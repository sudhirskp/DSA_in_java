package DSA_Sheet.Uber;

import java.util.Arrays;

public class Permute_String {


        public boolean checkInclusion(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            if(n>m) return false;
            int [] c1 = new int[26];

            for(int i=0;i<n;i++){
                c1[s1.charAt(i)-'a']++;
            }

            for(int i=0;i<m-n+1;i++){
                int [] c2 = new int[26];
                for(int j=0;j<n;j++){
                    c2[s2.charAt(i+j)-'a']++;
                }
                if(Arrays.equals(c1,c2)) return true;
            }
            return false;
        }


        // Optimized Approach
        public boolean checkInclusion1(String s1, String s2) {
            int n = s1.length();
            int m = s2.length();
            if(n>m) return false;
            int [] c1 = new int[26];
            int [] c2 = new int[26];

            for(int i=0;i<n;i++){
                c1[s1.charAt(i)-'a']++;
                c2[s2.charAt(i)-'a']++;
            }
            if(Arrays.equals(c1,c2)) return true;

            for(int i=1;i<m-n+1;i++){
                c2[s2.charAt(i-1)-'a']--;
                c2[s2.charAt(i+n-1)-'a']++;
                if(Arrays.equals(c1,c2)) return true;
            }
            return false;
        }


    public static void main(String[] args) {
        Permute_String ob = new Permute_String();
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(ob.checkInclusion(s1,s2));
    }
}
// link - https://leetcode.com/problems/permutation-in-string/description/
// leetCode : 567
