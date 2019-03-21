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
 * If expression.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:975
 * @astdecl FIfExp : FAbstractArrayExp ::= IfExp:FExp ThenExp:FExp ElseExp:FExp;
 * @production FIfExp : {@link FAbstractArrayExp} ::= <span class="component">IfExp:{@link FExp}</span> <span class="component">ThenExp:{@link FExp}</span> <span class="component">ElseExp:{@link FExp}</span>;

 */
public class FIfExp extends FAbstractArrayExp implements Cloneable {
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:130
     */
    public FExp extractRecordFExp(String suffix) {
        return createNode(getIfExp().treeCopy(),
                getThenExp().extractRecordFExp(suffix),
                getElseExp().extractRecordFExp(suffix));
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:949
     */
    public FIfExp createEmptyNode()          { return new FIfExp();          }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1083
     */
    public FIfExp createNode(FExp ifExp, FExp thenExp, FExp elseExp) {
        FIfExp node = createEmptyNode();
        node.setIfExp(ifExp);
        node.setThenExp(thenExp);
        node.setElseExp(elseExp);
        return node;
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3061
     */
    @Override
    public void assignedInAllBranchesVariables(Set<String> res) {
        getIfExp().assignedInAllBranchesVariables(res);
        Set<String> a = getThenExp().assignedInAllBranchesVariables();
        Set<String> b = getElseExp().assignedInAllBranchesVariables();
        if (a.size() > b.size()) {
            Set<String> tmp = a;
            a = b;
            b = tmp;
        }
        for (String name : a) {
            if (b.contains(name)) {
                res.add(name);
            }
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1620
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
		prettyPrintAsElseExp(p, str, indent);
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1629
     */
    public void prettyPrintAsElseExp(Printer p, CodeStream str, String indent) {
		str.print("if ");
		p.print(getIfExp(), str, indent);
		str.print(" then ");
		p.print(getThenExp(), str, indent);
		str.print(" else");
		getElseExp().prettyPrintAsElseExp(p, str, indent);
	}
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2465
     */
    public FExp flatten(Flattener f) {
        if (getIfExpNoTransform().variability().knownParameterOrLess()) {
            try {
                CValue cval = getIfExpNoTransform().ceval();
                if (cval.hasBooleanValue()) {
                    return cval.booleanValue() ? 
                            getThenExp().flatten(f) : 
                            getElseExp().flatten(f);
                }
            } catch (ConstantEvaluationException e) {}
        }
        return new FIfExp(getIfExp().flatten(f),
                          getThenExp().flatten(f),
                          getElseExp().flatten(f));
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:169
     */
    public void collectFunctionCalls(FClass.commonSubexpressionEliminationIfSet m) {
        getIfExp().collectFunctionCalls(m);
        /* In the branches we would have to consider the conditions (if expression) before we extract
         * to a new equation. We also also have to consider the variability (is this a when-clause?). */
    }
    /**
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:78
     */
    public void constantFolding(VariableEvaluator evaluator) {
        if (!variability().knownParameterOrLess() && getIfExp().variability().knownParameterOrLess()) {
            super.constantFolding(evaluator);
            try {
                if (getIfExp().variability().knownParameterOrLess()) {
                    CValue cval = getIfExp().ceval(evaluator);
                    if (cval.hasBooleanValue()) {
                        replaceMe(cval.booleanValue() ? getThenExp() : getElseExp());
                    }
                }
            } catch (ConstantEvaluationException e) {}
        } else {
            super.constantFolding(evaluator);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1589
     */
    public FExp replaceReferences(AbstractFunctionInliner fi) {
        super.replaceReferences(fi);
        if (getIfExp().isConstantExp()) {
            boolean useThen = getIfExp().ceval().booleanValue();
            FExp exp = useThen ? getThenExp() : getElseExp();
            replaceMe(exp);
            return exp;
        }
        return this;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1088
     */
    public FExp scalarRecordFExp(Scalarizer s, FAccess suffix) {
        FIfExp res = new FIfExp();
        res.setIfExp(getIfExp().scalarize(s));
        res.setThenExp(getThenExp().scalarRecordFExp(s, suffix));
        res.setElseExp(getElseExp().scalarRecordFExp(s, suffix));
        return res;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1200
     */
    public FExp extractArrayCell(Scalarizer s, Index i) {
        FIfExp res = new FIfExp();
        res.setIfExp(getIfExp().scalarize(s));
        res.setThenExp(getThenExp().extractArrayCell(s, i));
        res.setElseExp(getElseExp().extractArrayCell(s, i));
        return dynamicFExp(res);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1596
     */
    public FExp scalarizeExp(Scalarizer s) {
        if (getIfExp().variability().indexParameterOrLess()) {
            try {
                return cevalSelectExp().scalarize(s);
            } catch (ConstantEvaluationException e) {}
        }
        return new FIfExp(getIfExp().scalarize(s),
                getThenExp().scalarize(s),
                getElseExp().scalarize(s));
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:213
     */
    public void createArrayTemporariesInChildren(Scalarizer s) {
        if (inFAlgorithm()) {
            List thenClauses = new List();
            List elseClauses = new List();
            getIfExp().createArrayTemporaries(s);
            getThenExp().createArrayTemporaries(s.block(thenClauses));
            getElseExp().createArrayTemporaries(s.block(elseClauses));
            if (thenClauses.getNumChild() > 0 || elseClauses.getNumChild() > 0) {
                List<FIfWhenClause> cl = new List<FIfWhenClause>();
                cl.add(new FIfClause(getIfExp().scalarize(s), thenClauses));
                ((Scalarizer.Algorithm)s).add(new FIfStmtTemp(cl, elseClauses));
            }
        } else {
            createArrayTemporariesIfBranch(null, s);
        }
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:257
     */
    public void createArrayTemporariesIfBranch(FExp guard, Scalarizer s) {
        if (guard == null) {
            getIfExp().createArrayTemporaries(s);
        } else {
            getIfExp().createArrayTemporariesIfBranch(guard.treeCopyNoTransform(), s);
        }
        FExp ifExp = getIfExp().scalarize(s);
        FExp thenGuard = ifExp.treeCopyNoTransform();
        FExp elseGuard = new FNotExp(ifExp.treeCopyNoTransform());
        if (guard != null) {
            thenGuard = new FAndExp(guard.treeCopyNoTransform(), thenGuard);
            elseGuard = new FAndExp(guard.treeCopyNoTransform(), elseGuard);
        }
        getThenExp().createArrayTemporariesIfBranch(thenGuard, s);
        getElseExp().createArrayTemporariesIfBranch(elseGuard, s);
    }
    /**
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:180
     */
    private FExp andIfExpConds(FExp e1) {
        FExp e2 = enclosingIfExpCond();
        if (e2 != null)
            e1 = new FAndExp(e2,e1);
        return e1;
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:409
     */
    @Override
    protected FExp diffExp(String name) {
        FExp td = getThenExp().diff(name);
        FExp ed = getElseExp().diff(name);
        boolean tz = td.equalsRealValue(0);
        boolean ez = ed.equalsRealValue(0);
        if (ez && tz) {
            return new FRealLitExp(0.0);
        } 
        FExp e = getIfExp().copySymbolic();
        return createNode(e, td, ed);
    }
    /**
     * Replaces an {@link FIfExp} with either branch if its test can be evaluated.
     * 
     * @param equations
     * The equation list where to put equations that are extracted from {@code true} branches.
     * Note that this is not used for this method.
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:189
     */
    public void eliminateIfEquations(List<FAbstractEquation> equations) {
        try {
            if (getIfExp().isConstantExp()) {
                replaceMe(getIfExp().ceval().booleanValue() ? getThenExp() : getElseExp());
            }
        } catch (ConstantEvaluationException e) {
            /*
             * Test failed to evaluate to boolean constant. In this case we do nothing.
             */
        }
    }
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:127
     */
    private boolean isWhen            = false;
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:136
     */
    public void setWhen()            { isWhen = true; }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:162
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        boolean arg = isFunctionCallArg();
        p.printVarDecls(getIfExp(), str, indent);
        if (arg) {
            getThenExp().genTempArg(p.DeclStep, str, indent);
            getElseExp().genTempArg(p.DeclStep, str, indent);
        } else {
            p.printVarDecls(getThenExp(), str, indent);
            p.printVarDecls(getElseExp(), str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:175
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream ostr, String indent) {
        boolean arg = isFunctionCallArg();
        p.printPreSteps(getIfExp(), ostr, indent);
        ConditionalCodeStream  str = new ConditionalCodeStream(ostr);
        String next = p.indent(indent);
        str.setBufferMode(true);
        str.print(indent);
        str.print("if (");
        p.print(getIfExp(), str, next);
        str.print(") {\n");
        str.setBufferMode(false);
        if (arg) {
            getThenExp().genTempArg(p.PreStep, str, next);
        } else {
            p.printPreSteps(getThenExp(), str, next);
        }
        str.setBufferMode(true);
        str.print(indent);
        str.print("}");
        str.clear();
        str.print(" else {\n");
        str.setBufferMode(false);
        if (arg) {
            getElseExp().genTempArg(p.PreStep, str, next);
        } else {
            p.printPreSteps(getElseExp(), str, next);
        }
        str.setBufferMode(true);
        str.print(indent);
        str.print("}\n");
        str.close();
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:209
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        prettyPrint_C(p.ExecStep, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:214
     */
    public void prettyPrint_C(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        boolean arg = isFunctionCallArg();
        str.print(FEqExp.macro_C);
        str.print("(");
        p.codePrinter().print(getIfExp(), str, indent);
        str.print(", JMI_TRUE, ");
        if (arg) {
            getThenExp().genTempArg(p, str, indent);
        } else {
            p.print(getThenExp(),str,indent);
        }
        str.print(", ");
        if (arg) {
            getElseExp().genTempArg(p, str, indent);
        } else {
            p.print(getElseExp(),str,indent);
        }
        str.print(")");
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:234
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream ostr, String indent) {

    }
    /**
     * @aspect StepPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\StepPrinter.jrag:157
     */
    public void genTempArg(CodePrinter.StepPrinter p, CodeStream str, String indent) {
        p.print(this, str, indent);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIfExp() {
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
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"IfExp", "ThenExp", "ElseExp"},
        type = {"FExp", "FExp", "FExp"},
        kind = {"Child", "Child", "Child"}
    )
    public FIfExp(FExp p0, FExp p1, FExp p2) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 3;
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
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:46
     */
    public FIfExp clone() throws CloneNotSupportedException {
        FIfExp node = (FIfExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FIfExp copy() {
        try {
            FIfExp node = (FIfExp) clone();
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
     * @declaredat ASTNode:70
     */
    @Deprecated
    public FIfExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public FIfExp treeCopyNoTransform() {
        FIfExp tree = (FIfExp) copy();
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
     * @declaredat ASTNode:105
     */
    public FIfExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the IfExp child.
     * @param node The new node to replace the IfExp child.
     * @apilevel high-level
     */
    public void setIfExp(FExp node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the IfExp child.
     * @return The current node used as the IfExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="IfExp")
    public FExp getIfExp() {
        return (FExp) getChild(0);
    }
    /**
     * Retrieves the IfExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the IfExp child.
     * @apilevel low-level
     */
    public FExp getIfExpNoTransform() {
        return (FExp) getChildNoTransform(0);
    }
    /**
     * Replaces the ThenExp child.
     * @param node The new node to replace the ThenExp child.
     * @apilevel high-level
     */
    public void setThenExp(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the ThenExp child.
     * @return The current node used as the ThenExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="ThenExp")
    public FExp getThenExp() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the ThenExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ThenExp child.
     * @apilevel low-level
     */
    public FExp getThenExpNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the ElseExp child.
     * @param node The new node to replace the ElseExp child.
     * @apilevel high-level
     */
    public void setElseExp(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the ElseExp child.
     * @return The current node used as the ElseExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="ElseExp")
    public FExp getElseExp() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the ElseExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ElseExp child.
     * @apilevel low-level
     */
    public FExp getElseExpNoTransform() {
        return (FExp) getChildNoTransform(2);
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
        ndims_value = getThenExp().ndims();
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
        size_value = getThenExp().size();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1346
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1346")
    public boolean canBuildArrayFromChild() {
        boolean canBuildArrayFromChild_value = isArray() && !getThenExp().size().equivalent(getElseExp().size(), inFunction());
        return canBuildArrayFromChild_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1351
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1351")
    public FExp childToBuildArray() {
        FExp childToBuildArray_value = cevalSelectExp();
        return childToBuildArray_value;
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
            Array thenArr = getThenExp().getArray();
            Array elseArr = getElseExp().getArray();
            for (Index i : arr.indices()) {
                FExp ifExp = getIfExp().fullCopy();
                arr.set(i, createNode(ifExp, thenArr.get(i), elseArr.get(i)));
            }
            return arr;
        }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2315")
    public CValue cevalArray(VariableEvaluator evaluator, Index i) {
        CValue cevalArray_VariableEvaluator_Index_value = cevalSelectExp(evaluator).cevalArray(evaluator, i);
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
        CValue cevalCalc_VariableEvaluator_value = cevalSelectExp(evaluator).ceval(evaluator);
        return cevalCalc_VariableEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2434")
    public FExp cevalSelectExp() {
        FExp cevalSelectExp_value = cevalSelectExp(defaultVariableEvaluator());
        return cevalSelectExp_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2435
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2435")
    public FExp cevalSelectExp(VariableEvaluator evaluator) {
        FExp cevalSelectExp_VariableEvaluator_value = getIfExp().ceval(evaluator).booleanValue() ? getThenExp() : getElseExp();
        return cevalSelectExp_VariableEvaluator_value;
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
                if (getIfExp().variability().evalOrLess()) {
                    try {
                        CValue testVal = getIfExp().ceval();
                        if (testVal.hasBooleanValue()) {
                            if (testVal.booleanValue())
                                return getThenExp().isCircular();
                            else
                                return getElseExp().isCircular();
                        }
                    } catch (ConstantEvaluationException e) {}
                }
                return super.isCircularCalc();
            }
    }
    /**
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4")
    public Precedence precedence() {
        Precedence precedence_value = Precedence.CONDITIONAL;
        return precedence_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223")
    public FExp nominal() {
        FExp nominal_value = FExp.nominalMax(getThenExp(), getElseExp());
        return nominal_value;
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3715
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3715")
    public boolean isIndependent(Set<? extends CommonVariableDecl> set) {
        {
                // Don't check the guard exp since it is discrete and does not affect
                // linearity.
                return getThenExp().isIndependent(set) && getElseExp().isIndependent(set);
            }
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
        type_value = type_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private FType type_compute() {
            FType thenType = getThenExp().type();
            FType elseType = getElseExp().type();
            if (!getIfExp().isOKTestExp() || thenType.ndims() != elseType.ndims())
                return fUnknownType();
            
            return fypeSelection(thenType, elseType);
        }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:571
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:571")
    public FType fypeSelection(FType thenType, FType elseType) {
        FType fypeSelection_FType_FType_value = thenType.typePromotion(elseType, inFunction(), null);
        return fypeSelection_FType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520")
    public boolean allowUnknownSize() {
        boolean allowUnknownSize_value = inAllowUnknownSize();
        return allowUnknownSize_value;
    }
    /**
     * Check if this expression generates events.
     * 
     * Does not consider subexpressions.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:668
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:668")
    public boolean eventGenerating() {
        boolean eventGenerating_value = true;
        return eventGenerating_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1460")
    public boolean scalarizeExpanded() {
        boolean scalarizeExpanded_value = super.scalarizeExpanded() && !isFunctionCallIO()
                    && !type().isRecord();
        return scalarizeExpanded_value;
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
        boolean extractTemp_value = false;
        return extractTemp_value;
    }
    /**
     * @attribute syn
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="WhenClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:133")
    public boolean isWhen() {
        boolean isWhen_value = isWhen;
        return isWhen_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:646
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:646")
    public boolean isIndicatorGuard(FExp e) {
        boolean isIndicatorGuard_FExp_value = e == getThenExp() || e == getElseExp();
        return isIndicatorGuard_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:650
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:650")
    public FExp myIndicatorGuardExp(FExp e) {
        FExp myIndicatorGuardExp_FExp_value = getIfExp();
        return myIndicatorGuardExp_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:654
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:654")
    public boolean negateIndicatorGuard(FExp e) {
        boolean negateIndicatorGuard_FExp_value = e == getElseExp();
        return negateIndicatorGuard_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095")
    public String htmlPrintWrapTagClass() {
        String htmlPrintWrapTagClass_value = "collapsable";
        return htmlPrintWrapTagClass_value;
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
        MX toMX_value = ifcasadi.if_else(getIfExp().toMX(), getThenExp().toMX(), getElseExp().toMX());
        return toMX_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1829
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1829")
    public boolean isInitial() {
        boolean isInitial_value = getParent().Define_isInitial(this, null);
        return isInitial_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     */
    public boolean Define_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1569
            return getIfExp().inDeadIfBranchTest(true);
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1568
            return getIfExp().inDeadIfBranchTest(false);
        }
        else {
            return getParent().Define_inDeadIfBranch(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     * @apilevel internal
     */
    public boolean Define_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3329
            return isFunctionCallArg();
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3328
            return isFunctionCallArg();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3688
     * @apilevel internal
     */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode, Set<FVariable> vars) {
        if (_callerNode == getIfExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3703
            return !isWhen() && (!inNoEventExp() || getIfExp().isIndependent(vars));
        }
        else {
            return getParent().Define_isLinear(this, _callerNode, vars);
        }
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
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1530
            return functionCallIsExp();
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1529
            return functionCallIsExp();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1804
     * @apilevel internal
     */
    public boolean Define_inIfCondition(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1804
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIfCondition
     */
    protected boolean canDefine_inIfCondition(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1826
            return isWhen() || inWhen();
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1825
            return isWhen() || inWhen();
        }
        else {
            return getParent().Define_inWhen(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:438
            return lockMyBranch(this, checkType, getIfExp(), false);
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:437
            return lockMyBranch(this, checkType, getIfExp(), true);
        }
        else {
            return getParent().Define_lockBranch(this, _callerNode, checkType);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return flattenFASContext();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     */
    public boolean Define_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isFunctionCallIO();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallIO
     */
    protected boolean canDefine_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:175
     * @apilevel internal
     */
    public FExp Define_enclosingIfExpCond(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:179
            return andIfExpConds(new FNotExp(getIfExp().fullCopy()));
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:178
            return andIfExpConds(getIfExp().fullCopy());
        }
        else {
            return getParent().Define_enclosingIfExpCond(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:175
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingIfExpCond
     */
    protected boolean canDefine_enclosingIfExpCond(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584
     * @apilevel internal
     */
    public boolean Define_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:592
            return true;
        }
        else if (_callerNode == getThenExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:591
            return true;
        }
        else {
            return getParent().Define_hasBrancher(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute hasBrancher
     */
    protected boolean canDefine_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2491
        if (isWhen() && isInitial()) {
            return rewriteRule0();
        }
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:518
        if (getThenExpNoTransform().equalsSymbolic(getElseExpNoTransform())) {
            return rewriteRule1();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2491
     * @apilevel internal
     */
    private FExp rewriteRule0() {
{
            if (getIfExp().isInitialGuard())
                return getThenExp();
            else
                return getElseExp();
        }    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:518
     * @apilevel internal
     */    private FExp rewriteRule1() {
        return getThenExp();
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_transformedGuards(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2052
        if (isWhen()) {
            {
                FAbstractEquation target = (FAbstractEquation) (myFEquation());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_transformedGuards(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_transformedGuards(Set<FExp> collection) {
        super.contributeTo_FAbstractEquation_transformedGuards(collection);
        if (isWhen()) {
            collection.add(getIfExp());
        }
    }
}
