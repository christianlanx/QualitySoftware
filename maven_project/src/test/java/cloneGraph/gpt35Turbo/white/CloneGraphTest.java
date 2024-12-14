package cloneGraph.gpt35Turbo.white;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;

public class CloneGraphTest {

    private CloneGraph cloneGraph;

    @BeforeEach
    public void setup() {
        cloneGraph = new CloneGraph();
    }

    @Test
    public void testCloneGraphSingleNode() {
        Node node = new Node(1);
        Node cloned = cloneGraph.cloneGraph(node);
        assertNotNull(cloned);
        assertEquals(node.val, cloned.val);
    }

    @Test
    public void testCloneGraphMultipleNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        
        Node cloned = cloneGraph.cloneGraph(node1);
        assertNotNull(cloned);
        assertEquals(node1.val, cloned.val);
        assertEquals(node1.neighbors.size(), cloned.neighbors.size());
        assertEquals(node1.neighbors.get(0).val, cloned.neighbors.get(0).val);
        assertEquals(node1.neighbors.get(1).val, cloned.neighbors.get(1).val);
    }
}