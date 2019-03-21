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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:84
 * @astdecl SrcBaseClassDecl : SrcClassDecl ::= <Encapsulated:boolean> <Partial:boolean> SrcRestriction <Redeclare:boolean> <Final:boolean> <Inner:boolean> <Outer:boolean> <Replaceable:boolean> [SrcConstrainingClause] [ConstrainingClauseComment:SrcComment];
 * @production SrcBaseClassDecl : {@link SrcClassDecl} ::= <span class="component">&lt;Encapsulated:boolean&gt;</span> <span class="component">&lt;Partial:boolean&gt;</span> <span class="component">{@link SrcRestriction}</span> <span class="component">&lt;Redeclare:boolean&gt;</span> <span class="component">&lt;Final:boolean&gt;</span> <span class="component">&lt;Inner:boolean&gt;</span> <span class="component">&lt;Outer:boolean&gt;</span> <span class="component">&lt;Replaceable:boolean&gt;</span> <span class="component">[{@link SrcConstrainingClause}]</span> <span class="component">[ConstrainingClauseComment:{@link SrcComment}]</span>;

 */
public abstract class SrcBaseClassDecl extends SrcClassDecl implements Cloneable {
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1486
     */
    public InstRestriction newInstRestriction() {
        return getSrcRestriction().newInstRestriction();
    }
    /**
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1846
     */
    public Opt newInstConstrainingClassOpt(InstRedeclareClassNode cicr) {
        if (hasSrcConstrainingClause()) {
            SrcConstrainingClause cc = getSrcConstrainingClause();
            Opt opt = cc.hasSrcClassModification() ? new Opt(cc.getSrcClassModification().newInstModification()) : new Opt();
            return new Opt(new InstConstrainingClass(cc.getSrcAccess().newInstAccess(), opt, this, cicr));
        } else {
            return new Opt();
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcBaseClassDecl() {
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
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Encapsulated", "Partial", "SrcRestriction", "Redeclare", "Final", "Inner", "Outer", "Replaceable", "SrcConstrainingClause", "ConstrainingClauseComment"},
        type = {"SrcIdDecl", "boolean", "boolean", "SrcRestriction", "boolean", "boolean", "boolean", "boolean", "boolean", "Opt<SrcConstrainingClause>", "Opt<SrcComment>"},
        kind = {"Child", "Token", "Token", "Child", "Token", "Token", "Token", "Token", "Token", "Opt", "Opt"}
    )
    public SrcBaseClassDecl(SrcIdDecl p0, boolean p1, boolean p2, SrcRestriction p3, boolean p4, boolean p5, boolean p6, boolean p7, boolean p8, Opt<SrcConstrainingClause> p9, Opt<SrcComment> p10) {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:34
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:40
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public SrcBaseClassDecl clone() throws CloneNotSupportedException {
        SrcBaseClassDecl node = (SrcBaseClassDecl) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:63
     */
    @Deprecated
    public abstract SrcBaseClassDecl fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:71
     */
    public abstract SrcBaseClassDecl treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:79
     */
    public abstract SrcBaseClassDecl treeCopy();
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Encapsulated;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Partial;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Redeclare;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Final;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Inner;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Outer;
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
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Replaceable;
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
     * Is this class partial?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:478
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:478")
    public boolean isPartial() {
        boolean isPartial_value = getPartial();
        return isPartial_value;
    }
    /**
     * Is this class encapsulated?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:485
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:485")
    public boolean isEncapsulated() {
        boolean isEncapsulated_value = getEncapsulated();
        return isEncapsulated_value;
    }
    /**
     * Is this class a model?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:492
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:492")
    public boolean isModel() {
        boolean isModel_value = getSrcRestriction().isModel();
        return isModel_value;
    }
    /**
     * Is this class a block?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:505
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:505")
    public boolean isBlock() {
        boolean isBlock_value = getSrcRestriction().isBlock();
        return isBlock_value;
    }
    /**
     * Is this class a class?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:518
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:518")
    public boolean isClass() {
        boolean isClass_value = getSrcRestriction().isClass();
        return isClass_value;
    }
    /**
     * Is this class a package?
     * @attribute syn
     * @aspect ClassRestriction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:531
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassRestriction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:531")
    public boolean isPackage() {
        boolean isPackage_value = getSrcRestriction().isPackage();
        return isPackage_value;
    }
    /**
     * Check if there is a constraining clause with modifications.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:478
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:478")
    public boolean hasConstrainingModification() {
        boolean hasConstrainingModification_value = hasSrcConstrainingClause() && getSrcConstrainingClause().hasSrcClassModification();
        return hasConstrainingModification_value;
    }
    /**
     * Check if this class has a restriction.
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:730
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:730")
    public boolean hasSrcRestriction() {
        boolean hasSrcRestriction_value = true;
        return hasSrcRestriction_value;
    }
    /**
     * Does node match <code>string</code>? Override for node types that 
     * need to be searched for.
     * 
     * Base implementation always returns <code>false</code.
     * Generally, this is implemented with something like 
     * <code>str.equals(name())</code>.
     * 
     * @param str  the string to match
     * @return     <code>true</code if <code>str</code> matches this node, 
     * <code>false</code> otherwise
     * @attribute syn
     * @aspect NodeSearch
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeSearch", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698")
    public boolean matches(String str) {
        boolean matches_String_value = getName().matches(str);
        return matches_String_value;
    }
    /**
     * Get the string comment a.k.a. description string that applies to this element, 
     * or null if there is none.
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:222
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:222")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = selectStringComment(getConstrainingClauseComment());
        return myStringComment_value;
    }
    /**
     * Check if a SrcClassDecl is declared inner.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1285
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1285")
    public boolean isInner() {
        boolean isInner_value = getInner();
        return isInner_value;
    }
    /**
     * Check if a SrcClassDecl is declared outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1291
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1291")
    public boolean isOuter() {
        boolean isOuter_value = getOuter();
        return isOuter_value;
    }
    /**
     * Check if a SrcClassDecl is declared inner or outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1297
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1297")
    public boolean hasInnerOrOuter() {
        boolean hasInnerOrOuter_value = getInner() || getOuter();
        return hasInnerOrOuter_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
