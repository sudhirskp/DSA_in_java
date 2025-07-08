package basic_of_java;

import java.util.Scanner;

public class Print_unique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size : ");
        int n = sc.nextInt();
        int arr[]= new int[n];
        System.out.print("enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.print("Unique Element are : ");
        for(int i=0;i<n;i++){
           boolean uni = true;
           for(int j=0;j<n;j++){
               if(i!=j && arr[i]==arr[j]){
                   uni = false;
                   break;
               }
           }
           if(uni){
               System.out.print(arr[i]+ " ");
           }
        }
        sc.close();

    }
}
