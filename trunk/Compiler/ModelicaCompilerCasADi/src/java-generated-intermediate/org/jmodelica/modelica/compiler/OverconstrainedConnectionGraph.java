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
 * @aspect OverconstrainedConnections
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:1540
 */
public class OverconstrainedConnectionGraph extends java.lang.Object {
    
		
		/**
		 * The calculated values for operators that depend on the graph for a specific component.
		 */
		public static class OpsResult {
			
			/** The result for the Connections.isRoot() operator. */
			public final boolean isRoot;
			/** The result for the Connections.rooted() operator. */
			public final boolean rooted;
			
			public OpsResult(boolean isRoot, boolean rooted) {
				this.isRoot = isRoot;
				this.rooted = rooted;
			}
			
		}

    
		
		private Collection<Edge> edges = new ArrayList<Edge>();

    
		private Collection<Node> nodes = new ArrayList<Node>();

    
		private Map<String,Node> nodeMap = new HashMap<String,Node>();

    
		private Map<String,OpsResult> opsMap;

    
		static String UNROOTED_ERR_MSG  = "Set of unrooted connectors in overconstrained connection graph:";

    
		static String MULTIROOT_ERR_MSG = "Multiple definite roots in unbreakable subgraph in overconstrained connection graph";

    
		static String LOOP_ERR_MSG      = "Unbreakable loop in overconstrained connection graph";

    
		static String MULTIDEF_ERR_MSG  = "Multiple root definitions for single connector in overconstrained connection graph";

    
		static String ERR_SEP = "\n    ";

    
		
		/**
		 * Add a connection to the graph.
		 * 
		 * @param left    describes one end of connection
		 * @param right   describes other end of connection
		 * @param prefix  the prefix to use when flattening names
		 * @param source  the originating connect or branch statement
		 */
		public void addConnection(ConnectionSetEntry left, ConnectionSetEntry right, FAccess prefix, ConnectionEdge source) {
			Node leftNode = getNode(left.name(), left.getVar());
			Node rightNode = getNode(right.name(), right.getVar());
			edges.add(new Edge(source, leftNode, rightNode, left, right, prefix));
		}

    
		
		/**
		 * Mark a component as a root in the graph.
		 */
		public void addRoot(InstComponentDecl var) {
			getNode(var).setRoot();
		}

    
		
		/**
		 * Mark a component as a potential root with the given priority in the graph.
		 */
		public void addPotentialRoot(InstComponentDecl var, int priority) {
			getNode(var).setPotentialRoot(priority);
		}

    

        /**
         * Convert graph to a set of spanning trees.
         * 
         * See Modelica Language Specification 3.3, section 9.4.2.
         */
        public void buildTrees(ConnectionSetManager csm) {
            breakPureConnectLoops();
            Queue<Node> roots = collectRoots();
            java.util.List<Node> selected = new ArrayList<Node>(roots.size());
            if (selectRoots(roots, selected))
                return;
            
            buildTrees(csm, selected);
            unrootedErrors();
            buildOpsMap();
        }

    

        /**
         * Break loops comprised entirely of connect edges.
         */
        private void breakPureConnectLoops() {
            for (Node n : nodes) {
                n.breakPureConnectLoops();
            }
        }

    

        /**
         * Collect roots sorted by priority.
         */
        private Queue<Node> collectRoots() {
            Queue<Node> roots = new PriorityQueue<Node>();
            for (Node n : nodes)
                if (n.canBeRoot())
                    roots.add(n);
            return roots;
        }

    

        /**
         * Select a root for each unbreakable sub-graph, and generate any root-related errors.
         * 
         * @param roots     list of roots sorted in priority order
         * @param selected  list where the selected roots will be added
         * @return  true if any errors were generated
         */
        private boolean selectRoots(Queue<Node> roots, java.util.List<Node> selected) {
            clearVisited();
            boolean foundError = false;
            java.util.List<Node> otherRoots = new ArrayList<Node>();
            for (Node root = roots.poll(); root != null; root = roots.poll()) {
                if (!root.visited) {
                    boolean loop = root.markSelectedRoot(root, otherRoots);
                    selected.add(root);
                    
                    // Generate errors for unbreakable loops.
                    if (loop) {
                        genError(LOOP_ERR_MSG, root, "Selected root: ");
                        foundError = true;
                    }
                    // Generate errors for multiple roots.
                    if (otherRoots.size() > 0) {
                        genError(MULTIROOT_ERR_MSG, root, "Selected root: ", otherRoots, "Other root: ");
                        otherRoots = new ArrayList<Node>();
                        foundError = true;
                    }
                }
            }
            return foundError;
        }

    

        /**
         * Build spanning trees from graph, starting from selected roots.
         */
        private void buildTrees(ConnectionSetManager csm, java.util.List<Node> selected) {
            clearVisited();
            for (Node sel : selected) {
                if (!sel.visited) {
                    Queue<Node> work = new ArrayDeque<Node>();
                    work.add(sel);
                    sel.level = 0;
                    sel.visited = true;
                    for (Node n = work.poll(); n != null; n = work.poll()) {
                        n.buildTree(work, csm);
                    }
                }
            }
        }

    

        /**
         * Generate errors for subgraphs without roots.
         */
        private void unrootedErrors() {
            for (Node n : nodes) {
                if (!n.visited) {
                    ArrayList<Node> subGraph = new ArrayList<Node>();
                    n.subGraph(subGraph);
                    genError(UNROOTED_ERR_MSG, n, subGraph, null);
                }
            }
        }

    

        /**
         * Build lookup map for operators that are dependent on the result.
         */
        private void buildOpsMap() {
            opsMap = new HashMap<String,OpsResult>();
            for (Node n : nodes) 
                opsMap.put(n.flatName(), n.opsResult());
        }

    

        /**
         * Clear visited flags.
         */
        private void clearVisited() {
            for (Node n : nodes)
                n.visited = false;
            for (Edge e : edges)
                e.visited = false;
        }

    

        /**
         * Generate error message.
         */
        private void genError(String msg, Node node, 
                java.util.List<Node> nodeList, String listMsg) {
            genError(msg, node, null, nodeList, listMsg);
        }

    

        /**
         * Generate error message.
         */
        private void genError(String msg, Node node, String nodeMsg) {
            genError(msg, node, nodeMsg, null, null);
        }

    

        /**
         * Generate error message.
         */
        private void genError(String msg, Node node, String nodeMsg, 
                java.util.List<Node> nodeList, String listMsg) {
            StringBuilder errorMsg = new StringBuilder();
            errorMsg.append(msg);
            if (nodeMsg != null) {
                errorMsg.append(ERR_SEP);
                errorMsg.append(nodeMsg);
                errorMsg.append(node.flatName());
            }
            if (nodeList != null) {
                for (Node n : nodeList) {
                    errorMsg.append(ERR_SEP);
                    if (listMsg != null) {
                        errorMsg.append(listMsg);
                    }
                    errorMsg.append(n.flatName());
                }
            }
            node.var.error(errorMsg.toString());
        }

    

		/**
		 * Check if conversion to spanning trees is finished.
		 */
		public boolean builtTreesDone() {
			return opsMap != null;
		}

    
		
		/**
		 * Find the result for operators that depend on the graph for the given access.
		 */
		public OpsResult ops(FExp e) {
			OpsResult res = null;
            CommonAccess u = e.asCommonAccess();
			if (u.isInstAccess()) {
                InstComponentDecl var = u.asInstAccess().myInstComponentDecl();
				Node n = getNode(var);
				res = (n == null) ? null : n.opsResult();
			} else {
                res = opsMap.get(u.name());
			}
			return (res == null) ? new OpsResult(false, false) : res;
		}

    
		
		/**
		 * Remove all references to the instance tree, and discard information that is no longer needed.
		 */
		public void disconnectFromInstanceTree() {
			edges = null;
			nodes = null;
			nodeMap = null;
		}

    

        /**
         * Find, or if neccessary create, the node for a given component.
         */
        private Node getNode(InstComponentDecl var) {
            return getNode(var.getFAccess().name(), var);
        }

    

        /**
         * Find, or if neccessary create, the node for a given component accessed by the specified name.
         */
        private Node getNode(String name, InstComponentDecl var) {
            Node res = nodeMap.get(name);
            if (res == null) {
                res = new Node(var, name);
                nodeMap.put(name, res);
                nodes.add(res);
            }
            return res;
        }

    

