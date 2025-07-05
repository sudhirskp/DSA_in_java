package DP;

public class fibo {

    //top-Down Approach
    public static int fib(int n , int [] dp){
        if(n==0 || n==1) return n;
        if(dp[n]!=0) return dp[n];
        int x = fib(n-1,dp);
        int y = fib(n-2,dp);
        dp[n] = x+y;
        return x+y;
    }
    public static void main(String[] args) {
        int n = 5;
        int [] dp = new int [n+1];
        for(int i=1;i<=n;i++){
            System.out.print(fib(i,dp) + " ");
        }
    }
}
