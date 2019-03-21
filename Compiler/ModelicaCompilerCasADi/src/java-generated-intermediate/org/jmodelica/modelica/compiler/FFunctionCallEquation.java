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
 * An equation consisting of a left hand side that is a list of component 
 * references and a right hand side that is a function call.
 * 
 * Example: (x, y, z) = func(a, b);
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:481
 * @astdecl FFunctionCallEquation : FAbstractEquation ::= Left:FFunctionCallLeft* Call:FAbstractFunctionCall;
 * @production FFunctionCallEquation : {@link FAbstractEquation} ::= <span class="component">Left:{@link FFunctionCallLeft}*</span> <span class="component">Call:{@link FAbstractFunctionCall}</span>;

 */
public class FFunctionCallEquation extends FAbstractEquation implements Cloneable {
    /**
     * Constructs a function call equation that is not initial.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:116
     */
    public FFunctionCallEquation(List<FFunctionCallLeft> left, FAbstractFunctionCall call) {
        this(EquationType.NORMAL, new List<FAttribute>(), new Opt<FStringComment>(), left, call);
    }
    /**
     * Constructs a function call equation.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:123
     */
    public FFunctionCallEquation(EquationType type, List<FFunctionCallLeft> left, FAbstractFunctionCall call) {
        this(type, new List<FAttribute>(), new Opt<FStringComment>(), left, call);
    }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:213
     */
    public void addToParameterEquationsMap(
			Map<FAbstractVariable,FAbstractEquation> map) {
		for (FFunctionCallLeft left : getLefts())
			if (left.hasFExp())
				left.getFExp().addToParameterEquationsMap(map, this);
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1412
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(indent);
		if (getNumLeft() > 0) {
	   		str.print("(");
	   		getLefts().prettyPrintWithSep(p, str, indent, ", ");
	   		str.print(") = ");
		}
   		p.print(getCall(), str, indent);
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p);
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:331
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        if (inWhen) {
            for (FFunctionCallLeft left : getLefts()) {
                if (left.hasFExp()) {
                    left.getFExp().makeContinuousVariablesDiscrete();
                }
            }
        }
    }
    /**
     * @aspect AssertEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1619
     */
    @Override
    public boolean evaluateAsserts(boolean inClause) {
        return getCall().evaluateAsserts(inClause);
    }
    /**
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1752
     */
    public void collectReinits(Map<FAbstractVariable,Set<FReinit>> map) {
        getCall().collectReinits(map);
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:105
     */
    @Override
    public void flattenEqn(Flattener f, List<FAbstractEquation> l) {
        if (ignoreInFlattening()) {
            return;
        }
        FExp call = getCall().flatten(f);
        if (!(call instanceof FAbstractFunctionCall)) {
            return;
        }
        List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
        for (FFunctionCallLeft left : getLefts()) { 
            lefts.add(left.flatten(f));
        }
        FFunctionCallEquation flattened =  new FFunctionCallEquation(lefts, (FAbstractFunctionCall) call);
        flattenAttrs(f, flattened);
        l.add(flattened);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:108
     */
    public void sanityCheckParameterEquations(FClass fc) {
        for (FFunctionCallLeft left : getLefts())
            if (left.hasFExp())
                left.getFExp().sanityCheckParameterEquationLeft(fc, this);
    }
    /**
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1686
     */
    public void makeReinitedVarsStates() {
        getCall().makeReinitedVarsStates();
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:921
     */
    @Override
    public void insertTempsInLHS(FClass fClass, boolean param) {
        for (FFunctionCallLeft left : getLefts()) {
            left.insertTempsInLHS(fClass, param);
        }
    }
    /**
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:32
     */
    public void constantFolding(VariableEvaluator evaluator) {
        if (getCall() instanceof FAssert) {
            return;
        }
        for (FExp childExp : getCall().childFExps()) {
            childExp.constantFolding(evaluator);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:825
     */
    @Override
    public Collection<FAbstractEquation> inlineFunctions(AbstractFunctionInliner fi) {
        if (getCall().isInlinableFunctionCall(fi)) {
            getCall().inline(fi);
            ArrayList<FFunctionVariable> outs = ((FFunctionCall) getCall()).myCallOutputs();
            int n = getNumLeft();
            ArrayList<FAbstractEquation> list = new ArrayList<FAbstractEquation>();
            for (int i = 0; i < n; i++) {
                if (getLeft(i).hasFExp()) {
                    FAccess name = outs.get(i).getFAccess().fullCopy();
                    name.removeFArraySubscripts();
                    name.scalarized = true;
                    getLeft(i).getFExp().createInliningOutputEquations(list, fi, name);
                }
            }
            return fi.handleInlinedFunctionCallEquation(this, list);
        } else {
            getCall().inlineFunctions(fi);
            return Collections.singletonList((FAbstractEquation)this);
        }
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:354
     */
    public void variabilityPropagation(FClass.VariabilityPropagator propagator) {
        
        TypePrefixVariability variability = getCall().variability();
        for (FFunctionCallLeft left : getLefts()) {
            if (left.hasFExp() && !left.getFExp().canPropagate()) {
                variability = Variability.CONTINUOUS;
                break;
            }
        }
        boolean eval = variability.knownParameterOrLess() || 
                (potentialPartialVariability().knownParameterOrLess() && 
                    (!isInitial() || propagator.propagateInitialPartial()));
        
        CValue[] val = null;
        if (eval) {
            try {
                VariableEvaluator evaluator = propagator.evaluator(variability);
                val = getCall().evaluate(evaluator);
            } catch (ConstantEvaluationException e) {
                eval = false;
            }
        }
        
        boolean allRemoved = true;
        int i = 0;
        for (FFunctionCallLeft left : getLefts()) {
            if (left.hasFExp()) {
                if (left.getFExp().canPropagate()) {
                    left.taggedByVProp = left.getFExp().variabilityPropagation(propagator,
                            eval ? val[i] : CValue.UNKNOWN, variability);
                }
                allRemoved &= left.taggedByVProp;
            }
            i++;
        }
        
        if (allRemoved) {
            taggedByVProp = Variability.CONSTANT;
        } else {
            variability = variability.combine(Variability.FIXEDPARAMETER);
            propagator.moveEquation(variability, this);
        }
        taggedForCleanup = true;
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:655
     */
    public boolean taggedForCleanup = false;
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:673
     */
    public void cleanEquations(ArrayList<FAbstractEquation> l, TypePrefixVariability v) {
        super.cleanEquations(l, v);
        if (taggedForCleanup) {
            for (FFunctionCallLeft left : getLefts()) {
                left.cleanEquations();
            }
            taggedForCleanup = false;
        }
    }
    /**
     * Scalarize equation and put all scalarized equations in list eqns.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1211
     */
    public void scalarize(Scalarizer.Equation s) {
        if (getCall().isOperatorWithoutOutputs()) {
            createArrayTemporaries(s);
            getCall().scalarizeOperatorWithoutOutputs(s);
        } else {
            getCall().createArrayTemporaries(s);
            getLefts().createArrayTemporaries(s);
        }
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:384
     */
    @Override
	public SimpleEquationBlock createSimpleEquationBlock(Collection<FVariable> fvs, Collection<Integer> assignedIndices, Solvability solvability, EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
		for (Integer assignedIndex : assignedIndices)
			if (assignedIndex == null)
				throw new IllegalArgumentException("FFunctionCallEquation, AssignedIndex must be set for this class type! equation: " + this);
		if (solvability.isAnalyticallySolvable()) {
			return new SolvedFunctionCallEquationBlock(producer, blockDependency, this, fvs, assignedIndices);
		} else {
			return new UnsolvedFunctionCallEquationBlock(producer, blockDependency, this, fvs, assignedIndices);
		}
	}
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:420
     */
    @Override
    public SimpleEquationBlock createMetaEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
        return new MetaEquationBlock(producer, blockDependency, this);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:2156
     */
    @Override
    public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> 
    AbstractBiPGraph<E, V, C>.IncidenceMap createIncidenceMap(AbstractBiPGraph<E, V, C> g, EnumSet<AbstractBiPGraph.VarType> variableTypes,
            AbstractBiPGraph.VariableResolver<E, V> resolver) {
        if (myOptions().getStringOption("function_incidence_computation").equals("all")) {
            try {
                AbstractBiPGraph<E, V, C>.SplitIncidenceMap splitIncidenceMap = g.new SplitIncidenceMap(this, resolver, variableTypes);
                splitIncidenceMap.lhs(); // trigger cache calculations
                return splitIncidenceMap;
            } catch (ConstantEvaluationException e) {
                
            }
        }
        return g.new ManyIncidenceMap(this, resolver, variableTypes);
    }
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:664
     */
    @Override
    public <V> AbstractBiPGraph.AssignmentIncidenceMap assignmentIncidenceMap(AbstractBiPGraph g, EnumSet<AbstractBiPGraph.VarType> variableTypes, AbstractBiPGraph.VariableResolver resolver) {
        return g.new SplitIncidenceMap(this, resolver, variableTypes);
    }
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:222
     */
    public void removeBindingExpOfAssignedVars() {
		for (FFunctionCallLeft left : getLefts())
			if (left.hasFExp())
				left.getFExp().removeBindingExpOfReferencedVars();
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:239
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		if (!getCall().isIgnoredXML()) {
			String indent2 = p.indent(indent);
			open_XML(str, indent);
			for (FFunctionCallLeft f : this.getLeftList())
				p.print(f, str, indent2);
			p.print(getCall(), str, indent2);
			close_XML(str, indent);
		}
	}
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:359
     */
    @Override
	public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
		if (!getCall().isIgnored()) {
			p.printPreSteps(this, str, indent);
		}
	}
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:47
     */
    @Override
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        if (!getCall().isIgnored()) {
            genBlockEval_C(p, str, indent, visited, forVariables, forIndices);
            for (FFunctionCallLeft l : getLefts()) {
                l.genWriteBackAssignment_C(p, str, indent, forVariables);
            }
        }
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:58
     */
    @Override
    public void genBlockEval_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        boolean firstVisit = visited == null || visited.add(this);
        if (!getCall().isIgnored()) {
            if (firstVisit) {
                p.printPreSteps(this, str, indent);
            }
        }
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:61
     */
    @Override
    public void genResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices) {
        boolean firstVisit = visited == null || visited.add(this);
        if (!getCall().isIgnored()) {
            if (firstVisit) {
                p.printPreSteps(this, str, indent);
            }
            Enumerator indexCounter = new Enumerator();
            for (FFunctionCallLeft l : getLefts())
                p.printWriteBackResidual(str, indent, l, enumerator, forIndices, indexCounter);
        }
    }
    /**
     * @aspect CCodeGenGlobalsReinit
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:235
     */
    @Override
    public void collectReinits_C(CodePrinter p, Collection<FReinit> res) {
        getCall().collectReinits_C(p, res);
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:660
     */
    public boolean isIgnoredForCasADi() {
        // Ignore things that we don't support right now, such as asserts
        return getNumLeft() == 0;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionCallEquation() {
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
        children = new ASTNode[5];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(List.EMPTY, 4);
    }
    /**
     * @declaredat ASTNode:17
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "FAttribute", "FStringComment", "Left", "Call"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>", "List<FFunctionCallLeft>", "FAbstractFunctionCall"},
        kind = {"Token", "List", "Opt", "List", "Child"}
    )
    public FFunctionCallEquation(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2, List<FFunctionCallLeft> p3, FAbstractFunctionCall p4) {
        setType(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:30
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:36
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getInitialEquationList_reset();
        assignedSet_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:46
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public FFunctionCallEquation clone() throws CloneNotSupportedException {
        FFunctionCallEquation node = (FFunctionCallEquation) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:55
     */
    public FFunctionCallEquation copy() {
        try {
            FFunctionCallEquation node = (FFunctionCallEquation) clone();
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
     * @declaredat ASTNode:74
     */
    @Deprecated
    public FFunctionCallEquation fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:84
     */
    public FFunctionCallEquation treeCopyNoTransform() {
        FFunctionCallEquation tree = (FFunctionCallEquation) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 4:
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
     * @declaredat ASTNode:109
     */
    public FFunctionCallEquation treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:114
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenEquationType_Type == ((FFunctionCallEquation) node).tokenEquationType_Type);    
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
     * Replaces the Left list.
     * @param list The new list node to be used as the Left list.
     * @apilevel high-level
     */
    public void setLeftList(List<FFunctionCallLeft> list) {
        setChild(list, 2);
    }
    /**
     * Retrieves the number of children in the Left list.
     * @return Number of children in the Left list.
     * @apilevel high-level
     */
    public int getNumLeft() {
        return getLeftList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Left list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Left list.
     * @apilevel low-level
     */
    public int getNumLeftNoTransform() {
        return getLeftListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Left list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Left list.
     * @apilevel high-level
     */
    public FFunctionCallLeft getLeft(int i) {
        return (FFunctionCallLeft) getLeftList().getChild(i);
    }
    /**
     * Check whether the Left list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasLeft() {
        return getLeftList().getNumChild() != 0;
    }
    /**
     * Append an element to the Left list.
     * @param node The element to append to the Left list.
     * @apilevel high-level
     */
    public void addLeft(FFunctionCallLeft node) {
        List<FFunctionCallLeft> list = (parent == null) ? getLeftListNoTransform() : getLeftList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addLeftNoTransform(FFunctionCallLeft node) {
        List<FFunctionCallLeft> list = getLeftListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Left list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setLeft(FFunctionCallLeft node, int i) {
        List<FFunctionCallLeft> list = getLeftList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Left list.
     * @return The node representing the Left list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Left")
    public List<FFunctionCallLeft> getLeftList() {
        List<FFunctionCallLeft> list = (List<FFunctionCallLeft>) getChild(2);
        return list;
    }
    /**
     * Retrieves the Left list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Left list.
     * @apilevel low-level
     */
    public List<FFunctionCallLeft> getLeftListNoTransform() {
        return (List<FFunctionCallLeft>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the Left list without
     * triggering rewrites.
     */
    public FFunctionCallLeft getLeftNoTransform(int i) {
        return (FFunctionCallLeft) getLeftListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Left list.
     * @return The node representing the Left list.
     * @apilevel high-level
     */
    public List<FFunctionCallLeft> getLefts() {
        return getLeftList();
    }
    /**
     * Retrieves the Left list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Left list.
     * @apilevel low-level
     */
    public List<FFunctionCallLeft> getLeftsNoTransform() {
        return getLeftListNoTransform();
    }
    /**
     * Replaces the Call child.
     * @param node The new node to replace the Call child.
     * @apilevel high-level
     */
    public void setCall(FAbstractFunctionCall node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the Call child.
     * @return The current node used as the Call child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Call")
    public FAbstractFunctionCall getCall() {
        return (FAbstractFunctionCall) getChild(3);
    }
    /**
     * Retrieves the Call child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Call child.
     * @apilevel low-level
     */
    public FAbstractFunctionCall getCallNoTransform() {
        return (FAbstractFunctionCall) getChildNoTransform(3);
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
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInitialEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getInitialEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
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
            setChild(new List(node), 4);
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
        return 4;
    }
    /**
     * Retrieves the InitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getInitialEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(4);
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
     * Constant evaluation of binding equation for dependent parameter.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3268")
    public CValue cevalParameter(VariableEvaluator evaluator, FVariable fv) {
        {
        	  CValue[] vals = getCall().cevalFunction(evaluator);
        	  for (int i = 0; i < getNumLeft(); i++) {
        		  CValue res = getLeft(i).extractCValue(vals[i], fv);
        		  if (res != null)
        			  return res;
        	  }
        	  return CValue.UNKNOWN;
          }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881")
    public int numScalarEquations() {
        {
                int res = 0;
                for (FFunctionCallLeft l : getLefts())
                    res += l.numScalarElements();
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2265
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2265")
    public Set<FVariable> boundParameters() {
        { 
                if (isParameterEquation()) { 
                    return referencedParametersInLHS(); 
                } else {
                    return Collections.emptySet();
                }
            }
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
            if (getCall() instanceof FSpatialDistExp) {
                FSpatialDistExp call = (FSpatialDistExp) getCall();
                ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
                if (getNumLeft() > 0 && getLeft(0).hasFExp()) {
                    l.add(new FEquation(getLeft(0).getFExp().copySymbolic(), call.createInitialReplacement(false)));
                }
                if (getNumLeft() > 1 && getLeft(1).hasFExp()) {
                    l.add(new FEquation(getLeft(1).getFExp().copySymbolic(), call.createInitialReplacement(true)));
                }
                return new List<FAbstractEquation>(l);
            }
            return super.getInitialEquationList();
        }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888")
    public Set<FAccessExp> FAccessExpsInRHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        Set<FAccessExp> FAccessExpsInRHS_CommonAccessExpLookupVisitor_FAccessExp__value = getCall().findCommonAccessExpsInTree(visitor);
        return FAccessExpsInRHS_CommonAccessExpLookupVisitor_FAccessExp__value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929")
    public Set<FAccessExp> FAccessExpsInLHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        Set<FAccessExp> FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value = getLefts().findCommonAccessExpsInTree(visitor);
        return FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3032
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3032")
    public Set<FVariable> referencedParametersInLHS() {
        Set<FVariable> referencedParametersInLHS_value = parametersInSet(referencedFVariablesInLHS());
        return referencedParametersInLHS_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1030
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1030")
    public boolean ignoreInFlattening() {
        boolean ignoreInFlattening_value = getCall().ignoreInFlattening();
        return ignoreInFlattening_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1036
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1036")
    public boolean isIgnored() {
        boolean isIgnored_value = getCall().isIgnored();
        return isIgnored_value;
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
                // Check all output arguments
                for (FFunctionCallLeft fl : getLefts()) {
                    if (fl.hasFExp()) {
                        var = var.combine(fl.getFExp().variability());
                    }
                }
                // Check call
                return var.combine(getCall().variability());
            }
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
        assignedSet_value = assignedSet_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        assignedSet_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return assignedSet_value;
    }
    /** @apilevel internal */
    private Set<InstComponentDecl> assignedSet_compute() {
            LinkedHashSet<InstComponentDecl> s = new LinkedHashSet<InstComponentDecl>();
            for (FFunctionCallLeft left : getLefts()) {
                if (left.hasFExp()) {
                    s.addAll(left.getFExp().accessedVarSet());
                }
            }
            return s;
        }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582")
    public boolean hasFunctionCallEquations() {
        boolean hasFunctionCallEquations_value = true;
        return hasFunctionCallEquations_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:599")
    public boolean hasFunctionCallEquationsWithLefts() {
        boolean hasFunctionCallEquationsWithLefts_value = getNumLeft() > 0;
        return hasFunctionCallEquationsWithLefts_value;
    }
    /**
     * Check if this equation can cause events. 
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:717
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:717")
    public boolean generatesEvents() {
        boolean generatesEvents_value = getCall().generatesEvents();
        return generatesEvents_value;
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
        boolean hasInlinableFunctions_AbstractFunctionInliner_value = getCall().hasInlinableFunctions(fi);
        return hasInlinableFunctions_AbstractFunctionInliner_value;
    }
    /**
     * Checks if equation is eligible for var. prop.
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:23")
    public boolean canPropagate(FClass.VariabilityPropagator propagator) {
        {
                getCall().flushAllRecursive();
                return super.canPropagate(propagator) && propagator.variables(this).size() > 0 && numScalarEquations() > 0 && 
                        ((propagator.variables(this).size() == numScalarEquations() && getCall().variability().parameterOrLess()) 
                                || potentialPartialVariability().knownParameterOrLess());
            }
    }
    /**
     * If any arg is constant return constant. Otherwise returns combined variability.
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:49
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:49")
    public TypePrefixVariability potentialPartialVariability() {
        TypePrefixVariability potentialPartialVariability_value = getCall().potentialPartialVariability();
        return potentialPartialVariability_value;
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
                try {
                    FExp diffedCall = getCall().diff(name);
                    if (diffedCall.isLiteralZero()) {
                        Collection<FAbstractEquation> res = new ArrayList<FAbstractEquation>();
                        for (FFunctionCallLeft left : getLefts())
                            for (FAccessExp use : FAccessExpsInLHS())
                                res.add(dynamicFAbstractEquation(new FEquation(use.diff(name), use.type().sizedZeroLiteral())));
                        return res;
                    } else {
                        List lefts = new List();
                        for (FFunctionCallLeft l : getLefts()) {
                            Opt lopt = l.hasFExp() ? new Opt(l.getFExp().diff(name)) : new Opt();
                            lefts.add(new FFunctionCallLeft(lopt));
                        }
                        return Arrays.asList(dynamicFAbstractEquation(
                                new FFunctionCallEquation(lefts, (FAbstractFunctionCall)diffedCall)));
                    }
                } catch (ExpressionDifferentiationException e) {
                    throw new EquationDifferentiationException(this, e.toQuotedString() + " in equation:\n   " + this);
                }
            }
    }
    /**
     * Used for evaluation of equations during analyse of overdetermined
     * initial system.
     * Tries to solve and determine the value of the provided variable.
     * Returns CValue.UNKNOWN or exception on failure.
     * @attribute syn
     * @aspect OverdeterminedInitialSystem
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\OverdeterminedInitialSystem.jrag:178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverdeterminedInitialSystem", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\OverdeterminedInitialSystem.jrag:178")
    public CValue OIS_ceval(VariableEvaluator evaluator, FVariable var) {
        CValue OIS_ceval_VariableEvaluator_FVariable_value = cevalParameter(evaluator, var);
        return OIS_ceval_VariableEvaluator_FVariable_value;
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
        		else if (leftVars.size() == 1 && duringTearing && canUseLocalIteration())
        			return Solvability.NUMERICALLY_SOLVABLE;
        		else
        			return Solvability.UNSOLVABLE;
        	}
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "FunctionCallEquation";
        return xmlTag_value;
    }
    /** @return An empty MX 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230")
    public MX toMXForLhs() {
        {
                MX myLefts = new MX();
                for (FFunctionCallLeft fleft : getLefts()) {
                    if (fleft.hasFExp()) {
                        MXVector fleftExpAsMXVex = fleft.getFExp().toMXVector();
                        for (int i = 0; i < fleftExpAsMXVex.size(); ++i) {
                            myLefts.append(fleftExpAsMXVex.get(i));
                        }
                    }
                }
                return myLefts;
            }
    }
    /** @return An empty MX 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:232
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:232")
    public MX toMXForRhs() {
        {
                MXVector rhsVec = getCall().toMXVector();
                MX returnMX = new MX();
                for (int i = 0; i < rhsVec.size(); ++i) {
                    returnMX.append(rhsVec.get(i));
                }
                return returnMX;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060
     * @apilevel internal
     */
    public Size Define_size(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1061
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().sizeOfOutput(i);
        }
        else {
            return getParent().Define_size(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute size
     */
    protected boolean canDefine_size(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     * @apilevel internal
     */
    public Set<FVariable> Define_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2263
            return boundParameters();
        }
        else {
            return getParent().Define_boundParameters(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute boundParameters
     */
    protected boolean canDefine_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329
     * @apilevel internal
     */
    public String Define_funcName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCall().name();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute funcName
     */
    protected boolean canDefine_funcName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     */
    public boolean Define_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1463
            return true;
        }
        else {
            return super.Define_isFunctionCallClause(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallClause
     */
    protected boolean canDefine_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484
     * @apilevel internal
     */
    public int Define_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1485
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? -1 : getLeft(i - 1).myLastIndex();
        }
        else {
            return getParent().Define_prevIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute prevIndex
     */
    protected boolean canDefine_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515
     * @apilevel internal
     */
    public CommonVariableDecl Define_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1516
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().findOutput(i);
        }
        else {
            return getParent().Define_myOutput(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myOutput
     */
    protected boolean canDefine_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1526
            return false;
        }
        else {
            return getParent().Define_functionCallIsExp(this, _callerNode);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1532
     * @apilevel internal
     */
    public ArrayList<FFunctionCallLeft> Define_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1536
            return getLefts().toArrayList();
        }
        else {
            return getParent().Define_myLefts(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     * @apilevel internal
     */
    public FAbstractFunctionCall Define_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1542
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getCall();
        }
        else {
            return getParent().Define_myFunctionCall(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380
     * @apilevel internal
     */
    public FType Define_type(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:782
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().typeOfOutput(i);
        }
        else {
            return getParent().Define_type(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute type
     */
    protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483
     * @apilevel internal
     */
    public String Define_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCall().functionCallDecription();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallDecription
     */
    protected boolean canDefine_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
