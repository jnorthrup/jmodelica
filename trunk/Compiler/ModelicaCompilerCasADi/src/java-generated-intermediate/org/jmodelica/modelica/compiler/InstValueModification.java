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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:187
 * @astdecl InstValueModification : InstModification ::= FExp InstArrayModification*;
 * @production InstValueModification : {@link InstModification} ::= <span class="component">{@link FExp}</span> <span class="component">{@link InstArrayModification}*</span>;

 */
public class InstValueModification extends InstModification implements Cloneable, LockBranch {
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1141
     */
    public void collectErrors(ErrorCheckType checkType) {
		getFExp().collectErrors(checkType);
	}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:371
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        if (isFlattened(this)) {
            getFExp().flattenUsedFuncsAndEnums(f);
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstValueModification() {
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
        name = {"SrcModification"},
        type = {"SrcModificationOrRedeclareElement"},
        kind = {"Token"}
    )
    public InstValueModification(SrcModificationOrRedeclareElement p0) {
        setSrcModification(p0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:29
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getInstArrayModificationList_reset();
        getFExp_reset();
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
    public InstValueModification clone() throws CloneNotSupportedException {
        InstValueModification node = (InstValueModification) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public InstValueModification copy() {
        try {
            InstValueModification node = (InstValueModification) clone();
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
    public InstValueModification fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public InstValueModification treeCopyNoTransform() {
        InstValueModification tree = (InstValueModification) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 0:
                    tree.children[i] = null;
                    continue;
                case 1:
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
     * @declaredat ASTNode:105
     */
    public InstValueModification treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcModificationOrRedeclareElement_SrcModification == ((InstValueModification) node).tokenSrcModificationOrRedeclareElement_SrcModification);    
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
     * Retrieves the FExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FExp child.
     * @apilevel low-level
     */
    public FExp getFExpNoTransform() {
        return (FExp) getChildNoTransform(0);
    }
    /**
     * Retrieves the child position of the optional child FExp.
     * @return The the child position of the optional child FExp.
     * @apilevel low-level
     */
    protected int getFExpChildPosition() {
        return 0;
    }
    /**
     * Retrieves the number of children in the InstArrayModification list.
     * @return Number of children in the InstArrayModification list.
     * @apilevel high-level
     */
    public int getNumInstArrayModification() {
        return getInstArrayModificationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstArrayModification list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstArrayModification list.
     * @apilevel low-level
     */
    public int getNumInstArrayModificationNoTransform() {
        return getInstArrayModificationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstArrayModification list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstArrayModification list.
     * @apilevel high-level
     */
    public InstArrayModification getInstArrayModification(int i) {
        return (InstArrayModification) getInstArrayModificationList().getChild(i);
    }
    /**
     * Check whether the InstArrayModification list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstArrayModification() {
        return getInstArrayModificationList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstArrayModification list.
     * @param node The element to append to the InstArrayModification list.
     * @apilevel high-level
     */
    public void addInstArrayModification(InstArrayModification node) {
        List<InstArrayModification> list = (parent == null) ? getInstArrayModificationListNoTransform() : getInstArrayModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstArrayModificationNoTransform(InstArrayModification node) {
        List<InstArrayModification> list = getInstArrayModificationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstArrayModification list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstArrayModification(InstArrayModification node, int i) {
        List<InstArrayModification> list = getInstArrayModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstArrayModification list.
     * @return The the child position of the InstArrayModification list.
     * @apilevel low-level
     */
    protected int getInstArrayModificationListChildPosition() {
        return 1;
    }
    /**
     * Retrieves the InstArrayModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstArrayModification list.
     * @apilevel low-level
     */
    public List<InstArrayModification> getInstArrayModificationListNoTransform() {
        return (List<InstArrayModification>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the InstArrayModification list without
     * triggering rewrites.
     */
    public InstArrayModification getInstArrayModificationNoTransform(int i) {
        return (InstArrayModification) getInstArrayModificationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstArrayModification list.
     * @return The node representing the InstArrayModification list.
     * @apilevel high-level
     */
    public List<InstArrayModification> getInstArrayModifications() {
        return getInstArrayModificationList();
    }
    /**
     * Retrieves the InstArrayModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstArrayModification list.
     * @apilevel low-level
     */
    public List<InstArrayModification> getInstArrayModificationsNoTransform() {
        return getInstArrayModificationListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:490
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:490")
    public boolean isSuperseded() {
        {
                InstComponentDecl cmp = myTargetComponent();
                InstModification mod = cmp.isAttribute() ? 
                        parentTargetComponent().totalMergedEnvironment().find(cmp.name()) : 
                        cmp.myInstValueMod();
                return mod != null && mod != this;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573")
    public boolean containsFunction(FFunctionDecl.FunctionType ft) {
        boolean containsFunction_FFunctionDecl_FunctionType_value = getFExp().containsFunction(ft) ||  super.containsFunction(ft);
        return containsFunction_FFunctionDecl_FunctionType_value;
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
        boolean hasInstValueMod_value = true;
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
        FExp instValueMod_value = getFExp();
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
        InstValueModification getInstValueMod_value = this;
        return getInstValueMod_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:442
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:442")
    public InstLookupResult<InstComponentDecl> lookupInstComponentForBindingExp(String name) {
        InstLookupResult<InstComponentDecl> lookupInstComponentForBindingExp_String_value = lookupInstComponent(name);
        return lookupInstComponentForBindingExp_String_value;
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
        boolean hasValue_value = true;
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
        boolean allModificationsMatchesSize_Size_value = getFExp().size().equivalent(s, true);
        return allModificationsMatchesSize_Size_value;
    }
    /**
     * @attribute syn
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:310")
    public SrcValueModification getSrcValueModification() {
        SrcValueModification getSrcValueModification_value = (SrcValueModification)     getSrcModification();
        return getSrcValueModification_value;
    }
    /** @apilevel internal */
    private void getInstArrayModificationList_reset() {
        getInstArrayModificationList_computed = false;
        
        getInstArrayModificationList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstArrayModificationList_computed = false;

    /** @apilevel internal */
    protected List<InstArrayModification> getInstArrayModificationList_value;

    /**
     * @attribute syn nta
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:617
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:617")
    public List<InstArrayModification> getInstArrayModificationList() {
        ASTState state = state();
        if (getInstArrayModificationList_computed) {
            return (List<InstArrayModification>) getChild(getInstArrayModificationListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstArrayModificationList_value = getInstArrayModificationList_compute();
        if(getInstArrayModificationList_value.numChildren() <= 0) {
            getInstArrayModificationList_value  = List.EMPTY;
        }
        setChild(getInstArrayModificationList_value, getInstArrayModificationListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstArrayModificationList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<InstArrayModification> node = (List<InstArrayModification>) this.getChild(getInstArrayModificationListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<InstArrayModification> getInstArrayModificationList_compute() {
            List<InstArrayModification> res = new List<InstArrayModification>();
            if (getFExp().isArray()) {
                for (int i = 1, n = getFExp().size().get(0) + 1; i < n; i++) {
                    FExp exp = getFExp().splitArrayExp(i);
                    res.add(new InstArrayModification(getSrcModification(), exp));
                }
            }
            return res;
        }
    /**
     * Get the InstValueModification corresponding to the specified cell (1-based index) of the array.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:631
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:631")
    public InstValueModification arrayInstModification(int i) {
        {
                int n = getNumInstArrayModification();
                if (n <= 0) {
                    return this;
                } else {
                    // Make sure we always return something
                    int j = (i > 0 && i <= n) ? i - 1 : 0;
                    return getInstArrayModification(j);
                }
            }
    }
    /** @apilevel internal */
    private void getFExp_reset() {
        getFExp_computed = false;
        
        getFExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getFExp_computed = false;

    /** @apilevel internal */
    protected FExp getFExp_value;

    /**
     * @attribute syn nta
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1868
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1868")
    public FExp getFExp() {
        ASTState state = state();
        if (getFExp_computed) {
            return (FExp) getChild(getFExpChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFExp_value = getSrcValueModification().instantiateExp();
        setChild(getFExp_value, getFExpChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FExp node = (FExp) this.getChild(getFExpChildPosition());
        return node;
    }
    /** 
     * obtaining the owning source modification or entity. Primary used to
     * obtain the Component / ComponentModification
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1998
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1998")
    public SrcAnnotatable getElementModification() {
        SrcAnnotatable getElementModification_value = elementModification();
        return getElementModification_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377")
    public boolean isFlattened(InstValueModification ivm) {
        boolean isFlattened_InstValueModification_value = getParent().Define_isFlattened(this, null, ivm);
        return isFlattened_InstValueModification_value;
    }
    /**
     * @attribute inh
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001")
    public SrcAnnotatable elementModification() {
        SrcAnnotatable elementModification_value = getParent().Define_elementModification(this, null);
        return elementModification_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378
     * @apilevel internal
     */
    public boolean Define_isBound(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3380
            return true;
        }
        else {
            return getParent().Define_isBound(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBound
     */
    protected boolean canDefine_isBound(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:447
            return isSuperseded() || lockBranch(checkType);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return retrieveFAccessFromModification();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccess
     */
    protected boolean canDefine_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
