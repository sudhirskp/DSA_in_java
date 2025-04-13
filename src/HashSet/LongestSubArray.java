package HashSet;

import java.util.HashMap;

public class LongestSubArray {

    public int longestSubarray(int[] arr, int k) {
        int n =arr.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        int max = 0;
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            int find = sum -k;
            if(map.containsKey(find)){

                int len = i - map.get(find);
                max = Math.max(max,len);

            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] arr = {10, 5, 2, 7, 1, -10};
        int k = 15;
        LongestSubArray lsa = new LongestSubArray();
        System.out.println(lsa.longestSubarray(arr,k));
    }
}

//Longest Subarray with Sum K
//Difficulty: MediumAccuracy: 24.64%Submissions: 640K+Points: 4
//Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
//
//Examples:
//
//Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
//Output: 6
//Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
//Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
//Output: 5
//Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
