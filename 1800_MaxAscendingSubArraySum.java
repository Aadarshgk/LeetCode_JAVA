class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=0,res=0,prev=0;
        for(int num:nums){
            if(num>prev){
                sum+=num;
            }else{
                res=Math.max(res,sum);
                sum=num;
            }
            prev=num;
        }
        res=Math.max(res,sum);
        return res;
    }
}