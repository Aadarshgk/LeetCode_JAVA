class Solution {
    public int countLargestGroup(int n) {
        int[] temp= new int[46];
        for(int i=1;i<=n;i++){
            int num=i,sum=0;
            while(num>0){
                sum+=num%10;
                num/=10;
            }
            temp[sum]++;
        }

        int max=0,maxCount=0;
        for(int i=0;i<46;i++){
            if(temp[i]>max){
                max=temp[i];
                maxCount=1;
            }else if(temp[i]==max){
                maxCount++;
            }
        }

        return maxCount;
        
    }
}