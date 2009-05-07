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

/** \file GenericGenerator.java
 *  \brief GenericGenerator class.
 */

package org.jmodelica.codegen;

import java.io.*;
import org.jmodelica.ast.*;

/**
 * A generator class containing a basic set of tags which
 * are not language dependent.
 * 
 * This class is also intended as base class for more specialized generators.
 *
 */
public class GenericGenerator extends AbstractGenerator {

	class DAETag_numIndependentConstants extends DAETag {
		
		public DAETag_numIndependentConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_ci","Number of independent constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentConstants());
		}
	
	}

	class DAETag_numDependentConstants extends DAETag {
		
		public DAETag_numDependentConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_cd","Number of dependent constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentConstants());
		}
	
	}

	class DAETag_numIndependentParameters extends DAETag {
		
		public DAETag_numIndependentParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_pi","Number of independent parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentParameters());
		}
	
	}

	class DAETag_numDependentParameters extends DAETag {
		
		public DAETag_numDependentParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_pd","Number of dependent parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentParameters());
		}
	
	}

	class DAETag_numIndependentRealConstants extends DAETag {
		
		public DAETag_numIndependentRealConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_ci","Number of independent real constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentRealConstants());
		}
	
	}

	class DAETag_numDependentRealConstants extends DAETag {
		
		public DAETag_numDependentRealConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_cd","Number of dependent real constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentRealConstants());
		}
	
	}

	class DAETag_numIndependentRealParameters extends DAETag {
		
		public DAETag_numIndependentRealParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_pi","Number of independent real parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentRealParameters());
		}
	
	}

	class DAETag_numDependentRealParameters extends DAETag {
		
		public DAETag_numDependentRealParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_pd","Number of dependent real parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentRealParameters());
		}
	
	}
	
	class DAETag_numIndependentIntegerConstants extends DAETag {
		
		public DAETag_numIndependentIntegerConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_ci","Number of independent integer constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentIntegerConstants());
		}
	
	}

	class DAETag_numDependentIntegerConstants extends DAETag {
		
		public DAETag_numDependentIntegerConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_cd","Number of dependent integer constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentIntegerConstants());
		}
	
	}

	class DAETag_numIndependentIntegerParameters extends DAETag {
		
		public DAETag_numIndependentIntegerParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_pi","Number of independent integer parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentIntegerParameters());
		}
	
	}

	class DAETag_numDependentIntegerParameters extends DAETag {
		
		public DAETag_numDependentIntegerParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_pd","Number of dependent integer parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentIntegerParameters());
		}
	
	}

	class DAETag_numIndependentBooleanConstants extends DAETag {
		
		public DAETag_numIndependentBooleanConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_ci","Number of independent boolean constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentBooleanConstants());
		}
	
	}

	class DAETag_numDependentBooleanConstants extends DAETag {
		
		public DAETag_numDependentBooleanConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_cd","Number of dependent boolean constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentBooleanConstants());
		}
	
	}

	class DAETag_numIndependentBooleanParameters extends DAETag {
		
		public DAETag_numIndependentBooleanParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_pi","Number of independent boolean parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentBooleanParameters());
		}
	
	}

	class DAETag_numDependentBooleanParameters extends DAETag {
		
		public DAETag_numDependentBooleanParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_pd","Number of dependent boolean parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentBooleanParameters());
		}
	
	}

	class DAETag_numIndependentStringConstants extends DAETag {
		
		public DAETag_numIndependentStringConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_ci","Number of independent string constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentStringConstants());
		}
	
	}

	class DAETag_numDependentStringConstants extends DAETag {
		
		public DAETag_numDependentStringConstants(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_cd","Number of dependent string constants",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentStringConstants());
		}
	
	}

	class DAETag_numIndependentStringParameters extends DAETag {
		
		public DAETag_numIndependentStringParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_pi","Number of independent string parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIndependentStringParameters());
		}
	
	}

	class DAETag_numDependentStringParameters extends DAETag {
		
		public DAETag_numDependentStringParameters(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_pd","Number of dependent string parameters",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDependentStringParameters());
		}
	
	}

	class DAETag_numAlgebraicVariables extends DAETag {
		
		public DAETag_numAlgebraicVariables(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_w","Number of algebraic variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicVariables());
		}
	
	}

	class DAETag_numAlgebraicRealVariables extends DAETag {
		
		public DAETag_numAlgebraicRealVariables(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_w","Number of algebraic real variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicRealVariables());
		}
	
	}

	class DAETag_numAlgebraicIntegerVariables extends DAETag {
		
		public DAETag_numAlgebraicIntegerVariables(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_w","Number of algebraic integer variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicIntegerVariables());
		}
	
	}

	class DAETag_numAlgebraicBooleanVariables extends DAETag {
		
		public DAETag_numAlgebraicBooleanVariables(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_w","Number of algebraic boolean variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicBooleanVariables());
		}
	
	}

	class DAETag_numAlgebraicStringVariables extends DAETag {
		
		public DAETag_numAlgebraicStringVariables(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_w","Number of algebraic string variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numAlgebraicStringVariables());
		}
	
	}
	
	class DAETag_numInputs extends DAETag {
		
		public DAETag_numInputs(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_u","Number of inputs",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numInputs());
		}
	
	}

	class DAETag_numRealInputs extends DAETag {
		
		public DAETag_numRealInputs(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_real_u","Number of real inputs",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numRealInputs());
		}
	
	}

	class DAETag_numIntegerInputs extends DAETag {
		
		public DAETag_numIntegerInputs(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_integer_u","Number of integer inputs",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numIntegerInputs());
		}
	
	}

	class DAETag_numBooleanInputs extends DAETag {
		
		public DAETag_numBooleanInputs(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_boolean_u","Number of boolean inputs",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numBooleanInputs());
		}
	
	}

	class DAETag_numStringInputs extends DAETag {
		
		public DAETag_numStringInputs(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_string_u","Number of string inputs",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numStringInputs());
		}
	
	}

	class DAETag_numEquations extends DAETag {
		
		public DAETag_numEquations(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_equations","Number of equations",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numEquations());
		}
	
	}

	class DAETag_numInitialEquations extends DAETag {
		
		public DAETag_numInitialEquations(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_initial_equations","Number of initial equations",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numInitialEquations());
		}
	
	}

	class DAETag_numInitialGuessEquations extends DAETag {
		
		public DAETag_numInitialGuessEquations(AbstractGenerator myGenerator, 
		  FClass fclass) {
			super("n_initial_guess_equations","Number of initial guess equations",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numInitialGuessEquations());
		}
	
	}

	class DAETag_numDifferentiatedRealVariables extends DAETag {
		
		public DAETag_numDifferentiatedRealVariables(
		  AbstractGenerator myGenerator, FClass fclass) {
			super("n_real_x","Number of differentiated Real variables",
			  myGenerator,fclass);
		}
	
		public void generate(PrintStream genPrinter) {
			genPrinter.print(fclass.numDifferentiatedRealVariables());
		}
	
	}

	/**
	 * Constructor.
	 * 
	 * @param expPrinter Printer object used to generate code for expressions.
	 * @param escapeCharacter Escape characters used to decode tags.
	 * @param fclass An FClass object used as a basis for the code generation.
	 */
	public GenericGenerator(Printer expPrinter, char escapeCharacter,
	  FClass fclass) {
		super(expPrinter,escapeCharacter);

		// Create tags			
		AbstractTag tag = null;
		
		tag = new DAETag_numIndependentConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentRealConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentIntegerConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentBooleanConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentStringConstants(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numDependentConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentRealConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentIntegerConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentBooleanConstants(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentStringConstants(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numIndependentParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentRealParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentIntegerParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentBooleanParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIndependentStringParameters(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numDependentParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentRealParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentIntegerParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentBooleanParameters(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numDependentStringParameters(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numAlgebraicVariables(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numAlgebraicRealVariables(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numAlgebraicIntegerVariables(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numAlgebraicBooleanVariables(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numAlgebraicStringVariables(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numInputs(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numRealInputs(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numIntegerInputs(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numBooleanInputs(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numStringInputs(this,fclass);
		tagMap.put(tag.getName(),tag);


		tag = new DAETag_numDifferentiatedRealVariables(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numEquations(this,fclass);
		tagMap.put(tag.getName(),tag);

		tag = new DAETag_numInitialEquations(this,fclass);
		tagMap.put(tag.getName(),tag);
		tag = new DAETag_numInitialGuessEquations(this,fclass);
		tagMap.put(tag.getName(),tag);
		
	}

}
