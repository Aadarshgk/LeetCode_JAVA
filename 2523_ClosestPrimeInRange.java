import java.util.Arrays;
class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] ar = new boolean[right + 1];
        Arrays.fill(ar, true);
        ar[0] = false;
        ar[1] = false;
        for (int i = 2; i * i <= right; i++) {
            if (ar[i]) {
                for (int j = i * i; j <= right; j += i) {
                    ar[j] = false;
                }
            }
        }

        int[] res = new int[] { -1, -1 };
        int prev = -1;
        int minDif = Integer.MAX_VALUE;
        for (int i = left; i <= right; i++) {
            if (ar[i]) {
                if (prev != -1) {
                    int dif = i - prev;
                    if (dif < minDif) {
                        res[0] = prev;
                        res[1] = i;
                        minDif = dif;
                    }
                }
                prev = i;
            }
        }
        return res;
    }
}