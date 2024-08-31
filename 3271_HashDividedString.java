class Solution {
    public String stringHash(String s, int k) {
        StringBuilder res= new StringBuilder();
        int len=s.length();
        for(int i=0;i<len;i+=k){
            int val=0;
            for(int j=0;j<k;j++){
                val+=(s.charAt(i+j)-97);
            }
            val= val%26;
            res.append((char)(val+97));
        }
        return res.toString();
    }
}
