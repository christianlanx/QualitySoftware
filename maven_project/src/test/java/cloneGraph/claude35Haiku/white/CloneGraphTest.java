package cloneGraph.claude35Haiku.white;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import cloneGraph.CloneGraph.Node;

class CloneGraphTest {

    private CloneGraph cloneGraph = new CloneGraph();

    @Test
    void testCloneNullGraph() {
        Node nullGraph = null;
        Node clonedGraph = cloneGraph.cloneGraph(nullGraph);
        assertNull(clonedGraph);
    }

    @Test
    void testCloneSingleNodeGraph() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotSame(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testCloneConnectedGraph() {
        // Create a simple connected graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Verify clone structure
        assertNotSame(node1, clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.size());

        // Check that neighbors are also cloned
        for (Node neighbor : clonedNode1.neighbors) {
            assertNotSame(node1.neighbors.get(0), neighbor);
            assertTrue(neighbor.val == 2 || neighbor.val == 3);
        }
    }

    @Test
    void testCloneComplexGraph() {
        // Create a more complex graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);
        node4.neighbors.add(node2);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Verify deep clone with graph structure preserved
        assertNotSame(node1, clonedNode1);
        assertEquals(node1.val, clonedNode1.val);

        // Verify neighbor connections
        Set<Integer> neighborValues = new HashSet<>();
        for (Node neighbor : clonedNode1.neighbors) {
            neighborValues.add(neighbor.val);
            assertNotSame(node1.neighbors.get(0), neighbor);
        }
        assertTrue(neighborValues.contains(2));
        assertTrue(neighborValues.contains(3));
    }

    @Test
    void testCloneGraphPreserveStructure() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node3.neighbors.add(node1);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Verify interconnected graph structure is preserved
        assertEquals(2, clonedNode1.neighbors.size());
        Set<Integer> neighborValues = new HashSet<>();
        for (Node neighbor : clonedNode1.neighbors) {
            neighborValues.add(neighbor.val);
        }
        assertTrue(neighborValues.contains(2));
        assertTrue(neighborValues.contains(3));
    }
}