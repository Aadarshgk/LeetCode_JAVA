import java.util.Arrays;
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int len=nums.length;
        if(k==1) return nums;

        int[] res= new int[len-k+1];
        Arrays.fill(res,-1);
        int i=0,j=0;
        while(j<len){
            if(j>0 && nums[j]- nums[j-1]!=1){
                i=j;
            }

            while(i<j && j-i+1 > k){
                i++;
            }

            if(j-i+1==k){
                res[j-k+1]=nums[j];
            }
            j++;
        }

        return res;
    }
}