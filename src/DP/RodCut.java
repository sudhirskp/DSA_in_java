package DP;

public class RodCut {

    //Memoization
    //TC: O(N*target)
    //SC: O(N*target)
    public int cutRod(int[] price) {
        // code here
        int n = price.length;
        int [][] dp = new int[n][n+2];
        return Cut(n-1,n,price,dp);
    }

    private int Cut(int index, int rod, int [] price, int [][] dp){
        if(index==0){
            dp[0][rod] = rod*price[0];
            return rod*price[0]; //index == 0
        }

        if(dp[index][rod]!=0){
            return dp[index][rod];
        }


        int cut = 0;
        int curlen = index+1;

        if(rod>=curlen){
            cut = price[index] + Cut(index,rod-curlen,price,dp);
        }

        int notCut = Cut(index-1,rod,price,dp);

        dp[index][rod] = Math.max(cut,notCut);

        return dp[index][rod];
    }


    //Tabulation
    //TC: O(N*target)
    //SC: O(N*target)
    public int cutRodDPT(int[] price) {
        // code here
        int n = price.length;
        int [][] dp = new int[n][n+1];

        for(int r=0; r<n+1;r++){
            dp[0][r] = r*price[0];
        }

        for(int i =1;i<n;i++){
            for(int j =0;j<n+1;j++){

                int cut = 0;
                int curlen = i+1;
                if(j>=curlen){
                    cut = price[i] + dp[i][j-curlen]; //Cut(index,rod-curlen,price,dp);
                }

                int notCut = dp[i-1][j]; //Cut(index-1,rod,price,dp);

                dp[i][j] = Math.max(cut,notCut);
            }
        }
        return dp[n-1][n];
    }

    public static void main(String[] args) {
        RodCut ob = new RodCut();
        System.out.println(ob.cutRod(new int []{3,5,8,7,10,13,17,18}));
        System.out.println(ob.cutRodDPT(new int []{3,5,8,7,10,13,17,18}));
    }
}
//https://www.geeksforgeeks.org/problems/rod-cutting0840/1