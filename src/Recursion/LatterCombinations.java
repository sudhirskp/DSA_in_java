package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LatterCombinations {
        public List<String> letterCombinations(String digits) {
            HashMap<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");

            List<String> res = new ArrayList<>();
            Combinations(digits, res, 0, map);
            return res;
        }

        String cur="";

        private void Combinations(String digits, List<String> res, int index, HashMap<Character, String> map) {
            if (index == digits.length()){
                if(cur!=""){
                    res.add(cur);
                }
                return;
            }

            String currentStr = map.get(digits.charAt(index));
            for (int i = 0; i < currentStr.length(); i++) {
                cur += currentStr.charAt(i);
                Combinations(digits, res, index + 1, map);
                cur = cur.substring(0, cur.length() - 1);
            }
        }

    public static void main(String[] args) {
        String digits = "23";
        LatterCombinations obj = new LatterCombinations();
        System.out.println(obj.letterCombinations(digits));
    }
}
