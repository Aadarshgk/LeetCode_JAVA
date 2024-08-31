import java.util.PriorityQueue;
class Solution {
    class Pair{
        int dmg;
        int hlt;
        double ratio;
        public Pair(int dmg,int hlt,double ratio){
            this.dmg=dmg;
            this.hlt=hlt;
            this.ratio=ratio;
        }
    }
    public long minDamage(int power, int[] damage, int[] health) {
        long total= 0;
        long res=0;
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)->Double.compare(b.ratio,a.ratio));
        for(int i=0;i<damage.length;i++){
            int hit= (health[i]-1)/power + 1;
            double r= (double) damage[i]/hit;
            pq.add(new Pair(damage[i],health[i],r));
            total+=damage[i];
        }

        while(!pq.isEmpty()){
            Pair enemy= pq.remove();
            int hit= (enemy.hlt -1)/ power +1;
            res+=hit*total;
            total-=enemy.dmg;
        }
        return res;
    }
}