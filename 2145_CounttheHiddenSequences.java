class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min=0,max=0,cur=0;
        for(int n: differences){
            cur+=n;
            min=Math.min(min,cur);
            max=Math.max(max,cur);
        }

        int count=(int)((upper-lower) - (max-min)+1);
        return count>0? count: 0;
    }
}