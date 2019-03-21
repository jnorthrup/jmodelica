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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:162
 */
public abstract class FmiXMLGenerator extends GenericXMLGenerator {
    
    
    /**
     * Constructor.
     * 
     * @param expPrinter Printer object used to generate code for expressions.
     * @param escapeCharacter Escape characters used to decode tags.
     * @param fclass An FClass object used as a basis for the code generation.
     */
    public FmiXMLGenerator(Printer expPrinter, char escapeCharacter, FClass fclass) {
        super(expPrinter, escapeCharacter, fclass);
    }

    
    
    /**
     * Base class for tags used to generate XML that should only be present in ME FMUs.
     */
    public abstract class METag extends XMLTag {
        
        /**
         * Construct a tag.
         * 
         * @param name        tag name
         * @param xml         name to use for the xml tag or attribute
         * @param myGenerator the tag's generator
         * @param fclass      an FClass to generate code for
         */
        public METag(String name, String xml, AbstractGenerator myGenerator, FClass fclass) {
            super(name, xml, myGenerator, fclass);
            addOptions("generate_fmi_me_xml");
        }
        
    }

    
    
    /**
     * Base class for tags used to generate XML that should only be present in CS FMUs.
     */
    public abstract class CSTag extends XMLTag {
        
        /**
         * Construct a tag.
         * 
         * @param name        tag name
         * @param xml         name to use for the xml tag or attribute
         * @param myGenerator the tag's generator
         * @param fclass      an FClass to generate code for
         */
        public CSTag(String name, String xml, AbstractGenerator myGenerator, FClass fclass) {
            super(name, xml, myGenerator, fclass);
            addOptions("generate_fmi_cs_xml");
        }
        
    }

    
    
    /**
	 * Internal class used to generate a DefaultExperiment tag.
	 * 
	 * @see XMLTag
	 */
	public class XMLTag_defaultExperiment extends XMLTag {
		
		private FClass.Experiment e = fclass.experiment;
		
		public XMLTag_defaultExperiment(AbstractGenerator myGenerator, FClass fclass) {
			super("defaultExperiment", "DefaultExperiment", myGenerator, fclass);
		}
		
		public void generate(CodeStream genPrinter) {
			if (e != null) {
				super.generate(genPrinter);
			}
		}
		
		public void generateAttributes(CodeStream genPrinter) {
			if (e.hasStart)
				generateAttribute("startTime", Double.toString(e.start),     genPrinter);
			if (e.hasStop)
				generateAttribute("stopTime",  Double.toString(e.stop),      genPrinter);
			if (e.hasTolerance)
				generateAttribute("tolerance", Double.toString(e.tolerance), genPrinter);
		}
	}

    

    private static Collection<String> vendorAnnotationTools = new ArrayList<String>();

    
    private static Collection<String> vendorAnnotations = new ArrayList<String>();

    

    /**
     * Used for registering new vendor annotation tag. Returns the name
     * for conveninence. Vendor annotation tags should inherit 
     * FMIVendorAnnotation.
     */
    public static String addVendorAnnotation(String childName) {
        vendorAnnotations.add(childName);
        return childName;
    }

    

    /**
     * Used for registering new tool specific tag under the vendor annotation tag. 
     * Returns the name for conveninence.
     */
    public static String addVendorAnnotationTool(String childName) {
        vendorAnnotationTools.add(childName);
        return childName;
    }

    

    /**
     * Internal class used to generate a VendorAnnotations tag.
     * 
     * @see XMLTag
     */
    public class XMLTag_vendorAnnotations extends XMLTag {

        public XMLTag_vendorAnnotations(AbstractGenerator myGenerator, FClass fclass) {
            super("vendorAnnotations", "VendorAnnotations", myGenerator, fclass);
        }
        
        public String[] children() { 
            return vendorAnnotationTools.toArray(new String[vendorAnnotationTools.size()]);
        }

        public boolean isActive() {
            return hasActiveChildren();
        }
    }

    
	
    /**
     * Internal class used to generate a Tool tag.
     * 
     * @see XMLTag
     */
    public abstract class XMLTag_tool extends XMLTag {

        private final String vendorName;

        public XMLTag_tool(String tagName, String vendorName, AbstractGenerator myGenerator, FClass fclass) {
            super(tagName, "Tool", myGenerator, fclass);
            this.vendorName = vendorName;
        }

