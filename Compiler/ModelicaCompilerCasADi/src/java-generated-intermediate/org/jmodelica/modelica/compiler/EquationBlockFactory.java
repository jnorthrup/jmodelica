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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:28
 */
public class EquationBlockFactory extends java.lang.Object {
    
 
        /**
         * This method groups the Eq objects in a BLT block so that Eqs that
         * originates from the same FAbstractEquation are grouped together.
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<SCCBlock<E, V>> groupComponent(Collection<E> eqs) {
            Map<FAbstractEquation, SCCBlock<E, V>> groups = new LinkedHashMap<FAbstractEquation, SCCBlock<E, V>>();
            for (E eqn : eqs) {
                SCCBlock<E, V> group = groups.get(eqn.getEquation());
                if (group == null) {
                    group = new SCCBlock<E, V>();
                    groups.put(eqn.getEquation(), group);
                }
                group.addMember(eqn);
            }
            return groups.values();
        }

    

        public static SimpleEquationBlock createSimpleEquationBlock(FAbstractEquation e, Collection<FVariable> fvs, Collection<Integer> assignedIndices, BlockProducer producer, BlockDependency blockDependency, boolean solve) {
            // Check if equation is solvable for all active variables (only if we want a solved block)
            Solvability solvability = solve ? Solvability.ANALYTICALLY_SOLVABLE : Solvability.UNSOLVABLE;
            for (Iterator<FVariable> it = fvs.iterator(); solvability.isSolvable() && it.hasNext(); )
                solvability = Solvability.least(solvability, e.isSolved(it.next(), producer.duringTearing()));
            return e.createSimpleEquationBlock(fvs, assignedIndices, solvability, producer, blockDependency);
        }

    

        /**
         * This method takes an equation and a variable and constructs an equation block.
         * If <code>solve</code> is true the equation will be solved for the variable. 
         */
        public static SimpleEquationBlock createSimpleEquationBlock(FAbstractEquation equation, FVariable variable, Integer assignedIndex, BlockProducer producer, BlockDependency blockDependency, boolean solve) {
            return createSimpleEquationBlock(equation, Arrays.asList(variable), Arrays.asList(assignedIndex), producer, blockDependency, solve);
        }

    

        /**
         * This method takes an equation <code>eqn</code> and variable
         * <code>var</code> and produces an unsolved block of types
         * ScalarEquationBlock, IfEquationBlock or FFunctionCallEquationBlock.
         */
        public static <E extends AbstractEq<E,V>, V extends AbstractVar<E,V>> SimpleEquationBlock createSimpleEquationBlock(E eqn, V var, BlockProducer producer) {
            return createSimpleEquationBlock(eqn.getEquation(), var.getVariable(), eqn.groupNumber(), producer, new NoBlockDependency(), false);
        }

    

