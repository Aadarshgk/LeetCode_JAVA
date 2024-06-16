class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1;
        int res=0;
        while(i<j){
            int minHeight= Math.min(height[i],height[j]);
            int area=(j-i)*minHeight;
            res=Math.max(area , res);
            while(i<j && height[i]<=minHeight){
                i++;
            }
            while(i<j && height[j]<=minHeight){
                j--;
            }
        }
        return res;
    }
}