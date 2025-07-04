package Recursion;

public class Basics {

    public static int Sum(int n){
        if(n==1) return 1;
        return n + Sum(n-1);
    }

    public static void printIncreasing(int n){
        if(n==0) return ;
        printIncreasing(n-1);
        System.out.print(n + " ");
    }

    public static void printArr(int arr[] , int size){
        if(size <0) return;
        printArr(arr , size -1);
        System.out.print(arr[size] + " ");
    }

    //print first index of the target number of the arr
    public static int printFirst(int arr[] , int target , int start){
        if(start== arr.length) return -1;
        if(arr[start]==target) return start;
        else{
            int index = printFirst(arr,target,start+1);
            return index;
        }
    }
    public static void main(String[] args) {

        //System.out.println(Sum(5));
       // printIncreasing(5);
        printArr(new int [] {1,3,4,5,6,7} , 5);
        System.out.println();
        System.out.println(printFirst(new int []{2,3,4,5,6,4,3},4,0));
    }
}
