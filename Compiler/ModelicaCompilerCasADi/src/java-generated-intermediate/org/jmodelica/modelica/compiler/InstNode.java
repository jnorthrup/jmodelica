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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:17
 * @astdecl InstNode : BaseNode ::= InstComponentDecl* InstClassDecl* InstExtends* InstImport* RedeclaredInstClassDecl:InstClassDecl* FAbstractEquation* ElementInstModification:InstModification* AnnotationExp:FExp*;
 * @production InstNode : {@link BaseNode} ::= <span class="component">{@link InstComponentDecl}*</span> <span class="component">{@link InstClassDecl}*</span> <span class="component">{@link InstExtends}*</span> <span class="component">{@link InstImport}*</span> <span class="component">RedeclaredInstClassDecl:{@link InstClassDecl}*</span> <span class="component">{@link FAbstractEquation}*</span> <span class="component">ElementInstModification:{@link InstModification}*</span> <span class="component">AnnotationExp:{@link FExp}*</span>;

 */
public abstract class InstNode extends BaseNode implements Cloneable, InstLookupRedirectNode, AllInstComponentSource, AllInstClassSource, InstContext {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3757
     */
    public Map<CommonVariableDecl, CValue> getCurrentEvaluationValues() { return null; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3758
     */
    public void setCurrentEvaluationValues(Map<CommonVariableDecl, CValue> values) {}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:331
     */
    public void checkContentsOKInExternalObject() {
		for (InstExtends ie : getInstExtendss())
			ie.checkContentsOKInExternalObject();
		boolean ok = true;
		for (InstClassDecl icd : getInstClassDecls())
			if (!icd.name().equals("constructor") && !icd.name().equals("destructor"))
				ok = false;
		if (getNumInstComponentDecl() > 0)
			ok = false;
		if (getNumRedeclaredInstClassDecl() > 0)
			ok = false;
		if (getNumFAbstractEquation() > 0)
			ok = false;
		if (!ok)
			error("External object classes may not contain any elements except the constructor and destructor");
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:641
     */
    public void resetCollectErrors() {
		super.resetCollectErrors();
		resetCollectErrorsOn(getInstComponentDeclListNoTransform());
		resetCollectErrorsOn(getInstClassDeclListNoTransform());
		resetCollectErrorsOn(getInstExtendsListNoTransform());
		resetCollectErrorsOn(getInstImportListNoTransform());
		resetCollectErrorsOn(getRedeclaredInstClassDeclListNoTransform());
		resetCollectErrorsOn(getFAbstractEquationListNoTransform());
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:651
     */
    public void collectErrors(ErrorCheckType checkType) {
    if (!errorChecked) {
      errorChecked = true;
	  allChecks(checkType);
	  for (InstNode n : getInstComponentDecls()) 
		  n.collectErrors(checkType);
	  for (InstNode n : getInstExtendss()) 
		  n.collectErrors(checkType);
	  for (FAbstractEquation e : getFAbstractEquations()) 
		  e.collectErrors(checkType);
	}
  }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1090
     */
    public void checkRedeclares(ErrorCheckType checkType) {
	    if (!errorChecked) {
	        for (InstNode n : getInstComponentDecls()) 
	            n.checkRedeclares(checkType);
	        for (InstNode n : getInstExtendss()) 
	            n.checkRedeclares(checkType);
	      }
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1563
     */
    protected static final byte RECURSIVE_UNKNOWN = 0;
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1564
     */
    protected static final byte RECURSIVE_YES     = 1;
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1565
     */
    protected static final byte RECURSIVE_NO      = 2;
    /**
     * Find all duplicates among child components.
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:157
     */
    public void calculateDuplicates() {
        Map<String,InstComponentDecl> map = new HashMap<String,InstComponentDecl>();
        for (InstComponentDecl comp : allInstComponentDeclsWithDuplicates()) 
            comp.calculateDuplicate(map);
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1301
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
		prefix = getFAccess();
		for (FAbstractEquation ae : getFAbstractEquations()) 
		   ae.buildConnectionSets(prefix, csm, connect);
		getInstComponentDeclList().buildConnectionSets(prefix, csm, connect);
		getInstExtendsList().buildConnectionSets(prefix, csm, connect);
	}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:310
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        getInstComponentDeclList().flattenUsedFuncsAndEnums(f);
        getFAbstractEquationList().flattenUsedFuncsAndEnums(f);
        getInstExtendsList().flattenUsedFuncsAndEnums(f);
        for (InstModification im : totalMergedEnvironment()) 
            im.flattenUsedFuncsAndEnums(f);
        super.flattenUsedFuncsAndEnums(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:347
     */
    public void flattenOverloadedOperatorsForFlow(Flattener f) {
        for (InstComponentDecl icd : getInstComponentDecls())
            icd.flattenOverloadedOperatorsForFlow(f);
        for (InstExtends ie : getInstExtendss())
            ie.flattenOverloadedOperatorsForFlow(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:450
     */
    public void flattenStateSelect(Flattener f) {
        lookupInstClass("StateSelect").target().flattenEnum(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:539
     */
    public static final int FUNC_AND_REC_MOD_LEVEL = 1000;
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:668
     */
    public void flattenComponentsInFunction(Flattener f, List<FFunctionVariable> vars, List<FStatement> stmts,
            Set<String> added, int level) {
        HashMap<InstNode,Integer> oldLevels = setModificationLevel(level);
        for (InstExtends ie : getInstExtendss()) {
            ie.flattenComponentsInFunction(f, vars, stmts, added, level + 1);
        }
        for (InstComponentDecl icd : getInstComponentDecls()) {
            if (added.add(icd.name())) {
                HashMap<InstNode,Integer> oldLevels2 = icd.setModificationLevel(level + 1);
                icd.flattenInFunction(f, vars, stmts);
                icd.flattenUsedFuncsAndEnums(f);
                icd.clearModificationLevel(oldLevels2);
            }
        }
        clearModificationLevel(oldLevels);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:731
     */
    public void flattenThisRecord(Flattener f) {
        String name = qualifiedTypeName();
        if (!f.isFlattened(this)) {
            FRecordDecl frd = new FRecordDecl();
            frd.setFAccess(new FAccessString(name));
            
            Set<String> names = new HashSet<String>();
            flattenComponentsInRecord(f, frd, names, FUNC_AND_REC_MOD_LEVEL);
            
            f.addFRecordDecl(frd);
            
            flattenUsedFuncsAndEnums(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:746
     */
    public void flattenComponentsInRecord(Flattener f, FRecordDecl frd, Set<String> names, int level) {
        HashMap<InstNode,Integer> oldLevels = setModificationLevel(level);
        for (InstExtends ie : getInstExtendss())
            ie.flattenComponentsInRecord(f, frd, names, level + 1);
        for (InstComponentDecl icd : getInstComponentDecls()) {
            HashMap<InstNode,Integer> oldLevels2 = icd.setModificationLevel(level + 1);
            icd.flattenInRecord(f, frd, names);
            icd.clearModificationLevel(oldLevels2);
        }
        clearModificationLevel(oldLevels);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1145
     */
    public void flatten(Flattener f, FlattenBindingExp binding, int level) {
        HashMap<InstNode,Integer> oldLevels = setModificationLevel(level);
        flattenEquations(f);
        getInstComponentDeclList().flatten(f, binding, level + 1);
        getInstExtendsList().flatten(f, binding, level + 1);
        f.contribute(this);
        clearModificationLevel(oldLevels);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1154
     */
    public void flattenEquations(Flattener f) {
        for (FAbstractEquation ae : getFAbstractEquations()) 
            ae.flatten(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1388
     */
    public static boolean containsRedeclared(InstNode in) {
        for (InstComponentDecl icd : in.getInstComponentDecls()) {
            if (icd.containsRedeclared()) {
                return true;
            }
        }
        for (InstClassDecl icd : in.getInstClassDecls()) {
            if (icd.containsRedeclared()) {
                return true;
            }
        }
        return false;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1565
     */
    public void addAttributes(Flattener f, List<FAttribute> attr, Environment env) {
        addAttributes(f, attr, env, AttributeExpRetriever.DEFAULT, true);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1569
     */
    public void addAttributes(Flattener f,
            List<FAttribute> attr, Environment env, AttributeExpRetriever aer, boolean cls) {
        for (InstModification im : env) 
            im.collectAttributes(f, attr, aer, cls);
    }
    /**
     * Set the modification level for contained modifications.
     * 
     * @throws IllegalArgumentException  if level is negative
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2185
     */
    public HashMap<InstNode,Integer> setModificationLevel(int level) {
        HashMap<InstNode,Integer> old = new HashMap<InstNode,Integer>();
        setModificationLevelHelper(old, level);
        return old;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2191
     */
    public void setModificationLevelHelper(HashMap<InstNode,Integer> old, int level) {
        myModificationLevel = level;
        old.put(this, myModificationLevel);
        for (InstNode extra : extraNodesToSetModLevelFor()) {
            if (extra != null && !old.containsKey(extra)) {
                extra.setModificationLevelHelper(old, extra.nextModLevelForExtraNode(level));
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2201
     */
    public void clearModificationLevel(HashMap<InstNode,Integer> old) {
        for (InstNode n : old.keySet()) {
            n.myModificationLevel = old.get(n);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2237
     */
    protected InstNode[] listExtraNodesToSetModLevelFor(boolean ext, InstNode... nodes) {
        InstNode[] res = new InstNode[nodes.length + (ext ? getNumInstExtends() : 0) + 1];
        System.arraycopy(nodes, 0, res, 0, nodes.length);
        for (int i = nodes.length; i < res.length - 1; i++) {
            res[i] = getInstExtends(i - nodes.length);
        }
        res[res.length - 1] = parentNodeToSetModLevelFor();
        return res;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2247
     */
    private int myModificationLevel = Integer.MAX_VALUE;
    /**
     * @aspect AttributeContributer
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3482
     */
    
        public FClass contribute(FClass fClass) {
            for (AttributeContributer contributer : attributeContributers())
                contributer.contribute(this, fClass);
            return fClass;
        }
    /**
     * If icd is in an outer component, try to find corresponding class in inner decl.
     * 
     * If inner decl isn't found, return icd to avoid extra error messages.
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:554
     */
    public InstClassDecl findInnerClassIfAny(InstClassDecl icd) {
        if (icd.inOrIsOuter()) {
            InstClassDecl inner = icd.myInnerInstClassDecl();
            if (inner != null) 
                icd = inner;
        }
        return icd;
    }
    /**
     * @aspect SimpleInstClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:669
     */
    public InstClassDecl simpleLookupInstClassDeclRecursive(String name) {
        String[] parts = name.split("\\.", 2);
        InstClassDecl icd = findMatching(getInstClassDecls(), parts[0]);
        if (icd != null)
            return icd = (parts.length == 1) ? icd : icd.actualInstClass().simpleLookupInstClassDeclRecursive(parts[1]);
        else
            return unknownInstClassDecl();
    }
    /**
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:626
     */
    public InstLookupResult findInnerComponentIfAny(InstComponentDecl icd) {
        if (icd.isOuter()) {
            return InstLookupResult.outer(icd);
        }
        return InstLookupResult.found(icd);
    }
    /**
     * Dynamically places an FExp in the tree under this InstNode.
     * 
     * @return  the final version of the dynamically placed node.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:862
     */
    public FExp dynamicFExp(FExp exp) {
		getDynamicFExpOpt().setChild(exp, 0);
		return (FExp) getDynamicFExpOpt().getChild(0);
	}
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:867
     */
    public void clearDynamicFExp() {
       getDynamicFExpOpt().setChild(null, 0);
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1086
     */
    public InstComponentDecl createInstComponentDecl(SrcComponentDecl cd) {
        // Check if the component is redeclared. 
        // -> Yes: Create an InstReplacingComponent component
        // -> No: Create an InstComponent 
        InstComponentRedeclare irc = retrieveReplacingComponent(cd.name());
        InstComponentRedeclare cicr = retrieveConstrainingComponent(cd.name());
        if (irc!=null) {
            SrcComponentDecl replacingComp = irc.getComponentRedeclareDecl();
            return new InstCreateReplacingComponentDecl(replacingComp, irc, cd, irc, cicr);
            // TODO: handle expandable connectors in this case
        } else { 
            return new InstCreateComponentDecl(cd, null);
        }
     }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1115
     */
    public InstClassDecl createInstClassDecl(SrcClassDecl bcd) {
         // Check if the class is redeclared. 
         // -> Yes: Create an InstReplacingClass component
         // -> No: Create an InstClassDecl
         InstRedeclareClassNode icr = retrieveReplacingClass(bcd.name());
         InstRedeclareClassNode cicr = retrieveConstrainingClass(bcd.name());
         if (icr != null) {
             SrcClassDecl replacingClass = icr.redeclaringClassDecl();
             return bcd.newInstReplacingClass(replacingClass, icr, cicr);
         } else {
             return bcd.newInstClassDecl();
         }
     }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1146
     */
    public InstNode createInstExtends(SrcExtendsClause ec, InstNode lookup) {
        // This cannot be redeclared. Just create and return.
        return ec.newInstExtends(lookup);
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1167
     */
    public InstNode createInstExtendsCheckReplacing(SrcExtendsClause ec, InstNode lookup) {
        if (!isInInstModification() && ec.needsReplacingExtends()) {
            Environment e = myEnvironment();
            InstModification im = findMatching(e, name());
            if (im != null)
                return im.createInstReplacingExtends(ec, lookup);
        }
        return ec.newInstExtends(lookup);
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1201
     */
    public InstExtends createInstReplacingExtends(SrcExtendsClause ec, InstNode lookup) {
        return ec.newInstExtends(lookup);
    }
    /**
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1874
     */
    public List buildFAbstractEquationList() { 
    List l = new List();
	    for (SrcAbstractEquation e : equations()) {
	        l.add(e.instantiate());
	    }
	    for (SrcAlgorithm a : algorithms()) {
	        l.add(a.instantiate());
	    }
	    for (FAlgorithm a : fAlgorithms()) {
	        l.add(a.fullCopy());
	    }
	    return l;
	}
    /**
     * Iterate over all components in this node and all InstExtends (recursively).
     * Filters out any duplicate components.
     * 
     * @return  an Iterable over the components
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2304
     */
    public Iterable<InstComponentDecl> allInstComponentDecls() {
        return new FilteredIterable(allInstComponentDeclsWithDuplicates(), NO_DUPLICATE);
    }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2318
     */
    public static final Criteria<InstComponentDecl> NO_DUPLICATE = new Criteria<InstComponentDecl>() {
        public boolean test(InstComponentDecl elem) {
            return !elem.isDuplicate();
        }
    };
    /**
     * Iterate over all components in this node and all InstExtends (recursively).
     * Includes any duplicate components.
     * 
     * @return  an Iterable over the components
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2330
     */
    public Iterable<InstComponentDecl> allInstComponentDeclsWithDuplicates() {
        return new AllInstComponentIterable(this);
    }
    /**
     * Iterate over all classes in this node and all InstExtends (recursively).
     * 
     * @return  an Iterable over the classes
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2342
     */
    public Iterable<InstClassDecl> allInstClassDecls() {
        return new AllInstClassIterable(this);
    }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2349
     */
    protected Iterator<InstComponentDecl> allInstComponentDeclsIterator() {
        return new AllInstComponentIterator(this);
    }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2356
     */
    protected Iterator<InstClassDecl> allInstClassDeclsIterator() {
        return new AllInstClassIterator(this);
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:69
     */
    public static String subTypeMessage(String name, String message) {
        if (name == null) {
            return "they " + message;
        } else {
            return "their instances of " + name + " " + message;
        }
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:77
     */
    public static String compareTypes(
            InstNode superType, InstNode subType, String name, 
            boolean related, boolean primitive, boolean top) {
        if (related) {
            if (primitive) {
                return comparePrimitiveTypes(superType, subType, name, top);
            } else {
                return compareCompositeTypes(superType, subType, name, top);
            }
        } else {
            return subTypeMessage(name, "are of unrelated types");
        }
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:91
     */
    public static String comparePrimitiveTypes(
            InstNode superType, InstNode subType, String name, boolean top) {
        if (subType == superType) {
            return null;
        } else if (!subType.baseClassName().equals(superType.baseClassName())) {
            return subTypeMessage(name, "are of different primitive types");
        } else if (subType.ndims() == superType.ndims() || 
                   top && subType.ndims() == 0 || 
                   superType.isClassDecl() && subType.ndims() > superType.ndims()) {
            return null;
        } else {
            return subTypeMessage(name, "have incompatible number of dimensions");
        }
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:106
     */
    public static String compareCompositeTypes(
            InstNode superType, InstNode subType, String name, boolean top) {
        if (subType == superType || subType.myInstClass().isUnknown()) 
            return null;
        
        if (superType.isArray() != subType.isArray()) {
            if (top && superType.isArray()) {
                superType = superType.getInstComponentDecl(0);
            } else if (superType.isClassDecl() || subType.isClassDecl()) {
                if (superType.isClassDecl()) {
                    subType = subType.getInstComponentDecl(0);
                } else {
                    superType = superType.getInstComponentDecl(0);
                }
            } else {
                return subTypeMessage(name, "have incompatible number of dimensions");
            }
        }
        
        if (superType.isArray()) {
            List<InstComponentDecl> superComponents = superType.getInstComponentDecls();
            List<InstComponentDecl> subComponents = subType.getInstComponentDecls();
            int n = Math.min(superComponents.getNumChild(), subComponents.getNumChild());
            for (int i = 0; i < n; i++) {
                InstComponentDecl superChild = superComponents.getChild(i);
                InstComponentDecl subChild = subComponents.getChild(i);
                String res = subChild.subType(superChild, subTypeComponentName(name, superChild), false);
                if (res != null) {
                    return res;
                }
            }
        } else {
            for (InstComponentDecl superChild : superType.containedInstComponents()) {
                InstComponentDecl subChild = subType.memberInstComponent(superChild.name()).targetOrNull();
                String subName = subTypeComponentName(name, superChild);
                if (subChild == null) {
                    return subName + " from the constraining type is missing";
                } else {
                    String res = subChild.subType(superChild.constrainingInstType(), subName, false);
                    if (res != null) {
                        return res;
                    }
                }
            }
        }
        return null;
    }
    /**
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:154
     */
    private static String subTypeComponentName(String name, InstComponentDecl component) {
        if (name != null) {
            if (component.isArrayChild()) {
                InstArrayComponentDecl arrComp = (InstArrayComponentDecl) component;
                if (arrComp.isBottomDimension()) {
                    return name + arrComp.myIndex();
                } else {
                    return name;
                }
            } else {
                return name + '.' + component.name();
            }
        } else {
            if (component.isArrayChild()) {
                return null;
            } else {
                return component.name();
            }
        }
    }
    /**
     * Evaluate exp in the scope of this node.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:113
     */
    public CValue ceval(SrcExp exp) {
        return annotationExp(exp).ceval();
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:116
     */
    public CValue ceval(SrcExp exp, VariableEvaluator evaluator) {
        return annotationExp(exp).ceval(evaluator);
    }
    /**
     * If exp is an access, try to look it up as a class in the scope of this node, 
     * otherwise return null.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:131
     */
    public InstLookupResult<InstClassDecl> lookupInstClass(SrcExp exp) {
        return annotationExp(exp).lookupInstClassIfAccess();
    }
    /**
     * If exp is an access, try to look it up as a component in the scope of this node, 
     * otherwise return null.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:155
     */
    public InstLookupResult<InstComponentDecl> lookupInstComponent(SrcExp exp) {
        return annotationExp(exp).lookupInstComponentIfAccess();
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:197
     */
    public void addAnnotationToEvaluator(ArrayList<AnnotationNode> list, InstNode evaluator) {
        if (annotation().exists()) {
            list.add(annotation());
        }
    }
    /**
     * Returns the instantiated exp corresponding to argument
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:281
     */
    public FExp annotationExp(SrcExp exp) {
        if (exp.isSubExp()) {
            return annotationExp(exp.parentExp()).equivalentChildFExp(exp);
        } else {
            List<FExp> list = getAnnotationExps();
            Map<SrcExp, Integer> annotationExpMap = annotationExpMap();
            if (annotationExpMap.containsKey(exp)) {
                return list.getChild(annotationExpMap.get(exp));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
    /** 
     * Search for the applicable annotation from the enviroment. FilteredEnviroment 
     * is not used since it is peeling which is undesired. Retrives latest live annotation
     * from the chain of redeclares.
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2087
     */
    public SrcAnnotatable srcannotatableFromEnviroment() {
        Environment enviroment = myEnvironment();
        for (InstModification im : enviroment) {
            if (im.matches(name()) && im.isRedeclare()) {
                SrcAnnotatable annotatable = im.getElementModification();
                SrcAnnotationProvider provider = annotatable.srcAnnotationProvider();
                annotatable = provider.isClassRedeclare() ?
                        provider.getSrcClassRedeclare() : annotatable;
                annotatable = provider.isComponentRedeclare() ?
                        provider.getSrcComponentRedeclare() : annotatable;
                if (annotatable.srcAnnotationProvider().hasAnnotation()) {
                    return annotatable;
                }
            }
        }
        return null;
    }
    /**
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:43
     */
    public void checkAbsoluteValue() {
        AnnotationNode an = annotation("absoluteValue");
        if (an.exists()) {
            if (!isPrimitiveType()) {
                ASTNode.ABSOLUTE_VALUE_LOCATION.invoke(an.ast());
            }

            final SrcExp srcExp = an.exp();
            if (srcExp == null || !srcExp.isBooleanLiteral()) {
                ASTNode.ABSOLUTE_VALUE.invoke(an.ast());
            }
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstNode() {
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
        children = new ASTNode[8];
        setChild(List.EMPTY, 0);
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 2);
        setChild(List.EMPTY, 3);
        setChild(List.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:22
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:28
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:32
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myInputs_reset();
        myNonInputs_reset();
        myOutputs_reset();
        myModifiableComponents_reset();
        getFAccess_reset();
        genericLookupInstClass_String_reset();
        genericLookupInstComponent_String_reset();
        memberInstComponent_String_reset();
        memberInstConstantWithExtends_String_reset();
        memberInstConstant_String_reset();
        localInstModifications_reset();
        getMergedEnvironment_reset();
        myEnvironment_def_String_reset();
        totalMergedEnvironment_reset();
        getDynamicFExpOpt_reset();
        getInstComponentDeclList_reset();
        getInstClassDeclList_reset();
        getRedeclaredInstClassDeclList_reset();
        getInstExtendsList_reset();
        getElementInstModificationList_reset();
        getFAbstractEquationList_reset();
        getInstImportList_reset();
        containedInstComponents_reset();
        annotationExpMap_reset();
        getAnnotationExpList_reset();
        retrieveFAccess_reset();
        lookupInstComponent_String_reset();
        lookupInstConstant_String_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:64
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:68
     */
    public InstNode clone() throws CloneNotSupportedException {
        InstNode node = (InstNode) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:79
     */
    @Deprecated
    public abstract InstNode fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public abstract InstNode treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:95
     */
    public abstract InstNode treeCopy();
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
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1964
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1964")
    public abstract String qualifiedName();
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1210")
    public abstract boolean isPublic();
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
        int ndims_value = 0;
        return ndims_value;
    }
    /**
     * Get the array sizes. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1117
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1117")
    public Size size() {
        Size size_value = FArraySubscripts.declarationSize(myFSubscripts());
        return size_value;
    }
    /**
     * check if an instance node is an array expression.
     * 
     * @return True if array dimension > 0 else false
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1211
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1211")
    public boolean isArray() {
        boolean isArray_value = ndims()>0;
        return isArray_value;
    }
    /** @apilevel internal */
    private void myInputs_reset() {
        myInputs_computed = false;
        
        myInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myInputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<InstComponentDecl> myInputs_value;

    /**
     * Returns a list of all InstComponentDecls declared as "input".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1121
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1121")
    public ArrayList<InstComponentDecl> myInputs() {
        ASTState state = state();
        if (myInputs_computed) {
            return myInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myInputs_value = myInputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myInputs_value;
    }
    /** @apilevel internal */
    private ArrayList<InstComponentDecl> myInputs_compute() {
             ArrayList<InstComponentDecl> l = new ArrayList<InstComponentDecl>();
             Map<String,Integer> names = new HashMap<String,Integer>();
             for (InstComponentDecl icd : allInstComponentDecls()) {
                 if (icd.isInput()) {
                     // Make sure inherited ones are added first, 
                     // but that any that are also present locally replace them.
                     if (names.containsKey(icd.name())) {
                         l.set(names.get(icd.name()), icd);
                     } else {
                         names.put(icd.name(), l.size());
                         l.add(icd);
                     }
                 }
             }
             return l;
         }
    /** @apilevel internal */
    private void myNonInputs_reset() {
        myNonInputs_computed = false;
        
        myNonInputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myNonInputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<InstComponentDecl> myNonInputs_value;

    /**
     * Returns a list of all InstComponentDecls not declared as "input".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1145")
    public ArrayList<InstComponentDecl> myNonInputs() {
        ASTState state = state();
        if (myNonInputs_computed) {
            return myNonInputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myNonInputs_value = myNonInputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myNonInputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myNonInputs_value;
    }
    /** @apilevel internal */
    private ArrayList<InstComponentDecl> myNonInputs_compute() {
             ArrayList<InstComponentDecl> l = new ArrayList<InstComponentDecl>();
             Map<String,Integer> names = new HashMap<String,Integer>();
             for (InstComponentDecl icd : allInstComponentDecls()) {
                 if (!icd.isInput()) {
                     // Make sure inherited ones are added first, 
                     // but that any that are also present locally replace them.
                     if (names.containsKey(icd.name())) {
                         l.set(names.get(icd.name()), icd);
                     } else {
                         names.put(icd.name(), l.size());
                         l.add(icd);
                     }
                 }
             }
             return l;
         }
    /** @apilevel internal */
    private void myOutputs_reset() {
        myOutputs_computed = false;
        
        myOutputs_value = null;
    }
    /** @apilevel internal */
    protected boolean myOutputs_computed = false;

    /** @apilevel internal */
    protected ArrayList<InstComponentDecl> myOutputs_value;

    /**
     * Returns a list of all InstComponentDecls declared as "output".
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1168
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1168")
    public ArrayList<InstComponentDecl> myOutputs() {
        ASTState state = state();
        if (myOutputs_computed) {
            return myOutputs_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myOutputs_value = myOutputs_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myOutputs_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myOutputs_value;
    }
    /** @apilevel internal */
    private ArrayList<InstComponentDecl> myOutputs_compute() {
             ArrayList<InstComponentDecl> l = new ArrayList<InstComponentDecl>();
             Map<String,Integer> names = new HashMap<String,Integer>();
             for (InstComponentDecl icd : allInstComponentDecls()) {
                 if (icd.isOutput()) {
                     // Make sure inherited ones are added first, 
                     // but that any that are also present locally replace them.
                     if (names.containsKey(icd.name())) {
                         l.set(names.get(icd.name()), icd);
                     } else {
                         names.put(icd.name(), l.size());
                         l.add(icd);
                     }
                 }
             }
             return l;
         }
    /** @apilevel internal */
    private void myModifiableComponents_reset() {
        myModifiableComponents_computed = false;
        
        myModifiableComponents_value = null;
    }
    /** @apilevel internal */
    protected boolean myModifiableComponents_computed = false;

    /** @apilevel internal */
    protected ArrayList<InstComponentDecl> myModifiableComponents_value;

    /**
     * Returns a list of all contained InstComponentDecls that may be altered by a modification.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1192")
    public ArrayList<InstComponentDecl> myModifiableComponents() {
        ASTState state = state();
        if (myModifiableComponents_computed) {
            return myModifiableComponents_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myModifiableComponents_value = myModifiableComponents_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myModifiableComponents_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myModifiableComponents_value;
    }
    /** @apilevel internal */
    private ArrayList<InstComponentDecl> myModifiableComponents_compute() {
             ArrayList<InstComponentDecl> l = new ArrayList<InstComponentDecl>();
             for (InstComponentDecl icd : allInstComponentDecls())
                 if (icd.isModifiable())
                     l.add(icd);
             return l;
         }
    /**
     * Check if this class fulfills the requirements of a package.
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:819
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:819")
    public boolean isOkPackage() {
        {
                for (InstComponentDecl icd : getInstComponentDecls()) {
                    if (!icd.isConstant()) {
                        return false;
                    }
                }
                if (getNumFAbstractEquation() != 0) {
                    return false;
                }
                for (InstExtends ie : getInstExtendss()) {
                    if (!ie.isOkPackage()) {
                        return false;
                    }
                }
                return true;
            }
    }
    /**
     * Is this node or any node before the closest common ancestor with <code>source</code> replaceable?
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1418")
    public boolean canBeReplacedFor(InstNode source) {
        boolean canBeReplacedFor_InstNode_value = canBeReplacedIn(commonAncestor(source));
        return canBeReplacedFor_InstNode_value;
    }
    /**
     * Is this class or any class before <code>ancestor</code> replaceable?
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1427")
    public boolean canBeReplacedIn(InstNode ancestor) {
        boolean canBeReplacedIn_InstNode_value = isReplaceable() || canBeReplacedInHelper(ancestor);
        return canBeReplacedIn_InstNode_value;
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
        boolean isRecursed_value = false;
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
        boolean isOfInstClassDecl_InstClassDecl_value = false;
        return isOfInstClassDecl_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:390")
    public String kindDescription() {
        {
                throw new UnsupportedOperationException();
            }
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
        boolean containsFunction_FFunctionDecl_FunctionType_value = getInstComponentDecls().containsFunction(ft) || getInstExtendss().containsFunction(ft) ||
                getFAbstractEquations().containsFunction(ft) || super.containsFunction(ft);
        return containsFunction_FFunctionDecl_FunctionType_value;
    }
    /**
     * Find the first flow variable in this node, if any.
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:633")
    public InstComponentDecl findFlowVar() {
        {
                for (InstComponentDecl icd : allInstComponentDecls())
                    if (icd.isFlow())
                        return icd;
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:685
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:685")
    public FAlgorithm findFunctionAlgorithm() {
        {
                if (getNumFAbstractEquation() > 0) {
                    FAbstractEquation equ = getFAbstractEquation(0);
                    if (equ instanceof FAlgorithm)
                        return (FAlgorithm) equ;
                } else {
                    for (InstExtends ie : getInstExtendss()) {
                        FAlgorithm tmp = ie.findFunctionAlgorithm();
                        if (tmp != null) 
                            return tmp;
                    }
                }
                return null;
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
        String qualifiedTypeName_value = qualifiedName();
        return qualifiedTypeName_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1387")
    public boolean containsRedeclared() {
        boolean containsRedeclared_value = InstNode.containsRedeclared(this);
        return containsRedeclared_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2207
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2207")
    public int nextModLevelForExtraNode(int level) {
        int nextModLevelForExtraNode_int_value = level + 1;
        return nextModLevelForExtraNode_int_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2218")
    public InstNode[] extraNodesToSetModLevelFor() {
        InstNode[] extraNodesToSetModLevelFor_value = listExtraNodesToSetModLevelFor(false);
        return extraNodesToSetModLevelFor_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2249
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2249")
    public boolean hasModificationLevel() {
        boolean hasModificationLevel_value = myModificationLevel != Integer.MAX_VALUE;
        return hasModificationLevel_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFAccesss
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:175
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFAccesss", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:175")
    public FAccess getFAccessPrefix() {
        FAccess getFAccessPrefix_value = retrieveFAccess();
        return getFAccessPrefix_value;
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
        getFAccess_value = getFAccessPrefix();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getFAccess_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getFAccess_value;
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
        InstComponentDecl lookupInnerInstComponentNoLocal_InstComponentDecl_InstComponentDecl_value = lookupInnerInstComponent(outer, false);
        return lookupInnerInstComponentNoLocal_InstComponentDecl_InstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:33
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:33")
    public InstLookupResult<InstClassDecl> lookupInstClassRedirect(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassRedirect_String_value = genericLookupInstClass(name);
        return lookupInstClassRedirect_String_value;
    }
    /**
     * Lookup the class being redeclared & extended in the last step of a chain 
     * of "redeclare class extends" declarations, where it is known that the last 
     * redeclaring class is below this node.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:219
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:219")
    public InstLookupResult<InstClassDecl> lookupLastRedeclareExtendsInstClass(String name) {
        {
                // TODO: find better way of detecting if there is only one "redeclare class extends" in chain
                InstLookupResult<InstClassDecl> first = lookupCurRedeclareExtendsInstClass(name);
                if (first.successful()) {
                    InstLookupResult<InstClassDecl> second = first.target().resolveLib().lookupRedeclareExtendsInstClass(name);
                    if (second.successful())
                        return second;
                }
                return first;
            }
    }
    /**
     * Look up the next class being redeclared & extended in a chain of 
     * "redeclare class extends" declarations.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:234
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:234")
    public InstLookupResult<InstClassDecl> lookupNextRedeclareExtendsInstClass(String name) {
        {
                for (InstExtends ie : getInstExtendss()) {
                    InstLookupResult<InstClassDecl> res = ie.lookupCurRedeclareExtendsInstClass(name);
                    if (res.successful())
                        return res;
                }
                for (InstClassDecl icd : getInstClassDecls()) 
                    if (icd.matches(name)) 
                        return InstLookupResult.found(icd.originalInstClass());
                return InstLookupResult.notFound();
            }
    }
    /**
     * Look up the next class being redeclared & extended in a chain of 
     * "redeclare class extends" declarations, including among direct children.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:250")
    public InstLookupResult<InstClassDecl> lookupCurRedeclareExtendsInstClass(String name) {
        {
                for (InstClassDecl icd : getRedeclaredInstClassDecls()) 
                    if (icd.matches(name)) 
                        return InstLookupResult.found(icd);
                return lookupNextRedeclareExtendsInstClass(name);
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:371
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:371")
    public InstLookupResult<InstClassDecl> lookupInstClassInSurrounding(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassInSurrounding_String_value = lookupInstClass(name);
        return lookupInstClassInSurrounding_String_value;
    }
    /** @apilevel internal */
    private void genericLookupInstClass_String_reset() {
        genericLookupInstClass_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map genericLookupInstClass_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:377")
    public InstLookupResult<InstClassDecl> genericLookupInstClass(String name) {
        Object _parameters = name;
        if (genericLookupInstClass_String_values == null) genericLookupInstClass_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (genericLookupInstClass_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstClassDecl>) genericLookupInstClass_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstClassDecl> genericLookupInstClass_String_value = genericLookupInstClass_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        genericLookupInstClass_String_values.put(_parameters, genericLookupInstClass_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return genericLookupInstClass_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstClassDecl> genericLookupInstClass_compute(String name) {
            for (InstClassDecl icd : getInstClassDecls()) 
                if (icd.matches(name)) 
                    return InstLookupResult.found(icd);
            
            for (InstExtends ie : getInstExtendss()) {
                InstLookupResult<InstClassDecl> res = ie.memberInstClass(name);
                if (res.successful())
                    return res;
            }
            
            for (InstImport ii : getInstImports()) {
                InstLookupResult<InstClassDecl> res = ii.lookupInstClassInImport(name);
                if (res.successful())
                    return res;
            }
            
            return lookupInstClassInSurrounding(name);
        }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:399")
    public InstLookupResult<InstClassDecl> superLookupInstClass(String name) {
        {
                InstLookupResult<InstClassDecl> res = superLookupInstClassLocal(name);
                return res.successful() ? res : superLookupInstClassSurrounding(name);
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:404
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:404")
    public InstLookupResult<InstClassDecl> superLookupInstClassSurrounding(String name) {
        InstLookupResult<InstClassDecl> superLookupInstClassSurrounding_String_value = lookupInstClass(name);
        return superLookupInstClassSurrounding_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:407
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:407")
    public InstLookupResult<InstClassDecl> superLookupInstClassLocal(String name) {
        {
                for (InstImport ii : getInstImports()) {
                    InstLookupResult<InstClassDecl> res = ii.lookupInstClassInImport(name);
                    if (res.successful())
                        return res;
                }
                
                for (InstClassDecl icd : getInstClassDecls()) {
                    if (icd.matches(name)) {
                        return InstLookupResult.found(icd);
                    }
                }
                
                return InstLookupResult.notFound();
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
        InstLookupResult<InstClassDecl> memberInstClass_String_value = InstLookupResult.notFound();
        return memberInstClass_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:595")
    public InstClassDecl myInstClass() {
        InstClassDecl myInstClass_value = unknownInstClassDecl();
        return myInstClass_value;
    }
    /**
     * Look up qualified class names in the instance class structure.
     * 
     * @param name  a qualified name, for example 'A.B.C'
     * @attribute syn
     * @aspect SimpleInstClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:697
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleInstClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:697")
    public InstLookupResult<InstClassDecl> lookupInstClassQualified(String name) {
        {
                return lookupInstClassQualified(name, false);
            }
    }
    /**
     * Look up qualified class names in the instance class structure.
     * 
     * @param name  a qualified name, for example 'A.B.C'
     * @attribute syn
     * @aspect SimpleInstClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:706
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleInstClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:706")
    public InstLookupResult<InstClassDecl> lookupInstClassQualifiedGlobal(String name) {
        {
                return lookupInstClassQualified(name, true);
            }
    }
    /**
     * Look up qualified class names in the instance class structure.
     * 
     * @param name    a qualified name, for example 'A.B.C'
     * @param global  should the lookup start in the global scope?
     * @attribute syn
     * @aspect SimpleInstClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:716
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleInstClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:716")
    public InstLookupResult<InstClassDecl> lookupInstClassQualified(String name, boolean global) {
        {
                String[] parts = name.split("\\.");
                InstNode icd = this;
                InstLookupResult<InstClassDecl> res = null;
                boolean first = true;
                for (String part : parts) {
                    res = icd.lookupInstClassQualifiedPart(part, first, global);
                    if (!res.successful())
                        return res;
                    icd = res.target().resolveLib();
                    first = false;
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect SimpleInstClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:731
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleInstClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:731")
    public InstLookupResult<InstClassDecl> lookupInstClassQualifiedPart(String name, boolean first, boolean global) {
        {
                if (!first) {
                    return memberInstClass(name);
                } else if (global) {
                    return lookupInstClassFromTop(name);
                } else {
                    return lookupInstClass(name);
                }
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:418")
    public InstNode myConstrainingDecl() {
        {
                if (hasInstConstraining() && getInstConstraining().hasInstRedeclare()) {
                    return getInstConstraining().getRedeclareInstNode();
                } else {
                    return myDefaultConstrainingDecl();
                }
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:427")
    public InstNode myDefaultConstrainingDecl() {
        InstNode myDefaultConstrainingDecl_value = this;
        return myDefaultConstrainingDecl_value;
    }
    /** @apilevel internal */
    private void genericLookupInstComponent_String_reset() {
        genericLookupInstComponent_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map genericLookupInstComponent_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:579
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:579")
    public InstLookupResult<InstComponentDecl> genericLookupInstComponent(String name) {
        Object _parameters = name;
        if (genericLookupInstComponent_String_values == null) genericLookupInstComponent_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (genericLookupInstComponent_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) genericLookupInstComponent_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> genericLookupInstComponent_String_value = genericLookupInstComponent_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        genericLookupInstComponent_String_values.put(_parameters, genericLookupInstComponent_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return genericLookupInstComponent_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstComponentDecl> genericLookupInstComponent_compute(String name) {
            InstLookupResult<InstComponentDecl> res = memberInstComponent(name);
            if (res.successful())
                return res;
            for (InstImport ii : getInstImports()) {
                res = ii.lookupInstConstantInImport(name);
                if (res.successful())
                    return res;
            }
            return genericLookupInstConstant(name);
        }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:593
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:593")
    public InstLookupResult<InstComponentDecl> genericLookupInstConstant(String name) {
        InstLookupResult<InstComponentDecl> genericLookupInstConstant_String_value = lookupInstConstant(name);
        return genericLookupInstConstant_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:598
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:598")
    public InstLookupResult<InstComponentDecl> arrayMemberInstComponent(String name, int ndims) {
        {
                if (ndims == 0) 
                    return memberInstComponent(name);
                return getInstComponentDecl(0).arrayMemberInstComponent(name, ndims - 1);
            }
    }
    /** @apilevel internal */
    private void memberInstComponent_String_reset() {
        memberInstComponent_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map memberInstComponent_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:606
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:606")
    public InstLookupResult<InstComponentDecl> memberInstComponent(String name) {
        Object _parameters = name;
        if (memberInstComponent_String_values == null) memberInstComponent_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (memberInstComponent_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) memberInstComponent_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> memberInstComponent_String_value = memberInstComponent_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        memberInstComponent_String_values.put(_parameters, memberInstComponent_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return memberInstComponent_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstComponentDecl> memberInstComponent_compute(String name) {
            if (isArray()) {
                return arrayMemberInstComponent(name, ndims());
            } else {    
                for (InstComponentDecl ic : getInstComponentDecls()) 
                    if (ic.matches(name))
                        return findInnerComponentIfAny(ic.duplicateOriginal());
    
                for (InstExtends ie : getInstExtendss()) {
                    InstLookupResult<InstComponentDecl> res = ie.memberInstComponent(name);
                    if (res.successful())
                        return res;
                }
                
                return InstLookupResult.notFound();
            }
        }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:639
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:639")
    public InstLookupResult<InstComponentDecl> memberInstConstantFirst(String name) {
        {
                InstLookupResult<InstComponentDecl> res = memberInstConstantWithExtends(name);
                if (res.successful())
                    return res;
                
                for (InstImport ii : getInstImports()) {
                    res = ii.lookupInstConstantInImport(name);
                    if (res.successful())
                        return res;
                }
                
                return lookupInstConstant(name);
            }
    }
    /** @apilevel internal */
    private void memberInstConstantWithExtends_String_reset() {
        memberInstConstantWithExtends_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map memberInstConstantWithExtends_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:655
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:655")
    public InstLookupResult<InstComponentDecl> memberInstConstantWithExtends(String name) {
        Object _parameters = name;
        if (memberInstConstantWithExtends_String_values == null) memberInstConstantWithExtends_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (memberInstConstantWithExtends_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) memberInstConstantWithExtends_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> memberInstConstantWithExtends_String_value = memberInstConstantWithExtends_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        memberInstConstantWithExtends_String_values.put(_parameters, memberInstConstantWithExtends_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return memberInstConstantWithExtends_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstComponentDecl> memberInstConstantWithExtends_compute(String name) {
            InstLookupResult<InstComponentDecl> res = memberInstConstant(name);
            if (res.successful())
                return res;
            
            for (InstExtends ie : getInstExtendss()) {
                res = ie.memberInstConstantWithExtends(name);
                if (res.successful())
                    return res;
            }
            
            return InstLookupResult.notFound();
        }
    /** @apilevel internal */
    private void memberInstConstant_String_reset() {
        memberInstConstant_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map memberInstConstant_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:671
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:671")
    public InstLookupResult<InstComponentDecl> memberInstConstant(String name) {
        Object _parameters = name;
        if (memberInstConstant_String_values == null) memberInstConstant_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (memberInstConstant_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) memberInstConstant_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> memberInstConstant_String_value = memberInstConstant_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        memberInstConstant_String_values.put(_parameters, memberInstConstant_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return memberInstConstant_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstComponentDecl> memberInstConstant_compute(String name) {
            for (InstComponentDecl ic : getInstComponentDecls()) 
                if (ic.getSrcComponentDecl().isConstant() && ic.matches(name))
                    return InstLookupResult.found(ic.duplicateOriginal());
            
            return InstLookupResult.notFound();
        }
    /**
     * @attribute syn
     * @aspect SimpleLookupInstComponentDecl
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:777
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleLookupInstComponentDecl", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:777")
    public InstComponentDecl simpleLookupInstComponentDecl(String name) {
        {
                for (InstComponentDecl icd : getInstComponentDecls()) {
                    if (icd.name().matches(name))
                        return icd;
                }
                for (InstExtends ie : getInstExtendss()) {
                    InstComponentDecl match = ie.simpleLookupInstComponentDecl(name);
                    if (match != null)
                        return match;
                }
                return null;
            }
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
        {
                if (isReal()) 
                    return fRealScalarType();
                else if (isInteger()) 
                    return fIntegerScalarType();
                else if (isBoolean()) 
                    return fBooleanScalarType();
                else if (isString()) 
                    return fStringScalarType();
                else if (isExternalObject())
                    return new FExternalObjectType(Size.SCALAR, "ExternalObject", new FAccessString("ExternalObject.constructor"), new FAccessString("ExternalObject.destructor"));
                return fUnknownType();
            }
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:200
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:200")
    public boolean isReal() {
        boolean isReal_value = false;
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
        boolean isInteger_value = false;
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
        boolean isBoolean_value = false;
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
        boolean isString_value = false;
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
        boolean isEnum_value = false;
        return isEnum_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:205
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:205")
    public boolean isExternalObject() {
        boolean isExternalObject_value = false;
        return isExternalObject_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:206")
    public boolean isPartialFunction() {
        boolean isPartialFunction_value = false;
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
        boolean isMeOrMyClass_InstNode_value = node == this;
        return isMeOrMyClass_InstNode_value;
    }
    /**
     * If this is an extends, get the surrounding class or component, otherwise return this.
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:413
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:413")
    public InstNode inheritingNode() {
        InstNode inheritingNode_value = this;
        return inheritingNode_value;
    }
    /**
     * @attribute syn
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:442
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:442")
    public boolean inArrayComponent() {
        boolean inArrayComponent_value = false;
        return inArrayComponent_value;
    }
    /**
     * Is this class a function?
     * @attribute syn
     * @aspect InstClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:631
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:631")
    public boolean isFunction() {
        boolean isFunction_value = false;
        return isFunction_value;
    }
    /** @apilevel internal */
    private void localInstModifications_reset() {
        localInstModifications_computed = false;
        
        localInstModifications_value = null;
    }
    /** @apilevel internal */
    protected boolean localInstModifications_computed = false;

    /** @apilevel internal */
    protected Collection<InstModification> localInstModifications_value;

    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:331
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:331")
    public Collection<InstModification> localInstModifications() {
        ASTState state = state();
        if (localInstModifications_computed) {
            return localInstModifications_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        localInstModifications_value = localInstModifications_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        localInstModifications_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return localInstModifications_value;
    }
    /** @apilevel internal */
    private Collection<InstModification> localInstModifications_compute() {
            Collection<InstModification> nc = localInstModificationsNoClass();
            Collection<InstModification> c = localInstModificationsClass();
            if (nc.isEmpty()) {
                return c;
            } else if (c.isEmpty()) {
                return nc;
            } else {
                ArrayList<InstModification> l = new ArrayList<InstModification>();
                l.addAll(nc);
                l.addAll(c);
                return l;
            }
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
        Collection<InstModification> localInstModificationsNoClass_value = Collections.<InstModification>emptyList();
        return localInstModificationsNoClass_value;
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
        Collection<InstModification> localInstModificationsClass_value = Collections.<InstModification>emptyList();
        return localInstModificationsClass_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:422")
    public java.util.List<InstModification> instModificationsFromConstrainingType() {
        java.util.List<InstModification> instModificationsFromConstrainingType_value = Collections.<InstModification>emptyList();
        return instModificationsFromConstrainingType_value;
    }
    /** @apilevel internal */
    private void getMergedEnvironment_reset() {
        getMergedEnvironment_computed = false;
        
        getMergedEnvironment_value = null;
    }
    /** @apilevel internal */
    protected boolean getMergedEnvironment_computed = false;

    /** @apilevel internal */
    protected Environment getMergedEnvironment_value;

    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:496
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:496")
    public Environment getMergedEnvironment() {
        ASTState state = state();
        if (getMergedEnvironment_computed) {
            return getMergedEnvironment_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getMergedEnvironment_value = filteredEnvironment().mergeInnerClone(getElementInstModifications(), localInstModifications());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getMergedEnvironment_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getMergedEnvironment_value;
    }
    /**
     * Gives the environment filtered on this InstNode. The result includes only include modifications on/for this 
     * InstNode. 
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:515
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:515")
    public Environment filteredEnvironment() {
        Environment filteredEnvironment_value = nameScope() ? myEnvironment(name()) : myEnvironment();
        return filteredEnvironment_value;
    }
    /** @apilevel internal */
    private void myEnvironment_def_String_reset() {
        myEnvironment_def_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map myEnvironment_def_String_values;

    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:589
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:589")
    public Environment myEnvironment_def(String name) {
        Object _parameters = name;
        if (myEnvironment_def_String_values == null) myEnvironment_def_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (myEnvironment_def_String_values.containsKey(_parameters)) {
            return (Environment) myEnvironment_def_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        Environment myEnvironment_def_String_value = getMergedEnvironment().filter(name, retrieveReplacingComponent(name), retrieveReplacingClass(name));
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myEnvironment_def_String_values.put(_parameters, myEnvironment_def_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return myEnvironment_def_String_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:698")
    public InstComponentRedeclare retrieveReplacingComponent(String name) {
        {
                for (InstModification im : getMergedEnvironment()) {
                    InstComponentRedeclare icr = im.matchInstComponentRedeclare(name);
                    if (icr != null) 
                        return icr;
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:707
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:707")
    public InstComponentRedeclare retrieveConstrainingComponent(String name) {
        {
                for (InstModification im : getMergedEnvironment()) {
                    InstComponentRedeclare icr = im.matchInstComponentRedeclare(name);
                    if (icr != null && icr.getComponentRedeclareDecl().hasSrcConstrainingClause()) 
                        return icr;
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:717
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:717")
    public InstRedeclareClassNode retrieveReplacingClass(String name) {
        {
                for (InstModification im : getMergedEnvironment()) {
                    InstClassRedeclare icr = im.matchInstClassRedeclare(name);
                    if (icr != null) 
                        return icr;
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:726
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:726")
    public InstRedeclareClassNode retrieveConstrainingClass(String name) {
        {
                for (InstModification im : getMergedEnvironment()) {
                    InstRedeclareClassNode icr = im.matchInstClassRedeclare(name);
                    if (icr != null && icr.redeclaringClassDecl().hasSrcConstrainingClause()) 
                        return icr;
                }
                return null;
            }
    }
    /** @apilevel internal */
    private void totalMergedEnvironment_reset() {
        totalMergedEnvironment_computed = false;
        
        totalMergedEnvironment_value = null;
    }
    /** @apilevel internal */
    protected boolean totalMergedEnvironment_computed = false;

    /** @apilevel internal */
    protected Environment totalMergedEnvironment_value;

    /**
     * InstPrimitive:s may have children of type InstExtends, if the InstPrimitive is instantiated
     * either from a short class declaration that references a primitive type or from a 'type' class
     * declaration that inherits a primitive type. In both cases, the result is one or a chain of InstExtends/
     * InstExtendsShortClass children. The final node in such a chain holds the total merged environment of 
     * the InstPrimitive. InstRecords can of course have InstExtends.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:788
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:788")
    public Environment totalMergedEnvironment() {
        ASTState state = state();
        if (totalMergedEnvironment_computed) {
            return totalMergedEnvironment_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        totalMergedEnvironment_value = totalMergedEnvironment_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        totalMergedEnvironment_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return totalMergedEnvironment_value;
    }
    /** @apilevel internal */
    private Environment totalMergedEnvironment_compute() {
    		if (getNumInstExtends()==0)
    			return getMergedEnvironment();
    		else
    			return getInstExtends(0).totalMergedEnvironment();
    	}
    /** @apilevel internal */
    private void getDynamicFExpOpt_reset() {
        getDynamicFExpOpt_computed = false;
        
        getDynamicFExpOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getDynamicFExpOpt_computed = false;

    /** @apilevel internal */
    protected Opt getDynamicFExpOpt_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:851
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:851")
    public Opt getDynamicFExpOpt() {
        ASTState state = state();
        if (getDynamicFExpOpt_computed) {
            return getDynamicFExpOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getDynamicFExpOpt_value = new DynamicOpt();
        getDynamicFExpOpt_value.setParent(this);
        getDynamicFExpOpt_value.is$Final = true;
        if (true) {
        getDynamicFExpOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getDynamicFExpOpt_value;
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
            List<InstComponentDecl> l = new List<InstComponentDecl>();
            for (SrcComponentDecl cd : components()) {
                if (!cd.hasRedeclare()) {
                    l.add(createInstComponentDecl(cd));
                }
            }
            return l;
            
        }
    /** @apilevel internal */
    private void getInstClassDeclList_reset() {
        getInstClassDeclList_computed = false;
        
        getInstClassDeclList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstClassDeclList_computed = false;

    /** @apilevel internal */
    protected List getInstClassDeclList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:966
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:966")
    public List getInstClassDeclList() {
        ASTState state = state();
        if (getInstClassDeclList_computed) {
            return (List) getChild(getInstClassDeclListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstClassDeclList_value = getInstClassDeclList_compute();
        if(getInstClassDeclList_value.numChildren() <= 0) {
            getInstClassDeclList_value  = List.EMPTY;
        }
        setChild(getInstClassDeclList_value, getInstClassDeclListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstClassDeclList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getInstClassDeclListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getInstClassDeclList_compute() {
            List l = new List();
            
            for (SrcClassDecl cd : classes()) {
                if (!cd.hasRedeclare()) {
                    InstClassDecl icd = createInstClassDecl(cd);
                    if (icd != null)
                        l.add(icd);
                }
            }
            
            return l;
        }
    /** @apilevel internal */
    private void getRedeclaredInstClassDeclList_reset() {
        getRedeclaredInstClassDeclList_computed = false;
        
        getRedeclaredInstClassDeclList_value = null;
    }
    /** @apilevel internal */
    protected boolean getRedeclaredInstClassDeclList_computed = false;

    /** @apilevel internal */
    protected List getRedeclaredInstClassDeclList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:980
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:980")
    public List getRedeclaredInstClassDeclList() {
        ASTState state = state();
        if (getRedeclaredInstClassDeclList_computed) {
            return (List) getChild(getRedeclaredInstClassDeclListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getRedeclaredInstClassDeclList_value = getRedeclaredInstClassDeclList_compute();
        if(getRedeclaredInstClassDeclList_value.numChildren() <= 0) {
            getRedeclaredInstClassDeclList_value  = List.EMPTY;
        }
        setChild(getRedeclaredInstClassDeclList_value, getRedeclaredInstClassDeclListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getRedeclaredInstClassDeclList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getRedeclaredInstClassDeclListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getRedeclaredInstClassDeclList_compute() {
            List l = new List();
            
            for (SrcClassDecl cd : classes()) {
                if (cd.hasRedeclare()) {
                    InstNode icd = cd.newInstClassDecl();
                    if (icd != null)
                        l.add(icd);
                }
            }
            
            return l;
        }
    /** @apilevel internal */
    private void getInstExtendsList_reset() {
        getInstExtendsList_computed = false;
        
        getInstExtendsList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstExtendsList_computed = false;

    /** @apilevel internal */
    protected List getInstExtendsList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:999
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:999")
    public List getInstExtendsList() {
        ASTState state = state();
        if (getInstExtendsList_computed) {
            return (List) getChild(getInstExtendsListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstExtendsList_value = getInstExtendsList_compute();
        if(getInstExtendsList_value.numChildren() <= 0) {
            getInstExtendsList_value  = List.EMPTY;
        }
        setChild(getInstExtendsList_value, getInstExtendsListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstExtendsList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getInstExtendsListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getInstExtendsList_compute() {
            List l = new List();
            if (shouldHaveInstExtendsList()) {
                InstNode lookup = instLookupNodeForShortClassExtends();
                for (SrcExtendsClause e : superClasses()) { 
                    l.add(createInstExtends(e, lookup));
                }
            }
            return l;
        }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1010
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1010")
    public boolean shouldHaveInstExtendsList() {
        boolean shouldHaveInstExtendsList_value = true;
        return shouldHaveInstExtendsList_value;
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
        InstNode instLookupNodeForShortClassExtends_value = myInstClass().instLookupNodeForShortClassExtends();
        return instLookupNodeForShortClassExtends_value;
    }
    /** @apilevel internal */
    private void getElementInstModificationList_reset() {
        getElementInstModificationList_computed = false;
        
        getElementInstModificationList_value = null;
    }
    /** @apilevel internal */
    protected boolean getElementInstModificationList_computed = false;

    /** @apilevel internal */
    protected List<InstModification> getElementInstModificationList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1078
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1078")
    public List<InstModification> getElementInstModificationList() {
        ASTState state = state();
        if (getElementInstModificationList_computed) {
            return (List<InstModification>) getChild(getElementInstModificationListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getElementInstModificationList_value = getElementInstModificationList_compute();
        if(getElementInstModificationList_value.numChildren() <= 0) {
            getElementInstModificationList_value  = List.EMPTY;
        }
        setChild(getElementInstModificationList_value, getElementInstModificationListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getElementInstModificationList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<InstModification> node = (List<InstModification>) this.getChild(getElementInstModificationListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<InstModification> getElementInstModificationList_compute() {
            List<InstModification> l = new List<InstModification>();
            for (SrcModificationOrRedeclareElement m : elementModifications()) 
                l.add(m.newInstModification());
            return l;
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
        getFAbstractEquationList_value = buildFAbstractEquationList();
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
    /** @apilevel internal */
    private void getInstImportList_reset() {
        getInstImportList_computed = false;
        
        getInstImportList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstImportList_computed = false;

    /** @apilevel internal */
    protected List getInstImportList_value;

    /**
     * @attribute syn nta
     * @aspect InstImportClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1908
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstImportClauses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1908")
    public List getInstImportList() {
        ASTState state = state();
        if (getInstImportList_computed) {
            return (List) getChild(getInstImportListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstImportList_value = getInstImportList_compute();
        if(getInstImportList_value.numChildren() <= 0) {
            getInstImportList_value  = List.EMPTY;
        }
        setChild(getInstImportList_value, getInstImportListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstImportList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getInstImportListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getInstImportList_compute() {
        	List l = new List();
        	for (SrcImportClause ic : imports()) {
        		InstImport iic = ic.newInstImport();
        		iic.setLocation(ic);
        		l.add(iic);
        	}
        	return l;
        }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1934
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1934")
    public boolean nameScope() {
        boolean nameScope_value = false;
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
        String name_value = "";
        return name_value;
    }
    /**
     * Retrieve fully indexed names for array elements
     * 
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1951
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1951")
    public String getElementName() {
        String getElementName_value = name();
        return getElementName_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1988
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1988")
    public String buildQualifiedName() {
        String buildQualifiedName_value = combineName(instClassNamePrefix(false), name());
        return buildQualifiedName_value;
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
        String baseClassName_value = (getNumInstExtends() > 0) ? getInstExtends(0).baseClassName() : qualifiedName();
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
        Iterable<SrcAbstractEquation> equations_value = Collections.<SrcAbstractEquation>emptyList();
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
        Iterable<SrcAlgorithm> algorithms_value = Collections.<SrcAlgorithm>emptyList();
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
        Iterable<FAlgorithm> fAlgorithms_value = Collections.<FAlgorithm>emptyList();
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
        Iterable<SrcComponentDecl> components_value = Collections.<SrcComponentDecl>emptyList();
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
        Iterable<SrcExtendsClause> superClasses_value = Collections.<SrcExtendsClause>emptyList();
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
        Iterable<SrcClassDecl> classes_value = Collections.<SrcClassDecl>emptyList();
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
        Iterable<SrcImportClause> imports_value = Collections.<SrcImportClause>emptyList();
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
        Iterable<SrcModificationOrRedeclareElement> elementModifications_value = Collections.<SrcModificationOrRedeclareElement>emptyList();
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
        boolean hasInstConstraining_value = false;
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
        InstConstraining getInstConstraining_value = null;
        return getInstConstraining_value;
    }
    /**
     * Is this declaration redeclared?
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2134")
    public boolean isRedeclared() {
        boolean isRedeclared_value = false;
        return isRedeclared_value;
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
        boolean isReplaceable_value = false;
        return isReplaceable_value;
    }
    /**
     * Is this declaration affected by a constraining type?
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2152
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2152")
    public boolean isConstrained() {
        boolean isConstrained_value = isReplaceable() || isRedeclared();
        return isConstrained_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2157")
    public boolean extendsPrimitive() {
        boolean extendsPrimitive_value = false;
        return extendsPrimitive_value;
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
        boolean isClassDecl_value = false;
        return isClassDecl_value;
    }
    /**
     * Check if this node is an extends.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2177
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2177")
    public boolean isExtends() {
        boolean isExtends_value = false;
        return isExtends_value;
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
        boolean isComponentDecl_value = false;
        return isComponentDecl_value;
    }
    /**
     * Check if this node is, is of, or extends a primitive type.
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2206")
    public boolean isOrExtendsPrimitive() {
        boolean isOrExtendsPrimitive_value = isPrimitive() || extendsPrimitive();
        return isOrExtendsPrimitive_value;
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
        boolean extendsEnum_value = false;
        return extendsEnum_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2228")
    public InstNode commonAncestor(InstNode node) {
        {
                HashSet<InstNode> theirs = new HashSet<InstNode>(node.instAncestors());
                for (InstNode mine : instAncestors())
                    if (theirs.contains(mine))
                        return mine;
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2236
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2236")
    public java.util.List<InstNode> instAncestors() {
        {
                ArrayList<InstNode> list = new ArrayList<InstNode>();
                InstNode cur = this;
                while (cur != null) {
                    list.add(cur);
                    cur = cur.instNodeParent();
                }
                return list;
            }
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2250")
    public InstNode matchingAncestor(InstNode node) {
        {
                if (node.isClassDecl()) {
                    int dims = node.nTypeDims();
                    for (InstNode mine : instAncestors()) {
                        if (mine.isThisClass(node)) {
                            if (dims == 0 || mine.isClassDecl()) {
                                return mine;
                            }
                            dims = dims - 1;
                        }
                    }
                    return null;
                } else {
                    return commonAncestor(node);
                }
            }
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2267")
    public int nTypeDims() {
        int nTypeDims_value = 0;
        return nTypeDims_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2272")
    public boolean isThisClass(InstNode node) {
        boolean isThisClass_InstNode_value = this == node;
        return isThisClass_InstNode_value;
    }
    /**
     * @attribute syn
     * @aspect InstArrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2629
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstArrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2629")
    public java.util.List<? extends Subscript> myFSubscripts() {
        java.util.List<? extends Subscript> myFSubscripts_value = Collections.emptyList();
        return myFSubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:102")
    public boolean isUnknown() {
        boolean isUnknown_value = false;
        return isUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:106")
    public boolean isPrimitive() {
        boolean isPrimitive_value = false;
        return isPrimitive_value;
    }
    /**
     * Check that this is of a subtype of t.
     * 
     * If either side is the result of a failed lookup, then check succeeds, 
     * since that should generate an error anyway, and we only want it reported once.
     * 
     * @return  null if it is a subtype, a description of the problem otherwise.
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:36
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:36")
    public String subType(InstNode t) {
        String subType_InstNode_value = t.isUnknown() ? null : subType(t, null, true);
        return subType_InstNode_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:40
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:40")
    public String subType(InstNode t, String name, boolean top) {
        {
                throw new UnsupportedOperationException();
            }
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:54
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:54")
    public boolean isCompositeType() {
        boolean isCompositeType_value = false;
        return isCompositeType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:58
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:58")
    public boolean isArrayPartType() {
        boolean isArrayPartType_value = false;
        return isArrayPartType_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:61
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:61")
    public boolean isRecordType() {
        boolean isRecordType_value = false;
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
        boolean isPrimitiveType_value = false;
        return isPrimitiveType_value;
    }
    /** @apilevel internal */
    private void containedInstComponents_reset() {
        containedInstComponents_computed = false;
        
        containedInstComponents_value = null;
    }
    /** @apilevel internal */
    protected boolean containedInstComponents_computed = false;

    /** @apilevel internal */
    protected SortedSet<InstComponentDecl> containedInstComponents_value;

    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:182
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:182")
    public SortedSet<InstComponentDecl> containedInstComponents() {
        ASTState state = state();
        if (containedInstComponents_computed) {
            return containedInstComponents_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        containedInstComponents_value = containedInstComponents_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        containedInstComponents_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return containedInstComponents_value;
    }
    /** @apilevel internal */
    private SortedSet<InstComponentDecl> containedInstComponents_compute() {
            SortedSet<InstComponentDecl> s = new TreeSet<InstComponentDecl>(InstComponentDecl.NAME_COMPARATOR);
            for (InstNode node : getInstExtendss())
                s.addAll(node.containedInstComponents());
            for (InstComponentDecl node : getInstComponentDecls())
                s.add(node);
            return s;
        }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:192")
    public InstNode constrainingInstType() {
        InstNode constrainingInstType_value = this;
        return constrainingInstType_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations and need a 
     * non-default evaluator.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:37
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:37")
    public AnnotationNode annotation() {
        AnnotationNode annotation_value = annotation(annotationExpEvaluator());
        return annotation_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:103
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:103")
    public InstContext annotationExpEvaluator() {
        InstContext annotationExpEvaluator_value = parentExpEvaluator();
        return annotationExpEvaluator_value;
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
                ArrayList<AnnotationNode> list = new ArrayList<>();
                getInstComponentDecls().addAnnotationToEvaluator(list, this);
                getInstClassDecls().addAnnotationToEvaluator(list, this);
                getInstExtendss().addAnnotationToEvaluator(list, this);
                getRedeclaredInstClassDecls().addAnnotationToEvaluator(list, this);
                return list;
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:240
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:240")
    public ArrayList<SrcExp> annotationExps() {
        {
                ArrayList<SrcExp> exps = new ArrayList<>();
                for (AnnotationNode annotation : annotations()) {
                    annotation.collectExps(exps);
                }
                return exps;
            }
    }
    /** @apilevel internal */
    private void annotationExpMap_reset() {
        annotationExpMap_computed = false;
        
        annotationExpMap_value = null;
    }
    /** @apilevel internal */
    protected boolean annotationExpMap_computed = false;

    /** @apilevel internal */
    protected Map<SrcExp,Integer> annotationExpMap_value;

    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:248
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:248")
    public Map<SrcExp,Integer> annotationExpMap() {
        ASTState state = state();
        if (annotationExpMap_computed) {
            return annotationExpMap_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        annotationExpMap_value = annotationExpMap_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        annotationExpMap_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return annotationExpMap_value;
    }
    /** @apilevel internal */
    private Map<SrcExp,Integer> annotationExpMap_compute() {
            ArrayList<SrcExp> exps = annotationExps();
            Map<SrcExp, Integer> map = new HashMap<>();
            for (int i = 0; i < exps.size(); i++) {
                SrcExp exp = exps.get(i);
                map.put(exp, i);
            }
            return map;
        }
    /** @apilevel internal */
    private void getAnnotationExpList_reset() {
        getAnnotationExpList_computed = false;
        
        getAnnotationExpList_value = null;
    }
    /** @apilevel internal */
    protected boolean getAnnotationExpList_computed = false;

    /** @apilevel internal */
    protected List<FExp> getAnnotationExpList_value;

    /**
     * @attribute syn nta
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:258")
    public List<FExp> getAnnotationExpList() {
        ASTState state = state();
        if (getAnnotationExpList_computed) {
            return (List<FExp>) getChild(getAnnotationExpListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getAnnotationExpList_value = getAnnotationExpList_compute();
        if(getAnnotationExpList_value.numChildren() <= 0) {
            getAnnotationExpList_value  = List.EMPTY;
        }
        setChild(getAnnotationExpList_value, getAnnotationExpListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getAnnotationExpList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<FExp> node = (List<FExp>) this.getChild(getAnnotationExpListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<FExp> getAnnotationExpList_compute() {
            ArrayList<SrcExp> exps = annotationExps();
            ArrayList<FExp> instExps = new ArrayList<>();
            for (int i = 0; i < exps.size(); i++) {
                SrcExp exp = exps.get(i);
                FExp instExp = exp.instantiate();
                instExps.add(instExp);
            }
            return new List(instExps);
        }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:405")
    public AnnotationNode classAnnotation() {
        AnnotationNode classAnnotation_value = myInstClass().annotation();
        return classAnnotation_value;
    }
    /**
     * @attribute syn
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RootAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:65")
    public SourceRoot sourceRoot() {
        SourceRoot sourceRoot_value = (SourceRoot) root();
        return sourceRoot_value;
    }
    /**
     * Create an instance name from a class declaration and a suffix.
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:836
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:836")
    public String buildInstanceName(InstClassDecl cls, FAccess suffix) {
        String buildInstanceName_InstClassDecl_FAccess_value = (suffix.numParts() == 0) ? cls.name() : cls.name() + '.' + suffix.name();
        return buildInstanceName_InstClassDecl_FAccess_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:845
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:845")
    public String libraryName() {
        {
        	  InstClassDecl icd = myInstClass();
        	  String res = icd.isUnknown() ? findLibraryName() : icd.findLibraryName();
        	  return (res == null) ? name() : res;
          }
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:885
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:885")
    public boolean isLibNode() {
        boolean isLibNode_value = false;
        return isLibNode_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145")
    public boolean inRecord() {
        boolean inRecord_value = getParent().Define_inRecord(this, null);
        return inRecord_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3154")
    public boolean inRecordDecl() {
        boolean inRecordDecl_value = getParent().Define_inRecordDecl(this, null);
        return inRecordDecl_value;
    }
    /**
     * Get the class or component containing this node.
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1435
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1435")
    public InstNode containingEntity() {
        InstNode containingEntity_value = getParent().Define_containingEntity(this, null);
        return containingEntity_value;
    }
    /**
     * Helper method for {@link #canBeReplacedIn(InstNode)} - use it instead.
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1432
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1432")
    public boolean canBeReplacedInHelper(InstNode ancestor) {
        boolean canBeReplacedInHelper_InstNode_value = getParent().Define_canBeReplacedInHelper(this, null, ancestor);
        return canBeReplacedInHelper_InstNode_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:406")
    public boolean isInRedeclareMod() {
        boolean isInRedeclareMod_value = getParent().Define_isInRedeclareMod(this, null);
        return isInRedeclareMod_value;
    }
    /**
     * Extract the part of a binding array expression that refers to this primitive or record.
     * 
     * Will not create new nodes unless necessary.
     * 
     * @param fe    the expression to split
     * @param node  the node where the binding expression was declared 
     * @param dims  the expected number of dimensions of the resulting expression
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1824
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1824")
    public FExp splitBindingFExp(FExp fe, InstNode node, int dims) {
        FExp splitBindingFExp_FExp_InstNode_int_value = getParent().Define_splitBindingFExp(this, null, fe, node, dims);
        return splitBindingFExp_FExp_InstNode_int_value;
    }
    /**
     * @attribute inh
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2212")
    public InstNode parentNodeToSetModLevelFor() {
        InstNode parentNodeToSetModLevelFor_value = getParent().Define_parentNodeToSetModLevelFor(this, null);
        return parentNodeToSetModLevelFor_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFAccesss
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFAccesss", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:196")
    public FAccess retrieveFAccess() {
        ASTState state = state();
        if (retrieveFAccess_computed) {
            return retrieveFAccess_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        retrieveFAccess_value = getParent().Define_retrieveFAccess(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        retrieveFAccess_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return retrieveFAccess_value;
    }
    /** @apilevel internal */
    private void retrieveFAccess_reset() {
        retrieveFAccess_computed = false;
        
        retrieveFAccess_value = null;
    }
    /** @apilevel internal */
    protected boolean retrieveFAccess_computed = false;

    /** @apilevel internal */
    protected FAccess retrieveFAccess_value;

    /**
     * @attribute inh
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:21
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:21")
    public boolean inOuter() {
        boolean inOuter_value = getParent().Define_inOuter(this, null);
        return inOuter_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:27
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:27")
    public boolean inInner() {
        boolean inInner_value = getParent().Define_inInner(this, null);
        return inInner_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:49
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:49")
    public InstComponentDecl lookupInnerInstComponent(InstComponentDecl outer, boolean firstScope) {
        InstComponentDecl lookupInnerInstComponent_InstComponentDecl_boolean_value = getParent().Define_lookupInnerInstComponent(this, null, outer, firstScope);
        return lookupInnerInstComponent_InstComponentDecl_boolean_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:131")
    public InstClassDecl lookupInnerInstClass(String name, boolean firstScope) {
        InstClassDecl lookupInnerInstClass_String_boolean_value = getParent().Define_lookupInnerInstClass(this, null, name, firstScope);
        return lookupInnerInstClass_String_boolean_value;
    }
    /**
     * @attribute inh
     * @aspect InnerOuterClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:146
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InnerOuterClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:146")
    public InstClassDecl lookupInInnerInstClass(String name) {
        InstClassDecl lookupInInnerInstClass_String_value = getParent().Define_lookupInInnerInstClass(this, null, name);
        return lookupInInnerInstClass_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:28
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:28")
    public InstLookupResult<InstClassDecl> lookupInstClass(String name) {
        InstLookupResult<InstClassDecl> lookupInstClass_String_value = getParent().Define_lookupInstClass(this, null, name);
        return lookupInstClass_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:152
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:152")
    public InstLookupResult<InstClassDecl> lookupInstClassFromTop(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassFromTop_String_value = getParent().Define_lookupInstClassFromTop(this, null, name);
        return lookupInstClassFromTop_String_value;
    }
    /**
     * Look up the class being redeclared & extended in a "redeclare class extends" declaration.
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:162
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:162")
    public InstLookupResult<InstClassDecl> lookupRedeclareExtendsInstClass(String name) {
        InstLookupResult<InstClassDecl> lookupRedeclareExtendsInstClass_String_value = getParent().Define_lookupRedeclareExtendsInstClass(this, null, name);
        return lookupRedeclareExtendsInstClass_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:319
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:319")
    public InstLookupResult<InstComponentDecl> lookupInstComponent(String name) {
        Object _parameters = name;
        if (lookupInstComponent_String_values == null) lookupInstComponent_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (lookupInstComponent_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) lookupInstComponent_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> lookupInstComponent_String_value = getParent().Define_lookupInstComponent(this, null, name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        lookupInstComponent_String_values.put(_parameters, lookupInstComponent_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return lookupInstComponent_String_value;
    }
    /** @apilevel internal */
    private void lookupInstComponent_String_reset() {
        lookupInstComponent_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map lookupInstComponent_String_values;

    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:634
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:634")
    public InstLookupResult<InstComponentDecl> lookupInstConstant(String name) {
        Object _parameters = name;
        if (lookupInstConstant_String_values == null) lookupInstConstant_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (lookupInstConstant_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) lookupInstConstant_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> lookupInstConstant_String_value = getParent().Define_lookupInstConstant(this, null, name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        lookupInstConstant_String_values.put(_parameters, lookupInstConstant_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return lookupInstConstant_String_value;
    }
    /** @apilevel internal */
    private void lookupInstConstant_String_reset() {
        lookupInstConstant_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map lookupInstConstant_String_values;

    /**
     * Find the surrounding class, if any.
     * @attribute inh
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:427
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:427")
    public InstClassDecl surroundingInstClass() {
        InstClassDecl surroundingInstClass_value = getParent().Define_surroundingInstClass(this, null);
        return surroundingInstClass_value;
    }
    /**
     * @attribute inh
     * @aspect InstVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36")
    public TypePrefixVariability overrideVariability() {
        TypePrefixVariability overrideVariability_value = getParent().Define_overrideVariability(this, null);
        return overrideVariability_value;
    }
    /**
     * myEnvironment represents the environment of the InstNode itself. It is defined
     * as an inherited attribute and is computed from the outer environment located at
     * ancestor InstNodes.
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554")
    public Environment myEnvironment() {
        Environment myEnvironment_value = getParent().Define_myEnvironment(this, null);
        return myEnvironment_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:555
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:555")
    public Environment myEnvironment(String name) {
        Environment myEnvironment_String_value = getParent().Define_myEnvironment(this, null, name);
        return myEnvironment_String_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:760
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:760")
    public InstNode myInstNode() {
        InstNode myInstNode_value = getParent().Define_myInstNode(this, null);
        return myInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:774
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:774")
    public InstNode myParentInstNode() {
        InstNode myParentInstNode_value = getParent().Define_myParentInstNode(this, null);
        return myParentInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1211
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1211")
    public boolean isInInstModification() {
        boolean isInInstModification_value = getParent().Define_isInInstModification(this, null);
        return isInInstModification_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1992
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1992")
    public String instClassNamePrefix(boolean sup) {
        String instClassNamePrefix_boolean_value = getParent().Define_instClassNamePrefix(this, null, sup);
        return instClassNamePrefix_boolean_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2223")
    public boolean enclosedBy(InstNode node) {
        boolean enclosedBy_InstNode_value = getParent().Define_enclosedBy(this, null, node);
        return enclosedBy_InstNode_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2246
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2246")
    public InstNode instNodeParent() {
        InstNode instNodeParent_value = getParent().Define_instNodeParent(this, null);
        return instNodeParent_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2287
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2287")
    public InstComponentDecl containingInstComponent() {
        InstComponentDecl containingInstComponent_value = getParent().Define_containingInstComponent(this, null);
        return containingInstComponent_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2473
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2473")
    public InstNode containingInstNode() {
        InstNode containingInstNode_value = getParent().Define_containingInstNode(this, null);
        return containingInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:107
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:107")
    public InstContext parentExpEvaluator() {
        InstContext parentExpEvaluator_value = getParent().Define_parentExpEvaluator(this, null);
        return parentExpEvaluator_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:852
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:852")
    public String findLibraryName() {
        String findLibraryName_value = getParent().Define_findLibraryName(this, null);
        return findLibraryName_value;
    }
    /**
     * Any closest ancestor instClass but not stopping at InstComponents and returning it's class
     * as opposed to enclosingInstClassDecl().
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:892
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:892")
    public InstClassDecl containingInstClass() {
        InstClassDecl containingInstClass_value = getParent().Define_containingInstClass(this, null);
        return containingInstClass_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:896
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:896")
    public InstNode enclosingInstNode() {
        InstNode enclosingInstNode_value = getParent().Define_enclosingInstNode(this, null);
        return enclosingInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221")
    public boolean inProtectedComponent() {
        boolean inProtectedComponent_value = getParent().Define_inProtectedComponent(this, null);
        return inProtectedComponent_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:531
     * @apilevel internal
     */
    public int Define_retrieveArrayCompNdims(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return ndims() - 1;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:531
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveArrayCompNdims
     */
    protected boolean canDefine_retrieveArrayCompNdims(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     * @apilevel internal
     */
    public boolean Define_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIterExp
     */
    protected boolean canDefine_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906
     * @apilevel internal
     */
    public Size Define_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return s;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:906
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandSizeForIterExp
     */
    protected boolean canDefine_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1923
     * @apilevel internal
     */
    public int Define_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 0;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1923
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpDepth
     */
    protected boolean canDefine_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     */
    public boolean Define_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1565
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inDeadIfBranch
     */
    protected boolean canDefine_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418
     * @apilevel internal
     */
    public boolean Define_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2418
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isNormalEquation
     */
    protected boolean canDefine_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3159
     * @apilevel internal
     */
    public boolean Define_inRecordConstructor(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3159
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordConstructor
     */
    protected boolean canDefine_inRecordConstructor(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425
     * @apilevel internal
     */
    public FFunctionDecl Define_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1425
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingFFunctionDecl
     */
    protected boolean canDefine_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
        int childIndex = this.getIndexOfChild(_callerNode);
        return new ArrayList<FFunctionCallLeft>();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     */
    public String Define_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1571
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcGeneratedVarName
     */
    protected boolean canDefine_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1824
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhen
     */
    protected boolean canDefine_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1415
     * @apilevel internal
     */
    public boolean Define_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:205
     * @apilevel internal
     */
    public boolean Define_inAssert(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:205
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAssert
     */
    protected boolean canDefine_inAssert(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:210
     * @apilevel internal
     */
    public boolean Define_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:210
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIfTestWithoutConnect
     */
    protected boolean canDefine_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:222
     * @apilevel internal
     */
    public boolean Define_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:222
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForAttributeOnOperatorRecordDeclarationMember
     */
    protected boolean canDefine_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:230
     * @apilevel internal
     */
    public boolean Define_isForOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     * @apilevel internal
     */
    public boolean Define_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:445
     * @apilevel internal
     */
    public FAbstractEquation Define_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:498
     * @apilevel internal
     */
    public InstComponentDecl Define_myTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return unknownInstComponentDecl();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:504
     * @apilevel internal
     */
    public InstComponentDecl Define_parentTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return unknownInstComponentDecl();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:504
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentTargetComponent
     */
    protected boolean canDefine_parentTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:580
     * @apilevel internal
     */
    public InstComponentDecl Define_errorEnclosingComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return containingInstComponent();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1411
     * @apilevel internal
     */
    public boolean Define_canBeReplacedForMe(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return node.canBeReplacedFor(this);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1411
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canBeReplacedForMe
     */
    protected boolean canDefine_canBeReplacedForMe(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1432
     * @apilevel internal
     */
    public boolean Define_canBeReplacedInHelper(ASTNode _callerNode, ASTNode _childNode, InstNode ancestor) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return (ancestor != this) && canBeReplacedIn(ancestor);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1432
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canBeReplacedInHelper
     */
    protected boolean canDefine_canBeReplacedInHelper(ASTNode _callerNode, ASTNode _childNode, InstNode ancestor) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1572
     * @apilevel internal
     */
    public boolean Define_isWithin(ASTNode _callerNode, ASTNode _childNode, InstClassDecl icd) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isOfInstClassDecl(icd);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1773
     * @apilevel internal
     */
    public FWhenEquation Define_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1773
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myWhen
     */
    protected boolean canDefine_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1783
     * @apilevel internal
     */
    public FWhenEquation Define_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return last;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1783
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findTopWhen
     */
    protected boolean canDefine_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:178
     * @apilevel internal
     */
    public ASTNode Define_nameCollisionScope(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:178
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute nameCollisionScope
     */
    protected boolean canDefine_nameCollisionScope(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:295
     * @apilevel internal
     */
    public InstModification Define_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElementInstModificationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:297
            int i = _callerNode.getIndexOfChild(_childNode);
            return getElementInstModification(i);
        }
        else {
            return getParent().Define_parentInstModification(this, _callerNode);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:786
     * @apilevel internal
     */
    public boolean Define_inCardinality(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:786
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inCardinality
     */
    protected boolean canDefine_inCardinality(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853
     * @apilevel internal
     */
    public boolean Define_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpMustBeScalar
     */
    protected boolean canDefine_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1536
     * @apilevel internal
     */
    public boolean Define_inExternalObject(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isExternalObject();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1536
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inExternalObject
     */
    protected boolean canDefine_inExternalObject(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1824
     * @apilevel internal
     */
    public FExp Define_splitBindingFExp(ASTNode _callerNode, ASTNode _childNode, FExp fe, InstNode node, int dims) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return (node == this) ? fe : splitBindingFExp(fe, node, dims);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2073
     * @apilevel internal
     */
    public boolean Define_inModWithEach(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2073
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inModWithEach
     */
    protected boolean canDefine_inModWithEach(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2165
     * @apilevel internal
     */
    public boolean Define_isOnPrimitiveTypeDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2165
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isOnPrimitiveTypeDecl
     */
    protected boolean canDefine_isOnPrimitiveTypeDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2176
     * @apilevel internal
     */
    public int Define_modificationLevel(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myModificationLevel;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2176
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute modificationLevel
     */
    protected boolean canDefine_modificationLevel(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2304
     * @apilevel internal
     */
    public boolean Define_expandSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandSize
     */
    protected boolean canDefine_expandSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:49
     * @apilevel internal
     */
    public InstComponentDecl Define_lookupInnerInstComponent(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl outer, boolean firstScope) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                InstComponentDecl res = genericLookupInstComponent(outer.name()).unresolved().targetOrNull();
                if (!firstScope && res != null && res.isInner()) {
                    return res;
                } else if (res != null && res.isOuter() && !res.isInner()) {
                    res = null;
                }
                return lookupInnerInstComponentNoLocal(outer, res);
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:49
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInnerInstComponent
     */
    protected boolean canDefine_lookupInnerInstComponent(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl outer, boolean firstScope) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:131
     * @apilevel internal
     */
    public InstClassDecl Define_lookupInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name, boolean firstScope) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                if (!firstScope) {
                    InstClassDecl icd = genericLookupInstClass(name).target();
                    if (icd != null && icd.isInner())
                        return icd;
                }
                return lookupInnerInstClass(name, false);
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:131
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInnerInstClass
     */
    protected boolean canDefine_lookupInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name, boolean firstScope) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getAnnotationExpListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:275
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:45
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return superLookupInstClass(name);
        }
        else if (_callerNode == getElementInstModificationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:44
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else if (_callerNode == getFAbstractEquationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:43
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:42
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else if (_callerNode == getRedeclaredInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:41
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else if (_callerNode == getInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:40
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else {
            return getParent().Define_lookupInstClass(this, _callerNode, name);
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
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:69
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstClass(name);
        }
        else {
            return getParent().Define_lookupInstClassFromMod(this, _callerNode, name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:128
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassInChain(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:136
            int index = _callerNode.getIndexOfChild(_childNode);
            return getInstComponentDecl(index).lookupInstClass(name);
        }
        else if (_callerNode == getRedeclaredInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:134
            int index = _callerNode.getIndexOfChild(_childNode);
            return getRedeclaredInstClassDecl(index).lookupInstClass(name);
        }
        else if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:132
            int index = _callerNode.getIndexOfChild(_childNode);
            return getInstExtends(index).lookupInstClass(name);
        }
        else if (_callerNode == getInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:130
            int index = _callerNode.getIndexOfChild(_childNode);
            return getInstClassDecl(index).lookupInstClass(name);
        }
        else {
            return getParent().Define_lookupInstClassInChain(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:128
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassInChain
     */
    protected boolean canDefine_lookupInstClassInChain(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:162
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getRedeclaredInstClassDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:171
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return lookupNextRedeclareExtendsInstClass(name);
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return InstLookupResult.notFound();
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return genericLookupInstComponent(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:634
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstConstant(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return memberInstConstantFirst(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:634
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstConstant
     */
    protected boolean canDefine_lookupInstConstant(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getElementInstModificationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:756
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return memberInstComponent(name).unresolved();
        }
        else {
            return getParent().Define_lookupInstComponentInInstElement(this, _callerNode, name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:769
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstReplacingComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return memberInstComponent(name).unresolved();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:769
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstReplacingComponent
     */
    protected boolean canDefine_lookupInstReplacingComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:67
     * @apilevel internal
     */
    public FType Define_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return fUnknownType();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:67
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstForIndexType
     */
    protected boolean canDefine_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:370
     * @apilevel internal
     */
    public InstModification Define_retrieveModificationLackingEach(ASTNode _callerNode, ASTNode _childNode, Size s) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:370
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveModificationLackingEach
     */
    protected boolean canDefine_retrieveModificationLackingEach(ASTNode _callerNode, ASTNode _childNode, Size s) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:534
     * @apilevel internal
     */
    public Environment Define_myEnvironmentNoClass(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getMergedEnvironment().clone();
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
        return new Environment();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getMergedEnvironment().clone();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myEnvironment_def(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:676
     * @apilevel internal
     */
    public InstModification Define_surroundingInstModification(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:676
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingInstModification
     */
    protected boolean canDefine_surroundingInstModification(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:740
     * @apilevel internal
     */
    public InstRedeclareClassNode Define_lookupReplacingClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:741
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            {
                	for (InstClassDecl icd : getRedeclaredInstClassDecls())
                		if (icd.name().equals(name))
                			return icd;
                	return retrieveReplacingClass(name);
                }
        }
        else {
            return getParent().Define_lookupReplacingClass(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:740
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupReplacingClass
     */
    protected boolean canDefine_lookupReplacingClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:759
     * @apilevel internal
     */
    public InstNode Define_myInstNode(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getElementInstModificationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:766
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstNode();
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return this;
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:774
     * @apilevel internal
     */
    public InstNode Define_myParentInstNode(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:774
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myParentInstNode
     */
    protected boolean canDefine_myParentInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2073
     * @apilevel internal
     */
    public InstEnumClassDecl Define_myInstEnumClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2073
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstEnumClassDecl
     */
    protected boolean canDefine_myInstEnumClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2078
     * @apilevel internal
     */
    public int Define_myIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 0;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2078
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myIndex
     */
    protected boolean canDefine_myIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2223
     * @apilevel internal
     */
    public boolean Define_enclosedBy(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return (node == this) || enclosedBy(node);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2223
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosedBy
     */
    protected boolean canDefine_enclosedBy(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2246
     * @apilevel internal
     */
    public InstNode Define_instNodeParent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2246
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instNodeParent
     */
    protected boolean canDefine_instNodeParent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2473
     * @apilevel internal
     */
    public InstNode Define_containingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2473
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstNode
     */
    protected boolean canDefine_containingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2530
     * @apilevel internal
     */
    public int Define_myDimension(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 0;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2530
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myDimension
     */
    protected boolean canDefine_myDimension(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2540
     * @apilevel internal
     */
    public boolean Define_isBottomDimHelper(ASTNode _callerNode, ASTNode _childNode, int i) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return i == ndims();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2540
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBottomDimHelper
     */
    protected boolean canDefine_isBottomDimHelper(ASTNode _callerNode, ASTNode _childNode, int i) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2548
     * @apilevel internal
     */
    public boolean Define_isTopDimension(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2548
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopDimension
     */
    protected boolean canDefine_isTopDimension(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2593
     * @apilevel internal
     */
    public Index Define_parentIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2769
     * @apilevel internal
     */
    public InstClassDecl Define_inheritedOriginHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return unknownInstClassDecl();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:106
     * @apilevel internal
     */
    public InstContext Define_parentExpEvaluator(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:106
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExpEvaluator
     */
    protected boolean canDefine_parentExpEvaluator(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2001
     * @apilevel internal
     */
    public SrcAnnotatable Define_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:851
     * @apilevel internal
     */
    public String Define_findLibraryName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return libraryName();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:851
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findLibraryName
     */
    protected boolean canDefine_findLibraryName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857
     * @apilevel internal
     */
    public String Define_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
                InstLookupResult<InstClassDecl> icd = lookupInstClassQualifiedGlobal(name);
                return icd.successful() ? icd.target().dirName() : null;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute packagePath
     */
    protected boolean canDefine_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:896
     * @apilevel internal
     */
    public InstNode Define_enclosingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:896
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstNode
     */
    protected boolean canDefine_enclosingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:990
     * @apilevel internal
     */
    public InstAccess Define_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:990
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstAccess
     */
    protected boolean canDefine_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347
     * @apilevel internal
     */
    public FIfWhenEquation Define_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1347
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingIfOrElse
     */
    protected boolean canDefine_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     */
    public boolean Define_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignUse
     */
    protected boolean canDefine_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
