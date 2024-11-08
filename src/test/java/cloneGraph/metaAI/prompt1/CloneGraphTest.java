package cloneGraph.metaAI.prompt1;
import cloneGraph.CloneGraph;

import org.junit.Test;
import static org.junit.Assert.*;

public class CloneGraphTest {

    CloneGraph cloneGraph = new CloneGraph();

    @Test
    public void testExample1() {
        Node node = new Node(1, Arrays.asList(new Node(2), new Node(4)));
        node.neighbors.get(0).neighbors = Arrays.asList(node, new Node(3));
        node.neighbors.get(1).neighbors = Arrays.asList(node, new Node(3));
        node.neighbors.get(0).neighbors.get(1).neighbors = Arrays.asList(node.neighbors.get(0), node.neighbors.get(1));
        Node expected = new Node(1, Arrays.asList(new Node(2), new Node(4)));
        expected.neighbors.get(0).neighbors = Arrays.asList(expected, new Node(3));
        expected.neighbors.get(1).neighbors = Arrays.asList(expected, new Node(3));
        expected.neighbors.get(0).neighbors.get(1).neighbors = Arrays.asList(expected.neighbors.get(0), expected.neighbors.get(1));
        assertEquals(expected, cloneGraph.cloneGraph(node));
    }

    @Test
    public void testExample2() {
        Node node = new Node(1);
        Node expected = new Node(1);
        assertEquals(expected, cloneGraph.cloneGraph(node));
    }

    @Test
    public void testExample3() {
        Node node = null;
        Node expected = null;
        assertEquals(expected, cloneGraph.cloneGraph(node));
    }

    private void assertEquals(Node expected, Node actual) {
        assertEquals(expected.val, actual.val);
        assertEquals(expected.neighbors.size(), actual.neighbors.size());
        for (int i = 0; i < expected.neighbors.size(); i++) {
            assertEquals(expected.neighbors.get(i).val, actual.neighbors.get(i).val);
        }
    }
}