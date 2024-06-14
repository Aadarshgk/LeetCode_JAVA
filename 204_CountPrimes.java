class Solution {
    public int countPrimes(int n) {
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(visited[i]) continue;
            count++;
            for(long j=(long)i*i;j<n;j=j+i){
                visited[(int)j]=true;
            }
        }
        return count;
    }
}