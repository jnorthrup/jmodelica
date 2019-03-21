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
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:95
 * @astdecl InstConstrainingComponent : InstConstraining ::= <SrcComponentDecl:SrcComponentDecl> <InstRedeclare:InstComponentRedeclare>;
 * @production InstConstrainingComponent : {@link InstConstraining} ::= <span class="component">&lt;SrcComponentDecl:SrcComponentDecl&gt;</span> <span class="component">&lt;InstRedeclare:InstComponentRedeclare&gt;</span>;

 */
public class InstConstrainingComponent extends InstConstraining implements Cloneable {
    /**
     * @declaredat ASTNode:1
     */
    public InstConstrainingComponent() {
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
        setChild(Opt.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"ClassName", "InstClassModification", "SrcComponentDecl", "InstRedeclare"},
        type = {"InstAccess", "Opt<InstClassModification>", "SrcComponentDecl", "InstComponentRedeclare"},
        kind = {"Child", "Opt", "Token", "Token"}
    )
    public InstConstrainingComponent(InstAccess p0, Opt<InstClassModification> p1, SrcComponentDecl p2, InstComponentRedeclare p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setSrcComponentDecl(p2);
        setInstRedeclare(p3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:26
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:32
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:36
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getSrcConstrainingClause_reset();
        getInstNode_reset();
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
    public InstConstrainingComponent clone() throws CloneNotSupportedException {
        InstConstrainingComponent node = (InstConstrainingComponent) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public InstConstrainingComponent copy() {
        try {
            InstConstrainingComponent node = (InstConstrainingComponent) clone();
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
    public InstConstrainingComponent fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public InstConstrainingComponent treeCopyNoTransform() {
        InstConstrainingComponent tree = (InstConstrainingComponent) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
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
     * @declaredat ASTNode:105
     */
    public InstConstrainingComponent treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcComponentDecl_SrcComponentDecl == ((InstConstrainingComponent) node).tokenSrcComponentDecl_SrcComponentDecl) && (tokenInstComponentRedeclare_InstRedeclare == ((InstConstrainingComponent) node).tokenInstComponentRedeclare_InstRedeclare);    
    }
    /**
     * Replaces the ClassName child.
     * @param node The new node to replace the ClassName child.
     * @apilevel high-level
     */
    public void setClassName(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the ClassName child.
     * @return The current node used as the ClassName child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="ClassName")
    public InstAccess getClassName() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the ClassName child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ClassName child.
     * @apilevel low-level
     */
    public InstAccess getClassNameNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the InstClassModification child. This is the <code>Opt</code>
     * node containing the child InstClassModification, not the actual child!
     * @param opt The new node to be used as the optional node for the InstClassModification child.
     * @apilevel low-level
     */
    public void setInstClassModificationOpt(Opt<InstClassModification> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) InstClassModification child.
     * @param node The new node to be used as the InstClassModification child.
     * @apilevel high-level
     */
    public void setInstClassModification(InstClassModification node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional InstClassModification child exists.
     * @return {@code true} if the optional InstClassModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstClassModification() {
        return getInstClassModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstClassModification child.
     * @return The InstClassModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstClassModification getInstClassModification() {
        return (InstClassModification) getInstClassModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstClassModification child. This is the <code>Opt</code> node containing the child InstClassModification, not the actual child!
     * @return The optional node for child the InstClassModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstClassModification")
    public Opt<InstClassModification> getInstClassModificationOpt() {
        return (Opt<InstClassModification>) getChild(1);
    }
    /**
     * Retrieves the optional node for child InstClassModification. This is the <code>Opt</code> node containing the child InstClassModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstClassModification.
     * @apilevel low-level
     */
    public Opt<InstClassModification> getInstClassModificationOptNoTransform() {
        return (Opt<InstClassModification>) getChildNoTransform(1);
    }
    /**
     * Replaces the lexeme SrcComponentDecl.
     * @param value The new value for the lexeme SrcComponentDecl.
     * @apilevel high-level
     */
    public void setSrcComponentDecl(SrcComponentDecl value) {
        tokenSrcComponentDecl_SrcComponentDecl = value;
    }
    /** @apilevel internal 
     */
    protected SrcComponentDecl tokenSrcComponentDecl_SrcComponentDecl;
    /**
     * Retrieves the value for the lexeme SrcComponentDecl.
     * @return The value for the lexeme SrcComponentDecl.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcComponentDecl")
    public SrcComponentDecl getSrcComponentDecl() {
        return tokenSrcComponentDecl_SrcComponentDecl;
    }
    /**
     * Replaces the lexeme InstRedeclare.
     * @param value The new value for the lexeme InstRedeclare.
     * @apilevel high-level
     */
    public void setInstRedeclare(InstComponentRedeclare value) {
        tokenInstComponentRedeclare_InstRedeclare = value;
    }
    /** @apilevel internal 
     */
    protected InstComponentRedeclare tokenInstComponentRedeclare_InstRedeclare;
    /**
     * Retrieves the value for the lexeme InstRedeclare.
     * @return The value for the lexeme InstRedeclare.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="InstRedeclare")
    public InstComponentRedeclare getInstRedeclare() {
        return tokenInstComponentRedeclare_InstRedeclare;
    }
    /**
     * Retrieves the InstNode child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstNode child.
     * @apilevel low-level
     */
    public InstBaseNode getInstNodeNoTransform() {
        return (InstBaseNode) getChildNoTransform(2);
    }
    /**
     * Retrieves the child position of the optional child InstNode.
     * @return The the child position of the optional child InstNode.
     * @apilevel low-level
     */
    protected int getInstNodeChildPosition() {
        return 2;
    }
    /** @apilevel internal */
    private void getSrcConstrainingClause_reset() {
        getSrcConstrainingClause_computed = false;
        
        getSrcConstrainingClause_value = null;
    }
    /** @apilevel internal */
    protected boolean getSrcConstrainingClause_computed = false;

    /** @apilevel internal */
    protected SrcConstrainingClause getSrcConstrainingClause_value;

    /**
     * @attribute syn
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1856
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1856")
    public SrcConstrainingClause getSrcConstrainingClause() {
        ASTState state = state();
        if (getSrcConstrainingClause_computed) {
            return getSrcConstrainingClause_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getSrcConstrainingClause_value = getSrcComponentDecl().getSrcConstrainingClause();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getSrcConstrainingClause_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getSrcConstrainingClause_value;
    }
    /** @apilevel internal */
    private void getInstNode_reset() {
        getInstNode_computed = false;
        
        getInstNode_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstNode_computed = false;

    /** @apilevel internal */
    protected InstBaseNode getInstNode_value;

    /**
     * @attribute syn nta
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1860
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1860")
    public InstBaseNode getInstNode() {
        ASTState state = state();
        if (getInstNode_computed) {
            return (InstBaseNode) getChild(getInstNodeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstNode_value = getClassName().myInstClassDecl().newInstConstrainingComponentDecl(getSrcComponentDecl(), getSrcConstrainingClause().getSrcAccess());
        setChild(getInstNode_value, getInstNodeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstNode_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        InstBaseNode node = (InstBaseNode) this.getChild(getInstNodeChildPosition());
        return node;
    }
    /**
     * Does this constraining clause come from a redeclare?
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2118")
    public boolean hasInstRedeclare() {
        boolean hasInstRedeclare_value = getInstRedeclare() != null;
        return hasInstRedeclare_value;
    }
    /**
     * get the InstNode for the redeclare that this constraining clause comes from.
     * 
     * Only valid if hasInstRedeclare() returns true.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2127
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2127")
    public InstNode getRedeclareInstNode() {
        InstNode getRedeclareInstNode_value = getInstRedeclare().getInstComponentDecl();
        return getRedeclareInstNode_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return (getInstRedeclare() != null) ? getInstRedeclare().lookupInstClass(name) : lookupInstClass(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClass
     */
    protected boolean canDefine_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return (getInstRedeclare() != null) ? getInstRedeclare().lookupInstComponent(name) : lookupInstComponent(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponent
     */
    protected boolean canDefine_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstClassModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:754
            return getInstNode().memberInstComponent(name).unresolved();
        }
        else {
            return getParent().Define_lookupInstComponentInInstElement(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponentInInstElement
     */
    protected boolean canDefine_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
