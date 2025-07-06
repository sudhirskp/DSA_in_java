package DP;

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
    public static void main(String[] args) {
        MinPathSum ob = new MinPathSum();
        int [][] arr = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(ob.minPath(arr, 0, 0));
    }
}
