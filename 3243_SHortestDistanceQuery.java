import java.util.List;
import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ArrayList;
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            adj.get(i).add(i+1);
        }   

        int len=queries.length;
        int[] res= new int[len];

        for(int i=0;i<len;i++){
            adj.get(queries[i][0]).add(queries[i][1]);
            res[i]=bfs(adj);
        }
        return res;
    }

    public int bfs(List<List<Integer>> adj){
        int len=adj.size();
        boolean[] vis= new boolean[len];
        Arrays.fill(vis,false);

        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        vis[0]=true;

        int step=0;
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                int ele=q.poll();
                if(ele==len-1) return step;
                for(int num:adj.get(ele)){
                    if(!vis[num]){
                        vis[num]=true;
                        q.add(num);
                    }
                }
            }
            step++;
        }

        return 1;
    }
}