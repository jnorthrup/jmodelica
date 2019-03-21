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
 * @aspect ArrayHelpers
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2390
 */
public class Size extends java.lang.Object {
    
		
		/**
		 * Used for unknown lengths.
		 */
		public static final int UNKNOWN = -1;

    
		
		/**
		 * Used to represent the size of scalar expressions.
		 */
		public static final Size SCALAR = new Size();

    
		
		protected int[] size;

    
		
		/**
		 * Private constructor that creates a scalar size.
		 */
		private Size() {
			size = new int[0];
		}

    

        /**
         * Constructs a Size with the given lengths.
         */
        public Size(int... size) {
            if (size.length == 0)
                throw new IllegalArgumentException(
                        "Can't create 0-dimensional Size object, use Size.SCALAR instead.");
            this.size = size;
        }

    

		/**
		 * Get the number of dimensions.
		 */
		public int ndims() {
			return size.length;
		}

    
		
		/**
		 * Get length in the <code>i</code>th dimension.
		 */
		public int get(int i) {
			return has(i) ? size[i] : UNKNOWN;
		}

    
		
		/**
		 * Get length in the last dimension.
		 */
		public int last() {
			return get(size.length - 1);
		}

    
		
		/**
		 * Check if this size has an <code>i</code>th dimension.
		 */
		public boolean has(int i) {
			return i >= 0 && i < size.length;
		}

    

        /**
         * Returns the number of elements spanned by this Size.
         * 
         * Only valid if all dimensions are known or currently evaluable.
         */
        public int numElements() {
            return numElements(0);
        }

    

        /**
         * Returns the number of elements spanned by all but the <code>n</code> outermost 
         * dimensions of this Size.
         * 
         * Only valid if all used dimensions are known or currently evaluable.
         */
        public int numElements(int n) {
            int res = 1;
            for (int i = n; i < size.length && res > 0; i++)
                res *= get(i);
            return res < 0 ? 0 : res;
        }

    

        /**
         * True if any dimension is verified to be zero
         */
        public boolean isZero() {
            return !isUnknown() && numElements() == 0;
        }

    
		
		/**
		 * Create a new FArraySubscripts object with ranges spanning this size.
		 */
		public FArraySubscripts rangeFArraySubscripts() {
			FArrayExpSubscripts fas = new FArrayExpSubscripts();
			for (int i = 0; i < size.length; i++)
				fas.addFSubscript(rangeFSubscript(i));
			return fas;
		}

    

        /**
         * Create a new FSubscript for dimension <code>i</code>.
         */
        public FSubscript rangeFSubscript(int i) {
            return size[i] == UNKNOWN ? new FColonSubscript() : new FExpSubscript(new FRangeExp(1, size[i]));
        }

    

		/**
		 * Check if any lengths are unknown.
		 */
		public boolean isUnknown() {
			for (int s : size)
				if (s == UNKNOWN)
					return true;
			return false;
		}

    
		public boolean isUnknownNoEval() {
		    return isUnknown();
		}

    
        
        /**
         * Check if length in dimension d is unknown.
         */
        public boolean isUnknown(int d) {
            return !has(d) || size[d] == UNKNOWN;
        }

    
        
		/**
		 * Check if all lengths have a value (fix length or expression).
		 */
		public boolean isComplete() {
			for (int i = 0; i < size.length; i++)
				if (!hasValue(i))
					return false;
			return true;
		}

    
		
		/**
		 * Check is the length in any dimension equals 0.
		 */
		public boolean isEmpty() {
			for (int i = 0; i < size.length; i++)
				if (read(i) == 0)
					return true;
			return false;
		}

    
		
		/**
		 * Check if a given index fits within this size.
		 * 
		 * Unknown lengths are assumed to be long enough.
		 */
		public boolean isOKIndex(Index i) {
			int[] ind = i.index();
			if (size.length != ind.length)
				return false;
			for (int j = 0; j < size.length; j++) {
				int a = ind[j];
				int b = get(j);
				if (a < 1 || (a > b && b != UNKNOWN))
					return false;
			}
			return true;
		}

    
		
		/**
		 * Check if the lengths in the given dimension has a value (fix length or integer).
		 */
		protected boolean hasValue(int dim) {
			return size[dim] != UNKNOWN;
		}

    
		
