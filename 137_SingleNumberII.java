class Solution {
    public int singleNumber(int[] nums) {
        int[] setBit= new int[32];
        for(int num: nums){
            for(int i=0;i<32;i++){
                if((num & (1<<i))!=0){
                    setBit[i]++;
                }
            }
        }

        int res=0;
        for(int i=0;i<32;i++){
            if(setBit[i]%3!=0){
                res|=(1<<i);
            }
        }

        return res;
    }
}