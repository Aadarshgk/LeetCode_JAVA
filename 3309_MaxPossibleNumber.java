class Solution {
    int maxNum= Integer.MIN_VALUE;
    public int maxGoodNumber(int[] nums) {
        return permute(nums,new boolean[3],0,-1);
    }

    public int permute(int[] nums, boolean[] set, int n,int count){
        if(count==3){
            maxNum=Math.max(maxNum,n);
            return maxNum;
        }

        for(int i=0;i<3;i++){
            if(!set[i]){
                set[i]=true;
                int num=nums[i];
                int shift=0;
                while(num>0){
                    num=(num>>1);
                    shift++;
                }
                num=nums[i];
                n=(n<<shift)|num;
                permute(nums,set,n,count++);
                n=(n>>shift);
                set[i]=false;
            }
        }
        maxNum=Math.max(maxNum,n);
        return maxNum;
    }
}