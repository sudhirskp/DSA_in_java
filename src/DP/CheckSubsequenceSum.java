package DP;

public class CheckSubsequenceSum {

    public static boolean checkSubsequenceSum(int N, int[] arr, int K) {
        // code here
        // boolean dp [] = new boolean [N+1];
        //Arrays.fill(dp,-1);
        return check(N-1,arr,K);
    }

    private static boolean check(int n, int [] arr, int target){

        if(target==0){
            //dp[n] = true;
            return true;
        }

        if(n==0){
            if(target==arr[n]){
                //dp[n] = true;
                return true;
            }
            //dp[n] = false;
            return false;
        }

        // if(dp[n]!=false){
        //     return true;
        // }

        boolean pick = false;
        if(target>=arr[n]){
            pick = check(n-1,arr,target-arr[n]);
            if(pick) return true;
        }

        boolean Nopick = check(n-1,arr,target);

        //dp[n] = pick || Nopick;

        return Nopick;
    }

    //memoization - top-down
    public static boolean checkSubsequenceSumDP(int N, int[] arr, int K) {
        // code here
        int dp [][] = new int [N][K+1];
        //int dp
        //0 -> not visited
        //1 -> true
        //2 -> false;
        //Arrays.fill(dp,-1);
        return checkDP(N-1,arr,K,dp);
    }

    private static boolean checkDP(int n, int [] arr, int target, int [][] dp){

        if(target==0){
            dp[n][target] = 1;
            return true;
        }

        if(n==0){
            if(target==arr[n]){
                dp[n][target] = 1;
                return true;
            }
            //dp[n] = false;
            dp[n][target] = 2;
            return false;
        }

         if(dp[n][target]!=0){
             if(dp[n][target]==1) return true;
             if(dp[n][target]==2) return false;
         }

        boolean pick = false;
        if(target>=arr[n]){
            pick = checkDP(n-1,arr,target-arr[n],dp);
            if(pick){
                dp[n][target] = 1;
                return true;
            }
        }

        boolean Nopick = checkDP(n-1,arr,target,dp);

        if(Nopick){
            dp[n][target] = 1;
        }else{
            dp[n][target] = 2;
        }

        return Nopick;
    }

    //Tabulation, bottom-up
    public static boolean checkSubsequenceSumTabu(int N, int[] arr, int K) {
        // code here
        int [][] dp = new int [N][K+1];
        for(int i =0;i<N;i++) {
            dp[i][0] = 1;
        }

        for(int i =1;i<=K;i++){
            if(i==arr[0]){
                dp[0][i] = 1;
            }else{
                dp[0][i] = 2;
            }
        }

        for(int i =1 ;i<N;i++){
            for(int j=1;j<=K;j++){
                int pick = 2;
                if(j>=arr[i]){
                    //pick = checkDP(n-1,arr,target-arr[n],dp);
                    pick = dp[i-1][j-arr[i]];
                    if(pick==1){
                        dp[i][j] = 1;
                        continue;
                    }
                }

                //boolean Nopick = checkDP(n-1,arr,target,dp);
                int NoPick = dp[i-1][j];
                dp[i][j] = NoPick;
            }
        }
        return dp[N-1][K]==1;
    }

    //space optimize tabulation
    public static boolean checkSubsequenceSumTabuS(int N, int[] arr, int K) {
        // code here
        //int [][] dp = new int [N][K+1];
        int [] pre = new int [K+1];
//        for(int i =0;i<N;i++) {
//            dp[i][0] = 1;
//        }
         pre[0] = 1;

        for(int i =1;i<=K;i++){
            if(i==arr[0]){
                pre[i] = 1;
            }else{
                pre[i] = 2;
            }
        }

        for(int i =1 ;i<N;i++){
            int [] cur = new int [K+1];
            cur[0] = 1;
            for(int j=1;j<=K;j++){
                int pick = 2;
                if(j>=arr[i]){
                    //pick = checkDP(n-1,arr,target-arr[n],dp);
                    pick = pre[j-arr[i]];
                    if(pick==1){
                        cur[j] = 1;
                        continue;
                    }
                }

                //boolean Nopick = checkDP(n-1,arr,target,dp);
                int NoPick = pre[j];
                cur[j] = NoPick;
            }
            pre = cur;
        }
        return pre[K]==1;
    }




    public static void main(String[] args){
        System.out.println(checkSubsequenceSum(7,new int []{10,1,2,7,6,1,5},8));
        System.out.println(checkSubsequenceSumDP(7,new int []{10,1,2,7,6,1,5},8));
        System.out.println(checkSubsequenceSumTabu(7,new int []{10,1,2,7,6,1,5},8));
        System.out.println(checkSubsequenceSumTabuS(7,new int []{10,1,2,7,6,1,5},8));
    }
}
//https://www.geeksforgeeks.org/problems/check-if-there-exists-a-subsequence-with-sum-k/0