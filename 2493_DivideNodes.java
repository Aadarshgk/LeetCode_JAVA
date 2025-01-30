import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Solution {
    public boolean isBipartite(List<List<Integer>> adj,int n){
        int[] state= new int[n+1];
        Arrays.fill(state,0);

        for(int i=1;i<n+1;i++){
            if(state[i]==0 && !helper(adj,state,i)){
                return false;
            }
        }
        return true;
    }

    public boolean helper(List<List<Integer>> adj,int[] state, int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        state[start]=1;
        while(!q.isEmpty()){
            int num=q.poll();
            for(int nbr: adj.get(num)){
                if(state[nbr]==0){
                    state[nbr]=-1*state[num];
                    q.add(nbr);
                }else if(state[nbr]==state[num]){
                    return false;
                }
            }
        }
        return true;
    }

    public int countLevels(List<List<Integer>> adj, int i,int n){
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        q.add(i);
        vis[i]=true;
        int level=0;
        while(!q.isEmpty()){
            int len=q.size();
            for(int j=0;j<len;j++){
                int num=q.poll();
                for(int nbr: adj.get(num)){
                    if(!vis[nbr]){
                        q.add(nbr);
                        vis[nbr]=true;
                    }
                }
            }
            level++;
        }
        return level;
    }

    public int maxLevel(int[] maxDist, List<List<Integer>> adj, boolean[] vis, int source){
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        vis[source]=true;

        int max=-1;
        while(!q.isEmpty()){
            int cur=q.poll();
            max=Math.max(max,maxDist[cur]);
            for(int nbr: adj.get(cur)){
                if(!vis[nbr]){
                    q.add(nbr);
                    vis[nbr]=true;
                }
            }
        }
        return max;
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!isBipartite(adj,n)) return -1;

        int[] maxDist= new int[n+1];
        for(int i=1;i<n+1;i++){
            maxDist[i]=countLevels(adj,i,n);
        }

        boolean[] vis=new boolean[n+1];
        int total=0;
        for(int i=1;i<n+1;i++){
            if(!vis[i]){
                total+=maxLevel(maxDist,adj,vis,i);
            }
        }

        return total;


    }
}