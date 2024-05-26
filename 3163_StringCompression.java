class Solution {
    public String compressedString(String word) {
        StringBuilder res= new StringBuilder();
        int count=0,i=0,j=0,len=word.length();
        while(j<len){
            count=0;
            while(j<len && word.charAt(i)==word.charAt(j) && count<9){
                j++;
                count++;
            }           
            res.append(count);
            res.append(word.charAt(i));
            i=j; 
        }
        return res.toString();
    }
}