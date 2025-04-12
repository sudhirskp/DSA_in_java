package basic_of_java;

import java.util.Scanner;

public class AddAtindex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size : ");
        int n = sc.nextInt();
        int arr[]= new int[n];
        System.out.print("enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            //System.out.print(" "+ arr[i]);
        }
        System.out.print("Enter the element and index to add : ");
        int add = sc.nextInt();
        int index = sc.nextInt();
        int temp [] = new int [arr.length+1];
        System.out.print("after adding the element : ");
        for(int i=0 ,j=0;i<temp.length;i++){
            if(i==index){
                temp[i]=add;
            }
            else{
                temp[i]= arr[j];
                j++;
            }
            System.out.print(" "+ temp[i]);
        }
        sc.close();
    }
}
