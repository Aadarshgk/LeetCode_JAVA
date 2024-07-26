import java.util.Arrays;
class Solution {
    public int tribonacci(int n) {
        int[] ar= new int[n+1];
        Arrays.fill(ar,Integer.MAX_VALUE);
        return memory(n,ar);
    }

    public int memory(int n, int[] ar){
        if(n==0){
            ar[0]=0;
            return 0;
        }

        if(n==1 || n==2){
            ar[n] = 1;
            return 1;
        }

        int sum=0;
        if(ar[n-1]!=Integer.MAX_VALUE){
            sum+=ar[n-1];
        }else{
            sum+=memory(n-1,ar);
        }

        if(ar[n-2]!=Integer.MAX_VALUE){
            sum+=ar[n-2];
        }else{
            sum+=memory(n-2,ar);
        }
        
        if(ar[n-3]!=Integer.MAX_VALUE){
            sum+=ar[n-3];
        }else{
            sum+=memory(n-3,ar);
        }
        
        ar[n]=sum;
        return sum;
    }
}