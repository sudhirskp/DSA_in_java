package Pattern.Overlapping_intervals;

import java.util.Arrays;

public class NonOverlapping {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        System.out.println(Arrays.deepToString(intervals));
        int n = intervals.length;
        //int[] curr = intervals[0];
        int count = 0;
        int prevend = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if(prevend <= intervals[i][0]){
                prevend = intervals[i][1];
            }else{
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        //int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        int [][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        NonOverlapping obj = new NonOverlapping();
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }
}

//leetcode 435
