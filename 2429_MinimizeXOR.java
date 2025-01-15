class Solution {
    public int minimizeXor(int num1, int num2) {
        int count=Integer.bitCount(num2);
        int i=1;
        while(i<=num1){
            i=(i<<1);
        }   
        i=(i>>1);

        int res=0;
        while(i>0 && count>0){
            if((num1&i)>0){
                res=(res|i);
                count--;
            }
            i=(i>>1);
        }
        i=1;
        while(count>0){
            if((res&i)==0){
                res=(res|i);
                count--;
            }

            i=(i<<1);
        }

        return res;
    }
}