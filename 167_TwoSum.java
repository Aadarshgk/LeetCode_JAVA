class Solution {
    public int[] bruteForce(int[] numbers, int target) {
        int i = 0, len = numbers.length - 1, low, high, mid, sum;
        int[] res = new int[2];
        while (i < len) {
            low = i + 1;
            high = len;
            while (low <= high) {
                mid = low + (high - low) / 2;
                sum = numbers[mid] + numbers[i];
                if (sum == target) {
                    res[0] = i + 1;
                    res[1] = mid + 1;
                    return res;
                } else if (sum < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            i++;
        }
        return res;
    }

    public int[] optimal(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1, sum;
        while (low < high) {
            sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[] { low + 1, high + 1 };
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[] { low + 1, high + 1 };
    }

}