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
 * @aspect LightProfiling
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\Profiling.jrag:50
 */
public class StepInfo extends java.lang.Object {
    
		
		public static boolean GC_BEFORE_MEM = false;

    
		
		public static final Class<? extends InfoItem> TIME = TimeItem.class;

    
		public static final Class<? extends InfoItem> MEMORY_CHANGE = MemoryChangeItem.class;

    
		
		private ArrayList<Class<? extends InfoItem>> itemClasses;

    
		private ArrayList<InfoNode> open;

    
		private InfoNode top;

    
		
		public StepInfo() {
			itemClasses = new ArrayList<Class<? extends InfoItem>>();
			itemClasses.add(TIME);
			itemClasses.add(MEMORY_CHANGE);
			reset();
		}

    
		
		public void reset() {
			open = new ArrayList<InfoNode>();
			top = new InfoNode("Total", 0);
			open.add(top);
			top.begin();
		}

    
		
		public void addItemType(Class<? extends InfoItem> item) {
			itemClasses.add(item);
		}

    
		
		public void clearItemTypes() {
			itemClasses.clear();
		}

    
		
		public void begin(String name) {
			if (name == null)
				throw new IllegalArgumentException("Must give a name");
			InfoNode n = new InfoNode(name, top.depth + 1);
			top.add(n);
			top = n;
			open.add(top);
			top.begin();
		}

    
		
		public void end(String name) {
			if (name == null)
				throw new IllegalArgumentException("Must give a name");
			if (!top.name.equals(name))
				throw new IllegalArgumentException("Name does not match last opened step: " + 
						name + ", last: " + top.name);
			top.end();
			open.remove(open.size() - 1);
			top = open.get(open.size() -1);
		}

    
		
		public void logReport() {
			logReport(Integer.MAX_VALUE);
		}

    
		
		public void logReport(int maxDepth) {
			while (top.depth > 0) 
				end(top.name);
			top.end();
			
			ArrayList<String[]> lines = new ArrayList<String[]>();
			lines.add(top.toStrings());
			for (InfoNode n : top)
				if (n.depth <= maxDepth)
					lines.add(n.toStrings());
			
			int n = lines.get(0).length;
			int[] lengths = new int[n];
			for (String[] line : lines)
				for (int i = 0; i < n; i++)
					if (line[i].length() > lengths[i])
						lengths[i] = line[i].length();
			
			StringBuilder buf = new StringBuilder("%-");
			buf.append(lengths[0]);
			buf.append("s: ");
			for (int i = 1; i < n; i++) {
				buf.append("%");
				buf.append(lengths[i]);
				buf.append((i < n - 1) ? "s, " : "s");
			}
			String fmt = buf.toString();
			
			for (String[] line : lines) 
				ASTNode.log.debug(String.format(fmt, (Object[]) line));
		}

    
		
		public String[][] rawLog() {
			while (top.depth > 0) 
				end(top.name);
			top.end();
			
			java.util.List<String[]> lines = new ArrayList<String[]>();
			lines.add(top.toStringsRaw());
			for (InfoNode n : top)
				lines.add(n.toStringsRaw());
			
			return lines.toArray(new String[lines.size()][]);
		}

    
		private static final String[][] measurmentNames = new String[][] {new String[]{"type"}, new String[]{"time"}, new String[]{"memoryDiff", "memoryTotal"}};

    
		
		public void writeCSVFile(File file) throws FileNotFoundException {
			String[][] rawMemLog = rawLog();
			String[][][] memLog = new String[rawMemLog.length][][];
			for (int i = 0; i < rawMemLog.length; i++) {
				memLog[i] = new String[rawMemLog[i].length][];
				for (int j = 0; j < rawMemLog[i].length; j++) {
					if (j == 0)
						memLog[i][j] = new String[] {rawMemLog[i][j]};
					else
						memLog[i][j] = rawMemLog[i][j].split(",");
				}
			}
			PrintStream memOutFile = new PrintStream(file);
			for (int j = 0; j < memLog[0].length; j++) {
				for (int k = 0; k < memLog[0][j].length; k++) {
					memOutFile.print("\"");
					memOutFile.print(measurmentNames[j][k]);
					memOutFile.print("\"");
					for (int i = 0; i < memLog.length; i++) {
						memOutFile.print(",\"");
						memOutFile.print(memLog[i][j][k]);
						memOutFile.print('"');
					}
					memOutFile.println();
				}
			}
			memOutFile.close();
		}

    
		
