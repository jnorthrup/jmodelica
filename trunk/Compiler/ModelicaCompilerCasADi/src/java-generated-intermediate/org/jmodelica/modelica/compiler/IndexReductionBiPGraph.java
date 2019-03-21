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
 * @aspect DynamicStateSelect
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:263
 */
public class IndexReductionBiPGraph extends AbstractBiPGraph<IndexReductionEq, IndexReductionVar, IndexReductionSCCBlock> {
    
        public static class DSSet {
            private static Enumerator e = new Enumerator();
            public final Set<IndexReductionEq> eqns = new LinkedHashSet<IndexReductionEq>();
            public final Set<IndexReductionVar> vars = new LinkedHashSet<IndexReductionVar>();
            public final int id = e.next();
            public FExp[][] coefficients;
            
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("Set %d, %d equations and %d variables:\n", id, eqns.size(), vars.size()));
                sb.append("  Equations:\n");
                for (IndexReductionEq eqn : eqns)
                    sb.append("    " + eqn + "\n");
                sb.append("  Variables:\n");
                for (IndexReductionVar var : vars)
                    sb.append("    " + var + "\n");
                return sb.toString();
            }
        }

    public Set<IndexReductionVar> computeDynamicStateSets(int dynamicStateLimit, 
            Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix, IndexReductionResult result) {
        if (result.hasDSFailed())
            return Collections.emptySet();
        Map<IndexReductionVar, IndexReductionEq> initialMatching = new HashMap<IndexReductionVar, IndexReductionEq>();
        for (IndexReductionVar var : getVariables())
            initialMatching.put(var, var.getMatching());
        
        Map<IndexReductionVar, IndexReductionEq> tempAssignmentMap = computeTempAssignmentMap();
        
        ASTNode.log.verbose(printCoefficientsObj(coefficientsMatrix, false));
        ASTNode.log.verbose(printCoefficientsObj(coefficientsMatrix, true));
        Set<DSSet> dsSets = new LinkedHashSet<DSSet>();
        Map<IndexReductionEq, DSSet> dsLookup = new HashMap<IndexReductionEq, DSSet>();
        Queue<IndexReductionEq> worklist = new ArrayDeque<IndexReductionEq>();
        SAP1 sap1 = new SAP1(dsLookup.keySet(), coefficientsMatrix);
        SAP2 sap2 = new SAP2(dsLookup.keySet(), coefficientsMatrix, worklist);
        for (IndexReductionEq eqn : getEquations()) {
            Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
            if (coefficients == null)
                continue;
            Coefficient coff = coefficients.get(eqn.getMatching());
            if (coff != null && coff.state == COEFFICIENT_STATE.CONTINUOUS)
                worklist.add(eqn);
        }
        while (!worklist.isEmpty()) {
            IndexReductionEq eqn = worklist.poll();
            ASTNode.log.debug("Looking for DS in %s", eqn);
            Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
            if (coefficients == null)
                continue;
            if (!dynamicSetCandidate(eqn, eqn.getMatching(), coefficients))
                continue;
            lightReset();
            ASTNode.log.debug("  SAP1");
            if (sap1.augmentingPath(eqn)) {
                continue;
            }
            DSSet set = dsLookup.get(eqn);
            if (set == null)
                set = new DSSet();
            Collection<IndexReductionEq> otherEqns = new ArrayList<IndexReductionEq>();
            ASTNode.log.debug("    Path not found, set %d", set.id);
            for (IndexReductionVar var : eqn.getVariablesSortedSAP2(tempAssignmentMap)) {
                if (!dynamicSetCandidate(eqn, var, coefficients))
                    continue;
                ASTNode.log.debug("  Checking ncc variable %s", var);
                if (var.getMatching() == eqn) {
                    set.vars.add(var);
                    ASTNode.log.debug("    adding %s to set %d", var, set.id);
                } else if (var.getMatching() == null) {
                    set.vars.add(var);
                    var.setMatching(eqn);
                    ASTNode.log.debug("    adding %s to set %d", var, set.id);
                } else {
                    IndexReductionEq tmpAssignEqn = tempAssignmentMap.get(var);
                    if (tmpAssignEqn != null) {
                        if (tmpAssignEqn.getMatching() != var && dsLookup.get(tmpAssignEqn) == null) {
                            set.vars.add(tmpAssignEqn.getMatching());
                            set.eqns.add(tmpAssignEqn);
                            continue;
                        }
                    }
                    lightReset();
                    DSSet otherSet = dsLookup.get(var.getMatching());
                    Collection<IndexReductionVar> noVisit = new ArrayList<IndexReductionVar>();
                    if (otherSet != null)
                        noVisit.addAll(otherSet.vars);
                    noVisit.addAll(set.vars);
                    noVisit.add(eqn.getMatching());
                    noVisit.add(var);
                    ASTNode.log.debug("    SAP2 %s", var.getMatching());
                    Collection<IndexReductionEq> res = sap2.augmentingPath(var.getMatching(), noVisit);
                    if (res == sap2.trueValue()) {
                        ASTNode.log.debug("      Path found");
                        set.vars.add(var);
                        var.setMatching(eqn);
                        ASTNode.log.debug("      adding %s to set %d", var, set.id);
                    } else {
                        ASTNode.log.debug("      Path not found");
                        for (IndexReductionEq resEqn : res)
                            ASTNode.log.debug("      Adding %s to set.eqns", resEqn);
                        otherEqns.addAll(res);
                    }
                }
            }
            if (set.vars.size() >= 2 || set.eqns.size() > 0 || otherEqns.size() > 0) {
                for (IndexReductionEq otherEqn : otherEqns) {
                    DSSet otherSet = dsLookup.remove(otherEqn);
                    if (otherSet != null) {
                        ASTNode.log.debug("  Merging with set %d from %s", otherSet.id, otherEqn);
                        dsSets.remove(otherSet);
                        for (IndexReductionVar memberVar : otherSet.vars) {
                            set.vars.add(memberVar);
                            ASTNode.log.debug("    adding %s to set %d", memberVar, set.id);
                        }
                        for (IndexReductionEq memberEq : otherSet.eqns) {
                            set.eqns.add(memberEq);
                            dsLookup.put(memberEq, set);
                        }
                    } else {
                        set.eqns.add(otherEqn);
                        dsLookup.put(otherEqn, set);
                        set.vars.add(otherEqn.getMatching());
                    }
                }
                set.eqns.add(eqn);
                dsLookup.put(eqn, set);
                dsSets.add(set);
                ASTNode.log.debug("  Set added, %d eqns and %d vars", set.eqns.size(), set.vars.size());
            } else {
                ASTNode.log.debug("  Set not added, %d eqns and %d vars", set.eqns.size(), set.vars.size());
            }
        }
        
        for (IndexReductionEq eqn : getEquations()) {
            if (dsLookup.containsKey(eqn))
                continue;
            if (eqn.getMatching() == null)
                continue; // Possible?
            Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
            if (coefficients == null)
                continue; // Possible?
            if (!dynamicSetCandidate(eqn, eqn.getMatching(), coefficients))
                continue;
            for (IndexReductionVar var : eqn.getVariables()) {
                if (eqn.getMatching() == var || var.getMatching() == null)
                    continue;
                IndexReductionEq otherEqn = var.getMatching();
                coefficients = coefficientsMatrix.get(otherEqn);
                if (!dynamicSetCandidate(eqn, var, coefficients))
                    continue;
                DSSet set = dsLookup.get(otherEqn);
                if (set == null)
                    continue;
                set.eqns.add(eqn);
                set.vars.add(eqn.getMatching());
                dsLookup.put(eqn, set);
                break;
            }
        }
        
        boolean skipDynamicStates = false;
        for (DSSet set : dsSets) {
            if (dynamicStateLimit >= 0 && (set.eqns.size() > dynamicStateLimit || set.vars.size() > dynamicStateLimit)) {
                ASTNode.log.verbose("Too big dynamic state set, %d equations and %d variables!", set.eqns.size(), set.vars.size());
                ASTNode.log.verbose(set);
                skipDynamicStates = true;
            }
        }
        
        if (skipDynamicStates) {
            ASTNode.log.verbose("Resetting matchings");
            for (Map.Entry<IndexReductionVar, IndexReductionEq> entry : initialMatching.entrySet()) {
                IndexReductionVar var = entry.getKey();
                IndexReductionEq eqn = entry.getValue();
                var.setMatching(eqn);
                if (eqn != null)
                    eqn.setMatching(var);
            }
            result.markDSAsFailed();
            return Collections.emptySet();
        }
        
        Set<IndexReductionVar> vars = new HashSet<IndexReductionVar>();
        for (DSSet set : dsSets) {
            if (set.eqns.size() == set.vars.size()) {
                ASTNode.log.debug("Set %d not added, %d eqns and %d vars", set.id, set.eqns.size(), set.vars.size());
                continue;
            } else if (set.eqns.size() > set.vars.size()) {
                throw new UnsupportedOperationException("Something went wrong during dynamic state selection, dynamic state set " + set.id + " contains " + set.eqns.size() + " equations but only " + set.vars.size() + "variables! Please report this error!");
            }
            set.coefficients = new FExp[set.eqns.size()][set.vars.size()];
            int i = 0;
            for (IndexReductionEq eqn : set.eqns) {
                int j = 0;
                Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
                if (coefficients == null)
                    continue; // Yes this can happen :)
                for (IndexReductionVar var : set.vars) {
                    Coefficient coff = coefficients.get(var);
                    set.coefficients[i][j] = coff == null ? null : coefficients.get(var).exp;
                    if (set.coefficients[i][j] != null && set.coefficients[i][j].isNoExp())
                        throw new IndexReductionException("Dynamic state construction failed due to non scalar derivative for variable " + var.getName() + " when differentiating: \n" + eqn.getEquation());
                    j++;
                }
                i++;
            }
            ASTNode.log.verbose(set);
            result.addDSSet(set);
            vars.addAll(set.vars);
        }
        return vars;
    }

    public Map<IndexReductionVar, IndexReductionEq> computeTempAssignmentMap() {
        Map<IndexReductionVar, IndexReductionEq> res = new HashMap<IndexReductionVar, IndexReductionEq>();
        for (IndexReductionEq eqn : getEquations()) {
            FAbstractVariable var = eqn.getEquation().assignedFV();
            if (var == null || !var.isTemporary()) {
                continue;
            }
            IndexReductionVar bipVar = getVariable(var.name());
            if (bipVar == null) {
                continue;
            }
            res.put(bipVar, eqn);
        }
        return res;
    }

    public boolean dynamicSetCandidate(IndexReductionEq eqn, IndexReductionVar var,
            Map<IndexReductionVar, Coefficient> coefficients) {
        return var.dynamicSetCandidate(coefficients.get(var), computeIncidenceStateSelect(eqn, var));
    }

    public FVariable.StateSelect computeIncidenceStateSelect(IndexReductionEq eq, IndexReductionVar var) {
        if (var.getVariable().stateSelection() == FVariable.StateSelect.ALWAYS) {
            return FVariable.StateSelect.ALWAYS;
        }
        for (FAccessExp exp : eq.getEquation().findFAccessExpsInTree()) {
            if (getVariable(exp.name()) == var && !exp.getOriginalVariable().isEmpty()) {
                return exp.myOriginalFV().stateSelection();
            }
        }
        return var.getVariable().stateSelection();
    }

    public Object printCoefficientsObj(final Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix, final boolean printExpressions) {
        return new Object() {
            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (IndexReductionVar var : getVariables()) {
                    sb.append('\t');
                    sb.append(var);
                }
                sb.append('\n');
                for (IndexReductionEq eqn : getEquations()) {
                    sb.append(eqn);
                    Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
                    if (coefficients == null)
                        coefficients = Collections.emptyMap();
                    for (IndexReductionVar var : getVariables()) {
                        sb.append('\t');
                        Coefficient coff = coefficients.get(var);
                        if (coff == null)
                            continue;
                        if (printExpressions) {
                            sb.append(coff.exp);
                        } else {
                            switch (coff.state) {
                            case CONTINUOUS:
                                sb.append('+');
                                break;
                            case EXCEPTION:
                                sb.append('X');
                                break;
                            case SPLIT:
                                sb.append('S');
                                break;
                            default:
                                sb.append('*');
                            }
                        }
                    }
                    sb.append('\n');
                }
                return sb.toString();
            }
        };
    }

    
        
        public class SAP1 extends StandardAugmentingPath {
            private final Set<IndexReductionEq> dsEqns;
            private final Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix;
            
            public SAP1(Set<IndexReductionEq> dsEqns, Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix) {
                this.dsEqns = dsEqns;
                this.coefficientsMatrix = coefficientsMatrix;
            }

            @Override
            protected Iterable<IndexReductionVar> visitVariables(IndexReductionEq eqn) {
                if (dsEqns.contains(eqn))
                    return Collections.emptyList();
                else
                    return super.visitVariables(eqn);
            }

            @Override
            protected boolean shouldVisit(IndexReductionEq eqn, IndexReductionVar var) {
                if (!super.shouldVisit(eqn, var))
                    return false;
                if (var.numDifferentiations() < eqn.numDifferentiations()) {
                    return false;
                }
                Map<IndexReductionVar, Coefficient> coefficients =  coefficientsMatrix.get(eqn);
                if (coefficients != null) {
                    Coefficient coff = coefficients.get(var);
                    if (coff != null && coff.state == COEFFICIENT_STATE.CONTINUOUS)
                        return false;
                }
                return var.dynamicSetCandidate(computeIncidenceStateSelect(eqn, var));
            }
            @Override
            protected void match(IndexReductionEq eqn, IndexReductionVar var) {
                IndexReductionVar previous = eqn.getMatching();
                super.match(eqn, var);
                ASTNode.log.debug("      Rematch %s to %s (previous %s)", eqn, var, previous);
            }
        }

    

        public class SAP2 extends AugmentingPathAlgorithm<Collection<IndexReductionEq>> {
            private final Set<IndexReductionEq> dsEqns;
            private final Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix;
            private final Queue<IndexReductionEq> worklist;
            
            public SAP2(Set<IndexReductionEq> dsEqns, Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix, Queue<IndexReductionEq> worklist) {
                super(Collections.unmodifiableCollection(new ArrayList<IndexReductionEq>()));
                this.dsEqns = dsEqns;
                this.coefficientsMatrix = coefficientsMatrix;
                this.worklist = worklist;
            }
            
            @Override
            protected Collection<IndexReductionEq> startValue(IndexReductionEq eqn) {
                if (dsEqns.contains(eqn))
                    return Collections.singletonList(eqn);
                else
                    return Collections.emptyList();
            }

            @Override
            protected Iterable<IndexReductionVar> visitVariables(IndexReductionEq eqn) {
                if (dsEqns.contains(eqn))
                    return Collections.emptyList();
                else
                    return super.visitVariables(eqn);
            }

            @Override
            protected Collection<IndexReductionEq> mergeSubRes(Collection<IndexReductionEq> res, Collection<IndexReductionEq> subRes, IndexReductionEq eqn) {
                if (subRes.size() > 0) {
                    if (res.isEmpty())
                        res = new ArrayList<IndexReductionEq>();
                    res.addAll(subRes);
                    res.add(eqn);
                }
                return res;
            }
    
            @Override
            protected void match(IndexReductionEq eqn, IndexReductionVar var) {
                IndexReductionVar previous = eqn.getMatching();
                super.match(eqn, var);
                ASTNode.log.debug("      Rematch %s to %s (previous %s)", eqn, var, previous);
                Map<IndexReductionVar, Coefficient> coefficients = coefficientsMatrix.get(eqn);
                if (coefficients == null)
                    return;
                Coefficient coff = coefficients.get(var);
                if (coff != null && coff.state == COEFFICIENT_STATE.CONTINUOUS) {
                    ASTNode.log.debug("      Adding %s to worklist", eqn);
                    worklist.add(eqn);
                }
            }
            
            @Override
            protected boolean shouldVisit(IndexReductionEq eqn, IndexReductionVar var) {
                if (!super.shouldVisit(eqn, var)) {
                    return false;
                }
                if (var.numDifferentiations() < eqn.numDifferentiations()) {
                    return false;
                }
                return var.dynamicSetCandidate(computeIncidenceStateSelect(eqn, var));
            }
        }

    

        @Override
        protected IndexReductionEq createEq(String name, FAbstractEquation eqn, int groupNumber, Collection<IndexReductionEq> groupMembers, TypePrefixVariability variability, FType type, boolean isMeta) {
            return new IndexReductionEq(name, eqn, groupNumber, groupMembers, variability, type, isMeta);
        }

    

        @Override
        protected IndexReductionVar createVar(String name, FVariable var) {
            return new IndexReductionVar(name, var);
        }

    

        @Override
        public boolean canMatch(IndexReductionEq e, IndexReductionVar v) {
            return super.canMatch(e, v) && !e.isNonDiffUse(v) && getVariable(v.getName()) != null;
        }

    

        @Override
        protected IndexReductionSCCBlock createComponentBlock() {
            return new IndexReductionSCCBlock();
        }

    public static final int MAX_N_EQ_DIFFS = 5;

    public static final int MAX_N_FEXP_IN_EQ = 10000;

    private void differentiateVariable(IndexReductionVar var, Collection<FVariable> newDiffedVars, Collection<IndexReductionVar> varsToRemove) {
        if (var.getMeDifferentiated() != null)
            return;
        // Create a new differentiated variable
        FVariable diffedFVar = var.getVariable().createFDerivativeVariable();
        newDiffedVars.add(diffedFVar);
        // Add the differentiated variable to the graph 
        IndexReductionVar diffedVar = addVariable(diffedFVar.name(), diffedFVar);
        // a reference from the visited variable to its 
        // differentiated counterpart
        varsToRemove.add(var);
        var.setMeDifferentiated(diffedVar);
        diffedVar.setMeIntegrated(var);
    }

    private static FAbstractEquation differentiateEquation(FAbstractEquation fEqn, IndexReductionFunctionInliner inliner) {
        if (fEqn.numFExp() > MAX_N_FEXP_IN_EQ)
            throw new IndexReductionException("Maximum number of expressions in a single equation has been reached");
        
        Collection<FAbstractEquation> diffedFEqns = fEqn.diff("time");
        if (diffedFEqns.size() != 1)
            throw new UnsupportedOperationException("Differentiation of equations should result" +
                    " in a single equation when differentiating on time");
        return inliner.dynamicEquation(diffedFEqns.iterator().next());
    }

    
        private class ExtraEquationVariableResolver implements VariableResolver<IndexReductionEq, IndexReductionVar> {
            
            private final Map<String, AssignmentIncidenceMap> extraEqMap;
            private final Set<String> evaluationStack = new LinkedHashSet<String>();
            
            private ExtraEquationVariableResolver(Collection<FAbstractEquation> equations) {
                extraEqMap = new HashMap<String, AssignmentIncidenceMap>();
                for (FAbstractEquation equation : equations) {
                    AssignmentIncidenceMap incidenceMap = equation.assignmentIncidenceMap(IndexReductionBiPGraph.this, null, this);
                    for (CommonAccessExp lhs : incidenceMap.assigned()) {
                        extraEqMap.put(lhs.name(), incidenceMap);
                    }
                }
            }
            
            @Override
            public Set<IndexReductionVar> lookupVars(Iterable<FAccessExp> set) {
                Set<IndexReductionVar> res = new LinkedHashSet<IndexReductionVar>();
                lookupVars(set, res);
                return res;
            }
    
            private void lookupVars(Iterable<FAccessExp> set, Set<IndexReductionVar> resolvedVars) {
                for (FAccessExp use : set) {
                    String varName = use.name();
                    IndexReductionVar var = getVariable(varName);
                    if (var != null) {
                        resolvedVars.add(var);
                    } else {
                        AssignmentIncidenceMap incidenceMap = extraEqMap.get(varName);
                        if (incidenceMap != null) {
                            if (!evaluationStack.add(varName)) {
                                throw new UnsupportedOperationException("Oh boy, we have a circularity in our evaluation of extra equations during index reduction, this is not supported. Stack: " + evaluationStack);
                            }
                            try {
                                lookupVars(incidenceMap.rhs(varName), resolvedVars);
                            } finally {
                                evaluationStack.remove(varName);
                            }
                        }
                    }
                }
            }
        }

    private void differentiateEquation(IndexReductionEq baseEqn,
            Collection<FVariable> newDiffedVars,Collection<IndexReductionVar> varsToRemove,
            IndexReductionResult result, Stack<IndexReductionEq> eqToMatchStack,
            IndexReductionFunctionInliner inliner, Map<String, FVariable> temporaryVarsMap) {
        if (baseEqn.getMeDifferentiated() != null)
            return;
        
        getStepLogger().logVerbose("Differentiating %s", baseEqn);
        
        // Go through all group members and collect all unique AST equations.
        // There might be several equations the second time an inlined
        // equation is differentiated.
        Set<FAbstractEquation> originalFEqns = new LinkedHashSet<FAbstractEquation>();
        for (IndexReductionEq eqn : baseEqn.getGroupMembers())
            originalFEqns.add(eqn.getEquation());
        
        if (baseEqn.numDifferentiations() > MAX_N_EQ_DIFFS)
            throw new IndexReductionException("Maximum number of differentiations has been reached");
        
        // Handle nonscalar equations and LHS variables that needs to be differentiated
        for (IndexReductionEq eqn : baseEqn.getGroupMembers()) {
            for (IndexReductionVar var : eqn.getVariables()) {
                if (!eqn.isNonDiffUse(var)) {
                    if (var.getMatching() != null && var.getMatching() != eqn)
                        eqToMatchStack.add(var.getMatching());
                    differentiateVariable(var, newDiffedVars, varsToRemove);
                }
            }
        }
        
        // Differentiate equations
        java.util.List<FAbstractEquation> diffedFEqns = new ArrayList<FAbstractEquation>();
        Set<FAbstractEquation> originalDiffedFEqns = new LinkedHashSet<FAbstractEquation>();
        for (FAbstractEquation originalFEqn : originalFEqns) {
            FAbstractEquation originalDiffedFEqn = differentiateEquation(originalFEqn, inliner);
            originalDiffedFEqns.add(originalDiffedFEqn);
            diffedFEqns.add(originalDiffedFEqn);
        }
        Collection<FAbstractEquation> extraEquations = new ArrayList<FAbstractEquation>();
        for (FAbstractEquation fEqn : baseEqn.getExtraEquations()) {
            getStepLogger().logVerbose("  Extra equation: %s", fEqn);
            extraEquations.add(fEqn);
            if (baseEqn.diffExtraEqn(fEqn)) {
                FAbstractEquation diffedFEqn = differentiateEquation(fEqn, inliner);
                getStepLogger().logVerbose("    Diffed into: %s", diffedFEqn);
                if (diffedFEqn.isContinuous()) {
                    diffedFEqns.add(diffedFEqn);
                } else {
                    getStepLogger().logVerbose("    Diffed not added!");
                }
            } else {
                getStepLogger().logVerbose("    Not diffed!");
            }
        }
        
        // Handle inlining of function calls
        Collection<FAbstractEquation> newExtraEquations = new ArrayList<FAbstractEquation>();
        Stack<FAbstractEquation> inlineStack = new Stack<FAbstractEquation>();
        for (FAbstractEquation fEqn : diffedFEqns) {
            if (fEqn.hasInlinableFunctions(inliner))
                inlineStack.push(fEqn);
            else if (!originalDiffedFEqns.contains(fEqn))
                newExtraEquations.add(fEqn);
            for (FAccessExp use : fEqn.findFAccessExpsInTree()) {
                String baseName = use.getAccess().name();
                FVariable topTempDerivative = temporaryVarsMap.get(baseName);
                if (topTempDerivative == null)
                    continue;
                if (topTempDerivative.order() >= use.order())
                    continue;
                for (int i = topTempDerivative.order(); i <= use.order(); i++) {
                    topTempDerivative = topTempDerivative.createFDerivativeVariable();
                    newDiffedVars.add(topTempDerivative);
                    result.addDummyDerivative(topTempDerivative);
                }
                temporaryVarsMap.put(baseName, topTempDerivative);
            }
        }
        
        if (inlineStack.size() > 0) {
            
            ASTNode.log.debug("Differentiated equation has inlinable functions");
            while (!inlineStack.isEmpty()) {
                inliner.reset();
                FAbstractEquation fEqn = inlineStack.pop();
                ASTNode.log.debug("  Performing function inlining on %s", fEqn);
                Collection<FAbstractEquation> inlinedFEqns = fEqn.inlineFunctions(inliner);
                
                for (FAbstractEquation spawnedFExp : inliner.getNewEquations()) {
                    ASTNode.log.debug("Additional equation introduced, %s", spawnedFExp);
                    if (spawnedFExp.hasInlinableFunctions(inliner))
                        inlineStack.add(spawnedFExp);
                    else
                        newExtraEquations.add(spawnedFExp);
                }
                
                for (FVariable var : inliner.getNewVariables()) {
                    newDiffedVars.add(var);
                    temporaryVarsMap.put(var.name(), var);
                }
                
                if (inlinedFEqns == null) {
                    if (originalDiffedFEqns.contains(fEqn)) {
                        ASTNode.log.debug("Inlining done, original equation has been split into multiple equations");
                        originalDiffedFEqns.remove(fEqn); // Remove the original equation if it has been split
                        originalDiffedFEqns.addAll(inliner.getLastSplitFFCE());
                        newExtraEquations.removeAll(inliner.getLastSplitFFCE());
                    } else {
                        ASTNode.log.debug("Inlining done, equation has been split into multiple equations");
                    }
                    
                } else {
                    for (FAbstractEquation inlinedFEqn : inlinedFEqns) {
                        ASTNode.log.debug("Equation inlined, got %s", inlinedFEqn);
                        if (inlinedFEqn.hasInlinableFunctions(inliner)) {
                            inlineStack.add(inlinedFEqn);
                        } else if (!originalDiffedFEqns.contains(inlinedFEqn)) {
                            newExtraEquations.add(inlinedFEqn);
                        }
                    }
                }
            }
        }
        
        for (FAbstractEquation extraFEqn : newExtraEquations) {
            result.addEquation(extraFEqn);
            extraEquations.add(extraFEqn);
        }
        
        // Construct a list of all the variables that should be common in all
        // of the equations.
        // Always add variables from extra equations
        ExtraEquationVariableResolver extraResolver = new ExtraEquationVariableResolver(extraEquations);
        
        // Check so that the differentiated equation has the same number of
        // members as the original.
        int numScalarsInDiffed = 0;
        for (FAbstractEquation newEqn : originalDiffedFEqns)
            numScalarsInDiffed += newEqn.numScalarEquations();
        if (baseEqn.getGroupMembers().size() != numScalarsInDiffed)
            throw new IndexReductionException("Number of scalar equations in differentiated equation(" + numScalarsInDiffed + ") does not match the number in original equation(" + baseEqn.getGroupMembers().size() + "). Original equation:\n" + baseEqn.getEquation());
        
        Collection<IndexReductionEq> diffedOriginalEqs = new ArrayList<IndexReductionEq>();
        // Go through differentiated equations that corresponds to the original
        // equations. Add all of these equations to the BiPGraph. We need to
        // remember equations that are differentiated from the "orignal"
        // equation so that we can add links later. Also add links between
        // differentiated equation and the original equation.
        Iterator<IndexReductionEq> eqnIt = baseEqn.getGroupMembers().iterator();
        for (FAbstractEquation newEqn : originalDiffedFEqns) {
            result.addEquation(newEqn);
            
            IncidenceMap incMap = newEqn.createIncidenceMap(this, null, extraResolver);
            
            // Build new differentiated BiP equations for each scalar.
            for (int i = 0; i < newEqn.numScalarEquations(); i++) {
                IndexReductionEq original = eqnIt.next();
                getStepLogger().logVerbose("About to add equation: %s", newEqn);
                // Add the differentiated equation
                IndexReductionEq diffedEqn = addEquation(newEqn, i, diffedOriginalEqs, incMap.variability(i), incMap.type(i), original.getName() + "_d");
                
                incMap.addEdges(diffedEqn, true);
                
                diffedOriginalEqs.add(diffedEqn);
                diffedEqn.setExtraEquations(extraEquations);
                
                // Set a reference from the visited equation to
                // its differentiated counterpart
                original.setMeDifferentiated(diffedEqn);
                diffedEqn.setMeIntegrated(original);
                
                getStepLogger().logVerbose("Added equation: %s, %s", diffedEqn, diffedEqn.printEquation());
                
                if (original.getMatching() != null && !match(diffedEqn, original.getMatching().getMeDifferentiated()))
                    eqToMatchStack.add(diffedEqn);
            }
            getStepLogger().logVerbose("Equation added");
        }
        
    }

    public Set<FVariable> removablePreferDerivatives(Set<FVariable> preferVars) {
        Set<FVariable> removableVars = new HashSet<FVariable>();
        for (FVariable preferVar : preferVars) {
            FVariable fDerVar = preferVar.getMeDifferentiated();
            if (fDerVar == null)
                continue;
            AbstractVar derVar = getVariable(fDerVar.name());
            if (derVar != null && derVar.getMatching() == null)
                removableVars.add(derVar.getVariable());
        }
        return removableVars;
    }

    public IndexReductionResult reduceIndex(IndexReductionFunctionInliner inliner,
            int dynamicStateLimit, int maximumNbrOfMunkresIncidences, boolean printPantelidesSteps) {
        IndexReductionResult result = new IndexReductionResult();
        FClass fclass = null;
        Stack<IndexReductionEq> eqToMatchStack = new Stack<IndexReductionEq>();
        for (IndexReductionEq e : getEquations()) {
            if (e.getEquation().isContinuous()) {
                eqToMatchStack.push(e);
                fclass = e.getEquation().myFClass();
            }
        }
        Collections.reverse(eqToMatchStack);
        
        // If there are no equations, we cannot do index reduction.
        if (eqToMatchStack.isEmpty())
            throw new IndexReductionException("No continuous equations was given");
        
        java.util.List<FVariable> newDiffedVars = new ArrayList<FVariable>();
        // This map is used to ensure that all temporary variables that are
        // introduced during inlining can be marked as dummy derivatives
        Map<String, FVariable> temporaryVarsMap = new HashMap<String, FVariable>();
        
        // Algoritm step numbering from the original Pantelides paper
        // Loop over all equations (step 3)
        while (!eqToMatchStack.empty() ){
            IndexReductionEq eqToMatch = eqToMatchStack.pop(); // Step 3a
            
            // Ensure that we have the top differentiated equation, it might
            // have been differentiated since it was put on the stack.
            while (eqToMatch.getMeDifferentiated() != null)
                eqToMatch = eqToMatch.getMeDifferentiated();
            
            // Ignore, if it is already been matched.
            // TODO: Can this happen?
            if (eqToMatch.getMatching() != null)
                continue;
            
            // If the equation is not matched
            
            // Since the states are not added to the graph,
            // Step 3b-1 is skipped and is done at the end of 
            // the iteration 
            lightReset(); // Step 3b-2
            // Find an augmenting path, step 3b-4
            //n_ind = 0;
            boolean pathFound = augmentPath(eqToMatch);
            Collection<IndexReductionEq> visitedEquations = getVisitedEquations();
            Collection<IndexReductionVar> visitedVariables = getVisitedVariables();
            getStepLogger().logVerbose("*************");
            getStepLogger().logVerbose("Looking for augmented path starting in equation: %s", eqToMatch);
            if (pathFound)
                getStepLogger().logVerbose("Path found!");
            else
                getStepLogger().logVerbose("Path not found!");
            
            getStepLogger().logVerbose("Visisted equations:");
            for (IndexReductionEq ee : visitedEquations)
                getStepLogger().logVerbose("  %s", ee.printEquation());
            
            getStepLogger().logVerbose("Visisted variables:");
            for (IndexReductionVar vv : visitedVariables)
                getStepLogger().logVerbose("  %s", vv);
            
            if (!pathFound) { // Step 3b-5
                Collection<IndexReductionVar> varsToRemove = new ArrayList<IndexReductionVar>();
                for (IndexReductionVar var : visitedVariables) { // Loop over all visited variables, Step 3b-5i
                    // Differentiate variable
                    differentiateVariable(var, newDiffedVars, varsToRemove);
                }
                for (IndexReductionEq eqn : visitedEquations) { // Step 3b-5ii
                    // Differentiate equation
                    differentiateEquation(eqn, newDiffedVars, varsToRemove, result, eqToMatchStack, inliner, temporaryVarsMap);
                }
                // Remove variables that have been differentiated, Step 3b-1
                for (IndexReductionVar var : varsToRemove) {
                    // Copy matching to differentiated var
                    if (var.getMatching() != null && var.getMatching().getMeDifferentiated() != null
                            && !match(var.getMatching().getMeDifferentiated(), var.getMeDifferentiated()))
                        // Or if that fails, add it to the list of equations to visit.
                        eqToMatchStack.add(var.getMatching().getMeDifferentiated());
                    // Remove var
                    removeVariable(var);
                }
                // Set the next equation to start matching from, 
                // Step 3b-5iv
                // Push the matched equation to the stack of equations to be matched
                eqToMatchStack.push(eqToMatch);
                if (printPantelidesSteps) {
                    getStepLogger().logVerbose("Graph after addition of equations and variables:");
                    getStepLogger().logVerbose(this);
                }
            }
            if (printPantelidesSteps) {
                getStepLogger().logVerbose("Matching:");
                getStepLogger().logVerbose(printMatchingObj());
                getStepLogger().logVerbose("*************");
            }
        }
        fclass.addFDerivativeVariables(newDiffedVars);
        for (FAbstractEquation eqn : result.getEquations())
            eqn.flushAllRecursive();

        // Remove equations that are not connected
        java.util.List<IndexReductionEq> eqToRemove = new ArrayList<IndexReductionEq>();
        for (IndexReductionEq e : getEquations())
            if (e.getMeDifferentiated() != null)
                eqToRemove.add(e);
        for (IndexReductionEq e : eqToRemove)
            removeEquation(e);
        
        getStepLogger().logVerbose("Index reduction done!");
        getStepLogger().logVerbose(this);
        getStepLogger().logVerbose("Matching:");
        getStepLogger().logVerbose(printMatchingObj());
        
        if (getUnmatchedEquations().size() > 0 || getUnmatchedVariables().size() > 0)
            throw new IndexReductionException("There were unmatched equations and/or variables left after index reduction.");
        
        if (result.getEquations().isEmpty()) {
            getStepLogger().logVerbose("Index reduction did not change the system. Munkres is skipped.");
            return result;
        }
        // Selection of dummy derivatives
        /*
            The algorithm is implemented differently than in the original paper
            by Mattsson and S\ufffdderlind. In the paper, each block is treated
            individually by selecting all dummy derivatives of one block
            before proceeding to the next block. This approach, however, makes
            it hard to handle user preferences for state selection as defined
            by the stateSelect attribute. This is because selection of
            dummy derivatives in one block may restrict the choices in 
            following blocks, even though a global analysis would yield that
            it would indeed be possible to satisfy user selection.
            
            Therefore, all equations in blocks containing differentiated
            equations are treated in one block.
            
            NOTE: This algorithm has been changed from time to time and has now
            diverged from the original one that was presented in the paper.
        */
        
        Collection<IndexReductionSCCBlock> components = tarjan(fclass.myStepUtil(), true);
    
        Set<IndexReductionVar> varsToKeep = new HashSet<IndexReductionVar>();
        // Remove all equations and variables that doesn't exist in blocks that
        // contains differentiated equations or variables.
        for (IndexReductionSCCBlock block : components) {
            if (block.containsDifferentatedComponents()) {
                getStepLogger().logVerbose(" ********* Found block containing diffed equations ***********");
                getStepLogger().logVerbose(block);
                for (IndexReductionEq eqn : block.getMembers())
                    for (IndexReductionVar var : eqn.getVariables())
                        if (var.numDifferentiations() > 0)
                            varsToKeep.add(var);
            } else {
                for (IndexReductionEq eqn : block.getMembers())
                    removeEquation(eqn);
            }
        }
        
        for (IndexReductionVar var : new ArrayList<IndexReductionVar>(getVariables()))
            if (!varsToKeep.contains(var))
                removeVariable(var);
        
        // Lists of equations and variables, notation is the same as in the 
        // paper, only zHat is needed, g, h and z is handled by the BiPGraph.

        java.util.List<FVariable> zHat = new ArrayList<FVariable>();

        lookForHigherOrderVars();

        // Initialize variable to keep track of there are still 
        // differentiated equations
        boolean remainingDifferentiatedEquations = true;
        
        // Iterate
        while (remainingDifferentiatedEquations) {
            getStepLogger().logVerbose("----------------");
            // Step 3: Remove equations that aren't differentiated.
            for (IndexReductionEq eqn : new ArrayList<IndexReductionEq>(getEquations()))
                if (eqn.getMeIntegrated() == null)
                    removeEquation(eqn);
            
            // Step 4: Select independent columns.
            getStepLogger().logVerbose(this);
            
            // Compute weights for variables based on state select, linearity
            // and other attributes.
            Map<IndexReductionVar, IndexReductionCost> weights = new HashMap<IndexReductionVar, IndexReductionCost>();
            Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix = new HashMap<IndexReductionEq, Map<IndexReductionVar, Coefficient>>();
            for (IndexReductionVar var : getVariables()) {
                FVariable fv = var.getVariable();
                int linearity = calculateLinearityWeight(var, coefficientsMatrix);
                if (var.getMeIntegrated() != null)
                    linearity += calculateLinearityWeight(var.getMeIntegrated(), coefficientsMatrix);
                boolean fixed = fv.getTopIntegrated().isFixed();
                IndexReductionCost weight = new IndexReductionCost(fv.stateSelection(), fixed, fv.order(), linearity);
                getStepLogger().logVerbose("Weight: %s %s", var, weight);
                weights.put(var, weight);
            }
            
            // Run matching
            try {
                ASTNode.beginStep("Munkres");
                int numIncidences = countNumberOfIncidences();
                if (maximumNbrOfMunkresIncidences > 0 && numIncidences > maximumNbrOfMunkresIncidences) {
                    throw new IndexReductionException("The dummy derivative problem is too big, there is " + numIncidences +
                            " incidences in the graph, limit is set to " + maximumNbrOfMunkresIncidences +
                            ". The limit can be changed by setting the option 'munkres_max_incidences'");
                }
                matchMunkres(weights);
            } finally {
                ASTNode.endStep("Munkres");
            }
            getStepLogger().logVerbose(printMatchingObj());
            Set<IndexReductionVar> dsVars = Collections.emptySet();
            if (dynamicStateLimit != 0) {
                dsVars = computeDynamicStateSets(dynamicStateLimit, coefficientsMatrix, result);
            }
            getStepLogger().logVerbose(printMatchingObj());
            
            // Step 5: prepare for next iteration
            // Mark all variables for removal. Add the integrated variable for
            // each matched variable to the graph and add the matched variable
            // to zHat.
            Collection<IndexReductionVar> varsToRemove = new ArrayList<IndexReductionVar>();
            getStepLogger().logVerbose(" Dummy derivatives selected in iteration: ");
            for (IndexReductionVar var : new ArrayList<IndexReductionVar>(getVariables())) {
                varsToRemove.add(var);
                if (var.getMatching() != null) {
                    if (!dsVars.contains(var)) {
                        getStepLogger().logVerbose("   %s", var);
                        zHat.add(var.getVariable());
                    }
                    insert(getOrCreateIntegrated(var));
                }
            }
            getStepLogger().logVerbose("");
            
            // Add the "integrated" equation for all equations in the graph and
            // remove the differentiated equation.
            for (IndexReductionEq eqn : new ArrayList<IndexReductionEq>(getEquations())) {
                IndexReductionEq inEqn = eqn.getMeIntegrated();
                insert(inEqn);
                for (IndexReductionVar var : eqn.getVariables()) {
                    if (var.getMeIntegrated() != null)
                        inEqn.addVariable(var.getMeIntegrated(), eqn.isRemoteVar(var));
                }
                removeEquation(eqn);
            }
            
            // Remove all variables that was marked for removal earlier.
            for (IndexReductionVar var : varsToRemove)
                removeVariable(var);
            
            // Check if there are remaining differentiated equations
            remainingDifferentiatedEquations = false;
            for (IndexReductionEq eqn : getEquations())
                if (eqn.getMeIntegrated()!=null)
                    remainingDifferentiatedEquations = true;
        }
        
        getStepLogger().logVerbose(" Dummy derivatives: ");
        for (FVariable var : zHat) {
            result.addDummyDerivative(var);
            getStepLogger().logVerbose("   %s", var);
        }
        getStepLogger().logVerbose("");
        
        return result;
    }

    
        public static class Coefficient {
            public final FExp exp;
            public final COEFFICIENT_STATE state;
            
            public Coefficient(FExp exp, COEFFICIENT_STATE state) {
                this.exp = exp;
                this.state = state;
            }
        }

    
        
        public enum COEFFICIENT_STATE{
            CONSTANT, CONTINUOUS, EXCEPTION, SPLIT;
            public static COEFFICIENT_STATE create(TypePrefixVariability variability) {
                if (variability == null)
                    return EXCEPTION;
                if (variability.lessOrEqual(Variability.FIXEDPARAMETER))
                    return CONSTANT;
                return CONTINUOUS;
            }
        }

    public int calculateLinearityWeight(IndexReductionVar var, Map<IndexReductionEq, Map<IndexReductionVar, Coefficient>> coefficientsMatrix) {
        int weight = 0;
        for (IndexReductionEq eqn : getEquations())
            weight += eqn.calculateLinearityWeight(var, coefficientsMatrix);
        return weight;
    }

    public void insert(IndexReductionEq eqn) {
        equationMap.put(eqn.getName(), eqn);
        insertIntoEquationIndexMap(eqn.getEquation(), eqn);
    }

    public void insert(IndexReductionVar var) {
        variableMap.put(var.getName(), var);
    }

    public IndexReductionVar getOrCreateIntegrated(IndexReductionVar var) {
        IndexReductionVar inVar = var.getMeIntegrated();
        if (inVar != null)
            return inVar;
        
        FVariable inFVar = var.getVariable().getMeIntegrated();
        if (inFVar == null)
            throw new UnsupportedOperationException(var + " does not have any integrated variable!");
        
        return addVariable(inFVar.name(), inFVar);
        
    }

    
        
        public static class IndexReductionCost implements MunkresCost<IndexReductionCost> {
            
            private static final int NUM_WEIGHTS = 8;
            public static final int STATE_SELECT_ALWAYS_WEIGHT_POSITION  = 0;
            public static final int STATE_SELECT_PREFER_WEIGHT_POSITION  = 1;
            public static final int STATE_SELECT_DEFAULT_WEIGHT_POSITION = 2;
            public static final int STATE_SELECT_AVOID_WEIGHT_POSITION   = 3;
            public static final int STATE_SELECT_NEVER_WEIGHT_POSITION   = 4;
            private static final int FIXED_WEIGHT_POSITION               = 5;
            private static final int ORDER_WEIGHT_POSITION               = 6;
            private static final int LINEARITY_WEIGHT_POSITION           = 7;
            
            private int[] weights = new int[NUM_WEIGHTS];
            
            private IndexReductionCost() {
            }
            
            public IndexReductionCost(FAbstractVariable.StateSelect stateSelect, boolean fixed, int order, int linearity) {
                if (order < 2) {
                    weights[stateSelect.weightPos()] += 1;
                }
                weights[FIXED_WEIGHT_POSITION] += fixed ? 1 : 0;
                weights[ORDER_WEIGHT_POSITION] += -order;
                weights[LINEARITY_WEIGHT_POSITION] += linearity;
            }
            
            @Override
            public int compareTo(IndexReductionCost other) {
                for (int i = 0; i < weights.length; i++) {
                    int diff = new Integer(weights[i]).compareTo(other.weights[i]);
                    if (diff != 0)
                        return diff;
                }
                return 0;
            }
            
            @Override
            public void subtract(IndexReductionCost other) {
                for (int i = 0; i < weights.length; i++)
                    weights[i] -= other.weights[i];
            }
            
            @Override
            public void add(IndexReductionCost other) {
                for (int i = 0; i < weights.length; i++)
                    weights[i] += other.weights[i];
            }
            
            @Override
            public boolean isZero() {
                for (int i = 0; i < weights.length; i++)
                    if (weights[i] != 0)
                        return false;
                return true;
            }
            
            @Override
            public IndexReductionCost copy() {
                IndexReductionCost copy = new IndexReductionCost();
                for (int i = 0; i < weights.length; i++)
                    copy.weights[i] = weights[i];
                return copy;
            }
            
            public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("(");
                for (int i = 0; i < weights.length; i++) {
                    if (i > 0)
                        sb.append(", ");
                    sb.append(weights[i]);
                }
                sb.append(")");
                return sb.toString();
            }
            
            public static IndexReductionCost zeroCost() {
                return new IndexReductionCost();
            }
        }

    public int[][] matchMunkres(Map<IndexReductionVar, IndexReductionCost> weights, IndexReductionCost cost[][], boolean useRemote) {
        int i = 0;
        
        for (IndexReductionEq eqn : getEquations()) {
            int j = 0;
            for (IndexReductionVar var : variableMap.values()) {
                IndexReductionCost incideceCost;
                if (eqn.getVariables().contains(var) && canMatch(eqn, var) && var.numDifferentiations() >= eqn.numDifferentiations() && (!eqn.isRemoteVar(var) || useRemote)) {
                    incideceCost = weights.get(var);
                } else {
                    incideceCost = null;
                }
                cost[i][j++] = incideceCost;
            }
            i++;
        }
        
        MunkresProblem<IndexReductionCost> munk = new SparseMunkresProblem<IndexReductionCost>(cost);
        return munk.solve();
    }

    public void matchMunkres(Map<IndexReductionVar, IndexReductionCost> weights) {

        if (equationMap.size()==0 || variableMap.size()==0) {
            throw new IndexReductionException("Empty set of equations or variables was given to the dummy derivative algorithm");
        }

        IndexReductionCost cost[][] = new IndexReductionCost[equationMap.size()][variableMap.size()];
        int[][] result;
        java.util.List<IndexReductionEq> eqs = new ArrayList<IndexReductionEq>(equationMap.values());
        java.util.List<IndexReductionVar> vars = new ArrayList<IndexReductionVar>(variableMap.values());
        try {
            result = matchMunkres(weights, cost, true);
        } catch (MunkresException e) {
            throw new IndexReductionException("Munkres algorithm was unable to find a matching; " + e.getMessage());
        }

        IndexReductionCost opt_cost = IndexReductionCost.zeroCost();
        getStepLogger().logVerbose("Munkres result:");
        for (int i = 0; i < result.length; i++) {
            opt_cost.add(cost[result[i][0]][result[i][1]]);
            IndexReductionEq eqn = eqs.get(result[i][0]);
            IndexReductionVar var = vars.get(result[i][1]);
            if (!match(eqn, var))
                throw new IndexReductionException("Munkres matched to unmatchable incidence, unable to match " + eqn + " with " + var);
            getStepLogger().logVerbose("%s: %s %s", eqn, var, cost[result[i][0]][result[i][1]]);
        }
        getStepLogger().logVerbose("Optimal cost: %s", opt_cost);
    }

    public void lookForHigherOrderVars() {
        Map<IndexReductionVar, Collection<IndexReductionEq>> varToEqMap = computeVariableToEquationMap();
        Map<IndexReductionVar, Collection<IndexReductionVar>> visitedCache = new HashMap<IndexReductionVar, Collection<IndexReductionVar>>();

        for (IndexReductionEq eqn : getEquations()) {
            eqn.lookForHigherOrderVars(varToEqMap, visitedCache);
        }

        
    }


}
