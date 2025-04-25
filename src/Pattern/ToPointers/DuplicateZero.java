package Pattern.ToPointers;

public class DuplicateZero {
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Count the number of zeros
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeros++;
            }
        }

        // Start from the end of the array and fill in the values
        for (int i = n - 1, j = n + zeros - 1; i >= 0; i--) {
            if (j < n) {
                arr[j] = arr[i];
            }
            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

//1089. Duplicate Zeros
//Solved
//        Easy
//Topics
//        Companies
//Hint
//Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
//
//Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
//
//
//
//        Example 1:
//
//Input: arr = [1,0,2,3,0,4,5,0]
//Output: [1,0,0,2,3,0,0,4]
//Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]