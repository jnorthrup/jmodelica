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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2992
 */
public class MutableSize extends Size {
    
		
		private int i;

    
		private FExp[] exps;

    
		private boolean[] evaluated;

    
		
		/**
		 * Constructs a new mutable Size of <code>ndims</code> dimensions.
		 */
		public MutableSize(int ndims) {
			super(new int[ndims]);
			Arrays.fill(size, UNKNOWN);
			exps = new FExp[ndims];
			i = 0;
			evaluated = new boolean[ndims];
		}

    
		
		/**
		 * Constructs the size descrived by a vector expression.
		 */
		public MutableSize(FExp exp) {
			this(exp.ndims() == 1 ? exp.size().get(0) : 0);
			for (FExp dim : exp.getArray().iterable())
				append(dim);
		}

    
		
		/**
		 * Sets the next length to <code>s</code>.
		 * 
		 * May overwrite lengths set with <code>set()</code>.
		 */
		public void append(int s) {
			set(i++, s);
		}

    
		
		/**
		 * Sets the next length to the value of <code>e</code>.
		 * 
		 * May overwrite lengths set with <code>set()</code>.
		 */
		public void append(FExp e) {
			set(i++, e);
		}

    
		
		/**
		 * Sets the next length to the length of dimension <code>d</code> 
		 *        of <code>s</code>.
		 * 
		 * May overwrite lengths set with <code>set()</code>.
		 */
		public void append(Size s, int d) {
			set(i++, s, d);
		}

    
		
		/**
		 * Sets the next <code>s.ndims()</code> lengths from <code>s</code>.
		 * 
		 * May overwrite lengths set with <code>set()</code>.
		 */
		public void append(Size s) {
			if (s instanceof MutableSize) {
				MutableSize ms = (MutableSize) s;
				for (int j = 0; j < ms.size.length; j++, i++) {
					exps[i] = ms.exps[j];
					size[i] = ms.size[j];
				}
			} else {
				for (int si : s.size) {
					size[i++] = si;
				}
			}
		}

    
		
		/**
		 * Sets length <code>i</code> to <code>s</code>.
		 */
		public void set(int i, int s) {
			size[i] = s;
		}

    

        /**
         * Sets length <code>d</code> to the value of <code>e</code>.
         */
        public void set(int d, FExp e) {
            int s = UNKNOWN;
            if (okExp(e) && e.hasOnlyLiterals()) {
                try {
                    CValue val = e.ceval();
                    if (val.hasIntValue()) {
                        s = val.intValue();
                    }
                } catch (ConstantEvaluationException cee) {
                }
            }
            size[d] = s;
            exps[d] = (s == UNKNOWN) ? e : null;
        }

    

        /**
         * Sets length <code>d1</code> to the length of dimension <code>d2</code> 
         *        of <code>s</code>.
         * 
         * May overwrite lengths set with <code>set()</code>.
         */
        public void set(int d1, Size s, int d2) {
            if (d2 >= s.size.length) {
                size[d1] = -1;
                exps[d1] = null;
            } else {
                size[d1] = s.size[d2];
                exps[d1] = (s instanceof MutableSize) ? ((MutableSize) s).exps[d2] : null;
            }
        }

    

        /**
         * Make sure dimension i of size is ready to use.
         */
        private void evaluate(int i) {
            if (i >= 0 && i < evaluated.length && !evaluated[i]) {
                evaluated[i] = true;
                if (exps[i] != null) {
                    try {
                        CValue val = exps[i].ceval();
                        if (val.hasIntValue()) {
                            size[i] = val.intValue();
                        }
                    } catch (ConstantEvaluationException e) {
                    }
                }
            }
        }

    

		/**
		 * Make sure size is ready to use.
		 */
		private void evaluate() {
			for (int i = 0; i < size.length; i++) 
				evaluate(i);
		}

    
		
		/**
		 * Adds <code>s</code> to length <code>d</code>.
		 */
		public void add(int d, int s) {
            if (size[d] == Size.UNKNOWN || s == Size.UNKNOWN) {
                size[d] = Size.UNKNOWN;
            } else {
                size[d] = size[d] + s;
            }
        }

    

