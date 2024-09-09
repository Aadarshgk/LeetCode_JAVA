import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        int len=nums.length;
        for(int i=0;i<len-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<len-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1;
                int l=len-1;
                long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                while(k<l){
                    sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum>target){
                        l--;
                    }else if(sum<target){
                        k++;
                    }else{
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        res.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                        
                    }
                }
            }
        }
        return res;
    }
}