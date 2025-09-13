package Grind75;

import java.util.HashMap;

public class minWindowSubs {

        public String minWindow(String s, String t) {
            int n = s.length();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int sw = 0;
            int end = 0;
            int si = -1;
            int MinWin = Integer.MAX_VALUE;
            int uniqueCharCount = map.size();

            while (end < n) {
                char c = s.charAt(end);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) == 0) {
                        uniqueCharCount--;
                    }
                }

                while (uniqueCharCount == 0) {
                    int len = end - sw + 1;
                    if(MinWin>len){
                        MinWin = len;
                        si = sw;
                    }
                    c = s.charAt(sw);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                        if (map.get(c)>0) {
                            uniqueCharCount++;
                        }
                    }
                    sw++;
                }
                end++;
            }

            if(si==-1){
                return "";
            }else{
                return s.substring(si,si+MinWin);
            }
        }

    public static void main(String[] args) {
            String s = "ADOBECODEBANC";
            String t = "ABC";
            minWindowSubs minWindowSubs = new minWindowSubs();
            System.out.println(minWindowSubs.minWindow(s,t));
    }
}
//leetCode 76
//https://leetcode.com/problems/minimum-window-substring/description/
//medium