class Solution {
    public boolean canJump(int[] nums){
        int len=nums.length;
        if(len<=1) return true;
        int sum=nums[0],i=1;
        while(sum>0){
            sum=Math.max(sum-1,nums[i]);
            if(sum+i >=len-1) return true;
            i++;
        }
        return false;
    }
}