		/**
		 * Create a copy of this size.
		 */
		protected Size clone() {
			return (size.length == 0) ? SCALAR : new Size(size.clone());
		}

    
		
		/**
		 * Create a copy of this size as a MutableSize.
		 */
		public MutableSize mutableClone() {
			MutableSize ms = new MutableSize(size.length);
			System.arraycopy(size, 0, ms.size, 0, size.length);
			return ms;
		}

    
		
		/**
		 * Create a copy of this with <code>dim</code> dimensions, if necessary 
		 *        adding dimensions of length 1 to the right side, or removing dimensions 
		 *        from the left side.
		 */
		public Size promote(int dim) {
			if (dim == size.length) 
				return this;
			if (dim == 0)
				return SCALAR;
			Size ns = new Size(new int[dim]);
			int old = dim < size.length ? dim : size.length;
			System.arraycopy(size, size.length - old, ns.size, 0, old);
			Arrays.fill(ns.size, old, dim, 1);
			return ns;
		}

    
		
		/**
		 * If this size contains any dimensions that are represented with expressions, then creates 
		 * and attempts to evaluate a copy of this size. Otherwise, return this.
		 */
		public Size evaluated() {
		    return this;
		}

    
		
		/**
		 * Return a Size that have the same lengths as this size where they are known, 
		 *        and any that are unknown copied from the size of <code>exp</code>. 
		 * 
		 * If the size of <code>exp</code> have more dimensions, the last part is assumed to match this size.
		 */
		public Size createKnown(FExp exp) {
			Size known;
			if (!exp.size().isUnknown() || this instanceof MutableSize) { 
				known = clone();
			} else {
				known = new MutableSize(size.length);
				System.arraycopy(size, 0, known.size, 0, size.length);
			}
			known.fillUnknownFrom(exp);
			return known;
		}

    
		
		/**
		 * Return a Size that have the same lengths as this size where they are known, 
		 * and any that are unknown in this size but known in <code>s</code> is copied from there. 
		 */
		public Size createKnown(Size s) {
			Size known = clone();
			for (int i = 0; i < size.length; i++)
				if (known.size[i] == UNKNOWN && s.size[i] != UNKNOWN)
					known.set(i, s.size[i]);
			return known;
		}

    
		
		/**
		 * Sets length <code>i</code> to <code>s</code>.
		 */
		protected void set(int i, int s) {
			size[i] = s;
		}

    
		
		/**
		 * For each unknown length, copy the equivalent length from size of <code>exp</code>. 
		 * 
		 * If the size of <code>exp</code> have more dimensions than this, the last part is ignored.
		 */
		protected void fillUnknownFrom(FExp exp) {
			Size other = exp.size();
			if (other.size.length >= size.length)
				for (int i = 0; i < size.length; i++) 
					if (!hasValue(i))
						copyFrom(i, exp, i);
		}

    
		
		/**
		 * Copy value of dimension <code>d2</code> in <code>other</code> to dimension 
		 *        <code>d1</code> in <code>this</code>.
		 */
		protected void copyFrom(int d1, FExp exp, int d2) {
			size[d1] = exp.size().size[d2];
		}

    
		
		/**
		 * Check if another object is equal to this one.
		 */
		public boolean equals(Object s) {
			return s instanceof Size && equivalent((Size) s, false);
		}

    
		
		/**
		 * Calculate hash code.
		 */
		public int hashCode() {
			int res = 0;
			for (int i = 0; i < size.length; i++)
				res = (res << 8) ^ size[i];
			return res;
		}

    
		
		/**
		 * Check if another size is equivalent to this one.
		 * 
		 * @param allowUnknown  if <code>true</code>, consider unknown lengths equal to any length, 
		 *                      otherwise consider unknown lengths to differ from all lengths, including
		 *                      other unknown lengths
		 */
		public boolean equivalent(Size s, boolean allowUnknown) {
			return equivalentExcept(s, allowUnknown, -1);
		}

    
		
