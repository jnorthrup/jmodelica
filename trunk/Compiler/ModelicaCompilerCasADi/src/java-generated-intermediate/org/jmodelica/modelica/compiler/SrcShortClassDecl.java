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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:110
 * @astdecl SrcShortClassDecl : SrcBaseClassDecl ::= SrcExtendsClauseShortClass;
 * @production SrcShortClassDecl : {@link SrcBaseClassDecl} ::= <span class="component">{@link SrcExtendsClauseShortClass}</span>;

 */
public class SrcShortClassDecl extends SrcBaseClassDecl implements Cloneable {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:282
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(indent);
        indent = p.indent(indent);
        if (getEncapsulated()) {
            str.print("encapsulated ");
        }
        if (getPartial()) {
            str.print("partial ");
        }
        if (getRedeclare()) {
            str.print("redeclare ");
        }
        if (getFinal()) {
            str.print("final ");
        }
        if (getInner()) {
            str.print("inner ");
        }
        if (getOuter()) {
            str.print("outer ");
        }
        if (getReplaceable()) {
            str.print("replaceable ");
        }
        
        str.print(getSrcRestriction(), " ");
        p.print(getName(), str, indent);
        str.print(" = ", getSrcExtendsClauseShortClass().getSuper().name());
        if (getSrcExtendsClauseShortClass().hasSrcArraySubscripts()) {
            p.print(getSrcExtendsClauseShortClass().getSrcArraySubscripts(), str, indent);
        }
        if (getSrcExtendsClauseShortClass().hasSrcClassModification()) {
            p.print(getSrcExtendsClauseShortClass().getSrcClassModification(), str, indent);
        }
        if (hasSrcConstrainingClause()) {
            p.print(getSrcConstrainingClause(), str, indent);
        }
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1407
     */
    public InstShortClassDecl newInstClassDecl() {
        Opt fas_opt = new Opt();
        if (getSrcExtendsClauseShortClass().hasSrcArraySubscripts()) {
            fas_opt.setChild(getSrcExtendsClauseShortClass().getSrcArraySubscripts().instantiate(),0);
        }
        InstShortClassDecl scd =  new InstShortClassDecl(this, new Opt(), 
                newInstRestriction(),fas_opt);
        scd.setInstConstrainingClassOpt(newInstConstrainingClassOpt(null));     
        scd.setLocation(this);
        return scd;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1471
     */
    public InstClassDecl createInstReplacingClass(
            SrcClassDecl replacedClass, InstRedeclareClassNode icr, InstRedeclareClassNode cicr) {
        Opt fas_opt = new Opt();
        if (getSrcExtendsClauseShortClass().hasSrcArraySubscripts()) {
            fas_opt.setChild(getSrcExtendsClauseShortClass().getSrcArraySubscripts().instantiate(), 0);
        }
        SrcClassDecl constrainingDecl = (cicr == null) ? replacedClass : cicr.redeclaringClassDecl();
        InstRestriction ir = newInstRestriction();
        InstReplacingShortClassDecl scd =  new InstReplacingShortClassDecl(this, new Opt(), ir, fas_opt, replacedClass, icr);
        scd.setInstConstrainingClassOpt(constrainingDecl.newInstConstrainingClassOpt(cicr));
        scd.setLocation(this);
        return scd;
     }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:508
     */
    public RootAnnotationProviderProxy<SrcShortClassDecl, SrcModification> createModifierProvider(){
            return new RootAnnotationProviderProxy<SrcShortClassDecl, SrcModification>(this) {
            
            @Override
            protected boolean hasProvider() {
                return owningNode.getSrcExtendsClauseShortClass().hasSrcClassModification();
            }

            @Override
            protected void createProvider() {
                owningNode.getSrcExtendsClauseShortClass().setSrcClassModification(new SrcClassModification());
            }

            @Override
            protected SrcModification getProvider() {
                return owningNode.getSrcExtendsClauseShortClass().getSrcClassModification();
            }
        };
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcShortClassDecl() {
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
        children = new ASTNode[5];
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "Encapsulated", "Partial", "SrcRestriction", "Redeclare", "Final", "Inner", "Outer", "Replaceable", "SrcConstrainingClause", "ConstrainingClauseComment", "SrcExtendsClauseShortClass"},
        type = {"SrcIdDecl", "boolean", "boolean", "SrcRestriction", "boolean", "boolean", "boolean", "boolean", "boolean", "Opt<SrcConstrainingClause>", "Opt<SrcComment>", "SrcExtendsClauseShortClass"},
        kind = {"Child", "Token", "Token", "Child", "Token", "Token", "Token", "Token", "Token", "Opt", "Opt", "Child"}
    )
    public SrcShortClassDecl(SrcIdDecl p0, boolean p1, boolean p2, SrcRestriction p3, boolean p4, boolean p5, boolean p6, boolean p7, boolean p8, Opt<SrcConstrainingClause> p9, Opt<SrcComment> p10, SrcExtendsClauseShortClass p11) {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:35
     */
    protected int numChildren() {
        return 5;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:41
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public SrcShortClassDecl clone() throws CloneNotSupportedException {
        SrcShortClassDecl node = (SrcShortClassDecl) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:58
     */
    public SrcShortClassDecl copy() {
        try {
            SrcShortClassDecl node = (SrcShortClassDecl) clone();
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
     * @declaredat ASTNode:77
     */
    @Deprecated
    public SrcShortClassDecl fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:87
     */
    public SrcShortClassDecl treeCopyNoTransform() {
        SrcShortClassDecl tree = (SrcShortClassDecl) copy();
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
     * @declaredat ASTNode:107
     */
    public SrcShortClassDecl treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:112
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_Encapsulated == ((SrcShortClassDecl) node).tokenboolean_Encapsulated) && (tokenboolean_Partial == ((SrcShortClassDecl) node).tokenboolean_Partial) && (tokenboolean_Redeclare == ((SrcShortClassDecl) node).tokenboolean_Redeclare) && (tokenboolean_Final == ((SrcShortClassDecl) node).tokenboolean_Final) && (tokenboolean_Inner == ((SrcShortClassDecl) node).tokenboolean_Inner) && (tokenboolean_Outer == ((SrcShortClassDecl) node).tokenboolean_Outer) && (tokenboolean_Replaceable == ((SrcShortClassDecl) node).tokenboolean_Replaceable);    
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
     * Replaces the SrcExtendsClauseShortClass child.
     * @param node The new node to replace the SrcExtendsClauseShortClass child.
     * @apilevel high-level
     */
    public void setSrcExtendsClauseShortClass(SrcExtendsClauseShortClass node) {
        setChild(node, 4);
    }
    /**
     * Retrieves the SrcExtendsClauseShortClass child.
     * @return The current node used as the SrcExtendsClauseShortClass child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcExtendsClauseShortClass")
    public SrcExtendsClauseShortClass getSrcExtendsClauseShortClass() {
        return (SrcExtendsClauseShortClass) getChild(4);
    }
    /**
     * Retrieves the SrcExtendsClauseShortClass child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcExtendsClauseShortClass child.
     * @apilevel low-level
     */
    public SrcExtendsClauseShortClass getSrcExtendsClauseShortClassNoTransform() {
        return (SrcExtendsClauseShortClass) getChildNoTransform(4);
    }
    /**
     * Is this element a short class decl?
     * @attribute syn
     * @aspect NodeTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:452
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:452")
    public boolean isShortClassDecl() {
        boolean isShortClassDecl_value = true;
        return isShortClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect NodeTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:455
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:455")
    public SrcShortClassDecl asShortClassDecl() {
        SrcShortClassDecl asShortClassDecl_value = this;
        return asShortClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:486
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:486")
    public boolean hasSrcClassModification() {
        boolean hasSrcClassModification_value = getSrcExtendsClauseShortClass().hasSrcClassModification();
        return hasSrcClassModification_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1693
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1693")
    public boolean hasSrcTypePrefix() {
        boolean hasSrcTypePrefix_value = getSrcExtendsClauseShortClass().hasSrcTypePrefix();
        return hasSrcTypePrefix_value;
    }
    /**
     * Lookup in contained classes and extended classes. Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:409")
    public ResolvedAccess simpleLookupMemberScope(String name) {
        ResolvedAccess simpleLookupMemberScope_String_value = getSrcExtendsClauseShortClass().findClassDecl().simpleLookupMemberScope(name);
        return simpleLookupMemberScope_String_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43")
    public Iterable<SrcExtendsClause> superClasses() {
        Iterable<SrcExtendsClause> superClasses_value = Collections.<SrcExtendsClause>singletonList(getSrcExtendsClauseShortClass());
        return superClasses_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = getSrcExtendsClauseShortClass().annotation(instContext);
        return annotation_InstContext_value;
    }
    /*******************
     * Class Decls    
     * ****************
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:367")
    public SrcAnnotationProvider srcAnnotationProvider() {
        {
                SrcComment comment = getSrcExtendsClauseShortClass().getSrcComment();
                Opt<SrcComment> ccCommentOpt = getConstrainingClauseCommentOpt();
        
                if (ccCommentOpt.numChildren() > 0) {
                    return SrcAnnotationNode.createProviderFor(comment, ccCommentOpt.getChild(0));
                }
                return SrcAnnotationNode.createProviderFor(comment);
            }
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1636
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1636")
    public boolean isInput() {
        boolean isInput_value = hasInputOrOutput() && getSrcExtendsClauseShortClass().getSrcTypePrefixInputOutput().isInput();
        return isInput_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1640
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1640")
    public boolean isOutput() {
        boolean isOutput_value = hasInputOrOutput() && getSrcExtendsClauseShortClass().getSrcTypePrefixInputOutput().isOutput();
        return isOutput_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1644
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1644")
    public boolean hasInputOrOutput() {
        boolean hasInputOrOutput_value = getSrcExtendsClauseShortClass().hasSrcTypePrefixInputOutput();
        return hasInputOrOutput_value;
    }
    /**
     * @attribute syn
     * @aspect SrcStringComments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1813
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcStringComments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1813")
    public boolean hasSrcStringComment() {
        boolean hasSrcStringComment_value = getSrcExtendsClauseShortClass().getSrcComment().hasSrcStringComment();
        return hasSrcStringComment_value;
    }
    /**
     * @attribute syn
     * @aspect SrcStringComments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1814
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcStringComments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1814")
    public SrcStringComment getSrcStringComment() {
        SrcStringComment getSrcStringComment_value = getSrcExtendsClauseShortClass().getSrcComment().getSrcStringComment();
        return getSrcStringComment_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912
     * @apilevel internal
     */
    public SrcBaseClassDecl Define_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getSrcExtendsClauseShortClassNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:919
            return this;
        }
        else {
            return getParent().Define_enclosingClassDecl(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingClassDecl
     */
    protected boolean canDefine_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
