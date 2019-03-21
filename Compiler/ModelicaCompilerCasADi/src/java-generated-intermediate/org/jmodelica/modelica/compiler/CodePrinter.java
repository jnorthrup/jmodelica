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
 * @aspect CCodeGen
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:996
 */
public abstract class CodePrinter extends Printer {
    
	    public abstract void genOdeDerivativeBlocksInitReinit(StructuredBLT sblt, CodePrinter p, CodeStream str, String indent);

    
	    public abstract void genOdeDerivativeBlocksWriteBackReinit(StructuredBLT sblt, CodePrinter p, CodeStream str, String indent);

    
        public abstract void printAssign(FType type, CodeStream str, String indent, ASTNode left, ASTNode right);

    
        public abstract void printInit(FAbstractVariable v, CodeStream str, String indent, FType type);

    public abstract void printTempInputDecl(FAbstractVariable v, TempScope ts, CodeStream str, String indent);

    public abstract void printInputInit(CodeStream str, String indent, FVariable v);

    
        public abstract void genBlockResidualSetUpFunctionDecl(AbstractEquationBlock block, CodePrinter p, CodeStream str, String outerIndent);

    
        public abstract void genBlockResidualFunctionName(AbstractEquationBlock block, CodePrinter p, CodeStream str);

    
        public abstract void genBlockResidualFunctionArgumentList(AbstractEquationBlock block, CodePrinter p, CodeStream str);

    
        public abstract void genBlockResidualFunctionVectorDecls(AbstractEquationBlock block, CodePrinter p, CodeStream str, String indent);

    
        public abstract void genResidualFunctionEvalModes(AbstractEquationBlock block, CodePrinter p, CodeStream str, String indent, int generateSparseThreshold);

    public C_blockResidualAttributePrinter C_blockResidualAttributePrinter = new C_blockResidualAttributePrinter();

    
        public static class C_blockResidualAttributePrinter {
            public void print(CodePrinter p, CodeStream str, String indent, String attr, 
                    Map<FVariable, String> iterVarMap, boolean set) {
                if (!set) {
                    for (Map.Entry<FVariable, String> iterEntry : iterVarMap.entrySet()) {
                        FExp exp = attributeExp(iterEntry.getKey(), attr);
                        if (exp != null) {
                            p.printVarDecls(exp, str, indent);
                        }
                    }
                }
                for (Map.Entry<FVariable, String> iterEntry : iterVarMap.entrySet()) {
                    FVariable iv = iterEntry.getKey();
                    if (attributeSet(iv, attr)) {
                        if (set) {
                            str.format("%s%s = 1;\n", indent, iterEntry.getValue());
                        } else {
                            FExp exp = attributeExp(iv, attr);
                            if (exp != null) {
                                p.printPreSteps(exp, str, indent);
                                str.print(indent);
                                str.print(iterEntry.getValue());
                                str.print(" = ");
                                p.print(exp, str, indent);
                                str.print(";\n");
                                p.printPostSteps(exp, str, indent);
                            }
                        }
                    }
                }
            }
            
            private Collection<String> attributes = Arrays.asList(FAttribute.START, FAttribute.MIN, FAttribute.MAX, FAttribute.NOMINAL);

            public void printVariability(CodePrinter p, CodeStream str, String indent, Collection<FVariable> iterVars) {
                TypePrefixVariability variability = Variability.CONSTANT;
                for (FVariable var : iterVars) {
                    for (String attr : attributes) {
                        FExp exp = attributeExp(var, attr);
                        if (exp != null) {
                            variability = variability.combine(exp.variability());
                        }
                    }
                    
                }
                str.print(variability.genJMIVariabilityConstant_C() + ", ");
            }
            
            public boolean attributeSet(String attr, Map<FVariable, String> iterVarMap) {
                for (FVariable fv : iterVarMap.keySet()) {
                    if (attributeSet(fv, attr)) {
                        return true;
                    }
                }
                return false;
            }
            
            public boolean attributeSet(FVariable var, String attr) {
                return var.attributeSet(attr);
            }
            
            public FExp attributeExp(FVariable var, String attr) {
                return var.attributeExp(attr);
            }

        }

    
        public abstract void printResidual(FType type, CodeStream str, String indent,
                ASTNode left, ASTNode right, int index);

