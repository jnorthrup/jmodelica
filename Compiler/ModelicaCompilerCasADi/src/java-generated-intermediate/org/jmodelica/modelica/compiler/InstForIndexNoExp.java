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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:170
 * @astdecl InstForIndexNoExp : InstForIndex ::= [FExp];
 * @production InstForIndexNoExp : {@link InstForIndex} ::= <span class="component">[{@link FExp}]</span>;

 */
public class InstForIndexNoExp extends InstForIndex implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:635
     */
    @Override
    public FSubscript createFSubscript() {
        return hasFExp() ? super.createFSubscript() : new FColonSubscript();
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2250
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
    }
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:425
     */
    @Override
    public int evaluateInFunc(AlgorithmEvaluator evaluator, 
            List<InstForIndex> indices, int i, List<FStatement> stmts) {
        if (hasFExp()) {
            return super.evaluateInFunc(evaluator, indices, i, stmts);
        } else {
            throw new ConstantEvaluationException();
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1910
     */
    @Override
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(getInstPrimitive().name());
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1329
     */
    @Override
    public void collectErrorsForAllIndices(
            List<? extends CommonForIndex> indices, int i, ASTNode child, ErrorCheckType checkType) {
        if (hasFExp()) {
            super.collectErrorsForAllIndices(indices, i, child, checkType);
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:934
     */
    public void typeCheck(ErrorCheckType checkType) {
        hasFExp(); // Force eval of NTA, thus checking if a consistent range can be computed
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:938
     */
    public static final SimpleErrorProducer IMPLICIT_FOR_RANGE_NON_INTEGER =
            new SimpleErrorProducer("IMPLICIT_FOR_RANGE_NON_INTEGER", ProblemKind.COMPLIANCE, 
                    "Non-integer for iteration range not supported");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:942
     */
    public static final SimpleErrorProducer IMPLICIT_FOR_RANGE_INCONSISTENT =
            new SimpleErrorProducer("IMPLICIT_FOR_RANGE_INCONSISTENT", ProblemKind.SEMANTIC, 
                    "For index with implicit iteration range used for inconsistent sizes, here used for size %s and earlier for size %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:946
     */
    public static final SimpleErrorProducer IMPLICIT_FOR_RANGE_NOT_USED =
            new SimpleErrorProducer("IMPLICIT_FOR_RANGE_NOT_USED", ProblemKind.SEMANTIC, 
                    "For index with implicit iteration range must be used as array index");
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:276
     */
    private final static String SIZE_CONSISTENCE_ASSERT_MSG = 
            "For index with implicit iteration range used for inconsistent sizes, %s used for different sizes in %s and %s";
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:279
     */
    public void addForIndexRangeAsserts(Flattener f, List<FStatement> l) {
        FExpSubscript cmpUse = null;
        Size cmpSize = null;
        // Find first known size, or if all are unknown, the first one
        for (FExpSubscript use : mySubscriptUses()) {
            Size size = use.mySize();
            if (cmpUse == null || (cmpSize.isUnknown() && !size.isUnknown())) {
                cmpUse = use;
                cmpSize = size;
            }
        }
        for (FExpSubscript use : mySubscriptUses()) {
            Size size = use.mySize();
            if (use != cmpUse && size.isUnknown()) {
                FExp test = getFExp().dynamicFExp(new FEqExp(size.createFExp(0), cmpSize.createFExp(0))).flatten(f);
                String msg = String.format(SIZE_CONSISTENCE_ASSERT_MSG, 
                        use, use.myInstAccess(), cmpUse.myInstAccess());
                FAssert as = new FAssert(test, new FStringLitExp(msg), new Opt());
                l.add(new FFunctionCallStmt(new List<FFunctionCallLeft>(), as));
            }
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstForIndexNoExp() {
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
        name = {"InstPrimitive"},
        type = {"InstForIndexPrimitive"},
        kind = {"Child"}
    )
    public InstForIndexNoExp(InstForIndexPrimitive p0) {
        setChild(p0, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 1;
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
        getFExpOpt_reset();
        mySubscriptUses_reset();
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
    public InstForIndexNoExp clone() throws CloneNotSupportedException {
        InstForIndexNoExp node = (InstForIndexNoExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public InstForIndexNoExp copy() {
        try {
            InstForIndexNoExp node = (InstForIndexNoExp) clone();
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
    public InstForIndexNoExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public InstForIndexNoExp treeCopyNoTransform() {
        InstForIndexNoExp tree = (InstForIndexNoExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 1:
                    tree.children[i] = Opt.EMPTY;
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
     * @declaredat ASTNode:102
     */
    public InstForIndexNoExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:107
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the InstPrimitive child.
     * @param node The new node to replace the InstPrimitive child.
     * @apilevel high-level
     */
    public void setInstPrimitive(InstForIndexPrimitive node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the InstPrimitive child.
     * @return The current node used as the InstPrimitive child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="InstPrimitive")
    public InstForIndexPrimitive getInstPrimitive() {
        return (InstForIndexPrimitive) getChild(0);
    }
    /**
     * Retrieves the InstPrimitive child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstPrimitive child.
     * @apilevel low-level
     */
    public InstForIndexPrimitive getInstPrimitiveNoTransform() {
        return (InstForIndexPrimitive) getChildNoTransform(0);
    }
    /**
     * Replaces the (optional) FExp child.
     * @param node The new node to be used as the FExp child.
     * @apilevel high-level
     */
    public void setFExp(FExp node) {
        // TODO: should also check if getOpt() is the empty singleton, since we check the _value on return.
        getFExpOpt().setChild(node, 0);
    }
    /**
     * Check whether the optional FExp child exists.
     * @return {@code true} if the optional FExp child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFExp() {
        return getFExpOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FExp child.
     * @return The FExp child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getFExp() {
        return (FExp) getFExpOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for child FExp. This is the <code>Opt</code> node containing the child FExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FExp.
     * @apilevel low-level
     */
    public Opt<FExp> getFExpOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child FExp.
     * @return The the child position of the optional child FExp.
     * @apilevel low-level
     */
    protected int getFExpOptChildPosition() {
        return 1;
    }
    /**
     * Check if the expression of this index is a vector (and thus usable).
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:892
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:892")
    public boolean expIsVector() {
        boolean expIsVector_value = true;
        return expIsVector_value;
    }
    /**
     * Get the array size of the loop index expression. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1164")
    public Size size() {
        Size size_value = hasFExp() ? getFExp().size() : new Size(-1);
        return size_value;
    }
    /**
     * Get the set of all values this for index spans.
     * 
     * @return an int array containing the values spanned
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2347
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2347")
    public int[] myIndices() {
        int[] myIndices_value = hasFExp() ? getFExp().myIndices() : new int[0];
        return myIndices_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4711
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4711")
    public boolean isCircular() {
        boolean isCircular_value = hasFExp() && getFExp().isCircular();
        return isCircular_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:519
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:519")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = Variability.FIXEDPARAMETER;
        return variability_value;
    }
    /** @apilevel internal */
    private void getFExpOpt_reset() {
        getFExpOpt_computed = false;
        
        getFExpOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getFExpOpt_computed = false;

    /** @apilevel internal */
    protected Opt<FExp> getFExpOpt_value;

    /**
     * @attribute syn nta
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:951
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:951")
    public Opt<FExp> getFExpOpt() {
        ASTState state = state();
        if (getFExpOpt_computed) {
            return (Opt<FExp>) getChild(getFExpOptChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFExpOpt_value = getFExpOpt_compute();
        if(getFExpOpt_value.numChildren() <= 0) {
            getFExpOpt_value  = Opt.EMPTY;
        }

        setChild(getFExpOpt_value, getFExpOptChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFExpOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        Opt<FExp> node = (Opt<FExp>) this.getChild(getFExpOptChildPosition());
        return node;
    }
    /** @apilevel internal */
    private Opt<FExp> getFExpOpt_compute() {
            Size size = null;
            for (FExpSubscript use : mySubscriptUses()) {
                Size useSize = use.mySize();
                if (!use.myIndexType().isInteger()) {
                    IMPLICIT_FOR_RANGE_NON_INTEGER.invoke(use);
                }
                if (size == null) {
                    size = useSize;
                } else if (!size.equivalent(useSize, true)) {
                    IMPLICIT_FOR_RANGE_INCONSISTENT.invoke(use, useSize, size);
                }
            }
            if (size == null) {
                IMPLICIT_FOR_RANGE_NOT_USED.invoke(this);
                return new Opt();
            } else {
                return new Opt(size.createRangeExp(0));
            }
        }
    /** @apilevel internal */
    private void mySubscriptUses_reset() {
        mySubscriptUses_computed = false;
        
        mySubscriptUses_value = null;
    }
    /** @apilevel internal */
    protected boolean mySubscriptUses_computed = false;

    /** @apilevel internal */
    protected Collection<FExpSubscript> mySubscriptUses_value;

    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:972
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:972")
    public Collection<FExpSubscript> mySubscriptUses() {
        ASTState state = state();
        if (mySubscriptUses_computed) {
            return mySubscriptUses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        mySubscriptUses_value = mySubscriptUses(name());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        mySubscriptUses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return mySubscriptUses_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:974
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:974")
    public Collection<FExpSubscript> mySubscriptUses(String name) {
        Collection<FExpSubscript> mySubscriptUses_String_value = getParent().Define_mySubscriptUses(this, null, name);
        return mySubscriptUses_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:67
     * @apilevel internal
     */
    public FType Define_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstPrimitiveNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:69
            return hasFExp() ? 
                        getFExp().type().scalarType() : fUnknownType();
        }
        else {
            return getParent().Define_myInstForIndexType(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:67
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstForIndexType
     */
    protected boolean canDefine_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
