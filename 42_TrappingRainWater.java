class Solution {
    public int trap(int[] height) {
        int len=height.length;
        if(len<3) return 0;
        int res=0;

        int i=0,j=1,sum=0,lMax=height[0];
        while(j<len){
            int h=height[j];
            if(h<lMax){
                sum+=lMax-h;
            }else{
                res+=sum;
                lMax=h;
                sum=0;
                i=j;
            }
            j++;
        }

        int rMax=height[len-1];
        j=len-2;
        sum=0;
        while(j>=i){
            int h=height[j];
            if(h<rMax){
                sum+=rMax-h;
            }else{
                res+=sum;
                sum=0;
                rMax=h;
            }
            j--;
        }

        return res;
    }
}