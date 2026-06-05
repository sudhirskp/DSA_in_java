package DP;

import java.util.Arrays;

public class MinPathSum {

    //top-down - approach
    public int minPath(int [][] arr , int r , int c){
        int row = arr.length;
        int col = arr[0].length;
        int [][] dp = new int [row+1][col+1];
        if(r >= row || c >= col) return Integer.MAX_VALUE;
        if(r == row-1 && c == col-1) return arr[r][c];

        if(dp[r][c]!=0) return dp[r][c];

        int right = minPath(arr,r,c+1);
        int bottom = minPath(arr,r+1,c);

        dp[r][c] = arr[r][c] + Math.min(right, bottom);
        return arr[r][c] + Math.min(right,bottom);
    }

    int n;
    int m;
    int [][] dp;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int [m+1][n+1];
        for(int [] d : dp) Arrays.fill(d,Integer.MAX_VALUE);
        return findSum(0,0,grid);
    }

    private int findSum(int r, int c, int [][] grid){
        if(r==m-1 && c==n-1){
            dp[r][c] = grid[r][c];
            return dp[r][c];
        }
        if(r>=m || c>=n){
            return dp[r][c] = Integer.MAX_VALUE;
        }

        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];

        int rowSum = findSum(r+1,c,grid);
        int colSum = findSum(r,c+1,grid);
        dp[r][c] = grid[r][c] + Math.min(rowSum,colSum);
        return dp[r][c];
    }

    //Tabulation
    public int minPathSum1(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m + 1][n + 1];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int rowSum = dp[i-1][j];//findSum(r + 1, c, grid);
                int colSum = dp[i][j-1];//findSum(r, c + 1, grid);
                dp[i][j] = grid[i][j] + Math.min(rowSum, colSum);
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        MinPathSum ob = new MinPathSum();
        int [][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(ob.minPath(arr, 0, 0));
        System.out.println(ob.minPathSum(arr));
        System.out.println(ob.minPathSum1(arr));
    }
}

//LeetCode 64
