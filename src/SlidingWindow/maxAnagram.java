package SlidingWindow;

import java.util.Arrays;

public class maxAnagram {

    int search(String pat, String txt) {
        int n = txt.length();
        int k = pat.length();

        int patcount [] = new int [26];
        for(int i=0;i<k;i++){
            patcount[pat.charAt(i)-'a']++;
        }

        int txtcount [] = new int [26];
        for(int i=0;i<k;i++){
            txtcount[txt.charAt(i)-'a']++;
        }

        int count =0;
        if(Arrays.equals(patcount , txtcount)){
            count++;
        }

        for(int i=1;i<n-k+1;i++){
            int removeIndex = txt.charAt(i-1)-'a';
            int addIndex = txt.charAt(i+k-1)-'a';
            txtcount[removeIndex]--;
            txtcount[addIndex]++;

            if(Arrays.equals(patcount , txtcount)){
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        maxAnagram ob = new maxAnagram();
        String txt = "forxxorfxdofr";
        String pat = "for";
        int result = ob.search(pat, txt);
        System.out.println("Count of occurrences of anagrams: " + result);
    }
}

//Count Occurences of Anagrams
//Difficulty: MediumAccuracy: 48.09%Submissions: 88K+Points: 4
//Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
//
//Example 1:
//
//Input: txt = "forxxorfxdofr", pat = "for"
//Output: 3
//Explanation: for, orf and ofr appears in the txt, hence answer is 3.