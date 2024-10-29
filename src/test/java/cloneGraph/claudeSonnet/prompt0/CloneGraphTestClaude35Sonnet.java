package cloneGraph.claudeSonnet.prompt0;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

import java.util.*;

public class CloneGraphTestClaude35Sonnet {
    private CloneGraph cloneGraph;
    private CloneGraph.Node node1, node2, node3, node4;

    @Before
    public void setUp() {
        cloneGraph = new CloneGraph();
        
        // Reset nodes before each test
        node1 = new CloneGraph.Node(1);
        node2 = new CloneGraph.Node(2);
        node3 = new CloneGraph.Node(3);
        node4 = new CloneGraph.Node(4);
    }

    @Test
    public void testNullInput() {
        assertNull("Null input should return null", cloneGraph.cloneGraph(null));
    }

    @Test
    public void testSingleNodeGraph() {
        CloneGraph.Node result = cloneGraph.cloneGraph(new CloneGraph.Node(1));
        
        assertNotNull("Result should not be null", result);
        assertEquals("Value should be 1", 1, result.val);
        assertTrue("Neighbors list should be empty", result.neighbors.isEmpty());
        assertNotSame("Should be a different object", node1, result);
    }

    @Test
    public void testTwoConnectedNodes() {
        // Create a simple graph: 1 <-> 2
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph.Node result = cloneGraph.cloneGraph(node1);

        assertNotNull("Result should not be null", result);
        assertEquals("Should have one neighbor", 1, result.neighbors.size());
        assertEquals("First node value should be 1", 1, result.val);
        assertEquals("Neighbor node value should be 2", 2, result.neighbors.get(0).val);
        
        // Verify bidirectional connection
        assertEquals("Neighbor's neighbor should point back to first node", 
            result, result.neighbors.get(0).neighbors.get(0));
    }

    @Test
    public void testCyclicGraph() {
        // Create a cyclic graph: 1 -> 2 -> 3 -> 4 -> 1
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        CloneGraph.Node result = cloneGraph.cloneGraph(node1);

        assertNotNull("Result should not be null", result);
        assertEquals("Node value should be 1", 1, result.val);
        assertEquals("Should have one neighbor", 1, result.neighbors.size());
        
        // Follow the cycle
        CloneGraph.Node current = result;
        for (int expectedVal = 1; expectedVal <= 4; expectedVal++) {
            assertEquals("Node value should match", expectedVal, current.val);
            current = current.neighbors.get(0);
        }
        
        // Verify we're back at the start
        assertEquals("Should complete the cycle", result, current);
    }

    @Test
    public void testFullyConnectedGraph() {
        // Create a fully connected graph where each node connects to all others
        node1.neighbors.addAll(Arrays.asList(node2, node3, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3, node4));
        node3.neighbors.addAll(Arrays.asList(node1, node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node2, node3));

        CloneGraph.Node result = cloneGraph.cloneGraph(node1);

        assertNotNull("Result should not be null", result);
        assertEquals("Should have three neighbors", 3, result.neighbors.size());
        
        // Verify all nodes have connections to all other nodes
        Set<CloneGraph.Node> visited = new HashSet<>();
        Queue<CloneGraph.Node> queue = new LinkedList<>();
        queue.add(result);
        visited.add(result);

        while (!queue.isEmpty()) {
            CloneGraph.Node current = queue.poll();
            assertEquals("Each node should have 3 neighbors", 3, current.neighbors.size());
            
            for (CloneGraph.Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        assertEquals("Should have visited 4 nodes", 4, visited.size());
    }

    @Test
    public void testDisconnectedNode() {
        CloneGraph.Node isolated = new CloneGraph.Node(1);
        
        CloneGraph.Node result = cloneGraph.cloneGraph(isolated);
        
        assertNotNull("Result should not be null", result);
        assertEquals("Value should be 1", 1, result.val);
        assertTrue("Should have no neighbors", result.neighbors.isEmpty());
        assertNotSame("Should be a different object", isolated, result);
    }

    @Test
    public void testCustomNodeConstructors() {
        // Test Node constructor with just value
        CloneGraph.Node node = new CloneGraph.Node(5);
        assertEquals("Value should be 5", 5, node.val);
        assertNotNull("Neighbors list should be initialized", node.neighbors);
        assertTrue("Neighbors list should be empty", node.neighbors.isEmpty());

        // Test Node constructor with value and neighbors
        ArrayList<CloneGraph.Node> neighbors = new ArrayList<>();
        neighbors.add(new CloneGraph.Node(6));
        CloneGraph.Node nodeWithNeighbors = new CloneGraph.Node(5, neighbors);
        assertEquals("Value should be 5", 5, nodeWithNeighbors.val);
        assertEquals("Should have one neighbor", 1, nodeWithNeighbors.neighbors.size());
        assertEquals("Neighbor value should be 6", 6, nodeWithNeighbors.neighbors.get(0).val);
    }
}