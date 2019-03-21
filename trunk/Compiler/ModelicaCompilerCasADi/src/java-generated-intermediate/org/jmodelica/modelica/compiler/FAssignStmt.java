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
 * A flattened assignment statement.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:608
 * @astdecl FAssignStmt : FStatement ::= Left:FAssignableExp Right:FExp;
 * @production FAssignStmt : {@link FStatement} ::= <span class="component">Left:{@link FAssignableExp}</span> <span class="component">Right:{@link FExp}</span>;

 */
public class FAssignStmt extends FStatement implements Cloneable {
    /**
     * Evaluate statement during function evaluation.
     * 
     * @param evaluator the evaluator used to evaluate the algorithm
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:67
     */
    @Override
    public int evaluate(AlgorithmEvaluator evaluator) {
        getLeft().assignToInFuncEval(evaluator, evaluator.ceval(getRight()), getRight().type());
        return EVAL_CONT;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2624
     */
    public void defSet(Set<FVariable> fvSet, Set<FVariable> fvUse) {
        defSetAdd(fvSet, fvUse, lookupFVariablesInSet(getRight().findFAccessExpsInTree()));
        defSetAdd(fvUse, fvSet, lookupFVariablesInSet(getLeft().findFAccessExpsInTree()));
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1562
     */
    private String myTempVarName;
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1429
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		p.print(getLeft(), str, indent);
		str.print(" := ");
		p.print(getRight(), str, indent);
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:341
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        if (inWhen) {
            getLeft().makeContinuousVariablesDiscrete();
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1137
     */
    public void typeCheck(ErrorCheckType checkType) {
      FType left = getLeft().type();
      FType right = getRight().type();
      if (!left.isUnknown() && !right.isUnknown()) {
          if (!left.typeCompatible(right, true)) {
              if (left.typeCompatibleExceptLengths(right)) {
                  // TODO: should use lockBranch() here as well, but no support yet
                  errorUnlessDisabled("The array sizes of right and left hand side of assignment are not compatible, " + 
                          "size of left-hand side is %s, and size of right-hand side is %s", left.size(), right.size());
              } else {
                  error("The right and left expression types of assignment are not compatible, " + 
                          "type of left-hand side is %s, and type of right-hand side is %s", left, right);
              }
          }
      }
  }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:66
     */
    public boolean flatten(Flattener f, List<FStatement> sl) {
        addForIndexRangeAsserts(f, sl);
        if (scalarizedAsFFunctionCallStmt()) {
            List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
            lefts.add(new FFunctionCallLeft(new Opt<FExp>(getLeft().flatten(f))));
            sl.add(new FFunctionCallStmt(lefts, (FAbstractFunctionCall) getRight().flatten(f)));
        } else {
            sl.add(new FAssignStmt((FAssignableExp)getLeft().flatten(f), getRight().flatten(f)));
        }
        return false;
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:338
     */
    public void enableAliasRewrite() {
		super.enableAliasRewrite();
		rewriteAlias = true;
		is$Final = false;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:354
     */
    boolean rewriteAlias = false;
    /**
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:41
     */
    public void constantFolding(VariableEvaluator evaluator) {
        getRight().constantFolding(evaluator);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1356
     */
    public void inline(AbstractFunctionInliner fi) {
        FExp right = getRight().treeCopy();
        right = getRight().dynamicFExp(right);
        right = right.replaceReferences(fi);
        FAccessExp left = getLeft().dynamicFExp(getLeft().treeCopy()).asFAccessExp();
        left.replaceReferencesInSubscripts(fi);
        right.addInliningVarsAndEqns(fi, left.scalarName(), true);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1442
     */
    public void inlinePrepare(AbstractFunctionInliner fi, List<FStatement> stmts) {
        stmts.add(fullCopy());
    }
    /**
     * @aspect AlgorithmScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:31
     */
    @Override
    public void scalarize(Scalarizer.Algorithm s) {
        
        FAssignableExp left = getLeft();
        FExp right = getRight();
        
        left.createArrayTemporaries(s);
        right.createArrayTemporaries(s);
        
        FType t = left.size().isUnknown() ? left.type() : right.type();
        if (extractTemp()) {
            s.addTempVar(this);
            CommonAccessExp temp = getRight().tempExp(tempVarName());
            t.scalarizeAssignment(s, temp, right);
            right = temp;
        }
        t.scalarizeAssignment(s, left, right);
    }
    /**
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:965
     */
    @Override
    public void diff(List<FStatement> diffed) {
        if (order() == myFAlgorithm().order() && shouldBeDifferentiated())
            diffed.add(new FDerivativeAssignStmt(getLeft().createDerExp(1).asFAccessExp(), getRight().diff("time"), order() + 1));
        diffed.add(fullCopy());
    }
    /**
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:690
     */
    @Override
    public void acceptTransform(StatementTransformer tf)     { tf.visit(this); }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:308
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		open_XML(str, indent);
		p.print(getLeft(), str, indent2);
		enclose_XML(p, str, indent2, "Expression", getRight());
		close_XML(str, indent);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:210
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        p.printPreSteps(this, str, indent);
        p.printAssign(getLeft().type(), str, indent, getLeft(), getRight());
        p.printPostSteps(this, str, indent);
    }
    /**
     * Update the supplied expressions to reflect this statement.
     * @param A MXVector with expressions
     * @param A MXVector with MX for the function variables
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:187
     */
    MXVector updateExpressionsAccordingToStatement(MXVector expressions, MXVector allVars) {
        MXVector lhsVec = new MXVector();
        MX left = getLeft().toMX();
        if (left == null) {
            throw new UnsupportedOperationException("The variable on the LHS does not exists: " + toString());
        }
        lhsVec.add(left);
        MXVector rhsVec = getRight().toMXVector();
        
        MX updatedRhsExpression = ifcasadi.substitute(rhsVec, allVars, expressions).get(0);
        int indexInAllCurrVars = findIndexOfMXInMXVector(lhsVec.get(0), allVars);
        expressions.set(indexInAllCurrVars, updatedRhsExpression);
        return expressions;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAssignStmt() {
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
        name = {"Left", "Right"},
        type = {"FAssignableExp", "FExp"},
        kind = {"Child", "Child"}
    )
    public FAssignStmt(FAssignableExp p0, FExp p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:29
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        type_reset();
        sortingAssignedNames_reset();
        sortingDependencies_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public FAssignStmt clone() throws CloneNotSupportedException {
        FAssignStmt node = (FAssignStmt) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FAssignStmt copy() {
        try {
            FAssignStmt node = (FAssignStmt) clone();
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
     * @declaredat ASTNode:68
     */
    @Deprecated
    public FAssignStmt fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public FAssignStmt treeCopyNoTransform() {
        FAssignStmt tree = (FAssignStmt) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
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
     * @declaredat ASTNode:98
     */
    public FAssignStmt treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:103
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Left child.
     * @param node The new node to replace the Left child.
     * @apilevel high-level
     */
    public void setLeft(FAssignableExp node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Left child.
     * @return The current node used as the Left child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Left")
    public FAssignableExp getLeft() {
        return (FAssignableExp) getChild(0);
    }
    /**
     * Retrieves the Left child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Left child.
     * @apilevel low-level
     */
    public FAssignableExp getLeftNoTransform() {
        return (FAssignableExp) getChildNoTransform(0);
    }
    /**
     * Replaces the Right child.
     * @param node The new node to replace the Right child.
     * @apilevel high-level
     */
    public void setRight(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Right child.
     * @return The current node used as the Right child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Right")
    public FExp getRight() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the Right child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Right child.
     * @apilevel low-level
     */
    public FExp getRightNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1557
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1557")
    public String tempVarName() {
        {
                 if (myTempVarName == null)
                     myTempVarName = calcTempVarName();
                 return myTempVarName;
             }
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1565
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1565")
    public String calcTempVarName() {
        String calcTempVarName_value = calcGeneratedVarName(FlatVariableMap.GeneratedVarType.TEMP);
        return calcTempVarName_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:266
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:266")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = getRight().type().typePromotion(getLeft().type());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:78
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:78")
    public boolean scalarizedAsFFunctionCallStmt() {
        boolean scalarizedAsFFunctionCallStmt_value = getRight().isNonVectorizedFunctionCall() && getLeft().type().isComposite() && 
                    inFunction() && !getLeft().isSlice();
        return scalarizedAsFFunctionCallStmt_value;
    }
    /**
     * Helper method to find unsupported statements in isTrivialInlinable().
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1124
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1124")
    public boolean isOkTrivialInline() {
        boolean isOkTrivialInline_value = true;
        return isOkTrivialInline_value;
    }
    /**
     * Helper method to unsupported statements in isTrivialInlinable().
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1140
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1140")
    public boolean isOkTrivialInlineInFor() {
        boolean isOkTrivialInlineInFor_value = getLeft().isOkTrivialInlineInFor();
        return isOkTrivialInlineInFor_value;
    }
    /**
     * Check if we can inline this statement.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1276
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1276")
    public boolean isInlinable() {
        boolean isInlinable_value = true;
        return isInlinable_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:139
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:139")
    public boolean extractTemp() {
        {
                if (type().isArray()) {
                    Set<FAbstractVariable> left = getLeft().usesInScalarizedExp();
                    Set<FAbstractVariable> right = getRight().usesInScalarizedExp();
                    for (FAbstractVariable fv : left) {
                        if (right.contains(fv)) {
                            return true;
                        }
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:51
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SizeAsserts", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:51")
    public ArrayList<FAssert> sizeAsserts() {
        {
                ArrayList<FAssert> a = new ArrayList<FAssert>();
                getLeft().size().sizeAsserts(a, getRight().size(), getLeft());
                getRight().size().sizeAsserts(a, getLeft().size(), getLeft());
                return a;
            }
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1061
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1061")
    public int order() {
        int order_value = 0;
        return order_value;
    }
    /** @apilevel internal */
    private void sortingAssignedNames_reset() {
        sortingAssignedNames_computed = false;
        
        sortingAssignedNames_value = null;
    }
    /** @apilevel internal */
    protected boolean sortingAssignedNames_computed = false;

    /** @apilevel internal */
    protected Set<String> sortingAssignedNames_value;

    /**
     * @attribute syn
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenInitArrayStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:108")
    public Set<String> sortingAssignedNames() {
        ASTState state = state();
        if (sortingAssignedNames_computed) {
            return sortingAssignedNames_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        sortingAssignedNames_value = getLeft().sortingAssignedNames();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingAssignedNames_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingAssignedNames_value;
    }
    /** @apilevel internal */
    private void sortingDependencies_reset() {
        sortingDependencies_computed = false;
        
        sortingDependencies_value = null;
    }
    /** @apilevel internal */
    protected boolean sortingDependencies_computed = false;

    /** @apilevel internal */
    protected Set<String> sortingDependencies_value;

    /**
     * @attribute syn
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:150
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenInitArrayStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:150")
    public Set<String> sortingDependencies() {
        ASTState state = state();
        if (sortingDependencies_computed) {
            return sortingDependencies_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        sortingDependencies_value = getRight().sortingAddNamesUsed(baseSortingDependencies());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingDependencies_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingDependencies_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Assign";
        return xmlTag_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1572
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1572")
    public String calcGeneratedVarName(FlatVariableMap.GeneratedVarType gvt) {
        String calcGeneratedVarName_FlatVariableMap_GeneratedVarType_value = getParent().Define_calcGeneratedVarName(this, null, gvt);
        return calcGeneratedVarName_FlatVariableMap_GeneratedVarType_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     */
    public boolean Define_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3371
            return true;
        }
        else {
            return super.Define_isAssignedTo(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignedTo
     */
    protected boolean canDefine_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4242
     * @apilevel internal
     */
    public boolean Define_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4244
            return true;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:169
            return !scalarizedAsFFunctionCallStmt();
        }
        else {
            return super.Define_flattenFASContext(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute flattenFASContext
     */
    protected boolean canDefine_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:114
     * @apilevel internal
     */
    public boolean Define_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getLeft().size().isUnknown() || getRight().size().isUnknown();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     */
    public boolean Define_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getRightNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:695
            return false;
        }
        else if (_callerNode == getLeftNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:694
            return true;
        }
        else {
            return getParent().Define_isAssignUse(this, _callerNode);
        }
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
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:409
        if (rewriteAlias && getLeft() instanceof FAccessExp) {
            return rewriteRule0();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:409
     * @apilevel internal
     */
    private FAssignStmt rewriteRule0() {
{
            FAccessExp left = getLeft().asFAccessExp();
            if (left.myFV().isFVariable() && left.myFV().isAlias()) {
                FVariable fv = (FVariable) left.myFV();
                FAccessExp exp = fv.alias().createAccessExp();
                setLeft(exp);
                exp.setOriginalVariable(left, fv);
                setRight(fv.aliasNegatedWrap(getRight(), getRight()));
                return this;
            } else {
                rewriteAlias = false;
                return this;
            }
        }    }
    /** @apilevel internal */
    protected void collect_contributors_FStatement_sizeAssertsColl(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:38
        {
            FStatement target = (FStatement) (this);
            java.util.Set<ASTNode> contributors = _map.get(target);
            if (contributors == null) {
                contributors = new java.util.LinkedHashSet<ASTNode>();
                _map.put((ASTNode) target, contributors);
            }
            contributors.add(this);
        }
        super.collect_contributors_FStatement_sizeAssertsColl(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_sizeAssertsColl(ArrayList<FAssert> collection) {
        super.contributeTo_FStatement_sizeAssertsColl(collection);
        collection.addAll(sizeAsserts());
    }
}
