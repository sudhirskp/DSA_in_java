package basic_of_java;

import java.util.Scanner;

public class Count_odd_even {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter the size : ");
        int n = sc.nextInt();
        int arr[]= new int[n];
        System.out.print("enter the array element : ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        int eve =0,odd=0;
        for (int i=0;i<n;i++){
            if(arr[i]%2==0){
                eve++;
            }
            else{
                odd++;
            }
        }
        System.out.println("No. of even number : "+ eve);
        System.out.println("No. of odd number : "+ odd);
        sc.close();
    }

}
