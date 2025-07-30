class Solution {
    public int longestSubarray(int[] nums) {
        int len=nums.length,max=Integer.MIN_VALUE;
        for(int n: nums){
            max=Math.max(n,max);
        }

        int count=0,res=0;
        for(int i=0;i<len;i++){
            if(nums[i]==max){
                count++;
                res=Math.max(count,res);
            }else{
                count=0;
            }
        }

        return res;
        
    }
}