package DP;

public class Tribonnaci {

    //bottom - up Approach
    public int triBo(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int [] dp = new int [n+1];
        dp[0] =0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }

    //top-down approach
    public int triBo2(int n){
        if(n==0) return 0;
        if(n==1 || n==2) return 1;

        int [] dp = new int [n+1];
        if(dp[n]!=0) return dp[n];

        int case1 = triBo2(n-1);
        int case2 = triBo2(n-2);
        int case3 = triBo2(n-3);

        dp[n] = case1+case2+case3;
        return case1+case2+case3;
    }

    public static void main(String[] args) {
        Tribonnaci ob = new Tribonnaci();
        System.out.println(ob.triBo2(4));

    }
}

//N-th Tribonacci Number
//Problem Description
//
//The Tribonacci sequence Tn is defined as follows:
//
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//Given n, return the value of Tn.
//
//
//Problem Constraints
//
//0 <= n <= 37
//The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
