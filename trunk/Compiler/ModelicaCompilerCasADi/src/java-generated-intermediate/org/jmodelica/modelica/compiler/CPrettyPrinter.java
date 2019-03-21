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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:39
 */
public class CPrettyPrinter extends CodePrinter {
    

        public CPrettyPrinter() {
            this(null, false, Homotopy.HOMOTOPY, true);
        }

    
        
        public CPrettyPrinter(AbstractEquationBlock block) {
            this(block, false, Homotopy.HOMOTOPY, false);
        }

    

        protected CPrettyPrinter(AbstractEquationBlock block, boolean inInitialSystem, Homotopy homotopyType,
                boolean writeSwitches) {
            super(block, inInitialSystem, homotopyType, writeSwitches);
        }

    

        @Override
        protected CodePrinter createPrinter(AbstractEquationBlock block, boolean inInitialSystem, Homotopy homotopyType,
                boolean writeSwitches) {
            return new CPrettyPrinter(block, inInitialSystem, homotopyType, writeSwitches);
        }

    

        @Override
        public void print(ASTNode node, CodeStream str, String indent) { 
            node.prettyPrint_C(this, str, indent); 
        }

    

        @Override
        public void printVarDecls(ASTNode node, CodeStream str, String indent) {
            node.genVarDecls_C(this, str, indent);
        }

    
        
        @Override
        public void printDecl(ASTNode node, CodeStream str, String indent, Set<ASTNode> visited, Collection<FVariable> forVariables, boolean solved) {
            node.printDecl_C(this, str, indent, visited, forVariables, solved);
        }

    
        
        @Override
        public void printPreSteps(ASTNode node, CodeStream str, String indent) {
            node.genTempVars_C(this, str, indent);
        }

    
        
        @Override
        public void printPostSteps(ASTNode node, CodeStream str, String indent) {
            node.genTempFree_C(this, str, indent);
        }

    

        @Override
        public TypePrinter_C createDeclPrinter(CodeStream str) {
            return new DeclPrinter_C(this, str);
        }

    
        
        @Override
        public TypePrinter_C createInitPrinter(CodeStream str) {
            return new InitPrinter_C(this, str);
        }

    
        
        @Override
        public TypePrinter_C createInitSetPrinter(CodeStream str) {
            return new InitSetPrinter_C(this, str);
        }

    

        @Override
        public void genBlockResidualCall(AbstractEquationBlock block, CodeStream str, String indent) {
            block.genBlockResidualCall_C(this, str, indent);
        }

    

        @Override
        public void genSolved(FAbstractEquation node, CodeStream str, String indent,
                Set<FAbstractEquation> visited, Collection<FVariable> forVariables, Collection<Integer> forIndices) {
            node.genBlock_C(this, str, indent, visited, forVariables, forIndices);
        }

    

        @Override
        public void genResidual(FAbstractEquation node, CodeStream str, String indent, Enumerator enumerator,
                Set<FAbstractEquation> visited, Set<Integer> forIndices) {
            node.genResidual_C(this, str, indent, enumerator, visited, forIndices);
        }

    
	    public void genOdeDerivativeBlocksInitReinit(StructuredBLT sblt, CodePrinter p, CodeStream str, String indent) {
			sblt.genOdeDerivativeBlocksInitReinit(p, str, indent);
	    }

    
	    public void genOdeDerivativeBlocksWriteBackReinit(StructuredBLT sblt, CodePrinter p, CodeStream str, String indent) {
            sblt.genOdeDerivativeBlocksWriteBackReinit(p, str, indent);
	    }

    
        @Override
        public void printAssign(FType type, CodeStream str, String indent, ASTNode left, ASTNode right) {
            type.printAssign(ExecStep, str, indent, left, right);
        }

    
        @Override
        public void printInit(FAbstractVariable v, CodeStream str, String indent, FType type) {
            v.printInit(ExecStep, str, indent, type);
        }

