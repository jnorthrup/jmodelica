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
 * @aspect Scalarization
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:26
 */
public abstract class Scalarizer extends java.lang.Object {
    
        
        private List vars;

    
        private List clauses;

    
        private ForNames forNames;

    
        private TypePrefixVariability variability;

    
        
        public Scalarizer(List vars, List clauses, ForNames forNames, TypePrefixVariability variability) {
            this.vars = vars;
            this.clauses = clauses;
            this.forNames = forNames;
            this.variability = variability;
        }

    
        
        public void add(ASTNode clause) {
            clauses.add(clause);
        }

    
        
        public abstract void add(List<FFunctionCallLeft> lefts, FAbstractFunctionCall call);

    
        
        public void add(FAbstractVariable fv) {
            vars.add(fv);
        }

    
        
        public List getVars() {
            return vars;
        }

    
        
        public List getClauses() {
            return clauses;
        }

    
        
        public ForNames getNames() {
            return forNames;
        }

    
        
        public void createForLoops(List<FStatement> inner, FExp exp) {
            forNames.createForLoops(this, clauses, inner, exp);
        }

    
        
        public void createForLoops(FAssignableExp left, FExp right, FExp exp) {
            List<FStatement> l = new List<FStatement>();
            l.add(new FAssignStmt(left, right));
            createForLoops(l, exp);
        }

    
        
        public FExp scalarizeAccessExp(FAccessExp accessExp) {
            FExp res = accessExp.myFV().scalarizeIterIndex(this);
            if (res == null) {
                res = accessExp.createNode(accessExp.getFAccess().scalarize(this, accessExp.indexNames));
            }
            return accessExp.setLocationOf(res);
        }

    
        
        public abstract void add(FExp left, FExp right);

    
        
        public void add(List v) {
            vars.addAll(v);
        }

    
        
        public void addTempVar(FType type, String name, boolean addVar) {
            if (addVar) {
                type.createTempFVariables(getVars(), new FAccessString(name), variability);
            }
        }

    
        
        public void addTempVar(FExp source) {
            addTempVar(source.type(), source.tempVarName(), !source.useTempVar);
        }

    
        
        public abstract<T extends Scalarizer> T block(List clauses);

    
        public abstract<T extends Scalarizer> T block(List vars, List clauses);

    
        
        public TypePrefixVariability getVariability() {
            return variability;
        }

    
        
        public boolean inFunction() {
            return false;
        }

    
        
        public static class Variable {
            
            public List vars;
            public Scalarizer.Equation si;
            public Scalarizer.Equation sp;
            public Scalarizer.Equation sc;
            
            public Variable(List vars) {
                this.vars = vars;
                si = new Scalarizer.Equation(vars, new List<FAbstractEquation>(), Variability.INITIALPARAMETER);
                sp = new Scalarizer.Equation(vars, new List<FAbstractEquation>(), Variability.FIXEDPARAMETER);
                sc = new Scalarizer.Equation(vars, new List<FAbstractEquation>(), Variability.CONTINUOUS);
            }
            
            public Scalarizer.Equation select(TypePrefixVariability variability) {
                if (variability.fixedParameterOrLess()) {
                    return sp;
                } else if (variability.parameterOrLess()) {
                    return si;
                } else {
                    return sc;
                }
            }
        }

    
        
        public static class Equation extends Scalarizer {
            
            public Equation(List vars, List equs, TypePrefixVariability variability) {
                this(vars, equs, new ForNames(), variability);
            }
            
            public Equation(List vars, List equs, ForNames forNames, TypePrefixVariability variability) {
                super(vars, equs, forNames, variability);
            }
            
            public Scalarizer.Equation block(List clauses) {
                return block(getVars(), clauses);
            }
            
            public Scalarizer.Equation block(List vars, List clauses) {
                return new Equation(vars, clauses, getNames(), getVariability());
            }
            
            public void add(FExp left, FExp right) {
				// TODO: Not 100% correct, should be equation.setLocationOf(...)
                add(left.setLocationOf(new FEquation(left, right)));
            }
            
            @Override
            public void add(List<FFunctionCallLeft> lefts, FAbstractFunctionCall call) {
                add(new FFunctionCallEquation(lefts, call));
            }
            
            @Override
            public void addTempVar(FExp source) {
                if (!source.useTempVar) {
                    super.addTempVar(source);
                    source.notifyIfWhenEquationsOfTemporaryVar();
                }
            }
        }

    
        
        public Scalarizer.Algorithm algorithm(List<FStatement> stmts) {
            return new Algorithm(getVars(), stmts, getNames(), false, variability);
        }

    
        
        public static Scalarizer.Algorithm function(List<FFunctionVariable> vars, List<FStatement> stmts) {
            return new Algorithm(vars, stmts, new ForNames(), true, Variability.DISCRETE);
        }

    
        
        public static class Algorithm extends Scalarizer {
            private boolean func;
            
            public Algorithm(List vars, List clauses, ForNames forNames, boolean func, TypePrefixVariability variability) {
                super(vars, clauses, forNames, variability);
                this.func = func;
            }
            
            public Scalarizer.Algorithm block(List clauses) {
                return block(getVars(), clauses);
            }
            
            public Scalarizer.Algorithm block(List vars, List clauses) {
                return new Algorithm(vars, clauses, getNames(), func, getVariability());
            }
            
            public void add(FExp left, FExp right) {
                add(new FAssignStmt((FAssignableExp)left, right));
            }
            
            @Override
            public void add(List<FFunctionCallLeft> lefts, FAbstractFunctionCall call) {
                add(new FFunctionCallStmt(lefts, call));
            }
            
            @Override
            public void addTempVar(FType type, String name, boolean addVar) {
                if (func) {
                    if (addVar) {
                        type = type.treeCopy();
                        FFunctionVariable v = type.isArray() ?
                                new FFunctionArray(type, name) :
                                new FFunctionVariable(type, name);
                        add(v);
                    }
                    if (type.isArray()) {
                        FInitArrayStmt stmt = new FInitArrayStmt(new FAccessExp(name));
                        add(stmt);
                        type.scalarizeInitArray(this, stmt);
                    }
                } else {
                    super.addTempVar(type, name, addVar);
                }
            }
            
            public void addTempVar(FAssignStmt source) {
                FType type = source.getLeft().size().isUnknown() ? source.getLeft().type() : source.getRight().type();
                addTempVar(type, source.tempVarName(), true);
            }
            
            public boolean inFunction() {
                return func;
            }
        }


}
