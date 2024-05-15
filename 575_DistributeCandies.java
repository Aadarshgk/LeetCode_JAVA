import java.util.HashSet;
class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        int i=0,len=candyType.length;
        while(i<len){
            set.add(candyType[i++]);
        } 
        len=(len/2<set.size())?len/2:set.size();
        return len;
    }
}