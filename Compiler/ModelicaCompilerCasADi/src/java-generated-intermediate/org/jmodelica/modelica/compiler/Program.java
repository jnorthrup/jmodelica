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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\Modelica.ast:67
 * @astdecl Program : SrcBaseNode ::= UnstructuredEntity:SrcStoredDefinition* SrcUnknownClassDecl UnknownComponent:SrcComponentClause EnumBaseDecl:SrcEnumClassDecl PredefinedType:SrcBaseClassDecl* BuiltInType:SrcClassDecl* BuiltInFunction:SrcBaseClassDecl* SrcLibNode* AnonymousClass:SrcBaseClassDecl* InstProgramRoot;
 * @production Program : {@link SrcBaseNode} ::= <span class="component">UnstructuredEntity:{@link SrcStoredDefinition}*</span> <span class="component">{@link SrcUnknownClassDecl}</span> <span class="component">UnknownComponent:{@link SrcComponentClause}</span> <span class="component">EnumBaseDecl:{@link SrcEnumClassDecl}</span> <span class="component">PredefinedType:{@link SrcBaseClassDecl}*</span> <span class="component">BuiltInType:{@link SrcClassDecl}*</span> <span class="component">BuiltInFunction:{@link SrcBaseClassDecl}*</span> <span class="component">{@link SrcLibNode}*</span> <span class="component">AnonymousClass:{@link SrcBaseClassDecl}*</span> <span class="component">{@link InstProgramRoot}</span>;

 */
