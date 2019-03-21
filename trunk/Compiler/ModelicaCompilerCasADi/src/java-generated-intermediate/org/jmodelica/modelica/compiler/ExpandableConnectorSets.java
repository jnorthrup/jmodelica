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
 * @aspect ExpandableConnectors
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaFrontEnd\\src\\jastadd\\flattening\\Connections.jrag:2135
 */
public class ExpandableConnectorSets extends java.lang.Object {
    
        
        private Map<InstComponentDecl,ExpandableSet> map;

    
        private Set<ExpandableSet> sets;

    
        private java.util.List<Connection> connections;

    
        private java.util.List<InstAccess> uses;

    
        private boolean expansionDone;

    

        
        public ExpandableConnectorSets() {
            map = new LinkedHashMap<>();
            sets = new LinkedHashSet<>();
            connections = new ArrayList<>();
            uses = new ArrayList<>();
            expansionDone = false;
        }

    
        
        /**
         * Calculate the components present in each expandable connector and apply connections 
         * involving them.
         */
        public void elaborate(ConnectionSetManager csm) {
            boolean ok = true;
            for (ExpandableSet set : sets()) 
                set.addNested();
            for (ExpandableSet set : sets()) 
                if (!set.expand())
                    ok = false;
            
            if (ok) {
                expansionDone = true;
                for (Connection conn : connections) {
                    conn.connect(csm);
                }
                for (InstComponentDecl icd : map.keySet()) {
                    icd.buildConnectionSets(null, csm, true);
                    icd.getInstComponentDecls().collectErrors(ErrorCheckType.GENERATED);
                }
                for (InstAccess use : uses) {
                    use.flushAllRecursiveClearFinal();
                    if (use.myInstComponentDecl().isUnknown()) 
                        use.error("Using member of expandable connector is only allowed if the member is connected to in the connection set");
                }
            }
        }

    
        
        /**
         * Add an expandable connector to sets.
         */
        public void addConnector(InstComponentDecl conn) {
            setFor(conn);
        }

    
        
        /**
         * Add a use of a member of an expandable connector.
         */
        public void addUse(InstAccess use) {
            uses.add(use);
        }

    

        /**
         * Add information about a connection introducing a new component to an expandable connector.
         */
        public void addIntroducingConnection(InstAccess unknown, InstAccess known,
                FAccess prefix, ConnectionEdge source) {
            InstComponentDecl expandable = unknown.findReferencedExpandableConnector();
            InstAccess unknownPart = unknown.findExpandableMemberPart(expandable);
            ExpandableSet set = setFor(expandable);
            set.addMember(known, unknown, unknownPart);
            
            connections.add(new Connection(prefix, source));
            // TODO: support adding nestled expandable connectors? see Modelica:#428
       }

    

        /**
         * Add information about a connection between two expandable connectors.
         */
        public void addSpanningConnection(InstComponentDecl leftComp, InstComponentDecl rightComp,
                FAccess prefix, ConnectionEdge source) {
            connectExpandableConnectors(leftComp, rightComp);
            connections.add(new Connection(prefix, source));
        }

    

        /**
         * Check if elaboration is already done.
         */
        public boolean isExpansionDone() {
            return expansionDone;
        }

    
        
        private void connectExpandableConnectors(InstComponentDecl leftComp, InstComponentDecl rightComp) {
            ExpandableSet left = setFor(leftComp);
            ExpandableSet right = setFor(rightComp);
            left.merge(right);
            
            SortedSet<InstComponentDecl> rightChildren = rightComp.containedInstComponents();
            for (InstComponentDecl leftChild : leftComp.containedInstComponents()) {
                if (leftChild.isExpandableConnector() && rightChildren.contains(leftChild)) {
                    InstComponentDecl rightChild = rightChildren.tailSet(leftChild).first();
                    if (rightChild.isExpandableConnector())
                        connectExpandableConnectors(leftChild, rightChild);
                }
            }
        }

    
        
        /**
         * Add a new binding to the map and the list of sets to process.
         */
        private void bind(InstComponentDecl conn, ExpandableSet set) {
            map.put(conn, set);
            sets.add(set);
        }

    
        
        private ExpandableSet setFor(InstComponentDecl comp) {
            InstComponentDecl org = comp.duplicateOriginal();
            ExpandableSet set = map.get(org);
            if (set == null) {
                set = new ExpandableSet(org);
            }
            if (org != comp) {
                set.addConnector(comp);
            }
            return set;
        }

    

