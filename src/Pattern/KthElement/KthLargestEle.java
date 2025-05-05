package Pattern.KthElement;

import java.util.PriorityQueue;

public class KthLargestEle {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(que.size()<=k){
                que.offer(nums[i]);
            }

            if(que.size()>k){
                que.poll();
            }
        }
        return que.poll();
    }

    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int val : nums){
            que.offer(val);
        }

        while(que.size()>k){
            que.poll();
        }
        return que.poll();
    }

    public static void main(String[] args) {
        KthLargestEle ob = new KthLargestEle();
        int [] a = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(ob.findKthLargest1(a,k));
    }
}

//215. Kth Largest Element in an Array
//Medium
//        Topics
//Companies
//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Can you solve it without sorting?
//
//Example 1:
//
//Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5