class Solution {
    public void setZeroes(int[][] matrix) {
        int i=0,j=0,rows=matrix.length,cols=matrix[0].length,r=0,c=0;
        while(i<rows){
            j=0;
            while(j<cols){
                if(matrix[i][j]==0){
                    if(i==0){
                        r=1;
                    }
                    if(j==0){
                        c=1;
                    }
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
                j++;
            }
            i++;
        }
        i=1;
        j=1;
        while(i<rows){
            j=1;
            while(j<cols){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
                j++;
            }
            i++;
        }

        if(r==1){
            j=0;
            while(j<cols){
                matrix[0][j++]=0;
            }
        }
        if(c==1){
            i=0;
            while(i<rows){
                matrix[i++][0]=0;
            }
        }
    }
}