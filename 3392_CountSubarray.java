class Solution {
    public int countSubarrays(int[] nums) {
        int len=nums.length,res=0;
        for(int i=0;i<len-2;i++){
            if((nums[i]+nums[i+2])*2== nums[i+1]){
                res++;
            }
        }

        return res;
    }
}