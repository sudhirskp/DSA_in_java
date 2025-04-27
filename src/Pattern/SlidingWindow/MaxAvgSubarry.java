package Pattern.SlidingWindow;

public class MaxAvgSubarry {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        MaxAvgSubarry obj = new MaxAvgSubarry();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = obj.findMaxAverage(nums, k);
        System.out.println(result);
    }
}
