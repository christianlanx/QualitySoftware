package cloneGraph.gpt4o.black;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraphTest {

    private List<Node> createGraphFromAdjList(int[][] adjList) {
        if (adjList == null || adjList.length == 0) return new ArrayList<>();

        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 1; i <= adjList.length; i++) {
            nodes.put(i, new Node(i));
        }

        for (int i = 0; i < adjList.length; i++) {
            Node node = nodes.get(i + 1);
            for (int neighbor : adjList[i]) {
                node.neighbors.add(nodes.get(neighbor));
            }
        }

        return new ArrayList<>(nodes.values());
    }

    private boolean compareGraphs(Node node1, Node node2, Map<Integer, Node> visited) {
        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;
        if (node1.val != node2.val) return false;
        
        visited.put(node1.val, node1);

        if (node1.neighbors.size() != node2.neighbors.size()) return false;

        for (int i = 0; i < node1.neighbors.size(); i++) {
            Node neighbor1 = node1.neighbors.get(i);
            Node neighbor2 = node2.neighbors.get(i);

            if (!visited.containsKey(neighbor1.val)) {
                if (!compareGraphs(neighbor1, neighbor2, visited)) return false;
            } else if (visited.get(neighbor1.val) != neighbor2) {
                return false;
            }
        }
        
        return true;
    }

    @Test
    public void testGraphCloneExample1() {
        int[][] adjList = new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        CloneGraph graph = new CloneGraph();

        Node clonedNode = graph.cloneGraph(nodes.get(0));

        assertTrue(compareGraphs(nodes.get(0), clonedNode, new HashMap<>()));
    }

    @Test
    public void testGraphCloneExample2() {
        int[][] adjList = new int[][]{{}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        CloneGraph graph = new CloneGraph();

        Node clonedNode = graph.cloneGraph(nodes.get(0));

        assertTrue(compareGraphs(nodes.get(0), clonedNode, new HashMap<>()));
    }
    
    @Test
    public void testGraphCloneExample3() {
        List<Node> nodes = createGraphFromAdjList(new int[][]{});
        CloneGraph graph = new CloneGraph();

        Node clonedNode = graph.cloneGraph(null);

        assertNull(clonedNode);
    }

    @Test
    public void testSingleNodeGraph() {
        int[][] adjList = new int[][]{{}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        CloneGraph graph = new CloneGraph();

        Node clonedNode = graph.cloneGraph(nodes.get(0));

        assertTrue(compareGraphs(nodes.get(0), clonedNode, new HashMap<>()));
    }

    @Test
    public void testTwoNodesConnected() {
        int[][] adjList = new int[][]{{2}, {1}};
        List<Node> nodes = createGraphFromAdjList(adjList);
        CloneGraph graph = new CloneGraph();

        Node clonedNode = graph.cloneGraph(nodes.get(0));

        assertTrue(compareGraphs(nodes.get(0), clonedNode, new HashMap<>()));
    }
}