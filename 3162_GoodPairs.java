class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int i=0,len1=nums1.length,len2=nums2.length,count=0;
        while(i<len1){
            int j=0,n1=nums1[i];            
            while(j<len2){
                if(n1%(nums2[j]*k)==0){
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }
}