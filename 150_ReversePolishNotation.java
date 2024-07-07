import java.util.Stack;
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack= new Stack<>();
        int len=tokens.length;
        for(int i=0;i<len;i++){
            if(tokens[i].equals("+")){
                int num2=stack.pop();
                int num1=stack.pop();
                stack.push(num1+num2);
            }else if(tokens[i].equals("-")){
                int num2=stack.pop();
                int num1=stack.pop();
                stack.push(num1-num2);
            }else if(tokens[i].equals("*")){
                int num2=stack.pop();
                int num1=stack.pop();
                stack.push(num1*num2);
            }else if(tokens[i].equals("/")){
                int num2=stack.pop();
                int num1=stack.pop();
                stack.push((int)num1/num2);
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }   
        return stack.pop();
    }
}