        public final void generateAttributes(CodeStream genPrinter) {
            generateAttribute("name", vendorName, genPrinter);
        }
    }

    

    private static final String VENDOR_ANNOTATIONS_TOOL_MAIN = addVendorAnnotationTool("vendorAnnotations_tool");

    

    /**
     * Internal class used to generate a Tool tag in VendorAnnotations.
     * 
     * @see XMLTag
     */
    public class XMLTag_vendorAnnotations_tool extends XMLTag_tool {
        
        public XMLTag_vendorAnnotations_tool(AbstractGenerator myGenerator, FClass fclass) {
            super(VENDOR_ANNOTATIONS_TOOL_MAIN, fclass.guidManager().getToolNameToken(), myGenerator, fclass);
        }

        public String[] children() {
            if (fclass.myOptions().getStringOption("fmi_version") == OptionRegistry.FMIVersion.FMI10) {
                return vendorAnnotations.toArray(new String[vendorAnnotations.size()]);
            } else {
                return new String[] { "vendorAnnotations_annotations" };
            }
        }

        public boolean isActive() {
            return hasActiveChildren();
        }
    }

    

    /**
     * Internal class used to generate a Tool tag in VendorAnnotations.
     * 
     * @see XMLTag
     */
    public class XMLTag_vendorAnnotations_annotations extends XMLTag {
        
        public XMLTag_vendorAnnotations_annotations(AbstractGenerator myGenerator, FClass fclass) {
            super("vendorAnnotations_annotations", "Annotations", myGenerator, fclass);
        }

        public String[] children() {
            return vendorAnnotations.toArray(new String[vendorAnnotations.size()]);
        }

        public boolean isActive() {
            return hasActiveChildren();
        }
    }

    

    /**
     * Internal class used to describe a vendor annotation.
     * 
     * @see XMLTag
     */
    public abstract class FMIVendorAnnotation extends XMLTag {
        
        private String annotationName;
        
        public FMIVendorAnnotation(String tagName, String annotationName, AbstractGenerator myGenerator, FClass fclass) {
            super(tagName, "Annotation", myGenerator, fclass);
            this.annotationName = annotationName;
        }
        
        public abstract Object annotationValue();
        
        public void generateAttributes(CodeStream genPrinter) {
            generateAttribute("name",  annotationName,    genPrinter);
            generateAttribute("value", annotationValue(), genPrinter);
        }
    }

    

    private static final String COMPILER_VERSION_ANNOTATION = addVendorAnnotation("vendorAnnotation:compilerVersion");

    
    
    public class CompilerVersionAnnotation extends FMIVendorAnnotation {
        public CompilerVersionAnnotation(AbstractGenerator myGenerator, FClass fclass) {
            super(COMPILER_VERSION_ANNOTATION, "CompilerVersion", myGenerator, fclass);
        }
        
        public String annotationValue() {
            return getFClass().guidManager().getCompilerVersionToken();
        }
    }

    

    /**
     * Abstract class for handling printing of variables. Things that are
     * common between the different FMI versions should be in this class.
     * Each sub class must have a class named XMLTag_variables!
     */
    public abstract class ModelVariablesBase extends XMLTag implements Variable {
        
        protected FVariable variable;
        
        public ModelVariablesBase(AbstractGenerator myGenerator, FClass fclass) {
            super("modelVariables", "ModelVariables", myGenerator, fclass);
        }
        
        public String[] children() { return new String[] {"variables"}; }
        
        public void generateChildren(CodeStream genPrinter) {
            fclass.xmlVariableIndexMap();
            for (FVariable var : fclass.xmlVariables()) {
                var.generateXMLVariable(genPrinter, this);
            }
        }

        public void generateVariableChildren(CodeStream genPrinter, FVariable var) {
            variable = var;
            generateComment("Variable with index #" + var.fmiXMLVariableIndex(), genPrinter);
            super.generateChildren(genPrinter);
        }
    }

    
    
    public interface Variable {
        public void generateVariableChildren(CodeStream genPrinter, FVariable var);
    }

    

