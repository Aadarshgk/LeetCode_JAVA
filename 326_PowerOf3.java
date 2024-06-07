class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1) return false;
        while(n>1){
            if(n%3==0){
                n/=3;
            }else{
                return false;
            }
        }
        if(n==1) return true;
        return false;
    }
}