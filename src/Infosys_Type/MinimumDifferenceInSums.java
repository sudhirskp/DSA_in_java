package Infosys_Type;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumDifferenceInSums {

    public long minimumDifference(int[] nums) {
        int len = nums.length;
        int n = len/3;
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());

        long [] leftsum = new long [len];
        long [] rightsum = new long [len];
        long sum = 0;

        for(int i = 0;i<len;i++){
            maxH.offer(nums[i]);
            sum+=nums[i];

            if(maxH.size()==n){
                leftsum[i] = sum;
            }

            if(maxH.size()>n){
                sum-= maxH.poll();
                leftsum[i] = sum;
            }
        }

        sum = 0;

        for(int i = len-1;i>=0;i--){
            minH.offer(nums[i]);
            sum+=nums[i];

            if(minH.size()==n){
                rightsum[i] = sum;
            }

            if(minH.size()>n){
                sum-= minH.poll();
                rightsum[i] = sum;
            }
        }

        //i from n-1 to 2n-1
        //i from 1 to 3
        // System.out.print(Arrays.toString(rightsum));

        long ans = Long.MAX_VALUE;

        for(int i = n-1 ;i<=2*n-1;i++){
            ans = Math.min(ans,leftsum[i] - rightsum[i+1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumDifferenceInSums minimumDifferenceInSums = new MinimumDifferenceInSums();
        int[] nums = {1,2,3,4};
        System.out.println(minimumDifferenceInSums.minimumDifference(nums));
    }
}
//LeetCode 2163
