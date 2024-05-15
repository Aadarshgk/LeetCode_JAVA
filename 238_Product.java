class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length,i=1;
        int[] pre=new int[len];
        int[] suf=new int[len];
        int[] answer= new int[len];
        suf[len-1]=1;
        pre[0]=1;
        while(i<len){
            pre[i]=pre[i-1]*nums[i-1];
            suf[len-i-1]=suf[len-i]*nums[len-i];
            i++;
        }
        i=0;
        while(i<len){
            answer[i]=pre[i]*suf[i];
            i++;    
        }
        return answer;
    }
}