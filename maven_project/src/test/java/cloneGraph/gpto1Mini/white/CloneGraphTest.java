package cloneGraph.gpto1Mini.white;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CloneGraphTest {

    private final CloneGraph cloneGraph = new CloneGraph();

    @Test
    void cloneGraph_nullInput() {
        assertNull(cloneGraph.cloneGraph(null), "Cloning a null graph should return null.");
    }

    @Test
    void cloneGraph_singleNode() {
        Node node = new Node(1);
        Node cloned = cloneGraph.cloneGraph(node);

        assertNotNull(cloned, "Cloned node should not be null.");
        assertEquals(node.val, cloned.val, "Cloned node value should match the original.");
        assertNotSame(node, cloned, "Cloned node should be a different instance.");
        assertTrue(cloned.neighbors.isEmpty(), "Cloned node should have no neighbors.");
    }

    @Test
    void cloneGraph_twoNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node cloned = cloneGraph.cloneGraph(node1);

        assertNotNull(cloned, "Cloned graph should not be null.");
        assertEquals(node1.val, cloned.val, "Cloned node1 value should match the original.");
        assertNotSame(node1, cloned, "Cloned node1 should be a different instance.");
        assertEquals(1, cloned.neighbors.size(), "Cloned node1 should have one neighbor.");

        Node clonedNeighbor = cloned.neighbors.get(0);
        assertEquals(node2.val, clonedNeighbor.val, "Cloned node2 value should match the original.");
        assertNotSame(node2, clonedNeighbor, "Cloned node2 should be a different instance.");
        assertEquals(1, clonedNeighbor.neighbors.size(), "Cloned node2 should have one neighbor.");
        assertSame(cloned, clonedNeighbor.neighbors.get(0), "Cloned node2 should reference cloned node1.");
    }

    @Test
    void cloneGraph_cycle() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node cloned = cloneGraph.cloneGraph(node1);

        assertNotNull(cloned, "Cloned graph should not be null.");
        assertEquals(1, cloned.val, "Cloned node1 value should match the original.");

        assertEquals(1, cloned.neighbors.size(), "Cloned node1 should have one neighbor.");
        Node clonedNode2 = cloned.neighbors.get(0);
        assertEquals(2, clonedNode2.val, "Cloned node2 value should match the original.");
        assertEquals(1, clonedNode2.neighbors.size(), "Cloned node2 should have one neighbor.");
        assertSame(cloned, clonedNode2.neighbors.get(0), "Cloned node2 should reference cloned node1.");
    }

    @Test
    void cloneGraph_complexGraph() {
        /*
            Create a graph:
                1 -- 2
                |    |
                4 -- 3
        */
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

        Node cloned = cloneGraph.cloneGraph(node1);
        assertNotNull(cloned, "Cloned graph should not be null.");
        assertEquals(1, cloned.val, "Cloned node1 value should match the original.");

        // Use a map to store cloned nodes by their value
        Map<Integer, Node> clonedNodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(cloned);
        visited.add(cloned);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            clonedNodes.put(current.val, current);
            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Verify all nodes are cloned
        assertEquals(4, clonedNodes.size(), "All four nodes should be cloned.");

        for (int i = 1; i <= 4; i++) {
            assertTrue(clonedNodes.containsKey(i), "Cloned graph should contain node " + i);
        }

        // Verify connections
        assertEquals(2, clonedNodes.get(1).neighbors.size(), "Node 1 should have two neighbors.");
        assertTrue(clonedNodes.get(1).neighbors.contains(clonedNodes.get(2)), "Node 1 should be connected to Node 2.");
        assertTrue(clonedNodes.get(1).neighbors.contains(clonedNodes.get(4)), "Node 1 should be connected to Node 4.");

        assertEquals(2, clonedNodes.get(2).neighbors.size(), "Node 2 should have two neighbors.");
        assertTrue(clonedNodes.get(2).neighbors.contains(clonedNodes.get(1)), "Node 2 should be connected to Node 1.");
        assertTrue(clonedNodes.get(2).neighbors.contains(clonedNodes.get(3)), "Node 2 should be connected to Node 3.");

        assertEquals(2, clonedNodes.get(3).neighbors.size(), "Node 3 should have two neighbors.");
        assertTrue(clonedNodes.get(3).neighbors.contains(clonedNodes.get(2)), "Node 3 should be connected to Node 2.");
        assertTrue(clonedNodes.get(3).neighbors.contains(clonedNodes.get(4)), "Node 3 should be connected to Node 4.");

        assertEquals(2, clonedNodes.get(4).neighbors.size(), "Node 4 should have two neighbors.");
        assertTrue(clonedNodes.get(4).neighbors.contains(clonedNodes.get(1)), "Node 4 should be connected to Node 1.");
        assertTrue(clonedNodes.get(4).neighbors.contains(clonedNodes.get(3)), "Node 4 should be connected to Node 3.");
    }
}