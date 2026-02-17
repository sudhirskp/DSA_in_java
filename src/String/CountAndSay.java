package String;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {

    public String countAndSay(int n) {
        String ans = "1";  // base case
        for (int i = 1; i < n; i++) {
            ans = buildNext(ans);
        }

//        for (int i = 1; i < n; i++) {
//            ans = newStr(MapPair(ans));
//        }

        return ans;
    }

    private String buildNext(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(str.charAt(str.length() - 1));
        return sb.toString();
    }

    private List<int[]> MapPair(String s) {
        List<int[]> list = new ArrayList<>();
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                list.add(new int[] { s.charAt(i - 1) - '0', count });
                count = 1;
            }
        }

        list.add(new int[] { s.charAt(s.length() - 1) - '0', count });
        return list;
    }

    private String newStr(List<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int[] pair : list) {
            sb.append(pair[1]);
            sb.append(pair[0]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay ob = new CountAndSay();
        int n = 5;
        System.out.println(ob.countAndSay(n));
    }
}
