class Solution {
    public int maximumCandies(int[] candies, long k) {
        int l=1,r=0;
        for(int n:candies){
            if(n>r){
                r=n;
            }
        }
        
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            long sum=0;
            for(int n: candies){
                sum+=(n/mid);
            }
            if(sum>=k){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
}