package DP;

import java.util.Arrays;

public class PalindromePartition {

    //Tabulation
    int [] dp;
    public int minCut(String s) {
        int n = s.length();
        dp = new int [s.length()+1];
        // Arrays.fill(dp,-1);
        // return pp(s,0);
        dp[n] = 0;

        for(int ind  = n-1; ind>=0;ind--){
            int min = Integer.MAX_VALUE;

            for (int i = ind; i < s.length(); i++) {
                if (isPalindrome(ind, i, s)) {
                    if (i == s.length() - 1) {
                        min = 0;
                    } else {
                        min = Math.min(min, 1 + dp[i+1]);
                    }
                }
            }
            dp[ind] = min;
        }
        return dp[0];

    }

    //memoization
    public int minCut1(String s) {
        dp = new int [s.length()+1];
        Arrays.fill(dp,-1);
        return pp(s,0);
    }

    private int pp(String s, int index) {
        if (index >= s.length()) return 0;
        if (dp[index] != -1) return dp[index];

        int min = Integer.MAX_VALUE;

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(index, i, s)) {
                if (i == s.length() - 1) {
                    min = 0;
                } else {
                    min = Math.min(min, 1 + pp(s, i + 1));
                }
            }
        }

        return dp[index] = min;
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition obj = new PalindromePartition();
        System.out.println(obj.minCut("aab"));
        System.out.println(obj.minCut1("ababbb"));
    }
}
//LeetCode 132