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
 * Array constructor expression.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1099
 * @astdecl FArray : FAbstractArrayExp ::= FExp*;
 * @production FArray : {@link FAbstractArrayExp} ::= <span class="component">{@link FExp}*</span>;

 */
public class FArray extends FAbstractArrayExp implements Cloneable {
    /**
     * Add a copy of the expression at position i to arr. 
     * 
     * @param arr    the Array to add the expression to.
     * @param i      the index to add at, denotes position in both Array and FArray.
     * @param level  the level this FArray is at in a structure of nestled FArrays.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1865
     */
    public void fillArray(ArrayExp arr, Index i, int level) {
	    if (isIterArray())
	        super.fillArray(arr, i, level);
	    else
	        getFExp(i.get(level) - 1).fillArray(arr, i, level + 1);
	}
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:102
     */
    public FExp extractRecordFExp(String suffix) {
        FArray res = createEmptyNode();
        for (FExp e : getFExps())
            res.addFExp(e.extractRecordFExp(suffix));
        return res;
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:5109
     */
    public void mapComponents(Map<FAccessExp, Set<FAccessExp>> res, CValue val) {
        Enumerator e = new Enumerator();
        mapComponentsArray(res, val.array(), e);
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:5118
     */
    public void mapComponentsArray(Map<FAccessExp, Set<FAccessExp>> res, CValueArray val, Enumerator e) {
        for (FExp exp : getFExps()) {
            exp.mapComponentsArray(res, val, e);
        }
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:987
     */
    public FArray createEmptyNode()          { return new FArray();          }
    /**
     * Create new node of same class as this, with the specified 
     * children.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1257
     */
    public FArray createNode(List<FExp> exps) {
		FArray node = createEmptyNode();
		node.setFExpList(exps);
		return node;
	}
    /**
     * Create new node of same class as this, with the specified 
     * children.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1267
     */
    public FArray createNode(ArrayList<FExp> exps) {
		FArray node = createEmptyNode();
		for (FExp e : exps)
			node.addFExp(e);
		return node;
	}
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1932
     */
    public void flatChildFExps(ArrayList<FExp> res) {
        for (FExp exp : getFExps()) {
            exp.flatChildFExps(res);
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1915
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
		str.print("{");
		getFExps().prettyPrintWithSep(p, str, indent, ", ");
		str.print("}");
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:366
     */
    public void makeContinuousVariablesDiscrete() {
        for (FExp e : getFExps())
            e.makeContinuousVariablesDiscrete();
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2383
     */
    public FExp flatten(Flattener f) {
        if (isIterArray() && !size().isUnknown()) {
            return ((FIterExp)getFExp(0)).flattenArray(f);
        }
        List l = new List();
        for (FExp exp : getFExps()) {
            l.add(exp.flatten(f));
        }
        return createNode(l);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2599
     */
    public FExp createFPreExp() {
        return this; // Assume literal;
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:962
     */
    @Override
    public void insertTempsInLHS(FClass fClass, boolean param) {
        for (FExp fExp : getFExps()) {
            fExp.insertTempsInLHS(fClass, param);
        }
    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:103
     */
    public void findBlockFunctionExtraction(AbstractEquationBlock block, ArrayList<FFunctionCall> functions) {
        for (FExp exp: getFExps()) {
            exp.findBlockFunctionExtraction(block, functions);
        }

    }
    /**
     * @aspect BlockFunctionExtraction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\BlockFunctionExtraction.jrag:140
     */
    public boolean dependsOnBlock(AbstractEquationBlock block) {
        for (FExp exp: getFExps()) {
            if (exp.dependsOnBlock(block)) {
                return true;
            }
        }
        return false;
    }
    /**
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:215
     */
    public FExp merge(FClass.commonSubexpressionEliminationIfSet.CSESet m, FExp exp) {
        FArray other = (FArray) exp;
        for (int i = 0; i < getNumFExp(); i++) {
            setFExp(getFExp(i).merge(m, other.getFExp(i)), i);
        }
        return this;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:580
     */
    public FExp createInlineVars(
            AbstractFunctionInliner fi, FExp bExp, TypePrefixVariability variability) {
        FArray bArr = (FArray) bExp;
        FArray res = new FArray();
        int n = getNumFExp();
        for (int i = 0; i < n; i++) {
            FExp cellBExp = (bArr != null) ? bArr.getFExp(i) : null;
            res.addFExp(getFExp(i).createInlineVars(fi, cellBExp, variability));
        }
        return res;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:869
     */
    public void createInliningOutputEquations(
            ArrayList<FAbstractEquation> list, AbstractFunctionInliner fi, FAccess name) {
        int i = 1;
        for (FExp exp : getFExps()) {
            FAccess cellName = name.copyAndAddSubscript(i);
            exp.createInliningOutputEquations(list, fi, cellName);
            i++;
        }
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:447
     */
    @Override
    public boolean variabilityPropagation(
            FClass.VariabilityPropagator propagator,
            CValue value,
            TypePrefixVariability variability) {
        
        if (taggedByVProp) {
            return taggedByVProp;
        }
        
        CValueArray a = null;
        if (value != CValue.UNKNOWN) {
            a = (CValueArray) value;
        }
        taggedByVProp = variabilityPropagationArray(propagator, a, variability, new Enumerator());
        return taggedByVProp;
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:474
     */
    @Override
    public boolean variabilityPropagationArray(
            FClass.VariabilityPropagator propagator,
            CValueArray value,
            TypePrefixVariability variability,
            Enumerator enumerator) {
        boolean res = true;
        for (FExp exp : getFExps()) {
            res &= exp.variabilityPropagationArray(propagator, value, variability, enumerator);
        }
        return res;
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:700
     */
    @Override
    public FExp cleanEquations() {
        if (taggedByVProp) {
            return super.cleanEquations();
        }
        FArray res = new FArray();
        for (FExp exp : getFExps()) {
            res.addFExpNoTransform(exp.cleanEquations());
        }
        return res;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1120
     */
    public FExp scalarRecordFExp(Scalarizer s, FAccess suffix) {
        if (useTempVar) {
            return tempExp().scalarRecordFExp(s, suffix);
        }
        if (isIterArray())
            return super.scalarRecordFExp(s, suffix);
        FArray res = createEmptyNode();
        for (FExp e : getFExps())
            res.addFExp(e.scalarRecordFExp(s, suffix));
        return res;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1479
     */
    public FExp scalarizeExp(Scalarizer s) {
		if (isIterArray())
			return getFExp(0).scalarize(s);
		FArray res = new FArray();
		for (FExp e : getFExps())
			res.addFExpNoTransform(e.scalarize(s));
		return res;
	}
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:493
     */
    public void unknownFunctionArrayTemporaries(Scalarizer s) {
        s.addTempVar(this);
        ForNames names = s.getNames();
        boolean iter = isIterArray();
        names.addLayer(ndims()- (iter ? 0 : 1));
        names.fillLayer(this);

        for (int i = 0; i < getNumFExp(); i++) {
            List<FStatement> inner = new List<FStatement>();
            List<FStatement> outer = s.getClauses();
            FExp right = getFExp(i);
            FAccessExp left;
            if (iter) {
                left = tempExp(names.createFArraySubscripts());
                getFExp(0).editNamesIter(s);
                right.createArrayTemporaries(s.block(inner));
                right.addArrayUsesToIndexMap(s);
                names.removeLayer();
                right = ((FIterExp) right).getFExp();
            } else {
                List<FSubscript> subs = new List<FSubscript>();
                subs.add(new FIntegerSubscript(i+1));
                subs.addAll(names.createFArraySubscripts().copyAsFArrayExpSubscripts().getFSubscriptListNoTransform());
                left = tempExp(new FArrayExpSubscripts(subs));
                right.createArrayTemporaries(s);
                right.addArrayUsesToIndexMap(s);
            }
            type().scalarizeAssignment_sub((Scalarizer.Algorithm)s.block(inner), left, right);
            s.createForLoops(inner, getFExp(i));
        }

        names.removeLayer();
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:653
     */
    @Override
    protected FExp diffExp(String name) {
        FArray diff_farray = new FArray();
        for (FExp e : getFExps()) {
            diff_farray.addFExp(e.diff(name));
        }
        return diff_farray;
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:408
     */
    public void collectArrayElementsForGenGlobalVariableInitFunc_C(ArrayList<GlobalVariableArrayElement> list) {
        String name = tempName_C();
        String type = type().isRecord() ? C_ARRAY_RECORD : C_ARRAY_VALUE;
        String pre = String.format("jmi_array_%s_%d(%s, ", type, ndims(), name);
        for (Index i : indices()) {
            final String cellName = pre + i.toUnclosedString() + ")";
            final FExp cellExp = fArrayCell(i, 0);
            list.add(new GlobalVariableArrayElement() {
                public void gen(CodePrinter p, CodeStream str, String indent) {
                    cellExp.genGlobalVariableInitCall_C(p, str, indent, cellName, true);
                }
                public int numScalars_C() {
                    return cellExp.numScalarsGlobals_C();
                }
            });
        }
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:453
     */
    @Override
    public void genGlobalVariableInitFuncDecl_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent, "JMI_ARR(",
                "DYNA", ", ", 
                type().nameScalar_C(p, false), ", ",
                type().nameArray_C(p, false), ", ",
                tempName_C(), ", ");
        type().size().printNumElements_C(p, str, indent, this);
        str.print(", ");
        str.print(type().ndims());
        str.print(")\n");
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:466
     */
    @Override
    public void genGlobalVariableInitFuncInit_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent, "JMI_ARRAY_INIT_", ndims(), "(",
                "DYNA", ", ", 
                type().nameScalar_C(p, false), ", ",
                type().nameArray_C(p, false), ", ",
                tempName_C(), ", ");
        type().size().printNumElements_C(p, str, indent, this);
        str.print(", ");
        str.print(type().ndims());
        str.print(", ");
        type().size().printDimensions_C(p, str, indent, this);
        str.print(")\n");
    }
    /**
     * @aspect CCodeGenGlobalVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:493
     */
    public void genGlobalVariableInitCall_C(CodePrinter p, CodeStream str, String indent, String name, boolean expand) {
        str.print(indent, name, " = jmi_global_", tempName_C(), "(jmi);\n");
    }
    /**
     * @declaredat ASTNode:1
     */
    public FArray() {
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
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FExp"},
        type = {"List<FExp>"},
        kind = {"List"}
    )
    public FArray(List<FExp> p0) {
        setChild(p0, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:29
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:41
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public FArray clone() throws CloneNotSupportedException {
        FArray node = (FArray) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public FArray copy() {
        try {
            FArray node = (FArray) clone();
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
     * @declaredat ASTNode:69
     */
    @Deprecated
    public FArray fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public FArray treeCopyNoTransform() {
        FArray tree = (FArray) copy();
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
     * @declaredat ASTNode:104
     */
    public FArray treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:109
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FExp list.
     * @param list The new list node to be used as the FExp list.
     * @apilevel high-level
     */
    public void setFExpList(List<FExp> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FExp list.
     * @return Number of children in the FExp list.
     * @apilevel high-level
     */
    public int getNumFExp() {
        return getFExpList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FExp list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FExp list.
     * @apilevel low-level
     */
    public int getNumFExpNoTransform() {
        return getFExpListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FExp list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FExp list.
     * @apilevel high-level
     */
    public FExp getFExp(int i) {
        return (FExp) getFExpList().getChild(i);
    }
    /**
     * Check whether the FExp list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFExp() {
        return getFExpList().getNumChild() != 0;
    }
    /**
     * Append an element to the FExp list.
     * @param node The element to append to the FExp list.
     * @apilevel high-level
     */
    public void addFExp(FExp node) {
        List<FExp> list = (parent == null) ? getFExpListNoTransform() : getFExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFExpNoTransform(FExp node) {
        List<FExp> list = getFExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FExp list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFExp(FExp node, int i) {
        List<FExp> list = getFExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FExp list.
     * @return The node representing the FExp list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FExp")
    public List<FExp> getFExpList() {
        List<FExp> list = (List<FExp>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FExp list.
     * @apilevel low-level
     */
    public List<FExp> getFExpListNoTransform() {
        return (List<FExp>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FExp list without
     * triggering rewrites.
     */
    public FExp getFExpNoTransform(int i) {
        return (FExp) getFExpListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FExp list.
     * @return The node representing the FExp list.
     * @apilevel high-level
     */
    public List<FExp> getFExps() {
        return getFExpList();
    }
    /**
     * Retrieves the FExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FExp list.
     * @apilevel low-level
     */
    public List<FExp> getFExpsNoTransform() {
        return getFExpListNoTransform();
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
        ndims_value = ndims_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /** @apilevel internal */
    private int ndims_compute() {
    		if (isIterArray())
    			return getFExp(0).ndims();
    		if (getNumFExp()==0)  //Empty array
    			return 1;
    		// We assume that the FArray is set up correctly and that
    		// all branches are equal.
    		return getFExp(0).ndims() + 1;
    	}
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:820
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:820")
    public boolean isZeroLiteral() {
        {
                for (FExp e : getFExps()) {
                    if (!e.isZeroLiteral()) {
                        return false;
                    }
                }
                return true;
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
    	    if (getFExp(0) == null)
    	        return new Size(0);
    		if (isIterArray())
    			return getFExp(0).size();
    		return getFExp(0).size().expand(getNumFExp());
    	}
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1346
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1346")
    public boolean canBuildArrayFromChild() {
        boolean canBuildArrayFromChild_value = isIterArray();
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
        FExp childToBuildArray_value = getFExp(0);
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
    		for (Index i : arr.indices())
    			fillArray(arr, i, 0);
    		return arr;
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
        {
        	  CValueArray arr = val.array();
        	  for (Index i : indices()) {
        		  CValue res = getArray().get(i).extractCValue(arr.getCell(i), fv);
        		  if (res != null)
        			  return res;
        	  }
        	  return null;
          }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2065
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2065")
    public ArrayList<FExp> guards() {
        {
                ArrayList<FExp> l = new ArrayList<FExp>();
                for (FExp e : childFExps())
                    l.add(e);
                return l;
            }
    }
    /**
     * Get the number of scalar variables assigned by this a FFunctionCallLeft with this 
     * FExp as its expression.
     * 
     * Only valid after scalarization.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1503
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1503")
    public int numScalarVars() {
        {
                 int n = getNumFExp();
                 return (n == 0) ? 0 : n * getFExp(0).numScalarVars();
             }
    }
    /**
     * Check if this FArray is on the form "{exp for i in exp}".
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:647")
    public boolean isIterArray() {
        boolean isIterArray_value = getNumFExp() == 1 && getFExp(0).isIterExp();
        return isIterArray_value;
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
            if (isIterArray())
                return getFExp(0).type();
            
            // Check that the types of the elements are consistent
            int n = getNumFExp();
            FType t = n > 0 ? getFExp(0).type() : fUnknownType();
            boolean func = inFunction();
            for (int i = 1; i < n && !t.isUnknown(); i++) {
                t = mergeArrayCellTypes(t, getFExp(i).type(), func);
            }
            return t.arrayType(size());
        }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:675
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:675")
    public FType mergeArrayCellTypes(FType t1, FType t2, boolean func) {
        {
                if (t1.isNoType()) {
                    return t2;
                } else if (t2.isNoType()) {
                    return t1;
                } else {
                    return t1.typePromotion(t2, func, null);
                }
            }
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
        {
                if (isIterArray()) {
                    return getFExp(0).splitArrayExp(index);
                }
                
                if (getNumFExp() >= index ) {
                    return getFExp(index - 1);
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1970")
    public boolean isAnnotationExp() {
        boolean isAnnotationExp_value = getNumFExp() > 0;
        return isAnnotationExp_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:1978")
    public Iterable<? extends ASTNode> annotationList() {
        Iterable<? extends ASTNode> annotationList_value = getFExps();
        return annotationList_value;
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
        {
                for (FExp exp : getFExps()) {
                    if (!exp.canPropagate()) {
                        return false;
                    }
                }
                return true;
            }
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
        boolean extractTemp_value = extractTempArrayCon() && !keepSimple();
        return extractTemp_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:99
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:99")
    public boolean keepSimple() {
        boolean keepSimple_value = isFunctionCallIO() && !isFVectorFunctionCallArg()
                        && ndims() == 1 && !isIterArray() && type().isPrimitive();
        return keepSimple_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Array";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1583")
    public FAccessExp first() {
        FAccessExp first_value = getFExp(0).first();
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
                for (FExp exp : getFExps()) {
                    last = exp.consecutiveArray(last);
                    if (last == null) {
                        break;
                    }
                }
                return last;
            }
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:434")
    public FExp fArrayCell(Index i, int d) {
        FExp fArrayCell_Index_int_value = getFExp(i.get(d) - 1).fArrayCell(i, d + 1);
        return fArrayCell_Index_int_value;
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
                MXVector MXVec = new MXVector();
                for (FExp exp : getFExps()) {
                    MXVector expMXVec = exp.toMXVector();
                    for (int i = 0; i < expMXVec.size(); ++i) {
                        MXVec.add(expMXVec.get(i));
                    }
                }
                return MXVec;
            }
    }
    /**
     * @attribute inh
     * @aspect FlatAlgorithmAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAlgorithmAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242")
    public boolean useIsAssignment() {
        boolean useIsAssignment_value = getParent().Define_useIsAssignment(this, null);
        return useIsAssignment_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:279")
    public boolean canInlineConstant() {
        boolean canInlineConstant_value = getParent().Define_canInlineConstant(this, null);
        return canInlineConstant_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     */
    public boolean Define_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isLeftHandSide();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     */
    public boolean Define_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4248
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return useIsAssignment();
        }
        else {
            return super.Define_useIsAssignment(_callerNode, _childNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     */
    public boolean Define_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFArray
     */
    protected boolean canDefine_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     * @apilevel internal
     */
    public boolean Define_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpUseOK
     */
    protected boolean canDefine_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return canInlineConstant();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
