package cloneGraph.gpt4o.grey;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class CloneGraphTest {
    private CloneGraph cloneGraph;

    @BeforeEach
    public void setUp() {
        cloneGraph = new CloneGraph();
    }

    private List<Node> createGraphFromAdjList(int[][] adjList) {
        if (adjList.length == 0) return new ArrayList<>();

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < adjList.length; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int i = 0; i < adjList.length; i++) {
            List<Node> neighbors = new ArrayList<>();
            for (int neighbor : adjList[i]) {
                neighbors.add(nodes.get(neighbor - 1));
            }
            nodes.get(i).neighbors = neighbors;
        }

        return nodes;
    }

    private int[][] convertGraphToAdjList(Node node) {
        if (node == null) return new int[][]{};

        List<List<Integer>> adjList = new ArrayList<>();
        List<Node> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited.contains(current)) continue;

            visited.add(current);
            List<Integer> neighbors = new ArrayList<>();
            for (Node neighbor : current.neighbors) {
                neighbors.add(neighbor.val);
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }

            adjList.add(neighbors);
        }

        int[][] result = new int[adjList.size()][];
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> neighbors = adjList.get(i);
            result[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    private void assertGraphEquals(int[][] expectedAdjList, Node clonedGraph) {
        int[][] clonedAdjList = convertGraphToAdjList(clonedGraph);
        assertArrayEquals(expectedAdjList, clonedAdjList);
    }

    @Test
    public void testCloneGraphExample1() {
        int[][] adjList = {{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        Node clonedGraph = cloneGraph.cloneGraph(nodes.get(0));
        assertGraphEquals(adjList, clonedGraph);
    }

    @Test
    public void testCloneGraphExample2() {
        int[][] adjList = {{}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        Node clonedGraph = cloneGraph.cloneGraph(nodes.get(0));
        assertGraphEquals(adjList, clonedGraph);
    }

    @Test
    public void testCloneGraphExample3() {
        int[][] adjList = {};
        Node clonedGraph = cloneGraph.cloneGraph(null);
        assertGraphEquals(adjList, clonedGraph);
    }

    @Test
    public void testCloneGraphWithSingleIsolatedNode() {
        int[][] adjList = {{}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        Node clonedGraph = cloneGraph.cloneGraph(nodes.get(0));
        assertGraphEquals(adjList, clonedGraph);
    }

    @Test
    public void testCloneGraphWithTwoConnectedNodes() {
        int[][] adjList = {{2}, {1}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        Node clonedGraph = cloneGraph.cloneGraph(nodes.get(0));
        assertGraphEquals(adjList, clonedGraph);
    }
}