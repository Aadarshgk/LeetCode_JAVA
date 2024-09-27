class Solution {
    public int jump(int[] nums) {
        int len=nums.length;
        int l=0,r=0,count=0,max=0;
        while(r<len-1){
            for(int i=l;i<=r;i++){
                max=Math.max(i+nums[i],max);
            }
            count++;
            l=r+1;
            r=max;
        }
        return count;
    }
}

//initial soln
// class Solution {
//     public int jump(int[] nums) {
//         int len=nums.length;
//         int[] dp= new int[len];
//         Arrays.fill(dp,Integer.MAX_VALUE);
//         dp[0]=0;
//         for(int i=0;i<len;i++){
//             for(int k=0; k<=nums[i] && i+k<len;k++){
//                 dp[i+k]=Math.min(dp[i]+1,dp[i+k]);
//             }
//         }
//         return dp[len-1];
//     }
// }