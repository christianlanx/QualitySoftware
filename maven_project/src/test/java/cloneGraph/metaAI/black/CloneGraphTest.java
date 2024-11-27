package cloneGraph.metaAI.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CloneGraphTest {

    private CloneGraph cloneGraph = new CloneGraph();

    @Test
    public void testCloneGraph_Example1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors = new ArrayList<>();
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors = new ArrayList<>();
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors = new ArrayList<>();
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotEquals(node1, clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraph_Example2() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotEquals(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(node.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraph_EmptyGraph() {
        Node clonedNode = cloneGraph.cloneGraph(null);
        assertNull(clonedNode);
    }
}