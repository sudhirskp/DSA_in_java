package basic_of_java;

import java.util.Scanner;

public class ReversArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("enter the array element : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("After reverse the Array : ");
        int start = 0, end = n - 1;
        while(start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;

        }
        for(int a : arr){
            System.out.print(a +" ");
        }
        sc.close();
    }
}
