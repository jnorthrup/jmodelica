/*
    Copyright (C) 2017 Modelon AB

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, version 3 of the License.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package org.jmodelica.util.annotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jmodelica.common.URIResolver;
import org.jmodelica.common.URIResolver.URIException;
import org.jmodelica.util.Criteria;
import org.jmodelica.util.collections.FilteredIterable;
import org.jmodelica.util.values.ConstValue;
import org.jmodelica.util.values.ConstantEvaluationException;
import org.jmodelica.util.values.Evaluable;

/**
 * Generic class for handling traversal over different types 
 * of annotations but also other tree structures.
 * Mainly in the source and flat tree.
 * 
 * In several places in the code we have to upcast a variable in order to
 * assign a field or call a method. This is due to the field or method being
 * private and the local variable of a subtype. See
 * http://stackoverflow.com/questions/20672840/has-private-access-error-with-generics
 * for a good explanation.
 * 
 * @param <T> The sub-type of AnnotationNode which we are operating on
 * @param <N> The base node type which we deal with
 * @param <V> The value that is returned by the nodes
 */
public abstract class GenericAnnotationNode<T extends GenericAnnotationNode<T, N, V>,
        N extends AnnotationProvider<N, V>, V extends Evaluable> {

    /**
     * Vendor name.
     */
    public static final String VENDOR_NAME = "__Modelon";
    private final AnnotationStateManager state;

    /**
     * Constructor to create an unambiguous annotation node.<br>
     * <code>name</code> may be null, some nodes simply do not have a name.<br>
     * <code>node</code> may only be null for the instances returned by
     * {@link #ambiguousNode()} and nodes which don't exist yet.
     * 
     * @param name Name of the node, optionally null.
     * @param node The node that this annotation node represent.
     * @param parent The parent of the node
     */
    protected GenericAnnotationNode(String name, N node, T parent) {
        this(name, node, parent, false);
    }

    /**
     * Constructor to create an annotation node.<br>
     * An ambiguous node created with this constructor is immutable. 
     * That is, calling a state changing method on an unambiguous will not have any effect. 
     * No state change will occur nor will any exception be thrown.
     * <code>name</code> may be null, some nodes simply do not have a name.<br>
     * <code>node</code> may only be null for the instances returned by
     * {@link #ambiguousNode()} and nodes which don't exist yet.
     *
     * @param name Name of the node, optionally null.
     * @param node The node that this annotation node represent.
     * @param parent The parent of the node
     * @param ambiguous The ambiguity of the node.
     */
    protected GenericAnnotationNode(String name, N node, T parent, boolean ambiguous) {
    	state = ambiguous ? 
    			new AmbiguousAnnotationStateManager(name, node, parent) : 
    			new MutableAnnotationStateManager(name, node, parent);
    }

    /**
     * This is an internal method, do not call it.
     */
    private void computeSubNodesCache() {
        state.computeSubNodesCache();
    }

    protected boolean isSubNodesCacheFresh() {
        return state.isSubNodesCacheFresh();
    }

    protected boolean hasSubNodesCache() {
        return state.hasSubNodesCache();
    }
    /**
     * Sets the name and node of this GenericAnnotationNode. This is an internal method,
     * call {{@link #updateNode(String, AnnotationProvider)} instead.
     * @param newName The new name
     * @param node The new node
     */
    private void setNode(String newName, N node) {
        state.setNode(newName, node);
    }

    private void setSubNodeNodeWasSet() {
        state.setSubNodeNodeWasSet();
    }

    /**
     * This is an internal method. Call {{@link #updateNode(String, AnnotationProvider)}
     * instead.
     * @param newName the new name
     * @param newNode the new node
     * @param subNode the subNode to associate the node with
     */
    private void updateSubNode(String newName, N newNode, T subNode) {
        state.updateSubNode(newName, newNode, subNode);
    }

    private N createNodeForChild(GenericAnnotationNode<T, N, V> child) throws AnnotationEditException {
        return state.createNodeForChild(child);
    }

    /**
     * Navigate downwards in the annotation tree. The first element in the path
     * list is resolved relative to this node. Then the resolved node is used to
     * resolve the next one and so on.
     * @param path List of path elements to resolve
     * @return the resolved node
     */
    public T forPath(String... path) {
        return forPath(path, 0);
    }

    T forPath(String[] paths, int currentIndex) {
        return state.forPath(paths, currentIndex);
    }

    /**
     * Returns reference to it self, but with correct type! This pattern
     * ensures that all nodes have the same type as T.
     * All implementations of this method should simply return
     * <code>this</code>.
     * 
     * @return This node but with correct type
     */
    protected abstract T self();

    /**
     * Creates an annotation node representing the given name and node. One can
     * assume that it is a child of this node.
     * If null is returned, then the node will be filtered!
     * 
     * @param name Name of the new node
     * @param node The node which the annotation node is representing
     * @return An annotation node representing name and node
     */
    protected abstract T createNode(String name, N node);

    /**
     * Tries to infer the name from node and then calls <code>createNode(name, node)</code>.
     * <code>name</code> may be <code>null</code> at that point. 
     * @param node The node which the annotation node is representing
     * @return An annotation node representing node
     */
    protected abstract T createNode(N node);

    /**
     * Provides all sub nodes for this node that {@link #nodeExists()}.
     * 
     * @return all sub nodes that {@link #nodeExists()}
     */
    public Iterable<T> subNodes() {
        return state.subNodes();
    }

    /**
     * @return the node that this annotation node represents
     * 
     * @throws AnnotationEditException may be thrown if the node doesn't exist
     *          and it wasn't possible to create.
     */
    public N node() throws AnnotationEditException {
        return state.node();
    }

    /**
     * Return the node that this annotation represents without creating if it
     * doesn't exist. I.e.: simply return what we know without creating
     * anything.
     * 
     * @return The underlying node if available
     */
    protected N peekNode() {
        return state.peekNode();
    }

    /**
     * Tries to resolve the provided string as and URI.
     * 
     * @param str String to resolve as URI
     * @return canonical file:// URI or null on failure
     */
    public String resolveURI(String str) throws URIException {
        return state.resolveURI(str);
    }
    
    /**
     * 
     * @return the name of this annotation node, can be null
     */
    public String name() {
        return state.name();
    }

    /**
     * Updates the name and node of this GenericAnnotationNode.
     * @param newName The new name
     * @param node The new node
     */
    @SuppressWarnings("unchecked")
    protected void updateNode(String newName, N node) {
       state.updateNode(newName, node);
    }

    /**
     *
     * @return true if this node has a value, otherwise false
     */
    public boolean hasValue() {
        return value() != null;
    }

    /**
     * 
     * @return the value of this node, if it has one, otherwise null
     */
    public V value() {
        return state.value();
    }

    /**
     * Assigns a new value to this annotation and the actual node that this
     * annotation represents.
     * 
     * @param newValue The new value
     * @throws AnnotationEditException if it either wasn't possible to create
     *          the node or set the value of the node.
     */
    public void setValue(V newValue) throws AnnotationEditException {
        state.setValue(newValue);
    }

    /**
     * Interprets the value of this annotation as a sub annotation which can
     * be traversed and explored further.
     * 
     * @return An annotation representing the value of this annotation or null
     *          if it wasn't possible to interpret the value as an annotation.
     */
    public T valueAsAnnotation() {
        return state.valueAsAnnotation();
    }

    /**
     * If the provided value can be interpreted as an annotation node, then
     * this method should return the provider that reflects the value as an
     * annotation node.
     * 
     * @return Provider which reflects the value as annotation node
     */
    protected abstract N valueAsProvider();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            state.toString(sb);
        } catch (IOException e) {
            // Not possible, sb.append() does not throw IOException...
        }
        return sb.toString();
    }

    public void toString(Appendable out) throws IOException {
        state.toString(out);
    }

    /**
     * 
     * @return true if this node is ambiguous, otherwise false
     */
    public boolean isAmbiguous() {
        return this == ambiguousNode();
    }

    /**
     * This is an internal method, call {{@link #nodeExists()} instead.
     * @return true if this node is available.
     */
    protected boolean hasNode() {
        return state.hasNode();
    }

    /**
     * 
     * @return true if this node does exist.
     */
    public boolean nodeExists() {
        return state.nodeExists();
    }

    /**
     * Should return a singleton object which represent an ambiguous node.
     * It is crucial that this is the same object each time!
     * 
     * @return a node representing an ambiguous node
     */
    protected abstract T ambiguousNode();

    /**
     * Returns true if the each keyword is set
     * 
     * @return true if each is set
     */
    public boolean isEach() {
    	return state.isEach();
    }

    /**
     * Returns true if the final keyword is set
     * 
     * @return true if final is set
     */
    public boolean isFinal() {
    	return state.isFinal();
    }

    /**
     * Returns the parent node.
     * 
     * @return the parent node.
     */
    protected T parent() {
        return state.parent();
    }

    /**
     * Convenience method which downcast from the generic type {@code T} to the less
     * specific type {@code GenericAnnotationNode<T, N, V>}
     * 
     * @param node node to downcast
     * @return downcasted node
     */
    private GenericAnnotationNode<T, N, V> asGeneric(T node) {
        return node;
    }

    /**********************************
     *  Value checkers and retrieves
     *********************************/

    /**
     * Check if the value of this annotation entry represents a scalar boolean.
     * 
     * @return true if the value represent scalar boolean
     */
    public boolean isValueBoolean() {
        return getAndCheckConstValue(ValueType.BOOLEAN, ValueSize.SCALAR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a scalar boolean.
     * 
     * @return boolean value of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as scalar boolean
     */
    public boolean valueAsBoolean() throws ConstantEvaluationException{
        return getAndCheckConstValue(ValueType.BOOLEAN, ValueSize.SCALAR, true).booleanValue();
    }

    /**
     * Check if the value of this annotation entry represents a scalar integer.
     * 
     * @return true if the value represent scalar integer
     */
    public boolean isValueInteger() {
        return getAndCheckConstValue(ValueType.INTEGER, ValueSize.SCALAR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a scalar integer.
     * 
     * @return integer value of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as scalar integer
     */
    public int valueAsInteger() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.INTEGER, ValueSize.SCALAR, true).intValue();
    }

    /**
     * Check if the value of this annotation entry represents a integer vector.
     * 
     * @return true if the value represent integer vector
     */
    public boolean isValueIntegerVector() {
        return getAndCheckConstValue(ValueType.INTEGER, ValueSize.VECTOR) != null;
    }
    
    /**
     * Interpret the value of this annotation entry as a integer vector.
     * 
     * @return integer value of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as integer vector
     */
    public int[] valueAsIntegerVector() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.INTEGER, ValueSize.VECTOR, true).intVector();
    }
    
    /**
     * Check if the value of this annotation entry represents a scalar real.
     * 
     * @return true if the value represent scalar real
     */
    public boolean isValueReal() {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.SCALAR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a scalar real.
     * 
     * @return real value of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as scalar real
     */
    public double valueAsReal() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.SCALAR, true).realValue();
    }

    /**
     * Check if the value of this annotation entry represents a real vector.
     * 
     * @return true if the value represent real vector
     */
    public boolean isValueRealVector() {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.VECTOR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a real vector.
     * 
     * @return real vector of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as real vector
     */
    public double[] valueAsRealVector() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.VECTOR, true).realVector();
    }

    /**
     * Check if the value of this annotation entry represents a real matrix.
     * 
     * @return true if the value represent real matrix
     */
    public boolean isValueRealMatrix() {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.MATRIX) != null;
    }

    /**
     * Interpret the value of this annotation entry as a real matrix.
     * 
     * @return real matrix of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as real matrix
     */
    public double[][] valueAsRealMatrix() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.REAL, ValueSize.MATRIX, true).realMatrix();
    }

    /**
     * Check if the value of this annotation entry represents a scalar string.
     * 
     * @return true if the value represent scalar string
     */
    public boolean isValueString() {
        return getAndCheckConstValue(ValueType.STRING, ValueSize.SCALAR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a scalar string.
     * 
     * @return string value of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as scalar string
     */
    public String valueAsString() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.STRING, ValueSize.SCALAR, true).stringValue();
    }

    /**
     * Check if the value of this annotation entry represents a string vector.
     * 
     * @return true if the value represent string vector
     */
    public boolean isValueStringVector() {
        return getAndCheckConstValue(ValueType.STRING, ValueSize.VECTOR) != null;
    }

    /**
     * Interpret the value of this annotation entry as a string vector.
     * 
     * @return string vector of the entry value
     * @throws ConstantEvaluationException
     *      if there is no value or it can't be interpreted as string vector
     */
    public String[] valueAsStringVector() throws ConstantEvaluationException {
        return getAndCheckConstValue(ValueType.STRING, ValueSize.VECTOR, true).stringVector();
    }
    
    public boolean isUnknownAccess() {
        return getAndCheckConstValue(ValueType.UNKNOWN_ACCESS, ValueSize.SCALAR) != null;
    }
    
    public boolean isUnknownAccessVector() {
        return getAndCheckConstValue(ValueType.UNKNOWN_ACCESS, ValueSize.VECTOR) != null;
    }
    
    public String unknownAccessAsString() {
        return getAndCheckConstValue(ValueType.UNKNOWN_ACCESS, ValueSize.SCALAR).access();
    }
    
    public String[] unknownAccessVectorAsStringVector() {
        return getAndCheckConstValue(ValueType.UNKNOWN_ACCESS, ValueSize.VECTOR).accessVector();
    }

    /*****************************************
     * Value checkers and retrieves helpers
     ****************************************/
    private static enum ValueType {
        BOOLEAN {
            @Override
            public boolean check(ConstValue value) {
                return value.isBoolean();
            }
        },
        INTEGER {
            @Override
            public boolean check(ConstValue value) {
                return value.isInteger();
            }
        },
        STRING {
            @Override
            public boolean check(ConstValue value) {
                return value.isString() || value.isEnum();
            }
        },
        UNKNOWN_ACCESS {
          @Override
        public boolean check(ConstValue value) {
            return value.isUnknownAccess();
        }  
        },
        REAL {
            @Override
            public boolean check(ConstValue value) {
                return value.isReal();
            }
        };

        public abstract boolean check(ConstValue value);
    }

    private static enum ValueSize {
        SCALAR {
            @Override
            public boolean check(ConstValue value) {
                return value.isScalar();
            }
        },
        VECTOR {
            @Override
            public boolean check(ConstValue value) {
                return value.isVector();
            }
        },
        MATRIX {
            @Override
            public boolean check(ConstValue value) {
                return value.isMatrix();
            }
        };

        public abstract boolean check(ConstValue value);
    }

    /**
     * Helper which checks that the value of this annotation entry is set and
     * of specified size and type. If the size and type match, then the value
     * is returned, otherwise null is returned.
     * 
     * @param type Type which the value should have
     * @param size Size which the value should have
     * @return Value if it matches the size and type, otherwise null
     */
    private ConstValue getAndCheckConstValue(ValueType type, ValueSize size) {
        return getAndCheckConstValue(type, size, false);
    }

    /**
     * Helper which checks that the value of this annotation entry is set and
     * of specified size and type. If the size and type match, then the value
     * is returned, otherwise, depending on throwOnIncorrect and exception is 
     * thrown or null is returned.
     * 
     * @param type Type which the value should have
     * @param size Size which the value should have
     * @param throwOnIncorrect Whether the method should throw and exception
     *      or return null
     * @return Value if it matches the size and type, null if throwOnIncorrect
     *      is false
     * @throws ConstantEvaluationException if throwOnIncorrect is true and the
     *      value isn't set or doesn't match the size or type.
     */
    private ConstValue getAndCheckConstValue(ValueType type, ValueSize size, boolean throwOnIncorrect)
            throws ConstantEvaluationException {
        if (!hasValue()) {
            if (throwOnIncorrect) {
                throw new ConstantEvaluationException();
            } else {
                return null;
            }
        }
        ConstValue value = evaluatedValue();
        if (type.check(value) && size.check(value)) {
            return value;
        } else if (throwOnIncorrect) {
            throw new ConstantEvaluationException(value, "Cannot convert to " + size + " " + type);
        } else {
            return null;
        }
    }

    protected ConstValue evaluatedValue() {
        return value().evaluateValue();
    }
    
    /**
     * Removes the reference to node. 
     * The backing node is not removed and has to be removed separately. 
     */
    protected void disconnectFromNode() {
        state.disconnectFromNode();
    }

    public abstract class AnnotationStateManager {

        protected abstract void computeSubNodesCache();

        protected abstract boolean isFinal();

		protected abstract boolean isEach();

		protected abstract boolean isSubNodesCacheFresh();

        protected abstract boolean hasSubNodesCache();

        protected abstract void setNode(String newName, N node);

        protected abstract void setSubNodeNodeWasSet();

        protected abstract void updateSubNode(String newName, N newNode, T subNode);

        protected abstract N createNodeForChild(GenericAnnotationNode<T,N,V> child);

        protected abstract T forPath(String[] path, int i);

        protected abstract Iterable<T> subNodes();

        protected abstract N node();

        protected abstract String resolveURI(String str) throws URIResolver.URIException ;

        protected abstract N peekNode();

        protected abstract String name();

        protected abstract void disconnectFromNode();

        protected abstract void updateNode(String newName, N node);

        protected abstract V value();

        protected abstract void setValue(V newValue);

        protected abstract T valueAsAnnotation();

        protected abstract void toString(Appendable out) throws IOException ;

        protected abstract boolean hasNode();

        protected abstract boolean nodeExists();

        protected abstract T parent();
    }

    public class AmbiguousAnnotationStateManager extends AnnotationStateManager {

        private final String name;
        private final N node;
        private final T parent;

        protected AmbiguousAnnotationStateManager(String name, N node, T parent) {
            this.name = name;
            this.node = node;
            this.parent = parent;
        }

        @Override
        protected void computeSubNodesCache() {
        	// Do nothing
        }

        @Override
        protected boolean isSubNodesCacheFresh() {
            return true;
        }

        @Override
        protected boolean hasSubNodesCache() {
            return true;
        }

        @Override
        protected void setNode(String newName, N node) {
        	// Do nothing
        }

        @Override
        protected void setSubNodeNodeWasSet() {
        	// Do nothing
        }

        @Override
        protected void updateSubNode(String newName, N newNode, T subNode) {
        	// Do nothing
        }

        @Override
        protected N createNodeForChild(GenericAnnotationNode<T, N, V> child) {
            return null;
        }

        @Override
        protected T forPath(String[] path, int i) {
            return self();
        }

        @Override
        protected Iterable<T> subNodes() {
            return Collections.emptyList();
        }

        @Override
        protected N node() {
            return node;
        }

        @Override
        protected String resolveURI(String str) throws URIException {
            return null;
        }

        @Override
        protected N peekNode() {
            return node;
        }

        @Override
        protected String name() {
            return name;
        }

        @Override
        protected void disconnectFromNode() {
        	// Do nothing
        }

        @Override
        protected void updateNode(String newName, N node) {
        	// Do nothing
        }

        @Override
        protected V value() {
            return node().annotationValue();
        }

        @Override
        protected void setValue(V newValue) {
        	// Do nothing
        }

        @Override
        protected T valueAsAnnotation() {
            return self();
        }

        @Override
        protected void toString(Appendable out) throws IOException {
        	// We don't have anything to append
        }

        @Override
        protected boolean hasNode() {
            return true;
        }

        @Override
        protected boolean nodeExists() {
            return true;
        }

        @Override
        protected T parent() {
            return parent;
        }

		@Override
		protected boolean isFinal() {
			return false;
		}

		@Override
		protected boolean isEach() {
			return false;
		}
    }

    public class MutableAnnotationStateManager extends AnnotationStateManager {

        private String name;
        private N node;
        private final T parent;

        private Collection<T> subNodes_cache;
        private Map<String, T> subNodesNameMap_cache;
        private boolean nodeWasSet = false;
        private boolean subNodeNodeWasSet = false;
        private T valueAnnotation_cache;
        private boolean valueAnnotation_cacheComputed = false;

        protected MutableAnnotationStateManager(String name, N node, T parent) {
            this.parent = parent;
            setNode(name, node);
        }

        @Override
        protected void computeSubNodesCache() {
            if (isSubNodesCacheFresh()) {
                return;
            }
            if (subNodes_cache == null) {
                subNodes_cache = Collections.emptyList();
            }
            if (subNodesNameMap_cache == null) {
                subNodesNameMap_cache = Collections.emptyMap();
            }

            if(!nodeExists() || isAmbiguous()) {
                return;
            }

            List<T> subNodes = new ArrayList<T>();
            Map<String, List<T>> oldNodesMap = constructMapIncludingAmbiguous(subNodes_cache);
            Map<String, T> subNodesNameMap = new HashMap<String, T>();
            for (AnnotationProvider.SubAnnotationPair<N> subNodePair : node.annotationSubNodes()) {
                String subNodeName = subNodePair.getAnnotationName();
                N subNodeNode = subNodePair.getAnnotationValue();
                T subNode = null;

                List<T> oldNodes = oldNodesMap.get(subNodeName);
                if (oldNodes != null) {
                    subNode = oldNodes.remove(0);
                    if (oldNodes.isEmpty()) {
                        oldNodesMap.remove(subNodeName);
                    }
                }
                createOrSetSubNodeAndAddToCaches(subNode, subNodeName, subNodeNode, subNodes, subNodesNameMap);
            }

            for(List<T> oldNodes : oldNodesMap.values()) {
                for(T oldNode: oldNodes) {
                    //TODO move the setting of the node field in the sub node to null to an explicit step
                    createOrSetSubNodeAndAddToCaches(oldNode, oldNode.name(), null, subNodes, subNodesNameMap);
                }
            }
            subNodes_cache = subNodes;
            subNodesNameMap_cache = subNodesNameMap;
            clearNodeWasSetFlags();
        }

        private T createOrSetSubNodeAndAddToCaches(T subNode, String subNodeName, N subNodeNode, Collection<T> subNodes, Map<String, T> subNodesNameMap) {
            if (subNode == null) {
                subNode = createNode(subNodeName, subNodeNode);
            } else {
                asGeneric(subNode).setNode(subNodeName, subNodeNode);
            }
            if (subNode != null) {
                addToCaches(subNodes, subNodesNameMap, subNode);
            }
            return subNode;
        }

        private void addToCaches(Collection<T> subNodes, Map<String, T> subNodesNameMap, T subNode) {
            subNodes.add(subNode);
            updateSubNodesNameMapCache(subNodesNameMap, subNode);
        }

        private void updateSubNodesNameMapCache(Map<String, T> subNodesNameMap, T subNode) {
            T previous = subNodesNameMap.put(subNode.name(), subNode);
            if (previous != null && previous.hasNode() && subNode.hasNode()) { // subNode goes from not ambiguous to ambiguous
                subNodesNameMap.put(subNode.name(), ambiguousNode());
            }
        }

        private T removeFromSubNodesNameMapCache(T subNode, Collection<T> subNodes, Map<String, T> subNodesNameMap) {
            T previous = subNodesNameMap.get(subNode.name());
            if (previous != null) {
                if (previous == ambiguousNode()) {
                    Map<String, List<T>> oldNodesMap = constructMapIncludingAmbiguous(filterExists(subNodes));
                    List<T> oldNodes = oldNodesMap.get(subNode.name());
                    if(oldNodes.size() == 2) { // subNode goes from ambiguous to not ambiguous
                        oldNodes.remove(subNode);
                        subNodesNameMap.put(subNode.name(), oldNodes.get(0));
                    }
                } else {
                    subNodesNameMap.remove(subNode.name());
                }
            }
            return previous;
        }

        /**
         * Computes a map that maps between name and node, the list is needed since
         * there may be multiple nodes with the same name, if that is the case,
         * then they are put in the list in the order that they are found!
         */
        private Map<String, List<T>> constructMapIncludingAmbiguous(Iterable<T> nodes) {
            if (nodes == null) {
                return Collections.emptyMap();
            }
            Map<String, List<T>> res = new LinkedHashMap<String, List<T>>();
            for (T node : nodes) {
                String name = node.name();
                List<T> withSameName = res.get(name);
                if (withSameName == null) {
                    withSameName = new ArrayList<T>(Collections.singletonList(node));
                    res.put(name, withSameName);
                } else if (withSameName.size() == 1) {
                    withSameName = new ArrayList<T>(withSameName);
                    withSameName.add(node);
                    res.put(name, withSameName);
                } else {
                    withSameName.add(node);
                }
            }
            return res;
        }

        @Override
        protected void updateSubNode(String newName, N newNode, T subNode) {
            removeFromSubNodesNameMapCache(subNode, subNodes_cache, subNodesNameMap_cache);
            asGeneric(subNode).setNode(newName, newNode);
            updateSubNodesNameMapCache(subNodesNameMap_cache, subNode);
        }

        @Override
        protected boolean isSubNodesCacheFresh() {
            return !nodeWasSet && !subNodeNodeWasSet;
        }

        @Override
        protected boolean hasSubNodesCache() {
            return subNodes_cache != null;
        }

        @Override
        protected T forPath(String[] paths, int currentIndex) {
            if (isAmbiguous() || currentIndex == paths.length) {
                return self();
            }
            computeSubNodesCache();
            T subNode = subNodesNameMap_cache.get(paths[currentIndex]);
            if (subNode == null) {
                makeEmptySubNodesCacheMutable();
                subNode = createOrSetSubNodeAndAddToCaches(subNode, paths[currentIndex], null, subNodes_cache,
                        subNodesNameMap_cache);
            }
            return subNode.forPath(paths, currentIndex + 1);
        }

        private void makeEmptySubNodesCacheMutable() {
            if (subNodesNameMap_cache.isEmpty()) {
                subNodesNameMap_cache = new HashMap<String, T>();
            }
            if (subNodes_cache.isEmpty()) {
                subNodes_cache = new ArrayList<T>();
            }
        }

        @Override
        protected N createNodeForChild(GenericAnnotationNode<T, N, V> child) throws AnnotationEditException {
            if (child == valueAnnotation_cache) {
                // Trying to set the value annotation child
                throw new AnnotationEditException(GenericAnnotationNode.this, "Not possible to set assign annotation value as annotation yet");
            }
            N res = node().addAnnotationSubNode(child.name());
            if (res == null) {
                throw new AnnotationEditException(child, "Unable to create sub node");
            }
            return res;
        }

        private boolean hasSubNodes() {
            computeSubNodesCache();
            return !subNodes_cache.isEmpty();
        }

        @Override
        protected Iterable<T> subNodes() {
            computeSubNodesCache();
            return filterExists(subNodes_cache);
        }

        private Iterable<T> filterExists(Iterable<T> nodes) {
            return new FilteredIterable<T>(nodes, new Criteria<T>() {

                @Override
                public boolean test(T elem) {
                    return elem.nodeExists();
                }

            });
        }

        @Override
        protected N node() throws AnnotationEditException {
            if (!hasNode()) {
                if (parent == null) {
                    // This is a null pattern node without hope of creating
                    return null;
                }
                N node = asGeneric(parent()).createNodeForChild(GenericAnnotationNode.this);
                updateNode(name(), node);
            }
            return node;
        }

        @Override
        protected N peekNode() {
            return node;
        }

        @Override
        protected String resolveURI(String str) throws URIResolver.URIException {
            if (node == null) {
                if (parent == null) {
                    return null; // We did our best, we cant do more
                }
                return parent.resolveURI(str);
            }
            return node.resolveURI(str);
        }

        @Override
        protected String name() {
            return name;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void updateNode(String newName, N node) {
            if (parent() != null && !name().equals(newName)) {
                asGeneric(parent()).updateSubNode(newName, node, (T) GenericAnnotationNode.this);
            } else {
                setNode(newName, node);
            }
        }

        @Override
        protected void setNode(String newName, N node) {
            // This is an internal method because it does not update the caches in the parent node.
            // it needs to be protected to be accessible from the parent node.
            disconnectFromNode();
            this.name = newName;
            this.node = node;
            setNodeWasSetFlags();
        }

        @Override
        protected V value() {
            if (!nodeExists() || isAmbiguous()) {
                return null;
            }
            return node().annotationValue();
        }

        @Override
        protected void setValue(V newValue) throws AnnotationEditException {
            try {
                node().setAnnotationValue(newValue);
            } catch (FailedToSetAnnotationValueException e) {
                throw new AnnotationEditException(GenericAnnotationNode.this, e);
            }
        }

        @Override
        protected T valueAsAnnotation() {
            if (!valueAnnotation_cacheComputed) {
                valueAnnotation_cacheComputed = true;
                if (isAmbiguous()) {
                    valueAnnotation_cache = ambiguousNode();
                } else if (nodeExists()) {
                    N annotationNode = valueAsProvider();
                    if (hasValue() && annotationNode == null) {
                        valueAnnotation_cache = null;
                    } else {
                        valueAnnotation_cache = createNode(annotationNode);
                    }
                } else {
                    valueAnnotation_cache = null;
                }
            }
            return valueAnnotation_cache;
        }

        @Override
        protected void toString(Appendable out) throws IOException {
            if (name() != null) {
                out.append(name());
            }
            if (hasSubNodes()) {
                boolean first = true;
                for (T subNode : subNodes()) {
                    if (first) {
                        out.append('(');
                    }
                    if (!first) {
                        out.append(", ");
                    }
                    first = false;
                    subNode.toString(out);
                }
                if (!first) {
                    out.append(')');
                }
            }
            if (hasValue()) {
                out.append('=');
                out.append(value().toString());
            }
        }

        @Override
        protected boolean hasNode() {
            return isAmbiguous() || node != null;
        }

        @Override
        protected boolean nodeExists() {
            if (parent() != null) {
                asGeneric(parent()).computeSubNodesCache();
            }
            return hasNode();
        }

        @Override
        protected T parent() {
            return parent;
        }

        @Override
        protected void disconnectFromNode() {
            if (parent != null) {
                node = null;
                setNodeWasSetFlags();
            }
            if (subNodes_cache != null) {
                for (T t : subNodes_cache) {
                    t.disconnectFromNode();
                }
            }
        }

        private void setNodeWasSetFlags() {
            nodeWasSet = true;
            if (parent() != null) {
                asGeneric(parent()).setSubNodeNodeWasSet();
            }
        }

        @Override
        protected void setSubNodeNodeWasSet() {
            subNodeNodeWasSet = true;
        }

        private void clearNodeWasSetFlags() {
            nodeWasSet = false;
            subNodeNodeWasSet = false;
        }

		@Override
		protected boolean isFinal() {
			return node.isFinal();
		}

		@Override
		protected boolean isEach() {
			return node.isEach();
		}

    }

}
