import java.util.Arrays;
class Solution {
    public int fib(int n) {
        int[] ar = new int[n + 1];
        Arrays.fill(ar, Integer.MAX_VALUE);
        return fib(n, ar);
    }

    public int fib(int n, int[] ar) {
        if (n == 0) {
            ar[0] = 0;
            return 0;
        }
        if (n == 1) {
            ar[1] = 1;
            return 1;
        }

        if (ar[n - 2] == Integer.MAX_VALUE) {
            fib(n - 2, ar);
        }
        if (ar[n - 1] == Integer.MAX_VALUE) {
            fib(n - 1, ar);
        }

        ar[n] = ar[n - 1] + ar[n - 2];
        return ar[n];
    }
}