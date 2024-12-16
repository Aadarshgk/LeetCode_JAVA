class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while(k>0){
            int x=0;
            for(int i=1;i<nums.length;i++){
                if(nums[i]<nums[x]){
                    x=i;
                }
            }

            nums[x]*=multiplier;
            k--;
        }   

        return nums;
    }
}