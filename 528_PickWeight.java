import java.util.Random;
class Solution {
    int ar[];
    int sum=0;
    Random num= new Random();
    public Solution(int[] w) {
        ar= new int[w.length];
        int i=0;
        while(i<w.length){
            sum+=w[i];
            ar[i++]=sum;
        }
    }
    
    public int pickIndex() {
        int pick=num.nextInt(sum)+1;
        int res= binarySearch(pick);
        return res;
    }

    public int binarySearch(int target){
        int low=0,high=ar.length-1;
        while(low<=high){
            int mid= low + (high-low)/2;
            if(ar[mid]==target){
                return mid;
            }else if(target<ar[mid]){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}

