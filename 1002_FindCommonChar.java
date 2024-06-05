import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public List<String> commonChars(String[] words) {
        int[] res= new int[26];
        Arrays.fill(res,0);
        for(int i=0;i<words[0].length();i++){
            res[words[0].charAt(i)-'a']++;
        }
        for(int i=1;i<words.length;i++){
            int[] temp=new int[26];
            Arrays.fill(temp,0);
            String a=words[i];
            for(int j=0;j<a.length();j++){
                temp[a.charAt(j)-'a']++;
            }
            check(res,temp);
        }
        int i=0;
        List<String> soln=new ArrayList<>();
        while(i<26){
            if(res[i]!=0){
                char c='a';
                c+=i;
                for(int k=0;k<res[i];k++){
                    soln.add(String.valueOf(c));
                }
            }
            i++;
        }
        return soln;
    }


    public void check(int[] ar, int[] temp){
        int i=0;
        while(i<26){
            ar[i]=Math.min(ar[i],temp[i]);
            i++;
        }
    }
}