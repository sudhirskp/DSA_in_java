package GreedyAlgo;

import java.util.Arrays;

public class MiceHole {
        static int assignMiceHoles(int N, int[] M, int[] H) {
            // code here
            Arrays.sort(M);
            Arrays.sort(H);

            int maxVal =0;

            for(int i=0;i<N;i++){
                maxVal = Math.max(maxVal, Math.abs(M[i]-H[i]));
            }
            return maxVal;
        }
    public static void main(String[] args) {
            int [] M = {-4,2,4};
            int [] H = {4,0,5};
            int N = M.length;
            System.out.println(assignMiceHoles(N,M,H));
    }
}
