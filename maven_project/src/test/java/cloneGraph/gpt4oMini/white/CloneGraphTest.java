package cloneGraph.gpt4oMini.white;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    void testCloneGraph_NullNode() {
        CloneGraph graphCloner = new CloneGraph();
        Node result = graphCloner.cloneGraph(null);
        assertNull(result, "Cloning a null node should return null.");
    }

    @Test
    void testCloneGraph_SingleNode() {
        CloneGraph graphCloner = new CloneGraph();
        Node node = new Node(1);
        Node result = graphCloner.cloneGraph(node);
        
        assertNotNull(result, "Cloned node should not be null.");
        assertEquals(node.val, result.val, "Cloned node value should match the original.");
        assertTrue(result.neighbors.isEmpty(), "Cloned node should not have any neighbors.");
    }

    @Test
    void testCloneGraph_TwoConnectedNodes() {
        CloneGraph graphCloner = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        
        Node result = graphCloner.cloneGraph(node1);
        
        assertNotNull(result, "Cloned node should not be null.");
        assertEquals(node1.val, result.val, "Cloned first node's value should match the original.");
        assertEquals(1, result.neighbors.size(), "Cloned first node should have one neighbor.");
        assertEquals(node2.val, result.neighbors.get(0).val, "Neighbor's value should match the original neighbor.");
        assertEquals(1, result.neighbors.get(0).neighbors.size(), "Cloned neighbor should have one neighbor.");
        assertEquals(node1.val, result.neighbors.get(0).neighbors.get(0).val, "Neighbor's neighbor's value should match the original neighbor.");
    }

    @Test
    void testCloneGraph_DisconnectedGraph() {
        CloneGraph graphCloner = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node3.neighbors.add(node1); // Create disconnection

        Node result = graphCloner.cloneGraph(node1);
        
        assertNotNull(result, "Cloned node should not be null.");
        assertEquals(1, result.val, "Cloned first node's value should match the original.");
        assertEquals(1, result.neighbors.size(), "Cloned first node should have one neighbor.");
        
        Node clonedNeighbor = result.neighbors.get(0);
        assertEquals(2, clonedNeighbor.val, "Cloned neighbor's value should match the original neighbor.");
        assertTrue(clonedNeighbor.neighbors.isEmpty(), "Cloned neighbor should not have any neighbors.");
    }

    @Test
    void testCloneGraph_LargeGraph() {
        CloneGraph graphCloner = new CloneGraph(); 
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);
        
        Node result = graphCloner.cloneGraph(node1);

        assertNotNull(result, "Cloned node should not be null.");
        assertEquals(1, result.val, "Cloned first node's value should match the original.");
        assertEquals(2, result.neighbors.size(), "Cloned first node should have two neighbors.");
        
        Node clonedNeighbor1 = result.neighbors.get(0);
        assertEquals(2, clonedNeighbor1.val, "First cloned neighbor's value should match the original.");
        
        Node clonedNeighbor2 = result.neighbors.get(1);
        assertEquals(3, clonedNeighbor2.val, "Second cloned neighbor's value should match the original.");
        
        assertTrue(clonedNeighbor1.neighbors.contains(result.neighbors.get(1)), "Cloned neighbor1 should contain cloned neighbor2.");
        assertTrue(clonedNeighbor2.neighbors.contains(result.neighbors.get(1)), "Cloned neighbor2 should contain cloned neighbor1.");
    }
}