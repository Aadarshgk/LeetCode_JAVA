
import java.util.HashMap;
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node,Node> map= new HashMap<>();
        Node root=new Node(head.val);
        Node temp1=head.next;
        Node temp2=root;
        map.put(head,root);
        while(temp1!=null){
            temp2.next=new Node(temp1.val);
            temp2=temp2.next;
            map.put(temp1,temp2);
            temp1=temp1.next;
        }
        temp1=head;
        temp2=root;
        while(temp1!=null){
            temp2.random=map.get(temp1.random);
            temp2=temp2.next;
            temp1=temp1.next;
        }
        return root;
    }
}