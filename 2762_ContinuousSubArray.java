class Solution {
    public long continuousSubarrays(int[] nums) {
        int minVal=Integer.MAX_VALUE;
        int maxVal=Integer.MIN_VALUE;
        long count=0;
        long winSize;
        int l=0,r=0,len=nums.length;
        for(r=0;r<len;r++){
            int n=nums[r];
            maxVal=Math.max(n,maxVal);
            minVal=Math.min(n,minVal);
            
            if((maxVal-minVal)>2){
                winSize=r-l;
                count+=(winSize*(winSize+1))/2;

                l=r;

                maxVal=nums[r];
                minVal=nums[r];
                while(Math.abs(nums[r]-nums[l-1])<=2){
                    l--;
                    maxVal=Math.max(nums[l],maxVal);
                    minVal=Math.min(nums[l],minVal);
                }

                if(l<r){
                    winSize=r-l;
                    count-=(winSize*(winSize+1))/2;
                }
            }
        }   

        winSize=r-l;
        count+=(winSize*(winSize+1))/2;
        return count;
    }
}