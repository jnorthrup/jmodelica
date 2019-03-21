package org.jmodelica.modelica.compiler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import org.jmodelica.util.BinaryOperation;
import org.jmodelica.util.StringUtil;
import org.jmodelica.util.collections.ConstArrayIterator;
import org.jmodelica.util.collections.SingleIterator;
import org.jmodelica.util.values.ConstValue;
import org.jmodelica.util.values.Evaluable;
import org.jmodelica.util.values.ConstantEvaluationException;
import org.jmodelica.util.values.ConstantEvaluationNotReadyException;
import org.jmodelica.util.values.FunctionEvaluationException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Timer;
import java.util.TimerTask;
import org.jmodelica.common.evaluation.ExternalFunction;
import org.jmodelica.common.evaluation.ExternalProcessCache;
import org.jmodelica.common.evaluation.ExternalProcessCacheImpl;
import org.jmodelica.common.evaluation.ExternalProcessMultiCache;
import org.jmodelica.common.evaluation.ProcessCommunicator;
import org.jmodelica.common.ast.prefixes.EquationType;
import org.jmodelica.common.ast.prefixes.TypePrefixInputOutput;
import org.jmodelica.common.ast.prefixes.VisibilityType;
import org.jmodelica.util.Precedence;
import java.util.LinkedHashSet;
import java.util.EnumMap;
import java.io.File;
import java.math.BigInteger;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.DigestOutputStream;
import java.security.NoSuchAlgorithmException;
import org.jmodelica.common.GUIDManager;
import org.jmodelica.util.streams.StreamGobbler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jmodelica.util.logging.StreamingLogger;
import org.jmodelica.util.logging.Level;
import org.jmodelica.util.AbstractModelicaScanner;
import beaver.Symbol;
import java.io.ByteArrayOutputStream;
import org.jmodelica.util.streams.CodeStream;
import org.jmodelica.util.streams.NotNullCodeStream;
import java.util.TreeSet;
import org.jmodelica.util.collections.ParallelIterable;
import org.jmodelica.util.ErrorCheckType;
import org.jmodelica.util.problemHandling.SimpleProblemProducer;
import org.jmodelica.util.problemHandling.SimpleWarningProducer;
import org.jmodelica.util.problemHandling.SimpleErrorProducer;
import org.jmodelica.util.problemHandling.ComplianceFMUOnlyProducer;
import org.jmodelica.common.URIResolver;
import org.jmodelica.common.URIResolver.URIException;
import java.util.LinkedList;
import org.jmodelica.util.collections.ListMap;
import org.jmodelica.util.collections.LinkedHashListMap;
import org.jmodelica.api.problemHandling.Problem;
import org.jmodelica.api.problemHandling.ProblemSeverity;
import org.jmodelica.api.problemHandling.ProblemKind;
import org.jmodelica.util.problemHandling.ReporterNode;
import org.jmodelica.util.problemHandling.ProblemOptionsProvider;
import org.jmodelica.util.Criteria;
import org.jmodelica.util.problemHandling.ErrorProducerUnlessDisabled;
import org.jmodelica.util.problemHandling.AbstractErrorProducerUnlessDisabled;
import org.jmodelica.util.collections.ReverseListIterable;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import org.jmodelica.util.Enumerator;
import org.jmodelica.util.collections.GrowableSetIterable;
import java.util.Stack;
import org.jmodelica.util.collections.FilteredIterator;
import org.jmodelica.util.collections.FilteredIterable;
import java.util.SortedSet;
import java.util.Comparator;
import org.jmodelica.common.options.OptionRegistry;
import org.jmodelica.util.problemHandling.ProblemProducer;
import org.jmodelica.util.AdjustableSymbol;
import org.jmodelica.util.QualifiedName;
import org.jmodelica.util.collections.SubClassIterator;
import org.jmodelica.util.collections.SingleIterable;
import org.jmodelica.util.collections.ChainedIterable;
import org.jmodelica.util.collections.NestledIterator;
import org.jmodelica.util.collections.NestledIterable;
import org.jmodelica.util.collections.SubClassIterable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import org.jmodelica.util.collections.ChainedIterator;
import org.jmodelica.util.annotations.AnnotationProvider;
import org.jmodelica.util.annotations.AnnotationProvider.SubNodePair;
import org.jmodelica.util.annotations.FailedToSetAnnotationValueException;
import org.jmodelica.util.annotations.GenericAnnotationNode;
import org.jmodelica.util.annotations.IterableAnnotationProvider;
import org.jmodelica.util.collections.TransformerIterable;
import org.jmodelica.util.values.Evaluator;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.net.URI;
import java.net.URISyntaxException;
import org.jmodelica.util.formatting.FormattingRecorder;
import org.jmodelica.util.formatting.DefaultFormattingRecorder;
import org.jmodelica.common.ResourceLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedExceptionAction;
import java.util.IdentityHashMap;
import org.jmodelica.util.streams.NullStream;
import org.jmodelica.util.problemHandling.SanityProblemProducer;
import java.util.EnumSet;
import org.jmodelica.util.munkres.DenseMunkresProblem;
import org.jmodelica.util.munkres.IntegerCost;
import java.util.BitSet;
import org.jmodelica.util.exceptions.BLTException;
import java.util.ListIterator;
import java.util.TreeMap;
import java.util.Random;
import org.jmodelica.util.collections.HashStack;
import org.jmodelica.util.tarjan.Tarjan;
import org.jmodelica.util.tarjan.SimpleTarjan;
import org.jmodelica.util.tarjan.TarjanComponent;
import org.jmodelica.util.exceptions.MunkresException;
import org.jmodelica.util.exceptions.IndexReductionException;
import org.jmodelica.util.munkres.SparseMunkresProblem;
import org.jmodelica.util.munkres.MunkresProblem;
import org.jmodelica.util.munkres.MunkresCost;
import org.jmodelica.util.Solvability;
import java.io.*;
import java.lang.reflect.Constructor;
import org.jmodelica.util.XMLUtil;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import org.jmodelica.util.collections.ListUtil;
import java.io.FileReader;
import org.jmodelica.util.test.GenericTestCase;
import org.jmodelica.util.test.Assert;
import org.jmodelica.util.CompiledUnit;
import org.jmodelica.util.logging.units.LoggingUnit;
import org.jmodelica.util.test.GenericTestSuite;
import org.jmodelica.util.test.TestTree;
import org.jmodelica.common.options.TestOptions;
import org.jmodelica.util.AbstractFlatModelicaScanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jmodelica.util.streams.CStringCodeStream;
import org.jmodelica.common.ccodegen.CFuncParamDirection;
import org.jmodelica.util.exceptions.CompilerException;
import java.util.Deque;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.InterruptedException;
import java.lang.StringBuilder;
import java.nio.channels.FileChannel;
import java.util.Hashtable;
import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import org.jmodelica.util.logging.ModelicaLogger;
import org.jmodelica.util.logging.MemoryLogger;
import org.jmodelica.common.options.OptionRegistry.UnknownOptionException;
import org.jmodelica.util.Arguments;
import org.jmodelica.util.SymbolValueFixer;
import org.jmodelica.util.EnvironmentUtils;
import org.jmodelica.util.exceptions.ModelicaException;
import org.jmodelica.util.exceptions.InternalCompilerError;
import org.jmodelica.util.MemorySpider;
import org.jmodelica.util.exceptions.IllegalCompilerArgumentException;
import org.jmodelica.util.exceptions.ModelicaClassNotFoundException;
import org.jmodelica.util.exceptions.JModelicaHomeNotFoundException;
import org.jmodelica.util.exceptions.PackingFailedException;
import org.jmodelica.util.exceptions.CcodeCompilationException;
import org.jmodelica.util.PassAndForget;
import org.jmodelica.util.logging.IllegalLogStringException;
import org.jmodelica.util.streams.*;
import org.jmodelica.util.files.*;
import org.jmodelica.util.ccompiler.CCompilerArguments;
import org.jmodelica.util.ccompiler.CCompilerDelegator;
import org.jmodelica.util.ccompiler.CCompilerDelegator.Creator;
import org.jmodelica.util.ccompiler.CCompilerTarget;
import org.jmodelica.util.ccompiler.GccCompilerDelegator;
import org.jmodelica.common.LogContainer;
import org.jmodelica.modelica.compiler.generated.OptionsAggregated;
import org.xml.sax.SAXException;
import ifcasadi.ifcasadi;
import ifcasadi.GenericType;
import ifcasadi.MX;
import ifcasadi.MXFunction;
import ifcasadi.MXVector;
/**
 * @ast class
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\codegen\\XMLGenerator.jrag:47
 */
