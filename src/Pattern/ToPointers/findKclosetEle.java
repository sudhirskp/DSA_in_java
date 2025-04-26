package Pattern.ToPointers;

import java.util.ArrayList;
import java.util.List;

public class findKclosetEle {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (right-left >= k) {
            int a = Math.abs(arr[left] - x);
            int b = Math.abs(arr[right] - x);
            if (a > b) {
                left++;
            } else {
                right--;
            }
        }
        for (int i = left; i <= right; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        int x = 3;
        findKclosetEle obj = new findKclosetEle();
        List<Integer> result = obj.findClosestElements(arr, k, x);
        System.out.println(result); // Output: [1, 2, 3, 4]
    }
}

//658. Find K Closest Elements
//Solved
//        Medium
//Topics
//        Companies
//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//        |a - x| < |b - x|, or
//|a - x| == |b - x| and a < b
//
//
//Example 1:
//
//Input: arr = [1,2,3,4,5], k = 4, x = 3
//
//Output: [1,2,3,4]