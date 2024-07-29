class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len= cost.length;
        int[] amt= new int[len+1];
        amt[0]=amt[1]=0;
        int i=2;
        while(i<=len){
            amt[i]=Math.min(amt[i-1]+cost[i-1],amt[i-2]+cost[i-2]);
            i++;
        }
        return amt[len];
    }
}