class Solution {
    public int minSwaps(String s) {
        int count=0;
        int imbalance=0;
        for(char c: s.toCharArray()){
            if(c=='['){
                count++;
            }else{
                if(count==0){
                    imbalance++;
                }else{
                    count--;
                }
            }
        }
        return (imbalance+1)/2;
    }
}