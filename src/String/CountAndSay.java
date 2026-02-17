package String;

public class CountAndSay {

    public String countAndSay(int n) {
        String ans = "1";  // base case
        for (int i = 1; i < n; i++) {
            ans = buildNext(ans);
        }
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

    public static void main(String[] args) {
        CountAndSay ob = new CountAndSay();
        int n = 5;
        System.out.println(ob.countAndSay(n));
    }
}
