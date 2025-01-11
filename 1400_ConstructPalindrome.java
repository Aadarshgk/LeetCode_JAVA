class Solution {
    public boolean canConstruct(String s, int k) {
        if(k>s.length()) return false;
        int[] ar= new int[26];

        for(char c : s.toCharArray()){
            ar[c-'a']++;
        }

        int odd=0;
        for(int n : ar){
            if(n%2==1) odd++;
        }

        return odd<=k;
    }
}