class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len=0,i=0,j=0,len1=nums1.length,len2=nums2.length,k=0;
        while(i<len1 && j<len2){
            if(nums1[i][0]==nums2[j][0]){
                i++;
                j++;
            }else if(nums1[i][0]>nums2[j][0]){
                j++;
            }else{
                i++;
            }
            len++;
        }
        while(i<len1){
            i++;
            len++;
        }
        while(j<len2){
            j++;
            len++;
        }

        int[][] res= new int[len][2];
        i=0;
        j=0;
        for(k=0;k<len && i<len1 && j<len2;k++){
            if(nums1[i][0]==nums2[j][0]){
                res[k][0]=nums1[i][0];
                res[k][1]=nums1[i][1]+nums2[j][1];
                i++;
                j++;
            }else if(nums1[i][0]<nums2[j][0]){
                res[k][0]=nums1[i][0];
                res[k][1]=nums1[i][1];
                i++;
            }else{
                res[k][0]=nums2[j][0];
                res[k][1]=nums2[j][1];
                j++;
            }
        }

        while(i<len1 && k<len){
            res[k][0]=nums1[i][0];
            res[k][1]=nums1[i][1];
            i++;
            k++;
        }

        while(j<len2 && k<len){
            res[k][0]=nums2[j][0];
            res[k][1]=nums2[j][1];
            j++;
            k++;
        }
        return res;
    }
}