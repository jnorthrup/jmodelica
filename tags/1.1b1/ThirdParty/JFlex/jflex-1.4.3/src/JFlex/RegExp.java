/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * JFlex 1.4.3                                                             *
 * Copyright (C) 1998-2009  Gerwin Klein <lsf@jflex.de>                    *
 * All rights reserved.                                                    *
 *                                                                         *
 * This program is free software; you can redistribute it and/or modify    *
 * it under the terms of the GNU General Public License. See the file      *
 * COPYRIGHT for more information.                                         *
 *                                                                         *
 * This program is distributed in the hope that it will be useful,         *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of          *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the           *
 * GNU General Public License for more details.                            *
 *                                                                         *
 * You should have received a copy of the GNU General Public License along *
 * with this program; if not, write to the Free Software Foundation, Inc., *
 * 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA                 *
 *                                                                         *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package JFlex;

import java.util.Vector;

/**
 * Stores a regular expression of rules section in a JFlex-specification.
 *
 * This base class has no content other than its type. 
 *
 * @author Gerwin Klein
 * @version JFlex 1.4.3, $Revision: 433 $, $Date: 2009-01-31 19:52:34 +1100 (Sat, 31 Jan 2009) $
 */
public class RegExp {
  
  /**
   * The type of the regular expression. This field will be
   * filled with values from class sym.java (generated by cup)
   */
  int type;
  

  /**
   * Create a new regular expression of the specified type.
   *
   * @param type   a value from the cup generated class sym.
   *
   * @see JFlex.sym
   */
  public RegExp(int type) {
    this.type = type;    
  }

  

  /**
   * Returns a String-representation of this regular expression
   * with the specified indentation.
   *
   * @param tab   a String that should contain only space characters and
   *              that is inserted in front of standard String-representation
   *              pf this object.
   */
  public String print(String tab) {
    return tab+toString();
  }


  /**
   * Returns a String-representation of this regular expression
   */
  public String toString() {
    return "type = "+type;
  }


  /**
   * Find out if this regexp is a char class or equivalent to one.
   * 
   * @param  macros  for macro expansion
   * @return true if the regexp is equivalent to a char class.
   */
  public boolean isCharClass(Macros macros) {
    RegExp1 unary;
    RegExp2 binary;

    switch (type) {
    case sym.CHAR:
    case sym.CHAR_I:
    case sym.CCLASS:
    case sym.CCLASSNOT:
      return true;
      
    case sym.BAR: 
      binary = (RegExp2) this;
      return binary.r1.isCharClass(macros) && binary.r2.isCharClass(macros);
 
    case sym.MACROUSE:
      unary = (RegExp1) this;
      return macros.getDefinition((String) unary.content).isCharClass(macros);
     
    default: return false; 
    }     
  }
  
  /**
   * The approximate number of NFA states this expression will need (only 
   * works correctly after macro expansion and without negation)
   * 
   * @param macros  macro table for expansion   
   */
  public int size(Macros macros) {
    RegExp1 unary;
    RegExp2 binary;
    RegExp content;

    switch ( type ) {
    case sym.BAR: 
      binary = (RegExp2) this;
      return binary.r1.size(macros) + binary.r2.size(macros) + 2;

    case sym.CONCAT:   
      binary = (RegExp2) this;
      return binary.r1.size(macros) + binary.r2.size(macros);
      
    case sym.STAR:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return content.size(macros) + 2;

    case sym.PLUS:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return content.size(macros) + 2;
      
    case sym.QUESTION: 
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return content.size(macros);

    case sym.BANG:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return content.size(macros) * content.size(macros);
      // this is only a very rough estimate (worst case 2^n)
      // exact size too complicated (propably requires construction)
      
    case sym.TILDE:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return content.size(macros) * content.size(macros) * 3;
      // see sym.BANG
      
    case sym.STRING:
    case sym.STRING_I:
      unary = (RegExp1) this;
      return ((String) unary.content).length()+1;

    case sym.CHAR:
    case sym.CHAR_I:
      return 2;

    case sym.CCLASS:
    case sym.CCLASSNOT:
      return 2;

    case sym.MACROUSE:
      unary = (RegExp1) this;
      return macros.getDefinition((String) unary.content).size(macros);
    }

    throw new Error("unknown regexp type "+type);
  }
  
