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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:200
 * @astdecl InstComponentRedeclare : InstElementRedeclare ::= InstComponentDecl;
 * @production InstComponentRedeclare : {@link InstElementRedeclare} ::= <span class="component">{@link InstComponentDecl}</span>;

 */
public class InstComponentRedeclare extends InstElementRedeclare implements Cloneable {
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:205
     */
    public boolean contentCheckExtendsOperatorRecord(ErrorCheckType checkType) {
        if (!getInstComponentDecl().isPrimitive() || !isForOperatorRecordDeclarationMember()) {
            error("Short class declarations extending an operator record may only modify attributes of members of the record");
            return false;
        }
        return true;
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:476
     */
    public void contentCheck(ErrorCheckType checkType) {}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1083
     */
    public void collectErrors(ErrorCheckType checkType) {
		if (!errorChecked) {
		    super.collectErrors(checkType);
		    errorChecked = true;
		}
	}
    /**
     * @declaredat ASTNode:1
     */
    public InstComponentRedeclare() {
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
    public InstComponentRedeclare(SrcModificationOrRedeclareElement p0, boolean p1, boolean p2, InstAccess p3) {
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
        getInstComponentDecl_reset();
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
    public InstComponentRedeclare clone() throws CloneNotSupportedException {
        InstComponentRedeclare node = (InstComponentRedeclare) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public InstComponentRedeclare copy() {
        try {
            InstComponentRedeclare node = (InstComponentRedeclare) clone();
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
    public InstComponentRedeclare fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:78
     */
    public InstComponentRedeclare treeCopyNoTransform() {
        InstComponentRedeclare tree = (InstComponentRedeclare) copy();
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
    public InstComponentRedeclare treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:108
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcModificationOrRedeclareElement_SrcModification == ((InstComponentRedeclare) node).tokenSrcModificationOrRedeclareElement_SrcModification) && (tokenboolean_Each == ((InstComponentRedeclare) node).tokenboolean_Each) && (tokenboolean_Final == ((InstComponentRedeclare) node).tokenboolean_Final);    
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
     * Retrieves the InstComponentDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstComponentDecl child.
     * @apilevel low-level
     */
    public InstComponentDecl getInstComponentDeclNoTransform() {
        return (InstComponentDecl) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child InstComponentDecl.
     * @return The the child position of the optional child InstComponentDecl.
     * @apilevel low-level
     */
    protected int getInstComponentDeclChildPosition() {
        return 1;
    }
    /**
     * Find the actual redeclared component for a redeclaration modification.
     * @attribute syn
     * @aspect LookupInstComponentsInModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:766
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LookupInstComponentsInModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:766")
    public InstComponentDecl myInstReplacingComponent() {
        InstComponentDecl myInstReplacingComponent_value = lookupInstReplacingComponent(name()).target(INST_UNKNOWN_COMPONENT, this);
        return myInstReplacingComponent_value;
    }
    /**
     * @attribute syn
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:314")
    public SrcComponentDecl getComponentRedeclareDecl() {
        SrcComponentDecl getComponentRedeclareDecl_value = getSrcModification().componentRedeclareDecl();
        return getComponentRedeclareDecl_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:434
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:434")
    public java.util.List<InstModification> instModificationsFromConstrainingType() {
        {
                InstLookupResult<InstComponentDecl> repl = lookupInstComponentInInstElement(name());
                if (repl.successful()) 
                    return repl.target().instModificationsFromConstrainingType();
                else
                    return Collections.<InstModification>emptyList();
            }
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
        boolean hasConstrainingModification_value = getComponentRedeclareDecl().hasConstrainingModification();
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
                    return getInstComponentDecl().getInstConstrainingComponent().getInstClassModification();
                return null;
            }
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:682
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:682")
    public InstComponentRedeclare matchInstComponentRedeclare(String name) {
        {
                if (getName().name().equals(name))
                    return this;
                else
                    return null;
            }
    }
    /** @apilevel internal */
    private void getInstComponentDecl_reset() {
        getInstComponentDecl_computed = false;
        
        getInstComponentDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstComponentDecl_computed = false;

    /** @apilevel internal */
    protected InstComponentDecl getInstComponentDecl_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1615
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1615")
    public InstComponentDecl getInstComponentDecl() {
        ASTState state = state();
        if (getInstComponentDecl_computed) {
            return (InstComponentDecl) getChild(getInstComponentDeclChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstComponentDecl_value = new InstCreateComponentDecl(getComponentRedeclareDecl(), null);
        setChild(getInstComponentDecl_value, getInstComponentDeclChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstComponentDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        InstComponentDecl node = (InstComponentDecl) this.getChild(getInstComponentDeclChildPosition());
        return node;
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
     * @aspect LookupInstComponentsInModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="LookupInstComponentsInModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:751")
    public InstLookupResult<InstComponentDecl> lookupInstComponentInInstElement(String name) {
        InstLookupResult<InstComponentDecl> lookupInstComponentInInstElement_String_value = getParent().Define_lookupInstComponentInInstElement(this, null, name);
        return lookupInstComponentInInstElement_String_value;
    }
    /**
     * @attribute inh
     * @aspect LookupInstComponentsInModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:769
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="LookupInstComponentsInModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:769")
    public InstLookupResult<InstComponentDecl> lookupInstReplacingComponent(String name) {
        InstLookupResult<InstComponentDecl> lookupInstReplacingComponent_String_value = getParent().Define_lookupInstReplacingComponent(this, null, name);
        return lookupInstReplacingComponent_String_value;
    }
    /**
     * @attribute inh
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597")
    public Environment myEnvironment(String name) {
        Environment myEnvironment_String_value = getParent().Define_myEnvironment(this, null, name);
        return myEnvironment_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1142
     * @apilevel internal
     */
    public Size Define_defaultSize(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstComponentDeclNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1143
            return myInstReplacingComponent().declaredSize();
        }
        else {
            return super.Define_defaultSize(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1142
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute defaultSize
     */
    protected boolean canDefine_defaultSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1150
     * @apilevel internal
     */
    public Size Define_defaultSizeCalc(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstComponentDeclNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1151
            return myInstReplacingComponent().declaredSizeCalc();
        }
        else {
            return super.Define_defaultSizeCalc(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1150
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute defaultSizeCalc
     */
    protected boolean canDefine_defaultSizeCalc(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:759
            return lookupInstComponentInInstElement(name);
        }
        else {
            return super.Define_lookupInstComponent(_callerNode, _childNode, name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:94
     * @apilevel internal
     */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getNameNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:111
            return Kind.COMPONENT_ACCESS;
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
        if (_callerNode == getInstComponentDeclNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:602
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
