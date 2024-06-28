//Better soln
class Solution {
    public int numIslands(char[][] grid) {
        int row= grid.length, col= grid[0].length,count=0;;
        boolean[][] vis= new boolean[row][col];

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1' && vis[i][j]!=true){
                    bfs(grid,i,j,vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i,int j, boolean[][] vis){
        if(i>=grid.length|| i<0 || j>=grid[0].length || j<0 || grid[i][j]=='0' || vis[i][j]==true) return;
        vis[i][j]=true;

        bfs(grid,i-1,j,vis);
        bfs(grid,i+1,j,vis);
        bfs(grid,i,j-1,vis);
        bfs(grid,i,j+1,vis);
    }
}


// class Solution {
//     class Pair{
//         int x;
//         int y;

//         public Pair(int x,int y){
//             this.x=x;
//             this.y=y;
//         }
//     }

//     Queue<Pair> q= new LinkedList<>();

//     public int numIslands(char[][] grid) {
//         int i=0,j=0, row=grid.length,col=grid[0].length,count=0;
//         boolean[][] vis= new boolean[row][col];
        
//         for(i=0;i<row;i++){
//             for(j=0;j<col;j++){
//                 if(grid[i][j]=='1'){
//                     Pair p=new Pair(i,j);
//                     if(vis[i][j]!=true){
//                         bfs(grid,p,row,col,vis);
//                         count++;
//                     }
//                 }
//             }
//         }    
//         return count;
//     }

//     public void bfs(char[][] grid, Pair p,int row,int col,boolean[][] vis){
//         q.add(p);
//         vis[p.x][p.y]=true;
//         while(!q.isEmpty()){
//             Pair temp=q.remove();
//             int i=temp.x;
//             int j=temp.y;

//             if(i>0 && grid[i-1][j]=='1' && vis[i-1][j]==false){
//                 q.add(new Pair(i-1,j));
//                 vis[i-1][j]=true;
//             }
//             if(i<row-1 && grid[i+1][j]=='1' && vis[i+1][j]==false){
//                 q.add(new Pair(i+1,j));
//                 vis[i+1][j]=true;
//             }
//             if(j>0 && grid[i][j-1]=='1' && vis[i][j-1]==false){
//                 q.add(new Pair(i,j-1));
//                 vis[i][j-1]=true;
//             }
//             if(j<col-1 && grid[i][j+1]=='1' && vis[i][j+1]==false){
//                 q.add(new Pair(i,j+1));
//                 vis[i][j+1]=true;
//             }
//         }

//     }
// }