		private InfoItem[] createItems() {
			InfoItem[] res = new InfoItem[itemClasses.size()];
			Class x = null;
			for (int i = 0; i < res.length; i++) {
				try {
					res[i] = itemClasses.get(i).newInstance();
				} catch (Exception e) {
					throw new IllegalArgumentException("Could not instantiate info item", e);
				}
			}
			return res;
		}

    
		
		private class InfoNode implements Iterable<InfoNode> {
			
			private static final char INDENT = ' ';
			
			private InfoItem[] items;
			private ArrayList<InfoNode> children;
			public String name;
			public int depth;
			
			public InfoNode(String name, int depth) {
				this.name = name;
				this.depth = depth;
				items = createItems();
				children = null;
			}
			
			public void begin() {
				for (InfoItem it : items)
					it.begin();
			}
			
			public void end() {
				for (InfoItem it : items)
					it.end();
			}
			
			public void add(InfoNode n) {
				if (children == null)
					children = new ArrayList<InfoNode>();
				children.add(n);
			}
			
			private String produceNameHead() {
				StringBuilder buf = new StringBuilder();
				for (int j = 0; j < depth; j++)
					buf.append(INDENT);
				buf.append(name);
				return buf.toString();
			}
			
			public String[] toStrings() {
				String[] res = new String[items.length + 1];
				res[0] = produceNameHead();
				int i = 1;
				for (InfoItem it : items)
					res[i++] = it.toString();
				return res;
			}
			
			public String[] toStringsRaw() {
				String[] res = new String[items.length + 1];
				res[0] = produceNameHead();
				int i = 1;
				for (InfoItem it : items)
					res[i++] = it.toStringRaw();
				return res;
			}
			
			public Iterator<InfoNode> iterator() {
				return new NodeIterator();
			}
			
			private class NodeIterator implements Iterator<InfoNode> {
				
				int i = 0;
				Iterator<InfoNode> cur = null;
				
				public boolean hasNext() {
					return children != null && i < children.size();
				}
				
				public InfoNode next() {
					InfoNode res;
					if (cur != null) {
						res = cur.next();
					} else {
						res = children.get(i);
						cur = res.iterator();
					}
					if (!cur.hasNext()) {
						cur = null;
						i++;
					}
					return res;
				}
				
				public void remove() {
					throw new UnsupportedOperationException();
				}
				
			}
			
		}

    
		
		public interface InfoItem {
			public void begin();
			public void end();
			public String toString();
			public String toStringRaw();
		}

    
		
		public static abstract class StateDifferenceInfoItem implements InfoItem {
			private long beginVal = 0;
			private long endVal = 0;
			
			public void begin() {
				beginVal = state();
			}
			
			public void end() {
				endVal = state();
			}
			
			public String toString() {
				return toString(endVal - beginVal, endVal);
			}
			
			public String toStringRaw() {
				return toStringRaw(endVal - beginVal, endVal);
			}
			
			public abstract long state();
			public abstract String toString(long diff, long endVal);
			public abstract String toStringRaw(long diff, long endVal);
		}

    
		
		public static class TimeItem extends StateDifferenceInfoItem {
			public long state() {
				return System.currentTimeMillis() - MemoryChangeItem.timeSpentInGC;
			}
			
			public String toString(long diff, long endVal) {
				return (Math.round(diff / 10.0) / 100.0) + " s";
			}
			
			public String toStringRaw(long diff, long endVal) {
				return new Long(diff).toString();
			}
		}

    
		
		public static class MemoryChangeItem extends StateDifferenceInfoItem {
			private static final Runtime RUNTIME = Runtime.getRuntime();
			private static long timeSpentInGC = 0;
			
			public static long getTimeSpentInGC() {
				return timeSpentInGC;
			}

			public long state() {
				if (StepInfo.GC_BEFORE_MEM)
					runGC();
				return usedMemory();
			}
			
			private static long usedMemory() {
				return RUNTIME.totalMemory() - RUNTIME.freeMemory();
			}
			
			private static void runGC() {
				long start = System.currentTimeMillis();
				try {
					long usedMem1 = usedMemory(), usedMem2 = Long.MAX_VALUE;
					for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++i) {
						RUNTIME.runFinalization();
						RUNTIME.gc();
						Thread.yield();
	
						usedMem2 = usedMem1;
						usedMem1 = usedMemory();
					}
				} catch (Exception e) {}
				timeSpentInGC += System.currentTimeMillis() - start;
			}
			
			public String toString(long diff, long endVal) {
				return ASTNode.formatMem(diff) + " (" + ASTNode.formatMem(endVal) + " total)";
			}
			
			public String toStringRaw(long diff, long endVal) {
				return diff + "," + endVal;
			}
		}


}