        /**
         * Adds the value of <code>e</code> to length <code>d</code>.
         */
        public void add(int d, FExp e) {
            boolean ok = false;
            try {
                CValue val = e.ceval();
                if (val.hasIntValue()) {
                    add(d, val.intValue());
                    ok = true;
                }
            } catch (ConstantEvaluationException cee) {}
            if (!ok) {
                FExp e2 = new FAddExp(createFExp(d), e.createSizeFExp());
                exps[d] = e.dynamicFExp(e2);
                size[d] = UNKNOWN;
            }
        }

    

		/**
		 * Adds the length of dimension <code>d2</code> of <code>s</code> 
		 *        to length <code>d1</code> of this size.
         *
         * Adds both expressions and evaluated sizes.
		 */
		public void add(int d1, Size s, int d2) {
            addFExp(d1, s, d2);
            add(d1, s.size[d2]);
		}

    
		
        /**
         * If there is an expression in dimension <code>d1</code> of <code>this</code> or 
         * dimension <code>d2</code> of size <code>s</code>, add the two size representations 
         * into a new <code>FExp</code> in <code>this</code>.
         */
        protected void addFExp(int d1, Size s, int d2) {
            FExp n = null;
            if (hasFExp(d1)) {
                n = getFExp(d1);
            } else if (s instanceof MutableSize) {
                MutableSize ms = (MutableSize) s;
                if (ms.hasFExp(d2)) {
                    n = ms.getFExp(d2);
                }
            }
            
            if (n == null) {
                return;
            }
            
            FExp e = new FAddExp(createFExpForced(d1), s.createFExpForced(d2));
            exps[d1] = n.dynamicFExp(e);
        }

    
        
        /**
         * Returns true if there is an FExp representing size in 
         * dimension <code>d</code>, else false.
         */
        protected boolean hasFExp(int d) {
            return exps[d] != null;
        }

    
        
        /**
         * Get the FExp representing size in dimension <code>d</code>.
         * It might be null.
         */
        protected FExp getFExp(int d) {
            return exps[d];
        }

    

        /**
         * Get length in the <code>i</code>th dimension.
         */
        public int get(int i) {
            evaluate(i);
            if (i < 0 || i >= size.length)
                return UNKNOWN;
            if (size[i] != Size.UNKNOWN) // We want to evaluate FColonSizeExps as well
                return size[i];
            try {
                if (exps[i] != null)
                    return exps[i].ceval().intValue();
            } catch (ConstantEvaluationException e) {
            }
            return UNKNOWN;
        }

    

		/**
		 * Check if the lengths in the given dimension has a value (fix length or integer).
		 */
		protected boolean hasValue(int dim) {
            return size[dim] != UNKNOWN || okExp(dim);
		}

    
		
        /**
         * Check if an expression is valid.
         */
        protected static boolean okExp(FExp e) {
            return okExp(e, false);
        }

    
        
        protected boolean okExp(int i) {
            return okExp(i, false);
        }

    
        
        protected static boolean okExp(FExp e, boolean allowUnknownSize) {
            return e != null && e.isValidExp(allowUnknownSize);
        }

    
        
        protected boolean okExp(int i, boolean allowUnknownSize) {
            return size[i] == Size.UNKNOWN && okExp(exps[i], allowUnknownSize);
        }

    
		
		/**
		 * Copy value of dimension <code>d2</code> in size of <code>exp</code> to dimension 
		 *        <code>d1</code> in <code>this</code>.
		 */
		protected void copyFrom(int d1, FExp exp, int d2) {
			set(d1, exp.size(), d2);
            if (exps[d1] != null && exps[d1] instanceof FColonSizeExp) {
                exps[d1] = exp.dynamicFExp(exps[d1].createSizeFExp());
            }
			if (!hasValue(d1)) {
				FExp copyExp = exp.fullCopy();
				Opt dimExp = new Opt(new FIntegerLitExp(d2 + 1));
				FSizeExp sizeExp  = new FSizeExp(copyExp, dimExp);
				exps[d1] = exp.dynamicFExp(sizeExp);
			}
		}

    
		
