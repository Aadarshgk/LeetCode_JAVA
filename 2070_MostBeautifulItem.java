import java.util.Arrays;
class Solution {

    public int binarySearch(int[][] items, int num){
        int i=0,j=items.length-1;
        int mid=i+(j-i)/2;
        int maxBeauty=0;
        while(i<=j){
            mid=i+(j-i)/2;
            if(items[mid][0]<=num){
                maxBeauty=Math.max(maxBeauty,items[mid][1]);
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return maxBeauty;
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0]-b[0]);
        int[]  res= new int[queries.length];
        // int prev=0;
        for(int i=1;i<items.length;i++){
            if(items[i][1]<items[i-1][1]){
                items[i][1]=items[i-1][1];
            }
        }

        for(int i=0;i<res.length;i++){
            res[i]=binarySearch(items,queries[i]);
        }

        return res;

    }
}