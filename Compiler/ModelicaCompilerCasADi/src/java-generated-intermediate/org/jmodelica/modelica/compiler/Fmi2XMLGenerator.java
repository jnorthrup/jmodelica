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
 * @aspect FmiXMLGenerator
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:1012
 */
public class Fmi2XMLGenerator extends FmiXMLGenerator {
    
	
    public static final Creator CREATOR = new Creator()
    {
        public Fmi2XMLGenerator create(Printer expPrinter, char escapeCharacter, FClass fclass) {
            return new Fmi2XMLGenerator(expPrinter, escapeCharacter, fclass);
        }
    };

    
    
	/**
	 * Constructor.
	 * 
	 * @param expPrinter Printer object used to generate code for expressions.
	 * @param escapeCharacter Escape characters used to decode tags.
	 * @param fclass An FClass object used as a basis for the code generation.
	 */
    public Fmi2XMLGenerator(Printer expPrinter, char escapeCharacter, FClass fclass) {
		super(expPrinter,escapeCharacter, fclass);
	}

    
	
	/**
	 * Gets the root-tag for FMI 2.0 XML-generation.
	 * 
	 * @see XMLTag
	 */
    protected String root() {
    	return "fmiModelDescription";
    }

    

	/**
	 * Internal class used to generate a fmiModelDescription tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_fmiModelDescription extends XMLTag {
		
		public XMLTag_fmiModelDescription(AbstractGenerator myGenerator, FClass fclass) {
			super("fmiModelDescription", "fmiModelDescription", myGenerator, fclass);
		}
		
		public String[] children() {
            return new String[] { "modelExchange",     "coSimulation",   "unitDefinitions",
                                  "typeDefinitions",   "logCategories",  "defaultExperiment",
                                  "vendorAnnotations", "modelVariables", "modelStructure"};
        }

        public void generateAttributes(CodeStream genPrinter) {
            generateAttribute("fmiVersion",               "2.0",                               genPrinter);
            generateAttribute("modelName",                fclass.name(),                       genPrinter);
            generateAttribute("guid",                     fclass.guidManager().getGuidToken(), genPrinter);
            generateAttribute("generationTool", fclass.guidManager().getGenerationToolToken(), genPrinter);
            generateAttribute("generationDateAndTime",    fclass.guidManager().getDateToken(), genPrinter);
            generateAttribute("variableNamingConvention", "structured",                        genPrinter);
            generateAttribute("numberOfEventIndicators",  numberOfEventIndicators(fclass),     genPrinter);
        }
	}

    
	

    /**
     * Internal class used to generate a ModelExchange tag.
     * 
     * @see XMLTag
     */
    public class XMLTag_modelExchange extends METag {

        public XMLTag_modelExchange(AbstractGenerator myGenerator, FClass fclass) {
            super("modelExchange", "ModelExchange", myGenerator, fclass);
        }

        @Override
        public String[] children() {
            return modelExchangeChildren.toArray(new String[modelExchangeChildren.size()]);
        }

        @Override
        public void generateAttributes(CodeStream genPrinter) {
            Boolean supportDirDer = fclass.supportDirDer();
            
            generateAttribute("modelIdentifier",                     fclass.nameUnderscore(), genPrinter);
            generateAttribute("needsExecutionTool",                  false,                   genPrinter);
            generateAttribute("completedIntegratorStepNotNeeded",    false,                   genPrinter);
            generateAttribute("canBeInstantiatedOnlyOncePerProcess", true,                    genPrinter);
            generateAttribute("canNotUseMemoryManagementFunctions",  false,                   genPrinter);
            generateAttribute("canGetAndSetFMUstate",                false,                   genPrinter);
            generateAttribute("canSerializeFMUstate",                false,                   genPrinter);
            generateAttribute("providesDirectionalDerivative",       supportDirDer,           genPrinter);
        }
    }

    

    private static java.util.List<String> modelExchangeChildren = new ArrayList<String>();

    

