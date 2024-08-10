class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len=arr.length;
        return helper(arr,0,len-1,new pair[len][len]).sum;
    }

    public pair helper(int[] ar, int l, int r,pair dp[][]){
        if(l>r){
            return new pair(100000,0);
        }

        if(l==r){
            return new pair(0,ar[l]);
        }

        if(dp[l][r]!=null) {
            return dp[l][r];
        }

        pair res= new pair(100000,0);
        for(int i=l;i<r;i++){
            pair left= helper(ar,l,i,dp);
            pair right= helper(ar,i+1,r,dp);
            int total= left.sum+ right.sum + (left.max * right.max);
            if(total< res.sum){
                res.max= Math.max(left.max , right.max);
                res.sum= total;
            }
        } 

        dp[l][r]=new pair(res.sum,res.max);
        return res;
    }

    class pair{
        int max;
        int sum;

        public pair(int sum, int max){
            this.max=max;
            this.sum=sum;
        }
    }
}