package Pattern.Overlapping_intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int curr [] = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(curr[1]>=intervals[i][0]){
                curr[1] = Math.max(curr[1] , intervals[i][1]);
            }else{
                list.add(curr);
                curr = intervals[i];
            }
        }
        list.add(curr);
        return list.toArray(new int [list.size()][2]);
    }

    public static void main(String[] args){
        int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals obj = new MergeIntervals();
        int [][] ans = obj.merge(arr);
        for(int i=0;i<ans.length;i++){
            System.out.print("[" + ans[i][0] + "," + ans[i][1] + "]");
            if(i!=ans.length-1){
                System.out.print(",");
            }
        }
    }
}

//56 merge Intervals - leet
