package cloneGraph.ai21Jamba15Large.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cloneGraph.Node;

public class CloneGraphTest {

    @Test
    void testCloneGraphWithFourNodes() {
        // Create the input graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors = new ArrayList<Node>(List.of(node2, node4));
        node2.neighbors = new ArrayList<Node>(List.of(node1, node3));
        node3.neighbors = new ArrayList<Node>(List.of(node2, node4));
        node4.neighbors = new ArrayList<Node>(List.of(node1, node3));

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Assert the cloned graph is correct
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        
        Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(2, clonedNode2.neighbors.size());
        
        Node clonedNode3 = clonedNode2.neighbors.get(1);
        assertEquals(3, clonedNode3.val);
        assertEquals(2, clonedNode3.neighbors.size());
        
        Node clonedNode4 = clonedNode.neighbors.get(1);
        assertEquals(4, clonedNode4.val);
        assertEquals(2, clonedNode4.neighbors.size());
    }

    @Test
    void testCloneGraphWithSingleNode() {
        // Create the input graph with a single node
        Node node1 = new Node(1);
        
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Assert the cloned graph is correct
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testCloneGraphWithEmptyGraph() {
        // Create an empty graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(null);
        
        // Assert the cloned graph is correct
        assertNotNull(clonedNode);
        assertTrue(clonedNode.neighbors.isEmpty());
    }
}