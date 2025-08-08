package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        powerSet(nums,res,new ArrayList<>(),0);
        return res;
    }

    private void powerSet(int [] nums, List<List<Integer>> res,List<Integer> temp, int index){
        int n = nums.length;
        if(index >= n){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        powerSet(nums,res,temp,index+1);
        temp.remove(temp.size()-1); // Backtrack
        powerSet(nums,res,temp,index+1);
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        Subset s = new Subset();
        System.out.println(s.subsets(nums));
    }
}
//https://leetcode.com/problems/subsets/
//78. Subsets
//