    public abstract void printTempSwap(FAbstractVariable v, TempScope ts, CodeStream str, String indent);

    public abstract boolean inGeneratedFunctionCall(FExp exp);

    public abstract void print(IOComputation ioc, CodeStream str, String indent, CFuncParamDirection direction,
            Iterable<FExp> args);

    public abstract FExp[] returnArguments(FExp exp);

    
        public abstract boolean needsTemp(Named_C exp);

    
        public abstract boolean needsStatement(FFunctionCall call);

    
        public abstract void printCall(FFunctionCall call, CodeStream str, String indent);

    
        public abstract void print(TypePrintable_C n, String indent, FType type, TypePrinter_C tp);

    public abstract boolean shouldPrintFuncDecl(FFunctionDecl ffd);

    
        public abstract void print(IOComputation ioc, CodeStream str, String indent, 
                ArrayList<FFunctionVariable> variables);

    
        public abstract void printExpHeader(FFunctionDecl fd, CodeStream str, String indent);

    
        public abstract void printExpFunc(FFunctionDecl fd, CodeStream str, String indent);

    
        public abstract String functionDefSuffix();

    
        public abstract void printFunctionBody(FFunctionDecl fd, CodeStream str, String indent);

    
        public abstract void printReturnWrite(FFunctionVariable v, CodeStream str, String indent);

    public abstract boolean functionCallIsExp(FFunctionCall call);

    
        public abstract void print(IOComputation ioc, CodeStream str, String indent,
                ArrayList<FFunctionVariable> variables, Iterable<FExp> args);

    
        public abstract void print(IOComputation ioc, CodeStream str, String indent, 
                ArrayList<FFunctionVariable> variables, ArrayList<FFunctionCallLeft> args);

    
        protected final FuncCallInArgPrinter funcCallInArgPrinter = new FuncCallInArgPrinter(false);

    
        protected final FuncCallInArgPrinter memCpyFuncCallInArgPrinter = new FuncCallInArgPrinter(true);

    
        
        public class FuncCallInArgPrinter extends CodeFuncCallInOutArgPrinter {
            
            protected FuncCallInArgPrinter(boolean useMemcpy) {
                super(useMemcpy);
            }
            
            @Override
            public String arrayAccessConst() {
                return ASTNode.C_ARRAY_REFERENCE;
            }

            @Override
            public void printCellExp(CodeStream str, String indent, String name, FExp exp) {
                exp.genTempInputCellAssigns_C(CodePrinter.this, str, indent, name);
            }

            @Override
            protected void printCellMemcpyUse(CodeStream str, String indent, String firstName, FAccessExp firstUse, int n) {
                firstUse.genTempInputCellAssignsMemcpy_C(str, indent, firstName, n);
            }
            
            public void printAssign(CodeStream str, String indent, String name, FExp exp) {
                str.print(indent, "JMI_ASG(", exp.type().macroType(), ", ", name, ", ");
                CodePrinter.this.print(exp, str, indent);
                str.print(")\n");
            }
        }

    

        public abstract void printTempInputAssigns(CodeStream str, String indent, FExp exp);

    public abstract void printTempInputAssigns(CodeStream str, String indent, TempScope ts, FAbstractVariable v);

    
        public abstract class FuncCallOutArgPrinter extends CodeFuncCallInOutArgPrinter {
            
            protected FuncCallOutArgPrinter(boolean useMemcpy) {
                super(useMemcpy);
            }

            @Override
            public String arrayAccessConst() {
                return ASTNode.C_ARRAY_VALUE;
            }

            @Override
            public void printCellExp(CodeStream str, String indent, String name, FExp exp) {
                throw new UnsupportedOperationException("No implementation for FuncCallOutArgPrinter.printCellExp for type '" + exp.getClass().getSimpleName() + "'. Printer is " + getClass().getSimpleName());
            }

            @Override
            public abstract void printCellUse(CodeStream str, String indent, String name, FAccessExp exp);
            
