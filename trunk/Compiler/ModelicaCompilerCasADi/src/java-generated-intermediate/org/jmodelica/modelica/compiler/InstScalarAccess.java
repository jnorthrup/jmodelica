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
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\ast\\InstanceTree.ast:158
 * @astdecl InstScalarAccess : InstNamedAccess ::= ExpandedSubscripts:FArraySubscripts;
 * @production InstScalarAccess : {@link InstNamedAccess} ::= <span class="component">ExpandedSubscripts:{@link FArraySubscripts}</span>;

 */
public abstract class InstScalarAccess extends InstNamedAccess implements Cloneable {
    /**
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2124
     */
    protected InstNamedAccess specifyEach(Index i, int[] dim) { //TODO:Necessary?
		FArraySubscripts oldfas = allFArraySubscripts().get(0);
		int n = oldfas.ndims();
		if (n > 0) {
			return getArrayCopy(oldfas.createSpecified(i, dim));
		} else {
			return treeCopy();
		}
	}
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2186
     */
    @Override
    public void collectAccessNames(Set<String> collectedNames) {
        myInstComponentDecl().collectScalarPrimitives(collectedNames);
    }
    /**
     * @declaredat ASTNode:1
     */
    public InstScalarAccess() {
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
        children = new ASTNode[1];
    }
    /**
     * @declaredat ASTNode:13
     */
    @ASTNodeAnnotation.Constructor(
        name = {"ID"},
        type = {"String"},
        kind = {"Token"}
    )
    public InstScalarAccess(String p0) {
        setID(p0);
    }
    /**
     * @declaredat ASTNode:21
     */
    public InstScalarAccess(beaver.Symbol p0) {
        setID(p0);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:25
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:31
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:35
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        getExpandedSubscripts_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:40
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:44
     */
    public InstScalarAccess clone() throws CloneNotSupportedException {
        InstScalarAccess node = (InstScalarAccess) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:55
     */
    @Deprecated
    public abstract InstScalarAccess fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:63
     */
    public abstract InstScalarAccess treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:71
     */
    public abstract InstScalarAccess treeCopy();
    /**
     * Replaces the lexeme ID.
     * @param value The new value for the lexeme ID.
     * @apilevel high-level
     */
    public void setID(String value) {
        tokenString_ID = value;
    }
    /**
     * JastAdd-internal setter for lexeme ID using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme ID
     * @apilevel internal
     */
    public void setID(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setID is only valid for String lexemes");
        tokenString_ID = (String)symbol.value;
        IDstart = symbol.getStart();
        IDend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme ID.
     * @return The value for the lexeme ID.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="ID")
    public String getID() {
        return tokenString_ID != null ? tokenString_ID : "";
    }
    /**
     * Retrieves the ExpandedSubscripts child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the ExpandedSubscripts child.
     * @apilevel low-level
     */
    public FArraySubscripts getExpandedSubscriptsNoTransform() {
        return (FArraySubscripts) getChildNoTransform(0);
    }
    /**
     * Retrieves the child position of the optional child ExpandedSubscripts.
     * @return The the child position of the optional child ExpandedSubscripts.
     * @apilevel low-level
     */
    protected int getExpandedSubscriptsChildPosition() {
        return 0;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2134
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2134")
    public abstract InstArrayAccess getArrayCopy(FArraySubscripts fas);
    /**
     * Get array dimensions.
     * 
     * A value > 0 indicates an array, 0 indicates a scalar and -1 indicates
     * an error in computation of the array dimensions.
     * 
     * @return Array dimension.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:356")
    public int ndims() {
        int ndims_value = myInstComponentDecl().ndims();
        return ndims_value;
    }
    /**
     * Get the expanded FArraySubscripts of each part of this access.
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:446
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:446")
    public java.util.List<FArraySubscripts> allFArraySubscripts() {
        java.util.List<FArraySubscripts> allFArraySubscripts_value = Arrays.asList(getExpandedSubscripts());
        return allFArraySubscripts_value;
    }
    /** @apilevel internal */
    private void getExpandedSubscripts_reset() {
        getExpandedSubscripts_computed = false;
        
        getExpandedSubscripts_value = null;
    }
    /** @apilevel internal */
    protected boolean getExpandedSubscripts_computed = false;

    /** @apilevel internal */
    protected FArraySubscripts getExpandedSubscripts_value;

    /**
     * Get the expanded array subscripts of this access.
     * 
     * An access without subscripts returns subscripts that span the entire component.
     * Any colon subscripts are expanded into constant vector expressions.
     * @attribute syn nta
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:478
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:478")
    public FArraySubscripts getExpandedSubscripts() {
        ASTState state = state();
        if (getExpandedSubscripts_computed) {
            return (FArraySubscripts) getChild(getExpandedSubscriptsChildPosition());
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getExpandedSubscripts_value = myInstComponentDecl().expandedSubscripts();
        setChild(getExpandedSubscripts_value, getExpandedSubscriptsChildPosition());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        getExpandedSubscripts_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        FArraySubscripts node = (FArraySubscripts) this.getChild(getExpandedSubscriptsChildPosition());
        return node;
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1102")
    public Size arraySize() {
        Size arraySize_value = getExpandedSubscripts().accessSize();
        return arraySize_value;
    }
    /**
     * @attribute syn
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Flattening", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1965")
    public InstAccess splitArrayAccess(int index) {
        {
                FArraySubscripts fas = FArraySubscripts.createFColonSubscripts(ndims());
                fas.specifyNext(index);
                return getArrayCopy(fas);
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:32
     * @apilevel internal
     */
    public boolean Define_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getExpandedSubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:35
            return false;
        }
        else {
            return getParent().Define_inSubscriptedExp(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:32
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inSubscriptedExp
     */
    protected boolean canDefine_inSubscriptedExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1093
     * @apilevel internal
     */
    public boolean Define_inUnknownAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return myInstComponentDecl().isUnknown();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1093
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inUnknownAccess
     */
    protected boolean canDefine_inUnknownAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     */
    public InstLookupResult<InstClassDecl> Define_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getExpandedSubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:322
            return getTopInstAccess().lookupInstClass(name);
        }
        else {
            return getParent().Define_lookupInstClass(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:29
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstClass
     */
    protected boolean canDefine_lookupInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     */
    public InstLookupResult<InstComponentDecl> Define_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        if (_callerNode == getExpandedSubscriptsNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:354
            return getTopInstAccess().lookupInstComponent(name);
        }
        else {
            return getParent().Define_lookupInstComponent(this, _callerNode, name);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:320
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupInstComponent
     */
    protected boolean canDefine_lookupInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
