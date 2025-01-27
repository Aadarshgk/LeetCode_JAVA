import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public List<Boolean> checkIfPrerequisite(int num, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<num;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            adj.get(pre[0]).add(pre[1]);
        }


        List<Boolean> res= new ArrayList<>();
        for(int[] query: queries){
            res.add(bfs(adj,query[0],query[1]));
        }

        return res;
    }

    public boolean bfs(List<List<Integer>> adj, int src, int dest){
        boolean[] vis= new boolean[adj.size()];
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            int len= q.size();
            for(int i=0;i<len;i++){
                int n=q.poll();
                if(n==dest) return true;
                for(int nbr: adj.get(n)){
                    if(!vis[nbr]){
                        q.add(nbr);
                        vis[nbr]=true;
                    }
                }
            }
        }
        return false;
    }
}