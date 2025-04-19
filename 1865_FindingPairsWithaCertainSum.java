class FindSumPairs {
    
    int[] nums1;
    int[] nums2;
    HashMap<Integer,Integer> map;
    public FindSumPairs(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        this.nums1=nums1;
        this.nums2=nums2;
        map=new HashMap<>();
        for(int n: nums2){
            map.put(n,map.getOrDefault(n,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int n=nums2[index];
        map.put(n,map.get(n)-1);
        nums2[index]+=val;
        n=nums2[index];
        map.put(n,map.getOrDefault(n,0)+1);
    }
    
    public int count(int tot) {
        int res=0;
        for(int n: nums1){
            if(n>tot) break;
            res+=map.getOrDefault(tot-n,0);
        }

        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */