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
 * @aspect TestCases
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestCase.jrag:50
 */
abstract public class TestCase extends java.lang.Object implements GenericTestCase {
    

    /**
     * A simple ParserHandler instance which is used for tests.
     */
    public static final ParserHandler PARSER_HANDLER = new ParserHandler();

    

    private String name = null;

    
    private String description = null;

    
    private String platform = null;

    
    private String sourceFileName = null;

    
    private String className = null;

    
    private int beginLine = -1;

    

    private boolean filter = false;

    
    private boolean checkAll = false;

    
    private ErrorCheckType checkType = ErrorCheckType.COMPILE;

    
    
    private String[] modelicaLibraries = new String[0];

    

    protected OptionRegistry options = createOptionRegistry();

    
    private Exception exception = null;

    
    private ArrayList<String> regexp = new ArrayList<String>();

    
    
    /**
     * If cls represents a Java "wrapper" class, return the equivalent primitive 
     * type. If not, return cls.
     */
    public static Class unwrapClass(Class cls) {
        try {
            for (Field f : cls.getDeclaredFields()) {
                if (f.getType().equals(Class.class) && f.getName().equals("TYPE")) {
                    return (Class) f.get(null);
                }
            }
        } catch (Exception e) {}
        return cls;
    }

    

    /**
     * Create the OptionRegistry to be used during compilation.
     * 
     * Options may be further changed by test annotation.
     */
    protected OptionRegistry createOptionRegistry() {
        OptionRegistry or = new TestOptions();
        OptionsAggregated.addTo(or);
        File modelicapath = EnvironmentUtils.getThirdPartyMSL();
        or.setStringOption("MODELICAPATH", modelicapath.getPath());
        return or;
    }

    

    public String filterTestResult(String str, Map<Pattern, String> resultFilters) {
        for (Pattern p : resultFilters.keySet()) {
            str = p.matcher(str).replaceAll(resultFilters.get(p));
        }
        return str;
    }

    
	
	/**
	 * Set a string option to be used during compilation.
	 */
	public void setStringOption(String key, String value) {
		try {
			options.setStringOption(key, value);
		} catch (UnknownOptionException e) {
			exception = e;
		}
	}

    
    
	/**
	 * Set a boolean option to be used during compilation.
	 */
	public void setBooleanOption(String key, boolean value) {
		try {
			options.setBooleanOption(key, value);
		} catch (UnknownOptionException e) {
			exception = e;
		}
	}

    
	
	/**
	 * Set an integer option to be used during compilation.
	 */
	public void setIntegerOption(String key, int value) {
		try {
			options.setIntegerOption(key, value);
		} catch (UnknownOptionException e) {
			exception = e;
		}
	}

    
	
	/**
	 * Set a real option to be used during compilation.
	 */
	public void setRealOption(String key, double value) {
		try {
			options.setRealOption(key, value);
		} catch (UnknownOptionException e) {
			exception = e;
		}
	}

    
    
    /**
     * Set a string option to be used during compilation.
     */
    public void setOption(String key, String value) {
        setStringOption(key, value);
    }

    
    
    /**
     * Set a boolean option to be used during compilation.
     */
    public void setOption(String key, boolean value) {
        setBooleanOption(key, value);
    }

    
    
    /**
     * Set an integer option to be used during compilation.
     */
    public void setOption(String key, int value) {
        setIntegerOption(key, value);
    }

    
    
    /**
     * Set a real option to be used during compilation.
     */
    public void setOption(String key, double value) {
        setRealOption(key, value);
    }

    

    /**
     * Gets an option's default value.
     * 
     * @param options   the {@link OptionRegistry} from which to get the option.
     * @param key       the name of the option.
     */
    public Object getOptionDefault(OptionRegistry options, String key) {
        if (!options.hasOption(key)) {
            return null;
        }

        if (options.isBooleanOption(key)) {
            return options.getBooleanOptionDefault(key);
        } else if (options.isRealOption(key)) {
            return options.getRealOptionDefault(key);
        } else if (options.isIntegerOption(key)) {
            return options.getIntegerOptionDefault(key);
        } else if (options.isStringOption(key)) {
            return options.getStringOptionDefault(key);
        }

        throw new IllegalArgumentException("Unexpected option value type for " + key + ".");
    }

    

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

    

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

    

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

    

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

    

