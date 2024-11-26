class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] res=new int[n];
        for(int[] edge: edges){
            res[edge[1]]++;
        }
        int ans=-1,count=0;
        for(int i=0;i<n;i++){
            if(res[i]==0){
                ans=i;
                count++;
            }
        }

        if(count==1) return ans;
        return -1;
    }
}