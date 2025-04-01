package List;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlap {
    public static List<int[]> mergeOverlap(int [][] interval){
        if(interval.length==0){
            return new ArrayList<>();
        }
        Arrays.sort(interval,(x,y)-> Integer.compare(x[0],y[0]));

        List<int[]> mergeInterval = new ArrayList<>();

        int[] currentInterval = interval[0];
        mergeInterval.add(currentInterval);

        for(int [] inter : interval ){
            int currentStart = currentInterval[0];
            int currentEnd = currentInterval[1];
            int nextStart = currentInterval[0];
            int nextEnd = currentInterval[1];

            if(currentEnd >= nextStart){
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            }
            else{
                currentInterval = inter;
                mergeInterval.add(currentInterval);
            }
        }

        return mergeInterval;
    }

    public static void main(String[] args) {
        int [][] arr = {{1,3},{4,5},{6,7},{3,5}};
        List<int []> Overlap= mergeOverlap(arr);

        System.out.println("Merged Array : ");
        for(int [] i : Overlap){
            System.out.println(i);
            //System.out.println(Arrays.toString(i));
        }

    }


}

//leatcode code ------------------------------------------------------------

//class Solution {
//    public int[][] merge(int[][] intervals) {
//        if(intervals.length==0){
//            return intervals;
//        }
//        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
//
//        List<int[]> mergeInterval = new ArrayList<>();
//        int [] currentInterval = intervals[0];
//        mergeInterval.add(currentInterval);
//
//        for(int [] interval : intervals){
//            int currentst = currentInterval[0];
//            int currentend = currentInterval[1];
//            int nextst = interval[0];
//            int nextend = interval[1];
//
//            if(currentend >=nextst){
//                currentInterval[1] = Math.max(currentend,nextend);
//            }
//            else{
//                currentInterval = interval;
//                mergeInterval.add(currentInterval);
//            }
//        }
//
//        int n = mergeInterval.size();
//
//        return mergeInterval.toArray(new int[n][n]);
//
//    }
//}
