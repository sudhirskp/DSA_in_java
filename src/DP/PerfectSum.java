package DP;

import java.util.Arrays;

public class PerfectSum {

    //TLE 2^1000
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        return count(n-1,target,nums);
    }

    private int count(int index, int tr, int [] arr){
        if(index==0){
            if(tr==0 && arr[0]==0){
                return 2;
            }else if(tr==0) return 1;
            else if(tr==arr[0]) return 1;
            else return 0;
        }

        int pick =0;

        if(tr>=arr[index]){
            pick = count(index-1,tr-arr[index],arr);
        }
        int NoPick = count(index-1,tr,arr);

        return pick + NoPick;
    }

    //memoization
    public int perfectSumDp(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp = new int [n][target+1];
        for(int [] d : dp){
            Arrays.fill(d,-1);
        }
        return count(n-1,target,nums,dp);
    }

    private int count(int index, int tr, int [] arr, int [][] dp){
        if(index==0){
            if(tr==0 && arr[0]==0){
                dp[0][0] = 2;
                return 2;
            }else if(tr==0){
                dp[0][0] = 1;
                return 1;
            }
            else if(tr==arr[0]){
                dp[0][tr] = 1;
                return 1;
            }
            else{
                dp[0][0] = 0;
                return 0;
            }
        }

        if(dp[index][tr]!=-1){
            return dp[index][tr];
        }

        int pick =0;

        if(tr>=arr[index]){
            pick = count(index-1,tr-arr[index],arr,dp);
        }
        int Nopick = count(index-1,tr,arr,dp);

        dp[index][tr] = pick + Nopick;

        return dp[index][tr];
    }

    //Tabulation
    public int perfectSumTabu(int[] nums, int target) {
        // code here
        int n = nums.length;
        int [][] dp = new int [n][target+1];
        // for(int [] d : dp){
        //     Arrays.fill(d,-1);
        // }

        for(int tr = 0;tr<=target;tr++){
            if(tr==0 && nums[0]==0){
                dp[0][tr] = 2;
            }else if(tr==0){
                dp[0][tr] = 1;
            }
            else if(tr==nums[0]){
                dp[0][tr] = 1;
            }
            else{
                dp[0][tr] = 0;
            }
        }

        for(int index =1;index<n;index++){
            for(int j = 0;j<=target;j++){
                int pick = 0;
                if(j>=nums[index]){
                    //pick = count(index-1,j-arr[index],arr,dp);
                    pick = dp[index-1][j-nums[index]];
                }
                //int Nopick = count(index-1,j,arr,dp);
                int no = dp[index-1][j];
                dp[index][j] = pick + no;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        PerfectSum ob = new PerfectSum();
        int arr[] = {5, 2, 3, 10, 6, 8}; int  target = 10;
        System.out.println(ob.perfectSum(arr,target));
        System.out.println(ob.perfectSumDp(arr,target));
        System.out.println(ob.perfectSumTabu(arr,target));
    }
}
//https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/0