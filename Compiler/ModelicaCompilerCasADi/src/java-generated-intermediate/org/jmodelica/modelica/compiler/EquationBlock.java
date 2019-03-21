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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:1376
 */
public class EquationBlock extends AbstractEquationBlock {
    

        private java.util.List<SimpleEquationBlock> unsolvedBlocks = new ArrayList<SimpleEquationBlock>();

    
        private java.util.List<AbstractEquationBlock> solvedBlocks = new ArrayList<AbstractEquationBlock>();

    
        private Collection<SimpleEquationBlock> localRealBlocks_cache = null;

    
        private Collection<SimpleEquationBlock> localSolvedBlocks_cache = null;

    
        private Collection<SimpleEquationBlock> localDiscreteRealBlocks_cache = null;

    
        private Collection<SimpleEquationBlock> localNonRealBlocks_cache = null;

    
        private Collection<AbstractEquationBlock> solvedRealBlocks_cache = null;

    
        private Collection<SimpleEquationBlock> localSolvedRealBlocks_cache = null;

    
        private Collection<SimpleEquationBlock> localMetaBlocks_cache = null;

    

        protected EquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
            super(producer, blockDependency);
        }

    
        
        public EquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency, Collection<? extends AbstractEquationBlock> solvedBlocks, Collection<SimpleEquationBlock> unsolvedBlocks) {
            super(producer, blockDependency);
            AbstractEquationBlock lastSolved = null;
            for (AbstractEquationBlock block : solvedBlocks) {
                if (lastSolved == null || !lastSolved.merge(block)) {
                    this.solvedBlocks.add(block);
                    lastSolved = block;
                }
            }
            this.unsolvedBlocks.addAll(unsolvedBlocks);
        }

    
        
        private void resetCache() {
            localRealBlocks_cache = null;
            localSolvedBlocks_cache = null;
            localNonRealBlocks_cache = null;
            solvedRealBlocks_cache = null;
            localSolvedRealBlocks_cache = null;
        }

    
        
        /**
         * Addas a solved block to the list of solved blocks in this block.
         * 
         * @param block Block to add to the list of solved blocks
         */
        public void addSolvedBlock(AbstractEquationBlock block) {
            if (solvedBlocks.size() == 0 || !solvedBlocks.get(solvedBlocks.size() - 1).merge(block)) {
                solvedBlocks.add(block);
            }
            resetCache();
        }

    

        /**
         * Adds an unsolved block to this torn block.
         * 
         * @param block Block to add to the list of unsolved blocks
         */
        protected void addUnsolvedBlock(SimpleEquationBlock block) {
            unsolvedBlocks.add(block);
            resetCache();
        }

    

        /**
         * Returns all unsolved blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all sunolved blocks
         */
        public Collection<SimpleEquationBlock> unsolvedBlocks() {
            return unsolvedBlocks;
        }

    

        /**
         * Returns all solved blocks in this block.
         * 
         * @return Collection<AbstractEquationBlock> all solved blocks
         */
        public Collection<AbstractEquationBlock> solvedBlocks() {
            return solvedBlocks;
        }

    

        @Override
        public Collection<SimpleEquationBlock> localRealBlocks() {
            if (localRealBlocks_cache == null) {
                localRealBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (block.isSimple() && block.asSimple().isReal())
                        localRealBlocks_cache.add(block.asSimple());
                for (SimpleEquationBlock block : unsolvedBlocks())
                    if (block.isReal())
                        localRealBlocks_cache.add(block);
            }
            return localRealBlocks_cache;
        }

    

        /**
         * Returns all local solved blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all local solved blocks
         */
        public Collection<SimpleEquationBlock> localSolvedBlocks() {
            if (localSolvedBlocks_cache == null) {
                localSolvedBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (block.isSimple())
                        localSolvedBlocks_cache.add(block.asSimple());
            }
            return localSolvedBlocks_cache;
        }

    
        
        /**
         * Returns all local discrete real blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all local non-real blocks
         */
        public Collection<SimpleEquationBlock> localDiscreteRealBlocks() {
            if (localDiscreteRealBlocks_cache == null) {
                localDiscreteRealBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks()) {
                    if (block.isSimple() && block.asSimple().isDiscreteReal()) {
                        localDiscreteRealBlocks_cache.add(block.asSimple());
                    }
                }
                for (SimpleEquationBlock block : unsolvedBlocks()) {
                    if (block.isDiscreteReal()) {
                        localDiscreteRealBlocks_cache.add(block);
                    }
                }
            }
            return localDiscreteRealBlocks_cache;
        }

    
        
        /**
         * Returns all local non-real blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all local non-real blocks
         */
        public Collection<SimpleEquationBlock> localNonRealBlocks() {
            if (localNonRealBlocks_cache == null) {
                localNonRealBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (block.isSimple() && !block.asSimple().isReal())
                        localNonRealBlocks_cache.add(block.asSimple());
                for (SimpleEquationBlock block : unsolvedBlocks())
                    if (!block.isReal())
                        localNonRealBlocks_cache.add(block);
            }
            return localNonRealBlocks_cache;
        }

    

        /**
         * Returns all solved real blocks in this block.
         * 
         * @return Collection<AbstractEquationBlock> all solved real blocks
         */
        public Collection<AbstractEquationBlock> solvedRealBlocks() {
            if (solvedRealBlocks_cache == null) {
                solvedRealBlocks_cache = new ArrayList<AbstractEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (!block.isSimple() || block.asSimple().isReal())
                        solvedRealBlocks_cache.add(block);
            }
            return solvedRealBlocks_cache;
        }

    

        /**
         * Returns all local solved real blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all solved real blocks
         */
        public Collection<SimpleEquationBlock> localSolvedRealBlocks() {
            if (localSolvedRealBlocks_cache == null) {
                localSolvedRealBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (block.isSimple() && block.asSimple().isReal())
                        localSolvedRealBlocks_cache.add(block.asSimple());
            }
            return localSolvedRealBlocks_cache;
        }

    

        /**
         * Returns all locla meta blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all local meta blocks
         */
        public Collection<SimpleEquationBlock> localMetaBlocks() {
            if (localMetaBlocks_cache == null) {
                localMetaBlocks_cache = new ArrayList<SimpleEquationBlock>();
                for (AbstractEquationBlock block : solvedBlocks())
                    if (block.isSimple() && block.asSimple().isMeta())
                        localMetaBlocks_cache.add(block.asSimple());
            }
            return localMetaBlocks_cache;
        }

    

        @Override
        public boolean canComputeJacobian() {
            boolean res = true;
            for (AbstractEquationBlock block : solvedBlocks())
                res &= block.isSimple();
            return res;
        }

    

        /**
         * Returns true if the block contains non-real blocks.
         * 
         * @return boolean True if contains non-real blocks
         */
        public boolean isMixed() {
            return !localNonRealBlocks().isEmpty();
        }

    

        @Override
        public Collection<FAbstractEquation> realEquations() {
            Collection<FAbstractEquation> equations = new ArrayList<FAbstractEquation>();
            for (AbstractEquationBlock block : solvedBlocks())
                equations.addAll(block.realEquations());
            for (SimpleEquationBlock block : unsolvedBlocks())
                equations.addAll(block.realEquations());
            return equations;
        }

    

        @Override
        public Collection<FAbstractEquation> localRealEquations() {
            return collectLocalEquations(localRealBlocks());
        }

    

        @Override
        public Collection<FAbstractEquation> nonRealEquations() {
            Collection<FAbstractEquation> equations = new ArrayList<FAbstractEquation>();
            for (AbstractEquationBlock block : solvedBlocks())
                equations.addAll(block.nonRealEquations());
            for (SimpleEquationBlock block : unsolvedBlocks())
                equations.addAll(block.nonRealEquations());
            return equations;
        }

    

        @Override
        public Collection<FAbstractEquation> localNonRealEquations() {
            return collectLocalEquations(localNonRealBlocks());
        }

    

        /**
         * Returns all equations in this block that are localy solved.
         * 
         * @return Collection<FAbstractEquation> all solved equations
         */
        public Collection<FAbstractEquation> localSolvedEquations() {
            return collectLocalEquations(localSolvedBlocks());
        }

    

        @Override
        public Collection<FAbstractEquation> unsolvedEquations() {
            Collection<FAbstractEquation> equations = new ArrayList<FAbstractEquation>();
            for (SimpleEquationBlock block : unsolvedBlocks())
                equations.addAll(block.unsolvedEquations());
            return equations;
        }

    

        @Override
        public Collection<FAbstractEquation> localUnsolvedEquations() {
            return collectLocalEquations(unsolvedBlocks());
        }

    

        @Override
        public Collection<FVariable> realVariables() {
            Collection<FVariable> variables = new ArrayList<FVariable>();
            for (AbstractEquationBlock block : solvedBlocks())
                variables.addAll(block.realVariables());
            for (SimpleEquationBlock block : unsolvedBlocks())
                variables.addAll(block.realVariables());
            return variables;
        }

    

        @Override
        public Collection<FVariable> localRealVariables() {
            return collectLocalVariables(localRealBlocks());
        }

    

        @Override
        public Collection<FVariable> nonRealVariables() {
            Collection<FVariable> variables = new ArrayList<FVariable>();
            for (AbstractEquationBlock block : solvedBlocks())
                variables.addAll(block.nonRealVariables());
            for (SimpleEquationBlock block : unsolvedBlocks())
                variables.addAll(block.nonRealVariables());
            return variables;
        }

    
        
        @Override
        public Collection<FVariable> localDiscreteRealVariables() {
            return collectLocalVariables(localDiscreteRealBlocks());
        }

    
        
        @Override
        public Collection<FVariable> localNonRealVariables() {
            return collectLocalVariables(localNonRealBlocks());
        }

    

        @Override
        public Collection<FVariable> localSolvedRealVariables() {
            return collectLocalVariables(localSolvedRealBlocks());
        }

    
        
        /**
         * Returns all variables in this block that are localy solved.
         * 
         * @return Collection<FVariable> all solved variables
         */
        public Collection<FVariable> localSolvedVariables() {
            return collectLocalVariables(localSolvedBlocks());
        }

    

        @Override
        public Collection<FVariable> unsolvedVariables() {
            Collection<FVariable> variables = new ArrayList<FVariable>();
            for (SimpleEquationBlock block : unsolvedBlocks())
                variables.addAll(block.unsolvedVariables());
            return variables;
        }

    

        @Override
        public Collection<FVariable> localUnsolvedVariables() {
            return collectLocalVariables(unsolvedBlocks());
        }

    

         @Override
        public boolean isSolvable() {
            return false;
        }

    

        @Override
        public void errorCheck(FClass fclass) {
            for (SimpleEquationBlock seb : unsolvedBlocks())
                if (!seb.isReal())
                    seb.equation().error("Non-real equation used as residual:\n" + seb.equation());
            if (!fclass.myOptions().getBooleanOption("allow_non_scalar_nested_blocks")) {
                for (AbstractEquationBlock block : new ChainedIterable<AbstractEquationBlock>(solvedBlocks(), unsolvedBlocks())) {
                    if (block.allEquations().size() > 1) {
                        ASTNode.NESTED_NON_SCALAR_BLOCK.invoke(fclass, block);
                    }
                }
            }
            errorCheckExternalObjects(fclass);
            if (isLinear())
                return;
            for (AbstractEquationBlock seb : solvedBlocks()) {
                seb.errorCheck(fclass);
            }
            for (SimpleEquationBlock seb : unsolvedBlocks()) {
                seb.errorCheck(fclass);
            }
            errorCheckStartValueDependencies(fclass);
        }

    

        @Override
        protected boolean needLabel(boolean inSubBlock) {
            return true;
        }

    

        @Override
        protected boolean needSequenceNumber(boolean inSubBlock) {
            return true;
        }

    
        
        @Override
        protected void setLabel(String prefix, boolean inBlockResidual, Enumerator nestedEnum, Enumerator seqEnum) {
            super.setLabel(prefix, inBlockResidual, nestedEnum, seqEnum);
            setSubLabels(prefix, seqEnum);
        }

    
        
        protected void setSubLabels(String prefix, Enumerator seqEnum) {
            Enumerator subNestedEnum = new Enumerator(1);
            String label = getLabel();
            for (AbstractEquationBlock eb : solvedBlocks())
                eb.setLabel(label, false, subNestedEnum, seqEnum);
            for (SimpleEquationBlock eb : unsolvedBlocks())
                eb.setLabel(label, true, subNestedEnum, seqEnum);
        }

    @Override
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        String innerIndent = p.indent(indent);
        str.format("%s--- ", indent);
        prettyPrintTypeStr(str);
        if (isMixed())
            str.print(" mixed");
        if (isLinear())
            str.print(" linear");
        str.format(" system (Block %s) of ", getLabel());
        prettyPrintNumVarStr(str);
        str.println(" ---");
        if (isLinear())
            str.formatln("%sCoefficient variability: %s", indent, variability().toStringLiteral());
        prettyPrintBeforeVariablesStr(p, str, indent);
        prettyPrintUnsolvedVariablesStr(p, str, indent);
        int indexCounter=0;
        for (SimpleEquationBlock seb : unsolvedBlocks()) {
        	p.prePrettyPrint(str, indexCounter++, indent);
            seb.prettyPrintActiveVariables(p, str, innerIndent, !isLinear(), false);
        }
        str.println();
        if (isMixed()) {
            str.formatln("%sSolved discrete variables:", indent);
            indexCounter=0;
            for (SimpleEquationBlock seb : localNonRealBlocks()) {
            	p.prePrettyPrint(str, indexCounter++, indent);
                seb.prettyPrintActiveVariables(p, str, innerIndent, false, false);
            }
            str.println();
        }
        prettyPrintBeforeEquationsStr(p, str, indent);
        prettyPrintUnsolvedEquationsStr(p, str, indent);
        indexCounter=0;
        for (SimpleEquationBlock seb : unsolvedBlocks()) {
        	p.prePrettyPrint(str, indexCounter++, indent);
            seb.prettyPrintSub(p, str, innerIndent);
        }
        if (isMixed()) {
            str.println();
            str.formatln("%sDiscrete equations:", indent);
            indexCounter=0;
            for (SimpleEquationBlock seb : localNonRealBlocks()) {
            	p.prePrettyPrint(str, indexCounter++, indent);
                seb.prettyPrintSub(p, str, innerIndent);
            }
        }
        if (localMetaBlocks().size() > 0) {
            str.println();
            str.formatln("%sMeta equations:", indent);
            indexCounter=0;
            for (SimpleEquationBlock seb : localMetaBlocks()) {
            	p.prePrettyPrint(str, indexCounter++, indent);
                seb.prettyPrintSub(p, str, innerIndent);
            }
        }
        if (isLinear()) {
            str.println();
            str.formatln("%sJacobian:", indent);
            FExp[][] jacobian = jacobian();
            for (int col = 0; col < jacobian.length; col++) {
                str.format("%s|", innerIndent);
                for (int row = 0; row < jacobian.length; row++) {
                    if (row > 0)
                        str.print(", ");
                    str.print(jacobian[col][row] == null ? "0.0" : jacobian[col][row]);
                }
                str.println("|");
            }
        }
    }

    @Override
    public void prettyPrintSub(Printer p, CodeStream str, String indent) {
        prettyPrint(p, str, indent);
        str.println();
    }

    protected void prettyPrintTypeStr(CodeStream str) {
        str.print("Unsolved");
    }

    protected void prettyPrintNumVarStr(CodeStream str) {
        str.print(allVariables().size() + " variables");
    }

    protected void prettyPrintBeforeVariablesStr(Printer p, CodeStream str, String indent) {}

    protected void prettyPrintUnsolvedVariablesStr(Printer p, CodeStream str, String indent) {
        if (isMixed())
            str.formatln("%sUnknown continuous variables:", indent);
        else
            str.formatln("%sUnknown variables:", indent);
    }

    protected void prettyPrintBeforeEquationsStr(Printer p, CodeStream str, String indent) {}

    protected void prettyPrintUnsolvedEquationsStr(Printer p, CodeStream str, String indent) {
        if (isMixed())
            str.formatln("%sContinuous residual equations:", indent);
        else
            str.formatln("%sEquations:", indent);
    }

    @Override
    public void prettyPrintActiveVariables(Printer p, CodeStream str, String indent, boolean printAttributes, boolean printLabel) {
        for (AbstractEquationBlock block : solvedBlocks()) {
            if (printLabel && block.isSimple() && block.getLabel() == null)
                block.asSimple().prettyPrintActiveVariables(p, str, indent, printAttributes, getLabel());
            else
                block.prettyPrintActiveVariables(p, str, indent, printAttributes, printLabel);
        }
        for (SimpleEquationBlock block : unsolvedBlocks())
            block.prettyPrintActiveVariables(p, str, indent, printAttributes, getLabel());
    }

    public void errorCheckStartValueDependencies(FClass fclass) {
        Collection<FVariable> allVariables = allVariables();
        Set<FVariable> memberVariables = new HashSet<FVariable>(allVariables);
        for (FVariable var : allVariables) {
            FExp startExpression = var.startAttributeExp();
            if (startExpression == null) {
                continue;
            }
            for (FVariable referencedVar : startExpression.referencedFVariablesInFExp()) {
                if (memberVariables.contains(referencedVar)) {
                    ASTNode.START_VALUE_DEPEND_ON_BLOCK_ERROR.invoke(fclass, this, startExpression, var.displayName());
                }
            }
        }
    }

    public void errorCheckExternalObjects(FClass fclass) {
        for (FVariable var : allVariables()) {
            if (var.isExternalObject()) {
                ASTNode.EXTERNAL_OBJECT_IN_BLOCK.invoke(fclass, this, var.displayName());
            }
        }
    }

    @Override
    protected void genVarDecls(CodePrinter p, CodeStream str, String indent, Set<ASTNode> visited) {
        if (visited == null)
            visited = new HashSet<ASTNode>();
        for (SimpleEquationBlock seb : localSolvedBlocks())
            seb.genVarDecls(p, str, indent, visited);
        for (SimpleEquationBlock seb : unsolvedBlocks())
            seb.genVarDecls(p, str, indent, visited);
    }

    @Override
    protected void blockResidualBlocks(Collection<AbstractEquationBlock> res) {
        for (SimpleEquationBlock seb : localSolvedBlocks()) {
            res.add(seb);
        }
        for (SimpleEquationBlock seb : unsolvedBlocks()) {
            res.add(seb);
        }
    }

    @Override
    public Set<ASTNode> blockResidualNodes() {
        Set<ASTNode> res = super.blockResidualNodes();
        res.addAll(localNonRealEquations());
        return res;
    }

    @Override
    protected void genSolved(CodePrinter p, CodeStream str, String indent,
            boolean inResFunc, Set<FAbstractEquation> visited) {
        genBlockResidualCall(p, str, indent);
    }

    @Override
    public void genSolvedPart(CodePrinter p, CodeStream str,
            String indent, Set<FAbstractEquation> visited) {
        // Loop over all solved blocks and write the expressions
        for (AbstractEquationBlock aeb : solvedBlocks())
            aeb.genSolvedInResFunc(p, str, indent, visited);
    }

    @Override
    public void genResidualPart(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited) {
        for (SimpleEquationBlock block : unsolvedBlocks())
            block.genBlockResidual(p, str, indent, enumerator, visited);
    }

    @Override
    protected Collection<AbstractEquationBlock> genBlockResidualFunction_subBlocks_C() {
        return solvedBlocks();
    }

    @Override
    public boolean hasEquationNominal_C(boolean auto) {
        for (SimpleEquationBlock block : unsolvedBlocks()) {
            if (block.hasEquationNominal_C(auto)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void genEquationNominalVarDecl_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        for (SimpleEquationBlock block : unsolvedBlocks())
            block.genEquationNominalVarDecl_C(p, str, indent, auto, nominalMap);
    }

    @Override
    public void genEquationNominal_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap) {
        Enumerator e = new Enumerator();
        for (SimpleEquationBlock block : unsolvedBlocks()) {
            block.genEquationNominal_C(p, str, indent, auto, nominalMap, e);
        }
    }

    protected String diagnostics_generateBLTTable_color() {
    return "#CCCCF0";
}


}
