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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:431
 * @astdecl FArrayExpSubscripts : FArraySubscripts ::= FSubscript*;
 * @production FArrayExpSubscripts : {@link FArraySubscripts} ::= <span class="component">{@link FSubscript}*</span>;

 */
public class FArrayExpSubscripts extends FArraySubscripts implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:114
     */
    public int numSubscript() {
        return getNumFSubscript();
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:126
     */
    public Iterable<? extends Subscript> subscripts() {
        return getFSubscripts();
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:131
     */
    public FArrayExpSubscripts copyAsFArrayExpSubscripts() {
        return treeCopy();
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2037
     */
    public FArraySubscripts createSpecified(Index i, int[] dim) {
        if (ndims() == 0) {
            return super.createSpecified(i, dim);
        }
        
        List<FSubscript> subscripts = new List<>();
        for (FSubscript fs : getFSubscripts()) {
            subscripts.add(fs.createSpecified(i, dim));
        }
        return FArraySubscripts.createFArraySubscripts(subscripts);
    }
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:4563
     */
    public void expIndices(ArrayList<int[]> newInd, boolean[] newTrim, int offset) {
        for (int k = 0; k < getNumFSubscript(); k++) {
            FSubscript fs = getFSubscript(k);
            if (fs.variability().indexParameterOrLess()) {
                int[] i = fs.myIndices();
                newInd.add(i);
                newTrim[k + offset] = false;
            } else {
                newInd.add(ASTNode.range(fs.mySize().get(0)));
                newTrim[k + offset] = true;
            }
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2213
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
        for (FSubscript sub : getFSubscripts()) {
            sub.collectAccessNames(collectedNames);
        }
    }
    /**
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:812
     */
    public void addFSubscript(int i) {
        addFSubscript(new FIntegerSubscript(i));
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:203
     */
    public FArraySubscripts createEvaluated() {
        List<FSubscript> list = new List<FSubscript>();
        for (FSubscript fs : getFSubscripts()) {
            list.add(fs.createEvaluated());
        }
        FArraySubscripts res = FArraySubscripts.createFArraySubscripts(list);
        res.setParent(getParent());
        return res;
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:586
     */
    public FArraySubscripts copyReplaceAccess(FExp.ContextReplacer crp) {
        List<FSubscript> list = new List<>();
        for (FSubscript f : getFSubscripts()) {
            list.add(f.copyReplaceAccess(crp));
        }
        return FArraySubscripts.createFArraySubscripts(list);
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:864
     */
    public void forceVariability(ErrorCheckType checkType,  TypePrefixVariability v) {
        for (FSubscript s : getFSubscripts()) {
            s.forceVariability(checkType, v);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1178
     */
    public void collectErrors(ErrorCheckType checkType) {
		// Should this check be in the access instead?
        int ndims = myDims();
		if (getNumFSubscript() > ndims && !isInstComponentSize() && myAccessExists()) {
			// TODO: shouldn't this check for to few as well? (no [] or all dimensions given)
			error("Too many array subscripts for access: " + getNumFSubscript() + 
                    " subscripts given, component has " + ndims + " dimensions");
			allChecks(checkType);
			for (int i = 0; i < ndims; i++)
				getFSubscript(i).collectErrors(checkType);
		} else {
    		super.collectErrors(checkType);
		}
	}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1998
     */
    public void specifyNext(int index) {
        for (int i = 0; i < getNumFSubscript(); i++) {
            if (getFSubscript(i).ndims() > 0) {
                setFSubscript(getFSubscript(i).specify(index), i);
                return;
            }
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2286
     */
    public FArraySubscripts flatten(Flattener f) {
        List l = new List();
        for (FSubscript fs : getFSubscripts())
            l.add(fs.flatten(f));
        return FArraySubscripts.createFArraySubscripts(l);
    }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:104
     */
    public void extractNonParameterIndices(List<FSubscript> sub) {
        for (int i = 0, n = getNumFSubscript(); i < n; i++) {
            FSubscript fs = getFSubscript(i);
            if (!fs.variability().indexParameterOrLess()) {
                sub.add(fs);
                setFSubscript(new FColonSubscript(), i);
            } else if (fs.ndims() == 1) {
                sub.add(fs.size().rangeFSubscript(0));
            }
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:683
     */
    public void removeFromUses() {
        for (FSubscript s : getFSubscripts()) {
            s.removeFromUses();
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:649
     */
    public void preventEvents() {
        for (FSubscript s : getFSubscripts()) {
            s.preventEvents();
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:975
     */
    public void inlineFunctions(AbstractFunctionInliner fi) {
        for (FSubscript fs : getFSubscripts()) {
            fs.inlineFunctions(fi);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1668
     */
    public FArraySubscripts copyWithNonLiteralSubscriptsAsColon() {
        FArrayExpSubscripts res = new FArrayExpSubscripts();
        for (FSubscript s : getFSubscripts()) {
            res.addFSubscriptNoTransform(s.copyWithNonLiteralSubscriptsAsColon());
        }
        return res;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1713
     */
    public void copyNonLiteralSubscriptsTo(FArrayExpSubscripts fas) {
        for (FSubscript s : getFSubscripts()) {
            s.copyNonLiteralSubscriptsTo(fas);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1571
     */
    public FArraySubscripts scalarize(Scalarizer s) {
        FArrayExpSubscripts fas = new FArrayExpSubscripts();
        for (FSubscript fs : getFSubscripts()) {
            fas.addFSubscript(fs.scalarize(s));
        }
        return fas;
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:949
     */
    public int addArrayUsesToIndexMap(FExp[] names, int i) {
        for (FSubscript fs : getFSubscripts()) {
            if (fs.ndims() > 0) {
                FExp[] indexNames = new FExp[1];
                indexNames[0] = names[i];
                fs.addArrayUsesToIndexMap(indexNames);
                i++;
            }
        }
        return i;
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:749
     */
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        getFSubscripts().prettyPrintWithSep(p, str, "", ", ");
    }
    /**
     * @declaredat ASTNode:1
     */
    public FArrayExpSubscripts() {
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
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FSubscript"},
        type = {"List<FSubscript>"},
        kind = {"List"}
    )
    public FArrayExpSubscripts(List<FSubscript> p0) {
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
        accessNdims_reset();
        accessSize_reset();
        hasUnknownIndices_reset();
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
    public FArrayExpSubscripts clone() throws CloneNotSupportedException {
        FArrayExpSubscripts node = (FArrayExpSubscripts) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FArrayExpSubscripts copy() {
        try {
            FArrayExpSubscripts node = (FArrayExpSubscripts) clone();
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
    public FArrayExpSubscripts fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public FArrayExpSubscripts treeCopyNoTransform() {
        FArrayExpSubscripts tree = (FArrayExpSubscripts) copy();
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
    public FArrayExpSubscripts treeCopy() {
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
     * Replaces the FSubscript list.
     * @param list The new list node to be used as the FSubscript list.
     * @apilevel high-level
     */
    public void setFSubscriptList(List<FSubscript> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FSubscript list.
     * @return Number of children in the FSubscript list.
     * @apilevel high-level
     */
    public int getNumFSubscript() {
        return getFSubscriptList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FSubscript list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FSubscript list.
     * @apilevel low-level
     */
    public int getNumFSubscriptNoTransform() {
        return getFSubscriptListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FSubscript list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FSubscript list.
     * @apilevel high-level
     */
    public FSubscript getFSubscript(int i) {
        return (FSubscript) getFSubscriptList().getChild(i);
    }
    /**
     * Check whether the FSubscript list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFSubscript() {
        return getFSubscriptList().getNumChild() != 0;
    }
    /**
     * Append an element to the FSubscript list.
     * @param node The element to append to the FSubscript list.
     * @apilevel high-level
     */
    public void addFSubscript(FSubscript node) {
        List<FSubscript> list = (parent == null) ? getFSubscriptListNoTransform() : getFSubscriptList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFSubscriptNoTransform(FSubscript node) {
        List<FSubscript> list = getFSubscriptListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FSubscript list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFSubscript(FSubscript node, int i) {
        List<FSubscript> list = getFSubscriptList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FSubscript list.
     * @return The node representing the FSubscript list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FSubscript")
    public List<FSubscript> getFSubscriptList() {
        List<FSubscript> list = (List<FSubscript>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FSubscript list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FSubscript list.
     * @apilevel low-level
     */
    public List<FSubscript> getFSubscriptListNoTransform() {
        return (List<FSubscript>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FSubscript list without
     * triggering rewrites.
     */
    public FSubscript getFSubscriptNoTransform(int i) {
        return (FSubscript) getFSubscriptListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FSubscript list.
     * @return The node representing the FSubscript list.
     * @apilevel high-level
     */
    public List<FSubscript> getFSubscripts() {
        return getFSubscriptList();
    }
    /**
     * Retrieves the FSubscript list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FSubscript list.
     * @apilevel low-level
     */
    public List<FSubscript> getFSubscriptsNoTransform() {
        return getFSubscriptListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:106")
    public Subscript subscript(int i) {
        Subscript subscript_int_value = getFSubscript(i);
        return subscript_int_value;
    }
    /** @apilevel internal */
    private void accessNdims_reset() {
        accessNdims_computed = false;
    }
    /** @apilevel internal */
    protected boolean accessNdims_computed = false;

    /** @apilevel internal */
    protected int accessNdims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:197
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:197")
    public int accessNdims() {
        ASTState state = state();
        if (accessNdims_computed) {
            return accessNdims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        accessNdims_value = accessNdims_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        accessNdims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return accessNdims_value;
    }
    /** @apilevel internal */
    private int accessNdims_compute() {
    		int nd = 0;
    		for (FSubscript fs : getFSubscripts()) {
    			nd += fs.ndims();
    		}
    		return nd;
    	}
    /** @apilevel internal */
    private void accessSize_reset() {
        accessSize_computed = false;
        
        accessSize_value = null;
    }
    /** @apilevel internal */
    protected boolean accessSize_computed = false;

    /** @apilevel internal */
    protected Size accessSize_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:709
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:709")
    public Size accessSize() {
        ASTState state = state();
        if (accessSize_computed) {
            return accessSize_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        accessSize_value = accessSize_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        accessSize_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return accessSize_value;
    }
    /** @apilevel internal */
    private Size accessSize_compute() {
    		if (accessNdims() == 0)
    			return Size.SCALAR;
    		MutableSize s = new MutableSize(accessNdims());
    		for (FSubscript fs : getFSubscripts()) 
    			if (fs.ndims() == 1)
    				s.append(fs.size());
    		return s;
    	}
    /**
     * Filter out known subscripts and copy to a new FArraySubscripts. 
     * Unknown non-scalar subscripts will be specified
     * by the corresponding position in index.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1659
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1659")
    public FArraySubscripts specify(Index index) {
        {
                List<FSubscript> list = new List<FSubscript>();
                int j = 0;
                for (FSubscript fs : getFSubscripts()) {
                    if (!fs.variability().indexParameterOrLess()) {
                        if (fs.ndims() > 0) {
                            fs = fs.specify(index.get(j));
                        } else {
                            fs = fs.treeCopy();
                        }
                        j++;
                        list.add(fs);
                    }
                }
                return FArraySubscripts.createFArraySubscripts(list);
            }
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1677
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1677")
    public FArraySubscripts specifyAll(Index index) {
        {
                List<FSubscript> list = new List<FSubscript>();
                int j = 0;
                for (FSubscript fs : getFSubscripts()) {
                    if (fs.ndims() > 0) {
                        fs = fs.specify(index.get(j++));
                    } else {
                        fs = fs.treeCopy();
                    }
                    list.add(fs);
                }
                return FArraySubscripts.createFArraySubscripts(list);
            }
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4757
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4757")
    public boolean isCircular() {
        {
        		for (FSubscript fs : getFSubscripts())
        			if (fs.isCircular())
        				return true;
        		return false;
        	}
    }
    /**
     * Check if this array subscript list has any expression or colon subscripts.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:518
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:518")
    public boolean hasNonLiteralSubscripts() {
        {
                for (FSubscript s : getFSubscripts())
                    if (s.hasNonLiteralSubscripts())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:237
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:237")
    public FArraySubscripts buildAccessContext() {
        {
                List<FSubscript> list = new List<FSubscript>();
                for (FSubscript fs : getFSubscripts()) {
                    list.add(fs.buildAccessContext());
                }
                return FArraySubscripts.createFArraySubscripts(list);
            }
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:566
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:566")
    public TypePrefixVariability variability() {
        {
        		TypePrefixVariability total = Variability.CONSTANT;
        		for (FSubscript arg : getFSubscripts()) 
        			total = total.combine(arg.variability());
        		return total;
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1129")
    public boolean isFullSize() {
        {
              for (FSubscript fs : getFSubscripts())
                  if (!fs.isColon())
                      return false;
              return true;
          }
    }
    /** @apilevel internal */
    private void hasUnknownIndices_reset() {
        hasUnknownIndices_computed = false;
    }
    /** @apilevel internal */
    protected boolean hasUnknownIndices_computed = false;

    /** @apilevel internal */
    protected boolean hasUnknownIndices_value;

    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:334
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:334")
    public boolean hasUnknownIndices() {
        ASTState state = state();
        if (hasUnknownIndices_computed) {
            return hasUnknownIndices_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        hasUnknownIndices_value = hasUnknownIndices_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        hasUnknownIndices_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return hasUnknownIndices_value;
    }
    /** @apilevel internal */
    private boolean hasUnknownIndices_compute() {
            for (FSubscript fs : getFSubscripts())
                if (fs.isUnknownIndex())
                    return true;
            return false;
        }
    /**
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1126
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1126")
    public boolean isSlice() {
        {
                for (FSubscript fs : getFSubscripts()) {
                    if (fs.isSlice()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:701
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:701")
    public boolean generatesEvents() {
        {
                for (FSubscript s : getFSubscripts()) {
                    if (s.generatesEvents()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:777
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:777")
    public boolean hasInliableFunctions(AbstractFunctionInliner fi) {
        {
                for (FSubscript sub : getFSubscripts()) {
                    if (sub.hasInlinableFunctions(fi)) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * Check if an array subscript contains any calls to functions that we can inline.
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:790
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:790")
    public boolean hasInlinableFunctions(AbstractFunctionInliner fi) {
        {
                for (FSubscript fs : getFSubscripts()) {
                    if (fs.hasInlinableFunctions(fi)) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:700
     * @apilevel internal
     */
    public int Define_myDim(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFSubscriptListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:701
            int i = _callerNode.getIndexOfChild(_childNode);
            return i;
        }
        else {
            return getParent().Define_myDim(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:700
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myDim
     */
    protected boolean canDefine_myDim(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:52
     * @apilevel internal
     */
    public Size Define_mySize(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFSubscriptListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:48
            int i = _callerNode.getIndexOfChild(_childNode);
            return mySize().contract(i);
        }
        else {
            return getParent().Define_mySize(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:52
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute mySize
     */
    protected boolean canDefine_mySize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFSubscriptListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:274
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
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
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
