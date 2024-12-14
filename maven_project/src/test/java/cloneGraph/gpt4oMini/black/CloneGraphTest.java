package cloneGraph.gpt4oMini.black;

import cloneGraph.CloneGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CloneGraphTest {

    @Test
    public void testCloneGraph_Example1() {
        CloneGraph graph = new CloneGraph();

        // Create the original graph: [[2,4],[1,3],[2,4],[1,3]]
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph.Node clonedNode1 = graph.cloneGraph(node1);
        
        // Validate cloned graph structure
        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode1.neighbors.get(0).val);
        assertEquals(4, clonedNode1.neighbors.get(1).val);
        assertEquals(2, clonedNode1.neighbors.get(0).neighbors.get(1).val);
        assertEquals(3, clonedNode1.neighbors.get(0).neighbors.get(0).val);
    }

    @Test
    public void testCloneGraph_Example2() {
        CloneGraph graph = new CloneGraph();

        // Create the original graph: [[]]
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        
        CloneGraph.Node clonedNode1 = graph.cloneGraph(node1);
        
        // Validate cloned graph structure
        assertEquals(1, clonedNode1.val);
        assertEquals(0, clonedNode1.neighbors.size());
    }

    @Test
    public void testCloneGraph_Empty() {
        CloneGraph graph = new CloneGraph();
        
        // Test cloning an empty graph
        CloneGraph.Node clonedNode = graph.cloneGraph(null);
        
        // Validate that the result is null
        assertNull(clonedNode);
    }
}