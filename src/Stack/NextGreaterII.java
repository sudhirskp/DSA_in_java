package Stack;
import java.util.Stack;

public class NextGreaterII {
    public int[] nextGreaterElements(int[] nums){
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int res [] = new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i%n]){
                stk.pop();
            }
            if(i<n){
                if(stk.isEmpty()){
                    res[i] = -1;
                }else{
                    res[i] = stk.peek();
                }

            }
            stk.push(nums[i%n]);
        }
        return res;
    }
    public static void main(String[] args) {
        NextGreaterII obj = new NextGreaterII();
        int[] nums = {1,2,1};
        int[] result = obj.nextGreaterElements(nums);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}


//503. Next Greater Element II
//Medium
//        Topics
//Companies
//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
//
//
//
//Example 1:
//
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2;
//The number 2 can't find next greater number.
//The second 1's next greater number needs to search circularly, which is also 2.
