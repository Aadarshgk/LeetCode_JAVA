import java.util.Arrays;
class Solution {
    public long maxScore(int[] a, int[] b) {
        long[][] dp=new long[4][b.length];
        for(int i=0;i<4;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(a,b,0,0,dp);
    }

    public long solve(int[] a, int[] b, int i, int j, long[][] dp){
        if(i==4) return 0;
        if(j>=b.length) return (long)-1e9;

        if(dp[i][j]!=-1) return dp[i][j];

        long x =(long) a[i]*b[j] + solve(a,b,i+1,j+1,dp);
        long y= solve(a,b,i,j+1,dp);

        if(x>y){
            dp[i][j]=x;
        }else{
            dp[i][j]=y;
        }

        return dp[i][j];

    }
} 
