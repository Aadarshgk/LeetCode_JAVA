import java.util.Queue;
import java.util.LinkedList;
class MyStack {
    Queue<Integer> q= new LinkedList<>();
    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int i=0,len=q.size();
        while(i<len-1){
            q.add(q.remove());
            i++;
        }
        return q.remove();
    }
    
    public int top() {
        int i=0,len=q.size();
        while(i<len-1){
            q.add(q.remove());
            i++;
        }
        i=q.peek();
        q.add(q.remove());
        return i;
    }
    
    public boolean empty() {
        if(q.peek()==null){
            return true;
        }
        return false;
    }
}
