import java.util.HashSet;
class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set= new HashSet<>();
        for(int n: arr){
            if(set.contains(n*2) || ((n%2==0) && set.contains(n/2))) return true;
            set.add(n);
        }
        return false;
    }
}