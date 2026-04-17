package DP;

public class Partition {

        // TC: O(2^N) where N is the number of elements in the input array
        // SC: O(N) for the recursion stack
        //TLE
        int n;
        int total;
        public boolean canPartition(int[] nums) {
            n = nums.length;
            total = 0;
            for (int num : nums) total += num;

            // If total sum is odd, can't partition equally
            if (total % 2 != 0) return false;

            // Target sum for one subset
            int target = total / 2;

            return subset(0, nums, 0, target);
        }

        private boolean subset(int index, int[] nums, int currentSum, int target) {
            if (currentSum == target) return true;
            if (index >= n || currentSum > target) return false;

            // Include current element
            if (subset(index + 1, nums, currentSum + nums[index], target)) return true;

            // Exclude current element
            if (subset(index + 1, nums, currentSum, target)) return true;

            return false;
        }


        //TC: O(N*target)
        //SC: O(N*target)
        //Memoization
        public boolean canPartitionDP(int[] nums) {
            n = nums.length;
            total = 0;
            for (int num : nums) total += num;

            if (total % 2 != 0) return false;
            int target = total / 2;
            int [][] dp = new int [n][target+1];
            return subset1(0, nums, 0, target,dp);
        }

        private boolean subset1(int index, int[] nums, int currentSum, int target, int [][]dp) {
            if (currentSum == target){
                return true;
            }
            if (index >= n || currentSum > target) {
                return false;
            }

            if(dp[index][currentSum]!=0){
                return dp[index][currentSum]==1 ? true : false;
            }

            boolean fst = subset1(index + 1, nums, currentSum + nums[index], target,dp);

            boolean sec = subset1(index + 1, nums, currentSum, target,dp);

            dp[index][currentSum] = (fst || sec) ? 1 : 2;

            return fst || sec;
        }

        //TC: O(N*target)
        //SC: O(N)
        //Tabulation
    public boolean canPartitionDPT(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;
        int target = total / 2;
        boolean [] dp = new boolean [target+1];
        dp[0] = true;
        for(int num : nums){
            for(int i = target;i>=num;i--){
                if(dp[i-num]){
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        System.out.println(p.canPartition(new int []{1,5,11,5}));
        System.out.println(p.canPartitionDP(new int []{1,5,11,5}));
        System.out.println(p.canPartitionDPT(new int []{1,5,11,5}));
    }
}
//https://leetcode.com/problems/partition-equal-subset-sum/
//416. Partition Equal Subset Sum
