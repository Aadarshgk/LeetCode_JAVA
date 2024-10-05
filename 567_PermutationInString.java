import java.util.Arrays;
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1=s1.length(), len2=s2.length();
        if(len1>len2) return false;
        int[] ar1= new int[26];
        int[] ar2= new int[26];

        for(int i=0;i<len1;i++){
            ar1[s1.charAt(i)-'a']++;
            ar2[s2.charAt(i)-'a']++;
        }   

        if(Arrays.equals(ar1,ar2)) return true;     

        int l=0,r=len1;
        while(r<len2){
            ar2[s2.charAt(r)-'a']++;
            ar2[s2.charAt(l)-'a']--;

            l++;
            r++;

            if(Arrays.equals(ar1,ar2)) return true;
        }
        return false;
    }
}