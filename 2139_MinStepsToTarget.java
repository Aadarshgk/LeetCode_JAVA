class Solution {
    public int minMoves(int target, int maxDoubles) {
        int step=0;
        while(target>1 && maxDoubles>0){
            if(target%2==0){
                target/=2;
                maxDoubles--;
                step++;
            }else{
                target--;
                step++;
            }
        }        
        if(target==1){
            return step;
        }else{
            step+=(target-1);
            return step;
        }
    }
}