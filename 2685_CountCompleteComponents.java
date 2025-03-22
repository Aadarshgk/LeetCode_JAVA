import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }        

        int[] vis=new int[n];
        int count=0;

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                count++;
                dfs(adj,i,vis,count);
            }
        }

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(vis[i] == vis[j] && !adj.get(i).contains(j)){
                    set.add(vis[i]);
                }
            }
        }

        return count-set.size();

    }

    public void dfs(List<List<Integer>> adj, int v,int[] vis,int count){
        vis[v]=count;

        for(int n: adj.get(v)){
            if(vis[n]==0){
                dfs(adj,n,vis,count);
            }
        }
    }
}