class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int len=s1.length();
        int temp=-1;
        boolean flag=false;
        for(int i=0;i<len;i++){
            if(s1.charAt(i)==s2.charAt(i)) continue;
            if(temp==-1){
                temp=i;
            }else{
                if(!flag && s1.charAt(i)==s2.charAt(temp) && s1.charAt(temp)==s2.charAt(i)){
                    flag=true;
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(temp>-1 && !flag) return false;
        return true;
    }
}