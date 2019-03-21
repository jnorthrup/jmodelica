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
 * Base class for function call arguments in the instance tree.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1209
 * @astdecl InstFunctionArgument : BaseNode;
 * @production InstFunctionArgument : {@link BaseNode};

 */
public abstract class InstFunctionArgument extends BaseNode implements Cloneable, HasType, LockBranch {
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:525
     */
    public InstFunctionArgument copyReplaceAccess(FExp.ContextReplacer crp) {
        return fullCopy();
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1453
     */
    public boolean generateUnbindableError(String desc, boolean genForPos) {
		return genForPos;
	}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1489
     */
    public void typeCheck(ErrorCheckType checkType) {
        boolean typeOk = true;
        FType type = getFExp().type();
        if (!type.isUnknown()) {
            if (argumentDefinedTypeValid()) {
                FType boundType = getBoundInput().type();
                if (!boundType.isUnknown()) {
                    if (isVectorized()) 
                        boundType = boundType.sizedType(boundType.size().expand(vectorizedSize()));
                    else if (isDestructorArgument())
                        boundType = boundType.sizedType(type.size());
                    typeOk = boundType.typeCompatible(type, true) || lockBranch(checkType);
                }
            } else {
                typeOk = argumentTypeValid(type);
            }
        }
        if (!typeOk) {
            String msg = argumentTypeError();
            if (msg != null) {
                error(msg);
            } else {
                error("%s: types of %s and input %s are not compatible\n" + 
                      "    type of '%s' is %s\n" + 
                      "    expected type is %s", 
                      functionCallDecription(), argumentDesc(), getBoundInput().name(), 
                      getFExp(), getFExp().type(),
                      argumentDefinedTypeValid() ? getBoundInput().type().toString() : expectedArgumentType());
            }
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2865
     */
    public FExp flatten(Flattener f) {
        return getFExp().flatten(f);
    }
    /**
     * Return an InstMultipleBoundArgument containing both <code>this</code> and <code>arg</code>.
     * 
     * If <code>this</code> is an InstMultipleBoundArgument, <code>arg</code> is simply added to it.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:32
     */
    protected InstMultipleBoundArgument addMultipleBoundArgument(InstFunctionArgument arg) {
		return new InstMultipleBoundArgument(new List().add(this).add(arg));
	}
    /**
     * The input component this argument is bound to.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:65
     */
    protected InstComponentDecl boundInput = null;
    /**
     * Set the input component this argument is bound to.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:70
     */
    public void setBoundInput(InstComponentDecl input) {
		boundInput = input;
	}
    /**
     * Argument nodes representing arguments that are missing or given multiple times do 
     * not get a location set when they are created. Set the location for those nodes, do nothing 
     * for other nodes.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:151
     */
    public void setErrorArgLocation(ASTNode node) {}
    /**
     * Check if this argument can be a vectorized argument, given the 
     * results to calls to this function for previous arguments.
     * 
     * The argument <code>dims</code> is the result from calls on other 
     * parameters. If -1, then the return value should be -1. If 0, then 
     * no vectorized arguments have been found so far. If greater than 0, 
     * then it is the number of dimensions of the vectorization size.
     * 
     * If this argument matches the size of the input, <code>dims</code> 
     * is returned. If the number of dimensions in the vectorization size 
     * that would be required for this to be a correctly vectorized argument 
     * differs from <code>dims</code>, then function is definately not a 
     * correctly vectorized function, and -1 is returned. Otherwise the 
     * vectorization size is returned.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:884
     */
    public int findVectorizationNdims(int dims) {
		return dims;
	}
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:892
     */
    protected int combineVectorizationSize(int pre, int exp, int var) {
		int res = exp - var;
		if (pre < 0 || res == 0)
			return pre;
		if (res < 0 || (pre > 0 && pre != res))
			return -1;
		return res;
	}
    /**
     * @aspect InstExpVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:239
     */
    public static TypePrefixVariability variability(List<InstFunctionArgument> args) {
        TypePrefixVariability total = Variability.CONSTANT;
        for (InstFunctionArgument arg : args) {
            total = total.combine(arg.variability().combine());
        }
        return total;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1054
     */
    public void populateInstModifications(List<InstModification> res) {}
    /**
     * Returns the FExp associated with this argument, if any.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1640
     */
    public FExp getFExp() { return null; }
    /**
     * Returns the FExp associated with this argument, if any, without triggering rewrites.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1645
     */
    public FExp getFExpNoTransform() { return null; }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1647
     */
    public FExp getOriginalFExp() { return null; }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:364
     */
    public FExp findFExpFor(Object id, SrcExp exp) {
        return matchesId(id) ? getFExp() : null;
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstFunctionArgument() {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:13
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:19
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:23
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        isVectorized_reset();
        getSrcModification_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:29
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public InstFunctionArgument clone() throws CloneNotSupportedException {
        InstFunctionArgument node = (InstFunctionArgument) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:44
     */
    @Deprecated
    public abstract InstFunctionArgument fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:52
     */
    public abstract InstFunctionArgument treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:60
     */
    public abstract InstFunctionArgument treeCopy();
    /**
     * Get array dimensions of function argument.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:297
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:297")
    public int ndims() {
        int ndims_value = -1;
        return ndims_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4721
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4721")
    public boolean isCircular() {
        boolean isCircular_value = false;
        return isCircular_value;
    }
    /**
     * Get array sizes of function argument.
     * @attribute syn
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionCallSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:282")
    public Size size() {
        Size size_value = null;
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:456
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:456")
    public FType type() {
        FType type_value = getFExp().type();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520")
    public boolean allowUnknownSize() {
        boolean allowUnknownSize_value = inAllowUnknownSize();
        return allowUnknownSize_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1546
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1546")
    public String argumentDesc() {
        String argumentDesc_value = null;
        return argumentDesc_value;
    }
    /**
     * Return the position of the input the argument corresponds to.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:44")
    public int findArgumentPosition(ArrayList<InstComponentDecl> inputs) {
        int findArgumentPosition_ArrayList_InstComponentDecl__value = -1;
        return findArgumentPosition_ArrayList_InstComponentDecl__value;
    }
    /**
     * Check if the argument was explicitly given in the call.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:59")
    public boolean isGiven() {
        boolean isGiven_value = false;
        return isGiven_value;
    }
    /**
     * Get the input component this argument is bound to.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:83
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:83")
    public InstComponentDecl getBoundInput() {
        InstComponentDecl getBoundInput_value = isInstRecordConstructorArg() ? myRecordConstructorVirtualInstComponentDecl() : 
                    boundInput == null ? unknownInstComponentDecl() : boundInput;
        return getBoundInput_value;
    }
    /**
     * Get the virtual component instance that is connected to this argument.
     * 
     * Only valid for arguments to record constructors in the instance tree.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:100")
    public InstComponentDecl myRecordConstructorVirtualInstComponentDecl() {
        InstComponentDecl myRecordConstructorVirtualInstComponentDecl_value = lookupRecordConstructorVirtualInstComponentDecl(boundInput.name());
        return myRecordConstructorVirtualInstComponentDecl_value;
    }
    /**
     * Returns <code>false</code> if this argument node represents an error, 
     * e.g. a missing argument.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:158
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:158")
    public boolean isOKArg() {
        boolean isOKArg_value = true;
        return isOKArg_value;
    }
    /** @apilevel internal */
    private void isVectorized_reset() {
        isVectorized_computed = false;
    }
    /** @apilevel internal */
    protected boolean isVectorized_computed = false;

    /** @apilevel internal */
    protected boolean isVectorized_value;

    /**
     * Check if this argument is vectorized.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:915
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:915")
    public boolean isVectorized() {
        ASTState state = state();
        if (isVectorized_computed) {
            return isVectorized_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isVectorized_value = false;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isVectorized_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isVectorized_value;
    }
    /**
     * @attribute syn
     * @aspect InstExpVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:247
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstExpVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:247")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = isOKArg() ? getFExp().variability() : Variability.CONSTANT;
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1064
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1064")
    public InstModification newInstModification() {
        InstModification newInstModification_value = new InstComponentModification(getSrcModification(), false, false,
                            boundInput.createInstAccess(),
                            new Opt<InstModification>(getSrcModification().newInstModification()));
        return newInstModification_value;
    }
    /** @apilevel internal */
    private void getSrcModification_reset() {
        getSrcModification_computed = false;
        
        getSrcModification_value = null;
    }
    /** @apilevel internal */
    protected boolean getSrcModification_computed = false;

    /** @apilevel internal */
    protected SrcModification getSrcModification_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1071
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1071")
    public SrcModification getSrcModification() {
        ASTState state = state();
        if (getSrcModification_computed) {
            return getSrcModification_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getSrcModification_value = getSrcModification_compute();
        getSrcModification_value.setParent(this);
        getSrcModification_value.is$Final = true;
        if (true) {
        getSrcModification_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getSrcModification_value;
    }
    /** @apilevel internal */
    private SrcModification getSrcModification_compute() {
            SrcDummyModification res = new SrcDummyModification();
            copyLocationTo(res);
            return res;
        }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:381
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:381")
    public boolean matchesId(Object id) {
        boolean matchesId_Object_value = false;
        return matchesId_Object_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329")
    public String funcName() {
        String funcName_value = getParent().Define_funcName(this, null);
        return funcName_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionCallSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416")
    public Size vectorizedSize() {
        Size vectorizedSize_value = getParent().Define_vectorizedSize(this, null);
        return vectorizedSize_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:434")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843")
    public boolean accessToModelOK() {
        boolean accessToModelOK_value = getParent().Define_accessToModelOK(this, null);
        return accessToModelOK_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483")
    public String functionCallDecription() {
        String functionCallDecription_value = getParent().Define_functionCallDecription(this, null);
        return functionCallDecription_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532")
    public boolean isDestructorArgument() {
        boolean isDestructorArgument_value = getParent().Define_isDestructorArgument(this, null);
        return isDestructorArgument_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1542
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1542")
    public String argumentTypeError() {
        String argumentTypeError_value = getParent().Define_argumentTypeError(this, null);
        return argumentTypeError_value;
    }
    /**
     * Check if the type defined for this argument in the built-in function list 
     * is valid.
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1676
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1676")
    public boolean argumentDefinedTypeValid() {
        boolean argumentDefinedTypeValid_value = getParent().Define_argumentDefinedTypeValid(this, null);
        return argumentDefinedTypeValid_value;
    }
    /**
     * Check if the type supplied is valid for this argument.
     * 
     * Only used if argumentDefinedTypeValid() returns <code>false</code>.
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1708
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1708")
    public boolean argumentTypeValid(FType type) {
        boolean argumentTypeValid_FType_value = getParent().Define_argumentTypeValid(this, null, type);
        return argumentTypeValid_FType_value;
    }
    /**
     * Description of expexted type of argument.
     * 
     * Should be defined for cases where argumentDefinedTypeValid() returns and 
     * argumentTypeValid() both return false.
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1744
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1744")
    public String expectedArgumentType() {
        String expectedArgumentType_value = getParent().Define_expectedArgumentType(this, null);
        return expectedArgumentType_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:283
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:283")
    public boolean canInlineConstant() {
        boolean canInlineConstant_value = getParent().Define_canInlineConstant(this, null);
        return canInlineConstant_value;
    }
    /**
     * Is this an argument to a record constructor in the instance tree?
     * @attribute inh
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90")
    public boolean isInstRecordConstructorArg() {
        boolean isInstRecordConstructorArg_value = getParent().Define_isInstRecordConstructorArg(this, null);
        return isInstRecordConstructorArg_value;
    }
    /**
     * Lookup the virtual component instance that should be connected to an argument of a given name.
     * 
     * Only valid for arguments to record constructors in the instance tree.
     * @attribute inh
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108")
    public InstComponentDecl lookupRecordConstructorVirtualInstComponentDecl(String name) {
        InstComponentDecl lookupRecordConstructorVirtualInstComponentDecl_String_value = getParent().Define_lookupRecordConstructorVirtualInstComponentDecl(this, null, name);
        return lookupRecordConstructorVirtualInstComponentDecl_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:124
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:124")
    public FAbstractFunctionCall myCall() {
        FAbstractFunctionCall myCall_value = getParent().Define_myCall(this, null);
        return myCall_value;
    }
    /**
     * Check if this is an argument to a vectorized function call.
     * @attribute inh
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905")
    public boolean inVectorizedCall() {
        boolean inVectorizedCall_value = getParent().Define_inVectorizedCall(this, null);
        return inVectorizedCall_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843
     * @apilevel internal
     */
    public boolean Define_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return accessToModelOK();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessToModelOK
     */
    protected boolean canDefine_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2742
     * @apilevel internal
     */
    public FExp Define_myFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2742
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFExp
     */
    protected boolean canDefine_myFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return !inFunction();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute flattenFASContext
     */
    protected boolean canDefine_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return canInlineConstant();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
