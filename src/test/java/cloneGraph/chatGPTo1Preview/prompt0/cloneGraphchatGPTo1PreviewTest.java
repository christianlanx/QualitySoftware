package cloneGraph.chatGPTo1Preview.prompt0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

import cloneGraph.CloneGraph;

public class cloneGraphchatGPTo1PreviewTest {
    @Test
    public void testCloneGraphNull() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node = null;
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);
        assertNull(clonedNode);
    }

    @Test
    public void testCloneGraphSingleNode() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node = new CloneGraph.Node(1);
        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotSame(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraphSingleNodeWithSelfLoop() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node = new CloneGraph.Node(1);
        node.neighbors.add(node);  // Self-loop

        CloneGraph.Node clonedNode = cloneGraph.cloneGraph(node);

        assertNotSame(node, clonedNode);
        assertEquals(node.val, clonedNode.val);
        assertEquals(1, clonedNode.neighbors.size());
        assertSame(clonedNode, clonedNode.neighbors.get(0));
    }

    @Test
    public void testCloneGraphTwoNodes() {
        CloneGraph cloneGraph = new CloneGraph();
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        assertNotSame(node1, clonedNode1);
        assertEquals(node1.val, clonedNode1.val);
        assertEquals(1, clonedNode1.neighbors.size());

        CloneGraph.Node clonedNode2 = clonedNode1.neighbors.get(0);
        assertNotSame(node2, clonedNode2);
        assertEquals(node2.val, clonedNode2.val);
        assertEquals(1, clonedNode2.neighbors.size());
        assertSame(clonedNode1, clonedNode2.neighbors.get(0));
    }

    @Test
    public void testCloneGraphComplexGraph() {
        CloneGraph cloneGraph = new CloneGraph();

        // Build the original graph
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Use BFS to compare the original and cloned graphs
        assertTrue(areGraphsEqual(node1, clonedNode1));
    }

    @Test
    public void testCloneGraphDisconnectedGraph() {
        CloneGraph cloneGraph = new CloneGraph();

        // Build the original graph with two disconnected components
        CloneGraph.Node node1 = new CloneGraph.Node(1);
        CloneGraph.Node node2 = new CloneGraph.Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        CloneGraph.Node node3 = new CloneGraph.Node(3);
        CloneGraph.Node node4 = new CloneGraph.Node(4);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);

        // Since cloneGraph clones the component reachable from the given node,
        // only node1 and node2 should be cloned.
        CloneGraph.Node clonedNode1 = cloneGraph.cloneGraph(node1);

        // Verify that node3 and node4 are not cloned
        assertFalse(containsNode(clonedNode1, 3));
        assertFalse(containsNode(clonedNode1, 4));

        // Verify that node1 and node2 are correctly cloned
        assertTrue(areGraphsEqual(node1, clonedNode1));
    }

    /**
     * Helper method to compare two graphs using BFS traversal.
     * Ensures that the graphs are structurally identical and have the same node values,
     * but consist of different node instances.
     *
     * @param node1 the starting node of the first graph
     * @param node2 the starting node of the second graph
     * @return true if the graphs are equal, false otherwise
     */
    private boolean areGraphsEqual(CloneGraph.Node node1, CloneGraph.Node node2) {
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        Map<CloneGraph.Node, CloneGraph.Node> visited = new HashMap<>();
        Queue<CloneGraph.Node> queue1 = new LinkedList<>();
        Queue<CloneGraph.Node> queue2 = new LinkedList<>();

        queue1.add(node1);
        queue2.add(node2);
        visited.put(node1, node2);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            CloneGraph.Node n1 = queue1.poll();
            CloneGraph.Node n2 = queue2.poll();

            if (n1.val != n2.val) {
                return false;
            }
            if (n1.neighbors.size() != n2.neighbors.size()) {
                return false;
            }

            for (int i = 0; i < n1.neighbors.size(); i++) {
                CloneGraph.Node neighbor1 = n1.neighbors.get(i);
                CloneGraph.Node neighbor2 = n2.neighbors.get(i);

                if (visited.containsKey(neighbor1)) {
                    if (visited.get(neighbor1) != neighbor2) {
                        return false;
                    }
                } else {
                    visited.put(neighbor1, neighbor2);
                    queue1.add(neighbor1);
                    queue2.add(neighbor2);
                }
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     * Helper method to check if a node with a given value exists in the graph.
     *
     * @param node the starting node of the graph
     * @param val the value to search for
     * @return true if a node with the given value exists, false otherwise
     */
    private boolean containsNode(CloneGraph.Node node, int val) {
        if (node == null) {
            return false;
        }
        Set<CloneGraph.Node> visited = new HashSet<>();
        Queue<CloneGraph.Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            CloneGraph.Node current = queue.poll();
            if (current.val == val) {
                return true;
            }
            for (CloneGraph.Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}
