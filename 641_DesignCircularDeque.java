class MyCircularDeque {

    class Node{
        int val;
        Node next;
        Node prev;

        public Node(){
            this.next=null;
            this.prev=null;
        }        
        
        public Node(int val){
            this.val=val;
            this.next=null;
            this.prev=null;
        }        
    }

    private int len;
    private Node front;
    private Node rear;
    private int maxLen;

    public MyCircularDeque(int k) {
        front=new Node();
        rear=new Node();
        front.next=rear;
        rear.prev=front;
        len=0;
        maxLen=k;
    }
    
    public boolean insertFront(int value) {
        if(len==maxLen) return false;;
        Node node= new Node(value);
        node.next=front.next;
        node.prev=front;
        node.next.prev=node;
        front.next=node;
        len++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(len==maxLen) return false;
        Node node= new Node(value);
        node.next=rear;
        node.prev=rear.prev;
        node.prev.next=node;
        node.next=rear;
        rear.prev=node;
        len++;
        return true;
    }
    
    public boolean deleteFront() {
        if(len==0) return false;
        front.next=front.next.next;
        front.next.prev=front;
        len--;
        return true;
    }
    
    public boolean deleteLast() {
        if(len==0) return false;
        rear.prev=rear.prev.prev;
        rear.prev.next=rear;
        len--;
        return true;
    }
    
    public int getFront() {
        if(len==0) return -1;
        return front.next.val;
    }
    
    public int getRear() {
        if(len==0) return -1;
        return rear.prev.val;
    }
    
    public boolean isEmpty() {
        return len==0;
    }
    
    public boolean isFull() {
        return len==maxLen;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */