package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class LongestValidParenthesis {

    //1st approach------brute-force-------------------------------------------------------------

    public void removeValidParenthesis(String s, Stack<Integer> stk) {
        int n = s.length();
        char[] pr = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (pr[i] == '(') {
                stk.push(i);
            } else if (pr[i] == ')') {
                if (stk.isEmpty() || pr[stk.peek()] == ')') {
                    stk.push(i);
                } else {
                    stk.pop();
                }
            }
        }
    }

    public int longestValidParentheses(String s) {
        int n = s.length();
        char[] pr = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        removeValidParenthesis(s , stk);

        if(stk.isEmpty()) return s.length();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(0,s.length());
        while (!stk.isEmpty()) {
            al.add(0,stk.pop());
        }
        al.add(0, -1);

        int ans = 0;
        for (int i = 1; i < al.size(); i++) {
            int diff = (al.get(i) - al.get(i-1)-1);
            if (diff > ans) {
                ans = diff;
            }
        }
        return ans;
    }
//2nd approach----------good-----------------------------------------------------------
public int longestValidParentheses1(String s) {
    int n = s.length();
    char[] pr = s.toCharArray();
    Stack<Integer> stk = new Stack<>();
    stk.push(-1);
    int max =0;
    for(int i=0;i<n;i++){
        if(pr[i]=='('){
            stk.push(i);
        }else {
            stk.pop();
            if(stk.isEmpty()){
                stk.push(i);
            }else{
                max = Math.max(max, i - stk.peek());
            }
        }
    }
    return max;
}

//3rd approach-----------------best-------------------------------------------------------
    //by using costume stack - 100% faster
public int longestValidParentheses2(String s) {
    int n = s.length();
    char[] pr = s.toCharArray();
    int stk [] = new int [n+1];
    int index =-1;
    stk[++index] = -1;
    int max =0;
    for(int i=0;i<n;i++){
        if(pr[i]=='('){
            stk[++index] =i;
        }else {
            index--;
            if(index==-1){
                stk[++index]=i;
            }else{
                max = Math.max(max, i - stk[index]);
            }
        }
    }
    return max;
}



    public static void main(String[] args) {
        LongestValidParenthesis ob = new LongestValidParenthesis();
        String s = "(()";
        int ans = ob.longestValidParentheses(s);
        //System.out.println(ans);
        //System.out.println(ob.longestValidParentheses1(s));
        System.out.println(ob.longestValidParentheses2(s));
    }
}


//32. Longest Valid Parentheses
//Hard
//Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
//
//Example 1:
//
//Input: s = "(()"
//Output: 2
//Explanation: The longest valid parentheses substring is "()".