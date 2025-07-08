package basic_of_java;

import java.util.ArrayList;
import java.util.Scanner;

public class Print_negative_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr [] = new int [10];
        System.out.print("enter the arr element : ");
        for(int i=0;i< arr.length;i++){
            arr [i] =sc.nextInt();
            if(arr[i]<0){
                System.out.println(arr[i]);
            }

        }
        sc.close();

    }

}
