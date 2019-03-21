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
 * Superclass for when equations, if equations and else clause of if equations.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:567
 * @astdecl FIfWhenElseEquation : FAbstractEquation ::= FAbstractEquation*;
 * @production FIfWhenElseEquation : {@link FAbstractEquation} ::= <span class="component">{@link FAbstractEquation}*</span>;

 */
public abstract class FIfWhenElseEquation extends FAbstractEquation implements Cloneable {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1301
     */
    public abstract FIfWhenElseEquation createEmptyNode();
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1369
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(indent);
		if (isElse())
   			str.print("else");
   		prettyPrintHead(p, str, indent);
   		getFAbstractEquations().prettyPrintWithFix(p, str, p.indent(indent), "", ";" + str.getLineEnder());
   		prettyPrintTail(p, str, indent);
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1378
     */
    protected void prettyPrintHead(Printer p, CodeStream str, String indent) {
   		str.println();
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1382
     */
    protected void prettyPrintTail(Printer p, CodeStream str, String indent) {
	}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:509
     */
    protected void forceTestVariability(ErrorCheckType checkType, TypePrefixVariability v) {}
    /**
     * @aspect AssertEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1632
     */
    @Override
    public boolean evaluateAsserts(boolean inClause) {
        boolean res = true;
        List<FAbstractEquation> l = new List<FAbstractEquation>();
        for (FAbstractEquation eqn : getFAbstractEquations()) {
            if (!eqn.evaluateAsserts(false)) {
                l.add(eqn);
                res = false;
            }
        }
        setFAbstractEquationList(l);
        return res;
    }
    /**
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1747
     */
    public void collectReinits(Map<FAbstractVariable,Set<FReinit>> map) {
        for (FAbstractEquation e : getFAbstractEquations())
            e.collectReinits(map);
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:72
     */
    @Override
    public void flattenEqn(Flattener f, List<FAbstractEquation> l) {
        List<FAbstractEquation> toList = new List<FAbstractEquation>();
        FAbstractEquation.flattenEqnList(f, toList, getFAbstractEquations());
        FIfWhenElseEquation res = createEmptyNode();
        res.setType(getType());
        res.setFAbstractEquationList(toList);
        flattenIfWhenTo(f, res);
        if (!res.isEmpty()) {
            l.add(res);
        }
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:85
     */
    public void flattenIfWhenTo(Flattener f, FIfWhenElseEquation res) {}
    /**
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1675
     */
    public void makeReinitedVarsStates() {
        for (FAbstractEquation e : getFAbstractEquations())
            e.makeReinitedVarsStates();
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:733
     */
    public void removeMarkedEqns() {
		setFAbstractEquationList(removeMarkedEqns(getFAbstractEquations()));
	}
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:165
     */
    public void collectFunctionCalls(FClass.commonSubexpressionEliminationIfSet m) {
        
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:855
     */
    @Override
    public Collection<FAbstractEquation> inlineFunctions(AbstractFunctionInliner fi) {
        setFAbstractEquationList(new List<>(fi.inline(getFAbstractEquations())));
        return Collections.singletonList((FAbstractEquation)this);
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:228
     */
    public void addEquationsToWorkList(Set<FAbstractEquation> wl) {
        if (isTempAssign()) {
            for (FAbstractEquation equation: getFAbstractEquations()) {
                equation.addEquationsToWorkList(wl);
            }
        }
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:667
     */
    public void cleanEquations(ArrayList<FAbstractEquation> l, TypePrefixVariability v) {
        if (!isTempAssign() || v.lessOrEqual(getFAbstractEquation(0).taggedByVProp)) {
            l.add(this);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1246
     */
    @Override
    public void scalarize(Scalarizer.Equation s) {
        List<FAbstractEquation> l = new List<FAbstractEquation>();
        scalarizeList(s.block(l), getFAbstractEquations());
        FIfWhenElseEquation res = createEmptyNode();
        res.setType(getType());
        res.setFAbstractEquationList(l);
        scalarizeTestAndElse(s, res);
        s.add(res);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1278
     */
    public void scalarizeTestAndElse(Scalarizer.Equation s, FIfWhenElseEquation res) {}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1294
     */
    public void addDummyEqnsForTemps(ArrayList<FExp> tempsForThen, ArrayList<FExp> tempsForElse) {
        if (tempsForThen != null) 
            for (FExp e : tempsForThen)
                e.type().addDummyEqnsForTemp(getFAbstractEquations(), e.tempVarName());
	}
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:253
     */
    private boolean isTempAssign = false;
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:254
     */
    public void setIsTempAssign() { isTempAssign = true; }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:255
     */
    public boolean isTempAssign() { return isTempAssign; }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:664
     */
    @Override
    public void acceptTransform(EquationTransformer tf) { tf.visit(this); }
    /**
     * Eliminates unnecessary if equations.
     * <p>
     * If an equation's test can be evaluated to {@code true}, it's block equations are added to the list and
     * this method finishes. If it is evaluated to {@code false}, the block equations are disregarded.
     * <p>
     * If the test can not be evaluated, the branch is kept and remaining branches are kept, unless they can be
     * evaluated to false, in which case they are disregarded. Remaining live branches are kept but their
     * block equations are not added yet, since <i>the first</i> {@code true} test's equations should be added,
     * and there are preceding branches that could not be evaluated.
     * This is specified with {@code equations} being null.
     * 
     * @param equations
     * The list in which to put equations that are extracted from live branches.
     * If null, only eliminate dead branches, and return new else branch of parent.
     * @return
     * this branch if it could not be evaluated, {@code null} otherwise. If non-{@code null} this equation is
     * added back to the {@code equations} list by {@link #eliminateIfEquations(List<FAbstractEquation>)}.
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:103
     */
    public FIfWhenElseEquation eliminateIfEquationsLocal(List<FAbstractEquation> equations) {
        return this;
    }
    /**
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:170
     */
    public void eliminateChildIfEquationsToList(List<FAbstractEquation> equations) {
        for (FAbstractEquation equation : getFAbstractEquations()) {
            equation.eliminateIfEquations(equations);
        }
    }
    /**
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:176
     */
    public void eliminateChildIfEquationsInPlace() {
        List<FAbstractEquation> equations = new List<>();
        eliminateChildIfEquationsToList(equations);
        setFAbstractEquationList(equations);
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:123
     */
    private Map<FAbstractVariable,FEquation> assignmentEquationMap = null;
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:124
     */
    private Set<FEquation> nonAssignmentEquationSet = null;
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:125
     */
    private Set<FAbstractEquation> nonFEquationSet = null;
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:127
     */
    private void calcAssignmentEquations() {
        if (assignmentEquationMap == null || nonAssignmentEquationSet == null || nonFEquationSet == null) {

            assignmentEquationMap = new HashMap<FAbstractVariable,FEquation>();
            nonAssignmentEquationSet = new HashSet<FEquation>();
            nonFEquationSet = new HashSet<FAbstractEquation>();

            for (FAbstractEquation absEqn : getFAbstractEquations()) {
                if (absEqn instanceof FEquation) {
                    FEquation eqn = (FEquation) absEqn;
                    FAbstractVariable var = eqn.assignedFV();

                    if (var != null && !assignmentEquationMap.containsKey(var)) {
                        assignmentEquationMap.put(var, eqn);
                    } else {
                        nonAssignmentEquationSet.add(eqn);
                    }
                } else {
                    nonFEquationSet.add(absEqn);
                }
            }
        }
    }
    /**
     * Remove empty else equations, i.e., {@link SrcElseEquation}s with more than one child.
     * 
     * @param equations
     * The equation list in which to put the resulting equations.
     * In this case, retain all equations in the equation list.
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:365
     */
    public void removeEmptyElse(List<FAbstractEquation> equations) {
        List<FAbstractEquation> myEquations = new List<FAbstractEquation>();
        for (FAbstractEquation equation : getFAbstractEquations()) {
            if (equation instanceof FElseEquation) {
                ((FElseEquation) equation).removeEmptyElse(myEquations);
            } else {
                equation.removeEmptyElse(myEquations);
            }
        }
        setFAbstractEquationList(myEquations);
        equations.add(this);
    }
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:39
     */
    @Override
    protected FIfWhenElseEquation convertWhenEqnToIfEqn(Collection<FAbstractEquation> outerNewList, FClass fclass) {
        Collection<FAbstractEquation> newSubList = new ArrayList<FAbstractEquation>();
        for (FAbstractEquation eqn : getFAbstractEquations()) {
            newSubList.add(eqn.convertWhenEqnToIfEqn(outerNewList, fclass));
        }
        setFAbstractEquationList(new List<FAbstractEquation>(newSubList));
        return this;
    }
    /**
     * Helper for printing if equations
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:435
     */
    public void genIfStart_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent);
        str.print("} else {\n");
    }
    /**
     * Helper for printing if equations
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:453
     */
    public void genIfEnd_C(CodePrinter p, CodeStream str, String indent) {}
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:95
     */
    @Override
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        genIfStart_C(p, str, indent);
        if (forVariables == null) {
            for (FAbstractEquation equation : getFAbstractEquations()) {
                equation.genAssignment_C(p, str, p.indent(indent));
            }
            return;
        }
        Iterator<FVariable> fvIt = forVariables.iterator();
        Iterator<Integer> fiIt = forIndices.iterator();
        Map<Integer, FVariable> fiToFvMap = new HashMap<Integer, FVariable>();
        while (fvIt.hasNext() && fiIt.hasNext()) {
            fiToFvMap.put(fiIt.next(), fvIt.next());
        }
        int i = 0;
        for (FAbstractEquation equation : getFAbstractEquations()) {
            Collection<Integer> fis   = new ArrayList<Integer>();
            Collection<FVariable> fvs = new ArrayList<FVariable>();
            int n = equation.numScalarEquations();
            for (int k = 0; k < n; k++) {
                FVariable var = fiToFvMap.get(k + i);
                if (var != null) {
                    fis.add(k);
                    fvs.add(var);
                }
            }
            if (forIndices.size() == 0 || fis.size() > 0) {
                equation.genBlock_C(p, str, p.indent(indent), visited, fvs, fis);
            }
            i += n;
        }
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:139
     */
    @Override
    public void genBlockEval_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        genIfStart_C(p, str, indent);
        Iterator<FVariable> fvIt = forVariables.iterator();
        Iterator<Integer> fiIt = forIndices.iterator();
        int i = 0;
        int n = fiIt.hasNext() ? fiIt.next() : -1;
        for (FAbstractEquation equation : getFAbstractEquations()) {
            Collection<Integer> fis   = new ArrayList<Integer>();
            Collection<FVariable> fvs = new ArrayList<FVariable>();
            while (n >= i && n < i + equation.numScalarEquations()) {
                    fis.add(n - i);
                    fvs.add(fvIt.next());
                    n = fiIt.hasNext() ? fiIt.next() : -1;
            }
            if (forIndices.size() == 0 || fis.size() > 0) {
                equation.genBlockEval_C(p, str, p.indent(indent), visited, fvs, fis);
            }
            i += equation.numScalarEquations();
        }
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:74
     */
    @Override
    public void genResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices) {
        genIfStart_C(p, str, indent);
        Iterator<Integer> fiIt = forIndices.iterator();
        int i = 0;
        int n = fiIt.hasNext() ? fiIt.next() : -1;
        for (FAbstractEquation equation : getFAbstractEquations()) {
            Set<Integer> fis = new HashSet<Integer>();
            while (n >= i && n < i + equation.numScalarEquations()) {
                fis.add(n - i);
                n = fiIt.hasNext() ? fiIt.next() : -1;
            }
            if (forIndices.size() == 0 || fis.size() > 0) {
                equation.genResidual_C(p, str, p.indent(indent), enumerator, visited, fis);
            }
            i += equation.numScalarEquations();
        }
    }
    /**
     * @aspect CCodeGenGlobalsReinit
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:240
     */
    @Override
    public void collectReinits_C(CodePrinter p, Collection<FReinit> res) {
        for (FAbstractEquation e : getFAbstractEquations()) {
            e.collectReinits_C(p, res);
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIfWhenElseEquation() {
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
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(List.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:17
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "FAttribute", "FStringComment", "FAbstractEquation"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>", "List<FAbstractEquation>"},
        kind = {"Token", "List", "Opt", "List"}
    )
    public FIfWhenElseEquation(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2, List<FAbstractEquation> p3) {
        setType(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:29
     */
    protected int numChildren() {
        return 3;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:35
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        inputs_reset();
        assignedSet_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FIfWhenElseEquation clone() throws CloneNotSupportedException {
        FIfWhenElseEquation node = (FIfWhenElseEquation) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:60
     */
    @Deprecated
    public abstract FIfWhenElseEquation fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:68
     */
    public abstract FIfWhenElseEquation treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:76
     */
    public abstract FIfWhenElseEquation treeCopy();
    /**
     * Replaces the lexeme Type.
     * @param value The new value for the lexeme Type.
     * @apilevel high-level
     */
    public void setType(EquationType value) {
        tokenEquationType_Type = value;
    }
    /**
     * Retrieves the value for the lexeme Type.
     * @return The value for the lexeme Type.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Type")
    public EquationType getType() {
        return tokenEquationType_Type;
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 0);
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
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
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
            setChild(new List(node), 0);
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
        List<FAttribute> list = (List<FAttribute>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(0);
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
     * Replaces the optional node for the FStringComment child. This is the <code>Opt</code>
     * node containing the child FStringComment, not the actual child!
     * @param opt The new node to be used as the optional node for the FStringComment child.
     * @apilevel low-level
     */
    public void setFStringCommentOpt(Opt<FStringComment> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) FStringComment child.
     * @param node The new node to be used as the FStringComment child.
     * @apilevel high-level
     */
    public void setFStringComment(FStringComment node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional FStringComment child exists.
     * @return {@code true} if the optional FStringComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFStringComment() {
        return getFStringCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FStringComment child.
     * @return The FStringComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FStringComment getFStringComment() {
        return (FStringComment) getFStringCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FStringComment child. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * @return The optional node for child the FStringComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FStringComment")
    public Opt<FStringComment> getFStringCommentOpt() {
        return (Opt<FStringComment>) getChild(1);
    }
    /**
     * Retrieves the optional node for child FStringComment. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FStringComment.
     * @apilevel low-level
     */
    public Opt<FStringComment> getFStringCommentOptNoTransform() {
        return (Opt<FStringComment>) getChildNoTransform(1);
    }
    /**
     * Replaces the FAbstractEquation list.
     * @param list The new list node to be used as the FAbstractEquation list.
     * @apilevel high-level
     */
    public void setFAbstractEquationList(List<FAbstractEquation> list) {
        setChild(list, 2);
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
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAbstractEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
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
            setChild(new List(node), 2);
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
        List<FAbstractEquation> list = (List<FAbstractEquation>) getChild(2);
        return list;
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(2);
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
     * Retrieves the number of children in the InitialEquation list.
     * @return Number of children in the InitialEquation list.
     * @apilevel high-level
     */
    public int getNumInitialEquation() {
        return getInitialEquationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InitialEquation list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InitialEquation list.
     * @apilevel low-level
     */
    public int getNumInitialEquationNoTransform() {
        return getInitialEquationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InitialEquation list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InitialEquation list.
     * @apilevel high-level
     */
    public FAbstractEquation getInitialEquation(int i) {
        return (FAbstractEquation) getInitialEquationList().getChild(i);
    }
    /**
     * Check whether the InitialEquation list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInitialEquation() {
        return getInitialEquationList().getNumChild() != 0;
    }
    /**
     * Append an element to the InitialEquation list.
     * @param node The element to append to the InitialEquation list.
     * @apilevel high-level
     */
    public void addInitialEquation(FAbstractEquation node) {
        List<FAbstractEquation> list = (parent == null) ? getInitialEquationListNoTransform() : getInitialEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInitialEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getInitialEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InitialEquation list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInitialEquation(FAbstractEquation node, int i) {
        List<FAbstractEquation> list = getInitialEquationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InitialEquation list.
     * @return The the child position of the InitialEquation list.
     * @apilevel low-level
     */
    protected int getInitialEquationListChildPosition() {
        return 3;
    }
    /**
     * Retrieves the InitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getInitialEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(3);
    }
    /**
     * @return the element at index {@code i} in the InitialEquation list without
     * triggering rewrites.
     */
    public FAbstractEquation getInitialEquationNoTransform(int i) {
        return (FAbstractEquation) getInitialEquationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InitialEquation list.
     * @return The node representing the InitialEquation list.
     * @apilevel high-level
     */
    public List<FAbstractEquation> getInitialEquations() {
        return getInitialEquationList();
    }
    /**
     * Retrieves the InitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getInitialEquationsNoTransform() {
        return getInitialEquationListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881")
    public int numScalarEquations() {
        int numScalarEquations_value = numScalarEqnsInList(getFAbstractEquations());
        return numScalarEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2468
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2468")
    public List<FAbstractEquation> createInitialEquationList() {
        {
                List<FAbstractEquation> l = new List<FAbstractEquation>();
                for (FAbstractEquation e : getFAbstractEquations()) {
                    if (e.replacedAtInitialization()) {
                        l.addAll(e.getInitialEquations());
                    } else {
                        l.add(e.copySymbolic());
                    }
                }
                return l;
            }
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888")
    public Set<FAccessExp> FAccessExpsInRHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        {
                Set<FAccessExp> res = new LinkedHashSet<FAccessExp>();
                for (FAbstractEquation fae : getFAbstractEquations())
                    res.addAll(fae.FAccessExpsInRHS(visitor));
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929")
    public Set<FAccessExp> FAccessExpsInLHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        {
                Set<FAccessExp> res = new LinkedHashSet<FAccessExp>();
                for (FAbstractEquation fae : getFAbstractEquations())
                    res.addAll(fae.FAccessExpsInLHS(visitor));
                return res;
            }
    }
    /** @apilevel internal */
    private void inputs_reset() {
        inputs_computed = false;
        
        inputs_value = null;
    }
    /** @apilevel internal */
    protected boolean inputs_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> inputs_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3433
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3433")
    public LinkedHashSet<FVariable> inputs() {
        ASTState state = state();
        if (inputs_computed) {
            return inputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        inputs_value = inputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        inputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return inputs_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> inputs_compute() {
            LinkedHashSet<FVariable> s = new LinkedHashSet<FVariable>();
            s.addAll(retrieveInputs());
            for (FAbstractEquation e : getFAbstractEquations()) {
                s.addAll(e.inputs());
            }
            return s;
        }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3677")
    public boolean checkLinearity(Set<FVariable> vars) {
        boolean checkLinearity_Set_FVariable__value = false;
        return checkLinearity_Set_FVariable__value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:289
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:289")
    public boolean isReal(boolean exclusive) {
        {
                boolean res = exclusive;
                for (FAbstractEquation equation : getFAbstractEquations()) {
                    boolean fvRes = equation.isReal(exclusive);
                    res = exclusive ? res && fvRes : res || fvRes;
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195")
    public TypePrefixVariability variability() {
        {
                TypePrefixVariability var = Variability.CONSTANT;
                for (FAbstractEquation equation : getFAbstractEquations())
                    var = var.combine(equation.variability());
                return var;
            }
    }
    /**
     * @attribute syn
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:215
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComplianceCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:215")
    public boolean containsConnect() {
        boolean containsConnect_value = containsConnect(getFAbstractEquations());
        return containsConnect_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:499
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:499")
    public boolean canSelectBranch() {
        boolean canSelectBranch_value = true;
        return canSelectBranch_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:519
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:519")
    public boolean isBalancedEquations() {
        boolean isBalancedEquations_value = true;
        return isBalancedEquations_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:526
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:526")
    public boolean isBalancedAssignments() {
        boolean isBalancedAssignments_value = true;
        return isBalancedAssignments_value;
    }
    /** @apilevel internal */
    private void assignedSet_reset() {
        assignedSet_computed = false;
        
        assignedSet_value = null;
    }
    /** @apilevel internal */
    protected boolean assignedSet_computed = false;

    /** @apilevel internal */
    protected Set<InstComponentDecl> assignedSet_value;

    /**
     * Gives the set of components assigned in this equation.
     * 
     * Only works in instance tree.
     * For if and when equations, only the first branch is considered.
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:547
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:547")
    public Set<InstComponentDecl> assignedSet() {
        ASTState state = state();
        if (assignedSet_computed) {
            return assignedSet_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        assignedSet_value = assignedSetFromEqns(getFAbstractEquations());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        assignedSet_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return assignedSet_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582")
    public boolean hasFunctionCallEquations() {
        {
        		for (FAbstractEquation equ : getFAbstractEquations())
        			if (equ.hasFunctionCallEquations())
        				return true;
        		return false;
        	}
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:599")
    public boolean hasFunctionCallEquationsWithLefts() {
        {
        		for (FAbstractEquation equ : getFAbstractEquations())
        			if (equ.hasFunctionCallEquationsWithLefts())
        				return true;
        		return false;
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:99
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:99")
    public boolean isEmpty() {
        boolean isEmpty_value = getNumFAbstractEquation() == 0;
        return isEmpty_value;
    }
    /**
     * Check if an equation contains any calls to functions that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:725
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:725")
    public boolean hasInlinableFunctions(AbstractFunctionInliner fi) {
        {
                if (isWhen())
                    return false;
                for (FAbstractEquation eqn : getFAbstractEquations())
                    if (eqn.hasInlinableFunctions(fi))
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:25
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:25")
    public Solvability isSolved(FVariable var, boolean duringTearing) {
        {
                Set<FVariable> leftVars = referencedFVariablesInLHS();
                
                boolean inLeft = false;
                for (FVariable fv : leftVars) {
                    if (fv == var)
                        inLeft = true;
                }
                
                Set<FVariable> argVars = referencedFVariablesInRHS();
        
                boolean inArgs = false;
                for (FVariable fv : argVars) {
                    if (fv == var)
                        inArgs = true;
                }
        
                if (inLeft && !inArgs)
                    return Solvability.ANALYTICALLY_SOLVABLE;
                else
                    return Solvability.UNSOLVABLE;
            }
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:108")
    public Map<FAbstractVariable,FEquation> assignmentEquationMap() {
        {
                calcAssignmentEquations();
                return assignmentEquationMap;
            }
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:113
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:113")
    public Set<FEquation> nonAssignmentEquationSet() {
        {
                calcAssignmentEquations();
                return nonAssignmentEquationSet;
            }
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:118")
    public Set<FAbstractEquation> nonFEquationSet() {
        {
                calcAssignmentEquations();
                return nonFEquationSet;
            }
    }
    /**
     * Check if this when equation is the else part of another when equation.
     * @attribute inh
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="GeneralHelpers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942")
    public boolean isElse() {
        boolean isElse_value = getParent().Define_isElse(this, null);
        return isElse_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1816
            int childIndex = _callerNode.getIndexOfChild(_childNode);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38
     * @apilevel internal
     */
    public boolean Define_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isTempAssign() && canPropagateContext(propagator);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canPropagateContext
     */
    protected boolean canDefine_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
