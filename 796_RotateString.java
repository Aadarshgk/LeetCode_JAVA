class Solution {
    public boolean rotateString(String s, String goal) {
        int len=s.length();
        if(goal.length() != len) return false;
        boolean res=false;
        char c=s.charAt(0);
        for(int i=0;i<len;i++){
            if(c==goal.charAt(i)){
                res= res|| check(s,goal,i,len);
            }
        }

        return res;    
    }

    public boolean check(String s, String goal, int i,int len){
        for(char c:s.toCharArray()){
            if(c!=goal.charAt(i)){
                return false;
            }
            i=(i+1)%len;
        }
        return true;
    }
}