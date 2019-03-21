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
 * An equation consisting of a right and a left hand side expression.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:473
 * @astdecl FEquation : FAbstractEquation ::= Left:FExp Right:FExp;
 * @production FEquation : {@link FAbstractEquation} ::= <span class="component">Left:{@link FExp}</span> <span class="component">Right:{@link FExp}</span>;

 */
public class FEquation extends FAbstractEquation implements Cloneable {
    /**
     * Constructs an equation that is not initial and is not marked as
     * residual.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:95
     */
    public FEquation(FExp left, FExp right) {
        this(EquationType.NORMAL, new List<FAttribute>(), new Opt<FStringComment>(), left, right);
    }
    /**
     * Constructs an equation that is not marked as residual.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:102
     */
    public FEquation(EquationType type, FExp left, FExp right) {
        this(type, new List<FAttribute>(), new Opt<FStringComment>(), left, right);
    }
    /**
     * Constructs an equation that is not initial
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:109
     */
    public FEquation(List<FAttribute> attrs, FExp left, FExp right) {
        this(EquationType.NORMAL, attrs, new Opt<FStringComment>(), left, right);
    }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:208
     */
    public void addToParameterEquationsMap(
			Map<FAbstractVariable,FAbstractEquation> map) {
		getLeft().addToParameterEquationsMap(map, this);
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1360
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(indent);
    	p.print(getLeft(),str,indent);
   		str.print(" = ");
   		p.print(getRight(),str,indent);
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p);
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:325
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        if (inWhen) {
            getLeft().makeContinuousVariablesDiscrete();
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:503
     */
    public void contentCheck(ErrorCheckType checkType) {
		super.contentCheck(checkType);
		if (inWhen() && !isAssignmentEqn())
			error("Only assignment equations are allowed in when clauses");
	}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:419
     */
    public void typeCheck(ErrorCheckType checkType) {
        typeCheckLocalIteration(checkType);
        FType left = getLeft().type();
        FType right = getRight().type();
        if (!left.isUnknown() && !right.isUnknown()) {
            if (!left.equivalentTo(right)) {
                if (left.equivalentExceptLengths(right)) {
                    if (!lockBranch(checkType))
                        ARRAY_SIZE_MISMATCH_IN_EQUATION.invoke(this, left.size(), right.size());
                } else {
                    TYPE_MISMATCH_IN_EQUATION.invoke(this, left, right);
                }
            }
        }
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:45
     */
    @Override
    public void flattenEqn(Flattener f, List<FAbstractEquation> l) {
        FEquation flattened = new FEquation(getLeft().flatten(f), getRight().flatten(f));
        flattenAttrs(f, flattened);
        flattened.setLocation(this);
        l.add(flattened);
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:302
     */
    public void collectLocations(BaseNode collector){
    	collector.addLocation(this);
		getLeft().collectLocations(collector);
		getRight().collectLocations(collector);
		return;
	}
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:104
     */
    public void sanityCheckParameterEquations(FClass fc) {
        getLeft().sanityCheckParameterEquationLeft(fc, this);
    }
    /**
     * Detection of alias variables in equations
     * 
     * Equations of the type 'x=y', 'x=-y', '-x=y' and '-x=-y' are detected
     * as alias equations and an AliasPair object is returned.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:88
     */
    public AliasPair aliasVariables() {
        AliasPair res = null;
        if (!containsActiveAnnotations()) // This equation should not be alias-removed if it is marked as residual!
            res = aliasVariables(true);
        aliasClassified = true;
        classifiedAsAlias = res != null;
        return res;
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:97
     */
    public AliasPair aliasVariables(boolean checkVariables) {
        return aliasVariables(getLeft(), getRight(), 1, checkVariables);
    }
    /**
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1008
     */
    public void propagateDerivativeBindings() {
        if (!isDerivativeBindingEquation())
            return;
        FAbstractVariable right = getRight().asFAccessExp().myFV();
        FAbstractVariable left = getLeft().asFAccessExp().myFV();
        if (!left.isFVariable() || !right.isFVariable())
            return;
        if (left.isTemporary() || right.isTemporary())
            return;
        if (left.isInput() || right.isInput())
            return;
        if (left.variability().discreteOrLess() || right.variability().discreteOrLess())
            return;
        boolean rightIsDer = right.isDerivativeVariable();
        boolean leftIsDer = left.isDerivativeVariable();
        FVariable var;
        FVariable derVar;
        if (rightIsDer && !leftIsDer) {
            var = left.asFVariable();
            derVar = right.asFVariable();
        } else if (!rightIsDer && leftIsDer) {
            var = right.asFVariable();
            derVar = left.asFVariable();
        } else {
            return;
        }
        //aliasClass = AliasClass.DER_ALIAS;
        myFClass().getAliasManager().addDerivativeBindingPair(var, derVar.getMeIntegrated());
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:81
     */
    public void findBlockFunctionExtraction(AbstractEquationBlock block, ArrayList<FFunctionCall> functions) {  
        getLeft().findBlockFunctionExtraction(block, functions); 
        getRight().findBlockFunctionExtraction(block, functions);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:818
     */
    @Override
    public Collection<FAbstractEquation> inlineFunctions(AbstractFunctionInliner fi) {
        getLeft().inlineFunctions(fi);
        getRight().inlineFunctions(fi);
        return Collections.singletonList((FAbstractEquation)this);
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:293
     */
    public void variabilityPropagation(FClass.VariabilityPropagator propagator) {
        
        FVariable fVariable;
        FExp solution;
        TypePrefixVariability solutionVariability;
        
        fVariable = propagator.variables(this).iterator().next();
        
        if (!fVariable.canPropagate()) {
            return;
        }
        
        solution = solution(fVariable);
        solution.resetOriginalReferences();
        
        if (!solution.isValidExp()) {
            return;
        }
        
        if (!canPropagate(fVariable, solution)) {
            return;
        }
        
        solutionVariability = solution.variability();
        
        if (!solutionVariability.parameterOrLess()) {
            // Sometimes combinations of parameters and constants yield 
            // discrete variability. IfExpr, sample() etc.
            return;
        }
        
        if (solutionVariability.knownParameterOrLess()) {
            FExp newSolution = null;
            try {
                CValue cval = solution.ceval(propagator.evaluator());
                if (cval.hasBuildLiteral()) {
                    newSolution = cval.buildLiteral();
                    solution.collectLocations(newSolution);
                    solution = newSolution;
                }
            } catch (ConstantEvaluationException e) {}
            if (newSolution == null) {
                // If we can't evaluate right now, set it as parameter
                solutionVariability = Variability.FIXEDPARAMETER;
            }
        }
        
        taggedByVProp = solutionVariability;
        fVariable.variabilityPropagation(propagator, solutionVariability, solution);
        
        if (!solutionVariability.knownParameterOrLess()) {
            if (solutionVariability.fixedParameterOrLess()) {
                propagator.addEquation(solutionVariability, this.setLocationOf(new FEquation(fVariable.setLocationOf(fVariable.createAccessExp()), solution)));
            } else {
                propagator.addEquation(solutionVariability, this);
                solution.flushAllRecursive();
            }
        }
        
    }
    /**
     * Scalarize equation and put all resulting equations in list eqns.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:961
     */
    @Override
    public void scalarize(Scalarizer.Equation s) {
		//log.debug("FEquation.scalarize() " + ndims());
        if (size().isZero())
            return;
        
        createArrayTemporaries(s);
		if (ndims()==0) {
			/*
			 * If the equation is of dimension 0, i.e, already scalar,
			 * the equations is "scalarized" into a simple equation where
			 * e.g. built in functions are replaced by elementary operations.
			 */
			
            List<FAttribute> attrs = scalarizeAttributeList(Index.NULL, s);
            createScalarFEquations(s, attrs, getLeft(), getRight());
		} else if (ndims() > 0) {
			/*
			 * If the expression is an array expression, then the FExp.getArray()
			 * element is used to generate scalar equations.
			 */
			// Iterate over array elements and create scalarized equation for each
			for (Index i : indices()) {
                List<FAttribute> attrs = scalarizeAttributeList(i, s);
                createScalarFEquations(s, attrs, getLeft().getArray().get(i), getRight().getArray().get(i));
			}
		} else {
			throw new UnsupportedOperationException("Bad equation: ndims() for equation '" + 
					this + "' returned " + ndims()); 
		}
	}
    /**
     * Scalarize left and right expressions and create new scalar equations.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1003
     */
    public void createScalarFEquations(Scalarizer.Equation s, List<FAttribute> attrs, FExp left, FExp right) {
        if (left.inferType().isRecord()) {
            left.inferType().scalarRecordClauses(s, new FAccessEmpty(), left, right);
        } else {
            s.add(this.setLocationOf(new FEquation(attrs, left.scalarize(s), right.scalarize(s))));
        }
	}
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:360
     */
    @Override
	public SimpleEquationBlock createSimpleEquationBlock(Collection<FVariable> fvs, Collection<Integer> assignedIndices, Solvability solvability, EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) { 
		FVariable fv = fvs.iterator().next();
		if (solvability.isAnalyticallySolvable()) { // Solved scalar equation
			return new SolvedScalarEquationBlock(producer, blockDependency, this, fv);
		} else if(solvability.isSolvable()) { // Numerically solvable scalar equation
			return new NumericallySolvedScalarEquationBlock(producer, blockDependency, this, fv);
		} else { // Unsolved scalar equation
			return new UnsolvedScalarEquationBlock(producer, blockDependency, this, fv);
		}
	}
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:659
     */
    @Override
    public <V> AbstractBiPGraph.AssignmentIncidenceMap assignmentIncidenceMap(AbstractBiPGraph g, EnumSet<AbstractBiPGraph.VarType> variableTypes, AbstractBiPGraph.VariableResolver resolver) {
        return g.new SingleAssignmentIncidenceMap(this, resolver);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:144
     */
    private static FExp computeInactiveSolution(Collection<FExp> exps) {
        if (exps.size() == 0) {
            return new FRealLitExp(0);
        }
        java.util.List<FExp> expsCopies = new ArrayList<FExp>();
        // Compute new expressions for the inactive terms
        for (FExp exp : exps) {
            FExp expCopy = exp.copySymbolic();
            if (!exp.isNegativeTerm()) {
                expCopy = new FNegExp(expCopy);
            }
            expsCopies.add(expCopy);
        }
        return FExp.createBalancedBinaryTree(new FAddExp(), expsCopies);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:160
     */
    private static FExp computeActiveSolution(Collection<FExp> exps, FVariable var,
            boolean dontAllowDivisionByVariable, double tol) {
        java.util.List<FExp> parts = new ArrayList<FExp>();
        TypePrefixVariability mulCoeffVar = Variability.CONSTANT; // Keep track of variability
        // Compute new expressions for the active terms
        for (FExp e : exps) {
            ArrayList<FExp> fac = e.factors();
            // There is only one reference to the active variable in each
            // term - this is checked above.            
            ArrayList<FExp> activeFactors = new ArrayList<FExp>();
            ArrayList<FExp> inactiveFactors = new ArrayList<FExp>();
            // Find terms
            boolean negatedFactor = false;          
            for (FExp ee : fac) {
                if (ee.nbrUses(var.name())==1 && !ee.isInvertedFactor() && 
                    (ee.isIdentifier(var.name()) || // Identifier 
                    (ee instanceof FPreExp))) { // pre expression 
                    activeFactors.add(ee);
                } else if (ee.nbrUses(var.name())==1 && !ee.isInvertedFactor() && 
                    ((ee instanceof FNegExp) && ((FNegExp)ee).getFExp().isIdentifier(var.name()))) { 
                    // TODO: remove this branch since it is not general enough
                    activeFactors.add(((FNegExp)ee).getFExp());
                    negatedFactor = true;
                } else if (ee.nbrUses(var.name())==0) {
                    if (ee.variability().constantVariability() &&
                            Math.abs(ee.ceval().realValue()) *
                            ee.dynamicFExp(var.nominal()).ceval().realValue() < tol) {
                        return new FNoExp();
                    }
                    inactiveFactors.add(ee);
                } else {
                    // This equation cannot be solved
                    return new FNoExp();
                }
            }
            
            FExp coeff = computeInactiveFactorSolution(inactiveFactors);
            for (FExp eee : inactiveFactors) {
                mulCoeffVar = mulCoeffVar.combine(eee.variability());
            }
            if (e.isNegativeTerm() || negatedFactor) {
                coeff = new FNegExp(coeff);
            }
            parts.add(coeff);
        }
        if (dontAllowDivisionByVariable && !mulCoeffVar.lessOrEqual(Variability.CONSTANT)) {
            return new FNoExp();
        }
        return FExp.createBalancedBinaryTree(new FAddExp(), parts);
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:211
     */
    private static FExp computeInactiveFactorSolution(Collection<FExp> exps) {
        if (exps.size() == 0) {
            return new FRealLitExp(1);
        }
        java.util.List<FExp> expsCopies = new ArrayList<FExp>();
        // Compute new expressions for the inactive factor terms
        for (FExp exp : exps) {
            FExp expCopy = exp.copySymbolic();
            if (exp.isInvertedFactor()) {
                expCopy = new FDivExp(new FRealLitExp(1), expCopy);
            }
            expsCopies.add(expCopy);
        }
        return FExp.createBalancedBinaryTree(new FMulExp(), expsCopies);
    }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:661
     */
    @Override
    public void acceptTransform(EquationTransformer tf)           { tf.visit(this); }
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:218
     */
    public void removeBindingExpOfAssignedVars() {
		getLeft().removeBindingExpOfReferencedVars();
	}
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:268
     */
    public void revertToBindingExp() throws ConstantEvaluationException {
		FVariable fv = (FVariable) getLeft().asFAccessExp().getFAccess().myFV();
		fv.setBindingExp(getRight().ceval().buildLiteral());
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:226
     */
    private static final FSubExp EXP_TEMPLATE = new FSubExp();
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:228
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		String indent3 = p.indent(indent2);
		open_XML(str, indent);
		EXP_TEMPLATE.open_XML(str, indent2);
		p.print(getLeft(), str, indent3);
		p.print(getRight(), str, indent3);
		EXP_TEMPLATE.close_XML(str, indent2);
		close_XML(str, indent);
	}
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:470
     */
    @Override
    public void genAssignment_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(this, str, indent);
        FAccessExp left = getLeft().stripNegations().asFAccessExp();
        FVariable fv = (FVariable)left.myFV();
        if (fv.isExternalObject()) {
            fv.genDestructorCall_C(p, str, indent);
        }
        fv.genAssignment_C(p, str, indent, fv.name_C(), getRight(), getLeft().isNegated());
        p.printPostSteps(this, str, indent);
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:31
     */
    @Override
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        FVariable fv = forVariables.iterator().next();
        FExp sol = solution(fv);
        
        p.printPreSteps(sol, str, indent);
        p.printAssign(fv.type(), str, indent, fv, sol);
        p.printPostSteps(sol, str, indent);
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:53
     */
    @Override
    public void genResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices) {
        boolean firstVisit = visited == null || visited.add(this);
        p.printPreSteps(this, str, indent);
        p.printResidual(type(), str, indent, getLeft(), getRight(), enumerator.next());
        p.printPostSteps(this, str, indent);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FEquation() {
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
        setChild(List.EMPTY, 4);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "FAttribute", "FStringComment", "Left", "Right"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>", "FExp", "FExp"},
        kind = {"Token", "List", "Opt", "Child", "Child"}
    )
    public FEquation(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2, FExp p3, FExp p4) {
        setType(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:29
     */
    protected int numChildren() {
        return 4;
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
        size_reset();
        assignedInAllBranchesVariables_reset();
        type_reset();
        assignedSet_reset();
        isAliasEquation_reset();
        solution_FVariable_boolean_reset();
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
    public FEquation clone() throws CloneNotSupportedException {
        FEquation node = (FEquation) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:58
     */
    public FEquation copy() {
        try {
            FEquation node = (FEquation) clone();
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
    public FEquation fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public FEquation treeCopyNoTransform() {
        FEquation tree = (FEquation) copy();
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
     * @declaredat ASTNode:112
     */
    public FEquation treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:117
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenEquationType_Type == ((FEquation) node).tokenEquationType_Type);    
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
     * Replaces the Left child.
     * @param node The new node to replace the Left child.
     * @apilevel high-level
     */
    public void setLeft(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the Left child.
     * @return The current node used as the Left child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Left")
    public FExp getLeft() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the Left child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Left child.
     * @apilevel low-level
     */
    public FExp getLeftNoTransform() {
        return (FExp) getChildNoTransform(2);
    }
    /**
     * Replaces the Right child.
     * @param node The new node to replace the Right child.
     * @apilevel high-level
     */
    public void setRight(FExp node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the Right child.
     * @return The current node used as the Right child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Right")
    public FExp getRight() {
        return (FExp) getChild(3);
    }
    /**
     * Retrieves the Right child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Right child.
     * @apilevel low-level
     */
    public FExp getRightNoTransform() {
        return (FExp) getChildNoTransform(3);
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
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:163
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:163")
    public int ndims() {
        {
        		if (getLeft().ndims() == getRight().ndims()) {
        			return getLeft().ndims();
        		}
        		return -1;
        	}
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
     * Get the array sizes. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:592
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:592")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = size_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /** @apilevel internal */
    private Size size_compute() {
    		Size left = getLeft().size();
    		Size right = getRight().size();
    		return left.equals(right) ? left : Size.SCALAR;
    	}
    /**
     * Get the set of all array indices of an array access. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2289
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2289")
    public Indices indices() {
        Indices indices_value = getLeft().indices();
        return indices_value;
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
        CValue cevalParameter_VariableEvaluator_FVariable_value = getRight().ceval(evaluator);
        return cevalParameter_VariableEvaluator_FVariable_value;
    }
    /**
     * Constant evaluation of binding equation for dependent parameter.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3283
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3283")
    public CValue cevalParameter(VariableEvaluator evaluator, FVariable fv, Index i) {
        CValue cevalParameter_VariableEvaluator_FVariable_Index_value = getRight().ceval(evaluator, i);
        return cevalParameter_VariableEvaluator_FVariable_Index_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881")
    public int numScalarEquations() {
        int numScalarEquations_value = getLeft().type().numScalarElements();
        return numScalarEquations_value;
    }
    /**
     * Utility function that returns true if this equation on the form zero
     * equal to zero.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2255")
    public boolean isZeroEquation() {
        boolean isZeroEquation_value = getLeft().isLiteralZero() && getRight().isLiteralZero();
        return isZeroEquation_value;
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
                    return getLeft().referencedParametersInFExp();
                } else {
                    return Collections.emptySet();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2274
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2274")
    public Set<FVariable> RHSVariables() {
        {
                if (isParameterEquation()) {
                    return getRight().referencedParametersInFExp();
                } else {
                    return Collections.emptySet();
                }
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
        Set<FAccessExp> FAccessExpsInRHS_CommonAccessExpLookupVisitor_FAccessExp__value = getRight().findCommonAccessExpsInTree(visitor);
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
        Set<FAccessExp> FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value = getLeft().findCommonAccessExpsInTree(visitor);
        return FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3035
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3035")
    public boolean assignedInAllBranches(FAbstractVariable var) {
        boolean assignedInAllBranches_FAbstractVariable_value = assignedInAllBranchesVariables().contains(var.name());
        return assignedInAllBranches_FAbstractVariable_value;
    }
    /** @apilevel internal */
    private void assignedInAllBranchesVariables_reset() {
        assignedInAllBranchesVariables_computed = false;
        
        assignedInAllBranchesVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean assignedInAllBranchesVariables_computed = false;

    /** @apilevel internal */
    protected Set<String> assignedInAllBranchesVariables_value;

    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3038
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3038")
    public Set<String> assignedInAllBranchesVariables() {
        ASTState state = state();
        if (assignedInAllBranchesVariables_computed) {
            return assignedInAllBranchesVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        assignedInAllBranchesVariables_value = assignedInAllBranchesVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        assignedInAllBranchesVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return assignedInAllBranchesVariables_value;
    }
    /** @apilevel internal */
    private Set<String> assignedInAllBranchesVariables_compute() {
            Set<String> res = new HashSet<String>();
            getLeft().assignedInAllBranchesVariables(res);
            getRight().assignedInAllBranchesVariables(res);
            return res;
        }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3198
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3198")
    public FExp nominal() {
        {
                FExp nom = getLeft().dynamicFExp(FExp.nominalMax(getLeft(), getRight()));
                if (nom.variability().knownParameterOrLess()) {
                    try {
                        CValue val = nom.ceval();
                        if (val.hasBuildLiteral()) {
                            nom = getLeft().dynamicFExp(val.buildLiteral());
                        }
                    } catch (ConstantEvaluationException e) {}
                }
                return nom;
            }
    }
    /**
     * @attribute syn
     * @aspect ExpressionGeneralisation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionGeneralisation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4409")
    public boolean isNegated() {
        boolean isNegated_value = getLeft().isNegated() ^ getRight().isNegated();
        return isNegated_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:263")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = getRight().type().typePromotion(getLeft().type());
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:289
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:289")
    public boolean isReal(boolean exclusive) {
        boolean isReal_boolean_value = type().isReal();
        return isReal_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = isWhen() ? Variability.DISCRETE : getLeft().variability().combine(getRight().variability());
        return variability_value;
    }
    /**
     * If this is an assignment equation, return the variable assigned.
     * 
     * Only works in flat tree.
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:396
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:396")
    public FAbstractVariable assignedFV() {
        FAbstractVariable assignedFV_value = getLeft().assignedFV();
        return assignedFV_value;
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
        assignedSet_value = getLeft().accessedVarSet();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:579
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:579")
    public boolean isAssignmentEqn() {
        boolean isAssignmentEqn_value = getLeft().isAccess();
        return isAssignmentEqn_value;
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:775
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:775")
    public FAbstractVariable isPrePropagationEquation() {
        {
                FAbstractVariable left = getLeft().isAccess() ? getLeft().asCommonAccess().asFAccess().myFV() : null;
                FAbstractVariable right = getRight().isAccess() ? getRight().asCommonAccess().asFAccess().myFV() : null;
                return left == right ? left : null;
            }
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1567
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1567")
    public boolean isZeroFlowForm() {
        { 
                FExp l = getLeft().stripNegations();
                FExp r = getRight().stripNegations();
                return l.isZeroFlowForm(r) || r.isZeroFlowForm(l);
            }
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1577
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1577")
    public boolean isConstantZeroFlow() {
        { 
                FExp l = getLeft().stripNegations();
                FExp r = getRight().stripNegations();
                
                if (l.isZeroLiteral() && r.isSemiLinear()) {
                    return ((FSemiLinearExp) r).getX().isZeroLiteral();
                }
                if (r.isZeroLiteral() && l.isSemiLinear()) {
                    return ((FSemiLinearExp) l).getX().isZeroLiteral();
                }
                
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1592
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1592")
    public FAccessExp zeroFlowGetLeft() {
        {
                FExp l = getLeft().stripNegations();
                FExp r = getRight().stripNegations();
                return (l.isSemiLinear() ? r : l).asFAccessExp();
            }
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1598
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1598")
    public FSemiLinearExp zeroFlowGetRight() {
        {
                FExp l = getLeft().stripNegations();
                FExp r = getRight().stripNegations();
                return (FSemiLinearExp) (l.isSemiLinear() ? l : r);
            }
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1603
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1603")
    public FExp zeroFlowGetX() {
        FExp zeroFlowGetX_value = zeroFlowGetRight().getX().stripNegations();
        return zeroFlowGetX_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1604
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1604")
    public FExp zeroFlowGetPos() {
        FExp zeroFlowGetPos_value = zeroFlowGetRight().getX().isNegated() ? zeroFlowGetRight().getNegSlope() : zeroFlowGetRight().getPosSlope();
        return zeroFlowGetPos_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1605
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1605")
    public FExp zeroFlowGetNeg() {
        FExp zeroFlowGetNeg_value = zeroFlowGetRight().getX().isNegated() ? zeroFlowGetRight().getPosSlope() : zeroFlowGetRight().getNegSlope();
        return zeroFlowGetNeg_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1607
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1607")
    public boolean zeroFlowNegated() {
        boolean zeroFlowNegated_value = isNegated() ^ zeroFlowGetRight().getX().isNegated();
        return zeroFlowNegated_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1609
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1609")
    public String zeroFlowGetKey() {
        {
                StringBuilder sb = new StringBuilder();
                if (zeroFlowNegated())
                    sb.append("-");
                sb.append(zeroFlowGetLeft().prettyPrint(""));
                sb.append("$");
                sb.append(zeroFlowGetX().prettyPrint(""));
                return sb.toString();
            }
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:101
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:101")
    public boolean potentialAliasEquation() {
        boolean potentialAliasEquation_value = aliasVariables(false) != null;
        return potentialAliasEquation_value;
    }
    /** @apilevel internal */
    private void isAliasEquation_reset() {
        isAliasEquation_computed = false;
    }
    /** @apilevel internal */
    protected boolean isAliasEquation_computed = false;

    /** @apilevel internal */
    protected boolean isAliasEquation_value;

    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:188")
    public boolean isAliasEquation() {
        ASTState state = state();
        if (isAliasEquation_computed) {
            return isAliasEquation_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isAliasEquation_value = aliasClassified? classifiedAsAlias: aliasVariables()!=null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isAliasEquation_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isAliasEquation_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:551
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:551")
    public boolean isOkInlineTemporaries() {
        boolean isOkInlineTemporaries_value = getRight().isOkInlineTemporaries();
        return isOkInlineTemporaries_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:987
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:987")
    public boolean isSameVariableEquality() {
        boolean isSameVariableEquality_value = getLeft().isAccess() && getRight().isAccess()
                    && getLeft().asFAccessExp().myFV() == getRight().asFAccessExp().myFV()
                    && !getLeft().asFAccessExp().myFV().isUnknown();
        return isSameVariableEquality_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1038
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeRewriting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1038")
    public boolean isDerivativeBindingEquation() {
        {
                if (!getRight().isAccess() || !getLeft().isAccess())
                    return false;
                if (!inEquationSection())
                    return false;
                boolean rightIsDer = getRight().isAbstractDerAccess();
                boolean leftIsDer = getLeft().isAbstractDerAccess();
                return rightIsDer && !leftIsDer || !rightIsDer && leftIsDer;
            }
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
        boolean generatesEvents_value = getLeft().generatesEvents() || getRight().generatesEvents();
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
        {
            	if (isWhen()) {
            		return false;
            	}
            	return getLeft().hasInlinableFunctions(fi) || getRight().hasInlinableFunctions(fi);
            }
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:376
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:376")
    public Map<String, Integer> coefficientMap() {
        {
                Map<String, Integer> coefficientMap = new LinkedHashMap<>();
        
                for (FExp exp : linearTerms()) {
                    String coeffKey = exp.myCoeffKey();
                    int val = exp.coeff();
                    if (val != 0 || !coeffKey.equals(FLitExp.COEFF_KEY)) {
                        int newValue = val + (coefficientMap.containsKey(coeffKey) ? coefficientMap.get(coeffKey) : 0);
                        coefficientMap.put(coeffKey, newValue);
                    }
                }
                return coefficientMap;
            }
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:393
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:393")
    public java.util.List<FExp> linearTerms() {
        {
                ArrayList<FExp> linearTerms = new ArrayList<FExp>();
                linearTerms.addAll(referencedCommonAccessExps());
                linearTerms.addAll(timeExps());
                for (FExp exp : terms()) {
                    if (exp.isLiteralExp()) {
                        linearTerms.add(exp);
                    }
                }
                return linearTerms;
            }
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:463
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:463")
    public boolean isSimpleLinear() {
        boolean isSimpleLinear_value = !containsActiveAnnotations() && !isSimpleAlias() && type().isNumeric() &&
                    getLeft().isSimpleLinearExp() && getRight().isSimpleLinearExp();
        return isSimpleLinear_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:483
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:483")
    public boolean isSimpleAlias() {
        boolean isSimpleAlias_value = getLeft().isSimpleAlias() && getRight().isSimpleAlias();
        return isSimpleAlias_value;
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
        boolean canPropagate_FClass_VariabilityPropagator_value = super.canPropagate(propagator) && propagator.canPropagate(this);
        return canPropagate_FClass_VariabilityPropagator_value;
    }
    /**
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:91
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:91")
    public boolean canPropagate(FVariable var, FExp solution) {
        boolean canPropagate_FVariable_FExp_value = true;
        return canPropagate_FVariable_FExp_value;
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
                    return Arrays.asList(dynamicFAbstractEquation(new FEquation(getLeft().diff(name), getRight().diff(name))));
                } catch (ExpressionDifferentiationException e) {
                    throw new EquationDifferentiationException(this, e.toQuotedString() + " in equation:\n   " + this);
                }
            }
    }
    /**
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1290
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1290")
    public FExp asSubExp() {
        FExp asSubExp_value = getLeft().dynamicFExp(new FSubExp(getLeft().fullCopy(), getRight().fullCopy()));
        return asSubExp_value;
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
        CValue OIS_ceval_VariableEvaluator_FVariable_value = solution(var).ceval(evaluator);
        return OIS_ceval_VariableEvaluator_FVariable_value;
    }
    /**
     * Used for evaluation of equations during analyse of overdetermined
     * initial system.
     * Tries to validate the equation and ensuring that the left hand side is
     * equal to the right hand side.
     * @attribute syn
     * @aspect OverdeterminedInitialSystem
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\OverdeterminedInitialSystem.jrag:188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverdeterminedInitialSystem", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\OverdeterminedInitialSystem.jrag:188")
    public boolean OIS_consistencyCheck(VariableEvaluator evaluator, StepLogger stepLogger) {
        {
                try {
                    stepLogger.logVerbose("  Right:");
                    CValue right = getRight().ceval(evaluator);
                    stepLogger.logVerbose("    Calculated value: %s", right);
                    stepLogger.logVerbose("  Left:");
                    CValue left = getLeft().ceval(evaluator);
                    stepLogger.logVerbose("    Calculated value: %s", left);
                    CValue equ = type().equ(left, right);
                    return equ.hasBooleanValue() && equ.booleanValue();
                } catch (ConstantEvaluationException e) {
                    return false;
                }
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
        		boolean solvable = !(solution(var, duringTearing) instanceof FNoExp);
        		if (solvable)
        			return Solvability.ANALYTICALLY_SOLVABLE;
        		else if (duringTearing && canUseLocalIteration())
        			return Solvability.NUMERICALLY_SOLVABLE;
        		else
        			return Solvability.UNSOLVABLE;
        	}
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:102")
    public FExp solution(FVariable var) {
        {
        		return solution(var, false);
        	}
    }
    /** @apilevel internal */
    private void solution_FVariable_boolean_reset() {
        solution_FVariable_boolean_values = null;
        solution_FVariable_boolean_proxy = null;
    }
    /** @apilevel internal */
    protected ASTNode solution_FVariable_boolean_proxy;
    /** @apilevel internal */
    protected java.util.Map solution_FVariable_boolean_values;

    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:106")
    public FExp solution(FVariable var, boolean duringTearing) {
        java.util.List _parameters = new java.util.ArrayList(2);
        _parameters.add(var);
        _parameters.add(duringTearing);
        if (solution_FVariable_boolean_values == null) solution_FVariable_boolean_values = new java.util.HashMap(4);
        ASTState state = state();
        if (solution_FVariable_boolean_values.containsKey(_parameters)) {
            return (FExp) solution_FVariable_boolean_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FExp solution_FVariable_boolean_value = solution_compute(var, duringTearing);
        if (solution_FVariable_boolean_proxy == null) {
            solution_FVariable_boolean_proxy = new ASTNode();
            solution_FVariable_boolean_proxy.is$Final = true;
            solution_FVariable_boolean_proxy.setParent(this);
        }
        if (solution_FVariable_boolean_value != null) {
            solution_FVariable_boolean_proxy.addChild(solution_FVariable_boolean_value);
            // Proxy child access is used to trigger rewrite of NTA value.
            solution_FVariable_boolean_value = (FExp) solution_FVariable_boolean_proxy.getChild(solution_FVariable_boolean_proxy.numChildren - 1);
            solution_FVariable_boolean_value.is$Final = true;
        }
        if (true) {
        solution_FVariable_boolean_values.put(_parameters, solution_FVariable_boolean_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return solution_FVariable_boolean_value;
    }
    /** @apilevel internal */
    private FExp solution_compute(FVariable var, boolean duringTearing) {
            try {
                // Get terms
                ArrayList<FExp> t = terms();
                
                ArrayList<FExp> activeTerms = new ArrayList<FExp>();
                ArrayList<FExp> inactiveTerms = new ArrayList<FExp>();
                //Find terms
                for (FExp e : t) {
                    if (e.nbrUses(var.name())==1) {
                        activeTerms.add(e);
                    } else if (e.nbrUses(var.name())==0) {
                        inactiveTerms.add(e);
                    } else {
                        return new FNoExp();
                    }
                }
                
                // Compute new expressions for the inactive and active terms
                FExp inactiveTerm = computeInactiveSolution(inactiveTerms);
                FExp activeTerm = computeActiveSolution(activeTerms, var,
                        duringTearing && !myOptions().getBooleanOption("divide_by_vars_in_tearing") ||
                        inactiveTerm.isLiteralZero(), duringTearing ? myOptions().getRealOption("tearing_division_tolerance") : 0);
                
                if (activeTerm.isNoExp()) {
                    return new FNoExp();
                }
                if (inactiveTerm.isLiteralZero() || activeTerm.isLiteralOne()) {
                    return inactiveTerm;
                }
                return new FDivExp(inactiveTerm, activeTerm);
            } catch (ModelicaException e) {
                throw e;
            } catch (Exception e) {
                throw new org.jmodelica.util.exceptions.InternalCompilerError("Exception caught while solving equation '" + prettyPrint("") + "' for variable '" + var.name() + "'", e);
            }
        }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:227")
    public ArrayList<FExp> terms() {
        {
                ArrayList<FExp> t = new ArrayList<FExp>();
                t.addAll(getLeft().terms());
                t.addAll(getRight().terms());
                return t;
            }
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:328
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:328")
    public int nbrUses(String name) {
        {
        		return getLeft().nbrUses(name) + getRight().nbrUses(name);
        	}
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:240
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:240")
    public FExp assignmentExp() {
        FExp assignmentExp_value = isAssignmentEqn() ? getRight() : null;
        return assignmentExp_value;
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:243
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:243")
    public FExp createResidualExp() {
        {
                FExp lhs = getLeft();
                FExp rhs = getRight();
                
                if (lhs.isZeroLiteral()) {
                    return rhs.fullCopy();
                }
                if (rhs.isZeroLiteral()) {
                    return lhs.fullCopy();
                }
                return new FSubExp(lhs.fullCopy(), rhs.fullCopy());
            }
    }
    /**
     * Test if this should be the binding expression of an independent parameter instead.
     * @attribute syn
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:253
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterSorting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:253")
    public boolean isIndependentParameterEquation() {
        boolean isIndependentParameterEquation_value = getLeft().isFlatParameterUse() && getRight().isIndependentParameterExp();
        return isIndependentParameterEquation_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Equation";
        return xmlTag_value;
    }
    /**
     * Helper method which returns true if the right hand side is an sample
     * operator.
     * @attribute syn
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:224
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenBlocks", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:224")
    public boolean isSampleEquation() {
        boolean isSampleEquation_value = getRight().isFSampleExp();
        return isSampleEquation_value;
    }
    /** @return An empty MX 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230")
    public MX toMXForLhs() {
        MX toMXForLhs_value = getLeft().toMX();
        return toMXForLhs_value;
    }
    /** @return An empty MX 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:232
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:232")
    public MX toMXForRhs() {
        MX toMXForRhs_value = getRight().toMX();
        return toMXForRhs_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     * @apilevel internal
     */
    public Set<FVariable> Define_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getRightNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2262
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     */
    public boolean Define_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3360
            return true;
        }
        else {
            return super.Define_isLeftHandSide(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLeftHandSide
     */
    protected boolean canDefine_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1530
     * @apilevel internal
     */
    public boolean Define_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1532
            return getRight().isConstructorCall();
        }
        else {
            return super.Define_isConstructorAssign(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1530
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorAssign
     */
    protected boolean canDefine_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629
     * @apilevel internal
     */
    public FAccessExp Define_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getRightNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:631
            return getLeft().getEquationLeftInlineUse();
        }
        else {
            return super.Define_inlineUsesFunctionCallLeft(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inlineUsesFunctionCallLeft
     */
    protected boolean canDefine_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:416
     * @apilevel internal
     */
    public int Define_outerCoeff(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getRightNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:418
            return -1;
        }
        else {
            return super.Define_outerCoeff(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:416
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute outerCoeff
     */
    protected boolean canDefine_outerCoeff(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:291
     * @apilevel internal
     */
    public boolean Define_isNegativeTerm(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:295
            return false;
        }
        else if (_callerNode == getRightNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:294
            return true;
        }
        else {
            return getParent().Define_isNegativeTerm(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:291
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isNegativeTerm
     */
    protected boolean canDefine_isNegativeTerm(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:299
     * @apilevel internal
     */
    public boolean Define_isInvertedFactor(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:299
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInvertedFactor
     */
    protected boolean canDefine_isInvertedFactor(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
