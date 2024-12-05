class Solution {
    public boolean canChange(String start, String target) {
        int len=start.length();
        int i=0,j=0;

        while(i<len || j<len){
            while(i<len && start.charAt(i)=='_') i++;
            while(j<len && target.charAt(j)=='_') j++;

            if(i<len && j<len){
                if(start.charAt(i)!=target.charAt(j)) return false;
                if(start.charAt(i)=='L' && i<j) return false;
                if(start.charAt(i)=='R' && i>j) return false;
            }
            i++;
            j++;
        }

        return (i==j)?true:false;
    }
}