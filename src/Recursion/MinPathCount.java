package Recursion;

import java.util.Arrays;

public class MinPathCount {
        int numberOfPaths(int m, int n){
            int[][] dp = new int[m][n];

            // Fill first row and column with 1
            for(int i = 0; i < m; i++) dp[i][0] = 1;
            for(int j = 0; j < n; j++) dp[0][j] = 1;

            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }

            return dp[m-1][n-1];
        }



        int[][] dp;

        int numberOfPaths1(int m, int n){
            dp = new int[m + 1][n + 1];
            for (int[] row : dp)
                Arrays.fill(row, -1);
            return helper(m, n);
        }

        int helper(int m, int n){
            if (m == 1 || n == 1) return 1;
            if (dp[m][n] != -1) return dp[m][n];
            dp[m][n] = helper(m - 1, n) + helper(m, n - 1);
            return dp[m][n];
        }



    public static void main(String[] args) {
        int[][] arr = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathCount ob = new MinPathCount();
        System.out.println(ob.numberOfPaths1(3, 3));
    }
}
