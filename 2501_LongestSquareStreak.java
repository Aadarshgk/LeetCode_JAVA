import java.util.HashSet;
import java.util.Iterator;
class Solution {
    public int longestSquareStreak(int[] nums) {
        int max=0;
        HashSet<Long> set= new HashSet<>();
        for(int a: nums){
            set.add((long)a);
        }
        
        Iterator<Long> it= set.iterator();

        while(it.hasNext()){
            Long a= it.next();
            max=Math.max(check(a,set),max);
        }


        return (max>0)?max+1:-1;
    }

    public int check(Long a,HashSet<Long> set){
        if(!set.contains((Long) (a*a))) return 0;
        return 1+ check(a*a,set);
    }
}