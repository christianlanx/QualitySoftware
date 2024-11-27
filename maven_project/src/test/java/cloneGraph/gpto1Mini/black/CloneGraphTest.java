package cloneGraph.gpto1Mini.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CloneGraphTest {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Assuming CloneGraph class is defined as provided
    public class CloneGraph {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Map<Node, Node> map = new HashMap<>();
            return clone(node, map);
        }

        private Node clone(Node node, Map<Node, Node> map) {
            if (map.containsKey(node)) {
                return map.get(node);
            }
            Node cloneNode = new Node(node.val);
            map.put(node, cloneNode);
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(clone(neighbor, map));
            }
            return cloneNode;
        }
    }

    // Helper method to build a graph from adjacency list
    private Node buildGraph(List<List<Integer>> adjList) {
        if (adjList == null || adjList.isEmpty()) return null;

        Map<Integer, Node> map = new HashMap<>();
        // Create all nodes
        for (int i = 1; i <= adjList.size(); i++) {
            map.put(i, new Node(i));
        }
        // Assign neighbors
        for (int i = 1; i <= adjList.size(); i++) {
            Node current = map.get(i);
            for (Integer neighborVal : adjList.get(i - 1)) {
                current.neighbors.add(map.get(neighborVal));
            }
        }
        return map.get(1);
    }

    // Helper method to serialize a graph to adjacency list
    private List<List<Integer>> serializeGraph(Node node) {
        List<List<Integer>> adjList = new ArrayList<>();
        if (node == null) return adjList;

        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node.val, node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighbors.add(neighbor.val);
                if (!visited.containsKey(neighbor.val)) {
                    visited.put(neighbor.val, neighbor);
                    queue.offer(neighbor);
                }
            }
            adjList.add(neighbors);
        }

        return adjList;
    }

    // Helper method to compare two adjacency lists irrespective of the order of neighbors
    private boolean compareAdjLists(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size()) return false;

        List<Set<Integer>> setList1 = new ArrayList<>();
        List<Set<Integer>> setList2 = new ArrayList<>();

        for (List<Integer> neighbors : list1) {
            Set<Integer> set = new HashSet<>(neighbors);
            setList1.add(set);
        }

        for (List<Integer> neighbors : list2) {
            Set<Integer> set = new HashSet<>(neighbors);
            setList2.add(set);
        }

        // Sort both lists based on the first element for comparison
        setList1.sort(Comparator.comparingInt(a -> a.isEmpty() ? 0 : Collections.min(a)));
        setList2.sort(Comparator.comparingInt(a -> a.isEmpty() ? 0 : Collections.min(a)));

        for (int i = 0; i < setList1.size(); i++) {
            if (!setList1.get(i).equals(setList2.get(i))) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testCloneGraph_Example1() {
        // Example 1:
        // Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
        // Output: [[2,4],[1,3],[2,4],[1,3]]
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(2,4),
                Arrays.asList(1,3),
                Arrays.asList(2,4),
                Arrays.asList(1,3)
        );

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");

        // Verify that the cloned nodes are different instances
        assertNotSame(original, cloned, "The cloned node should be a different instance.");
        assertAllNodesDifferent(original, cloned, new HashSet<>());
    }

    @Test
    public void testCloneGraph_Example2() {
        // Example 2:
        // Input: adjList = [[]]
        // Output: [[]]
        List<List<Integer>> adjList = Arrays.asList(
                Collections.emptyList()
        );

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");

        // Verify that the cloned node is a different instance
        assertNotSame(original, cloned, "The cloned node should be a different instance.");
    }

    @Test
    public void testCloneGraph_Example3() {
        // Example 3:
        // Input: adjList = []
        // Output: []
        List<List<Integer>> adjList = new ArrayList<>();

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");
        assertNull(cloned, "The cloned graph should be null for an empty input.");
    }

    @Test
    public void testCloneGraph_SingleNode() {
        // Single node with no neighbors
        List<List<Integer>> adjList = Arrays.asList(
                Collections.emptyList()
        );

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");
        assertNotSame(original, cloned, "The cloned node should be a different instance.");
    }

    @Test
    public void testCloneGraph_TwoNodes() {
        // Two nodes connected to each other
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(1)
        );

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");
        assertNotSame(original, cloned, "The cloned node should be a different instance.");

        // Verify that cloned neighbors are different instances
        assertNotSame(original.neighbors.get(0), cloned.neighbors.get(0), "Neighbor nodes should be different instances.");
    }

    @Test
    public void testCloneGraph_CyclicGraph() {
        // Cycle: 1 - 2 - 3 - 1
        List<List<Integer>> adjList = Arrays.asList(
                Arrays.asList(2,3),
                Arrays.asList(1,3),
                Arrays.asList(1,2)
        );

        Node original = buildGraph(adjList);
        CloneGraph solution = new CloneGraph();
        Node cloned = solution.cloneGraph(original);

        List<List<Integer>> clonedAdjList = serializeGraph(cloned);

        assertTrue(compareAdjLists(adjList, clonedAdjList), "The cloned adjacency list should match the original.");
        assertNotSame(original, cloned, "The cloned node should be a different instance.");
        assertNotSame(original.neighbors.get(0), cloned.neighbors.get(0), "Neighbor nodes should be different instances.");
    }

    // Helper method to verify all nodes in the original and cloned graphs are different instances
    private void assertAllNodesDifferent(Node original, Node cloned, Set<Integer> visited) {
        if (original == null || cloned == null) return;
        if (visited.contains(original.val)) return;
        visited.add(original.val);
        assertNotSame(original, cloned, "Nodes with val " + original.val + " should be different instances.");
        assertEquals(original.val, cloned.val, "Nodes should have the same val.");
        assertEquals(original.neighbors.size(), cloned.neighbors.size(), "Nodes should have the same number of neighbors.");
        for (int i = 0; i < original.neighbors.size(); i++) {
            assertAllNodesDifferent(original.neighbors.get(i), cloned.neighbors.get(i), visited);
        }
    }
}