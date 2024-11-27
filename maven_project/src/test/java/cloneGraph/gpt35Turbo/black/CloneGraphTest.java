package cloneGraph.gpt35Turbo.black;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    @Test
    void testCloneGraph() {
        // Create nodes for testing
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // Setup neighbors for nodes
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        // Create CloneGraph object and clone graph
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedNode = cloneGraph.cloneGraph(node1);

        // Check if cloned graph has correct neighbors
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);

        assertEquals(1, clonedNode.neighbors.get(0).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(0).neighbors.get(1).val);

        assertEquals(2, clonedNode.neighbors.get(1).neighbors.get(0).val);
        assertEquals(3, clonedNode.neighbors.get(1).neighbors.get(1).val);
    }
}