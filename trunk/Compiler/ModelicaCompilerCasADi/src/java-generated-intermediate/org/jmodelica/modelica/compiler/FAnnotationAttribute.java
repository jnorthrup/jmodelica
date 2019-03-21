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
 * Represents an attribute that was generated from an annotation.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:405
 * @astdecl FAnnotationAttribute : FAttribute;
 * @production FAnnotationAttribute : {@link FAttribute};

 */
public class FAnnotationAttribute extends FAttribute implements Cloneable {
    /**
     * Create an FInternalAttribute with only the children that are 
     * valid for them.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:690
     */
    public FAnnotationAttribute(String name) {
        this(new FAccessEmpty(), new FIdDecl(new FAccessString(name)), new Opt<FExp>(), 
                true, Integer.MAX_VALUE, new Opt<FEach>(), new Opt<FFinal>(), new List<FAttribute>());
    }
    /**
     * Create an FInternalAttribute with only the children that are 
     * valid for them.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:699
     */
    public FAnnotationAttribute(String name, FExp exp, int level, boolean eachKey) {
        this(new FAccessEmpty(), new FIdDecl(new FAccessString(name)), new Opt<FExp>(exp), 
                true, level, eachKey ? new Opt<FEach>(new FEach()) : new Opt<FEach>(), new Opt<FFinal>(), new List<FAttribute>());
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1322
     */
    public FAnnotationAttribute createEmptyNode() { return new FAnnotationAttribute(); }
    /**
     * Overrides default behaviour since we should use AnnotationPrettyPrinter
     * when printing annotation nodes.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:158
     */
    @Override
    public void prettyPrint(CodeStream str, String indent) {
        prettyPrint(AnnotationPrettyPrinter, str, indent);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:94
     */
    public void sanityCheckCommonAccessConsistency(FClass fc) {
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:834
     */
    @Override
    public void scalarize(List<FAttribute> attrs, Index i, Scalarizer s) {
        if (i.ndims() == 0)
            scalarize(attrs, s);
        else
            scalarizeInternal(attrs, i, s);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAnnotationAttribute() {
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
        children = new ASTNode[6];
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
    }
    /**
     * @declaredat ASTNode:17
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "Name", "Value", "AttributeSet", "Level", "FEach", "FFinal", "FAttribute"},
        type = {"CommonAccess", "FIdDecl", "Opt<FExp>", "boolean", "int", "Opt<FEach>", "Opt<FFinal>", "List<FAttribute>"},
        kind = {"Child", "Child", "Opt", "Token", "Token", "Opt", "Opt", "List"}
    )
    public FAnnotationAttribute(CommonAccess p0, FIdDecl p1, Opt<FExp> p2, boolean p3, int p4, Opt<FEach> p5, Opt<FFinal> p6, List<FAttribute> p7) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setAttributeSet(p3);
        setLevel(p4);
        setChild(p5, 3);
        setChild(p6, 4);
        setChild(p7, 5);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:33
     */
    protected int numChildren() {
        return 6;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:39
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FAnnotationAttribute clone() throws CloneNotSupportedException {
        FAnnotationAttribute node = (FAnnotationAttribute) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FAnnotationAttribute copy() {
        try {
            FAnnotationAttribute node = (FAnnotationAttribute) clone();
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
     * @declaredat ASTNode:75
     */
    @Deprecated
    public FAnnotationAttribute fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:85
     */
    public FAnnotationAttribute treeCopyNoTransform() {
        FAnnotationAttribute tree = (FAnnotationAttribute) copy();
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
     * @declaredat ASTNode:105
     */
    public FAnnotationAttribute treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_AttributeSet == ((FAnnotationAttribute) node).tokenboolean_AttributeSet) && (tokenint_Level == ((FAnnotationAttribute) node).tokenint_Level);    
    }
    /**
     * Replaces the Type child.
     * @param node The new node to replace the Type child.
     * @apilevel high-level
     */
    public void setType(CommonAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Type child.
     * @return The current node used as the Type child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Type")
    public CommonAccess getType() {
        return (CommonAccess) getChild(0);
    }
    /**
     * Retrieves the Type child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Type child.
     * @apilevel low-level
     */
    public CommonAccess getTypeNoTransform() {
        return (CommonAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(FIdDecl node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public FIdDecl getName() {
        return (FIdDecl) getChild(1);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public FIdDecl getNameNoTransform() {
        return (FIdDecl) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the Value child. This is the <code>Opt</code>
     * node containing the child Value, not the actual child!
     * @param opt The new node to be used as the optional node for the Value child.
     * @apilevel low-level
     */
    public void setValueOpt(Opt<FExp> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) Value child.
     * @param node The new node to be used as the Value child.
     * @apilevel high-level
     */
    public void setValue(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional Value child exists.
     * @return {@code true} if the optional Value child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasValue() {
        return getValueOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Value child.
     * @return The Value child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getValue() {
        return (FExp) getValueOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Value child. This is the <code>Opt</code> node containing the child Value, not the actual child!
     * @return The optional node for child the Value child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Value")
    public Opt<FExp> getValueOpt() {
        return (Opt<FExp>) getChild(2);
    }
    /**
     * Retrieves the optional node for child Value. This is the <code>Opt</code> node containing the child Value, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Value.
     * @apilevel low-level
     */
    public Opt<FExp> getValueOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(2);
    }
    /**
     * Replaces the lexeme AttributeSet.
     * @param value The new value for the lexeme AttributeSet.
     * @apilevel high-level
     */
    public void setAttributeSet(boolean value) {
        tokenboolean_AttributeSet = value;
    }
    /**
     * Retrieves the value for the lexeme AttributeSet.
     * @return The value for the lexeme AttributeSet.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="AttributeSet")
    public boolean getAttributeSet() {
        return tokenboolean_AttributeSet;
    }
    /**
     * Replaces the lexeme Level.
     * @param value The new value for the lexeme Level.
     * @apilevel high-level
     */
    public void setLevel(int value) {
        tokenint_Level = value;
    }
    /**
     * Retrieves the value for the lexeme Level.
     * @return The value for the lexeme Level.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Level")
    public int getLevel() {
        return tokenint_Level;
    }
    /**
     * Replaces the optional node for the FEach child. This is the <code>Opt</code>
     * node containing the child FEach, not the actual child!
     * @param opt The new node to be used as the optional node for the FEach child.
     * @apilevel low-level
     */
    public void setFEachOpt(Opt<FEach> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) FEach child.
     * @param node The new node to be used as the FEach child.
     * @apilevel high-level
     */
    public void setFEach(FEach node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional FEach child exists.
     * @return {@code true} if the optional FEach child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFEach() {
        return getFEachOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FEach child.
     * @return The FEach child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FEach getFEach() {
        return (FEach) getFEachOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FEach child. This is the <code>Opt</code> node containing the child FEach, not the actual child!
     * @return The optional node for child the FEach child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FEach")
    public Opt<FEach> getFEachOpt() {
        return (Opt<FEach>) getChild(3);
    }
    /**
     * Retrieves the optional node for child FEach. This is the <code>Opt</code> node containing the child FEach, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FEach.
     * @apilevel low-level
     */
    public Opt<FEach> getFEachOptNoTransform() {
        return (Opt<FEach>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the FFinal child. This is the <code>Opt</code>
     * node containing the child FFinal, not the actual child!
     * @param opt The new node to be used as the optional node for the FFinal child.
     * @apilevel low-level
     */
    public void setFFinalOpt(Opt<FFinal> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) FFinal child.
     * @param node The new node to be used as the FFinal child.
     * @apilevel high-level
     */
    public void setFFinal(FFinal node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional FFinal child exists.
     * @return {@code true} if the optional FFinal child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFFinal() {
        return getFFinalOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FFinal child.
     * @return The FFinal child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FFinal getFFinal() {
        return (FFinal) getFFinalOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FFinal child. This is the <code>Opt</code> node containing the child FFinal, not the actual child!
     * @return The optional node for child the FFinal child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FFinal")
    public Opt<FFinal> getFFinalOpt() {
        return (Opt<FFinal>) getChild(4);
    }
    /**
     * Retrieves the optional node for child FFinal. This is the <code>Opt</code> node containing the child FFinal, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FFinal.
     * @apilevel low-level
     */
    public Opt<FFinal> getFFinalOptNoTransform() {
        return (Opt<FFinal>) getChildNoTransform(4);
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * @return Number of children in the FAttribute list.
     * @apilevel high-level
     */
    public int getNumFAttribute() {
        return getFAttributeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAttribute list.
     * @apilevel low-level
     */
    public int getNumFAttributeNoTransform() {
        return getFAttributeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAttribute list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAttribute list.
     * @apilevel high-level
     */
    public FAttribute getFAttribute(int i) {
        return (FAttribute) getFAttributeList().getChild(i);
    }
    /**
     * Check whether the FAttribute list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAttribute() {
        return getFAttributeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAttribute list.
     * @param node The element to append to the FAttribute list.
     * @apilevel high-level
     */
    public void addFAttribute(FAttribute node) {
        List<FAttribute> list = (parent == null) ? getFAttributeListNoTransform() : getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAttribute list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAttribute(FAttribute node, int i) {
        List<FAttribute> list = getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAttribute")
    public List<FAttribute> getFAttributeList() {
        List<FAttribute> list = (List<FAttribute>) getChild(5);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the FAttribute list without
     * triggering rewrites.
     */
    public FAttribute getFAttributeNoTransform(int i) {
        return (FAttribute) getFAttributeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    public List<FAttribute> getFAttributes() {
        return getFAttributeList();
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributesNoTransform() {
        return getFAttributeListNoTransform();
    }
    /**
     * Check if this is attribute is generated from a modification.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1948
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1948")
    public boolean isModification() {
        boolean isModification_value = false;
        return isModification_value;
    }
    /**
     * Check if this is attribute is genereated from an annotation.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1961
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1961")
    public boolean isAnnotation() {
        boolean isAnnotation_value = true;
        return isAnnotation_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
