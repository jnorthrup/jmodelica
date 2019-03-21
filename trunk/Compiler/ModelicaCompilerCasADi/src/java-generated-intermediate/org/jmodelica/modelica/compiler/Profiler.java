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
 * @aspect MemoryUse
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:731
 */
public abstract class Profiler extends java.lang.Object {
    

        /**
         * Approximates the memory footprint of an AST node.
         * 
         * @param deep  if the approximation should include the contents of non-ASTNode members
         */
        public static long getNodeSize(ASTNode node, boolean deep) {
            if (deep)
                return getObjectSize(node);
            else 
                return getTotalShellSize(node.getClass());
        }

    

        /**
         * Clear cached data.
         */
        public static void clear() {
            visited.clear();
        }

    

        private static final long OBJECT_PAD_SIZE     = 8;

    
        private static final long OBJECT_SHELL_SIZE   = 12;

    
        private static final long OBJREF_SIZE         = 4;

    
        private static final long LONG_FIELD_SIZE     = 8;

    
        private static final long INT_FIELD_SIZE      = 4;

    
        private static final long SHORT_FIELD_SIZE    = 2;

    
        private static final long CHAR_FIELD_SIZE     = 2;

    
        private static final long BYTE_FIELD_SIZE     = 1;

    
        private static final long BOOLEAN_FIELD_SIZE  = 1;

    
        private static final long DOUBLE_FIELD_SIZE   = 8;

    
        private static final long FLOAT_FIELD_SIZE    = 4;

    

        private static HashMap<Class, Long> totalFieldSize = new HashMap<Class, Long>();

    
        private static IdentityHashMap<Object, Object> visited = new IdentityHashMap<Object, Object>();

    

        public static class GetFieldsAction implements PrivilegedAction {
            
            private Class cls;
            
            public Field[] perform(Class cl) {
                cls = cl;
                return (Field[]) AccessController.doPrivileged(this);
            }

            public Object run() {
                return cls.getDeclaredFields();
            }
            
        }

    

        public static class GetValueAction implements PrivilegedExceptionAction {
            
            private Field field;
            
            public Object perform(Field f, Object o) throws Exception {
                if (!f.isAccessible()) {
                    field = f;
                    AccessController.doPrivileged(this);
                }
                return f.get(o);
            }

            public Object run() throws Exception {
                field.setAccessible(true);
                return null;
            }
            
        }

    

        public static final GetFieldsAction GET_FIELDS = new GetFieldsAction();

    
        public static final GetValueAction GET_VALUE  = new GetValueAction();

    

        public static long getObjectSize(Object o) {
            if (o == null || visited.containsKey(o))
                return 0;
            visited.put(o, null);
            
            Class type = o.getClass();
            if (type.isArray())
                return getArraySize(o, type);
            if (o instanceof LinkedList)
                return getLinkedListSize((LinkedList) o, type);
            
            long mem = getTotalShellSize(type);
            for (; type != null; type = type.getSuperclass())
                for (Field f : GET_FIELDS.perform(type)) 
                    if ((f.getModifiers() & Modifier.STATIC) == 0) 
                        mem += getObjectFieldSize(f, o);
            return mem;
        }

    

        public static void printObjectParts(Object o) {
            printObjectParts(o, o.getClass());
        }

    

        private static void printObjectParts(Object o, Class type) {
            if (type != Object.class)
                printObjectParts(o, type.getSuperclass());
            
            for (Field f : GET_FIELDS.perform(type)) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    long mem = getFieldSize(f.getType()) + getObjectFieldSize(f, o);
                    System.out.format("%6d : %s\n", mem, f.getName());
                }
            }
        }

    

        private static long getObjectFieldSize(Field f, Object o) {
            Class type = f.getType();
            if (type.isPrimitive())
                return 0;
            try {
                Object val = GET_VALUE.perform(f, o);
                return shouldCount(val) ? getObjectSize(val) : 0;
            } catch (Exception e) {
                System.err.println("Could not read member: " + o.getClass().getSimpleName() + "." + f.getName());
                return OBJECT_SHELL_SIZE;
            }
        }

    

        private static boolean shouldCount(Object o) {
            if (o instanceof ASTNode) {
                ASTNode n = (ASTNode) o;
                for (; n.parent != null; n = n.parent)
                    if (!n.recognizedByParent())
                        return true;
                return !(n instanceof Root);
            } else {
                return true;
            }
        }

    

        // Special case for linked list to avoid stack overflow
        private static long getLinkedListSize(LinkedList l, Class type) {
            long sum = getTotalShellSize(type);
            long entrySize;
            try {
                entrySize = getTotalShellSize(type.getField("header").getType());
            } catch (Exception e) {
                entrySize = 3 * OBJREF_SIZE + OBJECT_SHELL_SIZE; // From inspecting source
            }
            for (Object o : l)
                sum += entrySize + getObjectSize(o);
            return sum;
        }

    

        private static long getTotalFieldSize(Class type) {
            if (totalFieldSize.containsKey(type))
                return totalFieldSize.get(type);
            
            long mem = 0;
            if (type != Object.class)
                mem = getTotalFieldSize(type.getSuperclass());
            
            for (Field f : GET_FIELDS.perform(type)) 
                if ((f.getModifiers() & Modifier.STATIC) == 0) 
                    mem += getFieldSize(f.getType());
            
            totalFieldSize.put(type, mem);
            return mem;
        }

    

        public static long getTotalShellSize(Class type) {
            long mem = OBJECT_SHELL_SIZE + getTotalFieldSize(type);
            return ((mem - 1) / OBJECT_PAD_SIZE + 1) * OBJECT_PAD_SIZE;
        }

    

        private static long getFieldSize(Class type) {
            if (type == int.class)
                return INT_FIELD_SIZE;
            else if (type == long.class)
                return LONG_FIELD_SIZE;
            else if (type == short.class)
                return SHORT_FIELD_SIZE;
            else if (type == byte.class)
                return BYTE_FIELD_SIZE;
            else if (type == boolean.class)
                return BOOLEAN_FIELD_SIZE;
            else if (type == char.class)
                return CHAR_FIELD_SIZE;
            else if (type == double.class)
                return DOUBLE_FIELD_SIZE;
            else if (type == float.class)
                return FLOAT_FIELD_SIZE;
            return OBJREF_SIZE;
        }

    

        private static long getArraySize(Object o, Class type) {
            int len = java.lang.reflect.Array.getLength(o);
            Class comp = type.getComponentType();
            long size = getFieldSize(comp);
            long res = OBJECT_SHELL_SIZE + INT_FIELD_SIZE + len * size;
            res = ((res - 1) / OBJECT_PAD_SIZE + 1) * OBJECT_PAD_SIZE;
            if (!comp.isPrimitive()) { 
                for (int i = 0; i < len; i++) {
                    Object elem = java.lang.reflect.Array.get(o, i);
                    if (shouldCount(elem))
                        res += getObjectSize(elem);
                }
            }
            return res;
        }


}
