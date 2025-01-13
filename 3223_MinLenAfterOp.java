class Solution {
    public int minimumLength(String s) {
        int[] ar= new int[26];
        for(char c: s.toCharArray()){
            ar[c-'a']++;
        }

        int len=0;
        for(int i=0;i<26;i++){
            if(ar[i]==0) continue;
            if(ar[i]%2==0){
                len+=2;
            }else{
                len+=1;
            }
        }

        return len;
    }
}