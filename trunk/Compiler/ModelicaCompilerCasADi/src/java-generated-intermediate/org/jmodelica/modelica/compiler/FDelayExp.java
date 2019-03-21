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
 * The delay() operator.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1320
 * @astdecl FDelayExp : FBuiltInFunctionCall ::= FExp Delay:FExp [Max:FExp];
 * @production FDelayExp : {@link FBuiltInFunctionCall} ::= <span class="component">{@link FExp}</span> <span class="component">Delay:{@link FExp}</span> <span class="component">[Max:{@link FExp}]</span>;

 */
public class FDelayExp extends FBuiltInFunctionCall implements Cloneable {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:958
     */
    public FDelayExp createEmptyNode()       { return new FDelayExp();       }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1381
     */
    public FDelayExp createNode(FExp exp, FExp delay, Opt<FExp> max)    { return new FDelayExp(exp, delay, max); }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1415
     */
    public FDelayExp(FExp a1, FExp a2, Opt<FExp> a3) { this(emptyArgs(), a1, a2, a3); }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:190
     */
    public void complianceCheck(ErrorCheckType checkType) {
        ONLY_FMU_FUNCTION_LIKE_OPERATOR.invoke(this, "delay");
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1332
     */
    public void typeCheck(ErrorCheckType checkType) {
        boolean max = hasMax();
        boolean maxParam = max ? getMax().variability().parameterOrLess() : false;
        boolean delayParam = getDelay().variability().parameterOrLess();
        if (max && !maxParam) {
            DELAY_MAX_NOT_PARAMETER.invoke(this, getMax());
        }
        if (!max && !delayParam) {
            DELAY_NOT_PARAMETER.invoke(this, getDelay());
        }
        
        double maxVal = 0.0;
        boolean maxEval = false;
        if (max && maxParam) {
            try {
                CValue maxCVal = getMax().ceval();
                if (maxCVal.hasRealValue()) {
                    maxVal = maxCVal.realValue();
                    maxEval = true;
                }
            } catch (ConstantEvaluationException e) {}
        }
        double delayVal = 0.0;
        boolean delayEval = false;
        if (delayParam) {
            try {
                CValue delayCVal = getDelay().ceval();
                if (delayCVal.hasRealValue()) {
                    delayVal = delayCVal.realValue();
                    delayEval = true;
                }
            } catch (ConstantEvaluationException e) {}
        }
        if (maxEval && delayEval && delayVal > maxVal) {
            DELAY_OVER_MAX.invoke(this, getDelay(), delayVal, getMax(), maxVal);
        }
        if (delayEval && delayVal < 0.0) {
            DELAY_NEGATIVE.invoke(this, getDelay(), delayVal);
        }
        if (maxEval && maxVal < 0.0) {
            DELAY_MAX_NEGATIVE.invoke(this, getMax(), maxVal);
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2619
     */
    public FExp flatten(Flattener f)        { return createNode(getFExp().flatten(f), getDelay().flatten(f), hasMax() ? new Opt(getMax().flatten(f)) : new Opt()); }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1918
     */
    public FDelayExp scalarizeExp(Scalarizer s) {
        Opt max = hasMax() ? new Opt(getMax().scalarize(s)) : new Opt();
        return createNode(getFExp().scalarize(s), getDelay().scalarize(s), max);
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:497
     */
    @Override
    protected FExp diffExp(String name) {
        Opt max = hasMax() ? new Opt(getMax().copySymbolic()) : new Opt();
        FExp res = createNode(getFExp().diff(name), getDelay().copySymbolic(), max);
        if (getDelay().isContinuousExp()) {
            res = new FMulExp(getDelay().diff(name), res);
        }
        return res;
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:356
     */
    private FDelayExp originalFDelayExp                   = null;
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:367
     */
    public void setOriginalFExp(FDelayExp original)             { this.originalFDelayExp       = original; }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:396
     */
    @Override
    protected void resetOriginalReferences() {
        setOriginalFExp(this);
        super.resetOriginalReferences();
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:426
     */
    @Override
    protected void traverseSymbolic(ASTNode e) {
        setOriginalFExp(((FDelayExp)e).originalFExp());
        super.traverseSymbolic(e);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:515
     */
    @Override
    public void genEventResidualVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (!p.inInitialSystem()) {
            p.printVarDecls(getDelay(), str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:543
     */
    @Override
    public void genEventResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator) {
        if (p.inInitialSystem()) {
            str.formatln("%s(*res)[%d] = JMI_DELAY_INITIAL_EVENT_RES;", indent, enumerator.next());
            str.formatln("%s(*res)[%d] = JMI_DELAY_INITIAL_EVENT_RES;", indent, enumerator.next());
        } else {
            p.printPreSteps(getDelay(), str, indent);
            int index = myDelayIndex();
            str.format("%sjmi_delay_first_event_indicator(jmi, %d, ", indent, index);
            p.print(getDelay(), str, indent);
            str.print(", &(*res)[" + enumerator.next() + "]);\n");
            str.format("%sjmi_delay_second_event_indicator(jmi, %d, ", indent, index);
            p.print(getDelay(), str, indent);
            str.print(", &(*res)[" + enumerator.next() + "]);\n");
            p.printPostSteps(getDelay(), str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:843
     */
    @Override
    public void genRelExpKind(CodeStream str) {
        str.print(FRelExp.GEQ_C);
        str.print(", ");
        str.print(FRelExp.GEQ_C);
    }
    /**
     * Generate temp declarations for the initialization of delay blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1347
     */
    public void genInitVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        p.printVarDecls(getFExp(), str, indent);
        p.printVarDecls(myMaxDelayExp(), str, indent);
    }
    /**
     * Generate the initialization of delay blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1355
     */
    public void genInit_C(CodePrinter p, CodeStream str, String indent) {
        FExp maxDelayExp = myMaxDelayExp();
        boolean fixed = isTimeEventGenerating();
        p.printPreSteps(getFExp(), str, indent);
        p.printPreSteps(maxDelayExp, str, indent);
        
        str.format("%sjmi_delay_init(jmi, %d, ", indent, myDelayIndex());
        str.print(boolValue_C(fixed)); // jmi_boolean fixed
        str.print(", "); 
        str.print(boolValue_C(!generatesEventInDAE())); // jmi_boolean no_event
        str.print(", "); 
        p.print(fixed ? getDelay() : maxDelayExp, str, indent); // jmi_real_t max_delay
        str.print(", "); 
        p.print(getFExp(), str, indent); // jmi_real_t y0
        str.println(");");
        
        p.printPostSteps(getFExp(), str, indent);
        p.printPostSteps(maxDelayExp, str, indent);
    }
    /**
     * Generate temp declarations for the sampling of delay blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1386
     */
    public void genSampleVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        p.printVarDecls(getFExp(), str, indent);
    }
    /**
     * Generate the sampling of delay blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1393
     */
    public void genSample_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(getFExp(), str, indent);
        str.format("%sjmi_delay_record_sample(jmi, %d, ", indent, myDelayIndex());
        p.print(getFExp(), str, indent);
        str.println(");");
        p.printPostSteps(getFExp(), str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1401
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        str.format("jmi_delay_evaluate(jmi, %d, ", myDelayIndex());
        p.print(getFExp(), str, indent);
        str.print(", ");
        p.print(getDelay(), str, indent);
        str.print(")");
    }
    /**
     * @declaredat ASTNode:1
     */
    public FDelayExp() {
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
        children = new ASTNode[5];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"OriginalArg", "FExp", "Delay", "Max"},
        type = {"List<InstFunctionArgument>", "FExp", "FExp", "Opt<FExp>"},
        kind = {"List", "Child", "Child", "Opt"}
    )
    public FDelayExp(List<InstFunctionArgument> p0, FExp p1, FExp p2, Opt<FExp> p3) {
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
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        myDelayIndex_reset();
        myEventIndicatorIndex_reset();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FDelayExp clone() throws CloneNotSupportedException {
        FDelayExp node = (FDelayExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FDelayExp copy() {
        try {
            FDelayExp node = (FDelayExp) clone();
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
     * @declaredat ASTNode:75
     */
    @Deprecated
    public FDelayExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:85
     */
    public FDelayExp treeCopyNoTransform() {
        FDelayExp tree = (FDelayExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 4:
                    tree.children[i] = null;
                    continue;
                }
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
    public FDelayExp treeCopy() {
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
     * Replaces the OriginalArg list.
     * @param list The new list node to be used as the OriginalArg list.
     * @apilevel high-level
     */
    public void setOriginalArgList(List<InstFunctionArgument> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * @return Number of children in the OriginalArg list.
     * @apilevel high-level
     */
    public int getNumOriginalArg() {
        return getOriginalArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the OriginalArg list.
     * @apilevel low-level
     */
    public int getNumOriginalArgNoTransform() {
        return getOriginalArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the OriginalArg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the OriginalArg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getOriginalArg(int i) {
        return (InstFunctionArgument) getOriginalArgList().getChild(i);
    }
    /**
     * Check whether the OriginalArg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasOriginalArg() {
        return getOriginalArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the OriginalArg list.
     * @param node The element to append to the OriginalArg list.
     * @apilevel high-level
     */
    public void addOriginalArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getOriginalArgListNoTransform() : getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addOriginalArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getOriginalArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the OriginalArg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setOriginalArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="OriginalArg")
    public List<InstFunctionArgument> getOriginalArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(0);
        return list;
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the OriginalArg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getOriginalArgNoTransform(int i) {
        return (InstFunctionArgument) getOriginalArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getOriginalArgs() {
        return getOriginalArgList();
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgsNoTransform() {
        return getOriginalArgListNoTransform();
    }
    /**
     * Replaces the FExp child.
     * @param node The new node to replace the FExp child.
     * @apilevel high-level
     */
    public void setFExp(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the FExp child.
     * @return The current node used as the FExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FExp")
    public FExp getFExp() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the FExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FExp child.
     * @apilevel low-level
     */
    public FExp getFExpNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the Delay child.
     * @param node The new node to replace the Delay child.
     * @apilevel high-level
     */
    public void setDelay(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the Delay child.
     * @return The current node used as the Delay child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Delay")
    public FExp getDelay() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the Delay child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Delay child.
     * @apilevel low-level
     */
    public FExp getDelayNoTransform() {
        return (FExp) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the Max child. This is the <code>Opt</code>
     * node containing the child Max, not the actual child!
     * @param opt The new node to be used as the optional node for the Max child.
     * @apilevel low-level
     */
    public void setMaxOpt(Opt<FExp> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) Max child.
     * @param node The new node to be used as the Max child.
     * @apilevel high-level
     */
    public void setMax(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional Max child exists.
     * @return {@code true} if the optional Max child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasMax() {
        return getMaxOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Max child.
     * @return The Max child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getMax() {
        return (FExp) getMaxOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Max child. This is the <code>Opt</code> node containing the child Max, not the actual child!
     * @return The optional node for child the Max child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Max")
    public Opt<FExp> getMaxOpt() {
        return (Opt<FExp>) getChild(3);
    }
    /**
     * Retrieves the optional node for child Max. This is the <code>Opt</code> node containing the child Max, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Max.
     * @apilevel low-level
     */
    public Opt<FExp> getMaxOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(3);
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(4);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 4;
    }
    /** @apilevel internal */
    private void ndims_reset() {
        ndims_computed = false;
    }
    /** @apilevel internal */
    protected boolean ndims_computed = false;

    /** @apilevel internal */
    protected int ndims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228")
    public int ndims() {
        ASTState state = state();
        if (ndims_computed) {
            return ndims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ndims_value = vectorizedNdims();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /** @apilevel internal */
    private void size_reset() {
        size_computed = false;
        
        size_value = null;
    }
    /** @apilevel internal */
    protected boolean size_computed = false;

    /** @apilevel internal */
    protected Size size_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = vectorizedSize();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /** @apilevel internal */
    private void getArrayExp_reset() {
        getArrayExp_computed = false;
        
        getArrayExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getArrayExp_computed = false;

    /** @apilevel internal */
    protected ArrayExp getArrayExp_value;

    /**
     * Computes a generic array expansion of the expression. If this expression is not an array the result is undefined.
     * Normally {@link #getArray()} should be called instead.
     * 
     * This is used mainly to scalarize array expressions. Should be overridden for all 
     * expression types possible, since default implementation clones the original expression 
     * for each cell.
     * 
     * @return An ArrayExp with scalar expressions if this is an array expression, 
     * <code>null</code> otherwise.
     * @attribute syn nta
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367")
    public ArrayExp getArrayExp() {
        ASTState state = state();
        if (getArrayExp_computed) {
            return (ArrayExp) getChild(getArrayExpChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getArrayExp_value = getArrayExp_compute();
        setChild(getArrayExp_value, getArrayExpChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getArrayExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        ArrayExp node = (ArrayExp) this.getChild(getArrayExpChildPosition());
        return node;
    }
    /** @apilevel internal */
    private ArrayExp getArrayExp_compute() {
            ArrayExp arr = new ArrayExp(indices());
            for (Index i : arr.indices()) {
                arr.set(i, createNode(getFExp().getArray().get(i), getDelay().getArray().get(i), 
                        hasMax() ? new Opt(getMax().getArray().get(i)) : new Opt()));
            }
            return arr;
        }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public CValue cevalCalc(VariableEvaluator evaluator) {
        CValue cevalCalc_VariableEvaluator_value = getFExp().ceval(evaluator);
        return cevalCalc_VariableEvaluator_value;
    }
    /** @apilevel internal */
    private void myDelayIndex_reset() {
        myDelayIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean myDelayIndex_computed = false;

    /** @apilevel internal */
    protected int myDelayIndex_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1556
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1556")
    public int myDelayIndex() {
        ASTState state = state();
        if (myDelayIndex_computed) {
            return myDelayIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myDelayIndex_value = myFClass().myDelayExps().indexOf(originalFExp());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myDelayIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myDelayIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1964
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1964")
    public boolean isTimeEventGenerating() {
        boolean isTimeEventGenerating_value = getDelay().variability().parameterOrLess();
        return isTimeEventGenerating_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1989
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1989")
    public int mySwitchIndex() {
        int mySwitchIndex_value = myEventIndicatorIndex();
        return mySwitchIndex_value;
    }
    /** @apilevel internal */
    private void myEventIndicatorIndex_reset() {
        myEventIndicatorIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean myEventIndicatorIndex_computed = false;

    /** @apilevel internal */
    protected int myEventIndicatorIndex_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2001
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2001")
    public int myEventIndicatorIndex() {
        ASTState state = state();
        if (myEventIndicatorIndex_computed) {
            return myEventIndicatorIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myEventIndicatorIndex_value = myFClass().relExpsWithStateEvent().size() + myDelayEventIndicatorIndex();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myEventIndicatorIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myEventIndicatorIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2028
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2028")
    public int myDelayEventIndicatorIndex() {
        int myDelayEventIndicatorIndex_value = 2*checkIndex(myFClass().delayExpsWithStateEvent().indexOf(originalFExp()));
        return myDelayEventIndicatorIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114")
    public boolean hasEventGeneratingType() {
        boolean hasEventGeneratingType_value = true;
        return hasEventGeneratingType_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223")
    public FExp nominal() {
        FExp nominal_value = getFExp().nominal();
        return nominal_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817")
    public String builtInName() {
        String builtInName_value = "delay";
        return builtInName_value;
    }
    /** @apilevel internal */
    private void type_reset() {
        type_computed = false;
        
        type_value = null;
    }
    /** @apilevel internal */
    protected boolean type_computed = false;

    /** @apilevel internal */
    protected FType type_value;

    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = getFExp().type();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = getFExp().variability();
        return expVariability_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:362")
    public FDelayExp originalFExp() {
        FDelayExp originalFExp_value = (originalFDelayExp == null)        ? this : originalFDelayExp;
        return originalFExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1374")
    public FExp myMaxDelayExp() {
        FExp myMaxDelayExp_value = hasMax() ? getMax() : getDelay();
        return myMaxDelayExp_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1830
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1830")
    public boolean isInitial() {
        boolean isInitial_value = getParent().Define_isInitial(this, null);
        return isInitial_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416
     * @apilevel internal
     */
    public Size Define_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return vectorizedSize();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute vectorizedSize
     */
    protected boolean canDefine_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905
     * @apilevel internal
     */
    public boolean Define_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isArray();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inVectorizedCall
     */
    protected boolean canDefine_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2500
        if (isInitial()) {
            return rewriteRule0();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2500
     * @apilevel internal
     */
    private FExp rewriteRule0() {
{
            return getFExp().copySymbolic();
        }    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_myDelayExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1554
        {
            FClass target = (FClass) (myFClass());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FClass_myDelayExps(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_delayExpsWithStateEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2024
        if (generatesEventInDAE() && !isTimeEventGenerating()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_delayExpsWithStateEvent(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_delayExpInEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2167
        if (generatesEventInDAE()) {
            {
                FAbstractEquation target = (FAbstractEquation) (myFEquation());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_delayExpInEquation(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_replacedAtInitialExps(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2433
        {
            FAbstractEquation target = (FAbstractEquation) (myFEquation());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FAbstractEquation_replacedAtInitialExps(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myDelayExps(ArrayList<FDelayExp> collection) {
        super.contributeTo_FClass_myDelayExps(collection);
        collection.add(this);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_delayExpsWithStateEvent(ArrayList<FDelayExp> collection) {
        super.contributeTo_FClass_delayExpsWithStateEvent(collection);
        if (generatesEventInDAE() && !isTimeEventGenerating()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_delayExpInEquation(ArrayList<FDelayExp> collection) {
        super.contributeTo_FAbstractEquation_delayExpInEquation(collection);
        if (generatesEventInDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_replacedAtInitialExps(ArrayList<FExp> collection) {
        super.contributeTo_FAbstractEquation_replacedAtInitialExps(collection);
        collection.add(this);
    }
}
