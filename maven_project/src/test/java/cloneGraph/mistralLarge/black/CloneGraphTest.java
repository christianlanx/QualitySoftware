package cloneGraph.mistralLarge.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CloneGraphTest {

    @Test
    void testCloneGraphExample1() {
        // Create the graph as per the example
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = new ArrayList<>(List.of(node2, node4));
        node2.neighbors = new ArrayList<>(List.of(node1, node3));
        node3.neighbors = new ArrayList<>(List.of(node2, node4));
        node4.neighbors = new ArrayList<>(List.of(node1, node3));

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Verify the cloned graph
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);

        // Check the neighbors of the cloned nodes
        assertEquals(1, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(1).val);
        assertEquals(1, clonedNode.neighbors.get(1).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(1).neighbors.get(1).val);
    }

    @Test
    void testCloneGraphExample2() {
        // Create the graph with a single node
        Node node1 = new Node(1);
        node1.neighbors = new ArrayList<>();

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Verify the cloned graph
        assertEquals(1, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    void testCloneGraphExample3() {
        // Create an empty graph
        Node node = null;

        // Clone the graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node);

        // Verify the cloned graph
        assertNull(clonedNode);
    }
}