package DP;

import java.util.Arrays;

public class LCS {

    //TC: O(N1*N2) SC: O(N1*N2) - Memoization
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }

        return Sub(0, 0, text1, text2, dp);
    }

    private int Sub(int ind1, int ind2, String text1, String text2, int[][] dp) {
        if (ind1 == text1.length() || ind2 == text2.length()) {
            dp[ind1][ind2] = 0;
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        int pick = 0;
        int No1 = 0;
        int No2 = 0;
        int NoPick = 0;
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            pick = 1 + Sub(ind1 + 1, ind2 + 1, text1, text2,dp);
        } else {
            No1 = 0 + Sub(ind1 + 1, ind2, text1, text2,dp);
            No2 = 0 + Sub(ind1, ind2 + 1, text1, text2,dp);
            NoPick = Math.max(No1, No2);
        }

        dp[ind1][ind2] = Math.max(pick, NoPick);

        return dp[ind1][ind2];
    }

    //Tabulation //TC: O(N1*N2) SC: O(N1*N2)
    public int longestCommonSubsequenceTB(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();

        int[][] dp = new int[n1 +  1][n2 + 1];

        //    for (int d[] : dp) {
        //          Arrays.fill(d, -1);
        //     }

        dp[0][0] = 0;

        for(int i = 1 ; i<n1+1 ;i++){
            for(int j =1;j<n2+1;j++){

                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 +dp[i-1][j-1];  //Sub(ind1 + 1, ind2 + 1, text1, text2,dp);
                } else {
                    int No1 = 0 + dp[i-1][j]; //Sub(ind1 + 1, ind2, text1, text2,dp);
                    int No2 = 0 + dp[i][j-1];//Sub(ind1, ind2 + 1, text1, text2,dp);
                    dp[i][j] = Math.max(No1,No2);
                }
            }
        }
        return dp[n1][n2];
        //return Sub(0, 0, text1, text2, dp);
    }


    public static void main(String[] args) {
        LCS ob = new LCS();
        System.out.println(ob.longestCommonSubsequence("abcde", "ace"));
        System.out.println(ob.longestCommonSubsequenceTB("abcde", "ace"));
    }
}
//https://leetcode.com/problems/longest-common-subsequence/
//LeetCode 1143