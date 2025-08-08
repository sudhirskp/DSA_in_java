package PriorityQueue;

import java.util.PriorityQueue;

public class MaxSumOfSubsequence {

        public int[] maxSubsequence(int[] nums, int k) {
            int n = nums.length;
            PriorityQueue<int[]> que = new PriorityQueue<>((a, b)-> Integer.compare(a[0],b[0]));
            for(int i=0;i<n;i++){
                que.offer(new int []{nums[i],i});

                if(que.size()>k){
                    que.poll();
                }
            }
            PriorityQueue<int[]> que1 = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));

            int [] res = new int [k];
            int i=0;
            while(!que.isEmpty()){
                int [] arr = que.poll();
                que1.offer(arr);
            }

            while(!que1.isEmpty()){
                int [] arr = que1.poll();
                res[i++] = arr[0];
            }

            return res;
        }

    public static void main(String[] args) {
        int [] arr = {2,1,3,3};
        int k = 2;
        MaxSumOfSubsequence maxSumOfSubsequence = new MaxSumOfSubsequence();
        int [] res = maxSumOfSubsequence.maxSubsequence(arr,k);
        for(int val : res){
            System.out.print(val+" ");
        }
    }
}
//https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/
//leetcode 2099