public class XMLGenerator extends GenericXMLGenerator {
    protected  void genStartAndFixedAttribute_XML(FVariable var, CodeStream str) {
        FExp e_start = null;
        Boolean isFixed;
        
        if (var.fixedAttributeSet()) {
            isFixed = var.fixedAttributeExp().ceval().booleanValue();
        } else {
            isFixed = false; //The default value.
        }
        
        if (!isFixed) {
            boolean startGenerated = false;
            if (var.useBindingExpAsStart()) 
                e_start = var.getBindingExp();
            else if (var.startAttributeSet() && !var.isDependentParameter())
                e_start = var.startAttributeExp();
            else if (var.isInput())
                e_start = var.createStartAttributeExp();
            
            if (!var.myOptions().getBooleanOption("generate_xml_equations") && e_start != null && !e_start.isConstantExp())
                e_start = null;
            if (e_start != null) {
                generateAttribute("start", var.type().convert(e_start.ceval()).xmlValue(), str);
                startGenerated = true;
            }
            
            if (startGenerated && !var.fixedAttribute()) {
                //Start is generated and fixed equals false => generate this.
                generateAttribute("fixed", "false", str);
            }
        }
    }

    protected  void addLinearInfo(CodeStream genPrinter, FVariable variable){
        //isLinear
        generateOneLineTag("isLinear", variable.isLinear(), genPrinter);
    }

