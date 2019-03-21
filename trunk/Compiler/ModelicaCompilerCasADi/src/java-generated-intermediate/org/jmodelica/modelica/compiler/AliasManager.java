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
 * @aspect AliasVariables
 * @declaredat C:\\stuff\\workspace\\JModelica\\Compiler\\ModelicaMiddleEnd\\src\\jastadd\\optimizations\\AliasVariables.jadd:130
 */
public class AliasManager extends java.lang.Object {
    
	
		// Alias error messages.
		private Collection<String> aliasErrorMessages = new ArrayList<String>();

    
		
		// A set of alias sets
		private Set<AliasSet> aliasSets = new LinkedHashSet<AliasSet>();

    
		
		// A map that maps FVariable to its alias set.
		private Map<FVariable, AliasVariable> variableMap = new HashMap<FVariable, AliasVariable>();

    
		
		/**
		 * Report any detected alias errors.
		 * 
		 * @param fc  where to report errors
		 */
		public void reportAliasErrors(FClass fc) {
			for (String msg : aliasErrorMessages)
				fc.error(msg);
			aliasErrorMessages.clear();
		}

    
		
		/**
		 * Get the set of alias sets.
		 * 
		 * @return A set containing the alias sets.
		 */
		public Set<AliasSet> getAliasSets() {
			return aliasSets;
		}

    
		
		/**
		 * Get the AliasVariable object corresponding to an FVariable
		 * 
		 * @param fv An FVariable object
		 * @return The alias variable that corresponds to an FVariable
		 */
		public AliasVariable getAliasVariable(FVariable fv) {
			return variableMap.get(fv);
		}

    
		

		/**
		 * Retrieve the alias set corresponding to an FVariable.
		 * 
		 * Returns null if the FVariable is not present in an alias set.
		 * 
		 * @param fv  An FVariable.
		 * @return The alias set corresponding to the alias variable.
		 */
		public AliasSet getAliasSet(FVariable fv) {
			AliasVariable alias = variableMap.get(fv);
			if (alias == null)
				return null;
			return alias.getSet();
		}

    
		
		/**
		 * Remove a variable and its alias set from the alias manager.
		 */
        public void unAlias(FVariable fv) {
            AliasSet as = fv.aliasSet();
            for (AliasVariable av : as)
                variableMap.remove(av.fv);
            aliasSets.remove(as);
        }

    
        
		/**
		 * Add a pair of alias variables to the alias manager.
		 */
		public void addAliasVariables(AliasPair pair) {
			addAliasVariables(pair.fv1, pair.fv2, pair.negated);
		}

    

		/**
		 * Add a pair of alias variables to the alias manager.
		 * 
		 * @param fvA An FVariable.
		 * @param fvB Another FVariable.
		 * @param neg True if the alias pair is negated, otherwise false.
		 * 
		 */
		public void addAliasVariables(FVariable fvA, FVariable fvB, boolean neg) {
			/*
			 * Rules for alias sets:
			 * 
			 *  1. An alias variable can only occur in one alias set
			 *  2. An alias variable can occur either negated or
			 *     non-negated in an alias set, not both.
			 *  
			 *  These rules are enforced by the algorithm below: if a
			 *  rule is about to be broken an error message is generated.
			 *  			
			 *  Notice that LinkedHashSets are expected to be persistent, 
			 *  therfore alias sets need to be temporarily removed from the
			 *  set, then modified, then reinserted.
			 */
			
			AliasVariable aliasA = getAliasVariable(fvA);
			AliasVariable aliasB = getAliasVariable(fvB);
			
			if (aliasA != null && aliasB != null) {
				merge(aliasA, aliasB, neg);
			} else if (aliasA != null) {
				add(aliasA.getSet(), fvB, aliasA.isNegated() ? !neg : neg);
			} else if (aliasB != null) {
				add(aliasB.getSet(), fvA, aliasB.isNegated() ? !neg : neg);
			} else {
				join(fvA, fvB, neg);
			}
            if (fvA.isTemporary())
                getAliasVariable(fvA).setTempAssignRight(fvB);
		}

    
		
