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
 * Generic function call expression in flat tree.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1179
 * @astdecl FFunctionCall : CommonFunctionCall ::= Name:FAccess Arg:FExp* FType;
 * @production FFunctionCall : {@link CommonFunctionCall} ::= <span class="component">Name:{@link FAccess}</span> <span class="component">Arg:{@link FExp}*</span> <span class="component">{@link FType}</span>;

 */
public class FFunctionCall extends CommonFunctionCall implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3574
     */
    @Override
    public void evaluateCell(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        myCommonCallable().evaluate(evaluator, values);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1001
     */
    public FFunctionCall createEmptyNode()           { return new FFunctionCall();           }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1738
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
        str.print(getName().name(), "(");
        getArgs().prettyPrintWithSep(p, str, "", ", ");
        str.print(")");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1116
     */
    public FExp affixExpression(FExp exp) {
        // can't use dynamicExp(), since this node might not be in tree (InstFunctionCall.flatten())
        // TODO: if InstFunctionCall.flatten() is changed so that the size is flattened in a 
        //       rewrite on FFunctionCall instead, then dynamicExp() can be used here
        exp.parent = this;
        return exp;
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2772
     */
    public FFunctionCall flatten(Flattener f) {
        List args = new List();
        for (FExp e : getArgs()) 
            args.add(e.flatten(f));
        getFTypeNoTransform().clearFlattened();
        return new FFunctionCall(getName().flatten(f), args, getFType().flatten(f, null, true));
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:148
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        myFCallable().markUsedGlobals(type);
        super.markUsedGlobals(type);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:66
     */
    public void sanityCheckCommonAccessConsistency(FClass fc) {
        sanityCheckCommonAccessConsistencyInChildren(fc);
        
        if (myFCallable() == null) {
            fc.sanityProblem(this, "Function not found in function call:\n    %s", this);
        }
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:110
     */
    public void findBlockFunctionExtraction(AbstractEquationBlock block, ArrayList<FFunctionCall> functions) {
        for (FExp exp: getArgs())
            if (exp.dependsOnBlock(block)) {
                for (FExp expr: getArgs()) 
                    expr.findBlockFunctionExtraction(block, functions);
                return;
            }
        functions.add(this);
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:157
     */
    public boolean dependsOnBlock(AbstractEquationBlock block) {
        for (FExp exp: getArgs()) {
            if (exp.dependsOnBlock(block)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:175
     */
    public void collectFunctionCalls(FClass.commonSubexpressionEliminationIfSet m) {
        /* We dont try to eliminate nested function call expressions to avoid some complicated cases */
        m.add(this);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:514
     */
    public void addInliningVarsAndEqns(AbstractFunctionInliner fi, String oldName, boolean noEvent) {
        if (isComposite()) {
            TypePrefixVariability v = fi.contextVariability(this);
            if (v.constantVariability()) {
                try {
                    CValue cval = ceval();
                    if (cval.hasBuildLiteral()) {
                        dynamicFExp(cval.buildLiteral()).addInliningVarsAndEqns(fi, oldName, noEvent);
                        return;
                    }
                } catch (ConstantEvaluationException e) {}
            }
            String tempName = fi.nextTempVarName();
            FExp exp = type().addInliningVarsAndEqns(fi, oldName, noEvent, this, tempName);
            List<FFunctionCallLeft> l = new List<FFunctionCallLeft>();
            l.add(new FFunctionCallLeft(new Opt<FExp>(exp)));
            fi.addEquation(new FFunctionCallEquation(l, treeCopy()));
        } else {
            super.addInliningVarsAndEqns(fi, oldName, noEvent);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:625
     */
    public FExp preventEvents() {
        for (FExp e : getArgs())
            e.preventEvents();
        return this;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:896
     */
    public void inlineFunctions(AbstractFunctionInliner fi) {
        if (isInlinableFunctionCall(fi)) {
            inline(fi);
            replaceMe(type().replaceInlined(fi, myCallOutputs().get(0).name()));
        } else {
            super.inlineFunctions(fi);
        }
    }
    /**
     * Inline this function call. 
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:999
     */
    public void inline(AbstractFunctionInliner fi) {
        myFCallable().inline(fi, getArgs());
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1454
     */
    public FExp scalarize(Scalarizer s) {
        FExp exp = super.scalarize(s);
        indexNames = null;
        return exp;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1792
     */
    public FFunctionCall scalarizeExp(Scalarizer s) {
        List<FExp> args = new List<FExp>();
        for (FExp arg : getArgs()) {
            args.add(arg.scalarize(s));
        }
        FFunctionCall res = createScalarized(getName().treeCopy(), args, null);
        res.setFType(getFType().scalarize(s, res));
        return res;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1901
     */
    protected FFunctionCall createScalarized(FAccess name, List<FExp> args, FType type) {
        return setLocationOf(new FFunctionCall(name, args, type)); 
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:275
     */
    public void createArrayTemporaries(Scalarizer s) {
        // No names available as a function call arg.
        boolean b = !extractTemp();
        if (b)
            s.getNames().addLayer(0);
        super.createArrayTemporaries(s);
        if (b)
            s.getNames().removeLayer();
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:986
     */
    public void addArrayUsesToIndexMap(FExp[] names) {
        // No names available as a function call arg.
        if (extractTemp()) {
            super.addArrayUsesToIndexMap(names);
        }
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:601
     */
    private int order = 0;
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:603
     */
    @Override
    protected FExp diffExp(String name) {
        // If the function does not have an argument that matches name,
        // and the name is not 'time', then the derivative is zero.
        if (!name.equals(TIME)) {
            boolean isIndependent = true;
            FAbstractVariable fv = getName().lookupFV(name);
            if (fv != null) {
                HashSet<FVariable> s = new HashSet<FVariable>();
                s.add((FVariable) fv);
                for (FExp e : getArgs()) {
                    if (!e.isIndependent(s)) {
                        isIndependent = false;
                        break;
                    }
                }
                if (isIndependent) {
                    return new FRealLitExp(0);
                }
            }
        }
        
        if (isConstantExp()) {
            return diffZero();
        }
        
        FFunctionDecl myDecl = myFCallable().asFFunctionDecl();
        if (myDecl == null)
            throw new FunctionDifferentiationException(this);
        AnnotationNode derNode = derivativeAnnotation();
        
        FCallable myDiffDecl = myDecl.diff(derNode, inFunction());
        if (myDiffDecl == null)
            throw new FunctionDifferentiationException(this);
        List args = new List();
        for (FExp e : getArgs()) {
            args.add(e.copySymbolic());
        }
        int i = 0;
        for (FExp e : getArgs()) {
            FFunctionVariable fv = myDecl.myInput(i);
            if (fv.shouldBeDifferentiated(derNode))
                args.add(e.diff(name));
            i++;
        }
        FFunctionCall der_f = new FFunctionCall(new FAccessString(myDiffDecl.name()), args, getFType().treeCopy());
        der_f.order = order + 1;
        return der_f;
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:216
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		open_XML(str, indent);
		enclose_XML(p, str, indent2, "Name", getName());
		enclose_XML(p, str, indent2, "Arguments", getArgs());
		close_XML(str, indent);
	}
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1291
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        getArgs().genTempArg(p.DeclStep, str, indent);
        if (p.needsTemp(this)) {
            if (myFCallable().isPartialFunction()) {
                str.formatln("%s%s %s;", indent, p.funcNameUnderscore(myFCallable().actualFFunctionDecl(), C_SUFFIX_FPOUT), tempName_C());
                if (p.needsOutputVarArgs()) {
                    p.print(this, indent, type(), p.createDeclPrinter(str));
                }
            } else {
                p.print(this, indent, type(), p.createDeclPrinter(str));
            }
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1306
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        getArgs().genTempArg(p.PreStep, str, indent);
        if (p.needsTemp(this)) {
            p.print(this, indent, type(), p.createInitPrinter(str));
        }
        if (p.needsStatement(this)) {
            p.printCall(this, str, indent);
            getArgs().genTempArg(p.PostStep, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1318
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (p.needsStatement(this)) {
            str.print(tempName_C());
        } else if (impureCodeGen(p)) {
            str.print("JMI_CACHED(", tempName_C(), ", ");
            p.printCall(this, str, indent);
            str.print(")");
        } else {
            p.printCall(this, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1331
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        if (!p.needsStatement(this)) {
            getArgs().genTempArg(p.PostStep, str, indent);
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:53
     */
    @Override
    public void genTempInputDecl_C(CodePrinter p, CodeStream str, String indent) {
        // Handled in genVarDecls
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:74
     */
    @Override
    public void genTempInputAssigns_C(CodePrinter p, CodeStream str, String indent) {
        // Handled in genTempVars
    }
    /**
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:89
     */
    public void genStaticVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent, "jmi_real_t ", tempName_C(), ";\n");
        str.print(indent, "int ", FExp.computed_C(tempName_C()), ";\n");
    }
    /**
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:120
     */
    public void genStaticTempVars_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent, FExp.global_C(FExp.computed_C(tempName_C())), " = 0;\n");
    }
    /**
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:150
     */
    public void gatherBlockSetupNodes(CodePrinter p, Collection<FFunctionCall> res) {
        super.gatherBlockSetupNodes(p, res);
        if (impureCodeGen(p)) {
            res.add(this);
        }
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:489
     */
    public void genGlobalVariableInitCall_C(CodePrinter p, CodeStream str, String indent, String name, boolean expand) {
        str.print(indent, name, " = jmi_global_", tempName_C(), "(jmi);\n");
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:518
     */
    @Override
    public void genDestructorCall_C(CodePrinter p, CodeStream str, String indent, FGlobalVariable v) {
        if (isConstructorCall()) {
            String strName = v.type().name() + ".destructor";
            FCallable c = getName().lookupFCallable(strName);
            str.print(indent, c.funcNameUnderscore(C_SUFFIX_DEF), "(", FExp.global_C(v.nameUnderscore()), ");\n");
        }
    }
    /** @return A MXVector with the used MX outputs for this function call 
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:348
     */
    MXVector retrieveUsedOutputsFromMXFunctionCall(MXVector callVector) {
        MXVector usedCalls = new MXVector();
        ArrayList<FFunctionCallLeft> lefts = myLefts();
        int index = 0;
        ArrayList<FFunctionCallLeft> myLefts = myLefts();
        ArrayList<FFunctionVariable> myOutVars = myFCallable().myOutputs();
        for (int i = 0; i < myLefts.size(); ++i) {
            if (myLefts.get(i).hasFExp()) {
                for (int j = 0; j < myLefts.get(i).getFExp().toMXVector().size(); ++j) {
                    usedCalls.add(callVector.get(index + j));
                }
            } 
            index += myOutVars.get(i).asMXVector().size();
        }
        return usedCalls;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionCall() {
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
        name = {"Name", "Arg", "FType"},
        type = {"FAccess", "List<FExp>", "FType"},
        kind = {"Child", "List", "Child"}
    )
    public FFunctionCall(FAccess p0, List<FExp> p1, FType p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:31
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:35
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        cevalFunction_VariableEvaluator_reset();
        type_reset();
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
    public FFunctionCall clone() throws CloneNotSupportedException {
        FFunctionCall node = (FFunctionCall) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public FFunctionCall copy() {
        try {
            FFunctionCall node = (FFunctionCall) clone();
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
    public FFunctionCall fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:82
     */
    public FFunctionCall treeCopyNoTransform() {
        FFunctionCall tree = (FFunctionCall) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
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
     * @declaredat ASTNode:107
     */
    public FFunctionCall treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:112
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(FAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public FAccess getName() {
        return (FAccess) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public FAccess getNameNoTransform() {
        return (FAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Arg list.
     * @param list The new list node to be used as the Arg list.
     * @apilevel high-level
     */
    public void setArgList(List<FExp> list) {
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
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addArgNoTransform(FExp node) {
        List<FExp> list = getArgListNoTransform();
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
    public void setArg(FExp node, int i) {
        List<FExp> list = getArgList();
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
    public List<FExp> getArgList() {
        List<FExp> list = (List<FExp>) getChild(1);
        return list;
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<FExp> getArgListNoTransform() {
        return (List<FExp>) getChildNoTransform(1);
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
     * Replaces the FType child.
     * @param node The new node to replace the FType child.
     * @apilevel high-level
     */
    public void setFType(FType node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the FType child.
     * @return The current node used as the FType child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FType")
    public FType getFType() {
        return (FType) getChild(2);
    }
    /**
     * Retrieves the FType child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FType child.
     * @apilevel low-level
     */
    public FType getFTypeNoTransform() {
        return (FType) getChildNoTransform(2);
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(3);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
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
            FClass fc = myFClass();
            if (!isComposite() || fc == null) {
                return super.getArrayExp();
            }
            
            if (isArray() && variability().knownParameterOrLess() && inKeptBExp()) {
                ArrayExp arr = new ArrayExp(indices());
                CValueArray carr = (CValueArray) cevalArray(Index.NULL);
                for (Index i : arr.indices()) {
                    arr.set(i, carr.getCell(i).buildLiteral());
                }
                return arr;
            }
            
            if (isFunctionCallArg()) {
                return super.getArrayExp();
            }
            
            return createTempArray();
        }
    /**
     * Extract a subcomponent of this record expression. Creates new nodes when necessary.
     * Similar to getArray() for arrays.
     * @attribute syn
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Components", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23")
    public FExp component(String name) {
        {
                FClass fc = myFClass();
                if (!isComposite() || fc == null) {
                    return super.component(name);
                }
                return dynamicFExp(dynamicFExp(new FAccessExp(tempVarName())).component(name));
            }
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
        CValue cevalCalc_VariableEvaluator_value = evaluate(evaluator)[0];
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3441
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3441")
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
        FExp argument_int_value = getArg(i);
        return argument_int_value;
    }
    /**
     * @attribute syn
     * @aspect LiteralExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4601
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LiteralExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4601")
    public boolean hasOnlyLiterals() {
        boolean hasOnlyLiterals_value = false;
        return hasOnlyLiterals_value;
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
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:260")
    public FCallable myFCallable() {
        FCallable myFCallable_value = getName().myFCallable();
        return myFCallable_value;
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
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:430
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:430")
    public String funcNameUnderscore(String suffix) {
        String funcNameUnderscore_String_value = getName().funcNameUnderscore(suffix) + functionIndex();
        return funcNameUnderscore_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:451
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:451")
    public int functionIndex() {
        int functionIndex_value = myFCallable().functionIndex();
        return functionIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078")
    public CommonCallable myCommonCallable() {
        CommonCallable myCommonCallable_value = myFCallable();
        return myCommonCallable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1112
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1112")
    public boolean isPartialFunctionCall() {
        boolean isPartialFunctionCall_value = false;
        return isPartialFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1269
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1269")
    public ArrayList<FFunctionVariable> myCallInputs() {
        ArrayList<FFunctionVariable> myCallInputs_value = myFCallable().myInputs();
        return myCallInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1297
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1297")
    public ArrayList<FFunctionVariable> myCallOutputs() {
        ArrayList<FFunctionVariable> myCallOutputs_value = myFCallable().myOutputs();
        return myCallOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1321")
    public boolean hasOutputs() {
        boolean hasOutputs_value = !myCallOutputs().isEmpty();
        return hasOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1326
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1326")
    public FFunctionVariable expOutput() {
        FFunctionVariable expOutput_value = myCallOutputs().get(0);
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
        type_value = hasOutputs() ? typeOfOutput(0) : fNoType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1500")
    public boolean isConstructorCall() {
        boolean isConstructorCall_value = myFCallable().isConstructor();
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
        boolean isDestructorCall_value = myFCallable().isDestructor();
        return isDestructorCall_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = inputVariability().combineDown(type().funcOutputVariability());
        return expVariability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:620
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:620")
    public TypePrefixVariability inputVariability() {
        TypePrefixVariability inputVariability_value = super.expVariability();
        return inputVariability_value;
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
     * Return the derivative annotation matching this function call.
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:324")
    public AnnotationNode derivativeAnnotation() {
        {
                FFunctionDecl myDecl = myFCallable().asFFunctionDecl();
                if (myDecl == null)
                    return null;
                
                Set<String> zeroDer = new HashSet<String>();
                for (int i = 0, n = getNumArg(); i < n; i++) {
                    if (getArg(i).variability().parameterOrLess()) {
                        zeroDer.add(myDecl.myInput(i).name());
                    }
                }
                return myDecl.derivativeAnnotation(order + 1, zeroDer);
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970")
    public boolean isAnnotationExp() {
        boolean isAnnotationExp_value = true;
        return isAnnotationExp_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978")
    public Iterable<? extends ASTNode> annotationList() {
        Iterable<? extends ASTNode> annotationList_value = getArgs();
        return annotationList_value;
    }
    /**
     * Check if an expression contains any calls to functions that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:748
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:748")
    public boolean hasInlinableFunctions(AbstractFunctionInliner fi) {
        boolean hasInlinableFunctions_AbstractFunctionInliner_value = isInlinableFunctionCall(fi) || super.hasInlinableFunctions(fi);
        return hasInlinableFunctions_AbstractFunctionInliner_value;
    }
    /**
     * Check if an expression is a call to a function that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:806
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:806")
    public boolean isInlinableFunctionCall(AbstractFunctionInliner fi) {
        boolean isInlinableFunctionCall_AbstractFunctionInliner_value = myFCallable().isInlinable(fi, this);
        return isInlinableFunctionCall_AbstractFunctionInliner_value;
    }
    /**
     * Helper method to find unsupported statements in isTrivialInlinable().
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1134")
    public boolean isOkTrivialInline() {
        boolean isOkTrivialInline_value = true;
        return isOkTrivialInline_value;
    }
    /**
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:52
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:52")
    public TypePrefixVariability potentialPartialVariability() {
        {
                for (FExp exp : getArgs()) {
                    if (exp.variability().knownParameterOrLess()) {
                        return Variability.CONSTANT;
                    }
                }
                return super.potentialPartialVariability();
            }
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460")
    public boolean scalarizeExpanded() {
        boolean scalarizeExpanded_value = ((useTempVar && !inFunction()) || isVectorized()) && super.scalarizeExpanded();
        return scalarizeExpanded_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1469
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1469")
    public boolean isVectorized() {
        boolean isVectorized_value = false;
        return isVectorized_value;
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
        boolean extractTemp_value = isFunctionCallClause() || 
                ((isFVectorFunctionCallArg() || !isFunctionCallIO()) &&
                    (isComposite() || isForIndexExp()));
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
        boolean scalarizeAsFunctionCallClause_value = true;
        return scalarizeAsFunctionCallClause_value;
    }
    /**
     * @attribute syn
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:67
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SizeAsserts", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:67")
    public ArrayList<FAssert> sizeAsserts() {
        {
                ArrayList<FAssert> a = new ArrayList<FAssert>();
                Iterator<FFunctionVariable> inputs = myCallInputs().iterator();
                for (FExp arg : getArgs()) {
                    inputs.next().size().sizeAsserts(a, arg.size(), arg);
                }
                return a;
            }
    }
    /**
     * @attribute syn
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:898
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SmoothOrder", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:898")
    public int smoothOrder() {
        int smoothOrder_value = myFCallable().smoothOrder();
        return smoothOrder_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "FunctionCall";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062")
    public boolean isKnownStringLength() {
        boolean isKnownStringLength_value = false;
        return isKnownStringLength_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278")
    public boolean needsTemp_C() {
        boolean needsTemp_C_value = (!isFunctionCallClause() && isComposite()) || isStringExp() ||
                    (!functionCallIsExp() && myFCallable().isPartialFunction() && !isPartialFunctionCall());
        return needsTemp_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1288
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1288")
    public boolean needsStatement_C(CodePrinter p) {
        boolean needsStatement_C_CodePrinter_value = (functionCallIsExp() && isComposite()) || isStringExp() || !functionCallIsExp();
        return needsStatement_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1338")
    public boolean isStringExp() {
        boolean isStringExp_value = functionCallIsExp() && type().isString();
        return isStringExp_value;
    }
    /**
     * Check if this needs to cache its value
     * @return true if the value should be cached, else false
     * @attribute syn
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:75
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenGlobalsCached", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:75")
    public boolean impureCodeGen(CodePrinter p) {
        boolean impureCodeGen_CodePrinter_value = !type().isComposite() && !type().isString() &&
                    inWhen() && !isFunctionCallClause() && p.inBlock() && !dependsOnBlock(p.getBlock());
        return impureCodeGen_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CodeSplitter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeSplitter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196")
    public int numScalars_C() {
        {
                int n = super.numScalars_C();
                for (FExp exp : getArgs()) { 
                    if (exp.needsTemp_C()) {
                        n += exp.type().numScalarElements();
                    }
                }
                return n;
            }
    }
    /**
     * Returns this expression as A MX. Note that this might
     * not make sense for some expressions, e.g. function calls with
     * several outputs and FAccessExp for FFunctionArray.
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:282")
    public MX toMX() {
        { 
                return toMXVector().get(0);  
            }
    }
    /**
     * Returns this expression as A MXVector. 
     * @return A MXVector
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:271")
    public MXVector toMXVector() {
        {
                MXFunction f = myFCallable().toMXFunction();
                MXVector argVec = new MXVector();
                for (FExp exp : getArgs()) {
                    MXVector expMXVec = exp.toMXVector();
                    for (int i = 0; i < expMXVec.size(); ++i) {
                        argVec.add(expMXVec.get(i));
                    }
                }
                // To handle the case where some outputs are not used. 
                return  myLefts().size() > 0 ? retrieveUsedOutputsFromMXFunctionCall(f.call(argVec)) : f.call(argVec);
            }
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444")
    public boolean inAlgorithm() {
        boolean inAlgorithm_value = getParent().Define_inAlgorithm(this, null);
        return inAlgorithm_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3320
     * @apilevel internal
     */
    public boolean Define_inFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     * @apilevel internal
     */
    public boolean Define_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3327
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return super.Define_isFunctionCallArg(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallArg
     */
    protected boolean canDefine_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3345
     * @apilevel internal
     */
    public CommonVariableDecl Define_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3346
            int i = _callerNode.getIndexOfChild(_childNode);
            return myFCallable().myInput(i);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3653
     * @apilevel internal
     */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3653
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLinear
     */
    protected boolean canDefine_isLinear(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3688
     * @apilevel internal
     */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode, Set<FVariable> vars) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3688
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLinear
     */
    protected boolean canDefine_isLinear(ASTNode _callerNode, ASTNode _childNode, Set<FVariable> vars) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1528
            int i = _callerNode.getIndexOfChild(_childNode);
            return !getArg(i).isComposite();
        }
        else {
            return super.Define_functionCallIsExp(_callerNode, _childNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     */
    public String Define_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        if (_callerNode == getArrayExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1574
            return tempVarName();
        }
        else {
            return getParent().Define_calcGeneratedVarName(this, _callerNode, gvt);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:402
     * @apilevel internal
     */
    public boolean Define_inNonDiffArg(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:403
            int i = _callerNode.getIndexOfChild(_childNode);
            {
                    FFunctionDecl myDecl = myFCallable().asFFunctionDecl();
                    if (myDecl == null)
                        return false;
                    if (!myDecl.getFFunctionVariable(i).shouldBeDifferentiated(derivativeAnnotation()))
                        return true;
                    return inNonDiffArg();
                }
        }
        else {
            return getParent().Define_inNonDiffArg(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:402
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inNonDiffArg
     */
    protected boolean canDefine_inNonDiffArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     * @apilevel internal
     */
    public boolean Define_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inUnknownSize
     */
    protected boolean canDefine_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     */
    public boolean Define_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:127
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return super.Define_isFunctionCallIO(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallIO
     */
    protected boolean canDefine_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FStatement_sizeAssertsColl(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:42
        {
            FStatement target = (FStatement) (myFStatement());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FStatement_sizeAssertsColl(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_sizeAssertsColl(ArrayList<FAssert> collection) {
        super.contributeTo_FStatement_sizeAssertsColl(collection);
        collection.addAll(sizeAsserts());
    }
}
