package cloneGraph.gpto1Mini.grey;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CloneGraphTest {

    /**
     * Helper method to build a graph from an adjacency list.
     *
     * @param adjList The adjacency list representing the graph.
     * @return The reference node of the constructed graph.
     */
    private Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) {
            return null;
        }

        // Create all nodes
        Node[] nodes = new Node[adjList.length + 1]; // 1-indexed
        for (int i = 1; i <= adjList.length; i++) {
            nodes[i] = new Node(i);
        }

        // Assign neighbors
        for (int i = 1; i <= adjList.length; i++) {
            for (int neighborVal : adjList[i - 1]) {
                nodes[i].neighbors.add(nodes[neighborVal]);
            }
        }

        return nodes[1];
    }

    /**
     * Helper method to convert a graph to its adjacency list representation.
     *
     * @param node The reference node of the graph.
     * @return The adjacency list representing the graph.
     */
    private List<List<Integer>> getAdjList(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> adjList = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighbors.add(neighbor.val);
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            map.put(current.val, neighbors);
        }

        // Ensure the adjacency list is ordered by node values
        int size = map.keySet().stream().max(Integer::compareTo).orElse(0);
        for (int i = 1; i <= size; i++) {
            adjList.add(map.getOrDefault(i, new ArrayList<>()));
        }

        return adjList;
    }

    /**
     * Helper method to compare two adjacency lists for equality.
     *
     * @param expected The expected adjacency list.
     * @param actual   The actual adjacency list.
     */
    private void assertAdjacencyListEquals(List<List<Integer>> expected, List<List<Integer>> actual) {
        Assertions.assertEquals(expected.size(), actual.size(), "Adjacency list sizes do not match.");
        for (int i = 0; i < expected.size(); i++) {
            List<Integer> expectedNeighbors = new ArrayList<>(expected.get(i));
            List<Integer> actualNeighbors = new ArrayList<>(actual.get(i));
            Collections.sort(expectedNeighbors);
            Collections.sort(actualNeighbors);
            Assertions.assertEquals(expectedNeighbors, actualNeighbors, "Mismatch found in neighbors of node " + (i + 1));
        }
    }

    @Test
    public void testCloneGraph_Example1() {
        int[][] adjList = {
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3}
        };
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 4),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }

    @Test
    public void testCloneGraph_Example2() {
        int[][] adjList = {
                {}
        };
        List<List<Integer>> expected = Collections.singletonList(new ArrayList<>());

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }

    @Test
    public void testCloneGraph_Example3() {
        int[][] adjList = {};
        List<List<Integer>> expected = new ArrayList<>();

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }

    @Test
    public void testCloneGraph_SingleNode_NoNeighbors() {
        int[][] adjList = {
                {}
        };
        List<List<Integer>> expected = Collections.singletonList(new ArrayList<>());

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }

    @Test
    public void testCloneGraph_TwoNodes_Bidirectional() {
        int[][] adjList = {
                {2},
                {1}
        };
        List<List<Integer>> expected = Arrays.asList(
                Collections.singletonList(2),
                Collections.singletonList(1)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }

    @Test
    public void testCloneGraph_LargerGraph() {
        int[][] adjList = {
                {2, 4, 5},
                {1, 3},
                {2, 4},
                {1, 3, 5},
                {1, 4}
        };
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(2, 4, 5),
                Arrays.asList(1, 3),
                Arrays.asList(2, 4),
                Arrays.asList(1, 3, 5),
                Arrays.asList(1, 4)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjList);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> actual = getAdjList(cloned);

        assertAdjacencyListEquals(expected, actual);
    }
}