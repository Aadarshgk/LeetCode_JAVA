class Solution {
    public boolean canSortArray(int[] nums) {
        int len=nums.length;
        for(int i=0;i<len-1;i++){
            for(int j=0;j<len-i-1;j++){
                if(nums[j]>nums[j+1]){
                    if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])){
                        int temp=nums[j+1];
                            nums[j+1]=nums[j];
                            nums[j]=temp;
                    }else {
                        return false;
                    } 
                }
            }
        }
        return true;
    }
}
