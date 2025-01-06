class Solution {
    public int[] minOperations(String boxes) {
        int len=boxes.length();
        int[] res= new int[len];
        Arrays.fill(res,0);
        
        int[] leftSum=new int[len];
        int[] rightSum=new int[len];
        leftSum[0]=0;
        rightSum[len-1]=0;
        int count=0;
        for(int i=1;i<len;i++){
            leftSum[i]=leftSum[i-1]+1*count;
            if(boxes.charAt(i-1)=='1'){
                leftSum[i]++;
                count++;
            }
        }

        count=0;
        for(int i=len-2;i>=0;i--){
            rightSum[i]=rightSum[i+1]+ 1*count;
            if(boxes.charAt(i+1)=='1'){
                rightSum[i]++;
                count++;
            }
        }

        for(int i=0;i<len;i++){
            res[i]=leftSum[i]+rightSum[i];
        }
        return res;

    }
}