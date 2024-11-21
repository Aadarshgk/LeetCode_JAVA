class Solution {
    int[][] cell;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        cell=new int[m][n];
        for(int[] wall: walls){
            cell[wall[0]][wall[1]]=2;
        }

        for(int[] guard: guards){
            cell[guard[0]][guard[1]]=3;
        }

        for(int[] guard: guards){
            mark(guard[0],guard[1],m,n);
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(cell[i][j]==0){
                    count++;
                }
            }
        }

        return count;

    }

    public void mark(int i,int j,int m,int n){
        for(int k=i-1;k>=0;k--){
            if(cell[k][j]>1)break;
            cell[k][j]=1;
        }

        for(int k=i+1;k<m;k++){
            if(cell[k][j]>1) break;
            cell[k][j]=1;
        }

        for(int k=j-1;k>=0;k--){
            if(cell[i][k]>1) break;
            cell[i][k]=1;
        }

        for(int k=j+1;k<n;k++){
            if(cell[i][k]>1) break;
            cell[i][k]=1;
        }
    }
}