    /**
     * Adds the unit data of a real variable to the unit HashMap.
     *
     * @param HashMap A HashMap that data about units should be added.
     * @param FRealVariable A real variable class with unit attribute(s).
     */
    private void addToUnitMap(HashMap<String,HashSet<String>> unitMap, FVariable variable) {
        if (variable.isReal() && variable.attributeSet(FAttribute.UNIT)) {
            String attribute = variable.attributeCValue(FAttribute.UNIT).xmlValue();
            HashSet<String> displayUnitsSet = unitMap.get(attribute);
            if(displayUnitsSet == null) {
                displayUnitsSet = new LinkedHashSet<String>();
                unitMap.put(attribute, displayUnitsSet);
            }
            if (variable.attributeSet(FAttribute.DISPLAY_UNIT)) {
                displayUnitsSet.add(variable.attributeCValue(FAttribute.DISPLAY_UNIT).xmlValue());
            }
        }
    }

    
    
    /**
     * Create and format the Unit data in a HashMap.
     *
     * @param fclass An FClass object used as a basis for the code generation.
     */
    protected HashMap<String,HashSet<String>> extractUnits(FClass fclass) {
        HashMap<String,HashSet<String>> unitMap = new LinkedHashMap<String,HashSet<String>>();
        for(FVariable variable:fclass.allVariables()) {
            addToUnitMap(unitMap, variable);
        }
        
        return unitMap;
    }

    
    
    /**
     * Checks if the start attribute should be generated.
     *
     * @param FVariable A variable class.
     */
    protected boolean generateStartAttribute(FVariable var) {
        FExp startExp = var.generateXMLStartExp();
        if (startExp != null) {
            return startExp.isConstantExp();
        }
        return !var.variability().parameterOrLess() && var.fixedAttribute() && !var.isAlias();
    }

    

    protected void generateStartAttributeIfSet(FVariable var, CodeStream genPrinter) {
        if (generateStartAttribute(var)) {
            FExp startExp = var.generateXMLStartExp();
            CValue val = startExp != null ? startExp.ceval() : var.startAttributeCValue();
            val = var.type().convert(val);
            generateAttribute(FAttribute.START, val.xmlValue(), genPrinter);
        }
    }

    

    protected void generateStartAndFixedAttribute(CodeStream genPrinter, FVariable var) {
        if (generateStartAttribute(var)) {
            generateStartAttributeIfSet(var, genPrinter);
            if (!var.fixedAttribute() && !var.variability().knownParameterOrLess()) {
                generateAttribute("fixed", false, genPrinter); //Default is true
            }
        }
    }

    

    protected void generateUnitAndDisplayUnitAttribute(CodeStream genPrinter, FVariable var) {
        String name = FAttribute.UNIT;
        if (var.attributeSet(name)) {
            String value = var.attributeCValue(name).xmlValue();
            generateAttribute(name, value, genPrinter);
            generateAttributeIfSet(FAttribute.DISPLAY_UNIT, var, genPrinter);
        }
    }

    


    /**
     * Gets the number of event indicators that should be stated in the XML
     */
    protected int numberOfEventIndicators(FClass fclass) {
        if (fclass.onlyInitBLT())
            return fclass.numEventIndicators() + fclass.numInitialEventIndicators();
        else
            return fclass.numEventIndicators();
    }

    
    
    protected boolean generateAsConstant(FVariable var) {
        return var.variability().knownParameterOrLess();
    }

    
    
    protected String getCausality(FVariable var) {
        if (var.isInput()) {
            return "input";
        } else if (var.isOutput()) {
            return "output";
        } else {
            return getNonIOCausality(var);
        }
    }

    
    
    protected String getNonIOCausality(FVariable var) {
        return "internal";
    }

    
    
    protected String getVariability(FVariable var) {
        if (generateAsConstant(var)) {
            return "constant";
        } else if (var.isParameter()) {
            return getParameterVariability();
        } else if (var.isDiscrete()) {
            return "discrete";
        } else {
            return "continuous";
        }
    }

    
    
    protected String getParameterVariability() {
        return "parameter";
    }

    protected Unit getUnitConversion(String from, String to) {
    try {
        UnitParser unitParser = UnitParser.getParser();
        Unit c = unitParser.parse(from).convertTo(unitParser.parse(to));
        if (c.isAnyUnit()) return null;
        return c;
    } catch(UnitParser.Exception e) {
        return null;
    }
}

    protected Unit getBaseUnitInfo(String unit) {
    try {
        // Parse unit
        Unit u = UnitParser.getParser().parse(unit);
        if (u.isAnyUnit()) return null;
        return u;
    } catch(UnitParser.Exception e) {
        return null;
    }
}


}
