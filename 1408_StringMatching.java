//KMP algorithm
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    List<int[]> lps= new ArrayList<>();
    public List<String> stringMatching(String[] words) {
        int len=words.length;
        Arrays.sort(words, (a,b)->(a.length()-b.length()));

        calc(words);

        List<String> res= new ArrayList<>();
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(isSub(words[i],words[j],lps.get(i))){
                    res.add(words[i]);
                    break;
                }
            }
        }   
        return res;
    }

    public void calc(String[] words){
        for(String w: words){
            int len=w.length();
            int[] temp= new int[len];
            int i=1,j=0;
            while(i<len){
                if(w.charAt(i)==w.charAt(j)){
                    temp[i]=j+1;
                    i++;
                    j++;
                }else if(j>0){
                    j= temp[j-1];
                }else{
                    i++;
                }
            }
            lps.add(temp);
        }
    }

    public boolean isSub(String pat, String word, int[] pat_lps){
        int patLen=pat.length();
        int wordLen= word.length();
        int i=0,j=0;
        while(i<patLen && j<wordLen){
            if(pat.charAt(i)==word.charAt(j)){
                i++;
                j++;
            }

            if(i==patLen) return true;
            
            if(j<wordLen && pat.charAt(i)!=word.charAt(j)){
                if(i>0){
                    i=pat_lps[i-1];
                }else{
                    j++;
                }
            }
        }
        return false;
    }
}