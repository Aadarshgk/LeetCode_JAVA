import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int row=moveTime.length,col=moveTime[0].length;
        int[][] dist=new int[row][col];
        boolean[][] vis = new boolean[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        int[] dir={1,0,-1,0,1};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] ar=pq.poll();
            int x=ar[0];
            int y=ar[1];
            int d=ar[2];
            if(vis[x][y]) continue;
            vis[x][y]=true;
            for(int i=0;i<4;i++){
                int nx=x+dir[i];
                int ny=y+dir[i+1];

                if(nx<0 || nx>=row || ny<0 || ny>=col) continue;
                int dis=Math.max(d,moveTime[nx][ny])+1;

                if(dist[nx][ny]>dis){
                    dist[nx][ny]=dis;
                    pq.offer(new int[]{nx,ny,dis});
                }
            }
        }

        return dist[row-1][col-1];
    }
}