        private Iterable<ExpandableSet> sets() {
            return new GrowableSetIterable(sets);
        }

    

        private class Connection {
            
            public final FAccess prefix;
            public final FConnectClause source;
            private EvaluataionValueCache values;
            
            public Connection(FAccess prefix, ConnectionEdge source) {
                this.prefix = prefix;
                this.source = (FConnectClause) source;
                values = new EvaluataionValueCache(this.source);
            }
            
            public void connect(ConnectionSetManager csm) {
                source.flushAllRecursiveClearFinal(); // Depends on FConnectClause not resetting is$Final
                values.apply();
                source.buildConnectionSets(prefix, csm, true);
                values.reset();
            }
            
            public String toString() {
                return source.toString();
            }
            
        }

    
        
        private class ExpandableSet {
            
            private Set<InstComponentDecl> connectors;
            private Set<ExpandableSet> parentSets;
            private Map<String,ConnectorMember> members;
            private Set<ConnectorMember> owningMembers;
            private ExpandableSet replacement = null;
            private boolean expanded;
            private boolean nestedDone;
            private boolean isok;
            
            public ExpandableSet() {
                connectors = new LinkedHashSet<InstComponentDecl>();
                parentSets = new HashSet<ExpandableSet>();
                members = new HashMap<String,ConnectorMember>();
                owningMembers = new HashSet<ConnectorMember>();
                expanded = false;
                nestedDone = false;
                isok = true;
            }
            
            public ExpandableSet(InstComponentDecl connector) {
                this();
                addConnector(connector);
            }
            
            public ExpandableSet(ConnectorMember member) {
                this();
                owningMembers.add(member);
            }
            
            /**
             * Calculate the components present in each expandable connector, if not already done.
             * 
             * @return  <code>false</code> if any errors were found
             */
            public boolean expand() {
                if (!expanded) {
                    expanded = true;
                    for (ExpandableSet parentSet : parentSets()) {
                        parentSet.expand();
                    }
                    
                    ConnectorMember[] sorted = members.values().toArray(new ConnectorMember[members.size()]);
                    Arrays.sort(sorted);
                    for (ConnectorMember member : sorted) {
                        isok = member.check() && isok;
                    }
                    if (isok) { 
                        for (InstComponentDecl conn : connectors()) {
                            expandConnector(conn, sorted);
                        }
                    }
                }
                return isok;
            }

            private Iterable<InstComponentDecl> connectors() {
                return new GrowableSetIterable(connectors);
            }

            /**
             * Add all nested expandable connector to their parent's sets.
             */
            public void addNested() {
                if (!nestedDone && !members.isEmpty()) {
                    nestedDone = true;
                    for (InstComponentDecl conn : connectors) {
                        InstComponentDecl p = conn.findExpandableAncestor();
                        if (p != null) {
                            InstComponentDecl c = conn.ancestorChild(p, conn);
                            ExpandableSet set = setFor(p);
                            set.addDeclared(c.name());
                            set.addNested();
                        }
                    }
                }
            }
            
            /**
             * Merge two sets of expandable connectors, keeping this one.
             */
            public void merge(ExpandableSet other) {
                if (other == null || other == this)
                    return;
                
                for (InstComponentDecl conn : other.connectors) {
                    addConnector(conn);
                }
                other.replaceWith(this);
                
                parentSets().addAll(other.parentSets());
                
                for (ConnectorMember member : other.members.values()) {
                    ConnectorMember local = members.get(member.name);
                    if (local == null) {
                        local = new ConnectorMember(member);
                        local.addParentSet(this);
                        members.put(local.name, local);
                    } else {
                        local.merge(member);
                    }
                    local.removeParentSet(other);
                }
                
                for (ConnectorMember member : other.owningMembers) {
                    owningMembers.add(member);
                    member.replaceSet(this);
                }
            }
            
            private ExpandableSet actual() {
                if (replacement == null) {
                    return this;
                } else {
                    replacement = replacement.actual();
                    return replacement;
                }
            }
            
            private void replaceWith(ExpandableSet other) {
                replacement = other.actual();
                // Don't process this set
                expanded = true;
                nestedDone = true;
            }
            
