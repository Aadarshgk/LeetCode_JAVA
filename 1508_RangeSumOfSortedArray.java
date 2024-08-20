import java.util.Arrays;
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] res= new int[n*(n+1)/2];
        int id=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                res[id]=sum;
                id++;
            }
        }

        Arrays.sort(res);
        long sum=0;
        for(int i=left-1;i<right;i++){
            sum+=res[i];
        }
        return (int)(sum%1000000007);
    }
}