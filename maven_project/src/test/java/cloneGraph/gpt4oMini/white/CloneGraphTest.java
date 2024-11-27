package cloneGraph.gpt4oMini.white;
import cloneGraph.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    void testCloneGraph_NullInput() {
        CloneGraph graph = new CloneGraph();
        assertNull(graph.cloneGraph(null));
    }

    @Test
    void testCloneGraph_SingleNode() {
        CloneGraph graph = new CloneGraph();
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode = graph.cloneGraph(node);
        
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testCloneGraph_TwoConnectedNodes() {
        CloneGraph graph = new CloneGraph();
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1); // Ensure bi-directional connection

        CloneGraph.Node clonedGraph = graph.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(1, clonedGraph.neighbors.size());
        assertEquals(2, clonedGraph.neighbors.get(0).val);
        assertEquals(1, clonedGraph.neighbors.get(0).neighbors.size());
    }

    @Test
    void testCloneGraph_ThreeNodeTriangle() {
        CloneGraph graph = new CloneGraph();
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        node3.neighbors.add(node2);

        CloneGraph.Node clonedGraph = graph.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(2, clonedGraph.neighbors.size());
        
        CloneGraph.Node clonedNeighbor1 = clonedGraph.neighbors.get(0);
        CloneGraph.Node clonedNeighbor2 = clonedGraph.neighbors.get(1);
        
        assertEquals(2, clonedNeighbor1.val);
        assertEquals(3, clonedNeighbor2.val);
        assertEquals(2, clonedNeighbor1.neighbors.size());
        assertEquals(2, clonedNeighbor2.neighbors.size());
    }

    @Test
    void testCloneGraph_DisconnectedGraph() {
        CloneGraph graph = new CloneGraph();
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        
        // Node 3 is disconnected
        // CloneGraph.Node node3 = new CloneGraph.Node(3); (Already created above)

        CloneGraph.Node clonedGraph = graph.cloneGraph(node1);

        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(1, clonedGraph.neighbors.size());
        
        CloneGraph.Node clonedNeighbor1 = clonedGraph.neighbors.get(0);
        assertEquals(2, clonedNeighbor1.val);
        assertEquals(1, clonedNeighbor1.neighbors.size());

        // Check if the disconnected node is also present
        CloneGraph.Node clonedDisconnectedNode = graph.cloneGraph(node3);
        assertNotNull(clonedDisconnectedNode);
        assertEquals(3, clonedDisconnectedNode.val);
        assertTrue(clonedDisconnectedNode.neighbors.isEmpty());
    }
}