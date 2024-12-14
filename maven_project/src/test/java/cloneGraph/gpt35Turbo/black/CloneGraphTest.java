package cloneGraph.gpt35Turbo.black;

import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CloneGraphTest {

    @Test
    void testCloneGraphSingleNode() {
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node);
        assertNotNull(clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    void testCloneGraphMultipleNodes() {
        List<Node> neighbors1 = new ArrayList<>();
        List<Node> neighbors2 = new ArrayList<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        neighbors1.add(node2);
        neighbors1.add(node3);
        node1.neighbors = neighbors1;
        neighbors2.add(node1);
        node2.neighbors = neighbors2;
        node3.neighbors = neighbors2;

        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
        for (int i = 0; i < node1.neighbors.size(); i++) {
            assertEquals(node1.neighbors.get(i).val, clonedNode.neighbors.get(i).val);
        }
    }
}