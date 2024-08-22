class Solution {
    public int findComplement(int num) {
        int res=1;
        while(num>res){
            res=(res<<1) | 1;
        }   
        return res^num;
    }
}