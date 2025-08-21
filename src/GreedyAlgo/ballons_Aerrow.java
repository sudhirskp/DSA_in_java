package GreedyAlgo;

import java.util.Arrays;

public class ballons_Aerrow {

        public int findMinArrowShots(int[][] points) {
            int n = points.length-1;
            Arrays.sort(points,(a, b)->(a[1]<=b[1] ? -1 : 1));

            int aerrow=1;
            int lastend = points[0][1];
            for(int i=1;i<=n;i++){
                if(points[i][0]>lastend){
                    aerrow++;
                    lastend = points[i][1];
                }
            }
            return aerrow;
        }

    public static void main(String[] args) {
        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
        ballons_Aerrow obj = new ballons_Aerrow();
        System.out.println(obj.findMinArrowShots(points));
    }
}
//link : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
//TC : O(nlogn)
//SC : O(1)
//Approach : Greedy
//leetcode 452