        /**
         * This method takes a list of Eq objects and create equation blocks
         * of types ScalarEquationBlock, IfEquationBlock or FFunctionCallEquationBlock.
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> SimpleEquationBlock createSimpleEquationBlock(SCCBlock<E, V> component, BlockProducer producer, boolean solve) {
            Collection<FVariable> fvs = new ArrayList<FVariable>();
            Collection<Integer> assignedIndices = new ArrayList<Integer>();
            FAbstractEquation e = component.iterator().next().getEquation(); // TODO remove this hack, set to null and introduce in first loop iteration
            boolean isMeta = true;
            for (E eqn : component) {
                if (eqn.getEquation() != e) 
                    return null;
                if (!eqn.isMeta()) {
                    isMeta = false;
                    fvs.add(eqn.getMatching().getVariable());
                    assignedIndices.add(eqn.groupNumber());
                }
            }
            if (isMeta)
                return createMetaBlock(e);
            else
                return createSimpleEquationBlock(e, fvs, assignedIndices, producer, component.computeBlockDependency(), solve);
        }

    

        /**
         * This method takes as input a set of Eq objects corresponeing to
         * a BLT block. First the, the Eq objects are grouped using
         * groupComponent to simplify the analysis. Then, if there is
         * only one Eq, a SimpleEquationBlock is created, if possible. Otherwise
         * a real or mixed equation block is created.
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> AbstractEquationBlock createEquationBlock(SCCBlock<E, V> component, BlockProducer producer, StepUtil stepUtil, boolean isInitial) {
            if (component.containsDynamicStates())
                return computeDynamicStateBlock(component, producer, stepUtil);
            
            SimpleEquationBlock seb = createSimpleEquationBlock(component, producer, true);
            if (seb != null && seb.isSolvable())
                return seb;
            
            BiPGraph g = new BiPGraph(component.getMembers(), isInitial);
            Collection<SCCBlock<Eq, Var>> subBlocks = g.tarjan(stepUtil, false);
            
            errorCheckWhenEquations(subBlocks);
            
            Collection<E> realEquations = new LinkedHashSet<E>();
            Collection<E> nonRealEquations = new ArrayList<E>();
            Collection<E> metaEquations = new ArrayList<E>();
            Set<FVariable> realVariables = new HashSet<FVariable>();
            for (E e : component) {
                if (e.isMeta()) {
                    metaEquations.add(e);
                } else if (e.getMatching().getVariable().isReal()) {
                    realEquations.add(e);
                    realVariables.add(e.getMatching().getVariable());
                } else {
                    nonRealEquations.add(e);
                }
            }

            AbstractEquationBlock block = null;
            EquationBlock eqnBlock = null;
            boolean torn = false;
            if (producer.useTearing() && realEquations.size() > 1) {
                eqnBlock = tear(component, producer, stepUtil, isInitial);
                if (eqnBlock != null && !eqnBlock.solvedBlocks().isEmpty()) {
                    block = eqnBlock;
                    torn = true;
                }
            }
            Set<FAbstractEquation> activeRealEquations = new LinkedHashSet<FAbstractEquation>();
            if (torn) {
                // Check if an equation block is mixed, i.e., contains both continous
                // and discrete variables, and if it is linear in the unknowns
                Map<FVariable, AbstractEquationBlock> varToBlockMap = new HashMap<FVariable, AbstractEquationBlock>();
                for (AbstractEquationBlock subBlock : eqnBlock.solvedRealBlocks()) {
                    for (FVariable var : subBlock.allVariables())
                        varToBlockMap.put(var, subBlock);
                }
                Set<FVariable> iterationVariables = new HashSet<FVariable>();
                for (FVariable var : block.localUnsolvedVariables())
                    iterationVariables.add(var);
                Set<AbstractEquationBlock> visitedBlocks = new HashSet<AbstractEquationBlock>();
                Set<AbstractEquationBlock> activeBlocks = new HashSet<AbstractEquationBlock>();
                for (SimpleEquationBlock subBlock : eqnBlock.unsolvedBlocks()) {
                    linearityUseCheck(subBlock, varToBlockMap, iterationVariables, visitedBlocks, activeBlocks);
                    activeBlocks.add(subBlock);
                }
                for (AbstractEquationBlock subBlock : activeBlocks)
                    activeRealEquations.addAll(subBlock.allEquations());
            } else {
                for (E eqn : realEquations)
                    activeRealEquations.add(eqn.getEquation());
            }
            
            boolean linear = true;
            for (FAbstractEquation eqn : activeRealEquations)
                linear &= eqn.checkLinearity(realVariables);
            
            boolean mixed = nonRealEquations.size() > 0 && realEquations.size() > 0;
            
            if (block == null) {
                if (seb != null && !mixed) {
                    block = seb;
                } else {
                    BiPGraph nonRealG = new BiPGraph(nonRealEquations, isInitial);
                    Collection<SimpleEquationBlock> nonRealBlocks = nonRealG.computeNonRealBlocks(producer, stepUtil);
                    eqnBlock = new EquationBlock(producer, component.computeBlockDependency(), nonRealBlocks, createSimpleBlocks(groupComponent(realEquations), producer));
                    block = eqnBlock;
                }
            }
            
            if (linear) {
                if (block.canComputeJacobian())
                    block.computeJacobian(activeRealEquations);
//                else
//                   Give warning?
            }
            if (eqnBlock != null && !torn) {
                // Torn blocks handles meta equations internaly!
                for (E eqn : metaEquations) {
                    eqnBlock.addSolvedBlock(createMetaBlock(eqn.getEquation()));
                }
            }
            return block;
        }

    
        
        private static boolean linearityUseCheck(AbstractEquationBlock block, Map<FVariable, AbstractEquationBlock> varToBlockMap,
                Set<FVariable> iterationVariables, Set<AbstractEquationBlock> visitedBlocks, Set<AbstractEquationBlock> activeBlocks) {
            if (visitedBlocks.contains(block))
                return activeBlocks.contains(block);
            visitedBlocks.add(block);
            boolean inLoop = false;
            for (FVariable var : block.inactiveVariables()) {
                if (iterationVariables.contains(var)) {
                    inLoop = true;
                    continue;
                }
                AbstractEquationBlock varBlock = varToBlockMap.get(var);
                if (varBlock != null)
                    inLoop |= linearityUseCheck(varBlock, varToBlockMap, iterationVariables, visitedBlocks, activeBlocks);
            }
            if (inLoop)
                activeBlocks.add(block);
            return inLoop;
        }

    

        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Collection<SimpleEquationBlock> createSimpleBlocks(Collection<SCCBlock<E, V>> eqs, BlockProducer producer) {
            Collection<SimpleEquationBlock> blocks = new ArrayList<SimpleEquationBlock>();
            for (SCCBlock<E, V> e : eqs)
                blocks.add(createSimpleEquationBlock(e, producer, false));
            return blocks;
        }

    

        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> void errorCheckWhenEquations(Collection<SCCBlock<Eq, Var>> subBlocks) {
            for (SCCBlock<Eq, Var> block : subBlocks) {
                if (block.getMembers().size() == 1)
                    continue;
                Collection<FVariable> vars = new ArrayList<FVariable>();
                for (Eq eqn : block.getMembers()) {
                    vars.add(eqn.getMatching().getVariable());
                }
                for (Eq eqn : block.getMembers()) {
                    if (!eqn.getEquation().isWhen())
                        continue;
                    for (FExp guard : eqn.getEquation().transformedGuards()) {
                        if (guard.dependsOn(vars)) {
                            StringBuilder sb = new StringBuilder();
                            for (Eq e : block.getMembers()) {
                                sb.append(e.printEquation());
                                sb.append("\n");
                            }
                            throw new BLTException("A when-guard is involved in an algebraic loop, "
                                            + "consider breaking it using pre() expressions. Equations in block:\n" 
                                    + sb.toString());
                        }
                    }
                }
            }
        }

    

        /**
         * This method creates a MetaEquationBlock for a given equation.
         * This method does not do any checks of the equation. So checks that
         * ensures that the equation is an meta equation must be made before
         * calling this method.
         */
        public static SimpleEquationBlock createMetaBlock(FAbstractEquation eqn) {
            Collection<FVariable> depVars = new ArrayList<FVariable>();
            depVars.addAll(eqn.algebraicVariables());
            depVars.addAll(eqn.derivativeVariables());
            return eqn.createMetaEquationBlock(EquationBlockFactory.DEFAULT_BLOCK_PRODUCER, new SimpleBlockDependency(depVars));
        }

    

        public static abstract class BlockProducer {
            public abstract boolean useTearing();
            public abstract boolean duringTearing();
            public abstract String symbol();
        }

    
        public static final BlockProducer DEFAULT_BLOCK_PRODUCER = new DefaultBlockProducer();

    
        private final static class DefaultBlockProducer extends BlockProducer {
            @Override
            public boolean useTearing() {
                return true;
            }

            @Override
            public boolean duringTearing() {
                return false;
            }

