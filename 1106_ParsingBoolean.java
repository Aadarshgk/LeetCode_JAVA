import java.util.Stack;
class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack= new Stack<>();
        for(char c: expression.toCharArray()){
            if(c==',' || c=='(') continue;
            if(c==')'){
                boolean hasTrue=false,hasFalse=false;
                while(stack.peek()!='&' && stack.peek()!='!' && stack.peek()!='|'){
                    char top= stack.pop();
                    if(top=='t') hasTrue=true;
                    if(top=='f') hasFalse=true;
                } 

                char op=stack.pop();
                if(op=='|'){
                    stack.push(hasTrue?'t':'f');
                }else if(op=='&'){
                    stack.push(hasFalse?'f':'t');
                }else{
                    stack.push(hasTrue?'f':'t');
                }
            }else{
                stack.push(c);
            }
        }

        return stack.peek()=='t'?true:false;
    }
}