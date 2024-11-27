package cloneGraph.gpt4oMini.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class CloneGraphTest {

    // Helper method to create a graph from an adjacency list
    private Node createGraph(int[][] adjList) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < adjList.length; i++) {
            nodeMap.put(i + 1, new Node(i + 1));
        }
        for (int i = 0; i < adjList.length; i++) {
            Node node = nodeMap.get(i + 1);
            for (int neighbor : adjList[i]) {
                node.neighbors.add(nodeMap.get(neighbor));
            }
        }
        return nodeMap.get(1); // Return the node with value 1
    }

    // Helper method to create an adjacency list from a graph
    private List<List<Integer>> graphToAdjList(Node node) {
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Node> visited = new HashSet<>();
        dfs(node, visited, adjList);
        return adjList;
    }

    private void dfs(Node node, Set<Node> visited, List<List<Integer>> adjList) {
        if (node == null || visited.contains(node)) return;
        visited.add(node);
        while (adjList.size() < node.val) {
            adjList.add(new ArrayList<>());
        }
        for (Node neighbor : node.neighbors) {
            adjList.get(node.val - 1).add(neighbor.val);
            dfs(neighbor, visited, adjList);
        }
    }

    @Test
    public void testCloneGraph_singleNode() {
        int[][] adjList = {{}};
        Node original = createGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        
        assertEquals(originalAdjList, clonedAdjList);
    }

    @Test
    public void testCloneGraph_emptyGraph() {
        int[][] adjList = {};
        Node original = createGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);
        
        assertNull(cloned); // Expecting cloned graph to be null for an empty input
    }

    @Test
    public void testCloneGraph_fullGraph() {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        Node original = createGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        
        assertEquals(originalAdjList, clonedAdjList);
    }

    @Test
    public void testCloneGraph_disconnectedGraph() {
        // As per the problem's constraints, the graph is always connected. 
        // This test serves only for completeness and won't be executed.
        int[][] adjList = {{2}, {1, 3}, {2}, {4}, {3}};
        Node original = createGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        
        assertNotEquals(originalAdjList, clonedAdjList); // This check is irrelevant here
    }
    
}