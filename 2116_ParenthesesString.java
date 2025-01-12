class Solution {
    public boolean canBeValid(String s, String locked) {
        int len=s.length();
        if(len%2==1) return false;
        int opening=0,closing=0,wc=0;
        for(int i=0;i<len;i++){
            if(locked.charAt(i)=='0'){
                wc++;
            }else if(s.charAt(i)=='('){
                opening++;
            }else{
                closing++;
            }

            if(opening+wc<closing) return false;
        }

        opening=0;
        closing=0;
        wc=0;
        for(int i=len-1;i>=0;i--){
            if(locked.charAt(i)=='0'){
                wc++;
            }else if(s.charAt(i)=='('){
                opening++;
            }else{
                closing++;
            }

            if(wc+closing<opening) return false;
        }

        return true;
    }
}