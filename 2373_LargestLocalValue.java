class Solution {
    public int maxElement(int[][] ar,int row,int col){
        int i=0,j=0,max=ar[row][col];
        while(i<=2){
            j=0;
            while(j<=2){
                max=Math.max(max,ar[row+i][col+j]);
                j++;
            }
            i++;
        }
        return max;
    }
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;;
        int i=0,j,count=0;
        int[][] res= new int[n-2][n-2]; 
        while(i<n-2){
            j=0;
            while(j<n-2){
                res[i][j]=maxElement(grid,i,j);
                j++;
            }
            i++;
        }       
        return res; 
    }
}