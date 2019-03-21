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
 * One of the left hand side variables in a function call equation. 
 * 
 * Needed because it is allowed to leave places in the variable list empty.
 * Example: (x, , z) = func(a, b);
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:494
 * @astdecl FFunctionCallLeft : BaseNode ::= [FExp];
 * @production FFunctionCallLeft : {@link BaseNode} ::= <span class="component">[{@link FExp}]</span>;

 */
public class FFunctionCallLeft extends BaseNode implements Cloneable, LockBranch, FCompositeWriteBackNode, Named_C, TypePrintable_C {
    /**
     * Evaluate an assignment with this as the left side during function evaluation.
     * 
     * @param evaluator the evaluator used to evaluate the algorithm
     * @param right     the CValue to assign
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:79
     */
    public void assignToInFuncEval(AlgorithmEvaluator evaluator, CValue right, FType rightType) {
        if (hasFExp()) {
            getFExp().assignToInFuncEval(evaluator, right, rightType);
        }
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1922
     */
    public Iterable<FExp> flatChildFExps() {
        ArrayList<FExp> res = new ArrayList<FExp>();
        getFExp().flatChildFExps(res);
        return res;
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1458
     */
    public void typeCheck(ErrorCheckType checkType) {
        if (hasFExp() && !myOutput().isUnknown() && !type().isUnknown()) { // Avoid duplicate error
            if (getFExp() instanceof CommonAccessExp) {  // Should never be false - add check? 
                CommonAccess use = getFExp().asCommonAccess();
                FType useType = getFExp().type();
                FType outType = type();
                if (!use.isForIndex()) {
                    if (outType.size().isUnknown() && !inFunction() && !checkType.allowIncompleteSizes()) {
                        error(functionCallDecription() + ": could not evaluate array size of output " + 
                                myOutput().name());
                    } else if (!useType.typeCompatible(outType, true)) {
                        if (useType.typeCompatibleExceptLengths(outType)) {
                            if (!lockBranch(checkType))
                                errorUnlessDisabled("%s: component %s is of size %s and output %s is of size %s - they are not compatible", 
                                        functionCallDecription(), use.name(), useType.size(), myOutput().name(), outType.size());
                        } else {
                            error("%s: component %s is of type %s and output %s is of type %s - they are not compatible", 
                                    functionCallDecription(), use.name(), useType, myOutput().name(), outType);
                        }
                    }
                }
            }
        }
    }
    /**
     * @aspect FlatEquations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningEquations.jrag:123
     */
    public FFunctionCallLeft flatten(Flattener f) {
        return new FFunctionCallLeft(hasFExp() ? new Opt(getFExp().flatten(f)) : new Opt());
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:928
     */
    public void insertTempsInLHS(FClass fClass, boolean param) {
        if (hasFExp()) {
            getFExp().insertTempsInLHS(fClass, param);
        }
    }
    /**
     * Merge copies of FExps found in <code>other</code> into their respective position in <code>this</code>.
     * Add equation to <code>m</code> in case of collision.
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:188
     */
    public void merge(FClass.commonSubexpressionEliminationIfSet.CSESet m, FExp other) {
        if (hasFExp()) {
            setFExp(getFExp().merge(m, other));
        } else {
            setFExp(other.fullCopy());
        }
    }
    /**
     * Create temporary variable(s) for this access when inlining a function call that 
     * it is a left of, and return an access.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:556
     */
    public FExp createInlineVars(
            AbstractFunctionInliner fi, FExp bExp, TypePrefixVariability variability) {
        return hasFExp() ? getFExp().createInlineVars(fi, bExp, variability) : null;
    }
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:657
     */
    public boolean taggedByVProp = false;
    /**
     * @aspect VariabilityPropagationCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:683
     */
    public void cleanEquations() {
        if (taggedByVProp) {
            setFExpOpt(new Opt());
            taggedByVProp = false;
        } else if (hasFExp()){
            setFExpOpt(new Opt(getFExp().cleanEquations()));
        }
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:376
     */
    public FFunctionCallLeft scalarize(Scalarizer s) {
        if (hasFExp()) {
            return getFExp().scalarizeLeft(s);
        } else {
            return new FFunctionCallLeft();
        }
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:402
     */
    @Override
    public void createArrayTemporaries(Scalarizer s) {
        if (hasFExp()) {
            getFExp().createArrayTemporaries(s);
            if (getFExp().isSlice() && (getFExp().inFunction() && myFClass().noUnrollingInFunctions() || getFExp().extractAsUnknown())) {
                type().scalarizeAssignment((Scalarizer.Algorithm)s, (FAssignableExp)getFExp(), getFExp().tempExp());
            }
        }
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:287
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		open_XML(str, indent);
		if (hasFExp())
			p.print(getFExp(), str, p.indent(indent));
		else
			single_XML(str, p.indent(indent), "EmptyOutputArgument");
		close_XML(str, indent);
	}
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:107
     */
    public void genArgument(CodePrinter.ExecuteCodePrinter p, CodeStream str) {
        if (hasFExp()) {
            if (!getFExp().isComposite()) {
                str.print("&");
            }
            str.print(p.name(this));
        } else {
            str.print("NULL");
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:118
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (p.needsTemp(this)) {
            p.print(this, indent, type(), p.createDeclPrinter(str));
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:125
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        if (p.needsTemp(this)) {
            p.print(this, indent, type(), p.createInitSetPrinter(str));
        }
    }
    /**
     * @aspect CCodeGenFunctionIO
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:132
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        
    }
    /**
     * @aspect CodeFuncCallInOutArgPrinters
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:314
     */
    public void genWriteBackAssignment_C(CodePrinter p, CodeStream str, String indent,
            Collection<FVariable> forVariables) {
        if (p.needsTemp(this)) {
            p.printWriteBackAssignment(str, indent, this, forVariables);
        }
    }
    /**
     * @aspect CodeFuncCallInOutArgPrinters
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:360
     */
    public void genWriteBackResidual_C(CodePrinter p, CodeStream str, String indent, Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter) {
        if (hasFExp()) {
            CodePrinter.WriteBackResidualPrinter wp = printer_C.new WriteBackResidualPrinter(enumerator, forIndices, indexCounter);
            wp.print(str, indent, getFExp().type(), p.ExecStep.name(this), getFExp());
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionCallLeft() {
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
        children = new ASTNode[1];
        setChild(Opt.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FExp"},
        type = {"Opt<FExp>"},
        kind = {"Opt"}
    )
    public FFunctionCallLeft(Opt<FExp> p0) {
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
        myIndex_reset();
        myOutput_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public FFunctionCallLeft clone() throws CloneNotSupportedException {
        FFunctionCallLeft node = (FFunctionCallLeft) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public FFunctionCallLeft copy() {
        try {
            FFunctionCallLeft node = (FFunctionCallLeft) clone();
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
     * @declaredat ASTNode:67
     */
    @Deprecated
    public FFunctionCallLeft fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public FFunctionCallLeft treeCopyNoTransform() {
        FFunctionCallLeft tree = (FFunctionCallLeft) copy();
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
     * @declaredat ASTNode:97
     */
    public FFunctionCallLeft treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:102
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the optional node for the FExp child. This is the <code>Opt</code>
     * node containing the child FExp, not the actual child!
     * @param opt The new node to be used as the optional node for the FExp child.
     * @apilevel low-level
     */
    public void setFExpOpt(Opt<FExp> opt) {
        setChild(opt, 0);
    }
    /**
     * Replaces the (optional) FExp child.
     * @param node The new node to be used as the FExp child.
     * @apilevel high-level
     */
    public void setFExp(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 0);
        } else {
            setChild(Opt.EMPTY, 0);
        }
    }
    /**
     * Check whether the optional FExp child exists.
     * @return {@code true} if the optional FExp child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFExp() {
        return getFExpOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FExp child.
     * @return The FExp child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getFExp() {
        return (FExp) getFExpOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FExp child. This is the <code>Opt</code> node containing the child FExp, not the actual child!
     * @return The optional node for child the FExp child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FExp")
    public Opt<FExp> getFExpOpt() {
        return (Opt<FExp>) getChild(0);
    }
    /**
     * Retrieves the optional node for child FExp. This is the <code>Opt</code> node containing the child FExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FExp.
     * @apilevel low-level
     */
    public Opt<FExp> getFExpOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(0);
    }
    /**
     * Given that <code>val</code> is the value of this use expression, 
     * extract the part of it referring to <code>fv</code>, 
     * or <code>null</code> if none match. 
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3291")
    public CValue extractCValue(CValue val, FVariable fv) {
        CValue extractCValue_CValue_FVariable_value = hasFExp() ? getFExp().extractCValue(val, fv) : null;
        return extractCValue_CValue_FVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1909
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1909")
    public int numScalarElements() {
        {
                int res = 0;
                if (hasFExp()) {
                    for (FExp exp : flatChildFExps()) {
                        res += exp.numScalarElements();
                    }
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void myIndex_reset() {
        myIndex_computed = false;
    }
    /** @apilevel internal */
    protected boolean myIndex_computed = false;

    /** @apilevel internal */
    protected int myIndex_value;

    /**
     * Return the index of the variable assigned by this FFunctionCallLeft among 
     * all those assigned by the same FFunctionCallEquation/Stmt
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1483
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1483")
    public int myIndex() {
        ASTState state = state();
        if (myIndex_computed) {
            return myIndex_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myIndex_value = prevIndex() + (hasFExp() ? 1 : 0);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myIndex_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1488
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1488")
    public int myLastIndex() {
        int myLastIndex_value = myIndex() + (hasFExp() ? numScalarVars() - 1 : 0);
        return myLastIndex_value;
    }
    /**
     * Get the number of scalar variables assigned by this FFunctionCallLeft.
     * 
     * Only valid after scalarization.
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1495
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1495")
    public int numScalarVars() {
        int numScalarVars_value = (hasFExp() ? getFExp().numScalarVars() : 0);
        return numScalarVars_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = hasFExp() && myOutput().shouldBeDifferentiated();
        return shouldBeDifferentiated_value;
    }
    /**
     * @attribute syn
     * @aspect SizeAsserts
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SizeAsserts", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:57")
    public ArrayList<FAssert> sizeAsserts() {
        {
                ArrayList<FAssert> a = new ArrayList<FAssert>();
                if (hasFExp()) {
                    Size fs = getFExp().myFunctionCall().typeOfOutput(getParent().getIndexOfChild(this)).size();
                    fs.sizeAsserts(a, getFExp().size(), getFExp());
                    getFExp().size().sizeAsserts(a, fs, getFExp());
                }
                return a;
            }
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "OutputArgument";
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = parentXmlNamespace();
        return xmlNamespace_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1285
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1285")
    public boolean needsTemp_C() {
        boolean needsTemp_C_value = hasFExp() && getFExp().needsTemp_C();
        return needsTemp_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:30")
    public String name_C() {
        String name_C_value = getFExp().name_C();
        return name_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:32
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:32")
    public String tempName_C() {
        String tempName_C_value = getFExp().tempName_C();
        return tempName_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:19
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:19")
    public String type_C(CodePrinter p) {
        String type_C_CodePrinter_value = type().type_C(p);
        return type_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:158
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:158")
    public FExp myBackingFExp() {
        FExp myBackingFExp_value = getFExp();
        return myBackingFExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:162
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:162")
    public boolean useAlias_C() {
        boolean useAlias_C_value = getFExp().useAlias_C();
        return useAlias_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:183
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:183")
    public String alias_C(CodePrinter p) {
        String alias_C_CodePrinter_value = getFExp().alias_C(p);
        return alias_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CodeSplitter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeSplitter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196")
    public int numScalars_C() {
        int numScalars_C_value = needsTemp_C() ? type().numScalarElements() : 0;
        return numScalars_C_value;
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060")
    public Size size() {
        Size size_value = getParent().Define_size(this, null);
        return size_value;
    }
    /**
     * @attribute inh
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2324")
    public FClass myFClass() {
        FClass myFClass_value = getParent().Define_myFClass(this, null);
        return myFClass_value;
    }
    /**
     * @attribute inh
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3369
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3369")
    public boolean isAssignedTo() {
        boolean isAssignedTo_value = getParent().Define_isAssignedTo(this, null);
        return isAssignedTo_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1330")
    public String funcName() {
        String funcName_value = getParent().Define_funcName(this, null);
        return funcName_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484")
    public int prevIndex() {
        int prevIndex_value = getParent().Define_prevIndex(this, null);
        return prevIndex_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515")
    public CommonVariableDecl myOutput() {
        ASTState state = state();
        if (myOutput_computed) {
            return myOutput_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myOutput_value = getParent().Define_myOutput(this, null);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myOutput_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myOutput_value;
    }
    /** @apilevel internal */
    private void myOutput_reset() {
        myOutput_computed = false;
        
        myOutput_value = null;
    }
    /** @apilevel internal */
    protected boolean myOutput_computed = false;

    /** @apilevel internal */
    protected CommonVariableDecl myOutput_value;

    /**
     * @attribute inh
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:781
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:781")
    public FType type() {
        FType type_value = getParent().Define_type(this, null);
        return type_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:435
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:435")
    public boolean lockBranch(ErrorCheckType checkType) {
        boolean lockBranch_ErrorCheckType_value = getParent().Define_lockBranch(this, null, checkType);
        return lockBranch_ErrorCheckType_value;
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1484
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1484")
    public String functionCallDecription() {
        String functionCallDecription_value = getParent().Define_functionCallDecription(this, null);
        return functionCallDecription_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1836
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1836")
    public boolean duringFunctionInlining() {
        boolean duringFunctionInlining_value = getParent().Define_duringFunctionInlining(this, null);
        return duringFunctionInlining_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306
     * @apilevel internal
     */
    public boolean Define_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3306
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionCallLeft
     */
    protected boolean canDefine_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     */
    public boolean Define_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3311
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallLeft
     */
    protected boolean canDefine_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     */
    public boolean Define_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     */
    public boolean Define_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3373
            return isAssignedTo();
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
        if (_callerNode == getFExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4245
            return true;
        }
        else {
            return getParent().Define_useIsAssignment(this, _callerNode);
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
        if (_callerNode == getFExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:166
            return !inFunction();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:276
            return false;
        }
        else {
            return super.Define_canInlineConstant(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     */
    public boolean Define_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:128
            return true;
        }
        else {
            return super.Define_isFunctionCallIO(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallIO
     */
    protected boolean canDefine_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:690
     * @apilevel internal
     */
    public boolean Define_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
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
    /** @apilevel internal */
    protected void collect_contributors_FStatement_sizeAssertsColl(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:40
        if (hasFExp()) {
            {
                FStatement target = (FStatement) (getFExp().myFStatement());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FStatement_sizeAssertsColl(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_sizeAssertsColl(ArrayList<FAssert> collection) {
        super.contributeTo_FStatement_sizeAssertsColl(collection);
        if (hasFExp()) {
            collection.addAll(sizeAsserts());
        }
    }
}
