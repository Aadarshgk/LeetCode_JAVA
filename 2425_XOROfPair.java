class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;

        if(len1%2==0 && len2%2==0) return 0;

        int res=0;
        if(len1%2!=0){
            for(int n: nums2){
                res^=n;
            }
        }
        if(len2%2!=0){
            for(int n: nums1){
                res^=n;
            }
        }

        return res;
    }
}