package cloneGraph.ai21Jamba.prompt0;
import cloneGraph.CloneGraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CloneGraphTest {

    @Test
    public void testCloneGraph() {
        CloneGraph cloneGraph = new CloneGraph();

        // Test case 1: Simple graph with one node
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(0, clonedNode1.neighbors.size());

        // Test case 2: Graph with two nodes and one edge
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        CloneGraph.Node clonedNode2 = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode2);
        assertEquals(node1.val, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        assertEquals(node2.val, clonedNode2.neighbors.get(0).val);

        // Test case 3: Graph with three nodes and three edges
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        CloneGraph.Node clonedNode3 = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode3);
        assertEquals(node1.val, clonedNode3.val);
        assertEquals(1, clonedNode3.neighbors.size());
        assertEquals(node2.val, clonedNode3.neighbors.get(0).val);
        assertEquals(1, clonedNode3.neighbors.get(0).neighbors.size());
        assertEquals(node3.val, clonedNode3.neighbors.get(0).neighbors.get(0).val);

        // Test case 4: Disconnected graph with two nodes
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        CloneGraph.Node clonedNode4 = cloneGraph.cloneGraph(node4);
        assertNotNull(clonedNode4);
        assertEquals(node4.val, clonedNode4.val);
        assertEquals(0, clonedNode4.neighbors.size());

        // Test case 5: More complex graph
        CloneGraph.Node node5 = new CloneGraph.Node(5);
        node3.neighbors.add(node5);
        node5.neighbors.add(node3);
        CloneGraph.Node clonedNode5 = cloneGraph.cloneGraph(node1);
        assertNotNull(clonedNode5);
        assertEquals(node1.val, clonedNode5.val);
        assertEquals(1, clonedNode5.neighbors.size());
        assertEquals(node2.val, clonedNode5.neighbors.get(0).val);
        assertEquals(2, clonedNode5.neighbors.get(0).neighbors.size());
        assertEquals(node3.val, clonedNode5.neighbors.get(0).neighbors.get(0).val);
        assertEquals(node5.val, clonedNode5.neighbors.get(0).neighbors.get(1).val);
        assertEquals(1, clonedNode5.neighbors.get(0).neighbors.get(1).neighbors.size());
        assertEquals(node3.val, clonedNode5.neighbors.get(0).neighbors.get(1).neighbors.get(0).val);
    }
}