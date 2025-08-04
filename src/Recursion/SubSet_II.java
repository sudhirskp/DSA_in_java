package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubSet_II {

    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        powerSet(nums,res,new ArrayList<>(),0);
        int i=0;
        int n = res.size();
        while(n-- > 0){
            set.add(res.get(i));
            i++;
        }
        res.clear();
        res.addAll(set);
        return res;
    }

    private void powerSet(int [] nums, List<List<Integer>> res, List<Integer> temp, int index){
        int n = nums.length;
        if(index >= n){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        powerSet(nums,res,temp,index+1);
        temp.remove(temp.size()-1);
        powerSet(nums,res,temp,index+1);
    }

    //------------------------------------------------------------------
    //beats 99.99%
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        powerSet1(nums,res,new ArrayList<>(),0);
        return res;
    }

    private void powerSet1(int [] nums, List<List<Integer>> res,List<Integer> temp, int index){
        int n = nums.length;
        res.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            powerSet1(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int [] nums = {4,4,4,1,4};
        SubSet_II obj = new SubSet_II();
        List<List<Integer>> res = obj.subsetsWithDup2(nums);
        System.out.println(res);
    }
}
//https://leetcode.com/problems/subsets-ii/
//90. Subsets II