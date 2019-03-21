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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:297
 * @astdecl SrcFunctionArguments : SrcBaseNode ::= SrcExp* SrcNamedArgument*;
 * @production SrcFunctionArguments : {@link SrcBaseNode} ::= <span class="component">{@link SrcExp}*</span> <span class="component">{@link SrcNamedArgument}*</span>;

 */
public class SrcFunctionArguments extends SrcBaseNode implements Cloneable, SrcAnnotationProvider {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:843
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		for (int i=0; i<getNumSrcExp(); i++) {
			p.print(getSrcExp(i),str,indent);
			if (i<getNumSrcExp()-1)
				str.print(",");
		}
	}
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2066
     */
    @Override
    public boolean hasAnnotation() {
        return annotationSubNodes().iterator().hasNext();
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:670
     */
    @Override
    public SrcExp annotationValue() {
        return null;
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:675
     */
    @Override
    public Iterable<SubNodePair<SrcAnnotationProvider>> annotationSubNodes() {
        return new ChainedIterable(new TransformerIterable<SrcExp, SubNodePair<SrcAnnotationProvider>>(getSrcExps()) {
            @Override
            protected SubNodePair<SrcAnnotationProvider> transform(SrcExp exp) {
                if (exp.asNamedAnnotationProvider() == null) {
                    return new SubNodePair<SrcAnnotationProvider>(null, new ExpValueProvider(exp));
                } else {
                    return new SubNodePair<SrcAnnotationProvider>(exp.namedAnnotationProviderName(),
                            exp.asNamedAnnotationProvider());
                }
            }
        }, new TransformerIterable<SrcNamedArgument, SubNodePair<SrcAnnotationProvider>>(getSrcNamedArguments()) {
            @Override
            protected SubNodePair<SrcAnnotationProvider> transform(SrcNamedArgument arg) {
                return new SubNodePair<SrcAnnotationProvider>(arg.getName().name(), arg);
            }
        });
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:695
     */
    @Override
    public void setAnnotationValue(SrcExp newValue) throws FailedToSetAnnotationValueException {
        throw new FailedToSetAnnotationValueException();
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:700
     */
    @Override
    public SrcAnnotationProvider addAnnotationSubNode(String name) {
        return null;
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:705
     */
    @Override
    public boolean isEach() {
        return false;
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:710
     */
    @Override
    public boolean isFinal() {
        return false;
    }
    /**
     * Returns an iterable, that has an iterator that iterates over the SrcExps 
     * that comprise this set of arguments.
     * 
     * Note that this is different from the function with the same name on SrcExp.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:489
     */
    public Iterable<SrcExp> childSrcExps() {
        Iterable<SrcExp> namedPart = 
                new TransformerIterable<SrcNamedArgument, SrcExp>(getSrcNamedArguments())
            {
                protected SrcExp transform(SrcNamedArgument a) {
                    return a.getSrcExp();
                }
            };
        return new ChainedIterable(getSrcExps(), namedPart);
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcFunctionArguments() {
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
        setChild(List.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcExp", "SrcNamedArgument"},
        type = {"List<SrcExp>", "List<SrcNamedArgument>"},
        kind = {"List", "List"}
    )
    public SrcFunctionArguments(List<SrcExp> p0, List<SrcNamedArgument> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:31
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:35
     */
    public void flushAttrCache() {
        super.flushAttrCache();
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
    public SrcFunctionArguments clone() throws CloneNotSupportedException {
        SrcFunctionArguments node = (SrcFunctionArguments) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public SrcFunctionArguments copy() {
        try {
            SrcFunctionArguments node = (SrcFunctionArguments) clone();
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
    public SrcFunctionArguments fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:77
     */
    public SrcFunctionArguments treeCopyNoTransform() {
        SrcFunctionArguments tree = (SrcFunctionArguments) copy();
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
    public SrcFunctionArguments treeCopy() {
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
     * Replaces the SrcExp list.
     * @param list The new list node to be used as the SrcExp list.
     * @apilevel high-level
     */
    public void setSrcExpList(List<SrcExp> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the SrcExp list.
     * @return Number of children in the SrcExp list.
     * @apilevel high-level
     */
    public int getNumSrcExp() {
        return getSrcExpList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcExp list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcExp list.
     * @apilevel low-level
     */
    public int getNumSrcExpNoTransform() {
        return getSrcExpListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcExp list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcExp list.
     * @apilevel high-level
     */
    public SrcExp getSrcExp(int i) {
        return (SrcExp) getSrcExpList().getChild(i);
    }
    /**
     * Check whether the SrcExp list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcExp() {
        return getSrcExpList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcExp list.
     * @param node The element to append to the SrcExp list.
     * @apilevel high-level
     */
    public void addSrcExp(SrcExp node) {
        List<SrcExp> list = (parent == null) ? getSrcExpListNoTransform() : getSrcExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcExpNoTransform(SrcExp node) {
        List<SrcExp> list = getSrcExpListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcExp list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcExp(SrcExp node, int i) {
        List<SrcExp> list = getSrcExpList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcExp list.
     * @return The node representing the SrcExp list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcExp")
    public List<SrcExp> getSrcExpList() {
        List<SrcExp> list = (List<SrcExp>) getChild(0);
        return list;
    }
    /**
     * Retrieves the SrcExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcExp list.
     * @apilevel low-level
     */
    public List<SrcExp> getSrcExpListNoTransform() {
        return (List<SrcExp>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the SrcExp list without
     * triggering rewrites.
     */
    public SrcExp getSrcExpNoTransform(int i) {
        return (SrcExp) getSrcExpListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcExp list.
     * @return The node representing the SrcExp list.
     * @apilevel high-level
     */
    public List<SrcExp> getSrcExps() {
        return getSrcExpList();
    }
    /**
     * Retrieves the SrcExp list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcExp list.
     * @apilevel low-level
     */
    public List<SrcExp> getSrcExpsNoTransform() {
        return getSrcExpListNoTransform();
    }
    /**
     * Replaces the SrcNamedArgument list.
     * @param list The new list node to be used as the SrcNamedArgument list.
     * @apilevel high-level
     */
    public void setSrcNamedArgumentList(List<SrcNamedArgument> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the SrcNamedArgument list.
     * @return Number of children in the SrcNamedArgument list.
     * @apilevel high-level
     */
    public int getNumSrcNamedArgument() {
        return getSrcNamedArgumentList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcNamedArgument list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcNamedArgument list.
     * @apilevel low-level
     */
    public int getNumSrcNamedArgumentNoTransform() {
        return getSrcNamedArgumentListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcNamedArgument list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcNamedArgument list.
     * @apilevel high-level
     */
    public SrcNamedArgument getSrcNamedArgument(int i) {
        return (SrcNamedArgument) getSrcNamedArgumentList().getChild(i);
    }
    /**
     * Check whether the SrcNamedArgument list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcNamedArgument() {
        return getSrcNamedArgumentList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcNamedArgument list.
     * @param node The element to append to the SrcNamedArgument list.
     * @apilevel high-level
     */
    public void addSrcNamedArgument(SrcNamedArgument node) {
        List<SrcNamedArgument> list = (parent == null) ? getSrcNamedArgumentListNoTransform() : getSrcNamedArgumentList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcNamedArgumentNoTransform(SrcNamedArgument node) {
        List<SrcNamedArgument> list = getSrcNamedArgumentListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcNamedArgument list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcNamedArgument(SrcNamedArgument node, int i) {
        List<SrcNamedArgument> list = getSrcNamedArgumentList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcNamedArgument list.
     * @return The node representing the SrcNamedArgument list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcNamedArgument")
    public List<SrcNamedArgument> getSrcNamedArgumentList() {
        List<SrcNamedArgument> list = (List<SrcNamedArgument>) getChild(1);
        return list;
    }
    /**
     * Retrieves the SrcNamedArgument list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcNamedArgument list.
     * @apilevel low-level
     */
    public List<SrcNamedArgument> getSrcNamedArgumentListNoTransform() {
        return (List<SrcNamedArgument>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the SrcNamedArgument list without
     * triggering rewrites.
     */
    public SrcNamedArgument getSrcNamedArgumentNoTransform(int i) {
        return (SrcNamedArgument) getSrcNamedArgumentListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcNamedArgument list.
     * @return The node representing the SrcNamedArgument list.
     * @apilevel high-level
     */
    public List<SrcNamedArgument> getSrcNamedArguments() {
        return getSrcNamedArgumentList();
    }
    /**
     * Retrieves the SrcNamedArgument list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcNamedArgument list.
     * @apilevel low-level
     */
    public List<SrcNamedArgument> getSrcNamedArgumentsNoTransform() {
        return getSrcNamedArgumentListNoTransform();
    }
    /**
     * @attribute syn
     * @aspect Modifiers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:13
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:13")
    public boolean isClassRedeclare() {
        boolean isClassRedeclare_value = false;
        return isClassRedeclare_value;
    }
    /**
     * @attribute syn
     * @aspect Modifiers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:37
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:37")
    public SrcShortClassDecl getSrcClassRedeclare() {
        SrcShortClassDecl getSrcClassRedeclare_value = null;
        return getSrcClassRedeclare_value;
    }
    /**
     * @attribute syn
     * @aspect Modifiers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:58
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:58")
    public boolean isComponentRedeclare() {
        boolean isComponentRedeclare_value = false;
        return isComponentRedeclare_value;
    }
    /**
     * @attribute syn
     * @aspect Modifiers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:79
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Modifiers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Modifiers.jrag:79")
    public SrcComponentDecl getSrcComponentRedeclare() {
        SrcComponentDecl getSrcComponentRedeclare_value = null;
        return getSrcComponentRedeclare_value;
    }
    /**
     * @attribute inh
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:312
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:312")
    public SrcExp parentExp() {
        SrcExp parentExp_value = getParent().Define_parentExp(this, null);
        return parentExp_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:302
     * @apilevel internal
     */
    public boolean Define_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:302
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isSubExp
     */
    protected boolean canDefine_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:313
     * @apilevel internal
     */
    public SrcExp Define_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return parentExp();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:313
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExp
     */
    protected boolean canDefine_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:385
     * @apilevel internal
     */
    public Object Define_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getSrcExpListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:386
            int i = _callerNode.getIndexOfChild(_childNode);
            return Integer.valueOf(i);
        }
        else {
            return super.Define_myFunctionArgumentIdentifier(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:385
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionArgumentIdentifier
     */
    protected boolean canDefine_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:390
     * @apilevel internal
     */
    public int Define_myIdenticalFunctionArgumentIdentifierIndex(ASTNode _callerNode, ASTNode _childNode, Object id) {
        if (_callerNode == getSrcNamedArgumentListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:391
            int i = _callerNode.getIndexOfChild(_childNode);
            {
                    int res = 0;
                    for (int j = 0; j < i; j++) {
                        if (getSrcNamedArgument(j).getName().name().equals(id)) {
                            res++;
                        }
                    }
                    return res;
                }
        }
        else {
            return getParent().Define_myIdenticalFunctionArgumentIdentifierIndex(this, _callerNode, id);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:390
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myIdenticalFunctionArgumentIdentifierIndex
     */
    protected boolean canDefine_myIdenticalFunctionArgumentIdentifierIndex(ASTNode _callerNode, ASTNode _childNode, Object id) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