		/**
		 * Creates a new Size that is a copy of this one, but with dimensions removed 
		 * from each side.
		 * 
		 * @param left   the number of dimensions to remove from the left side
		 * @param right  the number of dimensions to remove from the right side
		 */
		public Size contract(int left, int right) {
			int ndims = size.length - left - right;
			if (ndims == 0)
				return Size.SCALAR;
			MutableSize ns = new MutableSize(ndims);
			System.arraycopy(size, left, ns.size, 0, ndims);
			System.arraycopy(exps, left, ns.exps, 0, ndims);
			return ns;
		}

    
		
		/**
		 * Creates a new Size that is a copy of this one, but with one more dimension 
		 * on the left side.
		 * 
		 * @param s  the length of the new dimension
		 */
		public Size expand(int s) {
			evaluate();
			MutableSize ns = new MutableSize(size.length + 1);
			ns.size[0] = s;
			ns.exps[0] = null;
			System.arraycopy(size, 0, ns.size, 1, size.length);
			System.arraycopy(exps, 0, ns.exps, 1, size.length);
			return ns;
		}

    

        /**
         * Creates a new Size that is a concatenation of <code>s</code> and this size.
         * 
         * <code>s</code> is added on the left side.
         */
        public Size expand(Size s) {
            return createExpanded(s, this);
        }

    

        /**
         * Creates a new Size that is a concatenation of this size and <code>s</code>.
         * 
         * <code>s</code> is added on the right side.
         */
        public Size expandRight(Size s) {
            return createExpanded(this, s);
        }

    

        /**
         * Delegate method for expand(Size) and expandRight(Size). Creates a new size tyhat is the concatenation of a and b.
         */
        protected Size createExpanded(Size a, Size b) {
            int ndims = a.size.length + b.size.length;
            if (ndims == 0)
                return Size.SCALAR;
            MutableSize ns = new MutableSize(ndims);
            if (a instanceof MutableSize) {
                MutableSize m = (MutableSize) a;
                m.evaluate();
                System.arraycopy(m.exps, 0, ns.exps, 0, m.size.length);
            }
            if (b instanceof MutableSize) {
                MutableSize m = (MutableSize) b;
                m.evaluate();
                System.arraycopy(m.exps, 0, ns.exps, a.size.length, m.size.length);
            }
            System.arraycopy(a.size, 0, ns.size, 0, a.size.length);
            System.arraycopy(b.size, 0, ns.size, a.size.length, b.size.length);
            return ns;
        }

    
        
		/**
		 * Create an FExp that describes the length of dimension <code>d</code>.
		 * 
		 * the resulting expression is not expanded like createSizeFExp().
		 */
		public FExp createFExp(int d) {
			evaluate(d);
            return (okExp(d, true)) ?
					exps[d].createSizeFExp() : 
					super.createFExp(d);
		}

    
        
        /**
         * Create an FExp that describes the length of dimension <code>d</code>.
         * 
         * Uses the FExp even if there is an evaluated size.
         */
        public FExp createFExpForced(int d) {
            return (hasFExp(d)) ?
                    getFExp(d).createSizeFExp() : 
                    super.createFExpForced(d);
        }

    
        
		/**
		 * Create an FExp that describes the number of elements of this size.
		 */
		public FExp createNumElementsFExp() {
			evaluate();
			int known = 1;
			FExp res = null;
			for (int i = 0; i < size.length; i++) {
				// TODO: this will fail if hasValue(i) == false
				if (size[i] == UNKNOWN) {
					FExp e = exps[i].unboundCopy();
					res = (res == null) ? e : new FMulExp(res, e);
				} else {
					known *= size[i];
				}
			}
			if (res == null)
				res = new FIntegerLitExp(known);
			else if (known > 1)
				res = new FMulExp(res, new FIntegerLitExp(known));
			return res;
		}

    