public class Program extends SrcBaseNode implements Cloneable {
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:261
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
		for (SrcStoredDefinition sd : getUnstructuredEntitys()) {
			p.print(sd,str,indent);
		}
	}
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:803
     */
    private Map<String,SrcClassDecl> anonymousClassMap = null;
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:318
     */
    private LibraryList libraryList;
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:320
     */
    public LibraryList getLibraryList() {
        if (libraryList == null)
            libraryList = new DefaultLibraryList(myOptions());
        return libraryList;
    }
    /**
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:326
     */
    public void setLibraryList(LibraryList list) {
        libraryList = list;
    }
    /**
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:140
     */
    public static String makeBaseTypeDef(String name, String... lines) {
        StringBuilder buf = new StringBuilder();
        buf.append("type ");
        buf.append(name);
        buf.append("\n");
        for (String line : lines) {
            buf.append("    ");
            buf.append(line);
        }
        buf.append("end ");
        buf.append(name);
        buf.append(";\n");
        return buf.toString();
    }
    /**
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:155
     */
    public static String makeAttributeDef(String name, String type, String value) {
        StringBuilder buf = new StringBuilder();
        if (value != null) {
            buf.append("parameter ");
        }
        buf.append(type);
        buf.append("Type ");
        buf.append(name);
        if (value != null) {
            buf.append(" = ");
            buf.append(value);
        }
        buf.append(";\n");
        return buf.toString();
    }
    /**
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:171
     */
    public static String makeEnumDef(String name, String... items) {
        StringBuilder buf = new StringBuilder();
        buf.append("type ");
        buf.append(name);
        buf.append(" = enumeration(");
        boolean comma = false;
        for (String item : items) {
            if (comma) {
                buf.append(", ");
            } else {
                comma = true;
            }
            buf.append(item);
        }
        buf.append(");\n");
        return buf.toString();
    }
    /**
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:346
     */
    private static final String BUILTIN_FUNCS = 
              "function initial end initial;\n"
            + "function terminal end terminal;\n"
            + "function smooth\n"
            + "  input Integer p;\n"
            + "  input Real expr;\n"   // Type not used
            + "  output Real y;\n"     // Type not used
            + "end smooth;\n"
            + "function noEvent\n"
            + "  input Real expr;\n"   // Type not used
            + "  output Real y;\n"     // Type not used
            + "end noEvent;\n"
            + "function sample\n"
            + "  input Real start;\n"
            + "  input Real interval;\n"
            + "  output Real y;\n"     // Type not used
            + "end sample;\n"
            + "function pre\n"
            + "  input Real x;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end pre;\n"
            + "function edge\n"
            + "  input Real x;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end edge;\n"
            + "function change\n"
            + "  input Real x;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end change;\n"
            + "function reinit\n"
            + "  input Real x;\n"      // Type not used
            + "  input Real expr;\n"     // Type not used
            + "end reinit;\n"
            + "function assert\n"
            + "  input Boolean condition;\n"
            + "  input String message;\n"
            + "  input AssertionLevel level = AssertionLevel.error;\n"
            + "end assert;\n"
            + "function terminate\n"
            + "  input String reason;\n"
            + "end terminate;\n"
            + "function abs\n"
            + "  input Real v;\n"
            + "  output Real y;\n"
            + "end abs;\n"
            + "function sign\n"
            + "  input Real v;\n"
            + "  output Real y;\n"
            + "end sign;\n"
            + "function sqrt\n"
            + "  input Real x;\n"
            + "  output Real y;\n"
            + "end sqrt;\n"
            + "function universeLifeAndEverything\n"
            + "  output Integer y = 42;\n"
            + "algorithm\n"
            + "end universeLifeAndEverything;\n"
            + "function div"
            + "  input Real x1;\n"      // Type not used
            + "  input Real x2;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end div;\n"
            + "function mod"
            + "  input Real x1;\n"      // Type not used
            + "  input Real x2;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end mod;\n"
            + "function rem"
            + "  input Real x1;\n"      // Type not used
            + "  input Real x2;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end rem;\n"
            + "function floor"
            + "  input Real x;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end floor;\n"
            + "function ceil"
            + "  input Real x;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end ceil;\n"
            + "function integer"
            + "  input Real x;\n"      // Type not used
            + "  output Integer y;\n"  // Type not used
            + "end integer;\n"
            + "function Integer"
            + "  input Real x;\n"      // Type not used
            + "  output Integer y;\n"  // Type not used
            + "end Integer;\n"
            + "function String"
            + "  input Real x;\n"      // Type not used
            + "  input Integer minimumLength = 0;\n"
            + "  input Boolean leftJustified = true;\n"
            + "  input Integer significantDigits = 6;\n"
            + "  input String format = \"\";\n"
            + "  output String y;\n"
            + "end String;\n"
            + "function delay"
            + "  input Real exp;\n"      // Type not used
            + "  input Real delayTime;\n"
            + "  input Real delayMax = delayTime;\n"
            + "  output Real y;\n"       // Type not used
            + "end delay;\n"
            + "function spatialDistribution"
            + "  input Real in0;\n"
            + "  input Real in1;\n"
            + "  input Real x;\n"
            + "  input Boolean positiveVelocity;\n"
            + "  input Real[:] initialPoints = {0.0, 1.0};\n"
            + "  input Real[:] initialValues = {0.0, 0.0};\n"
            + "  output Real out0;\n"
            + "  output Real out1;\n"
            + "end spatialDistribution;\n"
            + "function cardinality"
            + "  input Real x;\n"      // Type not used
            + "  output Integer y;\n"  // Type not used
            + "end cardinality;\n"
            + "package Subtask"
            + "  function decouple"
            + "    input Real x;\n"      // Type not used
            + "    output Integer y;\n"  // Type not used
            + "  end decouple;\n"
            + "end Subtask;\n"
            + "function ndims\n"
            + "  input Real A;\n"      // Type not used
            + "  output Integer n;\n"
            + "end ndims;\n"
            + "function size\n"
            + "  input Real A;\n"         // Type not used
            + "  input Integer d = 0;\n"  // Default value not used
            + "  output Integer s;\n"
            + "end size;\n"
            + "function scalar"
            + "  input Real A;\n"      // Type not used
            + "  output Real y;\n"     // Type not used
            + "end scalar;\n"
            + "function vector"
            + "  input Real A;\n"      // Type not used
            + "  output Real B;\n"     // Type not used
            + "end vector;\n"
            + "function matrix"
            + "  input Real A;\n"      // Type not used
            + "  output Real B;\n"     // Type not used
            + "end matrix;\n"
            + "function transpose\n"
            + "  input Real A;\n"    // Type not used
            + "  output Real B;\n"   // Type not used
            + "end transpose;\n"
            + "function symmetric\n"
            + "  input Real A;\n"    // Type not used
            + "  output Real B;\n"   // Type not used
            + "end symmetric;\n"
            + "function cross\n"
            + "  input Real x[3];\n"
            + "  input Real y[3];\n"
            + "  output Real z[3];\n"   // Type not used
            + "end cross;\n"
            + "function outerProduct\n"
            + "  input Real x[:];\n"
            + "  input Real y[:];\n"
            + "  output Real z[:,:];\n"   // Type not used
            + "end outerProduct;\n"
            + "function diagonal\n"
            + "  input Real v[:];\n"
            + "  output Real z[:,:];\n"   // Type not used
            + "end diagonal;\n"
            + "function identity\n"
            + "  input Integer n;\n"
            + "  output Integer a[n, n];\n"
            + "end identity;\n"
            + "function array end array;\n"
            + "function zeros end zeros;\n"
            + "function ones end ones;\n"
            + "function fill\n"
            + "  input Real s;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end fill;\n"
            + "function cat\n"
            + "  input Real k;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end cat;\n"
            + "function linspace\n" 
            + "  input Real x1;\n"
            + "  input Real x2;\n"
            + "  input Integer n;\n"
            + "  output Real z[1];\n"   // Size not used
            + "end linspace;\n"
            + "function min\n"
            + "  input Real x;\n"      // Type not used
            + "  input Real y = 0;\n"  // Type and default value not used
            + "  output Real z;\n"     // Type not used
            + "end min;\n"
            + "function max\n"
            + "  input Real x;\n"      // Type not used
            + "  input Real y = 0;\n"  // Type and default value not used
            + "  output Real z;\n"     // Type not used
            + "end max;\n"
            + "function sum\n"
            + "  input Real A;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end sum;\n"
            + "function product\n"
            + "  input Real A;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end product;\n"
            + "function skew\n"
            + "  input Real x[3];\n"
            + "  output Real y[3,3];\n"   // Type not used
            + "end skew;\n"
            + "function homotopy\n"
            + "  input Real actual;\n"
            + "  input Real simplified;\n"
            + "  output Real o;\n"
            + "end homotopy;\n"
            + "function semiLinear\n"
            + "  input Real v1;\n"     // Type not used
            + "  input Real v2;\n"     // Type not used
            + "  input Real v3;\n"     // Type not used
            + "  output Real o;\n"     // Type not used
            + "end semiLinear;\n"
            + "function inStream\n"
            + "  input Real v;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end inStream;\n"
            + "function actualStream\n"
            + "  input Real n;\n"      // Type not used
            + "  output Real o;\n"     // Type not used
            + "end actualStream;\n"
            + "function getInstanceName\n"
            + "  output String o;\n"
            + "end getInstanceName;\n"
            + "function sin \"sine\"\n"
            + "  input Modelica.SIunits.Angle u;\n"
            + "  output Real y;\n"
            + "end sin;\n"
            + "function cos \"cosine\"" 
            + "  input Modelica.SIunits.Angle u;\n"
            + "  output Real y;\n"
            + "end cos;\n"
            + "function tan \"tangent (u shall not be -pi/2, pi/2, 3*pi/2, ...)\"\n"
            + "  input Modelica.SIunits.Angle u;\n"
            + "  output Real y;\n"
            + "end tan;\n"
            + "function asin \"inverse sine (-1 <= u <= 1)\"\n"
            + "  input Real u;\n"
            + "  output Modelica.SIunits.Angle y;\n"
            + "end asin;\n"
            + "function acos \"inverse cosine (-1 <= u <= 1)\"\n"
            + "  input Real u;\n"
            + "  output Modelica.SIunits.Angle y;\n"
            + "end acos;\n"
            + "function atan \"inverse tangent\"\n"
            + "  input Real u;\n"
            + "  output Modelica.SIunits.Angle y;\n"
            + "end atan;\n"
            + "function atan2 \"four quadrant inverse tangent\"\n"
            + "  input Real u1;\n"
            + "  input Real u2;\n"
            + "  output Modelica.SIunits.Angle y;\n"
            + "end atan2;\n"
            + "function sinh \"hyperbolic sine\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end sinh;\n"
            + "function cosh \"hyperbolic cosine\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end cosh;\n"
            + "function tanh \"hyperbolic tangent\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end tanh;\n"
            + "function exp \"exponential, base e\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end exp;\n"
            + "function log \"natural (base e) logarithm (u shall be > 0)\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end log;\n"
            + "function log10 \"base 10 logarithm (u shall be > 0)\"\n"
            + "  input Real u;\n"
            + "  output Real y;\n"
            + "end log10;\n"
            + "package Connections"
            + "  function branch"
            + "    input Real a;\n"      // Type not used
            + "    input Real b;\n"      // Type not used
            + "  end branch;"
            + "  function root"
            + "    input Real a;\n"      // Type not used
            + "  end root;"
            + "  function potentialRoot"
            + "    input Real A;\n"      // Type not used
            + "    input Integer priority = 0;\n"
            + "  end potentialRoot;"
            + "  function isRoot"
            + "    input Real a;\n"      // Type not used
            + "  end isRoot;"
            + "  function rooted"
            + "    input Real a;\n"      // Type not used
            + "    output Boolean y;\n"
            + "  end rooted;"
            + "end Connections;"
            + "function rooted"
            + "  input Real a;\n"      // Type not used
            + "  output Boolean y;\n"
            + "end rooted;"
            ;
    /**
     * Lookup SrcClassDecl indicated by the provided name.
     * Support lookup of both global and relative qualified names.
     * Returns null when the class isn't found.
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:113
     */
    public SrcClassDecl simpleLookupClass(String name) {
        QualifiedName qName = new QualifiedName(name);
        SrcClassDecl cd = simpleLookupDefaultScope(qName.next()).getClassDecl();
        if (!qName.hasNext()) {
            return cd;
        }
        while (cd != null && qName.hasNext()) {
            cd = cd.simpleLookupMemberScope(qName.next()).getClassDecl();
            if (cd == null) {
                return null;
            }
        }
        return cd;
    }
    /**
     * @declaredat ASTNode:1
     */
    public Program() {
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
        children = new ASTNode[10];
        setChild(List.EMPTY, 0);
        setChild(List.EMPTY, 4);
        setChild(List.EMPTY, 5);
        setChild(List.EMPTY, 6);
        setChild(List.EMPTY, 7);
        setChild(List.EMPTY, 8);
    }
    /**
     * @declaredat ASTNode:19
     */
    @ASTNodeAnnotation.Constructor(
        name = {"UnstructuredEntity"},
        type = {"List<SrcStoredDefinition>"},
        kind = {"List"}
    )
    public Program(List<SrcStoredDefinition> p0) {
        setChild(p0, 0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:28
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:34
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:38
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getAnonymousClassList_reset();
        getInstProgramRoot_reset();
        getSrcUnknownClassDecl_reset();
        getUnknownComponent_reset();
        getSrcLibNodeList_reset();
        getPredefinedTypeList_reset();
        getEnumBaseDecl_reset();
        getBuiltInFunctionList_reset();
        getBuiltInTypeList_reset();
        simpleLookupDefaultScope_String_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public Program clone() throws CloneNotSupportedException {
        Program node = (Program) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:61
     */
    public Program copy() {
        try {
            Program node = (Program) clone();
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
    public Program fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:90
     */
    public Program treeCopyNoTransform() {
        Program tree = (Program) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 1:
                case 2:
                case 3:
                case 9:
                    tree.children[i] = null;
                    continue;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    tree.children[i] = List.EMPTY;
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
    public Program treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:130
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the UnstructuredEntity list.
     * @param list The new list node to be used as the UnstructuredEntity list.
     * @apilevel high-level
     */
    public void setUnstructuredEntityList(List<SrcStoredDefinition> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the UnstructuredEntity list.
     * @return Number of children in the UnstructuredEntity list.
     * @apilevel high-level
     */
    public int getNumUnstructuredEntity() {
        return getUnstructuredEntityList().getNumChild();
    }
    /**
     * Retrieves the number of children in the UnstructuredEntity list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the UnstructuredEntity list.
     * @apilevel low-level
     */
    public int getNumUnstructuredEntityNoTransform() {
        return getUnstructuredEntityListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the UnstructuredEntity list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the UnstructuredEntity list.
     * @apilevel high-level
     */
    public SrcStoredDefinition getUnstructuredEntity(int i) {
        return (SrcStoredDefinition) getUnstructuredEntityList().getChild(i);
    }
    /**
     * Check whether the UnstructuredEntity list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasUnstructuredEntity() {
        return getUnstructuredEntityList().getNumChild() != 0;
    }
    /**
     * Append an element to the UnstructuredEntity list.
     * @param node The element to append to the UnstructuredEntity list.
     * @apilevel high-level
     */
    public void addUnstructuredEntity(SrcStoredDefinition node) {
        List<SrcStoredDefinition> list = (parent == null) ? getUnstructuredEntityListNoTransform() : getUnstructuredEntityList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addUnstructuredEntityNoTransform(SrcStoredDefinition node) {
        List<SrcStoredDefinition> list = getUnstructuredEntityListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the UnstructuredEntity list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setUnstructuredEntity(SrcStoredDefinition node, int i) {
        List<SrcStoredDefinition> list = getUnstructuredEntityList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the UnstructuredEntity list.
     * @return The node representing the UnstructuredEntity list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="UnstructuredEntity")
    public List<SrcStoredDefinition> getUnstructuredEntityList() {
        List<SrcStoredDefinition> list = (List<SrcStoredDefinition>) getChild(0);
        return list;
    }
    /**
     * Retrieves the UnstructuredEntity list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the UnstructuredEntity list.
     * @apilevel low-level
     */
    public List<SrcStoredDefinition> getUnstructuredEntityListNoTransform() {
        return (List<SrcStoredDefinition>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the UnstructuredEntity list without
     * triggering rewrites.
     */
    public SrcStoredDefinition getUnstructuredEntityNoTransform(int i) {
        return (SrcStoredDefinition) getUnstructuredEntityListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the UnstructuredEntity list.
     * @return The node representing the UnstructuredEntity list.
     * @apilevel high-level
     */
    public List<SrcStoredDefinition> getUnstructuredEntitys() {
        return getUnstructuredEntityList();
    }
    /**
     * Retrieves the UnstructuredEntity list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the UnstructuredEntity list.
     * @apilevel low-level
     */
    public List<SrcStoredDefinition> getUnstructuredEntitysNoTransform() {
        return getUnstructuredEntityListNoTransform();
    }
    /**
     * Retrieves the SrcUnknownClassDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the SrcUnknownClassDecl child.
     * @apilevel low-level
     */
    public SrcUnknownClassDecl getSrcUnknownClassDeclNoTransform() {
        return (SrcUnknownClassDecl) getChildNoTransform(1);
    }
    /**
     * Retrieves the child position of the optional child SrcUnknownClassDecl.
     * @return The the child position of the optional child SrcUnknownClassDecl.
     * @apilevel low-level
     */
    protected int getSrcUnknownClassDeclChildPosition() {
        return 1;
    }
    /**
     * Retrieves the UnknownComponent child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the UnknownComponent child.
     * @apilevel low-level
     */
    public SrcComponentClause getUnknownComponentNoTransform() {
        return (SrcComponentClause) getChildNoTransform(2);
    }
    /**
     * Retrieves the child position of the optional child UnknownComponent.
     * @return The the child position of the optional child UnknownComponent.
     * @apilevel low-level
     */
    protected int getUnknownComponentChildPosition() {
        return 2;
    }
    /**
     * Retrieves the EnumBaseDecl child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the EnumBaseDecl child.
     * @apilevel low-level
     */
    public SrcEnumClassDecl getEnumBaseDeclNoTransform() {
        return (SrcEnumClassDecl) getChildNoTransform(3);
    }
    /**
     * Retrieves the child position of the optional child EnumBaseDecl.
     * @return The the child position of the optional child EnumBaseDecl.
     * @apilevel low-level
     */
    protected int getEnumBaseDeclChildPosition() {
        return 3;
    }
    /**
     * Retrieves the number of children in the PredefinedType list.
     * @return Number of children in the PredefinedType list.
     * @apilevel high-level
     */
    public int getNumPredefinedType() {
        return getPredefinedTypeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the PredefinedType list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the PredefinedType list.
     * @apilevel low-level
     */
    public int getNumPredefinedTypeNoTransform() {
        return getPredefinedTypeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the PredefinedType list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the PredefinedType list.
     * @apilevel high-level
     */
    public SrcBaseClassDecl getPredefinedType(int i) {
        return (SrcBaseClassDecl) getPredefinedTypeList().getChild(i);
    }
    /**
     * Check whether the PredefinedType list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasPredefinedType() {
        return getPredefinedTypeList().getNumChild() != 0;
    }
    /**
     * Append an element to the PredefinedType list.
     * @param node The element to append to the PredefinedType list.
     * @apilevel high-level
     */
    public void addPredefinedType(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = (parent == null) ? getPredefinedTypeListNoTransform() : getPredefinedTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addPredefinedTypeNoTransform(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = getPredefinedTypeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the PredefinedType list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setPredefinedType(SrcBaseClassDecl node, int i) {
        List<SrcBaseClassDecl> list = getPredefinedTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 4);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the PredefinedType list.
     * @return The the child position of the PredefinedType list.
     * @apilevel low-level
     */
    protected int getPredefinedTypeListChildPosition() {
        return 4;
    }
    /**
     * Retrieves the PredefinedType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the PredefinedType list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getPredefinedTypeListNoTransform() {
        return (List<SrcBaseClassDecl>) getChildNoTransform(4);
    }
    /**
     * @return the element at index {@code i} in the PredefinedType list without
     * triggering rewrites.
     */
    public SrcBaseClassDecl getPredefinedTypeNoTransform(int i) {
        return (SrcBaseClassDecl) getPredefinedTypeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the PredefinedType list.
     * @return The node representing the PredefinedType list.
     * @apilevel high-level
     */
    public List<SrcBaseClassDecl> getPredefinedTypes() {
        return getPredefinedTypeList();
    }
    /**
     * Retrieves the PredefinedType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the PredefinedType list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getPredefinedTypesNoTransform() {
        return getPredefinedTypeListNoTransform();
    }
    /**
     * Retrieves the number of children in the BuiltInType list.
     * @return Number of children in the BuiltInType list.
     * @apilevel high-level
     */
    public int getNumBuiltInType() {
        return getBuiltInTypeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the BuiltInType list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the BuiltInType list.
     * @apilevel low-level
     */
    public int getNumBuiltInTypeNoTransform() {
        return getBuiltInTypeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the BuiltInType list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the BuiltInType list.
     * @apilevel high-level
     */
    public SrcClassDecl getBuiltInType(int i) {
        return (SrcClassDecl) getBuiltInTypeList().getChild(i);
    }
    /**
     * Check whether the BuiltInType list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasBuiltInType() {
        return getBuiltInTypeList().getNumChild() != 0;
    }
    /**
     * Append an element to the BuiltInType list.
     * @param node The element to append to the BuiltInType list.
     * @apilevel high-level
     */
    public void addBuiltInType(SrcClassDecl node) {
        List<SrcClassDecl> list = (parent == null) ? getBuiltInTypeListNoTransform() : getBuiltInTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addBuiltInTypeNoTransform(SrcClassDecl node) {
        List<SrcClassDecl> list = getBuiltInTypeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the BuiltInType list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setBuiltInType(SrcClassDecl node, int i) {
        List<SrcClassDecl> list = getBuiltInTypeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the BuiltInType list.
     * @return The the child position of the BuiltInType list.
     * @apilevel low-level
     */
    protected int getBuiltInTypeListChildPosition() {
        return 5;
    }
    /**
     * Retrieves the BuiltInType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the BuiltInType list.
     * @apilevel low-level
     */
    public List<SrcClassDecl> getBuiltInTypeListNoTransform() {
        return (List<SrcClassDecl>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the BuiltInType list without
     * triggering rewrites.
     */
    public SrcClassDecl getBuiltInTypeNoTransform(int i) {
        return (SrcClassDecl) getBuiltInTypeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the BuiltInType list.
     * @return The node representing the BuiltInType list.
     * @apilevel high-level
     */
    public List<SrcClassDecl> getBuiltInTypes() {
        return getBuiltInTypeList();
    }
    /**
     * Retrieves the BuiltInType list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the BuiltInType list.
     * @apilevel low-level
     */
    public List<SrcClassDecl> getBuiltInTypesNoTransform() {
        return getBuiltInTypeListNoTransform();
    }
    /**
     * Retrieves the number of children in the BuiltInFunction list.
     * @return Number of children in the BuiltInFunction list.
     * @apilevel high-level
     */
    public int getNumBuiltInFunction() {
        return getBuiltInFunctionList().getNumChild();
    }
    /**
     * Retrieves the number of children in the BuiltInFunction list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the BuiltInFunction list.
     * @apilevel low-level
     */
    public int getNumBuiltInFunctionNoTransform() {
        return getBuiltInFunctionListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the BuiltInFunction list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the BuiltInFunction list.
     * @apilevel high-level
     */
    public SrcBaseClassDecl getBuiltInFunction(int i) {
        return (SrcBaseClassDecl) getBuiltInFunctionList().getChild(i);
    }
    /**
     * Check whether the BuiltInFunction list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasBuiltInFunction() {
        return getBuiltInFunctionList().getNumChild() != 0;
    }
    /**
     * Append an element to the BuiltInFunction list.
     * @param node The element to append to the BuiltInFunction list.
     * @apilevel high-level
     */
    public void addBuiltInFunction(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = (parent == null) ? getBuiltInFunctionListNoTransform() : getBuiltInFunctionList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addBuiltInFunctionNoTransform(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = getBuiltInFunctionListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the BuiltInFunction list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setBuiltInFunction(SrcBaseClassDecl node, int i) {
        List<SrcBaseClassDecl> list = getBuiltInFunctionList();
        if (list == List.EMPTY) {
            setChild(new List(node), 6);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the BuiltInFunction list.
     * @return The the child position of the BuiltInFunction list.
     * @apilevel low-level
     */
    protected int getBuiltInFunctionListChildPosition() {
        return 6;
    }
    /**
     * Retrieves the BuiltInFunction list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the BuiltInFunction list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getBuiltInFunctionListNoTransform() {
        return (List<SrcBaseClassDecl>) getChildNoTransform(6);
    }
    /**
     * @return the element at index {@code i} in the BuiltInFunction list without
     * triggering rewrites.
     */
    public SrcBaseClassDecl getBuiltInFunctionNoTransform(int i) {
        return (SrcBaseClassDecl) getBuiltInFunctionListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the BuiltInFunction list.
     * @return The node representing the BuiltInFunction list.
     * @apilevel high-level
     */
    public List<SrcBaseClassDecl> getBuiltInFunctions() {
        return getBuiltInFunctionList();
    }
    /**
     * Retrieves the BuiltInFunction list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the BuiltInFunction list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getBuiltInFunctionsNoTransform() {
        return getBuiltInFunctionListNoTransform();
    }
    /**
     * Retrieves the number of children in the SrcLibNode list.
     * @return Number of children in the SrcLibNode list.
     * @apilevel high-level
     */
    public int getNumSrcLibNode() {
        return getSrcLibNodeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the SrcLibNode list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the SrcLibNode list.
     * @apilevel low-level
     */
    public int getNumSrcLibNodeNoTransform() {
        return getSrcLibNodeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the SrcLibNode list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the SrcLibNode list.
     * @apilevel high-level
     */
    public SrcLibNode getSrcLibNode(int i) {
        return (SrcLibNode) getSrcLibNodeList().getChild(i);
    }
    /**
     * Check whether the SrcLibNode list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasSrcLibNode() {
        return getSrcLibNodeList().getNumChild() != 0;
    }
    /**
     * Append an element to the SrcLibNode list.
     * @param node The element to append to the SrcLibNode list.
     * @apilevel high-level
     */
    public void addSrcLibNode(SrcLibNode node) {
        List<SrcLibNode> list = (parent == null) ? getSrcLibNodeListNoTransform() : getSrcLibNodeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addSrcLibNodeNoTransform(SrcLibNode node) {
        List<SrcLibNode> list = getSrcLibNodeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the SrcLibNode list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setSrcLibNode(SrcLibNode node, int i) {
        List<SrcLibNode> list = getSrcLibNodeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 7);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the SrcLibNode list.
     * @return The the child position of the SrcLibNode list.
     * @apilevel low-level
     */
    protected int getSrcLibNodeListChildPosition() {
        return 7;
    }
    /**
     * Retrieves the SrcLibNode list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcLibNode list.
     * @apilevel low-level
     */
    public List<SrcLibNode> getSrcLibNodeListNoTransform() {
        return (List<SrcLibNode>) getChildNoTransform(7);
    }
    /**
     * @return the element at index {@code i} in the SrcLibNode list without
     * triggering rewrites.
     */
    public SrcLibNode getSrcLibNodeNoTransform(int i) {
        return (SrcLibNode) getSrcLibNodeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the SrcLibNode list.
     * @return The node representing the SrcLibNode list.
     * @apilevel high-level
     */
    public List<SrcLibNode> getSrcLibNodes() {
        return getSrcLibNodeList();
    }
    /**
     * Retrieves the SrcLibNode list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the SrcLibNode list.
     * @apilevel low-level
     */
    public List<SrcLibNode> getSrcLibNodesNoTransform() {
        return getSrcLibNodeListNoTransform();
    }
    /**
     * Retrieves the number of children in the AnonymousClass list.
     * @return Number of children in the AnonymousClass list.
     * @apilevel high-level
     */
    public int getNumAnonymousClass() {
        return getAnonymousClassList().getNumChild();
    }
    /**
     * Retrieves the number of children in the AnonymousClass list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the AnonymousClass list.
     * @apilevel low-level
     */
    public int getNumAnonymousClassNoTransform() {
        return getAnonymousClassListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the AnonymousClass list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the AnonymousClass list.
     * @apilevel high-level
     */
    public SrcBaseClassDecl getAnonymousClass(int i) {
        return (SrcBaseClassDecl) getAnonymousClassList().getChild(i);
    }
    /**
     * Check whether the AnonymousClass list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasAnonymousClass() {
        return getAnonymousClassList().getNumChild() != 0;
    }
    /**
     * Append an element to the AnonymousClass list.
     * @param node The element to append to the AnonymousClass list.
     * @apilevel high-level
     */
    public void addAnonymousClass(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = (parent == null) ? getAnonymousClassListNoTransform() : getAnonymousClassList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addAnonymousClassNoTransform(SrcBaseClassDecl node) {
        List<SrcBaseClassDecl> list = getAnonymousClassListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the AnonymousClass list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setAnonymousClass(SrcBaseClassDecl node, int i) {
        List<SrcBaseClassDecl> list = getAnonymousClassList();
        if (list == List.EMPTY) {
            setChild(new List(node), 8);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the child position of the AnonymousClass list.
     * @return The the child position of the AnonymousClass list.
     * @apilevel low-level
     */
    protected int getAnonymousClassListChildPosition() {
        return 8;
    }
    /**
     * Retrieves the AnonymousClass list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnonymousClass list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getAnonymousClassListNoTransform() {
        return (List<SrcBaseClassDecl>) getChildNoTransform(8);
    }
    /**
     * @return the element at index {@code i} in the AnonymousClass list without
     * triggering rewrites.
     */
    public SrcBaseClassDecl getAnonymousClassNoTransform(int i) {
        return (SrcBaseClassDecl) getAnonymousClassListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the AnonymousClass list.
     * @return The node representing the AnonymousClass list.
     * @apilevel high-level
     */
    public List<SrcBaseClassDecl> getAnonymousClasss() {
        return getAnonymousClassList();
    }
    /**
     * Retrieves the AnonymousClass list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the AnonymousClass list.
     * @apilevel low-level
     */
    public List<SrcBaseClassDecl> getAnonymousClasssNoTransform() {
        return getAnonymousClassListNoTransform();
    }
    /**
     * Retrieves the InstProgramRoot child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the InstProgramRoot child.
     * @apilevel low-level
     */
    public InstProgramRoot getInstProgramRootNoTransform() {
        return (InstProgramRoot) getChildNoTransform(9);
    }
    /**
     * Retrieves the child position of the optional child InstProgramRoot.
     * @return The the child position of the optional child InstProgramRoot.
     * @apilevel low-level
     */
    protected int getInstProgramRootChildPosition() {
        return 9;
    }
    /** @apilevel internal */
    private void getAnonymousClassList_reset() {
        getAnonymousClassList_computed = false;
        
        getAnonymousClassList_value = null;
    }
    /** @apilevel internal */
    protected boolean getAnonymousClassList_computed = false;

    /** @apilevel internal */
    protected List getAnonymousClassList_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:801
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:801")
    public List getAnonymousClassList() {
        ASTState state = state();
        if (getAnonymousClassList_computed) {
            return (List) getChild(getAnonymousClassListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getAnonymousClassList_value = new List();
        if(getAnonymousClassList_value.numChildren() <= 0) {
            getAnonymousClassList_value  = List.EMPTY;
        }
        setChild(getAnonymousClassList_value, getAnonymousClassListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getAnonymousClassList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getAnonymousClassListChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:805
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:805")
    public SrcClassDecl anonymousClass(String code, SrcRestriction restriction, String targetName) {
        {
                if (anonymousClassMap == null)
                    anonymousClassMap = new HashMap<String,SrcClassDecl>();
                SrcClassDecl res = anonymousClassMap.get(code);
                if (res == null) {
                    try {
                        addAnonymousClass(root().getUtilInterface().getParserHandler().parseAnonymousClassString(code, restriction, targetName));
                        res = getAnonymousClass(getNumAnonymousClass() - 1);
                        anonymousClassMap.put(code, res);
                    } catch (IOException e) {
                        // Can't normally happen when reading from a string, but just in case
                        throw new RuntimeException("Reading from string failed", e);
                    } catch (beaver.Parser.Exception e) {
                        // Parser crashed - just handle this higher up
                        throw new RuntimeException("Parser crashed", e);
                    } catch (ParserException e) {
                        CompilerException ce = new CompilerException();
                        ce.addProblem(e.getProblem());
                        throw ce;
                    }
                }
                return res;
            }
    }
    /** @apilevel internal */
    private void getInstProgramRoot_reset() {
        getInstProgramRoot_computed = false;
        
        getInstProgramRoot_value = null;
    }
    /** @apilevel internal */
    protected boolean getInstProgramRoot_computed = false;

    /** @apilevel internal */
    protected InstProgramRoot getInstProgramRoot_value;

    /**
     * @attribute syn nta
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1607
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1607")
    public InstProgramRoot getInstProgramRoot() {
        ASTState state = state();
        if (getInstProgramRoot_computed) {
            return (InstProgramRoot) getChild(getInstProgramRootChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getInstProgramRoot_value = getInstProgramRoot_compute();
        setChild(getInstProgramRoot_value, getInstProgramRootChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getInstProgramRoot_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        InstProgramRoot node = (InstProgramRoot) this.getChild(getInstProgramRootChildPosition());
        return node;
    }
    /** @apilevel internal */
    private InstProgramRoot getInstProgramRoot_compute() {
            return new InstProgramRoot(this, new Opt(), new Opt(), new Opt());
        }
    /** @apilevel internal */
    private void getSrcUnknownClassDecl_reset() {
        getSrcUnknownClassDecl_computed = false;
        
        getSrcUnknownClassDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean getSrcUnknownClassDecl_computed = false;

    /** @apilevel internal */
    protected SrcUnknownClassDecl getSrcUnknownClassDecl_value;

    /**
     * @attribute syn nta
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:20
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:20")
    public SrcUnknownClassDecl getSrcUnknownClassDecl() {
        ASTState state = state();
        if (getSrcUnknownClassDecl_computed) {
            return (SrcUnknownClassDecl) getChild(getSrcUnknownClassDeclChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getSrcUnknownClassDecl_value = new SrcUnknownClassDecl(new SrcIdDecl("Unknown"),
                                     false,
                                     false,
                                     new SrcClass(),
                                     false,
                                     false,
                                     false,
                                     false,
                                     false,
                                     new Opt<SrcConstrainingClause>(),
                                     new Opt<SrcComment>(),
                                     new Opt<SrcStringComment>(),
                                     new List<SrcClause>(),
                                     new Opt<SrcExternalClause>(),
                                     new Opt<SrcAnnotation>(),
                                     new SrcEndDecl("Unknown"));
        setChild(getSrcUnknownClassDecl_value, getSrcUnknownClassDeclChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getSrcUnknownClassDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        SrcUnknownClassDecl node = (SrcUnknownClassDecl) this.getChild(getSrcUnknownClassDeclChildPosition());
        return node;
    }
    /** @apilevel internal */
    private void getUnknownComponent_reset() {
        getUnknownComponent_computed = false;
        
        getUnknownComponent_value = null;
    }
    /** @apilevel internal */
    protected boolean getUnknownComponent_computed = false;

    /** @apilevel internal */
    protected SrcComponentClause getUnknownComponent_value;

    /**
     * @attribute syn nta
     * @aspect UnknownDeclarations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:38
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="UnknownDeclarations", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\PrimitiveClasses.jrag:38")
    public SrcComponentClause getUnknownComponent() {
        ASTState state = state();
        if (getUnknownComponent_computed) {
            return (SrcComponentClause) getChild(getUnknownComponentChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getUnknownComponent_value = new SrcComponentClause(
                     false,
                     false,
                     false,
                     false,
                     false,
                     new Opt(),
                     new Opt(),
                     new Opt(),
                     new SrcNamedAccess("Unknown"),
                     new Opt(),
                     new List(
                         new SrcUnknownComponentDecl(
                             new SrcIdDecl("Unknown"),
                             new Opt(),
                             new Opt(),
                             new Opt(),
                             new SrcComment())),
                     new Opt(),
                     new SrcComment());
        setChild(getUnknownComponent_value, getUnknownComponentChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getUnknownComponent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        SrcComponentClause node = (SrcComponentClause) this.getChild(getUnknownComponentChildPosition());
        return node;
    }
    /** @apilevel internal */
    private void getSrcLibNodeList_reset() {
        getSrcLibNodeList_computed = false;
        
        getSrcLibNodeList_value = null;
    }
    /** @apilevel internal */
    protected boolean getSrcLibNodeList_computed = false;

    /** @apilevel internal */
    protected List getSrcLibNodeList_value;

    /**
     * @attribute syn nta
     * @aspect Library
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:330
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Library", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:330")
    public List getSrcLibNodeList() {
        ASTState state = state();
        if (getSrcLibNodeList_computed) {
            return (List) getChild(getSrcLibNodeListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getSrcLibNodeList_value = getLibraryList().createLibNodeList();
        if(getSrcLibNodeList_value.numChildren() <= 0) {
            getSrcLibNodeList_value  = List.EMPTY;
        }
        setChild(getSrcLibNodeList_value, getSrcLibNodeListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getSrcLibNodeList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getSrcLibNodeListChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:48")
    public String builtInTypeDefs() {
        String builtInTypeDefs_value = builtInBaseTypeDefs() + 
                                                   builtInTypeClassDefs();
        return builtInTypeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:51
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:51")
    public String builtInBaseTypeDefs() {
        String builtInBaseTypeDefs_value = realTypeDef()    + 
                                                       integerTypeDef() + 
                                                       booleanTypeDef() + 
                                                       stringTypeDef()  + 
                                                       externalTypeDef();
        return builtInBaseTypeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:56
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:56")
    public String realTypeDef() {
        String realTypeDef_value = makeBaseTypeDef("Real",    realAttributeDefs());
        return realTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:57")
    public String integerTypeDef() {
        String integerTypeDef_value = makeBaseTypeDef("Integer", integerAttributeDefs());
        return integerTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:58
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:58")
    public String booleanTypeDef() {
        String booleanTypeDef_value = makeBaseTypeDef("Boolean", booleanAttributeDefs());
        return booleanTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:59
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:59")
    public String stringTypeDef() {
        String stringTypeDef_value = makeBaseTypeDef("String",  stringAttributeDefs());
        return stringTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:60
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:60")
    public String externalTypeDef() {
        String externalTypeDef_value = "partial model ExternalObject\n" + 
                                                   "end ExternalObject;\n";
        return externalTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:63
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:63")
    public String[] realAttributeDefs() {
        String[] realAttributeDefs_value = new String[] { 
                    makeAttributeDef("value",       "Real",    null), 
                    makeAttributeDef("quantity",    "String",  "\"\""), 
                    makeAttributeDef("unit",        "String",  "\"\""), 
                    makeAttributeDef("displayUnit", "String",  "\"\""), 
                    makeAttributeDef("min",         "Real",    "-1e20"), 
                    makeAttributeDef("max",         "Real",    "1e20"), 
                    makeAttributeDef("start",       "Real",    "0.0"), 
                    makeAttributeDef("fixed",       "Boolean", "false"), 
                    makeAttributeDef("nominal",     "Real",    "0.0"), 
                    makeAttributeDef("stateSelect", "Enum",    "StateSelect.default"), 
                };
        return realAttributeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:77")
    public String[] integerAttributeDefs() {
        String[] integerAttributeDefs_value = new String[] { 
                    makeAttributeDef("value",    "Integer", null), 
                    makeAttributeDef("quantity", "String",  "\"\""), 
                    makeAttributeDef("min",      "Integer", Integer.toString(Integer.MIN_VALUE)), 
                    makeAttributeDef("max",      "Integer", Integer.toString(Integer.MAX_VALUE)), 
                    makeAttributeDef("start",    "Integer", "0"), 
                    makeAttributeDef("fixed",    "Boolean", "false"), 
                };
        return integerAttributeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:87
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:87")
    public String[] booleanAttributeDefs() {
        String[] booleanAttributeDefs_value = new String[] { 
                    makeAttributeDef("value",    "Boolean", null), 
                    makeAttributeDef("quantity", "String",  "\"\""), 
                    makeAttributeDef("start",    "Boolean", "false"), 
                    makeAttributeDef("fixed",    "Boolean", "true"), 
                };
        return booleanAttributeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:95
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:95")
    public String[] stringAttributeDefs() {
        String[] stringAttributeDefs_value = new String[] { 
                    makeAttributeDef("value",    "String", null), 
                    makeAttributeDef("quantity", "String", "\"\""), 
                    makeAttributeDef("start",    "String", "\"\""), 
                };
        return stringAttributeDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:102")
    public String builtInTypeClassDefs() {
        String builtInTypeClassDefs_value = stateSelectTypeDef()    + 
                                                        assertionLevelTypeDef() + 
                                                        colorTypeDef()          + 
                                                        linePatternTypeDef()    + 
                                                        fillPatternTypeDef()    + 
                                                        borderPatternTypeDef()  + 
                                                        smoothTypeDef()         + 
                                                        arrowTypeDef()          + 
                                                        textStyleTypeDef()      + 
                                                        textAlignmentTypeDef();
        return builtInTypeClassDefs_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:112
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:112")
    public String stateSelectTypeDef() {
        String stateSelectTypeDef_value = makeEnumDef("StateSelect", 
                        "never   \"Do not use as state at all.\"",
                        "avoid   \"Use as state, if it cannot be avoided (but only if variable appears differentiated and no other potential state with attribute default, prefer, or always can be selected).\"",
                        "default \"Use as state if appropriate, but only if variable appears differentiated.\"",
                        "prefer  \"Prefer it as state over those having the default value (also variables can be selected, which do not appear differentiated).\"",
                        "always  \"Do use it as a state.\"");
        return stateSelectTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:119
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:119")
    public String assertionLevelTypeDef() {
        String assertionLevelTypeDef_value = makeEnumDef("AssertionLevel", "error", "warning");
        return assertionLevelTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:121
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:121")
    public String colorTypeDef() {
        String colorTypeDef_value = "type Color = Integer[3](min=0, max=255) \"RGB representation\";\n";
        return colorTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:123
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:123")
    public String linePatternTypeDef() {
        String linePatternTypeDef_value = makeEnumDef("LinePattern", "None", "Solid", "Dash", "Dot", "DashDot", "DashDotDot");
        return linePatternTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:125
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:125")
    public String fillPatternTypeDef() {
        String fillPatternTypeDef_value = makeEnumDef("FillPattern", 
                        "None", "Solid", "Horizontal", "Vertical", "Cross", "Forward", "Backward", 
                        "CrossDiag", "HorizontalCylinder", "VerticalCylinder", "Sphere");
        return fillPatternTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:129
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:129")
    public String borderPatternTypeDef() {
        String borderPatternTypeDef_value = makeEnumDef("BorderPattern", "None", "Raised", "Sunken", "Engraved");
        return borderPatternTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:131")
    public String smoothTypeDef() {
        String smoothTypeDef_value = makeEnumDef("Smooth", "None", "Bezier");
        return smoothTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:133")
    public String arrowTypeDef() {
        String arrowTypeDef_value = makeEnumDef("Arrow", "None", "Open", "Filled", "Half");
        return arrowTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:135
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:135")
    public String textStyleTypeDef() {
        String textStyleTypeDef_value = makeEnumDef("TextStyle", "Bold", "Italic", "UnderLine");
        return textStyleTypeDef_value;
    }
    /**
     * @attribute syn
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:137
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:137")
    public String textAlignmentTypeDef() {
        String textAlignmentTypeDef_value = makeEnumDef("TextAlignment", "Left", "Center", "Right");
        return textAlignmentTypeDef_value;
    }
    /** @apilevel internal */
    private void getPredefinedTypeList_reset() {
        getPredefinedTypeList_computed = false;
        
        getPredefinedTypeList_value = null;
    }
    /** @apilevel internal */
    protected boolean getPredefinedTypeList_computed = false;

    /** @apilevel internal */
    protected List getPredefinedTypeList_value;

    /**
     * This attribute defines the NTA for predefined types
     * which contains a list of predefined PrimitiveClassDef:s.
     * @attribute syn nta
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:193
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:193")
    public List getPredefinedTypeList() {
        ASTState state = state();
        if (getPredefinedTypeList_computed) {
            return (List) getChild(getPredefinedTypeListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getPredefinedTypeList_value = getPredefinedTypeList_compute();
        if(getPredefinedTypeList_value.numChildren() <= 0) {
            getPredefinedTypeList_value  = List.EMPTY;
        }
        setChild(getPredefinedTypeList_value, getPredefinedTypeListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getPredefinedTypeList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getPredefinedTypeListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getPredefinedTypeList_compute() {
            List l = new List();
    
            SrcPrimitiveClassDecl pcd = null;
    
            Program p;
            try {
                UtilInterface util = root().getUtilInterface();
                p = util.getParserHandler().parseString(util, builtInTypeDefs(), "").getProgram();
            } catch (Exception e) {
                return l;
            }
            
            Set<String> primitives = new HashSet<String>();
            primitives.add("Real");
            primitives.add("Integer");
            primitives.add("Boolean");
            primitives.add("String");
            primitives.add("ExternalObject");
            
            for (SrcClassDecl cd : p.getUnstructuredEntity(0).getSrcClassDecls()) {
                if (primitives.contains(cd.name())) {
                    l.add(SrcPrimitiveClassDecl.create(cd.asFullClassDecl())); 
                } else {
                    l.add(cd);
                }
            }
            
            return l;
        }
    /** @apilevel internal */
    private void getEnumBaseDecl_reset() {
        getEnumBaseDecl_computed = false;
        
        getEnumBaseDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean getEnumBaseDecl_computed = false;

    /** @apilevel internal */
    protected SrcEnumClassDecl getEnumBaseDecl_value;

    /**
     * This attribute defines the NTA for obtaining a base enumeration
     * declaration, which is used to construct user defined enumeration
     * types.
     * @attribute syn nta
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:229
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:229")
    public SrcEnumClassDecl getEnumBaseDecl() {
        ASTState state = state();
        if (getEnumBaseDecl_computed) {
            return (SrcEnumClassDecl) getChild(getEnumBaseDeclChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getEnumBaseDecl_value = getEnumBaseDecl_compute();
        setChild(getEnumBaseDecl_value, getEnumBaseDeclChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getEnumBaseDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        SrcEnumClassDecl node = (SrcEnumClassDecl) this.getChild(getEnumBaseDeclChildPosition());
        return node;
    }
    /** @apilevel internal */
    private SrcEnumClassDecl getEnumBaseDecl_compute() {
    
            // Build a string with a Modelica class corresponding to a basic
        	// enumeration
            String builtInDef = 
                    "type BaseEnum\n"
                  + "EnumType value;\n"
                  + "parameter StringType quantity=\"\";\n"
                  + "parameter EnumType min, max;\n"
                  + "parameter EnumType start;\n"
                  + "parameter BooleanType fixed=false;\n"
                  + "end BaseEnum;\n";
            
            SrcEnumClassDecl ecd = null;
      
            try {
            
                UtilInterface util = root().getUtilInterface();
                SourceRoot sr = util.getParserHandler().parseString(util, builtInDef,"");
                Program p = sr.getProgram();
    
                SrcFullClassDecl cd = p.getUnstructuredEntity(0).getSrcClassDecl(0).asFullClassDecl();
                
                ecd = new SrcEnumClassDecl(cd);
            
            } catch(Exception e){e.printStackTrace();}
                
            //log.debug("Program.getPredefinedTypeList(): "+l.getNumChild());
            
            return ecd;
        }
    /** @apilevel internal */
    private void getBuiltInFunctionList_reset() {
        getBuiltInFunctionList_computed = false;
        
        getBuiltInFunctionList_value = null;
    }
    /** @apilevel internal */
    protected boolean getBuiltInFunctionList_computed = false;

    /** @apilevel internal */
    protected List<SrcBaseClassDecl> getBuiltInFunctionList_value;

    /**
     * This attribute defines the NTA for predefined types
     * which contains a list of predefined SrcPrimitiveClassDecl:s.
     * @attribute syn nta
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:659
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:659")
    public List<SrcBaseClassDecl> getBuiltInFunctionList() {
        ASTState state = state();
        if (getBuiltInFunctionList_computed) {
            return (List<SrcBaseClassDecl>) getChild(getBuiltInFunctionListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getBuiltInFunctionList_value = getBuiltInFunctionList_compute();
        if(getBuiltInFunctionList_value.numChildren() <= 0) {
            getBuiltInFunctionList_value  = List.EMPTY;
        }
        setChild(getBuiltInFunctionList_value, getBuiltInFunctionListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getBuiltInFunctionList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List<SrcBaseClassDecl> node = (List<SrcBaseClassDecl>) this.getChild(getBuiltInFunctionListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List<SrcBaseClassDecl> getBuiltInFunctionList_compute() {
            List<SrcBaseClassDecl> l = new List<SrcBaseClassDecl>();
      
            try {
                UtilInterface util = root().getUtilInterface();
                SourceRoot sr = util.getParserHandler().parseString(util, BUILTIN_FUNCS, "");
                Program p = sr.getProgram();
                
                SrcExternalClause builtin = new SrcExternalClause(new Opt(new SrcExternalLanguage("builtin")), new Opt(), new Opt());
                for (SrcClassDecl cd : p.getUnstructuredEntity(0).getSrcClassDecls()) 
                    cd.addBuiltinFunctions(l, builtin);
            } catch (Exception e) {}
            
            return l;
        }
    /** @apilevel internal */
    private void getBuiltInTypeList_reset() {
        getBuiltInTypeList_computed = false;
        
        getBuiltInTypeList_value = null;
    }
    /** @apilevel internal */
    protected boolean getBuiltInTypeList_computed = false;

    /** @apilevel internal */
    protected List getBuiltInTypeList_value;

    /**
     * This attribute defines the NTA for predefined types
     * which contains a list of predefined BuiltInType:s.
     * @attribute syn nta
     * @aspect PredefinedTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:717
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="PredefinedTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:717")
    public List getBuiltInTypeList() {
        ASTState state = state();
        if (getBuiltInTypeList_computed) {
            return (List) getChild(getBuiltInTypeListChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getBuiltInTypeList_value = getBuiltInTypeList_compute();
        if(getBuiltInTypeList_value.numChildren() <= 0) {
            getBuiltInTypeList_value  = List.EMPTY;
        }
        setChild(getBuiltInTypeList_value, getBuiltInTypeListChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getBuiltInTypeList_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        List node = (List) this.getChild(getBuiltInTypeListChildPosition());
        return node;
    }
    /** @apilevel internal */
    private List getBuiltInTypeList_compute() {
            List l = new List();
            l.add(new SrcBuiltInClassDecl(new SrcIdDecl("RealType")));
            l.add(new SrcBuiltInClassDecl(new SrcIdDecl("IntegerType")));
            l.add(new SrcBuiltInClassDecl(new SrcIdDecl("BooleanType")));
            l.add(new SrcBuiltInClassDecl(new SrcIdDecl("StringType")));
            l.add(new SrcBuiltInClassDecl(new SrcIdDecl("EnumType")));
            return l;
        }
    /**
     * legacy support needed for old programs. Delegates to the new method which handles all the cases.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:84
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:84")
    public SrcClassDecl simpleLookupClassDotted(String name) {
        SrcClassDecl simpleLookupClassDotted_String_value = simpleLookupClass(name);
        return simpleLookupClassDotted_String_value;
    }
    /** @apilevel internal */
    private void simpleLookupDefaultScope_String_reset() {
        simpleLookupDefaultScope_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map simpleLookupDefaultScope_String_values;

    /**
     * Lookup simple name in global scope. Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:317
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:317")
    public ResolvedAccess simpleLookupDefaultScope(String name) {
        Object _parameters = name;
        if (simpleLookupDefaultScope_String_values == null) simpleLookupDefaultScope_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (simpleLookupDefaultScope_String_values.containsKey(_parameters)) {
            return (ResolvedAccess) simpleLookupDefaultScope_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ResolvedAccess simpleLookupDefaultScope_String_value = simpleLookupDefaultScope_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        simpleLookupDefaultScope_String_values.put(_parameters, simpleLookupDefaultScope_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return simpleLookupDefaultScope_String_value;
    }
    /** @apilevel internal */
    private ResolvedAccess simpleLookupDefaultScope_compute(String name) {
            for (SrcStoredDefinition sd : getUnstructuredEntitys()) {
                for (SrcClassDecl cd : sd.getSrcClassDecls()) {
                    if (cd.matches(name)) {
                        return createResolvedAccess(cd, null);
                    }
                }
            }
            
            ResolvedAccess res = simpleLookupPredefined(name);
            if (!res.isUnknown()) {
                return res;
            }
    
            return simpleLookupInLibNodeList(getSrcLibNodes(), name);
        }
    /**
     * Lookup a predefined type, function or operator in global scope. Has to be an unqualified classname.
     * @attribute syn
     * @aspect SimpleClassLookup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:355
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SimpleClassLookup", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:355")
    public ResolvedAccess simpleLookupPredefined(String name) {
        {
                ResolvedAccess res = simpleLookupInClassList(getPredefinedTypes(), name, null);
                if (!res.isUnknown()) {
                    return res;
                }
        
                res = simpleLookupInClassList(getBuiltInTypes(), name, null);
                if (!res.isUnknown()) {
                    return res;
                }
        
                return simpleLookupInClassList(getBuiltInFunctions(), name, null);
            }
    }
    /**
     * @attribute syn
     * @aspect SourceTraversal
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:145
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="SourceTraversal", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SourceTraversal.jrag:145")
    public Iterable<SrcClassDecl> classes() {
        {
                ArrayList<SrcClassDecl> l = new ArrayList<SrcClassDecl>();
                for (SrcStoredDefinition sd : getUnstructuredEntitys()) {
                    for (SrcClassDecl cd : sd.getSrcClassDecls()) {
                        if (!cd.isError()) {
                            l.add(cd);
                        }
                    }
                }
                // Libraries are loaded when needed in instance lookup instead
                return l;
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getInstProgramRootNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:614
            return new Environment();
        }
        else {
            return getParent().Define_myEnvironment(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:554
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     */
    public Environment Define_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getInstProgramRootNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:615
            return new Environment();
        }
        else {
            return getParent().Define_myEnvironment(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:597
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myEnvironment
     */
    protected boolean canDefine_myEnvironment(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:19
     * @apilevel internal
     */
    public boolean Define_isBuiltInClass(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getBuiltInFunctionListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:23
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else if (_callerNode == getBuiltInTypeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:22
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else if (_callerNode == getPredefinedTypeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:21
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return true;
        }
        else {
            return getParent().Define_isBuiltInClass(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\PredefinedTypes.jrag:19
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isBuiltInClass
     */
    protected boolean canDefine_isBuiltInClass(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:278
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupHelper(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupDefaultScope(name);
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupDefaultScope(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:302
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupFromExtends
     */
    protected boolean canDefine_simpleLookupFromExtends(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:309
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupGlobalScope(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupDefaultScope(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:309
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupGlobalScope
     */
    protected boolean canDefine_simpleLookupGlobalScope(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:349
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupPredefined(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return simpleLookupPredefined(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:349
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupPredefined
     */
    protected boolean canDefine_simpleLookupPredefined(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:312
     * @apilevel internal
     */
    public SrcClassDecl Define_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getSrcLibNodeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:314
            int i = _callerNode.getIndexOfChild(_childNode);
            return getSrcLibNode(i);
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return null;
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcUtil.jrag:312
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTopSrcClassDecl
     */
    protected boolean canDefine_myTopSrcClassDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     * @apilevel internal
     */
    public String Define_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getAnonymousClassListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:695
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return ParserHandler.ANONYMOUS_CLASS_FILENAME;
        }
        else {
            return super.Define_retrieveFileName(_callerNode, _childNode);
        }
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
