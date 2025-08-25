package GreedyAlgo;

public class JumpGame_II {


        public int jump(int[] nums) {
            int n = nums.length;
            int jump =0;
            int maxjumpInd =-1;
            int end =0;

            for(int i=0;i<n-1;i++){
                maxjumpInd = Math.max(maxjumpInd,i+nums[i]);

                if(i==end){
                    jump++;
                    end = maxjumpInd;
                }

                if(end >= n-1) return jump;
            }
            return jump;
        }

    public static void main(String[] args) {
        int [] nums = {2,3,1,1,4};
        JumpGame_II obj = new JumpGame_II();
        System.out.println(obj.jump(nums));
    }
}
//leetCode 45
//https://leetcode.com/problems/jump-game-ii/