		/**
         * If this size contains any dimensions that are represented with expressions, then creates 
         * and attempts to evaluate a copy of this size. Otherwise, return this.
         */
        public Size evaluated() {
            boolean copy = false;
            for (FExp e : exps)
                if (e != null)
                    copy = true;
            if (copy) {
                MutableSize res = new MutableSize(size.length);
                System.arraycopy(size, 0, res.size, 0, size.length);
                System.arraycopy(exps, 0, res.exps, 0, exps.length);
                res.evaluate();
                return res;
            } else {
                return this;
            }
        }

    
        
        /**
         * Create a new FSubscript with a range spanning dimension <code>i</code>.
         */
        public FSubscript rangeFSubscript(int i) {
            evaluate(i);
            return !okExp(i) ? super.rangeFSubscript(i) : 
                new FExpSubscript(new FRangeExp(new FIntegerLitExp(1), exps[i].fullCopy()));
        }

    

		/**
		 * Returns a string representation of a single length.
		 */
		protected String toString(int i) {
			evaluate(i);
            return !okExp(i) ? super.toString(i) : exps[i].prettyPrint("");
		}

    
		
		/**
		 * Create a copy of this size.
		 */
		protected MutableSize clone() {
			MutableSize ms = new MutableSize(size.length);
			System.arraycopy(size, 0, ms.size, 0, size.length);
			System.arraycopy(exps, 0, ms.exps, 0, exps.length);
			ms.evaluated = evaluated;
			return ms;
		}

    
		
		/**
		 * Create a copy of this size as a MutableSize.
		 */
		public MutableSize mutableClone() {
			return clone();
		}

    
		
		/**
		 * Create a copy of this with <code>dim</code> dimensions, if necessary 
		 *        adding dimensions of length 1 to the right side, or removing dimensions 
		 *        from the left side.
		 */
		public Size promote(int dim) {
			evaluate();
			if (dim == size.length) 
				return this;
			if (dim == 0)
				return SCALAR;
			MutableSize ns = new MutableSize(dim);
			int old = dim < size.length ? dim : size.length;
			System.arraycopy(size, size.length - old, ns.size, 0, old);
			System.arraycopy(exps, exps.length - old, ns.exps, 0, old);
			Arrays.fill(ns.size, old, dim, 1);
			return ns;
		}

    
		
		/**
		 * Make sure that size is final, then get value of size[i].
		 */
		protected int read(int i) {
			evaluate(i);
			return size[i];
		}

    
		
		public boolean isUnknown() {
			evaluate();
			return super.isUnknown();
		}

    
		
        @Override
        public boolean isUnknownNoEval() {
            return super.isUnknown();
        }

    public Size ceval(VariableEvaluator evaluator) {
	  int[] ns = size.clone();
	  for (int i = 0; i < size.length; i++) 
		  if (size[i] == UNKNOWN && exps[i] != null) 
			  ns[i] = exps[i].ceval(evaluator).intValue();
	  return new Size(ns);
  }

    public void resetAfterCeval() {
        for (int i = 0; i < exps.length; i++) {
            if (exps[i] != null) {
                exps[i].resetAfterCeval();
                evaluated[i] = false;
                size[i] = Size.UNKNOWN;
            }
        }
    }

