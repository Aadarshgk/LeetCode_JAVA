class Solution {
    public int countSquares(int[][] matrix) {
        int row=matrix.length,col=matrix[0].length;
        int[][] dp=new int[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                    }
                    count+=dp[i][j];
                }
            }
        }

        return count;
    }
}