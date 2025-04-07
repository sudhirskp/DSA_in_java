package Sorting;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public void brickSort(int [] arr){
        int n = arr.length;
        boolean isSorted = false;
        while(!isSorted){
            boolean flag = false;

            //Perform Bubble sort on odd indexed element
            for(int i=0;i<=n-2;i+=2){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
            //Perform Bubble sort on even indexed element
            for(int i=1;i<=n-2;i+=2){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                isSorted = true;
                // break;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {
            int [] arr = {2,3,4,1,5,6,7,8,9,10};
            //int n = arr.length;
            BubbleSort bs = new BubbleSort();
            //bs.bubbleSort(arr);
            System.out.println();
            bs.brickSort(arr);
    }
}
