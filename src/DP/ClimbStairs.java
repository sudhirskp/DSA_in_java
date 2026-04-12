package DP;

import java.util.Arrays;

public class ClimbStairs {

    //tabulation - bottom up
    public int climbStairs(int n) {
        if(n==1) return 1;
        int [] dp = new int [n+1];
        dp[1] =1;
        dp[2] =2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[dp.length-1];
    }

    //top-down - memoization
    public int climbStairs2(int n) {

        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return recur(n,dp);
    }

    private int recur(int n, int [] dp){
        if(n==1 || n==2){
            dp[0] = 0;
            //dp[1] = 1;
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        dp [n] = recur(n-1,dp) + recur(n-2,dp);
        return dp[n];
    }

    //space - optimize
    public int climbStairs3(int n) {
        if(n==1 || n==2) return n;
        int pre1 =1;
        int pre2 =2;
        int ans = 0;
        for(int i=3;i<=n;i++){
            //dp[i] = dp[i-1]+dp[i-2];
            ans = pre2 + pre1;
            pre1 = pre2;
            pre2 = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        ClimbStairs ob = new ClimbStairs();
        System.out.println(ob.climbStairs(9));
        System.out.println(ob.climbStairs2(9));
        System.out.println(ob.climbStairs3(9));
    }
}

//leet 70
