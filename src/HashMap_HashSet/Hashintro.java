package HashMap_HashSet;

import java.util.HashMap;
import java.util.Scanner;

public class Hashintro {
    public static void main(String[] args) {
        HashMap<String, Integer> hashintro = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of hashmap: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character left by nextInt()

        System.out.println("Enter the key and value pairs:");
        for (int i = 0; i < n; i++) {
            System.out.print("Key: ");
            String key = sc.nextLine();
            System.out.print("Value: ");
            int value = sc.nextInt();
            sc.nextLine(); // Consume the newline character left by nextInt()
            hashintro.put(key, value);
        }

        System.out.println("Keys in the hashmap:");
        for (String s : hashintro.keySet()) {
            System.out.println(s);
          }
        System.out.println(hashintro.containsKey("india"));
        System.out.println(hashintro.size());
        //System.out.println(hashintro.remove());
    }
}
