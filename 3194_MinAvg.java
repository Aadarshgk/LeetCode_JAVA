class Solution {
    public double minimumAverage(int[] nums) {
        double min=Double.MAX_VALUE;
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j){
            min=Math.min(min, (double)(nums[i]+nums[j])/2);
            i++;
            j--;
        }
        return min;
    }
}