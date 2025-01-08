class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int len=words.length,res=0;
        for(int i=0;i<len-1;i++){
            String pat=words[i];
            for(int j=i+1;j<len;j++){
                String text=words[j];
                if(text.startsWith(pat) && text.endsWith(pat)) res++;
            }
        }
        return res;
    }
}