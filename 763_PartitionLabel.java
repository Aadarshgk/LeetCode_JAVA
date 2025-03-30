import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] ar= new int[26][2];
        for(int[] a: ar){
            a[0]=-1;
            a[1]=-1;
        }   

        int len=s.length();
        for(int i=0;i<len;i++){
            int c1=s.charAt(i)-'a';
            int c2=s.charAt(len-i-1)-'a';
            if(ar[c1][0]==-1){
                ar[c1][0]=i;
            }

            if(ar[c2][1]==-1){
                ar[c2][1]=len-i-1;
            }
        }

        Arrays.sort(ar,(a,b)->a[0]-b[0]);

        List<int[]> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(ar[i][0]==-1) continue;
            int size=list.size();
            if(size==0 || list.get(size-1)[1]<ar[i][0]){
                list.add(ar[i]);
            }else{
                list.get(size-1)[1]=Math.max(list.get(size-1)[1],ar[i][1]);
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int[] a: list){
            res.add(a[1]-a[0]+1);
        }

        return res;

    }
}