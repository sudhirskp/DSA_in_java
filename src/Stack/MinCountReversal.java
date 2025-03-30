package Stack;

import java.util.Stack;

public class MinCountReversal {

    //1st approach
    public int MinCount(String s){
        int n = s.length();
        if(n%2!=0) return -1;
        Stack<Character> stk = new Stack<Character>();
        char ch [] = s.toCharArray();
        for(int i=0;i<n;i++){
            if(ch[i]=='{'){
                stk.push(ch[i]);
            } else if (stk.isEmpty() || stk.peek()=='}') {
                stk.push(ch[i]);
            }else{
                    stk.pop();
            }
        }
        int ans =0 , open =0,close =0;
        while (!stk.isEmpty()){
            char top = stk.pop();
            if(top=='{'){
                open++;
            }else{
                close++;
            }
        }
        ans = (int)(Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans;
    }

    //2nd approach
    public int countMinReversals(String s) {
        // code here
        int n = s.length();
        if(n%2!=0) return -1;
        int ans =0 , open =0,close =0;
        char ch [] = s.toCharArray();
        for(int i=0;i<n;i++){
            if(ch[i]=='{'){
                open++;
            } else if (open<=0) {
                close++;
            }else{
                open--;
            }
        }

        ans = (int)(Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans;
    }
    public static void main(String[] args) {
        String s = "}{{}}{{{";
        //String s = "{{}{{{}{{}}{{";
        MinCountReversal ob = new MinCountReversal();
        //System.out.println(ob.MinCount(s));
        System.out.println(ob.countMinReversals(s));
    }
}
