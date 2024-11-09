import java.util.ArrayList;
class Solution {
    public long minEnd(int n, int x) {
        ArrayList<Integer> list= new ArrayList<>();
        
        for(int i=0;i<32;i++){
            if((x&(1<<i))==0){
                list.add(i);
            }
        }

        for(int i=32;i<64;i++){
            list.add(i);
        }

        long ans=x;
        long len=n-1;
        for(int i=0;len>0;i++,len>>=1){
            ans+= (len & 1L)<<list.get(i);
        }

        return ans;
    }
}