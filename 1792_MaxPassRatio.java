import java.util.PriorityQueue;
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)-> Double.compare(b[0],a[0]));
        int len=classes.length;
        for(int i=0;i<len;i++){
            double old = (double)(classes[i][0])/(classes[i][1]);
            double ratio = (double)(classes[i][0]+1)/(classes[i][1]+1);
            pq.add(new double[]{ratio-old,i});
        }   

        for(int i=0;i<extraStudents;i++){
            double[] ar=pq.poll();
            int ind=(int)ar[1];
            classes[ind][0]++;
            classes[ind][1]++;
            double old = (double)(classes[ind][0])/(classes[ind][1]);
            double ratio = (double)(classes[ind][0]+1)/(classes[ind][1]+1);
            pq.add(new double[]{ratio-old,ind});
        }

        double res=0;
        for(int i=0;i<len;i++){
            res+=(double)(classes[i][0])/(classes[i][1]);
        }

        return res/len;
    }
}