    @Override
    public void printTempInputDecl(FAbstractVariable v, TempScope ts, CodeStream str, String indent) {
        v.type().printScalarDecl_C(this, str, indent, false, ts.tempName_C(v));
    }

    @Override
    public void printInputInit(CodeStream str, String indent, FVariable v) {
        v.algorithmInit(ExecStep, str, indent);
    }

    
        @Override
        public void genBlockResidualSetUpFunctionDecl(AbstractEquationBlock block, CodePrinter p, CodeStream str, String outerIndent) {
            block.genBlockResidualSetUpFunctionDecl_C(p, str, outerIndent);
        }

    
        @Override
        public void genBlockResidualFunctionVectorDecls(AbstractEquationBlock block, CodePrinter p, CodeStream str, String indent) {
            block.genBlockResidualFunctionVectorDecls_C(p, str, indent);
        }

    
        @Override
        public void genResidualFunctionEvalModes(AbstractEquationBlock block, CodePrinter p, CodeStream str, String indent, int generateSparseThreshold) {
            block.genResidualFunctionEvalModes_C(p, str, indent, generateSparseThreshold);
        }

    
        @Override
        public void genBlockResidualFunctionName(AbstractEquationBlock block, CodePrinter p, CodeStream str) {
            block.genBlockResidualFunctionName2_C(p, str);
        }

    
        @Override
        public void genBlockResidualFunctionArgumentList(AbstractEquationBlock block, CodePrinter p, CodeStream str) {
            block.genBlockResidualFunctionArgumentList_C(p, str);
        }

    
        @Override
        public void printResidual(FType type, CodeStream str, String indent,
                ASTNode left, ASTNode right, int index) {
            type.printResidual(ExecStep, str, indent, left, right, index);
        }

    @Override
    public void printTempSwap(FAbstractVariable v, TempScope ts, CodeStream str, String indent)  {
        v.genTempSwap(ExecStep, ts, str, indent);
    }

    public boolean inGeneratedFunctionCall(FExp exp) {
        return false;
    }

    @Override
    public void print(IOComputation ioc, CodeStream str, String indent, CFuncParamDirection direction,
            Iterable<FExp> args) {
        ioc.print(ExecStep, str, indent, direction, args);
    }

    @Override
    public FExp[] returnArguments(FExp exp) {
        return exp.returnArguments_C();
    }

    
        @Override
        public boolean needsTemp(Named_C exp) {
            return exp.needsTemp_C();
        }

    
        
        @Override
        public boolean needsStatement(FFunctionCall call) {
            return call.needsStatement_C(this);
        }

    
        
        @Override
        public void printCall(FFunctionCall call, CodeStream str, String indent) {
            call.myFCallable().prettyPrintCall(this, str, indent, call);
        }

    
        
        @Override
        public void print(TypePrintable_C n, String indent, FType type, TypePrinter_C tp) {
            type.print(tp, indent, ExecStep, n, false);
        }

    @Override
    public boolean shouldPrintFuncDecl(FFunctionDecl ffd) {
        return ffd.shouldPrintFuncDecl_C();
    }

    
        @Override
        public void print(IOComputation ioc, CodeStream str, String indent, ArrayList<FFunctionVariable> variables) {
            ioc.print(ExecStep, str, indent, variables);
        }

    
        @Override
        public void printExpHeader(FFunctionDecl fd, CodeStream str, String indent) {
            fd.printExpHeader_C(this, str, indent);
        }

    
        @Override
        public void printExpFunc(FFunctionDecl fd, CodeStream str, String indent) {
            fd.prettyPrintExpFunc_C(this, str, indent);
        }

    
        
        @Override
        public String functionDefSuffix() {
            return ASTNode.C_SUFFIX_DEF;
        }

    
        @Override
        public void printFunctionBody(FFunctionDecl fd, CodeStream str, String indent) {
            fd.genFunctionBodyAlgorithm(this, str, indent);
        }

    
        @Override
        public void printReturnWrite(FFunctionVariable v, CodeStream str, String indent) {
            v.printReturnWrite(ExecStep, str, indent);
        }

