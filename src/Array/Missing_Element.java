package Array;

import java.util.ArrayList;
import java.util.List;

public class Missing_Element {

    //169 //TC:O(n) //SC:O(1)
    public int majorityElement1(int[] nums) {
        int n = nums.length;
        int count = 0;
        int candidate = 0;

        for(int i =0;i<n;i++){
            if(candidate==0){
                candidate = nums[i];
            }

            if(candidate==nums[i]){
                count++;
            }else{
                count--;
                if(count==0){
                    candidate = 0;
                }
            }

        }
        return candidate;

    }

    //229 //TC:O(n) //SC:O(1)
    public List<Integer> majorityElement2(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                count1=1;
            } else if (count2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                count2=1;

            }else if(ele1==nums[i]){
                count1++;

            }else if(ele2==nums[i]){
                count2++;

            } else {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for(int i=0;i<n;i++){
            if(ele1==nums[i]) count1++;
            if(ele2==nums[i]) count2++;
        }

        if (count1>n/3) {
            ans.add(ele1);
        }
        if (count2>n/3) {
            ans.add(ele2);
        }

        return ans;
    }

    public static void main(String[] args) {
        Missing_Element missing_Element = new Missing_Element();
        int[] nums = {1,2};
        System.out.println(missing_Element.majorityElement1(nums));
        System.out.println(missing_Element.majorityElement2(nums));
    }
}

//https://leetcode.com/problems/majority-element-ii/
//leetcode 229

//Approach
//Current:
//Array
///
//Boyer–Moore Majority Vote Algorithm
//Suggested:
//Array
///
//Boyer–Moore Majority Vote Algorithm
//Key Idea:
//Extending Boyer-Moore Voting to find up to two elements appearing more than n/3 times.
//Consider:
//How would you adapt this logic if the threshold changed from n/3 to n/k for any arbitrary k?
//------------------------------------------------------------------------------------------------

//leetcode 169