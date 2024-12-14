package cloneGraph.gpto1Mini.black;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class CloneGraphTest {

    /**
     * Helper method to build a graph from an adjacency list.
     * @param adjList The adjacency list representing the graph.
     * @return The reference node of the constructed graph.
     */
    private Node buildGraph(int[][] adjList) {
        if (adjList.length == 0) {
            return null;
        }

        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= adjList.length; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 0; i < adjList.length; i++) {
            Node current = map.get(i + 1);
            for (int neighborVal : adjList[i]) {
                current.neighbors.add(map.get(neighborVal));
            }
        }

        return map.get(1);
    }

    /**
     * Helper method to get the adjacency list from a graph.
     * @param node The reference node of the graph.
     * @return The adjacency list representing the graph.
     */
    private List<List<Integer>> getAdjacencyList(Node node) {
        List<List<Integer>> adjList = new ArrayList<>();
        if (node == null) {
            return adjList;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighbors.add(neighbor.val);
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.offer(neighbor);
                }
            }
            map.put(current.val, neighbors);
        }

        // Ensure the list is ordered by node values
        int size = map.size();
        for (int i = 1; i <= size; i++) {
            adjList.add(map.getOrDefault(i, new ArrayList<>()));
        }

        return adjList;
    }

    /**
     * Helper method to compare two adjacency lists for equality.
     * @param list1 The first adjacency list.
     * @param list2 The second adjacency list.
     * @return True if both adjacency lists are equal, false otherwise.
     */
    private boolean compareAdjacencyLists(List<List<Integer>> list1, List<List<Integer>> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for(int i = 0; i < list1.size(); i++) {
            List<Integer> neighbors1 = new ArrayList<>(list1.get(i));
            List<Integer> neighbors2 = new ArrayList<>(list2.get(i));
            Collections.sort(neighbors1);
            Collections.sort(neighbors2);
            if (!neighbors1.equals(neighbors2)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testCloneGraph_Example1() {
        int[][] adjListInput = {
            {2, 4},
            {1, 3},
            {2, 4},
            {1, 3}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList(2, 4),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4),
            Arrays.asList(1, 3)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_Example2() {
        int[][] adjListInput = {
            {}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList()
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_Example3() {
        int[][] adjListInput = {};
        List<List<Integer>> expectedAdjList = new ArrayList<>();

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph should be empty.");
        assertNull(cloned, "The cloned graph should be null for an empty input.");
    }

    @Test
    public void testCloneGraph_SingleNode() {
        int[][] adjListInput = {
            {}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList()
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned single-node graph does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned single-node graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_TwoNodes() {
        int[][] adjListInput = {
            {2},
            {1}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(1)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned two-node graph does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned two-node graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_LargerGraph() {
        int[][] adjListInput = {
            {2, 4, 5},
            {1, 3, 5},
            {2, 4},
            {1, 3, 5},
            {1, 2, 4}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList(2, 4, 5),
            Arrays.asList(1, 3, 5),
            Arrays.asList(2, 4),
            Arrays.asList(1, 3, 5),
            Arrays.asList(1, 2, 4)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned larger graph does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned larger graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_DisconnectedGraph() {
        // Although the problem states the graph is connected, testing disconnected graph should return only the connected component.
        int[][] adjListInput = {
            {2},
            {1},
            {4},
            {3}
        };
        // Since the cloneGraph method assumes a connected graph starting from node 1,
        // the expected adjacency list should only include the first two nodes.
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(1)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph should only include the connected component starting from node 1.");
        assertNotSame(original, cloned, "The cloned graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_SelfLoop() {
        // Although the problem states there are no self-loops, testing to ensure the method handles it gracefully.
        int[][] adjListInput = {
            {1, 2},
            {1}
        };
        List<List<Integer>> expectedAdjList = Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(1)
        );

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph with a self-loop does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned graph should be a different instance from the original graph.");
    }

    @Test
    public void testCloneGraph_MaxNodes() {
        // Creating a graph with 100 nodes in a linear chain.
        int n = 100;
        int[][] adjListInput = new int[n][];
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            if (i > 0) neighbors.add(i);
            if (i < n - 1) neighbors.add(i + 2);
            adjListInput[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }

        List<List<Integer>> expectedAdjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = new ArrayList<>();
            if (i > 0) neighbors.add(i);
            if (i < n - 1) neighbors.add(i + 2);
            expectedAdjList.add(neighbors);
        }

        CloneGraph solution = new CloneGraph();
        Node original = buildGraph(adjListInput);
        Node cloned = solution.cloneGraph(original);
        List<List<Integer>> clonedAdjList = getAdjacencyList(cloned);

        assertTrue(compareAdjacencyLists(expectedAdjList, clonedAdjList), "The cloned graph with maximum nodes does not match the expected adjacency list.");
        assertNotSame(original, cloned, "The cloned graph should be a different instance from the original graph.");
    }
}