class Solution {
    public int findCenter(int[][] edges) {
        int[] ar= new int[edges.length+2];
        for(int[] a: edges ){
            ar[a[0]]++;
            ar[a[1]]++;
            if(ar[a[0]]>1) return a[0];
            if(ar[a[1]]>1) return a[1];
        }
        return 0;
    }
}