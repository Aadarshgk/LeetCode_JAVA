class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length,temp;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=(n-1)/2;j++){
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
}