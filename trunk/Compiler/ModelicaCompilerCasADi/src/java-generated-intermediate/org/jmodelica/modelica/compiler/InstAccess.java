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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:153
 * @astdecl InstAccess : CommonAccess;
 * @production InstAccess : {@link CommonAccess};

 */
public abstract class InstAccess extends CommonAccess implements Cloneable, CommonNamePart {
    /**
     * Creates a new InstAccess with the FArraySubscripts taken from the given Index.
     * 
     * @param i  the Index specifying what array subscripts to use
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2089
     */
    public InstAccess specify(Index i) {
		return specifyEach(i, new int[1]);
	}
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2098
     */
    public InstAccess specify(Index i, boolean scalarize) {
        return specify(i);
    }
    /**
     * Create a copy with the FArraySubscripts of each part set to match the Index.
     * 
     * @param i    the Index specifying what array subscripts to use
     * @param dim  the next dimension in <code>i</code> to use, 
     * wrapped in an array so that it can be changed by the method
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2109
     */
    protected InstAccess specifyEach(Index i, int[] dim) {
		return treeCopy();
	}
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:90
     */
    public InstAccess extractRecordFExp(String suffix) {
        return copyAndAppend(suffix);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2149
     */
    public boolean isPackageConstantAccess() { return myInstComponentDecl().isPackageConstant(); }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2151
     */
    public abstract void collectAccessNames(Set<String> collectedNames);
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2254
     */
    public void collectAccessNamesInArraySubscripts(Set<String> collectedNames) {
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4135
     */
    public Map<CommonVariableDecl,CValue> collectMyEvaluationValue(Map<CommonVariableDecl,CValue> map) {
        return map;
    }
    /**
     * Evaluate an assignment with this as the left side during function evaluation.
     * 
     * @param evaluator the evaluator used to evaluate the algorithm
     * @param right     the CValue to assign
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:157
     */
    public void assignToInFuncEval(AlgorithmEvaluator evaluator, CValue right) {
        InstAccess firstPart = getFirstInstAccess();
        InstComponentDecl comp = firstPart.myInstComponentDecl();
        if (comp instanceof InstAssignable) {
            InstAssignable var = (InstAssignable) comp;
            CValue val = var.type().assignToPartInFuncEval(firstPart, var.evaluationValue(evaluator), right);
            evaluator.setEvaluationValue(var, val);
        } else if (comp.isUnknown()) {
            // Do nothing
        } else {
            throw new ConstantEvaluationException(null, "Assigning to non-assignable");
        }
    }
    /**
     * Create an access from a class name.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:336
     */
    public static InstAccess fromName(String name) {
		String[] parts = name.split("\\.");
		if (parts.length == 1) {
			return new InstParseAccess(parts[0]);
		} else {
			List<InstAccess> l = new List<InstAccess>();
			for (String part : parts)
				l.add(new InstParseAccess(part));
			return new InstDot(l);
		}
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1667
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print(name());
		if (hasFArraySubscripts())
			p.print(getFArraySubscripts(), str, indent);
	}
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:156
     */
    public InstAccessExp buildAccessContextSizeExp(FExp.SizeContextReplacer crp) {
        List<InstAccess> res = crp.buildContext();
        for (InstAccess part : allParts()) {
            if (hasFArraySubscripts()) {
                part = new InstAmbiguousArrayAccess(part.name(), part.getFArraySubscripts().copyReplaceAccess(crp));
            } else {
                part = part.treeCopy();
            }
            res.addChild(part);
        }
        return new InstAccessExp(new InstDot(res));
    }
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:189
     */
    public List<InstAccess> buildAccessContext(String name, FArraySubscripts fas) {
        List<InstAccess> res = accessContextInst();
        if (fas == null) {
            res.add(new InstAmbiguousAccess(name));
        } else {
            res.add(new InstAmbiguousArrayAccess(name, fas));
        }
        return res;
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:541
     */
    public FExp copyReplaceAccess(FExp.FunctionContextReplacer crp) {
        InstComponentDecl var = myInstComponentDecl();
        FExp arg = copyReplaceAccessParent(crp);
        if (arg == null) {
            arg = crp.get(myInstComponentDecl());
        } else {
            arg = arg.component(name());
        }
        if (arg != null) {
            return arg.cell(crp, getFArraySubscripts());
        } else {
            return null;
        }
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:97
     */
    public void complianceCheck(ErrorCheckType checkType) {
        super.complianceCheck(checkType);
        InstComponentDecl decl = myInstComponentDecl();
        if (decl.isRecord() && hasFArraySubscripts() && inFunction() && 
                !getFArraySubscripts().variability().parameterOrLess()) {
            ONLY_FMU_NON_FIXED_RECORD_ARRAY_INDEX.invoke(this);
        }
        if (decl.isExternalObject() && decl.isConstant() && (decl.inRecord() || decl.isArray())) {
            EXTERNAL_OBJECT_CONSTANT_IN_COMPOSITE.invoke(this);
        }
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:938
     */
    public void forceUsesVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        myInstComponentDecl().forceVariability(checkType, v);
        forceUsesInSubscriptsVariability(checkType, v);
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:943
     */
    public void forceUsesInSubscriptsVariability(ErrorCheckType checkType, TypePrefixVariability v) {}
    /**
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:51
     */
    public void nameCheckAmbigous(ErrorCheckType checkType) {
        if (!isExpandableConnectorMemberInConnect()) {
            InstLookupResult<InstComponentDecl> comp = myInstLookupComponent();
            InstLookupResult<InstClassDecl> cls      = myInstLookupClass();
            if (!comp.isNotFound())
                comp.problem(this, "component", qualifiedName());
            else if (!cls.isNotFound())
                cls.problem(this, "class", qualifiedName());
            else 
                comp.problem(this, "class or component", qualifiedName());
        }
    }
    /**
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:72
     */
    public void nameCheckComponentAccess(ErrorCheckType checkType) {
        //log.debug("InstComponentAccess.nameCheck(" + checkType + "): " + name() + " " + myInstComponentDecl().name());
        if (hasLookupProblem()) {
            myInstLookup().problem(this, "component", qualifiedName());
        }
        if (!inConnectClause() && !isModificationName() && isConditional()) {
            error("The component "+qualifiedName()+" is conditional: Access of conditional components is only valid in connect statements");
        }
    }
    /**
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:90
     */
    public void generateClassLookupProblems(InstLookupResult lookup, ASTNode n) {
        if (lookup.isProblem()) {
            lookup.problem(this, n.classErrorType(), n.classErrorName());
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:750
     */
    public void typeError(ErrorCheckType checkType, CommonAccessExp access) {
        typeError();
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:754
     */
    public void typeError() {
	  typeError(this);
  }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:758
     */
    protected void typeError(InstAccess top) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1550
     */
    public void typeCheck(ErrorCheckType checkType) {
      if (myInstComponentDecl().size().isUndefined() && myInstComponentDecl().inFunction() && 
              !myInstComponentDecl().isInput() && !checkType.allowIncompleteSizes()) {
          compliance("Using variables with undefined size is not supported");
      }
      super.typeCheck(checkType);
  }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1594
     */
    public void checkMixedAccessLeft(
            InstAccess right, InstAccess top, ErrorCheckType checkType, int i, int n) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1612
     */
    public void checkMixedAccessRight(
            InstClassDecl left, InstAccess top, ErrorCheckType checkType, int i, int n) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1625
     */
    public void checkMixedAccessRightForComponent(
            InstClassDecl left, InstAccess top, ErrorCheckType checkType, int i, int n) {
        String type = null;
        if (left.extendsEnum()) {
            if (!myInstComponentDecl().isEnumLiteral())
                type = "attribute of primitive with dot notation";
        } else if (left.isPackage()) {
            left.checkRestriction(checkType);
        } else if (!left.isOkPackage()) {
            type = "component in non-package class";
        }
        if (type != null) {
            top.error("Can not access " + type + ": " + top.name());
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1641
     */
    public void checkMixedAccessRight(
            InstComponentDecl left, InstAccess top, ErrorCheckType checkType, boolean array, int i, int n) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1665
     */
    public void checkMixedAccessRightForComponent(
            InstComponentDecl left, InstAccess top, ErrorCheckType checkType, boolean array, int i, int n) {
        if (left.isPrimitive()) {
            top.error("Can not access attribute of primitive with dot notation: " + top.name());
        }
    }
    /**
     * Connect the variables referenced in a connect or branch statement in the connection set manager.
     * 
     * @param right   the other access
     * @param prefix  the prefix to use when flattening names
     * @param csm     the connection set manager to add variables to
     * @param source  the originating connect or branch statement
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1117
     */
    public void connectTo(InstAccess right, FAccess prefix, ConnectionSetManager csm, ConnectionEdge source) {
        
        boolean leftOutside  = isOutsideConnector();
        boolean rightOutside = right.isOutsideConnector();
        InstComponentDecl leftComp  = lookupEvaluatingIndices();
        InstComponentDecl rightComp = right.lookupEvaluatingIndices();
        
        boolean handleExpandable = !csm.isExpandableConnectorsDone();
        if (handleExpandable && (isExpandableConnectorPart() || right.isExpandableConnectorPart())) {
            if (isExpandableConnectorPart())
                csm.getExpandable().addIntroducingConnection(this, right, prefix, source);
            if (right.isExpandableConnectorPart())
                csm.getExpandable().addIntroducingConnection(right, this, prefix, source);
        } else if (handleExpandable && leftComp.isExpandableConnector()) {
            csm.getExpandable().addSpanningConnection(leftComp, rightComp, prefix, source);
        } else if (isArray() && !leftComp.isOverconstrainedConnection(rightComp)) {
            Indices leftInd = indices();
            Indices rightInd = right.indices();
            Iterator<Index> leftIter = leftInd.iterator();
            Iterator<Index> rightIter = rightInd.iterator();
            while (leftIter.hasNext() && rightIter.hasNext()) {
                Index leftI = leftInd.translate(leftIter.next());
                Index rightI = rightInd.translate(rightIter.next());
                InstComponentDecl leftCompCell = leftComp.findCell(leftI, leftI.ndims() - leftComp.ndims());
                InstComponentDecl rightCompCell = rightComp.findCell(rightI, rightI.ndims() - rightComp.ndims());
                FAccess leftCellName  = leftCompCell.getFAccess(leftI);
                FAccess rightCellName = rightCompCell.getFAccess(rightI);
                ConnectionSetEntry leftEntry = ConnectionSetEntry.create(leftCompCell, leftOutside, leftCellName);
                ConnectionSetEntry rightEntry = ConnectionSetEntry.create(rightCompCell, rightOutside, rightCellName);
                leftCompCell.connectTo(leftEntry, rightEntry, prefix, csm, source, true);
            }
        } else {
            FAccess leftName  = leftComp.getFAccess(index());
            FAccess rightName = rightComp.getFAccess(right.index());
            ConnectionSetEntry leftEntry = ConnectionSetEntry.create(leftComp, leftOutside, leftName);
            ConnectionSetEntry rightEntry = ConnectionSetEntry.create(rightComp, rightOutside, rightName);
            leftComp.connectTo(leftEntry, rightEntry, prefix, csm, source, true);
        }
    }
    /**
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3087
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
        if (isExpandableConnectorPart())
            csm.getExpandable().addUse(this);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:413
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        super.flattenUsedFuncsAndEnums(f);
        if (myInstComponentDecl().isRecord() && myInstComponentDecl().isConstant() && !hasUnknownIndices() && isTopInstAccess()) 
            ((InstAssignable) myInstComponentDecl()).flattenMyType(f);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:454
     */
    public void flattenMyRecord(Flattener f) {
        myInstClassDecl().flattenRecord(f);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2768
     */
    public FRecordAccess flattenRecordName() {
        return new FRecordAccess(myInstClassDecl().qualifiedName());
    }
    /**
     * Move any non-parameter indices to given list and replace with colon.
     * Copy any parameter non-scalar indices to given list.
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:83
     */
    public void extractNonParameterIndices(List<FSubscript> sub, TypePrefixVariability v) {}
    /**
     * Flatten this access.
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:119
     */
    public FAccess flatten(Flattener f) {
        return getFAccess().copyAndAddFas(flattenFAS(f));
    }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:147
     */
    public FArraySubscripts flattenFAS(Flattener f) {
        boolean arr = isArray();
        if ((!arr && hasFArraySubscripts()) || (arr && flattenFASContext())) {
            return allFArraySubscripts().get(0).flatten(f);
        } else {
            return null;
        }
    }
    /**
     * Lookup the specific array component corresponding to this access, using current ceval() 
     * value for indices. If no specific component can be found or this access is not to a specific 
     * element, the component for the array is returned.
     * 
     * @param array  the component node for the array
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:456
     */
    public InstComponentDecl lookupArrayElement(InstComponentDecl array) {
        return array;
    }
    /**
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:483
     */
    public InstLookupResult<InstComponentDecl> lookupArrayElement(InstLookupResult<InstComponentDecl> array) {
        if (array.isError()) {
            return array;
        }
        
        InstComponentDecl icd = lookupArrayElement(array.target());
        if (icd == array.target()) {
            return array;
        }
        return array.create(icd);
    }
    /**
     * Lookup component, re-evaluating any array accesses except in last component.
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:498
     */
    public InstComponentDecl lookupEvaluatingIndices() {
        InstAccess cur = getFirstInstAccess();
        InstComponentDecl icd = cur.myInstComponentDecl();
        
        InstAccess next = cur.getNextInstAccess();
        while (next != null && icd != null && !icd.isUnknown()) {
            icd = cur.lookupArrayElement(icd);
            icd = icd.memberInstComponent(next.name()).targetOrNull();
            cur = next;
            next = next.getNextInstAccess();
        }
        icd = cur.lookupArrayElement(icd);
        
        return (icd == null) ? unknownInstComponentDecl() : icd;
    }
    /**
     * Copy this access, append a name part to the copy and return the copy.
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1080
     */
    public InstDot copyAndAppend(String id) {
    	InstAccess left = fullCopy();
    	InstAccess right = createPartToAppend(id);
        return new InstDot(new List<InstAccess>().add(left).add(right));
    }
    /**
     * Create an InstAccess suitable for appending to this access.
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1095
     */
    public InstAccess createPartToAppend(String id) {
    	return new InstParseAccess(id);
    }
    /**
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1872
     */
    abstract public InstAccess copy();
    /**
     * @declaredat ASTNode:1
     */
    public InstAccess() {
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
    }
    /** @apilevel internal 
     * @declaredat ASTNode:27
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:31
     */
    public InstAccess clone() throws CloneNotSupportedException {
        InstAccess node = (InstAccess) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:42
     */
    @Deprecated
    public abstract InstAccess fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:50
     */
    public abstract InstAccess treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:58
     */
    public abstract InstAccess treeCopy();
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:718
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:718")
    public abstract String name();
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:745
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:745")
    public abstract String qualifiedName();
    /**
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356")
    public int ndims() {
        int ndims_value = 0;
        return ndims_value;
    }
    /**
     * Get the expanded FArraySubscripts of each part of this access.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:446")
    public java.util.List<FArraySubscripts> allFArraySubscripts() {
        java.util.List<FArraySubscripts> allFArraySubscripts_value = Arrays.<FArraySubscripts>asList(new FArrayLitSubscripts());
        return allFArraySubscripts_value;
    }
    /**
     * Get the expanded FArraySubscripts of each part of the fully qualified version of this access.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:404
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:404")
    public java.util.List<FArraySubscripts> qualifiedAllFArraySubscripts() {
        java.util.List<FArraySubscripts> qualifiedAllFArraySubscripts_value = concatenation(surroundingFArraySubscripts(), allFArraySubscripts());
        return qualifiedAllFArraySubscripts_value;
    }
    /**
     * Get the array sizes.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1083
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1083")
    public Size size() {
        Size size_value = isArray() ? arraySize() : Size.SCALAR;
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102")
    public Size arraySize() {
        Size arraySize_value = Size.SCALAR;
        return arraySize_value;
    }
    /**
     * check if an access is an array expression.
     * 
     * @return True if array dimension > 0 else false
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1197
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1197")
    public boolean isArray() {
        boolean isArray_value = ndims()>0;
        return isArray_value;
    }
    /**
     * Get the set of all array indices of an instance array access. 
     * 
     * @return An Indices object containing all indices in each array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2261")
    public Indices indices() {
        Indices indices_value = Indices.createFromFas(qualifiedAllFArraySubscripts());
        return indices_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2693
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2693")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = ceval(evaluator, Index.NULL);
        return ceval_VariableEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2694
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2694")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        CValue ceval_VariableEvaluator_Index_value = unknownCValue();
        return ceval_VariableEvaluator_Index_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4645
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4645")
    public boolean isCircular(int dim) {
        boolean isCircular_int_value = myInstComponentDecl().isCircular(dim);
        return isCircular_int_value;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4675
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4675")
    public boolean isUnknownSizeVarUse() {
        boolean isUnknownSizeVarUse_value = myInstComponentDecl().isUnknownSizeVar();
        return isUnknownSizeVarUse_value;
    }
    /**
     * Get the next part in the name this is a part of, or null if this is the last part. 
     * @attribute syn
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:210
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluationStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:210")
    public CommonNamePart nextNamePart() {
        CommonNamePart nextNamePart_value = getNextInstAccess();
        return nextNamePart_value;
    }
    /**
     * @attribute syn
     * @aspect AccessDims
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Dims.jrag:20
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessDims", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Dims.jrag:20")
    public int declarationDims() {
        int declarationDims_value = 0;
        return declarationDims_value;
    }
    /**
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3729
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3729")
    public boolean isIndependent(Set<? extends CommonVariableDecl> set) {
        {
                return !set.contains(myInstComponentDecl());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:165
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:165")
    public boolean isForIndex() {
        boolean isForIndex_value = myInstComponentDecl().isForIndex();
        return isForIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalObjectBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalObjectBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:377")
    public FExternalStmt myFExternalStmt() {
        FExternalStmt myFExternalStmt_value = myInstClassDecl().findFunctionExternal().getFAlgorithm().getFExternalStmt();
        return myFExternalStmt_value;
    }
    /**
     * The number of name parts.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:167
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:167")
    public int numParts() {
        int numParts_value = 1;
        return numParts_value;
    }
    /**
     * Check if this use has any expression or colon array subscripts. 
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:495
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:495")
    public boolean hasNonLiteralSubscripts() {
        boolean hasNonLiteralSubscripts_value = false;
        return hasNonLiteralSubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:20
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:20")
    public Size declarationSize() {
        Size declarationSize_value = Size.SCALAR;
        return declarationSize_value;
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:221
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:221")
    public List<InstAccess> buildAccessContext() {
        List<InstAccess> buildAccessContext_value = buildAccessContext(name(), accessContextFAS());
        return buildAccessContext_value;
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:224
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:224")
    public FArraySubscripts accessContextFAS() {
        {
                FArraySubscripts res = null;
                if (declarationDims() > 0) {
                    for (FArraySubscripts fas : allFArraySubscripts()) {
                        res = fas.buildAccessContext();
                    }
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:748
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:748")
    public FType type() {
        {
                if (myInstComponentDecl().isAssignable()) {
                    InstAssignable ip = (InstAssignable) myInstComponentDecl();
                    if (ip.type().isRecord()) {
                        CommonType t = ip.commonType();
                        int ndimsWithoutFAS = ndims() + (hasFArraySubscripts() ? getFArraySubscripts().ndims() - getFArraySubscripts().accessNdims() : 0);
                        // Using expand here is insufficient for record arrays where the elements have different sizes.
                        // Very difficult to fix here, should be fixed in CommonAccessExp.type() instead.
                        t = t.expand(size().contractRight(ndimsWithoutFAS - ip.ndims()));
                        try {
                            t = t.cell(index()).asFType();
                        } catch (ConstantEvaluationException e) {
                            t = ndims() > 0 ? t.arrayType(size()) : t.scalarType();
                        }
                        return t.asFType();
                    } else {
                        return ip.type().sizedType(size());
                    }
                } else if (myInstClassDecl().isEnum()) {
                    return myInstClassDecl().enumType();
                } else if (myInstClassDecl().isBoolean()) {
                    return myInstClassDecl().fBooleanType(size());
                } else {
                    return fUnknownType();
                }
        	}
    }
    /**
     * If this is an instance tree access, return set containing accessed var, otherwise empty set.
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:570
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:570")
    public Set<InstComponentDecl> accessedVarSet() {
        Set<InstComponentDecl> accessedVarSet_value = Collections.singleton(myInstComponentDecl());
        return accessedVarSet_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:82
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:82")
    public boolean isConditional() {
        boolean isConditional_value = myInstComponentDecl().hasConditionalAttribute();
        return isConditional_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:905
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:905")
    public boolean isInstAccess() {
        boolean isInstAccess_value = true;
        return isInstAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:915
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:915")
    public InstAccess asInstAccess() {
        InstAccess asInstAccess_value = this;
        return asInstAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:923
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:923")
    public boolean isAccessToStream() {
        boolean isAccessToStream_value = myInstComponentDecl().isStream();
        return isAccessToStream_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1106")
    public boolean isComponentSizeClass() {
        boolean isComponentSizeClass_value = myInstClassDecl().isComponentSizeClass();
        return isComponentSizeClass_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1784
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1784")
    public boolean isComponentReference(Criteria<InstComponentDecl> criteria) {
        boolean isComponentReference_Criteria_InstComponentDecl__value = criteria.test(myInstComponentDecl());
        return isComponentReference_Criteria_InstComponentDecl__value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1172
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1172")
    public Index index() {
        Index index_value = hasFArraySubscripts() ?
                    getFArraySubscripts().createIndex() :
                    Index.NULL;
        return index_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1286
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1286")
    public boolean isOutsideConnector() {
        boolean isOutsideConnector_value = getFirstInstAccess().myInstComponentDecl().isConnector();
        return isOutsideConnector_value;
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3154")
    public boolean isExpandableConnectorPart() {
        boolean isExpandableConnectorPart_value = false;
        return isExpandableConnectorPart_value;
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3160
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3160")
    public InstComponentDecl findReferencedExpandableConnector() {
        InstComponentDecl findReferencedExpandableConnector_value = null;
        return findReferencedExpandableConnector_value;
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3178")
    public InstAccess findExpandableMemberPart(InstComponentDecl expandable) {
        InstAccess findExpandableMemberPart_InstComponentDecl_value = null;
        return findExpandableMemberPart_InstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965")
    public InstAccess splitArrayAccess(int index) {
        InstAccess splitArrayAccess_int_value = this;
        return splitArrayAccess_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:46")
    public boolean isNonAssignableArray() {
        boolean isNonAssignableArray_value = !myInstComponentDecl().isAssignable() && isArray();
        return isNonAssignableArray_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:140")
    public FAccess getFAccess() {
        {
                throw new InternalCompilerError("getFAccess() not implemented for class '" + getClass().getName() + "'");
            }
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:261")
    public boolean flattenAsGlobalAccess() {
        boolean flattenAsGlobalAccess_value = topInstAssignable().flattenAsGlobalVariable() || 
                    (inFunction() && topInstAssignable().flattenAsGlobalVariableFromFunction());
        return flattenAsGlobalAccess_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:320
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:320")
    public InstAssignable topInstAssignable() {
        InstAssignable topInstAssignable_value = (InstAssignable) myInstComponentDecl();
        return topInstAssignable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:324")
    public boolean hasUnknownIndices() {
        boolean hasUnknownIndices_value = hasFArraySubscripts() && getFArraySubscripts().hasUnknownIndices();
        return hasUnknownIndices_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:326
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:326")
    public InstLookupResult<InstClassDecl> qualifiedLookupInstClass(String name) {
        {
                InstLookupResult<InstClassDecl> res = qualifiedLookupInstClassUnconstrained(name);
                if (res.successful()) { // TODO: limit to only replaceable and replaced components and their children?
                    InstNode constr = lookupConstrainingInstNode();
                    if (constr != null && !constr.memberInstClass(name).successful())
                        return InstLookupResult.<InstClassDecl>constrained(res, closestConstrainingDecl());
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:336
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:336")
    public InstLookupResult<InstClassDecl> qualifiedLookupInstClassUnconstrained(String name) {
        InstLookupResult<InstClassDecl> qualifiedLookupInstClassUnconstrained_String_value = InstLookupResult.notFound();
        return qualifiedLookupInstClassUnconstrained_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:354
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:354")
    public InstClassDecl lookupConstrainingInstClassHelper(InstAccess part, String name) {
        {
                InstLookupResult<InstClassDecl> res;
                if (part == null) {
                    res = lookupInstClass(name);
                } else {
                    InstNode parent = part.lookupConstrainingInstNode();
                    res = (parent != null) ? parent.memberInstClass(name) : InstLookupResult.<InstClassDecl>notFound();
                }
                if (!res.successful())
                    return null;
                InstClassDecl icd = res.target().resolveLib();
                if (!icd.hasInstConstrainingClass() || !icd.isReplaceable())
                    return icd;
                return (InstClassDecl) icd.getInstConstrainingClass().getInstNode();
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:571
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:571")
    public InstClassDecl myInstClassDecl() {
        InstClassDecl myInstClassDecl_value = unknownInstClassDecl();
        return myInstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:589
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:589")
    public InstLookupResult<InstClassDecl> myInstLookupClass() {
        InstLookupResult<InstClassDecl> myInstLookupClass_value = lookupInstClass(name());
        return myInstLookupClass_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:359
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:359")
    public InstLookupResult<InstComponentDecl> qualifiedLookupInstComponent(String name) {
        {
                InstLookupResult<InstComponentDecl> res = qualifiedLookupInstComponentUnconstrained(name);
                if (res.successful()) { // TODO: limit to only replaceable and replaced components and their children?
                    InstNode constr = lookupConstrainingInstNode();
                    if (constr != null && !constr.memberInstComponent(name).successful())
                        return InstLookupResult.<InstComponentDecl>constrained(res, closestConstrainingDecl());
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:369
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:369")
    public InstLookupResult<InstComponentDecl> qualifiedLookupInstComponentUnconstrained(String name) {
        InstLookupResult<InstComponentDecl> qualifiedLookupInstComponentUnconstrained_String_value = InstLookupResult.notFound();
        return qualifiedLookupInstComponentUnconstrained_String_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:378
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:378")
    public InstNode lookupConstrainingInstNode() {
        InstNode lookupConstrainingInstNode_value = null;
        return lookupConstrainingInstNode_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:389
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:389")
    public InstComponentDecl lookupConstrainingInstComponentHelper(InstAccess part, String name) {
        {
                InstLookupResult<InstComponentDecl> res;
                if (part == null) {
                    res = lookupInstComponent(name);
                } else {
                    InstNode parent = part.lookupConstrainingInstNode();
                    res = (parent != null) ? parent.memberInstComponent(name) : InstLookupResult.<InstComponentDecl>notFound();
                }
                if (!res.successful())
                    return null;
                InstComponentDecl icd = res.target();
                if (!icd.isReplaceable())
                    return icd;
                return icd.constrainingInstComponentDecl();
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:405")
    public InstNode closestConstrainingDecl() {
        InstNode closestConstrainingDecl_value = null;
        return closestConstrainingDecl_value;
    }
    /**
     * Check if this access has a lookup error.
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:711
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:711")
    public boolean hasLookupProblem() {
        boolean hasLookupProblem_value = false;
        return hasLookupProblem_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:718
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:718")
    public InstComponentDecl myInstComponentDecl() {
        InstComponentDecl myInstComponentDecl_value = unknownInstComponentDecl();
        return myInstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:724
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:724")
    public InstLookupResult<InstComponentDecl> myInstLookupComponent() {
        InstLookupResult<InstComponentDecl> myInstLookupComponent_value = lookupInstComponent(name());
        return myInstLookupComponent_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:726
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:726")
    public InstLookupResult<? extends InstLookupResult.Item> myInstLookup() {
        InstLookupResult<? extends InstLookupResult.Item> myInstLookup_value = myInstLookupClass();
        return myInstLookup_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:732
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:732")
    public InstComponentDecl myInstComponentElement() {
        InstComponentDecl myInstComponentElement_value = unknownInstComponentDecl();
        return myInstComponentElement_value;
    }
    /**
     * @attribute syn
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:157")
    public FRecordType recordType() {
        FRecordType recordType_value = myInstClassDecl().recordType();
        return recordType_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:548
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:548")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = myInstComponentDecl().variability().combine(indexVariability());
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect InstExpVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:256
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstExpVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:256")
    public TypePrefixVariability indexVariability() {
        TypePrefixVariability indexVariability_value = Variability.CONSTANT;
        return indexVariability_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:113
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:113")
    public boolean isAssignable() {
        boolean isAssignable_value = myInstComponentDecl().isAssignable();
        return isAssignable_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:120")
    public boolean isUnknown() {
        boolean isUnknown_value = true;
        return isUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect Types
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:214
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Types", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:214")
    public InstNode constrainingTypeOfClass() {
        InstNode constrainingTypeOfClass_value = myInstClassDecl().constrainingInstType();
        return constrainingTypeOfClass_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:146
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:146")
    public InstLookupResult<InstClassDecl> lookupInstClassIfAccess() {
        InstLookupResult<InstClassDecl> lookupInstClassIfAccess_value = myInstLookupClass();
        return lookupInstClassIfAccess_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:170")
    public InstLookupResult<InstComponentDecl> lookupInstComponentIfAccess() {
        InstLookupResult<InstComponentDecl> lookupInstComponentIfAccess_value = myInstLookupComponent();
        return lookupInstComponentIfAccess_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:774
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:774")
    public String lastName() {
        String lastName_value = name();
        return lastName_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:822
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:822")
    public String enclosingName() {
        String enclosingName_value = "";
        return enclosingName_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:946
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:946")
    public InstAccess getLastInstAccess() {
        InstAccess getLastInstAccess_value = this;
        return getLastInstAccess_value;
    }
    /**
     * SrcAccess method for the first SrcAccess of a qualified or
     * unqualified name.
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:972
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:972")
    public InstAccess getFirstInstAccess() {
        InstAccess getFirstInstAccess_value = this;
        return getFirstInstAccess_value;
    }
    /**
     * Iterable of all parts of this access
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:984
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:984")
    public Iterable<InstAccess> allParts() {
        Iterable<InstAccess> allParts_value = Arrays.asList(this);
        return allParts_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1031
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1031")
    public boolean isTopInstAccess() {
        boolean isTopInstAccess_value = this == getTopInstAccess();
        return isTopInstAccess_value;
    }
    /**
     * Get the top node in an access (possibly qualified).
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1036
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1036")
    public InstAccess getTopInstAccess() {
        InstAccess getTopInstAccess_value = retrieveTopInstAccess(this);
        return getTopInstAccess_value;
    }
    /**
     * Get the array subscripts of the last name part.
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1055
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1055")
    public FArraySubscripts getLastFArraySubscripts() {
        FArraySubscripts getLastFArraySubscripts_value = getLastInstAccess().getFArraySubscripts();
        return getLastFArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1058
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1058")
    public FArraySubscripts getFArraySubscripts() {
        FArraySubscripts getFArraySubscripts_value = null;
        return getFArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1061
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1061")
    public boolean hasFArraySubscripts() {
        boolean hasFArraySubscripts_value = false;
        return hasFArraySubscripts_value;
    }
    /**
     * Is this an access to a component?
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1068
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1068")
    public boolean isComponentAccess() {
        boolean isComponentAccess_value = false;
        return isComponentAccess_value;
    }
    /**
     * Is this an access to a class?
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1074
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1074")
    public boolean isClassAccess() {
        boolean isClassAccess_value = false;
        return isClassAccess_value;
    }
    /**
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1114")
    public boolean isSlice() {
        {
                java.util.List<FArraySubscripts> l = allFArraySubscripts();
                int last = l.size() - 1;
                for (int i = 0; i < last; i++) {
                    if (l.get(i).accessNdims() > 0) {
                        return true;
                    }
                }
                return l.get(last).isSlice();
            }
    }
    /**
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1523
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1523")
    public boolean isDisabled() {
        boolean isDisabled_value = false;
        return isDisabled_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1607
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1607")
    public InstCallable myInstCallable() {
        InstCallable myInstCallable_value = myInstLookupCallable().target(INST_UNKNOWN_CALLABLE, this);
        return myInstCallable_value;
    }
    /**
     * @attribute syn
     * @aspect MultiDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1609
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MultiDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1609")
    public InstLookupResult<InstCallable> myInstLookupCallable() {
        InstLookupResult<InstCallable> myInstLookupCallable_value = myInstLookup().asCallable();
        return myInstLookupCallable_value;
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
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:570
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Derivatives", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:570")
    public InstDerExp createDerExp(int order) {
        {
                FExp use = new InstAccessExp(treeCopy());
                return (order == 1) ? new InstDerExp(use) : new InstHDerExp(use, order);
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:450
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:450")
    public String name_C() {
        String name_C_value = toString_C(printer_C);
        return name_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:452
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:452")
    public String toString_C(CodePrinter p) {
        String toString_C_CodePrinter_value = myInstLookupComponent().target().name_C();
        return toString_C_CodePrinter_value;
    }
    /**
     * Get the expanded FArraySubscripts for any surrounding components.
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:411
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:411")
    public ArrayList<FArraySubscripts> surroundingFArraySubscripts() {
        ArrayList<FArraySubscripts> surroundingFArraySubscripts_value = getParent().Define_surroundingFArraySubscripts(this, null);
        return surroundingFArraySubscripts_value;
    }
    /**
     * Perform constant evaluation of an access to a record member.
     * @attribute inh
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753")
    public CValue cevalRecordMember(VariableEvaluator evaluator, InstNamedAccess access) {
        CValue cevalRecordMember_VariableEvaluator_InstNamedAccess_value = getParent().Define_cevalRecordMember(this, null, evaluator, access);
        return cevalRecordMember_VariableEvaluator_InstNamedAccess_value;
    }
    /**
     * @attribute inh
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1797
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1797")
    public boolean inConnectClause() {
        boolean inConnectClause_value = getParent().Define_inConnectClause(this, null);
        return inConnectClause_value;
    }
    /**
     * @attribute inh
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209")
    public List<InstAccess> accessContextInst() {
        List<InstAccess> accessContextInst_value = getParent().Define_accessContextInst(this, null);
        return accessContextInst_value;
    }
    /**
     * @attribute inh
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SizesUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561")
    public FExp copyReplaceAccessParent(FExp.FunctionContextReplacer crp) {
        FExp copyReplaceAccessParent_FExp_FunctionContextReplacer_value = getParent().Define_copyReplaceAccessParent(this, null, crp);
        return copyReplaceAccessParent_FExp_FunctionContextReplacer_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1170")
    public boolean isModificationName() {
        boolean isModificationName_value = getParent().Define_isModificationName(this, null);
        return isModificationName_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114")
    public boolean isExpandableConnectorMemberInConnect() {
        boolean isExpandableConnectorMemberInConnect_value = getParent().Define_isExpandableConnectorMemberInConnect(this, null);
        return isExpandableConnectorMemberInConnect_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:119
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:119")
    public boolean inConnectWithExistingComponent() {
        boolean inConnectWithExistingComponent_value = getParent().Define_inConnectWithExistingComponent(this, null);
        return inConnectWithExistingComponent_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:786
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:786")
    public boolean inCardinality() {
        boolean inCardinality_value = getParent().Define_inCardinality(this, null);
        return inCardinality_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningDebug
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningDebug", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2258")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156")
    public boolean flattenFASContext() {
        boolean flattenFASContext_value = getParent().Define_flattenFASContext(this, null);
        return flattenFASContext_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:295
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:295")
    public String findTempVarName(InstComponentDecl var) {
        String findTempVarName_InstComponentDecl_value = getParent().Define_findTempVarName(this, null, var);
        return findTempVarName_InstComponentDecl_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:27
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:27")
    public InstLookupResult<InstClassDecl> lookupInstClass(String name) {
        InstLookupResult<InstClassDecl> lookupInstClass_String_value = getParent().Define_lookupInstClass(this, null, name);
        return lookupInstClass_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:151
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:151")
    public InstLookupResult<InstClassDecl> lookupInstClassFromTop(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassFromTop_String_value = getParent().Define_lookupInstClassFromTop(this, null, name);
        return lookupInstClassFromTop_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349")
    public InstClassDecl lookupConstrainingInstClass(String name) {
        InstClassDecl lookupConstrainingInstClass_String_value = getParent().Define_lookupConstrainingInstClass(this, null, name);
        return lookupConstrainingInstClass_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:317
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:317")
    public InstLookupResult<InstComponentDecl> lookupInstComponent(String name) {
        InstLookupResult<InstComponentDecl> lookupInstComponent_String_value = getParent().Define_lookupInstComponent(this, null, name);
        return lookupInstComponent_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384")
    public InstComponentDecl lookupConstrainingInstComponent(String name) {
        InstComponentDecl lookupConstrainingInstComponent_String_value = getParent().Define_lookupConstrainingInstComponent(this, null, name);
        return lookupConstrainingInstComponent_String_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413")
    public InstNode findClosestConstrainingInstNode() {
        InstNode findClosestConstrainingInstNode_value = getParent().Define_findClosestConstrainingInstNode(this, null);
        return findClosestConstrainingInstNode_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:436
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:436")
    public InstLookupResult<InstComponentDecl> localLookupInstComponent(String name) {
        InstLookupResult<InstComponentDecl> localLookupInstComponent_String_value = getParent().Define_localLookupInstComponent(this, null, name);
        return localLookupInstComponent_String_value;
    }
    /**
     * Here a few cases are classified based on their context.
     * @attribute inh
     * @aspect InstNameClassification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstNameClassification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94")
    public Kind kind() {
        Kind kind_value = getParent().Define_kind(this, null);
        return kind_value;
    }
    /**
     * Find the component that this access should be evaluated in.
     * @attribute inh
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2286
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2286")
    public InstComponentDecl containingInstComponent() {
        InstComponentDecl containingInstComponent_value = getParent().Define_containingInstComponent(this, null);
        return containingInstComponent_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976")
    public InstAccess getNextInstAccess() {
        InstAccess getNextInstAccess_value = getParent().Define_getNextInstAccess(this, null);
        return getNextInstAccess_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038")
    public InstAccess retrieveTopInstAccess(InstAccess pre) {
        InstAccess retrieveTopInstAccess_InstAccess_value = getParent().Define_retrieveTopInstAccess(this, null, pre);
        return retrieveTopInstAccess_InstAccess_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1047
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1047")
    public boolean inQualified() {
        boolean inQualified_value = getParent().Define_inQualified(this, null);
        return inQualified_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1174
     * @apilevel internal
     */
    public boolean Define_myAccessExists(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return !myInstComponentDecl().isUnknown();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1174
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myAccessExists
     */
    protected boolean canDefine_myAccessExists(ASTNode _callerNode, ASTNode _childNode) {
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:990
     * @apilevel internal
     */
    public InstAccess Define_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:990
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstAccess
     */
    protected boolean canDefine_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_collectInstAccesses(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2255
        {
            FClass target = (FClass) (myFClass());
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FClass_collectInstAccesses(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_collectInstAccesses(HashSet<InstAccess> collection) {
        super.contributeTo_FClass_collectInstAccesses(collection);
        collection.add(this);
    }
}
