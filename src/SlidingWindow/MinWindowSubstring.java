package SlidingWindow;

import java.util.HashMap;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int n = s.length();
        int sw = 0; //startWindow
        int si = -1; //StartIndex
        int i = 0; //WindowEnd
        int minLen = Integer.MAX_VALUE;
        int ucc = map.size(); // unque char count

        while (i < n) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    ucc--;
                }
            }

            while (ucc == 0) {
                int len = i - sw + 1;
                if (minLen > len) {
                    minLen = len;
                    si = sw;
                }
                ch = s.charAt(sw);
                if (map.containsKey(ch)) {
                    map.put(ch, map.get(ch) + 1);
                    if (map.get(ch) > 0) {
                        ucc++;
                    }
                }
                sw++;
            }
            i++;
        }
        if (si == -1)
            return "";
        else
            return s.substring(si, si + minLen);
    }


    public static void main(String[] args) {
        MinWindowSubstring mws = new MinWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(mws.minWindow(s, t)); // Output: "BANC"
    }
}


//76. Minimum Window Substring
//        Hard
//Topics
//        Companies
//Hint
//Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
//
//The testcases will be generated such that the answer is unique
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//        Example 2:
//
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.