            @Override
            public String symbol() {
                return "D";
            }
        }

    
        
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, T extends BLT> T computeBLT(StepUtil stepUtil, EquationBlockFactory.BlockProducer producer, T blt, boolean inInitial,
                boolean handleHomotopy, boolean mergePre, Collection<? extends SCCBlock<E, V>> components) {
            blt = computeInnerBLT(stepUtil, producer, blt, inInitial, handleHomotopy, mergePre, components);
            blt.setLabels();
            return blt;
        }

    
    
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, T extends BLT> T computeInnerBLT(StepUtil stepUtil, EquationBlockFactory.BlockProducer producer, T blt, boolean inInitial,
                boolean handleHomotopy, boolean mergePre, Collection<? extends SCCBlock<E, V>> components) {
            Set<SCCBlock<E,V>> homotopyComponents = Collections.emptySet();
            if (inInitial && handleHomotopy) {
                stepUtil.getStepLogger().logVerbose("Initial system contains homotopy, computing homotopy block components...");
                homotopyComponents = computeHomotopyComponents(components);
                stepUtil.getStepLogger().logVerbose("... block components computed: %s", homotopyComponents);
            }
            if (!inInitial && mergePre) {
                blt = computeBLTWithPreMerge(stepUtil, producer, blt, components);
            } else {
                int homotopyCounter = 0;
                for (SCCBlock<E,V> component : components) {
                    if (homotopyComponents.contains(component)) {
                        if (++homotopyCounter < homotopyComponents.size()) {
                            continue;
                        }
                        blt.add(computeHomotopyBlock(homotopyComponents, producer, stepUtil));
                    } else {
                        blt.add(component.createEquationBlock(producer, stepUtil, inInitial));
                    }
                }
            }
            return blt;
        }

    

        
        
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> Set<SCCBlock<E, V>> computeHomotopyComponents(Collection<? extends SCCBlock<E, V>> components) {
            Set<E> eqsInHomotopyComponent = new HashSet<E>();
            Set<SCCBlock<E, V>> homotopyComponents = new LinkedHashSet<SCCBlock<E, V>>();
            for (SCCBlock<E, V> component : components) {
                boolean add = component.containsHomotopy();
                if (!add) {
                    for (E eqn : component.getPredecessors()) {
                        if (eqsInHomotopyComponent.contains(eqn)) {
                            add = true;
                            break;
                        }
                    }
                }
                if (!add) {
                    continue;
                }
                homotopyComponents.add(component);
                for (E eqn : component) {
                    eqsInHomotopyComponent.add(eqn);
                }
            }
            return homotopyComponents;
        }

    public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>>
        AbstractEquationBlock computeHomotopyBlock(Collection<SCCBlock<E, V>> components,
        BlockProducer producer, StepUtil stepUtil) {
        SCCBlock<E, V> mergedComponent = new SCCBlock<E, V>();
        for (SCCBlock<E, V> component : components) {
            for (E eqn : component) {
                mergedComponent.addMember(eqn);
            }
            mergedComponent.addPredecessors(component.getPredecessors());
        }
        
        BLT homotopyBLT = computeBLT(stepUtil, producer, new BLT(), true, false, false, components);
        HomotopySubBlock homotopySubBlock = new HomotopySubBlock(producer, mergedComponent.computeBlockDependency(), homotopyBLT);
        stepUtil.getStepLogger().logDebug("Homotopy sub block:");
        stepUtil.getStepLogger().logDebug(homotopySubBlock);
        
        BiPGraph graph = new BiPGraph(mergedComponent.getMembers(), true);
        graph.setAsHomotopySimplified();
        graph.maximumMatching(true);
        BLT simplifiedBLT = graph.computeBLT(stepUtil, producer, new BLT(), false);
        stepUtil.getStepLogger().logDebug("Simplified BLT:");
        stepUtil.getStepLogger().logDebug(simplifiedBLT);
        
        return new HomotopyBlock(producer, mergedComponent.computeBlockDependency(), homotopySubBlock, simplifiedBLT);
    }

    
        
        private static Collection<TearingAlgorithm> tearingAlgorithms;

    
        
        private static <T extends TearingAlgorithm> T addTearingAlgorithm(T algorithm) {
            if (tearingAlgorithms == null)
                tearingAlgorithms = new PriorityQueue<TearingAlgorithm>();
            tearingAlgorithms.add(algorithm);
            return algorithm;
        }

    
        
        public abstract static class TearingAlgorithm implements Comparable<TearingAlgorithm> {
            private final int priority;
            private final String option;

            public TearingAlgorithm(int priority) {
                this.priority = priority;
                this.option = null;
            }

            public TearingAlgorithm(int priority, String option) {
                this.priority = priority;
                this.option = option;
            }

            public boolean active(StepUtil stepUtil) {
                return stepUtil.getOptionRegistry().getBooleanOption(option);
            }

            public final int compareTo(TearingAlgorithm other) {
                return other.priority - priority;
            }

            public abstract <E extends AbstractEq<E,V>, V extends AbstractVar<E,V>> TornEquationBlock tear(SCCBlock<E, V> block, BlockProducer producer, StepUtil stepUtil, boolean isInitial);
        }

    
        
        public static <E extends AbstractEq<E,V>, V extends AbstractVar<E,V>> TornEquationBlock tear(SCCBlock<E, V> block, BlockProducer producer, StepUtil stepUtil, boolean isInitial) {
            TearingAlgorithm algorithm = getActiveAlgorithm(stepUtil);
            if (algorithm == null)
                return null;
            else
                return algorithm.tear(block, producer, stepUtil, isInitial);
        }

    
        
        public static TearingAlgorithm getActiveAlgorithm(StepUtil stepUtil) {
            for (TearingAlgorithm algorithm : tearingAlgorithms)
                if (algorithm.active(stepUtil))
                    return algorithm;
            return null;
        }

    
        
        public static boolean canTear(StepUtil stepUtil) {
            return getActiveAlgorithm(stepUtil) != null;
        }

    
        
        public static final BlockProducer AUTOMATIC_TEARING_BLOCK_PRODUCER = new AutomaticTearingBlockProducer();

    
        private final static class AutomaticTearingBlockProducer extends BlockProducer {
            @Override
            public boolean useTearing() {
                return true;
            }

            @Override
            public boolean duringTearing() {
                return true;
            }

            @Override
            public String symbol() {
                return "A";
            }
        }

    
        
        private static AutomaticTearingAlgorithm AUTOMATIC_TEARING = addTearingAlgorithm(new AutomaticTearingAlgorithm());

    
        
        public static class AutomaticTearingAlgorithm extends TearingAlgorithm {

            public AutomaticTearingAlgorithm() {
                super(1, "automatic_tearing");
            }