            public void printAssign(CodeStream str, String indent, String name, FExp exp) {
                str.print(indent, "JMI_ASG(", exp.type().macroType(), ", ");
                CodePrinter.this.print(exp, str, indent);
                str.print(", ", name, ")");
            }
        }

    
        public class WriteBackResidualPrinter extends FuncCallOutArgPrinter {
            protected final Enumerator enumerator;
            protected final Set<Integer> forIndices;
            protected final Enumerator indexCounter;
    
            protected WriteBackResidualPrinter(Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter) {
                super(false);
                this.enumerator = enumerator;
                this.forIndices = forIndices;
                this.indexCounter = indexCounter;
            }

            @Override
            public void printCellUse(CodeStream str, String indent, String name, FAccessExp use) {
                use.myFV().genWriteBackResidual(ASTNode.printer_C.ExecStep, str, indent, use, name, enumerator, forIndices, indexCounter);
            }
            
        }

    

        public abstract void printWriteBackResidual(CodeStream str, String indent, FFunctionCallLeft left,
                Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter);

    
        public abstract void printWriteBackResidual(CodeStream str, String indent, FAbstractVariable v, FAlgorithm alg,
                Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter);

    
        public class WriteBackAssignmentPrinter extends FuncCallOutArgPrinter {
            protected Collection<FVariable> forVariables;

            protected WriteBackAssignmentPrinter(boolean useMemcpy, Collection<FVariable> forVariables) {
                super(useMemcpy);
                this.forVariables = forVariables;
            }

            @Override
            public void printCellUse(CodeStream str, String indent, String name, FAccessExp use) {
                use.myFV().genWriteBackAssignment(ASTNode.printer_C.ExecStep, str, indent, use, name, forVariables);
            }

            @Override
            public boolean shouldPrint(FAccessExp use) {
                return forVariables == null || forVariables.contains(use.myFV());
            }

            @Override
            protected void printCellMemcpyUse(CodeStream str, String indent, String firstName, FAccessExp firstUse, int n) {
                firstUse.genArrayWriteBackAssignment_C(CodePrinter.this, str, indent, firstName, n);
            }
       }

    

        public abstract void printWriteBackAssignment(CodeStream str, String indent, FCompositeWriteBackNode node,
                Collection<FVariable> forVariables);

    

        public abstract void printWriteBackAssignment(CodeStream str, String indent, FAbstractVariable v, FAlgorithm alg,
                Collection<FVariable> forVariables);

    public abstract String funcNameUnderscore(FCallable fc, String suffix);

    public abstract int numArguments(FFunctionDecl ffd, Collection<FFunctionVariable> vars);

    public abstract boolean needsOutputVarArgs();

    public abstract void printCastArgument(FExp arg, CodeStream str, String indent);

    
        
        /**
         * A list of code generator providers. Each provider in this list is
         * called in the constructor of CodePrinter.
         */
        private static Collection<CodeGeneratorProvider> providers = null;

    
        
        /**
         * Adds a CodeGeneratorProvider to the list of providers.
         */
        private static <T extends CodeGeneratorProvider> T addProvider(T provider) {
            if (providers == null)
                providers = new PriorityQueue<CodeGeneratorProvider>();
            providers.add(provider);
            return provider;
        }

    
        
        /**
         * Returns the list of CodeGeneratorProvider providers.
         */
        public Collection<CodeGeneratorProvider> getProviders() {
            if (providers == null)
                return Collections.emptyList();
            else
                return providers;
        }

    

        private final AbstractEquationBlock block;

    
        private final boolean inInitialSystem;

    
        private final Homotopy homotopyType;

    
        private final boolean writeSwitches;

    

        public CodePrinter(AbstractEquationBlock block, boolean inInitialSystem, Homotopy homotopyType, boolean writeSwitches) {
            super("    ");
            for (CodeGeneratorProvider provider : getProviders())
                provider.provide(this);
            this.block = block;
            this.inInitialSystem = inInitialSystem;
            this.homotopyType = homotopyType;
            this.writeSwitches = writeSwitches;
        }

    
        
        /**
         * Abstract base class for code generator providers. Features that
         * needs to affect the code gen process should extend this object and
         * add it to the list of providers.
         */
        private abstract static class CodeGeneratorProvider implements Comparable<CodeGeneratorProvider> {
            private final int priority;
            
