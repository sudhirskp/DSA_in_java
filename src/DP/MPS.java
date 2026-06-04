package DP;

import java.util.Arrays;

public class MPS {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int pre = 1;
        int suff = 1;
        int max  = Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            if(pre==0) pre =1;
            if(suff==0) suff=1;
            pre *= nums[i];
            suff*= nums[n-1-i];
            max = Math.max(max,Math.max(pre,suff));
        }
        return max;
    }

    //Memoization
    public int maxProduct1(int [] nums) {
        int n = nums.length;
        int[][] memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return maxP(nums, 0, memo);
    }

    private int maxP(int[] nums,int i,int[][] memo){
        if(i==nums.length) return 0;
        if(memo[i][0]!=-1) return memo[i][0];
        if(memo[i][1]!=-1) return memo[i][1];
        int max1 = Math.max(maxP(nums,i+1,memo)*nums[i],maxP(nums,i+1,memo)/nums[i]);
        int max2 = Math.max(nums[i],1);
        memo[i][0] = max1;
        memo[i][1] = max2;
        return Math.max(max1,max2);
    }

    //Tabulation
    public int maxProduct2(int[] nums) {
        int n = nums.length;
        int[] maxP = new int[n];
        int[] minP = new int[n];
        maxP[0] = nums[0];
        minP[0] = nums[0];
        int max = nums[0];
        for(int i =1;i<n;i++){
            maxP[i] = Math.max(Math.max(maxP[i-1]*nums[i],minP[i-1]*nums[i]),nums[i]);
            minP[i] = Math.min(Math.min(maxP[i-1]*nums[i],minP[i-1]*nums[i]),nums[i]);
            max = Math.max(max,maxP[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        MPS obj = new MPS();
        System.out.println(obj.maxProduct(new int[] {2,3,-2,4}));
        System.out.println(obj.maxProduct1(new int[] {2,3,-2,4}));
        System.out.println(obj.maxProduct2(new int[] {2,3,-2,4}));
    }
}
//https://leetcode.com/problems/maximum-product-subarray/
//LeetCode 152