            @Override
            public <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> TornEquationBlock tear(SCCBlock<E, V> block, BlockProducer producer, StepUtil stepUtil, boolean isInitial) {
                TornEquationBlock teb = new TornEquationBlock(producer, block.computeBlockDependency());
                tear(block, teb, stepUtil, isInitial);
                return teb;
            }
            
            private <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> void tear(SCCBlock<E, V> block, TornEquationBlock eb, StepUtil stepUtil, boolean isInitial) {
                SolvingBiPGraph g = new SolvingBiPGraph(block.getMembers(), isInitial);
                if (isInitial)
                    g.setAsInitialSystem();
                
                stepUtil.getStepLogger().logVerbose("Starting automatic tearing");
                stepUtil.getStepLogger().logVerbose(g);
                stepUtil.getStepLogger().logVerbose("Initial matching");
                stepUtil.getStepLogger().logVerbose(g.printMatchingObj());
                
                // Obtain Maximum Solvable Matching in two steps (greedy and augmenting paths)
                g.greedyMatching();
                for (SolvingEq eqn : g.getUnmatchedEquations()) {
                    if (!g.augmentPath(eqn)) {
                        g.constrainedAugmentedPath(eqn);
                    }
                    g.lightReset();
                }
                Collection<SolvingEq> SUME = new ArrayList<SolvingEq>();
                for (SolvingEq eqn : g.getUnmatchedEquations()) {
                    eqn.isRes(true);
                    SUME.add(eqn);
                }

                stepUtil.getStepLogger().logVerbose("Matching after initial manipulation");
                stepUtil.getStepLogger().logVerbose(g.printMatchingObj());
                // Now we have a Maximum Solvable Matching

                if (SUME.isEmpty()) { // If: there exist a Pefect Solvable Matching
                                        //     proceed with recursive tearing of block
                    SimpleEquationBlock tearBlock = EquationBlockFactory.createSimpleEquationBlock(block, AUTOMATIC_TEARING_BLOCK_PRODUCER, true);
                    if (tearBlock != null && tearBlock.isSolvable()) {
                        eb.addSolvedBlock(tearBlock);
                    } else {
                        tearInner(stepUtil, g, eb);
                    }
                } else {
                    // Else: Start out by trying to insert residuals that contain
                    //       few variables. 
                    java.util.List<SolvingEq> residuals = new ArrayList<SolvingEq>();
                    for (SolvingEq e : SUME) {
                        // No need to deal with meta equations here since they
                        // can not be in SUME and no variable matches to a meta
                        // equation.
                        SolvingEq bestRes = e;
                        for (SolvingVar v : e.getSolvableVariables()) {
                            SolvingEq ee = v.getMatching();
                            if (ee.compareTo(bestRes) > 0)
                                bestRes = ee;
                        }
                        if (bestRes != e) {
                            bestRes.isRes(true);
                            g.match(e, bestRes.getMatching());
                            e.isRes(false);
                            residuals.add(bestRes);
                        } else {
                            residuals.add(e);
                        }
                    }

                    // Compute inner BLT and see if tearings can be changed 
                    Set<SolvingVar> SUMV = new LinkedHashSet<SolvingVar>(g.getUnmatchedVariables());
                    Collection<SCCBlock<SolvingEq, SolvingVar>> innerBlocks = g.tarjan(false);
                    java.util.List<SolvingVar> tearings = new ArrayList<SolvingVar>();

                    for (SCCBlock<SolvingEq, SolvingVar> bInner : innerBlocks) {
                        SimpleEquationBlock tearBlock = EquationBlockFactory.createSimpleEquationBlock(bInner, AUTOMATIC_TEARING_BLOCK_PRODUCER, true);
                        if (tearBlock != null && tearBlock.isSolvable()) {
                            eb.addSolvedBlock(tearBlock);
                            // If the equation contains a Var in SUMV, that Var cannot be
                            // reinserted and must be used as a iteration variable.
                            for (SolvingEq e : bInner) {
                                for (SolvingVar vv : e.getVariables()) {
                                    if (SUMV.remove(vv))
                                        tearings.add(vv);
                                }
                            }
                        } else {
                            // Build Inner Graph and add info about iteration variables
                            SolvingBiPGraph gInner = new SolvingBiPGraph(bInner.getMembers(), isInitial);
                            // Build block-graph and look for interchangeable variables in SUMV
                            java.util.List<SolvingEq> eqs = new ArrayList<SolvingEq>();
                            boolean graphHasTear = false;
                            for (SolvingEq e : bInner) {
                                SolvingEq gInnerEq = gInner.getEquation(e.getName());
                                for (SolvingVar v : e.getVariables()) {
                                    SolvingVar gInnerVar = gInner.getVariable(v.getName());
                                    if (gInnerVar != null && gInnerVar.isIter()) {
                                        gInner.addInsidence(gInnerEq, gInnerVar);
                                        if (gInner.canMatch(gInnerEq, gInnerVar) && gInnerVar.isIter() && !eqs.contains(gInnerEq)) {
                                            eqs.add(gInnerEq);
                                        }
                                    } else if (SUMV.contains(v)) {
                                        gInnerVar = gInner.addVariable(v.getName(), v.getVariable());
                                        gInnerVar.isIter(true);
                                        SUMV.remove(v);
                                        tearings.add(v);
                                        graphHasTear = true;
                                        gInner.addInsidence(gInnerEq, gInnerVar);
                                        if (gInner.canMatch(gInnerEq, gInnerVar) && !eqs.contains(gInnerEq)) {
                                            eqs.add(gInnerEq);
                                        }
                                    }
                                }
                            }
                            // Go through equations that might get a new matching
                            boolean isChanged = false;
                            for (SolvingEq e : eqs) {
                                if (e.isMeta()) {
                                    continue;
                                }
                                SolvingVar bestMatch = e.getMatching();
                                for (SolvingVar v : e.getSolvableVariables()) {
                                    if (v.isIter() && v.compareTo(bestMatch) < 0)
                                        bestMatch = v;
                                }
                                if (bestMatch != e.getMatching()) {
                                    SolvingVar tmp = e.getMatching();
                                    tmp.isIter(true);
                                    bestMatch.isIter(false);
                                    tearings.add(tmp);
                                    tearings.remove(bestMatch);
                                    gInner.match(e, bestMatch);
                                    isChanged = true;
                                }
                            }

                            if (graphHasTear) {
                                if (isChanged) {
                                    Collection<SCCBlock<SolvingEq, SolvingVar>> newBlocks = gInner.tarjan(false);
                                    for (SCCBlock<SolvingEq, SolvingVar> bInnerInner : newBlocks) {
                                        tearBlock = EquationBlockFactory.createSimpleEquationBlock(bInnerInner, AUTOMATIC_TEARING_BLOCK_PRODUCER, true);
                                        if (tearBlock != null && tearBlock.isSolvable()) {
                                            eb.addSolvedBlock(tearBlock);
                                        } else {
                                            tearInner(stepUtil, new SolvingBiPGraph(bInnerInner.getMembers(), isInitial), eb);
                                        }
                                    }
                                } else {
                                    tearInner(stepUtil, new SolvingBiPGraph(bInner.getMembers(), isInitial), eb);
                                }
                            } else {
                                // Reuse the already constructed graph
                                tearInner(stepUtil, gInner, eb);
                            }
                        }
                    }
                    for (SolvingVar v : SUMV) {
                        //SUMV ought to be empty, but there might exist variables that hasn't 
                        // been altered before. 
                        tearings.add(v);
                    }
                    for (int i = 0; i < tearings.size(); i++) {
                        stepUtil.getStepLogger().logVerbose("Automatic tearing pair, equation: %s, tearing with variable: %s", residuals.get(i).getEquation(), tearings.get(i).getName());
                        eb.addUnsolvedBlock(EquationBlockFactory.createSimpleEquationBlock(residuals.get(i), tearings.get(i), AUTOMATIC_TEARING_BLOCK_PRODUCER));
                    }
                }
            }
            
