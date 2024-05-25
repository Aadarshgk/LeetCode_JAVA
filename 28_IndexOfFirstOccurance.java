class Solution {
    public int strStr(String haystack, String needle) {
        int len1=haystack.length(),len2=needle.length(),flag=1;
        for(int i=0;i<len1-len2+1;i++){
            flag=1;
            for(int j=0;j<len2;j++){
                if(needle.charAt(j)!=haystack.charAt(i+j)){
                    flag=0;
                    break;
                }
            }
            if(flag==1){
                return i;
            }
        }
        return -1;
    }
}