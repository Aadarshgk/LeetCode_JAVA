class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] ar = new int[k];
        for(int a: arr){
            ar[(a%k+k)%k]++;
        }

        if(ar[0]%2 !=0) return false;

        for(int i=1;i<k;i++){
            if(ar[i]!=ar[k-i]) return false;
        }

        return true;

    }
}