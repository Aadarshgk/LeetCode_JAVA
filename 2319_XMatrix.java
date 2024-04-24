class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int i=0,j=0,row=grid.length,col=grid[0].length;
        while(i<row){
            j=0;
            while(j<col){
                int n= grid[i][j];
                if(i==j || j==col-i-1){
                    if(grid[i][j]==0){
                        return false;
                    }
                }else if(grid[i][j]!=0){
                    return false;
                }
                
                j++;
            }
            i++;
        }
        return true;
    }
}