            /**
             * Constructs a new provider.
             * The argument priority controls the order of wich providers are
             * called. Providers are called in ascending order.
             * 
             * @param priority Denotes the priority of this provider.
             */
            private CodeGeneratorProvider(int priority) {
                this.priority = priority;
            }
            
            @Override
            public int compareTo(CodeGeneratorProvider other) {
                return Integer.valueOf(priority).compareTo(Integer.valueOf(other.priority));
            }
            
            /**
             * Abstract method that should be implemented by sub classes.
             * The provider is then free to modify the CodePrinter object
             * and redefine code generators.
             */
            public abstract void provide(CodePrinter p);
        }

    
        

        @Override
        public abstract void print(ASTNode node, CodeStream str, String indent);

    

        public abstract void printVarDecls(ASTNode node, CodeStream str, String indent);

    
        
        public abstract void printDecl(ASTNode node, CodeStream str, String indent, Set<ASTNode> visited, Collection<FVariable> forVariables, boolean solved);

    

        public abstract void printPreSteps(ASTNode node, CodeStream str, String indent);

    
        
        public abstract void printPostSteps(ASTNode node, CodeStream str, String indent);

    

        public boolean inBlock() {
            return block != null;
        }

    
        
        public AbstractEquationBlock getBlock() {
            return block;
        }

    

        protected abstract CodePrinter createPrinter(AbstractEquationBlock block, boolean inInitialSystem, Homotopy homotopyType,
                boolean writeSwitches);

    

        public final CodePrinter initialSystemPrinter() {
            if (inInitialSystem())
                return this;
            else
                return createPrinter(block, true, homotopyType, writeSwitches);
        }

    

        public final CodePrinter normalSystemPrinter() {
            if (!inInitialSystem())
                return this;
            else
                return createPrinter(block, false, homotopyType, writeSwitches);
        }

    

        public final CodePrinter homotopySimplifiedPrinter() {
            if (homotopyType == Homotopy.SIMPLIFIED)
                return this;
            else
                return createPrinter(block, inInitialSystem, Homotopy.SIMPLIFIED, writeSwitches);
        }

    
        
        public final CodePrinter eventIndicatorPrinter() {
            if (writeSwitches) {
                return createPrinter(block, inInitialSystem, homotopyType, false);
            }
            return this;
        }

    

        public final CodePrinter evalPrinter() {
            if (!writeSwitches) {
                return createPrinter(block, inInitialSystem, homotopyType, true);
            }
            return this;
        }

    

        public boolean inInitialSystem() {
            return inInitialSystem;
        }

    
        
        public boolean writeSwitches() {
            return writeSwitches;
        }

    
        
        protected static enum Homotopy {
            HOMOTOPY, SIMPLIFIED, ACTUAL
        }

    
        
        public boolean inHomotopySimplified() {
            return homotopyType == Homotopy.SIMPLIFIED;
        }

    

        public boolean inHomotopyActual() {
            return homotopyType == Homotopy.ACTUAL;
        }

    
        
        /**
         * Generates the actual JMI call that solves the block in question.
         */
        public abstract void genBlockResidualCall(AbstractEquationBlock node, CodeStream str, String indent);

    

        /**
         * Produce c-statements that solves the equation in question.
         * 
         * @param node Equation which is going to be printed
         * @param str Output stream
         * @param indent Indentation
         * @param visited Set of visited equations
         * @param forVariables A collection of variables which we are producing
         *      statements for
         * @param forIndices The integer indices that we are producing
         *      statements for
         */
        public abstract void genSolved(FAbstractEquation node, CodeStream str, String indent,
                Set<FAbstractEquation> visited, Collection<FVariable> forVariables, Collection<Integer> forIndices);

    

        /**
         * Produce c-statements that forms an residual for the equation in
         * question.
         * 
         * @param node Equation which is going to be printed
         * @param str Output stream
         * @param indent Indentation
         * @param enumerator An enumerator which enumerates the residual vector.
         * @param visited Set of visited equations
         * @param forIndices The integer indices that we are producing
         *      statements for
         */
        public abstract void genResidual(FAbstractEquation node, CodeStream str, String indent,
                Enumerator enumerator, Set<FAbstractEquation> visited, Set<Integer> forIndices);

    

