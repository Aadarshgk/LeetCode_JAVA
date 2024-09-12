import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int largest=0;
        HashMap<Character,Integer> set=new HashMap<>();
        int l=0,len=s.length();
        for(int r=0;r<len;r++){
            if(set.containsKey(s.charAt(r))){
                l=Math.max(set.get(s.charAt(r))+1,l);
            }
            set.put(s.charAt(r),r);
            largest=Math.max(r-l+1,largest);
        }

        return largest;
    }
}