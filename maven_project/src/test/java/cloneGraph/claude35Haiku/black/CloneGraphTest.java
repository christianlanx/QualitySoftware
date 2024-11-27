package cloneGraph.claude35Haiku.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CloneGraphTest {
    private CloneGraph solution = new CloneGraph();

    @Test
    void testNullGraph() {
        assertNull(solution.cloneGraph(null), "Cloning null graph should return null");
    }

    @Test
    void testSingleNodeGraph() {
        Node node = new Node(1);
        Node clonedNode = solution.cloneGraph(node);

        assertNotNull(clonedNode, "Cloned node should not be null");
        assertEquals(node.val, clonedNode.val, "Cloned node value should match original");
        assertTrue(clonedNode.neighbors.isEmpty(), "Single node graph should have no neighbors");
        assertNotSame(node, clonedNode, "Cloned node should be a different object");
    }

    @Test
    void testComplexGraph() {
        // Create original graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Connect nodes
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Clone the graph
        Node clonedNode1 = solution.cloneGraph(node1);

        // Verify cloned graph structure
        assertNotNull(clonedNode1, "Cloned graph should not be null");
        assertEquals(1, clonedNode1.val, "First node value should be 1");
        assertEquals(2, clonedNode1.neighbors.size(), "First node should have 2 neighbors");

        // Verify unique objects
        assertNotSame(node1, clonedNode1, "Cloned nodes should be different objects");
        clonedNode1.neighbors.forEach(neighbor -> 
            assertNotSame(node1.neighbors.get(0), neighbor, "Neighboring nodes should be unique")
        );
    }

    @Test
    void testNoNeighborsGraph() {
        Node node = new Node(1);
        node.neighbors = new ArrayList<>();

        Node clonedNode = solution.cloneGraph(node);

        assertNotNull(clonedNode, "Cloned node should not be null");
        assertEquals(node.val, clonedNode.val, "Cloned node value should match original");
        assertTrue(clonedNode.neighbors.isEmpty(), "Node with no neighbors should have empty neighbor list");
        assertNotSame(node, clonedNode, "Cloned node should be a different object");
    }

    @Test
    void testGraphConnectivity() {
        // Create a more complex graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);

        Node clonedNode1 = solution.cloneGraph(node1);

        // Verify graph connectivity in cloned graph
        assertNotNull(clonedNode1, "Cloned graph should not be null");
        assertEquals(2, clonedNode1.neighbors.size(), "Cloned first node should have 2 neighbors");

        // Check neighbor values and connections
        assertTrue(
            clonedNode1.neighbors.stream().anyMatch(n -> n.val == 2) &&
            clonedNode1.neighbors.stream().anyMatch(n -> n.val == 3),
            "Cloned graph should maintain original connections"
        );
    }
}