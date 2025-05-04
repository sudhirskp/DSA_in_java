package Pattern.MonotonicStack;

import java.util.Stack;

public class DailyTemp{

    //62ms Runtime
    public int[] dailyTemperatures1(int[] temp) {
        int n = temp.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temp[i] > temp[st.peek()]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }

        return res;
    }

    //7ms Runtime beat 98.9%
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int [] res = new int [n];
        //Stack<Integer> st = new Stack<>();
        int [] st = new int [n+1];
        int ind = -1;
        for(int i=0;i<n;i++){
            while(ind!=-1 && temp[i]>temp[st[ind]]){
                int index = st[ind--];
                res[index] = i - index;
            }
            st[++ind] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemp dt = new DailyTemp();
        int [] temp = {73,74,75,71,69,72,76,73};
        int [] result = dt.dailyTemperatures(temp);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i] + " ");
        }
    }
}

//739. Daily Temperatures
//Medium
//        Topics
//Companies
//        Hint
//Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
//
//
//
//        Example 1:
//
//Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
