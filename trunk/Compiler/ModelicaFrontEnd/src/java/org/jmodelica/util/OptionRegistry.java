/*
    Copyright (C) 2010 Modelon AB

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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;


/**
 * OptionRegistry contains all options for the compiler. Options
 * can be created and retrieved based on type: String, Integer etc.
 * OptionRegistry also provides methods for handling paths
 * to Modelica libraries.
 */
public class OptionRegistry {
	
		private enum DefOpt {
			DIVIDE_BY_VARS_IN_TEARING  ("divide_by_vars_in_tearing", false, 
					"If this option is set to true (default is false), a less restrictive strategy is used for solving equations " +
					"in the tearing algorithm. Specifically, division by parameters and variables is permitted, by default no " +
					"such divisions are made during tearing."),
			ENABLE_TEARING   ("enable_tearing", false, 
					"If this option is set to true (default is false), tearing of equation systems is enabled."),
			CONV_FREE_DEP_PAR_TO_ALGS   ("convert_free_dependent_parameters_to_algebraics", true, 
					"If this option is set to true (default is true), free dependent parameters are" +
					"converted to algebraic variables."),
			GEN_DAE   ("generate_dae",            true, 
					"If this option is set to true (default is true), code for solving DAEs are generated."),
			GEN_DAE_JAC   ("generate_dae_jacobian",            false, 
					"If this option is set to true (default is false), code for computing DAE Jacobians are generated."),
			GEN_ODE_JAC   ("generate_ode_jacobian",            false,		
					"If this option is set to true (default is false), code for computing ODE Jacobians are generated."),
			GEN_ODE   ("generate_ode",            false, 
					"If this option is set to true (default is false), code for solving ODEs are generated. "),
			EXTRA_LIB   ("extra_lib_dirs",            "", 
					"The value of this option is appended to the value of the MODELICAPATH environment " +
					"variable for determining in what directories to search for libraries."),
			START_FIX   ("state_start_values_fixed",  false, 
					"This option enables the user to specify if initial equations should be " + 
					"generated automatically for differentiated variables even though the fixed " +
					"attribute is equal to fixed. Setting this option to true is, however, often " +
					"practical in optimization problems."),
			ELIM_ALIAS  ("eliminate_alias_variables", true, 
					"If this option is set to true (default), then alias variables are " +
                    "eliminated from the model."),
			HALT_WARN   ("halt_on_warning",           false, 
					"If this option is set to false (default) one or more compiler " +
                    "warnings will not stop compilation of the model."),
			XML_EQU     ("generate_xml_equations",    false, 
					"If this option is true, then model equations are generated in XML format. " + 
					"Default is false."),
			INDEX_RED   ("index_reduction",           true, // NB: this description used in a Python test 
					"If this option is true (default is true), index reduction is performed."),
			EQU_SORT    ("equation_sorting",          false, 
					"If this option is true (default is false), equations are sorted using the BLT algorithm."),
			XML_FMI_ME ("generate_fmi_me_xml",          false, 
					"If this option is true the model description part of the XML variables file " + 
					"will be FMI for model exchange compliant. Default is false. To generate an XML which will " + 
					"validate with FMI schema the option generate_xml_equations must also be false."),
			XML_FMI_CS ("generate_fmi_cs_xml",          false, 
						"If this option is true the model description part of the XML variables file " + 
						"will be FMI for co simulation compliant. Default is false. To generate an XML which will " + 
						"validate with FMI schema the option generate_xml_equations must also be false."),
			FMI_VER ("fmi_version",          1.0, 
						"If this option is true the model description part of the XML variables file " + 
						"will be FMI for co simulation compliant. Default is false. To generate an XML which will " + 
						"validate with FMI schema the option generate_xml_equations must also be false."),
			VAR_SCALE   ("enable_variable_scaling",   false, 
					"If this option is true (default is false), then the \"nominal\" attribute will " + 
					"be used to scale variables in the model."),
			MIN_T_TRANS ("normalize_minimum_time_problems", true, 
					"When this option is set to true (default is true) then minimum time " +
					"optimal control problems encoded in Optimica are converted to fixed " + 
					"interval problems by scaling of the derivative variables."),
			STRUCTURAL_DIAGNOSIS ("enable_structural_diagnosis", true, 
					"Enable this option to invoke the structural error diagnosis based on the matching algorithm."),
			ADD_INIT_EQ ("automatic_add_initial_equations", true, 
					"When this option is set to true (default is true), then additional initial " +
					"equations are added to the model based on a the result of a matching algorithm. " +
					"Initial equations are added for states that are not matched to an equation."), 
			COMPL_WARN ("compliance_as_warning", false, 
					"When this option is set to true (default is false), then compliance errors are treated " + 
					"as warnings instead. This can lead to the compiler or solver crashing. Use with caution!"),
			GEN_HTML_DIAG ("generate_html_diagnostics", false, 
					"When this option is set to true (default is false) model diagnostics is generated in HTML format. " +
			        "This includes the flattened model, connection sets, alias sets and BLT form."), 
			EXPORT_FUNCS ("export_functions", false, 
					"Export used Modelica functions to generated C code in a manner that is compatible with the " +
					"external C interface in the Modelica Language Specification (default is false)"),
			EXPORT_FUNCS_VBA ("export_functions_vba", false, 
					"Create VBA-compatible wrappers for exported functions (default is false). Requires export_functions"), 
			CHECK_PARAM_EVAL ("check_evaluation_of_parameter_binding_expressions", true, 
					"Check if parameter an attribute binding expressions should be possible to evaluate during compilation." +
					"Default is true."),
			STATE_INIT_EQ ("state_initial_equations", false, 
							"Neglect initial equations in the model and add initial equations, and parameters, for the states." +
							"Default is false."),
			INLINE_FUNCS ("inline_functions", false, 
					"Perform function inlining on model after flattening (default is false)");
						
