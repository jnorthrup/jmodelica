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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:2037
 */
public abstract class SimpleEquationBlock extends AbstractEquationBlock {
    
        private FAbstractEquation equation;

    

        public SimpleEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency, FAbstractEquation equation) {
            super(producer, blockDependency);
            this.equation = equation;
        }

    

        public FAbstractEquation equation() {
            return equation;
        }

    

        public boolean isReal() {
            for (FVariable fv : allVariables())
                if (!fv.isReal())
                    return false;
            return true;
        }

    
        
        public boolean isDiscreteReal() {
            for (FVariable fv : allVariables())
                if (!fv.isReal() || !fv.isDiscrete())
                    return false;
            return true;
        }

    

        @Override
        public Collection<FAbstractEquation> allEquations() {
            return allLocalEquations();
        }

    

        @Override
        public Collection<FAbstractEquation> allLocalEquations() {
            return Arrays.asList(equation());
        }

    

        @Override
        public Collection<FAbstractEquation> realEquations() {
            return localRealEquations();
        }

    

        @Override
        public Collection<SimpleEquationBlock> localRealBlocks() {
            if (isReal()) {
                return Collections.singletonList(this);
            } else {
                return Collections.emptyList();
            }
        }

    

        @Override
        public Collection<FAbstractEquation> localRealEquations() {
            if (isReal())
                return allLocalEquations();
            else
                return Collections.emptyList();
        }

    

        @Override
        public Collection<FAbstractEquation> nonRealEquations() {
            return localNonRealEquations();
        }

    

        @Override
        public Collection<FAbstractEquation> localNonRealEquations() {
            if (isReal())
                return Collections.emptyList();
            else
                return allLocalEquations();
        }

    

        @Override
        public Collection<FAbstractEquation> unsolvedEquations() {
            return localUnsolvedEquations();
        }

    

        @Override
        public Collection<FAbstractEquation> localUnsolvedEquations() {
            if (isSolvable())
                return Collections.emptyList();
            else
                return allLocalEquations();
        }

    

        @Override
        public Collection<FVariable> allVariables() {
            return allLocalVariables();
        }

    

        @Override
        public abstract Collection<FVariable> allLocalVariables();

    

        @Override
        public Collection<FVariable> realVariables() {
            return localRealVariables();
        }

    

        @Override
        public Collection<FVariable> localRealVariables() {
            if (isReal())
                return allLocalVariables();
            else
                return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> nonRealVariables() {
            return localNonRealVariables();
        }

    

        @Override
        public Collection<FVariable> localDiscreteRealVariables() {
            if (!isDiscreteReal())
                return Collections.emptyList();
            else
                return allLocalVariables();
        }

    
        
        @Override
        public Collection<FVariable> localNonRealVariables() {
            if (isReal())
                return Collections.emptyList();
            else
                return allLocalVariables();
        }

    

        @Override
        public Collection<FVariable> localSolvedRealVariables() {
            if (isReal() && isSolvable())
                return allLocalVariables();
            else
                return Collections.emptyList();
        }

    

        @Override
        public Collection<FVariable> unsolvedVariables() {
            return localUnsolvedVariables();
        }

    

        @Override
        public Collection<FVariable> localUnsolvedVariables() {
            if (isSolvable())
                return Collections.emptyList();
            else
                return allLocalVariables();
        }

    

        public Collection<Integer> assignedIndices() {
            return null;
        }

    

        public boolean canComputeJacobian() {
            return true;
        }

    

        @Override
        public void errorCheck(FClass fclass) {}

    

        protected boolean needLabel(boolean inSubBlock) {
            return needSequenceNumber(inSubBlock);
        }

    

        protected boolean needSequenceNumber(boolean inSubBlock) {
            return !inSubBlock && !isSolvable();
        }

    
        
        @Override
        public boolean isSimple() {
            return true;
        }

    

        @Override
        public SimpleEquationBlock asSimple() {
            return this;
        }

    @Override
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        String innerIndent = p.indent(indent);
        if (getLabel() == null) {
            str.formatln("%s--- %s ---", indent, prettyPrintTitle());
        } else {
            str.formatln("%s--- %s (Block %s) ---", indent, prettyPrintTitle(), getLabel());
            p.prePrettyPrint(str, 0, indent);
        }
        p.print(equation(), str, indent);
        str.println();
        if (allLocalVariables().size() == 0)
            return;
        if (isSolvable())
            prettyPrintActiveVariables(p, str, innerIndent + "Assigned variables: ", innerIndent + "                    ", false);
        else
            prettyPrintActiveVariables(p, str, innerIndent + "Computed variables: ", innerIndent + "                    ", false);
    }

    @Override
    public void prettyPrintSub(Printer p, CodeStream str, String indent) {
        String innerIndent = p.indent(indent);
        p.print(equation(), str, indent);
        str.println();
        if (allLocalVariables().size() == 0)
            return;
        if (isSolvable())
            prettyPrintActiveVariables(p, str, innerIndent + "Assigned variables: ", innerIndent + "                    ", false);
        else
            prettyPrintActiveVariables(p, str, innerIndent + "Iteration variables: ", innerIndent + "                     ", false);
    }

    public abstract String prettyPrintTitle();

    @Override
    public void prettyPrintActiveVariables(Printer p, CodeStream str, String indent, boolean printAttributes, boolean printLabel) {
        prettyPrintActiveVariables(p, str, indent, indent, printAttributes, printLabel ? getLabel() : null);
    }

    public void prettyPrintActiveVariables(Printer p, CodeStream str, String indent, boolean printAttributes, String label) {
        prettyPrintActiveVariables(p, str, indent, indent, printAttributes, label);
    }

    public void prettyPrintActiveVariables(Printer p, CodeStream str, String firstIndent, String otherIndent, boolean printAttributes) {
        prettyPrintActiveVariables(p, str, firstIndent, otherIndent, printAttributes, null);
    }

    public void prettyPrintActiveVariables(Printer p, CodeStream str, String firstIndent, String otherIndent, boolean printAttributes, String label) {
        boolean first = true;
        for (FVariable fv : allLocalVariables()) {
            str.print(first ? firstIndent : otherIndent);
            if (label != null)
                str.format("(%s) ", label);
            str.print(fv.displayName());
            first = false;
            if (printAttributes) {
                str.print(" (");
                fv.printFAttributes(str, FAttribute.MIN, FAttribute.MAX, FAttribute.START, FAttribute.NOMINAL);
                str.print(")");
            }
            str.println();
        }
    }

    @Override
    protected void genSolved(CodePrinter p, CodeStream str, String indent,
            boolean inResFunc, Set<FAbstractEquation> visited) {
        if (hasResidualFunction()) {
            genBlockResidualCall(p, str, indent);
        } else if (genBlockEnabled()) {
            Collection<FVariable> forVariables = allLocalVariables();
            Collection<Integer> forIndices = assignedIndices();
            if (inResFunc && !isReal()) {
                // Non-reals needs to be handled specially in the residual functions
                if (equation().isMixed()) {
                    equation().genBlockEval_C(p, str, indent, visited, forVariables, forIndices);
                }
                if (equation().shouldProduceNonRealGuard_C(forVariables)) {
                    str.format("%sif (evaluation_mode & JMI_BLOCK_EVALUATE_NON_REALS) {\n", indent);
                    p.genSolved(equation(), str, p.indent(indent), visited, forVariables, forIndices);
                    str.format("%s}\n", indent);
                } else {
                    p.genSolved(equation(), str, indent, visited, forVariables, forIndices);
                }
            } else {
                p.genSolved(equation(), str, indent, visited, forVariables, forIndices);
            }
            if (!inResFunc && !p.inInitialSystem()) {
                // Write back of pre variables is only done in the DAE BLT
                for (FVariable var : allLocalVariables()) {
                    if (var.isDiscrete() && !var.isPreVariable()) {
                        p.printAssign(var.type(), str, indent, var.myPreVariable(), var);
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Unable to produce solving code for block of type " + getClass().getSimpleName());
        }
    }

    public boolean genBlockEnabled()             { return false; }

    @Override
    public void genResidualPart(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited) {
        genBlockResidual(p, str, indent, enumerator, visited);
    }

    @Override
    public void genBlockResidual(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited) {
        p.genResidual(equation(), str, indent, enumerator, visited,
                assignedIndices() == null ? null : new LinkedHashSet<Integer>(assignedIndices()));
    }

    @Override
    public boolean hasEquationNominal_C(boolean auto) { 
        return realVariables().size() > 0 && equation().equationNominal_C(auto) != null;
    }

    @Override
    public void genEquationNominalVarDecl_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        FExp nom = equation().equationNominal_C(auto);
        nominalMap.put(equation(), nom);
        if (nom == null) {
            return;
        }
        p.printVarDecls(nom, str, indent);
    }

    @Override
    public void genEquationNominal_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        genEquationNominal_C(p, str, indent, auto, nominalMap, new Enumerator());
    }

    public void genEquationNominal_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap, Enumerator e) {
        FExp nom = nominalMap.get(equation());
        if (nom == null) {
            return;
        }
        for (int i = 0; i < realVariables().size(); i++) {
            int num = e.next();
            if (i == 0) {
                p.printPreSteps(nom, str, indent);
                str.format("%s(*res)[%d] = ", indent, num);
                p.print(nom, str, indent);
                p.printPostSteps(nom, str, indent);
                str.print(";\n");
            } else {
                str.format("%s(*res)[%d] = (*res)[%d];\n", indent, num, num - 1);
            }
        }
    }

    public void genReinitWritebacks_C(CodePrinter p, String indent, CodeStream str) {
        Map<String, ArrayList<FReinit>> map = new LinkedHashMap<>();
        for (FReinit r : collectReinits_C(p)) {
            String key = r.getVar().toString();
            ArrayList<FReinit> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(r);
        }
        for (ArrayList<FReinit> list : map.values()) {
            for (int i = 0, n = list.size(); i < n; i++) {
                list.get(i).genReinitWritebacks_C(p, str, indent, i == 0, i == n - 1);
            }
        }
    }

    protected String diagnostics_generateBLTTable_color() {
    return "#CCF0CC";
}


}
