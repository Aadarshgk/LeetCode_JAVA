import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        generateParenthesis(res,"",n,n,n);
        return res;
    }

    public void generateParenthesis(List<String> res,String str,int n, int f, int b){
        if(n*2==str.length()){
            res.add(new String(str));
            return;
        }
        if(n==f){
            generateParenthesis(res,str+"(",n,f-1,b);
        }else{
            if(f>0){
                generateParenthesis(res,str+"(",n,f-1,b);
            }
            if(f<b){
                generateParenthesis(res,str+")",n,f,b-1);
            }    
        }
    }
}