    public boolean isCircular(int d) {
		try {
			return size[d] == UNKNOWN && exps[d] != null && exps[d].isCircular();
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

    public Size accessContextSize(FSubscript sub) {
        if (isCircular(0) || size[0] != Size.UNKNOWN) {
            return super.accessContextSize(sub);
        }
        MutableSize ms = new MutableSize(1);
        ms.set(0, sub.getAccessContextSizeExp());
        return ms;
    }

    public FExp buildAccessContextSizeExp(FSubscript fs) {
        if (exps[0] == null || exps[0] instanceof FColonSizeExp) {
            return new FUnknownSizeExp(fs.buildAccessContextSizeExp(), fs.myDim());
        }
        return exps[0].copyReplaceAccess(new FExp.SizeContextReplacer(fs));
    }

    @Override
    public Size createSizeFExp(InstFunctionCall call) {
        
        for (InstFunctionArgument ifa : call.getArgs()) {
         // Cash sizes to prevent false circularity in nested function calls
            ifa.size(); 
        }
        
        MutableSize ms = new MutableSize(ndims());
        FExp.FunctionSizeContextReplacer crp = new FExp.FunctionSizeContextReplacer(call.inputArgMap());
        for (int j = 0; j < ndims(); j++) {
            try {
                FExp exp = copyReplaceAccess(j, crp);
                if(!call.inFunction()) {
                    exp = new FNoEventExp(exp);
                }
                ms.append(call.dynamicFExp(exp));
            } catch (ConstantEvaluationException e) {
                ms.append(Size.UNKNOWN);
            }
        }
        return ms;
    }

    public FExp copyReplaceAccess(int d, FExp.ContextReplacer crp) {
        checkDimension(d);
        FExp exp = exps[d];
        if (exp == null || exp.variability().knownParameterOrLess()) {
            evaluate(d);
            return super.copyReplaceAccess(d, crp);
        } else {
            return exps[d].copyReplaceAccess(crp);
        }
    }

    public TypePrefixVariability variability(int d) {
        return (exps[d] != null) ? getFExp(d).variability() : super.variability(d);
    }

    public void forceVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        for (FExp e : exps) {
            if (e != null) {
                e.forceVariability(checkType, v);
            }
        }
    }

    public void markAsStructuralParameter(ErrorCheckType checkType, FExp src) {
        if (src.errorCheckUnknownSize()) {
            for (int i = 0; i < ndims(); i++) {
                FExp exp = exps[i];
                if (exp != null) {
                    exp.markAsStructuralParameter(checkType);
                    if (!exp.variability().parameterOrLess()) {
                        ASTNode.NON_PARAMETER_SIZE_IN_EXPRESSION.invoke(src, exp, i, src);
                    }
                }
            }
        }
    }

    public boolean isUndefined() {
      for (int i = 0; i < ndims(); i++) {
          if (size[i] == Size.UNKNOWN && (exps[i] == null || exps[i] instanceof FColonSizeExp)) {
              return true;
          }
      }
      return false;
  }

    public boolean needSizeCheck(int i) { return (exps[i] != null && !(exps[i] instanceof FColonSizeExp)) || super.needSizeCheck(i); }

    public List<FExp> flattenExps(Flattener f) {
        List<FExp> l = new List<FExp>();
        for (int i = 0; i < exps.length; i++) {
            if (shouldFlattenChild(i)) {
                l.add(exps[i].flatten(f));
            }
        }
        return l;
    }

    public boolean shouldFlattenChild(int i) {
        return exps[i] != null && !(exps[i] instanceof FColonSizeExp) && 
                (size[i] == Size.UNKNOWN || !exps[i].inFunction());
    }

    public MutableSize flatten(Flattener f, ASTNode context, boolean keepSizeExpressions) {
        MutableSize res = new MutableSize(size.length);
        System.arraycopy(size, 0, res.size, 0, size.length);
        if (keepSizeExpressions) {
            for (int i = 0; i < exps.length; i++) {
                if (shouldFlattenChild(i)) {
                    res.exps[i] = context.affixExpression(exps[i].flatten(f));
                }
            }
        }
        return res;
    }

    public FSubscript flattenFSubscript(Flattener f, int i) {
        if (exps[i] == null || exps[i] instanceof FColonSizeExp ||
                exps[i].variability().knownParameterOrLess()) {
            return super.flattenFSubscript(f, i);
        }
        return exps[i].flatten(f).createFSubscript();
    }

    public FSubscript flattenSubscript(int i) {
        if (isUnknown()) {
            return new FColonSubscript();
        } else {
            return super.flattenSubscript(i);
        }
    }

    public FExp flattenFExp(Flattener f, int d) {
        if (exps[d] != null) {
            return exps[d].flatten(f);
        } else {
            return super.flattenFExp(f, d);
        }
    }

    @Override
    public void markUsedGlobals(Global.UseType type) {
        for (FExp e : exps)
            if (e != null)
                e.markUsedGlobals(type);
    }

    public MutableSize replaceReferences(AbstractFunctionInliner fi, ASTNode context) {
        MutableSize res = clone();
        for (int i = 0; i < exps.length; i++)
            if (res.exps[i] != null) {
                res.exps[i] = exps[i].dynamicFExp(exps[i].fullCopy()).replaceReferences(fi);
                res.exps[i].setParent(context);
            }
        return res;
    }

    @Override
    public Size scalarize(Scalarizer s, FExp context) {
        MutableSize res = new MutableSize(ndims());
        for (int i = 0; i < exps.length; i++) {
            res.size[i] = size[i];
            if (exps[i] != null) {
                res.exps[i] = exps[i].scalarize(s);
                context.dynamicFExp(res.exps[i]);
            }
        }
        return res;
    }

    @Override
    public FExp scalarize(Scalarizer s, int i) {
        if (exps[i] != null) {
            return exps[i].scalarize(s);
        } else {
            return super.scalarize(s, i);
        }
    }

    @Override
    public Size scalarizeInitArray(Scalarizer.Algorithm s, ASTNode context) {
        MutableSize res = new MutableSize(ndims());
        for (int i = 0; i < exps.length; i++) {
            res.size[i] = size[i];
            if (exps[i] != null) {
                exps[i].createArrayTemporaries(s);
                res.exps[i] = exps[i].scalarize(s);
                res.exps[i].parent = context;
            }
        }
        return res;
    }

    @Override
    public void createArrayTemporaries(Scalarizer s, int i) {
        if (exps[i] != null) {
            exps[i].createArrayTemporaries(s);
        } else {
            super.createArrayTemporaries(s, i);
        }
    }

    public Set<String> sortingAddNamesUsed(Set<String> set) {
        for (FExp exp : exps)
            if (exp != null)
                exp.sortingAddNamesUsed(set);
        return set;
    }

    @Override
    public void printNumElements_C(CodePrinter p, CodeStream str, String indent, TypePrintable_C src) {
        if (!variability().knownParameterOrLess()) {
            for (int i = 0; i < size.length; i++) {
                FExp exp = exps[i];
                if (i > 0) {
                    str.print(" * ");
                }
                if (exps[i] == null && size[i] == Size.UNKNOWN) {
                    printSize_C(p, str, indent, src.alias_C(p), i);
                } else if (exp == null) {
                    str.print(size[i]);
                } else {
                    boolean addParenthesis = exp.addParenthesis(Precedence.MULTIPLICATIVE);
                    if (addParenthesis) {
                        str.print("(");
                    }
                    p.print(exp, str, indent);
                    if (addParenthesis) {
                        str.print(")");
                    }
                }
            }
        } else {
            super.printNumElements_C(p, str, indent, src);
        }
    }

    @Override
    public void printDimensions_C(CodePrinter p, CodeStream str, String indent, TypePrintable_C src) {
        if (!variability().knownParameterOrLess()) {
            for (int i = 0; i < size.length; i++) {
                if (i > 0) {
                    str.print(", ");
                }
                if (exps[i] == null && size[i] == Size.UNKNOWN) {
                    printSize_C(p, str, indent, src.alias_C(p), i);
                } else if (exps[i] == null) {
                    str.print(size[i]);
                } else {
                    exps[i].prettyPrint_C(p, str, indent);
                }
            }
        } else {
            super.printDimensions_C(p, str, indent, src);
        }
    }

    @Override
    public void print(CodePrinter.StepPrinter p, CodeStream str, String indent) {
        if (isUnknown()) {
            for (int i = 0; i < size.length; i++) {
                if (size[i] == Size.UNKNOWN && exps[i] != null) {
                    p.print(exps[i], str, indent);
                }
            }
        } else {
            super.print(p, str, indent);
        }
    }


}
