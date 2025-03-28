import java.util.SortedSet;
import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.HashMap;
class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int row=grid.length,col=grid[0].length;
        boolean[][] vis=new boolean[row][col];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        SortedSet<Integer> set= new TreeSet<>();
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int n: queries){
            set.add(n);
        }
        int[] dir=new int[]{1,0,-1,0,1};

        pq.add(new int[]{grid[0][0],0,0});
        vis[0][0]=true;
        int count=0;
        for(int n: set){
            while(!pq.isEmpty()){
                int[] ar=pq.poll();
                int r=ar[1];
                int c=ar[2];
                if(ar[0]>=n){
                    pq.add(ar);
                    break;
                }
                count++;
                for(int i=0;i<4;i++){
                    int x=r+dir[i];
                    int y=c+dir[i+1];
                    if(x>=0 && x<row && y>=0 && y<col && !vis[x][y]){
                        pq.add(new int[]{grid[x][y],x,y});
                        vis[x][y]=true;
                    }
                }
            }
            map.put(n,count);
        }

        int len=queries.length;
        int[] res=new int[len];
        for(int i=0;i<len;i++){
            res[i]=map.get(queries[i]);
        }

        return res;
        
    }
}