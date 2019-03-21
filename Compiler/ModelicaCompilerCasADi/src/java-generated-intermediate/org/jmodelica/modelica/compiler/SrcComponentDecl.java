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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:189
 * @astdecl SrcComponentDecl : SrcBaseNode ::= Name:SrcIdDecl [VarArraySubscripts:SrcArraySubscripts] [SrcModification] [SrcConditionalAttribute] SrcComment;
 * @production SrcComponentDecl : {@link SrcBaseNode} ::= <span class="component">Name:{@link SrcIdDecl}</span> <span class="component">[VarArraySubscripts:{@link SrcArraySubscripts}]</span> <span class="component">[{@link SrcModification}]</span> <span class="component">[{@link SrcConditionalAttribute}]</span> <span class="component">{@link SrcComment}</span>;

 */
public class SrcComponentDecl extends SrcBaseNode implements Cloneable, ClassLookupable, SrcModificationOrRedeclareElement {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:577
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(getName().getID());
        p.print(getVarArraySubscriptsOpt(), str, indent);
        p.print(getSrcModificationOpt(), str, indent);
        p.print(getSrcConditionalAttributeOpt(), str, indent);
    }
    /**
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:285
     */
    public InstComponentRedeclare newInstModification() {
        if (!hasRedeclare()) {
            throw new UnsupportedOperationException();
        }
        InstAccess name;
        if (hasVarArraySubscripts()) {
            name = new InstParseArrayAccess(getName().getID(), getVarArraySubscripts().instantiate());
        } else {
            name = new InstParseAccess(getName().getID());
        }
        name.setLocation(getName());
        InstComponentRedeclare icr = new InstComponentRedeclare(this, false, false, name);
        icr.setLocation(myComponentClause());
        return icr;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1310
     */
    public FArraySubscripts instantiateArraySubscripts() {
        FArrayExpSubscripts fas = null;
        if (hasVarArraySubscripts()) {
            fas = getVarArraySubscripts().instantiate();
        }
        if (hasTypeArraySubscripts()) {
            FArrayExpSubscripts fas2 = getTypeArraySubscripts().instantiate();
            if (fas == null) {
                fas = fas2;
            } else {
                for (FSubscript s : fas2.getFSubscripts()) {
                    fas.addFSubscript(s);
                }
            }
        }
        return fas;
    }
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1568
     */
    public InstAccess newInstClassAccess() {
        return getClassName().newInstAccess();
    }
    /**
     * @aspect InstaceConstrainingClauses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1832
     */
    public Opt newInstConstrainingComponentOpt(InstComponentRedeclare cicr) {
        if (hasSrcConstrainingClause()) {
            SrcConstrainingClause cc = getSrcConstrainingClause();
            Opt opt = cc.hasSrcClassModification() ? new Opt(cc.getSrcClassModification().newInstModification()) : new Opt();
            return new Opt(new InstConstrainingComponent(cc.getSrcAccess().newInstAccess(), opt, this, cicr));
        } else {
            return new Opt();
        }
    }
    /**
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:525
     */
    protected ResolvedAccess simpleLookupFromModification(String name) {
        ResolvedAccess res = findClassDecl().simpleLookupMemberScope(name);
        if (!res.isUnknown()) {
            return res.fromContext(enclosingClassDecl().qualifiedName() + "." + name(), isProtected());
        }
        return simpleLookupHelper(name);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:43
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return srcAnnotation(SrcAnnotationNode.defaultEvaluator(), path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:81
     */
    public SrcAnnotationNode srcAnnotation(Evaluator<SrcExp> evaluator, String ... path) {
        return SrcAnnotationNode.createFor(srcAnnotationProvider(), evaluator, path);
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:528
     */
    public RootAnnotationProviderProxy<SrcComponentDecl, SrcModification> createModifierProvider() {
        return new RootAnnotationProviderProxy<SrcComponentDecl, SrcModification>(this) {
            @Override
            protected boolean hasProvider() {
                return owningNode.hasSrcModification();
            }

            @Override
            protected void createProvider() {
                owningNode.setSrcModification(new SrcCompleteModification(new SrcClassModification()));
            }

            @Override
            protected SrcModification getProvider() {
                return owningNode.getSrcModification();
            }
            
            @Override
            public final SrcExp annotationValue() {
                if (hasProvider())
                    return getProvider().annotationValue();
                return null;
            }
            
            @Override
            public final void setAnnotationValue(SrcExp newValue) throws FailedToSetAnnotationValueException {
                if (hasProvider()) {
                    getProvider().setAnnotationValue(newValue);
                } else {
                    owningNode.setSrcModification(new SrcValueModification(newValue));
                }
            }
            
            @Override
            public SrcAnnotationProvider addAnnotationSubNode(String name) {
                if (!hasProvider()) {
                    createProvider();
                }else if (owningNode.getSrcModification().isValueModification()) {
                    setSrcModification(owningNode.getSrcModification().moveValueModIntoCompleteMod());
                }
                return getProvider().addAnnotationSubNode(name);
            }
        };
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcComponentDecl() {
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
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Name", "VarArraySubscripts", "SrcModification", "SrcConditionalAttribute", "SrcComment"},
        type = {"SrcIdDecl", "Opt<SrcArraySubscripts>", "Opt<SrcModification>", "Opt<SrcConditionalAttribute>", "SrcComment"},
        kind = {"Child", "Opt", "Opt", "Opt", "Child"}
    )
    public SrcComponentDecl(SrcIdDecl p0, Opt<SrcArraySubscripts> p1, Opt<SrcModification> p2, Opt<SrcConditionalAttribute> p3, SrcComment p4) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:29
     */
    protected int numChildren() {
        return 5;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:35
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public void flushAttrCache() {
        super.flushAttrCache();
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
    public SrcComponentDecl clone() throws CloneNotSupportedException {
        SrcComponentDecl node = (SrcComponentDecl) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public SrcComponentDecl copy() {
        try {
            SrcComponentDecl node = (SrcComponentDecl) clone();
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
    public SrcComponentDecl fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:81
     */
    public SrcComponentDecl treeCopyNoTransform() {
        SrcComponentDecl tree = (SrcComponentDecl) copy();
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
     * @declaredat ASTNode:101
     */
    public SrcComponentDecl treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:106
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
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
     * Replaces the optional node for the VarArraySubscripts child. This is the <code>Opt</code>
     * node containing the child VarArraySubscripts, not the actual child!
     * @param opt The new node to be used as the optional node for the VarArraySubscripts child.
     * @apilevel low-level
     */
    public void setVarArraySubscriptsOpt(Opt<SrcArraySubscripts> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) VarArraySubscripts child.
     * @param node The new node to be used as the VarArraySubscripts child.
     * @apilevel high-level
     */
    public void setVarArraySubscripts(SrcArraySubscripts node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional VarArraySubscripts child exists.
     * @return {@code true} if the optional VarArraySubscripts child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasVarArraySubscripts() {
        return getVarArraySubscriptsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) VarArraySubscripts child.
     * @return The VarArraySubscripts child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcArraySubscripts getVarArraySubscripts() {
        return (SrcArraySubscripts) getVarArraySubscriptsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the VarArraySubscripts child. This is the <code>Opt</code> node containing the child VarArraySubscripts, not the actual child!
     * @return The optional node for child the VarArraySubscripts child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="VarArraySubscripts")
    public Opt<SrcArraySubscripts> getVarArraySubscriptsOpt() {
        return (Opt<SrcArraySubscripts>) getChild(1);
    }
    /**
     * Retrieves the optional node for child VarArraySubscripts. This is the <code>Opt</code> node containing the child VarArraySubscripts, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child VarArraySubscripts.
     * @apilevel low-level
     */
    public Opt<SrcArraySubscripts> getVarArraySubscriptsOptNoTransform() {
        return (Opt<SrcArraySubscripts>) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the SrcModification child. This is the <code>Opt</code>
     * node containing the child SrcModification, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcModification child.
     * @apilevel low-level
     */
    public void setSrcModificationOpt(Opt<SrcModification> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) SrcModification child.
     * @param node The new node to be used as the SrcModification child.
     * @apilevel high-level
     */
    public void setSrcModification(SrcModification node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional SrcModification child exists.
     * @return {@code true} if the optional SrcModification child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcModification() {
        return getSrcModificationOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcModification child.
     * @return The SrcModification child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcModification getSrcModification() {
        return (SrcModification) getSrcModificationOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcModification child. This is the <code>Opt</code> node containing the child SrcModification, not the actual child!
     * @return The optional node for child the SrcModification child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcModification")
    public Opt<SrcModification> getSrcModificationOpt() {
        return (Opt<SrcModification>) getChild(2);
    }
    /**
     * Retrieves the optional node for child SrcModification. This is the <code>Opt</code> node containing the child SrcModification, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcModification.
     * @apilevel low-level
     */
    public Opt<SrcModification> getSrcModificationOptNoTransform() {
        return (Opt<SrcModification>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the SrcConditionalAttribute child. This is the <code>Opt</code>
     * node containing the child SrcConditionalAttribute, not the actual child!
     * @param opt The new node to be used as the optional node for the SrcConditionalAttribute child.
     * @apilevel low-level
     */
    public void setSrcConditionalAttributeOpt(Opt<SrcConditionalAttribute> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) SrcConditionalAttribute child.
     * @param node The new node to be used as the SrcConditionalAttribute child.
     * @apilevel high-level
     */
    public void setSrcConditionalAttribute(SrcConditionalAttribute node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional SrcConditionalAttribute child exists.
     * @return {@code true} if the optional SrcConditionalAttribute child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSrcConditionalAttribute() {
        return getSrcConditionalAttributeOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SrcConditionalAttribute child.
     * @return The SrcConditionalAttribute child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public SrcConditionalAttribute getSrcConditionalAttribute() {
        return (SrcConditionalAttribute) getSrcConditionalAttributeOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SrcConditionalAttribute child. This is the <code>Opt</code> node containing the child SrcConditionalAttribute, not the actual child!
     * @return The optional node for child the SrcConditionalAttribute child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SrcConditionalAttribute")
    public Opt<SrcConditionalAttribute> getSrcConditionalAttributeOpt() {
        return (Opt<SrcConditionalAttribute>) getChild(3);
    }
    /**
     * Retrieves the optional node for child SrcConditionalAttribute. This is the <code>Opt</code> node containing the child SrcConditionalAttribute, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SrcConditionalAttribute.
     * @apilevel low-level
     */
    public Opt<SrcConditionalAttribute> getSrcConditionalAttributeOptNoTransform() {
        return (Opt<SrcConditionalAttribute>) getChildNoTransform(3);
    }
    /**
     * Replaces the SrcComment child.
     * @param node The new node to replace the SrcComment child.
     * @apilevel high-level
     */
    public void setSrcComment(SrcComment node) {
        setChild(node, 4);
    }
    /**
     * Retrieves the SrcComment child.
     * @return The current node used as the SrcComment child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="SrcComment")
    public SrcComment getSrcComment() {
        return (SrcComment) getChild(4);
    }
    /**
     * Retrieves the SrcComment child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcComment child.
     * @apilevel low-level
     */
    public SrcComment getSrcCommentNoTransform() {
        return (SrcComment) getChildNoTransform(4);
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2007
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2007")
    public String toString() {
        String toString_value = prettyPrint("");
        return toString_value;
    }
    /**
     * @attribute syn
     * @aspect InstModifications
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstModifications", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:325")
    public SrcComponentDecl componentRedeclareDecl() {
        SrcComponentDecl componentRedeclareDecl_value = this;
        return componentRedeclareDecl_value;
    }
    /**
     * @attribute syn
     * @aspect Environments
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:483
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Environments", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:483")
    public boolean hasConstrainingModification() {
        boolean hasConstrainingModification_value = myComponentClause().hasConstrainingModification();
        return hasConstrainingModification_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:72
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:72")
    public boolean isUnknown() {
        boolean isUnknown_value = false;
        return isUnknown_value;
    }
    /**
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:39
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:39")
    public SrcClassDecl findClassDecl() {
        SrcClassDecl findClassDecl_value = myComponentClause().findClassDecl();
        return findClassDecl_value;
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
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:233")
    public SrcStringComment myStringComment() {
        SrcStringComment myStringComment_value = selectStringComment(myComponentClause().getSrcComment(), getSrcComment());
        return myStringComment_value;
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
        {
                SrcComment comment = myComponentClause().getSrcComment();
                if (comment.hasSrcAnnotation()) {
                    return new CombinedAnnotationNode(comment.annotation(instContext), getSrcComment().annotation(instContext));
                }
                return getSrcComment().annotation(instContext);
            }
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:412
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:412")
    public AnnotationNode modificationAnnotation() {
        AnnotationNode modificationAnnotation_value = annotationOfChild(getSrcModificationOpt(),      AnnotationNode.DEFAULT_EVALUATOR);
        return modificationAnnotation_value;
    }
    /*******************
     * Component Decls  
     * ****************
     * @attribute syn
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:383
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SrcAnnotations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:383")
    public SrcAnnotationProvider srcAnnotationProvider() {
        {
                SrcComment ccComment = myComponentClause().getSrcComment();
                if (ccComment.hasSrcAnnotation()) {
                    return SrcAnnotationNode.createProviderFor(getSrcComment(), ccComment);
                }
                return SrcAnnotationNode.createProviderFor(getSrcComment());
            }
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:340
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:340")
    public boolean hasRedeclare() {
        boolean hasRedeclare_value = myComponentClause().getRedeclare();
        return hasRedeclare_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:342
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:342")
    public boolean hasFinal() {
        boolean hasFinal_value = myComponentClause().getFinal();
        return hasFinal_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:344")
    public boolean hasInner() {
        boolean hasInner_value = myComponentClause().getInner();
        return hasInner_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:346
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:346")
    public boolean hasOuter() {
        boolean hasOuter_value = myComponentClause().getOuter();
        return hasOuter_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:348
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:348")
    public boolean hasReplaceable() {
        boolean hasReplaceable_value = myComponentClause().getReplaceable();
        return hasReplaceable_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:350
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:350")
    public boolean hasSrcTypePrefixFlow() {
        boolean hasSrcTypePrefixFlow_value = myComponentClause().hasSrcTypePrefixFlow();
        return hasSrcTypePrefixFlow_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:351
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:351")
    public SrcTypePrefixFlow getSrcTypePrefixFlow() {
        SrcTypePrefixFlow getSrcTypePrefixFlow_value = myComponentClause().getSrcTypePrefixFlow();
        return getSrcTypePrefixFlow_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:353
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:353")
    public boolean hasSrcTypePrefixVariability() {
        boolean hasSrcTypePrefixVariability_value = myComponentClause().hasSrcTypePrefixVariability();
        return hasSrcTypePrefixVariability_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:355
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:355")
    public SrcTypePrefixVariability getSrcTypePrefixVariability() {
        SrcTypePrefixVariability getSrcTypePrefixVariability_value = myComponentClause().getSrcTypePrefixVariability();
        return getSrcTypePrefixVariability_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:358
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:358")
    public boolean hasSrcTypePrefixInputOutput() {
        boolean hasSrcTypePrefixInputOutput_value = myComponentClause().hasSrcTypePrefixInputOutput();
        return hasSrcTypePrefixInputOutput_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:360
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:360")
    public SrcTypePrefixInputOutput getSrcTypePrefixInputOutput() {
        SrcTypePrefixInputOutput getSrcTypePrefixInputOutput_value = myComponentClause().getSrcTypePrefixInputOutput();
        return getSrcTypePrefixInputOutput_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:363")
    public SrcAccess getClassName() {
        SrcAccess getClassName_value = myComponentClause().getClassName();
        return getClassName_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:365
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:365")
    public boolean hasTypeArraySubscripts() {
        boolean hasTypeArraySubscripts_value = myComponentClause().hasTypeArraySubscripts();
        return hasTypeArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:367")
    public SrcArraySubscripts getTypeArraySubscripts() {
        SrcArraySubscripts getTypeArraySubscripts_value = myComponentClause().getTypeArraySubscripts();
        return getTypeArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:370
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:370")
    public boolean hasSrcConstrainingClause() {
        boolean hasSrcConstrainingClause_value = myComponentClause().hasSrcConstrainingClause();
        return hasSrcConstrainingClause_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:372
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:372")
    public SrcConstrainingClause getSrcConstrainingClause() {
        SrcConstrainingClause getSrcConstrainingClause_value = myComponentClause().getSrcConstrainingClause();
        return getSrcConstrainingClause_value;
    }
    /**
     * @attribute syn
     * @aspect ComponentClauseFields
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:375
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentClauseFields", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:375")
    public boolean hasSrcArraySubscripts() {
        boolean hasSrcArraySubscripts_value = hasVarArraySubscripts() || hasTypeArraySubscripts();
        return hasSrcArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:758
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:758")
    public String name() {
        String name_value = getNameNoTransform().getID();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1217
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1217")
    public boolean isProtected() {
        boolean isProtected_value = !isPublic();
        return isProtected_value;
    }
    /**
     * Check if a SrcComponentDecl is declared flow.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1251
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1251")
    public boolean isFlow() {
        boolean isFlow_value = hasSrcTypePrefixFlow() && getSrcTypePrefixFlow().isFlow();
        return isFlow_value;
    }
    /**
     * Check if a SrcComponentDecl is declared stream.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1258")
    public boolean isStream() {
        boolean isStream_value = hasSrcTypePrefixFlow() && getSrcTypePrefixFlow().isStream();
        return isStream_value;
    }
    /**
     * Check if a SrcComponentDecl is declared flow or stream.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1265
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1265")
    public boolean hasFlowOrStream() {
        boolean hasFlowOrStream_value = hasSrcTypePrefixFlow();
        return hasFlowOrStream_value;
    }
    /**
     * Check if a SrcComponentDecl is declared inner.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1270
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1270")
    public boolean isInner() {
        boolean isInner_value = hasInner();
        return isInner_value;
    }
    /**
     * Check if a SrcComponentDecl is declared outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1275
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1275")
    public boolean isOuter() {
        boolean isOuter_value = hasOuter();
        return isOuter_value;
    }
    /**
     * Check if a SrcComponentDecl is declared inner or outer.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1280
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1280")
    public boolean hasInnerOrOuter() {
        boolean hasInnerOrOuter_value = hasInner() || hasOuter();
        return hasInnerOrOuter_value;
    }
    /**
     * Check if this component is declared parameter.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1304
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1304")
    public boolean isParameter() {
        boolean isParameter_value = hasSrcTypePrefixVariability() && getSrcTypePrefixVariability().parameterVariability();
        return isParameter_value;
    }
    /**
     * Check if this component is declared constant.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1309
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1309")
    public boolean isConstant() {
        boolean isConstant_value = hasSrcTypePrefixVariability() && getSrcTypePrefixVariability().constantVariability();
        return isConstant_value;
    }
    /**
     * Check if this component is declared discrete.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1314")
    public boolean isDiscrete() {
        boolean isDiscrete_value = hasSrcTypePrefixVariability() && getSrcTypePrefixVariability().discreteVariability();
        return isDiscrete_value;
    }
    /**
     * Check if this component is declared input.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1349
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1349")
    public boolean isInput() {
        boolean isInput_value = hasSrcTypePrefixInputOutput() && getSrcTypePrefixInputOutput().isInput();
        return isInput_value;
    }
    /**
     * Check if this component is declared output.
     * @attribute syn
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1379
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1379")
    public boolean isOutput() {
        boolean isOutput_value = hasSrcTypePrefixInputOutput() && getSrcTypePrefixInputOutput().isOutput();
        return isOutput_value;
    }
    /**
     * @attribute syn
     * @aspect ShortClassUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1667
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ShortClassUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1667")
    public boolean isEnumLiteral() {
        boolean isEnumLiteral_value = false;
        return isEnumLiteral_value;
    }
    /**
     * Any extra info to add to the memory use output.
     * @attribute syn
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:669
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="MemoryUse", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:669")
    public String extraMemoryUseInfo() {
        String extraMemoryUseInfo_value = " \"" + name() + "\"";
        return extraMemoryUseInfo_value;
    }
    /**
     * @attribute inh
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:212
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:212")
    public SrcComponentClause myComponentClause() {
        SrcComponentClause myComponentClause_value = getParent().Define_myComponentClause(this, null);
        return myComponentClause_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:784
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:784")
    public String classNamePrefix() {
        String classNamePrefix_value = getParent().Define_classNamePrefix(this, null);
        return classNamePrefix_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:922
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:922")
    public Set<SrcClassDecl> enclosingClassDecls() {
        Set<SrcClassDecl> enclosingClassDecls_value = getParent().Define_enclosingClassDecls(this, null);
        return enclosingClassDecls_value;
    }
    /**
     * @attribute inh
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1203
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1203")
    public boolean isPublic() {
        boolean isPublic_value = getParent().Define_isPublic(this, null);
        return isPublic_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getSrcModificationOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:287
            return simpleLookupFromModification(name);
        }
        else {
            return getParent().Define_simpleLookupHelper(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupHelper
     */
    protected boolean canDefine_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupHelper(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:292
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromValue
     */
    protected boolean canDefine_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