	/**
	 * platform is an optional annotation that allows to specify for which platforms the test should be run or skipped.
	 * see {@code org.jmodelica.util.Arguments#tooltip()} for possible platforms.
	 * 
	 * Assume that the system platform is win64.
	 * Example 1 (only excluded platforms):
	 *   annotation(
	 *     platform="!linux64")
	 * Here, win64 is included, because it is not listed as an excluded platform.
	 * 
	 * Example 2 (both included and excluded platforms):
	 *   annotation(
	 *     platform="win32 !linux64")
	 * Here, win64 is excluded, because the list of platforms includes included platforms, 
	 * and win64 is not listed as an included platform.
	 * 
	 * Example 3 (no platform annotation):
	 *   annotation(
	 *     )
	 * When the platform annotation is omitted, win64 is included, because it is not listed as an excluded platform. 
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

    

	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

    

	/**
	 * @return the sourceFileName
	 */
	public String getSourceFileName() {
		return sourceFileName;
	}

    

	/**
	 * @param sourceFileName the sourceFileName to set
	 */
	public void setSourceFileName(String sourceFileName) {
	    
		this.sourceFileName = sourceFileName;
	}

    

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

    

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

    

    /**
     * @return the beginLine
     */
    public int getBeginLine() {
        return beginLine;
    }

    

    /**
     * @param beginLine the beginLine to set
     */
    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    

    /**
     * Add a regular expression to be performed on the result (if result is compared as text).
     * 
     * Must follow the syntax "xREGEXPxREPLACEMENTx", where x is any character that does not 
     * appear in REGEXP or REPLACEMENT.
     */
    public void setRegexp(String re) {
        regexp.add(re);
    }

    

    /**
     * Get the list of regular expressions to be performed on the result 
     * (if result is compared as text).
     */
    public java.util.List<String> getRegexp() {
        return regexp;
    }

    

	/**
	 * Activate or deactivate filtering (see {@link #filter(String)}).
	 */
	public void setFilter(boolean val) {
		filter = val;
	}

    
	
	/**
	 * Activate or deactivate incusion of warnings and compliance errors 
	 *        in error check (see {@link #filterProblems(Collection)}).
	 */
	public void setCheckAll(boolean val) {
		checkAll = val;
	}

    
    
    /**
     * Set type of error checking to be performed.
     * 
     * Available for all test types, but only logical to change for error/warning/compliance tests.
     */
    public void setCheckType(String val) {
        checkType = ErrorCheckType.valueOf(ErrorCheckType.class, val.toUpperCase());
    }

    
    
    /**
     * Get type of error checking being performed.
     */
    public ErrorCheckType getCheckType() {
        return checkType;
    }

    
    
    public void setModelicaLibraries(String s) {
        modelicaLibraries = s.split(",");
    }

    
    
    public String[] getModelicaLibraries() {
        return modelicaLibraries;
    }

    
    
    public boolean hasModelicaLibraries() {
        return modelicaLibraries.length > 0;
    }

    
	
	/**
	 * Perform filtering on string, if activated.
	 */
	protected String filter(String str) {
		if (filter) {
			// TODO: Add more filters
			str = str.replace("%dir%", testFileDirectory());
			str = str.replace("%msl%", mslDirectory());
		}
		return str;
	}

    

    /**
     * Get the path to the directory containing the test file.
     */
    protected String testFileDirectory() {
        File file = new File(getSourceFileName());
        return URIResolver.DEFAULT.canonicalPath(file.getParentFile());
    }

    

	/**
	 * Get the path to the directory containing the MSL.
	 */
	protected String mslDirectory() {
		for (String path : options.getStringOption("MODELICAPATH").split(File.pathSeparator)) {
			File f = new File(path, "Modelica");
			if (f.isDirectory())
				return f.getAbsolutePath();
		}
		return null;
	}

    
	
	/**
	 * Remove all whitespace.
	 */
	public String removeWhitespace(String str) {
		// TODO: this can mask errors, we need a better filtering
		return str.replaceAll("\\s+", "");
	}

    
	
	private Assert asserter;

    

    /**
     * Perform an assertion that two strings are equal. Whitespaces and line
     * endings are removed before comparing!
     * 
     * @param msg       a message describing what went wrong
     * @param expected  the expected value
     * @param actual    the actual value
     */
    protected void assertEquals(String msg, String expected, String actual) {
        expected = filterForAssert(expected);
        actual = applyRegexps(actual);
        actual = filterForAssert(actual);
        assertExactlyEquals(msg, expected, actual);
    }

    

