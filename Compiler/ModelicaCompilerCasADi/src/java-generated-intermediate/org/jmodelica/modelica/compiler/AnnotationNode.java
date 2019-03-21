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
 * @aspect AnnotationAPI
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:468
 */
public abstract class AnnotationNode extends java.lang.Object implements Iterable<AnnotationNode> {
    private static Set<String> buildExternalFunctionAnnotations() {
        Set<String> res = new LinkedHashSet<String>();
        res.add("Include");
        res.add("IncludeDirectory");
        res.add("Library");
        res.add("LibraryDirectory");
        return res;
    }

    public static final Set<String> EXTERNAL_FUNCTION_ANNOTATIONS = buildExternalFunctionAnnotations();

    


    	
    	
		/**
		 * Returns the value for a node that represents a list of strings.
		 */
		public ArrayList<String> stringList() {
			return null;
		}

    

        /**
         * Represents an annotation that does not exist.
         */
        public static final AnnotationNode NO_ANNOTATION = new NullAnnotationNode();

    

        /**
         * Proxy object for evaluating simple expressions in the source tree.
         */
        public static final InstContext DEFAULT_EVALUATOR = new InstContext() {
            public CValue ceval(SrcExp exp) {
                return exp.ceval();
            }

            public CValue ceval(SrcExp exp, VariableEvaluator evaluator) {
                return exp.ceval(evaluator);
            }

            public InstLookupResult<InstClassDecl> lookupInstClass(SrcExp exp) {
                return null;
            }

            public FExp annotationExp(SrcExp exp) {
                return new FNoExp();
            }

            public InstLookupResult<InstComponentDecl> lookupInstComponent(SrcExp exp) {
                return null;
            }
        };

    

        /**
         * Finds an annotation node at the given path below this one.
         */
        public final AnnotationNode forPath(String path) {
            return forPath(path.split("/"), 0);
        }

    

        /**
         * Finds all annotation nodes of the given name that are direct children to this one.
         */
        public final Iterable<AnnotationNode> allFor(final String name) {
            return new Iterable<AnnotationNode>() {
                public Iterator<AnnotationNode> iterator() {
                    return iteratorFor(name);
                };
            };
        }

    

        /**
         * Iterates over all annotation nodes of the given name that are direct children to this one.
         */
        public Iterator<AnnotationNode> iteratorFor(final String name) {
            Criteria<AnnotationNode> crit = new Criteria<AnnotationNode>() {
                public boolean test(AnnotationNode elem) {
                    return name.equals(elem.name());
                }
            };
            return new FilteredIterator<AnnotationNode>(iterator(), crit);
        }

    

        /**
         * Creates a new empty annotation node, that if written to adds a new child 
         * of this annotation.
         * 
         * Can be used even if there is already a child with that name, 
         * then the new node will be beside the existing node.
         */
        public AnnotationNode emptyNode(String name) {
            return new AssignableNullAnnotationNode(this, name);
        }

    

        /**
         * Internal definition of {@link #forPath(String)}.
         * 
         * @param path   the path elements to find
         * @param i      the first index in <code>path</code> to use
         */
        private final AnnotationNode forPath(String[] path, int i) {
            if (i >= path.length)
                return this;
            AnnotationNode node = lookup(path[i]);
            if (node == null)
                node = emptyNode(path[i]);
            return node.forPath(path, i + 1);
        }

    

        /**
         * Finds an create annotation node at the given path below this one.
         */
        public final AnnotationNode createForPath(String path) {
            return createForPath(path.split("/"), 0);
        }

    

        /**
         * Internal definition of {@link #forPath(String)}.
         * 
         * @param path   the path elements to find
         * @param i      the first index in <code>path</code> to use
         */
        private final AnnotationNode createForPath(String[] path, int i) {
            if (i >= path.length)
                return this;
            AnnotationNode node = lookup(path[i]);
            if (node == null)
                node = addNode(path[i]);
            return node.createForPath(path, i + 1);
        }

    

		/**
		 * Check if this annotation node represents a value node.
		 */
		public boolean isValue() {
			return false;
		}

    
		
		/**
		 * Checks if this annotation node represents an existing annotation.
		 */
		public boolean exists() {
			return true;
		}

    
		
		/**
		 * Get the name associated with this annotation node, if any.
		 * 
		 * In general, any node reachable with a call to forPath() will have a name.
		 * 
		 * @return the name or <code>null</code>, if no name is available
		 */
		public String name() {
			return null;
		}

    

        /**
         * Iterate over this node's child annotation nodes.
         */
        public final Iterator<AnnotationNode> iterator() {
            Iterator<AnnotationNode> attrIt = attributeIterator();
            Iterator<AnnotationNode> valueIt = valueIterator();
            if (attrIt != NullAnnotationNode.EMPTY_ITERATOR && valueIt != NullAnnotationNode.EMPTY_ITERATOR)
                return new ChainedIterator<AnnotationNode>(attrIt, valueIt);
            else if (attrIt != NullAnnotationNode.EMPTY_ITERATOR)
                return attrIt;
            else
                return valueIt;
        }

    

