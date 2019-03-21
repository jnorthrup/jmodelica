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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:199
 * @astdecl InstClassRedeclare : InstElementRedeclare ::= InstClassDecl;
 * @production InstClassRedeclare : {@link InstElementRedeclare} ::= <span class="component">{@link InstClassDecl}</span>;

 */
public class InstClassRedeclare extends InstElementRedeclare implements Cloneable, InstRedeclareClassNode {
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1135
     */
    public void collectErrors(ErrorCheckType checkType) {
		super.collectErrors(checkType);
//		if (!inInstComponent())
//			getInstClassDecl().collectErrors(checkType);	
	}
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2130
     */
    public void collectAttributes(Flattener f,
            List<FAttribute> attrs, AttributeExpRetriever aer, boolean cls) {}
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1181
     */
    public InstExtends createInstReplacingExtends(SrcExtendsClause ec, InstNode lookup) {
        for (InstExtends ie : getInstClassDecl().actualInstClass().getInstExtendss())
            return ie.createInstReplacingExtends(ec, lookup);
        return ec.newInstExtends(lookup);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstClassRedeclare() {
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
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcModification", "Each", "Final", "Name"},
        type = {"SrcModificationOrRedeclareElement", "boolean", "boolean", "InstAccess"},
        kind = {"Token", "Token", "Token", "Child"}
    )
    public InstClassRedeclare(SrcModificationOrRedeclareElement p0, boolean p1, boolean p2, InstAccess p3) {
        setSrcModification(p0);
        setEach(p1);
        setFinal(p2);
        setChild(p3, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 1;
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
        getInstClassDecl_reset();
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
    public InstClassRedeclare clone() throws CloneNotSupportedException {
        InstClassRedeclare node = (InstClassRedeclare) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public InstClassRedeclare copy() {
        try {
            InstClassRedeclare node = (InstClassRedeclare) clone();
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
    public InstClassRedeclare fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public InstClassRedeclare treeCopyNoTransform() {
        InstClassRedeclare tree = (InstClassRedeclare) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 1:
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
     * @declaredat ASTNode:103
     */
    public InstClassRedeclare treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:108
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcModificationOrRedeclareElement_SrcModification == ((InstClassRedeclare) node).tokenSrcModificationOrRedeclareElement_SrcModification) && (tokenboolean_Each == ((InstClassRedeclare) node).tokenboolean_Each) && (tokenboolean_Final == ((InstClassRedeclare) node).tokenboolean_Final);    
    }
    /**
     * Replaces the lexeme SrcModification.
     * @param value The new value for the lexeme SrcModification.
     * @apilevel high-level
     */
    public void setSrcModification(SrcModificationOrRedeclareElement value) {
        tokenSrcModificationOrRedeclareElement_SrcModification = value;
    }
    /**
     * Retrieves the value for the lexeme SrcModification.
     * @return The value for the lexeme SrcModification.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcModification")
    public SrcModificationOrRedeclareElement getSrcModification() {
        return tokenSrcModificationOrRedeclareElement_SrcModification;
    }
    /**
     * Replaces the lexeme Each.
     * @param value The new value for the lexeme Each.
     * @apilevel high-level
     */
    public void setEach(boolean value) {
        tokenboolean_Each = value;
    }
    /**
     * Retrieves the value for the lexeme Each.
     * @return The value for the lexeme Each.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Each")
    public boolean getEach() {
        return tokenboolean_Each;
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
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(InstAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public InstAccess getName() {
        return (InstAccess) getChild(0);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public InstAccess getNameNoTransform() {
        return (InstAccess) getChildNoTransform(0);
    }
    /**
     * Retrieves the InstClassDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstClassDecl child.
     * @apilevel low-level
     */
    public InstClassDecl getInstClassDeclNoTransform() {
        return (InstClassDecl) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child InstClassDecl.
     * @return The the child position of the optional child InstClassDecl.
     * @apilevel low-level
     */
    protected int getInstClassDeclChildPosition() {
        return 1;
    }
    /**
     * @attribute syn
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:312
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:312")
    public SrcClassRedeclare getSrcClassRedeclare() {
        SrcClassRedeclare getSrcClassRedeclare_value = (SrcClassRedeclare)        getSrcModification();
        return getSrcClassRedeclare_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:442
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:442")
    public java.util.List<InstModification> instModificationsFromConstrainingType() {
        {
                InstLookupResult<InstClassDecl> repl = lookupInstClassInInstElement(name());
                if (repl.successful()) 
                    return repl.target().instModificationsFromConstrainingType();
                else
                    return Collections.<InstModification>emptyList();
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:465
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:465")
    public boolean hasInstClassModification() {
        boolean hasInstClassModification_value = getSrcClassRedeclare().getSrcBaseClassDecl().hasSrcClassModification();
        return hasInstClassModification_value;
    }
    /**
     * Check if there is a constraining clause with modifications.
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:470
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:470")
    public boolean hasConstrainingModification() {
        boolean hasConstrainingModification_value = getSrcClassRedeclare().getSrcBaseClassDecl().hasConstrainingModification();
        return hasConstrainingModification_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:642
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:642")
    public InstModification matchInstModification(String name) {
        {
                if (name().equals(name) && hasConstrainingModification())
                    return getInstClassDecl().getInstConstrainingClass().getInstClassModification();
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:690
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:690")
    public InstClassRedeclare matchInstClassRedeclare(String name) {
        {
                if (getName().name().equals(name))
                    return this;
                else
                    return null;
            }
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1024
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1024")
    public InstNode instLookupNodeForShortClassExtends() {
        InstNode instLookupNodeForShortClassExtends_value = myInstNode();
        return instLookupNodeForShortClassExtends_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1141
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1141")
    public SrcClassDecl redeclaringClassDecl() {
        SrcClassDecl redeclaringClassDecl_value = getSrcClassRedeclare().getSrcBaseClassDecl();
        return redeclaringClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1144
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1144")
    public InstClassDecl redeclaringInstClassDecl() {
        InstClassDecl redeclaringInstClassDecl_value = getInstClassDecl();
        return redeclaringInstClassDecl_value;
    }
    /** @apilevel internal */
    private void getInstClassDecl_reset() {
        getInstClassDecl_computed = false;
        
        getInstClassDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstClassDecl_computed = false;

    /** @apilevel internal */
    protected InstClassDecl getInstClassDecl_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1611
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1611")
    public InstClassDecl getInstClassDecl() {
        ASTState state = state();
        if (getInstClassDecl_computed) {
            return (InstClassDecl) getChild(getInstClassDeclChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstClassDecl_value = getInstClassDecl_compute();
        setChild(getInstClassDecl_value, getInstClassDeclChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstClassDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        InstClassDecl node = (InstClassDecl) this.getChild(getInstClassDeclChildPosition());
        return node;
    }
    /** @apilevel internal */
    private InstClassDecl getInstClassDecl_compute() {
        	return getSrcClassRedeclare().getSrcBaseClassDecl().newInstClassDecl();
        }
    /**
     * @attribute syn
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2281
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2281")
    public boolean isThisClass(InstNode node) {
        boolean isThisClass_InstNode_value = getInstClassDecl().isThisClass(node);
        return isThisClass_InstNode_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2076
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2076")
    public boolean isRedeclare() {
        boolean isRedeclare_value = true;
        return isRedeclare_value;
    }
    /**
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:668")
    public boolean inInstComponent() {
        boolean inInstComponent_value = getParent().Define_inInstComponent(this, null);
        return inInstComponent_value;
    }
    /**
     * @attribute inh
     * @aspect InstLookupClassesInModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:646
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstLookupClassesInModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:646")
    public InstLookupResult<InstClassDecl> lookupInstClassInInstElement(String name) {
        InstLookupResult<InstClassDecl> lookupInstClassInInstElement_String_value = getParent().Define_lookupInstClassInInstElement(this, null, name);
        return lookupInstClassInInstElement_String_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:598
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:598")
    public Environment myEnvironment(String name) {
        Environment myEnvironment_String_value = getParent().Define_myEnvironment(this, null, name);
        return myEnvironment_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:639
            return lookupInstClassInInstElement(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:110
            return Kind.CLASS_ACCESS;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstClassDeclNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:604
            return myEnvironment(name).mergeInnerClone(instModificationsFromConstrainingType());
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
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
