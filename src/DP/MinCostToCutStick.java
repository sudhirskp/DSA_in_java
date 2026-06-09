package DP;

import java.util.Arrays;

public class MinCostToCutStick {

    int [] rod;
    int [][]dp;
    //Tabulation
    public int minCost(int n, int[] cuts) {
        rod = new int [cuts.length+2];
        rod[0] = 0;
        rod[rod.length-1] = n;
        Arrays.sort(cuts);

        dp = new int [rod.length+1][rod.length+1];

        for(int i=1;i<rod.length-1;i++) rod[i] = cuts[i-1];

        for (int L = 2; L < rod.length; L++) {  // L = length of interval (in terms of indices)
            for (int i = 0; i + L < rod.length; i++) {
                int j = i + L;
                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible cut k between i and j
                for (int k = i + 1; k < j; k++) {
                    int cost = rod[j] - rod[i] + dp[i][k] + dp[k][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][rod.length - 1];
    }

    public int minCost1(int n, int[] cuts) {
        rod = new int [cuts.length+2];
        rod[0] = 0;
        rod[rod.length-1] = n;
        Arrays.sort(cuts);

        dp = new int [rod.length+1][rod.length+1];
        for(int [] d: dp) Arrays.fill(d,-1);

        for(int i=1;i<rod.length-1;i++) rod[i] = cuts[i-1];
        return cut(1,rod.length-2);
    }


    private int cut(int i, int j){
        if(i>j){
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int min= Integer.MAX_VALUE;
        for(int k =i;k<=j;k++){
            int cost = rod[j+1] - rod[i-1] + cut(i,k-1)+cut(k+1,j);
            min = Math.min(min,cost);
            dp[i][j] = min;
        }
        return dp[i][j];
    }
    public static void main(String[] args) {
        MinCostToCutStick obj = new MinCostToCutStick();
        System.out.println(obj.minCost(7, new int[] {1,3,4,5}));
        System.out.println(obj.minCost1(7, new int[] {1,3,4,5}));
    }
}
//leetcode 1547 hard