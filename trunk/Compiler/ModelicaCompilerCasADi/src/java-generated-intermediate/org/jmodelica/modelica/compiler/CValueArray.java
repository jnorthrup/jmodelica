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
 * @ast class
 * @aspect ConstantEvaluation
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:835
 */
public class CValueArray extends CValue {
    
    	
    	/* TODO: If/when caching is introduced for ceval(), add lazy evaluation by 
    	 *       keeping a reference to the producing FExp and adding a method to FExp 
    	 *       that fills in a specific cell. This method can then be overridden as 
    	 *       constant eval support for arrays is added to specific expression types.
    	 */ 
    	
		protected Indices indices;

    
		protected CValue[] values;

    
		private int add = 0;

    
    	
		/**
		 * Create a CValueArray of size <code>s</code>.
		 * 
		 * The array is initially filled with unknown values. 
		 * Individual values must be set with setCell().
		 */
    	public CValueArray(Size s) {
    	    s = s.evaluated();
    		indices = Indices.create(s);
			values = new CValue[indices.numElements()];
			for (int i = 0; i < values.length; i++)
				values[i] = UNKNOWN;
    	}

    
	    
	    public CValue clone() {
	    	CValueArray res = (CValueArray) super.clone();
	    	res.values = new CValue[values.length];
	    	for (int i = 0; i < values.length; i++) 
				res.values[i] = values[i].clone();
	    	return res;
	    }

    

        public boolean isArray() {
            return true;
        }

    

        @Override
        public int ndims() {
            return indices.ndims();
        }

    

        /**
         * Check if there was an error in any part of the evaluation.
         *
         * @return true if there was an error, otherwise false. 
         */
        public boolean isPartlyUnknown() {
            for (CValue cvalue : values)
                if (cvalue.isPartlyUnknown())
                    return true;
            return false;
        }

    

        public CValue constrainWithin(CValue min, CValue max) {
            CValueArray res = new CValueArray(size());
            for (int i = 0; i < values.length; i++) {
                CValue cellMin = min.isArray() ? min.array().getCell(i) : min;
                CValue cellMax = max.isArray() ? max.array().getCell(i) : max;
                res.values[i] = values[i].constrainWithin(cellMin, cellMax);
            }
            return res;
        }

    

