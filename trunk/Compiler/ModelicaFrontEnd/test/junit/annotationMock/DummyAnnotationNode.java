package annotationMock;

import org.jmodelica.util.annotations.GenericAnnotationNode;
import org.jmodelica.util.values.Evaluable;

public class DummyAnnotationNode extends GenericAnnotationNode<DummyAnnotationNode, DummyAnnotProvider, Evaluable> {

    private static DummyAnnotationNode ambiguousNode = new DummyAnnotationNode("Ambiguous", null, null);
    public DummyAnnotationNode(String name, DummyAnnotProvider node, DummyAnnotationNode parent) {
        super(name, node, parent);
    }

    /**
     * Expose protected method for testing
     */
    public void disconnectFromNode() {
        super.disconnectFromNode();
    }

    @Override
    protected DummyAnnotationNode self() {
        return this;
    }

    /**
     * Expose protected method for testing
     */
    public void updateNode(String newName, DummyAnnotProvider node) {
        super.updateNode(newName, node);
    }

    /**
     * Expose protected method for testing
     */
    public void updateSubNode(String newName, DummyAnnotProvider newNode, DummyAnnotationNode subNode) {
        super.updateSubNode(newName, newNode, subNode);
    }

    /**
     * Expose protected method for testing
     */
    public void updateMySubNodes(DummyAnnotProvider newNode) {
        super.updateMySubNodes(newNode);
    }

    /**
     * Expose protected method for testing
     */
    public void setNode(String name, DummyAnnotProvider newNode) {
        super.setNode(name, newNode);
    }

    @Override
    protected DummyAnnotationNode createNode(String name, DummyAnnotProvider node) {
        return new DummyAnnotationNode(name, node, this);
    }

    @Override
    protected DummyAnnotProvider valueAsProvider() {
        return node();
    }

    @Override
    protected DummyAnnotationNode ambiguousNode() {
        return ambiguousNode;
    }

    /**
     * Clear all the nodes from the DummyAnnotationProvider to emulate removal from source tree.
     */
    public void testSrcRemoveAll() {
        for (DummyAnnotationNode subNode: subNodes()) {
            subNode.testSrcRemoveAll();
        } 
        node().subNodes.clear();
    }
}
