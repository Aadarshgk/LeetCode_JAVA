class Solution {
    public void moveZeroes(int[] nums) {
        int k=0,len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]!=0){
                nums[k++]=nums[i];
            }
        }

        while(k<len){
            nums[k++]=0;
        }
    }
}