class Solution {
    int[] mem;
    public boolean checkPowersOfThree(int n) {
        mem=new int[16];
        mem[0]=1;
        for(int i=1;i<16;i++){
            mem[i]=mem[i-1]*3;
        }
        return helper(n,15);
    }

    public boolean helper(int n, int i){
        if(i<0){
            return false;
        }
        if(i==0){
            if(n==1) return true;
            return false;
        }

        while(mem[i]>n){
            i--;
        }
        if(n==mem[i]) return true;
        n-=mem[i--];
        return helper(n,i);
    }
}