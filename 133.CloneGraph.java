import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    private  HashMap<Node, Node> map= new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }

        if(map.containsKey(node)){
            return map.get(node) ;
        }

        Node root= new Node(node.val, new ArrayList());
        map.put(node, root);
        for(Node temp: node.neighbors){
            root.neighbors.add(cloneGraph(temp));
        }   
        return root;
    }
}