class Solution {
    public boolean helper(String num, int pos, int sum, int val){
        if(pos>=num.length()){
            return sum==val;
        }

        for(int i=0;i+pos<num.length();i++){
            int curVal=Integer.parseInt(num.substring(pos,pos+i+1));
            if(helper(num,i+pos+1,sum+curVal,val)){
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int res=1;
        for(int i=2;i<=n;i++){
            int sq=i*i;
            String num=String.valueOf(sq);
            if(helper(num,0,0,i)){
                res+= sq;
            }
        }
        return res;
    }
}