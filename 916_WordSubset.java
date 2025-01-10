import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq= new int[26];
        for(String str: words2){
            int[] ar= new int[26];
            for(char c : str.toCharArray()){
                int id=c-'a';
                ar[id]++;
                maxFreq[id]=Math.max(maxFreq[id],ar[id]);
            }
        }

        List<String> res= new ArrayList<>();
        for(String str: words1){
            int[] ar= new int[26];
            for(char c: str.toCharArray()){
                int id=c-'a';
                ar[id]++;
            }

            boolean flag=true;
            for(int i=0;i<26;i++){
                if(ar[i]<maxFreq[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res.add(str);
            }
        }
        return res;
    }
}