		/**
		 * An edge in the graph.
		 */
		private static class Edge {
			
			/** Visited flag used in traversals. */
			public boolean visited;

			private ConnectionEdge source;
			private Node n1;
			private Node n2;
			private ConnectionSetEntry cse1;
			private ConnectionSetEntry cse2;
			private FAccess prefix;
			private boolean broken;
			private boolean ignore = false;
			
			/**
			 * Create a new edge.
			 * 
			 * The edge is undirected, use of "first" and "second" below is purely to tell them apart.
			 * 
			 * @param source  the originating connect or branch statement
			 * @param n1      first end of the edge
			 * @param n2      second end of the edge
			 * @param cse1    describes first end of edge in terms of the connection set manager
			 * @param cse2    describes second end of edge in terms of the connection set manager
			 * @param prefix  the prefix to use when flattening names
			 */
			public Edge(ConnectionEdge source, Node n1, Node n2, ConnectionSetEntry cse1, ConnectionSetEntry cse2, FAccess prefix) {
				this.source = source;
				this.n1 = n1;
				this.n2 = n2;
				n1.addEdge(this);
				n2.addEdge(this);
				broken = false;
				if (isBreakable()) {
					this.cse1 = cse1;
					this.cse2 = cse2;
					this.prefix = prefix;
				}
			}
			
			/**
			 * Check if this is a breakable edge (a connect() statement).
			 */
			public boolean isBreakable() {
				return source.isBreakable();
			}
            
            public String toString() {
                return n1 + " - " + n2;
            }
			
			/**
			 * Get the other end of the edge.
			 * 
			 * Assumes that n is one of the ends.
			 */
			public Node other(Node n) {
				return (n == n1) ? n2 : n1;
			}
			
			/**
			 * Checks if the given node is the edge corresponding to the left argument of a 
			 * connect or branch.
			 */
			public boolean isLeft(Node n) {
				return n == n1;
			}
			
			/**
			 * Break this edge.
			 * 
			 * @throws UnsupportedOperationException  if the edge isn't breakable
			 */
			public void breakEdge() {
				if (!isBreakable())
					throw new UnsupportedOperationException();
				broken = true;
			}
			
			/**
			 * Check if edge is broken.
			 */
			public boolean isBroken() {
				return broken;
			}
			
			/**
			 * Add edge to connection sets, either as normal connections or as equalityConstraint() calls.
			 */
			public void connect(ConnectionSetManager csm) {
				if (isBreakable()) {
					if (isBroken())
						csm.addEqualityConstraint(cse1, cse2, prefix);
					else
						cse1.getVar().connectTo(cse1, cse2, prefix, csm, source, false);
				}
			}

            /**
             * Checks if this edge should be ignored during computations
             */
            public boolean isIgnored() {
                return ignore;
            }

            /**
             * Marks this edge as ignored and will not be considered during computations
             */
            public void setAsIgnored() {
                ignore = true;
            }

		}

    

        /**
         * A node in the graph.
         */
        private static class Node implements Comparable<Node> {

            /** Visited flag used in traversals. */
            public boolean visited = false;
            /** Depth of this node from root of tree. Depth 0 is the root. */
            public int level = -1;

            private static final int DEFINITE_ROOT = -1;
            private static final int NOT_ROOT      = Integer.MAX_VALUE;

            private InstComponentDecl var;
            private String name;
            private int rootPriority;
            private Collection<Edge> edges;
            private Node selectedRoot;

            public Node(InstComponentDecl var, String name) {
                this.var = var;
                this.name = name;
                rootPriority = NOT_ROOT;
                edges = new ArrayList<Edge>();
                selectedRoot = null;
            }

            public int compareTo(Node other) {
                return rootPriority - other.rootPriority;
            }

            public String toString() {
                return name;
            }

            public void addEdge(Edge e) {
                edges.add(e);
            }

            /**
             * Check if this node is declared either root or potential root.
             */
            public boolean canBeRoot() {
                return rootPriority != NOT_ROOT;
            }

            /**
             * Check if this node was selected as a root during conversion to spanning trees.
             * 
             * Returns false before conversion.
             */
            public boolean isSelectedRoot() {
                return level == 0;
            }

            /**
             * The flattened name of the node, as a String.
             */
            public String flatName() {
                return name;
            }

