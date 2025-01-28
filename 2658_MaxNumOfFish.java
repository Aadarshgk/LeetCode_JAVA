import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution {
    public int findMaxFish(int[][] grid) {
        int max=Integer.MIN_VALUE;
        int row=grid.length,col=grid[0].length;
        boolean[][] vis=new boolean[row][col];
        for(boolean[] ar: vis){
            Arrays.fill(ar,false);
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    max=Math.max(max,bfs(grid,vis,i,j,row,col));
                }
            }
        }   
        return (max<0)?0:max;
    }

    public int bfs(int[][] grid, boolean[][] vis,int i,int j,int row,int col){
        int[] dir={-1,0,1,0,-1};
        int sum=0;
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j]=true;
        while(!q.isEmpty()){
            int len=q.size();
            for(int k=0;k<len;k++){
                int[] ar= q.poll();
                int x=ar[0];
                int y=ar[1];
                sum+=grid[x][y];
                for(int l=0;l<4;l++){
                    int nx=x+dir[l];
                    int ny=y+dir[l+1];
                    if(nx>=0 && nx<row && ny>=0 && ny<col && grid[nx][ny]>0 && !vis[nx][ny] ){
                        q.add(new int[]{nx,ny});
                        vis[nx][ny]=true;
                    }
                }
            }
        }

        return sum;
    }


}