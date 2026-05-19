package Infosys_Type;

import java.util.Arrays;

public class JobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }


        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);


        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            int skip = dp[i + 1];

            int nextIndex = binarySearch(jobs, i);
            int take = jobs[i][2] + dp[nextIndex];

            dp[i] = Math.max(skip, take);
        }

        return dp[0];
    }

    private int binarySearch(int[][] jobs, int i) {
        int targetEnd = jobs[i][1];
        int left = 0, right = jobs.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][0] >= targetEnd) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        JobScheduling jobScheduling = new JobScheduling();
        int[] startTime = {1,2,3,4};
        int[] endTime = {3,5,10,6};
        int[] profit = {20,10,40,50};
        System.out.println(jobScheduling.jobScheduling(startTime,endTime,profit));
    }
}
//LeetCode 1235