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
 * Expressions of the form "(exp) for i in (exp)" in instance and flat tree.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:960
 * @astdecl FIterExp : FAbstractArrayExp ::= FExp ForIndex:CommonForIndex*;
 * @production FIterExp : {@link FAbstractArrayExp} ::= <span class="component">{@link FExp}</span> <span class="component">ForIndex:{@link CommonForIndex}*</span>;

 */
public class FIterExp extends FAbstractArrayExp implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1615
     */
    public FExp extract(Index i) {
		FExp exp = getFExp().getArray().get(i).fullCopy();
		List fil = (List) getForIndexList().fullCopy();
		return new FIterExp(exp, fil);
	}
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:109
     */
    public FExp extractRecordFExp(String suffix) {
        return new FIterExp(getFExp().extractRecordFExp(suffix), getForIndexList().treeCopy());
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2229
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
        for (CommonForIndex cfi : getForIndexs()) {
            cfi.collectAccessNames(collectedNames);
        }
        
        getFExp().collectAccessNames(collectedNames);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:998
     */
    public FIterExp createEmptyNode()        { return new FIterExp();        }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1927
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
		p.print(getFExp(), str, indent);
		str.print(" for ");
		for (int i = getNumForIndex() - 1; i >= 0; i--) {
			p.print(getForIndex(i), str, indent);
			if (i > 0)
				str.print(", ");
		}
	}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:384
     */
    public void contentCheck(ErrorCheckType checkType) {
		if (!iterExpUseOK())
			error("Reduction-expressions are only allowed with sum(), min(), max() and product()");
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1265
     */
    public void collectErrors(ErrorCheckType checkType) {
	    collectErrorsInFor(getFExp(), getForIndexList(), checkType);
	}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:870
     */
    public void typeCheck(ErrorCheckType checkType) {
	  super.typeCheck(checkType);
	  if (iterExpMustBeScalar() && !getFExp().type().isUnknown() && getFExp().ndims() != 0)
		  error("The expression of a reduction-expression must be scalar, except for sum(): " +
				  getFExp() + " has " + getFExp().ndims() + " dimension(s)");
  }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2394
     */
    public FArray flattenArray(Flattener f) {
        Iterable<CommonForIndex> forIndices = getForIndexs();
        Indices ind = Indices.create(forIndices);
        FArray res = flattenArray(f, forIndices, ind, ind.iterator(), ind.size(), 0);
        for (CommonForIndex fi : forIndices) {
            fi.clearEvaluationValue();
        }
        return res;
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2404
     */
    public FArray flattenArray(Flattener f, Iterable<CommonForIndex> forIndices, Indices ind, Iterator<Index> indIt, Size s, int dim) {
        List<FExp> l = new List<FExp>();
        if (dim == s.ndims() - 1) {
            for (int i = 0; i < s.get(dim); i++) {
                ind.translate(indIt.next()).setValues(forIndices);
                getFExp().flushAllRecursive();
                l.add(getFExp().flatten(f));
            }
        } else {
            for (int i = 0; i < s.get(dim); i++) {
                l.add(flattenArray(f, forIndices, ind, indIt, s, dim+1));
            }
        }
        return new FArray(l);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2434
     */
    public FExp flatten(Flattener f) {
        if (!size().isUnknown()) {
            return getArray().buildFlattened(f, this);
        }
        List<CommonForIndex> fil = new List<CommonForIndex>();
        for (CommonForIndex fi : getForIndexList())
            fil.add(fi.flatten(f));
        return new FIterExp(getFExp().flatten(f), fil);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1684
     */
    public FExp scalarizeExp(Scalarizer s) {
		return getFExp().scalarize(s);
	}
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:855
     */
    public boolean editNamesIter(Scalarizer s) {
        ForNames names = s.getNames();
        int i = 0;
        for (; i < getNumForIndex(); i++) {
            getForIndex(i).setIndexName(names.get(i));
        }
        names.addLayer(getFExp().ndims());
        for (; i < getFExp().ndims() + getNumForIndex(); i++) {
            names.promote(i);
        }
        return true;
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:802
     */
    @Override
    protected FExp diffExp(String name) {
        return new FIterExp(getFExp().diff(name), getForIndexs().treeCopy());
    }
    /**
     * @declaredat ASTNode:1
     */
    public FIterExp() {
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
        children = new ASTNode[3];
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FExp", "ForIndex"},
        type = {"FExp", "List<CommonForIndex>"},
        kind = {"Child", "List"}
    )
    public FIterExp(FExp p0, List<CommonForIndex> p1) {
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
        ndims_reset();
        size_reset();
        localSize_reset();
        getArrayExp_reset();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public FIterExp clone() throws CloneNotSupportedException {
        FIterExp node = (FIterExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public FIterExp copy() {
        try {
            FIterExp node = (FIterExp) clone();
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
     * @declaredat ASTNode:71
     */
    @Deprecated
    public FIterExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:81
     */
    public FIterExp treeCopyNoTransform() {
        FIterExp tree = (FIterExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
                    tree.children[i] = null;
                    continue;
                }
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
     * @declaredat ASTNode:106
     */
    public FIterExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:111
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FExp child.
     * @param node The new node to replace the FExp child.
     * @apilevel high-level
     */
    public void setFExp(FExp node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the FExp child.
     * @return The current node used as the FExp child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FExp")
    public FExp getFExp() {
        return (FExp) getChild(0);
    }
    /**
     * Retrieves the FExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FExp child.
     * @apilevel low-level
     */
    public FExp getFExpNoTransform() {
        return (FExp) getChildNoTransform(0);
    }
    /**
     * Replaces the ForIndex list.
     * @param list The new list node to be used as the ForIndex list.
     * @apilevel high-level
     */
    public void setForIndexList(List<CommonForIndex> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the ForIndex list.
     * @return Number of children in the ForIndex list.
     * @apilevel high-level
     */
    public int getNumForIndex() {
        return getForIndexList().getNumChild();
    }
    /**
     * Retrieves the number of children in the ForIndex list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the ForIndex list.
     * @apilevel low-level
     */
    public int getNumForIndexNoTransform() {
        return getForIndexListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the ForIndex list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the ForIndex list.
     * @apilevel high-level
     */
    public CommonForIndex getForIndex(int i) {
        return (CommonForIndex) getForIndexList().getChild(i);
    }
    /**
     * Check whether the ForIndex list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasForIndex() {
        return getForIndexList().getNumChild() != 0;
    }
    /**
     * Append an element to the ForIndex list.
     * @param node The element to append to the ForIndex list.
     * @apilevel high-level
     */
    public void addForIndex(CommonForIndex node) {
        List<CommonForIndex> list = (parent == null) ? getForIndexListNoTransform() : getForIndexList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addForIndexNoTransform(CommonForIndex node) {
        List<CommonForIndex> list = getForIndexListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the ForIndex list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setForIndex(CommonForIndex node, int i) {
        List<CommonForIndex> list = getForIndexList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the ForIndex list.
     * @return The node representing the ForIndex list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="ForIndex")
    public List<CommonForIndex> getForIndexList() {
        List<CommonForIndex> list = (List<CommonForIndex>) getChild(1);
        return list;
    }
    /**
     * Retrieves the ForIndex list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ForIndex list.
     * @apilevel low-level
     */
    public List<CommonForIndex> getForIndexListNoTransform() {
        return (List<CommonForIndex>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the ForIndex list without
     * triggering rewrites.
     */
    public CommonForIndex getForIndexNoTransform(int i) {
        return (CommonForIndex) getForIndexListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the ForIndex list.
     * @return The node representing the ForIndex list.
     * @apilevel high-level
     */
    public List<CommonForIndex> getForIndexs() {
        return getForIndexList();
    }
    /**
     * Retrieves the ForIndex list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the ForIndex list.
     * @apilevel low-level
     */
    public List<CommonForIndex> getForIndexsNoTransform() {
        return getForIndexListNoTransform();
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(2);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 2;
    }
    /** @apilevel internal */
    private void ndims_reset() {
        ndims_computed = false;
    }
    /** @apilevel internal */
    protected boolean ndims_computed = false;

    /** @apilevel internal */
    protected int ndims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228")
    public int ndims() {
        ASTState state = state();
        if (ndims_computed) {
            return ndims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ndims_value = ndims_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /** @apilevel internal */
    private int ndims_compute() {
    		int exp = getFExp().ndims();
    		return (exp >= 0) ? exp + localNdims() : -1;
    	}
    /**
     * The number of dimensions of the iteration indices of this iteration expression.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:258")
    public int localNdims() {
        int localNdims_value = getNumForIndex();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
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
    		if (ndims() <= 0)
    			return Size.SCALAR;
    		MutableSize s = new MutableSize(ndims());
    		s.append(localSize());
    		s.append(getFExp().size());
    		return s;
    	}
    /** @apilevel internal */
    private void localSize_reset() {
        localSize_computed = false;
        
        localSize_value = null;
    }
    /** @apilevel internal */
    protected boolean localSize_computed = false;

    /** @apilevel internal */
    protected Size localSize_value;

    /**
     * The size of the iteration indices of this iteration expression.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:879
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:879")
    public Size localSize() {
        ASTState state = state();
        if (localSize_computed) {
            return localSize_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        localSize_value = localSize_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        localSize_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return localSize_value;
    }
    /** @apilevel internal */
    private Size localSize_compute() {
            MutableSize s = new MutableSize(localNdims());
            for (CommonForIndex fi : getForIndexList()) {
                if (fi.expIsVector()) {
                    s.append(fi.size());
                }
            }
            return s;
        }
    /** @apilevel internal */
    private void getArrayExp_reset() {
        getArrayExp_computed = false;
        
        getArrayExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getArrayExp_computed = false;

    /** @apilevel internal */
    protected ArrayExp getArrayExp_value;

    /**
     * Computes a generic array expansion of the expression. If this expression is not an array the result is undefined.
     * Normally {@link #getArray()} should be called instead.
     * 
     * This is used mainly to scalarize array expressions. Should be overridden for all 
     * expression types possible, since default implementation clones the original expression 
     * for each cell.
     * 
     * @return An ArrayExp with scalar expressions if this is an array expression, 
     * <code>null</code> otherwise.
     * @attribute syn nta
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367")
    public ArrayExp getArrayExp() {
        ASTState state = state();
        if (getArrayExp_computed) {
            return (ArrayExp) getChild(getArrayExpChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getArrayExp_value = getFExp().getArray().createExpanded(getForIndexList());
        setChild(getArrayExp_value, getArrayExpChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getArrayExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        ArrayExp node = (ArrayExp) this.getChild(getArrayExpChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4633")
    public boolean isCircularCalc() {
        {
                if (getFExp().isCircular()) 
                    return true;
                for (CommonForIndex i : getForIndexList()) 
                    if (i.isCircular()) 
                        return true;
                return false;
            }
    }
    /**
     * Check if this FExp is on the form "exp for i in exp".
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:652
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:652")
    public boolean isIterExp() {
        boolean isIterExp_value = true;
        return isIterExp_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = type_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private FType type_compute() {
            if (ndims() < 0)
                return fUnknownType();
            return getFExp().type().arrayType(size());
        }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        {
                TypePrefixVariability total;
                if (size().isUnknown())
                    total = getFExp().variability();
                else if (size().isEmpty())
                    total = Variability.CONSTANT;
                else
                    total = getArray().iteratorFExp().next().variability();
                
                for (CommonForIndex ind : getForIndexList())
                    total = total.combine(ind.variability());
                return total;
            }
    }
    /**
     * Return the expression corresponding to the given index in this array expression. 
     * 
     * Will not create new nodes unless necessary.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1862")
    public FExp splitArrayExp(int index) {
        {
                Map<String,FExp> repl = new HashMap<String,FExp>();
                getForIndex(0).addReplacementEntry(repl, index);
                FExp res = dynamicFExp(getFExp().treeCopy()).replaceIndices(repl);
                if (getNumForIndex() > 1) {
                    List<CommonForIndex> indices = new List<CommonForIndex>();
                    for (int i = 1, n = getNumForIndex(); i < n; i++)
                        indices.add(getForIndex(i).fullCopy());
                    res = new FArray(new List(new FIterExp(res, indices)));
                }
                return res;
            }
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1924
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1924")
    public int iterExpDepth() {
        int iterExpDepth_value = getParent().Define_iterExpDepth(this, null);
        return iterExpDepth_value;
    }
    /**
     * @attribute inh
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:78
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:78")
    public FAbstractVariable lookupFV(String name) {
        FAbstractVariable lookupFV_String_value = getParent().Define_lookupFV(this, null, name);
        return lookupFV_String_value;
    }
    /**
     * @attribute inh
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:376")
    public boolean iterExpUseOK() {
        boolean iterExpUseOK_value = getParent().Define_iterExpUseOK(this, null);
        return iterExpUseOK_value;
    }
    /**
     * Check if the FExp of this FIterExp must be scalar.
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:853")
    public boolean iterExpMustBeScalar() {
        boolean iterExpMustBeScalar_value = getParent().Define_iterExpMustBeScalar(this, null);
        return iterExpMustBeScalar_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:514
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:514")
    public InstLookupResult<InstComponentDecl> lookupInstComponent(String name) {
        InstLookupResult<InstComponentDecl> lookupInstComponent_String_value = getParent().Define_lookupInstComponent(this, null, name);
        return lookupInstComponent_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:898
     * @apilevel internal
     */
    public boolean Define_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:899
            return true;
        }
        else {
            return getParent().Define_inIterExp(this, _callerNode);
        }
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
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:907
            return expandSizeForIterExp(s.expand(localSize()));
        }
        else {
            return getParent().Define_expandSizeForIterExp(this, _callerNode, s);
        }
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
        if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1925
            return iterExpDepth() + 1;
        }
        else {
            return getParent().Define_iterExpDepth(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     */
    public FAbstractVariable Define_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getForIndexListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:82
            int i = _callerNode.getIndexOfChild(_childNode);
            return i == 0 ? lookupFV(name) : getForIndex(i - 1).localLookupFV(name);
        }
        else if (_callerNode == getFExpNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:81
            return getForIndex(getNumForIndex() - 1).localLookupFV(name);
        }
        else {
            return getParent().Define_lookupFV(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:77
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFV
     */
    protected boolean canDefine_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:974
     * @apilevel internal
     */
    public Collection<FExpSubscript> Define_mySubscriptUses(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getForIndexListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:977
            int i = _callerNode.getIndexOfChild(_childNode);
            return collectSubscriptUses(name);
        }
        else {
            return getParent().Define_mySubscriptUses(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:974
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute mySubscriptUses
     */
    protected boolean canDefine_mySubscriptUses(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getForIndexListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:533
            int index = _callerNode.getIndexOfChild(_childNode);
            return index == 0 ? lookupInstComponent(name) : getForIndex(index - 1).localLookupInstComponent(name);
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return getForIndex(getNumForIndex() - 1).localLookupInstComponent(name);
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
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
