package DP;

import java.util.Arrays;

public class MCM {

    //Memoization
    //TC : O(N^3)
    //SC : O(N^2) + O(N)
    static int [][]dp;
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int [n+1][n+1];
        for(int [] d : dp) Arrays.fill(d,-1);
        return MCM(1,n-1,arr);
    }

    static int MCM(int i, int j, int [] arr){

        if(i==j){
            dp[i][i] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];

        for(int k = i;k<j;k++){
            int steps = (arr[i-1]*arr[k]*arr[j])+MCM(i,k,arr)+MCM(k+1,j,arr);
            min = Math.min(min,steps);

        }
        dp[i][j] = min;
        return min;
    }

    static int matrixMultiplication1(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int [n][n];
        //for(int [] d : dp) Arrays.fill(d,-1);
        //return MCM(1,n-1,arr);

        for(int i =n-1;i>=1;i--){
            for(int j = i+1;j<n;j++){
                int min = Integer.MAX_VALUE;
                for(int k =i;k<j;k++){
                    int steps = (arr[i-1]*arr[k]*arr[j])+dp[i][k]+dp[k+1][j];//MCM(i,k,arr)+MCM(k+1,j,arr);
                    min = Math.min(min,steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int [] arr = {2, 1, 3, 4};
        System.out.println(matrixMultiplication(arr));
        System.out.println(matrixMultiplication1(arr));
    }
}
