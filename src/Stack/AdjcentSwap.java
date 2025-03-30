package Stack;

public class AdjcentSwap {
    public int SwapCount(String s){
        int n = s.length();
        int open = 0;
        int close = 0;
        int unbalanced = 0;
        int swap = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='['){
                open++;
                if(unbalanced>0){
                    swap+=unbalanced;
                    unbalanced--;
                }
            }else{
                close++;
                unbalanced = (close-open);
            }
        }
        return swap;
    }
    public static void main(String[] args) {
        AdjcentSwap ob  = new AdjcentSwap();
        System.out.println(ob.SwapCount("[]][]["));
    }
}


//Minimum Swaps for Bracket Balancing
//You are given a string s of 2*n characters consisting of n ‘[‘ brackets and n ‘]’ brackets. A string is considered balanced if it can be represented in the form a[b] where a and b are balanced strings. We can make an unbalanced string balanced by swapping adjacent characters. Calculate the minimum number of swaps necessary to make a string balanced.
//Note - Strings a and b can be empty.
//
//        Examples :
//
//Input: s = "[]][]["
//Output: 2
//Explanation: First swap: Position 3 and 4 [][]][, Second swap: Position 5 and 6 [][][]