class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb= new StringBuilder();
        int len=word.length();
        int i=0;
        for(i=0;i<len;i++){
            sb.insert(0,word.charAt(i));
            if(word.charAt(i)==ch){
                break;
            }
        }
        if(i>=len) return word;
        for(i=i+1;i<len;i++){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}