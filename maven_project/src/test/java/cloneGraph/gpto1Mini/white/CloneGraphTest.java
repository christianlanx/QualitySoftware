package cloneGraph.gpto1Mini.white;
import cloneGraph.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

class CloneGraphTest {

    /**
     * Helper method to compare two graphs for equality.
     * It checks if both graphs have the same structure and node values,
     * and ensures that the cloned nodes are different instances.
     */
    private boolean areGraphsEqual(CloneGraph.Node node1, CloneGraph.Node node2) {
        if (node1 == null && node2 == null) return true;
        if ((node1 == null) != (node2 == null)) return false;

        Map<CloneGraph.Node, CloneGraph.Node> visited = new HashMap<>();
        Queue<CloneGraph.Node> queue1 = new LinkedList<>();
        Queue<CloneGraph.Node> queue2 = new LinkedList<>();

        queue1.add(node1);
        queue2.add(node2);
        visited.put(node1, node2);

        while (!queue1.isEmpty()) {
            CloneGraph.Node current1 = queue1.poll();
            CloneGraph.Node current2 = queue2.poll();

            if (current1.val != current2.val) return false;
            if (current1 == current2) return false; // Should be different instances
            if (current1.neighbors.size() != current2.neighbors.size()) return false;

            for (int i = 0; i < current1.neighbors.size(); i++) {
                CloneGraph.Node neighbor1 = current1.neighbors.get(i);
                CloneGraph.Node neighbor2 = current2.neighbors.get(i);

                if (visited.containsKey(neighbor1)) {
                    if (visited.get(neighbor1) != neighbor2) return false;
                } else {
                    visited.put(neighbor1, neighbor2);
                    queue1.add(neighbor1);
                    queue2.add(neighbor2);
                }
            }
        }

        return true;
    }

    @Test
    void testCloneGraph_NullInput() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node cloned = cloneGraph.cloneGraph(null);
        assertNull(cloned, "Cloning a null graph should return null.");
    }

    @Test
    void testCloneGraph_SingleNode_NoNeighbors() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node cloned = cloneGraph.cloneGraph(node);

        assertNotNull(cloned, "Cloned node should not be null.");
        assertEquals(node.val, cloned.val, "Node values should be equal.");
        assertNotSame(node, cloned, "Cloned node should be a different instance.");
        assertTrue(cloned.neighbors.isEmpty(), "Cloned node should have no neighbors.");
    }

    @Test
    void testCloneGraph_SingleNode_WithSelfNeighbor() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node = new CloneGraph.Node(1);
        node.neighbors.add(node); // Self-loop

        CloneGraph.Node cloned = cloneGraph.cloneGraph(node);

        assertNotNull(cloned, "Cloned node should not be null.");
        assertEquals(node.val, cloned.val, "Node values should be equal.");
        assertNotSame(node, cloned, "Cloned node should be a different instance.");
        assertEquals(1, cloned.neighbors.size(), "Cloned node should have one neighbor.");
        assertSame(cloned, cloned.neighbors.get(0), "Neighbor should point to the cloned node itself.");
    }

    @Test
    void testCloneGraph_TwoNodes_Bidirectional() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph.Node cloned = cloneGraph.cloneGraph(node1);

        assertNotNull(cloned, "Cloned node should not be null.");
        assertEquals(node1.val, cloned.val, "Node values should be equal.");
        assertNotSame(node1, cloned, "Cloned node should be a different instance.");
        assertEquals(1, cloned.neighbors.size(), "Cloned node should have one neighbor.");

        CloneGraph.Node clonedNeighbor = cloned.neighbors.get(0);
        assertEquals(node2.val, clonedNeighbor.val, "Neighbor node values should be equal.");
        assertNotSame(node2, clonedNeighbor, "Cloned neighbor should be a different instance.");
        assertEquals(1, clonedNeighbor.neighbors.size(), "Cloned neighbor should have one neighbor.");
        assertSame(cloned, clonedNeighbor.neighbors.get(0), "Neighbor's neighbor should point back to cloned node.");
    }

    @Test
    void testCloneGraph_CyclicGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        // Creating a cycle: 1 - 2 - 3 - 1
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        CloneGraph.Node cloned = cloneGraph.cloneGraph(node1);

        CloneGraph.Node original = node1;
        CloneGraph.Node originalCloned = cloned;

        assertTrue(areGraphsEqual(original, originalCloned), "Cloned graph should be structurally identical to the original.");
    }

    @Test
    void testCloneGraph_ComplexGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        // Creating the following graph:
        // 1 - 2
        // |   |
        // 4 - 3
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph.Node cloned = cloneGraph.cloneGraph(node1);

        CloneGraph.Node original = node1;
        CloneGraph.Node originalCloned = cloned;

        assertTrue(areGraphsEqual(original, originalCloned), "Cloned graph should be structurally identical to the original.");
    }

    @Test
    void testCloneGraph_LargerGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        // Creating a graph:
        // 1 connected to 2, 4
        // 2 connected to 1, 3
        // 3 connected to 2, 4
        // 4 connected to 1, 3
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        CloneGraph.Node cloned = cloneGraph.cloneGraph(node1);

        CloneGraph.Node original = node1;
        CloneGraph.Node originalCloned = cloned;

        assertTrue(areGraphsEqual(original, originalCloned), "Cloned graph should be structurally identical to the original.");
    }
}