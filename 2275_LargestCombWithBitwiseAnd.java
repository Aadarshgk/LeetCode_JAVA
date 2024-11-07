class Solution {
    public int largestCombination(int[] candidates) {
        int count=0,max=0;
        for(int i=0;i<24;i++){
            count=0;
            for(int n: candidates){
                if((n&1<<i)!=0){
                    count++;
                }
            }
            max=Math.max(count,max);
        }
        return max;
    }
}