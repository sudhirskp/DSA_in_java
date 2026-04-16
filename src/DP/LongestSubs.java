package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubs {

        int n;

        //TLE //TC: O(2^n) //SC: O(n)
        public int lengthOfLIS(int[] nums) {
            n = nums.length;
            int[] count = new int[1];
            List<Integer> ls = new ArrayList<>();
            subs(0, nums, count, ls);
            return count[0];
        }

        private void subs(int index, int[] nums, int[] count, List<Integer> ls) {
            if (index == n) {
                count[0] = Math.max(count[0], ls.size());
                return;
            }

            // Option 1: take nums[index] if valid
            if (ls.isEmpty() || ls.get(ls.size() - 1) < nums[index]) {
                ls.add(nums[index]);
                subs(index + 1, nums, count, ls);
                ls.remove(ls.size() - 1);
            }

            // Option 2: skip nums[index]
            subs(index + 1, nums, count, ls);
        }

        int[][] dp;

        //Memoization //TC: O(n^2) //SC: O(n^2)
        public int lengthOfLISDP(int[] nums) {
            n = nums.length;
            // dp[index][prevIndex+1] because prevIndex can be -1
            dp = new int[n][n+1];
            for (int[] row : dp) Arrays.fill(row, -1);
            return subs(0, -1, nums);
        }

        private int subs(int index, int prevIndex, int[] nums) {
            if (index == n) return 0;

            if (dp[index][prevIndex+1] != -1) return dp[index][prevIndex+1];

            // Option 1: skip nums[index]
            int notTake = subs(index+1, prevIndex, nums);

            // Option 2: take nums[index] if valid
            int take = 0;
            if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
                take = 1 + subs(index+1, index, nums);
            }

            dp[index][prevIndex+1] = Math.max(take, notTake);
            return dp[index][prevIndex+1];
        }

        //Tabulation //TC: O(n^2) //SC: O(n)
    public int lengthOfLISDPT(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // each element is LIS of length 1

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
            LongestSubs obj = new LongestSubs();
            int [] nums = {10,9,2,5,3,7,101,18};
            System.out.println(obj.lengthOfLIS(nums));
            System.out.println(obj.lengthOfLISDP(nums));
            System.out.println(obj.lengthOfLISDPT(nums));
    }
}
//https://leetcode.com/problems/longest-increasing-subsequence/
//300. Longest Increasing Subsequence