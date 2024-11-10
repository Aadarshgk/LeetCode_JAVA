class Solution {
    int[] bit = new int[32];
    int res=0;

    //Updating the bit array which maintains the set bits of the elements parsed by j(right pointer)
    void update(int num, int val){
        for(int i=0;i<32;i++){
            if((num & (1<<i))>0){
                bit[i]+=val;
            }
        }
    }

    //updates res ,i.e, the OR-ed val from i(left to j) 
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
        
        //Maintains the min length of subarray
        int min= Integer.MAX_VALUE;

        //parsing left to right
        while(j<len){


            //OR-ing the next element in the array
            res|=nums[j];

            //updating the bit array. Val=1 coz incrementing
            update(nums[j],1);

            //tryinng to reduce the length of subarray
            while(i<=j && res>=k){
                min= Math.min(min,j-i+1);

                //removing left element. val=-1 coz removing its set bit from bit array
                update(nums[i],-1);

                //updating res after removal of left num. This helps in unset a bit if required ;)
                getNumber();
                i++;
            }
            j++;
        }

        //tada
        return (min==Integer.MAX_VALUE)?-1:min;
    }
}