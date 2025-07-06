package Mock;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdobMock {

    public static String cleanString(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> toRemove = new HashSet<>();

        // Mark special characters and the immediate right letter for replacement
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isLetter(chars[i])) {
                toRemove.add(i);  // Mark special character
                for (int j = i + 1; j < chars.length; j++) {
                    if (Character.isLetter(chars[j])) {
                        toRemove.add(j);  // Mark the first right-side letter
                        break;
                    }
                }
            }
        }

        // Replace marked characters with space
        for (int i = 0; i < chars.length; i++) {
            if (toRemove.contains(i)) {
                chars[i] = ' ';
            }
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] testCases = {
                "hello*world",            // Output: hello orld
                "abc$def#ghi",            // Output: abc ef ghi
                "test@case!example",      // Output: test se example
                "no_special_here",        // Output: no special here
                "multiple***symbols",     // Output: mult ple   ymbols
                "end_with_special#"       // Output: end_with_spec al
        };

        System.out.println("Test Cases:");
        for (String test : testCases) {
            System.out.println("Input:  " + test);
            System.out.println("Output: " + cleanString(test));
            System.out.println();
        }

        // User input
        System.out.print("Enter your string: ");
        String userInput = scanner.nextLine();
        System.out.println("Output: " + cleanString(userInput));

        scanner.close();
    }
}
