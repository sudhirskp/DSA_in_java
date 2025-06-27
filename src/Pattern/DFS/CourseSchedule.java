package Pattern.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>();
            int indegree[] = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] pre : prerequisites) {
                int u = pre[1];
                int v = pre[0];
                adjList.get(u).add(v);
                indegree[v]++;
            }

            Queue<Integer> que = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    que.offer(i);
                }
            }

            List<Integer> res = new ArrayList<>();
            while (!que.isEmpty()) {
                int val = que.poll();
                res.add(val);
                for (int node : adjList.get(val)) {
                    indegree[node]--;
                    if (indegree[node] == 0)
                        que.offer(node);
                }
            }

            if(res.size() != numCourses) return new int [0];

            int[] result = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                result[i] = res.get(i);
            }

            return result;
        }
    public static void main(String[] args) {
            CourseSchedule courseSchedule = new CourseSchedule();
            int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
            int[] result = courseSchedule.findOrder(4, prerequisites);
            for(int i : result){
                System.out.print(i + " ");
            }
    }
}


//210. Course Schedule II
//
//Topics
//premium lock icon
//        Companies
//Hint
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
//
//
//
//        Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: [0,1]
//Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].