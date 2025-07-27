package Recursion;

import java.util.ArrayList;
import java.util.List;

public class permuteByRecursion {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteByRec(nums,0,res);
        return res;
    }

    public void permuteByRec(int [] nums , int index , List<List<Integer>> ans){
        int n = nums.length;
        if(index == n-1){ //n-1 or n
            List<Integer> list = new ArrayList<>();
            for(int i : nums){
                list.add(i);
            }
            ans.add(list);
            return;
        }

        for(int i=index;i<n;i++){
            swap(nums,i,index);
            permuteByRec(nums,index+1,ans);
            //backtrack
            swap(nums,i,index);
        }
    }
    void swap(int [] nums, int i , int ind){
        int temp = nums[i];
        nums[i] = nums[ind];
        nums[ind] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        permuteByRecursion obj = new permuteByRecursion();
        System.out.println(obj.permute(nums));
    }
}
//https://leetcode.com/problems/permutations/
//42. Permutations
