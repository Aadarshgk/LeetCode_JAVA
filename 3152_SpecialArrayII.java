class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1];
            if((nums[i-1]-nums[i])%2==0){
                prefix[i]++;
            }
        }
        boolean[] res=new boolean[queries.length];
        int k=0;
        for(int[] ar: queries){
            if(prefix[ar[1]]-prefix[ar[0]] > 0){
                res[k++]=false;
            }else{
                res[k++]=true;
            } 
        }
        return res;       
    }
}