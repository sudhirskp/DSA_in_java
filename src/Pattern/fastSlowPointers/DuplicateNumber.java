package Pattern.fastSlowPointers;

public class DuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        DuplicateNumber ob = new DuplicateNumber();
        int[] nums = {1,3,4,2,2};
        System.out.println(ob.findDuplicate(nums));
    }
}

//287. Find the Duplicate Number
//Solved
//        Medium
//Topics
//        Companies
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and using only constant extra space.
//
//Example 1:
//Input: nums = [1,3,4,2,2]
//Output: 2