import java.util.Arrays;
class Solution {
    boolean[] prime;

    void seive(int n){
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;

        for(int i=2;i<=n;i++){
            if(prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=false;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int len=nums.length;
        if(len==1) return true;

        int max=nums[len-1];
        boolean flag=true;
        for(int i=0;i<len-1;i++){
            if(nums[i]>=nums[i+1]){
                flag=false;
            }
            max=Math.max(max,nums[i]);
        }

        if(flag) return true;

        prime=new boolean[max+1];
        seive(max);

        int prev=Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            int j=nums[i]-1;
            while(j>=2){
                while(!prime[j]){
                    j--;
                }

                int difference= nums[i]-j;

                if(difference < nums[i+1] && difference>prev){
                    nums[i]-=j;
                    break;
                }else{
                    j--;
                }
            }
            prev=nums[i];

            if(nums[i]>=nums[i+1]) return false;
        }

        return true;
    }
}