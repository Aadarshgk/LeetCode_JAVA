class Solution {
    public int maxDistance(String s, int k) {
        int res=0,vert=0,horz=0,i=1;
        for(char c : s.toCharArray()){
            if(c=='N'){
                vert++;
            }else if(c=='S'){
                vert--;
            }else if(c=='W'){
                horz--;
            }else{
                horz++;
            }
            res=Math.max(res,Math.min( Math.abs(vert)+Math.abs(horz)+2*k,i++));
        }
        return res;
    }
}