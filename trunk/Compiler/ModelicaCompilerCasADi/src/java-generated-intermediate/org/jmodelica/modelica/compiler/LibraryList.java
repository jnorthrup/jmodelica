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
 * @aspect Library
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Library.jrag:332
 */
public class LibraryList extends java.lang.Object {
    

        protected Set<LibraryDef> set;

    
        
        public LibraryList() {
            set = new LinkedHashSet<LibraryDef>();
        }

    
        
        public void reset() {
            set.clear();
        }

    
        
        public Set<LibraryDef> availableLibraries() {
            return set;
        }

    
        
        public List<SrcLibNode> createLibNodeList() {
            List<SrcLibNode> res = new List<SrcLibNode>();
            for (LibraryDef def : availableLibraries())
                res.add(def.createLibNode());
            return res;
        }

    
        
        /**
         * Add <code>path</code> to list of libraries.
         * 
         * @param path    path of the library to add
         * @param reason  reason this library are added
         * @return <code>true</code> if a library was added 
         */
        public boolean addLibrary(String path, SrcLibNode.LoadReason reason) {
            return add(path, false, reason);
        }

    
        
        /**
         * Add each library found in the directory <code>path</code> to list of libraries.
         * 
         * @param path    path of the directory containing libraries to add
         * @param reason  reason these libraries are added
         * @return <code>true</code> if any libraries were added 
         */
        public boolean addLibraryDirectory(String path, SrcLibNode.LoadReason reason) {
            return add(path, true, reason);
        }

    
        
        /**
         * Add each of <code>paths</code> to list of libraries.
         * 
         * @param paths   paths of the libraries to add
         * @param reason  reason these libraries are added
         * @return <code>true</code> if any libraries were added 
         */
        public boolean addLibraries(String[] paths, SrcLibNode.LoadReason reason) {
            return addAll(paths, false, reason);
        }

    
        
        /**
         * Add each library found in each of the directories in <code>paths</code> 
         * to list of libraries.
         * 
         * @param paths   paths of the directories containing libraries to add
         * @param reason  reason these libraries are added
         * @return <code>true</code> if any libraries were added 
         */
        public boolean addLibraryDirectories(String[] paths, SrcLibNode.LoadReason reason) {
            return addAll(paths, true, reason);
        }

    
        
        protected boolean addAll(String[] paths, boolean directories, SrcLibNode.LoadReason reason) {
            boolean res = false;
            for (String path : paths)
                if (add(path, directories, reason))
                    res = true;
            return res;
        }

    

        /**
         * Add a path to list of libraries.
         * 
         * @param path       the library or directory containing libraries to add
         * @param directory  if <code>true</code>, add all libraries found in the directory 
         *                   <code>path</code>, else add <code>path</code>
         * @param reason     reason for loading this library
         * @return <code>true</code> if any libraries were added 
         */
        protected boolean add(String path, boolean directory, SrcLibNode.LoadReason reason) {
            File base = new File(path);
            if (directory) {
                boolean res = false;
                try {
                    File[] files = base.listFiles();
                    if (files != null)
                        for (File file : files)
                            if (add(file, reason))
                                res = true;
                } catch (SecurityException e) {
                    // TODO: should probably do something constructive here, log an error or something
                }
                return res;
            } else {
                return add(base, reason);
            }
        }

    

        protected boolean add(File path, SrcLibNode.LoadReason reason) {
            try {
                return add(LibraryDef.create(path, reason));
            } catch (SecurityException e) {
                // TODO: should probably do something constructive here, log an error or something
                return false;
            }
        }

    
        
        protected boolean add(LibraryDef def) {
            boolean res = def != null;
            if (res) {
                if (!set.contains(def)) {
                    set.add(def);
                }
            }
            return res;
        }

    
        
        public static class LibraryDef implements Comparable<LibraryDef> {
            
            public final String name;
            public final String version;
            public final File path;
            public final boolean structured;
            public final SrcLibNode.LoadReason reason;
            
            public static LibraryDef create(File path, SrcLibNode.LoadReason reason) {
                if (SrcLibNode.isStructuredLib(path))
                    return new LibraryDef(path, true, reason);
                else if (SrcLibNode.isUnstructuredLib(path))
                    return new LibraryDef(path, false, reason);
                else
                    return null;
            }
            
            public SrcLibNode createLibNode() {
                return new SrcLibNode(path, name, structured, reason);
            }
            
            public int hashCode() {
                return path.hashCode();
            }
            
            public boolean equals(Object o) {
                return o instanceof LibraryDef && path.equals(((LibraryDef) o).path);
            }
            
            public int compareTo(LibraryDef def) {
                int res = name.compareTo(def.name);
                return res == 0 ? path.compareTo(def.path) : res;
            }
            
            public String toString() {
                return name;
            }
            
            private LibraryDef(File path, boolean structured, SrcLibNode.LoadReason reason) {
                String name = path.getName();
                if (!structured) {
                    name = name.substring(0, name.lastIndexOf('.'));
                }
                String[] parts = name.split(" ", 2);
                if (parts.length > 1) {
                    name = parts[0];
                    version = parts[1];
                } else {
                    version = null;
                }
                this.name = name;
                this.path = path;
                this.structured = structured;
                this.reason = reason;
            }
            
        }


}
