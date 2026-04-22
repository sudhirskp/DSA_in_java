package DP;

public class SCS {

    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = LCS(str1, str2);
        int n1 = dp.length;
        int n2 = dp[0].length;
        int i = n1 - 1;
        int j = n2 - 1;

        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i-1][j]>dp[i][j-1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }

    int [][] LCS(String s, String st){
        int n1 = s.length();
        int n2 = st.length();
        int dp [][] = new int [n1+1][n2+1];
        //Handle for zero index for dp[0][0] = 0;

        for(int i =1;i<n1+1;i++){
            for(int j =1;j<n2+1;j++){

                if(s.charAt(i-1)==st.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int c1 = dp[i-1][j];
                    int c2 = dp[i][j-1];
                    dp[i][j] = Math.max(c1,c2);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        SCS obj = new SCS();
        System.out.println(obj.shortestCommonSupersequence("abac","cab" ));
    }
}
//https://leetcode.com/problems/shortest-common-supersequence/
//LeetCode 1092