        @Override
        public String op(FBinExp e) { return e.op_C(); }

    

        public abstract TypePrinter_C createDeclPrinter(CodeStream str);

    
        public abstract TypePrinter_C createInitPrinter(CodeStream str);

    
        public abstract TypePrinter_C createInitSetPrinter(CodeStream str);

    
        
        public String sep() {
            return ", ";
        }

    
        public abstract class StepPrinter {
            public CodePrinter codePrinter() { return CodePrinter.this; }
            public abstract void print(ASTNode n, CodeStream str, String indent);
            public abstract void printIO(FExp n, CodeStream str, String indent);
            public void print(CodeStream str, String s) {
                
            }
        }

    
        
        public StepPrinter DeclStep  = new DeclCodePrinter();

    
        public StepPrinter PreStep   = new PreCodePrinter();

    
        public ExecuteCodePrinter ExecStep  = new ExecuteCodePrinter();

    
        public StepPrinter PostStep  = new PostCodePrinter();

    
        
        public ExecuteCodePrinter getExecStep() {
            return ExecStep;
        }

    
        
        class DeclCodePrinter extends StepPrinter {
            @Override
            public void print(ASTNode n, CodeStream str, String indent) {
                codePrinter().printVarDecls(n, str, indent);
            }
            @Override
            public void printIO(FExp n, CodeStream str, String indent) {
                print(n, str, indent);
                codePrinter().printIODecl(n, str, indent);
            }
        }

    
        
        class PreCodePrinter extends StepPrinter {
            @Override
            public void print(ASTNode n, CodeStream str, String indent) {
                codePrinter().printPreSteps(n, str, indent);
            }
            @Override
            public void printIO(FExp n, CodeStream str, String indent) {
                print(n, str, indent);
                codePrinter().printIOPre(n, str, indent);
            }
        }

    
        
        class ExecuteCodePrinter extends StepPrinter {
            
            public boolean isDer() { //Hook to facilitate extensions
                return false;
            }

            @Override
            public void print(ASTNode n, CodeStream str, String indent) {
                codePrinter().print(n, str, indent);
            }
            @Override
            public void printIO(FExp n, CodeStream str, String indent) {
                codePrinter().printIOExec(n, str, indent);
            }
            
            @Override
            public void print(CodeStream str, String s) {
                str.print(s);
            }

            public void print(FFunctionVariable v, CodeStream str, String indent, IOComputation ioc) {
                ioc.print(v, this, str, indent);
            }

            public void print(FFunctionVariable v, FExp arg, CodeStream str, String indent, IOComputation ioc) {
                ioc.print(v, arg, this, str, indent);
            }

            public void print(FFunctionVariable v, FFunctionCallLeft arg, CodeStream str, String indent,
                    IOComputation ioc) {
                ioc.print(v, arg, this, str, indent);
            }

            public void printEmptyOutput(FFunctionVariable v, CodeStream str, String indent, String sep) {
                str.print(sep);
                str.print("NULL");
            }

            public String returnName(FFunctionVariable v) {
                return v.nameReturn_C();
            }
            
            public String name(Named_C exp) {
                if (needsTemp(exp)) {
                    return exp.tempName_C();
                } else {
                    return exp.name_C();
                }
            }
            
            public String type(FAbstractVariable v) {
                return v.type_C(codePrinter());
            }
            
            public String tempName(FAbstractVariable v, TempScope ts) {
                return ts.tempName_C(v);
            }
            
            public String guardedFunctionName(FExp exp) {
                return exp.guardedFunctionName_C();
            }

            public String residual() {
                return "res";
            }
        }

    
        
        class PostCodePrinter extends StepPrinter {
            @Override
            public void print(ASTNode n, CodeStream str, String indent) {
                codePrinter().printPostSteps(n, str, indent);
            }
            @Override
            public void printIO(FExp n, CodeStream str, String indent) {
                print(n, str, indent);
            }
        }

    
        public abstract void printIODecl(FExp n, CodeStream str, String indent);

    
        public abstract void printIOPre(FExp n, CodeStream str, String indent);

    
        public abstract void printIOExec(FExp n, CodeStream str, String indent);


}
