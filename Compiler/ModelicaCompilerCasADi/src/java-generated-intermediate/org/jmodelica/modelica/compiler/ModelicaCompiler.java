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
 * @aspect ExternalConstantEvaluation
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:49
 */
public class ModelicaCompiler extends java.lang.Object implements ExternalProcessMultiCache.Compiler<ExternalArgument, FExternalStmt>, LogContainer {
    public String compileExternal(FExternalStmt ext) throws FileNotFoundException, CcodeCompilationException {
        String executable = null;
        if (outDir == null)
            setRandomOutDir();
        String source = ext.getName().replace(".", "_");
        TargetObject target = createTargetObject("ceval", "0.1");
        Set<String> incDirs = new LinkedHashSet<String>();
        Set<String> libs    = new LinkedHashSet<String>();
        Set<String> libDirs = new LinkedHashSet<String>();
        
        ext.externalDependencies(null, incDirs, libs, libDirs);
        
        OptionRegistry options = ext.myOptions();
        ModulesSettings modulesSettings = createModulesSettings(options);
        
        target.getTemplates(options).generateCFiles(ModelicaCompiler.this, null, createCGenerator(ext), sourceDir, source);
        
        CCompilerDelegator ccompiler = getCCompiler();
        ccompiler.setModuleLibraryNames(modulesSettings.getLibraryNames());
        
        CCompilerArguments ccArgs = new CCompilerArguments(source, options, target,
                libs, libDirs, incDirs);
        executable = ccompiler.compileCCodeLocal(ModelicaCompiler.log, ccArgs, outDir);
        new File(sourceDir, source + ".c").delete();
        return executable;
    }

    protected ExternalFunctionCache externalFunctionCache = new ExternalFunctionCache(this);

    public ExternalFunctionCache getExternalFunctionCache() {
        return externalFunctionCache;
    }

    private ParserHandler parserHandler = new ParserHandler();

    public ParserHandler getParserHandler() {
        return parserHandler;
    }

    public void setParserHandler(ParserHandler parserHandler) {
        this.parserHandler = parserHandler;
    }

    UtilInterface createUtilInterface() {
        return UtilInterface.create(this);
    }

    
    
    public static final Level DEFAULT_LEVEL = Level.ERROR;

    
    protected static ModelicaLogger log = new StreamingLogger(ModelicaCompiler.DEFAULT_LEVEL, System.out);

    
    
    private CCompilerDelegator delegator = null;

    
    private String delegator_name = null;

    
    private OptionRegistry options = null;

    
    private DiagnosticsGenerator diagGenerator = null;

    
    
    protected boolean dumpMemoryUse = false;

    
    protected int dumpMemoryUseMinSize = 2 * 1024;

    
    protected boolean findFlatToInstanceLinks = false;

    
    
    // If true, assume that JMODELICA_HOME points to the source folder - for easier debugging while developing
    protected boolean debugSrcIsHome = false;

    
    public void setDebugSrcIsHome(boolean b) {
        debugSrcIsHome = b;
    }

    
    
    protected static LinkedList<CompilationHooks> globalHooksList = new LinkedList<CompilationHooks>();

    
    protected LinkedList<CompilationHooks> hooksList = new LinkedList<CompilationHooks>(globalHooksList);

    
    
    protected File tempDir = null;

    
    protected File outDir = null;

    
    protected File sourceDir = null;

    
    protected File resourceDir = null;

    
    
    protected String[] targetPlatforms = null;

    
    protected Collection<Problem> warnings = new ArrayList<Problem>();

    

    private static final String OPTION_EXPORT_TEMPLATE = "==OPTIONS-LIST==";

    

