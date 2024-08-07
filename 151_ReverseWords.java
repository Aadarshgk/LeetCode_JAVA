class Solution {
    public String reverseWords(String s) {
        String[] ar= s.split(" ");
        String res="";

        for(int i=ar.length-1;i>=0;i--){
            if(ar[i]!=""){
                if(i!=ar.length-1){
                    res+=" ";
                }
                res+=ar[i];
            }
        }        
        return res;
    }
}