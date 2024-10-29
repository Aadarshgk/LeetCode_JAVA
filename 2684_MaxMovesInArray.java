import java.util.Arrays;
class Solution {
    public int maxMoves(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dp= new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dp[i],0);
        }
        int count=0;
        for(int i=0;i<row;i++){
            int val=grid[i][0];
            count=Math.max(count, dfs(grid,val,i-1,1,dp));
            count=Math.max(count, dfs(grid,val,i,1,dp));
            count=Math.max(count, dfs(grid,val,i+1,1,dp));
        }

        return count;
    }

    public int dfs(int[][] grid,int val, int i,int j ,int[][] dp){
        if(i==grid.length || j==grid[0].length|| i<0) return 0;

        if(dp[i][j]!=0) return dp[i][j];

        if(grid[i][j]<=val){
            dp[i][j]=0;
            return dp[i][j];
        } 

        int val1=grid[i][j];
        int top=dfs(grid,val1,i-1,j+1,dp);
        int mid=dfs(grid,val1,i,j+1,dp);
        int bottom=dfs(grid,val1,i+1,j+1,dp);
        dp[i][j]= 1 + Math.max(top,Math.max(mid,bottom));
        return dp[i][j];
    }
}