package cloneGraph.mistralSmall.black;
import cloneGraph.*;
import cloneGraph.CloneGraph.*;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    @Test
    public void testExample1() {
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

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);
    }

    @Test
    public void testExample2() {
        Node node1 = new Node(1);

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void testExample3() {
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(null);

        assertNull(clonedNode);
    }

    @Test
    public void testGraphWithSingleNode() {
        Node node1 = new Node(1);

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void testGraphWithMultipleNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(0).val);
    }
}