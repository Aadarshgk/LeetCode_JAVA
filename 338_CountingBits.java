class Solution {
    public int[] countBits(int n) {
        int[] res= new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++){
            if((i&(i-1))==0){
                res[i]=1;
            }else{
                res[i]= res[i>>1] + (i&1);
            }
        }

        return res;
    }
}