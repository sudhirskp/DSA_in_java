package Other;

import java.util.*;

public class ReversQ {
    public void revers(int k, Queue<Integer> queue) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <k; i++) {
            st.push(queue.remove());

        }
        for (int i = 0; i <k; i++) {
            queue.offer(st.pop());
        }
        int count = queue.size() - k;
        for (int i = 0; i < count; i++) {
            queue.offer(queue.remove());
        }

    }

    public static void main(String[] args) {
        ReversQ ob = new ReversQ();
       Queue<Integer> q= new LinkedList<>();
       q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        q.offer(60);
        q.offer(70);

        ob.revers(3,q);
        // Print the reversed queue
        while (!q.isEmpty()) {
            System.out.print(" "+q.poll());
        }
    }
}