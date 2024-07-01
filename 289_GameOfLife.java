class Solution {
    public void gameOfLife(int[][] board) {
        int row=board.length,col= board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int n=check(board,i,j,row,col);
                if(board[i][j]==1){
                    if(n<2 || n>3){
                        board[i][j]=2;
                    }
                }else{
                    if(n==3){
                        board[i][j]=3;
                    }
                }
            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]%=2;
            }
        }
    }

    public int check(int[][] board,int r,int c,int row,int col){
        int count=0;
        for(int i=r-1;i<r+2;i++){
            for(int j=c-1;j<c+2;j++){
                if(i<0 || i>=row || j<0 || j>=col|| (i==r && j==c)){
                    continue;
                }
                if(board[i][j]==1 || board[i][j]==2){
                    count++;
                } 
            }
        }
        return count;
    }
}