package GreedyAlgo;

import java.util.Arrays;

public class MaxBagFullCapa {

        public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
            int n = rocks.length;
            int[] newArr = new int[n];
            for (int i = 0; i < n; i++) {
                newArr[i] = capacity[i] - rocks[i];
            }

            Arrays.sort(newArr);
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (newArr[i] <= additionalRocks) {
                    additionalRocks -= newArr[i];
                    count++;
                } else {
                    break;
                }
            }
            return count;
        }

    public static void main(String[] args) {
        int [] capacity = {2,3,4,5};
        int [] rocks = {1,2,4,4};
        int additionalRocks = 2;
        MaxBagFullCapa obj = new MaxBagFullCapa();
        System.out.println(obj.maximumBags(capacity,rocks,additionalRocks));
    }
}

//leetcode 2279
//https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