        @Override
        public boolean isReal() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isReal();
            return res;
        }

    

        @Override
        public boolean isInteger() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isInteger();
            return res;
        }

    

        @Override
        public boolean isString() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isString();
            return res;
        }

    

        @Override
        public boolean isBoolean() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isBoolean();
            return res;
        }

    

        @Override
        public boolean isEnum() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isEnum();
            return res;
        }

    

        @Override
        public boolean isValid() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isValid();
            return res;
        }

    

        @Override
        public boolean isUnknownAccess() {
            boolean res = true;
            for (CValue cvalue : values)
                res &= cvalue.isUnknownAccess();
            return res;
        }

    

        @Override
        public int[] intVector() {
            int[] vector = new int[values.length];
            for (int i = 0; i < values.length; i++)
                vector[i] = values[i].intValue();
            return vector;
        }

    

        @Override
        public double[] realVector() {
            double[] vector = new double[values.length];
            for (int i = 0; i < values.length; i++)
                vector[i] = values[i].realValue();
            return vector;
        }

    

        @Override
        public double[][] realMatrix() { 
            if (size().ndims() != 2) {
                double[][] matrix = new double[values.length][];
                for (int i = 0; i < values.length; i++) {
                    matrix[i] = values[i].realVector();
                }
                return matrix;
            }
            int n = size().get(0);
            int m = size().get(1);
            double[][] matrix = new double[n][m];
            for (Index i : indices()) {
                matrix[i.get(0)-1][i.get(1)-1] = getCell(i).realValue();
            }
            return matrix;
        }

    

        @Override
        public String[] stringVector() { 
            String[] vector = new String[values.length];
            for (int i = 0; i < values.length; i++)
                vector[i] = values[i].stringValue();
            return vector;
        }

    

        @Override
        public String[] accessVector() { 
            String[] vector = new String[values.length];
            for (int i = 0; i < values.length; i++)
                vector[i] = values[i].access();
            return vector;
        }

    

        /**
         * Convert to Object, Returns an Object array.
         * 
         * @return Value as Object[].
         */
        @Override
        public Object[] objectValue() { 
            return objectValue(0, 0);
        }

    
        
        private Object[] objectValue(int dim, int pos) {
            int n = size().get(dim);
            dim++;
            Object[] res = new Object[n];
            if (dim == ndims()) {
                for (int i = 0; i < n; i++) {
                    res[i] = values[pos + i].objectValue();
                }
            } else {
                int m = size().numElements(dim);
                for (int i = 0; i < n; i++) {
                    res[i] = objectValue(dim, pos + m * i);
                }
            }
            return res;
        }

    

        @Override
        public double minValue() {
            double min = Double.MAX_VALUE;
            for (CValue value : values)
                min = Math.min(value.minValue(), min);
            return min;
        }

    

        @Override
        public double maxValue() {
            double max = Double.MIN_VALUE;
            for (CValue value : values)
                max = Math.max(value.minValue(), max);
            return max;
        }

    

        /**
         * Convenience method for accessing an array CValue as CValueArray.
         * 
         * Only valid for arrays.
         */
        public CValueArray array() {
        	return this;
        }

          
        
        /**
         * Expand this CValue so that it represents an array of the given size, 
         * duplicating values as needed.
         */
        public CValue expandArray(Size s) {
        	if (s.ndims() == indices.ndims())
        		return this;
        	if (s.ndims() < indices.ndims())
        		throw new ConstantEvaluationException(this, "contract array to size " + s + ": "); 
        	
        	CValueArray res = new CValueArray(s);
        	while (!res.isFilled())
        		for (CValue v : values)
        			res.addCell(v);
        	return res;
        }

    
 	   
        /**
         * Set the value of a specific cell of an array constant value.
         */
        public void setCell(Index i, CValue val) {
        	values[i.internal(indices)] = val;
        }

    
        
       /**
         * Is this array is sufficiently large to to represent the given index. 
         */
        public boolean hasCell(Index i) {
            return indices.isValid(i);
        }

    
        
        /**
         * Set the value of the next free cell of an array constant value.
         * 
         * "Free" here means the cell after the last one set by addCell(), or the 
         * first cell if this is the first call.
         */
        public void addCell(CValue val) {
        	values[add++] = val;
        }

    
        
        /**
         * Returns <code>false</code> until {@link #addCell(CValue)} has been called 
         * once for each cell.
         */
        public boolean isFilled() {
        	return add >= values.length;
        }

    
        
        /**
         * Get the value of a specific cell of an array constant value.
         */
        public CValue getCell(Index i) {
        	if (!hasCell(i))
        		return UNKNOWN;
        	return values[i.internal(indices)];
        }

    

        /**
         * Get the value of a specific cell of an array constant value.
         */
        public CValue getCell(int i) {
            if (i < 0 || i >= values.length)
                return UNKNOWN;
            return values[i];
        }

    

        /**
         * Get the part of this array corresponding to the given index.
         */
        public CValue getPart(Index i) {
        	if (i == Index.NULL)
        		return this;
        	if (indices.ndims() == i.ndims())
        		return getCell(i);
        	
        	CValueArray res = new CValueArray(size().contract(i.ndims(), 0));
        	System.arraycopy(values, indices.internal(i), res.values, 0, res.values.length);
        	return res;
        }

    
        
        /**
         * Reduce an array to a single value.
         * 
         * For a scalar, returns itself. For an empty array, returns zero.
         * 
         * @param op    the operation to use to combine two values
         * @param zero  the start value
         */
        public CValue reduce(BinaryOperation<CValue> op, CValue zero) {
        	for (CValue val : values)
        		zero = op.op(zero, val);
        	return zero;
        }

    
		
		/**
		 * Returns the Indices associated with this constant array.
		 */
		public Indices indices() {
			return indices;
		}

    
		
		/**
		 * Returns the array size of this constant value.
		 */
		public Size size() {
			return indices.size();
		}

    
	    
	    /**
	     * Convert each cell to CValueInteger.
	     */
	    public CValue convertInteger() {
	    	CValueArray res = new CValueArray(indices.size());
	    	for (int i = 0; i < values.length; i++)
	    		res.values[i] = values[i].convertInteger();
	    	return res;
	    }

    
	    
	    /**
	     * Convert each cell to CValueReal.
	     */
	    public CValue convertReal() {
	    	CValueArray res = new CValueArray(indices.size());
	    	for (int i = 0; i < values.length; i++)
	    		res.values[i] = values[i].convertReal();
	    	return res;
	    }

    
	    
	    /**
	     * Convert each cell to CValueBoolean.
	     */
	    public CValue convertBoolean() {
	    	CValueArray res = new CValueArray(indices.size());
	    	for (int i = 0; i < values.length; i++)
	    		res.values[i] = values[i].convertBoolean();
	    	return res;
	    }

    
	    
	    /**
	     * Convert each cell to CValueString.
	     */
	    public CValue convertString() {
	    	CValueArray res = new CValueArray(indices.size());
	    	for (int i = 0; i < values.length; i++)
	    		res.values[i] = values[i].convertString();
	    	return res;
	    }

    

        /**
         * Is {@link #convertInteger()} expected to succeed?
         */
        public boolean hasConvertInteger() {
            for (CValue val : values) {
                if (!val.hasConvertInteger()) {
                    return false;
                }
            }
            return true;
        }

    

        /**
         * Is {@link #convertReal()} expected to succeed?
         */
        public boolean hasConvertReal() {
            for (CValue val : values) {
                if (!val.hasConvertReal()) {
                    return false;
                }
            }
            return true;
        }

    

        /**
         * Is {@link #convertBoolean()} expected to succeed?
         */
        public boolean hasConvertBoolean() {
            for (CValue val : values) {
                if (!val.hasConvertBoolean()) {
                    return false;
                }
            }
            return true;
        }

    

        /**
         * Is {@link #convertString()} expected to succeed?
         */
        public boolean hasConvertString() {
            for (CValue val : values) {
                if (!val.hasConvertString()) {
                    return false;
                }
            }
            return true;
        }

    

		public String toString() {
			// TODO: Should this be stringValue() instead?
			if (values.length == 0)
				return "(zero-size array)";
			StringBuilder buf = new StringBuilder();
			toStringRec(buf, iterator(), 0);
			return buf.toString();
		}

    
		
		private void toStringRec(StringBuilder buf, Iterator<CValue> it, int dim) {
			if (dim < indices.ndims()) {
				int n = indices.size().get(dim);
				buf.append("{ ");
				dim++;
				toStringRec(buf, it, dim);
				for (int i = 1; i < n; i++) {
					buf.append(", ");
					toStringRec(buf, it, dim);
				}
				buf.append(" }");
			} else {
				buf.append(it.next());
			}
		}

    

        /**
         * Create a literal AST node from constant, for use in flat tree.
         * 
         * @return FArray AST node containing literal expression nodes.
         */
        public FExp buildLiteral() { 
            return buildLiteralRec(iterator(), 0, true);
        }

    

        @Override
        public boolean hasBuildLiteral() {
            for (CValue val : values) {
                if (!val.hasBuildLiteral()) {
                    return false;
                }
            }
            return true;
        }

    

        /**
         * Create a literal AST node from constant, for use in instance tree.
         * 
         * @return FArray AST node containing literal expression nodes.
         */
        public FExp buildInstLiteral() { 
            return buildLiteralRec(iterator(), 0, false);
        }

    

        private FExp buildLiteralRec(Iterator<CValue> it, int dim, boolean flat) {
            if (dim < indices.ndims()) {
                FArray arr = new FArray();
                int n = indices.size().get(dim);
                dim++;
                for (int i = 0; i < n; i++) 
                    arr.addFExp(buildLiteralRec(it, dim, flat));
                return arr;
            } else {
                return flat ? it.next().buildLiteral() : it.next().buildInstLiteral();
            }
        }

    

	    /**
	     * An iterator that iterates over all cells in the array.
	     * 
	     * Traverses the array in the same order as indices().iterator().
	     */
		public Iterator<CValue> iterator() {
			return new ConstArrayIterator<CValue>(values);
		}

    

        /**
         * Checks whether or not this array has unknown members.
         * 
         * @return
         *          {@code false} of all array members are known, {@code true} otherwise.
         */
        public boolean hasUnknowns() {
            for (CValue value : values) {
                if (value.isUnknown()) {
                    return true;
                }
            }
            return false;
        }

    private boolean cached = false;

    public CValueArray markAsCached() { this.cached = true; return this; }

    public CValue cached()  {
        CValueArray res = this;
        if (cached) {
            res = (CValueArray) res.clone();
        } else {
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].cached();
            }
        }
        return res.markAsCached();
    }

    public boolean equals(CValue other) {
        if (other instanceof CValueArray) {
            CValueArray o = (CValueArray) other;
            if (values.length != o.values.length)
                return false;
            for (int i = 0; i < values.length; i++) {
                if (!values[i].equals(o.values[i])) {
                    return false;
                }
            }
            return true;
        }
        return super.equals(other);
    }

    public boolean typeMatches(CValue other) {
        if (other instanceof CValueArray) {
            CValueArray o = (CValueArray) other;
            if (values.length != o.values.length)
                return false;
            for (int i = 0; i < values.length; i++) {
                if (!values[i].typeMatches(o.values[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public CValue merge(CValue other) {
        if (other instanceof CValueArray) {
            CValueArray o = (CValueArray) other;
            if (values.length != o.values.length)
                return CValue.UNKNOWN;
            for (int i = 0; i < values.length; i++) {
                values[i] = values[i].merge(o.values[i]);
            }
            return this;
        }
        return CValue.UNKNOWN;
    }

    public void applyAttributes(List<FAttribute> attrs, Index i) {
	  if (values.length > 0 && values[0].isRecord()) 
		  for (Index j : indices) 
			  getCell(j).applyAttributes(attrs, i.expand(j));
  }

    public void serialize(BufferedWriter buff) throws IOException {
        for (int s : size().size) {
            buff.write("" + s + "\n");
        }
        for (Index i : indices()) {
            getCell(i).serialize(buff);
        }
    }


}
