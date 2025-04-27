package Pattern.SlidingWindow;

import java.util.HashMap;

public class longest_substrig_norepeate {
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
        String s = "abcabcbb";
        longest_substrig_norepeate obj = new longest_substrig_norepeate();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result); // Output: 3
    }
}
//leetcode 3