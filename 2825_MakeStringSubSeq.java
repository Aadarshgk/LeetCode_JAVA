class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int len1=str1.length(),len2=str2.length(),i=0,j=0;
        while(i<len1 && j<len2){
            char c1=str1.charAt(i);
            char c2=str2.charAt(j);
            if(c2==c1 || c2-c1==1 || (c1=='z' && c2=='a')){
                j++;
            }
            i++;
        }
        if(j==len2) return true;
        return false;
    }
}