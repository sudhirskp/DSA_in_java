package HashMap_HashSet;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutive {

    //1st approach // O(nlogn)
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int maxLen =1;
        int len = 1;
        int prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev){
                continue;
            }else if(nums[i]==prev+1){
                len++;
            }else{
                len=1;
            }
            prev = nums[i];
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;

    }

    //2nd approach // O(n+n)
    public int longestConsecutive2(int[] nums) {
        if(nums.length==0) return 0;
        int n = nums.length;
        int maxlength =0;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        for(Integer val : set){
            int prev = val -1;
            if(!set.contains(prev)){
                int len =1;
                int nextele = val+1;
                while(set.contains(nextele)){
                    len++;
                    nextele++;
                }
                maxlength = Math.max(maxlength, len);
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        int arr [] ={100,4,200,1,3,2};
        LongestConsecutive ob = new LongestConsecutive();
        System.out.println(ob.longestConsecutive(arr));
    }
}


//128. Longest Consecutive Sequence
//        Medium
//Topics
//        Companies
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.
//
//
//
//Example 1:
//
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.