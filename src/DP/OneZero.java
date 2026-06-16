package DP;

import java.util.Arrays;

public class OneZero {

    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }

        return dp[m][n];
    }

    int len;
    int max = -1;
    int dp[][][];
    public int findMaxForm1(String[] strs, int m, int n) {
        len = strs.length;
        dp= new int [len+1][m+1][n+1];

        for (int[][] arr : dp) {
            for (int[] row : arr) {
                Arrays.fill(row, -1);
            }
        }
        return find(0,strs,m,n);
    }
    private int find(int index, String [] str, int m, int n){

        if(index==len){
            return 0;
        }

        if(dp[index][m][n]!=-1){
            return dp[index][m][n];
        }

        int one = (int)str[index].chars().filter(ch -> ch == '1').count();

        int zero = (int)str[index].chars().filter(ch -> ch == '0').count();

        //System.out.print(one + " ");

        int pick = 0;
        if(one <=n &&  zero <= m){
            pick = 1 + find(index+1,str,m-zero,n-one);
        }

        int noPick = find(index+1,str,m,n);

        return dp[index][m][n] = Math.max(noPick,pick);
    }


    public static void main(String[] args) {
        OneZero obj = new OneZero();
        System.out.println(obj.findMaxForm(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
        System.out.println(obj.findMaxForm1(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3));
    }
}
//Leetcode 474