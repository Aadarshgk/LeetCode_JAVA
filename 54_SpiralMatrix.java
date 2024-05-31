import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int iStart=0,jStart=0,iEnd=matrix.length-1,jEnd=matrix[0].length-1;
        while(iStart<=iEnd && jStart<=jEnd){
            for(int j=jStart;j<=jEnd;j++){
                res.add(matrix[iStart][j]);
            }
            iStart++;

            for(int i=iStart;i<=iEnd;i++){
                res.add(matrix[i][jEnd]);
            }
            jEnd--;

            if(iStart<=iEnd){
                for(int j=jEnd;j>=jStart;j--){
                   res.add(matrix[iEnd][j]);
                }
            }
            iEnd--;
            
            if(jStart<=jEnd){
                for(int i=iEnd;i>=iStart;i--){
                   res.add(matrix[i][jStart]);
                }
            }
            jStart++;
        }
        return res;
    }
}