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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:823
 */
public abstract class AbstractEquationBlock extends java.lang.Object implements CodeSplitter.Item {
    public boolean containsFHomotopyExp() {
        for (FAbstractEquation eqn : allEquations()) {
            if (eqn.containsFHomotopyExp()) {
                return true;
            }
        }
        return false;
    }

    

        private BlockDependency blockDependency;

    
        private FExp[][] jacobian = null;

    
        private TypePrefixVariability variability = Variability.CONTINUOUS;

    
        private final EquationBlockFactory.BlockProducer producer;

    
        private String label;

    
        private int sequenceNumber = -1;

    
        private int indexNumber = -1;

    

        public AbstractEquationBlock(EquationBlockFactory.BlockProducer producer, BlockDependency blockDependency) {
            this.producer = producer;
            this.blockDependency = blockDependency;
        }

    

        public BlockDependency getBlockDependency() {
            return blockDependency;
        }

    

        /**
         * Returns all equations in this block.
         * 
         * @return Collection<FAbstractEquation> all equations
         */
        public Collection<FAbstractEquation> allEquations() {
            Collection<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            l.addAll(realEquations());
            l.addAll(nonRealEquations());
            return l;
        }

    

        /**
         * Returns all local equations in this block.
         * 
         * Local equations are equations that are computed directly in this
         * block.
         * 
         * @return Collection<FAbstractEquation> all local equations
         */
        public Collection<FAbstractEquation> allLocalEquations() {
            Collection<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            l.addAll(localRealEquations());
            l.addAll(localNonRealEquations());
            return l;
        }

    

        /**
         * Returns all equations in this block that are of type real
         * 
         * @return Collection<FAbstractEquation> all real equations
         */
        public abstract Collection<FAbstractEquation> realEquations();

    

        /**
         * Returns all real blocks in this block.
         * 
         * @return Collection<SimpleEquationBlock> all real blocks
         */
        public abstract Collection<SimpleEquationBlock> localRealBlocks();

    

        /**
         * Returns all local equations in this block that are of type real
         * 
         * Local equations are equations that are computed directly in this
         * block.
         * 
         * @return Collection<FAbstractEquation> all local real equations
         */
        public abstract Collection<FAbstractEquation> localRealEquations();

    

        /**
         * Returns all equations in this block that are not of type real
         * 
         * @return Collection<FAbstractEquation> all non-real equations
         */
        public abstract Collection<FAbstractEquation> nonRealEquations();

    

        /**
         * Returns all local equations in this block that are not of type real
         * 
         * Local equations are equations that are computed directly in this
         * block.
         * 
         * @return Collection<FAbstractEquation> all local non-real equations
         */
        public abstract Collection<FAbstractEquation> localNonRealEquations();

    

        /**
         * Returns all equations in this block that are of type real and is unsolved
         * 
         * @return Collection<FAbstractEquation> all unsolved real equations
         */
        public abstract Collection<FAbstractEquation> unsolvedEquations();

    

        /**
         * Returns all local equations in this block that are of type real and is unsolved
         * 
         * Local equations are equations that are computed directly in this
         * block.
         * 
         * @return Collection<FAbstractEquation> all local unsolved real equations
         */
        public abstract Collection<FAbstractEquation> localUnsolvedEquations();

    

        /**
         * Returns a list of all local equations that has been differentiated.
         * 
         * @return Collection<FAbstractEquation> all local differentiated equations
         */
        public Collection<FAbstractEquation> localDifferentiatedEquations() {
            java.util.List<FAbstractEquation> diffedEq = new ArrayList<FAbstractEquation>();
            for (FAbstractEquation e : allLocalEquations()) {
                if (e.getMeIntegrated() != null) {
                    diffedEq.add(e);
                }
            }
            return diffedEq;
        }

    

        /**
         * Returns all variables in this block
         * 
         * @return Collection<FVariable> all variables
         */
        public Collection<FVariable> allVariables() {
            Collection<FVariable> l = new ArrayList<FVariable>();
            l.addAll(realVariables());
            l.addAll(nonRealVariables());
            return l;
        }

    
        
        /**
         * Returns all local variables in this block
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local variables
         */
        public Collection<FVariable> allLocalVariables() {
            Collection<FVariable> l = new ArrayList<FVariable>();
            l.addAll(localRealVariables());
            l.addAll(localNonRealVariables());
            return l;
        }

    

        /**
         * Returns all variables in this block that are of type real.
         * 
         * @return Collection<FVariable> all real variables
         */
        public abstract Collection<FVariable> realVariables();

    

        /**
         * Returns all local variables in this block that are of type real.
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local real variables
         */
        public abstract Collection<FVariable> localRealVariables();

    

        /**
         * Returns all variables in this block that are not of type real.
         * 
         * @return Collection<FVariable> all non-real variables
         */
        public abstract Collection<FVariable> nonRealVariables();

    

        /**
         * Returns all local variables in this block that are not of real and discrete.
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local discrete real variables
         */
        public abstract Collection<FVariable> localDiscreteRealVariables();

    
        
        /**
         * Returns all local variables in this block that are not of type real.
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local non-real variables
         */
        public abstract Collection<FVariable> localNonRealVariables();

    

        /**
         * Returns all local variables in this block that are solved and of
         * real type.
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local solved real variables
         */
        public abstract Collection<FVariable> localSolvedRealVariables();

    
        
        /**
         * Returns all variables in this block that are of type real and is unsolved.
         * 
         * @return Collection<FVariable> all unsolved real variables
         */
        public abstract Collection<FVariable> unsolvedVariables();

    

        /**
         * Returns all local variables in this block that are of type real and is unsolved.
         * 
         * Local variables are variables that are computed directly in this
         * block.
         * 
         * @return Collection<FVariable> all local unsolved real variables
         */
        public abstract Collection<FVariable> localUnsolvedVariables();

    

		public Collection<FVariable> inactiveVariables() {
			java.util.List<FVariable> s = new ArrayList<FVariable>();
			for (FAbstractEquation e : allEquations()) {
				s.addAll(e.algebraicVariables());
				s.addAll(e.derivativeVariables());
				s.addAll(e.differentiatedRealVariables());
				s.addAll(e.initialParameters());
			}
			s.removeAll(allVariables());
			return s;	
		}

    		

		public Collection<FVariable> independentVariables() {
			java.util.List<FVariable> s = new ArrayList<FVariable>();
			for (FAbstractEquation e : allEquations()) {
				s.addAll(e.inputs());
				s.addAll(e.differentiatedRealVariables());
                s.addAll(e.discretePreVariables());
                //Add all independent parameters the block depends on
                for (FVariable vv: e.parameters())
                    s.addAll(vv.myParameterDependencies());
			}
			return s;
		}

    
		
		public abstract boolean isSolvable();

    
		
        public void computeDependencies(Map<FVariable, AbstractEquationBlock> blockMap) {
            blockDependency = blockDependency.computeComplete(blockMap);
            for (FVariable var : allVariables())
                blockMap.put(var, this);
        }

    

        public Collection<AbstractEquationBlock> immediatePredecessors() {
            return blockDependency.immediatePredecessors();
        }

    

        public Collection<AbstractEquationBlock> allPredecessors() {
            return blockDependency.allPredecessors();
        }

    

        public Collection<AbstractEquationBlock> immediateSuccessors() {
            return blockDependency.immediateSuccessors();
        }

    

        private Set<FVariable> dependsOnVariables_cashe = null;

    

        public Set<FVariable> dependsOn() {
            if (dependsOnVariables_cashe != null)
                return dependsOnVariables_cashe;
            dependsOnVariables_cashe = new LinkedHashSet<FVariable>(independentVariables());
            for (AbstractEquationBlock eb : blockDependency.immediatePredecessors())
                dependsOnVariables_cashe.addAll(eb.dependsOn());
            return dependsOnVariables_cashe;
        }

    

        public boolean isSimple() {
            return false;
        }

    

        public SimpleEquationBlock asSimple() {
            throw new UnsupportedOperationException("Unable to convert block of type '" + getClass().getSimpleName() + "' to 'SimpleEquationBlock'!");
        }

    

        /**
         * Returns the jacobian for this block if it has been computed, else null.
         * 
         * @return FExp[][] jacobian for this block
         */
        public FExp[][] jacobian() {
            return jacobian;
        }

    

