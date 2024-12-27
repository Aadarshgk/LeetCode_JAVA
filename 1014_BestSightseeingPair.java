class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int back=values[0];
        int res=Integer.MIN_VALUE;
        int j=1,len=values.length;
        while(j<len){
            int front=values[j]-j;
            res=Math.max(res,front+back);
            back=Math.max(back,values[j]+j);
            j++;
        }

        return res;

    }
}