package Stack;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Maxrectangle {

    //1st method
    public int[] findNextSmaller(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = n;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int [] findPrevSmaller(int[] arr){
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ps[] = findPrevSmaller(heights);
        int ns[] = findNextSmaller(heights);
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int area = (ns[i]-ps[i]-1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int [] arr = {2,1,5,6,2,3};
        Maxrectangle m = new Maxrectangle();
        //System.out.println(m.largestRectangleArea(arr));
        System.out.println(m.largestRectangleArea(arr));
    }
}
