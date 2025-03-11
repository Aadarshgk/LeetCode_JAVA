class Solution {
    public int numberOfSubstrings(String s) {
        int len=s.length(),j=0,res=0;
        int[] map=new int[3];
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            map[c-'a']++;

            while(map[0]>0 && map[1]>0 && map[2]>0){
                res+=len-i;
                char c1=s.charAt(j++);
                map[c1-'a']--;
            }
        }
        return res;
    }
}