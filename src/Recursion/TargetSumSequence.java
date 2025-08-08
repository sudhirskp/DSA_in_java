package Recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumSequence {

    public List<List<Integer>> findTargetSumWays(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        findTargetSumWays(nums, target,new ArrayList<>(), 0, res);
        return res;
    }

    int sum = 0;
    boolean findTargetSumWays(int[] nums, int target, List<Integer> list, int index, List<List<Integer>> res){

        if(index == nums.length){
            if(target == sum){
                res.add(new ArrayList<>(list));
            }
            return true;
        }

        list.add(nums[index]);
        sum += nums[index];
        boolean l = findTargetSumWays(nums, target, list, index + 1, res);
        list.remove(list.size() - 1); // Backtrack
        sum -= nums[index];

        boolean r = findTargetSumWays(nums, target, list, index + 1, res);
        return l || r;
    }
    public static void main(String[] args) {
        int [] nums ={1,2,3};
        int target = 3;
        System.out.println(new TargetSumSequence().findTargetSumWays(nums, target));
    }
}