		/**
		 * Check if another size is equivalent to this one, except in a given dimension.
		 * 
		 * @param allowUnknown  if <code>true</code>, consider unknown lengths equal to any length
		 * @param dim			dimension not to check
		 */
		public boolean equivalentExcept(Size s, boolean allowUnknown, int dim) {
			if (size.length != s.size.length)
				return false;
			for (int i = 0; i < size.length; i++) 
				if (i != dim && !equivalentDim(s, allowUnknown, i, i)) 
					return false;
			return true;
		}

    
		
		/**
		 * Check if a specific dimension of another size is equivalent to a specific 
		 *        dimension of this one.
		 * 
		 * @param allowUnknown  if <code>true</code>, consider unknown lengths equal to any length
		 * @param myDim         the dimension in this Size to compare
		 * @param itsDim        the dimension in the other Size to compare
		 */
		public boolean equivalentDim(Size s, boolean allowUnknown, int myDim, int itsDim) {
			int myLen = read(myDim);
			int itsLen = s.read(itsDim);
			boolean same = myLen == itsLen;
			if (same || !allowUnknown)
				return same;
			return myLen == UNKNOWN || itsLen == UNKNOWN;
		}

    
		
		/**
		 * Make sure that size is final, then get value of size[i].
		 */
		protected int read(int i) {
			return size[i];
		}

    
		
		private static final String SEP = ", ";

    
		
		/**
		 * Returns a string representation on the form "[l1, l2, l3]".
		 */
		public String toString() {
			if (size.length == 0)
				return "scalar";
			StringBuilder buf = new StringBuilder("[");
			String prefix = "";
			for (int i = 0; i < size.length; i++) {
				buf.append(prefix);
				buf.append(toString(i));
				prefix = SEP;
			}
			buf.append("]");
			return buf.toString();
		}

    
		
		/**
		 * Returns a string representation of a single length.
		 */
		protected String toString(int i) {
			return (size[i] == UNKNOWN) ? ":" : Integer.toString(size[i]);
		}

    
		
		/**
		 * Returns a string representation on the form "l1, l2, l3".
		 */
		public String toUnclosedString() {
			String tmp = toString();
			return tmp.substring(1, tmp.length() - 1);
		}

    

        /**
         * Creates a new Size that is a copy of this one, but with dimensions removed 
         * from each side. If nothing is changed, <code>this</code> is returned. 
         * 
         * @param left   the number of dimensions to remove from the left side
         * @param right  the number of dimensions to remove from the right side
         */
        public Size contract(int left, int right) {
            int ndims = size.length - left - right;
            if (ndims == size.length)
                return this;
            if (ndims <= 0)
                return Size.SCALAR;
            int[] ns = new int[ndims];
            System.arraycopy(size, left, ns, 0, ndims);
            return new Size(ns);
        }

    

		/**
		 * Creates a new Size that is a copy of this one, but with dimensions removed 
		 * from the left side. If nothing is changed, <code>this</code> is returned. 
		 * 
		 * @param n   the number of dimensions of the new size
		 */
		public Size contractLeft(int n) {
			return contract(size.length - n, 0);
		}

    
		
		/**
		 * Creates a new Size that is a copy of this one, but with dimensions removed 
		 * from the right side. If nothing is changed, <code>this</code> is returned. 
		 * 
		 * @param n   the number of dimensions of the new size
		 */
		public Size contractRight(int n) {
			return contract(0, size.length - n);
		}

    
		
		/**
		 * Creates a new Size that is a copy of this one, but with one more dimension 
		 * on the left side.
		 * 
		 * @param s  the length of the new dimension
		 */
		public Size expand(int s) {
			int[] ns = new int[size.length + 1];
			ns[0] = s;
			System.arraycopy(size, 0, ns, 1, size.length);
			return new Size(ns);
		}

    
		
        /**
         * Creates a new Size that is a copy of this one, but with one more dimension 
         * on the right side.
         * 
         * @param s  the length of the new dimension
         */
        public Size expandRight(int s) {
            int[] ns = new int[size.length + 1];
            System.arraycopy(size, 0, ns, 0, size.length);
            ns[size.length] = s;
            return new Size(ns);
        }

    

        /**
         * Creates a new Size that is a concatenation of <code>s</code> and this size.
         * 
         * <code>s</code> is added on the left side.
         */
        public Size expand(Size s) {
            return s.createExpanded(s, this);
        }

    