            /**
             * Add a member to the connectors of the set, possibly as expandable connector members 
             * that members are recursively added to.
             */
            public void addMember(InstAccess source, InstAccess unknown, InstAccess unknownPart) {
                String name = unknownPart.name();
                ConnectorMember member = members.get(name);
                if (unknownPart == unknown.getLastInstAccess()) {
                    FArraySubscripts fas = unknownPart.hasFArraySubscripts() ? unknownPart.getFArraySubscripts() : null;
                    if (member == null) {
                        member = new ConnectorMember(name, source, fas);
                        members.put(name, member);
                    } else {
                        member.addConnection(source, fas);
                    }
                } else {
                    // TODO: probably need more to support arrays in this case
                    if (member == null) {
                        member = new ConnectorMember(name, unknown);
                        members.put(name, member);
                    }
                    member.set().addMember(source, unknown, unknownPart.getNextInstAccess());
                }
                member.addParentSet(actual());
            }
            
            /**
             * Add a declared member to the connectors of the set.
             * 
             * This is only used to include nested expandable connectors.
             */
            public void addDeclared(String name) {
                ConnectorMember member = members.get(name);
                if (member == null) 
                    members.put(name, new ConnectorMember(name));
            }
            
            /**
             * Add a duplicate version of the expandable connector.
             * 
             * All encountered duplicate versions are expanded.
             */
            public void addConnector(InstComponentDecl connector) {
                connectors.add(connector);
                bind(connector, this);
            }
            
            /**
             * Add another set as a parent to this one.
             * 
             * All parent sets will be expanded before this one.
             */
            public void addParentSet(ExpandableSet parentSet) {
                parentSets.add(parentSet);
            }

            /**
             * Remove another set from list of parents.
             */
            public void removeParentSet(ExpandableSet parentSet) {
                parentSets.remove(parentSet);
            }
            
            /**
             * Get the list of sets that need to be expanded before this one, 
             * updated for replacements.
             */
            private Set<ExpandableSet> parentSets() {
                boolean replace = false;
                for (ExpandableSet parent : parentSets) {
                    replace |= parent.replacement != null;
                }
                if (replace) {
                    Set<ExpandableSet> replacement = new HashSet<>();
                    for (ExpandableSet parent : parentSets) {
                        replacement.add(parent.actual());
                    }
                    parentSets = replacement;
                }
                return parentSets;
            }
            
            /**
             * Create a list with the components each connector in this set should have.
             * 
             * @param members  the members of this set, sorted by name
             */
            public void expandConnector(InstComponentDecl parent, ConnectorMember[] members) {
                List<InstComponentDecl> memberList = new List<InstComponentDecl>();
                memberList.setParent(parent); // Make sure inherited attributes work at once
                InstComponentDecl[] templates = new InstComponentDecl[members.length];
                int i = 0;
                for (ConnectorMember member : members) {
                    memberList.add(member.createInstComponent(parent));
                    templates[i++] = member.template(parent);
                }
                parent.expandConnector(memberList, templates);
            }
            
            /**
             * Check if the given expandable set describes a set of connectors that will contain 
             * one of the connectors described by this set (directly or indirectly).
             */
            private boolean isOrAncestor(ExpandableSet other) {
                return other == this || isOrAncestorHelper(other, new HashSet<ExpandableSet>());
            }
            
