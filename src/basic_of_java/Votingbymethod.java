package basic_of_java;

import java.util.Scanner;

public class Votingbymethod {

    String checkforvote(int age){
        if(age >=18){
            return "You are Eligible for Vote";
        }
        else{
            return "Not eligible for Vote";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Age : ");
        int age = sc.nextInt();

        Votingbymethod vote = new Votingbymethod();

        System.out.println(vote.checkforvote(age));

    }
}

/*import java.util.Scanner;
public class VotingEligibilityChecker {

    // Method to check if a person is eligible to vote
    boolean isEligibleToVote(int age) {
        return age >= 18;
    }

    public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("Enter your age:");
		int personAge = input.nextInt();
		VotingEligibilityChecker obj = new VotingEligibilityChecker();
		boolean result = obj.isEligibleToVote(personAge);

        // Check eligibility and print the result
        if (result == true) {
            System.out.println("You are eligible to vote!");
        } else {
            System.out.println("Sorry, you are not eligible to vote yet.");
        }
    }
}*/
