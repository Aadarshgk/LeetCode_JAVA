class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int len1=nums.length,len2=queries.length;
        int[] dif=new int[len1+1];
        int pos=0,sum=0;
        for(int i=0;i<len1;i++){
            while(sum+dif[i]<nums[i]){
                if(pos==len2) return -1;
                int start=queries[pos][0];
                int end=queries[pos][1];
                int val=queries[pos][2];
                pos++;

                if(end<i) continue;
                dif[Math.max(i,start)]+=val;
                dif[end+1]-=val;  
            }
            sum+=dif[i];
        }

        return pos;
    }
}