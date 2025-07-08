package basic_of_java;

import java.util.Scanner;

public class RotationArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the index for rotation (-index for left, +index for right): ");
        int index = sc.nextInt();
        rotateArray(arr, index);
        System.out.print("Rotated array: ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    public static void rotateArray(int[] arr, int index) {
        int n = arr.length;
        if (index < 0) {
            index = n + index;
        }
        index = index % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, index - 1);
        reverse(arr, index, n - 1);
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
