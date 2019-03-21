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
 * Flattened for statement.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:691
 * @astdecl FForStmt : FStatement ::= Index:FForIndex ForStmt:FStatement* UnrolledForStmt:FStatement*;
 * @production FForStmt : {@link FStatement} ::= <span class="component">Index:{@link FForIndex}</span> <span class="component">ForStmt:{@link FStatement}*</span> <span class="component">UnrolledForStmt:{@link FStatement}*</span>;

 */
public class FForStmt extends FStatement implements Cloneable {
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:378
     */
    @Override
    public int evaluate(AlgorithmEvaluator evaluator) {
        CValue oldVal = getIndex().evaluationValue(evaluator);
        CValueArray ivals = getIndex().getFExp().ceval().array();
        int res = EVAL_CONT;
        for (Index i : ivals.indices()) {
            getIndex().setEvaluationValue(defaultVariableEvaluator(), ivals.getCell(i));
            res = getForStmts().evaluateList(evaluator);
            getForStmts().resetAfterCeval();
            if (res != EVAL_CONT) {
                break;
            }
        }
        getIndex().setEvaluationValue(defaultVariableEvaluator(), oldVal);
        return (res == EVAL_BREAK) ? EVAL_CONT : res;
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1480
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print("for ");
        p.print(getIndex(), str, indent);
        str.println(" loop");
        getForStmts().prettyPrintWithIndent(p, str, p.indent(indent), ";");
        str.print(indent, "end for");
    }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:170
     */
    public boolean flatten(Flattener f, List<FStatement> sl) {
        sl.add((FForStmt)(this.fullCopy()));
        return false;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1413
     */
    public void inline(AbstractFunctionInliner fi) {
        // Reduce to list of assignments
        List<FStatement> stmts = new List<FStatement>();
        inlinePrepare(fi, stmts);
        
        // Add assignments to tree temporarily
        List<FStatement> oldStmt = getForStmts();
        setForStmtList((List) stmts);
        getForStmtList();
        
        // Inline them
        for (FStatement stmt : stmts)
            stmt.inline(fi);
        
        // Restore old else branch
        setForStmtList(oldStmt);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1487
     */
    public void inlinePrepare(AbstractFunctionInliner fi, List<FStatement> stmts) {
        List<FStatement> oldStmts = getForStmts();
        FForIndex oldIndex = getIndex();
        
        // Prepare contents
        List<FStatement> newStmts = new List<FStatement>();
        for (FStatement stmt : oldStmts)
            stmt.inlinePrepare(fi, newStmts);
        setForStmtList((List) newStmts);
        
        // Unroll loop
        FExp loopExp = oldIndex.getFExp();
        loopExp = loopExp.dynamicFExp(loopExp.treeCopy()).replaceReferences(fi);
        FForIndex newIndex = new FForIndex(oldIndex.getFVariable(), loopExp);
        setIndex(newIndex);
        getUnrolledForStmtList_reset();
        stmts.addAll(getUnrolledForStmts());
        setForStmtList(oldStmts);
        setIndex(oldIndex);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1999
     */
    
        private class UnrollingScalarizer extends Scalarizer.Algorithm {
            
            private FAbstractVariable indexVariable;
            private FExp indexValue;
            
            public UnrollingScalarizer(List<FStatement> stmts, FAbstractVariable indexVariable, FExp indexValue) {
                super(new List<FFunctionVariable>(), stmts, new ForNames(), true, Variability.DISCRETE);
                this.indexVariable = indexVariable;
                this.indexValue = indexValue;
            }
            
            @Override
            public FExp scalarizeAccessExp(FAccessExp accessExp) {
                if (indexVariable.equals(accessExp.myFV())) {
                    return accessExp.setLocationOf(indexValue);
                }
                return super.scalarizeAccessExp(accessExp);
            }
            
            @Override
            public Algorithm block(List clauses) {
                return new UnrollingScalarizer(clauses, indexVariable, indexValue);
            }
            
            @Override
            public Algorithm block(List vars, List clauses) {
                return new UnrollingScalarizer(clauses, indexVariable, indexValue);
            }
        }
    /**
     * @aspect AlgorithmScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:100
     */
    @Override
    public void scalarize(Scalarizer.Algorithm s) {
        if (getNumForStmt() == 0) {
            return;
        }
        getIndex().createArrayTemporaries(s);
        FForStmt stmt = new FForStmt();
        List<FStatement> l = new List<FStatement>();
        stmt.setIndex(getIndex().scalarize(s));
        FStatement.scalarizeStmtList(s.block(l), getForStmts());
        stmt.setForStmtList(l);
        s.add(stmt);
    }
    /**
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:977
     */
    @Override
    public void diff(List<FStatement> diffed) {
        List<FStatement> statements = new List<FStatement>();
        for (FStatement statement : getForStmts())
            statement.diff(statements);
        diffed.add(new FForStmt(getIndex().fullCopy(), statements));
    }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:696
     */
    @Override
    public void acceptTransform(StatementTransformer tf)        { tf.visit(this); }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:364
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent){
        String namespace="fun";
        String tag = this.xmlTag();
        String stmtTag = "Statements";
        
        str.println(indent + "<" + namespace + ":" + tag + ">"); 
        //Index
        this.getIndex().prettyPrint_XML(str,p.indent(indent));
        //Statements
        str.println(indent + "\t<" + namespace + ":" + stmtTag + ">");
    	for (FStatement s : this.getForStmtList())
    		s.prettyPrint_XML(str,p.indent(indent+"\t"));
		str.println(indent + "\t</" + namespace + ":" + stmtTag + ">");;
    	
        str.println(indent + "</" + namespace + ":" + tag + ">"); 
     
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:275
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(getIndex(), str, indent);
        getIndex().printForIndexInit_C(p, str, indent);
        str.print(indent);
        str.print("for (");
        p.print(getIndex(), str, indent);
        str.print(") {\n");
        getIndex().printForIndexNext_C(p, str, p.indent(indent));
        p.print(getForStmts(), str, p.indent(indent));
        str.print(indent);
        str.print("}\n");
        p.printPostSteps(getIndex(), str, indent);
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:206
     */
    MXVector updateExpressionsAccordingToStatement(MXVector expressions, MXVector allVars) {
        for (FStatement stmt : getUnrolledForStmts()) {
            expressions = stmt.updateExpressionsAccordingToStatement(expressions, allVars);
        }
        return expressions;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FForStmt() {
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
        children = new ASTNode[3];
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Index", "ForStmt"},
        type = {"FForIndex", "List<FStatement>"},
        kind = {"Child", "List"}
    )
    public FForStmt(FForIndex p0, List<FStatement> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 2;
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
        getUnrolledForStmtList_reset();
        sortingAssignedNames_reset();
        sortingDependencies_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:46
     */
    public FForStmt clone() throws CloneNotSupportedException {
        FForStmt node = (FForStmt) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FForStmt copy() {
        try {
            FForStmt node = (FForStmt) clone();
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
     * @declaredat ASTNode:70
     */
    @Deprecated
    public FForStmt fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public FForStmt treeCopyNoTransform() {
        FForStmt tree = (FForStmt) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
                    tree.children[i] = List.EMPTY;
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
     * @declaredat ASTNode:105
     */
    public FForStmt treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Index child.
     * @param node The new node to replace the Index child.
     * @apilevel high-level
     */
    public void setIndex(FForIndex node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Index child.
     * @return The current node used as the Index child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Index")
    public FForIndex getIndex() {
        return (FForIndex) getChild(0);
    }
    /**
     * Retrieves the Index child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Index child.
     * @apilevel low-level
     */
    public FForIndex getIndexNoTransform() {
        return (FForIndex) getChildNoTransform(0);
    }
    /**
     * Replaces the ForStmt list.
     * @param list The new list node to be used as the ForStmt list.
     * @apilevel high-level
     */
    public void setForStmtList(List<FStatement> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the ForStmt list.
     * @return Number of children in the ForStmt list.
     * @apilevel high-level
     */
    public int getNumForStmt() {
        return getForStmtList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ForStmt list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ForStmt list.
     * @apilevel low-level
     */
    public int getNumForStmtNoTransform() {
        return getForStmtListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ForStmt list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ForStmt list.
     * @apilevel high-level
     */
    public FStatement getForStmt(int i) {
        return (FStatement) getForStmtList().getChild(i);
    }
    /**
     * Check whether the ForStmt list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasForStmt() {
        return getForStmtList().getNumChild() != 0;
    }
    /**
     * Append an element to the ForStmt list.
     * @param node The element to append to the ForStmt list.
     * @apilevel high-level
     */
    public void addForStmt(FStatement node) {
        List<FStatement> list = (parent == null) ? getForStmtListNoTransform() : getForStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addForStmtNoTransform(FStatement node) {
        List<FStatement> list = getForStmtListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ForStmt list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setForStmt(FStatement node, int i) {
        List<FStatement> list = getForStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the ForStmt list.
     * @return The node representing the ForStmt list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="ForStmt")
    public List<FStatement> getForStmtList() {
        List<FStatement> list = (List<FStatement>) getChild(1);
        return list;
    }
    /**
     * Retrieves the ForStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ForStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getForStmtListNoTransform() {
        return (List<FStatement>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the ForStmt list without
     * triggering rewrites.
     */
    public FStatement getForStmtNoTransform(int i) {
        return (FStatement) getForStmtListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ForStmt list.
     * @return The node representing the ForStmt list.
     * @apilevel high-level
     */
    public List<FStatement> getForStmts() {
        return getForStmtList();
    }
    /**
     * Retrieves the ForStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ForStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getForStmtsNoTransform() {
        return getForStmtListNoTransform();
    }
    /**
     * Retrieves the number of children in the UnrolledForStmt list.
     * @return Number of children in the UnrolledForStmt list.
     * @apilevel high-level
     */
    public int getNumUnrolledForStmt() {
        return getUnrolledForStmtList().getNumChild();
    }
    /**
     * Retrieves the number of children in the UnrolledForStmt list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the UnrolledForStmt list.
     * @apilevel low-level
     */
    public int getNumUnrolledForStmtNoTransform() {
        return getUnrolledForStmtListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the UnrolledForStmt list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the UnrolledForStmt list.
     * @apilevel high-level
     */
    public FStatement getUnrolledForStmt(int i) {
        return (FStatement) getUnrolledForStmtList().getChild(i);
    }
    /**
     * Check whether the UnrolledForStmt list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasUnrolledForStmt() {
        return getUnrolledForStmtList().getNumChild() != 0;
    }
    /**
     * Append an element to the UnrolledForStmt list.
     * @param node The element to append to the UnrolledForStmt list.
     * @apilevel high-level
     */
    public void addUnrolledForStmt(FStatement node) {
        List<FStatement> list = (parent == null) ? getUnrolledForStmtListNoTransform() : getUnrolledForStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addUnrolledForStmtNoTransform(FStatement node) {
        List<FStatement> list = getUnrolledForStmtListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the UnrolledForStmt list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setUnrolledForStmt(FStatement node, int i) {
        List<FStatement> list = getUnrolledForStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the UnrolledForStmt list.
     * @return The the child position of the UnrolledForStmt list.
     * @apilevel low-level
     */
    protected int getUnrolledForStmtListChildPosition() {
        return 2;
    }
    /**
     * Retrieves the UnrolledForStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the UnrolledForStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getUnrolledForStmtListNoTransform() {
        return (List<FStatement>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the UnrolledForStmt list without
     * triggering rewrites.
     */
    public FStatement getUnrolledForStmtNoTransform(int i) {
        return (FStatement) getUnrolledForStmtListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the UnrolledForStmt list.
     * @return The node representing the UnrolledForStmt list.
     * @apilevel high-level
     */
    public List<FStatement> getUnrolledForStmts() {
        return getUnrolledForStmtList();
    }
    /**
     * Retrieves the UnrolledForStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the UnrolledForStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getUnrolledForStmtsNoTransform() {
        return getUnrolledForStmtListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:48")
    public boolean containsBreakStmt() {
        {
                return false;
            }
    }
    /**
     * Helper method to find unsupported statements in isTrivialInlinable().
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1124
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1124")
    public boolean isOkTrivialInline() {
        boolean isOkTrivialInline_value = isOkTrivialInlineInFor();
        return isOkTrivialInline_value;
    }
    /**
     * Helper method to unsupported statements in isTrivialInlinable().
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1140")
    public boolean isOkTrivialInlineInFor() {
        {
                for (FStatement stmt : getForStmts())
                    if (!stmt.isOkTrivialInlineInFor())
                        return false;
                return true;
            }
    }
    /**
     * Check if we can inline this statement.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1276
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1276")
    public boolean isInlinable() {
        boolean isInlinable_value = isAllInlinable(getForStmts());
        return isInlinable_value;
    }
    /** @apilevel internal */
    private void getUnrolledForStmtList_reset() {
        getUnrolledForStmtList_computed = false;
        
        getUnrolledForStmtList_value = null;
    }
    /** @apilevel internal */
    protected boolean getUnrolledForStmtList_computed = false;

    /** @apilevel internal */
    protected List<FStatement> getUnrolledForStmtList_value;

    /**
     * @attribute syn nta
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1986
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1986")
    public List<FStatement> getUnrolledForStmtList() {
        ASTState state = state();
        if (getUnrolledForStmtList_computed) {
            return (List<FStatement>) getChild(getUnrolledForStmtListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getUnrolledForStmtList_value = getUnrolledForStmtList_compute();
        if(getUnrolledForStmtList_value.numChildren() <= 0) {
            getUnrolledForStmtList_value  = List.EMPTY;
        }
        setChild(getUnrolledForStmtList_value, getUnrolledForStmtListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getUnrolledForStmtList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<FStatement> node = (List<FStatement>) this.getChild(getUnrolledForStmtListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<FStatement> getUnrolledForStmtList_compute() {
            List<FStatement> unrolledForStmts = new List<>();
            
            FVariable index = getIndex().getFVariable();
            FExp loopExp = getIndex().getFExp();
            for (FExp e : loopExp.getArray().iterable()) {
                UnrollingScalarizer s = new UnrollingScalarizer(unrolledForStmts, index, e);
                scalarizeStmtList(s, getForStmts());
            }
            return unrolledForStmts;
        }
    /** @apilevel internal */
    private void sortingAssignedNames_reset() {
        sortingAssignedNames_computed = false;
        
        sortingAssignedNames_value = null;
    }
    /** @apilevel internal */
    protected boolean sortingAssignedNames_computed = false;

    /** @apilevel internal */
    protected Set<String> sortingAssignedNames_value;

    /**
     * @attribute syn
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenInitArrayStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:108")
    public Set<String> sortingAssignedNames() {
        ASTState state = state();
        if (sortingAssignedNames_computed) {
            return sortingAssignedNames_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        sortingAssignedNames_value = sortingAssignedNames(getForStmts());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingAssignedNames_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingAssignedNames_value;
    }
    /** @apilevel internal */
    private void sortingDependencies_reset() {
        sortingDependencies_computed = false;
        
        sortingDependencies_value = null;
    }
    /** @apilevel internal */
    protected boolean sortingDependencies_computed = false;

    /** @apilevel internal */
    protected Set<String> sortingDependencies_value;

    /**
     * @attribute syn
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenInitArrayStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:150")
    public Set<String> sortingDependencies() {
        ASTState state = state();
        if (sortingDependencies_computed) {
            return sortingDependencies_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        sortingDependencies_value = addCompoundStmtSortingDependencies(baseSortingDependencies(), getIndex(), getForStmts());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingDependencies_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingDependencies_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "For";
        return xmlTag_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     */
    public FAbstractVariable Define_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getForStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:80
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getIndex().localLookupFV(name);
        }
        else {
            return getParent().Define_lookupFV(this, _callerNode, name);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1466
     * @apilevel internal
     */
    public boolean Define_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1466
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute insideBlockStmt
     */
    protected boolean canDefine_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:930
     * @apilevel internal
     */
    public FStatement Define_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getForStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:934
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return this;
        }
        else {
            return getParent().Define_enclosingLoop(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:930
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingLoop
     */
    protected boolean canDefine_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1256
     * @apilevel internal
     */
    public boolean Define_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getForStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1257
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_inForLoop(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1256
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inForLoop
     */
    protected boolean canDefine_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     * @apilevel internal
     */
    public boolean Define_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getForStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:569
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_needsIndicatorInit(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute needsIndicatorInit
     */
    protected boolean canDefine_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
