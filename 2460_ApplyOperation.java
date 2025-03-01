class Solution {
    public int[] applyOperations(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]*=2;
                nums[i+1]=0;
            }
        }

        int i=-1;
        for(int j=0;j<len;j++){
            if(nums[j]!=0){
                nums[++i]=nums[j];
            }
        }

        while(i<len-1){
            nums[++i]=0;
        }
        return nums;
    }
}