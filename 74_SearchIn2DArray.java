class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,low,high,mid,row=matrix.length-1,col=matrix[i].length-1;
        while(i<=row){
            if(target>=matrix[i][0] && target<=matrix[i][col]){
                low=0;
                high=col;
                while(low<=high){
                    mid= low + (high-low)/2;
                    if(matrix[i][mid]==target){
                        return true;
                    }else if(matrix[i][mid]>target){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
            }
            i++;
        }
        return false;
    }
}