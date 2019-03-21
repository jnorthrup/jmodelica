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
 * @aspect Parsers
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Parser.jrag:43
 */
public final class ParserHandler extends java.lang.Object {
    
        public static final FormattingRecorder<ASTNode<?>> DEFAULT_FORMATTING_RECORDER =
                new DefaultFormattingRecorder<ASTNode<?>>();

    
        
        private final FormattingRecorder<ASTNode<?>> formattingRecorder;

    

        public ParserHandler() {
            this(DEFAULT_FORMATTING_RECORDER);
        }

    

        public ParserHandler(FormattingRecorder<ASTNode<?>> formattingRecorder) {
            this.formattingRecorder = formattingRecorder;
        }

    public SourceRoot parseModel(UtilInterface uif, String name) 
      throws FileNotFoundException, IOException, beaver.Parser.Exception, CompilerException{
        ModelicaCompiler.log.info("Parsing " + name + "...");
        SourceRoot sr;
        try {
            sr = parseFile(uif, name);
        } catch (ParserException e) {
            CompilerException ce = new CompilerException();
            ce.addProblem(e.getProblem());
            throw ce;
        }
        //loadOptions(sr);
        for (SrcStoredDefinition sd : sr.getProgram().getUnstructuredEntitys()) {
            sd.setFileName(name);
        }
        return sr;
    }

    public SourceRoot parseModel(UtilInterface uif, String[] names) 
            throws FileNotFoundException, IOException, beaver.Parser.Exception, CompilerException{
        SourceRoot sr = new SourceRoot(new Program());
        uif.transferRoot(sr);
        for (String name : names) {
            File f = new File(name);
            String name_tmp = name;
            if (f.isDirectory()) 
                name_tmp = SrcLibNode.packageFile(f);
            SourceRoot sr_tmp = (name_tmp != null) ? parseModel(uif, name_tmp) : null;
            if (!uif.getOptionRegistry().getBooleanOption("ignore_within")) {
                String lib = null;
                if (sr_tmp != null && sr_tmp.isFileInLibrary()) 
                    lib = sr_tmp.findOutermostLibraryDir();
                else if (SrcLibNode.isPackageFile(f))
                    lib = f.getParent();
                if (lib != null) {
                    String type = f.isDirectory() ? "Directory" : "File";
                    ModelicaCompiler.log.warning("%s '%s' is part of library at '%s', using library instead.", type, name, lib);
                    name = lib;
                    f = new File(name);
                }
            }
            if (f.isDirectory()) {
                if (!sr.getProgram().getLibraryList().addLibrary(name, SrcLibNode.LoadReason.COMMANDLINE)) 
                    ModelicaCompiler.log.error(String.format("Error: The directory '%s' is not a Modelica library.", name));
            } else {
                for (SrcStoredDefinition sd : sr_tmp.getProgram().getUnstructuredEntitys()) 
                    sr.getProgram().addUnstructuredEntity(sd);
            }
        }
        return sr;
    }

    public beaver.Parser createModelicaParser(AbstractModelicaScanner<ASTNode<?>> scanner, String fileName) {
        org.jmodelica.modelica.parser.ModelicaParser parser = 
            new org.jmodelica.modelica.parser.ModelicaParser();
        parser.setLineBreakMap(scanner.getLineBreakMap());
        parser.setFormattingRecorder(scanner.getFormattingRecorder());
        parser.setFileName(fileName);
        return parser;
    }

    public AbstractModelicaScanner<ASTNode<?>> createModelicaScanner(Reader in) {
        AbstractModelicaScanner<ASTNode<?>> scanner = new org.jmodelica.modelica.parser.ModelicaScanner(in);
        scanner.setFormattingRecorder(formattingRecorder);
        return scanner;
    }

    public AbstractFlatModelicaScanner createModelicaFlatScanner(Reader in) {
        return new org.jmodelica.modelica.parser.FlatModelicaScanner(in);
    }

