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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:85
 * @astdecl InstExternal : BaseNode ::= <SrcExternalClause:SrcExternalClause> [FExternalLanguage] [InstExternalCall];
 * @production InstExternal : {@link BaseNode} ::= <span class="component">&lt;SrcExternalClause:SrcExternalClause&gt;</span> <span class="component">[{@link FExternalLanguage}]</span> <span class="component">[{@link InstExternalCall}]</span>;

 */
public class InstExternal extends BaseNode implements Cloneable, InstContext {
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1528
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.print("external ");
		p.print(getFExternalLanguage(), str, indent);
		str.print(" ");
		p.print(getInstExternalCall(), str, indent);
	}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:79
     */
    public void contentCheck(ErrorCheckType checkType) {
        if (!inFunction()) {
			error("External function declarations are only allowed in functions");
        }
        contentCheckDirectoryAnnotation(checkType, "IncludeDirectory");
        contentCheckDirectoryAnnotation(checkType, "LibraryDirectory");
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:87
     */
    public void contentCheckDirectoryAnnotation(ErrorCheckType checkType, String name) {
        AnnotationNode libDir = annotation(name);
        if (libDir.exists()) {
            if (libDir.isStringValue()) {
                try {
                    URIResolver.DEFAULT.resolveChecked(this, libDir.string());
                } catch (URIException e) {
                    ASTNode.EXTERNAL_DIRECTORY_ANNOTATION.invoke(this, name, e.getMessage());
                }
            } else {
                ASTNode.EXTERNAL_DIRECTORY_ANNOTATION_TYPE.invoke(this, name);
            }
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:766
     */
    public void flatten(Flattener f, List<FStatement> sl) {
        getFAlgorithm().getFStatement(0).flatten(f, sl);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:776
     */
    public FExternalStmt createStmt() {
        InstClassDecl func = surroundingInstClass();
        FExternalStmt stmt = new FExternalStmt();
        SrcClassDecl scd = myTopSrcClassDecl();
        stmt.setLibTopPackagePath(scd == null ? "" : scd.myLibRootPath().getAbsolutePath()); // scd is null for builtins
        stmt.setFExternalLanguage(hasFExternalLanguage() ? 
                (FExternalLanguage) getFExternalLanguage().fullCopy() : 
                new FCExternalLanguage());
        stmt.extractLibrary(this);
        if (hasInstExternalCall()) {
            InstExternalCall call = getInstExternalCall();
            if (call.hasReturnVar()) {
                stmt.setReturnVar(new InstAccessExp(call.getReturnVar().treeCopy()));
            }
            stmt.setName(call.getName());
            for (FExp arg : call.getArgs()) {
                stmt.addArg(arg.treeCopy());
            }
        } else {
            boolean hasReturn = func.myOutputs().size() == 1 && 
                    func.myOutputs().get(0).canBeExternalReturn(stmt.getFExternalLanguage());
            if (hasReturn) {
                stmt.setReturnVar(new InstAccessExp(new InstComponentAccess(func.myOutputs().get(0).name())));
            }
            stmt.setName(func.name());
            for (InstComponentDecl arg : func.allInstComponentDecls()) {
                if (!hasReturn || !arg.isOutput()) {
                    arg.addExternalArg(stmt);
                }
            }
        }
        return stmt;
    }
    /**
     * Dynamically places an FExp in the tree under this InstExternal.
     * 
     * @return  the final version of the dynamically placed node.
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:876
     */
    public FExp dynamicFExp(FExp exp) {
        getDynamicFExpOpt().setChild(exp, 0);
        return (FExp) getDynamicFExpOpt().getChild(0);
    }
    /**
     * @aspect InstanceToString
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2734
     */
    public String toString() {
    	return getSrcExternalClause().toString();
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:120
     */
    public CValue ceval(SrcExp exp) {
      return surroundingInstClass().ceval(exp);
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:123
     */
    public CValue ceval(SrcExp exp, VariableEvaluator evaluator) {
        return surroundingInstClass().ceval(exp, evaluator);
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:135
     */
    public InstLookupResult<InstClassDecl> lookupInstClass(SrcExp exp) {
        return surroundingInstClass().lookupInstClass(exp);
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:159
     */
    public InstLookupResult<InstComponentDecl> lookupInstComponent(SrcExp exp) {
        return surroundingInstClass().lookupInstComponent(exp);
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:202
     */
    public void addAnnotationToEvaluator(ArrayList<AnnotationNode> list, InstNode evaluator) {
        if (annotation().exists()) {
            list.add(annotation());
        }
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:295
     */
    public FExp annotationExp(SrcExp exp) {
        return new FNoExp();
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:68
     */
    public SrcAnnotationNode srcAnnotation(String ... path) {
        return getSrcExternalClause().srcAnnotation(new SrcAnnotationNode.InstEvaluator(this), path);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstExternal() {
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
        setChild(Opt.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"SrcExternalClause", "FExternalLanguage", "InstExternalCall"},
        type = {"SrcExternalClause", "Opt<FExternalLanguage>", "Opt<InstExternalCall>"},
        kind = {"Token", "Opt", "Opt"}
    )
    public InstExternal(SrcExternalClause p0, Opt<FExternalLanguage> p1, Opt<InstExternalCall> p2) {
        setSrcExternalClause(p0);
        setChild(p1, 0);
        setChild(p2, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:26
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:32
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:36
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getFAlgorithm_reset();
        getDynamicFExpOpt_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:46
     */
    public InstExternal clone() throws CloneNotSupportedException {
        InstExternal node = (InstExternal) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public InstExternal copy() {
        try {
            InstExternal node = (InstExternal) clone();
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
     * @declaredat ASTNode:70
     */
    @Deprecated
    public InstExternal fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:80
     */
    public InstExternal treeCopyNoTransform() {
        InstExternal tree = (InstExternal) copy();
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
     * @declaredat ASTNode:100
     */
    public InstExternal treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:105
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSrcExternalClause_SrcExternalClause == ((InstExternal) node).tokenSrcExternalClause_SrcExternalClause);    
    }
    /**
     * Replaces the lexeme SrcExternalClause.
     * @param value The new value for the lexeme SrcExternalClause.
     * @apilevel high-level
     */
    public void setSrcExternalClause(SrcExternalClause value) {
        tokenSrcExternalClause_SrcExternalClause = value;
    }
    /** @apilevel internal 
     */
    protected SrcExternalClause tokenSrcExternalClause_SrcExternalClause;
    /**
     * Retrieves the value for the lexeme SrcExternalClause.
     * @return The value for the lexeme SrcExternalClause.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="SrcExternalClause")
    public SrcExternalClause getSrcExternalClause() {
        return tokenSrcExternalClause_SrcExternalClause;
    }
    /**
     * Replaces the optional node for the FExternalLanguage child. This is the <code>Opt</code>
     * node containing the child FExternalLanguage, not the actual child!
     * @param opt The new node to be used as the optional node for the FExternalLanguage child.
     * @apilevel low-level
     */
    public void setFExternalLanguageOpt(Opt<FExternalLanguage> opt) {
        setChild(opt, 0);
    }
    /**
     * Replaces the (optional) FExternalLanguage child.
     * @param node The new node to be used as the FExternalLanguage child.
     * @apilevel high-level
     */
    public void setFExternalLanguage(FExternalLanguage node) {
        if (node != null) {
            setChild(new Opt(node), 0);
        } else {
            setChild(Opt.EMPTY, 0);
        }
    }
    /**
     * Check whether the optional FExternalLanguage child exists.
     * @return {@code true} if the optional FExternalLanguage child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFExternalLanguage() {
        return getFExternalLanguageOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FExternalLanguage child.
     * @return The FExternalLanguage child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExternalLanguage getFExternalLanguage() {
        return (FExternalLanguage) getFExternalLanguageOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FExternalLanguage child. This is the <code>Opt</code> node containing the child FExternalLanguage, not the actual child!
     * @return The optional node for child the FExternalLanguage child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FExternalLanguage")
    public Opt<FExternalLanguage> getFExternalLanguageOpt() {
        return (Opt<FExternalLanguage>) getChild(0);
    }
    /**
     * Retrieves the optional node for child FExternalLanguage. This is the <code>Opt</code> node containing the child FExternalLanguage, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FExternalLanguage.
     * @apilevel low-level
     */
    public Opt<FExternalLanguage> getFExternalLanguageOptNoTransform() {
        return (Opt<FExternalLanguage>) getChildNoTransform(0);
    }
    /**
     * Replaces the optional node for the InstExternalCall child. This is the <code>Opt</code>
     * node containing the child InstExternalCall, not the actual child!
     * @param opt The new node to be used as the optional node for the InstExternalCall child.
     * @apilevel low-level
     */
    public void setInstExternalCallOpt(Opt<InstExternalCall> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) InstExternalCall child.
     * @param node The new node to be used as the InstExternalCall child.
     * @apilevel high-level
     */
    public void setInstExternalCall(InstExternalCall node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional InstExternalCall child exists.
     * @return {@code true} if the optional InstExternalCall child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasInstExternalCall() {
        return getInstExternalCallOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) InstExternalCall child.
     * @return The InstExternalCall child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public InstExternalCall getInstExternalCall() {
        return (InstExternalCall) getInstExternalCallOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the InstExternalCall child. This is the <code>Opt</code> node containing the child InstExternalCall, not the actual child!
     * @return The optional node for child the InstExternalCall child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="InstExternalCall")
    public Opt<InstExternalCall> getInstExternalCallOpt() {
        return (Opt<InstExternalCall>) getChild(1);
    }
    /**
     * Retrieves the optional node for child InstExternalCall. This is the <code>Opt</code> node containing the child InstExternalCall, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child InstExternalCall.
     * @apilevel low-level
     */
    public Opt<InstExternalCall> getInstExternalCallOptNoTransform() {
        return (Opt<InstExternalCall>) getChildNoTransform(1);
    }
    /** @apilevel internal */
    private void getFAlgorithm_reset() {
        getFAlgorithm_computed = false;
        
        getFAlgorithm_value = null;
    }
    /** @apilevel internal */
    protected boolean getFAlgorithm_computed = false;

    /** @apilevel internal */
    protected FAlgorithm getFAlgorithm_value;

    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:770
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:770")
    public FAlgorithm getFAlgorithm() {
        ASTState state = state();
        if (getFAlgorithm_computed) {
            return getFAlgorithm_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getFAlgorithm_value = getFAlgorithm_compute();
        getFAlgorithm_value.setParent(this);
        getFAlgorithm_value.is$Final = true;
        if (true) {
        getFAlgorithm_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getFAlgorithm_value;
    }
    /** @apilevel internal */
    private FAlgorithm getFAlgorithm_compute() {
            FAlgorithm fab = new FAlgorithm(new List());
            fab.addFStatement(createStmt());
            return fab;
        }
    /** @apilevel internal */
    private void getDynamicFExpOpt_reset() {
        getDynamicFExpOpt_computed = false;
        
        getDynamicFExpOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getDynamicFExpOpt_computed = false;

    /** @apilevel internal */
    protected Opt getDynamicFExpOpt_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:852
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:852")
    public Opt getDynamicFExpOpt() {
        ASTState state = state();
        if (getDynamicFExpOpt_computed) {
            return getDynamicFExpOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getDynamicFExpOpt_value = new DynamicOpt();
        getDynamicFExpOpt_value.setParent(this);
        getDynamicFExpOpt_value.is$Final = true;
        if (true) {
        getDynamicFExpOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getDynamicFExpOpt_value;
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
        AnnotationNode annotation_InstContext_value = getSrcExternalClause().annotation(instContext);
        return annotation_InstContext_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations and need a 
     * non-default evaluator.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:37
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:37")
    public AnnotationNode annotation() {
        AnnotationNode annotation_value = annotation(annotationExpEvaluator());
        return annotation_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:102")
    public InstContext annotationExpEvaluator() {
        InstContext annotationExpEvaluator_value = parentExpEvaluator();
        return annotationExpEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:844
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:844")
    public String libraryName() {
        String libraryName_value = findLibraryName();
        return libraryName_value;
    }
    /**
     * @attribute inh
     * @aspect InstBindingType
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstBindingType", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:428")
    public InstClassDecl surroundingInstClass() {
        InstClassDecl surroundingInstClass_value = getParent().Define_surroundingInstClass(this, null);
        return surroundingInstClass_value;
    }
    /**
     * @attribute inh
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:106
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:106")
    public InstContext parentExpEvaluator() {
        InstContext parentExpEvaluator_value = getParent().Define_parentExpEvaluator(this, null);
        return parentExpEvaluator_value;
    }
    /**
     * @attribute inh
     * @aspect SrcUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:311
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SrcUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:311")
    public SrcClassDecl myTopSrcClassDecl() {
        SrcClassDecl myTopSrcClassDecl_value = getParent().Define_myTopSrcClassDecl(this, null);
        return myTopSrcClassDecl_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:839
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:839")
    public String packageName() {
        String packageName_value = getParent().Define_packageName(this, null);
        return packageName_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:851
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:851")
    public String findLibraryName() {
        String findLibraryName_value = getParent().Define_findLibraryName(this, null);
        return findLibraryName_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
