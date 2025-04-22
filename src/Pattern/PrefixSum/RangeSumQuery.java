package Pattern.PrefixSum;

public class RangeSumQuery {
    int prefixSum[];
    public void NumArray(int[] nums) {
        prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for(int i=1;i<=nums.length;i++){
            prefixSum[i] = prefixSum[i-1]+nums[i-1];
        }

        //or
        //for(int i=0;i<nums.length;i++){
        //    prefixSum[i+1] = prefixSum[i]+nums[i];
        //}
    }

    public int sumRange(int left, int right) {
        return prefixSum[right+1]-prefixSum[left];
    }
    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        RangeSumQuery obj = new RangeSumQuery();
        obj.NumArray(nums);
        System.out.println(obj.sumRange(0,2));
    }
}

//303. Range Sum Query - Immutable
//        Solved
//Easy
//        Topics
//Companies
//Given an integer array nums, handle multiple queries of the following type:
//
//Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
//Implement the NumArray class:
//
//NumArray(int[] nums) Initializes the object with the integer array nums.
//int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
//
//
//Example 1:
//
//Input
//["NumArray", "sumRange", "sumRange", "sumRange"]
//        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
//Output
//[null, 1, -1, -3]

