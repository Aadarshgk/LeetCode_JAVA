class Solution {
    public int waysToSplitArray(int[] nums) {
        int len=nums.length;
        long total=0,sum=0;
        for(int n:nums){
            total+=n;
        }

        int count=0;
        for(int i=0;i<len-1;i++){
            sum+=nums[i];
            if(sum>=total-sum) count++;
        }
        return count;
    }
}