class Solution {
    public long gridGame(int[][] grid) {
        int col=grid[0].length;
        long topSum=0;
        long botSum=0;
        for(int i=0;i<col;i++){
            topSum+=grid[0][i];
        }

        long res=Long.MAX_VALUE;
        for(int i=0;i<col;i++){
            topSum-=grid[0][i];
            res=Math.min(res,Math.max(topSum,botSum));
            botSum+=grid[1][i];
        }

        return res;
    }
}