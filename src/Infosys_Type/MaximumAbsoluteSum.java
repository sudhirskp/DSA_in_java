package Infosys_Type;

public class MaximumAbsoluteSum {

    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int sum  = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i =0;i<n;i++){
            sum+=nums[i];
            max = Math.max(max,sum);
            if(sum<0){
                sum = 0;
            }
        }

        sum = 0;

        for(int i =0;i<n;i++){
            sum+=nums[i];
            min = Math.min(min,sum);
            if(sum>0){
                sum = 0;
            }
        }

        return Math.max(Math.abs(min),max);
    }

    public static void main(String[] args) {
        MaximumAbsoluteSum maximumAbsoluteSum = new MaximumAbsoluteSum();
        int[] nums = {1,2,3,4};
        System.out.println(maximumAbsoluteSum.maxAbsoluteSum(nums));
    }
}
//LeetCode 1749
