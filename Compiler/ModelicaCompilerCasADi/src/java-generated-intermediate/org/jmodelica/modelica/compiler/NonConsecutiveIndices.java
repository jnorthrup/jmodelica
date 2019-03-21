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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:4365
 */
public class NonConsecutiveIndices extends Indices {
    
		// The indices are stored as a list of integer arrays.
		protected ArrayList<int[]> indices;

     
		protected Index trans;

    
		protected boolean[] trim;

    
		
		/**
		 * Create a NonConsecutiveIndices object based on FArraySubcripts.
		 *        Use Indices.create(FArraySubscripts fas).
		 */
        public static NonConsecutiveIndices createFromFas(FArraySubscripts fas) {
			int n = fas.numSubscript();
			ArrayList<int[]> ind = new ArrayList<int[]>(n);
			boolean[] trim = new boolean[n];
            createFromFas(Collections.singleton(fas), ind, trim);
			return new NonConsecutiveIndices(ind, trim, 0);
		}

    
		
		/**
		 * Create a NonConsecutiveIndices object based on a list of FArraySubcripts.
		 *        Use Indices.create(ArrayList<FArraySubscripts> fasl).
		 */
		public static NonConsecutiveIndices createFromFas(java.util.List<FArraySubscripts> fasl) {
			int n = 0;
			for (FArraySubscripts fas : fasl)
				n += fas.numSubscript();
			ArrayList<int[]> ind = new ArrayList<int[]>(n);
			boolean[] trim = new boolean[n];
            createFromFas(fasl, ind, trim);
			return new NonConsecutiveIndices(ind, trim, 0);
		}

    
        
        private static void createFromFas(Iterable<FArraySubscripts> fasl, ArrayList<int[]> ind, boolean[] trim) {
            int i = 0;
            for (FArraySubscripts fas : fasl) {
                for (Subscript s : fas.subscripts()) { 
                    ind.add(s.myIndices());
                    trim[i++] = s.ndims() == 0;
                }
            }
        }

    
        
        /**
         * Create a NonConsecutiveIndices object based on a list of int arrays
         *        Use Indices.create(ArrayList<int[]> ind).
         * 
         * @param ind   one array for each dimension, containing the indices to span for that dimension.
         * @param trim  remove dimensions that only span one index.
         */
        public static NonConsecutiveIndices create(ArrayList<int[]> ind, boolean trim) {
            boolean[] trims = new boolean[ind.size()];
            for (int i = 0; i < trims.length; i++)
                trims[i] = trim && ind.get(i).length == 1;
            return new NonConsecutiveIndices(ind, trims, 0);
        }

    

        /**
         * Create a NonConsecutiveIndices object based on a Size, an array of dimensions to trim, 
         * and a number of extra dimensions to add to the end.
         */
        public static NonConsecutiveIndices create(Size s, int[] dim, int extra) {
            int n = s.ndims();
            ArrayList<int[]> ind = new ArrayList<int[]>(n);
            boolean[] trims = new boolean[n];
            for (int i = 0; i < n; i++) {
                ind.add(new int[] { 1 });
                trims[i] = true;
            }
            for (int d : dim) {
                if (d < n) {
                    int[] ii = new int[s.get(d)];
                    for (int i = 0; i < ii.length; i++)
                        ii[i] = i + 1;
                    ind.set(d, ii);
                    trims[d] = false;
                }
            }
            return new NonConsecutiveIndices(ind, trims, extra);
        }

    

		/**
		 * Translates an Index to the corresponding Index in the underlying 
		 * expression.
		 */
		public Index translate(Index i) {
			int[] ii = i.index();
			int[] ti = trans.index();
			for (int ji = 0, jt = 0; ji < ndims && jt < ti.length; ji++, jt++) {
				while (trim[jt]) 
					jt++;
				ti[jt] = indices.get(jt)[ii[ji] - 1];
			}
			return trans;
		}

    

		
		/**
		 * Internal constructor to create a NonConsecutiveIndices object based on a 
		 * list of int arrays containing the used indexes on the underlying array.
		 * 
		 * @param trim   the dimensions to remove
		 * @param extra  number of extra dimensions of length 1 to add
		 */
		protected NonConsecutiveIndices(ArrayList<int[]> ind, boolean[] trim, int extra) {
			super(getSize(ind, trim, extra));
			this.trim = trim;
			indices = ind;
			trans = new Index(ind.size());
			for (int i = 0; i < ind.size(); i++)
				if (indices.get(i).length > 0)
					trans.index()[i] = indices.get(i)[0];
		}

    
		
		/**
		 * Calculate size for this indices from a list of int arrays containing the 
		 * used indexes on the underlying array.
		 */
		protected static Size getSize(ArrayList<int[]> ind, boolean[] trim, int extra) {
			int n = 0;
			for (boolean tr : trim)
				if (!tr)
					n++;
            if (n == 0) {
                return Size.SCALAR;
            }
			MutableSize size = new MutableSize(n + extra);
			for (int i = 0; i < trim.length; i++)
				if (!trim[i])
					size.append(ind.get(i).length);
			for (int i = 0; i < extra; i++)
				size.append(1);
			return size;
		}

    
		
        /**
         * Create a new Indices object with the earlier active dimensions (trim=false)
         * specified by the corresponding position in index and the earlier inactive
         * dimensions enabled.
         */
        public NonConsecutiveIndices locked(Index index, boolean[] b) {
            ArrayList<int[]> newInd = new ArrayList<int[]>();
            boolean[] newTrim = new boolean[indices.size()];
            index = translate(index);
            for (int k = 0; k < indices.size(); k++) {
                if (trim[k]) {
                    newInd.add(indices.get(k));
                } else {
                    int[] t = new int[1];
                    t[0] = index.index()[k];
                    newInd.add(t);
                }
                b[k] = trim[k];
                newTrim[k] = false;
            }
            return new NonConsecutiveIndices(newInd, newTrim, 0);
        }

    
        
        /**
         * Create a new Indices object with the earlier inactive dimensions 
         * enabled and replaced using the surrounding size for the corresponding
         * dimension in fas. 
         */
        public static NonConsecutiveIndices expIndices(Size s, FArraySubscripts fas) {
            int n2 = s.ndims();
            int n1 = n2 - fas.ndims();
            ArrayList<int[]> newInd = new ArrayList<int[]>();
            boolean[] newTrim = new boolean[n2];
            for (int k = 0; k < n1; k++) {
                newInd.add(ASTNode.range(s.get(k)));
                newTrim[k] = false;
            }
            fas.expIndices(newInd, newTrim, n1);
            return new NonConsecutiveIndices(newInd, newTrim, 0);
        }

    
        
        /**
         * Create a new Indices object with the earlier inactive dimensions 
         * enabled and replaced using subscript size for the corresponding
         * dimension in fas. Earlier active dimensions are disabled.
         */
        public static NonConsecutiveIndices fasIndices(FArraySubscripts fas) {
            ArrayList<int[]> newInd = new ArrayList<int[]>();
            boolean[] newTrim = new boolean[fas.numSubscript()];
            for (int k = 0; k < newTrim.length; k++) {
                Subscript fs = fas.subscript(k);
                if (fs.ndims() == 0 || fs.variability().indexParameterOrLess()) {
                    newInd.add(new int[0]);
                    newTrim[k] = true;
                } else {
                    newInd.add(ASTNode.range(fs.size().numElements()));
                    newTrim[k] = false;
                }
            }
            return new NonConsecutiveIndices(newInd, newTrim, 0);
        }


}
