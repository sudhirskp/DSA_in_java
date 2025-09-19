package Amazon;

import java.util.HashMap;

public class LongestSub {


        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            HashMap<Character, Integer> map = new HashMap<>();
            int MaxLen = 0;
            int sw = 0;

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (map.containsKey(c) && map.get(c) >= sw) {
                    sw = map.get(c) + 1;
                }

                map.put(c, i);
                MaxLen = Math.max(MaxLen, i - sw + 1);
            }

            return MaxLen;
        }


    public static void main(String[] args) {
        LongestSub longestSub = new LongestSub();
        String s = "abcabcbb";
        System.out.println(longestSub.lengthOfLongestSubstring(s));
    }
}
//leetCode 3
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//time complexity : O(n)
//space complexity : O(n)