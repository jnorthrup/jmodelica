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
 * @astdecl List : ASTNode;
 * @production List : {@link ASTNode};

 */
public class List<T extends ASTNode> extends ASTNode<T> implements Cloneable, Iterable<T> {
    /**
     * Evaluate a list of statements or if-else clauses in a function.
     * 
     * This must be a list of nodes implementing FunctionEvalNode, or an exception will be thrown.
     * 
     * @param values  constant values for the variables.
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:37
     */
    public int evaluateList(AlgorithmEvaluator evaluator) {
        int res = FStatement.EVAL_CONT;
        Iterator<? extends FunctionEvalNode> it = (Iterator<? extends FunctionEvalNode>) iterator();
        while (it.hasNext() && res == FStatement.EVAL_CONT) {
            res = it.next().evaluate(evaluator);
        }
        return res;
    }
    /**
     * Construct a List containing the same nodes as the given Collection.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:37
     */
    public List(Collection<T> nodes) {
		if (!nodes.isEmpty())
			setChild(null, nodes.size() - 1); // Ensure we won't need to increase size later
		int i = 0;
		for (T n : nodes)
			setChild(n, i++);
	}
    /**
     * Prints a list of any type of ASTNode, adding <code>sep</code> between nodes.
     * 
     * Typical use: <code>list.prettyPrintWithSep(p, str, indent, ", ");</code> 
     * (Prints comma-separated list.)
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:174
     */
    public void prettyPrintWithSep(Printer p, CodeStream str, String indent, String sep) {
		String prefix = "";
		for (ASTNode n : this) {
			str.print(prefix);
			p.print(n, str, indent);
			prefix = sep;
		}
	}
    /**
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:183
     */
    public String toString() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		CodeStream str = new CodeStream(os);
		prettyPrintWithSep(prettyPrinter, str, "", ", ");
		return os.toString();
	}
    /**
     * Prints a list of any type of ASTNode, adding <code>prefix</code> before each node and 
     * <code>suffix</code> after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:209
     */
    public void prettyPrintWithFix(Printer p, CodeStream str, String indent, String prefix, String suffix) {
		for (ASTNode n : this) {
			str.print(prefix);
			p.print(n, str, indent);
			str.print(suffix);
		}
	}
    /**
     * Prints a list of any type of ASTNode, adding <code>indent</code> before each node and 
     * <code>suffix</code> plus a line break after after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:233
     */
    public void prettyPrintWithIndent(Printer p, CodeStream str, String indent, String suffix) {
		prettyPrintWithFix(p, str, indent, indent, suffix + str.getLineEnder());
	}
    /**
     * Prints a list of any type of ASTNode, adding <code>indent</code> before each node and 
     * a line break after after each node.
     * @aspect PrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:249
     */
    public void prettyPrintWithIndent(Printer p, CodeStream str, String indent) {
		prettyPrintWithFix(p, str, indent, indent, str.getLineEnder());
	}
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1163
     */
    public void prettyPrintFAttributeList(CodeStream str, Printer p) {
        prettyPrintFAttributeList(str, p, "", "");
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1167
     */
    public void prettyPrintFAnnotationAttributeList(CodeStream str, Printer p) {
        prettyPrintFAnnotationAttributeList(str, p, "");
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1171
     */
    public void prettyPrintFAnnotationAttributeList(CodeStream str, Printer p, String extraEnd) {
        prettyPrintFAnnotationAttributeList(str, p, " ", extraEnd);
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1175
     */
    public void prettyPrintFAnnotationAttributeList(CodeStream str, Printer p, String extraStart, String extraEnd) {
        prettyPrintFAttributeList(str, p.annotationPrinter(), extraStart + "annotation", extraEnd);
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1179
     */
    public void prettyPrintFAttributeList(CodeStream str, Printer p, String extraStart, String extraEnd) {
        boolean firstAttr = true;
        for (ASTNode astNode : this) {
            FAttribute attr = (FAttribute)astNode;
            if (attr.shouldPrettyPrint(p)) {
                if (!firstAttr)	
                    str.print(",");
                else
                    str.print(extraStart, "(");
                firstAttr = false;
                p.print(attr, str, "");
            }
        }
        if (!firstAttr) {
            str.print(")", extraEnd);
        }
    }
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2038
     */
    public void prettyPrintFAttributeList_MC(CodeStream str, Printer p) {
	
	    boolean attrSet = false;
	    	boolean firstAttr = true;
	    	
	    	for (int i=0;i<getNumChild();i++) {
	    		if (((FAttribute)getChild(i)).getAttributeSet() && !((FAttribute)getChild(i)).getName().name().equals("fixed")) {
					attrSet=true;
					break;
	 		   	}
	    	}
	    
	    	if (attrSet){
	    		str.print("(");
	    		for (int i=0;i<getNumChild();i++) {
	    
	    			if (((FAttribute)getChild(i)).getAttributeSet() && !((FAttribute)getChild(i)).getName().name().equals("fixed")) {
	
						if (!firstAttr)	
							str.print(",");
						p.print(((FAttribute)getChild(i)),str,"");
						
						firstAttr = false;
	 		   		}
	    		}
	    		str.print(")");
	   		}
	}
    /**
     * @aspect SizesUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Sizes.jrag:488
     */
    public List copyReplaceAccess(FExp.ContextReplacer crp) {
        List node = new List();
        for (ASTNode ch : this)
            node.add(ch.copyReplaceAccess(crp));
        return node;
    }
    /**
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:187
     */
    public void addAnnotationToEvaluator(ArrayList<AnnotationNode> list, InstNode evaluator) {
        for (ASTNode child : this) {
            child.addAnnotationToEvaluator(list, evaluator);
        }
    }
    /**
     * @aspect SrcAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\SrcAnnotations.jrag:244
     */
    protected ASTNode cleanUpAfterRemove() {
        if (numChildren() == 0) {
            ASTNode parent = getParent();
            replaceMe(List.EMPTY);
            return parent.cleanUpAfterRemove();
        }
        return this;
    }
    /**
     * Creates a new ArrayList containing all the elements in this list, in the same order.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:390
     */
    

	    /**
	     * Creates a new ArrayList containing all the elements in this list, in the same order.
	     */
	    public ArrayList<T> toArrayList() {
	        ArrayList<T> l = new ArrayList<T>(getNumChild());
	        for (T e : this)
	            l.add(e);
	        return l;
	    }
    /**
     * Adds all nodes in an array to the list.
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:408
     */
    
	    
	    /**
	     * Adds all nodes in an iterable to the list.
	     */
//	    public void addAll(Iterable<? extends T> list) {
//	        for (T e : list)
//	            add(e);
//	    }
	    
	    /**
	     * Adds all nodes in an array to the list.
	     */
	     public <S extends T> void addAll(S[] list) {
	         for (S e : list)
	             add(e);
	    }
    /**
     * Replace <code>from</code> with <code>to</code>.
     * 
     * Search through children after <code>from</code>. If it is found, 
     * replace it with <code>to</code> and return <code>true</code>.
     * Comparisons are done with ==, not with equals().
     * @aspect NodeMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:423
     */
    public boolean replaceChild(T oldNode, T newNode) {
    	int n = getNumChildNoTransform();
        for (int i = 0; i < n; i++) {
            if (getChildNoTransform(i) == oldNode) {
                setChild(newNode, i);
                return true;
            }
        }
        return false;
    }
    /**
     * @aspect Names
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:778
     */
    public T lastChildNoTransform() {
	  return getChildNoTransform(getNumChildNoTransform() - 1);
  }
    /**
     * Check if the list contains an instance of the specified class.
     * @aspect DebugHelpers
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:2012
     */
    public boolean containsInstance(Class c) {
		 for (ASTNode n : children)
			 if (c.isInstance(n))
				 return true;
		 return false;
	}
    /**
     * @declaredat ASTNode:1
     */
    public List() {
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
    /**
     * @declaredat ASTNode:12
     */
    public List(T... initialChildren) {
        children = new ASTNode[initialChildren.length];
        for (int i = 0; i < children.length; ++i) {
            addChild(initialChildren[i]);
        }
    }
    /**
     * @declaredat ASTNode:19
     */
    private boolean list$touched = true;
    /**
     * @declaredat ASTNode:21
     */
    public List<T> add(T node) {
        addChild(node);
        return this;
    }
    /**
     * @declaredat ASTNode:26
     */
    public List<T> addAll(Iterable<? extends T> c) {
        for (T node : c) {
            addChild(node);
        }
        return this;
    }
    /**
     * @declaredat ASTNode:33
     */
    public void insertChild(ASTNode node, int i) {
        list$touched = true;
        super.insertChild(node, i);
    }
    /**
     * @declaredat ASTNode:38
     */
    public void addChild(T node) {
        list$touched = true;
        super.addChild(node);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:44
     */
    public void removeChild(int i) {
        list$touched = true;
        super.removeChild(i);
    }
    /**
     * @declaredat ASTNode:49
     */
    public int getNumChild() {
        if (list$touched) {
            for (int i = 0; i < getNumChildNoTransform(); i++) {
                getChild(i);
            }
            list$touched = false;
        }
        return getNumChildNoTransform();
    }
    /** @return an iterator to iterate over elements in this list node. 
     * @declaredat ASTNode:60
     */
    @Override
    public java.util.Iterator<T> iterator() {
        return astChildIterator();
    }
    /**
     * @declaredat ASTNode:64
     */
    protected static final List EMPTY = new List() {
    @Override
    public List add(ASTNode node) {
        throw new Error("attempting to add() on empty List singleton!");
    }
    @Override
    public List addAll(Iterable c) {
        throw new Error("attempting to addAll() on empty List singleton!");
    }
    @Override
    public void insertChild(ASTNode node, int i) {
        throw new Error("attempting to insertChild() on empty List singleton!");
    }
    @Override
    public void addChild(ASTNode node) {
        throw new Error("attempting to addChild() on empty List singleton!");
    }
    @Override
    public void removeChild(int i) {
        throw new Error("attempting to removeChild() on empty List singleton!");
    }
    @Override
    public void setChild(ASTNode child, int pos) {
        throw new Error("attempting to setChild() in empty List singleton!");
    }
 };
    /**
     * @apilevel internal
     * @declaredat ASTNode:93
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:97
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:101
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:105
     */
    public List<T> clone() throws CloneNotSupportedException {
        List node = (List) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    public List<T> copy() {
        try {
            List node = (List) clone();
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
     * @declaredat ASTNode:129
     */
    @Deprecated
    public List<T> fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:139
     */
    public List<T> treeCopyNoTransform() {
        List tree = (List) copy();
        if (children != null) {
            for (int i = 0; i < children.length; ++i) {
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
     * @declaredat ASTNode:159
     */
    public List<T> treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:164
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node);    
    }
    /**
     * @attribute syn
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:43
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:43")
    public Precedence parentPrecedence() {
        Precedence parentPrecedence_value = parent != null ? retrieveParentPrecedence() : Precedence.LOWEST;
        return parentPrecedence_value;
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2363
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2363")
    public boolean inArray() {
        boolean inArray_value = getParent().Define_inArray(this, null);
        return inArray_value;
    }
    /**
     * @attribute inh
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2372
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2372")
    public FType inferredType() {
        FType inferredType_value = getParent().Define_inferredType(this, null);
        return inferredType_value;
    }
    /**
     * @attribute inh
     * @aspect ExpPrecedence
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="ExpPrecedence", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:48")
    public Precedence retrieveParentPrecedence() {
        Precedence retrieveParentPrecedence_value = getParent().Define_retrieveParentPrecedence(this, null);
        return retrieveParentPrecedence_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     */
    public boolean Define_inArray(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return inArray();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2362
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inArray
     */
    protected boolean canDefine_inArray(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     */
    public FType Define_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return inferredType();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:2371
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inferredType
     */
    protected boolean canDefine_inferredType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     */
    public Precedence Define_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return parentPrecedence();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ExpPrecedence.jrag:47
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute retrieveParentPrecedence
     */
    protected boolean canDefine_retrieveParentPrecedence(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876
     * @apilevel internal
     */
    public boolean Define_isFirst(ASTNode _callerNode, ASTNode _childNode) {
        int i = this.getIndexOfChild(_callerNode);
        return i == 0;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1876
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isFirst
     */
    protected boolean canDefine_isFirst(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880
     * @apilevel internal
     */
    public boolean Define_isLast(ASTNode _callerNode, ASTNode _childNode) {
        int i = this.getIndexOfChild(_callerNode);
        return i == getNumChild() - 1;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1880
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isLast
     */
    protected boolean canDefine_isLast(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        if (list$touched) {
            for(int i = 0 ; i < getNumChildNoTransform(); i++) {
                getChild(i);
            }
            list$touched = false;
            return this;
        }
        return super.rewriteTo();
    }
}
