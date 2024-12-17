import java.util.Arrays;
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] ar= new int[26];
        Arrays.fill(ar,0);
        for(char c: s.toCharArray()){
            ar[c-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        int i=25,j=24;
        while(i>=0){
            while(i>=0 && ar[i]==0) i--;
            
            if(i<0) break;

            int count=Math.min(ar[i],repeatLimit);
            for(int k=0;k<count;k++,ar[i]--){
                sb.append((char)('a'+i));
            }

            if(ar[i]>0){
                j=i-1;
                while(j>=0 && ar[j]==0) j--;
                if(j<0) break;
                sb.append((char)('a'+j));
                ar[j]--;
            }
        }
        return sb.toString();
    }
}