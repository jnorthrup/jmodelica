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
 * Base class for flattened equations.
 * 
 * The NTA InitialEquation is used to represent default initial equations for
 * when equations that are not active during initialization.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:460
 * @astdecl FAbstractEquation : BaseNode ::= <Type:EquationType> InitialEquation:FAbstractEquation* FAttribute* [FStringComment];
 * @production FAbstractEquation : {@link BaseNode} ::= <span class="component">&lt;Type:EquationType&gt;</span> <span class="component">InitialEquation:{@link FAbstractEquation}*</span> <span class="component">{@link FAttribute}*</span> <span class="component">[{@link FStringComment}]</span>;

 */
public abstract class FAbstractEquation extends BaseNode implements Cloneable, FDiagnosticsNode, LockBranch, FAttributeListAnnotationNode.FAttributeList {
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1946
     */
    protected static int numForElems(List<? extends CommonForIndex> list) {
        int res = 1;
        for (CommonForIndex i : list)
            res *= i.size().numElements();
        return res;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1953
     */
    protected static int numScalarEqnsInList(List<FAbstractEquation> list) {
        int res = 0;
        for (FAbstractEquation e : list) 
            res += e.numScalarEquations();
        return res;
    }
    /**
     * Returns an iterable that can be used to iterate over all surounding
     * equations (including this one).
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2359
     */
    public Iterable<FAbstractEquation> enclosingEquationsIterator() {
        return new Iterable<FAbstractEquation>() {

            @Override
            public Iterator<FAbstractEquation> iterator() {
                return new Iterator<FAbstractEquation>() {

                    private FAbstractEquation next = FAbstractEquation.this;
                    
                    @Override
                    public boolean hasNext() {
                        return next != null;
                    }

                    @Override
                    public FAbstractEquation next() {
                        FAbstractEquation res = next;
                        next = next.enclosingEquation();
                        return res;
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                    
                };
            }
            
        };
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2765
     */
    @Deprecated
    private FAbstractEquation meDifferentiated = null;
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2768
     */
    @Deprecated
    private FAbstractEquation meIntegrated = null;
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2771
     */
    @Deprecated
    public void setMeDifferentiated(FAbstractEquation e) {
        this.meDifferentiated = e;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2776
     */
    @Deprecated
    public FAbstractEquation getMeDifferentiated() {
        return this.meDifferentiated;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2781
     */
    @Deprecated
    public void setMeIntegrated(FAbstractEquation e) {
        this.meIntegrated = e;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2786
     */
    @Deprecated
    public FAbstractEquation getMeIntegrated() {
        return this.meIntegrated;
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:21
     */
    public FlatAnnotation flatAnnotation(String ... path) { return FlatAnnotation.createFor(this, path); }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:201
     */
    public void addToParameterEquationsMap(
            Map<FAbstractVariable,FAbstractEquation> map) {
        for (FVariable fv : referencedFVariablesInLHS()) {
            fv.addToParameterEquationsMap(map, this);
        }
    }
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:286
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent){
		super.htmlSourcePrettyPrint(p, str, indent);
		str.print(";<br>\n");
	}
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:222
     */
    public static boolean containsConnect(List<FAbstractEquation> eqns) {
		for (FAbstractEquation eqn : eqns)
			if (eqn.containsConnect())
				return true;
		return false;
	}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:50
     */
    public void contentCheck(ErrorCheckType checkType) {
		if (inFunction()) 
			error("Equations are not allowed in functions");
	}
    /**
     * Check if this equation may legally contain a connect clause.
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:420
     */
    public void checkMayContainConnect(ErrorCheckType checkType, FConnectClause connect) {
        FAbstractEquation context = surroundingFAbstractEquation();
        if (context != null) {
            context.checkMayContainConnect(checkType, connect);
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:534
     */
    protected static Set<InstComponentDecl> assignedSetFromEqns(List<FAbstractEquation> eqns) {
        Set<InstComponentDecl> res = new HashSet<InstComponentDecl>();
        for (FAbstractEquation eqn : eqns)
            res.addAll(eqn.assignedSet());
        return res;
    }
    /**
     * Try to evaluate asserts with constant tests in this equation.
     * 
     * If this equation should be removed, returns true.
     * @aspect AssertEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1615
     */
    public boolean evaluateAsserts(boolean inClause) {
        return false;
    }
    /**
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1737
     */
    public void collectReinits(Map<FAbstractVariable,Set<FReinit>> map) {}
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:19
     */
    public void flatten(Flattener f) {
        List<FAbstractEquation> l = getType().isInitial() ? f.getInitialEquations() : f.getNormalEquations();
        flattenEqn(f, l);
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:24
     */
    public static void flattenEqnList(Flattener f, List<FAbstractEquation> l,
            List<FAbstractEquation> eqs) {
        for (FAbstractEquation fae : eqs) {
            fae.flattenEqn(f, l);
        }
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:31
     */
    public void flattenAttrs(Flattener f, FAbstractEquation eqn) {
        List<FAttribute> flatAttrs = new List<FAttribute>();
        for (FAttribute attr : getFAttributes())
            flatAttrs.add(attr.flatten(f));
        eqn.setFAttributeList(flatAttrs);
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:38
     */
    public abstract void flattenEqn(Flattener f, List<FAbstractEquation> l);
    /**
     * Dynamically places an FAbstractEquation in the tree under this FAbstractEquation.
     * 
     * @return  the final version of the dynamically placed node.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:919
     */
    public FAbstractEquation dynamicFAbstractEquation(FAbstractEquation eqn) {
        if (eqn == this)
            return eqn;
        getDynamicFAbstractEquationOpt().setChild(eqn, 0);
        return (FAbstractEquation) getDynamicFAbstractEquationOpt().getChild(0);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:102
     */
    public void sanityCheckParameterEquations(FClass fc) {}
    /**
     * Mark all variables reinited in this equation as states.
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1673
     */
    public void makeReinitedVarsStates() {}
    /**
     * @aspect LocalIteration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:83
     */
    protected void typeCheckLocalIteration(ErrorCheckType checkType) {
        AnnotationNode node = annotation().vendorNode().forPath("LocalIteration");
        if (!node.exists())
            return;
        AnnotationNode enabledNode = node.forPath("enabled");
        if (enabledNode.exists()) {
            FExp enabledExp = enabledNode.fExp();
            typeCheckEnabled(checkType, enabledExp, type(), enabledNode.isEach());
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:75
     */
    public AliasPair aliasVariables() {
		return null;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:79
     */
    public boolean aliasClassified = false;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:80
     */
    public boolean classifiedAsAlias = false;
    /**
     * Flag for removing equation.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:641
     */
    public boolean markedForRemoval = false;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:643
     */
    public void markForRemoval() {
        markedForRemoval = true;
    }
    /**
     * Remove all contained equations with <code>markedForRemoval == true</code>. 
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:727
     */
    public void removeMarkedEqns() {}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:919
     */
    public void insertTempsInLHS(FClass fClass, boolean param) {}
    /**
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1005
     */
    public void propagateDerivativeBindings() {
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:77
     */
    public void findBlockFunctionExtraction(AbstractEquationBlock block, ArrayList<FFunctionCall> functions) {

    }
    /**
     * Inline all calls to functions that we can inline.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:814
     */
    public Collection<FAbstractEquation> inlineFunctions(AbstractFunctionInliner fi) {
        return Collections.singletonList((FAbstractEquation)this);
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:224
     */
    public void addEquationsToWorkList(Set<FAbstractEquation> wl) {
        wl.add(this);
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:289
     */
    public void variabilityPropagation(FClass.VariabilityPropagator propagator) {
        
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:659
     */
    public TypePrefixVariability taggedByVProp = Variability.CONTINUOUS;
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:661
     */
    public void cleanEquations(ArrayList<FAbstractEquation> l, TypePrefixVariability v) {
        if (v.lessOrEqual(taggedByVProp)) {
            l.add(this);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:363
     */
    public static void scalarizeList(Scalarizer.Equation s, List<FAbstractEquation> fromList) {
        for (FAbstractEquation ae : fromList) {
            ae.scalarize(s);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:949
     */
    public List<FAttribute> scalarizeAttributeList(Index i, Scalarizer s) {
        List<FAttribute> scalarized = new List<FAttribute>();
        for (FAttribute a : getFAttributes()) 
            a.scalarize(scalarized, i, s);
        return scalarized;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:956
     */
    public void scalarize(Scalarizer.Equation s) {}
    /**
     * Create a simple equation block from a single equation. 
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:356
     */
    public SimpleEquationBlock createSimpleEquationBlock(Collection<FVariable> fvs, Collection<Integer> assignedIndices, Solvability solvability, EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
		throw new UnsupportedOperationException("Unable to construct equation block from equation type " + getClass().getSimpleName());
	}
    /**
     * Create a meta equation block from a single equation. 
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:411
     */
    public SimpleEquationBlock createMetaEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
        throw new UnsupportedOperationException("Unable to construct meta equation block from equation type " + getClass().getSimpleName());
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:87
     */
    public static List<FAbstractEquation> diffList(String name, List<FAbstractEquation> equations) {
        List<FAbstractEquation> res = new List<FAbstractEquation>();
        for (FAbstractEquation equation : equations) {
            res.addAll(equation.diff(name));
        }
        return res;
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:2127
     */
    public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>>
    AbstractBiPGraph<E, V, C>.IncidenceMap createIncidenceMap(AbstractBiPGraph<E, V, C> g, EnumSet<AbstractBiPGraph.VarType> variableTypes) {
        return createIncidenceMap(g, variableTypes, g.defaultVariableResolver());
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:2133
     */
    public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>>
    AbstractBiPGraph<E, V, C>.IncidenceMap createIncidenceMap(AbstractBiPGraph<E, V, C> g, EnumSet<AbstractBiPGraph.VarType> variableTypes,
            AbstractBiPGraph.VariableResolver<E, V> resolver) {
        return g.new IncidenceMap(this, resolver);
    }
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:655
     */
    public <V> AbstractBiPGraph.AssignmentIncidenceMap assignmentIncidenceMap(AbstractBiPGraph g, EnumSet<AbstractBiPGraph.VarType> variableTypes, AbstractBiPGraph.VariableResolver resolver) {
        throw new UnsupportedOperationException("FAbstractEquation.assignmentIncidenceMap() isn't implemented for equations of type " + getClass().getSimpleName() + "!");
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:446
     */
    public FAbstractEquation copySymbolic() { return (FAbstractEquation) super.copySymbolic(); }
    /**
     * Transforms this {@link FAbstractEquation} using an {@link EquationTransformer}.
     * 
     * @param tf
     * The transformer to transform {@code this} with.
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:656
     */
    public void acceptTransform(EquationTransformer tf)   { tf.visit(this); }
    /**
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:73
     */
    public void eliminateIfEquations(List<FAbstractEquation> equations) { 
        equations.add(this);
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:155
     */
    public void rewriteIfEquations(List<FAbstractEquation> equations) {
        equations.add(this);
    }
    /**
     * Parent method for removal of empty else clauses.
     * <p>
     * Do nothing if the equation is not an {@link FIfWhenElseEquation}, {@link FForClauseE}, or {@link FElseEquation}.
     * 
     * @param equations
     * The equation list in which to put the resulting equations. In the default case,
     * an equation adds itself.
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:354
     */
    public void removeEmptyElse(List<FAbstractEquation> equations) {
        equations.add(this);
    }
    /**
     * Index of equation during equation sorting.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:22
     */
    public int sortingIndex = -1;
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:25
     */
    
		public static class SortingIndexComparator implements Comparator<FAbstractEquation> {
			public int compare(FAbstractEquation o1, FAbstractEquation o2) {
				return o1.sortingIndex - o2.sortingIndex;
			}
		}
    /**
     * Creates a TreeSet that can hold FAbstractEquations, sorted by their sortingIndex.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:43
     */
    public static TreeSet<FAbstractEquation> sortingSet() {
		return new TreeSet<FAbstractEquation>(new SortingIndexComparator());
	}
    /**
     * Remove binding expression of variables assigned in this equation.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:216
     */
    public void removeBindingExpOfAssignedVars() {}
    /**
     * Convert this parameter equation to a binding expression.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:267
     */
    public void revertToBindingExp() {}
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:35
     */
    protected FAbstractEquation convertWhenEqnToIfEqn(Collection<FAbstractEquation> outerNewList, FClass fclass) {
        return this;
    }
    /**
     * Flag for whether or not this if clause/expression 
     * originates from a when clause.
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:125
     */
    private boolean isWhen = false;
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:134
     */
    public void setWhen() { isWhen = true; }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:343
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        ASTNode attributeList = getFAttributeList();
        for (ASTNode node : this)
            if (node != attributeList)
                node.genVarDecls_C(p, str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:388
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        ASTNode attributeList = getFAttributeList();
        for (ASTNode node : this)
            if (node != attributeList)
                p.printPreSteps(node, str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:396
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        ASTNode attributeList = getFAttributeList();
        for (ASTNode node : this)
            if (node != attributeList)
                p.printPostSteps(node, str, indent);
    }
    /**
     * Generates code for dependent parameter assignments
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:466
     */
    public void genAssignment_C(CodePrinter p, CodeStream str, String indent) {
        genBlock_C(p, str, indent, null, null, null);
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:891
     */
    public FExp equationNominal_C(boolean auto) {
        return auto ? nominal() : null;
    }
    /**
     * Generate block code for equations
     * 
     * @param visited      Keeps track of visited equations
     * @param forVariables Variables that should get a writeback
     * @param forIndices   Indices of equations that should get a writeback
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:25
     */
    public void genBlock_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {}
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:28
     */
    public void genBlockEval_C(CodePrinter p, CodeStream str, String indent, Set<FAbstractEquation> visited,
            Collection<FVariable> forVariables, Collection<Integer> forIndices) {}
    /**
     * Generate residual code for equations
     * 
     * @param enumerator Enumerates residuals
     * @param visited    Keeps track of visited equations
     * @param forIndices Indices of equations that should get a residual
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:51
     */
    public void genResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices) {}
    /**
     * Helper, used for finding reinits
     * @aspect CCodeGenGlobalsReinit
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:233
     */
    public void collectReinits_C(CodePrinter p, Collection<FReinit> res) {}
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:659
     */
    public boolean isIgnoredForCasADi() { return false; }
    /**
     * @declaredat ASTNode:1
     */
    public FAbstractEquation() {
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
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(List.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "FAttribute", "FStringComment"},
        type = {"EquationType", "List<FAttribute>", "Opt<FStringComment>"},
        kind = {"Token", "List", "Opt"}
    )
    public FAbstractEquation(EquationType p0, List<FAttribute> p1, Opt<FStringComment> p2) {
        setType(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        size_reset();
        containsFTimeExp_reset();
        containsFHomotopyExp_reset();
        getInitialEquationList_reset();
        referencedCommonAccessExps_reset();
        referencedFVariables_reset();
        inputs_reset();
        realInputs_reset();
        algebraicContinousRealVariables_reset();
        discreteRealVariables_reset();
        discreteIntegerVariables_reset();
        discreteBooleanVariables_reset();
        discreteStringVariables_reset();
        discreteEnumVariables_reset();
        variables_reset();
        type_reset();
        assignedSet_reset();
        getDynamicFAbstractEquationOpt_reset();
        isAliasEquation_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:60
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        FAbstractEquation_transformedGuards_computed = false;
        
        FAbstractEquation_transformedGuards_value = null;
        FAbstractEquation_relExpInEquation_computed = false;
        
        FAbstractEquation_relExpInEquation_value = null;
        FAbstractEquation_delayExpInEquation_computed = false;
        
        FAbstractEquation_delayExpInEquation_value = null;
        FAbstractEquation_relExpInInitialEquation_computed = false;
        
        FAbstractEquation_relExpInInitialEquation_value = null;
        FAbstractEquation_eventGenExps_computed = false;
        
        FAbstractEquation_eventGenExps_value = null;
        FAbstractEquation_replacedAtInitialExps_computed = false;
        
        FAbstractEquation_replacedAtInitialExps_value = null;
        FAbstractEquation_retrieveInputs_computed = false;
        
        FAbstractEquation_retrieveInputs_value = null;
        FAbstractEquation_algebraicVariables_computed = false;
        
        FAbstractEquation_algebraicVariables_value = null;
        FAbstractEquation_derivativeVariables_computed = false;
        
        FAbstractEquation_derivativeVariables_value = null;
        FAbstractEquation_differentiatedRealVariables_computed = false;
        
        FAbstractEquation_differentiatedRealVariables_value = null;
        FAbstractEquation_dependentParameters_computed = false;
        
        FAbstractEquation_dependentParameters_value = null;
        FAbstractEquation_parameters_computed = false;
        
        FAbstractEquation_parameters_value = null;
        FAbstractEquation_discreteVariables_computed = false;
        
        FAbstractEquation_discreteVariables_value = null;
        FAbstractEquation_initialParameters_computed = false;
        
        FAbstractEquation_initialParameters_value = null;
        FAbstractEquation_discretePreVariables_computed = false;
        
        FAbstractEquation_discretePreVariables_value = null;
        FAbstractEquation_timeExps_computed = false;
        
        FAbstractEquation_timeExps_value = null;
        contributorMap_FAbstractEquation_transformedGuards = null;
        contributorMap_FAbstractEquation_relExpInEquation = null;
        contributorMap_FAbstractEquation_delayExpInEquation = null;
        contributorMap_FAbstractEquation_relExpInInitialEquation = null;
        contributorMap_FAbstractEquation_replacedAtInitialExps = null;
        contributorMap_FAbstractEquation_retrieveInputs = null;
        contributorMap_FAbstractEquation_algebraicVariables = null;
        contributorMap_FAbstractEquation_derivativeVariables = null;
        contributorMap_FAbstractEquation_differentiatedRealVariables = null;
        contributorMap_FAbstractEquation_dependentParameters = null;
        contributorMap_FAbstractEquation_parameters = null;
        contributorMap_FAbstractEquation_discreteVariables = null;
        contributorMap_FAbstractEquation_initialParameters = null;
        contributorMap_FAbstractEquation_discretePreVariables = null;
        contributorMap_FAbstractEquation_timeExps = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:127
     */
    public FAbstractEquation clone() throws CloneNotSupportedException {
        FAbstractEquation node = (FAbstractEquation) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:138
     */
    @Deprecated
    public abstract FAbstractEquation fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:146
     */
    public abstract FAbstractEquation treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:154
     */
    public abstract FAbstractEquation treeCopy();
    /**
     * Replaces the lexeme Type.
     * @param value The new value for the lexeme Type.
     * @apilevel high-level
     */
    public void setType(EquationType value) {
        tokenEquationType_Type = value;
    }
    /** @apilevel internal 
     */
    protected EquationType tokenEquationType_Type;
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
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInitialEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getInitialEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
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
            setChild(new List(node), 2);
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
        return 2;
    }
    /**
     * Retrieves the InitialEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InitialEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getInitialEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(2);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2050
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_transformedGuards = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_transformedGuards() {
        if (contributorMap_FAbstractEquation_transformedGuards == null) {
            contributorMap_FAbstractEquation_transformedGuards = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_transformedGuards(this, contributorMap_FAbstractEquation_transformedGuards);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2155
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_relExpInEquation = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_relExpInEquation() {
        if (contributorMap_FAbstractEquation_relExpInEquation == null) {
            contributorMap_FAbstractEquation_relExpInEquation = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_relExpInEquation(this, contributorMap_FAbstractEquation_relExpInEquation);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2165
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_delayExpInEquation = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_delayExpInEquation() {
        if (contributorMap_FAbstractEquation_delayExpInEquation == null) {
            contributorMap_FAbstractEquation_delayExpInEquation = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_delayExpInEquation(this, contributorMap_FAbstractEquation_delayExpInEquation);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2212
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_relExpInInitialEquation = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_relExpInInitialEquation() {
        if (contributorMap_FAbstractEquation_relExpInInitialEquation == null) {
            contributorMap_FAbstractEquation_relExpInInitialEquation = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_relExpInInitialEquation(this, contributorMap_FAbstractEquation_relExpInInitialEquation);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2431
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_replacedAtInitialExps = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_replacedAtInitialExps() {
        if (contributorMap_FAbstractEquation_replacedAtInitialExps == null) {
            contributorMap_FAbstractEquation_replacedAtInitialExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_replacedAtInitialExps(this, contributorMap_FAbstractEquation_replacedAtInitialExps);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3426
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_retrieveInputs = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_retrieveInputs() {
        if (contributorMap_FAbstractEquation_retrieveInputs == null) {
            contributorMap_FAbstractEquation_retrieveInputs = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_retrieveInputs(this, contributorMap_FAbstractEquation_retrieveInputs);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3460
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_algebraicVariables = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_algebraicVariables() {
        if (contributorMap_FAbstractEquation_algebraicVariables == null) {
            contributorMap_FAbstractEquation_algebraicVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_algebraicVariables(this, contributorMap_FAbstractEquation_algebraicVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3501
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_derivativeVariables = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_derivativeVariables() {
        if (contributorMap_FAbstractEquation_derivativeVariables == null) {
            contributorMap_FAbstractEquation_derivativeVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_derivativeVariables(this, contributorMap_FAbstractEquation_derivativeVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3511
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_differentiatedRealVariables = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_differentiatedRealVariables() {
        if (contributorMap_FAbstractEquation_differentiatedRealVariables == null) {
            contributorMap_FAbstractEquation_differentiatedRealVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_differentiatedRealVariables(this, contributorMap_FAbstractEquation_differentiatedRealVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3521
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_dependentParameters = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_dependentParameters() {
        if (contributorMap_FAbstractEquation_dependentParameters == null) {
            contributorMap_FAbstractEquation_dependentParameters = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_dependentParameters(this, contributorMap_FAbstractEquation_dependentParameters);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3531
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_parameters = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_parameters() {
        if (contributorMap_FAbstractEquation_parameters == null) {
            contributorMap_FAbstractEquation_parameters = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_parameters(this, contributorMap_FAbstractEquation_parameters);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3541
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_discreteVariables = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_discreteVariables() {
        if (contributorMap_FAbstractEquation_discreteVariables == null) {
            contributorMap_FAbstractEquation_discreteVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_discreteVariables(this, contributorMap_FAbstractEquation_discreteVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3551
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_initialParameters = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_initialParameters() {
        if (contributorMap_FAbstractEquation_initialParameters == null) {
            contributorMap_FAbstractEquation_initialParameters = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_initialParameters(this, contributorMap_FAbstractEquation_initialParameters);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3561
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_discretePreVariables = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_discretePreVariables() {
        if (contributorMap_FAbstractEquation_discretePreVariables == null) {
            contributorMap_FAbstractEquation_discretePreVariables = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_discretePreVariables(this, contributorMap_FAbstractEquation_discretePreVariables);
        }
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:241
     */
    /** @apilevel internal */
protected java.util.Map<ASTNode, java.util.Set<ASTNode>> contributorMap_FAbstractEquation_timeExps = null;

    /** @apilevel internal */
    protected void survey_FAbstractEquation_timeExps() {
        if (contributorMap_FAbstractEquation_timeExps == null) {
            contributorMap_FAbstractEquation_timeExps = new java.util.IdentityHashMap<ASTNode, java.util.Set<ASTNode>>();
            collect_contributors_FAbstractEquation_timeExps(this, contributorMap_FAbstractEquation_timeExps);
        }
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
        int ndims_value = -1;
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
        size_value = Size.SCALAR;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:599")
    public Size totalSize() {
        Size totalSize_value = size().expand(parentTotalSize());
        return totalSize_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:612
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:612")
    public FArraySubscripts expandedSubscripts() {
        {
                List<FSubscript> list = parentExpandedSubscripts();
        		Size size = size();
        		for (int i = 0; i < size.ndims(); i++) {
        			list.add(size.createExpandedFSubscript(i));
        		}
        		return FArraySubscripts.createFArraySubscripts(list);
        	}
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
        CValue cevalParameter_VariableEvaluator_FVariable_value = CValue.UNKNOWN;
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
        CValue cevalParameter_VariableEvaluator_FVariable_Index_value = CValue.UNKNOWN;
        return cevalParameter_VariableEvaluator_FVariable_Index_value;
    }
    /** @apilevel internal */
    private void containsFTimeExp_reset() {
        containsFTimeExp_computed = false;
    }
    /** @apilevel internal */
    protected boolean containsFTimeExp_computed = false;

    /** @apilevel internal */
    protected boolean containsFTimeExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1611
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1611")
    public boolean containsFTimeExp() {
        ASTState state = state();
        if (containsFTimeExp_computed) {
            return containsFTimeExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        containsFTimeExp_value = super.containsFTimeExp();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        containsFTimeExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return containsFTimeExp_value;
    }
    /** @apilevel internal */
    private void containsFHomotopyExp_reset() {
        containsFHomotopyExp_computed = false;
    }
    /** @apilevel internal */
    protected boolean containsFHomotopyExp_computed = false;

    /** @apilevel internal */
    protected boolean containsFHomotopyExp_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1620
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1620")
    public boolean containsFHomotopyExp() {
        ASTState state = state();
        if (containsFHomotopyExp_computed) {
            return containsFHomotopyExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        containsFHomotopyExp_value = super.containsFHomotopyExp();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        containsFHomotopyExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return containsFHomotopyExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1881")
    public int numScalarEquations() {
        int numScalarEquations_value = 1;
        return numScalarEquations_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1907
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1907")
    public boolean isMetaEquation() {
        boolean isMetaEquation_value = numScalarEquations() == 0;
        return isMetaEquation_value;
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
        boolean isZeroEquation_value = false;
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
        Set<FVariable> boundParameters_value = Collections.emptySet();
        return boundParameters_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2274
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2274")
    public Set<FVariable> RHSVariables() {
        Set<FVariable> RHSVariables_value = Collections.emptySet();
        return RHSVariables_value;
    }
    /**
     * Returns the outermost enclosing equation or the equation itself if it is
     * the outermost.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2345")
    public FAbstractEquation outermostEnclosingEquation() {
        {
                FAbstractEquation enclosing = this;
                FAbstractEquation next = enclosingEquation();
                while (next != null) {
                    enclosing = next;
                    next = enclosing.enclosingEquation();
                }
                return enclosing;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2438
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2438")
    public boolean replacedAtInitialization() {
        boolean replacedAtInitialization_value = isWhen() || replacedAtInitialExps().size() > 0;
        return replacedAtInitialization_value;
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
            List<FAbstractEquation> l = new List<FAbstractEquation>();
            if (replacedAtInitialization()) {
                l.add((FAbstractEquation) copySymbolic());
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2886
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2886")
    public Set<FAccessExp> FAccessExpsInRHS() {
        Set<FAccessExp> FAccessExpsInRHS_value = FAccessExpsInRHS(DefaultFAccessExpLookupVisitor.instance);
        return FAccessExpsInRHS_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2888")
    public Set<FAccessExp> FAccessExpsInRHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        Set<FAccessExp> FAccessExpsInRHS_CommonAccessExpLookupVisitor_FAccessExp__value = Collections.emptySet();
        return FAccessExpsInRHS_CommonAccessExpLookupVisitor_FAccessExp__value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2927
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2927")
    public Set<FAccessExp> FAccessExpsInLHS() {
        Set<FAccessExp> FAccessExpsInLHS_value = FAccessExpsInLHS(DefaultFAccessExpLookupVisitor.instance);
        return FAccessExpsInLHS_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2929")
    public Set<FAccessExp> FAccessExpsInLHS(CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        Set<FAccessExp> FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value = Collections.emptySet();
        return FAccessExpsInLHS_CommonAccessExpLookupVisitor_FAccessExp__value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2963
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2963")
    public ArrayList<FAccessExp> uniqueFAccessExpsInLHS() {
        {
                ArrayList<FAccessExp>   res   = new ArrayList<>();
                Set<FAbstractVariable> visit = new LinkedHashSet<FAbstractVariable>();
                for (FAccessExp e : FAccessExpsInLHS()) {
                    FAbstractVariable fv = e.myFV();
                    if (!visit.contains(fv)) {
                        visit.add(fv);
                        res.add(e);
                    }
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void referencedCommonAccessExps_reset() {
        referencedCommonAccessExps_computed = false;
        
        referencedCommonAccessExps_value = null;
    }
    /** @apilevel internal */
    protected boolean referencedCommonAccessExps_computed = false;

    /** @apilevel internal */
    protected Set<FAccessExp> referencedCommonAccessExps_value;

    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2976
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2976")
    public Set<FAccessExp> referencedCommonAccessExps() {
        ASTState state = state();
        if (referencedCommonAccessExps_computed) {
            return referencedCommonAccessExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        referencedCommonAccessExps_value = referencedCommonAccessExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        referencedCommonAccessExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return referencedCommonAccessExps_value;
    }
    /** @apilevel internal */
    private Set<FAccessExp> referencedCommonAccessExps_compute() {
            Set<FAccessExp> res = new LinkedHashSet<>();
            res.addAll(FAccessExpsInLHS());
            res.addAll(FAccessExpsInRHS());
            return res;
        }
    /***
     * DANGER! Use this method and its results with caution. It will probably
     * not work before saclarization but should be safe afterwards!
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2987
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2987")
    public Set<String> referencedVariablesAsStrings() {
        {
                Set<FAccessExp> exps = new LinkedHashSet<FAccessExp>();
                Set<String> res = new LinkedHashSet<String>();
                for (FAccessExp exp : exps) {
                    res.add(exp.name());
                }
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
        Set<FVariable> variableDependenciesRHS_value = referencedFVariablesInRHS();
        return variableDependenciesRHS_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3016
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3016")
    public Set<FVariable> referencedFVariablesInRHS() {
        Set<FVariable> referencedFVariablesInRHS_value = lookupFVariablesInSet(FAccessExpsInRHS());
        return referencedFVariablesInRHS_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3017
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3017")
    public Set<FVariable> referencedFVariablesInLHS() {
        Set<FVariable> referencedFVariablesInLHS_value = lookupFVariablesInSet(FAccessExpsInLHS());
        return referencedFVariablesInLHS_value;
    }
    /** @apilevel internal */
    private void referencedFVariables_reset() {
        referencedFVariables_computed = false;
        
        referencedFVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean referencedFVariables_computed = false;

    /** @apilevel internal */
    protected Set<FVariable> referencedFVariables_value;

    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3022
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3022")
    public Set<FVariable> referencedFVariables() {
        ASTState state = state();
        if (referencedFVariables_computed) {
            return referencedFVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        referencedFVariables_value = lookupFVariablesInSet(referencedCommonAccessExps());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        referencedFVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return referencedFVariables_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3035
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3035")
    public boolean assignedInAllBranches(FAbstractVariable var) {
        boolean assignedInAllBranches_FAbstractVariable_value = true;
        return assignedInAllBranches_FAbstractVariable_value;
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
                FExp nom = FExp.nominalDefault();
                nom.setParent(this);
                return nom;
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
        inputs_value = retrieveInputs();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        inputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return inputs_value;
    }
    /** @apilevel internal */
    private void realInputs_reset() {
        realInputs_computed = false;
        
        realInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean realInputs_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> realInputs_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3452
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3452")
    public LinkedHashSet<FVariable> realInputs() {
        ASTState state = state();
        if (realInputs_computed) {
            return realInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        realInputs_value = new LinkedHashSet<FVariable>(FClass.filterCollection(inputs(), FClass.REAL_VARIABLE_FILTER));
        if (isFinal && _boundaries == state().boundariesCrossed) {
        realInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return realInputs_value;
    }
    /** @apilevel internal */
    private void algebraicContinousRealVariables_reset() {
        algebraicContinousRealVariables_computed = false;
        
        algebraicContinousRealVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean algebraicContinousRealVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> algebraicContinousRealVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3478
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3478")
    public LinkedHashSet<FVariable> algebraicContinousRealVariables() {
        ASTState state = state();
        if (algebraicContinousRealVariables_computed) {
            return algebraicContinousRealVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        algebraicContinousRealVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().normalAlgebraicContinousRealVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        algebraicContinousRealVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return algebraicContinousRealVariables_value;
    }
    /** @apilevel internal */
    private void discreteRealVariables_reset() {
        discreteRealVariables_computed = false;
        
        discreteRealVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discreteRealVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> discreteRealVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3481
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3481")
    public LinkedHashSet<FVariable> discreteRealVariables() {
        ASTState state = state();
        if (discreteRealVariables_computed) {
            return discreteRealVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discreteRealVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().discreteRealVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discreteRealVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discreteRealVariables_value;
    }
    /** @apilevel internal */
    private void discreteIntegerVariables_reset() {
        discreteIntegerVariables_computed = false;
        
        discreteIntegerVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discreteIntegerVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> discreteIntegerVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3484
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3484")
    public LinkedHashSet<FVariable> discreteIntegerVariables() {
        ASTState state = state();
        if (discreteIntegerVariables_computed) {
            return discreteIntegerVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discreteIntegerVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().discreteIntegerVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discreteIntegerVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discreteIntegerVariables_value;
    }
    /** @apilevel internal */
    private void discreteBooleanVariables_reset() {
        discreteBooleanVariables_computed = false;
        
        discreteBooleanVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discreteBooleanVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> discreteBooleanVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3487
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3487")
    public LinkedHashSet<FVariable> discreteBooleanVariables() {
        ASTState state = state();
        if (discreteBooleanVariables_computed) {
            return discreteBooleanVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discreteBooleanVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().discreteBooleanVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discreteBooleanVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discreteBooleanVariables_value;
    }
    /** @apilevel internal */
    private void discreteStringVariables_reset() {
        discreteStringVariables_computed = false;
        
        discreteStringVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discreteStringVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> discreteStringVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3490
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3490")
    public LinkedHashSet<FVariable> discreteStringVariables() {
        ASTState state = state();
        if (discreteStringVariables_computed) {
            return discreteStringVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discreteStringVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().discreteStringVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discreteStringVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discreteStringVariables_value;
    }
    /** @apilevel internal */
    private void discreteEnumVariables_reset() {
        discreteEnumVariables_computed = false;
        
        discreteEnumVariables_value = null;
    }
    /** @apilevel internal */
    protected boolean discreteEnumVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> discreteEnumVariables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3493
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3493")
    public LinkedHashSet<FVariable> discreteEnumVariables() {
        ASTState state = state();
        if (discreteEnumVariables_computed) {
            return discreteEnumVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        discreteEnumVariables_value = FClass.intersectFVSet(algebraicVariables(), myFClass().discreteStringVariables());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        discreteEnumVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return discreteEnumVariables_value;
    }
    /** @apilevel internal */
    private void variables_reset() {
        variables_computed = false;
        
        variables_value = null;
    }
    /** @apilevel internal */
    protected boolean variables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> variables_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3567
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3567")
    public LinkedHashSet<FVariable> variables() {
        ASTState state = state();
        if (variables_computed) {
            return variables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        variables_value = variables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        variables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return variables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> variables_compute() {
            LinkedHashSet<FVariable> l = new LinkedHashSet<FVariable>();
            l.addAll(differentiatedRealVariables());
            l.addAll(derivativeVariables());
            l.addAll(algebraicVariables());
            l.addAll(discreteVariables());
            return l;
        }
    /**
     * Returns all variables known to this equation that are part of the
     * equation system, e.g. variables in the attributes isn't included in this
     * list.
     * <p>
     * Word of causion, this method is used for debug output right now and I
     * got a feeling that it might return the same variable twice! So test well
     * if you're going to use it "for real".
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3585
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3585")
    public Iterable<FVariable> allVariables() {
        {
                return new ChainedIterable<FVariable>(variables(), discretePreVariables(), parameters());
            }
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3677")
    public boolean checkLinearity(Set<FVariable> vars) {
        {
                for (FAccessExp e : referencedCommonAccessExps()) {
                    if (vars.contains(e.myFV()) && !e.isLinear(vars)) {
                        return false;
                    }
                }
                return true;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3882
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatDiagnostics", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3882")
    public int numScalars() {
        int numScalars_value = numScalarEquations();
        return numScalars_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:63
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:63")
    public FAttribute findAttribute(String name) {
        FAttribute findAttribute_String_value = findMatching(getFAttributes(), name);
        return findAttribute_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1030
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1030")
    public boolean ignoreInFlattening() {
        boolean ignoreInFlattening_value = false;
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
        boolean isIgnored_value = false;
        return isIgnored_value;
    }
    /**
     * Check if this FAbstractEquation contains any active annotation attributes.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1991
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1991")
    public boolean containsActiveAnnotations() {
        {
                if (getNumFAttribute() == 0)
                    return false;
                for (AttributeContributer contributer : attributeContributers())
                    if (contributer.containsActiveAttributes(this))
                        return true;
                return false;
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
        type_value = fUnknownType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * True if this equation exclusively equates real types.
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:275
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:275")
    public boolean isReal() {
        boolean isReal_value = isReal(true);
        return isReal_value;
    }
    /**
     * True if this equation exclusively equates non-real types.
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:280
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:280")
    public boolean isNonReal() {
        boolean isNonReal_value = !isReal(false);
        return isNonReal_value;
    }
    /**
     * True if this equation equates at least one real type and one non real type.
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:285
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:285")
    public boolean isMixed() {
        {
                return !isReal(true) && isReal(false);
            }
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
                for (FVariable fv : referencedFVariablesInLHS()) {
                    boolean fvRes = fv.isReal();
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
        TypePrefixVariability variability_value = Variability.CONTINUOUS;
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:245
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:245")
    public boolean isConstant() {
        boolean isConstant_value = variability().constantVariability();
        return isConstant_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:246
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:246")
    public boolean isParameter() {
        boolean isParameter_value = variability().parameterVariability();
        return isParameter_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:247
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:247")
    public boolean isDiscrete() {
        boolean isDiscrete_value = variability().discreteVariability();
        return isDiscrete_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:248
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:248")
    public boolean isContinuous() {
        boolean isContinuous_value = variability().continuousVariability();
        return isContinuous_value;
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
        FAbstractVariable assignedFV_value = null;
        return assignedFV_value;
    }
    /**
     * @attribute syn
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:215
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComplianceCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:215")
    public boolean containsConnect() {
        boolean containsConnect_value = false;
        return containsConnect_value;
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
        assignedSet_value = Collections.emptySet();
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
        boolean isAssignmentEqn_value = false;
        return isAssignmentEqn_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:582")
    public boolean hasFunctionCallEquations() {
        boolean hasFunctionCallEquations_value = false;
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
        boolean hasFunctionCallEquationsWithLefts_value = false;
        return hasFunctionCallEquationsWithLefts_value;
    }
    /** @apilevel internal */
    private void getDynamicFAbstractEquationOpt_reset() {
        getDynamicFAbstractEquationOpt_computed = false;
        
        getDynamicFAbstractEquationOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getDynamicFAbstractEquationOpt_computed = false;

    /** @apilevel internal */
    protected Opt getDynamicFAbstractEquationOpt_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:854
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:854")
    public Opt getDynamicFAbstractEquationOpt() {
        ASTState state = state();
        if (getDynamicFAbstractEquationOpt_computed) {
            return getDynamicFAbstractEquationOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getDynamicFAbstractEquationOpt_value = new DynamicOpt();
        getDynamicFAbstractEquationOpt_value.setParent(this);
        getDynamicFAbstractEquationOpt_value.is$Final = true;
        if (true) {
        getDynamicFAbstractEquationOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getDynamicFAbstractEquationOpt_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = variability().continuousVariability();
        return shouldBeDifferentiated_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = new FAttributeListAnnotationNode(this, instContext);
        return annotation_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:775
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:775")
    public FAbstractVariable isPrePropagationEquation() {
        FAbstractVariable isPrePropagationEquation_value = null;
        return isPrePropagationEquation_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1567
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1567")
    public boolean isZeroFlowForm() {
        boolean isZeroFlowForm_value = false;
        return isZeroFlowForm_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1577
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1577")
    public boolean isConstantZeroFlow() {
        boolean isConstantZeroFlow_value = false;
        return isConstantZeroFlow_value;
    }
    /**
     * @attribute syn
     * @aspect LocalIteration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:73
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LocalIteration", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:73")
    public boolean canUseLocalIteration() {
        {
                String option = myOptions().getStringOption("local_iteration_in_tearing");
                if (option == OptionRegistry.LocalIteration.OFF)
                    return false;
                else if (option == OptionRegistry.LocalIteration.ANNOTATION)
                    return hasLocalIteration();
                else
                    return true;
            }
    }
    /**
     * @attribute syn
     * @aspect LocalIteration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:94
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LocalIteration", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:94")
    public boolean hasLocalIteration() {
        {
                AnnotationNode node = annotation().vendorNode().forPath("LocalIteration");
                if (!node.exists())
                    return false;
                AnnotationNode enabledNode = node.forPath("enabled");
                return !enabledNode.exists() || enabledNode.bool();
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
        boolean potentialAliasEquation_value = false;
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
        isAliasEquation_value = false;
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
        boolean isOkInlineTemporaries_value = false;
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
        boolean isSameVariableEquality_value = false;
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
        boolean isDerivativeBindingEquation_value = false;
        return isDerivativeBindingEquation_value;
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
        boolean generatesEvents_value = false;
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
        boolean hasInlinableFunctions_AbstractFunctionInliner_value = false;
        return hasInlinableFunctions_AbstractFunctionInliner_value;
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
                throw new UnsupportedOperationException();
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
        java.util.List<FExp> linearTerms_value = Collections.<FExp> emptyList();
        return linearTerms_value;
    }
    /**
     * @attribute syn
     * @aspect eliminateLinearEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:463
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="eliminateLinearEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:463")
    public boolean isSimpleLinear() {
        boolean isSimpleLinear_value = false;
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
        boolean isSimpleAlias_value = false;
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
        boolean canPropagate_FClass_VariabilityPropagator_value = canPropagateContext(propagator) && !containsActiveAnnotations();
        return canPropagate_FClass_VariabilityPropagator_value;
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
                throw new EquationDifferentiationException(this, "Cannot differentate the equation:\n   " + prettyPrint(""));
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
        FExp asSubExp_value = new FNoExp();
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
        CValue OIS_ceval_VariableEvaluator_FVariable_value = CValue.UNKNOWN;
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
        boolean OIS_consistencyCheck_VariableEvaluator_StepLogger_value = false;
        return OIS_consistencyCheck_VariableEvaluator_StepLogger_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:23")
    public Solvability isSolved(FVariable var) {
        Solvability isSolved_FVariable_value = isSolved(var, false);
        return isSolved_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:25
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:25")
    public Solvability isSolved(FVariable var, boolean duringTearing) {
        Solvability isSolved_FVariable_boolean_value = Solvability.UNSOLVABLE;
        return isSolved_FVariable_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:227")
    public ArrayList<FExp> terms() {
        ArrayList<FExp> terms_value = new ArrayList<FExp>();
        return terms_value;
    }
    /**
     * @attribute syn
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:240
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IfEquationRewrite", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:240")
    public FExp assignmentExp() {
        FExp assignmentExp_value = null;
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
        FExp createResidualExp_value = null;
        return createResidualExp_value;
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
        boolean isIndependentParameterEquation_value = false;
        return isIndependentParameterEquation_value;
    }
    /**
     * @attribute syn
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="WhenClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:129")
    public boolean isWhen() {
        boolean isWhen_value = isWhen;
        return isWhen_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = "equ";
        return xmlNamespace_value;
    }
    /**
     * Helper method which determines if a guard is needed for the non real
     * equation.
     * @attribute syn
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:208
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenBlocks", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:208")
    public boolean shouldProduceNonRealGuard_C(Collection<FVariable> fvs) {
        {
                if (isSampleEquation()) {
                    return false;
                }
                for (FVariable fv : fvs) {
                    if (!fv.isTemporary()) {
                        return true;
                    }
                }
                return false;
            }
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
        boolean isSampleEquation_value = false;
        return isSampleEquation_value;
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
                int n = numScalarEquations();
                ASTNode attributeList = getFAttributeList();
                for (ASTNode node : this) {
                    if (node != attributeList) {
                        n += node.numScalars_C();
                    }
                }
                return n;
            }
    }
    /** @return An empty MX 
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:230")
    public MX toMXForLhs() {
        MX toMXForLhs_value = new MX();
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
        MX toMXForRhs_value = new MX();
        return toMXForRhs_value;
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:601
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:601")
    public Size parentTotalSize() {
        Size parentTotalSize_value = getParent().Define_parentTotalSize(this, null);
        return parentTotalSize_value;
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:621
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:621")
    public List<FSubscript> parentExpandedSubscripts() {
        List<FSubscript> parentExpandedSubscripts_value = getParent().Define_parentExpandedSubscripts(this, null);
        return parentExpandedSubscripts_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2322")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2337
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2337")
    public FAbstractEquation enclosingEquation() {
        FAbstractEquation enclosingEquation_value = getParent().Define_enclosingEquation(this, null);
        return enclosingEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2414
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2414")
    public boolean isParameterEquation() {
        boolean isParameterEquation_value = getParent().Define_isParameterEquation(this, null);
        return isParameterEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418")
    public boolean isNormalEquation() {
        boolean isNormalEquation_value = getParent().Define_isNormalEquation(this, null);
        return isNormalEquation_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2424
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2424")
    public List<FAbstractEquation> myFAbstractEquationList() {
        List<FAbstractEquation> myFAbstractEquationList_value = getParent().Define_myFAbstractEquationList(this, null);
        return myFAbstractEquationList_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1771
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1771")
    public boolean inEquationSection() {
        boolean inEquationSection_value = getParent().Define_inEquationSection(this, null);
        return inEquationSection_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1776
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1776")
    public boolean inInitialEquationSection() {
        boolean inInitialEquationSection_value = getParent().Define_inInitialEquationSection(this, null);
        return inInitialEquationSection_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1813
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1813")
    public boolean inWhen() {
        boolean inWhen_value = getParent().Define_inWhen(this, null);
        return inWhen_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1828
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1828")
    public boolean isInitial() {
        boolean isInitial_value = getParent().Define_isInitial(this, null);
        return isInitial_value;
    }
    /**
     * @attribute inh
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:446")
    public FAbstractEquation surroundingFAbstractEquation() {
        FAbstractEquation surroundingFAbstractEquation_value = getParent().Define_surroundingFAbstractEquation(this, null);
        return surroundingFAbstractEquation_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:430
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:430")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:761
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:761")
    public InstNode myInstNode() {
        InstNode myInstNode_value = getParent().Define_myInstNode(this, null);
        return myInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:38")
    public boolean canPropagateContext(FClass.VariabilityPropagator propagator) {
        boolean canPropagateContext_FClass_VariabilityPropagator_value = getParent().Define_canPropagateContext(this, null, propagator);
        return canPropagateContext_FClass_VariabilityPropagator_value;
    }
    /**
     * @attribute inh
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1348")
    public FIfWhenEquation surroundingIfOrElse() {
        FIfWhenEquation surroundingIfOrElse_value = getParent().Define_surroundingIfOrElse(this, null);
        return surroundingIfOrElse_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:31
     * @apilevel internal
     */
    public boolean Define_inArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:31
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArraySubscripts
     */
    protected boolean canDefine_inArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2170
     * @apilevel internal
     */
    public FStatement Define_myFStatement(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2170
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFStatement
     */
    protected boolean canDefine_myFStatement(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2305
     * @apilevel internal
     */
    public boolean Define_inFEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2305
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFEquation
     */
    protected boolean canDefine_inFEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2309
     * @apilevel internal
     */
    public FAbstractEquation Define_myFEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2309
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFEquation
     */
    protected boolean canDefine_myFEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2337
     * @apilevel internal
     */
    public FAbstractEquation Define_enclosingEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2337
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingEquation
     */
    protected boolean canDefine_enclosingEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3472
     * @apilevel internal
     */
    public boolean Define_inAccessLocation(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAttributeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3475
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return false;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return true;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3472
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAccessLocation
     */
    protected boolean canDefine_inAccessLocation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3653
     * @apilevel internal
     */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
        return true;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4228
     * @apilevel internal
     */
    public FAlgorithm Define_myFAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1444
     * @apilevel internal
     */
    public boolean Define_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1781
     * @apilevel internal
     */
    public boolean Define_inEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1781
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inEquation
     */
    protected boolean canDefine_inEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1797
     * @apilevel internal
     */
    public boolean Define_inConnectClause(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1797
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inConnectClause
     */
    protected boolean canDefine_inConnectClause(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1804
     * @apilevel internal
     */
    public boolean Define_inIfCondition(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1415
     * @apilevel internal
     */
    public boolean Define_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInitialEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1835
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_isInitial(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1415
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInitial
     */
    protected boolean canDefine_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:445
     * @apilevel internal
     */
    public FAbstractEquation Define_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:445
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFAbstractEquation
     */
    protected boolean canDefine_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1112
     * @apilevel internal
     */
    public boolean Define_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1112
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstComponentSize
     */
    protected boolean canDefine_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942
     * @apilevel internal
     */
    public boolean Define_isElse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1942
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isElse
     */
    protected boolean canDefine_isElse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:416
     * @apilevel internal
     */
    public int Define_outerCoeff(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 1;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584
     * @apilevel internal
     */
    public boolean Define_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:584
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute hasBrancher
     */
    protected boolean canDefine_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626
     * @apilevel internal
     */
    public FExp Define_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:626
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentFExp
     */
    protected boolean canDefine_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:405
     * @apilevel internal
     */
    public boolean Define_inFunctionArg(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:405
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionArg
     */
    protected boolean canDefine_inFunctionArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2050
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2050")
    public Set<FExp> transformedGuards() {
        ASTState state = state();
        if (FAbstractEquation_transformedGuards_computed) {
            return FAbstractEquation_transformedGuards_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_transformedGuards_value = transformedGuards_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_transformedGuards_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_transformedGuards_value;
    }
    /** @apilevel internal */
    private Set<FExp> transformedGuards_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_transformedGuards();
        Set<FExp> _computedValue = new HashSet<FExp>();
        if (root.contributorMap_FAbstractEquation_transformedGuards.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_transformedGuards.get(this)) {
                contributor.contributeTo_FAbstractEquation_transformedGuards(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_transformedGuards_computed = false;

    /** @apilevel internal */
    protected Set<FExp> FAbstractEquation_transformedGuards_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2155
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2155")
    public ArrayList<FRelExp> relExpInEquation() {
        ASTState state = state();
        if (FAbstractEquation_relExpInEquation_computed) {
            return FAbstractEquation_relExpInEquation_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_relExpInEquation_value = relExpInEquation_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_relExpInEquation_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_relExpInEquation_value;
    }
    /** @apilevel internal */
    private ArrayList<FRelExp> relExpInEquation_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_relExpInEquation();
        ArrayList<FRelExp> _computedValue = new ArrayList<FRelExp>();
        if (root.contributorMap_FAbstractEquation_relExpInEquation.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_relExpInEquation.get(this)) {
                contributor.contributeTo_FAbstractEquation_relExpInEquation(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_relExpInEquation_computed = false;

    /** @apilevel internal */
    protected ArrayList<FRelExp> FAbstractEquation_relExpInEquation_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2165
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2165")
    public ArrayList<FDelayExp> delayExpInEquation() {
        ASTState state = state();
        if (FAbstractEquation_delayExpInEquation_computed) {
            return FAbstractEquation_delayExpInEquation_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_delayExpInEquation_value = delayExpInEquation_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_delayExpInEquation_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_delayExpInEquation_value;
    }
    /** @apilevel internal */
    private ArrayList<FDelayExp> delayExpInEquation_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_delayExpInEquation();
        ArrayList<FDelayExp> _computedValue = new ArrayList<FDelayExp>();
        if (root.contributorMap_FAbstractEquation_delayExpInEquation.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_delayExpInEquation.get(this)) {
                contributor.contributeTo_FAbstractEquation_delayExpInEquation(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_delayExpInEquation_computed = false;

    /** @apilevel internal */
    protected ArrayList<FDelayExp> FAbstractEquation_delayExpInEquation_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2212")
    public ArrayList<FRelExp> relExpInInitialEquation() {
        ASTState state = state();
        if (FAbstractEquation_relExpInInitialEquation_computed) {
            return FAbstractEquation_relExpInInitialEquation_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_relExpInInitialEquation_value = relExpInInitialEquation_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_relExpInInitialEquation_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_relExpInInitialEquation_value;
    }
    /** @apilevel internal */
    private ArrayList<FRelExp> relExpInInitialEquation_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_relExpInInitialEquation();
        ArrayList<FRelExp> _computedValue = new ArrayList<FRelExp>();
        if (root.contributorMap_FAbstractEquation_relExpInInitialEquation.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_relExpInInitialEquation.get(this)) {
                contributor.contributeTo_FAbstractEquation_relExpInInitialEquation(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_relExpInInitialEquation_computed = false;

    /** @apilevel internal */
    protected ArrayList<FRelExp> FAbstractEquation_relExpInInitialEquation_value;

    /**
     * Collects event generating expressions in this statements
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2222
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2222")
    public ArrayList<FExp> eventGenExps() {
        ASTState state = state();
        if (FAbstractEquation_eventGenExps_computed) {
            return FAbstractEquation_eventGenExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_eventGenExps_value = eventGenExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_eventGenExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_eventGenExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> eventGenExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FAbstractEquation_eventGenExps();
        ArrayList<FExp> _computedValue = new ArrayList<FExp>();
        if (root.contributorMap_FAbstractEquation_eventGenExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_eventGenExps.get(this)) {
                contributor.contributeTo_FAbstractEquation_eventGenExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_eventGenExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> FAbstractEquation_eventGenExps_value;

    /**
     * @attribute coll
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2431
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2431")
    public ArrayList<FExp> replacedAtInitialExps() {
        ASTState state = state();
        if (FAbstractEquation_replacedAtInitialExps_computed) {
            return FAbstractEquation_replacedAtInitialExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_replacedAtInitialExps_value = replacedAtInitialExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_replacedAtInitialExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_replacedAtInitialExps_value;
    }
    /** @apilevel internal */
    private ArrayList<FExp> replacedAtInitialExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_replacedAtInitialExps();
        ArrayList<FExp> _computedValue = new ArrayList<FExp>();
        if (root.contributorMap_FAbstractEquation_replacedAtInitialExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_replacedAtInitialExps.get(this)) {
                contributor.contributeTo_FAbstractEquation_replacedAtInitialExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_replacedAtInitialExps_computed = false;

    /** @apilevel internal */
    protected ArrayList<FExp> FAbstractEquation_replacedAtInitialExps_value;

    /**
     * Collection attribute returning all input variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3426")
    public LinkedHashSet<FVariable> retrieveInputs() {
        ASTState state = state();
        if (FAbstractEquation_retrieveInputs_computed) {
            return FAbstractEquation_retrieveInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_retrieveInputs_value = retrieveInputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_retrieveInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_retrieveInputs_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> retrieveInputs_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_retrieveInputs();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_retrieveInputs.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_retrieveInputs.get(this)) {
                contributor.contributeTo_FAbstractEquation_retrieveInputs(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_retrieveInputs_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_retrieveInputs_value;

    /**
     * Collection attribute returning all algebraic variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3460
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3460")
    public LinkedHashSet<FVariable> algebraicVariables() {
        ASTState state = state();
        if (FAbstractEquation_algebraicVariables_computed) {
            return FAbstractEquation_algebraicVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_algebraicVariables_value = algebraicVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_algebraicVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_algebraicVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> algebraicVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_algebraicVariables();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_algebraicVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_algebraicVariables.get(this)) {
                contributor.contributeTo_FAbstractEquation_algebraicVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_algebraicVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_algebraicVariables_value;

    /**
     * Collection attribute returning all derivative variables (FDerivativeVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3501
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3501")
    public LinkedHashSet<FDerivativeVariable> derivativeVariables() {
        ASTState state = state();
        if (FAbstractEquation_derivativeVariables_computed) {
            return FAbstractEquation_derivativeVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_derivativeVariables_value = derivativeVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_derivativeVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_derivativeVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FDerivativeVariable> derivativeVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_derivativeVariables();
        LinkedHashSet<FDerivativeVariable> _computedValue = new LinkedHashSet<FDerivativeVariable>();
        if (root.contributorMap_FAbstractEquation_derivativeVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_derivativeVariables.get(this)) {
                contributor.contributeTo_FAbstractEquation_derivativeVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_derivativeVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FDerivativeVariable> FAbstractEquation_derivativeVariables_value;

    /**
     * Collection attribute returning all differentiated variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3511
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3511")
    public LinkedHashSet<FVariable> differentiatedRealVariables() {
        ASTState state = state();
        if (FAbstractEquation_differentiatedRealVariables_computed) {
            return FAbstractEquation_differentiatedRealVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_differentiatedRealVariables_value = differentiatedRealVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_differentiatedRealVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_differentiatedRealVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> differentiatedRealVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_differentiatedRealVariables();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_differentiatedRealVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_differentiatedRealVariables.get(this)) {
                contributor.contributeTo_FAbstractEquation_differentiatedRealVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_differentiatedRealVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_differentiatedRealVariables_value;

    /**
     * Collection attribute returning all independent parameter variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3521
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3521")
    public LinkedHashSet<FVariable> dependentParameters() {
        ASTState state = state();
        if (FAbstractEquation_dependentParameters_computed) {
            return FAbstractEquation_dependentParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_dependentParameters_value = dependentParameters_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_dependentParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_dependentParameters_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> dependentParameters_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_dependentParameters();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_dependentParameters.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_dependentParameters.get(this)) {
                contributor.contributeTo_FAbstractEquation_dependentParameters(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_dependentParameters_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_dependentParameters_value;

    /**
     * Collection attribute returning all dependent parameter variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3531
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3531")
    public LinkedHashSet<FVariable> parameters() {
        ASTState state = state();
        if (FAbstractEquation_parameters_computed) {
            return FAbstractEquation_parameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_parameters_value = parameters_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_parameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_parameters_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> parameters_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_parameters();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_parameters.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_parameters.get(this)) {
                contributor.contributeTo_FAbstractEquation_parameters(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_parameters_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_parameters_value;

    /**
     * Collection attribute returning all discrete variables (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3541
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3541")
    public LinkedHashSet<FVariable> discreteVariables() {
        ASTState state = state();
        if (FAbstractEquation_discreteVariables_computed) {
            return FAbstractEquation_discreteVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_discreteVariables_value = discreteVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_discreteVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_discreteVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> discreteVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_discreteVariables();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_discreteVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_discreteVariables.get(this)) {
                contributor.contributeTo_FAbstractEquation_discreteVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_discreteVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_discreteVariables_value;

    /**
     * Collection attribute returning all non-fixed parameters (FVariables)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3551
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3551")
    public LinkedHashSet<FVariable> initialParameters() {
        ASTState state = state();
        if (FAbstractEquation_initialParameters_computed) {
            return FAbstractEquation_initialParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_initialParameters_value = initialParameters_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_initialParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_initialParameters_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> initialParameters_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_initialParameters();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_initialParameters.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_initialParameters.get(this)) {
                contributor.contributeTo_FAbstractEquation_initialParameters(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_initialParameters_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_initialParameters_value;

    /**
     * Collection attribute returning all pre variables (FPreVariable)
     * referenced in an equation.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3561
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3561")
    public LinkedHashSet<FVariable> discretePreVariables() {
        ASTState state = state();
        if (FAbstractEquation_discretePreVariables_computed) {
            return FAbstractEquation_discretePreVariables_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_discretePreVariables_value = discretePreVariables_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_discretePreVariables_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_discretePreVariables_value;
    }
    /** @apilevel internal */
    private LinkedHashSet<FVariable> discretePreVariables_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_discretePreVariables();
        LinkedHashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractEquation_discretePreVariables.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_discretePreVariables.get(this)) {
                contributor.contributeTo_FAbstractEquation_discretePreVariables(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_discretePreVariables_computed = false;

    /** @apilevel internal */
    protected LinkedHashSet<FVariable> FAbstractEquation_discretePreVariables_value;

    /**
     * @attribute coll
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:241")
    public Set<FExp> timeExps() {
        ASTState state = state();
        if (FAbstractEquation_timeExps_computed) {
            return FAbstractEquation_timeExps_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractEquation_timeExps_value = timeExps_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractEquation_timeExps_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractEquation_timeExps_value;
    }
    /** @apilevel internal */
    private Set<FExp> timeExps_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FAbstractEquation)) {
            node = node.getParent();
        }
        FAbstractEquation root = (FAbstractEquation) node;
        root.survey_FAbstractEquation_timeExps();
        Set<FExp> _computedValue = new LinkedHashSet<FExp>();
        if (root.contributorMap_FAbstractEquation_timeExps.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractEquation_timeExps.get(this)) {
                contributor.contributeTo_FAbstractEquation_timeExps(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractEquation_timeExps_computed = false;

    /** @apilevel internal */
    protected Set<FExp> FAbstractEquation_timeExps_value;

}
