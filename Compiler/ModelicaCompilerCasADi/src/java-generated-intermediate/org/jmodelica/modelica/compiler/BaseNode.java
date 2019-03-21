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
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\BaseAST.ast:18
 * @astdecl BaseNode : ASTNode;
 * @production BaseNode : {@link ASTNode};

 */
public abstract class BaseNode extends ASTNode<ASTNode> implements Cloneable {
    /**
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:228
     */
    public void htmlSourcePrettyPrint(Printer p, CodeStream str, String indent) {
		SourceLocation[] file = null;
		if(fName instanceof String){
			file = new SourceLocation[1];
			file[0] = new SourceLocation((String)fName, start, end);
		}else if(fName != null){
			file = (SourceLocation[])fName;			
		}
		String nodeClass = htmlSourceNodeClass();
		
		if((file != null || htmlSourceNodeClass() != null) && p instanceof HtmlSourcePrettyPrinter){// && !locationContainedBy()){
			String dir = System.getProperty("user.dir");
			Boolean containedByParent = locationContainedBy();
			HtmlSourcePrettyPrinter hp = (HtmlSourcePrettyPrinter)p;

			str.print("<span ");
			str.print("class=\"");
			if(htmlSourceNodeClass() != null){
				str.print(htmlSourceNodeClass());
			}
			
			if(file != null ){
				if(!containedByParent){
					if(htmlSourceNodeClass() != null){
						str.print(" ");
					}
					str.print("newLevel");
				}
				str.print("\" title=\"");
				for(int i = 0; i < file.length; i++){
					String fileName = cropAbsolutePath(file[i].getFile());
					if(i > 0)
						str.print("&#10;");									// makes linebreaks to show multiple sources
					
					str.format("%s %d:%d %d:%d", fileName, file[i].getStartLine(), file[i].getStartColumn(),  file[i].getEndLine(), file[i].getEndColumn());
				}
			}
			
			str.print("\">");
			prettyPrint(p, str, indent);
			
			str.print("</span>");
		}else{
			prettyPrint(p, str, indent);
		}
	}
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:146
     */
    public String prettyPrint(String indent) {
        return super.prettyPrint(indent);
    }
    /**
     * @aspect SourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\SourcePrettyPrint.jrag:30
     */
    public void sourcePrettyPrint(Printer p, CodeStream str, String indent){
		prettyPrint(p, str, indent);
	}
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:624
     */
    protected boolean errorChecked = false;
    /**
     * @aspect InstanceErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:636
     */
    public void resetCollectErrors() {
		errorChecked = false;
		super.resetCollectErrors();
	}
    /**
     * @aspect Parsers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\Parser.jrag:37
     */
    public int adjustStartOfEmptySymbols(AdjustableSymbol[] syms, int i, int last) {
        return start;
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied from two other nodes.
     * 
     * @param start  the node to copy the <code>start</code> and <code>fName</code> 
     * members from.
     * @param end    the node to copy the <code>end</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:136
     */
    public void setLocation(ASTNode start, ASTNode end) {
        super.setLocation(start, end);        
        fName = start.fileNames();
    }
    /**
     * Sets the member variables defining the location of the node within 
     * the source to values copied from two other nodes, that might not be 
     * in a proper AST.
     * 
     * @param start  the node to copy the <code>start</code> and <code>fName</code> 
     * members from.
     * @param end    the node to copy the <code>end</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:184
     */
    public void setLocationNoTree(ASTNode start, ASTNode end) {
    	setLocationNoTree(start, end, start);
    }
    /**
     * Sets the member variables defining the location of the node within
     * the source to values copied from two other nodes, that might not be
     * in a proper AST.
     * @param start      the node to copy the <code>start</code> member from.
     * @param end        the node to copy the <code>end</code> member from.
     * @param fNameNode  the node to copy the <code>fName</code> member from.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:196
     */
    public void setLocationNoTree(ASTNode start, ASTNode end, ASTNode fNameNode) {
        super.setLocation(start, end);
        if (fNameNode instanceof BaseNode)
        	fName = ((BaseNode) fNameNode).fName;
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:207
     */
    protected void addLocation(ASTNode node){
    	int l1 = 0;
    	int l2 = 0;
    	SourceLocation[] sourceA, sourceA2;
    	if(node == null)
    		return;
    	if(fName == null || !(node instanceof BaseNode)){
    		setLocationNoTree(node);
    		return;
    	}
    	BaseNode sourceNode = (BaseNode)node; 
    	if(fName instanceof String){
    		l1 = 1;
    		sourceA = new SourceLocation[1];
    		sourceA[0] = new SourceLocation((String)fName, start, end);
    	}else{
    		l1 = ((SourceLocation[])fName).length;
    		sourceA = ((SourceLocation[])fName);
    	}
    	if(sourceNode.fName == null){
    		return;
    	}else if(sourceNode.fName instanceof String){
    		l2 = 1;
    		sourceA2 = new SourceLocation[1];
    		sourceA2[0] = new SourceLocation((String)sourceNode.fName, sourceNode.start, sourceNode.end);
    	}else{
    		l2 = ((SourceLocation[])sourceNode.fName).length;
    		sourceA2 = ((SourceLocation[])sourceNode.fName).clone();
    	}
    	
    	ArrayList<SourceLocation> tempLocations = new ArrayList<SourceLocation>();
    	for(int i = 0; i < l1; i++){
    		boolean ignoreSourceA = false; 
			for(int j = 0; j < l2; j++){
				if(sourceA2[j] == null){
					continue;
				}
				if(sourceA[i].locationContainedBy(sourceA2[j])){
					tempLocations.add(sourceA2[j]);
					sourceA2[j] = null;
					ignoreSourceA = true;
				}
				else if(!sourceA2[j].locationContainedBy(sourceA[i])){
					tempLocations.add(sourceA2[j]);
					sourceA2[j] = null;
				}
			}
			if(!ignoreSourceA)
				tempLocations.add(sourceA[i]);
		}
    	if(tempLocations.size() == 1){
    		fName = tempLocations.get(0).getFile();
    		start = tempLocations.get(0).getStart();
    		end = tempLocations.get(0).getEnd();
    	}else{
    		fName = tempLocations.toArray(sourceA);    		
    	}
    	
    }
    /**
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:458
     */
    protected boolean isChildOfHelper(BaseNode parent) {
        return parent == this;
    }
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:621
     */
    protected Object fName = null;
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:645
     */
    public Object fileNames() {
    	if (fName == null)
    	    fName = retrieveFileName();
   		return fName;
    }
    /**
     * @aspect FileNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:658
     */
    public String fileName() {
    	if (fName == null){
    	    fName = retrieveFileName();
    	}
    	if(fName instanceof SourceLocation[]){
    		return ((SourceLocation[])this.fName)[0].getFile();
    	}
   		return (String)fName;
    }
    /**
     * @declaredat ASTNode:1
     */
    public BaseNode() {
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
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:13
     */
    protected int numChildren() {
        return 0;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:19
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:23
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:27
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:31
     */
    public BaseNode clone() throws CloneNotSupportedException {
        BaseNode node = (BaseNode) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:42
     */
    @Deprecated
    public abstract BaseNode fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:50
     */
    public abstract BaseNode treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:58
     */
    public abstract BaseNode treeCopy();
    /**
     * @attribute syn
     * @aspect HtmlSourcePrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:216
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HtmlSourcePrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\HtmlSourcePrettyPrint.jrag:216")
    public String htmlSourceNodeClass() {
        String htmlSourceNodeClass_value = null;
        return htmlSourceNodeClass_value;
    }
    /**
     * @attribute syn
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:520")
    public boolean allowUnknownSize() {
        boolean allowUnknownSize_value = false;
        return allowUnknownSize_value;
    }
    /**
     * @attribute syn
     * @aspect RootAccess
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:62
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RootAccess", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:62")
    public Root root() {
        Root root_value = retrieveRoot();
        return root_value;
    }
    /**
     * @attribute syn
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:268
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:268")
    public boolean locationContainedBy() {
        {
            	if(!(fName instanceof String))
            		return false;
            	BaseNode parentWithLocation = parentWithLocation();
            	if (parentWithLocation == null) {
            		return false;
            	}
        		return fName.equals(parentWithLocation.fName) && start >= parentWithLocation.start && end <= parentWithLocation.end;		
            }
    }
    /**
     * @attribute inh
     * @aspect FlatTypeCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatTypeCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526")
    public boolean inAllowUnknownSize() {
        boolean inAllowUnknownSize_value = getParent().Define_inAllowUnknownSize(this, null);
        return inAllowUnknownSize_value;
    }
    /**
     * @attribute inh
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:277
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="NodeMethods", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:277")
    public BaseNode parentWithLocation() {
        BaseNode parentWithLocation_value = getParent().Define_parentWithLocation(this, null);
        return parentWithLocation_value;
    }
    /**
     * @attribute inh
     * @aspect XMLTagBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:751
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="XMLTagBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:751")
    public String parentXmlNamespace() {
        String parentXmlNamespace_value = getParent().Define_parentXmlNamespace(this, null);
        return parentXmlNamespace_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753
     * @apilevel internal
     */
    public CValue Define_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return access.myInstComponentDecl().cevalParentRecord(evaluator).record().getMember(access.getID());
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:2753
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute cevalRecordMember
     */
    protected boolean canDefine_cevalRecordMember(ASTNode _callerNode, ASTNode _childNode, VariableEvaluator evaluator, InstNamedAccess access) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:78
     * @apilevel internal
     */
    public boolean Define_retrieveShouldHaveParenthesis(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:78
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveShouldHaveParenthesis
     */
    protected boolean canDefine_retrieveShouldHaveParenthesis(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     * @apilevel internal
     */
    public boolean Define_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3325
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallArg
     */
    protected boolean canDefine_isFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     */
    public boolean Define_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3358
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLeftHandSide
     */
    protected boolean canDefine_isLeftHandSide(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     */
    public boolean Define_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3368
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isAssignedTo
     */
    protected boolean canDefine_isAssignedTo(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:160
     * @apilevel internal
     */
    public boolean Define_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:160
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGlobalAccess
     */
    protected boolean canDefine_isGlobalAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     */
    public boolean Define_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1870
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inFArray
     */
    protected boolean canDefine_inFArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561
     * @apilevel internal
     */
    public FExp Define_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:561
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute copyReplaceAccessParent
     */
    protected boolean canDefine_copyReplaceAccessParent(ASTNode _callerNode, ASTNode _childNode, FExp.FunctionContextReplacer crp) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1530
     * @apilevel internal
     */
    public boolean Define_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1530
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isConstructorAssign
     */
    protected boolean canDefine_isConstructorAssign(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1170
     * @apilevel internal
     */
    public boolean Define_isModificationName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1170
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isModificationName
     */
    protected boolean canDefine_isModificationName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114
     * @apilevel internal
     */
    public boolean Define_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:114
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isExpandableConnectorMemberInConnect
     */
    protected boolean canDefine_isExpandableConnectorMemberInConnect(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:119
     * @apilevel internal
     */
    public boolean Define_inConnectWithExistingComponent(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\NameCheck.jadd:119
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inConnectWithExistingComponent
     */
    protected boolean canDefine_inConnectWithExistingComponent(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526
     * @apilevel internal
     */
    public boolean Define_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return allowUnknownSize();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:526
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAllowUnknownSize
     */
    protected boolean canDefine_inAllowUnknownSize(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843
     * @apilevel internal
     */
    public boolean Define_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:843
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute accessToModelOK
     */
    protected boolean canDefine_accessToModelOK(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532
     * @apilevel internal
     */
    public boolean Define_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\TypeCheck.jrag:1532
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isDestructorArgument
     */
    protected boolean canDefine_isDestructorArgument(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:333
     * @apilevel internal
     */
    public boolean Define_isMultipliedWith(ASTNode _callerNode, ASTNode _childNode, FVariable v) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:333
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isMultipliedWith
     */
    protected boolean canDefine_isMultipliedWith(ASTNode _callerNode, ASTNode _childNode, FVariable v) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     */
    public boolean Define_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:156
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute flattenFASContext
     */
    protected boolean canDefine_flattenFASContext(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     */
    public boolean Define_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\FlatteningAccess.jrag:282
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute canInlineConstant
     */
    protected boolean canDefine_canInlineConstant(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111
     * @apilevel internal
     */
    public boolean Define_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InnerOuter.jrag:111
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isGeneratedInner
     */
    protected boolean canDefine_isGeneratedInner(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90
     * @apilevel internal
     */
    public boolean Define_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:90
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInstRecordConstructorArg
     */
    protected boolean canDefine_isInstRecordConstructorArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108
     * @apilevel internal
     */
    public InstComponentDecl Define_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstFunctionBinding.jrag:108
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupRecordConstructorVirtualInstComponentDecl
     */
    protected boolean canDefine_lookupRecordConstructorVirtualInstComponentDecl(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349
     * @apilevel internal
     */
    public InstClassDecl Define_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupClasses.jrag:349
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstClass
     */
    protected boolean canDefine_lookupConstrainingInstClass(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384
     * @apilevel internal
     */
    public InstComponentDecl Define_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:384
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute lookupConstrainingInstComponent
     */
    protected boolean canDefine_lookupConstrainingInstComponent(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413
     * @apilevel internal
     */
    public InstNode Define_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstLookupComponents.jrag:413
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute findClosestConstrainingInstNode
     */
    protected boolean canDefine_findClosestConstrainingInstNode(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:774
     * @apilevel internal
     */
    public boolean Define_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:774
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inheritsFinal
     */
    protected boolean canDefine_inheritsFinal(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1809
     * @apilevel internal
     */
    public boolean Define_isExpandableConnectorMember(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1809
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isExpandableConnectorMember
     */
    protected boolean canDefine_isExpandableConnectorMember(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1822
     * @apilevel internal
     */
    public InstComponentDecl Define_myExpandableConnectorTemplate(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:1822
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myExpandableConnectorTemplate
     */
    protected boolean canDefine_myExpandableConnectorTemplate(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:476
     * @apilevel internal
     */
    public ResolvedAccess Define_simpleLookupBypassDot(ASTNode _callerNode, ASTNode _childNode, String name) {
        int i = this.getIndexOfChild(_callerNode);
        return getChild(i).simpleLookupHelper(name);
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\source\\SimpleLookup.jrag:476
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute simpleLookupBypassDot
     */
    protected boolean canDefine_simpleLookupBypassDot(ASTNode _callerNode, ASTNode _childNode, String name) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:302
     * @apilevel internal
     */
    public boolean Define_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:302
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isSubExp
     */
    protected boolean canDefine_isSubExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:313
     * @apilevel internal
     */
    public SrcExp Define_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:313
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentExp
     */
    protected boolean canDefine_parentExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:385
     * @apilevel internal
     */
    public Object Define_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:385
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myFunctionArgumentIdentifier
     */
    protected boolean canDefine_myFunctionArgumentIdentifier(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:201
     * @apilevel internal
     */
    public String Define_parentAnnotationName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:201
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentAnnotationName
     */
    protected boolean canDefine_parentAnnotationName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:277
     * @apilevel internal
     */
    public BaseNode Define_parentWithLocation(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        {
            	if (fName != null) {
            		return this;
            	} else {
            		return parentWithLocation();
            	}
            }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:277
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentWithLocation
     */
    protected boolean canDefine_parentWithLocation(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     * @apilevel internal
     */
    public String Define_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return fileName();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveFileName
     */
    protected boolean canDefine_retrieveFileName(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:906
     * @apilevel internal
     */
    public InstComponentDecl Define_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:906
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute enclosingInstComponentDecl
     */
    protected boolean canDefine_enclosingInstComponentDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976
     * @apilevel internal
     */
    public InstAccess Define_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:976
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute getNextInstAccess
     */
    protected boolean canDefine_getNextInstAccess(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038
     * @apilevel internal
     */
    public InstAccess Define_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return pre;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1038
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveTopInstAccess
     */
    protected boolean canDefine_retrieveTopInstAccess(ASTNode _callerNode, ASTNode _childNode, InstAccess pre) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1046
     * @apilevel internal
     */
    public boolean Define_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1046
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inQualified
     */
    protected boolean canDefine_inQualified(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629
     * @apilevel internal
     */
    public FAccessExp Define_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:629
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inlineUsesFunctionCallLeft
     */
    protected boolean canDefine_inlineUsesFunctionCallLeft(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:628
     * @apilevel internal
     */
    public FExp Define_myTopFactorFExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return null;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:628
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute myTopFactorFExp
     */
    protected boolean canDefine_myTopFactorFExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     */
    public boolean Define_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:125
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFunctionCallIO
     */
    protected boolean canDefine_isFunctionCallIO(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131
     * @apilevel internal
     */
    public boolean Define_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:131
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isForIndexExp
     */
    protected boolean canDefine_isForIndexExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:135
     * @apilevel internal
     */
    public boolean Define_isFVectorFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeFunctions.jrag:135
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFVectorFunctionCallArg
     */
    protected boolean canDefine_isFVectorFunctionCallArg(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:86
     * @apilevel internal
     */
    public boolean Define_shouldRewriteToDSRef(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:86
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute shouldRewriteToDSRef
     */
    protected boolean canDefine_shouldRewriteToDSRef(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:751
     * @apilevel internal
     */
    public String Define_parentXmlNamespace(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return xmlNamespace();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:751
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute parentXmlNamespace
     */
    protected boolean canDefine_parentXmlNamespace(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1025
     * @apilevel internal
     */
    public boolean Define_isTopStringOp(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExpressions.jrag:1025
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isTopStringOp
     */
    protected boolean canDefine_isTopStringOp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
