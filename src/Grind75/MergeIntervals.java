package Grind75;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        ArrayList<int[]> list = new  ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int currentInterval[] = intervals[0];
        for(int i=1;i<n;i++){
            if(currentInterval[1]>= intervals[i][0]){
                currentInterval[1] = Math.max(currentInterval[1],intervals[i][1]);
            }else{
                list.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        list.add(currentInterval);
        return list.toArray(new int [list.size()][2]);
    }
    public static void main(String[] args) {
        int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mi = new MergeIntervals();
        System.out.println(Arrays.deepToString(mi.merge(arr)));
    }
}

//56. Merge Intervals
//Solved
//        Medium
//Topics
//        Companies
//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
