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
 * FVariable of type Boolean.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:186
 * @astdecl FPreBooleanVariable : FBooleanVariable;
 * @production FPreBooleanVariable : {@link FBooleanVariable};

 */
public class FPreBooleanVariable extends FBooleanVariable implements Cloneable {
    /**
     * Create a pre variable for a boolean variable.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:570
     */
    public FPreBooleanVariable(FBooleanVariable fv) {
		this(fv.getVisibilityType(), fv.getTypePrefixVariability(),
				TypePrefixInputOutput.NONE, (List) fv.getFAttributeList().fullCopy(), fv.getDerivedType(), 
				new Opt(), new Opt(), fv.getFAccess().fullCopy());
	}
    /**
     * @declaredat ASTNode:1
     */
    public FPreBooleanVariable() {
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
        children = new ASTNode[4];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "FAttribute", "DerivedType", "BindingExp", "FStringComment", "FAccess"},
        type = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "List<FAttribute>", "String", "Opt<FExp>", "Opt<FStringComment>", "FAccess"},
        kind = {"Token", "Token", "Token", "List", "Token", "Opt", "Opt", "Child"}
    )
    public FPreBooleanVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, String p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
    }
    /**
     * @declaredat ASTNode:31
     */
    public FPreBooleanVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, beaver.Symbol p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:42
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:48
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        name_C_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:57
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:61
     */
    public FPreBooleanVariable clone() throws CloneNotSupportedException {
        FPreBooleanVariable node = (FPreBooleanVariable) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:66
     */
    public FPreBooleanVariable copy() {
        try {
            FPreBooleanVariable node = (FPreBooleanVariable) clone();
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
     * @declaredat ASTNode:85
     */
    @Deprecated
    public FPreBooleanVariable fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:95
     */
    public FPreBooleanVariable treeCopyNoTransform() {
        FPreBooleanVariable tree = (FPreBooleanVariable) copy();
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
     * @declaredat ASTNode:115
     */
    public FPreBooleanVariable treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:120
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenVisibilityType_VisibilityType == ((FPreBooleanVariable) node).tokenVisibilityType_VisibilityType) && (tokenTypePrefixVariability_TypePrefixVariability == ((FPreBooleanVariable) node).tokenTypePrefixVariability_TypePrefixVariability) && (tokenTypePrefixInputOutput_TypePrefixInputOutput == ((FPreBooleanVariable) node).tokenTypePrefixInputOutput_TypePrefixInputOutput) && (tokenString_DerivedType == ((FPreBooleanVariable) node).tokenString_DerivedType);    
    }
    /**
     * Replaces the lexeme VisibilityType.
     * @param value The new value for the lexeme VisibilityType.
     * @apilevel high-level
     */
    public void setVisibilityType(VisibilityType value) {
        tokenVisibilityType_VisibilityType = value;
    }
    /**
     * Retrieves the value for the lexeme VisibilityType.
     * @return The value for the lexeme VisibilityType.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="VisibilityType")
    public VisibilityType getVisibilityType() {
        return tokenVisibilityType_VisibilityType;
    }
    /**
     * Replaces the lexeme TypePrefixVariability.
     * @param value The new value for the lexeme TypePrefixVariability.
     * @apilevel high-level
     */
    public void setTypePrefixVariability(TypePrefixVariability value) {
        tokenTypePrefixVariability_TypePrefixVariability = value;
    }
    /**
     * Retrieves the value for the lexeme TypePrefixVariability.
     * @return The value for the lexeme TypePrefixVariability.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="TypePrefixVariability")
    public TypePrefixVariability getTypePrefixVariability() {
        return tokenTypePrefixVariability_TypePrefixVariability;
    }
    /**
     * Replaces the lexeme TypePrefixInputOutput.
     * @param value The new value for the lexeme TypePrefixInputOutput.
     * @apilevel high-level
     */
    public void setTypePrefixInputOutput(TypePrefixInputOutput value) {
        tokenTypePrefixInputOutput_TypePrefixInputOutput = value;
    }
    /**
     * Retrieves the value for the lexeme TypePrefixInputOutput.
     * @return The value for the lexeme TypePrefixInputOutput.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="TypePrefixInputOutput")
    public TypePrefixInputOutput getTypePrefixInputOutput() {
        return tokenTypePrefixInputOutput_TypePrefixInputOutput;
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * @return Number of children in the FAttribute list.
     * @apilevel high-level
     */
    public int getNumFAttribute() {
        return getFAttributeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAttribute list.
     * @apilevel low-level
     */
    public int getNumFAttributeNoTransform() {
        return getFAttributeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAttribute list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAttribute list.
     * @apilevel high-level
     */
    public FAttribute getFAttribute(int i) {
        return (FAttribute) getFAttributeList().getChild(i);
    }
    /**
     * Check whether the FAttribute list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAttribute() {
        return getFAttributeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAttribute list.
     * @param node The element to append to the FAttribute list.
     * @apilevel high-level
     */
    public void addFAttribute(FAttribute node) {
        List<FAttribute> list = (parent == null) ? getFAttributeListNoTransform() : getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAttribute list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAttribute(FAttribute node, int i) {
        List<FAttribute> list = getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAttribute")
    public List<FAttribute> getFAttributeList() {
        List<FAttribute> list = (List<FAttribute>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FAttribute list without
     * triggering rewrites.
     */
    public FAttribute getFAttributeNoTransform(int i) {
        return (FAttribute) getFAttributeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    public List<FAttribute> getFAttributes() {
        return getFAttributeList();
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributesNoTransform() {
        return getFAttributeListNoTransform();
    }
    /**
     * Replaces the lexeme DerivedType.
     * @param value The new value for the lexeme DerivedType.
     * @apilevel high-level
     */
    public void setDerivedType(String value) {
        tokenString_DerivedType = value;
    }
    /**
     * JastAdd-internal setter for lexeme DerivedType using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme DerivedType
     * @apilevel internal
     */
    public void setDerivedType(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setDerivedType is only valid for String lexemes");
        tokenString_DerivedType = (String)symbol.value;
        DerivedTypestart = symbol.getStart();
        DerivedTypeend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme DerivedType.
     * @return The value for the lexeme DerivedType.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="DerivedType")
    public String getDerivedType() {
        return tokenString_DerivedType != null ? tokenString_DerivedType : "";
    }
    /**
     * Replaces the optional node for the BindingExp child. This is the <code>Opt</code>
     * node containing the child BindingExp, not the actual child!
     * @param opt The new node to be used as the optional node for the BindingExp child.
     * @apilevel low-level
     */
    public void setBindingExpOpt(Opt<FExp> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) BindingExp child.
     * @param node The new node to be used as the BindingExp child.
     * @apilevel high-level
     */
    public void setBindingExp(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional BindingExp child exists.
     * @return {@code true} if the optional BindingExp child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasBindingExp() {
        return getBindingExpOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) BindingExp child.
     * @return The BindingExp child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getBindingExp() {
        return (FExp) getBindingExpOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the BindingExp child. This is the <code>Opt</code> node containing the child BindingExp, not the actual child!
     * @return The optional node for child the BindingExp child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="BindingExp")
    public Opt<FExp> getBindingExpOpt() {
        return (Opt<FExp>) getChild(1);
    }
    /**
     * Retrieves the optional node for child BindingExp. This is the <code>Opt</code> node containing the child BindingExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child BindingExp.
     * @apilevel low-level
     */
    public Opt<FExp> getBindingExpOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the FStringComment child. This is the <code>Opt</code>
     * node containing the child FStringComment, not the actual child!
     * @param opt The new node to be used as the optional node for the FStringComment child.
     * @apilevel low-level
     */
    public void setFStringCommentOpt(Opt<FStringComment> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) FStringComment child.
     * @param node The new node to be used as the FStringComment child.
     * @apilevel high-level
     */
    public void setFStringComment(FStringComment node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional FStringComment child exists.
     * @return {@code true} if the optional FStringComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFStringComment() {
        return getFStringCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FStringComment child.
     * @return The FStringComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FStringComment getFStringComment() {
        return (FStringComment) getFStringCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FStringComment child. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * @return The optional node for child the FStringComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FStringComment")
    public Opt<FStringComment> getFStringCommentOpt() {
        return (Opt<FStringComment>) getChild(2);
    }
    /**
     * Retrieves the optional node for child FStringComment. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FStringComment.
     * @apilevel low-level
     */
    public Opt<FStringComment> getFStringCommentOptNoTransform() {
        return (Opt<FStringComment>) getChildNoTransform(2);
    }
    /**
     * Replaces the FAccess child.
     * @param node The new node to replace the FAccess child.
     * @apilevel high-level
     */
    public void setFAccess(FAccess node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the FAccess child.
     * @return The current node used as the FAccess child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAccess")
    public FAccess getFAccess() {
        return (FAccess) getChild(3);
    }
    /**
     * Retrieves the FAccess child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAccess child.
     * @apilevel low-level
     */
    public FAccess getFAccessNoTransform() {
        return (FAccess) getChildNoTransform(3);
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2698")
    public boolean isPreVariable() {
        boolean isPreVariable_value = true;
        return isPreVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344")
    public String name() {
        String name_value = getFAccessNoTransform().preName();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:453
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:453")
    public int variableIndex() {
        int variableIndex_value = myNonPreVariable().variableIndex();
        return variableIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104")
    public String displayName() {
        String displayName_value = name();
        return displayName_value;
    }
    /** @apilevel internal */
    private void name_C_reset() {
        name_C_computed = false;
        
        name_C_value = null;
    }
    /** @apilevel internal */
    protected boolean name_C_computed = false;

    /** @apilevel internal */
    protected String name_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279")
    public String name_C() {
        ASTState state = state();
        if (name_C_computed) {
            return name_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_C_value = preName_C();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_C_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
