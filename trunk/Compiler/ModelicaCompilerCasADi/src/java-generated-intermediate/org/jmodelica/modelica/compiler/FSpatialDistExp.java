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
 * The spatialDistribution() operator.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1325
 * @astdecl FSpatialDistExp : FBuiltInFunctionCall ::= In0:FExp In1:FExp X:FExp PositiveVelocity:FExp InitialPoints:FExp InitialValues:FExp;
 * @production FSpatialDistExp : {@link FBuiltInFunctionCall} ::= <span class="component">In0:{@link FExp}</span> <span class="component">In1:{@link FExp}</span> <span class="component">X:{@link FExp}</span> <span class="component">PositiveVelocity:{@link FExp}</span> <span class="component">InitialPoints:{@link FExp}</span> <span class="component">InitialValues:{@link FExp}</span>;

 */
public class FSpatialDistExp extends FBuiltInFunctionCall implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2514
     */
    public CValue[] evaluate(VariableEvaluator evaluator) {
        CValue[] res = new CValue[2];
        CValueArray vals = getInitialValues().ceval(evaluator).array();
        if (getPositiveVelocity().ceval(evaluator).booleanValue()) {
            res[1] = vals.getCell(vals.values.length-1);
            res[0] = vals.getCell(0);
        } else {
            res[0] = vals.getCell(vals.values.length-1);
            res[1] = vals.getCell(0);
        }
        return res;
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:959
     */
    public FSpatialDistExp createEmptyNode() { return new FSpatialDistExp(); }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1419
     */
    public FSpatialDistExp(FExp a1, FExp a2, FExp a3, FExp a4, FExp a5, FExp a6) { 
        this(emptyArgs(), a1, a2, a3, a4, a5, a6);
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2511
     */
    public FExp createInitialReplacement(boolean second) {
        int size = getInitialValues().size().numElements();
        return new FIfExp(getPositiveVelocity().copySymbolic(),
                getInitialValues().getArray().get(second ? size : 1).copySymbolic(), 
                getInitialValues().getArray().get(second ? 1 : size).copySymbolic());
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:197
     */
    public void complianceCheck(ErrorCheckType checkType) {
        ONLY_FMU_FUNCTION_LIKE_OPERATOR.invoke(this, "spatialDistribution");
        FAbstractEquation equation = myFEquation();
        if (isArray() && equation != null && equation instanceof FFunctionCallEquation) {
            INCORRECT_USE_OF_SPATIAL_DISTRIBUTION.invoke(this);
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1376
     */
    public void typeCheck(ErrorCheckType checkType) {
        super.typeCheck(checkType);
        if (!getIn0().size().equivalent(getIn1().size(), true)) {
            errorUnlessDisabledAnd(getIn0().ndims() == getIn1().ndims(), 
                    "Calling function spatialDistribution(): first and second arguments 'in0' and 'in1' needs equivalent sizes");
        }
        if (isArray()) {
            if (getX().isArray()) {
                error("Calling function spatialDistribution(): third argument 'x' cannot be vectorized");
            }
            if (getPositiveVelocity().isArray()) {
                error("Calling function spatialDistribution(): fourth argument 'positiveVelocity' cannot be vectorized");
            }
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2621
     */
    public FExp flatten(Flattener f)     {
        return new FSpatialDistExp(
            getIn0().flatten(f), getIn1().flatten(f), 
            getX().flatten(f), getPositiveVelocity().flatten(f),
            getInitialPoints().flatten(f), getInitialValues().flatten(f)
        );
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1923
     */
    public FSpatialDistExp scalarizeExp(Scalarizer s) {
        return new FSpatialDistExp(getIn0().scalarize(s), getIn1().scalarize(s),
                getX().scalarize(s), getPositiveVelocity().scalarize(s),
                getInitialPoints().scalarize(s), getInitialValues().scalarize(s));
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:507
     */
    @Override
    protected FExp diffExp(String name) {
        throw new FunctionDifferentiationException(this);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:357
     */
    private FSpatialDistExp originalFSpatialDistExp = null;
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:368
     */
    public void setOriginalFExp(FSpatialDistExp original) { this.originalFSpatialDistExp = original; }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:402
     */
    @Override
    protected void resetOriginalReferences() {
        setOriginalFExp(this);
        super.resetOriginalReferences();
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:432
     */
    @Override
    protected void traverseSymbolic(ASTNode e) {
        setOriginalFExp(((FSpatialDistExp)e).originalFExp());
        super.traverseSymbolic(e);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:522
     */
    @Override
    public void genEventResidualVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (!p.inInitialSystem()) {
            p.printVarDecls(getX(), str, indent);
            p.printVarDecls(getPositiveVelocity(), str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:561
     */
    @Override
    public void genEventResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator) {
        if (p.inInitialSystem()) {
            str.formatln("%s(*res)[%d] = JMI_DELAY_INITIAL_EVENT_RES;", indent, enumerator.next());
        } else {
            p.printPreSteps(getX(), str, indent);
            p.printPreSteps(getPositiveVelocity(), str, indent);
            int index = mySpatialDistIndex();
            str.format("%sef = jmi_spatialdist_event_indicator(jmi, %d, ", indent, index);
            p.print(getX(), str, indent);
            str.print(", ");
            p.print(getPositiveVelocity(), str, indent);
            str.print(", &(*res)[" + enumerator.next() + "]);\n");
            p.printPostSteps(getX(), str, indent);
            p.printPostSteps(getPositiveVelocity(), str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:850
     */
    @Override
    public void genRelExpKind(CodeStream str) {
        str.print(FRelExp.GEQ_C);
    }
    /**
     * Generate temp declarations for the initialization of spatialDistribution blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1413
     */
    public void genInitVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        getX().genTempArg(p.DeclStep, str, indent);
        getInitialPoints().genTempArg(p.DeclStep, str, indent);
        getInitialValues().genTempArg(p.DeclStep, str, indent);
    }
    /**
     * Generate the initialization of spatialDistribution blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1422
     */
    public void genInit_C(CodePrinter p, CodeStream str, String indent) {
        
        //int jmi_spatialdist_init(jmi_t *jmi, int index, jmi_boolean no_event,
        // jmi_real_t x0, jmi_real_t *x_init, jmi_real_t *y_init, int n_init);
        
        getX().genTempArg(p.PreStep, str, indent);
        getInitialPoints().genTempArg(p.PreStep, str, indent);
        getInitialValues().genTempArg(p.PreStep, str, indent);
        
        str.format("%sjmi_spatialdist_init(jmi, %d, ", indent, mySpatialDistIndex());
        str.print(boolValue_C(!generatesEventInDAE())); // jmi_boolean no_event
        str.print(", "); 
        p.print(getX(), str, indent); // jmi_real_t x0,
        str.print(", "); 
        getInitialPoints().genTempArg(p.ExecStep, str, indent); // jmi_real_t *x_init
        str.print(", ");
        getInitialValues().genTempArg(p.ExecStep, str, indent); // jmi_real_t *y_init
        str.println(");");
        
        getX().genTempArg(p.PostStep, str, indent);
        getInitialPoints().genTempArg(p.PostStep, str, indent);
        getInitialValues().genTempArg(p.PostStep, str, indent);
    }
    /**
     * Generate temp declarations for the sampling of spatialDistribution blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1449
     */
    public void genSampleVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        p.printVarDecls(getIn0(), str, indent);
        p.printVarDecls(getIn1(), str, indent);
        p.printVarDecls(getX(), str, indent);
        p.printVarDecls(getPositiveVelocity(), str, indent);
    }
    /**
     * Generate the sampling of spatialDistribution blocks.
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1459
     */
    public void genSample_C(CodePrinter p, CodeStream str, String indent) {
//        int jmi_spatialdist_record_sample(jmi_t *jmi, int index, jmi_real_t in0,
//              jmi_real_t in1, jmi_real_t x, jmi_boolean positiveVelocity);
        
        p.printPreSteps(getIn0(), str, indent);
        p.printPreSteps(getIn1(), str, indent);
        p.printPreSteps(getX(), str, indent);
        p.printPreSteps(getPositiveVelocity(), str, indent);
            
        str.format("%sjmi_spatialdist_record_sample(jmi, %d, ", indent, mySpatialDistIndex());
        p.print(getIn0(), str, indent);
        str.print(", ");
        p.print(getIn1(), str, indent);
        str.print(", ");
        p.print(getX(), str, indent);
        str.print(", ");
        p.print(getPositiveVelocity(), str, indent);
        str.println(");");
        
        p.printPostSteps(getIn0(), str, indent);
        p.printPostSteps(getIn1(), str, indent);
        p.printPostSteps(getX(), str, indent);
        p.printPostSteps(getPositiveVelocity(), str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1484
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        p.printVarDecls(getIn0(), str, indent);
        p.printVarDecls(getIn1(), str, indent);
        p.printVarDecls(getX(), str, indent);
        p.printVarDecls(getPositiveVelocity(), str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1492
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(getIn0(), str, indent);
        p.printPreSteps(getIn1(), str, indent);
        p.printPreSteps(getX(), str, indent);
        p.printPreSteps(getPositiveVelocity(), str, indent);
        if (!functionCallIsExp()) {// printed later if part of expression
            p.print(this, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1503
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
//        int jmi_spatialdist_evaluate(jmi_t *jmi, int index, jmi_real_t *out0,
//            jmi_real_t *out1, jmi_real_t in0, jmi_real_t in1, jmi_real_t x, 
//            jmi_boolean positiveVelocity);
        
        boolean exp = functionCallIsExp();
        if (!exp) {
            str.print(indent);
        }
        str.format("jmi_spatialdist_evaluate(jmi, %d, ", mySpatialDistIndex());
        if (exp) {
            str.print("NULL, NULL");
        } else {
            prettyPrintCallOutputs_C(p, str, indent, 2, "");
        }
        str.print(", ");
        p.print(getIn0(), str, indent);
        str.print(", ");
        p.print(getIn1(), str, indent);
        str.print(", ");
        p.print(getX(), str, indent);
        str.print(", ");
        p.print(getPositiveVelocity(), str, indent);
        str.print(")");
        
        if (!exp) {
            str.println(";");
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1534
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        p.printPostSteps(getIn0(), str, indent);
        p.printPostSteps(getIn1(), str, indent);
        p.printPostSteps(getX(), str, indent);
        p.printPostSteps(getPositiveVelocity(), str, indent);
    }
    /**
     * @aspect CCodeGenFunctionCall
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:364
     */
    public void prettyPrintCallOutputs_C(CodePrinter p, CodeStream str, String indent, int outputs,
            String sep) {
        int lefts = myLefts().size();
        for (int i = 0; i < outputs; i++) {
            str.print(sep);
            if (i < lefts) {
                myLefts().get(i).genArgument(p.ExecStep, str);
            } else if (i == 0 && lefts == 0 && isFunctionCallArg()) {
                str.print(tempName_C());
            } else {
                str.print("NULL");
            }
            sep = ", ";
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FSpatialDistExp() {
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
        children = new ASTNode[8];
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"OriginalArg", "In0", "In1", "X", "PositiveVelocity", "InitialPoints", "InitialValues"},
        type = {"List<InstFunctionArgument>", "FExp", "FExp", "FExp", "FExp", "FExp", "FExp"},
        kind = {"List", "Child", "Child", "Child", "Child", "Child", "Child"}
    )
    public FSpatialDistExp(List<InstFunctionArgument> p0, FExp p1, FExp p2, FExp p3, FExp p4, FExp p5, FExp p6) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
        setChild(p5, 5);
        setChild(p6, 6);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:29
     */
    protected int numChildren() {
        return 7;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:35
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        mySpatialDistIndex_reset();
        myEventIndicatorIndex_reset();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public FSpatialDistExp clone() throws CloneNotSupportedException {
        FSpatialDistExp node = (FSpatialDistExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:58
     */
    public FSpatialDistExp copy() {
        try {
            FSpatialDistExp node = (FSpatialDistExp) clone();
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
     * @declaredat ASTNode:77
     */
    @Deprecated
    public FSpatialDistExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public FSpatialDistExp treeCopyNoTransform() {
        FSpatialDistExp tree = (FSpatialDistExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 7:
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
     * @declaredat ASTNode:112
     */
    public FSpatialDistExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:117
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the OriginalArg list.
     * @param list The new list node to be used as the OriginalArg list.
     * @apilevel high-level
     */
    public void setOriginalArgList(List<InstFunctionArgument> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * @return Number of children in the OriginalArg list.
     * @apilevel high-level
     */
    public int getNumOriginalArg() {
        return getOriginalArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the OriginalArg list.
     * @apilevel low-level
     */
    public int getNumOriginalArgNoTransform() {
        return getOriginalArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the OriginalArg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the OriginalArg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getOriginalArg(int i) {
        return (InstFunctionArgument) getOriginalArgList().getChild(i);
    }
    /**
     * Check whether the OriginalArg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasOriginalArg() {
        return getOriginalArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the OriginalArg list.
     * @param node The element to append to the OriginalArg list.
     * @apilevel high-level
     */
    public void addOriginalArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getOriginalArgListNoTransform() : getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addOriginalArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getOriginalArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the OriginalArg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setOriginalArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="OriginalArg")
    public List<InstFunctionArgument> getOriginalArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(0);
        return list;
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the OriginalArg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getOriginalArgNoTransform(int i) {
        return (InstFunctionArgument) getOriginalArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getOriginalArgs() {
        return getOriginalArgList();
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgsNoTransform() {
        return getOriginalArgListNoTransform();
    }
    /**
     * Replaces the In0 child.
     * @param node The new node to replace the In0 child.
     * @apilevel high-level
     */
    public void setIn0(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the In0 child.
     * @return The current node used as the In0 child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="In0")
    public FExp getIn0() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the In0 child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the In0 child.
     * @apilevel low-level
     */
    public FExp getIn0NoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the In1 child.
     * @param node The new node to replace the In1 child.
     * @apilevel high-level
     */
    public void setIn1(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the In1 child.
     * @return The current node used as the In1 child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="In1")
    public FExp getIn1() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the In1 child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the In1 child.
     * @apilevel low-level
     */
    public FExp getIn1NoTransform() {
        return (FExp) getChildNoTransform(2);
    }
    /**
     * Replaces the X child.
     * @param node The new node to replace the X child.
     * @apilevel high-level
     */
    public void setX(FExp node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the X child.
     * @return The current node used as the X child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="X")
    public FExp getX() {
        return (FExp) getChild(3);
    }
    /**
     * Retrieves the X child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the X child.
     * @apilevel low-level
     */
    public FExp getXNoTransform() {
        return (FExp) getChildNoTransform(3);
    }
    /**
     * Replaces the PositiveVelocity child.
     * @param node The new node to replace the PositiveVelocity child.
     * @apilevel high-level
     */
    public void setPositiveVelocity(FExp node) {
        setChild(node, 4);
    }
    /**
     * Retrieves the PositiveVelocity child.
     * @return The current node used as the PositiveVelocity child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="PositiveVelocity")
    public FExp getPositiveVelocity() {
        return (FExp) getChild(4);
    }
    /**
     * Retrieves the PositiveVelocity child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the PositiveVelocity child.
     * @apilevel low-level
     */
    public FExp getPositiveVelocityNoTransform() {
        return (FExp) getChildNoTransform(4);
    }
    /**
     * Replaces the InitialPoints child.
     * @param node The new node to replace the InitialPoints child.
     * @apilevel high-level
     */
    public void setInitialPoints(FExp node) {
        setChild(node, 5);
    }
    /**
     * Retrieves the InitialPoints child.
     * @return The current node used as the InitialPoints child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="InitialPoints")
    public FExp getInitialPoints() {
        return (FExp) getChild(5);
    }
    /**
     * Retrieves the InitialPoints child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InitialPoints child.
     * @apilevel low-level
     */
    public FExp getInitialPointsNoTransform() {
        return (FExp) getChildNoTransform(5);
    }
    /**
     * Replaces the InitialValues child.
     * @param node The new node to replace the InitialValues child.
     * @apilevel high-level
     */
    public void setInitialValues(FExp node) {
        setChild(node, 6);
    }
    /**
     * Retrieves the InitialValues child.
     * @return The current node used as the InitialValues child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="InitialValues")
    public FExp getInitialValues() {
        return (FExp) getChild(6);
    }
    /**
     * Retrieves the InitialValues child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InitialValues child.
     * @apilevel low-level
     */
    public FExp getInitialValuesNoTransform() {
        return (FExp) getChildNoTransform(6);
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(7);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 7;
    }
    /** @apilevel internal */
    private void ndims_reset() {
        ndims_computed = false;
    }
    /** @apilevel internal */
    protected boolean ndims_computed = false;

    /** @apilevel internal */
    protected int ndims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228")
    public int ndims() {
        ASTState state = state();
        if (ndims_computed) {
            return ndims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ndims_value = vectorizedNdims();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /** @apilevel internal */
    private void size_reset() {
        size_computed = false;
        
        size_value = null;
    }
    /** @apilevel internal */
    protected boolean size_computed = false;

    /** @apilevel internal */
    protected Size size_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = vectorizedSize();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1018
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1018")
    public Size vectorizedSize() {
        {
                return getIn0().size();
            }
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1028
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1028")
    public int vectorizedNdims() {
        {
                return getIn0().ndims();
            }
    }
    /** @apilevel internal */
    private void getArrayExp_reset() {
        getArrayExp_computed = false;
        
        getArrayExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getArrayExp_computed = false;

    /** @apilevel internal */
    protected ArrayExp getArrayExp_value;

    /**
     * Computes a generic array expansion of the expression. If this expression is not an array the result is undefined.
     * Normally {@link #getArray()} should be called instead.
     * 
     * This is used mainly to scalarize array expressions. Should be overridden for all 
     * expression types possible, since default implementation clones the original expression 
     * for each cell.
     * 
     * @return An ArrayExp with scalar expressions if this is an array expression, 
     * <code>null</code> otherwise.
     * @attribute syn nta
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367")
    public ArrayExp getArrayExp() {
        ASTState state = state();
        if (getArrayExp_computed) {
            return (ArrayExp) getChild(getArrayExpChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getArrayExp_value = getArrayExp_compute();
        setChild(getArrayExp_value, getArrayExpChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getArrayExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        ArrayExp node = (ArrayExp) this.getChild(getArrayExpChildPosition());
        return node;
    }
    /** @apilevel internal */
    private ArrayExp getArrayExp_compute() {
            ArrayExp arr = new ArrayExp(indices());
            boolean vecPoints = getInitialPoints().ndims() > 1;
            boolean vecValues = getInitialValues().ndims() > 1;
            FExp points = getInitialPoints();
            FExp values = getInitialValues();
            for (Index i : arr.indices()) {
                if (vecPoints) {
                    points = getInitialPoints().getArray().subArrayFExp(i);
                }
                if (vecValues) {
                    values = getInitialValues().getArray().subArrayFExp(i);
                }
                arr.set(i, new FSpatialDistExp(getIn0().getArray().subArrayFExp(i), getIn1().getArray().subArrayFExp(i), getX().fullCopy(),
                        getPositiveVelocity().fullCopy(), points, values));
            }
            return arr;
        }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public CValue cevalCalc(VariableEvaluator evaluator) {
        CValue cevalCalc_VariableEvaluator_value = evaluate(evaluator)[0];
        return cevalCalc_VariableEvaluator_value;
    }
    /** @apilevel internal */
    private void mySpatialDistIndex_reset() {
        mySpatialDistIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean mySpatialDistIndex_computed = false;

    /** @apilevel internal */
    protected int mySpatialDistIndex_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1562
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1562")
    public int mySpatialDistIndex() {
        ASTState state = state();
        if (mySpatialDistIndex_computed) {
            return mySpatialDistIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        mySpatialDistIndex_value = myFClass().mySpatialDistExps().indexOf(originalFExp());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        mySpatialDistIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return mySpatialDistIndex_value;
    }
    /** @apilevel internal */
    private void myEventIndicatorIndex_reset() {
        myEventIndicatorIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean myEventIndicatorIndex_computed = false;

    /** @apilevel internal */
    protected int myEventIndicatorIndex_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2000
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2000")
    public int myEventIndicatorIndex() {
        ASTState state = state();
        if (myEventIndicatorIndex_computed) {
            return myEventIndicatorIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myEventIndicatorIndex_value = checkIndex(myFClass().stateEventExps().indexOf(originalFExp()));
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myEventIndicatorIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myEventIndicatorIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2114")
    public boolean hasEventGeneratingType() {
        boolean hasEventGeneratingType_value = true;
        return hasEventGeneratingType_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223")
    public FExp nominal() {
        FExp nominal_value = FExp.nominalMax(getIn0(), getIn1());
        return nominal_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817")
    public String builtInName() {
        String builtInName_value = "spatialDistribution";
        return builtInName_value;
    }
    /** @apilevel internal */
    private void type_reset() {
        type_computed = false;
        
        type_value = null;
    }
    /** @apilevel internal */
    protected boolean type_computed = false;

    /** @apilevel internal */
    protected FType type_value;

    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = getIn0().type();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:791
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:791")
    public boolean typeOutput(int i) {
        boolean typeOutput_int_value = i == 1 || super.typeOutput(i);
        return typeOutput_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1411
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1411")
    public int builtInNumOutput() {
        int builtInNumOutput_value = 2;
        return builtInNumOutput_value;
    }
    /**
     * Should this expression be extracted into its own statement?
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:65")
    public boolean extractTemp() {
        boolean extractTemp_value = isFunctionCallClause() || super.extractTemp();
        return extractTemp_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:372
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:372")
    public boolean scalarizeAsFunctionCallClause() {
        boolean scalarizeAsFunctionCallClause_value = isFunctionCallClause();
        return scalarizeAsFunctionCallClause_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:363")
    public FSpatialDistExp originalFExp() {
        FSpatialDistExp originalFExp_value = (originalFSpatialDistExp == null)  ? this : originalFSpatialDistExp;
        return originalFExp_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1831
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1831")
    public boolean isInitial() {
        boolean isInitial_value = getParent().Define_isInitial(this, null);
        return isInitial_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416
     * @apilevel internal
     */
    public Size Define_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return vectorizedSize();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:416
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute vectorizedSize
     */
    protected boolean canDefine_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905
     * @apilevel internal
     */
    public boolean Define_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isArray();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:905
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inVectorizedCall
     */
    protected boolean canDefine_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2506
        if (isInitial() && !isFunctionCallClause()) {
            return rewriteRule0();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2506
     * @apilevel internal
     */
    private FExp rewriteRule0() {
{
            return createInitialReplacement(false);
        }    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_mySpatialDistExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1560
        {
            FClass target = (FClass) (myFClass());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FClass_mySpatialDistExps(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_spatialDistExpsWithStateEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2018
        if (generatesEventInDAE()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_spatialDistExpsWithStateEvent(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_replacedAtInitialExps(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2435
        {
            FAbstractEquation target = (FAbstractEquation) (myFEquation());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FAbstractEquation_replacedAtInitialExps(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_mySpatialDistExps(ArrayList<FSpatialDistExp> collection) {
        super.contributeTo_FClass_mySpatialDistExps(collection);
        collection.add(this);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_spatialDistExpsWithStateEvent(ArrayList<FSpatialDistExp> collection) {
        super.contributeTo_FClass_spatialDistExpsWithStateEvent(collection);
        if (generatesEventInDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_replacedAtInitialExps(ArrayList<FExp> collection) {
        super.contributeTo_FAbstractEquation_replacedAtInitialExps(collection);
        collection.add(this);
    }
}