    /**
     * Adds extra children to the {@code &lt;ModelExchange$gt;} tag.
     *
     * @param childName
     *          The name of the child to add.
     */
    public static void addModelExchangeChild(String childName) {
        modelExchangeChildren.add(childName);
    }

    

    /**
     * Internal class used to generate a CoSimulation tag.
     * 
     * @see XMLTag
     */
    public class XMLTag_coSimulation extends CSTag {

        public XMLTag_coSimulation(AbstractGenerator myGenerator, FClass fclass) {
            super("coSimulation", "CoSimulation", myGenerator, fclass);
        }

        @Override
        public String[] children() {
            return coSimulationChildren.toArray(new String[coSimulationChildren.size()]);
        }

        public void generateAttributes(CodeStream genPrinter) {
            Boolean supportDirDer = fclass.supportDirDer();
            
            generateAttribute("modelIdentifier",                        fclass.nameUnderscore(), genPrinter);
            generateAttribute("needsExecutionTool",                     false,                   genPrinter);
            generateAttribute("canHandleVariableCommunicationStepSize", true,                    genPrinter);
            generateAttribute("canInterpolateInputs",                   true,                    genPrinter);
            generateAttribute("maxOutputDerivativeOrder",               0,                       genPrinter);
            generateAttribute("canRunAsynchronuously",                  false,                   genPrinter);
            generateAttribute("canBeInstantiatedOnlyOncePerProcess",    true,                    genPrinter);
            generateAttribute("canNotUseMemoryManagementFunctions",     false,                   genPrinter);
            generateAttribute("canSerializeFMUstate",                   false,                   genPrinter);
            generateAttribute("providesDirectionalDerivative",          supportDirDer,           genPrinter);
        }
    }

    

    private static java.util.List<String> coSimulationChildren = new ArrayList<String>();

    

    /**
     * Adds extra children to the {@code &lt;CoSimulation$gt;} tag.
     *
     * @param childName
     *          The name of the child to add.
     */
    public static void addCoSimulationChild(String childName) {
        coSimulationChildren.add(childName);
    }

    

