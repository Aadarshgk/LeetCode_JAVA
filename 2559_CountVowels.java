import java.util.HashSet;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int len=words.length;
        int[] mem= new int[len+1];
        HashSet<Character> set= new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        mem[0]=0;
        for(int i=0;i<len;i++){
            if(!set.contains(words[i].charAt(0)) || !set.contains(words[i].charAt(words[i].length()-1))){
                mem[i+1]=0;
            }else{
                mem[i+1]=1;
            }
        }

        for(int i=1;i<len+1;i++){
            mem[i]+=mem[i-1];
        }

        int[] ans= new int[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i]=mem[queries[i][1]+1]-mem[queries[i][0]];
        }

        return ans;

    }
}