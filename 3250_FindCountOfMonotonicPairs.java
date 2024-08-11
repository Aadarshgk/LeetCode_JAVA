import java.util.Arrays;
class Solution {
    int[][][] dp;
    public int countOfPairs(int[] nums) {
        int len= nums.length;
        dp= new int[len][51][51];
        for(int i=0;i<len;i++){
            for(int j=0;j<51;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return helper(nums,0,0,50);
    }

    public int helper(int[] nums, int i,int start, int end){
        if(i>=nums.length) return 1;

        if(dp[i][start][end]!=-1) return dp[i][start][end];

        int ans=0;
        for(int j=0;j<=nums[i];j++){
            int x=j, y=nums[i]-j;
            if(x>=start && y<=end){
                ans= (ans+helper(nums,i+1,x,y))%1000000007;
            }
        }
        dp[i][start][end]=ans;
        return ans;
    }

}