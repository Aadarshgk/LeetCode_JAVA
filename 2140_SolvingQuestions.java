import java.util.Arrays;
class Solution {
    public long mostPoints(int[][] questions) {
        int len=questions.length;
        long[] mem=new long[len];
        Arrays.fill(mem,-1);
        return helper(questions,0,mem,len);
    }

    public long helper(int[][] questions, int pos,long[] mem,int len){
        if(pos>=len) return 0;

        if(mem[pos]!=-1) return mem[pos];

        long ex= helper(questions,pos+1,mem,len);
        long inc= questions[pos][0] + helper(questions,pos+questions[pos][1]+1,mem,len);

        return mem[pos]=Math.max(ex,inc);
    }
}