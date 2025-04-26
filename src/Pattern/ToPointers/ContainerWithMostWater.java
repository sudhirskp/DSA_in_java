package Pattern.ToPointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;
        int left =0;
        int right = n-1;
        int waterCapacity =0;
        while(left<right){
            int h = Math.min(height[left],height[right]);
            waterCapacity = Math.max(waterCapacity, h * (right- left));
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return waterCapacity;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater container = new ContainerWithMostWater();
        int result = container.maxArea(height);
        System.out.println("Maximum water capacity: " + result);
    }
}

//11. Container With Most Water
//Solved
//        Medium
//Topics
//        Companies
//Hint
//You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//
//Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//Return the maximum amount of water a container can store.
//
//Notice that you may not slant the container.