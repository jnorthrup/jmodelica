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
 * A flattened algorithm clause.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:592
 * @astdecl FAlgorithm : FAbstractEquation ::= FStatement*;
 * @production FAlgorithm : {@link FAbstractEquation} ::= <span class="component">{@link FStatement}*</span>;

 */
public class FAlgorithm extends FAbstractEquation implements Cloneable, WriteBackContext, TempScope {
    /**
     * Constructs an algorithm block that is not initial.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:178
     */
    public FAlgorithm(List<FStatement> stmts) {
        this(EquationType.NORMAL, new List<FAttribute>(), new Opt<FStringComment>(), stmts);
    }
    /**
     * Constructs an algorithm block.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:185
     */
    public FAlgorithm(EquationType type, List<FStatement> stmts) {
        this(type, new List<FAttribute>(), new Opt<FStringComment>(), stmts);
    }
    /**
     * Find LHS variables which are definetly assigned to before any use.
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2608
     */
    public Set<FVariable> defSet() {
        HashSet<FVariable> fvSet = new HashSet<FVariable>();
        HashSet<FVariable> fvUse = new HashSet<FVariable>();
        for (FStatement stmt : getFStatements()) {
            stmt.defSet(fvSet, fvUse);
        }
        return fvSet;
    }
    /**
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4255
     */
    private String functionName = null;
    /**
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4256
     */
    public String generateFunctionName() {
        if (functionName == null)
            functionName = myFClass().generateFunctionName();
        return functionName;
    }
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:299
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent) {
		str.print(indent);
		str.print("algorithm<br>\n");
		getFStatements().prettyPrintWithIndent(p, str, p.indent(indent), ";<br>");
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1423
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(indent);
		str.println("algorithm");
		getFStatements().prettyPrintWithIndent(p, str, p.indent(indent), ";");
	}
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:202
     */
    public FExternalStmt getFExternalStmt() {
        for (FStatement stmt : getFStatements())
            if (stmt instanceof FExternalStmt)
                return (FExternalStmt) stmt;
        return null;
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:55
     */
    public void contentCheck(ErrorCheckType checkType) {}
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:127
     */
    @Override
    public void flattenEqn(Flattener f, List<FAbstractEquation> l) {
        List l2 = new List();
        FStatement.flattenFStatementList(f, getFStatements(), l2);
        l.add(new FAlgorithm(l2));
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:161
     */
    public void collectFunctionCalls(FClass.commonSubexpressionEliminationIfSet m) {
        
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:399
     */
    public void variabilityPropagation(FClass.VariabilityPropagator propagator) {
        TypePrefixVariability variability = variabilityRHS();
        if (propagator.moveEquation(variability, this)) {
            for (FVariable fv : referencedFVariablesInLHS()) {
                fv.variabilityPropagation(propagator, variability, null);
            }
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:993
     */
    @Override
    public void scalarize(Scalarizer.Equation s) {
		List<FStatement> stmts = new List<FStatement>();
        FStatement.scalarizeStmtList(s.algorithm(stmts), getFStatements());
        s.add(new FAlgorithm(stmts));
	}
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:372
     */
    @Override
	public SimpleEquationBlock createSimpleEquationBlock(Collection<FVariable> fvs, Collection<Integer> assignedIndices, Solvability solvability, EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) { 
		for (Integer assignedIndex : assignedIndices)
			if (assignedIndex == null)
				throw new IllegalArgumentException("FAlgorithm, AssignedIndex must be set for this class type! equation: " + this);
		if (solvability.isAnalyticallySolvable()) {
			return new SolvedAlgorithmBlock(producer, blockDependency, this, fvs, assignedIndices);
		} else {
			return new UnsolvedAlgorithmBlock(producer, blockDependency, this, fvs, assignedIndices);
		}
	}
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:415
     */
    @Override
    public SimpleEquationBlock createMetaEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
        return new MetaEquationBlock(producer, blockDependency, this);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:2140
     */
    @Override
    public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>>
    AbstractBiPGraph<E, V ,C>.IncidenceMap createIncidenceMap(AbstractBiPGraph<E, V, C> g, EnumSet<AbstractBiPGraph.VarType> variableTypes,
            AbstractBiPGraph.VariableResolver<E, V> resolver) {
        return g.new ManyIncidenceMap(this, resolver, variableTypes);
    }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:658
     */
    @Override
    public void acceptTransform(EquationTransformer tf)          { tf.visit(this); }
    /**
     * Transforms this {@link FAlgorithm} using an {@link AlgorithmTransformer}.
     * 
     * @param tf
     * The transformer to transform {@code this} with.
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:688
     */
    public void acceptTransform(AlgorithmTransformer tf)      { tf.visit(this); }
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:78
     */
    @Override
    protected FAbstractEquation convertWhenEqnToIfEqn(Collection<FAbstractEquation> outerEqnList, FClass fclass) {
        Collection<FStatement> newStmts = new ArrayList<FStatement>();
        for (FStatement stmt : getFStatements()) {
            newStmts.add(stmt.convertWhenStmtToIfStmt(outerEqnList, newStmts, fclass));
        }
        setFStatementList(new List<FStatement>(newStmts));
        return this;
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:298
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		open_XML(str, indent);
		p.print(getFStatements(), str, p.indent(indent));
		close_XML(str, indent);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:102
     */
    @Override
    public void printDecl_C(CodePrinter p, CodeStream str, String indent, Set<ASTNode> visited, Collection<FVariable> forVariables, boolean solved) {
        boolean first = visited == null || visited.add(this);
        if (first) {
            p.printVarDecls(this, str, indent);
            if (!solved || (forVariables != null && forVariables.size() != uniqueFAccessExpsInLHS().size())) {
                for (FAccessExp use : uniqueFAccessExpsInLHS()) {
                    if (!solved || !forVariables.contains(use.myFV()) || !use.myFV().isReal()) {
                        p.printTempInputDecl(use.myFV(), this, str, indent);
                    }
                }
            }
        }
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:147
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (!inFunction()) {
            // Print initialization stmts for variables which might not be set before use
            Set<FVariable> defSet = defSet();
            for (FVariable fv : referencedFVariablesInLHS()) {
                if (!defSet.contains(fv)) {
                    p.printInputInit(str, indent, fv);
                }
            }
        }
        // Print the algorithm
        p.print(getFStatements(), str, indent);
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:69
     */
    @Override
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        boolean firstVisit = visited == null || !visited.contains(this);
        boolean sideEffect = forVariables == null || forVariables.size() == uniqueFAccessExpsInLHS().size();
        genBlockEval_C(p, str, indent, visited, forVariables, forIndices);
        if (!sideEffect && (!firstVisit || !forVariables.iterator().next().isReal())) {
            for (FAccessExp use : uniqueFAccessExpsInLHS())
                p.printWriteBackAssignment(str, indent, use.myFV(), this, forVariables);
        }
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:81
     */
    @Override
    public void genBlockEval_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {
        boolean firstVisit = visited == null || visited.add(this);
        boolean sideEffect = forVariables == null || forVariables.size() == uniqueFAccessExpsInLHS().size();
        if (firstVisit) {
            if (sideEffect) {
                p.print(this, str, indent);
            } else {
                prettyPrintNoSideEffect_C(p, str, indent, forVariables);
            }
        }
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:102
     */
    @Override
    public void genResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices) {
        if (visited == null || visited.add(this)) {
            p.printPreSteps(this, str, indent);
            prettyPrintNoSideEffect_C(p, str, indent, null);
            p.printPostSteps(this, str, indent);
        }
        Enumerator indexCounter = new Enumerator();
        for (FAccessExp use : uniqueFAccessExpsInLHS()) {
            p.printWriteBackResidual(str, indent, use.myFV(), this, enumerator, forIndices, indexCounter);
        }
    }
    /**
     * Helper for genBlock_C and genResidual_C
     * Prints the algorithm, statements which restore LHS variables,
     * and statements which put the new values in temporaries.
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:120
     */
    public void prettyPrintNoSideEffect_C(CodePrinter p, CodeStream str, String indent, Collection<FVariable> forVariables) {
        Collection<FAccessExp> lhs = uniqueFAccessExpsInLHS();
        for (FAccessExp use : lhs) {
            if (forVariables == null || !forVariables.contains(use.myFV()) || !use.myFV().isReal()) {
                p.printTempInputAssigns(str, indent, this, use.myFV());
            }
        }
        p.print(this, str, indent);
        for (FAccessExp use : lhs) {
            if (forVariables == null || !forVariables.contains(use.myFV()) || !use.myFV().isReal()) {
                p.printTempSwap(use.myFV(), this, str, indent);
            }
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:598
     */
    public void genAssignedRef(FAbstractVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        str.print(p.name(v));
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:625
     */
    public void genScaledAssignedRef(FAbstractVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        if (v.needsScaling(this)) {
            str.print("(");
            genAssignedRef(v, p, str, indent);
            str.print("*sf(");
            str.print(v.valueReference());
            str.print("))");
        } else {
            genAssignedRef(v, p, str, indent);
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAlgorithm() {
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
        name = {"Type", "FAttribute", "FStringComment", "FStatement"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>", "List<FStatement>"},
        kind = {"Token", "List", "Opt", "List"}
    )
    public FAlgorithm(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2, List<FStatement> p3) {
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
        numScalarEquations_reset();
        getInitialEquationList_reset();
        referencedFVariablesInLHS_reset();
        tempName_C_FAbstractVariable_reset();
        tempName_C_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        contributorMap_FStatement_eventGenExps = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public FAlgorithm clone() throws CloneNotSupportedException {
        FAlgorithm node = (FAlgorithm) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:58
     */
    public FAlgorithm copy() {
        try {
            FAlgorithm node = (FAlgorithm) clone();
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
    public FAlgorithm fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public FAlgorithm treeCopyNoTransform() {
        FAlgorithm tree = (FAlgorithm) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 3:
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
    public FAlgorithm treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:117
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenEquationType_Type == ((FAlgorithm) node).tokenEquationType_Type);    
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
     * Replaces the FStatement list.
     * @param list The new list node to be used as the FStatement list.
     * @apilevel high-level
     */
    public void setFStatementList(List<FStatement> list) {
        setChild(list, 2);
    }
    /**
     * Retrieves the number of children in the FStatement list.
     * @return Number of children in the FStatement list.
     * @apilevel high-level
     */
    public int getNumFStatement() {
        return getFStatementList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FStatement list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FStatement list.
     * @apilevel low-level
     */
    public int getNumFStatementNoTransform() {
        return getFStatementListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FStatement list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FStatement list.
     * @apilevel high-level
     */
    public FStatement getFStatement(int i) {
        return (FStatement) getFStatementList().getChild(i);
    }
    /**
     * Check whether the FStatement list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFStatement() {
        return getFStatementList().getNumChild() != 0;
    }
    /**
     * Append an element to the FStatement list.
     * @param node The element to append to the FStatement list.
     * @apilevel high-level
     */
    public void addFStatement(FStatement node) {
        List<FStatement> list = (parent == null) ? getFStatementListNoTransform() : getFStatementList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFStatementNoTransform(FStatement node) {
        List<FStatement> list = getFStatementListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FStatement list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFStatement(FStatement node, int i) {
        List<FStatement> list = getFStatementList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FStatement list.
     * @return The node representing the FStatement list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FStatement")
    public List<FStatement> getFStatementList() {
        List<FStatement> list = (List<FStatement>) getChild(2);
        return list;
    }
    /**
     * Retrieves the FStatement list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FStatement list.
     * @apilevel low-level
     */
    public List<FStatement> getFStatementListNoTransform() {
        return (List<FStatement>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the FStatement list without
     * triggering rewrites.
     */
    public FStatement getFStatementNoTransform(int i) {
        return (FStatement) getFStatementListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FStatement list.
     * @return The node representing the FStatement list.
     * @apilevel high-level
     */
    public List<FStatement> getFStatements() {
        return getFStatementList();
    }
    /**
     * Retrieves the FStatement list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FStatement list.
     * @apilevel low-level
     */
    public List<FStatement> getFStatementsNoTransform() {
        return getFStatementListNoTransform();
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
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:73
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FStatement_eventGenExps = null;

    /** @apilevel internal */
    protected void survey_FStatement_eventGenExps() {
        if (contributorMap_FStatement_eventGenExps == null) {
            contributorMap_FStatement_eventGenExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FStatement_eventGenExps(this, contributorMap_FStatement_eventGenExps);
        }
    }

    /** @apilevel internal */
    private void numScalarEquations_reset() {
        numScalarEquations_computed = false;
    }
    /** @apilevel internal */
    protected boolean numScalarEquations_computed = false;

    /** @apilevel internal */
    protected int numScalarEquations_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1884
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1884")
    public int numScalarEquations() {
        ASTState state = state();
        if (numScalarEquations_computed) {
            return numScalarEquations_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        numScalarEquations_value = numScalarEquations_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        numScalarEquations_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return numScalarEquations_value;
    }
    /** @apilevel internal */
    private int numScalarEquations_compute() {
            Set<FVariable> assignedVars = new HashSet<FVariable>();
            for (FAccessExp use : FAccessExpsInLHS()) {
                if (!use.myFV().isUnknown() && !assignedVars.contains(use.myFV())) {
                    FVariable fv = (FVariable) use.myFV();
                    assignedVars.add(fv);
                }
            }
            return assignedVars.size();
    
        }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2438
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2438")
    public boolean replacedAtInitialization() {
        {
                if (super.replacedAtInitialization())
                    return true;
                
                /* 
                 * Even if there are no when statements, there might still be discrete 
                 * variables which are dependent on their pre() variables 
                 */
                Set<FVariable> notDefSet = referencedFVariablesInLHS();
                notDefSet.removeAll(defSet());
                for (FVariable fv : notDefSet)
                    if (fv.isDiscrete())
                        return true;
                return false;
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
            ArrayList<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            
            // Keeps FAccessExps in lhs which have not been removed
            Set<FAccessExp> usesLHS = FAccessExpsInLHS();
            
            // Keeps track of which variables are definetly set
            Set<FVariable> fvSet  = new HashSet<FVariable>();
            Set<FVariable> fvUse  = new HashSet<FVariable>();
            
            // Create a new algorithm with some statements removed
            ArrayList<FStatement> stmts = new ArrayList<FStatement>();
            for (FStatement stmt : getFStatements()) {
                stmt.addAsInitial(stmts, usesLHS, fvSet, fvUse);
            }
            
            Set<FVariable> lhs = lookupFVariablesInSet(usesLHS);
    
            // Add initial statements for variables which are not definetly set
            // in the new algorithm
            ArrayList<FStatement> initStmts = new ArrayList<FStatement>();
            for (FVariable fv : lhs)
                if (!fvSet.contains(fv))
                    initStmts.add(new FAssignStmt(fv.createAccessExp(), fv.createAlgorithmArgument(true)));
            for (FStatement stmt : stmts)
                initStmts.add(stmt);
            if (initStmts.size() > 0)
                l.add(new FAlgorithm(new List<FStatement>(initStmts)));
            
            // Create equations for variables which are no longer assigned 
            // in the new algorithm
            Set<FVariable> removedFVs = referencedFVariablesInLHS();
            removedFVs.removeAll(lhs);
            for (FVariable fv : removedFVs)
                l.add(new FEquation(fv.createAccessExp(), fv.createFPreExp()));
            
            return new List<FAbstractEquation>(l);
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
                for (FStatement stmt : getFStatements())
                    res.addAll(stmt.FAccessExpsInRHS(visitor));
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
                for (FStatement stmt : getFStatements())
                    res.addAll(stmt.FAccessExpsInLHS(visitor));
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3003
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3003")
    public Set<FVariable> variableDependenciesRHS() {
        {
                Set<FVariable> lhs = referencedFVariablesInLHS();
                Set<FVariable> rhs = referencedFVariablesInRHS();
                Set<FVariable> res = new LinkedHashSet<FVariable>();
                for (FVariable fv : rhs) {
                    if (!lhs.contains(fv)) {
                        res.add(fv);
                    }
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void referencedFVariablesInLHS_reset() {
        referencedFVariablesInLHS_computed = false;
        
        referencedFVariablesInLHS_value = null;
    }
    /** @apilevel internal */
    protected boolean referencedFVariablesInLHS_computed = false;

    /** @apilevel internal */
    protected Set<FVariable> referencedFVariablesInLHS_value;

    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3019
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3019")
    public Set<FVariable> referencedFVariablesInLHS() {
        ASTState state = state();
        if (referencedFVariablesInLHS_computed) {
            return referencedFVariablesInLHS_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        referencedFVariablesInLHS_value = super.referencedFVariablesInLHS();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        referencedFVariablesInLHS_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return referencedFVariablesInLHS_value;
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
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:195")
    public TypePrefixVariability variability() {
        {
                TypePrefixVariability variability = Variability.CONSTANT;
                for (FAbstractVariable variable : referencedFVariablesInLHS()) {
                    variability = variability.combine(variable.variability());
                }
                return variability;
            }
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:230")
    public TypePrefixVariability variabilityRHS() {
        {
                TypePrefixVariability variability = Variability.CONSTANT;
                for (FVariable variable : variableDependenciesRHS()) {
                    variability = variability.combine(variable.variability());
                }
                for (FExp exp : timeExps()) {
                    variability = variability.combine(exp.variability());
                }
                return variability;
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
        boolean generatesEvents_value = relExpInEquation().size() + delayExpInEquation().size() > 0;
        return generatesEvents_value;
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
        boolean canPropagate_FClass_VariabilityPropagator_value = propagator.propagateAlgorithms() &&
                    super.canPropagate(propagator) && propagator.variables(this).size() > 0 &&
                    propagator.variables(this).size() == numScalarEquations() && variabilityRHS().parameterOrLess();
        return canPropagate_FClass_VariabilityPropagator_value;
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:954
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:954")
    public FAlgorithm diff() {
        {
                List<FStatement> diffed = new List<FStatement>();
                for (FStatement statement : getFStatements())
                    statement.diff(diffed);
                return new FDerivativeAlgorithm(diffed, order() + 1);
            }
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1056
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1056")
    public int order() {
        int order_value = 0;
        return order_value;
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
        		
        		if (inLeft)
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
        String xmlTag_value = "Algorithm";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = "fun";
        return xmlNamespace_value;
    }
    /** @apilevel internal */
    private void tempName_C_FAbstractVariable_reset() {
        tempName_C_FAbstractVariable_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map tempName_C_FAbstractVariable_values;

    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:41
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:41")
    public String tempName_C(FAbstractVariable v) {
        Object _parameters = v;
        if (tempName_C_FAbstractVariable_values == null) tempName_C_FAbstractVariable_values = new java.util.HashMap(4);
        ASTState state = state();
        if (tempName_C_FAbstractVariable_values.containsKey(_parameters)) {
            return (String) tempName_C_FAbstractVariable_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        String tempName_C_FAbstractVariable_value = nextTempName_C();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        tempName_C_FAbstractVariable_values.put(_parameters, tempName_C_FAbstractVariable_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return tempName_C_FAbstractVariable_value;
    }
    /** @apilevel internal */
    private void tempName_C_reset() {
        tempName_C_computed = false;
        
        tempName_C_value = null;
    }
    /** @apilevel internal */
    protected boolean tempName_C_computed = false;

    /** @apilevel internal */
    protected String tempName_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:44")
    public String tempName_C() {
        ASTState state = state();
        if (tempName_C_computed) {
            return tempName_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        tempName_C_value = nextTempName_C();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        tempName_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return tempName_C_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2321")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4228
     * @apilevel internal
     */
    public FAlgorithm Define_myFAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4228
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFAlgorithm
     */
    protected boolean canDefine_myFAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     */
    public boolean Define_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute useIsAssignment
     */
    protected boolean canDefine_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     * @apilevel internal
     */
    public boolean Define_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return !inFunction();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAlgorithm
     */
    protected boolean canDefine_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1466
     * @apilevel internal
     */
    public boolean Define_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1466
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute insideBlockStmt
     */
    protected boolean canDefine_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1474
     * @apilevel internal
     */
    public boolean Define_insideBranchedStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1474
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute insideBranchedStmt
     */
    protected boolean canDefine_insideBranchedStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:86
     * @apilevel internal
     */
    public boolean Define_inWhile(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:86
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhile
     */
    protected boolean canDefine_inWhile(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:930
     * @apilevel internal
     */
    public FStatement Define_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:930
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingLoop
     */
    protected boolean canDefine_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1256
     * @apilevel internal
     */
    public boolean Define_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1256
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inForLoop
     */
    protected boolean canDefine_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     * @apilevel internal
     */
    public boolean Define_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:566
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute needsIndicatorInit
     */
    protected boolean canDefine_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_algorithms(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1840
        if (!inFunction()) {
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
        super.collect_contributors_FClass_algorithms(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_myAlgorithms(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4237
        if (!inFunction()) {
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
        super.collect_contributors_FClass_myAlgorithms(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_algorithms(ArrayList<FAlgorithm> collection) {
        super.contributeTo_FClass_algorithms(collection);
        if (!inFunction()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myAlgorithms(ArrayList<FAlgorithm> collection) {
        super.contributeTo_FClass_myAlgorithms(collection);
        if (!inFunction()) {
            collection.add(this);
        }
    }
}
