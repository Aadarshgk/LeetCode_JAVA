import java.util.Arrays;
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0,k=0;
        while(c<g.length && k<s.length){
            if(g[c]<=s[k]){
                c++;
            }
            k++;
        }
        return c;
    }
}