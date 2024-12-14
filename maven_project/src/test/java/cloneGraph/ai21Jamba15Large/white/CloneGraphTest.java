package cloneGraph.ai21Jamba15Large.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import cloneGraph.CloneGraph.Node;

public class CloneGraphTest {

    @Test
    void testCloneGraphNull() {
        Node node = null;
        Node clonedNode = new CloneGraph().cloneGraph(node);
        assertEquals(null, clonedNode);
    }

    @Test
    void testCloneGraphSingleNode() {
        Node node = new Node(1);
        Node clonedNode = new CloneGraph().cloneGraph(node);
        assertNotNull(clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testCloneGraphMultipleNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedNode1 = new CloneGraph().cloneGraph(node1);

        assertNotNull(clonedNode1);
        assertEquals(node1.val, clonedNode1.val);

        assertEquals(2, clonedNode1.neighbors.size());
        assertEquals(new Node(2).val, clonedNode1.neighbors.get(0).val);
        assertEquals(new Node(4).val, clonedNode1.neighbors.get(1).val);

        Node clonedNode2 = clonedNode1.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(2, clonedNode2.neighbors.size());
        assertEquals(new Node(1).val, clonedNode2.neighbors.get(0).val);
        assertEquals(new Node(3).val, clonedNode2.neighbors.get(1).val);

        Node clonedNode3 = clonedNode1.neighbors.get(1);
        assertEquals(4, clonedNode3.val);
        assertEquals(2, clonedNode3.neighbors.size());
        assertEquals(new Node(1).val, clonedNode3.neighbors.get(0).val);
        assertEquals(new Node(3).val, clonedNode3.neighbors.get(1).val);

        Node clonedNode4 = clonedNode2.neighbors.get(1);
        assertEquals(3, clonedNode4.val);
        assertEquals(2, clonedNode4.neighbors.size());
        assertEquals(new Node(2).val, clonedNode4.neighbors.get(0).val);
        assertEquals(new Node(4).val, clonedNode4.neighbors.get(1).val);
    }
}