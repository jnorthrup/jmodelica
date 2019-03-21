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
 * String conversion operator.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1595
 * @astdecl FStringExp : FBuiltInFunctionCall ::= Value:FExp [MinimumLength:FExp] [LeftJustified:FExp] [SignificantDigits:FExp] [Format:FExp];
 * @production FStringExp : {@link FBuiltInFunctionCall} ::= <span class="component">Value:{@link FExp}</span> <span class="component">[MinimumLength:{@link FExp}]</span> <span class="component">[LeftJustified:{@link FExp}]</span> <span class="component">[SignificantDigits:{@link FExp}]</span> <span class="component">[Format:{@link FExp}]</span>;

 */
public class FStringExp extends FBuiltInFunctionCall implements Cloneable {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2819
     */
    public static final int DEFAULT_PRECISION = 6;
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1029
     */
    public FStringExp createEmptyNode()       { return new FStringExp();       }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:287
     */
    public void complianceCheck(ErrorCheckType checkType) {
        super.complianceCheck(checkType);
        boolean func = inFunction();
        if (!func && hasMinimumLength()) {
            getMinimumLength().markAsStructuralParameter(checkType);
            if (!getMinimumLength().variability().parameterOrLess())
                UNSUPPORTED_NON_FIXED_STRING_ARGUMENT.invoke(getMinimumLength(), "minimumLength");
        }
        if (!func && hasLeftJustified()) {
            getLeftJustified().markAsStructuralParameter(checkType);
           if (!getLeftJustified().variability().parameterOrLess())
               UNSUPPORTED_NON_FIXED_STRING_ARGUMENT.invoke(getLeftJustified(), "leftJustified");
        }
        if (!func && hasSignificantDigits()) {
            getSignificantDigits().markAsStructuralParameter(checkType);
            if (!getSignificantDigits().variability().parameterOrLess())
                UNSUPPORTED_NON_FIXED_STRING_ARGUMENT.invoke(getSignificantDigits(), "significantDigits");
       }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1392
     */
    public void typeCheck(ErrorCheckType checkType) {
		FType valueType = getValue().type();
		if (hasSignificantDigits() && !valueType.isReal())
			error("Calling function String(): named argument significantDigits can only be used when first argument is real");
		if (hasFormat() && (hasMinimumLength() || hasLeftJustified() || hasSignificantDigits()))
			error("Calling function String(): named argument format can not be used together with minimumLength, leftJustified or significantDigits");
	}
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2661
     */
    public FStringExp flatten(Flattener f) {
        FStringExp flattened = new FStringExp();
        flattened.setValue(getValue().flatten(f));
        if (hasMinimumLength())
            flattened.setMinimumLength(getMinimumLength().flatten(f));
        if (hasLeftJustified())
            flattened.setLeftJustified(getLeftJustified().flatten(f));
        if (hasSignificantDigits())
            flattened.setSignificantDigits(getSignificantDigits().flatten(f));
        if (hasFormat())
            flattened.setFormat(getFormat().flatten(f));
        return flattened;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1752
     */
    public FExp scalarizeExp(Scalarizer s)  {
		FStringExp scalarized = new FStringExp();
		scalarized.setValue(getValue().scalarize(s));
		if (hasMinimumLength())
			scalarized.setMinimumLength(getMinimumLength().scalarize(s));
		if (hasLeftJustified())
			scalarized.setLeftJustified(getLeftJustified().scalarize(s));
		if (hasSignificantDigits())
			scalarized.setSignificantDigits(getSignificantDigits().scalarize(s));
		if (hasFormat())
			scalarized.setFormat(getFormat().scalarize(s));
		return scalarized;
	}
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:860
     */
    @Override
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        super.genVarDecls_C(p, str, indent);
        genTopStringDecl(p, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:866
     */
    @Override
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        super.genTempVars_C(p, str, indent);
        genTopStringInit(p, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:872
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        str.print(tempName_C());
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:877
     */
    @Override
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        super.genTempFree_C(p, str, indent);
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:882
     */
    @Override
    public void genMaxStringLength_C(CodePrinter p, CodeStream str, String indent) {
        if (hasFormat()) {
            str.print(getValue().type().maxNumericStringLength_C(DEFAULT_PRECISION));
        } else {
            if (hasMinimumLength()) {
                str.print("jmi_max(");
            }
            str.print(getValue().type().maxStringLength_C(0));
            if (getValue().type().isReal()) {
                str.print(" + ");
                if (hasSignificantDigits()) {
                    p.print(getSignificantDigits(), str, indent);
                } else {
                    str.print(significantDigits());
                }
            }
            if (hasMinimumLength()) {
                str.print(", ");
                p.print(getMinimumLength(), str, indent);
                str.print(")");
            }
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:950
     */
    @Override
    public void genStringFormat_C(CodePrinter p, CodeStream str, String indent) {
        if (hasFormat()) {
            p.print(getFormat(), str, indent);
        } else {
            if (hasLeftJustified()) {
                str.print("COND_EXP_EQ(");
                p.print(getLeftJustified(), str, indent);
                str.print(", JMI_TRUE, ");
            }
            
            genStringFormat_C(str, true);
            
            if (hasLeftJustified()) {
                str.print(", ");
                genStringFormat_C(str, false);
                str.print(")");
            }
            
            if (hasMinimumLength()) {
                str.print(", (int) ");
                p.print(getMinimumLength(), str, indent);
            }
            
            if (getValue().type().isReal()) {
                str.print(", (int) ");
                if (hasSignificantDigits()) {
                    p.print(getSignificantDigits(), str, indent);
                } else {
                    str.print(significantDigits());
                }
            }
        }
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:985
     */
    public void genStringFormat_C(CodeStream str, boolean justifyLeft) {
        str.print("\"%");
        if (justifyLeft)
            str.print("-");
        if (hasMinimumLength())
            str.print("*");
        if (getValue().type().isReal())
            str.print(".*");
        str.print(getValue().type().formatSpecifier());
        str.print("\"");
    }
    /**
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1016
     */
    @Override
    public void genStringParts_C(CodePrinter p, CodeStream str, String indent) {
        getValue().genStringParts_C(p, str, indent);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FStringExp() {
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
        children = new ASTNode[7];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(Opt.EMPTY, 5);
    }
    /**
     * @declaredat ASTNode:18
     */
    @ASTNodeAnnotation.Constructor(
        name = {"OriginalArg", "Value", "MinimumLength", "LeftJustified", "SignificantDigits", "Format"},
        type = {"List<InstFunctionArgument>", "FExp", "Opt<FExp>", "Opt<FExp>", "Opt<FExp>", "Opt<FExp>"},
        kind = {"List", "Child", "Opt", "Opt", "Opt", "Opt"}
    )
    public FStringExp(List<InstFunctionArgument> p0, FExp p1, Opt<FExp> p2, Opt<FExp> p3, Opt<FExp> p4, Opt<FExp> p5) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
        setChild(p4, 4);
        setChild(p5, 5);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:32
     */
    protected int numChildren() {
        return 6;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:38
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        size_reset();
        type_reset();
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
    public FStringExp clone() throws CloneNotSupportedException {
        FStringExp node = (FStringExp) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:57
     */
    public FStringExp copy() {
        try {
            FStringExp node = (FStringExp) clone();
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
    public FStringExp fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:86
     */
    public FStringExp treeCopyNoTransform() {
        FStringExp tree = (FStringExp) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 6:
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
    public FStringExp treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:116
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the OriginalArg list.
     * @param list The new list node to be used as the OriginalArg list.
     * @apilevel high-level
     */
    public void setOriginalArgList(List<InstFunctionArgument> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * @return Number of children in the OriginalArg list.
     * @apilevel high-level
     */
    public int getNumOriginalArg() {
        return getOriginalArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the OriginalArg list.
     * @apilevel low-level
     */
    public int getNumOriginalArgNoTransform() {
        return getOriginalArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the OriginalArg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the OriginalArg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getOriginalArg(int i) {
        return (InstFunctionArgument) getOriginalArgList().getChild(i);
    }
    /**
     * Check whether the OriginalArg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasOriginalArg() {
        return getOriginalArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the OriginalArg list.
     * @param node The element to append to the OriginalArg list.
     * @apilevel high-level
     */
    public void addOriginalArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getOriginalArgListNoTransform() : getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addOriginalArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getOriginalArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the OriginalArg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setOriginalArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="OriginalArg")
    public List<InstFunctionArgument> getOriginalArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(0);
        return list;
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the OriginalArg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getOriginalArgNoTransform(int i) {
        return (InstFunctionArgument) getOriginalArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getOriginalArgs() {
        return getOriginalArgList();
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgsNoTransform() {
        return getOriginalArgListNoTransform();
    }
    /**
     * Replaces the Value child.
     * @param node The new node to replace the Value child.
     * @apilevel high-level
     */
    public void setValue(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Value child.
     * @return The current node used as the Value child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Value")
    public FExp getValue() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the Value child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Value child.
     * @apilevel low-level
     */
    public FExp getValueNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the MinimumLength child. This is the <code>Opt</code>
     * node containing the child MinimumLength, not the actual child!
     * @param opt The new node to be used as the optional node for the MinimumLength child.
     * @apilevel low-level
     */
    public void setMinimumLengthOpt(Opt<FExp> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) MinimumLength child.
     * @param node The new node to be used as the MinimumLength child.
     * @apilevel high-level
     */
    public void setMinimumLength(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional MinimumLength child exists.
     * @return {@code true} if the optional MinimumLength child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasMinimumLength() {
        return getMinimumLengthOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) MinimumLength child.
     * @return The MinimumLength child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getMinimumLength() {
        return (FExp) getMinimumLengthOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the MinimumLength child. This is the <code>Opt</code> node containing the child MinimumLength, not the actual child!
     * @return The optional node for child the MinimumLength child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="MinimumLength")
    public Opt<FExp> getMinimumLengthOpt() {
        return (Opt<FExp>) getChild(2);
    }
    /**
     * Retrieves the optional node for child MinimumLength. This is the <code>Opt</code> node containing the child MinimumLength, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child MinimumLength.
     * @apilevel low-level
     */
    public Opt<FExp> getMinimumLengthOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(2);
    }
    /**
     * Replaces the optional node for the LeftJustified child. This is the <code>Opt</code>
     * node containing the child LeftJustified, not the actual child!
     * @param opt The new node to be used as the optional node for the LeftJustified child.
     * @apilevel low-level
     */
    public void setLeftJustifiedOpt(Opt<FExp> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) LeftJustified child.
     * @param node The new node to be used as the LeftJustified child.
     * @apilevel high-level
     */
    public void setLeftJustified(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional LeftJustified child exists.
     * @return {@code true} if the optional LeftJustified child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasLeftJustified() {
        return getLeftJustifiedOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) LeftJustified child.
     * @return The LeftJustified child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getLeftJustified() {
        return (FExp) getLeftJustifiedOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the LeftJustified child. This is the <code>Opt</code> node containing the child LeftJustified, not the actual child!
     * @return The optional node for child the LeftJustified child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="LeftJustified")
    public Opt<FExp> getLeftJustifiedOpt() {
        return (Opt<FExp>) getChild(3);
    }
    /**
     * Retrieves the optional node for child LeftJustified. This is the <code>Opt</code> node containing the child LeftJustified, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child LeftJustified.
     * @apilevel low-level
     */
    public Opt<FExp> getLeftJustifiedOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the SignificantDigits child. This is the <code>Opt</code>
     * node containing the child SignificantDigits, not the actual child!
     * @param opt The new node to be used as the optional node for the SignificantDigits child.
     * @apilevel low-level
     */
    public void setSignificantDigitsOpt(Opt<FExp> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) SignificantDigits child.
     * @param node The new node to be used as the SignificantDigits child.
     * @apilevel high-level
     */
    public void setSignificantDigits(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional SignificantDigits child exists.
     * @return {@code true} if the optional SignificantDigits child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasSignificantDigits() {
        return getSignificantDigitsOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) SignificantDigits child.
     * @return The SignificantDigits child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getSignificantDigits() {
        return (FExp) getSignificantDigitsOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the SignificantDigits child. This is the <code>Opt</code> node containing the child SignificantDigits, not the actual child!
     * @return The optional node for child the SignificantDigits child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="SignificantDigits")
    public Opt<FExp> getSignificantDigitsOpt() {
        return (Opt<FExp>) getChild(4);
    }
    /**
     * Retrieves the optional node for child SignificantDigits. This is the <code>Opt</code> node containing the child SignificantDigits, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child SignificantDigits.
     * @apilevel low-level
     */
    public Opt<FExp> getSignificantDigitsOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(4);
    }
    /**
     * Replaces the optional node for the Format child. This is the <code>Opt</code>
     * node containing the child Format, not the actual child!
     * @param opt The new node to be used as the optional node for the Format child.
     * @apilevel low-level
     */
    public void setFormatOpt(Opt<FExp> opt) {
        setChild(opt, 5);
    }
    /**
     * Replaces the (optional) Format child.
     * @param node The new node to be used as the Format child.
     * @apilevel high-level
     */
    public void setFormat(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 5);
        } else {
            setChild(Opt.EMPTY, 5);
        }
    }
    /**
     * Check whether the optional Format child exists.
     * @return {@code true} if the optional Format child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFormat() {
        return getFormatOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Format child.
     * @return The Format child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getFormat() {
        return (FExp) getFormatOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Format child. This is the <code>Opt</code> node containing the child Format, not the actual child!
     * @return The optional node for child the Format child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Format")
    public Opt<FExp> getFormatOpt() {
        return (Opt<FExp>) getChild(5);
    }
    /**
     * Retrieves the optional node for child Format. This is the <code>Opt</code> node containing the child Format, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Format.
     * @apilevel low-level
     */
    public Opt<FExp> getFormatOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(5);
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(6);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 6;
    }
    /** @apilevel internal */
    private void size_reset() {
        size_computed = false;
        
        size_value = null;
    }
    /** @apilevel internal */
    protected boolean size_computed = false;

    /** @apilevel internal */
    protected Size size_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = getValue().size();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
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
        {
                Object value;
                if (getValue().type().isReal())
                  value = getValue().ceval(evaluator).realValue();
                else if (getValue().type().isInteger())
                  value = getValue().ceval(evaluator).intValue();
                else if (getValue().type().isBoolean() || getValue().type().isEnum())
                  value = getValue().ceval(evaluator).stringExpValue();
                else
                  return CValue.UNKNOWN;
                return new CValueString(String.format((Locale) null, formatString(), value));
            }
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2803
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2803")
    public String formatString() {
        String formatString_value = "%" + formatFlags() + formatWidth() + formatPrecision() + formatSpecifier();
        return formatString_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2805
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2805")
    public String formatWidth() {
        String formatWidth_value = minimumLength() > 0 ? String.valueOf(minimumLength()) : "";
        return formatWidth_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2806
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2806")
    public String formatFlags() {
        String formatFlags_value = leftJustified() && minimumLength() > 0 ? "-" : "";
        return formatFlags_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2807
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2807")
    public String formatPrecision() {
        String formatPrecision_value = getValue().type().isReal() ? "." + significantDigits() : "";
        return formatPrecision_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2808
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2808")
    public String formatSpecifier() {
        String formatSpecifier_value = getValue().type().formatSpecifier();
        return formatSpecifier_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2809
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2809")
    public int minimumLength() {
        int minimumLength_value = hasMinimumLength() ? getMinimumLength().ceval().intValue() : 0;
        return minimumLength_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2810
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2810")
    public boolean leftJustified() {
        boolean leftJustified_value = hasLeftJustified() ? getLeftJustified().ceval().booleanValue() : true;
        return leftJustified_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2811
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2811")
    public int significantDigits() {
        int significantDigits_value = hasSignificantDigits() ? getSignificantDigits().ceval().intValue() : DEFAULT_PRECISION;
        return significantDigits_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817")
    public String builtInName() {
        String builtInName_value = "String";
        return builtInName_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = fStringScalarType();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        TypePrefixVariability expVariability_value = super.expVariability().combineDown(Variability.DISCRETE);
        return expVariability_value;
    }
    /**
     * The name of the operator to use for expressions of this type containing overloaded operators.
     * @attribute syn
     * @aspect OperatorRecordTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:84
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="OperatorRecordTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\OperatorRecords.jrag:84")
    public String operatorName() {
        String operatorName_value = OP_STR;
        return operatorName_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1062")
    public boolean isKnownStringLength() {
        boolean isKnownStringLength_value = (!hasSignificantDigits() || getSignificantDigits().variability().knownParameterOrLess())
                    && (!hasMinimumLength() || getMinimumLength().variability().knownParameterOrLess());
        return isKnownStringLength_value;
    }
    /**
     * The maximum length string the representation of the value of this expression can have in C.
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1071
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1071")
    public int maxStringLength_C() {
        int maxStringLength_C_value = hasFormat() ? type().maxNumericStringLength_C(significantDigits()) :
                    Math.max(getValue().type().maxStringLength_C(significantDigits()), minimumLength());
        return maxStringLength_C_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1676
     * @apilevel internal
     */
    public boolean Define_argumentDefinedTypeValid(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getOriginalArgListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1694
            int i = _callerNode.getIndexOfChild(_childNode);
            return i > 0;
        }
        else {
            return super.Define_argumentDefinedTypeValid(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1676
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentDefinedTypeValid
     */
    protected boolean canDefine_argumentDefinedTypeValid(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1708
     * @apilevel internal
     */
    public boolean Define_argumentTypeValid(ASTNode _callerNode, ASTNode _childNode, FType type) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return type.isScalar() && (type.isReal() || type.isInteger() || type.isBoolean() || type.isEnum());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1708
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentTypeValid
     */
    protected boolean canDefine_argumentTypeValid(ASTNode _callerNode, ASTNode _childNode, FType type) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1744
     * @apilevel internal
     */
    public String Define_expectedArgumentType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return "scalar Real, Integer, Boolean or enumeration";
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1744
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expectedArgumentType
     */
    protected boolean canDefine_expectedArgumentType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
