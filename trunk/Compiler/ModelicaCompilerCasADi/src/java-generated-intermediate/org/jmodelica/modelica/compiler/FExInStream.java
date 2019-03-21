/* This file was generated with JastAdd2 (http://jastadd.org) version 2.3.0 */
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
 * Expanded version of FInStream, used temporarily during symbolic manipulations.
 * 
 * Var list contains triples of: 
 * - flow var access
 * - stream contribution (inStream() expression or var access)
 * - is this connection to an outside connector (bool literal)
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:1661
 * @astdecl FExInStream : FBuiltInFunctionCall ::= Default:FExp Eps:FExp Var:FExp*;
 * @production FExInStream : {@link FBuiltInFunctionCall} ::= <span class="component">Default:{@link FExp}</span> <span class="component">Eps:{@link FExp}</span> <span class="component">Var:{@link FExp}*</span>;

 */
public class FExInStream extends FBuiltInFunctionCall implements Cloneable {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1058
     */
    public FExInStream createEmptyNode()      { return new FExInStream();      }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1422
     */
    public FExInStream(FExp a1, FExp a2, List<FExp> a3) { this(emptyArgs(), a1, a2, a3); }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:122
     */
    public void enableExpandedInStreamRewrite() {
        super.enableExpandedInStreamRewrite();
        
        // We don't need to add anything for < 2 contributors
        FExp stream = getDefault().treeCopy();
        int n = 0;
        for (InStreamPart cont : contributors()) {
            stream = cont.stream.treeCopy();
            n++;
            if (n > 1) {
                break;
            }
        }
        if (n < 2) {
            replaceMe(stream);
            return;
        }
        
        FExp eps   = getEps();
        FExp alpha = generateAlpha(eps, generateS());
        
        // Generate replacement expression
        ArrayList<FExp> nominatorTerms   = new ArrayList<FExp>();
        ArrayList<FExp> denominatorTerms = new ArrayList<FExp>();
        for (InStreamPart cont : contributors()) {
            stream = cont.stream.treeCopy();
            FExp flow = cont.flow.treeCopy();
            if (!cont.outside) {
                flow = new FNegExp(flow);
            }
            FExp posMax = positiveMax(eps, flow, alpha);
            nominatorTerms.add(new FMulExp(posMax.treeCopyNoTransform(), stream));
            denominatorTerms.add(posMax);
        }
        replaceMe(new FDivExp(
                FExp.createBalancedBinaryTree(new FAddExp(), nominatorTerms),
                FExp.createBalancedBinaryTree(new FAddExp(), denominatorTerms)));
    }
    /**
     * Generate and add variable with varType, add an equation for the variable with rhs <code>exp</code>.
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:164
     */
    private FExp addEquation(FlatVariableMap.GeneratedVarType varType, FExp exp) {
        String name = calcGeneratedVarName(varType);
        TypePrefixVariability v = variability().combine(Variability.FIXEDPARAMETER);
        myFClass().addFVariable(type().createTempFVariable(new FAccessString(name), variability()));
        myFClass().equationList(v).add(new FEquation(new FAccessExp(name), exp));
        return new FAccessExp(name);
    }
    /** 
     * Add variable and equation for s_i, return reference to s_i
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:190
     */
    private FExp generateS() {
        ArrayList<FExp> terms = new ArrayList<FExp>();
        for (InStreamPart cont : contributors()) {
            FExp flow = cont.flow.treeCopy();
            if (!cont.outside) {
                flow = new FNegExp(flow);
            }
            terms.add(new FMaxExp(flow, new Opt<FExp>(new FIntegerLitExp(0))));
            
        }
        return addEquation(FlatVariableMap.GeneratedVarType.STREAM_S,
                FExp.createBalancedBinaryTree(new FAddExp(), terms));
    }
    /** 
     * Add variable and equation for alpha_i, return reference to alpha_i
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:207
     */
    private FExp generateAlpha(FExp eps, FExp s) {
        FExp sDivEps = new FDivExp(s.treeCopyNoTransform(), eps.treeCopyNoTransform());
        FExp alpha = new FSmoothExp(
                new FIntegerLitExp(1), 
                new FIfExp(
                        new FGtExp(
                                s.treeCopyNoTransform(),
                                eps.treeCopyNoTransform()),
                        new FIntegerLitExp(1),
                        new FIfExp(
                                new FGtExp(
                                        s.treeCopyNoTransform(),
                                        new FIntegerLitExp(0)),
                                new FMulExp(
                                        sDivEps.treeCopyNoTransform(), 
                                        new FMulExp(
                                                sDivEps.treeCopyNoTransform(),
                                                new FSubExp(
                                                        new FIntegerLitExp(3),
                                                        new FMulExp(
                                                                new FIntegerLitExp(2),
                                                                s.treeCopyNoTransform())))),
                                new FIntegerLitExp(0))));
        return addEquation(FlatVariableMap.GeneratedVarType.STREAM_ALPHA, alpha);
    }
    /** 
     * Add variable and equation for positiveMax_i, return reference to positiveMax_i
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:236
     */
    private FExp positiveMax(FExp eps, FExp flow, FExp alpha) {
        FExp exp = new FAddExp(
                new FMulExp(
                        alpha.treeCopyNoTransform(),
                        new FMaxExp(
                                flow,
                                new Opt<FExp>(new FIntegerLitExp(0)))),
                new FMulExp(
                        new FSubExp(
                                new FIntegerLitExp(1),
                                alpha.treeCopyNoTransform()),
                        eps.treeCopyNoTransform()));
        return addEquation(FlatVariableMap.GeneratedVarType.STREAM_POSMAX, exp);
    }
    /**
     * An iterable over all stream/flow pairs that contribute to this inStream().
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:266
     */
    
