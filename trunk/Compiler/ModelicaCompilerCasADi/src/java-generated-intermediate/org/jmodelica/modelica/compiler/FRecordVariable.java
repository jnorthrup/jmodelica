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
 * FVariable of a record type.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:201
 * @astdecl FRecordVariable : FVariable ::= Record:FRecordAccess Type:FType;
 * @production FRecordVariable : {@link FVariable} ::= <span class="component">Record:{@link FRecordAccess}</span> <span class="component">Type:{@link FType}</span>;

 */
public class FRecordVariable extends FVariable implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3343
     */
    private boolean circular = false;
    /**
     * Create a record variable with only the required children.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:596
     */
    public FRecordVariable(VisibilityType vt, 
			TypePrefixVariability variability, FAccess name, FRecordAccess record) {
		this(vt, variability, TypePrefixInputOutput.NONE, new List(), (String) null, new Opt(), new Opt(), name, record);
	}
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1317
     */
    public FRecordVariable createEmptyNode()  					{ return new FRecordVariable(); }
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:78
     */
    public Size lookupHierarchicalSize(FAccessFull name, int part, int last) {
        FExp res = findHierarchicalAttributeValue(name, last, FAttribute.SIZE);
        if (res != null) {
            for (int i = part; i < last - 1; i++) {
                FArraySubscripts fas = name.getFAccessPart(i).getFArraySubscripts();
                if (fas != null) {
                    res = res.splitArrayExp(fas.createIndex());
                }
            }
            return new MutableSize(res);
        }
        return super.lookupHierarchicalSize(name, part, last);
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:178
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        super.markUsedGlobals(type);
        myFRecordDecl().markUsedGlobals(type);
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1152
     */
    public FVariable createPreVariable() {
		throw new UnsupportedOperationException();
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:824
     */
    public void activateEquivalentRecordUseRewrite() {
		super.activateEquivalentRecordUseRewrite();
		rewriteEquivalentRecord = true;
		is$Final = false;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:837
     */
    private boolean rewriteEquivalentRecord    = false;
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:392
     */
    @Override
    public void doScalarize(Scalarizer.Variable s) {
        scalarRecordFVariables(s, new ScalarizingVariableInstance(s, this));
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:586
     */
    public void scalarRecordCellFVariables(Scalarizer.Variable s, ScalarizingVariableInstance bes) {
        for (FVariable comp : myFRecordDecl().getFVariables()) {
            comp.scalarRecordFVariables(s, bes.create(s, comp));
        }
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:532
     */
    ArrayList<String> createFullNestedName(ArrayList<String> parts) {
        ArrayList<String> outList = new ArrayList<String>(); 
        if (size().numElements() > 1) {
            for (Index ind : size().rangeFArraySubscripts().indices()) {
                outList.addAll(createFullNestedNameForAllMyVariables(appendStringToAllEntriesInList(parts, "." + name() + ind.toString())));
            }
        } else {
            outList.addAll(createFullNestedNameForAllMyVariables(appendStringToAllEntriesInList(parts, "." + name())));
       
        }
        
        return outList;
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:546
     */
    private ArrayList<String> createFullNestedNameForAllMyVariables(ArrayList<String> parts) {
        ArrayList<String> outList = new ArrayList<String>(); 
        for (FVariable fvar : myFRecordDecl().getFVariables()) {
            outList.addAll(fvar.createFullNestedName(parts));
        }
        return outList;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FRecordVariable() {
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
        children = new ASTNode[6];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "FAttribute", "DerivedType", "BindingExp", "FStringComment", "FAccess", "Record"},
        type = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "List<FAttribute>", "String", "Opt<FExp>", "Opt<FStringComment>", "FAccess", "FRecordAccess"},
        kind = {"Token", "Token", "Token", "List", "Token", "Opt", "Opt", "Child", "Child"}
    )
    public FRecordVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, String p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7, FRecordAccess p8) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
        setChild(p8, 4);
    }
    /**
     * @declaredat ASTNode:32
     */
    public FRecordVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, beaver.Symbol p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7, FRecordAccess p8) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
        setChild(p8, 4);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:44
     */
    protected int numChildren() {
        return 5;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:50
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myFDerivedType_reset();
        myFRecordDecl_reset();
        type_reset();
        getType_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:62
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:66
     */
    public FRecordVariable clone() throws CloneNotSupportedException {
        FRecordVariable node = (FRecordVariable) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:71
     */
    public FRecordVariable copy() {
        try {
            FRecordVariable node = (FRecordVariable) clone();
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
     * @declaredat ASTNode:90
     */
    @Deprecated
    public FRecordVariable fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:100
     */
    public FRecordVariable treeCopyNoTransform() {
        FRecordVariable tree = (FRecordVariable) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 5:
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
     * @declaredat ASTNode:125
     */
    public FRecordVariable treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:130
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenVisibilityType_VisibilityType == ((FRecordVariable) node).tokenVisibilityType_VisibilityType) && (tokenTypePrefixVariability_TypePrefixVariability == ((FRecordVariable) node).tokenTypePrefixVariability_TypePrefixVariability) && (tokenTypePrefixInputOutput_TypePrefixInputOutput == ((FRecordVariable) node).tokenTypePrefixInputOutput_TypePrefixInputOutput) && (tokenString_DerivedType == ((FRecordVariable) node).tokenString_DerivedType);    
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
     * Replaces the Record child.
     * @param node The new node to replace the Record child.
     * @apilevel high-level
     */
    public void setRecord(FRecordAccess node) {
        setChild(node, 4);
    }
    /**
     * Retrieves the Record child.
     * @return The current node used as the Record child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Record")
    public FRecordAccess getRecord() {
        return (FRecordAccess) getChild(4);
    }
    /**
     * Retrieves the Record child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Record child.
     * @apilevel low-level
     */
    public FRecordAccess getRecordNoTransform() {
        return (FRecordAccess) getChildNoTransform(4);
    }
    /**
     * Retrieves the Type child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Type child.
     * @apilevel low-level
     */
    public FType getTypeNoTransform() {
        return (FType) getChildNoTransform(5);
    }
    /**
     * Retrieves the child position of the optional child Type.
     * @return The the child position of the optional child Type.
     * @apilevel low-level
     */
    protected int getTypeChildPosition() {
        return 5;
    }
    /**
     * Constant eval for variables without any binding expression, or binding equation.
     * Uses the start value for non-records.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3325")
    public CValue defaultCValue(VariableEvaluator evaluator, boolean inParameterRecord) {
        {
        	  if (isArray()) {
        		  CValueArray res = new CValueArray(size());
        		  for (Index i : indices())
        			  res.setCell(i, defaultCValueCell(evaluator, i, inParameterRecord));
        		  return res;
        	  } else {
        		  return defaultCValueCell(evaluator, Index.NULL, inParameterRecord);
        	  }
          }
    }
    /**
     * Constant eval for variables without any binding expression, or binding equation.
     * Uses the start value for non-records.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3341
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3341")
    public CValue defaultCValueCell(VariableEvaluator evaluator, Index i, boolean inParameterRecord) {
        {
                if (circular) {
                    throw new ConstantEvaluationException(null, "Circular evaluation in record component");
                }
                circular = true;
                try {
                    CValueRecord res = new CValueRecord((FRecordType) type().scalarType());
                    FRecordDecl rec = myFRecordDecl();
                    for (int j = 0, n = rec.getNumFVariable(); j < n; j++) {
                        FVariable fv = rec.getFVariable(j);
                        if (inParameterRecord || fv.isParameter() || fv.isRecord())
                            res.setMember(j, fv.ceval(evaluator, inParameterRecord));
                        else
                            res.setMember(j, CValue.UNKNOWN);
                    }
                    for (FAttribute a : getFAttributes())
                        a.applyToCValue(evaluator, res, i);
                    return res;
                } finally {
                    circular = false;
                }
            }
    }
    /** @apilevel internal */
    private void myFDerivedType_reset() {
        myFDerivedType_computed = false;
        
        myFDerivedType_value = null;
    }
    /** @apilevel internal */
    protected boolean myFDerivedType_computed = false;

    /** @apilevel internal */
    protected FDerivedType myFDerivedType_value;

    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:32
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:32")
    public FDerivedType myFDerivedType() {
        ASTState state = state();
        if (myFDerivedType_computed) {
            return myFDerivedType_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFDerivedType_value = null;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFDerivedType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFDerivedType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:71
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:71")
    public FExp findHierarchicalAttributeValue(FAccessFull name, int n, String attrName) {
        {
                FAttribute attr = findHierarchicalAttribute(name, n);
                if (attr != null) {
                    attr = attr.findAttribute(attrName);
                    if (attr != null) {
                        return attr.getValue();
                    }
                }
                return null;
            }
    }
    /** @apilevel internal */
    private void myFRecordDecl_reset() {
        myFRecordDecl_computed = false;
        
        myFRecordDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFRecordDecl_computed = false;

    /** @apilevel internal */
    protected FRecordDecl myFRecordDecl_value;

    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290")
    public FRecordDecl myFRecordDecl() {
        ASTState state = state();
        if (myFRecordDecl_computed) {
            return myFRecordDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFRecordDecl_value = lookupFRec(getRecord().name());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFRecordDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFRecordDecl_value;
    }
    /** @apilevel internal */
    private void type_reset() {
        type_computed = false;
        
        type_value = null;
    }
    /** @apilevel internal */
    protected boolean type_computed = false;

    /** @apilevel internal */
    protected FType type_value;

    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:174
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:174")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = getType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private void getType_reset() {
        getType_computed = false;
        
        getType_value = null;
    }
    /** @apilevel internal */
    protected boolean getType_computed = false;

    /** @apilevel internal */
    protected FType getType_value;

    /**
     * @attribute syn nta
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:195")
    public FType getType() {
        ASTState state = state();
        if (getType_computed) {
            return (FType) getChild(getTypeChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getType_value = myFRecordDecl().type().sizedType(size());
        setChild(getType_value, getTypeChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FType node = (FType) this.getChild(getTypeChildPosition());
        return node;
    }
    /**
     * @attribute inh
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:305
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:305")
    public FRecordDecl lookupFRec(String name) {
        FRecordDecl lookupFRec_String_value = getParent().Define_lookupFRec(this, null, name);
        return lookupFRec_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387
     * @apilevel internal
     */
    public TypePrefixVariability Define_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAttributeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3391
            int i = _callerNode.getIndexOfChild(_childNode);
            return variability().component(getFAttribute(i).name());
        }
        else {
            return super.Define_bindingExpVariability(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute bindingExpVariability
     */
    protected boolean canDefine_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:847
        if (rewriteEquivalentRecord) {
            return rewriteRule0();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:847
     * @apilevel internal
     */
    private FRecordVariable rewriteRule0() {
{
			rewriteEquivalentRecord = false;
			setRecord(myFClass().createEquivalentRecordAccess(getRecord()));
			flushAll();
			return this;
		}    }
}
