class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i=0,j,n=nums.length;
        while(i<n-1){
            j=i+1;
            while(j<n){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
                j++;
            }
            i++;
        }
        return new int[]{};
    }
}