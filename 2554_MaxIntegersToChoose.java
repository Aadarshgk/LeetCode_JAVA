class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        boolean[] set= new boolean[n+1];
        for(int a: banned){
            if(a>n) continue;
            set[a]=true;
        }

        int count=0,sum=0;
        for(int i=1;i<=n;i++){
            if(sum+i>maxSum){
                break;
            }
            if(set[i]) continue;
            count++;
            sum+=i;
        }

        return count;
    }
}