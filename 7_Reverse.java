class Solution {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;
        long res=0;
        boolean flag=(x<0)?true:false;
        x=Math.abs(x);
        while(x>0){
            if(res*10 >Integer.MAX_VALUE) return 0;
            res=(res*10)+(x%10);
            x/=10;
        }
        if(flag) return (int)-res;
        return (int)res;
    }
}