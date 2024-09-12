import java.util.Arrays;
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] alpha= new boolean[26];
        Arrays.fill(alpha,false);

        for(char c: allowed.toCharArray()){
            alpha[c-'a']=true;
        }

        int count=0;
        for(String a: words){
            for(char c: a.toCharArray()){
                if(!alpha[c-'a']){
                    count++;
                    break;
                }
            }
        }
        return words.length-count;
    }
}