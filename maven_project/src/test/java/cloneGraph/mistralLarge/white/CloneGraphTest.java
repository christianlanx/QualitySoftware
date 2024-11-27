package cloneGraph.mistralLarge.white;
import cloneGraph.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    @Test
    public void testCloneGraphWithNullNode() {
        CloneGraph cloneGraph = new CloneGraph();
        assertNull(cloneGraph.cloneGraph(null));
    }

    @Test
    public void testCloneGraphWithSingleNode() {
        CloneGraph.Node originalNode = new CloneGraph.Node(1);
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(originalNode);

        assertNotNull(clonedNode);
        assertEquals(originalNode.val, clonedNode.val);
        assertEquals(originalNode.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraphWithMultipleNodes() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node3);

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node1.neighbors.size(), clonedNode1.neighbors.size());

        CloneGraph.Node clonedNode2 = clonedNode1.neighbors.get(0);
        CloneGraph.Node clonedNode3 = clonedNode1.neighbors.get(1);

        assertEquals(node2.val, clonedNode2.val);
        assertEquals(node3.val, clonedNode3.val);

        assertEquals(node2.neighbors.size(), clonedNode2.neighbors.size());
        assertEquals(node3.neighbors.size(), clonedNode3.neighbors.size());

        assertEquals(node2.neighbors.get(0).val, clonedNode2.neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphWithCyclicGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node1.neighbors.size(), clonedNode1.neighbors.size());

        CloneGraph.Node clonedNode2 = clonedNode1.neighbors.get(0);

        assertEquals(node2.val, clonedNode2.val);
        assertEquals(node2.neighbors.size(), clonedNode2.neighbors.size());

        assertEquals(node1.val, clonedNode2.neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphWithComplexGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(node1.neighbors.size(), clonedNode1.neighbors.size());

        CloneGraph.Node clonedNode2 = clonedNode1.neighbors.get(0);
        CloneGraph.Node clonedNode3 = clonedNode1.neighbors.get(1);

        assertEquals(node2.val, clonedNode2.val);
        assertEquals(node3.val, clonedNode3.val);

        assertEquals(node2.neighbors.size(), clonedNode2.neighbors.size());
        assertEquals(node3.neighbors.size(), clonedNode3.neighbors.size());

        CloneGraph.Node clonedNode4 = clonedNode2.neighbors.get(0);

        assertEquals(node4.val, clonedNode4.val);
        assertEquals(node4.neighbors.size(), clonedNode4.neighbors.size());
    }
}