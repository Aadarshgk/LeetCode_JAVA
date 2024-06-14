class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y < target ) return false;
        int t=Math.min(x,y);
        while(x%t!=0 || y%t!=0){
            t--;
        }       

        if(target%t==0) return true;
        return false; 
        
    }
}