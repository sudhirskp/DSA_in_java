package HashSet;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySumIndex {

    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int sum =0;
        map.put(0,-1);

        for(int i=0;i<n;i++){
            sum += arr[i];
            int next = sum -target;
            if(map.containsKey(next)){
                int startindex = map.get(next)+1;
                list.add(startindex+1);
                list.add(i+1);
                return list;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        list.add(-1);
        return list;

    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 7, 5};
        int target = 12;
        System.out.println(subarraySum(arr,target));
    }
}

//Indexes of Subarray Sum
//Difficulty: MediumAccuracy: 16.5%Submissions: 1.8MPoints: 4Average Time: 20m
//Given an array arr[] containing only non-negative integers, your task is to find a continuous subarray (a contiguous sequence of elements) whose sum equals a specified value target. You need to return the 1-based indices of the leftmost and rightmost elements of this subarray. You need to find the first subarray whose sum is equal to the target.
//
//Note: If no such array is possible then, return [-1].
//
//Examples:
//
//Input: arr[] = [1, 2, 3, 7, 5], target = 12
//Output: [2, 4]
//Explanation: The sum of elements from 2nd to 4th position is 12.
//Input: arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
//Output: [1, 5]
//Explanation: The sum of elements from 1st to 5th position is 15.
