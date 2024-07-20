//Kadane's algorithm

class Solution {
    public int maxSubArray(int[] nums) {
        int temp= 0;
        int maxSum=Integer.MIN_VALUE;
        for(int a:nums){
            temp+=a;
            if(maxSum<temp){
                maxSum=temp;
            }
            if(temp<0){
                temp=0;
            }
        }
        return maxSum;
    }
}