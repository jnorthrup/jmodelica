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
 * Record constructor in instance trees.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1089
 * @astdecl InstRecordConstructor : FAbstractFunctionCall ::= Record:InstAccess Arg:InstFunctionArgument* InstComponentDecl* InstExtends* InstModification* Type:FType;
 * @production InstRecordConstructor : {@link FAbstractFunctionCall} ::= <span class="component">Record:{@link InstAccess}</span> <span class="component">Arg:{@link InstFunctionArgument}*</span> <span class="component">{@link InstComponentDecl}*</span> <span class="component">{@link InstExtends}*</span> <span class="component">{@link InstModification}*</span> <span class="component">Type:{@link FType}</span>;

 */
public class InstRecordConstructor extends FAbstractFunctionCall implements Cloneable, AllInstComponentSource {
    /**
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:98
     */
    public FExp extractRecordFExp(String suffix) {
        return component(suffix).fullCopy();
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1005
     */
    public InstRecordConstructor createEmptyNode()   { return new InstRecordConstructor();   }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1755
     */
    protected void prettyPrintExp(Printer p, CodeStream str, String indent) {
        str.print(getRecord().name(), "(");
        getArgs().prettyPrintWithSep(p, str, "", ", ");
        str.print(")");
    }
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:520
     */
    public FExp copyReplaceAccess(FExp.ContextReplacer crp) {
        InstAccess name = InstAccess.fromName(getRecord().myInstCallable().actualInstCallable().qualifiedName());
        return new InstRecordConstructor(name, getArgs().copyReplaceAccess(crp));
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:404
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        getRecord().flattenMyRecord(f);
        getArgs().flattenUsedFuncsAndEnums(f);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2748
     */
    public FRecordConstructor flatten(Flattener f) {
        List<FExp> args = new List();
        for (InstFunctionArgument ifa : getArgs()) {
            args.add(ifa.flatten(f));
        }
        return new FRecordConstructor(getRecord().flattenRecordName(), args);
    }
    /**
     * Add a new argument to list of arguments.
     * 
     * This implementation adds the argument to the original arguments 
     * and the expression from the argument as a child.
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:222
     */
    public void addArgument(InstFunctionArgument arg) {
		addArg(arg);
	}
    /**
     * Iterate over all components in this node and all InstExtends (recursively).
     * 
     * @return  an Iterable over the components
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2313
     */
    public Iterable<InstComponentDecl> allInstComponentDecls() {
        return new AllInstComponentIterable(this);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstRecordConstructor() {
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
        children = new ASTNode[7];
        setChild(List.EMPTY, 1);
        setChild(List.EMPTY, 3);
        setChild(List.EMPTY, 4);
        setChild(List.EMPTY, 5);
    }
    /**
     * @declaredat ASTNode:17
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Record", "Arg"},
        type = {"InstAccess", "List<InstFunctionArgument>"},
        kind = {"Child", "List"}
    )
    public InstRecordConstructor(InstAccess p0, List<InstFunctionArgument> p1) {
        setChild(p0, 0);
        setChild(p1, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        genericLookupInstComponent_String_reset();
        localLookupInstComponent_String_reset();
        type_reset();
        getType_reset();
        getMergedEnvironment_reset();
        myEnvironment_def_String_reset();
        getInstComponentDeclList_reset();
        getInstExtendsList_reset();
        getInstModificationList_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:50
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public InstRecordConstructor clone() throws CloneNotSupportedException {
        InstRecordConstructor node = (InstRecordConstructor) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:59
     */
    public InstRecordConstructor copy() {
        try {
            InstRecordConstructor node = (InstRecordConstructor) clone();
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
     * @declaredat ASTNode:78
     */
    @Deprecated
    public InstRecordConstructor fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:88
     */
    public InstRecordConstructor treeCopyNoTransform() {
        InstRecordConstructor tree = (InstRecordConstructor) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 2:
                case 6:
                    tree.children[i] = null;
                    continue;
                case 3:
                case 4:
                case 5:
                    tree.children[i] = List.EMPTY;
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
     * @declaredat ASTNode:119
     */
    public InstRecordConstructor treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:124
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the Record child.
     * @param node The new node to replace the Record child.
     * @apilevel high-level
     */
    public void setRecord(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Record child.
     * @return The current node used as the Record child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Record")
    public InstAccess getRecord() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the Record child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Record child.
     * @apilevel low-level
     */
    public InstAccess getRecordNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Arg list.
     * @param list The new list node to be used as the Arg list.
     * @apilevel high-level
     */
    public void setArgList(List<InstFunctionArgument> list) {
        setChild(list, 1);
    }
    /**
     * Retrieves the number of children in the Arg list.
     * @return Number of children in the Arg list.
     * @apilevel high-level
     */
    public int getNumArg() {
        return getArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Arg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Arg list.
     * @apilevel low-level
     */
    public int getNumArgNoTransform() {
        return getArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Arg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Arg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getArg(int i) {
        return (InstFunctionArgument) getArgList().getChild(i);
    }
    /**
     * Check whether the Arg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasArg() {
        return getArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the Arg list.
     * @param node The element to append to the Arg list.
     * @apilevel high-level
     */
    public void addArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getArgListNoTransform() : getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Arg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 1);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Arg")
    public List<InstFunctionArgument> getArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(1);
        return list;
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(1);
    }
    /**
     * @return the element at index {@code i} in the Arg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getArgNoTransform(int i) {
        return (InstFunctionArgument) getArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Arg list.
     * @return The node representing the Arg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getArgs() {
        return getArgList();
    }
    /**
     * Retrieves the Arg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Arg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getArgsNoTransform() {
        return getArgListNoTransform();
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
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstComponentDeclNoTransform(InstComponentDecl node) {
        List<InstComponentDecl> list = getInstComponentDeclListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
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
            setChild(new List(node), 3);
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
        return 3;
    }
    /**
     * Retrieves the InstComponentDecl list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstComponentDecl list.
     * @apilevel low-level
     */
    public List<InstComponentDecl> getInstComponentDeclListNoTransform() {
        return (List<InstComponentDecl>) getChildNoTransform(3);
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
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstExtendsNoTransform(InstExtends node) {
        List<InstExtends> list = getInstExtendsListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
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
            setChild(new List(node), 4);
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
        return 4;
    }
    /**
     * Retrieves the InstExtends list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstExtends list.
     * @apilevel low-level
     */
    public List<InstExtends> getInstExtendsListNoTransform() {
        return (List<InstExtends>) getChildNoTransform(4);
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
     * Retrieves the number of children in the InstModification list.
     * @return Number of children in the InstModification list.
     * @apilevel high-level
     */
    public int getNumInstModification() {
        return getInstModificationList().getNumChild();
    }
    /**
     * Retrieves the number of children in the InstModification list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the InstModification list.
     * @apilevel low-level
     */
    public int getNumInstModificationNoTransform() {
        return getInstModificationListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the InstModification list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the InstModification list.
     * @apilevel high-level
     */
    public InstModification getInstModification(int i) {
        return (InstModification) getInstModificationList().getChild(i);
    }
    /**
     * Check whether the InstModification list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasInstModification() {
        return getInstModificationList().getNumChild() != 0;
    }
    /**
     * Append an element to the InstModification list.
     * @param node The element to append to the InstModification list.
     * @apilevel high-level
     */
    public void addInstModification(InstModification node) {
        List<InstModification> list = (parent == null) ? getInstModificationListNoTransform() : getInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addInstModificationNoTransform(InstModification node) {
        List<InstModification> list = getInstModificationListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the InstModification list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setInstModification(InstModification node, int i) {
        List<InstModification> list = getInstModificationList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the InstModification list.
     * @return The the child position of the InstModification list.
     * @apilevel low-level
     */
    protected int getInstModificationListChildPosition() {
        return 5;
    }
    /**
     * Retrieves the InstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getInstModificationListNoTransform() {
        return (List<InstModification>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the InstModification list without
     * triggering rewrites.
     */
    public InstModification getInstModificationNoTransform(int i) {
        return (InstModification) getInstModificationListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the InstModification list.
     * @return The node representing the InstModification list.
     * @apilevel high-level
     */
    public List<InstModification> getInstModifications() {
        return getInstModificationList();
    }
    /**
     * Retrieves the InstModification list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the InstModification list.
     * @apilevel low-level
     */
    public List<InstModification> getInstModificationsNoTransform() {
        return getInstModificationListNoTransform();
    }
    /**
     * Retrieves the Type child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Type child.
     * @apilevel low-level
     */
    public FType getTypeNoTransform() {
        return (FType) getChildNoTransform(6);
    }
    /**
     * Retrieves the child position of the optional child Type.
     * @return The the child position of the optional child Type.
     * @apilevel low-level
     */
    protected int getTypeChildPosition() {
        return 6;
    }
    /**
     * Extract a subcomponent of this record expression. Creates new nodes when necessary.
     * Similar to getArray() for arrays.
     * @attribute syn
     * @aspect Components
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Components", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Components.jrag:23")
    public FExp component(String name) {
        {
                int i = 0;
                for (InstComponentDecl icd : myInstClassDecl().allInstComponentDecls()) {
                    if (icd.name().equals(name)) {
                        break;
                    }
                    i++;
                }
                return getArg(i).getFExp();
            }
    }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public CValue cevalCalc(VariableEvaluator evaluator) {
        {
                CValueRecord res = new CValueRecord((FRecordType) type());
                int i = 0;
                for (InstComponentDecl icd : getRecord().myInstClassDecl().allInstComponentDecls()) {
                    CValue val;
                    if (icd.isModifiable()) {
                        val = getArg(i).getFExp().ceval(evaluator);
                    } else {
                        val = icd.ceval(evaluator);
                    }
                    res.setMember(i++, val);
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:338
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:338")
    public String name() {
        String name_value = getRecordNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1078")
    public CommonCallable myCommonCallable() {
        CommonCallable myCommonCallable_value = myInstClassDecl();
        return myCommonCallable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1272
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1272")
    public ArrayList<CommonVariableDecl> myCallInputs() {
        ArrayList<CommonVariableDecl> myCallInputs_value = new ArrayList<CommonVariableDecl>();
        return myCallInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1300
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1300")
    public ArrayList<CommonVariableDecl> myCallOutputs() {
        ArrayList<CommonVariableDecl> myCallOutputs_value = new ArrayList<CommonVariableDecl>();
        return myCallOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1446")
    public String functionCallDecription() {
        String functionCallDecription_value = "Record constructor for " + name();
        return functionCallDecription_value;
    }
    /**
     * @attribute syn
     * @aspect InstFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:127
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:127")
    public Map<InstComponentDecl, InstFunctionArgument> inputArgMap() {
        {
                Map<InstComponentDecl,InstFunctionArgument> res = new HashMap<InstComponentDecl, InstFunctionArgument>();
                int i = 0;
                for (InstComponentDecl icd : myInstClassDecl().allInstComponentDecls()) {
                    res.put(icd, getArg(i++));
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:591
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:591")
    public InstClassDecl myInstClassDecl() {
        InstClassDecl myInstClassDecl_value = getRecord().myInstClassDecl();
        return myInstClassDecl_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:553
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:553")
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
            InstLookupResult<InstComponentDecl> res = localLookupInstComponent(name);
            return res.successful() ? res : lookupInstComponent(name);
        }
    /** @apilevel internal */
    private void localLookupInstComponent_String_reset() {
        localLookupInstComponent_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map localLookupInstComponent_String_values;

    /**
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:558
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:558")
    public InstLookupResult<InstComponentDecl> localLookupInstComponent(String name) {
        Object _parameters = name;
        if (localLookupInstComponent_String_values == null) localLookupInstComponent_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (localLookupInstComponent_String_values.containsKey(_parameters)) {
            return (InstLookupResult<InstComponentDecl>) localLookupInstComponent_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        InstLookupResult<InstComponentDecl> localLookupInstComponent_String_value = localLookupInstComponent_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        localLookupInstComponent_String_values.put(_parameters, localLookupInstComponent_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return localLookupInstComponent_String_value;
    }
    /** @apilevel internal */
    private InstLookupResult<InstComponentDecl> localLookupInstComponent_compute(String name) {
            for (InstComponentDecl icd : getInstComponentDecls()) {
                if (icd.matches(name)) {
                    return InstLookupResult.<InstComponentDecl>found(icd);
                }
            }
            for (InstExtends ie : getInstExtendss()) {
                InstLookupResult<InstComponentDecl> res = ie.memberInstComponent(name);
                if (res.successful()) {
                    return res;
                }
            }
            return InstLookupResult.notFound();
        }
    /**
     * Lookup name in the record declaration.
     * @attribute syn
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:576
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:576")
    public InstComponentDecl declarationInstComponent(String name) {
        InstComponentDecl declarationInstComponent_String_value = myInstClassDecl().memberInstComponent(name).target(INST_UNKNOWN_COMPONENT, this);
        return declarationInstComponent_String_value;
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
        type_value = getType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private void getType_reset() {
        getType_computed = false;
        
        getType_value = null;
    }
    /** @apilevel internal */
    protected boolean getType_computed = false;

    /** @apilevel internal */
    protected FType getType_value;

    /**
     * @attribute syn nta
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:146
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:146")
    public FType getType() {
        ASTState state = state();
        if (getType_computed) {
            return (FType) getChild(getTypeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getType_value = getRecord().recordType().forConstructor(getArgs());
        setChild(getType_value, getTypeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FType node = (FType) this.getChild(getTypeChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = InstFunctionArgument.variability(getArgs());
        return expVariability_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:508
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:508")
    public Environment getMergedEnvironment() {
        ASTState state = state();
        if (getMergedEnvironment_computed) {
            return getMergedEnvironment_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getMergedEnvironment_value = myInstClassDecl().getMergedEnvironment().mergeOuterClone(getInstModifications());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getMergedEnvironment_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getMergedEnvironment_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:591
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:591")
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
        Environment myEnvironment_def_String_value = declarationInstComponent(name).filteredEnvironment().mergeOuterClone(getMergedEnvironment().filter(name));
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myEnvironment_def_String_values.put(_parameters, myEnvironment_def_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return myEnvironment_def_String_value;
    }
    /** @apilevel internal */
    private void getInstComponentDeclList_reset() {
        getInstComponentDeclList_computed = false;
        
        getInstComponentDeclList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstComponentDeclList_computed = false;

    /** @apilevel internal */
    protected List<InstComponentDecl> getInstComponentDeclList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1029
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1029")
    public List<InstComponentDecl> getInstComponentDeclList() {
        ASTState state = state();
        if (getInstComponentDeclList_computed) {
            return (List<InstComponentDecl>) getChild(getInstComponentDeclListChildPosition());
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
        List<InstComponentDecl> node = (List<InstComponentDecl>) this.getChild(getInstComponentDeclListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<InstComponentDecl> getInstComponentDeclList_compute() {
            InstClassDecl rec = getRecord().myInstClassDecl().actualInstClass();
            List<InstComponentDecl> l = new List<InstComponentDecl>();
            for (SrcComponentDecl cd : rec.components()) 
                l.add(rec.createInstComponentDecl(cd));
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
    protected List<InstExtends> getInstExtendsList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1037
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1037")
    public List<InstExtends> getInstExtendsList() {
        ASTState state = state();
        if (getInstExtendsList_computed) {
            return (List<InstExtends>) getChild(getInstExtendsListChildPosition());
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
        List<InstExtends> node = (List<InstExtends>) this.getChild(getInstExtendsListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<InstExtends> getInstExtendsList_compute() {
            InstClassDecl rec = getRecord().myInstClassDecl().actualInstClass();
            List l = new List();
            InstNode lookup = myInstClassDecl().instLookupNodeForShortClassExtends();
            for (SrcExtendsClause e : rec.superClasses()) 
                l.add(rec.createInstExtends(e, lookup));
            return l;
        }
    /** @apilevel internal */
    private void getInstModificationList_reset() {
        getInstModificationList_computed = false;
        
        getInstModificationList_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstModificationList_computed = false;

    /** @apilevel internal */
    protected List<InstModification> getInstModificationList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1046
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1046")
    public List<InstModification> getInstModificationList() {
        ASTState state = state();
        if (getInstModificationList_computed) {
            return (List<InstModification>) getChild(getInstModificationListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstModificationList_value = getInstModificationList_compute();
        if(getInstModificationList_value.numChildren() <= 0) {
            getInstModificationList_value  = List.EMPTY;
        }
        setChild(getInstModificationList_value, getInstModificationListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstModificationList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<InstModification> node = (List<InstModification>) this.getChild(getInstModificationListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<InstModification> getInstModificationList_compute() {
            List<InstModification> res = new List<InstModification>();
            for (InstFunctionArgument ifa : getArgs()) {
                ifa.populateInstModifications(res);
            }
            return res;
        }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:357
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:357")
    public List<InstFunctionArgument> myInstFunctionArguments() {
        List<InstFunctionArgument> myInstFunctionArguments_value = getArgs();
        return myInstFunctionArguments_value;
    }
    /**
     * @attribute inh
     * @aspect FlatteningFunctionConstant
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:284
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatteningFunctionConstant", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:284")
    public boolean canInlineConstant() {
        boolean canInlineConstant_value = getParent().Define_canInlineConstant(this, null);
        return canInlineConstant_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:549
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupComponents", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:549")
    public InstLookupResult<InstComponentDecl> lookupInstComponent(String name) {
        InstLookupResult<InstComponentDecl> lookupInstComponent_String_value = getParent().Define_lookupInstComponent(this, null, name);
        return lookupInstComponent_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:531
     * @apilevel internal
     */
    public int Define_retrieveArrayCompNdims(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return 0;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     */
    public boolean Define_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3145
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecord
     */
    protected boolean canDefine_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3159
     * @apilevel internal
     */
    public boolean Define_inRecordConstructor(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3161
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3160
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_inRecordConstructor(this, _callerNode);
        }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668
     * @apilevel internal
     */
    public boolean Define_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:295
     * @apilevel internal
     */
    public InstModification Define_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstModificationListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:302
            int i = _callerNode.getIndexOfChild(_childNode);
            return getInstModification(i);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1536
     * @apilevel internal
     */
    public boolean Define_inExternalObject(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377
     * @apilevel internal
     */
    public boolean Define_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:377
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFlattened
     */
    protected boolean canDefine_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:952
     * @apilevel internal
     */
    public FAccess Define_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return new FAccessFull();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:290
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return canInlineConstant();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90
     * @apilevel internal
     */
    public boolean Define_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:91
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return super.Define_isInstRecordConstructorArg(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstRecordConstructorArg
     */
    protected boolean canDefine_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108
     * @apilevel internal
     */
    public InstComponentDecl Define_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:110
            int i = _callerNode.getIndexOfChild(_childNode);
            {
                    return localLookupInstComponent(name).targetOrNull();
                }
        }
        else {
            return super.Define_lookupRecordConstructorVirtualInstComponentDecl(_callerNode, _childNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupRecordConstructorVirtualInstComponentDecl
     */
    protected boolean canDefine_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:68
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassFromMod(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:73
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:119
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:117
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:128
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassInChain(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:141
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:139
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
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
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:170
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myInstClassDecl().genericLookupInstClass(name);
        }
        else {
            return getParent().Define_lookupRedeclareExtendsInstClass(this, _callerNode, name);
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
        if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:551
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return genericLookupInstComponent(name);
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return lookupInstComponent(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:36
     * @apilevel internal
     */
    public TypePrefixVariability Define_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return variability();
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:565
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getMergedEnvironment().clone();
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:564
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return getMergedEnvironment().clone();
        }
        else {
            return getParent().Define_myEnvironment(this, _callerNode);
        }
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
        if (_callerNode == getInstExtendsListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:579
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myEnvironment_def(name);
        }
        else if (_callerNode == getInstComponentDeclListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:578
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return myEnvironment_def(name);
        }
        else {
            return getParent().Define_myEnvironment(this, _callerNode, name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     * @apilevel internal
     */
    public boolean Define_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1221
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inProtectedComponent
     */
    protected boolean canDefine_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
