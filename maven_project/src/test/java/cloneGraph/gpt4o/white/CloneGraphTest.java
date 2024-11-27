package cloneGraph.gpt4o.white;
import cloneGraph.*;

import cloneGraph.CloneGraph.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    void testCloneGraphWithNull() {
        CloneGraph cg = new CloneGraph();
        assertNull(cg.cloneGraph(null), "Cloning a null graph should return null.");
    }

    @Test
    void testCloneGraphWithSingleVertex() {
        CloneGraph cg = new CloneGraph();
        Node node = new Node(1);
        Node clonedNode = cg.cloneGraph(node);

        assertNotNull(clonedNode, "Cloned node should not be null.");
        assertEquals(node.val, clonedNode.val, "Node values should match.");
        assertNotSame(node, clonedNode, "Cloned node should be a different instance.");
        assertTrue(clonedNode.neighbors.isEmpty(), "Cloned node should have no neighbors.");
    }

    @Test
    void testCloneGraphWithLinearGraph() {
        CloneGraph cg = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);

        Node clonedNode1 = cg.cloneGraph(node1);
        Node clonedNode2 = clonedNode1.neighbors.get(0);
        Node clonedNode3 = clonedNode2.neighbors.get(0);

        assertNotNull(clonedNode1, "Cloned node1 should not be null.");
        assertNotNull(clonedNode2, "Cloned node2 should not be null.");
        assertNotNull(clonedNode3, "Cloned node3 should not be null.");

        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode2.val);
        assertEquals(3, clonedNode3.val);

        assertNotSame(node1, clonedNode1, "Node1 and clonedNode1 should be different instances.");
        assertNotSame(node2, clonedNode2, "Node2 and clonedNode2 should be different instances.");
        assertNotSame(node3, clonedNode3, "Node3 and clonedNode3 should be different instances.");
        
        assertTrue(clonedNode3.neighbors.isEmpty(), "Cloned node3 should have no neighbors.");
    }

    @Test
    void testCloneGraphWithCycle() {
        CloneGraph cg = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clonedNode1 = cg.cloneGraph(node1);
        Node clonedNode2 = clonedNode1.neighbors.get(0);

        assertEquals(1, clonedNode1.val);
        assertEquals(2, clonedNode2.val);

        assertNotSame(node1, clonedNode1, "Node1 and clonedNode1 should be different instances.");
        assertNotSame(node2, clonedNode2, "Node2 and clonedNode2 should be different instances.");

        assertEquals(clonedNode1, clonedNode2.neighbors.get(0), "Cloned node2 should have cloned node1 as neighbor.");
    }

    @Test
    void testCloneGraphWithBranchingGraph() {
        CloneGraph cg = new CloneGraph();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.addAll(Arrays.asList(node2, node3));
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);

        Node clonedNode1 = cg.cloneGraph(node1);

        assertNotNull(clonedNode1, "Cloned node1 should not be null.");
        assertEquals(1, clonedNode1.val);

        List<Node> clonedNode1Neighbors = clonedNode1.neighbors;
        assertEquals(2, clonedNode1Neighbors.size(), "Node1 should have two neighbors.");

        Node clonedNode2 = findClonedNode(clonedNode1Neighbors, 2);
        Node clonedNode3 = findClonedNode(clonedNode1Neighbors, 3);
        
        assertNotNull(clonedNode2, "Cloned node2 should not be null.");
        assertNotNull(clonedNode3, "Cloned node3 should not be null.");

        assertTrue(clonedNode2.neighbors.contains(findClonedNode(clonedNode2.neighbors, 4)), "Node2 should be connected to Node4.");
        assertTrue(clonedNode3.neighbors.contains(findClonedNode(clonedNode3.neighbors, 4)), "Node3 should be connected to Node4.");
    }

    private Node findClonedNode(List<Node> nodes, int val) {
        return nodes.stream().filter(n -> n.val == val).findFirst().orElse(null);
    }
}