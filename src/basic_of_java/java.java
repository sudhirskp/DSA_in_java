package basic_of_java;

import java.util.Arrays;
import java.util.Scanner;

public class java {
    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 1, 0, 0, 1, 0, 1, 0};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i =0;
        int j = a.length-1;
        while(j>i){
            if(a[i] == 0){
                i++;
            }else if(a[j] == 1){
//                int temp = a[i];
//                a[i] = a[j];
//                a[j] = temp;
                j--;
            }else{
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }

        }
       for(int b : a){
           System.out.print(b + " ");
       }
        System.out.println("");

       for(int k=1;k<=n;k++){
           System.out.println(2 + "x" + k + "=" + 2*k);
       }
    }
}
