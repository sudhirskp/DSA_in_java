package String;

public class StartWith {

        public int strStr(String haystack, String needle) {
            int n = haystack.length();
            int m = needle.length();

            if (m == 0) return 0;  // edge case
            if (m > n) return -1;

            for (int i = 0; i <= n - m; i++) {
                if (haystack.substring(i, i + m).equals(needle)) {
                    return i;  // found first occurrence
                }
            }

            return -1;  // not found
        }


    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        StartWith ob = new StartWith();
        System.out.println(ob.strStr(haystack, needle));
    }
}
