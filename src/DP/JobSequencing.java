package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class JobSequencing {

    //TLE
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

        //DSU
        int findParent(int[] parent, int x) {
            if(parent[x] == x) return x;
            return parent[x] = findParent(parent, parent[x]);
        }
    public ArrayList<Integer> jobSequencing1(int[] deadline, int[] profit) {
        int n = deadline.length;

        // Step 1: sort jobs by profit descending
        Integer[] ids = new Integer[n];
        for(int i=0;i<n;i++) ids[i] = i;
        Arrays.sort(ids, (a,b) -> profit[b] - profit[a]);

        // Step 2: DSU parent initialization
        int maxdead = 0;
        for(int d : deadline) maxdead = Math.max(maxdead, d);
        int[] parent = new int[maxdead+1];
        for(int i=0;i<=maxdead;i++) parent[i] = i;

        // Step 3: assign jobs
        int count = 0, pr = 0;
        for(int id : ids){
            int avail = findParent(parent, deadline[id]);
            if(avail > 0){
                parent[avail] = findParent(parent, avail-1);
                count++;
                pr += profit[id];
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(pr);
        return res;
    }



    public static void main(String[] args) {
        JobSequencing obj = new JobSequencing();
        System.out.println(obj.jobSequencing(new int []{4,1,1,1}, new int []{20,10,40,30}));
        System.out.println(obj.jobSequencing1(new int []{4,1,1,1}, new int []{20,10,40,30}));
    }
}
//https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1