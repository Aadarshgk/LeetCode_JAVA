class Solution {
    public void merge(int[] ar, int low, int mid, int high) {
        int left=low, right=mid+1,x=0;
        int[] res = new int[high - low + 1];
        while (left <= mid && right <= high) {
            if (ar[left] <= ar[right]) {
                res[x++] = ar[left++];
            } else {
                res[x++] = ar[right++];
            }
        }
        while (left <= mid) {
            res[x++] = ar[left++];
        }
        while (right <= high) {
            res[x++] = ar[right++];
        }

        for (int i = 0, j = low; i < res.length; i++,j++) {
            ar[j] = res[i];
        }
    }

    public void divide(int[] ar, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        divide(ar, low, mid);
        divide(ar, mid + 1, high);
        merge(ar, low, mid, high);
    }
    public int[] sortArray(int[] nums) {
        divide(nums,0,nums.length-1);
        return nums;
    }
}