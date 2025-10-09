package Grind75;

import java.util.Arrays;

public class jobscheduling {

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[][] jobs = new int[n][3];

            for (int i = 0; i < n; i++) {
                jobs[i][0] = startTime[i];
                jobs[i][1] = endTime[i];
                jobs[i][2] = profit[i];
            }

            // Step 1: Sort by end time
            Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

            // Step 2: DP array
            int[] dp = new int[n];
            dp[0] = jobs[0][2];

            for (int i = 1; i < n; i++) {
                int include = jobs[i][2];
                int last = binarySearch(jobs, i);
                if (last != -1) include += dp[last];

                dp[i] = Math.max(dp[i - 1], include);
            }

            return dp[n - 1];
        }

        // Binary search to find last non-overlapping job
        private int binarySearch(int[][] jobs, int i) {
            int lo = 0, hi = i - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (jobs[mid][1] <= jobs[i][0]) {
                    if (jobs[mid + 1][1] <= jobs[i][0]) lo = mid + 1;
                    else return mid;
                } else hi = mid - 1;
            }
            return -1;
        }

    public static void main(String[] args) {
        jobscheduling ob = new jobscheduling();
        int [] st = {1,2,3,3};
        int [] end = {3,4,5,6};
        int [] pr = {50,10,40,70};

        System.out.println(ob.jobScheduling(st,end,pr));
    }
}
//LeetCode : 1235