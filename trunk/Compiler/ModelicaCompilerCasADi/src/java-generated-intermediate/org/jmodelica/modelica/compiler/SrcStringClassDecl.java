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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:124
 * @astdecl SrcStringClassDecl : SrcPrimitiveClassDecl;
 * @production SrcStringClassDecl : {@link SrcPrimitiveClassDecl};

 */
public class SrcStringClassDecl extends SrcPrimitiveClassDecl implements Cloneable {
    /**
     * Create from a SrcFullClassDecl - will destroy that node!
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:322
     */
    public SrcStringClassDecl(SrcFullClassDecl fcd) {
        super(fcd);
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcStringClassDecl() {
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
        children = new ASTNode[9];
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(Opt.EMPTY, 6);
        setChild(Opt.EMPTY, 7);
    }
    /**
     * @declaredat ASTNode:19
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Encapsulated", "Partial", "SrcRestriction", "Redeclare", "Final", "Inner", "Outer", "Replaceable", "SrcConstrainingClause", "ConstrainingClauseComment", "SrcStringComment", "SrcClause", "SrcExternalClause", "SrcAnnotation", "SrcEndDecl"},
        type = {"SrcIdDecl", "boolean", "boolean", "SrcRestriction", "boolean", "boolean", "boolean", "boolean", "boolean", "Opt<SrcConstrainingClause>", "Opt<SrcComment>", "Opt<SrcStringComment>", "List<SrcClause>", "Opt<SrcExternalClause>", "Opt<SrcAnnotation>", "SrcEndDecl"},
        kind = {"Child", "Token", "Token", "Child", "Token", "Token", "Token", "Token", "Token", "Opt", "Opt", "Opt", "List", "Opt", "Opt", "Child"}
    )
    public SrcStringClassDecl(SrcIdDecl p0, boolean p1, boolean p2, SrcRestriction p3, boolean p4, boolean p5, boolean p6, boolean p7, boolean p8, Opt<SrcConstrainingClause> p9, Opt<SrcComment> p10, Opt<SrcStringComment> p11, List<SrcClause> p12, Opt<SrcExternalClause> p13, Opt<SrcAnnotation> p14, SrcEndDecl p15) {
        setChild(p0, 0);
        setEncapsulated(p1);
        setPartial(p2);
        setChild(p3, 1);
        setRedeclare(p4);
        setFinal(p5);
        setInner(p6);
        setOuter(p7);
        setReplaceable(p8);
        setChild(p9, 2);
        setChild(p10, 3);
        setChild(p11, 4);
        setChild(p12, 5);
        setChild(p13, 6);
        setChild(p14, 7);
        setChild(p15, 8);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:43
     */
    protected int numChildren() {
        return 9;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:49
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public void flushAttrCache() {
        super.flushAttrCache();
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
    public SrcStringClassDecl clone() throws CloneNotSupportedException {
        SrcStringClassDecl node = (SrcStringClassDecl) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:66
     */
    public SrcStringClassDecl copy() {
        try {
            SrcStringClassDecl node = (SrcStringClassDecl) clone();
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
    public SrcStringClassDecl fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:95
     */
    public SrcStringClassDecl treeCopyNoTransform() {
        SrcStringClassDecl tree = (SrcStringClassDecl) copy();
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
    public SrcStringClassDecl treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:120
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_Encapsulated == ((SrcStringClassDecl) node).tokenboolean_Encapsulated) && (tokenboolean_Partial == ((SrcStringClassDecl) node).tokenboolean_Partial) && (tokenboolean_Redeclare == ((SrcStringClassDecl) node).tokenboolean_Redeclare) && (tokenboolean_Final == ((SrcStringClassDecl) node).tokenboolean_Final) && (tokenboolean_Inner == ((SrcStringClassDecl) node).tokenboolean_Inner) && (tokenboolean_Outer == ((SrcStringClassDecl) node).tokenboolean_Outer) && (tokenboolean_Replaceable == ((SrcStringClassDecl) node).tokenboolean_Replaceable);    
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(SrcIdDecl node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public SrcIdDecl getName() {
        return (SrcIdDecl) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public SrcIdDecl getNameNoTransform() {
        return (SrcIdDecl) getChildNoTransform(0);
    }
    /**
     * Replaces the lexeme Encapsulated.
     * @param value The new value for the lexeme Encapsulated.
     * @apilevel high-level
     */
    public void setEncapsulated(boolean value) {
        tokenboolean_Encapsulated = value;
    }
    /**
     * Retrieves the value for the lexeme Encapsulated.
     * @return The value for the lexeme Encapsulated.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Encapsulated")
    public boolean getEncapsulated() {
        return tokenboolean_Encapsulated;
    }
    /**
     * Replaces the lexeme Partial.
     * @param value The new value for the lexeme Partial.
     * @apilevel high-level
     */
    public void setPartial(boolean value) {
        tokenboolean_Partial = value;
    }
    /**
     * Retrieves the value for the lexeme Partial.
     * @return The value for the lexeme Partial.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Partial")
    public boolean getPartial() {
        return tokenboolean_Partial;
    }
    /**
     * Replaces the SrcRestriction child.
     * @param node The new node to replace the SrcRestriction child.
     * @apilevel high-level
     */
    public void setSrcRestriction(SrcRestriction node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the SrcRestriction child.
     * @return The current node used as the SrcRestriction child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcRestriction")
    public SrcRestriction getSrcRestriction() {
        return (SrcRestriction) getChild(1);
    }
    /**
     * Retrieves the SrcRestriction child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcRestriction child.
     * @apilevel low-level
     */
    public SrcRestriction getSrcRestrictionNoTransform() {
        return (SrcRestriction) getChildNoTransform(1);
    }
    /**
     * Replaces the lexeme Redeclare.
     * @param value The new value for the lexeme Redeclare.
     * @apilevel high-level
     */
    public void setRedeclare(boolean value) {
        tokenboolean_Redeclare = value;
    }
    /**
     * Retrieves the value for the lexeme Redeclare.
     * @return The value for the lexeme Redeclare.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Redeclare")
    public boolean getRedeclare() {
        return tokenboolean_Redeclare;
    }
    /**
     * Replaces the lexeme Final.
     * @param value The new value for the lexeme Final.
     * @apilevel high-level
     */
    public void setFinal(boolean value) {
        tokenboolean_Final = value;
    }
    /**
     * Retrieves the value for the lexeme Final.
     * @return The value for the lexeme Final.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Final")
    public boolean getFinal() {
        return tokenboolean_Final;
    }
    /**
     * Replaces the lexeme Inner.
     * @param value The new value for the lexeme Inner.
     * @apilevel high-level
     */
    public void setInner(boolean value) {
        tokenboolean_Inner = value;
    }
    /**
     * Retrieves the value for the lexeme Inner.
     * @return The value for the lexeme Inner.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Inner")
    public boolean getInner() {
        return tokenboolean_Inner;
    }
    /**
     * Replaces the lexeme Outer.
     * @param value The new value for the lexeme Outer.
     * @apilevel high-level
     */
    public void setOuter(boolean value) {
        tokenboolean_Outer = value;
    }
    /**
     * Retrieves the value for the lexeme Outer.
     * @return The value for the lexeme Outer.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Outer")
    public boolean getOuter() {
        return tokenboolean_Outer;
    }
    /**
     * Replaces the lexeme Replaceable.
     * @param value The new value for the lexeme Replaceable.
     * @apilevel high-level
     */
    public void setReplaceable(boolean value) {
        tokenboolean_Replaceable = value;
    }
    /**
     * Retrieves the value for the lexeme Replaceable.
     * @return The value for the lexeme Replaceable.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Replaceable")
    public boolean getReplaceable() {
        return tokenboolean_Replaceable;
    }
    /**
     * Replaces the optional node for the SrcConstrainingClause child. This is the <code>Opt</code>
     * node containing the child SrcConstrainingClause, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcConstrainingClause child.
     * @apilevel low-level
     */
    public void setSrcConstrainingClauseOpt(Opt<SrcConstrainingClause> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) SrcConstrainingClause child.
     * @param node The new node to be used as the SrcConstrainingClause child.
     * @apilevel high-level
     */
    public void setSrcConstrainingClause(SrcConstrainingClause node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional SrcConstrainingClause child exists.
     * @return {@code true} if the optional SrcConstrainingClause child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcConstrainingClause() {
        return getSrcConstrainingClauseOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcConstrainingClause child.
     * @return The SrcConstrainingClause child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcConstrainingClause getSrcConstrainingClause() {
        return (SrcConstrainingClause) getSrcConstrainingClauseOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcConstrainingClause child. This is the <code>Opt</code> node containing the child SrcConstrainingClause, not the actual child!
     * @return The optional node for child the SrcConstrainingClause child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcConstrainingClause")
    public Opt<SrcConstrainingClause> getSrcConstrainingClauseOpt() {
        return (Opt<SrcConstrainingClause>) getChild(2);
    }
    /**
     * Retrieves the optional node for child SrcConstrainingClause. This is the <code>Opt</code> node containing the child SrcConstrainingClause, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcConstrainingClause.
     * @apilevel low-level
     */
    public Opt<SrcConstrainingClause> getSrcConstrainingClauseOptNoTransform() {
        return (Opt<SrcConstrainingClause>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the ConstrainingClauseComment child. This is the <code>Opt</code>
     * node containing the child ConstrainingClauseComment, not the actual child!
     * @param opt The new node to be used as the optional node for the ConstrainingClauseComment child.
     * @apilevel low-level
     */
    public void setConstrainingClauseCommentOpt(Opt<SrcComment> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) ConstrainingClauseComment child.
     * @param node The new node to be used as the ConstrainingClauseComment child.
     * @apilevel high-level
     */
    public void setConstrainingClauseComment(SrcComment node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional ConstrainingClauseComment child exists.
     * @return {@code true} if the optional ConstrainingClauseComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasConstrainingClauseComment() {
        return getConstrainingClauseCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) ConstrainingClauseComment child.
     * @return The ConstrainingClauseComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcComment getConstrainingClauseComment() {
        return (SrcComment) getConstrainingClauseCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the ConstrainingClauseComment child. This is the <code>Opt</code> node containing the child ConstrainingClauseComment, not the actual child!
     * @return The optional node for child the ConstrainingClauseComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="ConstrainingClauseComment")
    public Opt<SrcComment> getConstrainingClauseCommentOpt() {
        return (Opt<SrcComment>) getChild(3);
    }
    /**
     * Retrieves the optional node for child ConstrainingClauseComment. This is the <code>Opt</code> node containing the child ConstrainingClauseComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child ConstrainingClauseComment.
     * @apilevel low-level
     */
    public Opt<SrcComment> getConstrainingClauseCommentOptNoTransform() {
        return (Opt<SrcComment>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the SrcStringComment child. This is the <code>Opt</code>
     * node containing the child SrcStringComment, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcStringComment child.
     * @apilevel low-level
     */
    public void setSrcStringCommentOpt(Opt<SrcStringComment> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) SrcStringComment child.
     * @param node The new node to be used as the SrcStringComment child.
     * @apilevel high-level
     */
    public void setSrcStringComment(SrcStringComment node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional SrcStringComment child exists.
     * @return {@code true} if the optional SrcStringComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcStringComment() {
        return getSrcStringCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcStringComment child.
     * @return The SrcStringComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcStringComment getSrcStringComment() {
        return (SrcStringComment) getSrcStringCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcStringComment child. This is the <code>Opt</code> node containing the child SrcStringComment, not the actual child!
     * @return The optional node for child the SrcStringComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcStringComment")
    public Opt<SrcStringComment> getSrcStringCommentOpt() {
        return (Opt<SrcStringComment>) getChild(4);
    }
    /**
     * Retrieves the optional node for child SrcStringComment. This is the <code>Opt</code> node containing the child SrcStringComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcStringComment.
     * @apilevel low-level
     */
    public Opt<SrcStringComment> getSrcStringCommentOptNoTransform() {
        return (Opt<SrcStringComment>) getChildNoTransform(4);
    }
    /**
     * Replaces the SrcClause list.
     * @param list The new list node to be used as the SrcClause list.
     * @apilevel high-level
     */
    public void setSrcClauseList(List<SrcClause> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the SrcClause list.
     * @return Number of children in the SrcClause list.
     * @apilevel high-level
     */
    public int getNumSrcClause() {
        return getSrcClauseList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcClause list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcClause list.
     * @apilevel low-level
     */
    public int getNumSrcClauseNoTransform() {
        return getSrcClauseListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcClause list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcClause list.
     * @apilevel high-level
     */
    public SrcClause getSrcClause(int i) {
        return (SrcClause) getSrcClauseList().getChild(i);
    }
    /**
     * Check whether the SrcClause list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcClause() {
        return getSrcClauseList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcClause list.
     * @param node The element to append to the SrcClause list.
     * @apilevel high-level
     */
    public void addSrcClause(SrcClause node) {
        List<SrcClause> list = (parent == null) ? getSrcClauseListNoTransform() : getSrcClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcClauseNoTransform(SrcClause node) {
        List<SrcClause> list = getSrcClauseListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcClause list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcClause(SrcClause node, int i) {
        List<SrcClause> list = getSrcClauseList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the SrcClause list.
     * @return The node representing the SrcClause list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="SrcClause")
    public List<SrcClause> getSrcClauseList() {
        List<SrcClause> list = (List<SrcClause>) getChild(5);
        return list;
    }
    /**
     * Retrieves the SrcClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcClause list.
     * @apilevel low-level
     */
    public List<SrcClause> getSrcClauseListNoTransform() {
        return (List<SrcClause>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the SrcClause list without
     * triggering rewrites.
     */
    public SrcClause getSrcClauseNoTransform(int i) {
        return (SrcClause) getSrcClauseListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcClause list.
     * @return The node representing the SrcClause list.
     * @apilevel high-level
     */
    public List<SrcClause> getSrcClauses() {
        return getSrcClauseList();
    }
    /**
     * Retrieves the SrcClause list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcClause list.
     * @apilevel low-level
     */
    public List<SrcClause> getSrcClausesNoTransform() {
        return getSrcClauseListNoTransform();
    }
    /**
     * Replaces the optional node for the SrcExternalClause child. This is the <code>Opt</code>
     * node containing the child SrcExternalClause, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcExternalClause child.
     * @apilevel low-level
     */
    public void setSrcExternalClauseOpt(Opt<SrcExternalClause> opt) {
        setChild(opt, 6);
    }
    /**
     * Replaces the (optional) SrcExternalClause child.
     * @param node The new node to be used as the SrcExternalClause child.
     * @apilevel high-level
     */
    public void setSrcExternalClause(SrcExternalClause node) {
        if (node != null) {
            setChild(new Opt(node), 6);
        } else {
            setChild(Opt.EMPTY, 6);
        }
    }
    /**
     * Check whether the optional SrcExternalClause child exists.
     * @return {@code true} if the optional SrcExternalClause child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcExternalClause() {
        return getSrcExternalClauseOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcExternalClause child.
     * @return The SrcExternalClause child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcExternalClause getSrcExternalClause() {
        return (SrcExternalClause) getSrcExternalClauseOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcExternalClause child. This is the <code>Opt</code> node containing the child SrcExternalClause, not the actual child!
     * @return The optional node for child the SrcExternalClause child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcExternalClause")
    public Opt<SrcExternalClause> getSrcExternalClauseOpt() {
        return (Opt<SrcExternalClause>) getChild(6);
    }
    /**
     * Retrieves the optional node for child SrcExternalClause. This is the <code>Opt</code> node containing the child SrcExternalClause, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcExternalClause.
     * @apilevel low-level
     */
    public Opt<SrcExternalClause> getSrcExternalClauseOptNoTransform() {
        return (Opt<SrcExternalClause>) getChildNoTransform(6);
    }
    /**
     * Replaces the optional node for the SrcAnnotation child. This is the <code>Opt</code>
     * node containing the child SrcAnnotation, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcAnnotation child.
     * @apilevel low-level
     */
    public void setSrcAnnotationOpt(Opt<SrcAnnotation> opt) {
        setChild(opt, 7);
    }
    /**
     * Replaces the (optional) SrcAnnotation child.
     * @param node The new node to be used as the SrcAnnotation child.
     * @apilevel high-level
     */
    public void setSrcAnnotation(SrcAnnotation node) {
        if (node != null) {
            setChild(new Opt(node), 7);
        } else {
            setChild(Opt.EMPTY, 7);
        }
    }
    /**
     * Check whether the optional SrcAnnotation child exists.
     * @return {@code true} if the optional SrcAnnotation child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcAnnotation() {
        return getSrcAnnotationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcAnnotation child.
     * @return The SrcAnnotation child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcAnnotation getSrcAnnotation() {
        return (SrcAnnotation) getSrcAnnotationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcAnnotation child. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * @return The optional node for child the SrcAnnotation child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcAnnotation")
    public Opt<SrcAnnotation> getSrcAnnotationOpt() {
        return (Opt<SrcAnnotation>) getChild(7);
    }
    /**
     * Retrieves the optional node for child SrcAnnotation. This is the <code>Opt</code> node containing the child SrcAnnotation, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcAnnotation.
     * @apilevel low-level
     */
    public Opt<SrcAnnotation> getSrcAnnotationOptNoTransform() {
        return (Opt<SrcAnnotation>) getChildNoTransform(7);
    }
    /**
     * Replaces the SrcEndDecl child.
     * @param node The new node to replace the SrcEndDecl child.
     * @apilevel high-level
     */
    public void setSrcEndDecl(SrcEndDecl node) {
        setChild(node, 8);
    }
    /**
     * Retrieves the SrcEndDecl child.
     * @return The current node used as the SrcEndDecl child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcEndDecl")
    public SrcEndDecl getSrcEndDecl() {
        return (SrcEndDecl) getChild(8);
    }
    /**
     * Retrieves the SrcEndDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcEndDecl child.
     * @apilevel low-level
     */
    public SrcEndDecl getSrcEndDeclNoTransform() {
        return (SrcEndDecl) getChildNoTransform(8);
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
