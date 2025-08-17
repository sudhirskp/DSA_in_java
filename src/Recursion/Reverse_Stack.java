package Recursion;

import java.util.Stack;

public class Reverse_Stack {


        static void reverse(Stack<Integer> st) {
            // code here
            if(st.size()==0){
                return;
            }
            int ele = st.pop();
            reverse(st);
            insertAtbottom(st,ele);
        }

        static void insertAtbottom(Stack<Integer> s, int ele){
            if(s.isEmpty()){
                s.push(ele);
                return;
            }
            int el = s.pop();
            insertAtbottom(s,ele);
            s.push(el);
        }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(6);
        st.push(4);
        st.push(0);

        reverse(st);

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }

    }
}
