package GreedyAlgo;

import java.util.*;

public class JobSequencing {

        public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
            // code here
            ArrayList<Integer> res = new ArrayList<>();

            int max =0;

            for(int v : deadline){
                max = Math.max(v,max);
            }

            int n = deadline.length;
            int [] jobassign = new int [max+1];
            Arrays.fill(jobassign,-1);



            Integer[] index = new Integer[n];
            for (int i = 0; i < n; i++) index[i] = i;
            Arrays.sort(index, (a, b) -> profit[b] - profit[a]);


            int jb =0;
            int pr =0;

            for(int i=0;i<n;i++){
                int jobIdx = index[i];
                int dead = deadline[jobIdx];
                while (dead > 0 && jobassign[dead] != -1) {
                    dead--;
                }

                if (dead > 0) { // found a free slot
                    jobassign[dead] = jobIdx;
                    jb++;
                    pr += profit[jobIdx];
                }
            }
            res.add(jb);
            res.add(pr);
            return res;
        }

    public static void main(String[] args) {
        int [] deadline = {2,1,2,1,1};
        int [] profit = {100,19,27,25,15};

        JobSequencing obj = new JobSequencing();
        System.out.println(obj.jobSequencing(deadline,profit));
    }
}

