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
 * A flat Modelica model containing variables, initial equations,
 * DAE equations and functions.
 * 
 * FClass corresponds to a flattened Modelica model and contains essentially
 * a list of variables and variables, a list of functions and a list of equations, 
 * of which some are initial equations.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:30
 * @astdecl FClass : BaseNode ::= FAccess FVariable* AliasVariable:FVariable* FGlobalVariable* FInitialEquation:FAbstractEquation* ParameterEquation:FAbstractEquation* FAbstractEquation* FFunctionDecl* FRecordDecl* FEnumDecl* FDerivedType* UnknownFVariable FResidualPair* FAttribute* DynamicStateManager;
 * @production FClass : {@link BaseNode} ::= <span class="component">{@link FAccess}</span> <span class="component">{@link FVariable}*</span> <span class="component">AliasVariable:{@link FVariable}*</span> <span class="component">{@link FGlobalVariable}*</span> <span class="component">FInitialEquation:{@link FAbstractEquation}*</span> <span class="component">ParameterEquation:{@link FAbstractEquation}*</span> <span class="component">{@link FAbstractEquation}*</span> <span class="component">{@link FFunctionDecl}*</span> <span class="component">{@link FRecordDecl}*</span> <span class="component">{@link FEnumDecl}*</span> <span class="component">{@link FDerivedType}*</span> <span class="component">{@link UnknownFVariable}</span> <span class="component">{@link FResidualPair}*</span> <span class="component">{@link FAttribute}*</span> <span class="component">{@link DynamicStateManager}</span>;

 */
public class FClass extends BaseNode implements Cloneable, FAttributeListAnnotationNode.FAttributeList, StepLogger {
    /** Set if constant evaluation should consider simulation to be during initialization or not. 
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2610
     */
    public void setIsInitial(boolean initial) {
          FInitialExp.setIsInitial(initial);
    }
    /**
     * Enum like object which represents the most specific categorisation
     * of a variable that is represented in our z-vector.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:46
     */
    
        
        /**
         * Enum like object which represents the most specific categorisation
         * of a variable that is represented in our z-vector.
         */
        public static interface ZCategory {
            public static final ZCategory TIME = 
                    new FixedSizeCategory("TIME", "t", "time");
            public static final ZCategory HOMOTOPY_LAMBDA = 
                    new FixedSizeCategory("HOMOTOPY_LAMBDA", "homotopy_lambda", "_homotopy_lambda");
            
            public ZStructVector zStructVector();
            public String zOffsetName();
            public ZCategoryEntry createEntry(Collection<FVariable> vars, Enumerator enumerator, Integer offset);
            public Comparator<FVariable> sorter(Collection<FVariable> vars, FClass fclass);
            public int valueReferenceFromIndex(int index);
            public void visitZOrder(ZVisitor v);
        }
    /**
     * A visitor for visiting each variable in Z order.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:63
     */
    
        
        /**
         * A visitor for visiting each variable in Z order.
         */
        public static interface ZVisitor {
            public void visitVariable(FVariable fv, ZCategoryEntry entry);
            public void visitVirtualVariable(String name, String zOffsetName, int offset);
        }
    /**
     * Implementation of ZCategory used by special constructs such as
     * time and homotopy lambda.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:72
     */
    

        /**
         * Implementation of ZCategory used by special constructs such as
         * time and homotopy lambda.
         */
        public static class FixedSizeCategory implements ZCategory {
            private final int size;
            private final String name;
            private final String zOffsetName;
            private final String[] memberNames;

            public FixedSizeCategory(String name, String zOffsetName, String... memberNames) {
                this.size = memberNames.length;
                this.name = name;
                this.zOffsetName = zOffsetName;
                this.memberNames = memberNames;
            }

            @Override
            public ZStructVector zStructVector() {
                return ZStructVector.DEFAULT;
            }

            @Override
            public ZCategoryEntry createEntry(Collection<FVariable> vars, Enumerator enumerator, Integer groupOffset) {
                if (vars.size() > 0) {
                    throw new IllegalArgumentException("Special z index categories are not allowed to have entries!");
                }
                return new ZCategoryEntry(this, size, enumerator, groupOffset);
            }

            @Override
            public Comparator<FVariable> sorter(Collection<FVariable> vars, FClass fclass) {
                return null;
            }

            @Override
            public String toString() {
                return name;
            }

            @Override
            public String zOffsetName() {
                return zOffsetName;
            }

            @Override
            public int valueReferenceFromIndex(int index) {
                return index;
            }

            @Override
            public void visitZOrder(ZVisitor v) {
                for (int i = 0; i < size; i++) {
                    v.visitVirtualVariable(memberNames[i], zOffsetName, i);
                }
            }

        }
    /**
     * Used for specifying which z-vector is used for enumerating the
     * specific variable category.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:131
     */
    

        /**
         * Used for specifying which z-vector is used for enumerating the
         * specific variable category.
         */
        public static enum ZStructVector {
            DEFAULT,
            STRING,
            EXTERNAL
        }
    /**
     * Used in when specifying category for parameters (and constants).
     * Parameters can be either independent or dependent. Dependent
     * parameters are those which are calculated by a binding expression
     * which references other parameters.
     * 
     * Currently there is only independent constants.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:145
     */
    

        /**
         * Used in when specifying category for parameters (and constants).
         * Parameters can be either independent or dependent. Dependent
         * parameters are those which are calculated by a binding expression
         * which references other parameters.
         * 
         * Currently there is only independent constants.
         */
        public static enum ParaDependency {
            INDEPENDENT ("i"),
            DEPENDENT   ("d");

            private final String zOffsetName;

            private ParaDependency(String zOffsetName) {
                this.zOffsetName = zOffsetName;
            }

            public String zOffsetName() {
                return zOffsetName;
            }
        }
    /**
     * Enum like object which represents the different variable types we
     * have in our z-vector.
     * 
     * Can't be enum since we wan't to use generics. Makes list retrieval
     * easier!
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:167
     */
    

        /**
         * Enum like object which represents the different variable types we
         * have in our z-vector.
         * 
         * Can't be enum since we wan't to use generics. Makes list retrieval
         * easier!
         */
        public static enum ZType {
            REAL,
            INTEGER   (1 << 28),
            BOOLEAN   (2 << 28),
            ENUM      (1 << 28, "integer"),
            STRING    (3 << 28, ZStructVector.STRING),
            EXTERNAL  (0, ZStructVector.EXTERNAL);

            private final int valueReferenceMask;
            private final ZStructVector zStructVector;
            private final String zOffsetName;

            private ZType() {
                this(0);
            }

            private ZType(int valueReferenceMask) {
                this(valueReferenceMask, ZStructVector.DEFAULT);
            }

            private ZType(int valueReferenceMask, String zOffsetName) {
                this(valueReferenceMask, ZStructVector.DEFAULT, zOffsetName);
            }

            private ZType(int valueReferenceMask, ZStructVector zStructVector) {
                this(valueReferenceMask, zStructVector, null);
            }

            private ZType(int valueReferenceMask, ZStructVector zStructVector, String zOffsetName) {
                this.valueReferenceMask = valueReferenceMask;
                this.zStructVector = zStructVector;
                this.zOffsetName = (zOffsetName != null) ? zOffsetName : toString().toLowerCase();
            }

            public ZStructVector zStructVector() {
                return zStructVector;
            }

            /**
             * Takes a variable index and adds the types valuereference mask
             */
            public int mask(int index) {
                return index ^ valueReferenceMask;
            }

            public String calcZOffsetName(ZVariability var, ParaDependency dependency) {
                if (this == EXTERNAL) {
                    return zOffsetName;
                } else {
                    return String.format(var.zOffsetNameFormat(), zOffsetName, dependency.zOffsetName());
                }
            }

        }
    /**
     * Represents the different variabilities that are possible in the z-vector
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:225
     */
    

        /**
         * Represents the different variabilities that are possible in the z-vector
         */
        public static enum ZVariability {
            CONSTANT        ("c%s"),
            REGULAR_PARAMETER,
            STRUCTURAL_PARAMETER,
            FINAL_PARAMETER,
            EVAL_PARAMETER,
            FREE_PARAMETER, // Only for Optimica!
            INITIAL_PARAMETER,
            DISCRETE        ("d"),
            INPUT           ("u"),
            DIFFERENTIATED  ("x"),
            DERIVATIVE      ("dx"),
            CONTINUOUS      ("w");

            private final boolean isParameter;
            private final String zOffsetNameFormat;

            private ZVariability() {
                this("p%s", true);
            }

            private ZVariability(String zOffsetName) {
                this(zOffsetName, false);
            }

            private ZVariability(String zOffsetName, boolean isParameter) {
                this.isParameter = isParameter;
                this.zOffsetNameFormat = "%s_" + zOffsetName;
            }

            public boolean isParameter() {
                return isParameter;
            }

            public String zOffsetNameFormat() {
                return zOffsetNameFormat;
            }
        }
    /**
     * Class representing ordinary z-vector categories.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:267
     */
    

        /**
         * Class representing ordinary z-vector categories.
         */
        public static class ZOrdinaryCategory implements ZCategory {
            private final static Map<Integer, ZOrdinaryCategory> lookupMap = new HashMap<Integer, ZOrdinaryCategory>();
            
            private static ZOrdinaryCategory create(ParaDependency dependency, ZType type, ZVariability variability) {
                ZOrdinaryCategory category = new ZOrdinaryCategory(dependency, type, variability);
                return category;
            }

            public static final ZOrdinaryCategory INDEPENDENT_REAL_CONSTANT                = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.CONSTANT);
            public static final ZOrdinaryCategory DEPENDENT_REAL_CONSTANT                  = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.CONSTANT);
            public static final ZOrdinaryCategory INDEPENDENT_REAL_REGULAR_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_REAL_STRUCTURAL_PARAMETER    = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_REAL_FINAL_PARAMETER         = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_REAL_EVAL_PARAMETER          = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_REAL_FREE_PARAMETER          = create(ParaDependency.INDEPENDENT, ZType.REAL,    ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_REAL_REGULAR_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_REAL_STRUCTURAL_PARAMETER      = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_REAL_FINAL_PARAMETER           = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_REAL_EVAL_PARAMETER            = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_REAL_FREE_PARAMETER            = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory REAL_INITIAL_PARAMETER                   = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.INITIAL_PARAMETER);

            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_CONSTANT             = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.CONSTANT);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_CONSTANT                = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.CONSTANT);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_CONSTANT               = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.CONSTANT);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_CONSTANT                  = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.CONSTANT);
            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_REGULAR_PARAMETER    = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_REGULAR_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_STRUCTURAL_PARAMETER = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_STRUCTURAL_PARAMETER    = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_FINAL_PARAMETER      = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_FINAL_PARAMETER         = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_EVAL_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_EVAL_PARAMETER          = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_INTEGER_FREE_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.INTEGER, ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_ENUM_FREE_PARAMETER          = create(ParaDependency.INDEPENDENT, ZType.ENUM,    ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_REGULAR_PARAMETER      = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_REGULAR_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_STRUCTURAL_PARAMETER   = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_STRUCTURAL_PARAMETER      = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_FINAL_PARAMETER        = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_FINAL_PARAMETER           = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_EVAL_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_EVAL_PARAMETER            = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_INTEGER_FREE_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_ENUM_FREE_PARAMETER            = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory INTEGER_INITIAL_PARAMETER                = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.INITIAL_PARAMETER);
            public static final ZOrdinaryCategory ENUM_INITIAL_PARAMETER                   = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.INITIAL_PARAMETER);

            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_CONSTANT             = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.CONSTANT);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_CONSTANT               = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.CONSTANT);
            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_REGULAR_PARAMETER    = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_STRUCTURAL_PARAMETER = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_FINAL_PARAMETER      = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_EVAL_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_BOOLEAN_FREE_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.BOOLEAN, ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_REGULAR_PARAMETER      = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_STRUCTURAL_PARAMETER   = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_FINAL_PARAMETER        = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_EVAL_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_BOOLEAN_FREE_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.FREE_PARAMETER);
            public static final ZOrdinaryCategory BOOLEAN_INITIAL_PARAMETER                = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.INITIAL_PARAMETER);

            public static final ZOrdinaryCategory INDEPENDENT_STRING_CONSTANT              = create(ParaDependency.INDEPENDENT, ZType.STRING,  ZVariability.CONSTANT);
            public static final ZOrdinaryCategory DEPENDENT_STRING_CONSTANT                = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.CONSTANT);
            public static final ZOrdinaryCategory INDEPENDENT_STRING_REGULAR_PARAMETER     = create(ParaDependency.INDEPENDENT, ZType.STRING,  ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_STRING_STRUCTURAL_PARAMETER  = create(ParaDependency.INDEPENDENT, ZType.STRING,  ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_STRING_FINAL_PARAMETER       = create(ParaDependency.INDEPENDENT, ZType.STRING,  ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory INDEPENDENT_STRING_EVAL_PARAMETER        = create(ParaDependency.INDEPENDENT, ZType.STRING,  ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_STRING_REGULAR_PARAMETER       = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_STRING_STRUCTURAL_PARAMETER    = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.STRUCTURAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_STRING_FINAL_PARAMETER         = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.FINAL_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_STRING_EVAL_PARAMETER          = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.EVAL_PARAMETER);
            public static final ZOrdinaryCategory STRING_INITIAL_PARAMETER                 = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.INITIAL_PARAMETER);

            public static final ZOrdinaryCategory INDEPENDENT_EXTERNAL_OBJECT              = create(ParaDependency.INDEPENDENT, ZType.EXTERNAL,ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory DEPENDENT_EXTERNAL_OBJECT                = create(ParaDependency.DEPENDENT,   ZType.EXTERNAL,ZVariability.REGULAR_PARAMETER);
            public static final ZOrdinaryCategory EXTERNAL_OBJECT_INITIAL_PARAMETER        = create(ParaDependency.DEPENDENT,   ZType.EXTERNAL,ZVariability.INITIAL_PARAMETER);

            public static final ZOrdinaryCategory REAL_INPUT                               = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.INPUT);
            public static final ZOrdinaryCategory INTEGER_INPUT                            = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.INPUT);
            public static final ZOrdinaryCategory ENUM_INPUT                               = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.INPUT);
            public static final ZOrdinaryCategory BOOLEAN_INPUT                            = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.INPUT);
            public static final ZOrdinaryCategory STRING_INPUT                             = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.INPUT);

            public static final ZOrdinaryCategory DISCRETE_REAL                            = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.DISCRETE);
            public static final ZOrdinaryCategory DISCRETE_INTEGER                         = create(ParaDependency.DEPENDENT,   ZType.INTEGER, ZVariability.DISCRETE);
            public static final ZOrdinaryCategory DISCRETE_ENUM                            = create(ParaDependency.DEPENDENT,   ZType.ENUM,    ZVariability.DISCRETE);
            public static final ZOrdinaryCategory DISCRETE_BOOLEAN                         = create(ParaDependency.DEPENDENT,   ZType.BOOLEAN, ZVariability.DISCRETE);
            public static final ZOrdinaryCategory DISCRETE_STRING                          = create(ParaDependency.DEPENDENT,   ZType.STRING,  ZVariability.DISCRETE);

            public static final ZOrdinaryCategory DIFFERENTIATED                           = new ZOrdinaryCategory(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.DIFFERENTIATED) {
                /**
                 * This is needed since optimization and some simulation models
                 * are extremely picky about the order of the states!
                 */
                @Override
                public Comparator<FVariable> sorter(Collection<FVariable> vars, FClass fclass) {
                    final Map<FVariable, Integer> posMap = new HashMap<FVariable, Integer>();
                    int i = 0;
                    for (FVariable var : fclass.differentiatedByFDerExp()) {
                        posMap.put(var,  i++);
                    }
                    return new Comparator<FVariable>() {
                        @Override
                        public int compare(FVariable a, FVariable b) {
                            Integer aPos = posMap.get(a);
                            if (aPos == null) {
                                throw new InternalCompilerError("Unable to determine index for differentiated variable " + a);
                            }
                            Integer bPos = posMap.get(b);
                            if (bPos == null) {
                                throw new InternalCompilerError("Unable to determine index for differentiated variable " + b);
                            }
                            return aPos - bPos;
                        }};
                };
            };
            public static final ZOrdinaryCategory DERIVATIVE                               = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.DERIVATIVE);
            public static final ZOrdinaryCategory CONTINUOUS                               = create(ParaDependency.DEPENDENT,   ZType.REAL,    ZVariability.CONTINUOUS);

            public final ParaDependency dependency;
            public final ZType type;
            public final ZVariability variability;
            private final String zOffsetName;

            /**
             * Use create method instead!
             */
            private ZOrdinaryCategory(ParaDependency dependency, ZType type, ZVariability variability) {
                this.dependency = dependency;
                this.type = type;
                this.variability = variability;
                this.zOffsetName = type.calcZOffsetName(variability, dependency);
                lookupMap.put(computeLookupKey(this), this);
            }

            @Override
            public ZStructVector zStructVector() {
                return type.zStructVector();
            }

            @Override
            public String zOffsetName() {
                return zOffsetName;
            }

            @Override
            public int valueReferenceFromIndex(int index) {
                return type.mask(index);
            }

            @Override
            public void visitZOrder(ZVisitor v) {}

            @Override
            public ZCategoryEntry createEntry(Collection<FVariable> vars, Enumerator enumerator, Integer groupOffset) {
                return new ZCategoryEntry(this, vars, enumerator, groupOffset);
            }

            private static int computeLookupKey(ZOrdinaryCategory category) {
                return computeLookupKey(category.dependency, category.type, category.variability);
            }

            private static int computeLookupKey(ParaDependency dependency, ZType type, ZVariability variability) {
                return dependency.hashCode() ^ type.hashCode() ^ variability.hashCode();
            }

            public static ZOrdinaryCategory resolve(FVariable var) {
                if (var == null || var.isPreVariable()) {
                    // Pre variables should be excluded!
                    return null;
                }
                ParaDependency dependency;
                if (var.isIndependentConstant() || var.isIndependentParameter()) {
                    dependency = ParaDependency.INDEPENDENT;
                } else {
                    dependency = ParaDependency.DEPENDENT;
                }
                ZType type = var.type().genType();
                ZVariability variability = var.zVariability();
                // If any of these are null, then this variable is not of
                // interest and should be ignored, indicate this with null.
                if (dependency == null || type == null || variability == null) {
                    return null;
                }
                return lookupMap.get(computeLookupKey(dependency, type, variability));
            }

            @Override
            public Comparator<FVariable> sorter(Collection<FVariable> vars, FClass fclass) {
                return null;
            }

            @Override
            public String toString() {
                return dependency + "_" + type + "_" + variability;
            }
        }
    /**
     * Manages value references for variables
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:470
     */
    

        /**
         * Manages value references for variables
         */
        public static class VarRefMap {
            private static final ZCategory[] zIndexOrder = new ZCategory[] {
                    ZOrdinaryCategory.INDEPENDENT_REAL_CONSTANT,
                    ZOrdinaryCategory.DEPENDENT_REAL_CONSTANT,
                    ZOrdinaryCategory.INDEPENDENT_REAL_REGULAR_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_REAL_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_REAL_FINAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_REAL_EVAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_REAL_FREE_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_REAL_REGULAR_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_REAL_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_REAL_FINAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_REAL_EVAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_REAL_FREE_PARAMETER,
                    ZOrdinaryCategory.REAL_INITIAL_PARAMETER,

                    ZOrdinaryCategory.INDEPENDENT_INTEGER_CONSTANT,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_CONSTANT,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_CONSTANT,
                    ZOrdinaryCategory.DEPENDENT_ENUM_CONSTANT,
                    ZOrdinaryCategory.INDEPENDENT_INTEGER_REGULAR_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_REGULAR_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_INTEGER_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_INTEGER_FINAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_FINAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_INTEGER_EVAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_EVAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_INTEGER_FREE_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_ENUM_FREE_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_REGULAR_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_ENUM_REGULAR_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_ENUM_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_FINAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_ENUM_FINAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_EVAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_ENUM_EVAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_INTEGER_FREE_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_ENUM_FREE_PARAMETER,
                    ZOrdinaryCategory.INTEGER_INITIAL_PARAMETER,
                    ZOrdinaryCategory.ENUM_INITIAL_PARAMETER,

                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_CONSTANT,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_CONSTANT,
                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_REGULAR_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_FINAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_EVAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_BOOLEAN_FREE_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_REGULAR_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_FINAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_EVAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_BOOLEAN_FREE_PARAMETER,
                    ZOrdinaryCategory.BOOLEAN_INITIAL_PARAMETER,

                    ZOrdinaryCategory.DERIVATIVE,
                    ZOrdinaryCategory.DIFFERENTIATED,
                    ZOrdinaryCategory.REAL_INPUT,
                    ZOrdinaryCategory.CONTINUOUS,

                    ZCategory.TIME,
                    ZCategory.HOMOTOPY_LAMBDA,

                    ZOrdinaryCategory.DISCRETE_REAL,

                    ZOrdinaryCategory.DISCRETE_INTEGER,
                    ZOrdinaryCategory.DISCRETE_ENUM,

                    ZOrdinaryCategory.INTEGER_INPUT,
                    ZOrdinaryCategory.ENUM_INPUT,

                    ZOrdinaryCategory.DISCRETE_BOOLEAN,
                    ZOrdinaryCategory.BOOLEAN_INPUT,

                    ZOrdinaryCategory.INDEPENDENT_STRING_CONSTANT,
                    ZOrdinaryCategory.DEPENDENT_STRING_CONSTANT,
                    ZOrdinaryCategory.INDEPENDENT_STRING_REGULAR_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_STRING_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_STRING_FINAL_PARAMETER,
                    ZOrdinaryCategory.INDEPENDENT_STRING_EVAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_STRING_REGULAR_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_STRING_STRUCTURAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_STRING_FINAL_PARAMETER,
                    ZOrdinaryCategory.DEPENDENT_STRING_EVAL_PARAMETER,
                    ZOrdinaryCategory.STRING_INITIAL_PARAMETER,

                    ZOrdinaryCategory.DISCRETE_STRING,
                    ZOrdinaryCategory.STRING_INPUT,

                    ZOrdinaryCategory.INDEPENDENT_EXTERNAL_OBJECT,
                    ZOrdinaryCategory.DEPENDENT_EXTERNAL_OBJECT,
                    ZOrdinaryCategory.EXTERNAL_OBJECT_INITIAL_PARAMETER,
            };

            private static final ZCategory[] zIndexOrderPre = new ZCategory[] {
                    ZOrdinaryCategory.DERIVATIVE,
                    ZOrdinaryCategory.DIFFERENTIATED,
                    ZOrdinaryCategory.REAL_INPUT,
                    ZOrdinaryCategory.CONTINUOUS,

                    ZOrdinaryCategory.DISCRETE_REAL,

                    ZOrdinaryCategory.DISCRETE_INTEGER,
                    ZOrdinaryCategory.DISCRETE_ENUM,

                    ZOrdinaryCategory.INTEGER_INPUT,
                    ZOrdinaryCategory.ENUM_INPUT,

                    ZOrdinaryCategory.DISCRETE_BOOLEAN,
                    ZOrdinaryCategory.BOOLEAN_INPUT,
                    
                    ZOrdinaryCategory.DISCRETE_STRING,
                    ZOrdinaryCategory.STRING_INPUT,
            };

            private final Map<ZCategory, ZCategoryEntry> categoryMap;

            public VarRefMap(Iterable<FVariable> vars, FClass fclass) {
                Map<ZCategory, java.util.List<FVariable>> varMap = new HashMap<>(zIndexOrder.length);
                Map<String, Integer> zOffsetMap = new HashMap<>(zIndexOrder.length);
                Map<ZStructVector, Enumerator> vectorEnumerators = new HashMap<>(zIndexOrder.length);
                for (ZCategory category : zIndexOrder) {
                    if (varMap.put(category, new ArrayList<FVariable>()) != null) {
                        throw new IllegalArgumentException("There are multiple entries for " + category + " in z index map");
                    }
                    ZStructVector zStructVector = category.zStructVector();
                    if (!vectorEnumerators.containsKey(zStructVector)) {
                        vectorEnumerators.put(zStructVector, new Enumerator());
                    }
                }
                for (FVariable var : vars) {
                    ZCategory category = var.zCategory();
                    if (category == null) {
                        // Ignore, not supposed to be in any index map!
                        continue;
                    }
                    Collection<FVariable> catVars = varMap.get(category);
                    if (catVars == null) {
                        // Ignore, not of interest in this index map!
                        continue;
                    }
                    catVars.add(var);
                }
                categoryMap = new LinkedHashMap<ZCategory, ZCategoryEntry>(zIndexOrder.length);
                String prevZOffsetName = null;
                for (ZCategory category : zIndexOrder) {
                    java.util.List<FVariable> categoryVars = varMap.get(category);
                    Comparator<FVariable> sorter = category.sorter(categoryVars, fclass);
                    if (sorter != null) {
                        Collections.sort(categoryVars, sorter);
                    }
                    Enumerator enumerator = vectorEnumerators.get(category.zStructVector());
                    String zOffsetName = category.zOffsetName();
                    ZCategoryEntry entry = category.createEntry(
                            categoryVars, enumerator, zOffsetMap.get(zOffsetName));
                    categoryMap.put(category, entry);
                    if (!zOffsetMap.containsKey(zOffsetName)) {
                        zOffsetMap.put(zOffsetName, entry.offset());
                    } else if (!zOffsetName.equals(prevZOffsetName)) {
                        throw new IllegalArgumentException(
                                "Z offset category '" + zOffsetName + "' is not continuous in z index map.");
                    }
                    prevZOffsetName = zOffsetName;
                }
            }

            /**
             * Used for filtering on specific categories
             */
            public static abstract class CategoryFilter implements Criteria<Map.Entry<ZCategory, ZCategoryEntry>> {
                @Override
                public boolean test(Entry<ZCategory, ZCategoryEntry> elem) {
                    if (elem.getKey() instanceof ZOrdinaryCategory) {
                        return test((ZOrdinaryCategory) elem.getKey());
                    } else {
                        return false;
                    }
                }

                /**
                 * Null safe version of test(ZOrdinaryCategory). E.g. if null
                 * is given, then false is returned.
                 */
                public boolean testSingle(ZOrdinaryCategory category) {
                    return category != null && test(category);
                }

                protected abstract boolean test(ZOrdinaryCategory category);
            }

            /**
             * Provides a collection containing all variables with specified
             * type. This collection is read only and only support a small
             * number of operations that collection supports.
             */
            public Collection<FVariable> getBy(final ZType type) {
                return getBy(new CategoryFilter() {
                    @Override
                    protected boolean test(ZOrdinaryCategory category) {
                        return category.type == type;
                    }
                });
            }

            /**
             * Provides a collection containing all variables with specified
             * variability. This collection is read only and only support a
             * small number of operations that collection supports.
             */
            public Collection<FVariable> getBy(final ZVariability variability) {
                return getBy(new CategoryFilter() {
                    @Override
                    protected boolean test(ZOrdinaryCategory category) {
                        return category.variability == variability;
                    }
                    
                });
            }

            /**
             * Provides a collection containing all variables with specified
             * dependency and variability. This collection is read only and 
             * only support a small number of operations that collection supports.
             */
            public Collection<FVariable> getBy(final ParaDependency dependency, final ZVariability variability) {
                return getBy(new CategoryFilter() {
                    @Override
                    protected boolean test(ZOrdinaryCategory category) {
                        return category.dependency == dependency && category.variability == variability;
                    }
                    
                });
            }

            private static final CategoryFilter PARAMETER_FILTER = new CategoryFilter() {
                @Override
                public boolean test(ZOrdinaryCategory category) {
                    return category.variability.isParameter();
                }
                
            };

            /**
             * Provides a collection containing all parameters with specified
             * dependency. This collection is read only and only support a
             * small number of operations that collection supports.
             */
            public Collection<FVariable> getParameterBy(final ParaDependency dependency) {
                return getBy(new CategoryFilter() {
                    @Override
                    protected boolean test(ZOrdinaryCategory category) {
                        return category.dependency == dependency && PARAMETER_FILTER.test(category);
                    }
                    
                });
            }

            /**
             * Provides a collection containing all parameters with specified
             * dependency and type. This collection is read only and only
             * support a small number of operations that collection supports.
             */
            public Collection<FVariable> getParameterBy(final ParaDependency dependency, final ZType type) {
                return getBy(new CategoryFilter() {
                    @Override
                    protected boolean test(ZOrdinaryCategory category) {
                        return category.dependency == dependency && category.type == type && PARAMETER_FILTER.test(category);
                    }
                    
                });
            }

            public Collection<FVariable> getBy(CategoryFilter filter) {
                return new SelectiveCollection(filter);
            }

            public ZCategoryEntry getBy(ZCategory category) {
                return categoryMap.get(category);
            }

            /**
             * Visit all variables in z-order, using provided visitor.
             * If pre is true, then visit only those categories that have pre versions.
             */
            public void visitZOrder(ZVisitor v, boolean pre) {
                for (ZCategory category : (pre ? zIndexOrderPre : zIndexOrder)) {
                    getBy(category).visitZOrder(v);
                }
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<ZCategory, ZCategoryEntry> entry : categoryMap.entrySet()) {
                    if (entry.getValue().size > 0) {
                        sb.append(entry.getKey());
                        sb.append(" (");
                        sb.append(entry.getValue().size);
                        sb.append(" scalars, ");
                        sb.append(entry.getValue().indexMap.size());
                        sb.append(" entries):\n");
                        for (Map.Entry<FVariable, Integer> varEntry : entry.getValue().indexMap.entrySet()) {
                            sb.append("  ");
                            sb.append(varEntry.getValue());
                            sb.append(": ");
                            sb.append(varEntry.getKey().name());
                            sb.append("\n");
                        }
                    }
                }
                return sb.toString();
            }

            /**
             * Class which is returned when selecting a sub-set of the
             * categories.
             */
            private class SelectiveCollection implements Collection<FVariable> {
                private final Iterable<Map.Entry<ZCategory, ZCategoryEntry>> entries;

                private SelectiveCollection(CategoryFilter filter) {
                    entries = new FilteredIterable<Map.Entry<ZCategory, ZCategoryEntry>>(categoryMap.entrySet(), filter);
                }

                public int size() {
                    int size = 0;
                    for (Map.Entry<ZCategory, ZCategoryEntry> entry : entries) {
                        size += entry.getValue().size;
                    }
                    return size;
                }

                @Override
                public Iterator<FVariable> iterator() {
                    return new Iterator<FVariable>() {

                        private Iterator<FVariable> current;
                        private Iterator<Map.Entry<ZCategory, ZCategoryEntry>> entryIter = entries.iterator();

                        @Override
                        public boolean hasNext() {
                            while ((current == null || !current.hasNext()) && entryIter.hasNext()) {
                                current = entryIter.next().getValue().iterator();
                            }
                            return current.hasNext();
                        }

                        @Override
                        public FVariable next() {
                            if (!hasNext()) {
                                throw new NoSuchElementException();
                            }
                            return current.next();
                        }

                        @Override
                        public void remove() {
                            throw new UnsupportedOperationException();
                        }
                    };
                }

                @Override
                public boolean add(FVariable arg0) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean addAll(Collection<? extends FVariable> c) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void clear() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean contains(Object o) {
                    throw new UnsupportedOperationException("Don't use, inefficient!");
                }

                @Override
                public boolean containsAll(Collection<?> c) {
                    throw new UnsupportedOperationException("Don't use, inefficient!");
                }

                @Override
                public boolean isEmpty() {
                    return size() == 0;
                }

                @Override
                public boolean remove(Object o) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean removeAll(Collection<?> c) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public boolean retainAll(Collection<?> c) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public Object[] toArray() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    throw new UnsupportedOperationException();
                }
            }
        }
    /**
     * Represents an entry of ZCategory and contains the offset, size and
     * variables which falls into the specified category.
     * 
     * This class only implements a sub-set of the collection interface.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:897
     */
    

        /**
         * Represents an entry of ZCategory and contains the offset, size and
         * variables which falls into the specified category.
         * 
         * This class only implements a sub-set of the collection interface.
         */
        public static class ZCategoryEntry implements Collection<FVariable> {
            private final int offset;
            private final int groupOffset;
            private final int size;
            private final Map<FVariable, Integer> indexMap;
            private final ZCategory category;

            public ZCategoryEntry(ZCategory category, int size, Enumerator enumerator, Integer groupOffset) {
                this.category = category;
                this.offset = enumerator.peek();
                this.groupOffset = (groupOffset == null) ? this.offset : groupOffset;
                this.size = size;
                this.indexMap = Collections.emptyMap();
                // Now wind forward the enumerator
                for (int i = 0; i < size; i++, enumerator.next());
            }

            public ZCategoryEntry(ZCategory category, Collection<FVariable> vars, Enumerator enumerator, Integer groupOffset) {
                this.category = category;
                this.offset = enumerator.peek();
                this.groupOffset = (groupOffset == null) ? this.offset : groupOffset;
                Map<FVariable, Integer> indexMap = new LinkedHashMap<FVariable, Integer>(vars.size());
                for (FVariable var : vars) {
                    indexMap.put(var, var.incrementValueReferenceIndex(enumerator));
                }
                size = enumerator.peek() - this.offset;
                this.indexMap = Collections.unmodifiableMap(indexMap);
            }

            public int getIndexFor(FVariable var) {
                return indexMap.get(var);
            }

            public int getOffsetIndexFor(FVariable var) {
                return indexMap.get(var) - groupOffset;
            }

            public int getValueReferenceFor(FVariable var) {
                return category.valueReferenceFromIndex(getIndexFor(var));
            }

            public int offset() {
                return offset;
            }

            public ZCategory category() {
                return category;
            }

            public void visitZOrder(ZVisitor v) {
                category.visitZOrder(v);
                for (FVariable fv : this) {
                    v.visitVariable(fv, this);
                }
            }

            @Override
            public Iterator<FVariable> iterator() {
                return indexMap.keySet().iterator();
            }

            @Override
            public boolean add(FVariable e) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean addAll(Collection<? extends FVariable> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Don't use, inefficient!");
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                throw new UnsupportedOperationException("Don't use, inefficient!");
            }

            @Override
            public boolean isEmpty() {
                return size() == 0;
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                throw new UnsupportedOperationException();
            }

            @Override
            public int size() {
                return size;
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException();
            }

            @Override
            public <T> T[] toArray(T[] a) {
                throw new UnsupportedOperationException();
            }
        }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1163
     */
    
        public static <T1, T2 extends T1> Collection<T2> filterCollection(Collection<T1> input, Criteria<T1> filter) {
            Collection<T2> res = new ArrayList<T2>();
            for (T1 elm : input) {
                if (filter.test(elm))
                    res.add((T2)elm);
            }
            return res;
        }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1173
     */
    
        
        // TODO: Remove?!
        public static <T extends FVariable, C extends Set<T>> C intersectFVSet(
                C a, Collection<? extends FVariable> b) {
            try {
                // To avoid having to have different versions for different collections
                C res = (C) a.getClass().newInstance();
                res.addAll(a);
                res.retainAll(b);
                return res;
            } catch (IllegalAccessException e) {
            } catch (InstantiationException e) {
            }
            throw new IllegalArgumentException("First argument must be of class with public default constructor.");
        }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1187
     */
    
        
        public static final Criteria<FVariable> REAL_VARIABLE_FILTER = new Criteria<FVariable>() {
            @Override
            public boolean test(FVariable var) {
                return var.isReal();
            }
        };
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1194
     */
    
        
        public static final Criteria<FVariable> INTEGER_VARIABLE_FILTER = new Criteria<FVariable>() {
            @Override
            public boolean test(FVariable var) {
                return var.isInteger();
            }
        };
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1201
     */
    
        
        public static final Criteria<FVariable> BOOLEAN_VARIABLE_FILTER = new Criteria<FVariable>() {
            @Override
            public boolean test(FVariable var) {
                return var.isBoolean();
            }
        };
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1208
     */
    
        
        public static final Criteria<FVariable> STRING_VARIABLE_FILTER = new Criteria<FVariable>() {
            @Override
            public boolean test(FVariable var) {
                return var.isString();
            }
        };
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1215
     */
    
        
        public static final Criteria<FVariable> ENUM_VARIABLE_FILTER = new Criteria<FVariable>() {
            @Override
            public boolean test(FVariable var) {
                return var.isEnum();
            }
        };
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1702
     */
    public static final VarRefMap.CategoryFilter ALGEBRAIC_FILTER = new VarRefMap.CategoryFilter() {
        @Override
        protected boolean test(ZOrdinaryCategory category) {
            return category == ZOrdinaryCategory.CONTINUOUS || category.variability == ZVariability.DISCRETE;
        }
        
    };
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3776
     */
    public String modelDiagnostics() {
        StringBuilder str = new StringBuilder();
        modelDiagnosticsPrintRow(str, "Number of independent constants:", independentConstants());
        modelDiagnosticsPrintRow(str, "  Number of Real independent constants:", independentRealConstants());
        modelDiagnosticsPrintRow(str, "  Number of Real independent constants:", independentRealConstants());
        modelDiagnosticsPrintRow(str, "  Number of Integer independent constants:", independentIntegerConstants());
        modelDiagnosticsPrintRow(str, "  Number of Enum independent constants:", independentEnumConstants());
        modelDiagnosticsPrintRow(str, "  Number of Boolean independent constants:", independentBooleanConstants());
        modelDiagnosticsPrintRow(str, "  Number of String independent constants:", independentStringConstants());

        modelDiagnosticsPrintRow(str, "Number of dependent constants:", dependentConstants());
        modelDiagnosticsPrintRow(str, "  Number of Real dependent constants:", dependentRealConstants());
        modelDiagnosticsPrintRow(str, "  Number of Integer dependent constants:", dependentIntegerConstants());
        modelDiagnosticsPrintRow(str, "  Number of Enum dependent constants:", dependentEnumConstants());
        modelDiagnosticsPrintRow(str, "  Number of Boolean dependent constants:", dependentBooleanConstants());
        modelDiagnosticsPrintRow(str, "  Number of String dependent constants:", dependentStringConstants());

        modelDiagnosticsPrintRow(str, "Number of independent parameters:", independentParameters());
        modelDiagnosticsPrintRow(str, "  Number of Real independent parameters:", independentRealParameters());
        modelDiagnosticsPrintRow(str, "  Number of Integer independent parameters:", independentIntegerParameters());
        modelDiagnosticsPrintRow(str, "  Number of Enum independent parameters:", independentEnumParameters());
        modelDiagnosticsPrintRow(str, "  Number of Boolean independent parameters:", independentBooleanParameters());
        modelDiagnosticsPrintRow(str, "  Number of String independent parameters:", independentStringParameters());
                  
        modelDiagnosticsPrintRow(str, "Number of dependent parameters:", dependentParameters());
        modelDiagnosticsPrintRow(str, "  Number of Real dependent parameters:", dependentRealParameters());
        modelDiagnosticsPrintRow(str, "  Number of Integer dependent parameters:", dependentIntegerParameters());
        modelDiagnosticsPrintRow(str, "  Number of Enum dependent parameters:", dependentEnumParameters());
        modelDiagnosticsPrintRow(str, "  Number of Boolean dependent parameters:", dependentBooleanParameters());
        modelDiagnosticsPrintRow(str, "  Number of String dependent parameters:", dependentStringParameters());
        
        modelDiagnosticsPrintRow(str, "Number of initial parameters:", initialParameters());
        modelDiagnosticsPrintRow(str, "  Number of Real dependent parameters:", realInitialParameters());
        modelDiagnosticsPrintRow(str, "  Number of Integer dependent parameters:", integerInitialParameters());
        modelDiagnosticsPrintRow(str, "  Number of Enum dependent parameters:", enumInitialParameters());
        modelDiagnosticsPrintRow(str, "  Number of Boolean dependent parameters:", booleanInitialParameters());
        modelDiagnosticsPrintRow(str, "  Number of String dependent parameters:", stringInitialParameters());
        
        modelDiagnosticsPrintRow(str, "Number of variables:", variables());
        modelDiagnosticsPrintRow(str, "  Number of Real variables:", realVariables());
        modelDiagnosticsPrintRow(str, "  Number of Integer variables:", integerVariables());
        modelDiagnosticsPrintRow(str, "  Number of Enum variables:", enumVariables());
        modelDiagnosticsPrintRow(str, "  Number of Boolean variables:", booleanVariables());
        modelDiagnosticsPrintRow(str, "  Number of String variables:", stringVariables());

        modelDiagnosticsPrintRow(str, "Number of Real differentiated variables:", differentiatedRealVariables()); 
        modelDiagnosticsPrintRow(str, "Number of Real derivative variables:", derivativeVariables()); 
        modelDiagnosticsPrintRow(str, "Number of Real continous algebraic variables:", algebraicContinousRealVariables());

        modelDiagnosticsPrintRow(str, "Number of inputs:", inputs());
        modelDiagnosticsPrintRow(str, "  Number of Real inputs:", realInputs());
        modelDiagnosticsPrintRow(str, "  Number of Integer inputs:", integerInputs());
        modelDiagnosticsPrintRow(str, "  Number of Enum inputs:", enumInputs());
        modelDiagnosticsPrintRow(str, "  Number of Boolean inputs:", booleanInputs());
        modelDiagnosticsPrintRow(str, "  Number of String inputs:", stringInputs());
        
        modelDiagnosticsPrintRow(str, "Number of discrete variables:", discreteVariables());
        modelDiagnosticsPrintRow(str, "  Number of Real discrete variables:", discreteRealVariables());
        modelDiagnosticsPrintRow(str, "  Number of Integer discrete variables:", discreteIntegerVariables());
        modelDiagnosticsPrintRow(str, "  Number of Enum discrete variables:", discreteEnumVariables());
        modelDiagnosticsPrintRow(str, "  Number of Boolean discrete variables:", discreteBooleanVariables());
        modelDiagnosticsPrintRow(str, "  Number of String discrete variables:", discreteStringVariables());
        
        modelDiagnosticsPrintRow(str, "Number of equations:", equations());
        
        modelDiagnosticsPrintRow(str, "Number of variables with binding expression:", variablesWithBindingExp());
        modelDiagnosticsPrintRow(str, "  Number of Real variables with binding exp:", realVariablesWithBindingExp());
        modelDiagnosticsPrintRow(str, "  Number of Integer variables binding exp:", integerVariablesWithBindingExp());
        modelDiagnosticsPrintRow(str, "  Number of Enum variables binding exp:", enumVariablesWithBindingExp());
        modelDiagnosticsPrintRow(str, "  Number of Boolean variables binding exp:", booleanVariablesWithBindingExp());
        modelDiagnosticsPrintRow(str, "  Number of String variables binding exp:", stringVariablesWithBindingExp());
            
        modelDiagnosticsPrintRow(str, "Total number of equations:", equations(), variablesWithBindingExp());
    
        modelDiagnosticsPrintRow(str, "Number of initial equations:", initialEquations());

        str.append(String.format("Number of event indicators in equations:      %6d\n", numEventIndicators()));
        str.append(String.format("Number of event indicators in init equations: %6d\n", numRelExpInInitialEquations()));


        return str.toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3859
     */
    private static void modelDiagnosticsPrintRow(StringBuilder sb, String label, Collection<? extends FDiagnosticsNode> ... lists) {
        int num = 0;
        int numScalar = 0;
        for (Collection<? extends FDiagnosticsNode> list : lists) {
            num += list.size();
            numScalar += countNumScalars(list);
        }
        sb.append(String.format("%-46s%6d(%5d scalars)\n", label, num, numScalar));
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3869
     */
    private static int countNumScalars(Collection<? extends FDiagnosticsNode> nodes) {
        int num = 0;
        for (FDiagnosticsNode node : nodes)
            num += node.numScalars();
        return num;
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3885
     */
    public String aliasDiagnostics() {
        StringBuilder str = new StringBuilder();
        str.append("Alias sets:\n");
        if (getAliasManager()!=null) {
            str.append(getAliasManager());
            int n_elim = 0;
            for (AliasManager.AliasSet aliasSet : getAliasManager().getAliasSets()) {
                n_elim += aliasSet.numAliases() - 1;
            }
            str.append(n_elim + " variables can be eliminated\n");
                
        } else {
            str.append("  Alias sets not computed.\n");
        }
        return str.toString();  
        
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3903
     */
    public String aliasDiagnosticsShort() {
        StringBuilder str = new StringBuilder();
        if (getAliasManager()!=null) {
            int n_elim = 0;
            Set<AliasManager.AliasSet> aliasSets = getAliasManager().getAliasSets();
            for (AliasManager.AliasSet aliasSet : aliasSets) {
                n_elim += aliasSet.numAliases() - 1;
            }
            str.append(aliasSets.size());
            str.append(" sets, ");
            str.append(n_elim);
            str.append(" eliminated variables");
        } else {
            str.append("Alias sets not computed");
        }
        return str.toString();  
        
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3922
     */
    public String variableDiagnostics() {
        
        StringBuilder str = new StringBuilder();
        
        str.append("Independent constants: \n");
        for (FVariable fv : independentConstants()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
                str.append("\n");
        }
        str.append("\n");
        
        str.append("Dependent constants: \n");
        for (FVariable fv : dependentConstants()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
                str.append("\n");
        }
        str.append("\n");
        
        str.append("Independent parameters: \n");
        for (FVariable fv : independentParameters()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
            if (fv.hasBindingExp()) {
                CValue val = CValue.UNKNOWN;
                try {
                    val = fv.getBindingExp().ceval();
                } catch (ConstantEvaluationException e) {
                    
                }
                str.append(", evaluated binding exp: ");
                str.append(val);
            }
            str.append("\n");
        }
        str.append("\n");
        
        str.append("Dependent parameters: \n");
        for (FVariable fv : dependentParameters()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
                str.append("\n");
        }

        str.append("\n");  
        str.append("Differentiated variables: \n");
        for (FVariable fv : differentiatedRealVariables()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
            str.append("\n");
        }

        str.append("\n");  
        str.append("Derivative variables: \n");
        for (FVariable fv : derivativeVariables()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
                str.append("\n");
        }
        str.append("\n");  

        str.append("Discrete variables: \n");
        for (FVariable fv : discreteVariables()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
            str.append(", alias: ");
            if (!fv.isAlias()) {
                str.append("no");
            } else {
                if (fv.isNegated()) {
                    str.append("-");
                }
                str.append(fv.alias().valueReference());
            }
            str.append("\n");
        }
        str.append("\n");
        
        str.append("Algebraic real variables: \n");
        for (FVariable fv : algebraicContinousRealVariables()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
            str.append(", alias: ");
            if (!fv.isAlias()) {
                str.append("no");
            } else {
                if (fv.isNegated()) {
                    str.append("-");
                }
                str.append(fv.alias().valueReference());
            }
            str.append("\n");
        }
        str.append("\n");
        
        str.append("Input variables: \n");
        for (FVariable fv : inputs()) {
            str.append(" " + fv.name());
            str.append(": number of uses: " + fv.uses().size() + ", isLinear: " 
                    + fv.isLinear());
                str.append("\n");
        }

        return str.toString();
        
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4038
     */
    public String dependencyDiagnostics() {
        
        StringBuilder str = new StringBuilder();
            
        if (myOptions().getBooleanOption("equation_sorting")) {
            
            str.append("Variable dependencies:\n");
            
            if (getNumFVariable() > myOptions().getIntegerOption("diagnostics_limit")) {
                str.append("Oh dear, the model has way to many variables (" + getNumFVariable() + ")!\n");
                str.append("Current limit is set to " + myOptions().getIntegerOption("diagnostics_limit") + ", you can change this by changing the option 'diagnostics_limit'.\n");
                return str.toString();
            }
            
            str.append("Derivative variables: \n");
            for (FVariable fv : derivativeVariables()) {
                str.append(" " + fv.name() + "\n");
                for (FVariable d : fv.dependsOn()) {
                    str.append("    " + d.name() + "\n");
                }
            }
            str.append("\n");
            str.append("Differentiated variables: \n");
            for (FVariable fv : differentiatedRealVariables()) {
                str.append(" " + fv.name() + "\n");
                for (FVariable d : fv.dependsOn()) {
                    str.append("    " + d.name() + "\n");
                }
            }
            str.append("\n");
            str.append("Algebraic real variables: \n");
            for (FVariable fv : algebraicContinousRealVariables()) {
                str.append(" " + fv.name() + "\n");
                for (FVariable d : fv.dependsOn()) {
                    str.append("    " + d.name() + "\n");
                }
            }
            str.append("\n");
        }
        return str.toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4080
     */
    public String directDependencyDiagnostics() {
        StringBuilder sb = new StringBuilder();
        for (FVariable output : realOutputs()) {
            sb.append(output.name());
            sb.append("\n");
            for (FVariable input : output.directDependencies()) {
                sb.append("    ");
                sb.append(input.name());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4104
     */
    public String connectionSetDiagnostics() {
        return getConnectionSetManager().printConnectionSets();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4108
     */
    public String incidence() {
        return incidence(false);
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4112
     */
    public String incidence(boolean printAllVariables) {
        StringBuilder str = new StringBuilder();
        
        str.append("Incidence:\n");
        
        int i = 0;
        for (FAbstractEquation fe : equations()) {
            Iterable<? extends FVariable> vars;
            if (printAllVariables) {
                vars = fe.allVariables();
            } else {
                vars = new ChainedIterable<FVariable>(fe.derivativeVariables(), fe.algebraicVariables());
            }
            str.append(" eq " + i + ":");
            for (FVariable var : vars) {
                str.append(" " + var.name());
            }
            str.append("\n");
            i++;
        }
        
        return str.toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4136
     */
    public String dersAndDiffs() {
        StringBuilder str = new StringBuilder();
        str.append("Derivatives and differentiated variables:\n");
        for (FDerivativeVariable fdv : derivativeVariables()) {
            if (fdv.myDifferentiatedVariable()!=null) {
                str.append(" " + fdv.name() + ", " + fdv.myDifferentiatedVariable().name() + "\n");
            }
        }   
        str.append("Differentiated variables and derivatives:\n");
        for (FVariable fv : differentiatedRealVariables()) {
            if (fv.myDerivativeVariable()!=null) {
                str.append(" " + fv.name() + ", " + fv.myDerivativeVariable().name() + "\n");
            }
        }
        return str.toString();
        
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4154
     */
    public String printDAEBLT() {
        return getDAEBLT() == null ? "" : getDAEBLT().toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4158
     */
    public String printDAEInitBLT() {
        return getDAEInitBLT().toString();
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4162
     */
    public String printMatchedDAE() {
        return computeMatchedDAEBiPGraph().toString();
    }
    /**
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4261
     */
    private int generatedFunctionNumber = 1;
    /**
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4262
     */
    public String generateFunctionName() {
        String name, part;
        do {
            part = "algorithm_" + generatedFunctionNumber;
            name = name() + "." + part;
            generatedFunctionNumber++;
        } while (lookupFunc(name) != null || variablesMap().lookup(part) != null);
        return name;
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:22
     */
    public FlatAnnotation flatAnnotation(String ... path) {            return FlatAnnotation.createFor(this, path); }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:407
     */
    public static String removeModifiersFromClassName(String name) {
        int p = name.indexOf('(');
        if (p >= 0)
            name = name.substring(0, p);
        return name;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:414
     */
    public static String convertClassNameToUnderscore(String name) {
        return removeModifiersFromClassName(name).replace(".", "_");
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:472
     */
    private int nextForIndexIndex = 0;
    /**
     * Add an equation to the first equation block.
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1042
     */
    public void addFEquation(FAbstractEquation feq) {
        addFAbstractEquationNoTransform(feq);
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1046
     */
    public void addFInitialEquations(Collection<? extends FAbstractEquation> eqns) {
        for (FAbstractEquation feq : eqns) {
            addFInitialEquation(feq);
        }
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1052
     */
    public void addFEquations(Collection<? extends FAbstractEquation> eqns) {
        for (FAbstractEquation feq : eqns) {
            addFEquation(feq);
        }
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1589
     */
    private FlatVariableMap.NameIndexCache nameIndexCache = new FlatVariableMap.NameIndexCache();
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1592
     */
    public String nextTempVarName() {
         return nextGeneratedVarName(FlatVariableMap.GeneratedVarType.TEMP);
     }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1596
     */
    public String nextGeneratedVarName(FlatVariableMap.GeneratedVarType gvt) {
         return variablesMap().nextGeneratedVarName(nameIndexCache, gvt);
     }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1608
     */
    public String nextTempVarName(FFunctionDecl func) {
         return variablesMap().nextGeneratedVarName(nameIndexCache, FlatVariableMap.GeneratedVarType.TEMP, func.variablesMap());
     }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1665
     */
    public String nextTempFuncName() {
        String name;
        do {
            name = "temp_" + nextTempFuncIndex++;
        } while (lookupFunc(name) != null);
        return name;
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1672
     */
    private int nextTempFuncIndex = 1;
    /**
     * @aspect DefaultExperiment
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1892
     */
    
        
        public Experiment experiment = null;
    /**
     * Create an experiment description from an experiment annotation, if it exists.
     * @aspect DefaultExperiment
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1897
     */
    
        
        /**
         * Create an experiment description from an experiment annotation, if it exists.
         */
        public void createExperiment(AnnotationNode a) {
            if (a.exists())
                experiment = new Experiment(a);
        }
    /**
     * Represents an experiment annotation.
     * @aspect DefaultExperiment
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1905
     */
    
        
        /**
         * Represents an experiment annotation.
         */
        public static class Experiment {
            
            public boolean hasStart = false;
            public double start;
            public boolean hasStop = false;
            public double stop;
            public boolean hasInterval = false;
            public double interval;
            public boolean hasTolerance = false;
            public double tolerance;
            
            public Experiment(AnnotationNode expr) {
                for (AnnotationNode val : expr) {
                    if (val.isRealValue()) {
                        if (val.name().equals("StartTime")) {
                            hasStart = true;
                            start = val.real();
                        } else if (val.name().equals("StopTime")) {
                            hasStop = true;
                            stop = val.real();
                        } else if (val.name().equals("Interval")) {
                            hasInterval = true;
                            interval = val.real();
                        } else if (val.name().equals("Tolerance")) {
                            hasTolerance = true;
                            tolerance = val.real();
                        }
                    }
                }
            }
            
        }
    /**
     * @aspect JastAddHacks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2046
     */
    
        public <V extends FDynamicResolver> V dynamicResolver(V res) {
            getFDynamicResolverOpt().setChild(res, 0);
            return (V) getFDynamicResolverOpt().getChild(0);
        }
    /**
     * Copied from FClass.prettyPrint and modified
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:150
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent) {
        String nextInd = p.indent(indent);
        str.print(indent + "<b>fclass " + name() + "</b><br>\n");
        ArrayList<FVariable> protectedVars = new ArrayList<FVariable>();
        for (FVariable fv : getFVariables()) {
            if (!fv.isDerivativeVariable() && !fv.isPreVariable() &&
                    !fv.getVisibilityType().isRuntimeOptionVisibility()) {
                if (fv.isProtected()) {
                  protectedVars.add(fv);
                } else {
                    p.print(fv, str, nextInd);
                    str.print(";<br>\n");
                }
            }
        }
        if (!protectedVars.isEmpty()) {
            str.print(indent + "<b>protected</b><br>\n");
            for (FVariable fv : protectedVars) {
                p.print(fv, str, nextInd);
                str.print(";<br>\n");
            }
        }

        if (getNumFInitialEquation()>0)
            str.print(indent + "<b>initial equation</b><br>\n");
        getFInitialEquations().prettyPrintWithFix(p, str, nextInd, "", "");

        if (getNumParameterEquation()>0)
            str.print(indent + "<b>parameter equation</b><br>\n");
        getParameterEquations().prettyPrintWithFix(p, str, nextInd, "", "");
    
        boolean wroteEquation = false;
        for (FAbstractEquation e : getFAbstractEquations()) {
            if (e instanceof FAlgorithm) {
                p.print(e, str, indent);
                str.print("<br>");
                wroteEquation = false;
            } else {
                if (!e.isIgnored()) {
                    if (!wroteEquation) {
                        str.print(indent);
                        str.print("<b>equation</b><br>\n");
                        wroteEquation = true;
                    }
                    p.print(e, str, nextInd);
                }
            }
        }
        
        if (getNumFFunctionDecl() > 0 || getNumFRecordDecl() > 0 || 
                getNumFEnumDecl() > 0 || getNumFDerivedType() > 0) {
            str.print("\n" + indent + "<b>public</b><br>\n");
            p.print(getFFunctionDecls(), str, nextInd);
            p.print(getFRecordDecls(), str, nextInd);
            p.print(getFEnumDecls(), str, nextInd);
            p.print(getFDerivedTypes(), str, nextInd);
        }
        
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p, indent, ";\n");

        str.print(indent);
        str.print("<br><b>end ");
        str.print(name());
        str.print(";</b>\n");
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1031
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        String nextInd = p.indent(indent);
        str.formatln("%sfclass %s", indent, name());
        ArrayList<FVariable> protectedVars = new ArrayList<FVariable>();
        for (FVariable fv : getFVariables()) {
            if (!fv.isDerivativeVariable() && !fv.isPreVariable() &&
                    !fv.getVisibilityType().isRuntimeOptionVisibility()) {
                if (fv.isProtected()) {
                  protectedVars.add(fv);
                } else {
                    p.print(fv, str, nextInd);
                    str.println(";");
                }
            }
        }
        if (!protectedVars.isEmpty()) {
            str.println(indent, "protected");
            for (FVariable fv : protectedVars) {
                p.print(fv, str, nextInd);
                str.println(";");
            }
        }
        if (getNumFGlobalVariable() > 0) {
            str.println(indent, "global variables");
            for (FVariable fv : getFGlobalVariables()) {
                p.print(fv, str, nextInd);
                str.println(";");
            }
        }
        if (getNumFInitialEquation() > 0) {
            str.println(indent, "initial equation");
        }
        getFInitialEquations().prettyPrintWithFix(p, str, nextInd, "", ";" + str.getLineEnder());

        if (getNumParameterEquation() > 0) {
            str.println(indent, "parameter equation");
        }
        getParameterEquations().prettyPrintWithFix(p, str, nextInd, "", ";" + str.getLineEnder());
    
        boolean wroteEquation = false;
        for (FAbstractEquation e : getFAbstractEquations()) {
            if (e instanceof FAlgorithm) {
                p.print(e, str, indent);
                wroteEquation = false;
            } else {
                if (!e.isIgnored()) {
                    if (!wroteEquation) {
                        str.println(indent, "equation");
                        wroteEquation = true;
                    }
                    p.print(e, str, nextInd);
                    str.println(";");
                }
            }
        }
        
        if (getNumFFunctionDecl() > 0 || getNumFRecordDecl() > 0 || 
                getNumFEnumDecl() > 0 || getNumFDerivedType() > 0) {
            str.println();
            str.formatln("%spublic", indent);
            p.print(getFFunctionDecls(), str, nextInd);
            p.print(getFRecordDecls(), str, nextInd);
            p.print(getFEnumDecls(), str, nextInd);
            p.print(getFDerivedTypes(), str, nextInd);
        }
        
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p, indent, ";" + str.getLineEnder());

        str.println(indent, "end ", name(), ";");
    }
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2101
     */
    public void prettyPrint_MC(Printer p, CodeStream str, String indent) {
        String nextInd = p.indent(indent);
    
        p.print(getFFunctionDecls(), str, indent);
        p.print(getFRecordDecls(), str, indent);
        p.print(getFEnumDecls(), str, indent);
        p.print(getFDerivedTypes(), str, indent);
    
        str.println(indent, "model ", nameUnderscore());
        for (FVariable fv : getFVariables()) {
            if (!fv.isDerivativeVariable() && !fv.isPreVariable()) {
                p.print(fv, str, nextInd);
                str.println(";");
            }
        }

        if (getNumFInitialEquation() > 0) {
            str.println(indent, "initial equation");
        }
        getFInitialEquations().prettyPrintWithFix(p, str, nextInd, "", ";" + str.getLineEnder());

    /*
        if (getNumParameterEquation() > 0) {
            str.println(indent, "parameter equation");
        }
        getParameterEquations().prettyPrintWithFix(p, str, nextInd, "", ";" + str.getLineEnder());
    */
        boolean wroteEquation = false;
        for (FAbstractEquation e : getFAbstractEquations()) {
            if (e instanceof FAlgorithm) {
                p.print(e, str, indent);
                wroteEquation = false;
            } else {
                if (!e.isIgnored()) {
                    if (!wroteEquation) {
                        str.println(indent, "equation");
                        wroteEquation = true;
                    }
                    p.print(e, str, nextInd);
                    str.println(";");
                }
            }
        }
                
        str.println(indent, "end ", nameUnderscore(), ";");
    }
    /**
     * Convert all continous variables that are assigned in when equations into discrete variables.
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:282
     */
    public void updateVariabilityForVariablesInWhen() {
        beginStep("updateVariabilityForVariablesInWhen()");
        getFAbstractEquations().updateVariabilityForVariablesInWhen(false);
        checkDiscreteOperations();
        endStep("updateVariabilityForVariablesInWhen()");
    }
    /**
     * Evaluate asserts with constant tests, generate errors for failing ones, 
     * and eliminate all evaluated assets.
     * @aspect AssertEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1597
     */
    
        /**
         * Evaluate asserts with constant tests, generate errors for failing ones, 
         * and eliminate all evaluated assets.
         */
        public class evaluateAsserts extends Transformation {
            public void perform() {
                List<FAbstractEquation> l = new List<FAbstractEquation>();
                for (FAbstractEquation eqn : getFAbstractEquations()) {
                    if (!eqn.evaluateAsserts(true)) {
                        l.add(eqn);
                    }
                }
                setFAbstractEquationList(l);
            }
        }
    /**
     * Check errors that can only be detected after scalarization.
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1690
     */
    public void scalarizationErrorCheck() {
        checkMultipleReinit();
        breakOnErrors();
    }
    /**
     * Check for variables with multiple reinits.
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1698
     */
    public void checkMultipleReinit() {
        Map<FAbstractVariable, Set<FReinit>> reinitMap = collectReinits();
        for (FAbstractVariable fv : reinitMap.keySet()) {
            if (!fv.isUnknown()) {
                Set<FWhenEquation> whens = new HashSet<FWhenEquation>();
                Set<FReinit> reinits = reinitMap.get(fv);
                for (FReinit r : reinits) {
                    FWhenEquation w = r.myWhen();
                    if (!whens.contains(w))
                        whens.add(w);
                }
                if (whens.size() > 1) {
                    StringBuilder buf = new StringBuilder();
                    buf.append("The variable ");
                    buf.append(fv.name());
                    buf.append(" is assigned in reinit() clauses in more than one when clause:\n");
                    for (FReinit r : reinits) {
                        buf.append("    ");
                        buf.append(r);
                        buf.append(";\n");
                    }
                    fv.error(buf.toString());
                }
            }
        }
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:36
     */
    public ConnectionSetManager connectionSetManager = new ConnectionSetManager();
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:38
     */
    public ConnectionSetManager getConnectionSetManager() {
		return connectionSetManager;
	}
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:42
     */
    public void genConnectionEquations(Flattener f) {
        beginStep("genConnectionEquations()");
        for (ConnectionSet set : connectionSetManager.getConnectionSetList()) 
            set.generateEquations(f);
        connectionSetManager.generateEqualityConstraints(f);
        connectionSetManager.disconnectFromInstanceTree();
        endStep("genConnectionEquations()");
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:65
     */
    
        public class enableStreamsRewrite extends Transformation {
            // Depends on enableIfEquationElimination being done
            public void perform() {
                enableStreamsRewrite();
                change();
            }
        }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:102
     */
    
        public class enableExpandedInStreamRewrite extends Transformation {
            // Depends on variabilityPropagationIfSet and the following aliasEliminationIfSet being done
            public void perform() {
                enableExpandedInStreamRewrite();
                change();
            }
        }
    /**
     * Get (no transform) equation list matching the variability <code>v</code>.
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:175
     */
    public List<FAbstractEquation> equationList(TypePrefixVariability v) {
        if (v.knownParameterOrLess()) {
            throw new UnsupportedOperationException();
        } else if (v.fixedParameterVariability()) {
            return getParameterEquationsNoTransform();
        } else if (v.initialParameterVariability()) {
            return getFInitialEquationsNoTransform();
        } else {
            return getFAbstractEquationsNoTransform();
        }
    }
    /**
     * Create a correctly set up FClass.
     * 
     * Also creates a FlatRoot and sets its fields.
     * 
     * @param icl   the class being flattened
     * @param file  the path to the file to report errors on
     * @aspect FlatTree
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:35
     */
    public static FClass create(InstClassDecl icl, String flatName) {
        FlatRoot flatRoot = new FlatRoot(icl.createFClass());
        //flatRoot.setFileName(file);
        FClass fc = flatRoot.getFClass(); // make FClass final
        fc.userDefinedName = flatName;
        fc.root().transferRoot(icl.root());
        fc.setDynamicStateManager(new DynamicStateManager());
        return fc;
    }
    /**
     * Set the name of the FClass.
     * 
     * If a user-defined name has been set, use it, otherwise use the given name.
     * @aspect FlatTree
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:50
     */
    public void setName(String name) {
        if (userDefinedName != null) 
            name = userDefinedName;
        setFAccess(new FAccessString(name));
    }
    /**
     * User-defined name for the flat class.
     * @aspect FlatTree
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:59
     */
    private String userDefinedName = null;
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:264
     */
    public void update(Flattener f) {
        setFGlobalVariableList(f.getFGlobalVariables());
        setFVariableList(f.getFVariables());
        setFAbstractEquationList(f.getNormalEquations());
        setFInitialEquationList(f.getInitialEquations());
        setParameterEquationList(f.getParameterEquations());
        
        setFFunctionDeclList(f.getFFunctionDecls());
        setFRecordDeclList(f.getFRecordDecls());
        setFEnumDeclList(f.getFEnumDecls());
        setFDerivedTypeList(f.getFDerivedTypes());
        
        numComponents = f.getComponentCount();
    }
    /**
     * @aspect ComponentCount
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3492
     */
    private int numComponents = 0;
    /**
     * @aspect ComponentCount
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3494
     */
    protected void countComponent() {
        numComponents++;
    }
    /**
     * @aspect ComponentCount
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3498
     */
    public int numberOfComponents() {
        return numComponents;
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:19
     */
    public void removeUnusedGlobals() {
        beginStep("removeUnusedGlobals()");
        
        for (FFunctionDecl   g : getFFunctionDecls())   { g.global().reset(); }
        for (FRecordDecl     g : getFRecordDecls())     { g.global().reset(); }
        for (FGlobalVariable g : getFGlobalVariables()) { g.global().reset(); }
        
        getFVariables()         .markUsedGlobals();
        getFInitialEquations()  .markUsedGlobals();
        getParameterEquations() .markUsedGlobals();
        getFAbstractEquations() .markUsedGlobals();
        getDynamicStateManager().markUsedGlobals();
        
        List<FFunctionDecl> resFunc = new List<>();
        for (FFunctionDecl g : getFFunctionDecls()) {
            if (g.global().isUsed()) {
                resFunc.add(g);
            }
        }
        setFFunctionDeclList(resFunc);
        
        List<FRecordDecl> resRec = new List<>();
        for (FRecordDecl g : getFRecordDecls()) {
            if (g.global().isUsed()) {
                resRec.add(g);
            }
        }
        setFRecordDeclList(resRec);
        
        List<FGlobalVariable> resVar = new List<>();
        for (FGlobalVariable g : getFGlobalVariables()) {
            if (g.global().isUsed()) {
                resVar.add(g);
            }
        }
        setFGlobalVariableList(resVar);
        
        endStep("removeUnusedGlobals()");
    }
    /**
     * Copies all files included by loadResource() to Resource folder.
     * @aspect LoadResource
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\LoadResource.jrag:24
     */
    public void loadResources(File resourcePath) {
        Collection<String> errors = resourceLoader().loadResources(resourcePath);
        for (String error : errors) {
            error(String.format("loadResource(): " + error));
        }
        breakOnErrors();
    }
    /**
     * Add parameters for all defined runtime options.
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:23
     */
    
        /**
         * Add parameters for all defined runtime options.
         */
        public class addRuntimeOptionParameters extends Transformation {
            public boolean active() {
                OptionRegistry opt = myOptions();
                return opt.getBooleanOption("generate_runtime_option_parameters") && opt.getBooleanOption("generate_ode");
            }
            
            public void perform() {
                OptionRegistry opt = myOptions();
                for (String key : opt.getRuntimeOptionKeys()) {
                    FVariable v = null;
                    String name = OptionRegistry.getFMUXMLName(key);
                    if (opt.isBooleanOption(key))
                        v = createBooleanRuntimeOptionParameter(name, opt.getBooleanOption(key));
                    else if (opt.isStringOption(key))
                        v = createStringRuntimeOptionParameter(name, opt.getStringOption(key));
                    else if (opt.isIntegerOption(key))
                        v = createIntegerRuntimeOptionParameter(name, opt.getIntegerOption(key));
                    else if (opt.isRealOption(key))
                        v = createRealRuntimeOptionParameter(name, opt.getRealOption(key));
                    addFVariable(v);
                }
            }
        }
    /**
     * Create a parameter for a boolean runtime option. 
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:51
     */
    public FVariable createBooleanRuntimeOptionParameter(String name, boolean val) {
        return commonCreateRuntimeOptionParameter(new FBooleanVariable(), name, FBooleanLitExp.create(val));
    }
    /**
     * Create a parameter for a string runtime option. 
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:58
     */
    public FVariable createStringRuntimeOptionParameter(String name, String val) {
        return commonCreateRuntimeOptionParameter(new FStringVariable(), name, new FStringLitExp(val));
    }
    /**
     * Create a parameter for a integer runtime option. 
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:65
     */
    public FVariable createIntegerRuntimeOptionParameter(String name, int val) {
        return commonCreateRuntimeOptionParameter(new FIntegerVariable(), name, new FIntegerLitExp(val));
    }
    /**
     * Create a parameter for a real runtime option. 
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:72
     */
    public FVariable createRealRuntimeOptionParameter(String name, double val) {
        return commonCreateRuntimeOptionParameter(new FRealVariable(), name, new FRealLitExp(val));
    }
    /**
     * Set the children of a runtime option parameter.
     * 
     * @param v     the variable to set fields on
     * @param name  the name of the variable
     * @param bExp  the burrent value of the option
     * @return  <code>v</code>, for convenience
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:84
     */
    public FVariable commonCreateRuntimeOptionParameter(FVariable v, String name, FExp bExp) {
        v.setVisibilityType(VisibilityType.RUNTIME_OPTION);
        v.setTypePrefixVariability(Variability.FIXEDPARAMETER);
        v.setTypePrefixInputOutput(TypePrefixInputOutput.NONE);
        v.setBindingExp(bExp);
        v.setFAccess(new FAccessString(name));
        return v;
    }
    /**
     * Perform a basic sanity check of the current flat tree.
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:24
     */
    public void sanityCheck() {
        if (myOptions().getBooleanOption("debug_sanity_check")) {
            sanityCheckCommonAccessConsistency(this);
            for (FAbstractEquation eqn : getParameterEquations()) {
                eqn.sanityCheckParameterEquations(this);
            }
            sanityCheckType(this);
            // Break execution and print any errors 
            breakOnErrors();
        }
    }
    /**
     * Report a sanity problem.
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:39
     */
    public void sanityProblem(ASTNode node, String message, Object... args) {
        DEBUG_SANITY_CHECK.invoke(node, lastCompletedTransformationStep, completedTransformationSteps, message, args);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:4
     */
    public void logDebug(Object obj) {
        log.debug(obj);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:7
     */
    public void logDebug(String format, Object... args) {
        log.debug(format, args);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:11
     */
    public void logVerbose(Object obj) {
        log.verbose(obj);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:15
     */
    public void logVerbose(String format, Object... args) {
        log.verbose(format, args);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:19
     */
    public void logInfo(Object obj) {
        log.info(obj);
    }
    /**
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:23
     */
    public void logInfo(String format, Object... args) {
        log.info(format, args);
    }
    /**
     * transformCanonicalBase contains all transformation that should be
     * done by both the Modelica and the Optimica compilers.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:83
     */
    public void transformCanonicalBase() {
        for (Transformation t : getTransformations()) {
            t.apply();
        }
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:89
     */
    public void transformCanonicalCleanup() {
        removeUnusedGlobals();
        root().flushAllRecursive();
    }
    /**
     * List that contains all transformations that has been registered.
     * This list is initialized by setupTransformations()
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:100
     */
    
        
        /**
         * List that contains all transformations that has been registered.
         * This list is initialized by setupTransformations()
         */
        private java.util.List<Transformation> transformations;
    /**
     * Method that initializes the transformations list. This method should
     * called before each operation on the list. Internal check prevents
     * multiple initializations.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:107
     */
    
        
        /**
         * Method that initializes the transformations list. This method should
         * called before each operation on the list. Internal check prevents
         * multiple initializations.
         */
        private void setupTransformations() {
            if (transformations != null)
                return;
            transformations = new ArrayList<Transformation>();
            transformations.add(new enableIfEquationElimination());
            transformations.add(new genAlgorithmFunctionsIfSet());
            transformations.add(new genInitArrayStatements());
            transformations.add(new scalarize());
            transformations.add(new MakeReinitedVarsStates());
            transformations.add(new enableIfEquationElimination());
            transformations.add(new enableStreamsRewrite());
            transformations.add(new ExtractEventGeneratingExpressions());
            transformations.add(new GenerateEventIndicators());
            transformations.add(new convertWhenToIf());
            transformations.add(new FunctionInliningIfSet());
            transformations.add(new setFDerivativeVariables());
            transformations.add(new addFPreVariables());
            transformations.add(new enableIfEquationRewrite());
            transformations.add(new aliasEliminationIfSet());
            transformations.add(new variabilityPropagationIfSet());
            transformations.add(new aliasEliminationIfSet());
            transformations.add(new eliminateLinearEquations());
            transformations.add(new aliasEliminationIfSet());
            transformations.add(new enableExpandedInStreamRewrite());
            transformations.add(new evaluateAsserts());
            transformations.add(new enableSemiLinearRewrite());
            transformations.add(new eliminateEqualSwitches());
            transformations.add(new genInitialEquations());
            transformations.add(new addStateInitialEquationsIfSet());
            transformations.add(new setFDerivativeVariablesPreBLT());
            transformations.add(new indexReduction());
            transformations.add(new LateFunctionInliningIfSet());
            transformations.add(new commonSubexpressionEliminationIfSet());
            transformations.add(new addFPreVariables());
            transformations.add(new aliasEliminationIfSet());
            transformations.add(new eliminateLinearEquations());
            transformations.add(new sortDependentParameters());
            transformations.add(new addRuntimeOptionParameters());
            transformations.add(new computeMatchingsAndBLT());
        }
    /**
     * This method returns the list of transformations. This method should
     * be used when retreiving the list of transformations since it ensures
     * that the list is initialized.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:153
     */
    

        /**
         * This method returns the list of transformations. This method should
         * be used when retreiving the list of transformations since it ensures
         * that the list is initialized.
         */
        private Collection<Transformation> getTransformations() {
            setupTransformations();
            return transformations;
        }
    /**
     * Adds a transformation to the list of transformations. The
     * transformation is added after each occurance of <code>after<code>.
     * The transformation is not added if no occurances of 
     * <code>after<code> is found.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:164
     */
    

        /**
         * Adds a transformation to the list of transformations. The
         * transformation is added after each occurance of <code>after<code>.
         * The transformation is not added if no occurances of 
         * <code>after<code> is found.
         */
        private <T extends Transformation> T addTransformationAfter(T transformation, String after) {
            setupTransformations();
            ListIterator<Transformation> it = transformations.listIterator();
            while (it.hasNext()) {
                Transformation other = it.next();
                if (other.name().equals(after))
                    it.add(transformation);
            }
            return transformation;
        }
    /**
     * Base class for transformations on the flat tree.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:178
     */
    

        /**
         * Base class for transformations on the flat tree.
         */
        public abstract class Transformation {

            private String option;

            /**
             * Create a transformation with default settings:
             * <ul>
             * <li>Not coupled to a compiler option.</li>
             * </ul>
             */
            public Transformation() {
                this(null);
            }

            /**
             * Create a transformation with specific settings.
             * 
             * @param option  boolean option the transfomation depends on (null for none)
             */
            public Transformation(String option) {
                this.option = option;
            }

            /**
             * Perform the transformation.
             */
            public abstract void perform();

            /**
             * Determine if this transformation should be perfomed.
             * 
             * Defaults to true if this transformation does not depend on an option or the option is true.
             */
            public boolean active() {
                return (option == null) || myOptions().getBooleanOption(option);
            }

            /**
             * The name of this transformation.
             * 
             * Defaults to the name of the class.
             */
            public String name() {
                return getClass().getSimpleName();
            }

            /**
             * Apply this transformation, if active.
             * 
             * Subclasses should not override this method.
             */
            public void apply() {
                if (active()) {
                    try {
                        beginStep(name());
                        log.info("Applying transformation: " + name() + "...");
                        perform();
                    } finally {
                        completedTransformationSteps++;
                        lastCompletedTransformationStep = name();
                        endStep(name());
                    }
                    transformationStepDebug();
                }
            }

            /**
             * Flushes tree and discards calculated information.
             * 
             * Call this method at the end of perform() if it changed the tree.
             */
            void change() {
                setDAEBLT(BLT.EMPTY_BLT);
                setDAEInitBLT(BLT.EMPTY_BLT);
                DAEBiPGraph = null;
                root().flushAllRecursiveClearFinal();
            }
            
            @Override
            public String toString() {
                return getClass().getSimpleName() + ", operating on:\n\n" + FClass.this;
            }
        }
    /**
     * Perform transformation step debug operations that are activated.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:267
     */
    public void transformationStepDebug() {
        generateStepMof();
        sanityCheck();
    }
    /**
     * Generate a .mof file with the current flat tree.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:275
     */
    public void generateStepMof() {
        String value = myOptions().getStringOption("debug_transformation_steps");
        if ("full".equals(value)) {
            TRANSFORMATION_STEP_DIR.mkdir();
            TRANSFORMATION_STEP_HTML_DIR.mkdir();
            String fileName = String.format("%02d_%s.mof", completedTransformationSteps, lastCompletedTransformationStep);
            String htmlFileName = String.format("%02d_%s.html", completedTransformationSteps, lastCompletedTransformationStep);
            File file = new File(TRANSFORMATION_STEP_DIR, fileName);
            File htmlFile = new File(TRANSFORMATION_STEP_HTML_DIR, htmlFileName);
            log.debug("Writing flat tree after step " + lastCompletedTransformationStep + " to " + fileName);
            try {
                CodeStream out = new CodeStream(file);
                CodeStream htmlOut = new CodeStream(htmlFile);
                sourcePrettyPrint(out, "");
                htmlSourcePrettyPrint(htmlOut, "");
                out.close();
                htmlOut.close();
            } catch (IOException e) {
                log.warning("Failed to write step info to file " + file);
            }
        }
        if ("full".equals(value) || "diag".equals(value)) {
            TRANSFORMATION_STEP_DIR.mkdir();
            String fileName = String.format("%02d_%s.txt", completedTransformationSteps, lastCompletedTransformationStep);
            File file = new File(TRANSFORMATION_STEP_DIR, fileName);
            log.debug("Writing diag after step " + lastCompletedTransformationStep + " to " + fileName);
            try {
                CodeStream out = new CodeStream(file);
                out.print(modelDiagnostics());
                out.close();
            } catch (IOException e) {
                log.warning("Failed to write step info to file " + file);
            }
        }
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:311
     */
    private static final File TRANSFORMATION_STEP_DIR = new File("transformation_steps");
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:312
     */
    private static final File TRANSFORMATION_STEP_HTML_DIR = new File("transformation_steps_html");
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:314
     */
    private int completedTransformationSteps = 0;
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:315
     */
    private String lastCompletedTransformationStep = "flattening";
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:326
     */
    protected boolean doneTransformCanonical = false;
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:328
     */
    public void transformCanonical() {
        if (doneTransformCanonical)
            return;
        doneTransformCanonical = true;
        beginStep("transformCanonical()");

        transformCanonicalBase();
        

        root().flushAllRecursive();	
        transformCanonicalCleanup();
        getDAEBLT().errorCheck(this);
        getDAEInitBLT().errorCheck(this);

        endStep("transformCanonical()");
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:362
     */
    private HashMap<FVariable, AbstractEquationBlock> daeFVariableEquationBlockMap =
            new HashMap<FVariable, AbstractEquationBlock>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:370
     */
    private HashMap<FAbstractEquation, AbstractEquationBlock> daeEquationEquationBlockMap =
            new HashMap<FAbstractEquation, AbstractEquationBlock>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:381
     */
    private HashMap<FVariable,AbstractEquationBlock> daeInitFVariableEquationBlockMap = new HashMap<FVariable,AbstractEquationBlock>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:387
     */
    private HashMap<FAbstractEquation,AbstractEquationBlock> daeInitEquationEquationBlockMap = new HashMap<FAbstractEquation,AbstractEquationBlock>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:393
     */
    private ArrayList<FAbstractEquation> daeUnmatchedEquations = new ArrayList<FAbstractEquation>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:399
     */
    private ArrayList<FVariable> daeUnmatchedVariables = new ArrayList<FVariable>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:405
     */
    private ArrayList<FAbstractEquation> daeInitUnmatchedEquations = new ArrayList<FAbstractEquation>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:411
     */
    private ArrayList<FVariable> daeInitUnmatchedVariables = new ArrayList<FVariable>();
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:417
     */
    private BLT daeBLT = BLT.EMPTY_BLT;
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:418
     */
    public BLT getDAEBLT() {
        transformCanonical();
        return daeBLT;
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:423
     */
    public void setDAEBLT(BLT newBLT) {
        daeBLT = newBLT;
        daeFVariableEquationBlockMap = new HashMap<FVariable, AbstractEquationBlock>();
        daeEquationEquationBlockMap = new HashMap<FAbstractEquation, AbstractEquationBlock>();

        for (AbstractEquationBlock eb : daeBLT) {
            for (FVariable fv : eb.allVariables()) {
                daeFVariableEquationBlockMap.put(fv,eb);
            }

            for (FAbstractEquation equation : eb.allEquations()) {
            	daeEquationEquationBlockMap.put(equation, eb);
            }
        }

        if (newBLT == BLT.EMPTY_BLT)
            daeStructuredBLT = BLT.EMPTY_BLT;
        else
            daeStructuredBLT = new StructuredBLT(this, daeBLT);
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:444
     */
    private StructuredBLT daeStructuredBLT = BLT.EMPTY_BLT;
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:446
     */
    public StructuredBLT getDAEStructuredBLT() {
        transformCanonical();
        return daeStructuredBLT;
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:451
     */
    private BLT daeInitBLT = BLT.EMPTY_BLT;
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:453
     */
    public BLT getDAEInitBLT() {
        transformCanonical();
        return daeInitBLT;
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:458
     */
    public void setDAEInitBLT(BLT newBLT) {
        daeInitBLT = newBLT;
        daeInitFVariableEquationBlockMap = new HashMap<FVariable, AbstractEquationBlock>();
        daeInitEquationEquationBlockMap = new HashMap<FAbstractEquation, AbstractEquationBlock>();

        for (AbstractEquationBlock eb : daeInitBLT) {
            for (FVariable fv : eb.allVariables()) {
                daeInitFVariableEquationBlockMap.put(fv,eb);
            }

            for (FAbstractEquation equation : eb.allEquations()) {
                daeInitEquationEquationBlockMap.put(equation, eb);
            }
        }
        daeInitBLT.computeDependencies();
    }
    /**
     * Run matchings and BLT.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:483
     */
    
        /**
         * Run matchings and BLT.
         */
        public class computeMatchingsAndBLT extends Transformation {
            public computeMatchingsAndBLT() {
                super("automatic_add_initial_equations");
            }

            @Override
            public boolean active() {
                return super.active() && shouldPerformMatchingsAndBLT();
            }

            @Override
            public void perform() {
                computeMatchingsAndBLT();
                complianceCheckBLT();
                breakOnErrors();
            }
        }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:502
     */
    public void complianceCheckBLT() {
        getDAEBLT().complianceCheck(ErrorCheckType.COMPILE, myStepUtil());
        getDAEInitBLT().complianceCheck(ErrorCheckType.COMPILE, myStepUtil());
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:507
     */
    private static final EnumSet<BiPGraph.VarType> VAR_TYPES_NORMAL = 
            EnumSet.of(BiPGraph.VarType.DERIVATIVE_VARIABLES, 
                    BiPGraph.VarType.ALGEBRAIC_VARIABLES);
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:511
     */
    private static final EnumSet<BiPGraph.VarType> VAR_TYPES_REAL = 
            EnumSet.of(BiPGraph.VarType.DERIVATIVE_VARIABLES, 
                    BiPGraph.VarType.CONTINUOUS_ALGEBRAIC_VARIABLES);
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:515
     */
    private static final EnumSet<BiPGraph.VarType> VAR_TYPES_INIT = 
            EnumSet.of(BiPGraph.VarType.DIFFERENTIATED_VARIABLES, 
                    BiPGraph.VarType.DISCRETE_PRE_VARIABLES, 
                    BiPGraph.VarType.NON_FIXED_PARAMETERS);
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:520
     */
    private static final EnumSet<BiPGraph.VarType> VAR_TYPES_ALL = 
            EnumSet.of(BiPGraph.VarType.DERIVATIVE_VARIABLES, 
                    BiPGraph.VarType.ALGEBRAIC_VARIABLES, 
                    BiPGraph.VarType.DIFFERENTIATED_VARIABLES, 
                    BiPGraph.VarType.DISCRETE_PRE_VARIABLES, 
                    BiPGraph.VarType.NON_FIXED_PARAMETERS);
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:527
     */
    private BiPGraph computeMatchedDAEBiPGraph() {
        BiPGraph g = new BiPGraph();
        g.addVariables(this, VAR_TYPES_NORMAL);
        g.addEquations(equations(), VAR_TYPES_NORMAL);
        g.maximumMatching(true);
        daeUnmatchedVariables.clear();
        for (Var var : g.getUnmatchedVariables())
            daeUnmatchedVariables.add(var.getVariable());
        daeUnmatchedEquations.clear();
        for (Eq ee : g.getUnmatchedEquations())
            daeUnmatchedEquations.add(ee.getEquation());
        return g;
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:541
     */
    private BiPGraph DAEBiPGraph = null;
    /**
     * The symbolic equation sorting and canonicalization proceeds in the
     * following steps:
     * 
     * - The DAE system consisting of the DAE equations with algebraics and
     * derivatives treated as unknowns is matched to obtain a pairing
     * between equations and variables. Discrete and continuous algebraic
     * variables are treated equally in this respect.
     * 
     * - If a perfect matching is found, i.e., if there are no unmatched
     * equations or variables, the BLT algoritm is applied to compute
     * a sequence of stron components, corresponding to systems of equations.
     * 
     * - Having computed a matching and transformed the DAE into BLT form, 
     * the DAE initialization system is analyzed:
     * - The differentiated variables are added to the set of unknown 
     * variables of the system.
     * - The pre variables are added to the set of unknown variables of the
     * system.
     * - The initial equations are added to the set of equations of the 
     * system. This includes equations resulting from start values with
     * a corresonding fixed attribute set to true.
     * - When clauses are analyzed: if a when clause is explicitly enabled by
     * the initial() operator (whatever this means...), the when clause 
     * is excluded, otherwhise the equation pre(x) = x is added, where x 
     * is the variable that is solved for in the when clause.
     * 
     * - The matching algoritm is applied to the updated graph. Notice that it
     * is important that the result of the DAE matching is used as a starting
     * point: using this approach, derivatives and algebraics will remain
     * matched if possible and additional equations are added, if needed,
     * for differentiated variables. If there are 
     * unmatched equations, the transformation sequence terminates. If there
     * are unmatched variables, then additional initial equations are added 
     * in order to obtained a balanced system. For continuous variables, 
     * equations such as x = x.start are added, whereas for discrete variables
     * equations such as pre(x) = x.start are added.
     * 
     * - Finally, the BLT algorithm is applied to the resulting perfect
     * matchibng for the DAE initialization system.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:584
     */
    private void computeMatchingsAndBLT() {
        // Make sure that we don't do this if any errors have been reported
        breakOnErrors();
        StepUtil stepUtil = myStepUtil();

        logVerbose("Flat tree before matching and BLT:");
        logVerbose(this);

        BiPGraph g;
        if (DAEBiPGraph == null) {
            g = computeMatchedDAEBiPGraph();
            logVerbose("DAE BiPGraph");
            logVerbose(g);
            logVerbose("DAE BiPGraph matching");
            logVerbose(g.printMatchingObj());
        } else {
            g = DAEBiPGraph;
            DAEBiPGraph = null;
        }
		
        g.setStepLogger(stepUtil.getStepLogger()); //TODO refactor to setStepUtil
        logVerbose(g);
        
        // If no complete matching found, then fail
        if (!g.isComplete()) {
            checkStructure();
            breakOnErrors();
        } 

        // Perform BLT
        if (myOptions().getBooleanOption("equation_sorting") &&
                !myOptions().getBooleanOption("generate_only_initial_system") &&
                g.isComplete()) {
            BLT daeBLT;
            try {
                daeBLT = g.computeDAEBLT(stepUtil);
                if (blockFunctionExtraction(daeBLT, g)) {
                    daeBLT = g.computeDAEBLT(stepUtil);
                }
            } catch (BLTException e) {
                error(e.getMessage());
                return;
            }
            setDAEBLT(daeBLT);
            logVerbose(getDAEStructuredBLT());
            logVerbose(getDAEBLT());
        } else {
            setDAEBLT(BLT.EMPTY_BLT);
        }
        
        g.removeVariables(dynamicAlgebraicVariables());
        
        // Find matching for the initialization system
        g.addVariables(this, VAR_TYPES_INIT);
        g.addEquations(equations(), VAR_TYPES_INIT);
        g.setAsInitialSystem();
        
        // Replace when equations
        java.util.List<FAbstractEquation> equationsToReplace = new ArrayList<FAbstractEquation>();
        for (FAbstractEquation e : equations()) {
            if (e.replacedAtInitialization()) {
                equationsToReplace.add(e);
            }
        }
        
        Set<FAbstractVariable> existingPrePropagationLikeInitialEquations = new HashSet<FAbstractVariable>();
        for (FAbstractEquation eqn : initialEquations()) {
            FAbstractVariable var = eqn.isPrePropagationEquation();
            if (var != null)
                existingPrePropagationLikeInitialEquations.add(var);
        }
        
        Map<FAbstractVariable, FAbstractEquation> prePropagationEquations = new HashMap<FAbstractVariable, FAbstractEquation>();
        // Loop over all equations to replace
        for (FAbstractEquation equationToReplace : equationsToReplace) {
            
            // How many equations are there in this when clause?
            List<FAbstractEquation> newEquations = equationToReplace.getInitialEquations();
            
            // Put the Equations in an ArrayList rather than a List
            // TODO: There are probably more elegant ways to do this...
            java.util.List<FAbstractEquation> newEquations_ = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : newEquations) {
                FAbstractVariable var = e.isPrePropagationEquation();
                if (var == null) {
                    newEquations_.add(e);
                } else {
                    if (existingPrePropagationLikeInitialEquations.contains(var))
                        continue;
                    boolean hasOthers = false;
                    boolean assignedInAllBranches = false;
                    for (FAccessExp exp : var.uses()) {
                        FAbstractEquation eqn = exp.myFEquation();
                        if (eqn == null || eqn == e || eqn == equationToReplace || !(eqn.inEquationSection() || eqn.inInitialEquationSection()))
                            continue;
                        hasOthers = true;
                        if (eqn.assignedInAllBranches(var))
                            assignedInAllBranches = true;
                    }
                    
                    if (!hasOthers || assignedInAllBranches)
                        prePropagationEquations.put(var, e);
                    else
                        newEquations_.add(e);
                }
            }
            
            // - equationToReplace is an FAbstractEquation that should be replaced
            // - newEquations contains the new equations that replaces the equationToReplace
            // - Note that newEquations may contain several equations
            
            java.util.List<Eq> eq_list = new ArrayList<Eq>(g.getEquations(equationToReplace));
            
            for (Eq eqq : eq_list) {
                g.removeEquation(eqq);
            }
            
            if (!eq_list.isEmpty())
                g.addEquations(newEquations_, VAR_TYPES_ALL, eq_list.get(0).getName() + "_init_", new Enumerator(1));
        }
        
        logVerbose(g);
        
        g.addEquations(initialEquations(), VAR_TYPES_ALL);
        
        g.maximumMatching(false, prePropagationEquations.keySet());
        logVerbose("Init DAE BiPGraph");
        logVerbose(g);
        logVerbose("Init BiPGraph matching");
        logVerbose(g.printMatchingObj());
        
        g = overdeterminedInitialSystem(g);
        
        // Add initial equations if needed
        if (g.getUnmatchedEquations().isEmpty() && myOptions().getBooleanOption("automatic_add_initial_equations")) {
            for (Var var : g.getUnmatchedVariables()) {
                FVariable fv = var.getVariable();
                FAbstractEquation fe = prePropagationEquations.remove(fv);
                if (fe == null && fv.isPreVariable())
                    fe = prePropagationEquations.remove(fv.myNonPreVariable());
                if (fe == null) {
                    FAccessExp lhs = fv.isPreVariable() ? fv.createFPreExp() : fv.createAccessExp();
                    FExp rhs = fv.startAttributeSet() ? fv.startAttributeExp() : fv.type().zeroLiteral();
                    fe = new FEquation(lhs, rhs);
                    fe.setLocationNoTree(fv);
                    addFInitialEquation(fe);
                }
                g.addEquations(Collections.singletonList(fe), VAR_TYPES_ALL);
            }
            root().flushAllRecursive();
            
            g.maximumMatching(false);
            logVerbose("Init DAE BiPGraph after addition of initial equations");
            logVerbose(g);
            logVerbose("Init BiPGraph matching after addition of initial equations");
            logVerbose(g.printMatchingObj());
        }
        
        numIgnoredPrePropagationEquations = prePropagationEquations.size() 
                + existingPrePropagationLikeInitialEquations.size();
        
        for (Var var : g.getUnmatchedVariables()) {
            daeInitUnmatchedVariables.add(var.getVariable());
        }
        
        for (Eq ee : g.getUnmatchedEquations()) {
            daeInitUnmatchedEquations.add(ee.getEquation());
        }
        
        collectErrors(ErrorCheckType.COMPILE);
        breakOnErrors();
        
        if (myOptions().getBooleanOption("equation_sorting") && g.isComplete()) {
            g.tarjanReset();
            BLT daeInitBLT;
            try {
                daeInitBLT = g.computeInitDAEBLT(stepUtil);
                if (blockFunctionExtraction(daeInitBLT, g)) {
                    daeInitBLT = g.computeInitDAEBLT(stepUtil);
                }
            } catch (BLTException e) {
                error(e.getMessage());
                return;
            }
            setDAEInitBLT(daeInitBLT);
            logVerbose(daeInitBLT);
        } else {
            setDAEInitBLT(BLT.EMPTY_BLT);
        }
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:784
     */
    public void checkStructure() {
		if (myOptions().getBooleanOption("enable_structural_diagnosis")) {
			StringBuffer err_str = new StringBuffer("The system is structurally singular. ");
			if (writeUnmatchedElements(err_str, getDAEUnmatchedVariables(), getDAEUnmatchedEquations())) 
				error(err_str.toString());
			err_str = new StringBuffer("The initialization system is structurally singular. ");
			if (writeUnmatchedElements(err_str, getDAEInitUnmatchedVariables(), getDAEInitUnmatchedEquations())) 
				error(err_str.toString());
		}
	}
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:795
     */
    public static boolean writeUnmatchedElements(StringBuffer str, Collection<FVariable> unmatchedVariables, Collection<FAbstractEquation> unmatchedEquations) {
		boolean unbalanced = false;
		if (!unmatchedVariables.isEmpty()) {
			str.append("The following varible(s) could not be matched to any equation:\n");
			for (FVariable fv : unmatchedVariables) {
				str.append("     " + fv.name());
				str.append("\n");
			}
			unbalanced = true;
		}
		
		if (!unmatchedEquations.isEmpty()) {
			if (unbalanced) 
				str.append("\n  ");
			str.append("The following equation(s) could not be matched to any variable:\n");
			for (FAbstractEquation ee : unmatchedEquations) {
				str.append(ee.prettyPrint("    "));
				str.append("\n");
			}
			unbalanced = true;
		}
		return unbalanced;
	}
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:820
     */
    
        public class genAlgorithmFunctionsIfSet extends Transformation {
            public genAlgorithmFunctionsIfSet() {
                super("algorithms_as_functions");
            }
            
            public void perform() {
                genAlgorithmFunctions();
            }
        }
    /**
     * Generate functions from algorithms.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:834
     */
    public void genAlgorithmFunctions() {
		for (FAlgorithm alg : myAlgorithms()) {
			// Create function declaration
			List<FFunctionVariable> vars = new List<FFunctionVariable>();
			FAccess funcName = new FAccessString(alg.generateFunctionName());
			
			// - Find inputs
			ArrayList<FVariable> inVars = new ArrayList<FVariable>();
			ArrayList<FFunctionVariable> bothInVars = new ArrayList<FFunctionVariable>();
			for (FAccessExp use : alg.FAccessExpsInRHS()) {
				FAbstractVariable fv = use.myFV();
				if (!fv.isUnknown() && !inVars.contains(fv) && !fv.isForIndex()) {
					inVars.add((FVariable) fv);
					bothInVars.add(null);
				}
			}
			
			// - Create outputs, add to vars and locate those that are inputs as well
			ArrayList<FVariable> outVars = new ArrayList<FVariable>();
			for (FAccessExp use : alg.FAccessExpsInLHS()) {
				if (!use.myFV().isUnknown() && !outVars.contains(use.myFV())) {
					FVariable fv = (FVariable) use.myFV();
					FFunctionVariable ffv = fv.createFFunctionOutput();
					vars.add(ffv);
					outVars.add(fv);
					int i = inVars.indexOf(fv);
					if (i >= 0) 
						bothInVars.set(i, ffv);
				}
			}
			
			// - Create inputs, add to vars and update inputs and outputs that are the same
			ArrayList<FVariable> allVars = new ArrayList<FVariable>();
			allVars.addAll(inVars);
			allVars.addAll(outVars);
			
            List<FStatement> stmts = new List<FStatement>();
			for (int i = 0; i < inVars.size(); i++) {
				FVariable fv = inVars.get(i);
				FFunctionVariable ffv = fv.createFFunctionInput();
				vars.add(ffv);
				if (bothInVars.get(i) != null) {
					
					// Generate a new (unique) name for variable
					boolean nameExists = true;
					String name = null;
					for (int j = 0; nameExists; j++) {
						name = fv.name() + "_" + j;
						nameExists = false;
						for (FVariable fv2 : allVars)
							if (fv2.name().equals(name))
								nameExists = true;
					}
					
					// Rename input
                    ffv.setFAccess(new FAccessString(name));
					
					// Create and add binding expression for output
                    stmts.add(new FAssignStmt(bothInVars.get(i).createAccessExp(), ffv.createAccessExp()));
				}
			}
			
            for (FStatement stmt : alg.getFStatements()) {
                stmts.add(stmt);
            }
            alg.setFStatementList(stmts);
			
			// Create function call equation and replace algorithm
			List<FExp> args = new List<FExp>();
			for (int i = 0; i < inVars.size(); i++) 
				args.add(inVars.get(i).createAlgorithmArgument(bothInVars.get(i) != null));
			Size[] sizes = new Size[outVars.size()];
			for (int i = 0; i < outVars.size(); i++)
				sizes[i] = outVars.get(i).size();
            FType type = FFunctionType.create(funcName.name(), outVars, this);
            FFunctionCall call = new FFunctionCall(funcName, args, type);
			List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
			for (FVariable fv : outVars)
				lefts.add(fv.getFAccess().createFFunctionCallLeft());
			replaceEquation(alg, new FFunctionCallEquation(lefts, call));
			
			// Add return statement, create function declaration and add it to FClass 
			alg.addFStatement(new FReturnStmt());
			addFFunctionDecl(new FFunctionDecl(funcName, vars, alg, new List<FAttribute>()));
		}
	}
    /**
     * Replace one equation with another.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:924
     */
    public void replaceEquation(FAbstractEquation oldEq, FAbstractEquation newEq) {
		getFAbstractEquations().replaceChild(oldEq, newEq);
	}
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:980
     */
    
        
        public setFDerivativeVariables setFDerivativeVariables = new setFDerivativeVariables();
    /**
     * Remake all FDerivativeVariables.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:985
     */
    
        
        /**
         * Remake all FDerivativeVariables.
         */
        public class setFDerivativeVariables extends Transformation {
            protected Set<FVariable> variablesToVisit() {
                return new LinkedHashSet<FVariable>(differentiatedRealVariablesFilteredSet());
            }
            
            public void perform() {
                ArrayList<FVariable> l = new ArrayList<FVariable>();
                for (FVariable fv : getFVariables()) {
                    if (!fv.isDerivativeVariable()) {
                        l.add(fv);
                    }
                }
                for (FVariable fv : variablesToVisit()) {
                    if (fv.isDiscrete()) {
                        DIFFERENTIATED_DISCRETE_VARIABLE.invoke(fv, fv.name());
                    }
                    l.add(fv.createFDerivativeVariable());
                }
                setFVariableList(new List<FVariable>(l));
                root().flushAllRecursive();
                breakOnErrors();
            }
        }
    /**
     * Used by index reduction when removing derivatives of state select
     * prefer variables.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1013
     */
    
        
        /**
         * Used by index reduction when removing derivatives of state select
         * prefer variables.
         */
        private Set<FVariable> ssPreferVars = null;
    /**
     * Add derivative variables to the list of FVariables.
     * Derivative variable is added for a variable of either of the following is true:
     * - Occurres differentiated
     * - Have StateSelect always or prefer
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1021
     */
    
        
        /**
         * Add derivative variables to the list of FVariables.
         * Derivative variable is added for a variable of either of the following is true:
         *  - Occurres differentiated
         *  - Have StateSelect always or prefer
         */
        public class setFDerivativeVariablesPreBLT extends setFDerivativeVariables {
            @Override
            protected Set<FVariable> variablesToVisit() {
                ssPreferVars = new HashSet<FVariable>();
                Set<FVariable> fvsToVisit = super.variablesToVisit();
                boolean indexReductionActive = myOptions().getBooleanOption("index_reduction");
                for (FVariable fv : variables()) {
                    if (!fv.isReal()) {
                        continue;
                    }
                    FRealVariable.StateSelect ss = ((FRealVariable)fv).stateSelectAttribute();
                    if (!(ss == FRealVariable.StateSelect.ALWAYS
                            || ss == FRealVariable.StateSelect.PREFER && indexReductionActive)) {
                        continue;
                    }
                    if (ss == FRealVariable.StateSelect.PREFER && !fvsToVisit.contains(fv)) {
                        ssPreferVars.add(fv);
                    }
                    fvsToVisit.add(fv);
                }
                return fvsToVisit;
            }
        }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1046
     */
    public void addFDerivativeVariables(Collection<FVariable> fvs) {
        for (FVariable fv : fvs)
            addFVariable(fv);
        root().flushAllRecursive();
    }
    /**
     * Add pre variables to the list of FVariables, one for each
     * discrete variable and one for each continuous variable that is 
     * used in a pre() expression in an initial equation.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1089
     */
    
        /**
         * Add pre variables to the list of FVariables, one for each
         * discrete variable and one for each continuous variable that is 
         * used in a pre() expression in an initial equation.
         */
        public class addFPreVariables extends Transformation {
            public void perform() {
                ArrayList<FVariable> l = new ArrayList<FVariable>();
                for (FVariable fv : discreteVariables()) 
                    if (fv.myPreVariable().isUnknown())
                        l.add(fv.createPreVariable());
                for (FVariable fv : continuousVariablesUsedInPreInInitial())
                    if (fv.myPreVariable().isUnknown())
                        l.add(fv.createPreVariable());
                for (FVariable fv : l) 
                    addFVariableNoTransform(fv);
                root().flushAllRecursive();
            }
        }
    /**
     * Generate initial equations from variables with fixed start
     * attributes.
     * 
     * Intitial equations corresponding to explicitly set start attributes of 
     * differentiated variables are also generated, without taking the fixed
     * attribute into account.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1170
     */
    
        /**
         * Generate initial equations from variables with fixed start
         * attributes.
         * 
         * Intitial equations corresponding to explicitly set start attributes of 
         * differentiated variables are also generated, without taking the fixed
         * attribute into account.
         */
        public class genInitialEquations extends Transformation {
            public void perform() {
                // TODO: Isn't there always a value for fv.startAttributeExp() now?
                for (FVariable fv : variables()) {
                    boolean generate = false;
                    if (!myOptions().getBooleanOption("state_initial_equations") &&
                            fv.isDifferentiatedVariable() && (fv.isFixed() ||
                            myOptions().getBooleanOption("state_start_values_fixed")))
                        generate = true;
                    else if (!myOptions().getBooleanOption("state_initial_equations") &&
                            fv.isAlgebraicContinousRealVariable() && fv.isFixed())
                        generate = true;
                    else if (fv.isDiscrete() && fv.isFixed()) {
                        generate = true;
                    }
                    
                    if (generate) {
                        FExp lhs = fv.setLocationOf(fv.isDiscrete() ? fv.createFPreExp() : fv.createAccessExp());
                        FExp rhs = fv.setLocationOf(fv.startAttributeSet() ? fv.startAttributeExp().fullCopy() : fv.type().zeroLiteral());
                        addFInitialEquation(new FEquation(lhs, rhs));
                    }
                }
                root().flushAllRecursive();
            }
        }
    /**
     * This field is populated by computeMatchingsAndBLT, there are some models
     * where the initial system is defined so that pre propgation equations
     * such as x = pre(x) can't be inserted. These equations are then ignored
     * which must be accounted for during balance computations.
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1264
     */
    private int numIgnoredPrePropagationEquations = 0;
    /**
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1283
     */
    public void checkFClassDimensions() {
               // Check dimensions of DAE
		int n_eq_F = numDAEEquations();
		int n_vars_F = numDAEVariables();
		if (n_eq_F != n_vars_F) 
			error("The DAE system has " + n_eq_F + " equations and " + n_vars_F + " free variables.");
		
		// Check dimensions of DAE initialization system
		int n_eq_F0 = numDAEInitEquations();
		int n_vars_F0 = numDAEInitVariables();
		if (n_eq_F0 > n_vars_F0) 
			error("The DAE initialization system has " + n_eq_F0 + " equations and " + n_vars_F0 + " free variables.");
		
	}
    /**
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1298
     */
    public void collectErrors(ErrorCheckType checkType) {
		checkFClassDimensions();
		checkStructure();
		allChecks(checkType);
	}
    /**
     * Flush model AST and enable rewrites of FAccessExps and FDerExps
     * after alias elimination.
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1348
     */
    public void flush() {
		flushAllRecursiveClearFinal();
		//is$Final = true;
	}
    /**
     * @aspect StateInitialEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1374
     */
    
        public class addStateInitialEquationsIfSet extends Transformation {
            // Constraints: after alias elimination (see #), before BLT
            
            public addStateInitialEquationsIfSet() {
                super("state_initial_equations");
            }
            
            public void perform() {
                addStateInitialEquations();
            }
        }
    /**
     * @aspect StateInitialEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1387
     */
    public void addStateInitialEquations() {
        setFInitialEquationList(new List());
        
        for (FVariable fv : differentiatedRealVariables()) {
            FAccess nameToAdd = fv.getFAccess().copyAndAddPrefix("_start_");
            FRealVariable fvToAdd = new FRealVariable(VisibilityType.PUBLIC, Variability.FIXEDPARAMETER, nameToAdd);
            if (fv.startAttributeSet())
                fvToAdd.setBindingExp(fv.startAttributeExp().ceval().buildLiteral());
            else
                fvToAdd.setBindingExp(fv.type().zeroLiteral());
            addFVariable(fvToAdd);
            FEquation eqnToAdd = new FEquation(fv.createAccessExp(), fvToAdd.createAccessExp());
            addFInitialEquation(eqnToAdd);
            flushAllRecursive();
        }
    }
    /**
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1409
     */
    
        public class enableSemiLinearRewrite extends Transformation {
            private boolean changed = false;
            
            public void perform() {
                setFAbstractEquationList(transform(getFAbstractEquations()));
                setFInitialEquationList(transform(getFInitialEquations()));
                setParameterEquationList(transform(getParameterEquations()));
                
                // Change all remaining semiLinear exps to if exps.
                Set<FSemiLinearExp> fsls = collectSemiLinearExps();
                changed = changed || fsls.size() > 0;
                for (FSemiLinearExp exp: fsls)
                    exp.replaceMe(exp.asIfExp());
                
                if (changed) {
                    change();
                }
            }
            
            /**
             * Applies zero flow transformations to a list of equations.
             */
            private List<FAbstractEquation> transform(List<FAbstractEquation> equations) {
                ListMap<String, FEquation> rule1 = new LinkedHashListMap<String, FEquation>();
                ArrayList<FEquation> rule2 = new ArrayList<FEquation>();
                List<FAbstractEquation> newEquations = new List<FAbstractEquation>();
                
                // Find zero flow equations
                for (FAbstractEquation equation : equations) {
                    if (equation.isConstantZeroFlow()) {
                        rule2.add((FEquation) equation);
                    } else if (equation.isZeroFlowForm()) {
                        FEquation e = (FEquation) equation;
                        rule1.add(e.zeroFlowGetKey(), e);
                    }
                }
                
                // Chained zero flow transformations (Rule 1)
                for (java.util.List<FEquation> l : rule1.values()) {
                    if (l.size() > 1) {
                        transformChain(newEquations, buildChain(l));
                        changed = true;
                    }
                }
                
                changed = changed || rule2.size() > 0;
                
                // Constant zero flow transformations (Rule 2)
                for (FEquation equation : rule2) {
                    equation.setLeft(equation.zeroFlowGetPos());
                    equation.setRight(equation.zeroFlowGetNeg());
                }
                
                List<FAbstractEquation> res = removeMarkedEqns(equations);
                res.addAll(newEquations);
                return res;
            }
            
            /**
             * Order the equations in <code>l</code> by matching the slopes in
             * the semiLinear expressions. If any equation cannot be ordered an
             * error is given.
             */
            private ArrayList<FEquation> buildChain(java.util.List<FEquation> l) {
                ArrayList<FEquation> chain = new ArrayList<FEquation>();
                FEquation eq1 = l.remove(0);
                chain.add(eq1);
                
                boolean change = true;
                while (change) {
                    change = false;
                    Iterator<FEquation> it = l.iterator();
                    while (it.hasNext()) {
                        FEquation eq2 = it.next();
                        if (addToChain(chain, eq2)) {
                            change = true;
                            it.remove();
                        }
                    }
                }
                
                if (l.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Could not construct zero flow chain for a set of semilinear equations."
                            + " This leads to an undetermined system. Involved equations:\n");
                    
                    for (FEquation e : chain) {
                        sb.append(e.prettyPrint(""));
                        sb.append("\n");
                    }
                    for (FEquation e : l) {
                        sb.append(e.prettyPrint(""));
                        sb.append("\n");
                    }
                    
                    l.get(0).error(sb.toString());
                }
                return chain;
            }
            
            /**
             * Add an equation to the chain if the slopes match
             */
            private boolean addToChain(ArrayList<FEquation> chain, FEquation equation) {
                FExp pos = equation.zeroFlowGetPos();
                FExp neg = equation.zeroFlowGetNeg();
                FExp chainNeg = chain.get(chain.size()-1).zeroFlowGetNeg();
                FExp chainPos = chain.get(0).zeroFlowGetPos();
                
                if (chainNeg.prettyPrint("").equals(pos.prettyPrint(""))) {
                    chain.add(equation);
                    return true;
                } else if (chainPos.prettyPrint("").equals(neg.prettyPrint(""))) {
                    chain.add(0, equation);
                    return true;
                }
                return false;
            }
            
            /**
             * Build new equations to represent the chain of semiLinears
             */
            private void transformChain(List<FAbstractEquation> newEquations, ArrayList<FEquation> chain) {
                for (FEquation e : chain)
                    e.markedForRemoval = true;
                
                FEquation first = chain.get(0);
                FEquation last  = chain.remove(chain.size()-1);
                FExp chainPos   = first.zeroFlowGetPos();
                FExp chainNeg   = last.zeroFlowGetNeg();
                FExp chainX     = first.zeroFlowGetX();
                
                // S(1) = if X >= 0 SA else SB
                newEquations.add(new FEquation(
                        first.zeroFlowGetNeg().fullCopy(), 
                        new FIfExp(new FGeqExp(chainX.fullCopy(), new FIntegerLitExp(0)),
                                chainPos.fullCopy(),
                                chainNeg.fullCopy()
                                )));
                
                // S(n+1) = S(n)
                FEquation pre_e = null;
                for (FEquation e : chain) {
                    if (pre_e != null)
                        newEquations.add(new FEquation(e.zeroFlowGetNeg().fullCopy(), pre_e.zeroFlowGetNeg().fullCopy()));
                    pre_e = e;
                }
                
                // Y = semiLinear(X,SA,SB)
                FExp slExp = new FSemiLinearExp(chainX.fullCopy(), chainPos.fullCopy(), chainNeg.fullCopy());
                newEquations.add(new FEquation(
                        first.zeroFlowGetLeft().fullCopy(),
                        slExp.negated(first.zeroFlowNegated())
                        ));
            }
        }
    /**
     * Transformation for marking up variables that have reinit() applied on them as states
     * (by setting stateSelect=always).
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1662
     */
    
        /**
         * Transformation for marking up variables that have reinit() applied on them as states
         * (by setting stateSelect=always).
         */
        public class MakeReinitedVarsStates extends Transformation {
            public void perform() {
                for (FAbstractEquation eqn : getFAbstractEquations())
                    eqn.makeReinitedVarsStates();
            }
        }
    /**
     * Perform alias elimination if it is activated.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:23
     */
    
        /**
         * Perform alias elimination if it is activated.
         */
        public class aliasEliminationIfSet extends Transformation {
            public aliasEliminationIfSet() {
                super("eliminate_alias_variables");
            }
            
            public void perform() {
                genAlias();
                propagateDerivativeBindings();
                sortAliasVariables(false);
                sortAliasEquations();
                enableAliasRewrite();
                change();
                removeUnusedTemporaries();
                mergeEquivalentRecords();
                insertTempsInLHS();
                remoteRedundantInitialEquations();
                change();
            }
            
            public void propagateDerivativeBindings() {
                // Collect derivative binding equations, however only if we are going
                // to perform index reduction!
                if (myOptions().getBooleanOption("propagate_derivatives")) {
                    for (FAbstractEquation equation : getFAbstractEquations()) {
                        if (!equation.isAliasEquation()) {
                            equation.propagateDerivativeBindings();
                        }
                    }
                }
            }
        }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:55
     */
    
        
        public aliasEliminationIfSet aliasElimination = new aliasEliminationIfSet();
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:58
     */
    ArrayList<String> aliasErrors = new ArrayList<String>();
    /**
     * Generate alias information and remove alias equations.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:196
     */
    public void genAlias() {
		if (aliasManager == null) {
			aliasManager = new AliasManager();
		}
		for (FAbstractEquation equation : getFAbstractEquations()) {
			// Iterate over all equations
			// If the equation is an alias equation, then register
			// the alias variables in the alias manager.
			// Check all alias equations, also those that that have been
			// checked before.
			equation.aliasClassified = false; 
			if (equation.isAliasEquation()) 
				aliasManager.addAliasVariables(equation.aliasVariables());
		}
        if (myOptions().getBooleanOption("eliminate_alias_parameters")) {
            for (FAbstractEquation equation : getParameterEquations()) {
                equation.aliasClassified = false; 
                if (equation.isAliasEquation()) 
                    aliasManager.addAliasVariables(equation.aliasVariables());
            }
        }
        if (myOptions().getBooleanOption("eliminate_alias_constants")) {
            Map<String, FVariable> firstOccurencesReal = new HashMap<String, FVariable>();
            Map<String, FVariable> firstOccurencesNonReal = new HashMap<String, FVariable>();
            for (FVariable fv : getFVariables()) {
                fv.classifyAliasConstant(aliasManager, firstOccurencesReal, firstOccurencesNonReal);
            }
        }
        aliasManager.reportAliasErrors(this);
	}
    /**
     * Eliminate alias variables from the flat model.
     * 
     * The non-alias variables are kept in the list FClass.FVariableList but the
     * alias variables are moved to FClass.AliasVariablesList.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:248
     */
    public void sortAliasVariables(boolean recompute) {
        ArrayList<FVariable> nonAliasVars = new ArrayList<FVariable>();
        ArrayList<FVariable> aliasVars    = new ArrayList<FVariable>();
        if (recompute) {
            for (FVariable fv : getAliasVariables()) {
                fv.aliasSort(nonAliasVars, aliasVars);
            }
        } else {
            for (FVariable fv : getAliasVariables()) {
                aliasVars.add(fv);
            }
        }
        for (FVariable fv : getFVariables()) {
             fv.aliasSort(nonAliasVars, aliasVars);
        }
        setFVariableList(new List(nonAliasVars));
        setAliasVariableList(new List(aliasVars));
    }
    /**
     * Eliminate alias equation from the flat model.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:270
     */
    public void sortAliasEquations() {
        ArrayList<FAbstractEquation> eqns = new ArrayList<FAbstractEquation>();
        ArrayList<FAbstractEquation> pEqns = new ArrayList<FAbstractEquation>();
        for (FAbstractEquation equation : getFAbstractEquations()) {
            if (!equation.isAliasEquation()) {
                eqns.add(equation);
            }
        }
        if (myOptions().getBooleanOption("eliminate_alias_parameters")) {
            for (FAbstractEquation equation : getParameterEquations()) { 
                if (!equation.isAliasEquation()) {
                    pEqns.add(equation);
                }
            }
            setParameterEquationList(new List(pEqns));
        }
        setFAbstractEquationList(new List(eqns));
    }
    /**
     * Remove all unused temporary variables, and inline temporaries only used once.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:498
     */
    public void removeUnusedTemporaries() {
        ArrayList<FVariable> temps = tempVariables();
        Collection<FVariable> tempsToRemove = new ArrayList<FVariable>();
        int oldSize = Integer.MAX_VALUE;
        while (temps.size() < oldSize) {
            ArrayList<FVariable> temps2 = new ArrayList<FVariable>(temps.size());
            for (FVariable fv : temps) {
                if (!fv.inlineUses()) {
                    temps2.add(fv);
                } else {
                    tempsToRemove.add(fv);
                }
            }
            oldSize = temps.size();
            temps = temps2;
        }
        
        ArrayList<FVariable> vars = new ArrayList<FVariable>();
        for (FVariable fv : getFVariables())
            if (!fv.isTemporary())
                vars.add(fv);
        for (FVariable fv : temps)
            vars.add(fv);
        
        removeMarkedEqns();
        setFVariableList(new List(vars));
        
        Set<FVariable> aliasVarsToRemove = new HashSet<FVariable>();
        
        for (FVariable fv : tempsToRemove) {
            aliasVarsToRemove.addAll(getAliasManager().removeTemporaryVariableSet(fv));
        }
        
        ArrayList<FVariable> newAliasVars = new ArrayList<FVariable>();
        for (FVariable fv : getAliasVariables()) {
            if (!aliasVarsToRemove.contains(fv)) {
                newAliasVars.add(fv);
            }
        }
        setAliasVariableList(new List(newAliasVars));
    }
    /**
     * Remove all equations with <code>markedForRemoval == true</code>. 
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:704
     */
    public void removeMarkedEqns() {
		setFInitialEquationList(removeMarkedEqns(getFInitialEquations()));
		setParameterEquationList(removeMarkedEqns(getParameterEquations()));
		setFAbstractEquationList(removeMarkedEqns(getFAbstractEquations()));
	}
    /**
     * Remove records that are equivalent, and update uses. 
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:746
     */
    public void mergeEquivalentRecords() {
		computeEquivalentRecords();
		activateEquivalentRecordUseRewrite();
		List<FRecordDecl> list = new List<FRecordDecl>();
		for (FRecordDecl rec : getFRecordDecls())
			if (rec.equivalentRecordToKeep)
				list.add(rec);
		setFRecordDeclList(list);
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:756
     */
    public void computeEquivalentRecords() {
        ArrayList<FRecordType> distinctTypes = new ArrayList<>();
        ArrayList<FRecordDecl> keptDecl = new ArrayList<>();
        equivalentRecordComponentOrderMap = new HashMap<>();
        for (FRecordDecl rec : getFRecordDecls()) {
            boolean found = false;
            FRecordType type = rec.type();
            for (int i = 0; !found && i < distinctTypes.size(); i++) {
                FRecordType other = distinctTypes.get(i);
                /* TODO: Also check that this type is not used in any external functions.
                 *       If it is, do not remove it (if the one chosen to be kept isn't used 
                 *       in an external, keep this one instead). */
                if (type.typeCompatible(other)) {
                    found = true;
                    rec.equivalentRecordGroup = i;
                    type.addComponentReorderFrom(other, equivalentRecordComponentOrderMap);
                }
            }
            if (!found) {
                rec.equivalentRecordToKeep = true;
                rec.equivalentRecordGroup = distinctTypes.size();
                distinctTypes.add(type);
                keptDecl.add(rec);
            }
        }
        equivalentRecordMap = new HashMap<>();
        for (FRecordDecl rec : getFRecordDecls())
            equivalentRecordMap.put(rec.name(), keptDecl.get(rec.equivalentRecordGroup));
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:807
     */
    protected Map<String,FRecordDecl> equivalentRecordMap;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:808
     */
    protected Map<String,int[]> equivalentRecordComponentOrderMap;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:875
     */
    public FRecordAccess createEquivalentRecordAccess(FRecordAccess old) {
		FRecordDecl rec = equivalentRecordMap.get(old.name());
		return (rec != null) ? rec.getFAccess().createFRecordAccess() : old;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:880
     */
    public int[] getEquivalentRecordComponentOrder(FAccess old) {
        return equivalentRecordComponentOrderMap.get(old.name());
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:884
     */
    public FType createEquivalentRecordType(FType old) {
        FRecordDecl rec = equivalentRecordMap.get(old.name());
        if (rec == null) {
            return old;
        }
        FType t = rec.type().fullCopy();
        t.transferSizes(old);
        return t;
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:910
     */
    public void insertTempsInLHS() {
        for (FAbstractEquation equation : getParameterEquations()) {
            equation.insertTempsInLHS(this, true);
        }
        for (FAbstractEquation equation : getFAbstractEquations()) {
            equation.insertTempsInLHS(this, false);
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:976
     */
    public void remoteRedundantInitialEquations() {
        ArrayList<FAbstractEquation> eqns = new ArrayList<FAbstractEquation>();
        // Remove alias equations.
        for (FAbstractEquation equation : getFInitialEquations()) {
            if (!equation.isSameVariableEquality()) {
                eqns.add(equation);
            }
        }
        setFInitialEquationList(new List(eqns));
    }
    /**
     * An FClass has an alias manager.
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:113
     */
    private AliasManager aliasManager = new AliasManager();
    /**
     * Get the alias manager.
     * 
     * @return the alias manager.
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:120
     */
    public AliasManager getAliasManager() {
		return aliasManager;
	}
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:20
     */
    public boolean blockFunctionExtraction(BLT blt, BiPGraph g) {
        if (!myOptions().getBooleanOption("enable_block_function_extraction"))
            return false;
            
        ArrayList<FFunctionCall> functions = new ArrayList<FFunctionCall>();
        HashMap<String,FVariable> newVars = new HashMap<String, FVariable>();
        
        // Find functions to extract from current block
        for (AbstractEquationBlock block: blt)
            if (!block.isSimple())
                for (FAbstractEquation equation: block.allEquations())
                    equation.findBlockFunctionExtraction(block, functions);
                    
        // If no functions are found do not proceed
        if (functions.isEmpty())
            return false;
        
        // If functions are found replace them with new variables and add equations: new_var = func()
        ArrayList<FAbstractEquation> newEqs = new ArrayList<FAbstractEquation>();
        for (FFunctionCall fCall: functions) {
            FVariable funcRepVariable = null;
            if ((funcRepVariable = newVars.get(fCall.toString())) == null) { // If funcCall hasn't been processed before
                // Create new temp. variable and add it to the variable list and the BiPGraph
                String newTempName = fCall.calcTempVarName();
                Collection<Eq> eqs = g.getEquations(fCall.myFEquation());
                funcRepVariable = fCall.type().createTempFVariable(new FAccessFull(newTempName), fCall.variability());
                addFVariable(funcRepVariable);
                if (!fCall.variability().parameterOrLess()) {
                    Var var = g.addVariable(newTempName, funcRepVariable);
                    for (Eq eqn : eqs) {
                        eqn.addVariable(var);
                    }
                }
                newVars.put(fCall.toString(), funcRepVariable);
                // Create new equation "temp = funcCall()" and add it to the equation list and list for BiPGraph
                
                FEquation newEq = new FEquation(funcRepVariable.createAccessExp(), fCall.fullCopy());
                if (!fCall.variability().parameterOrLess()) {
                    addFEquation(newEq);
                    newEqs.add(newEq);
                } else {
                    addParameterEquation(newEq);
                }
            }
            // Replace the functionCall with a use of the corresponding temp variable
            fCall.replaceMe(funcRepVariable.createAccessExp());
        }
        // Add the equations to the BiPGraph and make new matchings
        root().flushAllRecursive();
        g.addEquations(newEqs, VAR_TYPES_ALL);
        g.maximumMatching(true);
            
        return true;
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:21
     */
    
        public class commonSubexpressionEliminationIfSet extends Transformation {
            
            Map<String, CSESet> m;
            
            public commonSubexpressionEliminationIfSet() {
                super("common_subexp_elim");
            }
            
            public void perform() {
                m = new LinkedHashMap<String, CSESet>();
                
                getFAbstractEquations().collectFunctionCalls(this);
                
                boolean changed = false;
                for (CSESet s : m.values()) {
                    boolean res = s.eliminate();
                    changed = changed || res;
                }
                
                m = null;
                
                if (changed) {
                    List<FAbstractEquation> l = new List<FAbstractEquation>();
                    for (FAbstractEquation fae : getFAbstractEquations()) {
                        if (!fae.markedForRemoval) {
                            l.add(fae);
                        }
                    }
                    
                    setFAbstractEquationList(l);
                    
                    change();
                }
            }
            
            public void add(FAbstractFunctionCall fc) {
                String s = fc.prettyPrint("");
                CSESet l = m.get(s);
                if (l == null) {
                    l = new CSESet();
                    m.put(s,l);
                }
                l.add(fc);
            }
            
            public class CSESet extends ArrayList<FAbstractFunctionCall> {
                private FExp repl = null;
                private List<FFunctionCallLeft> res = null;
                
                public boolean eliminate() {
                    if (size() > 1) {
                        FAbstractFunctionCall fc = get(0);
                        FAbstractFunctionCall fcCopy = (FAbstractFunctionCall) fc.copySymbolic();
                        res = new List<FFunctionCallLeft>();
                        res.setParent(fc);
                        
                        merge();
                        
                        FAbstractEquation fae;
                        if (res.getNumChild() != 1 || fc.isComposite()) {
                            add(new FFunctionCallEquation(res, fcCopy));
                        } else {
                        	fae = get(0).setLocationOf(new FEquation(res.getChild(0).getFExp(), fcCopy));
                        	fae.addLocation(get(1));
                            add(fae);
                        }
                        return true;
                    }
                    return false;
                }
                
                public void merge() {
                    for (FAbstractFunctionCall ffc : this) {
                        if (ffc.isFunctionCallClause()) {
                            FFunctionCallEquation fce = (FFunctionCallEquation) ffc.myFEquation();
                            for (int i = 0; i < fce.getNumLeft(); i++) {
                                if (fce.getLeft(i).hasFExp()) {
                                    merge(i, fce.getLeft(i).getFExp());
                                }
                            }
                            ffc.myFEquation().markForRemoval();
                        } else {
                            ffc.replaceMe(getRepl().fullCopy());
                        }
                    }
                }
                
                public void merge(int i, FExp other) {
                    if (i >= res.getNumChild()) {
                        res.add(new FFunctionCallLeft());
                    }
                    res.getChild(i).merge(this, other);
                }
                
                public void add(FAbstractEquation fae) {
                    fae.parent = getFAbstractEquationListNoTransform();
                    if (fae.variability().parameterOrLess()) {
                        addParameterEquationNoTransform(fae);
                    } else {
                        addFAbstractEquationNoTransform(fae);
                    }
                }

                public FExp getRepl() {
                    if (repl != null) {
                        return repl;
                    }

                    FAbstractFunctionCall call = get(0);

                    final TypePrefixVariability variability = call.variability().combine(
                            Variability.FIXEDPARAMETER).combineDown(call.type().funcOutputVariability());

                    FAbstractVariable var = variablesMap().lookup(call.tempVarName());
                    if (var == null) {
                        var = call.tempVar(variability, call.type());
                        addFVariable(var.asFVariable());
                        variablesMap().addVariable(var);
                    }

                    repl = var.createAccessExp();
                    merge(0, repl);
                    return repl;
                }

            }

        }
    /**
     * Reduce the number of event indicators by eliminating relative
     * operators that are equal. This is done by traversing the normal
     * equation system and the initial equation system and storing all
     * relative operations in a map that translate toString() to a list
     * of relative operators that are equal.
     * Operators are then eliminating by setting the originalFRelExp
     * field in the redundant operators.
     * The normal operator should be used if equal operators exists in
     * both the normal and initial blocks. This is achieved by inserting all
     * normal equations into the map before the initial equations and then
     * selecting the first in the list as the original operator.
     * Note that we can't eliminate if we have any switch in the normal
     * equation section but the selected switch is in the initial system!
     * @aspect EqualSwitchElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\EqualSwitchElimination.jrag:35
     */
    
        /**
         * Reduce the number of event indicators by eliminating relative
         * operators that are equal. This is done by traversing the normal
         * equation system and the initial equation system and storing all
         * relative operations in a map that translate toString() to a list
         * of relative operators that are equal.
         * Operators are then eliminating by setting the originalFRelExp
         * field in the redundant operators.
         * The normal operator should be used if equal operators exists in
         * both the normal and initial blocks. This is achieved by inserting all
         * normal equations into the map before the initial equations and then
         * selecting the first in the list as the original operator.
         * Note that we can't eliminate if we have any switch in the normal
         * equation section but the selected switch is in the initial system!
         */
        public class eliminateEqualSwitches extends Transformation {
            public void perform() {
                Map<String, Collection<FRelExp>> candidates = new HashMap<String, Collection<FRelExp>>();
                for (FRelExp exp : relExpsWithEvent()) {
                    exp.collectEqualSwitches(candidates);
                    exp.setOriginalFExp(exp);
                } 
                for (FRelExp exp : eventExpInInitialEquations()) {
                    exp.collectEqualSwitches(candidates);
                    exp.setOriginalFExp(exp);
                }
                for (Map.Entry<String, Collection<FRelExp>> entry : candidates.entrySet()) {
                    if (entry.getValue().size() < 2)
                        continue;
                    boolean anyInDAE = false;
                    FRelExp original = null;
                    for (FRelExp exp : entry.getValue()) {
                        anyInDAE |= exp.inEquationSection();
                        if (!exp.hasBrancher() && !(exp.inFArray() && exp.inFunctionCall())) {
                            original = exp;
                            break;
                        }
                    }
                    if (original == null) {
                        // Found no switch that meet our requirements
                        continue;
                    }
                    if (original.inInitialEquationSection() && anyInDAE) {
                        // If the "original" exp is in the initial DAE and we have other exps in the DAE, then we can't
                        // eliminate! Cause the others in the DAE have guards (or other reason) for not getting picked
                        // before the one in initial!
                        continue;
                    }
                    log.verbose("Eliminated %d equal switches: %s", entry.getValue().size() - 1, entry.getKey());
                    for (FRelExp exp : entry.getValue()) {
                        exp.setOriginalFExp(original);
                    }
                }
                root().flushAllRecursive();
            }
        }
    /**
     * If function inlining is enabled, inline all function calls that we can.
     * 
     * Then remove functions that aren't needed anymore. Functions with <code>LateInline=true</code> 
     * or <code>InlineAfterIndexReduction=true</code> are excepted.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:28
     */
    
        /**
         * If function inlining is enabled, inline all function calls that we can.
         * 
         * Then remove functions that aren't needed anymore. Functions with <code>LateInline=true</code> 
         * or <code>InlineAfterIndexReduction=true</code> are excepted.
         */
        public class FunctionInliningIfSet extends Transformation {
            protected String opt;
            protected boolean late;

            /**
             * Creates a transformation for function inlining.
             */
            public FunctionInliningIfSet() {
                this.late = false;
            }

            public boolean active() {
                opt = myOptions().getStringOption("inline_functions");
                return opt != OptionRegistry.Inlining.NONE;
            }

            public void perform() {
                new FunctionInliner(FClass.this, opt, late).inline();
                root().flushAllRecursive();
                removeUnusedTemporaries();
                change();
            }
        }
    /**
     * If function inlining is enabled, inline all function calls that we can.
     * 
     * Then remove functions that aren't needed anymore. Functions with <code>LateInline=true</code> 
     * or <code>InlineAfterIndexReduction=true</code> are included.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:59
     */
    

        
        /**
         * If function inlining is enabled, inline all function calls that we can.
         * 
         * Then remove functions that aren't needed anymore. Functions with <code>LateInline=true</code> 
         * or <code>InlineAfterIndexReduction=true</code> are included.
         */
        public class LateFunctionInliningIfSet extends FunctionInliningIfSet {
            /**
             * Creates a transformation for late function inlining.
             */
            public LateFunctionInliningIfSet() {
                this.late = true;
            }
        }
    /**
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:26
     */
    
        private static final int ALIAS_SIZE = 2;
    /**
     * <h1>Eliminate Linear Equations</h1>
     * <p>
     * Eliminates <i>simple</i> linear equations from a set of equations.
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:33
     */
    

        /**
         *  <h1>Eliminate Linear Equations</h1>
         *  <p>
         *  Eliminates <i>simple</i> linear equations from a set of equations.
         */
        public class eliminateLinearEquations extends Transformation {

            public eliminateLinearEquations() {
                super("eliminate_linear_equations");
            }

            @Override
            public void perform() {
                ArrayList<FAbstractEquation> equations = new ArrayList<FAbstractEquation>();
                for (FAbstractEquation faq : getFAbstractEquations()) {
                    if (faq.isSimpleLinear()) {
                        equations.add(faq);
                    }
                }

                Set<FAbstractEquation> modified = new HashSet<FAbstractEquation>();
                Map<FAbstractEquation, Map<String, Integer>> equationMap = new LinkedHashMap<>();
                for (int i = 0; i < equations.size(); ++i) {
                    FAbstractEquation src = equations.get(i);

                    Map<String, Integer> srcCoeff = src.coefficientMap();
                    if (hasSuperfluousTerms(srcCoeff)) {
                        FAbstractEquation newEquation = removeSuperfluousTerms(src, srcCoeff);
                        equations.set(i, newEquation);
                        modified.add(newEquation);
                    }
                    equationMap.put(src, srcCoeff);

                    for (int j = i + 1; j < equations.size(); ++j) {
                        FAbstractEquation dest = equations.get(j);

                        if (modified.contains(dest)) {
                            continue;
                        }
                        
                        if (!equationMap.containsKey(dest)) {
                            equationMap.put(dest, dest.coefficientMap());
                        }
                        FAbstractEquation newEquation = removeAliasesFromEquations(equationMap, src, dest);
                        if (newEquation != null) {
                            // ASTNode.log.debug("Rewriting " + dest + ", using\n\t" + src + "\n\tto\n" +
                            //         newEquation + ".");
                            equations.set(j, newEquation);
                            modified.add(newEquation);
                        }
                    }
                }
            }

            /**
             * Checks if an equation has terms that cancel out, i.e. "x + z = y + z".
             */
            protected boolean hasSuperfluousTerms(Map<String, Integer> coeffs) {
                for (int coeff : coeffs.values()) {
                    if (coeff == 0) {
                        return true;
                    }
                }
                return false;
            }

            /**
             * Removes any terms that cancel out from the equation, i.e. "x + z = y + z" -> "x = y".
             */
            protected FAbstractEquation removeSuperfluousTerms(
                    FAbstractEquation oldEquation, Map<String, Integer> coeffs) {
                ArrayList<FExp> leftExps = new ArrayList<FExp>();
                ArrayList<FExp> rightExps = new ArrayList<FExp>();
                for (String key : coeffs.keySet()) {
                    int coeff = coeffs.get(key);
                    if (coeff > 0) {
                        leftExps.add(newTerm(coeff, key));
                    } else if (coeff < 0) {
                        rightExps.add(newTerm(-coeff, key));
                    }
                }
                FAbstractEquation newEquation = new FEquation(addTree(leftExps), addTree(rightExps));
                oldEquation.replaceMe(newEquation);
                return newEquation;
            }

            /**
             *  Removes an alias expression mutual for two equations.
             *  
             *  @param  equationMap
             *          An equation map; each equation key maps to another map which maps the terms used in the
             *          equation to their respective coefficients.
             *  @param  source
             *          The equation to compare against {@code dest}.
             *  @param  dest
             *          The equation to compare against {@code source}. This equation will be overwritten in case a
             *          sub-expression is eliminated.
             *  @return
             *          The modified equation, {@code null} otherwise.
             */
            protected FAbstractEquation removeAliasesFromEquations(
                    Map<FAbstractEquation, Map<String, Integer>> equationMap,
                    FAbstractEquation source, FAbstractEquation dest) {
                
                Map<String, Integer> coeffSource = equationMap.get(source);
                Map<String, Integer> coeffDest   = equationMap.get(dest);
                
                Set<String> mutual       = new LinkedHashSet<>();
                Set<String> uniqueSource = new LinkedHashSet<>();
                Set<String> uniqueDest   = new LinkedHashSet<>();
                
                if (!coefficientSort(mutual, uniqueSource, uniqueDest, coeffSource, coeffDest)) {
                    return null;
                }
                
                int beforeSize = eqnWeight(coeffDest);
                
                String pivot = mutual.iterator().next();
                mutual.remove(pivot);
                
                // Calculate coefficients to use
                int c1 = coeffSource.get(pivot);
                int c2 = coeffDest.get(pivot);
                int cSign = (c1 * c2 >= 0) ? 1 : -1;
                int rCoeffMul = Math.abs(c2) * cSign;
                int lCoeffMul = Math.abs(c1);
                
                ArrayList<Integer> coeffs = new ArrayList<>();
                for (String key : uniqueDest) {
                    coeffs.add(lCoeffMul * coeffDest.get(key));
                }
                for (String key : uniqueSource) {
                    coeffs.add(rCoeffMul * coeffSource.get(key));
                }
                
                ArrayList<String> mutualToUse = new ArrayList<>();
                for (String key : mutual) {
                    int coeff = c2 * coeffSource.get(key) - c1 * coeffDest.get(key);
                    if (coeff != 0) {
                        if (c1 < 0) {
                            coeff = -coeff;
                        }
                        coeffs.add(coeff);
                        mutualToUse.add(key);
                    }
                }
                
                // Minimize coefficients
                int gcd = coeffDivisor(coeffs);
                for (int i = 0, n = coeffs.size(); i < n; i++) {
                    coeffs.set(i, coeffs.get(i) / gcd);
                }
                
                // Check if new equation is better
                if (eqnWeight(coeffs, uniqueDest, uniqueSource, mutualToUse) >= beforeSize) {
                    return null;
                }
                
                // Create expressions
                ArrayList<FExp> leftExps = new ArrayList<>();
                ArrayList<FExp> rightExps = new ArrayList<>();
                int i = 0;
                for (String key : uniqueDest) {
                    leftExps.add(newTerm(coeffs.get(i++), key));
                }
                for (String key : uniqueSource) {
                    rightExps.add(newTerm(coeffs.get(i++), key));
                }
                for (String key : mutualToUse) {
                    rightExps.add(newTerm(coeffs.get(i++), key));
                }
                
                FAbstractEquation newEqn = new FEquation(addTree(leftExps), addTree(rightExps));
                dest.replaceMe(newEqn);
                return newEqn;
            }

            /**
             * Calculate the weight to use for a given coefficient map key when deciding if 
             * the transformation is beneficial.
             * 
             * Literals gives 1, variables 3 or 4 (3 if coeff == 1), and time 5.
             */
            protected int keyWeight(String key, int coeff) {
                if (coeff == 0) {
                    return 0;
                } else if (key.equals(FLitExp.COEFF_KEY)) {
                    return 1;
                } else if (key.equals(FTimeExp.COEFF_KEY)) {
                    return 5;
                } else {
                    return (coeff == 1) ? 3 : 4;
                }
            }

            /**
             * Calculate the weight of a proposed equation, using keyWeight() for the weight
             * of an individual term.
             */
            protected int eqnWeight(ArrayList<Integer> coeffs, Collection<String>... keySets) {
                int res = 0;
                int i = 0;
                for (Collection<String> keySet : keySets) {
                    for (String key : keySet) {
                        res += keyWeight(key, coeffs.get(i));
                        i++;
                    }
                }
                return res;
            }

            /**
             * Calculate the weight of an existing equation, using keyWeight() for the weight
             * of an individual term.
             */
            protected int eqnWeight(Map<String, Integer> coeffMap) {
                int res = 0;
                for (String key : coeffMap.keySet()) {
                    res += keyWeight(key, coeffMap.get(key));
                }
                return res;
            }

            /**
             * Returns the greatest common divisor of two integers.
             * 
             * Uses Euclid's algorithm.
             */
            public int gcd(int a, int b) {
                while (b != 0) {
                    int tmp = b;
                    b = a % b;
                    a = tmp;
                }
                return a;
            }

            /**
             * Returns the greatest common divisor of a collection of integers, with the same 
             * sign as the majority of the integers.
             * 
             * Uses Euclid's algorithm.
             */
            public int coeffDivisor(Collection<Integer> n) {
                Iterator<Integer> i = n.iterator();
                int res = i.hasNext() ? i.next() : 0;
                int neg = (res < 0) ? 1 : 0;
                while (i.hasNext()) {
                    int v = i.next();
                    res = gcd(res, v);
                    if (v < 0) {
                        neg++;
                    }
                }
                res = Math.abs(res);
                return (neg > n.size() / 2) ? -res : res;
            }

            /**
             * Sorts coefficient keys according to whether or not they exist in both equations' key sets or not.
             * 
             * @param   mutual
             *          The set in which to put keys present in both equations.
             * @param   sourceUnique
             *          The set in which to put keys only present in the source equation.
             * @param   destUnique
             *          The set in which to put keys only present in the destination equation.
             * @param   sourceKeys
             *          The coefficient keys of the source equation.
             * @param   destKeys
             *          The coefficient keys of the destination equation.
             */
            private boolean coefficientSort(Set<String> mutual, Set<String> sourceUnique, Set<String> destUnique,
                    Map<String, Integer> coeffSrc, Map<String, Integer> coeffDest) {

                Set<String> destKeys = coeffDest.keySet();
                for (String key : coeffSrc.keySet()) {
                    if (coeffSrc.get(key) != 0) {
                        if (destKeys.contains(key) && coeffDest.get(key) != 0) {
                            mutual.add(key);
                        } else {
                            sourceUnique.add(key);
                        }
                    }
                }
                for (String key : destKeys) {
                    if (coeffDest.get(key) != 0 && !mutual.contains(key)) {
                        destUnique.add(key);
                    }
                }

                if (mutual.isEmpty()) {
                    return false;
                }

                return (!sourceUnique.isEmpty() || !destUnique.isEmpty()) && 
                       sourceUnique.size() + destUnique.size() <= ALIAS_SIZE;
            }

            /* ========================= *
             *  Create new expressions.  *
             * ========================= */

            private FExp addTree(ArrayList<FExp> exps) {
                if (exps.size() == 0) {
                    return new FIntegerLitExp(0);
                }
                if (exps.size() == 1) {
                    return exps.get(0);
                }
                return FExp.createBalancedBinaryTree(new FAddExp(), exps);
            }

            private FExp addTree(FExp exp, ArrayList<FExp> exps) {
                return new FAddExp(exp, addTree(exps));
            }

            private FExp newDivision(int nominator, int denominator) {
                if (nominator % denominator == 0) {
                    return new FIntegerLitExp(nominator / denominator);
                }
                return new FDivExp(new FIntegerLitExp(nominator), new FIntegerLitExp(denominator));
            }

            private FExp newTerm(String expKey) {
                if (expKey.equals(FLitExp.COEFF_KEY)) {
                    return new FIntegerLitExp(1);
                } else if (expKey.equals(FTimeExp.COEFF_KEY)) {
                    return new FTimeExp();
                }
                return new FAccessExp(expKey);
            }

            private FExp newTerm(int coeff, String expKey) {
                FExp res = newTerm(expKey);
                if (coeff != 1) {
                    res = new FMulExp(new FIntegerLitExp(coeff), res);
                }
                return res;
            }
        }
    /**
     * Runs variability propagation if option is set.
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:97
     */
    
        /**
         * Runs variability propagation if option is set.
         */
        public class variabilityPropagationIfSet extends Transformation {
            public variabilityPropagationIfSet() {
                super("variability_propagation");
            }
            
            public void perform() {
                FClass.VariabilityPropagator propagator = new FClass.VariabilityPropagator();
                variabilityPropagation(propagator);
                constantFolding(propagator.evaluator());
                root().flushAllRecursiveClearFinal();
            }
        }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:110
     */
    
        
        public class VariabilityPropagator {
            private LinkedHashSet<FAbstractEquation> worklist = new LinkedHashSet<FAbstractEquation>();
            private boolean splitAliasParameters = !(myOptions().getBooleanOption("eliminate_alias_variables") 
                    && myOptions().getBooleanOption("eliminate_alias_parameters"));
            private boolean splitAliasConstants  = !(myOptions().getBooleanOption("eliminate_alias_variables") 
                    && myOptions().getBooleanOption("eliminate_alias_constants"));
            private boolean propagateInitial     = myOptions().getBooleanOption("variability_propagation_initial");
            private boolean propagateAlgorithms  = myOptions().getBooleanOption("variability_propagation_algorithms");
            private boolean propagateInitialPartial = myOptions().getBooleanOption("variability_propagation_initial_partial");
            
            private VariableEvaluator evaluator       = 
                    new VariableEvaluator(
                            myOptions().getBooleanOption("variability_propagation_external"));
            private VariableEvaluator partialEvaluator = 
                    new PartialVariableEvaluator(
                            myOptions().getBooleanOption("variability_propagation_external"));
            
            public VariabilityPropagator() {
                
            }
            
            public LinkedHashSet<FAbstractEquation> getWorklist() {
                return worklist;
            }
            
            public VariableEvaluator evaluator() {
                return evaluator;
            }
            
            public VariableEvaluator evaluator(TypePrefixVariability variability) {
                if (variability.knownParameterOrLess()) {
                    return evaluator;
                } else {
                    return partialEvaluator;
                }
            }
            
            public void addEquation(TypePrefixVariability v, FAbstractEquation fae) {
                if (v.initialParameterVariability()) {
                    addFInitialEquationNoTransform(fae);
                } else {
                    addParameterEquationNoTransform(fae);
                }
            }
            
            public void addWorkEq(FAbstractEquation fae) {
                worklist.add(fae);
            }
            
            public boolean splitAliasParameters() {
                return splitAliasParameters;
            }
            
            public boolean splitAliasConstants() {
                return splitAliasConstants;
            }
            
            public boolean propagateInitial() {
                return propagateInitial;
            }
            
            public boolean propagateInitialPartial() {
                return propagateInitialPartial;
            }
            
            public boolean propagateAlgorithms() {
                return propagateAlgorithms;
            }
            
            public Set<FVariable> variables(FAbstractEquation equation) {
                return equation.isInitial() ? equation.initialParameters() : equation.variables();
            }
            
            public Set<FVariable> variables(FAbstractEquation equation, TypePrefixVariability variability) {
                return variability.initialParameterVariability() ? equation.initialParameters() : equation.variables();
            }
            
            public List<FAbstractEquation> cleanEquations(TypePrefixVariability v, 
                    List<FAbstractEquation> equations) {
                ArrayList<FAbstractEquation> newEquations = new ArrayList<FAbstractEquation>();
                for (FAbstractEquation equation: equations) {
                    equation.cleanEquations(newEquations, v);
                }
                return new List<FAbstractEquation>(newEquations);
            }
            
            public boolean canPropagate(FEquation equation) {
                if (equation.isInitial()) {
                    return equation.initialParameters().size() == 1 && equation.variables().isEmpty();
                } else {
                    return equation.variables().size() == 1;
                }
            }
            
            public void updateEquation(FVariable fv, FAbstractEquation equation,
                    TypePrefixVariability newVariability) {
                variables(equation, fv.variability()).remove(fv);
                if (newVariability != null && !newVariability.fixedParameterOrLess()) {
                    variables(equation, newVariability).add(fv);
                }
            }
            
            public boolean moveEquation(TypePrefixVariability variability, FAbstractEquation equation) {
                if (equation.isInitial() ? variability.fixedParameterVariability() : variability.parameterVariability()) {
                    addEquation(variability, equation);
                    equation.taggedByVProp = variability;
                    return true;
                } else {
                    return false;
                }
            }
        }
    /**
     * Runs variability propagation.
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:239
     */
    public void variabilityPropagation(FClass.VariabilityPropagator propagator) {
        
        LinkedHashSet<FAbstractEquation> worklist  = propagator.getWorklist();
        List<FAbstractEquation> parameterEquations = getParameterEquations();
        List<FAbstractEquation> initialEquations   = getFInitialEquations();
        List<FAbstractEquation> equations          = getFAbstractEquations();
        
        // Build worklist
        if (propagator.propagateInitial()) {
            for (FAbstractEquation equation: initialEquations) {
                equation.addEquationsToWorkList(worklist);
            }
        }
        for (FAbstractEquation equation: equations) {
            equation.addEquationsToWorkList(worklist);
        }
        
        // Work
        while (!worklist.isEmpty()) {
            FAbstractEquation equation = worklist.iterator().next();
            if (equation.canPropagate(propagator)) {
                equation.variabilityPropagation(propagator);
            }
            worklist.remove(equation);
        }
        
        // Clean variables
        ArrayList<FVariable> newVariables = new ArrayList<FVariable>();
        ArrayList<FVariable> newAliases   = new ArrayList<FVariable>();
        AliasManager am = getAliasManager();
        for (FVariable fVariable: getFVariables()) {
            if (!fVariable.taggedByVProp) {
                newVariables.add(fVariable);
            }
        }
        for (FVariable fVariable: getAliasVariables()) {
            if (am.getAliasSet(fVariable) != null) {
                newAliases.add(fVariable);
            } else if (!fVariable.isTemporary()) {
                newVariables.add(fVariable);
            }
        }
        setFVariableList(new List<FVariable>(newVariables));
        setAliasVariableList(new List<FVariable>(newAliases));
        
        // Clean equations
        setFAbstractEquationList(propagator.cleanEquations(Variability.CONTINUOUS,       equations));
        setFInitialEquationList( propagator.cleanEquations(Variability.INITIALPARAMETER, initialEquations));
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:240
     */
    public boolean noUnrollingInFunctions() {
        return myOptions().getBooleanOption("no_loop_unrolling_in_functions");
    }
    /**
     * Flag indicating if a flat class is scalarized.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:252
     */
    boolean scalarized = false;
    /**
     * Scalarize all variables and equations in the flat model.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:261
     */
    
        /**
         * Scalarize all variables and equations in the flat model.
         */
        public class scalarize extends Transformation {
            public void perform() {
                List<FVariable> vars = new List<FVariable>();
                Scalarizer.Variable sv = new Scalarizer.Variable(vars);
                scalarizeVars(sv);
                setFVariableList(vars);
                scalarizeFuncs();
                scalarizeTypes();
                scalarizeAttributes(sv.sp);
                getConnectionSetManager().scalarize();
                scalarized = true;
                scalarizationCleanup();
                scalarizationErrorCheck();
            }
        }
    /**
     * Scalarize variable declarations and equations.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:281
     */
    protected void scalarizeVars(Scalarizer.Variable sv) {
        
        FAbstractEquation.scalarizeList(sv.sc, getFAbstractEquations());
        FAbstractEquation.scalarizeList(sv.si, getFInitialEquations());
        FAbstractEquation.scalarizeList(sv.sp, getParameterEquations());
        
        for (FVariable fv : getFVariables()) {
            fv.scalarize(sv);
        }
        
        setFAbstractEquationList(sv.sc.getClauses());
        setFInitialEquationList(sv.si.getClauses());
        setParameterEquationList(sv.sp.getClauses());
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:296
     */
    protected void scalarizeFuncs() {
		for (FFunctionDecl f : getFFunctionDecls()) 
			f.scalarize();
	}
    /**
     * Handles scalarization of the FAttributes that are declared in the FClass
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:304
     */
    private void scalarizeAttributes(Scalarizer s) {
        List<FAttribute> attrs = new List<FAttribute>();
        for (FAttribute a : getFAttributes())
            a.scalarize(attrs, Index.NULL, s);
        setFAttributeList(attrs);
    }
    /**
     * Scalarize type declarations by removing array-valued attributes. 
     * They have been copied to the variables when the variables were scalarized. 
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:315
     */
    protected void scalarizeTypes() {
		for (FDerivedType t : getFDerivedTypes())
			t.removeArrayValuedAttributes();
	}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:359
     */
    protected void scalarizationCleanup() {
        flush();  // Must flush before traversing
    }
    /**
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:214
     */
    public void applyDynamicStateResult(IndexReductionResult result) {
        if (result.hasDSFailed()) {
            warning("Unable to use dynamic states since there are too big sets. Using static states instead");
            return;
        }
        DynamicStateManager manager = getDynamicStateManager();
        for (IndexReductionBiPGraph.DSSet resSet : result.getDSSets()) {
            List<FAccessExp> varList = new List<>();
            for (IndexReductionVar var : resSet.vars) {
                FVariable fVar = var.getVariable();
                if (fVar.order() == 1)
                    varList.add(fVar.getMeIntegrated().createAccessExp());
                else
                    varList.add(new FAccessExp(fVar.getFAccess().createDerPrefixedName(fVar.order() - 1)));
            }
            List<DynamicStateCoefficient> coffList = new List<DynamicStateCoefficient>();
            for (int eqn = 0; eqn < resSet.coefficients.length; eqn++) {
                for (int var = 0; var < resSet.coefficients[eqn].length; var++) {
                    if (resSet.coefficients[eqn][var] != null)
                        coffList.add(new DynamicStateCoefficient(eqn, var, resSet.coefficients[eqn][var]));
                }
            }
            DynamicStateSet set = new DynamicStateSet(manager.nextId(), resSet.eqns.size(), varList, coffList, null, null);
            FDynamicAlgebraicVariable[] algebraicVars = new FDynamicAlgebraicVariable[set.numAlgebraics()];
            for (int i = 1; i <= set.numAlgebraics(); i++) {
                FDynamicAlgebraicVariable var = new FDynamicAlgebraicVariable(set, i);
                algebraicVars[i - 1] = var;
                addFVariable(var);
            }
            set.setAlgebraicVars(algebraicVars);
            FDynamicStateVariable[] stateVars = new FDynamicStateVariable[set.numStates()];
            for (int i = 1; i <= set.numStates(); i++) {
                FDynamicStateVariable var = new FDynamicStateVariable(set, i);
                stateVars[i - 1] = var;
                addFVariable(var);
                addFEquation(new FEquation(new FDerExp(var.createFAccess()), new FDSDerExp(set.id(), i)));
            }
            set.setStateVars(stateVars);
            manager.addSet(set);
        }
        enableDynamicStateRewrite();
    }
    /**
     * Generate array initialization statements for unknown function arrays.
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:23
     */
    
        /**
         * Generate array initialization statements for unknown function arrays.
         */
        public class genInitArrayStatements extends Transformation {
            public void perform() {
                for (FFunctionDecl ffd : getFFunctionDecls()) {
                    ffd.sortBindingAssignments();
                }
            }
        }
    /**
     * Generate array initialization statements for unknown function arrays.
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:36
     */
    
        /**
         * Generate array initialization statements for unknown function arrays.
         */
        public class indexReduction extends Transformation {
            public indexReduction() {
                super("index_reduction");
            }
            
            public void perform() {
                try {
                    // Make sure that we don't do this if any errors have been reported previously
                    breakOnErrors();
                    
                    DAEBiPGraph = computeMatchedDAEBiPGraph();
                    if (shouldReduceIndex(DAEBiPGraph))
                        reduceIndex();
                } catch (IndexReductionException e) {
                    if (indexReductionErrorsAsWarnings())
                        warning(e.getMessage());
                    else
                        error(e.getMessage());
                    // We need to check structure and give warning since a bad system can affect index reduction
                    checkStructure();
                } catch (EquationDifferentiationException e) {
                    error(e.getMessage());
                }
                breakOnErrors();
            }
        }
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:64
     */
    private boolean shouldReduceIndex(BiPGraph g) {
        return !g.isComplete() && continuousEquations().size() > 0 && derivativeVariables().size() > 0;
    }
    /**
     * Perform index reduction on model.
     * 
     * @return  the new graph
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:73
     */
    private void reduceIndex() {
        logVerbose("Flat tree before index reduction");
        logVerbose(this);
        logVerbose("Index reduction starts...");
        IndexReductionResult result;
        while (true) {
            IndexReductionBiPGraph g = new IndexReductionBiPGraph();
            g.setStepLogger(this);
            // Only do index reduction based on real variables and equations
            g.addVariables(this, VAR_TYPES_REAL);
            g.addEquations(continuousNonMetaEquations(), VAR_TYPES_REAL);
            logVerbose(g);
            g.maximumMatching(true);
            logVerbose("DAE system real variables only");
            logVerbose(g.printMatchingObj());
            
            try {
                boolean printPantelidesSteps = g.getEquations().size() <= myOptions().getIntegerOption("diagnostics_limit");
                if (!printPantelidesSteps) {
                    logVerbose("The BiPGraph will not be printed during pantelides, the model is too big. "
                            + "Limit, compiler option 'diagnostics_limit', is set to %d and model size is %d. ",
                            myOptions().getIntegerOption("diagnostics_limit"), g.getEquations().size());
                }
                int dynamicStatesLimit = myOptions().getBooleanOption("dynamic_states") ?
                        myOptions().getIntegerOption("dynamic_states_limit") :
                        0;
                result = g.reduceIndex(new IndexReductionFunctionInliner(this),
                        dynamicStatesLimit,
                        myOptions().getIntegerOption("munkres_max_incidences"),
                        printPantelidesSteps);
                break;
            } catch (EquationDifferentiationException e) {
                logVerbose("Unable to differentiate equation:\n%s", e.equation);
                if (ssPreferVars == null || ssPreferVars.isEmpty())
                    throw e;
                Set<FVariable> removableVars = g.removablePreferDerivatives(ssPreferVars);
                if (removableVars.isEmpty())
                    throw e;
                logVerbose("Retrying index reduction without the following state select prefer derivatives:");
                for (FVariable var : removableVars) {
                    logVerbose("  %s", var.name());
                    ssPreferVars.remove(var.getMeIntegrated());
                }
                logVerbose("");
                
                // Remove SS=prefer derivatives
                List<FVariable> vars = new List<FVariable>();
                for (FVariable var : getFVariableListNoTransform()) {
                    if (!removableVars.contains(var))
                        vars.add(var);
                }
                setFVariableList(vars);
                root().flushAllRecursive();
            }
        }
        
        // Add the new equations
        // Replace selected dummy derivatives with algebraics
        // Enable rewrite of identifiers? (not necessary?)
        for (FAbstractEquation fe : result.getEquations()) {
            if (fe.variability().fixedParameterOrLess()) {
                addParameterEquation(fe);
            } else if (fe.variability().parameterOrLess()) {
                addFInitialEquation(fe);
            } else {
                addFEquation(fe);
            }
        }
        
        getAliasManager().stopCollectingDerivativeBindings();
        
        Collection<FVariable> l = new ArrayList<FVariable>();
        
        for (FVariable fv : getFVariables()) {
            if (fv.isDerivativeVariable()) {
                if (result.getDummyDerivatives().contains(fv)) {
                    FDummyDerivativeVariable fdv = new FDummyDerivativeVariable(fv.getVisibilityType(),
                        fv.getTypePrefixVariability(), fv.getFAccess().fullCopy(), fv.order());
                    l.add(fdv);
                } else if (fv.order() > 1) {
                    // Convert higher order derivative variables into
                    // first order derivatives, generating variables for each step
                    FAccess accessPrev = fv.getFAccess().treeCopy();
                    for (int i = 1; i < fv.order(); i++) {
                        FAccess access = fv.getFAccess().createDerPrefixedName(i);
                        l.add(new FRealVariable(VisibilityType.PUBLIC,
                                fv.getTypePrefixVariability(), access.fullCopy()));
                        // Derivative variable is added later
                        addFEquation(new FEquation(new FAccessExp(access), new FDerExp(accessPrev.treeCopy())));
                        accessPrev = access;
                    }
                }
            } else {
                l.add(fv);
            }
        }

        setFVariableList(new List<FVariable>(l));

        applyDynamicStateResult(result);
        
        logVerbose(this);
        
        enableFHDerRewrite();

        // flushAllRecursiveClearFinal must be used here in order to
        // trigger rewrites of FDerExp -> FDummyDerExp
        root().flushAllRecursiveClearFinal();

        aliasElimination.apply();
        // Add derivative variables
        setFDerivativeVariables.apply();

        root().flushAllRecursive();

        logVerbose(this);
        logVerbose(aliasManager);

        // Produce errors and warnings:
        Set<FVariable> stateSelectAlwaysVars = new HashSet<FVariable>();
        for (FVariable fv : variables()) {
            if (fv.aliasSet() != null) {
                for (AliasManager.AliasVariable av : fv.aliasSet()) {
                    if (av.getFVariable().stateSelectAttribute() == FRealVariable.StateSelect.ALWAYS)
                        stateSelectAlwaysVars.add(av.getFVariable());
                }
            } else if (fv.stateSelectAttribute() == FRealVariable.StateSelect.ALWAYS) {
                stateSelectAlwaysVars.add(fv);
            }
        }
        for (FVariable fv : differentiatedRealVariables()) {
            if (fv.stateSelectAttribute() == FRealVariable.StateSelect.NEVER)
                fv.warning(fv.name() + " has stateSelect=never, but must be selected as state");
            stateSelectAlwaysVars.remove(fv);
        }
        for (FVariable fv : stateSelectAlwaysVars) 
            if (fv.isSetInReinit())
                fv.error(fv.name() + " is assigned in reinit(), but could not be selected as state");
            else
                fv.warning(fv.name() + " has stateSelect=always, but could not be selected as state");

        logInfo(stateDiagnosticsObj());
        
        DAEBiPGraph = computeMatchedDAEBiPGraph();
        logVerbose("BiPGraph after index reduction");
        logVerbose(DAEBiPGraph);
        logVerbose("BiPGraph matching after index reduction");
        logVerbose(DAEBiPGraph.printMatchingObj());

        if (!DAEBiPGraph.isComplete()) {
            // If we get here, index reduction failed
            throw new IndexReductionException();
        }
    }
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:228
     */
    public Object stateDiagnosticsObj() {
        return new Object() {
            public String toString() {
                if (differentiatedRealVariables().isEmpty())
                    return "There are no states in the model";
                StringBuilder sb = new StringBuilder();
                sb.append("States:\n");
                for (FVariable fv : differentiatedRealVariables()) {
                    if (fv.isDynamicState())
                        continue;
                    if (fv.isFDynamicStateVariable()) {
                        FDynamicStateVariable var = fv.asFDynamicStateVariable();
                        if (var.getNumber() != 1)
                            continue;
                        DynamicStateSet set = var.getSet();
                        sb.append(String.format("  Set of dynamic states with %d states and %d algebraics:\n", set.numStates(), set.numAlgebraics()));
                        for (FVariable state : set.fVars()) {
                            sb.append(state.prettyPrint("    "));
                            sb.append('\n');
                        }
                    } else {
                        sb.append(fv.prettyPrint("  "));
                        sb.append('\n');
                    }
                }
                return sb.toString();
            }
        };
    }
    /**
     * Given a BiPGraph, this method remove all redundant unmatched initial
     * equations.
     * Returns a BiPGraph with no unmatched equations on success (might be the
     * same as inputed to the method).
     * @aspect OverdeterminedInitialSystem
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\OverdeterminedInitialSystem.jrag:27
     */
    public BiPGraph overdeterminedInitialSystem(BiPGraph g) {
        AbstractBiPGraph<Eq, Var, ?>.OISResult res = g.overdeterminedInitialSystem();
        if (res == null)
            return g;
        
        Set<FAbstractEquation> eqnsToRemove = new HashSet<FAbstractEquation>();
        for (Eq e : res.redundentEquations) {
            g.removeEquation(e);
            eqnsToRemove.add(e.getEquation());
        }
        
        List<FAbstractEquation> newInitList = new List<FAbstractEquation>();
        for (FAbstractEquation eqn : getFInitialEquations()) {
            if (!eqnsToRemove.contains(eqn))
                newInitList.add(eqn);
        }
        setFInitialEquationList(newInitList);
        
        for (FVariable var : res.visitedParameters) {
            if (!var.isParameter())
                continue;
            
            AliasManager.AliasSet aliasSet = var.aliasSet();
            if (aliasSet != null) {
                for (AliasManager.AliasVariable alias : aliasSet) {
                    alias.getFVariable().setTypePrefixVariability(Variability.STRUCTPARAMETER);
                }
            } else {
                var.setTypePrefixVariability(Variability.STRUCTPARAMETER);
            }
        }
        
        return g;
    }
    /**
     * Extracts event generating expressions into if expressions
     * and replaces the exp with a temp var.
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:24
     */
    
        /**
         * Extracts event generating expressions into if expressions
         * and replaces the exp with a temp var.
         */
        public class ExtractEventGeneratingExpressions extends Transformation {
            public void perform() {
                HashSet<FAlgorithm> algs = new HashSet<FAlgorithm>();
                ArrayList<FExp> eventExps = eventGenExps();
                Collections.reverse(eventExps);

                // Equations.
                for (FExp exp: eventExps) {
                    FVariable fv = exp.type().createFVariable(VisibilityType.PUBLIC,
                            new FAccessFull(exp.tempVarName()), exp.variability());
                    addFVariable(fv);
                    addFInitialEquation(new FEquation(exp.tempPreExp(), fv.createStartAttributeExp()));

                    if (exp.inAlgorithm()) {
                        algs.add((FAlgorithm) exp.myFEquation());
                        continue;
                    }
                    addFEquation(new FEquation(exp.tempUseExp(), exp.eventTempExpCalc()));
                    exp.replaceMe(exp.eventTempExpUse());

                    addFEquations(exp.extractEventGenEquation());
                    addFInitialEquations(exp.extractEventGenInitialEquation());
                }

                // Algorithms.
                Transformer.visitAlgorithms(algs, new EventAlgorithmTransformer(myOptions()));

                root().flushAllRecursive();
            }
        }
    /**
     * Transforms equations and algorithms. Currently the following transformations exist:
     * <ul>
     * <li>{@link AlgorithmIndicatorGenerator}; generates event indicators for algorithm statements.</li>
     * <li>{@link EquationIndicatorGenerator}; generates event indicators for equations.</li>
     * </ul>
     * <p>
     * Options used by this transformation step:
     * <ul>
     * <li>{@link OptionRegistry.OptionSpecification#EVENT_OUTPUT_VARS event_output_vars}</li>
     * </ul>
     * Note that the latter, which enables generation of indicator equations if no indicator statements are needed,
     * is disabled by default when running tests.
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:35
     */
    

        /**
         * Transforms equations and algorithms. Currently the following transformations exist:
         * <ul>
         * <li>{@link AlgorithmIndicatorGenerator}; generates event indicators for algorithm statements.</li>
         * <li>{@link EquationIndicatorGenerator}; generates event indicators for equations.</li>
         * </ul>
         * <p>
         * Options used by this transformation step:
         * <ul>
         * <li>{@link OptionRegistry.OptionSpecification#EVENT_OUTPUT_VARS event_output_vars}</li>
         * </ul>
         * Note that the latter, which enables generation of indicator equations if no indicator statements are needed,
         * is disabled by default when running tests.
         */
        public class GenerateEventIndicators extends Transformation {

            @Override
            public void perform() {
                OptionRegistry options = myOptions();
                Transformer.visitAlgorithms(algorithms(), new AlgorithmIndicatorGenerator(FClass.this, options));
                Transformer.visitEquations(FClass.this, new EquationIndicatorGenerator(options));
                flushAllRecursive();
            }
        }
    /**
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:25
     */
    

        public class enableIfEquationElimination extends Transformation {

            /**
             * Eliminates unnecessary if equations; if a test can be determinedly evaluated to false or true
             * the functions in the if or else branche's block can be discarded or inlined respectively.
             * <p>
             * Depends on MakeReinitedVarsStates when invoked after scalarization.
             */
            @Override
            public void perform() {
                List<FAbstractEquation> newEquations = new List<FAbstractEquation>();
                List<FAbstractEquation> newInitialEquations = new List<FAbstractEquation>();
                List<FAbstractEquation> newParameterEquations = new List<FAbstractEquation>();

                for (FAbstractEquation equation : getFAbstractEquations()) {
                    equation.eliminateIfEquations(newEquations);
                }

                for (FAbstractEquation equation : getFInitialEquations()) {
                    equation.eliminateIfEquations(newInitialEquations);
                }

                for (FAbstractEquation equation : getParameterEquations()) {
                    equation.eliminateIfEquations(newParameterEquations);
                }

                setFAbstractEquationList(newEquations);
                setFInitialEquationList(newInitialEquations);
                setParameterEquationList(newParameterEquations);

                /*
                 * Remove orphaned temporaries.
                 */
                flushAllRecursive();
                removeUnusedTemporaries();
            }

        }
    /**
     * After we have eliminated if equations with constant (and possibly parameter) test expressions,
     * then all if equations must be balanced, so we can rewrite to  a list of residual equations
     * with if expressions.
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:28
     */
    

        /**
         * After we have eliminated if equations with constant (and possibly parameter) test expressions,
         * then all if equations must be balanced, so we can rewrite to  a list of residual equations
         * with if expressions.
         */
        public class enableIfEquationRewrite extends Transformation {

            @Override
            public void perform() {
                rewriteIfEquations();
                removeEmptyElse();
                checkIfEquationCompliance();
            }

        }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:39
     */
    

        private void rewriteIfEquations() {
            List<FAbstractEquation> newEquations = new List<FAbstractEquation>();
            List<FAbstractEquation> newInitialEquations = new List<FAbstractEquation>();
            List<FAbstractEquation> newParameterEquations = new List<FAbstractEquation>();

            for (FAbstractEquation equation : getFAbstractEquations()) {
                equation.rewriteIfEquations(newEquations);
            }

            for (FAbstractEquation equation : getFInitialEquations()) {
                equation.rewriteIfEquations(newInitialEquations);
            }

            for (FAbstractEquation equation : getParameterEquations()) {
                equation.rewriteIfEquations(newParameterEquations);
            }

            setFAbstractEquationList(newEquations);
            setFInitialEquationList(newInitialEquations);
            setParameterEquationList(newParameterEquations);
        }
    /**
     * Remove all empty else-clauses that have been generated.
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:64
     */
    

        /**
         * Remove all empty else-clauses that have been generated.
         */
        private void removeEmptyElse() {
            List<FAbstractEquation> newEquations = new List<FAbstractEquation>();
            List<FAbstractEquation> newInitialEquations = new List<FAbstractEquation>();
            List<FAbstractEquation> newParameterEquations = new List<FAbstractEquation>();

            for (FAbstractEquation equation : getFAbstractEquations()) {
                equation.removeEmptyElse(newEquations);
            }

            for (FAbstractEquation equation : getFInitialEquations()) {
                equation.removeEmptyElse(newInitialEquations);
            }

            for (FAbstractEquation equation : getParameterEquations()) {
                equation.removeEmptyElse(newParameterEquations);
            }

            setFAbstractEquationList(newEquations);
            setFInitialEquationList(newInitialEquations);
            setParameterEquationList(newParameterEquations);
        }
    /**
     * Sort dependent parameter equations.
     * 
     * This is a simple implementation of Kahn's topological sorting algorithm.
     * This implementation will most likely be replaced by other graph 
     * algorithms later on.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:62
     */
    
        /**
         * Sort dependent parameter equations.
         * 
         * This is a simple implementation of Kahn's topological sorting algorithm.
         * This implementation will most likely be replaced by other graph 
         * algorithms later on.
         */
        public class sortDependentParameters extends Transformation {
            public void perform() {
                sortDependentParameters();
            }
        }
    /**
     * Sort dependent parameter equations.
     * 
     * This is a simple implementation of Kahn's topological sorting algorithm.
     * This implementation will most likely be replaced by other graph 
     * algorithms later on.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:76
     */
    public void sortDependentParameters() {
        // Check that all independent parameters can be evaluated.
        for (FVariable var : getFVariables()) {
            TypePrefixVariability variability = var.variability();
            if (variability.parameterVariability() && var.hasBindingExp()) {
                FExp bExp = var.getBindingExp();
                if (!bExp.isLiteralExp() && !var.isExternalObject()) {
                    FExp literal = null;
                    try {
                        CValue cval = bExp.ceval();
                        if (cval.hasBuildLiteral()) {
                            literal = cval.buildLiteral();
                        }
                    } catch (ConstantEvaluationException e) {}
                    if (literal != null) {
                        var.setBindingExp(literal);
                    } else {
                        FAbstractEquation fae = new FEquation(var.createAccessExp(), bExp);
                        addParameterEquationNoTransform(fae);
                        var.removeBindingExp();
                        parameterEquationsMap().put(var, fae);
                    }
                }
            }
        }
		// Get the list of parameter equations and set up preliminary data.
		ArrayList<FAbstractEquation> eqns = getParameterEquations().toArrayList();
		
		// Check if there is any dependent parameters that can be made independent.
		Iterator<FAbstractEquation> it = eqns.iterator();
		while (it.hasNext()) {
			FAbstractEquation eqn = it.next();
			if (eqn != null && eqn.isIndependentParameterEquation()) {
				try {
					eqn.revertToBindingExp();
					it.remove();
				} catch (ConstantEvaluationException e) {
					// Doh, we were unable to evaluate the expression
				}
			}
		}
		int n_eqns = eqns.size();
		List<FVariable> vars = getFVariables();
		int n_vars = getNumFVariable();
		for (int i = 0; i < n_eqns; i++)
			eqns.get(i).sortingIndex = i;
		for (FVariable fv : vars)
			fv.parameterEquation();  // Calculate these before changing anything
		
		
		// Set up data structures for the adjacency graph.
		ArrayList<HashSet<FAbstractEquation>> toNodes = new ArrayList<HashSet<FAbstractEquation>>(n_eqns);
		ArrayList<HashSet<FAbstractEquation>> fromNodes = new ArrayList<HashSet<FAbstractEquation>>(n_eqns);
		for (int i = 0; i < n_eqns; i++) {
			toNodes.add(new HashSet<FAbstractEquation>());
			fromNodes.add(new HashSet<FAbstractEquation>());
		}
		
		// For each equation
		for (FAbstractEquation eqn : eqns) {
			// Retrieve all variables referenced in right hand side
            Set<FVariable> deps = eqn.variableDependenciesRHS();
			// Build the actual adjacency graph.
			for (FVariable fv : deps) {
				FAbstractEquation depEqn = fv.parameterEquation();
				if (depEqn != null && depEqn.sortingIndex >= 0) {
					toNodes.get(depEqn.sortingIndex).add(eqn);		
					fromNodes.get(eqn.sortingIndex).add(depEqn);
				}
			}
		}	
				
		// Sort using algorithm described at
		// http://en.wikipedia.org/wiki/Topological_sorting
		List<FAbstractEquation> L = new List<FAbstractEquation>();
		Queue<FAbstractEquation> S = new ArrayDeque<FAbstractEquation>();
		
		// Add all nodes without incoming edges to S
		for (int i = 0; i < n_eqns; i++) 
			if (fromNodes.get(i).isEmpty()) 
				S.add(eqns.get(i));
		
		// Repeat while S is not empty
		int si = 0;
		int n_indep = 0;
		while (S.size() > 0) {
			// Remove a node n from S
			FAbstractEquation n = S.remove();
			L.add(n);
			// For each node m with an edge e from n to m (in original order)
			Set<FAbstractEquation> nodes = FAbstractEquation.sortingSet();
			nodes.addAll(toNodes.get(n.sortingIndex));
			for (FAbstractEquation m : nodes) {
				// Remove edge e from fromNodes
				fromNodes.get(m.sortingIndex).remove(n);
				// If m has no incoming edges add m to S
				if (fromNodes.get(m.sortingIndex).isEmpty()) 
					S.add(m);
			}
			// Remove e from toNodes
			toNodes.get(n.sortingIndex).clear();
			// Done with n - update sortingIndex
			n.sortingIndex = si++;
		}
		
		// Not possible to find an ordering without cycles?
		if (L.getNumChild() != eqns.size() - n_indep) {
			error("The model "+ name() +" contains cyclic parameter dependencies.");
		} else {
			// Replace old parameter equation list
			setParameterEquationList(L);
			
			// Rearrange parameters in same order as parameter equations
			ArrayList<FVariable> depParams = new ArrayList<FVariable>(n_eqns);
            for (FAbstractEquation fae : L) {
                depParams.addAll(fae.referencedFVariablesInLHS());
            }
			ArrayList<Integer> depParamIndices = new ArrayList<Integer>(n_eqns);
			for (int i = 0; i < n_vars; i++) {
				FVariable fv = vars.getChild(i);
				if (fv.hasParameterEquation()) {
                    depParamIndices.add(new Integer(i));
                }
            }
            
			for (int i = 0; i < depParams.size(); i++)
				vars.setChild(depParams.get(i), depParamIndices.get(i).intValue());
	
			// Flush AST since the structure has changed.
				root().flushAllRecursive();
			
			// Remove any binding expressions of variables with parameter equations
			for (FAbstractEquation eqn : L)
				eqn.removeBindingExpOfAssignedVars();
		}
	}
    /**
     * Transforms when clauses to if clauses.
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:23
     */
    
        /**
         * Transforms when clauses to if clauses.
         */
        public class convertWhenToIf extends Transformation {
            public void perform() {
                Collection<FAbstractEquation> newEqns = new ArrayList<FAbstractEquation>();
                for (FAbstractEquation eqn : getFAbstractEquations()) {
                    newEqns.add(eqn.convertWhenEqnToIfEqn(newEqns, FClass.this));
                }
                setFAbstractEquationList(new List<FAbstractEquation>(newEqns));
                flushAllRecursive();
            }
        }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:351
     */
    public String externalDependencies() {
        StringBuilder sb = new StringBuilder();
        for (FExternalStmt stmt : myExternals()) {
            Set<String> incs    = new LinkedHashSet();
            Set<String> incDirs = new LinkedHashSet();
            Set<String> libs    = new LinkedHashSet();
            Set<String> libDirs = new LinkedHashSet();
            stmt.externalDependencies(incs, incDirs, libs, libDirs);
            
            sb.append(stmt.getName());
            sb.append("\n");
            for (String s : incs) {
                sb.append(s);
                sb.append("\n");
            }
            for (String s : incDirs) {
                sb.append(new File(s).getName());
                sb.append("\n");
            }
            for (String s : libs) {
                sb.append(s);
                sb.append("\n");
            }
            for (String s : libDirs) {
                sb.append(new File(s).getName());
                sb.append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:43
     */
    public boolean mightBeSplit() {
        return myOptions().getIntegerOption("cc_split_element_limit") > 0;
    }
    /**
     * @aspect CCodeGenFunctionDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:47
     */
    public void generateFunctionHeaders(CodePrinter p, CodeStream str, String indent) {
        for (FFunctionDecl func : myFFunctionDeclsPartial()) {
            func.genStructsPartial(p, str, "");
        }
        for (FFunctionDecl func : myFFunctionDeclsPartialCalled()) {
            func.genHeadersPartial(p, str, "");
        }
        for (FFunctionDecl func : getFFunctionDecls()) {
            func.genHeader(p, str, "");
        }
        if (mightBeSplit()) {
            for(AbstractEquationBlock block: getDAEBLT()) {
                block.genBlockResidualSetUpFunctionCallHeader_C(p, str, indent);
            }
        }
    }
    /**
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:54
     */
    private CodeGenContext codeGenContext = new CodeGenContext();
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:118
     */
    public void generateDDFunctionHeaders(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:122
     */
    public void generateDDFunctions(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:126
     */
    public void generateDDBlocks(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:130
     */
    public void generateDDBlocksInit(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:134
     */
    public void generateDDAddBlocks(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:138
     */
    public void generateDDAddBlocksInit(CodeStream str) {
        
    }
    /**
     * @aspect ExtraCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExtraCodeGen.jrag:142
     */
    public void generateDDODEDerivatives(CodeStream str) {
        
    }
    /**
     * @declaredat ASTNode:1
     */
    public FClass() {
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
        children = new ASTNode[15];
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(List.EMPTY, 3);
        setChild(List.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
        setChild(List.EMPTY, 8);
        setChild(List.EMPTY, 9);
        setChild(List.EMPTY, 10);
        setChild(List.EMPTY, 11);
        setChild(List.EMPTY, 12);
    }
    /**
     * @declaredat ASTNode:25
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FAccess", "FVariable", "AliasVariable", "FGlobalVariable", "FInitialEquation", "ParameterEquation", "FAbstractEquation", "FFunctionDecl", "FRecordDecl", "FEnumDecl", "FDerivedType", "FResidualPair", "FAttribute", "DynamicStateManager"},
        type = {"FAccess", "List<FVariable>", "List<FVariable>", "List<FGlobalVariable>", "List<FAbstractEquation>", "List<FAbstractEquation>", "List<FAbstractEquation>", "List<FFunctionDecl>", "List<FRecordDecl>", "List<FEnumDecl>", "List<FDerivedType>", "List<FResidualPair>", "List<FAttribute>", "DynamicStateManager"},
        kind = {"Child", "List", "List", "List", "List", "List", "List", "List", "List", "List", "List", "List", "List", "Child"}
    )
    public FClass(FAccess p0, List<FVariable> p1, List<FVariable> p2, List<FGlobalVariable> p3, List<FAbstractEquation> p4, List<FAbstractEquation> p5, List<FAbstractEquation> p6, List<FFunctionDecl> p7, List<FRecordDecl> p8, List<FEnumDecl> p9, List<FDerivedType> p10, List<FResidualPair> p11, List<FAttribute> p12, DynamicStateManager p13) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
        setChild(p5, 5);
        setChild(p6, 6);
        setChild(p7, 7);
        setChild(p8, 8);
        setChild(p9, 9);
        setChild(p10, 10);
        setChild(p11, 11);
        setChild(p12, 12);
        setChild(p13, 13);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:47
     */
    protected int numChildren() {
        return 14;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:53
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:57
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        varRefMap_reset();
        differentiatedRealVariablesList_reset();
        allDifferentiatedRealVariables_reset();
        discretePreVariables_reset();
        allVariables_reset();
        realVariables_reset();
        integerVariables_reset();
        enumVariables_reset();
        booleanVariables_reset();
        stringVariables_reset();
        normalAlgebraicContinousRealVariables_reset();
        normalAlgebraicVariables_reset();
        realVariablesWithBindingExp_reset();
        integerVariablesWithBindingExp_reset();
        enumVariablesWithBindingExp_reset();
        booleanVariablesWithBindingExp_reset();
        stringVariablesWithBindingExp_reset();
        realInputs_reset();
        integerInputs_reset();
        enumInputs_reset();
        booleanInputs_reset();
        stringInputs_reset();
        realOutputs_reset();
        integerOutputs_reset();
        enumOutputs_reset();
        booleanOutputs_reset();
        stringOutputs_reset();
        numScalarEquationsAtInitialization_reset();
        equations_reset();
        continuousEquations_reset();
        continuousNonMetaEquations_reset();
        switchExps_reset();
        stateEventExps_reset();
        timeEventExps_reset();
        numInitialScalarEquations_reset();
        initialEquations_reset();
        derivedTypeMap_reset();
        variablesMap_reset();
        globalVariablesMap_reset();
        parameterEquationsMap_reset();
        getUnknownFVariable_reset();
        getFDynamicResolverOpt_reset();
        stateSelectType_reset();
        collectReinits_reset();
        resourceLoader_reset();
        runtimeOptionParameters_reset();
        myStepUtil_reset();
        continuousVariablesUsedInPreInInitial_reset();
        xmlVariables_reset();
        xmlVariableIndexMap_reset();
        exportWrapperGroups_reset();
        timeMX_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:113
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        FClass_differentiatedByFDerExp_computed = false;
        
        FClass_differentiatedByFDerExp_value = null;
        FClass_dynamicStates_computed = false;
        
        FClass_dynamicStates_value = null;
        FClass_dynamicStateVariables_computed = false;
        
        FClass_dynamicStateVariables_value = null;
        FClass_dynamicAlgebraicVariables_computed = false;
        
        FClass_dynamicAlgebraicVariables_value = null;
        FClass_differentiatedRealVariablesFilteredSet_computed = false;
        
        FClass_differentiatedRealVariablesFilteredSet_value = null;
        FClass_myFFunctionDeclsPartial_computed = false;
        
        FClass_myFFunctionDeclsPartial_value = null;
        FClass_myFFunctionDeclsPartialCalled_computed = false;
        
        FClass_myFFunctionDeclsPartialCalled_value = null;
        FClass_myDelayExps_computed = false;
        
        FClass_myDelayExps_value = null;
        FClass_mySpatialDistExps_computed = false;
        
        FClass_mySpatialDistExps_value = null;
        FClass_derivativeVariables_computed = false;
        
        FClass_derivativeVariables_value = null;
        FClass_variables_computed = false;
        
        FClass_variables_value = null;
        FClass_aliasVariables_computed = false;
        
        FClass_aliasVariables_value = null;
        FClass_tempVariables_computed = false;
        
        FClass_tempVariables_value = null;
        FClass_variablesWithBindingExp_computed = false;
        
        FClass_variablesWithBindingExp_value = null;
        FClass_inputs_computed = false;
        
        FClass_inputs_value = null;
        FClass_outputs_computed = false;
        
        FClass_outputs_value = null;
        FClass_algorithms_computed = false;
        
        FClass_algorithms_value = null;
        FClass_sampleExpsWithTimeEvent_computed = false;
        
        FClass_sampleExpsWithTimeEvent_value = null;
        FClass_spatialDistExpsWithStateEvent_computed = false;
        
        FClass_spatialDistExpsWithStateEvent_value = null;
        FClass_delayExpsWithStateEvent_computed = false;
        
        FClass_delayExpsWithStateEvent_value = null;
        FClass_guardExpInEquations_computed = false;
        
        FClass_guardExpInEquations_value = null;
        FClass_guardExpInInitialEquations_computed = false;
        
        FClass_guardExpInInitialEquations_value = null;
        FClass_relExpsWithEvent_computed = false;
        
        FClass_relExpsWithEvent_value = null;
        FClass_relExpInInitialEquations_computed = false;
        
        FClass_relExpInInitialEquations_value = null;
        FClass_myAlgorithms_computed = false;
        
        FClass_myAlgorithms_value = null;
        FClass_myExternals_computed = false;
        
        FClass_myExternals_value = null;
        FClass_collectInstAccesses_computed = false;
        
        FClass_collectInstAccesses_value = null;
        FClass_collectSemiLinearExps_computed = false;
        
        FClass_collectSemiLinearExps_value = null;
        FClass_eventGenExps_computed = false;
        
        FClass_eventGenExps_value = null;
        contributorMap_FClass_differentiatedByFDerExp = null;
        contributorMap_FClass_dynamicStates = null;
        contributorMap_FClass_dynamicStateVariables = null;
        contributorMap_FClass_dynamicAlgebraicVariables = null;
        contributorMap_FClass_differentiatedRealVariablesFilteredSet = null;
        contributorMap_FClass_myFFunctionDeclsPartial = null;
        contributorMap_FClass_myFFunctionDeclsPartialCalled = null;
        contributorMap_FClass_myDelayExps = null;
        contributorMap_FClass_mySpatialDistExps = null;
        contributorMap_FClass_derivativeVariables = null;
        contributorMap_FClass_variables = null;
        contributorMap_FClass_aliasVariables = null;
        contributorMap_FClass_tempVariables = null;
        contributorMap_FClass_variablesWithBindingExp = null;
        contributorMap_FClass_inputs = null;
        contributorMap_FClass_outputs = null;
        contributorMap_FClass_algorithms = null;
        contributorMap_FClass_sampleExpsWithTimeEvent = null;
        contributorMap_FClass_spatialDistExpsWithStateEvent = null;
        contributorMap_FClass_delayExpsWithStateEvent = null;
        contributorMap_FClass_relExpsWithEvent = null;
        contributorMap_FClass_relExpInInitialEquations = null;
        contributorMap_FClass_myAlgorithms = null;
        contributorMap_FClass_myExternals = null;
        contributorMap_FClass_collectInstAccesses = null;
        contributorMap_FClass_collectSemiLinearExps = null;
        contributorMap_FClass_eventGenExps = null;
        contributorMap_FAbstractVariable_uses = null;
        contributorMap_FAbstractEquation_eventGenExps = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:233
     */
    public FClass clone() throws CloneNotSupportedException {
        FClass node = (FClass) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:238
     */
    public FClass copy() {
        try {
            FClass node = (FClass) clone();
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
     * @declaredat ASTNode:257
     */
    @Deprecated
    public FClass fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:267
     */
    public FClass treeCopyNoTransform() {
        FClass tree = (FClass) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 14:
                    tree.children[i] = null;
                    continue;
                }
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
     * @declaredat ASTNode:292
     */
    public FClass treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:297
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FAccess child.
     * @param node The new node to replace the FAccess child.
     * @apilevel high-level
     */
    public void setFAccess(FAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FAccess child.
     * @return The current node used as the FAccess child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAccess")
    public FAccess getFAccess() {
        return (FAccess) getChild(0);
    }
    /**
     * Retrieves the FAccess child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAccess child.
     * @apilevel low-level
     */
    public FAccess getFAccessNoTransform() {
        return (FAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the FVariable list.
     * @param list The new list node to be used as the FVariable list.
     * @apilevel high-level
     */
    public void setFVariableList(List<FVariable> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the FVariable list.
     * @return Number of children in the FVariable list.
     * @apilevel high-level
     */
    public int getNumFVariable() {
        return getFVariableList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FVariable list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FVariable list.
     * @apilevel low-level
     */
    public int getNumFVariableNoTransform() {
        return getFVariableListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FVariable list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FVariable list.
     * @apilevel high-level
     */
    public FVariable getFVariable(int i) {
        return (FVariable) getFVariableList().getChild(i);
    }
    /**
     * Check whether the FVariable list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFVariable() {
        return getFVariableList().getNumChild() != 0;
    }
    /**
     * Append an element to the FVariable list.
     * @param node The element to append to the FVariable list.
     * @apilevel high-level
     */
    public void addFVariable(FVariable node) {
        List<FVariable> list = (parent == null) ? getFVariableListNoTransform() : getFVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFVariableNoTransform(FVariable node) {
        List<FVariable> list = getFVariableListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FVariable list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFVariable(FVariable node, int i) {
        List<FVariable> list = getFVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FVariable list.
     * @return The node representing the FVariable list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FVariable")
    public List<FVariable> getFVariableList() {
        List<FVariable> list = (List<FVariable>) getChild(1);
        return list;
    }
    /**
     * Retrieves the FVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FVariable list.
     * @apilevel low-level
     */
    public List<FVariable> getFVariableListNoTransform() {
        return (List<FVariable>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the FVariable list without
     * triggering rewrites.
     */
    public FVariable getFVariableNoTransform(int i) {
        return (FVariable) getFVariableListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FVariable list.
     * @return The node representing the FVariable list.
     * @apilevel high-level
     */
    public List<FVariable> getFVariables() {
        return getFVariableList();
    }
    /**
     * Retrieves the FVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FVariable list.
     * @apilevel low-level
     */
    public List<FVariable> getFVariablesNoTransform() {
        return getFVariableListNoTransform();
    }
    /**
     * Replaces the AliasVariable list.
     * @param list The new list node to be used as the AliasVariable list.
     * @apilevel high-level
     */
    public void setAliasVariableList(List<FVariable> list) {
        setChild(list, 2);
    }
    /**
     * Retrieves the number of children in the AliasVariable list.
     * @return Number of children in the AliasVariable list.
     * @apilevel high-level
     */
    public int getNumAliasVariable() {
        return getAliasVariableList().getNumChild();
    }
    /**
     * Retrieves the number of children in the AliasVariable list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the AliasVariable list.
     * @apilevel low-level
     */
    public int getNumAliasVariableNoTransform() {
        return getAliasVariableListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the AliasVariable list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the AliasVariable list.
     * @apilevel high-level
     */
    public FVariable getAliasVariable(int i) {
        return (FVariable) getAliasVariableList().getChild(i);
    }
    /**
     * Check whether the AliasVariable list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasAliasVariable() {
        return getAliasVariableList().getNumChild() != 0;
    }
    /**
     * Append an element to the AliasVariable list.
     * @param node The element to append to the AliasVariable list.
     * @apilevel high-level
     */
    public void addAliasVariable(FVariable node) {
        List<FVariable> list = (parent == null) ? getAliasVariableListNoTransform() : getAliasVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addAliasVariableNoTransform(FVariable node) {
        List<FVariable> list = getAliasVariableListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the AliasVariable list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setAliasVariable(FVariable node, int i) {
        List<FVariable> list = getAliasVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the AliasVariable list.
     * @return The node representing the AliasVariable list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="AliasVariable")
    public List<FVariable> getAliasVariableList() {
        List<FVariable> list = (List<FVariable>) getChild(2);
        return list;
    }
    /**
     * Retrieves the AliasVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AliasVariable list.
     * @apilevel low-level
     */
    public List<FVariable> getAliasVariableListNoTransform() {
        return (List<FVariable>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the AliasVariable list without
     * triggering rewrites.
     */
    public FVariable getAliasVariableNoTransform(int i) {
        return (FVariable) getAliasVariableListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the AliasVariable list.
     * @return The node representing the AliasVariable list.
     * @apilevel high-level
     */
    public List<FVariable> getAliasVariables() {
        return getAliasVariableList();
    }
    /**
     * Retrieves the AliasVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AliasVariable list.
     * @apilevel low-level
     */
    public List<FVariable> getAliasVariablesNoTransform() {
        return getAliasVariableListNoTransform();
    }
    /**
     * Replaces the FGlobalVariable list.
     * @param list The new list node to be used as the FGlobalVariable list.
     * @apilevel high-level
     */
    public void setFGlobalVariableList(List<FGlobalVariable> list) {
        setChild(list, 3);
    }
    /**
     * Retrieves the number of children in the FGlobalVariable list.
     * @return Number of children in the FGlobalVariable list.
     * @apilevel high-level
     */
    public int getNumFGlobalVariable() {
        return getFGlobalVariableList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FGlobalVariable list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FGlobalVariable list.
     * @apilevel low-level
     */
    public int getNumFGlobalVariableNoTransform() {
        return getFGlobalVariableListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FGlobalVariable list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FGlobalVariable list.
     * @apilevel high-level
     */
    public FGlobalVariable getFGlobalVariable(int i) {
        return (FGlobalVariable) getFGlobalVariableList().getChild(i);
    }
    /**
     * Check whether the FGlobalVariable list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFGlobalVariable() {
        return getFGlobalVariableList().getNumChild() != 0;
    }
    /**
     * Append an element to the FGlobalVariable list.
     * @param node The element to append to the FGlobalVariable list.
     * @apilevel high-level
     */
    public void addFGlobalVariable(FGlobalVariable node) {
        List<FGlobalVariable> list = (parent == null) ? getFGlobalVariableListNoTransform() : getFGlobalVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFGlobalVariableNoTransform(FGlobalVariable node) {
        List<FGlobalVariable> list = getFGlobalVariableListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FGlobalVariable list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFGlobalVariable(FGlobalVariable node, int i) {
        List<FGlobalVariable> list = getFGlobalVariableList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FGlobalVariable list.
     * @return The node representing the FGlobalVariable list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FGlobalVariable")
    public List<FGlobalVariable> getFGlobalVariableList() {
        List<FGlobalVariable> list = (List<FGlobalVariable>) getChild(3);
        return list;
    }
    /**
     * Retrieves the FGlobalVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FGlobalVariable list.
     * @apilevel low-level
     */
    public List<FGlobalVariable> getFGlobalVariableListNoTransform() {
        return (List<FGlobalVariable>) getChildNoTransform(3);
    }
    /**
     * @return the element at index {@code i} in the FGlobalVariable list without
     * triggering rewrites.
     */
    public FGlobalVariable getFGlobalVariableNoTransform(int i) {
        return (FGlobalVariable) getFGlobalVariableListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FGlobalVariable list.
     * @return The node representing the FGlobalVariable list.
     * @apilevel high-level
     */
    public List<FGlobalVariable> getFGlobalVariables() {
        return getFGlobalVariableList();
    }
    /**
     * Retrieves the FGlobalVariable list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FGlobalVariable list.
     * @apilevel low-level
     */
    public List<FGlobalVariable> getFGlobalVariablesNoTransform() {
        return getFGlobalVariableListNoTransform();
    }
    /**
     * Replaces the FInitialEquation list.
     * @param list The new list node to be used as the FInitialEquation list.
     * @apilevel high-level
     */
    public void setFInitialEquationList(List<FAbstractEquation> list) {
        setChild(list, 4);
    }
    /**
     * Retrieves the number of children in the FInitialEquation list.
     * @return Number of children in the FInitialEquation list.
     * @apilevel high-level
     */
    public int getNumFInitialEquation() {
        return getFInitialEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FInitialEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FInitialEquation list.
     * @apilevel low-level
     */
    public int getNumFInitialEquationNoTransform() {
        return getFInitialEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FInitialEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FInitialEquation list.
     * @apilevel high-level
     */
    public FAbstractEquation getFInitialEquation(int i) {
        return (FAbstractEquation) getFInitialEquationList().getChild(i);
    }
    /**
     * Check whether the FInitialEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFInitialEquation() {
        return getFInitialEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the FInitialEquation list.
     * @param node The element to append to the FInitialEquation list.
     * @apilevel high-level
     */
    public void addFInitialEquation(FAbstractEquation node) {
        List<FAbstractEquation> list = (parent == null) ? getFInitialEquationListNoTransform() : getFInitialEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFInitialEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFInitialEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FInitialEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFInitialEquation(FAbstractEquation node, int i) {
        List<FAbstractEquation> list = getFInitialEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FInitialEquation list.
     * @return The node representing the FInitialEquation list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FInitialEquation")
    public List<FAbstractEquation> getFInitialEquationList() {
        List<FAbstractEquation> list = (List<FAbstractEquation>) getChild(4);
        return list;
    }
    /**
     * Retrieves the FInitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FInitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFInitialEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(4);
    }
    /**
     * @return the element at index {@code i} in the FInitialEquation list without
     * triggering rewrites.
     */
    public FAbstractEquation getFInitialEquationNoTransform(int i) {
        return (FAbstractEquation) getFInitialEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FInitialEquation list.
     * @return The node representing the FInitialEquation list.
     * @apilevel high-level
     */
    public List<FAbstractEquation> getFInitialEquations() {
        return getFInitialEquationList();
    }
    /**
     * Retrieves the FInitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FInitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFInitialEquationsNoTransform() {
        return getFInitialEquationListNoTransform();
    }
    /**
     * Replaces the ParameterEquation list.
     * @param list The new list node to be used as the ParameterEquation list.
     * @apilevel high-level
     */
    public void setParameterEquationList(List<FAbstractEquation> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the ParameterEquation list.
     * @return Number of children in the ParameterEquation list.
     * @apilevel high-level
     */
    public int getNumParameterEquation() {
        return getParameterEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ParameterEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ParameterEquation list.
     * @apilevel low-level
     */
    public int getNumParameterEquationNoTransform() {
        return getParameterEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ParameterEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ParameterEquation list.
     * @apilevel high-level
     */
    public FAbstractEquation getParameterEquation(int i) {
        return (FAbstractEquation) getParameterEquationList().getChild(i);
    }
    /**
     * Check whether the ParameterEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasParameterEquation() {
        return getParameterEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the ParameterEquation list.
     * @param node The element to append to the ParameterEquation list.
     * @apilevel high-level
     */
    public void addParameterEquation(FAbstractEquation node) {
        List<FAbstractEquation> list = (parent == null) ? getParameterEquationListNoTransform() : getParameterEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addParameterEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getParameterEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ParameterEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setParameterEquation(FAbstractEquation node, int i) {
        List<FAbstractEquation> list = getParameterEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the ParameterEquation list.
     * @return The node representing the ParameterEquation list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="ParameterEquation")
    public List<FAbstractEquation> getParameterEquationList() {
        List<FAbstractEquation> list = (List<FAbstractEquation>) getChild(5);
        return list;
    }
    /**
     * Retrieves the ParameterEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ParameterEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getParameterEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the ParameterEquation list without
     * triggering rewrites.
     */
    public FAbstractEquation getParameterEquationNoTransform(int i) {
        return (FAbstractEquation) getParameterEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ParameterEquation list.
     * @return The node representing the ParameterEquation list.
     * @apilevel high-level
     */
    public List<FAbstractEquation> getParameterEquations() {
        return getParameterEquationList();
    }
    /**
     * Retrieves the ParameterEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ParameterEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getParameterEquationsNoTransform() {
        return getParameterEquationListNoTransform();
    }
    /**
     * Replaces the FAbstractEquation list.
     * @param list The new list node to be used as the FAbstractEquation list.
     * @apilevel high-level
     */
    public void setFAbstractEquationList(List<FAbstractEquation> list) {
        setChild(list, 6);
    }
    /**
     * Retrieves the number of children in the FAbstractEquation list.
     * @return Number of children in the FAbstractEquation list.
     * @apilevel high-level
     */
    public int getNumFAbstractEquation() {
        return getFAbstractEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAbstractEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAbstractEquation list.
     * @apilevel low-level
     */
    public int getNumFAbstractEquationNoTransform() {
        return getFAbstractEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAbstractEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAbstractEquation list.
     * @apilevel high-level
     */
    public FAbstractEquation getFAbstractEquation(int i) {
        return (FAbstractEquation) getFAbstractEquationList().getChild(i);
    }
    /**
     * Check whether the FAbstractEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAbstractEquation() {
        return getFAbstractEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAbstractEquation list.
     * @param node The element to append to the FAbstractEquation list.
     * @apilevel high-level
     */
    public void addFAbstractEquation(FAbstractEquation node) {
        List<FAbstractEquation> list = (parent == null) ? getFAbstractEquationListNoTransform() : getFAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAbstractEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAbstractEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAbstractEquation(FAbstractEquation node, int i) {
        List<FAbstractEquation> list = getFAbstractEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAbstractEquation list.
     * @return The node representing the FAbstractEquation list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAbstractEquation")
    public List<FAbstractEquation> getFAbstractEquationList() {
        List<FAbstractEquation> list = (List<FAbstractEquation>) getChild(6);
        return list;
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(6);
    }
    /**
     * @return the element at index {@code i} in the FAbstractEquation list without
     * triggering rewrites.
     */
    public FAbstractEquation getFAbstractEquationNoTransform(int i) {
        return (FAbstractEquation) getFAbstractEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAbstractEquation list.
     * @return The node representing the FAbstractEquation list.
     * @apilevel high-level
     */
    public List<FAbstractEquation> getFAbstractEquations() {
        return getFAbstractEquationList();
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationsNoTransform() {
        return getFAbstractEquationListNoTransform();
    }
    /**
     * Replaces the FFunctionDecl list.
     * @param list The new list node to be used as the FFunctionDecl list.
     * @apilevel high-level
     */
    public void setFFunctionDeclList(List<FFunctionDecl> list) {
        setChild(list, 7);
    }
    /**
     * Retrieves the number of children in the FFunctionDecl list.
     * @return Number of children in the FFunctionDecl list.
     * @apilevel high-level
     */
    public int getNumFFunctionDecl() {
        return getFFunctionDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FFunctionDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FFunctionDecl list.
     * @apilevel low-level
     */
    public int getNumFFunctionDeclNoTransform() {
        return getFFunctionDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FFunctionDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FFunctionDecl list.
     * @apilevel high-level
     */
    public FFunctionDecl getFFunctionDecl(int i) {
        return (FFunctionDecl) getFFunctionDeclList().getChild(i);
    }
    /**
     * Check whether the FFunctionDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFFunctionDecl() {
        return getFFunctionDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the FFunctionDecl list.
     * @param node The element to append to the FFunctionDecl list.
     * @apilevel high-level
     */
    public void addFFunctionDecl(FFunctionDecl node) {
        List<FFunctionDecl> list = (parent == null) ? getFFunctionDeclListNoTransform() : getFFunctionDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFFunctionDeclNoTransform(FFunctionDecl node) {
        List<FFunctionDecl> list = getFFunctionDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FFunctionDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFFunctionDecl(FFunctionDecl node, int i) {
        List<FFunctionDecl> list = getFFunctionDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FFunctionDecl list.
     * @return The node representing the FFunctionDecl list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FFunctionDecl")
    public List<FFunctionDecl> getFFunctionDeclList() {
        List<FFunctionDecl> list = (List<FFunctionDecl>) getChild(7);
        return list;
    }
    /**
     * Retrieves the FFunctionDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FFunctionDecl list.
     * @apilevel low-level
     */
    public List<FFunctionDecl> getFFunctionDeclListNoTransform() {
        return (List<FFunctionDecl>) getChildNoTransform(7);
    }
    /**
     * @return the element at index {@code i} in the FFunctionDecl list without
     * triggering rewrites.
     */
    public FFunctionDecl getFFunctionDeclNoTransform(int i) {
        return (FFunctionDecl) getFFunctionDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FFunctionDecl list.
     * @return The node representing the FFunctionDecl list.
     * @apilevel high-level
     */
    public List<FFunctionDecl> getFFunctionDecls() {
        return getFFunctionDeclList();
    }
    /**
     * Retrieves the FFunctionDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FFunctionDecl list.
     * @apilevel low-level
     */
    public List<FFunctionDecl> getFFunctionDeclsNoTransform() {
        return getFFunctionDeclListNoTransform();
    }
    /**
     * Replaces the FRecordDecl list.
     * @param list The new list node to be used as the FRecordDecl list.
     * @apilevel high-level
     */
    public void setFRecordDeclList(List<FRecordDecl> list) {
        setChild(list, 8);
    }
    /**
     * Retrieves the number of children in the FRecordDecl list.
     * @return Number of children in the FRecordDecl list.
     * @apilevel high-level
     */
    public int getNumFRecordDecl() {
        return getFRecordDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FRecordDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FRecordDecl list.
     * @apilevel low-level
     */
    public int getNumFRecordDeclNoTransform() {
        return getFRecordDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FRecordDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FRecordDecl list.
     * @apilevel high-level
     */
    public FRecordDecl getFRecordDecl(int i) {
        return (FRecordDecl) getFRecordDeclList().getChild(i);
    }
    /**
     * Check whether the FRecordDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFRecordDecl() {
        return getFRecordDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the FRecordDecl list.
     * @param node The element to append to the FRecordDecl list.
     * @apilevel high-level
     */
    public void addFRecordDecl(FRecordDecl node) {
        List<FRecordDecl> list = (parent == null) ? getFRecordDeclListNoTransform() : getFRecordDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFRecordDeclNoTransform(FRecordDecl node) {
        List<FRecordDecl> list = getFRecordDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FRecordDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFRecordDecl(FRecordDecl node, int i) {
        List<FRecordDecl> list = getFRecordDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FRecordDecl list.
     * @return The node representing the FRecordDecl list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FRecordDecl")
    public List<FRecordDecl> getFRecordDeclList() {
        List<FRecordDecl> list = (List<FRecordDecl>) getChild(8);
        return list;
    }
    /**
     * Retrieves the FRecordDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FRecordDecl list.
     * @apilevel low-level
     */
    public List<FRecordDecl> getFRecordDeclListNoTransform() {
        return (List<FRecordDecl>) getChildNoTransform(8);
    }
    /**
     * @return the element at index {@code i} in the FRecordDecl list without
     * triggering rewrites.
     */
    public FRecordDecl getFRecordDeclNoTransform(int i) {
        return (FRecordDecl) getFRecordDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FRecordDecl list.
     * @return The node representing the FRecordDecl list.
     * @apilevel high-level
     */
    public List<FRecordDecl> getFRecordDecls() {
        return getFRecordDeclList();
    }
    /**
     * Retrieves the FRecordDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FRecordDecl list.
     * @apilevel low-level
     */
    public List<FRecordDecl> getFRecordDeclsNoTransform() {
        return getFRecordDeclListNoTransform();
    }
    /**
     * Replaces the FEnumDecl list.
     * @param list The new list node to be used as the FEnumDecl list.
     * @apilevel high-level
     */
    public void setFEnumDeclList(List<FEnumDecl> list) {
        setChild(list, 9);
    }
    /**
     * Retrieves the number of children in the FEnumDecl list.
     * @return Number of children in the FEnumDecl list.
     * @apilevel high-level
     */
    public int getNumFEnumDecl() {
        return getFEnumDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FEnumDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FEnumDecl list.
     * @apilevel low-level
     */
    public int getNumFEnumDeclNoTransform() {
        return getFEnumDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FEnumDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FEnumDecl list.
     * @apilevel high-level
     */
    public FEnumDecl getFEnumDecl(int i) {
        return (FEnumDecl) getFEnumDeclList().getChild(i);
    }
    /**
     * Check whether the FEnumDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFEnumDecl() {
        return getFEnumDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the FEnumDecl list.
     * @param node The element to append to the FEnumDecl list.
     * @apilevel high-level
     */
    public void addFEnumDecl(FEnumDecl node) {
        List<FEnumDecl> list = (parent == null) ? getFEnumDeclListNoTransform() : getFEnumDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFEnumDeclNoTransform(FEnumDecl node) {
        List<FEnumDecl> list = getFEnumDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FEnumDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFEnumDecl(FEnumDecl node, int i) {
        List<FEnumDecl> list = getFEnumDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FEnumDecl list.
     * @return The node representing the FEnumDecl list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FEnumDecl")
    public List<FEnumDecl> getFEnumDeclList() {
        List<FEnumDecl> list = (List<FEnumDecl>) getChild(9);
        return list;
    }
    /**
     * Retrieves the FEnumDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FEnumDecl list.
     * @apilevel low-level
     */
    public List<FEnumDecl> getFEnumDeclListNoTransform() {
        return (List<FEnumDecl>) getChildNoTransform(9);
    }
    /**
     * @return the element at index {@code i} in the FEnumDecl list without
     * triggering rewrites.
     */
    public FEnumDecl getFEnumDeclNoTransform(int i) {
        return (FEnumDecl) getFEnumDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FEnumDecl list.
     * @return The node representing the FEnumDecl list.
     * @apilevel high-level
     */
    public List<FEnumDecl> getFEnumDecls() {
        return getFEnumDeclList();
    }
    /**
     * Retrieves the FEnumDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FEnumDecl list.
     * @apilevel low-level
     */
    public List<FEnumDecl> getFEnumDeclsNoTransform() {
        return getFEnumDeclListNoTransform();
    }
    /**
     * Replaces the FDerivedType list.
     * @param list The new list node to be used as the FDerivedType list.
     * @apilevel high-level
     */
    public void setFDerivedTypeList(List<FDerivedType> list) {
        setChild(list, 10);
    }
    /**
     * Retrieves the number of children in the FDerivedType list.
     * @return Number of children in the FDerivedType list.
     * @apilevel high-level
     */
    public int getNumFDerivedType() {
        return getFDerivedTypeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FDerivedType list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FDerivedType list.
     * @apilevel low-level
     */
    public int getNumFDerivedTypeNoTransform() {
        return getFDerivedTypeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FDerivedType list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FDerivedType list.
     * @apilevel high-level
     */
    public FDerivedType getFDerivedType(int i) {
        return (FDerivedType) getFDerivedTypeList().getChild(i);
    }
    /**
     * Check whether the FDerivedType list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFDerivedType() {
        return getFDerivedTypeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FDerivedType list.
     * @param node The element to append to the FDerivedType list.
     * @apilevel high-level
     */
    public void addFDerivedType(FDerivedType node) {
        List<FDerivedType> list = (parent == null) ? getFDerivedTypeListNoTransform() : getFDerivedTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFDerivedTypeNoTransform(FDerivedType node) {
        List<FDerivedType> list = getFDerivedTypeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FDerivedType list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFDerivedType(FDerivedType node, int i) {
        List<FDerivedType> list = getFDerivedTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FDerivedType list.
     * @return The node representing the FDerivedType list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FDerivedType")
    public List<FDerivedType> getFDerivedTypeList() {
        List<FDerivedType> list = (List<FDerivedType>) getChild(10);
        return list;
    }
    /**
     * Retrieves the FDerivedType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FDerivedType list.
     * @apilevel low-level
     */
    public List<FDerivedType> getFDerivedTypeListNoTransform() {
        return (List<FDerivedType>) getChildNoTransform(10);
    }
    /**
     * @return the element at index {@code i} in the FDerivedType list without
     * triggering rewrites.
     */
    public FDerivedType getFDerivedTypeNoTransform(int i) {
        return (FDerivedType) getFDerivedTypeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FDerivedType list.
     * @return The node representing the FDerivedType list.
     * @apilevel high-level
     */
    public List<FDerivedType> getFDerivedTypes() {
        return getFDerivedTypeList();
    }
    /**
     * Retrieves the FDerivedType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FDerivedType list.
     * @apilevel low-level
     */
    public List<FDerivedType> getFDerivedTypesNoTransform() {
        return getFDerivedTypeListNoTransform();
    }
    /**
     * Replaces the FResidualPair list.
     * @param list The new list node to be used as the FResidualPair list.
     * @apilevel high-level
     */
    public void setFResidualPairList(List<FResidualPair> list) {
        setChild(list, 11);
    }
    /**
     * Retrieves the number of children in the FResidualPair list.
     * @return Number of children in the FResidualPair list.
     * @apilevel high-level
     */
    public int getNumFResidualPair() {
        return getFResidualPairList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FResidualPair list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FResidualPair list.
     * @apilevel low-level
     */
    public int getNumFResidualPairNoTransform() {
        return getFResidualPairListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FResidualPair list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FResidualPair list.
     * @apilevel high-level
     */
    public FResidualPair getFResidualPair(int i) {
        return (FResidualPair) getFResidualPairList().getChild(i);
    }
    /**
     * Check whether the FResidualPair list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFResidualPair() {
        return getFResidualPairList().getNumChild() != 0;
    }
    /**
     * Append an element to the FResidualPair list.
     * @param node The element to append to the FResidualPair list.
     * @apilevel high-level
     */
    public void addFResidualPair(FResidualPair node) {
        List<FResidualPair> list = (parent == null) ? getFResidualPairListNoTransform() : getFResidualPairList();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFResidualPairNoTransform(FResidualPair node) {
        List<FResidualPair> list = getFResidualPairListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FResidualPair list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFResidualPair(FResidualPair node, int i) {
        List<FResidualPair> list = getFResidualPairList();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FResidualPair list.
     * @return The node representing the FResidualPair list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FResidualPair")
    public List<FResidualPair> getFResidualPairList() {
        List<FResidualPair> list = (List<FResidualPair>) getChild(11);
        return list;
    }
    /**
     * Retrieves the FResidualPair list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FResidualPair list.
     * @apilevel low-level
     */
    public List<FResidualPair> getFResidualPairListNoTransform() {
        return (List<FResidualPair>) getChildNoTransform(11);
    }
    /**
     * @return the element at index {@code i} in the FResidualPair list without
     * triggering rewrites.
     */
    public FResidualPair getFResidualPairNoTransform(int i) {
        return (FResidualPair) getFResidualPairListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FResidualPair list.
     * @return The node representing the FResidualPair list.
     * @apilevel high-level
     */
    public List<FResidualPair> getFResidualPairs() {
        return getFResidualPairList();
    }
    /**
     * Retrieves the FResidualPair list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FResidualPair list.
     * @apilevel low-level
     */
    public List<FResidualPair> getFResidualPairsNoTransform() {
        return getFResidualPairListNoTransform();
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 12);
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * @return Number of children in the FAttribute list.
     * @apilevel high-level
     */
    public int getNumFAttribute() {
        return getFAttributeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAttribute list.
     * @apilevel low-level
     */
    public int getNumFAttributeNoTransform() {
        return getFAttributeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAttribute list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAttribute list.
     * @apilevel high-level
     */
    public FAttribute getFAttribute(int i) {
        return (FAttribute) getFAttributeList().getChild(i);
    }
    /**
     * Check whether the FAttribute list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAttribute() {
        return getFAttributeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAttribute list.
     * @param node The element to append to the FAttribute list.
     * @apilevel high-level
     */
    public void addFAttribute(FAttribute node) {
        List<FAttribute> list = (parent == null) ? getFAttributeListNoTransform() : getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAttribute list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAttribute(FAttribute node, int i) {
        List<FAttribute> list = getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAttribute")
    public List<FAttribute> getFAttributeList() {
        List<FAttribute> list = (List<FAttribute>) getChild(12);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(12);
    }
    /**
     * @return the element at index {@code i} in the FAttribute list without
     * triggering rewrites.
     */
    public FAttribute getFAttributeNoTransform(int i) {
        return (FAttribute) getFAttributeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    public List<FAttribute> getFAttributes() {
        return getFAttributeList();
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributesNoTransform() {
        return getFAttributeListNoTransform();
    }
    /**
     * Replaces the DynamicStateManager child.
     * @param node The new node to replace the DynamicStateManager child.
     * @apilevel high-level
     */
    public void setDynamicStateManager(DynamicStateManager node) {
        setChild(node, 13);
    }
    /**
     * Retrieves the DynamicStateManager child.
     * @return The current node used as the DynamicStateManager child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="DynamicStateManager")
    public DynamicStateManager getDynamicStateManager() {
        return (DynamicStateManager) getChild(13);
    }
    /**
     * Retrieves the DynamicStateManager child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the DynamicStateManager child.
     * @apilevel low-level
     */
    public DynamicStateManager getDynamicStateManagerNoTransform() {
        return (DynamicStateManager) getChildNoTransform(13);
    }
    /**
     * Retrieves the UnknownFVariable child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the UnknownFVariable child.
     * @apilevel low-level
     */
    public UnknownFVariable getUnknownFVariableNoTransform() {
        return (UnknownFVariable) getChildNoTransform(14);
    }
    /**
     * Retrieves the child position of the optional child UnknownFVariable.
     * @return The the child position of the optional child UnknownFVariable.
     * @apilevel low-level
     */
    protected int getUnknownFVariableChildPosition() {
        return 14;
    }
    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1069
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_differentiatedByFDerExp = null;

    /** @apilevel internal */
    protected void survey_FClass_differentiatedByFDerExp() {
        if (contributorMap_FClass_differentiatedByFDerExp == null) {
            contributorMap_FClass_differentiatedByFDerExp = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_differentiatedByFDerExp(this, contributorMap_FClass_differentiatedByFDerExp);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1494
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_dynamicStates = null;

    /** @apilevel internal */
    protected void survey_FClass_dynamicStates() {
        if (contributorMap_FClass_dynamicStates == null) {
            contributorMap_FClass_dynamicStates = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_dynamicStates(this, contributorMap_FClass_dynamicStates);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1505
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_dynamicStateVariables = null;

    /** @apilevel internal */
    protected void survey_FClass_dynamicStateVariables() {
        if (contributorMap_FClass_dynamicStateVariables == null) {
            contributorMap_FClass_dynamicStateVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_dynamicStateVariables(this, contributorMap_FClass_dynamicStateVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1515
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_dynamicAlgebraicVariables = null;

    /** @apilevel internal */
    protected void survey_FClass_dynamicAlgebraicVariables() {
        if (contributorMap_FClass_dynamicAlgebraicVariables == null) {
            contributorMap_FClass_dynamicAlgebraicVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_dynamicAlgebraicVariables(this, contributorMap_FClass_dynamicAlgebraicVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1525
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_differentiatedRealVariablesFilteredSet = null;

    /** @apilevel internal */
    protected void survey_FClass_differentiatedRealVariablesFilteredSet() {
        if (contributorMap_FClass_differentiatedRealVariablesFilteredSet == null) {
            contributorMap_FClass_differentiatedRealVariablesFilteredSet = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_differentiatedRealVariablesFilteredSet(this, contributorMap_FClass_differentiatedRealVariablesFilteredSet);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1539
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_myFFunctionDeclsPartial = null;

    /** @apilevel internal */
    protected void survey_FClass_myFFunctionDeclsPartial() {
        if (contributorMap_FClass_myFFunctionDeclsPartial == null) {
            contributorMap_FClass_myFFunctionDeclsPartial = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_myFFunctionDeclsPartial(this, contributorMap_FClass_myFFunctionDeclsPartial);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1548
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_myFFunctionDeclsPartialCalled = null;

    /** @apilevel internal */
    protected void survey_FClass_myFFunctionDeclsPartialCalled() {
        if (contributorMap_FClass_myFFunctionDeclsPartialCalled == null) {
            contributorMap_FClass_myFFunctionDeclsPartialCalled = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_myFFunctionDeclsPartialCalled(this, contributorMap_FClass_myFFunctionDeclsPartialCalled);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1552
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_myDelayExps = null;

    /** @apilevel internal */
    protected void survey_FClass_myDelayExps() {
        if (contributorMap_FClass_myDelayExps == null) {
            contributorMap_FClass_myDelayExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_myDelayExps(this, contributorMap_FClass_myDelayExps);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1558
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_mySpatialDistExps = null;

    /** @apilevel internal */
    protected void survey_FClass_mySpatialDistExps() {
        if (contributorMap_FClass_mySpatialDistExps == null) {
            contributorMap_FClass_mySpatialDistExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_mySpatialDistExps(this, contributorMap_FClass_mySpatialDistExps);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1577
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_derivativeVariables = null;

    /** @apilevel internal */
    protected void survey_FClass_derivativeVariables() {
        if (contributorMap_FClass_derivativeVariables == null) {
            contributorMap_FClass_derivativeVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_derivativeVariables(this, contributorMap_FClass_derivativeVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1584
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_variables = null;

    /** @apilevel internal */
    protected void survey_FClass_variables() {
        if (contributorMap_FClass_variables == null) {
            contributorMap_FClass_variables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_variables(this, contributorMap_FClass_variables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1643
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_aliasVariables = null;

    /** @apilevel internal */
    protected void survey_FClass_aliasVariables() {
        if (contributorMap_FClass_aliasVariables == null) {
            contributorMap_FClass_aliasVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_aliasVariables(this, contributorMap_FClass_aliasVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1662
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_tempVariables = null;

    /** @apilevel internal */
    protected void survey_FClass_tempVariables() {
        if (contributorMap_FClass_tempVariables == null) {
            contributorMap_FClass_tempVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_tempVariables(this, contributorMap_FClass_tempVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1719
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_variablesWithBindingExp = null;

    /** @apilevel internal */
    protected void survey_FClass_variablesWithBindingExp() {
        if (contributorMap_FClass_variablesWithBindingExp == null) {
            contributorMap_FClass_variablesWithBindingExp = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_variablesWithBindingExp(this, contributorMap_FClass_variablesWithBindingExp);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1746
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_inputs = null;

    /** @apilevel internal */
    protected void survey_FClass_inputs() {
        if (contributorMap_FClass_inputs == null) {
            contributorMap_FClass_inputs = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_inputs(this, contributorMap_FClass_inputs);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1776
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_outputs = null;

    /** @apilevel internal */
    protected void survey_FClass_outputs() {
        if (contributorMap_FClass_outputs == null) {
            contributorMap_FClass_outputs = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_outputs(this, contributorMap_FClass_outputs);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1838
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_algorithms = null;

    /** @apilevel internal */
    protected void survey_FClass_algorithms() {
        if (contributorMap_FClass_algorithms == null) {
            contributorMap_FClass_algorithms = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_algorithms(this, contributorMap_FClass_algorithms);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2010
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_sampleExpsWithTimeEvent = null;

    /** @apilevel internal */
    protected void survey_FClass_sampleExpsWithTimeEvent() {
        if (contributorMap_FClass_sampleExpsWithTimeEvent == null) {
            contributorMap_FClass_sampleExpsWithTimeEvent = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_sampleExpsWithTimeEvent(this, contributorMap_FClass_sampleExpsWithTimeEvent);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2016
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_spatialDistExpsWithStateEvent = null;

    /** @apilevel internal */
    protected void survey_FClass_spatialDistExpsWithStateEvent() {
        if (contributorMap_FClass_spatialDistExpsWithStateEvent == null) {
            contributorMap_FClass_spatialDistExpsWithStateEvent = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_spatialDistExpsWithStateEvent(this, contributorMap_FClass_spatialDistExpsWithStateEvent);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2022
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_delayExpsWithStateEvent = null;

    /** @apilevel internal */
    protected void survey_FClass_delayExpsWithStateEvent() {
        if (contributorMap_FClass_delayExpsWithStateEvent == null) {
            contributorMap_FClass_delayExpsWithStateEvent = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_delayExpsWithStateEvent(this, contributorMap_FClass_delayExpsWithStateEvent);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2130
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_relExpsWithEvent = null;

    /** @apilevel internal */
    protected void survey_FClass_relExpsWithEvent() {
        if (contributorMap_FClass_relExpsWithEvent == null) {
            contributorMap_FClass_relExpsWithEvent = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_relExpsWithEvent(this, contributorMap_FClass_relExpsWithEvent);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2207
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_relExpInInitialEquations = null;

    /** @apilevel internal */
    protected void survey_FClass_relExpInInitialEquations() {
        if (contributorMap_FClass_relExpInInitialEquations == null) {
            contributorMap_FClass_relExpInInitialEquations = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_relExpInInitialEquations(this, contributorMap_FClass_relExpInInitialEquations);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4235
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_myAlgorithms = null;

    /** @apilevel internal */
    protected void survey_FClass_myAlgorithms() {
        if (contributorMap_FClass_myAlgorithms == null) {
            contributorMap_FClass_myAlgorithms = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_myAlgorithms(this, contributorMap_FClass_myAlgorithms);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4318
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_myExternals = null;

    /** @apilevel internal */
    protected void survey_FClass_myExternals() {
        if (contributorMap_FClass_myExternals == null) {
            contributorMap_FClass_myExternals = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_myExternals(this, contributorMap_FClass_myExternals);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2254
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_collectInstAccesses = null;

    /** @apilevel internal */
    protected void survey_FClass_collectInstAccesses() {
        if (contributorMap_FClass_collectInstAccesses == null) {
            contributorMap_FClass_collectInstAccesses = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_collectInstAccesses(this, contributorMap_FClass_collectInstAccesses);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1647
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_collectSemiLinearExps = null;

    /** @apilevel internal */
    protected void survey_FClass_collectSemiLinearExps() {
        if (contributorMap_FClass_collectSemiLinearExps == null) {
            contributorMap_FClass_collectSemiLinearExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_collectSemiLinearExps(this, contributorMap_FClass_collectSemiLinearExps);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:59
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FClass_eventGenExps = null;

    /** @apilevel internal */
    protected void survey_FClass_eventGenExps() {
        if (contributorMap_FClass_eventGenExps == null) {
            contributorMap_FClass_eventGenExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FClass_eventGenExps(this, contributorMap_FClass_eventGenExps);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3273
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractVariable_uses = null;

    /** @apilevel internal */
    protected void survey_FAbstractVariable_uses() {
        if (contributorMap_FAbstractVariable_uses == null) {
            contributorMap_FAbstractVariable_uses = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractVariable_uses(this, contributorMap_FAbstractVariable_uses);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2222
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_eventGenExps = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_eventGenExps() {
        if (contributorMap_FAbstractEquation_eventGenExps == null) {
            contributorMap_FAbstractEquation_eventGenExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_eventGenExps(this, contributorMap_FAbstractEquation_eventGenExps);
        }
    }

    /** @apilevel internal */
    private void varRefMap_reset() {
        varRefMap_computed = false;
        
        varRefMap_value = null;
    }
    /** @apilevel internal */
    protected boolean varRefMap_computed = false;

    /** @apilevel internal */
    protected VarRefMap varRefMap_value;

    /**
     * Lazy attribute which holds the variable reference map.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1095
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1095")
    public VarRefMap varRefMap() {
        ASTState state = state();
        if (varRefMap_computed) {
            return varRefMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        varRefMap_value = new VarRefMap(getFVariables(), this);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        varRefMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return varRefMap_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1142
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1142")
    public int derivativeVariablesOffset() {
        int derivativeVariablesOffset_value = varRefMap().getBy(ZOrdinaryCategory.DERIVATIVE).offset();
        return derivativeVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1143
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1143")
    public int realInputsOffset() {
        int realInputsOffset_value = varRefMap().getBy(ZOrdinaryCategory.REAL_INPUT).offset();
        return realInputsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1144
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1144")
    public int algebraicContinousRealVariablesOffset() {
        int algebraicContinousRealVariablesOffset_value = varRefMap().getBy(ZOrdinaryCategory.CONTINUOUS).offset();
        return algebraicContinousRealVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1147
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1147")
    public int integerInputsOffset() {
        int integerInputsOffset_value = varRefMap().getBy(ZOrdinaryCategory.INTEGER_INPUT).offset();
        return integerInputsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1148
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1148")
    public int enumInputsOffset() {
        int enumInputsOffset_value = varRefMap().getBy(ZOrdinaryCategory.ENUM_INPUT).offset();
        return enumInputsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1150")
    public int booleanInputsOffset() {
        int booleanInputsOffset_value = varRefMap().getBy(ZOrdinaryCategory.BOOLEAN_INPUT).offset();
        return booleanInputsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1152
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1152")
    public int timeOffset() {
        int timeOffset_value = varRefMap().getBy(ZCategory.TIME).offset();
        return timeOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1154")
    public int homotopyLambdaOffset() {
        int homotopyLambdaOffset_value = varRefMap().getBy(ZCategory.HOMOTOPY_LAMBDA).offset();
        return homotopyLambdaOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1229
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1229")
    public int numReals() {
        int numReals_value = reals().size();
        return numReals_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1230")
    public Collection<FVariable> reals() {
        Collection<FVariable> reals_value = varRefMap().getBy(ZType.REAL);
        return reals_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1232
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1232")
    public int numIntegers() {
        int numIntegers_value = integers().size();
        return numIntegers_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1233")
    public Collection<FVariable> integers() {
        Collection<FVariable> integers_value = varRefMap().getBy(ZType.INTEGER);
        return integers_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1235
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1235")
    public int numEnums() {
        int numEnums_value = enums().size();
        return numEnums_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1236
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1236")
    public Collection<FVariable> enums() {
        Collection<FVariable> enums_value = varRefMap().getBy(ZType.ENUM);
        return enums_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1238
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1238")
    public int numBooleans() {
        int numBooleans_value = booleans().size();
        return numBooleans_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1239
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1239")
    public Collection<FVariable> booleans() {
        Collection<FVariable> booleans_value = varRefMap().getBy(ZType.BOOLEAN);
        return booleans_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1241")
    public int numStrings() {
        int numStrings_value = strings().size();
        return numStrings_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1242
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1242")
    public Collection<FVariable> strings() {
        Collection<FVariable> strings_value = varRefMap().getBy(ZType.STRING);
        return strings_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1244
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1244")
    public int numIndependentConstants() {
        int numIndependentConstants_value = independentConstants().size();
        return numIndependentConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1245
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1245")
    public Collection<FVariable> independentConstants() {
        Collection<FVariable> independentConstants_value = varRefMap().getBy(ParaDependency.INDEPENDENT, ZVariability.CONSTANT);
        return independentConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1247
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1247")
    public int numExternalObjectVariables() {
        int numExternalObjectVariables_value = externalObjectVariables().size();
        return numExternalObjectVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1248
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1248")
    public Collection<FVariable> externalObjectVariables() {
        Collection<FVariable> externalObjectVariables_value = varRefMap().getBy(ZType.EXTERNAL);
        return externalObjectVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1250")
    public int independentRealConstantsOffset() {
        int independentRealConstantsOffset_value = independentRealConstants().offset();
        return independentRealConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1251
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1251")
    public int numIndependentRealConstants() {
        int numIndependentRealConstants_value = independentRealConstants().size();
        return numIndependentRealConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1252")
    public ZCategoryEntry independentRealConstants() {
        ZCategoryEntry independentRealConstants_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_REAL_CONSTANT);
        return independentRealConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1254")
    public int independentIntegerConstantsOffset() {
        int independentIntegerConstantsOffset_value = independentIntegerConstants().offset();
        return independentIntegerConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1255")
    public int numIndependentIntegerConstants() {
        int numIndependentIntegerConstants_value = independentIntegerConstants().size();
        return numIndependentIntegerConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1256
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1256")
    public ZCategoryEntry independentIntegerConstants() {
        ZCategoryEntry independentIntegerConstants_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_INTEGER_CONSTANT);
        return independentIntegerConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1258")
    public int independentEnumConstantsOffset() {
        int independentEnumConstantsOffset_value = independentEnumConstants().offset();
        return independentEnumConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1259
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1259")
    public int numIndependentEnumConstants() {
        int numIndependentEnumConstants_value = independentEnumConstants().size();
        return numIndependentEnumConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1260")
    public ZCategoryEntry independentEnumConstants() {
        ZCategoryEntry independentEnumConstants_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_ENUM_CONSTANT);
        return independentEnumConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1262
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1262")
    public int independentBooleanConstantsOffset() {
        int independentBooleanConstantsOffset_value = independentBooleanConstants().offset();
        return independentBooleanConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1263")
    public int numIndependentBooleanConstants() {
        int numIndependentBooleanConstants_value = independentBooleanConstants().size();
        return numIndependentBooleanConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1264
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1264")
    public ZCategoryEntry independentBooleanConstants() {
        ZCategoryEntry independentBooleanConstants_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_BOOLEAN_CONSTANT);
        return independentBooleanConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1266")
    public int numIndependentStringConstants() {
        int numIndependentStringConstants_value = independentStringConstants().size();
        return numIndependentStringConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1267")
    public ZCategoryEntry independentStringConstants() {
        ZCategoryEntry independentStringConstants_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_STRING_CONSTANT);
        return independentStringConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1270
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1270")
    public int numDependentConstants() {
        int numDependentConstants_value = dependentConstants().size();
        return numDependentConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1271")
    public Collection<FVariable> dependentConstants() {
        Collection<FVariable> dependentConstants_value = varRefMap().getBy(ParaDependency.DEPENDENT, ZVariability.CONSTANT);
        return dependentConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1273
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1273")
    public int dependentRealConstantsOffset() {
        int dependentRealConstantsOffset_value = dependentRealConstants().offset();
        return dependentRealConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1274
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1274")
    public int numDependentRealConstants() {
        int numDependentRealConstants_value = dependentRealConstants().size();
        return numDependentRealConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1275
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1275")
    public ZCategoryEntry dependentRealConstants() {
        ZCategoryEntry dependentRealConstants_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_REAL_CONSTANT);
        return dependentRealConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1277
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1277")
    public int dependentIntegerConstantsOffset() {
        int dependentIntegerConstantsOffset_value = dependentIntegerConstants().offset();
        return dependentIntegerConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1278")
    public int numDependentIntegerConstants() {
        int numDependentIntegerConstants_value = dependentIntegerConstants().size();
        return numDependentIntegerConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1279")
    public ZCategoryEntry dependentIntegerConstants() {
        ZCategoryEntry dependentIntegerConstants_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_INTEGER_CONSTANT);
        return dependentIntegerConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1281
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1281")
    public int dependentEnumConstantsOffset() {
        int dependentEnumConstantsOffset_value = dependentEnumConstants().offset();
        return dependentEnumConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1282")
    public int numDependentEnumConstants() {
        int numDependentEnumConstants_value = dependentEnumConstants().size();
        return numDependentEnumConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1283
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1283")
    public ZCategoryEntry dependentEnumConstants() {
        ZCategoryEntry dependentEnumConstants_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_ENUM_CONSTANT);
        return dependentEnumConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1285
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1285")
    public int dependentBooleanConstantsOffset() {
        int dependentBooleanConstantsOffset_value = dependentBooleanConstants().offset();
        return dependentBooleanConstantsOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1286
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1286")
    public int numDependentBooleanConstants() {
        int numDependentBooleanConstants_value = dependentBooleanConstants().size();
        return numDependentBooleanConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1287
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1287")
    public ZCategoryEntry dependentBooleanConstants() {
        ZCategoryEntry dependentBooleanConstants_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_BOOLEAN_CONSTANT);
        return dependentBooleanConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1289
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1289")
    public int numDependentStringConstants() {
        int numDependentStringConstants_value = dependentStringConstants().size();
        return numDependentStringConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1290
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1290")
    public ZCategoryEntry dependentStringConstants() {
        ZCategoryEntry dependentStringConstants_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_STRING_CONSTANT);
        return dependentStringConstants_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1292
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1292")
    public int numIndependentParameters() {
        int numIndependentParameters_value = independentParameters().size();
        return numIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1293
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1293")
    public Collection<FVariable> independentParameters() {
        Collection<FVariable> independentParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT);
        return independentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1295
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1295")
    public int numIndependentRealParameters() {
        int numIndependentRealParameters_value = independentRealParameters().size();
        return numIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1296
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1296")
    public Collection<FVariable> independentRealParameters() {
        Collection<FVariable> independentRealParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT, ZType.REAL);
        return independentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1298
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1298")
    public int numIndependentIntegerParameters() {
        int numIndependentIntegerParameters_value = independentIntegerParameters().size();
        return numIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1299")
    public Collection<FVariable> independentIntegerParameters() {
        Collection<FVariable> independentIntegerParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT, ZType.INTEGER);
        return independentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1301
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1301")
    public int numIndependentEnumParameters() {
        int numIndependentEnumParameters_value = independentEnumParameters().size();
        return numIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1302
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1302")
    public Collection<FVariable> independentEnumParameters() {
        Collection<FVariable> independentEnumParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT, ZType.ENUM);
        return independentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1304
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1304")
    public int numIndependentBooleanParameters() {
        int numIndependentBooleanParameters_value = independentBooleanParameters().size();
        return numIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1305
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1305")
    public Collection<FVariable> independentBooleanParameters() {
        Collection<FVariable> independentBooleanParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT, ZType.BOOLEAN);
        return independentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1307
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1307")
    public int numIndependentStringParameters() {
        int numIndependentStringParameters_value = independentStringParameters().size();
        return numIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1308
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1308")
    public Collection<FVariable> independentStringParameters() {
        Collection<FVariable> independentStringParameters_value = varRefMap().getParameterBy(ParaDependency.INDEPENDENT, ZType.STRING);
        return independentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1310")
    public int numRegularIndependentParameters() {
        int numRegularIndependentParameters_value = regularIndependentParameters().size();
        return numRegularIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1311
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1311")
    public Collection<FVariable> regularIndependentParameters() {
        Collection<FVariable> regularIndependentParameters_value = varRefMap().getBy(ParaDependency.INDEPENDENT, ZVariability.REGULAR_PARAMETER);
        return regularIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1313
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1313")
    public int independentRealParametersOffset() {
        int independentRealParametersOffset_value = regularIndependentRealParameters().offset();
        return independentRealParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1314")
    public int numRegularIndependentRealParameters() {
        int numRegularIndependentRealParameters_value = regularIndependentRealParameters().size();
        return numRegularIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1315")
    public ZCategoryEntry regularIndependentRealParameters() {
        ZCategoryEntry regularIndependentRealParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_REAL_REGULAR_PARAMETER);
        return regularIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1317
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1317")
    public int independentIntegerParametersOffset() {
        int independentIntegerParametersOffset_value = regularIndependentIntegerParameters().offset();
        return independentIntegerParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1318
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1318")
    public int numRegularIndependentIntegerParameters() {
        int numRegularIndependentIntegerParameters_value = regularIndependentIntegerParameters().size();
        return numRegularIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1319
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1319")
    public ZCategoryEntry regularIndependentIntegerParameters() {
        ZCategoryEntry regularIndependentIntegerParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_INTEGER_REGULAR_PARAMETER);
        return regularIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1321")
    public int independentEnumParametersOffset() {
        int independentEnumParametersOffset_value = regularIndependentEnumParameters().offset();
        return independentEnumParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1322")
    public int numRegularIndependentEnumParameters() {
        int numRegularIndependentEnumParameters_value = regularIndependentEnumParameters().size();
        return numRegularIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1323
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1323")
    public ZCategoryEntry regularIndependentEnumParameters() {
        ZCategoryEntry regularIndependentEnumParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_ENUM_REGULAR_PARAMETER);
        return regularIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1325")
    public int independentBooleanParametersOffset() {
        int independentBooleanParametersOffset_value = regularIndependentBooleanParameters().offset();
        return independentBooleanParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1326
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1326")
    public int numRegularIndependentBooleanParameters() {
        int numRegularIndependentBooleanParameters_value = regularIndependentBooleanParameters().size();
        return numRegularIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1327
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1327")
    public ZCategoryEntry regularIndependentBooleanParameters() {
        ZCategoryEntry regularIndependentBooleanParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_BOOLEAN_REGULAR_PARAMETER);
        return regularIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1329
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1329")
    public int numRegularIndependentStringParameters() {
        int numRegularIndependentStringParameters_value = regularIndependentStringParameters().size();
        return numRegularIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1330")
    public ZCategoryEntry regularIndependentStringParameters() {
        ZCategoryEntry regularIndependentStringParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_STRING_REGULAR_PARAMETER);
        return regularIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1332
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1332")
    public int numStructuralIndependentParameters() {
        int numStructuralIndependentParameters_value = structuralIndependentParameters().size();
        return numStructuralIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1333
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1333")
    public Collection<FVariable> structuralIndependentParameters() {
        Collection<FVariable> structuralIndependentParameters_value = varRefMap().getBy(ParaDependency.INDEPENDENT, ZVariability.STRUCTURAL_PARAMETER);
        return structuralIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1335
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1335")
    public int numStructuralIndependentRealParameters() {
        int numStructuralIndependentRealParameters_value = structuralIndependentRealParameters().size();
        return numStructuralIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1336
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1336")
    public ZCategoryEntry structuralIndependentRealParameters() {
        ZCategoryEntry structuralIndependentRealParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_REAL_STRUCTURAL_PARAMETER);
        return structuralIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1338")
    public int numStructuralIndependentIntegerParameters() {
        int numStructuralIndependentIntegerParameters_value = structuralIndependentIntegerParameters().size();
        return numStructuralIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1339
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1339")
    public ZCategoryEntry structuralIndependentIntegerParameters() {
        ZCategoryEntry structuralIndependentIntegerParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_INTEGER_STRUCTURAL_PARAMETER);
        return structuralIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1341
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1341")
    public int numStructuralIndependentEnumParameters() {
        int numStructuralIndependentEnumParameters_value = structuralIndependentEnumParameters().size();
        return numStructuralIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1342
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1342")
    public ZCategoryEntry structuralIndependentEnumParameters() {
        ZCategoryEntry structuralIndependentEnumParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_ENUM_STRUCTURAL_PARAMETER);
        return structuralIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1344")
    public int numStructuralIndependentBooleanParameters() {
        int numStructuralIndependentBooleanParameters_value = structuralIndependentBooleanParameters().size();
        return numStructuralIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1345")
    public ZCategoryEntry structuralIndependentBooleanParameters() {
        ZCategoryEntry structuralIndependentBooleanParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_BOOLEAN_STRUCTURAL_PARAMETER);
        return structuralIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1347
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1347")
    public int numStructuralIndependentStringParameters() {
        int numStructuralIndependentStringParameters_value = structuralIndependentStringParameters().size();
        return numStructuralIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1348")
    public ZCategoryEntry structuralIndependentStringParameters() {
        ZCategoryEntry structuralIndependentStringParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_STRING_STRUCTURAL_PARAMETER);
        return structuralIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1350
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1350")
    public int numFinalIndependentParameters() {
        int numFinalIndependentParameters_value = finalIndependentParameters().size();
        return numFinalIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1351
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1351")
    public Collection<FVariable> finalIndependentParameters() {
        Collection<FVariable> finalIndependentParameters_value = varRefMap().getBy(ParaDependency.INDEPENDENT, ZVariability.FINAL_PARAMETER);
        return finalIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1353
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1353")
    public int numFinalIndependentRealParameters() {
        int numFinalIndependentRealParameters_value = finalIndependentRealParameters().size();
        return numFinalIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1354
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1354")
    public ZCategoryEntry finalIndependentRealParameters() {
        ZCategoryEntry finalIndependentRealParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_REAL_FINAL_PARAMETER);
        return finalIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1356")
    public int numFinalIndependentIntegerParameters() {
        int numFinalIndependentIntegerParameters_value = finalIndependentIntegerParameters().size();
        return numFinalIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1357
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1357")
    public ZCategoryEntry finalIndependentIntegerParameters() {
        ZCategoryEntry finalIndependentIntegerParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_INTEGER_FINAL_PARAMETER);
        return finalIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1359
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1359")
    public int numFinalIndependentEnumParameters() {
        int numFinalIndependentEnumParameters_value = finalIndependentEnumParameters().size();
        return numFinalIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1360")
    public ZCategoryEntry finalIndependentEnumParameters() {
        ZCategoryEntry finalIndependentEnumParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_ENUM_FINAL_PARAMETER);
        return finalIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1362")
    public int numFinalIndependentBooleanParameters() {
        int numFinalIndependentBooleanParameters_value = finalIndependentBooleanParameters().size();
        return numFinalIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1363")
    public ZCategoryEntry finalIndependentBooleanParameters() {
        ZCategoryEntry finalIndependentBooleanParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_BOOLEAN_FINAL_PARAMETER);
        return finalIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1365
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1365")
    public int numFinalIndependentStringParameters() {
        int numFinalIndependentStringParameters_value = finalIndependentStringParameters().size();
        return numFinalIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1366
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1366")
    public ZCategoryEntry finalIndependentStringParameters() {
        ZCategoryEntry finalIndependentStringParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_STRING_FINAL_PARAMETER);
        return finalIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1368
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1368")
    public int numEvalIndependentParameters() {
        int numEvalIndependentParameters_value = evalIndependentParameters().size();
        return numEvalIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1369
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1369")
    public Collection<FVariable> evalIndependentParameters() {
        Collection<FVariable> evalIndependentParameters_value = varRefMap().getBy(ParaDependency.INDEPENDENT, ZVariability.STRUCTURAL_PARAMETER);
        return evalIndependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1371
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1371")
    public int numEvalIndependentRealParameters() {
        int numEvalIndependentRealParameters_value = evalIndependentRealParameters().size();
        return numEvalIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1372
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1372")
    public ZCategoryEntry evalIndependentRealParameters() {
        ZCategoryEntry evalIndependentRealParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_REAL_EVAL_PARAMETER);
        return evalIndependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1374")
    public int numEvalIndependentIntegerParameters() {
        int numEvalIndependentIntegerParameters_value = evalIndependentIntegerParameters().size();
        return numEvalIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1375
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1375")
    public ZCategoryEntry evalIndependentIntegerParameters() {
        ZCategoryEntry evalIndependentIntegerParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_INTEGER_EVAL_PARAMETER);
        return evalIndependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1377")
    public int numEvalIndependentEnumParameters() {
        int numEvalIndependentEnumParameters_value = evalIndependentEnumParameters().size();
        return numEvalIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1378
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1378")
    public ZCategoryEntry evalIndependentEnumParameters() {
        ZCategoryEntry evalIndependentEnumParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_ENUM_EVAL_PARAMETER);
        return evalIndependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1380
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1380")
    public int numEvalIndependentBooleanParameters() {
        int numEvalIndependentBooleanParameters_value = evalIndependentBooleanParameters().size();
        return numEvalIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1381
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1381")
    public ZCategoryEntry evalIndependentBooleanParameters() {
        ZCategoryEntry evalIndependentBooleanParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_BOOLEAN_EVAL_PARAMETER);
        return evalIndependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1383
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1383")
    public int numEvalIndependentStringParameters() {
        int numEvalIndependentStringParameters_value = evalIndependentStringParameters().size();
        return numEvalIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1384
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1384")
    public ZCategoryEntry evalIndependentStringParameters() {
        ZCategoryEntry evalIndependentStringParameters_value = varRefMap().getBy(ZOrdinaryCategory.INDEPENDENT_STRING_EVAL_PARAMETER);
        return evalIndependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1386
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1386")
    public int numDependentParameters() {
        int numDependentParameters_value = dependentParameters().size();
        return numDependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1387")
    public Collection<FVariable> dependentParameters() {
        Collection<FVariable> dependentParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT);
        return dependentParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1389
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1389")
    public int numDependentRealParameters() {
        int numDependentRealParameters_value = dependentRealParameters().size();
        return numDependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1390")
    public Collection<FVariable> dependentRealParameters() {
        Collection<FVariable> dependentRealParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT, ZType.REAL);
        return dependentRealParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1392
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1392")
    public int numDependentIntegerParameters() {
        int numDependentIntegerParameters_value = dependentIntegerParameters().size();
        return numDependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1393
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1393")
    public Collection<FVariable> dependentIntegerParameters() {
        Collection<FVariable> dependentIntegerParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT, ZType.INTEGER);
        return dependentIntegerParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1395
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1395")
    public int numDependentEnumParameters() {
        int numDependentEnumParameters_value = dependentEnumParameters().size();
        return numDependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1396
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1396")
    public Collection<FVariable> dependentEnumParameters() {
        Collection<FVariable> dependentEnumParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT, ZType.ENUM);
        return dependentEnumParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1398
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1398")
    public int numDependentBooleanParameters() {
        int numDependentBooleanParameters_value = dependentBooleanParameters().size();
        return numDependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1399")
    public Collection<FVariable> dependentBooleanParameters() {
        Collection<FVariable> dependentBooleanParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT, ZType.BOOLEAN);
        return dependentBooleanParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1401
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1401")
    public int numDependentStringParameters() {
        int numDependentStringParameters_value = dependentStringParameters().size();
        return numDependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1402
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1402")
    public Collection<FVariable> dependentStringParameters() {
        Collection<FVariable> dependentStringParameters_value = varRefMap().getParameterBy(ParaDependency.DEPENDENT, ZType.STRING);
        return dependentStringParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1404
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1404")
    public int dependentRealRegularParametersOffset() {
        int dependentRealRegularParametersOffset_value = dependentRealRegularParameters().offset();
        return dependentRealRegularParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1405")
    public int numDependentRealRegularParameters() {
        int numDependentRealRegularParameters_value = dependentRealRegularParameters().size();
        return numDependentRealRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1406")
    public ZCategoryEntry dependentRealRegularParameters() {
        ZCategoryEntry dependentRealRegularParameters_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_REAL_REGULAR_PARAMETER);
        return dependentRealRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1408
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1408")
    public int dependentIntegerRegularParametersOffset() {
        int dependentIntegerRegularParametersOffset_value = dependentIntegerRegularParameters().offset();
        return dependentIntegerRegularParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1409")
    public int numDependentIntegerRegularParameters() {
        int numDependentIntegerRegularParameters_value = dependentIntegerRegularParameters().size();
        return numDependentIntegerRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1410
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1410")
    public ZCategoryEntry dependentIntegerRegularParameters() {
        ZCategoryEntry dependentIntegerRegularParameters_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_INTEGER_REGULAR_PARAMETER);
        return dependentIntegerRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1412")
    public int dependentEnumRegularParametersOffset() {
        int dependentEnumRegularParametersOffset_value = dependentEnumRegularParameters().offset();
        return dependentEnumRegularParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1413
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1413")
    public int numDependentEnumRegularParameters() {
        int numDependentEnumRegularParameters_value = dependentEnumRegularParameters().size();
        return numDependentEnumRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1414
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1414")
    public ZCategoryEntry dependentEnumRegularParameters() {
        ZCategoryEntry dependentEnumRegularParameters_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_ENUM_REGULAR_PARAMETER);
        return dependentEnumRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1416
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1416")
    public int dependentBooleanRegularParametersOffset() {
        int dependentBooleanRegularParametersOffset_value = dependentBooleanRegularParameters().offset();
        return dependentBooleanRegularParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1417
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1417")
    public int numDependentBooleanRegularParameters() {
        int numDependentBooleanRegularParameters_value = dependentBooleanRegularParameters().size();
        return numDependentBooleanRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1418")
    public ZCategoryEntry dependentBooleanRegularParameters() {
        ZCategoryEntry dependentBooleanRegularParameters_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_BOOLEAN_REGULAR_PARAMETER);
        return dependentBooleanRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1420
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1420")
    public int numDependentStringRegularParameters() {
        int numDependentStringRegularParameters_value = dependentStringRegularParameters().size();
        return numDependentStringRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1421
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1421")
    public ZCategoryEntry dependentStringRegularParameters() {
        ZCategoryEntry dependentStringRegularParameters_value = varRefMap().getBy(ZOrdinaryCategory.DEPENDENT_STRING_REGULAR_PARAMETER);
        return dependentStringRegularParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1423
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1423")
    public int realInitialParametersOffset() {
        int realInitialParametersOffset_value = realInitialParameters().offset();
        return realInitialParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1424
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1424")
    public int numRealInitialParameters() {
        int numRealInitialParameters_value = realInitialParameters().size();
        return numRealInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1425
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1425")
    public ZCategoryEntry realInitialParameters() {
        ZCategoryEntry realInitialParameters_value = varRefMap().getBy(ZOrdinaryCategory.REAL_INITIAL_PARAMETER);
        return realInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1427")
    public int integerInitialParametersOffset() {
        int integerInitialParametersOffset_value = integerInitialParameters().offset();
        return integerInitialParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1428")
    public int numIntegerInitialParameters() {
        int numIntegerInitialParameters_value = integerInitialParameters().size();
        return numIntegerInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1429
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1429")
    public ZCategoryEntry integerInitialParameters() {
        ZCategoryEntry integerInitialParameters_value = varRefMap().getBy(ZOrdinaryCategory.INTEGER_INITIAL_PARAMETER);
        return integerInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1431
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1431")
    public int enumInitialParametersOffset() {
        int enumInitialParametersOffset_value = enumInitialParameters().offset();
        return enumInitialParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1432
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1432")
    public int numEnumInitialParameters() {
        int numEnumInitialParameters_value = enumInitialParameters().size();
        return numEnumInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1433
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1433")
    public ZCategoryEntry enumInitialParameters() {
        ZCategoryEntry enumInitialParameters_value = varRefMap().getBy(ZOrdinaryCategory.ENUM_INITIAL_PARAMETER);
        return enumInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1435
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1435")
    public int booleanInitialParametersOffset() {
        int booleanInitialParametersOffset_value = booleanInitialParameters().offset();
        return booleanInitialParametersOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1436
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1436")
    public int numBooleanInitialParameters() {
        int numBooleanInitialParameters_value = booleanInitialParameters().size();
        return numBooleanInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1437
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1437")
    public ZCategoryEntry booleanInitialParameters() {
        ZCategoryEntry booleanInitialParameters_value = varRefMap().getBy(ZOrdinaryCategory.BOOLEAN_INITIAL_PARAMETER);
        return booleanInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1439
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1439")
    public int numStringInitialParameters() {
        int numStringInitialParameters_value = stringInitialParameters().size();
        return numStringInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1440
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1440")
    public ZCategoryEntry stringInitialParameters() {
        ZCategoryEntry stringInitialParameters_value = varRefMap().getBy(ZOrdinaryCategory.STRING_INITIAL_PARAMETER);
        return stringInitialParameters_value;
    }
    /**
     * Optimica specific but used in Modelica...
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1445
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1445")
    public int numFreeParameters() {
        int numFreeParameters_value = freeParameters().size();
        return numFreeParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1446")
    public Collection<FVariable> freeParameters() {
        Collection<FVariable> freeParameters_value = varRefMap().getBy(ZVariability.FREE_PARAMETER);
        return freeParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1449
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1449")
    public int discreteRealVariablesOffset() {
        int discreteRealVariablesOffset_value = discreteRealVariables().offset();
        return discreteRealVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1450
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1450")
    public int numDiscreteRealVariables() {
        int numDiscreteRealVariables_value = discreteRealVariables().size();
        return numDiscreteRealVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1451
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1451")
    public ZCategoryEntry discreteRealVariables() {
        ZCategoryEntry discreteRealVariables_value = varRefMap().getBy(ZOrdinaryCategory.DISCRETE_REAL);
        return discreteRealVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1453
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1453")
    public int discreteIntegerVariablesOffset() {
        int discreteIntegerVariablesOffset_value = discreteIntegerVariables().offset();
        return discreteIntegerVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1454
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1454")
    public int numDiscreteIntegerVariables() {
        int numDiscreteIntegerVariables_value = discreteIntegerVariables().size();
        return numDiscreteIntegerVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1455")
    public ZCategoryEntry discreteIntegerVariables() {
        ZCategoryEntry discreteIntegerVariables_value = varRefMap().getBy(ZOrdinaryCategory.DISCRETE_INTEGER);
        return discreteIntegerVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1457
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1457")
    public int discreteEnumVariablesOffset() {
        int discreteEnumVariablesOffset_value = discreteEnumVariables().offset();
        return discreteEnumVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1458
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1458")
    public int numDiscreteEnumVariables() {
        int numDiscreteEnumVariables_value = discreteEnumVariables().size();
        return numDiscreteEnumVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1459
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1459")
    public ZCategoryEntry discreteEnumVariables() {
        ZCategoryEntry discreteEnumVariables_value = varRefMap().getBy(ZOrdinaryCategory.DISCRETE_ENUM);
        return discreteEnumVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1461
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1461")
    public int discreteBooleanVariablesOffset() {
        int discreteBooleanVariablesOffset_value = discreteBooleanVariables().offset();
        return discreteBooleanVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1462
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1462")
    public int numDiscreteBooleanVariables() {
        int numDiscreteBooleanVariables_value = discreteBooleanVariables().size();
        return numDiscreteBooleanVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1463
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1463")
    public ZCategoryEntry discreteBooleanVariables() {
        ZCategoryEntry discreteBooleanVariables_value = varRefMap().getBy(ZOrdinaryCategory.DISCRETE_BOOLEAN);
        return discreteBooleanVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1465
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1465")
    public int numDiscreteStringVariables() {
        int numDiscreteStringVariables_value = discreteStringVariables().size();
        return numDiscreteStringVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1466
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1466")
    public ZCategoryEntry discreteStringVariables() {
        ZCategoryEntry discreteStringVariables_value = varRefMap().getBy(ZOrdinaryCategory.DISCRETE_STRING);
        return discreteStringVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1468
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1468")
    public int differentiatedRealVariablesOffset() {
        int differentiatedRealVariablesOffset_value = differentiatedRealVariables().offset();
        return differentiatedRealVariablesOffset_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1469
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1469")
    public int numDifferentiatedRealVariables() {
        int numDifferentiatedRealVariables_value = differentiatedRealVariables().size();
        return numDifferentiatedRealVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1470
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1470")
    public ZCategoryEntry differentiatedRealVariables() {
        ZCategoryEntry differentiatedRealVariables_value = varRefMap().getBy(ZOrdinaryCategory.DIFFERENTIATED);
        return differentiatedRealVariables_value;
    }
    /** @apilevel internal */
    private void differentiatedRealVariablesList_reset() {
        differentiatedRealVariablesList_computed = false;
        
        differentiatedRealVariablesList_value = null;
    }
    /** @apilevel internal */
    protected boolean differentiatedRealVariablesList_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> differentiatedRealVariablesList_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1473
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1473")
    public ArrayList<FVariable> differentiatedRealVariablesList() {
        ASTState state = state();
        if (differentiatedRealVariablesList_computed) {
            return differentiatedRealVariablesList_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        differentiatedRealVariablesList_value = differentiatedRealVariablesList_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        differentiatedRealVariablesList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return differentiatedRealVariablesList_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> differentiatedRealVariablesList_compute() {
            ArrayList<FVariable> l = new ArrayList<FVariable>();
            for (FVariable fv : differentiatedRealVariables()) 
                l.add(fv);
            return l;
        }
    /** @apilevel internal */
    private void allDifferentiatedRealVariables_reset() {
        allDifferentiatedRealVariables_computed = false;
        
        allDifferentiatedRealVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean allDifferentiatedRealVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> allDifferentiatedRealVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1482
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1482")
    public LinkedHashSet<FVariable> allDifferentiatedRealVariables() {
        ASTState state = state();
        if (allDifferentiatedRealVariables_computed) {
            return allDifferentiatedRealVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        allDifferentiatedRealVariables_value = allDifferentiatedRealVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        allDifferentiatedRealVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return allDifferentiatedRealVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> allDifferentiatedRealVariables_compute() {
            LinkedHashSet<FVariable> set = new LinkedHashSet<FVariable>();
            set.addAll(differentiatedRealVariables());
            set.addAll(dynamicStates());
            return set;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1498
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1498")
    public int numDynamicStates() {
        int numDynamicStates_value = dynamicStates().size();
        return numDynamicStates_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1509
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1509")
    public int numDynamicStateVariables() {
        int numDynamicStateVariables_value = dynamicStateVariables().size();
        return numDynamicStateVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1519
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1519")
    public int numDynamicAlgebraicVariables() {
        int numDynamicAlgebraicVariables_value = dynamicAlgebraicVariables().size();
        return numDynamicAlgebraicVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1576
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1576")
    public int numDerivativeVariables() {
        int numDerivativeVariables_value = derivativeVariables().size();
        return numDerivativeVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1583")
    public int numVariables() {
        int numVariables_value = variables().size();
        return numVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1590
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1590")
    public int numDiscreteVariables() {
        int numDiscreteVariables_value = discreteVariables().size();
        return numDiscreteVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1591
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1591")
    public Collection<FVariable> discreteVariables() {
        Collection<FVariable> discreteVariables_value = varRefMap().getBy(ZVariability.DISCRETE);
        return discreteVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1593
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1593")
    public int numInitialParameters() {
        int numInitialParameters_value = initialParameters().size();
        return numInitialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1594
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1594")
    public Collection<FVariable> initialParameters() {
        Collection<FVariable> initialParameters_value = varRefMap().getBy(ZVariability.INITIAL_PARAMETER);
        return initialParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1630
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1630")
    public int numDiscretePreVariables() {
        int numDiscretePreVariables_value = discretePreVariables().size();
        return numDiscretePreVariables_value;
    }
    /** @apilevel internal */
    private void discretePreVariables_reset() {
        discretePreVariables_computed = false;
        
        discretePreVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discretePreVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> discretePreVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1631
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1631")
    public Collection<FVariable> discretePreVariables() {
        ASTState state = state();
        if (discretePreVariables_computed) {
            return discretePreVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discretePreVariables_value = discretePreVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discretePreVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discretePreVariables_value;
    }
    /** @apilevel internal */
    private Collection<FVariable> discretePreVariables_compute() {
            Collection<FVariable> l = new ArrayList<FVariable>();
            for (FVariable fv : discreteVariables()) {
                l.add((FVariable) lookupFV(fv.getFAccess().preName()));
            }
            for (FVariable fv : continuousVariablesUsedInPreInInitial()) {
                l.add((FVariable) lookupFV(fv.getFAccess().preName()));
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1642
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1642")
    public int numAliasVariables() {
        int numAliasVariables_value = aliasVariables().size();
        return numAliasVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1649
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1649")
    public int numAllVariables() {
        int numAllVariables_value = allVariables().size();
        return numAllVariables_value;
    }
    /** @apilevel internal */
    private void allVariables_reset() {
        allVariables_computed = false;
        
        allVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean allVariables_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> allVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1650
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1650")
    public ArrayList<FVariable> allVariables() {
        ASTState state = state();
        if (allVariables_computed) {
            return allVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        allVariables_value = allVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        allVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return allVariables_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> allVariables_compute() {
              ArrayList<FVariable> set = new ArrayList<FVariable>();
              for (FVariable fv : getFVariables()) {
                      set.add(fv);
                  }
              for (FVariable fv : getAliasVariables()) {
                      set.add(fv);
                  }
              return set;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1661
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1661")
    public int numTempVariables() {
        int numTempVariables_value = tempVariables().size();
        return numTempVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1668
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1668")
    public int numRealVariables() {
        int numRealVariables_value = realVariables().size();
        return numRealVariables_value;
    }
    /** @apilevel internal */
    private void realVariables_reset() {
        realVariables_computed = false;
        
        realVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean realVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FRealVariable> realVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1669
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1669")
    public Collection<FRealVariable> realVariables() {
        ASTState state = state();
        if (realVariables_computed) {
            return realVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        realVariables_value = filterCollection(variables(), REAL_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        realVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return realVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1672
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1672")
    public int numIntegerVariables() {
        int numIntegerVariables_value = integerVariables().size();
        return numIntegerVariables_value;
    }
    /** @apilevel internal */
    private void integerVariables_reset() {
        integerVariables_computed = false;
        
        integerVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean integerVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FIntegerVariable> integerVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1673
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1673")
    public Collection<FIntegerVariable> integerVariables() {
        ASTState state = state();
        if (integerVariables_computed) {
            return integerVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        integerVariables_value = filterCollection(variables(), INTEGER_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        integerVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return integerVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1676
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1676")
    public int numEnumVariables() {
        int numEnumVariables_value = enumVariables().size();
        return numEnumVariables_value;
    }
    /** @apilevel internal */
    private void enumVariables_reset() {
        enumVariables_computed = false;
        
        enumVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean enumVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FEnumVariable> enumVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1677")
    public Collection<FEnumVariable> enumVariables() {
        ASTState state = state();
        if (enumVariables_computed) {
            return enumVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        enumVariables_value = filterCollection(variables(), ENUM_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        enumVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return enumVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1680
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1680")
    public int numBooleanVariables() {
        int numBooleanVariables_value = booleanVariables().size();
        return numBooleanVariables_value;
    }
    /** @apilevel internal */
    private void booleanVariables_reset() {
        booleanVariables_computed = false;
        
        booleanVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean booleanVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FBooleanVariable> booleanVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1681
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1681")
    public Collection<FBooleanVariable> booleanVariables() {
        ASTState state = state();
        if (booleanVariables_computed) {
            return booleanVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        booleanVariables_value = filterCollection(variables(), BOOLEAN_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        booleanVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return booleanVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1684
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1684")
    public int numStringVariables() {
        int numStringVariables_value = stringVariables().size();
        return numStringVariables_value;
    }
    /** @apilevel internal */
    private void stringVariables_reset() {
        stringVariables_computed = false;
        
        stringVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean stringVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FStringVariable> stringVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1685
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1685")
    public Collection<FStringVariable> stringVariables() {
        ASTState state = state();
        if (stringVariables_computed) {
            return stringVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stringVariables_value = filterCollection(variables(), STRING_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stringVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stringVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1688
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1688")
    public int numAlgebraicContinousRealVariables() {
        int numAlgebraicContinousRealVariables_value = algebraicContinousRealVariables().size();
        return numAlgebraicContinousRealVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1689
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1689")
    public Collection<FVariable> algebraicContinousRealVariables() {
        Collection<FVariable> algebraicContinousRealVariables_value = varRefMap().getBy(ZOrdinaryCategory.CONTINUOUS);
        return algebraicContinousRealVariables_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1691
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1691")
    public int numNormalAlgebraicContinousRealVariables() {
        int numNormalAlgebraicContinousRealVariables_value = normalAlgebraicContinousRealVariables().size();
        return numNormalAlgebraicContinousRealVariables_value;
    }
    /** @apilevel internal */
    private void normalAlgebraicContinousRealVariables_reset() {
        normalAlgebraicContinousRealVariables_computed = false;
        
        normalAlgebraicContinousRealVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean normalAlgebraicContinousRealVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> normalAlgebraicContinousRealVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1692
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1692")
    public Collection<FVariable> normalAlgebraicContinousRealVariables() {
        ASTState state = state();
        if (normalAlgebraicContinousRealVariables_computed) {
            return normalAlgebraicContinousRealVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        normalAlgebraicContinousRealVariables_value = normalAlgebraicContinousRealVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        normalAlgebraicContinousRealVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return normalAlgebraicContinousRealVariables_value;
    }
    /** @apilevel internal */
    private Collection<FVariable> normalAlgebraicContinousRealVariables_compute() {
            // TODO: Refactor to new framework!
            Collection<FVariable> set = new LinkedHashSet<FVariable>();
            for (FVariable var : algebraicContinousRealVariables()) {
                set.add(var);
            }
            set.removeAll(dynamicStates());
            return set;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1710
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1710")
    public Collection<FVariable> algebraicVariables() {
        Collection<FVariable> algebraicVariables_value = varRefMap().getBy(ALGEBRAIC_FILTER);
        return algebraicVariables_value;
    }
    /** @apilevel internal */
    private void normalAlgebraicVariables_reset() {
        normalAlgebraicVariables_computed = false;
        
        normalAlgebraicVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean normalAlgebraicVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> normalAlgebraicVariables_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1712
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1712")
    public Collection<FVariable> normalAlgebraicVariables() {
        ASTState state = state();
        if (normalAlgebraicVariables_computed) {
            return normalAlgebraicVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        normalAlgebraicVariables_value = normalAlgebraicVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        normalAlgebraicVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return normalAlgebraicVariables_value;
    }
    /** @apilevel internal */
    private Collection<FVariable> normalAlgebraicVariables_compute() {
            Collection<FVariable> set = new LinkedHashSet<FVariable>(algebraicVariables());
            set.removeAll(dynamicStates());
            return set;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1718
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1718")
    public int numVariablesWithBindingExp() {
        int numVariablesWithBindingExp_value = variablesWithBindingExp().size();
        return numVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1725
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1725")
    public int numRealVariablesWithBindingExp() {
        int numRealVariablesWithBindingExp_value = realVariablesWithBindingExp().size();
        return numRealVariablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private void realVariablesWithBindingExp_reset() {
        realVariablesWithBindingExp_computed = false;
        
        realVariablesWithBindingExp_value = null;
    }
    /** @apilevel internal */
    protected boolean realVariablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> realVariablesWithBindingExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1726
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1726")
    public Collection<FVariable> realVariablesWithBindingExp() {
        ASTState state = state();
        if (realVariablesWithBindingExp_computed) {
            return realVariablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        realVariablesWithBindingExp_value = filterCollection(variablesWithBindingExp(), REAL_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        realVariablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return realVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1729
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1729")
    public int numIntegerVariablesWithBindingExp() {
        int numIntegerVariablesWithBindingExp_value = integerVariablesWithBindingExp().size();
        return numIntegerVariablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private void integerVariablesWithBindingExp_reset() {
        integerVariablesWithBindingExp_computed = false;
        
        integerVariablesWithBindingExp_value = null;
    }
    /** @apilevel internal */
    protected boolean integerVariablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> integerVariablesWithBindingExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1730
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1730")
    public Collection<FVariable> integerVariablesWithBindingExp() {
        ASTState state = state();
        if (integerVariablesWithBindingExp_computed) {
            return integerVariablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        integerVariablesWithBindingExp_value = filterCollection(variablesWithBindingExp(), INTEGER_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        integerVariablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return integerVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1733
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1733")
    public int numEnumVariablesWithBindingExp() {
        int numEnumVariablesWithBindingExp_value = enumVariablesWithBindingExp().size();
        return numEnumVariablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private void enumVariablesWithBindingExp_reset() {
        enumVariablesWithBindingExp_computed = false;
        
        enumVariablesWithBindingExp_value = null;
    }
    /** @apilevel internal */
    protected boolean enumVariablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> enumVariablesWithBindingExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1734
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1734")
    public Collection<FVariable> enumVariablesWithBindingExp() {
        ASTState state = state();
        if (enumVariablesWithBindingExp_computed) {
            return enumVariablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        enumVariablesWithBindingExp_value = filterCollection(variablesWithBindingExp(), ENUM_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        enumVariablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return enumVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1737
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1737")
    public int numBooleanVariablesWithBindingExp() {
        int numBooleanVariablesWithBindingExp_value = booleanVariablesWithBindingExp().size();
        return numBooleanVariablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private void booleanVariablesWithBindingExp_reset() {
        booleanVariablesWithBindingExp_computed = false;
        
        booleanVariablesWithBindingExp_value = null;
    }
    /** @apilevel internal */
    protected boolean booleanVariablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> booleanVariablesWithBindingExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1738
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1738")
    public Collection<FVariable> booleanVariablesWithBindingExp() {
        ASTState state = state();
        if (booleanVariablesWithBindingExp_computed) {
            return booleanVariablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        booleanVariablesWithBindingExp_value = filterCollection(variablesWithBindingExp(), BOOLEAN_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        booleanVariablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return booleanVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1741
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1741")
    public int numStringVariablesWithBindingExp() {
        int numStringVariablesWithBindingExp_value = stringVariablesWithBindingExp().size();
        return numStringVariablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private void stringVariablesWithBindingExp_reset() {
        stringVariablesWithBindingExp_computed = false;
        
        stringVariablesWithBindingExp_value = null;
    }
    /** @apilevel internal */
    protected boolean stringVariablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> stringVariablesWithBindingExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1742
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1742")
    public Collection<FVariable> stringVariablesWithBindingExp() {
        ASTState state = state();
        if (stringVariablesWithBindingExp_computed) {
            return stringVariablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stringVariablesWithBindingExp_value = filterCollection(variablesWithBindingExp(), STRING_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stringVariablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stringVariablesWithBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1745
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1745")
    public int numInputs() {
        int numInputs_value = inputs().size();
        return numInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1755
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1755")
    public int numRealInputs() {
        int numRealInputs_value = realInputs().size();
        return numRealInputs_value;
    }
    /** @apilevel internal */
    private void realInputs_reset() {
        realInputs_computed = false;
        
        realInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean realInputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> realInputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1756
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1756")
    public Collection<FVariable> realInputs() {
        ASTState state = state();
        if (realInputs_computed) {
            return realInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        realInputs_value = filterCollection(inputs(), REAL_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        realInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return realInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1759
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1759")
    public int numIntegerInputs() {
        int numIntegerInputs_value = integerInputs().size();
        return numIntegerInputs_value;
    }
    /** @apilevel internal */
    private void integerInputs_reset() {
        integerInputs_computed = false;
        
        integerInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean integerInputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> integerInputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1760
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1760")
    public Collection<FVariable> integerInputs() {
        ASTState state = state();
        if (integerInputs_computed) {
            return integerInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        integerInputs_value = filterCollection(inputs(), INTEGER_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        integerInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return integerInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1763
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1763")
    public int numEnumInputs() {
        int numEnumInputs_value = enumInputs().size();
        return numEnumInputs_value;
    }
    /** @apilevel internal */
    private void enumInputs_reset() {
        enumInputs_computed = false;
        
        enumInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean enumInputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> enumInputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1764
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1764")
    public Collection<FVariable> enumInputs() {
        ASTState state = state();
        if (enumInputs_computed) {
            return enumInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        enumInputs_value = filterCollection(inputs(), ENUM_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        enumInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return enumInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1767
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1767")
    public int numBooleanInputs() {
        int numBooleanInputs_value = booleanInputs().size();
        return numBooleanInputs_value;
    }
    /** @apilevel internal */
    private void booleanInputs_reset() {
        booleanInputs_computed = false;
        
        booleanInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean booleanInputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> booleanInputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1768
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1768")
    public Collection<FVariable> booleanInputs() {
        ASTState state = state();
        if (booleanInputs_computed) {
            return booleanInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        booleanInputs_value = filterCollection(inputs(), BOOLEAN_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        booleanInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return booleanInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1771
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1771")
    public int numStringInputs() {
        int numStringInputs_value = stringInputs().size();
        return numStringInputs_value;
    }
    /** @apilevel internal */
    private void stringInputs_reset() {
        stringInputs_computed = false;
        
        stringInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean stringInputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> stringInputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1772
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1772")
    public Collection<FVariable> stringInputs() {
        ASTState state = state();
        if (stringInputs_computed) {
            return stringInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stringInputs_value = filterCollection(inputs(), STRING_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stringInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stringInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1775
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1775")
    public int numOutputs() {
        int numOutputs_value = outputs().size();
        return numOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1782
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1782")
    public int numRealOutputs() {
        int numRealOutputs_value = realOutputs().size();
        return numRealOutputs_value;
    }
    /** @apilevel internal */
    private void realOutputs_reset() {
        realOutputs_computed = false;
        
        realOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean realOutputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> realOutputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1783
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1783")
    public Collection<FVariable> realOutputs() {
        ASTState state = state();
        if (realOutputs_computed) {
            return realOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        realOutputs_value = filterCollection(outputs(), REAL_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        realOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return realOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1786
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1786")
    public int numIntegerOutputs() {
        int numIntegerOutputs_value = integerOutputs().size();
        return numIntegerOutputs_value;
    }
    /** @apilevel internal */
    private void integerOutputs_reset() {
        integerOutputs_computed = false;
        
        integerOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean integerOutputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> integerOutputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1787
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1787")
    public Collection<FVariable> integerOutputs() {
        ASTState state = state();
        if (integerOutputs_computed) {
            return integerOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        integerOutputs_value = filterCollection(outputs(), INTEGER_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        integerOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return integerOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1790
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1790")
    public int numEnumOutputs() {
        int numEnumOutputs_value = enumOutputs().size();
        return numEnumOutputs_value;
    }
    /** @apilevel internal */
    private void enumOutputs_reset() {
        enumOutputs_computed = false;
        
        enumOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean enumOutputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> enumOutputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1791
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1791")
    public Collection<FVariable> enumOutputs() {
        ASTState state = state();
        if (enumOutputs_computed) {
            return enumOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        enumOutputs_value = filterCollection(outputs(), ENUM_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        enumOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return enumOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1794
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1794")
    public int numBooleanOutputs() {
        int numBooleanOutputs_value = booleanOutputs().size();
        return numBooleanOutputs_value;
    }
    /** @apilevel internal */
    private void booleanOutputs_reset() {
        booleanOutputs_computed = false;
        
        booleanOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean booleanOutputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> booleanOutputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1795
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1795")
    public Collection<FVariable> booleanOutputs() {
        ASTState state = state();
        if (booleanOutputs_computed) {
            return booleanOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        booleanOutputs_value = filterCollection(outputs(), BOOLEAN_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        booleanOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return booleanOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1798
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1798")
    public int numStringOutputs() {
        int numStringOutputs_value = stringOutputs().size();
        return numStringOutputs_value;
    }
    /** @apilevel internal */
    private void stringOutputs_reset() {
        stringOutputs_computed = false;
        
        stringOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean stringOutputs_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> stringOutputs_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1799
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1799")
    public Collection<FVariable> stringOutputs() {
        ASTState state = state();
        if (stringOutputs_computed) {
            return stringOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stringOutputs_value = filterCollection(outputs(), STRING_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stringOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stringOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1802
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1802")
    public int numScalarEquations() {
        {
               int res = 0;
               for (FAbstractEquation e : equations())
                       res += e.numScalarEquations();
                for (FVariable fv : getFVariables())
                    if (!fv.variability().parameterOrLess() && fv.hasBindingExp())
                        res += fv.getBindingExp().type().numScalarElements();
               return res;
            }
    }
    /** @apilevel internal */
    private void numScalarEquationsAtInitialization_reset() {
        numScalarEquationsAtInitialization_computed = false;
    }
    /** @apilevel internal */
    protected boolean numScalarEquationsAtInitialization_computed = false;

    /** @apilevel internal */
    protected int numScalarEquationsAtInitialization_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1813
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1813")
    public int numScalarEquationsAtInitialization() {
        ASTState state = state();
        if (numScalarEquationsAtInitialization_computed) {
            return numScalarEquationsAtInitialization_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        numScalarEquationsAtInitialization_value = numScalarEquationsAtInitialization_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        numScalarEquationsAtInitialization_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return numScalarEquationsAtInitialization_value;
    }
    /** @apilevel internal */
    private int numScalarEquationsAtInitialization_compute() {
            int res = 0;
            for (FAbstractEquation e : equations())
                res += e.numScalarEquations();
            return res;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1819
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1819")
    public int numEquations() {
        int numEquations_value = equations().size();
        return numEquations_value;
    }
    /** @apilevel internal */
    private void equations_reset() {
        equations_computed = false;
        
        equations_value = null;
    }
    /** @apilevel internal */
    protected boolean equations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAbstractEquation> equations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1820
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1820")
    public ArrayList<FAbstractEquation> equations() {
        ASTState state = state();
        if (equations_computed) {
            return equations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        equations_value = equations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        equations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return equations_value;
    }
    /** @apilevel internal */
    private ArrayList<FAbstractEquation> equations_compute() {
            ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : getFAbstractEquations()) {
                if (!e.isIgnored()) {
                    l.add(e);
                }
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1830
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1830")
    public ArrayList<FAbstractEquation> allEquations() {
        {
                ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
                l.addAll(equations());
                l.addAll(initialEquations());
                l.addAll(getParameterEquations().toArrayList());
                return l;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1843
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1843")
    public int numContinuousEquations() {
        int numContinuousEquations_value = continuousEquations().size();
        return numContinuousEquations_value;
    }
    /** @apilevel internal */
    private void continuousEquations_reset() {
        continuousEquations_computed = false;
        
        continuousEquations_value = null;
    }
    /** @apilevel internal */
    protected boolean continuousEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAbstractEquation> continuousEquations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1844
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1844")
    public ArrayList<FAbstractEquation> continuousEquations() {
        ASTState state = state();
        if (continuousEquations_computed) {
            return continuousEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        continuousEquations_value = continuousEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        continuousEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return continuousEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FAbstractEquation> continuousEquations_compute() {
            ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : getFAbstractEquations()) {
                if (!e.isIgnored() && e.isContinuous()) {
                    l.add(e);
                }
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1854
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1854")
    public int numContinuousNonMetaEquations() {
        int numContinuousNonMetaEquations_value = continuousNonMetaEquations().size();
        return numContinuousNonMetaEquations_value;
    }
    /** @apilevel internal */
    private void continuousNonMetaEquations_reset() {
        continuousNonMetaEquations_computed = false;
        
        continuousNonMetaEquations_value = null;
    }
    /** @apilevel internal */
    protected boolean continuousNonMetaEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAbstractEquation> continuousNonMetaEquations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1855
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1855")
    public ArrayList<FAbstractEquation> continuousNonMetaEquations() {
        ASTState state = state();
        if (continuousNonMetaEquations_computed) {
            return continuousNonMetaEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        continuousNonMetaEquations_value = continuousNonMetaEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        continuousNonMetaEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return continuousNonMetaEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FAbstractEquation> continuousNonMetaEquations_compute() {
            ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : continuousEquations()) {
                if (!e.isMetaEquation()) {
                    l.add(e);
                }
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1865
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1865")
    public int numScalarVariables() {
        {
                int res = 0;
                for (FVariable fv : getFVariables())
                    if (!fv.variability().parameterOrLess())
                        res += fv.type().numScalarElements();
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1973
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1973")
    public int numSwitches() {
        int numSwitches_value = numStateSwitches() + numTimeSwitches();
        return numSwitches_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1974
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1974")
    public int numStateSwitches() {
        int numStateSwitches_value = relExpsWithStateEvent().size() + numSpatialDistSwitches() + numDelaySwitches();
        return numStateSwitches_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1975
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1975")
    public int numTimeSwitches() {
        int numTimeSwitches_value = relExpsWithTimeEvent().size();
        return numTimeSwitches_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1977
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1977")
    public int numEventIndicators() {
        int numEventIndicators_value = numStateSwitches();
        return numEventIndicators_value;
    }
    /** @apilevel internal */
    private void switchExps_reset() {
        switchExps_computed = false;
        
        switchExps_value = null;
    }
    /** @apilevel internal */
    protected boolean switchExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> switchExps_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1979
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1979")
    public ArrayList<FExp> switchExps() {
        ASTState state = state();
        if (switchExps_computed) {
            return switchExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        switchExps_value = switchExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        switchExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return switchExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> switchExps_compute() {
            ArrayList<FExp> res = new ArrayList<FExp>();
            res.addAll(stateEventExps());
            res.addAll(relExpsWithTimeEvent());
            return res;
        }
    /** @apilevel internal */
    private void stateEventExps_reset() {
        stateEventExps_computed = false;
        
        stateEventExps_value = null;
    }
    /** @apilevel internal */
    protected boolean stateEventExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> stateEventExps_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1991
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1991")
    public ArrayList<FExp> stateEventExps() {
        ASTState state = state();
        if (stateEventExps_computed) {
            return stateEventExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stateEventExps_value = stateEventExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stateEventExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stateEventExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> stateEventExps_compute() {
            ArrayList<FExp> res = new ArrayList<FExp>();
            res.addAll(relExpsWithStateEvent());
            res.addAll(spatialDistExpsWithStateEvent());
            res.addAll(delayExpsWithStateEvent());
            return res;
        }
    /** @apilevel internal */
    private void timeEventExps_reset() {
        timeEventExps_computed = false;
        
        timeEventExps_value = null;
    }
    /** @apilevel internal */
    protected boolean timeEventExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> timeEventExps_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2003
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2003")
    public ArrayList<FExp> timeEventExps() {
        ASTState state = state();
        if (timeEventExps_computed) {
            return timeEventExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        timeEventExps_value = timeEventExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        timeEventExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return timeEventExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> timeEventExps_compute() {
            ArrayList<FExp> res = new ArrayList<FExp>();
            res.addAll(sampleExpsWithTimeEvent());
            res.addAll(relExpsWithTimeEvent());
            return res;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2015
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2015")
    public int numSpatialDistSwitches() {
        int numSpatialDistSwitches_value = spatialDistExpsWithStateEvent().size();
        return numSpatialDistSwitches_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2021
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2021")
    public int numDelaySwitches() {
        int numDelaySwitches_value = 2*delayExpsWithStateEvent().size();
        return numDelaySwitches_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2031
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2031")
    public int numGuardExpInEquations() {
        int numGuardExpInEquations_value = guardExpInEquations().size();
        return numGuardExpInEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2032
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2032")
    public int numGuardExpInInitialEquations() {
        int numGuardExpInInitialEquations_value = guardExpInInitialEquations().size();
        return numGuardExpInInitialEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2135
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2135")
    public ArrayList<FRelExp> relExpsWithStateEvent() {
        {
                ArrayList<FRelExp> res = new ArrayList<FRelExp>();
                for (FRelExp exp : relExpsWithEvent()) {
                    if (!exp.isTimeEventGenerating()) {
                        res.add(exp);
                    }
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2145")
    public ArrayList<FRelExp> relExpsWithTimeEvent() {
        {
                ArrayList<FRelExp> res = new ArrayList<FRelExp>();
                for (FRelExp exp : relExpsWithEvent()) {
                    if (exp.isTimeEventGenerating()) {
                        res.add(exp);
                    }
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2177
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2177")
    public int numInitialEquations() {
        int numInitialEquations_value = initialEquations().size();
        return numInitialEquations_value;
    }
    /** @apilevel internal */
    private void numInitialScalarEquations_reset() {
        numInitialScalarEquations_computed = false;
    }
    /** @apilevel internal */
    protected boolean numInitialScalarEquations_computed = false;

    /** @apilevel internal */
    protected int numInitialScalarEquations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2178")
    public int numInitialScalarEquations() {
        ASTState state = state();
        if (numInitialScalarEquations_computed) {
            return numInitialScalarEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        numInitialScalarEquations_value = numInitialScalarEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        numInitialScalarEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return numInitialScalarEquations_value;
    }
    /** @apilevel internal */
    private int numInitialScalarEquations_compute() {
            int res = 0;
            for (FAbstractEquation e : initialEquations())
                res += e.numScalarEquations();
            return res;
        }
    /** @apilevel internal */
    private void initialEquations_reset() {
        initialEquations_computed = false;
        
        initialEquations_value = null;
    }
    /** @apilevel internal */
    protected boolean initialEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAbstractEquation> initialEquations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2184")
    public ArrayList<FAbstractEquation> initialEquations() {
        ASTState state = state();
        if (initialEquations_computed) {
            return initialEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        initialEquations_value = initialEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        initialEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return initialEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FAbstractEquation> initialEquations_compute() {
            ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : getFInitialEquations()) {
                l.add(e);
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2192")
    public int numInitialGuessEquations() {
        {
                int n_eq = 0;
                for (FRealVariable fv : realVariables()) {
                    if (!fv.isFixed()) {
                        n_eq++;
                    }
                }
                return n_eq;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2202
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2202")
    public int numInitialEventIndicators() {
        int numInitialEventIndicators_value = numRelExpInInitialEquations();
        return numInitialEventIndicators_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2204")
    public ArrayList<FRelExp> eventExpInInitialEquations() {
        ArrayList<FRelExp> eventExpInInitialEquations_value = relExpInInitialEquations();
        return eventExpInInitialEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2206")
    public int numRelExpInInitialEquations() {
        int numRelExpInInitialEquations_value = relExpInInitialEquations().size();
        return numRelExpInInitialEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2714
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2714")
    public GUIDManager guidManager() {
        GUIDManager guidManager_value = root().getUtilInterface().getGuidManager();
        return guidManager_value;
    }
    /**
     * @attribute syn
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3743
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatDiagnostics", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3743")
    public String diagnostics() {
        {
                StringBuilder str = new StringBuilder();
                str.append("Diagnostics for flattened class " + name() + "\n");
        
                str.append(modelDiagnostics());
                
                str.append("\n");
                
                str.append(variableDiagnostics());
                
                str.append("\n");  
        
                str.append(aliasDiagnostics());
                
                str.append("\n");  
                
                str.append(incidence());
        
                str.append("\n");  
                
                str.append(dependencyDiagnostics());
        
                str.append("\n");
                
        //      str.append(dersAndDiffs());
                
                str.append("\n");  
                
                str.append(connectionSetDiagnostics());
                
                return str.toString();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4167
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatDiagnostics", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4167")
    public String attributeLevels() {
        {
                StringBuilder str = new StringBuilder();
                str.append("Variables:\n");
                for (FVariable v : getFVariables())
                    v.attributeLevels(str);
                for (FVariable v : getAliasVariables())
                    v.attributeLevels(str);
                if (getNumFDerivedType() > 0) {
                    str.append("\nTypes:\n");
                    for (FDerivedType t : getFDerivedTypes())
                        t.attributeLevels(str);
                }
                return str.toString();
            }
    }
    /**
     * Gives the arguments to pass to gcc required by external functions.
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4279")
    public String externalCompilerArgs() {
        {
                StringBuilder buf = new StringBuilder();
                for (String lib : externalLibraries()) {
                    buf.append(" -l");
                    buf.append(lib);
                }
                for (String dir : externalLibraryDirectories()) {
                    buf.append(" -L");
                    buf.append(dir);
                }
                for (String dir : externalIncludeDirectories()) {
                    buf.append(" -I");
                    buf.append(dir);
                }
                return buf.toString();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4296
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4296")
    public String externalLibArgs() {
        {
                StringBuilder buf = new StringBuilder();
                for (String lib : externalLibraries()) {
                    buf.append(" -l");
                    buf.append(lib);
                }
                for (String dir : externalLibraryDirectories()) {
                    buf.append(" -L");
                    buf.append(dir);
                }
                return buf.toString();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4309
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4309")
    public String externalIncludeArgs() {
        {
                StringBuilder buf = new StringBuilder();
                for (String dir : externalIncludeDirectories()) {
                    buf.append(" -I");
                    buf.append(dir);
                }
                return buf.toString();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4323
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4323")
    public HashSet<String> externalLibraries() {
        {
                HashSet<String> res = new LinkedHashSet<String>();
                for (FExternalStmt ext : myExternals())
                    if (ext.library() != null)
                        for (String lib : ext.library())
                            res.add(lib);
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4332
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4332")
    public HashSet<String> externalIncludes() {
        {
                HashSet<String> res = new LinkedHashSet<String>();
                for (FExternalStmt ext : myExternals())
                    if (ext.include() != null)
                        res.add(ext.include());
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4340
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4340")
    public HashSet<String> externalLibraryDirectories() {
        {
                HashSet<String> res = new LinkedHashSet<String>();
                for (FExternalStmt ext : myExternals())
                    if (ext.libraryDirectory() != null)
                        res.add(ext.libraryDirectory());
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4348")
    public HashSet<String> externalIncludeDirectories() {
        {
                HashSet<String> res = new LinkedHashSet<String>();
                for (FExternalStmt ext : myExternals())
                    if (ext.includeDirectory() != null)
                        res.add(ext.includeDirectory());
                return res;
            }
    }
    /** @apilevel internal */
    private void derivedTypeMap_reset() {
        derivedTypeMap_computed = false;
        
        derivedTypeMap_value = null;
    }
    /** @apilevel internal */
    protected boolean derivedTypeMap_computed = false;

    /** @apilevel internal */
    protected Map<String,FDerivedType> derivedTypeMap_value;

    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:41
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:41")
    public Map<String,FDerivedType> derivedTypeMap() {
        ASTState state = state();
        if (derivedTypeMap_computed) {
            return derivedTypeMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        derivedTypeMap_value = derivedTypeMap_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        derivedTypeMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return derivedTypeMap_value;
    }
    /** @apilevel internal */
    private Map<String,FDerivedType> derivedTypeMap_compute() {
            Map<String,FDerivedType> m = new HashMap<String,FDerivedType>();
            for (FDerivedType t : getFDerivedTypes()) {
                m.put(t.getName(), t);
            }
            return m;
        }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:65")
    public FAbstractVariable lookupFV(String name) {
        FAbstractVariable lookupFV_String_value = nullUnknown(variablesMap().lookup(name));
        return lookupFV_String_value;
    }
    /** @apilevel internal */
    private void variablesMap_reset() {
        variablesMap_computed = false;
        
        variablesMap_value = null;
    }
    /** @apilevel internal */
    protected boolean variablesMap_computed = false;

    /** @apilevel internal */
    protected FlatVariableMap variablesMap_value;

    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:102")
    public FlatVariableMap variablesMap() {
        ASTState state = state();
        if (variablesMap_computed) {
            return variablesMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        variablesMap_value = new FlatVariableMap(getFVariables(), getAliasVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        variablesMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return variablesMap_value;
    }
    /** @apilevel internal */
    private void globalVariablesMap_reset() {
        globalVariablesMap_computed = false;
        
        globalVariablesMap_value = null;
    }
    /** @apilevel internal */
    protected boolean globalVariablesMap_computed = false;

    /** @apilevel internal */
    protected FlatVariableMap globalVariablesMap_value;

    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:103
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:103")
    public FlatVariableMap globalVariablesMap() {
        ASTState state = state();
        if (globalVariablesMap_computed) {
            return globalVariablesMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        globalVariablesMap_value = new FlatVariableMap(getFGlobalVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        globalVariablesMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return globalVariablesMap_value;
    }
    /** @apilevel internal */
    private void parameterEquationsMap_reset() {
        parameterEquationsMap_computed = false;
        
        parameterEquationsMap_value = null;
    }
    /** @apilevel internal */
    protected boolean parameterEquationsMap_computed = false;

    /** @apilevel internal */
    protected Map<FAbstractVariable,FAbstractEquation> parameterEquationsMap_value;

    /**
     * @attribute syn
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:194
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:194")
    public Map<FAbstractVariable,FAbstractEquation> parameterEquationsMap() {
        ASTState state = state();
        if (parameterEquationsMap_computed) {
            return parameterEquationsMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        parameterEquationsMap_value = parameterEquationsMap_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        parameterEquationsMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return parameterEquationsMap_value;
    }
    /** @apilevel internal */
    private Map<FAbstractVariable,FAbstractEquation> parameterEquationsMap_compute() {
    		Map<FAbstractVariable,FAbstractEquation> map = new HashMap<FAbstractVariable,FAbstractEquation>();
    		for (FAbstractEquation equ : getParameterEquations())
    			equ.addToParameterEquationsMap(map);
    		return map;
    	}
    /**
     * @attribute syn
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:272")
    public FFunctionDecl lookupFunc(String name) {
        {
        		for (FFunctionDecl f : getFFunctionDecls())
        			if (f.name().equals(name))
        				return f;
        		return null;
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:310")
    public FRecordDecl lookupFRec(String name) {
        {
        		for (FRecordDecl r : getFRecordDecls())
        			if (r.name().equals(name))
        				return r;
        		return null;
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatEnumBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:340
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:340")
    public FEnumDecl lookupFEnum(String name) {
        {
        		for (FEnumDecl r : getFEnumDecls()) {
        			if (r.name().equals(name))
        				return r;
        		}
        		return null;
        	}
    }
    /** @apilevel internal */
    private void getUnknownFVariable_reset() {
        getUnknownFVariable_computed = false;
        
        getUnknownFVariable_value = null;
    }
    /** @apilevel internal */
    protected boolean getUnknownFVariable_computed = false;

    /** @apilevel internal */
    protected UnknownFVariable getUnknownFVariable_value;

    /**
     * @attribute syn nta
     * @aspect UnknownFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="UnknownFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:387")
    public UnknownFVariable getUnknownFVariable() {
        ASTState state = state();
        if (getUnknownFVariable_computed) {
            return (UnknownFVariable) getChild(getUnknownFVariableChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getUnknownFVariable_value = new UnknownFVariable();
        setChild(getUnknownFVariable_value, getUnknownFVariableChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getUnknownFVariable_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        UnknownFVariable node = (UnknownFVariable) this.getChild(getUnknownFVariableChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:329
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:329")
    public String name() {
        String name_value = getFAccessNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:405")
    public String nameUnderscore() {
        String nameUnderscore_value = getFAccess().nameUnderscore();
        return nameUnderscore_value;
    }
    /**
     * Check if this FClass contains any active annotation attributes.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1967
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1967")
    public boolean containsActiveAnnotations() {
        {
                if (getNumFAttribute() == 0)
                    return false;
                for (AttributeContributer contributer : attributeContributers())
                    if (contributer.containsActiveAttributes(this))
                        return true;
                return false;
            }
    }
    /** @apilevel internal */
    private void getFDynamicResolverOpt_reset() {
        getFDynamicResolverOpt_computed = false;
        
        getFDynamicResolverOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getFDynamicResolverOpt_computed = false;

    /** @apilevel internal */
    protected Opt getFDynamicResolverOpt_value;

    /**
     * @attribute syn
     * @aspect JastAddHacks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2052
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="JastAddHacks", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2052")
    public Opt getFDynamicResolverOpt() {
        ASTState state = state();
        if (getFDynamicResolverOpt_computed) {
            return getFDynamicResolverOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFDynamicResolverOpt_value = new DynamicOpt();
        getFDynamicResolverOpt_value.setParent(this);
        getFDynamicResolverOpt_value.is$Final = true;
        if (true) {
        getFDynamicResolverOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getFDynamicResolverOpt_value;
    }
    /** @apilevel internal */
    private void stateSelectType_reset() {
        stateSelectType_computed = false;
        
        stateSelectType_value = null;
    }
    /** @apilevel internal */
    protected boolean stateSelectType_computed = false;

    /** @apilevel internal */
    protected FType stateSelectType_value;

    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:188")
    public FType stateSelectType() {
        ASTState state = state();
        if (stateSelectType_computed) {
            return stateSelectType_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        stateSelectType_value = stateSelectType_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        stateSelectType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return stateSelectType_value;
    }
    /** @apilevel internal */
    private FType stateSelectType_compute() {
            FEnumType type = new FEnumType(Size.SCALAR, "StateSelect", new List());
            for (String el : new String[] { "never", "avoid", "default", "prefer", "always" }) 
                type.addFEnumLiteralType(new FEnumLiteralType(Size.SCALAR, el));
            return type;
        }
    /** @apilevel internal */
    private void collectReinits_reset() {
        collectReinits_computed = false;
        
        collectReinits_value = null;
    }
    /** @apilevel internal */
    protected boolean collectReinits_computed = false;

    /** @apilevel internal */
    protected Map<FAbstractVariable,Set<FReinit>> collectReinits_value;

    /**
     * @attribute syn
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1730
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ScalarizationErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1730")
    public Map<FAbstractVariable,Set<FReinit>> collectReinits() {
        ASTState state = state();
        if (collectReinits_computed) {
            return collectReinits_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        collectReinits_value = collectReinits_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        collectReinits_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return collectReinits_value;
    }
    /** @apilevel internal */
    private Map<FAbstractVariable,Set<FReinit>> collectReinits_compute() {
            Map<FAbstractVariable,Set<FReinit>> reinitMap = new HashMap<FAbstractVariable,Set<FReinit>>();
            for (FAbstractEquation e : getFAbstractEquations())
                e.collectReinits(reinitMap);
            return reinitMap;
        }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = new FAttributeListAnnotationNode(this, instContext);
        return annotation_InstContext_value;
    }
    /** @apilevel internal */
    private void resourceLoader_reset() {
        resourceLoader_computed = false;
        
        resourceLoader_value = null;
    }
    /** @apilevel internal */
    protected boolean resourceLoader_computed = false;

    /** @apilevel internal */
    protected ResourceLoader resourceLoader_value;

    /**
     * @attribute syn
     * @aspect LoadResource
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\LoadResource.jrag:32
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LoadResource", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\LoadResource.jrag:32")
    public ResourceLoader resourceLoader() {
        ASTState state = state();
        if (resourceLoader_computed) {
            return resourceLoader_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        resourceLoader_value = resourceLoader_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        resourceLoader_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return resourceLoader_value;
    }
    /** @apilevel internal */
    private ResourceLoader resourceLoader_compute() {
            LinkedHashSet<String> s = new LinkedHashSet<String>();
            collectResourcesToLoad(s);
            return new ResourceLoader(new ArrayList<>(s));
        }
    /**
     * @attribute syn
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:93
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RuntimeOptions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:93")
    public int numRuntimeOptionParameters() {
        int numRuntimeOptionParameters_value = runtimeOptionParameters().size();
        return numRuntimeOptionParameters_value;
    }
    /** @apilevel internal */
    private void runtimeOptionParameters_reset() {
        runtimeOptionParameters_computed = false;
        
        runtimeOptionParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean runtimeOptionParameters_computed = false;

    /** @apilevel internal */
    protected SortedSet<FVariable> runtimeOptionParameters_value;

    /**
     * @attribute syn
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:94
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RuntimeOptions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:94")
    public SortedSet<FVariable> runtimeOptionParameters() {
        ASTState state = state();
        if (runtimeOptionParameters_computed) {
            return runtimeOptionParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        runtimeOptionParameters_value = runtimeOptionParameters_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        runtimeOptionParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return runtimeOptionParameters_value;
    }
    /** @apilevel internal */
    private SortedSet<FVariable> runtimeOptionParameters_compute() {
            SortedSet<FVariable> res = new TreeSet<FVariable>(new VariableNameComparator());
            for (FVariable fv : independentParameters()) {
                if (fv.isRuntimeOption()) {
                    res.add(fv);
                }
            }
            return res;
        }
    /** @apilevel internal */
    private void myStepUtil_reset() {
        myStepUtil_computed = false;
        
        myStepUtil_value = null;
    }
    /** @apilevel internal */
    protected boolean myStepUtil_computed = false;

    /** @apilevel internal */
    protected StepUtil myStepUtil_value;

    /**
     * @attribute syn
     * @aspect StepLogging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:52
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="StepLogging", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\StepLogging.jrag:52")
    public StepUtil myStepUtil() {
        ASTState state = state();
        if (myStepUtil_computed) {
            return myStepUtil_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myStepUtil_value = myStepUtil_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myStepUtil_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myStepUtil_value;
    }
    /** @apilevel internal */
    private StepUtil myStepUtil_compute() {
            final FClass self = this;
            return new StepUtil() {
                @Override
                public OptionRegistry getOptionRegistry() {
                    return self.myOptions();
                }
                @Override
                public StepLogger getStepLogger() {
                    return self;
                }
            };
        }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:365
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:365")
    public HashMap<FVariable,AbstractEquationBlock> getDAEFVariableEquationBlockMap() {
        {
                transformCanonical();
                return daeFVariableEquationBlockMap;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:373
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:373")
    public HashMap<FAbstractEquation,AbstractEquationBlock> getDAEFEquationEquationBlockMap() {
        {
                transformCanonical();
                return daeEquationEquationBlockMap;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:382
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:382")
    public HashMap<FVariable,AbstractEquationBlock> getDAEInitFVariableEquationBlockMap() {
        {
                transformCanonical();
                return daeInitFVariableEquationBlockMap;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:388
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:388")
    public HashMap<FAbstractEquation,AbstractEquationBlock> getDAEInitEquationEquationBlockMap() {
        {
                transformCanonical();
                return daeInitEquationEquationBlockMap;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:394
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:394")
    public ArrayList<FAbstractEquation> getDAEUnmatchedEquations() {
        {
                transformCanonical();
                return daeUnmatchedEquations;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:400
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:400")
    public ArrayList<FVariable> getDAEUnmatchedVariables() {
        {
                transformCanonical();
                return daeUnmatchedVariables;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:406")
    public ArrayList<FAbstractEquation> getDAEInitUnmatchedEquations() {
        {
                transformCanonical();
                return daeInitUnmatchedEquations;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:412")
    public ArrayList<FVariable> getDAEInitUnmatchedVariables() {
        {
                transformCanonical();
                return daeInitUnmatchedVariables;
            }
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:475
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:475")
    public boolean onlyInitBLT() {
        boolean onlyInitBLT_value = getDAEBLT() == BLT.EMPTY_BLT && getDAEInitBLT() != BLT.EMPTY_BLT;
        return onlyInitBLT_value;
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:477
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:477")
    public boolean shouldPerformMatchingsAndBLT() {
        boolean shouldPerformMatchingsAndBLT_value = true;
        return shouldPerformMatchingsAndBLT_value;
    }
    /** @apilevel internal */
    private void continuousVariablesUsedInPreInInitial_reset() {
        continuousVariablesUsedInPreInInitial_computed = false;
        
        continuousVariablesUsedInPreInInitial_value = null;
    }
    /** @apilevel internal */
    protected boolean continuousVariablesUsedInPreInInitial_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> continuousVariablesUsedInPreInInitial_value;

    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1105
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1105")
    public Collection<FVariable> continuousVariablesUsedInPreInInitial() {
        ASTState state = state();
        if (continuousVariablesUsedInPreInInitial_computed) {
            return continuousVariablesUsedInPreInInitial_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        continuousVariablesUsedInPreInInitial_value = continuousVariablesUsedInPreInInitial_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        continuousVariablesUsedInPreInInitial_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return continuousVariablesUsedInPreInInitial_value;
    }
    /** @apilevel internal */
    private Collection<FVariable> continuousVariablesUsedInPreInInitial_compute() {
            Set<FVariable> res = new LinkedHashSet<FVariable>();
            getFInitialEquations().gatherContinuousVariablesUsedInPre(res);
            return new ArrayList<FVariable>(res);
        }
    /**
     * The number of DAE equations corresponds to the equivalent scalar number
     * of equations.
     * @attribute syn
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1238
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonicalErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1238")
    public int numDAEEquations() {
        int numDAEEquations_value = numScalarEquations();
        return numDAEEquations_value;
    }
    /**
     * The number of equations in the DAE initialization system originating 
     * from the DAE should be the same as the equivalent scalar number of
     * equations. The equations may differ, however, due to inactive when
     * clauses.
     * @attribute syn
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1246
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonicalErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1246")
    public int numDAEEquationsAtInitialization() {
        int numDAEEquationsAtInitialization_value = numScalarEquationsAtInitialization();
        return numDAEEquationsAtInitialization_value;
    }
    /**
     * The number of unknown variables in the DAE corresponds to the number
     * of real algebraic variables plus the number of derivative variables
     * plus the number of discrete variables.
     * @attribute syn
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonicalErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1254")
    public int numDAEVariables() {
        int numDAEVariables_value = numNormalAlgebraicContinousRealVariables() + 
        		numDerivativeVariables() + numDiscreteVariables();
        return numDAEVariables_value;
    }
    /**
     * The number of equations in the DAE initialization system is the 
     * number of scalar DAE equations plus the number of scalar initial
     * equations.
     * @attribute syn
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonicalErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1271")
    public int numDAEInitEquations() {
        int numDAEInitEquations_value = numDAEEquationsAtInitialization() + 
                numInitialScalarEquations() - numIgnoredPrePropagationEquations;
        return numDAEInitEquations_value;
    }
    /**
     * The number of unknowns in the DAE initialization system is the 
     * number of unknowns in the DAE system plus the number of differentiated
     * variables plus the number of (pre) discrete variables.
     * @attribute syn
     * @aspect TransformCanonicalErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonicalErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1279")
    public int numDAEInitVariables() {
        int numDAEInitVariables_value = numDAEVariables() +
                       numDifferentiatedRealVariables() + numDiscretePreVariables() +
                       numInitialParameters() + numDynamicStates() - numDynamicAlgebraicVariables();
        return numDAEInitVariables_value;
    }
    /**
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:30")
    public boolean indexReductionErrorsAsWarnings() {
        boolean indexReductionErrorsAsWarnings_value = false;
        return indexReductionErrorsAsWarnings_value;
    }
    /** @apilevel internal */
    private void xmlVariables_reset() {
        xmlVariables_computed = false;
        
        xmlVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean xmlVariables_computed = false;

    /** @apilevel internal */
    protected Collection<FVariable> xmlVariables_value;

    /**
     * Contains all variables that are supposed to be generated in the XML.
     * Also sorted correctly.
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:126
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:126")
    public Collection<FVariable> xmlVariables() {
        ASTState state = state();
        if (xmlVariables_computed) {
            return xmlVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        xmlVariables_value = xmlVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        xmlVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return xmlVariables_value;
    }
    /** @apilevel internal */
    private Collection<FVariable> xmlVariables_compute() {
            // get and sort all FVariables
            // TODO: Not very nice!
            ArrayList<FVariable> variables = new ArrayList<FVariable>(allVariables());
            VariableNameComparator comp = new VariableNameComparator();
            Iterator<FVariable> it = variables.iterator();
            while (it.hasNext()) {
                if (!it.next().generateXMLVariable()) {
                    it.remove();
                }
            }
            Collections.sort(variables, comp);
            return variables;
        }
    /** @apilevel internal */
    private void xmlVariableIndexMap_reset() {
        xmlVariableIndexMap_computed = false;
        
        xmlVariableIndexMap_value = null;
    }
    /** @apilevel internal */
    protected boolean xmlVariableIndexMap_computed = false;

    /** @apilevel internal */
    protected Map<String, Integer> xmlVariableIndexMap_value;

    /**
     * Used for finding the indices for scalar variable tags.
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:144
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:144")
    public Map<String, Integer> xmlVariableIndexMap() {
        ASTState state = state();
        if (xmlVariableIndexMap_computed) {
            return xmlVariableIndexMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        xmlVariableIndexMap_value = xmlVariableIndexMap_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        xmlVariableIndexMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return xmlVariableIndexMap_value;
    }
    /** @apilevel internal */
    private Map<String, Integer> xmlVariableIndexMap_compute() {
            //Create map for the indices of the scalar variables.
            Map<String, Integer> res = new LinkedHashMap<String, Integer>();
            Enumerator enumerator = new Enumerator(1);
            for (FVariable var : xmlVariables()) {
                var.generateXMLVariableIndex(res, enumerator);
            }
            return res;
        }
    /**
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:154")
    public boolean supportDirDer() {
        boolean supportDirDer_value = false;
        return supportDirDer_value;
    }
    /** @apilevel internal */
    private void exportWrapperGroups_reset() {
        exportWrapperGroups_computed = false;
        
        exportWrapperGroups_value = null;
    }
    /** @apilevel internal */
    protected boolean exportWrapperGroups_computed = false;

    /** @apilevel internal */
    protected java.util.List<java.util.List<FFunctionDecl>> exportWrapperGroups_value;

    /**
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:195")
    public java.util.List<java.util.List<FFunctionDecl>> exportWrapperGroups() {
        ASTState state = state();
        if (exportWrapperGroups_computed) {
            return exportWrapperGroups_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        exportWrapperGroups_value = exportWrapperGroups_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        exportWrapperGroups_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return exportWrapperGroups_value;
    }
    /** @apilevel internal */
    private java.util.List<java.util.List<FFunctionDecl>> exportWrapperGroups_compute() {
            ListMap<String,FFunctionDecl> map = new LinkedHashListMap<String,FFunctionDecl>();
            for (FFunctionDecl f : getFFunctionDecls()) {
                if (f.hasExportWrapper_C()) {
                    map.add(f.signatureString(), f);
                }
            }
            
            java.util.List<java.util.List<FFunctionDecl>> res = new ArrayList<java.util.List<FFunctionDecl>>();
            for (java.util.List<FFunctionDecl> list : map.values()) {
                Collections.sort(list, FFunctionDecl.UNAME_COMPARATOR);
                res.add(list);
            }
            return res;
        }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1094
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1094")
    public String htmlPrintWrapTag() {
        String htmlPrintWrapTag_value = "div";
        return htmlPrintWrapTag_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095")
    public String htmlPrintWrapTagClass() {
        String htmlPrintWrapTagClass_value = "fclass";
        return htmlPrintWrapTagClass_value;
    }
    /** @apilevel internal */
    private void timeMX_reset() {
        timeMX_computed = false;
        
        timeMX_value = null;
    }
    /** @apilevel internal */
    protected boolean timeMX_computed = false;

    /** @apilevel internal */
    protected MX timeMX_value;

    /**
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:327
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:327")
    public MX timeMX() {
        ASTState state = state();
        if (timeMX_computed) {
            return timeMX_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        timeMX_value = ifcasadi.msym("time");
        if (isFinal && _boundaries == state().boundariesCrossed) {
        timeMX_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return timeMX_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     * @apilevel internal
     */
    public boolean Define_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIterExp
     */
    protected boolean canDefine_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906
     * @apilevel internal
     */
    public Size Define_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return s;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandSizeForIterExp
     */
    protected boolean canDefine_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1923
     * @apilevel internal
     */
    public int Define_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 0;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1923
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpDepth
     */
    protected boolean canDefine_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2797
     * @apilevel internal
     */
    public String Define_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                throw new UnsupportedOperationException("The getInstanceName() operator is not allowed in the flat tree.");
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2797
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcInstanceName
     */
    protected boolean canDefine_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3427
     * @apilevel internal
     */
    public boolean Define_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3427
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute duringFunctionEval
     */
    protected boolean canDefine_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1118
     * @apilevel internal
     */
    public int Define_valueReference(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1128
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return -1;
        }
        else if (_callerNode == getAliasVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1127
            int i = _callerNode.getIndexOfChild(_childNode);
            return getAliasVariable(i).aliasValueReference();
        }
        else if (_callerNode == getFVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1119
            int i = _callerNode.getIndexOfChild(_childNode);
            {
                    FVariable var = getFVariable(i);
                    ZOrdinaryCategory category = ZOrdinaryCategory.resolve(var);
                    if (category == null) {
                        return -1;
                    }
                    return category.type.mask(varRefMap().getBy(category).getIndexFor(var));
                }
        }
        else {
            return getParent().Define_valueReference(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1118
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute valueReference
     */
    protected boolean canDefine_valueReference(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     */
    public boolean Define_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inDeadIfBranch
     */
    protected boolean canDefine_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2258
     * @apilevel internal
     */
    public FClass Define_myFClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2258
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFClass
     */
    protected boolean canDefine_myFClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2414
     * @apilevel internal
     */
    public boolean Define_isParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getParameterEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2415
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_isParameterEquation(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2414
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isParameterEquation
     */
    protected boolean canDefine_isParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418
     * @apilevel internal
     */
    public boolean Define_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2419
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return false;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isNormalEquation
     */
    protected boolean canDefine_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2424
     * @apilevel internal
     */
    public List<FAbstractEquation> Define_myFAbstractEquationList(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getParameterEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2427
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getParameterEquations();
        }
        else if (_callerNode == getFInitialEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2426
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getFInitialEquations();
        }
        else if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2425
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getFAbstractEquations();
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return null;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2424
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFAbstractEquationList
     */
    protected boolean canDefine_myFAbstractEquationList(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     */
    public boolean Define_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecord
     */
    protected boolean canDefine_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306
     * @apilevel internal
     */
    public boolean Define_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionCallLeft
     */
    protected boolean canDefine_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     */
    public boolean Define_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallLeft
     */
    protected boolean canDefine_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3320
     * @apilevel internal
     */
    public boolean Define_inFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3320
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionCall
     */
    protected boolean canDefine_inFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345
     * @apilevel internal
     */
    public CommonVariableDecl Define_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCorrespondingInput
     */
    protected boolean canDefine_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:36
     * @apilevel internal
     */
    public FDerivedType Define_findFDerivedType(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return derivedTypeMap().get(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:36
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findFDerivedType
     */
    protected boolean canDefine_findFDerivedType(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     */
    public FAbstractVariable Define_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFV(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFV
     */
    protected boolean canDefine_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:155
     * @apilevel internal
     */
    public FAbstractVariable Define_lookupGlobalVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return globalVariablesMap().lookup(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:155
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupGlobalVariable
     */
    protected boolean canDefine_lookupGlobalVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     */
    public FAbstractEquation Define_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getAliasVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:187
            int i = _callerNode.getIndexOfChild(_childNode);
            return parameterEquationsMap().get(getAliasVariable(i));
        }
        else if (_callerNode == getFVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:185
            int i = _callerNode.getIndexOfChild(_childNode);
            return parameterEquationsMap().get(getFVariable(i));
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return null;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parameterEquation
     */
    protected boolean canDefine_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241
     * @apilevel internal
     */
    public boolean Define_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getParameterEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:242
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return false;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:241
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inParameterEquation
     */
    protected boolean canDefine_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     */
    public boolean Define_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAttributeValue
     */
    protected boolean canDefine_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:264
     * @apilevel internal
     */
    public FCallable Define_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFunc(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:264
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFCallable
     */
    protected boolean canDefine_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:307
     * @apilevel internal
     */
    public FRecordDecl Define_lookupFRec(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFRec(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:307
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFRec
     */
    protected boolean canDefine_lookupFRec(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:337
     * @apilevel internal
     */
    public FEnumDecl Define_lookupFEnum(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return lookupFEnum(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:337
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFEnum
     */
    protected boolean canDefine_lookupFEnum(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:447
     * @apilevel internal
     */
    public int Define_functionIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFFunctionDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:448
            int i = _callerNode.getIndexOfChild(_childNode);
            return i;
        }
        else {
            return getParent().Define_functionIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:447
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionIndex
     */
    protected boolean canDefine_functionIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460
     * @apilevel internal
     */
    public int Define_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getAliasVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:462
            int i = _callerNode.getIndexOfChild(_childNode);
            return getNumFVariable() + i;
        }
        else if (_callerNode == getFVariableListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:461
            int i = _callerNode.getIndexOfChild(_childNode);
            return i;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return -1;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findVariableIndex
     */
    protected boolean canDefine_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:468
     * @apilevel internal
     */
    public int Define_forIndexIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return nextForIndexIndex++;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:468
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute forIndexIndex
     */
    protected boolean canDefine_forIndexIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:474
     * @apilevel internal
     */
    public int Define_recordIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFRecordDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:475
            int i = _callerNode.getIndexOfChild(_childNode);
            return i;
        }
        else {
            return getParent().Define_recordIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:474
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute recordIndex
     */
    protected boolean canDefine_recordIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:477
     * @apilevel internal
     */
    public int Define_enumIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFEnumDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:478
            int i = _callerNode.getIndexOfChild(_childNode);
            return i;
        }
        else {
            return getParent().Define_enumIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:477
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enumIndex
     */
    protected boolean canDefine_enumIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     * @apilevel internal
     */
    public boolean Define_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAlgorithm
     */
    protected boolean canDefine_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallIsExp
     */
    protected boolean canDefine_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1532
     * @apilevel internal
     */
    public ArrayList<FFunctionCallLeft> Define_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new ArrayList<FFunctionCallLeft>();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myLefts
     */
    protected boolean canDefine_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     */
    public String Define_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return nextGeneratedVarName(gvt);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcGeneratedVarName
     */
    protected boolean canDefine_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1770
     * @apilevel internal
     */
    public boolean Define_inEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1773
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_inEquationSection(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1770
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inEquationSection
     */
    protected boolean canDefine_inEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1775
     * @apilevel internal
     */
    public boolean Define_inInitialEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFInitialEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1778
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_inInitialEquationSection(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1775
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInitialEquationSection
     */
    protected boolean canDefine_inInitialEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785
     * @apilevel internal
     */
    public boolean Define_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getParameterEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1790
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_inNoEventExp(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1785
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inNoEventExp
     */
    protected boolean canDefine_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhen
     */
    protected boolean canDefine_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1415
     * @apilevel internal
     */
    public boolean Define_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFInitialEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1833
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return false;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1415
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInitial
     */
    protected boolean canDefine_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:445
     * @apilevel internal
     */
    public FAbstractEquation Define_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:445
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFAbstractEquation
     */
    protected boolean canDefine_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:573
     * @apilevel internal
     */
    public boolean Define_isTopWhenIfEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:573
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopWhenIfEquation
     */
    protected boolean canDefine_isTopWhenIfEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lockBranch
     */
    protected boolean canDefine_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1773
     * @apilevel internal
     */
    public FWhenEquation Define_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1773
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myWhen
     */
    protected boolean canDefine_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1783
     * @apilevel internal
     */
    public FWhenEquation Define_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return last;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1783
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findTopWhen
     */
    protected boolean canDefine_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccess
     */
    protected boolean canDefine_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942
     * @apilevel internal
     */
    public boolean Define_isElse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isElse
     */
    protected boolean canDefine_isElse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38
     * @apilevel internal
     */
    public boolean Define_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        if (_callerNode == getFInitialEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:41
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return propagator.propagateInitial();
        }
        else if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:40
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_canPropagateContext(this, _callerNode, propagator);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canPropagateContext
     */
    protected boolean canDefine_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347
     * @apilevel internal
     */
    public FIfWhenEquation Define_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingIfOrElse
     */
    protected boolean canDefine_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574
     * @apilevel internal
     */
    public boolean Define_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isIndicator
     */
    protected boolean canDefine_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     */
    public boolean Define_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignUse
     */
    protected boolean canDefine_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     * @apilevel internal
     */
    public CodeGenContext Define_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return codeGenContext;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCodeGenContext
     */
    protected boolean canDefine_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /**
     * Util for finding all differentiated variables. Can't use the fact that
     * for var x there is a variable der(x), not true before additon of
     * derivative variables!
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1069
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1069")
    public LinkedHashSet<FVariable> differentiatedByFDerExp() {
        ASTState state = state();
        if (FClass_differentiatedByFDerExp_computed) {
            return FClass_differentiatedByFDerExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_differentiatedByFDerExp_value = differentiatedByFDerExp_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_differentiatedByFDerExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_differentiatedByFDerExp_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> differentiatedByFDerExp_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_differentiatedByFDerExp();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FClass_differentiatedByFDerExp.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_differentiatedByFDerExp.get(this)) {
                contributor.contributeTo_FClass_differentiatedByFDerExp(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_differentiatedByFDerExp_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FClass_differentiatedByFDerExp_value;

    /**
     * Collection that contains all differentiated variables that has been
     * found to be dynamic states. All of these variables originates from
     * the original model.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1494
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1494")
    public LinkedHashSet<FRealVariable> dynamicStates() {
        ASTState state = state();
        if (FClass_dynamicStates_computed) {
            return FClass_dynamicStates_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_dynamicStates_value = dynamicStates_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_dynamicStates_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_dynamicStates_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FRealVariable> dynamicStates_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_dynamicStates();
        LinkedHashSet<FRealVariable> _computedValue = new LinkedHashSet<FRealVariable>();
        if (root.contributorMap_FClass_dynamicStates.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_dynamicStates.get(this)) {
                contributor.contributeTo_FClass_dynamicStates(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_dynamicStates_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FRealVariable> FClass_dynamicStates_value;

    /**
     * Collection that contains all dynamic state variables introduced by the
     * compiler. This collection differs from dynamicStates() in that it 
     * contains all the actual states.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1505
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1505")
    public LinkedHashSet<FDynamicStateVariable> dynamicStateVariables() {
        ASTState state = state();
        if (FClass_dynamicStateVariables_computed) {
            return FClass_dynamicStateVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_dynamicStateVariables_value = dynamicStateVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_dynamicStateVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_dynamicStateVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FDynamicStateVariable> dynamicStateVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_dynamicStateVariables();
        LinkedHashSet<FDynamicStateVariable> _computedValue = new LinkedHashSet<FDynamicStateVariable>();
        if (root.contributorMap_FClass_dynamicStateVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_dynamicStateVariables.get(this)) {
                contributor.contributeTo_FClass_dynamicStateVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_dynamicStateVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FDynamicStateVariable> FClass_dynamicStateVariables_value;

    /**
     * Collection that contains all dynamic algebraic variables introduced by the
     * compiler.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1515
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1515")
    public LinkedHashSet<FDynamicAlgebraicVariable> dynamicAlgebraicVariables() {
        ASTState state = state();
        if (FClass_dynamicAlgebraicVariables_computed) {
            return FClass_dynamicAlgebraicVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_dynamicAlgebraicVariables_value = dynamicAlgebraicVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_dynamicAlgebraicVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_dynamicAlgebraicVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FDynamicAlgebraicVariable> dynamicAlgebraicVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_dynamicAlgebraicVariables();
        LinkedHashSet<FDynamicAlgebraicVariable> _computedValue = new LinkedHashSet<FDynamicAlgebraicVariable>();
        if (root.contributorMap_FClass_dynamicAlgebraicVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_dynamicAlgebraicVariables.get(this)) {
                contributor.contributeTo_FClass_dynamicAlgebraicVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_dynamicAlgebraicVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FDynamicAlgebraicVariable> FClass_dynamicAlgebraicVariables_value;

    /**
     * Returns the same set as differentiatedRealVariablesSet, except derivatives with no
     * uses that were not introduced because of stateselect.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1525
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1525")
    public LinkedHashSet<FRealVariable> differentiatedRealVariablesFilteredSet() {
        ASTState state = state();
        if (FClass_differentiatedRealVariablesFilteredSet_computed) {
            return FClass_differentiatedRealVariablesFilteredSet_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_differentiatedRealVariablesFilteredSet_value = differentiatedRealVariablesFilteredSet_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_differentiatedRealVariablesFilteredSet_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_differentiatedRealVariablesFilteredSet_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FRealVariable> differentiatedRealVariablesFilteredSet_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_differentiatedRealVariablesFilteredSet();
        LinkedHashSet<FRealVariable> _computedValue = new LinkedHashSet<FRealVariable>();
        if (root.contributorMap_FClass_differentiatedRealVariablesFilteredSet.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_differentiatedRealVariablesFilteredSet.get(this)) {
                contributor.contributeTo_FClass_differentiatedRealVariablesFilteredSet(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_differentiatedRealVariablesFilteredSet_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FRealVariable> FClass_differentiatedRealVariablesFilteredSet_value;

    /**
     * \brief Collection of all callables called by a partial function call
     * or kept as a component.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1539
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1539")
    public LinkedHashSet<FFunctionDecl> myFFunctionDeclsPartial() {
        ASTState state = state();
        if (FClass_myFFunctionDeclsPartial_computed) {
            return FClass_myFFunctionDeclsPartial_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_myFFunctionDeclsPartial_value = myFFunctionDeclsPartial_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_myFFunctionDeclsPartial_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_myFFunctionDeclsPartial_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FFunctionDecl> myFFunctionDeclsPartial_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_myFFunctionDeclsPartial();
        LinkedHashSet<FFunctionDecl> _computedValue = new LinkedHashSet<FFunctionDecl>();
        if (root.contributorMap_FClass_myFFunctionDeclsPartial.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_myFFunctionDeclsPartial.get(this)) {
                contributor.contributeTo_FClass_myFFunctionDeclsPartial(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_myFFunctionDeclsPartial_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FFunctionDecl> FClass_myFFunctionDeclsPartial_value;

    /**
     * \brief Collection of all FFunctionDecls called by a partial function call.
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1548
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1548")
    public LinkedHashSet<FFunctionDecl> myFFunctionDeclsPartialCalled() {
        ASTState state = state();
        if (FClass_myFFunctionDeclsPartialCalled_computed) {
            return FClass_myFFunctionDeclsPartialCalled_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_myFFunctionDeclsPartialCalled_value = myFFunctionDeclsPartialCalled_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_myFFunctionDeclsPartialCalled_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_myFFunctionDeclsPartialCalled_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FFunctionDecl> myFFunctionDeclsPartialCalled_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_myFFunctionDeclsPartialCalled();
        LinkedHashSet<FFunctionDecl> _computedValue = new LinkedHashSet<FFunctionDecl>();
        if (root.contributorMap_FClass_myFFunctionDeclsPartialCalled.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_myFFunctionDeclsPartialCalled.get(this)) {
                contributor.contributeTo_FClass_myFFunctionDeclsPartialCalled(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_myFFunctionDeclsPartialCalled_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FFunctionDecl> FClass_myFFunctionDeclsPartialCalled_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1552
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1552")
    public ArrayList<FDelayExp> myDelayExps() {
        ASTState state = state();
        if (FClass_myDelayExps_computed) {
            return FClass_myDelayExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_myDelayExps_value = myDelayExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_myDelayExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_myDelayExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FDelayExp> myDelayExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_myDelayExps();
        ArrayList<FDelayExp> _computedValue = new ArrayList<FDelayExp>();
        if (root.contributorMap_FClass_myDelayExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_myDelayExps.get(this)) {
                contributor.contributeTo_FClass_myDelayExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_myDelayExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FDelayExp> FClass_myDelayExps_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1558
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1558")
    public ArrayList<FSpatialDistExp> mySpatialDistExps() {
        ASTState state = state();
        if (FClass_mySpatialDistExps_computed) {
            return FClass_mySpatialDistExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_mySpatialDistExps_value = mySpatialDistExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_mySpatialDistExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_mySpatialDistExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FSpatialDistExp> mySpatialDistExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_mySpatialDistExps();
        ArrayList<FSpatialDistExp> _computedValue = new ArrayList<FSpatialDistExp>();
        if (root.contributorMap_FClass_mySpatialDistExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_mySpatialDistExps.get(this)) {
                contributor.contributeTo_FClass_mySpatialDistExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_mySpatialDistExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FSpatialDistExp> FClass_mySpatialDistExps_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1577
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1577")
    public ArrayList<FDerivativeVariable> derivativeVariables() {
        ASTState state = state();
        if (FClass_derivativeVariables_computed) {
            return FClass_derivativeVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_derivativeVariables_value = derivativeVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_derivativeVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_derivativeVariables_value;
    }
    /** @apilevel internal */
    private ArrayList<FDerivativeVariable> derivativeVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_derivativeVariables();
        ArrayList<FDerivativeVariable> _computedValue = new ArrayList<FDerivativeVariable>();
        if (root.contributorMap_FClass_derivativeVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_derivativeVariables.get(this)) {
                contributor.contributeTo_FClass_derivativeVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_derivativeVariables_computed = false;

    /** @apilevel internal */
    protected ArrayList<FDerivativeVariable> FClass_derivativeVariables_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1584
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1584")
    public ArrayList<FVariable> variables() {
        ASTState state = state();
        if (FClass_variables_computed) {
            return FClass_variables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_variables_value = variables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_variables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_variables_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> variables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_variables();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_variables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_variables.get(this)) {
                contributor.contributeTo_FClass_variables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_variables_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_variables_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1643
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1643")
    public ArrayList<FVariable> aliasVariables() {
        ASTState state = state();
        if (FClass_aliasVariables_computed) {
            return FClass_aliasVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_aliasVariables_value = aliasVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_aliasVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_aliasVariables_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> aliasVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_aliasVariables();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_aliasVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_aliasVariables.get(this)) {
                contributor.contributeTo_FClass_aliasVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_aliasVariables_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_aliasVariables_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1662
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1662")
    public ArrayList<FVariable> tempVariables() {
        ASTState state = state();
        if (FClass_tempVariables_computed) {
            return FClass_tempVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_tempVariables_value = tempVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_tempVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_tempVariables_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> tempVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_tempVariables();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_tempVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_tempVariables.get(this)) {
                contributor.contributeTo_FClass_tempVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_tempVariables_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_tempVariables_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1719
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1719")
    public ArrayList<FVariable> variablesWithBindingExp() {
        ASTState state = state();
        if (FClass_variablesWithBindingExp_computed) {
            return FClass_variablesWithBindingExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_variablesWithBindingExp_value = variablesWithBindingExp_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_variablesWithBindingExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_variablesWithBindingExp_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> variablesWithBindingExp_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_variablesWithBindingExp();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_variablesWithBindingExp.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_variablesWithBindingExp.get(this)) {
                contributor.contributeTo_FClass_variablesWithBindingExp(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_variablesWithBindingExp_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_variablesWithBindingExp_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1746
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1746")
    public ArrayList<FVariable> inputs() {
        ASTState state = state();
        if (FClass_inputs_computed) {
            return FClass_inputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_inputs_value = inputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_inputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_inputs_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> inputs_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_inputs();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_inputs.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_inputs.get(this)) {
                contributor.contributeTo_FClass_inputs(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_inputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_inputs_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1776
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1776")
    public ArrayList<FVariable> outputs() {
        ASTState state = state();
        if (FClass_outputs_computed) {
            return FClass_outputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_outputs_value = outputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_outputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_outputs_value;
    }
    /** @apilevel internal */
    private ArrayList<FVariable> outputs_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_outputs();
        ArrayList<FVariable> _computedValue = new ArrayList<FVariable>();
        if (root.contributorMap_FClass_outputs.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_outputs.get(this)) {
                contributor.contributeTo_FClass_outputs(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_outputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<FVariable> FClass_outputs_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1838
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1838")
    public ArrayList<FAlgorithm> algorithms() {
        ASTState state = state();
        if (FClass_algorithms_computed) {
            return FClass_algorithms_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_algorithms_value = algorithms_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_algorithms_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_algorithms_value;
    }
    /** @apilevel internal */
    private ArrayList<FAlgorithm> algorithms_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_algorithms();
        ArrayList<FAlgorithm> _computedValue = new ArrayList<FAlgorithm>();
        if (root.contributorMap_FClass_algorithms.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_algorithms.get(this)) {
                contributor.contributeTo_FClass_algorithms(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_algorithms_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAlgorithm> FClass_algorithms_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2010
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2010")
    public ArrayList<FSampleExp> sampleExpsWithTimeEvent() {
        ASTState state = state();
        if (FClass_sampleExpsWithTimeEvent_computed) {
            return FClass_sampleExpsWithTimeEvent_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_sampleExpsWithTimeEvent_value = sampleExpsWithTimeEvent_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_sampleExpsWithTimeEvent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_sampleExpsWithTimeEvent_value;
    }
    /** @apilevel internal */
    private ArrayList<FSampleExp> sampleExpsWithTimeEvent_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_sampleExpsWithTimeEvent();
        ArrayList<FSampleExp> _computedValue = new ArrayList<FSampleExp>();
        if (root.contributorMap_FClass_sampleExpsWithTimeEvent.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_sampleExpsWithTimeEvent.get(this)) {
                contributor.contributeTo_FClass_sampleExpsWithTimeEvent(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_sampleExpsWithTimeEvent_computed = false;

    /** @apilevel internal */
    protected ArrayList<FSampleExp> FClass_sampleExpsWithTimeEvent_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2016
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2016")
    public ArrayList<FSpatialDistExp> spatialDistExpsWithStateEvent() {
        ASTState state = state();
        if (FClass_spatialDistExpsWithStateEvent_computed) {
            return FClass_spatialDistExpsWithStateEvent_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_spatialDistExpsWithStateEvent_value = spatialDistExpsWithStateEvent_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_spatialDistExpsWithStateEvent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_spatialDistExpsWithStateEvent_value;
    }
    /** @apilevel internal */
    private ArrayList<FSpatialDistExp> spatialDistExpsWithStateEvent_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_spatialDistExpsWithStateEvent();
        ArrayList<FSpatialDistExp> _computedValue = new ArrayList<FSpatialDistExp>();
        if (root.contributorMap_FClass_spatialDistExpsWithStateEvent.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_spatialDistExpsWithStateEvent.get(this)) {
                contributor.contributeTo_FClass_spatialDistExpsWithStateEvent(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_spatialDistExpsWithStateEvent_computed = false;

    /** @apilevel internal */
    protected ArrayList<FSpatialDistExp> FClass_spatialDistExpsWithStateEvent_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2022
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2022")
    public ArrayList<FDelayExp> delayExpsWithStateEvent() {
        ASTState state = state();
        if (FClass_delayExpsWithStateEvent_computed) {
            return FClass_delayExpsWithStateEvent_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_delayExpsWithStateEvent_value = delayExpsWithStateEvent_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_delayExpsWithStateEvent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_delayExpsWithStateEvent_value;
    }
    /** @apilevel internal */
    private ArrayList<FDelayExp> delayExpsWithStateEvent_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_delayExpsWithStateEvent();
        ArrayList<FDelayExp> _computedValue = new ArrayList<FDelayExp>();
        if (root.contributorMap_FClass_delayExpsWithStateEvent.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_delayExpsWithStateEvent.get(this)) {
                contributor.contributeTo_FClass_delayExpsWithStateEvent(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_delayExpsWithStateEvent_computed = false;

    /** @apilevel internal */
    protected ArrayList<FDelayExp> FClass_delayExpsWithStateEvent_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2036
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2036")
    public ArrayList<FExp> guardExpInEquations() {
        ASTState state = state();
        if (FClass_guardExpInEquations_computed) {
            return FClass_guardExpInEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_guardExpInEquations_value = guardExpInEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_guardExpInEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_guardExpInEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> guardExpInEquations_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FlatRoot)) {
            node = node.getParent();
        }
        FlatRoot root = (FlatRoot) node;
        root.survey_FClass_guardExpInEquations();
        ArrayList<FExp> _computedValue = new ArrayList<FExp>();
        if (root.contributorMap_FClass_guardExpInEquations.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_guardExpInEquations.get(this)) {
                contributor.contributeTo_FClass_guardExpInEquations(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_guardExpInEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> FClass_guardExpInEquations_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2043
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2043")
    public ArrayList<FExp> guardExpInInitialEquations() {
        ASTState state = state();
        if (FClass_guardExpInInitialEquations_computed) {
            return FClass_guardExpInInitialEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_guardExpInInitialEquations_value = guardExpInInitialEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_guardExpInInitialEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_guardExpInInitialEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> guardExpInInitialEquations_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FlatRoot)) {
            node = node.getParent();
        }
        FlatRoot root = (FlatRoot) node;
        root.survey_FClass_guardExpInInitialEquations();
        ArrayList<FExp> _computedValue = new ArrayList<FExp>();
        if (root.contributorMap_FClass_guardExpInInitialEquations.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_guardExpInInitialEquations.get(this)) {
                contributor.contributeTo_FClass_guardExpInInitialEquations(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_guardExpInInitialEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> FClass_guardExpInInitialEquations_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2130
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2130")
    public ArrayList<FRelExp> relExpsWithEvent() {
        ASTState state = state();
        if (FClass_relExpsWithEvent_computed) {
            return FClass_relExpsWithEvent_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_relExpsWithEvent_value = relExpsWithEvent_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_relExpsWithEvent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_relExpsWithEvent_value;
    }
    /** @apilevel internal */
    private ArrayList<FRelExp> relExpsWithEvent_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_relExpsWithEvent();
        ArrayList<FRelExp> _computedValue = new ArrayList<FRelExp>();
        if (root.contributorMap_FClass_relExpsWithEvent.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_relExpsWithEvent.get(this)) {
                contributor.contributeTo_FClass_relExpsWithEvent(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_relExpsWithEvent_computed = false;

    /** @apilevel internal */
    protected ArrayList<FRelExp> FClass_relExpsWithEvent_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2207
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2207")
    public ArrayList<FRelExp> relExpInInitialEquations() {
        ASTState state = state();
        if (FClass_relExpInInitialEquations_computed) {
            return FClass_relExpInInitialEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_relExpInInitialEquations_value = relExpInInitialEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_relExpInInitialEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_relExpInInitialEquations_value;
    }
    /** @apilevel internal */
    private ArrayList<FRelExp> relExpInInitialEquations_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_relExpInInitialEquations();
        ArrayList<FRelExp> _computedValue = new ArrayList<FRelExp>();
        if (root.contributorMap_FClass_relExpInInitialEquations.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_relExpInInitialEquations.get(this)) {
                contributor.contributeTo_FClass_relExpInInitialEquations(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_relExpInInitialEquations_computed = false;

    /** @apilevel internal */
    protected ArrayList<FRelExp> FClass_relExpInInitialEquations_value;

    /**
     * @attribute coll
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4235
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAlgorithmAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4235")
    public ArrayList<FAlgorithm> myAlgorithms() {
        ASTState state = state();
        if (FClass_myAlgorithms_computed) {
            return FClass_myAlgorithms_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_myAlgorithms_value = myAlgorithms_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_myAlgorithms_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_myAlgorithms_value;
    }
    /** @apilevel internal */
    private ArrayList<FAlgorithm> myAlgorithms_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_myAlgorithms();
        ArrayList<FAlgorithm> _computedValue = new ArrayList<FAlgorithm>();
        if (root.contributorMap_FClass_myAlgorithms.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_myAlgorithms.get(this)) {
                contributor.contributeTo_FClass_myAlgorithms(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_myAlgorithms_computed = false;

    /** @apilevel internal */
    protected ArrayList<FAlgorithm> FClass_myAlgorithms_value;

    /**
     * @attribute coll
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4318
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4318")
    public HashSet<FExternalStmt> myExternals() {
        ASTState state = state();
        if (FClass_myExternals_computed) {
            return FClass_myExternals_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_myExternals_value = myExternals_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_myExternals_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_myExternals_value;
    }
    /** @apilevel internal */
    private HashSet<FExternalStmt> myExternals_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_myExternals();
        HashSet<FExternalStmt> _computedValue = new LinkedHashSet<FExternalStmt>();
        if (root.contributorMap_FClass_myExternals.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_myExternals.get(this)) {
                contributor.contributeTo_FClass_myExternals(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_myExternals_computed = false;

    /** @apilevel internal */
    protected HashSet<FExternalStmt> FClass_myExternals_value;

    /**
     * @attribute coll
     * @aspect FlatteningDebug
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatteningDebug", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2254")
    public HashSet<InstAccess> collectInstAccesses() {
        ASTState state = state();
        if (FClass_collectInstAccesses_computed) {
            return FClass_collectInstAccesses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_collectInstAccesses_value = collectInstAccesses_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_collectInstAccesses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_collectInstAccesses_value;
    }
    /** @apilevel internal */
    private HashSet<InstAccess> collectInstAccesses_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_collectInstAccesses();
        HashSet<InstAccess> _computedValue = new HashSet<InstAccess>();
        if (root.contributorMap_FClass_collectInstAccesses.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_collectInstAccesses.get(this)) {
                contributor.contributeTo_FClass_collectInstAccesses(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_collectInstAccesses_computed = false;

    /** @apilevel internal */
    protected HashSet<InstAccess> FClass_collectInstAccesses_value;

    /**
     * Collects semiLinear expressions.
     * @attribute coll
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1647")
    public HashSet<FSemiLinearExp> collectSemiLinearExps() {
        ASTState state = state();
        if (FClass_collectSemiLinearExps_computed) {
            return FClass_collectSemiLinearExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_collectSemiLinearExps_value = collectSemiLinearExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_collectSemiLinearExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_collectSemiLinearExps_value;
    }
    /** @apilevel internal */
    private HashSet<FSemiLinearExp> collectSemiLinearExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_collectSemiLinearExps();
        HashSet<FSemiLinearExp> _computedValue = new HashSet<FSemiLinearExp>();
        if (root.contributorMap_FClass_collectSemiLinearExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_collectSemiLinearExps.get(this)) {
                contributor.contributeTo_FClass_collectSemiLinearExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_collectSemiLinearExps_computed = false;

    /** @apilevel internal */
    protected HashSet<FSemiLinearExp> FClass_collectSemiLinearExps_value;

    /**
     * Collects all event generating expressions.
     * @attribute coll
     * @aspect ExtractEventGeneratingExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="ExtractEventGeneratingExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:59")
    public ArrayList<FExp> eventGenExps() {
        ASTState state = state();
        if (FClass_eventGenExps_computed) {
            return FClass_eventGenExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FClass_eventGenExps_value = eventGenExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FClass_eventGenExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FClass_eventGenExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> eventGenExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FClass_eventGenExps();
        ArrayList<FExp> _computedValue = new ArrayList<FExp>();
        if (root.contributorMap_FClass_eventGenExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FClass_eventGenExps.get(this)) {
                contributor.contributeTo_FClass_eventGenExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FClass_eventGenExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> FClass_eventGenExps_value;

}
