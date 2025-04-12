package basic_of_java;

import java.util.Scanner;

public class Duplicatenumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.print("Enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int temp,count =0;
       for(int i=0;i<arr.length;i++){
           for(int j=i+1;j<arr.length;j++){
               if(arr[i]==arr[j]){
                   System.out.println(arr[j]);
                   count++;
               }
           }
       }
        System.out.println("No. of duplicate element : "+ count);

    }
}
