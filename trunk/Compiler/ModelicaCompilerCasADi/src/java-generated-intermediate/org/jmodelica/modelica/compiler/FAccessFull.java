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
 * A full FAccess, with a list of FAccessParts.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:363
 * @astdecl FAccessFull : FAccess ::= FAccessPart*;
 * @production FAccessFull : {@link FAccess} ::= <span class="component">{@link FAccessPart}*</span>;

 */
public class FAccessFull extends FAccess implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:462
     */
    public ArrayList<FArraySubscripts> createFArraySubscriptsList() {
        ArrayList<FArraySubscripts> res = new ArrayList<FArraySubscripts>();
        for (FAccessPart accessPart : getFAccessParts()) {
            if (accessPart.hasFArraySubscripts()) {
                res.add(accessPart.getFArraySubscripts());
            }
        }
        return res;
    }
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2000
     */
    public FAccess specify(Index i, boolean scalarize) {
		FAccessFull res = new FAccessFull();
		int[] dim = new int[1];
		int np = getNumFAccessPart();
		for (int j = 0; j < np; j++) {
			FAccessPart part = getFAccessPart(j);
			int n = part.numFSubscripts();
			if (n == 0 && j == np - 1)
				n = i.ndims() - dim[0];
			FArraySubscripts newfas = null;
			if (n > 0) {
                if (part.hasFArraySubscripts()) {
                    newfas = part.getFArraySubscripts().createSpecified(i, dim);
                } else {
                    List<FSubscript> newSubscripts = new List<>();
                    for (int k = 0; k < n; k++) {
                        newSubscripts.add(new FIntegerSubscript(i.get(dim[0]++)));
                    }
                    newfas = FArraySubscripts.createFArraySubscripts(newSubscripts);
				}
                // If this is last part, append the rest of i to newfas
                while (j == np - 1 && dim[0] < i.ndims())
                    newfas.addFSubscript(i.get(dim[0]++));
			}
			FAccessPart newpart = (newfas == null) ? 
					new FAccessPart(part.getName()) : 
					new FAccessPartArray(part.getName(), newfas);
			res.addFAccessPart(newpart);
		}
		res.scalarized = scalarize;
		return res;
	}
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:144
     */
    public void assignToInFuncEval(AlgorithmEvaluator evaluator, CValue right) {
        FAbstractVariable var = myTopFV();
        FAccessPart firstPart = getFAccessPart(0);
        CValue val = var.type().assignToPartInFuncEval(firstPart, var.evaluationValue(evaluator), right);
        evaluator.setEvaluationValue(var, val);
    }
    /**
     * Constructs an FAccess with the given name parts (without any subscripts).
     * 
     * Does <em>not</em> parse array subscripts.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:243
     */
    public FAccessFull(String... name) {
        this(new List());
        for (String part : name)
            addFAccessPart(part);
    }
    /**
     * Creates and adds a new FAccessPart without array subscripts.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:252
     */
    public void addFAccessPart(String name) {
    	addFAccessPart(new FAccessPart(name));
    }
    /**
     * Constructs an FAccess by splitting the given name into name parts and adding array subscripts.
     * 
     * Does <em>not</em> parse array subscripts.
     * 
     * @param fas  the array subscripts to set for the last name part
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:263
     */
    public FAccessFull(String name, FArraySubscripts fas) {
		this(name);
		addFArraySubscripts(fas);
	}
    /**
     * Get a string representation of a prefix of this name.
     * 
     * @param start The first sub part to include
     * @param n     the number of parts to include. If <code>n <= 0</code>, then 
     * all but the last <code>-n</code> parts are included.
     * @param op    if not <code>null</code>, generate a name with an operator applied (e.g. "der(a.b)")
     * @param eval  if <code>true</code>, then evaluate all expressions first
     * @param index if greater or equal to two, then the index added as a second argument (eg "der(a.b,2)").
     * This only works if op is not null. 
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:99
     */
    private String prefixName(int start, int n, String op, boolean eval, int index) {
        int tot = getNumFAccessPart();
        if (n <= 0)
            n = tot + n;
        StringBuilder str = new StringBuilder();
        if (op != null) {
            str.append(op);
            str.append("(");
        }
        for (int i = start; i < n; i++) {
            FAccessPart part = getFAccessPart(i);
            boolean last = i == n - 1;
            str.append(part.getName());
            if ((!last || op != null || isScalarized()) && part.hasFArraySubscripts()) {
                FArraySubscripts fas = part.getFArraySubscripts();
                if (eval)
                    fas = fas.createEvaluated();
                str.append(fas);
            }
            if (!last) 
                str.append(".");
        }
        if (op != null) {
            if (index > 1) {
                str.append(',');
                str.append(index);
            }
            str.append(")");
        }
        return str.toString();
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:545
     */
    public FAccessFull append(String name) {
        addFAccessPart(name);
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:554
     */
    public FAccess append(String name, FArraySubscripts fas) {
        if (use(fas)) {
            addFAccessPart(new FAccessPartArray(name, fas));
        } else {
            addFAccessPart(new FAccessPart(name));
        }
        return this;
    }
    /**
     * Copy and append all name parts from <code>access</code>.
     * 
     * @return  <code>this</code>, for convenience
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:572
     */
    public FAccessFull append(FAccess access) {
        return access.appendTo(this);
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:586
     */
    protected FAccessFull appendTo(FAccessFull access) {
        return access.appendFull(this);
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:590
     */
    protected FAccessFull appendFull(FAccessFull access) {
        for (FAccessPart part : access.getFAccessParts())
            addFAccessPart(part.fullCopy());
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:609
     */
    public FAccessFull copyAndAppend(String name) {
        return fullCopy().append(name);
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:640
     */
    public FAccessFull copyAsFAccessFull() {
        return fullCopy();
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:653
     */
    public FAccessFull asFAccessFull() {
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:670
     */
    public FAccessFull copyAndPrepend(String name) {
        FAccessFull res = treeCopy();
        FAccessPart first = res.getFAccessPart(0);
        first.setName(name + "." + first.getName());
        return res;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:699
     */
    public FAccessFull copyAndAddPrefix(String prefix, boolean removeUnderscore) {
        FAccessFull res = fullCopy();
        String name = res.getFAccessPart(0).getName();
        if (removeUnderscore && name.startsWith("_")) {
            name = name.substring(1);
        }
        res.getFAccessPart(0).setName(prefix + name);
        return res;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:722
     */
    public FAccess copyAndAddSubscript(int s) {
        return fullCopy().addSubscript(s);
    }
    /**
     * Add new FSubscript to the last name part.
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:729
     */
    public FAccess addSubscript(int s) {
        int i = getNumFAccessPart() - 1;
        setFAccessPart(getFAccessPart(i).addSubscript(s), i);
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:768
     */
    public FAccessFull copyAndAddFas(FArraySubscripts fas) {
        return treeCopy().addFArraySubscripts(fas);
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:791
     */
    public FAccessFull copyAndAddFas(Index i) {
        return copyAndAddFas(i.createFArraySubscripts());
    }
    /**
     * Set the FArraySubscripts of the last FAccessPart.
     * 
     * Passing null as fas is equivalent to calling {@link #removeFArraySubscripts()}.
     * 
     * @return  <code>this</code>, for convenience
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:813
     */
    public FAccessFull addFArraySubscripts(FArraySubscripts fas) {
        if (fas == null)
            return removeFArraySubscripts();
        int i = getNumFAccessPart() - 1;
        setFAccessPart(new FAccessPartArray(getFAccessPart(i).getName(), fas), i);
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:830
     */
    public FAccessFull removeFArraySubscripts() {
        int i = getNumFAccessPart() - 1;
        if (getFAccessPart(i).hasFArraySubscripts())
            setFAccessPart(new FAccessPart(getFAccessPart(i).getName()), i);
        return this;
    }
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:930
     */
    public FAccess copyPart(int first, int last) {
        if (last < first)
            return new FAccessEmpty();
        if (last == first)
            return getFAccessPart(first).createFAccess();
        FAccessFull res = new FAccessFull();
        for (int i = first; i <= last; i++)
            res.addFAccessPart(getFAccessPart(i).fullCopy());
        return res;
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1311
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		for (int i = 0, n = getNumFAccessPart(); i < n; i++) {
			p.print(getFAccessPart(i), str, indent);
			if (i < n - 1)
				str.print(".");
		}
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:674
     */
    public void removeFromUses() {
        for (FAccessPart p : getFAccessParts()) {
            if (p.hasFArraySubscripts()) {
                p.getFArraySubscripts().removeFromUses();
            }
        }
	}
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:640
     */
    public void preventEvents() {
        for (FAccessPart part : getFAccessParts()) {
            if (part.hasFArraySubscripts()) {
                part.getFArraySubscripts().preventEvents();
            }
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:965
     */
    public void inlineFunctions(AbstractFunctionInliner fi) {
        for (FAccessPart part : getFAccessParts())
            if (part.hasFArraySubscripts())
                part.getFArraySubscripts().inlineFunctions(fi);
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1649
     */
    public FAccess copyWithNonLiteralSubscriptsAsColon() {
        FAccessFull res = new FAccessFull();
        for (FAccessPart p : getFAccessParts()) {
            res.addFAccessPartNoTransform(p.copyWithNonLiteralSubscriptsAsColon());
        }
        return res;
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1697
     */
    public FArraySubscripts copyNonLiteralSubscripts() {
        FArrayExpSubscripts fas = new FArrayExpSubscripts();
        for (FAccessPart p : getFAccessParts()) {
            p.copyNonLiteralSubscriptsTo(fas);
        }
        return fas;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1148
     */
    public FExp scalarRecordFExpForCon(Scalarizer s, FRecordConstructor con) {
        FAccessPart first = getFAccessPart(0);
        FExp arg = con.component(first.getName());
        if (first.hasFArraySubscripts()) {
            if (arg.useTempVar()) {
                arg = arg.tempExp(first.getFArraySubscripts());
            } else {
                arg = arg.extractArrayCell(s, first.getFArraySubscripts().createIndex());
            }
        }
        return copySuffix().scalarRecordFExp(s, arg);
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1533
     */
    public FAccess scalarize(Scalarizer s) {
        if (!inFunction()) {
            StringBuilder name = new StringBuilder();
            getFAccessPart(0).scalarizeAsString(name);
            for (int i = 1; i < getNumFAccessPart(); i++) {
                name.append(".");
                getFAccessPart(i).scalarizeAsString(name);
            }
            return new FAccessString(name.toString());
        } else {
            FAccessFull access = new FAccessFull(new List());
            for (FAccessPart accessp : getFAccessParts()) 
                access.addFAccessPart(accessp.scalarize(s));
            return access;
        }
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:461
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		for (FAccessPart np : getFAccessParts())
			np.prettyPrint_XML(str,p.indent(indent));
	}
    /**
     * @declaredat ASTNode:1
     */
    public FAccessFull() {
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
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"FAccessPart"},
        type = {"List<FAccessPart>"},
        kind = {"List"}
    )
    public FAccessFull(List<FAccessPart> p0) {
        setChild(p0, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:23
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:29
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:33
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        declarationSize_reset();
        myTopFV_reset();
        name_reset();
        derName_int_reset();
        dynDerName_int_reset();
        preName_reset();
        nameUnderscore_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:48
     */
    public FAccessFull clone() throws CloneNotSupportedException {
        FAccessFull node = (FAccessFull) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:53
     */
    public FAccessFull copy() {
        try {
            FAccessFull node = (FAccessFull) clone();
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
     * @declaredat ASTNode:72
     */
    @Deprecated
    public FAccessFull fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:82
     */
    public FAccessFull treeCopyNoTransform() {
        FAccessFull tree = (FAccessFull) copy();
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
     * @declaredat ASTNode:107
     */
    public FAccessFull treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:112
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the FAccessPart list.
     * @param list The new list node to be used as the FAccessPart list.
     * @apilevel high-level
     */
    public void setFAccessPartList(List<FAccessPart> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the FAccessPart list.
     * @return Number of children in the FAccessPart list.
     * @apilevel high-level
     */
    public int getNumFAccessPart() {
        return getFAccessPartList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAccessPart list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAccessPart list.
     * @apilevel low-level
     */
    public int getNumFAccessPartNoTransform() {
        return getFAccessPartListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAccessPart list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAccessPart list.
     * @apilevel high-level
     */
    public FAccessPart getFAccessPart(int i) {
        return (FAccessPart) getFAccessPartList().getChild(i);
    }
    /**
     * Check whether the FAccessPart list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAccessPart() {
        return getFAccessPartList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAccessPart list.
     * @param node The element to append to the FAccessPart list.
     * @apilevel high-level
     */
    public void addFAccessPart(FAccessPart node) {
        List<FAccessPart> list = (parent == null) ? getFAccessPartListNoTransform() : getFAccessPartList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAccessPartNoTransform(FAccessPart node) {
        List<FAccessPart> list = getFAccessPartListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAccessPart list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAccessPart(FAccessPart node, int i) {
        List<FAccessPart> list = getFAccessPartList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAccessPart list.
     * @return The node representing the FAccessPart list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAccessPart")
    public List<FAccessPart> getFAccessPartList() {
        List<FAccessPart> list = (List<FAccessPart>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FAccessPart list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAccessPart list.
     * @apilevel low-level
     */
    public List<FAccessPart> getFAccessPartListNoTransform() {
        return (List<FAccessPart>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the FAccessPart list without
     * triggering rewrites.
     */
    public FAccessPart getFAccessPartNoTransform(int i) {
        return (FAccessPart) getFAccessPartListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAccessPart list.
     * @return The node representing the FAccessPart list.
     * @apilevel high-level
     */
    public List<FAccessPart> getFAccessParts() {
        return getFAccessPartList();
    }
    /**
     * Retrieves the FAccessPart list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAccessPart list.
     * @apilevel low-level
     */
    public List<FAccessPart> getFAccessPartsNoTransform() {
        return getFAccessPartListNoTransform();
    }
    /**
     * Retrieves the ExpandedSubscripts child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ExpandedSubscripts child.
     * @apilevel low-level
     */
    public FArraySubscripts getExpandedSubscriptsNoTransform() {
        return (FArraySubscripts) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child ExpandedSubscripts.
     * @return The the child position of the optional child ExpandedSubscripts.
     * @apilevel low-level
     */
    protected int getExpandedSubscriptsChildPosition() {
        return 1;
    }
    /**
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:551
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:551")
    public int declarationNDims() {
        {
        		// Only look at the array subscripts for the last FAccessPart,
        		// all other array subscripts has been expanded in the instantiation.
        		FAccessPart last = getFAccessPart(getNumFAccessPart() - 1);
        		if (last.hasFArraySubscripts()) {
        			return last.getFArraySubscripts().ndims(); 
        		} else {
        			return 0;
        		}
        	}
    }
    /**
     * Get array dimensions of an identifier when used in an identifier.
     * 
     * Here it is not sufficient to check the number of subscripts; the 
     * identifier x[1] has the dimension 0, not 1.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:574
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:574")
    public int accessNdims() {
        {
                int res = 0;
                for (FAccessPart accessPart : getFAccessParts()) {
                    res = res + accessPart.accessNdims();
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void declarationSize_reset() {
        declarationSize_computed = false;
        
        declarationSize_value = null;
    }
    /** @apilevel internal */
    protected boolean declarationSize_computed = false;

    /** @apilevel internal */
    protected Size declarationSize_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1171
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1171")
    public Size declarationSize() {
        ASTState state = state();
        if (declarationSize_computed) {
            return declarationSize_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        declarationSize_value = declarationSize_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        declarationSize_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return declarationSize_value;
    }
    /** @apilevel internal */
    private Size declarationSize_compute() {
    		FAccessPart last = getFAccessPart(getNumFAccessPart()-1);
    		if (last.hasFArraySubscripts()) {
    			return last.getFArraySubscripts().declarationSize(); 
    		} else {
    			return Size.SCALAR;
    		}
    	}
    /**
     * @attribute syn
     * @aspect CircularExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4729
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4729")
    public boolean isCircular() {
        {
        		for (FAccessPart part : getFAccessParts())
        			if (part.isCircular())
        				return true;
        		return false;
        	}
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:89
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:89")
    public FAttribute findHierarchicalAttribute(FAccessFull prefix, FVariable var, int n) {
        {
                int i = prefix.numMatchingParts(this);
                if (i >= n)
                    return null;
                FAttribute attr = var.findAttribute(getFAccessPart(i).getName());
                for (i++; i < n && attr != null; i++)
                    attr = attr.findAttribute(getFAccessPart(i).getName());
                return attr;
            }
    }
    /** @apilevel internal */
    private void myTopFV_reset() {
        myTopFV_computed = false;
        
        myTopFV_value = null;
    }
    /** @apilevel internal */
    protected boolean myTopFV_computed = false;

    /** @apilevel internal */
    protected FAbstractVariable myTopFV_value;

    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:28
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:28")
    public FAbstractVariable myTopFV() {
        ASTState state = state();
        if (myTopFV_computed) {
            return myTopFV_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myTopFV_value = getFAccessPart(0).myFV();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myTopFV_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myTopFV_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:127
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:127")
    public FAbstractVariable myFV() {
        FAbstractVariable myFV_value = getFAccessPart(getNumFAccessPart() - 1).myFV();
        return myFV_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNameBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:131")
    public FAbstractVariable myOutermostFV() {
        FAbstractVariable myOutermostFV_value = getFAccessPart(0).myFV();
        return myOutermostFV_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:70
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:70")
    public FAccessPart lastFAccessPart() {
        FAccessPart lastFAccessPart_value = getFAccessPart(getNumFAccessPart()-1);
        return lastFAccessPart_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:77")
    public boolean hasFArraySubscripts() {
        boolean hasFArraySubscripts_value = lastFAccessPart().hasFArraySubscripts();
        return hasFArraySubscripts_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:78
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:78")
    public FArraySubscripts getFArraySubscripts() {
        FArraySubscripts getFArraySubscripts_value = lastFAccessPart().getFArraySubscripts();
        return getFArraySubscripts_value;
    }
    /**
     * Gets a specific name part. Consides FAccessString as always having a single part.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:134")
    public String partName(int i) {
        String partName_int_value = getFAccessPart(i).getName();
        return partName_int_value;
    }
    /**
     * Gets the prefix name parts. Considers FAccessString as having one part for each '.'-separated substring.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:157")
    public String prefixActualPartName() {
        String prefixActualPartName_value = prefixName(0, -1, null, false, -1);
        return prefixActualPartName_value;
    }
    /**
     * The number of name parts. Will always report 1 for FAccessString.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:173
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:173")
    public int numParts() {
        int numParts_value = getNumFAccessPart();
        return numParts_value;
    }
    /**
     * The number of dots in the name.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:180
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:180")
    public int numDots() {
        int numDots_value = getNumFAccessPart() - 1;
        return numDots_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:189
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:189")
    public int numMatchingParts(FAccessFull access) {
        {
                int n = getNumFAccessPart();
                for (int i = 0; i < n; i++)
                    if (!getFAccessPart(i).getName().equals(access.getFAccessPart(i).getName()))
                        return i;
                return n;
            }
    }
    /** @apilevel internal */
    private void name_reset() {
        name_computed = false;
        
        name_value = null;
    }
    /** @apilevel internal */
    protected boolean name_computed = false;

    /** @apilevel internal */
    protected String name_value;

    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:268")
    public String name() {
        ASTState state = state();
        if (name_computed) {
            return name_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_value = prefixName(0, 0, null, false, -1);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_value;
    }
    /** @apilevel internal */
    private void derName_int_reset() {
        derName_int_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map derName_int_values;

    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:269
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:269")
    public String derName(int index) {
        Object _parameters = index;
        if (derName_int_values == null) derName_int_values = new java.util.HashMap(4);
        ASTState state = state();
        if (derName_int_values.containsKey(_parameters)) {
            return (String) derName_int_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        String derName_int_value = prefixName(0, 0, DER, false, index);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        derName_int_values.put(_parameters, derName_int_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return derName_int_value;
    }
    /** @apilevel internal */
    private void dynDerName_int_reset() {
        dynDerName_int_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map dynDerName_int_values;

    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:270
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:270")
    public String dynDerName(int index) {
        Object _parameters = index;
        if (dynDerName_int_values == null) dynDerName_int_values = new java.util.HashMap(4);
        ASTState state = state();
        if (dynDerName_int_values.containsKey(_parameters)) {
            return (String) dynDerName_int_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        String dynDerName_int_value = prefixName(0, 0, DYN_DER, false, index);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dynDerName_int_values.put(_parameters, dynDerName_int_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return dynDerName_int_value;
    }
    /** @apilevel internal */
    private void preName_reset() {
        preName_computed = false;
        
        preName_value = null;
    }
    /** @apilevel internal */
    protected boolean preName_computed = false;

    /** @apilevel internal */
    protected String preName_value;

    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:271
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:271")
    public String preName() {
        ASTState state = state();
        if (preName_computed) {
            return preName_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        preName_value = prefixName(0, 0, PRE, false, -1);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        preName_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return preName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:283
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:283")
    public String scalarName(boolean eval, boolean onlyLast) {
        {
                boolean scalar = scalarized;
                scalarized = true;
                int start = onlyLast ? numParts() - 1 : 0;
                String res = prefixName(start, 0, null, eval, -1);
                scalarized = scalar;
                return res;
            }
    }
    /** @apilevel internal */
    private void nameUnderscore_reset() {
        nameUnderscore_computed = false;
        
        nameUnderscore_value = null;
    }
    /** @apilevel internal */
    protected boolean nameUnderscore_computed = false;

    /** @apilevel internal */
    protected String nameUnderscore_value;

    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:374")
    public String nameUnderscore() {
        ASTState state = state();
        if (nameUnderscore_computed) {
            return nameUnderscore_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        nameUnderscore_value = nameUnderscore_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        nameUnderscore_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return nameUnderscore_value;
    }
    /** @apilevel internal */
    private String nameUnderscore_compute() {
            StringBuilder str = new StringBuilder();
            int i = 0;
            int last = getNumFAccessPart() - 1;
            String sep = "";
            for (FAccessPart part : getFAccessParts()) {
                str.append(sep);
                sep = "_";
                str.append(part.nameUnderscore());
                if ((i < last || isScalarized()) && part.hasFArraySubscripts()) {
                    for (Subscript s : part.getFArraySubscripts().subscripts()) {
                        str.append(sep);
                        str.append(s.prettyPrint(""));
                    }
                }
            }
            return str.toString();
        }
    /**
     * Check if this is a simple name, i.e. just a string or empty name.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:483
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:483")
    public boolean isSimple() {
        boolean isSimple_value = false;
        return isSimple_value;
    }
    /**
     * Check if this use has any expression or colon array subscripts. 
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:495
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:495")
    public boolean hasNonLiteralSubscripts() {
        {
                for (FAccessPart part : getFAccessParts())
                    if (part.hasNonLiteralSubscripts())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:58
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:58")
    public Size calcMySize(int i) {
        Size calcMySize_int_value = getFAccessPart(0).myFV().lookupHierarchicalSize(this, 0, i);
        return calcMySize_int_value;
    }
    /**
     * @attribute syn
     * @aspect AccessSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:178
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AccessSizes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:178")
    public List<FAccessPart> buildAccessContext() {
        {
                FAccessPart last = getFAccessPart(getNumFAccessPart()-1);
                return last.buildAccessContext(last.name(), null);
            }
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:548
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:548")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = myTopFV().variabilityHierarchical(this, 1).combine(indexVariability());
        return variability_value;
    }
    /**
     * Return a new name that has index instead of the first array subscript with ndims() > 1.
     * 
     * If name has no subscripts, a set of subscripts with all colons is first created.
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1931
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1931")
    public FAccess splitArrayAccess(int index) {
        {
                FAccessFull res = fullCopy();
                int i = getNumFAccessPart();
                res.setFAccessPart(getFAccessPart(i - 1).splitArrayAccess(index, ndims()), i - 1);
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect Slices
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1114
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Slices", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1114")
    public boolean isSlice() {
        {
            	int n = getNumFAccessPart() - 1;
            	for (int i = 0; i < n; i++) {
            		FAccessPart part = getFAccessPart(i);
            		if (part.hasFArraySubscripts())
            			for (Subscript s : part.getFArraySubscripts().subscripts())
            				if (s.ndims() > 0)
            					return true;
            	}
        		FAccessPart part = getFAccessPart(n);
                return part.hasFArraySubscripts() && part.getFArraySubscripts().isSlice();
            }
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:689
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:689")
    public boolean generatesEvents() {
        {
                for (FAccessPart part : getFAccessParts()) {
                    if (part.hasFArraySubscripts()) {
                        if (part.getFArraySubscripts().generatesEvents()) {
                            return true;
                        }
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:769
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FunctionInlining", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:769")
    public boolean hasInlinableFunctions(AbstractFunctionInliner fi) {
        {
                for (FAccessPart part : getFAccessParts())
                    if (part.hasFArraySubscripts())
                        if (part.getFArraySubscripts().hasInlinableFunctions(fi))
                            return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:706
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:706")
    public String toString_C(CodePrinter.ExecuteCodePrinter p) {
        {
                if (getNumFAccessPart() < 2) {
                    return super.toString_C(p);
                }
                
                String type = myFV().funcArrayType(isAssignUse());
                FAccessPart part = getFAccessPart(0);
                FArraySubscripts fas = part.hasFArraySubscripts() ? part.getFArraySubscripts() : null;
                String res = myOutermostFV().genUse_C(p, fas, C_ARRAY_RECORD);
                for (int i = 1, n = getNumFAccessPart(); i < n; i++) {
                    part = getFAccessPart(i);
                    res = res + "->" + part.getName();
                    if (part.hasFArraySubscripts()) {
                        String curType = (n - i > 1 ? C_ARRAY_RECORD : type);
                        res = part.getFArraySubscripts().genFunctionArrayUse_C(p.codePrinter(), res, curType);
                    }
                }
                return res;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:211
     * @apilevel internal
     */
    public CommonNamePart Define_nextNamePart(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessPartListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:212
            int i = _callerNode.getIndexOfChild(_childNode);
            return getNumFAccessPart() > i + 1 ? getFAccessPart(i + 1) : null;
        }
        else {
            return getParent().Define_nextNamePart(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:211
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute nextNamePart
     */
    protected boolean canDefine_nextNamePart(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:150
     * @apilevel internal
     */
    public FAbstractVariable Define_myContextFV(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessPartListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:151
            int i = _callerNode.getIndexOfChild(_childNode);
            return i == 0 ? null : getFAccessPart(i - 1).myFV();
        }
        else {
            return getParent().Define_myContextFV(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:150
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myContextFV
     */
    protected boolean canDefine_myContextFV(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:160
     * @apilevel internal
     */
    public boolean Define_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return isGlobalAccess();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:160
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGlobalAccess
     */
    protected boolean canDefine_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:842
     * @apilevel internal
     */
    public FAccess Define_partialName(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessPartListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:843
            int i = _callerNode.getIndexOfChild(_childNode);
            return (i == getNumFAccessPart() - 1) ? this : copyPrefix();
        }
        else {
            return getParent().Define_partialName(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:842
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute partialName
     */
    protected boolean canDefine_partialName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:52
     * @apilevel internal
     */
    public Size Define_mySize(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessPartListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:56
            int i = _callerNode.getIndexOfChild(_childNode);
            return calcMySize(i+1);
        }
        else {
            return super.Define_mySize(_callerNode, _childNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:52
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute mySize
     */
    protected boolean canDefine_mySize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:215
     * @apilevel internal
     */
    public List<FAccessPart> Define_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessPartListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:218
            int i = _callerNode.getIndexOfChild(_childNode);
            return i == 0 ? new List<FAccessPart>() : getFAccessPart(i-1).buildAccessContext();
        }
        else {
            return getParent().Define_accessContextFlat(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:215
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextFlat
     */
    protected boolean canDefine_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
