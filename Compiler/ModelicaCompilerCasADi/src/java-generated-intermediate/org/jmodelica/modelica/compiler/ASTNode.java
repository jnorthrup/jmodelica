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
 * @astdecl ASTNode;
 * @production ASTNode;

 */
public class ASTNode<T extends ASTNode> extends beaver.Symbol implements Cloneable, ReporterNode, AdjustableSymbol, Iterable<T>, URIResolver.PackageNode, CodeSplitter.Item {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:432
     */
    
        public static <T> ArrayList<T> concatenation(java.util.List<T>... lists) {
			int size = 0;
			for (java.util.List<T> list : lists)
				size += list.size();
			ArrayList<T> res = new ArrayList<T>(size);
			for (java.util.List<T> list : lists)
				res.addAll(list);
			return res;
		}
    /**
     * Replaces all uses of indices in <code>indexMap</code> with the respective expressions.
     * 
     * May alter the tree below this.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1268
     */
    protected ASTNode replaceIndices(Map<String,FExp> indexMap) {
		ASTNode res = replaceFromIndexMap(indexMap);
		if (this == res) {
			for (int i = 0, n = getNumChild(); i < n; i++) {
				ASTNode sub = getChild(i);
				ASTNode repl = sub.replaceIndices(indexMap);
				if (repl != sub)
					setChild(repl, i);
			}
		}
		return res;
	}
    /**
     * If this node is a use of an index in <code>indexMap</code>, return the 
     * respective expression, otherwise return <code>this</code>.
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1289
     */
    protected ASTNode replaceFromIndexMap(Map<String,FExp> indexMap) {
		return this;
	}
    /**
     * @aspect ArrayHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:4585
     */
    public static int[] range(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3661
     */
    public void resetAfterCeval() {
        for (ASTNode n : this) {
            n.resetAfterCeval();
        }
    }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4103
     */
    public Map<CommonVariableDecl,CValue> collectEvaluationValues(Map<CommonVariableDecl,CValue> map) {
        for (ASTNode n : this)
            map = n.collectEvaluationValues(map);
        return map;
    }
    /**
     * @aspect VariableEvaluator
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4922
     */
    public static VariableEvaluator defaultVariableEvaluator() {
        return VariableEvaluator.instance;
    }
    /**
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:476
     */
    
        public static <T> T[] arr(T... args) { 
            return args;
        }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2841
     */
    public Set<InstAccessExp> findInstAccessExpsInTree() {
        return findCommonAccessExpsInTree(DefaultInstAccessExpLookupVisitor.instance);
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2845
     */
    public Set<FAccessExp> findFAccessExpsInTree() {
        return findCommonAccessExpsInTree(DefaultFAccessExpLookupVisitor.instance);
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2849
     */
    public <T extends CommonAccessExp> Set<T> findCommonAccessExpsInTree(CommonAccessExpLookupVisitor<T> visitor) {
        Set<T> set = new LinkedHashSet<>();
        visitor.visit(this, set);
        return set;
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2855
     */
    public <T extends CommonAccessExp> void findCommonAccessExpsInTree(Set<T> set, CommonAccessExpLookupVisitor<T> visitor) {
        for (ASTNode n : this) {
            visitor.visit(n, set);
        }
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2995
     */
    public static Set<FVariable> lookupFVariablesInSet(Set<FAccessExp> set) {
        Set<FVariable> res = new LinkedHashSet<FVariable>();
        for (FAccessExp use : set)
            if (use.myFV() instanceof FVariable)
                res.add((FVariable) use.myFV());
        return res;
    }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3024
     */
    public static Set<FVariable> parametersInSet(Set<? extends FVariable> set) {
        Set<FVariable> res = new LinkedHashSet<FVariable>();
        for (FVariable fv : set)
            if (fv.isParameter())
                res.add(fv);
        return res;
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4207
     */
    public static void attributeLevelsForList(List<FAttribute> l, StringBuilder str) {
        if (l.getNumChild() > 0) {
            str.append("(");
            String sep = ", ";
            String pref = "";
            for (FAttribute a : l) {
                str.append(pref);
                a.attributeLevels(str);
                pref = sep;
            }
            str.append(")");
        }
    }
    /**
     * Return unknown if variable is null, variable otherwise.
     * 
     * Convenience method to facilitate one-liners.
     * @aspect FlatNameBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:98
     */
    public FAbstractVariable nullUnknown(FAbstractVariable variable) {
		return (variable == null) ? unknownFVariable() : variable;
	}
    /**
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:368
     */
    public static String underScore(String s) {
        return s.replaceAll("[^0-9a-zA-Z_]", "_");
    }
    /**
     * Static printer instance.
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:11
     */
    public static HtmlSourcePrettyPrinter printer_htmlSource = new HtmlSourcePrettyPrinter();
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:40
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent) {
		prettyPrint(p, str, indent);
	}
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:81
     */
    public void htmlSourcePrettyPrint(CodeStream str, String indent) {
        //System.out.println("fname: " + printfname());
        //System.out.println("multnodes: " + printmult());
        //System.out.println("Total basenodes: " + printbasenodes() + "\n");
        HtmlSourcePrettyPrinter p = printer_htmlSource;
        str.println("<html>\n<head>\n");
        str.println(p.htmlStyle());
        str.println(p.htmlScriptHeader());
        str.println("</head>\n<body>\n");
        str.println("<div class=\"font\">\n");
        str.println("<button class=\"button\" type=\"button\" onclick=\"classIdSwitch()\">Debug</button><br>\n");

        htmlSourcePrettyPrint(p, str, indent);
        str.println("</div>\n</body>\n</html>");
    }
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:275
     */
    public static String cropAbsolutePath(String path){
		String p = path;
		String dir = System.getProperty("user.dir");
		try{
			if(p.substring(0, dir.lastIndexOf("\\")).equals(dir.substring(0, dir.lastIndexOf("\\")))){
			   	p = p.substring(dir.lastIndexOf("\\") + 1);
			}
		}catch(IndexOutOfBoundsException e){}
		return p;
	}
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:321
     */
    public String htmlSourcePrettyPrint(String indent) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		CodeStream str = new NotNullCodeStream(os);
		htmlSourcePrettyPrint(str, indent);
		return os.toString();
	}
    /**
     * Static printer instance.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:91
     */
    static PrettyPrinter prettyPrinter = new PrettyPrinter();
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:127
     */
    public String prettyPrint(String indent) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CodeStream str = new NotNullCodeStream(os);
        prettyPrint(str, indent);
        return os.toString();
    }
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:134
     */
    public String prettyPrint(Printer printer) {
        return prettyPrint(printer, "");
    }
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:138
     */
    public String prettyPrint(Printer printer, String indent) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CodeStream str = new NotNullCodeStream(baos);
        printer.print(this, str, indent);
        return baos.toString();
    }
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:150
     */
    public void prettyPrint(CodeStream str, String indent) {
         prettyPrint(prettyPrinter, str, indent);
    }
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:163
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
  		for (ASTNode n : this)
   			p.print(n, str, indent);
	}
    /**
     * Prints an ArrayList of any type of ASTNode, adding <code>sep</code> between nodes.
     * 
     * Typical use: <code>prettyPrintWithSep(list, p, str, indent, ", ");</code> 
     * (Prints comma-separated list.)
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:196
     */
    public static void prettyPrintWithSep(java.util.List<? extends ASTNode> l, Printer p, CodeStream str, String indent, String sep) {
		String prefix = "";
		for (ASTNode n : l) {
			str.print(prefix);
			p.print(n, str, indent);
			prefix = sep;
		}
	}
    /**
     * Prints an ArrayList of any type of ASTNode, adding <code>prefix</code> before each node and 
     * <code>suffix</code> after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:221
     */
    public static void prettyPrintWithFix(java.util.List<? extends ASTNode> l, Printer p, CodeStream str, String indent, String prefix, String suffix) {
		for (ASTNode n : l) {
			str.print(prefix);
			p.print(n, str, indent);
			str.print(suffix);
		}
	}
    /**
     * Prints an ArrayList of any type of ASTNode, adding <code>indent</code> before each node and 
     * <code>suffix</code> plus a line break after after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:241
     */
    public static void prettyPrintWithIndent(java.util.List<? extends ASTNode> l, Printer p, CodeStream str, String indent, String suffix) {
		prettyPrintWithFix(l, p, str, indent, indent, suffix + str.getLineEnder());
	}
    /**
     * Prints an ArrayList of any type of ASTNode, adding <code>indent</code> before each node and 
     * a line break after after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:257
     */
    public static void prettyPrintWithIndent(java.util.List<? extends ASTNode> l, Printer p, CodeStream str, String indent) {
		prettyPrintWithFix(l, p, str, indent, indent, str.getLineEnder());
	}
    /**
     * Static printer instance.
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2017
     */
    static MCPrettyPrinter printer_MC = new MCPrettyPrinter();
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2031
     */
    public String prettyPrint_MC(String indent) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		CodeStream str = new CodeStream(os);
		prettyPrint(str,indent);
		return os.toString();
	}
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2149
     */
    public void prettyPrint_MC(CodeStream str, String indent) {
 		prettyPrint_MC(printer_MC, str, indent);
	}
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2153
     */
    public void prettyPrint_MC(Printer p, CodeStream str, String indent) {
 		prettyPrint(p, str, indent);
	}
    /**
     * @aspect AnnotationPrettyPrinting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2184
     */
    public static PrettyPrinter AnnotationPrettyPrinter = new AnnotationPrettyPrinter();
    /**
     * @aspect FunctionCallSizes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:293
     */
    public void replaceSizeFExp(InstFunctionCall call) {
        for (ASTNode n : this) {
            n.replaceSizeFExp(call);
        }
    }
    /**
     * Create a copy of this FExp with variable uses and function calls replaced with expressions 
     * that allow calculations of unknown sizes.
     * 
     * For non-FExp nodes, this simply makes a full copy.
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:484
     */
    public ASTNode copyReplaceAccess(FExp.ContextReplacer crp) {
        return treeCopy();
    }
    /**
     * Static printer instance.
     * @aspect SourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\SourcePrettyPrint.jrag:10
     */
    static SourcePrettyPrinter printer_source = new SourcePrettyPrinter();
    /**
     * @aspect SourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\SourcePrettyPrint.jrag:22
     */
    public void sourcePrettyPrint(Printer p, CodeStream str, String indent) {
        prettyPrint(p, str, indent);
    }
    /**
     * @aspect SourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\SourcePrettyPrint.jrag:26
     */
    public void sourcePrettyPrint(CodeStream str, String indent) {
        sourcePrettyPrint(printer_source, str, indent);
    }
    /**
     * Convert all continous variables that are assigned in when equations and statements into discrete variables.
     * 
     * @param inWhen  is this node in a when equation?
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:294
     */
    public void updateVariabilityForVariablesInWhen(boolean inWhen) {
        for (ASTNode n : this) {
            n.updateVariabilityForVariablesInWhen(inWhen);
        }
    }
    /**
     * Check for code that is not allowed in its current context.
     * 
     * Examples would be checking that classes follow the requirements of 
     * their restriction. 
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:31
     */
    public void complianceCheck(ErrorCheckType checkType) {}
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:46
     */
    private static ErrorChecker COMPLIANCE_CHECKER = addErrorChecker(new ErrorChecker.ComplianceChecker());
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:48
     */
    public static final SimpleProblemProducer ONLY_FMU_IF_STATEMENTS =
            new ComplianceFMUOnlyProducer("ONLY_FMU_IF_STATEMENTS", "Using if statements is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:57
     */
    public static final SimpleProblemProducer ONLY_FMU_WHILE_STATEMENTS =
            new ComplianceFMUOnlyProducer("ONLY_FMU_WHILE_STATEMENTS", "Using while statements is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:66
     */
    public static final SimpleProblemProducer UNSUPPORTED_EVENT_GENERATING_EXPRESSION_IN_WHILE_STATEMENT =
            new SimpleErrorProducer("UNSUPPORTED_EVENT_GENERATING_EXPRESSION_IN_WHILE_STATEMENT", ProblemKind.COMPLIANCE, "Event generating expressions are not supported in while statements");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:75
     */
    public static final SimpleProblemProducer ONLY_FMU_FUNCTION_LIKE_OPERATOR =
            new ComplianceFMUOnlyProducer("ONLY_FMU_FUNCTION_LIKE_OPERATOR", "The %s() function-like operator is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:91
     */
    public static final SimpleProblemProducer ONLY_FMU_NON_FIXED_RECORD_ARRAY_INDEX =
            new ComplianceFMUOnlyProducer("ONLY_FMU_NON_FIXED_RECORD_ARRAY_INDEX", "Using arrays of records with indices of higher than parameter variability is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:93
     */
    public static final SimpleProblemProducer EXTERNAL_OBJECT_CONSTANT_IN_COMPOSITE =
            new SimpleErrorProducer("EXTERNAL_OBJECT_CONSTANT_IN_COMPOSITE", ProblemKind.COMPLIANCE, "Access to external object constants in arrays or records is not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:109
     */
    public static final SimpleProblemProducer ONLY_FMU_WHEN_EQUATIONS =
            new ComplianceFMUOnlyProducer("ONLY_FMU_WHEN_EQUATIONS", "When equations are");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:116
     */
    @Deprecated
    public void complianceOnlyFMU(String message) {
        if (!myOptions().getBooleanOption("generate_ode"))
            compliance(message + " currently only supported when compiling FMUs");
    }
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:122
     */
    public static final SimpleProblemProducer UNSUPPORTED_EQUATION_TYPE =
            new SimpleErrorProducer("UNSUPPORTED_EQUATION_TYPE", ProblemKind.COMPLIANCE, "Unsupported equation type");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:129
     */
    public static final SimpleProblemProducer UNSUPPORTED_EXPRESSION_TYPE =
            new SimpleErrorProducer("UNSUPPORTED_EXPRESSION_TYPE", ProblemKind.COMPLIANCE, "Unsupported expression type");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:136
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTION_LIKE_OPERATOR =
            new SimpleErrorProducer("UNSUPPORTED_FUNCTION_LIKE_OPERATOR", ProblemKind.COMPLIANCE, "The %s() function-like operator is not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:171
     */
    public static final SimpleProblemProducer DEPRECATED_DECOUPLE =
            new SimpleWarningProducer("DEPRECATED_DECOUPLE", ProblemKind.SEMANTIC, "The Subtask.decouple() function-like operator is removed as of Modelica version 3.2r2");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:178
     */
    public static final SimpleProblemProducer DEPRECATED_CARDINALITY =
            new SimpleWarningProducer("DEPRECATED_CARDINALITY", ProblemKind.SEMANTIC, "The cardinality() function-like operator is deprecated, and will be removed in a future version of Modelica");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:181
     */
    public static final SimpleProblemProducer INCORRECT_USE_OF_CARDINALITY =
            new SimpleErrorProducer("INCORRECT_USE_OF_CARDINALITY", ProblemKind.COMPLIANCE, "The cardinality() function-like operator is only supported in asserts and in the tests of if clauses that do not contain connect()");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:194
     */
    public static final SimpleProblemProducer INCORRECT_USE_OF_SPATIAL_DISTRIBUTION =
            new SimpleErrorProducer("INCORRECT_USE_OF_SPATIAL_DISTRIBUTION", ProblemKind.COMPLIANCE, "The spatialDistribution() function-like operator is not supported vectorized in function call equations");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:229
     */
    public static final SimpleProblemProducer UNSUPPORTED_IN_FUNCTION_UNKNOWN_SIZE_OPERATOR =
            new SimpleErrorProducer("UNSUPPORTED_IN_FUNCTION_UNKNOWN_SIZE_OPERATOR", ProblemKind.COMPLIANCE, "Unknown sizes in operator %s is not supported in functions");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:242
     */
    public static final SimpleProblemProducer UNSUPPORTED_NON_FIXED_FOR_INDEX =
            new SimpleErrorProducer("UNSUPPORTED_NON_FIXED_FOR_INDEX", ProblemKind.COMPLIANCE, "For index with higher than parameter variability is not supported in equations and algorithms");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:262
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTION_LIKE_OPERATOR_IGNORED =
            new SimpleWarningProducer("UNSUPPORTED_FUNCTION_LIKE_OPERATOR_IGNORED", ProblemKind.COMPLIANCE, "The %s() function-like operator is not supported, and is currently ignored");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:269
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTION_LIKE_OPERATOR_EVAL_FALSE =
            new SimpleWarningProducer("UNSUPPORTED_FUNCTION_LIKE_OPERATOR_EVAL_FALSE", ProblemKind.COMPLIANCE, "The %s() function-like operator is not supported, and is currently evaluated to false");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:284
     */
    public static final SimpleProblemProducer UNSUPPORTED_NON_FIXED_STRING_ARGUMENT =
            new SimpleErrorProducer("UNSUPPORTED_NON_FIXED_STRING_ARGUMENT", ProblemKind.COMPLIANCE, "%s with higher than parameter variability is not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:307
     */
    public static final SimpleProblemProducer ONLY_FMU_INTEGER_VARIABLES =
            new ComplianceFMUOnlyProducer("ONLY_FMU_INTEGER_VARIABLES", "Integer variables of discrete variability is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:309
     */
    public static final SimpleProblemProducer ONLY_FMU_BOOLEAN_VARIABLES =
            new ComplianceFMUOnlyProducer("ONLY_FMU_BOOLEAN_VARIABLES", "Boolean variables of discrete variability is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:322
     */
    public static final SimpleProblemProducer ONLY_FMU_ENUMERATION_VARIABLES =
            new ComplianceFMUOnlyProducer("ONLY_FMU_ENUMERATION_VARIABLES", "Enumeration variables of discrete variability is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:331
     */
    public static final SimpleProblemProducer ONLY_FMU_FUNCTIONAL_INPUT =
            new ComplianceFMUOnlyProducer("ONLY_FMU_FUNCTIONAL_INPUT", "Using functional input arguments is");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:333
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTIONAL_INPUT_FROM_FUNCTION_DEFAULT =
            new SimpleErrorProducer("UNSUPPORTED_FUNCTIONAL_INPUT_FROM_FUNCTION_DEFAULT", ProblemKind.COMPLIANCE, "Creating functional input arguments from functions with default input arguments is currently not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:335
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTIONAL_INPUT_COMPOSITE =
            new SimpleErrorProducer("UNSUPPORTED_FUNCTIONAL_INPUT_COMPOSITE", ProblemKind.COMPLIANCE, "Functional input arguments with record/array inputs/outputs is currently not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:337
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTIONAL_INPUT_DEFAULT =
            new SimpleErrorProducer("UNSUPPORTED_FUNCTIONAL_INPUT_DEFAULT", ProblemKind.COMPLIANCE, "Default values of functional input arguments is currently not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:339
     */
    public static final SimpleProblemProducer UNSUPPORTED_FUNCTIONAL_ARRAY_INPUT =
            new SimpleErrorProducer("UNSUPPORTED_FUNCTIONAL_ARRAY_INPUT", ProblemKind.COMPLIANCE, "Arrays of functional input arguments is currently not supported");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:369
     */
    public static final SimpleProblemProducer UNSUPPORTED_EXTERNAL_OBJECT_CONSTRUCTORS =
            new SimpleErrorProducer("UNSUPPORTED_EXTERNAL_OBJECT_CONSTRUCTORS", ProblemKind.COMPLIANCE, "Constructors for external objects is not supported in functions");
    /**
     * @aspect ComplianceCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:378
     */
    public static final SimpleProblemProducer UNSUPPORTED_EXTERNAL_FUNCTION_RECORD_RETURN_VALUE =
            new SimpleErrorProducer("UNSUPPORTED_EXTERNAL_FUNCTION_RECORD_RETURN_VALUE", ProblemKind.COMPLIANCE, "Using records as return value from external functions is not supported");
    /**
     * Check for code that is not allowed in its current context.
     * 
     * Examples would be checking that classes follow the requirements of 
     * their restriction. 
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:33
     */
    public void contentCheck(ErrorCheckType checkType) {}
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:48
     */
    private static ErrorChecker CONTENT_CHECKER = addErrorChecker(new ErrorChecker.ContentChecker());
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:102
     */
    public static final SimpleProblemProducer EXTERNAL_DIRECTORY_ANNOTATION =
            new SimpleErrorProducer("EXTERNAL_DIRECTORY_ANNOTATION", ProblemKind.SEMANTIC,
                    "%s annotation could not be resolved\n  %s");
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:105
     */
    public static final SimpleProblemProducer EXTERNAL_DIRECTORY_ANNOTATION_TYPE =
            new SimpleErrorProducer("EXTERNAL_DIRECTORY_ANNOTATION_TYPE", ProblemKind.SEMANTIC,
                    "%s annotation only allows scalar string values");
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:282
     */
    public static final SimpleProblemProducer BINDING_EXPRESSION_VARIABILITY =
        new SimpleErrorProducer("BINDING_EXPRESSION_VARIABILITY", ProblemKind.SEMANTIC, 
            "Variability of binding expression (%s) must be lower or equal to the variability of the component (%s)");
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:286
     */
    public static final SimpleProblemProducer CONSTANT_INPUT =
        new SimpleErrorProducer("CONSTANT_INPUT", ProblemKind.SEMANTIC, "Function input may not be constant");
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:288
     */
    public static final SimpleProblemProducer EXTERNAL_FUNCTION_ANNOTATION =
        new SimpleErrorProducer("EXTERNAL_FUNCTION_ANNOTATION", ProblemKind.SEMANTIC,
            "External function annotations only allowed on external statement annotations. "
            + "This annotation is attached to a class. There might be a semicolon you want to remove.");
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:394
     */
    private static final String OK_ESCAPES = "'\"?\\abfnrtv";
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:396
     */
    public void checkEscapeSequences(ASTNode node, String str, String type) {
        for (int p = str.indexOf('\\'); p > -1 && p < str.length(); p = str.indexOf('\\', p + 2))
            if (OK_ESCAPES.indexOf(str.charAt(p + 1)) == -1)
                node.error("Illegal escape sequence at position %d in %s: '\\%c'", p + 1, type, str.charAt(p + 1));
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:402
     */
    public void checkQuotedIdentifier(ASTNode node, String str) {
        if (str.charAt(0) == '\'')
            checkEscapeSequences(node, str, "quoted identifier");
    }
    /**
     * @aspect ForceVariability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:921
     */
    public void forceUsesVariability(ErrorCheckType checkType, TypePrefixVariability v) {
        for (ASTNode n : this) {
            n.forceUsesVariability(checkType, v);
        }
    }
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:221
     */
    public void breakOnErrors() throws CompilerException {
		root().getErrorHandler().breakOnErrors();
	}
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:247
     */
    public ArrayList<Problem> collectWarnings() {
        return root().getErrorHandler().collectWarnings();
    }
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:280
     */
    public void reportProblem(Problem problem) {
      root().getErrorHandler().problem(problem);
  }
    /**
     * Register an error. Delegates to an {@link IErrorHandler}.
     * @param s	the error message.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:290
     */
    @Deprecated
  public void error(String s) {
	  root().getErrorHandler().error(s, this);
  }
    /**
     * Register an error. Delegates to an {@link IErrorHandler}.
     * 
     * Builds error message using <code>format</code> as format string.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:300
     */
    @Deprecated
  public void error(String format, Object... args) {
	  error(String.format(format, args));
  }
    /**
     * Register a compliance error. Delegates to an {@link IErrorHandler}.
     * @param s	the error message.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:309
     */
    @Deprecated
  public void compliance(String s) {
	  root().getErrorHandler().compliance(s, this);
  }
    /**
     * Register a compliance error. Delegates to an {@link IErrorHandler}.
     * 
     * Builds error message using <code>format</code> as format string.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:319
     */
    @Deprecated
  public void compliance(String format, Object... args) {
	  compliance(String.format(format, args));
  }
    /**
     * Register a warning. Delegates to an {@link IErrorHandler}.
     * @param s	the warning message.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:328
     */
    @Deprecated
  public void warning(String s) {
	  root().getErrorHandler().warning(s, this);
  }
    /**
     * Register a warning. Delegates to an {@link IErrorHandler}.
     * 
     * Builds warning message using <code>format</code> as format string.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:338
     */
    @Deprecated
  public void warning(String format, Object... args) {
	  warning(String.format(format, args));
  }
    /**
     * Register a problem. Delegates to an {@link IErrorHandler}.
     * @param p   the problem.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:347
     */
    @Deprecated
  public void problem(Problem p) {
      root().getErrorHandler().problem(p);
  }
    /**
     * If this node is in a disabled conditional component, generate a warning, otherwise generate an error.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:355
     */
    @Deprecated
    public void errorUnlessDisabled(String s) {
        if (inDisabledComponent()) {
            warning("Found error in disabled conditional:\n  " + s);
        } else {
            error(s);
        }
    }
    /**
     * If this node is in a disabled conditional component, generate a warning, otherwise generate an error.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:367
     */
    @Deprecated
    public void errorUnlessDisabled(String format, Object... args) {
        if (inDisabledComponent()) {
            warning("Found error in disabled conditional:\n  " + format, args);
        } else {
            error(format, args);
        }
    }
    /**
     * If this node is in a disabled conditional component and <code>condition</code> is <code>true</code>, 
     * generate a warning, otherwise generate an error.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:380
     */
    @Deprecated
    public void errorUnlessDisabledAnd(boolean condition, String s) {
        if (condition) {
            errorUnlessDisabled(s);
        } else {
            error(s);
        }
    }
    /**
     * If this node is in a disabled conditional component and <code>condition</code> is <code>true</code>, 
     * generate a warning, otherwise generate an error.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:393
     */
    @Deprecated
    public void errorUnlessDisabledAnd(boolean condition, String format, Object... args) {
        if (condition) {
            errorUnlessDisabled(format, args);
        } else {
            error(format, args);
        }
    }
    /**
     * Lock branch on src and return true if it only has parameter-expression 
     * tests that evaluates to use the branch not indicated by <code>then</code>. 
     * Otherwise delegates to {@link LockBranch#lockBranch(ErrorCheckType)}.
     * 
     * Any parameters used in the test will be marked as structural.
     * 
     * @param checkType  the type of error checks to use when marking structural parameters
     * @param then       if true, we are trying to remove the then-branch, otherwise the else-branch
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:462
     */
    public static boolean lockMyBranch(LockBranch src, ErrorCheckType checkType, FExp exp, boolean then) {
        if (exp.lockable(then)) {
            exp.markAsStructuralParameter(checkType);
            return true;
        } else {
            return src.lockBranch(checkType);
        }
    }
    /**
     * A list that contains all error checkers. New error checkers are added
     * dynamically during static evaluation by calling addErrorChecker().
     * 
     * @see ASTNode.addErrorChecker(ErrorChecker)
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:542
     */
    private static Collection<ErrorChecker> ERROR_CHECKERS;
    /**
     * Add ErrorChecker checker to the list of error checkers. This method
     * should only be called from ASTnode in order to ensure that the checker
     * is added corretly during static evaluation, hence the private
     * visibility.
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:550
     */
    private static ErrorChecker addErrorChecker(ErrorChecker checker) {
        if (ERROR_CHECKERS == null)
            ERROR_CHECKERS = new ArrayList<ErrorChecker>();
        ERROR_CHECKERS.add(checker);
        return checker;
    }
    /**
     * A helper method that calls all registered error checkers.
     * 
     * @see ASTNode#addErrorChecker(ErrorChecker)
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:562
     */
    protected void allChecks(ErrorCheckType checkType) {
        for (ErrorChecker checker : ERROR_CHECKERS)
            checker.check(this, checkType);
    }
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:567
     */
    public void collectErrors(ErrorCheckType checkType) {
        for (ASTNode n : this) {
            n.collectErrors(checkType);
        }
        allChecks(checkType);
    }
    /**
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:575
     */
    public void errorCheck(ErrorCheckType checkType) {
        collectErrors(checkType);
        breakOnErrors();
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:626
     */
    public void resetCollectErrors() {
		for (ASTNode n : noTransform())
			n.resetCollectErrors();
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:631
     */
    public static void resetCollectErrorsOn(ASTNode n) {
		if (n != null)
			n.resetCollectErrors();
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:932
     */
    public static final SimpleProblemProducer PARAMETER_MISSING_BINDING_EXPRESSION =
            new SimpleWarningProducer("PARAMETER_MISSING_BINDING_EXPRESSION", ProblemKind.SEMANTIC, "The parameter %s does not have a binding expression");
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:934
     */
    public static final SimpleProblemProducer CONSTANT_MISSING_BINDING_EXPRESSION =
            new SimpleWarningProducer("CONSTANT_MISSING_BINDING_EXPRESSION", ProblemKind.SEMANTIC, "The constant %s does not have a binding expression");
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:989
     */
    public static final SimpleProblemProducer START_VALUE_NOT_PARAMETER =
            new SimpleErrorProducer("START_VALUE_NOT_PARAMETER", ProblemKind.SEMANTIC,
                    "Variability of binding expression for attribute '%s' is not less"
                    + " than or equal to parameter variability: %s");
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:993
     */
    public static final SimpleProblemProducer START_VALUE_INITIAL_PARAMETER =
            new SimpleWarningProducer("START_VALUE_INITIAL_PARAMETER", ProblemKind.COMPLIANCE,
                    "Variability of binding expression for attribute '%s' is "
                    + " initial parameter variability: %s");
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1253
     */
    public static final SimpleProblemProducer EXTERNAL_OBJECT_MISSING_BINDING_EXPRESSION =
            new SimpleErrorProducer("EXTERNAL_OBJECT_MISSING_BINDING_EXPRESSION", ProblemKind.SEMANTIC,
                    "The external object '%s' does not have a binding expression");
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1269
     */
    public void collectErrorsInFor(
            ASTNode iterChild, List<? extends CommonForIndex> indices, ErrorCheckType checkType) {
        // Do the checks on the for itself
        allChecks(checkType);
        
        // Check everything except iterChild once
        for (ASTNode ch : this)
            if (ch != iterChild)
                ch.collectErrors(checkType);
        
        // Check array bounds in iterChild for each index combination
        try {
            indices.getChild(0).collectErrorsForAllIndices(indices, 0, iterChild, checkType);
        } catch (ConstantEvaluationException e) {
            // Do "general" check if we are unable to determine the indices.
            // Will probably give incorrect errors. However this is better than
            // passing along errors and then crash!
            iterChild.collectErrors(checkType);
        }
    }
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1385
     */
    public static final SimpleProblemProducer NEGATIVE_SIZE_FILL =
        new SimpleErrorProducer("NEGATIVE_SIZE_FILL", ProblemKind.SEMANTIC, "The dimension arguments of the fill()"
                + " operator may not be negative");
    /**
     * @aspect SourceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:21
     */
    public void nameCheck(ErrorCheckType checkType) {}
    /**
     * @aspect SourceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:36
     */
    private static ErrorChecker NAME_CHECKERS = addErrorChecker(new ErrorChecker.NameChecker());
    /**
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:108
     */
    public static final SimpleProblemProducer NOT_IN_CONSTRAINING_TYPE =
            new SimpleWarningProducer("NOT_IN_CONSTRAINING_TYPE", ProblemKind.SEMANTIC, 
                    "Access to %s %s not recommended, it is not present in "
                    + "constraining type of declaration '%s'");
    /**
     * @aspect DuplicateComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:184
     */
    public static final SimpleProblemProducer UNABLE_TO_INFER_EQUALITY_FOR_DUPLICATES =
            new SimpleWarningProducer("UNABLE_TO_INFER_EQUALITY_FOR_DUPLICATES", ProblemKind.SEMANTIC,
                    "The component %s is declared multiple times and can not be verified to be identical to other declaration(s) with the same name.");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:30
     */
    public void typeCheck(ErrorCheckType checkType) {}
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:45
     */
    private static ErrorChecker TYPE_CHECKER = addErrorChecker(new ErrorChecker.TypeChecker());
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:47
     */
    public static final SimpleProblemProducer CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS =
            new SimpleErrorProducer("CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS", ProblemKind.SEMANTIC,
                    "In the declaration '%s', the declared class is not a subtype of the " + 
                    "constraining class,\n    because %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:51
     */
    public static final SimpleProblemProducer REPLACING_CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS =
            new SimpleErrorProducer("REPLACING_CLASS_NOT_SUBTYPE_OF_CONSTRAINING_CLASS", ProblemKind.SEMANTIC,
                    "In the declaration '%s', the replacing class is not a subtype of the " + 
                    "constraining class from the declaration '%s',\n    because %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:55
     */
    public static final SimpleProblemProducer PREV_REDECLARE_NOT_REPLACEABLE =
            new SimpleWarningProducer("PREV_REDECLARE_NOT_REPLACEABLE", ProblemKind.SEMANTIC,
                    "In the declaration '%s', %s can't be redeclared since it has already been " + 
                    "redeclared without 'replaceable'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:170
     */
    public static final SimpleProblemProducer CANNOT_INFER_ARRAY_SIZE_OF_VARIABLE =
            new SimpleErrorProducer("CANNOT_INFER_ARRAY_SIZE_OF_VARIABLE", ProblemKind.SEMANTIC,
                    "Can not infer array size of the variable %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:173
     */
    public static final SimpleProblemProducer CANNOT_INFER_ARRAY_SIZE_OF_FUNCTION_OUTPUT =
            new SimpleErrorProducer("CANNOT_INFER_ARRAY_SIZE_OF_FUNCTION_OUTPUT", ProblemKind.COMPLIANCE,
                    "Can not infer array size of the function output %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:176
     */
    public static final SimpleProblemProducer BINDING_EXPRESSION_TYPE_MISMATCH =
            new SimpleErrorProducer("BINDING_EXPRESSION_TYPE_MISMATCH", ProblemKind.SEMANTIC,
                    "The binding expression of the variable %s does not match the declared type of the variable");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:179
     */
    public static final SimpleProblemProducer ASSUMING_EACH =
            new SimpleWarningProducer("ASSUMING_EACH", ProblemKind.SEMANTIC, "Assuming 'each' for the modification '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:181
     */
    public static final SimpleProblemProducer IGNORING_EACH =
            new SimpleWarningProducer("IGNORING_EACH", ProblemKind.SEMANTIC, "Ignoring erroneous 'each' for the modification '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:183
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_DECLARATION =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_DECLARATION", ProblemKind.SEMANTIC,
                    "Array size mismatch in declaration of %s, size of declaration is %s and size of binding expression is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:186
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_MODIFICATION =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_MODIFICATION", ProblemKind.SEMANTIC,
                    "Array size mismatch in modification of %s, expected size is %s and size of binding expression is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:189
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_MODIFICATION_DUE_TO_EACH =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_MODIFICATION_DUE_TO_EACH", ProblemKind.SEMANTIC,
                    "Array size mismatch in modification of %s, expected size is (due to 'each') %s and size of binding expression is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:192
     */
    public static final SimpleProblemProducer NON_SCALAR_CONDITIONAL_GUARD =
            new SimpleErrorProducer("NON_SCALAR_CONDITIONAL_GUARD", ProblemKind.SEMANTIC,
                    "The guard expression of a conditional component should be a scalar expression");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:195
     */
    public static final SimpleProblemProducer NON_BOOLEAN_CONDITIONAL_GUARD =
            new SimpleErrorProducer("NON_BOOLEAN_CONDITIONAL_GUARD", ProblemKind.SEMANTIC,
                    "The guard expression of a conditional component should be a boolean expression");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:198
     */
    public static final SimpleProblemProducer NON_FIXED_CONDITIONAL_GUARD =
            new SimpleErrorProducer("NON_FIXED_CONDITIONAL_GUARD", ProblemKind.SEMANTIC,
                    "The guard expression of a conditional component should have parameter or constant variability");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:320
     */
    public static final SimpleProblemProducer TYPE_MISMATCH_IN_ATTRIBUTE_MODIFICATION =
            new SimpleErrorProducer("TYPE_MISMATCH_IN_ATTRIBUTE_MODIFICATION", ProblemKind.SEMANTIC,
                    "The type of the binding expression of the attribute %s for the %s %s does not match the declared type of the variable");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:323
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_ATTRIBUTE_MODIFICATION =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_ATTRIBUTE_MODIFICATION", ProblemKind.SEMANTIC,
                    "Array size mismatch in modification of the attribute %s for the %s %s, expected size is %s and size of %s expression is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:326
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_ATTRIBUTE_MODIFICATION_DUE_TO_EACH =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_ATTRIBUTE_MODIFICATION_DUE_TO_EACH", ProblemKind.SEMANTIC,
                    "Array size mismatch in modification of the attribute %s for the %s %s, expected size is (due to 'each') %s and size of %s expression is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:363
     */
    public static final SimpleProblemProducer NOMINAL_EQUAL_TO_ZERO =
            new SimpleErrorProducer("NOMINAL_EQUAL_TO_ZERO", ProblemKind.SEMANTIC,
                    "The attribute nominal for the %s %s is set to %s, evaluating to 0.0. A nominal value of zero is not meaningful. Please set the nominal value to the expected magnitude of the variable.");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:366
     */
    public static final SimpleProblemProducer NOMINAL_ELEMENT_EQUAL_TO_ZERO =
            new SimpleErrorProducer("NOMINAL_ELEMENT_EQUAL_TO_ZERO", ProblemKind.SEMANTIC,
                    "The attribute nominal for the %s %s is set to %s, where element %s evaluates to 0.0. A nominal value of zero is not meaningful. Please set the nominal value to the expected magnitude of the variable.");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:397
     */
    public static final SimpleProblemProducer EACH_APPLIED_ON_SCALAR =
            new SimpleWarningProducer("EACH_APPLIED_ON_SCALAR", ProblemKind.SEMANTIC,
                    "The 'each' keyword should not be applied to a modification of a scalar component: %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:412
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_EQUATION =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_EQUATION", ProblemKind.SEMANTIC,
                    "The array sizes of right and left hand side of equation are not compatible, size of left-hand side is %s, and size of right-hand side is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:415
     */
    public static final SimpleProblemProducer TYPE_MISMATCH_IN_EQUATION =
            new SimpleErrorProducer("TYPE_MISMATCH_IN_EQUATION", ProblemKind.SEMANTIC,
                    "The right and left expression types of equation are not compatible, type of left-hand side is %s, and type of right-hand side is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:435
     */
    public static final SimpleProblemProducer CONNECT_WITH_INVALID_TYPE =
            new SimpleErrorProducer("CONNECT_WITH_INVALID_TYPE", ProblemKind.SEMANTIC,
                    "Connecting to an instance of a non-connector type is not allowed");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:438
     */
    public static final SimpleProblemProducer CONNECT_EXPANDABLE_AND_NON_EXPANDABLE_TYPE =
            new SimpleErrorProducer("CONNECT_EXPANDABLE_AND_NON_EXPANDABLE_TYPE", ProblemKind.SEMANTIC,
                    "Connecting an expandable connector to a non-expandable connector is not allowed");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:441
     */
    public static final SimpleProblemProducer TYPE_MISMATCH_IN_CONNECT =
            new SimpleErrorProducer("TYPE_MISMATCH_IN_CONNECT", ProblemKind.SEMANTIC,
                    "Types of connected components do not match");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:444
     */
    public static final ErrorProducerUnlessDisabled ARRAY_SIZE_MISMATCH_IN_CONNECT =
            new ErrorProducerUnlessDisabled("ARRAY_SIZE_MISMATCH_IN_CONNECT", ProblemKind.SEMANTIC,
                    "Sizes do not match in connection, size of '%s' is %s and size of '%s' is %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:603
     */
    public static final ErrorProducerUnlessDisabled NON_PARAMETER_SIZE_IN_EXPRESSION =
            new ErrorProducerUnlessDisabled("NON_PARAMETER_SIZE_IN_EXPRESSION", ProblemKind.COMPLIANCE,
                    "Non-parameter expression sizes not supported, '%s', dimension %d in '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:643
     */
    public static final FExp.ExpTypeErrorProducer TYPE_MISMATCH_IN_EXPRESSION =
            new FExp.ExpTypeErrorProducer("TYPE_MISMATCH_IN_EXPRESSION", "Type error in expression");
    /**
     * The message to use in default type error.
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:675
     */
    public static final FExp.ExpTypeErrorProducer EQUALITY_COMPARISON_OF_REAL =
            new FExp.ExpTypeErrorProducer("EQUALITY_COMPARISON_OF_REALS", "Equality comparisons do not allow real operands");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:979
     */
    public Collection<FExpSubscript> collectSubscriptUses(String name) {
        Collection<FExpSubscript> nodes = new ArrayList<FExpSubscript>();
        collectSubscriptUses(name, nodes);
        return nodes;
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:985
     */
    public void collectSubscriptUses(String name, Collection<FExpSubscript> nodes) {
        for (ASTNode n : this) {
            n.collectSubscriptUses(name, nodes);
        }
    }
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1316
     */
    public static final SimpleProblemProducer DELAY_MAX_NOT_PARAMETER =
            new SimpleErrorProducer("DELAY_MAX_NOT_PARAMETER", ProblemKind.SEMANTIC,
                    "Calling function delay(): third argument must be of parameter variability: %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1319
     */
    public static final SimpleProblemProducer DELAY_NOT_PARAMETER =
            new SimpleErrorProducer("DELAY_NOT_PARAMETER", ProblemKind.SEMANTIC,
                    "Calling function delay(): second argument must be of parameter variability when third argument is not given: %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1322
     */
    public static final SimpleProblemProducer DELAY_OVER_MAX =
            new SimpleErrorProducer("DELAY_OVER_MAX", ProblemKind.SEMANTIC,
                    "Calling function delay(): second argument may not be larger than third argument: %s = %s > %s = %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1325
     */
    public static final SimpleProblemProducer DELAY_NEGATIVE =
            new SimpleErrorProducer("DELAY_NEGATIVE", ProblemKind.SEMANTIC,
                    "Calling function delay(): second argument may not be negative: %s = %s < 0");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1328
     */
    public static final SimpleProblemProducer DELAY_MAX_NEGATIVE =
            new SimpleErrorProducer("DELAY_MAX_NEGATIVE", ProblemKind.SEMANTIC,
                    "Calling function delay(): third argument may not be negative: %s = %s < 0");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1429
     */
    public static final SimpleProblemProducer CANNOT_INFER_ARRAY_SIZE_OF_OUTPUT =
            new SimpleErrorProducer("CANNOT_INFER_ARRAY_SIZE_OF_OUTPUT", ProblemKind.SEMANTIC,
                    "Could not evaluate array size of output %s");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1576
     */
    public static final SimpleProblemProducer ACCESS_TO_CLASS_THROUGH_COMPONENT = 
            new SimpleErrorProducer("ACCESS_TO_CLASS_THROUGH_COMPONENT", ProblemKind.SEMANTIC,
                    "Can not access non-function class through component access: '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1579
     */
    public static final SimpleProblemProducer ACCESS_TO_FUNCTION_THROUGH_MULTIPLE_COMPONENTS = 
            new SimpleErrorProducer("ACCESS_TO_FUNCTION_THROUGH_MULTIPLE_COMPONENTS", ProblemKind.SEMANTIC,
                    "Can not access function through component unless only the first part of the name is a component: '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1582
     */
    public static final SimpleProblemProducer ACCESS_TO_FUNCTION_THROUGH_ARRAY_COMPONENT = 
            new SimpleErrorProducer("ACCESS_TO_FUNCTION_THROUGH_ARRAY_COMPONENT", ProblemKind.SEMANTIC,
                    "Can not access function through array component access: '%s'");
    /**
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1805
     */
    protected static void typeCheckEnabled(ErrorCheckType checkType, FExp enabledExp, FType parentType, boolean eachSet) {
        enabledExp.collectErrors(checkType);
        if (checkType.checkTypes()) {
            if (!enabledExp.type().isBoolean() && !enabledExp.type().isUnknown()) {
                enabledExp.error("The type of the enabled expression is not boolean");
            } else if (!eachSet && !parentType.dimensionCompatible(enabledExp.type())) { 
                if (enabledExp.ndims() == 0) {
                    enabledExp.warning("Assuming 'each' for enabled expression");
                } else {
                    enabledExp.errorUnlessDisabledAnd(parentType.ndims() == enabledExp.ndims(), 
                            "Array size mismatch for the enabled attribute, " + 
                            "size of component declaration is %s and size of expression is %s", 
                            parentType.size(), enabledExp.size());
                }
            } else if (eachSet) { 
                if (parentType.ndims() == 0) {
                    enabledExp.warning("The 'each' keyword should not be applied to attributes of scalar components");
                } else if (enabledExp.ndims() > 0) {
                    enabledExp.error("The enabled attribute is declared 'each' and the expression is not scalar");
                }
            }
        }
    }
    /**
     * Check operations that are allowed on discrete expressions or variables, 
     * but not on continuous ones or vice-versa.
     * 
     * Also breaks connections back to instance tree that was added during flattening 
     * to be able to report these errors in the correct place.
     * @aspect VariabilityCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1865
     */
    public void checkDiscreteOperations() {
        for (ASTNode n : this)
            n.checkDiscreteOperations();
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:51
     */
    public void enableStreamsRewrite() {
        for (ASTNode n : this)
            n.enableStreamsRewrite();
    }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:111
     */
    public void enableExpandedInStreamRewrite() {
        for (ASTNode n : this)
            n.enableExpandedInStreamRewrite();
    }
    /**
     * Traverse tree and build connection sets and overconstranined connection graph from relevant constructs.
     * 
     * @param prefix   the prefix to use when flattening names
     * @param csm      the connection set manager to add variables to
     * @param connect  if false, then we are in a dead branch, and shouldn't change sets or graph
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1296
     */
    public void buildConnectionSets(FAccess prefix, ConnectionSetManager csm, boolean connect) {
		for (ASTNode n : this) 
			n.buildConnectionSets(prefix, csm, connect);
	}
    /**
     * Find functions, record and enumeration declarations that need to be flattened.
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:305
     */
    public void flattenUsedFuncsAndEnums(Flattener f) {
        for (ASTNode n : this) 
            n.flattenUsedFuncsAndEnums(f);
    }
    /**
     * Affix the given expression to the tree.
     * 
     * Where supported, adds it to dynamicFExp(), otherwise throws UnsupportedOperationException.
     * 
     * @return the expression, possibly rewritten
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1108
     */
    public FExp affixExpression(FExp exp) {
        throw new UnsupportedOperationException("Method affixExpression(FExp) not supported by class " + getClass().getSimpleName());
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1139
     */
    public void flatten(Flattener f, FlattenBindingExp binding, int level) {
        for (ASTNode n : this) {
            n.flatten(f, binding, level);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1264
     */
    public void flattenAssertExternal(Flattener f) {
        for (ASTNode n : this) {
            n.flattenAssertExternal(f);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1285
     */
    public String runtimeErrorString(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error ");
        errorLocation(sb);
        sb.append("': ");
        sb.append(msg);
        return sb.toString().replace("\\", "\\\\");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1294
     */
    public String errorLocation() {
        StringBuilder sb = new StringBuilder();
        errorLocation(sb);
        return sb.toString();
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1300
     */
    public void errorLocation(StringBuilder sb) {
        sb.append("at line ");
        sb.append(beginLineRecursive());
        sb.append(", column ");
        sb.append(beginColumnRecursive());
        sb.append(", in file '");
        sb.append(fileName());
        sb.append("'");
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1472
     */
    public String concatStringLit() {
        StringBuilder sb = new StringBuilder();
        concatStringLit(sb);
        return sb.toString();
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1478
     */
    public void concatStringLit(StringBuilder sb) {
        for(ASTNode child : children) {
            child.concatStringLit(sb);
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2122
     */
    public void collectAttributes(Flattener f,
            List<FAttribute> attrs, AttributeExpRetriever aer, boolean cls) {
        for (int i = 0; i < getNumChild(); i++)
            getChild(i).collectAttributes(f, attrs, aer, cls);
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2780
     */
    public void clearFlattened() {
        for (ASTNode n : noTransform()) {
            n.clearFlattened();
        }
    }
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2808
     */
    public static final SimpleProblemProducer CANNOT_EVALUATE_LOADRESOURCE =
            new SimpleErrorProducer("CANNOT_EVALUATE_LOADRESOURCE", ProblemKind.SEMANTIC,
                    "Could not evaluate function call which depends on loadResource during flattening: %s%s");
    /**
     * A list that contains all attribute contributers. New contributers are added
     * dynamically during static evaluation by calling addAttributeContributer().
     * 
     * @see ASTNode.addAttributeContributer()
     * @aspect AttributeContributer
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3438
     */
    private static Collection<AttributeContributer> ATTRIBUTE_CONTRIBUTES;
    /**
     * Add InstantiationContributer to the list of contributers. This method
     * should only be called from SrcAbstractEquation in order to ensure that the
     * checker is added corretly during static evaluation, hence the private
     * visibility.
     * @aspect AttributeContributer
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3446
     */
    private static AttributeContributer addAttributeContributer(AttributeContributer contributer) {
        if (ATTRIBUTE_CONTRIBUTES == null)
            ATTRIBUTE_CONTRIBUTES = new ArrayList<AttributeContributer>();
        ATTRIBUTE_CONTRIBUTES.add(contributer);
        return contributer;
    }
    /**
     * @aspect AttributeContributer
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:3453
     */
    public static Collection<AttributeContributer> attributeContributers() {
        return Collections.unmodifiableCollection(ATTRIBUTE_CONTRIBUTES);
    }
    /**
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:270
     */
    public void addForIndexRangeAsserts(Flattener f, List<FStatement> l) {
        for (ASTNode n : this) {
            n.addForIndexRangeAsserts(f, l);
        }
    }
    /**
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:20
     */
    protected static final InstLookupResult.DefaultGenerator<InstClassDecl> INST_UNKNOWN_CLASS = 
            new InstLookupResult.DefaultGenerator<InstClassDecl>() {
        public InstClassDecl generate(ASTNode src) {
            return src.unknownInstClassDecl();
        }
    };
    /**
     * @aspect InstLookupClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:603
     */
    protected static final InstLookupResult.DefaultGenerator<InstCallable> INST_UNKNOWN_CALLABLE = 
            new InstLookupResult.DefaultGenerator<InstCallable>() {
        public InstCallable generate(ASTNode src) {
            return src.unknownInstClassDecl();
        }
    };
    /**
     * @aspect InstLookupComponents
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:310
     */
    protected static final InstLookupResult.DefaultGenerator<InstComponentDecl> INST_UNKNOWN_COMPONENT = 
            new InstLookupResult.DefaultGenerator<InstComponentDecl>() {
        public InstComponentDecl generate(ASTNode src) {
            return src.unknownInstComponentDecl();
        }
    };
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2375
     */
    

        protected static class AllInstComponentIterable implements Iterable<InstComponentDecl> {

            private AllInstComponentSource src;

            public AllInstComponentIterable(AllInstComponentSource src) {
                this.src = src;
            }

            public Iterator<InstComponentDecl> iterator() {
                return new AllInstComponentIterator(src);
            }

        }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2389
     */
    

        protected static class AllInstClassIterable implements Iterable<InstClassDecl> {

            private AllInstClassSource src;

            public AllInstClassIterable(AllInstClassSource src) {
                this.src = src;
            }

            public Iterator<InstClassDecl> iterator() {
                return new AllInstClassIterator(src);
            }

        }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2403
     */
    

        protected static class AllInstComponentIterator extends AllInstNodeIterator<InstComponentDecl> {

            public AllInstComponentIterator(AllInstComponentSource src) {
                super(src.getInstExtendss(), src.getInstComponentDecls());
            }

            protected Iterator<InstComponentDecl> subIterator(InstExtends ie) {
                return ie.allInstComponentDeclsIterator();
            }

        }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2415
     */
    

        protected static class AllInstClassIterator extends AllInstNodeIterator<InstClassDecl> {

            public AllInstClassIterator(AllInstClassSource src) {
                super(src.getInstExtendss(), src.getInstClassDecls());
            }

            protected Iterator<InstClassDecl> subIterator(InstExtends ie) {
                return ie.allInstClassDeclsIterator();
            }

        }
    /**
     * @aspect InstanceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2427
     */
    

        private static abstract class AllInstNodeIterator<T extends InstNode> implements Iterator<T> {

            private Iterator<T> current;
            private Iterator<InstExtends> exts;
            private Iterator<T> last;

            public AllInstNodeIterator(List<InstExtends> extList, List<T> lastList) {
                exts = extList.iterator();
                last = lastList.iterator();
                if (exts.hasNext()) {
                    current = subIterator(exts.next());
                } else {
                    current = last;
                }
                update();
            }

            protected abstract Iterator<T> subIterator(InstExtends ie);

            public boolean hasNext() {
                return current.hasNext();
            }

            public T next() {
                T res = current.next();
                update();
                return res;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            private void update() {
                while (!current.hasNext() && exts.hasNext()) {
                    current = subIterator(exts.next());
                }
                if (!current.hasNext()) {
                    current = last;
                }
            }

        }
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2508
     */
    
        protected static final Criteria<ASTNode> NOT_ERROR_NODE_CRITERIA = new Criteria<ASTNode>() {
            public boolean test(ASTNode elem) {
                return !elem.isError();
            }
        };
    /**
     * @aspect SourceAST_API
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2514
     */
    
    
        public static <N extends ASTNode> Iterable<N> filterErrorNodes(final Iterable<N> parent) {
            return new Iterable<N>() {
                public Iterator<N> iterator() {
                    return new FilteredIterator<N>(parent.iterator(), NOT_ERROR_NODE_CRITERIA);
                }
            };
        }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:171
     */
    public static final LibraryContentErrorProducer LIBRARY_FILE_CONTENTS = 
            new LibraryContentErrorProducer();
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:175
     */
    
        public static class LibraryContentErrorProducer extends ProblemProducer<SrcLibNode> {
            private static final String BASE_MSG = 
                    "Class '%s' must be alone at top level of library file, but the file %s.";

            public LibraryContentErrorProducer() {
                super("LIBRARY_FILE_CONTENTS", ProblemKind.SEMANTIC);
            }

            public void invoke(SrcLibNode src, SrcStoredDefinition sd) {
                String name = src.name();
                invoke(src, severity(sd, name), BASE_MSG, name, detailMsg(sd, name));
            }

            private String detailMsg(SrcStoredDefinition sd, String name) {
                if (sd == null) {
                   return "was empty";
                } else {
                    int correct = 0;
                    ArrayList<String> wrong = new ArrayList<String>();
                    for (SrcClassDecl cd : sd.getSrcClassDecls()) {
                        String n = cd.name();
                        if (n.equals(name)) {
                            correct++;
                        } else {
                            wrong.add(n);
                        }
                    }
                    
                    StringBuilder buf = new StringBuilder();
                    if (correct == 1 && !wrong.isEmpty()) {
                        buf.append("also ");
                    }
                    buf.append("contains");
                    if (correct > 1) {
                        buf.append(' ');
                        buf.append(correct);
                        buf.append(" classes of that name");
                        if (!wrong.isEmpty()) {
                            buf.append(", and also");
                        }
                    }
                    for (int i = 0, n = wrong.size(); i < n; i++) {
                        if (i > 0) {
                            buf.append((i < n - 1) ? "," : " and");
                        }
                        buf.append(" '");
                        buf.append(wrong.get(i));
                        buf.append("'");
                    }
                    if (correct == 0) {
                        buf.append(" instead");
                    }
                    return buf.toString();
                }
            }

            public ProblemSeverity severity(SrcStoredDefinition sd, String name) {
                // If the class simply has the wrong case, give a warning instead
                boolean warn = sd != null && sd.getNumSrcClassDecl() == 1 && 
                        sd.getSrcClassDecl(0).name().equalsIgnoreCase(name);
                return warn ? ProblemSeverity.WARNING : ProblemSeverity.ERROR;
            }

            @Override
            public String description() {
                return "Library file contains wrong class(es).";
            }

            @Override
            public ProblemSeverity severity() {
                return null;
            }
        }
    /**
     * @aspect Parsers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Parser.jrag:26
     */
    public int adjustStartOfEmptySymbols(AdjustableSymbol[] syms, int i, int last) {
        int value = last;
        if (i < syms.length) {
            value = syms[i].adjustStartOfEmptySymbols(syms, i + 1, last);
        }
        if (start == end && value != 0) {
            start = end = value;
        }
        return start;
    }
    /**
     * @aspect Parsers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Parser.jrag:316
     */
    public static final Charset UTF8 = Charset.forName("UTF-8");
    /**
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:132
     */
    public ResolvedAccess createResolvedAccess(SrcClassDecl decl, String context) {
        return new ClassAccess(decl, unknownComponentDecl(), context, decl.isProtected());
    }
    /**
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:135
     */
    public ResolvedAccess createResolvedAccess(SrcComponentDecl decl, String context) {
        return new ComponentAccess(unknownClassDecl(), decl, context, decl.isProtected());
    }
    /**
     * Convenience method for looking up a class in a list of SrcClassDecls.
     * Has to be an unqualified classname.
     * This method returns null when the class isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:538
     */
    public ResolvedAccess simpleLookupInClassList(Iterable<? extends SrcClassDecl> list, String name, String enclosingClass) {
        for (SrcClassDecl cd : list) {
            if (cd.matches(name)) {
                return createResolvedAccess(cd, enclosingClass);
            }
        }
        return unknownAccess();
    }
    /**
     * Convenience method for looking up a component in a list of SrcComponentDecls.
     * Has to be an unqualified name.
     * This method returns null when the component isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:552
     */
    public ResolvedAccess simpleLookupInComponentList(Iterable<? extends SrcComponentDecl> list,
            String name, String enclosingElement) {
        for (SrcComponentDecl cd : list) {
            if (cd.matches(name)) {
                return createResolvedAccess(cd, enclosingElement);
            }
        }
        return unknownAccess();
    }
    /**
     * Convenience method for looking up a class in the given list of SrcLibNodes.
     * Has to be an unqualified classname.
     * This method returns null when the class isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:567
     */
    public ResolvedAccess simpleLookupInLibNodeList(List<SrcLibNode> list, String name) {
        for (SrcLibNode ln : list) {
            if (ln.matches(name)) {
                return createResolvedAccess((SrcClassDecl) ln, null);
            }
        }
        return unknownAccess();
    }
    /**
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:661
     */
    public void testFindConstant(StringBuilder sb) {
        for (ASTNode child : this) {
            child.testFindConstant(sb);
        }
    }
    /**
     * Helper method for myStringComment() methods. 
     * Selects the first found among the arguments.
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:256
     */
    protected static SrcStringComment selectStringComment(StringCommentSource... sources) {
        for (StringCommentSource src : sources) {
            if (src != null && src.hasSrcStringComment()) {
                return src.getSrcStringComment();
            }
        }
        return null;
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:177
     */
    public void collectExps(ArrayList<SrcExp> list) {
        for (ASTNode node : this) {
            node.collectExps(list);
        }
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:186
     */
    public void addAnnotationToEvaluator(ArrayList<AnnotationNode> list, InstNode evaluator) {}
    /**
     * @aspect Options
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Options.jrag:21
     */
    public OptionRegistry myOptions() {
        return root().getUtilInterface().getOptionRegistry();
    }
    /**
     * A helper method for AST cleanup used by removeMe(). Should not be used independent of removeMe().
     * Replaces empty list or optional with singleton and returns the parent or simply return the caller.
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:234
     */
    protected ASTNode cleanUpAfterRemove() {
        return this;
    }
    /**
     * Remove this ASTNode from the AST.
     * 
     * The ASTNode is removed and the AST state is then cleaned up using cleanUpAfterRemove.
     * This means that a parent empty list or optional will be replaced with a singleton.
     * 
     * @return The closest parent which is not a empty list node or optional node. 
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:271
     */
    public ASTNode removeMe() {
        ASTNode parent = getParent();
        if (parent != null) {
            parent.removeChild(parent.getIndexOfChild(this));
            return parent.cleanUpAfterRemove();
        }
        return this;
    }
    /**
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:54
     */
    public static String JMODELICA_VENDOR_NAME = "JModelica.org";
    /**
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:55
     */
    public static String vendorName() {
        return ASTNode.JMODELICA_VENDOR_NAME;
    }
    /**
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:68
     */
    public static final ArrayList EMPTY_ARRAY_LIST = new ArrayList(0);
    /**
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:71
     */
    public boolean hasRoot() { return (getParent() == null) ? false : getParent().hasRoot(); }
    /**
     * @aspect Logging
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:78
     */
    public static ModelicaLogger log = ModelicaCompiler.log;
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:88
     */
    
        @Override
        public Iterator<T> iterator() {
            return astChildIterator();
        }
    /**
     * Copies the member variables defining the location within 
     * the source to another node.
     * 
     * @param n  the node to copy the location to
     * @return   the node given as <code>n</code>, for convenience
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:102
     */
    
        /**
         * Copies the member variables defining the location within 
         *        the source to another node.
         *        
         * @param n  the node to copy the location to
         * @return   the node given as <code>n</code>, for convenience
         */
        public <N extends ASTNode> N copyLocationTo(N n) {
      	    n.setLocation(this, this);
            return n;
        }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied another node.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:112
     */
    public void setLocation(ASTNode node) {
  	    setLocation(node, node);
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied from two other nodes.
     * 
     * @param start  the node to copy the <code>start</code> member from.
     * @param end    the node to copy the <code>end</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:123
     */
    public void setLocation(ASTNode start, ASTNode end) {
        this.start = start.start;
        this.end = end.end;
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied another node, that might not be in a 
     * proper AST.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:146
     */
    public void setLocationNoTree(ASTNode node) {
  	    setLocationNoTree(node, node);
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied from two other nodes, that might not be 
     * in a proper AST.
     * 
     * @param start  the node to copy the <code>start</code> member from.
     * @param end    the node to copy the <code>end</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:158
     */
    public void setLocationNoTree(ASTNode start, ASTNode end) {
        setLocation(start, end);
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied from two other parser symbols, 
     * that might not be AST nodes.
     * 
     * @param start  the node to copy the <code>start</code> member from.
     * @param end    the node to copy the <code>end</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:170
     */
    public void setLocationNoTree(Symbol start, Symbol end) {
        this.start = start.getStart();
        this.end = end.getEnd();
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:202
     */
    protected <T extends ASTNode> T setLocationOf(T node) {
        node.setLocationNoTree(this);
        return node;
    }
    /**
     * Return a copy of node that is not in any tree.
     * 
     * Returns <code>this</code> if node has no parent, <code>fullCopy()</code> otherwise.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:439
     */
    public ASTNode unboundCopy() {
        return (parent == null) ? this : fullCopy();
    }
    /**
     * Check if this node is a direct child (only List/Opt between) of <code>parent</code>.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:446
     */
    public boolean isChildOf(BaseNode parent) {
        ASTNode par = getParent();
        return par != null && par.isChildOfHelper(parent);
    }
    /**
     * Helper method for {@link #isChildOf(BaseNode parent)}, should not be called directly.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:454
     */
    protected boolean isChildOfHelper(BaseNode parent) {
        return isChildOf(parent);
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:502
     */
    
        
        protected class ChildTypedIterable<S extends ASTNode<?>> implements Iterable<S> {
            private Class<S> type;
            
            public ChildTypedIterable(Class<S> type) {
                this.type = type;
            }
            
            public Iterator<S> iterator() {
                return new ChildTypedIterator(type);
            }
        }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:515
     */
    
        
        
        private class ChildTypedIterator<S extends ASTNode<?>> implements Iterator<S> {
            
            private Iterator<T> it1;
            private Iterator<ASTNode> it2;
            private S next = null;
            private Class<S> type;
            
            public ChildTypedIterator(Class<S> type) {
                this.type = type;
                it1 = iterator();
                it2 = null;
                update();
            }
            
            private void update() {
                boolean cont = true;
                ASTNode node = null;
                while (cont) {
                    node = null;
                    if (it2 == null) {
                        if (it1.hasNext())
                            node = it1.next();
                        else 
                            cont = false;
                        if (node instanceof List || node instanceof Opt)
                            it2 = node.iterator();
                    } else {
                        if (it2.hasNext()) 
                            node = it2.next();
                        else 
                            it2 = null;
                    }
                    if (type.isInstance(node)) 
                        cont = false;
                }
                next = (S) node;
            }

            public boolean hasNext() {
                return next != null;
            }

            public S next() {
                S res = next;
                update();
                return res;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
            
        }
    /**
     * Returns the intersection of two sets.
     * 
     * @param a
     * A set.
     * @param b
     * A set.
     * @return
     * A set containing elements that exist in both {@code a} and {@code b}.
     * @aspect Utility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:592
     */
    
        /**
         * Returns the intersection of two sets.
         * 
         * @param a
         *          A set.
         * @param b
         *          A set.
         * @return
         *          A set containing elements that exist in both {@code a} and {@code b}.
         */
        public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
            // TODO: use runtime type of a instead - problematic if it is something like HashMap.KeySet.
            Set<T> res = new HashSet<T>();
            res.addAll(a);
            res.retainAll(b);
            return res;
        }
    /**
     * Short-hand method for sorting a collection.
     * 
     * @param elems
     * The elements to sort.
     * @param cmp
     * The {@link Comparator} to use when calculating the ordering of {@code elems}.
     * @aspect Utility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:608
     */
    

        /**
         * Short-hand method for sorting a collection.
         * 
         * @param elems
         *          The elements to sort.
         * @param cmp
         *          The {@link Comparator} to use when calculating the ordering of {@code elems}.
         */
        public static <T> ArrayList<T> toSortedList(Collection<T> elems, Comparator<? super T> cmp) {
            ArrayList<T> res = new ArrayList<T>(elems.size());
            res.addAll(elems);
            Collections.sort(res, cmp);
            return res;
        }
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:650
     */
    public Object fileNames() {
    	return fileName();
    }
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:655
     */
    public String fileName() { 
    	return retrieveFileName(); 
    }
    /**
     * Compose a dotted name of two components.
     * 
     * Each component can be a dotted name, a single name or empty.
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:801
     */
    public static String combineName(String first, String second) {
        if (first.isEmpty())
            return second;
        if (second.isEmpty())
            return first;
        return first + "." + second;
    }
    /**
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:881
     */
    public String resolveURI(String str) throws URIException {
        return URIResolver.DEFAULT.resolveURIChecked(this, str);
    }
    /**
     * Convert to string. Primarily useful for debugging.
     * 
     * Default implementation uses prettyPrint().
     * @aspect DebugHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1179
     */
    public String toString() {
        return prettyPrint("");
    }
    /**
     * Searches <code>set</code> for a node that returns <code>true</code> for 
     * <code>node.matches(str)</code>.
     * 
     * @param set  the container to search for a matching node
     * @param str  the string to match nodes to
     * @return     a matching node if one is found, <code>null</code> otherwise
     * @aspect NodeSearch
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1713
     */
    
        
        /**
         * Searches <code>set</code> for a node that returns <code>true</code> for 
         * <code>node.matches(str)</code>.
         * 
         * @param set  the container to search for a matching node
         * @param str  the string to match nodes to
         * @return     a matching node if one is found, <code>null</code> otherwise
         */
        public static <T extends ASTNode> T findMatching(Iterable<T> set, String str) {
            for (T node : set) 
                if (node.matches(str)) 
                    return node;
            return null;
        }
    /**
     * Replace all escape sequences with their actual meaning.
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1742
     */
    public static String unEscape(String str) {
        return patternedReplace(str, UN_ESCAPE_PATTERN, unEscapeReplacements());
    }
    /**
     * Replace all characters that should be escaped in a Modelica String with 
     * their escape sequences.
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1750
     */
    public static String escape(String str) {
        return patternedReplace(str, ESCAPE_PATTERN, escapeReplacements());
    }
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1754
     */
    private static final Pattern UN_ESCAPE_PATTERN = Pattern.compile("\\\\(.)");
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1756
     */
    private static Map<String,String> unEscapeReplacements() {
        if (UN_ESCAPE_REPLACEMENTS == null) {
            UN_ESCAPE_REPLACEMENTS = new HashMap<String,String>();
            UN_ESCAPE_REPLACEMENTS.put("'", "'");
            UN_ESCAPE_REPLACEMENTS.put("\"", "\"");
            UN_ESCAPE_REPLACEMENTS.put("?", "?");
            UN_ESCAPE_REPLACEMENTS.put("\\", Matcher.quoteReplacement("\\"));
            UN_ESCAPE_REPLACEMENTS.put("a", "\007");
            UN_ESCAPE_REPLACEMENTS.put("b", "\b");
            UN_ESCAPE_REPLACEMENTS.put("f", "\f");
            UN_ESCAPE_REPLACEMENTS.put("n", "\n");
            UN_ESCAPE_REPLACEMENTS.put("r", "\r");
            UN_ESCAPE_REPLACEMENTS.put("v", "\013");
            UN_ESCAPE_REPLACEMENTS.put("t", "\t");
        }
        return UN_ESCAPE_REPLACEMENTS;
    }
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1774
     */
    private static Map<String,String> UN_ESCAPE_REPLACEMENTS = null;
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1776
     */
    private static final Pattern ESCAPE_PATTERN = 
            Pattern.compile("([\"'\\\\\007\b\f\n\r\013\t])");
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1779
     */
    private static Map<String,String> escapeReplacements() {
        if (ESCAPE_REPLACEMENTS == null) {
            ESCAPE_REPLACEMENTS = new HashMap<String,String>();
            ESCAPE_REPLACEMENTS.put("'",    Matcher.quoteReplacement("\\'"));
            ESCAPE_REPLACEMENTS.put("\"",   Matcher.quoteReplacement("\\\""));
            ESCAPE_REPLACEMENTS.put("\\",   Matcher.quoteReplacement("\\\\"));
            ESCAPE_REPLACEMENTS.put("\007", Matcher.quoteReplacement("\\a"));
            ESCAPE_REPLACEMENTS.put("\b",   Matcher.quoteReplacement("\\b"));
            ESCAPE_REPLACEMENTS.put("\f",   Matcher.quoteReplacement("\\f"));
            ESCAPE_REPLACEMENTS.put("\n",   Matcher.quoteReplacement("\\n"));
            ESCAPE_REPLACEMENTS.put("\r",   Matcher.quoteReplacement("\\r"));
            ESCAPE_REPLACEMENTS.put("\013", Matcher.quoteReplacement("\\v"));
            ESCAPE_REPLACEMENTS.put("\t",   Matcher.quoteReplacement("\\t"));
        }
        return ESCAPE_REPLACEMENTS;
    }
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1796
     */
    private static Map<String,String> ESCAPE_REPLACEMENTS = null;
    /**
     * @aspect Strings
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1798
     */
    private static String patternedReplace(
            String str, Pattern pattern, Map<String,String> repl) {
        StringBuffer buf = new StringBuffer();
        Matcher m = pattern.matcher(str);
        while (m.find())
            m.appendReplacement(buf, repl.get(m.group(1)));
        m.appendTail(buf);
        return buf.toString();
    }
    /**
     * @aspect Sorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1840
     */
    public static final Comparator<ASTNode> CHILD_ORDER_COMPARATOR =
		    new Comparator<ASTNode>() {
				public int compare(ASTNode n1, ASTNode n2) {
			    	return childIndex(n1) - childIndex(n2);
			    }
				
				private int childIndex(ASTNode n) {
					return (n.parent == null) ? 0 : n.parent.getIndexOfChild(n);
				}
			    
				public boolean equals(Object obj) { 
			    	return obj == this; 
			    }
			};
    /**
     * @aspect Sorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1855
     */
    public static final Comparator<ASTNode> TOSTRING_COMPARATOR =
		    new Comparator<ASTNode>() {
				public int compare(ASTNode n1, ASTNode n2) {
			    	return n1.toString().compareTo(n2.toString());
			    }
			    
				public boolean equals(Object obj) { 
			    	return obj == this; 
			    }
			};
    /**
     * Used to iterate over the children of an AST node without triggering rewrites.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1889
     */
    
		
		/**
		 * Used to iterate over the children of an AST node without triggering rewrites.
		 */
		public Iterable<T> noTransform() { 
			return new Iterable<T>() {
				public Iterator<T> iterator() {
					return new NoTransformIterator();
				}
			};
		}
    /**
     * Used to iterate over the children of an AST node without triggering rewrites.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1900
     */
    
		
		/**
		 * Used to iterate over the children of an AST node without triggering rewrites.
		 */
		public class NoTransformIterator implements Iterator<T> {
			
			private int i = 0;
			private int n = getNumChildNoTransform();
			
			public boolean hasNext() {
				return i < n;
			}
			
			public T next() {
				return getChildNoTransform(i++);
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		}
    /**
     * Adds all children to a Collection.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1924
     */
    public void addAllTo(Collection<? super T> col) {
        for (T n : this) {
            col.add(n);
        }
    }
    /**
     * Create an array list with all children.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1933
     */
    public ArrayList<T> createArrayList() {
        ArrayList<T> res = new ArrayList<>(getNumChild());
        addAllTo(res);
        return res;
     }
    /**
     * Round a number to 2 decimals if it is < 10, 1 decimal otherwise.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1951
     */
    public static double roundFriendly(double val) {
		double round = val < 10.0 ? 100.0 : 10.0;
		return Math.round(val * round) / round;
	}
    /**
     * Create a human-readable memory size string (e.g. 2.34 kB).
     * 
     * @param mem  size to format, in bytes. May be negative.
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1961
     */
    public static String formatMem(long mem) {
		int i = 0;
		double scaledMem = Math.abs(mem);
		for (; i < 4 && scaledMem >= 1000.0; i++)
			scaledMem /= 1024.0;
		StringBuilder buf = new StringBuilder();
		if (i == 0) {
			buf.append(mem);
		} else {
			if (mem < 0)
				buf.append('-');
			buf.append(roundFriendly(scaledMem));
		}
		buf.append(memUnits[i]);
		return buf.toString();
	}
    /**
     * Parse a human-readable memory size string (e.g. 2.34 kB).
     * 
     * @param str  string to parse
     * @return  the amount of memory described by the string
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1984
     */
    public static long parseMem(String str) {
		Matcher m = memPattern.matcher(str);
		if (m.matches()) {
			double val = Double.parseDouble(m.group(1));
			String suff = m.group(4);
			if (suff != null && !suff.isEmpty()) {
				char sc = Character.toLowerCase(suff.charAt(0));
				for (int i = 0; i < memUnits.length && Character.toLowerCase(memUnits[i].charAt(1)) != sc; i++)
					val *= 1024.0;
			}
			if (val < Long.MAX_VALUE && val > Long.MIN_VALUE)
				return (long) val;
		}
		throw new IllegalArgumentException(str);
	}
    /**
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:2000
     */
    private static final String[] memUnits = { 
		" B", " kB", " MB", " GB", " TB" , " PB" , " EB" };
    /**
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:2002
     */
    private static final Pattern memPattern = 
			Pattern.compile("([0-9]+(\\.[0-9]*)?)(([kKmMgGtTpPeE])?[bB]?)?");
    /**
     * Mark all referenced globals as used.
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:125
     */
    public final void markUsedGlobals() {
        markUsedGlobals(Global.UseType.DIRECT);
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:128
     */
    public void markUsedGlobals(Global.UseType type) {
        for (ASTNode node : this)
            node.markUsedGlobals(type);
    }
    /**
     * @aspect LoadResource
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\LoadResource.jrag:38
     */
    void collectResourcesToLoad(LinkedHashSet<String> list) {
        for (ASTNode n : this)
            n.collectResourcesToLoad(list);
    }
    /**
     * @aspect LightProfiling
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:36
     */
    private static StepInfo stepInfo = new StepInfo();
    /**
     * @aspect LightProfiling
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:38
     */
    public static StepInfo getStepInfo() {
		return stepInfo;
	}
    /**
     * @aspect LightProfiling
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:42
     */
    public static void beginStep(String name) {
		stepInfo.begin(name);
	}
    /**
     * @aspect LightProfiling
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:46
     */
    public static void endStep(String name) {
		stepInfo.end(name);
	}
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:385
     */
    public Iterable<ASTNode> profilingChildren() {
        LinkedHashSet<ASTNode> res = new LinkedHashSet<ASTNode>(children != null ? children.length * 2 : 4);
        if (children != null)
            for (ASTNode ch : children)
                if (ch != null && ch.parent == this)
                    res.add(ch);
        for (Field f : Profiler.GET_FIELDS.perform(getClass())) {
            if ((f.getModifiers() & Modifier.STATIC) == 0 && ASTNode.class.isAssignableFrom(f.getType())) {
                try {
                    ASTNode val = (ASTNode) Profiler.GET_VALUE.perform(f, this);
                    if (val != null && val.parent == this)
                        res.add(val);
                } catch (Exception e) {}
            }
        }
        return res;
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:403
     */
    private static Map<Class,Counter> buildNodeCountMap = null;
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:405
     */
    private static NodeCountExtra[] nodeCountExtra = new NodeCountExtra[] { };
    /**
     * Output a list of the number of instances of each node class.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:415
     */
    public static void dumpNodeCount(String file) 
            throws IOException {
        ArrayList<Counter> list = new ArrayList<Counter>();
        list.addAll(buildNodeCountMap.values());
        Collections.sort(list);
        CodeStream out = new CodeStream(file);
        for (Counter c : list)
            out.println(c);
        for (NodeCountExtra nce : nodeCountExtra)
            nce.printResult(out);
        out.close();
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:428
     */
    public void buildNodeCount() {
        Profiler.clear();
        if (buildNodeCountMap == null)
            buildNodeCountMap = new HashMap<Class,Counter>();
        buildNodeCount(buildNodeCountMap);
        Profiler.clear();
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:436
     */
    private void buildNodeCount(Map<Class,Counter> map) {
        addToNodeCount(map, getClass(), Profiler.getNodeSize(this, false), Profiler.getNodeSize(this, true));
        for (NodeCountExtra nce : nodeCountExtra)
            nce.count(this);
        
        for (ASTNode n : profilingChildren())
            n.buildNodeCount(map);
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:445
     */
    private void addToNodeCount(Map<Class,Counter> map, Class cls, long local, long deep) {
        if (map.containsKey(cls))
            map.get(cls).inc(local, deep);
        else
            map.put(cls, new Counter(cls.getSimpleName(), local, deep));
        if (cls != ASTNode.class)
            addToNodeCount(map, cls.getSuperclass(), local, deep);
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:455
     */
    
        public static class Counter implements Comparable<Counter> {
            private int n;
            private long sizeLocal;
            private long sizeDeep;
            private String s;
            
            private static int l = 0;
            private static String fmt = null;
            
            public Counter(String name, long local, long deep) {
                s = name;
                sizeLocal = 0;
                sizeDeep = 0;
                n = 0;
                if (s.length() > l)
                    l = s.length();
                inc(local, deep);
            }
            
            public void inc(long local, long deep) {
                n++;
                sizeLocal += local;
                sizeDeep += deep;
            }
            
            public int compareTo(Counter c) {
                return c.n - n;
            }
            
            public String toString() {
                if (fmt == null)
                    fmt = "%-" + l + "s : %9d (%8s / %8s)";
                return String.format(fmt, s, n, ASTNode.formatMem(sizeDeep), ASTNode.formatMem(sizeLocal));
            }
        }
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * As {@link #dumpMemoryUse(PrintStream, boolean, int, long)}, with <code>deep = false</code>, 
     * <code>maxDepth = -1</code>, <code>minSize = 0</code>, and saving the output to a file.
     * 
     * @param file     filename to save output as
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:501
     */
    public void dumpMemoryUse(String file) throws FileNotFoundException {
		dumpMemoryUse(file, false);
	}
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * As {@link #dumpMemoryUse(PrintStream, boolean, int, long)}, with <code>maxDepth = -1</code>, 
     * <code>minSize = 0</code>, and saving the output to a file.
     * 
     * @param file     filename to save output as
     * @param deep     if the memory calculation should include the contents of non-ASTNode members
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:515
     */
    public void dumpMemoryUse(String file, boolean deep) throws FileNotFoundException {
		dumpMemoryUse(file, deep, -1, 0);
	}
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * As {@link #dumpMemoryUse(PrintStream, boolean, int, long)}, but saving the output to a file.
     * 
     * @param file     filename to save output as
     * @param deep     if the memory calculation should include the contents of non-ASTNode members
     * @param maxDepth the maximum depth to display nodes from, -1 means infinite depth
     * @param minSize  the minimum memory size to display a node
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:530
     */
    public void dumpMemoryUse(String file, boolean deep, int maxDepth, long minSize) 
			throws FileNotFoundException {
		dumpMemoryUse(new PrintStream(file), deep, maxDepth, minSize);
	}
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * As {@link #dumpMemoryUse(PrintStream, boolean, int, long)}, with <code>deep = false</code>, 
     * <code>maxDepth = -1</code> and <code>minSize = 0</code>.
     * 
     * @param out      stream to use for output
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:545
     */
    public void dumpMemoryUse(PrintStream out) {
		dumpMemoryUse(out, false, -1, 0);
	}
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * As {@link #dumpMemoryUse(PrintStream, boolean, int, long)}, with <code>maxDepth = -1</code> and 
     * <code>minSize = 0</code>.
     * 
     * @param out      stream to use for output
     * @param deep     if the memory calculation should include the contents of non-ASTNode members
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:559
     */
    public void dumpMemoryUse(PrintStream out, boolean deep) {
		dumpMemoryUse(out, deep, -1, 0);
	}
    /**
     * Output a view of an AST, showing the classname and approximate memory footprint 
     * of the subtree.
     * 
     * @param out      stream to use for output
     * @param deep     if the memory calculation should include the contents of non-ASTNode members
     * @param maxDepth the maximum depth to display nodes from, -1 means infinite depth
     * @param minSize  the minimum memory size to display a node
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:572
     */
    public void dumpMemoryUse(PrintStream out, boolean deep, int maxDepth, long minSize) {
		Profiler.clear();   // Remove any stale data from profiler
		gatherMemoryUse(out, "", deep, maxDepth, minSize, 0);
		Profiler.clear();   // Free any memory used by the profiler's cache
	}
    /**
     * Calculate the memory weight of a subtree.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:581
     */
    public long subTreeSize() {
		Profiler.clear();   // Remove any stale data from profiler
		long res = subTreeSizeNoClear();
		Profiler.clear();   // Free any memory used by the profiler's cache
		return res;
	}
    /**
     * Calculate the memory weight of a subtree, without clearing cache.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:591
     */
    private long subTreeSizeNoClear() {
		return gatherMemoryUse(NullStream.PRINT, "", true, 0, 0, 1);
	}
    /**
     * Calclulate memory weight of all subtrees fulfilling a specific criteria.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:598
     */
    public long filteredTreeSize(Criteria<ASTNode> filter) {
		Profiler.clear();   // Remove any stale data from profiler
		long res = filteredTreeSizeNoClear(filter);
		Profiler.clear();   // Free any memory used by the profiler's cache
		return res;
	}
    /**
     * Calclulate memory weight of all subtrees fulfilling a specific criteria, without clearing cache.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:608
     */
    private long filteredTreeSizeNoClear(Criteria<ASTNode> filter) {
        if (filter.test(this)) {
            return subTreeSizeNoClear();
        } else {
            long res = 0;
            for (ASTNode ch : profilingChildren()) 
                res += ch.filteredTreeSizeNoClear(filter);
            return res;
        }
    }
    /**
     * Calculate total memory weight of all nodes (including subtrees) of a specific class.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:622
     */
    public long specificNodeClassTreeSize(String name) {
		try {
			final Class cls = Class.forName(ASTNode.class.getName().replace("ASTNode", name));
			return filteredTreeSize(new ClassCriteria<ASTNode>(cls));
		} catch (ClassNotFoundException e) {
			return -1;
		}
	}
    /**
     * Traversal method for {@link #dumpMemoryUse(PrintStream, boolean, int, long)}.
     * 
     * @return approximation of the memory footprint for the subtree
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:636
     */
    protected long gatherMemoryUse(
            PrintStream out, String indent, boolean deep, int maxDepth, long minSize, int depth) {
        long local = Profiler.getNodeSize(this, deep);
        long mem = local;
        String nextInd = indent + " ";
        for (ASTNode ch : profilingChildren())
            mem += ch.gatherMemoryUse(out, nextInd, deep, maxDepth, minSize, depth+1);
        if ((depth == 0 || mem >= minSize) && (maxDepth < 0 || depth < maxDepth))
            addMemoryUseRow(out, indent, mem, local);
        return mem;
    }
    /**
     * Output method for {@link #dumpMemoryUse(PrintStream, boolean, int, long)}.
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:659
     */
    protected void addMemoryUseRow(PrintStream out, String indent, long mem, long local) {
		out.println(indent + getClass().getSimpleName() + extraMemoryUseInfo() + ": " + 
				formatMem(mem) + " (" + formatMem(local) + ")");
	}
    /**
     * Visit each node in tree (depth-first).
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:679
     */
    public void visitAll(ASTVisitor v) {
        for (ASTNode ch : profilingChildren())
            ch.visitAll(v);
        v.visit(this);
    }
    /**
     * @aspect MemoryUse
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:937
     */
    public boolean recognizedByParent() {
		return parent != null && 
				parent.children != null && 
				childIndex >= 0 && childIndex < parent.children.length &&
				parent.children[childIndex] == this;
	}
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:43
     */
    public static final SanityProblemProducer DEBUG_SANITY_CHECK = new SanityProblemProducer();
    /**
     * Check that all relevant names can be looked up in the flat tree.
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:48
     */
    public void sanityCheckCommonAccessConsistency(FClass fc) {
        sanityCheckCommonAccessConsistencyInChildren(fc);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:52
     */
    public void sanityCheckCommonAccessConsistencyInChildren(FClass fc) {
        for (ASTNode n : this) {
            n.sanityCheckCommonAccessConsistency(fc);
        }
    }
    /**
     * Check that all types are known
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:134
     */
    public void sanityCheckType(FClass fc) {
        sanityCheckTypeInChildren(fc);
    }
    /**
     * @aspect Sanity
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\SanityCheck.jrag:138
     */
    public void sanityCheckTypeInChildren(FClass fc) {
        for (ASTNode n : this) {
            n.sanityCheckType(fc);
        }
    }
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:974
     */
    public static final SimpleProblemProducer DIFFERENTIATED_DISCRETE_VARIABLE =
            new SimpleErrorProducer("DIFFERENTIATED_DISCRETE_VARIABLE", ProblemKind.SEMANTIC,
                    "Unable to differentiate the variable %s which is declared or infered to be discrete");
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1111
     */
    public void gatherContinuousVariablesUsedInPre(Set<FVariable> res) {
        for (ASTNode n : this) 
            n.gatherContinuousVariablesUsedInPre(res);
    }
    /**
     * @aspect DummyDerivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1206
     */
    public void enableFHDerRewrite() {
        for (ASTNode n : this)
            n.enableFHDerRewrite();
    }
    /**
     * Flush all caches, including collection attributes.
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1309
     */
    public void flushAll() {
		flushCache();
		flushCollectionCache();
	}
    /**
     * Flush all caches, including collection attributes, and also
     * flush all children. In addition, the is$final attribute is set to false
     * for FExps in order to enable rewrites of such nodes after elimination 
     * of alias variables and after function inlining.
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1320
     */
    public void flushAllRecursiveClearFinal() {
		flushAll();
		//is$Final = false;
		for (ASTNode n : noTransform()) {
			n.flushAllRecursiveClearFinal();
		}
	}
    /**
     * Flush all caches, including collection attributes, and also
     * flush all children. 
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1337
     */
    public void flushAllRecursive() {
		flushAll();
		for (ASTNode n : noTransform()) {
			n.flushAllRecursive();
		}
	}
    /**
     * Traverse entire tree, forcing any pending rewrites to occur.
     * @aspect FlushFClass
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1356
     */
    public void forceRewrites() {
        for (ASTNode n : this) 
            n.forceRewrites();
	}
    /**
     * @aspect LocalIteration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\extentions\\LocalIteration.jrag:70
     */
    private static AttributeContributer LOCAL_ITERATION_CONTRIBUTER =
            addAttributeContributer(new AttributeContributer.LocalIterationContributer());
    /**
     * Determine if two expressions would form an alias pair if on the left and right sides of 
     * an equation.
     * 
     * @param e1    an expression that would form one side of the equation
     * @param e2    an expression that would form the other side of the equation
     * @param sign  alias sign is multiplied with this - useful for e.g. 0 = x + y
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:112
     */
    public static AliasPair aliasVariables(FExp e1, FExp e2, int sign, boolean checkVariables) {
        FVariable fv1 = e1.variableThatCanBeAlias();
        FVariable fv2 = e2.variableThatCanBeAlias();
        if (fv1 != null && fv2 != null) {  // x = y, etc.
            if (!checkVariables || e1.canBeAlias() && e2.canBeAlias() 
                    && e1.type().typeAliasCompatible(e2.type()) 
                    && e1.variability().aliasCompatible(e2.variability())) {
                boolean negated = e1.aliasSign() * e2.aliasSign() * sign < 0;
                return new AliasPair(fv1, fv2, negated);
            } else {
                return null;
            }
        } else {                          // 0 = x + y, etc
            FExp eqZero = null;
            if (e1.isLiteralZero()) {
                eqZero = e2;
            } else if (e2.isLiteralZero()) {
                eqZero = e1;
            } if (eqZero != null) {
                return eqZero.aliasVariables(checkVariables);
            } else {
                return null;
            }
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:327
     */
    public void enableAliasRewrite() {
		for (ASTNode n : this)
			n.enableAliasRewrite();
	}
    /**
     * Create a copy of the list with all equations with <code>markedForRemoval == true</code> removed. 
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:713
     */
    protected static List<FAbstractEquation> removeMarkedEqns(List<FAbstractEquation> list) {
		List<FAbstractEquation> res = new List<FAbstractEquation>();
		for (FAbstractEquation eqn : list) {
			if (!eqn.markedForRemoval) {
				eqn.removeMarkedEqns();
				res.add(eqn);
			}
		}
		return res;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:813
     */
    public void activateEquivalentRecordUseRewrite() {
		for (ASTNode n : this)
			n.activateEquivalentRecordUseRewrite();
	}
    /**
     * Add function calls in this sub tree to <code>m</code>
     * @aspect CommonSubexpressionElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\CommonSubexpressionElimination.jrag:155
     */
    public void collectFunctionCalls(FClass.commonSubexpressionEliminationIfSet m) {
        for (ASTNode n : this) {
            n.collectFunctionCalls(m);
        }
    }
    /**
     * Performs constant folding
     * @aspect ConstantFolding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\ConstantFolding.jrag:22
     */
    public void constantFolding(VariableEvaluator evaluator) {
        for (ASTNode n : this) {
            n.constantFolding(evaluator);
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1003
     */
    private static final String REPLACE_UNKNOWN_CHILD_MSG = 
        "Trying to replace a child that is not found in the given position.";
    /**
     * Replace a child of this node.
     * 
     * @param child  the child to replace
     * @param repl   the node to replace it with
     * @throws IllegalArgumentException  if <code>child</code> is not a child of this node
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1013
     */
    private void replaceChild(ASTNode child, ASTNode repl) {
        int i = getIndexOfChild(child);
        if (i < 0)
            throw new IllegalArgumentException(REPLACE_UNKNOWN_CHILD_MSG);
        setChild(repl, i);
    }
    /**
     * Replace this node in the tree.
     * 
     * @param repl  the node to replace it with
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1025
     */
    protected void replaceMe(ASTNode repl) {
        ASTNode p = getParent();
        if (p != null) { 
            if (p instanceof DynamicOpt)
                p.setChild(repl, 0);
            else
                p.replaceChild(this, repl);
        }
    }
    /**
     * Helper method to check if a list of statements are all inlinable.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1266
     */
    public static boolean isAllInlinable(Iterable<? extends FStatement> list) {
        for (FStatement stmt : list)
            if (!stmt.isInlinable())
                return false;
        return true;
    }
    /**
     * Replace all variable references according to the inlining helper.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1571
     */
    public ASTNode replaceReferences(AbstractFunctionInliner fi) {
        for (ASTNode n : this)
            n.replaceReferences(fi);
        return this;
    }
    /**
     * Replace all variable references in array subscripts according to the inlining helper.
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1759
     */
    public void replaceReferencesInSubscripts(AbstractFunctionInliner fi) {
        for (ASTNode n : this)
            n.replaceReferencesInSubscripts(fi);
    }
    /**
     * Post processing FFunctionDecls after scalarization.
     * Clear the scalarized flag for all FAccesss.
     * Rewrite FTempAccessExp to FAccessExp
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:43
     */
    public void clearScalarized() {
        for (ASTNode node : this)
            node.clearScalarized();
    }
    /**
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:158
     */
    public void usesInScalarizedExp(Set<FAbstractVariable> res) {
        for (ASTNode n : this)
            n.usesInScalarizedExp(res);
    }
    /**
     * Traverser for {@link FExp#createArrayTemporaries(Scalarizer s)}.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:180
     */
    public void createArrayTemporaries(Scalarizer s) {
        for (ASTNode n : this)
            n.createArrayTemporaries(s);
    }
    /**
     * Wrapper for {@link ASTNode#addArrayUsesToIndexMap(FExp[] names)}.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:899
     */
    public void addArrayUsesToIndexMap(Scalarizer s) {
        if (s.getNames().size() > 0) {
            addArrayUsesToIndexMap(s.getNames().createFExpArray());
        }
    }
    /**
     * Traverser for {@link FExp#addArrayUsesToIndexMap(FExp[] names)}.
     * @aspect FunctionScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:908
     */
    public void addArrayUsesToIndexMap(FExp[] names) {
        for (ASTNode n : this)
            n.addArrayUsesToIndexMap(names);
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:517
     */
    public Set<FAccessExp> homotopySimplifiedVarUseLookupVisitor() {
        return findCommonAccessExpsInTree(HomotopySimplifiedVarUseLookupVisitor.instance);
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:521
     */
    public void homotopySimplifiedVarUseLookupVisitor(Set<FAccessExp> set, CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        findCommonAccessExpsInTree(set, visitor);
    }
    /**
     * @aspect BLT
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:1753
     */
    public static final AbstractEquationBlock.BlockProblemProducer NESTED_NON_SCALAR_BLOCK =
            new AbstractEquationBlock.BlockProblemProducer("NESTED_NON_SCALAR_BLOCK", "Nested non scalar blocks are not allowed since option 'allow_non_scalar_nested_blocks' is set to false.");
    /**
     * Static printer instance.
     * @aspect BLTPrettyPrinting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:2779
     */
    public static BLTPrettyPrinter BLTPrettyPrinter = new BLTPrettyPrinter();
    /**
     * @aspect StartValueDependency
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:3700
     */
    public static final AbstractEquationBlock.BlockProblemProducer START_VALUE_DEPEND_ON_BLOCK_ERROR =
            new AbstractEquationBlock.BlockProblemProducer("START_VALUE_DEPEND_ON_BLOCK_ERROR",
                    "The start value ('%s') for variable %s depends on variables which are computed in the same block, this is not allowed!");
    /**
     * @aspect StartValueDependency
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:3720
     */
    public static final AbstractEquationBlock.BlockProblemProducer EXTERNAL_OBJECT_IN_BLOCK =
            new AbstractEquationBlock.BlockProblemProducer("EXTERNAL_OBJECT_IN_BLOCK",
                    "The external object %s is computed in a block, this is not allowed!");
    /**
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:873
     */
    public static final int SMOOTH_ORDER_ANNOTATION_DEFAULT = -1;
    /**
     * @aspect SmoothOrder
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:875
     */
    public static int readSmoothOrderAnnotation(AnnotationNode a) {
        AnnotationNode smoothOrder = a.forPath("smoothOrder");
        if (smoothOrder.isIntegerValue())
            return smoothOrder.integer();
        else
            return SMOOTH_ORDER_ANNOTATION_DEFAULT;
    }
    /**
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:92
     */
    public void enableDynamicStateRewrite() {
        for (ASTNode n : this)
            n.enableDynamicStateRewrite();
    }
    /**
     * @aspect GenInitArrayStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\GenInitArrayStatements.jrag:189
     */
    public Set<String> sortingAddNamesUsed(Set<String> set) {
        for (ASTNode n : this)
            n.sortingAddNamesUsed(set);
        return set;
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:1509
     */
    public void findDAEVarUsesInTree(Set<FAccessExp> set, CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        findCommonAccessExpsInTree(set, visitor);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:1518
     */
    public void findInitDAEVarUsesInTree(Set<FAccessExp> set, CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        findCommonAccessExpsInTree(set, visitor);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:1522
     */
    public Set<FAccessExp> findInitUniqueDAEVarUsesInTree() {
        return findCommonAccessExpsInTree(InitUniqueDAEVarUseLookupVisitor.instance);
    }
    /**
     * @aspect Graphs
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Graphs.jadd:1526
     */
    public void findInitUniqueDAEVarUsesInTree(Set<FAccessExp> set, CommonAccessExpLookupVisitor<FAccessExp> visitor) {
        for (ASTNode n : this) {
            visitor.visit(n, set);
        }
    }
    /**
     * This method is used when the original node has been discarded and the
     * orignal references in FRelExp and FSampleExp needs to be reset.
     * 
     * It is also used when it is known that original expression doesn't
     * produce events but the new does. For example the derivative of
     * smooot(1, ...).
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:378
     */
    protected void resetOriginalReferences() {
        for (int i = 0; i < getNumChildNoTransform(); i++) {
            getChildNoTransform(i).resetOriginalReferences();
        }
    }
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:408
     */
    protected void traverseSymbolic(ASTNode e) {
		for (int i = 0; i < getNumChildNoTransform(); i++) {
			getChildNoTransform(i).traverseSymbolic(e.getChildNoTransform(i));
		}
	}
    /**
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:438
     */
    public ASTNode copySymbolic() {
		ASTNode res = fullCopy();
		res.traverseSymbolic(this);
		return res;
	}
    /**
     * Eliminates unnecessary if equations.
     * 
     * @param equations
     * The list in which to put equations that are extracted from live branches.
     * @aspect IfEquationElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationElimination.jrag:72
     */
    public void eliminateIfEquations(List<FAbstractEquation> equations) {}
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:92
     */
    public void checkIfEquationCompliance() {
        for (ASTNode n : this) {
            n.checkIfEquationCompliance();
        }
    }
    /**
     * @aspect IfEquationRewrite
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\IfEquationRewrite.jrag:188
     */
    

        // Probably keep this here.
        public static <K, V> Set<V> valuesOfUnNamedKeys(Map<K, V> map, Set<K> namedKeys) {
            Set<V> res = new HashSet<V>();

            for (Map.Entry<K,V> e : map.entrySet()) {
                if (!namedKeys.contains(e.getKey())) {
                    res.add(e.getValue());
                }
            }
            return res;
        }
    /**
     * @aspect TestFramework
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestFramework.jrag:19
     */
    public boolean collectTestCases(TestSuite ts, String className) {
        for (ASTNode n : this)
            if (n.collectTestCases(ts, className))
                return true;
        return false;
    }
    /**
     * @aspect TestFramework
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\TestFramework\\src\\jastadd\\TestFramework.jrag:52
     */
    public void collectTestCases(TestSuite ts) {
        for (ASTNode n : this)
            n.collectTestCases(ts);
    }
    /**
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:57
     */
    public static final SimpleProblemProducer ABSOLUTE_VALUE_LOCATION =
            new SimpleErrorProducer("ABSOLUTE_VALUE_LOCATION", ProblemKind.SEMANTIC,
                    "absoluteValue annotation only allowed on simple types or components of simple types");
    /**
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:61
     */
    public static final SimpleProblemProducer ABSOLUTE_VALUE =
            new SimpleErrorProducer("ABSOLUTE_VALUE", ProblemKind.SEMANTIC,
                    "absoluteValue annotation only allows scalar boolean literal values 'true' or 'false'");
    /**
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:68
     */
    private static AttributeContributer ABSOLUTE_VALUE_CONTRIBUTER =
            addAttributeContributer(new AttributeContributer.AbsoluteValueContributer());
    /**
     * Static printer instance.
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:28
     */
    public static XMLPrettyPrinter printer_XML = new XMLPrettyPrinter();
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:40
     */
    public String prettyPrint_XML(String indent) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		CodeStream str = new CodeStream(os);
		prettyPrint_XML(str, indent);
		return os.toString();
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:47
     */
    public void prettyPrint_XML(CodeStream str, String indent) {
        prettyPrint_XML(printer_XML, str, indent);
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:51
     */
    public void prettyPrint_XML(Printer p, CodeStream str, String indent) {
		prettyPrint(p, str, indent);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:58
     */
    private static final String XML_TAG_OPEN_FORMAT    = "%s<%s:%s>";
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:59
     */
    private static final String XML_TAG_OPEN_FORMAT_NL = "%s<%s:%s>\n";
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:60
     */
    private static final String XML_TAG_CLOSE_FORMAT   = "%s</%s:%s>\n";
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:61
     */
    private static final String XML_TAG_SINGLE_FORMAT  = "%s<%s:%s/>\n";
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:63
     */
    public void tag_XML(CodeStream str, String format, String indent) {
		str.format(format, indent, xmlNamespace(), xmlTag());
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:67
     */
    public void tag_XML(CodeStream str, String format, String indent, String tag) {
		str.format(format, indent, xmlNamespace(), tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:71
     */
    public void tag_XML(CodeStream str, String format, String indent, Map<String, String> attr) {
		str.format(format, indent, xmlNamespace(), addAttrs_XML(xmlTag(), attr));
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:75
     */
    public void tag_XML(CodeStream str, String format, String indent, String tag, Map<String, String> attr) {
		str.format(format, indent, xmlNamespace(), addAttrs_XML(tag, attr));
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:79
     */
    private static String addAttrs_XML(String tag, Map<String, String> attr) {
		StringBuilder buf = new StringBuilder(tag);
		for (String name : attr.keySet()) {
			buf.append(' ');
			buf.append(name);
			buf.append('=');
			buf.append(attr.get(name));
		}
		return buf.toString();
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:90
     */
    public void open_XML(CodeStream str, String indent) {
		tag_XML(str, XML_TAG_OPEN_FORMAT_NL, indent);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:94
     */
    public void open_XML(CodeStream str, String indent, String tag) {
		tag_XML(str, XML_TAG_OPEN_FORMAT_NL, indent, tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:98
     */
    public void open_XML(CodeStream str, String indent, Map<String, String> attr) {
		tag_XML(str, XML_TAG_OPEN_FORMAT_NL, indent, attr);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:102
     */
    public void open_XML(CodeStream str, String indent, String tag, Map<String, String> attr) {
		tag_XML(str, XML_TAG_OPEN_FORMAT_NL, indent, tag, attr);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:106
     */
    public void openLine_XML(CodeStream str, String indent) {
		tag_XML(str, XML_TAG_OPEN_FORMAT, indent);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:110
     */
    public void openLine_XML(CodeStream str, String indent, Map<String, String> attr) {
		tag_XML(str, XML_TAG_OPEN_FORMAT, indent, attr);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:114
     */
    public void close_XML(CodeStream str) {
		close_XML(str, "");
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:118
     */
    public void close_XML(CodeStream str, String indent) {
		tag_XML(str, XML_TAG_CLOSE_FORMAT, indent);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:122
     */
    public void close_XML(CodeStream str, String indent, String tag) {
		tag_XML(str, XML_TAG_CLOSE_FORMAT, indent, tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:126
     */
    public void single_XML(CodeStream str, String indent) {
		tag_XML(str, XML_TAG_SINGLE_FORMAT, indent);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:130
     */
    public void single_XML(CodeStream str, String indent, String tag) {
		tag_XML(str, XML_TAG_SINGLE_FORMAT, indent, tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:134
     */
    public void single_XML(CodeStream str, String indent,  Map<String, String> attr) {
		tag_XML(str, XML_TAG_SINGLE_FORMAT, indent, attr);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:138
     */
    public void single_XML(CodeStream str, String indent, String tag, Map<String, String> attr) {
		tag_XML(str, XML_TAG_SINGLE_FORMAT, indent, tag, attr);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:142
     */
    public void enclose_XML(Printer p, CodeStream str, String indent, String tag, ASTNode node) {
		open_XML(str, indent, tag);
		p.print(node, str, indent);
		close_XML(str, indent, tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:148
     */
    public void enclose_XML(Printer p, CodeStream str, String indent, String tag, ASTNode node, Map<String, String> attr) {
		open_XML(str, indent, tag, attr);
		p.print(node, str, indent);
		close_XML(str, indent, tag);
	}
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:154
     */
    public static Map<String,String> attr_XML(String... args) {
		switch (args.length / 2) {
		case 0:
			return Collections.emptyMap();
		case 1:
			return Collections.singletonMap(args[0], args[1]);
		default:
			Map<String,String> res = new LinkedHashMap<String,String>();
			for (int i = 0; i < args.length - 1; i += 2)
				res.put(args[i], args[i + 1]);
			return res;
		}
	}
    /**
     * Static printer instance.
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:37
     */
    static CPrettyPrinter printer_C = new CPrettyPrinter();
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:118
     */
    public String prettyPrint_C() {
        // This method should not exist
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CodeStream str = new CodeStream(os);
        prettyPrint_C(ASTNode.printer_C, str, "");
        return os.toString();
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:127
     */
    public void genVarDecls_C(CodePrinter p, CodeStream str, String indent) {
        for (ASTNode node : this) {
            p.printVarDecls(node, str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:133
     */
    public void genTempVars_C(CodePrinter p, CodeStream str, String indent) {
        for (ASTNode node : this) {
            p.printPreSteps(node, str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:139
     */
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        prettyPrint(p, str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:143
     */
    public void genTempFree_C(CodePrinter p, CodeStream str, String indent) {
        for (ASTNode node : this) {
            p.printPostSteps(node, str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:199
     */
    public static final String C_SUFFIX_DEF      = "def";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:200
     */
    public static final String C_SUFFIX_EXP      = "exp";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:201
     */
    public static final String C_SUFFIX_REC      = "r";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:202
     */
    public static final String C_SUFFIX_EXT      = "_ext";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:203
     */
    public static final String C_SUFFIX_ENUM     = "e";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:204
     */
    public static final String C_SUFFIX_INDEX    = "i";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:205
     */
    public static final String C_SUFFIX_VARIABLE = "v";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:206
     */
    public static final String C_SUFFIX_ARRAY    = "a";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:207
     */
    public static final String C_SUFFIX_RETURN   = "o";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:208
     */
    public static final String C_SUFFIX_NULL     = "n";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:210
     */
    public static final String C_ARRAY_RECORD    = "rec";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:211
     */
    public static final String C_ARRAY_REFERENCE = "ref";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:212
     */
    public static final String C_ARRAY_VALUE     = "val";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:215
     */
    public static final String C_SUFFIX_FP       = "fp";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:216
     */
    public static final String C_SUFFIX_FPCL     = "fpcl";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:217
     */
    public static final String C_SUFFIX_FPCR     = "fpcr";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:218
     */
    public static final String C_SUFFIX_FPOUT    = "fpout";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:219
     */
    public static final String C_SUFFIX_SETFLAG  = "_s";
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:321
     */
    public static void genFunctionStart(CodeStream str, String indent) {
        str.print(indent);
        str.print("int ef = 0;\n");
        ASTNode.genDynMemInit(str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:327
     */
    public static void genFunctionEnd(CodeStream str, String indent) {
        ASTNode.genDynMemFree(str, indent);
        str.print(indent);
        str.print("return ef;\n");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:333
     */
    public static void genDynMemInit(CodeStream str, String indent) {
        str.print(indent);
        str.print("JMI_DYNAMIC_INIT()\n");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:338
     */
    public static void genDynMemFree(CodeStream str, String indent) {
        str.print(indent);
        str.print("JMI_DYNAMIC_FREE()\n");
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:98
     */
    public void printDecl_C(CodePrinter p, CodeStream str, String indent, Set<ASTNode> visited, Collection<FVariable> forVariables, boolean solved) {
        throw new UnsupportedOperationException("ASTNode.printDecl_C(CodePrinter p, CodeStream str, String indent, Collection<FVariable> forVariables, boolean solved) not implemented for class '" + getClass().getSimpleName() +"'");
    }
    /**
     * 
     * @aspect CCodeGenExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1379
     */
    public static String boolValue_C(boolean value) {
        return value ? "JMI_TRUE" : "JMI_FALSE";
    }
    /**
     * @aspect CCodeGenGlobalsCached
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenGlobals.jrag:144
     */
    public void gatherBlockSetupNodes(CodePrinter p, Collection<FFunctionCall> res) {
        for (ASTNode n : this) {
            n.gatherBlockSetupNodes(p, res);
        }
    }
    /**
     * @aspect StepPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\StepPrinter.jrag:147
     */
    public void genTempArg(CodePrinter.StepPrinter p, CodeStream str, String indent) {
        for (ASTNode n : this) {
            n.genTempArg(p, str, indent);
        }
    }
    /**
     * @aspect ExportFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\ExportFunctions.jadd:69
     */
    public static final String C_SUFFIX_EXPORT = "export";
    /**
     * @aspect DiagnosticsGeneration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:975
     */
    protected static String escapeHTML(Object o) {
    return escapeHTML(o.toString());
}
    /**
     * @aspect DiagnosticsGeneration
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:979
     */
    protected static String escapeHTML(String str) {
    str = str.replace("&", "&amp;");
    str = str.replace("\"", "&quot;");
    str = str.replace("\'", "&039;");
    str = str.replace("<", "&lt;");
    str = str.replace(">", "&gt;");
    return str;
}
    /**
     * Static printer instance.
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:995
     */
    public static HTMLPrinter htmlPrinter = new HTMLPrinter();
    /**
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1083
     */
    public void htmlPrint(HTMLPrinter p, CodeStream str, String indent) {
        prettyPrint(p, str, indent);
    }
    /**
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1087
     */
    public void htmlPrint(CodeStream out, String title) {
        HTMLPrinter p = htmlPrinter;
        p.startFile(out, title);
        p.print(this, out, "  ");
        p.endFile(out);
    }
    /**
     * Does a recursive AST traversation to the first encountered FFunctionDecl. The FFunctionDecl
     * has a hash map where the key,value-pair passed in is set. The key should be the FAccess of a 
     * variable  in a record and value its symbolic MX. 
     * @param A String 
     * @param A MX
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:643
     */
    public void setMXVariableInFunctionDeclRecordVariableMap(String key, MX val) {
        if (getParent() != null) {
            getParent().setMXVariableInFunctionDeclRecordVariableMap(key, val);
        }
    }
    /**
     * @declaredat ASTNode:1
     */
    public ASTNode() {
        super();
        init$Children();
    }
    /**
     * Initializes the child array to the correct size.
     * Initializes List and Opt nta children.
     * @apilevel internal
     * @ast method
     * @declaredat ASTNode:11
     */
    public void init$Children() {
    }
    /**
     * Cached child index. Child indices are assumed to never change (AST should
     * not change after construction).
     * @apilevel internal
     * @declaredat ASTNode:18
     */
    private int childIndex = -1;
    /** @apilevel low-level 
     * @declaredat ASTNode:21
     */
    public int getIndexOfChild(ASTNode node) {
        if (node == null) {
            return -1;
        }
        // Legacy rewrites with rewrite in list can change child position, so update may be needed.
        if (node.childIndex >= 0 && node.childIndex < numChildren && node == children[node.childIndex]) {
            return node.childIndex;
        }
        for (int i = 0; children != null && i < children.length; i++) {
            if (children[i] == node) {
                node.childIndex = i;
                return i;
            }
        }
        return -1;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:39
     */
    public static final boolean generatedWithCacheCycle = true;
    /** @apilevel low-level 
     * @declaredat ASTNode:42
     */
    protected ASTNode parent;
    /** @apilevel low-level 
     * @declaredat ASTNode:45
     */
    protected ASTNode[] children;
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    private static ASTState state = new ASTState();
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public final ASTState state() {
        return state;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:57
     */
    public final static ASTState resetState() {
        return state = new ASTState();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:62
     */
    public boolean in$Circle = false;
    /** @apilevel internal 
     * @declaredat ASTNode:65
     */
    public boolean in$Circle() {
        return in$Circle;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:70
     */
    public void in$Circle(boolean b) {
        in$Circle = b;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:74
     */
    public boolean is$Final = false;
    /** @apilevel internal 
     * @declaredat ASTNode:77
     */
    public boolean is$Final() {
        return is$Final;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:82
     */
    public void is$Final(boolean b) {
        is$Final = b;
    }
    /**
     * @return an iterator that can be used to iterate over the children of this node.
     * The iterator does not allow removing children.
     * @declaredat ASTNode:90
     */
    public java.util.Iterator<T> astChildIterator() {
        return new java.util.Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getNumChild();
            }

            @Override
            public T next() {
                return hasNext() ? (T) getChild(index++) : null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
    /** @return an object that can be used to iterate over the children of this node 
     * @declaredat ASTNode:112
     */
    public Iterable<T> astChildren() {
        return new Iterable<T>() {
            @Override
            public java.util.Iterator<T> iterator() {
                return astChildIterator();
            }
        };
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:122
     */
    public T getChild(int i) {
        ASTNode node = this.getChildNoTransform(i);
        if (node == null) {
            return null;
        }
        if (node.is$Final()) {
            return (T) node;
        }
        if (!node.mayHaveRewrite()) {
            node.is$Final(this.is$Final());
            return (T) node;
        }
        if (!node.in$Circle()) {
            int rewriteState;
            int _boundaries = state().boundariesCrossed;
            do {
                state().push(ASTState.REWRITE_CHANGE);
                ASTNode oldNode = node;
                oldNode.in$Circle(true);
                node = node.rewriteTo();
                if (node != oldNode) {
                    this.setChild(node, i);
                }
                oldNode.in$Circle(false);
                rewriteState = state().pop();
            } while(rewriteState == ASTState.REWRITE_CHANGE);
            if (rewriteState == ASTState.REWRITE_NOCHANGE && this.is$Final()) {
                node.is$Final(true);
                state().boundariesCrossed = _boundaries;
            } else {
            }
        } else if (this.is$Final() != node.is$Final()) {
            state().boundariesCrossed++;
        } else {
        }
        return (T) node;

    }
    /** @apilevel low-level 
     * @declaredat ASTNode:161
     */
    public void addChild(T node) {
        setChild(node, getNumChildNoTransform());
    }
    /**
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @apilevel low-level
     * @declaredat ASTNode:168
     */
    public final T getChildNoTransform(int i) {
        if (children == null) {
            return null;
        }
        T child = (T)children[i];
        return child;
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:176
     */
    protected int numChildren;
    /** @apilevel low-level 
     * @declaredat ASTNode:179
     */
    protected int numChildren() {
        return numChildren;
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:184
     */
    public int getNumChild() {
        return numChildren();
    }
    /**
     * Behaves like getNumChild, but does not invoke AST transformations (rewrites).
     * @apilevel low-level
     * @declaredat ASTNode:192
     */
    public final int getNumChildNoTransform() {
        return numChildren();
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:196
     */
    public void setChild(ASTNode node, int i) {
        if (children == null) {
            children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
        } else if (i >= children.length) {
            ASTNode c[] = new ASTNode[i << 1];
            System.arraycopy(children, 0, c, 0, children.length);
            children = c;
        }
        if (Opt.EMPTY == node || node instanceof Opt && ((Opt) node).numChildren() <= 0) {
            children[i] = Opt.EMPTY;
        } else if (node instanceof List && ((List) node).numChildren() <= 0) {
            children[i] = List.EMPTY;
        } else {
            children[i] = node;
        }
        if (i >= numChildren) {
            numChildren = i+1;
        }
        if (node != null) {
            node.setParent(this);
            node.childIndex = i;
        }
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:220
     */
    public void insertChild(ASTNode node, int i) {
        if (children == null) {
            children = new ASTNode[(i + 1 > 4 || !(this instanceof List)) ? i + 1 : 4];
            children[i] = node;
        } else {
            ASTNode c[] = new ASTNode[children.length + 1];
            System.arraycopy(children, 0, c, 0, i);
            c[i] = node;
            if (i < children.length) {
                System.arraycopy(children, i, c, i+1, children.length-i);
                for(int j = i+1; j < c.length; ++j) {
                    if (c[j] != null) {
                        c[j].childIndex = j;
                    }
                }
            }
            children = c;
        }
        numChildren++;
        if (node != null) {
            node.setParent(this);
            node.childIndex = i;
        }
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:245
     */
    public void removeChild(int i) {
        if (children != null) {
            ASTNode child = (ASTNode) children[i];
            if (child != null) {
                child.parent = null;
                child.childIndex = -1;
            }
            // Adding a check of this instance to make sure its a List, a move of children doesn't make
            // any sense for a node unless its a list. Also, there is a problem if a child of a non-List node is removed
            // and siblings are moved one step to the right, with null at the end.
            if (this instanceof List || this instanceof Opt) {
                System.arraycopy(children, i+1, children, i, children.length-i-1);
                children[children.length-1] = null;
                numChildren--;
                // fix child indices
                for(int j = i; j < numChildren; ++j) {
                    if (children[j] != null) {
                        child = (ASTNode) children[j];
                        child.childIndex = j;
                    }
                }
            } else {
                children[i] = null;
            }
        }
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:272
     */
    public ASTNode getParent() {
        if (parent != null && ((ASTNode) parent).is$Final() != is$Final()) {
            state().boundariesCrossed++;
        }
        return (ASTNode) parent;
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:279
     */
    public void setParent(ASTNode node) {
        parent = node;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:347
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:351
     */
    public void flushTreeCache() {
        flushCache();
        if (children != null) {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null && ((ASTNode) children[i]).is$Final) {
                    ((ASTNode) children[i]).flushTreeCache();
                }
            }
        }
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:362
     */
    public void flushCache() {
        flushAttrAndCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:366
     */
    public void flushAttrAndCollectionCache() {
        flushAttrCache();
        flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:371
     */
    public void flushAttrCache() {
    }
    /** @apilevel internal 
     * @declaredat ASTNode:374
     */
    public void flushCollectionCache() {
    }
    /** @apilevel internal 
     * @declaredat ASTNode:377
     */
    public ASTNode<T> clone() throws CloneNotSupportedException {
        ASTNode node = (ASTNode) super.clone();
        if (node.is$Final()) {
            node.flushAttrAndCollectionCache();
        }
        node.in$Circle(false);
        // flush rewrites
        node.is$Final(false);
    SymbolValueFixer.fix(node);
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:388
     */
    public ASTNode<T> copy() {
        try {
            ASTNode node = (ASTNode) clone();
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
     * @declaredat ASTNode:407
     */
    @Deprecated
    public ASTNode<T> fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:417
     */
    public ASTNode<T> treeCopyNoTransform() {
        ASTNode tree = (ASTNode) copy();
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
     * @declaredat ASTNode:437
     */
    public ASTNode<T> treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /**
     * Performs a full traversal of the tree using getChild to trigger rewrites
     * @apilevel low-level
     * @declaredat ASTNode:445
     */
    public void doFullTraversal() {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).doFullTraversal();
        }
    }
    /** @apilevel internal 
     * @declaredat ASTNode:451
     */
    protected boolean is$Equal(ASTNode n1, ASTNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.is$Equal(n2);
    }
    /** @apilevel internal 
     * @declaredat ASTNode:457
     */
    protected boolean is$Equal(ASTNode node) {
        if (getClass() != node.getClass()) {
            return false;
        }
        if (numChildren != node.numChildren) {
            return false;
        }
        for (int i = 0; i < numChildren; i++) {
            if (children[i] == null && node.children[i] != null) {
                return false;
            }
            if (!((ASTNode)children[i]).is$Equal(((ASTNode)node.children[i]))) {
                return false;
            }
        }
        return true;
    }
    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1069
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_differentiatedByFDerExp(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_differentiatedByFDerExp(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_differentiatedByFDerExp(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1494
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_dynamicStates(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_dynamicStates(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_dynamicStates(LinkedHashSet<FRealVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1505
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_dynamicStateVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_dynamicStateVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_dynamicStateVariables(LinkedHashSet<FDynamicStateVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1515
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_dynamicAlgebraicVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_dynamicAlgebraicVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_dynamicAlgebraicVariables(LinkedHashSet<FDynamicAlgebraicVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1525
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_differentiatedRealVariablesFilteredSet(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_differentiatedRealVariablesFilteredSet(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_differentiatedRealVariablesFilteredSet(LinkedHashSet<FRealVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1539
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_myFFunctionDeclsPartial(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_myFFunctionDeclsPartial(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myFFunctionDeclsPartial(LinkedHashSet<FFunctionDecl> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1548
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_myFFunctionDeclsPartialCalled(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_myFFunctionDeclsPartialCalled(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myFFunctionDeclsPartialCalled(LinkedHashSet<FFunctionDecl> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1552
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_myDelayExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_myDelayExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myDelayExps(ArrayList<FDelayExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1558
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_mySpatialDistExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_mySpatialDistExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_mySpatialDistExps(ArrayList<FSpatialDistExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1577
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_derivativeVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_derivativeVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_derivativeVariables(ArrayList<FDerivativeVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1584
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_variables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_variables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_variables(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1643
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_aliasVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_aliasVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_aliasVariables(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1662
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_tempVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_tempVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_tempVariables(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1719
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_variablesWithBindingExp(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_variablesWithBindingExp(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_variablesWithBindingExp(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1746
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_inputs(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_inputs(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_inputs(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1776
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_outputs(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_outputs(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_outputs(ArrayList<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1838
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_algorithms(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_algorithms(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_algorithms(ArrayList<FAlgorithm> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2010
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_sampleExpsWithTimeEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_sampleExpsWithTimeEvent(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_sampleExpsWithTimeEvent(ArrayList<FSampleExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2016
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_spatialDistExpsWithStateEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_spatialDistExpsWithStateEvent(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_spatialDistExpsWithStateEvent(ArrayList<FSpatialDistExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2022
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_delayExpsWithStateEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_delayExpsWithStateEvent(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_delayExpsWithStateEvent(ArrayList<FDelayExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2036
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_guardExpInEquations(FlatRoot _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_guardExpInEquations(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_guardExpInEquations(ArrayList<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2043
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_guardExpInInitialEquations(FlatRoot _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_guardExpInInitialEquations(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_guardExpInInitialEquations(ArrayList<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2130
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_relExpsWithEvent(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_relExpsWithEvent(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_relExpsWithEvent(ArrayList<FRelExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2207
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_relExpInInitialEquations(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_relExpInInitialEquations(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_relExpInInitialEquations(ArrayList<FRelExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4235
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_myAlgorithms(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_myAlgorithms(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myAlgorithms(ArrayList<FAlgorithm> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4318
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_myExternals(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_myExternals(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_myExternals(HashSet<FExternalStmt> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2254
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_collectInstAccesses(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_collectInstAccesses(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_collectInstAccesses(HashSet<InstAccess> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1647
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_collectSemiLinearExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_collectSemiLinearExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_collectSemiLinearExps(HashSet<FSemiLinearExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:59
     */
        /** @apilevel internal */
    protected void collect_contributors_FClass_eventGenExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FClass_eventGenExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_eventGenExps(ArrayList<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3273
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractVariable_uses(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractVariable_uses(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractVariable_uses(HashSet<FAccessExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3399
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractVariable_dependentParameters(FlatRoot _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractVariable_dependentParameters(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractVariable_dependentParameters(HashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1111
     */
        /** @apilevel internal */
    protected void collect_contributors_FFunctionVariable_assigningUses(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FFunctionVariable_assigningUses(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FFunctionVariable_assigningUses(HashSet<FAccessExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2050
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_transformedGuards(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_transformedGuards(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_transformedGuards(Set<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2155
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_relExpInEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_relExpInEquation(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_relExpInEquation(ArrayList<FRelExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2165
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_delayExpInEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_delayExpInEquation(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_delayExpInEquation(ArrayList<FDelayExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2212
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_relExpInInitialEquation(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_relExpInInitialEquation(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_relExpInInitialEquation(ArrayList<FRelExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2222
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_eventGenExps(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_eventGenExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_eventGenExps(ArrayList<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2431
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_replacedAtInitialExps(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_replacedAtInitialExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_replacedAtInitialExps(ArrayList<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3426
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_retrieveInputs(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_retrieveInputs(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_retrieveInputs(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3460
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_algebraicVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_algebraicVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_algebraicVariables(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3501
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_derivativeVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_derivativeVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_derivativeVariables(LinkedHashSet<FDerivativeVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3511
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_differentiatedRealVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_differentiatedRealVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_differentiatedRealVariables(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3521
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_dependentParameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_dependentParameters(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_dependentParameters(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3531
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_parameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_parameters(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_parameters(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3541
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_discreteVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_discreteVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_discreteVariables(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3551
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_initialParameters(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_initialParameters(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_initialParameters(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3561
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_discretePreVariables(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_discretePreVariables(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_discretePreVariables(LinkedHashSet<FVariable> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:241
     */
        /** @apilevel internal */
    protected void collect_contributors_FAbstractEquation_timeExps(FAbstractEquation _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FAbstractEquation_timeExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FAbstractEquation_timeExps(Set<FExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2160
     */
        /** @apilevel internal */
    protected void collect_contributors_FStatement_relExpInStmt(FStatement _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FStatement_relExpInStmt(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_relExpInStmt(ArrayList<FRelExp> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:36
     */
        /** @apilevel internal */
    protected void collect_contributors_FStatement_sizeAssertsColl(FFunctionDecl _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FStatement_sizeAssertsColl(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_sizeAssertsColl(ArrayList<FAssert> collection) {
    }

    /**
     * @aspect <NoAspect>
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\ExtractEventGeneratingExpressions.jrag:73
     */
        /** @apilevel internal */
    protected void collect_contributors_FStatement_eventGenExps(FAlgorithm _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        for (int i = 0; i < getNumChild(); i++) {
            getChild(i).collect_contributors_FStatement_eventGenExps(_root, _map);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FStatement_eventGenExps(ArrayList<FExp> collection) {
    }

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1604
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1604")
    public boolean containsFTimeExp() {
        {
                for (ASTNode child : this)
                    if (child.containsFTimeExp())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1613
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1613")
    public boolean containsFHomotopyExp() {
        {
                for (ASTNode child : this)
                    if (child.containsFHomotopyExp())
                        return true;
                return false;
            }
    }
    /**
     * Check if tree contains a function call returning an array or a record.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2638
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2638")
    public boolean hasCompositeFunc() {
        {
                for (ASTNode n : this)
                    if (n.hasCompositeFunc())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect UnknownFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:389
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:389")
    public UnknownFVariable unknownFVariable() {
        UnknownFVariable unknownFVariable_value = root().unknownFVariable();
        return unknownFVariable_value;
    }
    /**
     * Counts the total number of FExp nodes in this ASTNode.
     * @attribute syn
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1853
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1853")
    public int numFExp() {
        {
                int n = 0;
                for (int i=0;i<getNumChild();i++)
                    n += getChild(i).numFExp();
                return n;
            }
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1366
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1366")
    public FType fUnknownType() {
        FType fUnknownType_value = FUnknownType.SCALAR;
        return fUnknownType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1367")
    public FType fNoType() {
        FType fNoType_value = FNoType.SCALAR;
        return fNoType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1369
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1369")
    public FPrimitiveType fRealScalarType() {
        FPrimitiveType fRealScalarType_value = FRealType.SCALAR;
        return fRealScalarType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1370
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1370")
    public FPrimitiveType fIntegerScalarType() {
        FPrimitiveType fIntegerScalarType_value = FIntegerType.SCALAR;
        return fIntegerScalarType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1371
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1371")
    public FPrimitiveType fBooleanScalarType() {
        FPrimitiveType fBooleanScalarType_value = FBooleanType.SCALAR;
        return fBooleanScalarType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1372
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1372")
    public FPrimitiveType fStringScalarType() {
        FPrimitiveType fStringScalarType_value = FStringType.SCALAR;
        return fStringScalarType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1374")
    public FPrimitiveType fRealArrayType(Size size) {
        FPrimitiveType fRealArrayType_Size_value = new FRealType(size);
        return fRealArrayType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1375
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1375")
    public FPrimitiveType fIntegerArrayType(Size size) {
        FPrimitiveType fIntegerArrayType_Size_value = new FIntegerType(size);
        return fIntegerArrayType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1376
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1376")
    public FPrimitiveType fBooleanArrayType(Size size) {
        FPrimitiveType fBooleanArrayType_Size_value = new FBooleanType(size);
        return fBooleanArrayType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1377
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1377")
    public FPrimitiveType fStringArrayType(Size size) {
        FPrimitiveType fStringArrayType_Size_value = new FStringType(size);
        return fStringArrayType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1379
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1379")
    public FPrimitiveType fRealType(Size size) {
        FPrimitiveType fRealType_Size_value = (size == Size.SCALAR) ? fRealScalarType() : fRealArrayType(size);
        return fRealType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1381
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1381")
    public FPrimitiveType fIntegerType(Size size) {
        FPrimitiveType fIntegerType_Size_value = (size == Size.SCALAR) ? fIntegerScalarType() : fIntegerArrayType(size);
        return fIntegerType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1383
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1383")
    public FPrimitiveType fBooleanType(Size size) {
        FPrimitiveType fBooleanType_Size_value = (size == Size.SCALAR) ? fBooleanScalarType() : fBooleanArrayType(size);
        return fBooleanType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1385
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1385")
    public FPrimitiveType fStringType(Size size) {
        FPrimitiveType fStringType_Size_value = (size == Size.SCALAR) ? fStringScalarType() : fStringArrayType(size);
        return fStringType_Size_value;
    }
    /**
     * @attribute syn
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:206
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:206")
    public ProblemOptionsProvider myProblemOptionsProvider() {
        ProblemOptionsProvider myProblemOptionsProvider_value = root().getUtilInterface();
        return myProblemOptionsProvider_value;
    }
    /**
     * @attribute syn
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:595
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:595")
    public String errorComponentName() {
        {
                InstComponentDecl parent = errorEnclosingComponent();
                return parent == null ? null : parent.getFAccess().scalarName(false);
            }
    }
    /**
     * @attribute syn
     * @aspect ErrorClasses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorClasses.jrag:22
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ErrorClasses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorClasses.jrag:22")
    public boolean isError() {
        boolean isError_value = false;
        return isError_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:100")
    public String classErrorType() {
        String classErrorType_value = null;
        return classErrorType_value;
    }
    /**
     * @attribute syn
     * @aspect InstanceNameCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceNameCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:104")
    public String classErrorName() {
        String classErrorName_value = null;
        return classErrorName_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:573")
    public boolean containsFunction(FFunctionDecl.FunctionType ft) {
        {
                for (ASTNode n : this) {
                    if (n.containsFunction(ft)) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1310
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1310")
    public boolean externalDependency() {
        {
                for (ASTNode n : this) {
                    if (n.externalDependency()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatStatements", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:48")
    public boolean containsBreakStmt() {
        {
                for (ASTNode n : this)
                    if (n.containsBreakStmt())
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:60")
    public SrcUnknownClassDecl unknownClassDecl() {
        SrcUnknownClassDecl unknownClassDecl_value = root().unknownClassDecl();
        return unknownClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:64
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:64")
    public SrcUnknownComponentDecl unknownComponentDecl() {
        SrcUnknownComponentDecl unknownComponentDecl_value = root().unknownComponentDecl();
        return unknownComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:96
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:96")
    public UnknownInstClassDecl unknownInstClassDecl() {
        UnknownInstClassDecl unknownInstClassDecl_value = root().unknownInstClassDecl();
        return unknownInstClassDecl_value;
    }
    /**
     * @attribute syn
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:99
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:99")
    public UnknownInstComponentDecl unknownInstComponentDecl() {
        UnknownInstComponentDecl unknownInstComponentDecl_value = root().unknownInstComponentDecl();
        return unknownInstComponentDecl_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = false;
        return shouldBeDifferentiated_value;
    }
    /**
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:129")
    public ResolvedAccess unknownAccess() {
        ResolvedAccess unknownAccess_value = root().unknownAccess();
        return unknownAccess_value;
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
        AnnotationNode annotation_value = annotation(AnnotationNode.DEFAULT_EVALUATOR);
        return annotation_value;
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
        AnnotationNode annotation_InstContext_value = AnnotationNode.NO_ANNOTATION;
        return annotation_InstContext_value;
    }
    /**
     * Get the annotation node for a sub-node of this AST node's annotation, if any.
     * 
     * Path is interpreted as a "/"-separated list of names of nested annotations.
     * 
     * Example:
     * <code>annotation(A(B(C = "foo")));</code>
     * Here the annotation given by the path <code>"A/B/C"</code> has the value <code>"foo"</code>.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:55")
    public AnnotationNode annotation(String path) {
        AnnotationNode annotation_String_value = annotation().forPath(path);
        return annotation_String_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:57")
    public AnnotationNode annotationOfChild(Opt n, InstContext instContext) {
        AnnotationNode annotationOfChild_Opt_InstContext_value = (n.getNumChild() > 0) ? n.getChild(0).annotation(instContext) : createNullAnnotationNode(instContext);
        return annotationOfChild_Opt_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:417
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:417")
    public AnnotationNode createNullAnnotationNode(InstContext instContext) {
        AnnotationNode createNullAnnotationNode_InstContext_value = AnnotationNode.NO_ANNOTATION;
        return createNullAnnotationNode_InstContext_value;
    }
    /**
     * Get the annotation node that represents this node when used as an annotation, if 
     * applicable.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:428")
    public AnnotationNode annotationNode(InstContext instContext) {
        AnnotationNode annotationNode_InstContext_value = createNullAnnotationNode(instContext);
        return annotationNode_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:61
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RootAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:61")
    public Root root() {
        Root root_value = retrieveRoot();
        return root_value;
    }
    /**
     * @attribute syn
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:69
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RootAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:69")
    public ArrayList emptyArrayList() {
        ArrayList emptyArrayList_value = EMPTY_ARRAY_LIST;
        return emptyArrayList_value;
    }
    /**
     * Returns the starting line for this node, or zero if positional
     * information is unavailable.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:335
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:335")
    public int beginLine() {
        int beginLine_value = getLine(getStart());
        return beginLine_value;
    }
    /**
     * Returns the starting column for this node, or zero if positional
     * information is unavailable.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:340
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:340")
    public int beginColumn() {
        int beginColumn_value = getColumn(getStart());
        return beginColumn_value;
    }
    /**
     * Returns the ending line for this node, or zero if positional
     * information is unavailable.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:345")
    public int endLine() {
        int endLine_value = getLine(getEnd());
        return endLine_value;
    }
    /**
     * Returns the ending column for this node, or zero if positional
     * information is unavailable.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:350
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:350")
    public int endColumn() {
        int endColumn_value = getColumn(getEnd());
        return endColumn_value;
    }
    /**
     * Returns the starting line for this node, or if unavailable, will make a
     * recursive call to the parent and ask for its starting line. Zero is
     * returned if positional information is unavailable for this node and its
     * parents.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:358
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:358")
    public int beginLineRecursive() {
        int beginLineRecursive_value = (start != 0 || getParent() == null)
                    ? beginLine() : getParent().beginLineRecursive();
        return beginLineRecursive_value;
    }
    /**
     * Returns the starting column for this node, or if unavailable, will make
     * a recursive call to the parent and ask for its starting column. Zero is
     * returned if positional information is unavailable for this node and its
     * parents.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:366
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:366")
    public int beginColumnRecursive() {
        int beginColumnRecursive_value = (start != 0 || getParent() == null)
                    ? beginColumn() : getParent().beginColumnRecursive();
        return beginColumnRecursive_value;
    }
    /**
     * Returns the ending line for this node, or if unavailable, will make a
     * recursive call to the parent and ask for its ending line. Zero is
     * returned if positional information is unavailable for this node and its
     * parents.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:374
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:374")
    public int endLineRecursive() {
        int endLineRecursive_value = (end != 0 || getParent() == null)
                    ? endLine() : getParent().endLineRecursive();
        return endLineRecursive_value;
    }
    /**
     * Returns the ending column for this node, or if unavailable, will make a
     * recursive call to the parent and ask for its ending column. Zero is
     * returned if positional information is unavailable for this node and its
     * parents.
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:382
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:382")
    public int endColumnRecursive() {
        int endColumnRecursive_value = (end != 0 || getParent() == null)
                    ? endColumn() : getParent().endColumnRecursive();
        return endColumnRecursive_value;
    }
    /**
     * @attribute syn
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:681
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FileNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:681")
    public String dirName() {
        String dirName_value = fileName().replaceFirst("^[^\\\\/]*$", ".").replaceFirst("[\\\\/][^\\\\/]*$", "");
        return dirName_value;
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
        boolean matches_String_value = false;
        return matches_String_value;
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
        String extraMemoryUseInfo_value = "";
        return extraMemoryUseInfo_value;
    }
    /**
     * @attribute syn
     * @aspect EquationSolve
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:332
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="EquationSolve", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:332")
    public int nbrUses(String name) {
        {
        		int n = 0;
        		for (int i=0;i<getNumChild();i++) {
        			n += getChild(i).nbrUses(name);
        		}
        		return n;
        	}
    }
    /**
     * @attribute syn
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:30
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AbsoluteValue", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:30")
    public boolean isAbsoluteValue(InstClassDecl superClass) {
        {
                AnnotationNode an = annotation("absoluteValue");
                if (an.exists()) {
                    return !an.isBoolValue() || an.bool();
                } else {
                    return superClass == null || superClass.isAbsoluteValue();
                } 
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
        String xmlTag_value = null;
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
        String xmlNamespace_value = null;
        return xmlNamespace_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:660
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:660")
    public boolean hasEventIndicator() {
        {
                for (ASTNode n : this) {
                    if (n.hasEventIndicator()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenAlgorithms", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55")
    public String assignMacroType(FType type) {
        String assignMacroType_FType_value = type.macroType();
        return assignMacroType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:46")
    public String nextTempName_C() {
        String nextTempName_C_value = myCodeGenContext().nextTempName_C();
        return nextTempName_C_value;
    }
    /**
     * @attribute syn
     * @aspect CodeSplitter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeSplitter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196")
    public int numScalars_C() {
        {
                int n = 0;
                for (ASTNode node : this) {
                    n += node.numScalars_C();
                }
                return n;
            }
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1094
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1094")
    public String htmlPrintWrapTag() {
        String htmlPrintWrapTag_value = null;
        return htmlPrintWrapTag_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1095")
    public String htmlPrintWrapTagClass() {
        String htmlPrintWrapTagClass_value = null;
        return htmlPrintWrapTagClass_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096")
    public String[][] htmlPrintWrapTagAttributes() {
        String[][] htmlPrintWrapTagAttributes_value = null;
        return htmlPrintWrapTagAttributes_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1097
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1097")
    public Object htmlPrintLocalObject() {
        Object htmlPrintLocalObject_value = this;
        return htmlPrintLocalObject_value;
    }
    /**
     * Does a recursive AST traversation up to the first encountered FFunctionDecl. The FFunctionDecl has an hash map that contains 
     * MX symbolic variables for records, and the MX for the passed in key (which should be equal to the FAccess of the variable) is returned. 
     * @param A String 
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:621
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:621")
    public MX getMXVariableFromRecordHashMap(String key) {
        {
                if (getParent() != null) {
                    return getParent().getMXVariableFromRecordHashMap(key);
                } else {
                    return null;
                }
            }
    }
    /**
     * Check is this node is in a function.
     * @attribute inh
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1409")
    public boolean inFunction() {
        boolean inFunction_value = getParent().Define_inFunction(this, null);
        return inFunction_value;
    }
    /**
     * @attribute inh
     * @aspect ErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:580
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:580")
    public InstComponentDecl errorEnclosingComponent() {
        InstComponentDecl errorEnclosingComponent_value = getParent().Define_errorEnclosingComponent(this, null);
        return errorEnclosingComponent_value;
    }
    /**
     * Can <code>node</code> be replaced as seen from here?
     * @attribute inh
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1411
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="InstanceErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1411")
    public boolean canBeReplacedForMe(InstNode node) {
        boolean canBeReplacedForMe_InstNode_value = getParent().Define_canBeReplacedForMe(this, null, node);
        return canBeReplacedForMe_InstNode_value;
    }
    /**
     * Lookup helper method for SrcAccess and SrcClassDecl. Obtain the SrcClassDecl
     * by looking after the target class one "name" piece at a time in the correct scope.
     * @attribute inh
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278")
    public ResolvedAccess simpleLookupHelper(String name) {
        ResolvedAccess simpleLookupHelper_String_value = getParent().Define_simpleLookupHelper(this, null, name);
        return simpleLookupHelper_String_value;
    }
    /**
     * @attribute inh
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="RootAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:59")
    public Root retrieveRoot() {
        Root retrieveRoot_value = getParent().Define_retrieveRoot(this, null);
        return retrieveRoot_value;
    }
    /**
     * @attribute inh
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FileNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691")
    public String retrieveFileName() {
        String retrieveFileName_value = getParent().Define_retrieveFileName(this, null);
        return retrieveFileName_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:857")
    public String packagePath(String name) {
        String packagePath_String_value = getParent().Define_packagePath(this, null, name);
        return packagePath_String_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:868")
    public String topPackagePath() {
        String topPackagePath_value = getParent().Define_topPackagePath(this, null);
        return topPackagePath_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:899
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:899")
    public InstClassDecl enclosingInstClassDecl() {
        InstClassDecl enclosingInstClassDecl_value = getParent().Define_enclosingInstClassDecl(this, null);
        return enclosingInstClassDecl_value;
    }
    /**
     * @attribute inh
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Names", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:912")
    public SrcBaseClassDecl enclosingClassDecl() {
        SrcBaseClassDecl enclosingClassDecl_value = getParent().Define_enclosingClassDecl(this, null);
        return enclosingClassDecl_value;
    }
    /**
     * Check if this node is in a disabled condition component.
     * 
     * Only valid in instance tree.
     * @attribute inh
     * @aspect ComponentDeclMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1538
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ComponentDeclMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1538")
    public boolean inDisabledComponent() {
        boolean inDisabledComponent_value = getParent().Define_inDisabledComponent(this, null);
        return inDisabledComponent_value;
    }
    /**
     * @attribute inh
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="GeneralHelpers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876")
    public boolean isFirst() {
        boolean isFirst_value = getParent().Define_isFirst(this, null);
        return isFirst_value;
    }
    /**
     * @attribute inh
     * @aspect GeneralHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="GeneralHelpers", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880")
    public boolean isLast() {
        boolean isLast_value = getParent().Define_isLast(this, null);
        return isLast_value;
    }
    /**
     * @attribute inh
     * @aspect CCodeGenNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="CCodeGenNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:48")
    public CodeGenContext myCodeGenContext() {
        CodeGenContext myCodeGenContext_value = getParent().Define_myCodeGenContext(this, null);
        return myCodeGenContext_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1142
     * @apilevel internal
     */
    public Size Define_defaultSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return Size.SCALAR;
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
        int childIndex = this.getIndexOfChild(_callerNode);
        return Size.SCALAR;
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     */
    public boolean Define_inArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArray
     */
    protected boolean canDefine_inArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     */
    public FType Define_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inferredType
     */
    protected boolean canDefine_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     */
    public Precedence Define_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return Precedence.LOWEST;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveParentPrecedence
     */
    protected boolean canDefine_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170
     * @apilevel internal
     */
    public boolean Define_isForIndex(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:170
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForIndex
     */
    protected boolean canDefine_isForIndex(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     */
    public boolean Define_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1461
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallClause
     */
    protected boolean canDefine_isFunctionCallClause(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1026
     * @apilevel internal
     */
    public SrcAccess Define_retrieveTopAccess(ASTNode _callerNode, ASTNode _childNode, SrcAccess pre) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return pre;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1026
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveTopAccess
     */
    protected boolean canDefine_retrieveTopAccess(ASTNode _callerNode, ASTNode _childNode, SrcAccess pre) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876
     * @apilevel internal
     */
    public boolean Define_isFirst(ASTNode _callerNode, ASTNode _childNode) {
        int i = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFirst
     */
    protected boolean canDefine_isFirst(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880
     * @apilevel internal
     */
    public boolean Define_isLast(ASTNode _callerNode, ASTNode _childNode) {
        int i = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLast
     */
    protected boolean canDefine_isLast(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872
     * @apilevel internal
     */
    public String Define_myForIndexName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:872
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myForIndexName
     */
    protected boolean canDefine_myForIndexName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876
     * @apilevel internal
     */
    public FExp Define_scalarizeIterIndex(ASTNode _callerNode, ASTNode _childNode, Scalarizer s) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:876
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute scalarizeIterIndex
     */
    protected boolean canDefine_scalarizeIterIndex(ASTNode _callerNode, ASTNode _childNode, Scalarizer s) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        if (state().peek() == ASTState.REWRITE_CHANGE) {
            state().pop();
            state().push(ASTState.REWRITE_NOCHANGE);
        }
        return this;
    }
    /** @apilevel internal */
    public CValue Define_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_cevalRecordMember(self, _callerNode, evaluator, access)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_cevalRecordMember(self, _callerNode, evaluator, access);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2756
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute cevalRecordMember
     */
    protected boolean canDefine_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_retrieveShouldHaveParenthesis(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveShouldHaveParenthesis(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveShouldHaveParenthesis(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:85
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveShouldHaveParenthesis
     */
    protected boolean canDefine_retrieveShouldHaveParenthesis(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isFunctionCallArg(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isFunctionCallArg(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3327
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallArg
     */
    protected boolean canDefine_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isLeftHandSide(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isLeftHandSide(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3362
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLeftHandSide
     */
    protected boolean canDefine_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isAssignedTo(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isAssignedTo(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3372
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignedTo
     */
    protected boolean canDefine_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isGlobalAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isGlobalAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:163
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGlobalAccess
     */
    protected boolean canDefine_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFArray(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFArray(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1872
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFArray
     */
    protected boolean canDefine_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_copyReplaceAccessParent(self, _callerNode, crp)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_copyReplaceAccessParent(self, _callerNode, crp);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:563
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute copyReplaceAccessParent
     */
    protected boolean canDefine_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isConstructorAssign(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isConstructorAssign(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorAssign
     */
    protected boolean canDefine_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isModificationName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isModificationName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isModificationName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1171
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isModificationName
     */
    protected boolean canDefine_isModificationName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isExpandableConnectorMemberInConnect(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isExpandableConnectorMemberInConnect(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:115
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isExpandableConnectorMemberInConnect
     */
    protected boolean canDefine_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inConnectWithExistingComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inConnectWithExistingComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inConnectWithExistingComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:121
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inConnectWithExistingComponent
     */
    protected boolean canDefine_inConnectWithExistingComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inAllowUnknownSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inAllowUnknownSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:528
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAllowUnknownSize
     */
    protected boolean canDefine_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_accessToModelOK(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_accessToModelOK(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:847
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessToModelOK
     */
    protected boolean canDefine_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isDestructorArgument(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isDestructorArgument(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1533
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorArgument
     */
    protected boolean canDefine_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isMultipliedWith(ASTNode _callerNode, ASTNode _childNode, FVariable v) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isMultipliedWith(self, _callerNode, v)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isMultipliedWith(self, _callerNode, v);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:338
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isMultipliedWith
     */
    protected boolean canDefine_isMultipliedWith(ASTNode _callerNode, ASTNode _childNode, FVariable v) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_flattenFASContext(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_flattenFASContext(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:167
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute flattenFASContext
     */
    protected boolean canDefine_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_canInlineConstant(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_canInlineConstant(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:277
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isGeneratedInner(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isGeneratedInner(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:112
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGeneratedInner
     */
    protected boolean canDefine_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInstRecordConstructorArg(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInstRecordConstructorArg(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:92
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstRecordConstructorArg
     */
    protected boolean canDefine_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupRecordConstructorVirtualInstComponentDecl(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupRecordConstructorVirtualInstComponentDecl(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:110
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupRecordConstructorVirtualInstComponentDecl
     */
    protected boolean canDefine_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupConstrainingInstClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupConstrainingInstClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:351
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstClass
     */
    protected boolean canDefine_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupConstrainingInstComponent(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupConstrainingInstComponent(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:386
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstComponent
     */
    protected boolean canDefine_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findClosestConstrainingInstNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findClosestConstrainingInstNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:414
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findClosestConstrainingInstNode
     */
    protected boolean canDefine_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inheritsFinal(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inheritsFinal(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:777
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsFinal
     */
    protected boolean canDefine_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isExpandableConnectorMember(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isExpandableConnectorMember(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isExpandableConnectorMember(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1811
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isExpandableConnectorMember
     */
    protected boolean canDefine_isExpandableConnectorMember(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_myExpandableConnectorTemplate(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myExpandableConnectorTemplate(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myExpandableConnectorTemplate(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1824
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myExpandableConnectorTemplate
     */
    protected boolean canDefine_myExpandableConnectorTemplate(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupBypassDot(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupBypassDot(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupBypassDot(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:478
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupBypassDot
     */
    protected boolean canDefine_simpleLookupBypassDot(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isSubExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isSubExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:305
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isSubExp
     */
    protected boolean canDefine_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcExp Define_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:316
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExp
     */
    protected boolean canDefine_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Object Define_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFunctionArgumentIdentifier(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFunctionArgumentIdentifier(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:387
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionArgumentIdentifier
     */
    protected boolean canDefine_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_parentAnnotationName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentAnnotationName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentAnnotationName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:202
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentAnnotationName
     */
    protected boolean canDefine_parentAnnotationName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public BaseNode Define_parentWithLocation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentWithLocation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentWithLocation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:285
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentWithLocation
     */
    protected boolean canDefine_parentWithLocation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveFileName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveFileName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:693
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFileName
     */
    protected boolean canDefine_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingInstComponentDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingInstComponentDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:908
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstComponentDecl
     */
    protected boolean canDefine_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstAccess Define_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_getNextInstAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_getNextInstAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:977
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getNextInstAccess
     */
    protected boolean canDefine_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstAccess Define_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveTopInstAccess(self, _callerNode, pre)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveTopInstAccess(self, _callerNode, pre);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1041
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveTopInstAccess
     */
    protected boolean canDefine_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inQualified(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inQualified(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1048
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inQualified
     */
    protected boolean canDefine_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAccessExp Define_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inlineUsesFunctionCallLeft(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inlineUsesFunctionCallLeft(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:631
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inlineUsesFunctionCallLeft
     */
    protected boolean canDefine_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_myTopFactorFExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myTopFactorFExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myTopFactorFExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:631
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTopFactorFExp
     */
    protected boolean canDefine_myTopFactorFExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isFunctionCallIO(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isFunctionCallIO(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:127
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallIO
     */
    protected boolean canDefine_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isForIndexExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isForIndexExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:133
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForIndexExp
     */
    protected boolean canDefine_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isFVectorFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isFVectorFunctionCallArg(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isFVectorFunctionCallArg(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:137
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFVectorFunctionCallArg
     */
    protected boolean canDefine_isFVectorFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_shouldRewriteToDSRef(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_shouldRewriteToDSRef(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_shouldRewriteToDSRef(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:88
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute shouldRewriteToDSRef
     */
    protected boolean canDefine_shouldRewriteToDSRef(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_parentXmlNamespace(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentXmlNamespace(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentXmlNamespace(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:752
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentXmlNamespace
     */
    protected boolean canDefine_parentXmlNamespace(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isTopStringOp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isTopStringOp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isTopStringOp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1026
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopStringOp
     */
    protected boolean canDefine_isTopStringOp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inArraySubscripts(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inArraySubscripts(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:33
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArraySubscripts
     */
    protected boolean canDefine_inArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public ArrayList<FArraySubscripts> Define_surroundingFArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingFArraySubscripts(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingFArraySubscripts(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:415
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFArraySubscripts
     */
    protected boolean canDefine_surroundingFArraySubscripts(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonVariableDecl Define_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingVariableDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingVariableDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:693
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingVariableDecl
     */
    protected boolean canDefine_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExpSubscript Define_surroundingFExpSubscript(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingFExpSubscript(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingFExpSubscript(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1303
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFExpSubscript
     */
    protected boolean canDefine_surroundingFExpSubscript(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_hasParentRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_hasParentRecordWithBindingExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_hasParentRecordWithBindingExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2747
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute hasParentRecordWithBindingExp
     */
    protected boolean canDefine_hasParentRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CValue Define_cevalParentRecord(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_cevalParentRecord(self, _callerNode, evaluator)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_cevalParentRecord(self, _callerNode, evaluator);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2767
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute cevalParentRecord
     */
    protected boolean canDefine_cevalParentRecord(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_duringFunctionEval(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_duringFunctionEval(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3429
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute duringFunctionEval
     */
    protected boolean canDefine_duringFunctionEval(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isConstructorStmt(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isConstructorStmt(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:157
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorStmt
     */
    protected boolean canDefine_isConstructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isDestructorStmt(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isDestructorStmt(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:162
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorStmt
     */
    protected boolean canDefine_isDestructorStmt(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_myDims(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myDims(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myDims(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Dims.jrag:25
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myDims
     */
    protected boolean canDefine_myDims(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_valueReference(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_valueReference(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_valueReference(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1128
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute valueReference
     */
    protected boolean canDefine_valueReference(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FStatement Define_myFStatement(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFStatement(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFStatement(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2173
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFStatement
     */
    protected boolean canDefine_myFStatement(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Set<FVariable> Define_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_boundParameters(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_boundParameters(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2263
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute boundParameters
     */
    protected boolean canDefine_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2306
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFEquation
     */
    protected boolean canDefine_inFEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractEquation Define_myFEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2311
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFEquation
     */
    protected boolean canDefine_myFEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FClass Define_myFClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2326
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFClass
     */
    protected boolean canDefine_myFClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractEquation Define_enclosingEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2338
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingEquation
     */
    protected boolean canDefine_enclosingEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isParameterEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isParameterEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2415
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isParameterEquation
     */
    protected boolean canDefine_isParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isNormalEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isNormalEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2421
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isNormalEquation
     */
    protected boolean canDefine_isNormalEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public List<FAbstractEquation> Define_myFAbstractEquationList(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFAbstractEquationList(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFAbstractEquationList(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2427
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFAbstractEquationList
     */
    protected boolean canDefine_myFAbstractEquationList(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inRecord(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inRecord(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3148
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecord
     */
    protected boolean canDefine_inRecord(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inRecordDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inRecordDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordDecl
     */
    protected boolean canDefine_inRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inRecordConstructor(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inRecordConstructor(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inRecordConstructor(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3162
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordConstructor
     */
    protected boolean canDefine_inRecordConstructor(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FRecordDecl Define_containingRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingRecordDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingRecordDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3191
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingRecordDecl
     */
    protected boolean canDefine_containingRecordDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isBound(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isBound(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isBound(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3380
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBound
     */
    protected boolean canDefine_isBound(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inParamBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inParamBindingExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inParamBindingExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3385
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inParamBindingExp
     */
    protected boolean canDefine_inParamBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public TypePrefixVariability Define_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_bindingExpVariability(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_bindingExpVariability(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3391
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute bindingExpVariability
     */
    protected boolean canDefine_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAlgorithm Define_myFAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFAlgorithm(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFAlgorithm(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4232
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFAlgorithm
     */
    protected boolean canDefine_myFAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_useIsAssignment(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_useIsAssignment(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4248
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute useIsAssignment
     */
    protected boolean canDefine_useIsAssignment(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FDerivedType Define_findFDerivedType(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findFDerivedType(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findFDerivedType(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:38
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findFDerivedType
     */
    protected boolean canDefine_findFDerivedType(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractVariable Define_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupFV(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupFV(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:2084
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFV
     */
    protected boolean canDefine_lookupFV(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractVariable Define_lookupGlobalVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupGlobalVariable(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupGlobalVariable(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:157
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupGlobalVariable
     */
    protected boolean canDefine_lookupGlobalVariable(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inParameterEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inParameterEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:244
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inParameterEquation
     */
    protected boolean canDefine_inParameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inAttributeValue(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inAttributeValue(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:251
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAttributeValue
     */
    protected boolean canDefine_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FCallable Define_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupFCallable(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupFCallable(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:270
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFCallable
     */
    protected boolean canDefine_lookupFCallable(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public FRecordDecl Define_lookupFRec(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupFRec(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupFRec(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:309
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFRec
     */
    protected boolean canDefine_lookupFRec(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public FEnumDecl Define_lookupFEnum(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupFEnum(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupFEnum(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:339
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupFEnum
     */
    protected boolean canDefine_lookupFEnum(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public int Define_forIndexIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_forIndexIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_forIndexIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:469
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute forIndexIndex
     */
    protected boolean canDefine_forIndexIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFunction(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFunction(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFunction(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1413
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunction
     */
    protected boolean canDefine_inFunction(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_extendsInFunction(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_extendsInFunction(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_extendsInFunction(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1418
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute extendsInFunction
     */
    protected boolean canDefine_extendsInFunction(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FFunctionDecl Define_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingFFunctionDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingFFunctionDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1429
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingFFunctionDecl
     */
    protected boolean canDefine_containingFFunctionDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_containingEntity(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingEntity(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingEntity(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1437
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingEntity
     */
    protected boolean canDefine_containingEntity(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_insideBlockStmt(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_insideBlockStmt(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1472
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute insideBlockStmt
     */
    protected boolean canDefine_insideBlockStmt(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_insideBranchedStmt(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_insideBranchedStmt(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_insideBranchedStmt(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1477
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute insideBranchedStmt
     */
    protected boolean canDefine_insideBranchedStmt(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractFunctionCall Define_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFunctionCall(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFunctionCall(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1544
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionCall
     */
    protected boolean canDefine_myFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inEquationSection(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inEquationSection(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1773
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inEquationSection
     */
    protected boolean canDefine_inEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inInitialEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inInitialEquationSection(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inInitialEquationSection(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1778
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInitialEquationSection
     */
    protected boolean canDefine_inInitialEquationSection(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1782
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inEquation
     */
    protected boolean canDefine_inEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_mySize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_mySize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_mySize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:50
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute mySize
     */
    protected boolean canDefine_mySize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonAccessExp Define_buildAccessContextSizeExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_buildAccessContextSizeExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_buildAccessContextSizeExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:171
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute buildAccessContextSizeExp
     */
    protected boolean canDefine_buildAccessContextSizeExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public List<InstAccess> Define_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_accessContextInst(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_accessContextInst(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:212
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextInst
     */
    protected boolean canDefine_accessContextInst(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public List<FAccessPart> Define_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_accessContextFlat(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_accessContextFlat(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:217
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessContextFlat
     */
    protected boolean canDefine_accessContextFlat(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonVariableDecl Define_myConstructorOutput(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myConstructorOutput(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myConstructorOutput(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:212
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myConstructorOutput
     */
    protected boolean canDefine_myConstructorOutput(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inWhile(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inWhile(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inWhile(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:87
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhile
     */
    protected boolean canDefine_inWhile(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inAssert(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inAssert(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inAssert(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:208
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAssert
     */
    protected boolean canDefine_inAssert(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inIfTestWithoutConnect(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inIfTestWithoutConnect(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ComplianceCheck.jadd:213
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIfTestWithoutConnect
     */
    protected boolean canDefine_inIfTestWithoutConnect(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isForOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isForOperatorRecordDeclarationMember(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isForOperatorRecordDeclarationMember(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:231
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForOperatorRecordDeclarationMember
     */
    protected boolean canDefine_isForOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_iterExpUseOK(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_iterExpUseOK(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:379
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpUseOK
     */
    protected boolean canDefine_iterExpUseOK(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_myOperatorRecord(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myOperatorRecord(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myOperatorRecord(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:843
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myOperatorRecord
     */
    protected boolean canDefine_myOperatorRecord(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_myAccessExists(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myAccessExists(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myAccessExists(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1176
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myAccessExists
     */
    protected boolean canDefine_myAccessExists(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_canBeReplacedForMe(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_canBeReplacedForMe(self, _callerNode, node)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_canBeReplacedForMe(self, _callerNode, node);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1412
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canBeReplacedForMe
     */
    protected boolean canDefine_canBeReplacedForMe(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_canBeReplacedInHelper(ASTNode _callerNode, ASTNode _childNode, InstNode ancestor) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_canBeReplacedInHelper(self, _callerNode, ancestor)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_canBeReplacedInHelper(self, _callerNode, ancestor);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1433
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canBeReplacedInHelper
     */
    protected boolean canDefine_canBeReplacedInHelper(ASTNode _callerNode, ASTNode _childNode, InstNode ancestor) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isWithin(ASTNode _callerNode, ASTNode _childNode, InstClassDecl icd) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isWithin(self, _callerNode, icd)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isWithin(self, _callerNode, icd);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1577
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isWithin
     */
    protected boolean canDefine_isWithin(ASTNode _callerNode, ASTNode _childNode, InstClassDecl icd) {
        return false;
    }
    /** @apilevel internal */
    public ASTNode Define_nameCollisionScope(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_nameCollisionScope(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_nameCollisionScope(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:181
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute nameCollisionScope
     */
    protected boolean canDefine_nameCollisionScope(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inRecordWithBindingExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inRecordWithBindingExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:306
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inRecordWithBindingExp
     */
    protected boolean canDefine_inRecordWithBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInRedeclareMod(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInRedeclareMod(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInRedeclareMod(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:407
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInRedeclareMod
     */
    protected boolean canDefine_isInRedeclareMod(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inCardinality(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inCardinality(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inCardinality(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:788
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inCardinality
     */
    protected boolean canDefine_inCardinality(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_iterExpMustBeScalar(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_iterExpMustBeScalar(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:856
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpMustBeScalar
     */
    protected boolean canDefine_iterExpMustBeScalar(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FType Define_myIndexType(ASTNode _callerNode, ASTNode _childNode, int i) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myIndexType(self, _callerNode, i)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myIndexType(self, _callerNode, i);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1072
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myIndexType
     */
    protected boolean canDefine_myIndexType(ASTNode _callerNode, ASTNode _childNode, int i) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_myFlowVar(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFlowVar(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFlowVar(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:625
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFlowVar
     */
    protected boolean canDefine_myFlowVar(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_findCellUp(ASTNode _callerNode, ASTNode _childNode, Index i, int j, InstComponentDecl src) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findCellUp(self, _callerNode, i, j, src)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findCellUp(self, _callerNode, i, j, src);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1267
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findCellUp
     */
    protected boolean canDefine_findCellUp(ASTNode _callerNode, ASTNode _childNode, Index i, int j, InstComponentDecl src) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_findExpandableAncestor(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findExpandableAncestor(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findExpandableAncestor(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3011
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findExpandableAncestor
     */
    protected boolean canDefine_findExpandableAncestor(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_ancestorChild(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl a, InstComponentDecl c) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_ancestorChild(self, _callerNode, a, c)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_ancestorChild(self, _callerNode, a, c);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:3024
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute ancestorChild
     */
    protected boolean canDefine_ancestorChild(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl a, InstComponentDecl c) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isFlattened(self, _callerNode, ivm)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isFlattened(self, _callerNode, ivm);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:378
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFlattened
     */
    protected boolean canDefine_isFlattened(ASTNode _callerNode, ASTNode _childNode, InstValueModification ivm) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentBindingFExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentBindingFExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1790
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentBindingFExp
     */
    protected boolean canDefine_parentBindingFExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_splitBindingFExp(ASTNode _callerNode, ASTNode _childNode, FExp fe, InstNode node, int dims) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_splitBindingFExp(self, _callerNode, fe, node, dims)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_splitBindingFExp(self, _callerNode, fe, node, dims);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1830
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute splitBindingFExp
     */
    protected boolean canDefine_splitBindingFExp(ASTNode _callerNode, ASTNode _childNode, FExp fe, InstNode node, int dims) {
        return false;
    }
    /** @apilevel internal */
    public InstValueModification Define_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentInstValueMod(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentInstValueMod(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2061
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentInstValueMod
     */
    protected boolean canDefine_parentInstValueMod(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_modificationLevel(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_modificationLevel(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_modificationLevel(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2178
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute modificationLevel
     */
    protected boolean canDefine_modificationLevel(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_parentNodeToSetModLevelFor(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentNodeToSetModLevelFor(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentNodeToSetModLevelFor(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2214
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentNodeToSetModLevelFor
     */
    protected boolean canDefine_parentNodeToSetModLevelFor(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_expandSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_expandSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_expandSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2308
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandSize
     */
    protected boolean canDefine_expandSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_myFExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myFExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myFExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2745
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFExp
     */
    protected boolean canDefine_myFExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAccess Define_retrieveFAccessFromModification(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveFAccessFromModification(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveFAccessFromModification(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:220
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccessFromModification
     */
    protected boolean canDefine_retrieveFAccessFromModification(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_myTempVarName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myTempVarName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myTempVarName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:237
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTempVarName
     */
    protected boolean canDefine_myTempVarName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_breakCondName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_breakCondName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_breakCondName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningStatements.jrag:244
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute breakCondName
     */
    protected boolean canDefine_breakCondName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inOuter(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inOuter(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inOuter(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:25
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inOuter
     */
    protected boolean canDefine_inOuter(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inInner(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inInner(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inInner(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:31
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInner
     */
    protected boolean canDefine_inInner(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_surroundingOuterComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingOuterComponentDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingOuterComponentDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:36
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingOuterComponentDecl
     */
    protected boolean canDefine_surroundingOuterComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_lookupInnerInstComponent(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl outer, boolean firstScope) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInnerInstComponent(self, _callerNode, outer, firstScope)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInnerInstComponent(self, _callerNode, outer, firstScope);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:53
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInnerInstComponent
     */
    protected boolean canDefine_lookupInnerInstComponent(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl outer, boolean firstScope) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_lookupInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name, boolean firstScope) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInnerInstClass(self, _callerNode, name, firstScope)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInnerInstClass(self, _callerNode, name, firstScope);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:135
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInnerInstClass
     */
    protected boolean canDefine_lookupInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name, boolean firstScope) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_lookupInInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInInnerInstClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInInnerInstClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:149
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInInnerInstClass
     */
    protected boolean canDefine_lookupInInnerInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassFromMod(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstClassFromMod(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstClassFromMod(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:71
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassFromMod
     */
    protected boolean canDefine_lookupInstClassFromMod(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassFromTop(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstClassFromTop(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstClassFromTop(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:153
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassFromTop
     */
    protected boolean canDefine_lookupInstClassFromTop(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupRedeclareExtendsInstClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupRedeclareExtendsInstClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:176
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupRedeclareExtendsInstClass
     */
    protected boolean canDefine_lookupRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupTopRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupTopRedeclareExtendsInstClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupTopRedeclareExtendsInstClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:191
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupTopRedeclareExtendsInstClass
     */
    protected boolean canDefine_lookupTopRedeclareExtendsInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstComponentDecl> Define_lookupInstConstant(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstConstant(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstConstant(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:637
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstConstant
     */
    protected boolean canDefine_lookupInstConstant(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstComponentDecl> Define_lookupInstReplacingComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstReplacingComponent(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstReplacingComponent(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:770
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstReplacingComponent
     */
    protected boolean canDefine_lookupInstReplacingComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_expectedSizeFromParent(ASTNode _callerNode, ASTNode _childNode, boolean useEach) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_expectedSizeFromParent(self, _callerNode, useEach)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_expectedSizeFromParent(self, _callerNode, useEach);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:322
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expectedSizeFromParent
     */
    protected boolean canDefine_expectedSizeFromParent(ASTNode _callerNode, ASTNode _childNode, boolean useEach) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_findInheritingNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findInheritingNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findInheritingNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:421
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findInheritingNode
     */
    protected boolean canDefine_findInheritingNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_surroundingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingInstClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingInstClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:431
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingInstClass
     */
    protected boolean canDefine_surroundingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public TypePrefixVariability Define_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_overrideVariability(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_overrideVariability(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:39
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute overrideVariability
     */
    protected boolean canDefine_overrideVariability(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public TypePrefixVariability Define_parentDefaultVariability(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentDefaultVariability(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentDefaultVariability(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:220
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentDefaultVariability
     */
    protected boolean canDefine_parentDefaultVariability(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Environment Define_myEnvironmentNoClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myEnvironmentNoClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myEnvironmentNoClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:540
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironmentNoClass
     */
    protected boolean canDefine_myEnvironmentNoClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Environment Define_myEnvironmentClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myEnvironmentClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myEnvironmentClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:542
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironmentClass
     */
    protected boolean canDefine_myEnvironmentClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myEnvironment(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myEnvironment(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:614
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myEnvironment(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myEnvironment(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:615
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstModification Define_surroundingInstModification(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingInstModification(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingInstModification(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:677
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingInstModification
     */
    protected boolean canDefine_surroundingInstModification(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstRedeclareClassNode Define_lookupReplacingClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupReplacingClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupReplacingClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:747
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupReplacingClass
     */
    protected boolean canDefine_lookupReplacingClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_myInstNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myInstNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myInstNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:779
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstNode
     */
    protected boolean canDefine_myInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_myParentInstNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myParentInstNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myParentInstNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:776
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myParentInstNode
     */
    protected boolean canDefine_myParentInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInInstModification(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInInstModification(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInInstModification(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1212
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInInstModification
     */
    protected boolean canDefine_isInInstModification(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inExpandableConnector(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inExpandableConnector(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inExpandableConnector(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1817
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inExpandableConnector
     */
    protected boolean canDefine_inExpandableConnector(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_instClassNamePrefix(ASTNode _callerNode, ASTNode _childNode, boolean sup) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_instClassNamePrefix(self, _callerNode, sup)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_instClassNamePrefix(self, _callerNode, sup);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1993
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instClassNamePrefix
     */
    protected boolean canDefine_instClassNamePrefix(ASTNode _callerNode, ASTNode _childNode, boolean sup) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2184
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInClassDecl
     */
    protected boolean canDefine_isInClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInComponentDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInComponentDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2199
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInComponentDecl
     */
    protected boolean canDefine_isInComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_enclosedBy(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosedBy(self, _callerNode, node)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosedBy(self, _callerNode, node);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2225
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosedBy
     */
    protected boolean canDefine_enclosedBy(ASTNode _callerNode, ASTNode _childNode, InstNode node) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_instNodeParent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_instNodeParent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_instNodeParent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2247
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instNodeParent
     */
    protected boolean canDefine_instNodeParent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_containingInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingInstComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingInstComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2290
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstComponent
     */
    protected boolean canDefine_containingInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_containingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingInstNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingInstNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2476
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstNode
     */
    protected boolean canDefine_containingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_containingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingInstClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingInstClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2481
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstClassDecl
     */
    protected boolean canDefine_containingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_instComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_instComponentDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_instComponentDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2616
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute instComponentDecl
     */
    protected boolean canDefine_instComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_delegateShouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_delegateShouldBeDifferentiated(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_delegateShouldBeDifferentiated(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:387
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute delegateShouldBeDifferentiated
     */
    protected boolean canDefine_delegateShouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_shouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode, AnnotationNode derNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_shouldBeDifferentiated(self, _callerNode, derNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_shouldBeDifferentiated(self, _callerNode, derNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:392
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute shouldBeDifferentiated
     */
    protected boolean canDefine_shouldBeDifferentiated(ASTNode _callerNode, ASTNode _childNode, AnnotationNode derNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inNonDiffArg(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inNonDiffArg(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inNonDiffArg(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:403
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inNonDiffArg
     */
    protected boolean canDefine_inNonDiffArg(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public List Define_getPredefinedType(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_getPredefinedType(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_getPredefinedType(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:30
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getPredefinedType
     */
    protected boolean canDefine_getPredefinedType(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_myIdenticalFunctionArgumentIdentifierIndex(ASTNode _callerNode, ASTNode _childNode, Object id) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myIdenticalFunctionArgumentIdentifierIndex(self, _callerNode, id)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myIdenticalFunctionArgumentIdentifierIndex(self, _callerNode, id);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:391
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myIdenticalFunctionArgumentIdentifierIndex
     */
    protected boolean canDefine_myIdenticalFunctionArgumentIdentifierIndex(ASTNode _callerNode, ASTNode _childNode, Object id) {
        return false;
    }
    /** @apilevel internal */
    public Root Define_retrieveRoot(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveRoot(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveRoot(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:60
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveRoot
     */
    protected boolean canDefine_retrieveRoot(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_classNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_classNamePrefix(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_classNamePrefix(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:315
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute classNamePrefix
     */
    protected boolean canDefine_classNamePrefix(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_packageName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_packageName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_packageName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:841
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute packageName
     */
    protected boolean canDefine_packageName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_findLibraryName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findLibraryName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findLibraryName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:854
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findLibraryName
     */
    protected boolean canDefine_findLibraryName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_packagePath(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_packagePath(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:863
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute packagePath
     */
    protected boolean canDefine_packagePath(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public String Define_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_topPackagePath(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_topPackagePath(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:874
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute topPackagePath
     */
    protected boolean canDefine_topPackagePath(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcBaseClassDecl Define_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:919
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingClassDecl
     */
    protected boolean canDefine_enclosingClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Set<SrcClassDecl> Define_enclosingClassDecls(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingClassDecls(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingClassDecls(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:924
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingClassDecls
     */
    protected boolean canDefine_enclosingClassDecls(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FStatement Define_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingLoop(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingLoop(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:935
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingLoop
     */
    protected boolean canDefine_enclosingLoop(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcAccess Define_getNextAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_getNextAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_getNextAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:964
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getNextAccess
     */
    protected boolean canDefine_getNextAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstAccess Define_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myInstAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myInstAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:993
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstAccess
     */
    protected boolean canDefine_myInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isPublic(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isPublic(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isPublic(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1206
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isPublic
     */
    protected boolean canDefine_isPublic(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inProtectedComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inProtectedComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1222
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inProtectedComponent
     */
    protected boolean canDefine_inProtectedComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_inheritsInputOutputFrom(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inheritsInputOutputFrom(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inheritsInputOutputFrom(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1395
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsInputOutputFrom
     */
    protected boolean canDefine_inheritsInputOutputFrom(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isTopLevel(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isTopLevel(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isTopLevel(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1408
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopLevel
     */
    protected boolean canDefine_isTopLevel(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_inheritsFlowFrom(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inheritsFlowFrom(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inheritsFlowFrom(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1439
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsFlowFrom
     */
    protected boolean canDefine_inheritsFlowFrom(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inDisabledComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inDisabledComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inDisabledComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1541
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inDisabledComponent
     */
    protected boolean canDefine_inDisabledComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_duringFunctionInlining(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_duringFunctionInlining(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_duringFunctionInlining(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1838
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute duringFunctionInlining
     */
    protected boolean canDefine_duringFunctionInlining(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_canPropagateContext(self, _callerNode, propagator)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_canPropagateContext(self, _callerNode, propagator);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:43
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canPropagateContext
     */
    protected boolean canDefine_canPropagateContext(ASTNode _callerNode, ASTNode _childNode, FClass.VariabilityPropagator propagator) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inKeptBExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inKeptBExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inKeptBExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:597
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inKeptBExp
     */
    protected boolean canDefine_inKeptBExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FIfWhenEquation Define_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingIfOrElse(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingIfOrElse(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1350
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingIfOrElse
     */
    protected boolean canDefine_surroundingIfOrElse(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inUnknownSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inUnknownSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:118
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inUnknownSize
     */
    protected boolean canDefine_inUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_enclosingIfExpCond(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingIfExpCond(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingIfExpCond(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\SizeAsserts.jrag:179
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingIfExpCond
     */
    protected boolean canDefine_enclosingIfExpCond(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isNegativeTerm(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isNegativeTerm(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isNegativeTerm(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:293
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isNegativeTerm
     */
    protected boolean canDefine_isNegativeTerm(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInvertedFactor(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInvertedFactor(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInvertedFactor(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Symbolic.jrag:300
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInvertedFactor
     */
    protected boolean canDefine_isInvertedFactor(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_needsIndicatorInit(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_needsIndicatorInit(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:572
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute needsIndicatorInit
     */
    protected boolean canDefine_needsIndicatorInit(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_hasBrancher(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_hasBrancher(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:592
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute hasBrancher
     */
    protected boolean canDefine_hasBrancher(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FExp Define_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentFExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentFExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:629
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentFExp
     */
    protected boolean canDefine_parentFExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFunctionArg(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFunctionArg(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFunctionArg(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:406
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionArg
     */
    protected boolean canDefine_inFunctionArg(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CodeGenContext Define_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myCodeGenContext(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myCodeGenContext(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenNames.jrag:52
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCodeGenContext
     */
    protected boolean canDefine_myCodeGenContext(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_parentTotalSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentTotalSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentTotalSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:602
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentTotalSize
     */
    protected boolean canDefine_parentTotalSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public List<FSubscript> Define_parentExpandedSubscripts(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentExpandedSubscripts(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentExpandedSubscripts(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:622
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExpandedSubscripts
     */
    protected boolean canDefine_parentExpandedSubscripts(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inAccessLocation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inAccessLocation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inAccessLocation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3474
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAccessLocation
     */
    protected boolean canDefine_inAccessLocation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isLinear(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isLinear(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3655
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLinear
     */
    protected boolean canDefine_isLinear(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isLinear(ASTNode _callerNode, ASTNode _childNode, Set<FVariable> vars) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isLinear(self, _callerNode, vars)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isLinear(self, _callerNode, vars);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3690
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLinear
     */
    protected boolean canDefine_isLinear(ASTNode _callerNode, ASTNode _childNode, Set<FVariable> vars) {
        return false;
    }
    /** @apilevel internal */
    public FEnumDecl Define_retrieveFEnumDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveFEnumDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveFEnumDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:327
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFEnumDecl
     */
    protected boolean canDefine_retrieveFEnumDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inNoEventExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inNoEventExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1788
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inNoEventExp
     */
    protected boolean canDefine_inNoEventExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inSmoothExp(ASTNode _callerNode, ASTNode _childNode, int order) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inSmoothExp(self, _callerNode, order)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inSmoothExp(self, _callerNode, order);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1794
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inSmoothExp
     */
    protected boolean canDefine_inSmoothExp(ASTNode _callerNode, ASTNode _childNode, int order) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inConnectClause(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inConnectClause(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inConnectClause(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1801
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inConnectClause
     */
    protected boolean canDefine_inConnectClause(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inIfCondition(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inIfCondition(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inIfCondition(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1810
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIfCondition
     */
    protected boolean canDefine_inIfCondition(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_errorEnclosingComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_errorEnclosingComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_errorEnclosingComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:593
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute errorEnclosingComponent
     */
    protected boolean canDefine_errorEnclosingComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inInstComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inInstComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:669
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inInstComponent
     */
    protected boolean canDefine_inInstComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inUnknownAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inUnknownAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inUnknownAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1096
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inUnknownAccess
     */
    protected boolean canDefine_inUnknownAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInstComponentSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInstComponentSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1119
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstComponentSize
     */
    protected boolean canDefine_isInstComponentSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_findTempVarName(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl var) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findTempVarName(self, _callerNode, var)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findTempVarName(self, _callerNode, var);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:296
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findTempVarName
     */
    protected boolean canDefine_findTempVarName(ASTNode _callerNode, ASTNode _childNode, InstComponentDecl var) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClass
     */
    protected boolean canDefine_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstClassInInstElement(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstClassInInstElement(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:650
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassInInstElement
     */
    protected boolean canDefine_lookupInstClassInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstBuiltInClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstBuiltInClass(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstBuiltInClass(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:755
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstBuiltInClass
     */
    protected boolean canDefine_lookupInstBuiltInClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstComponentDecl> Define_localLookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_localLookupInstComponent(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_localLookupInstComponent(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:440
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute localLookupInstComponent
     */
    protected boolean canDefine_localLookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstComponent(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstComponent(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:545
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponent
     */
    protected boolean canDefine_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstComponentInInstElement(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstComponentInInstElement(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:757
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponentInInstElement
     */
    protected boolean canDefine_lookupInstComponentInInstElement(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public Kind Define_kind(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_kind(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_kind(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstNameClassification.jrag:111
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute kind
     */
    protected boolean canDefine_kind(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inArrayComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inArrayComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inArrayComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:441
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArrayComponent
     */
    protected boolean canDefine_inArrayComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstEnumClassDecl Define_myInstEnumClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myInstEnumClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myInstEnumClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2074
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstEnumClassDecl
     */
    protected boolean canDefine_myInstEnumClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_myIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2079
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myIndex
     */
    protected boolean canDefine_myIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_dimensionLength(ASTNode _callerNode, ASTNode _childNode, int i) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_dimensionLength(self, _callerNode, i)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_dimensionLength(self, _callerNode, i);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2572
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute dimensionLength
     */
    protected boolean canDefine_dimensionLength(ASTNode _callerNode, ASTNode _childNode, int i) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_enclosingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingInstClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingInstClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:900
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstClassDecl
     */
    protected boolean canDefine_enclosingInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inForLoop(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inForLoop(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1260
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inForLoop
     */
    protected boolean canDefine_inForLoop(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inIterExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inIterExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:901
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inIterExp
     */
    protected boolean canDefine_inIterExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_expandSizeForIterExp(self, _callerNode, s)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_expandSizeForIterExp(self, _callerNode, s);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:909
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandSizeForIterExp
     */
    protected boolean canDefine_expandSizeForIterExp(ASTNode _callerNode, ASTNode _childNode, Size s) {
        return false;
    }
    /** @apilevel internal */
    public int Define_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_iterExpDepth(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_iterExpDepth(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1927
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute iterExpDepth
     */
    protected boolean canDefine_iterExpDepth(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_calcInstanceName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_calcInstanceName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:826
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcInstanceName
     */
    protected boolean canDefine_calcInstanceName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inDeadIfBranch(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inDeadIfBranch(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1571
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inDeadIfBranch
     */
    protected boolean canDefine_inDeadIfBranch(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFunctionCallLeft(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFunctionCallLeft(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3309
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionCallLeft
     */
    protected boolean canDefine_inFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isFunctionCallLeft(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isFunctionCallLeft(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3315
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallLeft
     */
    protected boolean canDefine_isFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inFunctionCall(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inFunctionCall(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3323
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFunctionCall
     */
    protected boolean canDefine_inFunctionCall(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonVariableDecl Define_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myCorrespondingInput(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myCorrespondingInput(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3351
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCorrespondingInput
     */
    protected boolean canDefine_myCorrespondingInput(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInFV(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInFV(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:307
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInFV(self, _callerNode, fv)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInFV(self, _callerNode, fv);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:317
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInDerivedType(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInDerivedType(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:327
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInDerivedType(self, _callerNode, t)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInDerivedType(self, _callerNode, t);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:337
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractEquation Define_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parameterEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parameterEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:189
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parameterEquation
     */
    protected boolean canDefine_parameterEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_functionIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_functionIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_functionIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:448
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionIndex
     */
    protected boolean canDefine_functionIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findVariableIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findVariableIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:463
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findVariableIndex
     */
    protected boolean canDefine_findVariableIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_recordIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_recordIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_recordIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:475
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute recordIndex
     */
    protected boolean canDefine_recordIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_enumIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enumIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enumIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:478
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enumIndex
     */
    protected boolean canDefine_enumIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inAlgorithm(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inAlgorithm(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1448
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAlgorithm
     */
    protected boolean canDefine_inAlgorithm(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_functionCallIsExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_functionCallIsExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1525
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallIsExp
     */
    protected boolean canDefine_functionCallIsExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public ArrayList<FFunctionCallLeft> Define_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myLefts(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myLefts(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1535
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myLefts
     */
    protected boolean canDefine_myLefts(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_calcGeneratedVarName(self, _callerNode, gvt)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_calcGeneratedVarName(self, _callerNode, gvt);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1573
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute calcGeneratedVarName
     */
    protected boolean canDefine_calcGeneratedVarName(ASTNode _callerNode, ASTNode _childNode, FlatVariableMap.GeneratedVarType gvt) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inWhen(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inWhen(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1815
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inWhen
     */
    protected boolean canDefine_inWhen(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isInitial(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isInitial(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1417
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInitial
     */
    protected boolean canDefine_isInitial(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractEquation Define_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_surroundingFAbstractEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_surroundingFAbstractEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:449
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingFAbstractEquation
     */
    protected boolean canDefine_surroundingFAbstractEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isTopWhenIfEquation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isTopWhenIfEquation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isTopWhenIfEquation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:575
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopWhenIfEquation
     */
    protected boolean canDefine_isTopWhenIfEquation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lockBranch(self, _callerNode, checkType)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lockBranch(self, _callerNode, checkType);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:447
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lockBranch
     */
    protected boolean canDefine_lockBranch(ASTNode _callerNode, ASTNode _childNode, ErrorCheckType checkType) {
        return false;
    }
    /** @apilevel internal */
    public FWhenEquation Define_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myWhen(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myWhen(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1776
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myWhen
     */
    protected boolean canDefine_myWhen(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FWhenEquation Define_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_findTopWhen(self, _callerNode, last)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_findTopWhen(self, _callerNode, last);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1786
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findTopWhen
     */
    protected boolean canDefine_findTopWhen(ASTNode _callerNode, ASTNode _childNode, FWhenEquation last) {
        return false;
    }
    /** @apilevel internal */
    public FAccess Define_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveFAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveFAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:215
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFAccess
     */
    protected boolean canDefine_retrieveFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isElse(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isElse(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isElse(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1946
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isElse
     */
    protected boolean canDefine_isElse(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isIndicator(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isIndicator(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:576
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isIndicator
     */
    protected boolean canDefine_isIndicator(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isAssignUse(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isAssignUse(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignUse
     */
    protected boolean canDefine_isAssignUse(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inSubscriptedExp(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inSubscriptedExp(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:34
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inSubscriptedExp
     */
    protected boolean canDefine_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonNamePart Define_nextNamePart(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_nextNamePart(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_nextNamePart(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:212
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute nextNamePart
     */
    protected boolean canDefine_nextNamePart(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractVariable Define_myContextFV(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myContextFV(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myContextFV(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:151
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myContextFV
     */
    protected boolean canDefine_myContextFV(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAccess Define_partialName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_partialName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_partialName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:843
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute partialName
     */
    protected boolean canDefine_partialName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_myDim(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myDim(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myDim(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:701
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myDim
     */
    protected boolean canDefine_myDim(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_outerCoeff(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_outerCoeff(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_outerCoeff(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\LinearEquationElimination.jrag:420
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute outerCoeff
     */
    protected boolean canDefine_outerCoeff(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_size(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_size(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_size(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1062
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute size
     */
    protected boolean canDefine_size(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_funcName(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_funcName(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_funcName(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1331
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute funcName
     */
    protected boolean canDefine_funcName(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_prevIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_prevIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1486
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute prevIndex
     */
    protected boolean canDefine_prevIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public CommonVariableDecl Define_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myOutput(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myOutput(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1517
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myOutput
     */
    protected boolean canDefine_myOutput(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FType Define_type(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_type(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_type(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2381
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute type
     */
    protected boolean canDefine_type(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_functionCallDecription(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_functionCallDecription(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1485
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute functionCallDecription
     */
    protected boolean canDefine_functionCallDecription(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_argumentDefinedTypeValid(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_argumentDefinedTypeValid(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_argumentDefinedTypeValid(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1683
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentDefinedTypeValid
     */
    protected boolean canDefine_argumentDefinedTypeValid(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_argumentTypeValid(ASTNode _callerNode, ASTNode _childNode, FType type) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_argumentTypeValid(self, _callerNode, type)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_argumentTypeValid(self, _callerNode, type);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1714
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentTypeValid
     */
    protected boolean canDefine_argumentTypeValid(ASTNode _callerNode, ASTNode _childNode, FType type) {
        return false;
    }
    /** @apilevel internal */
    public String Define_expectedArgumentType(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_expectedArgumentType(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_expectedArgumentType(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1752
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expectedArgumentType
     */
    protected boolean canDefine_expectedArgumentType(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_argumentTypeError(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_argumentTypeError(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_argumentTypeError(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1543
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute argumentTypeError
     */
    protected boolean canDefine_argumentTypeError(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public String Define_getKeyword(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_getKeyword(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_getKeyword(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1478
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getKeyword
     */
    protected boolean canDefine_getKeyword(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Collection<FExpSubscript> Define_mySubscriptUses(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_mySubscriptUses(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_mySubscriptUses(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:976
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute mySubscriptUses
     */
    protected boolean canDefine_mySubscriptUses(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public int Define_retrieveArrayCompNdims(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveArrayCompNdims(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveArrayCompNdims(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveArrayCompNdims
     */
    protected boolean canDefine_retrieveArrayCompNdims(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isForAttributeOnOperatorRecordDeclarationMember(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isForAttributeOnOperatorRecordDeclarationMember(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:227
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForAttributeOnOperatorRecordDeclarationMember
     */
    protected boolean canDefine_isForAttributeOnOperatorRecordDeclarationMember(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_myTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myTargetComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myTargetComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:499
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTargetComponent
     */
    protected boolean canDefine_myTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstComponentDecl Define_parentTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentTargetComponent(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentTargetComponent(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:505
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentTargetComponent
     */
    protected boolean canDefine_parentTargetComponent(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstModification Define_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentInstModification(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentInstModification(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:296
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentInstModification
     */
    protected boolean canDefine_parentInstModification(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inExternalObject(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inExternalObject(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inExternalObject(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1537
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inExternalObject
     */
    protected boolean canDefine_inExternalObject(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAccess Define_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_expandedFAccess(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_expandedFAccess(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:956
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute expandedFAccess
     */
    protected boolean canDefine_expandedFAccess(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inModWithEach(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inModWithEach(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inModWithEach(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2074
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inModWithEach
     */
    protected boolean canDefine_inModWithEach(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isOnPrimitiveTypeDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isOnPrimitiveTypeDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isOnPrimitiveTypeDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2166
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isOnPrimitiveTypeDecl
     */
    protected boolean canDefine_isOnPrimitiveTypeDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstLookupResult<InstClassDecl> Define_lookupInstClassInChain(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_lookupInstClassInChain(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_lookupInstClassInChain(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:145
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClassInChain
     */
    protected boolean canDefine_lookupInstClassInChain(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstModification Define_retrieveModificationLackingEach(ASTNode _callerNode, ASTNode _childNode, Size s) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_retrieveModificationLackingEach(self, _callerNode, s)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_retrieveModificationLackingEach(self, _callerNode, s);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:373
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveModificationLackingEach
     */
    protected boolean canDefine_retrieveModificationLackingEach(ASTNode _callerNode, ASTNode _childNode, Size s) {
        return false;
    }
    /** @apilevel internal */
    public AnnotationNode Define_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentEvalAnnotation(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentEvalAnnotation(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstVariability.jrag:142
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentEvalAnnotation
     */
    protected boolean canDefine_parentEvalAnnotation(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public int Define_myDimension(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myDimension(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myDimension(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2533
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myDimension
     */
    protected boolean canDefine_myDimension(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isBottomDimHelper(ASTNode _callerNode, ASTNode _childNode, int i) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isBottomDimHelper(self, _callerNode, i)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isBottomDimHelper(self, _callerNode, i);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2543
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBottomDimHelper
     */
    protected boolean canDefine_isBottomDimHelper(ASTNode _callerNode, ASTNode _childNode, int i) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isTopDimension(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isTopDimension(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isTopDimension(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2551
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopDimension
     */
    protected boolean canDefine_isTopDimension(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Index Define_parentIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2597
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentIndex
     */
    protected boolean canDefine_parentIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Size Define_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_vectorizedSize(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_vectorizedSize(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:420
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute vectorizedSize
     */
    protected boolean canDefine_vectorizedSize(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FAbstractFunctionCall Define_myCall(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myCall(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myCall(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:125
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myCall
     */
    protected boolean canDefine_myCall(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inVectorizedCall(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inVectorizedCall(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:910
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inVectorizedCall
     */
    protected boolean canDefine_inVectorizedCall(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public FType Define_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myInstForIndexType(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myInstForIndexType(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:69
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstForIndexType
     */
    protected boolean canDefine_myInstForIndexType(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_inheritedOriginHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inheritedOriginHelper(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inheritedOriginHelper(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2770
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritedOriginHelper
     */
    protected boolean canDefine_inheritedOriginHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public InstContext Define_parentExpEvaluator(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentExpEvaluator(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentExpEvaluator(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:108
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExpEvaluator
     */
    protected boolean canDefine_parentExpEvaluator(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcAnnotatable Define_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_elementModification(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_elementModification(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:2002
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute elementModification
     */
    protected boolean canDefine_elementModification(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstNode Define_enclosingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_enclosingInstNode(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_enclosingInstNode(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:897
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstNode
     */
    protected boolean canDefine_enclosingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_containingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_containingInstClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_containingInstClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:893
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute containingInstClass
     */
    protected boolean canDefine_containingInstClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public Index Define_parentTotalIndex(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_parentTotalIndex(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_parentTotalIndex(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:2610
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentTotalIndex
     */
    protected boolean canDefine_parentTotalIndex(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcClassDecl Define_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myTopSrcClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myTopSrcClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:316
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTopSrcClassDecl
     */
    protected boolean canDefine_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstClassDecl Define_myInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myInstClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myInstClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:814
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myInstClassDecl
     */
    protected boolean canDefine_myInstClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public InstRestriction Define_inheritedRestriction(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_inheritedRestriction(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_inheritedRestriction(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1512
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritedRestriction
     */
    protected boolean canDefine_inheritedRestriction(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcLibNode.LoadReason Define_loadReason(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_loadReason(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_loadReason(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:51
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute loadReason
     */
    protected boolean canDefine_loadReason(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public boolean Define_isBuiltInClass(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_isBuiltInClass(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_isBuiltInClass(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:23
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBuiltInClass
     */
    protected boolean canDefine_isBuiltInClass(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public SrcClassDecl Define_myClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myClassDecl(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myClassDecl(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:34
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myClassDecl
     */
    protected boolean canDefine_myClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupHelper(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupHelper(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:281
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupHelper
     */
    protected boolean canDefine_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupFromExtends(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupFromExtends(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:303
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromExtends
     */
    protected boolean canDefine_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupGlobalScope(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupGlobalScope(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupGlobalScope(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:312
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupGlobalScope
     */
    protected boolean canDefine_simpleLookupGlobalScope(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupPredefined(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupPredefined(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupPredefined(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:350
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupPredefined
     */
    protected boolean canDefine_simpleLookupPredefined(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public ResolvedAccess Define_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_simpleLookupFromValue(self, _callerNode, name)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_simpleLookupFromValue(self, _callerNode, name);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:293
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromValue
     */
    protected boolean canDefine_simpleLookupFromValue(ASTNode _callerNode, ASTNode _childNode, String name) {
        return false;
    }
    /** @apilevel internal */
    public SrcComponentClause Define_myComponentClause(ASTNode _callerNode, ASTNode _childNode) {
        ASTNode self = this;
        ASTNode parent = getParent();
        while (parent != null && !parent.canDefine_myComponentClause(self, _callerNode)) {
            _callerNode = self;
            self = parent;
            parent = self.getParent();
        }
        return parent.Define_myComponentClause(self, _callerNode);
    }

    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:213
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myComponentClause
     */
    protected boolean canDefine_myComponentClause(ASTNode _callerNode, ASTNode _childNode) {
        return false;
    }
public ASTNode rewrittenNode() { throw new Error("rewrittenNode is undefined for ASTNode"); }
}