        public abstract boolean canComputeJacobian();

    

        /**
         * Computes the jacobian for the unsolved part of this block and store
         * the result. This method should only be called if the block is linear.
         * This method also computes the variability of the resulting jacobian.
         */
        public boolean computeJacobian(Set<FAbstractEquation> activeRealEquations) {
            if (!canComputeJacobian())
                return false;
            jacobian = computeJacobian(localRealBlocks(), activeRealEquations);
            variability = computeVariability(jacobian);
            return true;
        }

    

        /**
         * Returns true if the block is linear.
         * 
         * @return boolean True if linear
         */
        public boolean isLinear() {
            return jacobian != null;
        }

    

        public TypePrefixVariability variability() {
            return variability;
        }

    

        public final String getLabel() {
            return label;
        }

    

        public final int getSequenceNumber() {
            if (sequenceNumber < 0) {
                throw new IllegalStateException("sequenceNumber has not been initialized.");
            }
            return sequenceNumber;
        }

    

        public final int getIndexNumber() {
            if (indexNumber < 0) {
                throw new IllegalStateException("indexNumber has not been initialized.");
            }
            return indexNumber;
        }

    

        public void setIndexNumber(int indexNumber) {
            this.indexNumber = indexNumber;
        }

    

        protected abstract boolean needLabel(boolean inSubBlock);

    
        protected abstract boolean needSequenceNumber(boolean inSubBlock);

    

        public final void setLabel(Enumerator nestedEnum, Enumerator seqEnum) {
            setLabel(null, false, nestedEnum, seqEnum);
        }

    

        protected void setLabel(String prefix, boolean inBlockResidual, Enumerator nestedEnum, Enumerator seqEnum) {
            if (needLabel(inBlockResidual)) {
                if (nestedEnum == null) { // Used for HomotopySubBlock
                    label = String.valueOf(prefix);
                } else if (prefix == null) {
                    label = String.valueOf(nestedEnum.next());
                } else {
                    label = prefix + '.' + nestedEnum.next();
                }
            }
            if (needSequenceNumber(inBlockResidual)) {
                sequenceNumber = seqEnum.next();
            }
        }

    

        /**
         * This method is call on blocks that are used in iterations. This
         * method should check the start values of its variable and verify
         * that a start value is set.
         */
        public abstract void errorCheck(FClass fclass);

    

        protected final static FExp[][] computeJacobian(Collection<SimpleEquationBlock> blocks, Set<FAbstractEquation> activeRealEquations) {
            
            Collection<FAbstractEquation> eqns = new ArrayList<FAbstractEquation>();
            Collection<FVariable> vars = new ArrayList<FVariable>();
            
            for (SimpleEquationBlock block : blocks) {
                Collection<FVariable> blockVars = block.localRealVariables();
                if (blockVars.size() == 0 || block.isMeta()) {
                    continue;
                }
                vars.addAll(blockVars);
                
                Collection<FAbstractEquation> blockEqns = block.localRealEquations();
                // There should be exactly one equation in this list
                if (blockEqns.size() != 1) {
                    throw new IllegalArgumentException("Incorrect arguments to AbstractEquationBlock.computeJacobian(). There are " + blockVars.size() + " local real variables but " + blockEqns.size() + " local real equations in sub-block:" + block);
                }
                // Let's add it n number of times, one for each variable
                for (int i = 0; i < blockVars.size(); i++) {
                    eqns.addAll(blockEqns);
                }
            }
            
            FExp[][] jacobian = new FExp[eqns.size()][vars.size()];
            int row = 0;
            int col = 0;
            Map<FVariable, Integer> columnMap = new HashMap<FVariable, Integer>();
            for (FVariable fv : vars)
                columnMap.put(fv, col++);
            
            for (FAbstractEquation fe : eqns) {
                if (!activeRealEquations.contains(fe)) {
                    jacobian[row][row] = new FRealLitExp(1);
                    jacobian[row][row].parent = fe; // TODO: This is ugly, yes!
                } else {
                    Set<FVariable> RLHS = fe.referencedFVariablesInLHS();
                    Set<FVariable> RRHS = fe.referencedFVariablesInRHS();
                    FExp l = ((FEquation)fe).getLeft();
                    FExp r = ((FEquation)fe).getRight();
                    for (FVariable fv : new ChainedIterable<FVariable>(RLHS, RRHS)) {
                        Integer colObj = columnMap.get(fv);
                        if (colObj == null)
                            continue;
                        col = colObj;
                        
                        FExp dl = l.diff(fv.name());
                        boolean lz = dl.equalsRealValue(0);
                        FExp dr = r.diff(fv.name());
                        boolean rz = dr.equalsRealValue(0);;
                        FExp je;
                        if (rz && lz) {
                            je = null;
                        } else if (lz) {
                            je = r.dynamicFExp(new FNegExp(dr));
                        } else if (rz) {
                            je = dl;
                        } else {
                            je = r.dynamicFExp(new FSubExp(dl,dr));
                        }
                        jacobian[row][col] = je;
                    }   
                }
                row++;
            }
            return jacobian;
        }

    

        protected final static TypePrefixVariability computeVariability(FExp[][] jacobian) {
            TypePrefixVariability blockVariability = Variability.CONSTANT;
            for (FExp[] row : jacobian)
                for (FExp element : row)
                    if (element != null && !element.variability().lessOrEqual(blockVariability))
                        blockVariability = element.variability();
            return blockVariability;
        }

    

        protected final static Collection<FVariable> collectLocalVariables(Collection<? extends SimpleEquationBlock> ... blockss) {
            Collection<FVariable> l = new ArrayList<FVariable>();
            for (Collection<? extends AbstractEquationBlock> blocks : blockss)
                for (AbstractEquationBlock sb : blocks)
                    l.addAll(sb.allLocalVariables());
            return l;
        }

    

        protected final static Collection<FAbstractEquation> collectLocalEquations(Collection<? extends SimpleEquationBlock> ... blockss) {
            Collection<FAbstractEquation> l = new ArrayList<FAbstractEquation>();
            for (Collection<? extends AbstractEquationBlock> blocks : blockss)
                for (AbstractEquationBlock sb : blocks)
                    l.addAll(sb.allLocalEquations());
            return l;
        }

    
        
        public EquationBlockFactory.BlockProducer producer() {
            return producer;
        }

    
        
        public String printAllVariables() {
            return printAllVariables(", ");
        }

    
        public String printAllVariables(String separator) {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (FVariable var : allVariables()) {
                if (!first)
                    sb.append(separator);
                first = false;
                sb.append(var.displayName());
            }
            return sb.toString();
        }

    
        
        public boolean isMeta() {
            return false;
        }

    
        
        public boolean isScalar() {
            return false;
        }

    
        
        public boolean isTimeDependent() {
            for (FAbstractEquation eqn : allEquations()) {
                if (eqn.containsFTimeExp()) {
                    return true;
                }
            }

            return false;
        }

    
        
        public static class BlockProblemProducer extends ProblemProducer<ReporterNode> {
            
            private final String message;
            
            public BlockProblemProducer(String identifier, String message) {
                super(identifier, ProblemKind.SEMANTIC);
                this.message = message;
            }
            
            @Override
            public ProblemSeverity severity() {
                return ProblemSeverity.ERROR;
            }
            
            public void invoke(ReporterNode src, AbstractEquationBlock block, Object ... messageArgs) {
                String processedMessage = String.format(message, messageArgs);
                invoke(src, ProblemSeverity.ERROR, "%s\nBlock which produced the error:\n%s", processedMessage, block);
            }

            @Override
            public String description() {
                return message;
            }

        }

    

        /**
         * Tries to merge the provided block with this one if they are of the
         * same type. True is returned if the merge was successful, false
         * otherwise.
         */
        public final boolean merge(AbstractEquationBlock block) {
            if (getClass().equals(block.getClass()) && do_merge(block)) {
                return true;
            }
            return false;
        }

    
        
        /**
         * Internal method for merging, subclasses should override and try to
         * merge. Return true on successful merge. No type check is needed, it
         * has already been checked.
         */
        protected boolean do_merge(AbstractEquationBlock block) {
            return false;
        }

