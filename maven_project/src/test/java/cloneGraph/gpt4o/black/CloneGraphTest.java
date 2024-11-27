package cloneGraph.gpt4o.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {
    private final CloneGraph cloneGraph = new CloneGraph();

    @Test
    void testExample1() {
        // Create the original graph [[2,4],[1,3],[2,4],[1,3]]
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
        
        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Verify the cloned graph
        assertGraphEquality(node1, clonedNode);
    }

    @Test
    void testExample2() {
        // Create the original graph [[]]
        Node node1 = new Node(1);
        
        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Verify the cloned graph
        assertGraphEquality(node1, clonedNode);
    }

    @Test
    void testExample3() {
        // Empty graph test
        Node clonedNode = cloneGraph.cloneGraph(null);
        assertNull(clonedNode);
    }

    @Test
    void testSingleNodeGraph() {
        // Create a graph with a single node with no neighbors
        Node node1 = new Node(1);
        
        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Verify the cloned graph
        assertGraphEquality(node1, clonedNode);
    }

    @Test
    void testLineGraph() {
        // Create a line graph 1-2-3-4
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        
        // Clone the graph
        Node clonedNode = cloneGraph.cloneGraph(node1);
        
        // Verify the cloned graph
        assertGraphEquality(node1, clonedNode);
    }

    private void assertGraphEquality(Node original, Node cloned) {
        // Using a set to avoid cycles and infinite loops
        Set<Node> visitedOriginal = new HashSet<>();
        Set<Node> visitedCloned = new HashSet<>();
        assertGraphEqualityHelper(original, cloned, visitedOriginal, visitedCloned);
    }

    private void assertGraphEqualityHelper(Node original, Node cloned, Set<Node> visitedOriginal, Set<Node> visitedCloned) {
        if (original == null) {
            assertNull(cloned);
            return;
        }

        assertNotNull(cloned);
        assertEquals(original.val, cloned.val);

        if (!visitedOriginal.contains(original)) {
            visitedOriginal.add(original);
            visitedCloned.add(cloned);
            
            assertEquals(original.neighbors.size(), cloned.neighbors.size());
            for (int i = 0; i < original.neighbors.size(); i++) {
                assertFalse(visitedCloned.contains(cloned.neighbors.get(i)));
                assertGraphEqualityHelper(original.neighbors.get(i), cloned.neighbors.get(i), visitedOriginal, visitedCloned);
            }
        }
    }
}