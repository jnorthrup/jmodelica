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
 * A flattened function call statement.
 * 
 * This covers function calls with no used return value or when using 
 * the syntax <code>(vars) := function(args);</code>. Function calls using 
 * exactly one return value are handled by FAssignStmt through FAbstractFunctionCall. 
 * (FAbstractFunctionCall inherits FExp, since it can be used in expressions).
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:624
 * @astdecl FFunctionCallStmt : FStatement ::= Left:FFunctionCallLeft* Call:FAbstractFunctionCall;
 * @production FFunctionCallStmt : {@link FStatement} ::= <span class="component">Left:{@link FFunctionCallLeft}*</span> <span class="component">Call:{@link FAbstractFunctionCall}</span>;

 */
public class FFunctionCallStmt extends FStatement implements Cloneable {
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:323
     */
    @Override
    public int evaluate(AlgorithmEvaluator evaluator) {
        CValue[] vals = getCall().evaluate(evaluator);
        ArrayList<? extends CommonVariableDecl> outputs = getCall().myCallOutputs();
        for (int i = 0, n = getNumLeft(); i < n; i++) {
            getLeft(i).assignToInFuncEval(evaluator, vals[i], outputs.get(i).type());
        }
        return EVAL_CONT;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2628
     */
    public void defSet(Set<FVariable> fvSet, Set<FVariable> fvUse) {
        defSetAdd(fvSet, fvUse, lookupFVariablesInSet(getCall().findFAccessExpsInTree()));
        for (FFunctionCallLeft left : getLefts())
            if (left.hasFExp())
                defSetAdd(fvUse, fvSet, lookupFVariablesInSet(left.getFExp().findFAccessExpsInTree()));
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1435
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		if (getNumLeft() > 0) {
			str.print("(");
			getLefts().prettyPrintWithSep(p, str, indent, ", ");
			str.print(") := ");
		}
		p.print(getCall(), str, indent);
	}
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:347
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        if (inWhen) {
            for (FFunctionCallLeft left : getLefts()) {
                if (left.hasFExp()) {
                    left.getFExp().makeContinuousVariablesDiscrete();
                }
            }
        }
    }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:94
     */
    public boolean flatten(Flattener f, List<FStatement> sl) {
        addForIndexRangeAsserts(f, sl);
        List<FFunctionCallLeft> l = new List<FFunctionCallLeft>();
        for (FFunctionCallLeft a : getLefts())
            l.add(a.flatten(f));
        sl.add(new FFunctionCallStmt(l, (FAbstractFunctionCall) getCall().flatten(f)));
        return false;
    }
    /**
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:45
     */
    public void constantFolding(VariableEvaluator evaluator) {
        for (FExp childExp : getCall().childFExps()) {
            childExp.constantFolding(evaluator);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1365
     */
    public void inline(AbstractFunctionInliner fi) {
        // Temporarily replace lefts with scalarized versions
        List<FFunctionCallLeft> oldLefts = getLefts();
        List<FFunctionCallLeft> newLefts = new List<FFunctionCallLeft>();
        for (FFunctionCallLeft left : oldLefts)
            newLefts.add(left.scalarize(fi.scalarizer()));
        setLeftList(newLefts);
        newLefts.clearScalarized();
        
        // Scalarize and replace references
        FExp call = getCall().scalarizeExp(fi.scalarizer());
        call = getCall().dynamicFExp(call);
        call.clearScalarized();
        call = call.replaceReferences(fi);
        
        fi.addVarsAndFCEqn(getLefts(), (FAbstractFunctionCall) call);
        
        // Restore old left list
        setLeftList(oldLefts);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1446
     */
    public void inlinePrepare(AbstractFunctionInliner fi, List<FStatement> stmts) {
        if (!getCall().isIgnored())
            stmts.add(fullCopy());
    }
    /**
     * @aspect AlgorithmScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:50
     */
    @Override
    public void scalarize(Scalarizer.Algorithm s) {
        if (getCall().isOperatorWithoutOutputs()) {
            createArrayTemporaries(s);
            getCall().scalarizeOperatorWithoutOutputs(s);
        } else {
            getCall().createArrayTemporaries(s);
            getLefts().createArrayTemporaries(s);
        }
    }
    /**
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:985
     */
    @Override
    public void diff(List<FStatement> diffed) {
        if (order() == myFAlgorithm().order() && shouldBeDifferentiated()) {
            List<FFunctionCallLeft> lefts = new List<FFunctionCallLeft>();
            for (FFunctionCallLeft l : getLefts()) {
                Opt<FExp> lopt = l.hasFExp() ? new Opt<FExp>(l.getFExp().diff("time")) : new Opt<FExp>();
                lefts.add(new FFunctionCallLeft(lopt));
            }
            FExp diffedCall = getCall().diff("time");
            diffed.add(new FDerivativeFunctionCallStmt(lefts, (FAbstractFunctionCall) diffedCall, order() + 1));
        }
        diffed.add(fullCopy());
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:422
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		if (!getCall().isIgnored()) {
			FFunctionCall call = (FFunctionCall)this.getCall();
			String tag = this.xmlTag();
			String namespace = "fun";
			
			str.println(indent + "<" + namespace + ":" + tag  + ">");
			
			for (FFunctionCallLeft f : this.getLeftList()){
				
				str.println(indent + "\t<" + namespace + ":OutputArgument>");
				
				if(!f.hasFExp()){
					str.println(indent + "\t\t<" + namespace + ":EmptyOutputArgument/>");
				}else{
					f.getFExp().prettyPrint_XML(str,p.indent(indent+"\t"));
				}
				
				str.println(indent + "\t</" + namespace + ":OutputArgument>");
			}
			
			call.prettyPrint_XML(str,p.indent(indent+"\t"));
		
			str.println(indent + "</" + namespace + ":" + tag  + ">");
		}
	}
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:200
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        if (!getCall().isIgnored()) {
            p.printPreSteps(this, str, indent);
            for (FFunctionCallLeft l : getLefts()) {
                l.genWriteBackAssignment_C(p, str, indent, null);
            }
        }
    }
    /**
     * Update the supplied expressions to reflect this statement.
     * @param A MXVector with expressions
     * @param A MXVector with MX for the function variables
     * @return A MXVector
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:157
     */
    MXVector updateExpressionsAccordingToStatement(MXVector expressions, MXVector allVars) {   
        if (getCall().isIgnored()) {
            return expressions;
        }
        if (isIgnoredForCasADi()) {
            System.err.println("Warning: Ignored statement:\n" + this);
            return expressions;
        }
        MXVector lhsVec = new MXVector();
        for (FFunctionCallLeft fleft : getLefts()) {
            if (fleft.hasFExp()) {
                MXVector fleftExpAsMXVex = fleft.getFExp().toMXVector();
                for (int i = 0; i < fleftExpAsMXVex.size(); ++i) {
                    lhsVec.add(fleftExpAsMXVex.get(i));
                }
            }
        }
        MXVector updatedRhsExpressions = ifcasadi.substitute(getCall().toMXVector(), allVars, expressions);
        for (int i = 0; i < lhsVec.size(); ++i) {
            expressions.set(findIndexOfMXInMXVector(lhsVec.get(i), allVars), updatedRhsExpressions.get(i));    
        }
        return expressions;
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:665
     */
    public boolean isIgnoredForCasADi() {
        // Ignore things that we don't support right now, such as asserts
        return getNumLeft() == 0;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionCallStmt() {
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
        name = {"Left", "Call"},
        type = {"List<FFunctionCallLeft>", "FAbstractFunctionCall"},
        kind = {"List", "Child"}
    )
    public FFunctionCallStmt(List<FFunctionCallLeft> p0, FAbstractFunctionCall p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:24
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:30
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:34
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        type_reset();
        sortingAssignedNames_reset();
        sortingDependencies_reset();
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
    public FFunctionCallStmt clone() throws CloneNotSupportedException {
        FFunctionCallStmt node = (FFunctionCallStmt) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public FFunctionCallStmt copy() {
        try {
            FFunctionCallStmt node = (FFunctionCallStmt) clone();
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
    public FFunctionCallStmt fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public FFunctionCallStmt treeCopyNoTransform() {
        FFunctionCallStmt tree = (FFunctionCallStmt) copy();
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
     * @declaredat ASTNode:99
     */
    public FFunctionCallStmt treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:104
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Left list.
     * @param list The new list node to be used as the Left list.
     * @apilevel high-level
     */
    public void setLeftList(List<FFunctionCallLeft> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the Left list.
     * @return Number of children in the Left list.
     * @apilevel high-level
     */
    public int getNumLeft() {
        return getLeftList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Left list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Left list.
     * @apilevel low-level
     */
    public int getNumLeftNoTransform() {
        return getLeftListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Left list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Left list.
     * @apilevel high-level
     */
    public FFunctionCallLeft getLeft(int i) {
        return (FFunctionCallLeft) getLeftList().getChild(i);
    }
    /**
     * Check whether the Left list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasLeft() {
        return getLeftList().getNumChild() != 0;
    }
    /**
     * Append an element to the Left list.
     * @param node The element to append to the Left list.
     * @apilevel high-level
     */
    public void addLeft(FFunctionCallLeft node) {
        List<FFunctionCallLeft> list = (parent == null) ? getLeftListNoTransform() : getLeftList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addLeftNoTransform(FFunctionCallLeft node) {
        List<FFunctionCallLeft> list = getLeftListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Left list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setLeft(FFunctionCallLeft node, int i) {
        List<FFunctionCallLeft> list = getLeftList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Left list.
     * @return The node representing the Left list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Left")
    public List<FFunctionCallLeft> getLeftList() {
        List<FFunctionCallLeft> list = (List<FFunctionCallLeft>) getChild(0);
        return list;
    }
    /**
     * Retrieves the Left list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Left list.
     * @apilevel low-level
     */
    public List<FFunctionCallLeft> getLeftListNoTransform() {
        return (List<FFunctionCallLeft>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the Left list without
     * triggering rewrites.
     */
    public FFunctionCallLeft getLeftNoTransform(int i) {
        return (FFunctionCallLeft) getLeftListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Left list.
     * @return The node representing the Left list.
     * @apilevel high-level
     */
    public List<FFunctionCallLeft> getLefts() {
        return getLeftList();
    }
    /**
     * Retrieves the Left list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Left list.
     * @apilevel low-level
     */
    public List<FFunctionCallLeft> getLeftsNoTransform() {
        return getLeftListNoTransform();
    }
    /**
     * Replaces the Call child.
     * @param node The new node to replace the Call child.
     * @apilevel high-level
     */
    public void setCall(FAbstractFunctionCall node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Call child.
     * @return The current node used as the Call child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Call")
    public FAbstractFunctionCall getCall() {
        return (FAbstractFunctionCall) getChild(1);
    }
    /**
     * Retrieves the Call child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Call child.
     * @apilevel low-level
     */
    public FAbstractFunctionCall getCallNoTransform() {
        return (FAbstractFunctionCall) getChildNoTransform(1);
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
        type_value = getCall().type();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
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
        boolean isOkTrivialInline_value = getCall().isOkTrivialInline();
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
        boolean isOkTrivialInlineInFor_value = getNumLeft() == 0;
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
        boolean isInlinable_value = getCall().isIgnored() || !insideBranchedStmt();
        return isInlinable_value;
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1064
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1064")
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
        sortingAssignedNames_value = sortingAssignedNames_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        sortingAssignedNames_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return sortingAssignedNames_value;
    }
    /** @apilevel internal */
    private Set<String> sortingAssignedNames_compute() {
            Set<String> res = new LinkedHashSet<String>(getNumLeft());
            for (FFunctionCallLeft left : getLefts())
                left.sortingAddNamesUsed(res);
            return res;
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
        sortingDependencies_value = getCall().sortingAddNamesUsed(baseSortingDependencies());
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
        String xmlTag_value = "FunctionCallStatement";
        return xmlTag_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060
     * @apilevel internal
     */
    public Size Define_size(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1062
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().sizeOfOutput(i);
        }
        else {
            return getParent().Define_size(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1060
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute size
     */
    protected boolean canDefine_size(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     */
    public boolean Define_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3372
            int childIndex = _callerNode.getIndexOfChild(_childNode);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329
     * @apilevel internal
     */
    public String Define_funcName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCall().name();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1329
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute funcName
     */
    protected boolean canDefine_funcName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     */
    public boolean Define_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1464
            return true;
        }
        else {
            return super.Define_isFunctionCallClause(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallClause
     */
    protected boolean canDefine_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484
     * @apilevel internal
     */
    public int Define_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1486
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? -1 : getLeft(i - 1).myLastIndex();
        }
        else {
            return getParent().Define_prevIndex(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1484
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute prevIndex
     */
    protected boolean canDefine_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515
     * @apilevel internal
     */
    public CommonVariableDecl Define_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1517
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().findOutput(i);
        }
        else {
            return getParent().Define_myOutput(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1515
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myOutput
     */
    protected boolean canDefine_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1522
     * @apilevel internal
     */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1527
            return false;
        }
        else {
            return getParent().Define_functionCallIsExp(this, _callerNode);
        }
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
        if (_callerNode == getCallNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1537
            return getLefts().toArrayList();
        }
        else {
            return getParent().Define_myLefts(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     * @apilevel internal
     */
    public FAbstractFunctionCall Define_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1543
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getCall();
        }
        else {
            return getParent().Define_myFunctionCall(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1539
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionCall
     */
    protected boolean canDefine_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380
     * @apilevel internal
     */
    public FType Define_type(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getLeftListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:783
            int i = _callerNode.getIndexOfChild(_childNode);
            return getCall().typeOfOutput(i);
        }
        else {
            return getParent().Define_type(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2380
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute type
     */
    protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483
     * @apilevel internal
     */
    public String Define_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getCall().functionCallDecription();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1483
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallDecription
     */
    protected boolean canDefine_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
