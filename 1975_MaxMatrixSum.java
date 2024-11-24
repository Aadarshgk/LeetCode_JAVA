class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long res=0;
        int count=0,min=Integer.MAX_VALUE;
        for(int[] row: matrix){
            for(int n:row){
                if(n<0) count++;
                n=Math.abs(n);
                res+=n;
                min=Math.min(min,n);
            }
        }

        if(count%2==0) return res;
        return res-(2*min);
    }
}