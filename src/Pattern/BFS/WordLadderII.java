package Pattern.BFS;
import java.util.*;

public class WordLadderII {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();
        que.offer(beginWord);

        if(!set.contains(endWord)) return ans;
        return ans;
    }
    public static void main(String[] args) {
        return ;
    }
}

// leet 126