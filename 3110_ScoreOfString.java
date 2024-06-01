class Solution {
    public int scoreOfString(String s) {
        int score=0,len=s.length(),i=0;
        while(i<len-1){
            score+=Math.abs(s.charAt(i)-s.charAt(++i));
        }
        return score;
    }
}