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
 * Base class for relational expressions.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:846
 * @astdecl FRelExp : FBoolBinExp ::= [Indicator:FExp] <IndicatorVarName:String>;
 * @production FRelExp : {@link FBoolBinExp} ::= <span class="component">[Indicator:{@link FExp}]</span> <span class="component">&lt;IndicatorVarName:String&gt;</span>;

 */
public abstract class FRelExp extends FBoolBinExp implements Cloneable {
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2867
     */
    @Override
    public <T extends CommonAccessExp> void findCommonAccessExpsInTree(Set<T> set, CommonAccessExpLookupVisitor<T> visitor) {
        Opt<FExp> indicator = getIndicatorOpt();

        if (indicator == null) {
            super.findCommonAccessExpsInTree(set, visitor);
        } else {
            for (ASTNode<?> n : this) {
                if (indicator != n) {
                    n.findCommonAccessExpsInTree(set, visitor);
                }
            }
        }
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:69
     */
    public void complianceCheck(ErrorCheckType checkType) {
        super.complianceCheck(checkType);
        if (!inFunction() && generatesEvent() && inWhile())
            UNSUPPORTED_EVENT_GENERATING_EXPRESSION_IN_WHILE_STATEMENT.invoke(this);
    }
    /**
     * @aspect EqualSwitchElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\EqualSwitchElimination.jrag:81
     */
    public void collectEqualSwitches(Map<String, Collection<FRelExp>> candidates) {
        FAlgorithm alg = myFAlgorithm();
        if (alg != null && dependsOn(alg.referencedFVariablesInLHS())) {
            return;
        }
        String key = toString();
        Collection<FRelExp> list = candidates.get(key);
        if (list == null) {
            list = new ArrayList<FRelExp>();
            candidates.put(key, list);
        }
        list.add(this);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:354
     */
    private FRelExp originalFRelExp                         = null;
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:365
     */
    public void setOriginalFExp(FRelExp original)                 { this.originalFRelExp         = original; }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:384
     */
    @Override
    protected void resetOriginalReferences() {
        setOriginalFExp(this);
        super.resetOriginalReferences();
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:414
     */
    @Override
	protected void traverseSymbolic(ASTNode e) {
        setOriginalFExp(((FRelExp)e).originalFExp());
		super.traverseSymbolic(e);
	}
    /**
     * Creates an indicator for this FRelExp.
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:620
     */
    public void genIndicator(boolean output) {
        String variableName = calcIndicatorVarName();
        FVariable v = new FRealVariable(VisibilityType.PUBLIC, Variability.CONTINUOUS,
                new FAccessFull(variableName));

        if (output) {
            v.setTypePrefixInputOutput(TypePrefixInputOutput.OUTPUT);
        }

        myFClass().addFVariable(v);
        setIndicator(v.createAccessExp());
        setIndicatorVarName(variableName);
    }
    /**
     * Creates an expression for the event indicator.
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:637
     */
    public FExp indicatorExp() {
        FExp res = new FSubExp(getLeft().fullCopy(), getRight().fullCopy());

        if (myOptions().getBooleanOption("event_indicator_scaling")) {
            res = new FDivExp(res, nominal());
        }
        return res;
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:510
     */
    @Override
    public void genEventResidualVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        printIndicator(p.DeclStep, str, indent, true);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:534
     */
    @Override
    public void genEventResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator) {
        printIndicator(p.PreStep, str, indent, true);
		str.print(indent + "(*res)[" + enumerator.next() + "] = ");
        printIndicator(p.ExecStep, str, indent, true);
		str.print(";\n");
        printIndicator(p.PostStep, str, indent, true);
	}
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:594
     */
    private void printIndicator(CodePrinter.StepPrinter sp, CodeStream str, String indent, boolean guard) {
        boolean hb = hasBrancher();
        if (guard && hb) {
            sp.print(str, FEqExp.macro_C);
            sp.print(str, "(");
            printIndicatorGuard(sp, str, indent, this);
            sp.print(str, ", JMI_TRUE, ");
        }
        
        if (scale()) {
            sp.print(str, "(");
        }
        
        if (hasIndicator()) {
            sp.print(getIndicator(), str, indent);
        } else {
            sp.print(getLeft(), str, indent);
            sp.print(str, " - (");
            sp.print(getRight(), str, indent);
            sp.print(str, ")");
        }
        
        if (scale()) {
            sp.print(str, ") / ");
            sp.print(getIndicatorNominal(), str, indent);
        }
        
        if (guard && hb) {
            sp.print(str, ", " + FLitExp.macro_C + "(1))");
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:699
     */
    @Override
    public void genTimeEventVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        printIndicator(p.DeclStep, str, indent, true);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:708
     */
    @Override
    public void genTimeEvent_C(CodePrinter p, CodeStream str, String indent, String res) {
        printIndicator(p.PreStep, str, indent, true);
        boolean phased = isPhased();
        str.format("%sif (SURELY_LT_ZERO(", indent);
        printIndicator(p.ExecStep, str, indent, true);
        str.print(")");
        if (phased) {
            str.print(" || (!jmi->eventPhase && ALMOST_ZERO(");
            printIndicator(p.ExecStep, str, indent, true);
            str.print("))");
        }
        str.println(") {");
        
        str.format("%sjmi_min_time_event(%s, 1, %s, ", p.indent(indent), res, phased ? "1" : "0");
        p.print(solutionForTime(), str, indent);
        str.formatln(");\n%s}", indent);
        printIndicator(p.PostStep, str, indent, true);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:855
     */
    @Override
    public void genRelExpKind(CodeStream str) {
    	str.print(kindString());
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:860
     */
    public void genRelExpKindPhased(CodeStream str) {
        str.print(kindStringPhased());
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:864
     */
    public static String LT_C  = "JMI_REL_LT";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:865
     */
    public static String LEQ_C = "JMI_REL_LEQ";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:866
     */
    public static String GT_C  = "JMI_REL_GT";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:867
     */
    public static String GEQ_C = "JMI_REL_GEQ";
    /**
     * Prints the position for the switch in the z-vector
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:721
     */
    public void genBlockResidualFunction_printSwitchIndex_C(CodePrinter p, CodeStream str, String nextIndent, Enumerator enumerator) {
        if (originalFExp().generatesEventInDAE()) {
            str.format("%sx[%d] = jmi->offs_sw + %d;\n", nextIndent, enumerator.next(), mySwitchIndex());
        } else {
            str.format("%sx[%d] = jmi->offs_sw_init + %d;\n", nextIndent, enumerator.next(), relExpInInitialEquationsIndex());
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1109
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (myOptions().getBooleanOption("generate_dae") || !generatesEvent(p.inInitialSystem())) {
            super.genVarDecls_C(p, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1116
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String outerIndent) {
        if (myOptions().getBooleanOption("generate_dae") || !generatesEvent(p.inInitialSystem())) {
            super.genTempVars_C(p, str, outerIndent);
        } else if (p.writeSwitches()) {
            str.print(outerIndent, "if (");
            if (p.inBlock())
                str.print("evaluation_mode & JMI_BLOCK_EVALUATE_NON_REALS");
            else
                str.print("jmi->atInitial || jmi->atEvent");
            str.println(") {");
            
            String indent = p.indent(outerIndent);
            printIndicator(p.DeclStep, str, indent, false);
            printIndicator(p.PreStep, str, indent, false);
            str.print(indent);
            printSwitchMacro_C(p, str, indent);
            boolean time = isTimeEventGenerating();
            if (time) {
                str.print(" = jmi_turn_switch_time(");
            } else {
                str.print(" = jmi_turn_switch(");
            }
            str.print("jmi");
            str.print(", ");
            printIndicator(p.ExecStep, str, indent, false);
            str.print(", ");
            printSwitchMacro_C(p, str, indent);
            str.print(", ");
            boolean phased = isPhased();
            if (phased) {
                str.print("jmi->eventPhase ? (");
                genRelExpKindPhased(str);
                str.print(") : (");
            }
            genRelExpKind(str);
            if (phased) {
                str.print(")");
            }
            
            str.print(");\n");
            printIndicator(p.PostStep, str, indent, false);
            str.print(outerIndent, "}\n");
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1162
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (cevalType().isString()) {
            str.print("strcmp(");
            p.print(getLeft(), str, indent);
            str.print(", ");
            p.print(getRight(), str, indent);
            str.print(")");
            str.print(op_C());
            str.print("0");
        } else if (!generatesEvent(p.inInitialSystem())) {
            str.print(macro_C()+"(");
            p.print(getLeft(), str, indent);
            str.print(", ");
            p.print(getRight(), str, indent);
            str.print(relIsInverted_C() ? ", JMI_FALSE, JMI_TRUE)" : ", JMI_TRUE, JMI_FALSE)");
        } else {
            printSwitchMacro_C(p, str, indent);
        }
    }
    /**
     * Helper, prints the appropiate jmi switch macro
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1211
     */
    private void printSwitchMacro_C(CodePrinter p, CodeStream str, String indent) {
        if (originalFExp().generatesEventInDAE()) {
            str.print("_sw(", mySwitchIndex(), ")");
        } else {
            str.print("_sw_init(", relExpInInitialEquationsIndex(), ")");
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FRelExp() {
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
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Left", "Right", "Indicator", "IndicatorVarName"},
        type = {"FExp", "FExp", "Opt<FExp>", "String"},
        kind = {"Child", "Child", "Opt", "Token"}
    )
    public FRelExp(FExp p0, FExp p1, Opt<FExp> p2, String p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setIndicatorVarName(p3);
    }
    /**
     * @declaredat ASTNode:25
     */
    public FRelExp(FExp p0, FExp p1, Opt<FExp> p2, beaver.Symbol p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setIndicatorVarName(p3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:32
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:38
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        mySwitchIndex_reset();
        myEventIndicatorIndex_reset();
        type_reset();
        getIndicatorNominal_reset();
        scale_reset();
        hasBrancher_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FRelExp clone() throws CloneNotSupportedException {
        FRelExp node = (FRelExp) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:67
     */
    @Deprecated
    public abstract FRelExp fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:75
     */
    public abstract FRelExp treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:83
     */
    public abstract FRelExp treeCopy();
    /**
     * Replaces the Left child.
     * @param node The new node to replace the Left child.
     * @apilevel high-level
     */
    public void setLeft(FExp node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Left child.
     * @return The current node used as the Left child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Left")
    public FExp getLeft() {
        return (FExp) getChild(0);
    }
    /**
     * Retrieves the Left child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Left child.
     * @apilevel low-level
     */
    public FExp getLeftNoTransform() {
        return (FExp) getChildNoTransform(0);
    }
    /**
     * Replaces the Right child.
     * @param node The new node to replace the Right child.
     * @apilevel high-level
     */
    public void setRight(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Right child.
     * @return The current node used as the Right child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Right")
    public FExp getRight() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the Right child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Right child.
     * @apilevel low-level
     */
    public FExp getRightNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the Indicator child. This is the <code>Opt</code>
     * node containing the child Indicator, not the actual child!
     * @param opt The new node to be used as the optional node for the Indicator child.
     * @apilevel low-level
     */
    public void setIndicatorOpt(Opt<FExp> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) Indicator child.
     * @param node The new node to be used as the Indicator child.
     * @apilevel high-level
     */
    public void setIndicator(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional Indicator child exists.
     * @return {@code true} if the optional Indicator child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasIndicator() {
        return getIndicatorOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Indicator child.
     * @return The Indicator child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getIndicator() {
        return (FExp) getIndicatorOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Indicator child. This is the <code>Opt</code> node containing the child Indicator, not the actual child!
     * @return The optional node for child the Indicator child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Indicator")
    public Opt<FExp> getIndicatorOpt() {
        return (Opt<FExp>) getChild(2);
    }
    /**
     * Retrieves the optional node for child Indicator. This is the <code>Opt</code> node containing the child Indicator, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Indicator.
     * @apilevel low-level
     */
    public Opt<FExp> getIndicatorOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(2);
    }
    /**
     * Replaces the lexeme IndicatorVarName.
     * @param value The new value for the lexeme IndicatorVarName.
     * @apilevel high-level
     */
    public void setIndicatorVarName(String value) {
        tokenString_IndicatorVarName = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_IndicatorVarName;
    /**
     */
    public int IndicatorVarNamestart;
    /**
     */
    public int IndicatorVarNameend;
    /**
     * JastAdd-internal setter for lexeme IndicatorVarName using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme IndicatorVarName
     * @apilevel internal
     */
    public void setIndicatorVarName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setIndicatorVarName is only valid for String lexemes");
        tokenString_IndicatorVarName = (String)symbol.value;
        IndicatorVarNamestart = symbol.getStart();
        IndicatorVarNameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme IndicatorVarName.
     * @return The value for the lexeme IndicatorVarName.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="IndicatorVarName")
    public String getIndicatorVarName() {
        return tokenString_IndicatorVarName != null ? tokenString_IndicatorVarName : "";
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
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2397
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2397")
    public FType cevalType() {
        FType cevalType_value = getLeft().type().typePromotion(getRight().type());
        return cevalType_value;
    }
    /**
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:4")
    public Precedence precedence() {
        Precedence precedence_value = Precedence.RELATIONAL;
        return precedence_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1962
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1962")
    public boolean isTimeEventGenerating() {
        boolean isTimeEventGenerating_value = myOptions().getBooleanOption("relational_time_events") && solutionForTime().isValidExp();
        return isTimeEventGenerating_value;
    }
    /** @apilevel internal */
    private void mySwitchIndex_reset() {
        mySwitchIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean mySwitchIndex_computed = false;

    /** @apilevel internal */
    protected int mySwitchIndex_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1986
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1986")
    public int mySwitchIndex() {
        ASTState state = state();
        if (mySwitchIndex_computed) {
            return mySwitchIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        mySwitchIndex_value = isTimeEventGenerating() ?
                    checkIndex(myFClass().switchExps().indexOf(originalFExp())) + myFClass().delayExpsWithStateEvent().size() :
                    myEventIndicatorIndex();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        mySwitchIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return mySwitchIndex_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1999
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1999")
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
        boolean hasEventGeneratingType_value = isRealComparison();
        return hasEventGeneratingType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2123
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2123")
    public boolean generatesEventInInitDAE() {
        boolean generatesEventInInitDAE_value = generatesEventInInitDAE(originalFExp());
        return generatesEventInInitDAE_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2126
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2126")
    public boolean generatesEventInInitDAE(FExp orig) {
        boolean generatesEventInInitDAE_FExp_value = (inInitialEquationSection() || (inEquationSection() && variability().initialParameterVariability()))
                    && orig==this && generatesEvent(true);
        return generatesEventInInitDAE_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2217
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2217")
    public int relExpInInitialEquationsIndex() {
        int relExpInInitialEquationsIndex_value = checkIndex(myFClass().relExpInInitialEquations().indexOf(originalFExp()));
        return relExpInInitialEquationsIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:39
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:39")
    public FVariable myIndicatorVariableOrException() {
        {
                FVariable variable = myIndicatorVariableOrNull();
                if (variable == null) {
                    if (myOptions().getBooleanOption("event_output_vars")) {
                        throw new InternalCompilerError("The relational expression '%s' doesn't have any indicator variable name set!", this);
                    } else {
                        throw new InternalCompilerError("Trying to get indicator variable name for '%s', but option 'event_output_vars' is disabled!", this);
                    }
                }
                return variable;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:51
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:51")
    public FVariable myIndicatorVariableOrNull() {
        {
                String name = getIndicatorVarName();
                if (name == null || name.isEmpty()) {
                    return null;
                }
                return lookupFV(name).asFVariable();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1567
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1567")
    public String calcIndicatorVarName() {
        String calcIndicatorVarName_value = calcGeneratedVarName(FlatVariableMap.GeneratedVarType.INDICATOR);
        return calcIndicatorVarName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:311
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:311")
    public boolean isRealComparison() {
        boolean isRealComparison_value = comparisonType().isReal();
        return isRealComparison_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:312
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:312")
    public boolean isIntegerComparison() {
        boolean isIntegerComparison_value = comparisonType().isInteger();
        return isIntegerComparison_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:313
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:313")
    public boolean isBooleanComparison() {
        boolean isBooleanComparison_value = comparisonType().isBoolean();
        return isBooleanComparison_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:314")
    public boolean isStringComparison() {
        boolean isStringComparison_value = comparisonType().isString();
        return isStringComparison_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:316
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:316")
    public FType comparisonType() {
        FType comparisonType_value = getRight().type().numericPromotion(getLeft().type());
        return comparisonType_value;
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
            if (shouldUseOverloadedOperator()) 
                return getLeft().type().matchOverloadedOperatorType(getRight().type(), operatorName());
            FType left = getLeft().type();
            if (left.equivalentTo(getRight().type()) && left.isScalar()) {
                if (left.isRecord()) {
                    return left;
                } else {
                    return fBooleanScalarType();
                }
            }
            else
                return fUnknownType();
        }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = inNoEventExp() ? super.expVariability() : super.expVariability().combineDown(Variability.DISCRETE);
        return expVariability_value;
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
        boolean eventGenerating_value = getLeft().isContinuousExp() || getRight().isContinuousExp();
        return eventGenerating_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:467
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:467")
    public boolean isSimpleLinearExp() {
        boolean isSimpleLinearExp_value = false;
        return isSimpleLinearExp_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:344")
    public FExp solutionForTime() {
        {
                if (getLeft() instanceof FTimeExp && getRight().variability().discreteOrLess()) {
                    return getRight();
                } else if (getRight() instanceof FTimeExp && getLeft().variability().discreteOrLess()) {
                    return getLeft();
                }
                return new FNoExp();
            }
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:360")
    public FRelExp originalFExp() {
        FRelExp originalFExp_value = (originalFRelExp == null)          ? this : originalFRelExp;
        return originalFExp_value;
    }
    /**
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:560
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:560")
    public boolean shouldGenerateIndicator() {
        boolean shouldGenerateIndicator_value = generatesEvent() && !isTimeEventGenerating() &&
                    !inFunctionCall() && !containsCommonFunctionCallExp();
        return shouldGenerateIndicator_value;
    }
    /**
     * Creates an assign equation for the indicator.
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:590
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:590")
    public FAbstractEquation indicatorEquation() {
        FAbstractEquation indicatorEquation_value = new FEquation(getIndicator().fullCopy(), indicatorExp());
        return indicatorEquation_value;
    }
    /**
     * Creates an assign statement for the indicator.
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:595")
    public FStatement indicatorStmt() {
        FStatement indicatorStmt_value = new FAssignStmt(getIndicator().asFAccessExp().fullCopy(), indicatorExp());
        return indicatorStmt_value;
    }
    /**
     * Creates an initialization statement for the indicator.
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:600
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:600")
    public FStatement indicatorInitStmt() {
        FStatement indicatorInitStmt_value = new FAssignStmt(getIndicator().asFAccessExp().fullCopy(), new FIntegerLitExp(1));
        return indicatorInitStmt_value;
    }
    /** @apilevel internal */
    private void getIndicatorNominal_reset() {
        getIndicatorNominal_computed = false;
        
        getIndicatorNominal_value = null;
    }
    /** @apilevel internal */
    protected boolean getIndicatorNominal_computed = false;

    /** @apilevel internal */
    protected FExp getIndicatorNominal_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:579
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:579")
    public FExp getIndicatorNominal() {
        ASTState state = state();
        if (getIndicatorNominal_computed) {
            return getIndicatorNominal_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getIndicatorNominal_value = FExp.nominalMax(getLeft(), getRight());
        getIndicatorNominal_value.setParent(this);
        getIndicatorNominal_value.is$Final = true;
        if (true) {
        getIndicatorNominal_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getIndicatorNominal_value;
    }
    /** @apilevel internal */
    private void scale_reset() {
        scale_computed = false;
    }
    /** @apilevel internal */
    protected boolean scale_computed = false;

    /** @apilevel internal */
    protected boolean scale_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:581
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:581")
    public boolean scale() {
        ASTState state = state();
        if (scale_computed) {
            return scale_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        scale_value = myOptions().getBooleanOption("event_indicator_scaling");
        if (isFinal && _boundaries == state().boundariesCrossed) {
        scale_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return scale_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:660
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:660")
    public boolean hasEventIndicator() {
        boolean hasEventIndicator_value = originalFExp() == this && generatesEvent() || super.hasEventIndicator();
        return hasEventIndicator_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:869
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:869")
    public String kindString() {
        String kindString_value = "-1";
        return kindString_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:875
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:875")
    public String kindStringPhased() {
        String kindStringPhased_value = kindString();
        return kindStringPhased_value;
    }
    /**
     * If the relational expression is negated
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1204")
    public boolean relIsInverted_C() {
        boolean relIsInverted_C_value = false;
        return relIsInverted_C_value;
    }
    /**
     * Helper, gets the relational c operator
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1222
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1222")
    public String op_C() {
        String op_C_value = op();
        return op_C_value;
    }
    /**
     * Helper, check if the relational expression generates phased events
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1229
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1229")
    public boolean isPhased() {
        boolean isPhased_value = isTimeEventGenerating() && isPhased_sub();
        return isPhased_value;
    }
    /**
     * Helper, subcall for isPhased()
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1234
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1234")
    public boolean isPhased_sub() {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * @attribute inh
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:85
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ComplianceCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:85")
    public boolean inWhile() {
        boolean inWhile_value = getParent().Define_inWhile(this, null);
        return inWhile_value;
    }
    /**
     * Checks whether or not this relational expression requires an initialization statement.
     * @attribute inh
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566")
    public boolean needsIndicatorInit() {
        boolean needsIndicatorInit_value = getParent().Define_needsIndicatorInit(this, null);
        return needsIndicatorInit_value;
    }
    /**
     * @attribute inh
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584")
    public boolean hasBrancher() {
        ASTState state = state();
        if (hasBrancher_computed) {
            return hasBrancher_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        hasBrancher_value = getParent().Define_hasBrancher(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        hasBrancher_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return hasBrancher_value;
    }
    /** @apilevel internal */
    private void hasBrancher_reset() {
        hasBrancher_computed = false;
    }
    /** @apilevel internal */
    protected boolean hasBrancher_computed = false;

    /** @apilevel internal */
    protected boolean hasBrancher_value;

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574
     * @apilevel internal
     */
    public boolean Define_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getIndicatorOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:576
            return true;
        }
        else {
            return getParent().Define_isIndicator(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:574
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isIndicator
     */
    protected boolean canDefine_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_relExpsWithEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2132
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
        super.collect_contributors_FClass_relExpsWithEvent(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_relExpInEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2157
        if (generatesEventInDAE(this)) {
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
        super.collect_contributors_FAbstractEquation_relExpInEquation(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FStatement_relExpInStmt(FStatement _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2162
        if (generatesEventInDAE()) {
            {
                FStatement target = (FStatement) (myFStatement());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FStatement_relExpInStmt(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_relExpInInitialEquations(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2209
        if (generatesEventInInitDAE()) {
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
        super.collect_contributors_FClass_relExpInInitialEquations(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_relExpInInitialEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2214
        if (generatesEventInInitDAE(this)) {
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
        super.collect_contributors_FAbstractEquation_relExpInInitialEquation(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_relExpsWithEvent(ArrayList<FRelExp> collection) {
        super.contributeTo_FClass_relExpsWithEvent(collection);
        if (generatesEventInDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_relExpInEquation(ArrayList<FRelExp> collection) {
        super.contributeTo_FAbstractEquation_relExpInEquation(collection);
        if (generatesEventInDAE(this)) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_relExpInStmt(ArrayList<FRelExp> collection) {
        super.contributeTo_FStatement_relExpInStmt(collection);
        if (generatesEventInDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_relExpInInitialEquations(ArrayList<FRelExp> collection) {
        super.contributeTo_FClass_relExpInInitialEquations(collection);
        if (generatesEventInInitDAE()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_relExpInInitialEquation(ArrayList<FRelExp> collection) {
        super.contributeTo_FAbstractEquation_relExpInInitialEquation(collection);
        if (generatesEventInInitDAE(this)) {
            collection.add(this);
        }
    }
}
