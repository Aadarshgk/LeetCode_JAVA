class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low=1,high=0;
        for(int num: quantities){
            high=Math.max(high,num);
        }

        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAssign(mid,n,quantities)){
                high=mid-1;
                ans=Math.min(ans,mid);
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public boolean canAssign(int mid,int n,int[] quantities){
        int count=0;
        for(int quantity: quantities){
            count+=Math.ceil((double) quantity/mid);
        }

        return count<=n;
    }
}