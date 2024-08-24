class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = len; j > i; j--) {
                nums[j] = (nums[j] + nums[j - 1]) % 10;
            }
        }
        return nums[len];
    }
}