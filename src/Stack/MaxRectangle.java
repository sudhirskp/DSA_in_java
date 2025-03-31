package Stack;

import java.util.Stack;

public class MaxRectangle {

    //hard leet 84

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

    //--------------------------------------------------------------------------------
    //2nd method
    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            int ele = (i==n)?0:heights[i];
            while(!st.isEmpty() && heights[st.peek()]>ele){
                int h = heights[st.pop()];
                int ps = st.isEmpty() ? -1 : st.peek();
                int w = i-ps-1;
                max = Math.max(max , h*w);
            }
            st.push(i);
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
//------------------------------------------------------------------------------------------

    //by using custome stack 99% faster
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

    //-----------------------------
    public static void main(String[] args) {
        int [] arr = {2,1,5,6,2,3};
        MaxRectangle m = new MaxRectangle();
        //System.out.println(m.largestRectangleArea(arr));
        System.out.println(m.largestRectangleArea2(arr));
        System.out.println(m.largestRectangleArea3(arr));
    }
}
