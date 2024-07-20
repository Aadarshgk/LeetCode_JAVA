class Solution {
    public int maxProfit(int[] prices) {
        int minNum=prices[0];
        int maxProfit=0;
        for(int a: prices){
            minNum=(a<minNum)?a:minNum;
            maxProfit=(a-minNum>maxProfit)?a-minNum:maxProfit;
        }   
        return maxProfit;
    }
}