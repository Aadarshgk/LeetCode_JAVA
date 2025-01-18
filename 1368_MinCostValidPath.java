import java.util.PriorityQueue;
import java.util.Arrays;
class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });

        int row=grid.length,col=grid[0].length;
        boolean[][] vis=new boolean[row][col];
        for(boolean[] b: vis){
            Arrays.fill(b,false);
        }

        int[] dx= {0,0,1,-1};
        int[] dy= {1,-1,0,0};

        pq.add(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] ar= pq.poll();
            int cost=ar[0];
            int x=ar[1];
            int y=ar[2];
            if(x==row-1 && y==col-1) return cost;
            if(vis[x][y]) continue;
            vis[x][y]=true;
            
            for(int i=0;i<4;i++){
                int newX= x+dx[i];
                int newY= y+dy[i];
                if(newX<row && newX>=0 && newY<col && newY>=0 && !vis[newX][newY]){
                    int newC= cost;
                    if((i+1)!=grid[x][y]){
                        newC++;
                    }
                    pq.add(new int[]{newC,newX,newY});
                }
            }

        }
        return 0;
    }
}