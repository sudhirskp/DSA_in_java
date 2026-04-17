package DP;

import java.util.Arrays;

public class Coine_Change {

    //Memoization
    //TC: O(N*target)
    //SC: O(N*target)
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int [n][amount+1];

        for(int d [] : dp){
            Arrays.fill(d,-1);
        }

        int res = combination(n-1, coins,amount,dp);
        if(res==(int)(1e9)){
            return -1;
        }
        return res;
    }

    private int combination(int index, int [] coins , int amount,int [][]dp){

        if(index==0){
            if(amount % coins[index]==0){
                dp[index][amount] = amount/coins[index];
                return amount/coins[index];
            }
            dp[index][amount] = (int)(1e9);
            return (int)(1e9);
        }

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        int pick = (int)(1e9);
        if(amount>=coins[index]){
            pick = 1 + combination(index,coins,amount-coins[index],dp);
        }
        int NoPick = 0 + combination(index-1,coins,amount,dp);

        dp[index][amount] = Math.min(pick,NoPick);
        return dp[index][amount];
    }

    //Tabulation
    //TC: O(N*target)
    //SC: O(N*target)
    public int coinChangeDPT(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int a = 0; a < amount + 1; a++) {
            if (a % coins[0] == 0) {
                dp[0][a] = a / coins[0];
            }else{
                dp[0][a] = (int) (1e9);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                int pick = (int)(1e9);
                if (j >= coins[i]) {
                    pick = 1 + dp[i][j-coins[i]]; //(index, coins, amount - coins[index], dp);
                }
                int NoPick = dp[i-1][j];//(index - 1, coins, amount, dp);
                dp[i][j]  = Math.min(NoPick,pick);
            }

        }

        if(dp[n-1][amount]==(int)(1e9)) return -1;
        return dp[n-1][amount];
    }

    public static void main(String[] args) {
        Coine_Change ob = new Coine_Change();
        System.out.println(ob.coinChange(new int []{1,2,5},11));
    }
}
