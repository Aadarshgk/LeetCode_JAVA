class Solution {
    public boolean checkPossibility(int[] nums) {
        int count=0,min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                if(++count>1){
                    return false;
                }
                if(i>=2 && nums[i-2]>nums[i]) continue;
            }
            min=nums[i];                             
        }
        return true;
    }
}