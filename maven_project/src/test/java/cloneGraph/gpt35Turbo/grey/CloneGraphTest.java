package cloneGraph.gpt35Turbo.grey;

import org.junit.jupiter.api.Test;

import cloneGraph.CloneGraph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {
    
    @Test
    void testCloneGraphSingleNode() {
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);
        assertEquals(1, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }
    
    @Test
    void testCloneGraphWithNeighbors() {
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
        
        List<CloneGraph.Node> adjList = new ArrayList<>();
        adjList.add(node2);
        adjList.add(node4);
        
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node1);
        
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        
        // Check first neighbor
        CloneGraph.Node clonedNeighbor1 = clonedNode.neighbors.get(0);
        assertEquals(2, clonedNeighbor1.val);
        assertEquals(2, clonedNeighbor1.neighbors.size());
        
        // Check second neighbor
        CloneGraph.Node clonedNeighbor2 = clonedNode.neighbors.get(1);
        assertEquals(4, clonedNeighbor2.val);
        assertEquals(2, clonedNeighbor2.neighbors.size());
    }
}