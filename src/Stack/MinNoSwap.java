package Stack;

import java.util.Stack;

public class MinNoSwap {

    //1st approach
    public int SwapCount(String s){
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        char ch [] = s.toCharArray();
        for(int i=0;i<n;i++){
            if(ch[i]=='['){
                stk.push(ch[i]);
            } else if (stk.isEmpty() || stk.peek()==']') {
                stk.push(ch[i]);
            }else{
                stk.pop();
            }
        }
        int opclose = stk.size()/2;
        return (opclose+1)/2;
    }

    //2nd approach
    public int SwapCount2(String s){
        int n = s.length();
        int open = 0;
        int close = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='['){
                open++;
            } else if (open<=0) {
                close++;
            }else{
                open--;
            }
        }
        return (open+1)/2;
    }
    public static void main(String[] args) {
        String s = "]]][[[";
        MinNoSwap ob = new MinNoSwap();
        System.out.println(ob.SwapCount(s));
        //System.out.println(ob.SwapCount2(s));
    }
}
