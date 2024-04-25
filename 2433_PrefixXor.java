class Solution {
    public int[] findArray(int[] pref) {
        int i=1, len=pref.length;
        int[] res= new int[len];
        res[0]=pref[0];
        while(i<len){
            res[i]= (pref[i-1] ^ pref[i]);
            i++;
        }
        return res;
    }
}