        /**
         * Creates a new Size that is a concatenation of this size and <code>s</code>.
         * 
         * <code>s</code> is added on the right side.
         */
        public Size expandRight(Size s) {
            return s.createExpanded(this, s);
        }

    

        /**
         * Delegate method for expand(Size) and expandRight(Size).
         * 
         * Creates a new size that is the concatenation of a and b.
         */
        protected Size createExpanded(Size a, Size b) {
            int ndims = a.size.length + b.size.length;
            if (ndims == 0)
                return Size.SCALAR;
            int[] ns = new int[ndims];
            System.arraycopy(a.size, 0, ns, 0, a.size.length);
            System.arraycopy(b.size, 0, ns, a.size.length, b.size.length);
            return new Size(ns);
        }

    
        
        /**
         * Create an FArraySubscripts that defines this size as used in variable declarations.
         * 
         * Dimension that nothing is known about get an FColonSubscript.
         */
        public FArraySubscripts createFArraySubscripts() {
            return FArraySubscripts.createFArraySubscripts(createFArraySubscriptsList());
        }

    
        
        public FArraySubscripts createFArrayExpSubscripts() {
            return new FArrayExpSubscripts(createFArraySubscriptsList());
        }

    
        
        private List<FSubscript> createFArraySubscriptsList() {
            List<FSubscript> list = new List<FSubscript>();
            for (int i = 0; i < ndims(); i++) {
                list.add(createFSubscript(i));
            }
            return list;
        }

    
        
        /**
         * Create an FSubscript that defines the length of dimension <code>d</code>.
         * 
         * If nothing is known of the length of the dimension, an FColonSubscript is created.
         */
        public FSubscript createFSubscript(int d) {
            return hasValue(d) ? createFExp(d).createFSubscript() : new FColonSubscript();
        }

    
		
		/**
		 * Create an FArraySubscripts that spans this size.
		 * 
		 * Dimension that nothing is known about get an FColonSubscript.
		 */
		public FArraySubscripts createExpandedFArraySubscripts() {
            List<FSubscript> list = new List<FSubscript>();
            for (int i = 0; i < ndims(); i++) {
                list.add(createExpandedFSubscript(i));
			}
			return FArraySubscripts.createFArraySubscripts(list);
		}

    

        /**
         * Create an FSubscript that spans the length of dimension <code>d</code>.
         * 
         * If nothing is known of the length of the dimension, an FColonSubscript is created.
         */
        public FSubscript createExpandedFSubscript(int d) {
            if (!isUnknown(d)) {
                return createRangeExp(d).createFSubscript();
            } else {
                return new FColonSubscript();
            }
        }

    

        /**
         * Create a range expression spanning this size.
         */
        public FRangeExp createRangeExp(int d) {
            List<FExp> lim = new List<FExp>();
            lim.add(new FIntegerLitExp(1));
            lim.add(createFExp(d));
            return new FRangeExp(lim);
        }

    

		/**
		 * Create an FExp that describes this size.
		 * 
		 * The resulting expression is not expanded like createSizeFExp().
		 */
		public FExp createFExp() {
			List<FExp> cells = new List<FExp>();
			for (int i = 0; i < size.length; i++)
				cells.add(createFExp(i));
			return new FArray(cells);
		}

    
		
		/**
		 * Create an FExp that describes the length of dimension <code>d</code>.
		 * 
		 * The resulting expression is not expanded like createSizeFExp().
		 */
		public FExp createFExp(int d) {
			return new FIntegerLitExp(size[d]);
		}

    
		
        public FExp createFExpForced(int d) {
            return createFExp(d);
        }

    
		
		/**
		 * Create an FExp that describes the number of elements of this size.
		 */
		public FExp createNumElementsFExp() {
			return new FIntegerLitExp(numElements());
		}

    

        /**
         * Create a zero expression of this size.
         */
        public FExp createZeroFExp() {
            if (size.length == 0) {
                return new FIntegerLitExp(0);
            } else {
                return fillDimsOfExp(new FZeros());
            }
        }

    

