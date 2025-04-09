package basic_of_java;

import java.util.Stack;

public class stringSpace {
    public boolean backspaceCompare(String s, String t) {
        char [] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        StringBuilder sb1  = new StringBuilder();
        StringBuilder sb2  = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<ch1.length;i++){
            if(ch1[i]=='#'){
                st.pop();
            }else{
                st.push(ch1[i]);

            }
        }
        while(!st.isEmpty()){
            sb1.append(st.pop());
        }

        for(int i=0;i<ch2.length;i++){
            if(ch2[i]=='#'){
                st.pop();
            }else{
                st.push(ch2[i]);
            }
        }
        while(!st.isEmpty()){
            sb2.append(st.pop());
        }
        return sb1.toString().equals(sb2.toString());
    }
    public static void main(String[] args) {
        String s = "xywrrmp";
        String t = "xywrrmu#p";
        stringSpace obj = new stringSpace();
        System.out.println(obj.backspaceCompare(s,t));
    }
}
