package Sorting;

public class SelectionSort {

    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void biDirectionalSelectionSort(int[] arr) {
        int n = arr.length;
        int k=n-1;
        for (int i = 0; i < k; i++) {
            int min = i;
            int max = i;
            for (int j = i + 1; j <= k; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;

            if(arr[max]==arr[min]){
                temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }else {
                 temp = arr[max];
                arr[max] = arr[k];
                arr[k] = temp;
            }
            k--;
        }

        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 1, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;
        SelectionSort ss = new SelectionSort();
        //ss.selectionSort(arr);
        System.out.println();
        ss.biDirectionalSelectionSort(arr);

    }
}
