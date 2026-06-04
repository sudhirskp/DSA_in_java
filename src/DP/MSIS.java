package DP;

import java.util.Map;
import java.util.TreeMap;

public class MSIS {

    public int maxSumIS(int arr[]) {
        // code her
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        int ans = 0;

        for (int val : arr) {

            // Find the best sum among
            // all elements smaller than val
            Map.Entry<Integer, Integer> entry = dp.lowerEntry(val);
            int bestSmaller = (entry == null) ? 0 : entry.getValue();

            int currSum = bestSmaller + val;

            // If this value gives a
            // better sum, update TreeMap
            if (dp.getOrDefault(val, 0) < currSum) {
                dp.put(val, currSum);

                // Remove entries with greater
                // keys with smaller or equal sums
                Integer higher = dp.higherKey(val);
                while (higher != null && dp.get(higher) <= currSum) {
                    dp.remove(higher);
                    higher = dp.higherKey(val);
                }
            }

            ans = Math.max(ans, currSum);
        }

        return ans;
    }

    //Memoization
    int n;
    int [][] dp;
    public int maxSumIS2(int arr[]) {
        // code her
        n = arr.length;
        dp = new int [n+1][n+1];
        return find(0,-1,arr);
    }

    int max = Integer.MIN_VALUE;
    //int sum1 = 0;
    //int sum2  = 0;

    private int find(int index, int pre, int [] arr){
        if(index==n){
            return 0;
        }

        if(dp[index][pre+1]!=0) return dp[index][pre+1];

        if(pre==-1 || arr[pre]<arr[index]){
            dp[index][pre+1] = Math.max(arr[index] + find(index+1,index,arr),find(index+1,pre,arr));

        }else{
            dp[index][pre+1] = find(index+1,pre,arr);
        }

        return dp[index][pre+1];
    }

    //Tabulation

    public int maxSumIS3(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];

        // Step 1: Initialize dp with arr[i]
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }

        // Step 2: Build dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        // Step 3: Find max sum
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }
    public static void main(String[] args) {
        MSIS obj = new MSIS();
        System.out.println(obj.maxSumIS(new int[] {1, 101, 2, 3, 100, 4, 5}));
        System.out.println(obj.maxSumIS2(new int[] {1, 101, 2, 3, 100, 4, 5}));
        System.out.println(obj.maxSumIS3(new int[] {1, 101, 2, 3, 100, 4, 5}));
    }
}
//https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1