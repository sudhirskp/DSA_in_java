package Graph.Graph_practice;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        return false;
    }
    public static void main(String[] args) {
        int graph [][] = {{0,1},{1,2},{2,3},{3,4}};
        CourseSchedule ob = new CourseSchedule();
        System.out.println(ob.canFinish(5, graph));
    }
}


//207. Course Schedule
//Medium
//        Topics
//Companies
//        Hint
//There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
//
//        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
//Return true if you can finish all courses. Otherwise, return false.
//
//
//
//Example 1:
//
//Input: numCourses = 2, prerequisites = [[1,0]]
//Output: true
//Explanation: There are a total of 2 courses to take.
//To take course 1 you should have finished course 0. So it is possible.