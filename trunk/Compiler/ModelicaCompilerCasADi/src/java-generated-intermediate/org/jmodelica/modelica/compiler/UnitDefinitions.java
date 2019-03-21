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
 * @ast class
 * @aspect UnitDefinitions
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\units\\UnitDefinitions.jrag:9
 */
abstract class UnitDefinitions extends java.lang.Object {
    
        
        public static final Map<String, Unit> unitSymbols;

    
        public static final Map<String, Double> prefixScales;

    
        
        static {
            // The parser tests for each prefix in the order below.
            // for example if d was before da it would always find d and never check da.
            // Thankfully that is the only such overlap.
            // I use a LinkedHashMap to preserve the order.
            LinkedHashMap<String, Double> ps = new LinkedHashMap<String, Double>();
            
            // Add all the prefixes
            ps.put("Y", 1e24);
            ps.put("Z", 1e21);
            ps.put("E", 1e18);
            ps.put("P", 1e15);
            ps.put("T", 1e12);
            ps.put("G", 1e9);
            ps.put("M", 1e6);
            ps.put("k", 1e3);
            ps.put("h", 1e2);
            ps.put("da", 1e1);
            ps.put("d", 1e-1);
            ps.put("c", 1e-2);
            ps.put("m", 1e-3);
            ps.put("u", 1e-6);
            ps.put("n", 1e-9);
            ps.put("p", 1e-12);
            ps.put("f", 1e-15);
            ps.put("a", 1e-18);
            ps.put("z", 1e-21);
            ps.put("y", 1e-24);
            
            // Make constant
            prefixScales = Collections.unmodifiableMap(ps);
            
            // Create map of units symbols.
            Map<String, Unit> sym = new HashMap<String, Unit>();
            
            // SI 'base'-units
            Unit meter      = Unit.fromDimension(Dimension.Length, "m");
            Unit second     = Unit.fromDimension(Dimension.Time, "s");
            Unit kilogram   = Unit.fromDimension(Dimension.Mass, "kg");
            Unit gram       = Unit.fromDimension(Dimension.Mass, 0.001, "g");
            Unit ampere     = Unit.fromDimension(Dimension.Current, "A");
            Unit kelvin     = Unit.fromDimension(Dimension.Temperature, "K");
            Unit mole       = Unit.fromDimension(Dimension.SubstanceAmount, "mol");
            Unit candela    = Unit.fromDimension(Dimension.LuminousIntensity, "cd");
            
            sym.put("m", meter);
            sym.put("s", second);
            sym.put("g", gram);
            sym.put("A", ampere);
            sym.put("K", kelvin);
            sym.put("mol", mole);
            sym.put("cd", candela);
            
            // add derived SI units, such as Newton, Joule, Watt, Volt, etc.
            Unit meter2     = meter.power(2);
            Unit radian     = Unit.UNIT;
            Unit steradian  = Unit.UNIT;
            Unit hertz      = second.power(-1);
            Unit newton     = kilogram.multiply(meter).divideBy(second.power(2));
            Unit pascal     = newton.divideBy(meter2);
            Unit joule      = newton.multiply(meter);
            Unit watt       = joule.divideBy(second);
            Unit coloumb    = ampere.multiply(second);
            Unit volt       = watt.divideBy(ampere);
            Unit weber      = volt.multiply(second);
            Unit lumen      = candela.multiply(steradian);
            Unit becquerel  = hertz;
            Unit gray       = joule.divideBy(kilogram);
            Unit sievert    = gray;
            
            sym.put("rad",  Unit.UNIT);
            sym.put("sr",   Unit.UNIT);
            sym.put("Hz",   second.power(-1));
            sym.put("N",    newton);
            sym.put("Pa",   pascal);
            sym.put("J",    joule);
            sym.put("W",    watt);
            sym.put("C",    coloumb);
            sym.put("V",    volt);
            sym.put("F",    coloumb.divideBy(volt));
            sym.put("Ohm",  volt.divideBy(ampere));
            sym.put("S",    ampere.divideBy(volt));
            sym.put("Wb",   weber);
            sym.put("T",    weber.divideBy(meter2));
            sym.put("H",    weber.divideBy(ampere));
            sym.put("degC", kelvin.offset(273.15));
            sym.put("lm",   lumen);
            sym.put("lx",   lumen.divideBy(meter2));
            sym.put("Bq",   becquerel);
            sym.put("Gy",   gray);
            sym.put("Sv",   sievert);
            sym.put("kat",  mole.divideBy(second));
            
            //TODO add common non-SI units
            Unit minute = second.multiply(60);
            Unit hour   = minute.multiply(60);
            Unit day    = hour.multiply(24);
            
            sym.put("min",  minute);
            sym.put("h",    hour);
            sym.put("d",    day);
            
            sym.put("deg",  radian.multiply(Math.PI/180));
            sym.put("r",    radian.multiply(2*Math.PI));   // "revolution" as in "revolutions per minute" [r/min]
            sym.put("l",    meter.multiply(0.1).power(3)); // dm3, decimeter cubed. 
            sym.put("dB",   Unit.UNIT);
            sym.put("eV",   joule.multiply(0.160218e-18)); // 0.160218 aJ
            sym.put("bar",  pascal.multiply(1e5));         // 0.1 MPa
            sym.put("phon", Unit.UNIT);
            sym.put("sone", Unit.UNIT);
            
            sym.put("degF", kelvin.multiply(5.0/9.0).offset(459.67));
            
            // Rename units to their defined name
            for (Entry<String, Unit> e: sym.entrySet()) {
                e.setValue(e.getValue().rename(e.getKey()));
            }
            
            // Make constant
            unitSymbols = Collections.unmodifiableMap(sym);
        }


}
