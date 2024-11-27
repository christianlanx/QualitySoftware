package cloneGraph.ai21Jamba15Mini.white;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CloneGraphTest {

    @Test
    void testCloneGraph_SingleNode() {
        Node node = new Node(1);
        Node clonedNode = new CloneGraph().cloneGraph(node);
        assertEquals(node.val, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    void testCloneGraph_TwoNodesNoEdges() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node clonedNode1 = new CloneGraph().cloneGraph(node1);
        Node clonedNode2 = new CloneGraph().cloneGraph(node2);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node2.val, clonedNode2.val);
        assertTrue(clonedNode1.neighbors.isEmpty());
        assertTrue(clonedNode2.neighbors.isEmpty());
    }

    @Test
    void testCloneGraph_TwoNodesOneEdge() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        Node clonedNode1 = new CloneGraph().cloneGraph(node1);
        Node clonedNode2 = new CloneGraph().cloneGraph(node2);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node2.val, clonedNode2.val);
        assertEquals(1, clonedNode1.neighbors.size());
        assertEquals(clonedNode2, clonedNode1.neighbors.get(0));
        assertEquals(1, clonedNode2.neighbors.size());
        assertEquals(clonedNode1, clonedNode2.neighbors.get(0));
    }

    @Test
    void testCloneGraph_MultipleNodesMultipleEdges() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        Node clonedNode1 = new CloneGraph().cloneGraph(node1);
        Node clonedNode2 = new CloneGraph().cloneGraph(node2);
        Node clonedNode3 = new CloneGraph().cloneGraph(node3);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node2.val, clonedNode2.val);
        assertEquals(node3.val, clonedNode3.val);
        assertEquals(2, clonedNode1.neighbors.size());
        assertTrue(clonedNode1.neighbors.contains(clonedNode2));
        assertTrue(clonedNode1.neighbors.contains(clonedNode3));
        assertEquals(0, clonedNode2.neighbors.size());
        assertEquals(0, clonedNode3.neighbors.size());
    }
}