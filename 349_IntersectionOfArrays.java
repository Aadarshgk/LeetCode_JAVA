import java.util.HashSet;
import java.util.Iterator;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set= new HashSet<>();
        HashSet<Integer> ar=new HashSet<>();
        int i=0,len1=nums1.length,len2=nums2.length;
        while(i<len1){
            set.add(nums1[i]);
            i++;
        }
        i=0;
        while(i<len2){
            if(set.contains(nums2[i])){
                ar.add(nums2[i]);
            }
            i++;
        }
        i=0;
        int len3=ar.size();
        int[] output= new int[len3];
        Iterator<Integer> itr=ar.iterator();
        while(itr.hasNext()){
            output[i]=itr.next();
            i++;
        }
        return output;
    }
}