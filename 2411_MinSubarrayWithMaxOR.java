import java.util.Arrays;
class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int max=Integer.MIN_VALUE,len=nums.length;
        int[] res=new int[len];
        for(int n: nums){
            max=Math.max(n,max);
        }
        int count=0,i=1;
        while(i<=max){
            i<<=1;
            count++;
        }

        int[] setBit=new int[count];
        Arrays.fill(setBit, len);

        for(int j=len-1;j>=0;j--){
            int nearest = j;
            for(int k=0;k<count;k++){
                if((nums[j]&(1<<k))>0){
                    setBit[k]=j;
                }else if(setBit[k]!=len){
                    nearest=Math.max(nearest,setBit[k]);
                }
            }

            res[j]=nearest-j+1;

        }

        return res;
    }
}