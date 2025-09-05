package Grind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FIndAnagrams {

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            if (s.length() < p.length()) return res;

            int[] pCount = new int[26];
            int[] sCount = new int[26];

            // frequency of p
            for (char c : p.toCharArray()) {
                pCount[c - 'a']++;
            }

            int window = p.length();

            // first window
            for (int i = 0; i < window; i++) {
                sCount[s.charAt(i) - 'a']++;
            }

            if (Arrays.equals(pCount, sCount)) res.add(0);

            // slide window
            for (int i = window; i < s.length(); i++) {
                sCount[s.charAt(i) - 'a']++;          // add right char
                sCount[s.charAt(i - window) - 'a']--; // remove left char

                if (Arrays.equals(pCount, sCount)) {
                    res.add(i - window + 1);
                }
            }

            return res;
        }



    public static void main(String[] args) {
        String s ="abcebabaca";
        String p = "abc";
        FIndAnagrams ob =new FIndAnagrams();
        System.out.println(ob.findAnagrams(s,p));
    }
}

//leetCode 438
