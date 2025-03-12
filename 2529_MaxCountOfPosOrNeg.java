class Solution {
    public int maximumCount(int[] nums) {
        int len=nums.length,i=0,neg=0;
        while(i<len){
            if(nums[i]<0){
                neg++;
            }else if(nums[i]>0){
                break;
            }
            i++;
        }
        return Math.max(neg,len-i);
    }
}