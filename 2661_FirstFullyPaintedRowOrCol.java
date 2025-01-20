import java.util.HashMap;
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int row=mat.length,col=mat[0].length;
        int[][] mem= new int[row*col + 1][2];
        HashMap<Integer,Integer> rowMap=new HashMap<>();   
        HashMap<Integer,Integer> colMap=new HashMap<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                mem[mat[i][j]]=new int[]{i,j};
            }
        }   

        for(int i=0;i<arr.length;i++){
            int n=arr[i];
            
            int r=mem[n][0];
            rowMap.put(r,rowMap.getOrDefault(r,0)+1);
            if(rowMap.get(r)==col) return i;
            
            int c=mem[n][1];
            colMap.put(c,colMap.getOrDefault(c,0)+1);
            if(colMap.get(c)==row) return i;
        }

        return -1;
    }
}