class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int len=derived.length;
        int og=0;
        for(int i=0;i<len-1;i++){
            og=(og^derived[i]);
        }   

        return (og^derived[len-1])==0;

    }
}