        /**
         * Add dimensions to an FArrayDimAsArgsExp so that it will have this size 
         * (assuming a scalar expression for fill).
         */
        public FArrayDimAsArgsExp fillDimsOfExp(FArrayDimAsArgsExp exp) {
            for (int i = 0; i < size.length; i++)
                exp.addFExp(createFExp(i));
            return exp;
        }

    

		public FFunctionVariable createFunctionVariable(String name, FType type) {
		    return createFunctionVariable(name, type, TypePrefixInputOutput.NONE);
		}

    
		
		public FFunctionVariable createFunctionVariable(String name, FType type, TypePrefixInputOutput inputOutput) {
		    if (this == Size.SCALAR)
		        return new FFunctionVariable(inputOutput, type.scalarType(), new Opt<FExp>(), new FAccessString(name));
		    else
		        return new FFunctionArray(inputOutput, type.arrayType(this), new Opt<FExp>(), new FAccessString(name));
		}

    public CValue ceval(VariableEvaluator evaluator, int d) {
        int s = get(d);
        return (s == Size.UNKNOWN) ? CValue.UNKNOWN : new CValueInteger(s);
    }

    public Size ceval() {
      return ceval(ASTNode.defaultVariableEvaluator());
  }

    public Size ceval(VariableEvaluator evaluator) {
	  return this;
  }

    public void resetAfterCeval() {
        
    }

    public boolean isCircular() {
		for (int d = 0; d < size.length; d++)
			if (isCircular(d))
				return true;
		return false;
	}

    public boolean isCircular(int d) {
		return false;
	}

    public Size contract(int i) {
        if (has(i)) {
            return contract(i,size.length-i-1);
        } else {
            return Size.SCALAR;
        }
    }

    public Size accessContextSize(FSubscript sub) {
        return this;
    }

    public FExp buildAccessContextSizeExp(FSubscript fs)        { throw new UnsupportedOperationException(); }

    public Size createSizeFExp(InstFunctionCall call) {
        return this;
    }

    public FExp copyReplaceAccess(int d, FExp.ContextReplacer crp) {
        checkDimension(d);
        if (isUnknown(d)) {
            throw new ConstantEvaluationException();
        }
        return new FIntegerLitExp(get(d));
    }

    public void checkDimension(int d) {
        if (d < 0 || d >= ndims() || isCircular(d)) {
            throw new ConstantEvaluationException();
        }
    }

    public Size mergeRecordType(Size other) {
        if (ndims() == 0) {
            return this;
        }
        int[] merged = new int[ndims()];
        for (int i = 0; i < ndims(); i++) {
            int s = get(i);
            if (s != other.get(i)) {
                s = Size.UNKNOWN;
            }
            merged[i] = s;
        }
        return new Size(merged);
    }

    public TypePrefixVariability variability() {
        TypePrefixVariability res = Variability.CONSTANT;
        for (int i = 0; i < ndims(); i++) {
            res = res.combine(variability(i));
        }
        return res;
    }

    public TypePrefixVariability variability(int d) {
        return (size[d] == Size.UNKNOWN) ? Variability.DISCRETE : Variability.CONSTANT;
    }

    public void forceVariability(ErrorCheckType checkType, TypePrefixVariability v) {}

    public void markAsStructuralParameter(ErrorCheckType checkType, FExp src) {}

    public boolean isUndefined() {
      for (int i = 0; i < ndims(); i++) {
          if (size[i] == Size.UNKNOWN) {
              return true;
          }
      }
      return false;
  }

    public void addSizeCheck(Flattener f, List<FStatement> l, InstAssignable n, FAccess access) {
        for (int i = 0; i < ndims(); i++) {
            if (needSizeCheck(i)) {
                String msg = "Mismatching sizes in function '" + n.surroundingInstClass().qualifiedName() +
                        "', component '" + access.toString() + "', dimension '" + (i+1) + "'";
                FAssert call = new FAssert(new FEqExp(flattenFExp(f, i), new FUnknownSizeExp(new FAccessExp(access.treeCopy()), i)), new FStringLitExp(msg), new Opt<FExp>());
                FFunctionCallStmt stmt = new FFunctionCallStmt(new List<FFunctionCallLeft>(), call);
                stmt.shouldBeSorted = true;
                l.add(stmt);
            }
        }
    }

