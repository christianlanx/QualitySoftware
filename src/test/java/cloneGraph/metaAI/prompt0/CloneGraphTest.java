package cloneGraph.metaAI.prompt0;
import cloneGraph.CloneGraph;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    CloneGraph cloneGraph = new CloneGraph();

    // Test null graph
    @Test
    public void testNullGraph() {
        CloneGraph.Node node = null;
        assertEquals(null, cloneGraph.cloneGraph(node));
    }

    // Test single node graph
    @Test
    public void testSingleNodeGraph() {
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    // Test graph with neighbors
    @Test
    public void testGraphWithNeighbors() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);
        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.get(0).val);
        assertEquals(3, clonedNode1.neighbors.get(1).val);
    }

    // Test cyclic graph
    @Test
    public void testCyclicGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);
        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.get(0).val);
        assertEquals(3, clonedNode1.neighbors.get(1).val);
    }

    // Test large graph
    @Test
    public void testLargeGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        CloneGraph.Node node5 = new CloneGraph.Node(5);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node5);
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);
        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.get(0).val);
        assertEquals(3, clonedNode1.neighbors.get(1).val);
        assertEquals(4, clonedNode1.neighbors.get(0).neighbors.get(0).val);
        assertEquals(5, clonedNode1.neighbors.get(1).neighbors.get(0).val);
    }
}