class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int j=0,res=0;
        while(j<32){
            res=((res<<1) | (n&1));
            n=n>>1;
            j++;
        }
        return res;
    }
}