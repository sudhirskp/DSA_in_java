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
    public static void main(String[] args) {

        //System.out.println(Sum(5));
       // printIncreasing(5);
        printArr(new int [] {1,3,4,5,6,7} , 5);
    }
}