    public void unsolvedBlockSizes(Collection<Integer> blockSizes) {
        if (!isSolvable()) {
            blockSizes.add(allVariables().size());
        }
    }

    public void unsolvedBlockIterationSizes(Collection<Integer> blockSizes) {
        if (!isSolvable()) {
            blockSizes.add(unsolvedVariables().size());
        }
    }

    @Override
    public final String toString() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CodeStream str = new CodeStream(os);
        prettyPrint(str);
        return os.toString();
    }

    public void prettyPrint(CodeStream str) {
        prettyPrint(ASTNode.BLTPrettyPrinter, str, "");
    }

    public abstract void prettyPrint(Printer p, CodeStream str, String indent);

    public abstract void prettyPrintSub(Printer p, CodeStream str, String indent);

    public abstract void prettyPrintActiveVariables(Printer p, CodeStream str, String indent, boolean printAttributes, boolean printLabel);

    protected void printIterationVariables(CodeStream str) {}

    protected void printTearingPairs(CodeStream str) {}

    public CodePrinter blockPrinter() {
        return new CPrettyPrinter(this);
    }

    public void genVarDecls(CodePrinter p, CodeStream str, String indent) {
        if (isSolvable()) {
            genVarDecls(p, str, indent, null);
        } else {
            for (FRelExp relExp : inactiveSwitches_C())
                p.printVarDecls(relExp, str, indent);
            for (FRelExp relExp : inactiveInitialSwitches_C())
                p.printVarDecls(relExp, str, indent);
        }
    }

    protected void genVarDecls(CodePrinter p, CodeStream str, String indent, Set<ASTNode> visited) {
        for (ASTNode n : blockResidualNodes())
            if (visited == null || visited.add(n))
                p.printVarDecls(n, str, indent);
    }

    protected Collection<AbstractEquationBlock> blockResidualBlocks() {
        Collection<AbstractEquationBlock> res = new LinkedHashSet<AbstractEquationBlock>();
        blockResidualBlocks(res);
        return res;
    }

    protected void blockResidualBlocks(Collection<AbstractEquationBlock> res) {
        res.add(this);
    }

    public Set<ASTNode> blockResidualNodes() {
        Set<ASTNode> res = new LinkedHashSet<ASTNode>();
        res.addAll(allLocalEquations());
        return res;
    }

    public void genSolvedInBLT(CodePrinter p, CodeStream str, String indent) {
        genSolved(p, str, indent, false, new HashSet<FAbstractEquation>());
    }

    public void genSolvedInResFunc(CodePrinter p, CodeStream str, String indent,
            Set<FAbstractEquation> visited) {
        genSolved(p, str, indent, true, visited);
    }

    protected abstract void genSolved(CodePrinter p, CodeStream str, String indent,
            boolean inResFunc, Set<FAbstractEquation> visited);

    public void genBlockResidualCall(CodePrinter p, CodeStream str, String indent) {
        for (FRelExp relExp : inactiveSwitches_C())
            p.printPreSteps(relExp, str, indent);
        for (FRelExp relExp : inactiveInitialSwitches_C())
            p.printPreSteps(relExp, str, indent);
        p.genBlockResidualCall(this, str, indent);
        for (FRelExp relExp : inactiveSwitches_C())
            p.printPostSteps(relExp, str, indent);
        for (FRelExp relExp : inactiveInitialSwitches_C())
            p.printPostSteps(relExp, str, indent);
    }

    public void genBlockResidualCall_C(CodePrinter p, CodeStream str, String indent) {
        String var = p.inInitialSystem() ? "dae_init_block_residuals" : "dae_block_residuals";
        genBlockResidualSetUpFunctionCall_C(p, str, indent);
        str.formatln("%sef |= jmi_solve_block_residual(jmi->%s[%d]);", indent, var, getSequenceNumber());
    }

    public void genSolvedPart(CodePrinter p, CodeStream str,
            String indent, Set<FAbstractEquation> visited) {}

    public boolean hasResidualFunction() {
        return sequenceNumber >= 0;
    }

    public abstract void genResidualPart(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited);

    public void genBlockResidual(CodePrinter p, CodeStream str, String indent,
            Enumerator enumerator, Set<FAbstractEquation> visited) {
        throw new UnsupportedOperationException("Can not produce residual statement for " + getClass().getSimpleName() + "! This kind of block should not end up in the residual of another block, something has gone horribly wrong here!");
    }

    public String genBlockResidualFunctionName_C(CodePrinter p) {
        return "dae_" + (p.inInitialSystem() ? "init_": "") + "block_" + getSequenceNumber();
    }

    public void genEvalModeValueReferences_C(CodePrinter p, CodeStream str, String indent, 
            String mode, Collection<FVariable> fvs) {
        if (fvs.size() > 0) {
            String nextIndent = p.indent(indent);
            int i = 0;
            genOpenEvalMode_C(str, indent, mode);
            for (FVariable fv : fvs) {
                if (!fv.isPreVariable()) {
                    str.format("%sx[%d] = %d;\n", nextIndent, i, fv.valueReference());
                }
                i++;
            }
            genCloseEvalMode_C(str, indent);
        }
    }

    public Map<FVariable,String> createSolverArrayMap(Collection<FVariable> fvs) {
        Map<FVariable,String> solverArrayMap = new LinkedHashMap<FVariable,String>();
        int i = 0;
        for (FVariable fv : fvs) {
            solverArrayMap.put(fv, "x[" + (i++) + "]");
        }
        return solverArrayMap;
    }

    public void genEvalModeAttribute_C(CodePrinter p, CodeStream str, String indent, 
            String mode, String attr, Map<FVariable,String> solverArrayMap) {
        genEvalModeAttribute_C(p, str, indent, mode, attr, solverArrayMap, false);
    }

    public void genEvalModeAttribute_C(CodePrinter p, CodeStream str, String indent, 
            String mode, String attr, Map<FVariable,String> solverArrayMap, boolean set) {
        if (p.C_blockResidualAttributePrinter.attributeSet(attr, solverArrayMap)) {
            String nextIndent = p.indent(indent);
            genOpenEvalMode_C(str, indent, mode);
            p.C_blockResidualAttributePrinter.print(p, str, nextIndent, attr, solverArrayMap, set);
            genCloseEvalMode_C(str, indent);
        }
    }

    public void genEvalModeSwitchIndex_C(CodePrinter p, CodeStream str, String indent, 
            String mode, Collection<FRelExp> ... relExpss) {
        boolean print = false;
        for (Collection<FRelExp> relExps : relExpss) {
            if (relExps.size() > 0) {
                print = true;
            }
        }
        if (print) {
            String nextIndent = p.indent(indent);
            genOpenEvalMode_C(str, indent, mode);
            Enumerator e = new Enumerator();
            for (Collection<FRelExp> relExps : relExpss) {
                for (FRelExp relExp : relExps) {
                    relExp.genBlockResidualFunction_printSwitchIndex_C(p, str, nextIndent, e);
                }
            }
            genCloseEvalMode_C(str, indent);
        }
    }

    public void genOpenEvalMode_C(CodeStream str, String indent, String mode) {
        str.print("if (evaluation_mode == ");
        str.print(mode);
        str.print(") {\n");
    }

    public void genCloseEvalMode_C(CodeStream str, String indent) {
        str.print(indent + "} else ");
    }

    public void genBlockResidualFunction(CodePrinter p, CodeStream str, String outerIndent,
			int generateSparseThreshold) {
		if (!hasResidualFunction())
            return;
        for (AbstractEquationBlock subBlock : genBlockResidualFunction_subBlocks_C())
            subBlock.genBlockResidualFunction(p, str, outerIndent, generateSparseThreshold);

        p.genBlockResidualSetUpFunctionDecl(this, p, str, outerIndent);

        genBlockResidualFunctionSignature(p, str, outerIndent);

        String indent = p.indent(outerIndent);

        String label = getLabel();
        if (label == null) {
            label = getClass().getSimpleName();
        }
        str.format("%s/***** %s: %s *****/\n", indent, p.inInitialSystem() ? "Init block" : "Block", label);

        p.genBlockResidualFunctionVectorDecls(this, p, str, indent);
        genVarDecls(p, str, indent, null);
        
        p.genResidualFunctionEvalModes(this, p, str, indent, generateSparseThreshold);
        ASTNode.genFunctionEnd(str, indent);
        str.print(outerIndent + "}\n\n");
	}

    public void genBlockResidualFunctionVectorDecls_C(CodePrinter p, CodeStream str, String indent) {
        str.print(indent);
        str.println("jmi_real_t** res = &residual;");
        ASTNode.genFunctionStart(str, indent);
    }

    public void genResidualFunctionEvalModes_C(CodePrinter p, CodeStream str, String indent, int generateSparseThreshold) {
		Map<FVariable,String> solverArrayMap = createSolverArrayMap(localUnsolvedVariables());
		String nextIndent = p.indent(indent);
        str.print(indent);

        genEvalModeAttribute_C(p, str, indent, "JMI_BLOCK_NOMINAL",   FAttribute.NOMINAL, solverArrayMap); 
        genEvalModeAttribute_C(p, str, indent, "JMI_BLOCK_START",     FAttribute.START,   solverArrayMap);
        genEvalModeAttribute_C(p, str, indent, "JMI_BLOCK_START_SET", FAttribute.START,   solverArrayMap, true);
        genEvalModeAttribute_C(p, str, indent, "JMI_BLOCK_MIN",       FAttribute.MIN,     solverArrayMap);
        genEvalModeAttribute_C(p, str, indent, "JMI_BLOCK_MAX",       FAttribute.MAX,     solverArrayMap);

        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_VALUE_REFERENCE",
                localUnsolvedVariables());
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_SOLVED_REAL_VALUE_REFERENCE",
                localSolvedRealVariables());
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_DISCRETE_REAL_VALUE_REFERENCE",
                discreteRealVariables_C());
        genEvalModeAttribute_C(p, str, indent,       "JMI_BLOCK_DISCRETE_REAL_NOMINAL", 
                FAttribute.NOMINAL, createSolverArrayMap(discreteRealVariables_C()));
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_SOLVED_NON_REAL_VALUE_REFERENCE", 
                nonRealNonStringVariables_C());
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_SOLVED_STRING_VALUE_REFERENCE", 
                nonRealStringVariables_C());
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_DIRECTLY_IMPACTING_NON_REAL_VALUE_REFERENCE", 
                directlyImpactingNonReals_C());
        genEvalModeValueReferences_C(p, str, indent, "JMI_BLOCK_NON_REAL_TEMP_VALUE_REFERENCE", 
                nonRealNonStringTempVariables_C());

        genEvalModeSwitchIndex_C(p, str, indent, "JMI_BLOCK_ACTIVE_SWITCH_INDEX",
                activeSwitches_C(), activeInitialSwitches_C());
        genEvalModeSwitchIndex_C(p, str, indent, "JMI_BLOCK_DIRECTLY_ACTIVE_SWITCH_INDEX",
                directlyActiveSwitches_C);

        genEvalModeNominal(p, str, indent, "JMI_BLOCK_EQUATION_NOMINAL");
        genEvalModeNominalAuto(p, str, indent, "JMI_BLOCK_EQUATION_NOMINAL_AUTO");
        genEvalModeInitialize(p, str, indent, solverArrayMap, nextIndent, "JMI_BLOCK_INITIALIZE");
        genEvalModeJacobian(p, str, indent, generateSparseThreshold, "JMI_BLOCK_EVALUATE_JACOBIAN");
        
        p = p.evalPrinter();
        
        genEvalModeEvalOrWriteBack(p, str, indent, solverArrayMap);
	}

    public void genBlockResidualFunctionSignature(CodePrinter p, CodeStream str, String outerIndent) {
        str.format("%sstatic int ", outerIndent);
        p.genBlockResidualFunctionName(this, p, str);
        p.genBlockResidualFunctionArgumentList(this, p, str);
        str.print(" {\n");

    }

    public void genBlockResidualFunctionName2_C(CodePrinter p, CodeStream str) {
        str.print(genBlockResidualFunctionName_C(p));
    }

    public void genBlockResidualFunctionArgumentList_C(CodePrinter p, CodeStream str) {
        str.print("(jmi_t* jmi, jmi_real_t* x, jmi_real_t* residual, int evaluation_mode)");
    }

    public void genEvalModeNominal(CodePrinter p, CodeStream str, String indent, String mode) {
		// Equation nominal values
        if (hasEquationNominal_C(false)) {
			genOpenEvalMode_C(str, indent, mode);
            Map<FAbstractEquation,FExp> nominalMap = new HashMap<FAbstractEquation,FExp>();
            genEquationNominalVarDecl_C(p, str, p.indent(indent), false, nominalMap);
            genEquationNominal_C(p, str, p.indent(indent), false, nominalMap);
            genCloseEvalMode_C(str, indent);
        }
	}

    public void genEvalModeNominalAuto(CodePrinter p, CodeStream str, String indent, String mode) {
		if (hasEquationNominal_C(true)) {
			genOpenEvalMode_C(str, indent, mode);
            Map<FAbstractEquation,FExp> nominalMap = new HashMap<FAbstractEquation,FExp>();
            genEquationNominalVarDecl_C(p, str, p.indent(indent), true, nominalMap);
            genEquationNominal_C(p, str, p.indent(indent), true, nominalMap);
            genCloseEvalMode_C(str, indent);
        }
	}

    public void genEvalModeInitialize(CodePrinter p, CodeStream str, String indent,
			Map<FVariable, String> solverArrayMap, String nextIndent, String mode) {
		// Loop over all active variables and write their value to x
        if (localUnsolvedVariables().size() > 0) {
			genOpenEvalMode_C(str, indent, mode);
            for (FVariable fv : localUnsolvedVariables()) 
                fv.genBlockResidualInit_C(p, str, nextIndent, solverArrayMap);
            genCloseEvalMode_C(str, indent);
        }
	}

    public void genEvalModeJacobian(CodePrinter p, CodeStream str, String indent, int generateSparseThreshold,
			String mode) {
		// Generate code for Jacobian
		if (isLinear() && generateSparseThreshold >= localSolvedRealVariables().size()) {
            genOpenEvalMode_C(str, indent, mode);
            // TODO: Merge the two functions?
            genBlockResidualFunction_jacobianDecls_C(p, str, p.indent(indent));
            genBlockResidualFunction_jacobian_C(p, str, p.indent(indent));
            genCloseEvalMode_C(str, indent);
        } else if (isLinear()) {
            genOpenEvalMode_C(str, indent, mode);
            str.print(p.indent(indent) + "ef = -1;\n");
            genCloseEvalMode_C(str, indent);
        }
	}

    public void genEvalModeEvalOrWriteBack(CodePrinter p, CodeStream str, String indent,
			Map<FVariable, String> solverArrayMap) {
		String nextIndent = p.indent(indent);
		str.print("if (evaluation_mode & JMI_BLOCK_EVALUATE || evaluation_mode & JMI_BLOCK_WRITE_BACK) {\n");
        // Loop over all active variables and write the values in x to the z vector
        str.print(nextIndent + "if ((evaluation_mode & JMI_BLOCK_EVALUATE_NON_REALS) == 0) {\n"); // TODO: remove guard when correct x is given to JMI_BLOCK_EVALUATE_NON_REALS
        for (FVariable fv : localUnsolvedVariables()) 
            fv.genBlockResidualEvalInit_C(p, str, p.indent(nextIndent), solverArrayMap);
        str.print(nextIndent + "}\n");
        Set<FAbstractEquation> visitedList = new HashSet<FAbstractEquation>();
        genSolvedPart(p, str, nextIndent, visitedList);
        str.print(nextIndent + "if (evaluation_mode & JMI_BLOCK_EVALUATE) {\n");
        // Write the residual expressions
        genResidualPart(p, str, p.indent(nextIndent), new Enumerator(), visitedList);
        str.print(nextIndent + "}\n");
        str.print(indent + "}\n");
	}

    protected Collection<AbstractEquationBlock> genBlockResidualFunction_subBlocks_C() {
        return Collections.emptyList();
    }

    public abstract boolean hasEquationNominal_C(boolean auto);

    public abstract void genEquationNominalVarDecl_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap);

    public abstract void genEquationNominal_C(CodePrinter p, CodeStream str, String indent,
            boolean auto, Map<FAbstractEquation,FExp> nominalMap);

    public void genBlockResidualFunction_jacobianDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (jacobian != null)
            for (FExp[] col : jacobian)
                for (FExp exp : col)
                    if (exp != null)
                        exp.genVarDecls_C(ASTNode.printer_C, str, indent);
    }

    public void genBlockResidualFunction_jacobian_C(CodePrinter p, CodeStream str, String indent) {
        if (jacobian == null)
            return;
        FExp[][] jacobian = jacobian();
        int rows = jacobian.length;
        int cols = jacobian.length;
        str.format("%smemset(residual, 0, %d * sizeof(jmi_real_t));\n", indent, rows * cols);
        // Output Jacobian
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                if (jacobian[row][col] != null) {
                    p.printPreSteps(jacobian[row][col], str, indent);
                    str.format("%sresidual[%d] = ", indent, rows * col + row);
                    p.print(jacobian[row][col], str, indent);
                    str.format(";\n");
                    p.printPostSteps(jacobian[row][col], str, indent);
                }
            }
        }
    }

    public void genBlockAddCall_C(CodePrinter p, CodeStream str, String indent, boolean dirDer,
            boolean inInit, boolean generateSparse, String nleSolver, int parentBlockNumber) {

        if (!hasResidualFunction()) {
            return;
        }

        int suffix = getSequenceNumber();

        for (AbstractEquationBlock subBlock : genBlockResidualFunction_subBlocks_C()) {
            subBlock.genBlockAddCall_C(p, str, indent, dirDer, inInit, generateSparse, nleSolver, suffix);
        }
        str.print(indent);
        str.print("jmi_dae_" + (inInit ? "init_" : "") + "add_equation_block(");
        str.print("*jmi, dae_" + (inInit ? "init_" : "") + "block_" + suffix + ", ");
        if (dirDer) {
            str.print("dae_" + (inInit ? "init_" : "") + "block_dir_der_" + suffix + ", ");
        } else {
            str.print("NULL, ");
        }

        addSparseJacobianFunctionPointers(str, generateSparse);

        str.print(localUnsolvedVariables().size() + ", "); // Rename to realIterationVariables() and nonRealIterationVariables()?
        str.print(localSolvedRealVariables().size() + ", ");
        str.print(discreteRealVariables_C().size() + ", ");
        str.print(nonRealNonStringVariables_C().size() + ", ");
        str.print(directlyImpactingNonReals_C().size() + ", ");
        str.print(nonRealNonStringTempVariables_C().size() + ", ");
        str.print(nonRealStringVariables_C().size() + ", ");
        str.print((activeSwitches_C().size() + activeInitialSwitches_C().size()) + ", ");
        str.print(directlyActiveSwitches_C().size() + ", ");
        str.print(variability().genJMIVariabilityConstant_C() + ", ");
        p.C_blockResidualAttributePrinter.printVariability(p, str, indent, this.localUnsolvedVariables());
        str.print(genJMISolverConstant_C(nleSolver) + ", ");
        str.print(getSequenceNumber() + ", \"");
        str.print(getLabel() + "\", ");
        str.print(parentBlockNumber + ");\n");
    }

    protected void addSparseJacobianFunctionPointers(CodeStream str, boolean generateSparse) {
        str.print("NULL, NULL, ");
    }

    public String genJMISolverConstant_C(String nleSolver) {
        if (isLinear() || localUnsolvedEquations().isEmpty())
            return "JMI_LINEAR_SOLVER";
        else if (nleSolver.equals("kinsol"))
            return "JMI_KINSOL_SOLVER";
        else if (nleSolver.equals("minpack"))
            return "JMI_MINPACK_SOLVER";
        else if (nleSolver.equals("realtime"))
            return "JMI_REALTIME_SOLVER";
        else
            throw new UnsupportedOperationException("The string value: " + nleSolver + " is not valid for the compiler option nonlinear_solver");
    }

    private Collection<FRelExp> activeSwitches_C = null;

    private Collection<FRelExp> inactiveSwitches_C = null;

    private Collection<FRelExp> activeInitialSwitches_C = null;

    private Collection<FRelExp> inactiveInitialSwitches_C = null;

    private Collection<FRelExp> directlyActiveSwitches_C = null;

    private Collection<FVariable> directlyImpactingNonReals_C = null;

    public Collection<FRelExp> activeSwitches_C() {
        cacheSwitches_C();
        return activeSwitches_C;
    }

    public Collection<FRelExp> activeInitialSwitches_C() {
        cacheSwitches_C();
        return activeInitialSwitches_C;
    }

    public Collection<FRelExp> inactiveSwitches_C() {
        cacheSwitches_C();
        return inactiveSwitches_C;
    }

    public Collection<FRelExp> inactiveInitialSwitches_C() {
        cacheSwitches_C();
        return inactiveInitialSwitches_C;
    }

    public Collection<FRelExp> directlyActiveSwitches_C() {
        cacheSwitches_C();
        return directlyActiveSwitches_C;
    }

    public Collection<FVariable> discreteRealVariables_C() {
        Collection<FVariable> l = new ArrayList<FVariable>();
        for (FVariable fv : localDiscreteRealVariables()) {
            if (!fv.isTemporary()) {
                l.add(fv);
            }
        }
        return l;
    }

    public Collection<FVariable> nonRealNonStringVariables_C() {
        Collection<FVariable> l = new ArrayList<FVariable>();
        for (FVariable fv : localNonRealVariables()) {
            if (!fv.isTemporary() && !fv.isString()) {
                l.add(fv);
            }
        }
        return l;
    }

    public Collection<FVariable> nonRealStringVariables_C() {
        Collection<FVariable> l = new ArrayList<FVariable>();
        for (FVariable fv : localNonRealVariables()) {
            if (!fv.isTemporary() && fv.isString()) {
                l.add(fv);
            }
        }
        return l;
    }

    public Collection<FVariable> nonRealNonStringTempVariables_C() {
        Collection<FVariable> l = new ArrayList<FVariable>();
        for (FVariable fv : localNonRealVariables()) {
            if (fv.isTemporary() && !fv.isString()) {
                l.add(fv);
            }
        }
        return l;
    }

    public Collection<FVariable> directlyImpactingNonReals_C() {
        cacheSwitches_C();
        return directlyImpactingNonReals_C;
    }

    private void cacheSwitches_C() {
        if (activeSwitches_C != null && activeInitialSwitches_C != null && inactiveSwitches_C != null &&
                inactiveInitialSwitches_C != null && directlyActiveSwitches_C != null && directlyImpactingNonReals_C != null)
            return;
        activeSwitches_C = new LinkedHashSet<FRelExp>();
        activeInitialSwitches_C = new LinkedHashSet<FRelExp>();
        inactiveSwitches_C = new LinkedHashSet<FRelExp>();
        inactiveInitialSwitches_C = new LinkedHashSet<FRelExp>();
        directlyActiveSwitches_C = new LinkedHashSet<FRelExp>();
        directlyImpactingNonReals_C = new LinkedHashSet<FVariable>();
        
        Set<FAbstractEquation> realEqns = new HashSet<FAbstractEquation>(localRealEquations());
        Set<FVariable> nonRealVars = new HashSet<FVariable>(nonRealNonStringVariables_C());
        Set<FVariable> allVariables = new HashSet<FVariable>(allLocalVariables());
        for (FAbstractEquation equation : allLocalEquations()) {
            boolean realEqn = realEqns.contains(equation);
            for (FRelExp relExp : equation.relExpInInitialEquation()) {
                FRelExp orig = relExp.originalFExp();
                if (orig.dependsOn(allVariables)) {
                    activeInitialSwitches_C.add(orig);
                    if (realEqn)
                        directlyActiveSwitches_C.add(orig);
                } else {
                    inactiveInitialSwitches_C.add(orig);
                }
            }
            for (FRelExp relExp : equation.relExpInEquation()) {
                FRelExp orig = relExp.originalFExp();
                if (orig.dependsOn(allVariables)) {
                    activeSwitches_C.add(orig);
                    if (realEqn)
                        directlyActiveSwitches_C.add(orig);
                } else {
                    inactiveSwitches_C.add(orig);
                }
            }
            if (realEqn) {
                for (FVariable var : equation.referencedFVariables()) {
                    if (nonRealVars.contains(var))
                        directlyImpactingNonReals_C.add(var);
                }
            }
        }
    }

    public void genSetupNodeDecls_C(CodePrinter p, CodeStream str, String indent) {
        if (hasResidualFunction()) {
            for (FFunctionCall call : getSetupNodes()) {
                call.genStaticVarDecls_C(p, str, indent);
            }
        }
    }

    public void genBlockResidualSetUpFunctionCall_C(CodePrinter p, CodeStream str, String indent) {
        if (getSetupNodes().size() > 0) {
            str.print(indent, genBlockResidualSetUpFunctionName_C(p), "(jmi);\n");
        }
    }

    public void genBlockResidualSetUpFunctionCallHeader_C(CodePrinter p, CodeStream str, String indent) {
        if (getSetupNodes().size() > 0 && hasResidualFunction()) {
            str.print(indent,"extern void " + genBlockResidualSetUpFunctionName_C(p), "(jmi_t* jmi);\n");
        }
    }

    public void genBlockResidualSetUpFunctionDecl_C(CodePrinter p, CodeStream str, String indent) {
        if (getSetupNodes().size() > 0) {
            String next = p.indent(indent);
            str.print(indent, "void ", genBlockResidualSetUpFunctionName_C(p), "(jmi_t* jmi) {\n");
            for (FFunctionCall call : getSetupNodes()) {
                call.genStaticTempVars_C(p, str, next);
            }
            str.print(indent, "}\n\n");
        }
    }

    public String genBlockResidualSetUpFunctionName_C(CodePrinter p) {
        return genBlockResidualFunctionName_C(p) + "_set_up";
    }

    private Collection<FFunctionCall> setupNodes = null;

    public Collection<FFunctionCall> getSetupNodes() {
        if (setupNodes == null) {
            setupNodes = new LinkedHashSet<FFunctionCall>();
            for (AbstractEquationBlock b : blockResidualBlocks()) {
                for (ASTNode n : b.blockResidualNodes()) {
                    n.gatherBlockSetupNodes(blockPrinter(), setupNodes);
                }
            }
        }
        return setupNodes;
    }

    public void genReinitTempDecls_C(CodePrinter p, CodeStream str, String indent) {
        for (FReinit r : collectReinits_C(p)) {
            str.print(indent, "jmi_real_t ", r.tempName_C(), ";\n");
        }
    }

    public void genReinitTempInits_C(CodePrinter p, CodeStream str, String indent) {
        for (FReinit r : collectReinits_C(p)) {
            p.printAssign(r.type(), str, indent, r, r.getVar());
        }
    }

    public void genReinitWritebacks_C(CodePrinter p, String indent, CodeStream str) {}

    public Iterable<FReinit> collectReinits_C(CodePrinter p) {
        ArrayList<FReinit> res = new ArrayList<>();
        for (FAbstractEquation eqn : allEquations()) {
            eqn.collectReinits_C(p, res);
        }
        return res;
    }

    

        /**
         * Describes a quadrant in an {@code EquationBlock}.
         * +-------+-----+
         * |       |     |
         * |   L   | A12 |
         * |       |     |
         * +-------+-----+
         * |  A21  | A22 |
         * +-------+-----+
         * - L is torn part
         * - A12 is incidences between torn equations and iteration variables
         * - A21 is incidences between torn variables and residual equations
         * - A22 is incidences between residual equations and iteration variables
         */
        protected enum Quadrant {
            L, A12, A21, A22;

            /**
             * Enum values.
             */
            public static final Quadrant[] values = values();

            /**
             * All {@code name} entries for the enums.
             */
            public static final String[] names = buildNames();

            private static String[] buildNames() {
                int length = values.length;
                String[] names = new String[length];

                for (int i = 0; i < length; ++i) {
                    names[i] = values[i].name();
                }
                return names;
            }
        }

    

        /**
         * Describes an equation block's structural information.
         */
        protected static class SparseJacobian {
            private final FExp[][] jacobian;
            private final int cols;
            private final int rows;
            private final int colPivot;
            private final int rowPivot;

            /**
             * Creates an instance of a block's structural information.
             * 
             * @param n1
             *            The size of the torn equations
             * @param n2
             *            The size of the remaining equations
             */
            public SparseJacobian(FExp[][] jacobian, int n1, int n2) {
                this.jacobian = jacobian;
                this.colPivot = n1;
                this.rowPivot = n1;
                this.cols = n1+n2;
                this.rows = n1+n2;
            }

            /**
             * Returns the starting column of the specified quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the starting column.
             * @return
             *         Text.
             */
            public int colStart(Quadrant quadrant) {
                if (quadrant == Quadrant.L || quadrant == Quadrant.A21) {
                    return 0;
                }
                return colPivot;
            }
    
            /**
             * Returns the last column of the specified quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the last column.
             * @return
             *         Text.
             */
            public int colEnd(Quadrant quadrant) {
                if (quadrant == Quadrant.L || quadrant == Quadrant.A21) {
                    return colPivot;
                }
                return cols;
            }
    
            /**
             * Returns the starting row of the specified quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the starting row.
             * @return
             *         Text.
             */
            public int rowStart(Quadrant quadrant) {
                if (quadrant == Quadrant.L || quadrant == Quadrant.A12) {
                    return 0;
                }
                return rowPivot;
            }
    
            /**
             * Returns the last row of the specified quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the last row.
             * @return
             *         Text.
             */
            public int rowEnd(Quadrant quadrant) {
                if (quadrant == Quadrant.L || quadrant == Quadrant.A12) {
                    return rowPivot;
                }
                return rows;
            }
    
            /**
             * Returns the number of columns in the quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the number of columns.
             * @return
             *         Text.
             */
            public int numCols(Quadrant quadrant) {
                return colEnd(quadrant) - colStart(quadrant);
            }
    
            /**
             * Returns the number of rows in the quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the number of rows.
             * @return
             *         Text.
             */
            public int numRows(Quadrant quadrant) {
                return rowEnd(quadrant) - rowStart(quadrant);
            }
    
            /**
             * Returns the expression at the specified coordinates.
             */
            public FExp at(int row, int col) {
                if (row >= rows || col > cols) {
                    return null;
                }
                return jacobian[row][col];
            }
    
            /**
             * Returns the number of non-zero fields in the quadrant.
             * 
             * @param quadrant
             *            The quadrant for which to return the number of rows.
             * @return
             *         Text.
             */
            public int numNonZero(Quadrant quadrant) {
                int numNonZero = 0;

                for (int row = rowStart(quadrant); row < rowEnd(quadrant); ++row) {
                    for (int col = colStart(quadrant); col < colEnd(quadrant); ++col) {

                        numNonZero = numNonZero + (jacobian[row][col] == null ? 0 : 1);
                    }
                }
                return numNonZero;
            }
            
            /**
             * Returns an iterable for a specific quadrant of the jacobian.
             * This iterable can then be used to visit all the set elements of
             * the quadrant.
             */
            public Iterable<JacobianCell> quadrantIterable(final Quadrant quadrant) {
                return new Iterable<JacobianCell>() {
                    
                    @Override
                    public Iterator<JacobianCell> iterator() {
                        return new QuadrantIterator(quadrant);
                    }
                };
            }
            
            private class QuadrantIterator implements Iterator<JacobianCell> {
                private final int rowOffset;
                private final int colOffset;
                private final int numRows;
                private final int numCols;
                
                private int row = -1;
                private int col = 0;
                private FExp next;
                
                public QuadrantIterator(Quadrant quadrant) {
                    rowOffset = rowStart(quadrant);
                    colOffset = colStart(quadrant);
                    numRows = numRows(quadrant);
                    numCols = numCols(quadrant);
                    update();
                }
                
                private void update() {
                    do {
                        row++;
                        if (row == numRows) {
                            row = 0;
                            col++;
                        }
                        if (col == numCols) {
                            next = null;
                            break;
                        }
                        next = at(rowOffset + row, colOffset + col);
                    } while (next == null && col < numCols);
                }

                @Override
                public boolean hasNext() {
                    return next != null;
                }

                @Override
                public JacobianCell next() {
                    if (next == null) {
                        throw new NoSuchElementException("End of iterator has been reached!");
                    }
                    JacobianCell res = new JacobianCell(row, col, next);
                    update();
                    return res;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Remove operation is not supported on this iterator");
                }
            }
        }

    
    
        private static class JacobianCell {
            private final int row;
            private final int col;
            private final FExp exp;
            
            private JacobianCell(int row, int col, FExp exp) {
                this.row = row;
                this.col = col;
                this.exp = exp;
            }
        }

    
        
        /**
         * Maps an evaluation aspect of a quadrant to a variable name.
         */
        protected enum EvaluationFunction {
            /**
             * The dimension i.e. the number of non-zero elements.
             */
            DIMENSIONS("dim"),
            /**
             * The columns.
             */
            COLPTR("col"),
            /**
             * The rows.
             */
            ROWIND("row"),
            /**
             * The evaluation.
             */
            EVAL("eval");
    
            /**
             * Enum values.
             */
            public static final EvaluationFunction[] values = values();
            /**
             * All {@code name} values for the respective enums.
             */
            public static final String[] names = buildNames();
            /**
             * All {@code var} values for the respective enums.
             */
            public static final String[] vars = buildVars();
            public final String var;
    
            private EvaluationFunction(String var) {
                this.var = var;
            }
    
            private static String[] buildNames() {
                int length = values.length;
                String[] names = new String[length];

                for (int i = 0; i < length; ++i) {
                    names[i] = values[i].name();
                }
                return names;
            }
    
            private static String[] buildVars() {
                int length = values.length;
                String[] names = new String[length];

                for (int i = 0; i < length; ++i) {
                    names[i] = values[i].var;
                }
                return names;
            }
        }

    protected static String STRUCT_TYPE_TAG               = "_t";

    protected static String JACOBIAN_STRUCT_C             = "jmi_jacobian_quadrants";

    protected static String JACOBIAN_FUNCTION_C           = "jacobian";

    protected static String JACOBIAN_STRUCT_FUNCTION_C    = "jacobian_struct";

    protected static String JACOBIAN_INIT_FUNCTION_C      = "jacobian_init";

    protected static String JACOBIAN_TYPE_C               = JACOBIAN_STRUCT_C + STRUCT_TYPE_TAG;

    protected static String JACOBIAN_PARAM_C              = "jac";

    protected static String JACOBIAN_INSTANCE_C           = "jc";

    protected static String INT_TYPE_C                    = "jmi_int_t";

    protected static String REAL_TYPE_C                   = "jmi_real_t";

    protected static String QUADRANT_STRUCT_C             = "jmi_jacobian_quadrant";

    protected static String QUADRANT_TYPE_C               = QUADRANT_STRUCT_C + STRUCT_TYPE_TAG;

    protected static String EVAL_BASE                     = "JMI_BLOCK_JACOBIAN";

    protected static String EVAL                          = EVAL_BASE + "_EVALUATE_";

    protected static String EVAL_MODE_VAR                 = "evaluation_mode";

    protected static String INIT_TAG                      = "_init";

    protected static String MODE_VAR                      = "mode";

    protected static String INTERNAL_TAG                  = "internal";

    public void genBlockResidualFunction_sparse_jacobian(CodePrinter p, CodeStream str,
            String indent, boolean initial) { }

    protected void genEval(CodePrinter p, CodeStream str, String indent, SparseJacobian jacobian,
            EvaluationFunction evalFunction, Quadrant quadrant, String initialSuffix, boolean real) {

        String instanceType = real ? REAL_TYPE_C : INT_TYPE_C;
        String innerIndent = p.indent(indent);
        
        if (real) {
            str.format("%svoid %s_%d_%s%s(jmi_t *jmi, %s **%s) {\n", indent, quadrant.name(), getSequenceNumber(),
                evalFunction.var, initialSuffix, instanceType, JACOBIAN_PARAM_C);
        } else {
            str.format("%svoid %s_%d_%s%s(%s **%s) {\n", indent, quadrant.name(), getSequenceNumber(),
                evalFunction.var, initialSuffix, instanceType, JACOBIAN_PARAM_C);
        }

        switch (evalFunction) {
            case DIMENSIONS :
                genStructDim(p, str, innerIndent, jacobian, quadrant);
                break;
            case COLPTR :
                genStructCol(p, str, innerIndent, jacobian, quadrant);
                break;
            case ROWIND :
                genStructRow(p, str, innerIndent, jacobian, quadrant);
                break;
            case EVAL :
                genStructEval(p, str, innerIndent, jacobian, quadrant);
                break;
            default:
                throw new IllegalArgumentException("Support for evaluation function " + evalFunction.var +
                    " is not implemented.");
        }
        str.format("}\n");
    }

    protected void genStructDim(CodePrinter p, CodeStream str, String indent,
            SparseJacobian jacobian, Quadrant quadrant) {

        str.format("%s(*%s)[0] = %d;\n", indent, JACOBIAN_PARAM_C, jacobian.numNonZero(quadrant));
        str.format("%s(*%s)[1] = %d;\n", indent, JACOBIAN_PARAM_C, jacobian.numCols(quadrant));
        str.format("%s(*%s)[2] = %d;\n", indent, JACOBIAN_PARAM_C, jacobian.numRows(quadrant));
    }

    private void genStructCol(CodePrinter p, CodeStream str, String indent,
            SparseJacobian jacobian, Quadrant quadrant) {
        int i = 0;
        int lastCol = 0;
        for (JacobianCell cell : jacobian.quadrantIterable(quadrant)) {
            // We need to loop since there might be columns without incidences,
            // especially A21.
            for (; lastCol <= cell.col; lastCol++) {
                str.format("%s(*%s)[%d] = %d;\n", indent, JACOBIAN_PARAM_C, lastCol, i);
            }
            i++;
        }
        // ... and the once at the end which doesn't have any incidences
        for (; lastCol <= jacobian.numCols(quadrant); lastCol++) {
            str.format("%s(*%s)[%d] = %d;\n", indent, JACOBIAN_PARAM_C, lastCol, i);
        }
    }

    protected void genStructRow(CodePrinter p, CodeStream str, String indent,
            SparseJacobian jacobian, Quadrant quadrant) {
        int i = 0;
        for (JacobianCell cell : jacobian.quadrantIterable(quadrant)) {
            str.format("%s(*%s)[%d] = %d;\n", indent, JACOBIAN_PARAM_C, i, cell.row);
            i++;
        }
    }

    protected void genStructEval(CodePrinter p, CodeStream str, String indent,
            SparseJacobian jacobian, Quadrant quadrant) {
        for (JacobianCell cell : jacobian.quadrantIterable(quadrant)) {
            p.printVarDecls(cell.exp, str, indent);
        }
        int cellIndex = 0;
        for (JacobianCell cell : jacobian.quadrantIterable(quadrant)) {
            p.printPreSteps(cell.exp, str, indent);
            str.format("%s(*%s)[%d] = ", indent, JACOBIAN_PARAM_C, cellIndex++);
            p.print(cell.exp, str, indent);
            str.format(";\n");
            p.printPostSteps(cell.exp, str, indent);
        }
    }

    protected void generateJacobianFunction(CodePrinter p, CodeStream str,
            String outerIndent, SparseJacobian jacobian, String initialSuffix) {

        String indent = p.indent(outerIndent);
        String innerIndent = p.indent(indent);

        beginJacobianFunction(p, str, outerIndent, JACOBIAN_FUNCTION_C, initialSuffix, true);
        
        Quadrant[] quadrants = Quadrant.values();
        int length = quadrants.length;
        
        for (int i = 0; i < length; ++i) {
            Quadrant quadrant = quadrants[i];
            String quadrantName = quadrant.name();

            genOpenEvalMode_C(str, indent, EVAL + quadrantName);
            str.format("%s%s->%s.%s(jmi, %s);\n", innerIndent, JACOBIAN_INSTANCE_C, quadrantName,
                    EvaluationFunction.EVAL.var, JACOBIAN_PARAM_C);
            
            if (i + 1 == length) {
                break;
            }
            
            genCloseEvalMode_C(str, indent);
        }

        endJacobianFunction(p, str, outerIndent);
    }

    protected void generateJacobianStructFunction(CodePrinter p, CodeStream str,
        String outerIndent, SparseJacobian jacobian, String initialSuffix) {

        String indent = p.indent(outerIndent);
        String innerIndent = p.indent(indent);

        beginJacobianFunction(p, str, outerIndent, JACOBIAN_STRUCT_FUNCTION_C, initialSuffix, false);

        EvaluationFunction[] evalFunctions = EvaluationFunction.values();
        Quadrant[] quadrants = Quadrant.values();
        int evalLength = evalFunctions.length;
        int quadrantLength = quadrants.length;

        for (int i = 0; i < quadrantLength; ++i) {
            String quadrantName = quadrants[i].name();
            String modeBase = EVAL_BASE + "_" + quadrantName + "_";

            for (int j = 0; j < evalLength; ++j) {
                EvaluationFunction evalFunction = evalFunctions[j];

                if (evalFunction == EvaluationFunction.EVAL) {
                    continue;
                }

                genOpenEvalMode_C(str, indent, modeBase + evalFunction.name());

                str.format("%s%s->%s.%s(%s);\n", innerIndent, JACOBIAN_INSTANCE_C, quadrantName,
                        evalFunction.var, JACOBIAN_PARAM_C);

                if (i + 1 == quadrantLength && j + 2 == evalLength) {
                    break;
                }

                genCloseEvalMode_C(str, indent);
            }
        }
        endJacobianFunction(p, str, outerIndent);
    }

    protected void beginJacobianFunction(CodePrinter p, CodeStream str,
            String indent, String functionName, String initialSuffix, boolean real) {

        int numberSuffix = getSequenceNumber();
        String instanceType = real ? REAL_TYPE_C : INT_TYPE_C;
        String innerIndent = p.indent(indent);

        str.format("%sstatic int %s(jmi_t *jmi, jmi_real_t *x, %s **%s, int mode) {\n", indent, functionName + "_" +
                    numberSuffix, instanceType, JACOBIAN_PARAM_C);
        str.format("%sint ef = 0;\n", innerIndent);
        str.format("%s%s *%s = %s_%d%s();\n", innerIndent, JACOBIAN_TYPE_C, JACOBIAN_INSTANCE_C,
                JACOBIAN_INIT_FUNCTION_C, numberSuffix, initialSuffix);
        str.format("%sint %s = %s;\n\n%s", innerIndent, EVAL_MODE_VAR, MODE_VAR, innerIndent);
    }

    protected void endJacobianFunction(CodePrinter p, CodeStream str, String indent) {
        String innerIndent = p.indent(indent);

        str.format("%s}\n\n", innerIndent);
        str.format("%sfree(%s);\n", innerIndent, JACOBIAN_INSTANCE_C);
        str.format("%sreturn ef;\n", innerIndent);
        str.format("%s}\n\n", indent);
    }

    protected void genStructInitDecl(CodePrinter p, CodeStream str,
            String indent, String initialSuffix) {

        int numberSuffix = getSequenceNumber();

        str.format("%s%s *%s_%d%s() {\n", indent, JACOBIAN_TYPE_C, JACOBIAN_INIT_FUNCTION_C,
                numberSuffix, initialSuffix);
        String innerIndent = p.indent(indent);
        str.format("%s%s *%s = (%s *) malloc(sizeof(%s));\n", innerIndent, JACOBIAN_TYPE_C,
                JACOBIAN_INSTANCE_C, JACOBIAN_TYPE_C, JACOBIAN_TYPE_C);

        for (Quadrant quadrant : Quadrant.values()) {
            String quadrantName = quadrant.name();
            for (EvaluationFunction eval : EvaluationFunction.values()) {
                String evalVar = eval.var;
                str.format("%s%s->%s.%s = &%s_%d_%s%s;\n", innerIndent, JACOBIAN_INSTANCE_C, quadrantName, evalVar,
                        quadrantName, numberSuffix, eval.var, initialSuffix);
            }
        }
        str.format("%sreturn %s;", innerIndent, JACOBIAN_INSTANCE_C);
        str.format("%s\n}\n\n", indent);
    }

    public int numScalars_C() {
        int n = 0;
        for (FAbstractEquation eqn : allEquations()) {
            n += eqn.numScalars_C();
        }
        return n;
    }

    protected Collection<FVariable> diagnostics_generateBLTTable_variables() {
    return allVariables();
}

    protected abstract String diagnostics_generateBLTTable_color();

    protected Map<FVariable, Integer> EMPTY_VAR_FILTER = Collections.emptyMap();

    public static final int DIAGNOSTICS_CELL_SIZE = 15;

    public void diagnostics_generateBLTTable_block(FVariable[] order, CodeStream out, DiagnosticsGenerator.TableManager tm) {
    int start = tm.getYPos() * DIAGNOSTICS_CELL_SIZE;
    int numReal = realVariables().size();
    int numNonReal = nonRealVariables().size();
    int sizeFrame;
    int sizeNonReal = (numReal + numNonReal) * DIAGNOSTICS_CELL_SIZE + 1;
    if (diagnostics_generateBLTTable_printDiscreteFrame()) {
        sizeFrame = numReal * DIAGNOSTICS_CELL_SIZE + 1;
        if (numNonReal > 0)
            out.formatln("    <div class=\"block\" style=\"background:#F0E7CC;left:%dpx;top:%dpx;width:%dpx;height:%dpx;\"></div>", start, start, sizeNonReal, sizeNonReal);
    } else {
        sizeFrame = (numReal + numNonReal) * DIAGNOSTICS_CELL_SIZE + 1;
    }
    if (numReal > 0)
        out.formatln("    <div class=\"block\" style=\"background:%s;left:%dpx;top:%dpx;width:%dpx;height:%dpx;\"></div>", diagnostics_generateBLTTable_color(), start, start, sizeFrame, sizeFrame);
    diagnostics_generateBLTTable_rows(order, out, tm, false, -1, EMPTY_VAR_FILTER);
}

    protected boolean diagnostics_generateBLTTable_printDiscreteFrame() {
    return true;
}

    public void diagnostics_generateBLTTable_rows(FVariable[] order, CodeStream out, DiagnosticsGenerator.TableManager tm, boolean nested, int size, Map<FVariable, Integer> varFilter) {
    for (FAbstractEquation equation : allEquations()) {
        if (varFilter == EMPTY_VAR_FILTER)
            size = equation.numScalarEquations();
        String equationStr = ASTNode.escapeHTML(equation);
        for (int i = 0; i < size; i++) {
            out.formatln("    <div class=\"equation\" style=\"top:%dpx;\" title=\"%s\">%s</div>", tm.getYPos() * DIAGNOSTICS_CELL_SIZE, equationStr, equationStr);
            for (FVariable var : order) {
                Integer pos = varFilter.get(var);
                boolean contains = (equation.variables().contains(var) 
                        || equation.discretePreVariables().contains(var)
                        || equation.initialParameters().contains(var))
                        && (pos == null || pos == i);
                if (contains)
                    out.formatln("    <div class=\"incidence\" style=\"left:%dpx;top:%dpx;z-index:10000;\" title=\"%s&#13;&#13;%s\" onmouseover=\"hightlight(this);\" onmouseout=\"unhighlight(this);\" onclick=\"lockHighlight(this);\"><div>%s</div></div>", tm.getXPos() * DIAGNOSTICS_CELL_SIZE, tm.getYPos() * DIAGNOSTICS_CELL_SIZE, ASTNode.escapeHTML(var.name()), equationStr, diagnostics_generateBLTTable_solvabilitySymbol(equation.isSolved(var, nested)));
                tm.newCol();
            }
            tm.newRow();
        }
    }
}

    private String diagnostics_generateBLTTable_solvabilitySymbol(Solvability s) {
    switch (s) {
    case ANALYTICALLY_SOLVABLE:
        return "O";
    case NUMERICALLY_SOLVABLE:
        return "@";
    case UNSOLVABLE:
        return "X";
    }
    throw new IllegalArgumentException("Unsupported solvability type " + s);
}

    public void diagnostics_generateBLTTable_row(FVariable[] order, CodeStream out, DiagnosticsGenerator.TableManager tm, boolean nested, FAbstractEquation equation, Map<FVariable, Integer> varMap) {
}

    public void prettyPrintHTML(HTMLPrinter p, CodeStream str, String indent) {
        str.print("<div class=\"bltBlock\">");
        prettyPrint(p, str, indent);
        str.print("</div>");
    }


}