    /**
     * Exports default options to XML.
     */
    public static class OptionExporter {
        /**
         * Exports list of options.
         * 
         * Allowed arguments:
         *   -x <file>    export as XML to <file>
         *   -d <file>    export as DocBook table to <file>
         *   -p <file>    export as plain text table to <file>
         *   -t <file>    next export argument will use <file> as a template, replacing any line containing 
         *                the value of <code>OPTION_EXPORT_TEMPLATE</code> with generated output
         * 
         * For the last export type argument given, the file argument may be ommited, 
         * in that case it is printed on stdout.
         */
        public static void main(String[] args) {
            OptionRegistry or = createOptions();
            Type t = null;
            BufferedReader tmpl = null;
            for (String arg : args) {
                if (t == null) {
                    t = type(arg);
                } else {
                    if (t == Type.Template) {
                        try {
                            tmpl = new BufferedReader(new FileReader(arg));
                        } catch (FileNotFoundException e) {
                            System.err.println("Could not open template file for reading: " + e.getMessage());
                        }
                    } else {
                        try {
                            PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream(arg)));
                            if (tmpl != null) {
                                String line = tmpl.readLine();
                                while (line != null) {
                                    if (line.contains(OPTION_EXPORT_TEMPLATE)) {
                                        emit(t, or, out);
                                    } else {
                                        out.println(line);
                                    }
                                    line = tmpl.readLine();
                                }
                            } else {
                                emit(t, or, out);
                            }
                            out.close();
                        } catch (FileNotFoundException e) {
                            System.err.println("Could not open file for writing: " + e.getMessage());
                        } catch (IOException e) {
                        }
                        tmpl = null;
                    }
                    t = null;
                }
            }
            if (t != null) {
                emit(t, or, System.out);
            }
        }
        
        private static void emit(Type t, OptionRegistry or, PrintStream out) {
            switch (t) {
            case XML:
                or.exportXML(out, OptionRegistry.Category.experimental);
                break;
            case DocBook:
                or.exportDocBook(out, OptionRegistry.Category.experimental);
                break;
            case PlainText:
                or.exportPlainText(out, OptionRegistry.Category.experimental);
                break;
            case Template:
                throw new IllegalArgumentException();
            }
        }
        
        private static Type type(String arg) {
            if (arg.equals("-x")) {
                return Type.XML;
            } else if (arg.equals("-d")) {
                return Type.DocBook;
            } else if (arg.equals("-p")) {
                return Type.PlainText;
            } else if (arg.equals("-t")) {
                return Type.Template;
            } else {
                System.err.println("Unknown output type argument: " + arg);
                return null;
            }
        }
        
        private enum Type {
            XML, DocBook, PlainText, Template;
        }
    }

    
    
    /**
     * Basic export of all known problem types
     */
    public static class ProblemExporter {
        public static void main(String[] args) {
            ASTNode node = new ASTNode(); // Dummy read to initialize all of the producers
            ProblemProducer.exportXML(new PrintStream(System.out));
        }
    }

    

    public static OptionRegistry createOptions() {
        OptionRegistry res = new OptionRegistry() {};
        OptionsAggregated.addTo(res);
        return res;
    }

    

    public static ModulesSettings createModulesSettings(OptionRegistry options)    
    {
       return new ModulesSettings(options);
    }

    

    public ModelicaCompiler(OptionRegistry options) {
        this.options = options;
    }

    

    protected ModelicaCompiler() {}

    

    public CCompilerDelegator getCCompiler() {
        String c_compiler = options.getStringOption(CCompilerDelegator.OPTION);
        if (delegator == null || !c_compiler.equals(delegator_name)) {
            delegator_name = c_compiler;
            delegator = CCompilerDelegator.delegatorFor(c_compiler);
        }
        return delegator;
    }

    
    
    public static <T extends CompilationHooks> T addGlobalCompilationHooks(T hooks) {
        globalHooksList.add(hooks);
        return hooks;
    }

    
    
    public static void removeGlobalCompilationHooks(CompilationHooks hooks) {
        globalHooksList.remove(hooks);
    }

    
    
    public <T extends CompilationHooks> T addCompilationHooks(T hooks) {
        hooksList.add(hooks);
        return hooks;
    }

    
    
    public void removeCompilationHooks(CompilationHooks hooks) {
        hooksList.remove(hooks);
    }

    
    
    protected IErrorHandler errorHandler = null;

    
    
    /**
     * Set the error handler to use for collection errors.
     * Passing <code>null</code> resets to default.
     */
    public void setErrorHandler(IErrorHandler eh) {
        errorHandler = eh;
    }

    
    
    public IErrorHandler getErrorHandler() {
        return errorHandler;
    }

    
    
    /**
     * Throws a {@link CompilationAbortedException} if any hooks class signals an abort.
     */
    protected void hookCheckAbort() {
        for (CompilationHooks hooks : hooksList) {
            if (hooks.shouldAbort(this)) {
                log.info("Compilation aborted.");
                throw new CompilationAbortedException();
            }
        }
    }

    
    
    /**
     * Calls the hook to be called after the supplied code files are parsed.
     */
    protected void hookFilesParsed(SourceRoot sr) {
        for (CompilationHooks hooks : hooksList)
            hooks.filesParsed(this, sr);
    }

    
    
    /**
     * Calls the hook to be called after the error checks on the instantiated 
     * model are finished without errors.
     */
    protected void hookModelInstantiatied(InstClassDecl icd) {
        for (CompilationHooks hooks : hooksList)
            hooks.modelInstantiatied(this, icd);
    }

    
    
    /**
     * Calls the hook to be called after the model is flattened.
     */
    protected void hookModelFlattened(FClass fc) {
        for (CompilationHooks hooks : hooksList)
            hooks.modelFlattened(this, fc);
    }

    
    
    /**
     * Calls the hook to be called after transformations are applied to the model.
     */
    protected void hookModelTransformed(FClass fc) {
        for (CompilationHooks hooks : hooksList)
            hooks.modelTransformed(this, fc);
    }

    
    
    /**
     * Calls the hook to be called after error checks of the flat model are 
     * finished without errors.
     */
    protected void hookFlatModelChecked(FClass fc) {
        for (CompilationHooks hooks : hooksList)
            hooks.flatModelChecked(this, fc);
    }

    
    
    /**
     * Calls the hook to be called after a code generator is created.
     */
    protected void hookCodeGeneratorCreated(AbstractGenerator gen) {
        for (CompilationHooks hooks : hooksList)
            hooks.codeGeneratorCreated(this, gen);
    }

    
    
    /**
     * Calls the hook to be called after output code is generated.
     */
    protected void hookCodeGenerated(File dir) {
        for (CompilationHooks hooks : hooksList)
            hooks.codeGenerated(this, dir);
    }

    
    
    /**
     * Calls the hook to be called after the generated C code is compiled.
     */
    protected void hookCodeCompiled() {
        for (CompilationHooks hooks : hooksList)
            hooks.codeCompiled(this);
    }

    
    
    /**
     * Calls the hook to be called after the FMU is packed.
     */
    protected void hookFmuPacked(FClass fc, File path) {
        for (CompilationHooks hooks : hooksList)
            hooks.fmuPacked(this, fc, path);
    }

    
    
    public String getStringOption(String key) throws UnknownOptionException {
        return options.getStringOption(key);
    }

    
    
    public void setStringOption(String key, String value) throws UnknownOptionException {
        options.setStringOption(key,value);
    }

    
    
    public int getIntegerOption(String key) throws UnknownOptionException {
        return options.getIntegerOption(key);
    }

    
    
    public void setIntegerOption(String key, int value) throws UnknownOptionException {
        options.setIntegerOption(key, value);
    }

    
    
    public double getRealOption(String key) throws UnknownOptionException {
        return options.getRealOption(key);
    }

    
    
    public void setRealOption(String key, double value) throws UnknownOptionException {
        options.setRealOption(key, value);
    }

    
    
    public boolean getBooleanOption(String key) throws UnknownOptionException{
        return options.getBooleanOption(key);
    }

    
    
    public void setBooleanOption(String key, boolean value) throws UnknownOptionException {
        options.setBooleanOption(key, value);
    }

    

    public void setDiagnosticsGenerator(DiagnosticsGenerator diagGenerator) {
        this.diagGenerator = diagGenerator;
    }

    

    public DiagnosticsGenerator getDiagnosticsGenerator() {
        return this.diagGenerator;
    }

    
    
    public String getOptionDescription(String key) throws UnknownOptionException {
        return options.getDescription(key);
    }

    
    
    public boolean willDumpMemoryUse() {
        return dumpMemoryUse;
    }

    

    public void setDumpMemoryUse(boolean dump) {
        dumpMemoryUse = dump;
    }

    

    public void setDumpMemoryUse(boolean dump, int minSize) {
        dumpMemoryUse = dump;
        dumpMemoryUseMinSize = minSize;
    }

    

    public void setDumpMemoryUse(boolean dump, String minSize) {
        if (minSize == null || minSize.isEmpty())
            setDumpMemoryUse(dump);
        else
            setDumpMemoryUse(dump, (int) ASTNode.parseMem(minSize));
    }

    
    
    public boolean willFindFlatToInstanceLinks() {
        return findFlatToInstanceLinks;
    }

    

    public void setFindFlatToInstanceLinks(boolean find) {
        findFlatToInstanceLinks = find;
    }

    

    /**
     * Returns the modelicapath attribute set for this compiler instance.
     * 
     * @return Reference to the modelicapath attribute. 
     * 
     */
    public String getModelicapath() {
        return options.getStringOption("MODELICAPATH");
    }

    
    
    /**
     * Set the modelicapath attribute.
     * 
     * @param path The new modelicapath.
     */
    public void setModelicapath(String path) {
        options.setStringOption("MODELICAPATH", path);
    }

    

    protected final static int NUM_USED_MEMORY_SLOTS = 6;

    
    protected long[] usedMem = new long[NUM_USED_MEMORY_SLOTS];

    
    protected int numUsedMemFilled;

    
    protected long timeCompilationStarted;

    

    /**
     * Initilize vars gathering debug information about compilation.
     * 
     * Should be called before compilation process begins.
     */
    protected void resetCompilationInfo() {
        timeCompilationStarted = System.currentTimeMillis();
        numUsedMemFilled = 0;
    }

    
    
    /**
     * Log debug information about compilation.
     * 
     * Should be called after compilation process ends.
     */
    protected void logCompilationInfo() {
        long time = System.currentTimeMillis() - timeCompilationStarted;
        double time2 = Math.round(time / 10.0) / 100.0;
        log.debug("Compilation took " + time2 + " s");
        
        noteUsedMemory();  // Needed if an exception occurred
        int numFinishedSteps = numUsedMemFilled / 2;
        if (numFinishedSteps > 0) {
            log.debug("Changes in memory use:");
            logMemoryUseForStep("parseModel", 0);
        }
        if (numFinishedSteps > 1)
            logMemoryUseForStep("instantiateModel", 1);
        if (numFinishedSteps > 2)
            logMemoryUseForStep("flattenModel", 2);
    }

    
    
    /**
     * Log memory change for a single compilation step.
     * 
     * Called by {@link #logCompilationInfo()}.
     * 
     * @param name   the name of the step
     * @param index  the index of the step (0-2)
     */
    protected void logMemoryUseForStep(String name, int index) {
        String mem = ASTNode.formatMem((int) (usedMem[2 * index + 1] - usedMem[2 * index]));
        log.debug(String.format(" %-19s %8s", name + "():", mem));
    }

    
    
    /**
     * Saves away the current amount of memory used.
     */
    protected void noteUsedMemory() {
        if (numUsedMemFilled < NUM_USED_MEMORY_SLOTS)
            usedMem[numUsedMemFilled++] = getUsedMemory();
    }

    
    
    private static final Runtime RUNTIME = Runtime.getRuntime();

    
    
    /**
     * Get the amount of memory currently used.
     * 
     * This includes objects that are no longer reachable but not yet garbage collected.
     */
    public static long getUsedMemory() {
        return RUNTIME.totalMemory() - RUNTIME.freeMemory();
    }

    

    /**
     * Save a dump of the memory use of an AST.
     * 
     * The dump will be saved in a file named <code>"size_" + type + ".txt"</code>.
     * 
     * @param root   the root of the AST to dump memory use for
     * @param type   a one-word description of the tree to dump
     * @param count  it node counts should also be generated
     */
    protected void dumpMemoryUseFile(ASTNode root, String type, boolean count) throws FileNotFoundException {
        dumpMemoryUseFile(root, type, type, count);
    }

    

    /**
     * Save a dump of the memory use of an AST.
     * 
     * The dump will be saved in a file named <code>"size_" + name + ".txt"</code>.
     * 
     * @param root   the root of the AST to dump memory use for
     * @param type   a short description of the tree to dump
     * @param name   the variable part of the file name
     * @param count  it node counts should also be generated
     */
    protected void dumpMemoryUseFile(ASTNode root, String type, String name, boolean count) 
            throws FileNotFoundException {
        if (dumpMemoryUse) {
            String file = "size_" + name + ".txt";
            log.debug("Dumping " + type + " tree to '" + file + "'...");
            long time = System.currentTimeMillis();
            root.dumpMemoryUse(file, true, -1, dumpMemoryUseMinSize);
            time = Math.round((System.currentTimeMillis() - time) / 1000.0);
            if (count)
                root.buildNodeCount();
            log.debug(" Dumped tree in " + time + "s");
        }
    }

    

    /**
     * Save a dump of the node class counts of an AST (or several).
     * 
     * The dump will be saved in a file named <code>"node_count.txt"</code>.
     */
    protected void dumpNodeCountFile() 
            throws IOException {
        if (dumpMemoryUse) {
            String file = "node_count.txt";
            log.debug("Dumping node counts to '" + file + "'...");
            ASTNode.dumpNodeCount(file);
        }
    }

    

    /**
     * Find any links from the flat tree to the instance tree.
     */
    protected void findFlatToInstanceLinks(FClass fc) {
        if (findFlatToInstanceLinks) {
            log.warning("Searching memory graph for flat tree for links to instance tree...");
            new MemorySpider(new MemorySpider.ClassFilteredVisitor<InstRoot>(InstRoot.class) {
                protected void visitFiltered(InstRoot ir, Stack<MemorySpider.Frame> path) {
                    Root root = null;
                    int first = -1;
                    int last = -1;
                    for (int i = 0; last < 0 && i < path.size(); i++) {
                        Object obj = path.get(i).getObject();
                        if (obj instanceof BaseNode) {
                            BaseNode n = (BaseNode) obj;
                            try {
                                if (first < 0) {
                                    root = n.root();
                                    first = i;
                                } else if (root != n.root()) {
                                    last = i;
                                } else {
                                    first = i;
                                }
                            } catch (Exception e) {}
                        }
                    }
                    log.error("Found link to instance tree, starting at: " + path.get(first).name());
                    for (int i = first + 1; i <= last; i++)
                        log.error("  " + path.get(i));
                    throw new IllegalArgumentException();
                }
            }).traverse(fc);
            log.warning("Done.");
        }
    }

    
    
    /**
     * Creates a target object.
     * 
     * @param target The type of target: me, cs, ect. Use nocodegen for a NOCODEGEN target.
     * @param version The version in case of a fmu. Use null for a NOCODEGEN.
     */
    public TargetObject createTargetObject(String target, String version) {
        return TargetObject.getTarget(target, version);
    }

    

    /**
     * Compiles a model and creates an FMU, convenience method for compileUnit that uses default version.
     * <p>
     * Compiles a model (parsing, instantiating, flattening, code generation and 
     * binary file compilation) and packs the result in a FMU.
     * 
     * @param className name of model class in the model file to compile.
     * @param fileName  array of model file or library paths.
     * @param target    the compiler target. Valid options are 'me' or 'cs'.
     * @param compileTo specify location of the compiled FMU. If a file is specified, the model will be renamed to this
     *                  name during the compilation. If directory, the  model will keep its original name.
     * @return          a {@link CompiledUnit} result object.
     */
    public CompiledUnit compileFMU(String className, String fileName[], String target, String compileTo) 
            throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {

        return compileUnit(className, fileName, target, "1.0" , compileTo);
    }

    

    /**
     * Compiles a model and creates an FMUX, convenience method for compileUnit.
     * <p>
     * Compiles a model (parsing, instantiating, flattening and XML code 
     * generation) and packs the result in a FMUX.
     * 
     * @param className name of model class in the model file to compile.
     * @param fileName  array of model file or library paths.
     * @param compileTo specify location of the compiled FMUX. If a file is specified, the model will be renamed to this
     *                  name during the compilation. If directory, the  model will keep its original name.
     * @return          a {@link CompiledUnit} result object.
     */
    public CompiledUnit compileFMUX(String className, String fileName[], String compileTo) 
            throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {

        return compileUnit(className, fileName, "fmux", null , compileTo);
    }

    

    /**
     * Compiles a FMU or FMUX. Is a wrapper.
     * <p>
     * Compiles a model (parsing, instantiating, flattening, code generation and 
     * binary file compilation) and packs the result in a FMU/FMUX.
     * 
     * @param className name of model class in the model file to compile.
     * @param fileName  array of model file or library paths.
     * @param target    the compiler target. Valid options are 'me' or 'cs'.
     * @param version   the FMI version. Valid options are '1.0' or '2.0'.
     * @param compileTo specify location of the compiled FMU/FMUX. If a file is specified, the model will be renamed to
     *                  this name during the compilation. If directory, the  model will keep its original name.
     * @return          a {@link CompiledUnit} result object.
     */
    public CompiledUnit compileUnit(String className, String fileName[], String target, String version, String compileTo) 
            throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {

        TargetObject targetObject = TargetObject.getTarget(target, version);
        return compileUnit(className, fileName, targetObject, compileTo);
    }

    

    /**
     * Compiles a FMU or FMUX.
     * 
     * @param className name of model class in the model file to compile.
     * @param fileName  array of model file or library paths.
     * @param target    target object, contains information about the target, its unit suffix for example.
     * @param compileTo specify location of the compiled FMU/FMUX. If a file is specified, the model will be renamed to
     *                  this name during the compilation. If directory, the  model will keep its original name.
     * @return          a {@link CompiledUnit} result object.
     */
    protected CompiledUnit compileUnit(String className, String fileName[], TargetObject target, String compileTo) 
            throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {

        /*
         * Always set certain options when compiling.
         * First save these options in the temporary options' registry to reset when compiling has finished.
         */
        OptionRegistry tempOptions = options.copy();

        /*
         * Set options for the target.
         */
        target.setDefaultOptions(options);

        boolean doTearDown = true;
        try {
            doTearDown = trySetUp();
            return doCompileUnit(className, fileName, target, compileTo);
        } finally {
            deleteOutDir();
            tryTearDown(doTearDown);

            /*
             * Reset all options.
             */
            options.copyAllOptions(tempOptions);
        }
    }

    

    protected CompiledUnit doCompileUnit(String className, String fileName[], TargetObject target, String compileTo) 
        throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {

        CompiledUnit unit = null;
        try {
            StepInfo.GC_BEFORE_MEM = options.getBooleanOption("debug_invoke_gc");

            if (outDir == null) {
                setRandomOutDir();
            }

            if (target.getMakeFileFlag() != null) {
                // Might be used by constant evaluation.
                CCompilerDelegator ccompiler = getCCompiler();
                ccompiler.setTargetPlatforms(targetPlatforms);

                // Get loadable module settings.
                ModulesSettings modulesSettings = createModulesSettings(options);
                ccompiler.setModuleLibraryNames(modulesSettings.getLibraryNames());
            }

            /*
             * Compile mo-file and generate code for all templates that are not null.
             */
            String flatName = null;
            File compileToPath = new File(compileTo);
            if (!compileToPath.isDirectory()) {
                flatName = compileToPath.getName();
                int i = flatName.lastIndexOf('.');
                if (i > 0)
                    flatName = flatName.substring(0, i);
            }
            FClass fc = compileModel(fileName, className, target, flatName, compileTo);

            if (!target.getCodeGenFlag()) {
                /*
                 * No code has been generated.
                 */
                return null;
            }

            /*
             * Compile C code if the Makefile flag is not null.
             */
            hookCheckAbort();
            doCompileCCode(target, fc, className, flatName);

            /*
             * Package unit.
             */
            ASTNode.beginStep("packUnit()");
            File unitPath = packUnit(className, target, fc);
            unit = log.logCompiledUnit(unitPath, warnings, fc.numberOfComponents());
            ASTNode.endStep("packUnit()");

        } finally {
            log.debug("Time usage and memory usage change during compilation steps:");
            ASTNode.getStepInfo().logReport();
            if (options.getBooleanOption("debug_csv_step_info"))
                ASTNode.getStepInfo().writeCSVFile(new File(FClass.removeModifiersFromClassName(className) + ".csv"));
        }
        
        return unit;
    }

    

    protected void parseFiles(String[] paths) {
        StepInfo.TimeItem time = new StepInfo.TimeItem();
        time.begin();
        File[] files = new File[paths.length];
        for (int i = 0; i < paths.length; i++)
            files[i] = new File(paths[i]);
        parseFiles(files, true);
        time.end();
        log.info("Total time: " + time);
    }

    

    private void parseFiles(File[] files, boolean all) {
        for (File file : files) {
            if (file.isDirectory()) {
                parseFiles(file.listFiles(), false);
            } else {
                String path = file.getPath();
                try {
                    if (all || hasModelicaFileExt(path)) {
                        parseModel(path);
                        log.info(file + " parsed OK.");
                    }
                } catch (CompilerException e) {
                    log.logCompilerException(e);
                } catch (FileNotFoundException e) {
                    log.error("Could not find file: " + e.getMessage());
                } catch (IOException e) {
                    log.error("Error opening file: " + e.getMessage());
                } catch (Exception e) {
                    log.error("Parser thew an exception on file " + path + ":\n" + e);
                }
            }
        }
    }

    
    
    public boolean hasModelicaFileExt(String file) {
        return file.endsWith(".mo");
    }

    

    private static final int ZIP_BUFFER_SIZE = 2048;

    
    

    /**
     * Write all files in a directory and its subdirectories to a zip stream.
     * 
     * @param dir     directory to zip
     * @param out     zip stream to write to
     */
    protected void zipDir(File dir, ZipOutputStream out) {
        zipDir(dir, out, null);
    }

    

    /**
     * Write all files in a directory and its subdirectories to a zip stream.
     * 
     * @param dir     directory to zip
     * @param out     zip stream to write to
     * @param zipDir  directory within the zip file to write to, or <code>null</code> for the root
     */
    protected void zipDir(File dir, ZipOutputStream out, File zipDir) {
        zipDir(dir, out, zipDir, new byte[ZIP_BUFFER_SIZE]);
    }

    
    
    /**
     * Write all files in a directory and its subdirectories to a zip stream.
     * 
     * @param dir     directory to zip
     * @param out     zip stream to write to
     * @param zipDir  directory within the zip file to write to, or <code>null</code> for the root
     * @param buffer  buffer to use when writing files
     */
    private void zipDir(File dir, ZipOutputStream out, File zipDir, byte[] buffer) {
        for (File f : dir.listFiles()) {
            File fz = new File(zipDir, f.getName());
            try {
                if (f.isDirectory()) {
                    out.putNextEntry(new ZipEntry(fz.getPath() + "/"));
                    zipDir(f, out, fz, buffer);
                } else {
                    FileInputStream in = new FileInputStream(f);
                    out.putNextEntry(new ZipEntry(fz.getPath()));
                    for (int n; (n = in.read(buffer, 0, buffer.length)) != -1; ) 
                        out.write(buffer, 0, n);
                    in.close();
                }
            } catch (FileNotFoundException e) {
                // Should only occur in weird cases - ignore and skip this file
            } catch (IOException e) {
                // TODO: this should result in an error message about failing to zip file
                e.printStackTrace();
            }
        }
    }

    

    /**
     * Parses a model and returns a reference to the root of the source tree.
     * Options related to the compilation are also loaded here and added to the
     * source tree representation.
     * 
     * @param name
     *            The name of the model file.
     *
     * @return The root of the source tree.
     * 
     * @throws beaver.Parser.Exception
     *             If there was an Beaver parsing exception.
     * @throws CompilerException
     *             If errors have been found during the parsing.
     * @throws FileNotFoundException
     *             If the model file can not be found.
     * @throws IOException
     *             If there was an error reading the model file. (Beaver exception.)
     */
    private SourceRoot parseModel(String name) 
      throws FileNotFoundException, IOException, beaver.Parser.Exception, CompilerException{
        return parserHandler.parseModel(createUtilInterface(), name);
    }

    

    /**
     * 
     * Parses a set of files and returns a reference to the root of a source tree
     * where the content of all files is contained. Each file is parsed using
     * the parseModel method.
     * 
     * @param names
     *            An array of file names.
     *
     * @return The root of the source tree.
     * 
     * @throws beaver.Parser.Exception
     *             If there was a Beaver parsing exception.
     * @throws CompilerException
     *             If errors have been found during the parsing.
     * @throws FileNotFoundException
     *             If the model file could not be found.
     * @throws IOException
     *             If there was an error reading the model file. (Beaver exception.)
     */
    public SourceRoot parseModel(String names[]) 
      throws FileNotFoundException, IOException, beaver.Parser.Exception, CompilerException {
        hookCheckAbort();
        boolean doTearDown = true;
        try {
            doTearDown = trySetUp();
            return doParseModel(names);
        } finally {
            tryTearDown(doTearDown);
        }
    }

    

    /**
     * Parses a string and returns a reference to the root of the source tree. 
     * Options related to the compilation are also loaded here and added to the 
     * source tree representation.
     * 
     * @param code
     *            Modelica code to parse.
     * @param name
     *            The filename (or other description) to use when reporting errors.
     *
     * @return The root of the source tree.
     * 
     * @throws beaver.Parser.Exception
     *             If there was an Beaver parsing exception.
     * @throws CompilerException
     *             If errors have been found during the parsing.
     * @throws IOException
     *             If there was an error reading the model file. (Beaver exception.)
     */
    public SourceRoot parseString(String code, String name) 
      throws IOException, beaver.Parser.Exception, CompilerException {
        checkSetUp();
        return parserHandler.parseString(createUtilInterface(), code, name);
    }

    

    public SourceRoot doParseModel(String names[]) 
      throws FileNotFoundException, IOException, beaver.Parser.Exception, CompilerException {
        checkSetUp();
        ASTNode.getStepInfo().reset();
        ASTNode.beginStep("parseModel()");
        SourceRoot sr = parserHandler.parseModel(createUtilInterface(), names);
        hookFilesParsed(sr);
        ASTNode.endStep("parseModel()");
        
        return sr;
    }

    
    
    /**
     * Parses and instantiated the model <code>cl</code> from the source files <code>name</code>.
     * 
     * @param name
     *            Array of model file or library paths.
     * @param cl
     *            The name of the class in the model file to compile.
     * @param target
     *            The model represenation type the model should be compiled to.
     * 
     * @throws ModelicaException
     *             If errors have been found during the parsing, instantiation
     *             or flattening.
     * @throws FileNotFoundException
     *             If the model file can not be found.
     * @throws IOException
     *             If there was an error creating the .mof file.
     * @throws beaver.Parser.Exception
     *             If there was an Beaver parsing exception.
     */
    private InstClassDecl instantiateModel(String name[], String cl, TargetObject target)
            throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {
        // build source tree
        SourceRoot sr = parseModel(name);
        dumpMemoryUseFile(sr, "source", false);

        if (options.getBooleanOption("generate_html_diagnostics")) {
            setDiagnosticsGenerator(new DiagnosticsGenerator(cl));
        }

        // compute instance tree
        InstClassDecl icl = instantiateModel(sr, cl, target);
        
        dumpMemoryUseFile(sr, "source and instance", "instance", true);
        
        return icl;
    }

    

    /**
     * Computes a model instance tree from a source tree. Some error checks such
     * as type checking is performed during the computation.
     * 
     * @param sr
     *            The reference to the model source root.
     * @param cl
     *            The name of the class in the model file to compile.
     * @param target
     *            The model represenation type the model should be compiled to.
     * 
     * @return The instance node corresponding to the instantiated model.
     * 
     * @throws CompilerException
     *             If errors have been found during the instantiation.
     * @throws ModelicaClassNotFoundException
     *             If the Modelica class to instantiate is not found.
     */
    public InstClassDecl instantiateModel(SourceRoot sr, String cl, TargetObject target) 
        throws ModelicaClassNotFoundException, CompilerException {
        hookCheckAbort();
        boolean doTearDown = true;
        try {
            doTearDown = trySetUp(sr.getErrorHandler());
            return doInstantiateModel(sr, cl, target);
        } finally {
            tryTearDown(doTearDown);
        }
    }

    
    
    public InstClassDecl doInstantiateModel(SourceRoot sr, String cl, TargetObject target) 
        throws ModelicaClassNotFoundException, CompilerException {
        
        ASTNode.beginStep("instantiateModel()");
        
        InstProgramRoot ipr = sr.getProgram().getInstProgramRoot();
        
        log.info("Checking for errors...");
        InstClassDecl icd = ipr.instantiateModel(cl);
        try {
            icd.checkErrorsInModelInstance(cl, target.getCheckType());
        } finally {
            handleCompilerWarnings(sr.collectWarnings());
        }
        
        hookModelInstantiatied(icd);
        ASTNode.endStep("instantiateModel()");
        
        return icd;
    }

    

    protected void handleCompilerWarnings(Collection<Problem> warnings) throws CompilerException {
        if (options.getBooleanOption("generate_html_diagnostics") && getDiagnosticsGenerator() != null) 
            getDiagnosticsGenerator().writeProblems(warnings);
        
        if (!warnings.isEmpty()) {
            log.logProblems(warnings);
            this.warnings.addAll(warnings);
        }
    }

    
    
    /**
     * Retrieves a list of warnings and clear the internal list.
    */
    public Problem[] retrieveAndClearWarnings() {
        Problem[] oldWarnings = warnings.toArray(new Problem[warnings.size()]);
        warnings = new ArrayList<Problem>();
        return oldWarnings;
    }

    

    /**
     * Please use the correctly spelled version!
     */
    @Deprecated
    public Problem[] retreiveAndClearWarnings() {
        return retrieveAndClearWarnings();
    }

    

    /**
     * Computes the flattened model representation from a model instance.
     * 
     * @param icd
     *            A reference to the model instance node.
     * @param target
     *            The model represenation type the model should be compiled to.
     * @param flatName
     *            Name of the unit/flat model supplied by the user, if any.
     * 
     * @return FClass object representing the flattened model.
     * 
     * @throws CompilerException
     *             If errors have been found during the flattening.
     * @throws IOException
     *             If there was an error creating the .mof file.
     * @throws ModelicaClassNotFoundException
     *             If the Modelica class to flatten is not found.
     */
    public FClass flattenModel(InstClassDecl icd, TargetObject target, String flatName) 
            throws CompilerException, ModelicaClassNotFoundException, IOException {
        hookCheckAbort();
        boolean doTearDown = true;
        try {
            doTearDown = trySetUp(icd.root().getErrorHandler());
            PassAndForget<InstClassDecl> buf = new PassAndForget<InstClassDecl>(icd);
            icd = null;
            return doFlattenModel(buf.pass(), target, flatName);
        } finally {
            tryTearDown(doTearDown);
        }
    }

    
    
    public FClass doFlattenModel(InstClassDecl icd, TargetObject target, String flatName) 
            throws CompilerException, ModelicaClassNotFoundException, IOException {
        ASTNode.beginStep("flattenModel()");
        
        String instName = icd.qualifiedName();
        File flatFile = new File(sourceDir, (flatName == null ? instName : flatName) + ".mof");
        final FClass fc = FClass.create(icd, flatName);
        
        ASTNode.beginStep("flatten()");
        log.info("Flattening model...");
        icd.flattenInstClassDecl(fc);
        dumpMemoryUseFile(fc, "flat", true);
        dumpNodeCountFile();
        icd = null;
        ASTNode.endStep("flatten()");
        
        findFlatToInstanceLinks(fc);
        hookModelFlattened(fc);
        hookCheckAbort();
        
        // Output the untransformed flattened model
        ASTNode.beginStep("prettyPrintRawFlat()");
        if (fc.myOptions().getBooleanOption("generate_mof_files")) {
            log.debug("Creating raw .mof file...");
            CodeStream out = new CodeStream(flatFile);
            fc.prettyPrint_MC(out, "");
            out.close();
            log.debug("... raw .mof file created.");
        }

        log.verbose("Raw flattened model:");
        log.verbose(fc);
        ASTNode.endStep("prettyPrintRawFlat()");

        if (fc.myOptions().getBooleanOption("generate_html_diagnostics") && getDiagnosticsGenerator()!=null) {
            ASTNode.beginStep("htmlDiagnostics()");
            getDiagnosticsGenerator().writeRawFlattenedModel(fc);
            getDiagnosticsGenerator().setModelDiagnosticsBeforeTransform(fc.modelDiagnostics());
            ASTNode.endStep("htmlDiagnostics()");
        }
        
        fc.transformCanonical();
        
        /* Temporary fix to problems with long compilation times due to later evaluations */
        getExternalFunctionCache().tearDown();
        fc.myOptions().setIntegerOption("external_constant_evaluation", 0);
        
        hookModelTransformed(fc);
        hookCheckAbort();
        
        ASTNode.beginStep("prettyPrintFlat()");
        if (fc.myOptions().getBooleanOption("generate_mof_files")) {
            log.debug("Creating transformed .mof file...");
            CodeStream out = new CodeStream(new File(sourceDir, instName + "_transformed.mof"));
            fc.prettyPrint_MC(out, "");
            out.close();
            log.debug("... transformed .mof file created.");
        }
        
        log.verbose("Diagnostics for transformed flattened model:");
        log.verbose(new Object() {
            public String toString() {
                return fc.diagnostics();
            };
        });
        
        log.verbose("Transformed flattened model:");
        log.verbose(fc);
        
        ASTNode.endStep("prettyPrintFlat()");
        
        dumpMemoryUseFile(fc, "transformed", false);
        
        if (fc.myOptions().getBooleanOption("write_iteration_variables_to_file")) {
            ASTNode.beginStep("writeIterationVariables()");
            if (!fc.onlyInitBLT())
                fc.getDAEBLT().writeIterationVariablesToFile(new File(resourceDir, instName + "_iteration_variables.txt"));
            fc.getDAEInitBLT().writeIterationVariablesToFile(new File(resourceDir, instName + "_initial_system_iteration_variables.txt"));
            ASTNode.endStep("writeIterationVariables()");
        }
        
        if (fc.myOptions().getBooleanOption("write_tearing_pairs_to_file")) {
            ASTNode.beginStep("writeIterationVariables()");
            if (!fc.onlyInitBLT())
                fc.getDAEBLT().writeTearingPairsToFile(new File(instName + "_tearing_pairs.txt"));
            fc.getDAEInitBLT().writeTearingPairsToFile(new File(instName + "_initial_system_tearing_pairs.txt"));
            ASTNode.endStep("writeIterationVariables()");
        }
        
        fc.errorCheck(target.getCheckType());
        handleCompilerWarnings(fc.collectWarnings());
        
        if (fc.myOptions().getBooleanOption("generate_html_diagnostics") && getDiagnosticsGenerator()!=null) {
            ASTNode.beginStep("htmlDiagnostics()");
            getDiagnosticsGenerator().writeTransformedFlattenedModel(fc);
            getDiagnosticsGenerator().writeDiagnostics(fc);
            ASTNode.endStep("htmlDiagnostics()");
        }

        hookFlatModelChecked(fc);
        ASTNode.endStep("flattenModel()");

        return fc;
    }

    

    /**
     * Create a new CGenerator object.
     * 
     * Override for subclasses needing another subclass of CGenerator.
     */
    protected CGenerator createCGenerator(FClass fc) {
        return new CGenerator(ASTNode.prettyPrinter, '$', fc);
    }

    

    protected ExternCEvalGenerator createCGenerator(FExternalStmt ext) {
        CodeGenContext cgc = new CodeGenContext().createProxy();
        Map<String,String> tempMap = new HashMap<String,String>();
        return new ExternCEvalGenerator(ASTNode.prettyPrinter, '$', null, ext, cgc, tempMap);
    }

    

    /**
     * 
     * Generates XML and c code for a flattened model represented as an instance
     * of FClass using template files. The XML variables, XML values and c files
     * are given the default names <modelname>.xml, <modelname>_values.xml and 
     * <modelname>.c respectively.
     * 
     * @param fc
     *            The FClass instance for which the code generation should be
     *            computed.
     * @param target
     *            The target object for the compiler.
     * @throws FileNotFoundException
     *             If either of the three template files can not be found.
     */
    public void generateCode(FClass fc, TargetObject target) throws FileNotFoundException {
        boolean doTearDown = true;
        try {
            doTearDown = trySetUp(fc.root().getErrorHandler());
            doGenerateCode(fc, target);
        } finally {
            tryTearDown(doTearDown);
        }
    }

    
    
    public void doGenerateCode(FClass fc, TargetObject target) throws FileNotFoundException {
        ASTNode.beginStep("generateCode()");
        log.info("Generating code...");
        String name = fc.nameUnderscore();
        
        Templates templates = target.getTemplates(getOptions());
    
        templates.generateCFiles(this, fc, createCGenerator(fc), sourceDir, name);
        templates.generateXMLFiles(this, fc, target.getXMLGenerator(fc), outDir, "modelDescription");
        
        fc.guidManager().setSourceFile(new File(outDir, "modelDescription.xml"));
        fc.guidManager().processDependentFiles();
        
        hookCodeGenerated(outDir);
        log.debug("... code generated.");
        ASTNode.endStep("generateCode()");
    }

    
    
    /**
     * Set the default logger and default level.
     */
    public void setDefaultLogger() {
        try {
            setLogger(DEFAULT_LEVEL + "|stdout");
        } catch (IllegalLogStringException e) {
            e.printStackTrace(); // Should never happen unless someone made major bobo!
        }
    }

    
    
    /**
     * Configure logging according to <code>logString</code>.
     */
    public void setLogger(String logString) throws IllegalLogStringException {
        setLogger(ModelicaLogger.createModelicaLoggersFromLogString(logString));
    }

    
    
    /**
     * Change logger to <code>logger</code>
     */
    public void setLogger(ModelicaLogger logger) {
        log.close();
        log = logger;
        ASTNode.log = log;
    }

    
    
    public ModelicaLogger log() {
        return log;
    }

    
    
    /**
     * Close and disconnect all loggers.
     */
    public void closeLogger() {
        log.close();
    }

    

    private void setOptions(Arguments programarguments) {
        // Create option registry
        options = createOptions();
        String opts = programarguments.get("opt");
        if (opts != null) {
            for (String opt : opts.split(",")) {
                String[] parts = opt.split(":", 2);
                if (parts.length == 1)
                    options.setBooleanOption(parts[0], true);
                else
                    options.setOption(parts[0], parts[1]);
            }
        }
        
        //add modelicapath to optionregistry
        String modelicapath = programarguments.get("modelicapath");
        if (modelicapath == null) {
            //modelicapath was not set in program arguments -> check envir variable or via JMODELICA_HOME
            if (System.getenv("MODELICAPATH") != null) 
                modelicapath = System.getenv("MODELICAPATH");
            else
                modelicapath = EnvironmentUtils.getThirdPartyMSL().toString();
        }
        options.setStringOption("MODELICAPATH", modelicapath);
    }

    
    
    public OptionRegistry getOptions() {
        return options;
    }

    

    public static final String COMPILER_VERSION = Version.parseVersion();

    

    protected void setArguments(Arguments programarguments) {
        
        int arg = 0;
        String modelicapath = null;
        
        //log option
        try {
            String logString = programarguments.get("log");
            setLogger(logString);
        } catch (IllegalLogStringException e) {
            setLogger(e.getLogger());
            log.error(e);
            closeLogger();
            System.exit(1);
        }
        
        setDumpMemoryUse(programarguments.containsKey("dumpmemuse"), programarguments.get("dumpmemuse"));
        setFindFlatToInstanceLinks(programarguments.containsKey("findflatinst"));
        
        if (programarguments.containsKey("debugSrcIsHome")) 
            setDebugSrcIsHome(true);
        
        // platform argument
        String platforms = programarguments.get("platform");
        if (platforms != null) {
            setTargetPlatforms(platforms.split(","));
        }
        
        // set options
        this.setOptions(programarguments);
        
        // Log compilation command
        log.info("Compiler arguments:\n  "        + programarguments.line());
        log.info("Current working directory:\n  " + currentWorkingDirecory());
        log.info("Compiler version: "             + COMPILER_VERSION);
        log.info("Java version: "                 + System.getProperty("java.version"));
        log.info("OS name: "                      + System.getProperty("os.name"));
        log.info("OS architecture: "              + System.getProperty("os.arch"));
        logEnvironment("MODELICAPATH", "JAVA_HOME", "JMODELICA_HOME");
    }

    

    public static void main(String[] args) {
        // create an empty compiler
        ModelicaCompiler mc = new ModelicaCompiler();
        try {
            // set arguments
            Arguments arguments = new Arguments("ModelicaCompiler", args);
            mc.setArguments(arguments);
            // Compile model
            mc.compileModelFromCommandLine(args, arguments);
        } catch(Throwable e) {
            log.error(e);
            log.close();
            System.exit(1);
        }
    }

    

    /**
     * Compile model given on command line options and print any error messages.
     */
    protected void compileModelFromCommandLine(String[] args, Arguments programarguments) {
        // Get files and class
        // TODO: move this into arguments class
        String[] files = splitFiles(programarguments.libraryPath());
        String className = programarguments.className();
        String compileTo = programarguments.out();
        
        // Compile model
        try {
            String targetType = programarguments.get("target");
            if (targetType == null || targetType.equals("fmume")) {
                targetType = "me";
            } else if (targetType.equals("fmucs")) {
                targetType = "cs";
            }
            
            //Compile
            compileUnit(className, files, targetType, programarguments.get("version"), compileTo);
            
        } catch (CompilerException ce) {
            if (options.getBooleanOption("generate_html_diagnostics") && getDiagnosticsGenerator() != null) 
                getDiagnosticsGenerator().writeProblems(ce.getProblems());
            log.logCompilerException(ce);
            closeLogger();
            System.exit(1);
        } catch (Throwable e) {
            log.error(e);
            closeLogger();
            System.exit(1);
        } finally {
            closeLogger();
        }
    }

    

    /**
     * Split the argument containing the list of files into an array of filenames.
     */
    protected String[] splitFiles(String arg) {
        ArrayList<String> res = new ArrayList<String>();
        for (String part : arg.split(","))
            if (!part.equals(""))
                res.add(part);
        return res.toArray(new String[res.size()]);
    }

    

    /**
     * Get the current working directory.
     */
    protected String currentWorkingDirecory() {
        try {
            return new File(".").getCanonicalPath();
        } catch (IOException e) {
            return "< could not get current working directory >";
        }
    }

    

    /**
     * Write environment variables to logger.
     */
    protected void logEnvironment(String... names) {
        for (String name : names) {
            String val = System.getenv(name);
            log.info("%-15s = %s", name, (val == null) ? "" : val);
        }
    }

    

    public enum TargetType {
        FMUME10, FMUME20, FMUCS10, FMUCS20, FMUMECS20, FMUX, CEVAL, NULL
    }

    
    
    /**
    * Target object, contains all information related to which target is compiled.
    * 
    * The target is an enum that represents all different targets, the templates are in a separate class.
    */
    public enum TargetObject implements CCompilerTarget {
        
        FMUME10   (TargetType.FMUME10,   "fmume10",   "fmu",  XMLGeneratorHolder.FMI1),
        FMUME20   (TargetType.FMUME20,   "fmume20",   "fmu",  XMLGeneratorHolder.FMI2),
        FMUCS10   (TargetType.FMUCS10,   "fmucs10",   "fmu",  XMLGeneratorHolder.FMI1),
        FMUCS20   (TargetType.FMUCS20,   "fmucs20",   "fmu",  XMLGeneratorHolder.FMI2),
        FMUMECS20 (TargetType.FMUMECS20, "fmumecs20", "fmu",  XMLGeneratorHolder.FMI2), 
        FMUX      (TargetType.FMUX,      null,        "fmux", XMLGeneratorHolder.FMIX),
        CHECK     (TargetType.NULL,      null,        null,   XMLGeneratorHolder.NULL, ErrorCheckType.CHECK, false),
        PARSE     (TargetType.NULL,      null,        null,   XMLGeneratorHolder.NULL, ErrorCheckType.CHECK, false),
        NOCODEGEN (TargetType.NULL,      null,        null,   XMLGeneratorHolder.NULL, ErrorCheckType.COMPILE, false),
        CEVAL     (TargetType.CEVAL,     "ceval",     null  , null);

        private final TargetType type;
        private final String makeFileFlag;
        private final String suffix;
        private final XMLGeneratorHolder xmlGenerator;
        private final ErrorCheckType checkType;
        private final boolean codeGen;

        private TargetObject(TargetType type, String makeFileFlag, String suffix, XMLGeneratorHolder xmlGenerator, ErrorCheckType checkType, boolean codeGen) {
            this.type = type;
            this.makeFileFlag = makeFileFlag;
            this.suffix = suffix;
            this.checkType = checkType;
            this.codeGen = codeGen;
            this.xmlGenerator = xmlGenerator;
        }

        private TargetObject(TargetType type, String makeFileFlag, String suffix, XMLGeneratorHolder xmlGenerator, ErrorCheckType checkType) {
            this(type, makeFileFlag, suffix, xmlGenerator, checkType, true);
        }
        
        private TargetObject(TargetType type, String makeFileFlag, String suffix, XMLGeneratorHolder xmlGenerator) {
            this(type, makeFileFlag, suffix, xmlGenerator, ErrorCheckType.COMPILE);
        }
        
        public Templates getTemplates(OptionRegistry options) {
            return new Templates(type, options);
        }
        
        public String createExtraCFlagsString(OptionRegistry options, String fileName) {
            
            if (suffix == null) {
                return "";
            }
            
            return getTemplates(options).createExtraCFlagsString(options, fileName);
        }
        
        /**
        * Returns an enum of the target that contains all relevant information for the target.
        * 
        * @param targetType  The compiler target.
        * @param version     The FMI version.
        */
        public static TargetObject getTarget(String targetType, String version)
                throws IllegalCompilerArgumentException {
            
            if (targetType.equals("nocodegen")) {
                return NOCODEGEN;
            } else if (targetType.equals("me")) {
                if (version == null || version.equals("1.0")) {
                    return FMUME10;
                } else if (version.equals("2.0")) {
                    return FMUME20;
                } else {
                    throw new IllegalCompilerArgumentException("Unknown version '" + version + "' for target '" + targetType + "'. Use 1.0 or 2.0."); 
                }
            } else if (targetType.equals("cs")) {
                if (version == null || version.equals("1.0")) {
                    return FMUCS10;
                } else if (version.equals("2.0")) {
                    return FMUCS20;
                } else {
                    throw new IllegalCompilerArgumentException("Unknown version '" + version + "' for target '" + targetType + "'. Use 1.0 or 2.0."); 
                }
            } else if (targetType.equals("me+cs")) {
                if (version == null || version.equals("2.0")) {
                    return FMUMECS20;
                } else {
                    throw new IllegalCompilerArgumentException("Unknown version '" + version + "' for target '" + targetType + "'. Use 2.0.");
                }
            } else if (targetType.equals("fmux")) {
                return FMUX;
            } else if (targetType.equals("ceval")){
                return CEVAL;
            } else if (targetType.equals("parse")) {
                return PARSE;
            } else if (targetType.equals("check")) {
                return CHECK;
            } else {
                throw new IllegalCompilerArgumentException("Unknown target '" + targetType + "'. Use me or cs to compile an FMU or fmux to compile an FMUX."); 
            }
        }
        
        /**
         * Create a new XMLGenerator object.
         * 
         * Override for subclasses needing another subclass of XMLGenerator.
         */
        public GenericXMLGenerator getXMLGenerator(FClass fc) {
            return xmlGenerator.getXMLGenerator(fc);
        }
        
        /**
         * get the flag should be used in the Makefile.
         * 
         * @return The flag for the Makefile. 
         * 
         */
        public String getMakeFileFlag() {
            return makeFileFlag;
        }
        
        /**
         * Gets the file suffix for a the target object. 
         */
        public String getUnitSuffix() {
            return suffix;
        }
        
        /**
         * Get the check type to use when error checking.
         */
        public ErrorCheckType getCheckType() {
            return checkType;
        }
        
        /**
         * Get a flag that determines if there should be any code-generation.
         */
        public boolean getCodeGenFlag() {
            return codeGen;
        }

        /**
         * Sets the default options that should be used for this target object. 
         */
        public void setDefaultOptions(OptionRegistry options) {
            for (TargetOptionContributor contributor :
                    TargetOptionContributor.TARGET_DEFAULT_OPTION_CONTRIBUTORS.values()) {

                contributor.setOptions(this, options);
            }
        }

    }

    

    public static TargetOptionContributor addTargetOptionContributor(TargetOptionContributor contributor) {
        Map<String, TargetOptionContributor> contributors = TargetOptionContributor.TARGET_DEFAULT_OPTION_CONTRIBUTORS;
        String identity = contributor.identity();

        if (contributors.containsKey(identity)) {
            return contributors.get(identity);
        }

        contributors.put(identity, contributor);
        return contributor;
    }

    

    private static final TargetOptionContributor TARGET_DEFAULT_BASE_CONTRIBUTOR = addTargetOptionContributor(
                    new ModelicaCompiler.TargetOptionContributor() {

                        @Override
                        public void setOptions(TargetObject object, OptionRegistry options) {
                            switch (object) {
                                case FMUME10:
                                    options.setStringOption("fmu_type", "FMUME10");
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", true);
                                    options.setBooleanOption("generate_fmi_cs_xml", false);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case FMUME20:
                                    options.setStringOption("fmu_type", "FMUME20");
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", true);
                                    options.setBooleanOption("generate_fmi_cs_xml", false);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case CHECK:
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", true);
                                    options.setBooleanOption("generate_fmi_cs_xml", false);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case FMUCS10:
                                    options.setStringOption("fmu_type", "FMUCS10");
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", false);
                                    options.setBooleanOption("generate_fmi_cs_xml", true);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case FMUCS20:
                                    options.setStringOption("fmu_type", "FMUCS20");
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", false);
                                    options.setBooleanOption("generate_fmi_cs_xml", true);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case FMUMECS20:
                                    options.setStringOption("fmu_type", "FMUME20;FMUCS20");
                                    options.setBooleanOption("generate_ode", true);
                                    options.setBooleanOption("generate_dae", false);
                                    options.setBooleanOption("equation_sorting", true);
                                    options.setBooleanOption("generate_fmi_me_xml", true);
                                    options.setBooleanOption("generate_fmi_cs_xml", true);
                                    options.setBooleanOption("generate_xml_equations", false);
                                    break;
                                case FMUX:
                                    options.setBooleanOption("generate_ode", false);
                                    options.setBooleanOption("generate_dae", true);
                                    options.setBooleanOption("equation_sorting", false);
                                    options.setBooleanOption("generate_fmi_me_xml", false);
                                    options.setBooleanOption("generate_fmi_cs_xml", false);
                                    options.setBooleanOption("generate_xml_equations", true);
                                    break;
                                case NOCODEGEN:
                                    options.setBooleanOption("no_loop_unrolling_in_functions", false);
                                    break;
                                default:
                                    break;
                                }
                            options.setStringOption("compiler_version", ModelicaCompiler.COMPILER_VERSION);
                        }

                        @Override
                        public String identity() {
                            return "org.jmodelica.modelica.compiler.ModelicaCompiler.TARGET_DEFAULT_BASE_CONTRIBUTOR";
                        }
                    });

    

    private static final TargetOptionContributor TARGET_FMI_VERSION_CONTRIBUTOR = addTargetOptionContributor(
                    new ModelicaCompiler.TargetOptionContributor() {

                        @Override
                        public void setOptions(TargetObject object, OptionRegistry options) {
                            switch (object) {
                                case FMUME10:
                                case FMUCS10:
                                    options.setStringOption("fmi_version", OptionRegistry.FMIVersion.FMI10);
                                    break;
                                case FMUME20:
                                case FMUCS20:
                                case FMUMECS20:
                                    options.setStringOption("fmi_version", OptionRegistry.FMIVersion.FMI20);
                                    break;
                                default:
                                    break;
                            }
                        }

                        @Override
                        public String identity() {
                            return "org.jmodelica.modelica.compiler.ModelicaCompiler.TARGET_FMI_VERSION_CONTRIBUTOR";
                        }
                    });

    

    /**
     * Contributor class for additional default options dependent on compilation target.
     */
    public static abstract class TargetOptionContributor implements Comparable<TargetOptionContributor> {

        private static final Map<String, TargetOptionContributor> TARGET_DEFAULT_OPTION_CONTRIBUTORS =
            new HashMap<String, TargetOptionContributor>();

        protected abstract String identity();
        protected abstract void setOptions(TargetObject object, OptionRegistry options);

        @Override
        public int compareTo(TargetOptionContributor other) {
            return identity().compareTo(other.identity());
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof TargetOptionContributor)) {
                return false;
            }
            return compareTo((TargetOptionContributor) other) == 0;
        }

    }

    public String[] getTargetPlatforms() {
        return targetPlatforms;
    }

    public void setTargetPlatforms(String... platforms) {
        this.targetPlatforms = platforms;
    }

    public void setTempFileDir(File temp) {
        tempDir = temp;
    }

    public void setOutDir(File out) {
        outDir = out;
        sourceDir = new File(outDir, "sources");
        resourceDir = new File(outDir, "resources");
        sourceDir.mkdirs();
        resourceDir.mkdir();
    }

    public void setSubOutDir(String out) {
        setOutDir(new File(tempDir, out));
    }

    public void setRandomOutDir() {
        try {
            File out = File.createTempFile("jmc", "out", tempDir);
            out.delete();
            setOutDir(out);
        } catch (IOException e) {
            throw new ModelicaException("Unable to create temporary directory with prefix 'jmc', suffix 'out' and " +
                    "temp base directory '" + tempDir + "'! java.io.tmpdir: '" + System.getProperty("java.io.tmpdir") + 
                    "'. TMP: '" + System.getenv("TMP") + "'. TEMP: '" + System.getenv("TEMP") + "'.", e);
        }
    }

    private void deleteOutDir() {
        if (outDir != null) {
            FileUtil.recursiveDelete(outDir);
        }
        outDir = null;
        sourceDir = null;
        resourceDir = null;
    }

    public FClass compileModel(String name[], String cl, TargetObject target, String flatName, String compileTo)
          throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {
        boolean doTearDown = true;
        try {
            doTearDown = trySetUp();
            return doCompileModel(name, cl, target, flatName, compileTo);
        } finally {
            tryTearDown(doTearDown);
        }
    }

    public FClass doCompileModel(String name[], String cl, TargetObject target, String flatName, String compileTo)
          throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {
        if (target.equals(TargetObject.PARSE)) {
            parseFiles(name);
            return null;
        } else if (target.equals(TargetObject.CHECK)) {
            try {
                instantiateModel(name, cl, target);
            } finally {
                if (outDir != null) {
                    deleteOutDir();
                }
            }
            return null;
        }
        
        log.info("======= Compiling model =======");
        resetCompilationInfo();
        
        FClass fc = null;
        try {
            // compute instance tree
            InstClassDecl icl = instantiateModel(name, cl, target);
            
            if (compileTo != null) {
                File unitFile = makePackagingDirs(cl, new File(compileTo), target);
                icl.root().getUtilInterface().setCompilationOutputPath(unitFile);
            }
            
            // flattening
            // Throw away source and instance trees when they are not needed any more
            PassAndForget<InstClassDecl> buf = new PassAndForget<InstClassDecl>(icl);
            icl = null;
            fc = flattenModel(buf.pass(), target, flatName);
            
            // Generate code 
            if (target.getCodeGenFlag()) {
                generateCode(fc, target);
                dumpMemoryUseFile(fc, "generated", false);
            }
            
            fc.loadResources(new File(outDir, "resources"));
            
        } finally {
        }
        
        if (options.getBooleanOption("generate_html_diagnostics"))
            setDiagnosticsGenerator(null);
        
        log.info("====== Model compiled successfully =======");
        
        return fc;
    }

    protected boolean isSetUp = false;

    protected boolean trySetUp() {
        return trySetUp(null);
    }

    protected boolean trySetUp(IErrorHandler eh) {
        if (!isSetUp) {
            setUp(eh);
            return true;
        }
        return false;
    }

    public void setUp() {
        setUp(null);
    }

    protected void setUp(IErrorHandler eh) {
        if (isSetUp) {
            throw new InternalCompilerError("Compiler setup can only be performed once");
        }
        if (eh == null) {
            eh = new DefaultErrorHandler(options.getBooleanOption("halt_on_warning"));
            if (options.getBooleanOption("compliance_as_warning")) {
                eh = new ComplianceWarnErrorHandler(eh);
            }
        }
        setErrorHandler(eh);
        isSetUp = true;
    }

    public void checkSetUp() {
        if (!isSetUp) {
            throw new InternalCompilerError("Compiler setup not performed. Use ModelicaCompiler.setUp()");
        }
    }

    protected void tryTearDown(boolean doTearDown) {
        if (doTearDown) {
            tearDown();
        }
    }

    public void tearDown() {
        createUtilInterface().tearDown();
        setErrorHandler(null);
        isSetUp = false;
    }

    protected void warning(String message) {
        errorHandler.problem(new Problem(message, ProblemSeverity.WARNING));
    }

    protected void error(String message) {
        errorHandler.problem(new Problem(message, ProblemSeverity.ERROR));
    }

    SplitFilesCodeStream generateFile(FClass fc, String tmpl, AbstractGenerator gen, File dir, String name, String header) 
            throws FileNotFoundException {

        if (tmpl != null || gen instanceof GenericXMLGenerator) {
            hookCheckAbort();
            hookCodeGeneratorCreated(gen);
            File outFile = new File(dir, name);
            boolean debugGen = options.getBooleanOption("debug_duplicate_generated");
            SplitFilesCodeStream stream = new SplitFilesCodeStream(outFile, debugGen, header);
            gen.generate(tmpl, stream, header);
            for (File file : stream.files()) {
                log.debug("Generated file '" + file + "'.");
                if (fc != null) {
                    fc.guidManager().addDependentFile(file);
                }
            }
            return stream;
        }
        return null;
    }

    protected File packUnit(String className,
            TargetObject target, FClass fClass) throws PackingFailedException {

        File unitFile = fClass.root().getUtilInterface().getCompilationOutputPath();

        try {
            hookCheckAbort();
            copySourceFiles(fClass, sourceDir, outDir);

            OutputStream dest = new BufferedOutputStream(new FileOutputStream(unitFile));
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            out.setMethod(ZipOutputStream.DEFLATED);

            zipDir(outDir, out);
            out.close();
        } catch (CompilationAbortedException e) {
            throw e;
        } catch (Exception e) {
            throw new PackingFailedException(String.format("Could not write to '%s'.", unitFile), e);
        }

        hookFmuPacked(fClass, unitFile.getAbsoluteFile());
        return unitFile;
    }

    private void copySourceFiles(FClass fClass, File rootDir, File destination) {
        if(!options.getBooleanOption("copy_source_files_to_fmu")) {
            FileUtil.recursiveDelete(sourceDir);
            sourceDir = null;
        }
    }

    private void doCompileCCode(TargetObject target,  FClass fc, String className, String flatName) {
        if (target.getMakeFileFlag() != null) {
                ASTNode.beginStep("compileCCode()");
                String cFileName = (flatName != null) ? flatName : FClass.convertClassNameToUnderscore(className);
                CCompilerDelegator ccompiler = getCCompiler();
                CCompilerArguments ccArgs = new CCompilerArguments(cFileName, fc.myOptions(), target, fc.externalLibraries(), fc.externalLibraryDirectories(), 
                        fc.externalIncludeDirectories());
                ccompiler.compileCCode(ModelicaCompiler.log, ccArgs, outDir);
                ccompiler.copySharedLibs(outDir, ccArgs.getExternalLibraries());
                ASTNode.endStep("compileCCode()");
        }
        hookCodeCompiled();
     }

    private File makePackagingDirs(String className, File destination, TargetObject target) {
        File dest = new File(destination.getAbsolutePath());
        if (dest.isDirectory()) { 
            String mangledName = FClass.convertClassNameToUnderscore(className);
            dest = new File(dest, mangledName + "." + target.getUnitSuffix());
        } else {
            File destDir = dest.getParentFile();
            if (destDir != null && !destDir.isDirectory()) {
                dest.getParentFile().mkdirs();
            }
        }
        return dest;
    }

    private static final Templates.TemplateContributor BASIC_TEMPLATES =
    Templates.addContributor(new Templates.TemplateContributor() {

        @Override
        public void addTemplates(Templates templates, OptionRegistry options) {
            templates.addCHeaderTemplates("base");
            templates.addCSourceTemplates("base", "init_independent", "init_dependent", "equ_init", "equ", "funcs");
        }
    });

    
        static {
            // Ensures that we load the class when this class is loaded!
            GccCompilerDelegator.CREATOR.getClass();
        }

    
        public FClass compileModelNoCodeGen(String name[], String cl)
          throws ModelicaException, FileNotFoundException, IOException, beaver.Parser.Exception {
            OptionRegistry tempOptions = options.copy();
            TargetObject target = createTargetObject("nocodegen", null);
            target.setDefaultOptions(options);
            try {
                return compileModel(name, cl, target, null, null);
            } finally {
                options.copyAllOptions(tempOptions);
            }
        }


}
