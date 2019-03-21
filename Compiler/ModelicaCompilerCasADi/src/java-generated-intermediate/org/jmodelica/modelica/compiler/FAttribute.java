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
 * Representation of an attribute for a built-in types.
 * 
 * The attributes (start, unit etc.) of the built-in types are represented by
 * objects of the FAttribute class, which in turned are stored in the 
 * FVariables. FAttributes contain information about the attribute name and
 * type, its value, whether it is set explicitly by the user and the prefixes
 * each and final. 
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:388
 * @astdecl FAttribute : BaseNode ::= Type:CommonAccess Name:FIdDecl [Value:FExp] <AttributeSet:boolean> <Level:int> [FEach] [FFinal] FAttribute*;
 * @production FAttribute : {@link BaseNode} ::= <span class="component">Type:{@link CommonAccess}</span> <span class="component">Name:{@link FIdDecl}</span> <span class="component">[Value:{@link FExp}]</span> <span class="component">&lt;AttributeSet:boolean&gt;</span> <span class="component">&lt;Level:int&gt;</span> <span class="component">[{@link FEach}]</span> <span class="component">[{@link FFinal}]</span> <span class="component">{@link FAttribute}*</span>;

 */
public class FAttribute extends BaseNode implements Cloneable, FlatAnnotationProvider, FAttributeListAnnotationNode.FAttributeList {
    /**
     * Apply any binding expressions for record members to a record CValue.
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3370
     */
    public void applyToCValue(VariableEvaluator evaluator, CValueRecord rec, Index i) {
	  if (rec.members().containsKey(name())) {
		  int j = rec.members().get(name());
		  if (hasValue()) {
			  CValue val = getValue().ceval(evaluator);
			  if (i != Index.NULL && rec.getMember(j).size().ndims() + i.ndims() == val.size().ndims())
				  val = val.array().getPart(i);
			  if (!rec.getMember(j).isUnknown())
				  rec.setMember(j, val);
		  } else {
			  if (!rec.getMember(j).isUnknown())
				  rec.getMember(j).applyAttributes(getFAttributes(), i);
		  }
	  }
  }
    /**
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4125
     */
    public Map<CommonVariableDecl,CValue> collectEvaluationValues(Map<CommonVariableDecl,CValue> map) {
        return map;
    }
    /**
     * Create an attribute with only the required children.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:707
     */
    public FAttribute(CommonAccess typeName, FIdDecl name, boolean isSet, int level) {
		this(typeName, name, new Opt(), isSet, level, new Opt(), new Opt(), new List());
	}
    /**
     * Create an attribute with only the required children.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:714
     */
    public FAttribute(String typeName, String name, boolean isSet, int level) {
        this(new FAccessString(typeName), new FIdDecl(name), isSet, level);
    }
    /**
     * Create an attribute with only the required children and a value.
     * 
     * The value may be <code>null</code>, then no value is set.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:723
     */
    public FAttribute(CommonAccess typeName, FIdDecl name, FExp value, boolean isSet, int level) {
		this(typeName, name, 
				(value == null ? new Opt() : new Opt(value)), 
				isSet, level, new Opt(), new Opt(), new List());
	}
    /**
     * Create an attribute with only the required children and a value.
     * 
     * The value may be <code>null</code>, then no value is set.
     * @aspect Constructors
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:734
     */
    public FAttribute(String typeName, String name, FExp value, boolean isSet, int level) {
        this(new FAccessString(typeName), new FIdDecl(name), value, isSet, level);
    }
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1320
     */
    public FAttribute createEmptyNode()         { return new FAttribute(); }
    /**
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2882
     */
    @Override
    public <T extends CommonAccessExp> void findCommonAccessExpsInTree(Set<T> set, CommonAccessExpLookupVisitor<T> visitor) {
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4196
     */
    public void attributeLevels(StringBuilder str) {
        str.append(name());
        str.append(":");
        str.append(getLevel());
        attributeLevelsForList(getFAttributes(), str);
        if (hasValue()) {
            str.append("=");
            str.append(getValue());
        }
    }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:19
     */
    public static final String QUANTITY     = "quantity";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:20
     */
    public static final String UNIT         = "unit";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:21
     */
    public static final String DISPLAY_UNIT = "displayUnit";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:22
     */
    public static final String MIN          = "min";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:23
     */
    public static final String MAX          = "max";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:24
     */
    public static final String START        = "start";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:25
     */
    public static final String FIXED        = "fixed";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:26
     */
    public static final String NOMINAL      = "nominal";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:27
     */
    public static final String STATE_SELECT = "stateSelect";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:28
     */
    public static final String SIZE         = "size()";
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:30
     */
    public static final String STATE_SELECT_TYPE = "StateSelect";
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:78
     */
    @Override
    public FExp annotationValue() {
        return getValue();
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:83
     */
    @Override
    public Iterable<SubNodePair<FlatAnnotationProvider>> annotationSubNodes() {
        return annotationSubNodes(getFAttributes());
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:88
     */
    @Override
    public void setAnnotationValue(FExp newValue) throws FailedToSetAnnotationValueException {
        setValue(newValue);
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:93
     */
    @Override
    public FlatAnnotationProvider addAnnotationSubNode(String name) {
        return addAnnotationSubNode(this, name);
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:99
     */
    @Override
    public boolean isEach() {
        return hasFEach();
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:104
     */
    @Override
    public boolean isFinal() {
        return hasFFinal();
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:170
     */
    
        public static Iterable<SubNodePair<FlatAnnotationProvider>> annotationSubNodes(List<FAttribute> list) {
            return new TransformerIterable<FAttribute, SubNodePair<FlatAnnotationProvider>>(list) {
                @Override
                protected SubNodePair<FlatAnnotationProvider> transform(FAttribute a) {
                    return new SubNodePair<FlatAnnotationProvider>(a.name(), a);
                }
            };
        }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:179
     */
    

        public static FlatAnnotationProvider addAnnotationSubNode(FAttributeListAnnotationNode.FAttributeList list, String name) {
            FAttribute attr = new FAnnotationAttribute(name);
            list.addFAttribute(attr);
            return attr;
        }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1197
     */
    public boolean shouldPrettyPrint(Printer p) {
        if (p.inAnnotation())
            return  isAnnotation();
        return getAttributeSet() && (isModification() || isInternal());

    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1204
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
			
						if (hasFEach())
							str.print("each ");
						if (hasFFinal())
							str.print("final ");	
		    			str.print(getName().name());
		    			getFAttributeList().prettyPrintFAttributeList(str, p);
		    			if (hasValue()) {
		    				str.print(" = ");
	    					p.print(getValue(),str,"");
						}
	}
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2265
     */
    public FAttribute flatten(Flattener f) {
        FAttribute flat = createEmptyNode();
        flat.setType(getType().fullCopy());
        flat.setName(getName().fullCopy());
        if (hasValue())
            flat.setValue(getValue().flatten(f));
        flat.setLevel(getLevel());
        if (hasFEach())
            flat.setFEach(getFEach().fullCopy());
        if (hasFFinal())
            flat.setFFinal(getFFinal().fullCopy());
        List<FAttribute> flatAttrs = new List<FAttribute>();
        for (FAttribute attr : getFAttributes())
            flatAttrs.add(attr.flatten(f));
        flat.setFAttributeList(flatAttrs);
        return flat;
    }
    /**
     * Removing all array-valued attributes.
     * 
     * @return  true if the attribute should be removed
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:336
     */
    public boolean removeArrayValuedAttributes() {
		boolean keep = false;
		List<FAttribute> list = null;
		if (getNumFAttribute() > 0) {
			list = new List<FAttribute>();
			for (FAttribute a : getFAttributes())
				if (!a.removeArrayValuedAttributes())
					list.add(a);
			keep = list.getNumChild() > 0;
		}
		if (hasValue()) {
			if (getValue().isArray()) {
				if (keep)
					setValueOpt(new Opt());
			} else {
				keep = true;
			}
		}
		if (keep && list != null)
			setFAttributeList(list);
		return !keep;
	}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:406
     */
    public void createArrayTemporaries(Scalarizer.Variable s, TypePrefixVariability variability, FType type) {
        type = type.componentType(name());
        if (type.isUnknown()) {
            variability = Variability.FIXEDPARAMETER;
        } else {
            variability = variability.component(name());
        }
        if (hasValue()) {
            getValue().createArrayTemporaries(s.select(variability));
        }
        for (FAttribute fab : getFAttributes()) {
            fab.createArrayTemporaries(s, variability, type);
        }
    }
    /**
     * Copy any attributes with array values to the given list, selecting the scalar value corresponding 
     * to the given index. 
     * 
     * @return  true if any attribute was added to the list 
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:519
     */
    protected boolean addArrayAttributesTo(Scalarizer.Variable s, Index i, List<FAttribute> list) {
		FAttribute match = findMatching(list, getName().name());
		if (match != null) {
			list = match.getFAttributes();
			for (FAttribute a : getFAttributes())
				a.addArrayAttributesTo(s, i, list);
			return false;
		}
		
		boolean isArray = hasValue() && getValue().isArray();
		boolean add = isArray;
		List<FAttribute> subList = null;
		if (add || getNumFAttribute() > 0) {
			subList = new List<FAttribute>();
			for (FAttribute a : getFAttributes())
				add = a.addArrayAttributesTo(s, i, subList) || add;
		}
		if (add) {
			FAttribute res = new FAttribute(getType().fullCopy(), getName().fullCopy(), new Opt(), 
					getAttributeSet(), getLevel(), getFEachOpt().fullCopy(), getFFinalOpt().fullCopy(), subList);
			if (hasValue()) {
				FExp val = getValue();
				if (isArray) {
					if (val.ndims() < i.ndims())
						i = i.subIndex(i.ndims() - val.ndims());
					val = val.getArray().get(i);
				}
                res.setValue(val.scalarize(s.sp));
			}
			list.add(res);
		}
		return add;
	}
    /**
     * Create a copy of the attibute with dimensions removed from all array expressions according 
     * to an index.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:782
     */
    public FAttribute copyForCell(Scalarizer.Variable s, Index i) {
        if (i == Index.NULL)
			return fullCopy();
		FAttribute res = createEmptyNode();
		res.setType(getType().fullCopy());
		res.setName(getName().fullCopy());
        res.setLevel(getLevel());
		if (hasValue()) {
			FExp val = getValue();
			if (val.ndims() < i.ndims() || isInternal())
                val = val.scalarize(s.sp);
			else
				val = val.dynamicFExp(val.splitArrayExp(i).unboundCopy()).scalarize(s.sp);
			res.setValue(val);
		}
		res.setAttributeSet(getAttributeSet());
		if (hasFEach())
			res.setFEach(getFEach().fullCopy());
		if (hasFFinal())
			res.setFFinal(getFFinal().fullCopy());
		for (FAttribute a : getFAttributes())
            res.addFAttribute(a.copyForCell(s, i));
		return res;
	}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:807
     */
    public void scalarize(List<FAttribute> attrs, Index i, Scalarizer s) {
        if (!name().equals(FAttribute.SIZE)) {
            scalarizeInternal(attrs, i, s);
        }
    }
    /**
     * Scalarize the attribute, picking out the specific element from an array 
     * expression or removing "each".
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:816
     */
    public FAttribute scalarizeInternal(List<FAttribute> attrs, Index i, Scalarizer s) {
        FAttribute attr = createEmptyNode();
        List<FAttribute> l = new List<FAttribute>();
        for (FAttribute a : getFAttributes()) {
            a.scalarize(l, i, s);
        }
        attr.setFAttributeList(l);
        attr.setType(getType().fullCopy());
        attr.setName(getName().fullCopy());
        attr.setAttributeSet(getAttributeSet());
        attr.setLevel(getLevel());
        attr.setFFinalOpt(getFFinalOpt().fullCopy());
        if (hasValue()) 
            attr.setValue(scalarizeValue(i, s));
        attrs.add(attr);
        return attr;
    }
    /**
     * Scalarize the attribute and create multiple instances for non-scalar
     * attributes.
     * An attribute is scalarized if it has no value and all its child
     * attributes have value and are of the same size.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:847
     */
    public void scalarize(List<FAttribute> attrs, Scalarizer s) {
        if (hasValue()) {
            scalarizeInternal(attrs, Index.NULL, s);
        } else {
            Size size = null;
            boolean keepScalar = false;
            for (FAttribute attr : getFAttributes()) {
                if (!attr.hasValue())
                    keepScalar = true;
                else if (size == null)
                    size = attr.getValue().size();
                else if (!attr.hasFEach() && !attr.getValue().size().equals(size))
                    keepScalar = true;
            }
            if (size == null || keepScalar)
                size = Size.SCALAR;
            for (Index i : Indices.create(size)) {
                scalarizeInternal(attrs, i, s);
            }
        }
    }
    /**
     * Scalarize the value of this attribute, picking out the specific element from an array 
     * expression.
     * 
     * Returns null if attribute has no value.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:875
     */
    public FExp scalarizeValue(Index i, Scalarizer s) {
        if (!hasValue()) 
            return null;
        if (i.ndims() > getValue().ndims()) {
            i = i.subIndex(i.ndims() - getValue().ndims());
        }
        return getValue().cell(i).scalarize(s);
    }
    /**
     * @declaredat ASTNode:1
     */
    public FAttribute() {
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
        children = new ASTNode[6];
        setChild(Opt.EMPTY, 2);
        setChild(Opt.EMPTY, 3);
        setChild(Opt.EMPTY, 4);
        setChild(List.EMPTY, 5);
    }
    /**
     * @declaredat ASTNode:17
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Type", "Name", "Value", "AttributeSet", "Level", "FEach", "FFinal", "FAttribute"},
        type = {"CommonAccess", "FIdDecl", "Opt<FExp>", "boolean", "int", "Opt<FEach>", "Opt<FFinal>", "List<FAttribute>"},
        kind = {"Child", "Child", "Opt", "Token", "Token", "Opt", "Opt", "List"}
    )
    public FAttribute(CommonAccess p0, FIdDecl p1, Opt<FExp> p2, boolean p3, int p4, Opt<FEach> p5, Opt<FFinal> p6, List<FAttribute> p7) {
        setChild(p0, 0);
        setChild(p1, 1);
        setChild(p2, 2);
        setAttributeSet(p3);
        setLevel(p4);
        setChild(p5, 3);
        setChild(p6, 4);
        setChild(p7, 5);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:33
     */
    protected int numChildren() {
        return 6;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:39
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:43
     */
    public void flushAttrCache() {
        super.flushAttrCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:47
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:51
     */
    public FAttribute clone() throws CloneNotSupportedException {
        FAttribute node = (FAttribute) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FAttribute copy() {
        try {
            FAttribute node = (FAttribute) clone();
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
     * @declaredat ASTNode:75
     */
    @Deprecated
    public FAttribute fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:85
     */
    public FAttribute treeCopyNoTransform() {
        FAttribute tree = (FAttribute) copy();
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
     * @declaredat ASTNode:105
     */
    public FAttribute treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenboolean_AttributeSet == ((FAttribute) node).tokenboolean_AttributeSet) && (tokenint_Level == ((FAttribute) node).tokenint_Level);    
    }
    /**
     * Replaces the Type child.
     * @param node The new node to replace the Type child.
     * @apilevel high-level
     */
    public void setType(CommonAccess node) {
        setChild(node, 0);
    }
    /**
     * Retrieves the Type child.
     * @return The current node used as the Type child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Type")
    public CommonAccess getType() {
        return (CommonAccess) getChild(0);
    }
    /**
     * Retrieves the Type child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Type child.
     * @apilevel low-level
     */
    public CommonAccess getTypeNoTransform() {
        return (CommonAccess) getChildNoTransform(0);
    }
    /**
     * Replaces the Name child.
     * @param node The new node to replace the Name child.
     * @apilevel high-level
     */
    public void setName(FIdDecl node) {
        setChild(node, 1);
    }
    /**
     * Retrieves the Name child.
     * @return The current node used as the Name child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="Name")
    public FIdDecl getName() {
        return (FIdDecl) getChild(1);
    }
    /**
     * Retrieves the Name child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the Name child.
     * @apilevel low-level
     */
    public FIdDecl getNameNoTransform() {
        return (FIdDecl) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the Value child. This is the <code>Opt</code>
     * node containing the child Value, not the actual child!
     * @param opt The new node to be used as the optional node for the Value child.
     * @apilevel low-level
     */
    public void setValueOpt(Opt<FExp> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) Value child.
     * @param node The new node to be used as the Value child.
     * @apilevel high-level
     */
    public void setValue(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional Value child exists.
     * @return {@code true} if the optional Value child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasValue() {
        return getValueOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) Value child.
     * @return The Value child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getValue() {
        return (FExp) getValueOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the Value child. This is the <code>Opt</code> node containing the child Value, not the actual child!
     * @return The optional node for child the Value child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="Value")
    public Opt<FExp> getValueOpt() {
        return (Opt<FExp>) getChild(2);
    }
    /**
     * Retrieves the optional node for child Value. This is the <code>Opt</code> node containing the child Value, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child Value.
     * @apilevel low-level
     */
    public Opt<FExp> getValueOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(2);
    }
    /**
     * Replaces the lexeme AttributeSet.
     * @param value The new value for the lexeme AttributeSet.
     * @apilevel high-level
     */
    public void setAttributeSet(boolean value) {
        tokenboolean_AttributeSet = value;
    }
    /** @apilevel internal 
     */
    protected boolean tokenboolean_AttributeSet;
    /**
     * Retrieves the value for the lexeme AttributeSet.
     * @return The value for the lexeme AttributeSet.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="AttributeSet")
    public boolean getAttributeSet() {
        return tokenboolean_AttributeSet;
    }
    /**
     * Replaces the lexeme Level.
     * @param value The new value for the lexeme Level.
     * @apilevel high-level
     */
    public void setLevel(int value) {
        tokenint_Level = value;
    }
    /** @apilevel internal 
     */
    protected int tokenint_Level;
    /**
     * Retrieves the value for the lexeme Level.
     * @return The value for the lexeme Level.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Level")
    public int getLevel() {
        return tokenint_Level;
    }
    /**
     * Replaces the optional node for the FEach child. This is the <code>Opt</code>
     * node containing the child FEach, not the actual child!
     * @param opt The new node to be used as the optional node for the FEach child.
     * @apilevel low-level
     */
    public void setFEachOpt(Opt<FEach> opt) {
        setChild(opt, 3);
    }
    /**
     * Replaces the (optional) FEach child.
     * @param node The new node to be used as the FEach child.
     * @apilevel high-level
     */
    public void setFEach(FEach node) {
        if (node != null) {
            setChild(new Opt(node), 3);
        } else {
            setChild(Opt.EMPTY, 3);
        }
    }
    /**
     * Check whether the optional FEach child exists.
     * @return {@code true} if the optional FEach child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFEach() {
        return getFEachOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FEach child.
     * @return The FEach child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FEach getFEach() {
        return (FEach) getFEachOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FEach child. This is the <code>Opt</code> node containing the child FEach, not the actual child!
     * @return The optional node for child the FEach child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FEach")
    public Opt<FEach> getFEachOpt() {
        return (Opt<FEach>) getChild(3);
    }
    /**
     * Retrieves the optional node for child FEach. This is the <code>Opt</code> node containing the child FEach, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FEach.
     * @apilevel low-level
     */
    public Opt<FEach> getFEachOptNoTransform() {
        return (Opt<FEach>) getChildNoTransform(3);
    }
    /**
     * Replaces the optional node for the FFinal child. This is the <code>Opt</code>
     * node containing the child FFinal, not the actual child!
     * @param opt The new node to be used as the optional node for the FFinal child.
     * @apilevel low-level
     */
    public void setFFinalOpt(Opt<FFinal> opt) {
        setChild(opt, 4);
    }
    /**
     * Replaces the (optional) FFinal child.
     * @param node The new node to be used as the FFinal child.
     * @apilevel high-level
     */
    public void setFFinal(FFinal node) {
        if (node != null) {
            setChild(new Opt(node), 4);
        } else {
            setChild(Opt.EMPTY, 4);
        }
    }
    /**
     * Check whether the optional FFinal child exists.
     * @return {@code true} if the optional FFinal child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFFinal() {
        return getFFinalOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FFinal child.
     * @return The FFinal child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FFinal getFFinal() {
        return (FFinal) getFFinalOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FFinal child. This is the <code>Opt</code> node containing the child FFinal, not the actual child!
     * @return The optional node for child the FFinal child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FFinal")
    public Opt<FFinal> getFFinalOpt() {
        return (Opt<FFinal>) getChild(4);
    }
    /**
     * Retrieves the optional node for child FFinal. This is the <code>Opt</code> node containing the child FFinal, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FFinal.
     * @apilevel low-level
     */
    public Opt<FFinal> getFFinalOptNoTransform() {
        return (Opt<FFinal>) getChildNoTransform(4);
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 5);
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * @return Number of children in the FAttribute list.
     * @apilevel high-level
     */
    public int getNumFAttribute() {
        return getFAttributeList().getNumChild();
    }
    /**
     * Retrieves the number of children in the FAttribute list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the FAttribute list.
     * @apilevel low-level
     */
    public int getNumFAttributeNoTransform() {
        return getFAttributeListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the FAttribute list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the FAttribute list.
     * @apilevel high-level
     */
    public FAttribute getFAttribute(int i) {
        return (FAttribute) getFAttributeList().getChild(i);
    }
    /**
     * Check whether the FAttribute list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasFAttribute() {
        return getFAttributeList().getNumChild() != 0;
    }
    /**
     * Append an element to the FAttribute list.
     * @param node The element to append to the FAttribute list.
     * @apilevel high-level
     */
    public void addFAttribute(FAttribute node) {
        List<FAttribute> list = (parent == null) ? getFAttributeListNoTransform() : getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the FAttribute list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setFAttribute(FAttribute node, int i) {
        List<FAttribute> list = getFAttributeList();
        if (list == List.EMPTY) {
            setChild(new List(node), 5);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="FAttribute")
    public List<FAttribute> getFAttributeList() {
        List<FAttribute> list = (List<FAttribute>) getChild(5);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(5);
    }
    /**
     * @return the element at index {@code i} in the FAttribute list without
     * triggering rewrites.
     */
    public FAttribute getFAttributeNoTransform(int i) {
        return (FAttribute) getFAttributeListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the FAttribute list.
     * @return The node representing the FAttribute list.
     * @apilevel high-level
     */
    public List<FAttribute> getFAttributes() {
        return getFAttributeList();
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributesNoTransform() {
        return getFAttributeListNoTransform();
    }
    /**
     * Does node match <code>string</code>? Override for node types that 
     * need to be searched for.
     * 
     * Base implementation always returns <code>false</code.
     * Generally, this is implemented with something like 
     * <code>str.equals(name())</code>.
     * 
     * @param str  the string to match
     * @return     <code>true</code if <code>str</code> matches this node, 
     * <code>false</code> otherwise
     * @attribute syn
     * @aspect NodeSearch
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="NodeSearch", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1698")
    public boolean matches(String str) {
        boolean matches_String_value = getName().name().equals(str);
        return matches_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:61
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:61")
    public FAttribute findAttribute(String name) {
        FAttribute findAttribute_String_value = findMatching(getFAttributes(), name);
        return findAttribute_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:332
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:332")
    public String name() {
        String name_value = getName().name();
        return name_value;
    }
    /**
     * Check if this is attribute is generated from a modification.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1948
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1948")
    public boolean isModification() {
        boolean isModification_value = true;
        return isModification_value;
    }
    /**
     * Check if this is an internal generated attribute.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1955
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1955")
    public boolean isInternal() {
        boolean isInternal_value = false;
        return isInternal_value;
    }
    /**
     * Check if this is attribute is genereated from an annotation.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1961
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1961")
    public boolean isAnnotation() {
        boolean isAnnotation_value = false;
        return isAnnotation_value;
    }
    /**
     * Get the annotation node that represents this node when used as an annotation, if 
     * applicable.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:428
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:428")
    public AnnotationNode annotationNode(InstContext instContext) {
        AnnotationNode annotationNode_InstContext_value = new FAttributeAnnotationNode  (this, instContext);
        return annotationNode_InstContext_value;
    }
    /**
     * Check if this attribute is in an FVariable.
     * @attribute inh
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304")
    public boolean isInFV() {
        boolean isInFV_value = getParent().Define_isInFV(this, null);
        return isInFV_value;
    }
    /**
     * Check if this attribute is in a specific FVariable.
     * @attribute inh
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314")
    public boolean isInFV(FVariable fv) {
        boolean isInFV_FVariable_value = getParent().Define_isInFV(this, null, fv);
        return isInFV_FVariable_value;
    }
    /**
     * Check if this attribute is in an FDerivedType.
     * @attribute inh
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324")
    public boolean isInDerivedType() {
        boolean isInDerivedType_value = getParent().Define_isInDerivedType(this, null);
        return isInDerivedType_value;
    }
    /**
     * Check if this attribute is in a specific FDerivedType.
     * @attribute inh
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334")
    public boolean isInDerivedType(FDerivedType t) {
        boolean isInDerivedType_FDerivedType_value = getParent().Define_isInDerivedType(this, null, t);
        return isInDerivedType_FDerivedType_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     */
    public boolean Define_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getValueOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:251
            return true;
        }
        else {
            return getParent().Define_inAttributeValue(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:250
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inAttributeValue
     */
    protected boolean canDefine_inAttributeValue(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
}
