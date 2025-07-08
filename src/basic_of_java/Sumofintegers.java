package basic_of_java;
import java.util.Scanner;

public class Sumofintegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num;

        int total = 0;
        // Continue looping until the user enters 0 or a negative integer
        while (true) {
            // Get an integer input from the user
            System.out.print("Enter an integer (0 or negative to exit): ");
            num = input.nextInt();

            // Check if the input is 0 or negative, and break the loop if true
            if (num <= 0) {
                break;
            }

            // Add the value to the total
            total += num;
        }

        // Print the total sum
        System.out.println("Total sum: " + total);
    }
}