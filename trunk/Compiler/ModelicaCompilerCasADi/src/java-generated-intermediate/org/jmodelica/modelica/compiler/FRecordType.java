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
 * A record type.
 * 
 * In the instance tree, the components are stored alphabetically, 
 * but in the flat tree they are in the order declared. 
 * @ast node
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ast\\FlatModelica.ast:261
 * @astdecl FRecordType : FCellType ::= <Name:String> Component:FRecordComponentType* <FClass:FClass>;
 * @production FRecordType : {@link FCellType} ::= <span class="component">&lt;Name:String&gt;</span> <span class="component">Component:{@link FRecordComponentType}*</span> <span class="component">&lt;FClass:FClass&gt;</span>;

 */
public class FRecordType extends FCellType implements Cloneable {
    /**
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:222
     */
    public CValue assignToPartInFuncEval(CommonNamePart name, CValue left, CValue right) {
        CommonNamePart next = name.nextNamePart();
        if (next == null) {
            return assignToLastInFuncEval(name, left, right);
        }
        
        FType nextType = componentType(next.name(), getComponents());
        if (isArray()) {
            if (left.isUnknown()) {
                left = new CValueArray(size()).markAsCached();
            }
            CValueArray arr = left.array();
            if (name.isArray()) {
                Indices ind = name.indices();
                int rdims = right.size().ndims();
                Size ns = right.size().promote(rdims - ind.ndims());
                Indices nind = Indices.create(ns);
                CValueArray ra = right.array();
                for (Index i : ind) {
                    if (ns != Size.SCALAR) {
                        CValueArray ra2 = new CValueArray(ns);
                        for (Index j : nind) {
                            ra2.setCell(j, ra.getCell(i.expand(j)));
                        }
                        right = ra2;
                    } else {
                        right = ra.getCell(i);
                    }
                    Index j = ind.translate(i);
                    arr.setCell(j, assignToRecPartInFuncEval(next, nextType, arr.getCell(j), right));
                }
            } else {
                Index i = name.getFArraySubscripts().createIndex();
                arr.setCell(i, assignToRecPartInFuncEval(next, nextType, arr.getCell(i), right));
            }
        } else {
            left = assignToRecPartInFuncEval(next, nextType, left, right);
        }
        return left;
    }
    /**
     * Handle one part of the left access of an assignment during function evaluation.
     * @aspect ConstantEvaluationStatements
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ConstantEvaluationStatements.jrag:266
     */
    public CValue assignToRecPartInFuncEval(CommonNamePart next, FType nextType, CValue left,
            CValue right) {
        if (left.isUnknown()) {
            left = new CValueRecord(this).markAsCached();
        }
        CValue val = left.record().getMember(next.name());
        val = nextType.assignToPartInFuncEval(next, val, right);
        left.record().setMember(next.name(), val);
        return left;
    }
    /**
     * @aspect ExternalProcessCommunication
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\ConstantEvaluation\\ExternalConstantEvaluation.jrag:324
     */
    public CValue deserializeScalar(ProcessCommunicator com) throws IOException {
        CValueRecord res = new CValueRecord(this);
        for (FRecordComponentType frct : getComponents()) {
            res.setMember(frct.getName(), frct.getFType().deserialize(com));
        }
        return res;
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1696
     */
    public void createTempCellFVariables(List vars, FAccessString name, TypePrefixVariability variability) {
        for (FRecordComponentType comp : getComponents()) {
            comp.getFType().createTempFVariables(vars, name.copyAndAppend(comp.getName()), variability);
        }
    }
    /**
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1751
     */
    public FVariable createFVariable(VisibilityType vt, FAccess name, 
            TypePrefixVariability variability) {
        return new FRecordVariable(vt, variability, name, new FRecordAccess(getName()));
    }
    /**
     * @aspect TypeStructurePrint
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\PrettyPrint.jrag:1006
     */
    public void printStructure(CodeStream str) {
        str.print(name());
        if (hasComponent()) {
            str.print("(");
            String sep = "";
            for (FRecordComponentType frct : getComponents()) {
                str.print(sep);
                frct.printStructure(str);
                sep = ", ";
            }
            str.print(")");
        }
        if (ndims() > 0) {
            str.print(size());
        }
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:432
     */
    public FType forConstructor(List<? extends HasType> args) {
        FRecordType frt = treeCopy();
        for (int i = 0; i < frt.getNumComponent(); i++) {
            frt.updateComponent(args.getChild(i).type(), i);
        }
        return frt;
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:440
     */
    private void updateComponent(FType type, int i) {
        if (getComponent(i).getFType().isRecord() && type.isRecord()) {
            getComponent(i).setFType(type.treeCopy());
        } else {
            getComponent(i).getFType().transferSizes(type);
        }
    }
    /**
     * @aspect FlatTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:838
     */
    public FType lookupHierarchical(FAccess name, int part, int last) {
        if (part == last) {
            return this;
        }
        FAbstractVariable res = null;
        String pn = name.partName(part);
        for (FRecordComponentType frct : getComponents())
            if (frct.getName().equals(pn))
                return frct.getFType().lookupHierarchical(name, part + 1, last);
        return null;
    }
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1320
     */
    protected boolean recursiveTypeCheck(TypeChecker ch) {
        for (FRecordComponentType c : getComponents())
            if (!c.getFType().recursiveTypeCheck(ch))
                return false;
        return true;
    }
    /**
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1422
     */
    public FExp zeroLiteral()  {
        if (getFClass() != null) {
            List<FExp> args = new List<FExp>();
            for (FRecordComponentType t : getComponents()) {
                args.add(t.getFType().zeroLiteral());
            }
            return new FRecordConstructor(new FRecordAccess(getName()), args);
        } else {
            List<InstFunctionArgument> args = new List<InstFunctionArgument>();
            int i = 1;
            for (FRecordComponentType t : getComponents()) {
                args.add(new InstPositionalArgument(t.getFType().zeroLiteral(), i++));
            }
            return new InstRecordConstructor(new InstGlobalAccess(InstAccess.fromName(getName())), args);
        }
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:766
     */
    public void contentCheckFortranArg(ErrorCheckType checkType, FExternalStmt stmt) {
        stmt.error("Passing records to external fortran functions is not allowed");
    }
    /**
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:788
     */
    public void contentCheckCArg(ErrorCheckType checkType, FExternalStmt stmt) {
        if (!externalValid()) {
            stmt.error("Record type used as input or output to external function can only contain scalar record or scalar simple types");
        }
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:652
     */
    public void updateRecordArraySizes(FType from) {
        super.updateRecordArraySizes(from);
        FRecordType rfrom = (FRecordType) from;
        for (FRecordComponentType comp : getComponents())
            comp.getFType().updateRecordArraySizes(componentType(comp.getName(), rfrom.getComponents()));
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1031
     */
    @Override
    public FType flatten(Flattener f, InstAssignable ia, boolean keepSizeExpressions) {
        List<FRecordComponentType> comps = new List<FRecordComponentType>();
        for (FRecordComponentType frct : getComponents()) {
            comps.add(frct.flatten(f, ia, keepSizeExpressions));
        }
        FRecordType res = new FRecordType(getSize(), getName(), comps, getFClass());
        res.setSize(getSize().flatten(f, res, keepSizeExpressions));
        res.flattened = true;
        return res;
    }
    /**
     * @aspect Flattening
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1066
     */
    private boolean flattened = false;
    /**
     * @aspect FlatExpressions
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:2785
     */
    public void clearFlattened() { flattened = false; super.clearFlattened(); }
    /**
     * @aspect InstTypeAnalysis
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\instance\\InstTypeAnalysis.jrag:152
     */
    public FType componentType(String name) {
        FType res = componentType(name, getComponents());
        return res == null ? super.componentType(name) : res;
    }
    /**
     * @aspect GlobalsCleanup
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Globals.jrag:208
     */
    @Override
    public void markUsedGlobals(Global.UseType type) {
        super.markUsedGlobals(type);
        myFRecordDecl().markUsedGlobals(type);
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:786
     */
    public void addComponentReorderFrom(FRecordType other, Map<String, int[]> map) {
        Map<String,Integer> myOrder = new HashMap<>();
        for (int i = 0, n = getNumComponent(); i < n; i++) {
            myOrder.put(getComponent(i).getName(), i);
        }
        
        int[] order = new int[getNumComponent()];
        boolean different = false;
        for (int i = 0, n = other.getNumComponent(); i < n; i++) {
            int j = myOrder.get(other.getComponent(i).getName());
            order[i] = j;
            if (i != j) {
                different = true;
            }
        }
        
        if (different) {
            map.put(name(), order);
        }
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:818
     */
    public void activateEquivalentRecordUseRewrite() {
        super.activateEquivalentRecordUseRewrite();
        rewriteEquivalentRecord = true;
        is$Final = false;
    }
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:836
     */
    private boolean rewriteEquivalentRecord        = false;
    /**
     * @aspect AliasElimination
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:900
     */
    public void transferSizes(FType t) {
        super.transferSizes(t);
        if (!t.isUnknown() && !t.isNoType()) {
            FRecordType rt = (FRecordType) t;
            for (int i = 0; i < getNumComponent(); i++) {
                getComponent(i).getFType().transferSizes(rt.getComponent(i).getFType());
            }
        }
    }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:942
     */
    public FExp buildFExpCell(ExpFromTypeBuilder b, String suffix) {
         FRecordConstructor frc = new FRecordConstructor(getName());
         for (FRecordComponentType frct : getComponents()) {
             frc.addArg(frct.getFType().buildFExp(b, suffix + "." + frct.getName()));
         }
         return frc;
     }
    /**
     * @aspect FunctionInlining
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\InlineFunctions.jrag:1791
     */
    public FType replaceReferences(AbstractFunctionInliner fi) {
        super.replaceReferences(fi);
        for (FRecordComponentType frct : getComponents()) {
            frct.getFType().replaceReferences(fi);
        }
        return this;
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1026
     */
    @Override
    public void scalarRecordClauses(Scalarizer s, FAccess suffix, FExp left, FExp right) {
        for (FRecordComponentType comp : getComponents()) {
            if (!isArray() && left.inFunction() && suffix.isEmpty() && left.myFClass().noUnrollingInFunctions()) {
                String name = comp.getName();
                comp.getFType().scalarizeAssignment((Scalarizer.Algorithm) s, left.component(name).asCommonAccessExp(), right.component(name));
            } else {
                FAccess next = suffix.copyAndAppend(comp.getName()).asFAccessFull();
                comp.getFType().scalarRecordComponentClauses(s, next, left, right);
            }
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1316
     */
    public void addDummyEqnsForTemp(List<FAbstractEquation> l, String name) {
        if (isArray()) {
            super.addDummyEqnsForTemp(l, name);
        } else {
            for (FRecordComponentType comp : getComponents())
                comp.getFType().addDummyEqnsForTemp(l, name + '.' + comp.getName());
        }
    }
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1415
     */
    public FExp createRecordConstructorCell(Scalarizer s, FExp exp) {
		FRecordConstructor rc = new FRecordConstructor(new FRecordAccess(getName()), new List());
		for (FRecordComponentType comp : getComponents()) {
             FExp next = exp.scalarRecordFExp(s, comp.getName());
             if (exp.type().isUnknown() || exp.useTempVar) {
                 // Work around for expanding FTempAccessExp which doesnt know its type
                 next = comp.getFType().createRecordConstructor(s, exp.dynamicFExp(next));
             }
             rc.addArg(next);
		}
		return rc;
	}
    /**
     * @aspect Scalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\Scalarization.jrag:1835
     */
    @Override
    public FType scalarize(Scalarizer s, FExp context) {
        List<FRecordComponentType> comps = new List<FRecordComponentType>();
        for (FRecordComponentType frct : getComponents()) {
            comps.add(frct.scalarize(s, context));
        }
        FRecordType res = new FRecordType(getSize(), getName(), comps, getFClass());
        res.setSize(getSize().scalarize(s, context));
        return res;
    }
    /**
     * @aspect AssignmentScalarization
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\scalarization\\ScalarizeAlgorithms.jrag:211
     */
    protected void scalarizeScalarAssignment(Scalarizer.Algorithm s, FAssignableExp left, FExp right) {
        scalarRecordClauses(s, new FAccessEmpty(), left, right);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:160
     */
    @Override
    public void prettyPrint_C(CodePrinter p, CodeStream str, String indent) {
        // Scalar type
        printStruct_C(p, str, indent, false);
        
        //Array type
		str.print(indent);
		str.print("JMI_ARRAY_TYPE(");
        str.print(nameScalar_C(p));
		str.print(", ");
		str.print(nameArray_C(p));
		str.print(")\n\n");
        
        // External type
        if (externalValid()) {
            printStruct_C(p, str, indent, true);
        }
        str.print("\n");
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:180
     */
    public void printStruct_C(CodePrinter p, CodeStream str, String indent, boolean ext) {
        String name = ext ? nameScalarExt_C(p) : nameScalar_C(p);
        FFunctionDecl.beginStruct_C(str, indent, name);
        String next = p.indent(indent);
        for (FRecordComponentType frct : getComponents()) {
            str.print(next);
            str.print(ext ? frct.getFType().nameScalarExt_C(p) : frct.getFType().type_C(p));
            str.print(" ");
            str.print(frct.getName());
            str.print(";\n");
        }
        if (getNumComponent() == 0) {
            // always generate default field so that C struct is not empty
            str.print(next + "char dummy;\n");
        }
        FFunctionDecl.endStruct_C(str, indent);
    }
    /**
     * @aspect CCodeGen
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGen.jrag:427
     */
    @Override
    public void printScalarDecl_C(CodePrinter p, CodeStream str, String indent, boolean external, String name) {
        str.formatln("%sJMI_RECORD_STATIC(%s, %s)", indent, nameScalar_C(p, external), name);
    }
    /**
     * @aspect CCodeGenAlgorithms
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenAlgorithms.jrag:531
     */
    @Override
    public void printAssignExt_C(CodePrinter p, CodeStream str, String indent, String dst, String src, 
            boolean wb, boolean first) {
        dst = dst + (first ? "->" : ".");
        src = src + "->";
        for (FRecordComponentType frct : getComponents()) {
            frct.getFType().printAssignExt_C(p, str, indent, dst + frct.getName(), src + frct.getName(), wb, false);
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:234
     */
    public void genSerialize_C(CodeStream str, String indent, String name, boolean parse) {
        name = name + "->";
        for (FRecordComponentType frct : getComponents()) {
            if (!frct.getFType().isRecord() || !parse) {
                frct.getFType().genSerialize_C(str, indent, name + frct.getName(), parse);
            }
        }
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:323
     */
    public void usedTypes(Map<String,FType> res) {
        if (res.containsKey(name())) {
            return;
        }
        for (FRecordComponentType frct : getComponents()) {
            frct.getFType().usedTypes(res);
        }
        res.put(name(), this);
    }
    /**
     * @aspect CCodeGenExternalCeval
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenExternalCeval.jrag:436
     */
    public void externalDependencies(Set<FExternalStmt> res) {
        for (FRecordComponentType frct : getComponents()) {
            frct.getFType().externalDependencies(res);
        }
    }
    /**
     * @aspect CodeFuncCallInOutArg
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenFunctionIO.jrag:467
     */
    @Override
    public void genFuncCallCellInOutArg_C(CodeFuncCallInOutArgPrinter p, CodeStream str, String indent, String name, FExp exp) {
        if (exp.isNoExp()) {
            return;
        }
        for (FRecordComponentType comp : getComponents()) {
            String compName = name + "->" + comp.getName();
            FExp compExp = exp.component(comp.getName());
            comp.getFType().genFuncCallInOutArg_C(p, str, indent, compName, compExp);
        }
    }
    /**
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:196
     */
    public void print(TypePrinter_C p)         { p.print(this); }
    /**
     * @declaredat ASTNode:1
     */
    public FRecordType() {
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
        setChild(List.EMPTY, 0);
    }
    /**
     * @declaredat ASTNode:14
     */
    @ASTNodeAnnotation.Constructor(
        name = {"Size", "Name", "Component", "FClass"},
        type = {"Size", "String", "List<FRecordComponentType>", "FClass"},
        kind = {"Token", "Token", "List", "Token"}
    )
    public FRecordType(Size p0, String p1, List<FRecordComponentType> p2, FClass p3) {
        setSize(p0);
        setName(p1);
        setChild(p2, 0);
        setFClass(p3);
    }
    /**
     * @declaredat ASTNode:25
     */
    public FRecordType(Size p0, beaver.Symbol p1, List<FRecordComponentType> p2, FClass p3) {
        setSize(p0);
        setName(p1);
        setChild(p2, 0);
        setFClass(p3);
    }
    /** @apilevel low-level 
     * @declaredat ASTNode:32
     */
    protected int numChildren() {
        return 1;
    }
    /**
     * @apilevel internal
     * @declaredat ASTNode:38
     */
    public boolean mayHaveRewrite() {
        return true;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:42
     */
    public void flushAttrCache() {
        super.flushAttrCache();
        myFRecordDecl_reset();
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
    public FRecordType clone() throws CloneNotSupportedException {
        FRecordType node = (FRecordType) super.clone();
        return node;
    }
    /** @apilevel internal 
     * @declaredat ASTNode:56
     */
    public FRecordType copy() {
        try {
            FRecordType node = (FRecordType) clone();
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
    public FRecordType fullCopy() {
        return treeCopyNoTransform();
    }
    /**
     * Create a deep copy of the AST subtree at this node.
     * The copy is dangling, i.e. has no parent.
     * @return dangling copy of the subtree at this node
     * @apilevel low-level
     * @declaredat ASTNode:85
     */
    public FRecordType treeCopyNoTransform() {
        FRecordType tree = (FRecordType) copy();
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
    public FRecordType treeCopy() {
        doFullTraversal();
        return treeCopyNoTransform();
    }
    /** @apilevel internal 
     * @declaredat ASTNode:110
     */
    protected boolean is$Equal(ASTNode node) {
        return super.is$Equal(node) && (tokenSize_Size == ((FRecordType) node).tokenSize_Size) && (tokenString_Name == ((FRecordType) node).tokenString_Name) && (tokenFClass_FClass == ((FRecordType) node).tokenFClass_FClass);    
    }
    /**
     * Replaces the lexeme Size.
     * @param value The new value for the lexeme Size.
     * @apilevel high-level
     */
    public void setSize(Size value) {
        tokenSize_Size = value;
    }
    /**
     * Retrieves the value for the lexeme Size.
     * @return The value for the lexeme Size.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Size")
    public Size getSize() {
        return tokenSize_Size;
    }
    /**
     * Replaces the lexeme Name.
     * @param value The new value for the lexeme Name.
     * @apilevel high-level
     */
    public void setName(String value) {
        tokenString_Name = value;
    }
    /** @apilevel internal 
     */
    protected String tokenString_Name;
    /**
     */
    public int Namestart;
    /**
     */
    public int Nameend;
    /**
     * JastAdd-internal setter for lexeme Name using the Beaver parser.
     * @param symbol Symbol containing the new value for the lexeme Name
     * @apilevel internal
     */
    public void setName(beaver.Symbol symbol) {
        if (symbol.value != null && !(symbol.value instanceof String))
        throw new UnsupportedOperationException("setName is only valid for String lexemes");
        tokenString_Name = (String)symbol.value;
        Namestart = symbol.getStart();
        Nameend = symbol.getEnd();
    }
    /**
     * Retrieves the value for the lexeme Name.
     * @return The value for the lexeme Name.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="Name")
    public String getName() {
        return tokenString_Name != null ? tokenString_Name : "";
    }
    /**
     * Replaces the Component list.
     * @param list The new list node to be used as the Component list.
     * @apilevel high-level
     */
    public void setComponentList(List<FRecordComponentType> list) {
        setChild(list, 0);
    }
    /**
     * Retrieves the number of children in the Component list.
     * @return Number of children in the Component list.
     * @apilevel high-level
     */
    public int getNumComponent() {
        return getComponentList().getNumChild();
    }
    /**
     * Retrieves the number of children in the Component list.
     * Calling this method will not trigger rewrites.
     * @return Number of children in the Component list.
     * @apilevel low-level
     */
    public int getNumComponentNoTransform() {
        return getComponentListNoTransform().getNumChildNoTransform();
    }
    /**
     * Retrieves the element at index {@code i} in the Component list.
     * @param i Index of the element to return.
     * @return The element at position {@code i} in the Component list.
     * @apilevel high-level
     */
    public FRecordComponentType getComponent(int i) {
        return (FRecordComponentType) getComponentList().getChild(i);
    }
    /**
     * Check whether the Component list has any children.
     * @return {@code true} if it has at least one child, {@code false} otherwise.
     * @apilevel high-level
     */
    public boolean hasComponent() {
        return getComponentList().getNumChild() != 0;
    }
    /**
     * Append an element to the Component list.
     * @param node The element to append to the Component list.
     * @apilevel high-level
     */
    public void addComponent(FRecordComponentType node) {
        List<FRecordComponentType> list = (parent == null) ? getComponentListNoTransform() : getComponentList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /** @apilevel low-level 
     */
    public void addComponentNoTransform(FRecordComponentType node) {
        List<FRecordComponentType> list = getComponentListNoTransform();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.addChild(node);
        }
    }
    /**
     * Replaces the Component list element at index {@code i} with the new node {@code node}.
     * @param node The new node to replace the old list element.
     * @param i The list index of the node to be replaced.
     * @apilevel high-level
     */
    public void setComponent(FRecordComponentType node, int i) {
        List<FRecordComponentType> list = getComponentList();
        if (list == List.EMPTY) {
            setChild(new List(node), 0);
        } else {
            list.setChild(node, i);
        }
    }
    /**
     * Retrieves the Component list.
     * @return The node representing the Component list.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.ListChild(name="Component")
    public List<FRecordComponentType> getComponentList() {
        List<FRecordComponentType> list = (List<FRecordComponentType>) getChild(0);
        return list;
    }
    /**
     * Retrieves the Component list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Component list.
     * @apilevel low-level
     */
    public List<FRecordComponentType> getComponentListNoTransform() {
        return (List<FRecordComponentType>) getChildNoTransform(0);
    }
    /**
     * @return the element at index {@code i} in the Component list without
     * triggering rewrites.
     */
    public FRecordComponentType getComponentNoTransform(int i) {
        return (FRecordComponentType) getComponentListNoTransform().getChildNoTransform(i);
    }
    /**
     * Retrieves the Component list.
     * @return The node representing the Component list.
     * @apilevel high-level
     */
    public List<FRecordComponentType> getComponents() {
        return getComponentList();
    }
    /**
     * Retrieves the Component list.
     * <p><em>This method does not invoke AST transformations.</em></p>
     * @return The node representing the Component list.
     * @apilevel low-level
     */
    public List<FRecordComponentType> getComponentsNoTransform() {
        return getComponentListNoTransform();
    }
    /**
     * Replaces the lexeme FClass.
     * @param value The new value for the lexeme FClass.
     * @apilevel high-level
     */
    public void setFClass(FClass value) {
        tokenFClass_FClass = value;
    }
    /** @apilevel internal 
     */
    protected FClass tokenFClass_FClass;
    /**
     * Retrieves the value for the lexeme FClass.
     * @return The value for the lexeme FClass.
     * @apilevel high-level
     */
    @ASTNodeAnnotation.Token(name="FClass")
    public FClass getFClass() {
        return tokenFClass_FClass;
    }
    /**
     * @attribute syn
     * @aspect FlatAPI
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1873
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatAPI", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatAPI\\FlatAPI.jrag:1873")
    public int numScalarElements() {
        {
                int res = 0;
                for (FRecordComponentType c : getComponents())
                    res += c.getFType().numScalarElements();
                return res * super.numScalarElements();
            }
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:299
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:299")
    public FRecordDecl myFRecordDecl() {
        ASTState state = state();
        if (myFRecordDecl_computed) {
            return myFRecordDecl_value;
        }
        int _boundaries = state.boundariesCrossed;
        boolean isFinal = this.is$Final();
        state().enterLazyAttribute();
        myFRecordDecl_value = (getFClass() != null) ? getFClass().lookupFRec(getName()) : lookupFRec(getName());
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
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatNames", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1011")
    public String name() {
        String name_value = getName();
        return name_value;
    }
    /**
     * Returns a string (tersely) describing this type.
     * 
     * @see FFunctionDecl#signatureString()
     * @attribute syn
     * @aspect FlatFunctionUtils
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1398
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FlatFunctionUtils", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatUtil.jrag:1398")
    public String signatureString() {
        String signatureString_value = String.format("(%s)%d", getName(), ndims());
        return signatureString_value;
    }
    /**
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:926
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:926")
    public FType mergeRecordType(FType other) {
        {
                if (ndims() != other.ndims() || !other.isRecord()) {
                    return fUnknownType();
                }
                FRecordType rec = (FRecordType) other;
                if (getNumComponent() != rec.getNumComponent()) {
                    return fUnknownType();
                }
                Map<String, FRecordComponentType> comps = new HashMap<>();
                Iterable<FRecordComponentType[]> iter = new ParallelIterable(
                        new FRecordComponentType[2], true, componentTreeSet(), rec.componentTreeSet());
                for (FRecordComponentType[] frct : iter) {
                    if (frct[0] == null || frct[1] == null || 
                            !frct[0].getName().equals(frct[1].getName())) {
                        return fUnknownType();
                    }
                    FType comp = frct[0].getFType().mergeRecordType(frct[1].getFType());
                    if (comp.isUnknown()) {
                        return fUnknownType();
                    }
                    String name = frct[0].getName();
                    comps.put(name, new FRecordComponentType(name, comp));
                }
                
                List<FRecordComponentType> compList = new List<>();
                for (FRecordComponentType comp : getComponents()) {
                    compList.add(comps.get(comp.getName()));
                }
                
                Size size = getSize().mergeRecordType(other.getSize());
                return new FRecordType(size, getName(), compList, getFClass());
            }
    }
    /**
     * @attribute syn
     * @aspect TypePromotion
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:964
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="TypePromotion", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:964")
    public TreeSet<FRecordComponentType> componentTreeSet() {
        {
                TreeSet<FRecordComponentType> res = new TreeSet<FRecordComponentType>();
                for (FRecordComponentType frct : getComponents()) {
                    res.add(frct);
                }
                return res;
            }
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1082")
    public boolean typeCompatible(CommonType type, boolean allowUnknown) {
        boolean typeCompatible_CommonType_boolean_value = typeMatches(type, true, allowUnknown);
        return typeCompatible_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect FTypeCompatibility
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeCompatibility", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1100")
    public boolean typeMatches(CommonType type, boolean compatible, boolean allowUnknown) {
        {
                if (!dimensionCompatible(type, allowUnknown) || !type.isRecord())
                    return false;
                FRecordType rec = (FRecordType) type;
                if (getNumComponent() != rec.getNumComponent())
                    return false;
                return typeMatches(componentTreeSet(), rec.componentTreeSet(), compatible, true);
            }
    }
    /**
     * @attribute syn
     * @aspect FTypeEquivalent
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="FTypeEquivalent", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1188")
    public boolean equivalentTo(CommonType type, boolean allowUnknown) {
        boolean equivalentTo_CommonType_boolean_value = typeMatches(type, false, allowUnknown);
        return equivalentTo_CommonType_boolean_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1235
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1235")
    public boolean isRecord() {
        boolean isRecord_value = true;
        return isRecord_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1276")
    public boolean isType(FType type) {
        boolean isType_FType_value = type.isRecord();
        return isType_FType_value;
    }
    /**
     * @attribute syn
     * @aspect BuiltInFlatTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1293
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="BuiltInFlatTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\TypeAnalysis.jrag:1293")
    public boolean containsType(FType type) {
        {
                for (FRecordComponentType component : getComponents())
                    if (component.getFType().containsType(type))
                        return true;
                return false;
            }
    }
    /**
     * @attribute syn
     * @aspect Variability
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:261
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="Variability", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\Variability.jrag:261")
    public TypePrefixVariability funcOutputVariability() {
        {
                TypePrefixVariability var = Variability.CONSTANT;
                for (FRecordComponentType component : getComponents()) {
                    var = var.combine(component.getFType().funcOutputVariability());
                }
                return var;
            }
    }
    /**
     * @attribute syn
     * @aspect ContentCheck
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="ContentCheck", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\errorcheck\\ContentsCheck.jadd:795")
    public boolean externalValid(boolean rec) {
        {
                if (isArray()) {
                    return false;
                }
                for (FRecordComponentType frct : getComponents()) {
                    if (!frct.getFType().externalValid(true)) {
                        return false;
                    }
                }
                return true;
            }
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:36
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:36")
    public String scalarType_C(CodePrinter p) {
        String scalarType_C_CodePrinter_value = nameScalar_C(p) + "*";
        return scalarType_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:46
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:46")
    public String nameScalar_C(CodePrinter p) {
        String nameScalar_C_CodePrinter_value = (getFClass() != null ? myFRecordDecl().name_C() : 
                ASTNode.underScore(getName())) + "_" + C_SUFFIX_REC;
        return nameScalar_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:55
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:55")
    public String nameArray_C(CodePrinter p) {
        String nameArray_C_CodePrinter_value = nameScalar_C(p) + C_SUFFIX_ARRAY;
        return nameArray_C_CodePrinter_value;
    }
    /**
     * @attribute syn
     * @aspect CCodeGenTypes
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:62
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.SYN)
    @ASTNodeAnnotation.Source(aspect="CCodeGenTypes", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaCBackEnd\\src\\jastadd\\CCodeGen\\CCodeGenTypes.jrag:62")
    public String nameScalarExt_C(CodePrinter p) {
        String nameScalarExt_C_CodePrinter_value = nameScalar_C(p) +  C_SUFFIX_EXT;
        return nameScalarExt_C_CodePrinter_value;
    }
    /**
     * @attribute inh
     * @aspect FlatRecordBinding
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:306
     */
    @ASTNodeAnnotation.Attribute(kind=ASTNodeAnnotation.Kind.INH)
    @ASTNodeAnnotation.Source(aspect="FlatRecordBinding", declaredAt="C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFlatTree\\src\\jastadd\\FlatNameBinding.jrag:306")
    public FRecordDecl lookupFRec(String name) {
        FRecordDecl lookupFRec_String_value = getParent().Define_lookupFRec(this, null, name);
        return lookupFRec_String_value;
    }
    /** @apilevel internal */
    public ASTNode rewriteTo() {
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1068
        if (flattened) {
            return rewriteRule0();
        }
        // Declared at C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:841
        if (rewriteEquivalentRecord) {
            return rewriteRule1();
        }
        return super.rewriteTo();
    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Flattening.jrag:1068
     * @apilevel internal
     */
    private FRecordType rewriteRule0() {
{
            setFClass(myFClass());
            flattened = false;
            return this;
        }    }
    /**
     * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasElimination.jrag:841
     * @apilevel internal
     */
    private FType rewriteRule1() {
{
            return myFClass().createEquivalentRecordType(this);
		}    }
}
