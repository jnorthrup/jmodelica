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
 * Flattened if statement.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:659
 * @astdecl FIfStmt : FIfWhenStmt ::= ElseStmt:FStatement*;
 * @production FIfStmt : {@link FIfWhenStmt} ::= <span class="component">ElseStmt:{@link FStatement}*</span>;

 */
public class FIfStmt extends FIfWhenStmt implements Cloneable {
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:359
     */
    @Override
    public int evaluateElse(AlgorithmEvaluator evaluator) {
        return getElseStmts().evaluateList(evaluator);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1307
     */
    public FIfStmt createEmptyNode()   { return new FIfStmt(); }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2579
     */
    public void addAsInitial(ArrayList<FStatement> stmts, Set<FAccessExp> usesLHS, 
            Set<FVariable> fvSet, Set<FVariable> fvUse) {
        
        if (!isWhen()) {
            super.addAsInitial(stmts, usesLHS, fvSet, fvUse);
            return;
        }
        
        boolean first = true;
        for (FIfWhenClause c : getFIfWhenClauses()) {
            if (c.getTest().isInitialGuard() && first) {
                for (FStatement s : c.getFStatements()) {
                    s.defSet(fvSet, fvUse);
                    stmts.add(s.copySymbolic());
                }
                first = false;
            } else {
                usesLHS.removeAll(c.findFAccessExpsInTree());
            }
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1460
     */
    protected void prettyPrintElse(Printer p, CodeStream str, String indent) {
        if (getNumElseStmt() > 0) {
            str.println(indent, "else");
            getElseStmts().prettyPrintWithIndent(p, str, p.indent(indent), ";");
        }
    }
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:481
     */
    public boolean lockMyBranch(ErrorCheckType checkType, int i) {
        if (i == 0) {
            return lockBranch(checkType);
        } else {
            FIfWhenClause next = getFIfWhenClause(i - 1);
            return lockMyBranch(next, checkType, next.getTest(), false);
        }
    }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:114
     */
    public boolean flatten(Flattener f, List<FStatement> sl) {
        for (FIfWhenClause c : getFIfWhenClauses()) {
            c.getTest().addForIndexRangeAsserts(f, sl);
        }
        boolean res = false;
        boolean hasBroken = false;
        List cl = new List();
        boolean first = true;
        for (FIfWhenClause c : getFIfWhenClauses()) {
            if (c.getTest().variability().indexParameterOrLess()) {
                try {
                    CValue val = c.getTest().ceval();
                    if (val.hasBooleanValue()) { 
                        if (!val.booleanValue()) {
                            continue;
                        } else if (first) {
                            return FStatement.flattenFStatementList(f, c.getFStatements(), sl) || hasBroken;
                        } else {
                            List l = new List();
                            hasBroken = FStatement.flattenFStatementList(f, c.getFStatements(), l) || hasBroken;
                            sl.add(new FIfStmt(cl, l));
                            return hasBroken;
                        }
                    }
                } catch (ConstantEvaluationException e) {}
            }
            first = false;
            hasBroken = c.flatten(f, cl) || hasBroken;
        }
        if (first) {
            return FStatement.flattenFStatementList(f, getElseStmts(), sl) || hasBroken;
        }
        List l = new List();
        hasBroken = FStatement.flattenFStatementList(f, getElseStmts(), l) || hasBroken;
        sl.add(new FIfStmt(cl, l));
        return hasBroken;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1395
     */
    public void inline(AbstractFunctionInliner fi) {
        // Reduce to list of assignments
        List<FStatement> stmts = new List<FStatement>();
        inlinePrepare(fi, stmts);
        
        // Add assignments to tree temporarily
        List<FStatement> oldElse = getElseStmts();
        setElseStmtList((List) stmts);
        getElseStmtList();
        
        // Inline them
        for (FStatement stmt : stmts)
            stmt.inline(fi);
        
        // Restore old else branch
        setElseStmtList(oldElse);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1451
     */
    public void inlinePrepare(AbstractFunctionInliner fi, List<FStatement> stmts) {
        List<FStatement> oldElse = getElseStmts();
        
        // Prepare contents
        List<FStatement> newElse = new List<FStatement>();
        for (FStatement stmt : oldElse)
            stmt.inlinePrepare(fi, newElse);
        setElseStmtList((List) newElse);
        
        // Combine branches to assignments with if-else expressions
        for (int i = getNumFIfWhenClause() - 1; i >= 0; i--) {
            newElse = getFIfWhenClause(i).inlineCombineBranches(fi, newElse);
            setElseStmtList((List) newElse);
        }
        
        // Write result to target list
        for (FStatement stmt : newElse)
            stmts.add(stmt);
        setElseStmtList(oldElse);
    }
    /**
     * @aspect AlgorithmScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:83
     */
    public void scalarizeElse(Scalarizer.Algorithm s, FIfWhenStmt stmt) {
        FIfStmt ifstmt = (FIfStmt) stmt;
        List<FStatement> l = new List<FStatement>();
        FStatement.scalarizeStmtList(s.block(l), getElseStmts());
        ifstmt.setElseStmtList(l);
    }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:693
     */
    @Override
    public void acceptTransform(StatementTransformer tf)         { tf.visit(this); }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:316
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent){
        String namespace="fun";
        String tag = this.xmlTag();
        String elseIfTag = "ElseIf";
        String elseTag = "Else";
        
        //opening tag
        str.println(indent + "<" + namespace + ":" + tag + ">"); 
        
        //then branch
        this.getFIfWhenClause(0).prettyPrint_XML(str,p.indent(indent));
        
        //elseif branches
        if(this.getNumFIfWhenClause()>1){
        	for (int i=1; i< this.getNumFIfWhenClause(); i++){
        		str.println(indent + "\t<" + namespace + ":" + elseIfTag + ">");
        		this.getFIfWhenClause(i).prettyPrint_XML(str,p.indent(indent+"\t"));
        		str.println(indent + "\t</" + namespace + ":" + elseIfTag + ">");
        	}
        }
        
       //else branch
        if (this.getNumElseStmt()!=0){
            str.println(indent + "\t<" + namespace + ":" + elseTag + ">");
        	for (FStatement s : this.getElseStmtList())
        		s.prettyPrint_XML(str,p.indent(indent+"\t"));
    		str.println(indent + "\t</" + namespace + ":" + elseTag + ">");
        }
	
		//closing tag
        str.println(indent + "</" + namespace + ":" + tag + ">");        
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:244
     */
    protected void prettyPrintElse_C(CodePrinter p, CodeStream str, String indent) {
        if (getNumElseStmt() > 0) {
            str.print(indent);
            str.print("} else {\n");
            p.print(getElseStmts(), str, p.indent(indent));
        }
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:202
     */
    MXVector updateExpressionsAccordingToStatement(MXVector expressions, MXVector allVars) {
        throw new UnsupportedOperationException("If-Statements are unsupported (try to rewrite into if-expressions): " + toString());
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIfStmt() {
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
        children = new ASTNode[2];
        setChild(List.EMPTY, 0);
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FIfWhenClause", "ElseStmt"},
        type = {"List<FIfWhenClause>", "List<FStatement>"},
        kind = {"List", "List"}
    )
    public FIfStmt(List<FIfWhenClause> p0, List<FStatement> p1) {
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
        sortingAssignedNames_reset();
        sortingDependencies_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:41
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public FIfStmt clone() throws CloneNotSupportedException {
        FIfStmt node = (FIfStmt) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public FIfStmt copy() {
        try {
            FIfStmt node = (FIfStmt) clone();
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
     * @declaredat ASTNode:69
     */
    @Deprecated
    public FIfStmt fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public FIfStmt treeCopyNoTransform() {
        FIfStmt tree = (FIfStmt) copy();
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
     * @declaredat ASTNode:99
     */
    public FIfStmt treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:104
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FIfWhenClause list.
     * @param list The new list node to be used as the FIfWhenClause list.
     * @apilevel high-level
     */
    public void setFIfWhenClauseList(List<FIfWhenClause> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FIfWhenClause list.
     * @return Number of children in the FIfWhenClause list.
     * @apilevel high-level
     */
    public int getNumFIfWhenClause() {
        return getFIfWhenClauseList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FIfWhenClause list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FIfWhenClause list.
     * @apilevel low-level
     */
    public int getNumFIfWhenClauseNoTransform() {
        return getFIfWhenClauseListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FIfWhenClause list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FIfWhenClause list.
     * @apilevel high-level
     */
    public FIfWhenClause getFIfWhenClause(int i) {
        return (FIfWhenClause) getFIfWhenClauseList().getChild(i);
    }
    /**
     * Check whether the FIfWhenClause list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFIfWhenClause() {
        return getFIfWhenClauseList().getNumChild() != 0;
    }
    /**
     * Append an element to the FIfWhenClause list.
     * @param node The element to append to the FIfWhenClause list.
     * @apilevel high-level
     */
    public void addFIfWhenClause(FIfWhenClause node) {
        List<FIfWhenClause> list = (parent == null) ? getFIfWhenClauseListNoTransform() : getFIfWhenClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFIfWhenClauseNoTransform(FIfWhenClause node) {
        List<FIfWhenClause> list = getFIfWhenClauseListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FIfWhenClause list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFIfWhenClause(FIfWhenClause node, int i) {
        List<FIfWhenClause> list = getFIfWhenClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FIfWhenClause list.
     * @return The node representing the FIfWhenClause list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FIfWhenClause")
    public List<FIfWhenClause> getFIfWhenClauseList() {
        List<FIfWhenClause> list = (List<FIfWhenClause>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FIfWhenClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FIfWhenClause list.
     * @apilevel low-level
     */
    public List<FIfWhenClause> getFIfWhenClauseListNoTransform() {
        return (List<FIfWhenClause>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FIfWhenClause list without
     * triggering rewrites.
     */
    public FIfWhenClause getFIfWhenClauseNoTransform(int i) {
        return (FIfWhenClause) getFIfWhenClauseListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FIfWhenClause list.
     * @return The node representing the FIfWhenClause list.
     * @apilevel high-level
     */
    public List<FIfWhenClause> getFIfWhenClauses() {
        return getFIfWhenClauseList();
    }
    /**
     * Retrieves the FIfWhenClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FIfWhenClause list.
     * @apilevel low-level
     */
    public List<FIfWhenClause> getFIfWhenClausesNoTransform() {
        return getFIfWhenClauseListNoTransform();
    }
    /**
     * Replaces the ElseStmt list.
     * @param list The new list node to be used as the ElseStmt list.
     * @apilevel high-level
     */
    public void setElseStmtList(List<FStatement> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the ElseStmt list.
     * @return Number of children in the ElseStmt list.
     * @apilevel high-level
     */
    public int getNumElseStmt() {
        return getElseStmtList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ElseStmt list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ElseStmt list.
     * @apilevel low-level
     */
    public int getNumElseStmtNoTransform() {
        return getElseStmtListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ElseStmt list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ElseStmt list.
     * @apilevel high-level
     */
    public FStatement getElseStmt(int i) {
        return (FStatement) getElseStmtList().getChild(i);
    }
    /**
     * Check whether the ElseStmt list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasElseStmt() {
        return getElseStmtList().getNumChild() != 0;
    }
    /**
     * Append an element to the ElseStmt list.
     * @param node The element to append to the ElseStmt list.
     * @apilevel high-level
     */
    public void addElseStmt(FStatement node) {
        List<FStatement> list = (parent == null) ? getElseStmtListNoTransform() : getElseStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addElseStmtNoTransform(FStatement node) {
        List<FStatement> list = getElseStmtListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ElseStmt list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setElseStmt(FStatement node, int i) {
        List<FStatement> list = getElseStmtList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the ElseStmt list.
     * @return The node representing the ElseStmt list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="ElseStmt")
    public List<FStatement> getElseStmtList() {
        List<FStatement> list = (List<FStatement>) getChild(1);
        return list;
    }
    /**
     * Retrieves the ElseStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElseStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getElseStmtListNoTransform() {
        return (List<FStatement>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the ElseStmt list without
     * triggering rewrites.
     */
    public FStatement getElseStmtNoTransform(int i) {
        return (FStatement) getElseStmtListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ElseStmt list.
     * @return The node representing the ElseStmt list.
     * @apilevel high-level
     */
    public List<FStatement> getElseStmts() {
        return getElseStmtList();
    }
    /**
     * Retrieves the ElseStmt list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElseStmt list.
     * @apilevel low-level
     */
    public List<FStatement> getElseStmtsNoTransform() {
        return getElseStmtListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1474
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1474")
    public String getKeyword() {
        String getKeyword_value = "if";
        return getKeyword_value;
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
        {
                for (FIfWhenClause branch : getFIfWhenClauses())
                    if (!isAllInlinable(branch.getFStatements()))
                        return false;
                return isAllInlinable(getElseStmts());
            }
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:999
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:999")
    public FIfWhenStmt createDifferentiated(List<FIfWhenClause> differentiatedClauses) {
        {
                List<FStatement> elseStatements = new List<FStatement>();
                for (FStatement statement : getElseStmts())
                    statement.diff(elseStatements);
                return new FIfStmt(differentiatedClauses, elseStatements);
            }
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
        sortingAssignedNames_value = sortingAssignedNames_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingAssignedNames_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingAssignedNames_value;
    }
    /** @apilevel internal */
    private Set<String> sortingAssignedNames_compute() {
            Set<String> res = new LinkedHashSet<String>();
            for (FIfWhenClause iwc : getFIfWhenClauses())
                res.addAll(iwc.sortingAssignedNames());
            for (FStatement stmt : getElseStmts())
                res.addAll(stmt.sortingAssignedNames());
            return res;
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
        sortingDependencies_value = sortingDependencies_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingDependencies_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingDependencies_value;
    }
    /** @apilevel internal */
    private Set<String> sortingDependencies_compute() {
            Set<String> res = new LinkedHashSet<String>();
            for (FIfWhenClause iwc : getFIfWhenClauses())
                res.addAll(iwc.sortingDependencies());
            for (FStatement stmt : getElseStmts())
                res.addAll(stmt.sortingDependencies());
            return res;
        }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "If";
        return xmlTag_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1821
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return isWhen() || inWhen();
        }
        else {
            return getParent().Define_inWhen(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhen
     */
    protected boolean canDefine_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        if (_callerNode == getElseStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:443
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return lockMyBranch(checkType, getNumFIfWhenClause());
        }
        else if (_callerNode == getFIfWhenClauseListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:442
            int i = _callerNode.getIndexOfChild(_childNode);
            return lockMyBranch(checkType, i);
        }
        else {
            return getParent().Define_lockBranch(this, _callerNode, checkType);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lockBranch
     */
    protected boolean canDefine_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     * @apilevel internal
     */
    public boolean Define_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseStmtListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:570
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