    public  void addRealAttributes(CodeStream str, FRealVariable var) {
        // quantity
        if(var.quantityAttributeSet()) {
            generateAttribute("quantity", var.quantity_XML(), str);
        }
        // unit
        if(var.unitAttributeSet()) {
            generateAttribute("unit", var.unit_XML(), str);
        }
        // default display unit
        if(var.displayUnitAttributeSet()) {
            generateAttribute("displayUnit", var.displayUnit_XML(), str);
        }
        // relativeQuantity
        generateAttribute("relativeQuantity", "false", str);
        
        // min
        if(var.minAttributeSet()) {
            generateAttribute("min", var.minAttribute(), str);
        }
        // max
        if(var.maxAttributeSet()) {
            generateAttribute("max", var.maxAttribute(), str);
        }
        // nominal
        if(var.nominalAttributeSet()) {
            generateAttribute("nominal", var.nominalAttribute(), str);
        }
        // start and fixed
        genStartAndFixedAttribute_XML(var, str);
    }

    protected  void addIntegerAttributes(CodeStream str, FIntegerVariable var) {
        // quantity
        if(var.quantityAttributeSet()) {
            generateAttribute("quantity", var.quantity_XML(), str);
        }
        // min
        if(var.minAttributeSet()) {
            generateAttribute("min", var.minAttribute(), str);
        }
        // max
        if(var.maxAttributeSet()) {
            generateAttribute("max", var.maxAttribute(), str);
        }
        // start and fixed
        genStartAndFixedAttribute_XML(var, str);
    }

    protected  void addEnumAttributes(CodeStream str, FEnumVariable var) {
        // declaredType
        generateAttribute("declaredType", var.myFEnumDecl().name(), str);
        
        //quantity
        if(var.quantityAttributeSet()) {
            generateAttribute("quantity", var.quantity_XML(), str);
        }
        // min
        if(var.minAttributeSet()) {
            generateAttribute("min", var.minAttribute(), str);
        }
        // max
        if(var.maxAttributeSet()) {
            generateAttribute("max", var.maxAttribute(), str);
        }
        // start and fixed
        genStartAndFixedAttribute_XML(var, str);
	}

    protected  void addBooleanAttributes(CodeStream str, FBooleanVariable var) {
        //start and fixed attribute
        genStartAndFixedAttribute_XML(var, str);
    }

    protected  void addStringAttributes(CodeStream str, FStringVariable var) {
        //start and fixed attribute
        genStartAndFixedAttribute_XML(var, str);
    }

    protected  String root() {
    	return null;
    }

