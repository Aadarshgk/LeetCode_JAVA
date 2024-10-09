class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[] dp=new int[col];
        dp[col-1]=1;
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(grid[i][j]==1){
                    dp[j]=0;
                }else if(j<col-1){
                    dp[j]+=dp[j+1];
                }
            }
        }

        return dp[0];
    }
}