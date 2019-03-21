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
 * Enumeration literal expression.
 * 
 * All accesses to enumeration literals should be replaced by FEnumLitExps in flat tree.
 * Note that Type may be unset in the flat tree - use type().
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:954
 * @astdecl FEnumLitExp : FLitExp ::= <Enum:String> <Value:String> [Type:FEnumType];
 * @production FEnumLitExp : {@link FLitExp} ::= <span class="component">&lt;Enum:String&gt;</span> <span class="component">&lt;Value:String&gt;</span> <span class="component">[Type:{@link FEnumType}]</span>;

 */
public class FEnumLitExp extends FLitExp implements Cloneable {
    /**
     * Constructs a enumeration literal expression from a type and an ordinal.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:206
     */
    public FEnumLitExp(FEnumType type, int val) {
		this(type.getName(), type.getFEnumLiteralType(val - 1).getName(), new Opt(type.unboundCopy()));
	}
    /**
     * Constructs a enumeration literal expression from a type and a literal name.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:213
     */
    public FEnumLitExp(FEnumType type, String val) {
		this(type.getName(), val, new Opt(type.unboundCopy()));
	}
    /**
     * Constructs a enumeration literal expression from an enum name and a value name.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:220
     */
    public FEnumLitExp(String name, String val) {
		this(name, val, new Opt());
	}
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:946
     */
    public FEnumLitExp createEmptyNode()         { return new FEnumLitExp();         }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2544
     */
    public FExp flatten(Flattener f) { return new FEnumLitExp(getEnum(), getValue(), new Opt<FEnumType>()); }
    /**
     * @aspect DebugHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1193
     */
    public String toString()         { return getEnum() + "." + getValue(); }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1740
     */
    public FExp scalarizeExp(Scalarizer s) { 
	    return inArraySubscripts() ? new FIntegerLitExp(ceval().intValue()) : super.scalarizeExp(s);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:204
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		open_XML(str, indent);
		p.print(new FAccessFull(getEnum(), getValue()), str, p.indent(indent));
		close_XML(str, indent);
	}
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:121
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        boolean wrap = inIfCondition();
        if (wrap) {
            str.print(FLitExp.macro_C);
            str.print("(");
        }
        str.print(ceval().intValue());
        if (wrap) {
            str.print(")");
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public FEnumLitExp() {
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
        children = new ASTNode[1];
        setChild(Opt.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Enum", "Value", "Type"},
        type = {"String", "String", "Opt<FEnumType>"},
        kind = {"Token", "Token", "Opt"}
    )
    public FEnumLitExp(String p0, String p1, Opt<FEnumType> p2) {
        setEnum(p0);
        setValue(p1);
        setChild(p2, 0);
    }
    /**
     * @declaredat ASTNode:24
     */
    public FEnumLitExp(beaver.Symbol p0, beaver.Symbol p1, Opt<FEnumType> p2) {
        setEnum(p0);
        setValue(p1);
        setChild(p2, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:30
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:36
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myFEnumDecl_reset();
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
    public FEnumLitExp clone() throws CloneNotSupportedException {
        FEnumLitExp node = (FEnumLitExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public FEnumLitExp copy() {
        try {
            FEnumLitExp node = (FEnumLitExp) clone();
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
    public FEnumLitExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:83
     */
    public FEnumLitExp treeCopyNoTransform() {
        FEnumLitExp tree = (FEnumLitExp) copy();
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
    public FEnumLitExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:108
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenString_Enum == ((FEnumLitExp) node).tokenString_Enum) && (tokenString_Value == ((FEnumLitExp) node).tokenString_Value);    
    }
    /**
     * Replaces the lexeme Enum.
     * @param value The new value for the lexeme Enum.
     * @apilevel high-level
     */
    public void setEnum(String value) {
        tokenString_Enum = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Enum;
    /**
     */
    public int Enumstart;
    /**
     */
    public int Enumend;
    /**
     * JastAdd-internal setter for lexeme Enum using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Enum
     * @apilevel internal
     */
    public void setEnum(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setEnum is only valid for String lexemes");
        tokenString_Enum = (String)symbol.value;
        Enumstart = symbol.getStart();
        Enumend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Enum.
     * @return The value for the lexeme Enum.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Enum")
    public String getEnum() {
        return tokenString_Enum != null ? tokenString_Enum : "";
    }
    /**
     * Replaces the lexeme Value.
     * @param value The new value for the lexeme Value.
     * @apilevel high-level
     */
    public void setValue(String value) {
        tokenString_Value = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Value;
    /**
     */
    public int Valuestart;
    /**
     */
    public int Valueend;
    /**
     * JastAdd-internal setter for lexeme Value using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Value
     * @apilevel internal
     */
    public void setValue(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setValue is only valid for String lexemes");
        tokenString_Value = (String)symbol.value;
        Valuestart = symbol.getStart();
        Valueend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Value.
     * @return The value for the lexeme Value.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Value")
    public String getValue() {
        return tokenString_Value != null ? tokenString_Value : "";
    }
    /**
     * Replaces the optional node for the Type child. This is the <code>Opt</code>
     * node containing the child Type, not the actual child!
     * @param opt The new node to be used as the optional node for the Type child.
     * @apilevel low-level
     */
    public void setTypeOpt(Opt<FEnumType> opt) {
        setChild(opt, 0);
    }
    /**
     * Replaces the (optional) Type child.
     * @param node The new node to be used as the Type child.
     * @apilevel high-level
     */
    public void setType(FEnumType node) {
        if (node != null) {
            setChild(new Opt(node), 0);
        } else {
            setChild(Opt.EMPTY, 0);
        }
    }
    /**
     * Check whether the optional Type child exists.
     * @return {@code true} if the optional Type child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasType() {
        return getTypeOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Type child.
     * @return The Type child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FEnumType getType() {
        return (FEnumType) getTypeOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Type child. This is the <code>Opt</code> node containing the child Type, not the actual child!
     * @return The optional node for child the Type child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Type")
    public Opt<FEnumType> getTypeOpt() {
        return (Opt<FEnumType>) getChild(0);
    }
    /**
     * Retrieves the optional node for child Type. This is the <code>Opt</code> node containing the child Type, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Type.
     * @apilevel low-level
     */
    public Opt<FEnumType> getTypeOptNoTransform() {
        return (Opt<FEnumType>) getChildNoTransform(0);
    }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public CValue cevalCalc(VariableEvaluator evaluator) {
        CValue cevalCalc_VariableEvaluator_value = new CValueEnum(type(), getValue());
        return cevalCalc_VariableEvaluator_value;
    }
    /** @apilevel internal */
    private void myFEnumDecl_reset() {
        myFEnumDecl_computed = false;
        
        myFEnumDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFEnumDecl_computed = false;

    /** @apilevel internal */
    protected FEnumDecl myFEnumDecl_value;

    /**
     * @attribute syn
     * @aspect FlatEnumBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:330")
    public FEnumDecl myFEnumDecl() {
        ASTState state = state();
        if (myFEnumDecl_computed) {
            return myFEnumDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFEnumDecl_value = lookupFEnum(getEnum());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFEnumDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFEnumDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:318
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:318")
    public FType type() {
        FType type_value = hasType() ? getType() : myFEnumDecl().type();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect ExpressionSimplification
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:538
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpressionSimplification", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:538")
    public boolean equalsSymbolic(FExp other) {
        {
                if (!(other instanceof FEnumLitExp))
                    return false;
                FEnumLitExp o = (FEnumLitExp) other;
                return getValue() == o.getValue(); 
            }
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = "Identifier";
        return xmlTag_value;
    }
    /**
     * @attribute inh
     * @aspect FlatEnumBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:336
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:336")
    public FEnumDecl lookupFEnum(String name) {
        FEnumDecl lookupFEnum_String_value = getParent().Define_lookupFEnum(this, null, name);
        return lookupFEnum_String_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
