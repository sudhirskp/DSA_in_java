package String;

public class Anagram {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] charCount = new int[256]; // Assuming ASCII characters

        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i)]++;
            charCount[s2.charAt(i)]--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Anagram ob = new Anagram();
        boolean ans = ob.areAnagrams("geeksforgeeks", "forgeeksgeeks");
        System.out.println(ans);

    }
}