		private static final String MERGE_ERROR_MESSAGE = 
				"Alias error: trying to add the %salias pair (%s,%s%s) to the alias set %s";

    
		
		/**
		 * Merges two alias variables <code>aliasA</code> and <code>aliasB</code>.
		 * The implementation also check the rules for a alias set is maintained.
		 * 
		 * @param aliasA First alias variable
		 * @param aliasB Second alias variable
		 * @param neg True if the alias pair is negated, otherwise false.
		 */
		private void merge(AliasVariable aliasA, AliasVariable aliasB, boolean neg) {
			AliasSet mergeSet = aliasB.getSet();
			AliasSet resultSet = aliasA.getSet();
			if (resultSet == mergeSet) {
				if ((aliasA.isNegated() == aliasB.isNegated()) == neg) {
					aliasErrorMessages.add(String.format(MERGE_ERROR_MESSAGE, 
							neg ? "negated " : "", 
							aliasA.getFVariable().name(), 
							neg ? "-" : "", 
							aliasB.getFVariable().name(), 
							resultSet)); 
				}
				return;
			}
			boolean shouldNegate = aliasA.isNegated() == aliasB.isNegated() ? neg : !neg;
            resultSet.merge(mergeSet, shouldNegate);
			aliasSets.remove(mergeSet);
		}

    
		
		/**
		 * Add a new variable to an exisiting alias set.
		 * 
		 * @param set The existing alias set
		 * @param fv The new alias variable
		 * @param neg True if the alias variable is negated, otherwise false.
		 */
		private void add(AliasSet set, FVariable fv, boolean neg) {
			set.add(new AliasVariable(fv, neg, variableMap));
		}

    
		
		/**
		 * Creates a new alias set based on the two variables.
		 * 
		 * @param fvA First variable
		 * @param fvB First variable
		 * @param neg True if the alias pair is negated, otherwise false.
		 */
		private void join(FVariable fvA, FVariable fvB, boolean negate) {
			AliasSet set = new AliasSet();
			aliasSets.add(set);
			set.add(new AliasVariable(fvA, false, variableMap));
			set.add(new AliasVariable(fvB, negate, variableMap));
		}

    
		
