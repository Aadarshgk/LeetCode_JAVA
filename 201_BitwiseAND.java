class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if((left&right)==0) return 0;
        if(left==right) return left;

        long temp=1;
        while(temp<= left && temp<=right){
            temp<<=1;
        }

        if(temp>left && temp<=right){
            return 0;
        }

        int res=left&right;
        for(long i=1;i+left<right;i*=2){
            res&=(left+i);
        }

        return res;
    }
}