package basic_of_java;

import java.util.Scanner;

public class Max_min {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size : ");
        int n = sc.nextInt();
        int arr[]= new int[n];
        System.out.print("enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0;i<n;i++){
            int temp = arr[i];

            if(temp>max){
                max = temp;
            }
           if(min>temp){
               min = temp;
           }
        }
        System.out.println("Max is : "+ max +" Min is : "+ min);
    }
}