        /**
         * Iterate over this node's child annotation nodes that are declared in
         * an attribute looking way.
         */
        public Iterator<AnnotationNode> attributeIterator() {
            return NullAnnotationNode.EMPTY_ITERATOR;
        }

    

        /**
         * Iterate over this node's child annotation nodes that are declared in
         * a asignment looking way.
         */
        public Iterator<AnnotationNode> valueIterator() {
            return NullAnnotationNode.EMPTY_ITERATOR;
        }

    

        /**
         * For a value modification, return toString() of the rhs, for any other 
         * modification, return null.
         */
        public String valueToString() {
            return null;
        }

    

        /**
         * Calculates and returns the evaluated value of this annotation
         * node (if possible).
         */
        public CValue ceval() {
            return CValue.UNKNOWN;
        }

    

        /**
         * Returns the value for a node that represents a string value.
         */
        public final String string() {
            try {
                return ceval().stringValue();
            } catch (ConstantEvaluationException e) {
                return null;
            }
        }

    

        /**
         * Check if this node represents a string value.
         */
        public final boolean isStringValue() {
            try {
                CValue val = ceval();
                return val.isString() && val.isScalar();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Check if this node represents a value modification that is an access.
         */
        public boolean isAccess() {
            return false;
        }

    

        /**
         * If this annotation was accessed from the instance tree, and this represents a 
         * value that is an access, try to look up that access as a class, and return the 
         * resulting lookup result.
         * 
         * If the requirements are not fulfilled (i.e. instance tree access), this returns null.
         */
        public InstLookupResult<InstClassDecl> lookupInstClass() {
            return null;
        }

    

        /**
         * If this annotation was accessed from the instance tree, and this represents a 
         * value that is an access, try to look up that access as a component, and return the 
         * resulting lookup result.
         * 
         * If the requirements are not fulfilled (i.e. instance tree access), this returns null.
         */
        public InstLookupResult<InstComponentDecl> lookupInstComponent() {
            return null;
        }

    

        /**
         * Returns the value for a node that represents a string value, interpreted as 
         * a path of an URI (with protocol file or modelica). A simple path is also 
         * supported, and is interpreted relative to the top containing package, or if 
         * that does not exist, relative to the directory containing the current file.
         */
        public String path() {
            return URIResolver.DEFAULT.resolveInPackage(ast(), string());
        }

    

        /**
         * Returns the value for a node that represents a list of strings.
         */
        public final String[] stringVector() {
            try {
                CValue val = ceval();
                if (val.isString() && val.isVector()) {
                    return val.stringVector();
                }
            } catch (ConstantEvaluationException e) {}
            return null;
        }

    

        /**
         * Check if this node represents a list of strings.
         */
        public final boolean isStringVector() {
            try {
                CValue val = ceval();
                return val.isString() && val.isVector();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the value for a node that represents a list of strings, 
         * or a single string value.
         */
        public final String[] asStringVector() {
            if (isStringVector())
                return stringVector();
            else if (isStringValue())
                return new String[] { string() };
            else
                return null;
        }

    

        /**
         * Returns the value for a node that represents an integer value.
         */
        public final int integer() {
            try {
                CValue val = ceval();
                if (val.hasIntValue()) {
                    return val.intValue();
                }
            } catch (ConstantEvaluationException e) {}
            return 0;
        }

    

        /**
         * Check if this node represents an integer value.
         */
        public final boolean isIntegerValue() {
            try {
                CValue val = ceval();
                return val.isInteger() && val.isScalar();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the value for a node that represents a real value.
         */
        public final double real() {
            try {
                CValue val = ceval();
                if (val.hasRealValue()) {
                    return val.realValue();
                }
            } catch (ConstantEvaluationException e) {}
            return 0.0;
        }

    

        /**
         * Check if this node represents a real value.
         */
        public final boolean isRealValue() {
            try {
                CValue val = ceval();
                return val.isReal() && val.isScalar();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the value for a node that represents a vector of real values.
         */
        public final double[] realVector() {
            try {
                CValue val = ceval();
                if (val.isReal() && val.isVector()) {
                    return val.realVector();
                }
            } catch (ConstantEvaluationException e) {}
            return null;
        }

    

        /**
         * Check if this node represents a vector of real values.
         */
        public final boolean isRealVectorValue() {
            try {
                CValue val = ceval();
                return val.isReal() && val.isVector();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the value for a node that represents a matrix of real values.
         */
        public final double[][] realMatrix() {
            try {
                CValue val = ceval();
                if (val.isReal() && val.isMatrix()) {
                    return val.realMatrix();
                }
            } catch (ConstantEvaluationException e) {}
            return null;
        }

    

        /**
         * Check if this node represents a matrix of real values.
         */
        public final boolean isRealMatrixValue() {
            try {
                CValue val = ceval();
                return val.isReal() && val.isMatrix();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the value for a node that represents a boolean value.
         */
        public final boolean bool() {
            try {
                CValue val = ceval();
                if (val.hasBooleanValue()) {
                    return val.booleanValue();
                }
            } catch (ConstantEvaluationException e) {}
            return false;
        }

    

        /**
         * Check if this node represents a boolean value.
         */
        public final boolean isBoolValue() {
            try {
                CValue val = ceval();
                return val.isBoolean() && val.isScalar();
            } catch (ConstantEvaluationException e) {
                return false;
            }
        }

    

        /**
         * Returns the ast node that this annotation node is connected to.
         */
        protected abstract ASTNode ast();

    

        /**
         * Returns the exp node that this annotation node is connected to (if possible).
         */
        public SrcExp exp() {
            return null;
        }

    

        /**
         * Returns the FExp node that this annotation node is connected to (if possible).
         */
        public FExp fExp() {
            return null;
        }

    

        /**
         * Returns true if the each keyword is set
         * @return true if each is set
         */
        public boolean isEach() {
            return false;
        }

    

        /**
         * Returns true if the final keyword is set
         * @return true if final is set
         */
        public boolean isFinal() {
            return false;
        }

    

        /**
         * Returns true if the final keyword is set
         * @return true if final is set
         */
        public int level() {
            return 0;
        }

    

        /**
         * Returns the vendor specific node for jmodelica. forPath("__Modelon") is done.
         */
        public AnnotationNode vendorNode() {
            return forPath("__Modelon");
        }

    

        /**
         * Returns the vendor specific node for jmodelica. forPath("__Modelon") is done.
         */
        public AnnotationNode createVendorNode() {
            return createForPath("__Modelon");
        }

    

        /**
         * Return the string representation of the AST node that this annotation node is connected to.
         */
        public String toString() {
            return (ast() != null) ? ast().toString() : "(no annotation)"; 
        }

    

        /**
         * Lookup the annotation node with the name <code>name</code> in this
         * annotation node.
         * Default implementation return NO_ANNOTATION node. Sub classes should
         * implement propper behaviour.
         * 
         * An AssignableNullAnnotationNode is created by calling functions if
         * null is returned.
         * 
         * @param name Name of the node.
         * @return An annotation node representation of the node.
         */
        protected AnnotationNode lookup(String name) {
            return NO_ANNOTATION;
        }

    

        /**
         * Set the expression <code>exp</code> of the node if possible.
         * 
         * @param exp Expresion to set.
         */
        public void setValue(SrcExp exp) {
            throw new AnnotationEditException("Set value is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Set the flat expression <code>exp</code> of the node if possible.
         * 
         * @param exp Flat expresion to set.
         */
        public void setValue(FExp exp) {
            throw new AnnotationEditException("Set value is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Adds a node with the name <code>name</code> to this node if possible.
         * 
         * @param name Name of the new node.
         * @return An annotation node representation of the new node.
         */
        public AnnotationNode addNode(String name) {
            throw new AnnotationEditException("Add node is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Sets the each value for the node (if possible).
         * 
         * @param eachValue New each value that should be set
         */
        public void setEach(boolean eachValue) {
            throw new AnnotationEditException("Set each is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Sets the final value for the node (if possible).
         * 
         * @param finalValue New final value that should be set
         */
        public void setFinal(boolean finalValue) {
            throw new AnnotationEditException("Set final is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Sets the level for the node (if possible).
         * 
         * @param level New level that should be set
         */
        public void setLevel(int level) {
            throw new AnnotationEditException("Set level is not supported on this type of annotation node (" + getClass().getSimpleName() + ")");
        }

    

        /**
         * Collects expressions in this annotation for instantiation and evaluation.
         */
        public void collectExps(ArrayList<SrcExp> exps) {
            ast().collectExps(exps);
        }

    

        /**
         * Iterates over the annotation nodes representing the nodes in the list.
         */
        protected static class AnnotationIterator implements Iterator<AnnotationNode> {
            private Iterator<? extends ASTNode> it;
            private AnnotationNode next;
            private InstContext instContext;

            public AnnotationIterator(Iterator<? extends ASTNode> it, InstContext instContext) {
                this.it = it;
                this.instContext = instContext;
                update();
            }

            public AnnotationIterator(Iterable<? extends ASTNode> list, InstContext instContext) {
                this(list.iterator(), instContext);
            }
            
            public boolean hasNext() {
                return next.exists();
            }
            
            public AnnotationNode next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                AnnotationNode res = next;
                update();
                return res;
            }
            
            public void remove() {
                throw new UnsupportedOperationException();
            }
            
            private void update() {
                next = NO_ANNOTATION;
                while (it.hasNext() && !next.exists()) 
                    next = it.next().annotationNode(instContext);
            }
        }

    

		/**
		 * Represents a non-existing annotation.
		 */
		private static class NullAnnotationNode extends AnnotationNode {
			private static final Iterator<AnnotationNode> EMPTY_ITERATOR = 
				new ArrayList<AnnotationNode>().iterator();
			
			public boolean exists() {
				return false;
			}
			
			public String path() {
				return null;
			}

			protected ASTNode ast() {
				return null;
			}
			
        }


}
