import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int i,j,count=0,rows=mat.length,cols=mat[0].length;
        List<Integer> res= new ArrayList<>();
        while(count<cols){
            j=cols-count-1;
            i=0;
            while(j<cols && i<rows){
                res.add(mat[i][j]);
                i++;j++;
            }
            Collections.sort(res);
            j=cols-count-1;
            i=0;
            while(j<cols && i<rows){
                mat[i][j]=res.remove(0);
                i++;j++;
            }
            count++;
        }
        count=1;
        while(count<rows){
            i=count;
            j=0;
            while(j<cols && i<rows){
                res.add(mat[i][j]);
                i++;j++;
            }
            Collections.sort(res);
            i=count;
            j=0;
            while(j<cols && i<rows){
                mat[i][j]=res.remove(0);
                i++;j++;
            }
            count++;
        }        
        return mat;
    }
}