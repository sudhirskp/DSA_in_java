package basic_of_java;

import java.util.Scanner;

public class factbymethod {

    int fact(int n){
        if(n<=0){
            return 1;
        }

        return n*fact(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to find the factorial : ");
        int n = sc.nextInt();
        factbymethod f = new factbymethod();

        System.out.println("The factorial of "+n+" is "+f.fact(n));
        sc.close();

    }
}
