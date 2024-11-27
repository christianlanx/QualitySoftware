package cloneGraph.claude35Sonnet.white;
import cloneGraph.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import java.util.*;

class CloneGraphTest {
    private CloneGraph cloneGraph;

    @BeforeEach
    void setUp() {
        cloneGraph = new CloneGraph();
    }

    @Test
    void testNullInput() {
        assertNull(cloneGraph.cloneGraph(null));
    }

    @Test
    void testSingleNodeGraph() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);
        
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
        assertNotSame(node, clonedNode);
    }

    @Test
    void testTwoConnectedNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(1, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertNotSame(node1, clonedNode);
        assertNotSame(node2, clonedNode.neighbors.get(0));
    }

    @Test
    void testCyclicGraph() {
        // Create a graph: 1 -- 2
        //                |    |
        //                4 -- 3
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Verify structure
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        
        // Verify that the cloned nodes are different instances
        assertNotSame(node1, clonedNode);
        assertNotSame(node2, clonedNode.neighbors.get(0));
        assertNotSame(node4, clonedNode.neighbors.get(1));

        // Verify connections
        Node clonedNode2 = clonedNode.neighbors.get(0);
        Node clonedNode4 = clonedNode.neighbors.get(1);
        
        assertTrue(clonedNode2.neighbors.contains(clonedNode));
        assertTrue(clonedNode4.neighbors.contains(clonedNode));
    }

    @Test
    void testIsolatedNode() {
        Node node = new Node(1);
        node.neighbors = new ArrayList<>();
        
        Node clonedNode = cloneGraph.cloneGraph(node);
        
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
        assertNotSame(node, clonedNode);
    }
}