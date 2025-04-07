//DP Tabulation
// class Solution {
//     public boolean canPartition(int[] nums) {
//         int sum=0,len=nums.length;
//         for(int i=0;i<len;i++){
//             sum+=nums[i];
//         }

//         if(sum%2!=0) return false;

//         int target=sum/2;
//         boolean[][] dp=new boolean[len][target+1];
//         dp[0][0]=true;
//         for(int i=1;i<len;i++){
//             for(int j=0;j<=target;j++){
//                 if(j==0){
//                     dp[i][j]=true;
//                     continue;
//                 }
//                 dp[i][j] = dp[i][j] || dp[i-1][j];
//                 if(nums[i]<=j){
//                     dp[i][j]  = dp[i][j] || dp[i-1][j-nums[i]];
//                 }
//             }
//         }

//         return dp[len-1][target];
//     }
// }

//DP SPACE OPTIMIZATION
import java.util.Arrays;
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n: nums){
            sum+=n;
        }

        if(sum%2!=0) return false;

        return helper(nums,sum/2);
    }

    public boolean helper(int[] nums,int target){
        boolean[] dp= new boolean[target+1];
        Arrays.fill(dp,false);
        dp[0]=true;

        int len=nums.length;
        for(int i=0;i<len;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]= dp[j] || dp[j-nums[i]];
            }
        }

        return dp[target];
    }
}