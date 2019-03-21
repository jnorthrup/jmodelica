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
 * @aspect BLT
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:1805
 */
public abstract class AbstractSubBLTBlock<T extends BLT> extends AbstractEquationBlock {
    
        private final T[] subBLTs;

    
        
        public AbstractSubBLTBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency, T[] subBLTs) {
            super(producer, blockDependency);
            this.subBLTs = subBLTs;
            
        }

    
        @Override
        public Collection<FAbstractEquation> realEquations() {
            Set<FAbstractEquation> res = new LinkedHashSet<FAbstractEquation>();
            for (T blt : subBLTs)
                for (AbstractEquationBlock block : blt)
                    res.addAll(block.realEquations());
            return res;
        }

    

        @Override
        public Collection<FAbstractEquation> localRealEquations() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FAbstractEquation> nonRealEquations() {
            Set<FAbstractEquation> res = new LinkedHashSet<FAbstractEquation>();
            for (T blt : subBLTs)
                for (AbstractEquationBlock block : blt)
                    res.addAll(block.nonRealEquations());
            return res;
        }

    

        @Override
        public Collection<FAbstractEquation> localNonRealEquations() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FAbstractEquation> unsolvedEquations() {
            return Collections.emptyList();
       }

    

        @Override
        public Collection<FAbstractEquation> localUnsolvedEquations() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<SimpleEquationBlock> localRealBlocks() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> realVariables() {
            Set<FVariable> res = new LinkedHashSet<FVariable>();
            for (T blt : subBLTs)
                for (AbstractEquationBlock block : blt)
                    res.addAll(block.realVariables());
            return res;
        }

    

        @Override
        public Collection<FVariable> localRealVariables() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> nonRealVariables() {
            Set<FVariable> res = new LinkedHashSet<FVariable>();
            for (T blt : subBLTs)
                for (AbstractEquationBlock block : blt)
                    res.addAll(block.nonRealVariables());
            return res;
        }

    

        @Override
        public Collection<FVariable> localDiscreteRealVariables() {
            return Collections.emptyList();
        }

    
        
        @Override
        public Collection<FVariable> localNonRealVariables() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> localSolvedRealVariables() {
            return Collections.emptyList();
        }

    
        
        @Override
        public Collection<FVariable> unsolvedVariables() {
            return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> localUnsolvedVariables() {
            return Collections.emptyList();
        }

    

        @Override
        public boolean isSolvable() {
            return false;
        }

    

        @Override
        public boolean canComputeJacobian() {
            return false;
        }

    

        @Override
        protected boolean needLabel(boolean inSubBlock) {
            return true;
        }

    

        @Override
        protected boolean needSequenceNumber(boolean inSubBlock) {
            return false;
        }

    
        
        @Override
        protected void setLabel(String prefix, boolean inBlockResidual, Enumerator nestedEnum, Enumerator seqEnum) {
            super.setLabel(prefix, false, nestedEnum, seqEnum);
            for (T blt : subBLTs)
                blt.setLabels(getLabel() + '(' + computeLabel(blt) + ')', new Enumerator(1), seqEnum);
        }

    

        protected abstract String computeLabel(T blt);

    

        @Override
        public void errorCheck(FClass fclass) {
            for (T blt : subBLTs)
                blt.errorCheck(fclass);
            
        }

    
        
        protected T[] subBLTs() {
            return subBLTs;
        }

    @Override
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.formatln("%s--- %s block ---", indent, blockTypeTitle());
        String innerIndent = p.indent(indent);
        for (T blt : subBLTs)
            blt.prettyPrint(p, str, innerIndent);
    }

    public abstract String blockTypeTitle();

    @Override
    public void prettyPrintSub(Printer p, CodeStream str, String indent) {
        prettyPrint(p, str, indent);
        str.println();
    }

    @Override
    public void prettyPrintActiveVariables(Printer p, CodeStream str, String indent, boolean printAttributes, boolean printLabel) {
        throw new UnsupportedOperationException("AbstractSubBLTBlock.prettyPrintActiveVariables() is not implemented!");
    }

    @Override
    public void genSolvedInResFunc(CodePrinter p, CodeStream str, String indent,
            Set<FAbstractEquation> visited) {
        throw new UnsupportedOperationException("Can not produce solved statements for " + getClass().getSimpleName() + " in a residual function! This block type is not ment to be present inside other blocks, something has gone horribly wrong here!");
    }

    @Override
    public void genResidualPart(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited) {
        throw new UnsupportedOperationException("Can not produce residual statements for " + getClass().getSimpleName() + "! This block type does not have any residaul equations, something has gone horribly wrong here!");
    }

    @Override
    public void genBlockResidualFunction(CodePrinter p, CodeStream str, String outerIndent, int generateSparseThreshold) {

        for (T blt : subBLTs) {
            for (AbstractEquationBlock block : blt) {
                block.genBlockResidualFunction(p, str, outerIndent, generateSparseThreshold);
            }
        }
    }

    @Override
    public boolean hasEquationNominal_C(boolean auto) { return true; }

    @Override
    public void genEquationNominalVarDecl_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        throw new UnsupportedOperationException("AbstractSubBLTBlock.genEquationNominalVarDecl_C() is not implemented!");
    }

    @Override
    public void genEquationNominal_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        throw new UnsupportedOperationException("AbstractSubBLTBlock.genEquationNominal_C() is not implemented!");
    }

    @Override
    public void genBlockAddCall_C(CodePrinter p, CodeStream str, String indent, boolean dirDer,
            boolean inInit, boolean generateSparse, String nleSolver, int parentBlockNumber) {

        for (T blt : subBLTs)
            for (AbstractEquationBlock block : blt)
                block.genBlockAddCall_C(p, str, indent, dirDer, inInit, generateSparse, nleSolver, parentBlockNumber);
    }

    protected String diagnostics_generateBLTTable_color() {
    return "#FF00FF";
}


}
