class Solution {
    boolean flag=false;
    int[] dir={1,0,-1,0,1};
    public boolean exist(char[][] board, String word) {
        int row=board.length,col=board[0].length;
        boolean[][] vis=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0)!=board[i][j]) continue;
                vis[i][j]=true;
                helper(board,word,1,i,j,vis);
                vis[i][j]=false;
            }

            if(flag) return flag;
        }
        return flag;
    }

    public void helper(char[][] board, String word,int c,int i,int j,boolean[][] vis){
        if(c==word.length()){
            flag=true;
            return;
        }

        for(int k=0;k<4;k++){
            int nx=i+dir[k];
            int ny=j+dir[k+1];

            if(nx<0 || nx>=board.length || ny<0 || ny>=board[0].length) continue;
            if(vis[nx][ny] || board[nx][ny]!=word.charAt(c)) continue;
            vis[nx][ny]=true;
            helper(board,word,c+1,nx,ny,vis);
            vis[nx][ny]=false;
        }
    }
    
}