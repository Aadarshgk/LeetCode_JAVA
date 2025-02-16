class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res= new int[n*2-1];
        boolean[] set= new boolean[n+1];
        backtrack(0,res,set,n);
        return res;
    }

    public boolean backtrack(int pos,int[] res, boolean[] set, int n){
        if(pos==n*2-1){
            return true;
        }

        for(int num=n;num>=1;num--){
            if(set[num]){
                continue;
            }else if(num>1 && (pos+num>=n*2-1 || res[num+pos]>0)){
                continue;
            }

            set[num]=true;
            res[pos]=num;
            if(num>1){
                res[pos+num]=num;
            }

            int j=pos+1;
            while(j<n*2-1 && res[j]>0) j++;
            if(backtrack(j,res,set,n)) return true;

            set[num]=false;
            res[pos]=0;
            if(num>1){
                res[pos+num]=0;
            }
        }
        return false;
    }
}