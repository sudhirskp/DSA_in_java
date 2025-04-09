package Sorting;

public class CountingSort {

    public void countingSort(int[] arr,int max) {
       int k = max;
       int count[] = new int[k+1];

       //Count the frequency of each element
       for(int i = 0; i < arr.length; i++){
           count[arr[i]]++;
       }

       //Calculate the cumulative frequency
       for(int i = 1; i <= k; i++){
           count[i] = count[i] + count[i-1];
       }
       //Create a temporary array to store the sorted array
        int [] temp = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            int index = --count[arr[i]];
            temp[index] = arr[i];
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(temp[i] + " ");
        }
    }

    //counting sort modification for redix sort
    public void countingSortDigit(int[] arr,int digit) {
        int k = 9;
        int count[] = new int[k+1];
       // int res [] = new int[arr.length];

        //Count the frequency of each element
        for(int i = 0; i < arr.length; i++){
            int index = (arr[i]/digit)%10;
            count[index]++;
        }

        //Calculate the cumulative frequency
        for(int i = 1; i <= k; i++){
            count[i] = count[i] + count[i-1];
        }
        //Create a temporary array to store the sorted array
        int [] temp = new int[arr.length];
        for(int i = arr.length-1; i >= 0; i--){
            int index = --count[(arr[i]/digit)%10];
            temp[index] = arr[i];
        }
        //copy in Original array
        for(int i = 0; i < arr.length; i++){
            arr[i] = temp[i];
        }
    }

    public void radixSort(int[] arr) {
        int n = arr.length;
        int max =Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int digit = 1;
        while(max/digit > 0){
            countingSortDigit(arr, digit);
            digit = digit*10;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }


    public static void main(String[] args) {

        int arr [] = {24456,3,4,1,44555,6,7,8995,9563,10};
        int min = 1;
        int max = 10;
        CountingSort cs = new CountingSort();
        //cs.countingSort(arr,max);
        cs.radixSort(arr);
    }

}
