package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> list = new ArrayList<>();
            int n = nums.length;
            for(int i=0;i<n-2;i++){
                if(i>0 && nums[i]==nums[i-1]) continue;

                int left = i+1;
                int right = n-1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum >0){
                        right--;
                    }else if(sum <0){
                        left++;
                    }else{
                        list.add(Arrays.asList(nums[i],nums[left],nums[right]));

                        while(left < right && nums[left]==nums[left+1]) left++;
                        while(left < right && nums[right]==nums[right-1]) right--;

                        left++;
                        right--;
                    }
                }
            }
            return list;
        }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(nums));
    }
}
//leetCode 15
//https://leetcode.com/problems/3sum/description/
//time complexity : O(n^2)
//space complexity : O(1)