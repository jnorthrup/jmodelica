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
 * @aspect FunctionInlining
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:152
 */
public abstract class AbstractFunctionInliner extends java.lang.Object {
    

        private FFunctionDecl func;

    
        private Map<String,FExp> replMap;

    
        private FlatVariableMap lookupMap;

    
        private Map<String,FType> typeMap;

    
        public TypePrefixVariability contextVariability = Variability.CONTINUOUS;

    
        
        private Scalarizer scalarizer = new Scalarizer.Algorithm(null, null, null, false, Variability.CONTINUOUS);

    
        
        /**
         * Inline all function calls that we can from a specific list of equations.
         */
        public Collection<FAbstractEquation> inline(List<FAbstractEquation> oldEquationList) {
            Collection<FAbstractEquation> newEquationList = new ArrayList<>();
            inline(oldEquationList, newEquationList);
            return newEquationList;
        }

    

        /**
         * Inline all function calls that we can from a specific list of equations.
         */
        public abstract void inline(List<FAbstractEquation> oldEquationList, Collection<FAbstractEquation> newEquationList);

    
        
        public void setContextVariability(TypePrefixVariability v) {
            contextVariability = v;
        }

    
        
        public TypePrefixVariability contextVariability(FExp e) {
            TypePrefixVariability res = e.variability();
            if (!res.knownParameterOrLess()) {
                res = contextVariability;
                if (res.continuousVariability() && e.variability().discreteVariability()) {
                    res = e.variability();
                }
            }
            return res;
        }

    

        /**
         * Check if a given function should be inlined under the current inlining level.
         */
        public abstract boolean isInlinable(FFunctionDecl func, FFunctionCall call);

    

        /**
         * Prepare for inlining a new function call.
         * 
         * @return  the map to use for lookups in the function during inlining.
         */
        public FlatVariableMap startFunction(FFunctionDecl f) {
            replMap = new HashMap<String,FExp>();
            lookupMap = new FlatVariableMap();
            typeMap = new HashMap<String,FType>();
            return lookupMap;
        }

    

        public void setTypeOf(String name, FType type) {
            typeMap.put(name, type);
        }

    

        /**
         * Get the expression to use for a specific variable of the function 
         * currently being inlined.
         * 
         * @param name  the name of the variable
         */
        public FExp getReplacementExp(String name) {
            return replMap.get(name);
        }

    

        /**
         * Set the expression to use for a specific variable of the function 
         * currently being inlined.
         * 
         * @param name  the name of the variable
         * @param exp   the expression to use
         */
        public void setReplacementExp(String name, FExp exp) {
            replMap.put(name, exp);
        }

    

        /**
         * Check if this function inliner has created a temporary variable of the specified name.
         * 
         * @param name  the name of the temporary variable
         */
        public boolean isReplacementVar(String name) {
            return lookupMap.lookup(name) != null;
        }

    

        /**
         * Find the size of a specific variable of the function currently being inlined.
         * 
         * @param name  the name of the variable
         */
        public FType lookupType(String name) {
            return typeMap.get(name);
        }

    

        /**
         * Add a variable and (if not constant) an equation for an assignment.
         * 
         * @param oldName  the name of the variable that was assigned in the function
         * @param value    the right-hand side of the equation
         * @param noEvent  if true, make sure no events are generated for the equation
         */
        public void addVarAndEqn(String oldName, FExp value, boolean noEvent) {
            addVarAndEqn(oldName, value, noEvent, value.type(), contextVariability(value));
        }

    
        
        public void addVarAndEqn(String oldName, FExp value, boolean noEvent, FType type,
                TypePrefixVariability variability) {
            if (type.isNoType()) {
                replMap.put(oldName, value);
                return;
            }
            FVariable var = addVar(oldName, variability, type);
            if (variability.knownParameterOrLess()) {
                try {
                    CValue cval = value.ceval();
                    if (cval.hasBuildLiteral()) {
                        value = cval.buildLiteral();
                        var.setBindingExp(value);
                        replMap.put(oldName, value);
                        return;
                    }
                } catch (ConstantEvaluationException e) {}
            }
            if (noEvent)
                value = value.preventEvents();
            value.resetOriginalReferences();
            FEquation eqn = new FEquation(var.createAccessExp(), value);
            addEquation(eqn);
        }

    

        /**
         * Add variables and (if not constant) an equation for a function call statement.
         * 
         * @param lefts  the lefts of the function call statement
         * @param call   the new function call
         */
        public void addVarsAndFCEqn(List<FFunctionCallLeft> lefts, FAbstractFunctionCall call) {
            int nLefts = lefts.getNumChild();
            TypePrefixVariability variability = (nLefts == 0) ? Variability.CONTINUOUS : contextVariability(call);
            FExp[] exps = null;
            if (variability.constantVariability()) {
                try {
                    CValue[] values = call.evaluate(ASTNode.defaultVariableEvaluator());
                    exps = new FExp[values.length];
                    for (int i = 0; exps != null && i < values.length; i++) {
                        if (values[i].hasBuildLiteral()) {
                            exps[i] = values[i].buildLiteral();
                        } else {
                            exps = null;
                        }
                    }
                } catch (ConstantEvaluationException e) {
                    exps = null;
                }
            }

            if (exps == null)
                exps = new FExp[nLefts];
            FExp[] lExps = new FExp[nLefts];
            for (int i = 0; i < nLefts; i++) 
                lExps[i] = lefts.getChild(i).createInlineVars(this, exps[i], variability);

            if (!variability.constantVariability()) {
                call = (FAbstractFunctionCall) call.preventEvents();
                FFunctionCallEquation eqn = 
                    new FFunctionCallEquation(EquationType.NORMAL, new List(), call);
                for (FExp exp : lExps) {
                    FFunctionCallLeft left = new FFunctionCallLeft();
                    if (exp != null)
                        left.setFExp(exp);
                    eqn.addLeft(left);
                }
                addEquation(eqn);
            }
        }

    
        
        protected abstract void addEquation(FAbstractEquation eqn);

    
        
        protected abstract String nextTempVarName();

    
        
        protected abstract void addVar(FVariable var);

    
        
        protected FVariable addVar(String oldName, TypePrefixVariability variability, FType type) {
            String n = nextTempVarName();
            FAccess name = type.isArray() ? 
                    new FAccessFull(n, type.size().createFArraySubscripts()) : 
                    new FAccessString(n);
            FVariable var = addVar(name, variability, type);
            setTypeOf(oldName, type);
            replMap.put(oldName, var.createAccessExp());
            return var;
        }

    
        
        protected FVariable addVar(FAccess name, TypePrefixVariability variability, FType type) {
            FVariable var = type.createTempFVariable(name, variability);
            lookupMap.addVariable(var);
            addVar(var);
            return var;
        }

    
        
        protected Collection<FAbstractEquation> handleInlinedFunctionCallEquation(FFunctionCallEquation original, Collection<FAbstractEquation> result) {
            return result;
        }

    

        public Scalarizer scalarizer() {
            return scalarizer;
        }


}
