class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int len=s.length();
        int[] rel= new int[len+1];
        Arrays.fill(rel,0);
        for(int[] shift: shifts){
            if(shift[2]==0){
                rel[shift[0]]--;
                rel[shift[1]+1]++;
            }else{
                rel[shift[0]]++;
                rel[shift[1]+1]--;
            }
        }

        for(int i=1;i<len;i++){
            rel[i]+=rel[i-1];
        }

        StringBuilder sb= new StringBuilder();

        for(int i=0;i<len;i++){
            int diff=rel[i]%26;
            if(diff<0){
                diff+=26;
            }

            char c= (char)((s.charAt(i)-'a' + diff)%26 + 97);
            sb.append(c);
        }

        return sb.toString();
    }
}