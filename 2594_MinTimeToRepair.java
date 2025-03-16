class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long len=ranks.length;
        long low=1;
        long high= (long)ranks[0]*cars*cars;

        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(helper(ranks,mid,cars)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean helper(int[] ranks,long mid, long cars){
        long count=0;
        for(int rank: ranks){
            count+=Math.sqrt(mid/rank);
        }
        return count>=cars;
    }
}