		/**
		 * Print the alias sets, with start attributes.
		 * 
		 * @return A string containing the alias sets.
		 */
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			for (AliasSet aliasSet : aliasSets) {
				str.append(aliasSet.toStringWithStart() +"\n");
			}
			return str.toString();		
		}

    

        /**
         * Removes the alias set for the temporary variable provided.
         * Errorchecks are done to ensure that only temporary variables are
         * removed. However if the system variable is a temporary variable
         * then all of the variables in the set should be temporaries.
         * 
         * This method returns a collection with all the variables removed
         */
        public Collection<FVariable> removeTemporaryVariableSet(FVariable fv) {
            if (!fv.isTemporary()) {
                throw new UnsupportedOperationException("FVariable " + fv.name() + " of java class " + fv.getClass().getSimpleName() + " is not a temporary variable!");
            }
            AliasVariable av = variableMap.get(fv);
            if (av == null) {
                return Collections.<FVariable>emptyList();
            }
            AliasSet as = av.getSet();
            Collection<FVariable> removedVars = new ArrayList<FVariable>();
            for (AliasVariable aliasVar : as) {
                if (!aliasVar.getFVariable().isTemporary()) {
                    throw new UnsupportedOperationException("FVariable " + fv.name() + " of java class " + fv.getClass().getSimpleName() + " is not a temporary variable!");
                }
                variableMap.remove(aliasVar.getFVariable());
                removedVars.add(aliasVar.getFVariable());
            }
            aliasSets.remove(as);
            return removedVars;
        }

    

		/**
		 * A class representing a set of alias variables.
		 */
		public class AliasSet implements Iterable<AliasVariable> {
			
			// List of aliases
			private java.util.List<AliasVariable> aliases = new ArrayList<AliasVariable>();
            private AliasVariable model = null;
            private long score = 0;
			
			/**
			 * Private constructor
			 */
			private AliasSet() {
			}
			
            /*
             * Recompute the model variable.
             */
            public void recompute() {
                AliasVariable oldModelVariable = model;
                java.util.List<AliasVariable> oldAliases = aliases;
                aliases = new ArrayList<>();
                model = null;
                score = 0;
                for (AliasVariable v : oldAliases) {
                    add(v);
                }
            }
			
			/**
			 * An iterator over all the alias variables in this set.
			 * 
			 * @return An iterator for this set
			 */
			@Override
			public Iterator<AliasVariable> iterator() {
				return aliases.iterator();
			}
			
			/**
			 * Adds a new alias variable to this set.
			 * 
			 * @param newAlias Alias variable to add
			 */
			private void add(AliasVariable newAlias) {
                _add(newAlias);
                model(newAlias);
			}
			
            /**
             * Adds a new alias variable to this set
             * without updating model variable.
             * 
             * @param newAlias Alias variable to add
             */
            private void _add(AliasVariable newAlias) {
                newAlias.setSet(this);
                aliases.add(newAlias);
            }
            
            /**
             * Update model variable if <code>newAlias</code>
             * has a better alias heuristic score.
             * 
             * @param newAlias Alias variable to check
             */
            private void model(AliasVariable newAlias) {
                if (newAlias != null) {
                    long newScore = newAlias.getFVariable().aliasHeuristicScore();
                    if (newScore > score) {
                        model = newAlias;
                        score = newScore;
                    }
                }
            }
            
            /**
             * Add all AliasVariables from <code>mergeSet</code> into
             * <code>this</code>. Does not modify or remove <code>mergeSet</code>.
             * 
             * @param mergeSet Alias set absorb
             * @param negate True if set should be negated
             */
            private void merge(AliasSet mergeSet, boolean negate) {
                for (AliasVariable a : mergeSet) {
                    if (negate)
                        a.negated = !a.negated;
                    _add(a);
                }
                if (mergeSet.score > score) {
                    model = mergeSet.model;
                    score = mergeSet.score;
                }
            }
            
			
			/**
             * Get the model variable of this alias set.
			 * 
             * @return The model variable of this alias set.
			 */
            public AliasVariable getModelVariable() {
                return model;
			}
			
			/**
			 * Method for retreiving the number of aliases in this set.
			 * 
			 * @return The number of aliases in this set
			 */
			public int numAliases() {
				return aliases.size();
			}
			
			@Override
			public String toString() {
				return toString(false);
			}
			
			public String toStringWithStart() {
				return toString(true);
			}
			
			private String toString(boolean withStart) {
				String sep = withStart ? ", " : ",";
				StringBuilder str = new StringBuilder();
				str.append("{");
				
                AliasVariable model = getModelVariable();
                str.append(model.toString(withStart));
				
				for (AliasVariable alias : aliases) {
                    if (alias == model)
						continue;
					str.append(sep);
					str.append(alias.toString(withStart));
				}
				str.append("}");
				return str.toString();
			}
			
			/**
			 * A more verbose version of toString().
			 * 
			 * @return More info about this set
			 */
			public String toStringVerbose() {
				StringBuilder str = new StringBuilder();
                str.append("Alias set: (" + getModelVariable().getFVariable().name() + ")\n");
				for (AliasVariable alias : aliases) {
					if (alias.isNegated()) {
						str.append("-");
					}
					str.append(alias.getFVariable().name());
					str.append(" " + alias.getFVariable().aliasHeuristicScore() + " ");
					str.append(" " + alias.getFVariable().varKind() + "\n");
				}
				return str.toString();
			}

            protected void removeVariableFromSet(AliasVariable var) {
                aliases.remove(var);
            }

			
		}

    
		
		/**
		 * AliasVariable is used to encapsulate an FVariable and whether
		 * the alias is negated. 
		 * 
		 * AliasVariable implements the Comparable interface and objects of the 
		 * class are used in the alias sets.
		 */
		public static class AliasVariable {
			
			// The FVariable
			private FVariable fv;
			// Negated attribute
			private boolean negated = false;
			
			// The set that this alias variable belong to
			private AliasSet set;
			
			/**
			 * Constructor.
			 * 
			 * @param fv           An FVariable.
			 * @param negated      True if the alias is negated, otherwise false.
			 * @param variableMap  Map to add the new AliasVariable to.
			 */
			private AliasVariable(FVariable fv, boolean negated, Map<FVariable, AliasVariable> variableMap) {
				this.fv = fv;
				this.negated = negated;
				variableMap.put(fv, this);
			}
		
			/**
			 * Returns true if the alias is negated.
			 * 
			 * @return True if the alias is negated, otherwise false.
			 */
			public boolean isNegated() {
				return negated;
			}
		
			/**
			 * Getter for the FVariable.
			 * 
			 * @return The FVariable.
			 */
			public FVariable getFVariable() {
				return fv;
			}	
			
			/**
			 * Returns the alias set that this alias variable belong to.
			 * 
			 * @return Alias set that this alias belong to
			 */
			public AliasSet getSet() {
				return set;
			}
			
			/**
			 * Private method for changing the set that this alias belong to.
			 * This method should only be used when the alias initially is added
			 * of when two alias sets are merged.
			 * 
			 * @param set The new set that this alias should belong to
			 */
			private void setSet(AliasSet set) {
				this.set = set;
			}
			
			@Override
			public String toString() {
				return toString(false);
			}
			
			protected String toString(boolean withStart) {
				StringBuilder buf = new StringBuilder();
				if (isNegated())
					buf.append('-');
				FVariable fv = getFVariable();
				buf.append(fv.displayName());
				if (withStart && fv.startAttributeSet()) {
					buf.append("(start=");
                    buf.append(fv.startAttributeExp().toString());
					buf.append(")");
				}
				return buf.toString();
			}
			
            /**
             * This tempAssignRight functionality is needed when resolving the
             * original alias variable for variable incidences in equations.
             * Due to how the functioninlining works this information would
             * otherwise be lost. E.g.:
             *   x = z;
             *   temp_1 = x;
             *   y = cos(temp_1);
             * Which might eventually become:
             *   y = cos(z);
             * In this situation we wan't to know that the x was the original
             * reference in the cos expression. Hence this functionality
             */
            private FVariable tempAssignRight;
            
            private void setTempAssignRight(FVariable var) {
                tempAssignRight = var;
            }
            
            public FVariable getTempAssignRight() {
                return tempAssignRight;
            }
		}

    
		
		
		public static class AttributePropagatorMap {

			private Map<String, AttributePropagator> map;
			private AliasVariable target;

			public AttributePropagatorMap(AliasVariable av) {
				map = new LinkedHashMap<String,AttributePropagator>();
				target = av;
				addAlias(av);
			}

			public void propagate() {
				List<FAttribute> l = new List<FAttribute>();
				for (AttributePropagator ap : map.values())
					ap.propagate(l);
				target.getFVariable().setFAttributeList(l);
			}
			
			public void addAlias(AliasVariable av) {
				FVariable fv = av.getFVariable();
				boolean neg = av.isNegated();
				for (FAttribute attr : fv.getFAttributes())
					addAttribute(attr, fv, neg);
				if (fv.myFDerivedType() != null)
					for (FAttribute attr : fv.myFDerivedType().getFAttributes())
						addTypeAttribute(attr, fv, neg);
			}
			
			private void addAttribute(FAttribute attr, FVariable fv, boolean neg) {
				get(attr.name()).addAttribute(attr, neg);
			}

			private void addTypeAttribute(FAttribute attr, FVariable fv, boolean neg) {
				AttributePropagator ap = get(attr.name());
				if (!ap.lastIsInFV(fv))
					ap.addAttribute(attr, neg);
			}

			private AttributePropagator get(String name) {
				AttributePropagator ap = map.get(name);
				if (ap == null) {
					ap = createAttributePropagator(name);
					ap.addToMap(map);
				}
				return ap;
			}

			private AttributePropagator createAttributePropagator(String name) {
				if (name.equals(FAttribute.START) || name.equals(FAttribute.NOMINAL))
					return new LevelAttributePropagator(name);
				else if (name.equals(FAttribute.FIXED))
				    return new BooleanReduceAttributePropagator(name, false);
                else if (name.equals(FAttribute.MIN) || name.equals(FAttribute.MAX))
                    return new MinMaxAttributePropagator(name);
				else
					return new KeepAttributePropagator(name);
			}

			private abstract class AttributePropagator {

			    protected String name;
				protected ArrayList<FAttribute> list = new ArrayList<FAttribute>();
				protected BitSet neg = new BitSet();
                
                public AttributePropagator(String name) {
                    this.name = name;
                }

				public void addAttribute(FAttribute attr, boolean neg) {
					this.neg.set(list.size(), neg);
					list.add(attr);
				}

				public boolean lastIsInFV(FVariable fv) {
					int n = list.size();
					return n > 0 && list.get(n - 1).isInFV(fv);
				}
				
				public void addToMap(Map<String, AttributePropagator> map) {
                    map.put(name, this);
				}

                protected void select(int i, List<FAttribute> l) {
                    if (i < 0)
                        return;
                    FAttribute sel = list.get(i);
                    
                    // Don't add attributes from own type
                    FVariable targetFV = target.getFVariable();
                    boolean inTarget = sel.isInFV(targetFV);
                    if (!inTarget && targetFV.findAttribute(name) == sel)
                        return;
                    
                    // If it is taken from elsewhere, we need a copy
                    if (!inTarget) {
                        sel = sel.fullCopy();
                        sel.parent = list.get(i).parent;
                    }
                    
                    // Value may need to be negated
                    if (neg.get(i) != target.isNegated() && sel.hasValue())
                        negate(sel);
                    
                    l.add(sel);
                }

				protected void negate(FAttribute sel) {
				    sel.setValue(sel.getValue().createNegated());
				}
				
				public abstract void propagate(List<FAttribute> l);

			}
			
			/**
			 * Used for attributes that are not specifically handled.
			 * 
			 * Only adds back the attribute from the target variable, if any.
			 */
			private class KeepAttributePropagator extends AttributePropagator {
                
                public KeepAttributePropagator(String name) {
                    super(name);
                }

				public void propagate(List<FAttribute> l) {
					if (list.size() > 0 && list.get(0).isInFV(target.getFVariable())) 
						l.add(list.get(0));
				}
				
			}
			
			/**
			 * Selects the attribute that was set "closest to the user".
			 * 
			 * Used for start and nominal.
			 * 
			 * Selects the value with lowest level among attributes set on variables, 
			 * or if no such are found the first found from a type. 
			 */
			private class LevelAttributePropagator extends AttributePropagator {
				
				private final static int NO_KIND   = 0;
				private final static int TYPE_KIND = 1;
				private final static int FV_KIND   = 2;
				
				public LevelAttributePropagator(String name) {
				    super(name);
				}

				public void propagate(List<FAttribute> l) {
					int selKind = NO_KIND;
					int selLevel = 0;
					int selIndex = -1;
					int i = 0;
					for (FAttribute attr : list) {
						int curKind = attr.isInFV() ? FV_KIND : TYPE_KIND;
						int curLevel = attr.getLevel();
						if (curKind > selKind || (curKind == FV_KIND && curLevel < selLevel)) {
							selKind = curKind;
							selLevel = curLevel;
							selIndex = i;
						}
						i++;
					}
					select(selIndex, l);
				}
				
			}
            
            /**
             * Combine values from all variables in alias set using boolean operation (and/or).
             * 
             * Used for fixed.
             */
            private class BooleanReduceAttributePropagator extends AttributePropagator {
                
                private boolean isAnd;
                
                public BooleanReduceAttributePropagator(String name, boolean isAnd) {
                    super(name);
                    this.isAnd = isAnd;
                }

                public void propagate(List<FAttribute> l) {
                    boolean res = isAnd;
                    int i = 0;
                    int selIndex = -1;
                    boolean selVal = false;
                    for (FAttribute attr : list) {
                        boolean val = false;
                        boolean set = false;
                        if (attr.hasValue()) {
                            try {
                                CValue cval = attr.getValue().ceval();
                                if (cval.hasBooleanValue()) {
                                    val = cval.booleanValue();
                                    set = true;
                                }
                            } catch (ConstantEvaluationException e) {}
                        }
                        res = isAnd ? (res && val) : (res || val);
                        if (val == res && (selIndex < 0 || selVal != res)) {
                            selIndex = i;
                            selVal = val;
                        }
                        i++;
                    }
                    select(selIndex, l);
               }
                
                protected void negate(FAttribute sel) {}
                
            }
            
            /**
             * Find strictest combination of min/max values.
             * 
             * Reports an error if this results in min > max.
             */
            private class MinMaxAttributePropagator extends AttributePropagator {
                
                private boolean propagated = false;
                
                public MinMaxAttributePropagator(String name) {
                    super(name);
                }
                
                public void addToMap(Map<String, AttributePropagator> map) {
                    map.put(FAttribute.MIN, this);
                    map.put(FAttribute.MAX, this);
                }

                public void propagate(List<FAttribute> l) {
                    if (propagated)
                        return;
                    propagated = true;
                    
                    double min = Double.NEGATIVE_INFINITY;
                    double max = Double.POSITIVE_INFINITY;
                    int i = 0;
                    int selMin = -1;
                    int selMax = -1;
                    boolean targetNeg = target.isNegated();
                    for (FAttribute attr : list) {
                        boolean isMin = attr.name().equals(FAttribute.MIN);
                        double val = isMin ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
                        try {
                            if (attr.hasValue()) {
                                CValue cval = attr.getValue().ceval();
                                if (cval.hasRealValue()) {
                                    val = cval.realValue();
                                }
                            }
                        } catch (ConstantEvaluationException e) {}
                        if (neg.get(i) != targetNeg) {
                            val = -val;
                            isMin = !isMin;
                        }
                        if (isMin) {
                            if (val > min) {
                                min = val;
                                selMin = i;
                            }
                        } else {
                            if (val < max) {
                                max = val;
                                selMax = i;
                            }
                        }
                        i++;
                    }
                    int p = l.getNumChild();
                    select(selMin, l, FAttribute.MIN);
                    select(selMax, l, FAttribute.MAX);
                    if (min > max) 
                        target.getFVariable().error("Variable %s is part of alias set that results in min/max combination with no possible values, min = %s, max = %s", 
                                target.getFVariable().name(), l.getChild(p).getValue(), l.getChild(p + 1).getValue());
                }
                
                protected void select(int i, List<FAttribute> l, String name) {
                    this.name = name;
                    select(i, l);
                }
                
                protected void negate(FAttribute sel) {
                    super.negate(sel);
                    String name = sel.name().equals(FAttribute.MIN) ? FAttribute.MAX : FAttribute.MIN;
                    sel.getName().setFAccess(new FAccessString(name));
                }
                
            }
        }

    private Map<FVariable, FVariable> derivativeBindingPairs = new HashMap<FVariable, FVariable>();

    public void addDerivativeBindingPair(FVariable var, FVariable derVar) {
        if (derivativeBindingPairs == null)
            return;
        derivativeBindingPairs.put(var, derVar);
    }

    public FVariable derivativeEquivalent(FVariable var) {
        return derivativeBindingPairs == null ? null : derivativeBindingPairs.get(var);
    }

    public void stopCollectingDerivativeBindings() {
        derivativeBindingPairs = null;
    }


}
