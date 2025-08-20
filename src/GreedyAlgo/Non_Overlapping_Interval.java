package GreedyAlgo;

import java.util.Arrays;

public class Non_Overlapping_Interval {


        public static int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int n = intervals.length;
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
        int [][] interval ={{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(interval));
    }
}


//leetCode 435