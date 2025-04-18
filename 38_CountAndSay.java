class Solution {
    public String countAndSay(int n) {
        return helper(new StringBuilder("1"),n);
    }

    public String helper(StringBuilder sb,int n){
        if(n==1) return sb.toString();

        StringBuilder ans = new StringBuilder();
        int count=0;
        char c=sb.charAt(0);
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==c){
                count++;
            }else{
                ans.append(count);
                ans.append(c);
                c=sb.charAt(i);
                count=1;
            }
        }
        ans.append(count);
        ans.append(c);
        return helper(ans,n-1);
    }
}