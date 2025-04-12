package basic_of_java;

import java.util.Scanner;

public class DeleteAt {
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
            System.out.print("Enter index to delete : ");
            int index = sc.nextInt();
            int temp [] = new int [arr.length];
            System.out.print("after deleting the element : ");
            for(int i=0;i<temp.length;i++){
                if(i==index){
                    continue;
                }
                else {
                    temp[i] = arr[i];
                }


                System.out.print(" "+ temp[i]);
            }
            sc.close();
        }
    }
