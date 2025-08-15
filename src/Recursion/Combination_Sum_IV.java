package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combination_Sum_IV {

        //1st approach - TLE
        //cur is only for printing - current combination
        public int combinationSum4(int[] nums, int target) {
            int n = nums.length;
            int [] ans = new int [1];
            Combinations(nums,ans,target,new ArrayList<>());
            return ans[0];
        }

        private void Combinations(int [] nums, int [] ans , int target, List<Integer> cur){
            if(target<=0){
                if(target==0){
                    System.out.println(cur);
                    ans[0]++;
                }
                return;
            }


            for(int i=0;i<nums.length;i++){
                cur.add(nums[i]);
                Combinations(nums,ans,target-nums[i],cur);
                cur.remove(cur.size()-1);

            }
        }

        //2nd approach - TLE
        public int combinationSum41(int[] nums, int target) {
            int n = nums.length;
            int ans = Combinations1(nums,target,new ArrayList<>());
            return ans;
        }


        private int Combinations1(int [] nums, int target,List<Integer> cur){
            int ans =0;
            if(target<=0){
                if(target==0){
                    System.out.print(ans + " ");
                    System.out.println(cur);
                    return 1;
                }
                return 0;
            }

            for(int i=0;i<nums.length;i++){
                if(nums[i]<=target){
                    cur.add(nums[i]);
                    ans += Combinations1(nums,target-nums[i],cur);
                    cur.remove(cur.size()-1);
                }

            }
            return ans;
        }

        //3rd approach - using memoization


        public int combinationSum43(int[] nums, int target) {
            HashMap<Integer,Integer> dp  = new HashMap<>();
            int ans = Combinations(nums,target,dp,0);
            return ans;
        }


        private int Combinations(int [] nums, int target, HashMap<Integer,Integer> dp, int ind){
            int ans =0;
            if(target<=0){
                if(target==0 || ind >= nums.length){
                    return 1;
                }
                return 0;
            }
            if(dp.containsKey(target)){
                return dp.get(target);
            }
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=target){
                    ans += Combinations(nums,target-nums[i],dp,i);
                }
            }
            dp.put(target,ans);
            return ans;
        }

        //4th approach - using tabulation
            public int combinationSum44(int[] nums, int target) {
                Integer[] dp = new Integer[target + 1];
                return Combinations(nums, target, dp);
            }

            private int Combinations(int[] nums, int target, Integer[] dp) {
                if (target == 0) return 1;
                if (target < 0) return 0;

                if (dp[target] != null) return dp[target];

                int ans = 0;
                for (int num : nums) {
                    ans += Combinations(nums, target - num, dp);
                }

                dp[target] = ans;
                return ans;
            }


    public static void main(String[] args) {
        int [] nums = {1,2,3};
        int target = 4;
        Combination_Sum_IV obj = new Combination_Sum_IV();
       // System.out.println(obj.combinationSum4(nums,target));
        //System.out.println(obj.combinationSum41(nums,target));
        //System.out.println(obj.combinationSum43(nums,target));
        System.out.println(obj.combinationSum44(nums,target));
    }
}
