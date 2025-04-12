package basic_of_java;

import java.util.Scanner;

public class Checkinputchar {
    public static void main(String[] args) {
        Scanner character = new Scanner(System.in);
        System.out.print("Enter value to check (alphabet,letters or special character) : ");
        char n = character.next().charAt(0);

        //check the character is digit or not, using ascii value
        if(n>=48 && n<=65){
            System.out.println("the character "+ "'"+n+"'" + "is digit");
        }
        //check for capital and small latter
        else if((n>=65 && n<=90) || (n>=95 && n<=122)){
            System.out.println("the character "+ "'"+n+"'" +" is Alphabet");
        }
        else{
                System.out.println("the character "+ "'"+n+"'" +" is special character");
        }

    }
}
