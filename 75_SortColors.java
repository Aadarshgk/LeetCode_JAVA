class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums, int low, int high){
        if(low>=high) return;
        int pivot=nums[low];
        int i=low+1,j=high;
        while(i<=j){
            while(i<=high && nums[i]<=pivot){
                i++;
            }
            while(j>=low+1 && nums[j]>=pivot){
                j--;
            }
            if(i<=j){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
            }
        }
        int temp=nums[j];
        nums[j]=nums[low];
        nums[low]=temp;

        quickSort(nums,low,j-1);
        quickSort(nums,j+1,high);
    }
}