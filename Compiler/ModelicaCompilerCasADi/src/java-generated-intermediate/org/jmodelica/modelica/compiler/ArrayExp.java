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
 * Describes the set of scalarized FExp nodes corresponding to an array expression.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:734
 * @astdecl ArrayExp : BaseNode ::= FExp*;
 * @production ArrayExp : {@link BaseNode} ::= <span class="component">{@link FExp}*</span>;

 */
public class ArrayExp extends BaseNode implements Cloneable, Array {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1225
     */
    public ArrayExp createExpanded(Iterable<? extends CommonForIndex> forIndices) {
		return createExpanded(this, forIndices);
	}
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1229
     */
    public static ArrayExp createExpanded(Array exp, Iterable<? extends CommonForIndex> forIndices) {
		Indices newIndices = Indices.create(forIndices);
		ArrayExp arr = new ArrayExp(Indices.create(expandedSize(exp, newIndices.size())));
		Map<String,FExp> indexMap = new HashMap<String,FExp>();
		for (Index i : newIndices) {
			newIndices.fillIndexMap(indexMap, i, forIndices);
			for (CommonForIndex fi : forIndices)
				indexMap.put(fi.uniqueIterExpName(), fi.evaluationValue().buildLiteral());
            fillSubset(arr, i, indexMap, exp);
		}
        for (CommonForIndex fi : forIndices) {
            fi.clearEvaluationValue();
        }
		return arr;
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1245
     */
    protected static Size expandedSize(Array exp, Size size) {
		return exp.size().expand(size);
	}
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1249
     */
    protected static void fillSubset(ArrayExp arr, Index i, Map<String,FExp> indexMap, Array exp) {
		for (Index i2 : exp.indices()) {
            arr.set(i.expand(i2), createSubsetExp(exp.get(i2), indexMap));
		}
	}
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1255
     */
    protected static FExp createSubsetExp(FExp e, Map<String,FExp> indexMap) {
        return e.dynamicFExp(e.fullCopy()).replaceIndices(indexMap);
    }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3532
     */
    
		
		protected Indices indices;
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3533
     */
    
		protected int length;
    /**
     * Create an ArrayExp spanning a given Indices.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3538
     */
    
		
		/**
		 * Create an ArrayExp spanning a given Indices.
		 */
		public ArrayExp(Indices indices) {
			this.indices = indices;
			setChild(new List<FExp>(), 0);
			length = indices.numElements();
			if (length > 0)
				setFExp(null, length - 1);
		}
    /**
     * Creates an iterator that iterates over all FExp nodes in this Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3549
     */
    
		
		/**
		 * Creates an iterator that iterates over all FExp nodes in this Array.
		 */
		public Iterator<FExp> iteratorFExp() {
			return getFExps().iterator();
		}
    /**
     * Returns an Iterable<FExp> containing all expressions in Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3556
     */
    
		
		/**
		 * Returns an Iterable<FExp> containing all expressions in Array.
		 */
		public Iterable<FExp> iterable() {
			return getFExps();
		}
    /**
     * Creates a left-hand iterator for multiplication. 
     * 
     * Creates an iterator that iterates over all FExp nodes involved in 
     * calculating the cell i in a multiplication with this Array at the 
     * left side. 
     * 
     * If this Array is a vector, i is ignored and an iterator that iterates 
     * over all elements in the Array is returned. 
     * 
     * If this Array is a matrix, an iterator that iterates over the row 
     * specified by i is returned.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3573
     */
    
		
		/**
		 * Creates a left-hand iterator for multiplication. 
		 * 
		 * Creates an iterator that iterates over all FExp nodes involved in 
		 * calculating the cell i in a multiplication with this Array at the 
		 * left side. 
		 * 
		 * If this Array is a vector, i is ignored and an iterator that iterates 
		 * over all elements in the Array is returned. 
		 * 
		 * If this Array is a matrix, an iterator that iterates over the row 
		 * specified by i is returned.
		 */
		public Iterator<FExp> leftMulIterator(Index i) {
			if (ndims() < 2)
				return new AIterator();
			else
				return createMatrixRowIterator(i.first(), size().get(1));
		}
    /**
     * Creates a right-hand iterator for multiplication. 
     * 
     * Creates an iterator that iterates over all FExp nodes involved in 
     * calculating the cell i in a multiplication with this Array at the 
     * right side. 
     * 
     * If this Array is a vector, i is ignored and an iterator that iterates 
     * over all elements in the Array is returned. 
     * 
     * If this Array is a matrix, an iterator that iterates over the column 
     * specified by i is returned.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3593
     */
    
		
		/**
		 * Creates a right-hand iterator for multiplication. 
		 * 
		 * Creates an iterator that iterates over all FExp nodes involved in 
		 * calculating the cell i in a multiplication with this Array at the 
		 * right side. 
		 * 
		 * If this Array is a vector, i is ignored and an iterator that iterates 
		 * over all elements in the Array is returned. 
		 * 
		 * If this Array is a matrix, an iterator that iterates over the column 
		 * specified by i is returned.
		 */
		public Iterator<FExp> rightMulIterator(Index i) {
			if (ndims() < 2)
				return new AIterator();
			else
				return createMatrixColIterator(i.last(), size().get(1), size().get(0));
		}
    /**
     * Returns the element referenced by <code>i</code> in this Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3603
     */
    
		
		/**
		 * Returns the element referenced by <code>i</code> in this Array.
		 */
		public FExp get(Index i) {
			return getFExp(i.internal(indices));
		}
    /**
     * Returns element <code>i</code> in this Array.
     * 
     * For vectors, this is equivalent to <code>get(new Index(new int[]{i}))</code>.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3612
     */
    
		
		/**
		 * Returns element <code>i</code> in this Array.
		 * 
		 * For vectors, this is equivalent to <code>get(new Index(new int[]{i}))</code>.
		 */
		public FExp get(int i) {
			return getFExp(i - 1);
		}
    /**
     * Sets the element referenced by <code>i</code> in this Array to <code>exp</code>.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3619
     */
    
		
		/**
		 * Sets the element referenced by <code>i</code> in this Array to <code>exp</code>.
		 */
		public void set(Index i, FExp exp) {
			setFExp(exp.unboundCopy(), i.internal(indices));
		}
    /**
     * Returns the Indices associated with this Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3626
     */
    
		
		/**
		 * Returns the Indices associated with this Array.
		 */
		public Indices indices() {
			return indices;
		}
    /**
     * Set all expressions in Array to copies of <code>exp</code>.
     * 
     * If <code>exp</code> is an array, it is duplicated as many times as 
     * nessecary to fill this Array with scalar expressions.
     * 
     * @return <code>this</code> 
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3638
     */
    
		
		/**
		 * Set all expressions in Array to copies of <code>exp</code>.
		 * 
		 * If <code>exp</code> is an array, it is duplicated as many times as 
		 * nessecary to fill this Array with scalar expressions.
		 * 
		 * @return <code>this</code> 
		 */
		public ArrayExp fill(FExp exp) {
			if (exp.isArray()) {
				int n = exp.size().numElements();
				for (int i = 0; i < length; i++)
					setFExp(exp.getArray().getFExp(i % n).fullCopy(), i);
			} else {
				for (int i = 0; i < length; i++)
					setFExp(exp.fullCopy(), i);
			}
			return this;
		}
    /**
     * Returns the number of dimensions spanned by this Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3653
     */
    
		
		/**
		 * Returns the number of dimensions spanned by this Array.
		 */
		public int ndims() {
			return indices.ndims();
		}
    /**
     * Returns the size of this Array in each dimension.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3660
     */
    
		
		/**
		 * Returns the size of this Array in each dimension.
		 */
		public Size size() {
			return indices.size();
		}
    /**
     * Recursive method for building an FArray describing this Array.
     * For use by methods creating specific types of FArrays.
     * 
     * @param it       the iterator returned by a call to {@link #iteratorFExp()}
     * @param builder  helper object that processes each subexpression
     * @param dim      the dimension to start at, use 0 to process entire array
     * 
     * @see #buildScalarized(java.util.Map,FExp)
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3674
     */
    
		
	    /**
	     * Recursive method for building an FArray describing this Array.
	     *        For use by methods creating specific types of FArrays.
	     *  
	     * @param it       the iterator returned by a call to {@link #iteratorFExp()}
	     * @param builder  helper object that processes each subexpression
	     * @param dim      the dimension to start at, use 0 to process entire array
	     * 
	     * @see #buildScalarized(java.util.Map,FExp)
	     */
        protected FExp buildFArray(Iterator<FExp> it, ElementBuilder builder, int dim) {
            return buildFArray(it, builder, dim, size(), null);
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3678
     */
    
        
        protected FExp buildFArray(Iterator<FExp> it, ElementBuilder builder, int dim, Size size, boolean[] b) {
            FArray arr = new FArray(new List<FExp>());
            int n = size.get(dim);
            if (b != null) {
                if (dim >= b.length) {
                    return builder.build(it.next().unboundCopy());
                } else if (!b[dim]) {
                    return buildFArray(it, builder, dim + 1, size, b);
                }
            }
            if (dim < size.ndims() - 1) {
                for (int i = 0; i < n; i++)
                    arr.addFExp(buildFArray(it, builder, dim + 1, size, b));
            } else {
                for (int i = 0; i < n; i++) 
                    arr.addFExp(builder.build(it.next()).unboundCopy());
            }
            return arr;
        }
    /**
     * Build an FArray describing this Array.
     * For use by methods creating specific types of FArrays.
     * 
     * @param builder  helper object that processes each subexpression
     * 
     * @see #buildScalarized(java.util.Map,FExp)
     * @see #buildFArray(Iterator,ElementBuilder,int)
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3707
     */
    
		
	    /**
	     * Build an FArray describing this Array.
	     *        For use by methods creating specific types of FArrays.
	     *  
	     * @param builder  helper object that processes each subexpression
	     * 
	     * @see #buildScalarized(java.util.Map,FExp)
	     * @see #buildFArray(Iterator,ElementBuilder,int)
	     */
	    protected FExp buildFArray(ElementBuilder builder) {
			Size s = size();
			if (s.isEmpty()) {
				List<FExp> dims = new List<FExp>();
				for (int i = 0, n = s.ndims(); i < n ; i++)
					dims.add(s.createFExp(i));
				return new FFillExp(dims, type().zeroLiteral());
			} else {
		    	return buildFArray(iteratorFExp(), builder, 0);
			}
	    }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3719
     */
    
	    
        protected FExp buildFArray() {
            return buildFArray(new IdentityBuilder());
        }
    /**
     * Create an FExp describing the part of this array indicated by <code>i</code>.
     * 
     * If <code>i</code> has fewer dimensions than this, an FArray is created.
     * Otherwise a copy of a specific cell is returned. 
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3729
     */
    
	    
	    /**
	     * Create an FExp describing the part of this array indicated by <code>i</code>.
	     * 
	     * If <code>i</code> has fewer dimensions than this, an FArray is created.
	     * Otherwise a copy of a specific cell is returned. 
	     */
        public FExp subArrayFExp(Index i) {
            if (i.ndims() >= ndims())
                return get(i).fullCopy();
            int start = i.internal(indices);
            Iterator<FExp> it = new AIterator(start, 1, length - start);
            return buildFArray(it, new IdentityBuilder(), i.ndims());
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3737
     */
    
	    
        public FExp subArrayFExp(Index i, NonConsecutiveIndices indices) {
            if (i.ndims() >= ndims())
                return get(indices.translate(i)).fullCopy();
            
            boolean[] b = new boolean[ndims()];
            indices = indices.locked(i, b);
            Iterator<FExp> it = new IndexIterator(indices);
            return buildFArray(it, new IdentityBuilder(), 0, indices.size(), b);
        }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3747
     */
    
        
        public class IndexIterator implements Iterator<FExp> {
            
            
            private Iterator<Index> it;
            private Indices indices;
            
            public IndexIterator(Indices indices) {
                this.indices = indices;
                this.it = indices.iterator();
            }
            
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public FExp next() {
                return get(indices.translate(it.next()));
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }
    /**
     * Create an iterator that iterates over a row. Assumes the Array is a matrix.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3777
     */
    
		
		/**
		 * Create an iterator that iterates over a row. Assumes the Array is a matrix.
		 */
		private AIterator createMatrixRowIterator(int row, int width) {
			return new AIterator((row - 1) * width, 1, width);
		}
    /**
     * Create an iterator that iterates over a column. Assumes the Array is a matrix.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3784
     */
    
		
		/**
		 * Create an iterator that iterates over a column. Assumes the Array is a matrix.
		 */
		private AIterator createMatrixColIterator(int col, int width, int height) {
			return new AIterator(col - 1, width, height);
		}
    /**
     * Discribes the helper object for {@link #buildFArray(Iterator,ElementBuilder,int)}. 
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3792
     */
    

		
	    /**
	     * Discribes the helper object for {@link #buildFArray(Iterator,ElementBuilder,int)}. 
	     */
	    protected interface ElementBuilder {
	    	public FExp build(FExp e);
	    }
    /**
     * Builder for buildFArray(), that returns a straight copy of the FExp.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3799
     */
    
	    
	    /**
	     * Builder for buildFArray(), that returns a straight copy of the FExp.
	     */
	    public class IdentityBuilder implements ElementBuilder {
	    	public FExp build(FExp exp) {
	    		return exp.fullCopy();
	    	}
	    }
    /**
     * Iterates over FExp nodes in this Array.
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3809
     */
    
		
	    
		/**
		 * Iterates over FExp nodes in this Array.
		 */
		private class AIterator implements Iterator<FExp> {
			
			private int i = 0;
			private int s;
			private int l;
			private int n;
			
			/**
			 * Create an iterator that iterates over all elements in the Array. 
			 */
			public AIterator() {
				s = 0;
				l = 1;
				n = length;
			}
			
			/**
			 * Create an iterator that iterates over a consecutive strech of the elements 
			 * in the Array. 
			 */
			public AIterator(int start, int step, int number) {
				s = start;
				l = step;
				n = number;
			}
			
			public boolean hasNext() {
				return i < n;
			}
			
			public FExp next() {
				if (i >= n)
					throw new NoSuchElementException();
				return getFExp(s + l * i++);
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		}
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2510
     */
    public FExp buildFlattened(Flattener f, FExp context) {
        return buildFArray(new FlattenedBuilder(f, context, 0));
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2514
     */
    public FExp buildFlattened(Flattener f, FExp context, int order) {
        return buildFArray(new FlattenedBuilder(f, context, order));
    }
    /**
     * Helper object for {@link #buildFlattened(FAccess, FExp)}.
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2522
     */
    
        /**
         * Helper object for {@link #buildFlattened(FAccess, FExp)}.
         */
        protected static class FlattenedBuilder implements ElementBuilder {
            private Flattener f;
            private FExp context;
            private int order;
            
            public FlattenedBuilder(Flattener f, FExp context, int order) {
                this.f = f;
                this.context = context;
                this.order = order;
            }
            
            public FExp build(FExp e) {
                if (order > 0) {
                    return context.dynamicFExp(new InstHDerExp(e, order)).flatten(f);
                } else {
                    return context.dynamicFExp(e).flatten(f);
                }
            }
        }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1736
     */
    

        public FExp buildWithReplacedReferences(AbstractFunctionInliner fi, FExp context) {
            return buildFArray(new ReplaceReferenceBuilder(fi, context));
        }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1740
     */
    

        protected class ReplaceReferenceBuilder implements ElementBuilder {
            private AbstractFunctionInliner fi;
            private FExp context;

            public ReplaceReferenceBuilder(AbstractFunctionInliner fi, FExp context) {
                this.fi = fi;
                this.context = context;
            }

            public FExp build(FExp e) {
                return context.dynamicFExp(e).replaceReferences(fi);
            }
        }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:187
     */
    public void createArrayTemporaries(Scalarizer s) {
        super.createArrayTemporaries(s);
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:857
     */
    public FExp buildDiff(final String name) {
        return buildFArray(new ElementBuilder() {
            public FExp build(FExp exp) {
                return exp.diff(name);
            }
        });
    }
    /**
     * @declaredat ASTNode:1
     */
    public ArrayExp() {
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
        children = new ASTNode[1];
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FExp"},
        type = {"List<FExp>"},
        kind = {"List"}
    )
    public ArrayExp(List<FExp> p0) {
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
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:41
     */
    public ArrayExp clone() throws CloneNotSupportedException {
        ArrayExp node = (ArrayExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:46
     */
    public ArrayExp copy() {
        try {
            ArrayExp node = (ArrayExp) clone();
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
     * @declaredat ASTNode:65
     */
    @Deprecated
    public ArrayExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:75
     */
    public ArrayExp treeCopyNoTransform() {
        ArrayExp tree = (ArrayExp) copy();
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
     * @declaredat ASTNode:95
     */
    public ArrayExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:100
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FExp list.
     * @param list The new list node to be used as the FExp list.
     * @apilevel high-level
     */
    public void setFExpList(List<FExp> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FExp list.
     * @return Number of children in the FExp list.
     * @apilevel high-level
     */
    public int getNumFExp() {
        return getFExpList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FExp list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FExp list.
     * @apilevel low-level
     */
    public int getNumFExpNoTransform() {
        return getFExpListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FExp list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FExp list.
     * @apilevel high-level
     */
    public FExp getFExp(int i) {
        return (FExp) getFExpList().getChild(i);
    }
    /**
     * Check whether the FExp list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFExp() {
        return getFExpList().getNumChild() != 0;
    }
    /**
     * Append an element to the FExp list.
     * @param node The element to append to the FExp list.
     * @apilevel high-level
     */
    public void addFExp(FExp node) {
        List<FExp> list = (parent == null) ? getFExpListNoTransform() : getFExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFExpNoTransform(FExp node) {
        List<FExp> list = getFExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FExp list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFExp(FExp node, int i) {
        List<FExp> list = getFExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FExp list.
     * @return The node representing the FExp list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FExp")
    public List<FExp> getFExpList() {
        List<FExp> list = (List<FExp>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FExp list.
     * @apilevel low-level
     */
    public List<FExp> getFExpListNoTransform() {
        return (List<FExp>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FExp list without
     * triggering rewrites.
     */
    public FExp getFExpNoTransform(int i) {
        return (FExp) getFExpListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FExp list.
     * @return The node representing the FExp list.
     * @apilevel high-level
     */
    public List<FExp> getFExps() {
        return getFExpList();
    }
    /**
     * Retrieves the FExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FExp list.
     * @apilevel low-level
     */
    public List<FExp> getFExpsNoTransform() {
        return getFExpListNoTransform();
    }
    /**
     * The type of the expression this ArrayExp belongs to.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380")
    public FType type() {
        FType type_value = getParent().Define_type(this, null);
        return type_value;
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
}
