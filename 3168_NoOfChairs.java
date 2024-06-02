class Solution {
    public int minimumChairs(String s) {
        int i=0,len=s.length(),count=0,max=0;
        while(i<len){
            if(s.charAt(i)=='E'){
                count++;
            }else{
                max=Math.max(max,count);
                count--;
            }
            i++;
        }
        max=Math.max(max,count);
        return max;

    }
}