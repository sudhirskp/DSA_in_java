package Sorting.Practice;

public class Class_Based_bubble {
    int arr[];
    int size;
    Class_Based_bubble(int arr []){
        this.arr = arr;
    }

    public void bubbleSort(int arr []){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            boolean flag = false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }

    public void display(int arr[] , int size){
        for(int i=0;i<size;i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr [] = {2,35,4,7,44,35,50};
        int n = arr.length;
        Class_Based_bubble ob = new Class_Based_bubble(arr);
        System.out.println("Before sorting");
        ob.display(arr,n);
        System.out.println(" ");
        System.out.println("After sorting ");
        ob.bubbleSort(arr);
        ob.display(arr,n);
    }
}
