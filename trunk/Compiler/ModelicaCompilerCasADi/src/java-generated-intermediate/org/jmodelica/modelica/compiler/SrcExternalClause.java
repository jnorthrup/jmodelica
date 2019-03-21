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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:147
 * @astdecl SrcExternalClause : SrcBaseNode ::= [SrcExternalLanguage] [SrcExternalFunctionCall] [SrcAnnotation];
 * @production SrcExternalClause : {@link SrcBaseNode} ::= <span class="component">[{@link SrcExternalLanguage}]</span> <span class="component">[{@link SrcExternalFunctionCall}]</span> <span class="component">[{@link SrcAnnotation}]</span>;

 */
public class SrcExternalClause extends SrcBaseNode implements Cloneable, ASTNodeWithAnnotation {
    /**
     * @aspect InstantiatedExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2984
     */
    public InstExternal instantiate() {
        // TODO: Interpret annotations and add information to InstExternal
        Opt lang = hasSrcExternalLanguage() ? new Opt(getSrcExternalLanguage().instantiate()) : new Opt();
        Opt call = hasSrcExternalFunctionCall() ? new Opt(getSrcExternalFunctionCall().instantiate()) : new Opt();
        return copyLocationTo(new InstExternal(this, lang, call));
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:65
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return srcAnnotation(SrcAnnotationNode.defaultEvaluator(), path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:90
     */
    public SrcAnnotationNode srcAnnotation(Evaluator<SrcExp> evaluator, String ... path) {
        return SrcAnnotationNode.createFor(this, evaluator, path);
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcExternalClause() {
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
        setChild(Opt.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcExternalLanguage", "SrcExternalFunctionCall", "SrcAnnotation"},
        type = {"Opt<SrcExternalLanguage>", "Opt<SrcExternalFunctionCall>", "Opt<SrcAnnotation>"},
        kind = {"Opt", "Opt", "Opt"}
    )
    public SrcExternalClause(Opt<SrcExternalLanguage> p0, Opt<SrcExternalFunctionCall> p1, Opt<SrcAnnotation> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
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
    public SrcExternalClause clone() throws CloneNotSupportedException {
        SrcExternalClause node = (SrcExternalClause) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public SrcExternalClause copy() {
        try {
            SrcExternalClause node = (SrcExternalClause) clone();
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
    public SrcExternalClause fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public SrcExternalClause treeCopyNoTransform() {
        SrcExternalClause tree = (SrcExternalClause) copy();
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
    public SrcExternalClause treeCopy() {
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
     * Replaces the optional node for the SrcExternalLanguage child. This is the <code>Opt</code>
     * node containing the child SrcExternalLanguage, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcExternalLanguage child.
     * @apilevel low-level
     */
    public void setSrcExternalLanguageOpt(Opt<SrcExternalLanguage> opt) {
        setChild(opt, 0);
    }
    /**
     * Replaces the (optional) SrcExternalLanguage child.
     * @param node The new node to be used as the SrcExternalLanguage child.
     * @apilevel high-level
     */
    public void setSrcExternalLanguage(SrcExternalLanguage node) {
        if (node != null) {
            setChild(new Opt(node), 0);
        } else {
            setChild(Opt.EMPTY, 0);
        }
    }
    /**
     * Check whether the optional SrcExternalLanguage child exists.
     * @return {@code true} if the optional SrcExternalLanguage child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcExternalLanguage() {
        return getSrcExternalLanguageOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcExternalLanguage child.
     * @return The SrcExternalLanguage child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcExternalLanguage getSrcExternalLanguage() {
        return (SrcExternalLanguage) getSrcExternalLanguageOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcExternalLanguage child. This is the <code>Opt</code> node containing the child SrcExternalLanguage, not the actual child!
     * @return The optional node for child the SrcExternalLanguage child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcExternalLanguage")
    public Opt<SrcExternalLanguage> getSrcExternalLanguageOpt() {
        return (Opt<SrcExternalLanguage>) getChild(0);
    }
    /**
     * Retrieves the optional node for child SrcExternalLanguage. This is the <code>Opt</code> node containing the child SrcExternalLanguage, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcExternalLanguage.
     * @apilevel low-level
     */
    public Opt<SrcExternalLanguage> getSrcExternalLanguageOptNoTransform() {
        return (Opt<SrcExternalLanguage>) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the SrcExternalFunctionCall child. This is the <code>Opt</code>
     * node containing the child SrcExternalFunctionCall, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcExternalFunctionCall child.
     * @apilevel low-level
     */
    public void setSrcExternalFunctionCallOpt(Opt<SrcExternalFunctionCall> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) SrcExternalFunctionCall child.
     * @param node The new node to be used as the SrcExternalFunctionCall child.
     * @apilevel high-level
     */
    public void setSrcExternalFunctionCall(SrcExternalFunctionCall node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional SrcExternalFunctionCall child exists.
     * @return {@code true} if the optional SrcExternalFunctionCall child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcExternalFunctionCall() {
        return getSrcExternalFunctionCallOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcExternalFunctionCall child.
     * @return The SrcExternalFunctionCall child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcExternalFunctionCall getSrcExternalFunctionCall() {
        return (SrcExternalFunctionCall) getSrcExternalFunctionCallOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcExternalFunctionCall child. This is the <code>Opt</code> node containing the child SrcExternalFunctionCall, not the actual child!
     * @return The optional node for child the SrcExternalFunctionCall child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcExternalFunctionCall")
    public Opt<SrcExternalFunctionCall> getSrcExternalFunctionCallOpt() {
        return (Opt<SrcExternalFunctionCall>) getChild(1);
    }
    /**
     * Retrieves the optional node for child SrcExternalFunctionCall. This is the <code>Opt</code> node containing the child SrcExternalFunctionCall, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcExternalFunctionCall.
     * @apilevel low-level
     */
    public Opt<SrcExternalFunctionCall> getSrcExternalFunctionCallOptNoTransform() {
        return (Opt<SrcExternalFunctionCall>) getChildNoTransform(1);
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
        AnnotationNode annotation_InstContext_value = annotationOfChild(getSrcAnnotationOpt(), instContext);
        return annotation_InstContext_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
