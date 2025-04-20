package Grind75;

import java.util.Arrays;

public class SortColor {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int count [] = new int [3];
        int copy [] = new int [n];
        for(int i=0;i<n;i++){
            count[nums[i]]++;
        }
        for(int i=1;i<=2;i++){
            count[i] = count[i]+count[i-1];
        }
        for(int i=n-1;i>=0;i--){
            int index = --count[nums[i]];
            copy[index] = nums[i];
        }
        System.arraycopy(copy, 0, nums, 0, nums.length);
    }
    public static void main(String[] args) {
        int nums [] = new int [] {2,0,2,1,1,0};
        SortColor obj = new SortColor();
        obj.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

//75. Sort Colors
//Medium
//        Topics
//Companies
//        Hint
//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.
//
//
//
//Example 1:
//
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
