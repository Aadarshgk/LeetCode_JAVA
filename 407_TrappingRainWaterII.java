import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int row=heightMap.length;
        int col=heightMap[0].length;
        if(row<3 || col<3) return 0;
        boolean[][] vis= new boolean[row][col];
        for(boolean[] b: vis){
            Arrays.fill(b,false);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]) return a[0]-b[0];
            else if(a[1]!=b[1]) return a[1]-b[1];
            return a[2]-b[2];
        });
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==row-1 || j==col-1 || j==0){
                    pq.add(new int[]{heightMap[i][j],i,j});
                    vis[i][j]=true;
                }
            }
        }

        int res=0,level=0;
        int[] dx= {1,-1,0,0};
        int[] dy={0,0,-1,1};
        while(!pq.isEmpty()){
            int[] ar= pq.poll();
            int ht=ar[0];
            int r=ar[1];
            int c=ar[2];

            level=Math.max(level,ht);

            for(int i=0;i<4;i++){
                int nr= r+dx[i];
                int nc= c+dy[i];

                if(nr>=0 && nr<row && nc>=0 && nc<col && !vis[nr][nc]){
                    vis[nr][nc]=true;   
                    int nh=heightMap[nr][nc];

                    if(nh<level){
                        res+=level-nh;
                    }

                    pq.add(new int[]{nh,nr,nc});
                }
            }
            

        }


        return res;

    }
}