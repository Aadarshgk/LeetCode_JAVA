import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generateParenthesis(new StringBuilder(),n,n,res);
        return res;
    }

    public void generateParenthesis(StringBuilder str,int f, int b,List<String> res){
        if(f==0 && b==0){
            res.add(str.toString());
            return;
        }
        
        if(f>0){
            str.append("(");
            generateParenthesis(str,f-1,b,res);
            str.deleteCharAt(str.length()-1);
        }
        if(f<b){
            str.append(")");
            generateParenthesis(str,f,b-1,res);
            str.deleteCharAt(str.length()-1);
        }    
    }
}


//Initial soln
// class Solution {
//     public List<String> generateParenthesis(int n) {
//         List<String> res= new ArrayList<>();
//         generateParenthesis(res,"",n,n,n);
//         return res;
//     }

//     public void generateParenthesis(List<String> res,String str,int n, int f, int b){
//         if(n*2==str.length()){
//             res.add(new String(str));
//             return;
//         }
//         if(n==f){
//             generateParenthesis(res,str+"(",n,f-1,b);
//         }else{
//             if(f>0){
//                 generateParenthesis(res,str+"(",n,f-1,b);
//             }
//             if(f<b){
//                 generateParenthesis(res,str+")",n,f,b-1);
//             }    
//         }
//     }
// }