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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:140
 * @astdecl InstGeneratedInner : BaseNode ::= InstComponentDecl <CopiedOuter:InstComponentDecl> <MatchingNonInner:InstComponentDecl>;
 * @production InstGeneratedInner : {@link BaseNode} ::= <span class="component">{@link InstComponentDecl}</span> <span class="component">&lt;CopiedOuter:InstComponentDecl&gt;</span> <span class="component">&lt;MatchingNonInner:InstComponentDecl&gt;</span>;

 */
public class InstGeneratedInner extends BaseNode implements Cloneable {
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:714
     */
    public void collectErrors(ErrorCheckType checkType) {
        if (!checkType.allowBadGeneratedInner()) {
            boolean error = false;
            if (getMatchingNonInner() != null) {
                getCopiedOuter().error("Can not generate missing inner declaration for %s, due to presence of component with same name on top level", name());
                error = true;
            } else {
                ListMap<String, String> map = new LinkedHashListMap<String, String>();
                for (InstComponentDecl outer : outers) {
                    if (outer.myInstClass().isPartial()) {
                        outer.error("Can not generate missing inner declaration for outer component %s of partial type %s", 
                                outer.name(), outer.myInstClass().qualifiedName());
                        error = true;
                    } else {
                        map.add(outer.myInstClass().actualInstClass().qualifiedName(), outer.qualifiedName());
                    }
                }
                if (map.size() > 1) {
                    StringBuilder sb = new StringBuilder();
                    java.util.List<String> classes = new ArrayList<String>(map.keySet());
                    Collections.sort(classes);
                    for (String cls : classes) {
                        java.util.List<String> components = map.get(cls);
                        Collections.sort(components);
                        for (String outer : components) {
                            sb.append("\n    ");
                            sb.append(cls);
                            sb.append(" ");
                            sb.append(outer);
                        }
                    }
                    getCopiedOuter().error("Can't generate missing inner declaration for %s, due to the outer declarations being of different types: %s", name(), sb);
                    error = true;
                }
            }
            if (!error) {
                getInstComponentDecl().collectErrors(checkType);
                // TODO: Use missingInnerMessage annotation
                getCopiedOuter().warning("Generated missing inner declaration for '%s'", getCopiedOuter());
            }
        }
    }
    /**
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:98
     */
    public InstGeneratedInner(InstClassDecl parent, InstComponentDecl outer, InstComponentDecl nonInner) {
        this(parent.createInstComponentDecl(outer.getSrcComponentDecl()), outer, nonInner);
        addOuter(outer);
    }
    /**
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:105
     */
    private Set<InstComponentDecl> outers = new HashSet<InstComponentDecl>();
    /**
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:107
     */
    public void addOuter(InstComponentDecl outer) {
        outers.add(outer);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstGeneratedInner() {
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
        children = new ASTNode[1];
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"InstComponentDecl", "CopiedOuter", "MatchingNonInner"},
        type = {"InstComponentDecl", "InstComponentDecl", "InstComponentDecl"},
        kind = {"Child", "Token", "Token"}
    )
    public InstGeneratedInner(InstComponentDecl p0, InstComponentDecl p1, InstComponentDecl p2) {
        setChild(p0, 0);
        setCopiedOuter(p1);
        setMatchingNonInner(p2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 1;
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
    public InstGeneratedInner clone() throws CloneNotSupportedException {
        InstGeneratedInner node = (InstGeneratedInner) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public InstGeneratedInner copy() {
        try {
            InstGeneratedInner node = (InstGeneratedInner) clone();
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
    public InstGeneratedInner fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:76
     */
    public InstGeneratedInner treeCopyNoTransform() {
        InstGeneratedInner tree = (InstGeneratedInner) copy();
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
    public InstGeneratedInner treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:101
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenInstComponentDecl_CopiedOuter == ((InstGeneratedInner) node).tokenInstComponentDecl_CopiedOuter) && (tokenInstComponentDecl_MatchingNonInner == ((InstGeneratedInner) node).tokenInstComponentDecl_MatchingNonInner);    
    }
    /**
     * Replaces the InstComponentDecl child.
     * @param node The new node to replace the InstComponentDecl child.
     * @apilevel high-level
     */
    public void setInstComponentDecl(InstComponentDecl node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the InstComponentDecl child.
     * @return The current node used as the InstComponentDecl child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="InstComponentDecl")
    public InstComponentDecl getInstComponentDecl() {
        return (InstComponentDecl) getChild(0);
    }
    /**
     * Retrieves the InstComponentDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstComponentDecl child.
     * @apilevel low-level
     */
    public InstComponentDecl getInstComponentDeclNoTransform() {
        return (InstComponentDecl) getChildNoTransform(0);
    }
    /**
     * Replaces the lexeme CopiedOuter.
     * @param value The new value for the lexeme CopiedOuter.
     * @apilevel high-level
     */
    public void setCopiedOuter(InstComponentDecl value) {
        tokenInstComponentDecl_CopiedOuter = value;
    }
    /** @apilevel internal 
     */
    protected InstComponentDecl tokenInstComponentDecl_CopiedOuter;
    /**
     * Retrieves the value for the lexeme CopiedOuter.
     * @return The value for the lexeme CopiedOuter.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="CopiedOuter")
    public InstComponentDecl getCopiedOuter() {
        return tokenInstComponentDecl_CopiedOuter;
    }
    /**
     * Replaces the lexeme MatchingNonInner.
     * @param value The new value for the lexeme MatchingNonInner.
     * @apilevel high-level
     */
    public void setMatchingNonInner(InstComponentDecl value) {
        tokenInstComponentDecl_MatchingNonInner = value;
    }
    /** @apilevel internal 
     */
    protected InstComponentDecl tokenInstComponentDecl_MatchingNonInner;
    /**
     * Retrieves the value for the lexeme MatchingNonInner.
     * @return The value for the lexeme MatchingNonInner.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="MatchingNonInner")
    public InstComponentDecl getMatchingNonInner() {
        return tokenInstComponentDecl_MatchingNonInner;
    }
    /**
     * Does node match <code>string</code>? Override for node types that 
     * need to be searched for.
     * 
     * Base implementation always returns <code>false</code.
     * Generally, this is implemented with something like 
     * <code>str.equals(name())</code>.
     * 
     * @param str  the string to match
     * @return     <code>true</code if <code>str</code> matches this node, 
     * <code>false</code> otherwise
     * @attribute syn
     * @aspect NodeSearch
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeSearch", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698")
    public boolean matches(String str) {
        boolean matches_String_value = getCopiedOuter().matches(str);
        return matches_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1944
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1944")
    public String name() {
        String name_value = getCopiedOuter().name();
        return name_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new Environment();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new Environment();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111
     * @apilevel internal
     */
    public boolean Define_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstComponentDeclNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:112
            return true;
        }
        else {
            return super.Define_isGeneratedInner(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGeneratedInner
     */
    protected boolean canDefine_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCopiedOuter().lookupInstClass(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClass
     */
    protected boolean canDefine_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
