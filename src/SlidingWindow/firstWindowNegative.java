package SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class firstWindowNegative {

    static List<Integer> firstNegInt(int [] arr, int k) {
        // write code here
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int res [] = new int [n-k+1];

       int index =0;
       while(k>index){
           if(arr[index]<0){
               q.offer(arr[index]);
           }
           index++;
       }

        res [0] =(q.isEmpty() ? 0 : q.peek());
        for(int i=1; i<=n-k; i++){
            if(arr[i-1]<0){
                q.poll();
            }
            if(arr[i+k-1]<0){
                q.offer(arr[i+k-1]);
            }
            res[i] = (q.isEmpty() ? 0 : q.peek());
        }

        for(int val : res){
            list.add(val);
        }
        return list;
    }

    public static void main(String[] args) {
        int arr [] ={ -8, 2, 3, -6, 10};
        int k = 2;
//        int ans [] = firstNegInt(arr,k);
//        for(int i =0;i< arr.length-k+1;i++){
//            System.out.print(ans[i] + " ");
//        }

        System.out.println(firstNegInt(arr,k));
    }
}


//First negative in every window of size k
//Difficulty: MediumAccuracy: 48.61%Submissions: 182K+Points: 4Average Time: 15m
//Given an array arr[]  and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
//
//Note: If a window does not contain a negative integer, then return 0 for that window.
//
//Examples:
//
//Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
//Output: [-8, 0, -6, -6]
//Explanation:
//Window [-8, 2] First negative integer is -8.
//Window [2, 3] No negative integers, output is 0.
//Window [3, -6] First negative integer is -6.
//Window [-6, 10] First negative integer is -6.