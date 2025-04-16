package SlidingWindow;

public class Max_Sum_SubArray_of_sizeK {

    public int maximumSumSubArray(int[] arr, int k){
        int sum = 0;

        int n = arr.length;
        for(int j=0;j<k;j++){
            sum+=arr[j];
        }
        int maxSum =sum;
        for(int i=1;i<n-k+1;i++){
            sum = sum-arr[i-1]+arr[i+k-1];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int arr [] ={100,200,300,400};
        int k = 4;
        Max_Sum_SubArray_of_sizeK ob = new Max_Sum_SubArray_of_sizeK();
        System.out.println(ob.maximumSumSubArray(arr ,k));
    }
}



//Max Sum Subarray of size K
//Difficulty: EasyAccuracy: 49.6%Submissions: 186K+Points: 2
//Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
//
//Note: A subarray is a contiguous part of any given array.
//
//Examples:
//
//Input: arr[] = [100, 200, 300, 400] , k = 2
//Output: 700
//Explanation: arr3  + arr4 = 700, which is maximum.