package Pattern.Overlapping_intervals;

import java.util.ArrayList;

public class InsertIntervals {

    public int[][] insertInterval(int [][] interval , int []newIntervals){
        int n = interval.length;
        ArrayList<int[]> list = new ArrayList<>();
        int i=0;
        while(i < n && interval[i][1] < newIntervals[0]){
            list.add(interval[i]);
            i++;
        }

        while(i < n && interval[i][0] <= newIntervals[1]){
            newIntervals[0] = Math.min(interval[i][0], newIntervals[0]);
            newIntervals[1] = Math.max(interval[i][1], newIntervals[1]);
            i++;
        }
        list.add(newIntervals);

        while(i < n){
            list.add(interval[i]);
            i++;
        }
        return list.toArray(new int [list.size()][2]);
    }
    public static void main(String[] args) {
        int [][] arr = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        InsertIntervals obj = new InsertIntervals();
        int [][] ans = obj.insertInterval(arr , newInterval);
        for(int i=0;i<ans.length;i++){
            System.out.print("[" + ans[i][0] + "," + ans[i][1] + "]");
            if(i!=ans.length-1){
                System.out.print(",");
            }
        }
    }
}


//57. Insert Interval
//Solved
//        Medium
//Topics
//        Companies
//Hint
//You are given an array of non-overlapping intervals intervals where
// intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
// You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//Return intervals after the insertion.
//
//Note that you don't need to modify intervals in-place. You can make a new array and return it.
//Example 1:
//
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]