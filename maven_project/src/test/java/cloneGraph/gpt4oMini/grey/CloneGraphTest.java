package cloneGraph.gpt4oMini.grey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

public class CloneGraphTest {

    private CloneGraph cloneGraphObj = new CloneGraph();

    @Test
    public void testCloneGraphExample1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = cloneGraphObj.cloneGraph(node1);
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
            Arrays.asList(2, 4),
            Arrays.asList(1, 3),
            Arrays.asList(2, 4),
            Arrays.asList(1, 3)
        ));
        List<List<Integer>> actual = getAdjacencyList(clonedGraph);
        assertEquals(expected, actual);
    }

    @Test
    public void testCloneGraphExample2() {
        Node node1 = new Node(1);

        Node clonedGraph = cloneGraphObj.cloneGraph(node1);
        List<List<Integer>> expected = new ArrayList<>(Arrays.asList(
            new ArrayList<>()
        ));
        List<List<Integer>> actual = getAdjacencyList(clonedGraph);
        assertEquals(expected, actual);
    }

    @Test
    public void testCloneGraphEmptyInput() {
        Node clonedGraph = cloneGraphObj.cloneGraph(null);
        assertEquals(null, clonedGraph);
    }

    private List<List<Integer>> getAdjacencyList(Node node) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        List<Node> visited = new ArrayList<>();
        if (node != null) {
            dfs(node, visited, adjacencyList);
        }
        return adjacencyList;
    }

    private void dfs(Node node, List<Node> visited, List<List<Integer>> adjacencyList) {
        if (visited.contains(node)) return;
        visited.add(node);
        List<Integer> neighborList = new ArrayList<>();
        for (Node neighbor : node.neighbors) {
            neighborList.add(neighbor.val);
        }
        adjacencyList.add(neighborList);
        for (Node neighbor : node.neighbors) {
            dfs(neighbor, visited, adjacencyList);
        }
    }
}