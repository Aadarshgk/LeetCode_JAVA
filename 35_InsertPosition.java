class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < target) {
                i++;
            } else {
                return i;
            }
        }
        return i;
    }

//Binary search method
    public int searchInsert2(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        } else {
            return mid;
        }

    }
}