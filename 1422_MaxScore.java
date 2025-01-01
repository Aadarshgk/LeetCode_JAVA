class Solution {
    public int maxScore(String s) {
        int len=s.length(),left=0,right=0;
        for(char c: s.toCharArray()){
            if(c=='1') right++;
        }

        int maxVal=0;
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)=='0'){
                left++;
            }else{
                right--;
            }
            maxVal=Math.max(maxVal,right+left);
        }
        return maxVal;
    }
}