    public static final  Creator CREATOR = new Creator()
    {
        public XMLGenerator create(Printer expPrinter, char escapeCharacter, FClass fclass) {
            return new XMLGenerator(expPrinter, escapeCharacter, fclass);
        }
    };

    public  XMLGenerator(Printer expPrinter, char escapeCharacter,
			FClass fclass) {
		super(expPrinter,escapeCharacter, fclass);
	}

    public  class DAETag_XML_rootAttributes extends DAETag {

        public DAETag_XML_rootAttributes(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_rootAttributes", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            generateAttribute("fmiVersion", "1.0", genPrinter);
            generateAttribute("modelName", fclass.name(), genPrinter);
            generateAttribute("modelIdentifier", fclass.nameUnderscore(), genPrinter);
            generateAttribute("guid", fclass.guidManager().getGuidToken(), genPrinter);
            generateAttribute("generationTool", fclass.guidManager().getGenerationToolToken(), genPrinter);
            // Todays date for now
            generateAttribute("generationDateAndTime", fclass.guidManager().getDateToken(), genPrinter);
            generateAttribute("variableNamingConvention", "structured", genPrinter);
            generateAttribute("numberOfContinuousStates", fclass.numDifferentiatedRealVariables(), genPrinter);
            if (fclass.getDAEStructuredBLT() == null)
                // Only generating init DAE
                generateAttribute("numberOfEventIndicators", fclass.numEventIndicators() + fclass.numInitialEventIndicators(), genPrinter);
            else
                generateAttribute("numberOfEventIndicators", fclass.numEventIndicators(), genPrinter);
        }
    }

    public  class DAETag_XML_namespaces extends DAETag {

        public DAETag_XML_namespaces(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_namespaces", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            //XML standard namespace
            generateAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance", genPrinter);
            //extensions' namespaces definitions
            generateAttribute("xmlns:exp", "https://svn.jmodelica.org/trunk/XML/daeExpressions.xsd", genPrinter);
            generateAttribute("xmlns:equ", "https://svn.jmodelica.org/trunk/XML/daeEquations.xsd", genPrinter);
            generateAttribute("xmlns:fun", "https://svn.jmodelica.org/trunk/XML/daeFunctions.xsd", genPrinter);
            generateAttribute("xmlns:opt", "https://svn.jmodelica.org/trunk/XML/daeOptimization.xsd", genPrinter);
        }
    }

    public  class DAETag_XML_unitDefinitions extends DAETag {

