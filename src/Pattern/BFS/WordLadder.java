package Pattern.BFS;

import java.util.*;

public class WordLadder {

    //1st approach using BFS - 170ms Runtime
    public List<String> getn(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                String newWord = word.substring(0, i) + ch + word.substring(i + 1);
                if (set.contains(newWord)) {
                    neighbours.add(newWord);
                }
            }
        }
        return neighbours;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 1; // Start from level 1

        while (!que.isEmpty()) {
            int currLevelSize = que.size();
            for (int i = 0; i < currLevelSize; i++) {
                String node = que.poll();
                if (node.equals(endWord)) {
                    return level;
                }

                List<String> neighbours = getn(node, set);
                for (String word : neighbours) {
                    if (set.contains(word)) {
                        que.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    //2nd approach - using BFS - 71ms
    public int ladderLength2(String beginWord, String endWord, List<String> wordList){
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;

        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        int ans =1;

        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                char [] ch = que.poll().toCharArray();
                for(int i=0;i<ch.length;i++){
                    char real = ch[i];
                    for(char c = 'a'; c<='z';c++){
                        if(c==real) continue;
                        ch[i] = c;
                        String New = new String(ch);
                        if(New.equals(endWord)) return ans + 1;
                        if(set.contains(New)){
                            que.offer(New);
                            set.remove(New);
                        }
                    }
                    ch[i] = real;
                }

            }
            ans++;
        }
        return 0;
    }

    //3rd approach - using bidirectional BFS - 19ms
        public int ladderLength3(String beginWord, String endWord, List<String> wordList){
            HashSet<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) return 0;

            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visited = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);
            int ans = 1;

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                HashSet<String> level = new HashSet<>();

                for (String word : beginSet) {
                    char[] ch = word.toCharArray();

                    for (int i = 0; i < ch.length; i++) {
                        char original = ch[i];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) continue;

                            ch[i] = c;
                            String newWord = new String(ch);

                            if (endSet.contains(newWord)) return ans + 1;

                            if (set.contains(newWord) && !visited.contains(newWord)) {
                                level.add(newWord);
                                visited.add(newWord);
                            }
                        }

                        ch[i] = original;
                    }
                }

                beginSet = level;
                ans++;
            }

            return 0;
        }

    public static void main(String[] args) {
        WordLadder obj = new WordLadder();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int result = obj.ladderLength3("hit", "cog", wordList);
        System.out.println(result);
    }
}

//leet 127