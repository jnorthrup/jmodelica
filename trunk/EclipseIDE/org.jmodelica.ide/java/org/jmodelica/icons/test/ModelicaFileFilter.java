package org.jmodelica.icons.test;

import java.io.File;
import java.io.FileFilter;

public class ModelicaFileFilter implements FileFilter {
	
	// TODO: Finns s�kert m�nga fler.
	// TODO: Borde egentligen ha Bad Models i st�llet, s� att 
	//			resten av filen i alla fall g�r att l�sa in.
	private static String[] badFiles = {
		// Saknar coordinateSystem f�r diagramlagret. (package Constants)
		"../JModelica/ThirdParty/MSL/Modelica/Constants.mo",
		
		// Anv�nder DynamicSelect i en Color-deklaration: InitialStep
		"../JModelica/ThirdParty/MSL/Modelica/StateGraph.mo",
		
		// Anv�nder DynamicSelect i en Color-deklaration: partialBooleanSISO
		"../JModelica/ThirdParty/MSL/Modelica/Blocks/Interfaces.mo",

		// Anv�nder DynamicSelect i en Color-deklaration: BooleanExpression
		"../JModelica/ThirdParty/MSL/Modelica/Blocks/Sources.mo",
		
		// Saknar coordinateSystem:
		// Blocks.Examples.BusUsage_Utilities.Interfaces.InternalConnectors.StandardControlBus
		"../JModelica/ThirdParty/MSL/Modelica/Blocks/package.mo",
		
		// Saknar coordinateSystem: Digital.Examples.Utilities.RS
		"../JModelica/ThirdParty/MSL/Modelica/Electrical/Analog/Digital.mo"
	};

	//TODO m�ste g� att hitta den h�r n�nstans.
	private static final String MODELICA_FILE_ENDING = "mo";	
	
	private static boolean isBad(String fileName) {
		for (int i = 0; i < badFiles.length; i++) {
			if (badFiles[i].replace('/', '\\').equals(fileName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean accept(File f) {
		String ending = f.toString().substring(f.toString().lastIndexOf(".")+1);
		return ending.equals(MODELICA_FILE_ENDING) /*&& !isBad(f.toString())*/;
	}
}