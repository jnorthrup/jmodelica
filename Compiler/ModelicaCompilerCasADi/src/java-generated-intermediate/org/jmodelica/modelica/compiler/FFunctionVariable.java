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
 * A flat variable in a function.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:88
 * @astdecl FFunctionVariable : FAbstractVariable ::= <TypePrefixInputOutput:TypePrefixInputOutput> FAttribute* Type:FType [BindingExp:FExp] FAccess <Order:int>;
 * @production FFunctionVariable : {@link FAbstractVariable} ::= <span class="component">&lt;TypePrefixInputOutput:TypePrefixInputOutput&gt;</span> <span class="component">{@link FAttribute}*</span> <span class="component">Type:{@link FType}</span> <span class="component">[BindingExp:{@link FExp}]</span> <span class="component">{@link FAccess}</span> <span class="component">&lt;Order:int&gt;</span>;

 */
public class FFunctionVariable extends FAbstractVariable implements Cloneable, FCallable, FlatLookupNode {
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3667
     */
    public void resetAfterCeval() {
        super.resetAfterCeval();
        clearLocalCachedEvaluationValue();
        size().resetAfterCeval();
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3740
     */
    public void evaluate(VariableEvaluator evaluator, Map<CommonVariableDecl, CValue> values) {
        evaluationValue.evaluateFunction(evaluator, myFCallable(), values);
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3760
     */
    public Map<CommonVariableDecl, CValue> getCurrentEvaluationValues() { return null; }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3761
     */
    public void setCurrentEvaluationValues(Map<CommonVariableDecl, CValue> values) {}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3874
     */
    protected CValue cevalFunctionBindingExp(VariableEvaluator evaluator) {
        if (hasBindingExp()) {
            return getBindingExp().ceval(evaluator);
        } else if (isArray()) {
            return CValue.UNKNOWN;
        } else {
            return type().zeroCValue();
        }
    }
    /**
     * Create an FFunctionVariable with the given name and type. 
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:749
     */
    public FFunctionVariable(FType type, String name) {
		this(TypePrefixInputOutput.NONE, new List<FAttribute>(), type, new Opt(), new FAccessString(name), 0);
	}
    /**
     * Create an FFunctionVariable with the given name, type and input/output prefix. 
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:756
     */
    public FFunctionVariable(FType type, String name, TypePrefixInputOutput inputOutput) {
        this(inputOutput, new List<FAttribute>(), type, new Opt<FExp>(), new FAccessString(name), 0);
    }
    /**
     * Create an FFunctionVariable with everything but order and attributes given.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:763
     */
    public FFunctionVariable(TypePrefixInputOutput inputOutput, FType type, Opt<FExp> bindingExp, FAccess name) {
        this(inputOutput, new List<FAttribute>(), type, bindingExp, name, 0);
    }
    /**
     * Create new node of same class as this, with the specified children.
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1328
     */
    public FFunctionVariable createNode(TypePrefixInputOutput prefix, FType type, Opt<FExp> bindingExp, FAccess name, int order) {
        FFunctionVariable node = createEmptyNode();
        node.setTypePrefixInputOutput(prefix);
        node.setType(type);
        node.setBindingExpOpt(bindingExp);
        node.setFAccess(name);
        node.setOrder(order);
        return node;
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1338
     */
    public FFunctionVariable createEmptyNode() { return new FFunctionVariable(); }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1275
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        if (!getTypePrefixInputOutput().isNone()) {
            str.print(getTypePrefixInputOutput(), " ");
        }
        str.print(getType().scalarType());
        if (isArray()) {
            str.print("[");
            for (int i = 0; i < ndims(); i++) {
                str.print(":");
                if (i < ndims() - 1) {
                    str.print(",");
                }
            }
            str.print("]");
        }
        str.print(" ", name());
        getFAttributeList().prettyPrintFAttributeList(str, p);
        if (hasBindingExp()) {
            str.print(" := ");
            p.print(getBindingExp(), str, indent);
        }
    }
    /**
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:68
     */
    public Size lookupHierarchicalSize(FAccessFull name, int part, int last) {
        if (functionInliner != null) {
            FType t = functionInliner.lookupType(name.name());
            if (t != null) {
                return t.size();
            }
        } 
        return super.lookupHierarchicalSize(name, part, last);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:641
     */
    public void updateRecordArraySizes() {
        // TODO: this should probably be in attributes as well
        // TODO: if exp is access to input with unknown array sizes, handle that
        if (hasBindingExp() && isRecord())
            getType().updateRecordArraySizes(getBindingExp().type());
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:170
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        super.markUsedGlobals(type);
        if (type().isFunction()) {
            myFCallable().markUsedGlobals(type);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1296
     */
    private AbstractFunctionInliner functionInliner = null;
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1302
     */
    public void cacheFunctionInliner(AbstractFunctionInliner fi) {
        functionInliner = fi;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1310
     */
    public void clearFunctionInliner() {
        functionInliner = null;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1345
     */
    public void inline(AbstractFunctionInliner fi, List<FExp> args) {
        throw new UnsupportedOperationException();
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:266
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		String indent2 = p.indent(indent);
		String indent3 = p.indent(indent2);
		open_XML(str, indent, attr_XML("type", getType().scalarType().toString()));
		enclose_XML(p, str, indent2, "Name", getFAccess());
		
		Size s = size();
		for (int i = 0; i < s.ndims(); i++) {
			open_XML(str, indent2, "Size");
			if (s.hasValue(i))
				p.print(s.createFExp(i), str, indent3);
			else
				str.format("%s<exp:UndefinedDimension/>", indent3);
			close_XML(str, indent2, "Size");
		}

		if (hasBindingExp())
			enclose_XML(p, str, indent2, "BindingExpression", getBindingExp());
		close_XML(str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:351
     */
    @Override
	public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
		if (!isInput()) {
			String suffix = (isOutput() && isComposite() && !isString()) ? C_SUFFIX_NULL : "";
			print(p.createDeclPrinter(str), name_C() + suffix, indent);
		}
	}
    /**
     * @aspect CCodeGenFunctionReturn
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunction.jrag:299
     */
    public void printReturnWrite(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        str.print(indent);
        str.print("JMI_RET(");
        str.print(type().macroType());
        str.print(", ");
        str.print(p.returnName(this));
        str.print(", ");
        str.print(p.name(this));
        str.print(")\n");
    }
    /**
     * @aspect CCodeGenFunctionPartial
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionPartial.jrag:387
     */
    @Override
    public void prettyPrintCall(CodePrinter p, CodeStream str, String indent, final FFunctionCall call) {
        boolean exp = p.functionCallIsExp(call);
        String name = p.ExecStep.name(this);
        final String out = exp ? "NULL" : p.ExecStep.name(call);
        if (!exp) {
            str.print(indent, out, ".n = ", call.myLefts().size(), ";\n");
            str.print(indent);
        }
        String outRef = exp ? "" : "&";
        str.print(name, "->fpcl(", name, ", ", outRef, out);
        for (FExp arg : call.getArgs()) {
            p.printCastArgument(arg, str, indent);
        }
        if (!exp && p.needsOutputVarArgs()) {
            IOComputation ioc = new FunctionCallParameterComputation(", ", call);
            ArrayList<FExp> args = new ArrayList<>();
            args.add(call);
            p.print(ioc, str, indent, myOutputs(), args);
        }
        str.print(")");
        if (!exp) {
            str.print(";\n");
        }
        if (!exp) {
            //write back
            StructComputation sc = new StructComputation() {
                @Override
                public void print(CodePrinter.ExecuteCodePrinter p, CodeStream str,
                        String indent, ArrayList<FFunctionVariable> variables, ArrayList<FFunctionCallLeft> args) {
                    int i = 0;
                    for (FFunctionCallLeft arg : args) {
                        p.print(variables.get(i), arg, str, indent, this);
                        i++;
                    }
                }

                @Override
                public void print(FFunctionVariable v, FFunctionCallLeft arg, 
                        CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
                    String name = p.name(arg);
                    str.print(indent, name, " = ", out, ".", name, ";\n");
                }
			};
            p.print(sc, str, indent, myOutputs(), call.myLefts());
        }
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:125
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        p.printInit(this, str, indent, type());
    }
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:134
     */
    public void exportWrapperDecl_C(CodeStream str) {
		str.format("%s %s", exportWrapperType_C(), name_C());
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:138
     */
    public void exportWrapperTypeDecl_C(CodeStream str) {
		str.print(exportWrapperType_C());
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:142
     */
    public void exportWrapperCall_C(CodeStream str) {
		str.print(name_C());
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:166
     */
    public void exportWrapperDeclareTemp_C(CodeStream str, String ind) {
	}
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:169
     */
    public void exportWrapperInitTemp_C(CodeStream str, String ind) {
	}
    /**
     * @declaredat ASTNode:1
     */
    public FFunctionVariable() {
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
        children = new ASTNode[4];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"TypePrefixInputOutput", "FAttribute", "Type", "BindingExp", "FAccess", "Order"},
        type = {"TypePrefixInputOutput", "List<FAttribute>", "FType", "Opt<FExp>", "FAccess", "int"},
        kind = {"Token", "List", "Child", "Opt", "Child", "Token"}
    )
    public FFunctionVariable(TypePrefixInputOutput p0, List<FAttribute> p1, FType p2, Opt<FExp> p3, FAccess p4, int p5) {
        setTypePrefixInputOutput(p0);
        setChild(p1, 0);
        setChild(p2, 1);
        setChild(p3, 2);
        setChild(p4, 3);
        setOrder(p5);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:29
     */
    protected int numChildren() {
        return 4;
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
        myFRecordDecl_reset();
        myFEnumDecl_reset();
        type_reset();
        name_C_reset();
        asMXVariable_reset();
        asMXVector_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
        FFunctionVariable_assigningUses_computed = false;
        
        FFunctionVariable_assigningUses_value = null;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FFunctionVariable clone() throws CloneNotSupportedException {
        FFunctionVariable node = (FFunctionVariable) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:61
     */
    public FFunctionVariable copy() {
        try {
            FFunctionVariable node = (FFunctionVariable) clone();
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
     * @declaredat ASTNode:80
     */
    @Deprecated
    public FFunctionVariable fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:90
     */
    public FFunctionVariable treeCopyNoTransform() {
        FFunctionVariable tree = (FFunctionVariable) copy();
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
     * @declaredat ASTNode:110
     */
    public FFunctionVariable treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:115
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenTypePrefixInputOutput_TypePrefixInputOutput == ((FFunctionVariable) node).tokenTypePrefixInputOutput_TypePrefixInputOutput) && (tokenint_Order == ((FFunctionVariable) node).tokenint_Order);    
    }
    /**
     * Replaces the lexeme TypePrefixInputOutput.
     * @param value The new value for the lexeme TypePrefixInputOutput.
     * @apilevel high-level
     */
    public void setTypePrefixInputOutput(TypePrefixInputOutput value) {
        tokenTypePrefixInputOutput_TypePrefixInputOutput = value;
    }
    /** @apilevel internal 
     */
    protected TypePrefixInputOutput tokenTypePrefixInputOutput_TypePrefixInputOutput;
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
     * Replaces the Type child.
     * @param node The new node to replace the Type child.
     * @apilevel high-level
     */
    public void setType(FType node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Type child.
     * @return The current node used as the Type child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Type")
    public FType getType() {
        return (FType) getChild(1);
    }
    /**
     * Retrieves the Type child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Type child.
     * @apilevel low-level
     */
    public FType getTypeNoTransform() {
        return (FType) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the BindingExp child. This is the <code>Opt</code>
     * node containing the child BindingExp, not the actual child!
     * @param opt The new node to be used as the optional node for the BindingExp child.
     * @apilevel low-level
     */
    public void setBindingExpOpt(Opt<FExp> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) BindingExp child.
     * @param node The new node to be used as the BindingExp child.
     * @apilevel high-level
     */
    public void setBindingExp(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
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
        return (Opt<FExp>) getChild(2);
    }
    /**
     * Retrieves the optional node for child BindingExp. This is the <code>Opt</code> node containing the child BindingExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child BindingExp.
     * @apilevel low-level
     */
    public Opt<FExp> getBindingExpOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(2);
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
     * Replaces the lexeme Order.
     * @param value The new value for the lexeme Order.
     * @apilevel high-level
     */
    public void setOrder(int value) {
        tokenint_Order = value;
    }
    /** @apilevel internal 
     */
    protected int tokenint_Order;
    /**
     * Retrieves the value for the lexeme Order.
     * @return The value for the lexeme Order.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Order")
    public int getOrder() {
        return tokenint_Order;
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:183
     */
    private FType refined_FlatTypeAnalysis_FFunctionVariable_type()
{ return getType(); }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535")
    public int ndims() {
        int ndims_value = 0;
        return ndims_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = evaluationValue(evaluator);
        return ceval_VariableEvaluator_value;
    }
    /**
     * Constant evaluation of FVariable binding expressions.
     * 
     * If an expression is evaluated in an FClass, then identifiers are 
     * referencing FVariables. The constant value of an FVariable is computed
     * by evaluating the binding expression of the variable, if any. If the
     * FVariable is not a constant or a parameter, or if it has no binding
     * expressions, then a CValueUnknown object is returned.
     * 
     * This version only evaluates a specific cell in an array, and returns 
     * the value for that specific cell.
     * 
     * @return The constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        CValue ceval_VariableEvaluator_Index_value = evaluationValue(evaluator).array().getCell(i);
        return ceval_VariableEvaluator_Index_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3640
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3640")
    public CValue evaluatePartial(Map<CommonVariableDecl, CValue> values) {
        CValue evaluatePartial_Map_CommonVariableDecl__CValue__value = evaluationValue.evaluatePartialFunction(this, values);
        return evaluatePartial_Map_CommonVariableDecl__CValue__value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2660
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2660")
    public boolean isFFunctionVariable() {
        boolean isFFunctionVariable_value = true;
        return isFFunctionVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:262
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:262")
    public FCallable myFCallable() {
        FCallable myFCallable_value = lookupFCallable(type().name());
        return myFCallable_value;
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
        myFRecordDecl_value = type().myFRecordDecl();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFRecordDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFRecordDecl_value;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:321
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatEnumBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:321")
    public FEnumDecl myFEnumDecl() {
        ASTState state = state();
        if (myFEnumDecl_computed) {
            return myFEnumDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFEnumDecl_value = type().myFEnumDecl();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFEnumDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFEnumDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:335
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:335")
    public String qualifiedName() {
        String qualifiedName_value = name();
        return qualifiedName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344")
    public String name() {
        String name_value = getFAccessNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418")
    public String nameUnderscore() {
        String nameUnderscore_value = getFAccess().nameUnderscore();
        return nameUnderscore_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:432
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:432")
    public String funcNameUnderscore(String suffix) {
        String funcNameUnderscore_String_value = myFCallable().funcNameUnderscore(suffix);
        return funcNameUnderscore_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:449
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:449")
    public int functionIndex() {
        int functionIndex_value = -1;
        return functionIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:968
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:968")
    public FAccessExp createAccessExp() {
        FAccessExp createAccessExp_value = new FAccessExp(getFAccess().treeCopy());
        return createAccessExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1104")
    public FFunctionDecl asFFunctionDecl() {
        FFunctionDecl asFFunctionDecl_value = null;
        return asFFunctionDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1107
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1107")
    public FFunctionDecl actualFFunctionDecl() {
        FFunctionDecl actualFFunctionDecl_value = myFCallable().actualFFunctionDecl();
        return actualFFunctionDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1110
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1110")
    public boolean isPartialFunction() {
        boolean isPartialFunction_value = type().isFunction();
        return isPartialFunction_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1115
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1115")
    public boolean isInput() {
        boolean isInput_value = getTypePrefixInputOutput().inputCausality();
        return isInput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1116
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1116")
    public boolean isOutput() {
        boolean isOutput_value = getTypePrefixInputOutput().outputCausality();
        return isOutput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1220
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1220")
    public ArrayList<FFunctionVariable> myInputs() {
        ArrayList<FFunctionVariable> myInputs_value = myFCallable().myInputs();
        return myInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1221
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1221")
    public ArrayList<FFunctionVariable> myOutputs() {
        ArrayList<FFunctionVariable> myOutputs_value = myFCallable().myOutputs();
        return myOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1222
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1222")
    public ArrayList<FFunctionVariable> myNonInputs() {
        ArrayList<FFunctionVariable> myNonInputs_value = myFCallable().myNonInputs();
        return myNonInputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1228")
    public FFunctionVariable myInput(int i) {
        FFunctionVariable myInput_int_value = myInputs().get(i);
        return myInput_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1320
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1320")
    public boolean hasOutputs() {
        boolean hasOutputs_value = !myOutputs().isEmpty();
        return hasOutputs_value;
    }
    /**
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1325")
    public FFunctionVariable expOutput() {
        FFunctionVariable expOutput_value = myOutputs().get(0);
        return expOutput_value;
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
        type_value = type_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /** @apilevel internal */
    private FType type_compute() {
            FType res = null;
            if (functionInliner != null) {
                res = functionInliner.lookupType(name());
            }
            return res == null ? refined_FlatTypeAnalysis_FFunctionVariable_type() : res;
        }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1509
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1509")
    public boolean isDestructor() {
        boolean isDestructor_value = false;
        return isDestructor_value;
    }
    /**
     * @attribute syn
     * @aspect ExternalObjectTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1513
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExternalObjectTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1513")
    public boolean isConstructor() {
        boolean isConstructor_value = false;
        return isConstructor_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = Variability.CONTINUOUS;
        return variability_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:552
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:552")
    public TypePrefixVariability variabilityHierarchical(FAccessFull name, int i) {
        TypePrefixVariability variabilityHierarchical_FAccessFull_int_value = variability();
        return variabilityHierarchical_FAccessFull_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:551
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:551")
    public boolean isExternalFunction() {
        boolean isExternalFunction_value = false;
        return isExternalFunction_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = delegateShouldBeDifferentiated();
        return shouldBeDifferentiated_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1048
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1048")
    public boolean isInlinable(AbstractFunctionInliner fi, FFunctionCall call) {
        boolean isInlinable_AbstractFunctionInliner_FFunctionCall_value = false;
        return isInlinable_AbstractFunctionInliner_FFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1119
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1119")
    public boolean isTrivialInlinable(boolean late, FFunctionCall call) {
        boolean isTrivialInlinable_boolean_FFunctionCall_value = false;
        return isTrivialInlinable_boolean_FFunctionCall_value;
    }
    /**
     * @attribute syn
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:895
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SmoothOrder", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:895")
    public int smoothOrder() {
        int smoothOrder_value = myFCallable().smoothOrder();
        return smoothOrder_value;
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1044
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1044")
    public FFunctionVariable createDerivative() {
        {
                return createNode(getTypePrefixInputOutput(), getType().fullCopy(), new Opt<FExp>(), 
                        getFAccess().createDerPrefixedName(1), order() + 1);
            }
    }
    /**
     * @attribute syn
     * @aspect AlgorithmDifferentiation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1059
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AlgorithmDifferentiation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:1059")
    public int order() {
        int order_value = getOrder();
        return order_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:647")
    public String xmlTag() {
        String xmlTag_value = isOutput() ? "OutputVariable" : (isInput() ? "InputVariable" : "ProtectedVariable");
        return xmlTag_value;
    }
    /**
     * @attribute syn
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:740")
    public String xmlNamespace() {
        String xmlNamespace_value = "fun";
        return xmlNamespace_value;
    }
    /** @apilevel internal */
    private void name_C_reset() {
        name_C_computed = false;
        
        name_C_value = null;
    }
    /** @apilevel internal */
    protected boolean name_C_computed = false;

    /** @apilevel internal */
    protected String name_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279")
    public String name_C() {
        ASTState state = state();
        if (name_C_computed) {
            return name_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_C_value = name_C(null, C_SUFFIX_VARIABLE);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:316
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:316")
    public String nameReturn_C() {
        String nameReturn_C_value = isRecord() ? name_C() : name_C(null, C_SUFFIX_RETURN);
        return nameReturn_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExternalCeval", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:268")
    public ExternalArgument externalArgument(FExp exp) {
        ExternalArgument externalArgument_FExp_value = this;
        return externalArgument_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:22
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:22")
    public String typeReturn_C(CodePrinter p) {
        String typeReturn_C_CodePrinter_value = isRecord() ? type_C(p) : (type_C(p) + "*");
        return typeReturn_C_CodePrinter_value;
    }
    /**
     * The type of this variable in an export wrapper function.
     * @attribute syn
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:56
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExportFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:56")
    public String exportWrapperType_C() {
        String exportWrapperType_C_value = type().exportWrapperType_C();
        return exportWrapperType_C_value;
    }
    /**
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:60")
    public MXFunction toMXFunction() {
        {
                throw new UnsupportedOperationException();
            }
    }
    /** @apilevel internal */
    private void asMXVariable_reset() {
        asMXVariable_computed = false;
        
        asMXVariable_value = null;
    }
    /** @apilevel internal */
    protected boolean asMXVariable_computed = false;

    /** @apilevel internal */
    protected MX asMXVariable_value;

    /**
     * For retrieving the MX representation of this variable.
     * Note that some variables can not be represented as a single MX, e.g.
     * FFunctionArray. These may need to be represented as MXVector.
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486")
    public MX asMXVariable() {
        ASTState state = state();
        if (asMXVariable_computed) {
            return asMXVariable_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        asMXVariable_value = ifcasadi.msym(getFAccess().toString());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        asMXVariable_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return asMXVariable_value;
    }
    /** @apilevel internal */
    private void asMXVector_reset() {
        asMXVector_computed = false;
        
        asMXVector_value = null;
    }
    /** @apilevel internal */
    protected boolean asMXVector_computed = false;

    /** @apilevel internal */
    protected MXVector asMXVector_value;

    /**
     * For retrieving the MXVector representation of this variable.
     * Some variables, e.g. FFunctionArray can only be represented
     * as MXVector
     * @return A MXVector
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:475
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:475")
    public MXVector asMXVector() {
        ASTState state = state();
        if (asMXVector_computed) {
            return asMXVector_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        asMXVector_value = asMXVector_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        asMXVector_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return asMXVector_value;
    }
    /** @apilevel internal */
    private MXVector asMXVector_compute() {
            MXVector MXVec = new MXVector();
            if (isRecord()) {
                for (FVariable fvar : myFRecordDecl().getFVariables()) {             
                    ArrayList<String> myFlattenedVariables = new ArrayList<String>();
                    myFlattenedVariables.add(name());
                    myFlattenedVariables = fvar.createFullNestedName(myFlattenedVariables);
                    for (String str : myFlattenedVariables) {
                        MX mx = ifcasadi.msym(str);
                        MXVec.add(mx);
                        getParent().setMXVariableInFunctionDeclRecordVariableMap(str, mx);
                    }
                }
            } else {
                MXVec.add(asMXVariable());
            }
            return MXVec;
        }
    /**
     * @attribute inh
     * @aspect FlatFunctionBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:267
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:267")
    public FCallable lookupFCallable(String name) {
        FCallable lookupFCallable_String_value = getParent().Define_lookupFCallable(this, null, name);
        return lookupFCallable_String_value;
    }
    /**
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1426")
    public FFunctionDecl containingFFunctionDecl() {
        FFunctionDecl containingFFunctionDecl_value = getParent().Define_containingFFunctionDecl(this, null);
        return containingFFunctionDecl_value;
    }
    /**
     * @attribute inh
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:385
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:385")
    public boolean delegateShouldBeDifferentiated() {
        boolean delegateShouldBeDifferentiated_value = getParent().Define_delegateShouldBeDifferentiated(this, null);
        return delegateShouldBeDifferentiated_value;
    }
    /**
     * @attribute inh
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:390
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:390")
    public boolean shouldBeDifferentiated(AnnotationNode derNode) {
        boolean shouldBeDifferentiated_AnnotationNode_value = getParent().Define_shouldBeDifferentiated(this, null, derNode);
        return shouldBeDifferentiated_AnnotationNode_value;
    }
    /**
     * @attribute inh
     * @aspect FunctionScalarizationHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:1013
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FunctionScalarizationHelpers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:1013")
    public FAbstractVariable lookupFV(String name) {
        FAbstractVariable lookupFV_String_value = getParent().Define_lookupFV(this, null, name);
        return lookupFV_String_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /**
     * All uses of this variable that are the left-hand side of an assignment or 
     * function call statement. 
     * @attribute coll
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.COLL)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1111")
    public HashSet<FAccessExp> assigningUses() {
        ASTState state = state();
        if (FFunctionVariable_assigningUses_computed) {
            return FFunctionVariable_assigningUses_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FFunctionVariable_assigningUses_value = assigningUses_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        FFunctionVariable_assigningUses_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return FFunctionVariable_assigningUses_value;
    }
    /** @apilevel internal */
    private HashSet<FAccessExp> assigningUses_compute() {
        ASTNode node = this;
        while (node != null && !(node instanceof FFunctionDecl)) {
            node = node.getParent();
        }
        FFunctionDecl root = (FFunctionDecl) node;
        root.survey_FFunctionVariable_assigningUses();
        HashSet<FAccessExp> _computedValue = new HashSet<>();
        if (root.contributorMap_FFunctionVariable_assigningUses.containsKey(this)) {
            for (ASTNode contributor : root.contributorMap_FFunctionVariable_assigningUses.get(this)) {
                contributor.contributeTo_FFunctionVariable_assigningUses(_computedValue);
            }
        }
        return _computedValue;
    }
    /** @apilevel internal */
    protected boolean FFunctionVariable_assigningUses_computed = false;

    /** @apilevel internal */
    protected HashSet<FAccessExp> FFunctionVariable_assigningUses_value;

    /** @apilevel internal */
    protected void collect_contributors_FClass_myFFunctionDeclsPartial(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1542
        if (type().isFunction()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_myFFunctionDeclsPartial(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myFFunctionDeclsPartial(LinkedHashSet<FFunctionDecl> collection) {
        super.contributeTo_FClass_myFFunctionDeclsPartial(collection);
        if (type().isFunction()) {
            collection.add(myFCallable().actualFFunctionDecl());
        }
    }
}
