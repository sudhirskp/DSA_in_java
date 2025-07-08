package basic_of_java;

import java.util.Scanner;

public class SumofArrayele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of Array : ");
        int n = sc.nextInt();
        int sum =0;
        int arr[] = new int[n];
        System.out.print("enter the value in array for sum : ");
        for(int i=0;i<n;i++){

            arr[i] = sc.nextInt();
            sum = sum + arr[i];
        }
        System.out.println("the sum = "+ sum);
    }
}
