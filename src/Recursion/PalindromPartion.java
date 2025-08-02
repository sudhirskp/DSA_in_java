package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartion {

        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> cur = new ArrayList<>();
            return PdPartion(s,0,cur,res);
        }

        private List<List<String>> PdPartion(String s, int index ,List<String> cur, List<List<String>>res){
            int n = s.length();
            if(index==n){
                res.add(new ArrayList<String>(cur));
            }

            for(int i=index;i<n;i++){
                if(palindrom(s,index,i)){
                    cur.add(s.substring(index,i+1));
                    PdPartion(s,i+1,cur,res);
                    cur.remove(cur.size()-1);
                }
            }
            return res;
        }

        private boolean palindrom(String s , int i , int j){
            while(i<j){
                if(s.charAt(i)!=s.charAt(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    public static void main(String[] args) {
        PalindromPartion ob = new PalindromPartion();
        System.out.println(ob.partition("aab"));
    }
}
//https://leetcode.com/problems/palindrome-partitioning/
//131. Palindrome Partitioning