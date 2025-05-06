class Solution {
    public boolean isBipartite(int[][] graph) {
        int len=graph.length;
        int[] vis=new int[len];
        Arrays.fill(vis,-1);

        for(int i=0;i<len;i++){
            boolean flag=true;
            if(vis[i]==-1){
                vis[i]=0;
                flag = bfs(graph,vis,i);
            }

            if(!flag) return flag;
        }

        return true;
    }

    public boolean bfs(int[][] graph,int[] vis, int num1){
        Queue<Integer> q=new LinkedList<>();
        q.add(num1);
        while(!q.isEmpty()){
            int num=q.poll();
            // if(graph[num].length==0) return false;
            for(int n: graph[num]){
                if(vis[n]==-1){
                    vis[n]=(vis[num]+1)%2;
                    q.add(n);
                }else if(vis[n]==vis[num]) return false;
            }
        }

        return true;
    }
}