class Solution {
    private int perm(int[] freq){
        int res=0;
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                freq[i]--;
                res+=1+perm(freq);
                freq[i]++;
            }
        }
        return res;
    }


    public int numTilePossibilities(String tiles) {
        int[] freq= new int[26];
        for(char c: tiles.toCharArray()){
            freq[c-'A']++;
        }

        return perm(freq);   
    }
    
    
}