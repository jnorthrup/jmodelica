/*
    Copyright (C) 2009 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package org.jmodelica.generated.scanners;

import java.util.*;
import java.io.StringReader;
import java.io.IOException;
import org.jmodelica.ide.helpers.ModelicaAnchorList;
import org.jmodelica.ide.indent.Indent;


/**
 * Scanner which pushes indentation anchors, used to indent the 
 * source code. 
 *
 * @author philip
 */

%%

%public
%final
%class IndentationHintScanner
%unicode
%apiprivate
%type void
%char

%{
    public IndentationHintScanner() {
        this(new StringReader(""));
    }
    
    public ModelicaAnchorList analyze(String text) {
		
		yyreset(new StringReader(text));
		
		ancs = new ModelicaAnchorList();
	
		annotation_paren_level = 0;
		last_state = YYINITIAL;
		
		try {
			yylex();
		} catch (IOException e) { }
		
		return ancs;
	}
	
	/* scanner state variables */
	public ModelicaAnchorList ancs;
	int annotation_paren_level;	
	int last_state;
	
%}



IDCHAR = [a-zA-Z_]
DIGIT = [0-9]
Q_CHAR = [^\'\\]
S_ESCAPE = "\\\'" | "\\\"" | "\\?" | "\\\\" | "\\a" | "\\b" | "\\f" | "\\n" | "\\r" | "\\t" | "\\v"

NewLine = \r|\n|\r\n
NonNewLineWhiteSpace = [ \t\f]
WhiteSpace = ({NewLine} | {NonNewLineWhiteSpace})+
            
NormalId = {IDCHAR} ({DIGIT}|{IDCHAR})*
Id = {NormalId} | {QIdent}
QIdent = "\'"  {QIdentCont}*  "\'"

Class = "block" | "when" | "class" | "connector" | "function" | "model" | "package" | "record" | "type" | "for" 
ClassPrefix = "encapsulated" | "partial" | "replaceable"
ClassDef = ({ClassPrefix} {WhiteSpace}+)* {Class}
ClassOneLine = {ClassDef} {WhiteSpace}* {Id} {WhiteSpace}* "="
 
Heading = ("initial" {WhiteSpace}+)? ("equation" | "algorithm" | "public" | "protected")

End = "end"

QIdentCont = {Q_CHAR} | {S_ESCAPE}

Other = . | {NewLine}


%state LINEBEGIN, END
%xstate COMMENT, COMMENT_LINEBEGIN, STRING, QIDENT, ANNOTATION, ANNOTATION_LINEBEGIN, CLASS 

%%

  <<EOF>> 			{ return; }
  "/*"  			{ ancs.beginSection(yychar + 2, yychar, Indent.COMMENT, "comment");
  				      last_state = yystate(); 
  				      yybegin(COMMENT_LINEBEGIN); 
  				    }
  "\""				{ ancs.beginSection(yychar + 1, yychar, Indent.UNCHANGED, "string");     
  					  last_state = yystate(); 
  					  yybegin(STRING); 
  					}
  "\'"				{ ancs.beginSection(yychar + 1, yychar, Indent.UNCHANGED, "qident");
  					  yybegin(QIDENT); 
  					}
  "annotation"		{ ancs.beginSection(yychar + yylength(), yychar, Indent.INDENT, "annotation");
  					  yybegin(ANNOTATION); 
  					}
  "//" .* {NewLine}	{ }

<YYINITIAL> {
  ^.				{ yypushback(1); yybegin(LINEBEGIN); }
  {NewLine}			{ yybegin(LINEBEGIN); }
  {ClassOneLine}	{ ancs.addAnchor(yychar, yychar, Indent.SAME); }
  {ClassDef}		{ ancs.addAnchor(yychar, yychar, Indent.SAME); 
  					  ancs.beginSection(yychar + yylength(), yychar, Indent.INDENT, "class");
  					  yybegin(CLASS);
  					} 
  {Heading}			{ ancs.addSink(yychar, "class", Indent.SAME); }
  "end" {WhiteSpace}* "if" {  }
  {End}				{ ancs.addSink(yychar, "class", Indent.SAME);
  					  ancs.addAnchor(yychar + yylength(), yychar, Indent.INDENT);
  					  yybegin(END); 
  					}
  {NormalId}    	{  }
  ";"				{ ancs.completeStatement(yychar + 1); }
} 

<CLASS> {
	{WhiteSpace}* {NormalId} { yybegin(YYINITIAL);}
	{Other} 		   { yypushback(1); yybegin(YYINITIAL); }
}

<LINEBEGIN> {
  {ClassDef}		|
  {End}				|
  ";"				|
  {Heading}		    { yypushback(yylength()); yybegin(YYINITIAL); }
  {Id}			    { ancs.beginLine(yychar);
  					  yybegin(YYINITIAL); 
  					}
  {WhiteSpace}*		{ }
  
}

<ANNOTATION_LINEBEGIN> {
	{WhiteSpace}	{ }
	")"+			{ ancs.addSink(yychar, "paren", 
						new Indent.AnnotationParen(annotation_paren_level - yylength())); 
					  yypushback(yylength()	);
					  yybegin(ANNOTATION); }
	{Other}			{ yypushback(1); 
					  yybegin(ANNOTATION); }
}

<ANNOTATION> {
  "("				{ 
  				 	  annotation_paren_level++; 
  					  
  					  if(annotation_paren_level==1)
  				        ancs.beginSection(yychar, yychar, new Indent.AnnotationParen(1), "paren");
  				      else 
  				        ancs.annotationParen(yychar, annotation_paren_level); 
  					}
  ")" 				{ 
  					  annotation_paren_level--;
  					  ancs.annotationParen(yychar+1, annotation_paren_level);
  					  if (annotation_paren_level == 0) { 
	  					    ancs.popPast("paren", yychar+1);
  							ancs.popPast("annotation", yychar+1);
  							yybegin(YYINITIAL); 
  					  }
					} 
   "/*"  			{ ancs.beginSection(yychar+2, yychar, Indent.COMMENT, "comment");
					  last_state = yystate();
					  yybegin(COMMENT_LINEBEGIN); }
  "\""				{ ancs.beginSection(yychar+1, yychar, Indent.UNCHANGED, "string");
					  last_state = yystate();
					  yybegin(STRING); }
  {NewLine}			{ yybegin(ANNOTATION_LINEBEGIN); }
  {Other}			{ 	}
}


<END> {
  {WhiteSpace}		{  }
  {Id}			    {  }
  {Other}			{ ancs.popPast("class", yychar + yylength()); 
  					  yybegin(YYINITIAL); }
}

<STRING> {
  "\\\\"			{  }
  "\\\""			{  }
  "\""				{ ancs.popPast("string", yychar + yylength());
  					  yybegin(last_state); }
  {Other}			{ }
}

<QIDENT> {
  "\\\'" 			{  }
  "\'"				{ ancs.popPast("qident", yychar + yylength()); 
  					  yybegin(YYINITIAL); }
  {Other}			{ }
}

<COMMENT_LINEBEGIN> {
  {WhiteSpace} 		{ }
  "*/"				{ ancs.addSink(yychar, "comment", Indent.SAME); // match comment end delim to start delim if alone on line
  					  ancs.popPast("comment", yychar); 
  					  yybegin(last_state); }
  {Other}		    { ancs.addAnchor(yychar+1, yychar, Indent.SAME); 
  					  yybegin(COMMENT); }
}

<COMMENT> {
  "*/"				{ ancs.popPast("comment", yychar); 
  					  yybegin(last_state); }
  {NewLine}	     	{ yybegin(COMMENT_LINEBEGIN); }
  {Other}			{ }
}

/* fallthrough */
{Other}				{ yybegin(YYINITIAL); }