import java.util.Arrays;
class Solution {
    public String addSpaces(String s, int[] spaces) {
        Arrays.sort(spaces);
        StringBuilder res= new StringBuilder();
        int i=0;
        for(int n: spaces){
            while(i<=n){
                if(i==n){
                    res.append(" ");
                }
                res.append(s.charAt(i));
                i++;
            }
        }

        while(i<s.length()){
            res.append(s.charAt(i++));
        }
        return res.toString();
    }
}