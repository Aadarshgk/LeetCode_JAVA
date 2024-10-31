class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0,j=k-1,len=nums.length;
        double sum=0.00;

        for(int l=0;l<k;l++){
            sum+=nums[l];
        }

        double max=sum;

        while(++j<len){
            sum+=nums[j];
            sum-=nums[i++];

            max=(sum<max)?max:sum;
        }

        return max/k;
    }
}