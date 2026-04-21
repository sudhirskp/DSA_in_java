package DP;

public class LPS {

    //Tabulation //TC: O(N^2) SC: O(N^2)
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String str = new StringBuilder(s).reverse().toString();
        int dp [][] = new int [n+1][n+1];
        //now apply LCS logic
        //default val in dp is zero so no need of looping to add 0 -> 0th index handle

        for(int i =1;i<n+1;i++){
            for(int j =1;j<n+1;j++){
                if(s.charAt(i-1)==str.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    int case1 = dp[i-1][j];
                    int case2 = dp[i][j-1];
                    dp[i][j] = Math.max(case1,case2);
                }
            }
        }
        return dp[n][n];
    }


    //Space Optimized //TC: O(N^2) SC: O(N^2)
    public int longestPalindromeSubseq1(String s) {
        int n = s.length();
        String str = new StringBuilder(s).reverse().toString();
        //int dp [][] = new int [n+1][n+1];
        //space optimize with pre
        int[] pre = new int[n + 1];
        //now apply LCS logic
        //default val in dp is zero so no need of looping to add 0 -> 0th index handle

        for (int i = 1; i < n + 1; i++) {
            int[] cur = new int[n + 1];
            //cur[0] = 0; handle default
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == str.charAt(j - 1))
                    cur[j] = 1 + pre[j - 1];
                else {
                    int case1 = pre[j];
                    int case2 = cur[j - 1];
                    cur[j] = Math.max(case1, case2);
                }
            }
            pre = cur;
        }
        return pre[n];
    }

    public static void main(String[] args) {
        LPS obj = new LPS();
        System.out.println(obj.longestPalindromeSubseq("bbbab"));
        System.out.println(obj.longestPalindromeSubseq1("bbbab"));
    }
}
//https://leetcode.com/problems/longest-palindromic-subsequence/
//LeetCode 516
