class Solution {
    public boolean isStrictlyPalindromic(int n) {
        int i=1;
        while(i<=n){
            i=(i<<1);
        }
        i>>=1;
        int j=1;

        while(i>j){
            if(((n&i)>1 && (n&j)>1) || (n&i)==(n&j)){
                i>>=1;
                j<<=1;
            }else{
                return false;
            }
        }
        return true;

    }
}