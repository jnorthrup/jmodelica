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
 * For indices expression.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:970
 * @astdecl FForIndex : CommonForIndex ::= FVariable FExp;
 * @production FForIndex : {@link CommonForIndex} ::= <span class="component">{@link FVariable}</span> <span class="component">{@link FExp}</span>;

 */
public class FForIndex extends CommonForIndex implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2240
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
        throw new UnsupportedOperationException();
    }
    /**
     * Constructs an FForIndex with a temporary index variable and a 
     * range expression starting at 1 as the in expression.
     * 
     * @param name  the name of the index
     * @param end   the upper limit for the range expression
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:355
     */
    public FForIndex(String name, FExp end) {
		this();
		setFExp(new FRangeExp(new FIntegerLitExp(1), end));
		setFVariable(new FIntegerVariable(VisibilityType.TEMPORARY, 
				Variability.FIXEDPARAMETER, new FAccessString(name)));
	}
    /**
     * Constructs an FForIndex with a temporary index variable and loops 
     * over the given variable.        
     * 
     * @param name  the name of the index
     * @param var   the name of the variable to loop over
     * @param dim   the dimension to loop over
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:370
     */
    public FForIndex(String name, FAccess var, int dim) {
		this(name, new FSizeExp(var, dim));
	}
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2880
     */
    @Override
    public FForIndex flatten(Flattener f) {
        return (FForIndex) fullCopy();
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1929
     */
    public FForIndex scalarize(Scalarizer s) {
        return new FForIndex(getFVariable().fullCopy(), getFExp().scalarizeIndexExp(s));
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:868
     */
    private String indexName = null;
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:870
     */
    public void setIndexName(String indexName) { this.indexName = indexName; }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:382
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent){
        String namespace="fun";
        String tag = "Index";      
        String varTag = "IterationVariable";
        FAccess qVarName = this.getFVariable().getFAccess();
        String expTag = "IterationSet";       
        
        str.println(indent + "<" + namespace + ":" + tag + ">"); 
        
        str.println(indent + "\t<" + namespace + ":" + varTag + ">"); 
        qVarName.prettyPrint_XML(str,p.indent(indent+"\t"));
        str.println(indent + "\t</" + namespace + ":" + varTag + ">"); 
        
        str.println(indent + "\t<" + namespace + ":" + expTag + ">");
        this.getFExp().prettyPrint_XML(str,p.indent(indent+"\t"));
        str.println(indent + "\t</" + namespace + ":" + expTag + ">");
        str.println(indent + "</" + namespace + ":" + tag + ">"); 
     
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:290
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        super.genVarDecls_C(p, str, indent);
        String name = getFVariable().name_C();
        str.format("%sjmi_real_t %s;\n", indent, name);
        getFExp().genForIndexExtraVarDecls_C(p, str, indent, name);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:312
     */
    public void printForIndexInit_C(CodePrinter p, CodeStream str, String indent) {
        getFExp().printForIndexInit_C(p, str, indent, getFVariable().name_C());
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:355
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        getFExp().printForIndex_C(p, str, indent, getFVariable().name_C());
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:405
     */
    public void printForIndexNext_C(CodePrinter p, CodeStream str, String indent) {
        getFExp().printForIndexNext_C(p, str, indent, getFVariable().name_C());
    }
    /**
     * @declaredat ASTNode:1
     */
    public FForIndex() {
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
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FVariable", "FExp"},
        type = {"FVariable", "FExp"},
        kind = {"Child", "Child"}
    )
    public FForIndex(FVariable p0, FExp p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 2;
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
        isCircular_reset();
        forIndexIndex_reset();
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
    public FForIndex clone() throws CloneNotSupportedException {
        FForIndex node = (FForIndex) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public FForIndex copy() {
        try {
            FForIndex node = (FForIndex) clone();
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
    public FForIndex fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public FForIndex treeCopyNoTransform() {
        FForIndex tree = (FForIndex) copy();
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
    public FForIndex treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:102
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FVariable child.
     * @param node The new node to replace the FVariable child.
     * @apilevel high-level
     */
    public void setFVariable(FVariable node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FVariable child.
     * @return The current node used as the FVariable child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FVariable")
    public FVariable getFVariable() {
        return (FVariable) getChild(0);
    }
    /**
     * Retrieves the FVariable child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FVariable child.
     * @apilevel low-level
     */
    public FVariable getFVariableNoTransform() {
        return (FVariable) getChildNoTransform(0);
    }
    /**
     * Replaces the FExp child.
     * @param node The new node to replace the FExp child.
     * @apilevel high-level
     */
    public void setFExp(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the FExp child.
     * @return The current node used as the FExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FExp")
    public FExp getFExp() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the FExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FExp child.
     * @apilevel low-level
     */
    public FExp getFExpNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3943
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3943")
    public CommonVariableDecl myCVD() {
        CommonVariableDecl myCVD_value = getFVariable();
        return myCVD_value;
    }
/** @apilevel internal */
protected ASTState.Cycle isCircular_cycle = null;
    /** @apilevel internal */
    private void isCircular_reset() {
        isCircular_computed = false;
        isCircular_initialized = false;
        isCircular_cycle = null;
    }
    /** @apilevel internal */
    protected boolean isCircular_computed = false;

    /** @apilevel internal */
    protected boolean isCircular_value;
    /** @apilevel internal */
    protected boolean isCircular_initialized = false;
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4649")
    public boolean isCircular() {
        if (isCircular_computed) {
            return isCircular_value;
        }
        ASTState state = state();
        if (!isCircular_initialized) {
            isCircular_initialized = true;
            isCircular_value = true;
        }
        if (!state.inCircle() || state.calledByLazyAttribute()) {
            state.enterCircle();
            int _boundaries = state.boundariesCrossed;
            boolean isFinal = this.is$Final();
            do {
                isCircular_cycle = state.nextCycle();
                boolean new_isCircular_value = getFExp().isCircular();
                if (isCircular_value != new_isCircular_value) {
                    state.setChangeInCycle();
                }
                isCircular_value = new_isCircular_value;
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                isCircular_computed = true;
                state.startLastCycle();
                boolean $tmp = getFExp().isCircular();
            } else {
                state.startResetCycle();
                boolean $tmp = getFExp().isCircular();
                isCircular_computed = false;
                isCircular_initialized = false;
            }
            state.leaveCircle();
        } else if (isCircular_cycle != state.cycle()) {
            isCircular_cycle = state.cycle();
            if (state.lastCycle()) {
                isCircular_computed = true;
                boolean new_isCircular_value = getFExp().isCircular();
                return new_isCircular_value;
            }
            if (state.resetCycle()) {
                isCircular_computed = false;
                isCircular_initialized = false;
                isCircular_cycle = null;
                return isCircular_value;
            }
            boolean new_isCircular_value = getFExp().isCircular();
            if (isCircular_value != new_isCircular_value) {
                state.setChangeInCycle();
            }
            isCircular_value = new_isCircular_value;
        } else {
        }
        return isCircular_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:86")
    public FAbstractVariable localLookupFV(String name) {
        {
                if (getFVariable().name().equals(name)) {
                    return getFVariable();
                }
                return lookupFV(name);
            }
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:820
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:820")
    public String name() {
        String name_value = getFVariableNoTransform().name();
        return name_value;
    }
    /**
     * @attribute inh
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77")
    public FAbstractVariable lookupFV(String name) {
        FAbstractVariable lookupFV_String_value = getParent().Define_lookupFV(this, null, name);
        return lookupFV_String_value;
    }
    /**
     * @attribute inh
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:468
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:468")
    public int forIndexIndex() {
        ASTState state = state();
        if (forIndexIndex_computed) {
            return forIndexIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        forIndexIndex_value = getParent().Define_forIndexIndex(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        forIndexIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return forIndexIndex_value;
    }
    /** @apilevel internal */
    private void forIndexIndex_reset() {
        forIndexIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean forIndexIndex_computed = false;

    /** @apilevel internal */
    protected int forIndexIndex_value;

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     */
    public boolean Define_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecord
     */
    protected boolean canDefine_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170
     * @apilevel internal
     */
    public boolean Define_isForIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFVariableNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:171
            return true;
        }
        else {
            return super.Define_isForIndex(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForIndex
     */
    protected boolean canDefine_isForIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     */
    public FAbstractEquation Define_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parameterEquation
     */
    protected boolean canDefine_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460
     * @apilevel internal
     */
    public int Define_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFVariableNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:463
            return forIndexIndex();
        }
        else {
            return getParent().Define_findVariableIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findVariableIndex
     */
    protected boolean canDefine_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131
     * @apilevel internal
     */
    public boolean Define_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:133
            return true;
        }
        else {
            return super.Define_isForIndexExp(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForIndexExp
     */
    protected boolean canDefine_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872
     * @apilevel internal
     */
    public String Define_myForIndexName(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFVariableNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:874
            return indexName;
        }
        else {
            return super.Define_myForIndexName(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myForIndexName
     */
    protected boolean canDefine_myForIndexName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876
     * @apilevel internal
     */
    public FExp Define_scalarizeIterIndex(ASTNode _callerNode, ASTNode _childNode, Scalarizer s) {
        if (_callerNode == getFVariableNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:877
            return indexName == null ? null : getFExp().scalarizeWithIndex(s, new FAccessExp(indexName));
        }
        else {
            return super.Define_scalarizeIterIndex(_callerNode, _childNode, s);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute scalarizeIterIndex
     */
    protected boolean canDefine_scalarizeIterIndex(ASTNode _callerNode, ASTNode _childNode, Scalarizer s) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