        public DAETag_XML_unitDefinitions(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_unitDefinitions", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            // extract all units and beloning unit definitions
            Map<String, Set<String>> map = new LinkedHashMap<String, Set<String>>();
            for (FVariable var : fclass.allVariables()) {
                if (!var.isFRealVariable()) {
                    continue;
                }
                FRealVariable realVar = var.asFRealVariable();
                if(realVar.unitAttributeSet() && realVar.displayUnitAttributeSet()) {
                    String attribute = realVar.unitAttribute();
                    Set<String> defs = map.get(attribute);
                    if (defs == null) {
                        defs = new LinkedHashSet<String>();
                        map.put(attribute, defs);
                    }
                    defs.add(realVar.displayUnitAttribute());
                }
            }
            
            //generate code if any units defined
            if (!map.isEmpty()) {
                generateOpenTag("UnitDefinitions", genPrinter);
                for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
                    String unit = entry.getKey();
                    Set<String> defs = entry.getValue();
                    generateTagStart("BaseUnit", genPrinter);
                    generateAttribute("unit", unit, genPrinter);
                    generateOpenEnd(genPrinter);
                    for (String def : defs) {
                        generateTagStart("DisplayUnitDefinition", genPrinter);
                        generateAttribute("displayUnit", def, genPrinter);
                        generateAttribute("gain", "1", genPrinter);
                        generateAttribute("offset", "0", genPrinter);
                        generateClosedEnd(genPrinter);
                    }
                    generateClosing("BaseUnit", genPrinter);
                }
                generateClosing("UnitDefinitions", genPrinter);
            }
        }
    }

    public  class DAETag_XML_typeDefinitions extends DAETag {

        public DAETag_XML_typeDefinitions(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_typeDefinitions", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            if (fclass.getNumFEnumDecl() > 0) {
                generateOpenTag("TypeDefinitions", genPrinter);
                for (FEnumDecl enumdecl: fclass.getFEnumDecls()) {
                    //name
                    generateTagStart("Type", genPrinter);
                    generateAttribute("name", enumdecl.name(), genPrinter);
                    //description
                    if (enumdecl.hasFStringComment()) {
                        generateAttribute("description", enumdecl.getFStringComment().getComment(), genPrinter);
                    }
                    // close Type-element
                    generateOpenEnd(genPrinter);
                    
                    // Enumeration type
                    generateTagStart("EnumerationType", genPrinter);
                    // TODO: add support for quantity attribute on type
                    //min
                    generateAttribute("min", "1", genPrinter);
                    //max
                    generateAttribute("max", enumdecl.numEnumLiterals(), genPrinter);
                    generateOpenEnd(genPrinter);
                    
                    //Items
                    for (FEnumLiteral literal : enumdecl.enumLiterals()) {
                        generateTagStart("Item", genPrinter);
                        generateAttribute("name", literal.name(), genPrinter);
                        if (literal.hasFStringComment()) {
                            generateAttribute("description", literal.getFStringComment().getComment(), genPrinter);
                        }
                        generateClosedEnd(genPrinter);
                    }
                    generateClosing("EnumerationType", genPrinter);
                    generateClosing("Type", genPrinter);
                }
                generateClosing("TypeDefinitions", genPrinter);
            }
        }
    }

    public  class DAETag_XML_defaultExperiment extends DAETag {

        public DAETag_XML_defaultExperiment(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_defaultExperiment", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            FClass.Experiment e = fclass.experiment;
            if (e != null) {
                generateTagStart("DefaultExperiment", genPrinter);
                if (e.hasStart) {
                    generateAttribute("startTime", e.start, genPrinter);
                }
                if (e.hasStop) {
                    generateAttribute("stopTime", e.stop, genPrinter);
                }
                if (e.hasTolerance) {
                    generateAttribute("tolerance", e.tolerance, genPrinter);
                }
                generateClosedEnd(genPrinter);
            }
        }
    }

    public  class DAETag_XML_modelVariables extends DAETag {

        public DAETag_XML_modelVariables(AbstractGenerator myGenerator, FClass fclass) {
            super("XML_variables", myGenerator, fclass);
        }

        @Override
        public void generate(CodeStream genPrinter) {
            // get and sort all FVariables
            ArrayList<FVariable> variables = new ArrayList<FVariable>(fclass.allVariables());
            Collections.sort(variables, new VariableNameComparator());
            
            for (FVariable variable : variables) {	
                if (variable.generateXMLVariable()) {
                    generateTagStart("ScalarVariable", genPrinter);
                    generateAttribute("name", variable.name(), genPrinter);
                    generateAttribute("valueReference", variable.valueReference(), genPrinter);
                    if (variable.hasFStringComment()) {
                        generateAttribute("description", variable.getFStringComment().getComment(), genPrinter);
                    }
                    generateAttribute("variability", variable.variability_XML(), genPrinter);
                    generateAttribute("causality", variable.causality_XML(), genPrinter);
                    generateAttribute("alias", variable.alias_XML(), genPrinter);
                    generateOpenEnd(genPrinter);
                    
                    variable.genDecl_XML(XMLGenerator.this, genPrinter);
                    
                    //direct dependency - not supported
                    if (variable.isOutput()) {
                        generateOpenTag("DirectDependency", genPrinter);
                        for (FVariable dv : variable.dependsOn()) {
                            if (dv.isInput()) {
                                generateOneLineTag("Name", dv.name(), genPrinter);
                            }
                        }
                        generateClosing("DirectDependency", genPrinter);
                    }
                    
                    if (fclass.myOptions().getBooleanOption("generate_xml_equations")){
                        //qualified name
                        generateOpenTag("QualifiedName", genPrinter);
                        variable.getFAccess().prettyPrint_XML(genPrinter,"\t\t\t");
                        generateClosing("QualifiedName", genPrinter);
                    }
                    
                    if (!fclass.myOptions().getBooleanOption("generate_fmi_me_xml")) {
                        //is linear?
                        addLinearInfo(genPrinter, variable);
                        
                        //variable category
                        generateOneLineTag("VariableCategory", variable.category_XML(), genPrinter);
                    }
                    generateClosing("ScalarVariable", genPrinter);
                }
            }
        }
    }

    public  class DAETag_XML_bindingEquations extends DAETag {
		
		public DAETag_XML_bindingEquations(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_bindingEquations", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(CodeStream genPrinter) {
			Boolean generateEqu = fclass.myOptions().getBooleanOption("generate_xml_equations");
			if(generateEqu) {
				genPrinter.println("<equ:BindingEquations>");			
			
				for(FVariable variable:fclass.independentParameters()){
					if(variable.hasBindingExp()){
						FExp expression = variable.getBindingExp();
						genPrinter.println("\t\t<equ:BindingEquation>");
						genPrinter.print("\t\t\t<equ:Parameter>");
						variable.getFAccess().prettyPrint_XML(genPrinter,"\t\t\t");
						genPrinter.println("</equ:Parameter>");
						genPrinter.println("\t\t\t<equ:BindingExp>");
						expression.prettyPrint_XML(genPrinter,"\t\t\t\t");
						genPrinter.println("\t\t\t</equ:BindingExp>");
						genPrinter.println("\t\t</equ:BindingEquation>");
					}
				}
		
				for(FVariable variable:fclass.dependentParameters()){
					if(variable.hasBindingExp() || variable.hasParameterEquation()){
						FExp expression = null;
						if (variable.hasBindingExp()) {
							expression = variable.getBindingExp();
						} else {
							expression = ((FEquation)variable.parameterEquation()).getRight();
						}
				
						genPrinter.println("\t\t<equ:BindingEquation>");
						genPrinter.print("\t\t\t<equ:Parameter>");
						variable.getFAccess().prettyPrint_XML(genPrinter,"\t\t\t");
						genPrinter.println("</equ:Parameter>");
						genPrinter.println("\t\t\t<equ:BindingExp>");
						expression.prettyPrint_XML(genPrinter,"\t\t\t\t");
						genPrinter.println("\t\t\t</equ:BindingExp>");
						genPrinter.println("\t\t</equ:BindingEquation>");
					}
				}
			
				genPrinter.println("\t</equ:BindingEquations>");
			}
		}
	}

    public  class DAETag_XML_equations extends DAETag {
		
		public DAETag_XML_equations(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_Equations", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(CodeStream genPrinter) {
			Boolean generateEqu = fclass.myOptions().getBooleanOption("generate_xml_equations");
			if(generateEqu){
				genPrinter.println("<equ:DynamicEquations>");			
				for(FAbstractEquation e : fclass.equations())
					e.prettyPrint_XML(genPrinter,"\t\t");								
				genPrinter.println("\t</equ:DynamicEquations>");
			}
		}
	}

    public  class DAETag_XML_initialEquations extends DAETag {
		
		public DAETag_XML_initialEquations(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_initialEquations", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(CodeStream genPrinter) {
			Boolean generateEqu = fclass.myOptions().getBooleanOption("generate_xml_equations");
			if(generateEqu) {
				genPrinter.println("<equ:InitialEquations>");			
				for(FAbstractEquation e : fclass.initialEquations())
					e.prettyPrint_XML(genPrinter,"\t\t");								
				genPrinter.println("\t</equ:InitialEquations>");
			}
		}
	}

    public  class DAETag_XML_Optimization extends DAETag {
		
		public DAETag_XML_Optimization(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_Optimization", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(CodeStream genPrinter) {
			//do nothing
		}
		
		
	}

    public  class DAETag_XML_functions extends DAETag {
		
		public DAETag_XML_functions(AbstractGenerator myGenerator, FClass fclass) {
			super("XML_Functions", myGenerator, fclass);
		}
		
		/*
		 * (non-Javadoc)
		 * @see org.jmodelica.codegen.AbstractTag#generate(java.io.PrintStream)
		 */
		public void generate(CodeStream genPrinter) {
			Boolean generateEqu = fclass.myOptions().getBooleanOption("generate_xml_equations");
			if(generateEqu) {
				genPrinter.println("<fun:FunctionsList>");			
				for(FFunctionDecl f : fclass.getFFunctionDeclList())
					f.prettyPrint_XML(genPrinter,"\t\t");								
				genPrinter.println("\t</fun:FunctionsList>");
			}
		}
	}


}
