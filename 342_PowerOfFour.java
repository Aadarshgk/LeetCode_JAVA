class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<1) return false;
        while(n%2==0){
                if(n%4==0){
                    n/=4;
                }else{
                    return false;
                }
        }
        if(n==1) return true;
        return false;        
    }
}