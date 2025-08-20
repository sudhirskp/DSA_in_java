package GreedyAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {


        public static int activitySelection(int[] start, int[] finish) {
            // code here
            int n = start.length;
            List<Integer> index = new ArrayList<>();

            for(int i=0;i<n;i++){
                index.add(i);
            }

            Collections.sort(index,(a, b)->(finish[a]-finish[b]));

            int maxAct =1;
            int lastInd = finish[index.get(0)];

            for(int i=1;i<n;i++){
                int ind = index.get(i);
                if(start[ind]>lastInd){
                    maxAct++;
                    lastInd = finish[ind];
                }
            }

            return maxAct;

        }


    public static void main(String[] args) {
        int [] st = {1, 3, 0, 5, 8, 5};
        int [] end = {2, 4, 6, 7, 9, 9};

        System.out.println(activitySelection(st,end));
    }
}
