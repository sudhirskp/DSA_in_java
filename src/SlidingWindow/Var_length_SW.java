package SlidingWindow;

public class Var_length_SW {

    //tc = o(n) sc = o(1)
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int n = arr.length;
        int minlen = Integer.MAX_VALUE;
        int sum =0;
        int start =0;
        int i =0; //endIndex

        while(i<n){
            sum+=arr[i];
            if(sum>x){
                int len = i - start+1;
                minlen = Math.min(minlen,len);
            }
            while(start<i && sum>x){
                sum-=arr[start];
                start++;

                if(sum>x){
                    int len = i - start+1;
                    minlen = Math.min(minlen,len);
                }
            }
            i++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
    public static void main(String[] args) {
        int x = 51, arr[] = {1, 4, 45, 6, 0, 19};
        //int x =100 , arr[] = {1, 10, 5, 2, 7};
        System.out.println(smallestSubWithSum(x, arr));
    }
}

//Smallest subarray with sum greater than x
//Difficulty: EasyAccuracy: 37.07%Submissions: 139K+Points: 2Average Time: 20m
//Given a number x and an array of integers arr, find the smallest subarray with sum greater than the given value. If such a subarray do not exist return 0 in that case.
//
//Examples:
//
//Input: x = 51, arr[] = [1, 4, 45, 6, 0, 19]
//Output: 3
//Explanation: Minimum length subarray is [4, 45, 6]
//Input: x = 100, arr[] = [1, 10, 5, 2, 7]
//Output: 0
//Explanation: No subarray exist