import java.util.Stack;
class MyQueue {
    Stack<Integer> stack= new Stack<>();
    Stack<Integer> helper= new Stack<>();    
    public MyQueue() {
        
    }
    
    public void push(int x) {
        if(!helper.isEmpty()){
            while(!helper.isEmpty()){
                stack.push(helper.pop());
            }
        }
        stack.push(x);
    }
    
    public int pop() {
        while(!stack.isEmpty()){
            helper.push(stack.pop());
        }
        return helper.pop();
    }
    
    public int peek() {
        if(helper.isEmpty()){
           while(!stack.isEmpty()){
                helper.push(stack.pop());
            }
        }
        return helper.peek();
    }
    
    public boolean empty() {
        if(stack.isEmpty() && helper.isEmpty()) return true;
        return false;
    }
}