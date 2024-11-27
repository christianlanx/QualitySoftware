package cloneGraph.ai21Jamba15Large.white;
import cloneGraph.*;
import cloneGraph.CloneGraph.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CloneGraphTest {

    @Test
    void testCloneGraph_NullNode() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = null;
        Node clonedNode = cloneGraph.cloneGraph(node);
        assertEquals(null, clonedNode);
    }

    @Test
    void testCloneGraph_SingleNode() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);
        assertNotNull(clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    void testCloneGraph_TwoNodes() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        Node clonedNode = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(node2.val, clonedNode.neighbors.get(0).val);
    }

    @Test
    void testCloneGraph_GraphWithCycle() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);
        Node clonedNode = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(node2.val, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        Node clonedNode3 = clonedNode2.neighbors.get(0);
        assertEquals(node3.val, clonedNode3.val);
        assertEquals(1, clonedNode3.neighbors.size());
        Node clonedNode1 = clonedNode3.neighbors.get(0);
        assertEquals(node1.val, clonedNode1.val);
    }

    @Test
    void testCloneGraph_ComplexGraph() {
        CloneGraph cloneGraph = new CloneGraph();
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
        Node clonedNode = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(node2.val, clonedNode2.val);
        assertEquals(2, clonedNode2.neighbors.size());
        Node clonedNode3 = clonedNode2.neighbors.get(1);
        assertEquals(node3.val, clonedNode3.val);
        assertEquals(2, clonedNode3.neighbors.size());
        Node clonedNode4 = clonedNode.neighbors.get(1);
        assertEquals(node4.val, clonedNode4.val);
        assertEquals(2, clonedNode4.neighbors.size());
    }
}