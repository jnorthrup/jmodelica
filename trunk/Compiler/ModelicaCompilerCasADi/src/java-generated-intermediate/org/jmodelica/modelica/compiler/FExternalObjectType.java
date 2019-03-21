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
 * Class representing the external object type.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:266
 * @astdecl FExternalObjectType : FCellType ::= <Name:String> Constructor:CommonAccess Destructor:CommonAccess;
 * @production FExternalObjectType : {@link FCellType} ::= <span class="component">&lt;Name:String&gt;</span> <span class="component">Constructor:{@link CommonAccess}</span> <span class="component">Destructor:{@link CommonAccess}</span>;

 */
public class FExternalObjectType extends FCellType implements Cloneable {
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1761
     */
    public FVariable createFVariable(VisibilityType vt, FAccess name, 
            TypePrefixVariability variability) {
        return new FExternalObjectVariable(vt, variability.combineDown(Variability.INITIALPARAMETER), name, getConstructor().fullCopy());
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1059
     */
    @Override
    public FType flatten(Flattener f, InstAssignable ia, boolean keepSizeExpressions) {
        FType res = new FExternalObjectType(getSize(), getName(), getConstructor().flatten(f), getDestructor().flatten(f));
        res.setSize(getSize().flatten(f, res, keepSizeExpressions));
        return res;
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:190
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        super.markUsedGlobals(type);
        getConstructor().myFCallable().markUsedGlobals(type);
        getDestructor ().myFCallable().markUsedGlobals(type);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:332
     */
    public void usedTypes(Map<String,FType> res) {
        if (res.containsKey(name())) {
            return;
        }
        res.put(name(), this);
        FExternalStmt stmt = myConstructorStmt();
        for (ExternalArgument arg : stmt.varsToSerialize()) {
            FType t = arg.type();
            boolean par = t.getParent() == null;
            if (par) {
                t.setParent(stmt);
            }
            t.usedTypes(res);
            if (par) {
                t.setParent(null);
            }
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:442
     */
    public void externalDependencies(Set<FExternalStmt> res) {
        myConstructorStmt().externalDependencies(res);
        myDestructorStmt().externalDependencies(res);
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:197
     */
    public void print(TypePrinter_C p) { p.print(this); }
    /**
     * @declaredat ASTNode:1
     */
    public FExternalObjectType() {
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
        name = {"Size", "Name", "Constructor", "Destructor"},
        type = {"Size", "String", "CommonAccess", "CommonAccess"},
        kind = {"Token", "Token", "Child", "Child"}
    )
    public FExternalObjectType(Size p0, String p1, CommonAccess p2, CommonAccess p3) {
        setSize(p0);
        setName(p1);
        setChild(p2, 0);
        setChild(p3, 1);
    }
    /**
     * @declaredat ASTNode:24
     */
    public FExternalObjectType(Size p0, beaver.Symbol p1, CommonAccess p2, CommonAccess p3) {
        setSize(p0);
        setName(p1);
        setChild(p2, 0);
        setChild(p3, 1);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:31
     */
    protected int numChildren() {
        return 2;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:37
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:41
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FExternalObjectType clone() throws CloneNotSupportedException {
        FExternalObjectType node = (FExternalObjectType) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public FExternalObjectType copy() {
        try {
            FExternalObjectType node = (FExternalObjectType) clone();
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
     * @declaredat ASTNode:73
     */
    @Deprecated
    public FExternalObjectType fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:83
     */
    public FExternalObjectType treeCopyNoTransform() {
        FExternalObjectType tree = (FExternalObjectType) copy();
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
     * @declaredat ASTNode:103
     */
    public FExternalObjectType treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:108
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSize_Size == ((FExternalObjectType) node).tokenSize_Size) && (tokenString_Name == ((FExternalObjectType) node).tokenString_Name);    
    }
    /**
     * Replaces the lexeme Size.
     * @param value The new value for the lexeme Size.
     * @apilevel high-level
     */
    public void setSize(Size value) {
        tokenSize_Size = value;
    }
    /**
     * Retrieves the value for the lexeme Size.
     * @return The value for the lexeme Size.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Size")
    public Size getSize() {
        return tokenSize_Size;
    }
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Name;
    /**
     */
    public int Namestart;
    /**
     */
    public int Nameend;
    /**
     * JastAdd-internal setter for lexeme Name using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Name
     * @apilevel internal
     */
    public void setName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setName is only valid for String lexemes");
        tokenString_Name = (String)symbol.value;
        Namestart = symbol.getStart();
        Nameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Name.
     * @return The value for the lexeme Name.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Name")
    public String getName() {
        return tokenString_Name != null ? tokenString_Name : "";
    }
    /**
     * Replaces the Constructor child.
     * @param node The new node to replace the Constructor child.
     * @apilevel high-level
     */
    public void setConstructor(CommonAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Constructor child.
     * @return The current node used as the Constructor child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Constructor")
    public CommonAccess getConstructor() {
        return (CommonAccess) getChild(0);
    }
    /**
     * Retrieves the Constructor child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Constructor child.
     * @apilevel low-level
     */
    public CommonAccess getConstructorNoTransform() {
        return (CommonAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Destructor child.
     * @param node The new node to replace the Destructor child.
     * @apilevel high-level
     */
    public void setDestructor(CommonAccess node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Destructor child.
     * @return The current node used as the Destructor child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Destructor")
    public CommonAccess getDestructor() {
        return (CommonAccess) getChild(1);
    }
    /**
     * Retrieves the Destructor child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Destructor child.
     * @apilevel low-level
     */
    public CommonAccess getDestructorNoTransform() {
        return (CommonAccess) getChildNoTransform(1);
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1083
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1083")
    public FClass.ZType genType() {
        FClass.ZType genType_value = FClass.ZType.EXTERNAL;
        return genType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalObjectBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:373
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalObjectBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:373")
    public FExternalStmt myConstructorStmt() {
        FExternalStmt myConstructorStmt_value = getConstructor().myFExternalStmt();
        return myConstructorStmt_value;
    }
    /**
     * @attribute syn
     * @aspect FlatExternalObjectBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExternalObjectBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:374")
    public FExternalStmt myDestructorStmt() {
        FExternalStmt myDestructorStmt_value = getDestructor().myFExternalStmt();
        return myDestructorStmt_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011")
    public String name() {
        String name_value = getName();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082")
    public boolean typeCompatible(CommonType type, boolean allowUnknown) {
        boolean typeCompatible_CommonType_boolean_value = typeMatches(type, true, allowUnknown);
        return typeCompatible_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100")
    public boolean typeMatches(CommonType type, boolean compatible, boolean allowUnknown) {
        {
                if (!dimensionCompatible(type, allowUnknown) || !type.isExternalObject())
                    return false;
                FExternalObjectType obj = (FExternalObjectType) type;
                if (getName().equals(obj.getName())) 
                    return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FTypeEquivalent
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeEquivalent", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188")
    public boolean equivalentTo(CommonType type, boolean allowUnknown) {
        boolean equivalentTo_CommonType_boolean_value = typeMatches(type, false, allowUnknown);
        return equivalentTo_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1242
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1242")
    public boolean isExternalObject() {
        boolean isExternalObject_value = true;
        return isExternalObject_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276")
    public boolean isType(FType type) {
        boolean isType_FType_value = type.isExternalObject();
        return isType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:362
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:362")
    public boolean compatibleConstructor(InstClassDecl icd) {
        boolean compatibleConstructor_InstClassDecl_value = getConstructor().name().equals(icd.qualifiedName() + ".constructor");
        return compatibleConstructor_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:364
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:364")
    public boolean compatibleDestructor(InstClassDecl icd) {
        boolean compatibleDestructor_InstClassDecl_value = getDestructor().name().equals(icd.qualifiedName() + ".destructor");
        return compatibleDestructor_InstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795")
    public boolean externalValid(boolean rec) {
        boolean externalValid_boolean_value = !rec || !isArray();
        return externalValid_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:513
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeFuncCallInOutArg", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:513")
    public String memcpyObject() {
        String memcpyObject_value = "jmi_extobj_t";
        return memcpyObject_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:46")
    public String nameScalar_C(CodePrinter p) {
        String nameScalar_C_CodePrinter_value = "jmi_extobj_t";
        return nameScalar_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:55")
    public String nameArray_C(CodePrinter p) {
        String nameArray_C_CodePrinter_value = "jmi_extobj_array_t";
        return nameArray_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:85
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:85")
    public String argTypeBase_C(CodePrinter p) {
        String argTypeBase_C_CodePrinter_value = "void*";
        return argTypeBase_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:96
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:96")
    public boolean isArgTypeBaseRef() {
        boolean isArgTypeBaseRef_value = true;
        return isArgTypeBaseRef_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:112
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:112")
    public String macroTypeDeclScalar() {
        String macroTypeDeclScalar_value = "EXO";
        return macroTypeDeclScalar_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
