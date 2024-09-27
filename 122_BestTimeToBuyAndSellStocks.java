class Solution {
    public int maxProfit(int[] prices) {
        int profit=0,len=prices.length;
        for(int i=0;i<len;i++){
            if(i>0 && prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}