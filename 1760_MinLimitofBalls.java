class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int low=1,high=Integer.MIN_VALUE,res=Integer.MAX_VALUE;
        for(int n: nums){
            high=Math.max(high,n);
        }   

        while(low<=high){
            int mid=low+(high-low)/2;

            
            if(canAssign(nums,mid,maxOperations)){
                res=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }

    public boolean canAssign(int[] nums,int val,int ops){
        double count=0;
        for(int n: nums){
            if(n>val){
                count+=Math.ceil((double)(n-val)/val);
            }
        }

        return count<=ops;
    }
}