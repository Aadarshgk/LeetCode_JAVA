import java.util.Arrays;
class Solution {
    int[] dp= new int[100001];
    public int countGoodStrings(int low, int high, int zero, int one) {
        Arrays.fill(dp,-1);
        return helper(low,high,zero,one,0);   
    }

    public int helper(int low, int high, int zero, int one, int pos){
        if(pos>high) return 0;
        if(dp[pos]!=-1) return dp[pos];

        int count=0;
        if(pos>=low) count++;
        count+=helper(low,high,zero,one,pos+zero);
        count+=helper(low,high,zero,one,pos+one);

        dp[pos]=count%1000000007;
        return dp[pos];
    }
}