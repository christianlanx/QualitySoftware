package cloneGraph.gpt4o.white;

import cloneGraph.CloneGraph.Node;
import cloneGraph.CloneGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    @Test
    public void testCloneNullGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        assertNull(cloneGraph.cloneGraph(null), "Cloning a null graph should return null.");
    }

    @Test
    public void testCloneSingleNodeGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);
        
        assertNotNull(clonedNode, "Cloned node should not be null.");
        assertEquals(node.val, clonedNode.val, "Cloned node value should match original.");
        assertTrue(clonedNode.neighbors.isEmpty(), "Cloned node should have no neighbors.");
    }

    @Test
    public void testCloneSimpleGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode1, "Cloned node1 should not be null.");
        assertEquals(1, clonedNode1.val, "Cloned node1 value should match original.");
        assertEquals(1, clonedNode1.neighbors.size(), "Cloned node1 should have one neighbor.");
        assertEquals(2, clonedNode1.neighbors.get(0).val, "Cloned node1's neighbor value should be 2.");

        Node clonedNode2 = clonedNode1.neighbors.get(0);
        assertNotNull(clonedNode2, "Cloned node2 should not be null.");
        assertEquals(1, clonedNode2.neighbors.size(), "Cloned node2 should have one neighbor.");
        assertEquals(1, clonedNode2.neighbors.get(0).val, "Cloned node2's neighbor value should be 1.");
    }

    @Test
    public void testCloneComplexGraph() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node1);
        node3.neighbors.add(node4);
        node4.neighbors.add(node2);
        node4.neighbors.add(node3);

        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode, "Cloned node should not be null.");
        assertEquals(1, clonedNode.val, "Cloned node value should match original.");
        assertEquals(2, clonedNode.neighbors.size(), "Cloned node should have two neighbors.");

        List<Integer> clonedNodeNeighborVals = new ArrayList<>();
        for (Node neighbor : clonedNode.neighbors) {
            clonedNodeNeighborVals.add(neighbor.val);
        }
        assertTrue(clonedNodeNeighborVals.contains(2), "Cloned node should have a neighbor with value 2.");
        assertTrue(clonedNodeNeighborVals.contains(3), "Cloned node should have a neighbor with value 3.");
    }

    @Test
    public void testGraphWithCycle() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode1, "Cloned node1 should not be null.");
        assertEquals(1, clonedNode1.val, "Cloned node1 value should match original.");

        Node clonedNode2 = clonedNode1.neighbors.get(0);
        assertNotNull(clonedNode2, "Cloned node2 should not be null.");
        assertEquals(2, clonedNode2.val, "Cloned node2 value should match original.");

        Node clonedNode3 = clonedNode2.neighbors.get(0);
        assertNotNull(clonedNode3, "Cloned node3 should not be null.");
        assertEquals(3, clonedNode3.val, "Cloned node3 value should match original.");

        assertEquals(clonedNode1, clonedNode3.neighbors.get(0), "Cloned node3's neighbor should point back to cloned node1, maintaining the cycle.");
    }
}