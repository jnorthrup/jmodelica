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
 * @aspect Connections
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:867
 */
public class ConnectionSetEntry extends java.lang.Object implements Comparable<ConnectionSetEntry> {
    

        private InstComponentDecl cd;

    
        private boolean outside;

    
        private FAccess access;

    
        private String prefix;

    
        private String str;

    
        private String[] scalarNames;

    

        public static ConnectionSetEntry create(InstComponentDecl cd, boolean outside, FAccess access) {
            if (cd.isFlow()) 
                return new FlowConnectionSetEntry(cd, outside, access);
            if (cd.isStream()) 
                return new StreamConnectionSetEntry(cd, outside, access);
            return new ConnectionSetEntry(cd, outside, access);
        }

    

        private ConnectionSetEntry(InstComponentDecl cd, boolean outside, FAccess access) {
            //log.debug("Created ConnectionSetEntry: " + cd.name());
            this.cd = cd;
            this.outside = outside;
            this.access = access;
            prefix = null;
        }

    

        public void disconnectFromInstanceTree() {
            cd = null;
        }

    

        public boolean isOutside() {
            return outside;
        }

    

        public boolean isInside() {
            return !outside;
        }

    

        public InstComponentDecl getVar() {
            return cd;
        }

    

        public boolean isFlow() {
            return false;
        }

    

        public boolean isStream() {
            return false;
        }

    

        public String name() {
           return access.name();
        }

    
        
        public String[] names() {
            if (scalarNames != null)
                return scalarNames;
            else
                return new String[] {name()};
        }

    

        public String prefix() {
            if (prefix == null) 
                prefix = access.copyPrefix().name();
            return prefix;
        }

    

        public boolean equals(String name, boolean outside) {
            if (outside != this.outside)
                return false;
            if (scalarNames != null) {
                for (String scalarName : scalarNames)
                    if (name.equals(scalarName))
                        return true;
                return false;
            } else {
                return name.equals(name());
            }
        }

    

        public String toString() {
            if (str == null)
                str = access + (outside ? " (o)" : " (i)");
            return str;
        }

    

        public FAccess getFAccess() {
            return access;
        }

    

        public FAccessExp createFAccessExp() {
            return new FAccessExp(access.treeCopy());
        }

    

        /**
         * Create an FAccessExp that is an access to a variable in this entry, that is connected to 
         * the variable named <code>name</code> in <code>other</code>.
         */
        public FAccessExp createCommonAccessExp(String name, ConnectionSetEntry other) {
            if (other == this)
                return new FAccessExp(name); 
            if (scalarNames == null || other.scalarNames == null)
                return createFAccessExp();
            int i;
            for (i = 0; i < other.scalarNames.length && !other.scalarNames[i].equals(name); i++);
            return (i < scalarNames.length) ? new FAccessExp(scalarNames[i]) : createFAccessExp();
        }

    

        /**
         * Create a zero expression suitable for this entry.
         */
        public FExp createZeroExp() {
            FType t = cd.type();
            if (access.hasFArraySubscripts() && access.getFArraySubscripts().accessNdims() == 0) {
                t = t.scalarType();
            }
            return t.flattenZeroLiteral();
        }

    

        /**
         * Create an equation setting the variable of this entry to zero.
         */
        public FAbstractEquation createZeroEquation() {
            return new FEquation(createFAccessExp(), createZeroExp());
        }

    

        /**
         * Create an access to the var of this entry and add or subtract it to/from e.
         * 
         * Used to build up flow equations.
         */
        public FExp buildFlow(FExp e) {
            return createFAccessExp().appendSum(e, outside, cd.type());
        }

    

        public int hashCode() {
            return toString().hashCode();
        }

    

        /**
         * Create a new connection set entry referring to a specific cell of the variable this refers to.
         * 
         * Assumes that the variable is an array and that <code>i</code> is suitable.
         */
        public ConnectionSetEntry specifyCell(Index i) {
            InstComponentDecl cell = cd.findCell(i, 0);
            return ConnectionSetEntry.create(cell, outside, cell.getFAccess(i));
        }

    

        public boolean equals(Object o) {
            return o instanceof ConnectionSetEntry && toString().equals(o.toString());
        }

    
    
        public int compareTo(ConnectionSetEntry cse) {
            return toString().compareTo(cse.toString());
        }

    

        /**
         * Create an access expression to the associated flow variable.
         * 
         * Only valid for stream connection entries.
         */
        public FExp createFlowCommonAccessExp() {
            throw new UnsupportedOperationException("Only supported for stream connection sets");
        }

    

        /**
         * Get the epsilon to use when calculating flows, based on the associated flow variable's nominal value.
         * 
         * Only valid for stream connection entries.
         */
         public double flowNominal() {
             throw new UnsupportedOperationException("Only supported for stream connection sets");
        }

    

         /**
          * Check if this entry should contribute when calculating streams.
          * 
          * Only valid for stream connection entries.
          */
          public boolean contributesToStream() {
              throw new UnsupportedOperationException("Only supported for stream connection sets");
        }

    


        private static class FlowConnectionSetEntry extends ConnectionSetEntry {

            public FlowConnectionSetEntry(InstComponentDecl cd, boolean outside, FAccess access) {
                super(cd, outside, access);
            }

            public boolean isFlow() {
                return true;
            }

        }

    

        private static class StreamConnectionSetEntry extends ConnectionSetEntry {

            private FExp flowExp;
            private double nominal = 1;
            private boolean contribute = true;

            public StreamConnectionSetEntry(InstComponentDecl cd, boolean outside, FAccess access) {
                super(cd, outside, access);
                InstComponentDecl flow = cd.myFlowVar();
                flowExp = new FAccessExp(flow.getFAccess().treeCopy());
                try {
                    CValue cval = flow.nominalAttributeCValue();
                    if (cval.hasRealValue()) {
                        nominal = Math.abs(cval.realValue());
                    }
                } catch (ConstantEvaluationException e) {}
                try {
                    CValue cval = isOutside() ? flow.maxAttributeCValue() : flow.minAttributeCValue();
                    if (cval.hasRealValue()) {
                        double val = cval.realValue();
                        contribute = isOutside() ? (val > 0) : (val < 0);
                    }
                } catch (ConstantEvaluationException e) {}
            }

            public boolean isStream() {
                return true;
            }

            public FExp createFlowCommonAccessExp() {
                return flowExp.fullCopy();
            }

            public double flowNominal() {
                return nominal;
            }

            public boolean contributesToStream() {
                return contribute;
            }

        }

    public void scalarize() {
		if (access.accessNdims() == 0) {
			// Can't use FAccess.scalarize(), since it relies on rewrites
			access = new FAccessString(access.scalarName());
		} else {
			Indices ind = Indices.createFromFas(access.getFArraySubscripts());
			scalarNames = new String[ind.numElements()];
			int j = 0;
			for (Index i : ind)
				scalarNames[j++] = access.copyAndAddFas(i.createFArraySubscripts()).scalarName();
		}
	}


}
