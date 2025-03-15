class Solution {
    private boolean canAssign(int maxVal, int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxVal) {
                count++;
                i++; 
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int low = Arrays.stream(nums).min().getAsInt();
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAssign(mid, nums, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}