class Solution {
    public int minOperations(int[] nums) {
        int len=nums.length,count=0;
        for(int i=0;i<len-2;i++){
            if(nums[i]==0){
                nums[i]=1;
                nums[i+1]=1-nums[i+1];
                nums[i+2]=1-nums[i+2];
                count++;
            }
        }
        
        if((nums[len-1]==nums[len-2]) && (nums[len-1]==1)){
            return count;
        }
        return -1;
    }
}