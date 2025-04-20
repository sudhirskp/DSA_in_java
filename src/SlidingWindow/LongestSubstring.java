package SlidingWindow;

public class LongestSubstring {
    public int longestkSubstr(String s, int k) {
        // code here
        int n  = s.length();
        int count [] = new int [26];
        int start =0 , maxLen = -1, ucc = 0; //unique character count
        for(int end =0;end<n;end++){
           if(count[s.charAt(end)-'a']==0){
               ucc++;
               count[s.charAt(end)-'a']++;
           }else{
                count[s.charAt(end)-'a']++;
           }
           if(ucc==k){
                maxLen = Math.max(maxLen,end-start+1);
           }else if(ucc>k){
                while(end>start && ucc>k){
                    count[s.charAt(start)-'a']--;
                    if(count[s.charAt(start)-'a']==0){
                        ucc--;
                    }
                    start++;
                }
           }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s ="aabaaab";
        int k = 2;
        LongestSubstring obj = new LongestSubstring();
        int result = obj.longestkSubstr(s, k);
        System.out.println(result); // Output: 7
    }
}

//ing with K Uniques
//Difficulty: MediumAccuracy: 34.65%Submissions: 184K+Points: 4
//Given a string s, you need to print the size of the longest possible substring with exactly k unique characters. If no possible substring exists, print -1.
//
//Examples:
//
//Input: s = "aabacbebebe", k = 3
//Output: 7
//Explanation: "cbebebe" is the longest substring with 3 distinct characters.Longest Substr