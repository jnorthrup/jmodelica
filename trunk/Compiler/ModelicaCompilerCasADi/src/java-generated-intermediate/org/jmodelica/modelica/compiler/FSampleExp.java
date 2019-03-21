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
 * Sample built-in function.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1330
 * @astdecl FSampleExp : FBuiltInFunctionCall ::= Offset:FExp Interval:FExp;
 * @production FSampleExp : {@link FBuiltInFunctionCall} ::= <span class="component">Offset:{@link FExp}</span> <span class="component">Interval:{@link FExp}</span>;

 */
public class FSampleExp extends FBuiltInFunctionCall implements Cloneable {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:960
     */
    public FSampleExp createEmptyNode()      { return new FSampleExp();      }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1403
     */
    public FSampleExp(FExp a1, FExp a2)       { this(emptyArgs(), a1, a2); }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:143
     */
    public void complianceCheck(ErrorCheckType checkType) {
        ONLY_FMU_FUNCTION_LIKE_OPERATOR.invoke(this, "sample");
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2633
     */
    public FSampleExp flatten(Flattener f)    { return new FSampleExp(getOffset().flatten(f), getInterval().flatten(f)); }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1748
     */
    public FExp scalarizeExp(Scalarizer s)     { return new FSampleExp(getOffset().scalarize(s), getInterval().scalarize(s)); }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:355
     */
    private FSampleExp originalFSampleExp                = null;
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:366
     */
    public void setOriginalFExp(FSampleExp original)           { this.originalFSampleExp      = original; }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:390
     */
    @Override
    protected void resetOriginalReferences() {
        setOriginalFExp(this);
        super.resetOriginalReferences();
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:420
     */
    @Override
	protected void traverseSymbolic(ASTNode e) {
        setOriginalFExp(((FSampleExp)e).originalFExp());
		super.traverseSymbolic(e);
	}
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:125
     */
    public java.util.List<FAbstractEquation> extractEventGenEquation() {
        FExp interval = getInterval();
        FExp offset = getOffset();
        FAssignableExp var = tempUseExp();

        /*
         *  Create the when statement.
         */
        FPreExp preExp = new FPreExp(indexVariable().createFAccess());
        FExp mulExp = new FMulExp(new FAddExp(preExp.treeCopyNoTransform(), new FIntegerLitExp(1)), interval);
        FExp addExp = new FAddExp(offset.treeCopyNoTransform(), mulExp);

        FAbstractEquation assign = new FEquation(indexVariable().createAccessExp(),
                new FAddExp(preExp, new FIntegerLitExp(1)));
        FAbstractEquation when = new FWhenEquation(EquationType.NORMAL, new List<FAbstractEquation>(assign),
                var.treeCopyNoTransform(), new Opt<FIfWhenElseEquation>());

        /*
         *  Create the assert statement.
         */
        FExp ltExp = new FLtExp(new FTimeExp(), addExp);
        FAbstractEquation assertEq = new FFunctionCallEquation(new List<FFunctionCallLeft>(),
                new FAssert(ltExp, new FStringLitExp(SAMPLE_ASSERT_MESSAGE), new Opt<FExp>()));

        /*
         *  Add statements to the result list.
         */
        java.util.List<FAbstractEquation> eqns = new ArrayList<FAbstractEquation>();
        eqns.add(when);
        eqns.add(assertEq);

        return eqns;
    }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:161
     */
    public java.util.List<FAbstractEquation> extractEventGenInitialEquation() {
        java.util.List<FAbstractEquation> eqns = new ArrayList<FAbstractEquation>();
        FExp offset = getOffset();
        
        FExp subExp = new FSubExp(new FTimeExp(), offset.treeCopyNoTransform());
        FExp eval = new FCeilFuncExp(new List<InstFunctionArgument>(),
                new FDivExp(subExp, getInterval().treeCopyNoTransform())); 

        FExp guards = new FLtExp(new FTimeExp(), offset.treeCopyNoTransform());
        FIfExp ifExp = new FIfExp(guards, new FIntegerLitExp(0), eval);
        eqns.add(new FEquation(indexVariable().createAccessExp(), ifExp));
        return eqns;
    }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:175
     */
    public java.util.List<FStatement> extractEventGenStatement() {
        FExp interval = getInterval();
        FExp offset = getOffset();
        FAssignableExp var = tempUseExp();

        /*
         *  Create the when statement.
         */
        FPreExp preExp = new FPreExp(indexVariable().createFAccess());
        FExp mulExp = new FMulExp(new FAddExp(preExp.treeCopyNoTransform(), new FIntegerLitExp(1)), interval);
        FExp addExp = new FAddExp(offset.treeCopyNoTransform(), mulExp);

        FStatement assignStmt = new FAssignStmt(indexVariable().createAccessExp(),
                new FAddExp(preExp.treeCopyNoTransform(), new FIntegerLitExp(1)));
        FStatement when = new FWhenStmt(new List<FIfWhenClause>(new FWhenClause(
                var.treeCopyNoTransform(), new List<FStatement>(assignStmt))));

        /*
         *  Create the assert statement.
         */
        FExp ltExp = new FLtExp(new FTimeExp(), addExp);
        FStatement assertEq = new FFunctionCallStmt(new List<FFunctionCallLeft>(),
                new FAssert(ltExp, new FStringLitExp(SAMPLE_ASSERT_MESSAGE), new Opt<FExp>()));

        /*
         *  Add statements to the result list.
         */
        java.util.List<FStatement> stmts = new ArrayList<FStatement>();
        stmts.add(when);
        stmts.add(assertEq);

        return stmts;
    }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:209
     */
    private static final String SAMPLE_ASSERT_MESSAGE = "Too long time steps relative to sample interval.";
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:211
     */
    private FVariable indexVariable = null;
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:212
     */
    private FVariable indexVariable() {
        if (indexVariable == null) {
            indexVariable = new FIntegerVariable(VisibilityType.PUBLIC,
                    Variability.DISCRETE, new FAccessFull(calcIndexVarName()));
            myFClass().addFVariable(indexVariable);
        }
        return indexVariable;
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:728
     */
    @Override
    public void genTimeEvent_C(CodePrinter p, CodeStream str, String indent, String res) {
        /*
            There are three cases to consider for each sampler:
             1) The current time is (surely) before the offset of 
                the sampler. In this case, the next time event occurs
                at time offset.
             2) The current time is a sample instant of the sampler
                in which case next time event is the next sample
                instant.
             3) If neither of the above holds true, then the current
                time is in between two sample instants of the sampler.
                In this case, the next time event is the next sample
                instant.
        */
        super.genTempVars_C(p, str, indent);
        // Case 1: time is before offset 
        str.print("  if (SURELY_LT_ZERO(_t - (");
        p.print(getOffset(), str, indent);
        str.print("))) {\n");
        str.format("%sjmi_min_time_event(%s, 1, 0, ", indent, res);
        p.print(getOffset(), str, indent);
        str.println(");");
        //str.print("printf(\"Hepp: %f %f\\n\",_t,nextTimeEventTmp);\n");
        str.print("  } ");   
        // Case 2: we are at a sample                                   
        str.print(" else if (ALMOST_ZERO(jmi_dremainder(jmi, _t - (");
        p.print(getOffset(), str, indent);
        str.print("), ");
        p.print(getInterval(), str, indent);
        str.print("))) {\n");
        // nSamp should be almost an integer - round to get it exact
        str.print("    nSamp = jmi_dround((_t - (");
        p.print(getOffset(), str, indent);
        str.print(")) / (");
        p.print(getInterval(), str, indent);
        str.print("));\n");
        str.format("%sjmi_min_time_event(%s, 1, 0, ", indent, res);
        str.print("(nSamp + 1.0) * (");
        p.print(getInterval(), str, indent);
        str.print(") + (");
        p.print(getOffset(), str, indent);
        str.println("));");
/*----*//*
        str.print("printf(\"Hopp: %12.12f %12.12f %12.12f %12.12f\\n\",_t,nextTimeEventTmp,nSamp,");
        str.print("(_t-");
        p.print(getOffset(), str, indent);
        str.print(")/(");
        p.print(getInterval(), str, indent);
        str.print("));\n");

*//*---*/
        str.print("  } ");

        // Case 3: Neither of the above: in between samples
        str.print(" else if (SURELY_GT_ZERO(jmi_dremainder(jmi, _t - (");
        p.print(getOffset(), str, indent);
        str.print("), ");
        p.print(getInterval(), str, indent);
        str.print("))) {\n");
        // User the floor function to get the number of previous
        // samples
        str.print("    nSamp = floor((_t - (");
        p.print(getOffset(), str, indent);
        str.print(")) / (");
        p.print(getInterval(), str, indent);
        str.print("));\n");
        str.format("%sjmi_min_time_event(%s, 1, 0, ", indent, res);
        str.print("(nSamp + 1.0) * (");
        p.print(getInterval(), str, indent);
        str.print(") + (");
        p.print(getOffset(), str, indent);
        str.println("));");
/*----*//*
        str.print("printf(\"Hopp2: %12.12f %12.12f %12.12f %12.12f\\n\",_t,nextTimeEventTmp,nSamp,");
        str.print("(_t-");
        p.print(getOffset(), str, indent);
        str.print(")/(");
        p.print(getInterval(), str, indent);
        str.print("));\n");

*//*---*/
        str.print("  }\n");
        super.genTempFree_C(p, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:306
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        str.print("jmi_sample(jmi,");
        p.print(getOffset(),str,"");
        str.print(",");
        p.print(getInterval(),str,"");
        str.print(")");
    }
    /**
     * @declaredat ASTNode:1
     */
    public FSampleExp() {
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
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"OriginalArg", "Offset", "Interval"},
        type = {"List<InstFunctionArgument>", "FExp", "FExp"},
        kind = {"List", "Child", "Child"}
    )
    public FSampleExp(List<InstFunctionArgument> p0, FExp p1, FExp p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:31
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:35
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public FSampleExp clone() throws CloneNotSupportedException {
        FSampleExp node = (FSampleExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FSampleExp copy() {
        try {
            FSampleExp node = (FSampleExp) clone();
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
     * @declaredat ASTNode:68
     */
    @Deprecated
    public FSampleExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public FSampleExp treeCopyNoTransform() {
        FSampleExp tree = (FSampleExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 3:
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
     * @declaredat ASTNode:103
     */
    public FSampleExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:108
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
     * Replaces the Offset child.
     * @param node The new node to replace the Offset child.
     * @apilevel high-level
     */
    public void setOffset(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Offset child.
     * @return The current node used as the Offset child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Offset")
    public FExp getOffset() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the Offset child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Offset child.
     * @apilevel low-level
     */
    public FExp getOffsetNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the Interval child.
     * @param node The new node to replace the Interval child.
     * @apilevel high-level
     */
    public void setInterval(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the Interval child.
     * @return The current node used as the Interval child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Interval")
    public FExp getInterval() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the Interval child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Interval child.
     * @apilevel low-level
     */
    public FExp getIntervalNoTransform() {
        return (FExp) getChildNoTransform(2);
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(3);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 3;
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
        CValue cevalCalc_VariableEvaluator_value = CValue.UNKNOWN;
        return cevalCalc_VariableEvaluator_value;
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
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1569
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1569")
    public String calcIndexVarName() {
        String calcIndexVarName_value = calcGeneratedVarName(FlatVariableMap.GeneratedVarType.SAMPLE);
        return calcIndexVarName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817")
    public String builtInName() {
        String builtInName_value = "sample";
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
        type_value = type_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private FType type_compute() {
            for (FExp ch : childFExps())
                if (!ch.variability().parameterOrLess())
                    return fUnknownType();
            return fBooleanScalarType();
        }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = Variability.DISCRETE;
        return expVariability_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:361
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:361")
    public FSampleExp originalFExp() {
        FSampleExp originalFExp_value = (originalFSampleExp == null)       ? this : originalFSampleExp;
        return originalFExp_value;
    }
    /**
     * @attribute syn
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:221
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExtractEventGeneratingExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:221")
    public FExp eventTempExpUse() {
        FExp eventTempExpUse_value = tempUseExp();
        return eventTempExpUse_value;
    }
    /**
     * @attribute syn
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:226
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExtractEventGeneratingExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:226")
    public FExp eventTempExpCalc() {
        {
                FExp preExp = new FPreExp(indexVariable().createFAccess());
                FExp mulExp = new FMulExp(preExp, getInterval().treeCopyNoTransform());
                FExp addExp = new FAddExp(getOffset().treeCopyNoTransform(), mulExp);
                FExp notInitial = new FNotExp(new FInitialExp());
                FExp geqExp = new FGeqExp(new FTimeExp(), addExp);
                return new FAndExp(notInitial, geqExp);
            }
    }
    /**
     * Helper method which returns true if this expression is of the type 
     * FSampleExp.
     * @attribute syn
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:231
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenBlocks", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:231")
    public boolean isFSampleExp() {
        boolean isFSampleExp_value = true;
        return isFSampleExp_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_sampleExpsWithTimeEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2012
        if (generatesEventInDAE()) {
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
        super.collect_contributors_FClass_sampleExpsWithTimeEvent(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_eventGenExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:65
        if (inEquationSection() && generatesEvent()) {
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
        super.collect_contributors_FClass_eventGenExps(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FStatement_eventGenExps(FAlgorithm _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:79
        if (inEquationSection() && generatesEvent()) {
            {
                FStatement target = (FStatement) (myFStatement());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FStatement_eventGenExps(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_sampleExpsWithTimeEvent(ArrayList<FSampleExp> collection) {
        super.contributeTo_FClass_sampleExpsWithTimeEvent(collection);
        if (generatesEventInDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_eventGenExps(ArrayList<FExp> collection) {
        super.contributeTo_FClass_eventGenExps(collection);
        if (inEquationSection() && generatesEvent()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_eventGenExps(ArrayList<FExp> collection) {
        super.contributeTo_FStatement_eventGenExps(collection);
        if (inEquationSection() && generatesEvent()) {
            collection.add(this);
        }
    }
}
