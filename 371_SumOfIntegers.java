class Solution {
    public int getSum(int a, int b) {
        int sum= (a^b);
        int carry=(a&b);
        if(carry ==0) return sum;
        carry=carry<<1;
        return getSum(carry,sum);
    }
}