    public short expModelicaGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.exp;
    }

    public short anonymousClassModelicaGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.anonymous_short_class;
    }

    public short elementGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.element;
    }

    public short abstractEquationGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.abstract_equation;
    }

    public short modifierGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.argument;
    }

    public short accessScalarGoal() {
        return org.jmodelica.modelica.parser.ModelicaParser.AltGoals.access_scalar;
    }

    public SourceRoot parseFile(UtilInterface uif, String fileName) 
            throws ParserException, beaver.Parser.Exception, FileNotFoundException, IOException {
        return parseModelicaFile(uif, fileName);
    }

    public SourceRoot parseString(UtilInterface uif, String str, String fileName) 
            throws CompilerException, beaver.Parser.Exception, IOException {
        try {
            return parseStringNoCatch(uif, str, fileName);
        } catch (ParserException e) {
            CompilerException ce = new CompilerException();
            ce.addProblem(e.getProblem());
            throw ce;
        }
    }

    public SourceRoot parseStringNoCatch(UtilInterface uif, String str, String fileName) 
            throws CompilerException, beaver.Parser.Exception, IOException {
        return parseModelicaString(uif, str, fileName);
    }

    public SrcExp parseExpString(String str)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseModelicaExpString(str);
    }

    public SrcBaseClassDecl parseAnonymousClassString(String code, SrcRestriction restriction, String targetName)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseModelicaAnonymousClassString(code, restriction, targetName);
    }

    public SourceRoot parseModelicaFile(UtilInterface uif, String fileName) 
            throws ParserException, beaver.Parser.Exception, FileNotFoundException, IOException {
        Reader reader = fileReader(uif, fileName);
        try {
            return parseModelicaResource(uif, reader, fileName);
        } finally {
            reader.close();
        }
    }

    public SourceRoot parseModelicaString(UtilInterface uif, String str, String fileName) 
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseModelicaResource(uif, new StringReader(str), fileName);
    }

    public SourceRoot parseModelicaResource(UtilInterface uif, Reader resource, String fileName) 
            throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner<ASTNode<?>> scanner = createModelicaScanner(resource);
        beaver.Parser parser = createModelicaParser(scanner, fileName);
        SourceRoot sr = (SourceRoot) parser.parse(scanner);
        sr.setUtilInterface(uif);
        sr.setFileName(fileName);
        return sr;
    }

    public static final String EXP_FILENAME = "<predefined string>";

    public SrcExp parseModelicaExpString(String str)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseModelicaExpString(str, false);
    }

    public SrcExp parseModelicaExpString(String str, boolean preserveFormatting)
            throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner<ASTNode<?>> scanner = createModelicaScanner(new StringReader(str));
        beaver.Parser parser = createModelicaParser(scanner, EXP_FILENAME);
        SrcExp exp = (SrcExp) parser.parse(scanner, expModelicaGoal());
        if (preserveFormatting) {
            scanner.getFormattingRecorder().postParsing(exp);
        }
        return exp;
    }

    public static final String ANONYMOUS_CLASS_FILENAME = "<command line argument>";

    public SrcBaseClassDecl parseModelicaAnonymousClassString(String code, SrcRestriction restriction, String targetName)
            throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner scanner = createModelicaScanner(new StringReader(code));
        beaver.Parser parser = createModelicaParser(scanner, ANONYMOUS_CLASS_FILENAME);
        SrcBaseClassDecl cl = (SrcBaseClassDecl) parser.parse(scanner, anonymousClassModelicaGoal());
        cl.setSrcRestriction(restriction);
        cl.setName(new SrcIdDecl(targetName));
        return cl;
    }

    public SrcElement parseElement(String code, String parentSourceFile)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseElement(code, parentSourceFile, false);
    }

    public SrcElement parseElement(String code, String parentSourceFile, boolean preserveFormatting)
            throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner<ASTNode<?>> scanner = createModelicaScanner(new StringReader(code));
        beaver.Parser parser = createModelicaParser(scanner, parentSourceFile);
        SrcElement elem = (SrcElement) parser.parse(scanner, elementGoal());
        if (preserveFormatting) {
            scanner.getFormattingRecorder().postParsing(elem);
        }
        return elem;
    }

    public SrcAbstractEquation parseAbstractEquation(String code, String parentSourceFile)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseAbstractEquation(code, parentSourceFile, false);
    }

    public SrcAbstractEquation parseAbstractEquation(String code, String parentSourceFile,
            boolean preserveFormatting) throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner scanner = createModelicaScanner(new StringReader(code));
        beaver.Parser parser = createModelicaParser(scanner, parentSourceFile);
        SrcAbstractEquation eqn = (SrcAbstractEquation) parser.parse(scanner, abstractEquationGoal());
        if (preserveFormatting) {
            scanner.getFormattingRecorder().postParsing(eqn);
        }
        return eqn;
    }

    public SrcArgument parseModifier(String code, String parentSourceFile)
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseModifier(code, parentSourceFile, false);
    }

    public SrcArgument parseModifier(String code, String parentSourceFile,
            boolean preserveFormatting) throws ParserException, beaver.Parser.Exception, IOException {
        AbstractModelicaScanner scanner = createModelicaScanner(new StringReader(code));
        beaver.Parser parser = createModelicaParser(scanner, parentSourceFile);
        SrcArgument eqn = (SrcArgument) parser.parse(scanner, modifierGoal());
        if (preserveFormatting) {
            scanner.getFormattingRecorder().postParsing(eqn);
        }
        return eqn;
    }

    public SrcAccess parseAccessScalar(String code, String parentSourceFile) 
            throws ParserException, beaver.Parser.Exception, IOException {
        return parseAccessScalar(code, parentSourceFile, false);
    }

    public SrcAccess parseAccessScalar(String code, String parentSourceFile, boolean preserveFormatting) 
            throws ParserException, beaver.Parser.Exception, IOException {
        final AbstractModelicaScanner<ASTNode<?>> scanner = createModelicaScanner(new StringReader(code));
        final beaver.Parser parser = createModelicaParser(scanner, parentSourceFile);
        final SrcAccess srcAccess = (SrcAccess) parser.parse(scanner, accessScalarGoal());

        if (preserveFormatting) {
            scanner.getFormattingRecorder().postParsing(srcAccess);
        }

        return srcAccess;
    }

    public Reader fileReader(UtilInterface uif, File file) throws FileNotFoundException {
        return new InputStreamReader(new FileInputStream(file), ASTNode.UTF8);
    }

    public Reader fileReader(UtilInterface uif, String path) throws FileNotFoundException {
        return fileReader(uif, new File(path));
    }


}
