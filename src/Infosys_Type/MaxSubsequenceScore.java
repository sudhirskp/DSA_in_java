package Infosys_Type;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long res = 0;

        PriorityQueue<Integer> que = new PriorityQueue<>();

        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];
            pairs[i][1] = nums1[i];
        }

        // sort descending by nums2
        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);


        long sum = 0;
        for (int[] p : pairs) {

            int n2 = p[0];
            int n1 = p[1];

            que.offer(n1);
            sum += n1;

            // keep only k largest nums1
            if (que.size() > k) {
                sum -= que.poll();
            }

            // compute score
            if (que.size() == k) {
                res = Math.max(res, sum * n2);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        MaxSubsequenceScore maxSubsequenceScore = new MaxSubsequenceScore();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k = 3;
        System.out.println(maxSubsequenceScore.maxScore(nums1,nums2,k));
    }
}
//LeetCode 2542
