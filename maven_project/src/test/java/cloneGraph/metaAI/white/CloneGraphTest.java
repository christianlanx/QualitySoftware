package cloneGraph.metaAI.white;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CloneGraphTest {

    private CloneGraph cloneGraph = new CloneGraph();

    @Test
    public void testCloneGraph_Example1() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

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

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotEquals(node1, clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraph_Example2() {
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotEquals(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(node.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraph_EmptyGraph() {
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(null);
        assertNull(clonedNode);
    }

    @Test
    public void testCloneGraph_SingleNodeWithNeighbors() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);

        node1.neighbors = new ArrayList<>();
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotEquals(node1, clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }
}