			public String key;
			public String desc;
			public Object val;
			
			private DefOpt(String k, Object v, String d) {
				key = k;
				desc = d;
				val = v;
			}
			
			private DefOpt(String k, boolean v, String d) {
				this(k, new Boolean(v), d);
			}
			
			private DefOpt(String k, double v, String d) {
				this(k, new Double(v), d);
			}
			
			private DefOpt(String k, int v, String d) {
				this(k, new Integer(v), d);
			}
			
			public String toString() {
				return key;
			}
		}

		private HashMap<String,Option> optionsMap;
		
		public OptionRegistry() {
			optionsMap = new HashMap<String,Option>();
			for (DefOpt o : DefOpt.values())
				defaultOption(o);
		}

		public OptionRegistry(OptionRegistry registry) {
			this();
			copyAllOptions(registry);
		}
		
		public OptionRegistry(String filepath) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
			this();
			loadOptions(filepath);
		}
		
	 	protected void loadOptions(String filepath) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
			//logger.info("Loading options...");
			org.w3c.dom.Document doc = parseAndGetDOM(filepath);
			
			javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();
			javax.xml.xpath.XPath xpath = factory.newXPath();
				
			javax.xml.xpath.XPathExpression expr;
				
			//set other options if there are any
			expr = xpath.compile("OptionsRegistry/Options");
			org.w3c.dom.Node options = (org.w3c.dom.Node)expr.evaluate(doc, javax.xml.xpath.XPathConstants.NODE);
			if(options !=null && options.hasChildNodes()) {				
				expr = xpath.compile("OptionsRegistry/Options/Option");
				org.w3c.dom.NodeList theOptions = (org.w3c.dom.NodeList)expr.evaluate(doc, javax.xml.xpath.XPathConstants.NODESET);
				expr = xpath.compile("OptionsRegistry/Options/Option/*");
				org.w3c.dom.NodeList theAttributes = (org.w3c.dom.NodeList)expr.evaluate(doc, javax.xml.xpath.XPathConstants.NODESET);
				
				for(int i=0; i<theOptions.getLength();i++) {
					org.w3c.dom.Node n = theOptions.item(i);
					org.w3c.dom.NamedNodeMap attributes = n.getAttributes();					
					String type = attributes.getNamedItem("type").getTextContent();
					
					org.w3c.dom.Node a = theAttributes.item(i);
					attributes = a.getAttributes();
					String key = attributes.getNamedItem("key").getTextContent();
					String value = attributes.getNamedItem("value").getTextContent();
					
					if(type.equals("string")) {
						setStringOption(key, value);
					} else if(type.equals("integer")) {
						setIntegerOption(key, Integer.parseInt(value));
					} else if(type.equals("real")) {
						setRealOption(key, Double.parseDouble(value));
					} else if(type.equals("boolean")) {
						setBooleanOption(key, Boolean.parseBoolean(value));
					}
				}				
			}	
	 	}
	 		 	
		/**
		 * Parses an XML file and returns the DOM document instance.
		 * 
		 * @param xmlfile
		 *            The XML file to be parsed.
		 * 
		 * @return The DOM document object.
		 * 
		 * @throws ParserConfigurationException
		 *             If a parser configuration error has occured.
		 * @throws IOException
		 *             If an IO error occurs.
		 * @throws SAXException
		 *             If an error with the parsing occurs.
		 */
		private org.w3c.dom.Document parseAndGetDOM(String xmlfile) 
			throws javax.xml.parsers.ParserConfigurationException, IOException, org.xml.sax.SAXException{
			javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			factory.setIgnoringElementContentWhitespace(true);
			factory.setNamespaceAware(true);
			javax.xml.parsers.DocumentBuilder builder = factory.newDocumentBuilder();		
			org.w3c.dom.Document doc = builder.parse(new File(xmlfile));
			return doc;
		}
		
		private static final String INDENT = "    ";
		
		/**
		 * \brief Replace tabs with INDENT.
		 */
		protected static String indent(String str) {
			return str.replace("\t", INDENT);
		}
		
		/**
		 * \brief Export all options as XML.
		 * 
		 * @param out  the stream to write to
		 */
		public void exportXML(PrintStream out) {
			out.print(indent("<OptionsRegistry>\n\t<Options>\n"));
			for (Option o : optionsMap.values())
				o.exportXML(out);
			out.print(indent("\t</Options>\n</OptionsRegistry>\n"));
		}
		
		/**
		 * \brief Export all options as an XML file.
		 * 
		 * @param name  the name of the file to write to
		 * @throws FileNotFoundException  if the file cannot be opened
		 */
		public void exportXML(String name) throws FileNotFoundException {
			FileOutputStream out = new FileOutputStream(name);
			exportXML(new PrintStream(out));
			try {
				out.close();
			} catch (IOException e) {
			}
		}
		
		/**
		 * \brief Main method. Exports default options to XML.
		 * 
		 * If given an argument, XML is saved in file with that path.
		 */
		public static void main(String[] args) {
			try {
				OptionRegistry or = new OptionRegistry();
				if (args.length < 1) 
					or.exportXML(System.out);
				else 
					or.exportXML(args[0]);
			} catch (FileNotFoundException e) {
				System.err.println("Could not open file for writing: " + e.getMessage());
			}
		}
		
		protected void defaultOption(DefOpt o) {
			if (o.val instanceof Integer)
				createIntegerOption(o.key, o.desc, ((Integer) o.val).intValue());
			else if (o.val instanceof String)
				createStringOption(o.key, o.desc, (String) o.val);
			else if (o.val instanceof Double)
				createRealOption(o.key, o.desc, ((Double) o.val).doubleValue());
			else if (o.val instanceof Boolean)
				createBooleanOption(o.key, o.desc, ((Boolean) o.val).booleanValue());
		}
		
		protected void createIntegerOption(String key, String description, int defaultValue) {
			optionsMap.put(key, new IntegerOption(key, description, defaultValue));			
		}
		
		public void addIntegerOption(String key, int value, String description) {
			setIntegerOption(key, value, description, true);
		}
		
		public void addIntegerOption(String key, int value) {
			setIntegerOption(key, value, "", true);
		}
		
		public void setIntegerOption(String key, int value) {
			setIntegerOption(key, value, "", false);
		}
		
		protected void setIntegerOption(String key, int value, String description, boolean add) {
			IntegerOption opt = findIntegerOption(key, add);
			if (opt == null)
				createIntegerOption(key, description, value);
			else
				opt.setValue(value);
		}

		public int getIntegerOption(String key) {
			return findIntegerOption(key, false).getValue();
		}
		
		protected IntegerOption findIntegerOption(String key, boolean allowMissing) {
			Option o = optionsMap.get(key);
			if (o instanceof IntegerOption)
				return (IntegerOption) o;
			if (o != null)
				throw new UnknownOptionException("Option: " + key + " is not of " +
						"integer type");
			if (allowMissing)
				return null;
			throw new UnknownOptionException("Unknown option: " + key);
		}
		
		protected void createStringOption(String key, String description, String defaultValue) {
			optionsMap.put(key, new StringOption(key, description, defaultValue));			
		}
		
		public void addStringOption(String key, String value, String description) {
			setStringOption(key, value, description, true);
		}
		
		public void addStringOption(String key, String value) {
			setStringOption(key, value, "", true);
		}
		
		public void setStringOption(String key, String value) {
			setStringOption(key, value, "", false);
		}
		
		protected void setStringOption(String key, String value, String description, boolean add) {
			StringOption opt = findStringOption(key, add);
			if (opt == null)
				createStringOption(key, description, value);
			else
				opt.setValue(value);
		}

		public String getStringOption(String key) {
			return findStringOption(key, false).getValue();
		}
		
		protected StringOption findStringOption(String key, boolean allowMissing) {
			Option o = optionsMap.get(key);
			if (o instanceof StringOption)
				return (StringOption) o;
			if (o != null)
				throw new UnknownOptionException("Option: " + key + " is not of " +
						"string type");
			if (allowMissing)
				return null;
			throw new UnknownOptionException("Unknown option: " + key);
		}
		
		protected void createRealOption(String key, String description, double defaultValue) {
			optionsMap.put(key, new RealOption(key, description, defaultValue));			
		}
		
		public void addRealOption(String key, double value, String description) {
			setRealOption(key, value, description, true);
		}
		
		public void addRealOption(String key, double value) {
			setRealOption(key, value, "", true);
		}
		
		public void setRealOption(String key, double value) {
			setRealOption(key, value, "", false);
		}
		
		protected void setRealOption(String key, double value, String description, boolean add) {
			RealOption opt = findRealOption(key, add);
			if (opt == null)
				createRealOption(key, description, value);
			else
				opt.setValue(value);
		}

		public double getRealOption(String key) {
			return findRealOption(key, false).getValue();
		}
		
		protected RealOption findRealOption(String key, boolean allowMissing) {
			Option o = optionsMap.get(key);
			if (o instanceof RealOption)
				return (RealOption) o;
			if (o != null)
				throw new UnknownOptionException("Option: " + key + " is not of " +
						"real type");
			if (allowMissing)
				return null;
			throw new UnknownOptionException("Unknown option: " + key);
		}
		
		protected void createBooleanOption(String key, String description, boolean defaultValue) {
			optionsMap.put(key, new BooleanOption(key, description, defaultValue));			
		}
		
		public void addBooleanOption(String key, boolean value, String description) {
			setBooleanOption(key, value, description, true);
		}
		
		public void addBooleanOption(String key, boolean value) {
			setBooleanOption(key, value, "", true);
		}
		
		public void setBooleanOption(String key, boolean value) {
			setBooleanOption(key, value, "", false);
		}
		
		protected void setBooleanOption(String key, boolean value, String description, boolean add) {
			BooleanOption opt = findBooleanOption(key, add);
			if (opt == null)
				createBooleanOption(key, description, value);
			else
				opt.setValue(value);
		}

		public boolean getBooleanOption(String key) {
			return findBooleanOption(key, false).getValue();
		}
		
		protected BooleanOption findBooleanOption(String key, boolean allowMissing) {
			Option o = optionsMap.get(key);
			if (o instanceof BooleanOption)
				return (BooleanOption) o;
			if (o != null)
				throw new UnknownOptionException("Option: " + key + " is not of " +
						"boolean type");
			if (allowMissing)
				return null;
			throw new UnknownOptionException("Unknown option: " + key);
		}
		
		public String getDescription(String key){
			Option o = optionsMap.get(key);
			if(o == null) {
				throw new UnknownOptionException("Unknown option: "+key);
			}
			return o.getDescription();
		}
		
		public Set<Map.Entry<String, Option>> getAllOptions() {
			return optionsMap.entrySet();
		}
		
		public void copyAllOptions(OptionRegistry registry) throws UnknownOptionException{
			// copy all options in parameter registry to this 
			// optionregistry and overwrite if exists before.
			Set<Map.Entry<String, Option>> set = registry.getAllOptions();
			Iterator<Map.Entry<String, Option>> itr = set.iterator();
			//iterate over all Map.entry
			while(itr.hasNext()) {
				Map.Entry<String, Option> entry = itr.next();
				String key = entry.getKey();
				Option o = entry.getValue();
				if(o instanceof StringOption) {
					addStringOption(key, ((StringOption) o).getValue());
				} else if(o instanceof IntegerOption) {
					addIntegerOption(key, ((IntegerOption) o).getValue());
				} else if(o instanceof RealOption) {
					addRealOption(key, ((RealOption) o).getValue());
				} else if(o instanceof BooleanOption) {
					addBooleanOption(key, ((BooleanOption) o).getValue());
				} else {
					throw new UnknownOptionException(
							"Trying to copy unknown option with key: "+key+
							" and description "+o.getDescription());
				}
			}			
		}

		/**
		 * \brief Make the first letter in a string capital.
		 */
		public static Object capitalize(String str) {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}

		public static String wrap(String str, String prefix, int width) {
			StringBuilder buf = new StringBuilder();
			int start = 0;
			int end = start + width;
			int len = str.length();
			while (end < len) {
				while (end > start && !Character.isWhitespace(str.charAt(end)))
					end--;
				buf.append(prefix);
				if (end <= start) {
					buf.append(str.substring(start, start + width - 1));
					start += width - 1;
					buf.append('-');
				} else {
					buf.append(str.substring(start, end));
					start = end + 1;
				}
				buf.append('\n');
				end = start + width;
			}
			buf.append(prefix);
			buf.append(str.substring(start));
			buf.append('\n');
			return buf.toString();
		}
	
	abstract static class Option {
		protected String key;
		protected String description;
			
		public Option(String key, String description) {
			this.key = key;
			this.description = description;
		}
	
		public void exportXML(PrintStream out) {
			String type = getType();
			String tag = capitalize(type) + "Attributes";
			String attrs = String.format("\t\t\t<%s key=\"%s\" value=\"%s\"", tag, key, getValueString());
			out.print(String.format(indent("\t\t<Option type=\"%s\">\n"), type));
			out.print(indent(attrs));
//			if (description == null || description.isEmpty()) {
			if (description == null || description.equals("")) {
				out.print("/>\n");
			} else {
				out.print(indent(">\n\t\t\t\t<Description>\n"));
				out.print(wrap(description, indent("\t\t\t\t\t"), 80));
				out.print(indent("\t\t\t\t</Description>\n\t\t\t</"));
				out.print(tag);
				out.print(">\n");
			}
			out.print(indent("\t\t</Option>\n"));
		}
		
		public abstract String getType();
		public abstract String getValueString();

		public String getKey() {
			return key;
		}

		public String getDescription() {
			return description;
		}
	
		public String toString() {
			return "\'"+key+"\': " + description; 
		}
		
	}
	
	static class IntegerOption extends Option {
		protected int value;
		
		public IntegerOption(String key, String description, int value) {
			super(key, description);
			this.value = value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}

		@Override
		public String getType() {
			return "integer";
		}

		@Override
		public String getValueString() {
			return Integer.toString(value);
		}
	}

	static class StringOption extends Option {
		protected String value;
		
		public StringOption(String key, String description, String value) {
			super(key,description);
			this.value = value;
		}
		
		public void setValue(String value) {
			this.value = value;
		}
		
		public String getValue() {
			return value;
		}

		@Override
		public String getType() {
			return "string";
		}

		@Override
		public String getValueString() {
			return value;
		}
	}

	static class RealOption extends Option {
		protected double value;
		
		public RealOption(String key, String description, double value) {
			super(key, description);
			this.value = value;
		}
		
		public void setValue(double value) {
			this.value = value;
		}
		
		public double getValue() {
			return value;
		}

		@Override
		public String getType() {
			return "real";
		}

		@Override
		public String getValueString() {
			return Double.toString(value);
		}
	}

	static class BooleanOption extends Option {
		protected boolean value;
		
		public BooleanOption(String key, String description, boolean value) {
			super(key, description);
			this.value = value;
		}
		
		public void setValue(boolean value) {
			this.value = value;
		}
		
		public boolean getValue() {
			return value;
		}

		@Override
		public String getType() {
			return "boolean";
		}
		
		@Override
		public String getValueString() {
			return Boolean.toString(value);
		}
	}
	
	public static class UnknownOptionException extends RuntimeException { 
		
		private static final long serialVersionUID = 3884972549318063140L;

		public UnknownOptionException(String message) {
			super(message);
		}		
	}
}
