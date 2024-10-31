package cloneGraph.chatGPT4o.prompt0;
import org.junit.Before;
import org.junit.Test;

import cloneGraph.CloneGraph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class cloneGraphchatGPT4oTest {
    private CloneGraph cloneGraph;

    @Before
    public void setUp() {
        cloneGraph = new CloneGraph();
    }

    @Test
    public void testCloneGraphWithSingleNode() {
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);
        
        assertNotNull(clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertNotSame(node, clonedNode);
        assertTrue(clonedNode.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraphWithTwoConnectedNodes() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertNotSame(node1, clonedNode);
        assertNotSame(node2, clonedNode.neighbors.get(0));
    }

    @Test
    public void testCloneGraphWithCycle() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);

        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node1);

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);

        CloneGraph.Node clonedNode2 = clonedNode.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        assertEquals(3, clonedNode2.neighbors.get(0).val);

        CloneGraph.Node clonedNode3 = clonedNode2.neighbors.get(0);
        assertEquals(3, clonedNode3.val);
        assertEquals(1, clonedNode3.neighbors.size());
        assertEquals(1, clonedNode3.neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphWithNull() {
        assertNull(cloneGraph.cloneGraph(null));
    }
    //error in this test
    /* 
    @Test
    public void testCloneGraphWithComplexGraph() {
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());

        CloneGraph.Node clonedNode2 = clonedNode.neighbors.get(0);
        CloneGraph.Node clonedNode4 = clonedNode.neighbors.get(1);

        assertEquals(2, clonedNode2.val);
        assertEquals(4, clonedNode4.val);

        assertEquals(2, clonedNode2.neighbors.size());
        assertEquals(2, clonedNode4.neighbors.size());

        // Check that nodes are different instances
        assertNotSame(node1, clonedNode);
        assertNotSame(node2, clonedNode2);
        assertNotSame(node4, clonedNode4);

        // Verify circular relationships are preserved in the clone
        assertTrue(clonedNode2.neighbors.contains(clonedNode));
        assertTrue(clonedNode4.neighbors.contains(clonedNode3));
    }
        */
}
