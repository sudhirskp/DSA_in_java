package Amazon;

import java.util.ArrayDeque;

public class SW_Max {

        public int[] maxSlidingWindow(int[] nums, int k){
            int n = nums.length;
            int res [] = new int[n - k + 1];
            if (n == 0 || k > n) {
                return new int[0];
            }

            ArrayDeque<Integer> deq = new ArrayDeque<>();
            int index =0;
            while(index<k){
                while(!deq.isEmpty() && nums[deq.peekLast()]<=nums[index]){
                    deq.pollLast();
                }
                deq.offerLast(index++);

            }
            res [0] = nums[deq.peekFirst()];

            for(int i=1;i<n-k+1;i++){
                if(!deq.isEmpty() && deq.peekFirst() <=(i-1)){
                    deq.pollFirst();
                }
                while(!deq.isEmpty() && nums[deq.peekLast()]<=nums[i+k-1]){
                    deq.pollLast();
                }
                deq.offerLast(i+k-1);
                res[i] = nums[deq.peekFirst()];
            }

            return res;

        }

    public static void main(String[] args) {
            SW_Max ob = new SW_Max();
            int arr [] = ob.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
            for(int i:arr){
                System.out.print(i+" ");
            }
    }
}
//leetcode : 239
//TC : O(n)
//SC : O(k)
//https://leetcode.com/problems/sliding-window-maximum/description/