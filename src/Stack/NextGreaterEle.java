package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterEle {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while the stack is not empty
            // and the top of the stack is less than or equal to the current element
            while (!stk.isEmpty() && stk.peek() <= arr[i]) {
                stk.pop();
            }
            // If stack is empty, no greater element exists; add -1
            if (stk.isEmpty()) {
                list.add(-1);
            }else{
                // The next greater element is at the top of the stack
                list.add(stk.peek());
            }
            // Push the current element into the stack
            stk.push(arr[i]);
        }
        // Reverse the list to match the order of the input array
        Collections.reverse(list);

        return list;
    }

    public static void main(String[] args) {
        NextGreaterEle obj = new NextGreaterEle();
        int[] arr = {4, 5, 2, 10, 8};
        ArrayList<Integer> result = obj.nextLargerElement(arr);
        System.out.println("Next Larger Elements: " + result);
    }
}
