package cloneGraph.ai21Jamba.prompt1;
import cloneGraph.CloneGraph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import java.util.ArrayList;
import java.util.List;

public class CloneGraphTest {

    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;

    @Before
    public void setUp() {
        // Initialize nodes for testing
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
    }

    @After
    public void tearDown() {
        node1 = null;
        node2 = null;
        node3 = null;
        node4 = null;
    }

    @Test
    public void testCloneGraphSingleNode() {
        Node node = new Node(1);
        Node clonedGraph = new CloneGraph().cloneGraph(node);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertTrue(clonedGraph.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraphMultiNode() {
        Node clonedGraph = new CloneGraph().cloneGraph(node1);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(2, clonedGraph.neighbors.size());

        Node clonedNode2 = clonedGraph.neighbors.get(0);
        assertEquals(2, clonedNode2.val);
        assertEquals(2, clonedNode2.neighbors.size());

        Node clonedNode4 = clonedGraph.neighbors.get(1);
        assertEquals(4, clonedNode4.val);
        assertEquals(2, clonedNode4.neighbors.size());

        Node clonedNode3 = clonedNode2.neighbors.get(1);
        assertEquals(3, clonedNode3.val);
        assertEquals(2, clonedNode3.neighbors.size());
    }

    @Test
    public void testCloneGraphEmptyGraph() {
        Node clonedGraph = new CloneGraph().cloneGraph(null);
        assertNull(clonedGraph);
    }

    @Test
    public void testCloneGraphEmptyNode() {
        Node node = new Node(1);
        node.neighbors = new ArrayList<>();
        Node clonedGraph = new CloneGraph().cloneGraph(node);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertTrue(clonedGraph.neighbors.isEmpty());
    }

    @Test
    public void testCloneGraphLargerGraph() {
        // Create a larger graph for testing
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.neighbors.add(node5);
        node1.neighbors.add(node6);
        node5.neighbors.add(node1);
        node6.neighbors.add(node1);

        Node clonedGraph = new CloneGraph().cloneGraph(node1);
        assertNotNull(clonedGraph);
        assertEquals(1, clonedGraph.val);
        assertEquals(4, clonedGraph.neighbors.size());

        Node clonedNode5 = clonedGraph.neighbors.get(2);
        assertEquals(5, clonedNode5.val);
        assertEquals(1, clonedNode5.neighbors.size());

        Node clonedNode6 = clonedGraph.neighbors.get(3);
        assertEquals(6, clonedNode6.val);
        assertEquals(1, clonedNode6.neighbors.size());
    }
}
```

To complete this test suite, you need to implement the `cloneGraph` method in the `CloneGraph` class. Here is a possible implementation:

```java
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Use a HashMap to keep track of visited nodes and their clones
        HashMap<Node, Node> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    private Node cloneGraphHelper(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphHelper(neighbor, visited));
        }

        return cloneNode;
    }
}