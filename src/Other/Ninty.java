package Other;

import java.util.Scanner;

public class Ninty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row and col size: ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] arr = new int[r][c];
        System.out.println("Enter the matrix element: ");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //matrix printing
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        //transpose of the matrix
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println("Transpose mtrix");
        //transpose printing
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j]+" ");

            }
            System.out.println();
        }
        //reverse (only for row)for 90 degree rotation
        for (int row = 0; row < r; row++) {
            int start = 0;
            int end = c - 1;
            while (start < end) {
                int temp = arr[row][start];
                arr[row][start] = arr[row][end];
                arr[row][end] = temp;
                start++;
                end--;
            }
        }

        // print the rotated matrix
        System.out.println("Rotated Matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
