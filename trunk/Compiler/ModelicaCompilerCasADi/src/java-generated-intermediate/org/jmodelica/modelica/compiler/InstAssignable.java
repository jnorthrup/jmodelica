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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:110
 * @astdecl InstAssignable : InstComponentDecl;
 * @production InstAssignable : {@link InstComponentDecl};

 */
public abstract class InstAssignable extends InstComponentDecl implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3673
     */
    public void resetAfterCeval() {
        super.resetAfterCeval();
        clearLocalCachedEvaluationValue();
        if (hasBindingFExp()) {
            myBindingInstExp().resetAfterCeval();
        }
        size().resetAfterCeval();
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3888
     */
    protected CValue cevalFunctionBindingExp(VariableEvaluator evaluator) {
        return hasBindingFExp() ? myBindingInstExp().ceval(evaluator) : type().zeroCValue();
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:263
     */
    public void contentCheck(ErrorCheckType checkType) {
        super.contentCheck(checkType);
        if (isDeclaredInput() || isDeclaredOutput()) {
            InstComponentDecl inherit = inheritsInputOutputFrom();
            if (inherit != null)
                inherit.error("Can't declare %s as %s, since it contains a component declared as input or output", 
                        name(), (isDeclaredInput() ? "input" : "output"));
        }
        if (isDeclaredFlow()) {
            InstComponentDecl inherit = inheritsFlowFrom();
            if (inherit != null)
                inherit.error("Can't declare %s as flow, since it contains a component declared as flow", name());
        }
        if (isExternalObject() && hasBindingFExp() && !getBindingFExp().variability().lessOrEqual(variability())) {
            ASTNode.BINDING_EXPRESSION_VARIABILITY.invoke(this, 
                getBindingFExp().variability().toStringLiteral(), variability().toStringLiteral());
        }
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:851
     */
    private TypePrefixVariability forcedVariability = Variability.CONTINUOUS;
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:879
     */
    public void forceVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        if (forcedVariability.lessOrEqual(v)) {
            return;
        }
        TypePrefixVariability currentVariability = variability().combine();
        if (!currentVariability.parameterVariability() || inFunction() || isForIndex())
            return;
        if (indices().numElements() > 0 && currentVariability.initialParameterVariability()) {
            compliance("Parameters with fixed=false can not be used as structural parameters");
            return;
        }
        forcedVariability = forcedVariability.combineDown(v);
        // Flush cache for variability()
        setVariabilityNotCalculated();
        if (hasBindingFExp()) {
            if (v.structParameterVariability()) {
                getBindingFExp().checkConstantExpression(checkType, forcedVariability.toStringLiteral(), qualifiedName());
            }
            getBindingFExp().forceUsesVariability(checkType, v);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:937
     */
    public void collectErrors(ErrorCheckType checkType) {
        //log.debug(toString());
        if (!errorChecked) {
            super.collectErrors(checkType);
            errorChecked = true;
            
            // Check modification
            if (hasInstValueMod()) {
                myInstValueMod().collectErrors(checkType);
            }
            
            if (hasBindingFExp()) {
                // Check if the binding expression of constants can be evaluated
                FExp bexp = getBindingFExp();
                if (isConstant() && !bexp.type().isUnknown()) {
                    bexp.checkConstantExpression(checkType, "constant", qualifiedName());
                } else if (isParameter() && bexp.isCircular()) {
                    bexp.error("Circularity in binding expression of parameter: %s = %s", qualifiedName(), bexp);
                }
            } else {
                // Warn if constant or parameter does not have a binding expression (start is used)
                if (variability().fixedParameterOrLess() && !isForIndex() && !isRecord() && 
                        !hasParentRecordWithBindingExp() && !inFunction()) {
                    if (isParameter()) {
                        PARAMETER_MISSING_BINDING_EXPRESSION.invoke(this, qualifiedName());
                    } else {
                        CONSTANT_MISSING_BINDING_EXPRESSION.invoke(this, qualifiedName());
                    }
                }
            }
            
            TypePrefixVariability v = variability().combine();
            // Mark parameters with Evaluate=true as structural
            if (v.parameterVariability() && isEvalAnnotated(true)) {
                if (v.fixedParameterOrLess()) {
                    forceVariability(checkType, Variability.STRUCTPARAMETER);
                } else {
                    warning("Evaluate annotation is ignored for parameters with fixed=false");
                }
            }
            
            // Check array indices
            getClassName().collectErrors(checkType);
            getLocalFArraySubscriptsOpt().collectErrors(checkType);
            
            // Check attributes for primitive variables
            checkAttributes(checkType);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:987
     */
    public void checkAttributes(ErrorCheckType checkType) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:202
     */
    public void typeCheck(ErrorCheckType checkType) {
        FExp bexp = myBindingInstExp();
        boolean function = inFunction();
        boolean record = inRecordDecl();
        boolean output = isOutput();
        boolean incompleteAllowed = (function && !output) || record;
        boolean unknownAllowed = function || record;
        Size componentSize = size();
        if (!componentSize.isComplete() && !incompleteAllowed && !checkType.allowIncompleteSizes()) {
            if (function && output) {
                CANNOT_INFER_ARRAY_SIZE_OF_FUNCTION_OUTPUT.invoke(surroundingInstClass(), qualifiedName());
            } else {
                CANNOT_INFER_ARRAY_SIZE_OF_VARIABLE.invoke(this, name());
            }
        }
        if (bexp != null && !inRecordWithBindingExp() && !bexp.type().isUnknown() && checkType.checkTypes()) {
            Index arrayIndex = indexInModification();
            
            CommonType expectedBT = expectedBindingType();
            CommonType actualBT = actualBindingType();
            
            boolean reportedError = false;
            if (!expectedBT.size().equivalent(actualBT.size(), unknownAllowed)) {
                InstValueModification ivm = myInstValueMod();
                InstModification needsEach = ivm.findModificationLackingEach(actualBT.size());
                if (!expectedBT.scalarType().typeCompatible(actualBT.scalarType())) {
                    BINDING_EXPRESSION_TYPE_MISMATCH.invoke(bexp, name());
                    reportedError = true;
                } else if (needsEach != null) {
                    ASSUMING_EACH.invoke(needsEach, needsEach);
                    actualBT = actualBT.expand(expectedBT.size().contractLeft(expectedBT.ndims() - actualBT.ndims()));
                } else if (ivm.expectedSizeNoEach().equivalent(actualBT.size(), unknownAllowed)) {
                    InstModification parIM = ivm.parentInstModification();
                    IGNORING_EACH.invoke(parIM, parIM);
                    expectedBT = expectedBindingTypeNoEach();
                    arrayIndex = indexInModificationNoEach();
                } else {
                    ErrorProducerUnlessDisabled reporter;
                    if (ivm.myInstNode() == this) {
                        reporter = ARRAY_SIZE_MISMATCH_IN_DECLARATION;
                    } else if (ivm.hasEach()) {
                        reporter = ARRAY_SIZE_MISMATCH_IN_MODIFICATION_DUE_TO_EACH;
                    } else {
                        reporter = ARRAY_SIZE_MISMATCH_IN_MODIFICATION;
                    }
                    reporter.invokeWithCondition(bexp, expectedBT.ndims() == actualBT.ndims(), name(), expectedBT.size(), actualBT.size());
                    reportedError = true;
                }
            }
            
            if (!reportedError) {
                if (expectedBT.size().isEmpty() || expectedBT.size().isUnknown() || actualBT.size().isUnknown()) {
                    typeCheckCell(expectedBT.scalarType(), actualBT.scalarType(), bexp, unknownAllowed);
                } else {
                    Size arraySize = expectedBT.size().contractLeft(expectedBT.ndims() - arrayIndex.ndims());
                    for (Index index : Indices.create(arraySize)) {
                        index = arrayIndex.expand(index);
                        CommonType expected = expectedBT.cell(index);
                        CommonType actual = actualBT.cell(index);
                        
                        typeCheckCell(expected, actual, bexp, unknownAllowed);
                    }
                }
            }
        }
        
        if (hasConditionalAttribute()) {
            FExp cond = getConditionalAttribute();
            if (!cond.type().isUnknown()) {
                if (!cond.type().isScalar()) 
                    NON_SCALAR_CONDITIONAL_GUARD.invoke(this);
                if (!cond.type().isBoolean()) 
                    NON_BOOLEAN_CONDITIONAL_GUARD.invoke(this);
                if (!cond.variability().parameterOrLess()) {
                    NON_FIXED_CONDITIONAL_GUARD.invoke(this);
                } else {
                    cond.markAsStructuralParameter(checkType);
                }
            }
        }
        
        typeCheckAttributes();
        super.typeCheck(checkType);
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:287
     */
    private void typeCheckCell(CommonType expectedBT, CommonType actualBT, FExp bexp, boolean unknownAllowed) {
        if (!expectedBT.typeCompatible(actualBT, unknownAllowed) && !expectedBT.isUnknown()) {
            if (!expectedBT.scalarType().typeCompatible(actualBT.scalarType())) {
                BINDING_EXPRESSION_TYPE_MISMATCH.invoke(bexp, name());
            }
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:311
     */
    public void typeCheckAttributes() {}
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1319
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        if (useInFlattening() && hasBindingFExp())
            getBindingFExp().buildConnectionSets(prefix, csm, connect);
        if (isOperatorRecord())
            buildConnectionSetsAsPrimitive(prefix, csm, connect);
        else
            super.buildConnectionSets(prefix, csm, connect);
    }
    /**
     * Name of equality constraint function.
     * @aspect OverconstrainedConnections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1474
     */
    public static final String EQUALITY_CONSTRAINT_NAME = "equalityConstraint";
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:811
     */
    public void addExternalArg(FExternalStmt stmt) {
        InstAccessExp access = new InstAccessExp(new InstComponentAccess(name()));
        stmt.addArg(access);
        for (int i = 0; i < ndims(); i++) {
            stmt.addArg(new FSizeExp(access.treeCopy(), new Opt(new FIntegerLitExp(i + 1))));
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:843
     */
    @Override
    public void flattenInFunction(Flattener f, List<FFunctionVariable> vars, List<FStatement> stmts) {
        if (!flattenAsGlobalVariableFromFunction()) {
            if (hasInstValueMod())
                getBindingFExp().flattenUsedFuncsAndEnums(f);
            Opt eo = new Opt();
            FAccess access = getFAccess().treeCopy().removeFArraySubscripts();
            FFunctionVariable ffv = createFFunctionVariable(f, eo, access);
            if (isInput())
                ffv.setTypePrefixInputOutput(TypePrefixInputOutput.INPUT);
            else if (isOutput())
                ffv.setTypePrefixInputOutput(TypePrefixInputOutput.OUTPUT);
            else
                ffv.setTypePrefixInputOutput(TypePrefixInputOutput.NONE);
            vars.addChild(ffv);
            if (isComposite()) {
                addFInitArrayStmt(f, stmts, isInput(), expandedFAccessCalc(), new ForNames());
            }
            if (!isInput()) {
                addBindingAssignments(f, stmts);
            }
            myInstClass().flattenRecord(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:872
     */
    public void addFInitArrayStmt(Flattener f, List<FStatement> l, boolean input, FAccess access, ForNames names) {
        if (isArray()) {
            if (input) {
                size().addSizeCheck(f, l, this, access);
            } else {
                FInitArrayStmt stmt = new FInitArrayStmt(new FAccessExp(access));
                stmt.shouldBeSorted = true;
                l.add(stmt);
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:932
     */
    public void addBindingAssignments(Flattener f, List<FStatement> l) {
        if (hasBindingFExp()) {
            FAssignableExp left = setLocationOf(new FAccessExp(expandedFAccessCalc()));
            FStatement stmt;
            if (scalarizedAsFFunctionCallStmt()) {
                List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
                lefts.add(new FFunctionCallLeft(new Opt<FExp>(left)));
                stmt = new FFunctionCallStmt(lefts, (FAbstractFunctionCall) getBindingFExp().flatten(f));
            } else {
                stmt = new FAssignStmt(left, getBindingFExp().flatten(f));
            }
            stmt.shouldBeSorted = true;
            l.add(stmt);
        } else {
            super.addBindingAssignments(f, l);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:974
     */
    public FFunctionVariable createFFunctionVariable(Flattener f, Opt eo, FAccess access) {
        // TODO: if we need separate variable class for records, override this
        FType type = type().flatten(f, this, !isInput());
        FFunctionVariable ffv;
        if (isArray())
            ffv = new FFunctionArray(TypePrefixInputOutput.NONE, type, eo, access);
        else
            ffv = new FFunctionVariable(TypePrefixInputOutput.NONE, type, eo, access);
        return ffv;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1196
     */
    public void flattenInRecord(Flattener f, FRecordDecl frd, Set<String> names) {
        if (names.add(name())) {
            FAccess access;
            if (isArray()) {
                List<FAccessPart> l = new List<FAccessPart>();
                l.add(new FAccessPartArray(name(), size().flattenFArraySubscripts(f)));
                access = new FAccessFull(l);
            } else {
                access = new FAccessString(name());
            }
            FVariable fv = createFVariable(f, access, FlattenBindingExp.NONE, false);
            fv.modifiableInRecord = isModifiable();
            frd.addFVariableNoTransform(fv);
            flattenMyType(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1237
     */
    public void flatten(Flattener f, FlattenBindingExp binding, int level) {
        flatten(f, binding, level, false);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1241
     */
    public void flatten(Flattener f, FlattenBindingExp binding, int level, boolean global) {
        if (useInFlattening() && (global || !flattenAsGlobalVariable())) {
            if (hasBindingFExp()) {
                getBindingFExp().flattenAssertExternal(f);
            }
            HashMap<InstNode,Integer> oldLevels = setModificationLevel(level);
            FAccess name;
            if (global) {
                name = getFAccess().copyAndPrepend(surroundingInstClass().qualifiedName()).copyAndAddFas(size().flattenFArraySubscripts(f));
            } else {
                name = getFAccess().copyAndAddFas(size().flattenFArraySubscripts(f));
            }
            FVariable fv = createFVariable(f, name, binding, global);
            if (global) {
                f.addGlobalVariable(fv);
            } else {
                f.addFVariable(fv);
            }
            flattenMyType(f);
            clearModificationLevel(oldLevels);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1323
     */
    public abstract void flattenMyType(Flattener f);
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1523
     */
    public FVariable createEmptyFGlobalVariable(Flattener f) {
        FGlobalVariable res = new FGlobalVariable();
        res.setFType(type().flatten(f, this, false));
        return res;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1529
     */
    public abstract FVariable createEmptyFVariable();
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1593
     */
    @Override
    public void addAttributesToFV(Flattener f, List<FAttribute> attr, Stack<Integer> indexStack,
            FlattenBindingExp binding, boolean isBound) {
        if (!variability().knownParameterOrLess()) {
            AttributeExpRetriever mut = new AttributeExpRetriever() {
                public FExp retrieve(InstValueModification im, boolean isEach) {
                    FExp exp = super.retrieve(im, isEach);
                    InstNode decl = im.myInstNode();
                    InstNode ancestor = InstAssignable.this.matchingAncestor(decl);
                    return (isEach || decl == InstAssignable.this || !exp.isArray()) ? 
                            exp : exp.dynamicFExp(splitBindingFExp(exp, ancestor, ndims()));
                }
            };
            addAttributes(f, attr, totalMergedEnvironment(), mut, false);
        }
        super.addAttributesToFV(f, attr, indexStack, binding, isBound);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1616
     */
    @Override
    public void generateAdditionalAttributes(Flattener f, List<FAttribute> attr, Stack<Integer> indexStack,
            FlattenBindingExp binding, boolean isBound) {
        FAttribute a = findMatching(attr, name());
        boolean canBind = hasBindingFExp() || variability().knownParameterOrLess();
        List<FAttribute> list = new List<FAttribute>();
        if (a != null) {
            list.addAll(a.getFAttributes());
        }
        boolean flattenBinding = binding.shouldFlattenExp(this);
        if (flattenBinding && !isConstant() && declaredSizeCalc().isUnknownNoEval()) {
            FInternalAttribute ia = (FInternalAttribute)findMatching(list, "size()");
            if (ia == null) {
                ia = new FInternalAttribute(FAttribute.SIZE, new FArray(new List<FExp>()));
                list.add(ia);
            }
            ia.setValue(size().createFExp().addInDim(indexStack, 0, (FArray)ia.getValue()));
        }
        if (flattenBinding) {
            HashMap<InstNode,Integer> m = setModificationLevel(FUNC_AND_REC_MOD_LEVEL+1);
            addAttributesToFV(f, list, indexStack, binding, isBound || canBind);
            clearModificationLevel(m);
        }
        if (a == null && (list.getNumChild() > 0 || (!isBound && canBind))) {
            a = new FAttribute(getClassName().flatten(f), 
                    new FIdDecl(new FAccessString(name())), 
                    new Opt(), true, 0, new Opt(), new Opt(), list);
            attr.add(a);
        } else if (a != null) {
            a.setFAttributeList(list);
        }
        
        if (!isBound && canBind) {
            a.setValue(flattenBindingFExp(f).addInDim(indexStack, 0, (FArray)a.getValue()));
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1688
     */
    public FVariable createFVariable(Flattener f) {
        return createFVariable(f, getFAccess(), FlattenBindingExp.ALL, false);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1692
     */
    public FVariable createFVariable(Flattener f, FAccess name, FlattenBindingExp binding, boolean global) {
        FVariable fv = global ? createEmptyFGlobalVariable(f) : createEmptyFVariable();
        fv.setVisibilityType(createVisibilityType());
        fv.setTypePrefixVariability(variability());
        
        // Only set input/output prefix for top level inputs and outputs
        if (isTopLevelInputOutput()) 
            fv.setTypePrefixInputOutput(isInput() ? TypePrefixInputOutput.INPUT : TypePrefixInputOutput.OUTPUT);
        else
            fv.setTypePrefixInputOutput(TypePrefixInputOutput.NONE);
        
        if (myInstClass().extendsPrimitive())
            fv.setDerivedType(myInstClass().actualInstClass().qualifiedName());
        
        boolean flattenBinding = binding.shouldFlattenExp(this);
        List<FAttribute> attrs = new List<FAttribute>();
        if (!inRecordDecl()) {
            attrs.addAll(fv.getFAttributes());
            addAttributesToFV(f, attrs, new Stack<Integer>(), binding,
                    !flattenBinding || hasBindingFExp() || variability().knownParameterOrLess());
        }
        fv.setFAttributeList(attrs);
        if (flattenBinding) {
            FExp e = flattenBindingFExp(f);
            if (e != null)
                fv.setBindingExp(e);
        }
        
        SrcStringComment comment = myStringComment();
        if (comment != null) {
            fv.setFStringComment(comment.flatten());
        }
        
        fv.setFAccess(name);
        fv.setLocation(this);
        
        contribute(fv);
        
        return fv;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1733
     */
    public VisibilityType createVisibilityType() {
        if (inExpandableConnector()) {
            return VisibilityType.EXPANDABLE;
        } else if (isPublicVar()) {
            return VisibilityType.PUBLIC;
        } else {
            return VisibilityType.PROTECTED;
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1795
     */
    public FExp flattenBindingFExp(Flattener f) {
        try {
            if (variability().knownParameterOrLess()) {
                CValue cval = ceval();
                if (cval.hasBuildLiteral()) {
                    FExp t = dynamicFExp(cval.buildInstLiteral());
                    t.flattenUsedFuncsAndEnums(f);
                    clearDynamicFExp();
                    return cval.buildLiteral();
                }
            }
        } catch (ConstantEvaluationException e) {}
        if (hasBindingFExp()) {
            InstValueModification im = myInstValueMod();
            return getBindingFExp().flatten(f);
        }
        return null;
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2760
     */
    public FExp flattenInRecordConstructor(Flattener f) {
        if (hasBindingFExp()) {
            return flattenBindingFExp(f);
        } else {
            return cevalNoBExp(defaultVariableEvaluator(), Index.NULL).buildLiteral();
        }
    }
    /**
     * @aspect AttributeContributer
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3466
     */
    
        public <N extends FVariable> N contribute(N variable) {
            for (AttributeContributer contributer : attributeContributers())
                contributer.contribute(this, variable);
            return variable;
        }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:69
     */
    public FExp flattenAccess(Flattener f, CommonAccessExp access, int order) {
        if (variability().indexParameterOrLess()) {
            FExp res = flattenAccessToConst(f, access);
            if (res != null) {
                return res;
            }
        }
        return super.flattenAccess(f, access, order);
    }
    /**
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:227
     */
    public FExp flattenAccessToConst(Flattener f, CommonAccessExp access) {
        FType t = access.type();
        if (t.isEmpty()) {
            return t.createEmptyExp();
        }
        
        InstAccess ia = access.asInstAccess();
        if (access.canInlineConstant() && !ia.hasUnknownIndices()) {
            try {
                CValue cval = access.ceval();
                if (isReal() && cval.hasConvertReal()) {
                    cval = cval.convertReal();
                }
                if (cval.hasBuildLiteral()) {
                    return cval.buildLiteral();
                }
            } catch (ConstantEvaluationException e) {
                // TODO: Error
            }
        }
        
        if (ia.flattenAsGlobalAccess()) {
            InstAssignable top = ia.topInstAssignable();
            
            if (f != null && !f.isFlattenedGlobalVariable(top)) {
                top.flatten(f, FlattenBindingExp.ALL, 0, true);
            }
            
            return new FGlobalAccessExp(ia.flatten(f).copyAndPrepend(top.surroundingInstClass().qualifiedName()),
                                        (String) null);
        }
        return null;
    }
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:190
     */
    public InstFunctionArgument buildInstDefaultArgument() {
        if (hasBindingFExp()) {
            return new InstDefaultArgument(myBindingInstExp());
        } else if (!isModifiable() && surroundingInstClass().isRecord()) {
            return new InstPositionalArgument(cevalNoBExp(ASTNode.defaultVariableEvaluator(), Index.NULL).buildLiteral(), -1);
        } else {
            return new InstMissingArgument();
        }
    }
    /**
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:80
     */
    private boolean circularVariability = false;
    /**
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:82
     */
    public TypePrefixVariability calcVariability(TypePrefixVariability v) {
        if (v.constantVariability() && isInput() && inFunction() && isTopLevelInputOutput()) {
            return Variability.DISCRETE;
        }
        if (v.parameterVariability() && !inRecordDecl() && !circularVariability) {
            circularVariability = true;
            if (isPrimitive()) {
                if (isSetAsInitial()) {
                    v = Variability.INITIALPARAMETER;
                } else if (isEvalAnnotated(true)) {
                    v = Variability.EVALTRUEPARAMETER;
                } else if (isEvalAnnotated(false)) {
                    v = Variability.EVALFALSEPARAMETER;
                } else if (isFinalIndependent()) {
                    v = Variability.FINALPARAMETER;
                }
                if (!(forcedVariability.testParameterVariability() && v.evalFalseParameterVariability())) {
                    v = v.combineDown(forcedVariability);
                }
            }
            v = bExpVariability().combinePropagate(v);
            circularVariability = false;
        }
        return v;
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstAssignable() {
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
        children = new ASTNode[16];
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
        setChild(List.EMPTY, 8);
        setChild(List.EMPTY, 9);
        setChild(List.EMPTY, 10);
        setChild(List.EMPTY, 11);
        setChild(List.EMPTY, 12);
        setChild(Opt.EMPTY, 14);
        setChild(Opt.EMPTY, 15);
    }
    /**
     * @declaredat ASTNode:27
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "ClassName", "LocalFArraySubscripts", "SrcComponentDecl", "InstModification", "InstConstrainingComponent", "ConditionalAttribute"},
        type = {"String", "InstAccess", "Opt<FArraySubscripts>", "SrcComponentDecl", "Opt<InstModification>", "Opt<InstConstrainingComponent>", "Opt<FExp>"},
        kind = {"Token", "Child", "Opt", "Token", "Opt", "Opt", "Opt"}
    )
    public InstAssignable(String p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6) {
        setName(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setSrcComponentDecl(p3);
        setChild(p4, 2);
        setChild(p5, 3);
        setChild(p6, 4);
    }
    /**
     * @declaredat ASTNode:41
     */
    public InstAssignable(beaver.Symbol p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6) {
        setName(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setSrcComponentDecl(p3);
        setChild(p4, 2);
        setChild(p5, 3);
        setChild(p6, 4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:51
     */
    protected int numChildren() {
        return 5;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:57
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:61
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        size_reset();
        indices_reset();
        isCircular_int_reset();
        equalityConstraint_reset();
        getBindingFExp_reset();
        myInstValueMod_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:71
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:75
     */
    public InstAssignable clone() throws CloneNotSupportedException {
        InstAssignable node = (InstAssignable) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:86
     */
    @Deprecated
    public abstract InstAssignable fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:94
     */
    public abstract InstAssignable treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:102
     */
    public abstract InstAssignable treeCopy();
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /**
     * JastAdd-internal setter for lexeme Name using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Name
     * @apilevel internal
     */
    public void setName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setName is only valid for String lexemes");
        tokenString_Name = (String)symbol.value;
        Namestart = symbol.getStart();
        Nameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Name.
     * @return The value for the lexeme Name.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Name")
    public String getName() {
        return tokenString_Name != null ? tokenString_Name : "";
    }
    /**
     * Replaces the ClassName child.
     * @param node The new node to replace the ClassName child.
     * @apilevel high-level
     */
    public void setClassName(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the ClassName child.
     * @return The current node used as the ClassName child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="ClassName")
    public InstAccess getClassName() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the ClassName child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ClassName child.
     * @apilevel low-level
     */
    public InstAccess getClassNameNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the LocalFArraySubscripts child. This is the <code>Opt</code>
     * node containing the child LocalFArraySubscripts, not the actual child!
     * @param opt The new node to be used as the optional node for the LocalFArraySubscripts child.
     * @apilevel low-level
     */
    public void setLocalFArraySubscriptsOpt(Opt<FArraySubscripts> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) LocalFArraySubscripts child.
     * @param node The new node to be used as the LocalFArraySubscripts child.
     * @apilevel high-level
     */
    public void setLocalFArraySubscripts(FArraySubscripts node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional LocalFArraySubscripts child exists.
     * @return {@code true} if the optional LocalFArraySubscripts child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasLocalFArraySubscripts() {
        return getLocalFArraySubscriptsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) LocalFArraySubscripts child.
     * @return The LocalFArraySubscripts child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FArraySubscripts getLocalFArraySubscripts() {
        return (FArraySubscripts) getLocalFArraySubscriptsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the LocalFArraySubscripts child. This is the <code>Opt</code> node containing the child LocalFArraySubscripts, not the actual child!
     * @return The optional node for child the LocalFArraySubscripts child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="LocalFArraySubscripts")
    public Opt<FArraySubscripts> getLocalFArraySubscriptsOpt() {
        return (Opt<FArraySubscripts>) getChild(1);
    }
    /**
     * Retrieves the optional node for child LocalFArraySubscripts. This is the <code>Opt</code> node containing the child LocalFArraySubscripts, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child LocalFArraySubscripts.
     * @apilevel low-level
     */
    public Opt<FArraySubscripts> getLocalFArraySubscriptsOptNoTransform() {
        return (Opt<FArraySubscripts>) getChildNoTransform(1);
    }
    /**
     * Replaces the lexeme SrcComponentDecl.
     * @param value The new value for the lexeme SrcComponentDecl.
     * @apilevel high-level
     */
    public void setSrcComponentDecl(SrcComponentDecl value) {
        tokenSrcComponentDecl_SrcComponentDecl = value;
    }
    /**
     * Retrieves the value for the lexeme SrcComponentDecl.
     * @return The value for the lexeme SrcComponentDecl.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcComponentDecl")
    public SrcComponentDecl getSrcComponentDecl() {
        return tokenSrcComponentDecl_SrcComponentDecl;
    }
    /**
     * Replaces the optional node for the InstModification child. This is the <code>Opt</code>
     * node containing the child InstModification, not the actual child!
     * @param opt The new node to be used as the optional node for the InstModification child.
     * @apilevel low-level
     */
    public void setInstModificationOpt(Opt<InstModification> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) InstModification child.
     * @param node The new node to be used as the InstModification child.
     * @apilevel high-level
     */
    public void setInstModification(InstModification node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional InstModification child exists.
     * @return {@code true} if the optional InstModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstModification() {
        return getInstModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstModification child.
     * @return The InstModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstModification getInstModification() {
        return (InstModification) getInstModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstModification child. This is the <code>Opt</code> node containing the child InstModification, not the actual child!
     * @return The optional node for child the InstModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstModification")
    public Opt<InstModification> getInstModificationOpt() {
        return (Opt<InstModification>) getChild(2);
    }
    /**
     * Retrieves the optional node for child InstModification. This is the <code>Opt</code> node containing the child InstModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstModification.
     * @apilevel low-level
     */
    public Opt<InstModification> getInstModificationOptNoTransform() {
        return (Opt<InstModification>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the InstConstrainingComponent child. This is the <code>Opt</code>
     * node containing the child InstConstrainingComponent, not the actual child!
     * @param opt The new node to be used as the optional node for the InstConstrainingComponent child.
     * @apilevel low-level
     */
    public void setInstConstrainingComponentOpt(Opt<InstConstrainingComponent> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) InstConstrainingComponent child.
     * @param node The new node to be used as the InstConstrainingComponent child.
     * @apilevel high-level
     */
    public void setInstConstrainingComponent(InstConstrainingComponent node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional InstConstrainingComponent child exists.
     * @return {@code true} if the optional InstConstrainingComponent child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstConstrainingComponent() {
        return getInstConstrainingComponentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstConstrainingComponent child.
     * @return The InstConstrainingComponent child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstConstrainingComponent getInstConstrainingComponent() {
        return (InstConstrainingComponent) getInstConstrainingComponentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstConstrainingComponent child. This is the <code>Opt</code> node containing the child InstConstrainingComponent, not the actual child!
     * @return The optional node for child the InstConstrainingComponent child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstConstrainingComponent")
    public Opt<InstConstrainingComponent> getInstConstrainingComponentOpt() {
        return (Opt<InstConstrainingComponent>) getChild(3);
    }
    /**
     * Retrieves the optional node for child InstConstrainingComponent. This is the <code>Opt</code> node containing the child InstConstrainingComponent, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstConstrainingComponent.
     * @apilevel low-level
     */
    public Opt<InstConstrainingComponent> getInstConstrainingComponentOptNoTransform() {
        return (Opt<InstConstrainingComponent>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the ConditionalAttribute child. This is the <code>Opt</code>
     * node containing the child ConditionalAttribute, not the actual child!
     * @param opt The new node to be used as the optional node for the ConditionalAttribute child.
     * @apilevel low-level
     */
    public void setConditionalAttributeOpt(Opt<FExp> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) ConditionalAttribute child.
     * @param node The new node to be used as the ConditionalAttribute child.
     * @apilevel high-level
     */
    public void setConditionalAttribute(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional ConditionalAttribute child exists.
     * @return {@code true} if the optional ConditionalAttribute child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasConditionalAttribute() {
        return getConditionalAttributeOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ConditionalAttribute child.
     * @return The ConditionalAttribute child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getConditionalAttribute() {
        return (FExp) getConditionalAttributeOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the ConditionalAttribute child. This is the <code>Opt</code> node containing the child ConditionalAttribute, not the actual child!
     * @return The optional node for child the ConditionalAttribute child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="ConditionalAttribute")
    public Opt<FExp> getConditionalAttributeOpt() {
        return (Opt<FExp>) getChild(4);
    }
    /**
     * Retrieves the optional node for child ConditionalAttribute. This is the <code>Opt</code> node containing the child ConditionalAttribute, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ConditionalAttribute.
     * @apilevel low-level
     */
    public Opt<FExp> getConditionalAttributeOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(4);
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
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstComponentDeclNoTransform(InstComponentDecl node) {
        List<InstComponentDecl> list = getInstComponentDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
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
            setChild(new List(node), 5);
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
        return 5;
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclListNoTransform() {
        return (List<InstComponentDecl>) getChildNoTransform(5);
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
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
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
            setChild(new List(node), 6);
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
        return 6;
    }
    /**
     * Retrieves the InstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(6);
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
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstExtendsNoTransform(InstExtends node) {
        List<InstExtends> list = getInstExtendsListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
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
            setChild(new List(node), 7);
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
        return 7;
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendsListNoTransform() {
        return (List<InstExtends>) getChildNoTransform(7);
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
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstImportNoTransform(InstImport node) {
        List<InstImport> list = getInstImportListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
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
            setChild(new List(node), 8);
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
        return 8;
    }
    /**
     * Retrieves the InstImport list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstImport list.
     * @apilevel low-level
     */
    public List<InstImport> getInstImportListNoTransform() {
        return (List<InstImport>) getChildNoTransform(8);
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
            setChild(new List(node), 9);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addRedeclaredInstClassDeclNoTransform(InstClassDecl node) {
        List<InstClassDecl> list = getRedeclaredInstClassDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 9);
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
            setChild(new List(node), 9);
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
        return 9;
    }
    /**
     * Retrieves the RedeclaredInstClassDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the RedeclaredInstClassDecl list.
     * @apilevel low-level
     */
    public List<InstClassDecl> getRedeclaredInstClassDeclListNoTransform() {
        return (List<InstClassDecl>) getChildNoTransform(9);
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
            setChild(new List(node), 10);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAbstractEquationNoTransform(FAbstractEquation node) {
        List<FAbstractEquation> list = getFAbstractEquationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 10);
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
            setChild(new List(node), 10);
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
        return 10;
    }
    /**
     * Retrieves the FAbstractEquation list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAbstractEquation list.
     * @apilevel low-level
     */
    public List<FAbstractEquation> getFAbstractEquationListNoTransform() {
        return (List<FAbstractEquation>) getChildNoTransform(10);
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
            setChild(new List(node), 11);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addElementInstModificationNoTransform(InstModification node) {
        List<InstModification> list = getElementInstModificationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 11);
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
            setChild(new List(node), 11);
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
        return 11;
    }
    /**
     * Retrieves the ElementInstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ElementInstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getElementInstModificationListNoTransform() {
        return (List<InstModification>) getChildNoTransform(11);
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
            setChild(new List(node), 12);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addAnnotationExpNoTransform(FExp node) {
        List<FExp> list = getAnnotationExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 12);
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
            setChild(new List(node), 12);
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
        return 12;
    }
    /**
     * Retrieves the AnnotationExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnnotationExp list.
     * @apilevel low-level
     */
    public List<FExp> getAnnotationExpListNoTransform() {
        return (List<FExp>) getChildNoTransform(12);
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
     * Retrieves the FArraySubscripts child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FArraySubscripts child.
     * @apilevel low-level
     */
    public FArraySubscripts getFArraySubscriptsNoTransform() {
        return (FArraySubscripts) getChildNoTransform(13);
    }
    /**
     * Retrieves the child position of the optional child FArraySubscripts.
     * @return The the child position of the optional child FArraySubscripts.
     * @apilevel low-level
     */
    protected int getFArraySubscriptsChildPosition() {
        return 13;
    }
    /**
     * Replaces the (optional) Annotation child.
     * @param node The new node to be used as the Annotation child.
     * @apilevel high-level
     */
    public void setAnnotation(InstClassModification node) {
        // TODO: should also check if getOpt() is the empty singleton, since we check the _value on return.
        getAnnotationOpt().setChild(node, 0);
    }
    /**
     * Check whether the optional Annotation child exists.
     * @return {@code true} if the optional Annotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasAnnotation() {
        return getAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Annotation child.
     * @return The Annotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstClassModification getAnnotation() {
        return (InstClassModification) getAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for child Annotation. This is the <code>Opt</code> node containing the child Annotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Annotation.
     * @apilevel low-level
     */
    public Opt<InstClassModification> getAnnotationOptNoTransform() {
        return (Opt<InstClassModification>) getChildNoTransform(14);
    }
    /**
     * Retrieves the child position of the optional child Annotation.
     * @return The the child position of the optional child Annotation.
     * @apilevel low-level
     */
    protected int getAnnotationOptChildPosition() {
        return 14;
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
        return (Opt<InstClassModification>) getChildNoTransform(15);
    }
    /**
     * Retrieves the child position of the optional child ClassAnnotation.
     * @return The the child position of the optional child ClassAnnotation.
     * @apilevel low-level
     */
    protected int getClassAnnotationOptChildPosition() {
        return 15;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:37
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:37")
    public abstract FType type();
    /**
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:510
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:510")
    public int ndims() {
        int ndims_value = hasFArraySubscripts() ? getFArraySubscripts().ndims() : 0;
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
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1118")
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
            Size s = super.size();
            if (s.isUnknown() && hasBindingFExp() && 
                    (!inRecordDecl() || !isModifiable()) && 
                    (!isInput() || !inFunction()) &&
                    !getBindingFExp().isCircular()) {
                s = s.createKnown(getBindingFExp());
            }
            return s;
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
     * Get the set of all array indices of an instance primitive component. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2268")
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
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2889
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2889")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = ceval(evaluator, Index.NULL);
        return ceval_VariableEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2891
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2891")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        {
                CValue val = CValue.UNKNOWN;
                if (hasEvaluationValue(evaluator)) {
                    val = evaluationValue(evaluator);
                } else if ((variability().fixedParameterOrLess() || (inFunction() && !isInput())) && !isForIndex()) {
                    boolean func = inFunction();
                    i = func ? i : Index.NULL;
                    if (hasBindingFExp()) {
                        FExp bexp = getBindingFExp();
                        if (!bexp.type().isUnknown())
                            val = bexp.ceval(evaluator, i);
                    } else if ((!func && !inRecordDecl()) || isRecord()) {
                        val = cevalNoBExp(evaluator, i);
                    }
                    if (!func) {
                        setEvaluationValue(evaluator, val);
                    }
                }
                return val;
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2958
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2958")
    public CValue cevalNoBExp(VariableEvaluator evaluator, Index i) {
        {
                CValue val = startAttributeCValue(evaluator);
                if (i != Index.NULL) 
                    val = val.array().getCell(i);
                if ((isInteger() || isReal() || isEnum()) && !val.isUnknown()) {
                    try {
                        CValue min = minAttributeCValue(evaluator);
                        if (i != Index.NULL) 
                            min = min.array().getCell(i);
                        CValue max = maxAttributeCValue(evaluator);
                        if (i != Index.NULL) 
                            max = max.array().getCell(i);
                        val =  val.constrainWithin(min, max);
                    } catch (ConstantEvaluationException e) {}
                }
                return val;
            }
    }
    /**
     * Find and evaluate the attribute <code>name</code>. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3072
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3072")
    public CValue attributeCValueGeneric(VariableEvaluator evaluator, String name) {
        {
                
                CValue val = attributeCValueSet(evaluator, name);
                if (val != null) {
                    return val;
                }
                
                CValue res = attributeCValueDefault(name);
                if (isArray()) {
                    res = arrayCValue(res);
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3087
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3087")
    public CValue attributeCValueSet(VariableEvaluator evaluator, String name) {
        {
                for (InstModification im : totalMergedEnvironment()) {
                    FExp exp = im.findAttribute(name);
                    if (exp != null) {
                        CValue val = exp.ceval(evaluator);
                        if (im.hasEach()) {
                            val = arrayCValue(val);
                        }
                        return val;
                    }
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3101
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3101")
    public CValueArray arrayCValue(CValue val) {
        {
                CValueArray array = new CValueArray(size());
                for (Index i : indices()) {
                    array.setCell(i, val);
                }
                return array;
            }
    }
    /** @apilevel internal */
    private void isCircular_int_reset() {
        isCircular_int_values = null;
    }
    protected java.util.Map isCircular_int_values;
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4740")
    public boolean isCircular(int dim) {
        Object _parameters = dim;
        if (isCircular_int_values == null) isCircular_int_values = new java.util.HashMap(4);
        ASTState.CircularValue _value;
        if (isCircular_int_values.containsKey(_parameters)) {
            Object _cache = isCircular_int_values.get(_parameters);
            if (!(_cache instanceof ASTState.CircularValue)) {
                return (Boolean) _cache;
            } else {
                _value = (ASTState.CircularValue) _cache;
            }
        } else {
            _value = new ASTState.CircularValue();
            isCircular_int_values.put(_parameters, _value);
            _value.value = true;
        }
        ASTState state = state();
        if (!state.inCircle() || state.calledByLazyAttribute()) {
            state.enterCircle();
            int _boundaries = state.boundariesCrossed;
            boolean isFinal = this.is$Final();
            boolean new_isCircular_int_value;
            do {
                _value.cycle = state.nextCycle();
                new_isCircular_int_value = isCircular_compute(dim);
                if (((Boolean)_value.value) != new_isCircular_int_value) {
                    state.setChangeInCycle();
                    _value.value = new_isCircular_int_value;
                }
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                isCircular_int_values.put(_parameters, new_isCircular_int_value);
                state.startLastCycle();
                boolean $tmp = isCircular_compute(dim);
            } else {
                isCircular_int_values.remove(_parameters);
                state.startResetCycle();
                boolean $tmp = isCircular_compute(dim);
            }
            state.leaveCircle();
            return new_isCircular_int_value;
        } else if (_value.cycle != state.cycle()) {
            _value.cycle = state.cycle();
            boolean new_isCircular_int_value = isCircular_compute(dim);
            if (state.lastCycle()) {
                isCircular_int_values.put(_parameters, new_isCircular_int_value);
            }
            if (state.resetCycle()) {
                isCircular_int_values.remove(_parameters);
            }
            else if (((Boolean)_value.value) != new_isCircular_int_value) {
                state.setChangeInCycle();
                _value.value = new_isCircular_int_value;
            }
            return new_isCircular_int_value;
        } else {
            return (Boolean) _value.value;
        }
    }
    /** @apilevel internal */
    private boolean isCircular_compute(int dim) {
            if (hasFArraySubscripts()) {
                if (dim == -1) {
                    if (getFArraySubscripts().isCircular()) {
                        return true;
                    }
                } else {
                    if (getFArraySubscripts().subscript(dim).isCircular()) {
                        return true;
                    }
                }
            }
            return (hasBindingFExp() && getBindingFExp().isCircular());
        }
    /** @apilevel internal */
    private void equalityConstraint_reset() {
        equalityConstraint_computed = false;
        
        equalityConstraint_value = null;
    }
    /** @apilevel internal */
    protected boolean equalityConstraint_computed = false;

    /** @apilevel internal */
    protected InstClassDecl equalityConstraint_value;

    /**
     * @attribute syn
     * @aspect OverconstrainedConnections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1480
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverconstrainedConnections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1480")
    public InstClassDecl equalityConstraint() {
        ASTState state = state();
        if (equalityConstraint_computed) {
            return equalityConstraint_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        equalityConstraint_value = equalityConstraint_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        equalityConstraint_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return equalityConstraint_value;
    }
    /** @apilevel internal */
    private InstClassDecl equalityConstraint_compute() {
            InstLookupResult<InstClassDecl> res = memberInstClass(EQUALITY_CONSTRAINT_NAME);
            if (!res.successful())
                res = myInstClass().memberInstClass(EQUALITY_CONSTRAINT_NAME);
            if (res.successful()) {
                InstClassDecl icd = res.target().actualInstClass();
                if (icd.isEqualityConstraint(type()))
                    return icd;
            }
            return null;
        }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:819
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:819")
    public boolean canBeExternalReturn(FExternalLanguage lang) {
        boolean canBeExternalReturn_FExternalLanguage_value = !isArray() && lang.canBeReturn(type());
        return canBeExternalReturn_FExternalLanguage_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:950
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:950")
    public FAccess expandedFAccessCalc() {
        FAccess expandedFAccessCalc_value = expandedFAccess().append(name());
        return expandedFAccessCalc_value;
    }
    /**
     * Retrieve the binding expression of an InstAssignable node.
     * 
     * Always null for components that are not assignable.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1748
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1748")
    public FExp myBindingInstExp() {
        FExp myBindingInstExp_value = hasInstValueMod() ? myInstValueMod().getFExp() : null;
        return myBindingInstExp_value;
    }
    /**
     * Check if this component has a binding expression.
     * 
     * Always false for components that are not assignable.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1756
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1756")
    public boolean hasBindingFExp() {
        boolean hasBindingFExp_value = getBindingFExp() != null;
        return hasBindingFExp_value;
    }
    /** @apilevel internal */
    private void getBindingFExp_reset() {
        getBindingFExp_computed = false;
        
        getBindingFExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getBindingFExp_computed = false;

    /** @apilevel internal */
    protected FExp getBindingFExp_value;

    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1763
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1763")
    public FExp getBindingFExp() {
        ASTState state = state();
        if (getBindingFExp_computed) {
            return getBindingFExp_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getBindingFExp_value = getBindingFExp_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getBindingFExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getBindingFExp_value;
    }
    /** @apilevel internal */
    private FExp getBindingFExp_compute() {
            //log.debug("In file: " + fileName() + " at line: " + beginLine() + ": " + prettyPrint(""));
            FExp exp = parentBindingFExp();
            if (exp != null) {
                exp = exp.component(name());
            } else if (hasInstValueMod()) {
                InstValueModification im = myInstValueMod();
                exp = im.getFExp();
                if (ndims() < exp.ndims()) {
                    if (exp.size().isEmpty()) {
                        exp = null;
                    } else {
                        InstNode decl = im.myInstNode();
                        decl = matchingAncestor(decl);
                        exp = exp.dynamicFExp(splitBindingFExp(exp, decl, ndims()));
                    }
                }
            }
            return exp;
        }
    /**
     * Check if this InstComponentDecl is an assignable with a value modifier
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2023
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2023")
    public boolean hasBindingExp() {
        boolean hasBindingExp_value = hasInstValueMod();
        return hasBindingExp_value;
    }
    /** @apilevel internal */
    private void myInstValueMod_reset() {
        myInstValueMod_computed = false;
        
        myInstValueMod_value = null;
    }
    /** @apilevel internal */
    protected boolean myInstValueMod_computed = false;

    /** @apilevel internal */
    protected InstValueModification myInstValueMod_value;

    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2034
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2034")
    public InstValueModification myInstValueMod() {
        ASTState state = state();
        if (myInstValueMod_computed) {
            return myInstValueMod_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myInstValueMod_value = myInstValueModCalc();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myInstValueMod_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myInstValueMod_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:264
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:264")
    public boolean flattenAsGlobalVariable() {
        boolean flattenAsGlobalVariable_value = isExternalObject() && variability().constantVariability();
        return flattenAsGlobalVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:266")
    public boolean flattenAsGlobalVariableFromFunction() {
        boolean flattenAsGlobalVariableFromFunction_value = !isInput() && !isOutput() && variability().constantVariability();
        return flattenAsGlobalVariableFromFunction_value;
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:81
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:81")
    public boolean scalarizedAsFFunctionCallStmt() {
        boolean scalarizedAsFFunctionCallStmt_value = getBindingFExp().isNonVectorizedFunctionCall() && type().isComposite();
        return scalarizedAsFFunctionCallStmt_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:232
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:232")
    public CommonType commonType() {
        CommonType commonType_value = type();
        return commonType_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:252")
    public CommonType expectedBindingType() {
        CommonType expectedBindingType_value = expectedBindingType(true);
        return expectedBindingType_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:253
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:253")
    public CommonType expectedBindingTypeNoEach() {
        CommonType expectedBindingTypeNoEach_value = expectedBindingType(false);
        return expectedBindingTypeNoEach_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:255")
    public CommonType expectedBindingType(boolean useEach) {
        {
                InstValueModification ivm = myInstValueMod();
                return type().sizedType(ivm.expectedSize(useEach));
            }
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:266")
    public CommonType actualBindingType() {
        {
                FExp bexp = myBindingInstExp();
                if (bexp.type().isRecord() && bexp.size().equals(bexp.getArray().size())) {
                    Array array = bexp.getArray();
                    Map<Index, FExp> exps = new HashMap<>();
                    for (Index i : bexp.indices()) {
                        exps.put(i.clone(), array.get(i));
                    }
                    return new ArrayType(bexp.indices(), exps, bexp.type().scalarType());
                }
                return bexp.type();
            }
    }
    /**
     * If this assignable is in a modification on an array, return the index for this instance.
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:282")
    public Index indexInModification() {
        Index indexInModification_value = indexInModification(true);
        return indexInModification_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:283
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:283")
    public Index indexInModificationNoEach() {
        Index indexInModificationNoEach_value = indexInModification(false);
        return indexInModificationNoEach_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:285
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:285")
    public Index indexInModification(boolean useEach) {
        {
                int ndims = myInstValueMod().expectedSize(useEach).ndims() - size().ndims();
                Index arrayIndex = parentTotalIndex();
                return arrayIndex.subIndex(arrayIndex.ndims() - ndims);
            }
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:59")
    public TypePrefixVariability calcVariability() {
        TypePrefixVariability calcVariability_value = calcVariability(super.calcVariability());
        return calcVariability_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:120")
    public boolean isFinalIndependent() {
        boolean isFinalIndependent_value = hasBindingFExp() && myInstValueMod().isFinal() && getBindingFExp().isIndependentParameterExp();
        return isFinalIndependent_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:124
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:124")
    public boolean isEvalAnnotated(boolean b) {
        {
                AnnotationNode an = evalAnnotation();
                return an.exists() && an.isBoolValue() && (!b ^ an.bool());
            }
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:129")
    public AnnotationNode evalAnnotation() {
        {
                AnnotationNode res = parentEvalAnnotation();
                if (!res.exists()) {
                    res = annotation().forPath("Evaluate");
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:145")
    public boolean isSetAsInitial() {
        boolean isSetAsInitial_value = isPrimitive() && 
                    attributeCValueSet(defaultVariableEvaluator(), FAttribute.FIXED) != null && 
                    !fixedAttributeCValue().reduceBooleanAnd();
        return isSetAsInitial_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:153
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:153")
    public TypePrefixVariability bExpVariability() {
        {
                if (hasBindingFExp() && !getBindingFExp().type().isUnknown()) {
                    return getBindingFExp().variability().dependentVariability();
                } else {
                    return super.bExpVariability();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:114")
    public boolean isAssignable() {
        boolean isAssignable_value = true;
        return isAssignable_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1227
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1227")
    public boolean isPublicVar() {
        boolean isPublicVar_value = isPublic() && !inProtectedComponent();
        return isPublicVar_value;
    }
    /**
     * Check if this component is or is part of a component that is declared input or output on the top level.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1403
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1403")
    public boolean isTopLevelInputOutput() {
        boolean isTopLevelInputOutput_value = isTopLevel() && !inExpandableConnector() && 
                    (isInput() || isOutput()) && !isProtected() && isPublicVar();
        return isTopLevelInputOutput_value;
    }
    /**
     * @attribute syn
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:25
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AbsoluteValue", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:25")
    public boolean isAbsoluteValue() {
        boolean isAbsoluteValue_value = true;
        return isAbsoluteValue_value;
    }
    /**
     * Is this a member of an array component?
     * @attribute inh
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:437
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:437")
    public boolean inArrayComponent() {
        boolean inArrayComponent_value = getParent().Define_inArrayComponent(this, null);
        return inArrayComponent_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2744
     * @apilevel internal
     */
    public boolean Define_hasParentRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isRecord() && (hasBindingFExp() || hasParentRecordWithBindingExp());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2744
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute hasParentRecordWithBindingExp
     */
    protected boolean canDefine_hasParentRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377
     * @apilevel internal
     */
    public boolean Define_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return !inRecordDecl() && myInstValueMod() == ivm;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFlattened
     */
    protected boolean canDefine_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952
     * @apilevel internal
     */
    public FAccess Define_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                if (size().isUnknown()) {
                    return expandedFAccess().append(name(), size().flattenSubscript());
                } else {
                    return expandedFAccess().append(name());
                }
            }
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
        return getBindingFExp();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138
     * @apilevel internal
     */
    public AnnotationNode Define_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return evalAnnotation();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentEvalAnnotation
     */
    protected boolean canDefine_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
