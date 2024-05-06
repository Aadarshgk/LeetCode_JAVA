import java.util.Stack;
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        StringBuilder sb= new StringBuilder();
        for(String dir : path.split("/")){
            if(dir.equals(".") || dir.isEmpty()){
                continue;
            }else if(dir.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(dir);
            }
        }
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        if(sb.isEmpty()){
            sb.append("/");
        }

        return sb.toString();
    }
}