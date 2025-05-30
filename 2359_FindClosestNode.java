import java.util.Arrays;
class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1==node2) return node1;
        int len=edges.length;
        int[] dist1= new int[len];
        int[] dist2= new int[len];
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        dist1[node1]=0;
        dist2[node2]=0;

        int count=0,node=edges[node1];
        while(node != -1 && dist1[node]==-1){
            dist1[node]=count++;
            node=edges[node];
        }
        
        count=0;
        node=edges[node2];
        while(node != -1 && dist2[node]==-1){
            dist2[node]=count++;
            node=edges[node];
        }

        int minDist=Integer.MAX_VALUE;
        int res=-1;
        for(int i=0;i<len;i++){
            if(dist1[i] != -1 && dist2[i] != -1){
                int dist=Math.max(dist1[i],dist2[i]);
                if(dist<minDist){
                    minDist=dist;
                    res=i;
                }
            }
        }

        if(minDist== Integer.MAX_VALUE) return -1;
        return res;

    }
}