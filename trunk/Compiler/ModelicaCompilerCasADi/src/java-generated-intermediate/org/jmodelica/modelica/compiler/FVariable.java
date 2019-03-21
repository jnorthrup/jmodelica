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
 * A class representing a flattened Modelica variable.
 * 
 * FVariable contains information about the variable's visibility (public
 * or protected), variability (parameter, discrete or continuous) and causality
 * (input or output). In addition, FVariable contains a list of attributes
 * and, optionally, a binding expression. FVariables may represent both array
 * variables and scalar variables: this information is embedded in the 
 * FAccess class.
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:115
 * @astdecl FVariable : FAbstractVariable ::= <VisibilityType:VisibilityType> <TypePrefixVariability:TypePrefixVariability> <TypePrefixInputOutput:TypePrefixInputOutput> FAttribute* <DerivedType:String> [BindingExp:FExp] [FStringComment] FAccess;
 * @production FVariable : {@link FAbstractVariable} ::= <span class="component">&lt;VisibilityType:VisibilityType&gt;</span> <span class="component">&lt;TypePrefixVariability:TypePrefixVariability&gt;</span> <span class="component">&lt;TypePrefixInputOutput:TypePrefixInputOutput&gt;</span> <span class="component">{@link FAttribute}*</span> <span class="component">&lt;DerivedType:String&gt;</span> <span class="component">[BindingExp:{@link FExp}]</span> <span class="component">[{@link FStringComment}]</span> <span class="component">{@link FAccess}</span>;

 */