            private boolean isOrAncestorHelper(ExpandableSet other, Set<ExpandableSet> visited) {
                /* If we have already been here, we either have a loop among the ancestors, 
                 * or a diamond pattern in the graph. Neither case means that there is a loop 
                 * involving other.
                 */
                if (visited.add(this)) {
                    for (ExpandableSet parent : parentSets) {
                        if (parent == other || parent.isOrAncestorHelper(other, visited)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            
            public String toString() {
                StringBuilder buf = new StringBuilder("Connectors:");
                for (InstComponentDecl c : connectors) {
                    buf.append("\n  ");
                    buf.append(c.qualifiedName());
                }
                buf.append("\nMembers:");
                for (ConnectorMember m : members.values()) {
                    buf.append("\n  ");
                    buf.append(m.name);
                }
                return buf.toString();
            }
            
            private class ConnectorMember implements Comparable<ConnectorMember> {
                
                public final String name;
                private ExpandableSet set;
                private java.util.List<Source> sources;
                private java.util.List<InstAccess> nestledAccesses;
                private InstComponentDecl template;
                private Map<InstComponentDecl,InstComponentDecl> templateMap;
                private FArraySubscripts subscripts;
                private boolean error;
                private boolean calculated;
                
                public ConnectorMember(String name) {
                    this.name = name;
                    sources = new ArrayList<Source>(4);
                    nestledAccesses = new ArrayList<InstAccess>(2);
                    template = null;
                    templateMap = null;
                    subscripts = null;
                    calculated = false;
                    error = false;
                }
                
                public ConnectorMember(String name, InstAccess target, FArraySubscripts fas) {
                    this(name);
                    addConnection(target, fas);
                }
                
                public ConnectorMember(String name, InstAccess unknown) {
                    this(name);
                    nestledAccesses.add(unknown);
                }
                
                public ConnectorMember(ConnectorMember other) {
                    this(other.name);
                    merge(other);
                    nestledAccesses = other.nestledAccesses;
                }
                
                public int compareTo(ConnectorMember other) {
                    return name.compareTo(other.name);
                }
                
                public void addConnection(InstAccess target, FArraySubscripts fas) {
                    sources.add(new Source(target, fas));
                    InstComponentDecl targetVar = target.myInstComponentDecl();
                    ExpandableSet otherSet = map.get(targetVar);
                    if (otherSet == null && targetVar.isExpandableConnector()) {
                        if (set == null) {
                            set = setFor(targetVar);
                        } else {
                            set().addConnector(targetVar);
                        }
                    } else {
                        if (set == null) {
                            set = otherSet;
                        } else {
                            set().merge(otherSet);
                        }
                    }
                }
                
                public void merge(ConnectorMember other) {
                    if (set == null) {
                        set = other.set;
                    } else if (other.set != null) {
                        set().merge(other.set());
                    }
                    for (Source s : other.sources) {
                        sources.add(new Source(s));
                    }
                }
                
                public ExpandableSet set() {
                    if (set == null) {
                        set = new ExpandableSet(this);
                    }
                    set = set.actual();
                    return set;
                }
                
                public void replaceSet(ExpandableSet newSet) {
                    set = newSet;
                }
                
                public void addParentSet(ExpandableSet parentSet) {
                    if (set != null) {
                        set().addParentSet(parentSet);
                    }
                }
                
                public void removeParentSet(ExpandableSet parentSet) {
                    if (set != null) {
                        set().removeParentSet(parentSet);
                    }
                }
                
                /**
                 * Check if all connections to this member are consistent.
                 * 
                 * @return  <code>false</code> if any errors were found
                 */
                public boolean check() {
                    if (!calculated)
                        calculateVariable();
                    return !error;
                }
                
                public InstComponentDecl createInstComponent(InstComponentDecl parent) {
                    InstComponentDecl tmpl = template(parent);
                    InstComponentDecl res;
                    if (tmpl.name().equals(name) && tmpl.isChildOf(parent)) {
                        if (subscripts() != null) {
                            tmpl.setLocalFArraySubscripts(subscripts());
                        }
                        res = tmpl;
                    } else {
                        SrcComponentDecl cd = tmpl.getSrcComponentDecl();
                        res = tmpl.myInstClass().newInstComponentDeclCopy(
                                name, subscripts(), cd, cd.getClassName());
                    }
                    if (tmpl.isExpandableConnector()) {
                        ExpandableSet set2 = setFor(tmpl);
                        set2.addConnector(res);
                        if (set != null) {
                            set().merge(set2);
                        }
                    }
                    return res;
                    // TODO: handle input/output (or is that really needed?)
                }
                
                private InstComponentDecl template(InstComponentDecl parent) {
                    if (!calculated) {
                        calculateVariable();
                    }
                    if (templateMap != null) {
                        InstComponentDecl declared = templateMap.get(parent);
                        if (declared != null) {
                            return declared;
                        }
                    }
                    return template;
                }
                
                private FArraySubscripts subscripts() {
                    if (!calculated)
                        calculateVariable();
                    return subscripts;
                }
                
                private void calculateVariable() {
                    error = false;
                    
                    // Check for recursive structure first.
                    if (set != null) {
                        for (Source src : sources) {
                            if (!src.checkRecursion(ExpandableSet.this)) {
                                error = true;
                            }
                        }
                        if (error) {
                            return;  // We risk infinite recursion if we continue
                        }
                    }
                    
                    // Collect instances of this member from declarations
                    ArrayList<InstComponentDecl> declared = new ArrayList<InstComponentDecl>();
                    Map<InstComponentDecl,InstComponentDecl> declaredMap = new HashMap<>();
                    for (InstComponentDecl conn : connectors) {
                        InstLookupResult<InstComponentDecl> res = conn.memberInstComponent(name);
                        if (res.successful()) {
                            InstComponentDecl decl = res.target();
                            declared.add(decl);
                            declaredMap.put(conn, decl);
                        }
                    }
                    
                    // Pick a variable to use as template
                    ASTNode templateErrorNode = null;
                    if (sources.isEmpty() && declared.isEmpty()) {
                        error = true;
                        for (InstAccess nestledAccess : nestledAccesses)
                            nestledAccess.compliance("Nested expandable connectors where some of the intermediate expandable connectors are neither connected to or declared are not supported");
                    } else if (declared.isEmpty()) {
                        template = sources.get(0).template();
                        templateErrorNode = sources.get(0).errorNode();
                    } else {
                        template = declared.get(0);
                        templateErrorNode = template;
                        templateMap = declaredMap;
                    }
                    
                    // Check types against template
                    if (template != null && !template.checkAsExpandableMemberTemplate(templateErrorNode))
                        error = true;
                    for (Source src : sources)
                        src.checkType(template);
                    for (InstComponentDecl decl : declared) {
                        if (!decl.connectableTypes(template)) {
                            error = true;
                            decl.error("Type of declared member of expandable connector does not match declarations in other expandable connectors in same connection set");
                        }
                    }
                    
                    // Calculate size
                    SummedSize ss = new SummedSize();
                    for (InstComponentDecl decl : declared)
                        ss.updateFromDeclaration(decl);
                    for (Source src : sources)
                        src.collectSize(ss);
                    Size s = ss.size;
                    if (template != null && template.ndims() > template.localNdims()) {
                        s = s.contract(0, template.ndims() - template.localNdims());
                    }
                    
                    // Create subscripts for size
                    if (s != Size.SCALAR && s != null) {
                        subscripts = s.createFArrayExpSubscripts();
                    }
                    
                    // Check against connections to non-existing members of non-expandable connectors
                    if (!sources.isEmpty() && set != null && set().connectors.isEmpty() && !set().members.isEmpty()) 
                        for (ConnectorMember m : set().members.values())
                            error = !m.checkNonExisting(template) || error;
                    
                    // Check array index types. If there is a declaration they are checked in FExpSubscript.typeCheckAsIndex;
                    if (declared.isEmpty()) {
                        Source tmpl = null;
                        for (Source src : sources) {
                            if (tmpl == null)
                                tmpl = src;
                            if (!src.checkIndexType(tmpl))
                                break;
                        }
                    }
                    calculated = true;
                }
                
                private boolean checkNonExisting(InstComponentDecl parentTemplate) {
                    boolean res = true;
                    InstComponentDecl myTemplate = (parentTemplate != null) ? parentTemplate.memberInstComponent(name).targetOrNull() : null;
                    if (myTemplate == null) {
                        for (Source s : sources)
                            s.errorNode().error("Can not connect to non-existing member of non-expandable connector in expandable connector");
                        res = false;
                    }
                    if (set != null) 
                        for (ConnectorMember m : set().members.values())
                            res = m.checkNonExisting(myTemplate) && res;
                    return res;
                }
                
                public String toString() {
                    return name + ": " + sources.toString();
                }
                
                private class Source {
                    
                    private InstAccess target;
                    private FArraySubscripts fas;
                    private boolean errorReported = false;
                    
                    private Size s;
                    private boolean[] fixed;
                    
                    public Source(InstAccess target, FArraySubscripts fas) {
                        this.target = target;
                        this.fas = fas;
                        calculateSize();
                    }
                    
                    public Source(Source other) {
                        this.target = other.target;
                        this.fas = other.fas;
                        this.s      = other.s;
                        this.fixed  = other.fixed;
                    }
                    
                    private void calculateSize() {
                        // Calculate local size
                        Size ts = target.size();
                        if (fas != null) {
                            MutableSize ms = new MutableSize(fas.ndims());
                            fixed = new boolean[ms.ndims()];
                            int tspos = 0;
                            for (int i = 0; i < fixed.length; i++) {
                                Subscript sub = fas.subscript(i);
                                int len = (tspos < ts.ndims()) ? ts.get(tspos) : 1;
                                if (!sub.calculateExpandableConnectorSize(ms, i, len)) 
                                    localError();
                                fixed[i] = sub.isColon();
                                if (sub.ndims() > 0) 
                                    tspos++;
                            }
                            if (tspos != ts.ndims())
                                localError();
                            s = ms;
                        } else {
                            s = (ts == Size.SCALAR) ? ts : ts.mutableClone();
                            fixed = new boolean[s.ndims()];
                            Arrays.fill(fixed, true);
                        }
                    }
                    
                    public void collectSize(SummedSize ss) {
                        if (errorReported)
                            return;
                        
                        // Merge with other sizes in set
                        if (!ss.merge(s, fixed))
                            mismatchError();
                   }
                    
                    public void checkType(InstComponentDecl template) {
                        if (!target.myInstComponentDecl().connectableTypes(template))
                            error("Type of component introduced to external connector does not match other connections to same name in connection set or component declared in connector");
                    }
                    
                    public boolean checkIndexType(Source other) {
                        if (fas == null || other.fas == null)
                            return true;
                        for (int dim = 0; dim < Math.min(fas.ndims(), other.fas.ndims()); dim++) {
                            if (!fas.subscript(dim).type().scalarType().typeCompatible(
                                    other.fas.subscript(dim).type().scalarType())) {
                                error("Array index type of component introduced to external connector does not match other"
                                        + " connections to same name in connection set");
                                return false;
                            }
                        }
                        return true;
                    }
                    
                    public boolean checkRecursion(ExpandableSet parent) {
                        ExpandableSet ancestor = map.get(target.myInstComponentDecl());
                        if (ancestor != null && parent.isOrAncestor(ancestor)) {
                            error("Connect introduces a copy of " + target + 
                                  " into a connector that is (possibly indirectly) connected back to " + target + 
                                  ". This creates an infinite recursive structure, and is not allowed:\n    " + 
                                  errorNode());
                            return false;
                        }
                        return true;
                    }
                    
                    private void mismatchError() {
                        error("Size introduced for external connector member does not match other connections to same name in connection set or component declared in connector");
                    }
                    
                    private void localError() {
                        error("Can not match size of connector to access introducing member in external connector");
                    }
                    
                    private void error(String err) {
                        error = true;
                        if (!errorReported) {
                            errorReported = true;
                            errorNode().error(err);
                        }
                    }
                    
                    public InstComponentDecl template() {
                        return target.myInstComponentElement();
                    }
                    
                    public ASTNode errorNode() {
                        return target.getParent();
                    }
                    
                    public String toString() {
                        return target.toString() + ((fas != null) ? (" (" + fas + ")") : "");
                    }
                    
                }
                
                private class SummedSize {
                    
                    public Size size = null;
                    public boolean[] fixed = null;
                    
                    public void updateFromDeclaration(InstComponentDecl icd) {
                        if (!mergeKnownFixed(icd.size())) {
                            error = true;
                            icd.error("Size of declared member of expandable connector does not match declarations in other expandable connectors in same connection set");
                        }
                    }
    
                    private boolean mergeKnownFixed(Size s) {
                        if (s != Size.SCALAR)
                            s = s.mutableClone();
                        boolean[] sFixed = new boolean[s.ndims()];
                        for (int i = 0; i < sFixed.length; i++)
                            sFixed[i] = s.hasValue(i);
                        return merge(s, sFixed);
                    }
    
                    public boolean merge(Size s, boolean[] sFixed) {
                        if (size == null) {
                            size = s;
                            fixed = sFixed;
                        } else if (sFixed.length != fixed.length) {
                            return false;
                        } else {
                            for (int i = 0; i < fixed.length; i++) {
                                int diff = s.get(i) - size.get(i);
                                if (sFixed[i]) {
                                    if (diff == 0) {
                                        fixed[i] = true;
                                    } else if (diff < 0) {
                                        return false;
                                    }
                                } 
                                if (diff > 0) {
                                    if (fixed[i]) {
                                        return false;
                                    } else {
                                        fixed[i] = sFixed[i];
                                        ((MutableSize) size).set(i, s, i);
                                    }
                                }
                            }
                        }
                        return true;
                    }
                    
                }
        }

        }


}
