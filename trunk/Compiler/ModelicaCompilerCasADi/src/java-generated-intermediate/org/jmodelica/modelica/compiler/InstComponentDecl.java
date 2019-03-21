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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:99
 * @astdecl InstComponentDecl : InstBaseNode ::= <Name:String> ClassName:InstAccess [LocalFArraySubscripts:FArraySubscripts] <SrcComponentDecl:SrcComponentDecl> [InstModification] [InstConstrainingComponent] FArraySubscripts [ConditionalAttribute:FExp] [Annotation:InstClassModification] [ClassAnnotation:InstClassModification];
 * @production InstComponentDecl : {@link InstBaseNode} ::= <span class="component">&lt;Name:String&gt;</span> <span class="component">ClassName:{@link InstAccess}</span> <span class="component">[LocalFArraySubscripts:{@link FArraySubscripts}]</span> <span class="component">&lt;SrcComponentDecl:SrcComponentDecl&gt;</span> <span class="component">[{@link InstModification}]</span> <span class="component">[{@link InstConstrainingComponent}]</span> <span class="component">{@link FArraySubscripts}</span> <span class="component">[ConditionalAttribute:{@link FExp}]</span> <span class="component">[Annotation:{@link InstClassModification}]</span> <span class="component">[ClassAnnotation:{@link InstClassModification}]</span>;

 */
