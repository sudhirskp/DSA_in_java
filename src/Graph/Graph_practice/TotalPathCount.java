package Graph.Graph_practice;

import java.util.*;

//not pass all testcases //
public class TotalPathCount {
    static class Pair {
        int v, w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;

        // Step 1: Construct adjacency list
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adjList.get(u).add(new Pair(v, w));
            adjList.get(v).add(new Pair(u, w));
        }

        // Step 2: Use Dijkstra’s algorithm to find shortest paths
        long[] dist = new long[n]; // Stores shortest distances
        int[] ways = new int[n];   // Stores number of ways to reach a node in shortest time
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.offer(new long[]{0, 0}); // {node, distance}

        while (!pq.isEmpty()) {
            long[] node = pq.poll();
            int u = (int) node[0];
            long d = node[1];

            if (d > dist[u]) continue;

            for (Pair neigh : adjList.get(u)) {
                int v = neigh.v;
                long w = neigh.w;
                long newDist = d + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u]; // Reset count
                    pq.offer(new long[]{v, newDist});
                } else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return ways[n - 1]; // Number of ways to reach node n-1 in shortest time
    }

    public static void main(String[] args) {
        int n = 7;
        int [][]edges = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        //int edges[][] = {{1, 0, 10}};
        TotalPathCount ob = new TotalPathCount();
        System.out.println(ob.countPaths(n, edges));
    }
}
