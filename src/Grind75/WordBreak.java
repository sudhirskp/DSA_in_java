package Grind75;

import java.util.HashMap;
import java.util.List;

class Tr {
    HashMap<Integer, Tr> child;
    boolean endof;

    Tr() {
        child = new HashMap<>();
        endof = false;
    }
}
public class WordBreak {

        Tr root;

        WordBreak() {
            root = new Tr();
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            // Build Trie with dictionary words
            for (String word : wordDict) {
                insert(word);
            }

            // Use DFS + memoization
            Boolean[] dp = new Boolean[s.length()];
            return dfs(s, 0, dp);
        }

        private boolean dfs(String s, int index, Boolean[] dp) {
            if (index == s.length()) return true;
            if (dp[index] != null) return dp[index];

            Tr cur = root;
            for (int i = index; i < s.length(); i++) {
                int ind = s.charAt(i) - 'a';
                if (!cur.child.containsKey(ind)) break;
                cur = cur.child.get(ind);

                if (cur.endof && dfs(s, i + 1, dp)) {
                    return dp[index] = true;
                }
            }

            return dp[index] = false;
        }

        public void insert(String word) {
            Tr cur = root;
            for (char c : word.toCharArray()) {
                int ind = c - 'a';
                if (!cur.child.containsKey(ind)) {
                    cur.child.put(ind, new Tr());
                }
                cur = cur.child.get(ind);
            }
            cur.endof = true;
        }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak(s, wordDict));
    }
}

// link : https://leetcode.com/problems/word-break/description/
//
