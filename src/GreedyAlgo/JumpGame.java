package GreedyAlgo;

public class JumpGame {

        public static boolean canJump(int[] nums) {
            int n = nums.length;
            int max =0;
            int i =0;
            while(i<=max){
                max = Math.max(max,i+nums[i]);
                if(max>=n-1){
                    return true;
                }
                i++;
            }
            return false;
        }
    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
}
//leetCode 55
//https://leetcode.com/problems/jump-game/