import java.util.HashMap;
class LRUCache {
    class Node{
        int key;
        int val;

        Node next;
        Node prev;

        public Node(int key,int val){
            this.key=key;
            this.val=val;
            this.next=null;
            this.prev=null;
        }
    }

    Node head;
    Node tail;

    int capacity;
    int len=0;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head= new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            delNode(temp);
            addNode(temp);
            return temp.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp=map.get(key);
            delNode(temp);
            temp.val=value;
            addNode(temp);
        }else{
            if(len==capacity){
                delNode(tail.prev);
            }
            Node temp= new Node(key,value);
            addNode(temp);
        }
    }

    public void addNode(Node root){
        map.put(root.key,root);
        root.next=head.next;
        root.prev=head;
        head.next=root;
        root.next.prev=root;
        len++;
    }

    public void delNode(Node root){
        map.remove(root.key);
        root.prev.next=root.next;
        root.next.prev=root.prev;
        len--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */











// import java.util.LinkedHashMap;
// class LRUCache {
//     LinkedHashMap<Integer,Integer> cache;
//     int size;
//     public LRUCache(int capacity) {
//         size=capacity;
//         cache=new LinkedHashMap<>(size,0.75f,true){
//             @Override
//             protected boolean removeEldestEntry(Map.Entry eldest) {
//                 return size() > size;
//                 }
//         };
//     }       
        
//     public int get(int key) {
//         if(cache.containsKey(key)){
//             return cache.get(key);
//         }
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         cache.put(key,value);
//     }
// }

// /**
//  * Your LRUCache object will be instantiated and called as such:
//  * LRUCache obj = new LRUCache(capacity);
//  * int param_1 = obj.get(key);
//  * obj.put(key,value);
//  */