    /**
     * Tests if two strings are exactly equal.
     */
    protected void assertExactlyEquals(String msg, String expected, String actual) {
        msg = getDescription() + "\n" + getClass().getSimpleName() + ": " + msg;
        asserter.assertEquals(msg, expected, actual);
    }

    

    private String filterForAssert(String str) {
        str = str.replaceAll("\\r\\n|\\r", "\n");
        str = str.replaceFirst("^([ \\t]*[\\n])+", "");
        str = str.replaceAll("[ \\t]*$", "");
        return str;
    }

    

    /**
     * Check if two strings are equal, minus any whitespace.
     * 
     * Will apply any regexps specified for the test on actual before comparison.
     */
    protected boolean checkEquals(String expected, String actual) {
        expected = removeWhitespace(expected);
        actual = applyRegexps(actual);
        actual = removeWhitespace(actual);
        return expected.equals(actual);
    }

    

    /**
     * Apply any regular expressions added with {@link #setRegexp(String)} to str.
     */
    protected String applyRegexps(String str) {
        for (String re : regexp) {
            str = applyRegexp(re, str);
        }
        return str;
    }

    

    /**
     * Apply the regular expression re to str.
     * 
     * It must follow the syntax "xREGEXPxREPLACEMENTx", where x is any character that does not 
     * appear in REGEXP or REPLACEMENT.
     */
    protected String applyRegexp(String re, String str) {
        String[] parts = re.split("\\" + re.substring(0, 1));
        if (parts.length != 3 || parts[1].length() == 0) {
            throw new IllegalArgumentException(
                    "Regexp on test case must follow syntax \"xREGEXPxREPLACEMENTx\", " + 
                    "where is a character that x does not appear in REGEXP or REPLACEMENT. " + 
                    "Offending regexp: " + re);
        }
        return str.replaceAll(parts[1], parts[2]);
    }

    

	/**
	 * Signal that the test failed.
	 * 
	 * @param msg  a message describing what went wrong
	 */
	protected void fail(String msg) {
		asserter.fail(getDescription() + "\n" + getClass().getSimpleName() + ": " + msg);
	}

    
	
