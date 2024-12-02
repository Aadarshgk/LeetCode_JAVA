class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] ar= sentence.split(" ");
        for(int i=0;i<ar.length;i++){
            if(ar[i].startsWith(searchWord)){
                return i+1;
            }
        }
        return -1;
    }
}