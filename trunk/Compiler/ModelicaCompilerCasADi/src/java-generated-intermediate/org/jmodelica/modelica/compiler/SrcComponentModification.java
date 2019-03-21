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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:227
 * @astdecl SrcComponentModification : SrcElementModification;
 * @production SrcComponentModification : {@link SrcElementModification};

 */
public class SrcComponentModification extends SrcElementModification implements Cloneable {
    /**
     * Constructs a component modification from an access and modification.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:62
     */
    public SrcComponentModification(SrcAccess name, SrcModification mod) {
		this();
		setName(name);
		setSrcModification(mod);
	}
    /**
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:256
     */
    public InstComponentModification newInstModification() {
        InstComponentModification top = null, last = null;
        // TODO: handle dotted names in modifications instead of splitting?
        for (SrcAccess part : getName().nameParts()) {
            InstComponentModification icm = new InstComponentModification(
                    this, getEach(), getFinal(), part.newInstAccess(), new Opt());
            icm.setLocation(this);
            if (last == null) {
                top = last = icm;
            } else {
                InstClassModification icm2 = new InstClassModification(this, new List(icm));
                icm2.setLocation(this);
                InstCompleteModification icm3 = new InstCompleteModification(this, icm2, new Opt());
                icm3.setLocation(this);
                last.setInstModification(icm3);
                last = icm;
            }
        }
        if (hasSrcModification()) {
            last.setInstModification(getSrcModification().newInstModification());
        }
        return top;
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:292
     */
    @Override
    public void setAnnotationValue(SrcExp newValue) throws FailedToSetAnnotationValueException {
        if (!hasSrcModification()) {
            setSrcModification(new SrcValueModification(newValue));
            return;
        }
        getSrcModification().setAnnotationValue(newValue);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:339
     */
    @Override
    public SrcAnnotationProvider addAnnotationSubNode(String name) {
        if (!hasSrcModification()) {
            setSrcModification(new SrcCompleteModification(new SrcClassModification()));
        
        }else if (getSrcModification().isValueModification()){
            setSrcModification(getSrcModification().moveValueModIntoCompleteMod());
        }
        return getSrcModification().addAnnotationSubNode(name);
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcComponentModification() {
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
        name = {"Each", "Final", "Name", "SrcModification", "SrcComment"},
        type = {"boolean", "boolean", "SrcAccess", "Opt<SrcModification>", "SrcComment"},
        kind = {"Token", "Token", "Child", "Opt", "Child"}
    )
    public SrcComponentModification(boolean p0, boolean p1, SrcAccess p2, Opt<SrcModification> p3, SrcComment p4) {
        setEach(p0);
        setFinal(p1);
        setChild(p2, 0);
        setChild(p3, 1);
        setChild(p4, 2);
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
        annotationNode_InstContext_reset();
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
    public SrcComponentModification clone() throws CloneNotSupportedException {
        SrcComponentModification node = (SrcComponentModification) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public SrcComponentModification copy() {
        try {
            SrcComponentModification node = (SrcComponentModification) clone();
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
    public SrcComponentModification fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public SrcComponentModification treeCopyNoTransform() {
        SrcComponentModification tree = (SrcComponentModification) copy();
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
     * @declaredat ASTNode:100
     */
    public SrcComponentModification treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:105
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_Each == ((SrcComponentModification) node).tokenboolean_Each) && (tokenboolean_Final == ((SrcComponentModification) node).tokenboolean_Final);    
    }
    /**
     * Replaces the lexeme Each.
     * @param value The new value for the lexeme Each.
     * @apilevel high-level
     */
    public void setEach(boolean value) {
        tokenboolean_Each = value;
    }
    /**
     * Retrieves the value for the lexeme Each.
     * @return The value for the lexeme Each.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Each")
    public boolean getEach() {
        return tokenboolean_Each;
    }
    /**
     * Replaces the lexeme Final.
     * @param value The new value for the lexeme Final.
     * @apilevel high-level
     */
    public void setFinal(boolean value) {
        tokenboolean_Final = value;
    }
    /**
     * Retrieves the value for the lexeme Final.
     * @return The value for the lexeme Final.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Final")
    public boolean getFinal() {
        return tokenboolean_Final;
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(SrcAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public SrcAccess getName() {
        return (SrcAccess) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public SrcAccess getNameNoTransform() {
        return (SrcAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the SrcModification child. This is the <code>Opt</code>
     * node containing the child SrcModification, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcModification child.
     * @apilevel low-level
     */
    public void setSrcModificationOpt(Opt<SrcModification> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) SrcModification child.
     * @param node The new node to be used as the SrcModification child.
     * @apilevel high-level
     */
    public void setSrcModification(SrcModification node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional SrcModification child exists.
     * @return {@code true} if the optional SrcModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcModification() {
        return getSrcModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcModification child.
     * @return The SrcModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcModification getSrcModification() {
        return (SrcModification) getSrcModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcModification child. This is the <code>Opt</code> node containing the child SrcModification, not the actual child!
     * @return The optional node for child the SrcModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcModification")
    public Opt<SrcModification> getSrcModificationOpt() {
        return (Opt<SrcModification>) getChild(1);
    }
    /**
     * Retrieves the optional node for child SrcModification. This is the <code>Opt</code> node containing the child SrcModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcModification.
     * @apilevel low-level
     */
    public Opt<SrcModification> getSrcModificationOptNoTransform() {
        return (Opt<SrcModification>) getChildNoTransform(1);
    }
    /**
     * Replaces the SrcComment child.
     * @param node The new node to replace the SrcComment child.
     * @apilevel high-level
     */
    public void setSrcComment(SrcComment node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the SrcComment child.
     * @return The current node used as the SrcComment child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcComment")
    public SrcComment getSrcComment() {
        return (SrcComment) getChild(2);
    }
    /**
     * Retrieves the SrcComment child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcComment child.
     * @apilevel low-level
     */
    public SrcComment getSrcCommentNoTransform() {
        return (SrcComment) getChildNoTransform(2);
    }
    /** @apilevel internal */
    private void annotationNode_InstContext_reset() {
        annotationNode_InstContext_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map annotationNode_InstContext_values;

    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:429
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:429")
    public AnnotationNode annotationNode(InstContext instContext) {
        Object _parameters = instContext;
        if (annotationNode_InstContext_values == null) annotationNode_InstContext_values = new java.util.HashMap(4);
        ASTState state = state();
        if (annotationNode_InstContext_values.containsKey(_parameters)) {
            return (AnnotationNode) annotationNode_InstContext_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        AnnotationNode annotationNode_InstContext_value = new ComponentModAnnotationNode(this, instContext);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        annotationNode_InstContext_values.put(_parameters, annotationNode_InstContext_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return annotationNode_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:206")
    public SrcExp annotationValue() {
        SrcExp annotationValue_value = hasSrcModification() ? getSrcModification().annotationValue() : null;
        return annotationValue_value;
    }
    /**
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:211
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:211")
    public Iterable<SubNodePair<SrcAnnotationProvider>> annotationSubNodes() {
        Iterable<SubNodePair<SrcAnnotationProvider>> annotationSubNodes_value = hasSrcModification() ? getSrcModification().annotationSubNodes() : super.annotationSubNodes();
        return annotationSubNodes_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
