package Grind75;

import java.util.Stack;

public class ReversePolish {
        public int evalRPN(String[] tokens) {
            Stack<Integer> st = new Stack<>();

            for (String token : tokens) {
                if (token.equals("+")) {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a + b);
                } else if (token.equals("-")) {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a - b);
                } else if (token.equals("*")) {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a * b);
                } else if (token.equals("/")) {
                    int b = st.pop();
                    int a = st.pop();
                    st.push(a / b);
                } else {
                    st.push(Integer.parseInt(token));
                }
            }

            return st.pop();
        }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        ReversePolish ob = new ReversePolish();
        System.out.println(ob.evalRPN(tokens)); // Output: 9
    }
}


//150. Evaluate Reverse Polish Notation
//Solved
//        Medium
//Topics
//        Companies
//You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//
//Evaluate the expression. Return an integer that represents the value of the expression.
//
//Note that:
//
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.
//
//
//Example 1:
//
//Input: tokens = ["2","1","+","3","*"]
//Output: 9
//Explanation: ((2 + 1) * 3) = 9
