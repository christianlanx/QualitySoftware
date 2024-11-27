package cloneGraph.gpt35Turbo.white;
import cloneGraph.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CloneGraphTest {
    
    @Test
    void testCloneGraph_NullInput() {
        CloneGraph cg = new CloneGraph();
        Node result = cg.cloneGraph(null);
        assertNull(result);
    }
    
    @Test
    void testCloneGraph() {
        CloneGraph cg = new CloneGraph();
        
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        
        n1.neighbors.add(n2);
        n2.neighbors.add(n3);
        n3.neighbors.add(n1);
        
        Node result = cg.cloneGraph(n1);
        
        assertNotNull(result);
        assertEquals(1, result.val);
        
        List<Node> resultNeighbors = result.neighbors;
        assertEquals(1, resultNeighbors.size());
        assertEquals(2, resultNeighbors.get(0).val);
        
        List<Node> resultNeighbors2 = resultNeighbors.get(0).neighbors;
        assertEquals(1, resultNeighbors2.size());
        assertEquals(3, resultNeighbors2.get(0).val);
    }

}