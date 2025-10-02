package DSA_Sheet.Amazon;

public class MajorityEle {

        //Boyer-Moore Voting Algorithm (Best – O(1) Space)
        public int majorityElement(int[] nums) {
            int candidate = 0, count = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }


    public static void main(String[] args) {
        MajorityEle majorityEle = new MajorityEle();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityEle.majorityElement(nums));
    }
}
//leetCode 169
//https://leetcode.com/problems/majority-element/description/
//time complexity : O(n)
//space complexity : O(1)