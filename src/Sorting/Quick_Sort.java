package Sorting;

public class Quick_Sort {

        public void quickSort(int[] arr, int low, int high) {
            // code here
            if(low>=high) return;

            int pivit = partition(arr,low,high);

            quickSort(arr,low,pivit-1);
            quickSort(arr,pivit+1,high);

        }

        private int partition(int[] arr, int low, int high) {

            // code here
            int pv = arr[low];

            int i =low;
            int j = high;

            while(i<j){
                while(i<high && arr[i]<=pv) i++;
                while(j>low && arr[j]>pv) j--;

                if(i<j){
                    swap(arr,i,j);
                }
            }
            swap(arr,low,j);

            return j;
        }

        private void swap(int [] arr , int i , int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    public static void main(String[] args) {
        int[] arr = {10, 80, 30, 90, 40, 50, 70};
        Quick_Sort qs = new Quick_Sort();
        qs.quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