public abstract class FVariable extends FAbstractVariable implements Cloneable, FDiagnosticsNode, FAttributeListAnnotationNode.FAttributeList {
    /**
     * @aspect InheritedFactoryMethods
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Constructors.jrag:1310
     */
    public abstract FVariable createEmptyNode();
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1099
     */
    public int incrementValueReferenceIndex(Enumerator e) {
        return e.next();
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2718
     */
    @Deprecated
    private FVariable meDifferentiated = null;
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2720
     */
    @Deprecated
    private FVariable meIntegrated = null;
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2723
     */
    @Deprecated
    public void setMeDifferentiated(FVariable var) {
        this.meDifferentiated = var;
    }
    /**
     * This method should only be used during index reduction where we can't
     * use variable lookup to resolve higher and lower order variables!
     * Instead, please use {@link #myDerivativeVariable()} instead!
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2733
     */
    @Deprecated
    public FVariable getMeDifferentiated() {
        return this.meDifferentiated;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2738
     */
    @Deprecated
    public void setMeIntegrated(FVariable var) {
        this.meIntegrated = var;
    }
    /**
     * This method should only be used during index reduction where we can't
     * use variable lookup to resolve higher and lower order variables!
     * Instead, please use {@link #myDifferentiatedVariable()} instead!
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2748
     */
    @Deprecated
    public FVariable getMeIntegrated() {
        return this.meIntegrated;
    }
    /**
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2753
     */
    @Deprecated
    public FVariable getTopIntegrated() {
        FVariable fv = this;
        while (fv.meIntegrated != null)
            fv = fv.meIntegrated;
        return fv;
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4094
     */
    public Set<FVariable> directDependencies() {
        Set<FVariable> res = new LinkedHashSet<FVariable>();
        for (FVariable dv : dependsOn()) {
            if (dv.isInput()) {
                res.add(dv);
            }
        }
        return res;
    }
    /**
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:4182
     */
    public void attributeLevels(StringBuilder str) {
        str.append("  ");
        str.append(name());
        attributeLevelsForList(getFAttributes(), str);
        str.append("\n");
    }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:126
     */
    public void setAttribute(String name, String type, FExp exp) {
        setAttribute(name, type, exp, 0);
    }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:130
     */
    public void setAttribute(String name, String type, FExp exp, int level) {
        FAttribute attr = findMatching(getFAttributes(), name);
        if (attr == null) {
            attr = new FAttribute(new FAccessString(type), new FIdDecl(name), exp, true, level);
            addFAttribute(attr);
        } else {
            attr.setValue(exp);
            attr.setLevel(level);
        }
    }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:141
     */
    public void unsetAttribute(String name) {
        List<FAttribute> newList = new List<FAttribute>();
        for (FAttribute attr : getFAttributes()) {
            if (!attr.matches(name))
                newList.add(attr);
        }
        setFAttributeList(newList);
        flushCache();
    }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:219
     */
    public void setFixedAttribute(boolean value) { setFixedAttribute(FBooleanLitExp.create(value)); }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:220
     */
    public void setFixedAttribute(FExp value)    { setAttribute(FAttribute.FIXED, "Boolean", value); }
    /**
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:238
     */
    public void warnStartAttributeNotSet() {
        if (!ASTNode.printer_C.C_blockResidualAttributePrinter.attributeSet(this, "start"))
            warning("Iteration variable \"" + name() + "\" is missing start value!");
    }
    /**
     * @aspect FlatAnnotations
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAnnotations.jrag:20
     */
    public FlatAnnotation flatAnnotation(String ... path) {         return FlatAnnotation.createFor(this, path); }
    /**
     * Create a pre() expression for this variable.
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1000
     */
    public FPreExp createFPreExp() {
        return new FPreExp(createFAccess());
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1115
     */
    public void prettyPrint(Printer p, CodeStream str, String indent) {
        str.print(indent);
        
        str.print(getTypePrefixVariability());
        
        if (!getTypePrefixInputOutput().isNone()) {
            str.print(getTypePrefixInputOutput(), " ");
        }
        
        str.print(prettyPrintType(), " ", displayName());
    
        getFAttributeList().prettyPrintFAttributeList(str, p);
        
        if (hasBindingExp()) {
            str.print(" = ");
            FExp bindingExp = getBindingExp();
            p.print(bindingExp, str, indent);
            
        }
        
        p.print(getFStringCommentOpt(), str, indent);
        
        getFAttributeList().prettyPrintFAnnotationAttributeList(str, p);

        if (isIndependentParameter() && hasBindingExp()) {
            str.print(" /* ");
            try {
                str.print(getBindingExp().ceval());
            } catch (ConstantEvaluationException e){
                str.print("evaluation error");
            }
            str.print(" */");
        }
    }
    /**
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1150
     */
    public void printFAttributes(CodeStream str, String ... attributes) {
        boolean first = true;
        for (String attribute : attributes) {
            if (attributeSet(attribute)) {
                if (!first) {
                    str.print(',');
                }
                first = false;
                str.print(attribute, "=", attributeExp(attribute));
            }
        }
    }
    /**
     * @aspect PrettyPrint_MC
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:2067
     */
    public void prettyPrint_MC(Printer p, CodeStream str, String indent) {
        str.print(indent, getTypePrefixVariability());
        if (!getTypePrefixInputOutput().isNone()) {
            str.print(getTypePrefixInputOutput(), " ");
        }
        
        str.print(prettyPrintType(), " ", nameUnderscore());
        getFAttributeList().prettyPrintFAttributeList_MC(str,p);
        
        FExp bindingExp = null;
        if (hasBindingExp()) {
            bindingExp = getBindingExp();
        } else if (hasParameterEquation()) {
            bindingExp = ((FEquation) parameterEquation()).getRight();
        }
        if (bindingExp != null) {
            str.print(" = ");
            p.print(bindingExp,str,indent);
        }
        
        p.print(getFStringCommentOpt(), str, indent);

        if (isIndependentParameter() && hasBindingExp()) {
            str.print(" /* ");
            try {
                str.print(getBindingExp().ceval());
            } catch (ConstantEvaluationException e){
                str.print("evaluation error");
            }
            str.print(" */");
        }
    }
    /**
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:385
     */
    public void makeContinuousVariableDiscrete() {
        if (getTypePrefixVariability().continuousVariability())
            setTypePrefixVariability(Variability.DISCRETE);
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1195
     */
    public boolean modifiableInRecord = true;
    /**
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:902
     */
    public FVariable dynamicFVariable(FVariable fv) {
        if (fv == this)
            return fv;
        if (fv.parent != null) {
            int i = fv.parent.getIndexOfChild(fv);
            if (i >= 0)
                return (FVariable) fv.parent.getChild(i);
        }
        getDynamicFVariableOpt().setChild(fv, 0);
        return (FVariable) getDynamicFVariableOpt().getChild(0);
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:133
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        AliasManager.AliasSet set = aliasSet();
        if (type != Global.UseType.ALIAS_ATTRIBUTE_USE && set != null)
            for (AliasManager.AliasVariable alias : set)
                if (alias.getFVariable() != this)
                    alias.getFVariable().markUsedGlobals(Global.UseType.ALIAS_ATTRIBUTE_USE);
        super.markUsedGlobals(type);
    }
    /**
     * Create an expression to serve as argument to a generated algorithm function.
     * 
     * @param init  <code>true</code> if the argument is to initialize an assigned variable
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:942
     */
    public FExp createAlgorithmArgument(boolean init) {
		if (init) {
			if (isDiscrete())
				return createFPreExp();
			if (isContinuous())
				return createStartAttributeExp();
		}
		return createAccessExp();
	}
    /**
     * Create an input representing this variable in a generated algorithm function.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:955
     */
    public FFunctionVariable createFFunctionOutput() {
		return createFFunctionVariable(TypePrefixInputOutput.OUTPUT);
	}
    /**
     * Create an output representing this variable in a generated algorithm function.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:962
     */
    public FFunctionVariable createFFunctionInput() {
		return createFFunctionVariable(TypePrefixInputOutput.INPUT);
	}
    /**
     * Create an function variable representing this variable in a generated algorithm function.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:969
     */
    public FFunctionVariable createFFunctionVariable(TypePrefixInputOutput io) {
		FType type = (FType) type().fullCopy();
		return new FFunctionVariable(io, type, new Opt(), getFAccess().fullCopy());
	}
    /**
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1052
     */
    public FAbstractDerivativeVariable createFDerivativeVariable() {
	    throw new UnsupportedOperationException("Trying to create a derivative variable from the non real variable " + name() + "! Java class type: '" + getClass().getSimpleName() + "'");
	}
    /**
     * Create a pre variable for this variable.
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1126
     */
    abstract public FVariable createPreVariable();
    /**
     * @aspect ReinitStates
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:1725
     */
    public void markAsState() {
        FAttribute newA = new FInternalAttribute(FAttribute.STATE_SELECT, new FEnumLitExp(FAttribute.STATE_SELECT_TYPE, "always"));
        FAttribute oldA = findAttributeLocal(FAttribute.STATE_SELECT);
        if (oldA != null) {
            oldA.replaceMe(newA);
            addFAttribute(oldA);
        } else {
            addFAttribute(newA);
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:227
     */
    public void classifyAliasConstant(AliasManager aliasManager, 
            Map<String, FVariable> firstOccurencesReal, 
            Map<String, FVariable> firstOccurencesNonReal) {
        if (variability().knownParameterOrLess() && hasBindingExp()) {
            Map<String, FVariable> firstOccurences = isReal() ? firstOccurencesReal : firstOccurencesNonReal;
            String s = getBindingExp().toString();
            FVariable first = firstOccurences.get(s);
            if (first != null) {
                aliasManager.addAliasVariables(new AliasPair(first, this, false));
            } else {
                firstOccurences.put(s, this);
            }
        }
    }
    /**
     * Adds this variable to <code>aliasVars</code>, if it is an alias, or 
     * <code>nonAliasVars</code>, if it is not.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:293
     */
    public void aliasSort(ArrayList<FVariable> nonAliasVars, ArrayList<FVariable> aliasVars) {
        if (isAlias()) {
            aliasVars.add(this);
        } else if (aliasSortKeep()) { 
            nonAliasVars.add(this);
            this.propagateAttributesFromAlias();
        }
    }
    /**
     * Inline all non-defining uses of variable, and remove equation defining it.
     * 
     * NB: This assumes that the variable and any equations marked for removal will be removed.
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:568
     */
    public boolean inlineUses() {
        if (!shouldEliminateTemporary()) {
            return false;
        }
		FExp value;
		if (hasBindingExp()) {
			value = getBindingExp();
		} else {
			if (definingUses().isEmpty())
                return nonDefiningUses().isEmpty();
			FAbstractEquation eqn = definingUses().iterator().next().myFEquation();
            if (eqn instanceof FEquation) {
                value = ((FEquation) eqn).getRight();
                eqn.markForRemoval();
            } else if (eqn instanceof FFunctionCallEquation) {
                return inlineUsesFunctionCallLeft();
            } else {
                return false;
            }
        }
        
        if (value.isAccess()) {
            for (FAccessExp use : nonDefiningUses()) {
                FExp copy = value.treeCopy();
                value.asFAccessExp().myFV().nonDefiningUses().add(copy.asFAccessExp());
                value.asFAccessExp().myFV().uses().add(copy.asFAccessExp());
                use.replaceMe(copy);
            }
            value.removeFromUses();
        } else {
            if (nonDefiningUses().isEmpty()) {
                value.removeFromUses();
            }
            value.parent = null;
            for (FAccessExp use : nonDefiningUses()) {
                use.replaceMe(value.unboundCopy());
            }
        }
        return true;
	}
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:609
     */
    public boolean inlineUsesFunctionCallLeft() {
        FAccessExp defineUse = definingUses().iterator().next();
        FExp value;
        if (nonDefiningUses().size() > 0) {
            List<FAbstractEquation> defineEqnList = defineUse.myFEquation().myFAbstractEquationList();
            FAccessExp nonDefineUse = nonDefiningUses().iterator().next();
            value = nonDefineUse.inlineUsesFunctionCallLeft();
            if (value == null || defineEqnList == null || defineEqnList != value.myFEquation().myFAbstractEquationList()) {
                return false;
            }
            value.myFEquation().markForRemoval();
        } else {
            value = new FNoExp();
        }
        
        definingUses().remove(defineUse);
        defineUse.replaceMe(value);
        return true;
    }
    /**
     * Set each attribute of this variable to the most relevant version from the 
     * variables of the alias set.
     * 
     * What is most relevant depends on the attribute, see respective subclass of 
     * AliasManager.AttributePropagator.
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:89
     */
    public void propagateAttributesFromAlias() {
        AliasManager.AliasSet aliasSet = aliasSet();
        if (aliasSet != null) {
            AliasManager.AliasVariable myAv = aliasSet.getModelVariable();
            if (myAv.getFVariable() == this && shouldPropagateAttributesForAlias()) {
                AliasManager.AttributePropagatorMap map = new AliasManager.AttributePropagatorMap(myAv);
                for (AliasManager.AliasVariable av : aliasSet) 
                    if (av.getFVariable() != this) 
                        map.addAlias(av);
                map.propagate();
            }
        }
    }
    /**
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:523
     */
    @Override
    public void variabilityPropagation(
            FClass.VariabilityPropagator propagator,
            TypePrefixVariability variability,
            FExp bindingExp) {
        
        if (variability().lessOrEqual(variability) || !variability.parameterOrLess()) {
            return;
        }
        
        FAbstractEquation equation;
        boolean isZero = variability.constantVariability() && bindingExp.isLiteralZero();
        
        // Uses
        for (FAccessExp use : uses()) {
            if (use.inFEquation()) {
                equation = use.myFEquation();
                propagator.updateEquation(this, equation, variability);
                
                if (isZero) {
                    // Adjust variable set for special case y = 0 * z
                    FExp topFactorExp = use.myTopFactorFExp();
                    if (topFactorExp != null) {
                        Set<FAccessExp> usesInEq = equation.findFAccessExpsInTree();
                        Set<FAccessExp> usesInTop = topFactorExp.findFAccessExpsInTree();
                        usesInEq.removeAll(usesInTop);
                        Set<FVariable> fvsInEq = lookupFVariablesInSet(usesInEq);
                        Set<FVariable> fvsInTop = lookupFVariablesInSet(usesInTop);
                        
                        for (FVariable tFV : fvsInTop) {
                            if (!fvsInEq.contains(tFV)) {
                                propagator.updateEquation(tFV, equation, null);
                            }
                        }
                        
                        topFactorExp.taggedByVProp = true;
                    }
                }
                
                propagator.addWorkEq(equation);
                if (equation.inInitialEquationSection() 
                        && equation.variables().isEmpty()
                        && equation.initialParameters().isEmpty()
                        && equation.parameters().isEmpty()) {
                    // Remove empty initial equation
                    equation.taggedByVProp = Variability.CONSTANT;
                }
            }
        }
        
        boolean wasDiscrete = isDiscrete();
        
        // Declaration
        // TODO: after we have added "dependent parameter that is evaluated" variability, this exception should use that instead
        if (variability.evalTrueParameterVariability()) {
            variability = Variability.STRUCTPARAMETER;
        }
        setTypePrefixVariability(variability);
        if (variability.knownParameterOrLess()) {
            setBindingExp(bindingExp.fullCopy());
        }
        if (variability.fixedParameterOrLess()) {
            if (fixedAttributeSet()) {
                setFixedAttribute(true);
            }
        }
        
        // Pre var
        if (wasDiscrete) {
            FAbstractVariable pre = myPreVariable();
            pre.taggedByVProp = true;
            pre.variabilityPropagation(propagator, variability, bindingExp);
        }
        
        // Derivative
        if (isDifferentiatedVariable()) {
            FAbstractVariable derVar = myDerivativeVariable();
            derVar.taggedByVProp = true;
            derVar.variabilityPropagation(propagator, Variability.CONSTANT, new FIntegerLitExp(0));
        }
        
        // Alias variables
        if (aliasSet() != null) {
            boolean unAlias = (variability.knownParameterOrLess() && propagator.splitAliasConstants()) ||
                    (variability.parameterVariability() && propagator.splitAliasParameters());
            AliasManager.AliasVariable thisAlias = aliasSet().getModelVariable();
            for (AliasManager.AliasVariable av : aliasSet()) {
                FVariable fv = av.getFVariable();
                boolean neg = av.isNegated() ^ thisAlias.isNegated();
                if (fv != this) {
                    fv.setTypePrefixVariability(variability);
                    if (variability.knownParameterOrLess()) {
                        fv.setBindingExp(bindingExp.negated(neg));
                    } else if (unAlias && variability.parameterVariability() && !fv.isTemporary()) {
                        propagator.addEquation(variability, new FEquation(fv.createAccessExp(), createAccessExp().negated(neg)));
                    }
                }
            }
            if (unAlias) {
                myFClass().getAliasManager().unAlias(this);
            }
        }
    }
    /**
     * Scalarize the FVariable and put all scalarized variables in the
     * list vars.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:373
     */
    public void scalarize(Scalarizer.Variable s) {
        try {
            if (size().isZero())
                return;
            createArrayTemporaries(s);
            doScalarize(s);
        } catch (ModelicaException e) {
            throw e;
        } catch (Exception e) {
            throw new org.jmodelica.util.exceptions.InternalCompilerError("Exception caught while scalarizing component'" + name() + "'", e);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:386
     */
    public void doScalarize(Scalarizer.Variable s) {
        for (Index i : indices()) {
            createScalarFVariable(s, i);
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:397
     */
    public void createArrayTemporaries(Scalarizer.Variable s) {
        if (hasBindingExp()) {
            getBindingExp().createArrayTemporaries(s.select(variability()));
        }
        for (FAttribute fab : getFAttributes()) {
            fab.createArrayTemporaries(s, variability(), type());
        }
    }
    /**
     * Create a scalar FVariable for a single cell or an already scalar FVariable.
     * 
     * @param i  the Index of the cell to create an FVariable for. Should be Index.NULL for 
     * already scalar FVariables.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:427
     */
    protected FVariable createScalarFVariable(Scalarizer.Variable s, Index i) {
		// Create new variable and copy fields that should be same
		FVariable fv = createEmptyNode();
		fv.setVisibilityType(getVisibilityType());
		fv.setTypePrefixVariability(getTypePrefixVariability());
		fv.setTypePrefixInputOutput(getTypePrefixInputOutput());
		if (hasFStringComment())
			fv.setFStringComment(getFStringComment().fullCopy());

        fv.setFAccess(scalarizeVariableName(i));

        // Scalarize binding expressions
        if (hasBindingExp()) {
            FExp bexp = getBindingExp().cell(i).scalarize(s.select(variability()));
            if (keepBExp(variability(), getBindingExp())) {
                fv.setBindingExp(bexp);
            } else {
                s.select(variability()).add(setLocationOf(new FAccessExp(scalarizeVariableUse(i))), bexp);
            }
        }

		// Iterate over all attributes and scalarize.
        List<FAttribute> attrs = new List<FAttribute>();
        attrs.addAll(fv.getFAttributes());
        for (FAttribute a : getFAttributes()) {
            a.scalarize(attrs, i, s.sp);
        }
        fv.setFAttributeList(attrs);
		fv.setDerivedType(getDerivedType());
        fv.addArrayAttributesFromType(s, i, myFDerivedType());

		fv.setLocation(this);
		
        s.select(variability()).add(fv);
        return fv;
	}
    /**
     * Create an FAccess for the scalarized variable.
     * Separate method for extensibility.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:468
     */
    protected FAccess scalarizeVariableName(Index i) {
        String name = getFAccess().name();
        if (i.ndims() > 0) {
            name = name + i;
        }
        return new FAccessString(name);
    }
    /**
     * Create an FAccess for the scalarized binding equation.
     * Separate method for extensibility.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:480
     */
    protected FAccess scalarizeVariableUse(Index i) {
        return scalarizeVariableName(i);
    }
    /**
     * Copy any attributes with array values from type, selecting the scalar value corresponding 
     * to the given index. 
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:502
     */
    protected void addArrayAttributesFromType(Scalarizer.Variable s, Index i, FDerivedType t) {
        if (t != null && i != Index.NULL) {
            for (FAttribute a : t.getFAttributes()) {
                List<FAttribute> attrs = new List<FAttribute>();
                attrs.addAll(getFAttributes());
                a.addArrayAttributesTo(s, i, attrs);
                setFAttributeList(attrs);
            }
        }
	}
    /**
     * Generate scalar FVariables for this record or record component.
     * 
     * @param s Scalarization visitor
     * @param bes        Instance representation of this variable
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:559
     */
    public void scalarRecordFVariables(Scalarizer.Variable s, ScalarizingVariableInstance bes) {
        try {
            for (Index i : bes.indices(this)) {
                scalarRecordCellFVariables(s, bes.create(s, i));
            }
        } catch (ModelicaException e) {
            throw e;
        } catch (Exception e) {
            throw new org.jmodelica.util.exceptions.InternalCompilerError("Exception caught while scalarizing component'" + bes.name() + "'", e);
        }
    }
    /**
     * Generate scalar FVariables for a single array cell of this record or record component.
     * 
     * @param s Scalarization visitor
     * @param bes        Instance representation of this variable
     * @param i          the index of this scalar variable in an array, or Index.NULL for scalar components
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:582
     */
    public void scalarRecordCellFVariables(Scalarizer.Variable s, ScalarizingVariableInstance bes) {
        bes.createScalarized(s, this);
    }
    /**
     * Create a copy of the variable with a specific name.
     * 
     * The new variable is marked as scalarized, and if it refers to a specific cell in an array, 
     * then attributes are updated accordingly.
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:747
     */
    public FVariable copyForName(Scalarizer.Variable s, String name, Index cell) {
		FVariable fv = createEmptyNode();
        fv.setFAccess(new FAccessString(name));
		fv.getFAccess().scalarized = true;
		fv.setVisibilityType(getVisibilityType());
		fv.setTypePrefixVariability(getTypePrefixVariability());
		fv.setTypePrefixInputOutput(getTypePrefixInputOutput());
		fv.setDerivedType(getDerivedType());
		if (hasBindingExp())
			fv.setBindingExp(getBindingExp().fullCopy());
		if (hasFStringComment())
			fv.setFStringComment(getFStringComment().fullCopy());
		
		for (FAttribute a : getFAttributes())
			if (!a.isInternal())
                fv.addFAttribute(a.copyForCell(s, cell));
		return fv;
	}
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:33
     */
    
		public static class SortingIndexComparator implements Comparator<FVariable> {
			public int compare(FVariable o1, FVariable o2) {
				return o1.parameterEquation().sortingIndex - o2.parameterEquation().sortingIndex;
			}
		}
    /** 
     * Sorts a list of FVariables according to the sortingIndex of their equation.
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:50
     */
    public static void sortParameters(java.util.List<FVariable> vars) {
		Collections.sort(vars, new SortingIndexComparator());
	}
    /**
     * @aspect ParameterSorting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\SortDependentParameters.jrag:245
     */
    public void removeBindingExp() {
		if (hasBindingExp())
			setBindingExpOpt(new Opt());
	}
    /**
     * Checks if a variable should be exposed in the XML
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:32
     */
    public boolean generateXMLVariable() {
        return !isPreVariable() && !isExternalObject() && (
                !isTemporary() ||
                isDifferentiatedVariable() ||
                isDerivativeVariable() ||
                isInput() ||
                myOptions().getBooleanOption("expose_temp_vars_in_fmu") && uses().size() > 0);
    }
    /**
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:41
     */
    public void generateXMLVariable(CodeStream str, FmiXMLGenerator.Variable gv) {
        gv.generateVariableChildren(str, this);
    }
    /**
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:45
     */
    public void generateXMLVariableIndex(Map<String,Integer> variableIndexMap, Enumerator enumerator) {
        variableIndexMap.put(generateXMLName(), enumerator.next());
    }
    /**
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:65
     */
    public void generateXMLDependencyIndex(Set<Integer> dependencyIndex) {
        dependencyIndex.add(fmiXMLVariableIndex());
    }
    /**
     * Computes and filters the XML indices for the list of provided variables
     * and returns them in a sorted set. The filtering is based on the provided
     * criteria object. If it isn't possible to compute set, then null is
     * returned. This can occur if the set references an non-scalar variable
     * and the set isn't computed for efficiency reasons.
     * 
     * If the provided filter is null, then all dependences will be added to
     * the list.
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:98
     */
    private static Collection<Integer> computeIndicesDependencies(Iterable<FVariable> dependencies, Criteria<FVariable> filter) {
        TreeSet<Integer> dependencyIndex = new TreeSet<Integer>();
        for (FVariable var : dependencies) {
            if (filter == null || filter.test(var)) {
                var.generateXMLDependencyIndex(dependencyIndex);
                if (var.numScalars() > 1) {
                    return null;
                }
            }
        }
        return dependencyIndex;
    }
    /**
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:573
     */
    public void genDecl_XML(XMLGenerator gen, CodeStream str) {
        throw new IllegalArgumentException("FVariable.genDecl_XML() is not implemented for " + getClass().getSimpleName() + "!");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:245
     */
    public TypePrefixVariability.VariabilityCausality_C variabilityCausality_C() {
        return variability().variabilityCausality_C(this);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:296
     */
    protected String name_C(String prefix) {
        return name_C(prefix, Integer.toString(variableIndex()));
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:482
     */
    public void genDestructorCall_C(CodePrinter p, CodeStream str, String indent) {
        throw new UnsupportedOperationException("Method not implemented for class " + getClass().getSimpleName() + "!");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:900
     */
    public void genStartValue_C(CodePrinter p, CodeStream str, String indent) {
        if (shouldGenStartValue()) {
            p.printPreSteps(this, str, indent);
            FExp exp = startValueExp();
            boolean noExp = exp == null;
            Opt bindingExpOpt = null;
            if (noExp) {
                bindingExpOpt = getBindingExpOpt();
                setBindingExp(exp = type().zeroLiteral());
            }
            genAssignment_C(p, str, indent, name_C(), exp, false);
            if (noExp) {
                setBindingExpOpt(bindingExpOpt);
            }
            p.printPostSteps(this, str, indent);
        }
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:930
     */
    public void genAssignment_C(CodePrinter p, CodeStream str, String indent, String name, FExp right,
            boolean neg) {
        str.print(indent);
        if (isString()) {
             str.print("JMI_ASG(STR_Z, ");
             str.print(name);
             str.print(", ");
        } else {
            str.print(name);
            str.print(" = ");
        }
        if (neg) {
            str.print("-");
        }
        str.print("(");
        p.print(right, str, "");
        str.print(")");
        if (isReal() && myOptions().getBooleanOption("enable_variable_scaling")) {
            str.print("/sf(");
            str.print(valueReference());
            str.print(")");
        }
        if (isString()) {
            str.print(")");
        }
        str.print(";\n");
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:168
     */
    public void algorithmInit(CodePrinter.ExecuteCodePrinter p, CodeStream str, String indent) {
        if (isString()) {
            str.print(indent, "JMI_ASG(", assignMacroType(type()), ", ", p.name(this), ", ");
        } else {
            str.print(indent, p.name(this), " = ");
        }
        
        if (isDiscrete()) {
            str.print(p.name(myPreVariable()));
        } else if (isParameter() && hasBindingExp()) {
            p.print(getBindingExp(), str, indent);
        } else {
            FExp e = startAttributeExp();
            if(e == null) {
                str.print("0.0");
            } else {
                p.print(e, str, indent);
            }
        }
        
        if (isString()) {
            str.print(")\n");
        } else {
            str.println(";");
        }
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:895
     */
    public void genBlockResidualValuref_C(CodePrinter p, CodeStream str, String indent, 
            Map<FVariable,String> solverArrayMap) {
        if (valueReference() != -1) 
            str.format("%s%s = %d;\n", indent, solverArrayMap.get(this), valueReference());
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:901
     */
    public void genBlockResidualBoundsCall_C(CodePrinter p, CodeStream str, String indent,
            String func, String msg, Map<FVariable,String> solverArrayMap) {
        boolean min = minAttributeSet();
        boolean max = maxAttributeSet();
        if (min || max) {
            String type = (min && max) ? "bounds" : (max ? "ubound" : "lbound");
            str.format("%s%s_%s(%s, ", indent, func, type, solverArrayMap.get(this));
            if (min)
                str.format("%s, ", attributeExp(FAttribute.MIN).ceval());
            if (max)
                str.format("%s, ", attributeExp(FAttribute.MAX).ceval());
            str.format("\"%s for variable %s\");\n", msg, name());
        }
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:916
     */
    public void genBlockResidualInit_C(CodePrinter p, CodeStream str, String indent,
            Map<FVariable,String> solverArrayMap) {
        str.format("%s%s = %s;\n", indent, solverArrayMap.get(this), name_C());
        genBlockResidualBoundsCall_C(p, str, indent, "init_with", "Resetting initial value", solverArrayMap);
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:922
     */
    public void genBlockResidualEvalInit_C(CodePrinter p, CodeStream str, String indent,
            Map<FVariable,String> solverArrayMap) {
        genBlockResidualBoundsCall_C(p, str, indent, "check", "Out of bounds", solverArrayMap);
        genBlockResidualWriteback_C(p, str, indent, solverArrayMap);
    }
    /**
     * @aspect CCodeGenBlocks
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenBlocks.jrag:928
     */
    public void genBlockResidualWriteback_C(CodePrinter p, CodeStream str, String indent,
            Map<FVariable,String> solverArrayMap) {
        str.format("%s%s = %s;\n", indent, name_C(), solverArrayMap.get(this));
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:554
     */
    ArrayList<String> createFullNestedName(ArrayList<String> parts) {
        if (size().numElements() > 1) {
            ArrayList<String> outList = new ArrayList<String>(size().numElements()*parts.size());
            for (Index ind : size().rangeFArraySubscripts().indices()) {
                outList.addAll(appendStringToAllEntriesInList(parts, "." + name() + ind.toString()));
            }
            return outList;
        } else {
            return appendStringToAllEntriesInList(parts, "." + name());
        }
    }
    /**
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:566
     */
    ArrayList<String> appendStringToAllEntriesInList(ArrayList<String> list, String str) {
        ArrayList<String> outList = new ArrayList<String>(list.size());
        for (String string : list) {
            outList.add(string + str);
        }
        return outList;
    }
    /**
     * @declaredat ASTNode:1
     */
    public FVariable() {
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
        children = new ASTNode[4];
        setChild(List.EMPTY, 0);
        setChild(Opt.EMPTY, 1);
        setChild(Opt.EMPTY, 2);
    }
    /**
     * @declaredat ASTNode:16
     */
    @ASTNodeAnnotation.Constructor(
        name = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "FAttribute", "DerivedType", "BindingExp", "FStringComment", "FAccess"},
        type = {"VisibilityType", "TypePrefixVariability", "TypePrefixInputOutput", "List<FAttribute>", "String", "Opt<FExp>", "Opt<FStringComment>", "FAccess"},
        kind = {"Token", "Token", "Token", "List", "Token", "Opt", "Opt", "Child"}
    )
    public FVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, String p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
    }
    /**
     * @declaredat ASTNode:31
     */
    public FVariable(VisibilityType p0, TypePrefixVariability p1, TypePrefixInputOutput p2, List<FAttribute> p3, beaver.Symbol p4, Opt<FExp> p5, Opt<FStringComment> p6, FAccess p7) {
        setVisibilityType(p0);
        setTypePrefixVariability(p1);
        setTypePrefixInputOutput(p2);
        setChild(p3, 0);
        setDerivedType(p4);
        setChild(p5, 1);
        setChild(p6, 2);
        setChild(p7, 3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:42
     */
    protected int numChildren() {
        return 4;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:48
     */
    public boolean mayHaveRewrite() {
        return false;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:52
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        size_reset();
        isCircular_reset();
        myParameterDependencies_reset();
        isIndependentConstant_reset();
        isDependentConstant_reset();
        isDependentParameter_reset();
        isIndependentParameter_reset();
        isRegularIndependentParameter_reset();
        isStructuralIndependentParameter_reset();
        isFinalIndependentParameter_reset();
        isEvalIndependentParameter_reset();
        isDifferentiatedVariable_reset();
        isLinear_reset();
        myFDerivedType_reset();
        findAttribute_String_reset();
        myFRecordDecl_reset();
        getDynamicFVariableOpt_reset();
        initDependsOn_reset();
        dependsOn_reset();
        myDAEEquationBlock_reset();
        myDAEInitEquationBlock_reset();
        alias_reset();
        derivativeEquivalent_reset();
        name_C_reset();
        asMXVariable_reset();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:81
     */
    public void flushCollectionCache() {
        super.flushCollectionCache();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:85
     */
    public FVariable clone() throws CloneNotSupportedException {
        FVariable node = (FVariable) super.clone();
        return node;
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @deprecated Please use treeCopy or treeCopyNoTransform instead
     * @declaredat ASTNode:96
     */
    @Deprecated
    public abstract FVariable fullCopy();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:104
     */
    public abstract FVariable treeCopyNoTransform();
    /**
     * Create a deep copy of the AST subtree at this node.
     * The subtree of this node is traversed to trigger rewrites before copy.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:112
     */
    public abstract FVariable treeCopy();
    /**
     * Replaces the lexeme VisibilityType.
     * @param value The new value for the lexeme VisibilityType.
     * @apilevel high-level
     */
    public void setVisibilityType(VisibilityType value) {
        tokenVisibilityType_VisibilityType = value;
    }
    /** @apilevel internal 
     */
    protected VisibilityType tokenVisibilityType_VisibilityType;
    /**
     * Retrieves the value for the lexeme VisibilityType.
     * @return The value for the lexeme VisibilityType.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="VisibilityType")
    public VisibilityType getVisibilityType() {
        return tokenVisibilityType_VisibilityType;
    }
    /**
     * Replaces the lexeme TypePrefixVariability.
     * @param value The new value for the lexeme TypePrefixVariability.
     * @apilevel high-level
     */
    public void setTypePrefixVariability(TypePrefixVariability value) {
        tokenTypePrefixVariability_TypePrefixVariability = value;
    }
    /** @apilevel internal 
     */
    protected TypePrefixVariability tokenTypePrefixVariability_TypePrefixVariability;
    /**
     * Retrieves the value for the lexeme TypePrefixVariability.
     * @return The value for the lexeme TypePrefixVariability.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="TypePrefixVariability")
    public TypePrefixVariability getTypePrefixVariability() {
        return tokenTypePrefixVariability_TypePrefixVariability;
    }
    /**
     * Replaces the lexeme TypePrefixInputOutput.
     * @param value The new value for the lexeme TypePrefixInputOutput.
     * @apilevel high-level
     */
    public void setTypePrefixInputOutput(TypePrefixInputOutput value) {
        tokenTypePrefixInputOutput_TypePrefixInputOutput = value;
    }
    /** @apilevel internal 
     */
    protected TypePrefixInputOutput tokenTypePrefixInputOutput_TypePrefixInputOutput;
    /**
     * Retrieves the value for the lexeme TypePrefixInputOutput.
     * @return The value for the lexeme TypePrefixInputOutput.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="TypePrefixInputOutput")
    public TypePrefixInputOutput getTypePrefixInputOutput() {
        return tokenTypePrefixInputOutput_TypePrefixInputOutput;
    }
    /**
     * Replaces the FAttribute list.
     * @param list The new list node to be used as the FAttribute list.
     * @apilevel high-level
     */
    public void setFAttributeList(List<FAttribute> list) {
        setChild(list, 0);
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
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addFAttributeNoTransform(FAttribute node) {
        List<FAttribute> list = getFAttributeListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
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
            setChild(new List(node), 0);
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
        List<FAttribute> list = (List<FAttribute>) getChild(0);
        return list;
    }
    /**
     * Retrieves the FAttribute list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the FAttribute list.
     * @apilevel low-level
     */
    public List<FAttribute> getFAttributeListNoTransform() {
        return (List<FAttribute>) getChildNoTransform(0);
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
     * Replaces the lexeme DerivedType.
     * @param value The new value for the lexeme DerivedType.
     * @apilevel high-level
     */
    public void setDerivedType(String value) {
        tokenString_DerivedType = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_DerivedType;
    /**
     */
    public int DerivedTypestart;
    /**
     */
    public int DerivedTypeend;
    /**
     * JastAdd-internal setter for lexeme DerivedType using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme DerivedType
     * @apilevel internal
     */
    public void setDerivedType(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setDerivedType is only valid for String lexemes");
        tokenString_DerivedType = (String)symbol.value;
        DerivedTypestart = symbol.getStart();
        DerivedTypeend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme DerivedType.
     * @return The value for the lexeme DerivedType.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="DerivedType")
    public String getDerivedType() {
        return tokenString_DerivedType != null ? tokenString_DerivedType : "";
    }
    /**
     * Replaces the optional node for the BindingExp child. This is the <code>Opt</code>
     * node containing the child BindingExp, not the actual child!
     * @param opt The new node to be used as the optional node for the BindingExp child.
     * @apilevel low-level
     */
    public void setBindingExpOpt(Opt<FExp> opt) {
        setChild(opt, 1);
    }
    /**
     * Replaces the (optional) BindingExp child.
     * @param node The new node to be used as the BindingExp child.
     * @apilevel high-level
     */
    public void setBindingExp(FExp node) {
        if (node != null) {
            setChild(new Opt(node), 1);
        } else {
            setChild(Opt.EMPTY, 1);
        }
    }
    /**
     * Check whether the optional BindingExp child exists.
     * @return {@code true} if the optional BindingExp child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasBindingExp() {
        return getBindingExpOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) BindingExp child.
     * @return The BindingExp child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FExp getBindingExp() {
        return (FExp) getBindingExpOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the BindingExp child. This is the <code>Opt</code> node containing the child BindingExp, not the actual child!
     * @return The optional node for child the BindingExp child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="BindingExp")
    public Opt<FExp> getBindingExpOpt() {
        return (Opt<FExp>) getChild(1);
    }
    /**
     * Retrieves the optional node for child BindingExp. This is the <code>Opt</code> node containing the child BindingExp, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child BindingExp.
     * @apilevel low-level
     */
    public Opt<FExp> getBindingExpOptNoTransform() {
        return (Opt<FExp>) getChildNoTransform(1);
    }
    /**
     * Replaces the optional node for the FStringComment child. This is the <code>Opt</code>
     * node containing the child FStringComment, not the actual child!
     * @param opt The new node to be used as the optional node for the FStringComment child.
     * @apilevel low-level
     */
    public void setFStringCommentOpt(Opt<FStringComment> opt) {
        setChild(opt, 2);
    }
    /**
     * Replaces the (optional) FStringComment child.
     * @param node The new node to be used as the FStringComment child.
     * @apilevel high-level
     */
    public void setFStringComment(FStringComment node) {
        if (node != null) {
            setChild(new Opt(node), 2);
        } else {
            setChild(Opt.EMPTY, 2);
        }
    }
    /**
     * Check whether the optional FStringComment child exists.
     * @return {@code true} if the optional FStringComment child exists, {@code false} if it does not.
     * @apilevel high-level
     */
    public boolean hasFStringComment() {
        return getFStringCommentOpt().getNumChild() != 0;
    }
    /**
     * Retrieves the (optional) FStringComment child.
     * @return The FStringComment child, if it exists. Returns {@code null} otherwise.
     * @apilevel low-level
     */
    public FStringComment getFStringComment() {
        return (FStringComment) getFStringCommentOpt().getChild(0);
    }
    /**
     * Retrieves the optional node for the FStringComment child. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * @return The optional node for child the FStringComment child.
     * @apilevel low-level
     */
    @ASTNodeAnnotation.OptChild(name="FStringComment")
    public Opt<FStringComment> getFStringCommentOpt() {
        return (Opt<FStringComment>) getChild(2);
    }
    /**
     * Retrieves the optional node for child FStringComment. This is the <code>Opt</code> node containing the child FStringComment, not the actual child!
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The optional node for child FStringComment.
     * @apilevel low-level
     */
    public Opt<FStringComment> getFStringCommentOptNoTransform() {
        return (Opt<FStringComment>) getChildNoTransform(2);
    }
    /**
     * Replaces the FAccess child.
     * @param node The new node to replace the FAccess child.
     * @apilevel high-level
     */
    public void setFAccess(FAccess node) {
        setChild(node, 3);
    }
    /**
     * Retrieves the FAccess child.
     * @return The current node used as the FAccess child.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Child(name="FAccess")
    public FAccess getFAccess() {
        return (FAccess) getChild(3);
    }
    /**
     * Retrieves the FAccess child.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The current node used as the FAccess child.
     * @apilevel low-level
     */
    public FAccess getFAccessNoTransform() {
        return (FAccess) getChildNoTransform(3);
    }
    /**
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:535")
    public int ndims() {
        int ndims_value = isScalarized()? 0 : getFAccess().declarationNDims();
        return ndims_value;
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
     * Get the array sizes. 
     * @attribute syn
     * @aspect Arrays
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Arrays", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:1157")
    public Size size() {
        ASTState state = state();
        if (size_computed) {
            return size_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        size_value = isScalarized()? Size.SCALAR: getFAccess().declarationSize();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        size_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return size_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3201")
    public CValue ceval(VariableEvaluator evaluator) {
        CValue ceval_VariableEvaluator_value = ceval(evaluator, isParameter());
        return ceval_VariableEvaluator_value;
    }
    /**
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3204
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3204")
    public CValue ceval(VariableEvaluator evaluator, boolean inParameterRecord) {
        {
        		CValue val;
        		if (isForIndex())
        			val = evaluationValue(evaluator);
        		else if (hasParameterEquation())
        			val = parameterEquation().cevalParameter(evaluator, this);
        		else if (hasBindingExp())
        			val = getBindingExp().ceval(evaluator);
        		else
        			val = defaultCValue(evaluator, inParameterRecord);
                if (isReal() && !val.isUnknown()) {
                    val = val.convertReal();
                }
        		return val;
        	}
    }
    /**
     * Constant evaluation of FVariable binding expressions.
     * 
     * If an expression is evaluated in an FClass, then identifiers are 
     * referencing FVariables. The constant value of an FVariable is computed
     * by evaluating the binding expression of the variable, if any. If the
     * FVariable is not a constant or a parameter, or if it has no binding
     * expressions, then a CValueUnknown object is returned.
     * 
     * This version only evaluates a specific cell in an array, and returns 
     * the value for that specific cell.
     * 
     * @return The constant value.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3241")
    public CValue ceval(VariableEvaluator evaluator, Index i) {
        {
                CValue val;
                if (isForIndex())
                    val = evaluationValue(evaluator);
                else if (hasParameterEquation())
                    val = parameterEquation().cevalParameter(evaluator, this, i);
                else if (hasBindingExp())
                    val = getBindingExp().ceval(evaluator, i);
                else
                    val = startAttributeCValue();
                val = val.array().getCell(i);
                if (isReal())
                    val = val.convertReal();
                return val;
            }
    }
    /**
     * Constant eval for variables without any binding expression, or binding equation.
     * Uses the start value for non-records.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3325
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3325")
    public CValue defaultCValue(VariableEvaluator evaluator, boolean inParameterRecord) {
        CValue defaultCValue_VariableEvaluator_boolean_value = startAttributeCValue();
        return defaultCValue_VariableEvaluator_boolean_value;
    }
    /**
     * Constant eval for variables without any binding expression, or binding equation.
     * Uses the start value for non-records.
     * @attribute syn
     * @aspect ConstantEvaluation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3341
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ConstantEvaluation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:3341")
    public CValue defaultCValueCell(VariableEvaluator evaluator, Index i, boolean inParameterRecord) {
        CValue defaultCValueCell_VariableEvaluator_Index_boolean_value = startAttributeCValue();
        return defaultCValueCell_VariableEvaluator_Index_boolean_value;
    }
/** @apilevel internal */
protected ASTState.Cycle isCircular_cycle = null;
    /** @apilevel internal */
    private void isCircular_reset() {
        isCircular_computed = false;
        isCircular_initialized = false;
        isCircular_cycle = null;
    }
    /** @apilevel internal */
    protected boolean isCircular_computed = false;

    /** @apilevel internal */
    protected boolean isCircular_value;
    /** @apilevel internal */
    protected boolean isCircular_initialized = false;
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isCircular=true)
    @ASTNodeAnnotation.Source(aspect="CircularExpressions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluation.jrag:4726")
    public boolean isCircular() {
        if (isCircular_computed) {
            return isCircular_value;
        }
        ASTState state = state();
        if (!isCircular_initialized) {
            isCircular_initialized = true;
            isCircular_value = true;
        }
        if (!state.inCircle() || state.calledByLazyAttribute()) {
            state.enterCircle();
            int _boundaries = state.boundariesCrossed;
            boolean isFinal = this.is$Final();
            do {
                isCircular_cycle = state.nextCycle();
                boolean new_isCircular_value = getFAccess().isCircular() || (hasBindingExp() && getBindingExp().isCircular());
                if (isCircular_value != new_isCircular_value) {
                    state.setChangeInCycle();
                }
                isCircular_value = new_isCircular_value;
            } while (state.testAndClearChangeInCycle());
            if (isFinal && _boundaries == state().boundariesCrossed) {
                isCircular_computed = true;
                state.startLastCycle();
                boolean $tmp = getFAccess().isCircular() || (hasBindingExp() && getBindingExp().isCircular());
            } else {
                state.startResetCycle();
                boolean $tmp = getFAccess().isCircular() || (hasBindingExp() && getBindingExp().isCircular());
                isCircular_computed = false;
                isCircular_initialized = false;
            }
            state.leaveCircle();
        } else if (isCircular_cycle != state.cycle()) {
            isCircular_cycle = state.cycle();
            if (state.lastCycle()) {
                isCircular_computed = true;
                boolean new_isCircular_value = getFAccess().isCircular() || (hasBindingExp() && getBindingExp().isCircular());
                return new_isCircular_value;
            }
            if (state.resetCycle()) {
                isCircular_computed = false;
                isCircular_initialized = false;
                isCircular_cycle = null;
                return isCircular_value;
            }
            boolean new_isCircular_value = getFAccess().isCircular() || (hasBindingExp() && getBindingExp().isCircular());
            if (isCircular_value != new_isCircular_value) {
                state.setChangeInCycle();
            }
            isCircular_value = new_isCircular_value;
        } else {
        }
        return isCircular_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1076
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1076")
    public boolean differentiatedByFDerExp() {
        boolean differentiatedByFDerExp_value = myFClass().differentiatedByFDerExp().contains(this);
        return differentiatedByFDerExp_value;
    }
    /**
     * Calculates the z variability enum for this variable.
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1081
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1081")
    public FClass.ZVariability zVariability() {
        FClass.ZVariability zVariability_value = getTypePrefixVariability().zVariability(this);
        return zVariability_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1097
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1097")
    public FClass.ZOrdinaryCategory zCategory() {
        FClass.ZOrdinaryCategory zCategory_value = FClass.ZOrdinaryCategory.resolve(this);
        return zCategory_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1131
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1131")
    public int aliasValueReference() {
        int aliasValueReference_value = alias() != null ? alias().valueReference() : -1;
        return aliasValueReference_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1133
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1133")
    public int indexInZ() {
        int indexInZ_value = valueReference() & 0x07FFFFFF;
        return indexInZ_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1138
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1138")
    public boolean isConsecutiveInZ(FAbstractVariable fv) {
        boolean isConsecutiveInZ_FAbstractVariable_value = indexInZ() + 1 == fv.indexInZ();
        return isConsecutiveInZ_FAbstractVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1157
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1157")
    public boolean shouldContribute() {
        boolean shouldContribute_value = !isAlias() && !inRecord() && !isForIndex();
        return shouldContribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1479
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1479")
    public int differentiatedRealVariableIndex() {
        int differentiatedRealVariableIndex_value = myFClass().differentiatedRealVariablesList().indexOf(this);
        return differentiatedRealVariableIndex_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1596
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1596")
    public boolean isFixed() {
        boolean isFixed_value = !isInitialParameter() && fixedAttribute();
        return isFixed_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1599
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1599")
    public boolean isInitialParameter() {
        boolean isInitialParameter_value = variability().initialParameterVariability();
        return isInitialParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1752
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1752")
    public int inputIndex() {
        int inputIndex_value = myFClass().inputs().indexOf(this);
        return inputIndex_value;
    }
    /** @apilevel internal */
    private void myParameterDependencies_reset() {
        myParameterDependencies_computed = false;
        
        myParameterDependencies_value = null;
    }
    /** @apilevel internal */
    protected boolean myParameterDependencies_computed = false;

    /** @apilevel internal */
    protected Set<FVariable> myParameterDependencies_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2292
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2292")
    public Set<FVariable> myParameterDependencies() {
        ASTState state = state();
        if (myParameterDependencies_computed) {
            return myParameterDependencies_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myParameterDependencies_value = myParameterDependencies_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myParameterDependencies_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myParameterDependencies_value;
    }
    /** @apilevel internal */
    private Set<FVariable> myParameterDependencies_compute() {
            HashSet<FVariable> varSet = new HashSet<FVariable>();
            if (hasParameterEquation()) {
                for (FVariable vv: parameterEquation().RHSVariables()) {
                    varSet.addAll(vv.myParameterDependencies());
                }
                return varSet;
            } else { //Base case
                varSet.add(this);
                return varSet;
            }
        }
    /** @apilevel internal */
    private void isIndependentConstant_reset() {
        isIndependentConstant_computed = false;
    }
    /** @apilevel internal */
    protected boolean isIndependentConstant_computed = false;

    /** @apilevel internal */
    protected boolean isIndependentConstant_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2391
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2391")
    public boolean isIndependentConstant() {
        ASTState state = state();
        if (isIndependentConstant_computed) {
            return isIndependentConstant_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isIndependentConstant_value = isConstant();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isIndependentConstant_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isIndependentConstant_value;
    }
    /** @apilevel internal */
    private void isDependentConstant_reset() {
        isDependentConstant_computed = false;
    }
    /** @apilevel internal */
    protected boolean isDependentConstant_computed = false;

    /** @apilevel internal */
    protected boolean isDependentConstant_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2392
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2392")
    public boolean isDependentConstant() {
        ASTState state = state();
        if (isDependentConstant_computed) {
            return isDependentConstant_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isDependentConstant_value = false;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isDependentConstant_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isDependentConstant_value;
    }
    /** @apilevel internal */
    private void isDependentParameter_reset() {
        isDependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isDependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isDependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2395
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2395")
    public boolean isDependentParameter() {
        ASTState state = state();
        if (isDependentParameter_computed) {
            return isDependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isDependentParameter_value = isParameter() && !isIndependentParameter();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isDependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isDependentParameter_value;
    }
    /** @apilevel internal */
    private void isIndependentParameter_reset() {
        isIndependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isIndependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isIndependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2399
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2399")
    public boolean isIndependentParameter() {
        ASTState state = state();
        if (isIndependentParameter_computed) {
            return isIndependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isIndependentParameter_value = isParameter() && !isInitialParameter() && !hasParameterEquation() && 
                    (!hasBindingExp() || getBindingExp().isIndependentParameterExp());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isIndependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isIndependentParameter_value;
    }
    /** @apilevel internal */
    private void isRegularIndependentParameter_reset() {
        isRegularIndependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isRegularIndependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isRegularIndependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2403
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2403")
    public boolean isRegularIndependentParameter() {
        ASTState state = state();
        if (isRegularIndependentParameter_computed) {
            return isRegularIndependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isRegularIndependentParameter_value = isIndependentParameter() && !variability().knownParameterOrLess();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isRegularIndependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isRegularIndependentParameter_value;
    }
    /** @apilevel internal */
    private void isStructuralIndependentParameter_reset() {
        isStructuralIndependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isStructuralIndependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isStructuralIndependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2405
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2405")
    public boolean isStructuralIndependentParameter() {
        ASTState state = state();
        if (isStructuralIndependentParameter_computed) {
            return isStructuralIndependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isStructuralIndependentParameter_value = isIndependentParameter() && variability().knownParameterOrLess();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isStructuralIndependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isStructuralIndependentParameter_value;
    }
    /** @apilevel internal */
    private void isFinalIndependentParameter_reset() {
        isFinalIndependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isFinalIndependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isFinalIndependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2407
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2407")
    public boolean isFinalIndependentParameter() {
        ASTState state = state();
        if (isFinalIndependentParameter_computed) {
            return isFinalIndependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isFinalIndependentParameter_value = false;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isFinalIndependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isFinalIndependentParameter_value;
    }
    /** @apilevel internal */
    private void isEvalIndependentParameter_reset() {
        isEvalIndependentParameter_computed = false;
    }
    /** @apilevel internal */
    protected boolean isEvalIndependentParameter_computed = false;

    /** @apilevel internal */
    protected boolean isEvalIndependentParameter_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2409
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2409")
    public boolean isEvalIndependentParameter() {
        ASTState state = state();
        if (isEvalIndependentParameter_computed) {
            return isEvalIndependentParameter_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isEvalIndependentParameter_value = false;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isEvalIndependentParameter_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isEvalIndependentParameter_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2649
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2649")
    public boolean hasParamValueExp() {
        boolean hasParamValueExp_value = hasBindingExp() || startAttributeSet();
        return hasParamValueExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2650
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2650")
    public FExp paramValueExp() {
        FExp paramValueExp_value = hasBindingExp() ? getBindingExp() : startAttributeExp();
        return paramValueExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2652
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2652")
    public boolean isVariable() {
        boolean isVariable_value = !isParameter() && !isConstant();
        return isVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2654
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2654")
    public boolean isFVariable() {
        boolean isFVariable_value = true;
        return isFVariable_value;
    }
    /** @apilevel internal */
    private void isDifferentiatedVariable_reset() {
        isDifferentiatedVariable_computed = false;
    }
    /** @apilevel internal */
    protected boolean isDifferentiatedVariable_computed = false;

    /** @apilevel internal */
    protected boolean isDifferentiatedVariable_value;

    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2664
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2664")
    public boolean isDifferentiatedVariable() {
        ASTState state = state();
        if (isDifferentiatedVariable_computed) {
            return isDifferentiatedVariable_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isDifferentiatedVariable_value = zVariability() == FClass.ZVariability.DIFFERENTIATED;
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isDifferentiatedVariable_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isDifferentiatedVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2673
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2673")
    public FVariable asFVariable() {
        FVariable asFVariable_value = this;
        return asFVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2706
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2706")
    public boolean isAlgebraicVariable() {
        boolean isAlgebraicVariable_value = FClass.ALGEBRAIC_FILTER.testSingle(zCategory());
        return isAlgebraicVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2709
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2709")
    public boolean isDiscreteVariable() {
        boolean isDiscreteVariable_value = zVariability() == FClass.ZVariability.DISCRETE;
        return isDiscreteVariable_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2712
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2712")
    public boolean isAlgebraicContinousRealVariable() {
        boolean isAlgebraicContinousRealVariable_value = zCategory() == FClass.ZOrdinaryCategory.CONTINUOUS;
        return isAlgebraicContinousRealVariable_value;
    }
    /**
     * @attribute syn
     * @aspect ReferencedVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3021
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ReferencedVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3021")
    public Set<FVariable> referencedFVariablesInBindingExp() {
        Set<FVariable> referencedFVariablesInBindingExp_value = lookupFVariablesInSet(getBindingExp().findFAccessExpsInTree());
        return referencedFVariablesInBindingExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatCausality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3118
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatCausality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3118")
    public boolean isInput() {
        boolean isInput_value = getTypePrefixInputOutput().inputCausality();
        return isInput_value;
    }
    /**
     * @attribute syn
     * @aspect FlatCausality
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3120
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatCausality", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3120")
    public boolean isOutput() {
        boolean isOutput_value = getTypePrefixInputOutput().outputCausality();
        return isOutput_value;
    }
    /**
     * Get the differenetiated variabel (FVariable) corresponding to 
     * a derivative variable (FDerivativeVariable)
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3593
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3593")
    public FAbstractVariable myDifferentiatedVariable() {
        {
                if (order() <= 0) {
                    return unknownFVariable();
                } else if (order() == 1) {
                    return getFAccess().myFV();
                } else {
                    return getFAccess().myDerFV(order() - 1);
                }
            }
    }
    /**
     * Get the derivative variabel (FDerivativeVariable) corresponding to 
     * a differentiated variable (FVariable)
     * @attribute syn
     * @aspect FVariableUses
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3607
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FVariableUses", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3607")
    public FAbstractVariable myDerivativeVariable() {
        FAbstractVariable myDerivativeVariable_value = getFAccess().myDerFV(order() + 1);
        return myDerivativeVariable_value;
    }
    /** @apilevel internal */
    private void isLinear_reset() {
        isLinear_computed = false;
    }
    /** @apilevel internal */
    protected boolean isLinear_computed = false;

    /** @apilevel internal */
    protected boolean isLinear_value;

    /**
     * Check linearity of variable.
     * 
     * The attribute isLinear returns true if all uses of the variable appears
     * linearly in equations and in initial equations. Parameters and constants
     * are assumed to be literals in the linearity computation. Accordingly,
     * multiplication of a variable with a parameter or constant does not render
     * the variable nonlinear. Also, parameters and constants are considered
     * to be linear themselves.
     * @attribute syn
     * @aspect LinearFVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3634
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="LinearFVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3634")
    public boolean isLinear() {
        ASTState state = state();
        if (isLinear_computed) {
            return isLinear_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        isLinear_value = isLinear_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        isLinear_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return isLinear_value;
    }
    /** @apilevel internal */
    private boolean isLinear_compute() {
            if (isParameter() || isConstant()) {
                return true;
            }
            for (FAccessExp e : uses()) {
                if (!e.isLinear()) {
                    return false;
                }
            }
            return true;
        }
    /**
     * @attribute syn
     * @aspect FlatDiagnostics
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3883
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatDiagnostics", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3883")
    public int numScalars() {
        int numScalars_value = type().numScalarElements();
        return numScalars_value;
    }
    /** @apilevel internal */
    private void myFDerivedType_reset() {
        myFDerivedType_computed = false;
        
        myFDerivedType_value = null;
    }
    /** @apilevel internal */
    protected boolean myFDerivedType_computed = false;

    /** @apilevel internal */
    protected FDerivedType myFDerivedType_value;

    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:32
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:32")
    public FDerivedType myFDerivedType() {
        ASTState state = state();
        if (myFDerivedType_computed) {
            return myFDerivedType_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFDerivedType_value = findFDerivedType(getDerivedType());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFDerivedType_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFDerivedType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:52
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:52")
    public FAttribute findAttributeLocal(String name) {
        FAttribute findAttributeLocal_String_value = findMatching(getFAttributes(), name);
        return findAttributeLocal_String_value;
    }
    /** @apilevel internal */
    private void findAttribute_String_reset() {
        findAttribute_String_values = null;
    }
    /** @apilevel internal */
    protected java.util.Map findAttribute_String_values;

    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:54
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:54")
    public FAttribute findAttribute(String name) {
        Object _parameters = name;
        if (findAttribute_String_values == null) findAttribute_String_values = new java.util.HashMap(4);
        ASTState state = state();
        if (findAttribute_String_values.containsKey(_parameters)) {
            return (FAttribute) findAttribute_String_values.get(_parameters);
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        FAttribute findAttribute_String_value = findAttribute_compute(name);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        findAttribute_String_values.put(_parameters, findAttribute_String_value);
        
        } else {
        }
        state().leaveLazyAttribute();
        return findAttribute_String_value;
    }
    /** @apilevel internal */
    private FAttribute findAttribute_compute(String name) {
            FAttribute res = findAttributeLocal(name);
            if (res == null && myFDerivedType() != null)
                res = myFDerivedType().findAttribute(name);
            return res;
        }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:65
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:65")
    public boolean attributeSet(FAttribute a) {
        boolean attributeSet_FAttribute_value = (a != null) && a.getAttributeSet();
        return attributeSet_FAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:66
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:66")
    public FExp attributeExp(FAttribute a) {
        FExp attributeExp_FAttribute_value = (a != null && a.hasValue()) ? a.getValue() : null;
        return attributeExp_FAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:67
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:67")
    public boolean attributeSet(String name) {
        boolean attributeSet_String_value = attributeSet(findAttribute(name));
        return attributeSet_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:68
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:68")
    public FExp attributeExp(String name) {
        FExp attributeExp_String_value = attributeExp(findAttribute(name));
        return attributeExp_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:69
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:69")
    public String attributeString(String name) {
        String attributeString_String_value = attributeCValueString(name).stringValue();
        return attributeString_String_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:85
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:85")
    public FAttribute findHierarchicalAttribute(FAccessFull name, int n) {
        FAttribute findHierarchicalAttribute_FAccessFull_int_value = name.findHierarchicalAttribute(getFAccess().asFAccessFull(), this, n);
        return findHierarchicalAttribute_FAccessFull_int_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:100")
    public CValue attributeCValue(String name) {
        {
                FAttribute a = findAttribute(name);
                return attributeSet(a) ? attributeExp(a).ceval() : CValue.UNKNOWN;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:105
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:105")
    public CValue attributeCValueString(String name) {
        {
                FAttribute a = findAttribute(name);
                return (attributeSet(a) ? attributeExp(a).ceval() : new CValueString("")).expandArray(size());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:109
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:109")
    public CValue attributeCValueBoolean(String name, boolean def) {
        {
                FAttribute a = findAttribute(name);
                return (attributeSet(a) ? attributeExp(a).ceval() : new CValueBoolean(def)).expandArray(size());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:113
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:113")
    public CValue attributeCValueReal(String name, double def) {
        {
                FAttribute a = findAttribute(name);
                return (attributeSet(a) ? attributeExp(a).ceval() : new CValueReal(def)).expandArray(size());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:117
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:117")
    public CValue attributeCValueInteger(String name, int def) {
        {
                FAttribute a = findAttribute(name);
                return (attributeSet(a) ? attributeExp(a).ceval() : new CValueInteger(def)).expandArray(size());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:121
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:121")
    public CValue attributeCValueEnum(String name, FType type, int def) {
        {
                FAttribute a = findAttribute(name);
                return (attributeSet(a) ? attributeExp(a).ceval() : new CValueEnum(type, def)).expandArray(size());
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:152
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:152")
    public boolean quantityAttributeSet() {
        boolean quantityAttributeSet_value = attributeSet(FAttribute.QUANTITY);
        return quantityAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:153
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:153")
    public FExp quantityAttributeExp() {
        FExp quantityAttributeExp_value = attributeExp(FAttribute.QUANTITY);
        return quantityAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:154
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:154")
    public CValue quantityAttributeCValue() {
        CValue quantityAttributeCValue_value = attributeCValueString(FAttribute.QUANTITY);
        return quantityAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:155
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:155")
    public String quantityAttribute() {
        String quantityAttribute_value = quantityAttributeCValue().stringValue();
        return quantityAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:158
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:158")
    public boolean unitAttributeSet() {
        boolean unitAttributeSet_value = attributeSet(FAttribute.UNIT);
        return unitAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:159
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:159")
    public FExp unitAttributeExp() {
        FExp unitAttributeExp_value = attributeExp(FAttribute.UNIT);
        return unitAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:160
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:160")
    public CValue unitAttributeCValue() {
        CValue unitAttributeCValue_value = attributeCValueString(FAttribute.UNIT);
        return unitAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:161
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:161")
    public String unitAttribute() {
        String unitAttribute_value = unitAttributeCValue().stringValue();
        return unitAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:164")
    public boolean displayUnitAttributeSet() {
        boolean displayUnitAttributeSet_value = attributeSet(FAttribute.DISPLAY_UNIT);
        return displayUnitAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:165
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:165")
    public FExp displayUnitAttributeExp() {
        FExp displayUnitAttributeExp_value = attributeExp(FAttribute.DISPLAY_UNIT);
        return displayUnitAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:166
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:166")
    public CValue displayUnitAttributeCValue() {
        CValue displayUnitAttributeCValue_value = attributeCValueString(FAttribute.DISPLAY_UNIT);
        return displayUnitAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:167
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:167")
    public String displayUnitAttribute() {
        String displayUnitAttribute_value = displayUnitAttributeCValue().stringValue();
        return displayUnitAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:170
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:170")
    public boolean minAttributeSet() {
        boolean minAttributeSet_value = attributeSet(FAttribute.MIN);
        return minAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:171
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:171")
    public FExp minAttributeExp() {
        FExp minAttributeExp_value = attributeExp(FAttribute.MIN);
        return minAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:180
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:180")
    public boolean maxAttributeSet() {
        boolean maxAttributeSet_value = attributeSet(FAttribute.MAX);
        return maxAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:181
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:181")
    public FExp maxAttributeExp() {
        FExp maxAttributeExp_value = attributeExp(FAttribute.MAX);
        return maxAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:190
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:190")
    public boolean useBindingExpAsStart() {
        boolean useBindingExpAsStart_value = (isIndependentParameter() || variability().knownParameterOrLess()) && hasBindingExp();
        return useBindingExpAsStart_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:193
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:193")
    public boolean startAttributeSet() {
        boolean startAttributeSet_value = attributeSet(FAttribute.START);
        return startAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:194
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:194")
    public FExp startAttributeExp() {
        FExp startAttributeExp_value = attributeExp(FAttribute.START);
        return startAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:195
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:195")
    public FExp createStartAttributeExp() {
        {
                FExp e = startAttributeExp();
                return (e == null) ? startAttributeCValue().buildLiteral() : e.fullCopy();
            }
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:200
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:200")
    public CValue startAttributeCValue() {
        CValue startAttributeCValue_value = CValue.UNKNOWN;
        return startAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:215
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:215")
    public boolean fixedAttributeSet() {
        boolean fixedAttributeSet_value = attributeSet(FAttribute.FIXED);
        return fixedAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:216
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:216")
    public FExp fixedAttributeExp() {
        FExp fixedAttributeExp_value = attributeExp(FAttribute.FIXED);
        return fixedAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:217
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:217")
    public CValue fixedAttributeCValue() {
        CValue fixedAttributeCValue_value = attributeCValueBoolean(FAttribute.FIXED, isParameter() || isConstant());
        return fixedAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:218
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:218")
    public boolean fixedAttribute() {
        boolean fixedAttribute_value = fixedAttributeCValue().reduceBooleanOr();
        return fixedAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:223
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:223")
    public boolean nominalAttributeSet() {
        boolean nominalAttributeSet_value = attributeSet(FAttribute.NOMINAL);
        return nominalAttributeSet_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:224
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:224")
    public FExp nominalAttributeExp() {
        FExp nominalAttributeExp_value = attributeExp(FAttribute.NOMINAL);
        return nominalAttributeExp_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:225
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:225")
    public CValue nominalAttributeCValue() {
        CValue nominalAttributeCValue_value = attributeCValueReal(FAttribute.NOMINAL, 1.0);
        return nominalAttributeCValue_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:226
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:226")
    public double nominalAttribute() {
        double nominalAttribute_value = nominalAttributeCValue().realValue();
        return nominalAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:233")
    public boolean stateSelectAttributeSet() {
        boolean stateSelectAttributeSet_value = attributeSet(FAttribute.STATE_SELECT);
        return stateSelectAttributeSet_value;
    }
    /** @apilevel internal */
    private void myFRecordDecl_reset() {
        myFRecordDecl_computed = false;
        
        myFRecordDecl_value = null;
    }
    /** @apilevel internal */
    protected boolean myFRecordDecl_computed = false;

    /** @apilevel internal */
    protected FRecordDecl myFRecordDecl_value;

    /**
     * @attribute syn
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:290")
    public FRecordDecl myFRecordDecl() {
        ASTState state = state();
        if (myFRecordDecl_computed) {
            return myFRecordDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFRecordDecl_value = containingRecordDecl();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myFRecordDecl_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myFRecordDecl_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:48
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:48")
    public String varKind() {
        {
                if (isIndependentConstant()) {
                    return "ci";
                } else if (isDependentConstant()) {
                    return "cd";
                } else if (isIndependentParameter()) {
                    return "pi";
                } else if (isDependentParameter()) {
                    return "pd";
                } else if (isDifferentiatedVariable()) {
                    return "x";
                } else if (isDerivativeVariable()) {
                    return "dx";
                } else if (isAlgebraicVariable()) {
                    return "w";
                } else if (isInput()) {
                    return "u";
                } else {
                    return "unknown";
                }
            }
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:344")
    public String name() {
        String name_value = getFAccessNoTransform().name();
        return name_value;
    }
    /**
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:418")
    public String nameUnderscore() {
        String nameUnderscore_value = getFAccess().nameUnderscore();
        return nameUnderscore_value;
    }
    /**
     * Create an access expression to this variable.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:962
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:962")
    public FAccessExp createAccessExp() {
        FAccessExp createAccessExp_value = isPreVariable() ? new FPreExp(createFAccess()) : new FAccessExp(createFAccess());
        return createAccessExp_value;
    }
    /**
     * Create an access to this variable.
     * @attribute syn
     * @aspect FlatNames
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:980
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:980")
    public FAccess createFAccess() {
        {
                if (isArray()) {
                    return getFAccess().copyAndAddFas(size().createExpandedFArraySubscripts());
                } else {
                    return getFAccess().treeCopy();
                }
            }
    }
    /**
     * Check if this FVariable contains any active annotation attributes.
     * @attribute syn
     * @aspect AttributeUtil
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1979
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AttributeUtil", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1979")
    public boolean containsActiveAnnotations() {
        {
                if (getNumFAttribute() == 0)
                    return false;
                for (AttributeContributer contributer : attributeContributers())
                    if (contributer.containsActiveAttributes(this))
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1102
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1102")
    public String prettyPrintType() {
        String prettyPrintType_value = getDerivedType().isEmpty() ? type().scalarType().toString() : getDerivedType();
        return prettyPrintType_value;
    }
    /**
     * @attribute syn
     * @aspect FlatPrettyPrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatPrettyPrint", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1104")
    public String displayName() {
        String displayName_value = getFAccess().toString();
        return displayName_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:250
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:250")
    public boolean isConstant() {
        boolean isConstant_value = variability().constantVariability();
        return isConstant_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:251
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:251")
    public boolean isParameter() {
        boolean isParameter_value = variability().parameterVariability();
        return isParameter_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:252
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:252")
    public boolean isDiscrete() {
        boolean isDiscrete_value = variability().discreteVariability();
        return isDiscrete_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:253
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:253")
    public boolean isContinuous() {
        boolean isContinuous_value = variability().continuousVariability();
        return isContinuous_value;
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:406")
    public TypePrefixVariability variability() {
        TypePrefixVariability variability_value = getTypePrefixVariability();
        return variability_value;
    }
    /**
     * Find all reinits and map them to the assigned variable.
     * @attribute syn
     * @aspect ScalarizationErrorCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1728
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ScalarizationErrorCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ErrorCheck.jrag:1728")
    public boolean isReinit() {
        boolean isReinit_value = myFClass().collectReinits().keySet().contains(this);
        return isReinit_value;
    }
    /** @apilevel internal */
    private void getDynamicFVariableOpt_reset() {
        getDynamicFVariableOpt_computed = false;
        
        getDynamicFVariableOpt_value = null;
    }
    /** @apilevel internal */
    protected boolean getDynamicFVariableOpt_computed = false;

    /** @apilevel internal */
    protected Opt getDynamicFVariableOpt_value;

    /**
     * @attribute syn
     * @aspect InstanceTreeConstruction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:855
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN, isNTA=true)
    @ASTNodeAnnotation.Source(aspect="InstanceTreeConstruction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstanceTree.jrag:855")
    public Opt getDynamicFVariableOpt() {
        ASTState state = state();
        if (getDynamicFVariableOpt_computed) {
            return getDynamicFVariableOpt_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        getDynamicFVariableOpt_value = new DynamicOpt();
        getDynamicFVariableOpt_value.setParent(this);
        getDynamicFVariableOpt_value.is$Final = true;
        if (true) {
        getDynamicFVariableOpt_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return getDynamicFVariableOpt_value;
    }
    /**
     * @attribute syn
     * @aspect DerivativeFunctions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeFunctions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\Types.jrag:282")
    public boolean shouldBeDifferentiated() {
        boolean shouldBeDifferentiated_value = variability().continuousVariability();
        return shouldBeDifferentiated_value;
    }
    /**
     * Get the annotation node for this AST node's annotation, if any.
     * 
     * This should be overridden for all nodes that can have annotations.
     * @attribute syn
     * @aspect AnnotationAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AnnotationAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Annotations.jrag:44")
    public AnnotationNode annotation(InstContext instContext) {
        AnnotationNode annotation_InstContext_value = new FAttributeListAnnotationNode(this, instContext);
        return annotation_InstContext_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1230
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1230")
    public boolean isPublic() {
        boolean isPublic_value = getVisibilityType().isPublic();
        return isPublic_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1231
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1231")
    public boolean isProtected() {
        boolean isProtected_value = getVisibilityType().isProtected();
        return isProtected_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1233
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1233")
    public boolean isTemporary() {
        boolean isTemporary_value = getVisibilityType().isTemporary();
        return isTemporary_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1236
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1236")
    public boolean isInterface() {
        boolean isInterface_value = getVisibilityType().isInterface();
        return isInterface_value;
    }
    /**
     * @attribute syn
     * @aspect Visibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1239
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Visibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\util\\Util.jrag:1239")
    public boolean isFromExpandableConnector() {
        boolean isFromExpandableConnector_value = getVisibilityType().isFromExpandableConnector();
        return isFromExpandableConnector_value;
    }
    /**
     * @attribute syn
     * @aspect RuntimeOptions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:104
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="RuntimeOptions", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\RuntimeOptions.jrag:104")
    public boolean isRuntimeOption() {
        boolean isRuntimeOption_value = getVisibilityType().isRuntimeOptionVisibility();
        return isRuntimeOption_value;
    }
    /** @apilevel internal */
    private void initDependsOn_reset() {
        initDependsOn_computed = false;
        
        initDependsOn_value = null;
    }
    /** @apilevel internal */
    protected boolean initDependsOn_computed = false;

    /** @apilevel internal */
    protected Set<FVariable> initDependsOn_value;

    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:345
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:345")
    public Set<FVariable> initDependsOn() {
        ASTState state = state();
        if (initDependsOn_computed) {
            return initDependsOn_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        initDependsOn_value = initDependsOn_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        initDependsOn_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return initDependsOn_value;
    }
    /** @apilevel internal */
    private Set<FVariable> initDependsOn_compute() {
            if (myDAEInitEquationBlock() != null)
                return myDAEInitEquationBlock().dependsOn();
            else
                return new LinkedHashSet<FVariable>();
        }
    /** @apilevel internal */
    private void dependsOn_reset() {
        dependsOn_computed = false;
        
        dependsOn_value = null;
    }
    /** @apilevel internal */
    protected boolean dependsOn_computed = false;

    /** @apilevel internal */
    protected Set<FVariable> dependsOn_value;

    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:352
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:352")
    public Set<FVariable> dependsOn() {
        ASTState state = state();
        if (dependsOn_computed) {
            return dependsOn_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        dependsOn_value = dependsOn_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        dependsOn_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return dependsOn_value;
    }
    /** @apilevel internal */
    private Set<FVariable> dependsOn_compute() {
            if (myDAEEquationBlock() != null)
                return myDAEEquationBlock().dependsOn();
            else
                return new LinkedHashSet<FVariable>();
        }
    /** @apilevel internal */
    private void myDAEEquationBlock_reset() {
        myDAEEquationBlock_computed = false;
        
        myDAEEquationBlock_value = null;
    }
    /** @apilevel internal */
    protected boolean myDAEEquationBlock_computed = false;

    /** @apilevel internal */
    protected AbstractEquationBlock myDAEEquationBlock_value;

    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:359
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:359")
    public AbstractEquationBlock myDAEEquationBlock() {
        ASTState state = state();
        if (myDAEEquationBlock_computed) {
            return myDAEEquationBlock_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myDAEEquationBlock_value = myFClass().getDAEFVariableEquationBlockMap().get(this);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myDAEEquationBlock_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myDAEEquationBlock_value;
    }
    /** @apilevel internal */
    private void myDAEInitEquationBlock_reset() {
        myDAEInitEquationBlock_computed = false;
        
        myDAEInitEquationBlock_value = null;
    }
    /** @apilevel internal */
    protected boolean myDAEInitEquationBlock_computed = false;

    /** @apilevel internal */
    protected AbstractEquationBlock myDAEInitEquationBlock_value;

    /**
     * @attribute syn
     * @aspect TransformCanonical
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:378
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TransformCanonical", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\TransformCanonical.jrag:378")
    public AbstractEquationBlock myDAEInitEquationBlock() {
        ASTState state = state();
        if (myDAEInitEquationBlock_computed) {
            return myDAEInitEquationBlock_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myDAEInitEquationBlock_value = myFClass().getDAEInitFVariableEquationBlockMap().get(this);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        myDAEInitEquationBlock_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return myDAEInitEquationBlock_value;
    }
    /**
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:164
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:164")
    public boolean canBeAlias() {
        boolean canBeAlias_value = !getFAccess().myDerFV(order() + 1).isDummyDerivativeVariable() 
                    && !isPreVariable() && !isNonDummyDerivativeVariable()
                    && !isInput() && !isOutput() && !isIndependentParameter()
                    && !isInterface();
        return canBeAlias_value;
    }
    /**
     * If this is a pre variable of an alias it should be left out/removed.
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:324
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:324")
    public boolean aliasSortKeep() {
        boolean aliasSortKeep_value = !isPreVariable() || !myNonPreVariable().isAlias();
        return aliasSortKeep_value;
    }
    /**
     * Check if this is a temporary variable that should be eliminated.
     * @attribute syn
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:543
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasElimination", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:543")
    public boolean shouldEliminateTemporary() {
        boolean shouldEliminateTemporary_value = isTemporary() && 
                definingUses().size() <= 1 && 
                (nonDefiningUses().size() <= 1 || (definingUses().size() == 1 && definingUses().iterator().next().myFEquation().isOkInlineTemporaries())) && 
                !isPreVariable() && myPreVariable().isUnknown() && 
                (definingUses().isEmpty() || !definingUses().iterator().next().myFEquation().generatesEvents()) && 
                !isDifferentiatedVariable() && !isDerivativeVariable();
        return shouldEliminateTemporary_value;
    }
    /**
     * Check if an FVariable is an alias.
     * 
     * Returns true if alias, else false.
     * 
     * @return True if alias, else false.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:34
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:34")
    public boolean isAlias() {
        boolean isAlias_value = alias() != null;
        return isAlias_value;
    }
    /**
     * Retreives the alias set for this variable or null if not an alias
     * 
     * @return AliasSet that this variable belongs to
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:42
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:42")
    public AliasManager.AliasSet aliasSet() {
        AliasManager.AliasSet aliasSet_value = myFClass().getAliasManager().getAliasSet(this);
        return aliasSet_value;
    }
    /** @apilevel internal */
    private void alias_reset() {
        alias_computed = false;
        
        alias_value = null;
    }
    /** @apilevel internal */
    protected boolean alias_computed = false;

    /** @apilevel internal */
    protected FVariable alias_value;

    /**
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:54
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:54")
    public FVariable alias() {
        ASTState state = state();
        if (alias_computed) {
            return alias_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        alias_value = alias_compute();
        if (isFinal && _boundaries == state().boundariesCrossed) {
        alias_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return alias_value;
    }
    /** @apilevel internal */
    private FVariable alias_compute() {
            AliasManager.AliasSet aliasSet = aliasSet();
            if (aliasSet == null || inRecord()) {
                return null;
            }
            FVariable res = aliasSet.getModelVariable().getFVariable();
            return (res == this) ? null : res;
        }
    /**
     * Returns true if the alias is negated otherwise false.
     * 
     * @return True if negated alias, otherwise false.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:68
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:68")
    public boolean isNegated() {
        {
        		AliasManager aliasManager = myFClass().getAliasManager();
        		AliasManager.AliasVariable alias = aliasManager.getAliasVariable(this);
        		AliasManager.AliasSet aliasSet = alias.getSet();
        		if (alias == null) {
        			return false;
        		} else {
                    AliasManager.AliasVariable iav = aliasSet.getModelVariable();
        			return (alias.isNegated() != iav.isNegated());
        		}
        	}
    }
    /**
     * Should attribute propatation be done for alias sets keeping this variable?
     * 
     * Intended to allow extensions to deactivate alias propagation for some variables.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:108
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:108")
    public boolean shouldPropagateAttributesForAlias() {
        boolean shouldPropagateAttributesForAlias_value = true;
        return shouldPropagateAttributesForAlias_value;
    }
    /**
     * Get the heuristic score for keeping this variable in an alias set.
     * 
     * The variable with the highest score should be kept. Score is always > 0.
     * @attribute syn
     * @aspect AliasVariables
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:923
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AliasVariables", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:923")
    public long aliasHeuristicScore() {
        {
                long score = 0;
                
                // Annotations
                score *= 10;
                if (containsActiveAnnotations()) {
                    score += 1;
                }
                
                score *= 10;
                VisibilityType t = getVisibilityType();
                if (t.isProtected()) {
                    // Some models fail to simulate without this
                    t = VisibilityType.PUBLIC;
                }
                score += t.ordinal();
                
                // Parameter
                score *= 10;
                if (variability().parameterOrLess()) {
                    if (isConstant()) {
                        score += 3;
                    } else if (isIndependentParameter()) {
                        score += 2;
                    } else {
                        score += 1;
                    }
                }
        
                // Stateselect level
                score *= 100;
                FAttribute stateSelectAttribute = findAttribute(FAttribute.STATE_SELECT);
                if (isReal() && stateSelectAttribute != null) {
                    if (!stateSelectAttribute.isInDerivedType()) {
                        score += stateSelectAttribute().ordinal() * 10;
                    } else {
                        score += stateSelectAttribute().ordinal();
                    }
                }
        
                // Fixed attribute == true
                score *= 10;
                if (isFixed()) {
                    score += 1;
                }
        
                // Start attribute set
                score *= 10;
                if (startAttributeSet()) {
                    score += 1;
                }
        
                // Distance to user
                score *= 1000;
                score += 999 - Math.min(getFAccess().numDots(), 999);
        
                // Number of differentiation steps in dummy derivative
                score *= 10;
                score += 9 - Math.min(order(), 9);
                
                return score;
        	}
    }
    /** @apilevel internal */
    private void derivativeEquivalent_reset() {
        derivativeEquivalent_computed = false;
        
        derivativeEquivalent_value = null;
    }
    /** @apilevel internal */
    protected boolean derivativeEquivalent_computed = false;

    /** @apilevel internal */
    protected FVariable derivativeEquivalent_value;

    /**
     * @attribute syn
     * @aspect DerivativeRewriting
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1056
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DerivativeRewriting", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:1056")
    public FVariable derivativeEquivalent() {
        ASTState state = state();
        if (derivativeEquivalent_computed) {
            return derivativeEquivalent_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        derivativeEquivalent_value = myFClass().getAliasManager().derivativeEquivalent(this);
        if (isFinal && _boundaries == state().boundariesCrossed) {
        derivativeEquivalent_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return derivativeEquivalent_value;
    }
    /**
     * @attribute syn
     * @aspect VariabilityPropagation
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:86
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="VariabilityPropagation", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\VariabilityPropagation.jrag:86")
    public boolean canPropagate() {
        boolean canPropagate_value = !isOutput() && !containsActiveAnnotations();
        return canPropagate_value;
    }
    /**
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:254
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:254")
    public boolean isScalarized() {
        boolean isScalarized_value = getFAccess().isScalarized();
        return isScalarized_value;
    }
    /**
     * Check if this FVariable should have a binding exp after scalarization
     * @attribute syn
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:602
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Scalarization", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:602")
    public boolean keepBExp(TypePrefixVariability variability, FExp bexp) {
        boolean keepBExp_TypePrefixVariability_FExp_value = variability.knownParameterOrLess() ||
                    (variability.parameterVariability() && bexp.isIndependentParameterExp());
        return keepBExp_TypePrefixVariability_FExp_value;
    }
    /**
     * @attribute syn
     * @aspect BlockDependencies
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:2771
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BlockDependencies", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\BLT.jrag:2771")
    public Collection<FVariable> bltDependencyVars() {
        Collection<FVariable> bltDependencyVars_value = Collections.singletonList(this);
        return bltDependencyVars_value;
    }
    /**
     * @attribute syn
     * @aspect Derivatives
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:556
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Derivatives", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\Differentiation.jrag:556")
    public int order() {
        int order_value = 0;
        return order_value;
    }
    /**
     * @attribute syn
     * @aspect DynamicStateSelect
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:57
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="DynamicStateSelect", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\DynamicStates.jrag:57")
    public DynamicStateSet dynamicStateSet() {
        DynamicStateSet dynamicStateSet_value = myFClass().getDynamicStateManager().lookupSet(this);
        return dynamicStateSet_value;
    }
    /**
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1316
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1316")
    public FRealVariable.StateSelect stateSelectAttribute() {
        FRealVariable.StateSelect stateSelectAttribute_value = FRealVariable.StateSelect.DEFAULT;
        return stateSelectAttribute_value;
    }
    /**
     * @attribute syn
     * @aspect IndexReduction
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1339
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="IndexReduction", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\structural\\IndexReduction.jrag:1339")
    public StateSelect stateSelection() {
        StateSelect stateSelection_value = getTopIntegrated().stateSelectAttribute();
        return stateSelection_value;
    }
    /**
     * @attribute syn
     * @aspect GenerateEventIndicators
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:578
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="GenerateEventIndicators", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\transformations\\GenerateEventIndicators.jrag:578")
    public boolean isIndicator() {
        {
                for (FAccessExp use : uses()) {
                    if (use.isIndicator()) {
                        return true;
                    }
                }
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect AbsoluteValue
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:24
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="AbsoluteValue", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\AbsoluteValue.jrag:24")
    public boolean isAbsoluteValue() {
        boolean isAbsoluteValue_value = isAbsoluteValue(null);
        return isAbsoluteValue_value;
    }
    /**
     * Returns the variable index in the xml for this variable! Only use this
     * method if you're sure that it is generated in the XML, exception is
     * given if the variable doesn't have any index!
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:54
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:54")
    public int fmiXMLVariableIndex() {
        {
                if (!generateXMLVariable()) {
                    throw new InternalCompilerError("Trying to get xml variable index for variable " + name() + ", this variable is not exposed in xml and does not have an index!");
                }
                Integer index = myFClass().xmlVariableIndexMap().get(generateXMLName());
                if (index == null) {
                    throw new InternalCompilerError("Got null when retrieving xml variable index for variable " + name() + "!");
                }
                return index;
            }
    }
    /**
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:69
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:69")
    public String generateXMLName() {
        String generateXMLName_value = name();
        return generateXMLName_value;
    }
    /**
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:71
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:71")
    public int generateXMLValueReference() {
        int generateXMLValueReference_value = valueReference();
        return generateXMLValueReference_value;
    }
    /**
     * Generate dependency indices for the DAE system. The provided filter is
     * used to determine whether the variable index should be included or not.
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:77
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:77")
    public Iterable<Integer> daeDependencyIndices(Criteria<FVariable> filter) {
        Iterable<Integer> daeDependencyIndices_Criteria_FVariable__value = computeIndicesDependencies(dependsOn(), filter);
        return daeDependencyIndices_Criteria_FVariable__value;
    }
    /**
     * Generate dependency indices for the Init DAE system. The provided filter
     * is used to determine whether the variable index should be included or
     * not.
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:85
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:85")
    public Iterable<Integer> initDAEDependencyIndices(Criteria<FVariable> filter) {
        Iterable<Integer> initDAEDependencyIndices_Criteria_FVariable__value = computeIndicesDependencies(hasParameterEquation() ? myParameterDependencies() : initDependsOn(), filter);
        return initDAEDependencyIndices_Criteria_FVariable__value;
    }
    /**
     * @attribute syn
     * @aspect FmiXML
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:111
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FmiXML", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\FmiXMLCodeGen\\src\\jastadd\\FmiXMLGenerator.jrag:111")
    public FExp generateXMLStartExp() {
        {
                if (useBindingExpAsStart()) 
                    return getBindingExp();
                else if (startAttributeSet() && !isDependentParameter() && !isAlias())
                    return startAttributeExp();
                else if (isInput())
                    return createStartAttributeExp();
                else
                    return null; //Default value
            }
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:535
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:535")
    public String quantity_XML() {
        String quantity_XML_value = quantityAttribute();
        return quantity_XML_value;
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:536
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:536")
    public String unit_XML() {
        String unit_XML_value = unitAttribute();
        return unit_XML_value;
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:537
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:537")
    public String displayUnit_XML() {
        String displayUnit_XML_value = displayUnitAttribute();
        return displayUnit_XML_value;
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:538
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:538")
    public String variability_XML() {
        {
                if (variability().knownParameterOrLess()) {
                    return "constant";
                } else if (isParameter()) {
                    return "parameter";
                } else if (isDiscrete()) {
                    return "discrete";
                } else {
                    //default
                    return "continuous";
                }
            }
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:550
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:550")
    public String causality_XML() {
        {
                if (isInput()) {
                    return "input";
                } else if (isOutput()) {
                    return "output";
                } else {
                    //default
                    return "internal";
                }
            }
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:560
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:560")
    public String alias_XML() {
        {
                if (isAlias()) {
                    if (isNegated()) {
                        return "negatedAlias";
                    } else {
                        return "alias";
                    }
                } else {
                    return "noAlias";
                }
            }
    }
    /**
     * @attribute syn
     * @aspect XMLCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:623
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="XMLCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFMUXBackEnd\\src\\jastadd\\XMLCodeGen.jrag:623")
    public String category_XML() {
        {
                if (isDerivativeVariable()) {
                    return "derivative";
                } else if (isDifferentiatedVariable()) {
                    return "state";
                } else if (isDependentConstant()) {
                    return "dependentConstant";
                } else if (isIndependentConstant()) {
                    return "independentConstant";
                } else if (isDependentParameter()) {
                    return "dependentParameter";
                } else if (isIndependentParameter()) {
                    return "independentParameter";
                } else {
                    return "algebraic";
                }
            }
    }
    /** @apilevel internal */
    private void name_C_reset() {
        name_C_computed = false;
        
        name_C_value = null;
    }
    /** @apilevel internal */
    protected boolean name_C_computed = false;

    /** @apilevel internal */
    protected String name_C_value;

    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:279")
    public String name_C() {
        ASTState state = state();
        if (name_C_computed) {
            return name_C_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        name_C_value = isForIndex() ? 
        										name_C(null, variableIndex() + C_SUFFIX_INDEX) :
        										name_C("");
        if (isFinal && _boundaries == state().boundariesCrossed) {
        name_C_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return name_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:293
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:293")
    public String preName_C() {
        String preName_C_value = name_C("pre");
        return preName_C_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:918
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:918")
    public boolean shouldGenStartValue() {
        {
                FExp exp = startValueExp();
                return !type().isNumeric() || (exp != null && !exp.isZeroLiteral());
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:923
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:923")
    public FExp startValueExp() {
        FExp startValueExp_value = useBindingExpAsStart() ? getBindingExp() : startAttributeExp();
        return startValueExp_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:925
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGen", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:925")
    public boolean hasDependentStartValue() {
        {
                FExp exp = startValueExp();
                return exp != null && !exp.variability().constantVariability();
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenAlgorithms", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:55")
    public String assignMacroType(FType type) {
        String assignMacroType_FType_value = isString() && !inRecord() ? "STR_Z" : super.assignMacroType(type);
        return assignMacroType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect CodeSplitter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CodeSplitter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CodeGen\\CodeSplitter.jrag:196")
    public int numScalars_C() {
        int numScalars_C_value = shouldGenStartValue() ? 1 : 0;
        return numScalars_C_value;
    }
    /**
     * @attribute syn
     * @aspect HTMLMarkupPrinter
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="HTMLMarkupPrinter", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompiler\\src\\jastadd\\DiagnosticsGenerator.jrag:1096")
    public String[][] htmlPrintWrapTagAttributes() {
        {
                return new String[][] {new String[] {"data-varDecl", name()}};
            }
    }
    /** @apilevel internal */
    private void asMXVariable_reset() {
        asMXVariable_computed = false;
        
        asMXVariable_value = null;
    }
    /** @apilevel internal */
    protected boolean asMXVariable_computed = false;

    /** @apilevel internal */
    protected MX asMXVariable_value;

    /**
     * For retrieving the MX representation of this variable.
     * Note that some variables can not be represented as a single MX, e.g.
     * FFunctionArray. These may need to be represented as MXVector.
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:486")
    public MX asMXVariable() {
        ASTState state = state();
        if (asMXVariable_computed) {
            return asMXVariable_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        asMXVariable_value = ifcasadi.msym(name());
        if (isFinal && _boundaries == state().boundariesCrossed) {
        asMXVariable_computed = true;
        
        } else {
        }
        state().leaveLazyAttribute();
        return asMXVariable_value;
    }
    /**
     * Returns the binding expression for this variable if there is one, otherwhise null.
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:579
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:579")
    public MX findMXBindingExpressionIfPresent() {
        {
                return hasBindingExp() ? getBindingExp().toMX() :  (hasParameterEquation() ? parameterEquationToMXBindingExpression() : null);
            }
    }
    /**
     * Creates a binding expression for the parameter equation of this variable.
     * Note that this handles cases where the parameter equation is a function call equation.
     * @return A MX
     * @attribute syn
     * @aspect FExpToCasADi
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:588
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FExpToCasADi", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCompilerCasADi\\src\\jastadd\\FExpToCasADi.jrag:588")
    public MX parameterEquationToMXBindingExpression() {
        {
                if (hasParameterEquation() && parameterEquation().hasFunctionCallEquationsWithLefts()) {
                    // E.g. for the case: parameter Real[2] p2 = function(p1);
                    // Need to find which output from the FFunctionCallEquation that
                    // corresponds to this variable.
                    FFunctionCallEquation feq = (FFunctionCallEquation) parameterEquation();
                    MXVector outs = feq.getCall().toMXVector();
                    int myOutIndex = 0;
                    
                    for (FFunctionCallLeft fleft : feq.getLefts()) {
                        if (fleft.hasFExp()) {
                            MXVector fleftExpAsMXVex = fleft.getFExp().toMXVector();
                            for (int i = 0; i < fleftExpAsMXVex.size(); ++i) {
                                if (fleftExpAsMXVex.get(i).isEqual(asMXVariable())) {
                                    return outs.get(myOutIndex);
                                }
                                myOutIndex++;
                            }
                        }
                    }
                }
                return hasParameterEquation() ? ((FEquation)parameterEquation()).getRight().toMX() : new MX(); 
            }
    }
    /**
     * @attribute inh
     * @aspect FlatAPIAttributes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:36
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatAPIAttributes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:36")
    public FDerivedType findFDerivedType(String name) {
        FDerivedType findFDerivedType_String_value = getParent().Define_findFDerivedType(this, null, name);
        return findFDerivedType_String_value;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     */
    public CommonVariableDecl Define_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAccessNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:692
            return this;
        }
        else {
            return getParent().Define_surroundingVariableDecl(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Arrays.jrag:691
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute surroundingVariableDecl
     */
    protected boolean canDefine_surroundingVariableDecl(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     * @apilevel internal
     */
    public Set<FVariable> Define_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getBindingExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2260
            return Collections.singleton(this);
        }
        else {
            return getParent().Define_boundParameters(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:2259
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute boundParameters
     */
    protected boolean canDefine_boundParameters(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3383
     * @apilevel internal
     */
    public boolean Define_inParamBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getBindingExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3385
            return isParameter();
        }
        else {
            return getParent().Define_inParamBindingExp(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3383
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inParamBindingExp
     */
    protected boolean canDefine_inParamBindingExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387
     * @apilevel internal
     */
    public TypePrefixVariability Define_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getFAttributeListNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3390
            int childIndex = _callerNode.getIndexOfChild(_childNode);
            return Variability.FIXEDPARAMETER;
        }
        else {
            int childIndex = this.getIndexOfChild(_callerNode);
            return variability();
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:3387
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute bindingExpVariability
     */
    protected boolean canDefine_bindingExpVariability(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:304
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     */
    public boolean Define_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return fv == this;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:314
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInFV
     */
    protected boolean canDefine_isInFV(ASTNode _callerNode, ASTNode _childNode, FVariable fv) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:324
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     */
    public boolean Define_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        int childIndex = this.getIndexOfChild(_callerNode);
        return false;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPIAttributes.jrag:334
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute isInDerivedType
     */
    protected boolean canDefine_isInDerivedType(ASTNode _callerNode, ASTNode _childNode, FDerivedType t) {
        return true;
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:595
     * @apilevel internal
     */
    public boolean Define_inKeptBExp(ASTNode _callerNode, ASTNode _childNode) {
        if (_callerNode == getBindingExpOptNoTransform()) {
            // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:597
            return keepBExp(variability(), getBindingExp());
        }
        else {
            return getParent().Define_inKeptBExp(this, _callerNode);
        }
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:595
     * @apilevel internal
     * @return {@code true} if this node has an equation for the inherited attribute inKeptBExp
     */
    protected boolean canDefine_inKeptBExp(ASTNode _callerNode, ASTNode _childNode) {
        return true;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        return super.rewriteTo();
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_variables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1586
        if (!isParameter() && !isConstant() && !isPreVariable() && shouldContribute()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_variables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_aliasVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1645
        if (!isParameter() && !isConstant() && isAlias()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_aliasVariables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_tempVariables(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1664
        if (isTemporary() && shouldContribute()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_tempVariables(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_variablesWithBindingExp(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1721
        if (!isParameter() && !isConstant() && hasBindingExp() && shouldContribute()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_variablesWithBindingExp(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_inputs(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1748
        if (isInput() && shouldContribute()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_inputs(_root, _map);
    }
    /** @apilevel internal */
    protected void collect_contributors_FClass_outputs(FClass _root, java.util.Map<ASTNode, java.util.Set<ASTNode>> _map) {
        // @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1778
        if (isOutput() && shouldContribute()) {
            {
                FClass target = (FClass) (myFClass());
                java.util.Set<ASTNode> contributors = _map.get(target);
                if (contributors == null) {
                    contributors = new java.util.LinkedHashSet<ASTNode>();
                    _map.put((ASTNode) target, contributors);
                }
                contributors.add(this);
            }
        }
        super.collect_contributors_FClass_outputs(_root, _map);
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_variables(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_variables(collection);
        if (!isParameter() && !isConstant() && !isPreVariable() && shouldContribute()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_aliasVariables(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_aliasVariables(collection);
        if (!isParameter() && !isConstant() && isAlias()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_tempVariables(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_tempVariables(collection);
        if (isTemporary() && shouldContribute()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_variablesWithBindingExp(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_variablesWithBindingExp(collection);
        if (!isParameter() && !isConstant() && hasBindingExp() && shouldContribute()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_inputs(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_inputs(collection);
        if (isInput() && shouldContribute()) {
            collection.add(this);
        }
    }
    /** @apilevel internal */
    protected void contributeTo_FClass_outputs(ArrayList<FVariable> collection) {
        super.contributeTo_FClass_outputs(collection);
        if (isOutput() && shouldContribute()) {
            collection.add(this);
        }
    }
}
