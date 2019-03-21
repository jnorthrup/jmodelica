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
 * Generic function call expression in instance trees.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1194
 * @astdecl InstFunctionCall : CommonFunctionCall ::= Name:InstAccess Arg:InstFunctionArgument* FType;
 * @production InstFunctionCall : {@link CommonFunctionCall} ::= <span class="component">Name:{@link InstAccess}</span> <span class="component">Arg:{@link InstFunctionArgument}*</span> <span class="component">{@link FType}</span>;

 */
public class InstFunctionCall extends CommonFunctionCall implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2142
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
      for (InstFunctionArgument arg : getArgList()) {
          arg.getFExp().collectAccessNames(collectedNames);
      }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3579
     */
    @Override
    public void evaluateCell(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        myCommonCallable().evaluate(evaluator, values);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1002
     */
    public InstFunctionCall createEmptyNode()        { return new InstFunctionCall();        }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1749
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
        str.print(getName().name(), "(");
        getArgs().prettyPrintWithSep(p, str, "", ", ");
        str.print(")");
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:515
     */
    public FExp copyReplaceAccess(FExp.ContextReplacer crp) {
        InstAccess name = InstAccess.fromName(getName().myInstCallable().actualInstCallable().qualifiedName());
        return new InstFunctionCall(name, getArgs().copyReplaceAccess(crp));
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:372
     */
    public void complianceCheck(ErrorCheckType checkType) {
        if (isConstructorCall() && isBound() && inFunction()) {
            UNSUPPORTED_EXTERNAL_OBJECT_CONSTRUCTORS.invoke(this);
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:238
     */
    public void contentCheck(ErrorCheckType checkType) {
       if (generated) {
           if (isConstructorCall()) {
               if (!isBound()) {
                   error("Constructors for external objects can only be used as binding expressions");
               }
           }
       } else {
			InstClassDecl target = getName().myInstClassDecl();
			if (target.isConstructor() || target.isDestructor())
				error("Constructors and destructors for ExternalObjects can not be used directly");
		}
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1338
     */
    public void collectErrors(ErrorCheckType checkType) {
        if (!errorChecked) {
            errorChecked = true;
            // Check that the function exists
            InstLookupResult<InstCallable> lp = getName().myInstLookupCallable();
            InstCallable func = getName().myInstCallable();
            String name = getName().name();
            if (lp.isError()) {
                // Function does not exist or can't be used due to constraining classes, or name refers to component
                getName().generateClassLookupProblems(lp, this);
            } else if (!func.isCallable()) {
                if (func.isExternalObject()) {
                    // Something is be wrong with constructor
                    name += ".constructor";
                    func = func.asInstClassDecl().myConstructor();
                    if (func.isUnknown()) {
                        // The constructor does not exist
                        error("Cannot find function declaration for " + name + "()");
                    }
                    // Constructor exists, but is not a function - delegate to default case
                }
                if (!func.isUnknown()) {
                    // Not a function
                    error("The class " + name + " is not a function");
                }
            } else if (!func.isRecord() && !func.isCompleteFunction()) {
                // TODO: add check if function is partial?
                if (!checkType.allowIncompleteReplaceableFunc() || !canBeReplacedForMe(func.asInstNode()))
                    error("Calling function " + getName().name() + 
                            "(): can only call functions that have one algorithm section or external function specification");
            } else {
                // Function exists, check everything
                errorChecked = false; // super also uses errorChecked
                super.collectErrors(checkType);
                
                // We need to check the function definition as well.
                func.collectErrors(checkType);
                
                // Check if there were any unbindable args
                boolean pos = true;
                String desc = functionCallDecription();
                for (InstFunctionArgument arg : unbindableArgs) 
                    pos = arg.generateUnbindableError(desc, pos);
            }
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1433
     */
    public void typeCheck(ErrorCheckType checkType) {
        if (!isFunctionCallClause() && !getName().myInstClassDecl().isRecord() && !hasOutputs() && !isPartialFunctionCall()) {
            error("Function " + getName().name() + "() has no outputs, but is used in expression");
        } else if (!isFunctionCallClause() && size().isUnknown() && errorCheckUnknownSize()) {
            CANNOT_INFER_ARRAY_SIZE_OF_OUTPUT.invoke(this, expOutput().name());
        }
        if (myCallOutputs().size() < myLefts().size()) {
            error("Too many components assigned from function call: " + getName().name() + 
                    "() has " + myCallOutputs().size() + " output(s)");
        }
        if (isFunctionCallClause()) {
            for (int i = 0, n = myCallOutputs().size(); i < n; i++) {
                sizeOfOutput(i).markAsStructuralParameter(checkType, this);
            }
        } else {
            size().markAsStructuralParameter(checkType, this);
        }
        if (callsLoadResource()) {
            getArgs().forceUsesVariability(checkType, Variability.LOADRESOURCEPARAMETER);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:385
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        InstCallable target = myInstCallable();
        target.flattenFunction(f);
        getArgs().flattenUsedFuncsAndEnums(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1270
     */
    public void flattenAssertExternal(Flattener f) {
        if (variability().knownParameterOrLess() && myInstCallable().isExternalFunction()) {
            try {
                String msg = "Error " + runtimeErrorString("Structural parameter external function call '"
                        + name() + "' did not evaluate to same result as during compilation");
                CValue cval = ceval();
                if (cval.hasBuildLiteral()) {
                    f.addParameterEquation(new FFunctionCallEquation(new List<FFunctionCallLeft>(), 
                            new FAssert(new FEqExp(cval.buildLiteral(), flatten(f)),
                                    new FStringLitExp(msg), new Opt<FExp>())));
                }
            } catch (ConstantEvaluationException e) {}
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2788
     */
    public FExp flatten(Flattener f) {
        if (callsLoadResource() && !inFunction()) {
            if (isFunctionCallClause()) {
                ASTNode.CANNOT_EVALUATE_LOADRESOURCE.invoke(this, this, "");
            } else {
                try {
                    return ceval().buildLiteral();
                } catch (ConstantEvaluationException e) {
                    ASTNode.CANNOT_EVALUATE_LOADRESOURCE.invoke(this, this, e.getModelicaStackTrace());
                }
            }
        }
        List args = new List();
        for (InstFunctionArgument e : getArgs()) 
            args.add(e.flatten(f));
        InstCallable target = myInstCallable().actualInstCallable();
        FAccess name = new FAccessString(target.qualifiedName());
        return createFFunctionCall(name, args, getFType().flatten(f, null, true));
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2812
     */
    public FFunctionCall createFFunctionCall(FAccess name, List args, FType type) {
        return setLocationOf(new FFunctionCall(name, args, type));
    }
    /**
     * List of arguments that could not be bound to inputs.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:164
     */
    private java.util.List<InstFunctionArgument> unbindableArgs     = Collections.emptyList();
    /**
     * Add a new argument to list of arguments.
     * 
     * This implementation adds the argument as a child.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:212
     */
    public void addArgument(InstFunctionArgument arg) {
		addArg(arg);
	}
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:228
     */
    

        private static BuiltInTranslator builtInTranslator = new BuiltInTranslator();
    /**
     * Helper class for rewrite InstFunctionCall -> FAbstractFunctionCall. 
     * 
     * Creates an instance of the specific subclass of FBuiltInFunctionCall matching 
     * the name of the function, if one matches. 
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:236
     */
    
        
        /**
         * Helper class for rewrite InstFunctionCall -> FAbstractFunctionCall. 
         * 
         * Creates an instance of the specific subclass of FBuiltInFunctionCall matching 
         * the name of the function, if one matches. 
         */
        private static class BuiltInTranslator {

            private HashMap<String, BuiltInCreator> map;
            private static final String MATH_PREF = "Modelica.Math.";
            private static final int MATH_LEN = MATH_PREF.length();

            /* Built-In-Type*/
            public enum BIT {
                NONE, MATH
            }

            public FBuiltInFunctionCall create(String name, InstFunctionArgument[] args) {
                boolean math = name.startsWith(MATH_PREF);
                if (math) 
                    name = name.substring(MATH_LEN);
                BuiltInCreator creator = map.get(name);
                if (creator == null || (math && !creator.match(BIT.MATH)))
                    return null;
                FBuiltInFunctionCall res = creator.create(args);
                if (res != null)
                    for (InstFunctionArgument arg : args)
                        res.addOriginalArg(arg);
                return res;
            }

            public boolean isInfArgs(String name) {
                BuiltInCreator creator = map.get(name);
                return creator != null && creator.isInfArgs();
            }


            public BuiltInTranslator() {
                map = new HashMap<String, BuiltInCreator>();
                //       name                                 math       node                # args
                map.put("abs",             new BuiltInCreator(BIT.NONE, new FAbsExp(),          1));
                map.put("sign",            new BuiltInCreator(BIT.NONE, new FSignExp(),         1));
                map.put("sqrt",            new BuiltInCreator(BIT.NONE, new FSqrtExp(),         1));
                map.put("Integer",         new BuiltInCreator(BIT.NONE, new FEnumIntegerExp(),  1));
                map.put("div",             new BuiltInCreator(BIT.NONE, new FDivFuncExp(),      2));
                map.put("mod",             new BuiltInCreator(BIT.NONE, new FModFuncExp(),      2));
                map.put("rem",             new BuiltInCreator(BIT.NONE, new FRemFuncExp(),      2));
                map.put("ceil",            new BuiltInCreator(BIT.NONE, new FCeilFuncExp(),     1));
                map.put("floor",           new BuiltInCreator(BIT.NONE, new FFloorFuncExp(),    1));
                map.put("integer",         new BuiltInCreator(BIT.NONE, new FIntegerFuncExp(),  1));
                map.put("sin",             new BuiltInCreator(BIT.MATH, new FSinExp(),          1));
                map.put("cos",             new BuiltInCreator(BIT.MATH, new FCosExp(),          1));
                map.put("tan",             new BuiltInCreator(BIT.MATH, new FTanExp(),          1));
                map.put("asin",            new BuiltInCreator(BIT.MATH, new FAsinExp(),         1));
                map.put("acos",            new BuiltInCreator(BIT.MATH, new FAcosExp(),         1));
                map.put("atan",            new BuiltInCreator(BIT.MATH, new FAtanExp(),         1));
                map.put("atan2",           new BuiltInCreator(BIT.MATH, new FAtan2Exp(),        2));
                map.put("sinh",            new BuiltInCreator(BIT.MATH, new FSinhExp(),         1));
                map.put("cosh",            new BuiltInCreator(BIT.MATH, new FCoshExp(),         1));
                map.put("tanh",            new BuiltInCreator(BIT.MATH, new FTanhExp(),         1));
                map.put("exp",             new BuiltInCreator(BIT.MATH, new FExpExp(),          1));
                map.put("log",             new BuiltInCreator(BIT.MATH, new FLogExp(),          1));
                map.put("log10",           new BuiltInCreator(BIT.MATH, new FLog10Exp(),        1));
                map.put("noEvent",         new BuiltInCreator(BIT.NONE, new FNoEventExp(),      1));
                map.put("smooth",          new BuiltInCreator(BIT.NONE, new FSmoothExp(),       2));
                map.put("pre",             new BuiltInCreator(BIT.NONE, new InstPreExp(),       1));
                map.put("edge",            new BuiltInCreator(BIT.NONE, new FEdgeExp(),         1));
                map.put("change",          new BuiltInCreator(BIT.NONE, new FChangeExp(),       1));
                map.put("sample",          new BuiltInCreator(BIT.NONE, new FSampleExp(),       2));
                map.put("initial",         new BuiltInCreator(BIT.NONE, new FInitialExp(),      0));
                map.put("terminal",        new BuiltInCreator(BIT.NONE, new FTerminalExp(),     0));
                map.put("terminate",       new BuiltInCreator(BIT.NONE, new FTerminate(),       1));
                map.put("reinit",          new BuiltInCreator(BIT.NONE, new FReinit(),          2));
                map.put("identity",        new BuiltInCreator(BIT.NONE, new FIdentity(),        1));
                map.put("diagonal",        new BuiltInCreator(BIT.NONE, new FDiagonal(),        1));
                map.put("scalar",          new BuiltInCreator(BIT.NONE, new FScalarExp(),       1));
                map.put("vector",          new BuiltInCreator(BIT.NONE, new FVectorExp(),       1));
                map.put("matrix",          new BuiltInCreator(BIT.NONE, new FMatrixExp(),       1));
                map.put("transpose",       new BuiltInCreator(BIT.NONE, new FTranspose(),       1));
                map.put("symmetric",       new BuiltInCreator(BIT.NONE, new FSymmetric(),       1));
                map.put("cross",           new BuiltInCreator(BIT.NONE, new FCross(),           2));
                map.put("skew",            new BuiltInCreator(BIT.NONE, new FSkew(),            1));
                map.put("outerProduct",    new BuiltInCreator(BIT.NONE, new FOuterProduct(),    2));
                map.put("sum",             new BuiltInCreator(BIT.NONE, new FSumExp(),          1));
                map.put("product",         new BuiltInCreator(BIT.NONE, new FProductExp(),      1));
                map.put("ndims",           new BuiltInCreator(BIT.NONE, new FNdimsExp(),        1));
                map.put("linspace",        new BuiltInCreator(BIT.NONE, new FLinspace(),        3));
                map.put("homotopy",        new BuiltInCreator(BIT.NONE, new FHomotopyExp(),     2));
                map.put("semiLinear",      new BuiltInCreator(BIT.NONE, new FSemiLinearExp(),   3));
                map.put("inStream",        new BuiltInCreator(BIT.NONE, new FInStream(),        1));
                map.put("actualStream",    new BuiltInCreator(BIT.NONE, new FActualStream(),    1));
                map.put("cardinality",     new BuiltInCreator(BIT.NONE, new FCardinality(),     1));
                map.put("getInstanceName", new BuiltInCreator(BIT.NONE, new FGetInstanceName(), 0));
                map.put("Subtask.decouple", 
                        new BuiltInCreator(BIT.NONE, new FDecouple(),     1));
                map.put("Modelica.Utilities.Files.loadResource", 
                        new BuiltInCreator(BIT.NONE, new FLoadResource(), 1));
                map.put("ModelicaServices.ExternalReferences.loadResource", 
                        new BuiltInCreator(BIT.NONE, new FLoadResource(), 1));
                //       name                                            node           # fixed args
                map.put("array",           new InfArgsBuiltInCreator(new FParseArray(), 0));
                map.put("ones",            new InfArgsBuiltInCreator(new FOnes(),       0));
                map.put("zeros",           new InfArgsBuiltInCreator(new FZeros(),      0));
                map.put("fill",            new InfArgsBuiltInCreator(new FFillExp(),    1));
                map.put("cat",             new InfArgsBuiltInCreator(new FCatExp(),     1));
                //       name                                            node          min/max # args
                map.put("size",            new VarArgsBuiltInCreator(new FSizeExp(),   1, 2));
                map.put("String",          new VarArgsBuiltInCreator(new FStringExp(), 1, 5));
                map.put("min",             new VarArgsBuiltInCreator(new FMinExp(),    1, 2));
                map.put("max",             new VarArgsBuiltInCreator(new FMaxExp(),    1, 2));
                map.put("assert",          new VarArgsBuiltInCreator(new FAssert(),    2, 3));
                map.put("delay",           new VarArgsBuiltInCreator(new FDelayExp(),  2, 3));
                map.put("spatialDistribution", new VarArgsBuiltInCreator(new FSpatialDistExp(), 4, 6, true));
                //       name                                    math       node              # args
                map.put("Connections.branch", new BuiltInCreator(BIT.NONE, new FConnBranch(),    2));
                map.put("Connections.root",   new BuiltInCreator(BIT.NONE, new FConnRoot(),      1));
                map.put("Connections.isRoot", new BuiltInCreator(BIT.NONE, new FConnIsRoot(),    1));
                map.put("Connections.rooted", new BuiltInCreator(BIT.NONE, new FConnRooted(),    1));
                map.put("rooted",             new BuiltInCreator(BIT.NONE, new FConnRootedDep(), 1));
                //       name                                                      node                  min/max # args
                map.put("Connections.potentialRoot", new VarArgsBuiltInCreator(new FConnPotentialRoot(), 1, 2));
                
                String[] unsupported = new String[] { 
                        // Ticket 664: Support all function-like operators
                    };
                for (String name : unsupported)
                    if (!map.containsKey(name))
                        map.put(name, new UnsupportedBuiltInCreator(name));
                
                // Not used anymore, but left for possible future needs
                String[] ignored = new String[] {};
                for (String name : ignored)
                    if (!map.containsKey(name))
                        map.put(name, new IgnoredBuiltInCreator(name));
            }

			private static class BuiltInCreator {
				
                protected BIT type;
				protected FBuiltInFunctionCall template;
				protected int numArgs;
				
                public BuiltInCreator(BIT t, FBuiltInFunctionCall tmpl, int nArgs) { 
                    type = t;
					template = tmpl;
					numArgs = nArgs;
				}
				
				public FBuiltInFunctionCall create(InstFunctionArgument[] args) {
					if (args.length < numArgs)
						return null;
					FBuiltInFunctionCall res = template.createEmptyNode();
					setArguments(res, args);
					return res;
				}
				
				protected void setArguments(FBuiltInFunctionCall res, InstFunctionArgument[] args) {
                    int o = res.argsOffset();
                    for (int i = 0; i < numArgs; i++) {
                        res.setChild(extractFExp(args[i]), i + o);
                    }
				}
				
				public boolean isInfArgs() {
					return false;
				}
				
				protected static FExp extractFExp(InstFunctionArgument arg) {
                    return arg.getOriginalFExp().fullCopy();
				}
				
                public boolean match(BIT t) {
                    return type == t;
                }
				
			}
			
			private static class InfArgsBuiltInCreator extends BuiltInCreator {
				
				public InfArgsBuiltInCreator(FBuiltInFunctionCall tmpl, int nFixed) {
				    super(BIT.NONE, tmpl, nFixed);
				}
				
				protected void setArguments(FBuiltInFunctionCall res, InstFunctionArgument[] args) {
					List<FExp> exps = new List<FExp>();
					for (int i = numArgs; i < args.length; i++)
						exps.add(extractFExp(args[i]));
                    res.setChild(exps, 1);
                    int o = res.argsOffset();
                    for (int i = 0; i < numArgs; i++) {
                        res.setChild(extractFExp(args[i]), i + o);
                    }
				}
				
				public boolean isInfArgs() {
					return true;
				}
				
			}
			
			private static class VarArgsBuiltInCreator extends BuiltInCreator {
                private int maxArgs;
                public boolean generateMissing = false;
                
                public VarArgsBuiltInCreator(FBuiltInFunctionCall tmpl, int minArgs, int maxArgs) {
                    this(tmpl, minArgs, maxArgs, false);
                }
                
                public VarArgsBuiltInCreator(FBuiltInFunctionCall tmpl, int minArgs, int maxArgs, boolean generateMissing) {
                    super(BIT.NONE, tmpl, minArgs);
                    this.maxArgs = maxArgs;
                    this.generateMissing = generateMissing;
                }
                
                protected void setArguments(FBuiltInFunctionCall res, InstFunctionArgument[] args) {
                    super.setArguments(res, args);
                    int o = res.argsOffset();
                    for (int i = numArgs; i < maxArgs; i++) {
                        if (generateMissing) {
                            res.setChild(extractFExp(args[i]), i + o);
                        } else {
                            res.setChild(args[i].isGiven() ? new Opt(extractFExp(args[i])) : new Opt(), i + o);
                        }
                    }
                }
			}
			
			private static class UnsupportedBuiltInCreator extends InfArgsBuiltInCreator {
				
				private static final FUnsupportedBuiltIn tmpl = new FUnsupportedBuiltIn();
				
				private String name;
				
				public UnsupportedBuiltInCreator(String name) {
					this(name, tmpl);
				}
				
				protected UnsupportedBuiltInCreator(String name, FUnsupportedBuiltIn tmpl2) {
					super(tmpl2, 0);
					this.name = name;
				}
				
				protected void setArguments(FBuiltInFunctionCall res, InstFunctionArgument[] args) {
					((FUnsupportedBuiltIn) res).setName(name);
				}
				
			}
			
			private static class IgnoredBuiltInCreator extends UnsupportedBuiltInCreator {
				
				private static final FIgnoredBuiltIn tmpl = new FIgnoredBuiltIn();
				
				public IgnoredBuiltInCreator(String name) {
					super(name, tmpl);
				}
				
			}
			
		}
    /**
     * Select the function in the given operator for the given type that best fits this call, and 
     * create an argument binding for it.
     * 
     * Returns null if the type does not have any functions for that operator.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:690
     */
    public ArgumentBinding matchOverloadedFunctionCall(FType type, String operator) {
        ArgumentBinding binding = null;
        InstClassDecl op = type.getOperators().get(operator);
        if (op != null) {
            int score = Integer.MAX_VALUE;
            for (InstClassDecl func : op.operatorFunctions()) {
                ArgumentBinding binding2 = new ArgumentBinding(func, this, false);
                int score2 = binding2.typeMatchScore();
                if (score2 < score) {
                    score = score2;
                    binding = binding2;
                }
            }
            if (binding != null)
                binding.updateBoundInputs();
        }
        return binding;
    }
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:804
     */
    private boolean bound = false;
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:805
     */
    public boolean generated = false;
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:866
     */
    private boolean vectorizationChecked = false;
    /**
     * @declaredat ASTNode:1
     */
    public InstFunctionCall() {
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
        children = new ASTNode[4];
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Arg"},
        type = {"InstAccess", "List<InstFunctionArgument>"},
        kind = {"Child", "List"}
    )
    public InstFunctionCall(InstAccess p0, List<InstFunctionArgument> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:30
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:34
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        cevalFunction_VariableEvaluator_reset();
        type_reset();
        getFType_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public InstFunctionCall clone() throws CloneNotSupportedException {
        InstFunctionCall node = (InstFunctionCall) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public InstFunctionCall copy() {
        try {
            InstFunctionCall node = (InstFunctionCall) clone();
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
     * @declaredat ASTNode:72
     */
    @Deprecated
    public InstFunctionCall fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:82
     */
    public InstFunctionCall treeCopyNoTransform() {
        InstFunctionCall tree = (InstFunctionCall) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
                case 3:
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
     * @declaredat ASTNode:108
     */
    public InstFunctionCall treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:113
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public InstAccess getName() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public InstAccess getNameNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Arg list.
     * @param list The new list node to be used as the Arg list.
     * @apilevel high-level
     */
    public void setArgList(List<InstFunctionArgument> list) {
        setChild(list, 1);
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
    public InstFunctionArgument getArg(int i) {
        return (InstFunctionArgument) getArgList().getChild(i);
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
    public void addArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getArgListNoTransform() : getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
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
    public void setArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
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
    public List<InstFunctionArgument> getArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(1);
        return list;
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the Arg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getArgNoTransform(int i) {
        return (InstFunctionArgument) getArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getArgs() {
        return getArgList();
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgsNoTransform() {
        return getArgListNoTransform();
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(2);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 2;
    }
    /**
     * Retrieves the FType child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FType child.
     * @apilevel low-level
     */
    public FType getFTypeNoTransform() {
        return (FType) getChildNoTransform(3);
    }
    /**
     * Retrieves the child position of the optional child FType.
     * @return The the child position of the optional child FType.
     * @apilevel low-level
     */
    protected int getFTypeChildPosition() {
        return 3;
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
        ndims_value = hasOutputs() ? expOutput().ndims() : -1;
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
        size_value = hasOutputs() ? sizeOfOutput(0) : Size.SCALAR;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
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
            if (variability().knownParameterOrLess()) {
                try {
                    ArrayExp arr = new ArrayExp(indices());
                    CValue val = cevalArray(Index.NULL);
                    if (val.isArray()) {
                        CValueArray carr = val.array();
                        for (Index i : arr.indices()) {
                            arr.set(i, carr.getCell(i).buildInstLiteral());
                        }
                        return arr;
                    }
                } catch (ConstantEvaluationException r) {
                    // Constant evaluation may fail even if variability is known parameter or less.
                    // If so we want to do the same thing we would do if variability was higher.
                }
            }
            return super.getArrayExp();
        }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315")
    public CValue cevalArray(VariableEvaluator evaluator, Index i) {
        CValue cevalArray_VariableEvaluator_Index_value = cevalCalc(evaluator);
        return cevalArray_VariableEvaluator_Index_value;
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
        CValue cevalCalc_VariableEvaluator_value = hasOutputs() ? evaluate(evaluator)[0] : CValue.UNKNOWN;
        return cevalCalc_VariableEvaluator_value;
    }
    /** @apilevel internal */
    private void cevalFunction_VariableEvaluator_reset() {
        cevalFunction_VariableEvaluator_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map cevalFunction_VariableEvaluator_values;

    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3442
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3442")
    public CValue[] cevalFunction(VariableEvaluator evaluator) {
        Object _parameters = evaluator;
        if (cevalFunction_VariableEvaluator_values == null) cevalFunction_VariableEvaluator_values = new java.util.HashMap(4);
        ASTState state = state();
        if (cevalFunction_VariableEvaluator_values.containsKey(_parameters)) {
            return (CValue[]) cevalFunction_VariableEvaluator_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        CValue[] cevalFunction_VariableEvaluator_value = evaluate(evaluator);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        cevalFunction_VariableEvaluator_values.put(_parameters, cevalFunction_VariableEvaluator_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return cevalFunction_VariableEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3506
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3506")
    public FExp argument(int i) {
        FExp argument_int_value = getArg(i).getFExp();
        return argument_int_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633")
    public boolean isCircularCalc() {
        {
        		for (InstFunctionArgument a : getArgs())
        			if (a.isCircular())
        				return true;
        		return false;
        	}
    }
    /**
     * Check if tree contains a function call returning an array or a record.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2638
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2638")
    public boolean hasCompositeFunc() {
        boolean hasCompositeFunc_value = type().isArray() || type().isRecord() || super.hasCompositeFunc();
        return hasCompositeFunc_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:338")
    public String name() {
        String name_value = getNameNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078")
    public CommonCallable myCommonCallable() {
        CommonCallable myCommonCallable_value = myInstCallable();
        return myCommonCallable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1267")
    public ArrayList<InstComponentDecl> myCallInputs() {
        ArrayList<InstComponentDecl> myCallInputs_value = myInstCallable().myCallInputs();
        return myCallInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1295
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1295")
    public ArrayList<InstComponentDecl> myCallOutputs() {
        ArrayList<InstComponentDecl> myCallOutputs_value = myInstCallable().myOutputs();
        return myCallOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1322")
    public boolean hasOutputs() {
        boolean hasOutputs_value = !myCallOutputs().isEmpty();
        return hasOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1327
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1327")
    public InstComponentDecl expOutput() {
        InstComponentDecl expOutput_value = myCallOutputs().get(0);
        return expOutput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:785
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:785")
    public FType typeOfOutput(int i) {
        FType typeOfOutput_int_value = getFType().component(i);
        return typeOfOutput_int_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500")
    public boolean isConstructorCall() {
        boolean isConstructorCall_value = getName().myInstClassDecl().isConstructor();
        return isConstructorCall_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1503
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1503")
    public boolean isDestructorCall() {
        boolean isDestructorCall_value = getName().myInstClassDecl().isDestructor();
        return isDestructorCall_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446")
    public String functionCallDecription() {
        String functionCallDecription_value = getName().myInstClassDecl().isRecord() ? 
        			"Record constructor for " + name() : super.functionCallDecription();
        return functionCallDecription_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:100")
    public String classErrorType() {
        String classErrorType_value = "function";
        return classErrorType_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:104")
    public String classErrorName() {
        String classErrorName_value = name() + "()";
        return classErrorName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520")
    public boolean allowUnknownSize() {
        boolean allowUnknownSize_value = inAllowUnknownSize() && callsExternal();
        return allowUnknownSize_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573")
    public boolean containsFunction(FFunctionDecl.FunctionType ft) {
        boolean containsFunction_FFunctionDecl_FunctionType_value = ft.containsFunction(myCommonCallable()) || super.containsFunction(ft);
        return containsFunction_FFunctionDecl_FunctionType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1455")
    public boolean isPartialFunctionCall() {
        boolean isPartialFunctionCall_value = false;
        return isPartialFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1310")
    public boolean externalDependency() {
        boolean externalDependency_value = ((InstNode)myInstCallable()).externalDependency();
        return externalDependency_value;
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:84
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:84")
    public boolean isNonVectorizedFunctionCall() {
        boolean isNonVectorizedFunctionCall_value = true;
        return isNonVectorizedFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:127
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:127")
    public Map<InstComponentDecl, InstFunctionArgument> inputArgMap() {
        {
                Map<InstComponentDecl,InstFunctionArgument> res = new HashMap<InstComponentDecl, InstFunctionArgument>();
                int i = 0;
                for (InstComponentDecl icd : myInstClassDecl().allInstComponentDecls()) {
                    res.put(icd, i < getNumArg() && icd.isInput() ? getArg(i++) : null);
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:807
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:807")
    public ArrayList<InstComponentDecl> myInputsToBind(InstCallable target) {
        ArrayList<InstComponentDecl> myInputsToBind_InstCallable_value = target.myCallInputs();
        return myInputsToBind_InstCallable_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:591
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:591")
    public InstClassDecl myInstClassDecl() {
        InstClassDecl myInstClassDecl_value = getName().myInstClassDecl();
        return myInstClassDecl_value;
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
        type_value = hasOutputs() ? typeOfOutput(0) : fUnknownType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:167
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:167")
    public FFunctionType declType() {
        FFunctionType declType_value = myInstCallable().actualInstClassDecl().functionType();
        return declType_value;
    }
    /** @apilevel internal */
    private void getFType_reset() {
        getFType_computed = false;
        
        getFType_value = null;
    }
    /** @apilevel internal */
    protected boolean getFType_computed = false;

    /** @apilevel internal */
    protected FType getFType_value;

    /**
     * @attribute syn nta
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:169
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:169")
    public FType getFType() {
        ASTState state = state();
        if (getFType_computed) {
            return (FType) getChild(getFTypeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFType_value = declType().treeCopy().removeInputs().createSizeFExp(this);
        setChild(getFType_value, getFTypeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FType node = (FType) this.getChild(getFTypeChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        {
                TypePrefixVariability total = Variability.CONSTANT;
                for (InstFunctionArgument arg : getArgs()) {
                    if (arg.isOKArg()) {
                        arg.getFExp();
                        total = total.combine(arg.getOriginalFExp().variability().combine());
                    }
                }
                return total;
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:357
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:357")
    public List<InstFunctionArgument> myInstFunctionArguments() {
        List<InstFunctionArgument> myInstFunctionArguments_value = getArgs();
        return myInstFunctionArguments_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1605
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1605")
    public InstCallable myInstCallable() {
        InstCallable myInstCallable_value = getName().myInstCallable();
        return myInstCallable_value;
    }
    /**
     * @attribute syn
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:897
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SmoothOrder", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:897")
    public int smoothOrder() {
        int smoothOrder_value = myInstClassDecl().smoothOrder();
        return smoothOrder_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345
     * @apilevel internal
     */
    public CommonVariableDecl Define_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3347
            int i = _callerNode.getIndexOfChild(_childNode);
            return myInstCallable().myCallInputs().get(i);
        }
        else {
            return getParent().Define_myCorrespondingInput(this, _callerNode);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378
     * @apilevel internal
     */
    public boolean Define_isBound(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3381
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return false;
        }
        else {
            return getParent().Define_isBound(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3378
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBound
     */
    protected boolean canDefine_isBound(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     * @apilevel internal
     */
    public FAbstractFunctionCall Define_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionCall
     */
    protected boolean canDefine_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526
     * @apilevel internal
     */
    public boolean Define_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return allowUnknownSize() || callsExternal();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAllowUnknownSize
     */
    protected boolean canDefine_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532
     * @apilevel internal
     */
    public boolean Define_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1533
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return isDestructorCall();
        }
        else {
            return super.Define_isDestructorArgument(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorArgument
     */
    protected boolean canDefine_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:112
            return Kind.AMBIGUOUS_ACCESS;
        }
        else {
            return getParent().Define_kind(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute kind
     */
    protected boolean canDefine_kind(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:722
        if (!bound) {
            return rewriteRule0();
        }
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:843
        if (bound && !vectorizationChecked) {
            return rewriteRule1();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:722
     * @apilevel internal
     */
    private FAbstractFunctionCall rewriteRule0() {
{
            // Make sure we only do this once.
            bound = true;

            // Get info
            boolean generated = this.generated;
            InstCallable target = getName().myInstCallable();
            InstCallable namedTarget = target;
            String name = target.qualifiedName();
            ArgumentBinding binding = null;

            // Handle special cases
            if (target.isPrimitive()) {
                // Check if this is an overloaded version of String()
                // TODO: Error if several perfect matches
                // TODO: Make toString() match original decl
                if (target.name().equals("String") && getNumArg() > 0) 
                    binding = matchOverloadedFunctionCall(getArg(0).getFExp().type(), FExp.OP_STR);
                if (binding != null) {
                    target = binding.target();
                    name = target.qualifiedName();
                    generated = true;
                } else {
                    // If not, look for conversion operator with same name as primitive class (if one exists)
                    InstLookupResult<InstClassDecl> icd = getName().lookupInstClass("!" + target.name());
                    if (icd.successful())
                        target = icd.target();
                }
            } else if (target.isExternalObject()) {
                // Use the external object constructor
                InstClassDecl icd = target.asInstClassDecl().myConstructor();
                if (icd.isFunction())
                    target = icd;
                generated = true;
            } else if (target.isOperatorRecord()) {
                // If the operator record defines constructors, find the one that matches the best
                // TODO: Error if several perfect matches
                // TODO: Make toString() match original decl
                // TODO: handle vectorized constructors
                binding = matchOverloadedFunctionCall(target.asInstClassDecl().recordType(), FExp.OP_CON);
                if (binding != null) {
                    target = binding.target();
                    generated = true;
                }
            }

            /* If we can't resolve the name as a function or record, don't try to bind arguments, 
             * just leave it for the error check. */
            if (!target.isCallable())
                return this;

            // Bind arguments
            boolean infArgs = builtInTranslator.isInfArgs(name);
            if (binding == null)
                binding = new ArgumentBinding(target, this, infArgs);

            // Create replacement node.
            FAbstractFunctionCall n = null;
            if (binding.isOK()) 
                n = builtInTranslator.create(name, binding.bound());
            if (n == null) {
                if (target.isRecord() && binding.isOK()) {
                    n = new InstRecordConstructor(getName(), new List());
                } else {
                    InstAccess accessName = generated ? target.asInstClassDecl().retargetFrom(namedTarget.asInstClassDecl(), getName()) : getName();
                    InstFunctionCall ifc = createEmptyNode();
                    ifc.setName(accessName);
                    ifc.generated = generated;
                    ifc.unbindableArgs = binding.unbindable();
                    ifc.bound = true;
                    n = ifc;
                }
                for (InstFunctionArgument arg : binding.bound())
                    n.addArgument(arg);
            } else if (infArgs) {
                n.setUnbindableArgsList(binding.unbindable());
            }
            n.setLocation(this);

            return n;
        }    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:843
     * @apilevel internal
     */
    private InstFunctionCall rewriteRule1() {
{
            vectorizationChecked = true;
            
            if (isFunctionCallClause() && myLefts().size() != 1)
                return this;
            if (getName().myInstClassDecl().isUnknown() || !unbindableArgs.isEmpty())
                return this;
            if (!hasOutputs() || !myCallOutputs().get(0).isAssignable())
                return this;
            
            int dims = 0;
            for (InstFunctionArgument arg : getArgs()) 
                dims = arg.findVectorizationNdims(dims);
            if (dims <= 0)
                return this;
            
            InstFunctionCall res = new InstVectorFunctionCall(getName(), getArgs(), dims);
            res.vectorizationChecked = res.bound = true;
            res.generated = generated;
            res.setLocation(this);
            return res;
        }    }
}