            private static void tearInner(StepUtil stepUtil, SolvingBiPGraph g, TornEquationBlock eb){
                SolvingVar bestIter = null;
                for (SolvingEq e : g.getEquations()) {
                    if (e.isMeta()) {
                        continue;
                    }
                    SolvingVar v = e.getMatching();
                    if (bestIter == null || v.compareTo(bestIter) > 0)
                        bestIter = v;
                }
                SolvingEq res = bestIter.getMatching();
                bestIter.isIter(true);
                res.isRes(true);
                stepUtil.getStepLogger().logVerbose("Automatic tearing pair, equation: %s, tearing with variable: %s", res.getEquation(), bestIter.getVariable().displayName());
                eb.addUnsolvedBlock(EquationBlockFactory.createSimpleEquationBlock(res, bestIter, AUTOMATIC_TEARING_BLOCK_PRODUCER));
                Collection<SCCBlock<SolvingEq, SolvingVar>> blt = g.tarjan(false);
                for (SCCBlock<SolvingEq, SolvingVar> block : blt) {
                    SimpleEquationBlock tearBlock = EquationBlockFactory.createSimpleEquationBlock(block, AUTOMATIC_TEARING_BLOCK_PRODUCER, true);
                    if (tearBlock != null && tearBlock.isSolvable()) {
                        eb.addSolvedBlock(tearBlock);
                    } else {
                        tearInner(stepUtil, new SolvingBiPGraph(block.getMembers(), g.isInitialSystem()), eb);
                    }
                }
            }
        }

    private static FVariable[][] combineDSCombinations(FVariable[][][] sets, int totalNumVars) {
        if (sets.length == 1)
            return sets[0];
        Collection<FVariable[]> res = new ArrayList<FVariable[]>();
        combineDSCombinations(sets, res, totalNumVars, new FVariable[totalNumVars], 0, 0);
        return res.toArray(new FVariable[res.size()][]);
    }

