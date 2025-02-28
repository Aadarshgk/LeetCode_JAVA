class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        String lcs=findLcs(str1,str2);
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        for(char c: lcs.toCharArray()){
            while(i<len1 && str1.charAt(i)!=c){
                sb.append(str1.charAt(i++));
            }
            while(j<len2 && str2.charAt(j)!=c){
                sb.append(str2.charAt(j++));
            }
            sb.append(c);
            i++;
            j++;
        }

        while(i<len1){
            sb.append(str1.charAt(i++));
        }
        while(j<len2){
            sb.append(str2.charAt(j++));
        }
        return sb.toString();
    }

    public String findLcs(String str1,String str2){
        int len1=str1.length();
        int len2=str2.length();
        int[][] dp= new int[len1+1][len2+1];
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb= new StringBuilder();
        int i=len1,j=len2;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.insert(0,str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else{
                j--;
            }
        }

        return sb.toString();
    }
}