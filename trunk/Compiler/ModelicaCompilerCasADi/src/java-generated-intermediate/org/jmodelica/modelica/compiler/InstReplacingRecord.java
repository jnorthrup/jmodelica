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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:126
 * @astdecl InstReplacingRecord : InstRecord ::= <OriginalDecl:SrcComponentDecl> OriginalInstComponent:InstComponentDecl <InstComponentRedeclare:InstComponentRedeclare>;
 * @production InstReplacingRecord : {@link InstRecord} ::= <span class="component">&lt;OriginalDecl:SrcComponentDecl&gt;</span> <span class="component">OriginalInstComponent:{@link InstComponentDecl}</span> <span class="component">&lt;InstComponentRedeclare:InstComponentRedeclare&gt;</span>;

 */
public class InstReplacingRecord extends InstRecord implements Cloneable {
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1099
     */
    public void checkRedeclares(ErrorCheckType checkType) {
        super.checkRedeclares(checkType);
        if (shouldCheckInto(checkType))
            typeCheckReplacingComponent(getOriginalInstComponent(), checkType);
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:75
     */
    public void typeCheck(ErrorCheckType checkType) {
        typeCheckReplacingComponent(getOriginalInstComponent(), checkType);
    }
    /**
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2669
     */
    public void addFSubscriptsFromOriginalDeclTo(java.util.List<Subscript> l) {
        getOriginalInstComponent().addLocalFArraySubscriptsTo(l);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstReplacingRecord() {
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
        children = new ASTNode[17];
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
        setChild(List.EMPTY, 8);
        setChild(List.EMPTY, 9);
        setChild(List.EMPTY, 10);
        setChild(List.EMPTY, 11);
        setChild(List.EMPTY, 12);
        setChild(Opt.EMPTY, 14);
        setChild(Opt.EMPTY, 15);
    }
    /**
     * @declaredat ASTNode:27
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "ClassName", "LocalFArraySubscripts", "SrcComponentDecl", "InstModification", "InstConstrainingComponent", "ConditionalAttribute", "OriginalDecl", "InstComponentRedeclare"},
        type = {"String", "InstAccess", "Opt<FArraySubscripts>", "SrcComponentDecl", "Opt<InstModification>", "Opt<InstConstrainingComponent>", "Opt<FExp>", "SrcComponentDecl", "InstComponentRedeclare"},
        kind = {"Token", "Child", "Opt", "Token", "Opt", "Opt", "Opt", "Token", "Token"}
    )
    public InstReplacingRecord(String p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6, SrcComponentDecl p7, InstComponentRedeclare p8) {
        setName(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setSrcComponentDecl(p3);
        setChild(p4, 2);
        setChild(p5, 3);
        setChild(p6, 4);
        setOriginalDecl(p7);
        setInstComponentRedeclare(p8);
    }
    /**
     * @declaredat ASTNode:43
     */
    public InstReplacingRecord(beaver.Symbol p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6, SrcComponentDecl p7, InstComponentRedeclare p8) {
        setName(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setSrcComponentDecl(p3);
        setChild(p4, 2);
        setChild(p5, 3);
        setChild(p6, 4);
        setOriginalDecl(p7);
        setInstComponentRedeclare(p8);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:55
     */
    protected int numChildren() {
        return 5;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:61
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:65
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getOriginalInstComponent_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:70
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:74
     */
    public InstReplacingRecord clone() throws CloneNotSupportedException {
        InstReplacingRecord node = (InstReplacingRecord) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:79
     */
    public InstReplacingRecord copy() {
        try {
            InstReplacingRecord node = (InstReplacingRecord) clone();
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
     * @declaredat ASTNode:98
     */
    @Deprecated
    public InstReplacingRecord fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:108
     */
    public InstReplacingRecord treeCopyNoTransform() {
        InstReplacingRecord tree = (InstReplacingRecord) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 13:
                case 16:
                    tree.children[i] = null;
                    continue;
                case 14:
                case 15:
                    tree.children[i] = Opt.EMPTY;
                    continue;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
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
     * @declaredat ASTNode:148
     */
    public InstReplacingRecord treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:153
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenString_Name == ((InstReplacingRecord) node).tokenString_Name) && (tokenSrcComponentDecl_SrcComponentDecl == ((InstReplacingRecord) node).tokenSrcComponentDecl_SrcComponentDecl) && (tokenSrcComponentDecl_OriginalDecl == ((InstReplacingRecord) node).tokenSrcComponentDecl_OriginalDecl) && (tokenInstComponentRedeclare_InstComponentRedeclare == ((InstReplacingRecord) node).tokenInstComponentRedeclare_InstComponentRedeclare);    
    }
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /**
     * JastAdd-internal setter for lexeme Name using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Name
     * @apilevel internal
     */
    public void setName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setName is only valid for String lexemes");
        tokenString_Name = (String)symbol.value;
        Namestart = symbol.getStart();
        Nameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Name.
     * @return The value for the lexeme Name.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Name")
    public String getName() {
        return tokenString_Name != null ? tokenString_Name : "";
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
     * Replaces the optional node for the LocalFArraySubscripts child. This is the <code>Opt</code>
     * node containing the child LocalFArraySubscripts, not the actual child!
     * @param opt The new node to be used as the optional node for the LocalFArraySubscripts child.
     * @apilevel low-level
     */
    public void setLocalFArraySubscriptsOpt(Opt<FArraySubscripts> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) LocalFArraySubscripts child.
     * @param node The new node to be used as the LocalFArraySubscripts child.
     * @apilevel high-level
     */
    public void setLocalFArraySubscripts(FArraySubscripts node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional LocalFArraySubscripts child exists.
     * @return {@code true} if the optional LocalFArraySubscripts child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasLocalFArraySubscripts() {
        return getLocalFArraySubscriptsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) LocalFArraySubscripts child.
     * @return The LocalFArraySubscripts child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FArraySubscripts getLocalFArraySubscripts() {
        return (FArraySubscripts) getLocalFArraySubscriptsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the LocalFArraySubscripts child. This is the <code>Opt</code> node containing the child LocalFArraySubscripts, not the actual child!
     * @return The optional node for child the LocalFArraySubscripts child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="LocalFArraySubscripts")
    public Opt<FArraySubscripts> getLocalFArraySubscriptsOpt() {
        return (Opt<FArraySubscripts>) getChild(1);
    }
    /**
     * Retrieves the optional node for child LocalFArraySubscripts. This is the <code>Opt</code> node containing the child LocalFArraySubscripts, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child LocalFArraySubscripts.
     * @apilevel low-level
     */
    public Opt<FArraySubscripts> getLocalFArraySubscriptsOptNoTransform() {
        return (Opt<FArraySubscripts>) getChildNoTransform(1);
    }
    /**
     * Replaces the lexeme SrcComponentDecl.
     * @param value The new value for the lexeme SrcComponentDecl.
     * @apilevel high-level
     */
    public void setSrcComponentDecl(SrcComponentDecl value) {
        tokenSrcComponentDecl_SrcComponentDecl = value;
    }
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
     * Replaces the optional node for the InstModification child. This is the <code>Opt</code>
     * node containing the child InstModification, not the actual child!
     * @param opt The new node to be used as the optional node for the InstModification child.
     * @apilevel low-level
     */
    public void setInstModificationOpt(Opt<InstModification> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) InstModification child.
     * @param node The new node to be used as the InstModification child.
     * @apilevel high-level
     */
    public void setInstModification(InstModification node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional InstModification child exists.
     * @return {@code true} if the optional InstModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstModification() {
        return getInstModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstModification child.
     * @return The InstModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstModification getInstModification() {
        return (InstModification) getInstModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstModification child. This is the <code>Opt</code> node containing the child InstModification, not the actual child!
     * @return The optional node for child the InstModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstModification")
    public Opt<InstModification> getInstModificationOpt() {
        return (Opt<InstModification>) getChild(2);
    }
    /**
     * Retrieves the optional node for child InstModification. This is the <code>Opt</code> node containing the child InstModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstModification.
     * @apilevel low-level
     */
    public Opt<InstModification> getInstModificationOptNoTransform() {
        return (Opt<InstModification>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the InstConstrainingComponent child. This is the <code>Opt</code>
     * node containing the child InstConstrainingComponent, not the actual child!
     * @param opt The new node to be used as the optional node for the InstConstrainingComponent child.
     * @apilevel low-level
     */
    public void setInstConstrainingComponentOpt(Opt<InstConstrainingComponent> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) InstConstrainingComponent child.
     * @param node The new node to be used as the InstConstrainingComponent child.
     * @apilevel high-level
     */
    public void setInstConstrainingComponent(InstConstrainingComponent node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional InstConstrainingComponent child exists.
     * @return {@code true} if the optional InstConstrainingComponent child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstConstrainingComponent() {
        return getInstConstrainingComponentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstConstrainingComponent child.
     * @return The InstConstrainingComponent child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstConstrainingComponent getInstConstrainingComponent() {
        return (InstConstrainingComponent) getInstConstrainingComponentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstConstrainingComponent child. This is the <code>Opt</code> node containing the child InstConstrainingComponent, not the actual child!
     * @return The optional node for child the InstConstrainingComponent child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstConstrainingComponent")
    public Opt<InstConstrainingComponent> getInstConstrainingComponentOpt() {
        return (Opt<InstConstrainingComponent>) getChild(3);
    }
    /**
     * Retrieves the optional node for child InstConstrainingComponent. This is the <code>Opt</code> node containing the child InstConstrainingComponent, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstConstrainingComponent.
     * @apilevel low-level
     */
    public Opt<InstConstrainingComponent> getInstConstrainingComponentOptNoTransform() {
        return (Opt<InstConstrainingComponent>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the ConditionalAttribute child. This is the <code>Opt</code>
     * node containing the child ConditionalAttribute, not the actual child!
     * @param opt The new node to be used as the optional node for the ConditionalAttribute child.
     * @apilevel low-level
     */
    public void setConditionalAttributeOpt(Opt<FExp> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) ConditionalAttribute child.
     * @param node The new node to be used as the ConditionalAttribute child.
     * @apilevel high-level
     */
    public void setConditionalAttribute(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional ConditionalAttribute child exists.
     * @return {@code true} if the optional ConditionalAttribute child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasConditionalAttribute() {
        return getConditionalAttributeOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ConditionalAttribute child.
     * @return The ConditionalAttribute child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getConditionalAttribute() {
        return (FExp) getConditionalAttributeOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the ConditionalAttribute child. This is the <code>Opt</code> node containing the child ConditionalAttribute, not the actual child!
     * @return The optional node for child the ConditionalAttribute child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="ConditionalAttribute")
    public Opt<FExp> getConditionalAttributeOpt() {
        return (Opt<FExp>) getChild(4);
    }
    /**
     * Retrieves the optional node for child ConditionalAttribute. This is the <code>Opt</code> node containing the child ConditionalAttribute, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ConditionalAttribute.
     * @apilevel low-level
     */
    public Opt<FExp> getConditionalAttributeOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(4);
    }
    /**
     * Replaces the lexeme OriginalDecl.
     * @param value The new value for the lexeme OriginalDecl.
     * @apilevel high-level
     */
    public void setOriginalDecl(SrcComponentDecl value) {
        tokenSrcComponentDecl_OriginalDecl = value;
    }
    /** @apilevel internal 
     */
    protected SrcComponentDecl tokenSrcComponentDecl_OriginalDecl;
    /**
     * Retrieves the value for the lexeme OriginalDecl.
     * @return The value for the lexeme OriginalDecl.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="OriginalDecl")
    public SrcComponentDecl getOriginalDecl() {
        return tokenSrcComponentDecl_OriginalDecl;
    }
    /**
     * Replaces the lexeme InstComponentRedeclare.
     * @param value The new value for the lexeme InstComponentRedeclare.
     * @apilevel high-level
     */
    public void setInstComponentRedeclare(InstComponentRedeclare value) {
        tokenInstComponentRedeclare_InstComponentRedeclare = value;
    }
    /** @apilevel internal 
     */
    protected InstComponentRedeclare tokenInstComponentRedeclare_InstComponentRedeclare;
    /**
     * Retrieves the value for the lexeme InstComponentRedeclare.
     * @return The value for the lexeme InstComponentRedeclare.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="InstComponentRedeclare")
    public InstComponentRedeclare getInstComponentRedeclare() {
        return tokenInstComponentRedeclare_InstComponentRedeclare;
    }
    /**
     * Retrieves the number of children in the InstComponentDecl list.
     * @return Number of children in the InstComponentDecl list.
     * @apilevel high-level
     */
    public int getNumInstComponentDecl() {
        return getInstComponentDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstComponentDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstComponentDecl list.
     * @apilevel low-level
     */
    public int getNumInstComponentDeclNoTransform() {
        return getInstComponentDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstComponentDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstComponentDecl list.
     * @apilevel high-level
     */
    public InstComponentDecl getInstComponentDecl(int i) {
        return (InstComponentDecl) getInstComponentDeclList().getChild(i);
    }
    /**
     * Check whether the InstComponentDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstComponentDecl() {
        return getInstComponentDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstComponentDecl list.
     * @param node The element to append to the InstComponentDecl list.
     * @apilevel high-level
     */
    public void addInstComponentDecl(InstComponentDecl node) {
        List<InstComponentDecl> list = (parent == null) ? getInstComponentDeclListNoTransform() : getInstComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstComponentDeclNoTransform(InstComponentDecl node) {
        List<InstComponentDecl> list = getInstComponentDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstComponentDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstComponentDecl(InstComponentDecl node, int i) {
        List<InstComponentDecl> list = getInstComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstComponentDecl list.
     * @return The the child position of the InstComponentDecl list.
     * @apilevel low-level
     */
    protected int getInstComponentDeclListChildPosition() {
        return 5;
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclListNoTransform() {
        return (List<InstComponentDecl>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the InstComponentDecl list without
     * triggering rewrites.
     */
    public InstComponentDecl getInstComponentDeclNoTransform(int i) {
        return (InstComponentDecl) getInstComponentDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstComponentDecl list.
     * @return The node representing the InstComponentDecl list.
     * @apilevel high-level
     */
    public List<InstComponentDecl> getInstComponentDecls() {
        return getInstComponentDeclList();
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclsNoTransform() {
        return getInstComponentDeclListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstClassDecl list.
     * @return Number of children in the InstClassDecl list.
     * @apilevel high-level
     */
    public int getNumInstClassDecl() {
        return getInstClassDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstClassDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstClassDecl list.
     * @apilevel low-level
     */
    public int getNumInstClassDeclNoTransform() {
        return getInstClassDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstClassDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstClassDecl list.
     * @apilevel high-level
     */
    public InstClassDecl getInstClassDecl(int i) {
        return (InstClassDecl) getInstClassDeclList().getChild(i);
    }
    /**
     * Check whether the InstClassDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstClassDecl() {
        return getInstClassDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstClassDecl list.
     * @param node The element to append to the InstClassDecl list.
     * @apilevel high-level
     */
    public void addInstClassDecl(InstClassDecl node) {
        List<InstClassDecl> list = (parent == null) ? getInstClassDeclListNoTransform() : getInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstClassDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstClassDecl(InstClassDecl node, int i) {
        List<InstClassDecl> list = getInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstClassDecl list.
     * @return The the child position of the InstClassDecl list.
     * @apilevel low-level
     */
    protected int getInstClassDeclListChildPosition() {
        return 6;
    }
    /**
     * Retrieves the InstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(6);
    }
    /**
     * @return the element at index {@code i} in the InstClassDecl list without
     * triggering rewrites.
     */
    public InstClassDecl getInstClassDeclNoTransform(int i) {
        return (InstClassDecl) getInstClassDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstClassDecl list.
     * @return The node representing the InstClassDecl list.
     * @apilevel high-level
     */
    public List<InstClassDecl> getInstClassDecls() {
        return getInstClassDeclList();
    }
    /**
     * Retrieves the InstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getInstClassDeclsNoTransform() {
        return getInstClassDeclListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstExtends list.
     * @return Number of children in the InstExtends list.
     * @apilevel high-level
     */
    public int getNumInstExtends() {
        return getInstExtendsList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstExtends list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstExtends list.
     * @apilevel low-level
     */
    public int getNumInstExtendsNoTransform() {
        return getInstExtendsListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstExtends list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstExtends list.
     * @apilevel high-level
     */
    public InstExtends getInstExtends(int i) {
        return (InstExtends) getInstExtendsList().getChild(i);
    }
    /**
     * Check whether the InstExtends list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstExtends() {
        return getInstExtendsList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstExtends list.
     * @param node The element to append to the InstExtends list.
     * @apilevel high-level
     */
    public void addInstExtends(InstExtends node) {
        List<InstExtends> list = (parent == null) ? getInstExtendsListNoTransform() : getInstExtendsList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstExtendsNoTransform(InstExtends node) {
        List<InstExtends> list = getInstExtendsListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstExtends list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstExtends(InstExtends node, int i) {
        List<InstExtends> list = getInstExtendsList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstExtends list.
     * @return The the child position of the InstExtends list.
     * @apilevel low-level
     */
    protected int getInstExtendsListChildPosition() {
        return 7;
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendsListNoTransform() {
        return (List<InstExtends>) getChildNoTransform(7);
    }
    /**
     * @return the element at index {@code i} in the InstExtends list without
     * triggering rewrites.
     */
    public InstExtends getInstExtendsNoTransform(int i) {
        return (InstExtends) getInstExtendsListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstExtends list.
     * @return The node representing the InstExtends list.
     * @apilevel high-level
     */
    public List<InstExtends> getInstExtendss() {
        return getInstExtendsList();
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendssNoTransform() {
        return getInstExtendsListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstImport list.
     * @return Number of children in the InstImport list.
     * @apilevel high-level
     */
    public int getNumInstImport() {
        return getInstImportList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstImport list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstImport list.
     * @apilevel low-level
     */
    public int getNumInstImportNoTransform() {
        return getInstImportListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstImport list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstImport list.
     * @apilevel high-level
     */
    public InstImport getInstImport(int i) {
        return (InstImport) getInstImportList().getChild(i);
    }
    /**
     * Check whether the InstImport list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstImport() {
        return getInstImportList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstImport list.
     * @param node The element to append to the InstImport list.
     * @apilevel high-level
     */
    public void addInstImport(InstImport node) {
        List<InstImport> list = (parent == null) ? getInstImportListNoTransform() : getInstImportList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstImportNoTransform(InstImport node) {
        List<InstImport> list = getInstImportListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstImport list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstImport(InstImport node, int i) {
        List<InstImport> list = getInstImportList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstImport list.
     * @return The the child position of the InstImport list.
     * @apilevel low-level
     */
    protected int getInstImportListChildPosition() {
        return 8;
    }
    /**
     * Retrieves the InstImport list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstImport list.
     * @apilevel low-level
     */
    public List<InstImport> getInstImportListNoTransform() {
        return (List<InstImport>) getChildNoTransform(8);
    }
    /**
     * @return the element at index {@code i} in the InstImport list without
     * triggering rewrites.
     */
    public InstImport getInstImportNoTransform(int i) {
        return (InstImport) getInstImportListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstImport list.
     * @return The node representing the InstImport list.
     * @apilevel high-level
     */
    public List<InstImport> getInstImports() {
        return getInstImportList();
    }
    /**
     * Retrieves the InstImport list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstImport list.
     * @apilevel low-level
     */
    public List<InstImport> getInstImportsNoTransform() {
        return getInstImportListNoTransform();
    }
    /**
     * Retrieves the number of children in the RedeclaredInstClassDecl list.
     * @return Number of children in the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public int getNumRedeclaredInstClassDecl() {
        return getRedeclaredInstClassDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the RedeclaredInstClassDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public int getNumRedeclaredInstClassDeclNoTransform() {
        return getRedeclaredInstClassDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the RedeclaredInstClassDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public InstClassDecl getRedeclaredInstClassDecl(int i) {
        return (InstClassDecl) getRedeclaredInstClassDeclList().getChild(i);
    }
    /**
     * Check whether the RedeclaredInstClassDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasRedeclaredInstClassDecl() {
        return getRedeclaredInstClassDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the RedeclaredInstClassDecl list.
     * @param node The element to append to the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public void addRedeclaredInstClassDecl(InstClassDecl node) {
        List<InstClassDecl> list = (parent == null) ? getRedeclaredInstClassDeclListNoTransform() : getRedeclaredInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addRedeclaredInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getRedeclaredInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the RedeclaredInstClassDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setRedeclaredInstClassDecl(InstClassDecl node, int i) {
        List<InstClassDecl> list = getRedeclaredInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the RedeclaredInstClassDecl list.
     * @return The the child position of the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    protected int getRedeclaredInstClassDeclListChildPosition() {
        return 9;
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(9);
    }
    /**
     * @return the element at index {@code i} in the RedeclaredInstClassDecl list without
     * triggering rewrites.
     */
    public InstClassDecl getRedeclaredInstClassDeclNoTransform(int i) {
        return (InstClassDecl) getRedeclaredInstClassDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDecls() {
        return getRedeclaredInstClassDeclList();
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDeclsNoTransform() {
        return getRedeclaredInstClassDeclListNoTransform();
    }
    /**
     * Retrieves the number of children in the FAbstractEquation list.
     * @return Number of children in the FAbstractEquation list.
     * @apilevel high-level
     */
    public int getNumFAbstractEquation() {
        return getFAbstractEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAbstractEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAbstractEquation list.
     * @apilevel low-level
     */
    public int getNumFAbstractEquationNoTransform() {
        return getFAbstractEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAbstractEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAbstractEquation list.
     * @apilevel high-level
     */
    public FAbstractEquation getFAbstractEquation(int i) {
        return (FAbstractEquation) getFAbstractEquationList().getChild(i);
    }
    /**
     * Check whether the FAbstractEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAbstractEquation() {
        return getFAbstractEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAbstractEquation list.
     * @param node The element to append to the FAbstractEquation list.
     * @apilevel high-level
     */
    public void addFAbstractEquation(FAbstractEquation node) {
        List<FAbstractEquation> list = (parent == null) ? getFAbstractEquationListNoTransform() : getFAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAbstractEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAbstractEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAbstractEquation(FAbstractEquation node, int i) {
        List<FAbstractEquation> list = getFAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the FAbstractEquation list.
     * @return The the child position of the FAbstractEquation list.
     * @apilevel low-level
     */
    protected int getFAbstractEquationListChildPosition() {
        return 10;
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(10);
    }
    /**
     * @return the element at index {@code i} in the FAbstractEquation list without
     * triggering rewrites.
     */
    public FAbstractEquation getFAbstractEquationNoTransform(int i) {
        return (FAbstractEquation) getFAbstractEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAbstractEquation list.
     * @return The node representing the FAbstractEquation list.
     * @apilevel high-level
     */
    public List<FAbstractEquation> getFAbstractEquations() {
        return getFAbstractEquationList();
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationsNoTransform() {
        return getFAbstractEquationListNoTransform();
    }
    /**
     * Retrieves the number of children in the ElementInstModification list.
     * @return Number of children in the ElementInstModification list.
     * @apilevel high-level
     */
    public int getNumElementInstModification() {
        return getElementInstModificationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ElementInstModification list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ElementInstModification list.
     * @apilevel low-level
     */
    public int getNumElementInstModificationNoTransform() {
        return getElementInstModificationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ElementInstModification list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ElementInstModification list.
     * @apilevel high-level
     */
    public InstModification getElementInstModification(int i) {
        return (InstModification) getElementInstModificationList().getChild(i);
    }
    /**
     * Check whether the ElementInstModification list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasElementInstModification() {
        return getElementInstModificationList().getNumChild() != 0;
    }
    /**
     * Append an element to the ElementInstModification list.
     * @param node The element to append to the ElementInstModification list.
     * @apilevel high-level
     */
    public void addElementInstModification(InstModification node) {
        List<InstModification> list = (parent == null) ? getElementInstModificationListNoTransform() : getElementInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addElementInstModificationNoTransform(InstModification node) {
        List<InstModification> list = getElementInstModificationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ElementInstModification list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setElementInstModification(InstModification node, int i) {
        List<InstModification> list = getElementInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the ElementInstModification list.
     * @return The the child position of the ElementInstModification list.
     * @apilevel low-level
     */
    protected int getElementInstModificationListChildPosition() {
        return 11;
    }
    /**
     * Retrieves the ElementInstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElementInstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getElementInstModificationListNoTransform() {
        return (List<InstModification>) getChildNoTransform(11);
    }
    /**
     * @return the element at index {@code i} in the ElementInstModification list without
     * triggering rewrites.
     */
    public InstModification getElementInstModificationNoTransform(int i) {
        return (InstModification) getElementInstModificationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ElementInstModification list.
     * @return The node representing the ElementInstModification list.
     * @apilevel high-level
     */
    public List<InstModification> getElementInstModifications() {
        return getElementInstModificationList();
    }
    /**
     * Retrieves the ElementInstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElementInstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getElementInstModificationsNoTransform() {
        return getElementInstModificationListNoTransform();
    }
    /**
     * Retrieves the number of children in the AnnotationExp list.
     * @return Number of children in the AnnotationExp list.
     * @apilevel high-level
     */
    public int getNumAnnotationExp() {
        return getAnnotationExpList().getNumChild();
    }
    /**
     * Retrieves the number of children in the AnnotationExp list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the AnnotationExp list.
     * @apilevel low-level
     */
    public int getNumAnnotationExpNoTransform() {
        return getAnnotationExpListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the AnnotationExp list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the AnnotationExp list.
     * @apilevel high-level
     */
    public FExp getAnnotationExp(int i) {
        return (FExp) getAnnotationExpList().getChild(i);
    }
    /**
     * Check whether the AnnotationExp list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasAnnotationExp() {
        return getAnnotationExpList().getNumChild() != 0;
    }
    /**
     * Append an element to the AnnotationExp list.
     * @param node The element to append to the AnnotationExp list.
     * @apilevel high-level
     */
    public void addAnnotationExp(FExp node) {
        List<FExp> list = (parent == null) ? getAnnotationExpListNoTransform() : getAnnotationExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addAnnotationExpNoTransform(FExp node) {
        List<FExp> list = getAnnotationExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the AnnotationExp list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setAnnotationExp(FExp node, int i) {
        List<FExp> list = getAnnotationExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the AnnotationExp list.
     * @return The the child position of the AnnotationExp list.
     * @apilevel low-level
     */
    protected int getAnnotationExpListChildPosition() {
        return 12;
    }
    /**
     * Retrieves the AnnotationExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnnotationExp list.
     * @apilevel low-level
     */
    public List<FExp> getAnnotationExpListNoTransform() {
        return (List<FExp>) getChildNoTransform(12);
    }
    /**
     * @return the element at index {@code i} in the AnnotationExp list without
     * triggering rewrites.
     */
    public FExp getAnnotationExpNoTransform(int i) {
        return (FExp) getAnnotationExpListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the AnnotationExp list.
     * @return The node representing the AnnotationExp list.
     * @apilevel high-level
     */
    public List<FExp> getAnnotationExps() {
        return getAnnotationExpList();
    }
    /**
     * Retrieves the AnnotationExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnnotationExp list.
     * @apilevel low-level
     */
    public List<FExp> getAnnotationExpsNoTransform() {
        return getAnnotationExpListNoTransform();
    }
    /**
     * Retrieves the FArraySubscripts child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FArraySubscripts child.
     * @apilevel low-level
     */
    public FArraySubscripts getFArraySubscriptsNoTransform() {
        return (FArraySubscripts) getChildNoTransform(13);
    }
    /**
     * Retrieves the child position of the optional child FArraySubscripts.
     * @return The the child position of the optional child FArraySubscripts.
     * @apilevel low-level
     */
    protected int getFArraySubscriptsChildPosition() {
        return 13;
    }
    /**
     * Replaces the (optional) Annotation child.
     * @param node The new node to be used as the Annotation child.
     * @apilevel high-level
     */
    public void setAnnotation(InstClassModification node) {
        // TODO: should also check if getOpt() is the empty singleton, since we check the _value on return.
        getAnnotationOpt().setChild(node, 0);
    }
    /**
     * Check whether the optional Annotation child exists.
     * @return {@code true} if the optional Annotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasAnnotation() {
        return getAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Annotation child.
     * @return The Annotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstClassModification getAnnotation() {
        return (InstClassModification) getAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for child Annotation. This is the <code>Opt</code> node containing the child Annotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Annotation.
     * @apilevel low-level
     */
    public Opt<InstClassModification> getAnnotationOptNoTransform() {
        return (Opt<InstClassModification>) getChildNoTransform(14);
    }
    /**
     * Retrieves the child position of the optional child Annotation.
     * @return The the child position of the optional child Annotation.
     * @apilevel low-level
     */
    protected int getAnnotationOptChildPosition() {
        return 14;
    }
    /**
     * Replaces the (optional) ClassAnnotation child.
     * @param node The new node to be used as the ClassAnnotation child.
     * @apilevel high-level
     */
    public void setClassAnnotation(InstClassModification node) {
        // TODO: should also check if getOpt() is the empty singleton, since we check the _value on return.
        getClassAnnotationOpt().setChild(node, 0);
    }
    /**
     * Check whether the optional ClassAnnotation child exists.
     * @return {@code true} if the optional ClassAnnotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasClassAnnotation() {
        return getClassAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ClassAnnotation child.
     * @return The ClassAnnotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstClassModification getClassAnnotation() {
        return (InstClassModification) getClassAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for child ClassAnnotation. This is the <code>Opt</code> node containing the child ClassAnnotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ClassAnnotation.
     * @apilevel low-level
     */
    public Opt<InstClassModification> getClassAnnotationOptNoTransform() {
        return (Opt<InstClassModification>) getChildNoTransform(15);
    }
    /**
     * Retrieves the child position of the optional child ClassAnnotation.
     * @return The the child position of the optional child ClassAnnotation.
     * @apilevel low-level
     */
    protected int getClassAnnotationOptChildPosition() {
        return 15;
    }
    /**
     * Retrieves the OriginalInstComponent child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the OriginalInstComponent child.
     * @apilevel low-level
     */
    public InstComponentDecl getOriginalInstComponentNoTransform() {
        return (InstComponentDecl) getChildNoTransform(16);
    }
    /**
     * Retrieves the child position of the optional child OriginalInstComponent.
     * @return The the child position of the optional child OriginalInstComponent.
     * @apilevel low-level
     */
    protected int getOriginalInstComponentChildPosition() {
        return 16;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387")
    public boolean containsRedeclared() {
        boolean containsRedeclared_value = true;
        return containsRedeclared_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218")
    public InstNode[] extraNodesToSetModLevelFor() {
        InstNode[] extraNodesToSetModLevelFor_value = listExtraNodesToSetModLevelFor(true, getInstComponentRedeclare().getInstComponentDecl(), myInstClass());
        return extraNodesToSetModLevelFor_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:427")
    public InstNode myDefaultConstrainingDecl() {
        InstNode myDefaultConstrainingDecl_value = getOriginalInstComponent();
        return myDefaultConstrainingDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:31
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:31")
    public TypePrefixVariability noDefinedVariability() {
        TypePrefixVariability noDefinedVariability_value = getOriginalInstComponent().localDefinedVariability();
        return noDefinedVariability_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422")
    public java.util.List<InstModification> instModificationsFromConstrainingType() {
        java.util.List<InstModification> instModificationsFromConstrainingType_value = getOriginalInstComponent().instModificationsForConstraining();
        return instModificationsFromConstrainingType_value;
    }
    /** @apilevel internal */
    private void getOriginalInstComponent_reset() {
        getOriginalInstComponent_computed = false;
        
        getOriginalInstComponent_value = null;
    }
    /** @apilevel internal */
    protected boolean getOriginalInstComponent_computed = false;

    /** @apilevel internal */
    protected InstComponentDecl getOriginalInstComponent_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1618
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1618")
    public InstComponentDecl getOriginalInstComponent() {
        ASTState state = state();
        if (getOriginalInstComponent_computed) {
            return (InstComponentDecl) getChild(getOriginalInstComponentChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getOriginalInstComponent_value = new InstCreateComponentDecl(getOriginalDecl(), null);
        setChild(getOriginalInstComponent_value, getOriginalInstComponentChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getOriginalInstComponent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        InstComponentDecl node = (InstComponentDecl) this.getChild(getOriginalInstComponentChildPosition());
        return node;
    }
    /**
     * Is this declaration redeclared?
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2134")
    public boolean isRedeclared() {
        boolean isRedeclared_value = true;
        return isRedeclared_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2111")
    public SrcAnnotatable orginalAnnotatable() {
        SrcAnnotatable orginalAnnotatable_value = getOriginalDecl();
        return orginalAnnotatable_value;
    }
    /**
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:390")
    public SrcAnnotationProvider srcAnnotationProvider() {
        SrcAnnotationProvider srcAnnotationProvider_value = getOriginalDecl().srcAnnotationProvider();
        return srcAnnotationProvider_value;
    }
    /**
     * Check if this component is declared input.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1338")
    public boolean isComponentDeclaredInput() {
        boolean isComponentDeclaredInput_value = getSrcComponentDecl().hasSrcTypePrefixInputOutput() ? getSrcComponentDecl().isInput() : getOriginalInstComponent().isDeclaredInput();
        return isComponentDeclaredInput_value;
    }
    /**
     * Check if this component is declared flow.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1447
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1447")
    public boolean isDeclaredFlow() {
        boolean isDeclaredFlow_value = getSrcComponentDecl().hasFlowOrStream() ? getSrcComponentDecl().isFlow() : getOriginalDecl().isFlow();
        return isDeclaredFlow_value;
    }
    /**
     * Check if this component is declared stream.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1458
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1458")
    public boolean isStream() {
        boolean isStream_value = getSrcComponentDecl().hasFlowOrStream() ? getSrcComponentDecl().isStream() : getOriginalDecl().isStream();
        return isStream_value;
    }
    /**
     * Check if this component is declared inner.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1469
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1469")
    public boolean isInner() {
        boolean isInner_value = getSrcComponentDecl().hasInnerOrOuter() ? getSrcComponentDecl().isInner() : getOriginalDecl().isInner();
        return isInner_value;
    }
    /**
     * Check if this component is declared outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1480
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1480")
    public boolean isOuter() {
        boolean isOuter_value = getSrcComponentDecl().hasInnerOrOuter() ? getSrcComponentDecl().isOuter() : getOriginalDecl().isOuter();
        return isOuter_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getOriginalInstComponentNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:200
            return retrieveFAccess();
        }
        else {
            return super.Define_retrieveFAccess(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccess
     */
    protected boolean canDefine_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getClassNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:104
            return getInstComponentRedeclare().lookupInstClass(name);
        }
        else if (_callerNode == getOriginalInstComponentNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:100
            return lookupInstClass(name);
        }
        else {
            return super.Define_lookupInstClass(_callerNode, _childNode, name);
        }
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
        if (_callerNode == getOriginalInstComponentNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:338
            return lookupInstComponent(name);
        }
        else {
            return super.Define_lookupInstComponent(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponent
     */
    protected boolean canDefine_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
