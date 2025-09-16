package Grind75;

public class TrappingRainWater {


        public int trap(int[] height) {
            int n = height.length;
            int left = 0;
            int right = n-1;
            int leftmax = Integer.MIN_VALUE;
            int rightmax = Integer.MIN_VALUE;
            int water =0;
            while(left < right){
                if(height[left] < height[right]){
                    if(height[left] >= leftmax) leftmax = height[left];
                    water += leftmax - height[left];
                    left++;
                }else{
                    if(height[right] >= rightmax){
                        rightmax = height[right];
                    }
                    water += rightmax - height[right];
                    right--;
                }
            }
            return water;
        }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingRainWater.trap(height));
    }
}
//leetCode 42
//https://leetcode.com/problems/trapping-rain-water/description/
//hard
//time complexity : O(n)
//space complexity : O(1)
