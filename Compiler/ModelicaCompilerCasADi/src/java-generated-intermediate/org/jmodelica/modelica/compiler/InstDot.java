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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:155
 * @astdecl InstDot : InstAccess ::= InstAccess*;
 * @production InstDot : {@link InstAccess} ::= <span class="component">{@link InstAccess}*</span>;

 */
public class InstDot extends InstAccess implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2113
     */
    protected InstDot specifyEach(Index i, int[] dim) {
		List<InstAccess> l = new List<InstAccess>();
		for (InstAccess ia : getInstAccesss())
			l.add(ia.specifyEach(i, dim));
		return new InstDot(l);
	}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2153
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
        final String qualifiedName = qualifiedName();

        final ArrayList<String> prefixes = new ArrayList<>();
        for (InstAccess instAccess : getInstAccesss()) {
            if (instAccess.isClassAccess()) {
                prefixes.add(instAccess.name());
            }
        }
        final String prefix = StringUtil.join(".", prefixes);

        final Set<String> names = new HashSet<>();
        getLastInstAccess().collectAccessNames(names);
        for (String name : names) {
            collectedNames.add(prefix.isEmpty() ? name : prefix +"." + name);
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2257
     */
    @Override
    public void collectAccessNamesInArraySubscripts(Set<String> collectedNames) {
        for (InstAccess access : getInstAccesss()) {
            access.collectAccessNamesInArraySubscripts(collectedNames);
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1673
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		getInstAccesss().prettyPrintWithSep(p, str, indent, ".");
	}
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:556
     */
    @Override
    public FExp copyReplaceAccess(FExp.FunctionContextReplacer crp) {
        return getLastInstAccess().copyReplaceAccess(crp);
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:945
     */
    public void forceUsesInSubscriptsVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        for (InstAccess ia : getInstAccesss()) {
            ia.forceUsesInSubscriptsVariability(checkType, v);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1145
     */
    public void collectErrors(ErrorCheckType checkType) {
        for (InstAccess ia : getInstAccesss()) {
            ia.collectErrors(checkType);
            if (ia.isUnknown() || !ia.myInstComponentDecl().shouldCheckInto(checkType))
                break;
        }
        allChecks(checkType);
    }
    /**
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:96
     */
    public void generateClassLookupProblems(InstLookupResult lookup, ASTNode n) {
         getInstAccess(getNumInstAccess() - 1).generateClassLookupProblems(lookup, n);
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:760
     */
    protected void typeError(InstAccess top) {
	  getLastInstAccess().typeError(top);
  }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1586
     */
    public void typeCheck(ErrorCheckType checkType) {
        // Check for accesses to component in class or class in component
        int n = getNumInstAccess();
        for (int i = 0; i < n - 1; i++)
            getInstAccess(i).checkMixedAccessLeft(getInstAccess(i + 1), this, checkType, i, n);
        super.typeCheck(checkType);
    }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:97
     */
    public void extractNonParameterIndices(List<FSubscript> sub, TypePrefixVariability v) {
        for (InstAccess ia : getInstAccesss()) {
            ia.extractNonParameterIndices(sub, v);
        }
    }
    /**
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:123
     */
    public FAccess flatten(Flattener f) {
        FAccess res = null;
        boolean assignable = false;
        for (InstAccess cur : getInstAccessList()) {
            if (assignable) {
                res = res.append(cur.name(), cur.flattenFAS(f));
            } else if (cur.myInstComponentDecl().isAssignable()) {
                res = cur.flatten(f);
                assignable = true;
            }
        }
        if (res == null) {
           res = getLastInstAccess().flatten(f);
        }
        return res;
    }
    /**
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1086
     */
    public InstDot copyAndAppend(String id) {
    	InstDot res = fullCopy();
    	res.addInstAccess(createPartToAppend(id));
    	return res;
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstDot() {
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
        name = {"InstAccess"},
        type = {"List<InstAccess>"},
        kind = {"List"}
    )
    public InstDot(List<InstAccess> p0) {
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
        name_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:38
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public InstDot clone() throws CloneNotSupportedException {
        InstDot node = (InstDot) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public InstDot copy() {
        try {
            InstDot node = (InstDot) clone();
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
     * @declaredat ASTNode:66
     */
    @Deprecated
    public InstDot fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:76
     */
    public InstDot treeCopyNoTransform() {
        InstDot tree = (InstDot) copy();
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
     * @declaredat ASTNode:96
     */
    public InstDot treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:101
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the InstAccess list.
     * @param list The new list node to be used as the InstAccess list.
     * @apilevel high-level
     */
    public void setInstAccessList(List<InstAccess> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the InstAccess list.
     * @return Number of children in the InstAccess list.
     * @apilevel high-level
     */
    public int getNumInstAccess() {
        return getInstAccessList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstAccess list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstAccess list.
     * @apilevel low-level
     */
    public int getNumInstAccessNoTransform() {
        return getInstAccessListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstAccess list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstAccess list.
     * @apilevel high-level
     */
    public InstAccess getInstAccess(int i) {
        return (InstAccess) getInstAccessList().getChild(i);
    }
    /**
     * Check whether the InstAccess list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstAccess() {
        return getInstAccessList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstAccess list.
     * @param node The element to append to the InstAccess list.
     * @apilevel high-level
     */
    public void addInstAccess(InstAccess node) {
        List<InstAccess> list = (parent == null) ? getInstAccessListNoTransform() : getInstAccessList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstAccessNoTransform(InstAccess node) {
        List<InstAccess> list = getInstAccessListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstAccess list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstAccess(InstAccess node, int i) {
        List<InstAccess> list = getInstAccessList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the InstAccess list.
     * @return The node representing the InstAccess list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="InstAccess")
    public List<InstAccess> getInstAccessList() {
        List<InstAccess> list = (List<InstAccess>) getChild(0);
        return list;
    }
    /**
     * Retrieves the InstAccess list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstAccess list.
     * @apilevel low-level
     */
    public List<InstAccess> getInstAccessListNoTransform() {
        return (List<InstAccess>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the InstAccess list without
     * triggering rewrites.
     */
    public InstAccess getInstAccessNoTransform(int i) {
        return (InstAccess) getInstAccessListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstAccess list.
     * @return The node representing the InstAccess list.
     * @apilevel high-level
     */
    public List<InstAccess> getInstAccesss() {
        return getInstAccessList();
    }
    /**
     * Retrieves the InstAccess list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstAccess list.
     * @apilevel low-level
     */
    public List<InstAccess> getInstAccesssNoTransform() {
        return getInstAccessListNoTransform();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356")
    public int ndims() {
        {
                int n = 0;
                for (InstAccess ia : getInstAccesss()) {
                    n = n + ia.ndims();
                }
                return n;
            }
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
        {
        		int n = getNumInstAccess();
        		java.util.List<FArraySubscripts>[] lists = new java.util.List[n];
        		for (int i = 0; i < n; i++)
        			lists[i] = getInstAccess(i).allFArraySubscripts();
        		return concatenation(lists);
        	}
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102")
    public Size arraySize() {
        {
                MutableSize s = new MutableSize(ndims());
                for (InstAccess ia : getInstAccesss()) {
                    s.append(ia.size());
                }
                return s;
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2694
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2694")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        CValue ceval_VariableEvaluator_Index_value = getLastInstAccess().ceval(evaluator, i);
        return ceval_VariableEvaluator_Index_value;
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
        int numParts_value = getNumInstAccess();
        return numParts_value;
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3154")
    public boolean isExpandableConnectorPart() {
        {
                InstComponentDecl conn = findReferencedExpandableConnector();
                return conn != null && conn != getLastInstAccess().findReferencedExpandableConnector();
            }
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3160
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3160")
    public InstComponentDecl findReferencedExpandableConnector() {
        {
                for (int i = getNumInstAccess() - 1; i >= 0; i--) {
                    InstComponentDecl conn = getInstAccess(i).findReferencedExpandableConnector();
                    if (conn != null)
                        return conn;
                }
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect ExpandableConnectors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpandableConnectors", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3178")
    public InstAccess findExpandableMemberPart(InstComponentDecl expandable) {
        {
                for (int i = getNumInstAccess() - 2; i >= 0; i--) 
                    if (getInstAccess(i).findReferencedExpandableConnector() != null)
                        return getInstAccess(i + 1);
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965")
    public InstAccess splitArrayAccess(int index) {
        {
                List<InstAccess> l = new List<InstAccess>();
                boolean split = false;
                for (InstAccess ia : getInstAccesss()) {
                    if (!split && ia.isArray()) {
                        l.add(ia.splitArrayAccess(index));
                        split = true;
                    } else {
                        l.add(ia.treeCopy());
                    }
                }
                return new InstDot(l);
            }
    }
    /**
     * @attribute syn
     * @aspect FlatteningAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:46")
    public boolean isNonAssignableArray() {
        {
                for (InstAccess ia : getInstAccessList()) {
                    if (ia.isNonAssignableArray()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:313
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:313")
    public int firstAssignableIndex() {
        {
                for (int i = 0, n = getNumInstAccess(); i < n; i++)
                    if (getInstAccess(i).isAssignable())
                        return i;
                return -1;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:320
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:320")
    public InstAssignable topInstAssignable() {
        InstAssignable topInstAssignable_value = getInstAccess(firstAssignableIndex()).topInstAssignable();
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
        {
                for (InstAccess ia : getInstAccesss())
                    if (ia.hasUnknownIndices())
                        return true;
                return false;
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
        InstClassDecl myInstClassDecl_value = getLastInstAccess().myInstClassDecl();
        return myInstClassDecl_value;
    }
    /**
     * Get a specific child access, triggering transformations on that child, but *not* on the entire list.
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:447
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:447")
    public InstAccess getInstAccessNoListTrans(int i) {
        InstAccess getInstAccessNoListTrans_int_value = getInstAccessListNoTransform().getChild(i);
        return getInstAccessNoListTrans_int_value;
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
        boolean hasLookupProblem_value = getInstAccess(getNumInstAccess() - 1).hasLookupProblem();
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
        InstComponentDecl myInstComponentDecl_value = getLastInstAccess().myInstComponentDecl();
        return myInstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:726
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:726")
    public InstLookupResult<? extends InstLookupResult.Item> myInstLookup() {
        InstLookupResult<? extends InstLookupResult.Item> myInstLookup_value = getLastInstAccess().myInstLookup();
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
        InstComponentDecl myInstComponentElement_value = getLastInstAccess().myInstComponentElement();
        return myInstComponentElement_value;
    }
    /**
     * @attribute syn
     * @aspect InstExpVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:256
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstExpVariability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:256")
    public TypePrefixVariability indexVariability() {
        {
                TypePrefixVariability variability = Variability.CONSTANT;
                for (InstAccess part : getInstAccesss())
                    variability = variability.combine(part.indexVariability());
                return variability;
            }
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:120")
    public boolean isUnknown() {
        boolean isUnknown_value = getLastInstAccess().isUnknown();
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
        {
                InstNode cur = getInstAccess(0).constrainingTypeOfClass();
                for (int i = 1, n = getNumInstAccess(); i < n; i++) {
                    InstLookupResult<InstClassDecl> res = cur.memberInstClass(getInstAccess(i).name());
                    if (res.successful()) {
                        cur = res.target().constrainingInstType();
                    } else {
                        cur = getInstAccess(i).constrainingTypeOfClass();
                    }
                }
                return cur;
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:146
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:146")
    public InstLookupResult<InstClassDecl> lookupInstClassIfAccess() {
        InstLookupResult<InstClassDecl> lookupInstClassIfAccess_value = getLastInstAccess().lookupInstClassIfAccess();
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
        InstLookupResult<InstComponentDecl> lookupInstComponentIfAccess_value = getLastInstAccess().lookupInstComponentIfAccess();
        return lookupInstComponentIfAccess_value;
    }
    /** @apilevel internal */
    private void name_reset() {
        name_computed = false;
        
        name_value = null;
    }
    /** @apilevel internal */
    protected boolean name_computed = false;

    /** @apilevel internal */
    protected String name_value;

    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:721
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:721")
    public String name() {
        ASTState state = state();
        if (name_computed) {
            return name_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_value = name_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_value;
    }
    /** @apilevel internal */
    private String name_compute() {
    	  StringBuilder buf = new StringBuilder();
    	  List<InstAccess> l = getInstAccessListNoTransform();
    	  for (int i = 0; i < l.getNumChildNoTransform(); i++) {
    		  buf.append(l.getChildNoTransform(i).name());
    		  buf.append('.');
    	  }
    	  return buf.substring(0, buf.length() - 1);
      }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:745
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:745")
    public String qualifiedName() {
        {
        	  StringBuilder buf = new StringBuilder();
        	  for (InstAccess ia : getInstAccesss()) {
        		  buf.append(ia.qualifiedName());
        		  buf.append('.');
        	  }
        	  return buf.substring(0, buf.length() - 1);
          }
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:774
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:774")
    public String lastName() {
        String lastName_value = getInstAccessListNoTransform().lastChildNoTransform().lastName();
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
        String enclosingName_value = name().substring(0, name().lastIndexOf('.'));
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
        InstAccess getLastInstAccess_value = getInstAccess(getNumInstAccessNoTransform() - 1);
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
        InstAccess getFirstInstAccess_value = getInstAccess(0);
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
        Iterable<InstAccess> allParts_value = getInstAccessList();
        return allParts_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1058
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1058")
    public FArraySubscripts getFArraySubscripts() {
        FArraySubscripts getFArraySubscripts_value = getLastInstAccess().getFArraySubscripts();
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
        boolean hasFArraySubscripts_value = getLastInstAccess().hasFArraySubscripts();
        return hasFArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1523
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1523")
    public boolean isDisabled() {
        {
            	for (InstAccess ia : getInstAccesss())
            		if (ia.isDisabled())
            			return true;
            	return false;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753
     * @apilevel internal
     */
    public CValue Define_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2756
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? cevalRecordMember(evaluator, access) : getInstAccess(i - 1).ceval(evaluator).record().getMember(access.getID());
        }
        else {
            return super.Define_cevalRecordMember(_callerNode, _childNode, evaluator, access);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute cevalRecordMember
     */
    protected boolean canDefine_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209
     * @apilevel internal
     */
    public List<InstAccess> Define_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:212
            int i = _callerNode.getIndexOfChild(_childNode);
            return i == 0 ? new List<InstAccess>() : getInstAccess(i-1).buildAccessContext();
        }
        else {
            return getParent().Define_accessContextInst(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:209
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextInst
     */
    protected boolean canDefine_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561
     * @apilevel internal
     */
    public FExp Define_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:563
            int i = _callerNode.getIndexOfChild(_childNode);
            return i == 0 ? copyReplaceAccessParent(crp) : getInstAccess(i-1).copyReplaceAccess(crp);
        }
        else {
            return super.Define_copyReplaceAccessParent(_callerNode, _childNode, crp);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute copyReplaceAccessParent
     */
    protected boolean canDefine_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114
     * @apilevel internal
     */
    public boolean Define_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:115
            int i = _callerNode.getIndexOfChild(_childNode);
            return isExpandableConnectorPart() && inConnectWithExistingComponent();
        }
        else {
            return super.Define_isExpandableConnectorMemberInConnect(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isExpandableConnectorMemberInConnect
     */
    protected boolean canDefine_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2304
     * @apilevel internal
     */
    public boolean Define_expandSize(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2308
            int i = _callerNode.getIndexOfChild(_childNode);
            {
                    for (int j = 0; j < i; j++) {
                        if (!getInstAccess(j).indexVariability().indexParameterOrLess()) {
                            return false;
                        }
                    }
                    return true;
                }
        }
        else {
            return super.Define_expandSize(_callerNode, _childNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:161
            int i = _callerNode.getIndexOfChild(_childNode);
            return i != getNumInstAccess() - 1 || flattenFASContext();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:319
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? lookupInstClass(name) : getInstAccessNoListTrans(i - 1).qualifiedLookupInstClass(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349
     * @apilevel internal
     */
    public InstClassDecl Define_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:351
            int i = _callerNode.getIndexOfChild(_childNode);
            return lookupConstrainingInstClassHelper((i == 0) ? null : getInstAccessNoListTrans(i - 1), name);
        }
        else {
            return super.Define_lookupConstrainingInstClass(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstClass
     */
    protected boolean canDefine_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:352
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? lookupInstComponent(name) : getInstAccessNoListTrans(i - 1).qualifiedLookupInstComponent(name);
        }
        else {
            return getParent().Define_lookupInstComponent(this, _callerNode, name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384
     * @apilevel internal
     */
    public InstComponentDecl Define_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:386
            int i = _callerNode.getIndexOfChild(_childNode);
            return lookupConstrainingInstComponentHelper((i == 0) ? null : getInstAccessNoListTrans(i - 1), name);
        }
        else {
            return super.Define_lookupConstrainingInstComponent(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstComponent
     */
    protected boolean canDefine_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413
     * @apilevel internal
     */
    public InstNode Define_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:414
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == 0) ? null : getInstAccessNoListTrans(i - 1).closestConstrainingDecl();
        }
        else {
            return super.Define_findClosestConstrainingInstNode(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findClosestConstrainingInstNode
     */
    protected boolean canDefine_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:98
            int i = _callerNode.getIndexOfChild(_childNode);
            {
            		List<InstAccess> accesses = getInstAccesssNoTransform();
            		if (i >= accesses.getNumChildNoTransform() - 1)
            			return kind();
            		else
            			return accesses.getChildNoTransform(i + 1).kind().predKind(i);
            	}
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976
     * @apilevel internal
     */
    public InstAccess Define_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:977
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i >= getNumInstAccessNoTransform() - 1) ? null : getInstAccess(i + 1);
        }
        else {
            return super.Define_getNextInstAccess(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getNextInstAccess
     */
    protected boolean canDefine_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038
     * @apilevel internal
     */
    public InstAccess Define_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return retrieveTopInstAccess(this);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveTopInstAccess
     */
    protected boolean canDefine_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1046
     * @apilevel internal
     */
    public boolean Define_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstAccessListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1049
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return super.Define_inQualified(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1046
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inQualified
     */
    protected boolean canDefine_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
