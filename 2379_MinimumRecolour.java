class Solution {
    public int minimumRecolors(String blocks, int k) {
        int count=0,min=k;
        int len=blocks.length(),j=0;
        for(int i=0;i<len;i++){
            if(blocks.charAt(i)-'B'==0){
                count++;
            }
            if(i>=k-1){
                min=Math.min(min,k-count);
                if(blocks.charAt(j)-'B'==0){
                    count--;
                }
                j++;
            }
        }

        return min;
    }
}