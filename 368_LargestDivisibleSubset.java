class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int[] dp=new int[len];
        Arrays.fill(dp,1);
        int lis=1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    if(lis<dp[i]){
                        lis=dp[i];
                    }
                }
            }
        }
        
        List<Integer> list=new ArrayList<>();
        int prev=-1;
        for(int i=len-1;i>=0;i--){
            if(dp[i]==lis && (prev%nums[i]==0 || prev==-1)){
                prev=nums[i];
                list.add(prev);
                lis--;
            }
        }

        return list;
    }
}