	/**
	 * Internal class used to generate a UnitDefinitions tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_unitDefinitions extends XMLTag {
        protected String unit;
        protected Iterator<String> unitItr;
        protected HashMap<String,HashSet<String>> unitMap;
		
		public XMLTag_unitDefinitions(AbstractGenerator myGenerator, FClass fclass) {
			super("unitDefinitions", "UnitDefinitions", myGenerator, fclass);
            unitMap = extractUnits(fclass);
		}
		
		public String[] children() { return new String[] {"unit"}; }
		
		public void generate(CodeStream genPrinter) {
			//Generate code if any units are defined.
            Set<String> units = unitMap.keySet();
            if(!units.isEmpty()) {
                unitItr = units.iterator();
                super.generate(genPrinter);
            }
		}
		
		public void generateChildren(CodeStream genPrinter) {
            while(unitItr.hasNext()) {
                unit = unitItr.next();
				super.generateChildren(genPrinter);
			}
		}
		
        public class XMLTag_unit extends XMLTag {
            AbstractTag baseUnitTag;
            Unit baseUnit;
            private String def;

            public XMLTag_unit(AbstractGenerator myGenerator, FClass fclass) {
                super("unit", "Unit", myGenerator, fclass);
            }

            public String[] children() { return new String[] {"displayUnit"}; }

            public void generateAttributes(CodeStream genPrinter) {
                generateAttribute("name", unit, genPrinter);
            }

            public void generateChildren(CodeStream genPrinter) {
                baseUnitTag = getTag("baseUnit");
                // Get base unit information
                baseUnit = getBaseUnitInfo(unit);
                if (baseUnit != null) {
                    baseUnitTag.generateTag(genPrinter);
                }
                
                HashSet<String> defs = unitMap.get(unit);
                Iterator<String> defsItr = defs.iterator();
                while(defsItr.hasNext()) {
                    def = defsItr.next();
                    super.generateChildren(genPrinter);
                }
            }

            public class XMLTag_baseUnit extends XMLTag {
                
                public XMLTag_baseUnit(AbstractGenerator myGenerator, FClass fclass) {
                    super("baseUnit", "BaseUnit", myGenerator, fclass);
                }
                
                public void generateAttributes(CodeStream genPrinter) {
                    int[] SIDimensions = new int[]{Dimension.Length,
                                                   Dimension.Time,
                                                   Dimension.Mass,
                                                   Dimension.Temperature,
                                                   Dimension.Current,
                                                   Dimension.SubstanceAmount,
                                                   Dimension.LuminousIntensity
                                                   /*, Dimension.Angle*/};
                    String[] SIBaseUnits = new String[]{"m",
                                                        "s",
                                                        "kg",
                                                        "K",
                                                        "A",
                                                        "mol",
                                                        "cd"
                                                        /*, "rad"*/};
                    int[] powers = baseUnit.getDimensions();
                    
                    for (int i = 0; i < SIDimensions.length; i++) {
                        int dimension = SIDimensions[i];
                        if (powers[dimension] != 0) {
                            generateAttribute(SIBaseUnits[i], powers[dimension], genPrinter);
                        }
                    }
                    double factor = baseUnit.getScale();
                    double offset = baseUnit.getOffset();
                    if (factor != 1.0) {
                        generateAttribute("factor", factor, genPrinter);
                    }
                    if (offset != 0.0) {
                        generateAttribute("offset", offset, genPrinter);
                    }
                }
            }

            public class XMLTag_displayUnit extends XMLTag {

                public XMLTag_displayUnit(AbstractGenerator myGenerator, FClass fclass) {
                    super("displayUnit", "DisplayUnit", myGenerator, fclass);
                }

                public void generateAttributes(CodeStream genPrinter) {
                    generateAttribute("name", def, genPrinter);
                    
                    Unit conv = getUnitConversion(unit, def);
                    if (conv != null) {
                        double factor = conv.getScale();
                        double offset = conv.getOffset();
                        if (factor != 1.0) {
                            generateAttribute("factor", factor, genPrinter);
                        }
                        if (offset != 0.0) {
                            generateAttribute("offset", offset, genPrinter);
                        }
                    }
                }
            }
        }
    }

    
	
	/**
	 * Internal class used to generate a TypeDefinitions tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_typeDefinitions extends XMLTag {
		
		private FEnumDecl enumdecl;
		
		public XMLTag_typeDefinitions(AbstractGenerator myGenerator, FClass fclass) {
			super("typeDefinitions", "TypeDefinitions", myGenerator, fclass);
		}
		
		public String[] children() { return new String[] {"simpleType"}; }
		
		public void generate(CodeStream genPrinter) {
            if (fclass.getNumFEnumDecl() > 0) super.generate(genPrinter);
		}
		
		public void generateChildren(CodeStream genPrinter) {
			Iterator<FEnumDecl> itr = fclass.getFEnumDecls().iterator();
			while (itr.hasNext()) {
				enumdecl = itr.next();
				super.generateChildren(genPrinter);
			}
		}
		
		public class XMLTag_type extends XMLTag {
			
			public XMLTag_type(AbstractGenerator myGenerator, FClass fclass) {
				super("simpleType", "SimpleType", myGenerator, fclass);
			}
            
            public String[] children() { return new String[] {"enumeration"}; }
			
			public void generateAttributes(CodeStream genPrinter) {
				generateAttribute("name", enumdecl.name(), genPrinter);
                if (enumdecl.hasFStringComment())
                    generateAttribute("description", enumdecl.getFStringComment().getComment(), genPrinter);
			}
		}
		
		public class XMLTag_enumerationType extends XMLTag {
			
			private FEnumLiteral literal;
			private int itemIndex; 
			
			public XMLTag_enumerationType(AbstractGenerator myGenerator, FClass fclass) {
				super("enumeration", "Enumeration", myGenerator, fclass);
			}
			
			public String[] children() { return new String[] {"item"}; }
			
			public void generateChildren(CodeStream genPrinter) {
				Iterator<FEnumLiteral> itr = enumdecl.enumLiterals().iterator();
                itemIndex = 1;
				while (itr.hasNext()) {
					literal = itr.next();
					super.generateChildren(genPrinter);
				}
			}
			
			public class XMLTag_item extends XMLTag {
				
				public XMLTag_item(AbstractGenerator myGenerator, FClass fclass) {
					super("item", "Item", myGenerator, fclass);
				}
				
				public void generateAttributes(CodeStream genPrinter) {
                    generateAttribute("name",  literal.name(), genPrinter);
                    generateAttribute("value", itemIndex++,    genPrinter);
					if (literal.hasFStringComment()) {
						generateAttribute("description", literal.getFStringComment().getComment(), genPrinter);
					}
				}
			}
		}
	}

    
    
    /**
	 * Internal class used to generate a LogCategories tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_logCategories extends XMLTag {
		
        //TODO: make a small class for the log categorie that can be looped over.
		private String[] categorieNames;
        private String[] categorieDescriptions;
		private String currentCategorieName;
        private String currentCategorieDescription;
		
		public XMLTag_logCategories(AbstractGenerator myGenerator, FClass fclass) {
			super("logCategories", "LogCategories", myGenerator, fclass);
            categorieNames        = new String[] {"logLevel1", "logLevel2", "logLevel3",
                                                  "logLevel4", "logLevel5", "logLevel6"};
                                           
            categorieDescriptions = new String[] { "logLevel1 - fatal error", 
                                                   "logLevel2 - error",
                                                   "logLevel3 - warning",
                                                   "logLevel4 - info",
                                                   "logLevel5 - verbose",
                                                   "logLevel6 - debug"};
		}
        
		public String[] children() { return new String[] {"category"}; }
		
		public void generateChildren(CodeStream genPrinter) {
			for (int i = 0; i < categorieNames.length; i++) {
				currentCategorieName        = categorieNames[i];
                currentCategorieDescription = categorieDescriptions[i];
				super.generateChildren(genPrinter);
			}
		}
		
        public class XMLTag_category extends XMLTag {
			
			public XMLTag_category(AbstractGenerator myGenerator, FClass fclass) {
				super("category", "Category", myGenerator, fclass);
            }
			
			public void generateAttributes(CodeStream genPrinter) {
				generateAttribute("name",        currentCategorieName,        genPrinter);
                generateAttribute("description", currentCategorieDescription, genPrinter);
			}
		}
	}

    
    
    private enum InitialType {
        CALCULATED("calculated"),
        EXACT     ("exact"),
        APPROX    ("approx");
        
        private final String stringRepresentation;
        
        InitialType(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }
        
        public String toString() { return stringRepresentation; }
    }

    
    
    private InitialType getInitialType(FVariable var) {
        if (!generateStartAttribute(var))
            return InitialType.CALCULATED;
        else if (var.fixedAttribute() || generateAsConstant(var))
            return InitialType.EXACT;
        else
            return InitialType.APPROX;
    }

    
    
    @Override
    protected String getNonIOCausality(FVariable var) {
        if (var.isParameter() && !generateAsConstant(var)) {
            if (getInitialType(var) == InitialType.CALCULATED) {
                return "calculatedParameter";
            } else {
                return "parameter";
            }
        } else {
            return "local";
        }
    }

    
    
    @Override
    protected String getParameterVariability() {
        return "fixed";
    }

    

    /**
     * Internal class used to generate a ModelVariables tag.
     * 
     * @see XMLTag
     */
    public class XMLTag_modelVariables extends ModelVariablesBase {

        protected String startValue;

        public XMLTag_modelVariables(AbstractGenerator myGenerator, FClass fclass) {
            super(myGenerator, fclass);
        }

        public class XMLTag_variables extends XMLTag {

            public XMLTag_variables(AbstractGenerator myGenerator, FClass fclass) {
                super("variables", "ScalarVariable", myGenerator, fclass);
            }

            public String[] children() {
                return new String[] {"real", "integer", "boolean", "string", "variableEnumeration"};
            }

            public void generateAttributes(CodeStream genPrinter) {
                //Modify the negated bit of the valuReference if the variable is a negated alias.
                int valueReference = variable.generateXMLValueReference();
                if (variable.isAlias() && variable.isNegated())
                    valueReference = valueReference ^ 0x08000000;
                
                generateAttribute("name",           variable.generateXMLName(), genPrinter);
                generateAttribute("valueReference", valueReference,  genPrinter);
                if (variable.hasFStringComment())
                    generateAttribute("description", variable.getFStringComment().getComment(), genPrinter);
                
                //Find the attribute for initial, is generated later.
                InitialType initialType = getInitialType(variable);
                
                //Generate the causality attribute.
                generateAttribute("causality", getCausality(variable), genPrinter);
                
                //Generate the variability attribute. No tunable parameters as for now.
                generateAttribute("variability", getVariability(variable), genPrinter);
                
                //Generate the initial attribute.
                if (!variable.isInput()) //Except for inputs, see FMI 2.0 spec p.47
                    generateAttribute("initial", initialType, genPrinter);
            }
        }

        public class XMLTag_real extends XMLTag {

            public XMLTag_real(AbstractGenerator myGenerator, FClass fclass) {
                super("real", "Real", myGenerator, fclass);
            }

            public String[] attributes() { return new String[] {"reinit"}; }

            public void generate(CodeStream genPrinter) {
                if (variable.isReal()) {
                    super.generate(genPrinter);
                }
            }

            private int getDerivativeIdx(FVariable var) {
                FAbstractVariable lowerOrderVar = var.myDifferentiatedVariable();
                if (lowerOrderVar.isFVariable()) {
                    return fclass.xmlVariableIndexMap().get(lowerOrderVar.asFVariable().generateXMLName());
                } else {
                    throw new InternalCompilerError("Unable to find lower order variable for derivative variable " + var.displayName());
                }
            }

            public void generateAttributes(CodeStream genPrinter) {
                generateAttributeIfSet(FAttribute.QUANTITY, variable, genPrinter);
                generateUnitAndDisplayUnitAttribute(genPrinter, variable);
                generateAttribute("relativeQuantity", !variable.isAbsoluteValue(), genPrinter);
                generateAttributeIfSet(FAttribute.MIN,     variable, genPrinter);
                generateAttributeIfSet(FAttribute.MAX,     variable, genPrinter);
                generateAttributeIfSet(FAttribute.NOMINAL, variable, genPrinter);
                generateStartAttributeIfSet(variable, genPrinter);
                if (variable.isDerivativeVariable() || variable.isDummyDerivativeVariable()) {
                    generateAttribute("derivative", getDerivativeIdx(variable), genPrinter);
                }
                super.generateAttributes(genPrinter);
            }

            public class XMLTag_reinit extends METag {
                
                public XMLTag_reinit(AbstractGenerator myGenerator, FClass fclass) {
                    super("reinit", "reinit", myGenerator, fclass);
                }
                
                public void generate(CodeStream genPrinter) {
                    if (variable.isReinit()) super.generate(genPrinter);
                }
                
                public Object value() { return true; } //Default is false
            }
        }

		public class XMLTag_integer extends XMLTag {

			public XMLTag_integer(AbstractGenerator myGenerator, FClass fclass) {
				super("integer", "Integer", myGenerator, fclass);
			}
			
			public void generate(CodeStream genPrinter) {
                if(variable.isInteger()) super.generate(genPrinter);
			}

			public void generateAttributes(CodeStream genPrinter) {
                generateAttributeIfSet(FAttribute.QUANTITY, variable, genPrinter);
                generateAttributeIfSet(FAttribute.MIN,      variable, genPrinter);
                generateAttributeIfSet(FAttribute.MAX,      variable, genPrinter);
                generateStartAttributeIfSet(variable, genPrinter);
			}
		}

		public class XMLTag_boolean extends XMLTag {

			public XMLTag_boolean(AbstractGenerator myGenerator, FClass fclass) {
				super("boolean", "Boolean", myGenerator, fclass);
			}
			
			public void generate(CodeStream genPrinter) {
                if(variable.isBoolean()) super.generate(genPrinter);
			}

			public void generateAttributes(CodeStream genPrinter) {
                generateStartAttributeIfSet(variable, genPrinter);
			}
		}

		public class XMLTag_string extends XMLTag {

			public XMLTag_string(AbstractGenerator myGenerator, FClass fclass) {
				super("string", "String", myGenerator, fclass);
			}
			
			public void generate(CodeStream genPrinter) {
                if(variable.isString()) super.generate(genPrinter);
			}

			public void generateAttributes(CodeStream genPrinter) {
                generateStartAttributeIfSet(variable, genPrinter);
			}
		}

		public class XMLTag_enumeration extends XMLTag {

			public XMLTag_enumeration(AbstractGenerator myGenerator, FClass fclass) {
				super("variableEnumeration", "Enumeration", myGenerator, fclass);
			}
			
			public void generate(CodeStream genPrinter) {
                if(variable.isEnum()) super.generate(genPrinter);
			}

			public void generateAttributes(CodeStream genPrinter) {
                generateAttribute("declaredType", variable.myFEnumDecl().name(), genPrinter);
                generateAttributeIfSet(FAttribute.QUANTITY, variable, genPrinter);
                generateAttributeIfSet(FAttribute.MIN,      variable, genPrinter);
                generateAttributeIfSet(FAttribute.MAX,      variable, genPrinter);
                generateStartAttributeIfSet(variable, genPrinter);
			}
		}
	}

    
	
	/**
	 * Internal class used to generate a ModelStructure tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_modelStructure extends XMLTag {
		
		private FVariable variable;

		public XMLTag_modelStructure(AbstractGenerator myGenerator, FClass fclass) {
			super("modelStructure", "ModelStructure", myGenerator, fclass);
		}
		
		public String[] children() { return new String[] {"outputs", "derivatives", "initialUnknowns"}; }
		
		public class XMLTag_derivatives extends XMLTag {

			public XMLTag_derivatives(AbstractGenerator myGenerator, FClass fclass) {
				super("derivatives", "Derivatives", myGenerator, fclass);
			}
			
            public String[] children() { return new String[] {"unknownForSimulation"}; }
			
			public void generate(CodeStream genPrinter) {
				if (fclass.numDerivativeVariables() > 0)
					super.generate(genPrinter);
			}
			
			public void generateChildren(CodeStream genPrinter) {
                for (FVariable var : fclass.derivativeVariables()) {
                    if (var.generateXMLVariable()) {
                        variable = var;
                        super.generateChildren(genPrinter);
                    }
				}
			}
		}
		
		public class XMLTag_outputs extends XMLTag {

			public XMLTag_outputs(AbstractGenerator myGenerator, FClass fclass) {
				super("outputs", "Outputs", myGenerator, fclass);
			}
			
            public String[] children() { return new String[] {"unknownForSimulation"}; }
			
			public void generate(CodeStream genPrinter) {
				if (fclass.numOutputs() > 0)
					super.generate(genPrinter);
			}
			
			public void generateChildren(CodeStream genPrinter) {
                for (FVariable var : fclass.outputs()) {
                    if (var.generateXMLVariable()) {
                        variable = var;
                        super.generateChildren(genPrinter);
                    }
				}
			}
		}
		
        public class XMLTag_initialUnknowns extends XMLTag implements Variable {
            
            private LinkedList<FVariable> initialUnknowns;
			
			public XMLTag_initialUnknowns(AbstractGenerator myGenerator, FClass fclass) {
				super("initialUnknowns", "InitialUnknowns", myGenerator, fclass);
			}
            
            public String[] children() { return new String[] {"unknownForInit"}; }
            
            private boolean isInitialUnknown(FVariable var) {
                InitialType initialType = getInitialType(var);
                boolean calculated         = (initialType == InitialType.CALCULATED);
                boolean calculatedOrApprox = (calculated || initialType == InitialType.APPROX);
                
                return var.isOutput()                 && calculatedOrApprox ||
                       var.isDifferentiatedVariable() && calculatedOrApprox ||
                       var.isDerivativeVariable()     && calculatedOrApprox ||
                       var.isParameter()              && calculated;
            }
            
            public void generate(CodeStream genPrinter) {
                //Find the initial unknowns if there are any.
                initialUnknowns = new LinkedList<FVariable>();
                for (FVariable var : fclass.allVariables()) {
                    if (var.generateXMLVariable() && isInitialUnknown(var)) {
                        initialUnknowns.add(var);
                    }
                }
                
                if (!initialUnknowns.isEmpty()) {
                    //Sort the initial unknowns and generate tag.
                    VariableNameComparator comp = new VariableNameComparator();
                    Collections.sort(initialUnknowns, comp);
                    super.generate(genPrinter);
                }
			}
			
			public void generateChildren(CodeStream genPrinter) {
				for (FVariable var: initialUnknowns) {
                    var.generateXMLVariable(genPrinter, this);
				}
			}

            public void generateVariableChildren(CodeStream genPrinter, FVariable var) {
                variable = var;
                super.generateChildren(genPrinter);
            }
		}
        
        /**
         * Base class for tags used to generate XML Tags Unknown
         */
        public abstract class XMLTag_unknown extends XMLTag {

            public XMLTag_unknown(String name, String xml, AbstractGenerator myGenerator, FClass fclass) {
                super(name, xml, myGenerator, fclass);
            }

            protected abstract Iterable<Integer> dependencyIndices();

            public void generateAttributes(CodeStream genPrinter) {
                generateAttribute("index", variable.fmiXMLVariableIndex(), genPrinter);
                Iterable<Integer> dependencyIndex = dependencyIndices();
                if (dependencyIndex != null) {
                    // If we have dependency on a non-scalar, then we skip the 
                    // dependencies filed since it can become to verbose!
                    // According to the FMI specification this means that this
                    // unknown depends on all knowns!
                    generateListAttribute("dependencies", dependencyIndex , genPrinter);
                }
            }
        }

        public class XMLTag_unknownForInit extends XMLTag_unknown {

            private HashMap<FVariable, HashSet<FVariable>> parameterDependencies = null;

            public XMLTag_unknownForInit(AbstractGenerator myGenerator, FClass fclass) {
                super("unknownForInit", "Unknown", myGenerator, fclass);
            }

            @Override
            protected Iterable<Integer> dependencyIndices() {
                return variable.initDAEDependencyIndices(new Criteria<FVariable>() {
                    @Override
                    public boolean test(FVariable var) {
                        return (var.generateXMLVariable() && getInitialType(var) == InitialType.EXACT) || var.isInput();
                    }
                });
            }
        }

        public class XMLTag_unknownForSimulation extends XMLTag_unknown {

            public XMLTag_unknownForSimulation(AbstractGenerator myGenerator, FClass fclass) {
                super("unknownForSimulation", "Unknown", myGenerator, fclass);
            }

            @Override
            protected Iterable<Integer> dependencyIndices() {
                return variable.daeDependencyIndices(new Criteria<FVariable>() {
                    @Override
                    public boolean test(FVariable var) {
                        return var.isDifferentiatedVariable() || var.isFDynamicStateVariable() || var.isInput();
                    }
                });
            }
        }
    }


}
