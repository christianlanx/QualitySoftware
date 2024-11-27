package cloneGraph.claude35Sonnet.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CloneGraphTest {
    private CloneGraph cloneGraph = new CloneGraph();

    @Test
    void testNullGraph() {
        Node result = cloneGraph.cloneGraph(null);
        assertNull(result);
    }

    @Test
    void testSingleNodeGraph() {
        Node node = new Node(1);
        Node result = cloneGraph.cloneGraph(node);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        assertTrue(result.neighbors.isEmpty());
        assertNotSame(node, result);
    }

    @Test
    void testFourNodeGraph() {
        // Create the original graph: [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        Node result = cloneGraph.cloneGraph(node1);

        // Verify the structure
        assertNotNull(result);
        assertEquals(1, result.val);
        
        // Verify that it's a deep copy
        assertNotSame(node1, result);
        
        // Check neighbors of node 1
        assertEquals(2, result.neighbors.size());
        assertEquals(2, result.neighbors.get(0).val);
        assertEquals(4, result.neighbors.get(1).val);

        // Get copied nodes
        Node copiedNode2 = result.neighbors.get(0);
        Node copiedNode4 = result.neighbors.get(1);
        
        // Check neighbors of node 2
        assertEquals(2, copiedNode2.neighbors.size());
        assertSame(result, copiedNode2.neighbors.get(0)); // Should point to copied node 1
        assertEquals(3, copiedNode2.neighbors.get(1).val);

        Node copiedNode3 = copiedNode2.neighbors.get(1);

        // Check neighbors of node 3
        assertEquals(2, copiedNode3.neighbors.size());
        assertSame(copiedNode2, copiedNode3.neighbors.get(0));
        assertSame(copiedNode4, copiedNode3.neighbors.get(1));

        // Check neighbors of node 4
        assertEquals(2, copiedNode4.neighbors.size());
        assertSame(result, copiedNode4.neighbors.get(0));
        assertSame(copiedNode3, copiedNode4.neighbors.get(1));
    }

    @Test
    void testCyclicGraph() {
        // Create a simple cyclic graph with two nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors = Collections.singletonList(node2);
        node2.neighbors = Collections.singletonList(node1);

        Node result = cloneGraph.cloneGraph(node1);

        assertNotNull(result);
        assertEquals(1, result.val);
        assertEquals(1, result.neighbors.size());
        
        Node copiedNode2 = result.neighbors.get(0);
        assertEquals(2, copiedNode2.val);
        assertEquals(1, copiedNode2.neighbors.size());
        
        // Verify the cycle is maintained in the copy
        assertSame(result, copiedNode2.neighbors.get(0));
    }

    @Test
    void testGraphWithMaxValues() {
        // Test with maximum constraint values
        Node node = new Node(100);
        Node result = cloneGraph.cloneGraph(node);
        
        assertNotNull(result);
        assertEquals(100, result.val);
        assertTrue(result.neighbors.isEmpty());
        assertNotSame(node, result);
    }
}