package GreedyAlgo;

import java.util.Arrays;

public class MaxUnit {


        public int maximumUnits(int[][] boxTypes, int truckSize) {
            int n = boxTypes.length;
            Arrays.sort(boxTypes,(a, b)->b[1]-a[1]);

            int res =0;
            for(int [] box : boxTypes){
                int b = box[0];
                int unit = box[1];
                if(b<=truckSize){
                    truckSize-=b;
                    res+=unit*b;
                }else{
                    res+=truckSize*unit;
                    truckSize=0;
                }
                if(truckSize==0)break;
            }
            return res;
        }

    public static void main(String[] args) {
        int [][] boxTypes = {{1,3},{2,2},{3,1}};
        int truckSize = 4;
        MaxUnit obj = new MaxUnit();
        System.out.println(obj.maximumUnits(boxTypes,truckSize));
    }
}
//leetcode 1710
//https://leetcode.com/problems/maximum-units-on-a-truck/
