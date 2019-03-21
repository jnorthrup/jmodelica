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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:104
 * @astdecl SrcLibNode : SrcClassDecl ::= <FileName:String> <Structured:boolean> <Version:String> <Reason:SrcLibNode.LoadReason> SrcStoredDefinition;
 * @production SrcLibNode : {@link SrcClassDecl} ::= <span class="component">&lt;FileName:String&gt;</span> <span class="component">&lt;Structured:boolean&gt;</span> <span class="component">&lt;Version:String&gt;</span> <span class="component">&lt;Reason:SrcLibNode.LoadReason&gt;</span> <span class="component">{@link SrcStoredDefinition}</span>;

 */
public class SrcLibNode extends SrcClassDecl implements Cloneable {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:537
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		str.formatln("%s%structured library '%s' at '%s'", indent, 
				(getStructured() ? "S" : "Uns"), name(), getFileName());
	}
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1427
     */
    public InstLibNode newInstClassDecl() {
        return new InstLibNode(this);
    }
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2487
     */
    private static final byte UPDATED_NAME_CASE_NOT_DONE  = 0;
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2488
     */
    private static final byte UPDATED_NAME_CASE_CHANGE    = 1;
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2489
     */
    private static final byte UPDATED_NAME_CASE_NO_CHANGE = 2;
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2490
     */
    private byte updatedNameCase = UPDATED_NAME_CASE_NOT_DONE;
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:37
     */
    
        public enum LoadReason { COMMANDLINE, MODELICAPATH }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:37
     */
    ;
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:57
     */
    public static final String PACKAGE_FILE = "package.mo";
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:58
     */
    public static final String PACKAGE_ORDER_FILE = "package.order";
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:145
     */
    private SrcClassDecl extractClassDecl(SrcStoredDefinition entity, String name) {
        if (entity == null) {
            return null;
        } else {
            SrcClassDecl match = null;
            SrcClassDecl wrongCase = null;
            for (SrcClassDecl cd : entity.getSrcClassDecls()) {
                if (name.equals(cd.name())) {
                    if (match == null) {
                        match = cd;
                    }
                } else if (name.equalsIgnoreCase(cd.name())) {
                    if (wrongCase == null) {
                        wrongCase = cd;
                    }
                }
            }
            return (match == null) ? wrongCase : match;
        }
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:166
     */
    private boolean shouldProduceProblem(SrcStoredDefinition entity, String name) {
        return entity == null || entity.getNumSrcClassDecl() != 1 || 
                !entity.getSrcClassDecl(0).name().equals(name);
    }
    /**
     * Check if a path points to a structured library.
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:253
     */
    public static boolean isStructuredLib(File f) {
        return f.isDirectory() && new File(f, PACKAGE_FILE).isFile();
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:257
     */
    public static boolean isUnstructuredLib(File f) {
        String name = f.getName();
        return f.isFile() && SrcLibNode.isUnstructuredLibName(name);
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:262
     */
    private static boolean isUnstructuredLibName(String name) {
        return name.endsWith(".mo") && !name.equals(PACKAGE_FILE);
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:266
     */
    private File myPackageFile() {
        return new File(getFileName(), myPackageFileName());
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:270
     */
    private String myPackageFileName() {
        return SrcLibNode.PACKAGE_FILE;
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:274
     */
    public static String packageFile(File f) {
        File l = new File(f,SrcLibNode.PACKAGE_FILE);
        if (!l.exists()) {
             return null;
        }
        return l.getPath();
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:282
     */
    static boolean isPackageFile(File f) {
        return f.getName().equals(SrcLibNode.PACKAGE_FILE);
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:297
     */
    private SrcStoredDefinition createErrorStoredDefinition() {
        return new SrcStoredDefinition(new Opt(), new List(createErrorClass()));
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:301
     */
    private SrcBadClassDecl createErrorClass() {
        return new SrcBadClassDecl(name());
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:305
     */
    public SrcLibNode(File file, String name, boolean structured, LoadReason reason) {
        this(new SrcIdDecl(name), file.getPath(), structured, "", reason);
    }
    /**
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:276
     */
    @Override
    public <T extends SrcClause> Iterable<T> clauses(Class<T> type) {
        return myClass().clauses(type);
    }
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:674
     */
    public String fileName() {
        return getStructured() ? myPackageFile().getPath() : getFileName();
    }
    /**
     * @declaredat ASTNode:1
     */
    public SrcLibNode() {
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
        name = {"Name", "FileName", "Structured", "Version", "Reason"},
        type = {"SrcIdDecl", "String", "boolean", "String", "SrcLibNode.LoadReason"},
        kind = {"Child", "Token", "Token", "Token", "Token"}
    )
    public SrcLibNode(SrcIdDecl p0, String p1, boolean p2, String p3, SrcLibNode.LoadReason p4) {
        setChild(p0, 0);
        setFileName(p1);
        setStructured(p2);
        setVersion(p3);
        setReason(p4);
    }
    /**
     * @declaredat ASTNode:25
     */
    public SrcLibNode(SrcIdDecl p0, beaver.Symbol p1, boolean p2, beaver.Symbol p3, SrcLibNode.LoadReason p4) {
        setChild(p0, 0);
        setFileName(p1);
        setStructured(p2);
        setVersion(p3);
        setReason(p4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:33
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:39
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getSrcStoredDefinition_reset();
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
    public SrcLibNode clone() throws CloneNotSupportedException {
        SrcLibNode node = (SrcLibNode) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:57
     */
    public SrcLibNode copy() {
        try {
            SrcLibNode node = (SrcLibNode) clone();
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
     * @declaredat ASTNode:76
     */
    @Deprecated
    public SrcLibNode fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:86
     */
    public SrcLibNode treeCopyNoTransform() {
        SrcLibNode tree = (SrcLibNode) copy();
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
     * @declaredat ASTNode:111
     */
    public SrcLibNode treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:116
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenString_FileName == ((SrcLibNode) node).tokenString_FileName) && (tokenboolean_Structured == ((SrcLibNode) node).tokenboolean_Structured) && (tokenString_Version == ((SrcLibNode) node).tokenString_Version) && (tokenSrcLibNode_LoadReason_Reason == ((SrcLibNode) node).tokenSrcLibNode_LoadReason_Reason);    
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
     * Replaces the lexeme FileName.
     * @param value The new value for the lexeme FileName.
     * @apilevel high-level
     */
    public void setFileName(String value) {
        tokenString_FileName = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_FileName;
    /**
     */
    public int FileNamestart;
    /**
     */
    public int FileNameend;
    /**
     * JastAdd-internal setter for lexeme FileName using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme FileName
     * @apilevel internal
     */
    public void setFileName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setFileName is only valid for String lexemes");
        tokenString_FileName = (String)symbol.value;
        FileNamestart = symbol.getStart();
        FileNameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme FileName.
     * @return The value for the lexeme FileName.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="FileName")
    public String getFileName() {
        return tokenString_FileName != null ? tokenString_FileName : "";
    }
    /**
     * Replaces the lexeme Structured.
     * @param value The new value for the lexeme Structured.
     * @apilevel high-level
     */
    public void setStructured(boolean value) {
        tokenboolean_Structured = value;
    }
    /** @apilevel internal 
     */
    protected boolean tokenboolean_Structured;
    /**
     * Retrieves the value for the lexeme Structured.
     * @return The value for the lexeme Structured.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Structured")
    public boolean getStructured() {
        return tokenboolean_Structured;
    }
    /**
     * Replaces the lexeme Version.
     * @param value The new value for the lexeme Version.
     * @apilevel high-level
     */
    public void setVersion(String value) {
        tokenString_Version = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Version;
    /**
     */
    public int Versionstart;
    /**
     */
    public int Versionend;
    /**
     * JastAdd-internal setter for lexeme Version using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Version
     * @apilevel internal
     */
    public void setVersion(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setVersion is only valid for String lexemes");
        tokenString_Version = (String)symbol.value;
        Versionstart = symbol.getStart();
        Versionend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Version.
     * @return The value for the lexeme Version.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Version")
    public String getVersion() {
        return tokenString_Version != null ? tokenString_Version : "";
    }
    /**
     * Replaces the lexeme Reason.
     * @param value The new value for the lexeme Reason.
     * @apilevel high-level
     */
    public void setReason(SrcLibNode.LoadReason value) {
        tokenSrcLibNode_LoadReason_Reason = value;
    }
    /** @apilevel internal 
     */
    protected SrcLibNode.LoadReason tokenSrcLibNode_LoadReason_Reason;
    /**
     * Retrieves the value for the lexeme Reason.
     * @return The value for the lexeme Reason.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Reason")
    public SrcLibNode.LoadReason getReason() {
        return tokenSrcLibNode_LoadReason_Reason;
    }
    /**
     * Retrieves the SrcStoredDefinition child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcStoredDefinition child.
     * @apilevel low-level
     */
    public SrcStoredDefinition getSrcStoredDefinitionNoTransform() {
        return (SrcStoredDefinition) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child SrcStoredDefinition.
     * @return The the child position of the optional child SrcStoredDefinition.
     * @apilevel low-level
     */
    protected int getSrcStoredDefinitionChildPosition() {
        return 1;
    }
    /**
     * Get loaded version of library class.
     * @attribute syn
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:211
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstLookupClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:211")
    public SrcClassDecl resolveLib() {
        SrcClassDecl resolveLib_value = myClass();
        return resolveLib_value;
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
        boolean isPartial_value = myClass().isPartial();
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
        boolean isEncapsulated_value = myClass().isEncapsulated();
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
        boolean isModel_value = myClass().isModel();
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
        boolean isBlock_value = myClass().isBlock();
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
        boolean isClass_value = myClass().isClass();
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
        boolean isPackage_value = myClass().isPackage();
        return isPackage_value;
    }
    /**
     * @attribute syn
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2492
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2492")
    public SrcClassDecl myClass() {
        {
                SrcClassDecl cl = getSrcStoredDefinition().getSrcClassDecl(0);
                if (updatedNameCase == UPDATED_NAME_CASE_NOT_DONE) {
                    if (!cl.name().equals(name()) && cl.name().equalsIgnoreCase(name())) {
                        setName(cl.getName().treeCopy());
                        updatedNameCase = UPDATED_NAME_CASE_CHANGE;
                    } else {
                        updatedNameCase = UPDATED_NAME_CASE_NO_CHANGE;
                    }
                }
                return cl;
            }
    }
    /**
     * @attribute syn
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2505
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceAST_API", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2505")
    public boolean nameCaseChanged() {
        boolean nameCaseChanged_value = updatedNameCase == UPDATED_NAME_CASE_CHANGE;
        return nameCaseChanged_value;
    }
    /**
     * Is this SrcLibNode loaded because the library was passed to the compiler as an argument?
     * @attribute syn
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:43")
    public boolean fromCommandLine() {
        boolean fromCommandLine_value = getReason() == LoadReason.COMMANDLINE;
        return fromCommandLine_value;
    }
    /**
     * Is this SrcLibNode loaded because the library was found on MODELICAPATH?
     * @attribute syn
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:48")
    public boolean fromModelicaPath() {
        boolean fromModelicaPath_value = getReason() == LoadReason.MODELICAPATH;
        return fromModelicaPath_value;
    }
    /**
     * @attribute syn
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:55")
    public SrcLibNode.LoadReason loadReason() {
        SrcLibNode.LoadReason loadReason_value = getReason();
        return loadReason_value;
    }
    /** @apilevel internal */
    private void getSrcStoredDefinition_reset() {
        getSrcStoredDefinition_computed = false;
        
        getSrcStoredDefinition_value = null;
    }
    /** @apilevel internal */
    protected boolean getSrcStoredDefinition_computed = false;

    /** @apilevel internal */
    protected SrcStoredDefinition getSrcStoredDefinition_value;

    /**
     * @attribute syn nta
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:60")
    public SrcStoredDefinition getSrcStoredDefinition() {
        ASTState state = state();
        if (getSrcStoredDefinition_computed) {
            return (SrcStoredDefinition) getChild(getSrcStoredDefinitionChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getSrcStoredDefinition_value = getSrcStoredDefinition_compute();
        setChild(getSrcStoredDefinition_value, getSrcStoredDefinitionChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getSrcStoredDefinition_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        SrcStoredDefinition node = (SrcStoredDefinition) this.getChild(getSrcStoredDefinitionChildPosition());
        return node;
    }
    /** @apilevel internal */
    private SrcStoredDefinition getSrcStoredDefinition_compute() {
            /* If structured
                    a. Read all files
                    b. Check for package.mo
                    c. Parse package.mo
                    d. Read all .mo files
                    e. Add SrcLibNodes to the SrcLibClassDecl
                    f. Return the SrcLibClassDecl
               If unstructured
                    a. Parse the .mo file
                    b. Return the resulting SrcFullClassDecl
            */
            
            String fileName = fileName();
            String dirName = null;
            File baseDir = null;
            String name = name();
            boolean isStructured = getStructured();
            // TODO: Error if more than one class in file
            if (isStructured) {
                dirName = getFileName();
                baseDir = new File(dirName);
            }
            try {
                log.info("Reading file: " + fileName);
                UtilInterface util = root().getUtilInterface();
                SourceRoot sr = util.getParserHandler().parseFile(util, fileName);
                SrcStoredDefinition entity = sr.getProgram().getUnstructuredEntity(0);
                SrcClassDecl cd = extractClassDecl(entity, name);
                if (shouldProduceProblem(entity, name)) {
                    LIBRARY_FILE_CONTENTS.invoke(this, entity);
                }
                if (cd == null) {
                    return createErrorStoredDefinition();
                }
                entity.setFileName(fileName);
                if (isStructured) {
                    SrcFullClassDecl fcd = (SrcFullClassDecl) cd;
                    LibraryList ll = new LibraryList();
                    ll.addLibraryDirectory(dirName, getReason());
    
                    SrcLibClassDecl lcd = new SrcLibClassDecl(fcd, ll.createLibNodeList());
                    lcd.readOrderFile(baseDir, util);
                    entity.setSrcClassDecl(lcd, 0);
                }
                return entity;
            } catch (ParserException e) {
                problem(e.getProblem());
                return createErrorStoredDefinition();
            } catch (Exception e) {
                String msg = "Error when parsing file: '" + fileName + "':\n" + 
                        "   " + e.getClass().getName() + "\n";
                if (e.getMessage() != null)
                    msg = msg + "   " + e.getMessage();
                error(msg);
                log.debug(e);
                return createErrorStoredDefinition();
            } 
        }
    /**
     * @attribute syn
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:286
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:286")
    public SrcClassDecl classDecl() {
        SrcClassDecl classDecl_value = (getSrcStoredDefinition().getNumSrcClassDecl() > 0) 
                    ? getSrcStoredDefinition().getSrcClassDecl(0) 
                    : createErrorClass();
        return classDecl_value;
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
        ResolvedAccess simpleLookupMemberScope_String_value = myClass().simpleLookupMemberScope(name);
        return simpleLookupMemberScope_String_value;
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
        {
                if (name().equalsIgnoreCase(str)) {
                    myClass();
                }
                return name().equals(str);
            }
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:30")
    public Iterable<SrcAbstractEquation> equations() {
        Iterable<SrcAbstractEquation> equations_value = myClass().equations();
        return equations_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:43")
    public Iterable<SrcExtendsClause> superClasses() {
        Iterable<SrcExtendsClause> superClasses_value = myClass().superClasses();
        return superClasses_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:60")
    public Iterable<SrcComponentClause> componentClauses() {
        Iterable<SrcComponentClause> componentClauses_value = myClass().componentClauses();
        return componentClauses_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:86")
    public Iterable<SrcModificationOrRedeclareElement> elementModifications() {
        Iterable<SrcModificationOrRedeclareElement> elementModifications_value = myClass().elementModifications();
        return elementModifications_value;
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:111")
    public Iterable<SrcClassDecl> classes() {
        Iterable<SrcClassDecl> classes_value = myClass().classes();
        return classes_value;
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
        AnnotationNode annotation_InstContext_value = myClass().annotation(instContext);
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
        SrcAnnotationProvider srcAnnotationProvider_value = resolveLib().srcAnnotationProvider();
        return srcAnnotationProvider_value;
    }
    /**
     * @attribute syn
     * @aspect ClassDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1556
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ClassDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1556")
    public boolean isLibNode() {
        boolean isLibNode_value = true;
        return isLibNode_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:50
     * @apilevel internal
     */
    public SrcLibNode.LoadReason Define_loadReason(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return getReason();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:50
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute loadReason
     */
    protected boolean canDefine_loadReason(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     * @apilevel internal
     */
    public String Define_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return fileName();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFileName
     */
    protected boolean canDefine_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