	/**
	 * Signal that the test failed.
	 * 
	 * @param e  the exception that caused the failure
	 */
	protected void fail(Throwable e) {
		if (e instanceof ModelicaException) 
			fail(e.getMessage());

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(out));
		fail("Exception caught in test case: " + out.toString());
	}

    
	
	public boolean shouldBeIgnored() {
	    String platforms = getPlatform();
        PlatformSet platformSet = PlatformSet.parse(platforms);
        String systemPlatform = EnvironmentUtils.getSystemPlatform();
        return platformSet.isPlatformExcluded(systemPlatform);
	}

    

    public static class PlatformSet {
        private static PlatformSet EMPTY_PLATFORMSET = new PlatformSet(Collections.<String>emptySet(), Collections.<String>emptySet());
        private Set<String> includedPlatforms;
        private Set<String> excludedPlatforms;
        private PlatformSet(Set<String> includedPlatforms, Set<String> excludedPlatforms) {
            this.includedPlatforms = includedPlatforms;
            this.excludedPlatforms = excludedPlatforms;
        }
        /**
         * parses a string of the form "win32 !linux64" and returns a PlatformSet.
         * See {@code TestCase.getPlatform()} for usage.
         */
        public static PlatformSet parse(String string) {
            if(string == null || string.equals("")) {
                return EMPTY_PLATFORMSET;
            }
            Set<String> includedPlatforms = new HashSet<>();
            Set<String> excludedPlatforms = new HashSet<>();
            String[] words = string.split(" ");
            for(String word : words) {
                if(word.startsWith("!")) {
                    excludedPlatforms.add(word.substring(1));
                } else {
                    includedPlatforms.add(word);
                }
            }
            return new PlatformSet(includedPlatforms, excludedPlatforms);
        }
        
       boolean isPlatformExcluded(String platform) {
           return excludedPlatforms.contains(platform) || !includedPlatforms.isEmpty() && !includedPlatforms.contains(platform);
       }
    }

    

	public void testMe(Assert a) {
		try {
			asserter = a;
			performTest();
		} catch (ParserException e) {
			fail(e);
		} catch (ModelicaClassNotFoundException e) {
			fail(e);
		} catch (beaver.Parser.Exception e) {
			fail(e);
		} catch (IOException e) {
			fail(e);
		}
	}

    

    public void performTest() throws ParserException, beaver.Parser.Exception, 
                IOException, ModelicaClassNotFoundException {
        UtilInterface uif = UtilInterface.create(options);
        try {
            performTest(uif);
        } finally {
            uif.tearDown();
        }
    }

    
    
    public void performTest(UtilInterface uif) throws ParserException, beaver.Parser.Exception, 
                IOException, ModelicaClassNotFoundException {
        if (exception != null)
            fail(exception);
        
        // Parse
        SourceRoot sr;
        if (modelicaLibraries.length > 0) {
            String[] names = new String[modelicaLibraries.length + 1];
            File parent = new File(getSourceFileName()).getParentFile();
            for (int i = 0; i < modelicaLibraries.length; i++) {
                names[i] = new File(parent, modelicaLibraries[i]).getAbsolutePath();
            }
            names[modelicaLibraries.length] = getSourceFileName();
            sr = getParserHandler().parseModel(uif, names);
        } else {
            sr = getParserHandler().parseFile(uif, getSourceFileName());
        }

        if (testOptions(options)) {
            return;
        }

        if (testSource(sr)) {
            return;
        }

        // Instantiate and check for errors.
        InstProgramRoot ipr = sr.getProgram().getInstProgramRoot();
        Collection<Problem> problems = null;
        try {
            ipr.checkErrorsInInstClass(className, checkType);
            problems = sr.collectWarnings();
        } catch (CompilerException e) {
            problems = e.getProblems();
        }
        if (testSemanticProblems(problems)) return;
        
        // Test instantiated class
        InstClassDecl icd = ipr.lookupInstClassQualified(getClassName()).target();
        if (testInstantiated(icd)) return;
        
        // Flatten class and check errors reported during flattening
        FClass fc = FClass.create(icd, null);
        try {
            icd.flattenInstClassDecl(fc);
            problems = sr.collectWarnings();
        } catch (CompilerException e) {
            problems = e.getProblems();
        }
        if (testSemanticProblems(problems)) return;
        
        
        // Test flattened class
        if (testFlattened(fc)) return;
        
        
        // Transform canonical and check for errors again
        try {
            fc.transformCanonical();
            fc.errorCheck(checkType);
            problems = fc.collectWarnings();
        } catch (CompilerException e) {
            problems = e.getProblems();
        }
        if (testTransformedProblems(problems)) return;
		
		
		// Test transformed class
	    testTransformed(fc);
	}

    

    /**
     * Compares two objects by class and value.
     * <p>
     * The classes in question need to implement {@link Comparable}.
     * 
     * @param expected  an object.
     * @param actual    an object to compare to {@code expected}.
     * @return          {@code true} if both operands are of the same class, and their
     *                  {@link Comparable#compareTo(Object)} returns 0 (value equality).
     */
    protected boolean classValueCompare(Object expected, Object actual) {
        Class<?> expectedClass = expected.getClass();
        if (expectedClass != actual.getClass()) {
            return false;
        }

        return expected.toString().equals(actual.toString());
    }

    
    
    /**
     * Compares the actual result of a test to the expected, failing if the actual result differs from the expected.
     * 
     * @param message   the message to report if the comparison fails.
     * @param expected  the expected result.
     * @param actual    the actual result.
     */
    protected void compareResult(String message, String expected, String actual) {
        if (!checkEquals(expected, actual)) {
            assertEquals(message, expected, actual);
        }
    }

    

    /**
     * Gets the classes of an array of objects.
     * 
     * @param objects   an array of objects.
     * @return          an array of the classes of {@code objects}.
     */
    protected static Class<?>[] unwrapClasses(Object[] objects) {
        Class<?>[] types = new Class[objects.length];

        for (int i = 0; i < objects.length; i++) {
            types[i] = unwrapClass(objects[i].getClass());
        }
        return types;
    }

    
    
    /* ============= *
     *  Test types.  *
     * ============= */

    /**
     * Performs tests on the options' registry.
     * 
     * @return  {@code true} if the test case should top after this method.
     */
    public boolean testOptions(OptionRegistry options) {
        return false;
    }

    

	/**
	 * Perform tests on the set of semantic problems found in the instance tree.
	 * 
	 * Default implementation fails if any errors other than COMPLIANCE were found, and returns false otherwise.
	 * 
	 * @return  <code>true</code> if test case shoule stop after this method
	 */
	protected boolean testSemanticProblems(Collection<Problem> problems) {
		return testProblems(problems);
	}

    

    /**
     * Perform tests on instantiated class.
     * 
     * @return  <code>true</code> if test case should stop after this method
     */
    protected boolean testInstantiated(InstClassDecl icd) {
        return false;
    }

    

	/**
	 * Perform tests on flattened class.
	 * 
	 * @return  <code>true</code> if test case should stop after this method
	 */
	protected boolean testFlattened(FClass fc) {
		return false;
	}

    

	/**
	 * Perform tests on flat class after transform canonical step.
	 * 
	 * @return  <code>true</code> if test case should stop after this method
	 */
	protected boolean testTransformed(FClass fc) {
		return false;
	}

    

    /**
    * Perform tests on source tree.
    *
    * @return  <code>true</code> if test case should stop after this method
    */
    protected boolean testSource(SourceRoot sr) {
        return false;
    }

    

	/**
	 * Perform tests on the set of semantic problems found after transform canonical step.
	 * 
	 * Default implementation fails if any errors other than COMPLIANCE were found, and returns false otherwise.
	 * 
	 * @return  <code>true</code> if test case shoule stop after this method
	 */
	protected boolean testTransformedProblems(Collection<Problem> problems) {
		return testProblems(problems);
	}

    
	
	/**
	 * Perform tests on a set of semantic problems.
	 * 
	 * Default implementation fails if any errors other than COMPLIANCE were found, and returns false otherwise.
	 * 
	 * @return  <code>true</code> if test case should stop after this method
	 */
	protected boolean testProblems(Collection<Problem> problems) {
		filterProblems(problems);
		if (problems.size() > 0)
			fail(new CompilerException(problems));
		return false;
	}

    
	
	/**
	 * Filters out any uninteresting problems from a set of semantic problems.
	 * 
	 * Default implementation removes any warnings and any COMPLIANCE errors.
	 */
	protected void filterProblems(Collection<Problem> problems) {
		for (Iterator<Problem> it = problems.iterator(); it.hasNext(); )
			if (!it.next().isTestError(checkAll))
				it.remove();
	}

    

    private static final Pattern PAT_ERROR_LINE = 
            Pattern.compile("at line ([0-9]+)(, column [0-9]+, in file '([^']+)')");

    

    /**
     * Adjust line number in error messages to be relative to the beginning of 
     * the class rather than beginning of the file.
     */
    public static String adjustErrorLines(String str, String file, int beginLine) {
        StringBuffer buf = new StringBuffer();
        Matcher m = PAT_ERROR_LINE.matcher(str);
        while (m.find()) {
            // If error is in the same file adjust line, else no change
            if (file.equals(m.group(3))) {
                int line = Integer.parseInt(m.group(1)) - beginLine + 1;
                m.appendReplacement(buf, "at line " + line + "$2");
            } else {
                m.appendReplacement(buf, "$0");
            }
        }
        m.appendTail(buf);
        return buf.toString();
    }

    

	/**
	 * Compare a flat class to a pretty-printed correct model and fail if different.
	 */
	protected void testPrettyPrint(FClass fc, String correct) {
		TokenTester tt = new TokenTester();
		String test = fc.prettyPrint("");
		if (!tt.test(test, correct)) {
			String diff = tt.firstDiff();
			String err = "Flat class does not match expected.";
			assertEquals(err, correct, test);
		}
	}

    
	
	/**
	 * Sort lines in string alphabetically.
	 */
	protected String sortLines(String str) {
		String[] lines = str.split("\n|\r|\r\n");
		Arrays.sort(lines);
		StringBuilder buf = new StringBuilder();
		for (String line : lines) {
			buf.append(line);
			buf.append('\n');
		}
		return buf.toString();
	}

    

    /**
     * Allows us to switch parser.
     */
    protected ParserHandler getParserHandler() {
        return PARSER_HANDLER;
    }


}
