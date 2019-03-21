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
 * An external function interface in the flat tree. Implemented as a statement.
 * 
 * LibTopPackagePath is the file path of the package file of the library that this external statement originated from.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:703
 * @astdecl FExternalStmt : FStatement ::= FExternalLanguage [ReturnVar:CommonAccessExp] <Name:String> Arg:FExp* <LibTopPackagePath:String>;
 * @production FExternalStmt : {@link FStatement} ::= <span class="component">{@link FExternalLanguage}</span> <span class="component">[ReturnVar:{@link CommonAccessExp}]</span> <span class="component">&lt;Name:String&gt;</span> <span class="component">Arg:{@link FExp}*</span> <span class="component">&lt;LibTopPackagePath:String&gt;</span>;

 */
public class FExternalStmt extends FStatement implements Cloneable, ExternalProcessMultiCache.External<ExternalArgument> {
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:312
     */
    @Override
    public int evaluate(AlgorithmEvaluator evaluator) {
        return evaluateExternal(evaluator);
    }
    /**
     * Check if this external function can be evaluated. Throw ConstantEvaluationException otherwise
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:66
     */
    public void checkCanEvaluate(AlgorithmEvaluator evaluator, Map<ExternalArgument, CValue> values) throws ConstantEvaluationException {
        if (evaluator.externalEvaluation() == 0) {
            throw new ConstantEvaluationException(null, "Could not evaluate external function, external evaluation disabled");
        }
        for (FExp arg : getArgs()) {
            if (!arg.type().externalValid()) {
                throw new ConstantEvaluationException(null, "Could not evaluate external function, invalid argument type");
            }
        }
        if (hasReturnVar() && !getReturnVar().type().externalValid()) {
            throw new ConstantEvaluationException(null, "Could not evaluate external function, invalid return type");
        }
        Collection<ExternalArgument> outputs = varsToDeserialize();
        for (ExternalArgument arg : values.keySet()) {
            if (!outputs.contains(arg)) {
                if (values.get(arg).isPartlyUnknown()) {
                    throw new ConstantEvaluationException(null, "Could not evaluate external function, unknown values in arguments");
                }
            }
        }
    }
    /**
     * Evaluate this statement as an external function constructor call. Stores evaluated
     * inputs in a CValueExternalObject.
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:145
     */
    public int evaluateConstructor(Map<CommonVariableDecl, CValue> values) {
        ArrayList<FExp> args = myConstructorArgs();
        CValue[] vals = new CValue[args.size()];
        for (int i = 0; i < args.size(); i++)
            vals[i] = args.get(i).ceval();
        values.put(myConstructorOutput(), new CValueExternalObject(vals));
        return EVAL_CONT;
    }
    /**
     * Retrieve {@link ExternalFunction} object which represents the external function
     * this statement refers to.
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:168
     */
    public ExternalFunction<ExternalArgument, CValue> myExternalFunction() {
        ExternalFunctionCache efc = root().getUtilInterface().getExternalFunctionCache();
        if (efc == null) {
            return new ExternalProcessCacheImpl<>(root().getUtilInterface().getModelicaCompiler())
                .failedEval(this, "external function cache unavailable", false);
        }
        return efc.getExternalProcessCache(getLibTopPackagePath()).getExternalFunction(this);
    }
    /**
     * Evaluate this external statement.
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:180
     */
    public int evaluateExternal(AlgorithmEvaluator evaluator) {
        
        Map<ExternalArgument, CValue> values = new LinkedHashMap<>();
        for (ExternalArgument arg : varsToSerialize()) {
            values.put(arg, arg.ceval());
        }
        
        checkCanEvaluate(evaluator, values);
        
        if (isConstructorStmt()) {
            return evaluateConstructor(evaluator.getValues());
        }
        
        int res = 0;
        int timeout = evaluator.externalEvaluation();
        ExternalFunction<ExternalArgument,CValue> ef = myExternalFunction();
        String error = null;
        try {
            res = ef.evaluate(this, values, timeout);
            if (res != 0) {
                error = "process returned '" + res + "'";
            }
        } catch (IOException e) {
            error = "error in process communication: '"+ e.getMessage() + "'";
        }
        
        if (error != null) {
            throw new ConstantEvaluationException(null, ExternalProcessCacheImpl.failedEvalMsg(getName(), error));
        }
        
        for (ExternalArgument output : varsToDeserialize()) {
            evaluator.getValues().put((CommonVariableDecl)output, values.get(output));
        }
        
        return EVAL_CONT;
    }
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4363
     */
    private String[] library;
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4364
     */
    private String include;
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4365
     */
    private String libraryDir;
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4366
     */
    private String includeDir;
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4368
     */
    public void extractLibrary(FExternalStmt n) {
        this.library = n.library;
        this.include = n.include;
        this.libraryDir = n.libraryDir;
        this.includeDir = n.includeDir;
    }
    /**
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4375
     */
    public void extractLibrary(InstExternal n) {
        library = n.annotation("Library").asStringVector();
        include = n.annotation("Include").string();
        libraryDir = n.annotation("LibraryDirectory").string();
        includeDir = n.annotation("IncludeDirectory").string();
        
        if (libraryDir == null || includeDir == null) {
            String libraryName = n.libraryName();
            if (libraryName != null) {
                String defDir = "modelica://" + libraryName + "/Resources";
                libraryDir = (libraryDir == null && library != null) ? 
                        defDir + "/Library" : libraryDir;
                includeDir = (includeDir == null && include != null) ? 
                        defDir + "/Include" : includeDir;
            }
        }
        
        if (includeDir != null) 
            includeDir = URIResolver.DEFAULT.resolve(n, includeDir);
        if (libraryDir != null) {
            libraryDir = URIResolver.DEFAULT.resolve(n, libraryDir);
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1504
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print("external ");
        p.print(getFExternalLanguage(), str, indent);
        str.print(" ");
        if (hasReturnVar()) {
            p.print(getReturnVar(), str, indent);
            str.print(" = ");
        }
        str.print(getName(), "(");
        getArgs().prettyPrintWithSep(p, str, indent, ", ");
        str.print(")");
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:214
     */
    public ArrayList<FExp> myConstructorArgs() {
        ArrayList<FExp> res = new ArrayList<FExp>();
        for (FExp arg : getArgs()) {
            if (arg.isConstructorTypeArg()) {
                res.add(arg);
            }
        }
        return res;
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:381
     */
    public void complianceCheck(ErrorCheckType checkType) {
        getFExternalLanguage().complianceCheck(checkType, this);
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:745
     */
    public void contentCheck(ErrorCheckType checkType) {
        getFExternalLanguage().contentCheck(checkType, this);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:826
     */
    public boolean flatten(Flattener f, List<FStatement> sl) {
        List<FExp> args = new List<FExp>();
        for (FExp arg : getArgs()) {
            args.add(arg.flatten(f));
        }
        Opt<CommonAccessExp> ret = hasReturnVar() ? 
                new Opt<>(getReturnVar().flatten(f).asCommonAccessExp()) : 
                new Opt<CommonAccessExp>();
                
        FExternalStmt stmt = new FExternalStmt(getFExternalLanguage().treeCopy(), ret, getName(), args, getLibTopPackagePath());
        stmt.extractLibrary(this);
        sl.add(stmt);
        return false;
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:123
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        FExternalLanguage lang = getFExternalLanguage();
        lang.genVarDecls_C(p, str, indent, this, codeGenContext != null);
        lang.genFuncDecl(p, str, indent, this);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:433
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        boolean ceval = codeGenContext != null;
        // Generate temp arrays for all array inputs and outputs
        // and transpose array for if array is input (Fortran 77 only)
        getFExternalLanguage().prepExternalArg(p, str, indent, this, false, getCodeGenContext(), ceval);
        
        str.print(indent);
        // return variable?
        if(hasReturnVar()) {
            String name = getCodeGenContext().alias(getReturnVar().externalArgument());
            if (name == null) {
                name = getReturnVar().type().isRecord() ?
                    "*"+getReturnVar().tempName_C() :
                    getReturnVar().getAccess().name_C();
            }
            str.print(name);
            str.print(" = ");
        }
        
        CodeGenContext cgc = getCodeGenContext().createProxy();
        getFExternalLanguage().extraContext(this, cgc, ceval);
        getFExternalLanguage().genFuncCall(p, str, indent, this, cgc);
        
        // If there are any output arrays, transpose these before returning (Fortran 77 only)
        getFExternalLanguage().prepExternalArg(p, str, indent, this, true, getCodeGenContext(), ceval);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:24
     */
    public void setExternalArgumentAliases(CodeGenContext cgc) {
        setExternalArgumentAliases(cgc, getName(), false);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:28
     */
    public void setExternalArgumentAliases(CodeGenContext cgc, String name, boolean all) {
        int i = 0;
        for (ExternalArgument arg : varsToSerialize()) {
            if (all || arg instanceof FExp) {
                cgc.setAlias(arg, name + "_arg" + i);
            }
            i++;
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:38
     */
    public void setExternalArgumentAliases(CodeGenContext cgc, String outName, String name) {
        setExternalArgumentAliases(cgc, name, true);
        cgc.setAlias(myConstructorOutput(), outName);
    }
    /**
     * Generate all C-declarations necessary for an external evaluation
     * 
     * @param p       ASTNode code generation visitor
     * @param str     output code stream
     * @param indent  indentation string
     * @param cgc     context for generating temporaries
     * @param tempMap maps expressions that should be replaced with temporaries
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:180
     */
    public void genSerialize_C(TypePrinter_C tp, String indent,
            CodeGenContext cgc, Map<String,String> tempMap, Iterable<ExternalArgument> cvds) {
        for (ExternalArgument cvd : cvds) {
            String name = cgc.alias(cvd);
            if (name == null) {
                name = cvd.name_C();
            }
            tp.resetUnknown(name, cvd.type(), indent);
            cvd.type().print(tp);
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:192
     */
    public void genSerializeComps_C(TypePrinter_C tp, String indent,
            CodeGenContext cgc, Map<String,String> tempMap, Iterable<ExternalArgument> cvds) {
        for (ExternalArgument cvd : cvds) {
            tp.resetUnknown(cvd.name_C(), cvd.type(), indent);
            tp.printComps((FExternalObjectType)cvd.type());
        }
    }
    /**
     * Generate statements for type conversions, calling the external function,
     * and printing return values on stdout.
     * 
     * For parameters {@link FExternalStmt.genSerializeDecl_C}
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:206
     */
    public void genSerializeCalc_C(CodePrinter p, CodeStream str, String indent,
            CodeGenContext cgc, Map<String,String> tempMap) {
        prettyPrint_C(p, str, indent);
        genCheckPoint(str, indent, "DONE");
        for (ExternalArgument cvd : varsToDeserialize())
            cvd.type().genSerialize_C(str, indent, cvd.name_C(), false);
        str.println();
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:215
     */
    public void genCheckPoint(CodeStream str, String indent, String token) {
        str.print(indent);
        str.print("JMCEVAL_check(\"");
        str.print(token);
        str.print("\");\n");
    }
    /**
     * Declarations of records used in this function
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:309
     */
    public Map<String,FType> usedTypes() {
        Map<String,FType> res = new LinkedHashMap<String,FType>();
        for (ExternalArgument cvd : varsToSerialize()) {
            cvd.type().usedTypes(res);
        }
        return res;
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:383
     */
    public void externalDependencies(
            Set<String> incs, Set<String> incDirs,
            Set<String> libs, Set<String> libDirs) {
        for (FExternalStmt dep : externalDependencies()) {
            if (incs != null && dep.include() != null) {
                incs.add(dep.include());
            }
            if (incDirs != null && dep.includeDirectory() != null) {
                incDirs.add(dep.includeDirectory());
            }
            if (libs != null && dep.library() != null) {
                for (String lib : dep.library()) {
                    libs.add(lib);
                }
            }
            if (libDirs != null && dep.libraryDirectory() != null) {
                libDirs.add(dep.libraryDirectory());
            }
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:404
     */
    public Set<FExternalStmt> externalDependencies() {
        Set<FExternalStmt> res = new LinkedHashSet<FExternalStmt>();
        externalDependencies(res);
        return res;
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:410
     */
    public void externalDependencies(Set<FExternalStmt> res) {
        if (res.contains(this)) {
            return;
        }
        res.add(this);
        
        for (ExternalArgument arg : varsToSerialize()) {
            FType t = arg.type();
            boolean par = t.getParent() == null;
            if (par) {
                t.setParent(this);
            }
            t.externalDependencies(res);
            if (par) {
                t.setParent(null);
            }
        }
        
        res.remove(this);
        res.add(this);
    }
    /**
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:56
     */
    private CodeGenContext codeGenContext = null;
    /**
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:57
     */
    public void setCodeGenContext(CodeGenContext cgc) { codeGenContext = cgc; }
    /**
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:58
     */
    public CodeGenContext getCodeGenContext() { return codeGenContext == null ? myCodeGenContext() : codeGenContext; }
    /**
     * @declaredat ASTNode:1
     */
    public FExternalStmt() {
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
        children = new ASTNode[3];
        setChild(Opt.EMPTY, 1);
        setChild(List.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FExternalLanguage", "ReturnVar", "Name", "Arg", "LibTopPackagePath"},
        type = {"FExternalLanguage", "Opt<CommonAccessExp>", "String", "List<FExp>", "String"},
        kind = {"Child", "Opt", "Token", "List", "Token"}
    )
    public FExternalStmt(FExternalLanguage p0, Opt<CommonAccessExp> p1, String p2, List<FExp> p3, String p4) {
        setChild(p0, 0);
        setChild(p1, 1);
        setName(p2);
        setChild(p3, 2);
        setLibTopPackagePath(p4);
    }
    /**
     * @declaredat ASTNode:27
     */
    public FExternalStmt(FExternalLanguage p0, Opt<CommonAccessExp> p1, beaver.Symbol p2, List<FExp> p3, beaver.Symbol p4) {
        setChild(p0, 0);
        setChild(p1, 1);
        setName(p2);
        setChild(p3, 2);
        setLibTopPackagePath(p4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:35
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:41
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myFClass_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public FExternalStmt clone() throws CloneNotSupportedException {
        FExternalStmt node = (FExternalStmt) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:59
     */
    public FExternalStmt copy() {
        try {
            FExternalStmt node = (FExternalStmt) clone();
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
     * @declaredat ASTNode:78
     */
    @Deprecated
    public FExternalStmt fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:88
     */
    public FExternalStmt treeCopyNoTransform() {
        FExternalStmt tree = (FExternalStmt) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
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
     * @declaredat ASTNode:108
     */
    public FExternalStmt treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:113
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenString_Name == ((FExternalStmt) node).tokenString_Name) && (tokenString_LibTopPackagePath == ((FExternalStmt) node).tokenString_LibTopPackagePath);    
    }
    /**
     * Replaces the FExternalLanguage child.
     * @param node The new node to replace the FExternalLanguage child.
     * @apilevel high-level
     */
    public void setFExternalLanguage(FExternalLanguage node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FExternalLanguage child.
     * @return The current node used as the FExternalLanguage child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FExternalLanguage")
    public FExternalLanguage getFExternalLanguage() {
        return (FExternalLanguage) getChild(0);
    }
    /**
     * Retrieves the FExternalLanguage child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FExternalLanguage child.
     * @apilevel low-level
     */
    public FExternalLanguage getFExternalLanguageNoTransform() {
        return (FExternalLanguage) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the ReturnVar child. This is the <code>Opt</code>
     * node containing the child ReturnVar, not the actual child!
     * @param opt The new node to be used as the optional node for the ReturnVar child.
     * @apilevel low-level
     */
    public void setReturnVarOpt(Opt<CommonAccessExp> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) ReturnVar child.
     * @param node The new node to be used as the ReturnVar child.
     * @apilevel high-level
     */
    public void setReturnVar(CommonAccessExp node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional ReturnVar child exists.
     * @return {@code true} if the optional ReturnVar child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasReturnVar() {
        return getReturnVarOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ReturnVar child.
     * @return The ReturnVar child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public CommonAccessExp getReturnVar() {
        return (CommonAccessExp) getReturnVarOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the ReturnVar child. This is the <code>Opt</code> node containing the child ReturnVar, not the actual child!
     * @return The optional node for child the ReturnVar child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="ReturnVar")
    public Opt<CommonAccessExp> getReturnVarOpt() {
        return (Opt<CommonAccessExp>) getChild(1);
    }
    /**
     * Retrieves the optional node for child ReturnVar. This is the <code>Opt</code> node containing the child ReturnVar, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ReturnVar.
     * @apilevel low-level
     */
    public Opt<CommonAccessExp> getReturnVarOptNoTransform() {
        return (Opt<CommonAccessExp>) getChildNoTransform(1);
    }
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Name;
    /**
     */
    public int Namestart;
    /**
     */
    public int Nameend;
    /**
     * JastAdd-internal setter for lexeme Name using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Name
     * @apilevel internal
     */
    public void setName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setName is only valid for String lexemes");
        tokenString_Name = (String)symbol.value;
        Namestart = symbol.getStart();
        Nameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Name.
     * @return The value for the lexeme Name.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Name")
    public String getName() {
        return tokenString_Name != null ? tokenString_Name : "";
    }
    /**
     * Replaces the Arg list.
     * @param list The new list node to be used as the Arg list.
     * @apilevel high-level
     */
    public void setArgList(List<FExp> list) {
        setChild(list, 2);
    }
    /**
     * Retrieves the number of children in the Arg list.
     * @return Number of children in the Arg list.
     * @apilevel high-level
     */
    public int getNumArg() {
        return getArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Arg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Arg list.
     * @apilevel low-level
     */
    public int getNumArgNoTransform() {
        return getArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Arg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Arg list.
     * @apilevel high-level
     */
    public FExp getArg(int i) {
        return (FExp) getArgList().getChild(i);
    }
    /**
     * Check whether the Arg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasArg() {
        return getArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the Arg list.
     * @param node The element to append to the Arg list.
     * @apilevel high-level
     */
    public void addArg(FExp node) {
        List<FExp> list = (parent == null) ? getArgListNoTransform() : getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addArgNoTransform(FExp node) {
        List<FExp> list = getArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Arg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setArg(FExp node, int i) {
        List<FExp> list = getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Arg")
    public List<FExp> getArgList() {
        List<FExp> list = (List<FExp>) getChild(2);
        return list;
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<FExp> getArgListNoTransform() {
        return (List<FExp>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the Arg list without
     * triggering rewrites.
     */
    public FExp getArgNoTransform(int i) {
        return (FExp) getArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    public List<FExp> getArgs() {
        return getArgList();
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<FExp> getArgsNoTransform() {
        return getArgListNoTransform();
    }
    /**
     * Replaces the lexeme LibTopPackagePath.
     * @param value The new value for the lexeme LibTopPackagePath.
     * @apilevel high-level
     */
    public void setLibTopPackagePath(String value) {
        tokenString_LibTopPackagePath = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_LibTopPackagePath;
    /**
     */
    public int LibTopPackagePathstart;
    /**
     */
    public int LibTopPackagePathend;
    /**
     * JastAdd-internal setter for lexeme LibTopPackagePath using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme LibTopPackagePath
     * @apilevel internal
     */
    public void setLibTopPackagePath(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setLibTopPackagePath is only valid for String lexemes");
        tokenString_LibTopPackagePath = (String)symbol.value;
        LibTopPackagePathstart = symbol.getStart();
        LibTopPackagePathend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme LibTopPackagePath.
     * @return The value for the lexeme LibTopPackagePath.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="LibTopPackagePath")
    public String getLibTopPackagePath() {
        return tokenString_LibTopPackagePath != null ? tokenString_LibTopPackagePath : "";
    }
    /**
     * Check if this external function should be cached as a live process.
     * @attribute syn
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:91
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:91")
    public boolean shouldCacheProcess() {
        {
                return myOptions().getIntegerOption("external_constant_evaluation_max_proc") > 0;
            }
    }
    /**
     * Returns a single scalar external object which can be cached. If there is not exactly
     * one scalar external object, return null.
     * @attribute syn
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:99
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:99")
    public ExternalArgument cachedExternalObject() {
        {
                ExternalArgument eo = null;
                for (ExternalArgument cvd : varsToSerialize()) {
                    if (cvd.type().isExternalObject() && cvd.type().isScalar()) {
                        if (eo != null) {
                            return null;
                        } else {
                            eo = cvd;
                        }
                    }
                }
                return eo;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4356")
    public String[] library() {
        String[] library_value = library;
        return library_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4357
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4357")
    public String include() {
        String include_value = include;
        return include_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4358
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4358")
    public String libraryDirectory() {
        String libraryDirectory_value = libraryDir;
        return libraryDirectory_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4359
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4359")
    public String includeDirectory() {
        String includeDirectory_value = includeDir;
        return includeDirectory_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4360")
    public boolean isIncluded() {
        boolean isIncluded_value = !(include() == null || include().equals(""));
        return isIncluded_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalFunctionAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4361
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalFunctionAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4361")
    public boolean isInLibrary() {
        boolean isInLibrary_value = !(libraryDirectory() == null || libraryDirectory().equals(""));
        return isInLibrary_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:565
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:565")
    public boolean isExternalStatement() {
        boolean isExternalStatement_value = true;
        return isExternalStatement_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "External";
        return xmlTag_value;
    }
    /**
     * List of ExternalArgument which has to be sent to the process
     * when evaluating an external function.
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:247
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:247")
    public Collection<ExternalArgument> varsToSerialize() {
        {
                Collection<ExternalArgument> res = new LinkedHashSet<>();
                if (hasReturnVar()) {
                    res.add(getReturnVar().externalArgument());
                }
                for (FExp e : getArgs()) {
                    res.add(e.externalArgument());
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:272")
    public ArrayList<ExternalArgument> externalObjectsToSerialize() {
        {
                ArrayList<ExternalArgument> externalObjects = new ArrayList<ExternalArgument>();
                for (ExternalArgument var : varsToSerialize()) {
                    if (var.type().isExternalObject()) {
                        externalObjects.add(var);
                    }
                }
                return externalObjects;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:282")
    public ArrayList<ExternalArgument> functionArgsToSerialize() {
        {
                ArrayList<ExternalArgument> functionArgs = new ArrayList<ExternalArgument>();
                for (ExternalArgument var : varsToSerialize()) {
                    if (!var.type().isExternalObject()) {
                        functionArgs.add(var);
                    }
                }
                return functionArgs;
            }
    }
    /**
     * List of CommonVariableDecl which has to be read from the process
     * when evaluating an external function.
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:296
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:296")
    public ArrayList<ExternalArgument> varsToDeserialize() {
        {
                ArrayList<ExternalArgument> res = new ArrayList<>();
                for (ExternalArgument cvd : varsToSerialize()) {
                    if (cvd.isOutput()) {
                        res.add(cvd);
                    }
                }
                return res;
            }
    }
    /**
     * @attribute inh
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExternalConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154")
    public boolean isConstructorStmt() {
        boolean isConstructorStmt_value = getParent().Define_isConstructorStmt(this, null);
        return isConstructorStmt_value;
    }
    /**
     * @attribute inh
     * @aspect ExternalConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExternalConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159")
    public boolean isDestructorStmt() {
        boolean isDestructorStmt_value = getParent().Define_isDestructorStmt(this, null);
        return isDestructorStmt_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2325")
    public FClass myFClass() {
        ASTState state = state();
        if (myFClass_computed) {
            return myFClass_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFClass_value = getParent().Define_myFClass(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFClass_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFClass_value;
    }
    /** @apilevel internal */
    private void myFClass_reset() {
        myFClass_computed = false;
        
        myFClass_value = null;
    }
    /** @apilevel internal */
    protected boolean myFClass_computed = false;

    /** @apilevel internal */
    protected FClass myFClass_value;

    /**
     * @attribute inh
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:209
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:209")
    public CommonVariableDecl myConstructorOutput() {
        CommonVariableDecl myConstructorOutput_value = getParent().Define_myConstructorOutput(this, null);
        return myConstructorOutput_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2479
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2479")
    public InstNode containingInstClassDecl() {
        InstNode containingInstClassDecl_value = getParent().Define_containingInstClassDecl(this, null);
        return containingInstClassDecl_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute flattenFASContext
     */
    protected boolean canDefine_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:275
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return false;
        }
        else {
            return super.Define_canInlineConstant(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     * @apilevel internal
     */
    public CodeGenContext Define_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCodeGenContext();
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
    /** @apilevel internal */
    protected void collect_contributors_FClass_myExternals(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4320
        {
            FClass target = (FClass) (myFClass());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FClass_myExternals(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myExternals(HashSet<FExternalStmt> collection) {
        super.contributeTo_FClass_myExternals(collection);
        collection.add(this);
    }
}
