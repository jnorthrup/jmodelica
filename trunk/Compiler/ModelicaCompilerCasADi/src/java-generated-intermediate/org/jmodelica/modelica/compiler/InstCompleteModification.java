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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:186
 * @astdecl InstCompleteModification : InstModification ::= InstClassModification [InstValueModification];
 * @production InstCompleteModification : {@link InstModification} ::= <span class="component">{@link InstClassModification}</span> <span class="component">[{@link InstValueModification}]</span>;

 */
public class InstCompleteModification extends InstModification implements Cloneable {
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:184
     */
    public boolean contentCheckExtendsOperatorRecord(ErrorCheckType checkType) {
        return getInstClassModification().contentCheckExtendsOperatorRecord(checkType) && 
                (!hasInstValueModification() || getInstValueModification().contentCheckExtendsOperatorRecord(checkType));
    }
    /**
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:221
     */
    public ArrayList<InstModification> expand() {
        ArrayList<InstModification> l = new ArrayList<InstModification>();
        for (InstModification im : getInstClassModification().getInstArguments())
            l.add(im);
        if (hasInstValueModification())
            l.add(getInstValueModification());
        return l;	
    
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstCompleteModification() {
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
        setChild(Opt.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcModification", "InstClassModification", "InstValueModification"},
        type = {"SrcModificationOrRedeclareElement", "InstClassModification", "Opt<InstValueModification>"},
        kind = {"Token", "Child", "Opt"}
    )
    public InstCompleteModification(SrcModificationOrRedeclareElement p0, InstClassModification p1, Opt<InstValueModification> p2) {
        setSrcModification(p0);
        setChild(p1, 0);
        setChild(p2, 1);
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
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public InstCompleteModification clone() throws CloneNotSupportedException {
        InstCompleteModification node = (InstCompleteModification) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public InstCompleteModification copy() {
        try {
            InstCompleteModification node = (InstCompleteModification) clone();
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
     * @declaredat ASTNode:67
     */
    @Deprecated
    public InstCompleteModification fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public InstCompleteModification treeCopyNoTransform() {
        InstCompleteModification tree = (InstCompleteModification) copy();
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
     * @declaredat ASTNode:97
     */
    public InstCompleteModification treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:102
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcModificationOrRedeclareElement_SrcModification == ((InstCompleteModification) node).tokenSrcModificationOrRedeclareElement_SrcModification);    
    }
    /**
     * Replaces the lexeme SrcModification.
     * @param value The new value for the lexeme SrcModification.
     * @apilevel high-level
     */
    public void setSrcModification(SrcModificationOrRedeclareElement value) {
        tokenSrcModificationOrRedeclareElement_SrcModification = value;
    }
    /**
     * Retrieves the value for the lexeme SrcModification.
     * @return The value for the lexeme SrcModification.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcModification")
    public SrcModificationOrRedeclareElement getSrcModification() {
        return tokenSrcModificationOrRedeclareElement_SrcModification;
    }
    /**
     * Replaces the InstClassModification child.
     * @param node The new node to replace the InstClassModification child.
     * @apilevel high-level
     */
    public void setInstClassModification(InstClassModification node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the InstClassModification child.
     * @return The current node used as the InstClassModification child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="InstClassModification")
    public InstClassModification getInstClassModification() {
        return (InstClassModification) getChild(0);
    }
    /**
     * Retrieves the InstClassModification child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstClassModification child.
     * @apilevel low-level
     */
    public InstClassModification getInstClassModificationNoTransform() {
        return (InstClassModification) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the InstValueModification child. This is the <code>Opt</code>
     * node containing the child InstValueModification, not the actual child!
     * @param opt The new node to be used as the optional node for the InstValueModification child.
     * @apilevel low-level
     */
    public void setInstValueModificationOpt(Opt<InstValueModification> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) InstValueModification child.
     * @param node The new node to be used as the InstValueModification child.
     * @apilevel high-level
     */
    public void setInstValueModification(InstValueModification node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional InstValueModification child exists.
     * @return {@code true} if the optional InstValueModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstValueModification() {
        return getInstValueModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstValueModification child.
     * @return The InstValueModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstValueModification getInstValueModification() {
        return (InstValueModification) getInstValueModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstValueModification child. This is the <code>Opt</code> node containing the child InstValueModification, not the actual child!
     * @return The optional node for child the InstValueModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstValueModification")
    public Opt<InstValueModification> getInstValueModificationOpt() {
        return (Opt<InstValueModification>) getChild(1);
    }
    /**
     * Retrieves the optional node for child InstValueModification. This is the <code>Opt</code> node containing the child InstValueModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstValueModification.
     * @apilevel low-level
     */
    public Opt<InstValueModification> getInstValueModificationOptNoTransform() {
        return (Opt<InstValueModification>) getChildNoTransform(1);
    }
    /**
     * \ingroup aspect_Flattening
     * 
     * Check if a modification has a value modification.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2085
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2085")
    public boolean hasInstValueMod() {
        boolean hasInstValueMod_value = hasInstValueModification();
        return hasInstValueMod_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2103
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2103")
    public FExp instValueMod() {
        FExp instValueMod_value = getInstValueModification().getFExp();
        return instValueMod_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2107
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2107")
    public InstValueModification getInstValueMod() {
        InstValueModification getInstValueMod_value = getInstValueModification();
        return getInstValueMod_value;
    }
    /**
     * Check if this modification has (or is) a value modification.
     * @attribute syn
     * @aspect InstNameClassification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:122
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstNameClassification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:122")
    public boolean hasValue() {
        boolean hasValue_value = hasInstValueModification();
        return hasValue_value;
    }
    /**
     * Check if the sizes all expressions in this modification matches <code>s</code> as size of this modification.
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:379
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:379")
    public boolean allModificationsMatchesSize(Size s) {
        boolean allModificationsMatchesSize_Size_value = getInstClassModification().allModificationsMatchesSize(s) && 
                (!hasInstValueModification() || getInstValueModification().allModificationsMatchesSize(s));
        return allModificationsMatchesSize_Size_value;
    }
    /**
     * @attribute syn
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:308
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:308")
    public SrcCompleteModification getSrcCompleteModification() {
        SrcCompleteModification getSrcCompleteModification_value = (SrcCompleteModification)  getSrcModification();
        return getSrcCompleteModification_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:642
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:642")
    public InstModification matchInstModification(String name) {
        {
                for (InstModification im : getInstClassModification().getInstArguments()) {
                    InstModification match = im.matchInstModification(name);
                    if (match != null)
                        return match;
                }
                return null;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:222
     * @apilevel internal
     */
    public boolean Define_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstValueModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:225
            return // TODO: not needed?
                    isForAttributeOnOperatorRecordDeclarationMember();
        }
        else {
            return getParent().Define_isForAttributeOnOperatorRecordDeclarationMember(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:222
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForAttributeOnOperatorRecordDeclarationMember
     */
    protected boolean canDefine_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
