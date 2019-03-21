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
 * @aspect Units
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\units\\Units.jrag:214
 */
 class CompositeUnit extends Unit {
    
        
        private final double scale;

    
        private final double offset;

    
        private final int[] powers;

    
        private final String name;

    
        
        CompositeUnit(String name) {
            this(new int[Dimension.NumberOfDimensions], 1, 0, name);
        }

    
        
        /*
         * Note:
         * Caller is responsible to make copies of arrays (but only if necessary)
         * before calling in order to preserve immutability.
         * Hence this constructor should be "private" to the Unit system,
         * use Unit.fromDimension() instead.
         */
        CompositeUnit(int[] powers, double scale, double offset, String name) {
            this.powers = powers;
            this.scale = scale;
            this.offset = offset;
            this.name = name;
            
            if(scale <= 0) {
                String msg = "Invalid Unit: scale must be non-zero and positive: " + scale;
                throw new IllegalArgumentException(msg);
            }
        }

    
        
        @Override
        public String getName() {
            return name;
        }

    
        
        @Override
        public double getScale() {
            return scale;
        }

    
        
        @Override
        public double getOffset() {
            return offset;
        }

    
        
        @Override
        public int[] getDimensions() {
            return Arrays.copyOf(powers, powers.length);
        }

    
        
        @Override
        public Unit rename(String name) {
            if(this.name.equals(name)) {
                return this;
            }
            return new CompositeUnit(powers, scale, offset, name);
        }

    
        
        public Unit offset(double delta) {
            return new CompositeUnit(powers, scale, offset + delta, name);
        }

    
        
        @Override
        public Unit multiply(Unit p) {
            if (p instanceof CompositeUnit) {
                CompositeUnit u = (CompositeUnit) p;
                String newName = joinNames(name, u.name, ".");
                double newScale = scale * u.scale;
                double newOffset = 0;
                int[] newPowers = addArray(powers, u.powers);
                return new CompositeUnit(newPowers, newScale, newOffset, newName); 
            }
            // Using commutativity: 
            return p.multiply(this);
        }

    
        
        @Override
        public Unit multiply(double scaleFactor) {
            return new CompositeUnit(powers, scale * scaleFactor, 0, name);
        }

    
        
        @Override
        public Unit multiply(double scaleFactor, String prefix) {
            String newName = name;
            if (!isSimpleName(name)) {
                newName = "(" + name + ")";
            }
            newName = prefix + newName;
            return new CompositeUnit(powers, scale * scaleFactor, 0, newName);
        }

    
        
        @Override
        public Unit divideBy(Unit p) {
            if (p instanceof CompositeUnit) {
                CompositeUnit u = (CompositeUnit) p;
                String newName = joinNames(name, u.name, "/");
                double newScale = scale / u.scale;
                double newOffset = 0;
                int[] newPowers = subArray(powers, u.powers);
                return new CompositeUnit(newPowers, newScale, newOffset, newName);
            }
            return multiply(p.power(-1));
        }

    
        
        @Override
        public Unit power(int k) {
            if (equals(Unit.UNIT) && name.equals("1")) {
                return Unit.UNIT;
            }
            if (k == 1) {
                return this;
            }
            String newName = name + k;
            if (!isSimpleName(name) || lastIsDigit(name)) {
                newName = "(" + name + ")" + k;
            }
            int[] newPowers = multiplyArray(powers, k);
            double newScale = Math.pow(scale, k);
            double newOffset = 0;
            return new CompositeUnit(newPowers, newScale, newOffset, newName);
        }

    
        
        private static boolean isSimpleName(String name) {
            return name.indexOf('.') == -1 && name.indexOf('/') == -1;
        }

    
        
        private static boolean lastIsDigit(String name) {
            if (name.isEmpty()) return false;
            return Character.isDigit(name.charAt(name.length()-1)); 
        }

    
        
        private static String joinNames(String a, String b, String op) {
            if (a.indexOf('/') != -1) {
                a = "(" + a + ")";
            }
            if (!isSimpleName(b)) {
                b = "(" + b + ")";
            }
            return a + op + b;
        }

    
        
        private int[] addArray(int[] a, int[] b) {
            assert(a.length == b.length);
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            return c;
        }

    
        
        private int[] subArray(int[] a, int[] b) {
            assert(a.length == b.length);
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] - b[i];
            }
            return c;
        }

    
        
        private int[] multiplyArray(int[] a, int k) {
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] * k;
            }
            return c;
        }

    
        
        // Convert from this to p
        public Unit convertTo(Unit p) {
            if (p instanceof CompositeUnit) {
                CompositeUnit u = (CompositeUnit) p;
                
                String newName = "conversion from " + name + " to "+ u.name;
                double newScale = scale / u.scale;
                double newOffset = offset * newScale - u.offset;
                int[] newPowers = subArray(powers, u.powers);
                
                if(!isZeroArray(newPowers)) {
                    return Unit.ANY;
                }
                
                return new CompositeUnit(newPowers, newScale, newOffset, newName);
            }
            // Don't know how to convert to p or p == Unit.ANY
            return Unit.ANY;
        }

    
        
        @Override
        public boolean sameDimension(Unit p) {
            if (p instanceof CompositeUnit) {
                CompositeUnit u = (CompositeUnit) p;
                return isZeroArray(subArray(powers, u.powers));
            }
            // If p is any unit then return true else false.
            return p.isAnyUnit();
        }

    
        
        private boolean isZeroArray(int[] a) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != 0) return false;
            }
            return true;
        }

    
        
        @Override
        public boolean isAnyUnit() {
            return false;
        }

    
        
        @Override
        public boolean isCompatibleWith(Unit u) {
            return isCompatibleWithoutOffset(u) && isCompatibleOnlyOffset(u);
        }

    
        
        @Override
        public boolean isCompatibleOnlyOffset(Unit u) {
            if (u == this)
                return true;
            if (u instanceof AnyUnit)
                return true;
            if (getClass() != u.getClass())
                return false;
            CompositeUnit w = (CompositeUnit) u;
            if (Math.abs(offset - w.offset) > 1e-10)
                return false;
            return true;
        }

     
        
        @Override
        public boolean isCompatibleWithoutOffset(Unit u) {
            if (u == this)
                return true;
            if (u == null)
                return false;
            if (u instanceof AnyUnit)
                return true;
            if (getClass() != u.getClass())
                return false;
            CompositeUnit w = (CompositeUnit) u;
            if (Math.abs(1 - scale / w.scale) > 1e-15)
                return false;
            if (!Arrays.equals(powers, w.powers))
                return false;
            return true;
        }

    
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Arrays.hashCode(powers);
            long temp;
            temp = Double.doubleToLongBits(scale);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(offset);
            result = prime * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

    
    
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            CompositeUnit other = (CompositeUnit) obj;
            if (!Arrays.equals(powers, other.powers))
                return false;
            if (Double.doubleToLongBits(scale) != Double.doubleToLongBits(other.scale))
                return false;
            if (Double.doubleToLongBits(offset) != Double.doubleToLongBits(other.offset))
                return false;
            return true;
        }

    
        
        @Override
        public String toString() {
            return "(" + scale + ", " + offset + ", " + Arrays.toString(powers) + ", \"" + name +  "\")";
        }


}
