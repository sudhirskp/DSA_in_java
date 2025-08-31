package Grind75;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //int n = prerequisites.length;

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }

            for (int[] node : prerequisites) {
                int v = node[0];
                int u = node[1];
                adj.get(u).add(v);
            }

            //Stack<Integer> stk = new Stack<>();
            boolean[] visited = new boolean[numCourses];
            boolean [] pathVisited = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (!visited[i]) {
                    if (!dfs(i, visited, pathVisited, adj))
                        return false;
                }
            }
            return true;

        }

        public boolean dfs(int u,boolean[] visited, boolean [] path, List<List<Integer>> adj) {
            visited[u] = true;
            path[u] = true;

            for (int node : adj.get(u)) {
                if (!visited[node]) {
                    if(!dfs(node,visited,path,adj))return false;

                }else if(path[node]) return false;

            }
            path[u] = false;
            return true;
        }

    public static void main(String[] args) {
            int arr [][] = {{1,0},{0,1}};
            Course_Schedule ob = new Course_Schedule();
        System.out.println(ob.canFinish(2,arr));
    }
}
//leetcode - 207
//link - https://leetcode.com/problems/course-schedule/description/
