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
 * @aspect FunctionScalarizationHelpers
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:1019
 */
public class ForNames extends java.lang.Object implements Iterable<String> {
    
        private ArrayList<String[]> names;

    
        private ArrayList<Integer> last;

    
        private int pos;

    
        
        /**
         * Standard constructor.
         */
        public ForNames() {
            names = new ArrayList<String[]>();
            last = new ArrayList<Integer>();
            last.add(0);
        }

    
        
        /**
         * Creates a new ForNames with a single layer with space for <code>n</code> names.
         */
        public ForNames(int n) {
            this();
            addLayer(n);
        }

    
        
        /**
         * Add a new layer of names, that can be filled with new names or names 
         *        from the layer underneath.
         * 
         * @param n  the number of names in the new layer
         */
        public void addLayer(int n) {
            names.add(new String[n]);
            pos = 0;
            last.add(last());
        }

    
        
        /**
         * Fills all empty spots in the top layer with newly created names.
         */
        public void fillLayer(FlatLookupNode context) {
            String[] top = topLayer();
            for (int i = pos; i < top.length; i++) 
                create(context);
        }

    
        
        /**
         * Removes the top layer, exposing the layer underneath.
         */
        public void removeLayer() {
            names.remove(names.size() - 1);
            last.remove(last.size() - 1);
        }

    

        private String[] topLayer() {
            return names.get(names.size() - 1);
        }

    
        
        public boolean hasNames() {
            return names.size() > 0 && topLayer().length > 0;
        }

    
        
        /**
         * Gets name with index <code>i</code> in the top layer.
         */
        public String get(int i) {
            return topLayer()[i];
        }

    
        
        /**
         * Adds a name to the top layer.
         */
        public void add(String name) {
            topLayer()[pos++] = name;
        }

    
        
        /**
         * Creates a new name and adds it to the top layer.
         * 
         * @return the created name
         */
        public String create(FlatLookupNode context) {
            String name;
            int l = last();
            do {
                name = "i" + (++l);
            } while (context != null && !context.lookupFV(name).isUnknown()); 
            add(name);
            last.set(last.size()-1, l);
            return name;
        }

    
        
        private int last() {
            return last.get(last.size()-1);
        }

    
        
        /**
         * Adds a name from the underlying layer to the top layer.
         * 
         * @param i  the index in the underlying layer
         */
        public void promote(int i) {
            add(names.get(names.size() - 2)[i]);
        }

    
        
        /**
         * Checks if there are enough layers to promote a name.
         */
        public boolean canPromote() {
            return names.size() > 1;
        }

    
        
        /**
         * Return the number of names in the top layer.
         */
        public int size() {
            return topLayer().length;
        }

    
        
        /**
         * Iterates over the top layer.
         */
        public Iterator<String> iterator() {
            return Arrays.asList(topLayer()).iterator();
        }

    
        
        /**
         * Pushes a copy of the top layer with first and second names switched
         */
        public void createTransposedLayer() {
            String[] lay = topLayer();
            addLayer(lay.length);
            for (int i = 0; i < lay.length; i++) {
                promote(i);
            }
            topLayer()[0] = lay[1];
            topLayer()[1] = lay[0];
            
        }

    
        
        /**
         * Creates nestled for loops using the top layer of names.
         *  
         * Adds the outermost for loop to a list of statements.
         * 
         * @param outer  list to add the created for statements to
         * @param inner  list of statements put inside the loop
         * @param sizes  array of expressions describing the size of each dimension
         */
        public void createForLoops(List<FStatement> outer, List<FStatement> inner, FExp[] sizes, int startDim) {
            if (startDim < sizes.length) {
                List<FStatement> mid = new List<FStatement>();
                createForLoops(mid, inner, sizes, startDim + 1);
                FForIndex ffi = new FForIndex(topLayer()[startDim], sizes[startDim]);
                outer.add(new FForStmt(ffi, mid));
            } else {
                outer.addAll(inner);
            }
        }

    
        
        /**
         * Creates nestled for loops over a single variable, using the top layer of names.
         *  
         * Adds the outermost for loop to a list of statements.
         * 
         * @param outer  list to add the created for statements to
         * @param inner  list of statements put inside the loop
         * @param var    name of the variable to loop over
         */
        public void createForLoops(List<FStatement> outer, List<FStatement> inner, FAccess var) {
            int n = topLayer().length;
            FExp[] sizes = new FExp[n];
            for (int i = 0; i < n; i++) {
                sizes[i] = new FSizeExp(var, i);
            }
            createForLoops(outer, inner, sizes, 0);
        }

    

        /**
         * Creates nestled (from d1 to d2) for loops over an expression, 
         * using the top layer of names.
         *  
         * Adds the outermost for loop to a list of statements.
         * 
         * @param outer  list to add the created for statements to
         * @param inner  list of statements put inside the loop
         * @param exp    expression to loop over
         * @param d1     dimensions to start in
         * @param d2     dimensions to end in
         */
        public void createForLoops(Scalarizer s, List<FStatement> outer, List<FStatement> inner, FExp exp, int d1, int d2) {
            FExp[] sizes = new FExp[d2];
            for (int i = d1; i < d2; i++) {
                sizes[i] = exp.size().scalarize(s, i);
            }
            createForLoops(outer, inner, sizes, d1);
        }

    
        
        /**
         * Creates nestled for loops over an expression, using the top layer of names.
         *  
         * Adds the outermost for loop to a list of statements.
         * 
         * @param outer  list to add the created for statements to
         * @param inner  list of statements put inside the loop
         * @param exp    expression to loop over
         */
        public void createForLoops(Scalarizer s, List<FStatement> outer, List<FStatement> inner, FExp exp) {
            createForLoops(s, outer, inner, exp, 0, exp.ndims());
        }

    

        /**
         * Creates a new FArraySubscripts with uses of the <code>d1</code> to <code>d2</code> names
         * in the top layer as subscripts. When out of names, adds 1s.
         */
        public FArrayExpSubscripts createFArraySubscripts(int d1, int d2) {
            if (d1 < 0)
                throw new UnsupportedOperationException();
            FArrayExpSubscripts fas = new FArrayExpSubscripts();
            for (int i = d1; i < d2; ++i) {
                if (i < topLayer().length)
                    fas.addFSubscript(new FExpSubscript(new FTempAccessExp(new FAccessFull(topLayer()[i]))));
                else
                    fas.addFSubscript(new FIntegerSubscript(1));
            }
            return fas;
        }

    
        
        /**
         * Creates a new FArraySubscripts with uses of the <code>d</code> 
         * first names in the top layer as subscripts. When out of names, adds 1s.
         */
        public FArrayExpSubscripts createFArraySubscripts(int d) {
            return createFArraySubscripts(0, d);
        }

    
        
        /**
         * Creates a new FArraySubscripts with uses of all the names in the top layer.
         */
        public FArrayExpSubscripts createFArraySubscripts() {
            return createFArraySubscripts(topLayer().length);
        }

    

        public FExp[] createFExpArray() {
            if (!hasNames())
                return new FExp[0];
            FExp[] subs = new FExp[topLayer().length];
            int i = 0;
            for (String s : topLayer()) {
                subs[i++] = new FAccessExp(s);
            }
            return subs;
        }

    
        
        /**
         * Creates a new ForNames with the top layer copied
         */
        public ForNames copySurface() {
            ForNames fn = new ForNames();
            if (names.size() > 0) {
                fn.addLayer(topLayer().length);
                for (String s : topLayer())
                    fn.add(s);
            }
            fn.last.add(last());
            return fn;
        }


}
