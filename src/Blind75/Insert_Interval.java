package Blind75;

import java.util.ArrayList;

public class Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int r = intervals.length;
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < r && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < r && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);

        while (i < r) {
            list.add(intervals[i]);
            i++;
        }

//        int ans [][] = new int [res.size()][2];
//        for(int j=0;j<res.size();j++){
//            ans [j] = res.get(j);
//        }
//        return ans;
        // or below

        return list.toArray(new int[list.size()][2]);
    }
    public static void main(String[] args) {
        int [][] intervals = {{1,3},{6,9}};
        int [] newIntervals = {2,5};

        Insert_Interval ob = new Insert_Interval();
        int res [][] = ob.insert(intervals,newIntervals);
        for(int i=0;i< res.length;i++){
            for(int j=0;j< res.length;j++){
                System.out.print(res[i][j] + " ");
            }
        }
    }
}


//You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
//Example 2:
//
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
