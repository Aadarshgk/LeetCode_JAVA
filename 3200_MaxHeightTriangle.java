class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        if(red==1 && blue==1) return 1;
        if(red==1 || blue ==1) return 2;
        int count1=1,i=red,j=blue;
        while(i>=0 && j>=0){
            if(count1%2==0){
                i-=count1;
            }else{
                j-=count1;
            }
            count1++;
        }
        count1--;
        int count2=1;
        i=red;
        j=blue;
        while(i>=0 && j>=0){
            if(count2%2==0){
                j-=count2;
            }else{
                i-=count2;
            }
            count2++;
        }
        count2--;
        return Math.max(count1,count2)-1;
    }
}