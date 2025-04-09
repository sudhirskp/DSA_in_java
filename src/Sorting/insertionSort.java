package Sorting;

public class insertionSort {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