        /**
         * An iterable over all stream/flow pairs that contribute to this inStream().
         */
        public Iterable<InStreamPart> contributors() {
            return new ContributorIterable();
        }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:270
     */
    
        
        public class InStreamPart {
            public final FExp flow;
            public final FExp stream;
            public final boolean outside;

            public InStreamPart(int i) {
                flow = flowExp(i);
                stream = streamExp(i);
                outside = isOutside(i);
            }

            public boolean contributes() {
                if (outside) {
                    return flow.maxRealValue() > 0;
                } else {
                    return flow.minRealValue() < 0;
                }
            }
        }
    /**
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:290
     */
    

        private class ContributorIterable implements Iterable<InStreamPart> {
            private int n = numVars();
            
            public Iterator<InStreamPart> iterator() {
                return new ContributorIterator();
            }

            private class ContributorIterator implements Iterator<InStreamPart> {
                private int i;
                private InStreamPart next;

                public ContributorIterator() {
                    i = -1;
                    step();
                }

                public boolean hasNext() {
                    return i < n;
                }

                public InStreamPart next() {
                    InStreamPart res = next;
                    step();
                    return res;
                }
                
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                private void step() {
                    do {
                        i++;
                        next = (i < n) ? new InStreamPart(i) : null;
                    } while (i < n && !next.contributes());
                }
            }
        }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1947
     */
    public FExInStream scalarizeExp(Scalarizer s) {
        FExInStream res = new FExInStream(getDefault().scalarize(s), getEps().scalarize(s), new List<FExp>());
        for (FExp e : getVars()) {
            res.addVarNoTransform(e.scalarize(s));
        }
        return res;
    }
    /**
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:520
     */
    @Override
    protected FExp diffExp(String name) {
        if (name.equals(FExp.TIME)) {
            return new FDerStream(copySymbolic());
        }
        return super.diffExp(name);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FExInStream() {
        super();
    }
    /**
     * Initializes the child array to the correct size.
     * Initializes List and Opt nta children.
     * @apilevel internal
     * @ast method
     * @declaredat ASTNode:10
     */
    public void init$Children() {
        children = new ASTNode[5];
        setChild(List.EMPTY, 0);
        setChild(List.EMPTY, 3);
    }
    /**
     * @declaredat ASTNode:15
     */
    @ASTNodeAnnotation.Constructor(
        name = {"OriginalArg", "Default", "Eps", "Var"},
        type = {"List<InstFunctionArgument>", "FExp", "FExp", "List<FExp>"},
        kind = {"List", "Child", "Child", "List"}
    )
    public FExInStream(List<InstFunctionArgument> p0, FExp p1, FExp p2, List<FExp> p3) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setChild(p3, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:27
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:33
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:37
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        ndims_reset();
        size_reset();
        getArrayExp_reset();
        type_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:45
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:49
     */
    public FExInStream clone() throws CloneNotSupportedException {
        FExInStream node = (FExInStream) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:54
     */
    public FExInStream copy() {
        try {
            FExInStream node = (FExInStream) clone();
            node.parent = null;
            if (children != null) {
                node.children = (ASTNode[]) children.clone();
            }
            return node;
        } catch (CloneNotSupportedException e) {
            throw new Error("Error: clone not supported for " + getClass().getName());
        }
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:73
     */
    @Deprecated
    public FExInStream fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:83
     */
    public FExInStream treeCopyNoTransform() {
        FExInStream tree = (FExInStream) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
                switch (i) {
                case 4:
                    tree.children[i] = null;
                    continue;
                }
                ASTNode child = (ASTNode) children[i];
                if (child != null) {
                    child = child.treeCopyNoTransform();
                    tree.setChild(child, i);
                }
            }
        }
        return tree;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:108
     */
    public FExInStream treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:113
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * Replaces the OriginalArg list.
     * @param list The new list node to be used as the OriginalArg list.
     * @apilevel high-level
     */
    public void setOriginalArgList(List<InstFunctionArgument> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * @return Number of children in the OriginalArg list.
     * @apilevel high-level
     */
    public int getNumOriginalArg() {
        return getOriginalArgList().getNumChild();
    }
    /**
     * Retrieves the number of children in the OriginalArg list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the OriginalArg list.
     * @apilevel low-level
     */
    public int getNumOriginalArgNoTransform() {
        return getOriginalArgListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the OriginalArg list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the OriginalArg list.
     * @apilevel high-level
     */
    public InstFunctionArgument getOriginalArg(int i) {
        return (InstFunctionArgument) getOriginalArgList().getChild(i);
    }
    /**
     * Check whether the OriginalArg list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasOriginalArg() {
        return getOriginalArgList().getNumChild() != 0;
    }
    /**
     * Append an element to the OriginalArg list.
     * @param node The element to append to the OriginalArg list.
     * @apilevel high-level
     */
    public void addOriginalArg(InstFunctionArgument node) {
        List<InstFunctionArgument> list = (parent == null) ? getOriginalArgListNoTransform() : getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addOriginalArgNoTransform(InstFunctionArgument node) {
        List<InstFunctionArgument> list = getOriginalArgListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the OriginalArg list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setOriginalArg(InstFunctionArgument node, int i) {
        List<InstFunctionArgument> list = getOriginalArgList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="OriginalArg")
    public List<InstFunctionArgument> getOriginalArgList() {
        List<InstFunctionArgument> list = (List<InstFunctionArgument>) getChild(0);
        return list;
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgListNoTransform() {
        return (List<InstFunctionArgument>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the OriginalArg list without
     * triggering rewrites.
     */
    public InstFunctionArgument getOriginalArgNoTransform(int i) {
        return (InstFunctionArgument) getOriginalArgListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the OriginalArg list.
     * @return The node representing the OriginalArg list.
     * @apilevel high-level
     */
    public List<InstFunctionArgument> getOriginalArgs() {
        return getOriginalArgList();
    }
    /**
     * Retrieves the OriginalArg list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the OriginalArg list.
     * @apilevel low-level
     */
    public List<InstFunctionArgument> getOriginalArgsNoTransform() {
        return getOriginalArgListNoTransform();
    }
    /**
     * Replaces the Default child.
     * @param node The new node to replace the Default child.
     * @apilevel high-level
     */
    public void setDefault(FExp node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Default child.
     * @return The current node used as the Default child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Default")
    public FExp getDefault() {
        return (FExp) getChild(1);
    }
    /**
     * Retrieves the Default child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Default child.
     * @apilevel low-level
     */
    public FExp getDefaultNoTransform() {
        return (FExp) getChildNoTransform(1);
    }
    /**
     * Replaces the Eps child.
     * @param node The new node to replace the Eps child.
     * @apilevel high-level
     */
    public void setEps(FExp node) {
        setChild(node, 2);
    }
    /**
     * Retrieves the Eps child.
     * @return The current node used as the Eps child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Eps")
    public FExp getEps() {
        return (FExp) getChild(2);
    }
    /**
     * Retrieves the Eps child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Eps child.
     * @apilevel low-level
     */
    public FExp getEpsNoTransform() {
        return (FExp) getChildNoTransform(2);
    }
    /**
     * Replaces the Var list.
     * @param list The new list node to be used as the Var list.
     * @apilevel high-level
     */
    public void setVarList(List<FExp> list) {
        setChild(list, 3);
    }
    /**
     * Retrieves the number of children in the Var list.
     * @return Number of children in the Var list.
     * @apilevel high-level
     */
    public int getNumVar() {
        return getVarList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Var list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Var list.
     * @apilevel low-level
     */
    public int getNumVarNoTransform() {
        return getVarListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Var list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Var list.
     * @apilevel high-level
     */
    public FExp getVar(int i) {
        return (FExp) getVarList().getChild(i);
    }
    /**
     * Check whether the Var list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasVar() {
        return getVarList().getNumChild() != 0;
    }
    /**
     * Append an element to the Var list.
     * @param node The element to append to the Var list.
     * @apilevel high-level
     */
    public void addVar(FExp node) {
        List<FExp> list = (parent == null) ? getVarListNoTransform() : getVarList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addVarNoTransform(FExp node) {
        List<FExp> list = getVarListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Var list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setVar(FExp node, int i) {
        List<FExp> list = getVarList();
        if (list == List.EMPTY) {
            setChild(new List(node), 3);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Var list.
     * @return The node representing the Var list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Var")
    public List<FExp> getVarList() {
        List<FExp> list = (List<FExp>) getChild(3);
        return list;
    }
    /**
     * Retrieves the Var list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Var list.
     * @apilevel low-level
     */
    public List<FExp> getVarListNoTransform() {
        return (List<FExp>) getChildNoTransform(3);
    }
    /**
     * @return the element at index {@code i} in the Var list without
     * triggering rewrites.
     */
    public FExp getVarNoTransform(int i) {
        return (FExp) getVarListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Var list.
     * @return The node representing the Var list.
     * @apilevel high-level
     */
    public List<FExp> getVars() {
        return getVarList();
    }
    /**
     * Retrieves the Var list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Var list.
     * @apilevel low-level
     */
    public List<FExp> getVarsNoTransform() {
        return getVarListNoTransform();
    }
    /**
     * Retrieves the ArrayExp child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ArrayExp child.
     * @apilevel low-level
     */
    public ArrayExp getArrayExpNoTransform() {
        return (ArrayExp) getChildNoTransform(4);
    }
    /**
     * Retrieves the child position of the optional child ArrayExp.
     * @return The the child position of the optional child ArrayExp.
     * @apilevel low-level
     */
    protected int getArrayExpChildPosition() {
        return 4;
    }
    /** @apilevel internal */
    private void ndims_reset() {
        ndims_computed = false;
    }
    /** @apilevel internal */
    protected boolean ndims_computed = false;

    /** @apilevel internal */
    protected int ndims_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:228")
    public int ndims() {
        ASTState state = state();
        if (ndims_computed) {
            return ndims_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        ndims_value = expDefiningSize().ndims();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        ndims_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return ndims_value;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:346
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:346")
    public FExp expDefiningSize() {
        FExp expDefiningSize_value = (numVars() > 0) ? streamExp(0) : getDefault();
        return expDefiningSize_value;
    }
    /** @apilevel internal */
    private void size_reset() {
        size_computed = false;
        
        size_value = null;
    }
    /** @apilevel internal */
    protected boolean size_computed = false;

    /** @apilevel internal */
    protected Size size_value;

    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:723")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = expDefiningSize().size();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /** @apilevel internal */
    private void getArrayExp_reset() {
        getArrayExp_computed = false;
        
        getArrayExp_value = null;
    }
    /** @apilevel internal */
    protected boolean getArrayExp_computed = false;

    /** @apilevel internal */
    protected ArrayExp getArrayExp_value;

    /**
     * Computes a generic array expansion of the expression. If this expression is not an array the result is undefined.
     * Normally {@link #getArray()} should be called instead.
     * 
     * This is used mainly to scalarize array expressions. Should be overridden for all 
     * expression types possible, since default implementation clones the original expression 
     * for each cell.
     * 
     * @return An ArrayExp with scalar expressions if this is an array expression, 
     * <code>null</code> otherwise.
     * @attribute syn nta
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1367")
    public ArrayExp getArrayExp() {
        ASTState state = state();
        if (getArrayExp_computed) {
            return (ArrayExp) getChild(getArrayExpChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getArrayExp_value = getArrayExp_compute();
        setChild(getArrayExp_value, getArrayExpChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getArrayExp_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        ArrayExp node = (ArrayExp) this.getChild(getArrayExpChildPosition());
        return node;
    }
    /** @apilevel internal */
    private ArrayExp getArrayExp_compute() {
            ArrayExp arr = new ArrayExp(indices());
            for (Index i : arr.indices()) {
                FExInStream cell = new FExInStream(getDefault().getArray().get(i).treeCopy(), getEps().treeCopy(), new List<FExp>());
                for (FExp e : getVars()) {
                    Index j = (e.ndims() < i.ndims()) ? i.partIndex(0, e.ndims()) : i;
                    cell.addVarNoTransform(e.getArray().get(j).treeCopy());
                }
                arr.set(i, cell);
            }
            return arr;
        }
    /**
     * Delegate attribute for ceval().
     * 
     * This needs to be overridden for subclasses of FExp.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2343")
    public CValue cevalCalc(VariableEvaluator evaluator) {
        {
                int n = 0;
                for (InStreamPart cont : contributors()) {
                    n++;
                    break;
                }
                if (n == 0) {
                    return getDefault().ceval(evaluator);
                } else if (n == 1) {
                    return contributors().iterator().next().stream.ceval(evaluator);
                } else {
                    double eps = -1.0;
                    double val = 0.0;
                    double sum = 0.0;
                    double div = 0.0;
                    for (InStreamPart cont : contributors()) {
                        double flow = cont.flow.ceval(evaluator).realValue();
                        if (!cont.outside) {
                            flow = -flow;
                        }
                        if (eps < 0.0) {
                            eps = getEps().ceval(evaluator).realValue();
                        }
                        flow = Math.max(flow, eps);
                        sum += flow * cont.stream.ceval(evaluator).realValue();
                        div += flow;
                    }
                    return new CValueReal(sum / div);
                }
            }
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1817")
    public String builtInName() {
        String builtInName_value = "inStreamExpansion";
        return builtInName_value;
    }
    /** @apilevel internal */
    private void type_reset() {
        type_computed = false;
        
        type_value = null;
    }
    /** @apilevel internal */
    protected boolean type_computed = false;

    /** @apilevel internal */
    protected FType type_value;

    /**
     * @attribute syn
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeAnalysis", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:322")
    public FType type() {
        ASTState state = state();
        if (type_computed) {
            return type_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        type_value = fRealType(size());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        type_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return type_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:426")
    public TypePrefixVariability expVariability() {
        {
                TypePrefixVariability stream = getDefault().variability();
                TypePrefixVariability total = Variability.CONSTANT;
                int n = 0;
                for (InStreamPart cont : contributors()) {
                    stream = cont.stream.variability();
                    total = total.combine(stream).combine(cont.flow.variability());
                    n++;
                }
                if (n < 2) {
                    return stream;
                } else {
                    return total;
                }
            }
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:97
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:97")
    public boolean needsLaterInStreamRewrite() {
        boolean needsLaterInStreamRewrite_value = true;
        return needsLaterInStreamRewrite_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:252")
    public int numVars() {
        int numVars_value = getNumVar() / 3;
        return numVars_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:254")
    public FExp flowExp(int i) {
        FExp flowExp_int_value = getVar(i * 3);
        return flowExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:256
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:256")
    public FExp streamExp(int i) {
        FExp streamExp_int_value = getVar(i * 3 + 1);
        return streamExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:258
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:258")
    public FExp isOutsideExp(int i) {
        FExp isOutsideExp_int_value = getVar(i * 3 + 2);
        return isOutsideExp_int_value;
    }
    /**
     * @attribute syn
     * @aspect Connections
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:260
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Connections", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:260")
    public boolean isOutside(int i) {
        boolean isOutside_int_value = isOutsideExp(i).ceval().booleanValue();
        return isOutside_int_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
