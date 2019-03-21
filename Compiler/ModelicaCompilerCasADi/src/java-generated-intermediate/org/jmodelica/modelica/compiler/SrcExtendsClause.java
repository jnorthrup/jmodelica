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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:167
 * @astdecl SrcExtendsClause : SrcElement ::= Super:SrcAccess [SrcClassModification] [SrcAnnotation];
 * @production SrcExtendsClause : {@link SrcElement} ::= <span class="component">Super:{@link SrcAccess}</span> <span class="component">[{@link SrcClassModification}]</span> <span class="component">[{@link SrcAnnotation}]</span>;

 */
public class SrcExtendsClause extends SrcElement implements Cloneable, ClassLookupable, ASTNodeWithAnnotation {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:647
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(indent, "extends ");
        p.print(getSuper(), str, indent);
        p.print(getSrcClassModificationOpt(), str, indent);
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1535
     */
    public InstExtends newInstExtends(InstNode lookup) {
        InstNormalExtends ie = newEmptyInstExtends(lookup);
        ie.setClassName(getSuper().newInstAccess());
        ie.setSrcExtendsClause(this);
        if (hasSrcClassModification())
            ie.setInstClassModification(getSrcClassModification().newInstModification());
        ie.setLocation(this);
        return ie;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1545
     */
    public InstExtends newInstReplacingExtends(InstExtendsShortClass iesc) {
        InstReplacingExtendsShortClass ie = new InstReplacingExtendsShortClass();
        ie.setClassName(getSuper().newInstAccess());
        ie.setSrcExtendsClause(this);
        ie.setInstExtendsShortClass(iesc);
        ie.setLocation(this);
        return ie;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1554
     */
    public InstNormalExtends newEmptyInstExtends(InstNode lookup) {
        return new InstNormalExtends();
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:50
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return srcAnnotation(SrcAnnotationNode.defaultEvaluator(), path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:84
     */
    public SrcAnnotationNode srcAnnotation(Evaluator<SrcExp> evaluator, String ... path) {
        return SrcAnnotationNode.createFor(srcAnnotationProvider(), evaluator, path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:573
     */
    public RootAnnotationProviderProxy<SrcExtendsClause, SrcModification> createModifierProvider(){
        return new RootAnnotationProviderProxy<SrcExtendsClause, SrcModification>(this) {
        
        @Override
        protected boolean hasProvider() {
            return owningNode.hasSrcClassModification();
        }

        @Override
        protected void createProvider() {
            owningNode.setSrcClassModification(new SrcClassModification());
        }

        @Override
        protected SrcModification getProvider() {
            return owningNode.getSrcClassModification();
        }
    };
}
    /**
     * @declaredat ASTNode:1
     */
    public SrcExtendsClause() {
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
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Super", "SrcClassModification", "SrcAnnotation"},
        type = {"SrcAccess", "Opt<SrcClassModification>", "Opt<SrcAnnotation>"},
        kind = {"Child", "Opt", "Opt"}
    )
    public SrcExtendsClause(SrcAccess p0, Opt<SrcClassModification> p1, Opt<SrcAnnotation> p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:26
     */
    protected int numChildren() {
        return 3;
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
    public SrcExtendsClause clone() throws CloneNotSupportedException {
        SrcExtendsClause node = (SrcExtendsClause) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public SrcExtendsClause copy() {
        try {
            SrcExtendsClause node = (SrcExtendsClause) clone();
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
    public SrcExtendsClause fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public SrcExtendsClause treeCopyNoTransform() {
        SrcExtendsClause tree = (SrcExtendsClause) copy();
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
     * @declaredat ASTNode:98
     */
    public SrcExtendsClause treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:103
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
     * @attribute syn
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:402
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:402")
    public boolean prettyPrintsAsLine() {
        boolean prettyPrintsAsLine_value = false;
        return prettyPrintsAsLine_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1216
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1216")
    public boolean needsReplacingExtends() {
        boolean needsReplacingExtends_value = false;
        return needsReplacingExtends_value;
    }
    /**
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:38
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:38")
    public SrcClassDecl findClassDecl() {
        SrcClassDecl findClassDecl_value = getSuper().findClassDecl();
        return findClassDecl_value;
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
    /**
     * Experimental! Retreives the annotation representing the modifications.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:411
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:411")
    public AnnotationNode modificationAnnotation() {
        AnnotationNode modificationAnnotation_value = annotationOfChild(getSrcClassModificationOpt(), AnnotationNode.DEFAULT_EVALUATOR);
        return modificationAnnotation_value;
    }
    /******************
     * Extends clause
     * ***************
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:398
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:398")
    public SrcAnnotationProvider srcAnnotationProvider() {
        SrcAnnotationProvider srcAnnotationProvider_value = SrcAnnotationNode.createProviderFor(this);
        return srcAnnotationProvider_value;
    }
    /**
     * Is this element an extends caluse declaration?
     * @attribute syn
     * @aspect SrcUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:291")
    public boolean isExtendsClause() {
        boolean isExtendsClause_value = true;
        return isExtendsClause_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:757
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:757")
    public String name() {
        String name_value = getSuperNoTransform().name();
        return name_value;
    }
    /**
     * Lookup helper method for SrcExtendsClause. Obtain the SrcClassDecl
     * with the given name. Has to be an unqualified classname.
     * @attribute inh
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302")
    public ResolvedAccess simpleLookupFromExtends(String name) {
        ResolvedAccess simpleLookupFromExtends_String_value = getParent().Define_simpleLookupFromExtends(this, null, name);
        return simpleLookupFromExtends_String_value;
    }
    /**
     * @attribute inh
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1204")
    public boolean isPublic() {
        boolean isPublic_value = getParent().Define_isPublic(this, null);
        return isPublic_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getSuperNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:283
            return simpleLookupFromExtends(name);
        }
        else {
            return getParent().Define_simpleLookupHelper(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupHelper
     */
    protected boolean canDefine_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupHelper(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromValue
     */
    protected boolean canDefine_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
