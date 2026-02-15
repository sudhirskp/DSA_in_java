package String;

import java.util.*;

public class GroupAnagram {


        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String s : strs) {
                // Sort characters to form the key
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = new String(chars);

                // Add to the corresponding group
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            }

            return new ArrayList<>(map.values());
        }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();


        for (String s : strs) {
            int[] count = new int[26]; // frequency of each letter

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build a unique key from counts
            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append(num).append('#'); // delimiter to avoid ambiguity
            }
            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
            GroupAnagram ob = new GroupAnagram();
            String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> ans = ob.groupAnagrams1(strs);
            System.out.println(ans);
    }
}
