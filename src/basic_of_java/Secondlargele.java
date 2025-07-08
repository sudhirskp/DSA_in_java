package basic_of_java;

import java.util.Arrays;
import java.util.Scanner;

public class Secondlargele {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size of arr : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int largest=Integer.MIN_VALUE;
        int secondlarg=Integer.MIN_VALUE;
        int num;

        System.out.print("enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            num = arr[i];

            if(num>largest){
                secondlarg = largest;
                largest = num;
            }
            else if(num > secondlarg && largest != num){

                secondlarg = num;
            }

        }
        if(secondlarg == Integer.MIN_VALUE){
            System.out.println("-1");
        }
        else{
            System.out.println(secondlarg);
        }
    }
}
