class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,len=nums.length,ans=Integer.MAX_VALUE;
        int sum=0;
        while(j<len){
            sum+=nums[j];
            while(sum>=target){
                ans=Math.min(ans,j-i+1);
                sum-=nums[i++];
            }

            j++;
        }

        return (ans==Integer.MAX_VALUE)?0:ans;
    }
}