package Pattern.PrefixSum;

import java.util.HashMap;
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxLen =0;
        int sum =0;
        for(int i=0;i<n;i++){
            sum += (nums[i]==0 ? -1 : 1);
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen , i - map.get(sum));
            }else{
                map.put(sum , i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums [] = {0,1,1,1,1,1,0,0,0};
        ContiguousArray ob = new ContiguousArray();
        System.out.println(ob.findMaxLength(nums));
    }
}


//525. Contiguous Array
//Solved
//        Medium
//        Companies
//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

//Example 1:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.