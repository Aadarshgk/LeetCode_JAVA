class Solution {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        return (int)(helper(4,n/2)* helper(5,n-n/2) % mod);
    }

    public long helper(long a, long b){
        long res=1;
        while(b>0){
            if((b&1)==1){
                res=(res*a)%mod;
            }
            a=(a*a)%mod;
            b/=2;
        }

        return res;
    }
}