            /**
             * Mark this node as a potential root with the given priority.
             */
            public void setPotentialRoot(int priority) {
                if (rootPriority < NOT_ROOT && rootPriority != priority) {
                    // Error - Multiple root definitions of a connector 
                    StringBuilder errorMsg = new StringBuilder();
                    errorMsg.append(MULTIDEF_ERR_MSG);
                    errorMsg.append(ERR_SEP);
                    errorMsg.append("Connector: ");
                    errorMsg.append(this.flatName());
                    var.error(errorMsg.toString());
                }
                if (rootPriority > priority)
                    rootPriority = priority;
            }

            /**
             * Mark this node as a definite root.
             */
            public void setRoot() {
                setPotentialRoot(DEFINITE_ROOT);
            }

            /**
             * Calculate the results of isRoot() and rooted() when applied to this node.
             */
            public OpsResult opsResult() {
                Node other = null;
                for (Edge e : edges)
                    if (!e.isIgnored() && e.isLeft(this) && !e.isBreakable())
                        other = e.other(this);
                boolean rooted = other != null && level < other.level;
                return new OpsResult(isSelectedRoot(), rooted);
            }

            /** 
             * Traversal method for building the spanning trees.
             */
            public void buildTree(Queue<Node> work, ConnectionSetManager csm) {
                for (Edge e : edges) 
                    if (!e.isIgnored() && !e.visited) 
                        buildTreeVisit(e, work, csm);
            }

            /** 
             * Traversal method for decending into unbreakable subgraphs when building the spanning trees.
             */
            private void buildTreeForUnbreakable(Queue<Node> work, ConnectionSetManager csm) {
                for (Edge e : edges) 
                    if (!e.isIgnored() && !e.visited && !e.isBreakable()) 
                        buildTreeVisit(e, work, csm);
            }

            /**
             * Visit a specific edge during traversal for building the spanning trees.
             */
            private void buildTreeVisit(Edge e, Queue<Node> work, ConnectionSetManager csm) {
                e.visited = true;
                Node n = e.other(this);
                if (n.visited) {
                    e.breakEdge();
                } else if (n.selectedRoot != selectedRoot) {
                    if (n.selectedRoot != null && n.selectedRoot.rootPriority == DEFINITE_ROOT)
                        e.breakEdge();
                    else
                        n.selectedRoot = selectedRoot;
                }
                n.visited = true;
                e.connect(csm);
                if (!e.isBroken()) {
                    n.level = level + 1;
                    work.add(n);
                    n.buildTreeForUnbreakable(work, csm);
                }
            }

            /**
             * Find and break loops consisting only of connect edges.
             */
            public void breakPureConnectLoops() {
                if (!visited) {
                    visited = true;
                    for (Edge e : edges) {
                        if (!e.isIgnored() && !e.visited && e.isBreakable()) {
                            e.visited = true;
                            Node n = e.other(this);
                            if (n.visited) {
                                e.setAsIgnored();
                            } else {
                                n.breakPureConnectLoops();
                            }
                        }
                    }
                }
            }

            /**
             * Set the selected root of this subgraph.
             * @param root        the selected root node
             * @param otherRoots  a collection to add any redundant roots to
             * @return true if unbreakable loop found
             */
            public boolean markSelectedRoot(Node root, Collection<Node> otherRoots) {
                boolean loop = false;
                visited = true;
                selectedRoot = root;
                if (root != this && rootPriority == DEFINITE_ROOT) {
                    // Error - more than one definite root in unbreakable subgraph
                    otherRoots.add(this);
                }
                
                for (Edge e : edges) {
                    if (!e.isIgnored() && !e.visited && !e.isBreakable()) {
                        e.visited = true;
                        Node n = e.other(this);
                        if (n.visited) {
                            // Error - unbreakable loop
                            loop = true;
                        }
                        loop = loop || n.markSelectedRoot(root, otherRoots);
                    }
                }
                return loop;
            }

            /**
             * Gathers the subgraph which n is in.
             */
            public void subGraph(ArrayList<Node> sg) {
                if (visited)
                    return;
                visited = true;
                sg.add(this);
                for (Edge e : edges) {
                    if (!e.isIgnored()) {
                        e.other(this).subGraph(sg);
                    }
                }
            }

        }


}
