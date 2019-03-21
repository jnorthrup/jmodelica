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
 * Base class for all type nodes.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:242
 * @astdecl FType : BaseNode;
 * @production FType : {@link BaseNode};

 */
public abstract class FType extends BaseNode implements Cloneable, ExternalProcessMultiCache.Type<CValue>, CommonType {
    /**
     * Wrap the given expression so it is suitable for use in an expression 
     * calculating the array size of a range expression.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:796
     */
    public FExp wrapRangeSizeExp(FExp exp) {
 		return exp;
 	}
    /**
     * Create a CValue with the zero value for this type, if applicable.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1726
     */
    public CValue zeroCValue() {
        if (isArray() && !zeroCValueScalar().isUnknown()) {
            CValueArray res = new CValueArray(size());
            while (!res.isFilled())
                res.addCell(zeroCValueScalar());
            return res; 
        } else {
            return zeroCValueScalar();
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1737
     */
    public CValue zeroCValueScalar()        { return CValue.UNKNOWN; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1745
     */
    public CValue createCValue(int v) {
        if (isArray()) {
            CValueArray res = new CValueArray(size());
            while (!res.isFilled())
                res.addCell(createCValueScalar(v));
            return res;
        } else {
            return createCValueScalar(v);
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1756
     */
    public CValue createCValueScalar(int v)     { return new CValueInteger(v); }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1759
     */
    public CValue convert(CValue v)        { return v; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1765
     */
    public CValue limitCValueScalar(boolean high)        { return CValue.UNSUPPORTED; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:1806
     */
    public CValue unknownCValue() {
        if (isArray()) {
            CValueArray arr = new CValueArray(size());
            for (Index i : indices()) {
                arr.setCell(i, CValue.UNKNOWN);
            }
            return arr;
        } else {
            return CValue.UNKNOWN;
        }
    }
    /**
     * Handle one part of the left access of an assignment during function evaluation.
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:218
     */
    public CValue assignToPartInFuncEval(CommonNamePart name, CValue left, CValue right) {
        return assignToLastInFuncEval(name, left, right);
    }
    /**
     * \brief Get the type of a specific component.
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:280
     */
    public FType componentType(String name, List<FRecordComponentType> comps) {
        for (FRecordComponentType comp : comps)
            if (comp.getName().equals(name))
                return comp.getFType();
        return fUnknownType();
    }
    /**
     * Handle the last part of the left access of an assignment during function evaluation.
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:290
     */
    public CValue assignToLastInFuncEval(CommonNamePart name, CValue left, CValue right) {
        if (!isArray() || !name.hasFArraySubscripts()) {
            return right.cached();
        }
        
        if (left.isUnknown()) {
            left = new CValueArray(size().ceval()).markAsCached();
        }
        
        if (name.isArray()) {
            CValueArray al = left.array();
            CValueArray ar = right.array();
            Indices ind = name.indices();
            for (Index i : ind) {
                al.setCell(ind.translate(i), ar.getCell(i));
            }
        } else {
            left.array().setCell(name.getFArraySubscripts().createIndex(), right);
        }
        return left;
    }
    /**
     * Read a constant value of <code>this</code> type from <code>buff</code>
     * @aspect ExternalProcessCommunication
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:310
     */
    public CValue deserialize(ProcessCommunicator com) throws IOException {
        if (isArray()) {
            CValueArray a = new CValueArray(size().ceval());
            for (Index i : a.indices()) {
                a.setCell(i, deserializeScalar(com));
            }
            return a;
        } else {
            return deserializeScalar(com);
        }
    }
    /**
     * @aspect ExternalProcessCommunication
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:321
     */
    public CValue deserializeScalar(ProcessCommunicator com) throws IOException {
        throw new IOException("Unsupported type to deserialize '" + getClass().getSimpleName() + "'");
    }
    /**
     * Create a negation expression for the flat tree for an expression of this type.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:445
     */
    public FExp createFNegExp(FExp a) {
        return new FNegExp(a);
    }
    /**
     * Create a subtraction expression for the flat tree for two expressions of this type.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:456
     */
    public FExp createFSubExp(FExp a, FExp b) {
        return new FSubExp(a, b);
    }
    /**
     * Create an addition expression for the flat tree for two expressions of this type.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:467
     */
    public FExp createFAddExp(FExp a, FExp b) {
        return new FAddExp(a, b);
    }
    /**
     * Creates new temporary variables with the given name.
     * 
     * @param vars         list of variable to add the new variable to
     * @param name         the name of the new variable
     * @param variability  the variability of the new variable
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1682
     */
    public void createTempFVariables(List vars, FAccessString name, TypePrefixVariability variability) {
        if (isArray()) {
            for (Index i : indices()) {
                createTempCellFVariables(vars, name.copyAndAddFas(i), variability);
            }
        } else {
            createTempCellFVariables(vars, name, variability);
        }
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1692
     */
    public void createTempCellFVariables(List vars, FAccessString name, TypePrefixVariability variability) {
        vars.add(createTempFVariable(name, variability));
    }
    /**
     * Creates a new temporary variable with the given name and variability.
     * 
     * All optional children in the new variable are empty.
     * 
     * Default implementation returns <code>null</code>.
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1709
     */
    public FVariable createTempFVariable(FAccess name, TypePrefixVariability variability) {
        return createFVariable(VisibilityType.TEMPORARY, name, variability);
    }
    /**
     * Creates a new variable with the given visibility, name and visibility.
     * 
     * All optional children in the new variable are empty.
     * 
     * Default implementation returns <code>null</code>.
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1720
     */
    public FVariable createFVariable(VisibilityType vt, FAccess name, 
            TypePrefixVariability variability) {
        throw new UnsupportedOperationException();
    }
    /**
     * Returns what is printed by {@link #printStructure(CodeStream)} as a String.
     * @aspect TypeStructurePrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:986
     */
    public String printStructure() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CodeStream str = new NotNullCodeStream(os);
        printStructure(str);
        return os.toString();
    }
    /**
     * Prints a string representation of the structure of this type. The
     * representation for scalar types is its name. The representation for composite
     * types its name and size, and the name and size of any components. This can be
     * used to provide more informative error messages for composite types.
     * 
     * @param str
     * the stream that is printed to.
     * @aspect TypeStructurePrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1002
     */
    public void printStructure(CodeStream str) {
        str.print(toString());
    }
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:262
     */
    public abstract Size getSize();
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:263
     */
    public abstract void setSize(Size size);
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:287
     */
    public FType createSizeFExp(InstFunctionCall call) {
        FType res = treeCopy();
        res.replaceSizeFExp(call);
        return res;
    }
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:299
     */
    public void replaceSizeFExp(InstFunctionCall call) {
        setSize(getSize().createSizeFExp(call));
        super.replaceSizeFExp(call);
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:834
     */
    public FType lookupHierarchical(FAccess name, int part, int last) {
        return this;
    }
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1291
     */
    public abstract boolean containsType(FType type);
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1307
     */
    
        protected static interface TypeChecker {
            public boolean check(FType t);
        }
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1311
     */
    
        
        private static final TypeChecker IS_REAL = new TypeChecker() {
            public boolean check(FType t) { return t.isReal(); }
        };
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1316
     */
    protected boolean recursiveTypeCheck(TypeChecker ch) {
        return ch.check(this);
    }
    /**
     * Create a literal with the zero value for this type, if applicable.
     * 
     * For operator records, a record constructor call is created.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1403
     */
    public FExp sizedZeroLiteral() {
         if (isArray()) {
             return size().fillDimsOfExp(createArrayZeroLiteralNoSize());
         } else {
             return zeroLiteral();
         }
     }
    /**
     * Create a literal with the zero value for the scalar version of this type, if applicable.
     * 
     * For operator records, a record constructor call is created.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1416
     */
    public FExp zeroLiteral()        { return new FNoExp(); }
    /**
     * Create a fill or zeros expression, as appropriate to describe a zero-value 
     * literal of this type, without the size filled in.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1443
     */
    protected FArrayDimAsArgsExp createArrayZeroLiteralNoSize() {
       return new FFillExp(new List<FExp>(), zeroLiteral());
   }
    /**
     * Create a literal with the given integer value for this type, if applicable.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1453
     */
    public FExp createSizedLiteral(int v) {
       if (isArray()) {
           return size().fillDimsOfExp(createArrayLiteralNoSize(v));
       } else {
           return createLiteral(v);
       }
   }
    /**
     * Create a literal with the given integer value for the scalar version of this type, if applicable.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1464
     */
    public FExp createLiteral(int v)        { throw new UnsupportedOperationException(); }
    /**
     * Create a fill, zeros or ones expression, as appropriate for the given integer value, 
     * without the size filled in.
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1476
     */
    protected FArrayDimAsArgsExp createArrayLiteralNoSize(int v) {
       return new FFillExp(new List<FExp>(), createLiteral(v));
   }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:762
     */
    public void contentCheckFortranArg(ErrorCheckType checkType, FExternalStmt stmt) {
        
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:787
     */
    public void contentCheckCArg(ErrorCheckType checkType, FExternalStmt stmt) { }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:363
     */
    public void flattenOverloadedOperatorsForFlow(Flattener f) {}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:648
     */
    public void updateRecordArraySizes(FType from) {
        setSize(from.getSize());
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:985
     */
    public FType flatten(Flattener f, InstAssignable ia, boolean keepSizeExpressions) {
        FType res = fullCopy();
        res.setSize(getSize().flatten(f, res, keepSizeExpressions));
        return res;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1124
     */
    public FExp affixExpression(FExp exp) {
        // TODO: need better way of including exp in tree
        exp.parent = this;
        return exp;
    }
    /**
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:148
     */
    public FType componentType(String name) {
        return fUnknownType();
    }
    /**
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:120
     */
    public FExp flattenZeroLiteral() {
        return sizedZeroLiteral();
    }
    /**
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:283
     */
    public abstract boolean shouldBeDifferentiated();
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:184
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        super.markUsedGlobals(type);
        getSize().markUsedGlobals(type);
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:894
     */
    public void transferSizes(FType t) {
        if (!t.isUnknown()) {
            setSize(t.getSize());
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:536
     */
    public FExp addInliningVarsAndEqns(final AbstractFunctionInliner fi, final String old, final boolean noEvent,
            final FExp src, final String temp) {
        ExpFromTypeBuilder b = new ExpFromTypeBuilder() {
            public FExp build(String suffix, FType type) {
                String tempName = temp + suffix;
                String oldName = old + suffix;
                FExp e = src.dynamicFExp(new FAccessExp(tempName));
                TypePrefixVariability v = fi.contextVariability(src);
                fi.addVarAndEqn(oldName, e, noEvent, type, v);
                fi.addVar(new FAccessString(tempName), v, type);
                return e.fullCopy();
             }
        };
        return buildFExp(b, "");
     }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:905
     */
    public FExp replaceInlined(final AbstractFunctionInliner fi, final String name) {
        ExpFromTypeBuilder b = new ExpFromTypeBuilder() {
            public FExp build(String suffix, FType type) {
                return fi.getReplacementExp(name + suffix).fullCopy();
            }
        };
        return buildFExp(b, "");
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:918
     */
    public FExp buildFExp(ExpFromTypeBuilder b, String suffix) {
         if (isArray()) {
            return buildFExp(b, suffix, 0, indices().iterator());
        } else {
            return buildFExpCell(b, suffix);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:926
     */
    public FExp buildFExp(ExpFromTypeBuilder b, String suffix, int dim, Iterator<Index> indices) {
        if (dim < size().ndims()) {
            FArray a = new FArray();
            for (int i = 0; i < size().get(dim); i++) {
               a.addFExp(buildFExp(b, suffix, dim + 1, indices));
            }
            return a;
        } else {
            return buildFExpCell(b, suffix + indices.next());
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:938
     */
    public FExp buildFExpCell(ExpFromTypeBuilder b, String suffix) {
        return b.build(suffix, scalarType());
     }
    /**
     * Make a copy of this type with all variable references replaced according to the 
     * function inliner.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1780
     */
    public FType copyAndReplaceReferences(AbstractFunctionInliner fi) {
        FType res = fullCopy();
        res.setParent(parent);
        return (FType) res.replaceReferences(fi);
    }
    /**
     * Generate scalar clauses for this record or record component.
     * 
     * @param s         Scalarization visitor
     * @param suffix    add this as a suffix to the name of the uppermost record in uses
     * @param left      the left expression from the original equation
     * @param right     the right expression from the original equation
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1020
     */
    public void scalarRecordClauses(Scalarizer s, FAccess suffix, FExp left, FExp right) {
        left = left.scalarRecordFExp(s, suffix);
        right = right.scalarRecordFExp(s, suffix);
        s.add(left, right);
    }
    /**
     * Generate scalar clauses for this record component.
     * 
     * @param s         Scalarization visitor
     * @param suffix    add this as a suffix to the name of the uppermost record in uses
     * @param left      the left expression from the original equation
     * @param right     the right expression from the original equation
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1047
     */
    public void scalarRecordComponentClauses(Scalarizer s, FAccess suffix, FExp left, FExp right) {
		if (isArray()) {
			FAccessFull fullSuffix = suffix.copyAsFAccessFull();
			Indices ind = null;
            if (!size().isUnknown())
				ind = indices(); 
			else  // TODO: This is calculated each time - introduce some kind of lazy attribute?
                ind = left.dynamicFExp(left.scalarRecordFExp(s, suffix)).indices();
			for (Index i : ind) {
				fullSuffix.addFArraySubscripts(i.createFArraySubscripts());
                scalarRecordClauses(s, fullSuffix, left, right);
			}
		} else {
            scalarRecordClauses(s, suffix, left, right);
		}
	}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1306
     */
    public void addDummyEqnsForTemp(List<FAbstractEquation> l, String name) {
        if (isArray()) {
            FType scalar = scalarType();
            for (Index i : indices()) 
                scalar.addDummyEqnsForTemp(l, name + i);
        } else {
            l.add(new FEquation(new FAccessExp(name), zeroLiteral()));
        }
    }
    /**
     * Create a record constructor (or FArray of record constructors),  
     * with the arguments taken from a record variable with the given name.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1359
     */
    public FExp createRecordConstructor(Scalarizer s, FExp exp) {
        if (isArray() || exp.isArray()) {
            return createRecordConstructorArray(s, exp, indices().iterator(), 0);
        } else {
            return createRecordConstructorCell(s, exp);
        }
	}
    /**
     * Create an FArray of expressions, with the arguments taken from a record 
     * variable or member with the given name.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1371
     */
    public FExp createRecordConstructorArray(Scalarizer s, FExp exp, Iterator<Index> it, int dim) {
        if (isEmpty()) {
            return createEmptyExp();
        }
		FArray arr = new FArray();
		boolean last = dim == ndims() - 1;
		for (int i = 0, n = size().get(dim); i < n; i++) {
			FExp res;
            if (last) {
                FExp subExp = exp.extractArrayCell(s, it.next());
                FType t = subExp.type();
                if (t.isUnknown()) {
                    t = this;
                }
                res = t.createRecordConstructorCell(s, subExp);
            } else {
                res = createRecordConstructorArray(s, exp, it, dim + 1);
            }
			arr.addFExp(res);
		}
		return arr;
	}
    /**
     * Create a record constructor with the arguments taken from a record 
     * variable with the given name.
     * 
     * Assumes that <code>name</code> refers to a non-array variable 
     * (or a specific cell in an array variable).
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1411
     */
    public FExp createRecordConstructorCell(Scalarizer s, FExp exp) {
        return exp.scalarize(s);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1802
     */
    public abstract FType scalarize(Scalarizer s, FExp context);
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1852
     */
    public abstract void scalarizeTypeSizes(Scalarizer s, FExp context);
    /**
     * @aspect AlgorithmScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:136
     */
    public abstract void scalarizeInitArray(Scalarizer.Algorithm s, ASTNode context);
    /**
     * Scalarize an assignment and put the resulting statements in the list of statements. 
     * @aspect AssignmentScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:169
     */
    public void scalarizeAssignment(Scalarizer.Algorithm s, FAssignableExp left, FExp right) {
        
        FExp expInAst = right.type().isUnknown() ? left : right;
        
        if (left.inFunction() && left.myFClass().noUnrollingInFunctions() && isArray() || size().isUnknown()) {
            ForNames names = s.getNames();
            names.addLayer(ndims());
            names.fillLayer(expInAst);

            left.addArrayUsesToIndexMap(s);
            right.addArrayUsesToIndexMap(s);

            List<FStatement> stmts = new List<FStatement>();
            scalarizeAssignment_sub(s.block(stmts), left, right);
            s.createForLoops(stmts, expInAst);

            names.removeLayer();
        } else {
            scalarizeAssignment_sub(s, left, right);
        }
    }
    /**
     * @aspect AssignmentScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:191
     */
    public void scalarizeAssignment_sub(Scalarizer.Algorithm s, FAssignableExp left, FExp right) {
        if ((left.inFunction() && left.myFClass().noUnrollingInFunctions()) || !isArray() || size().isUnknown()) {
            scalarizeScalarAssignment(s, left, right);
        } else {
            Indices ind = size().isUnknown() ? right.indices() : indices();
            for (Index i : indices()) {
                scalarizeScalarAssignment(s, (FAssignableExp) left.extractArrayCell(s, i), right.extractArrayCell(s, i));
            }
        }
    }
    /**
     * Scalarize a scalar assignment
     * @aspect AssignmentScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:205
     */
    protected void scalarizeScalarAssignment(Scalarizer.Algorithm s, FAssignableExp left, FExp right) {
        left = (FAssignableExp) left.scalarize(s);
        right = right.scalarize(s);
        s.add(new FAssignStmt(left,right));
    }
    /**
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:212
     */
    public Set<String> sortingAddNamesUsed(Set<String> set) {
        super.sortingAddNamesUsed(set);
        getSize().sortingAddNamesUsed(set);
        return set;
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:418
     */
    public void printScalarDecl_C(CodePrinter p, CodeStream str, String indent, boolean external, String name) {
        str.print(indent);
        str.print("JMI_DEF(");
        str.print(macroTypeDecl(external));
        str.print(", ");
        str.print(name);
        str.print(")\n");
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:33
     */
    public void printAssign(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent,
            ASTNode dst, ASTNode src) {
        str.print(indent);
        p.print(dst, str, indent);
        str.print(" = ");
        p.print(src, str, indent);
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:130
     */
    public void printDeclBase_C(CodePrinter p, CodeStream str, String indent, String name, FExp src, boolean external) {
        if (isArray()) {
            if (size().isUnknown() || external) {
                printDecl_C(p, str, indent, name, src, external);
            } else {
                str.format("%sJMI_ARR(STAT, %s, %s, %s, ", indent,
                        nameScalar_C(p, external), nameArray_C(p, external), name);
                size().printNumElements_C(p, str, indent, src);
                str.print(", ");
                str.print(ndims());
                str.println(")");
            }
        } else {
            printScalarDecl_C(p, str, indent, external, name);
        }
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:516
     */
    public void printAssignExt_C(CodePrinter p, CodeStream str, String indent, String dst, String src, 
            boolean wb, boolean first) {
        if (wb) {
            str.formatln("%s%s = %s;", indent, src, dst);
        } else {
            str.formatln("%s%s = (%s)%s;", indent, dst, argType_C(p, false), src);
        }
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:35
     */
    public void printResidual(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent,
            ASTNode left, ASTNode right, int index) {
        str.print(indent, "(*", p.residual(), ")[", index, "] = ");
        p.print(right, str, "");
        str.print(" - (");
        p.print(left, str, "");
        str.print(");\n");
    }
    /**
     * Generate code that parses the variable <code>name</code> of type 
     * <code>this</code> from stdin.
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:226
     */
    public void genSerialize_C(CodeStream str, String indent, String name, boolean parse) {
        str.print(indent, "JMCEVAL_", 
                parse ? "parse" : "print", 
                isArray() ? "Array(" : "(", 
                isEnum() ? "Enum" : name(), ", ",
                name, ");\n");
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:317
     */
    public void usedTypes(Map<String,FType> res) {
        if (res.containsKey(name())) {
            return;
        }
        res.put(name(), this);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:432
     */
    public void externalDependencies(Set<FExternalStmt> res) {
        
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:437
     */
    public void genFuncCallInOutArg_C(CodeFuncCallInOutArgPrinter p, CodeStream str, String indent, String name, FExp exp) {
        if (isArray()) {
            if (exp.genAssignMacro()) {
                p.printAssign(str, indent, name, exp);
            } else {
                String type = isRecord() ? C_ARRAY_RECORD : p.arrayAccessConst();
                String pre = String.format("jmi_array_%s_%d(%s, ", type, ndims(), name);
                for (Index i : exp.indices()) {
                    String cellName = pre + i.toUnclosedString() + ")";
                    genFuncCallCellInOutArg_C(p, str, indent, cellName, exp.fArrayCell(i, 0));
                }
            }
        } else {
            genFuncCallCellInOutArg_C(p, str, indent, name, exp);
        }
        p.endComponent(str, indent);
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:463
     */
    public void genFuncCallCellInOutArg_C(CodeFuncCallInOutArgPrinter p, CodeStream str, String indent, String name, FExp exp) {
        exp.genFuncCallCellInOutArg_C(p, str, indent, name);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:44
     */
    public abstract String nameScalar_C(CodePrinter p);
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:53
     */
    public abstract String nameArray_C(CodePrinter p);
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:60
     */
    public abstract String nameScalarExt_C(CodePrinter p);
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:68
     */
    public abstract String nameArrayExt_C(CodePrinter p);
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:80
     */
    public abstract String argType_C(CodePrinter p, boolean ref);
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:110
     */
    public abstract String macroTypeDeclScalar();
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:130
     */
    public void printDecl_C(CodePrinter p, CodeStream str, String indent, String name, FExp src) {
        printDecl_C(p, str, indent, name, src, false);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:134
     */
    public void printDecl_C(CodePrinter p, CodeStream str, String indent, String name, FExp src, boolean external) {
        print(p.createDeclPrinter(str), indent, name, src, external);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:138
     */
    public void printInit_C(CodePrinter p, CodeStream str, String indent, String name, FExp src) {
        printInit_C(p, str, indent, name, src, false);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:142
     */
    public void printInit_C(CodePrinter p, CodeStream str, String indent, String name, FExp src, boolean external) {
        print(p.createInitSetPrinter(str), indent, name, src, external);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:186
     */
    public void print(TypePrinter_C tp, String indent, CodePrinter.ExecuteCodePrinter ep, TypePrintable_C src, boolean external) {
        print(tp, indent, ep.name(src), src, external);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:190
     */
    public void print(TypePrinter_C tp, String indent, String name, TypePrintable_C src, boolean external) {
        tp.reset(name, src, size(), external, indent);
        print(tp);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:195
     */
    public void print(TypePrinter_C p)               { p.print(this); }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:535
     */
    public void printInitStartValue_C(CodePrinter p, CodeStream str, String indent, String name) {
        
    }
    /**
     * @declaredat ASTNode:1
     */
    public FType() {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:13
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:19
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:23
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        indices_reset();
        myFEnumDecl_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:29
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public FType clone() throws CloneNotSupportedException {
        FType node = (FType) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:44
     */
    @Deprecated
    public abstract FType fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:52
     */
    public abstract FType treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:60
     */
    public abstract FType treeCopy();
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011")
    public abstract String name();
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276")
    public abstract boolean isType(FType type);
    /** @apilevel internal */
    private void indices_reset() {
        indices_computed = false;
        
        indices_value = null;
    }
    /** @apilevel internal */
    protected boolean indices_computed = false;

    /** @apilevel internal */
    protected Indices indices_value;

    /**
     * Get the set of all array indices of an array access. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2240
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2240")
    public Indices indices() {
        ASTState state = state();
        if (indices_computed) {
            return indices_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        indices_value = Indices.create(size());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        indices_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return indices_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2812
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2812")
    public String formatSpecifier() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * Addition of constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4164")
    public CValue add(CValue v1, CValue v2) {
        CValue add_CValue_CValue_value = CValue.UNKNOWN;
        return add_CValue_CValue_value;
    }
    /**
     * Subtraction of constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4194
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4194")
    public CValue sub(CValue v1, CValue v2) {
        CValue sub_CValue_CValue_value = CValue.UNKNOWN;
        return sub_CValue_CValue_value;
    }
    /**
     * Multiplication of constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4217
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4217")
    public CValue mul(CValue v1, CValue v2) {
        CValue mul_CValue_CValue_value = CValue.UNKNOWN;
        return mul_CValue_CValue_value;
    }
    /**
     * Division of constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4240
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4240")
    public CValue div(CValue v1, CValue v2) {
        CValue div_CValue_CValue_value = CValue.UNKNOWN;
        return div_CValue_CValue_value;
    }
    /**
     * Power expression for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4263")
    public CValue pow(CValue v1, CValue v2) {
        CValue pow_CValue_CValue_value = CValue.UNKNOWN;
        return pow_CValue_CValue_value;
    }
    /**
     * Negation of a constant value.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4278")
    public CValue neg(CValue v) {
        CValue neg_CValue_value = CValue.UNKNOWN;
        return neg_CValue_value;
    }
    /**
     * Abs expression for constant values.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4288
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4288")
    public CValue abs(CValue v) {
        CValue abs_CValue_value = CValue.UNKNOWN;
        return abs_CValue_value;
    }
    /**
     * Sign expression for constant values.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4299")
    public CValue sign(CValue v) {
        CValue sign_CValue_value = CValue.UNKNOWN;
        return sign_CValue_value;
    }
    /**
     * Ceil expression for constant values.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4310")
    public CValue ceil(CValue v) {
        CValue ceil_CValue_value = CValue.UNKNOWN;
        return ceil_CValue_value;
    }
    /**
     * Truncation to zero for constant values.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4323
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4323")
    public CValue truncToZero(CValue v) {
        CValue truncToZero_CValue_value = CValue.UNKNOWN;
        return truncToZero_CValue_value;
    }
    /**
     * And expression for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4346
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4346")
    public CValue and(CValue v1, CValue v2) {
        CValue and_CValue_CValue_value = CValue.UNKNOWN;
        return and_CValue_CValue_value;
    }
    /**
     * Or expression for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4362")
    public CValue or(CValue v1, CValue v2) {
        CValue or_CValue_CValue_value = CValue.UNKNOWN;
        return or_CValue_CValue_value;
    }
    /**
     * Not expression for constant values.
     * 
     * @param v Constant value of operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4377")
    public CValue not(CValue v) {
        CValue not_CValue_value = CValue.UNKNOWN;
        return not_CValue_value;
    }
    /**
     * Equals comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4399")
    public CValue equ(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() == v2.intValue());
            }
    }
    /**
     * Not equal comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4429
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4429")
    public CValue neq(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() != v2.intValue());
            }
    }
    /**
     * Greater or equal than comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4459
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4459")
    public CValue geq(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() >= v2.intValue());
            }
    }
    /**
     * Greater than comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4489
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4489")
    public CValue gt(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() > v2.intValue());
            }
    }
    /**
     * Less or equal than comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4519
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4519")
    public CValue leq(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() <= v2.intValue());
            }
    }
    /**
     * Less than comparison for constant values.
     * 
     * @param v1 Constant value of left operand.
     * @param v2 Constant value of right operand.
     * @return Resulting constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4549
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4549")
    public CValue lt(CValue v1, CValue v2) {
        {
                if (!v1.hasIntValue() || !v2.hasIntValue()) {
                    return CValue.UNKNOWN;
                }
                return new CValueBoolean(v1.intValue() < v2.intValue());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1083
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1083")
    public FClass.ZType genType() {
        FClass.ZType genType_value = null;
        return genType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1873
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1873")
    public int numScalarElements() {
        int numScalarElements_value = size().numElements();
        return numScalarElements_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3136
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3136")
    public boolean isComposite() {
        boolean isComposite_value = isArray() || isRecord();
        return isComposite_value;
    }
    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:298
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:298")
    public FRecordDecl myFRecordDecl() {
        FRecordDecl myFRecordDecl_value = null;
        return myFRecordDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:301
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:301")
    public FFunctionDecl myFFunctionDecl() {
        FFunctionDecl myFFunctionDecl_value = null;
        return myFFunctionDecl_value;
    }
    /** @apilevel internal */
    private void myFEnumDecl_reset() {
        myFEnumDecl_computed = false;
        
        myFEnumDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFEnumDecl_computed = false;

    /** @apilevel internal */
    protected FEnumDecl myFEnumDecl_value;

    /**
     * @attribute syn
     * @aspect FlatEnumBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:331
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:331")
    public FEnumDecl myFEnumDecl() {
        ASTState state = state();
        if (myFEnumDecl_computed) {
            return myFEnumDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFEnumDecl_value = null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFEnumDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFEnumDecl_value;
    }
    /**
     * Returns a string (tersely) describing this type.
     * 
     * @see FFunctionDecl#signatureString()
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1398
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1398")
    public String signatureString() {
        String signatureString_value = "-";
        return signatureString_value;
    }
    /**
     * @attribute syn
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:956
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:956")
    public String toString() {
        String toString_value = isArray() ? name() + size() : name();
        return toString_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeInterface
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeInterface", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:57")
    public FType asFType() {
        FType asFType_value = this;
        return asFType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeInterface
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:58
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeInterface", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:58")
    public FType expand(Size size) {
        FType expand_Size_value = sizedType(size().expand(size));
        return expand_Size_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeInterface
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeInterface", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:59")
    public FType contract(int ndims) {
        FType contract_int_value = sizedType(size().contractLeft(ndims));
        return contract_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:508
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:508")
    public boolean canBeRange() {
        boolean canBeRange_value = false;
        return canBeRange_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:688
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:688")
    public boolean isNoType() {
        boolean isNoType_value = false;
        return isNoType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:794
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:794")
    public FType component(int i) {
        FType component_int_value = fUnknownType();
        return component_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:797
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:797")
    public FType nullUnknown(FRecordComponentType t) {
        FType nullUnknown_FRecordComponentType_value = t == null ? fUnknownType() : t.getFType();
        return nullUnknown_FRecordComponentType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:799
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:799")
    public FType vectorized(Size s) {
        {
                if (s == Size.SCALAR) {
                    return this;
                }
                MutableSize s2 = s.mutableClone();
                s2.append(getSize());
                return sizedType(s2);
            }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:850
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:850")
    public FType cell(Index index) {
        {
                if (index.ndims() == 0) {
                    return this;
                }
                if (indices().isValid(index)) {
                    return scalarType();
                }
                return FUnknownType.SCALAR;
            }
    }
    /**
     * Combine two types to the broadest common denominator.
     * 
     * If types are not compatible, the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:872
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:872")
    public FType typePromotion(FType type) {
        FType typePromotion_FType_value = typePromotion(type, false, null);
        return typePromotion_FType_value;
    }
    /**
     * Combine two types to the broadest common denominator.
     * 
     * If scalar types are not compatible or if both are array and sizes 
     * doesn't match, the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:881
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:881")
    public FType looseTypePromotion(FType type) {
        FType looseTypePromotion_FType_value = looseTypePromotion(type, false, null);
        return looseTypePromotion_FType_value;
    }
    /**
     * Combine two types to the broadest common numeric denominator.
     * 
     * If either is non-numeric or if sizes doesn't match, 
     * the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:890
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:890")
    public FType numericPromotion(FType type) {
        FType numericPromotion_FType_value = numericPromotion(type, false, null);
        return numericPromotion_FType_value;
    }
    /**
     * Combine two types to the broadest common numeric denominator.
     * 
     * If either is non-numeric or if both are array and sizes doesn't match, 
     * the unknown type is returned. 
     * An integer type combined with a real type results in a real type.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:899
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:899")
    public FType looseNumericPromotion(FType type) {
        FType looseNumericPromotion_FType_value = looseNumericPromotion(type, false, null);
        return looseNumericPromotion_FType_value;
    }
    /**
     * Combine two types to the broadest common denominator.
     * 
     * If types are not compatible, the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * If <code>allowUnknown</code> is <code>true</code>, then unknown 
     * lengths are considered equal to any length. If non-<code>null</code>, 
     * <code>operator</code> defines what operator to use in operator 
     * overloading.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:911
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:911")
    public FType typePromotion(FType type, boolean allowUnknown, String operator) {
        {
                if ((isOperatorRecord() || type.isOperatorRecord()) && operator != null) {
                    return matchOverloadedOperatorType(type, operator, false, allowUnknown);
                } else if (isNumeric()) {
                    return numericPromotion(type, allowUnknown, operator);
                } else if (!equivalentTo(type, allowUnknown)) {
                    if (isRecord()) {
                        return mergeRecordType(type);
                    }
                    return fUnknownType();
                } else {
                    return this;
                }
            }
    }
    /**
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:926
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:926")
    public FType mergeRecordType(FType other) {
        {
                FType res = treeCopy();
                res.setSize(getSize().mergeRecordType(other.getSize()));
                return res;
            }
    }
    /**
     * Combine two types to the broadest common denominator.
     * 
     * If scalar types are not compatible or if both are array and sizes 
     * doesn't match, the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * If <code>allowUnknown</code> is <code>true</code>, then unknown 
     * lengths are considered equal to any length. If non-<code>null</code>, 
     * <code>operator</code> defines what operator to use in operator 
     * overloading.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:998
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:998")
    public FType looseTypePromotion(FType type, boolean allowUnknown, String operator) {
        {
                if ((isOperatorRecord() || type.isOperatorRecord()) && operator != null) {
                    return matchOverloadedOperatorType(type, operator, true, allowUnknown);
                } else if (looslyDimensionCompatible(type, allowUnknown)) {
                    FType scalar = scalarType().typePromotion(type.scalarType(), false, operator);
                    return scalar.sizedType(isScalar() ? type.size() : size());
                } else {
                    return fUnknownType();
                }
            }
    }
    /**
     * Combine two types to the broadest common numeric denominator.
     * 
     * If either is non-numeric or if sizes doesn't match, 
     * the unknown type is returned. Operator records with suitable 
     * overloaded operators are considered numeric for this purpose.
     * An integer type combined with a real type results in a real type.
     * If <code>allowUnknown</code> is <code>true</code>, then unknown 
     * lengths are considered equal to any length. If non-<code>null</code>, 
     * <code>operator</code> defines what operator to use in operator 
     * overloading.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1021
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1021")
    public FType numericPromotion(FType type, boolean allowUnknown, String operator) {
        {
                if (isOperatorRecord() || type.isOperatorRecord()) {
                    return matchOverloadedOperatorType(type, operator, false, allowUnknown);
                } else if (dimensionCompatible(type, allowUnknown)) {
                    return scalarNumericPromotion(type, operator).arrayType(size());
                } else {
                    return fUnknownType();
                }
            }
    }
    /**
     * Combine two types to the broadest common numeric denominator.
     * 
     * If either is non-numeric or if both are array and sizes doesn't match, 
     * the unknown type is returned. Operator records with suitable 
     * overloaded operators are considered numeric for this purpose.
     * An integer type combined with a real type results in a real type.
     * If <code>allowUnknown</code> is <code>true</code>, then unknown 
     * lengths are considered equal to any length. If non-<code>null</code>, 
     * <code>operator</code> defines what operator to use in operator 
     * overloading.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1043
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1043")
    public FType looseNumericPromotion(FType type, boolean allowUnknown, String operator) {
        {
                if (isOperatorRecord() || type.isOperatorRecord()) {
                    return matchOverloadedOperatorType(type, operator, true, allowUnknown);
                } else if (looslyDimensionCompatible(type, allowUnknown)) {
                    return scalarNumericPromotion(type, operator).sizedType(isScalar() ? type.size() : size());
                } else {
                    return fUnknownType();
                }
            }
    }
    /**
     * Combine two types to the broadest common scalar numeric denominator.
     * 
     * If either is non-numeric, the unknown type is returned.
     * An integer type combined with a real type results in a real type.
     * If non-<code>null</code>, <code>operator</code> defines what operator 
     * to use in operator overloading.
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1061
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1061")
    public FType scalarNumericPromotion(FType type, String operator) {
        FType scalarNumericPromotion_FType_String_value = scalarType().matchOverloadedOperatorType(type.scalarType(), operator, false, false);
        return scalarNumericPromotion_FType_String_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1080
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1080")
    public boolean typeCompatible(CommonType type) {
        boolean typeCompatible_CommonType_value = typeCompatible(type, false);
        return typeCompatible_CommonType_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082")
    public boolean typeCompatible(CommonType type, boolean allowUnknown) {
        boolean typeCompatible_CommonType_boolean_value = false;
        return typeCompatible_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100")
    public boolean typeMatches(CommonType type, boolean compatible, boolean allowUnknown) {
        boolean typeMatches_CommonType_boolean_boolean_value = compatible ? typeCompatible(type, allowUnknown) : equivalentTo(type, allowUnknown);
        return typeMatches_CommonType_boolean_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1148
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1148")
    public boolean typeMatches(Iterable<FRecordComponentType> comps1, Iterable<FRecordComponentType> comps2, boolean compatible, boolean allowUnknown) {
        {
                Iterator<FRecordComponentType> i1 = comps1.iterator();
                Iterator<FRecordComponentType> i2 = comps2.iterator();
                while (i1.hasNext()) {
                    if (!i1.next().typeMatches(i2.next(), compatible, allowUnknown))
                        return false;
                }
                return true;
            }
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1163
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1163")
    public boolean dimensionCompatible(CommonType type) {
        boolean dimensionCompatible_CommonType_value = dimensionCompatible(type, false);
        return dimensionCompatible_CommonType_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1164")
    public boolean dimensionCompatible(CommonType type, boolean allowUnknown) {
        boolean dimensionCompatible_CommonType_boolean_value = size().equivalent(type.size(), allowUnknown);
        return dimensionCompatible_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1167
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1167")
    public boolean looslyDimensionCompatible(FType type, boolean allowUnknown) {
        boolean looslyDimensionCompatible_FType_boolean_value = isScalar() || type.isScalar() || dimensionCompatible(type, allowUnknown);
        return looslyDimensionCompatible_FType_boolean_value;
    }
    /**
     * Check if types are compatible except for array lengths, i.e. if the scalar types and the number of array 
     * dimensions are the same.
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1174
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1174")
    public boolean typeCompatibleExceptLengths(FType type) {
        boolean typeCompatibleExceptLengths_FType_value = ndims() == type.ndims() && scalarType().typeCompatible(type.scalarType());
        return typeCompatibleExceptLengths_FType_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeEquivalent
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1186
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeEquivalent", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1186")
    public boolean equivalentTo(CommonType type) {
        boolean equivalentTo_CommonType_value = equivalentTo(type, false);
        return equivalentTo_CommonType_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeEquivalent
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeEquivalent", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188")
    public boolean equivalentTo(CommonType type, boolean allowUnknown) {
        boolean equivalentTo_CommonType_boolean_value = false;
        return equivalentTo_CommonType_boolean_value;
    }
    /**
     * Check if types are equivalent except for array lengths, i.e. if the scalar types and the number of array 
     * dimensions are the same.
     * @attribute syn
     * @aspect FTypeEquivalent
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1208
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeEquivalent", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1208")
    public boolean equivalentExceptLengths(FType type) {
        boolean equivalentExceptLengths_FType_value = ndims() == type.ndims() && scalarType().equivalentTo(type.scalarType());
        return equivalentExceptLengths_FType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1223")
    public boolean isReal() {
        boolean isReal_value = false;
        return isReal_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1226
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1226")
    public boolean isInteger() {
        boolean isInteger_value = false;
        return isInteger_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1229
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1229")
    public boolean isBoolean() {
        boolean isBoolean_value = false;
        return isBoolean_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1232
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1232")
    public boolean isString() {
        boolean isString_value = false;
        return isString_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1235
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1235")
    public boolean isRecord() {
        boolean isRecord_value = false;
        return isRecord_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1237
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1237")
    public boolean isOperatorRecord() {
        boolean isOperatorRecord_value = false;
        return isOperatorRecord_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1239
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1239")
    public boolean isEnum() {
        boolean isEnum_value = false;
        return isEnum_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1242
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1242")
    public boolean isExternalObject() {
        boolean isExternalObject_value = false;
        return isExternalObject_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1244
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1244")
    public boolean isFunction() {
        boolean isFunction_value = false;
        return isFunction_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1247
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1247")
    public boolean isArray() {
        boolean isArray_value = getSize() != Size.SCALAR;
        return isArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1248
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1248")
    public boolean isScalar() {
        boolean isScalar_value = getSize() == Size.SCALAR;
        return isScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1250")
    public boolean isNumeric() {
        boolean isNumeric_value = false;
        return isNumeric_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1254")
    public boolean isPrimitive() {
        boolean isPrimitive_value = false;
        return isPrimitive_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1257
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1257")
    public boolean isRealScalar() {
        boolean isRealScalar_value = isScalar() && isReal();
        return isRealScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1258")
    public boolean isRealArray() {
        boolean isRealArray_value = isReal() && isArray();
        return isRealArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1259
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1259")
    public boolean isIntegerScalar() {
        boolean isIntegerScalar_value = isScalar() && isInteger();
        return isIntegerScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1260")
    public boolean isIntegerArray() {
        boolean isIntegerArray_value = isInteger() && isArray();
        return isIntegerArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1261")
    public boolean isBooleanScalar() {
        boolean isBooleanScalar_value = isScalar() && isBoolean();
        return isBooleanScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1262
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1262")
    public boolean isBooleanArray() {
        boolean isBooleanArray_value = isBoolean() && isArray();
        return isBooleanArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1263")
    public boolean isStringScalar() {
        boolean isStringScalar_value = isScalar() && isString();
        return isStringScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1264
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1264")
    public boolean isStringArray() {
        boolean isStringArray_value = isString() && isArray();
        return isStringArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1265
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1265")
    public boolean isRecordScalar() {
        boolean isRecordScalar_value = isScalar() && isRecord();
        return isRecordScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1266")
    public boolean isRecordArray() {
        boolean isRecordArray_value = isRecord() && isArray();
        return isRecordArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1267")
    public boolean isEnumScalar() {
        boolean isEnumScalar_value = isScalar() && isEnum();
        return isEnumScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1268")
    public boolean isEnumArray() {
        boolean isEnumArray_value = isEnum() && isArray();
        return isEnumArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1269
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1269")
    public boolean isNumericScalar() {
        boolean isNumericScalar_value = isScalar() && isNumeric();
        return isNumericScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1270
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1270")
    public boolean isNumericArray() {
        boolean isNumericArray_value = isNumeric() && isArray();
        return isNumericArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1271")
    public boolean isPrimitiveScalar() {
        boolean isPrimitiveScalar_value = isScalar() && isPrimitive();
        return isPrimitiveScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1272")
    public boolean isPrimitiveArray() {
        boolean isPrimitiveArray_value = isPrimitive() && isArray();
        return isPrimitiveArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1273
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1273")
    public boolean isExternalObjectScalar() {
        boolean isExternalObjectScalar_value = isScalar() && isExternalObject();
        return isExternalObjectScalar_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1274
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1274")
    public boolean isExternalObjectArray() {
        boolean isExternalObjectArray_value = isExternalObject() && isArray();
        return isExternalObjectArray_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1301
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1301")
    public boolean containsReal() {
        boolean containsReal_value = containsType(FRealType.SCALAR);
        return containsReal_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1302
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1302")
    public boolean containsInteger() {
        boolean containsInteger_value = containsType(FIntegerType.SCALAR);
        return containsInteger_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1303
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1303")
    public boolean containsBoolean() {
        boolean containsBoolean_value = containsType(FBooleanType.SCALAR);
        return containsBoolean_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1327
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1327")
    public boolean onlyContainsReal() {
        boolean onlyContainsReal_value = recursiveTypeCheck(IS_REAL);
        return onlyContainsReal_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1329
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1329")
    public boolean hasAdd() {
        boolean hasAdd_value = false;
        return hasAdd_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1333
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1333")
    public boolean hasNeg() {
        boolean hasNeg_value = false;
        return hasNeg_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1336
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1336")
    public boolean canBeIndex() {
        boolean canBeIndex_value = false;
        return canBeIndex_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1341
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1341")
    public int ndims() {
        int ndims_value = getSize().ndims();
        return ndims_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1343")
    public Size size() {
        Size size_value = getSize();
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1345")
    public FType sizedType(Size s) {
        FType sizedType_Size_value = (s == Size.SCALAR) ? scalarType() : arrayType(s);
        return sizedType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1348")
    public FType scalarType() {
        {
                if (isScalar() && !isFunction())
                    return this;
                FType copy = (FType) fullCopy();
                copy.setSize(Size.SCALAR);
                return copy;
            }
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1363")
    public boolean isUnknown() {
        boolean isUnknown_value = false;
        return isUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1388
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1388")
    public FType arrayType(Size size) {
        {
                if (size == size())
                    return this;
                FType copy = (FType) fullCopy();
                copy.setSize(size);
                return copy;
            }
    }
    /**
     * @attribute syn
     * @aspect AliasTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1538
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1538")
    public boolean typeAliasCompatible(FType type) {
        boolean typeAliasCompatible_FType_value = typeCompatible(type);
        return typeAliasCompatible_FType_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:261")
    public TypePrefixVariability funcOutputVariability() {
        TypePrefixVariability funcOutputVariability_value = Variability.DISCRETE;
        return funcOutputVariability_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:362")
    public boolean compatibleConstructor(InstClassDecl icd) {
        boolean compatibleConstructor_InstClassDecl_value = false;
        return compatibleConstructor_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:364
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:364")
    public boolean compatibleDestructor(InstClassDecl icd) {
        boolean compatibleDestructor_InstClassDecl_value = false;
        return compatibleDestructor_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:794
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:794")
    public boolean externalValid() {
        boolean externalValid_value = externalValid(false);
        return externalValid_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795")
    public boolean externalValid(boolean rec) {
        boolean externalValid_boolean_value = false;
        return externalValid_boolean_value;
    }
    /**
     * Calculate the type of an operator expression involving operator records.
     * 
     * For binary expressions <code>this</code> should be the left hand side.
     * 
     * @param right     the type of the right-hand side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @param loose     <code>true</code> if dimensions should be matched loosely
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:143
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:143")
    public FType matchOverloadedOperatorType(FType right, String operator, boolean loose, boolean allowUnknown) {
        {
                FType res = matchOverloadedOperatorType(right, operator);
                if (res.isUnknown() && (isArray() || right.isArray())) {
                    if (loose ? looslyDimensionCompatible(right, allowUnknown) : dimensionCompatible(right, allowUnknown)) {
                        FType scalar = scalarType().matchOverloadedOperatorType(right.scalarType(), operator);
                        res = scalar.sizedType(isScalar() ? right.size() : size());
                    }
                }
                return res;
            }
    }
    /**
     * Calculate the type of an operator expression involving operator records.
     * 
     * For binary expressions <code>this</code> should be the left hand side.
     * 
     * @param right     the type of the right-hand side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:163
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:163")
    public FType matchOverloadedOperatorType(FType right, String operator) {
        {
                InstClassDecl func = matchOverloadedOperator(right, operator);
                return (func == null) ? fUnknownType() : func.myOutputs().get(0).type();
            }
    }
    /**
     * Calculate the function to use for an operator expression involving operator records.
     * 
     * Returns null if none or more than one function matches or expression does not include operator records.
     * For binary expressions <code>this</code> should be the left hand side.
     * 
     * @param right     the type of the right-hand side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:244
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:244")
    public InstClassDecl matchOverloadedOperator(FType right, String operator) {
        InstClassDecl matchOverloadedOperator_FType_String_value = matchOverloadedOperator(right, operator, true);
        return matchOverloadedOperator_FType_String_value;
    }
    /**
     * Calculate the function to use for an operator expression involving operator records.
     * 
     * Returns null if none or more than one function matches or expression does not include operator records.
     * 
     * @param other     the type of the other side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @param isLeft    <code>true</code> if this type was on the left hand side of the expression, 
     * must be <code>true</code> for unary operators
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:257
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:257")
    public InstClassDecl matchOverloadedOperator(FType other, String operator, boolean isLeft) {
        {
                Collection<InstClassDecl> match = matchOverloadedOperators(other, operator, isLeft);
                return (match.size() == 1) ? match.iterator().next() : null;
            }
    }
    /**
     * Calculate the functions that match an operator expression involving operator records.
     * 
     * If expression does not include operator records, the empty set is returned.
     * For binary expressions <code>this</code> should be the left hand side.
     * 
     * @param right     the type of the right-hand side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:271")
    public Collection<InstClassDecl> matchOverloadedOperators(FType right, String operator) {
        Collection<InstClassDecl> matchOverloadedOperators_FType_String_value = matchOverloadedOperators(right, operator, true);
        return matchOverloadedOperators_FType_String_value;
    }
    /**
     * Calculate the functions that match an operator expression involving operator records.
     * 
     * If expression does not include operator records, the empty set is returned.
     * 
     * @param other     the type of the other side of the expression, <code>null</code> for unary operators
     * @param operator  the name of the operator to look for
     * @param isLeft    <code>true</code> if this type was on the left hand side of the expression, 
     * must be <code>true</code> for unary operators
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:284
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:284")
    public Collection<InstClassDecl> matchOverloadedOperators(FType other, String operator, boolean isLeft) {
        Collection<InstClassDecl> matchOverloadedOperators_FType_String_boolean_value = (other != null && other.isOperatorRecord()) ? 
                        other.matchOverloadedOperators(this, operator, !isLeft) : 
                        Collections.<InstClassDecl>emptyList();
        return matchOverloadedOperators_FType_String_boolean_value;
    }
    /**
     * Find the constructor to use to convert a given type to this type.
     * 
     * Returns null if none or more than one constructor matches or this is not a operator record type.
     * 
     * @param other     the type to convert
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:308
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:308")
    public InstClassDecl matchOverloadedConstructor(FType other) {
        InstClassDecl matchOverloadedConstructor_FType_value = null;
        return matchOverloadedConstructor_FType_value;
    }
    /**
     * Find the constructors that match for a conversion a given type to this type.
     * 
     * If this is not a operator record type, the empty set is returned.
     * 
     * @param other     the type to convert
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:321")
    public Collection<InstClassDecl> matchOverloadedConstructors(FType other) {
        Collection<InstClassDecl> matchOverloadedConstructors_FType_value = null;
        return matchOverloadedConstructors_FType_value;
    }
    /**
     * Find the zero function for an operator record type.
     * 
     * Returns null if none or more than one constructor matches or this is not a operator record type.
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:330")
    public InstClassDecl matchOverloadedZero() {
        InstClassDecl matchOverloadedZero_value = null;
        return matchOverloadedZero_value;
    }
    /**
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:517
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:517")
    public Map<String,InstClassDecl> getOperators() {
        Map<String,InstClassDecl> getOperators_value = Collections.emptyMap();
        return getOperators_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1394
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1394")
    public boolean isEmpty() {
        boolean isEmpty_value = size().isEmpty();
        return isEmpty_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1395
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1395")
    public FExp createEmptyExp() {
        {
                Size s = size();
                List<FExp> dims = new List<FExp>();
                for (int i = 0, n = s.ndims(); i < n ; i++) {
                    dims.add(s.createFExp(i));
                }
                return new FFillExp(dims, zeroLiteral());
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:274
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:274")
    public String arrayAccess(int nd, String name, String ind) {
        {
                return String.format("jmi_array_%s_%d(%s, %s)", isRecord() ? C_ARRAY_RECORD : C_ARRAY_REFERENCE, 
                        nd, name, ind);
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenAlgorithms", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:427")
    public String enumNames_C() {
        String enumNames_C_value = null;
        return enumNames_C_value;
    }
    /**
     * The maximum length string representations of values of this type can have in C.
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1086
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1086")
    public int maxStringLength_C(int precision) {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1099
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1099")
    public int maxNumericStringLength_C(int precision) {
        {
                return 10 + precision;
            }
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:513
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:513")
    public String memcpyObject() {
        {
                throw new InternalCompilerError("FType.memcpyObject() is not implemented for " + getClass().getSimpleName());
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:34
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:34")
    public String type_C(CodePrinter p) {
        String type_C_CodePrinter_value = isArray() ? arrayType_C(p) : scalarType_C(p);
        return type_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:36
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:36")
    public String scalarType_C(CodePrinter p) {
        String scalarType_C_CodePrinter_value = nameScalar_C(p);
        return scalarType_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:39
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:39")
    public String arrayType_C(CodePrinter p) {
        String arrayType_C_CodePrinter_value = nameArray_C(p) + "*";
        return arrayType_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:41
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:41")
    public String nameScalar_C(CodePrinter p, boolean external) {
        String nameScalar_C_CodePrinter_boolean_value = external ? nameScalarExt_C(p) : nameScalar_C(p);
        return nameScalar_C_CodePrinter_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:42
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:42")
    public String nameArray_C(CodePrinter p, boolean external) {
        String nameArray_C_CodePrinter_boolean_value = external ? nameArrayExt_C(p) : nameArray_C(p);
        return nameArray_C_CodePrinter_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:96
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:96")
    public boolean isArgTypeBaseRef() {
        boolean isArgTypeBaseRef_value = false;
        return isArgTypeBaseRef_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:102")
    public String macroType() {
        String macroType_value = macroTypeScalar() + (isArray() ? "_ARR" : "");
        return macroType_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:104")
    public String macroTypeScalar() {
        String macroTypeScalar_value = "GEN";
        return macroTypeScalar_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:108")
    public String macroTypeDecl(boolean external) {
        String macroTypeDecl_boolean_value = external ? macroTypeDeclScalar() + "_EXT" : macroTypeDeclScalar();
        return macroTypeDecl_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:65")
    public String exportWrapperType_C() {
        String exportWrapperType_C_value = "void";
        return exportWrapperType_C_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2316
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2316")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:31
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:31")
    public InstLookupResult<InstClassDecl> lookupInstClass(String name) {
        InstLookupResult<InstClassDecl> lookupInstClass_String_value = getParent().Define_lookupInstClass(this, null, name);
        return lookupInstClass_String_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
