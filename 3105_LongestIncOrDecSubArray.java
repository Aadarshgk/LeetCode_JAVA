class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len=nums.length;
        int i=0,j=0,k=1;
        int prev=nums[0];
        int inc=1,dec=1;
        while(k<len){
            int cur=nums[k];
            if(nums[k]<=prev){
                inc=Math.max(inc,k-i);
                i=k;
            }

            if(nums[k]>=prev){
                dec=Math.max(dec,k-j);
                j=k;
            }

            prev=cur;
            k++;
        }
        dec=Math.max(dec,k-j);
        inc=Math.max(inc,k-i);
        return Math.max(inc,dec);
    }
}