    private static void combineDSCombinations(FVariable[][][] sets, Collection<FVariable[]> res, int totalNumVars, FVariable[] current, int set, int offset) {
        for (int i = 1; i <= sets[set].length; i++) {
            System.arraycopy(sets[set][i - 1], 0, current, offset, sets[set][i - 1].length);
            if (sets.length == set + 1) {
                FVariable[] copy = new FVariable[totalNumVars];
                System.arraycopy(current, 0, copy, 0, totalNumVars);
                res.add(copy);
            } else {
                combineDSCombinations(sets, res, totalNumVars, current, set + 1, offset + sets[set][i - 1].length);
            }
        }
    }

    
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>> DynamicStateBlock computeDynamicStateBlock(SCCBlock<E, V> component, BlockProducer producer, StepUtil stepUtil) {
            Map<DynamicStateSet, FDynamicAlgebraicVariable[]> setVarMap = new LinkedHashMap<DynamicStateSet, FDynamicAlgebraicVariable[]>();
            Collection<V> otherVars = new ArrayList<V>();
            for (E eqn : component.getMembers()) {
                if (eqn.isMeta()) {
                    continue;
                }
                FVariable fVar = eqn.getMatching().getVariable();
                if (!fVar.isFDynamicAlgebraicVariable()) {
                    otherVars.add(eqn.getMatching());
                    continue;
                }
                FDynamicAlgebraicVariable var = fVar.asFDynamicAlgebraicVariable();
                DynamicStateSet set = var.getSet();
                if (var.getNumber() - 1 >= set.numAlgebraics() || var.getNumber() - 1 < 0)
                    throw new BLTException(var.name() + " has illegal dynamic state variable number, set size is " + set.numAlgebraics());
                FDynamicAlgebraicVariable[] vars = setVarMap.get(set);
                if (vars == null) {
                    vars = new FDynamicAlgebraicVariable[set.numAlgebraics()];
                    setVarMap.put(set, vars);
                }
                if (vars[var.getNumber() - 1] != null)
                    throw new BLTException("There are two instances of " + var.name() + " in the same BLT block!");
                vars[var.getNumber() - 1] = var;
            }
            if (setVarMap.isEmpty())
                throw new BLTException("No dynamic state variables were found in the BLT block");
            FVariable[][][] setCombinations = new FVariable[setVarMap.size()][][];
            int setCounter = 0;
            int totalNumAlgebraics = 0;
            int totalNumCombinations = 1;
            Collection<FVariable> allDynamicStates = new ArrayList<FVariable>();
            for (Map.Entry<DynamicStateSet, FDynamicAlgebraicVariable[]> entry : setVarMap.entrySet()) {
                boolean allSet = true;
                DynamicStateSet set = entry.getKey();
                FDynamicAlgebraicVariable[] DSVars = entry.getValue();
                for (int i = 1; i <= DSVars.length; i++) {
                    if (DSVars[i - 1] == null) {
                        allSet = false;
                    }
                }
                if (!allSet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Not all dynamic state variables resides in the same block, index ");
                    boolean first = true;
                    for (int i = 1; i <= DSVars.length; i++) {
                        if (DSVars[i - 1] != null)
                            continue;
                        if (!first)
                            sb.append(", ");
                        first = false;
                        sb.append(i);
                    }
                    sb.append(" are missing. Set:\n");
                    sb.append(set);
                    throw new BLTException(sb.toString());
                }
                setCombinations[setCounter] = set.algebraicCombinations();
                allDynamicStates.addAll(set.fVarsColl());
                totalNumAlgebraics += set.numAlgebraics();
                totalNumCombinations *= set.numCombinations();
                setCounter++;
            }
            if (totalNumCombinations > 42)
                throw new BLTException("Ouch! There are more than 42 combinations for the dynamic states, there were " + totalNumCombinations + " combinations!");
            FVariable[][] combinations = combineDSCombinations(setCombinations, totalNumAlgebraics);
            DynamicStateBLT[] blts = new DynamicStateBLT[combinations.length];
            for (int i = 0; i < combinations.length; i++) {
                FVariable[] combination = combinations[i];
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < combination.length; j++) {
                    sb.append(combination[j].name() + " ");
                }
                ASTNode.log.debug("Generating BLT for: %s", sb);
                BiPGraph graph = new BiPGraph(component.getMembers(), otherVars);
                for (FVariable var : combination)
                    graph.addVariable(var);
                for (Eq eqn : graph.getEquations()) {
                    Set<FVariable> vars = eqn.getEquation().referencedFVariables();
                    for (FVariable var : combination)
                        if (vars.contains(var))
                            graph.addEdge(eqn, graph.getVariable(var.name()));
                }
                ASTNode.log.debug(graph);
                graph.maximumMatching(true);
                Set<FVariable> algebraics = new LinkedHashSet<FVariable>(Arrays.asList(combination));
                Collection<FVariable> states = new ArrayList<FVariable>();
                for (FVariable var : allDynamicStates)
                    if (!algebraics.contains(var))
                        states.add(var);
                DynamicStateBLT blt = new DynamicStateBLT(setVarMap.keySet(), states, algebraics);
                if (graph.isComplete()) {
                    blt = graph.computeBLT(stepUtil, producer, blt, false);
                } else {
                    ASTNode.log.verbose("  This combination does not have a valid solution!");
                    ASTNode.log.debug(graph.printMatchingObj());
                }
                ASTNode.log.debug(blt);
                blts[i] = blt;
            }
            return new DynamicStateBlock(producer, component.computeBlockDependency(), blts, setVarMap.keySet());
        }

    
        public static final BlockProducer INDEX_REDUCTION_BLOCK_PRODUCER = new IndexReductionBlockProducer();

    

        private final static class IndexReductionBlockProducer extends BlockProducer {
            @Override
            public boolean useTearing() {
                return false;
            }

            @Override
            public boolean duringTearing() {
                return false;
            }

            @Override
            public String symbol() {
                return "I";
            }
        }

    

        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>, T extends BLT> T computeBLTWithPreMerge(StepUtil stepUtil, BlockProducer producer, T blt,
                Collection<C> components) {
            Collection<TarjanComponent<C>> tarjanRes = computePreBlocks(components);
            for (TarjanComponent<C> block : tarjanRes) {
                if (block.getMembers().size() == 1) {
                    blt.add(block.iterator().next().createEquationBlock(producer, stepUtil, false));
                } else {
                    SCCBlock<E, V> aggr  = new SCCBlock<E, V>();
                    for (C subBlock : block) {
                        for (E eqn : subBlock) {
                            aggr.addMember(eqn);
                        }
                        aggr.addPredecessors(subBlock.getPredecessors());
                    }
                    BiPGraph g = new BiPGraph(aggr.getMembers(), false);
                    Collection<SCCBlock<Eq, Var>> sortedBlocks = g.tarjan(stepUtil, false);
                    blt.add(new PrePropagationEquationBlock(producer, aggr.computeBlockDependency(), computeInnerBLT(stepUtil, producer, new BLT(), false, false, false, sortedBlocks)));
                }
            }
            return blt;
        }

    

        /**
         * The goal of this method is to merge blocks so that the block
         * sequence fulfil the following:
         * - That discrete variables are in the same block as their pre
         *   variable uses.
         * - All equations which contains an event generating expression are
         *   in the same block as all downstream equations which have a
         *   reference pre(x) where x is assigned by any of the equations on 
         *   the downstream path.
         * 
         * This is done in two steps, first merge pre and variable uses and
         * secondly merge event generating expressions with downstream pre.
         * This can not be done in one step!
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<TarjanComponent<C>> computePreBlocks(Collection<C> blocks) {
            // Compute variable to block map
            Map<FAbstractVariable, C> varToBlockMap = computeVarToBlockMap(blocks);
            // Find blocks which needs to be together due to decl and pre use
            Collection<TarjanComponent<C>> varDeclPreUseBlocks = mergeDeclAndPre(blocks, varToBlockMap);
            // Find blocks which needs to be together due to event and pre use
            Collection<TarjanComponent<TarjanComponent<C>>> eventPreBlocks =
                    mergeEventAndPre(varDeclPreUseBlocks, varToBlockMap.keySet());
            // Finally merge
            return mergeSubComponents(eventPreBlocks);
        }

    

        /**
         * Computes a map beteen variable and its defining block
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Map<FAbstractVariable, C> computeVarToBlockMap(Collection<C> components) {
            Map<FAbstractVariable, C> res = new HashMap<FAbstractVariable, C>();
            for (C component : components) {
                for (E eqn : component) {
                    if (eqn.isMeta()) {
                        continue;
                    }
                    res.put(eqn.getMatching().getVariable(), component);
                }
            }
            return res;
        }

    

        /**
         * Computes a ordered set of block containing sub-blocks which must be
         * together due to var decl and pre use.
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<TarjanComponent<C>> mergeDeclAndPre(Collection<C> blocks,
                Map<FAbstractVariable, C> varToBlockMap) {
            // Add link between discrete variables and their pre usages
            Map<C, Collection<C>> linkedDeclAndPres = linkVarDeclAndPreUse(blocks, varToBlockMap);
            // Compute predecessors for pre-var blocks
            Map<C, Collection<C>> predecessors = TarjanComponent.computePredecessorsMap(blocks);
            // And sort using tarjan
            PreTarjan<C> tarjan = new PreTarjan<C>(predecessors, linkedDeclAndPres);
            return tarjan.tarjan(blocks);
        }

    

        /**
         * Fins all blocks which must be together since they contain a variable
         * declaration and usage of pre of the variable.
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Map<C, Collection<C>> linkVarDeclAndPreUse(Collection<C> components,
                Map<FAbstractVariable, C> varToBlockMap) {
            Map<C, Collection<C>> blocksToMerge = new HashMap<C, Collection<C>>();
            for (C component : components) {
                Collection<C> res = blocksToMerge.get(component);
                for (E eqn : component) {
                    for (FVariable var : eqn.getEquation().discretePreVariables()) {
                        FAbstractVariable nonPre = var.myNonPreVariable();
                        C other = varToBlockMap.get(nonPre);
                        Collection<C> otherRes = blocksToMerge.get(other);
                        if (res == null && otherRes == null) {
                            res = new ArrayList<C>();
                            res.add(component);
                            blocksToMerge.put(component, res);
                            res.add(other);
                            blocksToMerge.put(other, res);
                        } else if (res == null) {
                            res = otherRes;
                            res.add(component);
                            blocksToMerge.put(component, res);
                        } else if (otherRes == null) {
                            res.add(other);
                            blocksToMerge.put(other, res);
                        } else if (res != otherRes) {
                            // We need to merge the two! We do this by repointing
                            // all to current res
                            res.addAll(otherRes);
                            for (C c : otherRes) {
                                blocksToMerge.put(c, res);
                            }
                        } else {
                            // Do nothing, both are in res already!
                        }
                    }
                }
            }
            return blocksToMerge;
        }

    

        /**
         * Merges event generating blocks with all downstream blocks that has
         * pre variable references.
         */
        public static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<TarjanComponent<TarjanComponent<C>>> mergeEventAndPre(
                Collection<TarjanComponent<C>> varDeclPreUseBlocks, Set<FAbstractVariable> activeVars) {
            // Compute predecessors for the pre-var blocks
            Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> predecessors =
                    TarjanComponent.computePredecessorsMap(varDeclPreUseBlocks);
            // Propagate event info
            Map<TarjanComponent<C>, Boolean> containsOrSucceedsEvents = 
                    computeContainsOrSucceedsEvents(varDeclPreUseBlocks, predecessors);
            // Find blocks which needs to be merged since pre is downstream of event gen exp
            Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> blocksToMerge = 
                    computeEventAndPreBlocks(varDeclPreUseBlocks, predecessors, containsOrSucceedsEvents, activeVars);
            // And sort
            PreTarjan<TarjanComponent<C>> tarjan = new PreTarjan<TarjanComponent<C>>(predecessors, blocksToMerge);
            return tarjan.tarjan(varDeclPreUseBlocks);
        }

    

        /**
         * For each component, this method determines if it is event
         * generating of depends on event generating equations. 
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Map<TarjanComponent<C>, Boolean> computeContainsOrSucceedsEvents(Collection<TarjanComponent<C>> components,
                Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> predecessors) {
            Map<TarjanComponent<C>, Boolean> containsOrSucceedsEvents = new HashMap<TarjanComponent<C>, Boolean>();
            for (TarjanComponent<C> component : components) {
                checkComponentForEventEqs(component, containsOrSucceedsEvents, predecessors);
            }
            return containsOrSucceedsEvents;
        }

    

        /**
         * Helper, checks if the component contains event generating expressions
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> boolean checkComponentForEventEqs(TarjanComponent<C> component, Map<TarjanComponent<C>, Boolean> containsOrSucceedsEventEq,
                Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> predecessors) {
            Boolean res = containsOrSucceedsEventEq.get(component);
            if (res != null) {
                return res;
            }
            res = false;
            for (TarjanComponent<C> predecessor : predecessors.get(component)) {
                if (checkComponentForEventEqs(predecessor, containsOrSucceedsEventEq, predecessors)) {
                    res = true;
                    break;
                }
            }
            if (!res) {
                for (C block : component) {
                    for (E eqn : block.getMembers()) {
                        if (eqn.getEquation().eventGenExps().size() > 0 || eqn.getEquation().isSampleEquation()) {
                            res = true;
                            break;
                        }
                    }
                }
            }
            containsOrSucceedsEventEq.put(component, res);
            return res;
        }

    

        /**
         * Computes which components needs to be merged. The result
         * contains a map with an entry for each component that needs to be
         * merged. It maps to the collection of components thatn needs to
         * be merged.
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> computeEventAndPreBlocks (
                Collection<TarjanComponent<C>> components, Map<TarjanComponent<C>,
                Collection<TarjanComponent<C>>> predecessors,
                Map<TarjanComponent<C>, Boolean> containsOrSucceedsEventEq, Set<FAbstractVariable> inBlockSet) {
            Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> blocksToMerge = new HashMap<TarjanComponent<C>, Collection<TarjanComponent<C>>>();
            for (TarjanComponent<C> component : components) {
                computeBlocksToMerge(component, false, blocksToMerge, containsOrSucceedsEventEq, predecessors,
                        inBlockSet);
            }
            Iterator<Map.Entry<TarjanComponent<C>, Collection<TarjanComponent<C>>>> it = blocksToMerge.entrySet().iterator();
            ASTNode.log.debug(new LinkedHashSet<Collection<TarjanComponent<C>>>(blocksToMerge.values()));
            while (it.hasNext()) {
                Map.Entry<TarjanComponent<C>, Collection<TarjanComponent<C>>> entry = it.next();
                if (entry.getValue().size() <= 1) {
                    it.remove();
                }
            }
            return blocksToMerge;
        }

    

        /**
         * Helper, recursive method used in above method.
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<TarjanComponent<C>> computeBlocksToMerge(TarjanComponent<C> component, boolean force,
                Map<TarjanComponent<C>, Collection<TarjanComponent<C>>> blocksToMerge,
                Map<TarjanComponent<C>, Boolean> containsOrSucceedsEvents, Map<TarjanComponent<C>,
                Collection<TarjanComponent<C>>> predecessors,
                Set<FAbstractVariable> inBlockSet) {
            if (!containsOrSucceedsEvents.get(component)) {
                return Collections.<TarjanComponent<C>>emptyList();
            }
            Collection<TarjanComponent<C>> res = blocksToMerge.get(component);
            if (res != null && (res.size() > 0 || !force)) {
                return res;
            }
            res = null;
            boolean containsPre = containsActivePre(component, inBlockSet);
            if (containsPre || force) {
                for (TarjanComponent<C> predecessor : predecessors.get(component)) {
                    Collection<TarjanComponent<C>> predecessorRes = computeBlocksToMerge(predecessor, true, blocksToMerge,
                            containsOrSucceedsEvents, predecessors, inBlockSet);
                    if (predecessorRes.isEmpty()) {
                        continue;
                    } else if (res == null) {
                        res = predecessorRes;
                    } else if (predecessorRes != res) {
                        // We need to merge the two! We do this by repointing
                        // all to current res
                        res.addAll(predecessorRes);
                        for (TarjanComponent<C> c : predecessorRes) {
                            blocksToMerge.put(c, res);
                        }
                    }
                }
                if (res == null) {
                    // If no predecessor had any event generating equation,
                    // then res is null and we need to create a new list
                    res = new ArrayList<TarjanComponent<C>>();
                }
                res.add(component);
            } else {
                res = Collections.emptyList();
            }
            blocksToMerge.put(component, res);
            return res;
        }

    

        /**
         * Helper which determines if an equation contains an active pre
         * reference. It's active if the discrete variable is in the graph.
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> boolean containsActivePre(TarjanComponent<C> component, Set<FAbstractVariable> inBlockSet) {
            for (C block : component) {
                for (E eqn : block) {
                    for (FVariable var : eqn.getEquation().discretePreVariables()) {
                        FAbstractVariable nonPre = var.myNonPreVariable();
                        if (inBlockSet.contains(nonPre)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

    

        /**
         * Merges components which needs to be in the same block.
         */
        private static <E extends AbstractEq<E, V>, V extends AbstractVar<E, V>, C extends SCCBlock<E, V>> Collection<TarjanComponent<C>> mergeSubComponents(Collection<TarjanComponent<TarjanComponent<C>>> preBlocks2) {
            Collection<TarjanComponent<C>> components = new ArrayList<TarjanComponent<C>>();
            for (TarjanComponent<TarjanComponent<C>> preBlock2 : preBlocks2) {
                Iterator<TarjanComponent<C>> it = preBlock2.iterator();
                TarjanComponent<C> newComponent = it.next();
                while (it.hasNext()) {
                    TarjanComponent<C> component = it.next();
                    newComponent.mergeWith(component);
                }
                
                if (preBlock2.getMembers().size() > 1) {
                    
                } else {
                }
                components.add(newComponent);
            }
            Set<FVariable> assigned = new HashSet<>();
            for (TarjanComponent<C> component : components) {
                for (C subComponent : component) {
                    for (E eqn : subComponent) {
                        if (!eqn.isMeta()) {
                            assigned.add(eqn.getMatching().getVariable());
                        }
                    }
                }
            }
            Collection<TarjanComponent<C>> newComponents = new ArrayList<TarjanComponent<C>>();
            for (TarjanComponent<C> component : components) {
                if (component.getMembers().size() > 1) {
                    boolean containsNestedDiscrete = false;
                    for (C subComponent : component) {
                        if (subComponent.getMembers().size() == 1) {
                            continue;
                        }
                        for (E eqn : subComponent) {
                            boolean hasSwitch = false;
                            for (FRelExp exp : eqn.getEquation().relExpInEquation()) {
                                if (exp.dependsOn(assigned)) {
                                    hasSwitch = true;
                                    break;
                                }
                            }
                            if (!eqn.isMeta() && !eqn.getMatching().getVariable().isContinuous() || hasSwitch) {
                                // If the matched variable and in effect the
                                // equation is discrete, then we need to
                                // extract all sub-blocks into one block.
                                containsNestedDiscrete = true;
                                break;
                            }
                        }
                    }
                    if (containsNestedDiscrete) {
                        // Merge!
                        Iterator<C> it = component.iterator();
                        C newSubComponent = it.next();
                        while (it.hasNext()) {
                            C mergeComponent = it.next();
                            newSubComponent.mergeWith(mergeComponent);
                        }
                        TarjanComponent<C> newComponent = new TarjanComponent<C>();
                        newComponent.addPredecessors(component.getPredecessors());
                        newComponent.addMember(newSubComponent);
                        component = newComponent;
                    }
                }
                newComponents.add(component);
            }
            return newComponents;
        }

    

        private static class PreTarjan<C extends TarjanComponent<?>> extends SimpleTarjan<C> {

            private final Map<C, Collection<C>> predecessors;
            private final Map<C, Collection<C>> blocksToMerge;

            public PreTarjan(Map<C, Collection<C>> predecessors, Map<C, Collection<C>> blocksToMerge) {
                this.predecessors = predecessors;
                this.blocksToMerge = blocksToMerge;
            }

            @Override
            protected void addPredecessors(C n, Collection<C> predecessors) {
                predecessors.addAll(this.predecessors.get(n));
            }

            @Override
            protected void forceIntoSame(C n, Set<C> members) {
                Collection<C> mergeList = blocksToMerge.get(n);
                if (mergeList != null) {
                    members.addAll(mergeList);
                }
            }
        }


}
