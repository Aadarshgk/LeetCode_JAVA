class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g=0,c=0,res=0,sum=0,len=gas.length;
        for(int i=0;i<len;i++){
            g+=gas[i];
            c+=cost[i];
        }
        if(g<c) return -1;

        for(int i=0;i<len;i++){
            sum+= gas[i]-cost[i];
            if(sum<0){
                sum=0;
                res=i+1;
            }
        }
        return res;
    }
}