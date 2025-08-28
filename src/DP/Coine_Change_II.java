package DP;

import java.util.HashMap;
import java.util.Map;

public class Coine_Change_II {


        //by using memoization
        public int change(int amount, int[] coins) {
            if(amount==0) return 1;
            return find(coins,amount,0);
        }

        Map<String , Integer> dp = new HashMap<>();

        int find(int [] coins, int amount,int index){
            int n = coins.length;
            if(amount==0){
                return 1;
            }
            if(index==n) return 0;

            String key = amount + "-"+ index;

            if(dp.containsKey(key)){
                return dp.get(key);
            }

            int count =0;

            if(amount>=coins[index]){
                count+=find(coins,amount-coins[index],index);
            }
            count+=find(coins,amount,index+1);
            dp.put(key,count);
            return count;
        }

        //by using tabulation
            public int change1(int amount, int[] coins) {
                int n = coins.length;
                int[][] dp = new int[n+1][amount+1];

                // base case: making 0 amount
                for (int i = 0; i <= n; i++) {
                    dp[i][0] = 1;
                }

                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= amount; j++) {
                        // not taking the coin
                        dp[i][j] = dp[i-1][j];

                        // taking the coin (unlimited supply)
                        if (j >= coins[i-1]) {
                            dp[i][j] += dp[i][j - coins[i-1]];
                        }
                    }
                }

                return dp[n][amount];
            }

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        Coine_Change_II ob = new Coine_Change_II();
        System.out.println(ob.change1(5,coins));
    }
}
// //leet 518
//