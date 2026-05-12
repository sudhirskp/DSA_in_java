package DP;

public class UniquePath {

    //Memoization //TC: O(N^2) SC: O(N^2)
    public int uniquePaths(int m, int n) {
        if(m==0 || n ==0 ) return 0;
        int [][] dp = new int [m+1][n+1];
        return pathCount(0,0,m,n,dp);
    }

    public int pathCount(int i , int j , int m , int n,int [][]dp){

        if(i==m-1) return 1;
        if(j==n-1) return 1;

        if(i>m || j > n) return 0;

        if(dp[i][j]!=0) return dp[i][j];

        int down = pathCount(i+1,j,m,n,dp);
        int right = pathCount(i,j+1,m,n,dp);

        dp[i][j] = down+right;
        return down+right;
    }


    //Tabulation //TC: O(N^2) SC: O(N^2)
    public int uniquePathsTB(int m, int n) {
        int [][] dp = new int [m+1][n+1];
        // for(int [] d : dp){
        //     Arrays.fill(d,-1);
        // }
        for(int i = 0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i = 0;i<n;i++){
            dp[0][i] = 1;
        }

        for(int i =1;i<m+1;i++){
            for(int j =1;j<n+1;j++){
                int way = dp[i-1][j] + dp[i][j-1];
                dp[i][j] = way;
            }
        }
        return dp[m-1][n-1];
    }

    //Math //TC: O(N) SC: O(1)
    public int uniquePaths2(int m, int n) {
        int total = m + n -2;
        int down = m -1;

        long res  = 1;

        for(int i =1;i<=down;i++){
            res  = res * (total - down + i)/i;
        }

        return (int)res;
    }


    public static void main(String[] args) {
        UniquePath obj = new UniquePath();
        System.out.println(obj.uniquePaths(3,7));
        System.out.println(obj.uniquePathsTB(3,7));
        System.out.println(obj.uniquePaths2(3,7));
    }
}
//https://leetcode.com/problems/unique-paths/
//LeetCode 62
