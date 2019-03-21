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
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1014
 * @astdecl FAccessExp : CommonAccessExp ::= FAccess <OriginalVariable:String>;
 * @production FAccessExp : {@link CommonAccessExp} ::= <span class="component">{@link FAccess}</span> <span class="component">&lt;OriginalVariable:String&gt;</span>;

 */
public class FAccessExp extends CommonAccessExp implements Cloneable, WriteBackContext {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1956
     */
    public FExp createSpecifiedNode(Index i, boolean scalarize) {
        return createNode(getFAccess().specify(i, scalarize));
    }
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:80
     */
    public FAccessExp extractRecordFExp(String suffix) {
        return createNode(getFAccess().extractRecordFExp(suffix));
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:5131
     */
    public void mapComponents(Map<FAccessExp, Set<FAccessExp>> res, CValue val) {
        Set<FAccessExp> s = new HashSet<>();
        s.addAll(val.getDependencies());
        res.put(this, s);
    }
    /**
     * Constructs an FAccessExp that refers to the variable with the given FAccess.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:271
     */
    public FAccessExp(FAccess name) {
		this(name, (String)null);
	}
    /**
     * Constructs an FAccessExp that refers to the variable with the given name.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:278
     */
    public FAccessExp(String name) {
		this(new FAccessString(name));
	}
    /**
     * Constructs an FAccessExp that refers to a cell of the variable with the given name.
     * 
     * @param fas  the array subscripts to set for the last name part
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:287
     */
    public FAccessExp(String name, FArraySubscripts fas) {
		this(new FAccessFull(name, fas));
	}
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:974
     */
    public FAccessExp createEmptyNode()     { return new FAccessExp();     }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1111
     */
    public FAccessExp createNode(FAccess use) {
        FAccessExp node = createEmptyNode();
        node.setFAccess(use);
        node.setLocationNoTree(this);
        return node;
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2837
     */
    public void addToFAccessExpSet(Set<FAccessExp> set) {
        set.add(this);
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3056
     */
    @Override
    public void assignedInAllBranchesVariables(Set<String> res) {
        res.add(name());
    }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:226
     */
    public void addToParameterEquationsMap(
			Map<FAbstractVariable,FAbstractEquation> map, FAbstractEquation equ) {
        getFAccess().myFV().addToParameterEquationsMap(map, equ);
	}
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2157
     */
    public void prettyPrint_MC(Printer p, CodeStream str, String indent) {
		str.print(nameUnderscore());
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:362
     */
    public void makeContinuousVariablesDiscrete() {
        myFV().makeContinuousVariableDiscrete();
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2589
     */
    public FExp createFPreExp() {
        return new FPreExp(getFAccessNoTransform());
    }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:25
     */
    public FExp flatten(Flattener f, int order) {
        return treeCopy();
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:324
     */
    public void collectLocations(BaseNode collector){
		FAbstractVariable fv = myFV();
		if(fv.hasBindingExp()){
    		collector.addLocation(((FVariable)fv).getBindingExp());
    	}
	}
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:58
     */
    public void sanityCheckCommonAccessConsistency(FClass fc) {
        sanityCheckCommonAccessConsistencyInChildren(fc);
        
        if (!getAccess().hasNonLiteralSubscripts() && myFV().isUnknown()) {
            fc.sanityProblem(this, "Variable not found: '%s'", name());
        }
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:119
     */
    public void sanityCheckParameterEquationLeft(FClass fc, FAbstractEquation eqn) {
        FAbstractVariable fv = getFAccess().myFV();
        if (!variability().fixedParameterVariability()) {
            String s = variability() + " set in parameter equation: " + this;
            fc.sanityProblem(this, s);
        }
    }
    /**
     * Mark referenced variable as state.
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1714
     */
    public void markReferencedVarAsState() {
        myFV().markAsState();
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:332
     */
    public void enableAliasRewrite() {
		super.enableAliasRewrite();
		rewriteAlias = true;
		is$Final = false;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:353
     */
    boolean rewriteAlias = false;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:465
     */
    public void setOriginalVariable(FAccessExp oldExp, FAbstractVariable var) {
        setOriginalVariable(computeOriginalVariable(oldExp, var));
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:468
     */
    private static String computeOriginalVariable(FAccessExp oldExp, FAbstractVariable var) {
        if (!oldExp.getOriginalVariable().isEmpty()) {
            return oldExp.getOriginalVariable();
        }
        while (var.isTemporary()) {
            AliasManager.AliasVariable av = var.asFVariable().myFClass().getAliasManager().getAliasVariable(var.asFVariable());
            if (av.getTempAssignRight() != null) {
                var = av.getTempAssignRight();
            } else {
                return null;
            }
            
        }
        return var.name();
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:658
     */
    public void removeFromUses() {
		FAbstractVariable var = myFV();
		var.uses().remove(this);
		var.definingUses().remove(this);
		var.nonDefiningUses().remove(this);
		getFAccess().removeFromUses();
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:957
     */
    @Override
    public void insertTempsInLHS(FClass fClass, boolean param) {
        
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:166
     */
    public boolean dependsOnBlock(AbstractEquationBlock block) {
        return block.allVariables().contains(myFV());
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:570
     */
    public FExp createInlineVars(
            AbstractFunctionInliner fi, FExp bExp, TypePrefixVariability variability) {
        FVariable var = fi.addVar(scalarName(), variability, type());
        if (bExp != null) {
            var.setBindingExp(bExp);
            fi.setReplacementExp(scalarName(), bExp);
        }
        return var.createAccessExp();
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:631
     */
    public FExp preventEvents() {
        getFAccess().preventEvents();
        return this;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:951
     */
    public void inlineFunctions(AbstractFunctionInliner fi) {
        getFAccess().inlineFunctions(fi);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1600
     */
    public FExp replaceReferences(AbstractFunctionInliner fi) {
        replaceReferencesInSubscripts(fi);
        if (fi.isReplacementVar(name())) {
            return this;
        }
        FExp exp = null;
        if (getFAccess().hasNonLiteralSubscripts()) {
            exp = dynamicFExp(copyWithNonLiteralSubscriptsAsColon());
            exp = exp.getArray().buildWithReplacedReferences(fi, this);
            exp = new FSubscriptedExp(exp, getFAccess().copyNonLiteralSubscripts());
        } else {
            exp = fi.getReplacementExp(scalarName());
            if (exp != null) {
                exp = dynamicFExp(exp.treeCopyNoTransform());
            } else {
                if (variability().knownParameterOrLess()) {
                    exp = ceval().buildLiteral();
                } else if (isArray() && !size().isUnknown()) { 
                    exp = getArray().buildWithReplacedReferences(fi, this);
                } else if (type().isRecord()) {
                    exp = dynamicFExp(type().createRecordConstructor(fi.scalarizer(), this));
                    exp = exp.replaceReferences(fi);
                } else {
                    exp = type().zeroLiteral();
                }
            }
        }
        replaceMe(exp);
        return exp;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1637
     */
    public FAccessExp copyWithNonLiteralSubscriptsAsColon() {
        return createNode(getFAccess().copyWithNonLiteralSubscriptsAsColon());
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1685
     */
    public FArraySubscripts copyNonLiteralSubscripts() {
        return getFAccess().copyNonLiteralSubscripts();
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:487
     */
    @Override
    public boolean variabilityPropagation(
            FClass.VariabilityPropagator propagator,
            CValue value,
            TypePrefixVariability variability) {
        
        if (taggedByVProp) {
            return taggedByVProp;
        }
        
        FExp bexp = null;
        if (value.hasBuildLiteral()) {
            try {
                bexp = value.buildLiteral();
                variability = Variability.CONSTANT;
            } catch (ConstantEvaluationException e) {
                variability = variability.combine(Variability.FIXEDPARAMETER);
            }
        } else {
            variability = variability.combine(Variability.FIXEDPARAMETER);
        }
        
        myFV().variabilityPropagation(propagator, variability, bexp);
        taggedByVProp = variability.knownParameterOrLess();
        return taggedByVProp;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1096
     */
    public FExp scalarRecordFExp(Scalarizer s, FAccess suffix) {
      FAccess access = getFAccess();
      if (indexNames != null) {
          access = access.copyAndAddFas(createIndexNameFas());
      }
      access = access.asFAccessFull().treeCopy().append(suffix);
      access.scalarized = false;
      FExp res = createNode(access);
      res = dynamicFExp(res).scalarize(s);
      res.setLocation(this);
      return res;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1488
     */
    public FExp scalarizeExp(Scalarizer s) {
        return s.scalarizeAccessExp(this);
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:169
     */
    public void usesInScalarizedExp(Set<FAbstractVariable> res) {
        res.add(myFV());
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:933
     */
    public void addArrayUsesToIndexMap(FExp[] names) {
        if (!hasFArraySubscripts() && isArray())
            indexNames = names;
        super.addArrayUsesToIndexMap(names);
    }
    /**
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:91
     */
    private boolean dynamicStateRewriteEnabled = false;
    /**
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:97
     */
    @Override
    public void enableDynamicStateRewrite() {
        super.enableDynamicStateRewrite();
        dynamicStateRewriteEnabled = true;
    }
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:236
     */
    public void removeBindingExpOfReferencedVars() {
		getFAccess().myFV().removeBindingExp();
	}
    /**
     * @aspect WhenClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\WhenTransformation.jrag:166
     */
    public FExp asGuard(Collection<FAbstractEquation> outerEqnList, Collection<FStatement> stmtList, FClass fclass) {
        if (shouldExtractGuard())
            return super.asGuard(outerEqnList, stmtList, fclass);
        else
            return new FAndExp(fullCopy(), new FNotExp(new FPreExp(getFAccess().fullCopy())));
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:193
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {	
		p.print(getFAccess(), str, p.indent(indent));
	}
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:307
     */
    @Override
    public void genForIndexExtraVarDecls_C(CodePrinter p, CodeStream str, String indent, String name) {
        str.format("%sint %si;\n", indent, name);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:365
     */
    @Override
    public void printForIndex_C(CodePrinter p, CodeStream str, String indent, String name) {
        str.format("%1$si = 0; %1$si < jmi_array_size(%2$s, 0); %1$si++", 
                name, getFAccess().toString_C(p));
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:412
     */
    @Override
    public void printForIndexNext_C(CodePrinter p, CodeStream str, String indent, String name) {
        str.format("%1$s%2$s = jmi_array_val_1(%3$s, %2$si);\n", 
                indent, name, getFAccess().toString_C(p));
    }
    /**
     * Helper method that prints the variable reference for assignment (LHS).
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:585
     */
    public void genAssignedRef(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        p.print(getFAccess(), str, "");
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:589
     */
    public void genAssignedRef(FAbstractVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        genAssignedRef(p, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:602
     */
    public void genScaledAssignedRef(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        if (needsScaling()) {
            genScaledAssignedRef(myFV(), p, str, indent);
        } else {
            genAssignedRef(p, str, indent);
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:613
     */
    public void genScaledAssignedRef(FAbstractVariable v, CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        if (needsScaling()) {
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
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:637
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        genScaledAssignedRef(p.ExecStep, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1606
     */
    public void genDirectSubscriptedUse_C(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent,
            FArraySubscripts fas) {
        str.print("(&");
        p.print(this, str, indent);
        str.print(")");
        str.print("[(int)(");
        Size s = fas.mySize();
        for (int i = fas.numSubscript() - 1; i >= 0; i--) {
            fas.subscript(i).prettyPrint(p.codePrinter(), str, indent);
            str.print(" - 1");
            if (i > 0) {
                str.print(" + ");
                str.print(s.get(i));
                str.print(" * (");
            }
        }
        for (int i = 0; i < fas.numSubscript() - 1; i++) {
            str.print(")");
        }
        str.print(")]");
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:489
     */
    @Override
    public void genFuncCallCellInOutArg_C(CodeFuncCallInOutArgPrinter p, CodeStream str, String indent, String name) {
        p.printUse(str, indent, name, this);
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:500
     */
    public void genTempInputCellAssignsMemcpy_C(CodeStream str, String indent, String name, int n) {
        str.print(indent);
        str.print("memcpy(&");
        str.print(name);
        str.print(", &");
        genAssignedRef(ASTNode.printer_C.ExecStep, str, indent);
        str.print(", ");
        str.print(n);
        str.print(" * sizeof(");
        str.print(type().memcpyObject());
        str.print("));\n");
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:530
     */
    public void genArrayWriteBackAssignment_C(CodePrinter p, CodeStream str, String indent, String name, int n) {
        str.print(indent);
        str.print("memcpy(&");
        genAssignedRef(p.ExecStep, str, indent);
        str.print(", &");
        str.print(name);
        str.print(", ");
        str.print(n);
        str.print(" * sizeof(jmi_real_t));\n");
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAccessExp() {
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
        children = new ASTNode[2];
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FAccess", "OriginalVariable"},
        type = {"FAccess", "String"},
        kind = {"Child", "Token"}
    )
    public FAccessExp(FAccess p0, String p1) {
        setChild(p0, 0);
        setOriginalVariable(p1);
    }
    /**
     * @declaredat ASTNode:22
     */
    public FAccessExp(FAccess p0, beaver.Symbol p1) {
        setChild(p0, 0);
        setOriginalVariable(p1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myFV_reset();
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
    public FAccessExp clone() throws CloneNotSupportedException {
        FAccessExp node = (FAccessExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FAccessExp copy() {
        try {
            FAccessExp node = (FAccessExp) clone();
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
    public FAccessExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public FAccessExp treeCopyNoTransform() {
        FAccessExp tree = (FAccessExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 1:
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
    public FAccessExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenString_OriginalVariable == ((FAccessExp) node).tokenString_OriginalVariable);    
    }
    /**
     * Replaces the FAccess child.
     * @param node The new node to replace the FAccess child.
     * @apilevel high-level
     */
    public void setFAccess(FAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FAccess child.
     * @return The current node used as the FAccess child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAccess")
    public FAccess getFAccess() {
        return (FAccess) getChild(0);
    }
    /**
     * Retrieves the FAccess child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAccess child.
     * @apilevel low-level
     */
    public FAccess getFAccessNoTransform() {
        return (FAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the lexeme OriginalVariable.
     * @param value The new value for the lexeme OriginalVariable.
     * @apilevel high-level
     */
    public void setOriginalVariable(String value) {
        tokenString_OriginalVariable = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_OriginalVariable;
    /**
     */
    public int OriginalVariablestart;
    /**
     */
    public int OriginalVariableend;
    /**
     * JastAdd-internal setter for lexeme OriginalVariable using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme OriginalVariable
     * @apilevel internal
     */
    public void setOriginalVariable(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setOriginalVariable is only valid for String lexemes");
        tokenString_OriginalVariable = (String)symbol.value;
        OriginalVariablestart = symbol.getStart();
        OriginalVariableend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme OriginalVariable.
     * @return The value for the lexeme OriginalVariable.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="OriginalVariable")
    public String getOriginalVariable() {
        return tokenString_OriginalVariable != null ? tokenString_OriginalVariable : "";
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 1;
    }
    /**
     * Given that <code>val</code> is the value of this use expression, 
     * extract the part of it referring to <code>fv</code>, 
     * or <code>null</code> if none match. 
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3299")
    public CValue extractCValue(CValue val, FVariable fv) {
        CValue extractCValue_CValue_FVariable_value = getFAccess().myFV() == fv ? val : null;
        return extractCValue_CValue_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1136
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1136")
    public boolean isConsecutiveInZ(FAccessExp use) {
        boolean isConsecutiveInZ_FAccessExp_value = myFV().isConsecutiveInZ(use.myFV());
        return isConsecutiveInZ_FAccessExp_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3223")
    public FExp nominal() {
        FExp nominal_value = myFV().nominal();
        return nominal_value;
    }
    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3466
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3466")
    public boolean isAlgebraicVariableAccess() {
        boolean isAlgebraicVariableAccess_value = inAccessLocation() && myFV().isAlgebraicVariable();
        return isAlgebraicVariableAccess_value;
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3706
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3706")
    public boolean isIndependent(Set<? extends CommonVariableDecl> set) {
        {
                return getFAccess().isIndependent(set);
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAlgorithmAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4227")
    public FAlgorithm myFAlgorithm() {
        FAlgorithm myFAlgorithm_value = getFAccess().myFAlgorithm();
        return myFAlgorithm_value;
    }
    /**
     * Return the maximum numeric value that this expression can take, considering min/max values of variables.
     * 
     * Only implemented for a small subset of expressions:
     * - flat access to Real or Integer
     * - numeric literal
     * - negation
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:252")
    public double maxRealValue() {
        double maxRealValue_value = myFV().maxRealValue();
        return maxRealValue_value;
    }
    /**
     * Return the minimum numeric value that this expression can take, considering min/max values of variables.
     * 
     * Only implemented for a small subset of expressions:
     * - flat access to Real or Integer
     * - numeric literal
     * - negation
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:264
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:264")
    public double minRealValue() {
        double minRealValue_value = myFV().minRealValue();
        return minRealValue_value;
    }
    /** @apilevel internal */
    private void myFV_reset() {
        myFV_computed = false;
        
        myFV_value = null;
    }
    /** @apilevel internal */
    protected boolean myFV_computed = false;

    /** @apilevel internal */
    protected FAbstractVariable myFV_value;

    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:23")
    public FAbstractVariable myFV() {
        ASTState state = state();
        if (myFV_computed) {
            return myFV_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFV_value = getFAccess().myFV();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFV_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFV_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:30")
    public FAbstractVariable myDerFV(int index) {
        FAbstractVariable myDerFV_int_value = getFAccess().myDerFV(index);
        return myDerFV_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:35
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:35")
    public CommonVariableDecl myCommonVarDecl() {
        CommonVariableDecl myCommonVarDecl_value = getFAccess().myFV();
        return myCommonVarDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:44")
    public CommonAccess getAccess() {
        CommonAccess getAccess_value = getFAccess();
        return getAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:356")
    public String derName(int order) {
        String derName_int_value = getFAccessNoTransform().derName(order);
        return derName_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:364
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:364")
    public String preName() {
        String preName_value = getFAccessNoTransform().preName();
        return preName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:366
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:366")
    public String scalarName() {
        String scalarName_value = getFAccess().scalarName();
        return scalarName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:395
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:395")
    public String nameUnderscore() {
        String nameUnderscore_value = getFAccess().nameUnderscore();
        return nameUnderscore_value;
    }
    /**
     * If this is an flat tree access, return set containing accessed var, otherwise empty set.
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:402
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:402")
    public FAbstractVariable assignedFV() {
        FAbstractVariable assignedFV_value = myFV();
        return assignedFV_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:900
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:900")
    public FAccessExp asFAccessExp() {
        FAccessExp asFAccessExp_value = this;
        return asFAccessExp_value;
    }
    /**
     * Check if this expression is an access to v or a multiplication where one of the 
     * multiplicands is an access to v.
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:344")
    public boolean isMultiplicationOf(FVariable v) {
        boolean isMultiplicationOf_FVariable_value = v == myFV();
        return isMultiplicationOf_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect Cardinality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Cardinality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3223")
    public int cardinalityValue() {
        int cardinalityValue_value = getFAccess().cardinalityValue();
        return cardinalityValue_value;
    }
    /**
     * Return the expression corresponding to the given index in this array expression. 
     * 
     * Will not create new nodes unless necessary.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862")
    public FExp splitArrayExp(int index) {
        FExp splitArrayExp_int_value = createNode(getFAccess().splitArrayAccess(index));
        return splitArrayExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1574
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1574")
    public boolean isZeroFlowForm(FExp other) {
        boolean isZeroFlowForm_FExp_value = other.isSemiLinear();
        return isZeroFlowForm_FExp_value;
    }
    /**
     * Checks if this expression allows a semiLinear() with it as argument to be smooth(0, ...).
     * @attribute syn
     * @aspect SemiLinear
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1636
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SemiLinear", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1636")
    public boolean isSmoothInSemiLinear() {
        boolean isSmoothInSemiLinear_value = true;
        return isSmoothInSemiLinear_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:159")
    public boolean canBeAlias() {
        boolean canBeAlias_value = myFV().canBeAlias();
        return canBeAlias_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:173
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:173")
    public FVariable variableThatCanBeAlias() {
        {
                FAbstractVariable fav = myFV();
                if (fav.isFVariable()) {
                    return fav.asFVariable();
                } else {
                    return null;
                }
            }
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:484
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:484")
    public FAbstractVariable myOriginalFV() {
        FAbstractVariable myOriginalFV_value = myFClass().lookupFV(getOriginalVariable());
        return myOriginalFV_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:554
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:554")
    public boolean isOkInlineTemporaries() {
        boolean isOkInlineTemporaries_value = true;
        return isOkInlineTemporaries_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:560
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:560")
    public boolean isTempAccess() {
        boolean isTempAccess_value = myFV().isTemporary();
        return isTempAccess_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:633")
    public FAccessExp getEquationLeftInlineUse() {
        FAccessExp getEquationLeftInlineUse_value = this;
        return getEquationLeftInlineUse_value;
    }
    /**
     * Check if this expression or any subexpressions can cause events. 
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:677")
    public boolean generatesEvents() {
        boolean generatesEvents_value = getFAccess().generatesEvents();
        return generatesEvents_value;
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
        boolean hasInlinableFunctions_AbstractFunctionInliner_value = getFAccess().hasInlinableFunctions(fi);
        return hasInlinableFunctions_AbstractFunctionInliner_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1116
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1116")
    public FFunctionVariable myFuncFV() {
        FFunctionVariable myFuncFV_value = getFAccess().myFuncFV();
        return myFuncFV_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1150")
    public boolean isOkTrivialInlineInFor() {
        boolean isOkTrivialInlineInFor_value = myFV().isArray();
        return isOkTrivialInlineInFor_value;
    }
    /**
     * Checks if left hand side variable(s) is eligible for var. prop.
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:65")
    public boolean canPropagate() {
        boolean canPropagate_value = myFV().canPropagate();
        return canPropagate_value;
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
        boolean extractTemp_value = super.extractTemp() && isSlice() && !isFunctionCallLeft();
        return extractTemp_value;
    }
    /**
     * @attribute syn
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:559
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Derivatives", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:559")
    public FExp createDerExp(int order) {
        {
                FDerExp exp = getFAccess().createDerExp(order() + order);
                exp.setOriginalVariable(getOriginalVariable());
                return exp;
            }
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:80
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:80")
    public boolean isDynamicState() {
        boolean isDynamicState_value = myFV().isDynamicState();
        return isDynamicState_value;
    }
    /**
     * Test if this is a use of a parameter (in the flat tree).
     * @attribute syn
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterSorting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:260")
    public boolean isFlatParameterUse() {
        boolean isFlatParameterUse_value = getFAccess().isFlatParameterUse();
        return isFlatParameterUse_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenAlgorithms", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55")
    public String assignMacroType(FType type) {
        String assignMacroType_FType_value = myFV().assignMacroType(type);
        return assignMacroType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1278")
    public boolean needsTemp_C() {
        boolean needsTemp_C_value = isSlice() || (isFunctionCallLeft() && (!inFunction() || alsoInRHS() || type().isString()));
        return needsTemp_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583")
    public FAccessExp first() {
        FAccessExp first_value = this;
        return first_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1589
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1589")
    public FAbstractVariable consecutiveArray(FAbstractVariable last) {
        {
                if (last == null || last.isConsecutiveInZ(myFV())) {
                    return myFV();
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:34
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenFunctionIO", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:34")
    public boolean alsoInRHS() {
        {
                FAbstractFunctionCall call = myFunctionCall();
                FAbstractVariable var = myFV();
                for (FExp exp : call.childFExps()) {
                    if (exp.isAccess() && exp.asFAccessExp().myFV() == var) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:455")
    public boolean genAssignMacro() {
        boolean genAssignMacro_value = true;
        return genAssignMacro_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095")
    public String htmlPrintWrapTagClass() {
        {
                FAbstractVariable fv = myFV();
                if (fv != null && fv.isFVariable()) {
                    return "varRef " + fv.asFVariable().zVariability();
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1097
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1097")
    public Object htmlPrintLocalObject() {
        Object htmlPrintLocalObject_value = myFV();
        return htmlPrintLocalObject_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096")
    public String[][] htmlPrintWrapTagAttributes() {
        {
                FAbstractVariable fv = myFV();
                if (fv == null || !fv.isFVariable()) {
                    return null;
                }
                return new String[][] {new String[] {"data-varRef", fv.name()}};
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
                if (myFV().inRecord()) {
                    return getParent().getMXVariableFromRecordHashMap(getFAccess().toString());
                } else if (hasFArraySubscripts() && inFunction()) {
                    int flatIndex = getFArraySubscripts().computeFlattenedIndexBasedOnSizeData(myFV().size());
                    return myFV().asMXVector().get(flatIndex);
                } else {
                    return myFV().asMXVariable();
                }
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
                if (inFunction() && (size().numElements() > 1 || type().isRecord())) {
                    return myFV().asMXVector();
                } else {
                    MXVector MXVec = new MXVector();
                    MXVec.add(toMX());
                    return MXVec;
                }
            }
    }
    /**
     * Returns true if this access is in a location where it should be
     * contributed to the equation system.
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3472
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3472")
    public boolean inAccessLocation() {
        boolean inAccessLocation_value = getParent().Define_inAccessLocation(this, null);
        return inAccessLocation_value;
    }
    /**
     * @attribute inh
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629")
    public FAccessExp inlineUsesFunctionCallLeft() {
        FAccessExp inlineUsesFunctionCallLeft_value = getParent().Define_inlineUsesFunctionCallLeft(this, null);
        return inlineUsesFunctionCallLeft_value;
    }
    /**
     * @attribute inh
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:86")
    public boolean shouldRewriteToDSRef() {
        boolean shouldRewriteToDSRef_value = getParent().Define_shouldRewriteToDSRef(this, null);
        return shouldRewriteToDSRef_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:366
        if (rewriteAlias) {
            return rewriteRule0();
        }
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:104
        if (dynamicStateRewriteEnabled && isDynamicState() && shouldRewriteToDSRef()) {
            return rewriteRule1();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:366
     * @apilevel internal
     */
    private FExp rewriteRule0() {
{
            if (myFV().isFVariable() && myFV().isAlias()) {
                FVariable fv = (FVariable) myFV();
                FAccessExp newExp = fv.alias().createAccessExp();
                newExp.setLocationNoTree(this);
                newExp.addLocation(fv);
                newExp.setOriginalVariable(this, fv);
                newExp.rewriteAlias = true;
                return fv.aliasNegatedWrap(this, newExp);
            }
            FAbstractEquation eqn = myFEquation();
            if (eqn != null && !eqn.potentialAliasEquation()
                    && myFV().derivativeEquivalent() != null
                    && order() == 0 && inEquationSection()
                    && !inWhen() && !inFunctionCallLeft()) {
                FVariable var = myFV().derivativeEquivalent();
                FAccessExp exp = var.getMeDifferentiated().createAccessExp();
                exp.setOriginalVariable(this, var);
                if (var.isAlias())
                    exp.rewriteAlias = true;
                return exp;
            } else {
                rewriteAlias = false;
                return this;
            }
        }    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:104
     * @apilevel internal
     */
    private FDSRefExp rewriteRule1() {
{
            dynamicStateRewriteEnabled = false;
            return new FDSRefExp(myFV().dynamicStateSet().id(), this);
        }    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractVariable_uses(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3276
        {
            FAbstractVariable target = (FAbstractVariable) (myFV());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FAbstractVariable_uses(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractVariable_dependentParameters(FlatRoot _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3403
        if (myFV().isParameter()) {
            {
                FAbstractVariable target = (FAbstractVariable) (myFV());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractVariable_dependentParameters(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_retrieveInputs(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3429
        if (myFV().isFVariable() && myFV().isInput()) {
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
        super.collect_contributors_FAbstractEquation_retrieveInputs(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_algebraicVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3463
        if (isAlgebraicVariableAccess()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_algebraicVariables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_differentiatedRealVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3514
        if (myFV().isDifferentiatedVariable() && inAccessLocation()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_differentiatedRealVariables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_dependentParameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3524
        if (myFV().isDependentParameter() && inAccessLocation()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_dependentParameters(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_parameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3534
        if (myFV().isParameter() && inAccessLocation()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_parameters(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_discreteVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3544
        if (myFV().isDiscreteVariable() && inAccessLocation()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_discreteVariables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_initialParameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3554
        if (myFV().isInitialParameter() && inAccessLocation()) {
            for (FAbstractEquation target : (Iterable<? extends FAbstractEquation>) (enclosingEquationsIterator())) {
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FAbstractEquation_initialParameters(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FFunctionVariable_assigningUses(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1113
        if (isAssignedTo() && myFuncFV() != null) {
            {
                FFunctionVariable target = (FFunctionVariable) (myFuncFV());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FFunctionVariable_assigningUses(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractVariable_uses(HashSet<FAccessExp> collection) {
        super.contributeTo_FAbstractVariable_uses(collection);
        collection.add(this);
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractVariable_dependentParameters(HashSet<FVariable> collection) {
        super.contributeTo_FAbstractVariable_dependentParameters(collection);
        if (myFV().isParameter()) {
            collection.addAll(boundParameters());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_retrieveInputs(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_retrieveInputs(collection);
        if (myFV().isFVariable() && myFV().isInput()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_algebraicVariables(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_algebraicVariables(collection);
        if (isAlgebraicVariableAccess()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_differentiatedRealVariables(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_differentiatedRealVariables(collection);
        if (myFV().isDifferentiatedVariable() && inAccessLocation()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_dependentParameters(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_dependentParameters(collection);
        if (myFV().isDependentParameter() && inAccessLocation()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_parameters(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_parameters(collection);
        if (myFV().isParameter() && inAccessLocation()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_discreteVariables(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_discreteVariables(collection);
        if (myFV().isDiscreteVariable() && inAccessLocation()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_initialParameters(LinkedHashSet<FVariable> collection) {
        super.contributeTo_FAbstractEquation_initialParameters(collection);
        if (myFV().isInitialParameter() && inAccessLocation()) {
            collection.add((FVariable) myFV());
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FFunctionVariable_assigningUses(HashSet<FAccessExp> collection) {
        super.contributeTo_FFunctionVariable_assigningUses(collection);
        if (isAssignedTo() && myFuncFV() != null) {
            collection.add(this);
        }
    }
}
