package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Choco_distribution{
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int res = Integer.MAX_VALUE;
        Collections.sort(arr);
        for(int i=0;i<arr.size()-m+1;i++){
            int minval = arr.get(i);
            int maxval = arr.get(i+m-1);
            res = Math.min(res,maxval-minval);
        }
        return res;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3,4, 1, 9, 56, 7, 9, 12));
        Choco_distribution ob = new Choco_distribution();
        System.out.println(ob.findMinDiff(list,5));
    }
}

//Chocolate Distribution Problem
//Difficulty: EasyAccuracy: 49.91%Submissions: 249K+Points: 2Average Time: 15m
//Given an array arr[] of positive integers, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are m students, the task is to distribute chocolate packets among m students such that -
//i. Each student gets exactly one packet.
//ii. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum and return that minimum possible difference.
//
//Examples:
//
//Input: arr = [3, 4, 1, 9, 56, 7, 9, 12], m = 5
//Output: 6
//Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following m packets :[3, 4, 9, 7, 9].
//Input: arr = [7, 3, 2, 4, 9, 12, 56], m = 3
//Output: 2
//Explanation: The minimum difference between maximum chocolates and minimum chocolates is 4 - 2 = 2 by choosing following m packets :[3, 2, 4].
