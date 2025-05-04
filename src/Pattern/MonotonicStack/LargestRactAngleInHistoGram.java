package Pattern.MonotonicStack;

public class LargestRactAngleInHistoGram {

    public int largestRectangleArea3(int[] heights) {
        int n = heights.length;
        int st [] = new int[n+1];
        int index =-1;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            int ele = (i==n)?0:heights[i];
            while(index!=-1 && heights[st[index]]>ele){
                int h = heights[st[index--]];
                int ps = index==-1 ? -1 : st[index];
                int w = i-ps-1;
                max = Math.max(max , h*w);
            }
            st[++index]=i;
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
    public static void main(String[] args) {
        LargestRactAngleInHistoGram l = new LargestRactAngleInHistoGram();
        int [] heights = {2,1,5,6,2,3};
        int result = l.largestRectangleArea3(heights);
        System.out.println("Largest Rectangle Area: " + result);
    }
}

//84. Largest Rectangle in Histogram
//Solved
//        Hard
//Topics
//        Companies
//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
//
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.