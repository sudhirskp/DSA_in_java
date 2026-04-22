package DP;

import java.util.Arrays;

public class UniquePath_II {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If start or end is blocked
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int [][] dp = new int [m+1][n+1];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }

        return pathCount(m, n, dp, obstacleGrid);
    }

    private int pathCount(int m, int n, int [][]dp, int [][]grid){
        // Base case: reached start cell
        if(m == 1 && n == 1){
            return grid[0][0] == 1 ? 0 : 1;
        }

        // Out of bounds or obstacle
        if(m <= 0 || n <= 0 || grid[m-1][n-1] == 1){
            return 0;
        }

        // Already computed
        if(dp[m][n] != -1) return dp[m][n];

        // Recurrence: move up or left
        int ways = pathCount(m-1, n, dp, grid) + pathCount(m, n-1, dp, grid);
        dp[m][n] = ways;
        return ways;
    }

    public static void main(String[] args) {
        UniquePath_II obj = new UniquePath_II();
        int [][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(obj.uniquePathsWithObstacles(grid));
    }
}
//https://leetcode.com/problems/unique-paths-ii/
//LeetCode 63