public abstract class InstComponentDecl extends InstBaseNode implements Cloneable, CommonVariableDecl, HasType, LockBranch, InstLookupResult.Item {
    /**
     * Create an FArraySubscripts that spans all array cells of this component.
     * 
     * If this is a scalar component, an empty FArraySubscripts is returned.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:498
     */
    public FArraySubscripts expandedSubscripts() {
		return size().createExpandedFArraySubscripts();
	}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2191
     */
    public void collectScalarPrimitives(Set<String> collectedNames) {
        for (InstComponentDecl instComponentDecl : getInstComponentDecls()) {
            instComponentDecl.collectScalarPrimitives(collectedNames);
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2993
     */
    public void cevalNoBExpArray(VariableEvaluator evaluator, InstRecord top, CValueArray a, int ndims) {
        if (ndims > 0) {
            for (InstComponentDecl icd : allInstComponentDecls()) {
                icd.cevalNoBExpArray(evaluator, top, a, ndims-1);
            }
        } else {
            a.addCell(top.cevalNoBExpCell(evaluator, allInstComponentDecls()));
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3483
     */
    public boolean isPackageConstant() { return isConstant() && containingInstClass().isPackage();}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3486
     */
    public boolean inSameInstClass(InstNode instNode) {
    	InstNode classDecl = instNode;
    	if (!classDecl.isClassDecl()) {
    		classDecl = classDecl.containingInstClass();
    	}
    	InstNode node = containingEntity();
    	if (node.equals(classDecl)) {
    		return true;
    	}
    	return false;
    }
    /**
     * Read current function evaluation value from map.
     * 
     * If this variable isn't in the map, set to value of binding expression.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3857
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3884
     */
    protected CValue cevalFunctionBindingExp(VariableEvaluator evaluator) {
        return CValue.UNKNOWN;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3907
     */
    protected void cevalBindingExpForRecordArray(VariableEvaluator evaluator, FRecordType type, CValueArray arr, int ndims) {
        throw new UnsupportedOperationException("Only valid for InstArrayComponentDecls.");
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3921
     */
    protected CValue cevalBindingExpForRecord(VariableEvaluator evaluator, FRecordType type) {
        CValueRecord res = new CValueRecord(type);
        evaluationValue = res;
        for (InstComponentDecl ch : allInstComponentDecls())
            res.setMember(ch.name(), ch.cevalFunctionBindingExp(evaluator));
        return res;
    }
    /**
     * Set the current function evaluation value.
     * 
     * Also updates value map.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3981
     */
    public void setEvaluationValue(VariableEvaluator evaluator, CValue val) {
        evaluator.setEvaluationValue(this, val.cached());
    }
    /**
     * Check if this variable has a current function evaluation value.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3995
     */
    public boolean hasEvaluationValue(VariableEvaluator evaluator) {
	  return evaluator.hasEvaluationValue(this);
  }
    /**
     * Get the current evaluation value.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4009
     */
    public CValue evaluationValue(VariableEvaluator evaluator) {
	  return evaluator.evaluationValue(this);
  }
    /**
     * Remove the current evaluation value
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4023
     */
    public void clearEvaluationValue(VariableEvaluator evaluator) {
        evaluator.clearEvaluationValue(this);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4028
     */
    protected CValue evaluationValue = null;
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4034
     */
    public CValue getLocalCachedEvaluationValue() {
        return evaluationValue;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4042
     */
    public void setLocalCachedEvaluationValue(CValue value) {
        evaluationValue = value;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4050
     */
    public void clearLocalCachedEvaluationValue() {
        evaluationValue = null;
    }
    /**
     * Kept for legacy reasons.
     * @deprecated Use {@link #setLocalCachedEvaluationValue} instead.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4066
     */
    public void setEvaluationValue(CValue value) {
        setLocalCachedEvaluationValue(value);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4113
     */
    public Map<CommonVariableDecl,CValue> collectEvaluationValues(Map<CommonVariableDecl,CValue> map) {
        return super.collectEvaluationValues(collectMyEvaluationValue(map));
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4139
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
     * Create an access to this variable, from a scope where it can be accessed unqualified.
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:991
     */
    public InstAccessExp createAccessExp() {
        return new InstAccessExp(createInstAccess());
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:256
     */
    public void contentCheck(ErrorCheckType checkType) {
        if (!inFunction()) // Array sizes outside functions should be structural parameters
            size().forceVariability(checkType, Variability.STRUCTPARAMETER);
        checkQuotedIdentifier(getSrcComponentDecl(), name());
        checkAbsoluteValue();
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:877
     */
    public void forceVariability(ErrorCheckType checkType, TypePrefixVariability v) {}
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:956
     */
    public void setVariabilityNotCalculated() {
        if (!variability_computed) {
            return;
        }
        InstComponentDecl icd = enclosingInstComponentDecl();
        if (icd != null) {
            icd.setVariabilityNotCalculated();
        }
        variability_computed = false;
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:840
     */
    public void collectErrors(ErrorCheckType checkType) {
        if (!errorChecked) {
            errorChecked = true;
            if (checkType.checkForRecursiveStructure() && isRecursed()) {
                error("Recursive class structure");
            } else if (isOuter()) {
                myInnerInstComponentDecl().collectErrors(checkType);
            } else {
                collectErrorsInClassName(checkType);
                myInstClass().checkRestriction(checkType);
                if (hasFArraySubscripts()) {
                    getFArraySubscripts().collectErrors(checkType);
                }
                if (hasConditionalAttribute())  {
                    getConditionalAttribute().collectErrors(checkType);
                }
                if (!isDisabled() && hasInstModification()) {
                    getInstModification().collectErrors(checkType);
                }
                for (InstModification im : getMergedEnvironment()) {
                    im.checkModificationNames(checkType);
                }
                
                if (shouldCheckInto(checkType)) {
                    errorChecked = false;
                    super.collectErrors(checkType);
                    if (hasInstConstrainingComponent()) {
                        getInstConstrainingComponent().collectErrors(checkType);
                    }
                }
            }
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:892
     */
    public void collectErrorsInClassName(ErrorCheckType checkType) {
		getClassName().collectErrors(checkType);
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1123
     */
    public void checkRedeclares(ErrorCheckType checkType) {
        if (!isDisabled() && hasInstModification()) {
            getInstModification().collectErrors(checkType);
        }
        if (shouldCheckInto(checkType)) {
            if (hasInstConstrainingComponent()) {
                getInstConstrainingComponent().collectErrors(checkType);
            }
            super.checkRedeclares(checkType);
        }
    }
    /**
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:151
     */
    private boolean duplicateOfCalculated = false;
    /**
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:152
     */
    private InstComponentDecl duplicateOfValue = null;
    /**
     * Update duplicate information for this component.
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:166
     */
    public void calculateDuplicate(Map<String,InstComponentDecl> map) {
        if (map.containsKey(name()))
            duplicateOfValue = map.get(name());
        else
            map.put(name(), this);
        duplicateOfCalculated = true;
    }
    /**
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:188
     */
    public void nameCheck(ErrorCheckType checkType) {
        // TODO: check for duplicate classes and for class and component with same name
        if (isDuplicate()) {
            InstComponentDecl other = duplicateOf();
            if (other.nameCollisionScope() == nameCollisionScope()) {
                error("Duplicate component in same class: " + this);
            } else {
                // TODO: check if they are identical
                UNABLE_TO_INFER_EQUALITY_FOR_DUPLICATES.invoke(this, name());
            }
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:91
     */
    public void typeCheckReplacingComponent(InstComponentDecl declaredType, ErrorCheckType checkType) {
        super.typeCheck(checkType);
        
        // Type check the original component
        InstComponentDecl superType = declaredType.constrainingInstComponentDecl();
        if (declaredType.hasInstConstrainingComponent()) {
            String subTypeMsg = declaredType.subType(superType);
            if (subTypeMsg != null) {
                SrcComponentClause cc = declaredType.myComponentClause();
                CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS.invoke(declaredType, cc, subTypeMsg);
            }
        }

        // The environment should be traversed backwards in order to perform correct
        // subtype tests in redeclaration chains.
        InstComponentRedeclare prevRedeclare = null;
        for (InstComponentRedeclare redeclare : myEnvironment().reverseComponentRedeclares(name())) {
            InstComponentDecl declaredSubType = redeclare.getInstComponentDecl();
            InstComponentDecl constrainingSubType = declaredSubType.constrainingInstComponentDecl();
                
            // Check consistency of the redeclaring component
            if (declaredSubType.hasInstConstrainingComponent()) {
                String subTypeMsg = declaredSubType.subType(constrainingSubType);
                if (subTypeMsg != null) {
                    SrcComponentClause cc = declaredSubType.myComponentClause();
                    CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS.invoke(declaredSubType, cc, subTypeMsg);
                }
            }

            // It is ok to check against the constrainingSubType, since the declaredSubType is a subtype
            // of the constrainingSubType. Then if constrainingSubType is a subtype of superType, then it
            // follows that declaredSubType is a subtype of superType by transitivity.
            String subTypeMsg = constrainingSubType.subType(superType);
            if (subTypeMsg != null) {
                SrcComponentClause cc = constrainingSubType.myComponentClause();
                SrcComponentClause scc = superType.myComponentClause();
                REPLACING_CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS.invoke(constrainingSubType, 
                        cc, scc, subTypeMsg);
            }
        
            // If the redeclaring declaration has a constraining clause, the constraining
            // type of the redeclaring declaration of should be used in following subtype-test 
            // instead of the constraining type of the original declaration.
            if (declaredSubType.hasInstConstrainingComponent()) 
                superType = constrainingSubType;
            
            // If the previous redeclare is declared without "replaceable", then it is illegal 
            // to redeclare further. The check on commonAncestor() checks that this redeclare actually 
            // replaces the previous one. 
            InstNode containingNode = redeclare.myInstNode();
            if (prevRedeclare != null && !prevRedeclare.getInstComponentDecl().isReplaceable() && 
                    prevRedeclare.myInstNode().commonAncestor(containingNode) == containingNode) {
                PREV_REDECLARE_NOT_REPLACEABLE.invoke(declaredSubType, 
                        declaredSubType.myComponentClause(), declaredSubType.name());
            }
            
            prevRedeclare = redeclare;
        }
    }
    /**
     * Helper method for constructing FAccesss for connection sets
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1160
     */
    public FAccess getFAccess(Index i) {
        FAccess res = getFAccess();
        if (isArray()) {
            if (i.ndims() > 0) {
                res = res.copyAndAddFas(i.subIndex(i.ndims() - ndims()).createFArraySubscripts());
            } else {
                res = res.copyAndAddFas(expandedSubscripts());
            }
        }
        return res;
    }
    /**
     * Connect the variables referenced in a connect or branch statement in the connection set manager.
     * 
     * @param left        describes current part of the left access
     * @param right       describes current part of the right access
     * @param prefix      the prefix to use when flattening names
     * @param csm         the connection set manager to add variables to
     * @param source      the originating connect or branch statement
     * @param buildGraph  if true, pass instances of overconstrained types to overconstrained connection graph
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1186
     */
    public void connectTo(ConnectionSetEntry left, ConnectionSetEntry right, 
            FAccess prefix, ConnectionSetManager csm, ConnectionEdge source, boolean buildGraph) {
        if (!isDisabled() && !right.getVar().isDisabled()) {
            if (buildGraph && isOverconstrainedConnection(right.getVar())) {
                csm.getGraph().addConnection(left, right, prefix, source);
            } else if (isArray()) {
                for (Index i : indices()) {
                    ConnectionSetEntry leftEntry = left.specifyCell(i);
                    ConnectionSetEntry rightEntry = right.specifyCell(i);
                    leftEntry.getVar().connectTo(leftEntry, rightEntry, prefix, csm, source, buildGraph);
                }
            } else if (isOperatorRecord()) {
                connectToAsPrimitive(left, right, prefix, csm, source, buildGraph);
            } else {
                SortedSet<InstComponentDecl> rightChildren = right.getVar().containedInstComponents();
                for (InstComponentDecl leftComp : containedInstComponents()) {
                    SortedSet<InstComponentDecl> rightTail = rightChildren.tailSet(leftComp);
                    if (rightTail.size() > 0) {
                        InstComponentDecl rightComp = rightTail.first();
                        FAccess leftName  = leftComp.getFAccess(Index.NULL);
                        FAccess rightName = rightComp.getFAccess(Index.NULL);
                        ConnectionSetEntry leftEntry = ConnectionSetEntry.create(leftComp, left.isOutside(), leftName);
                        ConnectionSetEntry rightEntry = ConnectionSetEntry.create(rightComp, right.isOutside(), rightName);
                        leftComp.connectTo(leftEntry, rightEntry, prefix, csm, source, buildGraph);
                    }
                }
            }
            csm.countCardinality(left.getFAccess().scalarName());
            csm.countCardinality(right.getFAccess().scalarName());
        }
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1224
     */
    public void connectToAsPrimitive(ConnectionSetEntry left, ConnectionSetEntry right, 
            FAccess prefix, ConnectionSetManager csm, ConnectionEdge source, boolean buildGraph) {
        if (left.equals(right)) {
            source.warning("Ignored connection from connector to itself");
        } else {
            if (buildGraph && isOverconstrainedConnection(right.getVar())) {
                csm.getGraph().addConnection(left, right, prefix, source);
            } else {
                // In the special case of members of expandable connectors, we need each cell separately.
                if (isArray() && (isExpandableConnectorMember() || right.getVar().isExpandableConnectorMember()) && 
                        !left.getFAccess().hasScalarSubscripts()) 
                    for (Index i : indices())
                        csm.addVars(left.specifyCell(i), right.specifyCell(i));
                else
                    csm.addVars(left, right);
            }
            csm.countCardinality(left.getFAccess().scalarName());
            csm.countCardinality(right.getFAccess().scalarName());
        }
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1314
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
		if (useInFlattening()) 
			super.buildConnectionSets(prefix, csm, connect);
	}
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1333
     */
    public void buildConnectionSetsAsPrimitive(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        if (useInFlattening() && (isFlow() || isStream())) {
            FAccess access = getFAccess(Index.NULL);
            csm.addFlowVar(this, false, access);
            if (inExpandableConnector()) {
                csm.addFlowVar(this, true, access);
            }
        }
    }
    /**
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:2984
     */
    public void expandConnector(List<InstComponentDecl> members, InstComponentDecl[] templates) {
        throw new UnsupportedOperationException();
    }
    /**
     * Check that this component would be allowed as a member of an expandable connector.
     * 
     * @param errorNode  node to report any errors found on
     * @return  <code>true</code> if the component is OK
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3068
     */
    public boolean checkAsExpandableMemberTemplate(ASTNode errorNode) {
        for (InstComponentDecl child : getInstComponentDecls()) {
            if (child.isExpandableConnector()) {
                errorNode.compliance("Expandable connectors containing a non-expandable connector component, that in turn contains an expandable connector, is not supported");
                return false;
            } else if (!child.checkAsExpandableMemberTemplate(errorNode))
                return false;
        }
        return true;
    }
    /**
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3104
     */
    public void buildConnectionSetsForExpandableConnector(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        if (useInFlattening()) {
            if (!isArray()) {
                if (csm.isExpandableConnectorsDone()) {
                    for (InstComponentDecl icd : getInstComponentDecls()) {
                        if (icd.isArray()) {
                            icd.addExpandableArrayMembersTopLevel(csm);
                        }
                    }
                } else {
                    csm.getExpandable().addConnector(this);
                }
            }
            super.buildConnectionSets(prefix, csm, connect);
        }
    }
    /**
     * Add all variables to connection set manager, to get "= 0" equations if they are not connected.
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3124
     */
    public void addExpandableArrayMembersTopLevel(ConnectionSetManager csm) {
        for (InstComponentDecl icd : allInstComponentDecls()) {
            icd.addExpandableArrayMembers(csm);
        }
    }
    /**
     * Add all variables to connection set manager, to get "= 0" equations if they are not connected.
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3141
     */
    public void addExpandableArrayMembers(ConnectionSetManager csm) {
        for (InstComponentDecl icd : allInstComponentDecls()) {
            icd.addExpandableArrayMembers(csm);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:319
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        if (useInFlattening()) {
            super.flattenUsedFuncsAndEnums(f);
            if (isOperatorRecord() && isFlow())
                type().matchOverloadedZero().flattenFunction(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:354
     */
    public void flattenOverloadedOperatorsForFlow(Flattener f) {
        if (useInFlattening()) {
            if (isOperatorRecord() && isFlow())
                type().flattenOverloadedOperatorsForFlow(f);
            else
                super.flattenOverloadedOperatorsForFlow(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:810
     */
    public void addExternalArg(FExternalStmt stmt) {}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:841
     */
    public void flattenInFunction(Flattener f, List<FFunctionVariable> vars, List<FStatement> stmts) {}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:868
     */
    public void addFInitArrayStmt(Flattener f, List<FStatement> l, boolean input, FAccess access, ForNames names) {
        
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:904
     */
    public void addFInitArrayStmtCell(Flattener f, List<FStatement> l, boolean input, FAccess access, ForNames names) {
        for (InstComponentDecl icd : allInstComponentDecls()) {
            icd.addFInitArrayStmt(f, l, input, access.copyAndAppend(icd.name()), names);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:926
     */
    public void addBindingAssignments(Flattener f, List<FStatement> l) {
        for (InstComponentDecl icd : allInstComponentDecls()) {
            icd.addBindingAssignments(f, l);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1171
     */
    public void flatten(Flattener f, FlattenBindingExp binding, int level) {
        if (useInFlattening()) {
            super.flatten(f, binding, level);
            if (!isPrimitive() && !hasFArraySubscripts() && !isConnector()) {
                f.countComponent();
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1193
     */
    public void flattenInRecord(Flattener f, FRecordDecl frd, Set<String> names) {}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1575
     */
    public void addAttributesToFV(Flattener f, List<FAttribute> attr, Stack<Integer> indexStack,
            FlattenBindingExp binding, boolean isBound) {
        if (isArray()) {
            int i = 0;
            for (InstComponentDecl icd : allInstComponentDecls()) {
                indexStack.push(i++);
                icd.addAttributesToFV(f, attr, indexStack, binding, isBound);
                indexStack.pop();
            }
        } else {
            for (InstComponentDecl icd : allInstComponentDecls()) {
                if (icd.useInFlattening()) {
                    icd.generateAdditionalAttributes(f, attr, indexStack, binding, isBound);
                }
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1611
     */
    public void generateAdditionalAttributes(Flattener f, List<FAttribute> attr, Stack<Integer> indexStack,
            FlattenBindingExp binding, boolean isBound) {
        
    }
    /**
     * Separate method for extensibility.
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2364
     */
    private FAccessExp createCommonAccessExp(FAccess name, int order) {
        if (order > 0) {
            return new FDerExp(name, order);
        } else {
            return new FAccessExp(name);
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2756
     */
    public FExp flattenInRecordConstructor(Flattener f) {
        return null;
    }
    /**
     * Flatten an access expression to this component.
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:65
     */
    public FExp flattenAccess(Flattener f, CommonAccessExp access, int order) {
        return createCommonAccessExp(access.asInstAccess().flatten(f), order);
    }
    /**
     * Called for inputs that no argument was bound to. Creates an InstDefaultArgument 
     * if the input has a default value and an InstBadArgument otherwise.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:180
     */
    public InstFunctionArgument createInstDefaultArgument() {
        InstFunctionArgument arg = buildInstDefaultArgument();
        arg.setBoundInput(this);
        return arg;
    }
    /**
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:186
     */
    public InstFunctionArgument buildInstDefaultArgument() {
        return new InstUnknownArgument();
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:961
     */
    public InstComponentDecl createInstArrayComponentDecl(int i) {
        return new InstArrayComponentDecl(name(), new InstClassAccess("ArrayDecl"), new Opt(), 
                getSrcComponentDecl(), new Opt(), new Opt(), new Opt(), i);
    }
    /**
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2655
     */
    public void addLocalFArraySubscriptsTo(java.util.List<Subscript> l) {
        if (hasLocalFArraySubscripts()) {
            for (Subscript s : getLocalFArraySubscripts().subscripts()) {
                l.add(s);
            }
        } else {
            addFSubscriptsFromOriginalDeclTo(l);
        }
	}
    /**
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2665
     */
    public void addFSubscriptsFromOriginalDeclTo(java.util.List<Subscript> l) {}
    /**
     * @aspect InstanceToString
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2738
     */
    public String toString() {
    	return getSrcComponentDecl().myComponentClause().toString();
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:175
     */
    public static final Comparator<InstComponentDecl> NAME_COMPARATOR = 
        new Comparator<InstComponentDecl>() {
        public int compare(InstComponentDecl o1, InstComponentDecl o2) {
            return o1.name().compareTo(o2.name());
        }
    };
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2149
     */
    public SrcAnnotatable mySrcAnnotatable() {
        boolean hasAnnotations = getSrcComponentDecl().srcAnnotationProvider().hasAnnotation();
        if (!hasAnnotations) {
            SrcAnnotatable annotatable = srcannotatableFromEnviroment();
            if (annotatable != null) {
                return annotatable;
            }
            SrcAnnotatable orginal = orginalAnnotatable();
            if (orginal.srcAnnotationProvider().hasAnnotation()) {
                return orginal;
            }
        }
        return getSrcComponentDecl();
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:28
     */
    public SrcAnnotationNode srcClassAnnotation(String ... path) {
        return myInstClass().getSrcClassDecl().srcAnnotation(new SrcAnnotationNode.InstEvaluator(this), path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:46
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return SrcAnnotationNode.createFor(srcAnnotationProvider(), new SrcAnnotationNode.InstEvaluator(containingInstNode()), path);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:455
     */
    public String name_C() {
        StringBuilder buf = new StringBuilder();
        buf.append(getFAccess().nameUnderscore());
        buf.append('_');
        buf.append(type().isArray() ? C_SUFFIX_ARRAY : C_SUFFIX_VARIABLE);
        return buf.toString();
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstComponentDecl() {
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
    public InstComponentDecl(String p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6) {
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
    public InstComponentDecl(beaver.Symbol p0, InstAccess p1, Opt<FArraySubscripts> p2, SrcComponentDecl p3, Opt<InstModification> p4, Opt<InstConstrainingComponent> p5, Opt<FExp> p6) {
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
        getFAccess_reset();
        myInnerInstComponentDecl_reset();
        type_reset();
        definedVariability_reset();
        localDefinedVariability_reset();
        variability_reset();
        getInstComponentDeclList_reset();
        getFAbstractEquationList_reset();
        myFSubscripts_reset();
        getFArraySubscripts_reset();
        getClassAnnotationOpt_reset();
        getAnnotationOpt_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:80
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:84
     */
    public InstComponentDecl clone() throws CloneNotSupportedException {
        InstComponentDecl node = (InstComponentDecl) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:95
     */
    @Deprecated
    public abstract InstComponentDecl fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:103
     */
    public abstract InstComponentDecl treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:111
     */
    public abstract InstComponentDecl treeCopy();
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Name;
    /**
     */
    public int Namestart;
    /**
     */
    public int Nameend;
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
    /** @apilevel internal 
     */
    protected SrcComponentDecl tokenSrcComponentDecl_SrcComponentDecl;
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
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:520
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:520")
    public int ndims() {
        int ndims_value = hasFArraySubscripts() ? getFArraySubscripts().ndims() : 0;
        return ndims_value;
    }
    /**
     * The number of array dimensions declared locally on this component, i.e. not from the type.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:528
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:528")
    public int localNdims() {
        int localNdims_value = hasLocalFArraySubscripts() ? getLocalFArraySubscripts().ndims() : 0;
        return localNdims_value;
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
        size_value = declaredSize();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /**
     * Get the array sizes as declared. May be unknown. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1133")
    public Size declaredSize() {
        Size declaredSize_value = hasFArraySubscripts() ? getFArraySubscripts().declarationSize() : defaultSize();
        return declaredSize_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1135
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1135")
    public Size declaredSizeCalc() {
        Size declaredSizeCalc_value = hasFArraySubscripts() ? getFArraySubscripts().declarationSize() : defaultSizeCalc();
        return declaredSizeCalc_value;
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
     * Get the set of all array indices of an InstComponentDecl. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2282")
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2888
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2888")
    public CValue ceval() {
        CValue ceval_value = ceval(defaultVariableEvaluator());
        return ceval_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2889
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2889")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = (evaluationValue == null) ? CValue.UNKNOWN : evaluationValue;
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
        CValue ceval_VariableEvaluator_Index_value = CValue.UNKNOWN;
        return ceval_VariableEvaluator_Index_value;
    }
    /**
     * Find and evaluate the "start" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3018
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3018")
    public CValue startAttributeCValue(VariableEvaluator evaluator) {
        CValue startAttributeCValue_VariableEvaluator_value = CValue.UNKNOWN;
        return startAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "fixed" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3024
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3024")
    public CValue fixedAttributeCValue() {
        CValue fixedAttributeCValue_value = fixedAttributeCValue(defaultVariableEvaluator());
        return fixedAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3025
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3025")
    public CValue fixedAttributeCValue(VariableEvaluator evaluator) {
        CValue fixedAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.FIXED);
        return fixedAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "quantity" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3030
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3030")
    public CValue quantityAttributeCValue() {
        CValue quantityAttributeCValue_value = quantityAttributeCValue(defaultVariableEvaluator());
        return quantityAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3031
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3031")
    public CValue quantityAttributeCValue(VariableEvaluator evaluator) {
        CValue quantityAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.QUANTITY);
        return quantityAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "unit" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3036
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3036")
    public CValue unitAttributeCValue() {
        CValue unitAttributeCValue_value = unitAttributeCValue(defaultVariableEvaluator());
        return unitAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3037
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3037")
    public CValue unitAttributeCValue(VariableEvaluator evaluator) {
        CValue unitAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.UNIT);
        return unitAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "displayUnit" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3042
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3042")
    public CValue displayUnitAttributeCValue() {
        CValue displayUnitAttributeCValue_value = displayUnitAttributeCValue(defaultVariableEvaluator());
        return displayUnitAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3043
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3043")
    public CValue displayUnitAttributeCValue(VariableEvaluator evaluator) {
        CValue displayUnitAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.DISPLAY_UNIT);
        return displayUnitAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "min" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3048
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3048")
    public CValue minAttributeCValue() {
        CValue minAttributeCValue_value = minAttributeCValue(defaultVariableEvaluator());
        return minAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3049
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3049")
    public CValue minAttributeCValue(VariableEvaluator evaluator) {
        CValue minAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.MIN);
        return minAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "max" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3054
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3054")
    public CValue maxAttributeCValue() {
        CValue maxAttributeCValue_value = maxAttributeCValue(defaultVariableEvaluator());
        return maxAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3055
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3055")
    public CValue maxAttributeCValue(VariableEvaluator evaluator) {
        CValue maxAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.MAX);
        return maxAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "nominal" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3060
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3060")
    public CValue nominalAttributeCValue() {
        CValue nominalAttributeCValue_value = nominalAttributeCValue(defaultVariableEvaluator());
        return nominalAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3061
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3061")
    public CValue nominalAttributeCValue(VariableEvaluator evaluator) {
        CValue nominalAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.NOMINAL);
        return nominalAttributeCValue_VariableEvaluator_value;
    }
    /**
     * Find and evaluate the "stateSelect" attribute. If it is not found, use default value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3066
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3066")
    public CValue stateSelectAttributeCValue() {
        CValue stateSelectAttributeCValue_value = stateSelectAttributeCValue(defaultVariableEvaluator());
        return stateSelectAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3067
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3067")
    public CValue stateSelectAttributeCValue(VariableEvaluator evaluator) {
        CValue stateSelectAttributeCValue_VariableEvaluator_value = attributeCValueGeneric(evaluator, FAttribute.STATE_SELECT);
        return stateSelectAttributeCValue_VariableEvaluator_value;
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
        CValue attributeCValueGeneric_VariableEvaluator_String_value = CValue.UNKNOWN;
        return attributeCValueGeneric_VariableEvaluator_String_value;
    }
    /**
     * Get the default value for attribute <code>name</code> for a given type.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3113
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3113")
    public CValue attributeCValueDefault(String name) {
        CValue attributeCValueDefault_String_value = CValue.UNKNOWN;
        return attributeCValueDefault_String_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3504
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3504")
    public FAbstractVariable asFAbstractVariable() {
        FAbstractVariable asFAbstractVariable_value = null;
        return asFAbstractVariable_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4681
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4681")
    public boolean isUnknownSizeVar() {
        boolean isUnknownSizeVar_value = type().size().isUnknown();
        return isUnknownSizeVar_value;
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
                new_isCircular_int_value = false;
                if (((Boolean)_value.value) != new_isCircular_int_value) {
                    state.setChangeInCycle();
                    _value.value = new_isCircular_int_value;
                }
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                isCircular_int_values.put(_parameters, new_isCircular_int_value);
                state.startLastCycle();
                boolean $tmp = false;
            } else {
                isCircular_int_values.remove(_parameters);
                state.startResetCycle();
                boolean $tmp = false;
            }
            state.leaveCircle();
            return new_isCircular_int_value;
        } else if (_value.cycle != state.cycle()) {
            _value.cycle = state.cycle();
            boolean new_isCircular_int_value = false;
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
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1602
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1602")
    public boolean isInitialParameter() {
        boolean isInitialParameter_value = variability().initialParameterVariability();
        return isInitialParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3138
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3138")
    public boolean isComposite() {
        boolean isComposite_value = isArray() || isRecord();
        return isComposite_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:995
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:995")
    public InstAccess createInstAccess() {
        InstAccess createInstAccess_value = new InstComponentAccess(name());
        return createInstAccess_value;
    }
    /**
     * May this component be altered by a modification?
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1205
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1205")
    public boolean isModifiable() {
        boolean isModifiable_value = !(definedVariability().constantVariability() && hasBindingExp()) &&
                     !(definedVariability().parameterVariability() && getSrcComponentDecl().hasFinal());
        return isModifiable_value;
    }
    /**
     * @attribute syn
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:509
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:509")
    public boolean isAttribute() {
        boolean isAttribute_value = false;
        return isAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:889
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:889")
    public boolean shouldCheckInto(ErrorCheckType checkType) {
        boolean shouldCheckInto_ErrorCheckType_value = !isDisabled() || checkType.checkInactiveComponents() || myOptions().getBooleanOption("check_inactive_contitionals");
        return shouldCheckInto_ErrorCheckType_value;
    }
    /**
     * Check if this node is in a recursive structure.
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1492
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1492")
    public boolean isRecursed() {
        boolean isRecursed_value = !isPrimitive() && isWithin(myInstClass());
        return isRecursed_value;
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
        boolean isOfInstClassDecl_InstClassDecl_value = icd == myInstClass() && !icd.isUnknown();
        return isOfInstClassDecl_InstClassDecl_value;
    }
    /**
     * Is this component a duplicate of another component?
     * @attribute syn
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:132
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DuplicateComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:132")
    public boolean isDuplicate() {
        boolean isDuplicate_value = duplicateOf() != null;
        return isDuplicate_value;
    }
    /**
     * If this component is a duplicate of one or more other components, 
     * return the component chosen to be considered the original.
     * @attribute syn
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:138
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DuplicateComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:138")
    public InstComponentDecl duplicateOriginal() {
        InstComponentDecl duplicateOriginal_value = isDuplicate() ? duplicateOf() : this;
        return duplicateOriginal_value;
    }
    /**
     * Get the component that this component is a duplicate of, if any.
     * @attribute syn
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:143
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DuplicateComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:143")
    public InstComponentDecl duplicateOf() {
        {
                if (!duplicateOfCalculated) 
                    containingEntity().calculateDuplicates();
                return duplicateOfValue;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:390")
    public String kindDescription() {
        String kindDescription_value = myInstClass().kindDescription() + " instance";
        return kindDescription_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:583
     */
    @Override
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:583")
    public boolean containsFunction(FFunctionDecl.FunctionType ft) {
        boolean containsFunction_FFunctionDecl_FunctionType_value = (hasInstModification() && getInstModification().containsFunction(ft)) ||  super.containsFunction(ft);
        return containsFunction_FFunctionDecl_FunctionType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1074
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1074")
    public FType myIndexType(int dim) {
        {
            FArraySubscripts fas = getFArraySubscripts();
            if (fas != null && fas.ndims() > dim)
                return fas.subscript(dim).type().scalarType();
            else
                return fUnknownType();
          }
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1255
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1255")
    public boolean isOverconstrainedConnection(InstComponentDecl right) {
        boolean isOverconstrainedConnection_InstComponentDecl_value = isOverconstrainedType() && right.isOverconstrainedType();
        return isOverconstrainedConnection_InstComponentDecl_value;
    }
    /**
     * Retrieve the specific cell for a given index from an array component.
     * 
     * What dimension of i that refers to the children of this component is given by j.
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1263
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1263")
    public InstComponentDecl findCell(Index i, int j) {
        InstComponentDecl findCell_Index_int_value = ((j > 0) ? findCellUp(i, j, this) : this).findCellDown(i, j);
        return findCell_Index_int_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1282")
    public InstComponentDecl findCellDown(Index i, int j) {
        InstComponentDecl findCellDown_Index_int_value = (j < i.ndims()) ? getInstComponentDecl(i.get(j) - 1).findCellDown(i, j + 1) : this;
        return findCellDown_Index_int_value;
    }
    /**
     * Check if an assignable is of an overconstrained connection type.
     * @attribute syn
     * @aspect OverconstrainedConnections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1469
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverconstrainedConnections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1469")
    public boolean isOverconstrainedType() {
        boolean isOverconstrainedType_value = equalityConstraint() != null;
        return isOverconstrainedType_value;
    }
    /**
     * Get the equality constraint function for this type, if any.
     * @attribute syn
     * @aspect OverconstrainedConnections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1479
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OverconstrainedConnections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1479")
    public InstClassDecl equalityConstraint() {
        InstClassDecl equalityConstraint_value = null;
        return equalityConstraint_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:819
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:819")
    public boolean canBeExternalReturn(FExternalLanguage lang) {
        boolean canBeExternalReturn_FExternalLanguage_value = false;
        return canBeExternalReturn_FExternalLanguage_value;
    }
    /**
     * Check if this component is present in the model (i.e. not a disabled conditional 
     * and not a non-selected duplicate).
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1163
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1163")
    public boolean isPresent() {
        boolean isPresent_value = !isDisabled() && !isDuplicate();
        return isPresent_value;
    }
    /**
     * Check if this component should be considered during flattening.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1169
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1169")
    public boolean useInFlattening() {
        boolean useInFlattening_value = isPresent() && !(isOuter() && !isInner());
        return useInFlattening_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1355
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1355")
    public InstComponentDecl scalar() {
        {
                InstComponentDecl rec = this;
                for (int i = 0; i < ndims(); i++) {
                    if (rec.getNumInstComponentDecl() == 0) {
                        return null;
                    } else {
                        rec = rec.getInstComponentDecl(0);
                    }
                }
                return rec;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1367")
    public String qualifiedTypeName() {
        {
                if (flattenRedeclaredType()) {
                    return surroundingInstClass().qualifiedName() + ":" + qualifiedName();
                } else {
                    return myInstClass().qualifiedName();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1385
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1385")
    public boolean flattenRedeclaredType() {
        boolean flattenRedeclaredType_value = InstNode.containsRedeclared(this);
        return flattenRedeclaredType_value;
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
        FExp myBindingInstExp_value = null;
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
        boolean hasBindingFExp_value = false;
        return hasBindingFExp_value;
    }
    /**
     * Retrieve the part of the binding expression that applies to this InstAssignable.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1762
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1762")
    public FExp getBindingFExp() {
        FExp getBindingFExp_value = null;
        return getBindingFExp_value;
    }
    /**
     * Check if this InstComponentDecl is an assignable has an InstModification setting 
     * its binding expression.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2018
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2018")
    public boolean hasInstValueMod() {
        boolean hasInstValueMod_value = (myInstValueMod() != null);
        return hasInstValueMod_value;
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
        boolean hasBindingExp_value = false;
        return hasBindingExp_value;
    }
    /**
     * Retrieve the InstModification setting the binding expression of 
     * this component. 
     * 
     * If the component is not an assignable, or is an assignable that does 
     * not have a binding expression, return <code>null</code>.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2033
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2033")
    public InstValueModification myInstValueMod() {
        InstValueModification myInstValueMod_value = null;
        return myInstValueMod_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2037
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2037")
    public InstValueModification myInstValueModCalc() {
        {
                InstValueModification ivm = parentInstValueMod();
                if (ivm != null) {
                    return ivm;
                }
                for (InstModification im : totalMergedEnvironment()) {
                    if (im.hasInstValueMod()) {
                        return im.getInstValueMod();
                    }
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2133")
    public boolean isBuiltIn() {
        boolean isBuiltIn_value = false;
        return isBuiltIn_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218")
    public InstNode[] extraNodesToSetModLevelFor() {
        InstNode[] extraNodesToSetModLevelFor_value = listExtraNodesToSetModLevelFor(true, myInstClass());
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
        getFAccess_value = appendMyName(retrieveFAccess());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFAccess_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getFAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFAccesss
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:181
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFAccesss", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:181")
    public FAccess appendMyName(FAccess prefix) {
        FAccess appendMyName_FAccess_value = prefix.copyAndAppend(name());
        return appendMyName_FAccess_value;
    }
    /**
     * @attribute syn
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:38
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:38")
    public boolean inOrIsOuter() {
        boolean inOrIsOuter_value = isOuter() || inOuter();
        return inOrIsOuter_value;
    }
    /**
     * @attribute syn
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:39
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:39")
    public boolean inOrIsInner() {
        boolean inOrIsInner_value = isInner() || inInner();
        return inOrIsInner_value;
    }
    /** @apilevel internal */
    private void myInnerInstComponentDecl_reset() {
        myInnerInstComponentDecl_computed = false;
        
        myInnerInstComponentDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myInnerInstComponentDecl_computed = false;

    /** @apilevel internal */
    protected InstComponentDecl myInnerInstComponentDecl_value;

    /**
     * @attribute syn
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:41
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:41")
    public InstComponentDecl myInnerInstComponentDecl() {
        ASTState state = state();
        if (myInnerInstComponentDecl_computed) {
            return myInnerInstComponentDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myInnerInstComponentDecl_value = myInnerInstComponentDecl_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myInnerInstComponentDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myInnerInstComponentDecl_value;
    }
    /** @apilevel internal */
    private InstComponentDecl myInnerInstComponentDecl_compute() {
            InstComponentDecl res = null;
            if (isOuter()) {
                res = lookupInnerInstComponent(this, true);
            }
            return (res == null) ? unknownInstComponentDecl() : res;
        }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:425
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:425")
    public InstLookupResult<InstClassDecl> genericLookupInstClass(String name) {
        {
                InstLookupResult<InstClassDecl> res = memberInstClass(name);
                if (res.successful())
                    return res;
                
                for (InstImport ii : getInstImports()) {
                    res = ii.lookupInstClassInImport(name);
                    if (res.successful())
                        return res;
                }
                
                return myInstClass().lookupInstClassInSurrounding(name);
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:443
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:443")
    public InstLookupResult<InstClassDecl> superLookupInstClassInComponent(String name) {
        {
                // TODO: Why do we do this? Seems to be needed, as tests fail without it
                if (myInstClass().isRedeclaredNonSimple())
                    return myInstClass().lookupInstClassInInstClassRedeclare(name);
                
                for (InstImport ii : getInstImports()) {
                    InstLookupResult<InstClassDecl> res = ii.lookupInstClassInImport(name);
                    if (res.successful())
                        return res;
                }
                
                for (InstClassDecl icd : getInstClassDecls()) 
                    if (icd.matches(name)) 
                        return InstLookupResult.found(icd);
            
                return myInstClass().superLookupInstClass(name);
            }
    }
    /**
     * Returns the InstComponentDecl representing the first cell of the array.
     * 
     * @param ndims  the number of dimensions of the array.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:523
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:523")
    public InstComponentDecl arrayCellInstComponent(int ndims) {
        {
                if (ndims == 0) 
                    return this;
                if (getNumInstComponentDecl() == 0)
                    return unknownInstComponentDecl();
                return getInstComponentDecl(0).arrayCellInstComponent(ndims - 1);
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:485
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:485")
    public InstLookupResult<InstClassDecl> memberInstClass(String name) {
        {
                if (isArray() && !isPrimitive()) {
                    return arrayCellInstComponent(ndims()).memberInstClass(name);
                } else {
                    for (InstClassDecl icd : getInstClassDecls()) 
                        if (icd.matches(name)) 
                            return InstLookupResult.found(findInnerClassIfAny(icd));
                    
                    for (InstExtends ie : getInstExtendss()) {
                        InstLookupResult<InstClassDecl> res = ie.memberInstClass(name);
                        if (res.successful())
                            return res;
                    }
                    
                    return InstLookupResult.notFound();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595")
    public InstClassDecl myInstClass() {
        InstClassDecl myInstClass_value = getClassName().myInstClassDecl();
        return myInstClass_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:593
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:593")
    public InstLookupResult<InstComponentDecl> genericLookupInstConstant(String name) {
        InstLookupResult<InstComponentDecl> genericLookupInstConstant_String_value = myInstClass().lookupInstConstant(name);
        return genericLookupInstConstant_String_value;
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
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:82
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:82")
    public FType createRecordType() {
        {
                InstComponentDecl root = this;
                for (int i = 0; i < ndims(); i++) {
                    if (root.getNumInstComponentDecl() == 0)
                        return myInstClass().recordType().sizedType(size());
                    root = root.getInstComponentDecl(0);
                }
                FRecordType type = myInstClass().resolveLib().createEmptyFRecordType(size());
                for (InstComponentDecl icd : root.allInstComponentDecls()) 
                    type.addComponent(new FRecordComponentType(icd.name(), (FType) icd.type().treeCopy()));
                return type;
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
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:159")
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
     * Check if node is the same as this or the class of this component (if this is a component).
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:403
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:403")
    public boolean isMeOrMyClass(InstNode node) {
        {
                InstNode inherit = node.inheritingNode();
                return inherit == this || inherit == myInstClass();
            }
    }
    /**
     * Is this component a connector?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:573")
    public boolean isConnector() {
        boolean isConnector_value = myInstClass().isConnector();
        return isConnector_value;
    }
    /**
     * Is this component an expandable connector?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:591
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:591")
    public boolean isExpandableConnector() {
        boolean isExpandableConnector_value = myInstClass().isExpandableConnector();
        return isExpandableConnector_value;
    }
    /**
     * Is this component an operator record?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:611
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:611")
    public boolean isOperatorRecord() {
        boolean isOperatorRecord_value = false;
        return isOperatorRecord_value;
    }
    /** @apilevel internal */
    private void definedVariability_reset() {
        definedVariability_computed = false;
        
        definedVariability_value = null;
    }
    /** @apilevel internal */
    protected boolean definedVariability_computed = false;

    /** @apilevel internal */
    protected TypePrefixVariability definedVariability_value;

    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:24
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:24")
    public TypePrefixVariability definedVariability() {
        ASTState state = state();
        if (definedVariability_computed) {
            return definedVariability_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        definedVariability_value = localDefinedVariability().combineDown(overrideVariability());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        definedVariability_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return definedVariability_value;
    }
    /** @apilevel internal */
    private void localDefinedVariability_reset() {
        localDefinedVariability_computed = false;
        
        localDefinedVariability_value = null;
    }
    /** @apilevel internal */
    protected boolean localDefinedVariability_computed = false;

    /** @apilevel internal */
    protected TypePrefixVariability localDefinedVariability_value;

    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:26
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:26")
    public TypePrefixVariability localDefinedVariability() {
        ASTState state = state();
        if (localDefinedVariability_computed) {
            return localDefinedVariability_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        localDefinedVariability_value = localDefinedVariability_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        localDefinedVariability_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return localDefinedVariability_value;
    }
    /** @apilevel internal */
    private TypePrefixVariability localDefinedVariability_compute() {
            SrcComponentDecl cd = getSrcComponentDecl();
            return cd.hasSrcTypePrefixVariability() ? cd.getSrcTypePrefixVariability().flatten() : noDefinedVariability();
        }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:31
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:31")
    public TypePrefixVariability noDefinedVariability() {
        TypePrefixVariability noDefinedVariability_value = Variability.CONTINUOUS;
        return noDefinedVariability_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:42
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:42")
    public boolean isConstant() {
        boolean isConstant_value = variability().constantVariability();
        return isConstant_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:43")
    public boolean isParameter() {
        boolean isParameter_value = variability().parameterVariability();
        return isParameter_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:44")
    public boolean isDiscrete() {
        boolean isDiscrete_value = variability().discreteVariability();
        return isDiscrete_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:45
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:45")
    public boolean isContinuous() {
        boolean isContinuous_value = variability().continuousVariability();
        return isContinuous_value;
    }
    /**
     * Get variability without any variability propagation, structural considerations, etc.
     * Does not combine component variabilities for records.
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:51
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:51")
    public TypePrefixVariability originalVariability() {
        TypePrefixVariability originalVariability_value = definedVariability().combineDown(defaultVariability());
        return originalVariability_value;
    }
    /** @apilevel internal */
    private void variability_reset() {
        variability_computed = false;
        
        variability_value = null;
    }
    /** @apilevel internal */
    protected boolean variability_computed = false;

    /** @apilevel internal */
    protected TypePrefixVariability variability_value;

    /**
     * Calculate variability.
     * This attribute should only have one equation, sometimes we flush it manually.
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:57")
    public TypePrefixVariability variability() {
        ASTState state = state();
        if (variability_computed) {
            return variability_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        variability_value = calcVariability();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        variability_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:59")
    public TypePrefixVariability calcVariability() {
        TypePrefixVariability calcVariability_value = originalVariability();
        return calcVariability_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:149
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:149")
    public TypePrefixVariability defaultVariability() {
        TypePrefixVariability defaultVariability_value = Variability.CONTINUOUS;
        return defaultVariability_value;
    }
    /**
     * @attribute syn
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:153
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:153")
    public TypePrefixVariability bExpVariability() {
        TypePrefixVariability bExpVariability_value = Variability.CONTINUOUS;
        return bExpVariability_value;
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
                if (hasInstModification() && !isGeneratedInner()) {
                    l.add(getInstModification());
                }
                l.addAll(instModificationsFromConstrainingType());
                if (myInstClass().isRedeclared()) {
                    l.addAll(myInstClass().instModificationsFromConstrainingType());
                }
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
        Collection<InstModification> localInstModificationsClass_value = myInstClass().classInstModifications();
        return localInstModificationsClass_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:399")
    public java.util.List<InstModification> instModificationsForConstraining() {
        {
                if (!isGeneratedInner()) {
                    if (hasInstConstrainingComponent()) {
                        if (getInstConstrainingComponent().hasInstClassModification())
                            return Collections.singletonList((InstModification) getInstConstrainingComponent().getInstClassModification());
                    } else if (hasInstModification()) {
                        return Collections.singletonList(getInstModification());
                    }
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
    /** @apilevel internal */
    private void getInstComponentDeclList_reset() {
        getInstComponentDeclList_computed = false;
        
        getInstComponentDeclList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstComponentDeclList_computed = false;

    /** @apilevel internal */
    protected List getInstComponentDeclList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:934
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:934")
    public List getInstComponentDeclList() {
        ASTState state = state();
        if (getInstComponentDeclList_computed) {
            return (List) getChild(getInstComponentDeclListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstComponentDeclList_value = getInstComponentDeclList_compute();
        if(getInstComponentDeclList_value.numChildren() <= 0) {
            getInstComponentDeclList_value  = List.EMPTY;
        }
        setChild(getInstComponentDeclList_value, getInstComponentDeclListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstComponentDeclList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getInstComponentDeclListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getInstComponentDeclList_compute() {
            //System.out.println( " : " + getClass().getName() + " : "+ myFSubscripts().size());
            if (isArray()) { // Take care of array declarations separately
                // Loop over indices and create new InstArrayComponentDecls
                List l = new List();
                // Only one FSubscript is used to create the one layer of InstArrayComponentDecls.
                // For a zero length or unknown length, create a dummy node with index 0.
                int n = childDimensionLength();
                for (int i = (n < 1) ? 0 : 1; i <= n || i == 0; i++)
                    l.add(createInstArrayComponentDecl(i));
                return l;
            } else { // If not array, then proceed as usual
                return super.getInstComponentDeclList();
            }
        }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1010
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1010")
    public boolean shouldHaveInstExtendsList() {
        boolean shouldHaveInstExtendsList_value = !isArrayDecl();
        return shouldHaveInstExtendsList_value;
    }
    /** @apilevel internal */
    private void getFAbstractEquationList_reset() {
        getFAbstractEquationList_computed = false;
        
        getFAbstractEquationList_value = null;
    }
    /** @apilevel internal */
    protected boolean getFAbstractEquationList_computed = false;

    /** @apilevel internal */
    protected List getFAbstractEquationList_value;

    /**
     * @attribute syn nta
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1892
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1892")
    public List getFAbstractEquationList() {
        ASTState state = state();
        if (getFAbstractEquationList_computed) {
            return (List) getChild(getFAbstractEquationListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFAbstractEquationList_value = isArrayParent() ? new List() : buildFAbstractEquationList();
        if(getFAbstractEquationList_value.numChildren() <= 0) {
            getFAbstractEquationList_value  = List.EMPTY;
        }
        setChild(getFAbstractEquationList_value, getFAbstractEquationListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFAbstractEquationList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getFAbstractEquationListChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1898
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1898")
    public boolean isArrayParent() {
        boolean isArrayParent_value = getNumInstComponentDecl() > 0 && getInstComponentDecl(0).isArrayChild();
        return isArrayParent_value;
    }
    /**
     * @attribute syn
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1901
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstaceConstrainingClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1901")
    public boolean isArrayChild() {
        boolean isArrayChild_value = false;
        return isArrayChild_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1934
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1934")
    public boolean nameScope() {
        boolean nameScope_value = true;
        return nameScope_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1939
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1939")
    public String name() {
        String name_value = getName();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1964
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1964")
    public String qualifiedName() {
        String qualifiedName_value = getFAccess().name();
        return qualifiedName_value;
    }
    /**
     * Get the qualified class name of the oldest ancestor in the inheritance structure.
     * 
     * For classes inheriting multiple classes, only the first one is considered.
     * This is useful mostly for classes that only allows inheriting from one other class.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2006
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2006")
    public String baseClassName() {
        String baseClassName_value = myInstClass().baseClassName();
        return baseClassName_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2013
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2013")
    public Iterable<SrcAbstractEquation> equations() {
        Iterable<SrcAbstractEquation> equations_value = myInstClass().equations();
        return equations_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2018
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2018")
    public Iterable<SrcAlgorithm> algorithms() {
        Iterable<SrcAlgorithm> algorithms_value = myInstClass().algorithms();
        return algorithms_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2023
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2023")
    public Iterable<FAlgorithm> fAlgorithms() {
        Iterable<FAlgorithm> fAlgorithms_value = myInstClass().fAlgorithms();
        return fAlgorithms_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2037
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2037")
    public Iterable<SrcComponentDecl> components() {
        Iterable<SrcComponentDecl> components_value = myInstClass().components();
        return components_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2045
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2045")
    public Iterable<SrcExtendsClause> superClasses() {
        Iterable<SrcExtendsClause> superClasses_value = myInstClass().superClasses();
        return superClasses_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2052
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2052")
    public Iterable<SrcClassDecl> classes() {
        Iterable<SrcClassDecl> classes_value = myInstClass().classes();
        return classes_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2060
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2060")
    public Iterable<SrcImportClause> imports() {
        Iterable<SrcImportClause> imports_value = myInstClass().imports();
        return imports_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2066
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2066")
    public Iterable<SrcModificationOrRedeclareElement> elementModifications() {
        Iterable<SrcModificationOrRedeclareElement> elementModifications_value = myInstClass().elementModifications();
        return elementModifications_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2107
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2107")
    public boolean hasInstConstraining() {
        boolean hasInstConstraining_value = hasInstConstrainingComponent();
        return hasInstConstraining_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2111")
    public InstConstraining getInstConstraining() {
        InstConstraining getInstConstraining_value = getInstConstrainingComponent();
        return getInstConstraining_value;
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
        boolean isReplaceable_value = getSrcComponentDecl().hasReplaceable();
        return isReplaceable_value;
    }
    /**
     * Check if this node is a component declaration or an extends in one.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2191
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2191")
    public boolean isComponentDecl() {
        boolean isComponentDecl_value = true;
        return isComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2272")
    public boolean isThisClass(InstNode node) {
        boolean isThisClass_InstNode_value = myInstClass().isThisClass(node);
        return isThisClass_InstNode_value;
    }
    /**
     * Find the length of the dimension corresponding to this InstArrayComponentDecl.
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2556
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2556")
    public int myDimensionLength() {
        int myDimensionLength_value = size().get(0);
        return myDimensionLength_value;
    }
    /**
     * Find the length of the dimension corresponding to the next level of InstArrayComponentDecls in an array.
     * 
     * For a primitive, the length of the first dimension is returned.
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2564
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2564")
    public int childDimensionLength() {
        int childDimensionLength_value = size().get(0);
        return childDimensionLength_value;
    }
    /**
     * If this is an array, get the top level component for the array.
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2623
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2623")
    public InstComponentDecl arrayTopInstComponentDecl() {
        InstComponentDecl arrayTopInstComponentDecl_value = this;
        return arrayTopInstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2626
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2626")
    public boolean isArrayDecl() {
        boolean isArrayDecl_value = hasFArraySubscripts() && 
        		getFArraySubscripts().ndims()>0;
        return isArrayDecl_value;
    }
    /** @apilevel internal */
    private void myFSubscripts_reset() {
        myFSubscripts_computed = false;
        
        myFSubscripts_value = null;
    }
    /** @apilevel internal */
    protected boolean myFSubscripts_computed = false;

    /** @apilevel internal */
    protected java.util.List<Subscript> myFSubscripts_value;

    /**
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2648
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2648")
    public java.util.List<Subscript> myFSubscripts() {
        ASTState state = state();
        if (myFSubscripts_computed) {
            return myFSubscripts_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFSubscripts_value = myFSubscripts_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFSubscripts_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFSubscripts_value;
    }
    /** @apilevel internal */
    private java.util.List<Subscript> myFSubscripts_compute() {
    		java.util.List<Subscript> l = new ArrayList<>();
    		addLocalFArraySubscriptsTo(l);
    		l.addAll(myInstClass().myFSubscripts());
    		return l;
    	}
    /** @apilevel internal */
    private void getFArraySubscripts_reset() {
        getFArraySubscripts_computed = false;
        
        getFArraySubscripts_value = null;
    }
    /** @apilevel internal */
    protected boolean getFArraySubscripts_computed = false;

    /** @apilevel internal */
    protected FArraySubscripts getFArraySubscripts_value;

    /**
     * This is the definition of an NTA that collects both the local
     * array subscripts given a component declaration and array subscripts
     * given on the declaration's class (in the case of short
     * class declarations).
     * @attribute syn nta
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2682
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2682")
    public FArraySubscripts getFArraySubscripts() {
        ASTState state = state();
        if (getFArraySubscripts_computed) {
            return (FArraySubscripts) getChild(getFArraySubscriptsChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFArraySubscripts_value = getFArraySubscripts_compute();
        setChild(getFArraySubscripts_value, getFArraySubscriptsChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFArraySubscripts_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FArraySubscripts node = (FArraySubscripts) this.getChild(getFArraySubscriptsChildPosition());
        return node;
    }
    /** @apilevel internal */
    private FArraySubscripts getFArraySubscripts_compute() {
    	    if (myFSubscripts().isEmpty())
    	        return null;
            List<FSubscript> list = new List<FSubscript>();
            for (Subscript s : myFSubscripts()) { 
                list.add(s.deferredCopy());
            }
            return new FArrayExpSubscripts(list);
    	}
    /**
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2692
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2692")
    public boolean hasFArraySubscripts() {
        boolean hasFArraySubscripts_value = getFArraySubscripts()!=null;
        return hasFArraySubscripts_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2718
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2718")
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
    /** @apilevel internal */
    private void getAnnotationOpt_reset() {
        getAnnotationOpt_computed = false;
        
        getAnnotationOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getAnnotationOpt_computed = false;

    /** @apilevel internal */
    protected Opt<InstClassModification> getAnnotationOpt_value;

    /**
     * @attribute syn nta
     * @aspect InstanceAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2722
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2722")
    public Opt<InstClassModification> getAnnotationOpt() {
        ASTState state = state();
        if (getAnnotationOpt_computed) {
            return (Opt<InstClassModification>) getChild(getAnnotationOptChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getAnnotationOpt_value = new Opt<InstClassModification>();
        if(getAnnotationOpt_value.numChildren() <= 0) {
            getAnnotationOpt_value  = Opt.EMPTY;
        }

        setChild(getAnnotationOpt_value, getAnnotationOptChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getAnnotationOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        Opt<InstClassModification> node = (Opt<InstClassModification>) this.getChild(getAnnotationOptChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:114")
    public boolean isAssignable() {
        boolean isAssignable_value = false;
        return isAssignable_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:117
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:117")
    public boolean isRecord() {
        boolean isRecord_value = false;
        return isRecord_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192")
    public InstNode constrainingInstType() {
        { 
                InstComponentDecl forCmp = constrainingInstComponentDecl();
                InstNode forClass = forCmp.constrainingTypeOfMyClass();
                return (forClass != forCmp.myInstClass()) ? forClass : forCmp;
            }
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:209
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:209")
    public InstComponentDecl constrainingInstComponentDecl() {
        InstComponentDecl constrainingInstComponentDecl_value = hasInstConstrainingComponent() ? (InstComponentDecl) getInstConstrainingComponent().getInstNode() : this;
        return constrainingInstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:212")
    public InstNode constrainingTypeOfMyClass() {
        InstNode constrainingTypeOfMyClass_value = getClassName().constrainingTypeOfClass();
        return constrainingTypeOfMyClass_value;
    }
    /**
     * Check if two components are of types that can be connected.
     * @attribute syn
     * @aspect ConnectorTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:235
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConnectorTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:235")
    public boolean connectableTo(InstComponentDecl other) {
        boolean connectableTo_InstComponentDecl_value = other.connectableTypes(this) && typePrefixesMatch(other);
        return connectableTo_InstComponentDecl_value;
    }
    /**
     * Check if two components are of sizes that can be connected.
     * @attribute syn
     * @aspect ConnectorTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConnectorTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:241")
    public boolean connectableSizes(InstComponentDecl other) {
        boolean connectableSizes_InstComponentDecl_value = size().equivalent(other.size(), false);
        return connectableSizes_InstComponentDecl_value;
    }
    /**
     * Check if two components are of types that can be connected given that they have matching type prefixes.
     * @attribute syn
     * @aspect ConnectorTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:246
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConnectorTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:246")
    public boolean connectableTypes(InstComponentDecl other) {
        {
                // TODO: in array case, we should make sure that all connected elements match, since array elements can be of different structure
                if (isArray())
                    return getInstComponentDecl(0).connectableTypes(other);
                while (other.isArray())
                    other = other.getInstComponentDecl(0);
                Map<String,InstComponentDecl> componentMap = new HashMap<String,InstComponentDecl>();
                for (InstComponentDecl oicd : other.allInstComponentDecls())
                    if (!oicd.definedVariability().constantVariability())
                        componentMap.put(oicd.name(), oicd);
                boolean expandable = isExpandableConnector();
                for (InstComponentDecl icd : allInstComponentDecls()) {
                    if (!icd.definedVariability().constantVariability()) {
                        InstComponentDecl oicd = componentMap.remove(icd.name());
                        boolean match = oicd != null && icd.connectableTo(oicd) && icd.connectableSizes(oicd);
                        if (!match && (oicd != null || !expandable))
                            return false;
                    }
                }
                return other.isExpandableConnector() || componentMap.size() == 0;
            }
    }
    /**
     * Check if two components have type prefixes that are compatible for connecting.
     * @attribute syn
     * @aspect ConnectorTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:275
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConnectorTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:275")
    public boolean typePrefixesMatch(InstComponentDecl other) {
        boolean typePrefixesMatch_InstComponentDecl_value = (isDeclaredFlow() == other.isDeclaredFlow()) && (isStream() == other.isStream()) && (isParameter() == other.isParameter());
        return typePrefixesMatch_InstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:215
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:215")
    public SrcComponentClause myComponentClause() {
        SrcComponentClause myComponentClause_value = getSrcComponentDecl().myComponentClause();
        return myComponentClause_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:243
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:243")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = getSrcComponentDecl().myStringComment();
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
        AnnotationNode annotation_InstContext_value = mySrcAnnotatable().annotation(instContext);
        return annotation_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:208
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:208")
    public ArrayList<AnnotationNode> annotations() {
        {
                ArrayList<AnnotationNode> list = super.annotations();
                myInstClass().addAnnotationToEvaluator(list, this);
                return list;
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2111")
    public SrcAnnotatable orginalAnnotatable() {
        SrcAnnotatable orginalAnnotatable_value = getSrcComponentDecl();
        return orginalAnnotatable_value;
    }
    /**
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:390")
    public SrcAnnotationProvider srcAnnotationProvider() {
        SrcAnnotationProvider srcAnnotationProvider_value = getSrcComponentDecl().srcAnnotationProvider();
        return srcAnnotationProvider_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210")
    public boolean isPublic() {
        boolean isPublic_value = getSrcComponentDecl().isPublic();
        return isPublic_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1219
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1219")
    public boolean isProtected() {
        boolean isProtected_value = getSrcComponentDecl().isProtected();
        return isProtected_value;
    }
    /**
     * Check if this component is an input component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1319
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1319")
    public boolean isInput() {
        boolean isInput_value = isDeclaredInput() || inheritsInput() || (isDeclaredFlow() && !isOutput());
        return isInput_value;
    }
    /**
     * Check if this component inherits input from the surrounding component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1324")
    public boolean inheritsInput() {
        {
                InstComponentDecl source = inheritsInputOutputFrom();
                return source != null && source.isDeclaredInput();
            }
    }
    /**
     * Check if this component or its class is declared input.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1332
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1332")
    public boolean isDeclaredInput() {
        boolean isDeclaredInput_value = (isComponentDeclaredInput() || myInstClass().isInput()) && !inExpandableConnector();
        return isDeclaredInput_value;
    }
    /**
     * Check if this component is declared input.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1338")
    public boolean isComponentDeclaredInput() {
        boolean isComponentDeclaredInput_value = getSrcComponentDecl().isInput();
        return isComponentDeclaredInput_value;
    }
    /**
     * Check if this component is an output component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1360")
    public boolean isOutput() {
        boolean isOutput_value = (isDeclaredOutput() || inheritsOutput()) && !inExpandableConnector();
        return isOutput_value;
    }
    /**
     * Check if this component inherits output from the surrounding component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1366
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1366")
    public boolean inheritsOutput() {
        {
                InstComponentDecl source = inheritsInputOutputFrom();
                return source != null && source.isDeclaredOutput();
            }
    }
    /**
     * Check if this component is declared output.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1374")
    public boolean isDeclaredOutput() {
        boolean isDeclaredOutput_value = getSrcComponentDecl().isOutput() || myInstClass().isOutput();
        return isDeclaredOutput_value;
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
        boolean isTopLevelInputOutput_value = false;
        return isTopLevelInputOutput_value;
    }
    /**
     * Check if this component is a flow component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1428")
    public boolean isFlow() {
        boolean isFlow_value = isDeclaredFlow() || inheritsFlow();
        return isFlow_value;
    }
    /**
     * Check if this component inherits output from the surrounding component.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1433
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1433")
    public boolean inheritsFlow() {
        boolean inheritsFlow_value = inheritsFlowFrom() != null;
        return inheritsFlow_value;
    }
    /**
     * Check if this component is declared flow.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1447
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1447")
    public boolean isDeclaredFlow() {
        boolean isDeclaredFlow_value = getSrcComponentDecl().isFlow();
        return isDeclaredFlow_value;
    }
    /**
     * Check if this component is declared stream.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1458
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1458")
    public boolean isStream() {
        boolean isStream_value = getSrcComponentDecl().isStream();
        return isStream_value;
    }
    /**
     * Check if this component is declared inner.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1469
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1469")
    public boolean isInner() {
        boolean isInner_value = getSrcComponentDecl().isInner() || isGeneratedInner();
        return isInner_value;
    }
    /**
     * Check if this component is declared outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1480
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1480")
    public boolean isOuter() {
        boolean isOuter_value = getSrcComponentDecl().isOuter() && !isGeneratedInner();
        return isOuter_value;
    }
    /**
     * Check if this component is disabled by a conditional clause
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1513
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1513")
    public boolean isDisabled() {
        {
                if (hasConditionalAttribute()) {
                    try {
                        CValue cval = getConditionalAttribute().ceval();
                        return cval.hasBooleanValue() && !cval.booleanValue();
                    } catch (ConstantEvaluationException e) {}
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1624
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1624")
    public InstCallable asCallable() {
        InstCallable asCallable_value = null;
        return asCallable_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1669
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1669")
    public boolean isEnumLiteral() {
        boolean isEnumLiteral_value = false;
        return isEnumLiteral_value;
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
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:266")
    public ExternalArgument externalArgument(FExp exp) {
        ExternalArgument externalArgument_FExp_value = variability().constantVariability() ? exp : this;
        return externalArgument_FExp_value;
    }
    /**
     * Find the declared size for a component that does not have any array subscripts in the declaration. 
     * For all components except the NTA of InstComponentRedeclare, this is simply scalar.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1142
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1142")
    public Size defaultSize() {
        Size defaultSize_value = getParent().Define_defaultSize(this, null);
        return defaultSize_value;
    }
    /**
     * Find the declared calculated size for a component that does not have any array subscripts in the declaration. 
     * For all components except the NTA of InstComponentRedeclare, this is simply scalar.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1150")
    public Size defaultSizeCalc() {
        Size defaultSizeCalc_value = getParent().Define_defaultSizeCalc(this, null);
        return defaultSizeCalc_value;
    }
    /**
     * Check if there is a parent record that has a binding expression.
     * @attribute inh
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2744
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2744")
    public boolean hasParentRecordWithBindingExp() {
        boolean hasParentRecordWithBindingExp_value = getParent().Define_hasParentRecordWithBindingExp(this, null);
        return hasParentRecordWithBindingExp_value;
    }
    /**
     * Perform constant evaluation of a record member.
     * @attribute inh
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2762
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2762")
    public CValue cevalParentRecord(VariableEvaluator evaluator) {
        CValue cevalParentRecord_VariableEvaluator_value = getParent().Define_cevalParentRecord(this, null, evaluator);
        return cevalParentRecord_VariableEvaluator_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3158
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3158")
    public boolean inRecordConstructor() {
        boolean inRecordConstructor_value = getParent().Define_inRecordConstructor(this, null);
        return inRecordConstructor_value;
    }
    /**
     * @attribute inh
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170")
    public boolean isForIndex() {
        boolean isForIndex_value = getParent().Define_isForIndex(this, null);
        return isForIndex_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:433
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:433")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * Check if <code>icd</code> is an ancestor of this node or any ancestor is an 
     * instance of <code>icd</code>.
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1571
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1571")
    public boolean isWithin(InstClassDecl icd) {
        boolean isWithin_InstClassDecl_value = getParent().Define_isWithin(this, null, icd);
        return isWithin_InstClassDecl_value;
    }
    /**
     * The node containing the scope in which two components with identical names 
     * constitute a collision, even if the components are also identical.
     * @attribute inh
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="DuplicateComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:178")
    public ASTNode nameCollisionScope() {
        ASTNode nameCollisionScope_value = getParent().Define_nameCollisionScope(this, null);
        return nameCollisionScope_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:304
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:304")
    public boolean inRecordWithBindingExp() {
        boolean inRecordWithBindingExp_value = getParent().Define_inRecordWithBindingExp(this, null);
        return inRecordWithBindingExp_value;
    }
    /**
     * Find the flow variable corresponding to this stream variable.
     * 
     * Only valid for stream variables.
     * @attribute inh
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:624
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:624")
    public InstComponentDecl myFlowVar() {
        InstComponentDecl myFlowVar_value = getParent().Define_myFlowVar(this, null);
        return myFlowVar_value;
    }
    /**
     * @attribute inh
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1266")
    public InstComponentDecl findCellUp(Index i, int j, InstComponentDecl src) {
        InstComponentDecl findCellUp_Index_int_InstComponentDecl_value = getParent().Define_findCellUp(this, null, i, j, src);
        return findCellUp_Index_int_InstComponentDecl_value;
    }
    /**
     * Find the closest ancestor component that is an expandable connector, if any.
     * @attribute inh
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3010
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3010")
    public InstComponentDecl findExpandableAncestor() {
        InstComponentDecl findExpandableAncestor_value = getParent().Define_findExpandableAncestor(this, null);
        return findExpandableAncestor_value;
    }
    /**
     * Find the ancestor component that is a direct child of the given component.
     * 
     * @param a  the ancestor to find child of
     * @param c  the child being considered, always use <code>this</code>
     * @attribute inh
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3023
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3023")
    public InstComponentDecl ancestorChild(InstComponentDecl a, InstComponentDecl c) {
        InstComponentDecl ancestorChild_InstComponentDecl_InstComponentDecl_value = getParent().Define_ancestorChild(this, null, a, c);
        return ancestorChild_InstComponentDecl_InstComponentDecl_value;
    }
    /**
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952")
    public FAccess expandedFAccess() {
        FAccess expandedFAccess_value = getParent().Define_expandedFAccess(this, null);
        return expandedFAccess_value;
    }
    /**
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1784")
    public FExp parentBindingFExp() {
        FExp parentBindingFExp_value = getParent().Define_parentBindingFExp(this, null);
        return parentBindingFExp_value;
    }
    /**
     * Retrieve the InstModification setting the binding expression of 
     * the parent component. 
     * 
     * If the parent component is not an assignable, or is an assignable that does 
     * not have a binding expression, return <code>null</code>.
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057")
    public InstValueModification parentInstValueMod() {
        InstValueModification parentInstValueMod_value = getParent().Define_parentInstValueMod(this, null);
        return parentInstValueMod_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:33
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:33")
    public InstComponentDecl surroundingOuterComponentDecl() {
        InstComponentDecl surroundingOuterComponentDecl_value = getParent().Define_surroundingOuterComponentDecl(this, null);
        return surroundingOuterComponentDecl_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111")
    public boolean isGeneratedInner() {
        boolean isGeneratedInner_value = getParent().Define_isGeneratedInner(this, null);
        return isGeneratedInner_value;
    }
    /**
     * @attribute inh
     * @aspect InstModificationType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:775
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstModificationType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:775")
    public boolean inheritsFinal() {
        boolean inheritsFinal_value = getParent().Define_inheritsFinal(this, null);
        return inheritsFinal_value;
    }
    /**
     * @attribute inh
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:138")
    public AnnotationNode parentEvalAnnotation() {
        AnnotationNode parentEvalAnnotation_value = getParent().Define_parentEvalAnnotation(this, null);
        return parentEvalAnnotation_value;
    }
    /**
     * The variability of the surrounding component, if any (null otherwise).
     * @attribute inh
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:219
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:219")
    public TypePrefixVariability parentDefaultVariability() {
        TypePrefixVariability parentDefaultVariability_value = getParent().Define_parentDefaultVariability(this, null);
        return parentDefaultVariability_value;
    }
    /**
     * @attribute inh
     * @aspect ExpandableConnectorMembers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1809
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectorMembers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1809")
    public boolean isExpandableConnectorMember() {
        boolean isExpandableConnectorMember_value = getParent().Define_isExpandableConnectorMember(this, null);
        return isExpandableConnectorMember_value;
    }
    /**
     * @attribute inh
     * @aspect ExpandableConnectorMembers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1815
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectorMembers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1815")
    public boolean inExpandableConnector() {
        boolean inExpandableConnector_value = getParent().Define_inExpandableConnector(this, null);
        return inExpandableConnector_value;
    }
    /**
     * @attribute inh
     * @aspect ExpandableConnectorMembers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1822
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectorMembers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1822")
    public InstComponentDecl myExpandableConnectorTemplate() {
        InstComponentDecl myExpandableConnectorTemplate_value = getParent().Define_myExpandableConnectorTemplate(this, null);
        return myExpandableConnectorTemplate_value;
    }
    /**
     * For internal use only - returns an incomplete Index. See {@link #myTotalIndex()}.
     * @attribute inh
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2607
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2607")
    public Index parentTotalIndex() {
        Index parentTotalIndex_value = getParent().Define_parentTotalIndex(this, null);
        return parentTotalIndex_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:905
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:905")
    public InstComponentDecl enclosingInstComponentDecl() {
        InstComponentDecl enclosingInstComponentDecl_value = getParent().Define_enclosingInstComponentDecl(this, null);
        return enclosingInstComponentDecl_value;
    }
    /**
     * Find the component that this component inherits input or output from, if any.
     * @attribute inh
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1390")
    public InstComponentDecl inheritsInputOutputFrom() {
        InstComponentDecl inheritsInputOutputFrom_value = getParent().Define_inheritsInputOutputFrom(this, null);
        return inheritsInputOutputFrom_value;
    }
    /**
     * @attribute inh
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1407
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1407")
    public boolean isTopLevel() {
        boolean isTopLevel_value = getParent().Define_isTopLevel(this, null);
        return isTopLevel_value;
    }
    /**
     * Find the component that this component inherits input or output from, if any.
     * @attribute inh
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1438
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1438")
    public InstComponentDecl inheritsFlowFrom() {
        InstComponentDecl inheritsFlowFrom_value = getParent().Define_inheritsFlowFrom(this, null);
        return inheritsFlowFrom_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     */
    public CommonVariableDecl Define_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFArraySubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:693
            return this;
        }
        else {
            return getParent().Define_surroundingVariableDecl(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingVariableDecl
     */
    protected boolean canDefine_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:32
     * @apilevel internal
     */
    public boolean Define_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLocalFArraySubscriptsOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:38
            return false;
        }
        else if (_callerNode == getFArraySubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:37
            return false;
        }
        else {
            return getParent().Define_inSubscriptedExp(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:32
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inSubscriptedExp
     */
    protected boolean canDefine_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:841
     * @apilevel internal
     */
    public InstClassDecl Define_myOperatorRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
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
        return isDisabled() || lockBranch(checkType);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:498
     * @apilevel internal
     */
    public InstComponentDecl Define_myTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:498
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTargetComponent
     */
    protected boolean canDefine_myTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:580
     * @apilevel internal
     */
    public InstComponentDecl Define_errorEnclosingComponent(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:589
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return this;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            {
                    if (isRedeclared() || getSrcComponentDecl().hasRedeclare()) {
                        return errorEnclosingComponent();
                    } else {
                        return containingInstComponent();
                    }
                }
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:580
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute errorEnclosingComponent
     */
    protected boolean canDefine_errorEnclosingComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668
     * @apilevel internal
     */
    public boolean Define_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
        return isOfInstClassDecl(icd) || isWithin(icd);
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
        if (_callerNode == getAnnotationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:299
            return getAnnotation();
        }
        else if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:298
            return getInstModification();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1112
     * @apilevel internal
     */
    public boolean Define_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFArraySubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1117
            return true;
        }
        else if (_callerNode == getLocalFArraySubscriptsOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1116
            return true;
        }
        else {
            return super.Define_isInstComponentSize(_callerNode, _childNode);
        }
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
        {
                if (j > 0) {
                    if (isArray()) {
                        return findCellUp(i, j - 1, this).getInstComponentDecl(i.get(j - 1) - 1);
                    } else {
                        return findCellUp(i, j, this).memberInstComponent(src.name()).target();
                    }
                }
                return src;
            }
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
        return (isExpandableConnector() && !isArray()) ? this : findExpandableAncestor();
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
        return (this == a) ? c : ancestorChild(a, this);
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
        return expandedFAccess();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2057
     * @apilevel internal
     */
    public InstValueModification Define_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInstValueMod();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     * @apilevel internal
     */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:199
            return retrieveFAccess();
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return getFAccess();
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:21
     * @apilevel internal
     */
    public boolean Define_inOuter(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return inOrIsOuter();
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
        return inOrIsInner();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:33
     * @apilevel internal
     */
    public InstComponentDecl Define_surroundingOuterComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isOuter() ? this : surroundingOuterComponentDecl();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:33
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingOuterComponentDecl
     */
    protected boolean canDefine_surroundingOuterComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:146
     * @apilevel internal
     */
    public InstClassDecl Define_lookupInInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInnerInstComponentDecl().memberInstClass(name).targetOrNull();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:47
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return superLookupInstClassInComponent(name);
        }
        else {
            return super.Define_lookupInstClass(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClass
     */
    protected boolean canDefine_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:68
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassFromMod(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:70
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else {
            return super.Define_lookupInstClassFromMod(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:68
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassFromMod
     */
    protected boolean canDefine_lookupInstClassFromMod(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:162
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInstClass().lookupRedeclareExtendsInstClassFromComponent(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:162
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupRedeclareExtendsInstClass
     */
    protected boolean canDefine_lookupRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:646
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:649
            return memberInstClass(name);
        }
        else {
            return getParent().Define_lookupInstClassInInstElement(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:646
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassInInstElement
     */
    protected boolean canDefine_lookupInstClassInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getLocalFArraySubscriptsOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:329
            return lookupInstComponent(name);
        }
        else if (_callerNode == getFArraySubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:328
            return lookupInstComponent(name);
        }
        else if (_callerNode == getConditionalAttributeOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:327
            return lookupInstComponent(name);
        }
        else if (_callerNode == getInstConstrainingComponentOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:326
            return lookupInstComponent(name);
        }
        else if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:325
            return lookupInstComponent(name);
        }
        else {
            return super.Define_lookupInstComponent(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponent
     */
    protected boolean canDefine_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:755
            return memberInstComponent(name).unresolved();
        }
        else {
            return super.Define_lookupInstComponentInInstElement(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponentInInstElement
     */
    protected boolean canDefine_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getConditionalAttributeOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:115
            return Kind.AMBIGUOUS_ACCESS;
        }
        else if (_callerNode == getClassNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:108
            return Kind.CLASS_ACCESS;
        }
        else {
            return getParent().Define_kind(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute kind
     */
    protected boolean canDefine_kind(ASTNode _callerNode, ASTNode _childNode) {
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
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:421
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:774
     * @apilevel internal
     */
    public boolean Define_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getSrcComponentDecl().hasFinal() || inheritsFinal();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:774
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsFinal
     */
    protected boolean canDefine_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36
     * @apilevel internal
     */
    public TypePrefixVariability Define_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return definedVariability();
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
        return variability();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:534
     * @apilevel internal
     */
    public Environment Define_myEnvironmentNoClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return filteredEnvironment().mergeInnerClone(getElementInstModifications(), localInstModificationsNoClass());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:534
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironmentNoClass
     */
    protected boolean canDefine_myEnvironmentNoClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:535
     * @apilevel internal
     */
    public Environment Define_myEnvironmentClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new Environment(localInstModificationsClass());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:535
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironmentClass
     */
    protected boolean canDefine_myEnvironmentClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstConstrainingComponentOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:580
            return getMergedEnvironment().clone();
        }
        else {
            return super.Define_myEnvironment(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:759
     * @apilevel internal
     */
    public InstNode Define_myInstNode(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isExpandableConnectorMember() ? myExpandableConnectorTemplate() : this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:759
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstNode
     */
    protected boolean canDefine_myInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1992
     * @apilevel internal
     */
    public String Define_instClassNamePrefix(ASTNode _callerNode, ASTNode _childNode, boolean sup) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return buildQualifiedName();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1992
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instClassNamePrefix
     */
    protected boolean canDefine_instClassNamePrefix(ASTNode _callerNode, ASTNode _childNode, boolean sup) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2198
     * @apilevel internal
     */
    public boolean Define_isInComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2198
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInComponentDecl
     */
    protected boolean canDefine_isInComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2286
     * @apilevel internal
     */
    public InstComponentDecl Define_containingInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFArraySubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2290
            return containingInstComponent();
        }
        else if (_callerNode == getLocalFArraySubscriptsOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2288
            return containingInstComponent();
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return this;
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2571
     * @apilevel internal
     */
    public int Define_dimensionLength(ASTNode _callerNode, ASTNode _childNode, int i) {
        if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2573
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return size().get(i);
        }
        else {
            return getParent().Define_dimensionLength(this, _callerNode, i);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2571
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute dimensionLength
     */
    protected boolean canDefine_dimensionLength(ASTNode _callerNode, ASTNode _childNode, int i) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2593
     * @apilevel internal
     */
    public Index Define_parentIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new Index(new int[ndims()]);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2593
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentIndex
     */
    protected boolean canDefine_parentIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2607
     * @apilevel internal
     */
    public Index Define_parentTotalIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return parentTotalIndex();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2607
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentTotalIndex
     */
    protected boolean canDefine_parentTotalIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2615
     * @apilevel internal
     */
    public InstComponentDecl Define_instComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2615
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instComponentDecl
     */
    protected boolean canDefine_instComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001
     * @apilevel internal
     */
    public SrcAnnotatable Define_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getSrcComponentDecl();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2797
     * @apilevel internal
     */
    public String Define_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:826
            return buildInstanceName(surroundingInstClass(), getFAccessPrefix());
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return buildInstanceName(surroundingInstClass(), getFAccess());
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:899
     * @apilevel internal
     */
    public InstClassDecl Define_enclosingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInstClass();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:899
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstClassDecl
     */
    protected boolean canDefine_enclosingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:906
     * @apilevel internal
     */
    public InstComponentDecl Define_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:906
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstComponentDecl
     */
    protected boolean canDefine_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     * @apilevel internal
     */
    public boolean Define_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isProtected() || inProtectedComponent();
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
        {
                return (isDeclaredInput() || isDeclaredOutput()) ? this : inheritsInputOutputFrom();
            }
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
        return (isAssignable() || isConnector()) && isTopLevel();
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
        return isDeclaredFlow() ? this : inheritsFlowFrom();
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
        return isDisabled() || inDisabledComponent();
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
