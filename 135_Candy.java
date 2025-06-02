import java.util.Arrays;
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] ar=new int[len];
        Arrays.fill(ar,1);

        for(int i=1;i<len;i++){
            if(ratings[i]>ratings[i-1]){
                ar[i]=ar[i-1]+1;
            }
        }   


        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                ar[i]=Math.max(ar[i],1+ar[i+1]);
            }
        }

        int count=0;
        for(int n: ar){
            count+=n;
        }

        return count;
    }
}