package cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CloneGraph {
    
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> shadow = new HashMap<Node, Node>();
            shadow.put(node,new Node(node.val));
        Queue< Node> queue= new LinkedList<Node>();
            queue.add(node);
        
        while(!queue.isEmpty()){

            Node currentNode = queue.poll();
            for(Node n: currentNode.neighbors){
                if(shadow.containsKey(n)){
                    // do nothing.
                }else{
                    shadow.put(n,new Node(n.val));
                    queue.add(n);
                }
                shadow.get(currentNode).neighbors.add(shadow.get(n));

            }
        }
        return shadow.get(node);
        
    }
}