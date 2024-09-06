class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return count;
    }

    public void divide(int[] nums, int low, int high) {

        if (low >= high)
            return;
        int mid = low + (high - low) / 2;
        divide(nums, low, mid);
        divide(nums, mid + 1, high);
        countPairs(nums, low, mid, high);
        merge(nums, low, mid, high);

    }

    public void merge(int[] nums, int low, int mid, int high) {
        int[] res = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            res[k++] = nums[i++];
        }

        while (j <= high) {
            res[k++] = nums[j++];
        }

        for (i = low, k = 0; i <= high; i++, k++) {
            nums[i] = res[k];
        }

    }

    public void countPairs(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
    }
}