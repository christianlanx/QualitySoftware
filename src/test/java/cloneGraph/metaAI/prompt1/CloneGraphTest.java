package cloneGraph.metaAI.prompt1;
import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    CloneGraph cloneGraph = new CloneGraph();

    @Test
    public void testCloneGraph_Example1() {
        // Create graph
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

        // Verify cloned graph
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);
        assertEquals(1, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(1).val);
        assertEquals(1, clonedNode.neighbors.get(1).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(1).neighbors.get(1).val);
    }

    @Test
    public void testCloneGraph_Example2() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);

        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraph_EmptyGraph() {
        Node clonedNode = cloneGraph.cloneGraph(null);
        assertNull(clonedNode);
    }

    @Test
    public void testCloneGraph_SingleNode() {
        Node node = new Node(1);
        Node clonedNode = cloneGraph.cloneGraph(node);

        assertEquals(1, clonedNode.val);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraph_LargeGraph() {
        // Create graph with 100 nodes
        Node[] nodes = new Node[100];
        for (int i = 0; i < 100; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < 99; i++) {
            nodes[i].neighbors.add(nodes[i + 1]);
        }

        Node clonedNode = cloneGraph.cloneGraph(nodes[0]);

        // Verify cloned graph
        assertEquals(1, clonedNode.val);
        for (int i = 0; i < 99; i++) {
            assertEquals(i + 2, clonedNode.neighbors.get(i).val);
        }
    }
}