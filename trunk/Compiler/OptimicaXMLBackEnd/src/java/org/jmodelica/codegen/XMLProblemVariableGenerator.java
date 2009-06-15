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

package org.jmodelica.codegen;

import java.io.PrintStream;

import org.jmodelica.ast.FClass;
import org.jmodelica.ast.FOptClass;
import org.jmodelica.ast.Printer;

/**
 * A generator class for XML code generation which takes a model described by
 * <FClass> and provides an XML document for the optimization problem meta data.
 * Uses a template for the static general structure of tags and an internal
 * class <TagGenerator> for the parts of the XML that are dynamic, that is, may
 * vary depending on the contents of the underlying model.
 * 
 * @see AbstractGenerator
 * @see TagGenerator
 * 
 */
public class XMLProblemVariableGenerator extends GenericGenerator{
	
	/**
	 * Internal class used to generate the optimization start time tag.
	 * 
	 * @see DAETag
	 */
	class DAETag_XML_startTime extends DAETag {
		public DAETag_XML_startTime(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_startTime","Interval start time (optional)", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(PrintStream genPrinter) {
			FOptClass optclass = (FOptClass) fclass;
			TagGenerator tg = new TagGenerator(2);
			genPrinter.print(tg.generateTag("Value")+ optclass.startTimeAttribute()+tg.generateTag("Value"));
			genPrinter.print(tg.generateTag("Free")+optclass.startTimeFreeAttribute()+tg.generateTag("Free"));
			genPrinter.print(tg.generateTag("InitialGuess")+optclass.startTimeInitialGuessAttribute()+tg.generateTag("InitialGuess"));
		}
	}
	
	/**
	 * Internal class used to generate the optimization final time tag.
	 * 
	 * @see DAETag
	 */
	class DAETag_XML_finalTime extends DAETag {
		public DAETag_XML_finalTime(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_finalTime", "Interval final time (optional)", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(PrintStream genPrinter) {
			FOptClass optclass = (FOptClass) fclass;
			TagGenerator tg = new TagGenerator(2);
			genPrinter.print(tg.generateTag("Value") + optclass.finalTimeAttribute() + tg.generateTag("Value"));
			genPrinter.print(tg.generateTag("Free") + optclass.finalTimeFreeAttribute() + tg.generateTag("Free"));
			genPrinter.print(tg.generateTag("InitialGuess") + optclass.finalTimeInitialGuessAttribute() + tg.generateTag("InitialGuess"));
		}
	}
	
	/**
	 * Internal class used to generate the optimization time point tags. The
	 * time points may vary from model to model. Therefore this class can
	 * generate several tags containing time point data.
	 * 
	 * @see DAETag
	 */
	class DAETag_XML_timePoints extends DAETag {
		public DAETag_XML_timePoints(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_timePoints", "Time points (optional)", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(PrintStream genPrinter) {
			FOptClass optclass = (FOptClass) fclass;
			TagGenerator tg = new TagGenerator(2);
			double[] points = optclass.timePoints();
			
			for(int i=0;i<points.length;i++) {
				genPrinter.print(tg.generateTag("Index")+optclass.timePointIndex(points[i])+tg.generateTag("Index"));
				genPrinter.print(tg.generateTag("Value")+points[i]+tg.generateTag("Value"));
			}
		}
	}
	
	/**
	 * Constructor.
	 * 
	 * @param expPrinter Printer object used to generate code for expressions.
	 * @param escapeCharacter Escape characters used to decode tags.
	 * @param fclass An FClass object used as a basis for the code generation.
	 */
	public XMLProblemVariableGenerator(Printer expPrinter,
			char escapeCharacter, FClass fclass) {
		super(expPrinter, escapeCharacter, fclass);
		
		// Create tags			
		AbstractTag tag = null;

		tag = new DAETag_XML_startTime(this,fclass);
		tagMap.put(tag.getName(), tag);
		tag = new DAETag_XML_finalTime(this,fclass);
		tagMap.put(tag.getName(), tag);
		tag = new DAETag_XML_timePoints(this,fclass);
		tagMap.put(tag.getName(), tag);


	}

}
