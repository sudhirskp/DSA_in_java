package Infosys_Type;

import java.util.ArrayList;
import java.util.List;

public class MaxValKCoins {

        //TC: O(2^N)
        //SC: O(2^N)
        //TLE
        int n;
        public int maxValueOfCoins(List<List<Integer>> piles, int k) {
            n = piles.size();
            return findCoins(0,piles,k);
        }

        private int findCoins(int st, List<List<Integer>> piles, int k){
            if(st==n || k==0){
                return 0;
            }

            int NoPick = findCoins(st+1,piles,k);

            int pick = 0;
            int sum  = 0;

            for(int i =0;i<Math.min(piles.get(st).size(),k);i++){
                sum+=piles.get(st).get(i);
                pick = Math.max(pick,sum + findCoins(st+1,piles,k-(i+1)));

            }
            return Math.max(NoPick,pick);
        }

        //Memoization
            int [][]dp;
            public int maxValueOfCoins1(List<List<Integer>> piles, int k) {
                n = piles.size();
                dp = new int [n][k+1];
                return findCoins1(0,piles,k);
            }

            private int findCoins1(int st, List<List<Integer>> piles, int k){
                if(st==n || k==0){
                    return 0;
                }

                if(dp[st][k]!=0) return dp[st][k];

                int NoPick = findCoins(st+1,piles,k);

                int pick = 0;
                int sum  = 0;

                for(int i =0;i<Math.min(piles.get(st).size(),k);i++){
                    sum+=piles.get(st).get(i);
                    pick = Math.max(pick,sum + findCoins(st+1,piles,k-(i+1)));

                }
                dp[st][k] = Math.max(NoPick,pick);

                return dp[st][k];
            }

            //Tabulation
            public int maxValueOfCoins2(List<List<Integer>> piles, int k) {
                n = piles.size();
                dp = new int[n + 1][k + 1];

                for (int i = 0; i < n; i++) {
                    for (int coins = 0; coins <= k; coins++) {
                        // Option 1: skip current pile
                        dp[i + 1][coins] = dp[i][coins];

                        // Option 2: take 1 to min(pile_size, coins) coins from current pile
                        int sum = 0;
                        for (int p = 0; p < piles.get(i).size() && p < coins; p++) {
                            sum += piles.get(i).get(p);
                            dp[i + 1][coins] = Math.max(dp[i + 1][coins], dp[i][coins - (p + 1)] + sum);
                        }
                    }
                }
                return dp[n][k];
            }

    public static void main(String[] args) {
        MaxValKCoins ob = new MaxValKCoins();
        List<List<Integer>> piles = new ArrayList<>();
        piles.add(List.of(1,100,3));
        piles.add(List.of(7,8,9));
        System.out.println(ob.maxValueOfCoins(piles, 2));
        System.out.println(ob.maxValueOfCoins1(piles, 2));
        System.out.println(ob.maxValueOfCoins2(piles, 2));
    }
}
//LeetCode 2218