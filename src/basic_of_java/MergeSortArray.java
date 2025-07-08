package basic_of_java;

import java.util.Scanner;

public class MergeSortArray {
    public static void main(String[] args) {
        int [] arr1 = new int [6];
        int [] arr2 = new int [5];
        int [] arr3 = new int [11];

        arr1 = new int[]{1,2,3,5,6,7,};
        arr2= new int[]{3,5,6,8,9};
        System.out.println("Before Merging :");
        System.out.print("Arr1 : ");
        for(int n : arr1){
            System.out.print(n +" ");
        }
        System.out.print("Arr2 : ");
        for(int a : arr2){
            System.out.print(a +" ");
        }
        System.out.println("");
        System.out.print("after merging arr3 : ");

        int i=0,j=0,k=0;
        while(i< arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr3[k]=arr2[j];
                j++;
            }
            else{
                arr3[k]=arr1[i];
                i++;
            }
            k++;
        }
        while(i< arr1.length){
            arr3[k]=arr1[i];
            i++;
            k++;
        }
        while(j<arr2.length){
            arr3[k]=arr2[j];
            j++;
            k++;
        }
        for(int n : arr3){
            System.out.print(n +" ");
        }

    }
}
