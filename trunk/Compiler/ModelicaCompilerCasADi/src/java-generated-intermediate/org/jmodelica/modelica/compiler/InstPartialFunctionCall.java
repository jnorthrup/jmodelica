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
 * Partial function call expression in instance trees.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1199
 * @astdecl InstPartialFunctionCall : InstFunctionCall;
 * @production InstPartialFunctionCall : {@link InstFunctionCall};

 */
public class InstPartialFunctionCall extends InstFunctionCall implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3589
     */
    @Override
    public void evaluateCell(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        evaluatePartial(values);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1003
     */
    public InstFunctionCall createEmptyNode() { return new InstPartialFunctionCall(); }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2816
     */
    public FFunctionCall createFFunctionCall(FAccess name, List args, FType type) {
        List<CommonAccess> argNames = new List<CommonAccess>();
        for (String s : namedArgs())
            argNames.add(new FAccessString(s));
        return new FPartialFunctionCall(name, args, type, argNames);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstPartialFunctionCall() {
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
        children = new ASTNode[4];
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Arg"},
        type = {"InstAccess", "List<InstFunctionArgument>"},
        kind = {"Child", "List"}
    )
    public InstPartialFunctionCall(InstAccess p0, List<InstFunctionArgument> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:30
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:34
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getFType_reset();
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
    public InstPartialFunctionCall clone() throws CloneNotSupportedException {
        InstPartialFunctionCall node = (InstPartialFunctionCall) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public InstPartialFunctionCall copy() {
        try {
            InstPartialFunctionCall node = (InstPartialFunctionCall) clone();
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
    public InstPartialFunctionCall fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public InstPartialFunctionCall treeCopyNoTransform() {
        InstPartialFunctionCall tree = (InstPartialFunctionCall) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
                case 3:
                    tree.children[i] = null;
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
    public InstPartialFunctionCall treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public InstAccess getName() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public InstAccess getNameNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Arg list.
     * @param list The new list node to be used as the Arg list.
     * @apilevel high-level
     */
    public void setArgList(List<InstFunctionArgument> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the Arg list.
     * @return Number of children in the Arg list.
     * @apilevel high-level
     */
    public int getNumArg() {
        return getArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Arg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Arg list.
     * @apilevel low-level
     */
    public int getNumArgNoTransform() {
        return getArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Arg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Arg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getArg(int i) {
        return (InstFunctionArgument) getArgList().getChild(i);
    }
    /**
     * Check whether the Arg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasArg() {
        return getArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the Arg list.
     * @param node The element to append to the Arg list.
     * @apilevel high-level
     */
    public void addArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getArgListNoTransform() : getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Arg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Arg")
    public List<InstFunctionArgument> getArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(1);
        return list;
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the Arg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getArgNoTransform(int i) {
        return (InstFunctionArgument) getArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getArgs() {
        return getArgList();
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgsNoTransform() {
        return getArgListNoTransform();
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(2);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 2;
    }
    /**
     * Retrieves the FType child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FType child.
     * @apilevel low-level
     */
    public FType getFTypeNoTransform() {
        return (FType) getChildNoTransform(3);
    }
    /**
     * Retrieves the child position of the optional child FType.
     * @return The the child position of the optional child FType.
     * @apilevel low-level
     */
    protected int getFTypeChildPosition() {
        return 3;
    }
    /** @apilevel internal */
    private void ndims_reset() {
        ndims_computed = false;
    }
    /** @apilevel internal */
    protected boolean ndims_computed = false;

    /** @apilevel internal */
    protected int ndims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228")
    public int ndims() {
        ASTState state = state();
        if (ndims_computed) {
            return ndims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ndims_value = hasOutputs() ? 0 : -1;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /** @apilevel internal */
    private void size_reset() {
        size_computed = false;
        
        size_value = null;
    }
    /** @apilevel internal */
    protected boolean size_computed = false;

    /** @apilevel internal */
    protected Size size_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = Size.SCALAR;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1267")
    public ArrayList<InstComponentDecl> myCallInputs() {
        ArrayList<InstComponentDecl> myCallInputs_value = filterPartialInputs(myInstCallable().myCallInputs());
        return myCallInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1295
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1295")
    public ArrayList<InstComponentDecl> myCallOutputs() {
        ArrayList<InstComponentDecl> myCallOutputs_value = new ArrayList<InstComponentDecl>(Arrays.asList((InstComponentDecl)myCorrespondingInput()));
        return myCallOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:785
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:785")
    public FType typeOfOutput(int i) {
        FType typeOfOutput_int_value = getFType();
        return typeOfOutput_int_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446")
    public String functionCallDecription() {
        String functionCallDecription_value = "Creating functional input argument " + name() + "()";
        return functionCallDecription_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1455")
    public boolean isPartialFunctionCall() {
        boolean isPartialFunctionCall_value = true;
        return isPartialFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:807
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:807")
    public ArrayList<InstComponentDecl> myInputsToBind(InstCallable target) {
        {
                ArrayList<InstComponentDecl> allInputs = super.myInputsToBind(target);
                FType type = myCorrespondingInput().type();
                Set<String> filter = new HashSet<String>();
                boolean error = !type.isFunction();
                if (error) {
                    /* This call is not matched to a partial function. 
                     * Error will be given by normal typecheck, bind all arguments for now. */
                    
                    // Filter will contain arguments that should be bound (all)
                    for (InstFunctionArgument ifa : getArgs()) {
                        if (ifa instanceof InstNamedArgument) {
                            filter.add(((InstNamedArgument) ifa).getName().name());
                        }
                    }
                } else {
                    // Filter will contain arguments that should not be bound
                    FFunctionType t = (FFunctionType) type;
                    for (FRecordComponentType c : t.getInputs()) {
                        filter.add(c.getName());
                    }
                }
                ArrayList<InstComponentDecl> res = new ArrayList<InstComponentDecl>();
                for (InstComponentDecl icd : allInputs) {
                    if (!(error ^ filter.contains(icd.qualifiedName()))) {
                        res.add(icd);
                    }
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void getFType_reset() {
        getFType_computed = false;
        
        getFType_value = null;
    }
    /** @apilevel internal */
    protected boolean getFType_computed = false;

    /** @apilevel internal */
    protected FType getFType_value;

    /**
     * @attribute syn nta
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:169
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:169")
    public FType getFType() {
        ASTState state = state();
        if (getFType_computed) {
            return (FType) getChild(getFTypeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFType_value = getFType_compute();
        setChild(getFType_value, getFTypeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FType node = (FType) this.getChild(getFTypeChildPosition());
        return node;
    }
    /** @apilevel internal */
    private FType getFType_compute() {
            FFunctionType type = declType().treeCopy();
            Set<String> s = new HashSet(namedArgs());
            List<FRecordComponentType> n = new List<FRecordComponentType>();
            for (FRecordComponentType frc : type.getInputs()) {
                if (!s.contains(frc.getName())) {
                    n.add(frc);
                }
            }
            type.setInputList(n);
            return type;
        }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:184")
    public ArrayList<String> namedArgs() {
        {
                ArrayList<String> res = new ArrayList<String>();
                for (InstComponentDecl icd : myInputsToBind(myInstCallable()))
                    res.add(icd.name());
                return res;
            }
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
