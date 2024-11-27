package cloneGraph.mistralSmall.white;
import cloneGraph.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    @Test
    public void testCloneGraphNullNode() {
        CloneGraph cloneGraph = new CloneGraph();
        Node result = cloneGraph.cloneGraph(null);
        assertNull(result);
    }

    @Test
    public void testCloneGraphSingleNode() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = new Node(1);
        Node result = cloneGraph.cloneGraph(node);
        assertEquals(1, result.val);
        assertTrue(result.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraphTwoNodes() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        Node result = cloneGraph.cloneGraph(node1);
        assertEquals(1, result.val);
        assertEquals(1, result.neighbors.size());
        assertEquals(2, result.neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphMultipleNodes() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        Node result = cloneGraph.cloneGraph(node1);
        assertEquals(1, result.val);
        assertEquals(1, result.neighbors.size());
        assertEquals(2, result.neighbors.get(0).val);
        assertEquals(1, result.neighbors.get(0).neighbors.size());
        assertEquals(3, result.neighbors.get(0).neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphWithCycle() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        Node result = cloneGraph.cloneGraph(node1);
        assertEquals(1, result.val);
        assertEquals(1, result.neighbors.size());
        assertEquals(2, result.neighbors.get(0).val);
        assertEquals(1, result.neighbors.get(0).neighbors.size());
        assertEquals(1, result.neighbors.get(0).neighbors.get(0).val);
    }

    @Test
    public void testCloneGraphWithNoNeighbors() {
        CloneGraph cloneGraph = new CloneGraph();
        Node node = new Node(1);
        Node result = cloneGraph.cloneGraph(node);
        assertEquals(1, result.val);
        assertTrue(result.neighbors.isEmpty());
    }
}