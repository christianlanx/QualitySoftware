package cloneGraph.claude35Haiku.white;

import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class CloneGraphTest {
    private cloneGraph.CloneGraph cloneGraph;

    @BeforeEach
    void setUp() {
        cloneGraph = new cloneGraph.CloneGraph();
    }

    @Test
    void testNullGraph() {
        Node nullGraph = null;
        Node clonedGraph = cloneGraph.cloneGraph(nullGraph);
        assertNull(clonedGraph);
    }

    @Test
    void testSingleNodeGraph() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotSame(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testComplexGraph() {
        // Create a graph with multiple nodes and connections
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Verify graph structure is preserved
        assertNotSame(node1, clonedNode1);
        assertEquals(node1.val, clonedNode1.val);

        // Check node connections and structure
        Set<Node> processedNodes = new HashSet<>();
        validateGraphClone(node1, clonedNode1, processedNodes);
    }

    private void validateGraphClone(Node original, Node cloned, Set<Node> processedNodes) {
        if (processedNodes.contains(original)) {
            return;
        }

        processedNodes.add(original);
        assertNotSame(original, cloned);
        assertEquals(original.val, cloned.val);
        assertEquals(original.neighbors.size(), cloned.neighbors.size());

        for (int i = 0; i < original.neighbors.size(); i++) {
            Node originalNeighbor = original.neighbors.get(i);
            Node clonedNeighbor = cloned.neighbors.get(i);

            assertNotSame(originalNeighbor, clonedNeighbor);
            assertEquals(originalNeighbor.val, clonedNeighbor.val);

            validateGraphClone(originalNeighbor, clonedNeighbor, processedNodes);
        }
    }
}