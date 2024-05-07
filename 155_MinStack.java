import java.util.Stack;
class MinStack {
    Stack<Integer> stack= new Stack<>();
    Stack<Integer> min= new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else if(val<=min.peek()){
            min.push(val);
        }    
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            int num=stack.pop();
            if(num==min.peek()){
                min.pop();
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
