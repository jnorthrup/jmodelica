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
 * Abstract base class for flat variables.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:83
 * @astdecl FAbstractVariable : BaseNode;
 * @production FAbstractVariable : {@link BaseNode};

 */
public abstract class FAbstractVariable extends BaseNode implements Cloneable, CommonVariableDecl, Named_C, TypePrintable_C {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3480
     */
    public boolean isInstClassConstant() { return false;}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3482
     */
    public boolean isPackageConstant() { return false;}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3485
     */
    public boolean inSameInstClass(InstNode instNode) { return false;}
    /**
     * Read current function evaluation value from map.
     * 
     * If this variable isn't in the map, set to value of binding expression.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3840
     */
    public void readEvaluationValue(Map<CommonVariableDecl, CValue> map) {
        CValue val = map.get(this);
        if (val == null) {
            val = cevalFunctionBindingExp(ASTNode.defaultVariableEvaluator());
        }
        if (!isInput()) {
            val = val.cached();
        }
        map.put(this, val);
        setLocalCachedEvaluationValue(val);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3870
     */
    protected CValue cevalFunctionBindingExp(VariableEvaluator evaluator) {
        return CValue.UNKNOWN;
    }
    /**
     * Set the current function evaluation value.
     * 
     * Also updates value map.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3972
     */
    public void setEvaluationValue(VariableEvaluator evaluator, CValue val) {
        evaluator.setEvaluationValue(this, val.cached());
    }
    /**
     * Check if this variable has a current function evaluation value.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3988
     */
    public boolean hasEvaluationValue(VariableEvaluator evaluator) {
	  return evaluator.hasEvaluationValue(this);
  }
    /**
     * Get the current evaluation value.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4002
     */
    public CValue evaluationValue(VariableEvaluator evaluator) {
	  return evaluator.evaluationValue(this);
  }
    /**
     * Remove the current evaluation value
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4016
     */
    public void clearEvaluationValue(VariableEvaluator evaluator) {
        evaluator.clearEvaluationValue(this);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4027
     */
    protected CValue evaluationValue = null;
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4030
     */
    public CValue getLocalCachedEvaluationValue() {
        return evaluationValue;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4038
     */
    public void setLocalCachedEvaluationValue(CValue value) {
        evaluationValue = value;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4046
     */
    public void clearLocalCachedEvaluationValue() {
        evaluationValue = null;
    }
    /**
     * Kept for legacy reasons.
     * @deprecated Use {@link #setLocalCachedEvaluationValue} instead.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4058
     */
    public void setEvaluationValue(CValue value) {
        setLocalCachedEvaluationValue(value);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4121
     */
    public Map<CommonVariableDecl,CValue> collectEvaluationValues(Map<CommonVariableDecl,CValue> map) {
        return super.collectEvaluationValues(collectMyEvaluationValue(map));
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4148
     */
    public Map<CommonVariableDecl,CValue> collectMyEvaluationValue(Map<CommonVariableDecl,CValue> map) {
        if (evaluationValue != null) {
            if (map == null)
                map = new HashMap<CommonVariableDecl,CValue>();
            map.put(this, evaluationValue);
        }
        return map;
    }
    /**
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:231
     */
    public void addToParameterEquationsMap(
            Map<FAbstractVariable,FAbstractEquation> map, FAbstractEquation equ) {
        if (!isUnknown()) {
            map.put(this, equ);
        }
    }
    /**
     * This method takes a variable and adds it to the tree. This is done by
     * settings its parent to the same parent as this node.
     * @aspect JastAddHacks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2039
     */
    
        /**
         * This method takes a variable and adds it to the tree. This is done by
         * settings its parent to the same parent as this node.
         */
        public <V extends FAbstractVariable> V dynamicVariable(V var) {
            var.parent = this.parent;
            return var;
        }
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:64
     */
    public Size lookupHierarchicalSize(FAccessFull name, int part, int last) {
        return type().lookupHierarchical(name, part+1, last).size();
    }
    /**
     * If this is a normal continous variable, convert it to a discrete variable.
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:383
     */
    public void makeContinuousVariableDiscrete() {}
    /**
     * @aspect Sorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1824
     */
    public static final Comparator<FAbstractVariable> NAME_COMPARATOR = 
		new Comparator<FAbstractVariable>() {
			public int compare(FAbstractVariable fv1, FAbstractVariable fv2) {
				String n1 = (fv1 == null) ? null : fv1.name();
				String n2 = (fv2 == null) ? null : fv2.name();
				if (n1 != null)
					return n1.compareTo(n2);
				else
					return (n2 != null) ? 1 : 0;
			}
			
			public boolean equals(Object obj) { 
				return obj == this; 
			}
		};
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:233
     */
    public void markUsedGlobalVariable(Global.UseType type) {}
    /**
     * Mark this variable as a state, by setting stateSelect=always.
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1721
     */
    public void markAsState() {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:452
     */
    public FExp aliasNegatedWrap(FExp oldExp, FExp newExp) {
        if (isAliasNegated(oldExp)) {
            return new FNegExp(newExp);
        } else {
            return newExp;
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:460
     */
    public boolean isAliasNegated(FExp oldExp) {
        // Hook to facilitate extensions
        return isNegated();
    }
    /**
     * Create a TrivialInlineCheck object for this variable.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1160
     */
    public TrivialInlineCheck createTrivialInlineCheck() {
        if (isArray()) {
            if (isRecord())
                return new TrivialInlineCheck.Unsupported();
            if (size().isUnknown())
                return new TrivialInlineCheck.UnknownArray();
            else
                return new TrivialInlineCheck.KnownArray(size().numElements());
        } else {
            if (isRecord())
                return new TrivialInlineCheck.Record(myFRecordDecl());
            else
                return new TrivialInlineCheck.Scalar();
        }
    }
    /**
     * Keep reference to function inliner during inlining for type lookup.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1301
     */
    public void cacheFunctionInliner(AbstractFunctionInliner fi) {}
    /**
     * Clear reference to function inliner.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1309
     */
    public void clearFunctionInliner() {}
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:515
     */
    public void variabilityPropagation(
            FClass.VariabilityPropagator propagator,
            TypePrefixVariability variability,
            FExp bindingExp) {
        
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:656
     */
    public boolean taggedByVProp = false;
    /**
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1320
     */
    
        public enum StateSelect {
            NEVER   (IndexReductionBiPGraph.IndexReductionCost.STATE_SELECT_NEVER_WEIGHT_POSITION), 
            AVOID   (IndexReductionBiPGraph.IndexReductionCost.STATE_SELECT_AVOID_WEIGHT_POSITION), 
            DEFAULT (IndexReductionBiPGraph.IndexReductionCost.STATE_SELECT_DEFAULT_WEIGHT_POSITION), 
            PREFER  (IndexReductionBiPGraph.IndexReductionCost.STATE_SELECT_PREFER_WEIGHT_POSITION), 
            ALWAYS  (IndexReductionBiPGraph.IndexReductionCost.STATE_SELECT_ALWAYS_WEIGHT_POSITION);
            
            private int weightPos;
            
            private StateSelect(int weightPos) {
                this.weightPos = weightPos;
            }
            
            public int weightPos() {
                return weightPos;
            }
        }
    /**
     * Remove binding expression of this variable.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:243
     */
    public void removeBindingExp() {}
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:304
     */
    protected String name_C(String prefix, String suffix) {
		StringBuilder buf = new StringBuilder();
		if (prefix != null) {
			buf.append(prefix);
			buf.append('_');
		}
		buf.append(nameUnderscore());
		buf.append('_');
		buf.append(suffix);
		return buf.toString();
	}
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:74
     */
    public void printInit(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent, FType type) {
        String name = p.name(this);
        TypePrinter_C tp = p.codePrinter().createInitSetPrinter(str);
        if (isComposite() && isOutput() && !isString()) {
            String next = p.codePrinter().indent(indent);
            String iniName = name + C_SUFFIX_NULL;
            str.print(indent + "if (" + name + " == NULL) {\n");
            p.codePrinter().printPreSteps(type, str, next);
            tp.reset(iniName, this, type.size(), false, next);
            type.print(tp);
            str.print(next + name + " = " + iniName + ";\n");
            str.print(indent + "}\n");
        } else {
            p.codePrinter().printPreSteps(type, str, indent);
            tp.reset(name, this, type.size(), false, indent);
            type.print(tp);
        }
    }
    /**
     * @aspect CCodeGenBlocksEval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksEval.jrag:42
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        str.print(name_C());
    }
    /**
     * @aspect CCodeGenBlocksResidual
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocksResidual.jrag:141
     */
    public void genTempSwap(CodePrinter.ExecuteCodePrinter p, TempScope ts, CodeStream str, String indent)  {
        str.print(indent, "JMI_SWAP(", type().macroType(), ", ", p.name(this), ", ", p.tempName(this, ts), ")\n");
    }
    /**
     * Helper, generates an regular variable use
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:729
     */
    public String genUse_C(CodePrinter.ExecuteCodePrinter p, FArraySubscripts fas, String type) {
        if (fas == null || fas.ndims() == 0) {
            return p.name(this);
        } else {
            return fas.genFunctionArrayUse_C(p.codePrinter(), p.name(this), type);
        }
    }
    /**
     * @aspect CodeFuncCallInOutArgPrinters
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:367
     */
    public void genWriteBackResidual(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent, WriteBackContext ctx, String name, Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter) {
        int index = indexCounter.next();
        if (forIndices == null || forIndices.contains(index)) {
            if (!isReal()) 
                throw new UnsupportedOperationException("Cannot generate real residual write back for non real variable " + name());

            // This variable is in the set of variables to generate code for.
            str.print(indent, "(*", p.residual(), ")[", enumerator.next(), "] = ");
            str.print(name);
            str.print(" - (");
            ctx.genScaledAssignedRef(this, p, str, indent);
            str.print(");\n");
        }
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:549
     */
    public void genWriteBackAssignment(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent, WriteBackContext ctx, String name,
            Collection<FVariable> forVariables) {
        if (forVariables != null && !forVariables.contains(this))
            return; // This variable is not in the set of variables to generate code for.
        if (type().isString()) {
            str.print(indent);
            str.print("JMI_ASG(STR");
            if (!ctx.inFunction()) {
                str.print("_Z");
            }
            str.print(", ");
            ctx.genAssignedRef(this, p, str, indent);
            str.print(", ");
            str.print(name);
            str.println(")");
            return;
        }
        str.print(indent);
        ctx.genAssignedRef(this, p, str, indent);
        str.print(" = (");
        str.print(name);
        str.print(")");
        if (needsScaling(ctx)) {
            str.print("/sf(");
            str.print(valueReference());
            str.print(")");
        }
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:120
     */
    public void print(TypePrinter_C tp, String name, String indent) {
        tp.reset(name, this, size(), false, indent);
        type().print(tp);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAbstractVariable() {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:13
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:19
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:23
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        size_reset();
        indices_reset();
        isCircular_reset();
        nonDefiningUses_reset();
        definingUses_reset();
        dependentRealParameters_reset();
        dependentIntegerParameters_reset();
        dependentEnumParameters_reset();
        dependentBooleanParameters_reset();
        dependentStringParameters_reset();
        myFRecordDecl_reset();
        myFEnumDecl_reset();
        name_C_reset();
        asMXVector_reset();
        asMXVariable_reset();
        valueReference_reset();
        parameterEquation_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        FAbstractVariable_uses_computed = false;
        
        FAbstractVariable_uses_value = null;
        FAbstractVariable_dependentParameters_computed = false;
        
        FAbstractVariable_dependentParameters_value = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public FAbstractVariable clone() throws CloneNotSupportedException {
        FAbstractVariable node = (FAbstractVariable) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:65
     */
    @Deprecated
    public abstract FAbstractVariable fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:73
     */
    public abstract FAbstractVariable treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:81
     */
    public abstract FAbstractVariable treeCopy();
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:174
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:174")
    public abstract FType type();
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406")
    public abstract TypePrefixVariability variability();
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535")
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1157")
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
     * check if a variable is an array expression.
     * 
     * @return True if array dimension > 0 else false
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1204")
    public boolean isArray() {
        boolean isArray_value = ndims()>0;
        return isArray_value;
    }
    /** @apilevel internal */
    private void indices_reset() {
        indices_computed = false;
        
        indices_value = null;
    }
    /** @apilevel internal */
    protected boolean indices_computed = false;

    /** @apilevel internal */
    protected Indices indices_value;

    /**
     * Get the set of all array indices of an FVariable. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2275
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2275")
    public Indices indices() {
        ASTState state = state();
        if (indices_computed) {
            return indices_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        indices_value = Indices.create(size());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        indices_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return indices_value;
    }
    /**
     * Constant evaluation of FVariable binding expressions.
     * 
     * If an expression is evaluated in an FClass, then identifiers are 
     * referencing FVariables. The constant value of an FVariable is computed
     * by evaluating the binding expression of the variable, if any. If the
     * FVariable is not a constant or a parameter, or if it has no binding
     * expressions, then a CValueUnknown object is returned.
     * 
     * @return The constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3199
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3199")
    public CValue ceval() {
        CValue ceval_value = ceval(defaultVariableEvaluator());
        return ceval_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = CValue.UNKNOWN;
        return ceval_VariableEvaluator_value;
    }
    /**
     * Constant evaluation of FVariable binding expressions.
     * 
     * If an expression is evaluated in an FClass, then identifiers are 
     * referencing FVariables. The constant value of an FVariable is computed
     * by evaluating the binding expression of the variable, if any. If the
     * FVariable is not a constant or a parameter, or if it has no binding
     * expressions, then a CValueUnknown object is returned.
     * 
     * This version only evaluates a specific cell in an array, and returns 
     * the value for that specific cell.
     * 
     * @return The constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        CValue ceval_VariableEvaluator_Index_value = CValue.UNKNOWN;
        return ceval_VariableEvaluator_Index_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3503
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3503")
    public FAbstractVariable asFAbstractVariable() {
        FAbstractVariable asFAbstractVariable_value = this;
        return asFAbstractVariable_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4679
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4679")
    public boolean isUnknownSizeVar() {
        boolean isUnknownSizeVar_value = false;
        return isUnknownSizeVar_value;
    }
/** @apilevel internal */
protected ASTState.Cycle isCircular_cycle = null;
    /** @apilevel internal */
    private void isCircular_reset() {
        isCircular_computed = false;
        isCircular_initialized = false;
        isCircular_cycle = null;
    }
    /** @apilevel internal */
    protected boolean isCircular_computed = false;

    /** @apilevel internal */
    protected boolean isCircular_value;
    /** @apilevel internal */
    protected boolean isCircular_initialized = false;
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4726")
    public boolean isCircular() {
        if (isCircular_computed) {
            return isCircular_value;
        }
        ASTState state = state();
        if (!isCircular_initialized) {
            isCircular_initialized = true;
            isCircular_value = true;
        }
        if (!state.inCircle() || state.calledByLazyAttribute()) {
            state.enterCircle();
            int _boundaries = state.boundariesCrossed;
            boolean isFinal = this.is$Final();
            do {
                isCircular_cycle = state.nextCycle();
                boolean new_isCircular_value = false;
                if (isCircular_value != new_isCircular_value) {
                    state.setChangeInCycle();
                }
                isCircular_value = new_isCircular_value;
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                isCircular_computed = true;
                state.startLastCycle();
                boolean $tmp = false;
            } else {
                state.startResetCycle();
                boolean $tmp = false;
                isCircular_computed = false;
                isCircular_initialized = false;
            }
            state.leaveCircle();
        } else if (isCircular_cycle != state.cycle()) {
            isCircular_cycle = state.cycle();
            if (state.lastCycle()) {
                isCircular_computed = true;
                boolean new_isCircular_value = false;
                return new_isCircular_value;
            }
            if (state.resetCycle()) {
                isCircular_computed = false;
                isCircular_initialized = false;
                isCircular_cycle = null;
                return isCircular_value;
            }
            boolean new_isCircular_value = false;
            if (isCircular_value != new_isCircular_value) {
                state.setChangeInCycle();
            }
            isCircular_value = new_isCircular_value;
        } else {
        }
        return isCircular_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1133")
    public int indexInZ() {
        int indexInZ_value = -1;
        return indexInZ_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1138
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1138")
    public boolean isConsecutiveInZ(FAbstractVariable fv) {
        boolean isConsecutiveInZ_FAbstractVariable_value = false;
        return isConsecutiveInZ_FAbstractVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1596
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1596")
    public boolean isFixed() {
        boolean isFixed_value = true;
        return isFixed_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1599")
    public boolean isInitialParameter() {
        boolean isInitialParameter_value = false;
        return isInitialParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2291")
    public Set<FVariable> myParameterDependencies() {
        Set<FVariable> myParameterDependencies_value = Collections.emptySet();
        return myParameterDependencies_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2394
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2394")
    public boolean isDependentParameter() {
        boolean isDependentParameter_value = false;
        return isDependentParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2398
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2398")
    public boolean isIndependentParameter() {
        boolean isIndependentParameter_value = false;
        return isIndependentParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2654
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2654")
    public boolean isFVariable() {
        boolean isFVariable_value = false;
        return isFVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2657
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2657")
    public boolean isFRealVariable() {
        boolean isFRealVariable_value = false;
        return isFRealVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2660
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2660")
    public boolean isFFunctionVariable() {
        boolean isFFunctionVariable_value = false;
        return isFFunctionVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2663
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2663")
    public boolean isDifferentiatedVariable() {
        boolean isDifferentiatedVariable_value = false;
        return isDifferentiatedVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2667
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2667")
    public boolean isAbstractDerivativeVariable() {
        boolean isAbstractDerivativeVariable_value = false;
        return isAbstractDerivativeVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2670
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2670")
    public boolean isDerivativeVariable() {
        boolean isDerivativeVariable_value = false;
        return isDerivativeVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2673
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2673")
    public FVariable asFVariable() {
        {
                throw new UnsupportedOperationException("asFVariable() is not supported for class type " + getClass().getSimpleName());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2678
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2678")
    public FRealVariable asFRealVariable() {
        {
                throw new UnsupportedOperationException("asFRealVariable() is not supported for class type " + getClass().getSimpleName());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2683
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2683")
    public FDerivativeVariable asDerivativeVariable() {
        {
                throw new UnsupportedOperationException("isDerivativeVariable() is not supported for class type " + getClass().getSimpleName());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2688
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2688")
    public boolean isDummyDerivativeVariable() {
        boolean isDummyDerivativeVariable_value = false;
        return isDummyDerivativeVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2691
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2691")
    public boolean isNonDummyDerivativeVariable() {
        boolean isNonDummyDerivativeVariable_value = false;
        return isNonDummyDerivativeVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2695
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2695")
    public boolean isDynamicDerivativeVariable() {
        boolean isDynamicDerivativeVariable_value = false;
        return isDynamicDerivativeVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2698")
    public boolean isPreVariable() {
        boolean isPreVariable_value = false;
        return isPreVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2705
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2705")
    public boolean isAlgebraicVariable() {
        boolean isAlgebraicVariable_value = false;
        return isAlgebraicVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2708
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2708")
    public boolean isDiscreteVariable() {
        boolean isDiscreteVariable_value = false;
        return isDiscreteVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2711
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2711")
    public boolean isAlgebraicContinousRealVariable() {
        boolean isAlgebraicContinousRealVariable_value = false;
        return isAlgebraicContinousRealVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatCausality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatCausality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3118")
    public boolean isInput() {
        boolean isInput_value = false;
        return isInput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatCausality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatCausality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3120")
    public boolean isOutput() {
        boolean isOutput_value = false;
        return isOutput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3127
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3127")
    public boolean isReal() {
        boolean isReal_value = type().isReal();
        return isReal_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3128
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3128")
    public boolean isInteger() {
        boolean isInteger_value = type().isInteger();
        return isInteger_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3129")
    public boolean isBoolean() {
        boolean isBoolean_value = type().isBoolean();
        return isBoolean_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3130
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3130")
    public boolean isString() {
        boolean isString_value = type().isString();
        return isString_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3131")
    public boolean isRecord() {
        boolean isRecord_value = type().isRecord();
        return isRecord_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3132
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3132")
    public boolean isEnum() {
        boolean isEnum_value = type().isEnum();
        return isEnum_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3133")
    public boolean isExternalObject() {
        boolean isExternalObject_value = type().isExternalObject();
        return isExternalObject_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3137
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3137")
    public boolean isComposite() {
        boolean isComposite_value = isArray() || isRecord();
        return isComposite_value;
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3246
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3246")
    public FExp nominal() {
        {
                if (variability().fixedParameterOrLess()) {
                    return new FAbsExp(createAccessExp());
                } else {
                    return variableNominal();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect Nominals
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Nominals", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3255")
    public FExp variableNominal() {
        {
                return FExp.nominalDefault();
            }
    }
    /** @apilevel internal */
    private void nonDefiningUses_reset() {
        nonDefiningUses_computed = false;
        
        nonDefiningUses_value = null;
    }
    /** @apilevel internal */
    protected boolean nonDefiningUses_computed = false;

    /** @apilevel internal */
    protected Set<FAccessExp> nonDefiningUses_value;

    /**
     * All uses of this variable that are not the left-hand side of an equation. 
     * (Unless the variable has a binding expression, then this is the same as uses().)
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3282")
    public Set<FAccessExp> nonDefiningUses() {
        ASTState state = state();
        if (nonDefiningUses_computed) {
            return nonDefiningUses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        nonDefiningUses_value = nonDefiningUses_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        nonDefiningUses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return nonDefiningUses_value;
    }
    /** @apilevel internal */
    private Set<FAccessExp> nonDefiningUses_compute() {
            Set<FAccessExp> res = new HashSet<FAccessExp>();
            for (FAccessExp use : uses())
                if (hasBindingExp() || !use.isLeftHandSide())
                    res.add(use);
            return res;
        }
    /** @apilevel internal */
    private void definingUses_reset() {
        definingUses_computed = false;
        
        definingUses_value = null;
    }
    /** @apilevel internal */
    protected boolean definingUses_computed = false;

    /** @apilevel internal */
    protected Set<FAccessExp> definingUses_value;

    /**
     * All uses of this variable that are the left-hand side of an equation. 
     * (Unless the variable has a binding expression, then this is empty.)
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3294
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3294")
    public Set<FAccessExp> definingUses() {
        ASTState state = state();
        if (definingUses_computed) {
            return definingUses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        definingUses_value = definingUses_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        definingUses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return definingUses_value;
    }
    /** @apilevel internal */
    private Set<FAccessExp> definingUses_compute() {
            if (hasBindingExp()) {
                return Collections.emptySet();
            } else {
                Set<FAccessExp> res = new HashSet<FAccessExp>();
                for (FAccessExp use : uses())
                    if (use.isLeftHandSide())
                        res.add(use);
                return res;
            }
        }
    /** @apilevel internal */
    private void dependentRealParameters_reset() {
        dependentRealParameters_computed = false;
        
        dependentRealParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean dependentRealParameters_computed = false;

    /** @apilevel internal */
    protected Collection<FRealVariable> dependentRealParameters_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3406")
    public Collection<FRealVariable> dependentRealParameters() {
        ASTState state = state();
        if (dependentRealParameters_computed) {
            return dependentRealParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependentRealParameters_value = FClass.filterCollection(dependentParameters(), FClass.REAL_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependentRealParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependentRealParameters_value;
    }
    /** @apilevel internal */
    private void dependentIntegerParameters_reset() {
        dependentIntegerParameters_computed = false;
        
        dependentIntegerParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean dependentIntegerParameters_computed = false;

    /** @apilevel internal */
    protected Collection<FIntegerVariable> dependentIntegerParameters_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3409")
    public Collection<FIntegerVariable> dependentIntegerParameters() {
        ASTState state = state();
        if (dependentIntegerParameters_computed) {
            return dependentIntegerParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependentIntegerParameters_value = FClass.filterCollection(dependentParameters(), FClass.INTEGER_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependentIntegerParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependentIntegerParameters_value;
    }
    /** @apilevel internal */
    private void dependentEnumParameters_reset() {
        dependentEnumParameters_computed = false;
        
        dependentEnumParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean dependentEnumParameters_computed = false;

    /** @apilevel internal */
    protected Collection<FEnumVariable> dependentEnumParameters_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3412")
    public Collection<FEnumVariable> dependentEnumParameters() {
        ASTState state = state();
        if (dependentEnumParameters_computed) {
            return dependentEnumParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependentEnumParameters_value = FClass.filterCollection(dependentParameters(), FClass.ENUM_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependentEnumParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependentEnumParameters_value;
    }
    /** @apilevel internal */
    private void dependentBooleanParameters_reset() {
        dependentBooleanParameters_computed = false;
        
        dependentBooleanParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean dependentBooleanParameters_computed = false;

    /** @apilevel internal */
    protected Collection<FBooleanVariable> dependentBooleanParameters_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3415
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3415")
    public Collection<FBooleanVariable> dependentBooleanParameters() {
        ASTState state = state();
        if (dependentBooleanParameters_computed) {
            return dependentBooleanParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependentBooleanParameters_value = FClass.filterCollection(dependentParameters(), FClass.BOOLEAN_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependentBooleanParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependentBooleanParameters_value;
    }
    /** @apilevel internal */
    private void dependentStringParameters_reset() {
        dependentStringParameters_computed = false;
        
        dependentStringParameters_value = null;
    }
    /** @apilevel internal */
    protected boolean dependentStringParameters_computed = false;

    /** @apilevel internal */
    protected Collection<FStringVariable> dependentStringParameters_value;

    /**
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3418")
    public Collection<FStringVariable> dependentStringParameters() {
        ASTState state = state();
        if (dependentStringParameters_computed) {
            return dependentStringParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependentStringParameters_value = FClass.filterCollection(dependentParameters(), FClass.STRING_VARIABLE_FILTER);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependentStringParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependentStringParameters_value;
    }
    /**
     * Get the pre variable connected to a normal variable, if any.
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3612
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3612")
    public FAbstractVariable myPreVariable() {
        FAbstractVariable myPreVariable_value = getFAccess().myPreFV();
        return myPreVariable_value;
    }
    /**
     * Get the normal variable connected to a pre variable.
     * 
     * Will be unknown for non-pre variables.
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3619
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3619")
    public FAbstractVariable myNonPreVariable() {
        FAbstractVariable myNonPreVariable_value = getFAccess().myFV();
        return myNonPreVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:82
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:82")
    public FAttribute findHierarchicalAttribute(FAccessFull name) {
        FAttribute findHierarchicalAttribute_FAccessFull_value = findHierarchicalAttribute(name, name.numParts());
        return findHierarchicalAttribute_FAccessFull_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:85
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:85")
    public FAttribute findHierarchicalAttribute(FAccessFull name, int n) {
        FAttribute findHierarchicalAttribute_FAccessFull_int_value = null;
        return findHierarchicalAttribute_FAccessFull_int_value;
    }
    /**
     * Return the maximum numeric value that this variable can take.
     * 
     * Only implemented for Real and Integer variables.
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:282")
    public double maxRealValue() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * Return the minimum numeric value that this variable can take.
     * 
     * Only implemented for Real and Integer variables.
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:291")
    public double minRealValue() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * @attribute syn
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:179
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:179")
    public boolean hasBindingExp() {
        boolean hasBindingExp_value = false;
        return hasBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:181
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:181")
    public boolean hasParameterEquation() {
        boolean hasParameterEquation_value = !hasBindingExp() && parameterEquation() != null;
        return hasParameterEquation_value;
    }
    /** @apilevel internal */
    private void myFRecordDecl_reset() {
        myFRecordDecl_computed = false;
        
        myFRecordDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFRecordDecl_computed = false;

    /** @apilevel internal */
    protected FRecordDecl myFRecordDecl_value;

    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290")
    public FRecordDecl myFRecordDecl() {
        ASTState state = state();
        if (myFRecordDecl_computed) {
            return myFRecordDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFRecordDecl_value = null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFRecordDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFRecordDecl_value;
    }
    /** @apilevel internal */
    private void myFEnumDecl_reset() {
        myFEnumDecl_computed = false;
        
        myFEnumDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFEnumDecl_computed = false;

    /** @apilevel internal */
    protected FEnumDecl myFEnumDecl_value;

    /**
     * @attribute syn
     * @aspect FlatEnumBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:321")
    public FEnumDecl myFEnumDecl() {
        ASTState state = state();
        if (myFEnumDecl_computed) {
            return myFEnumDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFEnumDecl_value = null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFEnumDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFEnumDecl_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:392
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:392")
    public boolean isUnknown() {
        boolean isUnknown_value = false;
        return isUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:256
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:256")
    public FAccess getFAccess() {
        FAccess getFAccess_value = null;
        return getFAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:336
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:336")
    public String qualifiedName() {
        String qualifiedName_value = name();
        return qualifiedName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344")
    public String name() {
        String name_value = null;
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418")
    public String nameUnderscore() {
        String nameUnderscore_value = null;
        return nameUnderscore_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:453
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:453")
    public int variableIndex() {
        int variableIndex_value = findVariableIndex();
        return variableIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104")
    public String displayName() {
        String displayName_value = name();
        return displayName_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:250")
    public boolean isConstant() {
        boolean isConstant_value = false;
        return isConstant_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:251
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:251")
    public boolean isParameter() {
        boolean isParameter_value = false;
        return isParameter_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:252")
    public boolean isDiscrete() {
        boolean isDiscrete_value = false;
        return isDiscrete_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:253
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:253")
    public boolean isContinuous() {
        boolean isContinuous_value = false;
        return isContinuous_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:552
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:552")
    public TypePrefixVariability variabilityHierarchical(FAccessFull name, int i) {
        {
                TypePrefixVariability res = variability();
                if (i < name.getNumFAccessPart()) {
                    FAccessPart part = name.getFAccessPart(i);
                    res = res.combine().combineDown(myFRecordDecl().lookupFV(part.getName()).variabilityHierarchical(name, i + 1));
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1233")
    public boolean isTemporary() {
        boolean isTemporary_value = false;
        return isTemporary_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1236
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1236")
    public boolean isInterface() {
        boolean isInterface_value = false;
        return isInterface_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1239
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1239")
    public boolean isFromExpandableConnector() {
        boolean isFromExpandableConnector_value = false;
        return isFromExpandableConnector_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:164")
    public boolean canBeAlias() {
        boolean canBeAlias_value = false;
        return canBeAlias_value;
    }
    /**
     * Check if an FVariable is an alias.
     * 
     * Returns true if alias, else false.
     * 
     * @return True if alias, else false.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:34
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:34")
    public boolean isAlias() {
        boolean isAlias_value = false;
        return isAlias_value;
    }
    /**
     * Get the model variable corresponding to the alias.
     * 
     * If the FVariable is an alias, the alias() return corresponding model
     * FVariable, else null.
     * 
     * @return The corresponding model variable if alias, otherwise null.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:52
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:52")
    public FVariable alias() {
        FVariable alias_value = null;
        return alias_value;
    }
    /**
     * Returns true if the alias is negated otherwise false.
     * 
     * @return True if negated alias, otherwise false.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:68
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:68")
    public boolean isNegated() {
        boolean isNegated_value = false;
        return isNegated_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1055
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeRewriting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1055")
    public FVariable derivativeEquivalent() {
        FVariable derivativeEquivalent_value = null;
        return derivativeEquivalent_value;
    }
    /**
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:86")
    public boolean canPropagate() {
        boolean canPropagate_value = false;
        return canPropagate_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:57")
    public DynamicStateSet dynamicStateSet() {
        DynamicStateSet dynamicStateSet_value = null;
        return dynamicStateSet_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:60")
    public int dynamicStateVarIndex() {
        int dynamicStateVarIndex_value = dynamicStateSet().varIndex(this);
        return dynamicStateVarIndex_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:62
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:62")
    public boolean isDynamicState() {
        boolean isDynamicState_value = dynamicStateSet() != null;
        return isDynamicState_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:64
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:64")
    public boolean isFDynamicStateVariable() {
        boolean isFDynamicStateVariable_value = false;
        return isFDynamicStateVariable_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:67
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:67")
    public FDynamicStateVariable asFDynamicStateVariable() {
        {
                throw new UnsupportedOperationException("Unable to convert " + getClass().getSimpleName() + " to FDynamicStateVariable!");
            }
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:72
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:72")
    public boolean isFDynamicAlgebraicVariable() {
        boolean isFDynamicAlgebraicVariable_value = false;
        return isFDynamicAlgebraicVariable_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:75
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:75")
    public FDynamicAlgebraicVariable asFDynamicAlgebraicVariable() {
        {
                throw new UnsupportedOperationException("Unable to convert " + getClass().getSimpleName() + " to FDynamicAlgebraicVariable!");
            }
    }
    /**
     * Check if this variable is marked as being set by a reinit().
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:261")
    public boolean isSetInReinit() {
        boolean isSetInReinit_value = false;
        return isSetInReinit_value;
    }
    /**
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1339
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1339")
    public StateSelect stateSelection() {
        {
                throw new UnsupportedOperationException("Unable to get state select from variable type " + getClass().getSimpleName());
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:271")
    public String funcArrayType(boolean assign) {
        String funcArrayType_boolean_value = isRecord() ? C_ARRAY_RECORD : (assign ? C_ARRAY_REFERENCE : C_ARRAY_VALUE);
        return funcArrayType_boolean_value;
    }
    /** @apilevel internal */
    private void name_C_reset() {
        name_C_computed = false;
        
        name_C_value = null;
    }
    /** @apilevel internal */
    protected boolean name_C_computed = false;

    /** @apilevel internal */
    protected String name_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279")
    public String name_C() {
        ASTState state = state();
        if (name_C_computed) {
            return name_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_C_value = null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:293
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:293")
    public String preName_C() {
        String preName_C_value = null;
        return preName_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:610
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:610")
    public boolean needsScaling(WriteBackContext ctx) {
        boolean needsScaling_WriteBackContext_value = isReal() && myOptions().getBooleanOption("enable_variable_scaling") && !ctx.inFunction();
        return needsScaling_WriteBackContext_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1286
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1286")
    public boolean needsTemp_C() {
        { return false; }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:268")
    public ExternalArgument externalArgument(FExp exp) {
        ExternalArgument externalArgument_FExp_value = exp;
        return externalArgument_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:33
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:33")
    public String tempName_C() {
        { throw new UnsupportedOperationException(); }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:18
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:18")
    public String type_C(CodePrinter p) {
        String type_C_CodePrinter_value = type().type_C(p);
        return type_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:159")
    public FExp myBackingFExp() {
        FExp myBackingFExp_value = null;
        return myBackingFExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:163
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:163")
    public boolean useAlias_C() {
        boolean useAlias_C_value = true;
        return useAlias_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:184")
    public String alias_C(CodePrinter p) {
        String alias_C_CodePrinter_value = p.getExecStep().name(this);
        return alias_C_CodePrinter_value;
    }
    /** @apilevel internal */
    private void asMXVector_reset() {
        asMXVector_computed = false;
        
        asMXVector_value = null;
    }
    /** @apilevel internal */
    protected boolean asMXVector_computed = false;

    /** @apilevel internal */
    protected MXVector asMXVector_value;

    /**
     * For retrieving the MXVector representation of this variable.
     * Some variables, e.g. FFunctionArray can only be represented
     * as MXVector
     * @return A MXVector
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:475
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:475")
    public MXVector asMXVector() {
        ASTState state = state();
        if (asMXVector_computed) {
            return asMXVector_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        asMXVector_value = asMXVector_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        asMXVector_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return asMXVector_value;
    }
    /** @apilevel internal */
    private MXVector asMXVector_compute() {
            MXVector MXVec = new MXVector();
            MXVec.add(asMXVariable());
            return MXVec;
        }
    /** @apilevel internal */
    private void asMXVariable_reset() {
        asMXVariable_computed = false;
        
        asMXVariable_value = null;
    }
    /** @apilevel internal */
    protected boolean asMXVariable_computed = false;

    /** @apilevel internal */
    protected MX asMXVariable_value;

    /**
     * For retrieving the MX representation of this variable.
     * Note that some variables can not be represented as a single MX, e.g.
     * FFunctionArray. These may need to be represented as MXVector.
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486")
    public MX asMXVariable() {
        ASTState state = state();
        if (asMXVariable_computed) {
            return asMXVariable_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        asMXVariable_value = asMXVariable_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        asMXVariable_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return asMXVariable_value;
    }
    /** @apilevel internal */
    private MX asMXVariable_compute() {
            throw new UnsupportedOperationException("Cannot convert variable to MX: " + toString());
        }
    /**
     * The value reference value is represented by a 32 bit unsigned integer 
     * variable. The lowest 27 bits is used to represent the index of a 
     * variable of the corresponding variable vector. Real, Integer, Boolean and 
     * enumeration variables share a vector, while String variables has their 
     * own vector. 
     * Bit 28 is reserved for representing negated/not negated.
     * Bits 29-31 represents the primitive type, where:
     * 0: Real
     * 1: Integer or enumeration
     * 2: Boolean
     * 3: String
     * Bit 32 is left unused.
     * 
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1118")
    public int valueReference() {
        ASTState state = state();
        if (valueReference_computed) {
            return valueReference_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        valueReference_value = getParent().Define_valueReference(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        valueReference_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return valueReference_value;
    }
    /** @apilevel internal */
    private void valueReference_reset() {
        valueReference_computed = false;
    }
    /** @apilevel internal */
    protected boolean valueReference_computed = false;

    /** @apilevel internal */
    protected int valueReference_value;

    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2314")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3140")
    public boolean inRecord() {
        boolean inRecord_value = getParent().Define_inRecord(this, null);
        return inRecord_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3190
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3190")
    public FRecordDecl containingRecordDecl() {
        FRecordDecl containingRecordDecl_value = getParent().Define_containingRecordDecl(this, null);
        return containingRecordDecl_value;
    }
    /**
     * @attribute inh
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:169
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:169")
    public boolean isForIndex() {
        boolean isForIndex_value = getParent().Define_isForIndex(this, null);
        return isForIndex_value;
    }
    /**
     * @attribute inh
     * @aspect ParameterEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ParameterEquations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:184")
    public FAbstractEquation parameterEquation() {
        ASTState state = state();
        if (parameterEquation_computed) {
            return parameterEquation_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        parameterEquation_value = getParent().Define_parameterEquation(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        parameterEquation_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return parameterEquation_value;
    }
    /** @apilevel internal */
    private void parameterEquation_reset() {
        parameterEquation_computed = false;
        
        parameterEquation_value = null;
    }
    /** @apilevel internal */
    protected boolean parameterEquation_computed = false;

    /** @apilevel internal */
    protected FAbstractEquation parameterEquation_value;

    /**
     * @attribute inh
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:460")
    public int findVariableIndex() {
        int findVariableIndex_value = getParent().Define_findVariableIndex(this, null);
        return findVariableIndex_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872")
    public String myForIndexName() {
        String myForIndexName_value = getParent().Define_myForIndexName(this, null);
        return myForIndexName_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876")
    public FExp scalarizeIterIndex(Scalarizer s) {
        FExp scalarizeIterIndex_Scalarizer_value = getParent().Define_scalarizeIterIndex(this, null, s);
        return scalarizeIterIndex_Scalarizer_value;
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
     * Collection attribute returning all variable uses in expressions.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3273
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3273")
    public HashSet<FAccessExp> uses() {
        ASTState state = state();
        if (FAbstractVariable_uses_computed) {
            return FAbstractVariable_uses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractVariable_uses_value = uses_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractVariable_uses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractVariable_uses_value;
    }
    /** @apilevel internal */
    private HashSet<FAccessExp> uses_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FClass)) {
            node = node.getParent();
        }
        FClass root = (FClass) node;
        root.survey_FAbstractVariable_uses();
        HashSet<FAccessExp> _computedValue = new LinkedHashSet<>();
        if (root.contributorMap_FAbstractVariable_uses.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractVariable_uses.get(this)) {
                contributor.contributeTo_FAbstractVariable_uses(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractVariable_uses_computed = false;

    /** @apilevel internal */
    protected HashSet<FAccessExp> FAbstractVariable_uses_value;

    /**
     * Collection attribute returning all dependent parameters which
     * depends on the parameter.
     * @attribute coll
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3399")
    public HashSet<FVariable> dependentParameters() {
        ASTState state = state();
        if (FAbstractVariable_dependentParameters_computed) {
            return FAbstractVariable_dependentParameters_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAbstractVariable_dependentParameters_value = dependentParameters_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FAbstractVariable_dependentParameters_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FAbstractVariable_dependentParameters_value;
    }
    /** @apilevel internal */
    private HashSet<FVariable> dependentParameters_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FlatRoot)) {
            node = node.getParent();
        }
        FlatRoot root = (FlatRoot) node;
        root.survey_FAbstractVariable_dependentParameters();
        HashSet<FVariable> _computedValue = new LinkedHashSet<FVariable>();
        if (root.contributorMap_FAbstractVariable_dependentParameters.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FAbstractVariable_dependentParameters.get(this)) {
                contributor.contributeTo_FAbstractVariable_dependentParameters(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FAbstractVariable_dependentParameters_computed = false;

    /** @apilevel internal */
    protected HashSet<FVariable> FAbstractVariable_dependentParameters_value;

}