    @Override
    public boolean functionCallIsExp(FFunctionCall call) {
        return call.functionCallIsExp();
    }

    
        @Override
        public void print(IOComputation ioc, CodeStream str, String indent,
                ArrayList<FFunctionVariable> variables, Iterable<FExp> args) {
            ioc.print(ExecStep, str, indent, variables, args);
        }

    
        @Override
        public void print(IOComputation ioc, CodeStream str, String indent,
                ArrayList<FFunctionVariable> variables, ArrayList<FFunctionCallLeft> args) {
            ioc.print(ExecStep, str, indent, variables, args);
        }

    
        @Override
        public void printIODecl(FExp n, CodeStream str, String indent) {
            n.genTempInputDecl_C(this, str, indent);
        }

    
        @Override
        public void printIOPre(FExp n, CodeStream str, String indent) {
            n.genTempInputAssigns_C(this, str, indent);
        }

    
        @Override
        public void printIOExec(FExp n, CodeStream str, String indent) {
            n.genArgument(ExecStep, str, indent);
        }

    
        
        @Override
        public void printTempInputAssigns(CodeStream str, String indent, FExp exp) {
            if (exp.inFunction()) {
                funcCallInArgPrinter.print(str, indent, exp.type(), exp.tempName_C(), exp);
            } else {
                memCpyFuncCallInArgPrinter.print(str, indent, exp.type(), exp.tempName_C(), exp);
            }
        }

    @Override
    public void printTempInputAssigns(CodeStream str, String indent, TempScope ts, FAbstractVariable v) {
        if (v.isString()) {
            str.print(indent, "JMI_ASG(", v.type().macroType(), ", ", ts.tempName_C(v), ", ", v.name_C(), ")\n");
        } else {
            FStatement.printAssignStmt_C(str, indent, ts.tempName_C(v), v.name_C());
        }
    }

    
        @Override
        public void printWriteBackResidual(CodeStream str, String indent, FFunctionCallLeft left,
                Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter) {
            left.genWriteBackResidual_C(this, str, indent, enumerator, forIndices, indexCounter);
        }

    
        @Override
        public void printWriteBackResidual(CodeStream str, String indent, FAbstractVariable v, FAlgorithm alg,
                Enumerator enumerator, Set<Integer> forIndices, Enumerator indexCounter) {
            v.genWriteBackResidual(ExecStep, str, indent, alg, ExecStep.tempName(v, alg), enumerator, forIndices, indexCounter);
        }

    
        @Override
        public void printWriteBackAssignment(CodeStream str, String indent, FCompositeWriteBackNode node, Collection<FVariable> forVariables) {
            FExp e = node.getFExp();
            FType t = e.type();
            WriteBackAssignmentPrinter p = new WriteBackAssignmentPrinter(t.isComposite() && !e.inFunction(), forVariables);
            p.print(str, indent, t, ExecStep.name(node), e);
        }

    

        @Override
        public void printWriteBackAssignment(CodeStream str, String indent, FAbstractVariable v, FAlgorithm alg,
                Collection<FVariable> forVariables) {
            v.genWriteBackAssignment(ExecStep, str, indent, alg, alg.tempName_C(v), forVariables);
        }

    @Override
    public String funcNameUnderscore(FCallable fc, String suffix) {
        return fc.funcNameUnderscore(suffix);
    }

    @Override
    public int numArguments(FFunctionDecl ffd, Collection<FFunctionVariable> vars) {
        return vars.size();
    }

    @Override
    public boolean needsOutputVarArgs() { return false; }

    @Override
    public void printCastArgument(FExp arg, CodeStream str, String indent) {
        arg.printCastArgument(ExecStep, str, indent);
    }


}