  /**
   * @return the reverse of the specified string.
   */
  public final static String revString(String s) {
    StringBuffer b = new StringBuffer(s.length());
    for (int i=s.length()-1; i >= 0; i--) {
      b.append(s.charAt(i));
    }
    return b.toString();
  }
  
  /**
   * Recursively convert tilde (upto) expressions into negation and star. 
   * 
   * @param macros  the macro table for expansion. 
   * @return new RegExp equivalent to the current one, but without upto expressions.
   */
  public final RegExp resolveTilde(Macros macros) {
    RegExp1 unary;
    RegExp2 binary;
    RegExp content;

    switch ( type ) {
    case sym.BAR: 
      binary = (RegExp2) this;
      return new RegExp2(sym.BAR, binary.r1.resolveTilde(macros), 
                                  binary.r2.resolveTilde(macros));

    case sym.CONCAT:   
      binary = (RegExp2) this;
      return new RegExp2(sym.CONCAT, binary.r1.resolveTilde(macros), 
                                     binary.r2.resolveTilde(macros));
      
    case sym.STAR:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.STAR, content.resolveTilde(macros));

    case sym.PLUS:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.PLUS, content.resolveTilde(macros));
      
    case sym.QUESTION: 
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.QUESTION, content.resolveTilde(macros));

    case sym.BANG:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.BANG, content.resolveTilde(macros));
      
    case sym.TILDE:
      // ~a = !([^]* a [^]*) a
      // uses subexpression sharing
      unary = (RegExp1) this;
      content = ((RegExp) unary.content).resolveTilde(macros);
      
      RegExp any_star = new RegExp1(sym.STAR, anyChar());
      RegExp neg = new RegExp1(sym.BANG, 
                       new RegExp2(sym.CONCAT, any_star, 
                           new RegExp2(sym.CONCAT, content, any_star)));
      
      return new RegExp2(sym.CONCAT, neg, content);
      
    case sym.STRING:
    case sym.STRING_I:    
    case sym.CHAR:
    case sym.CHAR_I:
    case sym.CCLASS:
    case sym.CCLASSNOT: 
      unary = (RegExp1) this;
      return new RegExp1(unary.type, unary.content);

    case sym.MACROUSE:
      unary = (RegExp1) this;      
      return macros.getDefinition((String) unary.content).resolveTilde(macros);
    }

    throw new Error("unknown regexp type "+type);
  }
  
  
  /**
   * Returns a regexp that matches any character: <code>[^]</code>
   * @return the regexp for <code>[^]</code>
   */
  public RegExp anyChar() {
    // FIXME: there is some code duplication here with the parser
    Vector list = new Vector();
    list.addElement(new Interval((char)0,CharClasses.maxChar));    
    return new RegExp1(sym.CCLASS,list);
  }


  /**
   * Create a new regexp that matches the reverse text of this one.
   * 
   * @return the reverse regexp
   */
  public final RegExp rev(Macros macros) {
    RegExp1 unary;
    RegExp2 binary;
    RegExp content;

    switch ( type ) {
    case sym.BAR: 
      binary = (RegExp2) this;
      return new RegExp2(sym.BAR, binary.r1.rev(macros), binary.r2.rev(macros));

    case sym.CONCAT:   
      binary = (RegExp2) this;
      return new RegExp2(sym.CONCAT, binary.r2.rev(macros), binary.r1.rev(macros));
      
    case sym.STAR:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.STAR, content.rev(macros));

    case sym.PLUS:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.PLUS, content.rev(macros));
      
    case sym.QUESTION: 
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.QUESTION, content.rev(macros));

    case sym.BANG:
      unary = (RegExp1) this;
      content = (RegExp) unary.content;      
      return new RegExp1(sym.BANG, content.rev(macros));
      
    case sym.TILDE:
      content = resolveTilde(macros);
      return content.rev(macros);
      
    case sym.STRING:
    case sym.STRING_I:    
      unary = (RegExp1) this;
      return new RegExp1(unary.type, revString((String) unary.content));
      
    case sym.CHAR:
    case sym.CHAR_I:
    case sym.CCLASS:
    case sym.CCLASSNOT: 
      unary = (RegExp1) this;
      return new RegExp1(unary.type, unary.content);

    case sym.MACROUSE:
      unary = (RegExp1) this;      
      return macros.getDefinition((String) unary.content).rev(macros);
    }

    throw new Error("unknown regexp type "+type);
  }
}
