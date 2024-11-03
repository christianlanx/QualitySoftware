package cloneGraph.claudeSonnet.prompt1;

import static org.junit.Assert.*;
import org.junit.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

import java.util.*;

public class cloneGraphclaudeSonnetTest {
    private CloneGraph solution = new CloneGraph();

    // Helper method to create a graph from adjacency list
    private Node createGraph(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return null;
        
        Map<Integer, Node> nodes = new HashMap<>();
        
        // Create all nodes first
        for (int i = 0; i < adjList.length; i++) {
            nodes.put(i + 1, new Node(i + 1));
        }
        
        // Add neighbors
        for (int i = 0; i < adjList.length; i++) {
            Node currentNode = nodes.get(i + 1);
            for (int neighbor : adjList[i]) {
                currentNode.neighbors.add(nodes.get(neighbor));
            }
        }
        
        return nodes.get(1);
    }

    // Helper method to convert graph to adjacency list
    private List<List<Integer>> graphToAdjList(Node node) {
        if (node == null) return new ArrayList<>();
        
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        // Assign indices to nodes
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!nodeToIndex.containsKey(current)) {
                nodeToIndex.put(current, current.val);
                queue.addAll(current.neighbors);
            }
        }
        
        // Create adjacency list
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nodeToIndex.size(); i++) {
            result.add(new ArrayList<>());
        }
        
        // Fill adjacency list
        for (Node current : nodeToIndex.keySet()) {
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighbors.add(neighbor.val);
            }
            result.set(current.val - 1, neighbors);
        }
        
        return result;
    }

    // Helper method to verify deep copy
    private void verifyDeepCopy(Node original, Node cloned, Set<Node> visitedOriginal, Set<Node> visitedCloned) {
        if (original == null || cloned == null) {
            assertNull(original);
            assertNull(cloned);
            return;
        }

        if (visitedOriginal.contains(original)) {
            assertTrue(visitedCloned.contains(cloned));
            return;
        }

        visitedOriginal.add(original);
        visitedCloned.add(cloned);

        assertEquals(original.val, cloned.val);
        assertNotSame(original, cloned);
        assertEquals(original.neighbors.size(), cloned.neighbors.size());

        for (int i = 0; i < original.neighbors.size(); i++) {
            verifyDeepCopy(original.neighbors.get(i), cloned.neighbors.get(i), 
                          visitedOriginal, visitedCloned);
        }
    }

    @Test
    public void testExample1() {
        int[][] adjList = {{2,4}, {1,3}, {2,4}, {1,3}};
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        // Verify structure
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        assertEquals(originalAdjList, clonedAdjList);
        
        // Verify deep copy
        verifyDeepCopy(original, cloned, new HashSet<>(), new HashSet<>());
    }

    @Test
    public void testExample2() {
        int[][] adjList = {{}};
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        assertNotNull(cloned);
        assertEquals(1, cloned.val);
        assertTrue(cloned.neighbors.isEmpty());
        assertNotSame(original, cloned);
    }

    @Test
    public void testExample3() {
        int[][] adjList = {};
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        assertNull(cloned);
    }

    @Test
    public void testSingleNodeCycle() {
        Node original = new Node(1);
        original.neighbors.add(original);
        Node cloned = solution.cloneGraph(original);
        
        assertNotNull(cloned);
        assertEquals(1, cloned.val);
        assertEquals(1, cloned.neighbors.size());
        assertSame(cloned, cloned.neighbors.get(0));
        assertNotSame(original, cloned);
    }

    @Test
    public void testCompleteGraph() {
        // Create a complete graph with 4 nodes
        int[][] adjList = {{2,3,4}, {1,3,4}, {1,2,4}, {1,2,3}};
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        assertEquals(originalAdjList, clonedAdjList);
        verifyDeepCopy(original, cloned, new HashSet<>(), new HashSet<>());
    }

    @Test
    public void testLinearGraph() {
        // Create a linear graph: 1 -> 2 -> 3 -> 4
        int[][] adjList = {{2}, {1,3}, {2,4}, {3}};
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        assertEquals(originalAdjList, clonedAdjList);
        verifyDeepCopy(original, cloned, new HashSet<>(), new HashSet<>());
    }

    @Test
    public void testMaxNodes() {
        // Create a graph with 100 nodes (maximum allowed)
        int[][] adjList = new int[100][];
        for (int i = 0; i < 100; i++) {
            adjList[i] = new int[]{Math.min(100, (i + 2))};
        }
        Node original = createGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        
        List<List<Integer>> originalAdjList = graphToAdjList(original);
        List<List<Integer>> clonedAdjList = graphToAdjList(cloned);
        assertEquals(originalAdjList, clonedAdjList);
        verifyDeepCopy(original, cloned, new HashSet<>(), new HashSet<>());
    }
}
