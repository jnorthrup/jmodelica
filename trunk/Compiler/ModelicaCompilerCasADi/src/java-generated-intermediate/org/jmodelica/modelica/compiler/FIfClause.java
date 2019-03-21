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
 * Flattened [else]if clause in if statement.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:681
 * @astdecl FIfClause : FIfWhenClause;
 * @production FIfClause : {@link FIfWhenClause};

 */
public class FIfClause extends FIfWhenClause implements Cloneable {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1298
     */
    public FIfClause createEmptyNode()   { return new FIfClause(); }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1159
     */
    public void typeCheck(ErrorCheckType checkType) {
	  if (!getTest().type().isUnknown() && !fBooleanScalarType().typeCompatible(getTest().type())) 
		  error("Type of test expression of if statement is not Boolean");
  }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:162
     */
    protected FIfWhenClause flattenFIfWhenClause(FExp t, List l) {
        return new FIfClause(t, l);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIfClause() {
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
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Test", "FStatement"},
        type = {"FExp", "List<FStatement>"},
        kind = {"Child", "List"}
    )
    public FIfClause(FExp p0, List<FStatement> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:30
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:34
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:38
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public FIfClause clone() throws CloneNotSupportedException {
        FIfClause node = (FIfClause) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public FIfClause copy() {
        try {
            FIfClause node = (FIfClause) clone();
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
     * @declaredat ASTNode:66
     */
    @Deprecated
    public FIfClause fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:76
     */
    public FIfClause treeCopyNoTransform() {
        FIfClause tree = (FIfClause) copy();
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
     * @declaredat ASTNode:96
     */
    public FIfClause treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:101
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Test child.
     * @param node The new node to replace the Test child.
     * @apilevel high-level
     */
    public void setTest(FExp node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Test child.
     * @return The current node used as the Test child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Test")
    public FExp getTest() {
        return (FExp) getChild(0);
    }
    /**
     * Retrieves the Test child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Test child.
     * @apilevel low-level
     */
    public FExp getTestNoTransform() {
        return (FExp) getChildNoTransform(0);
    }
    /**
     * Replaces the FStatement list.
     * @param list The new list node to be used as the FStatement list.
     * @apilevel high-level
     */
    public void setFStatementList(List<FStatement> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the FStatement list.
     * @return Number of children in the FStatement list.
     * @apilevel high-level
     */
    public int getNumFStatement() {
        return getFStatementList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FStatement list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FStatement list.
     * @apilevel low-level
     */
    public int getNumFStatementNoTransform() {
        return getFStatementListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FStatement list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FStatement list.
     * @apilevel high-level
     */
    public FStatement getFStatement(int i) {
        return (FStatement) getFStatementList().getChild(i);
    }
    /**
     * Check whether the FStatement list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFStatement() {
        return getFStatementList().getNumChild() != 0;
    }
    /**
     * Append an element to the FStatement list.
     * @param node The element to append to the FStatement list.
     * @apilevel high-level
     */
    public void addFStatement(FStatement node) {
        List<FStatement> list = (parent == null) ? getFStatementListNoTransform() : getFStatementList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFStatementNoTransform(FStatement node) {
        List<FStatement> list = getFStatementListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FStatement list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFStatement(FStatement node, int i) {
        List<FStatement> list = getFStatementList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FStatement list.
     * @return The node representing the FStatement list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FStatement")
    public List<FStatement> getFStatementList() {
        List<FStatement> list = (List<FStatement>) getChild(1);
        return list;
    }
    /**
     * Retrieves the FStatement list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FStatement list.
     * @apilevel low-level
     */
    public List<FStatement> getFStatementListNoTransform() {
        return (List<FStatement>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the FStatement list without
     * triggering rewrites.
     */
    public FStatement getFStatementNoTransform(int i) {
        return (FStatement) getFStatementListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FStatement list.
     * @return The node representing the FStatement list.
     * @apilevel high-level
     */
    public List<FStatement> getFStatements() {
        return getFStatementList();
    }
    /**
     * Retrieves the FStatement list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FStatement list.
     * @apilevel low-level
     */
    public List<FStatement> getFStatementsNoTransform() {
        return getFStatementListNoTransform();
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1819
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1819")
    public boolean inWhen() {
        boolean inWhen_value = getParent().Define_inWhen(this, null);
        return inWhen_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFStatementListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1820
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myFStatement().isWhen() || inWhen();
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
        if (_callerNode == getFStatementListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:441
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return lockMyBranch(this, checkType, getTest(), true);
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
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
