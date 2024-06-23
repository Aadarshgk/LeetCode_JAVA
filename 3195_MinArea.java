class Solution {
    public int minimumArea(int[][] grid) {
        int j=col(grid);
        int i=row(grid);
        return i*j;
    }
    
    public int col(int[][] grid){
        int jMin,jMax,flag=0;
        for(jMin=0;jMin<grid[0].length;jMin++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][jMin]==1){
                    flag=1;
                }
            }
            if(flag==1) break;
        }
        flag=0;
        for(jMax=grid[0].length-1;jMax>jMin;jMax--){
            for(int i=0;i<grid.length;i++){
                if(grid[i][jMax]==1){
                    flag=1;
                }
            }
            if(flag==1) break;
        }
        
        return jMax-jMin+1;
    }
    
    public int row(int[][] grid){
        int iMin,iMax,flag=0;
        for(iMin=0;iMin<grid.length;iMin++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[iMin][j]==1){
                    flag=1;
                }
            }
            if(flag==1) break;
        }
        flag=0;
        for(iMax=grid.length-1;iMax>iMin;iMax--){
            for(int j=0;j<grid[0].length;j++){
                if(grid[iMax][j]==1){
                    flag=1;
                }
            }
            if(flag==1) break;
        }
        
        return iMax-iMin+1;        
    }
}