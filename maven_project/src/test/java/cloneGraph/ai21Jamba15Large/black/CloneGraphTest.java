package cloneGraph.ai21Jamba15Large.black;
import cloneGraph.*;
import cloneGraph.CloneGraph.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {
    
    public Node createGraph(List<List<Integer>> adjList) {
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < adjList.size(); i++) {
            Node node = new Node(i + 1);
            nodes.add(node);
        }
        
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> neighbors = adjList.get(i);
            for (int neighbor : neighbors) {
                nodes.get(i).neighbors.add(nodes.get(neighbor - 1));
            }
        }
        
        return nodes.get(0);
    }
    
    public void assertGraphsEqual(Node expected, Node actual) {
        List<Node> expectedNodes = new ArrayList<>();
        List<Node> actualNodes = new ArrayList<>();
        
        dfs(expected, expectedNodes);
        dfs(actual, actualNodes);
        
        Assertions.assertEquals(expectedNodes.size(), actualNodes.size());
        
        for (int i = 0; i < expectedNodes.size(); i++) {
            Node expectedNode = expectedNodes.get(i);
            Node actualNode = actualNodes.get(i);
            Assertions.assertEquals(expectedNode.val, actualNode.val);
            Assertions.assertEquals(expectedNode.neighbors.size(), actualNode.neighbors.size());
            
            for (int j = 0; j < expectedNode.neighbors.size(); j++) {
                Assertions.assertEquals(expectedNode.neighbors.get(j).val, actualNode.neighbors.get(j).val);
            }
        }
    }
    
    private void dfs(Node node, List<Node> visited) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (Node neighbor : node.neighbors) {
            dfs(neighbor, visited);
        }
    }
    
    @Test
    void testCloneGraphExample1() {
        List<List<Integer>> adjList = List.of(
            List.of(2, 4),
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 3)
        );
        
        Node original = createGraph(adjList);
        Node cloned = new CloneGraph().cloneGraph(original);
        
        assertGraphsEqual(original, cloned);
    }
    
    @Test
    void testCloneGraphExample2() {
        List<List<Integer>> adjList = List.of(
            List.of()
        );
        
        Node original = createGraph(adjList);
        Node cloned = new CloneGraph().cloneGraph(original);
        
        assertGraphsEqual(original, cloned);
    }
    
    @Test
    void testCloneGraphExample3() {
        List<List<Integer>> adjList = List.of();
        
        Node original = createGraph(adjList);
        Node cloned = new CloneGraph().cloneGraph(original);
        
        assertGraphsEqual(original, cloned);
    }
    
    @Test
    void testCloneGraphComplexGraph() {
        List<List<Integer>> adjList = List.of(
            List.of(2, 3, 4),
            List.of(1, 5),
            List.of(1, 6),
            List.of(1, 7),
            List.of(1),
            List.of(2, 8),
            List.of(3, 9),
            List.of(4),
            List.of(5),
            List.of(6)
        );
        
        Node original = createGraph(adjList);
        Node cloned = new CloneGraph().cloneGraph(original);
        
        assertGraphsEqual(original, cloned);
    }
}