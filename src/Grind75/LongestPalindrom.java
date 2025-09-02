package Grind75;

public class LongestPalindrom {

        boolean palindrom(String str){
            int n = str.length();
            int i=0;
            int j=n-1;
            while(j>i){
                if(str.charAt(i)!=str.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }
        //brute-force approach
        public String longestPalindrome(String s) {
            int n = s.length();
            if(n==1) return s;
            StringBuilder sb = new StringBuilder();
            int i=0;
            int j = i+1;
            while(j<=n && i<n){
                if(palindrom(s.substring(i,j))){
                    String str = s.substring(i,j);
                    if(str.length()>=sb.length()){
                        sb= new StringBuilder();
                        sb.append(str);
                    }
                }
                j++;
                if(j==n+1){
                    i++;
                    j=i+1;
                }
            }
            return sb.toString();
        }

        //optimal approach
            public String longestPalindrome1(String s) {
                if (s == null || s.length() < 2) return s;
                int start = 0, end = 0;

                for (int i = 0; i < s.length(); i++) {
                    int len1 = expandAroundCenter(s, i, i);     // odd
                    int len2 = expandAroundCenter(s, i, i + 1); // even
                    int len = Math.max(len1, len2);

                    if (len > end - start) {
                        start = i - (len - 1) / 2;
                        end = i + len / 2;
                    }
                }

                return s.substring(start, end + 1);
            }

            private int expandAroundCenter(String s, int left, int right) {
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    left--;
                    right++;
                }
                return right - left - 1; // palindrome length
            }



    public static void main(String[] args) {
        String str = "bb";
        LongestPalindrom ob = new LongestPalindrom();
        System.out.println(ob.longestPalindrome1(str));
    }
}

// 5. Longest Palindromic Substring
//leetcode link: https://leetcode.com/problems/longest-palindromic-substring/description/
