package SlidingWindow;
import java.util.HashMap;
import java.util.HashSet;

public class LongestSubsWithoutRepeatChar {
    // Approach 1 good
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLength = -1;
        int sw =0;
        for(int i=0;i<n;i++){
            if(set.contains(s.charAt(i))){
                while(sw<i && set.contains(s.charAt(i))) {
                    set.remove(s.charAt(sw++));
                }
            }
            set.add(s.charAt(i));
            maxLength = Math.max(maxLength,i-sw+1);
        }
        return maxLength;
    }

    // Another Approach best
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        HashMap<Character ,Integer> map = new HashMap<>();
        int maxLength = 0;
        int sw =0;
        for(int i=0;i<n;i++){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>=sw){
                sw = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-sw+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubsWithoutRepeatChar obj = new LongestSubsWithoutRepeatChar();
        int result = obj.lengthOfLongestSubstring(s);
        System.out.println(result); // Output: 3
    }
}

//3. Longest Substring Without Repeating Characters
//        Medium
//Given a string s, find the length of the longest substring without duplicate characters.
//
//        Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
