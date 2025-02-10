//Stack soln
// class Solution {
//     public String clearDigits(String s) {
//         Stack<Character> stack=new Stack<>();
//         for(char c: s.toCharArray()){
//             if(c-'0'>=0 && c-'0' <=9){
//                 if(!stack.isEmpty()){
//                     stack.pop();
//                 }
//             }else{
//                 stack.push(c);
//             }
//         }
//         StringBuilder sb=new StringBuilder();
//         while(!stack.isEmpty()){
//             sb.insert(0,stack.pop());
//         }
//         return sb.toString();
//     }
// }


class Solution {
    public String clearDigits(String s) {
        StringBuilder sb= new StringBuilder();
        int i=-1,len=s.length();
        for(int j=0;j<len;j++){
            char c=s.charAt(j);
            if(c-'0'>=0 && c-'0'<=9){
                if(i>=0){
                    sb.deleteCharAt(i--);
                }
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
}