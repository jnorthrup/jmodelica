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
 * If equation clause.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:582
 * @astdecl FIfEquation : FIfWhenEquation;
 * @production FIfEquation : {@link FIfWhenEquation};

 */
public class FIfEquation extends FIfWhenEquation implements Cloneable {
    /**
     * Constructs an if equation.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:234
     */
    public FIfEquation(EquationType type, List<FAbstractEquation> eqns, FExp guard, Opt<FIfWhenElseEquation> elseClause) {
        this(type, new List<FAttribute>(), new Opt<FStringComment>(), eqns, guard, elseClause);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1302
     */
    public FIfEquation createEmptyNode()   { return new FIfEquation(); }
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:308
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        if (getTest().variability().knownParameterOrLess()) {
            try {
                CValue testVal = getTest().ceval();
                if (testVal.hasBooleanValue()) {
                    if (testVal.booleanValue()) {
                        getFAbstractEquations().updateVariabilityForVariablesInWhen(inWhen);
                    } else if (hasElse()) {
                        getElse().updateVariabilityForVariablesInWhen(inWhen);
                    }
                    return;
                }
            } catch (ConstantEvaluationException e) {}
        }
        super.updateVariabilityForVariablesInWhen(inWhen);
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:432
     */
    public void checkMayContainConnect(ErrorCheckType checkType, FConnectClause connect) {
        super.checkMayContainConnect(checkType, connect);
        TypePrefixVariability v = getTest().variability();
        if (!v.fixedParameterOrLess()) {
            connect.error("Connect clauses are not allowed in if equations with non-parameter or non-fixed conditions");
        } else {
            if (!getTest().canCeval()) {
                getTest().error("Could not evaluate test expression for if equation containing connect clause");
            }
            getTest().markAsStructuralParameter(checkType);
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:478
     */
    public static final String UNBALANCED_ERROR = 
		"All branches in if equation with non-parameter tests must have the same number of equations";
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:480
     */
    public static final String UNBALANCED_ERROR_WHEN = 
		"All branches in if equation with non-parameter tests within when equation must assign the same variables";
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:483
     */
    public void contentCheck(ErrorCheckType checkType) {
        super.contentCheck(checkType);
        if (isTopWhenIfEquation()) {
            boolean inWhen = inWhen();
            boolean balanced = inWhen ? isBalancedAssignments() : isBalancedEquations();
            boolean functionCallEqu = hasFunctionCallEquations(); 
            if (canSelectBranch()) {
                forceTestVariability(checkType, balanced ? Variability.TESTPARAMETER : Variability.STRUCTPARAMETER);
            } else {
                if (!balanced) {
                    error(inWhen ? UNBALANCED_ERROR_WHEN : UNBALANCED_ERROR);
                }
            }
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:511
     */
    @Override
    protected void forceTestVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        getTest().forceVariability(checkType, v);
        if (hasElse()) {
            getElse().forceTestVariability(checkType, v);
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1171
     */
    public void typeCheck(ErrorCheckType checkType) {
	  if (!getTest().type().isUnknown() && !fBooleanScalarType().typeCompatible(getTest().type())) 
		  error("Type of test expression of if equation is not Boolean");
  }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1343
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        boolean all = true;
        boolean test = false;
        try {
            CValue cval = getTest().ceval();
            if (cval.hasBooleanValue()) {
                test = cval.booleanValue();
                all = false;
            }
        } catch (ConstantEvaluationException e) {
        }
        getTest().buildConnectionSets(prefix, csm, connect);
        for (FAbstractEquation equ : getFAbstractEquations())
            equ.buildConnectionSets(prefix, csm, (all || test) && connect);
        if (hasElse())
            getElse().buildConnectionSets(prefix, csm, (all || !test) && connect);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:847
     */
    @Override
    public Collection<FAbstractEquation> inlineFunctions(AbstractFunctionInliner fi) {
        super.inlineFunctions(fi);
        if (hasElse())
            getElse().inlineFunctions(fi);
        return Collections.singletonList((FAbstractEquation)this);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1257
     */
    @Override
    public void scalarize(Scalarizer.Equation s) {
        boolean lockedBranch = false;
        if (getTest().variability().indexParameterOrLess()) {
            try {
                CValue cval = getTest().ceval();
                if (cval.hasBooleanValue()) {
                    if (cval.booleanValue()) {
                        scalarizeList(s, getFAbstractEquations());
                    } else if (hasElse()) {
                        scalarizeList(s, getElse().getFAbstractEquations());
                    }
                    lockedBranch = true;
                }
            } catch (ConstantEvaluationException e) {}
        }
        if (!lockedBranch) {
            super.scalarize(s);
        }
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:396
     */
    @Override
    public SimpleEquationBlock createSimpleEquationBlock(Collection<FVariable> fvs, Collection<Integer> assignedIndices, Solvability solvability, EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) { 
        for (Integer assignedIndex : assignedIndices)
            if (assignedIndex == null)
                throw new IllegalArgumentException("FIfEquation, AssignedIndex must be set for this class type! equation: " + this);
        if (solvability.isAnalyticallySolvable()) {
            return new SolvedIfEquationBlock(producer, blockDependency, this, fvs, assignedIndices);
        } else {
            return new UnsolvedIfEquationBlock(producer, blockDependency, this, fvs, assignedIndices);
        }
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:425
     */
    @Override
    public SimpleEquationBlock createMetaEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
        return new MetaEquationBlock(producer, blockDependency, this);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:2148
     */
    @Override
    public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>>
    AbstractBiPGraph<E, V, C>.IncidenceMap createIncidenceMap(AbstractBiPGraph<E, V, C> g, EnumSet<AbstractBiPGraph.VarType> variableTypes,
            AbstractBiPGraph.VariableResolver<E, V> resolver) {
        return g.new ManyIncidenceMap(this, resolver, variableTypes);
    }
    /**
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:107
     */
    public FIfWhenElseEquation eliminateIfEquationsLocal(List<FAbstractEquation> equations) {
        boolean evaluated = false;
        boolean testValue = false;
        if (getTest().variability().knownParameterOrLess()) {
            try {
                CValue cval = getTest().ceval();
                if (cval.hasBooleanValue()) {
                    testValue = cval.booleanValue();
                    evaluated = true;
                }
            } catch (ConstantEvaluationException e) {}
        }
        
        if (evaluated) {
            if (testValue) {
                if (equations == null) {
                    List<FAbstractEquation> subEquations = new List<>();
                    eliminateChildIfEquationsToList(subEquations);
                    return new FElseEquation(getType(), subEquations);
               } else {
                    eliminateChildIfEquationsToList(equations);
                    return null;
                }
            } else {
                if (hasElse()) {
                    return getElse().eliminateIfEquationsLocal(equations);
                } else {
                    return null;
                }
            }
        } else {
            if (hasElse()) {
                FIfWhenElseEquation elseEquation = getElse().eliminateIfEquationsLocal(null);
                if (elseEquation == null) {
                    setElseOpt(new Opt<FIfWhenElseEquation>());
                } else {
                    setElse(elseEquation);
                }
            }
            return this;
        }
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:98
     */
    public void checkIfEquationCompliance() {
        int numAssigned = referencedFVariablesInLHS().size();
        int numEqs = numScalarEquations();

        if (numAssigned != numEqs) {
            compliance("If equations that has non-parameter tests and contains function calls using multiple outputs"
                    + " must assign the same variables in all branches");
        }
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:159
     */
    public void rewriteIfEquations(List<FAbstractEquation> equations) {
        List<FAbstractEquation> myEquations = new List<FAbstractEquation>();
        for (FAbstractEquation equation : getFAbstractEquationList()) {
            equation.rewriteIfEquations(myEquations);
        }

        if (hasElse()) {
            getElse().rewriteIfEquations(equations);
        }

        setFAbstractEquationList(myEquations);
        if (isTopWhenIfEquation()) { 
            equations.addAll(createIfExpEquationList());
        } else {
            replaceMe(new FElseEquation(getType(), createIfExpEquationList()));
        }
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:201
     */
    protected static ArrayList<FEquation> unmatchedEquations(
            FIfWhenElseEquation ifEqn, Set<FAbstractVariable> varsInBoth) {
        Set<FEquation> unMatchedAssign = 
            valuesOfUnNamedKeys(ifEqn.assignmentEquationMap(), varsInBoth);
        unMatchedAssign.addAll(ifEqn.nonAssignmentEquationSet());
        return toSortedList(unMatchedAssign, CHILD_ORDER_COMPARATOR);
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:209
     */
    private int[][] matchEquationsMinimizeIncidences(ArrayList<FEquation> left, ArrayList<FEquation> right) {
        int nl = left.size();
        int nr = right.size();
        if (nl == 0 || nr == 0)
            return new int[0][0];
        int[][] weights = new int[nl][nr];
        for (int i = 0; i < nl; i++) {
            for (int j = 0; j < nr; j++) {
                Set<String> rightVars = right.get(j).referencedVariablesAsStrings();
                weights[i][j] = rightVars.size();
                for (String var : left.get(i).referencedVariablesAsStrings()) 
                    weights[i][j] += rightVars.contains(var) ? -1 : 1;
            }
        }
        return new DenseMunkresProblem(IntegerCost.create(weights)).solve();
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:226
     */
    private void sortOutMatchedEquations(ArrayList<FEquation> eqns, int[][] match, int col, 
            ArrayList<FEquation> matched, List<FAbstractEquation> remaining) {
        int n = eqns.size();
        boolean used[] = new boolean[n];
        for (int i = 0; i < match.length; i++) {
            matched.add(eqns.get(match[i][col]));
            used[match[i][col]] = true;
        }
        for (int i = 0; i < n; i++)
            if (!used[i]) {
                remaining.add(eqns.get(i));
            }
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:331
     */
    public void copyFlagsTo(FIfEquation e) {
        if (isTempAssign()) {
            e.setIsTempAssign();
        }

        if (isWhen()) {
            e.setWhen();
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:366
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (isWhen() && p.inInitialSystem() && !getTest().isInitialGuard()) {
            return;
        }
        p.printPreSteps(this, str, indent);
        genIfStart_C(p, str, indent);
        for (FAbstractEquation equation : getFAbstractEquations())
            p.print(equation, str, p.indent(indent));
        if (hasElse()) {
            p.print(getElse(), str,indent);
        }
        genIfEnd_C(p, str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:404
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(getTest(), str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:409
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        p.printPostSteps(getTest(), str, indent);
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:130
     */
    @Override
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        super.genBlock_C(p, str, indent, visited, forVariables, forIndices);
        if (hasElse())
            getElse().genBlock_C(p, str, indent, visited, forVariables, forIndices);
        genIfEnd_C(p, str, indent);
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:162
     */
    @Override
    public void genBlockEval_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        super.genBlockEval_C(p, str, indent, visited, forVariables, forIndices);
        if (hasElse())
            getElse().genBlockEval_C(p, str, indent, visited, forVariables, forIndices);
        genIfEnd_C(p, str, indent);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIfEquation() {
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
        children = new ASTNode[6];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
    }
    /**
     * @declaredat ASTNode:18
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "FAttribute", "FStringComment", "FAbstractEquation", "Test", "Else"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>", "List<FAbstractEquation>", "FExp", "Opt<FIfWhenElseEquation>"},
        kind = {"Token", "List", "Opt", "List", "Child", "Opt"}
    )
    public FIfEquation(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2, List<FAbstractEquation> p3, FExp p4, Opt<FIfWhenElseEquation> p5) {
        setType(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setChild(p5, 4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:32
     */
    protected int numChildren() {
        return 5;
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
        getInitialEquationList_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FIfEquation clone() throws CloneNotSupportedException {
        FIfEquation node = (FIfEquation) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FIfEquation copy() {
        try {
            FIfEquation node = (FIfEquation) clone();
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
     * @declaredat ASTNode:75
     */
    @Deprecated
    public FIfEquation fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:85
     */
    public FIfEquation treeCopyNoTransform() {
        FIfEquation tree = (FIfEquation) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 5:
                    tree.children[i] = List.EMPTY;
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
     * @declaredat ASTNode:110
     */
    public FIfEquation treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:115
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenEquationType_Type == ((FIfEquation) node).tokenEquationType_Type);    
    }
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
     * Replaces the Test child.
     * @param node The new node to replace the Test child.
     * @apilevel high-level
     */
    public void setTest(FExp node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the Test child.
     * @return The current node used as the Test child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Test")
    public FExp getTest() {
        return (FExp) getChild(3);
    }
    /**
     * Retrieves the Test child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Test child.
     * @apilevel low-level
     */
    public FExp getTestNoTransform() {
        return (FExp) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the Else child. This is the <code>Opt</code>
     * node containing the child Else, not the actual child!
     * @param opt The new node to be used as the optional node for the Else child.
     * @apilevel low-level
     */
    public void setElseOpt(Opt<FIfWhenElseEquation> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) Else child.
     * @param node The new node to be used as the Else child.
     * @apilevel high-level
     */
    public void setElse(FIfWhenElseEquation node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional Else child exists.
     * @return {@code true} if the optional Else child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasElse() {
        return getElseOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Else child.
     * @return The Else child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FIfWhenElseEquation getElse() {
        return (FIfWhenElseEquation) getElseOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Else child. This is the <code>Opt</code> node containing the child Else, not the actual child!
     * @return The optional node for child the Else child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Else")
    public Opt<FIfWhenElseEquation> getElseOpt() {
        return (Opt<FIfWhenElseEquation>) getChild(4);
    }
    /**
     * Retrieves the optional node for child Else. This is the <code>Opt</code> node containing the child Else, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Else.
     * @apilevel low-level
     */
    public Opt<FIfWhenElseEquation> getElseOptNoTransform() {
        return (Opt<FIfWhenElseEquation>) getChildNoTransform(4);
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
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInitialEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getInitialEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
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
            setChild(new List(node), 5);
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
        return 5;
    }
    /**
     * Retrieves the InitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getInitialEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(5);
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
    /** @apilevel internal */
    private void getInitialEquationList_reset() {
        getInitialEquationList_computed = false;
        
        getInitialEquationList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInitialEquationList_computed = false;

    /** @apilevel internal */
    protected List<FAbstractEquation> getInitialEquationList_value;

    /**
     * @attribute syn nta
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2456
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2456")
    public List<FAbstractEquation> getInitialEquationList() {
        ASTState state = state();
        if (getInitialEquationList_computed) {
            return (List<FAbstractEquation>) getChild(getInitialEquationListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInitialEquationList_value = getInitialEquationList_compute();
        if(getInitialEquationList_value.numChildren() <= 0) {
            getInitialEquationList_value  = List.EMPTY;
        }
        setChild(getInitialEquationList_value, getInitialEquationListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInitialEquationList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<FAbstractEquation> node = (List<FAbstractEquation>) this.getChild(getInitialEquationListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<FAbstractEquation> getInitialEquationList_compute() {
            return createInitialEquationList();
        }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1399")
    public String ifWhenType() {
        String ifWhenType_value = "if";
        return ifWhenType_value;
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
                return super.isReal(exclusive) && (!exclusive || (!hasElse() || getElse().isReal()));
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
                if (isWhen())
                    return Variability.DISCRETE;
                TypePrefixVariability var = super.variability();
                if (hasElse())
                    var = var.combine(getElse().variability());
                return var;
            }
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:519
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:519")
    public boolean isBalancedEquations() {
        boolean isBalancedEquations_value = hasElse() ? elseIsBalancedEquations() : numScalarEquations() == 0;
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
        boolean isBalancedAssignments_value = hasElse() ? elseIsBalancedAssignments() : numScalarEquations() == 0;
        return isBalancedAssignments_value;
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
        boolean hasInlinableFunctions_AbstractFunctionInliner_value = super.hasInlinableFunctions(fi) || (hasElse() && getElse().hasInlinableFunctions(fi));
        return hasInlinableFunctions_AbstractFunctionInliner_value;
    }
    /**
     * @attribute syn
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:83
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Derivatives", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:83")
    public Collection<FAbstractEquation> diff(String name) {
        {
                if (isWhen()) {
                    throw new EquationDifferentiationException(this, "Cannot differentate the equation:\n   " + prettyPrint(""));
                }
                try {
                    Opt<FIfWhenElseEquation> elseOpt = hasElse() ?
                        new Opt<FIfWhenElseEquation>((FElseEquation)getElse().diff(name).iterator().next()):
                        new Opt<FIfWhenElseEquation>();
                    return Arrays.asList(dynamicFAbstractEquation(
                            new FIfEquation(getType(), FAbstractEquation.diffList(name, getFAbstractEquations()), getTest().treeCopy(), elseOpt)));
                } catch (ExpressionDifferentiationException e) {
                    throw new EquationDifferentiationException(this, e.toQuotedString() + " in equation:\n   " + this);
                }
            }
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:257
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:257")
    public List<FAbstractEquation> createIfExpEquationList() {
        {
                List<FAbstractEquation> l = new List<FAbstractEquation>();
        
                // Generate equations for assignment equations that can be matched.
                Set<FAbstractVariable> varsInBoth = assignmentEquationMap().keySet();
                if (hasElse()) {
                    varsInBoth = intersection(varsInBoth, getElse().assignmentEquationMap().keySet());
                }
                for (FAbstractVariable v : toSortedList(varsInBoth, FAbstractVariable.NAME_COMPARATOR)) {
                    FExp left = assignmentEquationMap().get(v).assignmentExp().fullCopy();
                    FExp right = getElse().assignmentEquationMap().get(v).assignmentExp().fullCopy();
                    FIfExp ifExp = new FIfExp(getTest().fullCopy(), left, right);
                    FEquation e = new FEquation(getType(), v.createAccessExp(), ifExp);
                    if (isWhen()) {
                        ifExp.setWhen();
                        e.setWhen();
                    }
                    l.add(e);
                }
        
                // Find equations to match up among remaining FEquations based on indices.
                ArrayList<FEquation> unmatchedLeft = unmatchedEquations(this, varsInBoth);
                ArrayList<FEquation> unmatchedRight;
        
                if (hasElse()) {
                    unmatchedRight = unmatchedEquations(getElse(), varsInBoth);
                } else {
                    unmatchedRight = new ArrayList<FEquation>();
                }
        
                int[][] match = matchEquationsMinimizeIncidences(unmatchedLeft, unmatchedRight);
        
                /*
                 * Sort remaining equations into those that should remain in if equation
                 * and those that should become residual eqns left side.
                 */
                ArrayList<FEquation> residualLeft = new ArrayList<FEquation>();
                List<FAbstractEquation> keepLeft = new List<FAbstractEquation>();
                sortOutMatchedEquations(unmatchedLeft, match, 0, residualLeft, keepLeft);
                keepLeft.addAll(toSortedList(nonFEquationSet(), CHILD_ORDER_COMPARATOR));
                // Right side
                ArrayList<FEquation> residualRight = new ArrayList<FEquation>();
                List<FAbstractEquation> keepRight = new List<FAbstractEquation>();
                sortOutMatchedEquations(unmatchedRight, match, 1, residualRight, keepRight);
                if (hasElse()) {
                    keepRight.addAll(toSortedList(getElse().nonFEquationSet(), CHILD_ORDER_COMPARATOR));
                }
        
                // Generate residual equations.
                for (FEquation[] eqs : new ParallelIterable<FEquation>(new FEquation[2], true, residualLeft, residualRight)) {
                    FExp left = eqs[0].createResidualExp();
                    FExp right = eqs[1].createResidualExp();
                    FIfExp ifExp = new FIfExp(getTest().fullCopy(), left, right);
                    l.add(new FEquation(getType(), eqs[0].type().zeroLiteral(), ifExp));
                }
        
                // Generate new if equation with remaining equations.
                FIfEquation e;
                if (keepLeft.getNumChild() > 0) {
                    Opt<FIfWhenElseEquation> elseOpt = new Opt<FIfWhenElseEquation>();
                    if (keepRight.getNumChild() > 0) 
                        elseOpt.addChild(new FElseEquation(getType(), keepRight));
                    e = new FIfEquation(getType(), keepLeft, getTest(), elseOpt);
                    copyFlagsTo(e);
                    l.add(e);
                } else if (keepRight.getNumChild() > 0) {
                    e = new FIfEquation(getType(), keepRight, new FNotExp(getTest()), new Opt());
                    copyFlagsTo(e);
                    l.add(e);
                }
        
                return l;
            }
    }
    /**
     * @attribute inh
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:573")
    public boolean isTopWhenIfEquation() {
        boolean isTopWhenIfEquation_value = getParent().Define_isTopWhenIfEquation(this, null);
        return isTopWhenIfEquation_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     */
    public boolean Define_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElseOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1567
            return getTest().inDeadIfBranchTest(true);
        }
        else if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1566
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getTest().inDeadIfBranchTest(false);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:210
     * @apilevel internal
     */
    public boolean Define_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getTestNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:211
            return !containsConnect();
        }
        else {
            return getParent().Define_inIfTestWithoutConnect(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:210
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIfTestWithoutConnect
     */
    protected boolean canDefine_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        if (_callerNode == getElseOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:440
            return lockMyBranch(this, checkType, getTest(), false);
        }
        else if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:439
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return lockMyBranch(this, checkType, getTest(), true);
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
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_transformedGuards(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2054
        if (isWhen()) {
            {
                FAbstractEquation target = (FAbstractEquation) (this);
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
            collection.add(getTest());
        }
    }
}
