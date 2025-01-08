import java.util.Arrays;
class Trie {
    class Node{
        boolean isLast;
        Node[] node;

        Node(){
            this.isLast=false;
            this.node= new Node[26];
            Arrays.fill(this.node,null);
        }
    }

    Node root;
    public Trie() {
        root= new Node();
    }
    
    public void insert(String word) {
        insert(root,word.toCharArray(),0);
    }

    public void insert(Node head,char[] ar,int i){

        if(i==ar.length){
            head.isLast=true;
            return;
        }

        int id=ar[i]-'a';
        if(head.node[id]==null){
            head.node[id]=new Node();
        }


        insert(head.node[id],ar,i+1);

    }
    
    public boolean search(String word) {
        return search(root,word.toCharArray(),0);
    }

    public boolean search(Node head,char[] ar, int i){
        if(i==ar.length){
            if(head.isLast) return true;
            return false;
        }
        int id=ar[i]-'a';
        if(head.node[id] == null) return false;
        return search(head.node[id],ar,i+1);
    }
    
    public boolean startsWith(String prefix) {
        return startsWith(root,prefix.toCharArray(),0);
    }

    public boolean startsWith(Node head, char[] ar, int i){
        if(i==ar.length){
            return true;
        }
        int id=ar[i]-'a';
        if(head.node[id] == null) return false;
        return startsWith(head.node[id],ar,i+1);
    }
}
