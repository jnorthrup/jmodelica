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
 * @aspect ConstantEvaluation
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:60
 */
public abstract class CValue extends ConstValue implements Iterable<CValue>, Cloneable, ExternalProcessMultiCache.Value {
    
		
		/**
		 * An unknown value.
		 */
		public static final CValue UNKNOWN = new CValueUnknown();

    
		
		/**
		 * An unknown value for an expression that constant evaluation 
		 *        isn't supported for.
		 */
		public static final CValue UNSUPPORTED = new CValueUnsupported();

    

		/** 
		 * Default constructor.
		 */
	    protected CValue() {
	    }

    

        /**
         * Copy this constant value.
         */
        public CValue clone() {
            try {
                return (CValue) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new UnsupportedOperationException();
            }
        }

    

        /**
         * Create a literal AST node from constant, for use in flat tree.
         * 
         * @return  literal expression AST node
         */
        public FExp buildLiteral() { 
            throw new ConstantEvaluationException(this, "create literal expression from "); 
        }

    

        /**
         * Create a literal AST node from constant, for use in instance tree.
         * 
         * @return  literal expression AST node
         */
        public FExp buildInstLiteral() { 
            return buildLiteral(); 
        }

    

        /**
         * Constrain value to be between min and max, inclusively
         */
        public CValue constrainWithin(CValue min, CValue max) {
            throw new ConstantEvaluationException(this, "do relational comparison on "); 
        }

    

        /**
         * Convert to CValueInteger, default implementation.
         */
        public CValue convertInteger() {
            return new CValueInteger(intValue());
        }

    

        /**
         * Convert to CValueReal, default implementation.
         */
        public CValue convertReal() {
            return new CValueReal(realValue());
        }

    

        /**
         * Convert to CValueBoolean, default implementation.
         */
        public CValue convertBoolean() {
            return new CValueBoolean(booleanValue());
        }

    

        /**
         * Convert to CValueString, default implementation.
         */
        public CValue convertString() {
            return new CValueString(stringValue());
        }

    

        /**
         * Is {@link #convertInteger()} expected to succeed?
         */
        public boolean hasConvertInteger() {
            return hasIntValue();
        }

    

        /**
         * Is {@link #convertReal()} expected to succeed?
         */
        public boolean hasConvertReal() {
            return hasRealValue();
        }

    

        /**
         * Is {@link #convertBoolean()} expected to succeed?
         */
        public boolean hasConvertBoolean() {
            return hasBooleanValue();
        }

    

        /**
         * Is {@link #convertString()} expected to succeed?
         */
        public boolean hasConvertString() {
            return hasStringValue();
        }

    

        /**
         * Is {@link #buildLiteral()} expected to succeed?
         */
        public boolean hasBuildLiteral() {
            return false;
        }

    

        public String stringExpValue() {
            return stringValue();
        }

    

        /**
         * Convenience method for accessing an array CValue as CValueArray.
         * 
         * Only valid for arrays.
         */
        public CValueArray array() {
        	throw new ConstantEvaluationException(this, "use this as array: ");
        }

    
        
        public CValueUnknownUse unknownUse() {
            throw new ConstantEvaluationException(this, "use this as unknown value use: ");
        }

    
        
        /**
         * Expand this CValue so that it represents an array of the given size, 
         * duplicating values as needed.
         */
        public CValue expandArray(Size s) {
        	if (s == Size.SCALAR)
        		return this;
        	CValueArray res = new CValueArray(s);
        	while (!res.isFilled())
        		res.addCell(this);
        	return res;
        }

    
 	   
        /**
         * Convenience method for accessing a record CValue as CValueRecord.
         * 
         * Only valid for records.
         */
        public CValueRecord record() {
        	throw new ConstantEvaluationException(this, "use this as record: ");
        }

    
        
        /**
         * Reduce an array to a single value.
         * 
         * For a scalar, returns itself. For an empty array, returns zero.
         * 
         * @param op    the operation to use to combine two values
         * @param zero  the start value
         */
        public CValue reduce(BinaryOperation<CValue> op, CValue zero) {
        	return this;
        }

    
        
        /**
         * Reduce an array of constant boolean values to a single boolean that is the logical 
         * or of the array.
         * 
         * Used for the test expression of while statements. For scalar constant values, 
         * just returns the boolean value.
         */
        public boolean reduceBooleanOr() {
        	return reduce(OR_OPERATION, CValueBoolean.FALSE).booleanValue();
        }

    
        
        private static final BinaryOperation<CValue> OR_OPERATION = new BinaryOperation<CValue>() {
        	public CValue op(CValue x, CValue y) {
        		return (x.booleanValue() || y.booleanValue()) ? CValueBoolean.TRUE : CValueBoolean.FALSE;
        	}
        };

    
		
        /**
         * Reduce an array of constant boolean values to a single boolean that is the logical 
         * and of the array.
         * 
         * Used for evaluation of fixed=false parameters when evalute=true.
         */
        public boolean reduceBooleanAnd() {
            return reduce(AND_OPERATION, CValueBoolean.TRUE).booleanValue();
        }

    
        
        private static final BinaryOperation<CValue> AND_OPERATION = new BinaryOperation<CValue>() {
            public CValue op(CValue x, CValue y) {
                return (x.booleanValue() && y.booleanValue()) ? CValueBoolean.TRUE : CValueBoolean.FALSE;
            }
        };

    
        
		/**
		 * Returns the array size of this constant value.
		 */
		public Size size() {
			return Size.SCALAR;
		}

    
		
		/**
		 * Iterates over all array cells in CValue.
		 * 
		 * A scalar CValue is considered to have a single array cell.
		 */
		public Iterator<CValue> iterator() {
			return new SingleIterator<CValue>(this);
		}

    
        
        /**
         * Evaluate this as a function call. Throws exception if not a partial function.
         */
        public void evaluateFunction(VariableEvaluator evaluator, CommonCallable partial, Map<CommonVariableDecl, CValue> values) {
            throw new ConstantEvaluationException(this, "use this as a partial function: ");
        }

    
        
        /**
         * Evaluate this as a partial function call. Throws exception if not a partial function.
         */
        public CValue evaluatePartialFunction(CommonCallable partial, Map<CommonVariableDecl, CValue> values) {
            throw new ConstantEvaluationException(this, "use this as a partial function: ");
        }

    public boolean isZero()        { return false; }

    public CValue cached()       { return this; }

    public boolean equals(CValue other) {
        return super.equals(other);
    }

    public abstract boolean typeMatches(CValue other);

    public CValue merge(CValue other) {
        if (equals(other)) {
            return this;
        }
        if (isUnknown() && !other.isUnknown()) {
            return this;
        } else if (!isUnknown() && other.isUnknown()) {
            return other;
        }
        return CValue.UNKNOWN;
    }

    public CValue component(String name) {
        return CValue.UNKNOWN;
    }

    public void applyAttributes(List<FAttribute> attrs, Index i) {}

    public Set<FAccessExp> getDependencies() {
        return new HashSet<>();
    }

    public void markExternalObject(String name) {
        
    }

    public String getMarkedExternalObject() {
        throw new ConstantEvaluationException();
    }

    public void serialize(BufferedWriter buff) throws IOException {
        throw new IOException("Unsupported type to serialize '" + getClass().getSimpleName() + "'");
    }

    public FSubscript createFSubscript() {
        return buildLiteral().createFSubscript();
    }

    public String xmlValue() {
    		return stringValue();
    	}

    public String cCodeValue() {
		return toString();
	}


}
