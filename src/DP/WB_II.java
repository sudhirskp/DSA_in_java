package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WB_II {

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        find(0, s, wordDict, res, new StringBuilder());
        return res;
    }

    private void find(int index, String s, List<String> wd, List<String> res, StringBuilder sb) {
        if (index == s.length()) {
            res.add(sb.toString());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String word = s.substring(index, i + 1);
            if (wd.contains(word)) {
                int len = sb.length();
                if (len > 0) {
                    sb.append(" ").append(word);
                } else {
                    sb.append(word);
                }

                find(i + 1, s, wd, res, sb);
                sb.setLength(len); // backtrack
            }
        }
    }

    public static void main(String[] args) {
        WB_II obj = new WB_II();
        System.out.println(obj.wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
    }
}
//Leetcode 140