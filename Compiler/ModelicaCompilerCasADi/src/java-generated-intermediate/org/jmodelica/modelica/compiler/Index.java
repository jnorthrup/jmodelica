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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:3891
 */
public class Index extends java.lang.Object implements Cloneable {
    
		
		public static final Index NULL = new Index(0);

    
		
		protected int[] index;

    
		
		/**
		 * Construct an Index representing the indices given in <code>ind</code>.
		 */
		public Index(int[] ind) {
			index = ind;
		}

    
		
		/**
		 * Returns the indices that specify this cell.
		 */
		public int[] index() {
			return index;
		}

    
		
		/**
		 * Returns the number of dimensions of this Index.
		 */
		public int ndims() {
			return index.length;
		}

    
		
		/**
		 * Returns the index for the first dimension.
		 */
		public int first() {
			return index.length > 0 ? index[0] : -1;
		}

    
		
		/**
		 * Returns the index for the last dimension.
		 */
		public int last() {
			return index.length > 0 ? index[index.length - 1] : -1;
		}

    
		
		/**
		 * Returns the index for the <code>i</code>th dimension (zero-based).
		 */
		public int get(int i) {
			return index[i];
		}

    
		
		/**
		 * Sets the index for the <code>i</code>th dimension (zero-based).
		 */
		public void set(int i, int index) {
			this.index[i] = index;
		}

    
		
		/**
		 * Compare two Index for equality.
		 */
		public boolean equals(Object i) {
			return (i instanceof Index) && Arrays.equals(index, ((Index) i).index);
		}

    
		
		/**
		 * Calculate hash code.
		 * 
		 * Creates perfect hash when ndims() <= 3 and all indices are <= 1023.
		 */
		public int hashCode() {
			int shift = index.length <= 3 ? 10 : 5;
			int res = 0;
			for (int i = 0; i < index.length; i++)
				res = (res << shift) ^ index[i];
			return res;
		}

    
		
		/**
		 * Returns an Index that describes the last <code>ndims() - level</code> dimensions 
		 * of this Index.
		 * 
		 * @param level  the first index to copy. Must be between 0 and ndims(), inclusive.
		 */
		public Index subIndex(int level) {
			return partIndex(level, index.length);
		}

    
        
        /**
         * Returns an Index that describes dimensions from <code>i</code>, inclusively, 
         * to <code>j</code>, excludingly, of this Index.
         * 
         * @param i  the first index to copy. Must be between 0 and ndims(), inclusively.
         * @param j  the index after the last to copy. Must be between <code>i</code> and ndims(), inclusively.
         */
        public Index partIndex(int i, int j) {
            if (i == 0 && j == index.length)
                return this;
            if (i == j)
                return NULL;
            Index copy = new Index(j - i);
            System.arraycopy(index, i, copy.index, 0, copy.index.length);
            return copy;
        }

    
		
		/**
		 * Creates a new Index that is a copy of this Index, but promoted to <code>ndims</code> 
		 * dimensions by adding ones to the end.
		 * 
		 * The new Index will not be bound to any Indices object.
		 */
		public Index promote(int ndims) {
			return adjusted(0, 0, ndims);
		}

    
		
		/**
		 * Creates a new Index that is a copy of this Index, but with <code>adj</code>
		 *        added to dimension <code>dim</code> and promoted to <code>ndims</code> 
		 *        dimensions by adding ones to the end.
		 * 
		 * The new Index will not be bound to any Indices object.
		 */
		public Index adjusted(int dim, int adj, int ndims) {
			Index copy = new Index(new int[ndims]);
			System.arraycopy(index, 0, copy.index, 0, index.length);
			Arrays.fill(copy.index, index.length, ndims, 1);
			copy.index[dim] += adj;
			return copy;
		}

    
		
		/**
		 * Create a new FArraySubscripts object describing this index.
		 */
		public FArraySubscripts createFArraySubscripts() {
			return new FArrayLitSubscripts(index);
		}

    
		
		/**
		 * Copies this Index. Always use clone() when saving an Index.
		 */
		public Index clone() {
			try {
				Index i = (Index) super.clone();
				i.index = index.clone();
				return i;
			} catch (CloneNotSupportedException e) {
				return null;
			}
		}

    
		
		/**
		 * Returns an Index that is the result of appending <code>i</code> to this Index.
		 * 
		 * @param i  the Index to append.
		 */
		public Index expand(Index i) {
			if (index.length == 0)
				return i;
			if (i.index.length == 0)
				return this;
			Index expanded = new Index(index.length + i.index.length);
			System.arraycopy(index, 0, expanded.index, 0, index.length);
			System.arraycopy(i.index, 0, expanded.index, index.length, i.index.length);
			return expanded;
		}

    
		
		/**
		 * Return a string representation on the form "[i1,i2,i3]".
		 */
		public String toString() {
			return buildString(new StringBuilder("[")).append(']').toString();
		}

    
		
		/**
		 * Return a string representation on the form "i1,i2,i3".
		 */
		public String toUnclosedString() {
			return buildString(new StringBuilder()).toString();
		}

    
		
		/**
		 * Internal implementation of toString methods.
		 * 
		 * Note that this must give the same result as a prettyPrint() on an equivalent 
		 * FArraySubscripts, or inlining breaks.
		 */
		private StringBuilder buildString(StringBuilder buf) {
			boolean sep = false;
			for (int i : index) {
				if (sep)
					buf.append(',');
				buf.append(i);
				sep = true;
			}
			return buf;
		}

    
		
		
		/**
		 * Return the internal index in an Array of the cell this Index refers to.
		 *        Only for use from Array.
		 * 
		 * @param ind  the indices to resolve the internal index with
		 */
		public int internal(Indices ind) {
			return ind.internal(this);
		}

    
		
		/**
		 * Construct an empty Index.
		 */
		protected Index() {
		}

    
		
		/**
		 * Construct an Index of ndims dimensions, 
		 *        pointing at the spot before the first cell.
		 */
		protected Index(int ndims) {
			index = new int[ndims];
			for (int i = ndims - 2; i >= 0; i--)
				index[i] = 1;
			if (ndims > 0)
				index[ndims - 1] = 0;
		}

    public void setValues(Iterable<? extends CommonForIndex> forIndices) {
        int i = 0;
        for (CommonForIndex fi : forIndices) {
            fi.setEvaluationValue(new CValueInteger(index[i++]));
        }
    }


}
