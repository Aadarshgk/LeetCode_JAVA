class Solution {
    int[][][] dp; 
    public int findMaxForm(String[] strs, int m, int n) {
        dp= new int[m+1][n+1][strs.length];
        return helper(strs,m,n,0);
    }

    public int helper(String[] strs, int m, int n, int i){
        if(i==strs.length || m+n==0) return 0;

        if(dp[m][n][i]>0) return dp[m][n][i];

        int zero=0, one=0;
        for(char a: strs[i].toCharArray()){
            if(a=='0'){
                zero++;
            }else{
                one++;
            }
        } 

        int included=0,skipped=0;
        if(zero<=m && one<=n){
            included= 1+ helper(strs,m-zero,n-one,i+1);
        }
        skipped=helper(strs,m,n,i+1);

        dp[m][n][i]= Math.max(included, skipped);
        return dp[m][n][i];
        
    }
}