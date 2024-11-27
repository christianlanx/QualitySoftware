package cloneGraph.copilot.prompt1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import cloneGraph.CloneGraph;
import cloneGraph.CloneGraph.Node;


import java.util.*;

public class cloneGraphcopilotTest {

    @Test
    public void testCloneGraph_Example1() {
        CloneGraph solution = new CloneGraph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        Node clonedNode = solution.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(2, clonedNode.neighbors.size());
        assertEquals(2, clonedNode.neighbors.get(0).val);
        assertEquals(4, clonedNode.neighbors.get(1).val);
    }

    @Test
    public void testCloneGraph_Example2() {
        CloneGraph solution = new CloneGraph();

        Node node1 = new Node(1);

        Node clonedNode = solution.cloneGraph(node1);

        assertNotNull(clonedNode);
        assertEquals(1, clonedNode.val);
        assertEquals(0, clonedNode.neighbors.size());
    }

    @Test
    public void testCloneGraph_Example3() {
        CloneGraph solution = new CloneGraph();

        Node clonedNode = solution.cloneGraph(null);

        assertEquals(null, clonedNode);
    }

    private String graphToString(Node node) {
        if (node == null) {
            return "null";
        }
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node.val, node);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            sb.append(current.val).append(": [");
            for (Node neighbor : current.neighbors) {
                sb.append(neighbor.val).append(",");
                if (!visited.containsKey(neighbor.val)) {
                    queue.offer(neighbor);
                    visited.put(neighbor.val, neighbor);
                }
            }
            if (current.neighbors.size() > 0) {
                sb.setLength(sb.length() - 1);
            }
            sb.append("] ");
        }

        return sb.toString();
    }
}
