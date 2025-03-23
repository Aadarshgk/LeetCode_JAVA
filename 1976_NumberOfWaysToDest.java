import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] ar : roads) {
            adj.get(ar[0]).add(new int[]{ar[1], ar[2]});
            adj.get(ar[1]).add(new int[]{ar[0], ar[2]});
        }

        boolean[] vis = new boolean[n];
        int[] minCost = new int[n];
        int[] ways = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
        ways[0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0}); // (cost, node)

        while (!pq.isEmpty()) {
            int[] ar = pq.poll();
            int cost = ar[0];
            int node = ar[1];

            if (vis[node]) continue;

            vis[node] = true;

            for (int[] nbr : adj.get(node)) {
                if (!vis[nbr[0]]) {
                    if (cost + nbr[1] == minCost[nbr[0]]) {
                        ways[nbr[0]] = (ways[nbr[0]] + ways[node]) % 1000000007;
                    } else if (cost + nbr[1] < minCost[nbr[0]]) {
                        minCost[nbr[0]] = cost + nbr[1];
                        ways[nbr[0]] = ways[node];
                        pq.add(new int[]{minCost[nbr[0]], nbr[0]});
                    }
                }
            }
        }

        return ways[n - 1];
    }
}
