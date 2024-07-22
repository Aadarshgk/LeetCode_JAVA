class Solution {
    public int subsetXORSum(int[] nums) {
        int sum=0;
        sum=subset(nums,0,sum);
        return sum;
    }

    public int subset(int[] nums,int i, int total){
        if(i==nums.length) return total;

        return subset(nums,i+1, total^nums[i]) + subset(nums,i+1,total);
    }
}