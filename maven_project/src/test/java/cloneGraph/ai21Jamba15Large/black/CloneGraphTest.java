package cloneGraph.ai21Jamba15Large.black;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
        node1.neighbors.addAll(List.of(node2, node4));
        node2.neighbors.addAll(List.of(node1, node3));
        node3.neighbors.addAll(List.of(node2, node4));
        node4.neighbors.addAll(List.of(node1, node3));

        // Perform the clone operation
        Node clonedNode = new CloneGraph().cloneGraph(node1);

        // Verify the cloned graph
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);

        Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(2, clonedNode2.neighbors.size());
        assertEquals(1, clonedNode2.neighbors.get(0).val);
        assertEquals(3, clonedNode2.neighbors.get(1).val);

        Node clonedNode3 = clonedNode.neighbors.get(1);
        assertEquals(4, clonedNode3.val);
        assertEquals(2, clonedNode3.neighbors.size());
        assertEquals(1, clonedNode3.neighbors.get(0).val);
        assertEquals(3, clonedNode3.neighbors.get(1).val);

        Node clonedNode4 = clonedNode2.neighbors.get(1);
        assertEquals(3, clonedNode4.val);
        assertEquals(2, clonedNode4.neighbors.size());
        assertEquals(2, clonedNode4.neighbors.get(0).val);
        assertEquals(4, clonedNode4.neighbors.get(1).val);
    }

    @Test
    void testCloneGraphWithSingleNode() {
        // Create the input graph
        Node node1 = new Node(1);

        // Perform the clone operation
        Node clonedNode = new CloneGraph().cloneGraph(node1);

        // Verify the cloned graph
        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    void testCloneGraphWithEmptyGraph() {
        // Perform the clone operation on an empty graph
        Node clonedNode = new CloneGraph().cloneGraph(null);

        // Verify the cloned graph
        assertNotNull(clonedNode);
        assertEquals(0, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }
}