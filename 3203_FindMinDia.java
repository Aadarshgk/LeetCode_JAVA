import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adj1= new ArrayList<>();
        List<List<Integer>> adj2= new ArrayList<>();
        int n=edges1.length+1;
        int m=edges2.length+1;

        for(int i=0;i<n;i++){
            adj1.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj2.add(new ArrayList<>());
        }

        for(int[] ar: edges1){
            adj1.get(ar[0]).add(ar[1]);
            adj1.get(ar[1]).add(ar[0]);
        }
        
        for(int[] ar: edges2){
            adj2.get(ar[0]).add(ar[1]);
            adj2.get(ar[1]).add(ar[0]);
        }

        int dia1=bfs(adj1);
        int dia2=bfs(adj2);
        int dia3=((dia1+1)/2) + ((dia2+1)/2);
        return Math.max(Math.max(dia1,dia2),dia3+1);

    }

    public int bfs(List<List<Integer>> adj){
        int len=adj.size();
        boolean[] vis= new boolean[len];
        Arrays.fill(vis,false);
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        int last=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                last=q.poll();
                vis[last]=true;
                for(int num: adj.get(last)){
                    if(!vis[num]){
                        q.add(num);
                    }
                }
            }
        }

        Arrays.fill(vis,false);
        int count=0;
        q.add(last);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int n=q.poll();
                vis[n]=true;
                for(int num: adj.get(n)){
                    if(!vis[num]){
                        q.add(num);
                    }
                }
            }
            count++;
        }

        return count-1;

    }
}