    public boolean needSizeCheck(int i) { return size[i] != UNKNOWN; }

    public Size flatten(Flattener f, ASTNode context, boolean keepSizeExpressions) {
        return this;
    }

    public FArraySubscripts flattenFArraySubscripts(Flattener f) {
        if (ndims() > 0) {
            List<FSubscript> l = new List<FSubscript>();
            for (int i = 0; i < ndims(); i++) {
                l.add(flattenFSubscript(f, i));
            }
            return FArraySubscripts.createFArraySubscripts(l);
        }
        return null;
    }

    public FSubscript flattenFSubscript(Flattener f, int i) {
        int s = get(i);
        return s == Size.UNKNOWN ? new FColonSubscript() : new FIntegerSubscript(s);
    }

    public FSubscript flattenSubscript(int i) {
        return new FExpSubscript(new FRangeExp(new FIntegerLitExp(1),new FIntegerLitExp(get(i))));
    }

    public FArraySubscripts flattenSubscript() {
        if (ndims() == 0) {
            return null;
        }
        List<FSubscript> list = new List<FSubscript>();
        for (int i = 0; i < ndims(); i++) {
            list.add(flattenSubscript(i));
        }
        return FArraySubscripts.createFArraySubscripts(list);
    }

    public FExp flattenFExp(Flattener f, int d) {
        return createFExp(d);
    }

    public boolean isSliceFAS(FExp exp) {
        return isUnknown() || !exp.isLiteral(get(0));
    }

    public void markUsedGlobals(Global.UseType type) {
        
    }

    public Size replaceReferences(AbstractFunctionInliner fi, ASTNode context) {
        return this;
    }

    public Size scalarize(Scalarizer s, FExp context) {
        return this;
    }

    public FExp scalarize(Scalarizer s, int i) {
        return createFExp(i);
    }

    public Size scalarizeInitArray(Scalarizer.Algorithm s, ASTNode context) {
        return this;
    }

    public void createArrayTemporaries(Scalarizer s, int i) {
        
    }

    public void sizeAsserts(Collection<FAssert> asserts, Size other, FExp context) {
        Size l = evaluated();
        other = other.evaluated();
        for (int i = 0; i < l.size.length; i++) {
            if (l.size[i] != UNKNOWN && other.size[i] == UNKNOWN) {
                FAssert a = new FAssert(
                        context.orNotIfExpConds(new FEqExp(other.createFExp(i), l.createFExp(i))),
                        new FStringLitExp("Mismatching sizes in " + context.containingFFunctionDecl().name()), new Opt<FExp>());
                asserts.add((FAssert)context.dynamicFExp(a));
            }
        }
    }

    public Set<String> sortingAddNamesUsed(Set<String> set) {
        return set;
    }

    public void printNumElements_C(CodePrinter p, CodeStream str, String indent, TypePrintable_C src) {
        str.print(numElements());
    }

    public void printDimensions_C(CodePrinter p, CodeStream str, String indent, TypePrintable_C src) {
        str.print(toUnclosedString());
    }

    public void printNumElements_C(CodePrinter p, CodeStream str, String indent, String name) {
        printDimsWithSep_C(p, str, indent, name, " * ");
    }

    public void printDimensions_C(CodePrinter p, CodeStream str, String indent, String name) {
        printDimsWithSep_C(p, str, indent, name, ", ");
    }

    private void printDimsWithSep_C(CodePrinter p, CodeStream str, String indent, String name, String sep) {
        printSize_C(p, str, indent, name, 0);
        for (int i = 1; i < ndims(); i++) {
            str.print(sep);
            printSize_C(p, str, indent, name, i);
        }
    }

    public void printSize_C(CodePrinter p, CodeStream str, String indent, String name, int dim) {
        str.print("jmi_array_size(", name, p.sep(), dim, ")");
    }

    public void printSize_C(CodePrinter p, CodeStream str, String indent, FExp e, int dim) {
        str.print("jmi_array_size(");
        p.print(e, str, indent);
        str.print(p.sep(), dim, ")");
    }

    public void print(CodePrinter.StepPrinter p, CodeStream str, String indent) {}


}
