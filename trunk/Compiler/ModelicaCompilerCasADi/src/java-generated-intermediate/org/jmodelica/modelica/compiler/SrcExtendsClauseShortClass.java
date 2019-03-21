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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:112
 * @astdecl SrcExtendsClauseShortClass : SrcExtendsClause ::= [SrcTypePrefixFlow] [SrcTypePrefixVariability] [SrcTypePrefixInputOutput] [SrcArraySubscripts] SrcComment;
 * @production SrcExtendsClauseShortClass : {@link SrcExtendsClause} ::= <span class="component">[{@link SrcTypePrefixFlow}]</span> <span class="component">[{@link SrcTypePrefixVariability}]</span> <span class="component">[{@link SrcTypePrefixInputOutput}]</span> <span class="component">[{@link SrcArraySubscripts}]</span> <span class="component">{@link SrcComment}</span>;

 */
public class SrcExtendsClauseShortClass extends SrcExtendsClause implements Cloneable {
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1558
     */
    public InstNormalExtends newEmptyInstExtends(InstNode lookup) {
        InstExtendsShortClass res = new InstExtendsShortClass();
        res.setLookupNode(lookup);
        return res;
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcExtendsClauseShortClass() {
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
        children = new ASTNode[8];
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(Opt.EMPTY, 5);
        setChild(Opt.EMPTY, 6);
    }
    /**
     * @declaredat ASTNode:19
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Super", "SrcClassModification", "SrcAnnotation", "SrcTypePrefixFlow", "SrcTypePrefixVariability", "SrcTypePrefixInputOutput", "SrcArraySubscripts", "SrcComment"},
        type = {"SrcAccess", "Opt<SrcClassModification>", "Opt<SrcAnnotation>", "Opt<SrcTypePrefixFlow>", "Opt<SrcTypePrefixVariability>", "Opt<SrcTypePrefixInputOutput>", "Opt<SrcArraySubscripts>", "SrcComment"},
        kind = {"Child", "Opt", "Opt", "Opt", "Opt", "Opt", "Opt", "Child"}
    )
    public SrcExtendsClauseShortClass(SrcAccess p0, Opt<SrcClassModification> p1, Opt<SrcAnnotation> p2, Opt<SrcTypePrefixFlow> p3, Opt<SrcTypePrefixVariability> p4, Opt<SrcTypePrefixInputOutput> p5, Opt<SrcArraySubscripts> p6, SrcComment p7) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
        setChild(p5, 5);
        setChild(p6, 6);
        setChild(p7, 7);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:35
     */
    protected int numChildren() {
        return 8;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:41
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public SrcExtendsClauseShortClass clone() throws CloneNotSupportedException {
        SrcExtendsClauseShortClass node = (SrcExtendsClauseShortClass) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:58
     */
    public SrcExtendsClauseShortClass copy() {
        try {
            SrcExtendsClauseShortClass node = (SrcExtendsClauseShortClass) clone();
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
     * @declaredat ASTNode:77
     */
    @Deprecated
    public SrcExtendsClauseShortClass fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public SrcExtendsClauseShortClass treeCopyNoTransform() {
        SrcExtendsClauseShortClass tree = (SrcExtendsClauseShortClass) copy();
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
     * @declaredat ASTNode:107
     */
    public SrcExtendsClauseShortClass treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:112
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Super child.
     * @param node The new node to replace the Super child.
     * @apilevel high-level
     */
    public void setSuper(SrcAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Super child.
     * @return The current node used as the Super child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Super")
    public SrcAccess getSuper() {
        return (SrcAccess) getChild(0);
    }
    /**
     * Retrieves the Super child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Super child.
     * @apilevel low-level
     */
    public SrcAccess getSuperNoTransform() {
        return (SrcAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the SrcClassModification child. This is the <code>Opt</code>
     * node containing the child SrcClassModification, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcClassModification child.
     * @apilevel low-level
     */
    public void setSrcClassModificationOpt(Opt<SrcClassModification> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) SrcClassModification child.
     * @param node The new node to be used as the SrcClassModification child.
     * @apilevel high-level
     */
    public void setSrcClassModification(SrcClassModification node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional SrcClassModification child exists.
     * @return {@code true} if the optional SrcClassModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcClassModification() {
        return getSrcClassModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcClassModification child.
     * @return The SrcClassModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcClassModification getSrcClassModification() {
        return (SrcClassModification) getSrcClassModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcClassModification child. This is the <code>Opt</code> node containing the child SrcClassModification, not the actual child!
     * @return The optional node for child the SrcClassModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcClassModification")
    public Opt<SrcClassModification> getSrcClassModificationOpt() {
        return (Opt<SrcClassModification>) getChild(1);
    }
    /**
     * Retrieves the optional node for child SrcClassModification. This is the <code>Opt</code> node containing the child SrcClassModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcClassModification.
     * @apilevel low-level
     */
    public Opt<SrcClassModification> getSrcClassModificationOptNoTransform() {
        return (Opt<SrcClassModification>) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the SrcAnnotation child. This is the <code>Opt</code>
     * node containing the child SrcAnnotation, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcAnnotation child.
     * @apilevel low-level
     */
    public void setSrcAnnotationOpt(Opt<SrcAnnotation> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) SrcAnnotation child.
     * @param node The new node to be used as the SrcAnnotation child.
     * @apilevel high-level
     */
    public void setSrcAnnotation(SrcAnnotation node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional SrcAnnotation child exists.
     * @return {@code true} if the optional SrcAnnotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcAnnotation() {
        return getSrcAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcAnnotation child.
     * @return The SrcAnnotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcAnnotation getSrcAnnotation() {
        return (SrcAnnotation) getSrcAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcAnnotation child. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * @return The optional node for child the SrcAnnotation child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcAnnotation")
    public Opt<SrcAnnotation> getSrcAnnotationOpt() {
        return (Opt<SrcAnnotation>) getChild(2);
    }
    /**
     * Retrieves the optional node for child SrcAnnotation. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcAnnotation.
     * @apilevel low-level
     */
    public Opt<SrcAnnotation> getSrcAnnotationOptNoTransform() {
        return (Opt<SrcAnnotation>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the SrcTypePrefixFlow child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixFlow, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixFlow child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixFlowOpt(Opt<SrcTypePrefixFlow> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) SrcTypePrefixFlow child.
     * @param node The new node to be used as the SrcTypePrefixFlow child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixFlow(SrcTypePrefixFlow node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixFlow child exists.
     * @return {@code true} if the optional SrcTypePrefixFlow child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixFlow() {
        return getSrcTypePrefixFlowOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixFlow child.
     * @return The SrcTypePrefixFlow child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixFlow getSrcTypePrefixFlow() {
        return (SrcTypePrefixFlow) getSrcTypePrefixFlowOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixFlow child. This is the <code>Opt</code> node containing the child SrcTypePrefixFlow, not the actual child!
     * @return The optional node for child the SrcTypePrefixFlow child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixFlow")
    public Opt<SrcTypePrefixFlow> getSrcTypePrefixFlowOpt() {
        return (Opt<SrcTypePrefixFlow>) getChild(3);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixFlow. This is the <code>Opt</code> node containing the child SrcTypePrefixFlow, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixFlow.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixFlow> getSrcTypePrefixFlowOptNoTransform() {
        return (Opt<SrcTypePrefixFlow>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the SrcTypePrefixVariability child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixVariability, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixVariability child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixVariabilityOpt(Opt<SrcTypePrefixVariability> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) SrcTypePrefixVariability child.
     * @param node The new node to be used as the SrcTypePrefixVariability child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixVariability(SrcTypePrefixVariability node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixVariability child exists.
     * @return {@code true} if the optional SrcTypePrefixVariability child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixVariability() {
        return getSrcTypePrefixVariabilityOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixVariability child.
     * @return The SrcTypePrefixVariability child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixVariability getSrcTypePrefixVariability() {
        return (SrcTypePrefixVariability) getSrcTypePrefixVariabilityOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixVariability child. This is the <code>Opt</code> node containing the child SrcTypePrefixVariability, not the actual child!
     * @return The optional node for child the SrcTypePrefixVariability child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixVariability")
    public Opt<SrcTypePrefixVariability> getSrcTypePrefixVariabilityOpt() {
        return (Opt<SrcTypePrefixVariability>) getChild(4);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixVariability. This is the <code>Opt</code> node containing the child SrcTypePrefixVariability, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixVariability.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixVariability> getSrcTypePrefixVariabilityOptNoTransform() {
        return (Opt<SrcTypePrefixVariability>) getChildNoTransform(4);
    }
    /**
     * Replaces the optional node for the SrcTypePrefixInputOutput child. This is the <code>Opt</code>
     * node containing the child SrcTypePrefixInputOutput, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcTypePrefixInputOutput child.
     * @apilevel low-level
     */
    public void setSrcTypePrefixInputOutputOpt(Opt<SrcTypePrefixInputOutput> opt) {
        setChild(opt, 5);
    }
    /**
     * Replaces the (optional) SrcTypePrefixInputOutput child.
     * @param node The new node to be used as the SrcTypePrefixInputOutput child.
     * @apilevel high-level
     */
    public void setSrcTypePrefixInputOutput(SrcTypePrefixInputOutput node) {
        if (node != null) {
            setChild(new Opt(node), 5);
        } else {
            setChild(Opt.EMPTY, 5);
        }
    }
    /**
     * Check whether the optional SrcTypePrefixInputOutput child exists.
     * @return {@code true} if the optional SrcTypePrefixInputOutput child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcTypePrefixInputOutput() {
        return getSrcTypePrefixInputOutputOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcTypePrefixInputOutput child.
     * @return The SrcTypePrefixInputOutput child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcTypePrefixInputOutput getSrcTypePrefixInputOutput() {
        return (SrcTypePrefixInputOutput) getSrcTypePrefixInputOutputOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcTypePrefixInputOutput child. This is the <code>Opt</code> node containing the child SrcTypePrefixInputOutput, not the actual child!
     * @return The optional node for child the SrcTypePrefixInputOutput child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcTypePrefixInputOutput")
    public Opt<SrcTypePrefixInputOutput> getSrcTypePrefixInputOutputOpt() {
        return (Opt<SrcTypePrefixInputOutput>) getChild(5);
    }
    /**
     * Retrieves the optional node for child SrcTypePrefixInputOutput. This is the <code>Opt</code> node containing the child SrcTypePrefixInputOutput, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcTypePrefixInputOutput.
     * @apilevel low-level
     */
    public Opt<SrcTypePrefixInputOutput> getSrcTypePrefixInputOutputOptNoTransform() {
        return (Opt<SrcTypePrefixInputOutput>) getChildNoTransform(5);
    }
    /**
     * Replaces the optional node for the SrcArraySubscripts child. This is the <code>Opt</code>
     * node containing the child SrcArraySubscripts, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcArraySubscripts child.
     * @apilevel low-level
     */
    public void setSrcArraySubscriptsOpt(Opt<SrcArraySubscripts> opt) {
        setChild(opt, 6);
    }
    /**
     * Replaces the (optional) SrcArraySubscripts child.
     * @param node The new node to be used as the SrcArraySubscripts child.
     * @apilevel high-level
     */
    public void setSrcArraySubscripts(SrcArraySubscripts node) {
        if (node != null) {
            setChild(new Opt(node), 6);
        } else {
            setChild(Opt.EMPTY, 6);
        }
    }
    /**
     * Check whether the optional SrcArraySubscripts child exists.
     * @return {@code true} if the optional SrcArraySubscripts child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcArraySubscripts() {
        return getSrcArraySubscriptsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcArraySubscripts child.
     * @return The SrcArraySubscripts child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcArraySubscripts getSrcArraySubscripts() {
        return (SrcArraySubscripts) getSrcArraySubscriptsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcArraySubscripts child. This is the <code>Opt</code> node containing the child SrcArraySubscripts, not the actual child!
     * @return The optional node for child the SrcArraySubscripts child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcArraySubscripts")
    public Opt<SrcArraySubscripts> getSrcArraySubscriptsOpt() {
        return (Opt<SrcArraySubscripts>) getChild(6);
    }
    /**
     * Retrieves the optional node for child SrcArraySubscripts. This is the <code>Opt</code> node containing the child SrcArraySubscripts, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcArraySubscripts.
     * @apilevel low-level
     */
    public Opt<SrcArraySubscripts> getSrcArraySubscriptsOptNoTransform() {
        return (Opt<SrcArraySubscripts>) getChildNoTransform(6);
    }
    /**
     * Replaces the SrcComment child.
     * @param node The new node to replace the SrcComment child.
     * @apilevel high-level
     */
    public void setSrcComment(SrcComment node) {
        setChild(node, 7);
    }
    /**
     * Retrieves the SrcComment child.
     * @return The current node used as the SrcComment child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcComment")
    public SrcComment getSrcComment() {
        return (SrcComment) getChild(7);
    }
    /**
     * Retrieves the SrcComment child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcComment child.
     * @apilevel low-level
     */
    public SrcComment getSrcCommentNoTransform() {
        return (SrcComment) getChildNoTransform(7);
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1216
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1216")
    public boolean needsReplacingExtends() {
        boolean needsReplacingExtends_value = true;
        return needsReplacingExtends_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1696
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1696")
    public boolean hasSrcTypePrefix() {
        boolean hasSrcTypePrefix_value = hasSrcTypePrefixFlow() || hasSrcTypePrefixVariability() || hasSrcTypePrefixInputOutput();
        return hasSrcTypePrefix_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:227")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = selectStringComment(getSrcComment());
        return myStringComment_value;
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
        AnnotationNode annotation_InstContext_value = getSrcComment().annotation(instContext);
        return annotation_InstContext_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
