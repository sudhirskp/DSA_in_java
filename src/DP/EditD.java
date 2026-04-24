package DP;

public class EditD {

    //Tabulation TC: n1*n2 SC:n1*n2
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1+1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < n2+1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //return opr(i - 1, j - 1, w1, w2, dp);
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int insert = dp[i-1][j] ;  //opr(i - 1, j, w1, w2, dp) + 1;
                    int del = dp[i][j-1] ;  //opr(i, j - 1, w1, w2, dp) + 1;
                    int replace = dp[i-1][j-1] ; //opr(i - 1, j - 1, w1, w2, dp) + 1;
                    dp[i][j] = 1 + Math.min(insert, Math.min(del, replace));
                }

            }
        }

        return dp[n1][n2]; //return opr(n1, n2, word1, word2,dp);
    }

    //Memoization
    public int minDistanceMemo(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int [][] dp = new int [n1+1][n2+1];
        return opr(n1, n2, word1, word2,dp);
    }

    private int opr(int i, int j, String w1, String w2, int [][]dp) {
        if (i == 0){
            dp[i][j] = j;
            return j;
        }

        if (j == 0){
            dp[i][j] = i;
            return i;
        }
        if(dp[i][j]!=0) return dp[i][j];

        if (w1.charAt(i-1) == w2.charAt(j-1)) {
            return opr(i - 1, j - 1, w1, w2,dp);
        }
        int insert = opr(i - 1, j, w1, w2,dp) + 1;
        int del = opr(i, j - 1, w1, w2,dp) + 1;
        int replace = opr(i - 1, j - 1, w1, w2,dp) + 1;
        dp[i][j] = Math.min(insert,Math.min(del,replace));
        return dp[i][j];
    }

    public static void main(String[] args) {
        EditD ob = new EditD();
        System.out.println(ob.minDistance("horse","ros"));
        System.out.println(ob.minDistanceMemo("horse","ros"));
    }
}
//LeetCode 72
