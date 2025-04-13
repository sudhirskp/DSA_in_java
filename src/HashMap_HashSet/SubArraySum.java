package HashMap_HashSet;

import java.util.HashMap;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            int diff = sum - k;

            if (map.containsKey(diff)) {
                count += map.get(diff);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr [] = {1,-1,0};
        int k = 0;
        SubArraySum ob = new SubArraySum();
        System.out.println(ob.subarraySum(arr,k));
    }
}




//560. Subarray Sum Equals K
//Solved
//        Medium
//Topics
//        Companies
//Hint
//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.