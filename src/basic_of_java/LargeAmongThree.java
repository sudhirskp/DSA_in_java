package basic_of_java;

import java.util.Scanner;

public class LargeAmongThree{


    double compare(double a,double b,double c){
        double largest;
        largest=a;
        if(b>largest){
            largest=b;
            return largest;
        }
        else if(c>largest){
            largest=c;
            return largest;
        }
        else {
            return a;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three number to compare : ");

        double a =sc.nextDouble();
        double b =sc.nextDouble();
        double c=sc.nextDouble();

        LargeAmongThree large = new LargeAmongThree();

        System.out.print("Largest among three numbers : "+ large.compare(a,b,c));

    }
}
