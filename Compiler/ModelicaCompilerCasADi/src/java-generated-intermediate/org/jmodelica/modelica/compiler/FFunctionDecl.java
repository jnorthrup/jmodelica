/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.0 */
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
 * A flattened user-defined function.
 * 
 * Results from a class with the restriction "function" and an algorithm block.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:51
 * @astdecl FFunctionDecl : BaseNode ::= FAccess FFunctionVariable* FAlgorithm FAttribute*;
 * @production FFunctionDecl : {@link BaseNode} ::= <span class="component">{@link FAccess}</span> <span class="component">{@link FFunctionVariable}*</span> <span class="component">{@link FAlgorithm}</span> <span class="component">{@link FAttribute}*</span>;

 */
public class FFunctionDecl extends BaseNode implements Cloneable, FCallable, FAttributeListAnnotationNode.FAttributeList {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3643
     */
    public static Map<CommonVariableDecl, CValue> resetAfterCeval(CommonCallable cc, ASTNode n, Map<CommonVariableDecl, CValue> values) {
        Map<CommonVariableDecl, CValue> oldVal = cc.getCurrentEvaluationValues();
        cc.setCurrentEvaluationValues(values);
        for (CommonVariableDecl cvd : cc.myInputs()) {
            cvd.resetAfterCeval();
        }
        for (CommonVariableDecl cvd : cc.myNonInputs()) {
            cvd.resetAfterCeval();
        }
        n.resetAfterCeval();
        if (values != null) {
            for (CommonVariableDecl cvd : values.keySet()) {
                cvd.setLocalCachedEvaluationValue(values.get(cvd));
            }
        }
        return oldVal;
    }
    /**
     * Perform constant evaluation of functions.
     * 
     * @param values  constant values for the variables. 
     * Should be filled with the values of the inputs.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3714
     */
    public void evaluate(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        FFunctionDecl.evaluate(evaluator, values, this, getFAlgorithm());
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3718
     */
    public static void evaluate(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values, CommonCallable cc, FAlgorithm fab) {
        AlgorithmEvaluator algoEvaluator = evaluator.createAlgorithmEvaluator(fab.myOptions(), values);
        Map<CommonVariableDecl, CValue> oldVal = FFunctionDecl.resetAfterCeval(cc, fab, values);
        try {
            for (CommonVariableDecl cvd : cc.myInputs()) {
                // Only here because operator record functions does not evaluate default values of inputs
                cvd.readEvaluationValue(values);
            }
            for (CommonVariableDecl cvd : cc.myNonInputs()) {
                // Only here because scalar primitives does not have init statements.
                cvd.readEvaluationValue(values);
            }
            if (oldVal == null || algoEvaluator.recursive(cc)) {
                fab.getFStatements().evaluateList(algoEvaluator);
            }
        } catch (ConstantEvaluationException e) {
            algoEvaluator.failed(cc, e);
        } finally {
            FFunctionDecl.resetAfterCeval(cc, fab, oldVal);
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3749
     */
    private Map<CommonVariableDecl, CValue> currentEvaluationValues = null;
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3750
     */
    public Map<CommonVariableDecl, CValue> getCurrentEvaluationValues() { return currentEvaluationValues; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3751
     */
    public void setCurrentEvaluationValues(Map<CommonVariableDecl, CValue> values) { currentEvaluationValues = values; }
    /**
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:875
     */
    public FFunctionDecl(String name, List<FFunctionVariable> vars, FStatement ... statements) {
        this(new FAccessString(name), vars, new FAlgorithm(new List<FStatement>(statements)), new List<FAttribute>());
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:19
     */
    public FlatAnnotation flatAnnotation(String ... path) {     return FlatAnnotation.createFor(this, path); }
    /**
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:75
     */
    private FlatVariableMap tempLookupMap = null;
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1590
     */
    private FlatVariableMap.NameIndexCache nameIndexCache = new FlatVariableMap.NameIndexCache();
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1600
     */
    public String nextTempVarName() {
         return nextGeneratedVarName(FlatVariableMap.GeneratedVarType.TEMP);
     }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1604
     */
    public String nextGeneratedVarName(FlatVariableMap.GeneratedVarType gvt) {
         return variablesMap().nextGeneratedVarName(nameIndexCache, gvt);
     }
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:291
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent) {
    	str.print(indent + "function " + name() + "<br>\n");
    	getFFunctionVariables().prettyPrintWithIndent(p, str, p.indent(indent), ";<br>");
    	p.print(getFAlgorithm(), str, indent);
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p, indent, ";<br>\n");
    	str.print(indent + "end " + name() + ";<br><br>\n\n");
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1218
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.println(indent, "function ", name());
        getFFunctionVariables().prettyPrintWithIndent(p, str, p.indent(indent), ";");
        p.print(getFAlgorithm(), str, indent);
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p, indent, ";" + str.getLineEnder());
        str.println(indent, "end ", name(), ";");
        str.println();
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:532
     */
    
        public enum FunctionType {
            EXTERNAL, LOADRESOURCE;
            
            public boolean containsFunction(CommonCallable cc) {
                if (this == EXTERNAL) {
                    return cc.isExternalFunction();
                } else {
                    return cc.containsFunction(this);
                }
            }
        }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:636
     */
    public void updateRecordArraySizes() {
        for (FFunctionVariable ffv : getFFunctionVariables())
            ffv.updateRecordArraySizes();
    }
    /**
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:476
     */
    private static boolean partitionArgumentsByOrder(boolean[] hasDerivative, int start, int max, int order, int[] result) {
	    int n = hasDerivative.length - start;
	    if (order <= 1) {
	        result[result.length - 1] = n;
	        return max == n;
	    }
	    int first = (n + order - 1) / order;
	    int nd = 0;
        for (int i = start; i < start + first - 1; i++)
            if (hasDerivative[i])
                nd++;
	    for (; first < max; first++) {
	        result[result.length - order] = first;
            if (hasDerivative[start + first - 1])
                nd++;
            if (nd * order >= n - first && partitionArgumentsByOrder(hasDerivative, start + first, nd, order - 1, result))
                return true;
	    }
	    return false;
	}
    /**
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:497
     */
    private boolean[] cachedShouldBeDifferentiated = null;
    /**
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:498
     */
    private AnnotationNode cachedShouldBeDifferentiatedFor = null;
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:110
     */
    private final Global global = new Global();
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:111
     */
    public        Global global() { return global; }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:158
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        if (global().update(type)) {
            markUsedGlobalsExtra(type);
            super.markUsedGlobals(type);
        }
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:166
     */
    public void markUsedGlobalsExtra(Global.UseType type) {
        // Hook to facilitate extensions
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:350
     */
    public void enableAliasRewrite() {
	}
    /**
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:28
     */
    public void constantFolding(VariableEvaluator evaluator) {
        
    }
    /**
     * Describes the possible inputs from the user concerning if and how to inline the function.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:75
     */
    

        /**
         * Describes the possible inputs from the user concerning if and how to inline the function.
         */
        public enum InlineAnnotation { 
            DEFAULT     (true,  false, false), 
            NONE        (false, false, false), 
            INLINE      (true,  true,  false), 
            LATE        (true,  true,  true), 
            AFTER_INDEX (true,  true,  true);

            private boolean may;
            private boolean always;
            private boolean late;

            private InlineAnnotation(boolean may, boolean always, boolean late) {
                this.may = may;
                this.always = always;
                this.late = late;
            }

            /**
             * Check if the annotation says that we may try to inline the function.
             */
            public boolean may() {
                return may;
            }

            /**
             * Check if the annotation says that we should always try to inline the function.
             */
            public boolean always() {
                return always;
            }

            /**
             * Check if the annotation says that we should wait until after other symbolic transformations 
             * (especially index reduction) to inline.
             */
            public boolean late() {
                return late;
            }

        }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:117
     */
    private InlineAnnotation inlineAnnotationCache = null;
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:119
     */
    public InlineAnnotation inlineAnnotation() {
        if (inlineAnnotationCache != null)
            return inlineAnnotationCache;
        AnnotationNode inline = annotation().forPath("Inline");
        AnnotationNode late = annotation().forPath("LateInline");
        AnnotationNode index = annotation().forPath("InlineAfterIndexReduction");
        inlineAnnotationCache = InlineAnnotation.DEFAULT;
        if (late.isBoolValue())
            inlineAnnotationCache = late.bool() ? InlineAnnotation.LATE : InlineAnnotation.NONE;
        if (inline.isBoolValue() && !(late.isBoolValue() && late.bool()))
            inlineAnnotationCache =  inline.bool() ? InlineAnnotation.INLINE : InlineAnnotation.NONE;
        if (index.isBoolValue())
            inlineAnnotationCache = index.bool() ? InlineAnnotation.AFTER_INDEX : InlineAnnotation.NONE;
        return inlineAnnotationCache;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:135
     */
    public void copyInlineAnnotation(AnnotationNode src) {
        copyInlineAnnotation(src, "Inline");
        copyInlineAnnotation(src, "LateInline");
        copyInlineAnnotation(src, "InlineAfterIndexReduction");
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:141
     */
    private void copyInlineAnnotation(AnnotationNode src, String type) {
        src = src.forPath(type);
        if (src.exists() && src.isBoolValue())
            annotation().forPath(type).setValue(FBooleanLitExp.create(src.bool()));
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1050
     */
    private boolean containsExtObjArrays(ArrayList<FFunctionVariable> variables) {
        for (FFunctionVariable var : variables)
            if (var.getType().isExternalObjectArray())
                return true;
        return false;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1057
     */
    private boolean containsPartialFunction() {
        for (FFunctionVariable var : getFFunctionVariables())
            if (var.getType().isFunction())
                return true;
        return false;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1064
     */
    private boolean hasInlinableIO() {
        return !containsExtObjArrays(myInputs()) && !containsExtObjArrays(myOutputs())
                && !containsPartialFunction();
    }
    /**
     * Flags that this function is being inlined.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1294
     */
    private boolean duringInlining = false;
    /**
     * Inline a call to this function.
     * 
     * @param fi    the function inlining helper to use
     * @param args  the argument list for the function call
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1320
     */
    public void inline(AbstractFunctionInliner fi, List<FExp> args) {
        duringInlining = true;
        tempLookupMap = fi.startFunction(this);
        flushAllRecursive();
        
        int i = 0;
        ArrayList<FFunctionVariable> inp = myInputs();
        for (FFunctionVariable var : myInputs()) {
            FExp arg = args.getChild(i++);
            fi.setTypeOf(var.name(), arg.type());
            arg.addInliningVarsAndEqns(fi, var.name(), false);
            var.cacheFunctionInliner(fi);
        }
        
        for (FStatement stmt : getFAlgorithm().getFStatements()) 
            stmt.inline(fi);
        
        for (FFunctionVariable var : getFFunctionVariables())
            var.clearFunctionInliner();
        
        tempLookupMap = null;
        duringInlining = false;
        flushAllRecursive();
    }
    /**
     * Scalarize the function, replacing all array assignments with separate scalar 
     * assignments and scalarize all expressions.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:23
     */
    public void scalarize() {
        List<FStatement> stmts = new List<FStatement>();
        List<FAttribute> attrs = new List<FAttribute>();
        try {
            FStatement.scalarizeStmtList(Scalarizer.function(getFFunctionVariables(), stmts), getFAlgorithm().getFStatements());
        } catch (ModelicaException e) {
            throw e;
        } catch (Exception e) {
            throw new org.jmodelica.util.exceptions.InternalCompilerError("Exception caught while scalarizing function'" + name() + "'", e);
        }
        setFAlgorithm(new FAlgorithm(stmts));
        clearScalarized();  // Functions need scalarized = false in FAccesss
        flushAllRecursive();
    }
    /**
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:883
     */
    public void smoothOrder(int order) {
        AnnotationNode node = annotation().forPath("smoothOrder");
        if (node.exists() || order != SMOOTH_ORDER_ANNOTATION_DEFAULT)
            // We only wan't to set this attribute if it is already set or order is non equal to default.
            annotation().forPath("smoothOrder").setValue(new FIntegerLitExp(order));
    }
    /**
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:914
     */
    public FFunctionDecl createAndAddDerivativeFunction(AnnotationNode derNode) {
        FAccess name = getFAccess().createDerPrefixedName(1);
        derNode.setValue(new FAccessExp(name));
        derNode.forPath("order").setValue(new FIntegerLitExp(order() + 1));
        
        Collection<FFunctionVariable> inputs = new ArrayList<FFunctionVariable>();
        Collection<FFunctionVariable> derivatedInputs = new ArrayList<FFunctionVariable>();
        Collection<FFunctionVariable> outputs = new ArrayList<FFunctionVariable>();
        Collection<FFunctionVariable> others = new ArrayList<FFunctionVariable>();
        for (FFunctionVariable ffv : getFFunctionVariables()) {
            FFunctionVariable ffvCopy = ffv.fullCopy();
            if (ffv.isInput()) {
                inputs.add(ffvCopy);
                if (ffv.order() == order() && ffv.shouldBeDifferentiated(derNode))
                    derivatedInputs.add(ffv.createDerivative());
            } else if (ffv.isOutput()) {
                ffvCopy.setTypePrefixInputOutput(TypePrefixInputOutput.NONE);
                others.add(ffvCopy);
                if (ffv.order() == order() && ffv.shouldBeDifferentiated(derNode))
                    outputs.add(ffv.createDerivative());
            } else {
                others.add(ffvCopy);
                if (ffv.order() == order() && ffv.shouldBeDifferentiated(derNode))
                    others.add(ffv.createDerivative());
            }
        }
        List<FFunctionVariable> variables = new List<FFunctionVariable>();
        variables.addAll(inputs);
        variables.addAll(derivatedInputs);
        variables.addAll(outputs);
        variables.addAll(others);

        FFunctionDecl function = new FFunctionDecl(name, variables, new FAlgorithm(), new List<FAttribute>());
        function.smoothOrder(Math.max(smoothOrder() - 1, 0));
        myFClass().addFFunctionDecl(function);
        function.setFAlgorithm(getFAlgorithm().diff());
        
        return function;
    }
    /**
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:41
     */
    public void sortBindingAssignments() {
        Map<String,FStatement> map = new LinkedHashMap<String,FStatement>();
        for (FStatement stmt : getFAlgorithm().getFStatements())
            stmt.addToSortingMap(map);
        
        List<FStatement> stmts = new List<FStatement>();
        while (!map.isEmpty()) 
            map.values().iterator().next().addSortedByAssignmentOrder(stmts, map);
        
        for (FStatement stmt : getFAlgorithm().getFStatements())
            if (!stmt.shouldBeSorted)
                stmts.add(stmt);
        getFAlgorithm().setFStatementList(stmts);
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:255
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		open_XML(str, indent);
		enclose_XML(p, str, indent2, "Name", getFAccess());
		p.print(myOutputs(), str, indent2);
		p.print(myInputs(), str, indent2);
		p.print(myProtected(), str, indent2);
		p.print(getFAlgorithm(), str, indent2);
		close_XML(str, indent);
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:77
     */
    public void genHeader(CodePrinter p, CodeStream str, String indent) {
        if (!p.shouldPrintFuncDecl(this)) {
            return;
        }
        prettyPrintHeader(p, str, indent, "void", p.functionDefSuffix(), true);
        p.printExpHeader(this, str, indent);
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:85
     */
    public void prettyPrintHeader(CodePrinter p, CodeStream str, String indent, String type, String cSuffix,
            boolean returnArgs) {
        str.print(indent);
        str.print(type);
        str.print(" ");
        new HeadComputation(derivativeAnnotationUnrestricted(), "")
        .prettyPrintHead(this, p, str, indent, cSuffix, returnArgs);
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:165
     */
    public void printExpHeader_C(CodePrinter p, CodeStream str, String indent) {
        if (generateExpFunction()) {
            prettyPrintHeader(p, str, indent, getDeclaredType_C(p), C_SUFFIX_EXP, false);
        }
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:171
     */
    public String getDeclaredType_C(CodePrinter p) {
        if (myOutputs().size() > 0) {
            return myOutputs().get(0).type_C(p);
        } else {
            return "void";
        }
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:179
     */
    public void genOpenFunctionDecl(CodePrinter p, CodeStream str, String indent, String type, String cSuffix,
            boolean returnArgs) {
        str.print(indent);
        str.print(type);
        str.print(" ");
        new HeadComputation(derivativeAnnotationUnrestricted(), "").prettyPrintHead(this, p, str, indent, cSuffix, returnArgs);
        str.print(" {\n");
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:188
     */
    public void genCloseFunctionDecl(CodePrinter p, CodeStream str, String indent) {
            str.print(indent);
            str.print("}\n\n");
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:193
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (!p.shouldPrintFuncDecl(this)) {
            return;
        }
        String next = p.indent(indent);
        genOpenFunctionDecl(p, str, indent, "void", p.functionDefSuffix(), true);
        ASTNode.genDynMemInit(str, next);
        p.printFunctionBody(this, str, next);
        genCloseFunctionDecl(p, str, indent);
        p.printExpFunc(this, str, indent);
   }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:234
     */
    public void genFunctionBodyAlgorithm(CodePrinter p, CodeStream str, String indent) {
        p.printVarDecls(this, str, indent);
        for (FFunctionVariable ffv : myNonInputs()) {
            if (!ffv.isArray()) {
                p.print(ffv, str, indent);
            }
        }
        p.print(getFAlgorithm(), str, indent);
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:244
     */
    public void prettyPrintExpFunc_C(CodePrinter p, CodeStream str, String indent) {
        String next = p.indent(indent);
        if (generateExpFunction()) {
            genOpenFunctionDecl(p, str, indent, getDeclaredType_C(p), C_SUFFIX_EXP, false);
            printDeclarationForExp_C(p, str, next);
            prettyPrintWrappedCall_C(p, str, next);
            printReturnForExp_C(p, str, next);
            genCloseFunctionDecl(p, str, indent);
        }
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:255
     */
    public void printReturnForExp_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent);
        str.print("return");
        if (myOutputs().size() > 0) { 
            str.print(" ");
            str.print(myOutputs().get(0).name_C());
        }
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:265
     */
    public void printDeclarationForExp_C(CodePrinter p, CodeStream str, String indent) {
        if (myOutputs().size() > 0) { 
            myOutputs().get(0).genVarDecls_C(p, str, indent);
        }
    }
    /**
     * @aspect CCodeGenFunctionReturn
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:278
     */
    public void printReturnWrite(CodePrinter p, CodeStream str, String indent) {
        for (FFunctionVariable v : myOutputs()) {
            if ((!v.isArray() && !v.isRecord()) || (v.isArray() && v.isString())) {
                p.printReturnWrite(v, str, indent);
            }
        }
        ASTNode.genDynMemFree(str, indent);
        str.print(indent + "return;\n");
    }
    /**
     * @aspect CCodeGenFunctionCall
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:327
     */
    @Override
    public void prettyPrintCall(CodePrinter p, CodeStream str, String indent, FFunctionCall call) {
        boolean exp = p.functionCallIsExp(call);
        if (!exp) {
            str.print(indent);
        } else if (call.type().isString()) {
            str.print(indent, p.ExecStep.name(call), " = ");
        }
        new FunctionCallParameterComputation("", call).prettyPrintHead(this, p, str, indent,
                exp ? C_SUFFIX_EXP : p.functionDefSuffix(), !exp);
        if (!exp || call.type().isString()) {
            str.print(";\n");
        }
    }
    /**
     * @aspect CCodeGenFunctionCall
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:470
     */
    private void prettyPrintWrappedCall_C(CodePrinter p, CodeStream str, String indent) {
        if (!p.shouldPrintFuncDecl(this)) {
            return;
        }
        str.print(indent);
        new ParameterComputation(derivativeAnnotationUnrestricted(), "") {
            @Override
            public void print(CodePrinter.ExecuteCodePrinter p, CodeStream str,
                    String indent, ArrayList<FFunctionVariable> variables) {
                printGeneric(p, str, indent, variables);
            }
        }
        .prettyPrintHead(this, p, str, indent, C_SUFFIX_DEF, myOutputs().size() > 0);
        str.print(";\n");
    }
    /**
     * \brief Generates forward declarations for FPCL and FPCR functions used
     * by partial function calls.
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:24
     */
    public void genHeadersPartial(CodePrinter p, CodeStream str, String indent) {
        prettyPrintHeadFPCL(p, str, indent);
        str.println(";");
        prettyPrintHeadFPCR(p, str, indent);
        str.println(";");
    }
    /**
     * \brief Generates FP and OUT structs used by partial function calls.
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:50
     */
    public void genStructsPartial(CodePrinter p, CodeStream str, String indent) {
        String fp  = p.funcNameUnderscore(this, C_SUFFIX_FP);
        String out = p.funcNameUnderscore(this, C_SUFFIX_FPOUT);
        String next = p.indent(indent);
        
        beginStruct_C(str, indent, out);
        str.formatln("%sint n;", next);
        new StructComputation()
        .print(myOutputs(), p, str, next);
        endStruct_C(str, indent);  
        
        beginStruct_C(str, indent, fp);
        str.formatln("%s%s (*fpcl)(%s*, %s*, ...);", next, getDeclaredType_C(p), fp, out);
        str.formatln("%s%s* (*fpcr)(%s*, %s*, ...);", next, fp, fp, fp);
        new StructComputation()
        .print(myInputs(), p, str, next);
        endStruct_C(str, indent);
    }
    /**
     * \brief Generate first line of struct declaration name_ with typedef to name
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:79
     */
    public static void beginStruct_C(CodeStream str, String indent, String name) {
        str.formatln("%stypedef struct %s_ %s;", indent, name, name);
        str.formatln("%sstruct %s_ {", indent, name);
    }
    /**
     * \brief Generate last line of struct declaration
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:87
     */
    public static void endStruct_C(CodeStream str, String indent) {
        str.formatln("%s};", indent);
    }
    /**
     * \brief Generate declaration for varargs
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:118
     */
    public void genVarArgsDecl(CodeStream str, String indent) {
        str.print(indent);
        str.println("va_list argp;");
    }
    /**
     * \brief Generate initialization for varargs
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:126
     */
    public void genVarArgsOpen(CodeStream str, String indent, String last) {
        str.print(indent);
        str.print("va_start(argp, ");
        str.print(last);
        str.println(");");
    }
    /**
     * \brief Generate closing for varargs
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:156
     */
    public void genVarArgsClose(CodeStream str, String indent) {
        str.print(indent);
        str.println("va_end(argp);");
    }
    /**
     * \brief Generate header for FPCL function.
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:164
     */
    public void prettyPrintHeadFPCL(CodePrinter p, CodeStream str, String indent) {
        str.format("%s%s %s(%s* fp_in, %s* out, ...)", indent, getDeclaredType_C(p),p.funcNameUnderscore(this, C_SUFFIX_FPCL),
                p.funcNameUnderscore(this, C_SUFFIX_FP), p.funcNameUnderscore(this, C_SUFFIX_FPOUT));
    }
    /**
     * \brief Generate header for FPCR function.
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:172
     */
    public void prettyPrintHeadFPCR(CodePrinter p, CodeStream str, String indent) {
        String fp = p.funcNameUnderscore(this, C_SUFFIX_FP);
        str.format("%s%s* %s(%s* fp_in, %s* fp_out, ...)", indent, fp, p.funcNameUnderscore(this, C_SUFFIX_FPCR), fp, fp);
    }
    /**
     * \brief Generates FPCL and FPCR functions used by partial function calls.
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:206
     */
    public void prettyPrintPartial_C(CodePrinter p, CodeStream str, String indent) {
int i;
        final String next = p.indent(indent);
        final String next2 = p.indent(next);
        final String next3 = p.indent(next2);
        final String fp = p.funcNameUnderscore(this, C_SUFFIX_FP);

        String[] inputNames = new String[p.numArguments(this, myInputs())];
        String[] outputNames = new String[p.numArguments(this, myOutputs())];

        //Initialize inputNames and outputNames
        new TempNameStructComputation() {
            private int tempIndex = 1;// shared state between invocations
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                tempNames[i] ="tmp_" + tempIndex++;
            }
        }
        .print(myInputs(), inputNames, p, str, next)
        .print(myOutputs(), outputNames, p, str, next);
        
        // FPCL
        prettyPrintHeadFPCL(p, str, indent);
        str.print(" {\n");
        
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                str.formatln("%s%s %s;", indent, p.type(v), tempNames[i]);
            }
        }
        .print(myInputs(), inputNames, p, str, next)
        .print(myOutputs(), outputNames, p, str, next);

        if(p.needsOutputVarArgs()) {
            new TempNameStructComputation() {
                @Override
                public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
                        String indent) {
                    str.println(next, p.type(v), " ", "*", p.name(v), ";");  
                }
            }
            .print(myOutputs(), outputNames, p, str, next);
        }

        //init input variables from either the input struct or input varargs
        genVarArgsDecl(str, next);
        genVarArgsOpen(str, next, "out");
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
              str.formatln("%sif (fp_in->%s_s) {", next, p.name(v));
              str.formatln("%s%s = fp_in->%s;", next2, tempNames[i], p.name(v));
              str.formatln("%s} else {", next);
              genVarArgsRead(str, next2, tempNames[i], p.type(v));
              str.formatln("%s}", next);
            }
        }
        .print(myInputs(), inputNames, p, str, indent);
        //init output variables from varargs
        if(p.needsOutputVarArgs()) {
            new TempNameStructComputation() {
                @Override
                public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
                        String indent) {
                    genVarArgsRead(str, next, p.name(v), p.type(v)+"*");
                }
            }
            .print(myOutputs(), outputNames, p, str, indent);
        }
        genVarArgsClose(str, next);
        
        str.print(next, p.funcNameUnderscore(this, C_SUFFIX_DEF), "(");
        new TempNameStructComputation() {
            private String sep = "";
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                str.print(sep);
                if(v.isOutput()) {
                    str.print("&");
                }
                str.print(tempNames[i]);
                sep = ", ";
            }
        }
        .print(myInputs(), inputNames, p, str, indent)
        .print(myOutputs(), outputNames, p, str, indent);
        str.println(");");
        
        //writeback variables to the output struct and/or output varargs
        str.formatln("%sif (out != NULL) {",next);
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
              str.formatln("%sif (out->n > %d) {", next2, iArg);
              if(p.codePrinter().needsOutputVarArgs()) {
                  str.formatln("%s%s = %s;", next3, "*"+p.name(v), tempNames[i]);
              }
              str.formatln("%sout->%s = %s;", next3, p.name(v), tempNames[i]);
              str.formatln("%s}", next2);
            }
        }
        .print(myOutputs(), outputNames, p, str, indent);
        str.formatln("%s}",next);
        if (myOutputs().size() > 0)
            str.formatln("%sreturn %s;", next, outputNames[0]);
        str.format("%s}\n\n", indent);
        
        
        // FPCR
        prettyPrintHeadFPCR(p, str, indent);
        str.print(" {\n");
        genVarArgsDecl(str, next);
        str.formatln("%sif (fp_out == NULL) {", next);
        str.formatln("%sfp_out = malloc(sizeof(%s));", next2, fp);
        str.formatln("%s}", next);
        
        str.formatln("%sfp_out->fpcl = &%s;", next, p.funcNameUnderscore(this, C_SUFFIX_FPCL));
        str.formatln("%sfp_out->fpcr = &%s;", next, p.funcNameUnderscore(this, C_SUFFIX_FPCR));
        
        str.formatln("%sif (fp_in == NULL) {", next);
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                str.formatln("%sfp_out->%s_s = 0;", next2, p.name(v));
            }
        }
        .print(myInputs(), inputNames, p, str, indent);
        str.formatln("%s} else {", next);
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                String name = p.name(v);
                str.formatln("%sfp_out->%s_s = fp_in->%s_s;", next2, name, name);
                str.formatln("%sfp_out->%s = fp_in->%s;", next2, name, name);
            }
        }
        .print(myInputs(), inputNames, p, str, indent);
        str.formatln("%s}", next);
        
        genVarArgsOpen(str, next, "fp_out");
        new TempNameStructComputation() {
            @Override
            public void print(FFunctionVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str,
            String indent) {
                String name = p.name(v);
                str.format("%sif (!fp_out->%s_s && ", next, name);
                genVarArgsRead(str, "int");
                str.println(") {");
                str.formatln("%sfp_out->%s_s = 1;", next2, name);
                genVarArgsRead(str, next2, "fp_out->" + name, p.type(v));
                str.formatln("%s}", next);
            }
        }
        .print(myInputs(), inputNames, p, str, indent);
        genVarArgsClose(str, next);
        
        str.formatln("%sreturn fp_out;", next);
        str.format("%s}\n\n", indent);
    }
    /**
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:55
     */
    private CodeGenContext codeGenContext = new CodeGenContext();
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:71
     */
    public void exportWrapper_C(CodeStream str, String indent) {
		// TODO: handle multiple outputs/array output

		// Function header
		str.format("%sDllExport %s %s(", indent, exportWrapperType_C(), funcNameExportWrapper());
		exportWrapperArgumentDecl_C(str);
		str.print(") {\n");
		
		// Function body
		// TODO: add conversions from/to our internal representations, where needed
		String bodyInd = printer_C.indent(indent);
		FFunctionVariable out = myOutputs().get(0);
		// - Declare return var
		str.print(bodyInd);
		out.exportWrapperDecl_C(str);
		str.print(";\n");
		// - Declare temporary vars
		for (FFunctionVariable var : myInputs()) 
			var.exportWrapperDeclareTemp_C(str, bodyInd);
		// - Initialize temporary vars
		for (FFunctionVariable var : myInputs()) 
			var.exportWrapperInitTemp_C(str, bodyInd);
		// - Call function
		str.format("%s%s(", bodyInd, funcNameUnderscore(C_SUFFIX_DEF));
		for (FFunctionVariable var : myInputs()) 
			str.format("%s, ", var.name_C());
		str.format("&%s);\n", out.name_C());
		// - Return value
		str.format("%sreturn %s;\n", bodyInd, out.name_C());
		
		str.format("%s}\n\n", indent);
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:104
     */
    public void exportWrapperArgumentDecl_C(CodeStream str) {
		// TODO: handle multiple outputs/array output
		String sep = "";
		for (FFunctionVariable var : myInputs()) {
			str.print(sep);
			var.exportWrapperDecl_C(str);
			sep = ", ";
		}
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:114
     */
    public void exportWrapperArgumentTypeDecl_C(CodeStream str) {
		// TODO: handle multiple outputs/array output
		String sep = "";
		for (FFunctionVariable var : myInputs()) {
			str.print(sep);
			var.exportWrapperTypeDecl_C(str);
			sep = ", ";
		}
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:124
     */
    public void exportWrapperArgumentCall_C(CodeStream str) {
		// TODO: handle multiple outputs/array output
		String sep = "";
		for (FFunctionVariable var : myInputs()) {
			str.print(sep);
			var.exportWrapperCall_C(str);
			sep = ", ";
		}
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:211
     */
    public static final Comparator<FFunctionDecl> UNAME_COMPARATOR = 
		new Comparator<FFunctionDecl>() {
		 public int compare(FFunctionDecl f1, FFunctionDecl f2) {
			 return f1.getFAccess().nameUnderscore().compareTo(f2.getFAccess().nameUnderscore());
		 }
		 
		 public boolean equals(Object obj) {
			 return obj == this;
		 }
	};
    /**
     * Puts the MX for all function variables in a single vector. Arrays
     * and records are flattened. 
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:69
     */
    MXVector getMXVectorForFuncVars(){
        MXVector MXVec = new MXVector();
        for (FFunctionVariable funcVar : getFFunctionVariables()) {
            MXVector funcVarMXVec = funcVar.asMXVector();
            for (int i = 0; i < funcVarMXVec.size(); ++i) {
                MXVec.add(funcVarMXVec.get(i));
            }
        }
        return MXVec;
    }
    /**
     * Calculates an inlined expression for all variables in this FFunctionDecl.
     * Handles the statements sequentially, and returns a vector with the expressions. 
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:85
     */
    MXVector generateFinalExpressionVector() {
        MXVector allVars = getMXVectorForFuncVars();
        MXVector expressions = getMXVectorForFuncVars();
        for (FStatement statement : getFAlgorithm().getFStatementList()) {
            if (statement instanceof FReturnStmt) {
                break;
            }
            expressions = statement.updateExpressionsAccordingToStatement(expressions, allVars);
        }
        return expressions;
    }
    /**
     * Collects the MX for the function variables that occur as inputs in 
     * A MXVector
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:102
     */
    MXVector generateInputVector() {
        MXVector allVars = getMXVectorForFuncVars();
        MXVector MXVec = new MXVector();
        for (FFunctionVariable funcVar : getFFunctionVariables()) {
            if (funcVar.isInput()) {
                MXVector funcVarMXVec = funcVar.asMXVector();
                for (int i = 0; i < funcVarMXVec.size(); ++i) {
                    MXVec.add(funcVarMXVec.get(i));
                }
            }    
        }
        return MXVec;
    }
    /**
     * Picks out the MX in the MXVector, that is supplied as input, that 
     * corresponds to variables that occur as output for this function. 
     * Assumes that the variables in the supplied vector is ordered in the
     * same way as the variables in this function's variable list. 
     * @param A MXVector mixedCausality
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:124
     */
    MXVector pickMXCorrespondingToOutputs(MXVector mixedCausality) {
        MXVector allVars = getMXVectorForFuncVars();
        MXVector MXVec = new MXVector();
        int index = 0;
        for (FFunctionVariable funcVar : getFFunctionVariables()) {
            if (funcVar.isOutput()) {
                for (int i = 0; i < funcVar.asMXVector().size(); ++i) {
                    MXVec.add(mixedCausality.get(index));
                    index++;
                }
            } else {
                index += funcVar.asMXVector().size();
            }    
        }
        return MXVec;
    }
    /** Is used for handling record variables 
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:613
     */
    private HashMap<String,MX> hashMapWithMXForRecordVariables = new HashMap<String, MX>();
    /**
     * Sets the passed in key,value-pair in the map, where the key should be the FAccess 
     * of a variable in a record, and value its symbolic MX. 
     * @param A String
     * @param A MX
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:655
     */
    public void setMXVariableInFunctionDeclRecordVariableMap(String key, MX val) {
        hashMapWithMXForRecordVariables.put(key, val);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionDecl() {
        super();
    }
    /**
     * Initializes the child array to the correct size.
     * Initializes List and Opt nta children.
     * @apilevel internal
     * @ast method
     * @declaredat ASTNode:10
     */
    public void init$Children() {
        children = new ASTNode[4];
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FAccess", "FFunctionVariable", "FAlgorithm", "FAttribute"},
        type = {"FAccess", "List<FFunctionVariable>", "FAlgorithm", "List<FAttribute>"},
        kind = {"Child", "List", "Child", "List"}
    )
    public FFunctionDecl(FAccess p0, List<FFunctionVariable> p1, FAlgorithm p2, List<FAttribute> p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        variablesMap_reset();
        myInputs_reset();
        myProtected_reset();
        myNonInputs_reset();
        myOutputs_reset();
        signatureString_reset();
        isInlinable_boolean_FFunctionCall_reset();
        isTrivialInlinable_boolean_FFunctionCall_reset();
        toMXFunction_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        contributorMap_FFunctionVariable_assigningUses = null;
        contributorMap_FStatement_sizeAssertsColl = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FFunctionDecl clone() throws CloneNotSupportedException {
        FFunctionDecl node = (FFunctionDecl) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:61
     */
    public FFunctionDecl copy() {
        try {
            FFunctionDecl node = (FFunctionDecl) clone();
            node.parent = null;
            if (children != null) {
                node.children = (ASTNode[]) children.clone();
            }
            return node;
        } catch (CloneNotSupportedException e) {
            throw new Error("Error: clone not supported for " + getClass().getName());
        }
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:80
     */
    @Deprecated
    public FFunctionDecl fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:90
     */
    public FFunctionDecl treeCopyNoTransform() {
        FFunctionDecl tree = (FFunctionDecl) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                ASTNode child = (ASTNode) children[i];
                if (child != null) {
                    child = child.treeCopyNoTransform();
                    tree.setChild(child, i);
                }
            }
        }
        return tree;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:110
     */
    public FFunctionDecl treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:115
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FAccess child.
     * @param node The new node to replace the FAccess child.
     * @apilevel high-level
     */
    public void setFAccess(FAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FAccess child.
     * @return The current node used as the FAccess child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAccess")
    public FAccess getFAccess() {
        return (FAccess) getChild(0);
    }
    /**
     * Retrieves the FAccess child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAccess child.
     * @apilevel low-level
     */
    public FAccess getFAccessNoTransform() {
        return (FAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the FFunctionVariable list.
     * @param list The new list node to be used as the FFunctionVariable list.
     * @apilevel high-level
     */
    public void setFFunctionVariableList(List<FFunctionVariable> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the FFunctionVariable list.
     * @return Number of children in the FFunctionVariable list.
     * @apilevel high-level
     */
    public int getNumFFunctionVariable() {
        return getFFunctionVariableList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FFunctionVariable list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FFunctionVariable list.
     * @apilevel low-level
     */
    public int getNumFFunctionVariableNoTransform() {
        return getFFunctionVariableListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FFunctionVariable list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FFunctionVariable list.
     * @apilevel high-level
     */
    public FFunctionVariable getFFunctionVariable(int i) {
        return (FFunctionVariable) getFFunctionVariableList().getChild(i);
    }
    /**
     * Check whether the FFunctionVariable list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFFunctionVariable() {
        return getFFunctionVariableList().getNumChild() != 0;
    }
    /**
     * Append an element to the FFunctionVariable list.
     * @param node The element to append to the FFunctionVariable list.
     * @apilevel high-level
     */
    public void addFFunctionVariable(FFunctionVariable node) {
        List<FFunctionVariable> list = (parent == null) ? getFFunctionVariableListNoTransform() : getFFunctionVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFFunctionVariableNoTransform(FFunctionVariable node) {
        List<FFunctionVariable> list = getFFunctionVariableListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FFunctionVariable list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFFunctionVariable(FFunctionVariable node, int i) {
        List<FFunctionVariable> list = getFFunctionVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FFunctionVariable list.
     * @return The node representing the FFunctionVariable list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FFunctionVariable")
    public List<FFunctionVariable> getFFunctionVariableList() {
        List<FFunctionVariable> list = (List<FFunctionVariable>) getChild(1);
        return list;
    }
    /**
     * Retrieves the FFunctionVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FFunctionVariable list.
     * @apilevel low-level
     */
    public List<FFunctionVariable> getFFunctionVariableListNoTransform() {
        return (List<FFunctionVariable>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the FFunctionVariable list without
     * triggering rewrites.
     */
    public FFunctionVariable getFFunctionVariableNoTransform(int i) {
        return (FFunctionVariable) getFFunctionVariableListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FFunctionVariable list.
     * @return The node representing the FFunctionVariable list.
     * @apilevel high-level
     */
    public List<FFunctionVariable> getFFunctionVariables() {
        return getFFunctionVariableList();
    }
    /**
     * Retrieves the FFunctionVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FFunctionVariable list.
     * @apilevel low-level
     */
    public List<FFunctionVariable> getFFunctionVariablesNoTransform() {
        return getFFunctionVariableListNoTransform();
    }
    /**
     * Replaces the FAlgorithm child.
     * @param node The new node to replace the FAlgorithm child.
     * @apilevel high-level
     */
    public void setFAlgorithm(FAlgorithm node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the FAlgorithm child.
     * @return The current node used as the FAlgorithm child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAlgorithm")
    public FAlgorithm getFAlgorithm() {
        return (FAlgorithm) getChild(2);
    }
    /**
     * Retrieves the FAlgorithm child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAlgorithm child.
     * @apilevel low-level
     */
    public FAlgorithm getFAlgorithmNoTransform() {
        return (FAlgorithm) getChildNoTransform(2);
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 3);
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * @return Number of children in the FAttribute list.
     * @apilevel high-level
     */
    public int getNumFAttribute() {
        return getFAttributeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAttribute list.
     * @apilevel low-level
     */
    public int getNumFAttributeNoTransform() {
        return getFAttributeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAttribute list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAttribute list.
     * @apilevel high-level
     */
    public FAttribute getFAttribute(int i) {
        return (FAttribute) getFAttributeList().getChild(i);
    }
    /**
     * Check whether the FAttribute list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAttribute() {
        return getFAttributeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAttribute list.
     * @param node The element to append to the FAttribute list.
     * @apilevel high-level
     */
    public void addFAttribute(FAttribute node) {
        List<FAttribute> list = (parent == null) ? getFAttributeListNoTransform() : getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAttribute list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAttribute(FAttribute node, int i) {
        List<FAttribute> list = getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAttribute")
    public List<FAttribute> getFAttributeList() {
        List<FAttribute> list = (List<FAttribute>) getChild(3);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(3);
    }
    /**
     * @return the element at index {@code i} in the FAttribute list without
     * triggering rewrites.
     */
    public FAttribute getFAttributeNoTransform(int i) {
        return (FAttribute) getFAttributeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    public List<FAttribute> getFAttributes() {
        return getFAttributeList();
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributesNoTransform() {
        return getFAttributeListNoTransform();
    }
    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1111
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FFunctionVariable_assigningUses = null;

    /** @apilevel internal */
    protected void survey_FFunctionVariable_assigningUses() {
        if (contributorMap_FFunctionVariable_assigningUses == null) {
            contributorMap_FFunctionVariable_assigningUses = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FFunctionVariable_assigningUses(this, contributorMap_FFunctionVariable_assigningUses);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:36
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FStatement_sizeAssertsColl = null;

    /** @apilevel internal */
    protected void survey_FStatement_sizeAssertsColl() {
        if (contributorMap_FStatement_sizeAssertsColl == null) {
            contributorMap_FStatement_sizeAssertsColl = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FStatement_sizeAssertsColl(this, contributorMap_FStatement_sizeAssertsColl);
        }
    }

    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3636
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3636")
    public CValue evaluatePartial(Map<CommonVariableDecl, CValue> values) {
        CValue evaluatePartial_Map_CommonVariableDecl__CValue__value = CValuePartialFunction.create(this, values);
        return evaluatePartial_Map_CommonVariableDecl__CValue__value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:64
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:64")
    public FAttribute findAttribute(String name) {
        FAttribute findAttribute_String_value = findMatching(getFAttributes(), name);
        return findAttribute_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:67
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:67")
    public FAbstractVariable lookupFV(String name) {
        {
                FAbstractVariable res = (tempLookupMap == null) ? null : tempLookupMap.lookup(name);
                if (res == null) {
        			res = variablesMap().lookup(name);
                }
        		return nullUnknown(res);
        	}
    }
    /** @apilevel internal */
    private void variablesMap_reset() {
        variablesMap_computed = false;
        
        variablesMap_value = null;
    }
    /** @apilevel internal */
    protected boolean variablesMap_computed = false;

    /** @apilevel internal */
    protected FlatVariableMap variablesMap_value;

    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:104")
    public FlatVariableMap variablesMap() {
        ASTState state = state();
        if (variablesMap_computed) {
            return variablesMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        variablesMap_value = new FlatVariableMap(getFFunctionVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        variablesMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return variablesMap_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:279")
    public FCallable lookupFunc(String name) {
        {
                for (FFunctionVariable ffv : getFFunctionVariables())
                    if (ffv.name().equals(name) && ffv.type().isFunction())
                        return ffv;
                return lookupFCallable(name);
            }
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:330")
    public String name() {
        String name_value = getFAccessNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:334
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:334")
    public String qualifiedName() {
        String qualifiedName_value = name();
        return qualifiedName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:431
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:431")
    public String funcNameUnderscore(String suffix) {
        String funcNameUnderscore_String_value = getFAccess().funcNameUnderscore(suffix) + functionIndex();
        return funcNameUnderscore_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1103
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1103")
    public FFunctionDecl asFFunctionDecl() {
        FFunctionDecl asFFunctionDecl_value = this;
        return asFFunctionDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1106")
    public FFunctionDecl actualFFunctionDecl() {
        FFunctionDecl actualFFunctionDecl_value = this;
        return actualFFunctionDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1109
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1109")
    public boolean isPartialFunction() {
        boolean isPartialFunction_value = false;
        return isPartialFunction_value;
    }
    /** @apilevel internal */
    private void myInputs_reset() {
        myInputs_computed = false;
        
        myInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myInputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<FFunctionVariable> myInputs_value;

    /**
     * Returns a list of all FFunctionVariables declared as "input".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1212")
    public ArrayList<FFunctionVariable> myInputs() {
        ASTState state = state();
        if (myInputs_computed) {
            return myInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myInputs_value = myInputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myInputs_value;
    }
    /** @apilevel internal */
    private ArrayList<FFunctionVariable> myInputs_compute() {
             ArrayList<FFunctionVariable> l = new ArrayList<FFunctionVariable>();
             for (FFunctionVariable var : getFFunctionVariables())
                 if (var.isInput())
                     l.add(var);
             return l;
         }
    /**
     * Returns the i:th FFunctionVariable that is  declared as "input".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1227")
    public FFunctionVariable myInput(int i) {
        FFunctionVariable myInput_int_value = myInputs().get(i);
        return myInput_int_value;
    }
    /** @apilevel internal */
    private void myProtected_reset() {
        myProtected_computed = false;
        
        myProtected_value = null;
    }
    /** @apilevel internal */
    protected boolean myProtected_computed = false;

    /** @apilevel internal */
    protected ArrayList<FFunctionVariable> myProtected_value;

    /**
     * Returns a list of all FFunctionVariables not declared as "input" or "output".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1233")
    public ArrayList<FFunctionVariable> myProtected() {
        ASTState state = state();
        if (myProtected_computed) {
            return myProtected_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myProtected_value = myProtected_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myProtected_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myProtected_value;
    }
    /** @apilevel internal */
    private ArrayList<FFunctionVariable> myProtected_compute() {
             ArrayList<FFunctionVariable> l = new ArrayList<FFunctionVariable>();
             for (FFunctionVariable var : myNonInputs())
                 if (!var.isOutput())
                     l.add(var);
             return l;
         }
    /** @apilevel internal */
    private void myNonInputs_reset() {
        myNonInputs_computed = false;
        
        myNonInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myNonInputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<FFunctionVariable> myNonInputs_value;

    /**
     * Returns a list of all FFunctionVariables not declared as "input".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1244
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1244")
    public ArrayList<FFunctionVariable> myNonInputs() {
        ASTState state = state();
        if (myNonInputs_computed) {
            return myNonInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myNonInputs_value = myNonInputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myNonInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myNonInputs_value;
    }
    /** @apilevel internal */
    private ArrayList<FFunctionVariable> myNonInputs_compute() {
             ArrayList<FFunctionVariable> l = new ArrayList<FFunctionVariable>();
             for (FFunctionVariable var : getFFunctionVariables())
                 if (!var.isInput())
                     l.add(var);
             return l;
         }
    /** @apilevel internal */
    private void myOutputs_reset() {
        myOutputs_computed = false;
        
        myOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myOutputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<FFunctionVariable> myOutputs_value;

    /**
     * Returns a list of all FFunctionVariables declared as "output".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1255")
    public ArrayList<FFunctionVariable> myOutputs() {
        ASTState state = state();
        if (myOutputs_computed) {
            return myOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myOutputs_value = myOutputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myOutputs_value;
    }
    /** @apilevel internal */
    private ArrayList<FFunctionVariable> myOutputs_compute() {
             ArrayList<FFunctionVariable> l = new ArrayList<FFunctionVariable>();
             for (FFunctionVariable var : getFFunctionVariables())
                 if (var.isOutput())
                     l.add(var);
             return l;
         }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1319
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1319")
    public boolean hasOutputs() {
        boolean hasOutputs_value = !myOutputs().isEmpty();
        return hasOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1324")
    public FFunctionVariable expOutput() {
        FFunctionVariable expOutput_value = myOutputs().get(0);
        return expOutput_value;
    }
    /**
     * Check if this function returns an array when used as an expression.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1338")
    public boolean isArray() {
        boolean isArray_value = hasOutputs() ? expOutput().isArray() : false;
        return isArray_value;
    }
    /**
     * Check if this function returns a record when used as an expression.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1343")
    public boolean isRecord() {
        boolean isRecord_value = hasOutputs() ? expOutput().type().isRecord() : false;
        return isRecord_value;
    }
    /**
     * Check if this function returns a non-primitive when used as an expression.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1348")
    public boolean isComposite() {
        boolean isComposite_value = hasOutputs() ? expOutput().isComposite() : false;
        return isComposite_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1350
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1350")
    public boolean containsRealInputs() {
        {
                for (FFunctionVariable var : myInputs())
                    if (var.type().containsReal())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1356")
    public boolean containsRealOutputs() {
        {
                for (FFunctionVariable var : myOutputs())
                    if (var.type().containsReal())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1363")
    public boolean requiresDerivative() {
        boolean requiresDerivative_value = true;
        return requiresDerivative_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1367")
    public boolean derivativeEqualsZero() {
        boolean derivativeEqualsZero_value = !containsRealInputs() || !containsRealOutputs();
        return derivativeEqualsZero_value;
    }
    /** @apilevel internal */
    private void signatureString_reset() {
        signatureString_computed = false;
        
        signatureString_value = null;
    }
    /** @apilevel internal */
    protected boolean signatureString_computed = false;

    /** @apilevel internal */
    protected String signatureString_value;

    /**
     * Returns a string (tersely) describing the signature of the function.
     * 
     * Intended to make it easier to compare the signatures of functions.
     * The string consists of one character for each input/output, followed by the number 
     * of dimensions. The inputs are first, followed by a colon, and then the oututs.
     * The characters used are R - Real, I - Integer, B - Boolean and S - String. 
     * Records are represented by the record name within parenthesis, followed by the number
     * of dimensions. Enumerations are treated the same way, but with brackets instead of 
     * parenthesis.
     * 
     * Example:
     * Inputs: Real, Integer[2], Real[:,4], outputs: Real, Real gives "r0i1r2:r0r0".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1383
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1383")
    public String signatureString() {
        ASTState state = state();
        if (signatureString_computed) {
            return signatureString_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        signatureString_value = signatureString_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        signatureString_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return signatureString_value;
    }
    /** @apilevel internal */
    private String signatureString_compute() {
             StringBuilder buf = new StringBuilder();
             for (FFunctionVariable v : myInputs())
                 buf.append(v.type().signatureString());
             buf.append(':');
             for (FFunctionVariable v : myOutputs())
                 buf.append(v.type().signatureString());
             return buf.toString();
         }
    /**
     * Check if this FFunctionDecl contains any active annotation attributes.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2003
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2003")
    public boolean containsActiveAnnotations() {
        {
                if (getNumFAttribute() == 0)
                    return false;
                for (AttributeContributer contributer : attributeContributers())
                    if (contributer.containsActiveAttributes(this))
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1508
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1508")
    public boolean isDestructor() {
        boolean isDestructor_value = false;
        return isDestructor_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1512
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1512")
    public boolean isConstructor() {
        boolean isConstructor_value = false;
        return isConstructor_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:554
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:554")
    public boolean isExternalFunction() {
        boolean isExternalFunction_value = getFirstExternalStmt() != null;
        return isExternalFunction_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:556
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:556")
    public FExternalStmt getFirstExternalStmt() {
        {
                for (FStatement stmt : getFAlgorithm().getFStatements()) {
                    if (stmt.isExternalStatement()) {
                        return (FExternalStmt) stmt;
                    }
                }
                return null;
            }
    }
    /**
     * Get the first derivative annotation on this function that match the given restrictions.
     * 
     * If no annotation matches, an empty AnnotationNode is returned.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:304
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:304")
    public AnnotationNode derivativeAnnotation(int order, Set<String> zero) {
        {
                for (AnnotationNode derNode : annotation().allFor("derivative")) {
                    int myOrder = derivativeOrder(derNode);
                    if ((myOrder == order || myOrder == 1) && zero.containsAll(zeroDerivative(derNode))) {
                        return derNode;
                    }
                }
                // None found, return a null node
                return annotation().emptyNode("derivative");
            }
    }
    /**
     * Return the first derivative annotation without restrictions on this function.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:318
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:318")
    public AnnotationNode derivativeAnnotationUnrestricted() {
        AnnotationNode derivativeAnnotationUnrestricted_value = derivativeAnnotation(1, Collections.<String>emptySet());
        return derivativeAnnotationUnrestricted_value;
    }
    /**
     * Get the order of a given derivative annotation.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:341
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:341")
    public int derivativeOrder(AnnotationNode derNode) {
        {
                AnnotationNode orderNode = derNode.forPath("order");
                return orderNode.exists() ? orderNode.integer() : 1;
            }
    }
    /**
     * Get the set of names given as zeroDerivative for a given derivative annotation.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:349
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:349")
    public Set<String> zeroDerivative(AnnotationNode derNode) {
        {
                Set<String> set = new HashSet<String>();
                for (AnnotationNode zeroNode : derNode.allFor("zeroDerivative")) {
                    set.add(zeroNode.fExp().asCommonAccess().name());
                }
                return set;
            }
    }
    /**
     * Get the set of names given as noDerivative for a given derivative annotation.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:360")
    public Set<String> noDerivative(AnnotationNode derNode) {
        {
                Set<String> set = new HashSet<String>();
                for (AnnotationNode noDerNode : derNode.allFor("noDerivative")) {
                    set.add(noDerNode.fExp().asCommonAccess().name());
                }
                return set;
            }
    }
    /**
     * Find the derivative function for the first derivative annotation without restrictions on this function.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:371
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:371")
    public FFunctionDecl derivativeFunctionUnrestricted() {
        FFunctionDecl derivativeFunctionUnrestricted_value = derivativeFunction(derivativeAnnotationUnrestricted());
        return derivativeFunctionUnrestricted_value;
    }
    /**
     * Find the derivative function for the given annotation node.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:377")
    public FFunctionDecl derivativeFunction(AnnotationNode derNode) {
        {
                FCallable fc = null;
                if (derNode != null && derNode.exists()) {
                    fc = derNode.fExp().asCommonAccess().myFCallable();
                }
                return (fc == null) ? null : fc.asFFunctionDecl();
            }
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:395
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:395")
    public boolean shouldVarBeDifferentiated(int i, AnnotationNode derNode) {
        {
                if (derNode.exists())
                    return calculateShouldBeDifferentiated(i, derNode);
                else
                    return getFFunctionVariable(i).type().shouldBeDifferentiated();
            }
    }
    /**
     * Calculate if variable no <code>i</code> in the variables the function should be differentiated.
     * 
     * Result is cached for all variables in list, and in subsequent calls it will be assumed that 
     * the list is the same.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:419
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:419")
    public boolean calculateShouldBeDifferentiated(int i, AnnotationNode derNode) {
        {
                if (cachedShouldBeDifferentiatedFor != derNode) {
                    List<FFunctionVariable> vars = getFFunctionVariables();
                    cachedShouldBeDifferentiated = new boolean[vars.getNumChild()];
                    cachedShouldBeDifferentiatedFor = derNode;
                    
                    // Type
                    boolean[] okType = new boolean[cachedShouldBeDifferentiated.length];
                    boolean[] input = new boolean[cachedShouldBeDifferentiated.length];
                    int n = 0;
                    int k = 0;
                    for (FFunctionVariable var : vars) {
                        okType[k] = var.type().shouldBeDifferentiated();
                        input[k] = var.isInput();
                        if (okType[k] && input[k]) 
                            n++;
                        k++;
                    }
                    
                    // noDerivative && zeroDerivative
                    Set<String> exclude = new HashSet<String>();
                    exclude.addAll(zeroDerivative(derNode));
                    exclude.addAll(noDerivative(derNode));
                    
                    int j = k = 0;
                    boolean[] hasDerivative = new boolean[n];
                    for (FFunctionVariable var : vars) {
                        if (okType[k] && input[k]) {
                            if (!exclude.contains(var.name()))
                                hasDerivative[j] = true;
                            j++;
                        }
                        k++;
                    }
                    
                    // order
                    int order = derivativeOrder(derNode);
                    int[] part = new int[order];
                    partitionArgumentsByOrder(hasDerivative, 0, n, order, part);
                    
                    // Calc result
                    int ignore = n - part[order - 1];
                    for (k = 0, j = 0; k < cachedShouldBeDifferentiated.length; k++) {
                        if (okType[k]) { 
                            if (input[k]) {
                                if (j >= ignore && hasDerivative[j])
                                    cachedShouldBeDifferentiated[k] = true;
                                j++;
                            } else {
                                cachedShouldBeDifferentiated[k] = true;
                            }
                        }
                    }
                }
                return cachedShouldBeDifferentiated[i];
            }
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = new FAttributeListAnnotationNode(this, instContext);
        return annotation_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:119
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GlobalsCleanup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:119")
    public boolean functionIsUsed() {
        boolean functionIsUsed_value = global().isUsed();
        return functionIsUsed_value;
    }
    /**
     * @attribute syn
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GlobalsCleanup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:120")
    public boolean functionIsUsedAsDerivative() {
        boolean functionIsUsedAsDerivative_value = global().derivativeUse();
        return functionIsUsedAsDerivative_value;
    }
    /**
     * Check if we can inline this function, given the inlining level set in <code>fi</code>.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1045
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1045")
    public boolean isInlinable(AbstractFunctionInliner fi, FFunctionCall call) {
        boolean isInlinable_AbstractFunctionInliner_FFunctionCall_value = fi.isInlinable(this, call);
        return isInlinable_AbstractFunctionInliner_FFunctionCall_value;
    }
    /** @apilevel internal */
    private void isInlinable_boolean_FFunctionCall_reset() {
        isInlinable_boolean_FFunctionCall_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map isInlinable_boolean_FFunctionCall_values;

    /**
     * Check if we can inline this function.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1072
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1072")
    public boolean isInlinable(boolean late, FFunctionCall call) {
        java.util.List _parameters = new java.util.ArrayList(2);
        _parameters.add(late);
        _parameters.add(call);
        if (isInlinable_boolean_FFunctionCall_values == null) isInlinable_boolean_FFunctionCall_values = new java.util.HashMap(4);
        ASTState state = state();
        if (isInlinable_boolean_FFunctionCall_values.containsKey(_parameters)) {
            return (Boolean) isInlinable_boolean_FFunctionCall_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        boolean isInlinable_boolean_FFunctionCall_value = inlineAnnotation().may() && (late || !inlineAnnotation().late()) && 
                isAllInlinable(getFAlgorithm().getFStatements()) && hasInlinableIO();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isInlinable_boolean_FFunctionCall_values.put(_parameters, isInlinable_boolean_FFunctionCall_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return isInlinable_boolean_FFunctionCall_value;
    }
    /** @apilevel internal */
    private void isTrivialInlinable_boolean_FFunctionCall_reset() {
        isTrivialInlinable_boolean_FFunctionCall_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map isTrivialInlinable_boolean_FFunctionCall_values;

    /**
     * Check if this function falls under the "trivial" inlining category.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1080
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1080")
    public boolean isTrivialInlinable(boolean late, FFunctionCall call) {
        java.util.List _parameters = new java.util.ArrayList(2);
        _parameters.add(late);
        _parameters.add(call);
        if (isTrivialInlinable_boolean_FFunctionCall_values == null) isTrivialInlinable_boolean_FFunctionCall_values = new java.util.HashMap(4);
        ASTState state = state();
        if (isTrivialInlinable_boolean_FFunctionCall_values.containsKey(_parameters)) {
            return (Boolean) isTrivialInlinable_boolean_FFunctionCall_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        boolean isTrivialInlinable_boolean_FFunctionCall_value = isTrivialInlinable_compute(late, call);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isTrivialInlinable_boolean_FFunctionCall_values.put(_parameters, isTrivialInlinable_boolean_FFunctionCall_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return isTrivialInlinable_boolean_FFunctionCall_value;
    }
    /** @apilevel internal */
    private boolean isTrivialInlinable_compute(boolean late, FFunctionCall call) {
            if (!inlineAnnotation().may())
                return false;
            if (!late && inlineAnnotation().late())
                return false;
            if (inlineAnnotation().always())
                return isInlinable(late, call);
            if (!late && call.derivativeAnnotation().exists())
                return false;
            if (myProtected().size() > 0) {
                return false;
            }
            if (!hasInlinableIO())
                return false;
            for (FStatement stmt : getFAlgorithm().getFStatements())
                if (!stmt.isOkTrivialInline())
                    return false;
            for (FFunctionVariable out : myOutputs()) {
                TrivialInlineCheck chk = out.createTrivialInlineCheck();
                for (FAccessExp use : out.assigningUses()) 
                    chk.check(use.getFAccess());
                if (!chk.isOk())
                    return false;
            }
            return true;
        }
    /**
     * @attribute syn
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:894
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SmoothOrder", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:894")
    public int smoothOrder() {
        int smoothOrder_value = readSmoothOrderAnnotation(annotation());
        return smoothOrder_value;
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:903
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:903")
    public FCallable diff(AnnotationNode derNode, boolean inFunction) {
        {
                if (smoothOrder() == 0 && !inFunction)
                    return null;
                FFunctionDecl func = derivativeFunction(derNode);
                if (func != null) 
                    return func;
                if (smoothOrder() == SMOOTH_ORDER_ANNOTATION_DEFAULT && !inFunction)
                    return null;
                return createAndAddDerivativeFunction(derNode);
            }
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1055
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1055")
    public int order() {
        int order_value = getFAlgorithm().order();
        return order_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Function";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = "fun";
        return xmlNamespace_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:69
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenFunctionDecl", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:69")
    public boolean shouldPrintFuncDecl_C() {
        boolean shouldPrintFuncDecl_C_value = functionIsUsed();
        return shouldPrintFuncDecl_C_value;
    }
    /**
     * Check if we need to generate a wrapper for expressions for this function.
     * @attribute syn
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:74
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenFunctionDecl", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:74")
    public boolean generateExpFunction() {
        boolean generateExpFunction_value = hasOutputs() && !isComposite();
        return generateExpFunction_value;
    }
    /**
     * Check if function should generate an export wrapper. 
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:30")
    public boolean hasExportWrapper_C() {
        {
        		if (myOutputs().size() != 1)
        			return false;
        		if (!myOutputs().get(0).type().isNumericScalar())
        			return false;
        		for (FFunctionVariable ffv : myInputs())
        			if (ffv.type().isRecord())
        				return false;
        		return true;
        	}
    }
    /**
     * The return type of the export wrapper of this function.
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:44")
    public String exportWrapperType_C() {
        String exportWrapperType_C_value = exportWrapperReturnsValue_C() ? myOutputs().get(0).exportWrapperType_C() : "void";
        return exportWrapperType_C_value;
    }
    /**
     * Check if the export wrapper for the function should have a return type. 
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:50
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:50")
    public boolean exportWrapperReturnsValue_C() {
        boolean exportWrapperReturnsValue_C_value = myOutputs().size() == 1 && myOutputs().get(0).type().isScalar();
        return exportWrapperReturnsValue_C_value;
    }
    /**
     * The name of the export wrapper of this function.
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:61
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:61")
    public String funcNameExportWrapper() {
        String funcNameExportWrapper_value = funcNameUnderscore(C_SUFFIX_EXPORT);
        return funcNameExportWrapper_value;
    }
    /** @apilevel internal */
    private void toMXFunction_reset() {
        toMXFunction_computed = false;
        
        toMXFunction_value = null;
    }
    /** @apilevel internal */
    protected boolean toMXFunction_computed = false;

    /** @apilevel internal */
    protected MXFunction toMXFunction_value;

    /**
     * Creates A MXFunction for this FFunctionDecl. The MXFunction requires a single expression
     * for all output variables, and only functions for which this is possible are supported. 
     * @return A MXFunction 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:52
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:52")
    public MXFunction toMXFunction() {
        ASTState state = state();
        if (toMXFunction_computed) {
            return toMXFunction_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        toMXFunction_value = toMXFunction_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        toMXFunction_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return toMXFunction_value;
    }
    /** @apilevel internal */
    private MXFunction toMXFunction_compute() {  
            MXVector finalExpressions = generateFinalExpressionVector();
            MXFunction f = new MXFunction(generateInputVector(),pickMXCorrespondingToOutputs(finalExpressions));
            f.setOption("name",new GenericType(name()));
            f.init();
            return f; 
        }
    /**
     * Does a recursive AST traversation up to the first encountered FFunctionDecl. The FFunctionDecl has an hash map that contains 
     * MX symbolic variables for records, and the MX for the passed in key (which should be equal to the FAccess of the variable) is returned. 
     * @param A String 
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:621
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:621")
    public MX getMXVariableFromRecordHashMap(String key) {
        MX getMXVariableFromRecordHashMap_String_value = hashMapWithMXForRecordVariables.get(key);
        return getMXVariableFromRecordHashMap_String_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2319
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2319")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:265
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:265")
    public FCallable lookupFCallable(String name) {
        FCallable lookupFCallable_String_value = getParent().Define_lookupFCallable(this, null, name);
        return lookupFCallable_String_value;
    }
    /**
     * Get the index of this function.
     * @attribute inh
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:447
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:447")
    public int functionIndex() {
        int functionIndex_value = getParent().Define_functionIndex(this, null);
        return functionIndex_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3427
     * @apilevel internal
     */
    public boolean Define_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return currentEvaluationValues != null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3427
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute duringFunctionEval
     */
    protected boolean canDefine_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154
     * @apilevel internal
     */
    public boolean Define_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isConstructor();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorStmt
     */
    protected boolean canDefine_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159
     * @apilevel internal
     */
    public boolean Define_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isDestructor();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorStmt
     */
    protected boolean canDefine_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     */
    public FAbstractVariable Define_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFV(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFV
     */
    protected boolean canDefine_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     */
    public FAbstractEquation Define_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parameterEquation
     */
    protected boolean canDefine_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241
     * @apilevel internal
     */
    public boolean Define_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inParameterEquation
     */
    protected boolean canDefine_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     */
    public boolean Define_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAttributeValue
     */
    protected boolean canDefine_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:264
     * @apilevel internal
     */
    public FCallable Define_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFunc(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:264
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFCallable
     */
    protected boolean canDefine_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1409
     * @apilevel internal
     */
    public boolean Define_inFunction(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1409
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunction
     */
    protected boolean canDefine_inFunction(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425
     * @apilevel internal
     */
    public FFunctionDecl Define_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingFFunctionDecl
     */
    protected boolean canDefine_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     */
    public String Define_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return nextGeneratedVarName(gvt);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcGeneratedVarName
     */
    protected boolean canDefine_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785
     * @apilevel internal
     */
    public boolean Define_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inNoEventExp
     */
    protected boolean canDefine_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:209
     * @apilevel internal
     */
    public CommonVariableDecl Define_myConstructorOutput(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myOutputs().get(0);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:209
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myConstructorOutput
     */
    protected boolean canDefine_myConstructorOutput(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:385
     * @apilevel internal
     */
    public boolean Define_delegateShouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFFunctionVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:387
            int i = _callerNode.getIndexOfChild(_childNode);
            return shouldVarBeDifferentiated(i, derivativeAnnotationUnrestricted());
        }
        else {
            return getParent().Define_delegateShouldBeDifferentiated(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:385
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute delegateShouldBeDifferentiated
     */
    protected boolean canDefine_delegateShouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:390
     * @apilevel internal
     */
    public boolean Define_shouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode, AnnotationNode derNode) {
        if (_callerNode == getFFunctionVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:392
            int i = _callerNode.getIndexOfChild(_childNode);
            return shouldVarBeDifferentiated(i, derNode);
        }
        else {
            return getParent().Define_shouldBeDifferentiated(this, _callerNode, derNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:390
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute shouldBeDifferentiated
     */
    protected boolean canDefine_shouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode, AnnotationNode derNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1837
     * @apilevel internal
     */
    public boolean Define_duringFunctionInlining(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return duringInlining;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1837
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute duringFunctionInlining
     */
    protected boolean canDefine_duringFunctionInlining(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     * @apilevel internal
     */
    public CodeGenContext Define_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return codeGenContext;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCodeGenContext
     */
    protected boolean canDefine_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
