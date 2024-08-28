class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);

        for(int i=2;i<len;i++){
            if(i>2){
                nums[i]+=Math.max(nums[i-2],nums[i-3]);
            }else{
                nums[i]+=nums[i-2];
            }
        }

        return Math.max(nums[len-1],nums[len-2]);
    }
}