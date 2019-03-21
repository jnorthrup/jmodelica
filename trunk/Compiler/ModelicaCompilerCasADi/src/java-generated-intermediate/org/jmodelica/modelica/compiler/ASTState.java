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
 * @declaredat ASTState:34
 */
public class ASTState extends java.lang.Object {
    
    /**
     * This class stores an attribute value tagged with an iteration ID for
     * a circular evaluation.
     *
     * @apilevel internal
     */
    protected static class CircularValue {
        Object value;
        Cycle cycle;
    }

    

    /**
     * Instances of this class are used to uniquely identify circular evaluation iterations.
     * These iteration ID objects are created for each new fixed-point iteration in
     * a circular evaluation.
     *
     * @apilevel internal
     */
    protected static class Cycle {
    }

    

    /**
     * The iteration ID used outside of circular evaluation.
     *
     * <p>This is the iteration ID when no circular evaluation is ongoing.
     */
    public static final Cycle NON_CYCLE = new Cycle();

    

    /**
     * Tracks the state of the current circular evaluation. This class defines a
     * stack structure where the next element on the stack is pointed to by the
     * {@code next} field.
     *
     * @apilevel internal
     */
    protected static class CircleState {
        final CircleState next;
        boolean resetCycle = false;
        boolean change = false;

        /** Evaluation depth of lazy attributes. */
        int lazyAttribute = 0;

        boolean lastCycle = false;

        /** Cycle ID of the latest cycle in this circular evaluation. */
        Cycle cycle = NON_CYCLE;


        protected CircleState(CircleState next) {
            this.next = next;
        }
    }

    


    /** Sentinel circle state representing non-circular evaluation. */
    private static final CircleState CIRCLE_BOTTOM = new CircleState(null);

    

    /**
     * Current circular state.
     * @apilevel internal
     */
    private CircleState circle = CIRCLE_BOTTOM;

    

    /** @apilevel internal */
    protected boolean inCircle() {
        return circle != CIRCLE_BOTTOM;
    }

    

    /** @apilevel internal */
    protected boolean calledByLazyAttribute() {
        return circle.lazyAttribute > 0;
    }

    

    /** @apilevel internal */
    protected void enterLazyAttribute() {
        circle.lazyAttribute += 1;
    }

    

    /** @apilevel internal */
    protected void leaveLazyAttribute() {
        circle.lazyAttribute -= 1;
    }

    

    /** @apilevel internal */
    protected void enterCircle() {
        CircleState next = new CircleState(circle);
        circle = next;
    }

    


    /**
     * Maps circular attribute to last evaluated cycle index.
     * @apilevel internal
     */
    private java.util.Map<Object, Integer> visited = new java.util.IdentityHashMap<Object, Integer>();

    

    /**
     * Check if attribute was already visited during the current cycle.
     * @apilevel internal
     * @return {@code true} if the attribute was already visited.
     */
    protected boolean checkAndSetVisited(Object attribute, int cycle) {
        boolean result = visited.containsKey(attribute) && visited.get(attribute) == cycle;
        visited.put(attribute, cycle);
        return result;
    }

    

    /**
     * Reset visited cycle tracking for this thread.
     * @apilevel internal
     */
    protected void clearVisited() {
        visited.clear();
    }

    

    // TODO(joqvist): may not be necessary.
    /**
     * Reset visit tracker for a single attribute.
     * @apilevel internal
     */
    protected void resetVisited(Object attribute) {
        visited.remove(attribute);
    }

    

    /** @apilevel internal */
    protected void leaveCircle() {
        circle = circle.next;
    }

    

    /** @apilevel internal */
    protected Cycle nextCycle() {
        Cycle cycle = new Cycle();
        circle.cycle = cycle;
        return cycle;
    }

    

    /** @apilevel internal */
    protected Cycle cycle() {
        return circle.cycle;
    }

    

    /** @apilevel internal */
    protected CircleState currentCircle() {
        return circle;
    }

    


    /** @apilevel internal */
    protected void setChangeInCycle() {
        circle.change = true;
    }

    

    /** @apilevel internal */
    protected boolean testAndClearChangeInCycle() {
        boolean change = circle.change;
        circle.change = false;
        return change;
    }

    

    /** @apilevel internal */
    protected boolean changeInCycle() {
        return circle.change;
    }

    

    /** @apilevel internal */
    protected boolean lastCycle() {
        return circle.lastCycle;
    }

    

    /** @apilevel internal */
    protected void startLastCycle() {
        circle.lastCycle = true;
    }

    

    /** @apilevel internal */
    protected void startResetCycle() {
        circle.resetCycle = true;
    }

    

    /** @apilevel internal */
    protected boolean resetCycle() {
        return circle.resetCycle;
    }

    

    protected ASTState() {
        stack = new int[64];
        pos = 0;
    }

    
    /** @apilevel internal */
    public static final int REWRITE_CHANGE = 1;

    

    /** @apilevel internal */
    public static final int REWRITE_NOCHANGE = 2;

    

    /** @apilevel internal */
    public static final int REWRITE_INTERRUPT = 3;

    

    public int boundariesCrossed = 0;

    

    // state code
    private int[] stack;

    

    private int pos;

    

    private void ensureSize(int size) {
        if (size < stack.length) {
            return;
        }
        int[] newStack = new int[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    

    public void push(int i) {
        ensureSize(pos+1);
        stack[pos++] = i;
    }

    

    public int pop() {
        return stack[--pos];
    }

    

    public int peek() {
        return stack[pos - 1];
    }

    public void reset() {
        // Reset circular evaluation state.
        circle = CIRCLE_BOTTOM;
        boundariesCrossed = 0;
    }


}
