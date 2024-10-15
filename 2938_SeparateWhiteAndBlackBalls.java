class Solution {
    public long minimumSteps(String s) {
        int len=s.length();
        int i=0,j=0;
        long swaps=0;
        for(i=0;i<len;i++){
            if(s.charAt(i)=='0'){
                swaps+=i-j;
                j++;
            }
        }   
        return swaps;
    }
}