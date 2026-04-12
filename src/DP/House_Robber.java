package DP;

import java.util.Arrays;

public class House_Robber {

    int  n;
    //bottom-up - tabulation
    public  int rob(int[] nums) {
        n = nums.length;
        int [] dp = new int [n+1];

        dp[1] = nums[0];
        dp[0] = 0;
        for(int i = 2;i<=n;i++){
            int pick =  nums[i-1]+dp[i-2];
            int no = dp[i-1];
            dp[i] = Math.max(pick,no);
        }
        return dp[n];
    }

    //top-down - memoization //shifting logic

    public int rob1(int[] nums) {
        n = nums.length;
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return chori(n,nums,dp);
    }

     private int chori(int index, int [] nums, int [] dp){
         if(index==1){
             dp[index] = nums[0];
             return nums[0];
         }

         if(index==0){
             dp[index] = 0;
             return 0;
         }

         if(dp[index]!=-1){
             return dp[index];
         }

         int pick =  nums[index-1]+chori(index-2,nums,dp);
         int no = chori(index-1,nums,dp);

         dp[index] = Math.max(pick,no);
         return dp[index];
     }

    public static void main(String[] args) {
        House_Robber ob = new House_Robber();
        System.out.println(ob.rob(new int []{1,2,3,1}));
        System.out.println(ob.rob1(new int []{1,2,3,1}));
    }
}
//LeetCode 198