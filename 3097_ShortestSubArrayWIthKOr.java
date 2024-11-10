class Solution {
    int[] bit = new int[32];
    int res=0;

    void update(int num, int val){
        for(int i=0;i<32;i++){
            if((num & (1<<i))>0){
                bit[i]+=val;
            }
        }
    }

    void getNumber(){
        res=0;
        for(int i=0;i<32;i++){
            if(bit[i]>0){
                res|=(1<<i);
            }
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0) return 1;

        int len=nums.length;
        int i=0,j=0;
        int min= Integer.MAX_VALUE;
        while(j<len){
            update(nums[j],1);
            res|=nums[j];

            while(i<=j && res>=k){
                min= Math.min(min,j-i+1);
                update(nums[i],-1);
                getNumber();
                i++;
            }
            j++;
        }

        return (min==Integer.MAX_VALUE)?-1:min;
    }
}