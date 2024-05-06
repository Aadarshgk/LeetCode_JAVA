import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        int i=0,len=s.length();
        char ele;
        while(i<len){
            ele=s.charAt(i);
            if(ele=='(' || ele=='{' || ele=='['){
                stack.push(ele);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                switch(ele){
                    case ')':
                        if(stack.peek()!='('){
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;

                    case '}':
                        if(stack.peek()!='{'){
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;
                    case ']':
                        if(stack.peek()!='['){
                            return false;
                        }else{
                            stack.pop();
                        }
                        break;
                    }
                }
                i++;
            }
        if(stack.isEmpty()==true){
            return true;
        }
        return false;
    }
}