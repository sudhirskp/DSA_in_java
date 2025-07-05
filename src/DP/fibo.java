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

    //bottom-up Approach

    public static int fibb(int n){
        int [] dp = new int [n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        int n = 10;
        int [] dp = new int [n+1];
        System.out.println("By top Down : ");
        for(int i=1;i<=n;i++){
            System.out.print(fib(i,dp) + " ");
        }
        System.out.println();
        System.out.println("By Bottom Up : ");
        for(int i=1;i<=n;i++){
            System.out.print(fibb(i) + " ");
        }

    }
}
