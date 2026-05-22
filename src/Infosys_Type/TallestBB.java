package Infosys_Type;

import java.util.Arrays;

public class TallestBB {

        //TC: O(2^N)
        //SC: O(2^N)
        //TLE
        int n;
        public int tallestBillboard(int[] rods) {
            n = rods.length;
            return BB(0,rods,0,0);
        }

        private int BB(int index, int [] rod, int r1, int r2){

            if(index>=n){
                if(r1==r2) return r1;
                return 0;
            }

            int NoPick = BB(index+1,rod,r1,r2);

            int pickr1 = BB(index+1,rod,r1+rod[index],r2);

            int pickr2 = BB(index+1,rod,r1,r2+rod[index]);

            //System.out.print(pickr1 + " " + pickr2);

            return Math.max(Math.max(pickr1,pickr2),NoPick);
        }

        //Memoization
            int [][] dp;
            public int tallestBillboard1(int[] rods) {
                n = rods.length;
                dp = new int [n+1][50001];
                for(int [] d : dp)
                    Arrays.fill(d,-1);
                //return BB(0,rods,0,0);
                //diff = 0,l1-l2
                return BB(0,rods,0)/2;
            }

            private int BB(int index, int [] rod, int diff){

                if(index>=n){
                    // if(r1==r2){
                    //     return r1;
                    // }
                    // return 0;

                    if(diff==0){
                        return 0;
                    }
                    return Integer.MIN_VALUE;
                }

                if(dp[index][diff+5000]!=-1) return dp[index][diff+5000];

                int NoPick = BB(index+1,rod,diff);

                int pickr1 = rod[index] + BB(index+1, rod, diff+rod[index]);

                int pickr2 = rod[index] + BB(index+1, rod, diff-rod[index]);

                dp[index][diff+5000] =  Math.max(Math.max(pickr1,pickr2),NoPick);
                return dp[index][diff+5000];
            }


    public static void main(String[] args) {
        TallestBB ob = new TallestBB();
        int[] rods = {1,2,3,6};
        System.out.println(ob.tallestBillboard(rods));
        System.out.println(ob.tallestBillboard1(rods));
    }
}
//LeetCode 956