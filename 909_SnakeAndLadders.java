import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int max=n*n;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        boolean[] vis=new boolean[max+1];
        Arrays.fill(vis,false);
        vis[1]=true;
        int level=0;

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();

                if(cur==max) return level;
                int min=Math.min(cur+6,max);
                for(int j=cur+1;j<=min ;j++){
                    int dest=j;
                    int r=(j-1)/n;
                    int c=(j-1)%n;
                    if(r%2==1){
                        c=n-1-c;
                    }

                    r=n-1-r;

                    if(board[r][c]!=-1){
                        dest=board[r][c];
                    }

                    if(!vis[dest]){
                        vis[dest]=true;
                        q.add(dest);
                    }
                }
            }

            level++;
        }

        return -1;
    }
}