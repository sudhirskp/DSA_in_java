package Graph.Graph_practice;

import java.util.*;

public class Grid {
        public int[] maxPoints(int[][] grid, int[] queries) {
            int n = grid.length, m = grid[0].length;
            int[] ans = new int[queries.length];

            // Directions for 4-way movement (up, down, left, right)
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            // Priority Queue (Min-Heap) based on grid value
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

            // Insert the top-left (0,0) into PQ
            pq.offer(new int[]{grid[0][0], 0, 0});
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;

            // Store queries with original indices
            int[][] indexedQueries = new int[queries.length][2];
            for (int i = 0; i < queries.length; i++) {
                indexedQueries[i] = new int[]{queries[i], i};
            }

            // Sort queries in ascending order
            Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[0]));

            int count = 0; // Number of reachable cells
            int lastQuery = 0; // Last processed query value

            for (int[] q : indexedQueries) {
                int queryValue = q[0], index = q[1];

                // Process cells in priority queue while their values < queryValue
                while (!pq.isEmpty() && pq.peek()[0] < queryValue) {
                    int[] cell = pq.poll();
                    int value = cell[0], x = cell[1], y = cell[2];
                    count++;

                    // Explore neighbors
                    for (int d = 0; d < 4; d++) {
                        int newX = x + dx[d], newY = y + dy[d];

                        if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY]) {
                            pq.offer(new int[]{grid[newX][newY], newX, newY});
                            visited[newX][newY] = true;
                        }
                    }
                }

                // Store the result for this query
                ans[index] = count;
            }

            return ans;
        }


    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{2,5,7},{3,5,1}};
        int [] queries = {5,6,2};
        Grid  ob = new Grid();
        for(int a : ob.maxPoints(grid, queries)){
            System.out.print(a + " ");
        }
    }
}
