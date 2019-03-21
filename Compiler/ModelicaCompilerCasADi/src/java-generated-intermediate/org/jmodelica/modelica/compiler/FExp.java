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
 * Abstract base class for all flattened expressions.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:739
 * @astdecl FExp : BaseNode;
 * @production FExp : {@link BaseNode};

 */
public abstract class FExp extends BaseNode implements Cloneable, Array, Evaluable, ExternalArgument, HasType, LockBranch, FlatLookupNode, Named_C, TypePrintable_C {
    /**
     * Create a new expression suitable for use in an expression calculating the 
     * array size of a range expression.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:788
     */
    public FExp makeRangeSizeExp() {
        return type().wrapRangeSizeExp(fullCopy());
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1259
     */
    public ArrayExp createExpanded(Iterable<? extends CommonForIndex> forIndices) {
        return ArrayExp.createExpanded(this, forIndices);
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1281
     */
    protected FExp replaceIndices(Map<String,FExp> indexMap) {
		return (FExp) super.replaceIndices(indexMap);
	}
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1428
     */
    protected static FExp vectorMultiplication(Iterator<FExp> left, Iterator<FExp> right, FType type) {
		if (!left.hasNext())
			return type.zeroLiteral();
		FExp cur = new FMulExp( left.next().fullCopy(), right.next().fullCopy());
		while (left.hasNext()) 
			cur = new FAddExp(cur, new FMulExp( left.next().fullCopy(), right.next().fullCopy()));
		return cur;
	}
    /**
     * Add a copy of this expression to arr at position i. 
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1851
     */
    public void fillArray(ArrayExp arr, Index i, int level) {
		if (isArray())
            arr.set(i, getArray().get(i.subIndex(level)).copySymbolic());
		else
            arr.set(i, copySymbolic());
	}
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3855
     */
    
        
        public Iterator<FExp> iteratorFExp() {
            return iterable().iterator();
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3858
     */
    
        public Iterable<FExp> iterable() {return Collections.singleton(this);}
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3859
     */
    
        public Iterator<FExp> leftMulIterator(Index i) {return iteratorFExp();}
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3860
     */
    
        public Iterator<FExp> rightMulIterator(Index i) {return iteratorFExp();}
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3862
     */
    
        
        public FExp getFExp(int i) {
            return this;
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3866
     */
    
        
        public FExp get(Index i) {
            return this;
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3870
     */
    
        
        public FExp get(int i) {
            return this;
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3874
     */
    
        
        public FExp subArrayFExp(Index i) {
            return this;
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3878
     */
    
        
        public FExp subArrayFExp(Index i, NonConsecutiveIndices indices) {
            return this;
        }
    /**
     * Create an FExp that represents a specific component of this record expression.
     * 
     * TODO: merge into FExp.component()
     * 
     * @param suffix    the suffix to add to a use of the record to access the specific component
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:72
     */
    public FExp extractRecordFExp(String suffix) {
        return new FComponentExp(treeCopy(), suffix);
    }
    /** 
     * \build Creates an FExp with literals from this Array.
     * 
     * Creates a (possibly nested) FArray containing FLitExp nodes.
     * 
     * @param toReal  if <code>true</code>, convert all values to real.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2031
     */
    public FExp buildLiteral(boolean toReal) {
        return toReal ? ceval().convertReal().buildLiteral() : ceval().buildLiteral();
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2116
     */
    public void collectAccessNames(Set<String> collectedNames) {
        for (FExp child : childFExps()) {
            child.collectAccessNames(collectedNames);
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3697
     */
    public void resetAfterCeval() {
        flushAllRecursive();
    }
    /**
     * @aspect ConstantEvaluable
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4912
     */
    public ConstValue evaluateValue() {
        try {
            return ceval();
        } catch (ConstantEvaluationException e) {
            return CValue.UNKNOWN;
        }
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:5105
     */
    public void mapComponents(Map<FAccessExp, Set<FAccessExp>> res, CValue val) {
        throw new UnsupportedOperationException("Unsupported FExp in LHS");
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:5114
     */
    public void mapComponentsArray(Map<FAccessExp, Set<FAccessExp>> res, CValueArray val, Enumerator e) {
        mapComponents(res, val.getCell(e.next()));
    }
    /**
     * Evaluate an assignment with this as the left side during function evaluation.
     * 
     * @param evaluator the evaluator used to evaluate the algorithm
     * @param right     the CValue to assign
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:91
     */
    public void assignToInFuncEval(AlgorithmEvaluator evaluator, CValue right, FType rightType) {
        throw new ConstantEvaluationException();
    }
    /**
     * Add this expression to another.
     * 
     * Used to gradually builf up a sum, and handles special case for first term. 
     * The so far accumulated expession is then passed as exp, and this node will be 
     * the right child of the created expression. May return <code>this</code>, 
     * if exp is <code>null</code>.
     * 
     * @param exp   the first term, may be null
     * @param neg   if <code>true</code>, then this will be subtracted instead of added
     * @param type  the type of this expression (can't be calculated locally, since this 
     * is generally not in tree at this point). The result is calculated with 
     * the assumption that <code>exp</code> is of the same type. When one is 
     * Integer and the other Real, this assumption gives the correct result.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:435
     */
    public FExp appendSum(FExp exp, boolean neg, FType type) {
        if (exp == null)
            return neg ? type.createFNegExp(this) : this;
        else
            return neg ? type.createFSubExp(exp, this) : type.createFAddExp(exp, this);
    }
    /**
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:866
     */
    public FSubscript createFSubscript() {
        return new FExpSubscript(this);
    }
    /**
     * Create a new empty node.
     * 
     * Abstract method needed for abstract node classes with declared 
     * (i.e. not inherited) children.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:894
     */
    public abstract FExp createEmptyNode();
    /**
     * Create new node of same class as this, with the specified 
     * children. Used to allow common algorithms to handle unrelated types.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1278
     */
    public FExp createNodeBinary(FExp a, FExp b) {
		throw new UnsupportedOperationException();
	}
    /**
     * Create new node of same class as this, with the specified 
     * child. Used to allow common algorithms to handle unrelated types.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1286
     */
    public FExp createNodeUnary(FExp a) {
		throw new UnsupportedOperationException();
	}
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1928
     */
    public void flatChildFExps(ArrayList<FExp> res) {
        res.add(this);
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1966
     */
    protected int checkIndex(int i) {
        if (i < 0) {
            throw new UnsupportedOperationException("Unknown switch index for relational operator, not in list of switches.");
        }
        return i;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2329
     */
    public Iterable<FAbstractEquation> enclosingEquationsIterator() {
        return myFEquation().enclosingEquationsIterator();
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3045
     */
    public final Set<String> assignedInAllBranchesVariables() {
        Set<String> res = new HashSet<String>();
        assignedInAllBranchesVariables(res);
        return res;
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3051
     */
    public void assignedInAllBranchesVariables(Set<String> res) {
        for (FExp exp : childFExps())
            exp.assignedInAllBranchesVariables(res);
    }
    /**
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3216
     */
    public static FExp nominalMax(FExp e1, FExp e2) {
        return new FMaxExp(e1.nominal(), new Opt<FExp>(e2.nominal()));
    }
    /**
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3219
     */
    public static FExp nominalDefault() {
        return new FIntegerLitExp(1);
    }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:220
     */
    public void addToParameterEquationsMap(
			Map<FAbstractVariable,FAbstractEquation> map, FAbstractEquation equ) {
		for (FExp e : childFExps())
			e.addToParameterEquationsMap(map, equ);
	}
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1556
     */
    private String myTempVarName;
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1551
     */
    public final void prettyPrint(Printer p, CodeStream str, String indent) {
		boolean addParenthesis = addParenthesis(parentPrecedence());
		if (addParenthesis)
			str.print('(');
		prettyPrintExp(p, str, indent);
		if (addParenthesis)
			str.print(')');
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1560
     */
    protected abstract void prettyPrintExp(Printer p, CodeStream str, String indent);
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1624
     */
    public void prettyPrintAsElseExp(Printer p, CodeStream str, String indent) {
		str.print(' ');
		p.print(this, str, indent);
	}
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:128
     */
    
        public static class SizeContextReplacer implements ContextReplacer {
            private FSubscript fs;
            public SizeContextReplacer(FSubscript fs) {
                this.fs = fs;
            }
            
            @Override
            public FExp copyReplaceAccess(CommonAccessExp access) {
                return access.getAccess().buildAccessContextSizeExp(this);
            }
            
            @Override
            public FExp copyReplaceAccess(FSizeExp exp) {
                return exp.copyReplaceAccessExp(this);
            }
            
            public List<InstAccess> buildContext() {
                 return fs.myInstAccess().accessContextInst();
            }
        }
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:333
     */
    
        public static class FunctionSizeContextReplacer extends FunctionContextReplacer {
            public FunctionSizeContextReplacer(Map<InstComponentDecl, InstFunctionArgument> varMap) {
                super(varMap);
            }
            
            @Override
            public FExp copyReplaceAccess(FSizeExp exp) {
                return exp.createSizeFExp(this);
            }
            
        }
    /**
     * Create a copy of this expression suitable for when it is used to describe a size.
     * 
     * Default implementation simply returns a copy.
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:372
     */
    public FExp createSizeFExp() {
        return unboundCopy();
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:426
     */
    
        public interface ContextReplacer {
            public FExp copyReplaceAccess(CommonAccessExp access);
            public FExp copyReplaceAccess(FSizeExp exp);
        }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:431
     */
    

        public static class FunctionContextReplacer implements ContextReplacer {
            private Map<InstComponentDecl,InstFunctionArgument> varMap;
            public FunctionContextReplacer(Map<InstComponentDecl,InstFunctionArgument> varMap) {
                this.varMap = varMap;
            }
            
            @Override
            public FExp copyReplaceAccess(CommonAccessExp access) {
                FExp res = access.asInstAccess().copyReplaceAccess(this);
                if (res == null) {
                    return new FDeferExp(access);
                }
                return res;
            }
            
            @Override
            public FExp copyReplaceAccess(FSizeExp exp) {
                return exp.copyReplaceAccessExp(this);
            }
            
            public FExp get(InstComponentDecl icd) {
                if (varMap.containsKey(icd)) {
                    InstFunctionArgument ifa = varMap.get(icd);
                    return ifa == null ? icd.getBindingFExp().copyReplaceAccess(this) : ifa.getFExp();
                }
                return null;
            }
        }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:460
     */
    
        
        public static class ExpFunctionContextReplacer extends FunctionContextReplacer {
            private Map<InstComponentDecl,FExp> expMap;
            public ExpFunctionContextReplacer(Map<InstComponentDecl,FExp> expMap) {
                super(null);
                this.expMap = expMap;
            }
            
            @Override
            public FExp get(InstComponentDecl icd) {
                if (expMap.containsKey(icd)) {
                    FExp exp = expMap.get(icd);
                    return exp == null ? icd.getBindingFExp().copyReplaceAccess(this) : exp;
                }
                return null;
            }
        }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:499
     */
    public FExp copyReplaceAccess(FExp.ContextReplacer crp) {
        FExp exp = copy();
        for (int i = 0; i < getNumChild(); i++) {
            exp.setChild(getChild(i).copyReplaceAccess(crp), i);
        }
        return exp;
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:566
     */
    public FExp cell(FExp.FunctionContextReplacer crp, FArraySubscripts fas) {
        if (fas != null) {
            if (fas.variability().knownParameterOrLess()) {
                try {
                    return cell(fas.createIndex());
                } catch (ConstantEvaluationException e) {
                    
                }
            }
            return new FSubscriptedExp(this, fas.copyReplaceAccess(crp));
        }
        return this;
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:253
     */
    public FType promoteTypeForFExpList(Iterable<FExp> exps) {
        Iterator<FExp> it = exps.iterator();
        if (!it.hasNext())
            return fUnknownType();
        FType tot = it.next().type();
        while (it.hasNext())
            tot = tot.typePromotion(it.next().type());
        return tot;
    }
    /**
     * Convert all continous variables that this expression refers to into discrete variables.
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:360
     */
    public void makeContinuousVariablesDiscrete() {}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:438
     */
    public static TypePrefixVariability combineFExpListVariability(Iterable<? extends FExp> exps) {
        Iterator<? extends FExp> it = exps.iterator();
        TypePrefixVariability total = it.hasNext() ? it.next().variability() : Variability.CONSTANT;
        while (it.hasNext()) 
            total = total.combine(it.next().variability());
        return total;
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:853
     */
    public void markAsStructuralParameter(ErrorCheckType checkType) {
        forceVariability(checkType, Variability.STRUCTPARAMETER);
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:857
     */
    public void forceVariability(ErrorCheckType checkType,  TypePrefixVariability v) {
        if (!inFunction()) {
            forceUsesVariability(checkType, v);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:676
     */
    public void collectErrors(ErrorCheckType checkType) {
        if (!errorChecked) {
            errorChecked = true;
            super.collectErrors(checkType);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:901
     */
    public void checkConstantExpression(ErrorCheckType checkType, String varKind, String varName) {
		boolean failed = false;
        ConstantEvaluationException eres = null;
		try {
			if (isCircular()) {
			    if (!checkType.allowConstantNoValue())
    				error("Could not evaluate binding expression for %s '%s' due to circularity: '%s'", 
    						varKind, varName, prettyPrint(""));
			} else {
				CValue val = ceval();
				if (val.isPartlyUnknown()) {
					if (val.isUnsupported()) {
						compliance("Constant evaluation not supported for expression(s) directly or indirectly " + 
								"used by the binding expression for %s '%s': '%s'", varKind, varName, prettyPrint(""));
					} else {
						failed = true;
					}
				}
			}
		} catch (ConstantEvaluationNotReadyException e) {
			// Will be evaluatable later, ignore for now
		} catch (ConstantEvaluationException e) {
			failed = true;
			eres = e;
		}
		if (failed && !checkType.allowConstantNoValue()) {
			error("Could not evaluate binding expression for %s '%s': '%s'%s", varKind, varName, prettyPrint(""),
			        eres == null ? "" : eres.getModelicaStackTrace());
		}
	}
    /**
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1756
     */
    public void collectReinits(Map<FAbstractVariable,Set<FReinit>> map) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:478
     */
    public void typeCheck(ErrorCheckType checkType) {
        if (generateTypeError()) {
            for (FExp exp : childFExps())
                if (exp.type().isUnknown())
                    return;
            typeError(checkType);
        } else {
            size().markAsStructuralParameter(checkType, this);
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:614
     */
    
        public static class ExpTypeErrorProducer extends AbstractErrorProducerUnlessDisabled<ReporterNode> {
            private final String message;
            
            public ExpTypeErrorProducer(String identifier, String message) {
                super(identifier, ProblemKind.SEMANTIC);
                this.message = message;
            }

            public void invoke(FExp node) {
                StringBuilder buf = new StringBuilder(message);
                buf.append(": ");
                buf.append(node);
                for (FExp exp : node.childFExps()) {
                    buf.append("\n    type of '");
                    buf.append(exp);
                    buf.append("' is ");
                    buf.append(exp.type());
                }
                super.invokeWithCondition(node, node.typeErrorOnlyLengths(), buf.toString());
            }

            @Override
            public String description() {
                return message;
            }
            
        }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:646
     */
    public void typeError(ErrorCheckType checkType) {
        TYPE_MISMATCH_IN_EXPRESSION.invoke(this);
    }
    /**
     * @aspect VariabilityCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1836
     */
    public void setInstanceTreeSource(FExp source) {}
    /**
     * Generate error for operator that got wrong variability of argument
     * @aspect VariabilityCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1885
     */
    public void discreteArgError() {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:419
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        super.flattenUsedFuncsAndEnums(f);
        InstClassDecl oper = overloadedOperator(true);
        boolean scalar = oper == null;
        if (scalar)
            oper = overloadedOperator(false);
        if (oper != null) {
            oper.flattenFunction(f);
            int i = 0;
            for (FExp arg : childFExps()) {
                FType inType = oper.myInputs().get(i).type();
                FType argType = arg.type();
                if (scalar) 
                    argType = argType.scalarType();
                if (!inType.typeCompatible(argType, true))
                    inType.matchOverloadedConstructor(argType).flattenFunction(f);
                i++;
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1112
     */
    public FExp affixExpression(FExp exp) {
        return dynamicFExp(exp);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1653
     */
    public FExp addInDim(Stack<Integer> s, int d, FArray arr) {
        if (d == s.size()) {
            return this;
        } else {
            if (arr == null) {
                arr = new FArray();
            }
            int i = s.get(d);
            List<FExp> l = arr.getFExpListNoTransform();
            if (i < l.getNumChildNoTransform()) {
                l.setChild(addInDim(s, d+1, (FArray)l.getChildNoTransform(i)), i);
            } else {
                arr.addFExpNoTransform(addInDim(s, d+1, null));
            }
            return arr;
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2348
     */
    public FExp flatten(Flattener f) {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2506
     */
    public FExp buildFlattened(Flattener f, FExp context) {
        return flatten(f);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2586
     */
    public FExp createFPreExp() {
        throw new UnsupportedOperationException("createFPreExp() is not supported for class type " + getClass().getSimpleName());
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2693
     */
    public FExp flattenDer(Flattener f, int order) {
        return diff(TIME, order).flatten(f);
    }
    /**
     * Dynamically places an FExp in the tree under this FExp.
     * 
     * If <code>exp</code> is already in tree of if <code>exp == this</code>, 
     * then <code>exp</code> is returned.
     * 
     * @return  the final version of the dynamically placed node.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:890
     */
    public FExp dynamicFExp(FExp exp) {
		if (exp == this || exp == null)
			return exp;
		if (exp.parent != null) {
			int i = exp.parent.getIndexOfChild(exp);
			if (i >= 0)
				return (FExp) exp.parent.getChild(i);
		}
		getDynamicFExpOpt().setChild(exp, 0);
		return (FExp) getDynamicFExpOpt().getChild(0);
	}
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:48
     */
    public static final String OP_CON  = "'constructor'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:49
     */
    public static final String OP_ZERO = "'0'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:50
     */
    public static final String OP_STR  = "'String'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:51
     */
    public static final String OP_ADD  = "'+'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:52
     */
    public static final String OP_SUB  = "'-'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:53
     */
    public static final String OP_MUL  = "'*'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:54
     */
    public static final String OP_DIV  = "'/'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:55
     */
    public static final String OP_POW  = "'^'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:56
     */
    public static final String OP_EQ   = "'=='";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:57
     */
    public static final String OP_NEQ  = "'<>'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:58
     */
    public static final String OP_GT   = "'>'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:59
     */
    public static final String OP_LT   = "'<'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:60
     */
    public static final String OP_GEQ  = "'>='";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:61
     */
    public static final String OP_LEQ  = "'<='";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:62
     */
    public static final String OP_AND  = "'and'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:63
     */
    public static final String OP_OR   = "'or'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:64
     */
    public static final String OP_NEG  = "'-'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:65
     */
    public static final String OP_NOT  = "'not'";
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:67
     */
    public static final Set<String> OPERATORS = new HashSet<String>(Arrays.asList(
            OP_CON, OP_ZERO, 
            OP_STR, 
            OP_ADD, OP_SUB, OP_MUL, OP_DIV, OP_POW, OP_EQ, OP_NEQ, OP_GT, OP_LT, OP_GEQ, OP_LEQ, OP_AND, OP_OR, 
            OP_NEG, OP_NOT));
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:72
     */
    public static final Set<String> CONSTRUCTOR_OPERATORS = new HashSet<String>(Arrays.asList(
            OP_CON, OP_ZERO));
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:74
     */
    public static final Set<String> CONVERSION_OPERATORS = new HashSet<String>(Arrays.asList(
            OP_STR));
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:76
     */
    public static final Set<String> BINARY_OPERATORS = new HashSet<String>(Arrays.asList(
            OP_ADD, OP_SUB, OP_MUL, OP_DIV, OP_POW, OP_EQ, OP_NEQ, OP_GT, OP_LT, OP_GEQ, OP_LEQ, OP_AND, OP_OR));
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:78
     */
    public static final Set<String> UNARY_OPERATORS = new HashSet<String>(Arrays.asList(
            OP_NEG, OP_NOT));
    /**
     * Get a child expression that is equivalent to exp if its parent 
     * expression is equivalent to this.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:323
     */
    public FExp equivalentChildFExp(SrcExp exp) {
        Iterator<FExp> fIt = childFExps().iterator();
        for (SrcExp srcChild : exp.parentExp().childSrcExps()) {
            if (!fIt.hasNext()) {
                break;
            }
            FExp fChild = fIt.next();
            if (srcChild == exp) {
                return fChild;
            }
        }
        throw new IllegalArgumentException("Could not find equivalent sub-expression to '" + 
                exp + "' in '" + this + "'.");
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:298
     */
    public void collectLocations(BaseNode collector){
		return;
	}
    /**
     * Returns an iterable, that has an iterator that iterates over all direct FExp children.
     * 
     * The iterator passes through Lists and Opts.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:467
     */
    public Iterable<FExp> childFExps() {
        return new ChildTypedIterable(FExp.class);
    }
    /**
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1871
     */
    abstract public FExp copy();
    /**
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1874
     */
    public FExp unboundCopy() { return (FExp) super.unboundCopy(); }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:114
     */
    public void sanityCheckParameterEquationLeft(FClass fc, FAbstractEquation eqn) {
        for (FExp e : childFExps())
            e.sanityCheckParameterEquationLeft(fc, eqn);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:144
     */
    public void sanityCheckType(FClass fc) {
        sanityCheckTypeInChildren(fc);
        if (type().isUnknown()) {
            fc.sanityProblem(this, "Unknown type in expression: %s", this);
        }
    }
    /**
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1328
     */
    public void flushAllRecursiveClearFinal() {
		super.flushAllRecursiveClearFinal();
		is$Final = false;
	}
    /**
     * Mark referenced variable as state.
     * 
     * Only valid for variable accesses, default implementation throws exception.
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1707
     */
    public void markReferencedVarAsState() {
        throw new UnsupportedOperationException();
    }
    /**
     * Detection of alias variables in expressions
     * 
     * Only valid when in an equation that gives that the value of this expression is always 0.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:147
     */
    public AliasPair aliasVariables(boolean checkVariables) {
        return null;
    }
    /**
     * Remove all uses in an expression from the uses lists of their respective variables.
     * 
     * Should only be used to allow iterative algorithms to use updated uses lists while 
     * removing expressions. Only valid in flat tree.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:653
     */
    public void removeFromUses() {
		for (FExp e : childFExps())
			e.removeFromUses();
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:934
     */
    public void insertTempsInLHS(FClass fClass, boolean param) {
        String tempName = calcTempVarName();
        TypePrefixVariability v;
        if (param) {
            v = Variability.FIXEDPARAMETER;
        } else {
            v = type().funcOutputVariability();
        }
        fClass.addFVariable(type().createTempFVariable(new FAccessString(tempName), v));
        replaceMe(new FAccessExp(tempName));
        FEquation e = new FEquation(this, new FAccessExp(tempName));
        if (param) {
            fClass.addParameterEquation(e);
        } else {
            fClass.addFEquation(e);
        }
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:86
     */
    public void findBlockFunctionExtraction(AbstractEquationBlock block, ArrayList<FFunctionCall> functions) {

    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:122
     */
    public boolean dependsOnBlock(AbstractEquationBlock block) {
        return true;
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:196
     */
    public FExp merge(FClass.commonSubexpressionEliminationIfSet.CSESet m, FExp exp) {
        if (!exp.isNoExp()) {
            m.add(new FEquation(fullCopy(), exp.fullCopy()));
        }
        return this;
    }
    /**
     * @aspect EqualSwitchElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\EqualSwitchElimination.jrag:78
     */
    public void collectEqualSwitches(Map<String, Collection<FRelExp>> candidates) {
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:495
     */
    public void addInliningVarsAndEqns(AbstractFunctionInliner fi, String oldName, boolean noEvent) {
        FType type = type();
        if (isArray()) {
            fi.setTypeOf(oldName, type);
            Array arr = getArray();
            for (Index i : indices()) {
                arr.get(i).addInliningVarsAndEqns(fi, oldName + i, noEvent);
            }
        } else if (type.isRecord()) {
            fi.setTypeOf(oldName, type);
            oldName += ".";
            for (FRecordComponentType part : ((FRecordType) type()).getComponents()) {
                component(part.getName()).addInliningVarsAndEqns(fi, oldName + part.getName(), noEvent);
            }
        } else {
            fi.addVarAndEqn(oldName, this, noEvent);
        }
    }
    /**
     * Create temporary variable(s) for this access when inlining a function call that 
     * it is a left of, and return an access. Non-access expressions returns null.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:565
     */
    public FExp createInlineVars(
            AbstractFunctionInliner fi, FExp bExp, TypePrefixVariability variability) {
        return null;
    }
    /**
     * Encapsulate any event-generating expressions in noEvent().
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:608
     */
    public FExp preventEvents() {
        if (eventGenerating()) {
            FNoEventExp res = new FNoEventExp();
            replaceMe(res);
            res.setFExp(this);
            return res;
        } else {
            for (FExp e : childFExps())
                e.preventEvents();
            return this;
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:861
     */
    public void createInliningOutputEquations(
            ArrayList<FAbstractEquation> list, AbstractFunctionInliner fi, FAccess name) {
        FExp right = fi.getReplacementExp(name.scalarName());
        right = (right == null) ? type().zeroLiteral() : right.fullCopy();
        if (!this.isNoExp())
            list.add(new FEquation(this, right));
    }
    /**
     * Inline all calls to functions that we can inline.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:891
     */
    public void inlineFunctions(AbstractFunctionInliner fi) {
        for (FExp exp : childFExps())
            exp.inlineFunctions(fi);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1577
     */
    public FExp replaceReferences(AbstractFunctionInliner fi) {
        super.replaceReferences(fi);
        return this;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1730
     */
    public FExp buildWithReplacedReferences(AbstractFunctionInliner fi, FExp context) {
        return context.dynamicFExp(this).replaceReferences(fi);
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:408
     */
    public boolean variabilityPropagation(
            FClass.VariabilityPropagator propagator,
            CValue value,
            TypePrefixVariability variability) {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:465
     */
    public boolean variabilityPropagationArray(
            FClass.VariabilityPropagator propagator,
            CValueArray value,
            TypePrefixVariability variability,
            Enumerator enumerator) {
        return variabilityPropagation(propagator,
                    value == null ? CValue.UNKNOWN : value.values[enumerator.next()], variability);
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:658
     */
    public boolean taggedByVProp              = false;
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:692
     */
    public FExp cleanEquations() {
        if (taggedByVProp) {
            return new FNoExp();
        } else {
            return this;
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:903
     */
    public FTempAccessExp tempExp(String name, Index i) {
        FTempAccessExp res;
        if (inFunction()) {
            res = new FTempAccessExp(new FAccessFull(name, i.createFArraySubscripts()));
        } else {
            res = new FTempAccessExp(new FAccessString(name + i));
        }
        return (FTempAccessExp) dynamicFExp(res);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:913
     */
    public FTempAccessExp tempExp(String name, FArraySubscripts fas) {
        FTempAccessExp res;
        if (inFunction()) {
            res = new FTempAccessExp(new FAccessFull(name, fas));
        } else {
            if (fas == null) {
                res = new FTempAccessExp(new FAccessString(name));
            } else {
                res = new FTempAccessExp(new FAccessString(name + fas));
            }
        }
        return (FTempAccessExp) dynamicFExp(res);
    }
    /**
     * Stores FSubscripts to be uses by <code>scalarize()</code>
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:930
     */
    public FExp[] indexNames = null;
    /**
     * Create an FExp that represents a specific scalar component of this record.
     * 
     * @param suffix    the suffix to add to a use of the record to access the specific component
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1069
     */
    public FExp scalarRecordFExp(Scalarizer s, String suffix) {
        return scalarRecordFExp(s, new FAccessString(suffix));
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1073
     */
    public FExp scalarRecordFExp(Scalarizer s, FAccess suffix) {
        if (useTempVar) {
            return tempExp().scalarRecordFExp(s, suffix);
        }
        return scalarize(s);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1170
     */
    public FExp extractArrayCell(Scalarizer s, int... index) {
        return extractArrayCell(s, new Index(index));
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1174
     */
    public FExp extractArrayCell(Scalarizer s, Index i) {
        if (type().isUnknown() || size().isUnknown()) {
            int[] ind = i.index();
            FExp[] subs = new FExp[ind.length];
            for (int k = 0; k < ind.length; k++) {
                subs[k] = new FIntegerLitExp(ind[k]);
            }
            return extractArrayCell(s, subs);
        } else {
            return cell(i);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1187
     */
    public FExp extractArrayCell(Scalarizer s, FExp... subs) {
        addArrayUsesToIndexMap(subs);
        return dynamicFExp(scalarize(s));
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1226
     */
    public void scalarizeOperatorWithoutOutputs(Scalarizer s) {
        if (isArray()) {
            for (FExp e : getArray().iterable()) {
                e.scalarizeOperatorWithoutOutputs(s);
            }
        } else if (type().isRecord()) {
            for (FRecordComponentType frct : ((FRecordType)type()).getComponents()) {
                component(frct.getName()).scalarizeOperatorWithoutOutputs(s);
            }
        } else {
            FAbstractFunctionCall call = (FAbstractFunctionCall) scalarizeExp(s);
            List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
            s.add(lefts, call);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1325
     */
    public void notifyIfWhenEquationsOfTemporaryVar() {
	    FIfWhenEquation myIf = surroundingIfOrElse();
	    if (myIf != null) 
	        myIf.addBranchTemporary(this);
	}
    /**
     * Flag that signals that this expression should be replaced with a use of a temporary variable.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1437
     */
    protected boolean useTempVar = false;
    /**
     * Scalarize expressions, replacing array expressions with FArrays of scalarized subexpressions.
     * 
     * The FArrays are needed because function calls need arrays to be passed as arrays.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1445
     */
    public FExp scalarize(Scalarizer s) {
        FExp exp = useTempVar ? tempExp() : this;
        if (scalarizeExpanded()) {
            return type().createRecordConstructor(s, exp);
        } else {
            return exp.scalarizeExp(s);
        }
    }
    /**
     * Scalarize expressions.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1475
     */
    public FExp scalarizeExp(Scalarizer s) {
        return treeCopy();
	}
    /**
     * Scalarize an expression by recursively scalarizing and combining the contents in its Array.
     * 
     * New nodes are created with <code>template.createNodeBinary()</code>.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1693
     */
    public FExp reduceToScalarized(FExp template, Scalarizer s) {
        if (isArray()) {
            java.util.List<FExp> scalarizedExps = new ArrayList<FExp>();
            Iterator<FExp> it = getArray().iteratorFExp();
            while (it.hasNext()) {
                scalarizedExps.add(it.next().scalarize(s));
            }
            return createBalancedBinaryTree(template, scalarizedExps);
        } else {
            return scalarize(s);
        }
    }
    /**
     * Constructs a balanced binary tree based on the expression list exps with
     * the operation as specified by template.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1710
     */
    public static FExp createBalancedBinaryTree(FExp template, java.util.List<FExp> exps) {
        return createBalancedBinaryTree(template, exps, 0, exps.size());
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1714
     */
    private static FExp createBalancedBinaryTree(FExp template, java.util.List<FExp> exps, int start, int end) {
        if (start == end) {
            return null;
        }
        if (start == end - 1) {
            return exps.get(start);
        }
        // We want a left heavy tree, hence the modulo part
        int half = (start + end) / 2 + (start + end) % 2;
        FExp left = createBalancedBinaryTree(template, exps, start, half);
        FExp right = createBalancedBinaryTree(template, exps, half, end);
        return template.createNodeBinary(left, right);
    }
    /**
     * Scalarize the expression of an FForIndex. 
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1936
     */
    public FExp scalarizeIndexExp(Scalarizer s) {
		return scalarize(s);
	}
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:163
     */
    public void usesInScalarizedExp(Set<FAbstractVariable> res) {
        if (!extractTemp()) {
            super.usesInScalarizedExp(res);
        }
    }
    /**
     * Finds, extracts, and replaces expressions with temporaries
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:194
     */
    public void createArrayTemporaries(Scalarizer s) {
        if (extractTemp()) {
            if (inFunction() && myFClass().noUnrollingInFunctions() || extractAsUnknown()) {
                unknownFunctionArrayTemporaries(s);
                useTempVar = true;
            } else {
                knownArrayTemporaries(s);
            }
        } else {
            createArrayTemporariesInChildren(s);
        }
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:207
     */
    public void createArrayTemporariesInChildren(Scalarizer s) {
        for (ASTNode n : this) {
            n.createArrayTemporaries(s);
        }
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:230
     */
    public void createArrayTemporariesIfBranch(FExp ifExp, Scalarizer s) {
        List thenClauses = new List();
        List elseClauses = new List();
        List<FAbstractVariable> thenVars = new List<FAbstractVariable>();
        createArrayTemporaries(s.block(thenVars, thenClauses));
        if (thenClauses.getNumChild() > 0) {
            if (inFAlgorithm()) {
                List<FIfWhenClause> cl = new List<FIfWhenClause>();
                cl.add(new FIfClause(ifExp, thenClauses));
                s.add(new FIfStmtTemp(cl, elseClauses));
            } else {
                for (FAbstractVariable fv : thenVars) {
                    elseClauses.add(new FEquation(fv.createAccessExp(), fv.type().zeroLiteral()));
                }
                FElseEquation elseClause = new FElseEquation(EquationType.NORMAL, elseClauses);
                FIfEquation equation = new FIfEquation(EquationType.NORMAL, thenClauses, ifExp, new Opt<FIfWhenElseEquation>(elseClause));
                equation.setIsTempAssign();
                s.add(equation);
            }
            s.add(thenVars);
        }
    }
    /**
     * Create clauses for and replace this known size expression with a temp variable.
     * Used in both functions and equations.
     * @param s Scalarization visitor
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:341
     */
    public void knownArrayTemporaries(Scalarizer s) {
        s.addTempVar(this);
        Array arr = getArray();
        for (Index i : indices()) {
            arr.get(i).createArrayTemporaries(s);
            s.add(tempExp(i), arr.get(i).scalarize(s));
        }
        useTempVar = true;
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:384
     */
    public FFunctionCallLeft scalarizeLeft(Scalarizer s) {
        if (size().isEmpty()) {
            return new FFunctionCallLeft();
        }
        
        FExp exp = this;
        if (isSlice() && (s.inFunction() && myFClass().noUnrollingInFunctions() || extractAsUnknown())) {
            s.addTempVar(exp);
            exp = exp.tempExp();
            exp = exp.scalarizeExp(s);
        } else if (!s.inFunction() || isSlice()) {
            exp = type().createRecordConstructor(s, exp);
        } else {
            exp = exp.scalarizeExp(s);
        }
        return new FFunctionCallLeft(new Opt<FExp>(exp));
    }
    /**
     * Create clauses for and replace this unknown size expression with a temp variable.
     * Used in functions.
     * @param s Scalarization visitor
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:421
     */
    public void unknownFunctionArrayTemporaries(Scalarizer s) {
        s.addTempVar(this);
        createArrayTemporariesInChildren(s);
        useTempVar = false;
        type().scalarizeAssignment((Scalarizer.Algorithm)s, tempExp(), this);
        indexNames = null;
    }
    /**
     * Helper for unknown size expressions containing iteration expressions.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:852
     */
    public boolean editNamesIter(Scalarizer s) {
        return false;
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:881
     */
    public FExp scalarizeWithIndex(Scalarizer s, FExp res) {
        return null;
    }
    /**
     * Copies top layer in <code>names</code> to id uses and creates entries
     * in <code>indexNames</code> for expressions replaced with temps.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:917
     */
    public void addArrayUsesToIndexMap(FExp[] names) {
        if (useTempVar) {
            if (isArray()) {
                indexNames = names;
            }
        } else {
            super.addArrayUsesToIndexMap(names);
        }
    }
    /**
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:145
     */
    public FAssert sizeAssert(FExp e, int i) {
        String dim = i < 0 ? "" : String.format("dimension %d of ", i+1);
        return (FAssert)dynamicFExp(new FAssert(e, new FStringLitExp(String.format("Mismatching size in %sexpression %s in function %s",
                dim, prettyPrint(""), containingFFunctionDecl().name())), new Opt<FExp>()));
    }
    /**
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:168
     */
    public FExp orNotIfExpConds(FExp e1) {
        FExp e2 = enclosingIfExpCond();
        if (e2 != null)
            e1 = new FOrExp(e1, new FNotExp(e2));
        return e1;
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:144
     */
    public static final String TIME = "time";
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:146
     */
    public FExp diff(String name, int n) {
        return (n <= 1) ? diff(name) : diff(name, n - 1).diff(name);
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:150
     */
    public final FExp diff(String name) {
        return dynamicFExp(diffExp(name));
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:154
     */
    protected FExp diffExp(String name) {
        throw new ExpressionDifferentiationException(this);
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:534
     */
    public FExp diffUseOrDerExp(String name, String myName) {
        if (name.equals(TIME)) {
            if (variability().continuousVariability() || inFunction() && type().containsReal()) {
                return createDerExp(1);
            } else {
                return type().sizedZeroLiteral();
            }
        } else if (name.equals(myName)) {
            FExp exp = type().createSizedLiteral(1);
            if (exp == null) {
                exp = new FNoExp();
            }
            return exp;
        } else {
            return type().sizedZeroLiteral();
        }
    }
    /**
     * Generic implementation of {@link #diff(String)} for array expressions 
     * that delegates to the elements of array expansion.
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:821
     */
    protected FExp diffArray(String name) {
        return getArray().buildDiff(name);
    }
    /**
     * Generic implementation of {@link #diff(String)} for expressions that are 
     * always constant during simulation.
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:829
     */
    protected FExp diffZero() {
        return type().sizedZeroLiteral();
    }
    /**
     * Generic implementation of {@link #diff(String)} that simply differentiates 
     * each argument of the operator/function.
     * 
     * Only valid for operators/functions their arguments as direct children.
     * 
     * @param name  what variable to differentiate against - passed on to diff
     * @param exp   the arguments of the operator/function
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:842
     */
    protected FExp diffWrap(String name, FExp... exp) {
        FExp res = createEmptyNode();
        int o = res.argsOffset();
        for (int i = 0; i < exp.length; i++) {
            res.setChild(exp[i].diff(name), i + o);
        }
        return res;
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:865
     */
    public FExp buildDiff(final String name) {
        return diff(name);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:444
     */
    public FExp copySymbolic() { return (FExp) super.copySymbolic(); }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:113
     */
    public java.util.List<FAbstractEquation> extractEventGenEquation() {
        return Collections. <FAbstractEquation> emptyList();
    }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:117
     */
    public java.util.List<FAbstractEquation> extractEventGenInitialEquation() {
        return Collections. <FAbstractEquation> emptyList();
    }
    /**
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:121
     */
    public java.util.List<FStatement> extractEventGenStatement() {
        return Collections. <FStatement> emptyList();
    }
    /**
     * Remove binding expression of variables referenced in this expression.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:231
     */
    public void removeBindingExpOfReferencedVars() {
		for (FExp e : childFExps())
			e.removeBindingExpOfReferencedVars();
	}
    /**
     * Converts this guard expression from a when clause to a guard expression
     * to be used in an if clause.
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:142
     */
    public FExp transformGuard(Collection<FAbstractEquation> outerEqnList, Collection<FStatement> stmtList, FClass fclass) {
        Iterator<FExp> it = guards().iterator();
        FExp res = it.next().asGuard(outerEqnList, stmtList, fclass);
        while (it.hasNext())
            res = new FOrExp(res,it.next().asGuard(outerEqnList, stmtList, fclass));
        return res;
    }
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:149
     */
    public FExp asGuard(Collection<FAbstractEquation> outerEqnList, Collection<FStatement> stmtList, FClass fclass) {
        // We need to extract to temporary equation
        if (stmtList == null || !dependsOn(myFAlgorithm().referencedFVariablesInLHS())) {
            outerEqnList.add(new FEquation(tempUseExp(), fullCopy()));
        } else {
            stmtList.add(new FAssignStmt(tempUseExp(), fullCopy()));
        }
        
        fclass.addFVariable(type().createFVariable(VisibilityType.PUBLIC,
                new FAccessFull(tempVarName()), variability().combine(Variability.DISCRETE)));
        return new FAndExp(tempUseExp(), new FNotExp(tempPreExp()));
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:184
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		open_XML(str, indent);
		for (FExp child : childFExps())
			p.print(child, str, indent2);
		close_XML(str, indent);
	}
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:506
     */
    public void genEventResidualVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        throw new UnsupportedOperationException("Method not implemented for class " + getClass().getSimpleName() + "!");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:530
     */
    public void genEventResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator) {
        throw new UnsupportedOperationException("Method not implemented for class " + getClass().getSimpleName() + "!");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:631
     */
    public void printIndicatorGuard(CodePrinter.StepPrinter sp, CodeStream str, String indent) {
        FExp par = parentFExp();
        if (par != null) {
            par.printIndicatorGuard(sp, str, indent, this);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:638
     */
    public void printIndicatorGuard(CodePrinter.StepPrinter sp, CodeStream str, String indent, FExp e) {
        if (isIndicatorGuard(e)) {
            printIndicatorGuard(sp, str, indent, myIndicatorGuardExp(e), negateIndicatorGuard(e));
        } else {
            printIndicatorGuard(sp, str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:670
     */
    public void printIndicatorGuard(CodePrinter.StepPrinter sp, CodeStream str, String indent, FExp e, boolean not) {
        boolean hb = hasBrancher();
        if (hb) {
            sp.print(str, FAndExp.macro_C);
            sp.print(str, "(");
            printIndicatorGuard(sp, str, indent);
            sp.print(str, ", ");
        }
        
        if (not) {
            sp.print(str, FNotExp.macro_C);
            sp.print(str, "(");
        }
        
        sp.print(e, str, indent);
        
        if (not) {
            sp.print(str, ")");
        }
        
        if (hb) {
            sp.print(str, ")");
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:695
     */
    public void genTimeEventVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        genVarDecls_C(p, str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:704
     */
    public void genTimeEvent_C(CodePrinter p, CodeStream str, String indent, String res) {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:839
     */
    public void genRelExpKind(CodeStream str) {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:298
     */
    public void genForIndexExtraVarDecls_C(CodePrinter p, CodeStream str, String indent, String name) {
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:316
     */
    public void printForIndexInit_C(CodePrinter p, CodeStream str, String indent, String name) {}
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:360
     */
    public void printForIndex_C(CodePrinter p, CodeStream str, String indent, String name) {
        throw new UnsupportedOperationException("C code generation for loop index not implemented for class " + 
                getClass().getSimpleName());
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:409
     */
    public void printForIndexNext_C(CodePrinter p, CodeStream str, String indent, String name) {
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:502
     */
    public void prepExternalArg(CodePrinter p, CodeStream str, String indent, FExternalLanguage lang, boolean writeback, CodeGenContext cgc) {
        String tempName = tempName_C();
        String src = alias_C(p, cgc);
        if (isArray()) {
            MatrixOp op = new MatrixOp(type(), lang, writeback);
            if (writeback)
                op.genMatrixOp(p, str, indent, src, tempName, src);
            else
                op.genMatrixOp(p, str, indent, src, src, tempName);
        } else {
            type().printAssignExt_C(p, str, indent, tempName, src, writeback, true);
        }
    }
    /**
     * Helper, prints jmi guard around an operator
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:420
     */
    protected void prettyPrintGuardedStmt(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent, FExp ... exps) {
        str.print(indent);
        prettyPrintGuarded(p, str, indent, exps);
        str.println(";");
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:425
     */
    protected void prettyPrintGuarded(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent, FExp ... exps) {
        new RuntimeCallComputation(p, "").prettyPrintHead(p, str, indent, this, exps, p.codePrinter().returnArguments(this));
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:502
     */
    public FExp[] returnArguments_C() {
        return new FExp[] {};
    }
    /**
     * Produces statement which writes the string to the variable. This is the
     * default implementation, subclasses may override it.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:794
     */
    public void genStringExpWrite_C(CodePrinter p, CodeStream str, String indent, String dest) {
        str.print(indent, "snprintf(JMI_STR_END(", dest, "), JMI_STR_LEFT(", dest, "), ");
        genStringFormat_C(p, str, indent);
        str.print(", ");
        genStringParts_C(p, str, indent);
        str.println(");");
    }
    /**
     * Computes the maximum length of the produced string. This is the default
     * implementation, subclasses may override it.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:806
     */
    public void genMaxStringLength_C(CodePrinter p, CodeStream str, String indent) {
        str.print("JMI_LEN(");
        p.print(this, str, indent);
        str.print(")");
    }
    /**
     * Computes the format string for this expression. This is the default
     * implementation, subclasses may override it.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:816
     */
    public void genStringFormat_C(CodePrinter p, CodeStream str, String indent) {
        str.print("\"");
        if (type().isString())
            str.print("%s");
        else
            throw new IllegalArgumentException("Trying to use expression '" + toString() + "' in string type expression!");
        str.print("\"");
    }
    /**
     * Helper?
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:923
     */
    public void genTopStringDecl(CodePrinter p, CodeStream str, String indent) {
        if (isTopStringOp()) {
            boolean k = isKnownStringLength();
            str.format("%sJMI_DEF_%s(%s", indent, k ? "STR_STAT" : "STR_DYNA", tempName_C());
            if (k) {
                str.format(", %d", maxStringLength_C());
            }
            str.println(")");
        }
    }
    /**
     * Helper?
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:937
     */
    public void genTopStringInit(CodePrinter p, CodeStream str, String indent) {
        if (isTopStringOp()) {
            boolean k = isKnownStringLength();
            str.format("%sJMI_INI_%s(%s", indent, k ? "STR_STAT" : "STR_DYNA", tempName_C());
            if (!k) {
                str.print(", ");
                genMaxStringLength_C(p, str, indent);
            }
            str.println(")");
            genStringExpWrite_C(p, str, indent, tempName_C());
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:997
     */
    public void genStringParts_C(CodePrinter p, CodeStream str, String indent) {
        // TODO: This method should dispatch to the type!
        FType t = type();
        if (t.isEnum()) {
            str.print(t.enumNames_C());
            str.print("[(int) ");
            p.print(this, str, indent);
            str.print("]");
        } else if (t.isBoolean()) {
            str.print("COND_EXP_EQ(");
            p.print(this, str, indent);
            str.print(", JMI_TRUE, \"true\", \"false\")");
        } else {
            if (t.isInteger())
                str.print("(int) ");
            p.print(this, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1103
     */
    public static final int MAX_STRING_LENGTH_C = 16 * 1024 - 1;
    /**
     * @aspect CCodeGenExternal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:129
     */
    public void genExternalFortranFuncArgs(CodePrinter p, CodeStream str, String indent, CodeGenContext cgc) {
        if (!isArray() && !type().isString()) {
            str.print("&");
        }
        str.print(alias_C(p, cgc));
        if (isArray()) {
            str.print("->var");
        }
    }
    /**
     * @aspect CCodeGenExternal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:139
     */
    public void genExternalCFuncArgs(CodePrinter p, CodeStream str, String indent, CodeGenContext cgc) {
        str.print(alias_C(p, cgc));
        if (isArray()) {
            str.print("->var");
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:47
     */
    public void genTempInputDecl_C(CodePrinter p, CodeStream str, String indent) {
        if (p.needsTemp(this)) {
            p.print(this, indent, type(), p.createDeclPrinter(str));
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:67
     */
    public void genTempInputAssigns_C(CodePrinter p, CodeStream str, String indent) {
        if (p.needsTemp(this)) {
            p.print(this, indent, type(), p.createInitPrinter(str));
            p.printTempInputAssigns(str, indent, this);
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:87
     */
    public void genArgument(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        if (p.codePrinter().needsTemp(this)) {
            str.print(p.name(this));
        } else {
            p.print(this, str, indent);
        }
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:479
     */
    public void genFuncCallCellInOutArg_C(CodeFuncCallInOutArgPrinter p, CodeStream str, String indent, String name) {
        p.endComponent(str, indent);
        p.printCellExp(str, indent, name, this);
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:494
     */
    public void genTempInputCellAssigns_C(CodePrinter p, CodeStream str, String indent, String name) {
        str.print(indent + name + " = ");
        p.print(this, str, indent);
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:446
     */
    public void printCastArgument(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
            str.print(", (", type().type_C(p.codePrinter()),")(");
            genTempArg(p, str, indent);
            str.print(")");
    }
    /**
     * Wraps the name in the JMI_GLOBAL macro which accesses the variable in the global struct rather than the local 
     * namespace.
     * 
     * @param  name Variable name to wrap. It should be declared as a field in the global struct.
     * @return The name wrapped in the JMI_GLOBAL macro
     * @aspect CCodeGenGlobals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:55
     */
    public static String global_C(String name) {
        return "JMI_GLOBAL(" + name + ")";
    }
    /**
     * Generates the name for the computed flag that accompanies cached values
     * @param name The name of the variable that is cached
     * @return Name of the cache flag
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:67
     */
    public static String computed_C(String name) {
        return name + "_computed";
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:334
     */
    public void collectExpsForGlobalVariableInitFunc_C(ArrayList<FExp> list, boolean inArray) {
        if (!type().isExternalObject()) {
            for (FExp arg : childFExps()) {
                arg.collectExpsForGlobalVariableInitFunc_C(list, isArray());
            }
            if (inArray || !isComposite()) {
                return;
            }
        }
        
        list.add(this);
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:350
     */
    public void genGlobalVariableInitHead_C(CodePrinter p, CodeStream str, String indent) {
        String next = p.indent(indent);
        String returnType = typeReturn_C(p);
        str.print(indent, returnType, " jmi_global_", tempName_C(), "(jmi_t* jmi);\n");
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:356
     */
    public CodeSplitter genGlobalVariableInitFunc_C(CodePrinter p, CodeStream str, String indent, 
            final ArrayList<FExp> globals, final int index, CodeSplitter oldSplitter) {
        String next = p.indent(indent);
        final String returnType = typeReturn_C(p);
        
        ArrayList<GlobalVariableArrayElement> elements = new ArrayList<>();
        collectArrayElementsForGenGlobalVariableInitFunc_C(elements);
        
        final CodeSplitter<GlobalVariableArrayElement> splitter = 
                new CodeSplitter<GlobalVariableArrayElement>(p, str, next, true, "jmi_global_" + tempName_C(),
                myFClass().myOptions(), elements) {
            @Override
            protected void printFunctionHeader(int split) {
                str.print("int ", funcName, "_", split, "(jmi_t* jmi, ", returnType, " ", tempName_C(), ")");
            }
            @Override
            protected void genFuncCall(int split) {
                str.print(indent, funcName, "_", split, "(jmi, ", tempName_C(), ");\n");
            }
            @Override
            public void genAtNewFile() {
                for (int i = 0; i < index; i++) {
                    globals.get(i).genGlobalVariableInitHead_C(p, str, "");
                }
            }
            @Override
            public void genDecl(GlobalVariableArrayElement element) {
            }
            @Override
            public void gen(GlobalVariableArrayElement element) {
                element.gen(p, str, indent);
            }
        };
        splitter.setInitialSplit(oldSplitter);
        splitter.genFuncImpls();
        splitter.genFuncHeads();
        str.print(indent, returnType, " jmi_global_", tempName_C(), "(jmi_t* jmi) {\n");
        str.print(next, "JMI_DYNAMIC_INIT()\n");
        genGlobalVariableInitFuncDecl_C(p, str, next);
        str.print(next, "JMI_GLOBALS_INIT()\n");
        genGlobalVariableInitFuncInit_C(p, str, next);
        splitter.genFuncCalls();
        str.print(next, "JMI_GLOBALS_FREE()\n");
        str.print(next, "JMI_DYNAMIC_FREE()\n");
        str.print(next, "return ", tempName_C(), ";\n");
        str.print(indent, "}\n");
        return splitter;
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:405
     */
    public void collectArrayElementsForGenGlobalVariableInitFunc_C(ArrayList<GlobalVariableArrayElement> list) {
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:429
     */
    public void genGlobalVariableInitFuncDecl_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent, type().nameScalar_C(p), " ", tempName_C(), ";\n");
        p.printVarDecls(this, str, indent);
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:434
     */
    public void genGlobalVariableInitFuncInit_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(this, str, indent);
        str.print(indent, tempName_C(), " = ");
        p.print(this, str, indent);
        p.printPostSteps(this, str, indent);
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:481
     */
    public void genGlobalVariableInitCall_C(CodePrinter p, CodeStream str, String indent, String name, boolean expand) {
        if (!isLiteralZero()) {
            str.print(indent, name, " = ");
            p.print(this, str, indent);
            str.print(";\n");
        }
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:514
     */
    public void genDestructorCall_C(CodePrinter p, CodeStream str, String indent, FGlobalVariable v) {
    
    }
    /**
     * @aspect StepPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\StepPrinter.jrag:153
     */
    public void genTempArg(CodePrinter.StepPrinter p, CodeStream str, String indent) {
        p.printIO(this, str, indent);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FExp() {
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
        getDynamicFExpOpt_reset();
        tempName_C_reset();
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
    public FExp clone() throws CloneNotSupportedException {
        FExp node = (FExp) super.clone();
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
    public abstract FExp fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:52
     */
    public abstract FExp treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:60
     */
    public abstract FExp treeCopy();
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460
     */
    private boolean refined_Scalarization_FExp_scalarizeExpanded()
{ return isComposite() && indexNames == null
        && !(inFunction() && myFClass().noUnrollingInFunctions() || size().isUnknown() || inUnknownSize())
        && !(useTempVar && isForIndexExp()); }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public abstract CValue cevalCalc(VariableEvaluator evaluator);
    /**
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:227")
    public int ndims() {
        int ndims_value = 0;
        return ndims_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:306
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:306")
    public int overloadNdims() {
        {
                if (shouldUseOverloadedOperator()) {
                    InstClassDecl oper = overloadedOperator(true);
                    if (oper != null && !oper.myOutputs().isEmpty())
                        return oper.myOutputs().get(0).ndims();
                }
                return ndimsBase();
            }
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:315")
    public int ndimsBase() {
        int ndimsBase_value = -1;
        return ndimsBase_value;
    }
    /**
     * Get the array sizes. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:722
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:722")
    public Size size() {
        Size size_value = Size.SCALAR;
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:728
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:728")
    public Size overloadSize() {
        {
                if (shouldUseOverloadedOperator()) {
                    InstClassDecl oper = overloadedOperator(true);
                    if (oper != null && !oper.myOutputs().isEmpty())
                        return oper.myOutputs().get(0).size();
                }
                return sizeBase();
            }
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:737
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:737")
    public Size sizeBase() {
        Size sizeBase_value = null;
        return sizeBase_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:808
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:808")
    public boolean isIntegerLiteral() {
        boolean isIntegerLiteral_value = false;
        return isIntegerLiteral_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:811
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:811")
    public boolean isIntegerLiteral(int v) {
        boolean isIntegerLiteral_int_value = false;
        return isIntegerLiteral_int_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:814
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:814")
    public boolean isRealLiteral() {
        boolean isRealLiteral_value = false;
        return isRealLiteral_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:817")
    public boolean isRealLiteral(double v) {
        boolean isRealLiteral_double_value = false;
        return isRealLiteral_double_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:820
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:820")
    public boolean isZeroLiteral() {
        boolean isZeroLiteral_value = isIntegerLiteral(0);
        return isZeroLiteral_value;
    }
    /**
     * check if an expression is an array expression.
     * 
     * @return True if array dimension > 0 else false
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1185
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1185")
    public boolean isArray() {
        boolean isArray_value = ndims()>0;
        return isArray_value;
    }
    /**
     * Computes a generic array expansion of the expression.
     * 
     * @return An Array with scalar expressions if this is an array expression, 
     * <code>this</code> otherwise.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1325")
    public Array getArray() {
        Array getArray_value = this;
        return getArray_value;
    }
    /**
     * Computes a generic array expansion of the temporary replacing this expression.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1380
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1380")
    public ArrayExp createTempArray() {
        {
                ArrayExp res = new ArrayExp(indices());
                for (Index i : res.indices()) {
                    res.set(i, tempExp(i));
                }
                return res;
            }
    }
    /**
     * Get the set of all array indices of an array access. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2205
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2205")
    public Indices indices() {
        Indices indices_value = Indices.create(size());
        return indices_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2315")
    public int[] myIndices() {
        {
                try {
                    int n = 0;
                    if (ndims() == 0) {
                        n = 1;
                    } else if (ndims() == 1) {
                        n = size().get(0);
                    }
                    if (n > 0) {
                        CValue arrVal = ceval();
                        if (!arrVal.isUnknown()) {
                            int[] indices = new int[n];
                            int j = 0;
                            for (CValue val : arrVal) {
                                if (!val.hasIntValue()) {
                                    return new int[0];
                                }
                                indices[j++] = val.intValue();
                            }
                            return indices;
                        }
                    }
                } catch (ConstantEvaluationException e) {
                }
                return new int[0];
            }
    }
    /**
     * Try to infer type of an expression from its surrounding Array.
     * 
     * An FExp that is the direct child of an Array always has the same type as the Array, except scalar.
     * 
     * @return  if this expression is in an Array, the inferred type, otherwise type()
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2357
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2357")
    public FType inferType() {
        FType inferType_value = inArray() ? inferredType() : type();
        return inferType_value;
    }
    /**
     * Extract a subcomponent of this record expression. Creates new nodes when necessary.
     * Similar to getArray() for arrays.
     * @attribute syn
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Components", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23")
    public FExp component(String name) {
        FExp component_String_value = dynamicFExp(extractRecordFExp(name));
        return component_String_value;
    }
    /** 
     * Convenience function for savely checking if an expression as a particular value.
     * 
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2039
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2039")
    public boolean equalsRealValue(double val) {
        {
            	try {
            		return variability().lessOrEqual(Variability.CONSTANT) && ceval().realValue()==val;
            	} catch(Exception e) {
            		return false;
            	}
            }
    }
    /**
     * Returns the constant value of a flat expression. 
     * 
     * If the expression is not constant, or if it contains type errors, a 
     * CValueUnknown object is returned.
     * 
     * The actual evaluation of concrete FExp nodes is performed by dispatching
     * with respect to the primitive type of the expression. For example, when an
     * FAddExp node is evaluated, the computation proceeds in the following steps:
     * 
     * - The primitive type of the expression is retreived using the type()
     * attribute.
     * - The method add() defined for FType is invoked.
     * - The resulting CValue is returned. 
     * 
     * Using this strategy, a particular FExp node need not know the details of
     * how to evaluate itself in the case of operands of different types. Rather,
     * these computations are delegated to the respective types. In particular,
     * this design simplifies the task of extending the evaluation framework
     * to composite types such as arrays and complex numbers. In addition
     * the type dispatch makes implementation of support for operator overloading
     * simpler.
     * 
     * Note that function evaluation depends on nothing being cached in constant 
     * evaluation. If caching is later needed, an argument to avoid caching must be 
     * added to cevalCalc() and an alternate ceval() created. Also, the form taking 
     * an Index should then probably be removed.
     * 
     * The VariableEvaluator agrument is only designed to work reliably after
     * scalarization. This is due to that the fact that size, type, array and 
     * some other functions use ceval() without propagation of the evaluator.
     * 
     * @return The constant value of the expression.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2082
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2082")
    public CValue ceval() {
        CValue ceval_value = ceval(defaultVariableEvaluator());
        return ceval_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2084
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2084")
    public CValue ceval(VariableEvaluator evaluator) {
        {
                if (isCircular()) 
                    return CValue.UNKNOWN;
                if (isArray()) {
                    if (size().evaluated().isUnknown())
                        return CValue.UNKNOWN;
                    return cevalArray(evaluator, Index.NULL);
                }
                CValue resOver = cevalOverloaded(evaluator);
                return (resOver != null) ? resOver : cevalCalc(evaluator);
            }
    }
    /**
     * Like {@link #ceval()}, but in the case of an array, only calculate 
     * the given cell, if possible. 
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2100")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        {
                if (isCircular()) 
                    return CValue.UNKNOWN;
                if (isArray())
                    return cevalArray(evaluator, i);
                CValue resOver = cevalOverloaded(evaluator);
                return (resOver != null) ? resOver : cevalCalc(evaluator);
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2110
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2110")
    public Set<String> collectAccessNames() {
        {
                final Set<String> names = new HashSet<>();
                collectAccessNames(names);
                return names;
            }
    }
    /**
     * If this is an overloaded operator expression, evaluate it as such, otherwise return null.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2280
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2280")
    public CValue cevalOverloaded(VariableEvaluator evaluator) {
        {
                if (!shouldUseOverloadedOperator() || operatorName() == null)
                    return null;
                InstClassDecl func = overloadedOperator();
                return (func == null) ? CValue.UNKNOWN : func.evaluateFirst(evaluator, childFExps());
            }
    }
    /**
     * Check if this expression can be constant evaluated.
     * 
     * Calls ceval and checks that no exception is thrown, and that the result isn't unknown.
     * Use only for error checking, since it does not guarantee that the expression can be 
     * evaluated at the moment - only after calculating overconstrained connection graph.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2294
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2294")
    public boolean canCeval() {
        boolean canCeval_value = canCeval(defaultVariableEvaluator());
        return canCeval_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2296
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2296")
    public boolean canCeval(VariableEvaluator evaluator) {
        {
                  try {
                      return !ceval(evaluator).isUnknown();
                } catch (ConstantEvaluationNotReadyException e) {
                  // Will be evaluatable later, ignore for now
                  return true;
                  } catch (Exception e) {
                      return false;
                  }
            }
    }
    /**
     * Constant evaluation for arrays.
     * 
     * @param i  the index of the cell to calculate, 
     * where Index.NULL means to calculate all cells
     * @see #ceval()
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2314")
    public CValue cevalArray(Index i) {
        CValue cevalArray_Index_value = cevalArray(defaultVariableEvaluator(), i);
        return cevalArray_Index_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315")
    public CValue cevalArray(VariableEvaluator evaluator, Index i) {
        {
                CValueArray res = new CValueArray(size());
                if (size().evaluated().isUnknown())
                    return CValue.UNKNOWN;
                Array arr = getArray();
                if (i == Index.NULL)
                  for (Index j : arr.indices())
                      res.setCell(j, arr.get(j).ceval(evaluator));
                else if (size().isOKIndex(i))
                  res.setCell(i, arr.get(i).ceval(evaluator));
                else
                  throw new ConstantEvaluationException();
                return res;
            }
    }
    /**
     * Given that <code>val</code> is the value of this use expression, 
     * extract the part of it referring to <code>fv</code>, 
     * or <code>null</code> if none match. 
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3299")
    public CValue extractCValue(CValue val, FVariable fv) {
        CValue extractCValue_CValue_FVariable_value = null;
        return extractCValue_CValue_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect LiteralExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4601
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LiteralExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4601")
    public boolean hasOnlyLiterals() {
        {
                for (FExp e : childFExps())
                    if (!e.hasOnlyLiterals())
                        return false;
                return true;
            }
    }
    /**
     * Check if expression is circular.
     * 
     * Default implementation returns <code>true</code> if any direct FExp child 
     * is circular.
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4623
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4623")
    public boolean isCircular() {
        boolean isCircular_value = false;
        return isCircular_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633")
    public boolean isCircularCalc() {
        boolean isCircularCalc_value = false;
        return isCircularCalc_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4672
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4672")
    public boolean isUnknownSizeVarUse() {
        boolean isUnknownSizeVarUse_value = false;
        return isUnknownSizeVarUse_value;
    }
    /**
     * Create a negated copy of this expression.
     * @attribute syn
     * @aspect AritmeticTransformations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4776
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AritmeticTransformations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4776")
    public FExp createNegated() {
        FExp createNegated_value = new FNegExp(fullCopy());
        return createNegated_value;
    }
    /**
     * Return this expression negated.
     * 
     * Does not copy expression.
     * @attribute syn
     * @aspect AritmeticTransformations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4789
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AritmeticTransformations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4789")
    public FExp makeNegated() {
        FExp makeNegated_value = new FNegExp(this);
        return makeNegated_value;
    }
    /**
     * Can {@link #makeNegated()} and {@link #createNegated()} do something better 
     * than just wrapping the expression in a FNegExp?
     * @attribute syn
     * @aspect AritmeticTransformations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4812
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AritmeticTransformations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4812")
    public boolean hasSimpleNegation() {
        boolean hasSimpleNegation_value = false;
        return hasSimpleNegation_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:47
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:47")
    public boolean isOutput() {
        boolean isOutput_value = false;
        return isOutput_value;
    }
    /**
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4")
    public Precedence precedence() {
        Precedence precedence_value = Precedence.HIGHEST;
        return precedence_value;
    }
    /**
     * The reason for using parent here is that this attribute is intended to be used by 
     * prettyPrint(), that is in turn used by toString(). Checking if our parent is null lets   
     * us use toString() on expressions that are not yet in the AST without getting a 
     * NullPointerException. This is useful e.g. when debugging. 
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:41
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:41")
    public Precedence parentPrecedence() {
        Precedence parentPrecedence_value = parent != null ? retrieveParentPrecedence() : Precedence.LOWEST;
        return parentPrecedence_value;
    }
    /**
     * Used if precedence is equal for node and its parent.
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:71
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:71")
    public boolean shouldHaveParenthesis() {
        boolean shouldHaveParenthesis_value = parent != null ? retrieveShouldHaveParenthesis() : false;
        return shouldHaveParenthesis_value;
    }
    /**
     * Returns true if this exp should add parenthesis given a certain precedence.
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:90
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:90")
    public boolean addParenthesis(Precedence parentPrecedence) {
        boolean addParenthesis_Precedence_value = precedence().needParenthesis(parentPrecedence, shouldHaveParenthesis());
        return addParenthesis_Precedence_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1573")
    public boolean inDeadIfBranchTest(boolean deadValue) {
        boolean inDeadIfBranchTest_boolean_value = (isConstantExp() && ceval().booleanValue() == deadValue) || inDeadIfBranch();
        return inDeadIfBranchTest_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1919
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1919")
    public int numScalarElements() {
        int numScalarElements_value = type().numScalarElements();
        return numScalarElements_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2033
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2033")
    public int guardExpInEquationsIndex() {
        int guardExpInEquationsIndex_value = myFClass().guardExpInEquations().indexOf(this);
        return guardExpInEquationsIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2034
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2034")
    public int guardExpInInitialEquationsIndex() {
        int guardExpInInitialEquationsIndex_value = myFClass().guardExpInInitialEquations().indexOf(this);
        return guardExpInInitialEquationsIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2065
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2065")
    public ArrayList<FExp> guards() {
        {
                ArrayList<FExp> l = new ArrayList<FExp>();
                l.add(this);
                return l;
            }
    }
    /**
     * Check if an expression will generate an event. Parameters with
     * fixed=false are considered to generate events.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2083
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2083")
    public boolean generatesEvent() {
        boolean generatesEvent_value = generatesEvent(true);
        return generatesEvent_value;
    }
    /**
     * Check if an expression will generate an event.
     * 
     * @param checkInitialParameters  Controls whether parameters with fixed = false should be
     * considered to generate events.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2091
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2091")
    public boolean generatesEvent(boolean checkInitialParameters) {
        boolean generatesEvent_boolean_value = generatesEvent(false, checkInitialParameters);
        return generatesEvent_boolean_value;
    }
    /**
     * Check if an expression will generate an event.
     * 
     * @param ignoreVariability        Controls whether variability should be ignored.
     * @param checkInitialParameters   Controls whether parameters with fixed = false should be
     * considered to generate events.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2100")
    public boolean generatesEvent(boolean ignoreVariability, boolean checkInitialParameters) {
        boolean generatesEvent_boolean_boolean_value = inEventGeneratingLocation() && hasEventGeneratingType() &&
                    (ignoreVariability || hasEventGeneratingVariability(checkInitialParameters)) &&
                    myOptions().getBooleanOption("generate_event_switches");
        return generatesEvent_boolean_boolean_value;
    }
    /**
     * Check if an expression will generate an event.
     * Does not check context further than expressions.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2109
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2109")
    public boolean hasEventGeneratingVariability(boolean checkInitialParameters) {
        boolean hasEventGeneratingVariability_boolean_value = !variability().parameterOrLess() || (checkInitialParameters && variability().initialParameterVariability());
        return hasEventGeneratingVariability_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2112
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2112")
    public boolean inEventGeneratingLocation() {
        boolean inEventGeneratingLocation_value = !inFunction() && !inNoEventExp() && !inSmoothExp(myOptions().getBooleanOption("disable_smooth_events") ? 0 : 1);
        return inEventGeneratingLocation_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114")
    public boolean hasEventGeneratingType() {
        boolean hasEventGeneratingType_value = false;
        return hasEventGeneratingType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2122
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2122")
    public boolean generatesEventInDAE() {
        boolean generatesEventInDAE_value = generatesEventInDAE(originalFExp());
        return generatesEventInDAE_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2125
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2125")
    public boolean generatesEventInDAE(FExp orig) {
        boolean generatesEventInDAE_FExp_value = inEquationSection() && orig==this && generatesEvent(false);
        return generatesEventInDAE_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2412")
    public boolean isIndependentParameterExp() {
        boolean isIndependentParameterExp_value = isConstantExp() && !hasCompositeFunc();
        return isIndependentParameterExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2601
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2601")
    public boolean isInitialGuard() {
        boolean isInitialGuard_value = false;
        return isInitialGuard_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3020
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3020")
    public Set<FVariable> referencedFVariablesInFExp() {
        Set<FVariable> referencedFVariablesInFExp_value = lookupFVariablesInSet(findFAccessExpsInTree());
        return referencedFVariablesInFExp_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3033
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3033")
    public Set<FVariable> referencedParametersInFExp() {
        Set<FVariable> referencedParametersInFExp_value = parametersInSet(referencedFVariablesInFExp());
        return referencedParametersInFExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3135
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3135")
    public boolean isComposite() {
        boolean isComposite_value = isArray() || type().isRecord();
        return isComposite_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223")
    public FExp nominal() {
        FExp nominal_value = FExp.nominalDefault();
        return nominal_value;
    }
    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3331
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3331")
    public boolean containsCommonFunctionCallExp() {
        {
                for (FExp exp : childFExps()) {
                    if (exp.containsCommonFunctionCallExp()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3675
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3675")
    public boolean isLinearParameterExp() {
        boolean isLinearParameterExp_value = isParameterExp();
        return isLinearParameterExp_value;
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3706
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3706")
    public boolean isIndependent(Set<? extends CommonVariableDecl> set) {
        {
                for (FExp e : childFExps()) {
                    if (!e.isIndependent(set)) {
                        return false;
                    }
                }
                return true;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4225
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAlgorithmAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4225")
    public boolean inFAlgorithm() {
        boolean inFAlgorithm_value = myFAlgorithm() != null;
        return inFAlgorithm_value;
    }
    /**
     * Returns the expression stripped of any negations
     * @attribute syn
     * @aspect ExpressionGeneralisation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionGeneralisation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4405")
    public FExp stripNegations() {
        FExp stripNegations_value = this;
        return stripNegations_value;
    }
    /**
     * Check if the expressions is negated
     * @attribute syn
     * @aspect ExpressionGeneralisation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4414
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionGeneralisation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4414")
    public boolean isNegated() {
        boolean isNegated_value = false;
        return isNegated_value;
    }
    /**
     * Return this expression negated if <code>neg</code> is true.
     * @attribute syn
     * @aspect ExpressionGeneralisation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4420
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionGeneralisation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4420")
    public FExp negated(boolean neg) {
        {
                if (neg)
                    return new FNegExp(unboundCopy());
                else
                    return unboundCopy();
            }
    }
    /**
     * Return the maximum numeric value that this expression can take, considering min/max values of variables.
     * 
     * Only implemented for a small subset of expressions:
     * - flat access to Real or Integer
     * - numeric literal
     * - negation
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:252")
    public double maxRealValue() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * Return the minimum numeric value that this expression can take, considering min/max values of variables.
     * 
     * Only implemented for a small subset of expressions:
     * - flat access to Real or Integer
     * - numeric literal
     * - negation
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:264
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:264")
    public double minRealValue() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /*******************
     * FExp       
     * ****************
     * @attribute syn
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:112
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:112")
    public FlatAnnotationProvider asAnnotationProvider() {
        FlatAnnotationProvider asAnnotationProvider_value = null;
        return asAnnotationProvider_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:434")
    public boolean isIdentifier(String name) {
        boolean isIdentifier_String_value = false;
        return isIdentifier_String_value;
    }
    /**
     * Get the number of scalar variables assigned by this a FFunctionCallLeft with this 
     * FExp as its expression.
     * 
     * Only valid after scalarization.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1503
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1503")
    public int numScalarVars() {
        int numScalarVars_value = 1;
        return numScalarVars_value;
    }
    /**
     * Get the name this expression should use for temporary variable.
     * 
     * Uses custom caching to avoid flushing.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1551
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1551")
    public String tempVarName() {
        {
                 if (myTempVarName == null)
                     myTempVarName = calcTempVarName();
                 return myTempVarName;
             }
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1564
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1564")
    public String calcTempVarName() {
        String calcTempVarName_value = calcGeneratedVarName(FlatVariableMap.GeneratedVarType.TEMP);
        return calcTempVarName_value;
    }
    /**
     * Creates expressions based on tempVarName();
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1582
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1582")
    public FAccessExp tempUseExp() {
        FAccessExp tempUseExp_value = new FAccessExp(tempVarName());
        return tempUseExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1583")
    public FPreExp tempPreExp() {
        FPreExp tempPreExp_value = new FPreExp(new FAccessString(tempVarName()));
        return tempPreExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1584
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1584")
    public FVariable tempVar() {
        FVariable tempVar_value = tempVar(variability(), type());
        return tempVar_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1585
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1585")
    public FVariable tempVar(TypePrefixVariability variability, FType type) {
        FVariable tempVar_TypePrefixVariability_FType_value = type.createTempFVariable(new FAccessFull(tempVarName()), variability);
        return tempVar_TypePrefixVariability_FType_value;
    }
    /**
     * Is this expression of a type that is valid for most uses?
     * 
     * Only dummy expressions and similar return false.
     * @attribute syn
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1842
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1842")
    public boolean isValidExp() {
        boolean isValidExp_value = isValidExp(false);
        return isValidExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1844
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1844")
    public boolean isValidExp(boolean allowUnknownSize) {
        boolean isValidExp_boolean_value = true;
        return isValidExp_boolean_value;
    }
    /**
     * Counts the total number of FExp nodes in this ASTNode.
     * @attribute syn
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1853
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1853")
    public int numFExp() {
        {
                return super.numFExp() + 1;
            }
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:251
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:251")
    public FExp createFirstIndexExp() {
        {
                FArraySubscripts fas = new FArrayLitSubscripts();
                fas.addFSubscript(1);
                return new FSubscriptedExp(treeCopy(), fas);
            }
    }
    /**
     * @attribute syn
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:580
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SizesUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:580")
    public FExp cell(Index i) {
        FExp cell_Index_value = i.ndims() > 0 && ndims() > 0 ? getArray().get(i) : this;
        return cell_Index_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:224
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:224")
    public boolean isConstructorTypeArg() {
        boolean isConstructorTypeArg_value = false;
        return isConstructorTypeArg_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:318
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:318")
    public FType type() {
        FType type_value = fUnknownType();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:594
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:594")
    public boolean isOKTestExp() {
        boolean isOKTestExp_value = type().isBoolean() && type().isScalar();
        return isOKTestExp_value;
    }
    /**
     * Check if this FExp is on the form "exp for i in exp".
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:652
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:652")
    public boolean isIterExp() {
        boolean isIterExp_value = false;
        return isIterExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:685
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:685")
    public boolean isNoExp() {
        boolean isNoExp_value = false;
        return isNoExp_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500")
    public boolean isConstructorCall() {
        boolean isConstructorCall_value = false;
        return isConstructorCall_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1503
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1503")
    public boolean isDestructorCall() {
        boolean isDestructorCall_value = false;
        return isDestructorCall_value;
    }
    /**
     * If this is an flat tree access, return set containing accessed var, otherwise empty set.
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:402
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:402")
    public FAbstractVariable assignedFV() {
        FAbstractVariable assignedFV_value = null;
        return assignedFV_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:412")
    public boolean isConstantExp() {
        boolean isConstantExp_value = variability().constantVariability();
        return isConstantExp_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:413
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:413")
    public boolean isParameterExp() {
        boolean isParameterExp_value = variability().parameterVariability();
        return isParameterExp_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:414
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:414")
    public boolean isDiscreteExp() {
        boolean isDiscreteExp_value = variability().discreteVariability();
        return isDiscreteExp_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:415
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:415")
    public boolean isContinuousExp() {
        boolean isContinuousExp_value = variability().continuousVariability();
        return isContinuousExp_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:420
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:420")
    public boolean inDiscreteLocation() {
        boolean inDiscreteLocation_value = inWhen() || (inFunction() && !duringFunctionInlining());
        return inDiscreteLocation_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:422
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:422")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = expVariability();
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = combineFExpListVariability(childFExps());
        return expVariability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:428")
    public TypePrefixVariability variabilityInNoEventExp() {
        TypePrefixVariability variabilityInNoEventExp_value = variabilityInNoEventExp(combineFExpListVariability(childFExps()));
        return variabilityInNoEventExp_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:430
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:430")
    public TypePrefixVariability variabilityInNoEventExp(TypePrefixVariability var) {
        TypePrefixVariability variabilityInNoEventExp_TypePrefixVariability_value = inNoEventExp() ? var : var.combineDown(Variability.DISCRETE);
        return variabilityInNoEventExp_TypePrefixVariability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:688
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:688")
    public TypePrefixVariability indexVariability() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * If this is an instance tree access, return set containing accessed var, otherwise empty set.
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:564
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:564")
    public Set<InstComponentDecl> accessedVarSet() {
        Set<InstComponentDecl> accessedVarSet_value = Collections.emptySet();
        return accessedVarSet_value;
    }
    /**
     * @attribute syn
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:471
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:471")
    public boolean lockable(boolean then) {
        {
                if (variability().fixedParameterOrLess()) {
                    try {
                        CValue val = ceval();
                        return val.hasBooleanValue() && val.booleanValue() != then;
                    } catch (ConstantEvaluationException e) {}
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:489
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:489")
    public boolean generateTypeError() {
        boolean generateTypeError_value = type().isUnknown();
        return generateTypeError_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:518
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:518")
    public boolean errorCheckUnknownSize() {
        boolean errorCheckUnknownSize_value = !inFunction() && !allowUnknownSize();
        return errorCheckUnknownSize_value;
    }
    /**
     * Check if type error is only in array lengths.
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:653
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:653")
    public boolean typeErrorOnlyLengths() {
        boolean typeErrorOnlyLengths_value = typeErrorOnlyLengths(childFExps());
        return typeErrorOnlyLengths_value;
    }
    /**
     * Check if type error is only in array lengths.
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:659
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:659")
    public boolean typeErrorOnlyLengths(Iterable<FExp> exps) {
        {
                FType first = null;
                for (FExp exp : exps) {
                    FType cur = exp.type();
                    if (first == null) {
                        first = cur;
                    } else if (!first.equivalentExceptLengths(cur)) {
                        return false;
                    }
                }
                return true;
            }
    }
    /**
     * Returns true if this expression can be interpreted as some form of Access
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:885
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:885")
    public boolean isAccessLikeExp() {
        boolean isAccessLikeExp_value = false;
        return isAccessLikeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:888")
    public boolean isAccess() {
        boolean isAccess_value = false;
        return isAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:890
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:890")
    public CommonAccess asCommonAccess() {
        {
        	  throw new UnsupportedOperationException("asCommonAccess() is not supported for class type " + getClass().getSimpleName());
          }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:895
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:895")
    public CommonAccessExp asCommonAccessExp() {
        {
              throw new UnsupportedOperationException("asCommonAccessExp() is not supported for class type " + getClass().getSimpleName());
          }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:900
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:900")
    public FAccessExp asFAccessExp() {
        {
              throw new UnsupportedOperationException("asFAccessExp() is not supported for class type " + getClass().getSimpleName());
          }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:910
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:910")
    public InstAccess asInstAccess() {
        {
        		throw new UnsupportedOperationException();
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:920
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:920")
    public boolean isAccessToStream() {
        boolean isAccessToStream_value = false;
        return isAccessToStream_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1100")
    public boolean canBeComponentSize() {
        boolean canBeComponentSize_value = type().isInteger();
        return canBeComponentSize_value;
    }
    /**
     * Check if this expression is a reference to a component matching specified criteria.
     * 
     * Only valid in instance tree.
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1781
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1781")
    public boolean isComponentReference(Criteria<InstComponentDecl> criteria) {
        boolean isComponentReference_Criteria_InstComponentDecl__value = false;
        return isComponentReference_Criteria_InstComponentDecl__value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:97
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:97")
    public boolean needsLaterInStreamRewrite() {
        boolean needsLaterInStreamRewrite_value = false;
        return needsLaterInStreamRewrite_value;
    }
    /**
     * Check if this expression is an access to v or a multiplication where one of the 
     * multiplicands is an access to v.
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:344")
    public boolean isMultiplicationOf(FVariable v) {
        boolean isMultiplicationOf_FVariable_value = false;
        return isMultiplicationOf_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect Cardinality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Cardinality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3223")
    public int cardinalityValue() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * \Return the expression corresponding to the given index in this array expression. 
     * 
     * Will not create new nodes unless necessary.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1850
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1850")
    public FExp splitArrayExp(Index index) {
        {
                FExp res = this;
                for (int i : index.index())
                    res = res.splitArrayExp(i);
                return res;
            }
    }
    /**
     * Return the expression corresponding to the given index in this array expression. 
     * 
     * Will not create new nodes unless necessary.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862")
    public FExp splitArrayExp(int index) {
        FExp splitArrayExp_int_value = new FSubscriptedExp(unboundCopy(), index, ndims());
        return splitArrayExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:84
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:84")
    public boolean isNonVectorizedFunctionCall() {
        boolean isNonVectorizedFunctionCall_value = false;
        return isNonVectorizedFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:492
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:492")
    public int argsOffset() {
        int argsOffset_value = 0;
        return argsOffset_value;
    }
    /** @apilevel internal */
    private void getDynamicFExpOpt_reset() {
        getDynamicFExpOpt_computed = false;
        
        getDynamicFExpOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getDynamicFExpOpt_computed = false;

    /** @apilevel internal */
    protected Opt getDynamicFExpOpt_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:853
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:853")
    public Opt getDynamicFExpOpt() {
        ASTState state = state();
        if (getDynamicFExpOpt_computed) {
            return getDynamicFExpOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getDynamicFExpOpt_value = new DynamicOpt();
        getDynamicFExpOpt_value.setParent(this);
        getDynamicFExpOpt_value.is$Final = true;
        if (true) {
        getDynamicFExpOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getDynamicFExpOpt_value;
    }
    /**
     * The name of the operator to use for expressions of this type containing overloaded operators.
     * @attribute syn
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:84
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OperatorRecordTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:84")
    public String operatorName() {
        String operatorName_value = null;
        return operatorName_value;
    }
    /**
     * Check if this expression should use an overloaded operator.
     * 
     * Returns <code>true</code> for binary and unary expressions if any FExp child is of operator record type.
     * Note that this might return <code>true</code> for an expression that has <code>operatorName() == null</code>.
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:175
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:175")
    public boolean shouldUseOverloadedOperator() {
        boolean shouldUseOverloadedOperator_value = false;
        return shouldUseOverloadedOperator_value;
    }
    /**
     * Calculate the function to use for this operator expression involving operator records.
     * 
     * Returns null if none or more than one function matches or if this is not an operator record expression.
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:184")
    public InstClassDecl overloadedOperator() {
        InstClassDecl overloadedOperator_value = null;
        return overloadedOperator_value;
    }
    /**
     * Calculate the function to use for this operator expression involving operator records, 
     * given knowledge on whether array handling should be done by the operator or by the normal rules.
     * 
     * Returns null if none or more than one function matches or if this is not an operator record expression.
     * 
     * @param useSize  if <code>false</code>, try to match a function with scalar inputs, ignoring operand sizes
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:196")
    public InstClassDecl overloadedOperator(boolean useSize) {
        InstClassDecl overloadedOperator_boolean_value = null;
        return overloadedOperator_boolean_value;
    }
    /**
     * Calculate the function to use for this operator expression involving operator records.
     * 
     * Returns null if none or more than one function matches.
     * 
     * @param left   the type of the left operand
     * @param right  the type of the right operand for binary operators, and <code>null</code> for unary operators
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:208
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:208")
    public InstClassDecl overloadedOperatorFor(FType left, FType right) {
        {
                String operator = operatorName();
                InstClassDecl func = overloadedOperatorFor(left, right, true);
                if (func == null && (left.isArray() || (right != null && right.isArray())))
                    func = overloadedOperatorFor(left, right, false);
                return func;
            }
    }
    /**
     * Calculate the function to use for this operator expression involving operator records, 
     * given knowledge on whether array handling should be done by the operator or by the normal rules.
     * 
     * Returns null if none or more than one function matches.
     * 
     * @param left     the type of the left operand
     * @param right    the type of the right operand for binary operators, and <code>null</code> for unary operators
     * @param useSize  if <code>false</code>, try to match a function with scalar inputs, ignoring operand sizes
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:226
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:226")
    public InstClassDecl overloadedOperatorFor(FType left, FType right, boolean useSize) {
        {
                String operator = operatorName();
                if (!useSize) {
                    left = left.scalarType();
                    right = right == null ? null : right.scalarType();
                }
                return left.matchOverloadedOperator(right, operator);
            }
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = type().shouldBeDifferentiated() && 
                    (inFunction() || isContinuousExp());
        return shouldBeDifferentiated_value;
    }
    /**
     * If this is an access, try to look it up as a class, otherwise return null.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:142
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:142")
    public InstLookupResult<InstClassDecl> lookupInstClassIfAccess() {
        InstLookupResult<InstClassDecl> lookupInstClassIfAccess_value = null;
        return lookupInstClassIfAccess_value;
    }
    /**
     * If this is an access, try to look it up as a component, otherwise return null.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:166
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:166")
    public InstLookupResult<InstComponentDecl> lookupInstComponentIfAccess() {
        InstLookupResult<InstComponentDecl> lookupInstComponentIfAccess_value = null;
        return lookupInstComponentIfAccess_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970")
    public boolean isAnnotationExp() {
        boolean isAnnotationExp_value = false;
        return isAnnotationExp_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978")
    public Iterable<? extends ASTNode> annotationList() {
        Iterable<? extends ASTNode> annotationList_value = new ArrayList<ASTNode>(0);
        return annotationList_value;
    }
    /**
     * Check if this is a slice operation.
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1110
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1110")
    public boolean isSlice() {
        boolean isSlice_value = true;
        return isSlice_value;
    }
    /**
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1140")
    public boolean isSliceFAS(Size size) {
        boolean isSliceFAS_Size_value = true;
        return isSliceFAS_Size_value;
    }
    /**
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1150")
    public boolean isLiteral(int i) {
        boolean isLiteral_int_value = false;
        return isLiteral_int_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1574
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1574")
    public boolean isZeroFlowForm(FExp other) {
        boolean isZeroFlowForm_FExp_value = false;
        return isZeroFlowForm_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1620
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1620")
    public boolean isSemiLinear() {
        boolean isSemiLinear_value = false;
        return isSemiLinear_value;
    }
    /**
     * Checks if this expression allows a semiLinear() with it as argument to be smooth(0, ...).
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1636
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1636")
    public boolean isSmoothInSemiLinear() {
        boolean isSmoothInSemiLinear_value = false;
        return isSmoothInSemiLinear_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:159")
    public boolean canBeAlias() {
        boolean canBeAlias_value = false;
        return canBeAlias_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:170")
    public int aliasSign() {
        int aliasSign_value = 1;
        return aliasSign_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:173
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:173")
    public FVariable variableThatCanBeAlias() {
        FVariable variableThatCanBeAlias_value = null;
        return variableThatCanBeAlias_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:184")
    public boolean isLiteralExp() {
        boolean isLiteralExp_value = false;
        return isLiteralExp_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:554
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:554")
    public boolean isOkInlineTemporaries() {
        boolean isOkInlineTemporaries_value = false;
        return isOkInlineTemporaries_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:560
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:560")
    public boolean isTempAccess() {
        boolean isTempAccess_value = false;
        return isTempAccess_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:633")
    public FAccessExp getEquationLeftInlineUse() {
        FAccessExp getEquationLeftInlineUse_value = null;
        return getEquationLeftInlineUse_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1049
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeRewriting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1049")
    public boolean isDerAccess() {
        boolean isDerAccess_value = false;
        return isDerAccess_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1052
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeRewriting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1052")
    public boolean isAbstractDerAccess() {
        boolean isAbstractDerAccess_value = false;
        return isAbstractDerAccess_value;
    }
    /**
     * Check if this expression generates events.
     * 
     * Does not consider subexpressions.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:668
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:668")
    public boolean eventGenerating() {
        boolean eventGenerating_value = false;
        return eventGenerating_value;
    }
    /**
     * Check if this expression or any subexpressions can cause events. 
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:677")
    public boolean generatesEvents() {
        {
                if (eventGenerating())
                    return true;
                for (FExp e : childFExps())
                    if (e.generatesEvents())
                        return true;
                return false;
            }
    }
    /**
     * Check if an expression contains any calls to functions that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:748
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:748")
    public boolean hasInlinableFunctions(AbstractFunctionInliner fi) {
        {
                for (FExp exp : childFExps())
                    if (exp.hasInlinableFunctions(fi))
                        return true;
                return false;
            }
    }
    /**
     * Check if an expression is a call to a function that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:806
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:806")
    public boolean isInlinableFunctionCall(AbstractFunctionInliner fi) {
        boolean isInlinableFunctionCall_AbstractFunctionInliner_value = false;
        return isInlinableFunctionCall_AbstractFunctionInliner_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:410
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:410")
    public int coeff() {
        int coeff_value = myCoeff() * outerCoeff();
        return coeff_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:412")
    public int myCoeff() {
        int myCoeff_value = 1;
        return myCoeff_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:450
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:450")
    public String myCoeffKey() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:467
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:467")
    public boolean isSimpleLinearExp() {
        boolean isSimpleLinearExp_value = false;
        return isSimpleLinearExp_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:485
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:485")
    public boolean isSimpleAlias() {
        boolean isSimpleAlias_value = false;
        return isSimpleAlias_value;
    }
    /**
     * Checks if left hand side variable(s) is eligible for var. prop.
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:65")
    public boolean canPropagate() {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:887
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:887")
    public FTempAccessExp tempExp() {
        FTempAccessExp tempExp_value = tempExp(indexNames);
        return tempExp_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:888")
    public FTempAccessExp tempExp(String name) {
        FTempAccessExp tempExp_String_value = tempExp(name, (FArraySubscripts)null);
        return tempExp_String_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:889
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:889")
    public FTempAccessExp tempExp(Index i) {
        FTempAccessExp tempExp_Index_value = tempExp(tempVarName(), i);
        return tempExp_Index_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:890
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:890")
    public FTempAccessExp tempExp(FArraySubscripts fas) {
        FTempAccessExp tempExp_FArraySubscripts_value = tempExp(tempVarName(), fas);
        return tempExp_FArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:891
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:891")
    public FTempAccessExp tempExp(FExp[] subs) {
        {
                FArraySubscripts fas = null;
                if (subs != null && subs.length > 0) {
                    List<FSubscript> l = new List<FSubscript>();
                    for (FExp e : subs) {
                        l.add(e.treeCopy().createFSubscript());
                    }
                    fas = new FArrayExpSubscripts(l);
                }
                return tempExp(tempVarName(), fas);
            }
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1438
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1438")
    public boolean useTempVar() {
        boolean useTempVar_value = useTempVar;
        return useTempVar_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460")
    public boolean scalarizeExpanded() {
        boolean scalarizeExpanded_value = duringFunctionInlining() ? isComposite() : refined_Scalarization_FExp_scalarizeExpanded();
        return scalarizeExpanded_value;
    }
    /**
     * Should this expression be extracted into its own statement?
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:65")
    public boolean extractTemp() {
        boolean extractTemp_value = (inFunction() && myFClass().noUnrollingInFunctions() || extractAsUnknown())
                    && isComposite() && isFunctionCallIO() || extractForIndexTemp();
        return extractTemp_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:96
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:96")
    public boolean extractForIndexTemp() {
        boolean extractForIndexTemp_value = isForIndexExp();
        return extractForIndexTemp_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:102")
    public boolean extractTempArrayCon() {
        boolean extractTempArrayCon_value = (inFunction() && myFClass().noUnrollingInFunctions() && isArray()) || isForIndexExp()
                    || size().isUnknown() || inUnknownSize();
        return extractTempArrayCon_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:106")
    public boolean extractAsUnknown() {
        boolean extractAsUnknown_value = size().isUnknown();
        return extractAsUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:152
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:152")
    public Set<FAbstractVariable> usesInScalarizedExp() {
        {
                Set<FAbstractVariable> res = new HashSet<FAbstractVariable>();
                usesInScalarizedExp(res);
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:559
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Derivatives", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:559")
    public FExp createDerExp(int order) {
        FExp createDerExp_int_value = diff(TIME, order);
        return createDerExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:236
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:236")
    public ArrayList<FExp> terms() {
        {
                ArrayList<FExp> t = new ArrayList<FExp>();
                t.add(this);
                return t;
            }
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:263")
    public ArrayList<FExp> factors() {
        {
        		ArrayList<FExp> t = new ArrayList<FExp>();
        		t.add(this);
        		return t;
        	}
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:305
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:305")
    public int isMulTerm(String name) {
        int isMulTerm_String_value = 0;
        return isMulTerm_String_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:316
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:316")
    public boolean isDivTerm(String name) {
        boolean isDivTerm_String_value = false;
        return isDivTerm_String_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:325")
    public boolean isNegTerm(String name) {
        boolean isNegTerm_String_value = false;
        return isNegTerm_String_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:359
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:359")
    public FExp originalFExp() {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * Is this expression a literal zero?
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:454
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:454")
    public boolean isLiteralZero() {
        boolean isLiteralZero_value = false;
        return isLiteralZero_value;
    }
    /**
     * Is this expression a literal one?
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:465
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:465")
    public boolean isLiteralOne() {
        boolean isLiteralOne_value = false;
        return isLiteralOne_value;
    }
    /**
     * Is this expression a literal minus one?
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:474
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:474")
    public boolean isLiteralMinusOne() {
        boolean isLiteralMinusOne_value = false;
        return isLiteralMinusOne_value;
    }
    /**
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:521
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:521")
    public boolean needsNoEvent() {
        boolean needsNoEvent_value = true;
        return needsNoEvent_value;
    }
    /**
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:529
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:529")
    public boolean needsSmooth() {
        boolean needsSmooth_value = true;
        return needsSmooth_value;
    }
    /**
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:538
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:538")
    public boolean equalsSymbolic(FExp other) {
        {
                return super.equals(other);
            }
    }
    /**
     * @attribute syn
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:221
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExtractEventGeneratingExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:221")
    public FExp eventTempExpUse() {
        FExp eventTempExpUse_value = null;
        return eventTempExpUse_value;
    }
    /**
     * @attribute syn
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:226
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExtractEventGeneratingExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:226")
    public FExp eventTempExpCalc() {
        FExp eventTempExpCalc_value = null;
        return eventTempExpCalc_value;
    }
    /**
     * Checks whether or not an expression depends on any variable in a collection of them.
     * 
     * @param fvs
     * The {@link FVariable}s to which to check for dependency.
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:608
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:608")
    public boolean dependsOn(Collection<FVariable> fvs) {
        {
                for (FVariable fv : lookupFVariablesInSet(findFAccessExpsInTree())) {
                    if (fvs.contains(fv)) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * Test if this is a use of a parameter (in the flat tree).
     * @attribute syn
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterSorting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:260")
    public boolean isFlatParameterUse() {
        boolean isFlatParameterUse_value = false;
        return isFlatParameterUse_value;
    }
    /**
     * Should this guard expression be extracted into a temp variable?
     * @attribute syn
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="WhenClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:114")
    public boolean shouldExtractGuard() {
        boolean shouldExtractGuard_value = true;
        return shouldExtractGuard_value;
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:250")
    public boolean isIgnoredXML() {
        boolean isIgnoredXML_value = false;
        return isIgnoredXML_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Unsupported";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = "exp";
        return xmlNamespace_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:646
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:646")
    public boolean isIndicatorGuard(FExp e) {
        boolean isIndicatorGuard_FExp_value = false;
        return isIndicatorGuard_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:650
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:650")
    public FExp myIndicatorGuardExp(FExp e) {
        FExp myIndicatorGuardExp_FExp_value = null;
        return myIndicatorGuardExp_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:654
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:654")
    public boolean negateIndicatorGuard(FExp e) {
        boolean negateIndicatorGuard_FExp_value = false;
        return negateIndicatorGuard_FExp_value;
    }
    /**
     * Helper method which returns true if this expression is of the type 
     * FSampleExp.
     * @attribute syn
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:231
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenBlocks", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:231")
    public boolean isFSampleExp() {
        boolean isFSampleExp_value = false;
        return isFSampleExp_value;
    }
    /**
     * Helper, returns the specific part of the C guard function
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:461
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:461")
    public String guardedFunctionName_C() {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:611
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:611")
    public boolean needsScaling() {
        boolean needsScaling_value = type().isReal() && myOptions().getBooleanOption("enable_variable_scaling") && !inFunction();
        return needsScaling_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062")
    public boolean isKnownStringLength() {
        boolean isKnownStringLength_value = variability().knownParameterOrLess();
        return isKnownStringLength_value;
    }
    /**
     * The maximum length string the representation of the value of this expression can have in C.
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1071
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1071")
    public int maxStringLength_C() {
        { 
                if (type().isString())
                    return MAX_STRING_LENGTH_C;
                else
                    throw new IllegalArgumentException("Trying to use expression '" + toString() + "' in string type expression!");
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278")
    public boolean needsTemp_C() {
        boolean needsTemp_C_value = isComposite();
        return needsTemp_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583")
    public FAccessExp first() {
        FAccessExp first_value = null;
        return first_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1589
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1589")
    public FAbstractVariable consecutiveArray(FAbstractVariable last) {
        FAbstractVariable consecutiveArray_FAbstractVariable_value = null;
        return consecutiveArray_FAbstractVariable_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:42
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:42")
    public boolean extShouldArgConvert(boolean fortran, boolean ceval) {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:126
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternal.jrag:126")
    public boolean isExternalArgumentRef(boolean fortran) {
        boolean isExternalArgumentRef_boolean_value = fortran && !type().isArgTypeBaseRef() || isArray();
        return isExternalArgumentRef_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:258")
    public ExternalArgument externalArgument() {
        ExternalArgument externalArgument_value = this;
        return externalArgument_value;
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:434")
    public FExp fArrayCell(Index i, int d) {
        FExp fArrayCell_Index_int_value = cell(i);
        return fArrayCell_Index_int_value;
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:455")
    public boolean genAssignMacro() {
        boolean genAssignMacro_value = false;
        return genAssignMacro_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenGlobalVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:426")
    public int numScalarsGlobals_C() {
        int numScalarsGlobals_C_value = isLiteralZero() ? 0 : 1;
        return numScalarsGlobals_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:27
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:27")
    public String name_C() {
        String name_C_value = tempName_C();
        return name_C_value;
    }
    /** @apilevel internal */
    private void tempName_C_reset() {
        tempName_C_computed = false;
        
        tempName_C_value = null;
    }
    /** @apilevel internal */
    protected boolean tempName_C_computed = false;

    /** @apilevel internal */
    protected String tempName_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:43")
    public String tempName_C() {
        ASTState state = state();
        if (tempName_C_computed) {
            return tempName_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        tempName_C_value = nextTempName_C();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        tempName_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return tempName_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:26
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:26")
    public String typeReturn_C(CodePrinter p) {
        {
                String type = isArray() ? type().nameArray_C(p) : type().nameScalar_C(p);
                if (!type().isExternalObject()) {
                    type = type + "*";
                }
                return type;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:77")
    public String argType_C(CodePrinter p, boolean ref) {
        String argType_C_CodePrinter_boolean_value = type().argType_C(p, ref);
        return argType_C_CodePrinter_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:157")
    public FExp myBackingFExp() {
        FExp myBackingFExp_value = this;
        return myBackingFExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:161
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:161")
    public boolean useAlias_C() {
        boolean useAlias_C_value = false;
        return useAlias_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:165
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:165")
    public String alias_C(CodePrinter p) {
        {
                return alias_C(p, myCodeGenContext());
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:169
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:169")
    public String alias_C(CodePrinter p, CodeGenContext cgc) {
        {
                String res = cgc.alias(this);
                if (res == null) {
                    res = prettyPrint_C();
                }
                return res;
            }
    }
    /**
     * Returns this expression as A MXVector. 
     * @return A MXVector
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:271")
    public MXVector toMXVector() {
        {
                MXVector MXVec = new MXVector();
                MXVec.add(toMX());
                return MXVec;
            }
    }
    /**
     * Returns this expression as A MX. Note that this might
     * not make sense for some expressions, e.g. function calls with
     * several outputs and FAccessExp for FFunctionArray.
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:282")
    public MX toMX() {
        {
                throw new UnsupportedOperationException("Cannot convert expression to MX: " + toString());
            }
    }
    /**
     * Check if an expression is inside array subscripts.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:31
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:31")
    public boolean inArraySubscripts() {
        boolean inArraySubscripts_value = getParent().Define_inArraySubscripts(this, null);
        return inArraySubscripts_value;
    }
    /**
     * Check if this expression is inside an iteration expression.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898")
    public boolean inIterExp() {
        boolean inIterExp_value = getParent().Define_inIterExp(this, null);
        return inIterExp_value;
    }
    /**
     * Return a size that represents the given size with sizes of surrounding iteration expressions appended.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906")
    public Size expandSizeForIterExp(Size s) {
        Size expandSizeForIterExp_Size_value = getParent().Define_expandSizeForIterExp(this, null, s);
        return expandSizeForIterExp_Size_value;
    }
    /**
     * Check if this expression is the direct child of an Array.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362")
    public boolean inArray() {
        boolean inArray_value = getParent().Define_inArray(this, null);
        return inArray_value;
    }
    /**
     * Helper attribute to {@link FExp#inferType()}.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371")
    public FType inferredType() {
        FType inferredType_value = getParent().Define_inferredType(this, null);
        return inferredType_value;
    }
    /**
     * Check if this node is in a function that is being evaluated.
     * @attribute inh
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3426")
    public boolean duringFunctionEval() {
        boolean duringFunctionEval_value = getParent().Define_duringFunctionEval(this, null);
        return duringFunctionEval_value;
    }
    /**
     * @attribute inh
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:46")
    public Precedence retrieveParentPrecedence() {
        Precedence retrieveParentPrecedence_value = getParent().Define_retrieveParentPrecedence(this, null);
        return retrieveParentPrecedence_value;
    }
    /**
     * @attribute inh
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:77")
    public boolean retrieveShouldHaveParenthesis() {
        boolean retrieveShouldHaveParenthesis_value = getParent().Define_retrieveShouldHaveParenthesis(this, null);
        return retrieveShouldHaveParenthesis_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565")
    public boolean inDeadIfBranch() {
        boolean inDeadIfBranch_value = getParent().Define_inDeadIfBranch(this, null);
        return inDeadIfBranch_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2170")
    public FStatement myFStatement() {
        FStatement myFStatement_value = getParent().Define_myFStatement(this, null);
        return myFStatement_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259")
    public Set<FVariable> boundParameters() {
        Set<FVariable> boundParameters_value = getParent().Define_boundParameters(this, null);
        return boundParameters_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2305
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2305")
    public boolean inFEquation() {
        boolean inFEquation_value = getParent().Define_inFEquation(this, null);
        return inFEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2309
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2309")
    public FAbstractEquation myFEquation() {
        FAbstractEquation myFEquation_value = getParent().Define_myFEquation(this, null);
        return myFEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2315")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3189
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3189")
    public FRecordDecl containingRecordDecl() {
        FRecordDecl containingRecordDecl_value = getParent().Define_containingRecordDecl(this, null);
        return containingRecordDecl_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306")
    public boolean inFunctionCallLeft() {
        boolean inFunctionCallLeft_value = getParent().Define_inFunctionCallLeft(this, null);
        return inFunctionCallLeft_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311")
    public boolean isFunctionCallLeft() {
        boolean isFunctionCallLeft_value = getParent().Define_isFunctionCallLeft(this, null);
        return isFunctionCallLeft_value;
    }
    /**
     * Checks if this expression is used in a function call
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3320
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3320")
    public boolean inFunctionCall() {
        boolean inFunctionCall_value = getParent().Define_inFunctionCall(this, null);
        return inFunctionCall_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325")
    public boolean isFunctionCallArg() {
        boolean isFunctionCallArg_value = getParent().Define_isFunctionCallArg(this, null);
        return isFunctionCallArg_value;
    }
    /**
     * Returnes the function input that this expressions corresponds to.
     * NOTICE, this method will throw exception if this exp does not reside in a function call.
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345")
    public CommonVariableDecl myCorrespondingInput() {
        CommonVariableDecl myCorrespondingInput_value = getParent().Define_myCorrespondingInput(this, null);
        return myCorrespondingInput_value;
    }
    /**
     * Check if this is the left hand side of an equation.
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358")
    public boolean isLeftHandSide() {
        boolean isLeftHandSide_value = getParent().Define_isLeftHandSide(this, null);
        return isLeftHandSide_value;
    }
    /**
     * Check if this is exp is bound in a declaration
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378")
    public boolean isBound() {
        boolean isBound_value = getParent().Define_isBound(this, null);
        return isBound_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3383
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3383")
    public boolean inParamBindingExp() {
        boolean inParamBindingExp_value = getParent().Define_inParamBindingExp(this, null);
        return inParamBindingExp_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387")
    public TypePrefixVariability bindingExpVariability() {
        TypePrefixVariability bindingExpVariability_value = getParent().Define_bindingExpVariability(this, null);
        return bindingExpVariability_value;
    }
    /**
     * Check if a subexpression appears linearly.
     * 
     * Note that this method does not check if the expression itself is linear
     * but wheather it apperas linearly in a composite expression. For example
     * the sub expression 'sin(x)' appears linearly in '1+sin(x)'.
     * @attribute inh
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3653
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3653")
    public boolean isLinear() {
        boolean isLinear_value = getParent().Define_isLinear(this, null);
        return isLinear_value;
    }
    /**
     * @attribute inh
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3688
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3688")
    public boolean isLinear(Set<FVariable> vars) {
        boolean isLinear_Set_FVariable__value = getParent().Define_isLinear(this, null, vars);
        return isLinear_Set_FVariable__value;
    }
    /**
     * @attribute inh
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAlgorithmAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4230")
    public FAlgorithm myFAlgorithm() {
        FAlgorithm myFAlgorithm_value = getParent().Define_myFAlgorithm(this, null);
        return myFAlgorithm_value;
    }
    /**
     * Is this expression in a parameter equation?
     * @attribute inh
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241")
    public boolean inParameterEquation() {
        boolean inParameterEquation_value = getParent().Define_inParameterEquation(this, null);
        return inParameterEquation_value;
    }
    /**
     * Is this expression in the value of an attribute?
     * @attribute inh
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250")
    public boolean inAttributeValue() {
        boolean inAttributeValue_value = getParent().Define_inAttributeValue(this, null);
        return inAttributeValue_value;
    }
    /**
     * Get the containing FFunctionDecl.
     * 
     * Only valid in flat tree.
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425")
    public FFunctionDecl containingFFunctionDecl() {
        FFunctionDecl containingFFunctionDecl_value = getParent().Define_containingFFunctionDecl(this, null);
        return containingFFunctionDecl_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1446")
    public boolean inAlgorithm() {
        boolean inAlgorithm_value = getParent().Define_inAlgorithm(this, null);
        return inAlgorithm_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522")
    public boolean functionCallIsExp() {
        boolean functionCallIsExp_value = getParent().Define_functionCallIsExp(this, null);
        return functionCallIsExp_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539")
    public FAbstractFunctionCall myFunctionCall() {
        FAbstractFunctionCall myFunctionCall_value = getParent().Define_myFunctionCall(this, null);
        return myFunctionCall_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571")
    public String calcGeneratedVarName(FlatVariableMap.GeneratedVarType gvt) {
        String calcGeneratedVarName_FlatVariableMap_GeneratedVarType_value = getParent().Define_calcGeneratedVarName(this, null, gvt);
        return calcGeneratedVarName_FlatVariableMap_GeneratedVarType_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1770
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1770")
    public boolean inEquationSection() {
        boolean inEquationSection_value = getParent().Define_inEquationSection(this, null);
        return inEquationSection_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1775
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1775")
    public boolean inInitialEquationSection() {
        boolean inInitialEquationSection_value = getParent().Define_inInitialEquationSection(this, null);
        return inInitialEquationSection_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1781
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1781")
    public boolean inEquation() {
        boolean inEquation_value = getParent().Define_inEquation(this, null);
        return inEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785")
    public boolean inNoEventExp() {
        boolean inNoEventExp_value = getParent().Define_inNoEventExp(this, null);
        return inNoEventExp_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1792
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1792")
    public boolean inSmoothExp(int order) {
        boolean inSmoothExp_int_value = getParent().Define_inSmoothExp(this, null, order);
        return inSmoothExp_int_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1798
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1798")
    public boolean inConnectClause() {
        boolean inConnectClause_value = getParent().Define_inConnectClause(this, null);
        return inConnectClause_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1804
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1804")
    public boolean inIfCondition() {
        boolean inIfCondition_value = getParent().Define_inIfCondition(this, null);
        return inIfCondition_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824")
    public boolean inWhen() {
        boolean inWhen_value = getParent().Define_inWhen(this, null);
        return inWhen_value;
    }
    /**
     * Check if this expression is in an FArray expression. Either directly or
     * a thorugh a sequence of other expressions.
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870")
    public boolean inFArray() {
        boolean inFArray_value = getParent().Define_inFArray(this, null);
        return inFArray_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:427")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * Check if this expression is multiplied with the given variable.
     * @attribute inh
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:333
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:333")
    public boolean isMultipliedWith(FVariable v) {
        boolean isMultipliedWith_FVariable_value = getParent().Define_isMultipliedWith(this, null, v);
        return isMultipliedWith_FVariable_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:157")
    public boolean flattenFASContext() {
        boolean flattenFASContext_value = getParent().Define_flattenFASContext(this, null);
        return flattenFASContext_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFAccesss
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:197
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFAccesss", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:197")
    public FAccess retrieveFAccess() {
        FAccess retrieveFAccess_value = getParent().Define_retrieveFAccess(this, null);
        return retrieveFAccess_value;
    }
    /**
     * Find the InstModification containing this expression, if any.
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:676
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:676")
    public InstModification surroundingInstModification() {
        InstModification surroundingInstModification_value = getParent().Define_surroundingInstModification(this, null);
        return surroundingInstModification_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2474
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2474")
    public InstNode containingInstNode() {
        InstNode containingInstNode_value = getParent().Define_containingInstNode(this, null);
        return containingInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:402
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:402")
    public boolean inNonDiffArg() {
        boolean inNonDiffArg_value = getParent().Define_inNonDiffArg(this, null);
        return inNonDiffArg_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1837
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1837")
    public boolean duringFunctionInlining() {
        boolean duringFunctionInlining_value = getParent().Define_duringFunctionInlining(this, null);
        return duringFunctionInlining_value;
    }
    /**
     * @attribute inh
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:416
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:416")
    public int outerCoeff() {
        int outerCoeff_value = getParent().Define_outerCoeff(this, null);
        return outerCoeff_value;
    }
    /**
     * @attribute inh
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:628
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:628")
    public FExp myTopFactorFExp() {
        FExp myTopFactorFExp_value = getParent().Define_myTopFactorFExp(this, null);
        return myTopFactorFExp_value;
    }
    /**
     * Check if this FExp is in an binding exp that will still be a binding exp after scalarization 
     * @attribute inh
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:595")
    public boolean inKeptBExp() {
        boolean inKeptBExp_value = getParent().Define_inKeptBExp(this, null);
        return inKeptBExp_value;
    }
    /**
     * Surrounding if or else equation, if any.
     * 
     * Only valid in flat tree.
     * @attribute inh
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347")
    public FIfWhenEquation surroundingIfOrElse() {
        FIfWhenEquation surroundingIfOrElse_value = getParent().Define_surroundingIfOrElse(this, null);
        return surroundingIfOrElse_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114")
    public boolean inUnknownSize() {
        boolean inUnknownSize_value = getParent().Define_inUnknownSize(this, null);
        return inUnknownSize_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125")
    public boolean isFunctionCallIO() {
        boolean isFunctionCallIO_value = getParent().Define_isFunctionCallIO(this, null);
        return isFunctionCallIO_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131")
    public boolean isForIndexExp() {
        boolean isForIndexExp_value = getParent().Define_isForIndexExp(this, null);
        return isForIndexExp_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:135
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:135")
    public boolean isFVectorFunctionCallArg() {
        boolean isFVectorFunctionCallArg_value = getParent().Define_isFVectorFunctionCallArg(this, null);
        return isFVectorFunctionCallArg_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarizationHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:1014
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarizationHelpers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:1014")
    public FAbstractVariable lookupFV(String name) {
        FAbstractVariable lookupFV_String_value = getParent().Define_lookupFV(this, null, name);
        return lookupFV_String_value;
    }
    /**
     * @attribute inh
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:175
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SizeAsserts", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:175")
    public FExp enclosingIfExpCond() {
        FExp enclosingIfExpCond_value = getParent().Define_enclosingIfExpCond(this, null);
        return enclosingIfExpCond_value;
    }
    /**
     * @attribute inh
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:291")
    public boolean isNegativeTerm() {
        boolean isNegativeTerm_value = getParent().Define_isNegativeTerm(this, null);
        return isNegativeTerm_value;
    }
    /**
     * @attribute inh
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:299")
    public boolean isInvertedFactor() {
        boolean isInvertedFactor_value = getParent().Define_isInvertedFactor(this, null);
        return isInvertedFactor_value;
    }
    /**
     * @attribute inh
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574")
    public boolean isIndicator() {
        boolean isIndicator_value = getParent().Define_isIndicator(this, null);
        return isIndicator_value;
    }
    /**
     * @attribute inh
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:583")
    public boolean hasBrancher() {
        boolean hasBrancher_value = getParent().Define_hasBrancher(this, null);
        return hasBrancher_value;
    }
    /**
     * @attribute inh
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626")
    public FExp parentFExp() {
        FExp parentFExp_value = getParent().Define_parentFExp(this, null);
        return parentFExp_value;
    }
    /**
     * Check if this string concatenation or String operator is the top node in an expression consisting of 
     * one or more string concatenations, i.e. returns true if parent is not an FStringAddExp.
     * @attribute inh
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1025
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1025")
    public boolean isTopStringOp() {
        boolean isTopStringOp_value = getParent().Define_isTopStringOp(this, null);
        return isTopStringOp_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     */
    public CommonVariableDecl Define_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingVariableDecl
     */
    protected boolean canDefine_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     */
    public Precedence Define_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                Precedence precedence = precedence();
                if (precedence == Precedence.HIGHEST)
                    return Precedence.LOWEST;
                else
                    return precedence;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveParentPrecedence
     */
    protected boolean canDefine_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     */
    public boolean Define_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallLeft
     */
    protected boolean canDefine_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     */
    public boolean Define_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute useIsAssignment
     */
    protected boolean canDefine_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallIsExp
     */
    protected boolean canDefine_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1532
     * @apilevel internal
     */
    public ArrayList<FFunctionCallLeft> Define_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new ArrayList<FFunctionCallLeft>();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myLefts
     */
    protected boolean canDefine_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     */
    public boolean Define_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return inFArray();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFArray
     */
    protected boolean canDefine_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209
     * @apilevel internal
     */
    public List<InstAccess> Define_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new List<InstAccess>();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextInst
     */
    protected boolean canDefine_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:215
     * @apilevel internal
     */
    public List<FAccessPart> Define_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new List<FAccessPart>();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:215
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextFlat
     */
    protected boolean canDefine_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     * @apilevel internal
     */
    public boolean Define_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpUseOK
     */
    protected boolean canDefine_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853
     * @apilevel internal
     */
    public boolean Define_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpMustBeScalar
     */
    protected boolean canDefine_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1112
     * @apilevel internal
     */
    public boolean Define_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1112
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstComponentSize
     */
    protected boolean canDefine_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1542
     * @apilevel internal
     */
    public String Define_argumentTypeError(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1542
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentTypeError
     */
    protected boolean canDefine_argumentTypeError(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784
     * @apilevel internal
     */
    public FExp Define_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentBindingFExp
     */
    protected boolean canDefine_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     * @apilevel internal
     */
    public InstValueModification Define_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentInstValueMod
     */
    protected boolean canDefine_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     * @apilevel internal
     */
    public boolean Define_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return size().isUnknown() || (extractTemp() && extractAsUnknown()) ||
                    inUnknownSize();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inUnknownSize
     */
    protected boolean canDefine_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626
     * @apilevel internal
     */
    public FExp Define_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentFExp
     */
    protected boolean canDefine_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     */
    public boolean Define_inArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArray
     */
    protected boolean canDefine_inArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     */
    public FType Define_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return type().scalarType();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inferredType
     */
    protected boolean canDefine_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_eventGenExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2224
        if (generatesEvent()) {
            {
                FAbstractEquation target = (FAbstractEquation) (myFEquation());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_eventGenExps(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_eventGenExps(ArrayList<FExp> collection) {
        super.contributeTo_FAbstractEquation_eventGenExps(collection);
        if (generatesEvent()) {
            collection.add(this);
        }
    }
}
