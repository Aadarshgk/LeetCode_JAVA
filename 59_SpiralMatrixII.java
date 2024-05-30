class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int iStart=0,jStart=0,iEnd=n-1,jEnd=n-1,count=1,max=n*n;
        while(count<=max){
            for(int j=jStart;j<=jEnd;j++){
                res[iStart][j]=count++;
            }
            iStart++;

            for(int i=iStart;i<=iEnd;i++){
                res[i][jEnd]=count++;
            }
            jEnd--;

            for(int j=jEnd;j>=jStart;j--){
                res[iEnd][j]=count++;
            }
            iEnd--;
            
            for(int i=iEnd;i>=iStart;i--){
                res[i][jStart]=count++;
            }
            jStart++;
        }
        return res;
        
    }
}