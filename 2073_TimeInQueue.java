class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int i=0,count=0,res=0;
        while(i<tickets.length){
            if(i<=k){
                res=(tickets[i]<tickets[k])?tickets[i]:tickets[k];
                count+=res;
            }else{
                res=(tickets[i]<tickets[k])?tickets[i]:tickets[k]-1;
                count+=res;
            }
            i++;
        }
        return count;        
    }
}