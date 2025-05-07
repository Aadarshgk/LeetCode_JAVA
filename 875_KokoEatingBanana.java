class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int n: piles){
            max=(max<n)?n:max;
        }

        int l=1,r=max;
        while(l<=r){
            int mid=l+(r-l)/2;
            int total=helper(piles,mid);
            if(total<=h){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        return l;
    }

    public int helper(int[] ar,int num){
        int total=0;
        for(int n: ar){
            total+=Math.ceil((double)n/num);
        }
        return total;
    }
}