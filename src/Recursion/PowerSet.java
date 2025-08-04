package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerSet {

    public List<String> AllPossibleStrings(String s) {
        // Code here
        List<String> a = new ArrayList<>();
        possibleString(s,a,"",0);
        Collections.sort(a);
        return a;
    }

    private void possibleString(String s , List<String>a , String cur, int index){
        int n = s.length();
        if(index >= n){
            a.add(cur);
            return;
        }
        possibleString(s,a,cur+s.charAt(index),index+1);
        possibleString(s,a,cur,index+1);
    }

    public static void main(String[] args) {
        String s = "abc";
        PowerSet ps = new PowerSet();
        List<String> a = ps.AllPossibleStrings(s);
        for(String s1 : a){
            System.out.print(s1+" ");
        }
    }
}

// Time Complexity : O(2^n)
// Space Complexity : O(n)
//https://www.geeksforgeeks.org/problems/power-set4302/1
