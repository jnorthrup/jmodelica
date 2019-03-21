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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:43
 * @astdecl InstClassDecl : InstBaseNode ::= <SrcClassDecl:SrcClassDecl> [ClassAnnotation:InstClassModification] FunctionType:FType;
 * @production InstClassDecl : {@link InstBaseNode} ::= <span class="component">&lt;SrcClassDecl:SrcClassDecl&gt;</span> <span class="component">[ClassAnnotation:{@link InstClassModification}]</span> <span class="component">FunctionType:{@link FType}</span>;

 */
public abstract class InstClassDecl extends InstBaseNode implements Cloneable, InstLookupResult.Item, InstRedeclareClassNode, InstCallable {
    /**
     * Constant-evaluate function with given set of arguments and return value for first output.
     * 
     * @param args  arguments of the function call
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3768
     */
    public CValue evaluateFirst(VariableEvaluator evaluator, Iterable<FExp> args) {
        Map<CommonVariableDecl, CValue> values = new HashMap<CommonVariableDecl, CValue>();
        int i = 0;
        for (FExp arg : args) {
            if (i < myInputs().size()) {
                CommonVariableDecl cvd = myInputs().get(i);
                if (cvd.type().typeCompatible(arg.type(), true)) {
                    values.put(cvd, arg.ceval(evaluator));
                } else {
                    InstClassDecl constructor = cvd.type().matchOverloadedConstructor(arg.type());
                    ArrayList<FExp> l = new ArrayList<FExp>();
                    l.add(arg);
                    CValue v = constructor.evaluateFirst(evaluator, l);
                    values.put(cvd, v);
                }
            } else {
                throw new ConstantEvaluationException();
            }
            i++;
        }
        
        evaluate(evaluator, values);
        
        CValue res = myOutputs().isEmpty() ? null : values.get(myOutputs().get(0));
        return (res == null) ? CValue.UNKNOWN : res;
    }
    /**
     * Perform constant evaluation of functions.
     * 
     * @param values  constant values for the variables. 
     * Should be filled with the values of the inputs.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3801
     */
    public void evaluate(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        values.clear(); // Make sure evaluation returns CValue.UNKNOWN
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:293
     */
    public void contentCheck(ErrorCheckType checkType) {
        if (isExternalObject()) {
            checkContentsOKInExternalObject();
            myConstructor().checkConstructor(this);
            myDestructor().checkDestructor(this);
        }
        
        if (isFunction()) {
            for (InstComponentDecl icd : allInstComponentDecls()) {
                if (icd.definedVariability().constantVariability()) {
                    if (icd.isInput()) {
                        ASTNode.CONSTANT_INPUT.invoke(icd);
                    } else if (icd.hasBindingFExp()) {
                        icd.getBindingFExp().checkConstantExpression(checkType, "constant", icd.qualifiedName());
                    }
                }
            }
            for (AnnotationNode an : annotation()) {
                if (AnnotationNode.EXTERNAL_FUNCTION_ANNOTATIONS.contains(an.name())) {
                    ASTNode.EXTERNAL_FUNCTION_ANNOTATION.invoke(an.ast());
                }
            }
        }
        
        checkQuotedIdentifier(getSrcClassDecl().getName(), name());
        checkAbsoluteValue();
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:348
     */
    public void checkDestructor(InstClassDecl parent) {
		if (isUnknown())
			return;
		if (myOutputs().size() != 0 || myInputs().size() != 1 || !myInputs().get(0).type().compatibleDestructor(parent))
			error("An external object destructor must have exactly one input of the same type as the constructor, and no outputs");
	}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:355
     */
    public void checkConstructor(InstClassDecl parent) {
		if (isUnknown())
			return;
		if (myOutputs().size() != 1 || !myOutputs().get(0).type().compatibleConstructor(parent))
			error("An external object constructor must have exactly one output of the same type as the constructor");
	}
    /**
     * Perform content checks that are common to functions in operators and operator functions.
     * 
     * @param checkType  the kind of error checking being done
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:673
     */
    public void contentCheckAsOperatorFunction(ErrorCheckType checkType, FType type, String name) {
        boolean constr = FExp.CONSTRUCTOR_OPERATORS.contains(name);
        boolean conv   = FExp.CONVERSION_OPERATORS.contains(name);
        boolean binary = FExp.BINARY_OPERATORS.contains(name);
        boolean unary  = FExp.UNARY_OPERATORS.contains(name);
        int mandatory = 0;
        for (InstComponentDecl input : myInputs()) 
            if (!input.hasBindingFExp())
                mandatory++;
        
        String funcName = isOperator() ? "" : (name() + " ");
        if (myOutputs().size() != 1)
            error("Operator functions must have exactly one output, but %s has %d", name(), myOutputs().size());
        else if (constr && !myOutputs().get(0).type().equivalentTo(type))
            myOutputs().get(0).error("Output of operator record constructor must be of the type of the operator record the constructor belongs to");
        else if (conv) {
            FType expected = null;
            if (name.equals(FExp.OP_STR))
                expected = fStringScalarType();
            if (expected != null && !myOutputs().get(0).type().equivalentTo(expected))
                error("%s operator functions must have one output of type %s, but %sreturns %s", name, expected, funcName, myOutputs().get(0).type());
        }
        if (constr) {
            if (name.equals(FExp.OP_ZERO)) {
                if (!myInputs().isEmpty())
                    error("The '0' operator record constructor may not have any inputs, but %shas %d", funcName, myOutputs().size());
            } else if (mandatory == 1) {
                FType otherType = myInputs().get(0).type();
                if (otherType.matchOverloadedConstructor(type) != null) 
                    error("Ambiguous overloaded constructors in %s and %s", type, otherType);
            }
        } else {
            boolean typeOk = false;
            boolean orderOk = true;
            for (int i = 0, n = myInputs().size(); i < n; i++) { 
                InstComponentDecl inp = myInputs().get(i);
                if ((!conv || i == 0) && inp.type().scalarType().equivalentTo(type))
                    typeOk = true;
                if (inp.hasBindingFExp() && mandatory > i)
                    orderOk = false;
            }
            if (!typeOk)
                error((conv ? "First argument of conversion operator functions must be" : "Operator functions must have at least one argument that is") + 
                        " of the type of the operator record the function belongs to");
            if (!orderOk)
                error("All inputs without default value in operator function must be before all inputs with default value");
        }
        if (binary && unary) {
            if (mandatory < 1 || mandatory > 2)
                error("Operator functions for operators that are both unary and binary must have exactly 1 or 2 inputs without default value, but %s has %d", 
                        name(), mandatory);
        } else if (binary) {
            if (mandatory != 2)
                error("Operator functions for binary operators must have exactly 2 inputs without default value, but %s has %d", 
                        name(), mandatory);
        } else if (unary) {
            if (mandatory != 1)
                error("Operator functions for unary operators must have exactly 1 input without default value, but %s has %d", 
                        name(), mandatory);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:616
     */
    public void checkErrorsInModelInstance(String className, ErrorCheckType checkType) throws ModelicaClassNotFoundException {
        errorCheck(checkType);
    }
    /**
     * Check that the restriction of this class is fulfilled.
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:877
     */
    public void checkRestriction(ErrorCheckType checkType) {}
    /**
     * Check if class has exactly one algorithm section or external function declaration.
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1211
     */
    public boolean isCompleteFunction() {
        return (numFAlgorithm() == 1);
    }
    /**
     * Examine extends tree to find recursive extends nodes.
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1539
     */
    public void calcIsRecursive(HashSet<InstNode> visited) {
		for (InstExtends ie : getInstExtendss())
			ie.calcIsRecursive(visited);
	}
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1309
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        super.buildConnectionSets(prefix, csm, connect);
        getInstGeneratedInners().buildConnectionSets(prefix, csm, connect);
    }
    /**
     * Create a new FClass object.
     * 
     * Override for subclasses needing a subclass of FClass.
     * @aspect FlatTree
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:66
     */
    public FClass createFClass() {
        return new FClass();
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:90
     */
    public void flattenInstClassDecl(FClass fc) {
        int level = 1;
        HashMap<InstNode,Integer> oldLevels = setModificationLevel(level);
        beginStep("flattenInstClassDecl()");
        fc.setName(qualifiedName());
        buildConnectionSets(fc);
        breakOnErrors();
        beginStep("flattenComponents()");
        Flattener f = new Flattener(fc);
        flatten(f, FlattenBindingExp.ALL, level);
        getInstGeneratedInners().flatten(f, FlattenBindingExp.ALL, level);
        flattenUsedFuncsAndEnums(f);
        flattenInstClassDeclExtra(f);
        fc.update(f);
        endStep("flattenComponents()");
        fc.updateVariabilityForVariablesInWhen();
        fc.genConnectionEquations(f);
        fc.update(f);
        fc.createExperiment(annotation("experiment"));
        breakOnErrors();
        endStep("flattenInstClassDecl()");
        fc.transformationStepDebug();
        clearModificationLevel(oldLevels);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:284
     */
    
        private static final ArrayList<ExtraFlattener> extraFlatteners = new ArrayList<ExtraFlattener>();
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:286
     */
    
        
        public static ExtraFlattener addExtraFlattener(ExtraFlattener ef) {
            extraFlatteners.add(ef);
            return ef;
        }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:291
     */
    
        
        public static abstract class ExtraFlattener {
            public abstract void flattenExtra(Flattener f, InstClassDecl icd);
        }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:296
     */
    protected void flattenInstClassDeclExtra(Flattener f) {
        for (ExtraFlattener ef : extraFlatteners) {
            ef.flattenExtra(f, this);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:327
     */
    @Override
    public void flattenUsedFuncsAndEnums(Flattener f) {
        super.flattenUsedFuncsAndEnums(f);
        getInstGeneratedInners().flattenUsedFuncsAndEnums(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:463
     */
    public void flattenFunction(Flattener f) {}
    /**
     * Utility method for finding an annotation tree that contains one of the
     * provided subpaths. It will optionaly look in the external and the
     * annotation of extending classes.
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:558
     */
    protected AnnotationNode findAnnotationRoot(boolean lookInExternal, boolean lookInExtends, String ... subPaths) {
        return AnnotationNode.NO_ANNOTATION;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:602
     */
    protected AnnotationNode findDerivativeAnnotationRoot() {
        return findAnnotationRoot(true, true, "derivative");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:606
     */
    protected AnnotationNode findInlineAnnotationRoot() {
        return findAnnotationRoot(true, true, "Inline", "LateInline", "InlineAfterIndexReduction");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:610
     */
    protected AnnotationNode findSmoothOrderAnnotationRoot() {
        return findAnnotationRoot(true, true, "smoothOrder");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:714
     */
    public void flattenRecord(Flattener f) {}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1184
     */
    public void buildConnectionSets(FClass fc) {
        beginStep("buildConnectionSets()");
        ConnectionSetManager csm = fc.getConnectionSetManager();
        buildConnectionSets(new FAccessEmpty(), csm, true);
        csm.buildOverconstrainedConnectionTrees();
        csm.elaborateExpandableConnectors();
        endStep("buildConnectionSets()");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1498
     */
    public void flattenEnum(Flattener f) {
        if (!f.isFlattened(this)) {
            // Flatten all InstEnums corresponding to FEnumLiterals
            FEnumLiteralList l = new FEnumLiteralList();
            for (InstEnumLiteral ie : enumLiterals()) 
                l.addFEnumLiteral(ie.createFEnumLiteral());
            FIdDecl id = new FIdDecl(new FAccessString(qualifiedName()));
            FEnumDecl ed = new FEnumDecl(id, l, new Opt());
            SrcStringComment comment = myStringComment();
            if (comment != null) {
                ed.setFStringComment(comment.flatten());
            }
            addFDerivedType(f);
            f.addFEnumDecl(ed); 
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1671
     */
    public void addFDerivedType(Flattener f) {
        if (!f.isFlattened(this) && extendsPrimitive()) {
            List<FAttribute> attr = new List<FAttribute>();
            addAttributes(f, attr, totalMergedEnvironment());
            FType baseType = primitiveScalarType().fullCopy();
            f.addFDerivedType(new FDerivedType(qualifiedName(), baseType, attr));
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2831
     */
    public FFunctionCall flattenOverloadedFunctionCall(Flattener f, FExp... args) {
        FType[] argTypes = new FType[args.length];
        for (int i = 0; i < args.length; i++)
            argTypes[i] = args[i].type();
        return flattenOverloadedFunctionCall(f, args, argTypes);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2838
     */
    public FFunctionCall flattenOverloadedFunctionCall(Flattener f, FExp[] args, FType[] argTypes) {
        // TODO: handle array operations (scalar * matrix, etc)
        FAccess name = new FAccessString(qualifiedName());
        int nIn = myInputs().size();
        if (nIn > args.length)
            args = Arrays.copyOf(args, nIn);
        Map<InstComponentDecl,FExp> argMap = new HashMap<InstComponentDecl,FExp>();
        for (int i = 0; i < nIn; i++) {
            InstComponentDecl in = myInputs().get(i);
            argMap.put(in, args[i]);
        }
        FExp.FunctionContextReplacer crp = new FExp.ExpFunctionContextReplacer(argMap);
        for (int i = 0; i < nIn; i++) {
            InstComponentDecl in = myInputs().get(i);
            if (args[i] == null) {
                args[i] = crp.get(in).flatten(f);
            } else if (!in.type().typeCompatible(argTypes[i], true)) {
                InstClassDecl constructor = in.type().matchOverloadedConstructor(argTypes[i]);
                args[i] = constructor.flattenOverloadedFunctionCall(f, args[i]);
            } else {
                args[i] = args[i].flatten(f);
            }
        }
        List<FExp> argList = new List<FExp>(args);
        return new FFunctionCall(name, argList, functionType().flatten(f, null, true));
    }
    /**
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:292
     */
    private Map<InstComponentDecl,String> tempVarNames;
    /**
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:293
     */
    private int nextTempVarIndex = 1;
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:230
     */
    private static final String TEMP_VAR_PREFIX = "temp_";
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:231
     */
    private int incr = 0;
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:247
     */
    public boolean componentExists(String name) {
        for (InstComponentDecl decl : allInstComponentDecls()) {
            if (decl.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Change access to point to <code>this</code> class instead of <code>orig</code>.
     * 
     * Creates new access if necessary.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:501
     */
    public InstAccess retargetFrom(InstClassDecl orig, InstAccess access) {
        if (this == orig)
            return access;
        InstAccess part = new InstClassAccess(name());
        InstClassDecl parent = surroundingInstClass();
        if (parent == null)
            return part;
        access = parent.retargetFrom(orig, access);
        InstDot dot = (access instanceof InstDot) ? (InstDot) access : new InstDot(new List(access));
        dot.addInstAccess(part);
        return dot;
    }
    /**
     * Get the restriction of this class.
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:750
     */
    public InstRestriction getInstRestriction() {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1220
     */
    public InstComponentDecl newInstComponentDecl(SrcComponentDecl cd) {
        return newInstComponentDecl(cd, cd.getClassName());
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1224
     */
    public InstComponentDecl newInstComponentDecl(SrcComponentDecl cd, SrcAccess className) {
        InstComponentDecl icd = newInstComponentDeclGeneric(cd.name(), cd, className);
        if (cd.hasSrcArraySubscripts()) {
            icd.setLocalFArraySubscripts(cd.instantiateArraySubscripts());
        }
        if (cd.hasSrcConditionalAttribute())
            icd.setConditionalAttribute(cd.getSrcConditionalAttribute().getSrcExp().instantiate());
        return icd;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1234
     */
    public InstComponentDecl newInstComponentDeclCopy(
            String name, FArraySubscripts subscripts, SrcComponentDecl cd, SrcAccess className) {
        InstComponentDecl icd = newInstComponentDeclGeneric(name, cd, className);
        if (subscripts != null) {
            icd.setLocalFArraySubscripts(subscripts);
        }
        return icd;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1243
     */
    public abstract InstComponentDecl newInstComponentDeclGeneric(String name, SrcComponentDecl cd, SrcAccess className);
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1299
     */
    public InstComponentDecl newInstConstrainingComponentDecl(SrcComponentDecl cd, SrcAccess className) {
        InstComponentDecl icd = newInstComponentDecl(cd, className);
        icd.setInstConstrainingComponentOpt(new Opt());
        return icd;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1305
     */
    public abstract InstComponentDecl newInstReplacingComponent(
            SrcComponentDecl replacingDecl, SrcComponentDecl originalDecl, 
            InstComponentRedeclare icr, InstComponentRedeclare cicr);
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2333
     */
    public Iterable<InstComponentDecl> allInstComponentDeclsWithDuplicates() {
        return new AllInstComponentIterable(actualInstClass());
    }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2345
     */
    public Iterable<InstClassDecl> allInstClassDecls() {
        return new AllInstClassIterable(actualInstClass());
    }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2352
     */
    protected Iterator<InstComponentDecl> allInstComponentDeclsIterator() {
        return new AllInstComponentIterator(actualInstClass());
    }
    /**
     * @aspect InstanceToString
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2730
     */
    public String toString() {
    	return getSrcClassDecl().toString();
    }
    /**
     * Add operators to operator map. Operators add themselves and packages add any contained operators.
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:37
     */
    public void addOperatorsToMap(Map<String,InstClassDecl> map) {
        if (isOperator()) {
            // TODO: error if already in map? see https://trac.modelica.org/Modelica/ticket/1459
            map.put(name(), this);
        } else if (isPackage()) {
            for (InstClassDecl icd : allInstClassDecls())
                icd.addOperatorsToMap(map);
        }
    }
    /**
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:654
     */
    public String testFindConstant() {
        SrcClassDecl sourceClass = getSrcClassDecl();
        StringBuilder sb = new StringBuilder();
        sourceClass.testFindConstant(sb);
        return sb.toString();
    }
    /**
     * Obtain the SrcAnnotationProvider respecting the inheritance if this class is not a function.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2141
     */
    public SrcAnnotationProvider myAnnotation() {
        return getSrcClassDecl().srcAnnotationProvider();
    }
    /**
     * Obtain the source node which is responsable for providing the annotation.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2184
     */
    public SrcAnnotatable mySrcAnnotatable() {
        return getSrcClassDecl();
    }
    /**
     * Test method which obtains the string representation of the 
     * annotation for the inner class or component with the given name.  
     * A QualifiedName can be provider for lookup of the class or component to test. 
     * Supports relative dot lookup of component or class to test. 
     * Trigger a null pointer exception if the element is not found.
     * 
     * This method is only intended for testing. 
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2197
     */
    public String testElementAnnotations(String name) {
    	InstNode iNode = this;
        Iterable<? extends InstNode> it = null;
        boolean found = false;
        QualifiedName qn = new QualifiedName(name);
        do {
            String namePart = qn.next();
            it = new ChainedIterable<> (iNode.allInstComponentDecls(), iNode.allInstClassDecls());
            iNode = null;
            for (InstNode icd :  it) {
                if (icd.matches(namePart)) {
                    iNode = icd;
                    break;
                }
            }
        } while (qn.hasNext());
        Iterator<AnnotationNode> iter = iNode.annotation().iterator();
        return iter.hasNext() ? iter.next().toString() : "";
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:39
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return getSrcClassDecl().srcAnnotation(new SrcAnnotationNode.InstEvaluator(this), path);
    }
    /**
     * @aspect ClassDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1546
     */
    public boolean extendsClass(InstClassDecl icd) {
        if (equals(icd))
            return true;
        for (InstExtends ie : getInstExtendss()) {
            if (ie.myInstClass().extendsClass(icd))
                return true;
        }
        return false;
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstClassDecl() {
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
        children = new ASTNode[10];
        setChild(List.EMPTY, 0);
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(List.EMPTY, 3);
        setChild(List.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
        setChild(Opt.EMPTY, 8);
    }
    /**
     * @declaredat ASTNode:22
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcClassDecl"},
        type = {"SrcClassDecl"},
        kind = {"Token"}
    )
    public InstClassDecl(SrcClassDecl p0) {
        setSrcClassDecl(p0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:31
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:37
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:41
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        containsFunction_FFunctionDecl_FunctionType_reset();
        getFAccess_reset();
        getInstGeneratedInners_reset();
        recordType_reset();
        getFunctionType_reset();
        classInstModifications_reset();
        getClassAnnotationOpt_reset();
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
    public InstClassDecl clone() throws CloneNotSupportedException {
        InstClassDecl node = (InstClassDecl) super.clone();
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
    public abstract InstClassDecl fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:75
     */
    public abstract InstClassDecl treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:83
     */
    public abstract InstClassDecl treeCopy();
    /**
     * Replaces the lexeme SrcClassDecl.
     * @param value The new value for the lexeme SrcClassDecl.
     * @apilevel high-level
     */
    public void setSrcClassDecl(SrcClassDecl value) {
        tokenSrcClassDecl_SrcClassDecl = value;
    }
    /** @apilevel internal 
     */
    protected SrcClassDecl tokenSrcClassDecl_SrcClassDecl;
    /**
     * Retrieves the value for the lexeme SrcClassDecl.
     * @return The value for the lexeme SrcClassDecl.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcClassDecl")
    public SrcClassDecl getSrcClassDecl() {
        return tokenSrcClassDecl_SrcClassDecl;
    }
    /**
     * Retrieves the number of children in the InstComponentDecl list.
     * @return Number of children in the InstComponentDecl list.
     * @apilevel high-level
     */
    public int getNumInstComponentDecl() {
        return getInstComponentDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstComponentDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstComponentDecl list.
     * @apilevel low-level
     */
    public int getNumInstComponentDeclNoTransform() {
        return getInstComponentDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstComponentDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstComponentDecl list.
     * @apilevel high-level
     */
    public InstComponentDecl getInstComponentDecl(int i) {
        return (InstComponentDecl) getInstComponentDeclList().getChild(i);
    }
    /**
     * Check whether the InstComponentDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstComponentDecl() {
        return getInstComponentDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstComponentDecl list.
     * @param node The element to append to the InstComponentDecl list.
     * @apilevel high-level
     */
    public void addInstComponentDecl(InstComponentDecl node) {
        List<InstComponentDecl> list = (parent == null) ? getInstComponentDeclListNoTransform() : getInstComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstComponentDeclNoTransform(InstComponentDecl node) {
        List<InstComponentDecl> list = getInstComponentDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstComponentDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstComponentDecl(InstComponentDecl node, int i) {
        List<InstComponentDecl> list = getInstComponentDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstComponentDecl list.
     * @return The the child position of the InstComponentDecl list.
     * @apilevel low-level
     */
    protected int getInstComponentDeclListChildPosition() {
        return 0;
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclListNoTransform() {
        return (List<InstComponentDecl>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the InstComponentDecl list without
     * triggering rewrites.
     */
    public InstComponentDecl getInstComponentDeclNoTransform(int i) {
        return (InstComponentDecl) getInstComponentDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstComponentDecl list.
     * @return The node representing the InstComponentDecl list.
     * @apilevel high-level
     */
    public List<InstComponentDecl> getInstComponentDecls() {
        return getInstComponentDeclList();
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclsNoTransform() {
        return getInstComponentDeclListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstClassDecl list.
     * @return Number of children in the InstClassDecl list.
     * @apilevel high-level
     */
    public int getNumInstClassDecl() {
        return getInstClassDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstClassDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstClassDecl list.
     * @apilevel low-level
     */
    public int getNumInstClassDeclNoTransform() {
        return getInstClassDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstClassDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstClassDecl list.
     * @apilevel high-level
     */
    public InstClassDecl getInstClassDecl(int i) {
        return (InstClassDecl) getInstClassDeclList().getChild(i);
    }
    /**
     * Check whether the InstClassDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstClassDecl() {
        return getInstClassDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstClassDecl list.
     * @param node The element to append to the InstClassDecl list.
     * @apilevel high-level
     */
    public void addInstClassDecl(InstClassDecl node) {
        List<InstClassDecl> list = (parent == null) ? getInstClassDeclListNoTransform() : getInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstClassDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstClassDecl(InstClassDecl node, int i) {
        List<InstClassDecl> list = getInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstClassDecl list.
     * @return The the child position of the InstClassDecl list.
     * @apilevel low-level
     */
    protected int getInstClassDeclListChildPosition() {
        return 1;
    }
    /**
     * Retrieves the InstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the InstClassDecl list without
     * triggering rewrites.
     */
    public InstClassDecl getInstClassDeclNoTransform(int i) {
        return (InstClassDecl) getInstClassDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstClassDecl list.
     * @return The node representing the InstClassDecl list.
     * @apilevel high-level
     */
    public List<InstClassDecl> getInstClassDecls() {
        return getInstClassDeclList();
    }
    /**
     * Retrieves the InstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getInstClassDeclsNoTransform() {
        return getInstClassDeclListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstExtends list.
     * @return Number of children in the InstExtends list.
     * @apilevel high-level
     */
    public int getNumInstExtends() {
        return getInstExtendsList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstExtends list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstExtends list.
     * @apilevel low-level
     */
    public int getNumInstExtendsNoTransform() {
        return getInstExtendsListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstExtends list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstExtends list.
     * @apilevel high-level
     */
    public InstExtends getInstExtends(int i) {
        return (InstExtends) getInstExtendsList().getChild(i);
    }
    /**
     * Check whether the InstExtends list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstExtends() {
        return getInstExtendsList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstExtends list.
     * @param node The element to append to the InstExtends list.
     * @apilevel high-level
     */
    public void addInstExtends(InstExtends node) {
        List<InstExtends> list = (parent == null) ? getInstExtendsListNoTransform() : getInstExtendsList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstExtendsNoTransform(InstExtends node) {
        List<InstExtends> list = getInstExtendsListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstExtends list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstExtends(InstExtends node, int i) {
        List<InstExtends> list = getInstExtendsList();
        if (list == List.EMPTY) {
            setChild(new List(node), 2);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstExtends list.
     * @return The the child position of the InstExtends list.
     * @apilevel low-level
     */
    protected int getInstExtendsListChildPosition() {
        return 2;
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendsListNoTransform() {
        return (List<InstExtends>) getChildNoTransform(2);
    }
    /**
     * @return the element at index {@code i} in the InstExtends list without
     * triggering rewrites.
     */
    public InstExtends getInstExtendsNoTransform(int i) {
        return (InstExtends) getInstExtendsListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstExtends list.
     * @return The node representing the InstExtends list.
     * @apilevel high-level
     */
    public List<InstExtends> getInstExtendss() {
        return getInstExtendsList();
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendssNoTransform() {
        return getInstExtendsListNoTransform();
    }
    /**
     * Retrieves the number of children in the InstImport list.
     * @return Number of children in the InstImport list.
     * @apilevel high-level
     */
    public int getNumInstImport() {
        return getInstImportList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstImport list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstImport list.
     * @apilevel low-level
     */
    public int getNumInstImportNoTransform() {
        return getInstImportListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstImport list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstImport list.
     * @apilevel high-level
     */
    public InstImport getInstImport(int i) {
        return (InstImport) getInstImportList().getChild(i);
    }
    /**
     * Check whether the InstImport list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstImport() {
        return getInstImportList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstImport list.
     * @param node The element to append to the InstImport list.
     * @apilevel high-level
     */
    public void addInstImport(InstImport node) {
        List<InstImport> list = (parent == null) ? getInstImportListNoTransform() : getInstImportList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstImportNoTransform(InstImport node) {
        List<InstImport> list = getInstImportListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstImport list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstImport(InstImport node, int i) {
        List<InstImport> list = getInstImportList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstImport list.
     * @return The the child position of the InstImport list.
     * @apilevel low-level
     */
    protected int getInstImportListChildPosition() {
        return 3;
    }
    /**
     * Retrieves the InstImport list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstImport list.
     * @apilevel low-level
     */
    public List<InstImport> getInstImportListNoTransform() {
        return (List<InstImport>) getChildNoTransform(3);
    }
    /**
     * @return the element at index {@code i} in the InstImport list without
     * triggering rewrites.
     */
    public InstImport getInstImportNoTransform(int i) {
        return (InstImport) getInstImportListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstImport list.
     * @return The node representing the InstImport list.
     * @apilevel high-level
     */
    public List<InstImport> getInstImports() {
        return getInstImportList();
    }
    /**
     * Retrieves the InstImport list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstImport list.
     * @apilevel low-level
     */
    public List<InstImport> getInstImportsNoTransform() {
        return getInstImportListNoTransform();
    }
    /**
     * Retrieves the number of children in the RedeclaredInstClassDecl list.
     * @return Number of children in the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public int getNumRedeclaredInstClassDecl() {
        return getRedeclaredInstClassDeclList().getNumChild();
    }
    /**
     * Retrieves the number of children in the RedeclaredInstClassDecl list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public int getNumRedeclaredInstClassDeclNoTransform() {
        return getRedeclaredInstClassDeclListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the RedeclaredInstClassDecl list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public InstClassDecl getRedeclaredInstClassDecl(int i) {
        return (InstClassDecl) getRedeclaredInstClassDeclList().getChild(i);
    }
    /**
     * Check whether the RedeclaredInstClassDecl list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasRedeclaredInstClassDecl() {
        return getRedeclaredInstClassDeclList().getNumChild() != 0;
    }
    /**
     * Append an element to the RedeclaredInstClassDecl list.
     * @param node The element to append to the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public void addRedeclaredInstClassDecl(InstClassDecl node) {
        List<InstClassDecl> list = (parent == null) ? getRedeclaredInstClassDeclListNoTransform() : getRedeclaredInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addRedeclaredInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getRedeclaredInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the RedeclaredInstClassDecl list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setRedeclaredInstClassDecl(InstClassDecl node, int i) {
        List<InstClassDecl> list = getRedeclaredInstClassDeclList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the RedeclaredInstClassDecl list.
     * @return The the child position of the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    protected int getRedeclaredInstClassDeclListChildPosition() {
        return 4;
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(4);
    }
    /**
     * @return the element at index {@code i} in the RedeclaredInstClassDecl list without
     * triggering rewrites.
     */
    public InstClassDecl getRedeclaredInstClassDeclNoTransform(int i) {
        return (InstClassDecl) getRedeclaredInstClassDeclListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel high-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDecls() {
        return getRedeclaredInstClassDeclList();
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDeclsNoTransform() {
        return getRedeclaredInstClassDeclListNoTransform();
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
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAbstractEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
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
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the FAbstractEquation list.
     * @return The the child position of the FAbstractEquation list.
     * @apilevel low-level
     */
    protected int getFAbstractEquationListChildPosition() {
        return 5;
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(5);
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
     * Retrieves the number of children in the ElementInstModification list.
     * @return Number of children in the ElementInstModification list.
     * @apilevel high-level
     */
    public int getNumElementInstModification() {
        return getElementInstModificationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ElementInstModification list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ElementInstModification list.
     * @apilevel low-level
     */
    public int getNumElementInstModificationNoTransform() {
        return getElementInstModificationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ElementInstModification list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ElementInstModification list.
     * @apilevel high-level
     */
    public InstModification getElementInstModification(int i) {
        return (InstModification) getElementInstModificationList().getChild(i);
    }
    /**
     * Check whether the ElementInstModification list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasElementInstModification() {
        return getElementInstModificationList().getNumChild() != 0;
    }
    /**
     * Append an element to the ElementInstModification list.
     * @param node The element to append to the ElementInstModification list.
     * @apilevel high-level
     */
    public void addElementInstModification(InstModification node) {
        List<InstModification> list = (parent == null) ? getElementInstModificationListNoTransform() : getElementInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addElementInstModificationNoTransform(InstModification node) {
        List<InstModification> list = getElementInstModificationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ElementInstModification list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setElementInstModification(InstModification node, int i) {
        List<InstModification> list = getElementInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the ElementInstModification list.
     * @return The the child position of the ElementInstModification list.
     * @apilevel low-level
     */
    protected int getElementInstModificationListChildPosition() {
        return 6;
    }
    /**
     * Retrieves the ElementInstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElementInstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getElementInstModificationListNoTransform() {
        return (List<InstModification>) getChildNoTransform(6);
    }
    /**
     * @return the element at index {@code i} in the ElementInstModification list without
     * triggering rewrites.
     */
    public InstModification getElementInstModificationNoTransform(int i) {
        return (InstModification) getElementInstModificationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ElementInstModification list.
     * @return The node representing the ElementInstModification list.
     * @apilevel high-level
     */
    public List<InstModification> getElementInstModifications() {
        return getElementInstModificationList();
    }
    /**
     * Retrieves the ElementInstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElementInstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getElementInstModificationsNoTransform() {
        return getElementInstModificationListNoTransform();
    }
    /**
     * Retrieves the number of children in the AnnotationExp list.
     * @return Number of children in the AnnotationExp list.
     * @apilevel high-level
     */
    public int getNumAnnotationExp() {
        return getAnnotationExpList().getNumChild();
    }
    /**
     * Retrieves the number of children in the AnnotationExp list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the AnnotationExp list.
     * @apilevel low-level
     */
    public int getNumAnnotationExpNoTransform() {
        return getAnnotationExpListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the AnnotationExp list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the AnnotationExp list.
     * @apilevel high-level
     */
    public FExp getAnnotationExp(int i) {
        return (FExp) getAnnotationExpList().getChild(i);
    }
    /**
     * Check whether the AnnotationExp list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasAnnotationExp() {
        return getAnnotationExpList().getNumChild() != 0;
    }
    /**
     * Append an element to the AnnotationExp list.
     * @param node The element to append to the AnnotationExp list.
     * @apilevel high-level
     */
    public void addAnnotationExp(FExp node) {
        List<FExp> list = (parent == null) ? getAnnotationExpListNoTransform() : getAnnotationExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addAnnotationExpNoTransform(FExp node) {
        List<FExp> list = getAnnotationExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the AnnotationExp list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setAnnotationExp(FExp node, int i) {
        List<FExp> list = getAnnotationExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the AnnotationExp list.
     * @return The the child position of the AnnotationExp list.
     * @apilevel low-level
     */
    protected int getAnnotationExpListChildPosition() {
        return 7;
    }
    /**
     * Retrieves the AnnotationExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnnotationExp list.
     * @apilevel low-level
     */
    public List<FExp> getAnnotationExpListNoTransform() {
        return (List<FExp>) getChildNoTransform(7);
    }
    /**
     * @return the element at index {@code i} in the AnnotationExp list without
     * triggering rewrites.
     */
    public FExp getAnnotationExpNoTransform(int i) {
        return (FExp) getAnnotationExpListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the AnnotationExp list.
     * @return The node representing the AnnotationExp list.
     * @apilevel high-level
     */
    public List<FExp> getAnnotationExps() {
        return getAnnotationExpList();
    }
    /**
     * Retrieves the AnnotationExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnnotationExp list.
     * @apilevel low-level
     */
    public List<FExp> getAnnotationExpsNoTransform() {
        return getAnnotationExpListNoTransform();
    }
    /**
     * Replaces the (optional) ClassAnnotation child.
     * @param node The new node to be used as the ClassAnnotation child.
     * @apilevel high-level
     */
    public void setClassAnnotation(InstClassModification node) {
        // TODO: should also check if getOpt() is the empty singleton, since we check the _value on return.
        getClassAnnotationOpt().setChild(node, 0);
    }
    /**
     * Check whether the optional ClassAnnotation child exists.
     * @return {@code true} if the optional ClassAnnotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasClassAnnotation() {
        return getClassAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ClassAnnotation child.
     * @return The ClassAnnotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstClassModification getClassAnnotation() {
        return (InstClassModification) getClassAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for child ClassAnnotation. This is the <code>Opt</code> node containing the child ClassAnnotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ClassAnnotation.
     * @apilevel low-level
     */
    public Opt<InstClassModification> getClassAnnotationOptNoTransform() {
        return (Opt<InstClassModification>) getChildNoTransform(8);
    }
    /**
     * Retrieves the child position of the optional child ClassAnnotation.
     * @return The the child position of the optional child ClassAnnotation.
     * @apilevel low-level
     */
    protected int getClassAnnotationOptChildPosition() {
        return 8;
    }
    /**
     * Retrieves the FunctionType child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FunctionType child.
     * @apilevel low-level
     */
    public FType getFunctionTypeNoTransform() {
        return (FType) getChildNoTransform(9);
    }
    /**
     * Retrieves the child position of the optional child FunctionType.
     * @return The the child position of the optional child FunctionType.
     * @apilevel low-level
     */
    protected int getFunctionTypeChildPosition() {
        return 9;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1965
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1965")
    public abstract String qualifiedName();
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3634
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3634")
    public CValue evaluatePartial(Map<CommonVariableDecl, CValue> values) {
        CValue evaluatePartial_Map_CommonVariableDecl__CValue__value = CValuePartialFunction.create(this, values);
        return evaluatePartial_Map_CommonVariableDecl__CValue__value;
    }
    /**
     * Returns a list of all components in this class that would be inputs in a function call or 
     * record constructor. Treats all non-records as functions.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1315
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1315")
    public ArrayList<InstComponentDecl> myCallInputs() {
        ArrayList<InstComponentDecl> myCallInputs_value = isRecord() ? myModifiableComponents() : myInputs();
        return myCallInputs_value;
    }
    /**
     * Check if a class has an "experiment" annotation.
     * @attribute syn
     * @aspect DefaultExperiment
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DefaultExperiment", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1888")
    public boolean isExperiment() {
        boolean isExperiment_value = annotation("experiment").exists();
        return isExperiment_value;
    }
    /**
     * Returns a string listing the annotations in this class declaration and any child class declarations, recursively.
     * 
     * @param prefix
     * The string to prefix the annotation string with.
     * @attribute syn
     * @aspect AnnotationPrettyPrinting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationPrettyPrinting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2192")
    public String printClassAnnotations(String prefix) {
        String printClassAnnotations_String_value = "";
        return printClassAnnotations_String_value;
    }
    /**
     * Returns a string listing the annotations for components in this class.
     * 
     * @param prefix
     * The string to prefix the annotation string with.
     * @attribute syn
     * @aspect AnnotationPrettyPrinting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationPrettyPrinting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2212")
    public String printComponentAnnotations() {
        String printComponentAnnotations_value = "";
        return printComponentAnnotations_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1507
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1507")
    public boolean isDestructor() {
        boolean isDestructor_value = name().equals("destructor") && inExternalObject();
        return isDestructor_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1511
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1511")
    public boolean isConstructor() {
        boolean isConstructor_value = name().equals("constructor") && inExternalObject();
        return isConstructor_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1216
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1216")
    public boolean hasInstExternal() {
        boolean hasInstExternal_value = false;
        return hasInstExternal_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1218")
    public int numInstExternal() {
        {
        		int n = hasInstExternal() ? 1 : 0;
        		for (InstExtends ie : getInstExtendss())
        			n += ie.myInstClass().numInstExternal();
        		return n;
        	}
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1227")
    public int numFAlgorithm() {
        {
        		int n = 0;
        		for (FAbstractEquation e : getFAbstractEquations())
        			if (e instanceof FAlgorithm)
        				n++;
        		for (InstExtends ie : getInstExtendss())
        			n += ie.myInstClass().numFAlgorithm();
        		return n;
        	}
    }
    /**
     * Check if this node is equal to or an instance of <code>icd</code>.
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1583
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1583")
    public boolean isOfInstClassDecl(InstClassDecl icd) {
        boolean isOfInstClassDecl_InstClassDecl_value = icd == this;
        return isOfInstClassDecl_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:553
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:553")
    public boolean isExternalFunction() {
        boolean isExternalFunction_value = findFunctionExternal() != null;
        return isExternalFunction_value;
    }
    /** @apilevel internal */
    private void containsFunction_FFunctionDecl_FunctionType_reset() {
        containsFunction_FFunctionDecl_FunctionType_values = null;
    }
    protected java.util.Map containsFunction_FFunctionDecl_FunctionType_values;
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:598")
    public boolean containsFunction(FFunctionDecl.FunctionType ft) {
        Object _parameters = ft;
        if (containsFunction_FFunctionDecl_FunctionType_values == null) containsFunction_FFunctionDecl_FunctionType_values = new java.util.HashMap(4);
        ASTState.CircularValue _value;
        if (containsFunction_FFunctionDecl_FunctionType_values.containsKey(_parameters)) {
            Object _cache = containsFunction_FFunctionDecl_FunctionType_values.get(_parameters);
            if (!(_cache instanceof ASTState.CircularValue)) {
                return (Boolean) _cache;
            } else {
                _value = (ASTState.CircularValue) _cache;
            }
        } else {
            _value = new ASTState.CircularValue();
            containsFunction_FFunctionDecl_FunctionType_values.put(_parameters, _value);
            _value.value = false;
        }
        ASTState state = state();
        if (!state.inCircle() || state.calledByLazyAttribute()) {
            state.enterCircle();
            int _boundaries = state.boundariesCrossed;
            boolean isFinal = this.is$Final();
            boolean new_containsFunction_FFunctionDecl_FunctionType_value;
            do {
                _value.cycle = state.nextCycle();
                new_containsFunction_FFunctionDecl_FunctionType_value = super.containsFunction(ft);
                if (((Boolean)_value.value) != new_containsFunction_FFunctionDecl_FunctionType_value) {
                    state.setChangeInCycle();
                    _value.value = new_containsFunction_FFunctionDecl_FunctionType_value;
                }
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                containsFunction_FFunctionDecl_FunctionType_values.put(_parameters, new_containsFunction_FFunctionDecl_FunctionType_value);
                state.startLastCycle();
                boolean $tmp = super.containsFunction(ft);
            } else {
                containsFunction_FFunctionDecl_FunctionType_values.remove(_parameters);
                state.startResetCycle();
                boolean $tmp = super.containsFunction(ft);
            }
            state.leaveCircle();
            return new_containsFunction_FFunctionDecl_FunctionType_value;
        } else if (_value.cycle != state.cycle()) {
            _value.cycle = state.cycle();
            boolean new_containsFunction_FFunctionDecl_FunctionType_value = super.containsFunction(ft);
            if (state.lastCycle()) {
                containsFunction_FFunctionDecl_FunctionType_values.put(_parameters, new_containsFunction_FFunctionDecl_FunctionType_value);
            }
            if (state.resetCycle()) {
                containsFunction_FFunctionDecl_FunctionType_values.remove(_parameters);
            }
            else if (((Boolean)_value.value) != new_containsFunction_FFunctionDecl_FunctionType_value) {
                state.setChangeInCycle();
                _value.value = new_containsFunction_FFunctionDecl_FunctionType_value;
            }
            return new_containsFunction_FFunctionDecl_FunctionType_value;
        } else {
            return (Boolean) _value.value;
        }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1109
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1109")
    public boolean isComponentSizeClass() {
        boolean isComponentSizeClass_value = isBoolean();
        return isComponentSizeClass_value;
    }
    /**
     * Check if this is an equality constraint function for the given type.
     * @attribute syn
     * @aspect OverconstrainedConnections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1495
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverconstrainedConnections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1495")
    public boolean isEqualityConstraint(FType type) {
        {
        		ArrayList<InstComponentDecl> inputs = myInputs();
        		ArrayList<InstComponentDecl> outputs = myOutputs();
        		return isFunction() && 
        				inputs.size() == 2 && 
        				inputs.get(0).type().typeCompatible(type, true) && 
        				inputs.get(1).type().typeCompatible(type, true) && 
        				outputs.size() == 1 && 
        				outputs.get(0).ndims() == 1 && 
        				outputs.get(0).type().isReal();
        	}
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:700
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:700")
    public InstExternal findFunctionExternal() {
        {
                for (InstExtends ie : getInstExtendss()) {
                    InstExternal tmp = ie.myInstClass().findFunctionExternal();
                    if (tmp != null) 
                        return tmp;
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387")
    public boolean containsRedeclared() {
        boolean containsRedeclared_value = false;
        return containsRedeclared_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218")
    public InstNode[] extraNodesToSetModLevelFor() {
        InstNode[] extraNodesToSetModLevelFor_value = listExtraNodesToSetModLevelFor(true);
        return extraNodesToSetModLevelFor_value;
    }
    /** @apilevel internal */
    private void getFAccess_reset() {
        getFAccess_computed = false;
        
        getFAccess_value = null;
    }
    /** @apilevel internal */
    protected boolean getFAccess_computed = false;

    /** @apilevel internal */
    protected FAccess getFAccess_value;

    /**
     * @attribute syn
     * @aspect FlatteningFAccesss
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:177
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFAccesss", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:177")
    public FAccess getFAccess() {
        ASTState state = state();
        if (getFAccess_computed) {
            return getFAccess_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFAccess_value = new FAccessEmpty();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFAccess_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getFAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:300
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:300")
    public String localTempVarName(InstComponentDecl var) {
        {
                if (tempVarNames == null)
                    tempVarNames = new HashMap<InstComponentDecl,String>();
                if (tempVarNames.containsKey(var))
                    return tempVarNames.get(var);
                String name;
                do {
                    name = "temp_" + nextTempVarIndex++;
                } while (memberInstComponent(name).successful());
                tempVarNames.put(var, name);
                return name;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:233")
    public String nextTempVarName() {
        String nextTempVarName_value = TEMP_VAR_PREFIX + ++incr;
        return nextTempVarName_value;
    }
    /**
     * Lookup upwards in tree for matching inner declaration.
     * 
     * @param outer  outer declaration we are searching for 
     * @attribute syn
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:71
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:71")
    public InstComponentDecl lookupInnerInstComponentNoLocal(InstComponentDecl outer, InstComponentDecl nonInner) {
        {
                String name = outer.name();
                InstGeneratedInner res = null;
                List<InstGeneratedInner> inners = getInstGeneratedInners();
                for (InstGeneratedInner node : inners) {
                    if (node.matches(name)) {
                        res = node;
                    }
                }
                
                if (res != null) {
                    res.addOuter(outer);
                } else {
                    res = new InstGeneratedInner(this, outer, nonInner);
                    inners.add(res);
                    inners.getChild(inners.getNumChild() - 1);  // Make sure res is final
                }
                return res.getInstComponentDecl();
            }
    }
    /** @apilevel internal */
    private void getInstGeneratedInners_reset() {
        getInstGeneratedInners_computed = false;
        
        getInstGeneratedInners_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstGeneratedInners_computed = false;

    /** @apilevel internal */
    protected List<InstGeneratedInner> getInstGeneratedInners_value;

    /**
     * @attribute syn
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:93
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:93")
    public List<InstGeneratedInner> getInstGeneratedInners() {
        ASTState state = state();
        if (getInstGeneratedInners_computed) {
            return getInstGeneratedInners_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstGeneratedInners_value = new List<InstGeneratedInner>();
        getInstGeneratedInners_value.setParent(this);
        getInstGeneratedInners_value.is$Final = true;
        if (true) {
        getInstGeneratedInners_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getInstGeneratedInners_value;
    }
    /**
     * @attribute syn
     * @aspect InnerOuterClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:119
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:119")
    public boolean inOrIsOuter() {
        boolean inOrIsOuter_value = isOuter() || inOuter();
        return inOrIsOuter_value;
    }
    /**
     * @attribute syn
     * @aspect InnerOuterClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:120")
    public boolean inOrIsInner() {
        boolean inOrIsInner_value = isInner() || inInner();
        return inOrIsInner_value;
    }
    /**
     * @attribute syn
     * @aspect InnerOuterClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:122
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:122")
    public InstClassDecl myInnerInstClassDecl() {
        {
                InstClassDecl res = null;
                if (isOuter()) 
                    res = lookupInnerInstClass(name(), true);
                else if (inOuter())
                    res = lookupInInnerInstClass(name());
                return res;
            }
    }
    /**
     * Extract constructor function for external object class.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:932
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:932")
    public InstClassDecl myConstructor() {
        InstClassDecl myConstructor_value = memberInstClass("constructor").target(INST_UNKNOWN_CLASS, this);
        return myConstructor_value;
    }
    /**
     * Extract destructor function for external object class.
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:942
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:942")
    public InstClassDecl myDestructor() {
        InstClassDecl myDestructor_value = memberInstClass("destructor").target(INST_UNKNOWN_CLASS, this);
        return myDestructor_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:33
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:33")
    public InstLookupResult<InstClassDecl> lookupInstClassRedirect(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassRedirect_String_value = actualInstClass().genericLookupInstClass(name);
        return lookupInstClassRedirect_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:123
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:123")
    public InstLookupResult<InstClassDecl> lookupInstClassInInstClassRedeclare(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassInInstClassRedeclare_String_value = InstLookupResult.notFound();
        return lookupInstClassInInstClassRedeclare_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:148
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:148")
    public InstLookupResult<InstClassDecl> superLookupInstClassFromChain(String name) {
        InstLookupResult<InstClassDecl> superLookupInstClassFromChain_String_value = superLookupInstClass(name);
        return superLookupInstClassFromChain_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:181
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:181")
    public InstLookupResult<InstClassDecl> lookupRedeclareExtendsInstClassFromComponent(String name) {
        InstLookupResult<InstClassDecl> lookupRedeclareExtendsInstClassFromComponent_String_value = lookupLastRedeclareExtendsInstClass(name);
        return lookupRedeclareExtendsInstClassFromComponent_String_value;
    }
    /**
     * Resolve classes that are just references to other classes.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:197
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:197")
    public InstClassDecl actualInstClass() {
        InstClassDecl actualInstClass_value = this;
        return actualInstClass_value;
    }
    /**
     * Get loaded version of library class.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:205
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:205")
    public InstClassDecl resolveLib() {
        InstClassDecl resolveLib_value = this;
        return resolveLib_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:439
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:439")
    public boolean isRedeclaredNonSimple() {
        boolean isRedeclaredNonSimple_value = false;
        return isRedeclaredNonSimple_value;
    }
    /**
     * Does node match <code>string</code>? Override for node types that 
     * need to be searched for.
     * 
     * Base implementation always returns <code>false</code.
     * Generally, this is implemented with something like 
     * <code>str.equals(name())</code>.
     * 
     * @param str  the string to match
     * @return     <code>true</code if <code>str</code> matches this node, 
     * <code>false</code> otherwise
     * @attribute syn
     * @aspect NodeSearch
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeSearch", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698")
    public boolean matches(String str) {
        boolean matches_String_value = name().equals(str);
        return matches_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595")
    public InstClassDecl myInstClass() {
        InstClassDecl myInstClass_value = this;
        return myInstClass_value;
    }
    /**
     * The scalar type of this class or component, if it is a primitive type, otherwise the unknown type.
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:48")
    public FType primitiveScalarType() {
        FType primitiveScalarType_value = isEnum() ? enumType() : super.primitiveScalarType();
        return primitiveScalarType_value;
    }
    /** @apilevel internal */
    private void recordType_reset() {
        recordType_computed = false;
        
        recordType_value = null;
    }
    /** @apilevel internal */
    protected boolean recordType_computed = false;

    /** @apilevel internal */
    protected FRecordType recordType_value;

    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:95
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:95")
    public FRecordType recordType() {
        ASTState state = state();
        if (recordType_computed) {
            return recordType_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        recordType_value = recordType_compute();
        recordType_value.setParent(this);
        recordType_value.is$Final = true;
        if (true) {
        recordType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return recordType_value;
    }
    /** @apilevel internal */
    private FRecordType recordType_compute() {
            FRecordType type = resolveLib().createEmptyFRecordType(Size.SCALAR);
            for (InstComponentDecl icd : allInstComponentDecls()) 
                type.addComponent(new FRecordComponentType(icd.name(), (FType) icd.type().treeCopy()));
            return type;
        }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:102")
    public FRecordType createEmptyFRecordType(Size s) {
        FRecordType createEmptyFRecordType_Size_value = null;
        return createEmptyFRecordType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:118")
    public FType enumType() {
        {
                FEnumType type = new FEnumType(Size.SCALAR, qualifiedName(), new List());
                for (InstEnumLiteral el : enumLiterals()) 
                    type.addFEnumLiteralType(new FEnumLiteralType(Size.SCALAR, el.name()));
                return type;
            }
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:131")
    public FFunctionType functionType() {
        FFunctionType functionType_value = getFunctionType();
        return functionType_value;
    }
    /** @apilevel internal */
    private void getFunctionType_reset() {
        getFunctionType_computed = false;
        
        getFunctionType_value = null;
    }
    /** @apilevel internal */
    protected boolean getFunctionType_computed = false;

    /** @apilevel internal */
    protected FFunctionType getFunctionType_value;

    /**
     * @attribute syn nta
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:134")
    public FFunctionType getFunctionType() {
        ASTState state = state();
        if (getFunctionType_computed) {
            return (FFunctionType) getChild(getFunctionTypeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFunctionType_value = getFunctionType_compute();
        setChild(getFunctionType_value, getFunctionTypeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFunctionType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FFunctionType node = (FFunctionType) this.getChild(getFunctionTypeChildPosition());
        return node;
    }
    /** @apilevel internal */
    private FFunctionType getFunctionType_compute() {
            List<FRecordComponentType> inputTypes = new List();
            List<FRecordComponentType> outputTypes = new List();
            for (InstComponentDecl icd : myInputs())
                inputTypes.add(new FRecordComponentType(icd.name(), icd.type().treeCopy()));
            for (InstComponentDecl icd : myOutputs())
                outputTypes.add(new FRecordComponentType(icd.name(), icd.type().treeCopy()));
            return new FFunctionType(Size.SCALAR, actualInstClass().qualifiedName(), inputTypes, outputTypes, null);
        }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:200
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:200")
    public boolean isReal() {
        boolean isReal_value = finalClass().primitiveName().equals("Real");
        return isReal_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:201
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:201")
    public boolean isInteger() {
        boolean isInteger_value = finalClass().primitiveName().equals("Integer");
        return isInteger_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:202
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:202")
    public boolean isBoolean() {
        boolean isBoolean_value = finalClass().primitiveName().equals("Boolean");
        return isBoolean_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:203
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:203")
    public boolean isString() {
        boolean isString_value = finalClass().primitiveName().equals("String");
        return isString_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:204")
    public boolean isEnum() {
        boolean isEnum_value = extendsEnum();
        return isEnum_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:206")
    public boolean isPartialFunction() {
        boolean isPartialFunction_value = isPartial() && isFunction();
        return isPartialFunction_value;
    }
    /**
     * Check if node is the same as this or the class of this component (if this is a component).
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:403
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:403")
    public boolean isMeOrMyClass(InstNode node) {
        boolean isMeOrMyClass_InstNode_value = node.inheritingNode() == this;
        return isMeOrMyClass_InstNode_value;
    }
    /**
     * Is this class partial?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:550
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:550")
    public boolean isPartial() {
        boolean isPartial_value = getSrcClassDecl().isPartial();
        return isPartial_value;
    }
    /**
     * Is this class encapsulated?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:555
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:555")
    public boolean isEncapsulated() {
        boolean isEncapsulated_value = getSrcClassDecl().isEncapsulated();
        return isEncapsulated_value;
    }
    /**
     * Is this class a connector?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:560
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:560")
    public boolean isConnector() {
        boolean isConnector_value = false;
        return isConnector_value;
    }
    /**
     * Is this class an expandable connector?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:578
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:578")
    public boolean isExpandableConnector() {
        boolean isExpandableConnector_value = false;
        return isExpandableConnector_value;
    }
    /**
     * Is this class an operator record?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:596
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:596")
    public boolean isOperatorRecord() {
        boolean isOperatorRecord_value = false;
        return isOperatorRecord_value;
    }
    /**
     * Is this class an operator?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:617
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:617")
    public boolean isOperator() {
        boolean isOperator_value = false;
        return isOperator_value;
    }
    /**
     * Is this class a record?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:644
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:644")
    public boolean isRecord() {
        boolean isRecord_value = false;
        return isRecord_value;
    }
    /**
     * Is this class a function or record?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:659
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:659")
    public boolean isCallable() {
        boolean isCallable_value = false;
        return isCallable_value;
    }
    /**
     * Is this class a package?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:677")
    public boolean isPackage() {
        boolean isPackage_value = false;
        return isPackage_value;
    }
    /**
     * Is this class a model?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:690
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:690")
    public boolean isModel() {
        boolean isModel_value = false;
        return isModel_value;
    }
    /**
     * Is this class a block?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:703
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:703")
    public boolean isBlock() {
        boolean isBlock_value = false;
        return isBlock_value;
    }
    /**
     * Is this class a class?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:716
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:716")
    public boolean isClass() {
        boolean isClass_value = false;
        return isClass_value;
    }
    /**
     * Is this class an external object?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:729
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:729")
    public boolean isExternalObject() {
        {
                for (InstExtends ie : getInstExtendss()) {
                    String name = ie.getClassName().name();
                    if (name.equals("ExternalObject"))
                        return true;
                }
                return false;
            }
    }
    /**
     * Check if this class has a restriction.
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:743
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:743")
    public boolean hasInstRestriction() {
        boolean hasInstRestriction_value = false;
        return hasInstRestriction_value;
    }
    /**
     * All local modifications except those from any target class.
     * 
     * Used for extends within components.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:350
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:350")
    public Collection<InstModification> localInstModificationsNoClass() {
        {
                ArrayList<InstModification> l = new ArrayList<InstModification>();
                if (hasInstClassModification()) {
                    l.add(getInstClassModification());
                }
                l.addAll(instModificationsFromConstrainingType());
                return l;
            }
    }
    /**
     * Local modifications only from any target class.
     * 
     * Used for extends within components.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:356")
    public Collection<InstModification> localInstModificationsClass() {
        Collection<InstModification> localInstModificationsClass_value = targetClassInstModifications();
        return localInstModificationsClass_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:393
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:393")
    public java.util.List<InstModification> targetClassInstModifications() {
        java.util.List<InstModification> targetClassInstModifications_value = Collections.<InstModification>emptyList();
        return targetClassInstModifications_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:411
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:411")
    public java.util.List<InstModification> instModificationsForConstraining() {
        {
                if (hasInstConstrainingClass()) {
                    if (getInstConstrainingClass().hasInstClassModification())
                        return Collections.singletonList((InstModification) getInstConstrainingClass().getInstClassModification());
                } else {
                    if (hasInstClassModification())
                        return Collections.singletonList((InstModification) getInstClassModification());
                }
                return Collections.<InstModification>emptyList();
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422")
    public java.util.List<InstModification> instModificationsFromConstrainingType() {
        java.util.List<InstModification> instModificationsFromConstrainingType_value = instModificationsForConstraining();
        return instModificationsFromConstrainingType_value;
    }
    /**
     * Return OriginalInstClass for nodes that have it, null otherwise.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:453
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:453")
    public InstClassDecl originalInstClass() {
        InstClassDecl originalInstClass_value = null;
        return originalInstClass_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:458
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:458")
    public boolean hasInstClassModification() {
        boolean hasInstClassModification_value = false;
        return hasInstClassModification_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:461
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:461")
    public InstClassModification getInstClassModification() {
        InstClassModification getInstClassModification_value = null;
        return getInstClassModification_value;
    }
    /** @apilevel internal */
    private void classInstModifications_reset() {
        classInstModifications_computed = false;
        
        classInstModifications_value = null;
    }
    /** @apilevel internal */
    protected boolean classInstModifications_computed = false;

    /** @apilevel internal */
    protected ArrayList<InstModification> classInstModifications_value;

    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:489
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:489")
    public ArrayList<InstModification> classInstModifications() {
        ASTState state = state();
        if (classInstModifications_computed) {
            return classInstModifications_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        classInstModifications_value = getMergedEnvironment().clone();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        classInstModifications_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return classInstModifications_value;
    }
    /**
     * Find the instance tree node an extends below this node, from a short class declaration, 
     * should look up right hand side names in its modification from.
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1018
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1018")
    public InstNode instLookupNodeForShortClassExtends() {
        InstNode instLookupNodeForShortClassExtends_value = null;
        return instLookupNodeForShortClassExtends_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1140")
    public SrcClassDecl redeclaringClassDecl() {
        SrcClassDecl redeclaringClassDecl_value = getSrcClassDecl();
        return redeclaringClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1143
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1143")
    public InstClassDecl redeclaringInstClassDecl() {
        InstClassDecl redeclaringInstClassDecl_value = this;
        return redeclaringInstClassDecl_value;
    }
    /**
     * A connector class inheriting a record class is both connector and record, 
     * this method finds any inherited restriction that should be kept.
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1518
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1518")
    public InstRestriction inheritedRestriction(boolean checkMine) {
        InstRestriction inheritedRestriction_boolean_value = null;
        return inheritedRestriction_boolean_value;
    }
    /**
     * If this is a short class declaration we return the RHS class, else this.
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1705
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1705")
    public InstClassDecl myTargetInstClassDecl() {
        InstClassDecl myTargetInstClassDecl_value = this;
        return myTargetInstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1939
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1939")
    public String name() {
        String name_value = getSrcClassDecl().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1990
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1990")
    public String buildQualifiedOperatorName() {
        String buildQualifiedOperatorName_value = combineName(instClassNamePrefix(true), name());
        return buildQualifiedOperatorName_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2084
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2084")
    public ArrayList<InstEnumLiteral> enumLiterals() {
        ArrayList<InstEnumLiteral> enumLiterals_value = extendsEnum() ? getInstExtends(0).myInstClass().enumLiterals() : new ArrayList<InstEnumLiteral>();
        return enumLiterals_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2104")
    public boolean hasInstConstrainingClass() {
        boolean hasInstConstrainingClass_value = false;
        return hasInstConstrainingClass_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2105
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2105")
    public InstConstrainingClass getInstConstrainingClass() {
        InstConstrainingClass getInstConstrainingClass_value = null;
        return getInstConstrainingClass_value;
    }
    /**
     * Is this declaration replaceable?
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2145")
    public boolean isReplaceable() {
        boolean isReplaceable_value = getSrcClassDecl().getReplaceable();
        return isReplaceable_value;
    }
    /**
     * Check if this node is a class declaration or an extends in one.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2170")
    public boolean isClassDecl() {
        boolean isClassDecl_value = true;
        return isClassDecl_value;
    }
    /**
     * Check if this class is or extends an enumeration.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2211
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2211")
    public boolean extendsEnum() {
        boolean extendsEnum_value = getNumInstExtends() == 1 && getInstExtends(0).extendsEnum();
        return extendsEnum_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2218")
    public InstClassDecl getBaseInstClass() {
        InstClassDecl getBaseInstClass_value = (getNumInstExtends() > 0) ? getInstExtends(0).getBaseInstClass() : this;
        return getBaseInstClass_value;
    }
    /** @apilevel internal */
    private void getClassAnnotationOpt_reset() {
        getClassAnnotationOpt_computed = false;
        
        getClassAnnotationOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getClassAnnotationOpt_computed = false;

    /** @apilevel internal */
    protected Opt<InstClassModification> getClassAnnotationOpt_value;

    /**
     * @attribute syn nta
     * @aspect InstanceAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2717
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2717")
    public Opt<InstClassModification> getClassAnnotationOpt() {
        ASTState state = state();
        if (getClassAnnotationOpt_computed) {
            return (Opt<InstClassModification>) getChild(getClassAnnotationOptChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getClassAnnotationOpt_value = new Opt<InstClassModification>();
        if(getClassAnnotationOpt_value.numChildren() <= 0) {
            getClassAnnotationOpt_value  = Opt.EMPTY;
        }

        setChild(getClassAnnotationOpt_value, getClassAnnotationOptChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getClassAnnotationOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        Opt<InstClassModification> node = (Opt<InstClassModification>) this.getChild(getClassAnnotationOptChildPosition());
        return node;
    }
    /**
     * If this class was inherited into this scope, return the corresponding class 
     * from the inherited class. 
     * 
     * The inhetitance can be either direct or through a surronding class that was 
     * inherited in. This method only follows a single extends.
     * 
     * If no surrounding extends exists or any lookup fails, <code>this</code> is returned.
     * @attribute syn
     * @aspect InheritedFrom
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2764
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InheritedFrom", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2764")
    public InstClassDecl myInheritedOrigin() {
        {
                InstClassDecl res = inheritedOriginHelper(name());
                return res.isUnknown() ? this : res;
            }
    }
    /**
     * Calculate the functions that matches the two given types in this operator.
     * 
     * Delegates to the restriction, where results are cached.
     * 
     * @param a         an operand that is of the operator record type that contains this function
     * @param b         the other operand. If it is <code>null</code>, then the function should be unary.
     * @param aIsLeft   <code>true</code> if a is the left operand, must be true if b is <code>null</code>
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:362")
    public OperatorMatches matchOverloadedOperators(FType a, FType b, boolean aIsLeft) {
        OperatorMatches matchOverloadedOperators_FType_FType_boolean_value = OperatorMatches.EMPTY;
        return matchOverloadedOperators_FType_FType_boolean_value;
    }
    /**
     * Get a list of all functions in this operator.
     * 
     * If this is not an operator or operator function, an empty list is returned.
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:388
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:388")
    public java.util.List<InstClassDecl> operatorFunctions() {
        java.util.List<InstClassDecl> operatorFunctions_value = Collections.emptyList();
        return operatorFunctions_value;
    }
    /**
     * Check if this function matches the two given types as an overloaded operator.
     * 
     * @param a         an operand that is of the operator record type that contains this function
     * @param b         the other operand. If it is <code>null</code>, then the function should be unary.
     * @param aIsLeft   <code>true</code> if a is the left operand, must be true if b is <code>null</code>
     * @param indirect  if <code>true</code>, then look for a constructor that can convert b to fit this function
     * @attribute syn
     * @aspect OverloadedOperatorBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:416
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverloadedOperatorBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:416")
    public boolean matchesAsOperatorFunction(FType a, FType b, boolean aIsLeft, boolean indirect) {
        {
                java.util.List<InstComponentDecl> inputs = myInputs();
                int n = inputs.size();
                InstComponentDecl in1 = (n > 0) ? inputs.get(0) : null;
                InstComponentDecl in2 = (n > 1) ? inputs.get(1) : null;
                InstComponentDecl ain = aIsLeft ? in1 : in2;
                InstComponentDecl bin = aIsLeft ? in2 : in1;
                
                // Check that function is unary in unary case and binary in binary case (since '-' can contain both)
                if ((n < 2 || in2.hasBindingFExp()) != (b == null))
                    return false;
                for (int i = 2; i < n; i++)
                    if (!inputs.get(i).hasBindingFExp())
                        return false;
                
                // Unary case
                if (b == null)
                    return ain != null && ain.type().typeCompatible(a);  // a matches first argument
                
                // Indirect binary case
                if (indirect) {
                    if (bin == null || !bin.type().isOperatorRecord())  // if b isn't an operator record, no indirect match
                        return false;
                    // Find constructor matching single argument
                    return ain != null && ain.type().typeCompatible(a, true) &&  // a matches its argument
                           bin.type().matchOverloadedConstructor(b) != null;     // there is a single matching constructor for b
                }
                
                // Direct binary case
                return ain != null && ain.type().typeCompatible(a, true) &&  // a matches its argument
                       bin != null && bin.type().typeCompatible(b, true);    // b matches its argument
            }
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:111")
    public boolean isAssignable() {
        boolean isAssignable_value = isPrimitive() || isRecord();
        return isAssignable_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:54
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:54")
    public boolean isCompositeType() {
        boolean isCompositeType_value = !isRecord() && !isPrimitive();
        return isCompositeType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:61
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:61")
    public boolean isRecordType() {
        boolean isRecordType_value = isRecord();
        return isRecordType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:65")
    public boolean isPrimitiveType() {
        boolean isPrimitiveType_value = isOrExtendsPrimitive();
        return isPrimitiveType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192")
    public InstNode constrainingInstType() {
        InstNode constrainingInstType_value = hasInstConstrainingClass() ? getInstConstrainingClass().getInstNode() : findConstrainingInstType();
        return constrainingInstType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:201
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:201")
    public InstNode findConstrainingInstType() {
        InstNode findConstrainingInstType_value = this;
        return findConstrainingInstType_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:242
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:242")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = getSrcClassDecl().myStringComment();
        return myStringComment_value;
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
        AnnotationNode annotation_InstContext_value = getSrcClassDecl().annotation(instContext);
        return annotation_InstContext_value;
    }
    /**
     * Obtaines the orginal annotatable for a class or component.
     * Gives the orginal class or component for every replacing type.  
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2109
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2109")
    public SrcAnnotatable orginalAnnotatable() {
        SrcAnnotatable orginalAnnotatable_value = getSrcClassDecl();
        return orginalAnnotatable_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:809
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:809")
    public String primitiveName() {
        String primitiveName_value = name();
        return primitiveName_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210")
    public boolean isPublic() {
        boolean isPublic_value = getSrcClassDecl().isPublic();
        return isPublic_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1218")
    public boolean isProtected() {
        boolean isProtected_value = getSrcClassDecl().isProtected();
        return isProtected_value;
    }
    /**
     * Check if this class is declared inner.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1491
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1491")
    public boolean isInner() {
        boolean isInner_value = getSrcClassDecl().isInner();
        return isInner_value;
    }
    /**
     * Check if this component is declared outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1502
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1502")
    public boolean isOuter() {
        boolean isOuter_value = getSrcClassDecl().isOuter();
        return isOuter_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1593
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1593")
    public InstClassDecl asInstClassDecl() {
        InstClassDecl asInstClassDecl_value = this;
        return asInstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1596
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1596")
    public InstCallable actualInstCallable() {
        InstCallable actualInstCallable_value = actualInstClass();
        return actualInstCallable_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1599")
    public InstClassDecl actualInstClassDecl() {
        InstClassDecl actualInstClassDecl_value = actualInstClass();
        return actualInstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1602
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1602")
    public InstNode asInstNode() {
        InstNode asInstNode_value = this;
        return asInstNode_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1622
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1622")
    public InstCallable asCallable() {
        InstCallable asCallable_value = this;
        return asCallable_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1630
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1630")
    public InstClassDecl finalClass() {
        InstClassDecl finalClass_value = this;
        return finalClass_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1647")
    public boolean isInput() {
        boolean isInput_value = false;
        return isInput_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1657
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1657")
    public boolean isOutput() {
        boolean isOutput_value = false;
        return isOutput_value;
    }
    /**
     * Any extra info to add to the memory use output.
     * @attribute syn
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:669
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MemoryUse", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:669")
    public String extraMemoryUseInfo() {
        String extraMemoryUseInfo_value = " \"" + name() + "\"";
        return extraMemoryUseInfo_value;
    }
    /**
     * @attribute syn
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:896
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SmoothOrder", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:896")
    public int smoothOrder() {
        int smoothOrder_value = readSmoothOrderAnnotation(findSmoothOrderAnnotationRoot());
        return smoothOrder_value;
    }
    /**
     * @attribute syn
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:27
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AbsoluteValue", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:27")
    public boolean isAbsoluteValue() {
        boolean isAbsoluteValue_value = true;
        return isAbsoluteValue_value;
    }
    /**
     * If this class is in an operator record or in a package in an operator record, find that operator record.
     * @attribute inh
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:841
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:841")
    public InstClassDecl myOperatorRecord() {
        InstClassDecl myOperatorRecord_value = getParent().Define_myOperatorRecord(this, null);
        return myOperatorRecord_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1573")
    public boolean isWithin(InstClassDecl icd) {
        boolean isWithin_InstClassDecl_value = getParent().Define_isWithin(this, null, icd);
        return isWithin_InstClassDecl_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1536
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1536")
    public boolean inExternalObject() {
        boolean inExternalObject_value = getParent().Define_inExternalObject(this, null);
        return inExternalObject_value;
    }
    /**
     * @attribute inh
     * @aspect InheritedFrom
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2769
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InheritedFrom", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2769")
    public InstClassDecl inheritedOriginHelper(String name) {
        InstClassDecl inheritedOriginHelper_String_value = getParent().Define_inheritedOriginHelper(this, null, name);
        return inheritedOriginHelper_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:411
     * @apilevel internal
     */
    public ArrayList<FArraySubscripts> Define_surroundingFArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new ArrayList<FArraySubscripts>(0);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:411
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFArraySubscripts
     */
    protected boolean canDefine_surroundingFArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154
     * @apilevel internal
     */
    public boolean Define_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isConstructor();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:154
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorStmt
     */
    protected boolean canDefine_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159
     * @apilevel internal
     */
    public boolean Define_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isDestructor();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:159
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorStmt
     */
    protected boolean canDefine_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     */
    public boolean Define_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecord
     */
    protected boolean canDefine_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3154
     * @apilevel internal
     */
    public boolean Define_inRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isRecord();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3154
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordDecl
     */
    protected boolean canDefine_inRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1435
     * @apilevel internal
     */
    public InstNode Define_containingEntity(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1435
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingEntity
     */
    protected boolean canDefine_containingEntity(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:230
     * @apilevel internal
     */
    public boolean Define_isForOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isOperatorRecord();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:230
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForOperatorRecordDeclarationMember
     */
    protected boolean canDefine_isForOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:841
     * @apilevel internal
     */
    public InstClassDecl Define_myOperatorRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isOperatorRecord() ? this : (isPackage() ? myOperatorRecord() : null);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:841
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myOperatorRecord
     */
    protected boolean canDefine_myOperatorRecord(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:436
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lockBranch
     */
    protected boolean canDefine_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668
     * @apilevel internal
     */
    public boolean Define_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInstComponent
     */
    protected boolean canDefine_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1572
     * @apilevel internal
     */
    public boolean Define_isWithin(ASTNode _callerNode, ASTNode _childNode, InstClassDecl icd) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return icd == this || (!isFunction() && isWithin(icd));
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1572
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isWithin
     */
    protected boolean canDefine_isWithin(ASTNode _callerNode, ASTNode _childNode, InstClassDecl icd) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:295
     * @apilevel internal
     */
    public InstModification Define_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getClassAnnotationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:300
            return getClassAnnotation();
        }
        else {
            return super.Define_parentInstModification(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:295
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentInstModification
     */
    protected boolean canDefine_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:304
     * @apilevel internal
     */
    public boolean Define_inRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordWithBindingExp
     */
    protected boolean canDefine_inRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:406
     * @apilevel internal
     */
    public boolean Define_isInRedeclareMod(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:406
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInRedeclareMod
     */
    protected boolean canDefine_isInRedeclareMod(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:624
     * @apilevel internal
     */
    public InstComponentDecl Define_myFlowVar(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isConnector() ? findFlowVar() : null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:624
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFlowVar
     */
    protected boolean canDefine_myFlowVar(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1266
     * @apilevel internal
     */
    public InstComponentDecl Define_findCellUp(ASTNode _callerNode, ASTNode _childNode, Index i, int j, InstComponentDecl src) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return src;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1266
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findCellUp
     */
    protected boolean canDefine_findCellUp(ASTNode _callerNode, ASTNode _childNode, Index i, int j, InstComponentDecl src) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3010
     * @apilevel internal
     */
    public InstComponentDecl Define_findExpandableAncestor(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3010
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findExpandableAncestor
     */
    protected boolean canDefine_findExpandableAncestor(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3023
     * @apilevel internal
     */
    public InstComponentDecl Define_ancestorChild(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl a, InstComponentDecl c) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3023
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute ancestorChild
     */
    protected boolean canDefine_ancestorChild(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl a, InstComponentDecl c) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952
     * @apilevel internal
     */
    public FAccess Define_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new FAccessFull();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandedFAccess
     */
    protected boolean canDefine_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784
     * @apilevel internal
     */
    public FExp Define_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentBindingFExp
     */
    protected boolean canDefine_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1824
     * @apilevel internal
     */
    public FExp Define_splitBindingFExp(ASTNode _callerNode, ASTNode _childNode, FExp fe, InstNode node, int dims) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return fe;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1824
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute splitBindingFExp
     */
    protected boolean canDefine_splitBindingFExp(ASTNode _callerNode, ASTNode _childNode, FExp fe, InstNode node, int dims) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     * @apilevel internal
     */
    public InstValueModification Define_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentInstValueMod
     */
    protected boolean canDefine_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2212
     * @apilevel internal
     */
    public InstNode Define_parentNodeToSetModLevelFor(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return hasModificationLevel() ? null : this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2212
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentNodeToSetModLevelFor
     */
    protected boolean canDefine_parentNodeToSetModLevelFor(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new FAccessEmpty();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccess
     */
    protected boolean canDefine_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:218
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccessFromModification(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return retrieveFAccess();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:218
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccessFromModification
     */
    protected boolean canDefine_retrieveFAccessFromModification(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:295
     * @apilevel internal
     */
    public String Define_findTempVarName(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl var) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return localTempVarName(var);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:295
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findTempVarName
     */
    protected boolean canDefine_findTempVarName(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl var) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:235
     * @apilevel internal
     */
    public String Define_myTempVarName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                String sqn = "";
                while (componentExists(sqn = nextTempVarName())) {}
                return sqn;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:235
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTempVarName
     */
    protected boolean canDefine_myTempVarName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:21
     * @apilevel internal
     */
    public boolean Define_inOuter(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:21
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inOuter
     */
    protected boolean canDefine_inOuter(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:27
     * @apilevel internal
     */
    public boolean Define_inInner(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:27
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInner
     */
    protected boolean canDefine_inInner(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:146
     * @apilevel internal
     */
    public InstClassDecl Define_lookupInInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInnerInstClassDecl().memberInstClass(name).targetOrNull();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:146
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInInnerInstClass
     */
    protected boolean canDefine_lookupInInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:436
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_localLookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return memberInstComponent(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:436
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute localLookupInstComponent
     */
    protected boolean canDefine_localLookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:321
     * @apilevel internal
     */
    public Size Define_expectedSizeFromParent(ASTNode _callerNode, ASTNode _childNode, boolean useEach) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return size();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:321
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expectedSizeFromParent
     */
    protected boolean canDefine_expectedSizeFromParent(ASTNode _callerNode, ASTNode _childNode, boolean useEach) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:419
     * @apilevel internal
     */
    public InstNode Define_findInheritingNode(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:420
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return this;
        }
        else {
            return getParent().Define_findInheritingNode(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:419
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findInheritingNode
     */
    protected boolean canDefine_findInheritingNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:428
     * @apilevel internal
     */
    public InstClassDecl Define_surroundingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:428
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingInstClass
     */
    protected boolean canDefine_surroundingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:437
     * @apilevel internal
     */
    public boolean Define_inArrayComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:437
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArrayComponent
     */
    protected boolean canDefine_inArrayComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36
     * @apilevel internal
     */
    public TypePrefixVariability Define_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return Variability.CONTINUOUS;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute overrideVariability
     */
    protected boolean canDefine_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138
     * @apilevel internal
     */
    public AnnotationNode Define_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return AnnotationNode.NO_ANNOTATION;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentEvalAnnotation
     */
    protected boolean canDefine_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:219
     * @apilevel internal
     */
    public TypePrefixVariability Define_parentDefaultVariability(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:219
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentDefaultVariability
     */
    protected boolean canDefine_parentDefaultVariability(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1815
     * @apilevel internal
     */
    public boolean Define_inExpandableConnector(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1815
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inExpandableConnector
     */
    protected boolean canDefine_inExpandableConnector(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2183
     * @apilevel internal
     */
    public boolean Define_isInClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2183
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInClassDecl
     */
    protected boolean canDefine_isInClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2286
     * @apilevel internal
     */
    public InstComponentDecl Define_containingInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2286
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstComponent
     */
    protected boolean canDefine_containingInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2479
     * @apilevel internal
     */
    public InstNode Define_containingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2479
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstClassDecl
     */
    protected boolean canDefine_containingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2769
     * @apilevel internal
     */
    public InstClassDecl Define_inheritedOriginHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2772
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return inheritedOriginHelper(name()).memberInstClass(name).target(INST_UNKNOWN_CLASS, this);
        }
        else {
            return super.Define_inheritedOriginHelper(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2769
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritedOriginHelper
     */
    protected boolean canDefine_inheritedOriginHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001
     * @apilevel internal
     */
    public SrcAnnotatable Define_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getSrcClassDecl();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute elementModification
     */
    protected boolean canDefine_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:312
     * @apilevel internal
     */
    public SrcClassDecl Define_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getSrcClassDecl().myTopSrcClassDecl();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:312
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTopSrcClassDecl
     */
    protected boolean canDefine_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2797
     * @apilevel internal
     */
    public String Define_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return buildInstanceName(this, new FAccessEmpty());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2797
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcInstanceName
     */
    protected boolean canDefine_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868
     * @apilevel internal
     */
    public String Define_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
        	  String path = topPackagePath();
        	  return (path == null) ? dirName() : path;
          }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute topPackagePath
     */
    protected boolean canDefine_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:892
     * @apilevel internal
     */
    public InstClassDecl Define_containingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:892
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstClass
     */
    protected boolean canDefine_containingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     * @apilevel internal
     */
    public boolean Define_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inProtectedComponent
     */
    protected boolean canDefine_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1390
     * @apilevel internal
     */
    public InstComponentDecl Define_inheritsInputOutputFrom(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1390
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsInputOutputFrom
     */
    protected boolean canDefine_inheritsInputOutputFrom(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1407
     * @apilevel internal
     */
    public boolean Define_isTopLevel(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1407
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopLevel
     */
    protected boolean canDefine_isTopLevel(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1438
     * @apilevel internal
     */
    public InstComponentDecl Define_inheritsFlowFrom(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1438
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsFlowFrom
     */
    protected boolean canDefine_inheritsFlowFrom(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1538
     * @apilevel internal
     */
    public boolean Define_inDisabledComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1538
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inDisabledComponent
     */
    protected boolean canDefine_inDisabledComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
