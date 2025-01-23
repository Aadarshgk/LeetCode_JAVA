import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int countServers(int[][] grid) {
        int row=grid.length,col=grid[0].length;
        boolean[][] vis = new boolean[row][col];
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    vis[i][j]=true;
                    count+=connect(grid,vis,i,j,row,col);
                }
            }
        }

        return count;

    }

    public int connect(int[][] grid, boolean[][] vis,int i,int j,int row,int col){
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i,j});
        int res=0;
        while(!q.isEmpty()){
            int len=q.size();
            res+=len;
            for(int k=0;k<len;k++){
                int[] ar= q.poll();
                int x= ar[0]; 
                int y= ar[1]; 
                
                for(int nx=0;nx<row;nx++){
                    if(grid[nx][y]==1 && !vis[nx][y]){
                        vis[nx][y]=true;
                        q.add(new int[]{nx,y});
                    }
                }

                for(int ny=0;ny<col;ny++){
                    if(grid[x][ny]==1 && !vis[x][ny]){
                        vis[x][ny]=true;
                        q.add(new int[]{x,ny});
                    }
                }
            }
        }

        return (res==1)?0:res;
    }
}