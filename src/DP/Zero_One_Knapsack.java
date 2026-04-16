package DP;

import java.util.Arrays;

public class Zero_One_Knapsack {

    //TLE //TC: O(2^n) //SC: O(n)
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        return fill(n-1,W,val,wt);

    }

    private int fill(int index, int W, int [] val, int [] w){
        if(W==0){
            return 0;
        }

        if(index==0){
            if(w[index]<=W){
                return val[index];
            }else{
                return 0;
            }
        }

        int pick  =0;
        if(w[index]<=W){
            pick = val[index] + fill(index-1,W-w[index],val,w);
        }
        int NoPick = 0 + fill(index-1,W,val,w);

        return Math.max(pick,NoPick);
    }


    //Memoization //TC: O(n^2) //SC: O(n^2)
    public int knapsackDP(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int [][] dp = new int [n+1][W+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return fill(n-1,W,val,wt,dp);

    }

    private int fill(int index, int W, int [] val, int [] w, int [][] dp){
        if(W==0){
            dp[index][0] = 0;
            return 0;
        }

        if(index==0){
            if(w[index]<=W){
                dp[0][W] = val[index];
                return val[index];
            }else{
                dp[0][W]= 0;
                return 0;
            }
        }

        if(dp[index][W]!=-1) return dp[index][W];

        int pick  =0;
        if(w[index]<=W){
            pick = val[index] + fill(index-1,W-w[index],val,w,dp);
        }
        int NoPick = 0 + fill(index-1,W,val,w,dp);

        dp[index][W] = Math.max(pick,NoPick);

        return dp[index][W];
    }

    //Tabulation //TC: O(n^2) //SC: O(n^2)
    public int knapsackDPT(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int [][] dp = new int [n][W+1];

        for(int i =0;i<n;i++){
            dp[i][0] = 0;
        }

        for(int w = 0;w<W+1;w++){
            //for index 0
            if(wt[0]<=w){
                dp[0][w] = val[0];
            }else{
                dp[0][w]= 0;
            }
        }

        for(int i = 1;i<n;i++){
            for(int j =0;j<W+1;j++){
                int pick  =0;
                if(wt[i]<=j){
                    pick = val[i] + dp[i-1][j-wt[i]]; //fill(index-1,W-w[index],val,w,dp);
                }
                int NoPick = dp[i-1][j]; //fill(index-1,W,val,w,dp);

                dp[i][j] = Math.max(pick,NoPick);
            }
        }
        return dp[n-1][W];
    }

    public static void main(String[] args) {
        Zero_One_Knapsack obj = new Zero_One_Knapsack();
        System.out.println(obj.knapsack(4,new int []{1,2,3},new int []{4,5,1}));
        System.out.println(obj.knapsackDP(4,new int []{1,2,3},new int []{4,5,1}));
        System.out.println(obj.knapsackDPT(4,new int []{1,2,3},new int []{4,5,1}));
    }
}
//https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
