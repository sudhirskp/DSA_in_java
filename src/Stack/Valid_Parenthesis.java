package Stack;

import java.util.Stack;

public class Valid_Parenthesis {
    public boolean isvalid(String s){
        int n  = s.length();
        if(n%2!=0) return false;
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stk.push(s.charAt(i));
            }else{
                if(stk.isEmpty()) return false;
                if(s.charAt(i)==')' && stk.peek()!='(' || s.charAt(i)=='}' && stk.peek()!='{' || s.charAt(i)==']' && stk.peek()!='['){
                    return false;
                }else{
                    stk.pop();

                }
            }
        }
        return stk.isEmpty();
    }
    public static void main(String[] args) {
        Valid_Parenthesis ob = new Valid_Parenthesis();
        String s = "([}}])";
        boolean ans = ob.isvalid(s);
        System.out.println(ans);

    }
}
