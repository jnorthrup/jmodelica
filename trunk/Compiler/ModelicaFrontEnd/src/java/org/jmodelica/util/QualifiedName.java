/*
    Copyright (C) 2018 Modelon AB

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
package org.jmodelica.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.jmodelica.modelica.parser.ModelicaParser.Terminals;
import org.jmodelica.modelica.parser.ModelicaScanner;
import org.jmodelica.util.exceptions.NameFormatException;

import beaver.Scanner.Exception;
import beaver.Symbol;

/**
 * Handle splitting strings into different parts of a qualified name.
 */
public class QualifiedName {
    private final boolean isGlobal;
    private final ArrayList<String> names = new ArrayList<>();
    private final boolean isUnQualifiedImport;
    private final Iterator<String> iterator;

    public QualifiedName(String name) {
        isUnQualifiedImport = name.endsWith(".*");
        isGlobal = name.startsWith(".");
        splitQualifiedClassName(name);
        iterator = names.iterator();
    }

    // Interpret name as global or not regardless of dot form or not.
    public QualifiedName(String name, boolean isGlobal) {
        isUnQualifiedImport = name.endsWith(".*");
        splitQualifiedClassName(name); 
        this.isGlobal = isGlobal; // Note: must be setter after splitting
        iterator = names.iterator();
    }

    public int numberOfParts() {
        return names.size();
    }
    
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    public String next() {
        return iterator.next();
    }

    /**
     * Checks if the name is a valid and simple (unqualified) identifier.
     * @param name The name.
     * @param allowGlobal If <code>true</code>, then takes 'global' notation with a leading dot into account by 
     * ignoring such a character. 
     * @return Whether or not <code>name</code> is a valid identifier. 
     */
    public static boolean isValidSimpleIdentifier(String name, boolean allowGlobal) {
        if (allowGlobal && name.startsWith(".")) {
            name = name.substring(1, name.length());
        }
        ModelicaScanner ms = new ModelicaScanner(new StringReader(name));
        try {
           if (ms.nextToken().getId() != Terminals.ID)
               return false;
           if (ms.nextToken().getId() != Terminals.EOF)
               return false;
           return true;
        } catch (IOException e) {
            // This shouldn't happen when using a StringReader.
            throw new RuntimeException("Unhandled internal error", e);
        } catch (Exception e) {
            // Scanner cannot handle this, so this is not a valid identifier.
            return false;
        }
    }

    @Override
    public String toString() {
        return (isGlobal ? "(global) " : "") + (isUnQualifiedImport ? ".* " : "") + names.toString();
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    /**
     * Splits a composite class name into all its partial accesses
     */
    private final void splitQualifiedClassName(String name) {
        if (name.length() == 0) {
            throw new NameFormatException("A name must have at least one caracter");
        }
        if (isGlobal || isUnQualifiedImport) {
            int start = isGlobal ? 1 : 0;
            int end = isUnQualifiedImport ? name.length() -2 : name.length(); 
            name = name.substring(start, end);
        }
        ModelicaScanner ms = new ModelicaScanner(new StringReader(name));
        try {
            Symbol sym = ms.nextToken();
            if (sym.getId() != Terminals.ID)
                throw new NameFormatException("The qualified name is not valid");
            names.add((String)sym.value);
            while ((sym = ms.nextToken()).getId() == Terminals.DOT) {
                sym = ms.nextToken();
                if (sym.getId() != Terminals.ID)
                    throw new NameFormatException("The qualified name is not valid");
                names.add((String)sym.value);
            }
            if (sym.getId() != Terminals.EOF)
                throw new NameFormatException("Invalid name: " + name);
        } catch (IOException e) {
            // This shouldn't happen when using a StringReader.
            throw new RuntimeException("Unhandled internal error", e);
        } catch (Exception e) {
            // Identifier not valid.
            throw new NameFormatException("Invalid name: " + name);
        }
    }
}
