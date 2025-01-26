import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
class Solution {
    int kahnsTopo(int[] adj, int[] indegree, boolean[] vis, int source){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);

        int lastNode=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            vis[cur]=true;
            lastNode=cur;

            int nbr= adj[cur];
            indegree[nbr]--;
            if(indegree[nbr]==0 && !vis[nbr]){
                q.add(nbr);
            }
        }
        return adj[lastNode];

    }

    public int maxDepth(List<List<Integer>> revAdj,boolean[] orgVis,int n,int source,int avoid){
        boolean[] vis= new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        vis[source]=true;
        vis[avoid]=true;

        int level=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                orgVis[cur]=true;

                for(int nbr: revAdj.get(cur)){
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

    public int bfs(int[] adj,boolean[] vis,int source){
        Queue<Integer> q= new LinkedList<>();
        q.add(source);
        vis[source]=true;
        int count=0;
        while(!q.isEmpty()){
            int cur=q.poll();

            if(!vis[adj[cur]]){
                vis[adj[cur]]=true;
                q.add(adj[cur]);
            }
            count++;
        }

        return count;
    }


    
    public int maximumInvitations(int[] adj) {
        int len=adj.length;
        List<List<Integer>> revAdj=new ArrayList<>();
        for(int i=0;i<len;i++){
            revAdj.add(new ArrayList<>());
        }
        int[] indegree= new int[len];

        for(int i=0;i<len;i++){
            revAdj.get(adj[i]).add(i);
            indegree[adj[i]]++;
        }

        int totalTail=0;
        boolean[] vis= new boolean[len];
        for(int i=0;i<len;i++){
            if(indegree[i]==0 && !vis[i]){
                int node=kahnsTopo(adj,indegree,vis,i);
                if(adj[adj[node]]==node){
                    int tailLen= maxDepth(revAdj,vis,len,node,adj[node])-1;
                    totalTail+=tailLen;
                    vis[node]=false;
                }
            }
        }

        int twoCycles=0;
        int maxCycles=0;
        for(int i=0;i<len;i++){
            if(!vis[i]){
                int cycleSize=bfs(adj,vis,i);
                if(cycleSize==2){
                    twoCycles++;
                }else{
                    maxCycles=Math.max(maxCycles,cycleSize);
                }
            }
        }

        int cycleSize2=totalTail+2*twoCycles;
        return Math.max(cycleSize2,maxCycles);
    }
} 