import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
class Solution {
    int count=0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        boolean[] vis= new boolean[n];
        Arrays.fill(vis,false);
        for(int[] ar: edges){
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        dfs(0,adj,vis,values,k);
        return count;
    }

    public int dfs(int i,List<List<Integer>> adj, boolean[] vis, int[] values,int k){
        vis[i]=true;
        int sum=0;
        for(int n: adj.get(i)){
            if(!vis[n]){
                sum+=dfs(n,adj,vis,values,k);
            }
        }
        sum+=values[i];
        sum%=k;
        if(sum==0) count++;
        return sum;
    }
}